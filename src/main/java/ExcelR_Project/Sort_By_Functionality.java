package ExcelR_Project;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;



public class Sort_By_Functionality {
	

	public static void main(String args[]) throws Exception {
		
		System.setProperty("webdriver.chrome.driver","./Driverfiles/chromedriver.exe");
		WebDriver driver = new ChromeDriver();	
		driver.navigate().to("https://magento.softwaretestingboard.com/");
		
		driver.findElement(By.xpath("//*[@id=\"search\"]")).sendKeys("Bag");
		//using robot class
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		System.out.println("press enter key");
		
		Select st = new Select (driver.findElement(By.xpath("//select[@id='sorter']")));
		st.selectByVisibleText("Price");
		System.out.println("sort by price");
		driver.close();
		
	}


}
