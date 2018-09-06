<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>视频/音频/PPT上传</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/views/css/system/style.css"/>"/>
</head>
<body>
<br/><br/><br/><br/>
<div class="iframe-wrap">
    <div class="form-panel">
        <form class="form-horizontal" id="hxForm">
        			<div class="form-item clearfix mr20">
						
						<div class="col-6">
						    <label class="item-name col-5">课程名称：</label>
							<div class="col-5">
								<div class="ipt-box">
									<input type="text" class="ipt-txt" value="" name="courseName"/>
								</div>
							</div>
						</div>
					</div>
					<br>
					<div class="form-item clearfix mr20">
						<div class="col-6">
							<label class="item-name col-5">课程形式：</label>
							<div class="col-5">
								<div class="ipt-box" style="padding-top: 5px;">
								   <input type="radio" value="0" name="courseForm" checked="checked"/>视频
						           <input type="radio" value="1" name="courseForm" />音频
						           <input type="radio" value="2" name="courseForm" />PPT
								</div>
							</div>
						</div>
					</div>
					<br/> 
					<div class="form-item clearfix mr20">
						<div class="col-10">
							<label class="item-name col-3">课程简介：</label>
							<div class="col-9">
								<div class="ipt-box">
									<textarea type="text" class="ipt-txt" value="" name="briefInfo" style="height: 70px;"></textarea>
								</div>
							</div>
						</div>
						<div class="col-4">
						</div>
					</div>
         <br/>  
         
      	  
        <div class="complaint-files-select clearfix">
            <div class="col-9 ipt-box mr5">
                <!-- 选择课程文件前的输入框 -->
                <input type="text" id="fileName" class="ipt-txt clx"  value="" readonly="readonly">
                <input type="hidden" id="filePath" name="filePath" value="">
            </div>
            <div class="file-box col-2" style="width:20%;">
                <span id="uploadFile">
                <!--上传文件(从本地上传到服务器)：1.type="file" 2.spring-mvc.xml中配置文件上传-->
                <!-- name="btnFile" 对应后台 (@RequestParam(value="btnFile") MultipartFile files) -->
                <input type="file" id="btnFile" class="btnFile  w-80" name="btnFile">
                
                </span>
                <button type="button" class="fl btn w-80">选择课程文件</button>
            </div>
      	</div>
      	
        <div class="center mb20">
            <input type="submit" value="上传" class="btn">
            <input type="button" id="close" value="取消" class="btn">
        </div>
        </form>
        <div style="margin-left: 80px;">注：</div>
        <div style="color:red;margin-left: 100px;">1.封面图片非必传项。</div>
        <div style="color:red;margin-left: 100px;">2.封面图片建议尺寸为220*160。</div>
    </div>
</div>
<!-- 通用页面 -->
<jsp:include page="../common/common.jsp"/>
<script src="<c:url value='/views/js/uploadAndDownload/upload/upload_course.js'/>"></script>
</body>
</html>