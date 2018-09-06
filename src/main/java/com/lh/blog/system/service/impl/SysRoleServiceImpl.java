package com.lh.blog.system.service.impl;

import com.icinfo.framework.core.exception.BusinessException;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.lh.blog.system.dto.SysRoleDto;
import com.lh.blog.system.mapper.SysRoleMapper;
import com.lh.blog.system.mapper.SysRolePermisionMapper;
import com.lh.blog.system.model.SysRole;
import com.lh.blog.system.model.SysRolePermision;
import com.lh.blog.system.service.ISysRolePermisionService;
import com.lh.blog.system.service.ISysRoleService;
import com.lh.blog.util.UUIDUtils;

import static org.apache.commons.lang3.StringUtils.isEmpty;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 描述:    sys_role 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年10月17日
 */
@Service
public class SysRoleServiceImpl extends MyBatisServiceSupport implements ISysRoleService {

	@Autowired
	private SysRoleMapper sysRoleMapper;
	@Autowired
	private SysRolePermisionMapper sysRolePermisionMapper;
	@Autowired
	private ISysRolePermisionService sysRolePermisionService;
	
	/**
	 * 获取所有角色
	 */
	public List<SysRole> getAllRoles() {
		return sysRoleMapper.getAllRoles();
	}

	/**
	 * 获取分页角色
	 */
	@Override
	public List<SysRole> getPageRoles(PageRequest request) {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		return sysRoleMapper.getAllRoles();
	}

	/**
	 * 新增角色和保存角色-权限关系
	 */
	@Override
	public int insertRole(SysRoleDto sysRole) throws Exception {
		String uuid=UUIDUtils.randomUUID();
		sysRole.setUid(uuid);
		sysRoleMapper.insert(sysRole);
		String[] permisionIds=sysRole.getPermisions();
		if(permisionIds.length>0) {
			for(String permisionId:permisionIds) {
				SysRolePermision sysRolePermision=new SysRolePermision();
				sysRolePermision.setRp_role_id(uuid);
				sysRolePermision.setRp_permision_id(permisionId);
				sysRolePermisionMapper.insert(sysRolePermision);
			}
		}
		return 1;
	}

	/**
	 * 根据uid查询角色
	 */
	@Override
	public SysRole getRoleByUid(String uid) {
		Map<String,Object> qryMap=new HashMap<String,Object>();
		qryMap.put("uid", uid);
		List<SysRole> roleList=sysRoleMapper.getRoleByUid(qryMap);
		if(roleList.size()>0) {
			return roleList.get(0);
		}
		return null;
	}

	/**
	 * 通过uid编辑角色
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public int updateByUid(SysRoleDto sysRole,String[] permisions) throws Exception{
		if(isEmpty(sysRole.getUid())) {
			throw new BusinessException("修改失败，该角色不存在");
		}
		if(permisions==null||permisions.length==0) {
			throw new BusinessException("修改失败，请至少选择一项权限");
		}
		//删除旧权限
		sysRolePermisionService.deleteByRoleId(sysRole.getUid());
		//增加新权限
		sysRolePermisionService.insertRolePermisions(convert(sysRole.getUid(), permisions));
		//修改角色
		return sysRoleMapper.updateByPrimaryKeySelective(sysRole);
		//编辑角色的名称和描述
		/*Example example=new Example(SysRole.class);
		example.createCriteria().andEqualTo("uid", sysRole.getUid());
		sysRoleMapper.updateByExampleSelective(sysRole, example);*/
		
		//编辑角色的权限  先删除原后增加新的
		/*Example examplePer=new Example(SysRolePermision.class);
		examplePer.createCriteria().andEqualTo("rp_role_id", sysRole.getUid());
		sysRolePermisionMapper.deleteByExample(examplePer);
		String[] permisionIds=sysRole.getPermisions();
		if(permisionIds.length>0) {
			for(String permisionId:permisionIds) {
				SysRolePermision sysRolePermision=new SysRolePermision();
				sysRolePermision.setRp_role_id(sysRole.getUid());
				sysRolePermision.setRp_permision_id(permisionId);
				sysRolePermisionMapper.insert(sysRolePermision);
			}
		}
		return 1;*/
	}

	/**
	 * 删除角色
	 */
	@Override
	public int deleteByUid(String uid) {
		Example example=new Example(SysRole.class);
		example.createCriteria().andEqualTo("uid", uid);
		sysRoleMapper.deleteByExample(example);
		//删除角色的所有权限
		Example examplePer=new Example(SysRolePermision.class);
		examplePer.createCriteria().andEqualTo("rp_role_id", uid);
		sysRolePermisionMapper.deleteByExample(examplePer);
		
		return 1;
	}

	
	/**
	 * 通过角色名获取角色
	 */
	@Override
	public List<SysRole> getRoleByName(Map<String, Object> qryMap) {
		return sysRoleMapper.getRoleByName(qryMap);
	}

	/**
	 * 新增角色和新增角色权限关系
	 */
	@Override
	public int insertRolePer(SysRoleDto sysRole, String[] permisions) throws Exception {
		if(permisions==null || permisions.length==0) {
			throw new BusinessException("新增角色失败，请至少选择一项权限");
		}
		/*System.out.println("*****"+sysRole.getUid());*/
		//新增角色
		if(sysRoleMapper.insert(sysRole)<=0) {
			throw new BusinessException("新增角色失败");
		}
		//实体SysRole中的属性uid有@Before,在插入前给其setUid了，故第二个输出uid有值
		/*System.out.println("@@@@@@"+sysRole.getUid());*/
		//新增角色-权限关系
		List<SysRolePermision> sysRolePerList=convert(sysRole.getUid(), permisions);
		sysRolePermisionService.insertRolePermisions(sysRolePerList);
		return 1;
	}
	
	/**
	 * 数据转换
	 * @return
	 */
	private List<SysRolePermision> convert(String roleId,String[] permisions){
		List<SysRolePermision> rolePerList=new ArrayList<SysRolePermision>();
		for(String permision:permisions) {
			SysRolePermision sysRolePermision=new SysRolePermision();
			sysRolePermision.setRp_role_id(roleId);
			sysRolePermision.setRp_permision_id(permision);
			rolePerList.add(sysRolePermision);
		}
		return rolePerList;
	}
}