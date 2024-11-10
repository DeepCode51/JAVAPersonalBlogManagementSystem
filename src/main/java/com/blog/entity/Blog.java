/*   1:    */ package com.blog.entity;
/*   2:    */ 
/*   3:    */ import java.io.Serializable;
/*   4:    */ import java.util.Date;
/*   5:    */ import java.util.LinkedList;
/*   6:    */ import java.util.List;
/*   7:    */ 
/*   8:    */ public class Blog
/*   9:    */   implements Serializable
/*  10:    */ {
/*  11:    */   private static final long serialVersionUID = 1L;
/*  12:    */   private Integer id;
/*  13:    */   private String title;
/*  14:    */   private String summary;
/*  15:    */   private Date releaseDate;
/*  16:    */   private Integer clickHit;
/*  17:    */   private Integer replyHit;
/*  18:    */   private String content;
/*  19:    */   private String contentNoTag;
/*  20:    */   private BlogType blogType;
/*  21:    */   private Integer blogCount;
/*  22:    */   private String releaseDateStr;
/*  23:    */   private String keyWord;
/*  24: 34 */   private List<String> imagesList = new LinkedList();
/*  25:    */   
/*  26:    */   public Integer getId()
/*  27:    */   {
/*  28: 37 */     return this.id;
/*  29:    */   }
/*  30:    */   
/*  31:    */   public void setId(Integer id)
/*  32:    */   {
/*  33: 40 */     this.id = id;
/*  34:    */   }
/*  35:    */   
/*  36:    */   public String getTitle()
/*  37:    */   {
/*  38: 43 */     return this.title;
/*  39:    */   }
/*  40:    */   
/*  41:    */   public void setTitle(String title)
/*  42:    */   {
/*  43: 46 */     this.title = title;
/*  44:    */   }
/*  45:    */   
/*  46:    */   public String getSummary()
/*  47:    */   {
/*  48: 49 */     return this.summary;
/*  49:    */   }
/*  50:    */   
/*  51:    */   public void setSummary(String summary)
/*  52:    */   {
/*  53: 52 */     this.summary = summary;
/*  54:    */   }
/*  55:    */   
/*  56:    */   public Date getReleaseDate()
/*  57:    */   {
/*  58: 55 */     return this.releaseDate;
/*  59:    */   }
/*  60:    */   
/*  61:    */   public void setReleaseDate(Date releaseDate)
/*  62:    */   {
/*  63: 58 */     this.releaseDate = releaseDate;
/*  64:    */   }
/*  65:    */   
/*  66:    */   public Integer getClickHit()
/*  67:    */   {
/*  68: 61 */     return this.clickHit;
/*  69:    */   }
/*  70:    */   
/*  71:    */   public void setClickHit(Integer clickHit)
/*  72:    */   {
/*  73: 64 */     this.clickHit = clickHit;
/*  74:    */   }
/*  75:    */   
/*  76:    */   public Integer getReplyHit()
/*  77:    */   {
/*  78: 67 */     return this.replyHit;
/*  79:    */   }
/*  80:    */   
/*  81:    */   public void setReplyHit(Integer replyHit)
/*  82:    */   {
/*  83: 70 */     this.replyHit = replyHit;
/*  84:    */   }
/*  85:    */   
/*  86:    */   public String getContent()
/*  87:    */   {
/*  88: 73 */     return this.content;
/*  89:    */   }
/*  90:    */   
/*  91:    */   public void setContent(String content)
/*  92:    */   {
/*  93: 76 */     this.content = content;
/*  94:    */   }
/*  95:    */   
/*  96:    */   public String getContentNoTag()
/*  97:    */   {
/*  98: 79 */     return this.contentNoTag;
/*  99:    */   }
/* 100:    */   
/* 101:    */   public void setContentNoTag(String contentNoTag)
/* 102:    */   {
/* 103: 82 */     this.contentNoTag = contentNoTag;
/* 104:    */   }
/* 105:    */   
/* 106:    */   public BlogType getBlogType()
/* 107:    */   {
/* 108: 85 */     return this.blogType;
/* 109:    */   }
/* 110:    */   
/* 111:    */   public void setBlogType(BlogType blogType)
/* 112:    */   {
/* 113: 88 */     this.blogType = blogType;
/* 114:    */   }
/* 115:    */   
/* 116:    */   public Integer getBlogCount()
/* 117:    */   {
/* 118: 91 */     return this.blogCount;
/* 119:    */   }
/* 120:    */   
/* 121:    */   public void setBlogCount(Integer blogCount)
/* 122:    */   {
/* 123: 94 */     this.blogCount = blogCount;
/* 124:    */   }
/* 125:    */   
/* 126:    */   public String getReleaseDateStr()
/* 127:    */   {
/* 128: 97 */     return this.releaseDateStr;
/* 129:    */   }
/* 130:    */   
/* 131:    */   public void setReleaseDateStr(String releaseDateStr)
/* 132:    */   {
/* 133:100 */     this.releaseDateStr = releaseDateStr;
/* 134:    */   }
/* 135:    */   
/* 136:    */   public String getKeyWord()
/* 137:    */   {
/* 138:103 */     return this.keyWord;
/* 139:    */   }
/* 140:    */   
/* 141:    */   public void setKeyWord(String keyWord)
/* 142:    */   {
/* 143:106 */     this.keyWord = keyWord;
/* 144:    */   }
/* 145:    */   
/* 146:    */   public List<String> getImagesList()
/* 147:    */   {
/* 148:110 */     return this.imagesList;
/* 149:    */   }
/* 150:    */   
/* 151:    */   public void setImagesList(List<String> imagesList)
/* 152:    */   {
/* 153:113 */     this.imagesList = imagesList;
/* 154:    */   }
/* 155:    */ }


/* Location:           D:\classes\
 * Qualified Name:     com.blog.entity.Blog
 * JD-Core Version:    0.7.0.1
 */