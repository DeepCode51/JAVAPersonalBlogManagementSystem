/*  1:   */ package com.blog.controller;
/*  2:   */ 
/*  3:   */ import com.blog.entity.Blogger;
/*  4:   */ import com.blog.service.BloggerService;
/*  5:   */ import com.blog.util.CryptographyUtil;
/*  6:   */ import javax.annotation.Resource;
/*  7:   */ import javax.servlet.http.HttpServletRequest;
/*  8:   */ import org.apache.shiro.SecurityUtils;
/*  9:   */ import org.apache.shiro.authc.UsernamePasswordToken;
/* 10:   */ import org.apache.shiro.subject.Subject;
/* 11:   */ import org.springframework.stereotype.Controller;
/* 12:   */ import org.springframework.web.bind.annotation.RequestMapping;
/* 13:   */ import org.springframework.web.servlet.ModelAndView;
/* 14:   */ 
/* 15:   */ @Controller
/* 16:   */ @RequestMapping({"/blogger"})
/* 17:   */ public class BloggerController
/* 18:   */ {
/* 19:   */   @Resource
/* 20:   */   private BloggerService bloggerService;
/* 21:   */   
/* 22:   */   @RequestMapping({"/login"})
/* 23:   */   public String login(Blogger blogger, HttpServletRequest request)
/* 24:   */   {
/* 25:37 */     Subject subject = SecurityUtils.getSubject();
/* 26:38 */     UsernamePasswordToken token = new UsernamePasswordToken(blogger.getUserName(), CryptographyUtil.md5(blogger.getPassword(), "java1234"));
/* 27:   */     try
/* 28:   */     {
/* 29:40 */       subject.login(token);
/* 30:41 */       return "redirect:/admin/main.jsp";
/* 31:   */     }
/* 32:   */     catch (Exception e)
/* 33:   */     {
/* 34:43 */       e.printStackTrace();
/* 35:44 */       request.setAttribute("blogger", blogger);
/* 36:45 */       request.setAttribute("errorInfo", "用户名或密码错误！");
/* 37:   */     }
/* 38:46 */     return "login";
/* 39:   */   }
/* 40:   */   
/* 41:   */   @RequestMapping({"/aboutMe"})
/* 42:   */   public ModelAndView aboutMe()
/* 43:   */     throws Exception
/* 44:   */   {
/* 45:57 */     ModelAndView mav = new ModelAndView();
/* 46:58 */     mav.addObject("blogger", this.bloggerService.find());
/* 47:59 */     mav.addObject("mainPage", "foreground/blogger/info.jsp");
/* 48:60 */     mav.addObject("pageTitle", "关于博主_Java开源博客系统");
/* 49:61 */     mav.setViewName("mainTemp");
/* 50:62 */     return mav;
/* 51:   */   }
/* 52:   */ }


/* Location:           D:\classes\
 * Qualified Name:     com.blog.controller.BloggerController
 * JD-Core Version:    0.7.0.1
 */