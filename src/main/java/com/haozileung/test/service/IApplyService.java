/**
 * <p>文件的说明</p>
 * 创建时间：2014年3月3日 下午2:52:30 
 * @author lianghaopeng
 */
package com.haozileung.test.service;

import java.util.Date;

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

	public Apply saveApply(Apply apply);

	public void startVocation(Apply apply);

	public void finishVocation(Apply apply);

	public void sendMail(Apply apply);

	public Date getEndDate(Apply apply);

	public Apply savePMApproved(Apply apply, boolean result1, String comment1);

	public Apply saveDMApproved(Apply apply, boolean result2, String comment2);
}
