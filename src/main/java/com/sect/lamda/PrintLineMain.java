package com.sect.lamda;

public class PrintLineMain {

	public static void main(String[] args) {
		Runnable ab = ()->{System.out.println("0000");};
		FunctionInterface functionInterface = (int x)->{System.out.println("0000");};
		
		functionInterface.add(2, 2);
	}

}
