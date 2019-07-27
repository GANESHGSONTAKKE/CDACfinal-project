package com.cdac.project.security;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler{

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());

        if (roles.contains("APPLICANT")) {
        	response.sendRedirect("/applicant");
        } 
        else if (roles.contains("FACULTY_ADMIN")) {
        	response.sendRedirect("/fadmin");
        }
        else if (roles.contains("COURSE_ADMIN")) {
        	response.sendRedirect("/cadmin");
        }
        else if (roles.contains("FACULTY")) {
        	response.sendRedirect("/faculty");
        }else {
        	response.sendRedirect("/");
        }
		
		
	}

	
}
