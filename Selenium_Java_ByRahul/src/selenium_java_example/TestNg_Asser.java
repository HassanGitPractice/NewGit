package selenium_java_example;

	
	
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.chrome.ChromeOptions;
	import org.testng.Assert;
	//Video-60
	public class TestNg_Asser 
	{
		public static void main(String[] args)
		{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\mohammadh\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver =new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.manage().window().maximize();
        //System.out.println(driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected()); //It will return true is check box is selected if not selected it will return false.
       Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected());
        driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).click();
        //System.out.println(driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected());
        Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected());

        //Try to return the no. of checkbox present on the page.
        System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());
        Assert.assertEquals(driver.findElements(By.cssSelector("input[type='checkbox']")).size(),6);
        
		}
	}
