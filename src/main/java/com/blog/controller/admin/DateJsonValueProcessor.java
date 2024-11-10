/*  1:   */ package com.blog.controller.admin;
/*  2:   */ 
/*  3:   */ import java.sql.Timestamp;
/*  4:   */ import java.text.SimpleDateFormat;
/*  5:   */ import java.util.Date;
/*  6:   */ import net.sf.json.JsonConfig;
/*  7:   */ import net.sf.json.processors.JsonValueProcessor;
/*  8:   */ 
/*  9:   */ public class DateJsonValueProcessor
/* 10:   */   implements JsonValueProcessor
/* 11:   */ {
/* 12:   */   private String format;
/* 13:   */   
/* 14:   */   public DateJsonValueProcessor(String format)
/* 15:   */   {
/* 16:18 */     this.format = format;
/* 17:   */   }
/* 18:   */   
/* 19:   */   public Object processArrayValue(Object value, JsonConfig jsonConfig)
/* 20:   */   {
/* 21:23 */     return null;
/* 22:   */   }
/* 23:   */   
/* 24:   */   public Object processObjectValue(String key, Object value, JsonConfig jsonConfig)
/* 25:   */   {
/* 26:27 */     if (value == null) {
/* 27:29 */       return "";
/* 28:   */     }
/* 29:31 */     if ((value instanceof Timestamp))
/* 30:   */     {
/* 31:33 */       String str = new SimpleDateFormat(this.format).format((Timestamp)value);
/* 32:34 */       return str;
/* 33:   */     }
/* 34:36 */     if ((value instanceof Date))
/* 35:   */     {
/* 36:38 */       String str = new SimpleDateFormat(this.format).format((Date)value);
/* 37:39 */       return str;
/* 38:   */     }
/* 39:42 */     return value.toString();
/* 40:   */   }
/* 41:   */ }


/* Location:           D:\classes\
 * Qualified Name:     com.blog.controller.admin.DateJsonValueProcessor
 * JD-Core Version:    0.7.0.1
 */