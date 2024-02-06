package com.inetbanking.testcase;

//import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObject.LoginPAGE;

public class TC_Login_001 extends BaseClass


{
	@Test
	public void loginTest() throws IOException
	
	{
	
	
	driver.get(baseURL);
    //to call the method from loginpage we have to create the object of login page
	LoginPAGE lp=new LoginPAGE(driver);
	lp.setUserName(username);
	lp.setuserpwd(password);
	lp.clickSubmit();
	
	//String titleofLoginPage=driver.getTitle();
	//System.out.println(titleofLoginPage);
	
	if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
	{
		Assert.assertTrue(true);
	}
	else
	{
		 captureScreen(driver,"loginTest");
		Assert.assertTrue(false);
		//Logger.info("Login test failed");
	}
}
}