package SeptemberSeleniumMaven.EAWebApp;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class AppTest {

WebDriver driver;
	

	@BeforeSuite
	public void beforeSuite() {
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--remote-allow-origins=*");
//		driver = new ChromeDriver(options);
		//System.setProperty("webdriver.chrome.driver","C:\\Users\\User\\Downloads\\Driver_test\\chromedriver-win64\\chromedriver.exe");
		//WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:5001/");
		System.out.println(driver.getTitle());
		
	}
	
	@Test
	public void pageTitleValidation() {
		String expectedResult = "Home Page - EAWebApp";
		String actualResult = driver.getTitle();
		//String actualResult="Facebook";
		
		
		//System.out.println(actualResult);		
		assertTrue(actualResult.equals(expectedResult), "Mistmatch in the page title.");
	}
	
	
	public void productLinkIsClicked() {
		driver.findElement(By.linkText("Product")).click();
		
	}
	
	
	public void createLinkIsClicked() {
		productLinkIsClicked();
		driver.findElement(By.linkText("Create")).click();
		
	}
	
	@Test
	public void ProductIsAdded() {
		createLinkIsClicked();
		driver.findElement(By.id("Name")).sendKeys("Mouse Digital");
		driver.findElement(By.id("Description")).sendKeys("Digital mouse is a wifi mouse");
		driver.findElement(By.id("Price")).sendKeys("190");
		driver.findElement(By.id("Create")).click();
	}

	/*
	 * @Test public void loginTest() {
	 * driver.findElement(By.id("email")).sendKeys("tshimsthedor@yahoo.fr");
	 * driver.findElement(By.id("pass")).sendKeys("thedwer");
	 * driver.findElement(By.xpath("//button[@name='login']")).click(); String
	 * expectedResult = "Log in to Facebook"; String actualResult =
	 * driver.getTitle().toString();
	 * 
	 * Reporter.log("Expected Result = " + expectedResult);
	 * Reporter.log("Actual Result = " + actualResult);
	 * 
	 * assertTrue(actualResult.equals(expectedResult),
	 * "Mistmatch in the page title."); }
	 */
	


	@AfterSuite
	public void afterSuite() {
		driver.close();
	}

}
