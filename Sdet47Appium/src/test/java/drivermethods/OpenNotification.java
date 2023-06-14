package drivermethods;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class OpenNotification {
	@Test
	public void openNotify() throws MalformedURLException
	{
		File f=new File("C:\\Users\\johns\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js");
		AppiumDriverLocalService service=new AppiumServiceBuilder().withAppiumJS(f).withIPAddress("127.0.0.1").usingPort(4723).withTimeout(Duration.ofSeconds(1000)).build(); 
		service.start();
		
		
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		dc.setCapability(MobileCapabilityType.DEVICE_NAME,"realme85g");
		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		dc.setCapability(MobileCapabilityType.UDID, "YX9TIJRCROYHGI7T");
		
	    dc.setCapability("appPackage", "com.androidsample.generalstore");
	    dc.setCapability("appActivity", ".SplashActivity");
	    
	    URL u=new URL("http://localhost:4723");
	    AndroidDriver driver = new AndroidDriver(u,dc);
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/spinnerCountry")).click();
	    driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"India\"))"));
	    driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='India']")).click();
	    driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/nameField")).sendKeys("Johnsy");
	    driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/radioFemale")).click();
	    driver.hideKeyboard();
	    driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();
	    driver.openNotifications();
	    service.stop();
	}

}
