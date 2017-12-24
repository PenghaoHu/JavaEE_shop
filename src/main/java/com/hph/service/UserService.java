package com.hph.service;

import java.util.List;

import com.hph.entity.User;

/**
 * 用户相关--服务层接口
 * @author hupenghao
 *
 */
public interface UserService {
	
	/**
	 * 登录验证
	 * @param username
	 * @param password
	 * @return
	 */
	public List<?> getUser(String username, String password);
	/**
	 * 注册账户
	 * @param user
	 */
	public void addUser(User user);
	/**
	 * 根据ID查找账户
	 * @param id
	 * @return
	 */
	public User findUser(int id);
}
