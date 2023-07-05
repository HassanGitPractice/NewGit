package selenium_java_example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.AbstractDriverOptions;

public class Selemium_16_IframeSwitch {

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\mohammadh\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://jqueryui.com/droppable/");
		
		// To know the number of frame present in webpage 
		System.out.println(driver.findElements(By.tagName("iframe")).size());
		
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
		
		//driver.findElement(By.cssSelector("div[id='draggable']")).click();
		
		//drag and drop
		Actions a = new Actions(driver);
		
		WebElement source = driver.findElement(By.cssSelector("div[id='draggable']"));
		WebElement target = driver.findElement(By.cssSelector("div[id='droppable']"));
		
		a.dragAndDrop(source, target).build().perform();
		
		//To get exit from the frame and come back to original position
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//a[text()='Accept']")).click();
	}

}
