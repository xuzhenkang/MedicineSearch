package view.listener;

import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controller.TextFileReader;
import view.MainFrame;

public class MyMainListSelectionListener implements ListSelectionListener {

	private JTable jMainTable;
	private MainFrame mainFrame;

	public MyMainListSelectionListener(JTable jMainTable, MainFrame mainFrame) {
		this.jMainTable = jMainTable;
		this.mainFrame = mainFrame;
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (!e.getValueIsAdjusting()) { // 若e.getValueIsAdjusting()值为true，则说明鼠标按下操作。若不加此判断，则鼠标按下和抬起都会执行
			int index = jMainTable.getSelectedRow() > -1 ? jMainTable.getSelectedRow() : 0;
			String context = "";
			if (jMainTable.getRowCount() > 0) {
				String bookName = (String) jMainTable.getValueAt(index, 0); // 获取书名
				context = TextFileReader.getInstance().getBook(bookName).getContext();
			}
			mainFrame.rightPanel.getjTextArea().setText(context);
			mainFrame.rightPanel.getjTextArea().setCaretPosition(0);
			mainFrame.setKeywordAndText(mainFrame.keyword, context);
		}
	}

}
