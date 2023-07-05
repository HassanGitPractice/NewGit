package selenium_java_example;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium_18_calenderAdvance {

	public static void main(String[] args) {

		// Expected date : 25-June-2023
		String expectedDay = "25";
		String expectedMonth = "July";
		String expectedYear = "2023";

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\mohammadh\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://jqueryui.com/datepicker/");  
		driver.manage().window().maximize();
		// To know the no. of iframe available on webpage
		System.out.println(driver.findElements(By.tagName("iframe")).size());
		driver.switchTo().frame(0); // switch to frame
		driver.findElement(By.xpath("//input[@class='hasDatepicker']")).click();

		while (true) {
			String calenderMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			String calenderYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();

			if (calenderMonth.equals(expectedMonth) && calenderYear.equals(expectedYear)) {
				List<WebElement> daysList = driver.findElements(By.xpath("//table/tbody/tr/td"));  //td[@data-handler='selectDay']

				for (WebElement e : daysList) {
					String calenderDay = e.getText();
					if (calenderDay.equals(expectedDay)) {
						e.click();
						break; // to
					}
				}
				break;
			} else {
				driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
			}

		}
	}

}
