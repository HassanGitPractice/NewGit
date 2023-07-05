package selenium_java_example;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class Selenium_12_ImplicitWait {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver","C:\\Users\\mohammadh\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		driver.manage().window().maximize();

		driver.findElement(By.xpath("(//button[text()='ADD TO CART'])[4]")).click();
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
		driver.findElement(By.cssSelector("input[placeholder='Enter promo code']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("button[class='promoBtn']")).click();
		System.out.println(driver.findElement(By.cssSelector("span[class='promoInfo']")).getText());

	}

}
