package com.hph.service;

import java.util.List;

import com.hph.entity.User;

public interface UserService {

	public List<?> getUser(String username, String password);

	public void addUser(User user);

	public User findUser(int id);
}
