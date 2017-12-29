package se_10.mvc.view;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class DayView{

	private JScrollPane scroll;
	private JTable table;
	private static final String[] labels = {"Approach Time", "Departure Time", "Bill"};
	private Object[][] data = null;
	
	public JScrollPane createGUI() {
		// Use DefaultTableModel because it updates automatically
		DefaultTableModel model = new DefaultTableModel(data, labels);
		table = new JTable(model);
		table.setEnabled(false);
		scroll = new JScrollPane(table);
		table.setFillsViewportHeight(true);
		return scroll;
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
