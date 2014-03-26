/**
 * <p>文件的说明</p>
 * 创建时间：2014年3月3日 下午2:52:30 
 * @author lianghaopeng
 */
package com.haozileung.test.service;

import java.util.List;
import java.util.Map;

import com.haozileung.test.common.base.IService;
import com.haozileung.test.pojo.apply.Apply;

/**
 * <p>
 * 类的简介说明
 * </p>
 * 创建时间：2014年3月3日 下午2:52:30
 * 
 * @author lianghaopeng
 * @version V1.0
 */
public interface IApplyService extends IService {
	/**
	 * 开始流程
	 * 
	 * @param apply
	 * @return
	 */
	public boolean startFlow(Apply apply);

	/**
	 * 查询列表
	 * 
	 * @param userId
	 * @return
	 */
	public List<Apply> getToDoApplyList(String userId);

	/**
	 * 查询正在进行的流程
	 * 
	 * @return
	 */
	public List<Apply> getRunningApplyList();

	/**
	 * 查询已经结束的流程
	 * 
	 * @return
	 */
	public List<Apply> getFinishedApplyList();

	/**
	 * 签收任务
	 * 
	 * @param apply
	 * @param userId
	 * @return
	 */
	public boolean updateApplyClaim(Apply apply, String userId);

	/**
	 * 完成任务
	 * 
	 * @param apply
	 * @param userId
	 * @return
	 */
	public boolean updateApplyComplete(Apply apply, String userId,
			Map<String, Object> var);

	public void sendMail();
}
