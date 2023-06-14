package com.genericutilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;

public class DriverUtilities {
	
	DesiredCapabilities dc;
	AndroidDriver driver;
	
	public DriverUtilities(AndroidDriver driver)
	{
		this.driver=driver;

	}
	
	public void waitForPageLoad(AndroidDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	
   public void unlockMobile(String type,String keyValue)
   {
	  dc.setCapability("unlockType", type);
	  dc.setCapability("unlockKey",keyValue );
   }
   
   public void launchAPP(AndroidDriver driver,String appPackage)
   {
	   driver.activateApp(appPackage);
   }
   public void openNotification(AndroidDriver driver)
   {
	   driver.openNotifications();
   }
   
   public void rotateScreen(AndroidDriver driver)
   {
        ScreenOrientation s = driver.getOrientation();
        driver.rotate(s.LANDSCAPE);
   }
   public void appInstalledOrNot(AndroidDriver driver,String appPackage)
   {
	   Boolean res=driver.isAppInstalled(appPackage);
	   if(res==true)
		   System.out.println("Application is installed");
	   else
		   System.out.println("Application is not installed");
   }
   
}
