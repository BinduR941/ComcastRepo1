package practice_testNG;

import org.testng.annotations.Test;

import com.comcast.crm.baseutility.BaseClass;
import com.comcast.crm.objectrepositoryutility.LoginPage;

/**
 * test class for contact module
 * @author bindu
 */
public class SearchContactTest_CodingStandardsPgm extends BaseClass {

	@Test
	public void searchContactTest()
	{
		/*Step1: login to app*/
	
	LoginPage lp=new LoginPage(driver);
	lp.loginTOApp("username", "pass");

}
}
