package com.blog.service;

import com.blog.entity.BlogType;
import java.util.List;
import java.util.Map;

public abstract interface BlogTypeService
{
  public abstract List<BlogType> countList();
  
  public abstract List<BlogType> list(Map<String, Object> paramMap);
  
  public abstract Long getTotal(Map<String, Object> paramMap);
  
  public abstract Integer add(BlogType paramBlogType);
  
  public abstract Integer update(BlogType paramBlogType);
  
  public abstract Integer delete(Integer paramInteger);
}


/* Location:           D:\classes\
 * Qualified Name:     com.blog.service.BlogTypeService
 * JD-Core Version:    0.7.0.1
 */