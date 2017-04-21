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
		if (!e.getValueIsAdjusting()) { // 若e.getValueIsAdjusting()值为true，则说明鼠标按下操作。若不加此判断，则鼠标按下和抬起都会执行
			String keyword = (String) jLeftTable.getValueAt(jLeftTable.getSelectedRow(), 0);
			String text = mainFrame.rightPane.getjTextArea().getText();
			mainFrame.setKeywordAndText(keyword, text);
			// 更新数据
			Object[][] medicineBookList = new MedicineBookList(mainFrame.keyword).toArray();
			// 列名
			String[] mainColumnNames = mainFrame.leftPane.getMainColumnNames();
			DefaultTableModel dtm = new DefaultTableModel();
			dtm.setDataVector(medicineBookList, mainColumnNames);
			mainFrame.leftPane.getMainTable().setModel(dtm);
			if (mainFrame.leftPane.getMainTable().getRowCount() > 0)
				mainFrame.leftPane.getMainTable().setRowSelectionInterval(0, 0);
		}
	}

}
