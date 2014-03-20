package com.haozileung.test.client.widget;

import com.haozileung.test.client.ds.TaskDataSource;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.grid.ListGrid;
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
		addRecordDoubleClickHandler(new RecordDoubleClickHandler() {

			@Override
			public void onRecordDoubleClick(RecordDoubleClickEvent event) {
				Window formWin = new Window();
				formWin.setHeight("40%");
				formWin.setWidth("30%");
				ApproveForm form = new ApproveForm(type);
				formWin.addMember(form);
				formWin.show();
			}
		});
	}
}
