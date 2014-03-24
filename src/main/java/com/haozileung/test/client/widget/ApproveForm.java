/**
 * <p>文件的说明</p>
 * 创建时间：2014年3月12日 上午10:12:12 
 * @author lianghaopeng
 */
package com.haozileung.test.client.widget;

import com.haozileung.test.client.ds.TaskDataSource;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.HiddenItem;
import com.smartgwt.client.widgets.form.fields.ResetItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.SubmitItem;
import com.smartgwt.client.widgets.form.fields.TextAreaItem;
import com.smartgwt.client.widgets.form.fields.TextItem;

/**
 * <p>
 * 类的简介说明
 * </p>
 * 创建时间：2014年3月12日 上午10:12:12
 * 
 * @author lianghaopeng
 * @version V1.0
 */
public class ApproveForm extends DynamicForm {
	public ApproveForm(Integer approveType) {
		setDataSource(TaskDataSource.getInstance());
		setUseAllDataSourceFields(true);
		HiddenItem applyId = new HiddenItem("applyId");
		HiddenItem status = new HiddenItem("status");
		HiddenItem result1 = new HiddenItem();
		HiddenItem comment1 = new HiddenItem();
		SelectItem result2 = new SelectItem();
		result2.setRequired(true);
		TextAreaItem comment2 = new TextAreaItem();
		comment2.setRequired(true);
		if (approveType.equals(1)) {
			result1.setName("result1");
			comment1.setName("comment1");
			result2.setName("result2");
			comment2.setName("comment2");
		} else if (approveType.equals(2)) {
			result1.setName("result2");
			comment1.setName("comment2");
			result2.setName("result1");
			comment2.setName("comment1");
		} else {
			SC.say("审批类型出错！");
		}
		SubmitItem submit = new SubmitItem("submit", "提交");
		ResetItem reset = new ResetItem("reset", "重置");
		submit.setStartRow(false);
		submit.setEndRow(false);
		submit.setAlign(Alignment.RIGHT);
		reset.setStartRow(false);
		reset.setEndRow(false);
		reset.setAlign(Alignment.LEFT);
		TextItem applier = new TextItem("applier");
		applier.setDisabled(true);
		TextItem applyDate = new TextItem("applyDate");
		applyDate.setDisabled(true);
		TextItem numberOfDays = new TextItem("numberOfDays");
		numberOfDays.setDisabled(true);
		TextItem content = new TextItem("content");
		content.setDisabled(true);
		setFields(applyId, applier, applyDate, numberOfDays, content, status,
				result1, comment1, result2, comment2, submit, reset);
		setNumCols(2);
		setGroupTitle("请假审批表");
		setIsGroup(true);
	}
}
