package com.inetbanking.testcase;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetbanking.utilities.Readconfig;

public class BaseClass {
	     Readconfig readconfig=new Readconfig();
	
		public String baseURL=readconfig.getApplicationURL();
	    public String username=readconfig.getUsername();
	    public String password=readconfig.getPassword();
	    public static WebDriver driver;
	    @SuppressWarnings("deprecation")
		@Parameters("browser")
	    @BeforeClass
	    public void setup(String br)
	    {
	    	if(br.equals("chrome"))
	    	{
	    	System.setProperty("webdriver.chrome.driver",readconfig.getChromePath());
	    	driver=new ChromeDriver();
	    }
	    
	    else if(br.equals("edge"))
	    {
	    	System.setProperty("webdriver.edge.driver",readconfig.getEdgePath());
	    	driver=new EdgeDriver();
	    	
	    }
	    	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	    	driver.get(baseURL);
	    }
	    @AfterClass
	    public void teardown()
	    {
	    	driver.quit();
	    }
	    public void captureScreen(WebDriver driver,String tname) throws IOException {
	    	TakesScreenshot ts = (TakesScreenshot) driver;
	    	File source = ts.getScreenshotAs(OutputType.FILE);
	    	File target = new File(System.getProperty("user.dir") + "/screenshots/" +".png");
	    	FileUtils.copyFile(source, target);	
	    	System.out.println("Screenshot taken");
	    }

}
