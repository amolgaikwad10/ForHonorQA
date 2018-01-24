package com.qa.forhonor.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.forhonor.base.BaseClass;

public class LoginPage extends BaseClass {
	
	@FindBy(className="e2e-iframe-trusted-src")
	WebElement iframe;

	@FindBy(id="AuthEmail")
	WebElement email_id;
	
	@FindBy(id="AuthPassword")
	WebElement password;// Email ID 
	
	@FindBy(id="LogInButton")
	WebElement login_button;

	public LoginPage(){
		PageFactory.initElements(driver,this);
	}
	
	public String pagetitle() {
		return driver.getTitle();	
	}

	public HomePage log_in(String uname, String pass) {
		driver.switchTo().frame(iframe);
		email_id.sendKeys(uname);
		password.sendKeys(pass);
		login_button.click();
		driver.switchTo().defaultContent();
		return new HomePage();
		
	}
}