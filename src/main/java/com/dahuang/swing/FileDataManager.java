package com.dahuang.swing;


/**
 * ���ڻ�ȡ�ļ�������
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
