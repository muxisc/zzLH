package com.lh.blog.system.service.impl;

import com.icinfo.framework.core.exception.BusinessException;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.lh.blog.system.mapper.SysRolePermisionMapper;
import com.lh.blog.system.model.SysRolePermision;
import com.lh.blog.system.service.ISysRolePermisionService;

import static org.apache.commons.lang3.StringUtils.isEmpty;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 描述:    sys_role_permision 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年10月17日
 */
@Service
public class SysRolePermisionServiceImpl extends MyBatisServiceSupport implements ISysRolePermisionService {

	@Autowired
	private SysRolePermisionMapper sysRolePermisionMapper;
	
	/**
	 * 获取该角色的所有权限id
	 */
	@Override
	public List<SysRolePermision> getByRoleId(String roleId) {
		Map<String,Object> qryMap=new HashMap<String,Object>();
		qryMap.put("rp_role_id", roleId);
		return sysRolePermisionMapper.getByRoleId(qryMap);
	}

	/**
	 * 新增角色-权限关系
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public int insertRolePermisions(List<SysRolePermision> sysRolePers) throws Exception {
		/*
		 * Spring中的@Transactional(rollbackFor = Exception.class)事务处理，
		 * 当你的方法中抛出异常时，它会将事务回滚，数据库中的数据将不会改变，也就是回到进入此方法前的状态。
		 */
		for(SysRolePermision sysRolePer:sysRolePers) {
			if(sysRolePermisionMapper.insert(sysRolePer)<=0) {
				throw new BusinessException("新增角色权限关系失败");
			}
		}
		return sysRolePers.size();
	}

	/**
	 * 删除角色权限
	 */
	@Override
	public int deleteByRoleId(String roleId) throws Exception {
		if(isEmpty(roleId)) {
			return 0;
		}
		Example example=new Example(SysRolePermision.class);
		example.createCriteria().andEqualTo("rp_role_id", roleId);
		return sysRolePermisionMapper.deleteByExample(example);
	}
}