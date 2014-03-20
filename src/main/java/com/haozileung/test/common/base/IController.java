/**
 * <p>文件的说明</p>
 * 创建时间：2014年3月14日 下午3:06:29 
 * @author lianghaopeng
 */
package com.haozileung.test.common.base;

import java.io.Serializable;
import java.util.Map;

import com.haozileung.test.dto.Response;

/**
 * <p>
 * 类的简介说明
 * </p>
 * 创建时间：2014年3月14日 下午3:06:29
 * 
 * @author lianghaopeng
 * @version V1.0
 */
public interface IController<T extends IEntity> extends Serializable {
	
	public Response<T> fetch(Map<String, Object> param);

	public Response<T> add(Map<String, Object> param);

	public Response<T> delete(Map<String, Object> param);

	public Response<T> update(Map<String, Object> param);
}
