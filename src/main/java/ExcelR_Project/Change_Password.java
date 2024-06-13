package ExcelR_Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Change_Password {

WebDriver driver;
	
	public Change_Password(WebDriver driver) 
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
		By ChangePass = By.xpath("//*[@id=\"maincontent\"]/div[2]/div[1]/div[3]/div[2]/div/div[2]/a[2]");
		By CurrentPass = By.xpath("//input[@id='current-password']");
		By NewPass = By.xpath("//input[@id='password']");
		By ConfirmNewPass = By.xpath("//input[@id='password-confirmation']");
		By SaveBtn = By.xpath("//button[@class='action save primary']");
		
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
		public void clickOnChnagePassword()
		{
			driver.findElement(ChangePass).click();
		}
		public void enterCurrentPass(String cpw)
		{
			driver.findElement(CurrentPass).sendKeys(cpw);
		}
		public void enterNewPass(String npw)
		{
			driver.findElement(NewPass).sendKeys(npw);
		}
		public void enterConfirmNewPass(String cnpw)
		{
			driver.findElement(ConfirmNewPass).sendKeys(cnpw);
		}
		public void clickOnSaveBtn()
		{
			driver.findElement(SaveBtn).click();
		}


	
}
