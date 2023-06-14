package com.generalstore.POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.genericutilities.GestureUtility;

import io.appium.java_client.android.AndroidDriver;

public class LoginPage {
    AndroidDriver driver;


	@FindBy(id="com.androidsample.generalstore:id/spinnerCountry")
	private WebElement dropdown;
    
    @FindBy(id="com.androidsample.generalstore:id/nameField")
    private WebElement nameTxt;
    
    @FindBy(id="com.androidsample.generalstore:id/radioFemale")
    private WebElement femaleRadioBtn;
    
    @FindBy(id="com.androidsample.generalstore:id/btnLetsShop")
    private WebElement letShopBtn;
    
	public LoginPage(AndroidDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}

	public WebElement getDropdown() {
		return dropdown;
	}
	public WebElement getNameTxt() {
		return nameTxt;
	}
	public WebElement getFemaleRadioBtn() {
		return femaleRadioBtn;
	}
	public WebElement getLetShopBtn() {
		return letShopBtn;
	}
	public AndroidDriver getDriver() {
		return driver;
	}
	
	public void loginSetUp()
	{
		dropdown.click();
		GestureUtility gu=new GestureUtility(driver);
		gu.scroll("India");
		nameTxt.sendKeys("Johnsy");
        femaleRadioBtn.click();
        letShopBtn.click();
	}
	
}
