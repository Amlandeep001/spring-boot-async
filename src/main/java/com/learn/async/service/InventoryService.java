package com.learn.async.service;

import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class InventoryService
{
	public boolean checkProductAvailability(int productId)
	{
		log.info("order validated for product: {}", productId);
		return true;
	}
}
