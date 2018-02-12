package com.spring.coherence.configuration;

import com.spring.coherence.CoherenceCache;
import com.tangosol.net.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Configuration
@EnableCaching
public class CoherenceConfiguration {

	@Autowired
	private CacheManager cacheManager;

	@Bean
	public CacheManager cacheManager(
			ConfigurableCacheFactory configurableCacheFactory) {
		CoherenceCacheManager cacheManager = new CoherenceCacheManager(
				configurableCacheFactory);
		return cacheManager;
	}

	@PostConstruct
	public void postConstruct() {
		Cache cache = cacheManager.getCache("hello-example");
		cache.put("K1", "VALUE1");
	}

	@Bean
	public ConfigurableCacheFactory configurableCacheFactory() {
		ExtensibleConfigurableCacheFactory.Dependencies deps = ExtensibleConfigurableCacheFactory.DependenciesHelper
				.newInstance("dashboard-cache.xml");
		return new ExtensibleConfigurableCacheFactory(deps);
	}

	@PreDestroy
	public void preDestroy() {
		CacheFactory.shutdown();
	}

	private class CoherenceCacheManager implements CacheManager {

		private ConfigurableCacheFactory configurableCacheFactory;

		public CoherenceCacheManager(
				ConfigurableCacheFactory configurableCacheFactory) {
			this.configurableCacheFactory = configurableCacheFactory;
		}

		public Cache getCache(String cacheName) {
			// CacheFactory.setConfigurableCacheFactory(configurableCacheFactory);
			CacheFactory.ensureCluster();
			NamedCache namedCache = CacheFactory.getCache(cacheName);
			return new CoherenceCache(namedCache);
		}

		public Collection<String> getCacheNames() {
			throw new UnsupportedOperationException();
		}
	}
}
