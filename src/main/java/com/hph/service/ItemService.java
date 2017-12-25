package com.hph.service;

import java.util.List;

import com.hph.entity.Item;

/**
 * 商品相关--服务层接口
 * 
 * @author hupenghao
 *
 */
public interface ItemService {

	/**
	 * 添加商品
	 * 
	 * @param item
	 */
	public void addItem(Item item);

	/**
	 * 获得所有商品
	 * 
	 * @return
	 */
	public List<?> getAllItem();

	/**
	 * 获取用户发布的商品
	 * 
	 * @param id
	 * @return
	 */
	public List<?> getMyItem(int id);

	/**
	 * 获取商品详情
	 * 
	 * @param id
	 * @return
	 */
	public Item getItemDetail(int id);

	/**
	 * 购买商品
	 * 
	 * @param id
	 */
	public void buyItem(int id);

	public void update(Item item);

	public void delete(Item item);

}
