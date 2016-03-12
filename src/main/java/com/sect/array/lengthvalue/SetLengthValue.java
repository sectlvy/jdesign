package com.sect.array.lengthvalue;

public class SetLengthValue {

	public static void main(String[] args) {
		int[] s = new int[15];
//		s.length=9;
		FinalFieldt fft = new FinalFieldt();
		fft.setId("132");
		System.out.println(s.length);
	}
	
}

class FinalFieldt{
	public final String name="123";

	public String getName() {
		return name;
	}
	
	public String id = "";

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}