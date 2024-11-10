/*  1:   */ package com.blog.controller;
/*  2:   */ 
/*  3:   */ import com.blog.entity.Blog;
/*  4:   */ import com.blog.entity.PageBean;
/*  5:   */ import com.blog.service.BlogService;
/*  6:   */ import com.blog.util.PageUtil;
/*  7:   */ import com.blog.util.StringUtil;
/*  8:   */ import java.util.HashMap;
/*  9:   */ import java.util.List;
/* 10:   */ import java.util.Map;
/* 11:   */ import javax.annotation.Resource;
/* 12:   */ import javax.servlet.http.HttpServletRequest;
/* 13:   */ import org.jsoup.Jsoup;
/* 14:   */ import org.jsoup.nodes.Document;
/* 15:   */ import org.jsoup.nodes.Element;
/* 16:   */ import org.jsoup.select.Elements;
/* 17:   */ import org.springframework.stereotype.Controller;
/* 18:   */ import org.springframework.web.bind.annotation.RequestMapping;
/* 19:   */ import org.springframework.web.bind.annotation.RequestParam;
/* 20:   */ import org.springframework.web.servlet.ModelAndView;
/* 21:   */ 
/* 22:   */ @Controller
/* 23:   */ @RequestMapping({"/"})
/* 24:   */ public class IndexController
/* 25:   */ {
/* 26:   */   @Resource
/* 27:   */   private BlogService blogService;
/* 28:   */   
/* 29:   */   @RequestMapping({"/index"})
/* 30:   */   public ModelAndView index(@RequestParam(value="page", required=false) String page, @RequestParam(value="typeId", required=false) String typeId, @RequestParam(value="releaseDateStr", required=false) String releaseDateStr, HttpServletRequest request)
/* 31:   */     throws Exception
/* 32:   */   {
/* 33:45 */     ModelAndView mav = new ModelAndView();
/* 34:46 */     if (StringUtil.isEmpty(page)) {
/* 35:47 */       page = "1";
/* 36:   */     }
/* 37:49 */     PageBean pageBean = new PageBean(Integer.parseInt(page), 10);
/* 38:50 */     Map<String, Object> map = new HashMap();
/* 39:51 */     map.put("start", Integer.valueOf(pageBean.getStart()));
/* 40:52 */     map.put("size", Integer.valueOf(pageBean.getPageSize()));
/* 41:53 */     map.put("typeId", typeId);
/* 42:54 */     map.put("releaseDateStr", releaseDateStr);
/* 43:55 */     List<Blog> blogList = this.blogService.list(map);
/* 44:56 */     for (Blog blog : blogList)
/* 45:   */     {
/* 46:57 */       List<String> imagesList = blog.getImagesList();
/* 47:58 */       String blogInfo = blog.getContent();
/* 48:59 */       Document doc = Jsoup.parse(blogInfo);
/* 49:60 */       Elements jpgs = doc.select("img[src$=.jpg]");
/* 50:61 */       for (int i = 0; i < jpgs.size(); i++)
/* 51:   */       {
/* 52:62 */         Element jpg = (Element)jpgs.get(i);
/* 53:63 */         imagesList.add(jpg.toString());
/* 54:64 */         if (i == 2) {
/* 55:   */           break;
/* 56:   */         }
/* 57:   */       }
/* 58:   */     }
/* 59:69 */     mav.addObject("blogList", blogList);
/* 60:70 */     StringBuffer param = new StringBuffer();
/* 61:71 */     if (StringUtil.isNotEmpty(typeId)) {
/* 62:72 */       param.append("typeId=" + typeId + "&");
/* 63:   */     }
/* 64:74 */     if (StringUtil.isNotEmpty(releaseDateStr)) {
/* 65:75 */       param.append("releaseDateStr=" + releaseDateStr + "&");
/* 66:   */     }
/* 67:77 */     mav.addObject("pageCode", PageUtil.genPagination(request.getContextPath() + "/index.html", this.blogService.getTotal(map).longValue(), Integer.parseInt(page), 10, param.toString()));
/* 68:78 */     mav.addObject("mainPage", "foreground/blog/list.jsp");
/* 69:79 */     mav.addObject("pageTitle", "Java个人博客系统");
/* 70:80 */     mav.setViewName("mainTemp");
/* 71:81 */     return mav;
/* 72:   */   }
/* 73:   */   
/* 74:   */   @RequestMapping({"/download"})
/* 75:   */   public ModelAndView download()
/* 76:   */     throws Exception
/* 77:   */   {
/* 78:91 */     ModelAndView mav = new ModelAndView();
/* 79:92 */     mav.addObject("mainPage", "foreground/system/download.jsp");
/* 80:93 */     mav.addObject("pageTitle", "本站源码下载页面_Java开源博客系统");
/* 81:94 */     mav.setViewName("mainTemp");
/* 82:95 */     return mav;
/* 83:   */   }
/* 84:   */ }


/* Location:           D:\classes\
 * Qualified Name:     com.blog.controller.IndexController
 * JD-Core Version:    0.7.0.1
 */