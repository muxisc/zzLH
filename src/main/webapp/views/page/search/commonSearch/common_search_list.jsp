<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="renderer" content="webkit">
<title>综合搜索结果列表</title>
<link rel="stylesheet" href="<c:url value='/views/css/system/style.css'/>">
<link rel="stylesheet" href="<c:url value='/views/js/lib/pagination/pagination.css'/>">
</head>
<body>
 <div class="tax-search">
        <div class="tax-seart-form clearfix">
            <form id="hx-form">
            	<input type="hidden" id="keywordType" name="keywordType"/>
                <input type="text" id="keyword" name="keyword" class="tax-write" placeholder="请输入书名、书籍编号、作者、地址等信息搜索" value="${keyword}">
                <input type="button" id="search" class="tax-s-btn" value="搜索">
            </form>
        </div>

        <div class="tax-search-content">
            <div class="search-select">
                <a class="cur search-select-a" href="javascript:void(0)" data-val="">全部</a>
                <a class="search-select-a" href="javascript:void(0)" data-val="武侠小说">武侠小说</a>
                <a class="search-select-a" href="javascript:void(0)" data-val="青春校园">青春校园</a>
                <a class="search-select-a" href="javascript:void(0)" data-val="温暖亲情">温暖亲情</a>
            </div>
            <div class="search-result-list">
            
                <div id="search-tip"></div>
                
                <div class="sea-re-list">
                    <ul id="rstList">
                    
                    
                    </ul>
                </div>
                <div class="notice-pagination-box clearfix">
	                <div id="pageforhide">
	                    <span class="items-page" id="items-page">每页
	                    <select id='pageLength' class="form-control-inline">
	                        <option value="5" selected>5</option>
	                        <option value="10">10</option>
	                        <option value="15">15</option>
	                        <option value="20">20</option>
	                    </select>条
	                    </span>
	                    <span class="page-total">共<em id="notice-total"></em>条数据</span>
	                    <div id="pagination" class="pagination">
	
	                    </div>
	                </div>
	            </div>
            </div>
        </div>
    </div>

<script id="rstList-template" type="text/x-handlebars-template">
 {{#each data}}
    <li class="search-item">
	    <p class="com-name">
	       <span class="company-mc">
	       <a href="/zzLH/lh/search/bookDetail/{{uid}}">
	       {{bookName}}
	       </a>
	       </span>
	       <span class="statu-cx">{{bookState}}</span>
        </p>
	    <p class="com-item-msg">
	       <span><i class="icon-list_xydm"></i>书籍编号： <em>{{bookNumber}}</em></span>
		   <span><i class="icon-list_fr"></i>作者：<em>{{author}}</em></span>
		   <span><i class="icon-list_date"></i>出版日期：<em>{{publishDate}}</em></span>
        </p>
		<p class="com-item-msg">
		   <span><i class="icon-list_lj"></i>注册地址：<em>{{address}}</em></span>
		</p>
		<p class="com-item-jj">作者简介： {{authorDesc}} </p>
		<p class="com-item-jj">书籍类型：{{bookType}}</p>
	</li>
 {{/each}}
</script>
    <script src="<c:url value='/views/js/lib/require.js'/>"></script>
    <script src="<c:url value='/views/js/config.js'/>"></script>
	<script src="<c:url value='/views/js/search/commonSearch/common_search_list.js'/>"></script>
</body>
</html>
