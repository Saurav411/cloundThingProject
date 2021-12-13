import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CT_TestCase {

	@Test
	public void TestCase() {

		// Code to Execute on Chrome**************************
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		// Code to Execute on Firefox**************************
		// System.setProperty("webdriver.gecko.driver",
		// System.getProperty("user.dir") +"\\drivers\\geckodriver.exe");
		// // Instantiate a Firefox class.
		// DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		// capabilities.setCapability("marionette",true);
		// @SuppressWarnings("deprecation")
		// WebDriver driver= new FirefoxDriver(capabilities);

		// To maximize the browser and implementing implicit wait time.
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// To validate Page title
		// String expectedTitle = "Google";
		// String actualTitle = driver.getTitle();
		// Assert.assertEquals(actualTitle, expectedTitle);

		// Launch Website
		driver.navigate().to("https://cloudthing.com/");

		Actions a1 = new Actions(driver);
		WebElement AboutUs = driver.findElement(By.xpath("//ul[@class = 'mmm']/li/a[contains(text(),'About Us ')]"));
		a1.moveToElement(AboutUs).build().perform();
		
		driver.findElement(
				By.xpath("//ul[@class = 'mmm']/li/a[contains(text(),'About Us ')]/following-sibling::div[@class = 'mobmenu']//a[contains(text(),'Careers')]"))
				.click();
		String SearchJob = "Data Architect - LEARN MORE";
		driver.findElement(By.xpath("//*[@id= 'pos-search']")).sendKeys(SearchJob);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,600)");
		WebElement element =	driver.findElement(By.xpath("//*[@id= 'pos-list']//*[contains(text(),'Data Architect - LEARN MORE')]/ancestor::div[@class='job-ad-title']"));
		js.executeScript("argument[0].scrollIntoView(true)", element);
		js.executeScript("argument[0].click()", element);
//		driver.findElement(By.xpath("//*[@id= 'pos-list']//*[contains(text(),'Data Architect - LEARN MORE')]/ancestor::div[@class='job-ad-title']")).click();
//		js.executeScript("window.scrollBy(0,1000)");
		
		WebElement name =	driver.findElement(By.xpath("//*[@name = 'your-name']"));
		js.executeScript("argument[0].scrollIntoView(true)", name);
		driver.findElement(By.xpath("//*[@id= 'pos-search']")).sendKeys("Saurav");	
		
		WebElement email =	driver.findElement(By.xpath("//*[@name = 'email']"));
		js.executeScript("argument[0].scrollIntoView(true)", email);
		driver.findElement(By.xpath("//*[@id= 'pos-search']")).sendKeys("saurav.suman1104@gmail.com");	
		
		WebElement tel =	driver.findElement(By.xpath("//*[@name = 'tel']"));
		js.executeScript("argument[0].scrollIntoView(true)", tel);
		driver.findElement(By.xpath("//*[@id= 'pos-search']")).sendKeys("8962721741");	
		
		WebElement message =	driver.findElement(By.xpath("//*[@name = 'message']"));
		js.executeScript("argument[0].scrollIntoView(true)", message);
		driver.findElement(By.xpath("//*[@id= 'pos-search']")).sendKeys("message");
		
		WebElement chooseFile = driver.findElement(By.xpath("//*[@type='file' and @name='cv']"));
		chooseFile.sendKeys("/cloudThingProject/Resume_Saurav_QA.pdf");
		
		driver.findElement(By.xpath("//*[@type= 'submit']")).click();
		
//		Verifying if the form is submitted successfully		
		Assert.assertEquals(true, driver.findElement(By.xpath("//div[@class='wpcf7-response-output']")).isDisplayed());
		
		
		
		
		
		
		
		
		
	
		
		
		
		
		

		// driver.quit();
	}
}
