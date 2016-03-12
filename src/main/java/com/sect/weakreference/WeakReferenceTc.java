package com.sect.weakreference;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

public class WeakReferenceTc {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str = new String("hello"); //��  
		ReferenceQueue rq = new ReferenceQueue(); //��&nbsp;  
		WeakReference wf = new WeakReference(str, rq); //��  
		str=null; //��  
		//���δߴ��������������������"hello"���󱻻��յĿ�����  
		System.gc(); //��  
		System.gc(); //��  
		String str1=(String) wf.get(); //�� ����"hello"���󱻻��գ�str1Ϊnull  
		System.out.println(str1);
		Reference ref=rq.poll(); //��  

	}

}
