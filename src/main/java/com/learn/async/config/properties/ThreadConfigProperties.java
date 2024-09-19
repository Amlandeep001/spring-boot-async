package com.learn.async.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("order.async")
@lombok.Value
public class ThreadConfigProperties
{
	int corePoolSize;
	int maxPoolSize;
	int queueCapacity;

	String threadNamePrefix;
}
