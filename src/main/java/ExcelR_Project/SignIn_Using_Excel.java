package ExcelR_Project;


import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class SignIn_Using_Excel {

	public static void main(String[]args) throws Exception {
		System.setProperty("webdriver.chrome.driver","./Driverfiles/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://magento.softwaretestingboard.com/");
		System.out.println("open url");
		driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/a")).click();
		System.out.println("click on sign IN");
		
		String filePath = "C:\\New eclipse\\ExcelR_Project\\ExcelData\\ExcelData.xlsx";
		FileInputStream fis = new FileInputStream(filePath);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("Data");
		
		int rows = sheet.getLastRowNum();
		System.out.println("Total no  of rows:" + rows);
		
		for(int r=1;r<=rows;r++)
		{
			XSSFRow row = sheet.getRow(r);
			XSSFCell email = row.getCell(0);
			XSSFCell pass = row.getCell(1);
		
			driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys(email.toString());
			driver.findElement(By.xpath("//*[@id=\"pass\"]")).sendKeys(pass.toString());
			System.out.println("entered email & password");
			driver.findElement(By.id("send2")).click();
			System.out.println("click on sign in button");		
		}
		fis.close();
		System.out.println("sign in successful");
	
	}
	

}
