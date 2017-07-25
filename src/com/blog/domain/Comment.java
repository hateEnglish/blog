package com.blog.domain;

import java.sql.Timestamp;

public class Comment {
	//评论id
	private int id;
	
	//评论对象 文章id 或 评论id
	private int object;
	
	//发表评论的用户id
	private int user_id;
	
	//评论种类0 为对文章  1为对评论
	private int type;
	
	//评论内容
	private String content;
	
	//评论时间
	private Timestamp time;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getObject() {
		return object;
	}

	public void setObject(int object) {
		this.object = object;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
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
		return "Comment [id=" + id + ", object=" + object + ", user_id="
				+ user_id + ", type=" + type + ", content=" + content
				+ ", time=" + time + "]";
	}
	
	
}
