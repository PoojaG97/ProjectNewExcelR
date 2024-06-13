package ExcelR_Project;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class Arrow_of_SortBy_AscendingDescending {
	
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
	
//perform mouseover
    Actions ac = new Actions(driver);
    ac.moveToElement(driver.findElement(By.linkText("Women"))).perform();
    ac.moveToElement(driver.findElement(By.linkText("Tops"))).perform();
    System.out.println("Mouseover completed");
     driver.findElement(By.partialLinkText("Hood")).click();
     System.out.println("MOUSEOVER process completed");
     Thread.sleep(3000);
     
     Select st = new Select (driver.findElement(By.xpath("//select[@id='sorter']")));
		st.selectByVisibleText("Price");
		System.out.println("sort by price");
	//set Arrow as descending
		driver.findElement(By.xpath("//a[@class='action sorter-action sort-asc']")).click();
		System.out.println(" price of product is descending");
		Thread.sleep(8000);
	//Make arrow as ascending
		driver.findElement(By.xpath("//a[@class='action sorter-action sort-desc']")).click();
		System.out.println("Price of product is now ascending");
		driver.close();
     
}}



