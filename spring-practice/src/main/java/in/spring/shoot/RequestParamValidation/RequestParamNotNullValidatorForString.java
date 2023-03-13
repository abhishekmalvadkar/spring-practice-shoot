package in.spring.shoot.RequestParamValidation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class RequestParamNotNullValidatorForString implements ConstraintValidator<RequestParamNotNull, String> {

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (value.equals("null")) {
			return false;
		}
		
		return true;
	}

}
