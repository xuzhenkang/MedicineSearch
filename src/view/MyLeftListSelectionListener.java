package view;

import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import model.MedicineBookList;

public class MyLeftListSelectionListener implements ListSelectionListener {
	private JTable jLeftTable;
	private MainFrame mainFrame;

	public MyLeftListSelectionListener(JTable jLeftTable, MainFrame mainFrame) {
		this.jLeftTable = jLeftTable;
		this.mainFrame = mainFrame;
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		String keyword = (String) jLeftTable.getValueAt(e.getLastIndex(), 0);// e.getLastIndex()返回改变后的Table的行索引
		// 这里看需求。若text的内容发生变化，应该写在这里
		String text = mainFrame.rightPane.getjTextArea().getText();
		mainFrame.setKeywordAndText(keyword, text);
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
