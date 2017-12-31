package com.hph.service;

import java.util.List;

import com.hph.entity.Cart;

/**
 * 购物车相关--服务层接口
 * 
 * @author hupenghao
 */
public interface CartService {
	
	/**
	 * 购物车是否存在指定商品
	 * 
	 * @param user_id
	 * @param item_id
	 * @return
	 */
	public boolean cartItemIsExit(int user_id, int item_id);

	/**
	 * 添加商品进入购物车
	 * 
	 * @param user_id
	 * @param item_id
	 * @return
	 */
	public String addItemToCart(int user_id, int item_id);
	
	/**
	 * 购物车结账
	 * 
	 * @param id
	 * @return
	 */
	public String checkOut(int id);
	
	/**
	 * 移除购物车一项商品
	 * 
	 * @param id
	 */
	public void removeItem(int id);
	
	/**
	 * 根据用户获取其购物车
	 * 
	 * @param user_id
	 * @return
	 */
	public List<Cart> getCart(int user_id);
	
}
