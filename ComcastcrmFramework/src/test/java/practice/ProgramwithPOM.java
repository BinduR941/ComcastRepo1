package practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class ProgramwithPOM {

	
@FindBy(name="user_name")
WebElement username;
@FindBy(name="user_password")
WebElement pwd;
@FindBys({@FindBy(id="submitButton"), @FindBy(xpath = "(//input[@value=\"Login\"])[2]")})
WebElement Loginbtn;


@Test
public void Test()
{
	WebDriver driver=new ChromeDriver();
	driver.get("http://localhost:8888/");
	ProgramwithPOM s = PageFactory.initElements(driver,ProgramwithPOM.class);//identifies the elemenet and loads the elements with the current address inside the variable,pass broswer session and name of the class as an argument
	
	s.username.sendKeys("admin");
	s.pwd.sendKeys("admin");
	// at the time of usage,using the reference it  takes the latest address of  the browser and perform an action 
	driver.navigate().refresh();
	s.username.sendKeys("admin");
	s.pwd.sendKeys("admin");
	s.Loginbtn.click();

	}

}
