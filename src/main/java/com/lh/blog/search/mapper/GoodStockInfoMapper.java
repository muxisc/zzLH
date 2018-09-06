/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 * 描述: TODO <br/>
 *
 * @author framework generator
 * @date 2018年04月27日
 * @version 2.0
 */
package com.lh.blog.search.mapper;

import java.util.List;
import java.util.Map;

import com.icinfo.framework.mybatis.mapper.common.Mapper;
import com.lh.blog.search.model.GoodStockInfo;

/**
 * 描述:    goodstockinfo 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2018年04月27日
 */
public interface GoodStockInfoMapper extends Mapper<GoodStockInfo> {
	
	public List<GoodStockInfo> selectAllUsers(Map<String,Object> request);
}