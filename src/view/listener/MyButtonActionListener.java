package view.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;

import javax.swing.JOptionPane;

import view.MainFrame;

public class MyButtonActionListener implements ActionListener {
	private MainFrame mainFrame;

	public MyButtonActionListener(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Matcher matcher = mainFrame.getMatcher();
		if (matcher.find()) {
			int start = matcher.start();
			int end = matcher.end();
			//System.out.println(start + "," + end);
			mainFrame.rightPanel.getjTextArea().select(start, end);
			mainFrame.rightPanel.getjTextArea().requestFocus();
		} else {
			// 判断是否有下一个，如果没有打印给出下面的提示框
			JOptionPane.showMessageDialog(this.mainFrame, "没有找到下一个", "提示", JOptionPane.CLOSED_OPTION);
		}
	}
}
