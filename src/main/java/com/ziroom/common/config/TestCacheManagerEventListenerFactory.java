package com.ziroom.common.config;

import com.ziroom.guant.listener.TestCacheManagerEventListener;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.event.CacheManagerEventListener;
import net.sf.ehcache.event.CacheManagerEventListenerFactory;
import java.util.Properties;

/**
 * @author GuanTao
 * @program: guant
 * @description: 创建缓存管理器监听事件工厂
 * @create: 2021-02-04 16:15
 **/
public class TestCacheManagerEventListenerFactory extends CacheManagerEventListenerFactory {

    @Override
    public CacheManagerEventListener createCacheManagerEventListener(CacheManager cacheManager, Properties properties) {
        return new TestCacheManagerEventListener(cacheManager);
    }
}
