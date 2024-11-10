/*  1:   */ package com.blog.util;
/*  2:   */ 
/*  3:   */ import java.io.PrintWriter;
/*  4:   */ import javax.servlet.http.HttpServletResponse;
/*  5:   */ 
/*  6:   */ public class ResponseUtil
/*  7:   */ {
/*  8:   */   public static void write(HttpServletResponse response, Object o)
/*  9:   */     throws Exception
/* 10:   */   {
/* 11:11 */     response.setContentType("text/html;charset=utf-8");
/* 12:12 */     PrintWriter out = response.getWriter();
/* 13:13 */     out.println(o.toString());
/* 14:14 */     out.flush();
/* 15:15 */     out.close();
/* 16:   */   }
/* 17:   */ }


/* Location:           D:\classes\
 * Qualified Name:     com.blog.util.ResponseUtil
 * JD-Core Version:    0.7.0.1
 */