package com.ziroom.guant;

import com.ziroom.GuantApplicationTests;
import lombok.extern.slf4j.Slf4j;
import net.sf.ehcache.Cache;
import net.sf.ehcache.Element;
import org.junit.Test;
import javax.annotation.Resource;
import java.util.Arrays;


/**
* @Description: 单元测试类
* @Author:GuanTao
* @Date: 2020/4/28 8:51 下午
*/
@Slf4j
public class TestService extends GuantApplicationTests {


	@Resource(name = "testCache1")
	private Cache testCache1;

	@Resource(name = "testCache2")
	private Cache testCache2;

	@Resource(name = "testCache3")
	private Cache testCache3;



	/**
	 * 写入数据
	 */
	@Test
	public void dataInput() {
		// 单条写入
		testCache1.put(new Element("gt", "7777"));
		testCache2.put(new Element("gt", "7777"));
		testCache3.put(new Element("gt", "7777"));

		// 批量写入
		testCache1.putAll(Arrays.asList(new Element("melo", "888"), new Element("james", "999")));
		testCache2.putAll(Arrays.asList(new Element("melo", "888"), new Element("james", "999")));
		testCache3.putAll(Arrays.asList(new Element("melo", "888"), new Element("james", "999")));
	}

	/**
	 * 读取数据
	 */
	@Test
	public void readData() {
		// 单条读取
		log.info("c1：{}", testCache1.get("gt"));
		log.info("c2：{}", testCache2.get("gt"));
		log.info("c3：{}", testCache3.get("gt"));

		// 批量读取
		log.info("pc1：{}", testCache1.getAll(Arrays.asList("melo", "james")));
		log.info("pc2：{}", testCache2.getAll(Arrays.asList("melo", "james")));
		log.info("pc3：{}", testCache3.getAll(Arrays.asList("melo", "james")));
	}

	/**
	 * 修改元素
	 */
	@Test
	public void modifyElements() {
		testCache1.put(new Element("king", 89));
		log.info("修改前：{}", testCache1.get("king"));
		//testCache1.put(new Element("king", 90));与replace相同
		testCache1.replace(new Element("king", 90));
		log.info("修改后：{}",testCache1.get("king"));
	}

	/**
	 * 删除元素
	 */
	@Test
	public void deleteElement() {
		// 单条删除
		testCache1.remove("gt");
		testCache2.remove("gt");
		testCache3.remove("gt");
		log.info("c1：{}", testCache1.get("gt"));
		log.info("c2：{}", testCache2.get("gt"));
		log.info("c3：{}", testCache3.get("gt"));

		// 批量删除
		testCache1.removeAll(Arrays.asList("melo", "james"));
		testCache2.removeAll(Arrays.asList("melo", "james"));
		testCache3.removeAll(Arrays.asList("melo", "james"));
		log.info("pc1：{}", testCache1.getAll(Arrays.asList("melo", "james")));
		log.info("pc2：{}", testCache2.getAll(Arrays.asList("melo", "james")));
		log.info("pc3：{}", testCache3.getAll(Arrays.asList("melo", "james")));


	}
}
