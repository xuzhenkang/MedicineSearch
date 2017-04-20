package view;

import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import model.MedicineBookList;

public class MyMainListSelectionListener implements ListSelectionListener {

	private JTable jMainTable;
	private MainFrame mainFrame;

	public MyMainListSelectionListener(JTable jMainTable, MainFrame mainFrame) {
		this.jMainTable = jMainTable;
		this.mainFrame = mainFrame;
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		String keyword = (String) jMainTable.getValueAt(e.getLastIndex(), 0);// e.getLastIndex()返回改变后的Table的行索引
		// 这里看需求。若text的内容发生变化，应该写在这里
		String text = mainFrame.rightPane.getjTextArea().getText();
		mainFrame.setKeywordAndText(keyword, text);
		//String bookName = (String) jMainTable.getValueAt(e.getLastIndex(), 4); // 获取书名
		
		// 更新数据
		Object[][] MedicineBookList = new MedicineBookList(mainFrame.keyword).toArray();
		// 列名
		String[] mainColumnNames = mainFrame.leftPane.getMainColumnNames();
		DefaultTableModel dtm = new DefaultTableModel();
		dtm.setDataVector(MedicineBookList, mainColumnNames);
//		mainFrame.leftPane.getMainTable().removeAll();
		mainFrame.leftPane.getMainTable().setModel(dtm);
//		mainFrame.leftPane.getMainTable().validate();
		mainFrame.leftPane.getMainTable().updateUI();
//		mainFrame.leftPane.getMainTable().repaint();
	}

}
