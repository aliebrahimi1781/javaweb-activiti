/**
 * <p>文件的说明</p>
 * 创建时间：2014年3月13日 下午3:48:33 
 * @author lianghaopeng
 */
package com.haozileung.test.client.common;

import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.OperationBinding;
import com.smartgwt.client.data.RestDataSource;
import com.smartgwt.client.types.DSDataFormat;
import com.smartgwt.client.types.DSOperationType;

/**
 * <p>
 * 类的简介说明
 * </p>
 * 创建时间：2014年3月13日 下午3:48:33
 * 
 * @author lianghaopeng
 * @version V1.0
 */
public abstract class BaseDataSource extends RestDataSource {

	protected OperationBinding getFetch() {
		OperationBinding fetch = new OperationBinding();
		fetch.setOperationType(DSOperationType.FETCH);
		DSRequest fetchProps = new DSRequest();
		fetchProps.setHttpMethod("GET");
		fetch.setRequestProperties(fetchProps);
		return fetch;
	}

	protected OperationBinding getAdd() {
		OperationBinding add = new OperationBinding();
		add.setOperationType(DSOperationType.ADD);
		DSRequest fetchProps = new DSRequest();
		fetchProps.setHttpMethod("PUT");
		add.setRequestProperties(fetchProps);
		return add;
	}

	protected OperationBinding getUpdate() {
		OperationBinding update = new OperationBinding();
		update.setOperationType(DSOperationType.UPDATE);
		DSRequest fetchProps = new DSRequest();
		fetchProps.setHttpMethod("POST");
		update.setRequestProperties(fetchProps);
		return update;
	}

	protected OperationBinding getDelete() {
		OperationBinding delete = new OperationBinding();
		delete.setOperationType(DSOperationType.REMOVE);
		DSRequest fetchProps = new DSRequest();
		fetchProps.setHttpMethod("DELETE");
		delete.setRequestProperties(fetchProps);
		return delete;
	}

	@Override
	public void setDataURL(String dataURL) throws IllegalStateException {
		super.setDataURL(dataURL);
		this.setDataFormat(DSDataFormat.JSON);
		this.setOperationBindings(getFetch(), getAdd(), getUpdate(),
				getDelete());
	}

}
