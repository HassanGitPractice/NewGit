package selenium_java_example;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Selenium_19_calenderAdvance {

	public static void main(String[] args) {
		
		
		
		// Expected date 
		String expectedDay = "25";
		String expectedMonthYear = "September 2023"; 
		//String expectedYear = "2023";

		/*System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\mohammadh\\Downloads\\chromedriver_win32\\chromedriver.exe");*/
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://www.goibibo.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//span[@role='presentation']")).click();
		
		driver.findElement(By.xpath("(//p[@class='sc-12foipm-18 dxLXYg fswWidgetTitle'])[1]")).click();

		while (true) {
			String calenderMonthYear = driver.findElement(By.xpath("(//div[@class='DayPicker-Caption'])[1]")).getText();
			//String calenderYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();

			if (calenderMonthYear.equals(expectedMonthYear)) {
				List<WebElement> daysList = driver.findElements(By.xpath("//div[@class='DayPicker-Day']"));

				for (WebElement e : daysList) {
					String calenderDay = e.getText();
					if (calenderDay.equals(expectedDay)) {
						e.click();
						break; // to get out from inner for loop
					}
				}
				break;// to get out from while loop
			} 
			else 
			{
				driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
			}

		}
		
		
	}

}
