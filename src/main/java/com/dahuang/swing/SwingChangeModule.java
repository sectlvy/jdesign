package com.dahuang.swing;

//这段程序代码主要是为读者展示如何创建选择器，和使用选择器来以不同的方式选择表格中的单元格
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.dahuang.swing.file.FileDataManagerImpl;

public class SwingChangeModule implements ActionListener, ListSelectionListener {
	private String nowDataFileName = "即时数据.txt";
	private String detailDataFileName = "财报明细.txt";
	private String propertyFile = "C:\\config.properties";
	private double timeValue = 0.1;
	private FileDataManager fileDataManager = FileDataManagerImpl.getInstance();
	/**
	 * 获取文件名称
	 * @return
	 * @throws IOException 
	 */
	public String getFileName() throws IOException{
		Properties propertie = new Properties();
		File  file = new File(propertyFile);
		if(!file.exists()){
			file.createNewFile();
			FileOutputStream outputFile;
			try {
				outputFile = new FileOutputStream(file);
				propertie.setProperty("filepath", "C:\\Documents and Settings\\Administrator\\桌面\\DNF相关日志");
				propertie.setProperty("time", "5");
				propertie.store(outputFile, "Update 'filepath' value");
				outputFile.close();
			} catch (FileNotFoundException e1) {
			} catch (IOException e1) {
			}
		}
		InputStream in = new FileInputStream(file);
		propertie.load(in);
		in.close();
		return propertie.getProperty("filepath");
	}
	public SwingChangeModule() throws Exception {
		init();
		FileDataBean  dataBean = fileDataManager.getStrAllLineValue(getFileName()+File.separator+nowDataFileName);
		if(dataBean!=null){
			TableModel tm = new DefaultTableModel(dataBean.getTitleValues(), dataBean.getTitles());
			table.setModel(tm);
			table.repaint();
			table.updateUI();
			frame.repaint();
		}
	}
	
	public void reloadFileData()throws Exception {
		FileDataBean  dataBean = fileDataManager.getStrAllLineValue(getFileName()+File.separator+nowDataFileName);
		if(dataBean!=null){
			setTableModle(new DefaultTableModel(dataBean.getTitleValues(), dataBean.getTitles()));
		}
	}
	/**
	 * 处理按钮事件,
	 * 利用ListSelectionModel界面所定义的setSelectionMode
	 * ()方法来设置表格选取模式.
	 */
	private boolean isDoubleClick = false;
	public void actionPerformed(ActionEvent e) { 
		if (e.getActionCommand().equals("保存")){
			Properties propertie = new Properties();
			FileOutputStream outputFile;
			try {
				outputFile = new FileOutputStream(propertyFile);
				propertie.setProperty("filepath", fileTextField.getText());
				propertie.setProperty("time", timeFiled.getText());
				propertie.store(outputFile, "Update 'filepath' value");
				outputFile.close();
			} catch (FileNotFoundException e1) {
			} catch (IOException e1) {
			}
			timeValue = Double.valueOf(timeFiled.getText());
		}else if (e.getActionCommand().equals("明细")){
			FileDataBean dataBean;
			try {
				if(isDoubleClick){
					timeValue = 70;
					dataBean = fileDataManager.getFileDataBean(getFileName()+File.separator+detailDataFileName);
					setTableModle(new DefaultTableModel(dataBean.getTitleValues(),dataBean.getTitles()));
					isDoubleClick = false;
				}else{
					timeValue = Double.valueOf(timeFiled.getText());
					isDoubleClick = true;
					reloadFileData();
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}
	
	/**
	 * @return the timeValue
	 */
	public double getTimeValue() {
		return timeValue;
	}
	/*
	 * 当用户选取表格数据时会触发ListSelectionEvent , 我们实现ListSelectionListener界面来处理这一事件 .
	 * ListSelectionListener界面只定义一个方法 ,那就是valueChanged().
	 */
	public void valueChanged(ListSelectionEvent el) {
		String tempString = "";
		// JTable的getSelectedRows()与getSelectedColumns()方法会返回已选取表格cell的index
		// Array数据.
		int[] rows = table.getSelectedRows();
		int[] columns = table.getSelectedColumns();

		for (int i = 0; i < rows.length; i++) { // JTable的getValueAt()方法会返回某行的cell数据,返回值是Object数据类型,因此要自行转成String数据类型.
			for (int j = 0; j < columns.length; j++)
				tempString = tempString + " "
						+ (String) table.getValueAt(rows[i], columns[j]);
		}
		label.setText("你选取的数据是:" + tempString);
	}
	private JScrollPane jscrollPane;
	private JTable table = null;
	private ListSelectionModel selectionMode = null;
	private JLabel label = null;// 显示用户选取表格之用
	private JFrame frame = new JFrame();
	private JTextField  fileTextField;
	private JTextField  timeFiled;
	private void init() throws IOException {
		table = new JTable();
		table.setPreferredScrollableViewportSize(new Dimension(500, 200));
		table.setCellSelectionEnabled(true);// 使得表格的选取是以cell为单位,而不是以列为单位.若你没有写此行,则在选取表格数据时以整列为单位.
		selectionMode = table.getSelectionModel();// 取得table的ListSelectionModel.
		selectionMode.addListSelectionListener(this);
		jscrollPane = new JScrollPane(table);
		JPanel panel = new JPanel();
		
		JLabel labeltem = new JLabel("读取的文件是:");
		panel.add(labeltem);
		
		
		fileTextField  =  new JTextField();
		fileTextField.setText(this.getFileName());
		panel.add(fileTextField);
		
		JLabel labeltime = new JLabel("循环时间是（分钟）:");
		panel.add(labeltime);
		
		timeFiled = new JTextField();
		timeFiled.setText(String.valueOf(timeValue));
		panel.add(timeFiled);
		
		fileTextField.addActionListener(this);
		JButton saveButton = new JButton("保存");
		saveButton.addActionListener(this);
		panel.add(saveButton);
		
		JButton detailNum = new JButton("明细");
		detailNum.addActionListener(this);
		panel.add(detailNum);
		
		label = new JLabel("你选取的数据是:");
		Container contentPane = frame.getContentPane();
		contentPane.add(panel, BorderLayout.NORTH);
		contentPane.add(jscrollPane, BorderLayout.CENTER);
		contentPane.add(label, BorderLayout.SOUTH);
		frame.setTitle("DNF日志");
		frame.pack();
		frame.setVisible(true);
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	public void setTableModle(TableModel tableModel) {
		table.setModel(tableModel);
		table.repaint();
		table.updateUI();
		frame.repaint();
	}
}