package com.mytests;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.pages.HomePage;
import com.pages.LoginPage;

public class LoginTest extends BaseTest{

	@Test
	public void verifyLoginPageUrl() {
		String loginUrl=page.getInstance(LoginPage.class).getPageUrl();
		System.out.println(loginUrl);
		Assert.assertEquals(loginUrl, "https://ijmeet.com/login");
	}
	@Test
	public void doLogin() {
		HomePage homepage=page.getInstance(LoginPage.class).doLogin("pravina.parab@gmail.com", "ijMeet@123");
	String HomepageUrl=homepage.getPageUrl();
	Assert.assertEquals(HomepageUrl, "https://ijmeet.com/dashboard");
	
	}
}
