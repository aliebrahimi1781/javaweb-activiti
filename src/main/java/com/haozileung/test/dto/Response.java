/**
 * <p>文件的说明</p>
 * 创建时间：2014年3月12日 下午1:44:02 
 * @author lianghaopeng
 */
package com.haozileung.test.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.haozileung.test.common.base.IEntity;

/**
 * <p>
 * 类的简介说明
 * </p>
 * 创建时间：2014年3月12日 下午1:44:02
 * 
 * @author lianghaopeng
 * @version V1.0
 */
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class Response<T extends IEntity> implements Serializable {
	private static final long serialVersionUID = -7113490943820210225L;
	private ResponseField<T> response;

	public Response() {
		response = new ResponseField<T>();
	}

	public ResponseField<T> getResponse() {
		return response;
	}

	public void setResponse(ResponseField<T> response) {
		this.response = response;
	}

	@JsonIgnore
	public Integer getStatus() {
		return response.getStatus();
	}

	public void setStatus(Integer status) {
		response.setStatus(status);
	}

	@JsonIgnore
	public Integer getStartRow() {
		return response.getStartRow();
	}

	public void setStartRow(Integer startRow) {
		response.setStartRow(startRow);
	}

	@JsonIgnore
	public Integer getEndRow() {
		return response.getEndRow();
	}

	public void setEndRow(Integer endRow) {
		response.setEndRow(endRow);
	}

	@JsonIgnore
	public Integer getTotalRows() {
		return response.getTotalRows();
	}

	public void setTotalRows(Integer totalRows) {
		response.setTotalRows(totalRows);
	}

	@JsonIgnore
	public List<T> getData() {
		return response.getData();
	}

	public void setData(List<T> data) {
		response.setData(data);
	}

	@JsonIgnore
	public Map<String, ErrorMessage> getErrors() {
		return response.getErrors();
	}

	public void setErrors(Map<String, ErrorMessage> errors) {
		response.setErrors(errors);
	}
}
