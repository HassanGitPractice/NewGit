package selenium_java_example;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Selenium_13_ExplixitWait {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\mohammadh\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(5));  //creating object of wait class to implement explicit wait
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("(//button[text()='ADD TO CART'])[4]")).click();
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
		
		mywait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[placeholder='Enter promo code']"))); //Explicit wait
		
		driver.findElement(By.cssSelector("input[placeholder='Enter promo code']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("button[class='promoBtn']")).click();
		
		mywait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span[class='promoInfo']")));  //Ecplicit wait
		
		System.out.println(driver.findElement(By.cssSelector("span[class='promoInfo']")).getText());
		

	}

}
