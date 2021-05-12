package com.revature.aspect;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.revature.template.MessageTemplate;

@Aspect
@Component
public class AuthorizationAspect {

	@Autowired
	private HttpServletRequest request;
	@Autowired
	private HttpServletResponse response;
	
	@Around("@annotation(com.revature.annotations.LoggedInOnly)")
	public ResponseEntity<Object> protectEndpointForLoggedInUsersOnly(ProceedingJoinPoint pjp) throws Throwable {
		
		HttpSession session = request.getSession(false);
		
		if (session == null || session.getAttribute("loggedInUser") == null) {
			return ResponseEntity.status(401)
					.body(new MessageTemplate("You must be logged in to access this resource"));
		}
		// In order to execute the method annotated with UserOnly, we need to do
		ResponseEntity<Object> result = (ResponseEntity<Object>) pjp.proceed(pjp.getArgs());
		
		return result;
	}

}
