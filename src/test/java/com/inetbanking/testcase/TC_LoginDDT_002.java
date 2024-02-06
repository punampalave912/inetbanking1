package com.inetbanking.testcase;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
//import org.junit.Assert;
//import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.pageObject.LoginPAGE;
import com.inetbanking.utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass{

	
	@Test(dataProvider="LoginData1")
	public void loginDDT(String uname,String pwd) throws InterruptedException
	{
		//driver.get(baseURL);
		LoginPAGE lp=new LoginPAGE(driver);
		lp.setUserName(uname);
		lp.setuserpwd(pwd);
		lp.clickSubmit();
		
		Thread.sleep(3000);
	
		
		if(isAlertPresent()==true)
		{
			driver.switchTo().alert().accept();//close alert window
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
		}
		else
		{
			Assert.assertTrue(true);
			lp.clickLogout();
			Thread.sleep(3000);
			
			
			driver.switchTo().alert().accept();//close logout alert
			driver.switchTo().defaultContent();
		}
	}
	
	public boolean isAlertPresent()//user defined method is created to check Altert is present or not
	{
		try
		{
		driver.switchTo().alert();
		return true;
	}
		catch(NoAlertPresentException e)
		{
			return false;
		}
	}
	
	@DataProvider(name="LoginData1")
	String [] [] getData() throws IOException
	{
		String path=System.getProperty("user.dir")+"/src/test/java/com/inetbanking/testdata/LoginData1.xlsx";
		int rownum=XLUtils.getRowCount(path,  "Sheet1");
		int colcount=XLUtils.getCellcount(path, "Sheet1",1);
		
		String logindata[][]=new String[rownum][colcount];
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				logindata[i-1][j]=XLUtils.getcellData(path,"Sheet1", i,j);
			}
		}
		return logindata;
	}
}
