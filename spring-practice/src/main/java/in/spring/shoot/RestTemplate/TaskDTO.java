package in.spring.shoot.RestTemplate;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/*
 * Response has following properties : {
  "userId": 1,
  "id": 1,
  "title": "delectus aut autem",
  "completed": false
} but I need only few of them so I will take only those properties in my DTO/Wrapper class so rest template
will only map them and others will be ignored
 */
@Getter
@Setter
@ToString
public class TaskDTO {
	
	private Integer id;
	
	private String title;

}
