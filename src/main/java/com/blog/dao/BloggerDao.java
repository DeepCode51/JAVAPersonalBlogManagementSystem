package com.blog.dao;

import com.blog.entity.Blogger;

public abstract interface BloggerDao
{
  public abstract Blogger find();
  
  public abstract Blogger getByUserName(String paramString);
  
  public abstract Integer update(Blogger paramBlogger);
}


/* Location:           D:\classes\
 * Qualified Name:     com.blog.dao.BloggerDao
 * JD-Core Version:    0.7.0.1
 */