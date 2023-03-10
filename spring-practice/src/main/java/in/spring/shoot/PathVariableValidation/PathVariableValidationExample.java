package in.spring.shoot.PathVariableValidation;

import javax.validation.constraints.Positive;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/path-variable-validation")
@Validated // if you don't put this annotation at class level here then your javax.validation annoattion will not work on handler method parameters
public class PathVariableValidationExample {
	
	/*
	 * Case 1 : http://localhost:8080/api/path-variable-validation/todos/1 
	 * 			- this is valid
	 * 			- It will not throw any exception
	 * Case 2 : http://localhost:8080/api/path-variable-validation/todos/-1
	 * 			- this should not be valid
	 * 			- It will not throw any exception but it should throw exception that it is invalid
	 * Case 3 : http://localhost:8080/api/path-variable-validation/todos/0
	 * 			- this should not be valid
	 * 			- It will not throw any exception but it should throw exception that it is invalid
	 * Case 4 : http://localhost:8080/api/path-variable-validation/todos/abhi
	 * 			- this will throw exception
	 * 			- this should be in valid
	 */
	@GetMapping(value = "/todos/{id}")
	public String getTodoById(@PathVariable("id") Integer todoId) {
		return String.format("Todo id is %s", todoId);
	}
	
	/*
	 * Let us handle path variable validation for above cases
	 * - We need to think in two ways
	 * 1) If any javax.validation annotation we can apply on handler method path varibale parameter, if yes then see 
	 *    which exception it throws on validation violation and we need to handle that exception and send customized error response.
	 * 2) If any javax.validation annotation we are not able to apply on handler method path varibale parameter
	 * 	   for a particular case then see which exception it throws and handle that exception and send customized error response.
	 * 
	 * - We will get javax.validation.ConstraintViolationException if applied java.validation annoatation violates now we need to handle it
	 * - We will get org.springframework.web.method.annotation.MethodArgumentTypeMismatchException exception if we pass string "abc" in
	 *   id path parameter so we need to handle this exception
	 * 
	 * * Final thoughts
	 * - You can create custom validation annotation according to your requirement and we can apply that annotation 
	 *   on path varibale parameter
	 * - If you will have Many validation annotations on path parameter acccording to your requirement then you can 
	 *   create one custom normal annoation and supress all annotations inside it and use that single annotation here 
	 *   like @SpringBootAppliccation annotation a combination of multiple annotation
	 * 
	 */
	@GetMapping(value = "/task/{id}")
	public String getTodoByIdWithValidation(@PathVariable("id") @Positive(message = "todo path parameter value should be greater then zero") Integer todoId) {
		return String.format("Task id is %s", todoId);
	}
	

}
