package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.gherkin.model.And;
import com.comcast.crm.WebDriverUtility.WebDriverUtility;
import com.google.j2objc.annotations.OnDealloc;
/**
 * @author bindu
 * Contains login page elements and business library like login 
 * */


public class LoginPage extends WebDriverUtility {
	// Rule 1:create a separate java class
//Rule 2:Object creation-identify all elements using @FindBy
	
	
	//public WebDriver driver;

	public LoginPage(WebDriver driver) {

		//this.driver=driver; //go to browser reference and initialize //browser reference is local to constructor
	PageFactory.initElements(driver, this);  //doing the initialization inside the constructor driver will give acess to the webpage and this will
	//capture current address  
	}
	
	@FindBy(name = "user_name")
	private WebElement UserName;

	@FindBy(name = "user_password")
	private WebElement Password;

	@FindBy(id = "submitButton")
	private WebElement Loginbtn;// Rule 3:Object Initialization

	// Rule 4: Object Encapsulation

	public WebElement getUserName() {
		return UserName;
	}

	public WebElement getPassword() {
		return Password;
	}

	public WebElement getLoginbtn() {
		return Loginbtn;
	}
	
	@FindBy(xpath = "//input[@class=\\\"crmButton small save\\\"]")
	private WebElement Savebutton;

	public WebElement getSavebutton() {
		return Savebutton;
	}
/**
 * loginto application based on username, password, url arguments
 * @param userName
 * @param password
 */
	// Rule5: we can provide
	public void loginTOApp(String userName, String password) {
		
		
	    UserName.sendKeys(userName);
		Password.sendKeys(password);
		Loginbtn.click();
	}

}