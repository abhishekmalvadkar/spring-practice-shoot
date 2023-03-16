package in.spring.shoot.AOPAsyncAndSyncBehaviour;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.spring.shoot.Async.AsyncExample;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = "/api/aop-async-and-sync-behaviour")
@Slf4j
public class AOPAsyncAnsSycBehaviour {
	
	@GetMapping("/book-ticket")
	@LogMethodEntryExit
	public String bookTicket() {
		String name="abhishek";
		log.info("from bookTicket :: {}" , name);
		log.info("Saving book ticket information inside database table....");
		log.info("bookTicket() method code is processed by thread :: {}" , Thread.currentThread().getName());
		return "Congrats !! Your ticket booked sucessfully";
	}
	
	@GetMapping("/test-around-advice")
	@CacheResponse
	public String testAroundAdvice() {
		log.info("Saving book ticket information inside database table....");
		log.info("bookTicket() method code is processed by thread :: {}" , Thread.currentThread().getName());
		return "Congrats !! Your ticket booked sucessfully";
	}

}
