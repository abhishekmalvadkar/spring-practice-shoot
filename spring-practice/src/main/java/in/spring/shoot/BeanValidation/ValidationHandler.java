package in.spring.shoot.BeanValidation;

import static java.util.stream.Collectors.toList;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//@ControllerAdvice
@RestControllerAdvice
public class ValidationHandler {
	
	/*
	 * Case 1 : If you use @ControllerAdvice and if you are returning your custom object then you need to use @ResponseBody 
	 *          to tell spring boot to convert your object as json otherwise you will get an error.
	 * Case 2 : If you use @ControllerAdvice and if you are returning ResponseEntity object then you no need to use @ResponseBody
	 *          because ResponseEntity will take care of JSON conversion
	 * Case 3 : If you are returning your custom object then use @RestControllerAdvice over @ControllerAdvice + @ResponseBody
	 *          Beacause @RestControllerAdvice =  @ControllerAdvice + @ResponseBody    
	 *        
	 */
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
//	@ResponseBody
	public ApiResponseBody<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
		List<String> errors = ex.getBindingResult().getAllErrors().stream().map(ObjectError::getDefaultMessage)
		.collect(toList());
		return new ApiResponseBody<>(errors, HttpStatus.BAD_REQUEST.value());
//		return new ResponseEntity<>(new ApiResponseBody<>(errors, HttpStatus.BAD_REQUEST.value()), HttpStatus.OK);
	}

}
