package com.sect.lamda;
@FunctionalInterface
public interface FunctionInterface {
	default void add(int x,int y){
		System.out.println(x+y);
		
		accept(x+y);
	}
	
	void accept(int x);
}
