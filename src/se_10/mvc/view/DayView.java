package se_10.mvc.view;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

import se_10.mvc.model.CarPark;
import se_10.mvc.model.Cars;

public class DayView {

	private JScrollPane scroll;
	private JTable table;
	private static final String[] labels = {"Approach Time", "Departure Time", "Bill"};
	private Object[][] data = null;
	private CarPark park;
	private static final String _PATTERN = "HH:mm:ss";
	
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
						car.setActualPrice(park.getPricePerHour());
						if(car != null) {
							VisitorView view;
							if(!car.getDepartured()) {
								Object[] data = {car.getApproachTime().format(DateTimeFormatter.ofPattern(_PATTERN)), LocalDateTime.now().format(DateTimeFormatter.ofPattern(_PATTERN)), "" + car.getActualPrice(), "" + car.getPosition()};
								view = new VisitorView(data);
								Timer timer = new Timer(1000, new ActionListener() {
									
									@Override
									public void actionPerformed(ActionEvent arg0) {
										car.setActualPrice(park.getPricePerHour());
										Object[] data = {LocalDateTime.now().format(DateTimeFormatter.ofPattern(_PATTERN)), "" + car.getActualPrice()};
										view.update(data);
									}
								});
								timer.start();
							}else {
								Object[] data = {car.getApproachTime().format(DateTimeFormatter.ofPattern(_PATTERN)), car.getDepartureTime().format(DateTimeFormatter.ofPattern(_PATTERN)), "" + car.getActualPrice(), "" + car.getPosition()};
								view = new VisitorView(data);
							}
							
						}
					}
				}
			}
		});
		return scroll;
	}
	
	private Cars getCar(Object approach) {
		return park.getParkingSpot(approach.toString());
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
