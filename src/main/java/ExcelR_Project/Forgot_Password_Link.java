package ExcelR_Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Forgot_Password_Link {
	
	public static void main(String args[]) throws InterruptedException{
		System.setProperty("webdriver.chrome.driver","./Driverfiles/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://magento.softwaretestingboard.com/");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//li[@class='authorization-link']")).click();
		driver.findElement(By.xpath("//a[@class='action remind']")).click();
		System.out.println("Click on forgot password link");
		driver.findElement(By.xpath("//input[@type='email'][@name='email']")).sendKeys("pooja12girpunje@gmail.com");
		driver.findElement(By.xpath("//button[@type='submit'][@class='action submit primary']")).click();
		System.out.println("password reset link should be send to email");
	}


}
