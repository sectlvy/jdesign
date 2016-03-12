package com.sect.hashcode;

public class A {

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	@Override
	public boolean equals(Object arg0) {
		return super.equals(arg0);
	}

	@Override
	protected void finalize() throws Throwable {
		super.finalize();
	}

	@Override
	public int hashCode() {
		return 123123;
	}

	@Override
	public String toString() {
		return super.toString();
	}
	
}
