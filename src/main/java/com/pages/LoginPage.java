package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage{

	private By emailId=By.id("email");
	private By password=By.id("password");
	private By loginButton=By.cssSelector("button[type='submit']");
	
	public LoginPage(WebDriver driver){
		super(driver);
	}
	public WebElement getEmailId() {
		return getElement(emailId);
	}

	public WebElement  getPassword() {
		return getElement(password);
	}
	public WebElement getLoginButton() {
		return getElement(loginButton);
	}
	public String getLoginPageTitle() {
		return getPageTitle();
	}
public HomePage doLogin(String username,String pwd) {
	getEmailId().sendKeys(username);
	getPassword().sendKeys(pwd);
	getLoginButton().click();
	return getInstance(HomePage.class);
}
public HomePage doLogin() {
	getEmailId().sendKeys("");
	getPassword().sendKeys("");
	getLoginButton().click();
	return getInstance(HomePage.class);
}
}
