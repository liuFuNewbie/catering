package cn.catering.tools;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

public class StringToDateConverter implements Converter<String, Date> {

	private String datePattern;

	public StringToDateConverter(String datePattern) {
		super();
		this.datePattern = datePattern;
	}

	@Override
	public Date convert(String string) {
		Date date = null;
		try {
			date = new SimpleDateFormat(this.datePattern).parse(string);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
}
