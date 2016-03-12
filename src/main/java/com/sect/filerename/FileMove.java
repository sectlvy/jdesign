package com.sect.filerename;
/**
 * ��ԭ·�������е��ļ��ƶ���Ŀ��·����  
 * �ļ��в��ƶ�
 */
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileMove {
	
	private String filePath;//ԭ·��
	private String targetPath;//Ŀ��·��
	public static int number = 0;
	private String filer = "avi";//ֻ�Ƹ����ļ�
	
	private List<String> cllist = new ArrayList<String>();
	private List<File> fileList = new ArrayList<File>();
	public FileMove(String filePath,String targetPath){
		this.filePath = filePath;
		this.targetPath = targetPath;
		File file = new File(targetPath);
		if(!file.exists()){
			file.mkdirs();
		}
	}
	
	public void move(){
		File filePathFile = new File(filePath);
		
		System.out.println("start to analise");
		move(filePathFile);
		
		groupby();
	}
	public void combain(){
		File filePathFile = new File(filePath);
		
		System.out.println("start to analise");
		combain(filePathFile);
	}
	/**
	 * �������ļ������� �ϲ�
	 */
	public void combain(File cpath){
		if(cpath!=null && cpath.isDirectory()){
			String[] cfileList = cpath.list();
			for(String fpath : cfileList){
				File temFile = new File(cpath.getAbsolutePath()+File.separator+fpath);
				combain(temFile);
			}
		}else if(cpath!=null && cpath.isFile()){
			try{
				File newFile = new File(targetPath+File.separator+cpath.getName());
				if(!newFile.getParentFile().exists()){
					newFile.getParentFile().mkdirs();
				}
				cpath.renameTo(newFile);
			}catch(Exception e){
				System.out.println(cpath.getAbsolutePath()+cpath.getName()+"@@@"+e.getMessage());
			}
		}
	}
	private void move(File cpath){
		if(cpath!=null && cpath.isDirectory()){
			String[] cfileList = cpath.list();
			for(String fpath : cfileList){
				File temFile = new File(cpath.getAbsolutePath()+File.separator+fpath);
				move(temFile);
			}
		}else if(cpath!=null && cpath.isFile()){
			try{
				cllist.add(cpath.getName().substring(cpath.getName().lastIndexOf(".")+1,cpath.getName().length()));
				fileList.add(cpath);
				number++;
			}catch(Exception e){
				System.out.println(cpath.getAbsolutePath()+cpath.getName()+"@@@"+e.getMessage());
			}
		}
	}
	
	public void groupby(){
		System.out.println(" start to group by....");
		for(String gp : cllist){
			for(File file : fileList){
				if(file.getName().indexOf(gp)>0){
					File newFile = new File(targetPath+File.separator+gp+File.separator+file.getName());
					if(!newFile.getParentFile().exists()){
						newFile.getParentFile().mkdirs();
					}
					file.renameTo(newFile);
				}
			}
		}
	}
	public String getFiler() {
		return filer;
	}

	public void setFiler(String filer) {
		this.filer = filer;
	}
}
