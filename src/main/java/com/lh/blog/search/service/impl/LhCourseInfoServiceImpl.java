package com.lh.blog.search.service.impl;

import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.lh.blog.search.mapper.LhCourseInfoMapper;
import com.lh.blog.search.model.LhCourseInfo;
import com.lh.blog.search.service.ILhCourseInfoService;
import com.lh.blog.util.FileUtil;
import com.lh.blog.util.RequestUtil;
import com.lh.blog.util.UUIDUtils;

import net.sf.json.JSONArray;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * 描述:    lh_course_info 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2018年02月06日
 */
@Service
public class LhCourseInfoServiceImpl extends MyBatisServiceSupport implements ILhCourseInfoService {

	@Autowired
	private LhCourseInfoMapper lhCourseInfoMapper;
	
	//1.在spring.xml中加载属性文件spring.properties   2.spring.properties中：filePath=
	@Value("${filePath}")
	private String fileLocalPath;
	
	/**
	 * 获取课件分页列表
	 */
	@Override
	public List<LhCourseInfo> doGetLoadPage(PageRequest request) throws Exception {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		return lhCourseInfoMapper.doGetLoadPage(request.getParams());
	}

	/**
	 * 用Java Poi实现数据的Excel导出
	 * @throws Exception 
	 */
	@Override
	public void exportDataToExcel(HttpServletResponse response) throws Exception {
		/**
		 * Java Poi导出Excel
		 * Poi提供API给Java程序对Office格式文档  读和写的功能
		 * 使用Poi来生成Excel，之后使用Stream的方式输出到前台直接下载，也可以生成到服务器中再下载
		 */
		
		//1.创建一个workbook工作簿,对应一个Excel文件
		HSSFWorkbook workbook=new HSSFWorkbook();
		
		//2.在workbook中添加一个sheet表格,对应Excel文件中的sheet
		HSSFSheet sheet=workbook.createSheet("sf");
		
		sheet.setDefaultColumnWidth(30);   //设置默认列宽
		
		//3.在sheet中添加表头第0行，注意老版本poi对Excel的行数列数有限制short
		HSSFRow row=sheet.createRow(0);
		
		//生成一个样式
		HSSFCellStyle style=workbook.createCellStyle();  
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);    //设置一个居中格式
		
		
		//4.创建单元格，并设置表头的值，设置表头居中
		HSSFCell cell=row.createCell(0);    //创建一个单元格      第0行的第1列 
		cell.setCellValue("序号");
		cell.setCellStyle(style);
		
		cell=row.createCell(1);
		cell.setCellValue("课程名称");
		cell.setCellStyle(style);
		
		cell=row.createCell(2);
		cell.setCellValue("课程形式");
		cell.setCellStyle(style);
		
