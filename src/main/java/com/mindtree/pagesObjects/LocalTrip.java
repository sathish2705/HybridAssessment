package com.mindtree.pagesObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.mindtree.exceptions.PageObjectException;
import com.mindtree.exceptions.ReusableComponentException;
import com.mindtree.reusableComponent.WebDriverSupport;
import com.mindtree.uipages.LocalUI;
import com.mindtree.utilities.ExtentLogUtilities;
import com.relevantcodes.extentreports.ExtentTest;

public class LocalTrip extends LocalUI{
	WebDriver driver;
	Logger log;
	ExtentTest test;

	public LocalTrip(WebDriver driver, Logger log, ExtentTest test) throws Exception {
		this.driver = driver;
		this.test = test;
		this.log = log;
	}
	public void Local() throws ReusableComponentException, Exception {
		try {
			WebDriverSupport.click(driver, local , "local", "local", log, test);
			WebDriverSupport.click(driver, select, "select", "selected", log, test);
			Thread.sleep(2000);
			WebDriverSupport.click(driver, selectcar, "select", "select car", log, test);
			
			if (driver.findElement(bookingdetail).isDisplayed()) {
				ExtentLogUtilities.pass(driver, test, "booking detail shown ", log);
				WebDriverSupport.click(driver, home, "home page", "home page", log, test);
			} else {
				ExtentLogUtilities.fail(driver, test, " booking detail not shown", log);
				throw new PageObjectException("verify failed");
			}
			
		}catch (Exception e) {
			throw new PageObjectException(e.getMessage());
		}
	}
}

