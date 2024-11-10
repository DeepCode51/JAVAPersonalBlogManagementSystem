/*  1:   */ package com.blog.service.impl;
/*  2:   */ 
/*  3:   */ import com.blog.dao.BlogTypeDao;
/*  4:   */ import com.blog.entity.BlogType;
/*  5:   */ import com.blog.service.BlogTypeService;
/*  6:   */ import java.util.List;
/*  7:   */ import java.util.Map;
/*  8:   */ import javax.annotation.Resource;
/*  9:   */ import org.springframework.stereotype.Service;
/* 10:   */ 
/* 11:   */ @Service("blogTypeService")
/* 12:   */ public class BlogTypeServiceImpl
/* 13:   */   implements BlogTypeService
/* 14:   */ {
/* 15:   */   @Resource
/* 16:   */   private BlogTypeDao blogTypeDao;
/* 17:   */   
/* 18:   */   public List<BlogType> countList()
/* 19:   */   {
/* 20:26 */     return this.blogTypeDao.countList();
/* 21:   */   }
/* 22:   */   
/* 23:   */   public List<BlogType> list(Map<String, Object> map)
/* 24:   */   {
/* 25:30 */     return this.blogTypeDao.list(map);
/* 26:   */   }
/* 27:   */   
/* 28:   */   public Long getTotal(Map<String, Object> map)
/* 29:   */   {
/* 30:34 */     return this.blogTypeDao.getTotal(map);
/* 31:   */   }
/* 32:   */   
/* 33:   */   public Integer add(BlogType blogType)
/* 34:   */   {
/* 35:38 */     return this.blogTypeDao.add(blogType);
/* 36:   */   }
/* 37:   */   
/* 38:   */   public Integer update(BlogType blogType)
/* 39:   */   {
/* 40:42 */     return this.blogTypeDao.update(blogType);
/* 41:   */   }
/* 42:   */   
/* 43:   */   public Integer delete(Integer id)
/* 44:   */   {
/* 45:46 */     return this.blogTypeDao.delete(id);
/* 46:   */   }
/* 47:   */ }


/* Location:           D:\classes\
 * Qualified Name:     com.blog.service.impl.BlogTypeServiceImpl
 * JD-Core Version:    0.7.0.1
 */