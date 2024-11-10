/*  1:   */ package com.blog.util;
/*  2:   */ 
/*  3:   */ import java.text.SimpleDateFormat;
/*  4:   */ import java.util.Date;
/*  5:   */ 
/*  6:   */ public class DateUtil
/*  7:   */ {
/*  8:   */   public static String formatDate(Date date, String format)
/*  9:   */   {
/* 10:20 */     String result = "";
/* 11:21 */     SimpleDateFormat sdf = new SimpleDateFormat(format);
/* 12:22 */     if (date != null) {
/* 13:23 */       result = sdf.format(date);
/* 14:   */     }
/* 15:25 */     return result;
/* 16:   */   }
/* 17:   */   
/* 18:   */   public static Date formatString(String str, String format)
/* 19:   */     throws Exception
/* 20:   */   {
/* 21:36 */     if (StringUtil.isEmpty(str)) {
/* 22:37 */       return null;
/* 23:   */     }
/* 24:39 */     SimpleDateFormat sdf = new SimpleDateFormat(format);
/* 25:40 */     return sdf.parse(str);
/* 26:   */   }
/* 27:   */   
/* 28:   */   public static String getCurrentDateStr()
/* 29:   */     throws Exception
/* 30:   */   {
/* 31:44 */     Date date = new Date();
/* 32:45 */     SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
/* 33:46 */     return sdf.format(date);
/* 34:   */   }
/* 35:   */ }


/* Location:           D:\classes\
 * Qualified Name:     com.blog.util.DateUtil
 * JD-Core Version:    0.7.0.1
 */