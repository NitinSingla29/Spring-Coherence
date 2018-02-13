package com.spring.coherence;

import java.util.Collection;

import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;

import com.tangosol.net.CacheFactory;
import com.tangosol.net.NamedCache;

public class CoherenceCacheManager implements CacheManager {

	public Cache getCache(String cacheName) {
		NamedCache namedCache = CacheFactory.getCache(cacheName);
		return new CoherenceCache(namedCache);
	}

	public Collection<String> getCacheNames() {
		throw new UnsupportedOperationException();
	}
}
