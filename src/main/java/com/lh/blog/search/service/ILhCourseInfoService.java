package com.lh.blog.search.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.lh.blog.search.model.LhCourseInfo;

/**
 * 描述:    lh_course_info 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2018年02月06日
 */
public interface ILhCourseInfoService extends BaseService {
	
	/**
	 * 获取课程分页列表
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public List<LhCourseInfo> doGetLoadPage(PageRequest request)throws Exception;
	
	/**
	 * 上传文件
	 * @param files
	 * @param fileName
	 * @return
	 * @throws Exception
	 */
	public String uploadFile(MultipartFile files,String fileName)throws Exception;
	
	/**
	 * 下载文件
	 * @param fileName
	 * @return
	 * @throws Exception
	 */
	public ResponseEntity<byte[]> download(String fileName)throws Exception;
	
	/**
	 * 打包下载
	 * @param fileNameArray
	 * @return
	 * @throws Exception
	 */
	public ResponseEntity<byte[]> downloadAll(String fileNameArray)throws Exception;
	
	/**
	 * 数据Excel导出
	 * @param response
	 * @param session
	 */
	public void exportDataToExcel(HttpServletResponse response)throws Exception;
	
	/**
	 * 新增课程
	 * @param lhCourseInfo
	 * @return
	 * @throws Exception
	 */
	public int addCourseInfo(LhCourseInfo lhCourseInfo)throws Exception;
	
	/**
	 * 通过uid获取课程
	 * @param uid
	 * @return
	 * @throws Exception
	 */
	public LhCourseInfo getByUid(String uid)throws Exception;
}