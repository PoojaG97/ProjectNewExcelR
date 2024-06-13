package ExcelR_Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Add_New_Address {
	
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

	@DataProvider(name="data")
	public Object[][] getData()
	{
		return new Object[][] {{"pooja12girpunje@gmail.com","Pooja@1234"}};
		
	}
	
	@Test(dataProvider = "data")
	public void tc(String email,String password) throws Exception {
		
	driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys(email);
	driver.findElement(By.xpath("//*[@id=\"pass\"]")).sendKeys(password);
	System.out.println("entered email & password");
	driver.findElement(By.id("send2")).click();
	System.out.println("click on sign in button");
	Thread.sleep(3000);
	driver.navigate().refresh();

}

@AfterTest
public void tc02() {
	driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/span/button")).click();
	driver.findElement(By.xpath("//a[text()='My Account']")).click();
	System.out.println("click on my accout");
	driver.findElement(By.xpath("//a[text()='Address Book']")).click();
	driver.findElement(By.xpath("//button[@class='action primary add']")).click();
	driver.findElement(By.xpath("//input[@id='telephone']")).sendKeys("7744013001");
	driver.findElement(By.xpath("//input[@id='street_1']")).sendKeys("Ashok nagar");
	
	driver.findElement(By.xpath("//input[@id='zip']")).sendKeys("445001");
	Select st1= new Select(driver.findElement(By.xpath("//select[@id='country']")));
	st1.selectByValue("IN");
	
	driver.findElement(By.xpath("//input[@id='city']")).sendKeys("yavatmal");
	Select st = new Select(driver.findElement(By.xpath("//select[@id='region_id']")));
	st.selectByValue("553");
	
	driver.findElement(By.xpath("//button[@class='action save primary']")).click();
	System.out.println("Adding a new address");
	driver.close();

			}


}
