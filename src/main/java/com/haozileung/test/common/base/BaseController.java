/**
 * <p>文件的说明</p>
 * 创建时间：2014年3月3日 下午2:08:38 
 * @author lianghaopeng
 */
package com.haozileung.test.common.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.haozileung.test.dto.Response;

/**
 * <p>
 * 类的简介说明
 * </p>
 * 创建时间：2014年3月3日 下午2:08:38
 * 
 * @author lianghaopeng
 * @version V1.0
 */
public abstract class BaseController<T extends IEntity> implements
		IController<T> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5567430967270107013L;
	protected Logger logger = LoggerFactory.getLogger(BaseController.class
			.getName());

	@ResponseBody
	@RequestMapping(value = "")
	protected Response<T> handle() {
		return null;
	}

}
