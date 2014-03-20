/**
 * <p>文件的说明</p>
 * 创建时间：2014年3月3日 下午2:53:09 
 * @author lianghaopeng
 */
package com.haozileung.test.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.haozileung.test.dao.IApplyDAO;
import com.haozileung.test.pojo.apply.Apply;

/**
 * <p>
 * 类的简介说明
 * </p>
 * 创建时间：2014年3月3日 下午2:53:09
 * 
 * @author lianghaopeng
 * @version V1.0
 */
@Service("ApplyService")
public class ApplyServiceImpl implements IApplyService {

	private final static Logger logger = LoggerFactory
			.getLogger(ApplyServiceImpl.class);
	@Autowired
	private IApplyDAO applyRepository;

	@Override
	public boolean startFlow(Apply apply) {
		// TODO Auto-generated method stub
		return false;
	}
}
