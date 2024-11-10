/*   1:    */ package com.blog.controller.admin;
/*   2:    */ 
/*   3:    */ import com.blog.entity.BlogType;
/*   4:    */ import com.blog.entity.PageBean;
/*   5:    */ import com.blog.service.BlogService;
/*   6:    */ import com.blog.service.BlogTypeService;
/*   7:    */ import com.blog.util.ResponseUtil;
/*   8:    */ import java.util.HashMap;
/*   9:    */ import java.util.List;
/*  10:    */ import java.util.Map;
/*  11:    */ import javax.annotation.Resource;
/*  12:    */ import javax.servlet.http.HttpServletResponse;
/*  13:    */ import net.sf.json.JSONArray;
/*  14:    */ import net.sf.json.JSONObject;
/*  15:    */ import org.springframework.stereotype.Controller;
/*  16:    */ import org.springframework.web.bind.annotation.RequestMapping;
/*  17:    */ import org.springframework.web.bind.annotation.RequestParam;
/*  18:    */ 
/*  19:    */ @Controller
/*  20:    */ @RequestMapping({"/admin/blogType"})
/*  21:    */ public class BlogTypeAdminController
/*  22:    */ {
/*  23:    */   @Resource
/*  24:    */   private BlogTypeService blogTypeService;
/*  25:    */   @Resource
/*  26:    */   private BlogService blogService;
/*  27:    */   
/*  28:    */   @RequestMapping({"/list"})
/*  29:    */   public String list(@RequestParam(value="page", required=false) String page, @RequestParam(value="rows", required=false) String rows, HttpServletResponse response)
/*  30:    */     throws Exception
/*  31:    */   {
/*  32: 48 */     PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(rows));
/*  33: 49 */     Map<String, Object> map = new HashMap();
/*  34: 50 */     map.put("start", Integer.valueOf(pageBean.getStart()));
/*  35: 51 */     map.put("size", Integer.valueOf(pageBean.getPageSize()));
/*  36: 52 */     List<BlogType> blogTypeList = this.blogTypeService.list(map);
/*  37: 53 */     Long total = this.blogTypeService.getTotal(map);
/*  38: 54 */     JSONObject result = new JSONObject();
/*  39: 55 */     JSONArray jsonArray = JSONArray.fromObject(blogTypeList);
/*  40: 56 */     result.put("rows", jsonArray);
/*  41: 57 */     result.put("total", total);
/*  42: 58 */     ResponseUtil.write(response, result);
/*  43: 59 */     return null;
/*  44:    */   }
/*  45:    */   
/*  46:    */   @RequestMapping({"/save"})
/*  47:    */   public String save(BlogType blogType, HttpServletResponse response)
/*  48:    */     throws Exception
/*  49:    */   {
/*  50: 71 */     int resultTotal = 0;
/*  51: 72 */     if (blogType.getId() == null) {
/*  52: 73 */       resultTotal = this.blogTypeService.add(blogType).intValue();
/*  53:    */     } else {
/*  54: 75 */       resultTotal = this.blogTypeService.update(blogType).intValue();
/*  55:    */     }
/*  56: 77 */     JSONObject result = new JSONObject();
/*  57: 78 */     if (resultTotal > 0) {
/*  58: 79 */       result.put("success", Boolean.valueOf(true));
/*  59:    */     } else {
/*  60: 81 */       result.put("success", Boolean.valueOf(false));
/*  61:    */     }
/*  62: 83 */     ResponseUtil.write(response, result);
/*  63: 84 */     return null;
/*  64:    */   }
/*  65:    */   
/*  66:    */   @RequestMapping({"/delete"})
/*  67:    */   public String delete(@RequestParam("ids") String ids, HttpServletResponse response)
/*  68:    */     throws Exception
/*  69:    */   {
/*  70: 96 */     String[] idsStr = ids.split(",");
/*  71: 97 */     JSONObject result = new JSONObject();
/*  72: 98 */     for (int i = 0; i < idsStr.length; i++) {
/*  73: 99 */       if (this.blogService.getBlogByTypeId(Integer.valueOf(Integer.parseInt(idsStr[i]))).intValue() > 0) {
/*  74:100 */         result.put("exist", "博客类别下有博客，不能删除！");
/*  75:    */       } else {
/*  76:102 */         this.blogTypeService.delete(Integer.valueOf(Integer.parseInt(idsStr[i])));
/*  77:    */       }
/*  78:    */     }
/*  79:105 */     result.put("success", Boolean.valueOf(true));
/*  80:106 */     ResponseUtil.write(response, result);
/*  81:107 */     return null;
/*  82:    */   }
/*  83:    */ }


/* Location:           D:\classes\
 * Qualified Name:     com.blog.controller.admin.BlogTypeAdminController
 * JD-Core Version:    0.7.0.1
 */