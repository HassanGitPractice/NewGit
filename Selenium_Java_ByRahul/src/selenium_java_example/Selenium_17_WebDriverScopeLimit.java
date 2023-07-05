//video- 92,93,94, 
package selenium_java_example;

import java.time.Duration;
import java.util.Set;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium_17_WebDriverScopeLimit {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\mohammadh\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//1. To know number of link available on webpage
		
		System.out.println(driver.findElements(By.tagName("a")).size());
		
		//2. To know the number of link available in footer section-> Limiting webdriver scope
		
		WebElement minidriver = driver.findElement(By.xpath("//div[@id='gf-BIG']")); //Limiting webdriver scope by creating mini webdriver
		System.out.println(minidriver.findElements(By.tagName("a")).size());
		
		//3. To know the number of link available on footer ist column
		
		//WebElement columndriver = minidriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		WebElement columndriver = minidriver.findElement(By.xpath("(//ul)[1]"));
		System.out.println(columndriver.findElements(By.tagName("a")).size());
	
		//4. Click on all available ist column link on footer
		
		for(int i=1; i<columndriver.findElements(By.tagName("a")).size() ; i++)
		{
			String openInNewTab =Keys.chord(Keys.CONTROL, Keys.ENTER); //it will press ctrl key and then click 
			columndriver.findElements(By.tagName("a")).get(i).sendKeys(openInNewTab); // it will open each link on new page
			
		}
		
			Set<String> wind_IDs=driver.getWindowHandles();
			java.util.Iterator<String> it=wind_IDs.iterator();
			
			while(it.hasNext())
			{
				driver.switchTo().window(it.next());
				System.out.println(driver.getTitle());
			}
			
	}

}
