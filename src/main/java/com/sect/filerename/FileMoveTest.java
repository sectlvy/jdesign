package com.sect.filerename;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

public class FileMoveTest {
	static FileMove fileMove = null;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		String filePath = "I:\\media\\33";
		String targetFilePath = "I:\\media";
		fileMove = new FileMove(filePath,targetFilePath);
	}

	@After
	public void tearDown() throws Exception {
	}

	public void test() {
		fileMove.move();
		System.out.println(fileMove.number);
	}
	@Test
	public void testaa(){
		String cpath = "I:\\media\\2.avi";
		String filer = "avi";
		boolean s = cpath.indexOf(filer) == (cpath.length()-filer.length());
		
		System.out.println(s);
	}
}
