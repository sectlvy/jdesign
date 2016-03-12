package com.dahuang.swing.file;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dahuang.swing.FileDataBean;
import com.dahuang.swing.LineStrStrategy;
import com.dahuang.swing.bean.StrEqualStrBean;

public class StrAllLine implements LineStrStrategy {

	private List<String> titleList = new ArrayList<String>();
	private Map<String,List<String>> hashMap = new HashMap<String,List<String>>();
	private static String NoTitle=" ";
	@Override
	public FileDataBean getResDataBean(BufferedReader bufferedReader) {
		titleList.clear();
		hashMap.clear();
		String strline;
		String title = null;
		List<String> titleValueList = null;
		int maxLast = 0;
		try {
			strline = bufferedReader.readLine();
			titleValueList = new ArrayList<String>();
			while(strline!=null){
				if(strline!=null && strline!="" && strline.length()>0 && title==null){
					if(titleList.size()==0){
						titleList.add(NoTitle);
					}
					titleValueList.add(strline);
					hashMap.put(NoTitle, titleValueList);
					++maxLast;
				}
				strline = bufferedReader.readLine();
			}
			String[][] values = new String[maxLast][titleList.size()];
			for(int i =0;i<hashMap.size();i++){
				if(titleList.size()==0){
					//没标题数据
					values = new String[maxLast][1];
					for(int j=0;j<hashMap.get(NoTitle).size();j++){
						values[j][i] = hashMap.get(NoTitle).get(j);
					}
				}
				if(titleList.size()>0 && hashMap.get(titleList.get(i))!=null){
					for(int j=0;j<hashMap.get(titleList.get(i)).size();j++){
						values[j][i] = hashMap.get(titleList.get(i)).get(j);
					}
				}
			}
			FileDataBean fileDataBean = new StrEqualStrBean(titleList.toArray(new String[0]),values);
			//組裝fileData
			return fileDataBean;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
