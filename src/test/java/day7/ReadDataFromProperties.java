package day7;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

public class ReadDataFromProperties {

	@Test
	public void readProperties() throws IOException {
		
		File file = new File(System.getProperty("user.dir")+"\\src\\test\\java\\com\\ResourceFile\\OR.properties");
		
		Properties prop =new Properties();
		FileInputStream fis = new FileInputStream(file);
		
		prop.load(fis);
		
		System.out.println(prop.getProperty("bLogin"));
		
		
	}
}
