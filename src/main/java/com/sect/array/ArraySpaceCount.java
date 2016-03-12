package com.sect.array;

public class ArraySpaceCount {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		System.out.println(123);
		String[] ss = new String[]{"1ff","22","33"};
		
		for(String s:ss){
			System.out.println(s.hashCode());
		}
		
		int[] s = new int[1000000]; //3922
		for(int i=0;i<1000000;i++){
			s[i]=i;
		}
		
		System.out.println(s.hashCode());
	}

}
