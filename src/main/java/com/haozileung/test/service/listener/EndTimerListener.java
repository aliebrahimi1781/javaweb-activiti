/**
 * <p>文件的说明</p>
 * 创建时间：2014年3月26日 下午1:44:31 
 * @author lianghaopeng
 */
package com.haozileung.test.service.listener;

import org.activiti.engine.HistoryService;
import org.activiti.engine.IdentityService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;
import org.activiti.engine.runtime.ProcessInstance;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.haozileung.test.dao.IApplyDAO;
import com.haozileung.test.pojo.apply.Apply;

/**
 * <p>
 * 类的简介说明
 * </p>
 * 创建时间：2014年3月26日 下午1:44:31
 * 
 * @author lianghaopeng
 * @version V1.0
 */
@Component
public class EndTimerListener implements TaskListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7968104441413242843L;
	@Autowired
	private IApplyDAO applyRepository;
	@Autowired
	private RuntimeService runtimeService;
	@Autowired
	protected TaskService taskService;
	@Autowired
	protected HistoryService historyService;
	@Autowired
	protected RepositoryService repositoryService;
	@Autowired
	private IdentityService identityService;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.activiti.engine.delegate.TaskListener#notify(org.activiti.engine.
	 * delegate.DelegateTask)
	 */
	@Override
	public void notify(DelegateTask delegateTask) {
		ProcessInstance pi = runtimeService.createProcessInstanceQuery()
				.processInstanceId(delegateTask.getProcessInstanceId())
				.singleResult();
		String bussinessKey = pi.getBusinessKey();
		Apply apply = applyRepository.find(Integer.parseInt(bussinessKey));
		DateTime time = new DateTime(apply.getApplyDate());
		delegateTask.getExecution().setVariable("endTime",
				time.plusDays(apply.getNumberOfDays()));
		System.out.println("Set timer to "
				+ time.toString("yyyy-MM-dd HH:mm:ss"));
	}

}
