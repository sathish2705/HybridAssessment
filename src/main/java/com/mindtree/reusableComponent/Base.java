package com.mindtree.reusableComponent;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.mindtree.utilities.ExcelSheetRead;

public class Base extends ExcelSheetRead {
	public Base() throws Exception {
		super();
	}
	 static public WebDriver driver;
	
	public static WebDriver intialize() throws Exception{
		if(driver == null ) {
			if(get.getProperty("browser").equalsIgnoreCase("Chrome")) {
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+get.getProperty("path"));
				driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);		
		}
			else if(get.getProperty("browser").equalsIgnoreCase("Firefox")) {
				System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+get.getProperty("path"));
				driver = new FirefoxDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			}
			else if(get.getProperty("browser").equalsIgnoreCase("IE")) {
				System.setProperty("webdriver.InternetExplorer.driver", System.getProperty("user.dir")+get.getProperty("path"));
				driver = new InternetExplorerDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			}
			else {
			System.out.println("We don't support this browser");	
			}
		}
		return driver;
	}
	

}
