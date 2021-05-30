package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Page {
WebDriver driver;
WebDriverWait wait;
public Page(WebDriver driver) {
	this.driver=driver;
	this.wait=new WebDriverWait(this.driver,15);
}

//abstract methods 
public abstract String getPageTitle();
public abstract String getPageHeader(By locator);

public abstract WebElement getElement(By locator);
public abstract void waitForElementPresent(By locator);
public abstract void waitForpageTitle(String title);

public abstract String getPageUrl();
public <TPage extends BasePage> TPage getInstance(Class<TPage> pageClass) {
	TPage a=null;;
	try {
	     a=pageClass.getDeclaredConstructor(WebDriver.class).newInstance(this.driver);
     	return a;
	}catch(Exception e) {
		e.printStackTrace();
	}
	return a;
	
}

}
