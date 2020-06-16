package com.insurance.qa.base;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.insurance.qa.util.TestUtil;
import com.insurance.qa.util.WebEventListener;



public class InsuranceBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public static DesiredCapabilities cap;
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
	public InsuranceBase() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("C:\\Users\\pooja.adhana\\eclipse-workspace\\Insurance_HCINTest\\src\\main\\java\\com\\insurance\\qa\\config\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void initialization() {
		
				
		String browserName=prop.getProperty("browser");
		if(browserName.equals("chrome")){
//			cap=DesiredCapabilities.chrome();
//			 
//			// Set ACCEPT_SSL_CERTS  variable to true
//			cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
//			 
//			// Set the driver path
//			System.setProperty("webdriver.chrome.driver","C:\\HomeCredit_Docs\\Automation\\chromedriver.exe");
//			 
//			// Open browser with capability
//			 driver=new ChromeDriver(cap);
			System.setProperty("webdriver.chrome.driver", "C:\\HomeCredit_Docs\\Automation\\chromedriver.exe");	
			driver = new ChromeDriver(); 
		}
		
		//To log everything what a driver is doing
		e_driver = new EventFiringWebDriver(driver);
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		System.out.println("Load time="+TestUtil.PAGE_LOAD_TIMEOUT);
		System.out.println("Implicit wait="+TestUtil.IMPLICIT_WAIT);
		System.out.println("url"+prop.getProperty("url"));
		driver.get(prop.getProperty("url"));
	}
	
 }
