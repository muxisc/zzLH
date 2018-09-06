package com.lh.blog.search.controller;

import static org.apache.commons.lang3.StringUtils.isNotBlank;

import java.net.URLDecoder;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.mybatis.pagehelper.Page;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;
import com.lh.blog.search.model.LhBook;
import com.lh.blog.search.service.ILhBookService;
import com.lh.blog.util.RequestUtil;
import com.lh.blog.util.pagination.PageRequest;

/**
 * 描述:    lh_book 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2018年01月19日
 */
@Controller
@RequestMapping("/lh/search/")
public class LhBookController extends BaseController {
	private static final Logger logger=LoggerFactory.getLogger(LhBookController.class);
	
	@Autowired
	private ILhBookService lhBookService;
	
	
	/**
	 * 进入综合搜索页面
	 * @return
	 */
	@RequestMapping("commonSearch")
	public String commonSearch() {
		return "search/commonSearch/common_search";
	}
	
	/**
	 * 进入查询列表页面
	 * @return
	 */
	@RequestMapping("commonSearchList")
	public ModelAndView commonSearchList(String keyword)throws Exception {
		//关键字解码
		keyword=URLDecoder.decode(keyword, "UTF-8");
		ModelAndView model=new ModelAndView("search/commonSearch/common_search_list");
		model.addObject("keyword", keyword);
		return model;
	}
	
	/**
	 * 分页查询列表
	 * @param request
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("getBookList")
	@ResponseBody
	public PageResponse<LhBook> getBookList(@RequestParam Map<String,Object> qryMap) throws Exception{
		PageRequest request=RequestUtil.getMyPageParam(qryMap);
		//PageRequest request=RequestUtil.getMyPageParam(getRequest());
        List<LhBook> pageList=lhBookService.getPageList(request);
        int count=lhBookService.getListTotal(qryMap);
        //把pageList封装成Page的一个实例
        int pageSize = Integer.parseInt(qryMap.get("length").toString());
		int skipResult = Integer.parseInt(qryMap.get("start").toString());
        Page<LhBook> page=new Page<LhBook>(skipResult,pageSize);
        page.setTotal(count);
        page.addAll(pageList);
		return new PageResponse<LhBook>(page);
	}
	
	/**
	 * 进入详情页页面
	 * @return
	 */
	@RequestMapping("bookDetail/{uid}")
	public ModelAndView bookDetail(@PathVariable String uid) {
		ModelAndView model=new ModelAndView("search/commonSearch/bookDetail");
		if(isNotBlank(uid)) {
			LhBook lhBook=lhBookService.getOneByUid(uid);
			if(lhBook!=null) {
				model.addObject("lhBook", lhBook);
			}
		}
		return model;
	}
	
	
	
	
}