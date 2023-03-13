package in.spring.shoot.RequestParamValidation;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/request-param-validation")
@Validated
public class RequestParamValidationExample {

	/*
	 * Here i have created @RequestParamNotNull custom validation annotation
	 * because param is coming as string "null" which we need to check explicilty
	 * in this case existing @NotNull javax.validation is not helping us because it is
	 * not checking with "null" as string , it is checking with null as value
	 */
	@GetMapping(value = "/users")
	public String getUserByCountryAndUserId(
			@RequestParam("country")
			@RequestParamNotNull(message = "country should not be null")
			@NotBlank(message = "country name should not be empty") String countryName,
			@RequestParam("userId") @Positive(message = "user id should be greater then zero")
			Integer userId) {
		return String.format("User country is %s and user id is %s", countryName, userId);
	}

}
