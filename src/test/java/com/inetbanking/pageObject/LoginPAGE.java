package com.inetbanking.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPAGE {
             WebDriver ldriver;//first we have to create webdriver(ldriver-load driver)
             
             public LoginPAGE(WebDriver rdriver)//then we have to write the constructor(rdriver-remotedriver)
             {
            	 ldriver=rdriver;//then we need to initiate the local driver and remote driver
            	 PageFactory.initElements(rdriver, this);//then also need to specify the pagefactroy class
            	 
             }
             //then we need to identify the elements which are present inside the login page
             @FindBy(name="uid")
             WebElement textUserName;
             
             @FindBy(name="password")
             WebElement textPassword;
             
             @FindBy(name="btnLogin")
             WebElement textbtn;
             
             @FindBy(xpath="//a[text()='Log out']")
             WebElement lnkLogout;
             
             //then we have to write action method for this Element
             
             public void setUserName(String uname)
             {
            	 textUserName.sendKeys(uname);
}
             public void setuserpwd(String pwd)
             {
            	 textPassword.sendKeys(pwd);
}
             public void clickSubmit()
             {
            	 textbtn.click();
}
             public void clickLogout()
             {
            	 lnkLogout.click();
             }
             
}
