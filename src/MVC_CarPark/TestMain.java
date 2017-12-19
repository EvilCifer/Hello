package MVC_CarPark;

import java.time.LocalDateTime;
import java.time.Month;

public class TestMain {
	public static void main(String[] args) {
		CustomerView theView = new CustomerView();
		CarParkModel theModel = new CarParkModel();

		CarParkController theController = new CarParkController(theView, theModel);
	
		theModel.setPricePerHour(5.00);
		theModel.setCustomer(0, LocalDateTime.of(2015,  Month.JANUARY, 1, 19 , 13, 40));
		theModel.setCustomer(1, LocalDateTime.of(2017,  Month.DECEMBER, 18, 21 , 00, 00));
		theModel.setCustomer(2, LocalDateTime.MIN);
		theView.setVisible(true);
	}
}
