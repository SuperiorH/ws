package com.example.ws.test;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.util.concurrent.TimeUnit;

public class CacheManager {

    private static LoadingCache<String, Object> cache = null;

    static {
        cache = CacheBuilder.newBuilder()
                //缓存池大小
                .maximumSize(10000)
                //最后一次访问之后多少时间后移除
                .expireAfterAccess(1, TimeUnit.DAYS)
                //被创建或值被替换之后多少时间删除
                .expireAfterWrite(1, TimeUnit.DAYS)
                .recordStats().build(new CacheLoader<String, Object>() {
                    @Override
                    public Object load(String key) throws Exception {
                        //处理缓存不存在时的处理逻辑
                        return " ";
                    }
                });
    }

    public static void put(String key, Object value) {
        cache.put(key, value);
    }

}
