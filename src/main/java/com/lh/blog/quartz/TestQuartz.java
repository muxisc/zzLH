package com.lh.blog.quartz;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 定时器触发事件
 * @author hzhb
 *
 */
public class TestQuartz {
	
	public void test() {
		SimpleDateFormat df=new SimpleDateFormat("yy-MM-dd HH:mm:ss");
		System.out.println(df.format(new Date())+" 定时器触发了");
	}
	
}
