package com.blog.controller;

import com.blog.entity.Blog;
import com.blog.lucene.BlogIndex;
import com.blog.service.BlogService;
import com.blog.service.CommentService;
import com.blog.util.StringUtil;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping({"/blog"})
public class BlogController
{
  @Resource
  private BlogService blogService;
  @Resource
  private CommentService commentService;
  private BlogIndex blogIndex = new BlogIndex();
  
  @RequestMapping({"/articles/{id}"})
  public ModelAndView details(@PathVariable("id") Integer id, HttpServletRequest request)
    throws Exception
  {
    ModelAndView mav = new ModelAndView();
    Blog blog = this.blogService.findById(id);
    String keyWords = blog.getKeyWord();
    if (StringUtil.isNotEmpty(keyWords))
    {
      String[] arr = keyWords.split(" ");
      mav.addObject("keyWords", StringUtil.filterWhite(Arrays.asList(arr)));
    }
    else
    {
      mav.addObject("keyWords", null);
    }
    mav.addObject("blog", blog);
    blog.setClickHit(Integer.valueOf(blog.getClickHit().intValue() + 1));
    this.blogService.update(blog);
    Map<String, Object> map = new HashMap();
    map.put("blogId", blog.getId());
    map.put("state", Integer.valueOf(1));
    mav.addObject("commentList", this.commentService.list(map));
    mav.addObject("pageCode", genUpAndDownPageCode(this.blogService.getLastBlog(id), this.blogService.getNextBlog(id), request.getServletContext().getContextPath()));
    mav.addObject("mainPage", "foreground/blog/view.jsp");
    mav.addObject("pageTitle", blog.getTitle() + "_Java开源博客系统");
    mav.setViewName("mainTemp");
    return mav;
  }
  
  @RequestMapping({"/q"})
  public ModelAndView search(@RequestParam(value="q", required=false) String q, @RequestParam(value="page", required=false) String page, HttpServletRequest request)
    throws Exception
  {
    if (StringUtil.isEmpty(page)) {
      page = "1";
    }
    ModelAndView mav = new ModelAndView();
    mav.addObject("mainPage", "foreground/blog/result.jsp");
    List<Blog> blogList = this.blogIndex.searchBlog(q.trim());
    Integer toIndex = Integer.valueOf(blogList.size() >= Integer.parseInt(page) * 10 ? Integer.parseInt(page) * 10 : blogList.size());
    mav.addObject("blogList", blogList.subList((Integer.parseInt(page) - 1) * 10, toIndex.intValue()));
    mav.addObject("pageCode", genUpAndDownPageCode(Integer.valueOf(Integer.parseInt(page)), Integer.valueOf(blogList.size()), q, Integer.valueOf(10), request.getServletContext().getContextPath()));
    mav.addObject("q", q);
    mav.addObject("resultTotal", Integer.valueOf(blogList.size()));
    mav.addObject("pageTitle", "搜索关键字'" + q + "'结果页面_Java开源博客系统");
    mav.setViewName("mainTemp");
    return mav;
  }
  
  private String genUpAndDownPageCode(Blog lastBlog, Blog nextBlog, String projectContext)
  {
    StringBuffer pageCode = new StringBuffer();
    if ((lastBlog == null) || (lastBlog.getId() == null)) {
      pageCode.append("<p>上一篇：没有了</p>");
    } else {
      pageCode.append("<p>上一篇：<a href='" + projectContext + "/blog/articles/" + lastBlog.getId() + ".html'>" + lastBlog.getTitle() + "</a></p>");
    }
    if ((nextBlog == null) || (nextBlog.getId() == null)) {
      pageCode.append("<p>下一篇：没有了</p>");
    } else {
      pageCode.append("<p>下一篇：<a href='" + projectContext + "/blog/articles/" + nextBlog.getId() + ".html'>" + nextBlog.getTitle() + "</a></p>");
    }
    return pageCode.toString();
  }
  
  private String genUpAndDownPageCode(Integer page, Integer totalNum, String q, Integer pageSize, String projectContext)
  {
    long totalPage = totalNum.intValue() % pageSize.intValue() == 0 ? totalNum.intValue() / pageSize.intValue() : totalNum.intValue() / pageSize.intValue() + 1;
    StringBuffer pageCode = new StringBuffer();
    if (totalPage == 0L) {
      return "";
    }
    pageCode.append("<nav>");
    pageCode.append("<ul class='pager' >");
    if (page.intValue() > 1) {
      pageCode.append("<li><a href='" + projectContext + "/blog/q.html?page=" + (page.intValue() - 1) + "&q=" + q + "'>上一页</a></li>");
    } else {
      pageCode.append("<li class='disabled'><a href='#'>上一页</a></li>");
    }
    if (page.intValue() < totalPage) {
      pageCode.append("<li><a href='" + projectContext + "/blog/q.html?page=" + (page.intValue() + 1) + "&q=" + q + "'>下一页</a></li>");
    } else {
      pageCode.append("<li class='disabled'><a href='#'>下一页</a></li>");
    }
    pageCode.append("</ul>");
    pageCode.append("</nav>");
    
    return pageCode.toString();
  }
}
