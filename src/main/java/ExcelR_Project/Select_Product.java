package ExcelR_Project;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class Select_Product {
	
	@Test
	public void tc() throws Exception {
	System.setProperty("webdriver.chrome.driver","./Driverfiles/chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.navigate().to("https://magento.softwaretestingboard.com/");
	driver.findElement(By.xpath("//*[@id=\"search\"]")).sendKeys("jacket");
	//using robot class
	Robot r = new Robot();
	r.keyPress(KeyEvent.VK_ENTER);
	r.keyRelease(KeyEvent.VK_ENTER);
	System.out.println("press enter key");
	Thread.sleep(3000);
	
	//scroll to view product
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("window.scroll(10,400)");
	Thread.sleep(3000);
	
	driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div[1]/div[2]/div[2]/ol/li[2]/div/a/span/span/img")).click();
	System.out.println("select the product");
	
	
	driver.close();

	}

}
