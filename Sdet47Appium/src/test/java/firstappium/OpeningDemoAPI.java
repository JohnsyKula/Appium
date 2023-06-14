package firstappium;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class OpeningDemoAPI {
@Test
public void openDemo() throws Throwable 
{
	DesiredCapabilities dc=new DesiredCapabilities();
	dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
	dc.setCapability(MobileCapabilityType.DEVICE_NAME,"realme85g");
	dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
	dc.setCapability(MobileCapabilityType.UDID, "YX9TIJRCROYHGI7T");
	//dc.setCapability(MobileCapabilityType.NO_RESET, false);
	
	
    dc.setCapability("appPackage", "io.appium.android.apis");
    dc.setCapability("appActivity", ".ApiDemos");
    
    URL u=new URL("http://localhost:4723"); 
    AndroidDriver driver = new AndroidDriver(u,dc);
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
}


}
