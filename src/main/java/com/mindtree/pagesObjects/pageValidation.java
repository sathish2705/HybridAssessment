package com.mindtree.pagesObjects;


import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.mindtree.exceptions.PageObjectException;
import com.mindtree.utilities.ExtentLogUtilities;
import com.relevantcodes.extentreports.ExtentTest;

public class pageValidation {
	WebDriver driver;
	Logger log;
	ExtentTest test;
	public pageValidation(WebDriver driver, Logger log, ExtentTest test) {
		this.driver = driver;
		this.test = test;
		this.log = log;
	}
	public void Validate(String title) throws Exception {
		if(title.equalsIgnoreCase(driver.getTitle())) {
			ExtentLogUtilities.pass(driver, test, "Page opend with title " + title, log);
		}else {
		ExtentLogUtilities.fail(driver, test, "Page not opened with title " + title, log);
		throw new PageObjectException("Page not opened with title " + title);
		}
	}

}
