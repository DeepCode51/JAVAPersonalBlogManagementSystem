package com.blog.dao;

import com.blog.entity.Blog;
import java.util.List;
import java.util.Map;

public abstract interface BlogDao
{
  public abstract List<Blog> countList();
  
  public abstract List<Blog> list(Map<String, Object> paramMap);
  
  public abstract Long getTotal(Map<String, Object> paramMap);
  
  public abstract Blog findById(Integer paramInteger);
  
  public abstract Integer update(Blog paramBlog);
  
  public abstract Blog getLastBlog(Integer paramInteger);
  
  public abstract Blog getNextBlog(Integer paramInteger);
  
  public abstract Integer add(Blog paramBlog);
  
  public abstract Integer delete(Integer paramInteger);
  
  public abstract Integer getBlogByTypeId(Integer paramInteger);
}


/* Location:           D:\classes\
 * Qualified Name:     com.blog.dao.BlogDao
 * JD-Core Version:    0.7.0.1
 */