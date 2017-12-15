package se_10.mvc.view;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class DayView {

	private JFrame frame;
	private JTable table;
	
	public DayView() {
		createGUI();
	}
	
	public void  createGUI() {
		JFrame.setDefaultLookAndFeelDecorated(false);
		frame = new JFrame("DayView");
		frame.setPreferredSize(new Dimension(640, 320));
		frame.getContentPane().setLayout(new GridLayout(0, 1));
		table = new JTable(2, 2);
		frame.getContentPane().add(table);
		TableColumnModel model = table.getColumnModel();
		TableColumn column = model.getColumn(0);
		// JTable im internet anschauen
		
		frame.pack();
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		DayView view = new DayView();
	}
}
