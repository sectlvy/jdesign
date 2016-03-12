package com.sect.ejb.server.impl;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.sect.ejb.server.inf.HelloRemoteBean;
import com.sect.ejb.server.inf.OtherRemote;

/**
 * Session Bean implementation class HelloLocalBean
 */
@Stateless
public class HelloLocalBean implements HelloRemoteBean {
	@EJB
	private OtherRemote otherRemote;
    /**
     * Default constructor. 
     */
    public HelloLocalBean() {
    }

	@Override
	public void sayHello(String sayword) {
		
		otherRemote.getSayWord();
		
		System.out.println("Hello"+sayword+"@@@@@"+otherRemote.getSayWord());
	}

}
