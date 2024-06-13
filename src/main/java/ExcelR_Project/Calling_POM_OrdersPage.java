package ExcelR_Project;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Calling_POM_OrdersPage {
	

	public static void main(String[]args) throws Exception {
		System.setProperty("webdriver.chrome.driver","./Driverfiles/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		Thread.sleep(3000);
		MyOrders_using_POM lg= new MyOrders_using_POM(driver);
		lg.url();
		lg.signInLink();
		lg.enterEmail("pooja12girpunje@gmail.com");
		lg.enterPassword("Pooja@1234");
		lg.clickOnSignInBtn();
		Thread.sleep(4000);
		driver.navigate().refresh();
		lg.clickOnProfileArrow();
		lg.clickOnMyAccount();
		lg.clickOnMyOrders();
	System.out.println("display My Orders page");
	driver.close();
	}


}
