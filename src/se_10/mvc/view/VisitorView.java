package se_10.mvc.view;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VisitorView {

	private JFrame frame;
	private JLabel approachTime;
	private JLabel approachTimeText;
	private JLabel currentTime;
	private JLabel currentTimeText;
	private JLabel currentPrice;
	private JLabel currentPriceText;
	private JLabel parkingSlotNumber;
	private JLabel parkingSlotNumberText;
	private JPanel panel;
	
	
	public VisitorView(Object[] data) {
		createGUI(data);
	}
	
	private void createGUI(Object[] data) {
		frame = new JFrame("Visitor View");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		panel = new JPanel(new GridLayout(4, 2));
		frame.setPreferredSize(new Dimension(300, 200));
		
		approachTime = new JLabel();
		approachTimeText = new JLabel("Approach Time: ");
		currentTime = new JLabel();
		currentTimeText = new JLabel("Current Time: ");
		currentPrice = new JLabel();
		currentPriceText = new JLabel("Current Price: ");
		parkingSlotNumber = new JLabel();
		parkingSlotNumberText = new JLabel("Parking Slot Nr.: ");
		
		panel.add(approachTimeText);
		approachTime.setText((String) data[0]);
		panel.add(approachTime);
		panel.add(currentTimeText);
		currentTime.setText((String) data[1]);
		panel.add(currentTime);
		panel.add(currentPriceText);
		currentPrice.setText((String) data[2] + " €");
		panel.add(currentPrice);
		panel.add(parkingSlotNumberText);
		parkingSlotNumber.setText((String) data[3]);
		panel.add(parkingSlotNumber);
		frame.setResizable(false);
		
		frame.getContentPane().add(panel);
		frame.pack();
		frame.setVisible(true);
	}
	
	public void update(Object[] data) {
		currentTime.setText((String) data[0]);
		currentPrice.setText((String) data[1] + " €");
	}
	
}
