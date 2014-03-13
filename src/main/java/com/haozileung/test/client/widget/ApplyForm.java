/**
 * <p>文件的说明</p>
 * 创建时间：2014年3月12日 上午10:08:46 
 * @author lianghaopeng
 */
package com.haozileung.test.client.widget;

import com.haozileung.test.client.ds.ApplyDataSource;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.CanvasItem;
import com.smartgwt.client.widgets.form.fields.HiddenItem;
import com.smartgwt.client.widgets.form.fields.ResetItem;
import com.smartgwt.client.widgets.form.fields.SubmitItem;
import com.smartgwt.client.widgets.layout.HLayout;

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
		setDataSource(ApplyDataSource.getInstance());
		setUseAllDataSourceFields(true);
		HiddenItem applyId = new HiddenItem("applyId");
		HiddenItem result1 = new HiddenItem("result1");
		HiddenItem result2 = new HiddenItem("result2");
		HiddenItem comment1 = new HiddenItem("comment1");
		HiddenItem comment2 = new HiddenItem("comment2");
		HiddenItem status = new HiddenItem("status");
		
		SubmitItem submit = new SubmitItem("submit", "提交");
		ResetItem reset = new ResetItem("reset", "重置");
		
		setFields(applyId, result1, result2, comment1, comment2, status,
				submit, reset);
		setNumCols(2);
		setGroupTitle("请假申请表");
		setIsGroup(true);
	}
}
