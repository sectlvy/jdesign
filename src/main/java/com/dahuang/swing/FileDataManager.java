package com.dahuang.swing;


/**
 * 用于获取文件中数据
 * @author Administrator
 *
 */
public interface FileDataManager {
	/**
	 * 
	 * @param fileName
	 * @return
	 */
	FileDataBean getFileDataBean(String fileName)	throws Exception;
	/**
	 * 
	 * @param fileName
	 * @return
	 * @throws Exception
	 */
	public FileDataBean getStrAllLineValue(String fileName)	throws Exception;
}
