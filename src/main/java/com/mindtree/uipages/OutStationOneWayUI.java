package com.mindtree.uipages;

import org.openqa.selenium.By;

public class OutStationOneWayUI {
	public static By from = By.xpath("//input[@id='fromCityList']");
	public static By to = By.xpath("//input[@placeholder='Start typing city - e.g. Mysore']");
	public static By desti =By.xpath("//*[@id=\"approot\"]/mat-sidenav-container/mat-sidenav-content/app-home/div/app-home-container/div[1]/div[1]/div[2]/app-outstation/div/form/div[2]/div/input");
	public static By select = By.xpath("//button[contains(text(),'Select Car')]");
	public static By verify = By.xpath("//header/div[1]/div[2]/div[1]/div[1]");
	public static By home = By.xpath("//header/div[1]/div[1]/a[1]/img[1]");

}
