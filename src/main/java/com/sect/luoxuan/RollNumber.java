package com.sect.luoxuan;

public class RollNumber {
	private int number;//Ȧ��
	
	private int[][] rollNumArray;
	public RollNumber(int number){
		this.number = number-1;
		init();
	}
	
	private void init(){
		int n = number+2;
		rollNumArray = new int[n][n];
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}

}
