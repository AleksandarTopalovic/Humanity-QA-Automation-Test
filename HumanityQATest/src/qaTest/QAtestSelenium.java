package qaTest;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class QAtestSelenium {
	
	static WebDriver driver;
	static String browser;
	

	public static void main(String[] args) {
		setBrowser();
		configBrowser();
		runTest();
		
	}
	//set desired browser, Chrome or Firefox
	public static void setBrowser() {
		browser = "Chrome";

	}
	//configuration for using browsers
	public static void configBrowser() {
		if(browser.contains("Chrome")){
			System.setProperty("webdriver.chrome.driver","D:\\eclipse_workspace\\SeleniumTest\\lib\\chromedriver\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		if(browser.contains("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "D:\\eclipse_workspace\\SeleniumTest\\lib\\firefoxdriver\\geckodriver.exe");
			driver = new FirefoxDriver();	
		}
	}
	
	public static void runTest() {
		
		//open Humanity.com web page in browser and maximize window
		driver.get("https://www.humanity.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//navigate to 'Login' button and click
		driver.findElement(By.xpath("//P[text()='LOGIN']")).click();
		
		//enter username and password and click on login 
		driver.findElement(By.xpath("//INPUT[@id='email']")).sendKeys("topalovic.aleksandar@yahoo.com");
		driver.findElement(By.xpath("//INPUT[@id='password']")).sendKeys("ATq1w2e3");
		driver.findElement(By.xpath("//BUTTON[@class='btn btn-blue btn-full'][text()='Log in']")).click();
		
		//navigate to 'Staff' section in header and click on 'Add Employees' button
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.findElement(By.id("sn_staff")).click();
		driver.findElement(By.id("act_primary")).click();
				
		//adding new employee to staff  
		driver.findElement(By.xpath("//INPUT[@id='_asf1']")).sendKeys("John");
		driver.findElement(By.xpath("//INPUT[@id='_asl1']")).sendKeys("Doe");
		driver.findElement(By.xpath("//INPUT[@id='_ase1']")).sendKeys("John.Doe@address.com");
		driver.findElement(By.xpath("//BUTTON[@id='_as_save_multiple']")).click();

		//loging off and closing the browser
		driver.findElement(By.xpath("//I[@class='icon icon-arrowFullDn j-arrowIconToAvatar navBottom__userArrow']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Sign Out')]")).click();
		driver.quit();
	
	}

	
/*
	<!--
	  _____ _     _  __ _   _____  _                   _
	 / ____| |   (_)/ _| | |  __ \| |                 (_)
	| (___ | |__  _| |_| |_| |__) | | __ _ _ __  _ __  _ _ __   __ _
	 \___ \| '_ \| |  _| __|  ___/| |/ _` | '_ \| '_ \| | '_ \ / _` |
	 ____) | | | | | | | |_| |    | | (_| | | | | | | | | | | | (_| |
	|_____/|_| |_|_|_|  \__|_|    |_|\__,_|_| |_|_| |_|_|_| |_|\__, |
	                                                            __/ |
	                                                           |___/

	Stop poking around in our code for free, and get paid for it. We're hiring: www.humanity.com/jobs/
	-->
*/

}

