package com.jd.oneseven.may.cache;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import java.util.concurrent.TimeUnit;

/**
 * Created by liushitao on 2017/5/18.
 */
public class GuavaCache<T> {
    Cache<String, T> cache;

    void initCache(){
       if(null == cache){
           CacheBuilder cacheBuilder = CacheBuilder.newBuilder();
           int concurrencyLevel = 1;
           int initialCapacity = 10;
           long maximumSize = 10;
           long expire = 120;
           cacheBuilder.concurrencyLevel(concurrencyLevel);
           cacheBuilder.initialCapacity(initialCapacity);
           cacheBuilder.maximumSize(maximumSize);

           cacheBuilder.expireAfterAccess(expire, TimeUnit.SECONDS);
//           cacheBuilder.expireAfterWrite();

           cache = cacheBuilder.build();
       }
    }

    public T get(String key){
        initCache();

        return cache.getIfPresent(key);
    }

    public void put(String key, T obj){
        initCache();

        cache.put(key, obj);
    }

    public void clear(String key){
        initCache();

        cache.invalidate(key);
    }


    /* getter and setter **/

    public Cache<String, T> getCache() {
        return cache;
    }

    public void setCache(Cache<String, T> cache) {
        this.cache = cache;
    }
}
