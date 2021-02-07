package com.ziroom.guant.listener;

import lombok.extern.slf4j.Slf4j;
import net.sf.ehcache.CacheException;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Status;
import net.sf.ehcache.event.CacheManagerEventListener;

/**
 * @author GuanTao
 * @program: guant
 * @description: 自定义缓存管理器监听器
 * @create: 2021-02-04 16:23
 **/
@Slf4j
public class TestCacheManagerEventListener implements CacheManagerEventListener {

    private final CacheManager cacheManager;

    public TestCacheManagerEventListener(CacheManager cacheManager) {
        this.cacheManager = cacheManager;
    }


    /**
     * 在CacheManagerEventListener实现类实例化后被调用，用于初始化CacheManagerEventListener。
     *
     * @throws CacheException
     */
    @Override
    public void init() throws CacheException {
        log.info("在CacheManagerEventListener实现类实例化后被调用，用于初始化CacheManagerEventListener。");
    }

    /**
     * 返回当前CacheManagerEventListener所处的状态，可选值有STATUS_UNINITIALISED、 STATUS_ALIVE和STATUS_SHUTDOWN。
     *
     * @return
     */
    @Override
    public Status getStatus() {
        log.info("返回当前CacheManagerEventListener所处的状态，可选值有STATUS_UNINITIALISED、 STATUS_ALIVE和STATUS_SHUTDOWN。");
        return null;
    }

    /**
     * 用于释放资源
     *
     * @throws CacheException
     */
    @Override
    public void dispose() throws CacheException {
        log.info("用于释放资源");
    }

    /**
     * 添加缓存通知
     *
     * @param s
     */
    @Override
    public void notifyCacheAdded(String s) {
        log.info("添加缓存：{}", s);
    }

    /**
     * 删除Cache通知
     *
     * @param s
     */
    @Override
    public void notifyCacheRemoved(String s) {
        log.info("删除Cache通知：{}", s);
    }
}
