/*  1:   */ package com.blog.service.impl;
/*  2:   */ 
/*  3:   */ import com.blog.dao.BlogDao;
/*  4:   */ import com.blog.entity.Blog;
/*  5:   */ import com.blog.service.BlogService;
/*  6:   */ import java.util.List;
/*  7:   */ import java.util.Map;
/*  8:   */ import javax.annotation.Resource;
/*  9:   */ import org.springframework.stereotype.Service;
/* 10:   */ 
/* 11:   */ @Service("blogService")
/* 12:   */ public class BlogServiceImpl
/* 13:   */   implements BlogService
/* 14:   */ {
/* 15:   */   @Resource
/* 16:   */   private BlogDao blogDao;
/* 17:   */   
/* 18:   */   public List<Blog> countList()
/* 19:   */   {
/* 20:26 */     return this.blogDao.countList();
/* 21:   */   }
/* 22:   */   
/* 23:   */   public List<Blog> list(Map<String, Object> map)
/* 24:   */   {
/* 25:30 */     return this.blogDao.list(map);
/* 26:   */   }
/* 27:   */   
/* 28:   */   public Long getTotal(Map<String, Object> map)
/* 29:   */   {
/* 30:34 */     return this.blogDao.getTotal(map);
/* 31:   */   }
/* 32:   */   
/* 33:   */   public Blog findById(Integer id)
/* 34:   */   {
/* 35:38 */     return this.blogDao.findById(id);
/* 36:   */   }
/* 37:   */   
/* 38:   */   public Integer update(Blog blog)
/* 39:   */   {
/* 40:42 */     return this.blogDao.update(blog);
/* 41:   */   }
/* 42:   */   
/* 43:   */   public Blog getLastBlog(Integer id)
/* 44:   */   {
/* 45:46 */     return this.blogDao.getLastBlog(id);
/* 46:   */   }
/* 47:   */   
/* 48:   */   public Blog getNextBlog(Integer id)
/* 49:   */   {
/* 50:50 */     return this.blogDao.getNextBlog(id);
/* 51:   */   }
/* 52:   */   
/* 53:   */   public Integer add(Blog blog)
/* 54:   */   {
/* 55:54 */     return this.blogDao.add(blog);
/* 56:   */   }
/* 57:   */   
/* 58:   */   public Integer delete(Integer id)
/* 59:   */   {
/* 60:58 */     return this.blogDao.delete(id);
/* 61:   */   }
/* 62:   */   
/* 63:   */   public Integer getBlogByTypeId(Integer typeId)
/* 64:   */   {
/* 65:62 */     return this.blogDao.getBlogByTypeId(typeId);
/* 66:   */   }
/* 67:   */ }


/* Location:           D:\classes\
 * Qualified Name:     com.blog.service.impl.BlogServiceImpl
 * JD-Core Version:    0.7.0.1
 */