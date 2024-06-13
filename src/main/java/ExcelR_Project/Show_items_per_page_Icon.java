package ExcelR_Project;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class Show_items_per_page_Icon {
	

WebDriver driver;
	
	@BeforeTest
	public void startUp() {
		System.setProperty("webdriver.chrome.driver","./Driverfiles/chromedriver.exe");
		 driver = new ChromeDriver();
		driver.get("https://magento.softwaretestingboard.com/");
		System.out.println("open url");
		driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/a")).click();
		System.out.println("click on sign IN");
	}
//using data provider
	@DataProvider(name="data")
	public Object[][] getData()
	{
		return new Object[][] {{"pooja12girpunje@gmail.com","Pooja@1234"}};
		
	}
	
	@Test(dataProvider = "data")
	public void tc(String email,String password) throws IOException {
		
	driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys(email);
	driver.findElement(By.xpath("//*[@id=\"pass\"]")).sendKeys(password);
	System.out.println("entered email & password");
	driver.findElement(By.id("send2")).click();
	System.out.println("click on sign in button");

}


@AfterTest
public void tc02() throws Exception {
	 Actions ac = new Actions(driver);
	    ac.moveToElement(driver.findElement(By.linkText("Women"))).perform();
	    ac.moveToElement(driver.findElement(By.linkText("Tops"))).perform();
	    System.out.println("Mouseover completed");
	     driver.findElement(By.partialLinkText("Bras")).click();
	     System.out.println("MOUSEOVER process completed");
	     Thread.sleep(3000);
	//scroll to view product
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("window.scroll(10,1500)");
	driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div[1]/div[4]/div[3]/div")).click();
	Robot r = new Robot();
	r.keyPress(KeyEvent.VK_DOWN);
	r.keyRelease(KeyEvent.VK_DOWN);
	r.keyPress(KeyEvent.VK_ENTER);
	r.keyRelease(KeyEvent.VK_ENTER);
	System.out.println("24 product should be shown in one page");
	driver.close();

}

	
}
