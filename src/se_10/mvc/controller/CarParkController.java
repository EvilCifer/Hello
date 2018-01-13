package se_10.mvc.controller;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import se_10.mvc.model.CarPark;
import se_10.mvc.model.Cars;
import se_10.mvc.view.DayView;
import se_10.mvc.view.WeekView;

public class CarParkController implements ActionListener {

	private static CarParkController instance = null;
	private DayView dayView = new DayView();
	private WeekView weekView = new WeekView();
	private CarPark park = new CarPark();
	private JFrame frame;
	private JButton enter, leave, dump;
	private JPanel buttonPanel, controlPanel;
	private static double sum = 0;
	
	// Controls the views and the model (and the flow?)
	
	// Controller should save the visitors, in a  list or array.
	
	// Singleton Pattern because we want only one Instance of the CarPark per CarPark
	
	public CarParkController() {
		createGUI();
		park.setPricePerHour(2);
	}
	
	public static CarParkController getInstance() {
		if(instance == null) {
			instance = new CarParkController();
		}
		return instance;
	}
	
	private void createGUI() {
		frame = new JFrame("Car Park");
		enter = new JButton("Enter");
		leave = new JButton("Leave");
		dump = new JButton("Dump");
		controlPanel = new JPanel(new GridLayout(2, 1));
		buttonPanel = new JPanel(new FlowLayout());
		
		JFrame.setDefaultLookAndFeelDecorated(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout());
		enter.addActionListener(this);
		leave.addActionListener(this);
		dump.addActionListener(this);
		controlPanel.add(dayView.createGUI());
		controlPanel.add(weekView.createGUIWithReturn());
		buttonPanel.add(enter);
		buttonPanel.add(leave);
		buttonPanel.add(dump);
		frame.getContentPane().add(controlPanel);
		frame.getContentPane().add(buttonPanel);
		frame.addWindowListener(new WindowAdapter() {
			// Use this Method to safe the data
			@Override
			public void windowClosing(WindowEvent e) {
				if(e.getID() == WindowEvent.WINDOW_CLOSING) {
					park.save();
				}
			}
		});
		
		frame.pack();
		frame.setVisible(true);
	}

	
	// Use Timer to prevent double tap on enter???
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource() == enter) {
			int i = (int) (Math.random() * park.total());
			while(true) {
				if(isFull()) break;
				if(!parkingSpotOccupied(i)) {
					park.setParkingInParkingSpot(i, new Cars());
					dayView.addData(new Object[] {park.getParkingSpot(i).getApproachTime().format(DateTimeFormatter.ofPattern("HH:mm:ss")), "", ""});
					break;
				}
				i = (int) (Math.random() * park.total());
			}
			enter.setEnabled(false);
			Timer timer = new Timer(2000, new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					enter.setEnabled(true);
				}
			});
			timer.start();
		}
		if(arg0.getSource() == leave) {
			int i = (int) (Math.random() * park.total());
			while(true) {
				if(isEmpty()) break;
				if(parkingSpotOccupied(i)) {
					Cars car = park.getParkingSpot(i);
					car.setDepartureTime(LocalDateTime.now());
					car.setActualPrice(park.getPricePerHour());
					dayView.refresh(car.getApproachTime().format(DateTimeFormatter.ofPattern("HH:mm:ss")), car.getDepartureTime().format(DateTimeFormatter.ofPattern("HH:mm:ss")), car.getActualPrice());
					weekView.addData(new Object[] {car.getDepartureTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")), sum()});
					car.setDepartured(true);
					park.setParkingInParkingSpot(i, null);
					break;
				}
				i = (int) (Math.random() * park.total());
			}
		}
		if(arg0.getSource() == dump) {
			park.dump();
		}
	}
	
	private double sum() {
		for(int i = 0; i < park.total(); ++i) {
			sum += (park.getParkingSpot(i) != null) ? park.getParkingSpot(i).getActualPrice() : 0;
		}
		return sum;
	}
	
	private boolean parkingSpotOccupied(int i) {
		return park.getParkingSpot(i) != null;
	}
	
	private boolean isFull() {
		if(park.size() >= park.total()) System.err.println("The Car Park is full!!!");
		return park.size() >= park.total();
	}
	
	private boolean isEmpty() {
		if(park.size() == 0) System.err.println("The Car Park is empty!");
		return park.size() == 0;
	}
	
	public static void main(String[] args) {
		CarParkController controller = CarParkController.getInstance();
	}
}
