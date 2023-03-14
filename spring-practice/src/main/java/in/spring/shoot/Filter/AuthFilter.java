package in.spring.shoot.Filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@Order(2)
public class AuthFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		/*
		 * Above here write code whatever you want to do with request
		 */
		boolean isValidUser = true; // this true or false will come based on your auth model logic
		if (!isValidUser) {
			log.info("Set your error response in response");
			return; // only return means telling don't exceute futher filter or controller and send respone to client
		}
		log.trace("User is authenticated succesfully....");
		chain.doFilter(request, response); // Telling that go ahead to call next filter or controller
		
		
	}

}
