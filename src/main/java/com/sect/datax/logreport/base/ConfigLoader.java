package com.sect.datax.logreport.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

public class ConfigLoader {
	private static Logger log = Logger.getLogger(ConfigLoader.class);
	private static Properties properties = new Properties();
	
	public static void loadProperties(String configPath){
		try {
			File configFolder = new File(configPath);
			if (configFolder.isDirectory()) {
				File[] files = configFolder.listFiles();
				for (File file : files) {
					properties.load(new FileInputStream(file));
				}
			} else {
				properties.load(new FileInputStream(new File(configPath)));
			}
		} catch (IOException e) {
			log.error(e);
		}
	}
	public static String getProperty(String key){
		return (String)properties.get(key);
	}
	
	public static void setProperty(String key,String value){
		properties.setProperty(key, value);
	}
	
	public static String getProperty(String url,String key){
		return (String)properties.get(url+"@"+key);
	}
	public static void setProperty(String url,String key,String value){
		properties.setProperty(url+"@"+key, value);
	}
	public static List<Entry> getAllPrefixEntry(String url) {
		List<Entry> headEntryList = new ArrayList<Entry>();
		Set<Object> keyset = properties.keySet();
		if (keyset != null) {
			Iterator<Object> Iterator = keyset.iterator();
			while (Iterator.hasNext()) {
				String key = (String) Iterator.next();
				Pattern pattern = Pattern.compile(url + "@(.*)");
				Matcher matcher = pattern.matcher(key);
				if (matcher.find()) {
					String newKey = matcher.group(1);
					headEntryList.add(new Entry(newKey, properties.getProperty(key)));
				}
			}
		}
		return headEntryList;
	}

	public static class Entry {
		private String key;
		private String value;

		public Entry(String key, String value) {
			this.key = key;
			this.value = value;
		}

		public String getKey() {
			return key;
		}

		public void setKey(String key) {
			this.key = key;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}
	}
}
