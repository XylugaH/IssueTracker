package com.xylugah.issuetracker.converter;

import javax.annotation.Resource;

import org.springframework.core.convert.converter.Converter;

import com.xylugah.issuetracker.entity.User;
import com.xylugah.issuetracker.service.UserService;

public class UserIdToUserConverter implements Converter<String, User>{

	@Resource(name ="UserService")
	private UserService userService;
	
	@Override
	public User convert(final String id) {
		try {
            Integer userId = Integer.valueOf(id);
            return userService.getById(userId);
        } catch (NumberFormatException e) {
            return null;
        }
	}
}
