package com.mindtree.pagesObjects;

import java.util.Iterator;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.mindtree.exceptions.PageObjectException;
import com.mindtree.exceptions.ReusableComponentException;
import com.mindtree.reusableComponent.WebDriverSupport;
import com.mindtree.uipages.TravelAgentUI;
import com.mindtree.utilities.ExtentLogUtilities;
import com.relevantcodes.extentreports.ExtentTest;

public class TravelAgent extends TravelAgentUI {
	WebDriver driver;
	Logger log;
	ExtentTest test;

	public TravelAgent(WebDriver driver, Logger log, ExtentTest test) throws Exception {
		this.driver = driver;
		this.test = test;
		this.log = log;
	}
	
	public void Agent() throws ReusableComponentException, Exception{
		try {
		
			WebDriverSupport.click(driver, agent, "Travel Agent", "Travel Agent", log, test);
			Set<String>ids=driver.getWindowHandles();
			Iterator<String> it=ids.iterator();
			String parentid=it.next();
			String childid=it.next();
			Thread.sleep(2000);
			driver.switchTo().window(childid);
			Thread.sleep(2000);
			
			if(driver.findElement(agentlogo).isDisplayed()) {
				ExtentLogUtilities.pass(driver, test, "Travel Agent details shown ", log);
				driver.close();
			}else {
				ExtentLogUtilities.fail(driver, test, " Travel Agent details not shown", log);
				throw new PageObjectException("verify failed");
			}
			driver.switchTo().window(parentid);
			WebDriverSupport.click(driver, home, "home page", "home page", log, test);
		}catch (Exception e) {
			throw new PageObjectException(e.getMessage());
		}
	}

}