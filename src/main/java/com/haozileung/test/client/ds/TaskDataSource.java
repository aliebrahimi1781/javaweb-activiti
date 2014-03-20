/**
 * <p>文件的说明</p>
 * 创建时间：2014年3月12日 上午10:12:54 
 * @author lianghaopeng
 */
package com.haozileung.test.client.ds;

import java.util.LinkedHashMap;

import com.haozileung.test.client.common.BaseDataSource;
import com.smartgwt.client.data.fields.DataSourceDateField;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;
import com.smartgwt.client.types.DSDataFormat;

/**
 * <p>
 * 类的简介说明
 * </p>
 * 创建时间：2014年3月12日 上午10:12:54
 * 
 * @author lianghaopeng
 * @version V1.0
 */
public class TaskDataSource extends BaseDataSource {

	private static TaskDataSource instance;

	public static TaskDataSource getInstance() {
		if (null == instance) {
			instance = new TaskDataSource("TaskDataSource");
		}
		return instance;
	}

	public TaskDataSource(String id) {
		setID(id);
		DataSourceIntegerField applyId = new DataSourceIntegerField("applyId",
				"流水号");
		applyId.setPrimaryKey(true);
		applyId.setDetail(true);
		DataSourceTextField applier = new DataSourceTextField("applier", "申请人",
				25);
		applier.setRequired(true);
		DataSourceDateField applyDate = new DataSourceDateField("applyDate",
				"申请时间");
		applyDate.setRequired(true);
		DataSourceTextField content = new DataSourceTextField("content",
				"申请内容", 1000);
		content.setRequired(true);
		DataSourceFloatField numberOfDays = new DataSourceFloatField(
				"numberOfDays", "请假时长");
		numberOfDays.setRequired(true);
		LinkedHashMap<String, Object> approveValueMap = new LinkedHashMap<String, Object>();
		approveValueMap.put("-1", "未知");
		approveValueMap.put("0", "不通过");
		approveValueMap.put("1", "通过");
		DataSourceIntegerField result1 = new DataSourceIntegerField("result1",
				"项目经理审批");
		result1.setValueMap(approveValueMap);
		DataSourceTextField comment1 = new DataSourceTextField("comment1",
				"项目经理意见");
		DataSourceIntegerField result2 = new DataSourceIntegerField("result2",
				"部门经理审批");
		result2.setValueMap(approveValueMap);
		DataSourceTextField comment2 = new DataSourceTextField("comment2",
				"部门经理意见");
		DataSourceIntegerField status = new DataSourceIntegerField("status",
				"流程状态");
		LinkedHashMap<String, Object> statusValueMap = new LinkedHashMap<String, Object>();
		statusValueMap.put("0", "审批中");
		statusValueMap.put("1", "已开始");
		statusValueMap.put("2", "已结束");
		status.setValueMap(statusValueMap);
		this.setFields(applyId, applier, applyDate, numberOfDays, content,
				result1, result2, comment1, comment2, status);
		this.setDataFormat(DSDataFormat.JSON);
		//this.setDataURL("apply");
		this.setFetchDataURL("apply/fetch");
		this.setUpdateDataURL("apply/update");
		this.setAddDataURL("apply/add");
		this.setRemoveDataURL("apply/delete");
		this.setClientOnly(false);
	}
}
