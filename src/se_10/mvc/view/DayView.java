package se_10.mvc.view;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import se_10.mvc.model.CarPark;
import se_10.mvc.model.Cars;

public class DayView {

	private JScrollPane scroll;
	private JTable table;
	private static final String[] labels = {"Approach Time", "Departure Time", "Bill"};
	private Object[][] data = null;
	private CarPark park;
	
	public DayView(){
		park = CarPark.getInstance();
	}
	
	public JScrollPane createGUI() {
		DefaultTableModel model = new DefaultTableModel(data, labels);
		table = new JTable(model);
		table.setEnabled(false);
		scroll = new JScrollPane(table);
		table.setFillsViewportHeight(true);
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount() == 2) {
					Point point = e.getPoint();
					int row = table.rowAtPoint(point);
					if(row > -1) {
						Cars car = getCar(table.getValueAt(row, 0));
						if(car != null) {
							Object[] data = {car.getApproachTime().format(DateTimeFormatter.ofPattern("HH:mm:ss")), LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")), "" + car.getActualPrice(), "" + getPosition(table.getValueAt(row, 0))};
							VisitorView view = new VisitorView(data);
						}
					}
				}
			}
		});
		return scroll;
	}
	
	private Cars getCar(Object approach) {
		for(int i = 0; i < park.total(); ++i) {
			if(park.getParkingSpot(i) != null && park.getParkingSpot(i).getApproachTime().format(DateTimeFormatter.ofPattern("HH:mm:ss")).equals(approach)) {
				return park.getParkingSpot(i);
			}
		}
		return null;
	}
	
	private int getPosition(Object approach) {
		for(int i = 0; i < park.total(); ++i) {
			if(park.getParkingSpot(i) != null && park.getParkingSpot(i).getApproachTime().format(DateTimeFormatter.ofPattern("HH:mm:ss")).equals(approach)) {
				return i+1;
			}
		}
		return 0;
	}
	
	public void addData(Object[] data) {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.addRow(data);
	}
	
	public void refresh(String approach, String depart, double value) {
		for(int i = 0; i < table.getModel().getRowCount(); ++i) {
			if(table.getModel().getValueAt(i, 0).equals(approach)) {
				table.getModel().setValueAt(depart, i, 1);
				table.getModel().setValueAt(value, i, 2);
			}
		}
	}
	
}