		//5.去数据库中查询页面的数据     遍历集合数据，产生数据行
		Map<String,Object> qryMap=new HashMap<String,Object>();
		List<LhCourseInfo> dataList=lhCourseInfoMapper.doGetLoadPage(qryMap);
		for(int i=0;i<dataList.size();i++) {
			LhCourseInfo dataOne=dataList.get(i);
			String courseName=dataOne.getCourseName();
			String courseForm=dataOne.getCourseForm();
			if("2".equals(courseForm)) {
				courseForm="PPT";
			}
			
			row=sheet.createRow(i+1);     //row 行
			//6.创建单元格，并设置值
			row.createCell(0).setCellValue(i+1);
			row.createCell(1).setCellValue(courseName);
			row.createCell(2).setCellValue(courseForm);
		}
		//自动调整列宽    让列宽随着导出的列长自动适应
		sheet.autoSizeColumn(0);
		sheet.autoSizeColumn(1);
		sheet.autoSizeColumn(2);
		
		
		OutputStream outputStream=null;
		try {
			//让浏览器知道要保存的是Excel文件
			response.setContentType("application/vnd.ms-excel");
			//设置指定下载的文件名：课程列表_sf.xls
			response.setHeader("Content-Disposition", 
					"attachment;filename="+
			URLEncoder.encode("课程列表_sf"+".xls", "utf-8"));
			response.setCharacterEncoding("UTF-8");
			
			//out：与输出设备关联的流对象，可以将Excel文档导出到本地或者网络中
			outputStream=response.getOutputStream();
			//7.将生成的Excel文件输出到客户端浏览器
			workbook.write(outputStream);
			
			/**
			 * 把生成的Excel文件写在输出流里边
			 * 1.输出流是response得到的，然后向response容器中写入字节数据，即该文件，最后客户端会去response容器中获取数据文件
			 * 2.输出流是FileOutputStream
			 */
			
			//7.或把文件保存到指定位置
			/*FileOutputStream fos=new FileOutputStream("D:\\Users\\lh\\workspace\\zzLH\\src\\main\\webapp\\views\\export\\指定课程列表_sf.xls");
			workbook.write(fos);
			fos.close();*/
			
		}catch(Exception e) {
			e.printStackTrace();
			throw new Exception("数据导出Excel失败");
		}finally{
			//关闭流
			if(outputStream!=null) {
				outputStream.close();
			}
		}
	}

	
	
	/**
     * 下载文件
     */
	@Override
	public ResponseEntity<byte[]> download(String fileName) throws Exception {
		//String fileLocalPath="D:\\Users\\lh\\workspace\\zzLH\\src\\main\\webapp\\views\\upload";
		return FileUtil.downloadFromLocal(fileName, RequestUtil.getRequest(), fileLocalPath);
	}
	
	
	
	/**
	 * 打包下载
	 * @param fileNameArray    '["a.ppt","b.xlsx"]'
	 */
	@Override
	public ResponseEntity<byte[]> downloadAll(String fileNameArray) throws Exception {
		//传递的参数fileNameArray：[&quot;a.ppt&quot;,&quot;b.xlsx&quot;]  后台会把"转换成&quot;，故需转换
		fileNameArray= fileNameArray.replaceAll("&quot;","\"");
		//json字符串--->json数组
		JSONArray jsonArray=JSONArray.fromObject(fileNameArray);
		
		//1.创建一个压缩文件临时路径，即新建一个zip文件
		String zipName="该页所有课程.zip";
		String zipRealPath=fileLocalPath+"/"+zipName;
		
		try {    
            File tmpZip=new File(fileLocalPath);  
            if (!tmpZip.exists())  
                tmpZip.mkdirs();  
            File tmpZipFile = new File(zipRealPath);  
            if (!tmpZipFile.exists())  
                tmpZipFile.createNewFile();     //创建了一个压缩文件：该页的所有课程.zip
            
            //创建一个新的zip输出流
            FileOutputStream fos=new FileOutputStream(zipRealPath);
            ZipOutputStream out = new ZipOutputStream(fos);    
            
            //2.需要同时下载即打包的两个文件a.ppt ，b.xlsx    
            File[] allFile =new File[jsonArray.size()] ;      //[null,....]
            //把一个个文件给放到allFile数组中
            for(int i=0;i<jsonArray.size();i++){  
            	allFile[i]=new File(jsonArray.get(i)+"");  
            }  
            for (int i = 0; i < allFile.length; i++) { 
            	//fis含有真正需要下载的文件内容
                FileInputStream fis = new FileInputStream(fileLocalPath+"/"+allFile[i]);    
                
                //在该页的所有课程.zip压缩包下，创建一个个子目录，文件名为getName()
                ZipEntry zipEntry=new ZipEntry(allFile[i].getName());
                out.putNextEntry(zipEntry);      //这里只是创建了一个子目录，文件里面并没有真正的内容，下面的write才是把内容放进去
                
                //设置压缩文件内的字符编码，不然会变成乱码    
                //out.setEncoding("UTF-8"); 
                
                int len;    
                //3.读入需要下载的文件的内容，打包到zip文件 ，即把a.ppt和b.xlsx多个文件打包到该页的所有课程.zip中  
                byte[] buffer = new byte[1024]; 
                while ((len = fis.read(buffer)) > 0) {    
                    out.write(buffer, 0, len);    
                }    
                //4.关闭流
                out.closeEntry();    
                fis.close();    
            }
            //关闭流
            out.close();    
        } catch (Exception e) {    
            e.printStackTrace();  
        } 
		//3.或把打包好的压缩包传递给浏览器，让浏览器下载该压缩包
		return this.download(zipName);
	}
	
	/**
	 * 上传文件
	 */
	@Override
	public String uploadFile(MultipartFile files, String fileName) throws Exception {
		//这是该项目下的一个指定文件夹upload   上传到本地的文件夹
		//String fileLocalPath="D:\\Users\\lh\\workspace\\zzLH\\src\\main\\webapp\\views\\upload";
		//这是tomcat下的一个指定文件夹upload  上传到本地的tomcat服务器
		//String fileLocalPath="E:\\apache-tomcat-8.5.20-windows-x64\\apache-tomcat-8.5.20\\webapps\\zzLH\\views\\upload";
		String needFileName=getNeedFileName(fileName);
		
		//files该文件   needFileName包装过的文件名   fileLocalPath想把该文件保存到这个文件夹下(指定路径)
		return FileUtil.uploadToLocal(files, needFileName, fileLocalPath);
	}
	
	/**
	 * 处理文件名
	 * @param fileName
	 * @return
	 */
	private String getNeedFileName(String fileName) {
		fileName=fileName.replaceAll("\\\\", "/");
		fileName="lh"+UUIDUtils.randomUUID()+"-"+fileName;
		return fileName;
	}


	/**
	 * 新增课程
	 */
	@Override
	public int addCourseInfo(LhCourseInfo lhCourseInfo) throws Exception {
		lhCourseInfo.setCreateTime(new Date());
		return lhCourseInfoMapper.insert(lhCourseInfo);
	}

    /**
     * 通过uid获取课程
     */
	@Override
	public LhCourseInfo getByUid(String uid) throws Exception {
		return lhCourseInfoMapper.selectByPrimaryKey(uid);
	}



	
}