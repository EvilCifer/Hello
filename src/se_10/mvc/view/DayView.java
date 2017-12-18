package se_10.mvc.view;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.time.LocalTime;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class DayView {

	private JFrame frame;
	private JScrollPane scroll;
	private JTable table;
	
	// Create seconds Constructor with Object[][] and String[] as parameter
	public DayView() {
		String[] columnNames = {"Day", "Daily's Takings"};
		Object[][] dummyData = {{LocalTime.of(12, 30), 12}, {LocalTime.of(14, 00), 30},
				{LocalTime.of(14, 13), 23}, {LocalTime.of(15, 37), 15}};
		new DayView(dummyData, columnNames);
	}
	
	public DayView(Object[][] data, String[] columnNames) {
		createGUI(data, columnNames);
	}
	
	public void  createGUI(Object[][] data, String[] columnNames) {
		JFrame.setDefaultLookAndFeelDecorated(false);
		frame = new JFrame("DayView");
		frame.setPreferredSize(new Dimension(640, 320));
		frame.getContentPane().setLayout(new GridLayout(0, 1));
		
		table = new JTable(data, columnNames);
		table.setEnabled(false); // set Cells to "not editable"
		scroll = new JScrollPane(table);
		table.setFillsViewportHeight(true);
		frame.getContentPane().add(scroll);
		
		frame.pack();
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		DayView view = new DayView();
	}
}
