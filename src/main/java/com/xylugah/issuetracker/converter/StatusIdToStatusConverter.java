package com.xylugah.issuetracker.converter;

import javax.annotation.Resource;

import org.springframework.core.convert.converter.Converter;

import com.xylugah.issuetracker.entity.Status;
import com.xylugah.issuetracker.service.StatusService;

public class StatusIdToStatusConverter implements Converter<String, Status> {

	@Resource(name = "StatusService")
	private StatusService statusService;

	@Override
	public Status convert(final String id) {
		try {
			Integer statusId = Integer.valueOf(id);
			return statusService.getById(statusId);
		} catch (NumberFormatException e) {
			return null;
		}
	}
}