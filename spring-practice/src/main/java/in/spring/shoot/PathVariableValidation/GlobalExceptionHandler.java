package in.spring.shoot.PathVariableValidation;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(value = {ConstraintViolationException.class , MethodArgumentTypeMismatchException.class})
	public Object handlePathVaribaleVoilationException(Exception e , HttpServletRequest request) {
		Map<String, Object> errorResponse = new LinkedHashMap<>();
		errorResponse.put("error", e.getMessage());
		errorResponse.put("status", HttpStatus.BAD_REQUEST.value());
		errorResponse.put("path", request.getServletPath());
		return errorResponse;
	}

}
