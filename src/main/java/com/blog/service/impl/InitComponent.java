///*  1:   */ package com.blog.service.impl;
///*  2:   */
///*  3:   */ import com.blog.entity.Blog;
///*  4:   */ import com.blog.entity.BlogType;
///*  5:   */ import com.blog.entity.Blogger;
///*  6:   */ import com.blog.entity.Link;
///*  7:   */ import com.blog.service.BlogService;
///*  8:   */ import com.blog.service.BlogTypeService;
///*  9:   */ import com.blog.service.BloggerService;
///* 10:   */ import com.blog.service.LinkService;
///* 11:   */ import java.util.List;
///* 12:   */ import javax.servlet.ServletContext;
///* 13:   */ import javax.servlet.ServletContextEvent;
///* 14:   */ import javax.servlet.ServletContextListener;
///* 15:   */ import org.springframework.beans.BeansException;
///* 16:   */ import org.springframework.context.ApplicationContext;
///* 17:   */ import org.springframework.context.ApplicationContextAware;
///* 18:   */ import org.springframework.stereotype.Component;
///* 19:   */
///* 20:   */ @Component
///* 21:   */ public class InitComponent
///* 22:   */   implements ServletContextListener, ApplicationContextAware
///* 23:   */ {
///* 24:   */   private static ApplicationContext applicationContext;
///* 25:   */
///* 26:   */   public void setApplicationContext(ApplicationContext applicationContext)
///* 27:   */     throws BeansException
///* 28:   */   {
///* 29:35 */     applicationContext = applicationContext;
///* 30:   */   }
///* 31:   */
///* 32:   */   public void contextInitialized(ServletContextEvent servletContextEvent)
///* 33:   */   {
///* 34:39 */     ServletContext application = servletContextEvent.getServletContext();
///* 35:40 */     BloggerService bloggerService = (BloggerService)applicationContext.getBean("bloggerService");
///* 36:41 */     Blogger blogger = bloggerService.find();
///* 37:42 */     blogger.setPassword(null);
///* 38:43 */     application.setAttribute("blogger", blogger);
///* 39:   */
///* 40:45 */     BlogTypeService blogTypeService = (BlogTypeService)applicationContext.getBean("blogTypeService");
///* 41:46 */     List<BlogType> blogTypeCountList = blogTypeService.countList();
///* 42:47 */     application.setAttribute("blogTypeCountList", blogTypeCountList);
///* 43:   */
///* 44:49 */     BlogService blogService = (BlogService)applicationContext.getBean("blogService");
///* 45:50 */     List<Blog> blogCountList = blogService.countList();
///* 46:51 */     application.setAttribute("blogCountList", blogCountList);
///* 47:   */
///* 48:53 */     LinkService linkService = (LinkService)applicationContext.getBean("linkService");
///* 49:54 */     List<Link> linkList = linkService.list(null);
///* 50:55 */     application.setAttribute("linkList", linkList);
///* 51:   */   }
///* 52:   */
///* 53:   */   public void contextDestroyed(ServletContextEvent sce) {}
///* 54:   */ }
//
//
//
///* Location:           D:\classes\
//
// * Qualified Name:     com.blog.service.impl.InitComponent
//
// * JD-Core Version:    0.7.0.1
//
// */