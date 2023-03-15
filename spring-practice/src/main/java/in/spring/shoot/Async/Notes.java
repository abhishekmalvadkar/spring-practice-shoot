package in.spring.shoot.Async;

public class Notes {
	
	/*
	 * Real use case of @Async annotation
	 * 
	 * - Suppose you are storing response in redis as cache
	 * - And for that you have AOP advice which is taking return value of controller
	 * - And preparing  data for redis cache and sending into redis
	 * - AOP advice calling process is sync(I need to check that AOP advice is async or sync) 
	 *   process? so your client need to wait for response untill AOP advice
	 *   exceution completes and hence we can mark that preparing and send redis data code as @Async so it will execute
	 *   in async way.
	 *   
	 *   I have checked about AOP and information is like
	 *   
	 *   Yes, aspect advices like @Before or @After for Spring AOP will be executed asynchronously.
	 *   but @Around is not executed asynchronously keep this thing in mind
	 *   
	 *   - FPG is using @Around to store response in redis and hence they have made that method as @Async
	 *   
	 */

}
