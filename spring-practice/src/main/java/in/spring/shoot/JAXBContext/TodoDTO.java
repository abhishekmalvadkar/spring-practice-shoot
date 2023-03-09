package in.spring.shoot.JAXBContext;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@XmlRootElement
@NoArgsConstructor
@AllArgsConstructor
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
