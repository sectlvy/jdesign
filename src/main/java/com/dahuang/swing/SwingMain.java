package com.dahuang.swing;


public class SwingMain {
	public static void main(String[] args) throws Exception{
		SwingChangeModule swingChangeModule = new SwingChangeModule();
		
		while(true){
			Thread.sleep((int)(swingChangeModule.getTimeValue()*1000*60));
			swingChangeModule.reloadFileData();
		}
	}
}
