package Assignment;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.generalstore.POM.LoginPage;
import com.genericutilities.BaseClass;
import com.genericutilities.GestureUtility;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

@Listeners(com.genericutilities.ListenerImplementation.class)
public class LoginTest extends BaseClass  {
@Test
public void appLogin() throws MalformedURLException
{
//	File f=new File("C:\\Users\\johns\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js");
//	AppiumDriverLocalService service=new AppiumServiceBuilder().withAppiumJS(f).withIPAddress("127.0.0.1").usingPort(4723).withTimeout(Duration.ofSeconds(1000)).build(); 
//	service.start();
//	DesiredCapabilities dc=new DesiredCapabilities();
//	dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
//	dc.setCapability(MobileCapabilityType.DEVICE_NAME,"realme85g");
//	dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
//	dc.setCapability(MobileCapabilityType.UDID, "YX9TIJRCROYHGI7T");
//	
//    dc.setCapability("appPackage", "com.androidsample.generalstore");
//    dc.setCapability("appActivity", ".SplashActivity");
//    
//    URL u=new URL("http://localhost:4723");
//    AndroidDriver driver = new AndroidDriver(u,dc);
//    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    
    //login
    LoginPage l=new LoginPage(driver);
    l.loginSetUp();
    Assert.fail();
    
}

}
