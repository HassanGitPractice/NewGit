package selenium_java_example;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Selenium_1_Locator
{

	public static void main(String[] args) throws InterruptedException 
	{
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\mohammadh\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver =new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		String name ="Hassan";
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		
		//Find Element by css selector with ID values.
				driver.findElement(By.cssSelector("#inputUsername")).sendKeys(name);    //   tagname#id value ->OR #id value -> #inputUsername
				  
				//Find Element by CSS Selector with parsing  -> this is used when attribute values are keep changing.  (video-40)
				driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");
				
				//Find element by ID
				driver.findElement(By.id("chkboxOne")).click();
				driver.findElement(By.id("chkboxTwo")).click();
				
				//Find Element by xpath with parsing / regular Exppression . -> it is complex as compared to css parsing.
				//driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();        //  Regular expression  ->  	//button[contains(@class,'submit')] 
				driver.findElement(By.xpath("//button[@type='submit']")).click(); //by x-path
				
				//Thread.sleep(2000);
				
				System.out.println(driver.findElement(By.xpath("//p[text()='You are successfully logged in.']")).getText());  //-> o/p on console -> 'You are successfully logged in.'  but by this method we need to manually do the comparison from console between actual and expected result but we can do the comparison automatically with the help of Test-ng equal assertion
				
				//Testing equal assertion (Video-42). Note:- due to old version of java assert is not working need to update the java
				//Assert.assertEquals(driver.findElement(By.tagName("p")).getText(),"You are successfully logged in.");   // (actual,expected) -> This will compare actual result with expected and if it is true then it pass and if not match hen we will get error. 
				
				// Find Element to display the greeting(Ex- Hello Hassan) by CSS selector with traversing from parent to child
				System.out.println(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText());  // Css-> Parenttagname childtagname
				//Assert.assertEquals(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText(), "Hello"+name+"," ); //To run this line need to apdate java
				
				
				//Find Element by X-Path based on Text 
				//driver.findElement(By.xpath("//button[text() ='Log Out']")).click();  // -> //tagname[text() ='Text Name']
				
	}

}
