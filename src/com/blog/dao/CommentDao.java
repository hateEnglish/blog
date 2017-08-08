package com.blog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.blog.domain.Comment;
import com.blog.util.DatabaseUtil;

public class CommentDao {

	private static CommentDao commentDao = new CommentDao();

	private Connection conn;

	private CommentDao() {
		conn = DatabaseUtil.getConn();
	}

	public static CommentDao getInstance() {
		return commentDao;
	}

	/**
	 * 添加评论
	 * 
	 * @param comm 评论对象
	 * 
	 * @return 添加成功返回true 否则 返回false
	 * */
	public boolean addComment(Comment comm){
		
		String sql = "insert into comment(article_id,object,user_id,content,time) values(?,?,?,?,?)";
		
		PreparedStatement pres = DatabaseUtil.getStatement(conn, sql);
		
		try {
			pres.setInt(1,comm.getArticle_id());
			pres.setInt(2, comm.getObject());
			pres.setInt(3, comm.getUser_id());
			pres.setString(4, comm.getContent());
			pres.setTimestamp(5, comm.getTime());
			
			pres.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	
	
	/**
	 * 通过文章id获取评论
	 * 
	 * @param article_id 文章id
	 * 
	 * @return 文章列表
	 * 
	 * */
	public List<Comment> getCommentByArticleId(int article_id) {

		//String sql = "select * from comment where article_id = ?";

		String sql = "select c.id,c.article_id,c.content,c.object,c.time,c.user_id,u.name as user_nam" +
				"e from comment as c,user as u where c.user_id=u.id && c.article_id=? order by c.time desc";
		
		List<Comment> comms = null;

		PreparedStatement pres = DatabaseUtil.getStatement(conn, sql);

		try {
			pres.setInt(1, article_id);

			ResultSet rs = pres.executeQuery();

			comms = new ArrayList<Comment>();

			while (rs.next()) {
				Comment comm = new Comment();

				comm.setId(rs.getInt("id"));
				comm.setArticle_id(rs.getInt("article_id"));
				comm.setContent(rs.getString("content"));
				comm.setObject(rs.getInt("object"));
				comm.setTime(rs.getTimestamp("time"));
				comm.setUser_id(rs.getInt("user_id"));
				comm.setUser_name(rs.getString("user_name"));
				
				comms.add(comm);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return comms;
	}
	
	
	

}
