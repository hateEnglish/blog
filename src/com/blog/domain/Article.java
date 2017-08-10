package com.blog.domain;

import java.sql.Timestamp;

public class Article {
	//文章id
	private int id;
	
	//文章标题
	private String title;
	
	//文章状态
	private int state;
	
	//文章类型id
	private int type_id;
	
	//文章作者id
	private int user_id;
	
	//文章内容
	private String content;
	
	//文章创建时间
	private Timestamp time;
	
	//作者名称 即 用户名
	private String author;
	
	//访问量
	private Integer visit_number;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public int getType_id() {
		return type_id;
	}

	public void setType_id(int type_id) {
		this.type_id = type_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getTime() {
		return time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

	

	

	@Override
	public String toString() {
		return "Article [id=" + id + ", title=" + title + ", state=" + state
				+ ", type_id=" + type_id + ", user_id=" + user_id
				+ ", content=" + content + ", time=" + time + ", author="
				+ author + ", visit_number=" + visit_number + "]";
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Integer getVisit_number() {
		return visit_number;
	}

	public void setVisit_number(Integer visit_number) {
		this.visit_number = visit_number;
	}
	
	
}
