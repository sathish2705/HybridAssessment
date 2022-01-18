package com.mindtree.pagesObjects;

import java.util.Iterator;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.mindtree.exceptions.PageObjectException;
import com.mindtree.exceptions.ReusableComponentException;
import com.mindtree.reusableComponent.WebDriverSupport;
import com.mindtree.uipages.TwiiterUI;
import com.mindtree.utilities.ExtentLogUtilities;
import com.relevantcodes.extentreports.ExtentTest;

public class Twitter extends TwiiterUI {
	WebDriver driver;
	Logger log;
	ExtentTest test;


	public Twitter(WebDriver driver, Logger log, ExtentTest test) throws Exception {
		this.driver = driver;
		this.test = test;
		this.log = log;
	}
	public void inst() throws ReusableComponentException, Exception {
		try {
			WebDriverSupport.click(driver, twitterClick , "Twitter is clicked", "Twitter is clicked", log, test);
			Set<String>ids=driver.getWindowHandles();
			Iterator<String> it=ids.iterator();
			String parentid=it.next();
			String childid=it.next();
			Thread.sleep(2000);
			driver.switchTo().window(childid);
			Thread.sleep(3000);
			 if (driver.findElement(twitterTitle).isDisplayed()) {
					ExtentLogUtilities.pass(driver, test, "result detail shown ", log);
					driver.close();
					
				} else {
					ExtentLogUtilities.fail(driver, test, " result detail not shown", log);
					throw new PageObjectException("verify failed");
				}
	            
	            driver.switchTo().window(parentid);
		}catch (Exception e) {
			throw new PageObjectException(e.getMessage());
		}
	}

}
