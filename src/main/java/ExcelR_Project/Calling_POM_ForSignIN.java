package ExcelR_Project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class Calling_POM_ForSignIN {

	public static void main(String[]args) throws Exception {
		System.setProperty("webdriver.chrome.driver","./Driverfiles/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		Sign_In_Using_POM lg= new Sign_In_Using_POM(driver);
		lg.url();
		lg.signInLink();
		lg.enterEmail("pooja12girpunje@gmail.com");
		lg.enterPassword("Pooja@1234");
		lg.clickOnSignInBtn();
		driver.close();
	}


	
}
