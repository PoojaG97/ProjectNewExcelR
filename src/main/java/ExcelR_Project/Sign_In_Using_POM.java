package ExcelR_Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class Sign_In_Using_POM {
	
WebDriver driver;
	
	public Sign_In_Using_POM(WebDriver driver) 
	{
		this.driver=driver;
	}

	
		//Repository
		By SignInLink = By.xpath("//li[@class='authorization-link']");
		By email = By.xpath("//input[@id='email']");
		By pass = By.xpath("//*[@id=\"pass\"]");
		By SignInBtn = By.id("send2");
		
		public void url() throws InterruptedException
		{
			driver.get("https://magento.softwaretestingboard.com/");
			Thread.sleep(3000);
		}
		
		public void signInLink()
		{
			driver.findElement(SignInLink).click();
		}
		
		public void enterEmail(String em)
		{
			driver.findElement(email).sendKeys(em);
		}
		
		public void enterPassword(String pw)
		{
			driver.findElement(pass).sendKeys(pw);
		}
		
		public void clickOnSignInBtn()
		{
			driver.findElement(SignInBtn).click();
		}


}
