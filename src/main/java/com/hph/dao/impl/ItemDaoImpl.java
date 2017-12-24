package com.hph.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.hph.dao.ItemDao;
import com.hph.entity.Item;

@Repository
public class ItemDaoImpl implements ItemDao {

	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;

	protected final Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	public Item findOne(int id) {
		// TODO Auto-generated method stub
		return (Item) getCurrentSession().get(Item.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Item> findAll() {
		// TODO Auto-generated method stub
		return getCurrentSession().createQuery("from t_item").list();
	}

	public void create(Item entity) {
		// TODO Auto-generated method stub
		getCurrentSession().save(entity);
	}

	public void update(Item entity) {
		// TODO Auto-generated method stub
		getCurrentSession().update(entity);
	}

	public void delete(Item entity) {
		// TODO Auto-generated method stub

	}

	public void deleteById(long entityId) {
		// TODO Auto-generated method stub

	}

	public List<?> getMyItem(int id) {
		// TODO Auto-generated method stub
		return getCurrentSession().createQuery("from t_item where user_id="+id).list();
	}

}
