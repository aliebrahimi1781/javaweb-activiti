/**
 * <p>文件的说明</p>
 * 创建时间：2014年3月3日 下午2:08:38 
 * @author lianghaopeng
 */
package com.haozileung.test.common.base;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>
 * 类的简介说明
 * </p>
 * 创建时间：2014年3月3日 下午2:08:38
 * 
 * @author lianghaopeng
 * @version V1.0
 */
@SuppressWarnings("serial")
public abstract class BaseController implements Serializable {

	protected Logger logger = LoggerFactory.getLogger(BaseController.class
			.getName());

}
