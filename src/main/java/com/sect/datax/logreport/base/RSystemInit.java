/**
 * Kangle Lu
 * 2013骞�1鏈�6鏃�
 */
package com.sect.datax.logreport.base;

import java.io.File;

public class RSystemInit {
    public static void init(String args[]){
	String baseConfigDir = "E:\\workspace\\hreport\\config";
	if(args!=null && args.length>0){
	    baseConfigDir = args[0];
	}
	Log4jInit.init(baseConfigDir +File.separator+"log4j.properties");
	ConfigLoader.loadProperties(baseConfigDir);
	DatabaseManager.init();
    }
}
