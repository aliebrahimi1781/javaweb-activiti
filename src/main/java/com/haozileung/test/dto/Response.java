/**
 * <p>文件的说明</p>
 * 创建时间：2014年3月12日 下午1:44:02 
 * @author lianghaopeng
 */
package com.haozileung.test.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

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
public class Response<T extends IEntity> implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7113490943820210225L;
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
