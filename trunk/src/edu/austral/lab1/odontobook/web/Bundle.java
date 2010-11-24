package edu.austral.lab1.odontobook.web;

import java.util.Locale;
import java.util.ResourceBundle;

public class Bundle {
	
	private static ResourceBundle bundle;
	private static Locale locale;
	
	public Bundle(){
		locale = new Locale("en", "US");
		
	}
	
	public static void setLocale(Locale aux){

		locale = aux;
		bundle = ResourceBundle.getBundle("MessagesBundle", locale);
		
	}
	
	public static ResourceBundle getBundle(){
		bundle = ResourceBundle.getBundle("MessagesBundle", locale);
		return bundle;
	}
	
	public static String getString(String palabra){
		return bundle.getString(palabra);
	}
	
	public static String bundleSS(){
		return "Bundle string";
	}
	
	public  String bundleS(){
		return "Bundle string";
	}

}
