package com.sect.datax.logreport.base;

import org.apache.log4j.PropertyConfigurator;

public class Log4jInit {
	public static void init(String configPath) {
		System.out.println("................log4j start.................");
		if (configPath != null) {
			PropertyConfigurator.configure(configPath);
		}
	}
}
