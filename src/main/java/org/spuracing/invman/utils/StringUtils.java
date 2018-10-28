package org.spuracing.invman.utils;

public class StringUtils {
	
	public static String capatilizeFirstLetter(String str) {
		return str.substring(0,1).toUpperCase() + str.substring(1).toLowerCase();
	}
}
