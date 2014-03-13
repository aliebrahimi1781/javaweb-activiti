/**
 * <p>文件的说明</p>
 * 创建时间：2014年3月12日 下午1:52:33 
 * @author lianghaopeng
 */
package com.haozileung.test.dto;

import java.io.Serializable;

/**
 * <p>
 * 类的简介说明
 * </p>
 * 创建时间：2014年3月12日 下午1:52:33
 * 
 * @author lianghaopeng
 * @version V1.0
 */
public class ErrorMessage implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8914153967515686922L;
	private String errorMessage;

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}