package in.spring.shoot.BeanValidation;

public class Notes {
	
	
	public void myNotes() {
		/*
		 * - If you want to do bean validation then you have to add "spring-boot-starter-validation" dependency, inside it 
		 *   hibernate-validator dependency is coming.
		 *   
		 * @@NotEmpty
		 * - The annotated element must not be {@code null} nor empty.
		 * - Supported types are:
		 * 	- <li>{@code CharSequence} (length of character sequence is evaluated)</li>
		 * 	- <li>{@code Collection} (collection size is evaluated)</li>
		 * 	- <li>{@code Map} (map size is evaluated)</li>
		 * 	- <li>Array (array length is evaluated)</li>
		 * 
		 * - You do not need to remember that each and every annotation purpose
		 * - You have to use below trick : 
		 * - All bean validation annotations are from "javax.validation.constraints" package - This is like interface
		 *   and hibernate-validator given classes as implementation
		 * - Suppose if you are using @NotNull annotation and if you want to see implementation of these annotation then you have to do
		 *   like below steps : 
		 *   - Press ctrl+shift+T
		 *   - Enter NotEmptyValidator and this is implementation class for @NotEmpty annotation , you just need to sufix your
		 *   	annotation with "Validator" keyword while searching
		 *   - All these classes are implementing ConstraintValidator interface.
		 *   - Sometimes you are searching using above trick then you might get multiple implemtations means that anootation has
		 *     validations for many data types like below
		 *     if you are using @NotEmpty annotation then you will search like NotEmptyValidator then you will get implementation like
		 *     NotEmptyValidatorForCharSequence , NotEmptyValidatorForMap , NotEmptyValidatorForCollection etc.. means this annotation 
		 *     has validation for Charsequnce , Collection and Map data type.
		 * - By using above trick you can learn or use any validation annotation at runtime itself
		 * - I think , by using above trick you can also create your own validation annotation and its implementation(By checking how 
		 *   they do it , we can do same thing with some changes)

		 */		
	}
	

}
