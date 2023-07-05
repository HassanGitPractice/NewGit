//video-64
package selenium_java_example;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Selenium_10_E2E {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\mohammadh\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
		
		driver.get("https://www.spicejet.com");
		driver.manage().window().maximize();
		
		//Thread.sleep(1000);
		driver.findElement(By.xpath("//div[text()='From']")).click(); // click on From tab
		
		driver.findElement(By.xpath("//div[text()='Kishangarh Airport']")).click(); // to click on started city
		//Thread.sleep(500);
		driver.findElement(By.xpath("//div[text()='Chennai International Airport']")).click(); //to click on destination city
		
		driver.findElement(By.xpath("(//div[@data-testid='undefined-calendar-day-29'])[1]")).click(); // to select the date from calendar
		
		if(driver.findElement(By.xpath("//div[@data-testid='return-date-dropdown-label-test-id']")).getAttribute("style").contains("1")) //to verify that return date is disable
		{
			System.out.println("Return date is Enable");
			Assert.assertTrue(false);
		}
		else
		{
			Assert.assertTrue(true);
			System.out.println("Return date is disable");
		}
		driver.findElement(By.xpath("//div[@data-testid='home-page-travellers']")).click();  // to click on adult tab
		
		for(int i=1; i<=4; i++)  // to click on Adult button 4 time
		{
		driver.findElement(By.xpath("//div[@data-testid='Adult-testID-plus-one-cta']")).click();
		}
		
		driver.findElement(By.xpath("//div[@data-testid='home-page-travellers']")).click();  // to click on adult tab
		
		//Thread.sleep(1000);
		Assert.assertEquals(driver.findElement(By.xpath("//div[text()='5 Adults']")).getText(),"5 Adults");
		
		driver.findElement(By.xpath("(//div[@style='margin-right: 6px;'])[1]")).click(); // to select family and friend 
		
		
		driver.findElement(By.xpath("//div[@data-testid='home-page-flight-cta']")).click(); // to click on search button
		
		
		Thread.sleep(2000);  //Note :- A separate page popup that's why implicit wait wait is not working for it
		//Explicit wait
		//WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
	    //w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='css-1dbjc4n r-zso239'])[2]")));
		driver.findElement(By.xpath("(//div[@class='css-1dbjc4n r-zso239'])[2]")).click();
		
		//Thread.sleep(1000);
		//w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='css-1dbjc4n r-1awozwy r-z2wwpe r-1loqt21 r-18u37iz r-1777fci r-d9fdf6 r-1w50u8q r-ah5dr5 r-1otgn73']")));
		driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-1awozwy r-z2wwpe r-1loqt21 r-18u37iz r-1777fci r-d9fdf6 r-1w50u8q r-ah5dr5 r-1otgn73']")).click();
		
	}

}
