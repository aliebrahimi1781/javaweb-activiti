/**
 * <p>文件的说明</p>
 * 创建时间：2014年3月26日 上午11:40:58 
 * @author lianghaopeng
 */
package com.haozileung.test.service.listener;

import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;

/**
 * <p>
 * 类的简介说明
 * </p>
 * 创建时间：2014年3月26日 上午11:40:58
 * 
 * @author lianghaopeng
 * @version V1.0
 */
public class EndVocationListener implements TaskListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3299553891783508740L;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.activiti.engine.delegate.TaskListener#notify(org.activiti.engine.
	 * delegate.DelegateTask)
	 */
	@Override
	public void notify(DelegateTask delegateTask) {
		System.out.println(delegateTask.getName());
	}

}
