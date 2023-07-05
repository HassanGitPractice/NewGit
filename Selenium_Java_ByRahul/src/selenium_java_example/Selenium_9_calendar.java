//video-62 and 63
package selenium_java_example;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Selenium_9_calendar 
{

	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\mohammadh\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.spicejet.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds('5'));
		
		driver.findElement(By.cssSelector("div[data-testid='to-testID-origin']")).click();  // used to click on form tab
		
		driver.findElement(By.xpath("//div[contains(text(),'LKO')]")).click(); // to select starting point
		
		driver.findElement(By.xpath("//div[text()='HYD']")).click();
		//driver.findElement(By.xpath("(//div[@class='css-1dbjc4n r-1awozwy r-18u37iz r-1wtj0ep'])[3]")).click();  -> to click on calendar but in this case after selecting the start and date calender will get click autometically
		                              
		Thread.sleep(100);                          //(//div[@class='css-76zvg2 r-jwli3a r-ubezar r-16dba41'])[1]
		driver.findElement(By.xpath("(//div[@data-testid='undefined-calendar-day-17'])[1]")).click(); //-> for customize  date selection
		Thread.sleep(10);
		
		driver.findElement(By.xpath("(//div[@data-testid='undefined-calendar-day-15'])[2]")).click(); // -> for customize date selection
		
		System.out.println(driver.findElement(By.xpath("//div[text()='Return Date']")).getAttribute("style")); // print style value before click 
		driver.findElement(By.xpath("(//div[@class='css-1dbjc4n r-zso239'])[2]")).click(); //-> to click on Round trip
		System.out.println(driver.findElement(By.xpath("//div[text()='Return Date']")).getAttribute("style"));  // print style value after click
		
		if(driver.findElement(By.xpath("//div[text()='Return Date']")).getAttribute("style").contains("1"))
		{
			System.out.println("Return date is Enable");
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
		//Thread.sleep(100);
		//driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-1awozwy r-16ru68a r-y47klf r-1loqt21 r-eu3ka r-1otgn73 r-1aockid']")).click();
		//driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-1awozwy r-16ru68a r-y47klf r-1loqt21 r-eu3ka r-1otgn73 r-1aockid']")).click();   // //div[@class='css-76zvg2 r-jwli3a r-ubezar r-16dba41'] -> for customize date selection
		
		
	}

}