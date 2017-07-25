package com.blog.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonUtil {
	private static Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
	
	public static String toJson(Object obj){
		return gson.toJson(obj);
	}
	
}
