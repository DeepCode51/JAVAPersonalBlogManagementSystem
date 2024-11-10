/*  1:   */ package com.blog.service.impl;
/*  2:   */ 
/*  3:   */ import com.blog.dao.BloggerDao;
/*  4:   */ import com.blog.entity.Blogger;
/*  5:   */ import com.blog.service.BloggerService;
/*  6:   */ import javax.annotation.Resource;
/*  7:   */ import org.springframework.stereotype.Service;
/*  8:   */ 
/*  9:   */ @Service("bloggerService")
/* 10:   */ public class BloggerServiceImpl
/* 11:   */   implements BloggerService
/* 12:   */ {
/* 13:   */   @Resource
/* 14:   */   private BloggerDao bloggerDao;
/* 15:   */   
/* 16:   */   public Blogger find()
/* 17:   */   {
/* 18:23 */     return this.bloggerDao.find();
/* 19:   */   }
/* 20:   */   
/* 21:   */   public Blogger getByUserName(String userName)
/* 22:   */   {
/* 23:27 */     return this.bloggerDao.getByUserName(userName);
/* 24:   */   }
/* 25:   */   
/* 26:   */   public Integer update(Blogger blogger)
/* 27:   */   {
/* 28:31 */     return this.bloggerDao.update(blogger);
/* 29:   */   }
/* 30:   */ }


/* Location:           D:\classes\
 * Qualified Name:     com.blog.service.impl.BloggerServiceImpl
 * JD-Core Version:    0.7.0.1
 */