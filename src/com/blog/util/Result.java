
package com.blog.util;

public class Result {
	private int state;
	
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
