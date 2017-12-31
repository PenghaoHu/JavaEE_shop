package com.hph.dao;

import java.util.List;

import com.hph.entity.Cart;

/**
 * 购物车相关--持久层接口
 * 
 * @author hupenghao
 *
 */
public interface CartDao extends IOperations<Cart>{
	
	/**
	 * 根据用户id和商品id查询商品
	 * 
	 * @param item_id
	 * @param user_id
	 * @return
	 */
	public List<Cart> queryItemByUserIdAndItemId(int item_id,int user_id);
	
	/**
	 * 根据用户ID获取购物车
	 * 
	 * @param user_id
	 * @return
	 */
	public List<Cart> getCartByUserId(int user_id);
}
