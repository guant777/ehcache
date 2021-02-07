package com.ziroom.common.config;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author GuanTao
 * @description: guant
 * @create: 2021-02-03 20:18
 **/
@Configuration
@EnableCaching
public class EhCacheConfig {

    /**
     * 创建缓存管理器
     * @return CacheManager
     */
    @Bean("ehCacheCacheManager")
    public CacheManager ehCacheCacheManager() {
        return CacheManager.create("src/main/resources/ehcache.xml");
    }

    /**
     * 创建测试缓存实例1
     * @param cacheManager
     * @return Cache
     */
    @Bean(name="testCache1")
    public Cache getHouseFeatureCache(@Qualifier("ehCacheCacheManager") CacheManager cacheManager){
        return cacheManager.getCache("testCache1");
    }

    /**
     * 创建测试缓存实例1
     * @param cacheManager
     * @return Cache
     */
    @Bean(name="testCache2")
    public Cache getUserFeatureCache(@Qualifier("ehCacheCacheManager") CacheManager cacheManager){
        return cacheManager.getCache("testCache2");
    }

    /**
     * 创建测试缓存实例2
     * @param cacheManager
     * @return Cache
     */
    @Bean(name="testCache3")
    public Cache getStandbyCache(@Qualifier("ehCacheCacheManager") CacheManager cacheManager){
        return cacheManager.getCache("testCache3");
    }


}
