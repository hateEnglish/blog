package com.blog.servlet;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blog.dao.UserDao;
import com.blog.domain.User;
import com.blog.util.GsonUtil;
import com.blog.util.Result;

public class RegistServlet extends HttpServlet {

	private UserDao userDao = UserDao.getInstance();
	
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
		
		String account = req.getParameter("account");
		String user_name = req.getParameter("user_name");
		String passwd = req.getParameter("password");
		String sex = req.getParameter("sex");
		
		System.out.println(account+":"+user_name+":"+passwd+":"+sex);
		
		User user = new User();
		
		user.setAccount(account);
		user.setName(user_name);
		user.setPasswd(passwd);
		user.setSex("woman".equals(sex)?"1":"0");
		user.setTime(new Timestamp(System.currentTimeMillis()));
		
		if(userDao.add(user)){
			System.out.println("添加用户成功");
		}else{
		
		System.out.println("添加用户失败");
		
		}
		
		Result result = new Result();
		
		result.setState(0);
		result.setObj("注册成功");
		resp.getWriter().write(GsonUtil.toJson(result));
		
	}

}
