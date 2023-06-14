package firstappium;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class ScrollBar {
	@Test
	public void scroll() throws MalformedURLException
	{
		File f=new File("C:\\Users\\johns\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js");
		AppiumDriverLocalService service=new AppiumServiceBuilder().withAppiumJS(f).withIPAddress("127.0.0.1").usingPort(4723).withTimeout(Duration.ofSeconds(1000)).build(); 
		service.start();
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		dc.setCapability(MobileCapabilityType.DEVICE_NAME,"realme85g");
		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		dc.setCapability(MobileCapabilityType.UDID, "YX9TIJRCROYHGI7T");
		
	    dc.setCapability("appPackage", "io.appium.android.apis");
	    dc.setCapability("appActivity", ".ApiDemos");
	    
	    URL u=new URL("http://localhost:4723"); 
	    AndroidDriver driver = new AndroidDriver(u,dc);
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    driver.findElement(AppiumBy.accessibilityId("Views")).click();
	    
//	    //Scrolling upside
	    ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
	    	    "left", 450, "top", 350, "width", 450, "height", 1000,
	    	    "direction", "down",
	    	    "percent", 2.0
	    	));
//	    
//	    //scrolling downside
//	    ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
//	    	    "left", 350, "top", 450, "width", 450, "height", 500,
//	    	    "direction", "up",
//	    	    "percent", 1.0
//	    	));
	    
	    
	    
//	    boolean canScrollMore;
//	    do {
//	    	canScrollMore=(Boolean)((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
//		    	    "left", 350, "top", 450, "width", 450, "height", 500,
//		    	    "direction", "up",
//		    	    "percent", 1.0
//		    	));
//	    }
//	    while(canScrollMore);

	    
	    //if we know the particular element we can use this
	    driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"))"));
	    
	    service.stop();
	}
}
