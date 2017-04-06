package com.xylugah.issuetracker.converter;

import javax.annotation.Resource;

import org.springframework.core.convert.converter.Converter;

import com.xylugah.issuetracker.entity.Resolution;
import com.xylugah.issuetracker.service.ResolutionService;

public class ResolutionIdToResolutionConverter implements Converter<String, Resolution> {

	@Resource(name = "ResolutionService")
	private ResolutionService resolutionService;

	@Override
	public Resolution convert(final String id) {
		try {
			Integer resolutionId = Integer.valueOf(id);
			return resolutionService.getById(resolutionId);
		} catch (NumberFormatException e) {
			return null;
		}
	}
}
