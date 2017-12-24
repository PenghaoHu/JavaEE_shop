package com.hph.dao;

import java.util.List;

import com.hph.entity.User;


public interface UserDao extends IOperations<User>{

	List<?> queryUserByInfo(String username, String password);
}
