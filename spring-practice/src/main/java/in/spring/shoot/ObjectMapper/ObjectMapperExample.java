package in.spring.shoot.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = "/api/object-mapper")
@Slf4j
public class ObjectMapperExample {
	
	@GetMapping("/example-one")
	public String exampleOne() {
		
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
		String todoAsJsonString = responseEntity.getBody();
		return todoAsJsonString; // Returning json string directly because at the end we need to return json from controller end point
		                         // I have saved job of spring boot jackson
		
	}
	
	@GetMapping("/example-two")
	public TodoDTO exampleTwo() {
		
		/*
		 * URL : https://jsonplaceholder.typicode.com/todos/1
		 */
		String url = "https://jsonplaceholder.typicode.com/todos/1";
		RestTemplate restTemplate = new RestTemplate();
		
		/*
		 * Here I am taking Response Type as TodoDTO.class
		 */
		ResponseEntity<TodoDTO> responseEntity = restTemplate.exchange(url, HttpMethod.GET, null, TodoDTO.class);
		TodoDTO todoDTO = responseEntity.getBody();
		todoDTO.setType("My GIven Type"); // In Todo class I have taken custom property which is not in responsed todo and here
		                                  // I am seeting our custom property value
		
		return todoDTO; // Returning directly object because object to json conversion will be take care by jackson library automatically
		
		
	}
	
	/*
	 * Let's see how we can do object to json and json to object conversion by our self
	 */
	@GetMapping("/example-three")
	public String exampleThree() {
		
		/*
		 * URL : https://jsonplaceholder.typicode.com/todos/1
		 */
		String url = "https://jsonplaceholder.typicode.com/todos/1";
		RestTemplate restTemplate = new RestTemplate();
		
		/*
		 * Here I am taking Response Type as Json string
		 */
		ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.GET, null, String.class);
		String todoAsJsonString = responseEntity.getBody();
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		try {
			// Converting json string into object
			TodoDTO todoDTO = objectMapper.readValue(todoAsJsonString, TodoDTO.class);
			todoDTO.setType("My given type value");
			
			// Converting object into json string
			String todoResultAsJsonString = objectMapper.writeValueAsString(todoDTO);
			
			return todoResultAsJsonString;
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e.getMessage());
		}
		
		
	}
	
	/*
	 * Let's see how we can take the data from json file and convert it into object and then send
	 */
	@GetMapping("/example-four")
	public TodoDTO exampleFour() throws StreamReadException, DatabindException, IOException {
		
		Path todoJsonFilePath = Paths.get("src/main/resources/ObjectMapperExample/todo.json");
		
		BufferedReader reader = Files.newBufferedReader(todoJsonFilePath);
		
		ObjectMapper objectMapper = new ObjectMapper();
		TodoDTO todoDTO = objectMapper.readValue(reader, TodoDTO.class);
		return todoDTO;
		
		
		
		
	}

}
