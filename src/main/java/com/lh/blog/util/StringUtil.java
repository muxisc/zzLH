package com.lh.blog.util;


/**
 * 字符串工具类
 * @author icinfo
 *
 */
public class StringUtil {
	
	/**
	 * 数组转成字符串
	 * @param arrObject 数组对象
	 * @param separator 分隔符
	 * @return
	 */
    public static String arrayToString(Object [] arrObject,String separator) {
		
		// 默认为","号
		if(separator==null || separator.equals("")) separator = "," ;
		
		String returnStrValue = "";
		
		if(arrObject!=null){
			for(Object object:  arrObject){
				if(returnStrValue.equals("")){
					returnStrValue = String.valueOf(object);
				}
				else{
					returnStrValue = returnStrValue + separator + String.valueOf(object);
				}
			}
		}
		return returnStrValue;
	}

}
