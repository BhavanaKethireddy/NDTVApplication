package com.NDTVUtilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class NDTVUtilities {
	public static String utility(String url) throws IOException {
		String data;
		FileInputStream file = new FileInputStream("C:\\Users\\KE20587631\\eclipse-workspace\\SDET_NDTVProject\\src\\main\\resources\\NDTV.properties");
		Properties prop = new Properties();
		prop.load(file);
		data = prop.getProperty(url);
		return data;
	}
}


