package com.haozileung.test.client.widget;

import com.haozileung.test.client.ds.TaskDataSource;
import com.smartgwt.client.data.Criteria;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.HLayout;

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

	private int type;

	public TodoList(final Integer type) {
		this.type = type;
		setDataSource(TaskDataSource.getInstance());
		setAutoFetchData(true);
		Criteria c = new Criteria();
		setUseAllDataSourceFields(true);
		if (type.equals(1)) {
			c.setAttribute("userId", "pm");
		}
		if (type.equals(2)) {
			c.setAttribute("userId", "dm");

		}
		ListGridField result1 = new ListGridField("result1");
		ListGridField comment1 = new ListGridField("comment1");
		result1.setHidden(true);
		comment1.setHidden(true);
		ListGridField result2 = new ListGridField("result2");
		ListGridField comment2 = new ListGridField("comment2");
		result2.setHidden(true);
		comment2.setHidden(true);
		ListGridField applier = new ListGridField("applier");
		applier.setAlign(Alignment.CENTER);
		applier.setWidth("20%");
		ListGridField applyDate = new ListGridField("applyDate");
		applyDate.setAlign(Alignment.CENTER);
		applyDate.setWidth("20%");
		ListGridField numberOfDays = new ListGridField("numberOfDays");
		numberOfDays.setAlign(Alignment.CENTER);
		numberOfDays.setWidth("20%");
		ListGridField content = new ListGridField("content");
		content.setAlign(Alignment.CENTER);
		content.setWidth("20%");
		ListGridField status = new ListGridField("status");
		status.setAlign(Alignment.CENTER);
		status.setWidth("10%");
		ListGridField btnField = new ListGridField("isClaim");
		btnField.setWidth("10%");
		setFields(applier, applyDate, numberOfDays, content, result1, status,
				comment1, result2, comment2, btnField);
		setInitialCriteria(c);
		setShowRecordComponents(true);
		setShowRecordComponentsByCell(true);
	}

	@Override
	protected Canvas createRecordComponent(final ListGridRecord record,
			Integer colNum) {
		final TodoList list = this;
		if (this.getFieldName(colNum).equals("isClaim")) {
			IButton btn = new IButton();
			if (type == 1) {
				record.setAttribute("userId", "pm");
			}
			if (type == 2) {
				record.setAttribute("userId", "dm");
			}
			if (record.getAttributeAsString("isClaim") != null
					&& !record.getAttributeAsString("isClaim").isEmpty()) {
				if (record.getAttributeAsInt("isClaim").equals(1)) {
					record.setAttribute("type", "complete");
					btn.setTitle("审批");
					btn.addClickHandler(new ClickHandler() {
						@Override
						public void onClick(ClickEvent event) {
							final Window formWin = new Window();
							final ApproveForm form = new ApproveForm(type);
							HLayout buttonLayout = new HLayout();
							IButton submit = new IButton("提交");
							submit.addClickHandler(new ClickHandler() {
								@Override
								public void onClick(ClickEvent event) {
									if (form.validate()) {
										form.submit();
										form.reset();
										list.invalidateCache();
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
							formWin.setTitle("请假审批");
							formWin.setHeight("320");
							formWin.setWidth("300");
							form.setMargin(10);
							form.editRecord(record);
							formWin.addItem(form);
							formWin.addItem(buttonLayout);
							formWin.setIsModal(true);
							formWin.setShowModalMask(true);
							formWin.centerInPage();
							formWin.show();

						}
					});
				}
				if (record.getAttributeAsInt("isClaim").equals(0)) {
					record.setAttribute("type", "claim");
					btn.setTitle("未签收");
					btn.addClickHandler(new ClickHandler() {

						@Override
						public void onClick(ClickEvent event) {
							record.setAttribute("isClaim", 1);
							list.updateData(record);
						}
					});
				}
			}
			return btn;
		} else {
			return super.createRecordComponent(record, colNum);
		}
	}
}
