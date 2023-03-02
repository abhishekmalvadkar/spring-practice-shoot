package in.spring.shoot.BeanValidation;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import in.spring.shoot.BeanValidation.CustomAnnotationForValidation.WorkType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Timesheet {
	
	@NotEmpty(message = "Timesheet topic should not be null or empty")
	private String topic;
	
	@NotBlank(message = "Description should not be null or empty")
	private String description;
	
	@NotNull(message = "Hours should not be null")
	@Positive(message = "Hours should not be negative")
	private Integer hours;
	
	/*
	 * This shiuld be either CLIENT_PROJECT or IN_HOUSE_PROJECT any other should be treated
	 * as workType voilation
	 */
	@WorkType(message = "Work type should be either CLIENT_PROJECT or IN_HOUSE_PROJECT") // My custom validation annotation
	private String workType;
	

}
