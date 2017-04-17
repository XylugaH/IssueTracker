package com.xylugah.issuetracker.converter;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;

import com.xylugah.issuetracker.entity.Build;
import com.xylugah.issuetracker.service.BuildService;

public class BuildIdToBuildConverter implements Converter<String, Build> {

	private static final Logger logger = LoggerFactory.getLogger(BuildIdToBuildConverter.class);
	
	@Resource(name = "BuildService")
	private BuildService buildService;

	@Override
	public Build convert(final String id) {
		try {
			Integer buildId = Integer.valueOf(id);
			return buildService.getById(buildId);
		} catch (NumberFormatException e) {
			logger.error("Invalid id", e);
			return null;
		}
	}
}
