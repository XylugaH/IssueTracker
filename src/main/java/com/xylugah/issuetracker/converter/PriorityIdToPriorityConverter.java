package com.xylugah.issuetracker.converter;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;

import com.xylugah.issuetracker.entity.Priority;
import com.xylugah.issuetracker.service.PriorityService;

public class PriorityIdToPriorityConverter implements Converter<String, Priority> {

	private static final Logger logger = LoggerFactory.getLogger(PriorityIdToPriorityConverter.class);
	
	@Resource(name = "PriorityService")
	private PriorityService priorityService;

	@Override
	public Priority convert(final String id) {
		try {
			Integer priorityId = Integer.valueOf(id);
			return priorityService.getById(priorityId);
		} catch (NumberFormatException e) {
			logger.error("Invalid id", e);
			return null;
		}
	}
}
