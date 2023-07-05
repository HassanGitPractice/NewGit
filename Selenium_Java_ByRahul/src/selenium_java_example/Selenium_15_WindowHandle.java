//Video 88
package selenium_java_example;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium_15_WindowHandle {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\mohammadh\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.get("https://rahulshettyacademy.com/loginpagePractise/#");
		driver.manage().window().maximize();
		driver.findElement(By.cssSelector("a[class='blinkingText']")).click();

		Set<String> windowsIDs = driver.getWindowHandles();
		java.util.Iterator<String> it = windowsIDs.iterator();
		String parentID = it.next();
		String childID = it.next();

		driver.switchTo().window(childID);
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.cssSelector("p[class='im-para red']")).getText());

		String mailID = driver.findElement(By.cssSelector("p[class='im-para red']")).getText().split("at")[1].trim()
				.split(" ")[0];

		driver.switchTo().window(parentID);

		driver.findElement(By.cssSelector("input[id='username']")).sendKeys(mailID);

	}

}
