package view;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTable;

@SuppressWarnings("unused")
public class MyMouseOnTableAdapter extends MouseAdapter {
	private JTable jTable;

	public MyMouseOnTableAdapter(JTable jTable) {
		this.jTable = jTable;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		//int selectedRow = jTable.getSelectedRow();

//		if (jTable.getName().equals("LeftTable")) {
//			
//		} else if (jTable.getName().equals("MainTable")) {
//		}
	}
}