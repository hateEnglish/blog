package com.blog.servlet;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blog.dao.CommentDao;
import com.blog.domain.Comment;
import com.blog.domain.User;
import com.blog.util.GsonUtil;
import com.blog.util.Result;

public class AddComment extends HttpServlet {
	
	private static CommentDao commentDao = CommentDao.getInstance();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		
	}

	
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		System.out.println("进入addcommment");
		
		User user = (User) req.getSession().getAttribute("user");
		
		Result result = new Result();
		
		if(null==user){
			result.setState(1);
			result.setObj("还没有用户登陆!");
			System.out.println("未登陆不能发表评论");
		}else{
		
			
		String obj = req.getParameter("obj");
		String content = req.getParameter("content");
		String article_id = req.getParameter("article_id");
		
		Comment comment = new Comment();
		
		comment.setArticle_id(Integer.parseInt(article_id));
		comment.setContent(content);
		comment.setObject(Integer.parseInt(obj));
		comment.setTime(new Timestamp(System.currentTimeMillis()));
		comment.setUser_id(user.getId());
		System.out.println(comment.toString());
		
		commentDao.addComment(comment);
		
		}
		
		
		resp.getWriter().write(GsonUtil.toJson(result));
		
		
		
	}

}
