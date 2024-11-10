/*   1:    */ package com.blog.controller.admin;
/*   2:    */ 
/*   3:    */ import com.blog.entity.Blog;
/*   4:    */ import com.blog.entity.PageBean;
/*   5:    */ import com.blog.lucene.BlogIndex;
/*   6:    */ import com.blog.service.BlogService;
/*   7:    */ import com.blog.util.ResponseUtil;
/*   8:    */ import com.blog.util.StringUtil;
/*   9:    */ import java.util.Date;
/*  10:    */ import java.util.HashMap;
/*  11:    */ import java.util.List;
/*  12:    */ import java.util.Map;
/*  13:    */ import javax.annotation.Resource;
/*  14:    */ import javax.servlet.http.HttpServletResponse;
/*  15:    */ import net.sf.json.JSONArray;
/*  16:    */ import net.sf.json.JSONObject;
/*  17:    */ import net.sf.json.JsonConfig;
/*  18:    */ import org.springframework.stereotype.Controller;
/*  19:    */ import org.springframework.web.bind.annotation.RequestMapping;
/*  20:    */ import org.springframework.web.bind.annotation.RequestParam;
/*  21:    */ 
/*  22:    */ @Controller
/*  23:    */ @RequestMapping({"/admin/blog"})
/*  24:    */ public class BlogAdminController
/*  25:    */ {
/*  26:    */   @Resource
/*  27:    */   private BlogService blogService;
/*  28: 40 */   private BlogIndex blogIndex = new BlogIndex();
/*  29:    */   
/*  30:    */   @RequestMapping({"/save"})
/*  31:    */   public String save(Blog blog, HttpServletResponse response)
/*  32:    */     throws Exception
/*  33:    */   {
/*  34: 51 */     int resultTotal = 0;
/*  35: 52 */     if (blog.getId() == null)
/*  36:    */     {
/*  37: 53 */       resultTotal = this.blogService.add(blog).intValue();
/*  38: 54 */       this.blogIndex.addIndex(blog);
/*  39:    */     }
/*  40:    */     else
/*  41:    */     {
/*  42: 56 */       resultTotal = this.blogService.update(blog).intValue();
/*  43: 57 */       this.blogIndex.updateIndex(blog);
/*  44:    */     }
/*  45: 59 */     JSONObject result = new JSONObject();
/*  46: 60 */     if (resultTotal > 0) {
/*  47: 61 */       result.put("success", Boolean.valueOf(true));
/*  48:    */     } else {
/*  49: 63 */       result.put("success", Boolean.valueOf(false));
/*  50:    */     }
/*  51: 65 */     ResponseUtil.write(response, result);
/*  52: 66 */     return null;
/*  53:    */   }
/*  54:    */   
/*  55:    */   @RequestMapping({"/list"})
/*  56:    */   public String list(@RequestParam(value="page", required=false) String page, @RequestParam(value="rows", required=false) String rows, Blog s_blog, HttpServletResponse response)
/*  57:    */     throws Exception
/*  58:    */   {
/*  59: 80 */     PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(rows));
/*  60: 81 */     Map<String, Object> map = new HashMap();
/*  61: 82 */     map.put("title", StringUtil.formatLike(s_blog.getTitle()));
/*  62: 83 */     map.put("start", Integer.valueOf(pageBean.getStart()));
/*  63: 84 */     map.put("size", Integer.valueOf(pageBean.getPageSize()));
/*  64: 85 */     List<Blog> blogList = this.blogService.list(map);
/*  65: 86 */     Long total = this.blogService.getTotal(map);
/*  66: 87 */     JSONObject result = new JSONObject();
/*  67: 88 */     JsonConfig jsonConfig = new JsonConfig();
/*  68: 89 */     jsonConfig.registerJsonValueProcessor(Date.class, new DateJsonValueProcessor("yyyy-MM-dd"));
/*  69: 90 */     JSONArray jsonArray = JSONArray.fromObject(blogList, jsonConfig);
/*  70: 91 */     result.put("rows", jsonArray);
/*  71: 92 */     result.put("total", total);
/*  72: 93 */     ResponseUtil.write(response, result);
/*  73: 94 */     return null;
/*  74:    */   }
/*  75:    */   
/*  76:    */   @RequestMapping({"/delete"})
/*  77:    */   public String delete(@RequestParam("ids") String ids, HttpServletResponse response)
/*  78:    */     throws Exception
/*  79:    */   {
/*  80:106 */     String[] idsStr = ids.split(",");
/*  81:107 */     for (int i = 0; i < idsStr.length; i++)
/*  82:    */     {
/*  83:108 */       this.blogService.delete(Integer.valueOf(Integer.parseInt(idsStr[i])));
/*  84:109 */       this.blogIndex.deleteIndex(idsStr[i]);
/*  85:    */     }
/*  86:111 */     JSONObject result = new JSONObject();
/*  87:112 */     result.put("success", Boolean.valueOf(true));
/*  88:113 */     ResponseUtil.write(response, result);
/*  89:114 */     return null;
/*  90:    */   }
/*  91:    */   
/*  92:    */   @RequestMapping({"/findById"})
/*  93:    */   public String findById(@RequestParam("id") String id, HttpServletResponse response)
/*  94:    */     throws Exception
/*  95:    */   {
/*  96:126 */     Blog blog = this.blogService.findById(Integer.valueOf(Integer.parseInt(id)));
/*  97:127 */     JSONObject jsonObject = JSONObject.fromObject(blog);
/*  98:128 */     ResponseUtil.write(response, jsonObject);
/*  99:129 */     return null;
/* 100:    */   }
/* 101:    */ }


/* Location:           D:\classes\
 * Qualified Name:     com.blog.controller.admin.BlogAdminController
 * JD-Core Version:    0.7.0.1
 */