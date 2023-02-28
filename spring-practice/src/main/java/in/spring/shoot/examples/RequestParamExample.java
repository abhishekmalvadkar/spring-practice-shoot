package in.spring.shoot.examples;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = "/api")
@Slf4j
public class RequestParamExample {

	/*
	 * @RequestMapping(value = "/example-one" , method = RequestMethod.GET) - Non-complied with sonar
	 * 
	 * 
	 * - @GetMapping(value = "/example-one") // complied with sonar
	 * - Our URL : http://localhost:8080/api/example-one?name=abhi&age=24
	 * 
	 * Case 1 : Front end developer has both things name and age then he will fire
	 * 			URL like below http://localhost:8080/api/example-one?name=abhi&age=24 and it
	 * 			will work 
	 * Case 2 : Front end developer has only one thing and that is name
	 * 			and he does not have age then he will fire URL like below
	 * 			http://localhost:8080/api/example-one?name=abhi and it will not work , if you
	 * 			want these has to be work then you can use required = falsE OR
	 * 			defaultValue="Your default value" for missing parameters , if you use required = "false" only, then age variable will be 
	 * 			null , if you want default value to be set then you can use defaultValue="Your default value"
	 * Case 3 : Note that , if you set defaultValue = "Something" then implicitly required is going to be set as false , you do not need
	 * 			need to set it manually
	 * - By default every parameter in URL is coming as string type
	 * - @RequestParam will convert URL parameter string type to your variable type like in below example it converts string age into
	 * 	 Integer based on userAge variable type.
	 * - But if you fetch URL parameter using HttpServletRequet then you have to convert URL parameter from string type to your desired
	 * 	 type manually like we did below in example two.
	 * 
	 * 
	 */

	@GetMapping(value = "/example-one")
	public void exampleOne(@RequestParam(name = "name") String userName,
			@RequestParam(name = "age", required = false , defaultValue = "25") Integer userAge) {
		log.info("<<<<< exampleOne()");
		log.info("USER NAME :: {}", userName);
		log.info("USER AGE :: {}", userAge);
		log.info("exampleOne() >>>>>");
	}
	
	/*
	 * Our URL : http://localhost:8080/api/example-two?name=abhi&age=24
	 */
	@GetMapping(value = "/example-two")
	public void exampleTwo(HttpServletRequest request) {
		log.info("<<<<< exampleTwo()");
		String userName = request.getParameter("name");
		String ageStr = request.getParameter("age");
		int userAge = Integer.parseInt(ageStr); // Manual conversion needed from string to int
		log.info("USER NAME :: {}" , userName);
		log.info("USER AGE :: {}" , userAge);
		log.info("exampleTwo() >>>>>");
	}

}
