package view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import model.KeywordList;
import model.MedicineBookList;

public class LeftPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private MyJTable leftTable; // 左侧表格
	private MyJTable mainTable; // 中间的表格
	private JPanel lleftPanel; // 左侧面板中的左侧面板
	private JPanel lMainPanel; // 左侧面板中的右侧面板
	// 表头
	private String[] leftColumnNames = { "关键字", "文献数" }; // 左侧面板中的左侧面板中表格的表头
	private String[] mainColumnNames = { "中医文献名", "作者", "朝代", "年份" }; // 左侧面板中的右侧面板中表格的表头
	private JPanel leftLabelPanel; // 左侧面板中的左侧面板中的标签面板
	private JPanel mainLabelPanel; // 左侧面板中的右侧面板中的标签面板
	private JScrollPane lLeftScrollPane; // 左侧面板中的左侧面板中的Scroll面板
	private JScrollPane lMainScrollPane; // 左侧面板中的右侧面板中的Scroll面板
	private JLabel leftLabel; // 左侧面板中的左侧面板的北侧标签面板中的标签组件
	private JLabel mainLabel; // 左侧面板中的右侧面板的北侧标签面板中的标签组件
	
	private Object[][] leftData; // 左侧面板中的左侧面板中表格的数据
	private Object[][] mainData; // 左侧面板中的右侧面板中表格的数据
	
	public LeftPanel(MainFrame mainFrame) {
		this.setLayout(new BorderLayout());
		lMainPanel = new JPanel(new BorderLayout());
		lleftPanel = new JPanel(new BorderLayout());
		leftLabel = new JLabel("相关关键词");
		mainLabel = new JLabel("中医文献");
		leftLabelPanel = new JPanel();
		mainLabelPanel = new JPanel();
		// 加载左侧表格数据
		leftData = new KeywordList().toArray();
		
		// 左侧Panel
		leftLabelPanel.add(leftLabel);
		lleftPanel.add(leftLabelPanel, BorderLayout.NORTH);
		leftTable = new MyJTable(leftData, leftColumnNames, "LeftTable");
		// 初始化主面板的keyword
		mainFrame.keyword = (String) leftTable.getValueAt(leftTable.getSelectedRow(), 0);
		// 设定左侧Table行改变的时候的监听
		MyListSelectionListener mlsl = new MyListSelectionListener(leftTable, mainFrame);
		leftTable.getSelectionModel().addListSelectionListener(mlsl);
		lLeftScrollPane = new JScrollPane(leftTable, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		lleftPanel.add(lLeftScrollPane, BorderLayout.CENTER);
		lleftPanel.setPreferredSize(new Dimension(130, 500));

		// 中间Panel
		mainLabelPanel.add(mainLabel);
		lMainPanel.add(mainLabelPanel, BorderLayout.NORTH);
		// 加载中间表格的数据
		mainData = new MedicineBookList(mainFrame.keyword).toArray();
		mainTable = new MyJTable(mainData, mainColumnNames, "MainTable");
		
		lMainScrollPane = new JScrollPane(mainTable);
		lMainPanel.add(lMainScrollPane, BorderLayout.CENTER);
		lMainPanel.setPreferredSize(new Dimension(267, 500));

		// 设定布局
		this.add(lleftPanel, BorderLayout.WEST);
		this.add(lMainPanel, BorderLayout.EAST);
	}
	public JTable getLeftTable() {
		return leftTable;
	}
	public void setMainTable(MyJTable mainTable) {
		this.mainTable = mainTable;
	}
	public void setMainData(Object[][] mainData) {
		this.mainData = mainData;
	}
	public String[] getMainColumnNames() {
		return mainColumnNames;
	}
	public JPanel getlMainPanel() {
		return lMainPanel;
	}
	public void setlMainScrollPane(JScrollPane lMainScrollPane) {
		this.lMainScrollPane = lMainScrollPane;
	}
	
	
}
