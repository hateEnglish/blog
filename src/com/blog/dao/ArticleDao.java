package com.blog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.blog.domain.Article;
import com.blog.util.DatabaseUtil;

public class ArticleDao {
	private static ArticleDao articleDao = new ArticleDao();

	private Connection conn;

	private ArticleDao() {

		conn = DatabaseUtil.getConn();

	}

	public static ArticleDao getInstance() {

		return articleDao;

	}

	/**
	 * 获取文章总数
	 * 
	 * @return 文章总数
	 * 
	 */
	
	public int countArticle(){
		String sql = "select count(id) as numb from article";
		
		PreparedStatement pres = DatabaseUtil.getStatement(conn, sql);
		
		try {
			ResultSet rs = pres.executeQuery();
			
			rs.next();
			
			return rs.getInt("numb");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
		
	}
	
	public int countArticleByUserId(int user_id){
		
		String sql = "select count(id) as numb from article where user_id = ?";
		
		PreparedStatement pres = DatabaseUtil.getStatement(conn, sql);
		
		
		
		try {
			
			pres.setInt(1, user_id);
			
			ResultSet rs = pres.executeQuery();
			
			rs.next();
			
			return rs.getInt("numb");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
		
	}
	
	/**
	 * 添加文章
	 * 
	 * @param 文章对象
	 * 
	 * @return 添加成功返回true 否则 返回 false
	 * 
	 * */
	public boolean add(Article article) {

		String sql = "insert into article(title,state,type_id,user_id,content,time) values(?,?,?,?,?,?)";

		PreparedStatement preStm = DatabaseUtil.getStatement(conn, sql);

		try {
			preStm.setString(1, article.getTitle());
			preStm.setInt(2, article.getState());
			preStm.setInt(3, article.getType_id());
			preStm.setInt(4, article.getUser_id());
			preStm.setString(5, article.getContent());
			preStm.setTimestamp(6, article.getTime());

			preStm.execute();

			preStm.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	
	/**
	 * 通过文章id 获取文章
	 * 
	 * @param id 文章id
	 * 
	 * @return 文章对象
	 * */
	public Article getArticleById(int id) {
		Article art = null;

		String sql = "select article.id,name,state,title,type_id,user_id,article.time,content from article ,user where article.id=? and article.user_id=user.id";

		PreparedStatement preStm = DatabaseUtil.getStatement(conn, sql);

		try {

			preStm.setInt(1, id);

			ResultSet rs = preStm.executeQuery();

			art = new Article();

			while (rs.next()) {

				art.setId(rs.getInt("id"));
				art.setState(rs.getInt("state"));
				art.setTitle(rs.getString("title"));
				art.setType_id(rs.getInt("type_id"));
				art.setUser_id(rs.getInt("user_id"));
				art.setTime(rs.getTimestamp("time"));
				art.setContent(rs.getString("content"));
				art.setAuthor(rs.getString("name"));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return art;
	}

	/**
	 * 通过文章作者获得文章列表
	 * 
	 * @param user_id 文章作者id
	 * 
	 * @return 文章列表
	 * 
	 * */
	public List<Article> getArticleByUserId(int user_id) {
		List<Article> articles = null;

		String sql = "select * from article where user_id=?";

		
		PreparedStatement preStm = DatabaseUtil.getStatement(conn, sql);

		try {

			preStm.setInt(1, user_id);

			ResultSet rs = preStm.executeQuery();

			articles = new ArrayList<Article>();

			while (rs.next()) {
				Article art = new Article();

				art.setId(rs.getInt("id"));
				art.setState(rs.getInt("state"));
				art.setTitle(rs.getString("title"));
				art.setType_id(rs.getInt("type_id"));
				art.setUser_id(rs.getInt("user_id"));
				art.setTime(rs.getTimestamp("time"));
				// art.setContent(rs.getString("content"));

				articles.add(art);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return articles;
	}

	
	
	/**
	 * 通过文章作者获得文章列表
	 * 
	 * @param user_id 文章作者id
	 * 
	 * @return 文章列表
	 * 
	 * */
	public Article getArticleByUserIdAndTitle(int user_id,String title) {
		Article art = null;

		String sql = "select * from article where user_id=? and title =?";

		
		PreparedStatement preStm = DatabaseUtil.getStatement(conn, sql);

		try {

			preStm.setInt(1, user_id);
			preStm.setString(2, title);

			ResultSet rs = preStm.executeQuery();

			

			while (rs.next()) {
				art = new Article();
				art.setId(rs.getInt("id"));
				art.setState(rs.getInt("state"));
				art.setTitle(rs.getString("title"));
				art.setType_id(rs.getInt("type_id"));
				art.setUser_id(rs.getInt("user_id"));
				art.setTime(rs.getTimestamp("time"));
				// art.setContent(rs.getString("content"));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return art;
	}
	
	
	
	/**
	 * 获取最新发表的文章列表
	 * 
	 * @param start 从新到旧 发布  第一位 为 0
	 * @param numb 文章数量
	 * 
	 * @return 文章列表
	 * */
	public List<Article> getNewestArticle(int start, int numb) {
		List<Article> articles = null;

		//String sql = "select * from article order by time desc limit ?,?";

		String sql = "select article.id,name,state,title,type_id,user_id,article.time" +
				" from article ,user where article.user_id=user.id order by article.time desc limit ?,?";
		
		
		PreparedStatement preStm = DatabaseUtil.getStatement(conn, sql);

		try {

			preStm.setInt(1, start);
			preStm.setInt(2, numb);

			ResultSet rs = preStm.executeQuery();

			articles = new ArrayList<Article>();

			while (rs.next()) {
				Article art = new Article();

				art.setId(rs.getInt("id"));
				art.setState(rs.getInt("state"));
				art.setTitle(rs.getString("title"));
				art.setType_id(rs.getInt("type_id"));
				art.setUser_id(rs.getInt("user_id"));
				art.setTime(rs.getTimestamp("time"));
				// art.setContent(rs.getString("content"));
				art.setAuthor(rs.getString("name"));

				articles.add(art);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return articles;
	}

}
