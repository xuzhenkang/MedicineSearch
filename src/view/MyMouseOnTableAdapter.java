package view;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTable;
import javax.swing.JTextArea;

public class MyMouseOnTableAdapter extends MouseAdapter {
	private JTable jTable;
	private JTextArea jTextArea;

	public MyMouseOnTableAdapter(JTable jTable, JTextArea jTextArea) {
		this.jTable = jTable;
		this.jTextArea = jTextArea;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		int selectedRow = jTable.getSelectedRow();
		String message = jTable.getName() + " pressed " + selectedRow + " row selected!";
		System.out.println(message);
		jTextArea.setText(message + "÷–Œƒ≤‚ ‘");
	}
}