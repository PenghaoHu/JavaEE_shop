package com.hph.dao;

import java.util.List;

import com.hph.entity.Item;

/**
 * 商品相关--持久层接口
 * @author hupenghao
 *
 */
public interface ItemDao extends IOperations<Item>{
	
	/**
	 * 根据用户ID获得其发布的商品
	 * @param id
	 * @return
	 */
	public List<?> getMyItem(int id);
	
}
