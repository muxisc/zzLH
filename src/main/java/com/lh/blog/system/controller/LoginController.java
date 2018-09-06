package com.lh.blog.system.controller;



import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.security.shiro.LoginToken;
import com.icinfo.framework.security.shiro.UserProfile;
import com.icinfo.framework.tools.utils.DateUtils;
import com.lh.blog.system.dto.LoginDto;
import com.lh.blog.system.dto.SysUserDto;
import com.lh.blog.system.service.ISysUserService;


@Controller
@RequestMapping("/admin/")
public class LoginController extends BaseController {
	
	
	private static final Logger logger=LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	private ISysUserService sysUserService;
	
	
	/**
	 * 用户登陆验证
	 * @param session
	 * @param loginDto
	 * @param result
	 * @return
	 */
	@RequestMapping(value="login",method=RequestMethod.POST)
	@ResponseBody
	public AjaxResult loginCheck(HttpSession session,@Valid LoginDto loginDto,BindingResult result) {
		
		if(result.hasErrors()) {
			//Ajax请求两种结果1.AjaxResult.error("后台参数验证错误")2.AjaxResult.success("登录成功")
			AjaxResult error=AjaxResult.error("后台参数验证错误");
			error.addErrorInfo(result.getAllErrors());
			//后台显示注解校验错误的信息
			/*List<ErrorInfo> errors=error.getErrors();
			for(ErrorInfo errorOne:errors) {
				System.out.println(errorOne.getInfo());
			}*/
			return error;
		}
		
		try {
			SysUserDto sysUser = sysUserService.selectByUsername(loginDto.getUsername());
			if(sysUser ==null) {
				return AjaxResult.error("用户名错误，系统中没有该用户信息");
			}
			if(sysUser!=null && !"1".equals(sysUser.getUser_status())) {
				return AjaxResult.error("该用户已失效");
			}
			
			/**
			 * shiro安全框架：1.登录身份认证      2.权限认证
			 */
			Subject currentUser=SecurityUtils.getSubject();
			//登录追踪  UsernamePasswordToken令牌 得到loginToken(页面输入的用户名和密码)
			LoginToken loginToken=new LoginToken(loginDto.getUsername(),loginDto.getPassword());
			//开始进入shiro的认证流程
			currentUser.login(loginToken);
/**
 * 第二行：Subject subject = securityManager.login(this, token);
 * 第三行：info = authenticate(token);
 * 第七行：info = doAuthenticate(token);
 * doAuthenticate方法中：Collection<Realm> realms = getRealms();获取的realms在配置文件中
 * spring-shiro-single.xml:sysLoginService--->SysLoginServiceImpl方法：得到userProfile(数据库中的用户名和密码)
 * SecurityAuthorizingRealm：doGetAuthenticationInfo()方法：
 *      LoginToken loginToken = (LoginToken) token;
 *      UserProfile userProfile = shiroSecurityService.doGetUserProfile(loginToken); 去调用自己写的类SysLoginServiceImpl  
 *      loginToken和userProfile比较，即实现登录认证了   
 */
			//获取身份   其实就是所得的userProfile
			session.setAttribute("sysUserKey", currentUser.getPrincipal());
			session.setAttribute("sysUser", sysUser);
			//设置最后登录时间
			sysUser.setUser_last_login_time(DateUtils.getSysDate());
			sysUserService.updateByUsername(sysUser);
			
		} catch (Exception e) {
			System.out.println(loginDto.getUsername()+"........"+loginDto.getPassword());
			return AjaxResult.error("用户名或密码错误");
		}
		
		/**
		 * shiro提供了加解密
		 */
		/*//随机生成一个密码盐值
        String passwordSalt=new SecureRandomNumberGenerator().nextBytes().toHex();
        //原始密码是：123456
        SimpleHash hash= new SimpleHash("md5", "123456", passwordSalt, 2);
        //得加密密码，即数据库中保存的密码
        String password=hash.toHex();
        System.out.println("---------------"+password);*/
		
		System.out.println(loginDto.getUsername()+"....."+loginDto.getPassword());
		return AjaxResult.success("登录成功");
	}
	
	

}
