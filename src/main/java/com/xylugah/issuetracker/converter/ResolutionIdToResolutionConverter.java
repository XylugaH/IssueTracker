package com.xylugah.issuetracker.converter;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;

import com.xylugah.issuetracker.entity.Resolution;
import com.xylugah.issuetracker.service.ResolutionService;

public class ResolutionIdToResolutionConverter implements Converter<String, Resolution> {

	private static final Logger logger = LoggerFactory.getLogger(ResolutionIdToResolutionConverter.class);
	
	@Resource(name = "ResolutionService")
	private ResolutionService resolutionService;

	@Override
	public Resolution convert(final String id) {
		try {
			Integer resolutionId = Integer.valueOf(id);
			return resolutionService.getById(resolutionId);
		} catch (NumberFormatException e) {
			logger.error("Invalid id", e);
			return null;
		}
	}
}
