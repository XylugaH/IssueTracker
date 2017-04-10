package com.xylugah.issuetracker.exception;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

public class AccessDeniedHandlerImpl implements AccessDeniedHandler{

	private String errorPage;

	public AccessDeniedHandlerImpl() {
		
	}

	public AccessDeniedHandlerImpl(String errorPage) {
		this.errorPage = errorPage;
	}

	public String getErrorPage() {
		return errorPage;
	}

	public void setErrorPage(String errorPage) {
		this.errorPage = errorPage;
	}
	
	@Override
	public void handle(HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse,
			AccessDeniedException paramAccessDeniedException) throws IOException, ServletException {
		System.out.println("111");
		paramHttpServletResponse.sendRedirect(errorPage);
	}

}
