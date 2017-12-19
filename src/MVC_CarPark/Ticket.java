package MVC_CarPark;

import java.time.LocalDateTime;

public class Ticket {

	LocalDateTime from;
	LocalDateTime to;
	double actualPrice;

	public Ticket(LocalDateTime from) {
		this.from = from;
		this.to = LocalDateTime.now();
	}
}
