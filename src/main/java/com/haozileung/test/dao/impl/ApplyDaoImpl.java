/**
 * <p>文件的说明</p>
 * 创建时间：2014年3月19日 下午3:48:11 
 * @author lianghaopeng
 */
package com.haozileung.test.dao.impl;

import org.springframework.stereotype.Repository;

import com.haozileung.test.common.base.AbstractDAOImpl;
import com.haozileung.test.dao.IApplyDAO;
import com.haozileung.test.pojo.apply.Apply;

/**
 * <p>
 * 类的简介说明
 * </p>
 * 创建时间：2014年3月19日 下午3:48:11
 * 
 * @author lianghaopeng
 * @version V1.0
 */
@Repository
public class ApplyDaoImpl extends AbstractDAOImpl<Apply, Integer> implements
		IApplyDAO {
}
