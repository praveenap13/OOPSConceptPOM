package com.mytests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.pages.BasePage;
import com.pages.Page;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	WebDriver driver;
	public Page page;
	@BeforeMethod
	@Parameters("browser")
	public void setUpTest(String browser) {
		if(browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}else if(browser.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver=new FirefoxDriver();
		}else {
			System.out.println("no driver is defined in xml");
		}
		driver.get("https://ijmeet.com/login");
		try {
		Thread.sleep(6000);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		page=new BasePage(driver);
	}
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
}
