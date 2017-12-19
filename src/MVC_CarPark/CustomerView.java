package MVC_CarPark;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CustomerView extends JFrame {
	private static final long serialVersionUID = 1L;
	private JLabel visitor_ID_Label = new JLabel("Ticket ID:");
	private JLabel actual_Price_Text_Label = new JLabel("Actual Price: ");
	private JLabel actual_Price_Label = new JLabel("");
	private JLabel arrival_Time_Text_Label = new JLabel("Arrival Time: ");
	private JLabel arrival_Time_Label = new JLabel("");
	private JLabel departure_Time_Text_Label = new JLabel("Departure Time: ");
	private JLabel departure_Time_Label = new JLabel("");
	private JLabel duration_Time_Text_Label = new JLabel("Parking Duration: ");
	private JLabel duration_Time_Label = new JLabel("");
	
	private JButton actual_Price_Button = new JButton("Confirm");
	
	private JTextField visitor_ID = new JTextField(10);

	public CustomerView() {

		JPanel pricePanel = new JPanel();

		pricePanel.setLayout(null);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setSize(300, 200);
		this.setTitle("Customer View");

		pricePanel.add(visitor_ID_Label);
		pricePanel.add(actual_Price_Text_Label);
		pricePanel.add(arrival_Time_Text_Label);
		pricePanel.add(arrival_Time_Label);
		pricePanel.add(departure_Time_Text_Label);
		pricePanel.add(actual_Price_Label);
		pricePanel.add(departure_Time_Label);
		pricePanel.add(duration_Time_Text_Label);
		pricePanel.add(duration_Time_Label);
		
		
		pricePanel.add(visitor_ID);
		
		pricePanel.add(actual_Price_Button);
			
		visitor_ID_Label.setLocation(27,20);
		visitor_ID.setLocation(140, 20);
		arrival_Time_Text_Label.setLocation(27,40);
		arrival_Time_Label.setLocation(140,40);
		departure_Time_Text_Label.setLocation(27,60);
		departure_Time_Label.setLocation(140,60);
		duration_Time_Text_Label.setLocation(27,80);
		duration_Time_Label.setLocation(140,80);
		actual_Price_Text_Label.setLocation(27,100);
		actual_Price_Label.setLocation(140,100);
		actual_Price_Button.setLocation(90, 140);
		
		visitor_ID_Label.setSize(100,20);
		arrival_Time_Text_Label.setSize(100,20);
		arrival_Time_Label.setSize(200,20);
		departure_Time_Text_Label.setSize(100,20);
		departure_Time_Label.setSize(200,20);
		duration_Time_Text_Label.setSize(120,20);
		duration_Time_Label.setSize(200,20);
		actual_Price_Text_Label.setSize(100,20);
		actual_Price_Label.setSize(100,20);
		
		visitor_ID.setSize(100,20);
		
		actual_Price_Button.setSize(100,20);

		this.add(pricePanel);
	}

	public int getVisitorID() {
		return Integer.parseInt(visitor_ID.getText());
	}

	void addActualPriceListener(ActionListener e) {
		actual_Price_Button.addActionListener(e);
	}
	
	void displayErrorMessage(String errorMessage) {
		JOptionPane.showMessageDialog(this, errorMessage);
	}
	
	void getActualPriceLabel(double price) {
		actual_Price_Label.setText(String.format("%f", price));
	}
	
	void getArrivalTime(String text) {
		arrival_Time_Label.setText(text);
	}
	
	void getDepartureTime(String text) {
		departure_Time_Label.setText(text);
	}
	
	void getDurationTime(String text) {
		duration_Time_Label.setText(text);
	}
}
