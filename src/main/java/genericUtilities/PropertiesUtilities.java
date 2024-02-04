package genericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * This class contains reusable methods to initialize and read data from properties file
 * @author sowmya lekkala
 */

public class PropertiesUtilities {
	private Properties property;//here we created access specifier as private because only for sometimes we call the properties.
	/**
	 * 
	 * @param filePath
	 */
	public void propertiesInit(String filePath){
		//everytime file path will change so we store it in variable and pause parameter
		FileInputStream fis=null;
		try {
			fis=new FileInputStream(filePath);
		}catch(FileNotFoundException e) {
			e.printStackTrace();	
		}
		property=new Properties();
		try {
			property.load(fis);
		}
		catch(IOException e) {
			e.printStackTrace();	
		}
	}
	/**
	 * This method fetches data from properties file based on the key passed as an argument
	 * @param key
	 * @return
	 */
	public String readFromProperties(String key) {
		return property.getProperty(key);	
	}
}
