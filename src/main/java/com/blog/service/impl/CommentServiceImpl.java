/*  1:   */ package com.blog.service.impl;
/*  2:   */ 
/*  3:   */ import com.blog.dao.CommentDao;
/*  4:   */ import com.blog.entity.Comment;
/*  5:   */ import com.blog.service.CommentService;
/*  6:   */ import java.util.List;
/*  7:   */ import java.util.Map;
/*  8:   */ import javax.annotation.Resource;
/*  9:   */ import org.springframework.stereotype.Service;
/* 10:   */ 
/* 11:   */ @Service("commentService")
/* 12:   */ public class CommentServiceImpl
/* 13:   */   implements CommentService
/* 14:   */ {
/* 15:   */   @Resource
/* 16:   */   private CommentDao commentDao;
/* 17:   */   
/* 18:   */   public int add(Comment comment)
/* 19:   */   {
/* 20:26 */     return this.commentDao.add(comment);
/* 21:   */   }
/* 22:   */   
/* 23:   */   public List<Comment> list(Map<String, Object> map)
/* 24:   */   {
/* 25:30 */     return this.commentDao.list(map);
/* 26:   */   }
/* 27:   */   
/* 28:   */   public Long getTotal(Map<String, Object> map)
/* 29:   */   {
/* 30:34 */     return this.commentDao.getTotal(map);
/* 31:   */   }
/* 32:   */   
/* 33:   */   public Integer delete(Integer id)
/* 34:   */   {
/* 35:38 */     return this.commentDao.delete(id);
/* 36:   */   }
/* 37:   */   
/* 38:   */   public int update(Comment comment)
/* 39:   */   {
/* 40:42 */     return this.commentDao.update(comment);
/* 41:   */   }
/* 42:   */ }


/* Location:           D:\classes\
 * Qualified Name:     com.blog.service.impl.CommentServiceImpl
 * JD-Core Version:    0.7.0.1
 */