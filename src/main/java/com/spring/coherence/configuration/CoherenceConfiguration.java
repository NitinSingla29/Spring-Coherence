package com.spring.coherence.configuration;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.spring.coherence.CoherenceCacheManager;
import com.tangosol.net.CacheFactory;

@Configuration
@EnableCaching
public class CoherenceConfiguration {

	@Bean	
	public CacheManager cacheManager() {
		return new CoherenceCacheManager();
	}

	@PostConstruct
	public void postConstruct() {
		CacheFactory.ensureCluster();
	}

	@PreDestroy
	public void preDestroy() {
		CacheFactory.shutdown();
	}

}
