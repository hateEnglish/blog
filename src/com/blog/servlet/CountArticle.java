package com.blog.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blog.dao.ArticleDao;
import com.blog.util.GsonUtil;
import com.blog.util.Result;

public class CountArticle extends HttpServlet {

	//统计所有文章数量
	public static final String COUNT_ALL = "0";
	//通过用户id统计文章数量
	public static final String COUNT_BY_USER_ID = "1";
	
	public static ArticleDao articleDao = ArticleDao.getInstance();
	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
		
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
		//从客户端获取请求类型
		String type = req.getParameter("type");
		
		//返回对象
		Result result = new Result();
		
		//统计所有文章数量
		if(COUNT_ALL.equals(type)){
			
			int numb = articleDao.countArticle();
			
			result.setObj(numb);
			
		}if(COUNT_BY_USER_ID.equals(type)){
			
			//从客户端获取用户id
			String user_id = req.getParameter("user_id");
			
			int numb = articleDao.countArticleByUserId(Integer.parseInt(user_id));
			
			result.setObj(numb);
		}
		
		
		resp.getWriter().write(GsonUtil.toJson(result));
		
	}

}
