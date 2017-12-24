package com.hph.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.hph.entity.Item;
import com.hph.entity.User;
import com.hph.service.ItemService;
import com.hph.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 商品相关控制器
 * 
 * @author hupenghao
 */
public class ItemAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	@Resource
	private ItemService itemService;
	@Resource
	private UserService userService;

	String id;
	String name;
	String brand;
	String type;
	String description;
	Double price;
	Integer number;
	Map<String, Object> resultMap;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Map<String, Object> getResultMap() {
		return resultMap;
	}

	public void setResultMap(Map<String, Object> resultMap) {
		this.resultMap = resultMap;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 添加商品
	 * @return
	 */
	public String add() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		resultMap = new HashMap<String, Object>();
		Item item = new Item();
		item.setName(name);
		item.setBrand(brand);
		item.setType(type);
		item.setPrice(price);
		item.setDescription(description);
		item.setNumber(number);
		item.setUser_id(Integer.valueOf(session.getAttribute("id").toString()));
		itemService.addItem(item);
		resultMap.put("result", "success");
		return SUCCESS;
	}
	
	/**
	 * 获得所有商品
	 * @return
	 */
	public String getAll() {
		List<?> data = itemService.getAllItem();
		resultMap = new HashMap<String, Object>();
		if (data.size() > 0) {
			resultMap.put("data", data);
		}
		return SUCCESS;
	}
	
	/**
	 * 获得商品细节
	 * @return
	 */
	public String getDetail() {
		int itemid = Integer.valueOf(id);
		resultMap = new HashMap<String, Object>();
		Item item = itemService.getItemDetail(itemid);
		User user = userService.findUser(item.getUser_id());
		String item_username = user.getUsername();
		resultMap.put("result", "success");
		resultMap.put("itemDetail", item);
		resultMap.put("itemUsername", item_username);
		return SUCCESS;
	}
	
	/**
	 * 购买商品控制方法
	 * @return
	 */
	public String buy() {
		resultMap = new HashMap<String, Object>();
		int itemid = Integer.valueOf(id);
		itemService.buyItem(itemid);
		resultMap.put("result", "success");
		return SUCCESS;
	}
	
	/**
	 * 根据用户获取其发布的商品
	 * @return
	 */
	public String getMy() {
		resultMap = new HashMap<String, Object>();
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		String id = session.getAttribute("id").toString();
		int userId = Integer.valueOf(id);
		List<?> data = itemService.getMyItem(userId);
		resultMap.put("data", data);
		return SUCCESS;
	}
}
