package com.xylugah.issuetracker.converter;

import javax.annotation.Resource;

import org.springframework.core.convert.converter.Converter;

import com.xylugah.issuetracker.entity.Build;
import com.xylugah.issuetracker.service.BuildService;

public class BuildIdToBuildConverter implements Converter<String, Build> {

	@Resource(name = "BuildService")
	private BuildService buildService;

	@Override
	public Build convert(final String id) {
		try {
			Integer buildId = Integer.valueOf(id);
			return buildService.getById(buildId);
		} catch (NumberFormatException e) {
			return null;
		}
	}
}
