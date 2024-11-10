/*  1:   */ package com.blog.realm;
/*  2:   */ 
/*  3:   */ import com.blog.entity.Blogger;
/*  4:   */ import com.blog.service.BloggerService;
/*  5:   */ import javax.annotation.Resource;
/*  6:   */ import org.apache.shiro.SecurityUtils;
/*  7:   */ import org.apache.shiro.authc.AuthenticationException;
/*  8:   */ import org.apache.shiro.authc.AuthenticationInfo;
/*  9:   */ import org.apache.shiro.authc.AuthenticationToken;
/* 10:   */ import org.apache.shiro.authc.SimpleAuthenticationInfo;
/* 11:   */ import org.apache.shiro.authz.AuthorizationInfo;
/* 12:   */ import org.apache.shiro.realm.AuthorizingRealm;
/* 13:   */ import org.apache.shiro.session.Session;
/* 14:   */ import org.apache.shiro.subject.PrincipalCollection;
/* 15:   */ import org.apache.shiro.subject.Subject;
/* 16:   */ 
/* 17:   */ public class MyRealm
/* 18:   */   extends AuthorizingRealm
/* 19:   */ {
/* 20:   */   @Resource
/* 21:   */   private BloggerService bloggerService;
/* 22:   */   
/* 23:   */   protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals)
/* 24:   */   {
/* 25:32 */     return null;
/* 26:   */   }
/* 27:   */   
/* 28:   */   protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token)
/* 29:   */     throws AuthenticationException
/* 30:   */   {
/* 31:40 */     String userName = (String)token.getPrincipal();
/* 32:41 */     Blogger blogger = this.bloggerService.getByUserName(userName);
/* 33:42 */     if (blogger != null)
/* 34:   */     {
/* 35:43 */       SecurityUtils.getSubject().getSession().setAttribute("currentUser", blogger);
/* 36:44 */       AuthenticationInfo authcInfo = new SimpleAuthenticationInfo(blogger.getUserName(), blogger.getPassword(), "xx");
/* 37:45 */       return authcInfo;
/* 38:   */     }
/* 39:47 */     return null;
/* 40:   */   }
/* 41:   */ }


/* Location:           D:\classes\
 * Qualified Name:     com.blog.realm.MyRealm
 * JD-Core Version:    0.7.0.1
 */