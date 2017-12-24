package com.hph.dao;

import java.util.List;

import com.hph.entity.Item;

public interface ItemDao extends IOperations<Item>{
	
	public List<?> getMyItem(int id);
	
}
