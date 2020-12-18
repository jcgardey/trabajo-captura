package org.gardey.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import javax.jdo.AttributeConverter;


public class MapStringIntegerToStringConverter implements AttributeConverter<Map<String,Integer>, String> {

	@Override
	public String convertToDatastore(Map<String, Integer> map) {
		return map.entrySet().stream().map(entry -> entry.getKey() + "=" + entry.getValue()).collect(Collectors.joining(","));
	}

	@Override
	public Map<String, Integer> convertToAttribute(String datastoreValue) {
		Map <String, Integer> result = new HashMap <String, Integer>();
		String[] values = datastoreValue.split(",");
		for (String value : values) {
			result.put(value.split("=")[0], Integer.parseInt(value.split("=")[1]));
		}
		return result;
	}

}
