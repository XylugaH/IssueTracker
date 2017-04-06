package com.xylugah.issuetracker.converter;

import javax.annotation.Resource;

import org.springframework.core.convert.converter.Converter;

import com.xylugah.issuetracker.entity.Priority;
import com.xylugah.issuetracker.service.PriorityService;

public class PriorityIdToPriorityConverter implements Converter<String, Priority> {

	@Resource(name = "PriorityService")
	private PriorityService priorityService;

	@Override
	public Priority convert(final String id) {
		try {
			Integer priorityId = Integer.valueOf(id);
			return priorityService.getById(priorityId);
		} catch (NumberFormatException e) {
			return null;
		}
	}
}
