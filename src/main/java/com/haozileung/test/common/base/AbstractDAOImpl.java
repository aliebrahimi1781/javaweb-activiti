/**
 * <p>文件的说明</p>
 * 创建时间：2014年3月3日 下午2:07:25 
 * @author lianghaopeng
 */
package com.haozileung.test.common.base;

import java.io.Serializable;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.googlecode.genericdao.dao.hibernate.GenericDAOImpl;

/**
 * <p>
 * 类的简介说明
 * </p>
 * 创建时间：2014年3月3日 下午2:07:25
 * 
 * @author lianghaopeng
 * @version V1.0
 */
public abstract class AbstractDAOImpl<T, ID extends Serializable> extends
		GenericDAOImpl<T, ID> implements IDAO<T, ID> {
	// 注入SessionFactory
	@Autowired
	@Override
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}
}
