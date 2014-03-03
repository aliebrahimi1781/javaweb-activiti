/**
 * <p>文件的说明</p>
 * 创建时间：2014年3月3日 下午2:07:25 
 * @author lianghaopeng
 */
package com.haozileung.test.common.base;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 类的简介说明
 * </p>
 * 创建时间：2014年3月3日 下午2:07:25
 * 
 * @author lianghaopeng
 * @version V1.0
 */
@Transactional
public abstract class AbstractDAOImpl<T, ID extends Serializable> implements
		IDAO<T, ID> {
	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	@Override
	public ID save(T t) {
		return (ID) getSession().save(t);
	}

	@SuppressWarnings("unchecked")
	@Override
	public T find(ID id) {
		return (T) getSession().get(getPOJOClass(), id);
	}

	@Override
	public void update(T t) {
		getSession().update(t);
		;
	}

	@Override
	public void delete(T t) {
		getSession().delete(t);
	}
}
