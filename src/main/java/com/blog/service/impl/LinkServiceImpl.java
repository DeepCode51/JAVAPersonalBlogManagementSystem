/*  1:   */ package com.blog.service.impl;
/*  2:   */ 
/*  3:   */ import com.blog.dao.LinkDao;
/*  4:   */ import com.blog.entity.Link;
/*  5:   */ import com.blog.service.LinkService;
/*  6:   */ import java.util.List;
/*  7:   */ import java.util.Map;
/*  8:   */ import javax.annotation.Resource;
/*  9:   */ import org.springframework.stereotype.Service;
/* 10:   */ 
/* 11:   */ @Service("linkService")
/* 12:   */ public class LinkServiceImpl
/* 13:   */   implements LinkService
/* 14:   */ {
/* 15:   */   @Resource
/* 16:   */   private LinkDao linkDao;
/* 17:   */   
/* 18:   */   public int add(Link link)
/* 19:   */   {
/* 20:26 */     return this.linkDao.add(link);
/* 21:   */   }
/* 22:   */   
/* 23:   */   public int update(Link link)
/* 24:   */   {
/* 25:30 */     return this.linkDao.update(link);
/* 26:   */   }
/* 27:   */   
/* 28:   */   public List<Link> list(Map<String, Object> map)
/* 29:   */   {
/* 30:34 */     return this.linkDao.list(map);
/* 31:   */   }
/* 32:   */   
/* 33:   */   public Long getTotal(Map<String, Object> map)
/* 34:   */   {
/* 35:38 */     return this.linkDao.getTotal(map);
/* 36:   */   }
/* 37:   */   
/* 38:   */   public Integer delete(Integer id)
/* 39:   */   {
/* 40:42 */     return this.linkDao.delete(id);
/* 41:   */   }
/* 42:   */ }


/* Location:           D:\classes\
 * Qualified Name:     com.blog.service.impl.LinkServiceImpl
 * JD-Core Version:    0.7.0.1
 */