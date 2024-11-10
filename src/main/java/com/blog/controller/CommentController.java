/*  1:   */ package com.blog.controller;
/*  2:   */ 
/*  3:   */ import com.blog.entity.Blog;
/*  4:   */ import com.blog.entity.Comment;
/*  5:   */ import com.blog.service.BlogService;
/*  6:   */ import com.blog.service.CommentService;
/*  7:   */ import com.blog.util.ResponseUtil;
/*  8:   */ import javax.annotation.Resource;
/*  9:   */ import javax.servlet.http.HttpServletRequest;
/* 10:   */ import javax.servlet.http.HttpServletResponse;
/* 11:   */ import javax.servlet.http.HttpSession;
/* 12:   */ import net.sf.json.JSONObject;
/* 13:   */ import org.springframework.stereotype.Controller;
/* 14:   */ import org.springframework.web.bind.annotation.RequestMapping;
/* 15:   */ import org.springframework.web.bind.annotation.RequestParam;
/* 16:   */ 
/* 17:   */ @Controller
/* 18:   */ @RequestMapping({"/comment"})
/* 19:   */ public class CommentController
/* 20:   */ {
/* 21:   */   @Resource
/* 22:   */   private CommentService commentService;
/* 23:   */   @Resource
/* 24:   */   private BlogService blogService;
/* 25:   */   
/* 26:   */   @RequestMapping({"/save"})
/* 27:   */   public String save(Comment comment, @RequestParam("imageCode") String imageCode, HttpServletRequest request, HttpServletResponse response, HttpSession session)
/* 28:   */     throws Exception
/* 29:   */   {
/* 30:45 */     String sRand = (String)session.getAttribute("sRand");
/* 31:46 */     JSONObject result = new JSONObject();
/* 32:47 */     int resultTotal = 0;
/* 33:48 */     if (!imageCode.equals(sRand))
/* 34:   */     {
/* 35:49 */       result.put("success", Boolean.valueOf(false));
/* 36:50 */       result.put("errorInfo", "验证码填写错误！");
/* 37:   */     }
/* 38:   */     else
/* 39:   */     {
/* 40:52 */       String userIp = request.getRemoteAddr();
/* 41:53 */       comment.setUserIp(userIp);
/* 42:54 */       if (comment.getId() == null)
/* 43:   */       {
/* 44:55 */         resultTotal = this.commentService.add(comment);
/* 45:   */         
/* 46:57 */         Blog blog = this.blogService.findById(comment.getBlog().getId());
/* 47:58 */         blog.setReplyHit(Integer.valueOf(blog.getReplyHit().intValue() + 1));
/* 48:59 */         this.blogService.update(blog);
/* 49:   */       }
/* 50:63 */       if (resultTotal > 0) {
/* 51:64 */         result.put("success", Boolean.valueOf(true));
/* 52:   */       } else {
/* 53:66 */         result.put("success", Boolean.valueOf(false));
/* 54:   */       }
/* 55:   */     }
/* 56:69 */     ResponseUtil.write(response, result);
/* 57:70 */     return null;
/* 58:   */   }
/* 59:   */ }


/* Location:           D:\classes\
 * Qualified Name:     com.blog.controller.CommentController
 * JD-Core Version:    0.7.0.1
 */