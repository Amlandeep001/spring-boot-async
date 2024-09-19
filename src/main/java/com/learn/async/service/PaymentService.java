package com.learn.async.service;

import org.springframework.stereotype.Service;

import com.learn.async.dto.Order;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class PaymentService
{
	public void processPayment(Order order) throws InterruptedException
	{
		log.info("initiate payment for order: {} ", order.getProductId());
		// call actual payment gateway
		Thread.sleep(2000L);
		log.info("completed payment for order {}", order.getProductId());
	}
}
