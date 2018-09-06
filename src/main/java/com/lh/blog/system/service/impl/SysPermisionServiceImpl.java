package com.lh.blog.system.service.impl;

import com.icinfo.framework.common.exception.GenericException;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.lh.blog.system.mapper.SysPermisionMapper;
import com.lh.blog.system.model.SysPermision;
import com.lh.blog.system.service.ISysPermisionService;

import static org.apache.commons.lang3.StringUtils.isBlank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:    sys_permision 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年10月17日
 */
@Service
public class SysPermisionServiceImpl extends MyBatisServiceSupport implements ISysPermisionService {

	
	@Autowired
	private SysPermisionMapper sysPermisionMapper;
	
	/**
	 * 查询当前用户 权限列表
	 */
	@Override
	public List<SysPermision> selectUserPermisions(String userId) {
		
		if(isBlank(userId)) {
			//如果返回值是SysPermision --> return null;
			return new ArrayList<SysPermision>();
		}
		
		Map<String,Object> map=new HashMap<>();
		map.put("userId", userId);
		//参数：map  返回值：list
		return sysPermisionMapper.selectUserPermisons(map);
	}

	/**
	 * 查询所有权限资源
	 */
	@Override
	public List<SysPermision> selectAllPermisions() {
		return sysPermisionMapper.selectAllPermisions();
	}

	
	/**
	 * 通过主键uid查询该权限
	 */
	@Override
	public SysPermision selectByUid(String uid) {
		return sysPermisionMapper.selectByPrimaryKey(uid);
	}

	/**
	 * 新增权限
	 */
	@Override
	public int insertPermision(SysPermision sysPermision) {
		if(sysPermision==null) {
			return 0;
		}
		return sysPermisionMapper.insert(sysPermision);
	}

	/**
	 * 修改权限
	 */
	@Override
	public int updatePermision(SysPermision sysPermision) {
		//不准修改权限父子关系
		sysPermision.setPermision_parent_id(null);
		//不准修改权限类型
		sysPermision.setPermision_type(null);
		return sysPermisionMapper.updateByPrimaryKeySelective(sysPermision);
	}

	/**
	 * 删除权限
	 */
	@Override
	public int deletePermision(String uid) throws Exception{
		if(isBlank(uid)) {
			throw new IllegalArgumentException("删除失败：uid不能为空");
		}
		if(isHasSub(uid)) {
			throw new GenericException("删除失败：存在子权限");
		}
		return sysPermisionMapper.deleteByPrimaryKey(uid);
	}

	/**
	 * 判断权限是否存在子权限
	 */
	@Override
	public Boolean isHasSub(String parentId) throws Exception{
		if(isBlank(parentId)) {
			//非法数据异常    运行时异常 编译时可不用捕获
			throw new IllegalArgumentException("参数错误，parentId不能为空");
		}
		Example example=new Example(SysPermision.class);
		example.createCriteria().andEqualTo("permision_parent_id", parentId);
		return sysPermisionMapper.selectCountByExample(example)>0;
	}

}