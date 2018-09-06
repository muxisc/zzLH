package com.lh.blog.system.service.impl;

import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.lh.blog.system.mapper.LhTestGeneratorMapper;
import com.lh.blog.system.model.LhTestGenerator;
import com.lh.blog.system.service.ILhTestGeneratorService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:    lh_test_generator 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年10月16日
 */
@Service
public class LhTestGeneratorServiceImpl extends MyBatisServiceSupport implements ILhTestGeneratorService {

	/**
	 * 日志记录器
	 */
	private static final Logger logger=LoggerFactory.getLogger(LhTestGeneratorServiceImpl.class);
	
	
	@Autowired
	private LhTestGeneratorMapper lhTestGeneratorMapper;
	
	@Override
	public int insertGen(LhTestGenerator gen) {
		return lhTestGeneratorMapper.insertSelective(gen);
	}
}