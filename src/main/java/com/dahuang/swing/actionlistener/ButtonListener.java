package com.dahuang.swing.actionlistener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ListSelectionModel;

public class ButtonListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("����")){
			e.getSource();
//			fileName = fileTextField.getText();
//			timeValue = Double.valueOf(timeFiled.getText());
//			selectionMode.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//			selectionMode.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		}else if (e.getActionCommand().equals("��������ѡ��")){
			
		}
//			selectionMode
//					.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		if (e.getActionCommand().equals("����ѡ��"));
//			selectionMode
//					.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
//		table.revalidate();
	}
	
}
