package com.dell.delta_uat_automation.esupport.testcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.MDC;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.esupport.workflows.BaseFlow;
import com.dell.delta_uat_automation.esupport.workflows.EsupportMobileWorkFlow;
import com.dell.delta_uat_automation.utility.CommonUtility;
import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.MobileTestNGCreator;
import com.dell.delta_uat_automation.utility.Report;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_9922198_AMER_MB_Drivers_LDELL_Story9911898Downloadcountandtableformatfordownloads_ESUPPORT extends MobilePage
{
	
	@Test
	public void validate_TC_9922198_AMER_MB_Drivers_LDELL_Story9911898Downloadcountandtableformatfordownloads() throws Throwable  
	{
		try
		{
//			EsupportMobileWorkFlow obj_EsupportMobileWorkflow = PageFactory.initElements(driver, EsupportMobileWorkFlow.class);

            
			System.out.println("Starts TC_9922198_AMER_MB_Drivers_LDELL_Story9911898Downloadcountandtableformatfordownloads_ESUPPORT");
			Thread.sleep(6000);
			obj_EsupportMobileWorkflow.handleCookies(driver);
			
			obj_EsupportMobileWorkflow.ClickExtensionsAndPinMobileView(driver);
			obj_EsupportMobileWorkflow.ClickExtensionIconAndSelectDevice(driver, "Samsung_Galaxy_S6_Portrait");
            obj_EsupportMobileWorkflow.Switch_To_Mobile_window(driver);
            Thread.sleep(6000);

            obj_EsupportMobileWorkflow.ClickSearchProduct(driver,MobileTestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
		
            obj_EsupportMobileWorkflow.pcfClickDriversandDownloadsTab(driver);
			
            obj_EsupportMobileWorkflow.verifyNoDriversFoundMessage(driver, MobileTestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[0]);
			
            obj_EsupportMobileWorkflow.verifyDownloadsForSearchedKeyword(driver,MobileTestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[1]);
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_9922198_AMER_MB_Drivers_LDELL_Story9911898Downloadcountandtableformatfordownloads_ESUPPORT--------->\n  "+e);
		}
	}
    


}