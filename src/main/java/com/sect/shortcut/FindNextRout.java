package com.sect.shortcut;

import java.util.ArrayList;
import java.util.Vector;

public class FindNextRout {
	private Vector al;
	private String sourcePort;
	private String destPort;
	private String nextPort;

	public FindNextRout(Vector al, String sourcePort, String destPort) {
		this.al = al;
		this.sourcePort = sourcePort;
		this.destPort = destPort;
		NextRout();
	}

	public String getNextPort() {
		return nextPort;
	}

	public void NextRout() {
		int a = -1;
		String rout = "";
		for (Object item : al) {
			ArrayList all = new ArrayList();
			String[] ss = (item + "").split("\\*");
			all.add(ss[0]);
			if (sourcePort.equals(ss[0])) {
				if (ss[1].equals(destPort)) {
					int b = Integer.parseInt(ss[2]);
					if (b < a || a == -1) {
						a = b;
						nextPort = ss[1];
					}
				} else {
					int b = getLeastCost(all, ss[1], destPort);
					int c = b + Integer.parseInt(ss[2]);
					if (b != -1) {
						if (a == -1) {
							a = c;
							nextPort = ss[1];
						} else {
							if (c < a) {
								a = c;
								nextPort = ss[1];
							}
						}
					}
				}
			}
		}

	}

	public int getLeastCost(ArrayList all, String sourcePort, String destPort) {
		int a = -1;
		if (!all.contains(sourcePort)) {
			all.add(sourcePort);
			for (Object item : al) {
				String[] ss = (item + "").split("\\*");
				if (sourcePort.equals(ss[0])) {
					if (!all.contains(ss[1])) {
						if (ss[1].equals(destPort)) {
							int b = Integer.parseInt(ss[2]);
							if (b < a || a == -1) {
								a = b;
							}
						} else {
							int b = getLeastCost(all, ss[1], destPort);
							int c = b + Integer.parseInt(ss[2]);
							if (b != -1) {
								if (a == -1) {
									a = c;
								} else {
									if (c < a) {
										a = c;
									}
								}
							}
						}
					}
				}
			}

		}
		return a;
	}
}