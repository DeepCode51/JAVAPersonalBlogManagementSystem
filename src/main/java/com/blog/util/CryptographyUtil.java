/*  1:   */ package com.blog.util;
/*  2:   */ 
/*  3:   */ import java.io.PrintStream;
/*  4:   */ import org.apache.shiro.crypto.hash.Md5Hash;
/*  5:   */ 
/*  6:   */ public class CryptographyUtil
/*  7:   */ {
/*  8:   */   public static String md5(String str, String salt)
/*  9:   */   {
/* 10:20 */     return new Md5Hash(str, salt).toString();
/* 11:   */   }
/* 12:   */   
/* 13:   */   public static void main(String[] args)
/* 14:   */   {
/* 15:24 */     String password = "123456";
/* 16:   */     
/* 17:26 */     System.out.println("Md5加密：" + md5(password, "java1234"));
/* 18:   */   }
/* 19:   */ }


/* Location:           D:\classes\
 * Qualified Name:     com.blog.util.CryptographyUtil
 * JD-Core Version:    0.7.0.1
 */