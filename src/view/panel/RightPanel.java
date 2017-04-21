package view.panel;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import controller.TextFileReader;
import view.MainFrame;
import view.component.MyJTable;
import view.listener.MyButtonActionListener;

public class RightPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private JPanel rightNorthPanel; // 右侧面板中的北侧面板
	private JScrollPane rightScrollPane; // 右侧面板中的Scroll面板
	private JLabel rightLabel; // 右侧面板中的北侧面板中的标签组件
	private JButton searchNextButton; // 右侧面板中的北侧面板中的按钮组件
	private JTextArea jTextArea; // 右侧面板中的中间Scroll面板中的TextArea组件

	public RightPanel(MainFrame mainFrame) {
		this.setLayout(new BorderLayout());
		rightNorthPanel = new JPanel(new GridLayout(1, 3));
		jTextArea = new JTextArea();
		rightLabel = new JLabel("文献文本");
		searchNextButton = new JButton("搜索/下一个");
		rightNorthPanel.add(new JLabel(""));
		rightNorthPanel.add(rightLabel);
		rightNorthPanel.add(searchNextButton);
		this.add(rightNorthPanel, BorderLayout.NORTH);
		jTextArea.setEditable(false); // 设置不可编辑
		MyJTable mainTable = mainFrame.leftPane.getMainTable();
		String bookName = (String) mainTable.getValueAt(mainTable.getSelectedRow(), 0); // 获取书名
		String context = TextFileReader.getInstance().getBook(bookName).getContext();
		jTextArea.setText(context);
		jTextArea.setCaretPosition(0);
		mainFrame.setKeywordAndText(mainFrame.keyword, context);
		rightScrollPane = new JScrollPane(jTextArea);
		this.add(rightScrollPane, BorderLayout.CENTER);
		// 初始化text
		// 初始化pattern和matcher
		mainFrame.setText(jTextArea.getText());
		// 该句一定要放在matcher = pattern.matcher(text);之后，否则空指针异常
		searchNextButton.addActionListener(
				new MyButtonActionListener(mainFrame));
	}

	public JTextArea getjTextArea() {
		return jTextArea;
	}
}
