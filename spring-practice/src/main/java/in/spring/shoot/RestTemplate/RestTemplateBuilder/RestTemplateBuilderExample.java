package in.spring.shoot.RestTemplate.RestTemplateBuilder;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = "/api/rest-template-builder")
@Slf4j
public class RestTemplateBuilderExample {
	
	private final RestTemplate restTemplate;

	public RestTemplateBuilderExample(@Qualifier("todo-service") RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}


	/*
	 * In this example we are mentioning that take response data as json string
	 * itself
	 */
	@GetMapping("/example-one")
	public void getTodoByIdAsJsonString() {
		/*
		 * BASE URL : https://jsonplaceholder.typicode.com
		 * URL : /todos/1
		 */
		String url = "/todos/1"; // No need to set base url beacuse we have seted it in rest template object
		/*
		 * Here I am taking Response Type as String.class because returned JSON is
		 * nothing but a string , json string and I am taking it as it is here
		 */
		ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.GET, null, String.class);
		log.info("STATUS CODE :: {}", responseEntity.getStatusCode()); // STATUS CODE :: 200 OK
		log.info("BODY :: {}", responseEntity.getBody()); // BODY :: {"userId": 1,"id": 1,"title": "delectus aut
															// autem","completed": false} - JSON String
		log.info("HEADERS :: {}", responseEntity.getHeaders()); // HEADERS :: [Date:"Fri, 03 Mar 2023 10:22:44 GMT",
																// Content-Type:"application/json; charset=utf-8",
																// Content-Length:"83", Connection:"keep-alive",
																// X-Powered-By:"Express", X-Ratelimit-Limit:"1000",
																// X-Ratelimit-Remaining:"999",
																// X-Ratelimit-Reset:"1676008703", Vary:"Origin,
																// Accept-Encoding",
																// Access-Control-Allow-Credentials:"true",
																// Cache-Control:"max-age=43200", Pragma:"no-cache",
																// Expires:"-1", X-Content-Type-Options:"nosniff",
																// Etag:"W/"53-hfEnumeNh6YirfjyjaujcOPPT+s"", Via:"1.1
																// vegur", CF-Cache-Status:"HIT", Age:"27670",
																// Accept-Ranges:"bytes",
																// Server-Timing:"cf-q-config;dur=6.0000002122251e-06",
																// Report-To:"{"endpoints":[{"url":"https:\/\/a.nel.cloudflare.com\/report\/v3?s=t10Z2BbAnWY3Lzt%2B%2F7DJhVEdrEjI737%2ByGz%2B2msKw%2F8JxTqdHhObFzgt%2FDMEiCmP5v0B%2F7xPpcjmXuYlF0M9UMMrT0ncbybl6AhPjUy%2FW3kiJwQl6BaYW4WEjbWoE9qUZFMP0z7gfzZUz2QiIqxa"}],"group":"cf-nel","max_age":604800}",
																// NEL:"{"success_fraction":0,"report_to":"cf-nel","max_age":604800}",
																// Server:"cloudflare", CF-RAY:"7a2128f79915032b-AMD",
																// alt-svc:"h3=":443"; ma=86400, h3-29=":443";
																// ma=86400"]
		log.info("STATUS CODE VALUE :: {}", responseEntity.getStatusCodeValue()); // STATUS CODE VALUE :: 200

	}

}
