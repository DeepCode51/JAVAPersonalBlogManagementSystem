package com.blog.service;

import com.blog.entity.Comment;
import java.util.List;
import java.util.Map;

public abstract interface CommentService
{
  public abstract int add(Comment paramComment);
  
  public abstract int update(Comment paramComment);
  
  public abstract List<Comment> list(Map<String, Object> paramMap);
  
  public abstract Long getTotal(Map<String, Object> paramMap);
  
  public abstract Integer delete(Integer paramInteger);
}


/* Location:           D:\classes\
 * Qualified Name:     com.blog.service.CommentService
 * JD-Core Version:    0.7.0.1
 */