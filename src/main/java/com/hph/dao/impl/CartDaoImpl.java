package com.hph.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.hph.dao.CartDao;
import com.hph.entity.Cart;

/**
 * 购物车相关--持久层实现
 * 
 * @author hupenghao
 *
 */
@Repository
public class CartDaoImpl implements CartDao {

	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;

	protected final Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	public Cart findOne(int id) {
		// TODO Auto-generated method stub
		return (Cart) getCurrentSession().get(Cart.class, id);
	}

	public List<Cart> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public void create(Cart entity) {
		// TODO Auto-generated method stub
		getCurrentSession().save(entity);
	}

	public void update(Cart entity) {
		// TODO Auto-generated method stub
		getCurrentSession().update(entity);
	}

	public void delete(Cart entity) {
		// TODO Auto-generated method stub

	}

	public void deleteById(int entityId) {
		// TODO Auto-generated method stub
		Cart cart = (Cart) getCurrentSession().get(Cart.class, entityId);
		getCurrentSession().delete(cart);
	}

	@SuppressWarnings("unchecked")
	public List<Cart> queryItemByUserIdAndItemId(int item_id, int user_id) {
		// TODO Auto-generated method stub
		return getCurrentSession().createQuery("from t_cart where item_id=" + item_id + " and user_id=" + user_id)
				.list();
	}

	@SuppressWarnings("unchecked")
	public List<Cart> getCartByUserId(int user_id) {
		// TODO Auto-generated method stub
		return getCurrentSession().createQuery("from t_cart where user_id=" + user_id).list();
	}

}
