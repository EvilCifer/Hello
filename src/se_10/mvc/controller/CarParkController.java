package se_10.mvc.controller;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import se_10.mvc.model.CarPark;
import se_10.mvc.model.Cars;
import se_10.mvc.view.DayView;
import se_10.mvc.view.VisitorView;
import se_10.mvc.view.WeekView;

public class CarParkController implements ActionListener{

	private static CarParkController instance = null;
	private DayView dayView = new DayView();
	private WeekView weekView = new WeekView();
	private VisitorView visitorView;
	private CarPark park = new CarPark();
	private JFrame frame;
	private JButton enter, leave;
	private JPanel buttonPanel, dayPanel, weekPanel, controlPanel;
	
	// Controls the views and the model (and the flow?)
	
	// Controller should save the visitors, in a  list or array.
	
	public CarParkController() {
		
	}
	
	// Singleton Pattern because we want only one Instance of the CarPark per CarPark
	private CarParkController getInstance() {
		if(instance == null) {
			instance = new CarParkController();
		}
		return instance;
	}
	
	private void createGUI() {
		frame = new JFrame("Car Park");
		enter = new JButton("Enter");
		leave = new JButton("Leave");
		controlPanel = new JPanel(new GridLayout(2, 1));
		buttonPanel = new JPanel(new FlowLayout());
		
		JFrame.setDefaultLookAndFeelDecorated(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout());
		enter.addActionListener(this);
		leave.addActionListener(this);
		controlPanel.add(dayView.createGUI());
		controlPanel.add(weekView.createGUIWithReturn());
		buttonPanel.add(enter);
		buttonPanel.add(leave);
		frame.getContentPane().add(controlPanel);
		frame.getContentPane().add(buttonPanel);
		
		frame.pack();
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource() == enter) {
			int i = (int) (Math.random() * park.size());
			while(true) {
				if(isFull()) break;
				if(!parkingSpotOccupied(i)) {
					park.setParkingInParkingSpot(i, new Cars());
					dayView.addData(new Object[] {park.getParkingSpot(i).getApproachTime().format(DateTimeFormatter.ofPattern("HH:mm")), "", ""});
					break;
				}
				i = (int) (Math.random() * park.size());
			}
		}
		if(arg0.getSource() == leave) {
			int i = (int) (Math.random() * park.size());
			while(true) {
				if(isEmpty()) break;
				if(parkingSpotOccupied(i)) {
					Cars car = park.getParkingSpot(i);
					car.setActualTime(LocalDateTime.now());
					car.setActualPrice(park.getPricePerHour());
					dayView.refresh(car.getApproachTime().format(DateTimeFormatter.ofPattern("HH:mm")), car.getActualTime().format(DateTimeFormatter.ofPattern("HH:mm")), car.getActualPrice());
//					Object[] o = new Object[] {car.getActualTime().format(DateTimeFormatter.ofPattern("HH:mm")), car.getActualPrice()};
					weekView.addData(new Object[] {car.getActualTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")), car.getActualPrice()});
					park.setParkingInParkingSpot(i, null);
					break;
				}
				i = (int) (Math.random() * park.size());
			}
		}
	}
	
	private boolean parkingSpotOccupied(int i) {
		return park.getParkingSpot(i) != null;
	}
	
	private boolean isFull() {
		for(int i = 0; i < park.size(); ++i) {
			if(park.getParkingSpot(i) == null) return false;
		}
		System.err.println("The Car Park is full!!!");
		return true;
	}
	
	private boolean isEmpty() {
		for(int i = 0; i < park.size(); ++i) {
			if(park.getParkingSpot(i) != null) return false;
		}
		System.err.println("There are no Visitors, which can leave.");
		return true;
	}
	
	public static void main(String[] args) {
		CarParkController controller = new CarParkController();
		controller.createGUI();
	}
}
