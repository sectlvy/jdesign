/**
 * @author Kangle Lu
 * 2015��1��1��
 */
package com.sect.filerename;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class FilmToFolder {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		getAllFile("E:\\eyd", "E:\\d");
	}

	public static void getAllFile(String path, String targetPath) throws IOException {
		List<File> files = FileUtil.getAllFiles(path);
		File tfile = new File(targetPath);
		if (!tfile.exists()) {
			tfile.mkdirs();
		}
		File tlajifile = new File(targetPath + File.separator + "laji");
		if (!tlajifile.exists()) {
			tlajifile.mkdirs();
		}
		for (File file : files) {
			if (file.getName().indexOf("bt.td") < 0 && !file.getName().endsWith("rar")) {
				System.out.println(file.getName() + "@@---->" + file.length());
				if (file.length() > 100000000l) {
					File tff = new File(tfile, file.getName());
					file.renameTo(tff);
				} else {
					File tff = new File(tlajifile, file.getName());
					file.renameTo(tff);
				}
			}
		}
		
	}

}
