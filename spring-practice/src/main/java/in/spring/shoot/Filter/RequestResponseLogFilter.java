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
@Order(1)
public class RequestResponseLogFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		/*
		 * Above here write code whatever you want to do with request
		 */
		log.trace("Request logged here");
		chain.doFilter(request, response); // Telling that go ahead to call next filter or controller
		/*
		 * Below here write code whatever you want to do with response
		 */
		log.trace("Response logged here with time its taken to complete");
	}

}
