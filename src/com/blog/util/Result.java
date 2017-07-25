package com.blog.util;

public class Result {
	//返回值状态 0 为成功 1 为失败 2 为异常
	private int state;
	
	//返回对象
	private Object obj;

	
	public Result(){}
	
	
	public Result(int state, Object obj) {
		super();
		this.state = state;
		this.obj = obj;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}
	
	
}
