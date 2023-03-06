package in.spring.shoot.RestTemplate.RestTemplateBuilder;

import java.time.Duration;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.client.RootUriTemplateHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriTemplateHandler;

@Configuration
public class AppConfig {

	/*
	 * - RestTemplateBuilder is a stanadrd approach to create rest template object
	 * - As rest template class does not have state changes so we can think about to put it into spring context as spring bean
	 * - By using rest template builder you can set lots of things into rest template object easily like
	 *    - Setting Base URL(This will reduce duplicates)
	 *    - Setting Read Time out(This will prevent poort user experience)
	 * - Spring will give you RestTemplateBuilder object from spring context to build restTemplate object
	 * - If caller rest api does not send response in given read timout time then it will throw SocketTimeoutException
	 * - In microservice aarchitecture you can create multiple rest template objects based on your customization like below
	 * - As creative , you need to check by doing builder. and you can see lots of things that you can set in rest template object
	 *   in order to achvive something.
	 */
	@Bean(name = "todo-service")
	public RestTemplate todoRestTemplate(RestTemplateBuilder builder) {
		UriTemplateHandler uriTemplateHandler = new RootUriTemplateHandler("https://jsonplaceholder.typicode.com");
		return builder
//				.rootUri("https://jsonplaceholder.typicode.com") // 1st way
				.uriTemplateHandler(uriTemplateHandler) // 2nd way
				.setReadTimeout(Duration.ofMillis(1000))
				.build();
	}
	
	@Bean(name = "user-service")
	public RestTemplate userRestTemplate(RestTemplateBuilder builder) {
		UriTemplateHandler uriTemplateHandler = new RootUriTemplateHandler("https://user.service.com");
		return builder
//				.rootUri("https://jsonplaceholder.typicode.com") // 1st way
				.uriTemplateHandler(uriTemplateHandler) // 2nd way
				.setReadTimeout(Duration.ofMillis(2000))
				.build();
	}
	
}
