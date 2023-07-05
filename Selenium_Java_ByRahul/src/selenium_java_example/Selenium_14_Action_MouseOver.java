package selenium_java_example;



import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Selenium_14_Action_MouseOver {

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\mohammadh\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		
		Actions a = new Actions(driver);
		//a.moveToElement(driver.findElement(By.cssSelector("a[id='nav-link-accountList']"))).build().perform(); // here build mean step is ready to execute but to execute we should use perform
		//use for mouseover
		WebElement move = driver.findElement(By.cssSelector("a[id='nav-link-accountList']")) ;
		a.moveToElement(move).build().perform();
		
		//use to send key in capital letter
		a.moveToElement(driver.findElement(By.cssSelector("input[id='twotabsearchtextbox']"))).click().keyDown(Keys.SHIFT).sendKeys("hello").build().perform();
		
	}

}
