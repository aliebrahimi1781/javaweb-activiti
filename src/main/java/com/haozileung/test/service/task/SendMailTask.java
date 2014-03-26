/**
 * <p>文件的说明</p>
 * 创建时间：2014年3月26日 上午11:34:35 
 * @author lianghaopeng
 */
package com.haozileung.test.service.task;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

/**
 * <p>
 * 类的简介说明
 * </p>
 * 创建时间：2014年3月26日 上午11:34:35
 * 
 * @author lianghaopeng
 * @version V1.0
 */
public class SendMailTask implements JavaDelegate {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.activiti.engine.delegate.JavaDelegate#execute(org.activiti.engine
	 * .delegate.DelegateExecution)
	 */
	@Override
	public void execute(DelegateExecution execution) throws Exception {
		String bussinessKey = execution.getProcessBusinessKey();
		System.out.print("==============" + bussinessKey);
	}

}
