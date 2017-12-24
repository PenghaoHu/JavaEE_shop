package com.hph.service;

import java.util.List;

import com.hph.entity.Item;

public interface ItemService {

	public void addItem(Item item);

	public List<?> getAllItem();
	
	public List<?> getMyItem(int id);

	public Item getItemDetail(int id);
	
	public void buyItem(int id);

}
