package in.spring.shoot.JAXBContext;

import java.io.StringReader;
import java.io.StringWriter;
import java.util.Arrays;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = "/api/jaxb-context")
@Slf4j
public class JAXBContextExample {
	
	@GetMapping(value = "/example-one" , produces = {"application/json" , "application/xml"})
	public TodoDTO exampleOne() {
		
		return TodoDTO.builder()
		   .userId(1)
		   .title("Add timesheet")
		   .completed(false)
		   .type("Misc")
		   .id(10)
		   .build();
		   
	}
	
	/*
	 * Here I have requested above method as rest call and asked to return xml string
	 */
	@GetMapping("/example-two")
	public void exampleTwo() {
		
		String url = "http://localhost:8080/api/jaxb-context/example-one";
		RestTemplate restTemplate = new RestTemplate();
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_XML)); // asking to return response as xml
		
		HttpEntity<Object> httpEntity = new HttpEntity<>(null, httpHeaders);
		
		
		
		/*
		 * Here I am taking response type as String.class because I want to take response as xml string
		 */
		ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.GET, httpEntity, String.class);
		log.info("STATUS CODE :: {}" , responseEntity.getStatusCode()); // STATUS CODE :: 200 OK
		log.info("BODY :: {}" , responseEntity.getBody()); // BODY :: <?xml version="1.0" encoding="UTF-8" standalone="yes"?><todoDTO><completed>false</completed><title>Add timesheet</title><type>Misc</type><userId>1</userId></todoDTO> - xml string
		log.info("HEADERS :: {}" , responseEntity.getHeaders()); // HEADERS :: [Content-Type:"application/xml", Transfer-Encoding:"chunked", Date:"Thu, 09 Mar 2023 11:50:26 GMT", Keep-Alive:"timeout=60", Connection:"keep-alive"]
		log.info("STATUS CODE VALUE :: {}", responseEntity.getStatusCodeValue()); // STATUS CODE VALUE :: 200
		
	}
	
	/*
	 * Here I will take response as xml string and then convert that xml into object and return
	 */
	@GetMapping(value = "/example-three" , produces = {"application/json" , "application/xml"})
	public TodoDTO exampleThree() {
		
		String url = "http://localhost:8080/api/jaxb-context/example-one";
		RestTemplate restTemplate = new RestTemplate();
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_XML)); // asking to return response as xml
		
		HttpEntity<Object> httpEntity = new HttpEntity<>(null, httpHeaders);
		
		
		
		/*
		 * Here I am taking response type as String.class because I want to take response as xml string
		 */
		ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.GET, httpEntity, String.class);
		String todoAsXmlString = responseEntity.getBody();
		
		JAXBContext jaxbContext;
		try {
			jaxbContext = JAXBContext.newInstance(TodoDTO.class);
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			StringReader reader = new StringReader(todoAsXmlString);
			TodoDTO todoDTO = (TodoDTO) unmarshaller.unmarshal(reader);
			return todoDTO;
		} catch (JAXBException e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	
	/*
	 * Here I will take response as xml string and then convert that xml into object and change something again convert object into xml string and return
	 */
	@GetMapping(value = "/example-four")
	public String exampleFour() {
		
		String url = "http://localhost:8080/api/jaxb-context/example-one";
		RestTemplate restTemplate = new RestTemplate();
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_XML)); // asking to return response as xml
		
		HttpEntity<Object> httpEntity = new HttpEntity<>(null, httpHeaders);
		
		
		
		/*
		 * Here I am taking response type as String.class because I want to take response as xml string
		 */
		ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.GET, httpEntity, String.class);
		String todoAsXmlString = responseEntity.getBody();
		
		JAXBContext jaxbContext;
		try {
			jaxbContext = JAXBContext.newInstance(TodoDTO.class);
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			StringReader reader = new StringReader(todoAsXmlString);
			TodoDTO todoDTO = (TodoDTO) unmarshaller.unmarshal(reader);
			
			todoDTO.setTitle("Changed titile");
			
			StringWriter writer = new StringWriter();
			
			Marshaller marshaller = jaxbContext.createMarshaller();
			marshaller.marshal(todoDTO, writer);
			
			
			
			return writer.toString();
		} catch (JAXBException e) {
			throw new RuntimeException(e.getMessage());
		}
	}

}
