package POMPack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KiteLoginPage 
{
 private WebDriver driver;
	

	@FindBy (xpath = "//input[@id='userid']")
	private WebElement UserId;
	
	@FindBy (xpath= "//input[@id='password']")
	private WebElement Password;
	
	@FindBy(xpath= "//button[@type='submit']")
	private WebElement SubmitBtn;
	
	@FindBy(xpath="//input[@id='pin']")
	private WebElement PIN;
	
	@FindBy(xpath="//button[text()='Continue ']")
	private WebElement CtnBtn;
	
	@FindBy(xpath="//div//a[@class='dropdown-label']")
	private WebElement UserIdLogo;
	
	@FindBy (xpath="//ul//a[text()=' Logout']")
	private WebElement LogoutBtn;
	
	
	public KiteLoginPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void SetKiteLoginPageUserId() 
	{
		UserId.sendKeys("ZEE923");
	}
	public void SetKiteLoginPagePassword()
	{
		Password.sendKeys("tubelite0");
	}
	public void ClickKiteLoginPageSubmitBtn() 
	{
		SubmitBtn.click();
	}
	public void SetKiteLoginPagePIN() 
	{
		PIN.sendKeys("200000");
	}
	public void ClickKiteLoginPageContinueBtn() 
	{
		CtnBtn.click();
	}
	public void ClickKiteLoginPageUserIdLogo()
	{
		Actions act = new Actions(driver);
		act.moveToElement(UserIdLogo).click().perform();
		//UserIdLogo.click();
	}
	public void ClickKiteLoginPageLogoutBtn() 
	{
		Actions act = new Actions(driver);
		act.moveToElement(LogoutBtn).click().perform();
	}
	

}
