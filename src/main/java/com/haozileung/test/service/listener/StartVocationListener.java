/**
 * <p>文件的说明</p>
 * 创建时间：2014年3月26日 上午11:40:12 
 * @author lianghaopeng
 */
package com.haozileung.test.service.listener;

import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;

/**
 * <p>
 * 类的简介说明
 * </p>
 * 创建时间：2014年3月26日 上午11:40:12
 * 
 * @author lianghaopeng
 * @version V1.0
 */
public class StartVocationListener implements TaskListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6530852591745068884L;

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
