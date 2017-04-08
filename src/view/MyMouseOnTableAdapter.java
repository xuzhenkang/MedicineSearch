package view;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTable;

public class MyMouseOnTableAdapter extends MouseAdapter {
	private JTable jTable;

	public MyMouseOnTableAdapter(JTable jTable) {
		this.jTable = jTable;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		int selectedRow = jTable.getSelectedRow();
		String message = jTable.getName() + " pressed " + selectedRow + " row selected!";
		System.out.println(message);
		//jTextArea.setText(message + "÷–Œƒ≤‚ ‘" + "");
		
		if (jTable.getName().equals("LeftTable")) {
		} else if (jTable.getName().equals("MainTable")) {
			
		}
	}
}