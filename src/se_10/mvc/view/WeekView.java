package se_10.mvc.view;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class WeekView {

	private JScrollPane scroll;
	private JTable table;
	private static final String[] labels = {"Day", "Revenues"};
	private Object[][] data = null;
	
	public JScrollPane createGUIWithReturn() {
		DefaultTableModel model = new DefaultTableModel(data, labels);
		table = new JTable(model);
		table.setEnabled(false);
		scroll = new JScrollPane(table);
		table.setFillsViewportHeight(true);
		return scroll;
	}

	private void addData(Object[] data) {
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		model.addRow(data);
	}
}
