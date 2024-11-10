/*  1:   */ package com.blog.entity;
/*  2:   */ 
/*  3:   */ import java.util.Date;
/*  4:   */ 
/*  5:   */ public class Comment
/*  6:   */ {
/*  7:   */   private Integer id;
/*  8:   */   private String userIp;
/*  9:   */   private String content;
/* 10:   */   private Blog blog;
/* 11:   */   private Date commentDate;
/* 12:   */   private Integer state;
/* 13:   */   
/* 14:   */   public Integer getId()
/* 15:   */   {
/* 16:20 */     return this.id;
/* 17:   */   }
/* 18:   */   
/* 19:   */   public void setId(Integer id)
/* 20:   */   {
/* 21:23 */     this.id = id;
/* 22:   */   }
/* 23:   */   
/* 24:   */   public String getUserIp()
/* 25:   */   {
/* 26:26 */     return this.userIp;
/* 27:   */   }
/* 28:   */   
/* 29:   */   public void setUserIp(String userIp)
/* 30:   */   {
/* 31:29 */     this.userIp = userIp;
/* 32:   */   }
/* 33:   */   
/* 34:   */   public String getContent()
/* 35:   */   {
/* 36:32 */     return this.content;
/* 37:   */   }
/* 38:   */   
/* 39:   */   public void setContent(String content)
/* 40:   */   {
/* 41:35 */     this.content = content;
/* 42:   */   }
/* 43:   */   
/* 44:   */   public Blog getBlog()
/* 45:   */   {
/* 46:38 */     return this.blog;
/* 47:   */   }
/* 48:   */   
/* 49:   */   public void setBlog(Blog blog)
/* 50:   */   {
/* 51:41 */     this.blog = blog;
/* 52:   */   }
/* 53:   */   
/* 54:   */   public Date getCommentDate()
/* 55:   */   {
/* 56:44 */     return this.commentDate;
/* 57:   */   }
/* 58:   */   
/* 59:   */   public void setCommentDate(Date commentDate)
/* 60:   */   {
/* 61:47 */     this.commentDate = commentDate;
/* 62:   */   }
/* 63:   */   
/* 64:   */   public Integer getState()
/* 65:   */   {
/* 66:50 */     return this.state;
/* 67:   */   }
/* 68:   */   
/* 69:   */   public void setState(Integer state)
/* 70:   */   {
/* 71:53 */     this.state = state;
/* 72:   */   }
/* 73:   */ }


/* Location:           D:\classes\
 * Qualified Name:     com.blog.entity.Comment
 * JD-Core Version:    0.7.0.1
 */