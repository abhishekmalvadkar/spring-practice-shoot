package in.spring.shoot.Filter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = "/api/filter-example")
@Slf4j
public class FilterExample {
	
	@GetMapping(value = "/todos")
	public void getAllTodos() {
		log.trace("<<<<<<<< getAllTodos()");
		log.info("Processed request...");
		log.trace("getAllTodos() >>>>>>");
	}

}
