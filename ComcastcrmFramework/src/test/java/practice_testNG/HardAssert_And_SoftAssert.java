package practice_testNG;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.internal.MethodArguments;

public class HardAssert_And_SoftAssert {
@Test
public void homePagetest(Method mtd){
	Reporter.log(mtd.getName() + "Test start",true);
	Reporter.log("step1");
	Reporter.log("step2");
	Assert.assertEquals("Home", "Home");
	Reporter.log("step3");
	Assert.assertEquals("Home-CRM", "Home-CRM");
	Reporter.log("step4");
	Reporter.log(mtd.getName() + "Test end");
	
}

@Test
public void verifylogoPagetest(Method mtd){
	Reporter.log(mtd.getName() + "Test start");
	Reporter.log("step1");
	Reporter.log("step2");
	SoftAssert assertobj=new SoftAssert();
	
	assertobj.assertEquals("Home", "H");
	Reporter.log("step3");
	assertobj.assertEquals("Home-CRM", "Home-CRM");
	Reporter.log("step4");
	Reporter.log(mtd.getName() + "Test end");
	assertobj.assertAll();
}
}
