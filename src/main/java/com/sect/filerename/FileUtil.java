package com.sect.filerename;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class FileUtil {
    /**
     *  ��ȡ�ļ���׺
     * @param filename
     * @return
     */
    public static String getExtensionName(String filename) {
	if ((filename != null) && (filename.length() > 0)) {
	    int dot = filename.lastIndexOf('.');
	    if ((dot > -1) && (dot < (filename.length() - 1))) {
		return filename.substring(dot + 1);
	    }
	}
	return filename;
    }
    /**
     * ��ȡ������׺���ļ���
     * @param filename
     * @return
     */
    public static String getFileNameNoEx(String filename) {   
        if ((filename != null) && (filename.length() > 0)) {   
            int dot = filename.lastIndexOf('.');   
            if ((dot >-1) && (dot < (filename.length()))) {   
                return filename.substring(0, dot);   
            }   
        }   
        return filename;   
    } 
    
    public static String getUrlFileName(String urlFile){
	String[] strs = urlFile.split("/");
	return strs[strs.length-1];
    }
    
    public static List<File> getAllFiles(String folderPath) throws IOException{
    	FileCommonHelper fl = new FileCommonHelper(folderPath);
		List<File> fileList = new ArrayList<File>();
		fl.getList(fileList);
		return fileList;
    }
    /**
     * ���ö�ջ����ʽ ʵ�ֵݹ�
     * @author Administrator
     *
     */
    static class FileCommonHelper {
    	private String dir_name = null;
    	Vector<String> ver = null;
    	
    	
    	public FileCommonHelper(String dir_name){
    		this.dir_name = dir_name; // �ļ��е�ַ
    		ver = new Vector<String>(); // ������ջ
    	}

    	public void getList(List<File> fileList) throws IOException {
    		ver.add(dir_name);
    		while (ver.size() > 0) {
    			File[] files = new File(ver.get(0).toString()).listFiles(); // ��ȡ���ļ��������е��ļ�(��)��
    			ver.remove(0);

    			int len = files.length;
    			for (int i = 0; i < len; i++) {
    				String tmp = files[i].getAbsolutePath();
    				if (files[i].isDirectory()) // �����Ŀ¼���������С��Ա���к�������
    					ver.add(tmp);
    				else
    					fileList.add(files[i]);
    			}
    		}
    	}
    	
    }
}
