package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;

public class MainFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private JTable leftTable; // 左侧表格
	private JTable mainTable; // 中间的表格
	private JPanel leftPanel; // 左侧面板
	private JPanel lleftPanel; // 左侧面板中的左侧面板
	private JPanel lMainPanel; // 左侧面板中的右侧面板
	private JPanel rightPanel; // 右侧面板
	private JPanel rightNorthPanel; // 右侧面板中的北侧面板
	private JPanel leftLabelPanel; // 左侧面板中的左侧面板中的标签面板
	private JPanel mainLabelPanel; // 左侧面板中的右侧面板中的标签面板
	private JScrollPane lLeftScrollPane; // 左侧面板中的左侧面板中的Scroll面板
	private JScrollPane lMainScrollPane; // 左侧面板中的右侧面板中的Scroll面板
	private JScrollPane rightScrollPane; // 右侧面板中的Scroll面板
	private JLabel leftLabel; // 左侧面板中的左侧面板的北侧标签面板中的标签组件
	private JLabel mainLabel; // 左侧面板中的右侧面板的北侧标签面板中的标签组件
	private JLabel rightLabel; // 右侧面板中的北侧面板中的标签组件
	private JButton searchNextButton; // 右侧面板中的北侧面板中的按钮组件
	private JTextArea jTextArea; // 右侧面板中的中间Scroll面板中的TextArea组件
	private Object[][] leftData; // 左侧面板中的左侧面板中表格的数据
	private Object[][] mainData; // 左侧面板中的右侧面板中表格的数据
	// 表头
	private String[] leftColumnNames = { "关键字", "文献数" }; // 左侧面板中的左侧面板中表格的表头
	private String[] mainColumnNames = { "中医文献名", "作者", "朝代", "年份" }; // 左侧面板中的右侧面板中表格的表头

	public MainFrame() {
		// 初始化组件
		this.initComponents();
		// 加载数据
		this.loadData();
		// 左侧Panel
		this.initLeftPanel();
		// 右侧Panel
		this.initRightPanel();
		// 设定JFrame属性
		this.setFrame();
	}

	// 右侧Panel
	private void initRightPanel() {
		rightNorthPanel.add(new JLabel(""));
		rightNorthPanel.add(rightLabel);
		rightNorthPanel.add(searchNextButton);
		searchNextButton.addActionListener(new MyButtonActionListener());
		rightPanel.add(rightNorthPanel, BorderLayout.NORTH);
		jTextArea.setEditable(false); // 设置不可编辑
		jTextArea.setText("Read Only o asdf ");
		rightScrollPane = new JScrollPane(jTextArea);
		rightPanel.add(rightScrollPane, BorderLayout.CENTER);
	}

	// 左侧Panel
	private void initLeftPanel() {
		// 左侧Panel
		leftLabelPanel.add(leftLabel);
		lleftPanel.add(leftLabelPanel, BorderLayout.NORTH);
		leftTable = new JTable(leftData, leftColumnNames) {
			private static final long serialVersionUID = 1L;
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		leftTable.setName("LeftTable");
		leftTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);// 仅可以单选
		leftTable.setRowSelectionInterval(0, 0);
		leftTable.addMouseListener(new MyMouseOnTableAdapter(leftTable));
		lLeftScrollPane = new JScrollPane(leftTable, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		lleftPanel.add(lLeftScrollPane, BorderLayout.CENTER);
		lleftPanel.setPreferredSize(new Dimension(130, 500));

		// 中间Panel
		mainLabelPanel.add(mainLabel);
		lMainPanel.add(mainLabelPanel, BorderLayout.NORTH);
		mainTable = new JTable(mainData, mainColumnNames) {
			private static final long serialVersionUID = 1L;
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		mainTable.setName("MainTable");
		mainTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // 仅可以单选
		mainTable.setRowSelectionInterval(0, 0);
		mainTable.addMouseListener(new MyMouseOnTableAdapter(mainTable));
		lMainScrollPane = new JScrollPane(mainTable);
		lMainPanel.add(lMainScrollPane, BorderLayout.CENTER);
		lMainPanel.setPreferredSize(new Dimension(267, 500));

		// 设定布局
		leftPanel.add(lleftPanel, BorderLayout.WEST);
		leftPanel.add(lMainPanel, BorderLayout.EAST);
	}

	// 初始化组件
	private void initComponents() {
		leftPanel = new JPanel(new BorderLayout());
		lMainPanel = new JPanel(new BorderLayout());
		lleftPanel = new JPanel(new BorderLayout());
		rightPanel = new JPanel(new BorderLayout());
		rightNorthPanel = new JPanel(new GridLayout(1, 3));
		jTextArea = new JTextArea();
		leftLabel = new JLabel("相关关键词");
		mainLabel = new JLabel("中医文献");
		rightLabel = new JLabel("文献文本");
		searchNextButton = new JButton("搜索/下一个");
		leftLabelPanel = new JPanel();
		mainLabelPanel = new JPanel();
	}

	// 加载数据 要写到模型层或控制层
	private void loadData() {
		// 创建显示数据
		leftData = new Object[50][2];
		for (int i = 0; i < leftData.length; i++) {
			leftData[i][0] = "John";
			leftData[i][1] = "Sue";
		}
		mainData = new Object[50][4];
		for (int i = 0; i < mainData.length; i++) {
			mainData[i][0] = "本草纲目本草纲目本草纲目本草纲目本草纲目本草纲目";
			mainData[i][1] = "李时珍";
			mainData[i][2] = "明";
			mainData[i][3] = "1518年";
		}
	}

	// 设定Frame面板
	private void setFrame() {
		// 设定JFrame的总体布局
		this.setLayout(new GridLayout(1, 2));
		// 向JFrame面板中添加面板组件
		this.add(leftPanel);
		this.add(rightPanel);
		this.setTitle("基础检测子系统");
		this.setSize(800, 600);
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
	}

	class MyMouseOnTableAdapter extends MouseAdapter {
		private JTable jTable;

		public MyMouseOnTableAdapter(JTable jTable) {
			this.jTable = jTable;
		}

		@Override
		public void mousePressed(MouseEvent e) {
			int selectedRow = jTable.getSelectedRow();
			String message = jTable.getName() + " pressed " + selectedRow + " row selected!";
			System.out.println(message);
			jTextArea.setText(message + "中文测试");
		}
	}

	class MyButtonActionListener implements ActionListener {
		private JTable jTable;
		public MyButtonActionListener(JTable jTable) {
			this.jTable = jTable;
		}
		public MyButtonActionListener(){}
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
}
