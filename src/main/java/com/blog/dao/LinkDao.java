package com.blog.dao;

import com.blog.entity.Link;
import java.util.List;
import java.util.Map;

public abstract interface LinkDao
{
  public abstract int add(Link paramLink);
  
  public abstract int update(Link paramLink);
  
  public abstract List<Link> list(Map<String, Object> paramMap);
  
  public abstract Long getTotal(Map<String, Object> paramMap);
  
  public abstract Integer delete(Integer paramInteger);
}


/* Location:           D:\classes\
 * Qualified Name:     com.blog.dao.LinkDao
 * JD-Core Version:    0.7.0.1
 */