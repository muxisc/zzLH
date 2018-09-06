package com.lh.blog.system.service;

import java.util.List;

import com.icinfo.framework.core.service.BaseService;
import com.lh.blog.system.model.SysPermision;

/**
 * 描述:    sys_permision 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2017年10月17日
 */
public interface ISysPermisionService extends BaseService {
	
	/**
	 * 查询当前用户的权限列表
	 * @param userId
	 * @return
	 */
	public List<SysPermision> selectUserPermisions(String userId);
	
	/**
	 * 查询所有权限资源
	 * @return
	 */
	public List<SysPermision> selectAllPermisions();
	
	/**
	 * 通过主键uid查询该权限
	 * @param uid
	 * @return
	 */
	public SysPermision selectByUid(String uid);
	
	/**
	 * 新增权限
	 * @return
	 */
	public int insertPermision(SysPermision sysPermision);
	
	/**
	 * 修改权限
	 * @param sysPermision
	 * @return
	 */
	public int updatePermision(SysPermision sysPermision);

	/**
	 * 删除权限
	 * @param uid
	 * @return
	 */
	public int deletePermision(String uid) throws Exception;
	
	/**
	 * 判断该权限有无子权限
	 * @param parentId
	 * @return
	 */
	public Boolean isHasSub(String parentId) throws Exception;
	
	
}