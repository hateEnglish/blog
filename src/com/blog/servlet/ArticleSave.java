package com.blog.servlet;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blog.dao.ArticleDao;
import com.blog.domain.Article;
import com.blog.domain.User;
import com.blog.util.GsonUtil;
import com.blog.util.Result;

public class ArticleSave extends HttpServlet {

	
	ArticleDao articleDao = ArticleDao.getInstance();
	
	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		doPost(req,resp);
		
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("添加文章---------");
		String title = req.getParameter("title");
		String context = req.getParameter("context");
		String state = req.getParameter("state");
		
		User user = (User)req.getSession().getAttribute("user");
		
		Article art = new Article();
		
		//设置用户id
		art.setUser_id(user.getId());
		//设置文章属性
		art.setTitle(title);
		art.setContent(context);
		art.setState(Integer.parseInt(state));
		art.setType_id(1);
		//设置文章发布时间
		art.setTime(new Timestamp(System.currentTimeMillis()));
		System.out.println("art="+art);
		
		Result result = new Result();
		result.setObj("接收成功");
		
		articleDao.add(art);
		
		resp.getWriter().write(GsonUtil.toJson(result));
	}

}
