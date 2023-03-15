package in.spring.shoot.Async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class NotificationHelper {
	
	/*
	 * This method is annoted with @Async annotation means this method call will exceute asynchronously by different
	 * thread
	 * 
	 * In order to work this @Async annotation you have to also add @EnableAsync annotation on main class
	 * 
	 *  We are doing this so our client no need to wait for response (Performance optimizatopn)
	 */
	@Async
	public void sendEmail() {
		log.info("Sending email about ticket booked sucessfully....");
		log.info("sendEmail() method code is processed by thread :: {}" , Thread.currentThread().getName());
	}

}
