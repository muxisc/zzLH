package com.lh.blog.system.service.impl;

import com.icinfo.framework.core.exception.BusinessException;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.lh.blog.system.mapper.SysUserRoleMapper;
import com.lh.blog.system.model.SysUserRole;
import com.lh.blog.system.service.ISysUserRoleService;

import static org.apache.commons.lang3.StringUtils.isEmpty;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:    sys_user_role 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年10月17日
 */
@Service
public class SysUserRoleServiceImpl extends MyBatisServiceSupport implements ISysUserRoleService {

	@Autowired
	private SysUserRoleMapper sysUserRoleMapper;
	
	/**
	 * 添加用户-角色关系
	 */
	@Override
	public int insertUserRole(List<SysUserRole> userRoles) {
		for(SysUserRole userRole:userRoles) {
			if(sysUserRoleMapper.insert(userRole)<=0) {
				throw new BusinessException("保存用户-角色关系失败");
			}
		}
		return userRoles.size();
	}

	/**
	 * 通过用户Id获取其角色Id
	 */
	@Override
	public List<SysUserRole> selectByUserId(String userId) {
		if(isEmpty(userId)) {
			return new ArrayList<SysUserRole>();
		}
		Example example=new Example(SysUserRole.class);
		example.createCriteria().andEqualTo("ur_user_id", userId);
		return sysUserRoleMapper.selectByExample(example);
	}

	/**
	 * 通过用户Id删除其角色
	 */
	@Override
	public int deleteUserRole(String userId) {
		if(isEmpty(userId)) {
			return 0;
		}
		Example example=new Example(SysUserRole.class);
		example.createCriteria().andEqualTo("ur_user_id",userId);
		return sysUserRoleMapper.deleteByExample(example);
	}
}