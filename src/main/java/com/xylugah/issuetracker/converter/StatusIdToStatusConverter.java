package com.xylugah.issuetracker.converter;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;

import com.xylugah.issuetracker.entity.Status;
import com.xylugah.issuetracker.service.StatusService;

public class StatusIdToStatusConverter implements Converter<String, Status> {

	private static final Logger logger = LoggerFactory.getLogger(StatusIdToStatusConverter.class);

	@Resource(name = "StatusService")
	private StatusService statusService;

	@Override
	public Status convert(final String id) {
		try {
			Integer statusId = Integer.valueOf(id);
			return statusService.getById(statusId);
		} catch (NumberFormatException e) {
			logger.error("Invalid id", e);
			return null;
		}
	}
}