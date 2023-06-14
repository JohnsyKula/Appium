package com.genericutilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class GestureUtility {
	
	AndroidDriver driver;
	
	public GestureUtility(AndroidDriver driver)
	{
		this.driver=driver;
	}
	
	public void longPress(AndroidDriver driver,WebElement ele)
	{
	   ((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
		    	    "elementId", ((RemoteWebElement) ele).getId(),"duration",2000
		    	));
	}
	
	public void scroll(String element)
	{
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+element+"\"))")).click();
	}
	
	public void  swipeLeft(WebElement ele)
	{
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
				"elementId",((RemoteWebElement) ele).getId(),
			    "direction", "left",
			    "percent", 0.75
			));
	}
	
	public void swipeRight(WebElement ele)
	{
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
				"elementId",((RemoteWebElement) ele).getId(),
			    "direction", "right",
			    "percent", 0.75
			));

		
	}
	public void dragAndDrop(WebElement ele)
	{
		((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement) ele).getId(),
			    "endX", 100,
			    "endY", 100
			));
	}
	public void pinchOpen(WebElement ele)
	{
		((JavascriptExecutor) driver).executeScript("mobile: pinchOpenGesture", ImmutableMap.of(
				"elementId", ((RemoteWebElement) ele).getId(),
				"percent", 0.75
				));
	}
	public void pinchClose(WebElement ele)
	{
		((JavascriptExecutor) driver).executeScript("mobile: pinchCloseGesture", ImmutableMap.of(
				"elementId", ((RemoteWebElement) ele).getId(),
				"percent", 0.75
				));
	}
	

}
