//video-67
package selenium_java_example;

import java.sql.Driver;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium_11_alertPopUp {

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\mohammadh\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@placeholder='Enter Your Name']")).click();
		driver.findElement(By.cssSelector("#name")).sendKeys("Hassan");

		// driver.findElement(By.cssSelector("input[value='Alert']")).click();
		// driver.switchTo().alert().accept();

		driver.findElement(By.cssSelector("input[value='Confirm']")).click();
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().dismiss();

	}

}