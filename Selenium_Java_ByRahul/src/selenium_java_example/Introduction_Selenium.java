package selenium_java_example;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Introduction_Selenium {
	
	public static void main(String[] args) throws InterruptedException
	{
		//below two step will launch the browser . Note:- Due to resent update in Selenium we can Launch the browser by using 2nd line only, Ist line work is done by jars internally but it is recommended to use both the line for now.
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\mohammadh\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver =new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));  // Implicit wait()->It declare globally, It is used when we want some thing to show.  to handle error at line 35 
		//driver.get("https://rahulshettyacademy.com");	// it will open the site 
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		System.out.println(driver.getTitle());	// it will return the title of web site 
		
		System.out.println(driver.getCurrentUrl()); // it will return the url of application
		
		driver.findElement(By.id("inputUsername")).sendKeys("rahul");
		
		driver.findElement(By.name("inputPassword")).sendKeys("123456");
		
		driver.findElement(By.className("signInBtn")).click();
		
		//Note :- In single page application-> Element itersepted mean sliding is changing but URL is not changing then error can occur during selenium script running  bec selenium script is running faster than the sliding so to avoid error use wait(). it will pause the selenium script for given time period. watch video 40.
				//Thread.sleep(1000); //Explicit wait() -> used to get in a stable state.  to handel error at line 60
				
				//The below ist line code will generate the error message bec selenium is very fast and script get run before the error message get display, so we should use wait()(or synchronize the code) so it get enough time to generate the message. 
				System.out.println(driver.findElement(By.cssSelector("P.error")).getText()); // Using CSS selector reaching to the error message and printing the error message
				
			//Use LinkText for anchor tag<a> </a>
				driver.findElement(By.linkText("Forgot your password?")).click();
				                     
				
				driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Hassan"); 	// -> //Tagname[@attribute=’value’]
																									// -> //input[@placeholder=’Name’]

				
				//Finding element with the help of X-path & index and it is very useful when we have common attribute value.                    
				driver.findElement(By.xpath("//input[@type='text'][2]")).sendKeys("xyz@123.com");     // -> //Tagname[@attribute=’value’][index]
				
				
				//Finding element with the help of CSS Selector & index and it is very useful when we have common attribute value.
				driver.findElement(By.cssSelector("input[type='text']:nth-child(4)")).sendKeys("9452678945");    // ->  Tagname[attribute=’value’]:nth-child(index)
				driver.findElement(By.cssSelector("input[type='text']:nth-child(4)")).clear();
				
				
				//Find the element using X-path index with the help of tag name only mean it will be use when no attributes are available on HTML.
				
				driver.findElement(By.xpath("//form/input[3]")).sendKeys("7860199947");    // ->  //parentTagname/childTagname[index]
				System.out.println(driver.findElement(By.xpath("//form/h2")).getText());	// -> 	//parentTagname/childTagname   ,o/p-> Forgot password
				
				//css selector with class attribute
				driver.findElement(By.cssSelector(".reset-pwd-btn")).click(); // Class name -> tagname.classname ->  Button..reset-pwd-btn ->OR  .error
				
				//Find the element using CSS Selector with the help of tag name only mean it will be use when no attributes are available on HTML.
				System.out.println(driver.findElement(By.cssSelector("form p")).getText());    // o/p-> Please use temporary password 'rahulshettyacademy' to Login.
				
				//find element by Parent by child traverse using X-path 
				driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();
				
			//	Thread.sleep(5000);
				
				//Find Element by css selector with ID values.
				driver.findElement(By.cssSelector("#inputUsername")).sendKeys("rahul");    //   tagname#id value ->OR #id value -> #inputUsername
				  
				//Find Element by CSS Selector with parsing  -> this is used when attribute values are keep changing.  (video-40)
				driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");
				
				//Find element by ID
				driver.findElement(By.id("chkboxOne")).click();
				driver.findElement(By.id("chkboxTwo")).click();
				
				//Find Element by xpath with parsing / regular Exppression . -> it is complex as compared to css parsing.
				driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();        //  Regular expression  ->  	//button[contains(@class,'submit')] 
				 
	
				
				driver.close(); // It will close only the current browser(WEB SITE) open by Selenium
				
				//driver.quit();  // it will close all associate browser which is open by selenium, example ->we are executting a selenium script and it will open a browser(tab1) and on that browser there is a link and when we click on that link it navigate to new browser tab(tab2) so if we use close() then it will close only tab1 and if we use quit() the it will close tab1 and tab2 also. 
								// Note we can not use Close() and Quit() to-gather	*/
	}

}
















/* ------------------*********************************Code by Rahul sir**********************************-----------------------
 import java.time.Duration;



import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;





public class Locators {



public static void main(String[] args) throws InterruptedException {

// TODO Auto-generated method stub

//implicit wait - 2 seconds time out

System.setProperty("webdriver.chrome.driver", "/Users/rahulshetty/Documents/chromedriver");

WebDriver driver = new ChromeDriver();

driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

driver.get("https://rahulshettyacademy.com/locatorspractice/");

driver.findElement(By.id("inputUsername")).sendKeys("rahul");

driver.findElement(By.name("inputPassword")).sendKeys("hello123");

driver.findElement(By.className("signInBtn")).click();

System.out.println(driver.findElement(By.cssSelector("p.error")).getText());

driver.findElement(By.linkText("Forgot your password?")).click();

Thread.sleep(1000);//

driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("John");

driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("john@rsa.com");

driver.findElement(By.xpath("//input[@type='text'][2]")).clear();

driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("john@gmail.com");

driver.findElement(By.xpath("//form/input[3]")).sendKeys("9864353253");

driver.findElement(By.cssSelector(".reset-pwd-btn")).click();

System.out.println(driver.findElement(By.cssSelector("form p")).getText());

driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();

Thread.sleep(1000);

driver.findElement(By.cssSelector("#inputUsername")).sendKeys("rahul");

driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");

driver.findElement(By.id("chkboxOne")).click();

driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();

}



}

*/