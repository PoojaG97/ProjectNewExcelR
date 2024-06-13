package ExcelR_Project;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;

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



public class Compare_product {
	
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
public void tc02() throws Exception  {
	driver.findElement(By.xpath("//*[@id=\"search\"]")).sendKeys("Bag");
	//using robot class
	Robot r = new Robot();
	r.keyPress(KeyEvent.VK_ENTER);
	r.keyRelease(KeyEvent.VK_ENTER);
	System.out.println("press enter key");
	Thread.sleep(3000);
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("window.scroll(10,500)");
	driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div[1]/div[2]/div[2]/ol/li[1]/div/a/span/span/img")).click();
	driver.findElement(By.xpath("//a[@class='action tocompare']")).click();
	System.out.println("Add to compare");
	driver.navigate().back();
	System.out.println("back");
	driver.navigate().back();

	driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div[1]/div[2]/div[2]/ol/li[3]/div/a/span/span/img")).click();
	driver.findElement(By.xpath("//a[@class='action tocompare']")).click();
	System.out.println("2nd product add to compare");

	WebDriverWait wait =  new WebDriverWait(driver,40);
	WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@class='action compare']")));
	Thread.sleep(2000);
	element.click();
	
	//driver.findElement(By.xpath("//a[@class='action compare']")).click();
	System.out.println("compare product page get open");
	
	driver.close();
}


}
