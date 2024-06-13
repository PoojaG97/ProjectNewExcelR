package ExcelR_Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Create_An_Account {
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","./Driverfiles/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		System.out.println("open chromedriver");
		driver.navigate().to("https://magento.softwaretestingboard.com/");
		System.out.println("open URL");
		driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[3]/a")).click();
		System.out.println("click on create an account");
		driver.findElement(By.id("firstname")).sendKeys("pooja");
		driver.findElement(By.id("lastname")).sendKeys("Girpunje");
		System.out.println("Write name");
		driver.findElement(By.id("email_address")).sendKeys("pooja12girpunje@gmail.com");
		System.out.println("write email");
		driver.findElement(By.id("password")).sendKeys("Pooja@1234");
		driver.findElement(By.id("password-confirmation")).sendKeys("Pooja@1234");
		System.out.println("set password");
		driver.findElement(By.xpath("//*[@id=\"form-validate\"]/div/div[1]/button")).click();
		System.out.println("click on create an account button ");
		driver.close();
		
}


}
