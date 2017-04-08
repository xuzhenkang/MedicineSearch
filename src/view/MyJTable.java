package view;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;

public class MyJTable extends JTable {
	private static final long serialVersionUID = 1L;
	public MyJTable(Object[][] leftData, Object[] leftColumnNames, String tableName) {
		super(leftData, leftColumnNames);
		this.setName(tableName);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);// 仅可以单选
		this.setRowSelectionInterval(0, 0);
		this.addMouseListener(new MyMouseOnTableAdapter(this));
	}
	@Override
	public boolean isCellEditable(int row, int column) {
		return false;
	}
}
