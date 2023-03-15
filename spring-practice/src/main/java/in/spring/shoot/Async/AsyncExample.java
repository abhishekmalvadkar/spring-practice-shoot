package in.spring.shoot.Async;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = "/api/async")
@Slf4j
@RequiredArgsConstructor
public class AsyncExample {
	
	private final NotificationHelper notificationHelper;
	
	@GetMapping("/book-ticket")
	public String bookTicket() {
		log.info("Saving book ticket information inside database table....");
		log.info("bookTicket() method code is processed by thread :: {}" , Thread.currentThread().getName());
		this.notificationHelper.sendEmail(); // This code will exceute asynchronouse
		return "Congrats !! Your ticket booked sucessfully";
	}

}
