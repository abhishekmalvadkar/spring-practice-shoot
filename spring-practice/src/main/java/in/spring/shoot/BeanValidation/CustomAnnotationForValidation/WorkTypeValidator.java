package in.spring.shoot.BeanValidation.CustomAnnotationForValidation;

import java.util.Arrays;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/*
 * - This class WorkTypeValidator needs to implement ConstraintValidator interface as built-in
 * 	 annotations are also implementing this interface(we need to do same as they do)
 * - Here in ConstraintValidator<WorkType, String> first generic parameter is your annotation type
 *   and second generic parameter is type of variable where you are going to use this your custom
 *   validation annotation. 
 */
public class WorkTypeValidator implements ConstraintValidator<WorkType, String> {

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		
		List<String> workTypes = Arrays.asList("CLIENT_PROJECT" , "IN_HOUSE_PROJECT");
		
		return workTypes.contains(value);
	}

}
