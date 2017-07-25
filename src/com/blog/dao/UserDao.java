package com.blog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.blog.domain.User;
import com.blog.util.DatabaseUtil;

public class UserDao {

	private static UserDao userDao = new UserDao();

	private Connection conn;

	private UserDao() {

		conn = DatabaseUtil.getConn();

	}

	public static UserDao getInstance() {

		return userDao;

	}

	
	/**
	 * 添加用户
	 * 
	 * @param user 用户对象
	 * 
	 * @return 添加成功返回true 失败 返回false
	 * 
	 * */
	public boolean add(User user) {

		String sql = "insert into user(account,name,password,sex,sign,img,time) values(?,?,?,?,?,?,?)";

		PreparedStatement preStm = DatabaseUtil.getStatement(conn, sql);

		try {

			preStm.setString(1, user.getAccount());
			preStm.setString(2, user.getName());
			preStm.setString(3, user.getPasswd());
			preStm.setString(4, user.getSex());
			preStm.setString(5, user.getSign());
			preStm.setString(6, user.getImg());
			preStm.setTimestamp(7, user.getTime());

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {

			preStm.execute();

			//关闭会话
			preStm.close();

			return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	/**
	 * 通过账号和密码获得用户
	 * 
	 * @param account 用户账号
	 * @param passwd 用户密码
	 * 
	 * @return 用户对象
	 * */
	public User getUserByAccountAndPasswd(String account, String passwd) {

		User user = null;

		String sql = "select * from user where account=? and password=?";

		PreparedStatement preSta = DatabaseUtil.getStatement(conn, sql);

		try {
			preSta.setString(1, account);
			preSta.setString(2, passwd);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			ResultSet rs = preSta.executeQuery();

			
			while (rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setAccount(rs.getString("account"));
				user.setName(rs.getString("name"));
				user.setPasswd(rs.getString("password"));
				user.setSex(rs.getString("sex"));
				user.setSign(rs.getString("sign"));
				user.setImg(rs.getString("img"));
				user.setTime(rs.getTimestamp("time"));
			}
			preSta.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return user;
	}

	/**
	 * 获取新注册的用户
	 * 
	 * @param start 从最新的用户开始第几位用户 第一位 为0
	 * @param numb 用户个数
	 * 
	 * @return 用户列表
	 * */
	public List<User> getNewestUser(int start, int numb) {

		List<User> users = null;

		String sql = "select * from user order by time desc limit ?,?";

		PreparedStatement preSta = DatabaseUtil.getStatement(conn, sql);

		try {
			preSta.setInt(1, start);
			preSta.setInt(2, numb);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			ResultSet rs = preSta.executeQuery();

			users = new ArrayList<User>();
			while (rs.next()) {
				User user = new User();

				user.setId(rs.getInt("id"));
				user.setAccount(rs.getString("account"));
				user.setName(rs.getString("name"));
				// user.setPasswd(rs.getString("password"));
				user.setSex(rs.getString("sex"));
				user.setSign(rs.getString("sign"));
				user.setImg(rs.getString("img"));
				user.setTime(rs.getTimestamp("time"));
			}
			preSta.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return users;
	}

}
