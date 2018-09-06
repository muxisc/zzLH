package com.lh.blog.system.service;

import com.icinfo.framework.core.service.BaseService;
import com.lh.blog.system.model.LhTestGenerator;

/**
 * 描述:    lh_test_generator 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2017年10月16日
 */
public interface ILhTestGeneratorService extends BaseService {
	
	
	public int insertGen(LhTestGenerator gen);
}