package com.comcast.crm.generic.fileutility;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonUtility {
	public String getDataFromJsonFile(String key) throws IOException, ParseException {
		FileReader fr = new FileReader("./configappData/appcommondata.json");// get the java object of the physical json
																				// propfile
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(fr);// parse the jsonfile actual java object
		JSONObject map = (JSONObject) obj;// convert into hashmap(key value pair for conversion getting the java 'obj'
											// and doing the downcasting to json object
		// because of the conversion we can read the data based on key
		String data = (String) map.get(key);
		return data;
	}
}
