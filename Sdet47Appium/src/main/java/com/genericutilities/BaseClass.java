package com.genericutilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.generalstore.POM.LoginPage;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseClass {
	
	public static AndroidDriver driver;
	public AppiumDriverLocalService service;
	public LoginPage lp;
	public GestureUtility gUtil;

	
	@BeforeSuite
	public void startServer()
	{
		File f=new File("C:\\Users\\johns\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js");
	    service=new AppiumServiceBuilder().withAppiumJS(f).withIPAddress("127.0.0.1").usingPort(4723).withTimeout(Duration.ofSeconds(1000)).build(); 
		service.start();
	}
	@BeforeMethod
	public void openApp() throws MalformedURLException
	{
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		dc.setCapability(MobileCapabilityType.DEVICE_NAME,"realme85g");
		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		dc.setCapability(MobileCapabilityType.UDID, "YX9TIJRCROYHGI7T");
		
	    dc.setCapability("appPackage", "com.androidsample.generalstore");
	    dc.setCapability("appActivity", ".SplashActivity");
	   
	    URL u=new URL("http://localhost:4723");
	    driver = new AndroidDriver(u,dc);
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	@AfterMethod
	public void closeApp()
	{
		driver.quit();
	}
	@AfterSuite
	public void stopServer()
	{
		service.stop();
	}

}
