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

public class GetUserInfo extends HttpServlet {

	public final static String GET_USER_BY_ID = "0";
	
	private UserDao userDao = UserDao.getInstance();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {}

	
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String type = req.getParameter("type");
		
		Result result = new Result();
		
		if(GET_USER_BY_ID.equals(type)){
			
			String id = req.getParameter("id");
			
			User user = userDao.getUserById(Integer.parseInt(id));
			if(null!=user){
			result.setObj(user);
			
			}else{
				result.setState(0);
				result.setObj("用户不存在");
			}
		}
		
		
		
		resp.getWriter().write(GsonUtil.toJson(result));
		
	}

}
