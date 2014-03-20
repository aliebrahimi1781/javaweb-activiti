package com.haozileung.test.dto;

import java.util.List;
import java.util.Map;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.haozileung.test.common.base.IEntity;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class ResponseField<T extends IEntity> {

	private Integer status;
	private Integer startRow;
	private Integer endRow;
	private Integer totalRows;
	private List<T> data;
	private Map<String, ErrorMessage> errors;

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getStartRow() {
		return startRow;
	}

	public void setStartRow(Integer startRow) {
		this.startRow = startRow;
	}

	public Integer getEndRow() {
		return endRow;
	}

	public void setEndRow(Integer endRow) {
		this.endRow = endRow;
	}

	public Integer getTotalRows() {
		return totalRows;
	}

	public void setTotalRows(Integer totalRows) {
		this.totalRows = totalRows;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	public Map<String, ErrorMessage> getErrors() {
		return errors;
	}

	public void setErrors(Map<String, ErrorMessage> errors) {
		this.errors = errors;
	}
}