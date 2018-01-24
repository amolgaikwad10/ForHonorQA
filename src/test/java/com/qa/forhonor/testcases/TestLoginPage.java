package com.qa.forhonor.testcases;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.qa.forhonor.base.BaseClass;
import com.qa.forhonor.pages.HomePage;
import com.qa.forhonor.pages.LoginPage;

public class TestLoginPage extends BaseClass{
	
	LoginPage loginPage;
	HomePage homepage;
	
	public TestLoginPage() {
		super();
	}
	
	@BeforeTest
	public void setup() {
		BaseClass.initialize();
		loginPage=new LoginPage();
	}
	
	@Test
	public void testPagetitle() {
		String result=loginPage.pagetitle();
		System.out.println(result);
	}
	
	@Test void testLogin() {
		homepage=loginPage.log_in(prop.getProperty("username"), prop.getProperty("password"));
	}
}
