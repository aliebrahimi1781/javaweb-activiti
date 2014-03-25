/**
 * <p>文件的说明</p>
 * 创建时间：2014年3月12日 上午10:08:46 
 * @author lianghaopeng
 */
package com.haozileung.test.client.widget;

import java.util.Date;

import com.haozileung.test.client.ds.TaskDataSource;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.events.FormSubmitFailedEvent;
import com.smartgwt.client.widgets.form.events.FormSubmitFailedHandler;
import com.smartgwt.client.widgets.form.fields.DateItem;
import com.smartgwt.client.widgets.form.fields.HiddenItem;
import com.smartgwt.client.widgets.form.fields.ResetItem;
import com.smartgwt.client.widgets.form.fields.SubmitItem;

/**
 * <p>
 * 类的简介说明
 * </p>
 * 创建时间：2014年3月12日 上午10:08:46
 * 
 * @author lianghaopeng
 * @version V1.0
 */
public class ApplyForm extends DynamicForm {
	public ApplyForm() {
		setDataSource(TaskDataSource.getInstance());
		setUseAllDataSourceFields(true);
		HiddenItem applyId = new HiddenItem("applyId");
		HiddenItem result1 = new HiddenItem("result1");
		HiddenItem result2 = new HiddenItem("result2");
		HiddenItem comment1 = new HiddenItem("comment1");
		HiddenItem comment2 = new HiddenItem("comment2");
		HiddenItem status = new HiddenItem("status");
		HiddenItem isClaim = new HiddenItem("isClaim");
		status.setDefaultValue(0);

		SubmitItem submit = new SubmitItem("submit", "提交");
		ResetItem reset = new ResetItem("reset", "重置");
		submit.setStartRow(false);
		submit.setEndRow(false);
		submit.setAlign(Alignment.CENTER);
		reset.setStartRow(false);
		reset.setEndRow(false);
		reset.setAlign(Alignment.CENTER);
		addFormSubmitFailedHandler(new FormSubmitFailedHandler() {

			@Override
			public void onFormSubmitFailed(FormSubmitFailedEvent event) {
				SC.say("提交失败！");
			}
		});
		DateItem applyDate = new DateItem("applyDate");
		applyDate.setDefaultValue(new Date());
		setFields(applyId, applyDate, result1, result2, comment1, comment2,
				status, isClaim, submit, reset);
		setNumCols(2);
		setWidth(300);
		setAlign(Alignment.CENTER);
		setGroupTitle("请假申请表");
		setIsGroup(true);
	}
}
