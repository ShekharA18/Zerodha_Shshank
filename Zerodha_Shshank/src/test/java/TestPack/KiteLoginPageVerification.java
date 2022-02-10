package TestPack;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import BasePack.Pojo;
import POMPack.KiteLoginPage;
import TestUtilities.TestUtility;


public class KiteLoginPageVerification extends Pojo
{
	private WebDriver driver;
	private KiteLoginPage logpg;
	int testID;
	
	@BeforeTest 
	@Parameters("browser")
	public void launchBrowser(String browser) 
	{
		if(browser.equals("Chrome"))
			{
				driver = openChromeBrowser();
			}
		else 
			{
				driver = openFirefoxBrowser();
			}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://kite.zerodha.com/");
	}
	@BeforeClass
	public void createObjectOfPOMPack() 
	{
		logpg = new KiteLoginPage(driver);
	}
	@Test
	public void loginPageVerification() throws InterruptedException 
	{
		testID=100;
		logpg.SetKiteLoginPageUserId();
		logpg.SetKiteLoginPagePassword();
		logpg.ClickKiteLoginPageSubmitBtn();
		Thread.sleep(3000);
		logpg.SetKiteLoginPagePIN();
		logpg.ClickKiteLoginPageContinueBtn();
		String url= driver.getCurrentUrl();
		System.out.println(url);
		Assert.assertEquals(url,"https://kite.zerodha.com/");
	}
	@AfterMethod
	public void logoutKiteApplication(ITestResult result) throws InterruptedException, IOException 
	{
		if(ITestResult.FAILURE== result.getStatus()) 
		{
			TestUtility.takeScreenshot(driver, testID);	
		}
		Thread.sleep(3000);
		logpg.ClickKiteLoginPageUserIdLogo();
		logpg.ClickKiteLoginPageLogoutBtn();
	}
	@AfterClass
	public void clearPOMObjects() 
	{
		logpg= null;
	}
	@AfterTest
	public void closeBrowser() 
	{
		driver.close();
		driver=null;
		System.gc();
		
	}

}
