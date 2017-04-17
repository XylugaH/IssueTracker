package com.xylugah.issuetracker.converter;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;

import com.xylugah.issuetracker.entity.Role;
import com.xylugah.issuetracker.service.RoleService;

public class RoleIdToRoleConverter implements Converter<String, Role>{

	private static final Logger logger = LoggerFactory.getLogger(RoleIdToRoleConverter.class);
	
	@Resource(name ="RoleService")
	private RoleService roleService;
		
	@Override
	public Role convert(final String id) {
		try {
			Integer roleId = Integer.valueOf(id);
			return roleService.getById(roleId);
		} catch (NumberFormatException e) {
			logger.error("Invalid id", e);
			return null;
		}
	}

}
