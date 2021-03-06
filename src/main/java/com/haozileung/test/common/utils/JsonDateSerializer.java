/**
 * <p>文件的说明</p>
 * 创建时间：2014年3月24日 上午11:16:05 
 * @author lianghaopeng
 */
package com.haozileung.test.common.utils;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;

/**
 * <p>
 * 类的简介说明
 * </p>
 * 创建时间：2014年3月24日 上午11:16:05
 * 
 * @author lianghaopeng
 * @version V1.0
 */
public class JsonDateSerializer extends JsonSerializer<Date> {

	@Override
	public void serialize(Date arg0, JsonGenerator arg1, SerializerProvider arg2)
			throws IOException, JsonProcessingException {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String formattedDate = formatter.format(arg0);
		arg1.writeString(formattedDate);
	}

}
