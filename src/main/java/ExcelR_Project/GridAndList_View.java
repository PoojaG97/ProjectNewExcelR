package ExcelR_Project;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class GridAndList_View {
	
	WebDriver driver;

	@Test
	public void tc() throws InterruptedException {
	System.setProperty("webdriver.chrome.driver","./Driverfiles/chromedriver.exe");
	 driver = new ChromeDriver();
	System.out.println("open chromedriver");
	driver.navigate().to("https://magento.softwaretestingboard.com/");
	System.out.println("open URL");
	
	Actions ac = new Actions(driver);
    ac.moveToElement(driver.findElement(By.linkText("Men"))).perform();
    ac.moveToElement(driver.findElement(By.linkText("Tops"))).perform();
    System.out.println("Mouseover completed");
     driver.findElement(By.partialLinkText("Jack")).click();
     System.out.println("MOUSEOVER process completed");
     Thread.sleep(3000);
     
     
     //List view
     driver.findElement(By.id("mode-list")).click();
     JavascriptExecutor js = (JavascriptExecutor)driver;
     js.executeScript("window.scroll(0,450)");
     System.out.println("List view");
     Thread.sleep(3000);
     js.executeScript("window.scroll(0,-450)");
     
     //Grid view
     driver.findElement(By.id("mode-grid")).click();
     System.out.println("Grid view");
     driver.close();

}


}
