package in.spring.shoot.BeanValidation;

import java.util.List;

import lombok.Getter;

@Getter
public class ApiResponseBody<T> {
	
	private T data;
	
	private Integer status;
	
	private List<String> errors;

	public ApiResponseBody(T data, Integer status) {
		this.data = data;
		this.status = status;
	}

	public ApiResponseBody(List<String> errors , Integer status) {
		this.errors = errors;
		this.status = status;
	}
	
	
	
	

}
