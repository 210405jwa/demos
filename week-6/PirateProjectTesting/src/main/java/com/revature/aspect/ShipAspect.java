package com.revature.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.revature.model.Ship;
import com.revature.template.MessageTemplate;

@Aspect
@Component
public class ShipAspect {

	// Template
	@Pointcut("execution(public * com.revature.controller.ShipController.getShipById(..))")
	public void getShipByIdMethodInShipController() {}
	
	// Utilizing pointcut template
	@Before("getShipByIdMethodInShipController()")
	public void adviceBeforeGetShipbyId(JoinPoint jp) {
		
		String method = jp.getSignature().toLongString();
		
		System.out.println("Executing @Before advice on method: " + method);
		// You could do logging, etc in here
		
	}
	
	@AfterReturning(
			pointcut = 
			"execution(public * com.revature.controller.ShipController.getShipById(..))",
			returning = "result")
	public void afterReturningGetShipById(JoinPoint jp, Object result) {
		
		Object[] args = jp.getArgs();
		for (Object o : args) {
			System.out.println(o);
		}
		
		if (result instanceof ResponseEntity) {
			Object obj = ((ResponseEntity) result).getBody();
			
			System.out.println(obj);
			
			if (obj instanceof MessageTemplate) {
				System.out.println("MessageTemplate's message: " + ((MessageTemplate) obj).getMessage());
			}
		}
	}
	
}
