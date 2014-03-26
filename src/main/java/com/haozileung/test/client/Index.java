/**
 * <p>文件的说明</p>
 * 创建时间：2014年3月11日 上午9:11:33 
 * @author lianghaopeng
 */
package com.haozileung.test.client;

import com.google.gwt.core.client.EntryPoint;
import com.haozileung.test.client.widget.ApplyForm;
import com.haozileung.test.client.widget.TaskList;
import com.haozileung.test.client.widget.TodoList;
import com.haozileung.test.client.widget.UserList;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.tab.Tab;
import com.smartgwt.client.widgets.tab.TabSet;
import com.smartgwt.client.widgets.tab.events.TabSelectedEvent;
import com.smartgwt.client.widgets.tab.events.TabSelectedHandler;

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
		TabSet ts = new TabSet();
		ts.setWidth100();
		ts.setHeight100();

		Tab tab1 = new Tab("请假申请");
		Tab tab0 = new Tab("请假记录");
		Tab tab2 = new Tab("项目经理审批");
		Tab tab3 = new Tab("部门经理审批");
		Tab tab4 = new Tab("运行中的流程");
		Tab tab5 = new Tab("已经完成的流程");

		final ApplyForm form = new ApplyForm();
		HLayout buttonLayout = new HLayout();
		IButton submit = new IButton("提交");
		submit.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if (form.validate()) {
					form.submit();
					form.reset();
				}
			}
		});
		IButton reset = new IButton("重置");
		reset.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				form.reset();
			}
		});
		buttonLayout.addMember(submit);
		buttonLayout.addMember(reset);
		buttonLayout.setAlign(Alignment.CENTER);
		VLayout applyLayout = new VLayout();
		HLayout formLayout = new HLayout();
		formLayout.setHeight(300);
		formLayout.setWidth100();
		formLayout.setHeight100();
		formLayout.setAlign(Alignment.CENTER);
		formLayout.addMember(form);
		applyLayout.setWidth100();
		applyLayout.setHeight(300);
		applyLayout.addMember(formLayout);
		applyLayout.addMember(buttonLayout);
		applyLayout.setAlign(Alignment.CENTER);
		tab1.setPane(applyLayout);
		TodoList todoList = new TodoList(1);
		TodoList todoList2 = new TodoList(2);
		TaskList taskList = new TaskList(1);
		TaskList taskList2 = new TaskList(2);
		UserList userList = new UserList();
		tab0.setPane(userList);
		tab2.setPane(todoList);
		tab3.setPane(todoList2);
		tab4.setPane(taskList);
		tab5.setPane(taskList2);

		ts.addTab(tab1);
		ts.addTab(tab0);
		ts.addTab(tab2);
		ts.addTab(tab3);
		ts.addTab(tab4);
		ts.addTab(tab5);
		ts.addTabSelectedHandler(new TabSelectedHandler() {

			@Override
			public void onTabSelected(TabSelectedEvent event) {
				Canvas c = event.getTabPane();
				if (c instanceof ListGrid) {
					ListGrid tl = (ListGrid) c;
					tl.invalidateCache();
				}
			}
		});

		ts.show();
	}

}
