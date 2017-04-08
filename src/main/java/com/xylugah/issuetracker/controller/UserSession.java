package com.xylugah.issuetracker.controller;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import com.xylugah.issuetracker.entity.User;
import com.xylugah.issuetracker.service.UserService;

@Component
@Scope(value = "session")
//, proxyMode = ScopedProxyMode.INTERFACES)
public class UserSession {
	static {
		System.out.println("1");
	}

	@Resource(name = "UserService")
	private UserService userService;

	User user;
	
	public UserSession(){
		this.user = userService.getById(1);
	}
	
}
