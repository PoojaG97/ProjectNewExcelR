package ExcelR_Project;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Calling_POM_ChangePassword {
	

	public static void main(String[]args) throws Exception {
		System.setProperty("webdriver.chrome.driver","./Driverfiles/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		Change_Password lg= new Change_Password(driver);
		lg.url();
		lg.signInLink();
		lg.enterEmail("pooja12girpunje@gmail.com");
		lg.enterPassword("Pooja@1234");
		lg.clickOnSignInBtn();
		Thread.sleep(4000);
		driver.navigate().refresh();
		lg.clickOnProfileArrow();
		lg.clickOnMyAccount();
		lg.clickOnChnagePassword();
		lg.enterCurrentPass("Pooja@1234");
		lg.enterNewPass("Pooja@1234");
		lg.enterConfirmNewPass("Pooja@1234");
		lg.clickOnSaveBtn();
	
	System.out.println("password got changed");
	driver.close();
	}
	


}
