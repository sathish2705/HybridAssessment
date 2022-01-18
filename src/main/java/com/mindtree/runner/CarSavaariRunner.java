package com.mindtree.runner;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mindtree.exceptions.ApplicationException;
import com.mindtree.exceptions.UtilityException;
import com.mindtree.pagesObjects.CorporateCarRental;
import com.mindtree.pagesObjects.LocalTrip;
import com.mindtree.pagesObjects.OutStationOneWay;
import com.mindtree.pagesObjects.OutStationRoundTrip;
import com.mindtree.pagesObjects.Signin;
import com.mindtree.pagesObjects.Signout;
import com.mindtree.pagesObjects.Twitter;
import com.mindtree.pagesObjects.instaGram;
import com.mindtree.reusableComponent.Base;
import com.mindtree.utilities.ExtentLogUtilities;
import com.mindtree.utilities.GetProperties;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class CarSavaariRunner extends Base{
	static Logger log;
	static ExtentTest test;
	static ExtentReports report;
	
	public CarSavaariRunner() throws UtilityException,Exception{
		super();
	}
	
	@BeforeTest
	public void  intializeDriver() throws ApplicationException {
		try {
		report = new ExtentReports(System.getProperty("user.dir") + "\\reports\\" + "ExtentReportResults-"
				+ System.currentTimeMillis() + "-.html");
		log = Logger.getLogger(CarSavaariRunner.class.getName());
		driver=intialize();
		test = report.startTest("Home Page");
		driver.get(GetProperties.get.getProperty("url"));
		ExtentLogUtilities.pass(driver, test,"URL invoked Successfuly", log);
		report.endTest(test);
		report.flush();
		} catch (Exception e) {
			throw new ApplicationException(e.getMessage());
		}
	}
	
	@Test(priority = 1, dataProvider = "getTitle")
	public void pageValidation(String title) throws ApplicationException {
		test=report.startTest("Validating Title");
		try {
			new com.mindtree.pagesObjects.pageValidation(driver, log, test).Validate(title);
			report.endTest(test);
			report.flush();
		}catch (Exception e) {
			report.endTest(test);
			report.flush();
			throw new ApplicationException(e.getMessage());
		}
	}
	@DataProvider
	public Object[] getTitle() {
		Object data[] = new Object[1];
		data[0]=get.getProperty("title");
		return data;
	}
	
	@Test(priority = 2, dataProvider = "signin")
	public void signin(String uid,String pw) throws ApplicationException {
		test = report.startTest("sign in");
		try {
			new Signin(driver, log, test).Button(uid, pw);
			report.endTest(test);
			report.flush();
		} catch (Exception e) {
			report.endTest(test);
			report.flush();
			throw new ApplicationException(e.getMessage());
		}
	}

	@DataProvider
	public Object[] signin() {
		Object data[][] = new Object[1][2];
		data[0][0] = excelData.get("id");
		data[0][1] = excelData.get("pwd");
		return data;

	}
	@Test(priority = 3)
	public void TravelAgent() throws ApplicationException {
		test = report.startTest("Travel Agent");
		try {
			new com.mindtree.pagesObjects.TravelAgent(driver,log,test).Agent();
			report.endTest(test);
			report.flush();
		}catch (Exception e){
			report.endTest(test);
			report.flush();
			throw new ApplicationException(e.getMessage());
		}
	}
	
	@Test(priority = 4,dataProvider = "outstation")
	public void outStation(String from1 ,String to1) throws ApplicationException {
		test= report.startTest("OutStaion OneWay");
		try {
			new OutStationOneWay(driver ,log , test).OutStation(from1, to1);
			report.endTest(test);
			report.flush();
		}catch (Exception e) {
			report.endTest(test);
			report.flush();
			throw new ApplicationException(e.getMessage());
			}
	}

		@DataProvider
		public Object[] outstation() {
			Object data[][] = new Object[1][2];
			data[0][0] = excelData.get("from1");
			data[0][1] = excelData.get("to1");
			return data;
		}
		@Test(priority = 5)
		public void trip() throws ApplicationException {
			test = report.startTest("roundTrip");
			try {
				new OutStationRoundTrip(driver,log,test).roundTrip();
				report.endTest(test);
				report.flush();
			} catch (Exception e) {
				report.endTest(test);
				report.flush();
				throw new ApplicationException(e.getMessage());
			}
		}
		@Test(priority = 6)
		public void Local() throws ApplicationException {
			test = report.startTest("local");
			try {
				new LocalTrip(driver, log, test).Local();
				report.endTest(test);
				report.flush();
			} catch (Exception e) {
				report.endTest(test);
				report.flush();
				throw new ApplicationException(e.getMessage());
			}
	}
		@Test(priority = 7)
		public void instgram1() throws ApplicationException {
			test = report.startTest("instagram");
			try {
				new instaGram(driver, log, test).inst();
				report.endTest(test);
				report.flush();
			} catch (Exception e) {
				report.endTest(test);
				report.flush();
				throw new ApplicationException(e.getMessage());
			}
		}
		@Test(priority = 8, dataProvider = "getData3")
		public void CarRental(String nam,String comnam,String email,String phn) throws ApplicationException {
			test=report.startTest("Car Rental");
			try {
				new CorporateCarRental(driver, log, test).CarRental(nam,comnam,email,phn);
				report.endTest(test);
				report.flush();
			} catch (Exception e) {
				report.endTest(test);
				report.flush();
				throw new ApplicationException(e.getMessage());
			}
		}

		@DataProvider
		public Object[] getData3() {
			Object val[][] = new Object[1][4];
			val[0][0] = excelData.get("nam");
			val[0][1] = excelData.get("comnam");
			val[0][2] = excelData.get("email");
			val[0][3] = excelData.get("phn");
			return val;
		}
		@Test(priority = 9)
		public void instgram() throws ApplicationException {
			test = report.startTest("Twitter");
			try {
				new Twitter(driver, log, test).inst();
				report.endTest(test);
				report.flush();
			} catch (Exception e) {
				report.endTest(test);
				report.flush();
				throw new ApplicationException(e.getMessage());
			}
		}
			@Test(priority = 9)
			public void signOuts() throws ApplicationException {
				test = report.startTest("logout");
				try {
					new Signout(driver, log, test).signout();
					report.endTest(test);
					report.flush();
				} catch (Exception e) {
					report.endTest(test);
					report.flush();
					throw new ApplicationException(e.getMessage());
				}
			}
			
			@AfterTest
			public void closeInstance() {
				driver.quit();
			}

}
