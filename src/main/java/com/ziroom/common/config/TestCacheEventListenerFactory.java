package com.ziroom.common.config;
import com.ziroom.guant.listener.TestCacheEventListener;
import net.sf.ehcache.event.CacheEventListener;
import net.sf.ehcache.event.CacheEventListenerFactory;

import java.util.Properties;

/**
 * @author GuanTao
 * @program: guant
 * @description: 创建缓存监听事件工厂
 * @create: 2021-02-04 15:11
 **/
public class TestCacheEventListenerFactory extends CacheEventListenerFactory {

    @Override
    public CacheEventListener createCacheEventListener(Properties properties) {
        return TestCacheEventListener.INSTANCE;
    }
}
