package com.sect.hashcode;

import java.util.HashSet;

import org.apache.log4j.Logger;

public class MainCode {
	public static void main(String[] args){
		A a = new A();
		B b = new B();
		
		System.out.println(a.equals(b));
		System.out.println(a.hashCode());
		System.out.println(b.hashCode());
		
		String s1 = "fwefwfesddd";
		String s2 = "eeeeeeeeeee";
		
		System.out.println('e'*31+'e');
		System.out.println("ee".hashCode());
		
		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());
		
		MainCode mainCode1 = new MainCode();
		MainCode mainCode2 = new MainCode();
		
		System.out.println("mainCode1="+mainCode1.hashCode());
		System.out.println("mainCode2="+mainCode2.hashCode());
		System.out.println(mainCode1.equals(mainCode2));
		
		HashSet set = new HashSet();
		set.add(mainCode1);
		set.add(mainCode2);
		for(int i=0;i<100;i++){
			mainCode1.logInfo(i+" hello");
		}
	}
	
	private void logInfo(String info){
		Logger logger = Logger.getLogger("sect");
		logger.info(info);
	}
}
