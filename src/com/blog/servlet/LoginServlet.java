package com.blog.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blog.dao.UserDao;
import com.blog.domain.User;
import com.blog.util.GsonUtil;
import com.blog.util.Result;

public class LoginServlet extends HttpServlet {

	UserDao userDao = UserDao.getInstance();

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
			throws ServletException, IOException {}

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


		String account = req.getParameter("account");
		String passwd = req.getParameter("password");

		System.out.println(account+":"+passwd);
		
		User user = userDao.getUserByAccountAndPasswd(account, passwd);
		
		System.out.println(user);
		
		if (null != user) {
			
			req.getSession().setAttribute("user", user);
			System.out.println("用户存在");
			
			
			Result result = new Result();
			result.setState(0);
			result.setObj(user);
			
			
			resp.getWriter().write(GsonUtil.toJson(result));
		} else {
			
			Result result = new Result();
			result.setState(1);
			result.setObj("用户不存在");
			
			System.out.println(GsonUtil.toJson(result));
			resp.getWriter().write(GsonUtil.toJson(result));
			
			
		}

	
	}

}
