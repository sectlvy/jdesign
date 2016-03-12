package com.sect.filerename;

public class FolderCombain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileMove fileMove = null;
		if(args!=null && args.length>=2){
			fileMove = new FileMove(args[0],args[1]);
		}else{
			String filePath = "J:\\media\\b";
			String targetFilePath = "J:\\media\\d";
			fileMove = new FileMove(filePath,targetFilePath);
		}
		fileMove.combain();
		System.out.println(fileMove.number);
	}

}
