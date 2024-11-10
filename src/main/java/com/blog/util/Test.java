/* 1:  */ package com.blog.util;
/* 2:  */ 
/* 3:  */ import java.io.PrintStream;
/* 4:  */ import org.apache.commons.lang.StringEscapeUtils;
/* 5:  */ 
/* 6:  */ public class Test
/* 7:  */ {
/* 8:  */   public static void main(String[] args)
/* 9:  */   {
/* ::8 */     String str = "<p>fda</p>";
/* ;:9 */     System.out.println(StringEscapeUtils.escapeHtml(str));
/* <:  */   }
/* =:  */ }


/* Location:           D:\classes\
 * Qualified Name:     com.blog.util.Test
 * JD-Core Version:    0.7.0.1
 */