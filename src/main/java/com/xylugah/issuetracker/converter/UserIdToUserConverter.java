package com.xylugah.issuetracker.converter;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;

import com.xylugah.issuetracker.entity.User;
import com.xylugah.issuetracker.service.UserService;

public class UserIdToUserConverter implements Converter<String, User>{

	private static final Logger logger = LoggerFactory.getLogger(UserIdToUserConverter.class);

	@Resource(name ="UserService")
	private UserService userService;
	
	@Override
	public User convert(final String id) {
		try {
            Integer userId = Integer.valueOf(id);
            return userService.getById(userId);
        } catch (NumberFormatException e) {
        	logger.error("Invalid id", e);
            return null;
        }
	}
}
