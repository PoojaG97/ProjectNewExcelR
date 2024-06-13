package ExcelR_Project;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Orders_And_Return_Link {

	WebDriver driver;

	@Test
	public void tc() throws InterruptedException {
	System.setProperty("webdriver.chrome.driver","./Driverfiles/chromedriver.exe");
	 driver = new ChromeDriver();
	System.out.println("open chromedriver");
	driver.navigate().to("https://magento.softwaretestingboard.com/");
	System.out.println("open URL");
	
	driver.findElement(By.xpath("//a[text()='Orders and Returns']")).click();
	driver.findElement(By.xpath("//input[@id='oar-order-id']")).sendKeys("000005518");
	driver.findElement(By.name("oar_billing_lastname")).sendKeys("g");
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("window.scroll(0,150)");
	Select st = new Select(driver.findElement(By.name("oar_type")));
	st.selectByIndex(1);
	Thread.sleep(3000);
	driver.findElement(By.xpath("//input[@id='oar_zip']")).sendKeys("445001");
	driver.findElement(By.xpath("//button[@class='action submit primary']")).click();
	System.out.println("Order & Return page open");
	driver.close();
	
	}

	
}
