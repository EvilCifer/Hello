package se_10.mvc.controller;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import se_10.mvc.model.CarPark;
import se_10.mvc.model.Cars;
import se_10.mvc.view.DayView;
import se_10.mvc.view.TrafficLightView;
import se_10.mvc.view.WeekView;

public class CarParkController extends JFrame implements ActionListener {

	private static CarParkController instance = null;
	private static final String PATTERN = "HH:mm:ss";
	private DayView dayView = new DayView();
	private WeekView weekView = new WeekView();
	private CarPark park = new CarPark();
	private TrafficLightView light = new TrafficLightView();
	private JButton enter, leave;
	private JPanel buttonPanel, controlPanel;
	private JPanel lightPanel = new JPanel();
	private static double sum = 0;
	
	// Singleton Pattern because we want only one Instance of the CarPark per CarPark
	
	public CarParkController() {
		super("Car Park");
		setUpListener();
		park.setPricePerHour(2);
		enter = new JButton("Enter");
		leave = new JButton("Leave");
		controlPanel = new JPanel(new GridLayout(2, 1));
		buttonPanel = new JPanel(new FlowLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new GridLayout());
		controlPanel.add(dayView.createGUI());
		controlPanel.add(weekView.createGUI());
		buttonPanel.add(enter);
		buttonPanel.add(leave);
		lightPanel.setPreferredSize(new Dimension(controlPanel.getWidth(), controlPanel.getHeight()));
		enter.addActionListener(this);
		leave.addActionListener(this);
		getContentPane().add(controlPanel);
		getContentPane().add(buttonPanel);
		pack();
		setVisible(true);
	}
	
	public static CarParkController getInstance() {
		if(instance == null) {
			instance = new CarParkController();
		}
		return instance;
	}
	
	private void setUpListener() {
		addWindowListener(new WindowAdapter() {
			// Use this Method to safe the data
			@Override
			public void windowClosing(WindowEvent e) {
				if(e.getID() == WindowEvent.WINDOW_CLOSING) {
					park.save();
				}
			}
			
			@Override
			public void windowOpened(WindowEvent e) {
				if(e.getID() == WindowEvent.WINDOW_OPENED) {
					park.load();
					Collection<Cars> c = park.getAll();
					for(Cars car : c) {
						String departureTime = (car.getDepartureTime() != null) ? car.getDepartureTime().format(DateTimeFormatter.ofPattern(PATTERN)) : "";
						dayView.addData(new Object[] {car.getApproachTime().format(DateTimeFormatter.ofPattern(PATTERN)), departureTime, car.getActualPrice()});
						if(!car.getDepartured()) {
							park.setParkingInParkingSpot(car.getPosition(), car);
						}
						sum += car.getActualPrice();
						weekView.addData(new Object[] {car.getDepartureTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")), sum});
					}
				}
			}
		});
	}
	
//	public void paint(Graphics g) {
//		int x1 = (int)(getWidth() * 2.0/3.0) - 52;
//		int y1 = (int)(getHeight() * 2.0/3.0) - 52 - 100;
//		light.draw(g, Color.BLACK, x1, y1, 104, 104);
//	}
	
	// Use Timer to prevent double tap on enter???
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource() == enter) {
			int i = (int) (Math.random() * park.total());
			while(true) {
				if(isFull()) {
					
					break;
				}
				if(!parkingSpotOccupied(i)) {
					park.setParkingInParkingSpot(i, new Cars());
					dayView.addData(new Object[] {park.getParkingSpot(i).getApproachTime().format(DateTimeFormatter.ofPattern(PATTERN)), "", ""});
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
					dayView.refresh(car.getApproachTime().format(DateTimeFormatter.ofPattern("HH:mm:ss")), car.getDepartureTime().format(DateTimeFormatter.ofPattern(PATTERN)), car.getActualPrice());
					weekView.addData(new Object[] {car.getDepartureTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")), sum()});
					car.setDepartured(true);
					park.setParkingInParkingSpot(i, null);
					break;
				}
				i = (int) (Math.random() * park.total());
			}
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
		if(park.size() >= park.total()) {
			System.err.println("The Car Park is full!!!");
		}
		return park.size() >= park.total();
	}
	
	private boolean isEmpty() {
		if(park.size() == 0) System.err.println("The Car Park is empty!");
		return park.size() == 0;
	}
}
