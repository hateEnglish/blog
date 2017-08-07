package com.blog.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blog.dao.CommentDao;
import com.blog.domain.Comment;
import com.blog.util.GsonUtil;
import com.blog.util.Result;

public class GetComment extends HttpServlet {

	//通过文章id获取评论
	public static final String GET_COMMENT_BY_ARTICLE_ID = "0";
	
	private static CommentDao commentDao = CommentDao.getInstance();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {}

	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		//获取请求种类
		String type = req.getParameter("type");
		
		
		//生成返回结果对象
		Result result = new Result();
		
		if(GET_COMMENT_BY_ARTICLE_ID.equals(type)){
			
			String article_id = req.getParameter("article_id");
			
			List<Comment> comms = commentDao.getCommentByArticleId(Integer.parseInt(article_id));
			
			result.setObj(comms);
			
		}
		
		
		
		//输出返回数据
		resp.getWriter().write(GsonUtil.toJson(result));
	}

}
