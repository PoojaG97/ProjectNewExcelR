package ExcelR_Project;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



public class Dropdown {
	
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
     driver.findElement(By.xpath("//div[@id='narrow-by-list']/div[1]")).click();
     /*Select st = new Select(driver.findElement(By.xpath("//*[@id=\"narrow-by-list\"]/div[1]/div[1]")));
     st.selectByVisibleText("Sweatshirt");*/
     driver.findElement(By.xpath("//*[@id=\"narrow-by-list\"]/div[1]/div[2]/ol/li[2]/a")).click();
     System.out.println("select style");
     driver.findElement(By.xpath("//div[@id='narrow-by-list']/div[1]")).click();
     driver.findElement(By.xpath("//*[@id=\"narrow-by-list\"]/div[1]/div[2]/div/div/a[1]/div")).click();
     System.out.println("select size");
     driver.findElement(By.xpath("//div[@id='narrow-by-list']/div[2]")).click();
     driver.findElement(By.xpath("//*[@id=\"narrow-by-list\"]/div[2]/div[2]/div/div/a[2]/div")).click();
     System.out.println("select color");
     driver.close();
}


}
