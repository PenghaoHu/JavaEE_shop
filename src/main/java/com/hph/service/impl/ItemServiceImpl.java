package com.hph.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hph.dao.ItemDao;
import com.hph.entity.Item;
import com.hph.service.ItemService;

@Service
@Transactional
public class ItemServiceImpl implements ItemService {

	@Resource
	private ItemDao itemDao;

	public void addItem(Item item) {
		// TODO Auto-generated method stub
		itemDao.create(item);
	}

	public List<?> getAllItem() {
		// TODO Auto-generated method stub
		return itemDao.findAll();
	}

	public Item getItemDetail(int id) {
		return itemDao.findOne(id);
	}

	public void buyItem(int id) {
		// TODO Auto-generated method stub
		Item item = itemDao.findOne(id);
		if (item != null) {
			if (item.getNumber() > 0) {
				int buyNumber = item.getNumber() - 1;
				item.setId(id);
				item.setNumber(buyNumber);
				itemDao.update(item);
			}
		}
	}

	public List<?> getMyItem(int id) {
		// TODO Auto-generated method stub
		return itemDao.getMyItem(id);
	}
}
