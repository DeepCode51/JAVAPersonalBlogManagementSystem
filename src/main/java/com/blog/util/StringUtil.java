/*  1:   */ package com.blog.util;
/*  2:   */ 
/*  3:   */ import java.util.ArrayList;
/*  4:   */ import java.util.List;
/*  5:   */ 
/*  6:   */ public class StringUtil
/*  7:   */ {
/*  8:   */   public static boolean isEmpty(String str)
/*  9:   */   {
/* 10:19 */     if ((str == null) || ("".equals(str.trim()))) {
/* 11:20 */       return true;
/* 12:   */     }
/* 13:22 */     return false;
/* 14:   */   }
/* 15:   */   
/* 16:   */   public static boolean isNotEmpty(String str)
/* 17:   */   {
/* 18:32 */     if ((str != null) && (!"".equals(str.trim()))) {
/* 19:33 */       return true;
/* 20:   */     }
/* 21:35 */     return false;
/* 22:   */   }
/* 23:   */   
/* 24:   */   public static String formatLike(String str)
/* 25:   */   {
/* 26:45 */     if (isNotEmpty(str)) {
/* 27:46 */       return "%" + str + "%";
/* 28:   */     }
/* 29:48 */     return null;
/* 30:   */   }
/* 31:   */   
/* 32:   */   public static List<String> filterWhite(List<String> list)
/* 33:   */   {
/* 34:58 */     List<String> resultList = new ArrayList();
/* 35:59 */     for (String l : list) {
/* 36:60 */       if (isNotEmpty(l)) {
/* 37:61 */         resultList.add(l);
/* 38:   */       }
/* 39:   */     }
/* 40:64 */     return resultList;
/* 41:   */   }
/* 42:   */ }


/* Location:           D:\classes\
 * Qualified Name:     com.blog.util.StringUtil
 * JD-Core Version:    0.7.0.1
 */