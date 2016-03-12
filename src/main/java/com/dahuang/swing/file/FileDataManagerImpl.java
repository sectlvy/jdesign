package com.dahuang.swing.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import com.dahuang.swing.FileDataBean;
import com.dahuang.swing.FileDataManager;
import com.dahuang.swing.LineStrStrategy;

public class FileDataManagerImpl implements FileDataManager {
	
	private static FileDataManager fileDataManager = null;
	private static LineStrStrategy lineStrStrategy;
	private static LineStrStrategy strAllLine;
	public static FileDataManager getInstance() {
		if(fileDataManager==null){
			synchronized (FileDataManager.class) {
				if(fileDataManager==null){
					fileDataManager = new FileDataManagerImpl();
					lineStrStrategy = new StrEqualStrStrategy();
					strAllLine = new StrAllLine();
				}
			}
		}
		return fileDataManager;
	}
	public FileDataBean getFileDataBean(String fileName){
		try{
			File file = new File(fileName);
			if(!file.isFile()){
				throw new RuntimeException("FileDataManager无法处理文件"+fileName);
			}
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			FileDataBean  dataBean = lineStrStrategy.getResDataBean(bufferedReader);
			
			fileReader.close();
			bufferedReader.close();
			return dataBean;
		}catch(Exception e){
			return null;
		}
	}
	/**
	 * 获取正行 不截取的行内容
	 * @param fileName
	 * @return
	 */
	public FileDataBean getStrAllLineValue(String fileName){
		try{
			File file = new File(fileName);
			if(!file.isFile()){
				throw new RuntimeException("FileDataManager无法处理文件"+fileName);
			}
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			FileDataBean  dataBean = strAllLine.getResDataBean(bufferedReader);
			
			fileReader.close();
			bufferedReader.close();
			return dataBean;
		}catch(Exception e){
			return null;
		}
	}
}
