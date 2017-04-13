package com.blog.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

public class DateJsonValueProcessor implements JsonValueProcessor {

	private String format;

	public DateJsonValueProcessor(String format) {
		// TODO Auto-generated constructor stub
		this.format = format;
	}

	@Override
	public Object processArrayValue(Object arg0, JsonConfig arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object processObjectValue(String key, Object value,
			JsonConfig jsonConfig) {
		// TODO Auto-generated method stub
		if (value == null) {
			return "";
		}
		if (value instanceof Timestamp) {
			String str = new SimpleDateFormat(format)
					.format((java.sql.Timestamp) value);
			return str;
		}
		if (value instanceof Date) {
			String str = new SimpleDateFormat(format).format((Date) value);
			return str;
		}
		return value.toString();
	}

}
