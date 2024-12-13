package practice_testNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateContactUsingDataprovider_Test2 {
	@Test(dataProvider="getData")
	public void createContact(String firstname,String Lastname,long phoneNumber)
	{
		System.out.println("FirstName :"+ firstname +", LastName:" + Lastname +", PhoneNumber :"+phoneNumber);
	}

	@DataProvider 
	public Object[][] getData()
	{
		Object[][] objarr=new Object[3][3];
		objarr[0][0]="David";
		objarr[0][1]="jl";
		objarr[0][2]=1234567891l;
		
		objarr[1][0]="Bindu";
		objarr[1][1]="R";
		objarr[1][2]=1234567823l;
		
		objarr[2][0]="John";
		objarr[2][1]="Jacobs";
		objarr[2][2]=7895643678l;
		return objarr;
	}
}
