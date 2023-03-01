package in.spring.shoot.BeanValidation;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//@RestController
@Controller
@RequestMapping(value = "/api")
public class TimesheetController {
	
	@PostMapping("/timesheets")
	@ResponseBody
	public ApiResponseBody<Timesheet> createTimesheet(@Valid @RequestBody Timesheet timesheet) {
		return new ApiResponseBody<>(timesheet, HttpStatus.CREATED.value());
	}
	
	/*
	 * Testing that does ResponseEntity need @ResponseBody annotation or not? 
	 */
	@PostMapping("/test")
	public ResponseEntity<Timesheet> test(@RequestBody Timesheet timesheet) {
		return new ResponseEntity<>(timesheet, HttpStatus.OK); // it will work fine , no error will come
	}
	
}
