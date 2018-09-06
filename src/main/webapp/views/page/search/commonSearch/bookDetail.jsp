<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE>
<html>
<head>
	<title>详情</title>
	<link rel="stylesheet" href="<c:url value='/views/css/vendor/dataTables.bootstrap.min.css'/>">
	<link rel="stylesheet" href="<c:url value="/views/css/system/style.css"/>" />
	<link rel="stylesheet" href="<c:url value='/views/js/lib/pagination/pagination.css'/>">
    <style type="text/css">
       .basemsg{
           width: 70%;
           margin-top: 90px;
           margin-left: 30px;
           font-size: 15px;
       }
    </style>
</head>
<body>
<div class="iframe-wrap">
	<div class="form-panel pdlr30" style="width: auto;">
		<div style="position: fixed; background-color: white; width: 96%;margin-top:-30px; z-index: 10;">
			<div style="width:96%;height:30px;backgroud-color:white"></div>
			<div class="company-info-new">
			
			
					<span class="goback icon-return"></span>


		            <p class="mb10">
		                <span id="partyName" class="tit">${lhBook.bookName }</span>
		                <a class="company-stu-2">${lhBook.bookState }</a>
		            </p>
		            <p class="credit-info-p">
		                <i class="icon-sm icon-xydm"></i>书籍编号：<span>${lhBook.bookNumber }</span>
		                <i class="icon-sm icon-fr"></i>作者：<span>${lhBook.author }</span>
		            </p>
		    </div>
			<div class="company-tab-new">
				<ul>
					<li class="current tab" name="basic"><a href="javascript:void(0)">书籍简介</a></li>
				</ul>
			</div>
		</div>
    </div>
</div>
<div class="basemsg">
			${lhBook.bookDesc }	
</div>
<script src="<c:url value='/views/js/lib/require.js'/>"></script> 
<script src="<c:url value='/views/js/config.js'/>"></script> 
<script src="<c:url value='/views/js/search/commonSearch/bookDetail.js'/>"></script> 
</body>
</html>


