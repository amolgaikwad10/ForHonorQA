package com.qa.forhonor.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {

public static WebDriver driver;
public static Properties prop;
String prop_path="D:\\My Data\\Eclipse O2\\ForHonorWebQA\\src\\main\\java\\com\\qa\\forhonor\\config\\Property.properties";

public BaseClass() {
	try {
	     prop=new Properties();
		 FileInputStream fis=new FileInputStream(prop_path);
		 prop.load(fis);
	} catch (FileNotFoundException exception) {
		exception.printStackTrace();
	} catch (IOException exception) {
		exception.printStackTrace();
	}
}
	
	public static void initialize(){
		
		String browserName=prop.getProperty("Browser");		
		if(browserName.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver","D:\\01 Latest\\gecko_path\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		
		else if(browserName.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver","D:\\01 Latest\\chromedriver_2.33\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		
		else if(browserName.equalsIgnoreCase("IE")){
			/*System.setProperty("webdriver.chrome.driver","H:\\Latest Selenium\\chromedriver\\chromedriver.exe");
			instance=new ChromeDriver();*/
		}
		
		else{
			System.out.println("++++ Check Browser spell > firefox OR chrome OR IE ++++");
		}
	    
		driver.manage().window().maximize();
		driver.get(prop.getProperty("URL"));	
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		//driver.manage().deleteAllCookies();
		
}
}


