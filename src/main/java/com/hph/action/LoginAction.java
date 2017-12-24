package com.hph.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hph.entity.User;
import com.hph.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 用户相关控制器
 * @author hupenghao
 *
 */
@Controller
@Scope("prototype")
public class LoginAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	@Resource
	private UserService userService;

	String username;

	String password;

	Map<String, Object> resultMap;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Map<String, Object> getResultMap() {
		return resultMap;
	}

	public void setResultMap(Map<String, Object> resultMap) {
		this.resultMap = resultMap;
	}

	/**
	 * 用户登录控制器方法
	 * @return
	 */
	public String login() {
		List<?> result = userService.getUser(username, password);
		resultMap = new HashMap<String, Object>();
		if (result.size() > 0) {
			User user = (User)result.get(0);
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpSession session = request.getSession();
			session.setAttribute("id", user.getId());
			resultMap.put("result", "success");
			return SUCCESS;
		} else {
			resultMap.put("result", "error");
			return SUCCESS;
		}

	}
	/**
	 * 用户注册控制器方法
	 * @return
	 */
	public String register() {
		User user = new User();
		resultMap = new HashMap<String, Object>();
		user.setUsername(username);
		user.setPassword(password);
		userService.addUser(user);
		resultMap.put("result", "success");
		return SUCCESS;
	}
}
