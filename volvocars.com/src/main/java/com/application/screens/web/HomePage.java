package com.application.screens.web;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;




public class HomePage {
	
	WebDriver pageDriver;

	

	@FindBy(xpath="//label[@id='nameSALESPERSON']//preceding-sibling::img")
	public WebElement salesPersonImg;


	public String viewCartButton="//a[contains(text(),'View Cart')]";

	
	public HomePage(WebDriver driver) {
		System.out.println("Going to initialize the page objects");
		pageDriver = driver;
		System.out.println("Initialized the page objects");
	}



}
