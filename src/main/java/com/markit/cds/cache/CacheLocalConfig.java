package com.markit.cds.cache;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

public class CacheLocalConfig  {

    @Autowired
    private static HazelcastInstance hazelcast;
    
    public static HazelcastInstance initializeCache() {
        hazelcast = Hazelcast.newHazelcastInstance();
        return hazelcast;
    }
    public static Map<Object, Object> putInCache(String cacheName,Object cacheObject) {
	 Map<Object, Object> empMap = hazelcast.getMap(cacheName);
	 empMap.put(cacheName, cacheObject);
	return empMap;
    }
}
