package com.comcast.crm.generic.fileutility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {
public String getDataFromPropertyFile(String key) throws IOException
{
	FileInputStream fis=new FileInputStream("./configappData/commondata1.properties");
	Properties p=new Properties();
	p.load(fis); //to load all the keys
	String data=p.getProperty(key); //pass the key as to for which the value is required
	return data; //return data back to calling function
}
}
