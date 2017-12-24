package com.hph.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.hph.dao.UserDao;
import com.hph.entity.User;


/**
 * 用户相关--持久层实现
 * @author hupenghao
 *
 */
@Repository
public class UserDaoImpl implements UserDao {

	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;

	protected final Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	public List<?> queryUserByInfo(String username, String password) {
		// TODO Auto-generated method stub
		return getCurrentSession()
				.createQuery("from t_user where username='" + username + "' and password='" + password + "'").list();
	}

	public User findOne(int id) {
		// TODO Auto-generated method stub
		return (User) getCurrentSession().get(User.class, id);
	}

	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public void create(User entity) {
		// TODO Auto-generated method stub
		getCurrentSession().save(entity);
	}

	public void update(User entity) {
		// TODO Auto-generated method stub
	}

	public void delete(User entity) {
		// TODO Auto-generated method stub

	}

	public void deleteById(long entityId) {
		// TODO Auto-generated method stub

	}

}
