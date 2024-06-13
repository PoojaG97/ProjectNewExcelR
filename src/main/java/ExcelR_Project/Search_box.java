package ExcelR_Project;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class Search_box {
	
	@Test
	public void tc() throws Exception {
	System.setProperty("webdriver.chrome.driver","./Driverfiles/chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.navigate().to("https://magento.softwaretestingboard.com/");
	driver.findElement(By.xpath("//*[@id=\"search\"]")).sendKeys("Bag");
	//using robot class
	Robot r = new Robot();
	r.keyPress(KeyEvent.VK_ENTER);
	r.keyRelease(KeyEvent.VK_ENTER);
	System.out.println("press enter key");
	Thread.sleep(3000);
	driver.close();

}


}
