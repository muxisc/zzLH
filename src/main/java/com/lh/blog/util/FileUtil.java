package com.lh.blog.util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public class FileUtil {
	
	private static final Logger logger=LoggerFactory.getLogger(FileUtil.class);
	
	/**
	 * 上传到本地的接口
	 * @param files
	 * @param fileName
	 * @param fileLocalPath
	 * @return
	 */
	public static String uploadToLocal(MultipartFile files,String fileName,String fileLocalPath) {
		System.out.println("上传到本地开始");
		//第一个：D:\\Users\\lh\\workspace\\zzLH\\src\\main\\webapp\\views\\upload
		//第二个：lh7ac281e0ab40492d8751f1a9c041f999-哈嗯.pptx
		//目标文件：第一个\第二个
		File targetFile=new File(fileLocalPath, fileName);
		
		if(!targetFile.exists()){     //本地不存在该文件 
			//mkdirs()：可以在不存在的目录中创建文件夹   mkdir()：只能在已经存在的目录中创建文件夹  即需存在upload该文件夹
			targetFile.mkdirs();
		}
		
		//保存
		try {
			files.transferTo(targetFile);     //保存到一个目标文件
			System.out.println("上传到本地结束");
            //json对象        {"fileName":"lhafba15bcf93c4580ba3a96cd39ff2b39-测试上传.pptx","result":"OK"}
			String jsonObjectSuccess="{\"fileName\":"+"\""+fileName+"\""+",\"result\":\"OK\"}";
			return jsonObjectSuccess;
		} catch (Exception e) {
			e.printStackTrace();
			String jsonObjectError="{\"result\":\"NO\"}";
			return jsonObjectError;
		}
	}

	
	/**
	 * 从本地下载文件的接口
	 * @param fileName
	 * @param request
	 * @param fileLocalPath
	 * @return
	 */
	public static ResponseEntity<byte[]> downloadFromLocal(String fileName,HttpServletRequest request,String fileLocalPath){
		//一般用ResponseEntity来处理文件下载：1.获得文件    2.把文件转换为二进制    3.设置HttpHeaders的响应标头的一些基本属性
		
		/*
		 * 1和2：获得指定文件的byte数组  buffer
		 */
		//缓冲器buffer用来接收文件内容    byte[]表示二进制文件
		byte[] buffer = null;
		//headers：{}  HttpHeaders类：表示HTTP请求和响应头，把字符串头名映射到字符串值的列表
		HttpHeaders headers = new HttpHeaders();  
		try {
			//File.separator：\    
			File file = new File(fileLocalPath + File.separator + fileName);
			//FileInputStream文件输入流，是用来读数据的     FileOutputStream输出流，是用来写文件的
			//把该文件加入到输入流中
			FileInputStream fis = new FileInputStream(file);
			//定义了一个字节数组，数组长度为1024，即最多可以存1024个字节的东西，若超出这个值就会报溢出的异常
			byte[] b = new byte[1024];
			//字节数组输出流    两个数组长度一样都设置为1024
			ByteArrayOutputStream bos = new ByteArrayOutputStream(1024);
			int n;
			
			//读该指定文件，每读1024B=1K就向外写出一次，从第0个字节写到第n个字节
			//(n = fis.read(b)) != -1  读到文件尾，先把fis读取的流值赋值给n，再判断是否等于-1
			//如果fis.read还有值，那n>0，那就为true，就会读一次流
			while ((n = fis.read(b)) != -1) {
				bos.write(b, 0, n);   //输出读到的内容
			}
			
			//创建了流，最后一定要关闭流
			fis.close();
			bos.close();
			//把读到的内容(该指定文件的内容)--->byte[]即二进制文件
			buffer = bos.toByteArray();
			
			
			/**
			 * 3：处理响应
			 */
			int index = fileName.indexOf("-");
			fileName = fileName.substring(index + 1);
			//fileName="通用文件名.ppt";
			//下载文件名中含有中文的处理
			//获取是哪种浏览器，IE9之前包括IE9都包含MSIE;IE10之后都包含Trident;edge浏览器包含Edge
			String browserInfo=request.getHeader("User-Agent");
			if (browserInfo.contains("MSIE") || browserInfo.contains("Trident")
					||browserInfo.contains("Edge")) {
				//IE浏览器的处理   通过URLEncoder对fileName进行UTF-8编码   jy哈哈.pptx--->jy%E5%93%88%E5%93%88.pptx
				fileName = java.net.URLEncoder.encode(fileName, "UTF-8").replaceAll("\\+", "%20");
			} else {
				// 非IE浏览器的处理      通过字节转换成ISO-8859-1        jy哈哈.pptx--->jyåå.pptx
				fileName = new String(fileName.getBytes("UTF-8"), "ISO-8859-1");
			}
			//设置响应文件头    指定客户端下载的文件名
			headers.setContentDispositionFormData("attachment", fileName);
			//设置响应文件内容类型  application/octet-stream  二进制流数据（如常见的文件下载）
			headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
			//ResponseEntity该类实现文件数据(以字节存储)，响应头，状态封装在一起交给浏览器处理，以实现浏览器的文件下载
			return new ResponseEntity<byte[]>(buffer, headers, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	
	
	
}
