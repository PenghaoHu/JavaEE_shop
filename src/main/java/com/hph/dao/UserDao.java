package com.hph.dao;

import java.util.List;

import com.hph.entity.User;

/**
 * 用户相关--持久层接口
 * 
 * @author hupenghao
 */
public interface UserDao extends IOperations<User>{
	
	/**
	 * 登录查询
	 * @param username
	 * @param password
	 * @return
	 */
	List<?> queryUserByInfo(String username, String password);
}
