/**
 * <p>文件的说明</p>
 * 创建时间：2014年3月3日 下午2:53:09 
 * @author lianghaopeng
 */
package com.haozileung.test.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.activiti.engine.ActivitiException;
import org.activiti.engine.HistoryService;
import org.activiti.engine.IdentityService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.history.HistoricProcessInstanceQuery;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.runtime.ProcessInstanceQuery;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.haozileung.test.dao.IApplyDAO;
import com.haozileung.test.pojo.apply.Apply;
import com.haozileung.test.service.IApplyService;

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

	@Override
	@Transactional
	public boolean startFlow(Apply apply) {
		if (applyRepository.save(apply)) {
			String businessKey = apply.getApplyId().toString();
			identityService.setAuthenticatedUserId(apply.getApplier());
			ProcessInstance processInstance = null;
			try {
				processInstance = runtimeService.startProcessInstanceByKey(
						"leave", businessKey);
				String processInstanceId = processInstance.getId();
				apply.setProcessInstanceId(processInstanceId);
				logger.debug(
						"start process of {key={}, bkey={}, pid={}, variables={}}",
						new Object[] { "leave", businessKey,
								processInstanceId });
				return true;
			} catch (ActivitiException e) {
				logger.error("Activiti error!");
				return false;
			} catch (Exception e) {
				logger.error("System error!");
				return false;
			} finally {
				identityService.setAuthenticatedUserId(null);
			}
		} else {
			logger.error("Save Apply error!");
			return false;
		}
	}

	@Override
	public List<Apply> getToDoApplyList(String userId) {
		List<Apply> results = new ArrayList<Apply>();

		// 根据当前组未签收的任务
		TaskQuery groupQuery = taskService.createTaskQuery()
				.processDefinitionKey("leave").taskCandidateGroup(userId)
				.active().orderByTaskId().desc().orderByTaskCreateTime().desc();
		List<Task> groupTasks = groupQuery.list();
		// 根据流程的业务ID查询实体并关联
		for (Task task : groupTasks) {
			String processInstanceId = task.getProcessInstanceId();
			ProcessInstance processInstance = runtimeService
					.createProcessInstanceQuery()
					.processInstanceId(processInstanceId).active()
					.singleResult();
			String businessKey = processInstance.getBusinessKey();
			if (businessKey == null) {
				continue;
			}
			Apply apply = applyRepository.find(Integer.valueOf(businessKey));
			if (apply != null) {
				apply.setTaskId(task.getId());
				apply.setProcessInstanceId(processInstanceId);
				apply.setIsClaim(0);
				results.add(apply);
			}
		}
		// 根据当前人未签收的任务
		TaskQuery claimQuery = taskService.createTaskQuery()
				.processDefinitionKey("leave").taskCandidateUser(userId)
				.active().orderByTaskId().desc().orderByTaskCreateTime().desc();
		List<Task> unsignedTasks = claimQuery.list();
		// 根据流程的业务ID查询实体并关联
		for (Task task : unsignedTasks) {
			String processInstanceId = task.getProcessInstanceId();
			ProcessInstance processInstance = runtimeService
					.createProcessInstanceQuery()
					.processInstanceId(processInstanceId).active()
					.singleResult();
			String businessKey = processInstance.getBusinessKey();
			if (businessKey == null) {
				continue;
			}
			Apply apply = applyRepository.find(Integer.valueOf(businessKey));
			if (apply != null) {
				apply.setTaskId(task.getId());
				apply.setProcessInstanceId(processInstanceId);
				apply.setIsClaim(0);
				results.add(apply);
			}
		}
		// 根据当前人的ID查询
		TaskQuery todoQuery = taskService.createTaskQuery()
				.processDefinitionKey("leave").taskAssignee(userId).active()
				.orderByTaskId().desc().orderByTaskCreateTime().desc();
		List<Task> todoList = todoQuery.list();
		// 根据流程的业务ID查询实体并关联
		for (Task task : todoList) {
			String processInstanceId = task.getProcessInstanceId();
			ProcessInstance processInstance = runtimeService
					.createProcessInstanceQuery()
					.processInstanceId(processInstanceId).active()
					.singleResult();
			String businessKey = processInstance.getBusinessKey();
			if (businessKey == null) {
				continue;
			}
			Apply apply = applyRepository.find(Integer.valueOf(businessKey));
			if (apply != null) {
				apply.setTaskId(task.getId());
				apply.setProcessInstanceId(processInstanceId);
				apply.setIsClaim(1);
				results.add(apply);
			}
		}

		return results;
	}

	@Override
	public List<Apply> getRunningApplyList() {
		List<Apply> results = new ArrayList<Apply>();
		ProcessInstanceQuery query = runtimeService
				.createProcessInstanceQuery().processDefinitionKey("leave")
				.active().orderByProcessInstanceId().desc();
		List<ProcessInstance> list = query.list();

		// 关联业务实体
		for (ProcessInstance processInstance : list) {
			String businessKey = processInstance.getBusinessKey();
			if (businessKey == null) {
				continue;
			}
			Apply apply = applyRepository.find(Integer.valueOf(businessKey));
			if (apply != null) {
				results.add(apply);

				// 设置当前任务信息
				List<Task> tasks = taskService.createTaskQuery()
						.processInstanceId(processInstance.getId()).active()
						.orderByTaskCreateTime().desc().listPage(0, 1);
				apply.setTaskId(tasks.get(0).getId());
			}
		}
		return results;
	}

	@Override
	public List<Apply> getFinishedApplyList() {
		List<Apply> results = new ArrayList<Apply>();
		HistoricProcessInstanceQuery query = historyService
				.createHistoricProcessInstanceQuery()
				.processDefinitionKey("leave").finished()
				.orderByProcessInstanceEndTime().desc();
		List<HistoricProcessInstance> list = query.list();

		// 关联业务实体
		for (HistoricProcessInstance historicProcessInstance : list) {
			String businessKey = historicProcessInstance.getBusinessKey();
			if (businessKey != null) {
				Apply apply = applyRepository
						.find(Integer.valueOf(businessKey));
				if (apply != null) {
					results.add(apply);
				}
			}
		}
		return results;
	}

	@Override
	public boolean updateApplyClaim(Apply apply, String userId) {
		if (apply.getApplyId() == null) {
			return false;
		}
		try {
			taskService.claim(apply.getTaskId(), userId);
		} catch (Exception e) {
			return false;
		}
		applyRepository.save(apply);
		return true;
	}

	@Override
	public boolean updateApplyComplete(Apply apply, String userId,
			Map<String, Object> var) {
		if (apply.getApplyId() == null) {
			return false;
		}
		try {
			taskService.complete(apply.getTaskId(), var);
		} catch (Exception e) {
			return false;
		}
		applyRepository.save(apply);
		return true;
	}

	@Override
	public void sendMail() {
		System.out.println("审批不通过，测试~");
	}
}
