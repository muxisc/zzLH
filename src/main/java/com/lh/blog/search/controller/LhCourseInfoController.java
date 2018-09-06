package com.lh.blog.search.controller;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.core.web.annotation.RepeatSubmit;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;
import com.lh.blog.search.model.LhCourseInfo;
import com.lh.blog.search.service.ILhCourseInfoService;

import net.sf.json.JSONArray;

/**
 * 描述:    lh_course_info 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2018年02月06日
 */
@Controller
@RequestMapping("/lh/uploadAndDownload/")
public class LhCourseInfoController extends BaseController {
	private static final Logger logger=LoggerFactory.getLogger(LhCourseInfoController.class);
	
	@Autowired
	private ILhCourseInfoService lhCourseInfoService;
	
	
	
	/**
	 * 进入上传和下载的页面
	 * @return
	 */
	@RequestMapping("showLoadPage")
	public String showLoadPage() {
		return "uploadAndDownload/course_info_list";
	}
	
	/**
	 * 获取课件分页列表
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("doGetLoadPage")
	@ResponseBody
	public PageResponse<LhCourseInfo> doGetLoadPage(PageRequest request) throws Exception{
		List<LhCourseInfo> lhCourseInfoList= lhCourseInfoService.doGetLoadPage(request);
		return new PageResponse<>(lhCourseInfoList);
	}
	
	/**
	 * 进入视频/音频/PPT上传页面
	 * @return
	 */
	@RequestMapping("enterUploadPage")
	public String enterUploadPage() {
		return "uploadAndDownload/upload/upload_course";
	}
	
	
	/**
	 * 上传接口(兼容IE8)
	 * @param files
	 * @param fileName
	 * @return
	 */
	//produces解决传输json到页面出现中文乱码问题
	@RequestMapping(value="upload",method=RequestMethod.POST,produces="text/html;charset=UTF-8")
	@ResponseBody
	public String upload(@RequestParam(value="btnFile") MultipartFile files,String fileName) throws Exception{
		return lhCourseInfoService.uploadFile(files, fileName);
	}
	
	/**
	 * 下载文件
	 * @param fileName
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("download")
	public ResponseEntity<byte[]> download(String fileName)throws Exception{
		//在下载文件时，是用byte数组作临时的缓冲器接收文件内容
		//SpringMVC使用ResponseEntity来处理文件下载：1.获得文件    2.把文件转换为二进制    3.设置HttpHeaders的一些基本属性
		return lhCourseInfoService.download(fileName);
	}
	
	
	/**
	 * 打包下载
	 * @param fileNameArray
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("downloadAll")
	public ResponseEntity<byte[]> downloadAll(String fileNameArray)throws Exception{
       return lhCourseInfoService.downloadAll(fileNameArray);
	}
	
	
	/**
	 * 把页面的数据用excel导出
	 * @param response
	 * @throws Exception
	 */
    @RequestMapping("exportDataToExcel")
    @ResponseBody
    @RepeatSubmit
	public void exportDataToExcel(HttpServletResponse response)throws Exception {
    	lhCourseInfoService.exportDataToExcel(response);
	}
	
	
	/**
	 * 新增课程
	 * @param lhCourseInfo
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value="addCourseInfo",method=RequestMethod.POST)
	@ResponseBody
	public AjaxResult addCourseInfo(@RequestBody LhCourseInfo lhCourseInfo) throws Exception {
		if(lhCourseInfoService.addCourseInfo(lhCourseInfo)>0) {
			return AjaxResult.success("新增成功");
		}
		return AjaxResult.error("新增失败");
	}
	
	
	
	
}