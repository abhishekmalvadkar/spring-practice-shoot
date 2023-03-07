package in.spring.shoot.ObjectMapper;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TodoDTO {
	
	private Integer userId;
	
	private Integer id;
	
	private String title;
	
	private boolean completed;
	
	/*
	 * This varibale is not in todo which is coming from another API , we are adding this according to our need
	 */
	private String type;

}
