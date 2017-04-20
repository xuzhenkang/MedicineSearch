package view;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.MedicineBookList;

public class MyListSelectionListener implements ListSelectionListener {
	private JTable jLeftTable;
	private MainFrame mainFrame;

	public MyListSelectionListener(JTable jLeftTable, MainFrame mainFrame) {
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
		
		mainFrame.leftPane.getLeftTable().removeAll();
		mainFrame.leftPane.getLeftTable();
		mainFrame.leftPane.getLeftTable().validate();
		mainFrame.leftPane.getLeftTable().updateUI();
		
//		// 生成新的JTable
//		MyJTable mainTable = new MyJTable(MedicineBookList, mainColumnNames, "MainTable");
//		mainFrame.leftPane.setMainTable(mainTable); // 更新leftpane中的MainTable值
//		
//		JScrollPane lMainScrollPane = new JScrollPane(mainTable);// 将新的JTable放到Pane中
//		mainFrame.leftPane.setlMainScrollPane(lMainScrollPane); // 更新leftPane中的lMainScrollPane
//		JPanel lMainPanel = mainFrame.leftPane.getlMainPanel(); // 获取leftPane中的lMainPanel
//		lMainPanel.add(lMainScrollPane, BorderLayout.CENTER); // 在lMainPanel中添加lMainScrollPane以显示
		
		System.out.println("okok");
	}

}
