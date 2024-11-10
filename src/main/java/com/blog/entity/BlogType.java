/*  1:   */ package com.blog.entity;
/*  2:   */ 
/*  3:   */ import java.io.Serializable;
/*  4:   */ 
/*  5:   */ public class BlogType
/*  6:   */   implements Serializable
/*  7:   */ {
/*  8:   */   private static final long serialVersionUID = 1L;
/*  9:   */   private Integer id;
/* 10:   */   private String typeName;
/* 11:   */   private Integer blogCount;
/* 12:   */   private Integer orderNo;
/* 13:   */   
/* 14:   */   public Integer getId()
/* 15:   */   {
/* 16:23 */     return this.id;
/* 17:   */   }
/* 18:   */   
/* 19:   */   public void setId(Integer id)
/* 20:   */   {
/* 21:26 */     this.id = id;
/* 22:   */   }
/* 23:   */   
/* 24:   */   public String getTypeName()
/* 25:   */   {
/* 26:29 */     return this.typeName;
/* 27:   */   }
/* 28:   */   
/* 29:   */   public void setTypeName(String typeName)
/* 30:   */   {
/* 31:32 */     this.typeName = typeName;
/* 32:   */   }
/* 33:   */   
/* 34:   */   public Integer getBlogCount()
/* 35:   */   {
/* 36:35 */     return this.blogCount;
/* 37:   */   }
/* 38:   */   
/* 39:   */   public void setBlogCount(Integer blogCount)
/* 40:   */   {
/* 41:38 */     this.blogCount = blogCount;
/* 42:   */   }
/* 43:   */   
/* 44:   */   public Integer getOrderNo()
/* 45:   */   {
/* 46:41 */     return this.orderNo;
/* 47:   */   }
/* 48:   */   
/* 49:   */   public void setOrderNo(Integer orderNo)
/* 50:   */   {
/* 51:44 */     this.orderNo = orderNo;
/* 52:   */   }
/* 53:   */ }


/* Location:           D:\classes\
 * Qualified Name:     com.blog.entity.BlogType
 * JD-Core Version:    0.7.0.1
 */