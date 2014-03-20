/**
 * <p>文件的说明</p>
 * 创建时间：2014年3月12日 上午10:12:12 
 * @author lianghaopeng
 */
package com.haozileung.test.client.widget;

import com.haozileung.test.client.ds.TaskDataSource;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.HiddenItem;
import com.smartgwt.client.widgets.form.fields.ResetItem;
import com.smartgwt.client.widgets.form.fields.SubmitItem;

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
		HiddenItem result = new HiddenItem();
		HiddenItem comment = new HiddenItem();
		if (approveType.equals(1)) {
			result.setName("result1");
			comment.setName("comment1");
		} else if (approveType.equals(2)) {
			result.setName("result2");
			comment.setName("comment2");
		} else {
			SC.say("审批类型出错！");
		}
		SubmitItem submit = new SubmitItem("submit", "提交");
		ResetItem reset = new ResetItem("reset", "重置");

		setFields(applyId, status, submit, reset);
		setNumCols(2);
		setGroupTitle("请假审批表");
		setIsGroup(true);
	}
}
