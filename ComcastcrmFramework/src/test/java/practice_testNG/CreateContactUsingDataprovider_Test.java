package practice_testNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateContactUsingDataprovider_Test {
	@Test(dataProvider="getData")
	public void createContact(String firstname,String Lastname)
	{
		System.out.println("FirstName :"+ firstname + ",LastName:"+Lastname);
	}

	@DataProvider 
	public Object[][] getData()
	{
		Object[][] objarr=new Object[3][2];
		objarr[0][0]="David";
		objarr[0][1]="john";
		objarr[1][0]="Bindu";
		objarr[1][1]="R";
		objarr[2][0]="John";
		objarr[2][1]="Jacobs";
		return objarr;
	}
}
