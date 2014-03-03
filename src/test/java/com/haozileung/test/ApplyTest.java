/**
 * <p>文件的说明</p>
 * 创建时间：2014年3月3日 下午3:05:42 
 * @author lianghaopeng
 */
package com.haozileung.test;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import com.haozileung.test.dao.apply.IApplyDao;
import com.haozileung.test.pojo.apply.Apply;

/**
 * <p>
 * 类的简介说明
 * </p>
 * 创建时间：2014年3月3日 下午3:05:42
 * 
 * @author lianghaopeng
 * @version V1.0
 */
// 配置测试用例运行器
@RunWith(SpringJUnit4ClassRunner.class)
// 配置spring配置文件位置
@ContextConfiguration(locations = { "classpath*:applicationContext*.xml" })
// 配置测试监听器，其中TransactionalTestExecutionListener用于解析和事务有关的注解，DependencyInjectionTestExecutionListener解析和spring自动装配有关的注解
@TestExecutionListeners({ TransactionalTestExecutionListener.class,
		DependencyInjectionTestExecutionListener.class })
// 配置事务管理器，如果不指定名字，则默认装配名字为transactionManager的bean
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class ApplyTest {
	@Autowired
	private IApplyDao applyDao;

	@Test
	public void testApply() {
		Apply apply = new Apply(1, "Haozi", new Date(), "test for apply", 0,
				"approved", 0.5, 1);
		applyDao.save(apply);

		Apply a1 = applyDao.find(1);

		System.out.println(a1.getApplier());
		
		Apply a2 = applyDao.find(1);

		System.out.println(a2.getContent());
	}
}
