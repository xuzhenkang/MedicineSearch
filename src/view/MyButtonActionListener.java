package view;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;

public class MyButtonActionListener implements ActionListener {
	private JTable jTable;
	private JTextArea jTextArea;
	private Matcher matcher;
	private Component parentComponent;
	public MyButtonActionListener(JTable jTable) {
		this.jTable = jTable;
	}
	public MyButtonActionListener(Component parentComponent, JTextArea jTextArea, JTable jTable, Matcher matcher) {
		this.parentComponent = parentComponent;
		this.jTextArea = jTextArea;
		this.jTable = jTable;
		this.matcher = matcher;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (matcher.find()) {
			int start = matcher.start();
			int end = matcher.end();
			System.out.println(start + "," + end);
			jTextArea.select(start, end);
			jTextArea.requestFocus();
		} else {
			// 判断是否有下一个，如果没有打印给出下面的提示框
			JOptionPane.showMessageDialog(this.parentComponent, "没有找到下一个", "提示", JOptionPane.CLOSED_OPTION);
		}
	}
}
