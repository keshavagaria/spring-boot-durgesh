package com.hcl.demo.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.hcl.demo.dto.OrderRequest;
import com.hcl.demo.dto.OrderResponse;
import com.hcl.demo.util.NotificationUtil;

@Service
public class OrderService {

	
	public OrderResponse checkOutOrder(OrderRequest order) {
		
		int discount=addDiscount(order);
	    order.setPrice(order.getPrice()-discount);
		String message = NotificationUtil.sendEmail(order.getEmailId());
		return new OrderResponse(order, message, HttpStatus.OK.value());	
	}
	
	private int addDiscount(OrderRequest order) {
		System.out.println("called...");
		int price = order.getPrice();
		int discountAMount = 0;
		if (order.isDiscountable()) {
			if (order.getPrice() > 1000) {
				discountAMount = price * 10 / 100;
			} else {
				discountAMount = price;
			}
		} else {
			discountAMount = price;
		}
		return discountAMount;
	}
}
