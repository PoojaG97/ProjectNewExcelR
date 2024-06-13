package ExcelR_Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Verify_Page_title {
 

	public static void main(String args[])throws Exception {
		//test steps
		System.setProperty("webdriver.chrome.driver","./Driverfiles/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://magento.softwaretestingboard.com/");
		Thread.sleep(4000);
		//verify page title
		if(driver.getTitle().equals("Home Page")) {
		System.out.println("Title matched");
		}
		else {
		System.out.println("Title not matched");
		System.out.println(driver.getTitle());
		}
		
		driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/a")).click();

		if(driver.getTitle().equals("Customer Login")){
		System.out.println("Title matched");
			}
		else {
			System.out.println("Title not matched");
			System.out.println(driver.getTitle());
		}
		Thread.sleep(3000);
		driver.close();	
	}

}
