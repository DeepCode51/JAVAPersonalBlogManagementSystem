/*   1:    */ package com.blog.controller.admin;
/*   2:    */ 
/*   3:    */ import com.blog.entity.Blogger;
/*   4:    */ import com.blog.service.BloggerService;
/*   5:    */ import com.blog.util.CryptographyUtil;
/*   6:    */ import com.blog.util.DateUtil;
/*   7:    */ import com.blog.util.ResponseUtil;
/*   8:    */ import java.io.File;
/*   9:    */ import javax.annotation.Resource;
/*  10:    */ import javax.servlet.ServletContext;
/*  11:    */ import javax.servlet.http.HttpServletRequest;
/*  12:    */ import javax.servlet.http.HttpServletResponse;
/*  13:    */ import net.sf.json.JSONObject;
/*  14:    */ import org.apache.shiro.SecurityUtils;
/*  15:    */ import org.apache.shiro.subject.Subject;
/*  16:    */ import org.springframework.stereotype.Controller;
/*  17:    */ import org.springframework.web.bind.annotation.RequestMapping;
/*  18:    */ import org.springframework.web.bind.annotation.RequestParam;
/*  19:    */ import org.springframework.web.multipart.MultipartFile;
/*  20:    */ 
/*  21:    */ @Controller
/*  22:    */ @RequestMapping({"/admin/blogger"})
/*  23:    */ public class BloggerAdminController
/*  24:    */ {
/*  25:    */   @Resource
/*  26:    */   private BloggerService bloggerService;
/*  27:    */   
/*  28:    */   @RequestMapping({"/save"})
/*  29:    */   public String save(@RequestParam("imageFile") MultipartFile imageFile, Blogger blogger, HttpServletRequest request, HttpServletResponse response)
/*  30:    */     throws Exception
/*  31:    */   {
/*  32: 46 */     if (!imageFile.isEmpty())
/*  33:    */     {
/*  34: 47 */       String filePath = request.getServletContext().getRealPath("/");
/*  35: 48 */       String imageName = DateUtil.getCurrentDateStr() + "." + imageFile.getOriginalFilename().split("\\.")[1];
/*  36: 49 */       imageFile.transferTo(new File(filePath + "static/userImages/" + imageName));
/*  37: 50 */       blogger.setImageName(imageName);
/*  38:    */     }
/*  39: 52 */     int resultTotal = this.bloggerService.update(blogger).intValue();
/*  40: 53 */     StringBuffer result = new StringBuffer();
/*  41: 54 */     if (resultTotal > 0) {
/*  42: 55 */       result.append("<script language='javascript'>alert('修改成功！');</script>");
/*  43:    */     } else {
/*  44: 57 */       result.append("<script language='javascript'>alert('修改失败！');</script>");
/*  45:    */     }
/*  46: 59 */     ResponseUtil.write(response, result);
/*  47: 60 */     return null;
/*  48:    */   }
/*  49:    */   
/*  50:    */   @RequestMapping({"/find"})
/*  51:    */   public String find(HttpServletResponse response)
/*  52:    */     throws Exception
/*  53:    */   {
/*  54: 71 */     Blogger blogger = this.bloggerService.find();
/*  55: 72 */     JSONObject jsonObject = JSONObject.fromObject(blogger);
/*  56: 73 */     ResponseUtil.write(response, jsonObject);
/*  57: 74 */     return null;
/*  58:    */   }
/*  59:    */   
/*  60:    */   @RequestMapping({"/modifyPassword"})
/*  61:    */   public String modifyPassword(String newPassword, HttpServletResponse response)
/*  62:    */     throws Exception
/*  63:    */   {
/*  64: 86 */     Blogger blogger = new Blogger();
/*  65: 87 */     blogger.setPassword(CryptographyUtil.md5(newPassword, "java1234"));
/*  66: 88 */     int resultTotal = this.bloggerService.update(blogger).intValue();
/*  67: 89 */     JSONObject result = new JSONObject();
/*  68: 90 */     if (resultTotal > 0) {
/*  69: 91 */       result.put("success", Boolean.valueOf(true));
/*  70:    */     } else {
/*  71: 93 */       result.put("success", Boolean.valueOf(false));
/*  72:    */     }
/*  73: 95 */     ResponseUtil.write(response, result);
/*  74: 96 */     return null;
/*  75:    */   }
/*  76:    */   
/*  77:    */   @RequestMapping({"/logout"})
/*  78:    */   public String logout()
/*  79:    */     throws Exception
/*  80:    */   {
/*  81:106 */     SecurityUtils.getSubject().logout();
/*  82:107 */     return "redirect:/login.jsp";
/*  83:    */   }
/*  84:    */ }


/* Location:           D:\classes\
 * Qualified Name:     com.blog.controller.admin.BloggerAdminController
 * JD-Core Version:    0.7.0.1
 */