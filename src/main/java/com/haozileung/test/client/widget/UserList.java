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
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.HLayout;

/**
 * 
 * <p>
 * 类的简介说明
 * </p>
 * 创建时间：2014年3月26日 下午2:54:53
 * 
 * @author lianghaopeng
 * @version V1.0
 */
public class UserList extends ListGrid {
	public UserList() {
		setDataSource(TaskDataSource.getInstance());
		setAutoFetchData(true);
		Criteria c = new Criteria();
		setUseAllDataSourceFields(true);
		c.setAttribute("userId", "Haozi");
		setInitialCriteria(c);
		setShowRecordComponents(true);
		setShowRecordComponentsByCell(true);
	}

	@Override
	protected Canvas createRecordComponent(final ListGridRecord record,
			Integer colNum) {
		final UserList list = this;
		HLayout hLayout = new HLayout();
		if (this.getFieldName(colNum).equals("isClaim")) {
			IButton btn = new IButton("重新申请");
			record.setAttribute("userId", "Haozi");
			btn.addClickHandler(new ClickHandler() {

				@Override
				public void onClick(ClickEvent event) {
					final Window formWin = new Window();
					record.setAttribute("type", "reApply");
					final ApproveForm form = new ApproveForm(0);
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
					formWin.setTitle("重新提交");
					formWin.setHeight("380");
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
			hLayout.addMember(btn);
			IButton btn2 = new IButton("销假");
			record.setAttribute("userId", "Haozi");
			btn2.addClickHandler(new ClickHandler() {

				@Override
				public void onClick(ClickEvent event) {
					record.setAttribute("status", 2);
					list.updateData(record);
				}
			});
			btn.setAutoFit(true);
			btn2.setAutoFit(true);
			hLayout.addMember(btn2);
			hLayout.setHeight(20);
			return hLayout;
		} else {
			return super.createRecordComponent(record, colNum);
		}
	}
}
