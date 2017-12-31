package com.hph.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.hph.entity.Cart;
import com.hph.service.CartService;
import com.hph.service.ItemService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 购物车相关控制器
 * 
 * @author hupenghao
 */
public class CartAction extends ActionSupport {

	@Resource
	private CartService cartService;

	@Resource
	private ItemService itemService;

	private static final long serialVersionUID = 1L;

	private int id;

	private int item_id;

	private int user_id;

	private Map<String, Object> resultMap;

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public Map<String, Object> getResultMap() {
		return resultMap;
	}

	public void setResultMap(Map<String, Object> resultMap) {
		this.resultMap = resultMap;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getItem_id() {
		return item_id;
	}

	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}

	public String addItemToCart() {
		resultMap = new HashMap<String, Object>();
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		int user_id = Integer.valueOf(session.getAttribute("id").toString());
		String resultInfo = cartService.addItemToCart(user_id, item_id);
		if ("success".equals(resultInfo)) {
			resultMap.put("result", "success");
			return SUCCESS;
		}
		return null;
	}

	public String getAllCart() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		int user_id = Integer.valueOf(session.getAttribute("id").toString());
		List<Cart> data = cartService.getCart(user_id);
		resultMap = new HashMap<String, Object>();
		if (data.size() > 0) {
			for (Cart cart : data) {
				int item_id = cart.getItem_id();
				String item_name = itemService.getItemDetail(item_id).getName();
				cart.setItem_name(item_name);
			}
			resultMap.put("data", data);
		}
		return SUCCESS;
	}

	public String delete() {
		resultMap = new HashMap<String, Object>();
		cartService.removeItem(id);
		resultMap.put("result", "success");
		return SUCCESS;
	}

	public String checkOut() {
		resultMap = new HashMap<String, Object>();
		if (cartService.checkOut(id).equals("success")) {
			resultMap.put("result", "success");
		}else {
			resultMap.put("result", "商品库存不足");
		}
		return SUCCESS;
	}

}
