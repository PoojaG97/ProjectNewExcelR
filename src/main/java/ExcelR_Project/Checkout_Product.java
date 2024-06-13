package ExcelR_Project;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class Checkout_Product {
	
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
	driver.findElement(By.xpath("//*[@id=\"search\"]")).sendKeys("jacket");
	//using robot class
	Robot r = new Robot();
	r.keyPress(KeyEvent.VK_ENTER);
	r.keyRelease(KeyEvent.VK_ENTER);
	System.out.println("press enter key");
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	//Thread.sleep(3000);
	
	//scroll to view product
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("window.scroll(10,500)");
	
	driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div[1]/div[2]/div[2]/ol/li[2]/div/a/span/span/img")).click();
	System.out.println("select the product");
	
	js.executeScript("window.scroll(10,350)");
	
	driver.findElement(By.xpath("//div[@class='swatch-option text'][@id='option-label-size-143-item-166']")).click();
	driver.findElement(By.xpath("//*[@id=\"option-label-color-93-item-56\"]")).click();
	System.out.println("select size & color");
	
	driver.findElement(By.xpath("//button[@type='submit'][@class='action primary tocart']")).click();
	System.out.println("click on add to cart button");
	
	//checkout product
	js.executeScript("window.scroll(0,-250)");

	driver.findElement(By.xpath("//a[@class='action showcart']")).click();
	//Thread.sleep(2000);
	driver.findElement(By.xpath("//button[@id='top-cart-btn-checkout']")).click();
	System.out.println("click on checkout product");
	
	js.executeScript("window.scroll(0,550)");
	Thread.sleep(6000);

	/*driver.findElement(By.xpath("//input[@id='customer-email']")).sendKeys("pooja12girpunje@gmail.com");
	driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("pooja");
	driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("girpunje");
	driver.findElement(By.xpath("//input[@name='street[0]']")).sendKeys("ashok nagar");
	driver.findElement(By.xpath("//input[@name='city']")).sendKeys("yavatmal");*/
	driver.findElement(By.xpath("//button[@class='button action continue primary']")).click();
	System.out.println("click on next btn");
	js.executeScript("window.scroll(0,350)");
	//driver.findElement(By.xpath("//button[@class='action primary checkout']")).click();
	WebDriverWait wait =  new WebDriverWait(driver,40);
	WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"checkout-payment-method-load\"]/div/div/div[2]/div[2]/div[4]/div/button/span")));
	Thread.sleep(2000);
	element.click();
	
	System.out.println("place order");

	driver.close();
}


	


}
