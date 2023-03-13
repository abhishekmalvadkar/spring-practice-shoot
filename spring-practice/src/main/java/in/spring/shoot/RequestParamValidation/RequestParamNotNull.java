package in.spring.shoot.RequestParamValidation;

import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Retention(RUNTIME)
@Target(PARAMETER)
@Constraint(validatedBy = {RequestParamNotNullValidatorForString.class})
public @interface RequestParamNotNull {
	
	String message() default "Request param should not be null";

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };

}
