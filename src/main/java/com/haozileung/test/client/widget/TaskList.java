package com.haozileung.test.client.widget;

import com.haozileung.test.client.ds.TaskDataSource;
import com.smartgwt.client.data.Criteria;
import com.smartgwt.client.widgets.grid.ListGrid;

public class TaskList extends ListGrid {

	public TaskList(final Integer type) {
		setDataSource(TaskDataSource.getInstance());
		setAutoFetchData(true);
		Criteria c = new Criteria();
		setUseAllDataSourceFields(true);
		if (type.equals(1)) {
			c.setAttribute("type", "running");

		}
		if (type.equals(2)) {
			c.setAttribute("type", "finished");

		}
		setInitialCriteria(c);
	}

}