package com.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.dao.OrderDao;
import com.ecommerce.model.CartProduct;
import com.ecommerce.model.Order;

@Service
public class OrderService {
	
	@Autowired
	private OrderDao orderDao;

	public List<CartProduct> getSellerOrderDetail(int id) {
		
		return orderDao.getSellerOrderDetail(id);
	}

	public List<Order> getOrderHistory(int id) {
		List<Order> orderHistory = orderDao.getOrderHistory(id);
		return orderHistory;
	}

	public List<CartProduct> getOrderDetailHistory(int orderId) {
		List<CartProduct> orderDetailHistory = orderDao.getOrderDetailHistory(orderId);
		return orderDetailHistory;
	}

	public void createOrder(int id, double totalPrice, List<CartProduct> cartProducts) {
	orderDao.createOrder(id, totalPrice, cartProducts);
		
	}
	
}
