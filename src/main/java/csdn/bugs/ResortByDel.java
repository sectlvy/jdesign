package csdn.bugs;

import java.util.*;
import java.io.*;

public class ResortByDel {

	@SuppressWarnings("unchecked")
	public void ResortToTemp(String firstFile, String secondFile,
			String tempPath1, String tempPath2) throws IOException {
		// String oldPath = oldFolderPath;
		File f1 = new File(firstFile);
		File f2 = new File(secondFile);
		String str1 = null;
		String str2 = null;
		String string1 = null;
		String string2 = null;
		Vector vector1 = new Vector();// //定义容器类对象
		Vector vector2 = new Vector();// //定义容器类对象
		// boolean IsRepeat = false;
		try {
			BufferedReader reader1 = new BufferedReader(new FileReader(f1));
			BufferedReader reader2 = new BufferedReader(new FileReader(f2));
			while ((str1 = reader1.readLine()) != null
					&& (str2 = reader2.readLine()) != null) {
				if(!vector1.contains(str1)){
					vector1.add(str1);
				}
				if(!vector2.contains(str2)){
					vector2.add(str2);
				}
			}
			reader1.close();
			reader2.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 写入文件
		String newFile1 = tempPath1;
		String newFile2 = tempPath2;
		File tempFile1 = new File(newFile1);
		File tempFile2 = new File(newFile2);
		if (tempFile1.exists()) {
			tempFile1.delete();
		}
		if (tempFile2.exists()) {
			tempFile2.delete();
		}
		tempFile1.createNewFile();
		tempFile2.createNewFile();
		try {
			BufferedWriter writer1 = new BufferedWriter(new FileWriter(
					tempFile1, true));
			BufferedWriter writer2 = new BufferedWriter(new FileWriter(
					tempFile2, true));
			for (int i = 0; i < vector1.size(); i++) {
				str1 = (String) vector1.elementAt(i);
				writer1.write(str1);
				writer1.newLine();
				writer1.flush();
			}
			for (int i = 0; i < vector2.size(); i++) {
				str2 = (String) vector2.elementAt(i);
				writer2.write(str2);
				writer2.newLine();
				writer2.flush();
			}
			writer1.close();
			writer2.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws IOException {
		String tempPath1 = "D:\\tmp\\test1.txt";
		String tempPath2 = "D:\\tmp\\test2.txt";
		// String sourceFolder = "D:/tmp/tmp";
		String resultPath1 = "D:\\tmp\\result1.txt";
		String resultPath2 = "D:\\tmp\\result2.txt";
		// File tempFile = new File(tempPath);
		ResortByDel resort = new ResortByDel();
		// resort.AllResortToTemp(sourceFolder,tempPath);//首先放到temp.txt，然后删除
		resort.ResortToTemp(tempPath1, tempPath2, resultPath1, resultPath2);// 把temp文件再去重放入result文件
		// resort.DelTemp(tempPath);//删除temp.txt中转文件
		System.out.println("OK");

	}

}
