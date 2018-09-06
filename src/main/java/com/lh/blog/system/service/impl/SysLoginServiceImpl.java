package com.lh.blog.system.service.impl;

import static org.apache.commons.lang3.StringUtils.isBlank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icinfo.framework.security.shiro.LoginToken;
import com.icinfo.framework.security.shiro.ShiroSecurityService;
import com.icinfo.framework.security.shiro.UserProfile;
import com.lh.blog.system.dto.SysUserDto;
import com.lh.blog.system.model.SysPermision;
import com.lh.blog.system.service.ISysPermisionService;
import com.lh.blog.system.service.ISysUserService;


/**
 * 系统用户登陆
 * @author hzhb
 *
 */
@Service("sysLoginService")
public class SysLoginServiceImpl implements ShiroSecurityService {

	
	@Autowired
	private ISysUserService sysUserService;
	
	@Autowired
	private ISysPermisionService sysPermisionService;
	
	
	/**
	 * 用户身份认证服务
	 */
	@Override
	public UserProfile doGetUserProfile(LoginToken token) {
		
		SysUserDto sysUser=null;
		try {
			sysUser=sysUserService.selectByUsername(token.getUsername());
		} catch (Exception e) {
		}
		
		if(sysUser==null) {
			return null;
		}
		
		UserProfile userProfile=new UserProfile();
		//基本信息             5个都要有
		userProfile.setUserId(sysUser.getUid());
		userProfile.setUsername(sysUser.getUser_username());
		userProfile.setPassword(sysUser.getUser_password());
		userProfile.setRealName(sysUser.getUser_real_name());
		userProfile.setPasswordSalt(sysUser.getUser_password_salt());
		
		//获取当前用户的权限，即可访问的资源
		List<SysPermision> userPermisions=sysPermisionService.selectUserPermisions(sysUser.getUid());
		//权限
		Set<String> permisions=new HashSet<>();
		//菜单
		Map<String,List> menus=new HashMap<>();
		for(SysPermision permision:userPermisions) {
			permisions.add(permision.getPermision_url());
            if("1".equals(permision.getPermision_type())) {
            	if(isBlank(permision.getPermision_parent_id())) {
            		//根菜单
            		if(!menus.containsKey("-1")) {
        				menus.put("-1", new ArrayList<SysPermision>());
        			}
        			menus.get("-1").add(permision);
            	}else {
            		//子菜单
            		String parentId=permision.getPermision_parent_id();
            		if(!menus.containsKey(parentId)) {
            			menus.put(parentId, new ArrayList<SysPermision>());
            		}
            		menus.get(parentId).add(permision);
            	}
            }
			
		}
		
		userProfile.setMenus(menus);
		userProfile.setPermissions(permisions);
		return userProfile;
	}

	
	
	/**
	 * 加载所有动态业务权限资源
	 */
	@Override
	public Map<String, String> doGetDynamicPermisions() {
		Map<String,String> permisions=new HashMap<String,String>();
		
		return permisions;
	}

}
