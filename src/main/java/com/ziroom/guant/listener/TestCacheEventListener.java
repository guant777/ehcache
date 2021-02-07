package com.ziroom.guant.listener;

import lombok.extern.slf4j.Slf4j;
import net.sf.ehcache.CacheException;
import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;
import net.sf.ehcache.event.CacheEventListener;

/**
 * @author GuanTao
 * @program: guant
 * @description: 自定义缓存事件监听器
 * @create: 2021-02-04 15:24
 **/
@Slf4j
public class TestCacheEventListener implements CacheEventListener {

    public static final CacheEventListener INSTANCE = new TestCacheEventListener();


    /**
     * 删除缓存后通知
     *
     * @param ehcache 缓存实例
     * @param element 元素实例
     * @throws CacheException
     */
    @Override
    public void notifyElementRemoved(Ehcache ehcache, Element element) throws CacheException {
        log.info("缓存[{}]中该[{}]元素被删除", ehcache.getName(), element.getObjectKey());
    }

    /**
     * 添加缓存后通知
     *
     * @param ehcache 缓存实例
     * @param element 元素实例
     * @throws CacheException
     */
    @Override
    public void notifyElementPut(Ehcache ehcache, Element element) throws CacheException {
        log.info("缓存[{}]中该[{}]元素被添加", ehcache.getName(), element.getObjectKey());
    }

    /**
     * 修改缓存后通知
     *
     * @param ehcache 缓存实例
     * @param element 元素实例
     * @throws CacheException
     */
    @Override
    public void notifyElementUpdated(Ehcache ehcache, Element element) throws CacheException {
        log.info("缓存[{}]中该[{}]元素被修改", ehcache.getName(), element.getObjectKey());
    }

    /**
     * 缓存过期后通知
     *
     * @param ehcache 缓存实例
     * @param element 元素实例
     */
    @Override
    public void notifyElementExpired(Ehcache ehcache, Element element) {
        log.info("缓存[{}]中该[{}]元素过期", ehcache.getName(), element.getObjectKey());
    }

    @Override
    public void notifyElementEvicted(Ehcache ehcache, Element element) {
        log.info("缓存[{}]中该[{}]元素被驱逐", ehcache.getName(), element.getObjectKey());

    }

    @Override
    public void notifyRemoveAll(Ehcache ehcache) {
        log.info("缓存[{}]删除所有", ehcache.getName());

    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        log.info("缓存克隆时候被执行");
        return null;
    }

    @Override
    public void dispose() {
        log.info("资源销毁后被执行");
    }
}
