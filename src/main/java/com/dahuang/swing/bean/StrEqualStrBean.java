package com.dahuang.swing.bean;

import com.dahuang.swing.FileDataBean;

public class StrEqualStrBean implements FileDataBean {
	private String[] titles;
	private String[][] titleVlues;
	public StrEqualStrBean(String[] titles,String[][] titleVlues){
		this.titles = titles;
		this.titleVlues = titleVlues;
//		StrFileDataBean[] strFileDataBeans = new StrFileDataBean[titles.length];
//		for(int i=0;i<titles.length;i++){
//			StrFileDataBean strFileDataBean = new StrFileDataBean(titles[i],titleVlues[i]);
//			strFileDataBeans[i] = strFileDataBean;
//		}
	}
	public void addLine(String title,String[] titlesValues){
		
	}
	private StrFileDataBean[] strFileDataBeans;
	
	public StrFileDataBean[] getStrFileDataBeans() {
		return strFileDataBeans;
	}

	public void setStrFileDataBeans(StrFileDataBean[] strFileDataBeans) {
		this.strFileDataBeans = strFileDataBeans;
	}

	@Override
	public String getTitle(int number) {
		return strFileDataBeans[number].getTitle();
	}
	
	@Override
	public int getTitleSize() {
		return strFileDataBeans.length;
	}

	@Override
	public String[][] getTitleValues() {
		return this.titleVlues;
	}

	@Override
	public String[] getTitles() {
		return this.titles;
	}
	class StrFileDataBean{
		private String title;
		private String[] titleValues;
		
		
		public StrFileDataBean(String prititle,String[] prititleValues){
			this.title = prititle;
			this.titleValues = prititleValues;
		}
		
		
		public String getTitle() {
			return title;
		}
		public void setTitle(String prititle) {
			this.title = prititle;
		}
		public String[] getTitleValues() {
			return titleValues;
		}
		public void setTitleValues(String[] prititleValues) {
			this.titleValues = prititleValues;
		}
	}
}
