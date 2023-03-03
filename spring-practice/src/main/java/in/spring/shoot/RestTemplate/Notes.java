package in.spring.shoot.RestTemplate;

public class Notes {
	
	/*
	 * In RestTemplate you need to keep in mind below three methods
	 * - exchange(-)
	 * - getForEntity(-) : same for other http method type
	 * - getForObject(-) : same for other http method type
	 * 
	 * * excahnge(-)
	 * - You can use it for any http method type
	 * - It will give you ResponseEntity so in this case you will have 
	 *   - Response body
	 *   - Response status
	 *   - Response headers
	 *   - Response status code value
	 *   
	 * * getForEntity(-)
	 * - You can use it for GET http method type and other same type of methods you will use for respective http method type
	 * - It will give you ResponseEntity so in this case you will have 
	 *   - Response body
	 *   - Response status
	 *   - Response headers
	 *   - Response status code value
	 *   
	 * * getForObject(-)
	 * - You can use it for GET http method type and other same type of methods you will use for respective http method type
	 * - It will give you direct object only which is coming in response body
	 * - It will not give you ResponseEntity so in this case you will not have 
	 *   - Response body
	 *   - Response status
	 *   - Response headers
	 *   - Response status code value
	 *   
	 * Note : You can mention response type as below
	 *       - String.class Means You need JSON string - So you can deserialize it manually using ObjectMapper class 
	 *       - User[].class Means API is returning list json string as top node and you want to deseralize coming array JSON string into your User[]
	 *       	- Best practice take as User[] and then convert into List so data will not be loss
	 *       - User.class Means you want to deseralize coming JSON string into your User object
	 * Note : Always take only required properties into your DTO(User) class so rest template only map them only at the time of deseralization. 
	 * 		
	 * 
	 */

}
