package com.xylugah.issuetracker.converter;

import javax.annotation.Resource;

import org.springframework.core.convert.converter.Converter;

import com.xylugah.issuetracker.entity.Role;
import com.xylugah.issuetracker.service.RoleService;

public class RoleIdToRoleConverter implements Converter<String, Role>{

	@Resource(name ="RoleService")
	private RoleService roleService;
		
	@Override
	public Role convert(final String id) {
		try {
			Integer roleId = Integer.valueOf(id);
			return roleService.getById(roleId);
		} catch (NumberFormatException e) {
			return null;
		}
	}

}
