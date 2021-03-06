package se_10.mvc.view;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class WeekView {

	private JScrollPane scroll;
	private JTable table;
	private static final String[] labels = {"Day", "Revenues"};
	private Object[][] data = null;
	
	public JScrollPane createGUI() {
		DefaultTableModel model = new DefaultTableModel(data, labels);
		table = new JTable(model);
		table.setEnabled(false);
		scroll = new JScrollPane(table);
		table.setFillsViewportHeight(true);
		return scroll;
	}

	public void addData(Object[] data) {
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		if(!contains((String)data[0])) {
			model.addRow(data);
		}else {
			for(int i = 0; i < model.getRowCount(); ++i) {
				if(model.getValueAt(i, 0).equals(data[0])) {
					model.setValueAt(data[1], i, 1);
				}
			}
		}
	}
	
	private boolean contains(String date) {
		for(int i = 0; i < table.getModel().getRowCount(); ++i) {
			if(table.getModel().getValueAt(i, 0).equals(date)) {
				return true;
			}
		}
		return false;
	}
}
