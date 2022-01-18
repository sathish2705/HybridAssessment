package com.mindtree.pagesObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.mindtree.exceptions.PageObjectException;
import com.mindtree.reusableComponent.WebDriverSupport;
import com.mindtree.uipages.OutStationOneWayUI;
import com.mindtree.utilities.ExtentLogUtilities;
import com.relevantcodes.extentreports.ExtentTest;

public class OutStationOneWay extends OutStationOneWayUI {
	WebDriver driver;
	Logger log;
	ExtentTest test;
	
	public OutStationOneWay(WebDriver driver, Logger log, ExtentTest test) throws Exception {
		this.driver = driver;
		this.test = test;
		this.log = log;
	}
	public void OutStation(String from1, String to1) throws PageObjectException{
		try {
			Thread.sleep(2000);
			WebDriverSupport.click(driver, from, "from", "from place", log, test);
			WebDriverSupport.sendKeys(driver, from, "from", "place", log, test, from1);
			WebDriverSupport.click(driver, to, "to", "place", log, test);
			WebDriverSupport.sendKeys(driver, to, "to", "place", log, test, to1);
			driver.findElement(to).sendKeys(Keys.ENTER);
			//WebDriverSupport.click(driver, desti, "to", "place", log, test);
			Thread.sleep(2000);
			WebDriverSupport.click(driver, select, "select", "selected", log, test);
			Thread.sleep(2000);
			
			if(driver.findElement(verify).isDisplayed()) {
				ExtentLogUtilities.pass(driver, test, "Successfully verified", log);
				WebDriverSupport.click(driver, home, "home page", "home page", log, test);
				Thread.sleep(2000);
			}else {
				ExtentLogUtilities.fail(driver, test, " failed to verify", log);
				throw new PageObjectException("verify failed");
			}
		}catch (Exception e) {
			throw new PageObjectException(e.getMessage());
	}
	}
}
