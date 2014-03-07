/**
 * <p>文件的说明</p>
 * 创建时间：2014年3月3日 下午3:05:42 
 * @author lianghaopeng
 */
package com.haozileung.test;

import static org.junit.Assert.assertNotNull;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.activiti.engine.HistoryService;
import org.activiti.engine.IdentityService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.activiti.engine.test.ActivitiRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.haozileung.test.dao.ApplyRepository;
import com.haozileung.test.pojo.apply.Apply;

/**
 * <p>
 * 类的简介说明
 * </p>
 * 创建时间：2014年3月3日 下午3:05:42
 * 
 * @author lianghaopeng
 * @version V1.0
 */
// 配置测试用例运行器
@RunWith(SpringJUnit4ClassRunner.class)
// 配置spring配置文件位置
@ContextConfiguration(locations = { "classpath*:applicationContext*.xml" })
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
public class ApplyTest {
	private final Logger logger = LoggerFactory.getLogger(ApplyTest.class);

	@Autowired
	private IdentityService identityService;
	@Autowired
	private ApplyRepository applyRepository;

	@Autowired
	private RuntimeService runtimeService;

	@Autowired
	private TaskService taskService;

	@Autowired
	private RepositoryService repositoryService;
	@Autowired
	private HistoryService historyService;

	@Autowired
	@Rule
	public ActivitiRule activitiSpringRule;

	@PersistenceContext
	public EntityManager entityManager;

	@Test
	@Transactional
	public void testJpa() {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.SECOND, 20);
		Apply a = new Apply(null, "Haozi", c.getTime(), "apply from test", 0,
				"unknown", 0, "unknown", 1, 0);
		applyRepository.save(a);
		entityManager.persist(a);
		assertNotNull(a.getApplyId());
	}

	@Test
	// @Ignore
	public void test() {
		startProcess();
		waitTime(5);
		pmApprove();
		waitTime(5);
		dmApprove();
		waitTime(60);
	}

	@Transactional
	public void startProcess() {
		List<Apply> applies = applyRepository.findAll();
		for (Apply apply : applies) {
			if (apply.getStatus().equals(0)) {
				Map<String, Object> variables = new HashMap<String, Object>();
				variables.put("apply", apply);
				identityService.setAuthenticatedUserId(apply.getApplier());
				runtimeService.startProcessInstanceByKey("vacationRequest",
						variables);
			}
		}
		logger.info("Number of process instances: "
				+ runtimeService.createProcessInstanceQuery().count());
	}

	@Transactional
	public void pmApprove() {
		List<Task> tasks = taskService.createTaskQuery()
				.taskCandidateGroup("projectManager").list();
		logger.info("PM's tasks size is " + tasks.size());
		for (Task task : tasks) {
			logger.info("Task available: " + task.getName() + "--"
					+ task.getDescription());
			Map<String, Object> taskVariables = new HashMap<String, Object>();
			taskVariables.put("vacationApprovedPM", "true");
			taskVariables.put("managerMotivationPM", "go ahead!");
			taskService.complete(task.getId(), taskVariables);
		}
	}

	@Transactional
	public void dmApprove() {
		List<Task> tasks2 = taskService.createTaskQuery()
				.taskCandidateGroup("departmentManager").list();
		logger.info("DM's tasks size is " + tasks2.size());
		for (Task task : tasks2) {
			logger.info("Task available: " + task.getName() + "--"
					+ task.getDescription());
			Map<String, Object> taskVariables = new HashMap<String, Object>();
			taskVariables.put("vacationApprovedDM", "true");
			taskVariables.put("managerMotivationDM", "go ahead!");
			taskService.complete(task.getId(), taskVariables);
		}
	}

	public void waitTime(int n) {
		try {
			Thread.sleep(n * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
