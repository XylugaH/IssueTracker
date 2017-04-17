package com.xylugah.issuetracker.converter;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;

import com.xylugah.issuetracker.entity.Type;
import com.xylugah.issuetracker.service.TypeService;

public class TypeIdToTypeConverter implements Converter<String, Type> {

	private static final Logger logger = LoggerFactory.getLogger(TypeIdToTypeConverter.class);

	@Resource(name = "TypeService")
	private TypeService typeService;

	@Override
	public Type convert(final String id) {
		try {
			Integer typeId = Integer.valueOf(id);
			return typeService.getById(typeId);
		} catch (NumberFormatException e) {
			logger.error("Invalid id", e);
			return null;
		}
	}
}
