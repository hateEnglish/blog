package com.blog.domain;

import java.sql.Timestamp;

public class Article {
	//����id
	private int id;
	
	//���±���
	private String title;
	
	//����״̬ 0Ϊ����״̬1��Ϊ�ݸ�״̬
	private int state;
	
	//��������id
	private int type_id;
	
	//�û�id
	private int user_id;
	
	//��������
	private String content;
	
	//���·���ʱ��
	private Timestamp time;
	
	//作者名称 即 用户名
	private String author;

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
				+ author + "]";
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	
	
}
