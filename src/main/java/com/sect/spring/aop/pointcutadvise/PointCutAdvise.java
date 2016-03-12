package com.sect.spring.aop.pointcutadvise;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;



@Aspect
public class PointCutAdvise {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	@After(value = "exc")
	public void aftermethodinvok(){
		
	}

}
