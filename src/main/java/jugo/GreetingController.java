package jugo;

import java.util.concurrent.atomic.AtomicLong;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

	private final static String TEMPLATE = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@RequestMapping("/greeting")
	public Greeting greeting(
			@RequestParam( value="name", defaultValue="World") String name
	) {
		Greeting greetingResponse = new Greeting(counter.incrementAndGet(), String.format(TEMPLATE, name));
		return greetingResponse;
	}
	
}