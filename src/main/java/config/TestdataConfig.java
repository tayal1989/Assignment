package config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestdataConfig {
	
	public String url;
	public String apiUrl;
	public String findPetStatusApi;
	public String addPetApi;
	
	public Properties prop;

	/**
	 * This will load test data from testdata file
	 */
	public void populateConfiguration() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "/src/test/java/testdata/testdata.properties");
			prop.load(ip);

			// API URL
			url = prop.getProperty("url");
			apiUrl = prop.getProperty("api.url");
			findPetStatusApi = prop.getProperty("find.pet.status.api");
			addPetApi = prop.getProperty("add.pet.api");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
