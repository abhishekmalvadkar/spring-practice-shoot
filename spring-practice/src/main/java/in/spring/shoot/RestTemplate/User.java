package in.spring.shoot.RestTemplate;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class User {
	
	private Integer id;
	
	private String name;
	
	private String phone;
	
	private Company company;

}
