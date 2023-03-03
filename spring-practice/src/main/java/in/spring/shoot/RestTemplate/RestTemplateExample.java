package in.spring.shoot.RestTemplate;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = "/api/rest-template")
@Slf4j
public class RestTemplateExample {
	
	/*
	 * In this example we are mentioning that take response data as json string itself
	 */
	@GetMapping("/example-one")
	public void getTodoByIdAsJsonString() {
		/*
		 * URL : https://jsonplaceholder.typicode.com/todos/1
		 */
		String url = "https://jsonplaceholder.typicode.com/todos/1";
		RestTemplate restTemplate = new RestTemplate();
		
		/*
		 * Here I am taking Response Type as String.class because returned JSON is nothing but a string , json string and
		 * I am taking it as it is here
		 */
		ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.GET, null, String.class);
		log.info("STATUS CODE :: {}" , responseEntity.getStatusCode()); // STATUS CODE :: 200 OK
		log.info("BODY :: {}" , responseEntity.getBody()); // BODY :: {"userId": 1,"id": 1,"title": "delectus aut autem","completed": false} - JSON String
		log.info("HEADERS :: {}" , responseEntity.getHeaders()); // HEADERS :: [Date:"Fri, 03 Mar 2023 10:22:44 GMT", Content-Type:"application/json; charset=utf-8", Content-Length:"83", Connection:"keep-alive", X-Powered-By:"Express", X-Ratelimit-Limit:"1000", X-Ratelimit-Remaining:"999", X-Ratelimit-Reset:"1676008703", Vary:"Origin, Accept-Encoding", Access-Control-Allow-Credentials:"true", Cache-Control:"max-age=43200", Pragma:"no-cache", Expires:"-1", X-Content-Type-Options:"nosniff", Etag:"W/"53-hfEnumeNh6YirfjyjaujcOPPT+s"", Via:"1.1 vegur", CF-Cache-Status:"HIT", Age:"27670", Accept-Ranges:"bytes", Server-Timing:"cf-q-config;dur=6.0000002122251e-06", Report-To:"{"endpoints":[{"url":"https:\/\/a.nel.cloudflare.com\/report\/v3?s=t10Z2BbAnWY3Lzt%2B%2F7DJhVEdrEjI737%2ByGz%2B2msKw%2F8JxTqdHhObFzgt%2FDMEiCmP5v0B%2F7xPpcjmXuYlF0M9UMMrT0ncbybl6AhPjUy%2FW3kiJwQl6BaYW4WEjbWoE9qUZFMP0z7gfzZUz2QiIqxa"}],"group":"cf-nel","max_age":604800}", NEL:"{"success_fraction":0,"report_to":"cf-nel","max_age":604800}", Server:"cloudflare", CF-RAY:"7a2128f79915032b-AMD", alt-svc:"h3=":443"; ma=86400, h3-29=":443"; ma=86400"]
		log.info("STATUS CODE VALUE :: {}", responseEntity.getStatusCodeValue()); // STATUS CODE VALUE :: 200
		
	}
	
	/*
	 * In this example we are mentioning that take response data as TaskDTO object and we are metnioning only those properties in TaskDTO 
	 * class that we need from response.
	 * Suppose response type class has 100 properties but we need only 5 so we will take only 5 properties in our created class (Ex : TaskDTO)
	 */
	@GetMapping("/example-two")
	public void getTodoByIdAsTaskDTOObject() {
		/*
		 * URL : https://jsonplaceholder.typicode.com/todos/1
		 */
		String url = "https://jsonplaceholder.typicode.com/todos/1";
		RestTemplate restTemplate = new RestTemplate();
		
		/*
		 * Here I am taking Response Type as TaskDTO.class which will tell to rest template that convert coming JSON string into
		 * TaskDTO with mappped properties and if any properties is not in my TaskDTO then just ignore it.
		 */
		ResponseEntity<TaskDTO> responseEntity = restTemplate.exchange(url, HttpMethod.GET, null, TaskDTO.class);
		log.info("STATUS CODE :: {}" , responseEntity.getStatusCode()); // STATUS CODE :: 200 OK
		log.info("BODY :: {}" , responseEntity.getBody()); // BODY :: TaskDTO(id=1, title=delectus aut autem) - Not json string
		log.info("HEADERS :: {}" , responseEntity.getHeaders()); // HEADERS :: [Date:"Fri, 03 Mar 2023 10:22:44 GMT", Content-Type:"application/json; charset=utf-8", Content-Length:"83", Connection:"keep-alive", X-Powered-By:"Express", X-Ratelimit-Limit:"1000", X-Ratelimit-Remaining:"999", X-Ratelimit-Reset:"1676008703", Vary:"Origin, Accept-Encoding", Access-Control-Allow-Credentials:"true", Cache-Control:"max-age=43200", Pragma:"no-cache", Expires:"-1", X-Content-Type-Options:"nosniff", Etag:"W/"53-hfEnumeNh6YirfjyjaujcOPPT+s"", Via:"1.1 vegur", CF-Cache-Status:"HIT", Age:"27670", Accept-Ranges:"bytes", Server-Timing:"cf-q-config;dur=6.0000002122251e-06", Report-To:"{"endpoints":[{"url":"https:\/\/a.nel.cloudflare.com\/report\/v3?s=t10Z2BbAnWY3Lzt%2B%2F7DJhVEdrEjI737%2ByGz%2B2msKw%2F8JxTqdHhObFzgt%2FDMEiCmP5v0B%2F7xPpcjmXuYlF0M9UMMrT0ncbybl6AhPjUy%2FW3kiJwQl6BaYW4WEjbWoE9qUZFMP0z7gfzZUz2QiIqxa"}],"group":"cf-nel","max_age":604800}", NEL:"{"success_fraction":0,"report_to":"cf-nel","max_age":604800}", Server:"cloudflare", CF-RAY:"7a2128f79915032b-AMD", alt-svc:"h3=":443"; ma=86400, h3-29=":443"; ma=86400"]
		log.info("STATUS CODE VALUE :: {}", responseEntity.getStatusCodeValue()); // STATUS CODE VALUE :: 200
		
	}
	
	/*
	 * If any one returning List as top node then give response type as array and after that convert that array into list as shown below
	 * why we need to convert into list because if you print array then you may see there less records but when you convert into list then
	 * you will see all records
	 */
	@GetMapping("/example-three")
	public void getUserListAsUserArrayIfTheySendListAsRootNode() {
		/*
		 * URL : https://jsonplaceholder.typicode.com/users
		 */
		String url = "https://jsonplaceholder.typicode.com/users";
		RestTemplate restTemplate = new RestTemplate();
		
		
		ResponseEntity<User[]> responseEntity = restTemplate.getForEntity(url, User[].class);
		
		User[] usersArray = responseEntity.getBody();
		
		List<User> users = Arrays.asList(usersArray);
		
		log.info("USERS :: {}" , users);
				
	}
	
}
