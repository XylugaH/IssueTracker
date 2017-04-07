package com.xylugah.issuetracker.converter;

import javax.annotation.Resource;

import org.springframework.core.convert.converter.Converter;

import com.xylugah.issuetracker.entity.Type;
import com.xylugah.issuetracker.service.TypeService;

public class TypeIdToTypeConverter implements Converter<String, Type> {

	@Resource(name = "TypeService")
	private TypeService typeService;

	@Override
	public Type convert(final String id) {
		try {
			Integer typeId = Integer.valueOf(id);
			return typeService.getById(typeId);
		} catch (NumberFormatException e) {
			return null;
		}
	}
}
