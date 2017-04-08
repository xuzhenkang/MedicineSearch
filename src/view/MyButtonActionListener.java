package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTable;
import javax.swing.JTextArea;

public class MyButtonActionListener implements ActionListener {
	private JTable jTable;
	private JTextArea jTextArea;
	public MyButtonActionListener(JTable jTable) {
		this.jTable = jTable;
	}
	public MyButtonActionListener(JTextArea jTextArea) {
		this.jTextArea = jTextArea;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		/*没有用这句*/
		if (this.jTable != null)
			jTable.setRowSelectionInterval(0, jTable.getSelectedRow() + 1);
		
		jTextArea.select(0, 5);
		jTextArea.requestFocus();
		
		// 判断是否有下一个，如果没有打印给出下面的提示框
		//JOptionPane.showMessageDialog(MainFrame.this, "没有找到下一个", "提示", JOptionPane.CLOSED_OPTION);
	}
}
