package com.markit.cds.cache;

import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.Ignition;
import org.springframework.beans.factory.annotation.Autowired;

public class CacheLocalConfig  {

    @Autowired
    private static Ignite igniteInstance;
    
    public static Ignite initializeCache() {
	igniteInstance = Ignition.start();
        return igniteInstance;
    }
    public static IgniteCache<Object, Object> putInCache(String cacheName,Object cacheObject) {
	 IgniteCache<Object, Object> igniteCache = igniteInstance.getOrCreateCache(cacheName);
	 igniteCache.put(cacheName, cacheObject);
	return igniteCache;
    }
    
    public static Object getFromCache(String cacheName) {
	IgniteCache<Object, Object> igniteCache=igniteInstance.getOrCreateCache(cacheName);
	return igniteCache.get(cacheName);
    }
}
