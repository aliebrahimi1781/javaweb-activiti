/**
 * <p>文件的说明</p>
 * 创建时间：2014年3月3日 下午2:53:09 
 * @author lianghaopeng
 */
package com.haozileung.test.service;

import java.util.Calendar;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.haozileung.test.dao.ApplyRepository;
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
	private ApplyRepository applyRepository;

	@Override
	public Date getEndDate(Apply apply) {
		Calendar c = Calendar.getInstance();
		c.setTime(apply.getApplyDate());
		c.add(Calendar.SECOND, apply.getNumberOfDays() * 10);
		return c.getTime();
	}

	@Override
	public Apply savePMApproved(Apply apply, boolean result1, String comment1) {
		apply.setResult1(result1 == true ? 1 : 0);
		apply.setComment1(comment1);
		// applyDAO.save(apply);
		return apply;
	}

	@Override
	public Apply saveDMApproved(Apply apply, boolean result2, String comment2) {
		apply.setResult2(result2 == true ? 1 : 0);
		apply.setComment2(comment2);
		// applyDAO.save(apply);
		return apply;
	}

	@Override
	public void sendMail(Apply apply) {
		logger.info("请假未被批准：" + apply.getApplier() + "，" + apply.getContent()
				+ "，" + apply.getComment1() + "，" + apply.getComment2());
	}

	@Override
	public void startVocation(Apply apply) {
		apply.setStatus(1);
		// applyDAO.save(apply);
		logger.info(apply.getApplier() + "开始休假：" + new Date());
	}

	@Override
	public void finishVocation(Apply apply) {
		apply.setStatus(2);
		// applyDAO.save(apply);
		logger.info(apply.getApplier() + "结束休假：" + new Date());
	}

	@Override
	public Apply saveApply(Apply apply) {
		return applyRepository.save(apply);
	}
}
