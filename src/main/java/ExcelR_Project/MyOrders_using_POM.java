package ExcelR_Project;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;


public class MyOrders_using_POM {
	
WebDriver driver;
	
	public MyOrders_using_POM(WebDriver driver) 
	{
		this.driver=driver;
	}

	
		//Repository
		By SignInLink = By.xpath("//li[@class='authorization-link']");
		By email = By.xpath("//input[@id='email']");
		By pass = By.xpath("//*[@id=\"pass\"]");
		By SignInBtn = By.id("send2");
		By Profile = By.xpath("//button[@class='action switch']");
		By MyAccount = By.xpath("//a[text()='My Account']");
		By MyOrders = By.xpath("//a[text()='My Orders']");
		
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
		
		public void clickOnProfileArrow()
		{
			driver.findElement(Profile).click();
		}
		
		public void clickOnMyAccount()
		{
			driver.findElement(MyAccount).click();
		}
		public void clickOnMyOrders()
		{
			driver.findElement(MyOrders).click();
		}


}
