package com.haozileung.test.client.widget;

import com.haozileung.test.client.ds.TaskDataSource;
import com.smartgwt.client.data.Criteria;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.events.RecordDoubleClickEvent;
import com.smartgwt.client.widgets.grid.events.RecordDoubleClickHandler;

/**
 * 
 * <p>
 * 类的简介说明
 * </p>
 * 创建时间：2014年3月12日 上午10:12:30
 * 
 * @author lianghaopeng
 * @version V1.0
 */
public class TodoList extends ListGrid {
	public TodoList(final Integer type) {
		setDataSource(TaskDataSource.getInstance());
		setAutoFetchData(true);
		Criteria c = new Criteria();
		setUseAllDataSourceFields(true);
		if (type.equals(1)) {
			c.setAttribute("userId", "projectManager");
			ListGridField result = new ListGridField("result2");
			ListGridField comment = new ListGridField("comment2");
			result.setHidden(true);
			comment.setHidden(true);
			setFields(result, comment);
		}
		if (type.equals(2)) {
			c.setAttribute("userId", "departmentManager");
			ListGridField result = new ListGridField("result1");
			ListGridField comment = new ListGridField("comment1");
			result.setHidden(true);
			comment.setHidden(true);
			setFields(result, comment);
		}
		setInitialCriteria(c);
		addRecordDoubleClickHandler(new RecordDoubleClickHandler() {

			@Override
			public void onRecordDoubleClick(RecordDoubleClickEvent event) {
				Window formWin = new Window();
				formWin.setTitle("请假审批");
				formWin.setHeight("320");
				formWin.setWidth("300");
				ApproveForm form = new ApproveForm(type);
				form.editRecord(event.getRecord());
				formWin.addItem(form);
				formWin.setIsModal(true);
				formWin.setShowModalMask(true);
				formWin.centerInPage();
				formWin.show();
			}
		});
	}
}
