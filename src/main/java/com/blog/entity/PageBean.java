/*  1:   */ package com.blog.entity;
/*  2:   */ 
/*  3:   */ public class PageBean
/*  4:   */ {
/*  5:   */   private int page;
/*  6:   */   private int pageSize;
/*  7:   */   private int start;
/*  8:   */   
/*  9:   */   public PageBean(int page, int pageSize)
/* 10:   */   {
/* 11:17 */     this.page = page;
/* 12:18 */     this.pageSize = pageSize;
/* 13:   */   }
/* 14:   */   
/* 15:   */   public int getPage()
/* 16:   */   {
/* 17:22 */     return this.page;
/* 18:   */   }
/* 19:   */   
/* 20:   */   public void setPage(int page)
/* 21:   */   {
/* 22:25 */     this.page = page;
/* 23:   */   }
/* 24:   */   
/* 25:   */   public int getPageSize()
/* 26:   */   {
/* 27:29 */     return this.pageSize;
/* 28:   */   }
/* 29:   */   
/* 30:   */   public void setPageSize(int pageSize)
/* 31:   */   {
/* 32:33 */     this.pageSize = pageSize;
/* 33:   */   }
/* 34:   */   
/* 35:   */   public int getStart()
/* 36:   */   {
/* 37:37 */     return (this.page - 1) * this.pageSize;
/* 38:   */   }
/* 39:   */ }


/* Location:           D:\classes\
 * Qualified Name:     com.blog.entity.PageBean
 * JD-Core Version:    0.7.0.1
 */