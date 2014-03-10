package com.haozileung.test.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.haozileung.test.pojo.apply.Apply;

/**
 * 
 * <p>
 * 类的简介说明
 * </p>
 * 创建时间：2014年3月3日 下午2:51:52
 * 
 * @author lianghaopeng
 * @version V1.0
 */
public interface ApplyRepository extends CrudRepository<Apply, Integer> {
	/**
	 * 按状态查找
	 * 
	 * @param status
	 * @return
	 */
	public List<Apply> findOneByStatus(Integer status);
}
