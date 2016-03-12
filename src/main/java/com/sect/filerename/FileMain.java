package com.sect.filerename;

public class FileMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FileMove fileMove = null;
		if(args!=null && args.length>=2){
			fileMove = new FileMove(args[0],args[1]);
		}else{
			String filePath = "E:\\eyd";
			String targetFilePath = "E:\\b";
			fileMove = new FileMove(filePath,targetFilePath);
		}
		fileMove.move();
		System.out.println(fileMove.number);
	}

}
