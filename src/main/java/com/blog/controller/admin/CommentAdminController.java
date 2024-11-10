/*   1:    */ package com.blog.controller.admin;
/*   2:    */ 
/*   3:    */ import com.blog.entity.Comment;
/*   4:    */ import com.blog.entity.PageBean;
/*   5:    */ import com.blog.service.CommentService;
/*   6:    */ import com.blog.util.ResponseUtil;
/*   7:    */ import java.util.Date;
/*   8:    */ import java.util.HashMap;
/*   9:    */ import java.util.List;
/*  10:    */ import java.util.Map;
/*  11:    */ import javax.annotation.Resource;
/*  12:    */ import javax.servlet.http.HttpServletResponse;
/*  13:    */ import net.sf.json.JSONArray;
/*  14:    */ import net.sf.json.JSONObject;
/*  15:    */ import net.sf.json.JsonConfig;
/*  16:    */ import org.springframework.stereotype.Controller;
/*  17:    */ import org.springframework.web.bind.annotation.RequestMapping;
/*  18:    */ import org.springframework.web.bind.annotation.RequestParam;
/*  19:    */ 
/*  20:    */ @Controller
/*  21:    */ @RequestMapping({"/admin/comment"})
/*  22:    */ public class CommentAdminController
/*  23:    */ {
/*  24:    */   @Resource
/*  25:    */   private CommentService commentService;
/*  26:    */   
/*  27:    */   @RequestMapping({"/list"})
/*  28:    */   public String list(@RequestParam(value="page", required=false) String page, @RequestParam(value="rows", required=false) String rows, @RequestParam(value="state", required=false) String state, HttpServletResponse response)
/*  29:    */     throws Exception
/*  30:    */   {
/*  31: 45 */     PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(rows));
/*  32: 46 */     Map<String, Object> map = new HashMap();
/*  33: 47 */     map.put("start", Integer.valueOf(pageBean.getStart()));
/*  34: 48 */     map.put("size", Integer.valueOf(pageBean.getPageSize()));
/*  35: 49 */     map.put("state", state);
/*  36: 50 */     List<Comment> commentList = this.commentService.list(map);
/*  37: 51 */     Long total = this.commentService.getTotal(map);
/*  38: 52 */     JSONObject result = new JSONObject();
/*  39: 53 */     JsonConfig jsonConfig = new JsonConfig();
/*  40: 54 */     jsonConfig.registerJsonValueProcessor(Date.class, new DateJsonValueProcessor("yyyy-MM-dd"));
/*  41: 55 */     JSONArray jsonArray = JSONArray.fromObject(commentList, jsonConfig);
/*  42: 56 */     result.put("rows", jsonArray);
/*  43: 57 */     result.put("total", total);
/*  44: 58 */     ResponseUtil.write(response, result);
/*  45: 59 */     return null;
/*  46:    */   }
/*  47:    */   
/*  48:    */   @RequestMapping({"/delete"})
/*  49:    */   public String delete(@RequestParam("ids") String ids, HttpServletResponse response)
/*  50:    */     throws Exception
/*  51:    */   {
/*  52: 71 */     String[] idsStr = ids.split(",");
/*  53: 72 */     for (int i = 0; i < idsStr.length; i++) {
/*  54: 73 */       this.commentService.delete(Integer.valueOf(Integer.parseInt(idsStr[i])));
/*  55:    */     }
/*  56: 75 */     JSONObject result = new JSONObject();
/*  57: 76 */     result.put("success", Boolean.valueOf(true));
/*  58: 77 */     ResponseUtil.write(response, result);
/*  59: 78 */     return null;
/*  60:    */   }
/*  61:    */   
/*  62:    */   @RequestMapping({"/review"})
/*  63:    */   public String review(@RequestParam("ids") String ids, @RequestParam("state") Integer state, HttpServletResponse response)
/*  64:    */     throws Exception
/*  65:    */   {
/*  66: 90 */     String[] idsStr = ids.split(",");
/*  67: 91 */     for (int i = 0; i < idsStr.length; i++)
/*  68:    */     {
/*  69: 92 */       Comment comment = new Comment();
/*  70: 93 */       comment.setState(state);
/*  71: 94 */       comment.setId(Integer.valueOf(Integer.parseInt(idsStr[i])));
/*  72: 95 */       this.commentService.update(comment);
/*  73:    */     }
/*  74: 97 */     JSONObject result = new JSONObject();
/*  75: 98 */     result.put("success", Boolean.valueOf(true));
/*  76: 99 */     ResponseUtil.write(response, result);
/*  77:100 */     return null;
/*  78:    */   }
/*  79:    */ }


/* Location:           D:\classes\
 * Qualified Name:     com.blog.controller.admin.CommentAdminController
 * JD-Core Version:    0.7.0.1
 */