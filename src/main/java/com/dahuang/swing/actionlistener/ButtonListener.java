package com.dahuang.swing.actionlistener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ListSelectionModel;

public class ButtonListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("保存")){
			e.getSource();
//			fileName = fileTextField.getText();
//			timeValue = Double.valueOf(timeFiled.getText());
//			selectionMode.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//			selectionMode.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		}else if (e.getActionCommand().equals("连续区间选择")){
			
		}
//			selectionMode
//					.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		if (e.getActionCommand().equals("多重选择"));
//			selectionMode
//					.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
//		table.revalidate();
	}
	
}
