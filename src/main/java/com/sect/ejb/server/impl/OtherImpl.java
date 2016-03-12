package com.sect.ejb.server.impl;

import javax.ejb.Stateful;

import com.sect.ejb.server.inf.OtherRemote;
@Stateful
public class OtherImpl implements OtherRemote {
	private int time = 1;
	@Override
	public String getSayWord() {
		time++;
		System.out.println("time="+time);
		return "other";
	}

}
