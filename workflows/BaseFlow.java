package com.dell.delta_uat_automation.esupport.workflows;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.dell.delta_uat_automation.esupport.pages.EsupportContentHomePage;
import com.dell.delta_uat_automation.esupport.pages.EsupportCoveoPage;
import com.dell.delta_uat_automation.esupport.pages.EsupportDDLHomePage;
import com.dell.delta_uat_automation.esupport.pages.EsupportDriversandDownloadsPage;
import com.dell.delta_uat_automation.esupport.pages.EsupportErevenueHomePage;
import com.dell.delta_uat_automation.esupport.pages.EsupportIncidentsPage;
import com.dell.delta_uat_automation.esupport.pages.EsupportIntegratedHomePage;
import com.dell.delta_uat_automation.esupport.pages.EsupportMPSPage;

import com.dell.delta_uat_automation.esupport.pages.EsupportOrderHomePage;
import com.dell.delta_uat_automation.esupport.pages.EsupportPortalPage;
import com.dell.delta_uat_automation.esupport.pages.EsupportIPSPage;
import com.dell.delta_uat_automation.esupport.pages.EsupportRecentOrderPage;
import com.dell.delta_uat_automation.esupport.pages.EsupportRetailAssetPage;
import com.dell.delta_uat_automation.esupport.pages.EsupportSEOPage;
import com.dell.delta_uat_automation.esupport.pages.EsupportSecurityLandingPage;
import com.dell.delta_uat_automation.esupport.pages.EsupportServiceEventsPage;
import com.dell.delta_uat_automation.esupport.pages.EsupportSubscriptionHomePage;
import com.dell.delta_uat_automation.esupport.pages.EsupportUnifiedPortalPage;
import com.dell.delta_uat_automation.utility.CommonUtility;
import com.dell.delta_uat_automation.utility.Log;

public class BaseFlow {


	
	//public EsupportHomePage obj_EsupportHomePage = new EsupportHomePage();
	
	//public CsFlowDashboardPage obj_CsFlowDashboard = new CsFlowDashboardPage(); 
	
	//static EsupportHomePage obj_EsupportHomePage = new EsupportHomePage();
	public EsupportOrderHomePage obj_EsupportOrderHomePage = new EsupportOrderHomePage();
	public EsupportRecentOrderPage obj_EsupportRecentOrderPage = new EsupportRecentOrderPage(); 
	public EsupportRetailAssetPage obj_EsupportRetailAssetPage = new EsupportRetailAssetPage(); 
	public EsupportDriversandDownloadsPage obj_EsupportDriversandDownloadsPage = new EsupportDriversandDownloadsPage(); 
	public EsupportIncidentsPage obj_EsupportIncidentsPage = new EsupportIncidentsPage(); 
	public EsupportMPSPage obj_EsupportMPSPage = new EsupportMPSPage();
	public EsupportCoveoPage obj_EsupportCoveoPage = new EsupportCoveoPage();
    public EsupportIntegratedHomePage obj_EsupportIntegratedHomePage = new EsupportIntegratedHomePage();
    public EsupportContentHomePage obj_EsupportContentHomePage = new EsupportContentHomePage();
    public EsupportSubscriptionHomePage obj_EsupportSubscriptionHomePage = new EsupportSubscriptionHomePage();
    public EsupportErevenueHomePage obj_EsupportErevenueHomePage = new EsupportErevenueHomePage();
    public EsupportDDLHomePage obj_EsupportDDLHomePage = new EsupportDDLHomePage();
    public EsupportIPSPage obj_EsupportIPSHomePage = new EsupportIPSPage();
    public EsupportServiceEventsPage obj_EsupportServiceEventsHomePage = new EsupportServiceEventsPage();
    public EsupportUnifiedPortalPage obj_UnifiedPortalPage = new EsupportUnifiedPortalPage();
    public EsupportPortalPage obj_PortalPage = new EsupportPortalPage();
    public EsupportSecurityLandingPage obj_SecurityLandingPage = new EsupportSecurityLandingPage();
    public EsupportSEOPage obj_SEOPage = new EsupportSEOPage();
    
	public static String alertText;
	public static String activityNumber;
	public static String userGroup;

	public boolean isAlertPresent(WebDriver driver) {
		try {
			Alert a = new WebDriverWait(driver, 10).until(ExpectedConditions.alertIsPresent());
			if (a != null) {
				System.out.println("Alert is present");
				System.out.println(a.getText());
				driver.switchTo().alert().accept();
				alertText = a.getText();
				return true;
			} else {
				throw new Throwable();
			}
		} catch (Throwable e) {
			// System.err.println("Alert isn't present!!");
			return false;
		}

	}

