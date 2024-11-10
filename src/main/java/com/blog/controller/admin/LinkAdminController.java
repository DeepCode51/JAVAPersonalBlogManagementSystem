/*  1:   */ package com.blog.controller.admin;
/*  2:   */ 
/*  3:   */ import com.blog.entity.Link;
/*  4:   */ import com.blog.entity.PageBean;
/*  5:   */ import com.blog.service.LinkService;
/*  6:   */ import com.blog.util.ResponseUtil;
/*  7:   */ import java.util.HashMap;
/*  8:   */ import java.util.List;
/*  9:   */ import java.util.Map;
/* 10:   */ import javax.annotation.Resource;
/* 11:   */ import javax.servlet.http.HttpServletResponse;
/* 12:   */ import net.sf.json.JSONArray;
/* 13:   */ import net.sf.json.JSONObject;
/* 14:   */ import org.springframework.stereotype.Controller;
/* 15:   */ import org.springframework.web.bind.annotation.RequestMapping;
/* 16:   */ import org.springframework.web.bind.annotation.RequestParam;
/* 17:   */ 
/* 18:   */ @Controller
/* 19:   */ @RequestMapping({"/admin/link"})
/* 20:   */ public class LinkAdminController
/* 21:   */ {
/* 22:   */   @Resource
/* 23:   */   private LinkService linkService;
/* 24:   */   
/* 25:   */   @RequestMapping({"/list"})
/* 26:   */   public String list(@RequestParam(value="page", required=false) String page, @RequestParam(value="rows", required=false) String rows, HttpServletResponse response)
/* 27:   */     throws Exception
/* 28:   */   {
/* 29:44 */     PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(rows));
/* 30:45 */     Map<String, Object> map = new HashMap();
/* 31:46 */     map.put("start", Integer.valueOf(pageBean.getStart()));
/* 32:47 */     map.put("size", Integer.valueOf(pageBean.getPageSize()));
/* 33:48 */     List<Link> linkList = this.linkService.list(map);
/* 34:49 */     Long total = this.linkService.getTotal(map);
/* 35:50 */     JSONObject result = new JSONObject();
/* 36:51 */     JSONArray jsonArray = JSONArray.fromObject(linkList);
/* 37:52 */     result.put("rows", jsonArray);
/* 38:53 */     result.put("total", total);
/* 39:54 */     ResponseUtil.write(response, result);
/* 40:55 */     return null;
/* 41:   */   }
/* 42:   */   
/* 43:   */   @RequestMapping({"/save"})
/* 44:   */   public String save(Link link, HttpServletResponse response)
/* 45:   */     throws Exception
/* 46:   */   {
/* 47:67 */     int resultTotal = 0;
/* 48:68 */     if (link.getId() == null) {
/* 49:69 */       resultTotal = this.linkService.add(link);
/* 50:   */     } else {
/* 51:71 */       resultTotal = this.linkService.update(link);
/* 52:   */     }
/* 53:73 */     JSONObject result = new JSONObject();
/* 54:74 */     if (resultTotal > 0) {
/* 55:75 */       result.put("success", Boolean.valueOf(true));
/* 56:   */     } else {
/* 57:77 */       result.put("success", Boolean.valueOf(false));
/* 58:   */     }
/* 59:79 */     ResponseUtil.write(response, result);
/* 60:80 */     return null;
/* 61:   */   }
/* 62:   */   
/* 63:   */   @RequestMapping({"/delete"})
/* 64:   */   public String delete(@RequestParam("ids") String ids, HttpServletResponse response)
/* 65:   */     throws Exception
/* 66:   */   {
/* 67:92 */     String[] idsStr = ids.split(",");
/* 68:93 */     for (int i = 0; i < idsStr.length; i++) {
/* 69:94 */       this.linkService.delete(Integer.valueOf(Integer.parseInt(idsStr[i])));
/* 70:   */     }
/* 71:96 */     JSONObject result = new JSONObject();
/* 72:97 */     result.put("success", Boolean.valueOf(true));
/* 73:98 */     ResponseUtil.write(response, result);
/* 74:99 */     return null;
/* 75:   */   }
/* 76:   */ }


/* Location:           D:\classes\
 * Qualified Name:     com.blog.controller.admin.LinkAdminController
 * JD-Core Version:    0.7.0.1
 */