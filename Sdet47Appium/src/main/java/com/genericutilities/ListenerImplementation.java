package com.genericutilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerImplementation  extends BaseClass implements ITestListener {
	public void onTestFailure(ITestResult result) {
		String imgname = result.getName();
		System.out.println(imgname);
		TakesScreenshot s=(TakesScreenshot) driver;
		File src = s.getScreenshotAs(OutputType.FILE);
		File des=new File("./ScreenShot/"+imgname+".png");
		try {
			FileUtils.copyFile(src, des);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
