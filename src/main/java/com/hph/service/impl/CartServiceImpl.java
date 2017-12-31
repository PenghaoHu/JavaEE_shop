package com.hph.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hph.dao.CartDao;
import com.hph.dao.ItemDao;
import com.hph.entity.Cart;
import com.hph.entity.Item;
import com.hph.service.CartService;
/**
 * 购物车相关--服务层实现
 * 
 * @author hupenghao
 */
@Service
@Transactional
public class CartServiceImpl implements CartService {

	@Resource
	private CartDao cartDao;

	@Resource
	private ItemDao itemDao;
	
	public String addItemToCart(int user_id, int item_id) {
		// TODO Auto-generated method stub
		if (cartItemIsExit(user_id, item_id)) {
			List<Cart> data = cartDao.queryItemByUserIdAndItemId(item_id, user_id);
			Cart cart = data.get(0);
			cart.setNumber(cart.getNumber() + 1);
			cartDao.update(cart);
			return "success";
		} else {
			Cart cart = new Cart();
			cart.setItem_id(item_id);
			cart.setNumber(1);
			cart.setUser_id(user_id);
			cartDao.create(cart);
			return "success";
		}
	}

	public String checkOut(int id) {
		// TODO Auto-generated method stub
		Cart cart = cartDao.findOne(id);
		Item item = itemDao.findOne(cart.getItem_id());
		if (item.getNumber() >= cart.getNumber()) {
			item.setNumber(item.getNumber() - cart.getNumber());
			itemDao.update(item);
			cartDao.deleteById(id);
			return "success";
		} else {
			return "商品库存不足";
		}

	}

	public void removeItem(int id) {
		// TODO Auto-generated method stub
		cartDao.deleteById(id);
	}

	public boolean cartItemIsExit(int user_id, int item_id) {
		// TODO Auto-generated method stub
		List<Cart> data = cartDao.queryItemByUserIdAndItemId(item_id, user_id);
		if (data.size() > 0) {
			return true;
		} else {
			return false;
		}

	}

	public List<Cart> getCart(int user_id) {
		// TODO Auto-generated method stub
		return cartDao.getCartByUserId(user_id);
	}

}
