package in.spring.shoot.BeanValidation.CustomAnnotationForValidation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Retention(RUNTIME)
@Target({ FIELD, PARAMETER })
/*
 * This @Constraint annotation will tell to hibernate validator that which class should be use
 * to validate work type value
 */
@Constraint(validatedBy = WorkTypeValidator.class)
public @interface WorkType {
	
	String message() default "Set your default violation message here"; // copy this from other javax validation annotation
	
	Class<?>[] groups() default { }; // copy this from other javax validation annotation

	Class<? extends Payload>[] payload() default { }; // copy this from other javax validation annotation

}
