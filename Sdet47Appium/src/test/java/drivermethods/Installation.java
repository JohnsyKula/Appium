package drivermethods;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.genericutilities.BaseClass;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
//@Listeners(com.genericutilities.ListenerImplementation.class)
public class Installation{

	@Test
	public void installApp() throws MalformedURLException
	{
		File f=new File("C:\\Users\\johns\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js");
		AppiumDriverLocalService service=new AppiumServiceBuilder().withAppiumJS(f).withIPAddress("127.0.0.1").usingPort(4723).withTimeout(Duration.ofSeconds(1000)).build(); 
		service.start();
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		dc.setCapability(MobileCapabilityType.DEVICE_NAME,"realme85g");
		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		dc.setCapability(MobileCapabilityType.UDID, "YX9TIJRCROYHGI7T");
		
		//install way1 *
		//dc.setCapability(MobileCapabilityType.APP, "C:/Users/johns/eclipse-workspace/Sdet47Appium/src/test/resources/General-Store.apk");

		

	    
	    URL u=new URL("http://localhost:4723");
	    AndroidDriver driver = new AndroidDriver(u,dc);
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    
	    //install way 2
	     driver.installApp("C:\\Users\\johns\\eclipse-workspace\\Sdet47Appium\\src\\test\\resources\\General-Store.apk");
	    
	    //to check App is installed or not
	    System.out.println(driver.isAppInstalled("com.androidsample.generalstore"));
	    service.stop();
	}

}
