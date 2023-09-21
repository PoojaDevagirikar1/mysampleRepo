package com.application.testscenarios;

import org.openqa.selenium.chrome.ChromeDriver;



import io.qameta.allure.Step;

public class HomePageScenarios {
	
	

	ChromeDriver driver ;
	
	@Step("Verify Login")
	public String s_VerifyCustomerLogin() {
		System.out.println("Scenario: Going to execute s_VerifyCustomerLogin");
		
		
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver = new ChromeDriver();    	
		driver.get("https://www.volvocars.com/intl/v/safety/highlights");	          
		driver.manage().window().maximize(); 
		return null;
		
		
	}
	
	@Step("Verify Logout")
	public String s_VerifyCustomerLogout() {
		System.out.println("Scenario: Going to execute s_VerifyCustomerLogin");
		
		driver.quit();
		
		return null;
		
		
	}

	
}
