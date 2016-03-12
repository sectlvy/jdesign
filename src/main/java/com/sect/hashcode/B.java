package com.sect.hashcode;

public class B {

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
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
