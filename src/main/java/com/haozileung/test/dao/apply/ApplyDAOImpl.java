package com.haozileung.test.dao.apply;

import org.springframework.stereotype.Repository;

import com.haozileung.test.common.base.AbstractDAOImpl;
import com.haozileung.test.pojo.apply.Apply;

/**
 * 
 * <p>
 * 类的简介说明
 * </p>
 * 创建时间：2014年3月3日 下午2:51:57
 * 
 * @author lianghaopeng
 * @version V1.0
 */
@Repository("ApplyDAO")
public class ApplyDAOImpl extends AbstractDAOImpl<Apply, Integer> implements
		IApplyDao {

	@Override
	public Class<Apply> getPOJOClass() {
		return Apply.class;
	}

}
