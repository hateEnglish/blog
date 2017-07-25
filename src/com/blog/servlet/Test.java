package com.blog.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blog.dao.ArticleDao;
import com.blog.dao.UserDao;
import com.blog.domain.Article;
import com.blog.domain.User;

public class Test extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public Test() {
		super();
	}

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
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UserDao userDao = UserDao.getInstance();
		
		User user = new User();
		
		user.setAccount("xubao");
		user.setName("hahaxubao");
		user.setPasswd("1234");
		user.setSex("0");
		user.setSign("woshixubao");
		user.setTime(new Timestamp(System.currentTimeMillis()));
		user.setImg("default.jpg");
		
		userDao.add(user);
		System.out.println("user="+user);
		System.out.println("开始查询");
		
		User user1 = userDao.getUserByAccountAndPasswd("xubao", "1234");
		System.out.println(user1);
		
		System.out.println("开始测试articleDao");
		
		
		ArticleDao artDao = ArticleDao.getInstance();
		
		Article article = new Article();
		
		article.setState(1);
		article.setContent("我是虚报,我要介绍我自己");
		article.setUser_id(3);
		article.setTitle("自我介绍");
		article.setType_id(3);
		article.setTime(new Timestamp(System.currentTimeMillis()));
		
		artDao.add(article);
		System.out.println("artiicle="+article);
		
		System.out.println("查询文章");
		
		List<Article> art2 = artDao.getArticleByUserId(3);
		
		System.out.println("art2s"+art2);
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the GET method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
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
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the POST method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

}
