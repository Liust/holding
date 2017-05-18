package com.jd.oneseven.may.cache;

import com.google.common.cache.Cache;

/**
 * Created by liushitao on 2017/5/18.
 */
public class GuavaCache<T> {
    Cache<String, T> cache;

    public T get(String key){
        //init

        return cache.getIfPresent(key);
    }

    public void put(String key, T obj){
        //init

        cache.put(key, obj);
    }

    public void clear(String key){
        //init

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
