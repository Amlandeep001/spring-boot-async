package com.learn.async.config;

import java.util.concurrent.Executor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import com.learn.async.config.properties.ThreadConfigProperties;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableAsync
@RequiredArgsConstructor
public class AsyncConfiguration
{
	private final ThreadConfigProperties threadProperties;

	@Bean("asyncTaskExecutor")
	Executor asyncTaskExecutor()
	{
		ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
		taskExecutor.setCorePoolSize(threadProperties.getCorePoolSize());
		taskExecutor.setQueueCapacity(threadProperties.getQueueCapacity());
		taskExecutor.setMaxPoolSize(threadProperties.getMaxPoolSize());
		taskExecutor.setThreadNamePrefix(threadProperties.getThreadNamePrefix());
		taskExecutor.initialize();
		return taskExecutor;
	}
}
