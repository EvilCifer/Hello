package MVC_CarPark;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.DateTimeException;

import javax.swing.Timer;

public class CarParkController {
	private CustomerView theView;
	private CarParkModel theModel;

	public CarParkController(CustomerView theView, CarParkModel theModel) {
		this.theView = theView;
		this.theModel = theModel;
		this.theView.addActualPriceListener(new PriceListener());
	}

	class PriceListener implements ActionListener {

		Timer timer = new Timer(1000, this);
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			int visitorID = 0;
			timer.start();
			try {
				visitorID = theView.getVisitorID();
				theView.getActualPriceLabel(theModel.getActualPrice(visitorID));
				theView.getArrivalTime(theModel.getArrivalTime(visitorID));
				theView.getDepartureTime(theModel.getDepartureTime(visitorID));
				theView.getDurationTime(theModel.getDurationTime(visitorID));
				if(arg0.getSource() == timer) {
					visitorID = theView.getVisitorID();
					theView.getActualPriceLabel(theModel.getActualPrice(visitorID));
					theView.getArrivalTime(theModel.getArrivalTime(visitorID));
					theView.getDepartureTime(theModel.getDepartureTime(visitorID));
					theView.getDurationTime(theModel.getDurationTime(visitorID));
				}
			} catch (NumberFormatException e) {
				theView.displayErrorMessage("This number is not assigned");
			} catch (NullPointerException e) {
				theView.displayErrorMessage("This number is not assigned");
			} catch (DateTimeException e) {
				theView.displayErrorMessage("At least one date is invalid");
			}
		}
	}
}
