package BasePack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Pojo 
{
	public static WebDriver openChromeBrowser() 
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Chrome Drivers\\Version97\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		return driver;
	}
	public static WebDriver openFirefoxBrowser() 
	{
		System.setProperty("webdriver.gecko.driver", "D:\\Gecko Drivers\\geckodriver.exe");
		WebDriver driver= new FirefoxDriver();
		return driver;
	}
}
