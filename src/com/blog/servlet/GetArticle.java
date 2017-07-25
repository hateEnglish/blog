package com.blog.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blog.dao.ArticleDao;
import com.blog.domain.Article;
import com.blog.util.GsonUtil;
import com.blog.util.Result;

public class GetArticle extends HttpServlet {

	public static final String GET_BY_ID = "0";
	public static final String GET_BY_TIME = "1";
	public static final String GET_BY_USER_ID = "2";

	ArticleDao articleDao = ArticleDao.getInstance();

	/**
	 * The doGet method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		Result result = new Result();

		String type = req.getParameter("type");
		if (GET_BY_TIME.equals(type)) {

			System.out.println("getArticle bytime");

			String start = req.getParameter("start");
			String numb = req.getParameter("numb");

			List<Article> arts = articleDao.getNewestArticle(
					Integer.parseInt(start), Integer.parseInt(numb));

			result.setObj(arts);

		} else if (GET_BY_ID.equals(type)) {
			
			System.out.println("getArticle byid");
			
			String id = req.getParameter("start");
			System.out.println("id="+id);
			
			Article art = articleDao.getArticleById(Integer.parseInt(id));
			
			result.setObj(art);
		}else if(GET_BY_USER_ID.equals(type)){
			
			System.out.println("getArticle byuser_id");

			String user_id = req.getParameter("start");

			List<Article> arts = articleDao.getArticleByUserId(Integer.parseInt(user_id));

			result.setObj(arts);
			
		}
		System.out.println(GsonUtil.toJson(result));

		resp.getWriter().write(GsonUtil.toJson(result));

	}

}
