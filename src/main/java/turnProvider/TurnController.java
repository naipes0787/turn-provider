package turnProvider;

import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TurnController {
	private final AtomicLong counter = new AtomicLong();
	
	/**
	 * Returns a JSON with an id and a Random number between 1 and 500 
	 * to simulate the next turn to be called.
	 * @param name -> Doesn't have any logic yet
	 * @return
	 */
	@RequestMapping(value="/getcurrent")
	public Turn greeting(@RequestParam(value="name", defaultValue="World") String name) {
		Random random = new Random();
		Integer turn = random.nextInt(500);
		return new Turn(counter.incrementAndGet(), turn.toString());
	}
}