	public boolean verify(WebDriver driver, WebElement element) {
		boolean present = false;
		if (element != null) {
			CommonUtility.highlightElement(driver, element);
			present = true;
			return present;
		} else {
			return present;
		}
	}

	public boolean verify(WebDriver driver, By by) {
		boolean present = false;
		// WebElement element=driver.findElement(by);
		if (by != null) {
			CommonUtility.highlightElement(driver, by);
			present = true;
			return present;
		} else {
			return present;
		}
	}


	public void hovering(WebDriver driver, WebElement a) {
		try {
			String mouseOverScript = "if(document.createEvent){var evObj = document.createEvent('MouseEvents');evObj.initEvent('mouseover',true, false); arguments[0].dispatchEvent(evObj);} else if(document.createEventObject) { arguments[0].fireEvent('onmouseover');}";
			((JavascriptExecutor) driver).executeScript(mouseOverScript, a);
			Thread.sleep(3000);

		} catch (Exception e) {
			System.out.println("Hovering Did Not Happen");
		}
	}

	public boolean isElementVisible(String elementName, By elementType, WebDriver driver) {

		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 120);
		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
		boolean isVisible = false;

		try {

			wait.until(ExpectedConditions.visibilityOfElementLocated(elementType));

			if (CommonUtility.highlightElement(driver, elementType).isDisplayed()) {

				System.out.println(elementName + ": is displayed");
				isVisible = true;
			} else {

				System.out.println(elementName + ": is not displayed");
				isVisible = false;
				Assert.fail();

			}

		}

		catch (Exception e) {

			System.out.println("Failed while checking visibility of the element:" + elementName);

		}
		return isVisible;

	}

	public static WebDriverWait wait;
	public static int alertcount = 1;

	// generic wait
	public void genericWait(WebDriver driver) {
		wait = new WebDriverWait(driver, 240);
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
	}
	
	public String getCssValue_ElementColor(WebElement element){
        String color = element.getCssValue("color");
        return color;
 }

	public boolean verifyIfStringContainSpecialCharacter(String s){
        Pattern p = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(s);
        boolean b = m.find();
        return b;       
 }
	public void OpenThePopWindow(WebDriver driver) {
		try{
	Thread.sleep(3000);
	System.out.println("Verifying the pop up");
	String parent= driver.getWindowHandle();
	Set<String> windows=driver.getWindowHandles();
	Iterator<String> iter=windows.iterator();
	while( iter.hasNext()){
		   String child=iter.next();
		   if(child!=parent){
			   driver.switchTo().window(child);
		   }
	}
		}catch(Exception e){
			System.out.println("pop up is not exist");
			e.printStackTrace();
		}
	}
	public void handleCookies(WebDriver driver)
    {
          System.out.println("Handle Cookies");
          Log.info("Handle Cookies");   
          try{

        	  WebDriverWait wait = new WebDriverWait(driver, 60);
                driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
          //if(CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.declinecookies()).isDisplayed())
          //CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.declinecookies()).click();  else
               if(CommonUtility.CheckpresenceofElementLocated(driver, 30, obj_EsupportOrderHomePage.acceptCookies()))
               {
            	   CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.acceptCookies()); 
                CommonUtility.ClickOn(driver,obj_EsupportOrderHomePage.acceptCookies());        
               }
               
               if(CommonUtility.CheckpresenceofElementLocated(driver, 15, obj_EsupportIncidentsPage.DoNotSellMyInformationCoockies()))
   			{
   				CommonUtility.ScrollTo(driver,obj_EsupportIncidentsPage.DoNotSellMyInformationCoockies());
   				CommonUtility.ClickOn(driver,obj_EsupportIncidentsPage.DoNotSellMyInformationCoockies());
   				
   				
   				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIncidentsPage.ToggleButtonDisableCoockies()));
   				
   				CommonUtility.ScrollTo(driver,obj_EsupportIncidentsPage.ToggleButtonDisableCoockies());
   				CommonUtility.ClickOn(driver,obj_EsupportIncidentsPage.ToggleButtonDisableCoockies());
   				
   				Thread.sleep(3000);
   				
   				CommonUtility.ScrollTo(driver,obj_EsupportIncidentsPage.SavePreferencesButtonCoockies());
   				CommonUtility.ClickOn(driver,obj_EsupportIncidentsPage.SavePreferencesButtonCoockies());
   			}
          }
          catch(Exception ex){


          }
          driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
          driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

    }  


}
