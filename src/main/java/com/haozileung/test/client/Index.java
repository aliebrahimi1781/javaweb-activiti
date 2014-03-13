/**
 * <p>文件的说明</p>
 * 创建时间：2014年3月11日 上午9:11:33 
 * @author lianghaopeng
 */
package com.haozileung.test.client;

import com.google.gwt.core.client.EntryPoint;
import com.haozileung.test.client.widget.ApplyForm;
import com.haozileung.test.client.widget.TodoList;
import com.smartgwt.client.widgets.tab.Tab;
import com.smartgwt.client.widgets.tab.TabSet;

/**
 * <p>
 * 类的简介说明
 * </p>
 * 创建时间：2014年3月11日 上午9:11:33
 * 
 * @author lianghaopeng
 * @version V1.0
 */
public class Index implements EntryPoint {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.google.gwt.core.client.EntryPoint#onModuleLoad()
	 */
	@Override
	public void onModuleLoad() {
		// SC.say("测试！");
		TabSet ts = new TabSet();
		ts.setWidth100();
		ts.setHeight100();

		Tab tab1 = new Tab("请假申请");
		Tab tab2 = new Tab("项目经理审批");
		Tab tab3 = new Tab("部门经理审批");
		Tab tab4 = new Tab("运行中的流程");
		Tab tab5 = new Tab("已经完成的流程");

		ApplyForm form = new ApplyForm();
		tab1.setPane(form);
		TodoList todoList = new TodoList();
		TodoList todoList2 = new TodoList();
		tab2.setPane(todoList);
		tab3.setPane(todoList2);
		ts.addTab(tab1);
		ts.addTab(tab2);
		ts.addTab(tab3);
		ts.addTab(tab4);
		ts.addTab(tab5);

		ts.show();
	}

}
