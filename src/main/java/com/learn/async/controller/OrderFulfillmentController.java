package com.learn.async.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.async.dto.Order;
import com.learn.async.service.OrderFulfillmentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderFulfillmentController
{
	private final OrderFulfillmentService service;

	@PostMapping
	public ResponseEntity<Order> processOrder(@RequestBody Order order) throws InterruptedException
	{
		service.processOrder(order); // synchronous
		// asynchronous
		service.notifyUser(order);
		service.assignVendor(order);
		service.packaging(order);
		service.assignDeliveryPartner(order);
		service.assignTrailerAndDispatch(order);
		return ResponseEntity.ok(order);
	}
}
