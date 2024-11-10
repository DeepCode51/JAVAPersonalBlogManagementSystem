/*  1:   */ package com.blog.util;
/*  2:   */ 
/*  3:   */ public class PageUtil
/*  4:   */ {
/*  5:   */   public static String genPagination(String targetUrl, long totalNum, int currentPage, int pageSize, String param)
/*  6:   */   {
/*  7:19 */     long totalPage = totalNum % pageSize == 0L ? totalNum / pageSize : totalNum / pageSize + 1L;
/*  8:20 */     if (totalPage == 0L) {
/*  9:21 */       return "未查询到数据";
/* 10:   */     }
/* 11:23 */     StringBuffer pageCode = new StringBuffer();
/* 12:24 */     pageCode.append("<li><a href='" + targetUrl + "?page=1&" + param + "'>首页</a></li>");
/* 13:25 */     if (currentPage > 1) {
/* 14:26 */       pageCode.append("<li><a href='" + targetUrl + "?page=" + (currentPage - 1) + "&" + param + "'>上一页</a></li>");
/* 15:   */     } else {
/* 16:28 */       pageCode.append("<li class='disabled'><a href='#'>上一页</a></li>");
/* 17:   */     }
/* 18:30 */     for (int i = currentPage - 2; i <= currentPage + 2; i++) {
/* 19:31 */       if ((i >= 1) && (i <= totalPage)) {
/* 20:34 */         if (i == currentPage) {
/* 21:35 */           pageCode.append("<li class='active'><a href='" + targetUrl + "?page=" + i + "&" + param + "'>" + i + "</a></li>");
/* 22:   */         } else {
/* 23:37 */           pageCode.append("<li><a href='" + targetUrl + "?page=" + i + "&" + param + "'>" + i + "</a></li>");
/* 24:   */         }
/* 25:   */       }
/* 26:   */     }
/* 27:40 */     if (currentPage < totalPage) {
/* 28:41 */       pageCode.append("<li><a href='" + targetUrl + "?page=" + (currentPage + 1) + "&" + param + "'>下一页</a></li>");
/* 29:   */     } else {
/* 30:43 */       pageCode.append("<li class='disabled'><a href='#'>下一页</a></li>");
/* 31:   */     }
/* 32:45 */     pageCode.append("<li><a href='" + targetUrl + "?page=" + totalPage + "&" + param + "'>尾页</a></li>");
/* 33:46 */     return pageCode.toString();
/* 34:   */   }
/* 35:   */ }


/* Location:           D:\classes\
 * Qualified Name:     com.blog.util.PageUtil
 * JD-Core Version:    0.7.0.1
 */