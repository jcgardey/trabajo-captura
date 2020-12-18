package org.gardey.utils;

import java.util.Date;

import javax.jdo.AttributeConverter;

public class DateLongConverter implements AttributeConverter<Date,Long> {

	@Override
	public Long convertToDatastore(Date attributeValue) {
		return attributeValue.getTime();
	}

	@Override
	public Date convertToAttribute(Long datastoreValue) {
		return new Date(datastoreValue);
	}

}
