package com.lh.blog.util;

import java.util.UUID;

public class UUIDUtils {

	/**
	 * 获取32位UUID
	 * 
	 * @return
	 */
	public static String randomUUID(){
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
	
	public static void main(String[] args) {
		System.out.println(randomUUID());
	}
}
