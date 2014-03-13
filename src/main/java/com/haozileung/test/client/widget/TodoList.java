package com.haozileung.test.client.widget;

import com.haozileung.test.client.ds.TaskDataSource;
import com.smartgwt.client.widgets.grid.ListGrid;

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
	public TodoList() {
		setDataSource(TaskDataSource.getInstance());
	}

}
