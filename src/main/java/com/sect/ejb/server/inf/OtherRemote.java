package com.sect.ejb.server.inf;

import javax.ejb.Remote;

@Remote
public interface OtherRemote {
	String getSayWord();
}
