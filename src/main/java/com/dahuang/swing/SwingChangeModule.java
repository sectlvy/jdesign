package com.dahuang.swing;

//��γ��������Ҫ��Ϊ����չʾ��δ���ѡ��������ʹ��ѡ�������Բ�ͬ�ķ�ʽѡ�����еĵ�Ԫ��
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
	private String nowDataFileName = "��ʱ����.txt";
	private String detailDataFileName = "�Ʊ���ϸ.txt";
	private String propertyFile = "C:\\config.properties";
	private double timeValue = 0.1;
	private FileDataManager fileDataManager = FileDataManagerImpl.getInstance();
	/**
	 * ��ȡ�ļ�����
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
				propertie.setProperty("filepath", "C:\\Documents and Settings\\Administrator\\����\\DNF�����־");
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
	 * ����ť�¼�,
	 * ����ListSelectionModel�����������setSelectionMode
	 * ()���������ñ��ѡȡģʽ.
	 */
	private boolean isDoubleClick = false;
	public void actionPerformed(ActionEvent e) { 
		if (e.getActionCommand().equals("����")){
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
		}else if (e.getActionCommand().equals("��ϸ")){
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
	 * ���û�ѡȡ�������ʱ�ᴥ��ListSelectionEvent , ����ʵ��ListSelectionListener������������һ�¼� .
	 * ListSelectionListener����ֻ����һ������ ,�Ǿ���valueChanged().
	 */
	public void valueChanged(ListSelectionEvent el) {
		String tempString = "";
		// JTable��getSelectedRows()��getSelectedColumns()�����᷵����ѡȡ���cell��index
		// Array����.
		int[] rows = table.getSelectedRows();
		int[] columns = table.getSelectedColumns();

		for (int i = 0; i < rows.length; i++) { // JTable��getValueAt()�����᷵��ĳ�е�cell����,����ֵ��Object��������,���Ҫ����ת��String��������.
			for (int j = 0; j < columns.length; j++)
				tempString = tempString + " "
						+ (String) table.getValueAt(rows[i], columns[j]);
		}
		label.setText("��ѡȡ��������:" + tempString);
	}
	private JScrollPane jscrollPane;
	private JTable table = null;
	private ListSelectionModel selectionMode = null;
	private JLabel label = null;// ��ʾ�û�ѡȡ���֮��
	private JFrame frame = new JFrame();
	private JTextField  fileTextField;
	private JTextField  timeFiled;
	private void init() throws IOException {
		table = new JTable();
		table.setPreferredScrollableViewportSize(new Dimension(500, 200));
		table.setCellSelectionEnabled(true);// ʹ�ñ���ѡȡ����cellΪ��λ,����������Ϊ��λ.����û��д����,����ѡȡ�������ʱ������Ϊ��λ.
		selectionMode = table.getSelectionModel();// ȡ��table��ListSelectionModel.
		selectionMode.addListSelectionListener(this);
		jscrollPane = new JScrollPane(table);
		JPanel panel = new JPanel();
		
		JLabel labeltem = new JLabel("��ȡ���ļ���:");
		panel.add(labeltem);
		
		
		fileTextField  =  new JTextField();
		fileTextField.setText(this.getFileName());
		panel.add(fileTextField);
		
		JLabel labeltime = new JLabel("ѭ��ʱ���ǣ����ӣ�:");
		panel.add(labeltime);
		
		timeFiled = new JTextField();
		timeFiled.setText(String.valueOf(timeValue));
		panel.add(timeFiled);
		
		fileTextField.addActionListener(this);
		JButton saveButton = new JButton("����");
		saveButton.addActionListener(this);
		panel.add(saveButton);
		
		JButton detailNum = new JButton("��ϸ");
		detailNum.addActionListener(this);
		panel.add(detailNum);
		
		label = new JLabel("��ѡȡ��������:");
		Container contentPane = frame.getContentPane();
		contentPane.add(panel, BorderLayout.NORTH);
		contentPane.add(jscrollPane, BorderLayout.CENTER);
		contentPane.add(label, BorderLayout.SOUTH);
		frame.setTitle("DNF��־");
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