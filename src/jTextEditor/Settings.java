package jTextEditor;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Settings {
	
	
	Properties mySettings = new Properties();
	FileOutputStream out;
	
	public void saveSettingsToXML(){
		
		try {
			out = new FileOutputStream("properties.xml");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("Error");
		}
		
		
		try {
			mySettings.storeToXML(out, null);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public void setValue(String var, String value){
		
		mySettings.setProperty(var, value);
		saveSettingsToXML();
		System.out.println("Saved");
	}
	
	public String getValue(String var){
		
		try{
			mySettings.loadFromXML(new FileInputStream("properties.xml"));
			System.out.println("Loaded");
		}catch(IOException e){
			e.printStackTrace();
			System.out.println("Error");
		}
		
		String value;
		
		value = mySettings.getProperty(var);
		
		System.out.println(value);
		return value;
		
	}
	
}
