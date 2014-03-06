/**
 * <p>文件的说明</p>
 * 创建时间：2014年3月3日 下午2:06:06 
 * @author lianghaopeng
 */
package com.haozileung.test.common.base;

import java.io.Serializable;

import com.googlecode.genericdao.dao.hibernate.GenericDAO;

/**
 * <p>
 * 类的简介说明
 * </p>
 * 创建时间：2014年3月3日 下午2:06:06
 * 
 * @author lianghaopeng
 * @version V1.0
 */
public interface IDAO<T, ID extends Serializable> extends GenericDAO<T, ID> {
}
