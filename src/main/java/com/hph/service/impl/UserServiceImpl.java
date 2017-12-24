package com.hph.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hph.dao.UserDao;
import com.hph.entity.User;
import com.hph.service.UserService;

/**
 * 用户相关--服务层实现
 * @author hupenghao
 *
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Resource
	private UserDao userDao;

	public UserServiceImpl() {
		super();
	}

	public List<?> getUser(String username, String password) {
		// TODO Auto-generated method stub
		return userDao.queryUserByInfo(username, password);
	}

	public void addUser(User user) {
		// TODO Auto-generated method stub
		userDao.create(user);
	}

	public User findUser(int id) {
		// TODO Auto-generated method stub
		return userDao.findOne(id);
	}

}
