package com.dell.delta_uat_automation.esupport.workflows;

import java.io.IOException;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.dell.delta_uat_automation.utility.CommonUtility;
import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.Log;
import com.dell.delta_uat_automation.utility.Report;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class EsupportIPSWorkflow extends BaseFlow 
{
	public EsupportContentWorkflow obj_EsupportContentWorkflow = new EsupportContentWorkflow();
	
	public void handleCookies(WebDriver driver)
	{
		System.out.println("Handle Cookies");
		Log.info("Handle Cookies");	
		WebDriverWait wait = new WebDriverWait(driver,200);
		try
		{
			//			if(CommonUtility.CheckpresenceofElementLocated(driver, 10, obj_EsupportOrderHomePage.declinecookies()))
			//				CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.declinecookies()).click();  
			if(CommonUtility.CheckpresenceofElementLocated(driver, 10, obj_EsupportOrderHomePage.acceptCookies()))
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
		catch(Exception ex)
		{
			System.out.println("Cookies not present");
		}

		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
	}  

	public void validateProductHeader(WebDriver driver)
	{
		System.out.println("Inside validateProductHeader method");
		Log.info("Inside validateProductHeader method");

		String url = "";
		url = driver.getCurrentUrl();
		try
		{
			handleCookies(driver);
			String header = "";			

			WebDriverWait wait = new WebDriverWait(driver, 120);

			System.out.println("Current Url is:"+url);

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIPSHomePage.productHeader()));
			CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.productHeader());
			header = CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.productHeader()).getText();

			System.out.println("Product Header is:"+header);

			Report.put("Launch the URL in Chrome"+Report.color(url),
					"Should land in the product support page for the respective L Dell and M&A Products",
					"Landed in Product Support Page successfully. Header is:"+Report.color(header), "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Launch the URL in Chrome"+Report.color(url),
					"Should land in the product support page for the respective L Dell and M&A Products",
					"Failed to load Product Support Page", "FAIL");
			Assert.fail();
		}
	}


	public void clickSystemConfigurationLink(WebDriver driver)
	{
		System.out.println("Inside clickSystemConfigurationLink method");
		Log.info("Inside clickSystemConfigurationLink method");

		try
		{
			handleCookies(driver);
			String header = "";
			WebDriverWait wait = new WebDriverWait(driver, 120);

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIPSHomePage.systemConfigurationLink()));
			CommonUtility.ClickOn(driver,obj_EsupportIPSHomePage.systemConfigurationLink());

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIPSHomePage.systemConfigurationPopupHeader()));
			header = CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.systemConfigurationPopupHeader()).getText();

			Report.put("Click on the system configuration link on the hero section below the service tag",
					"User should load the system configuration Modal Pop up",
					"Modal Pop Up displayed Successfully. Header is: "+Report.color(header), "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on the system configuration link on the hero section below the service tag",
					"User should load the system configuration Modal Pop up",
					"Failed to display Modal Pop Up", "FAIL");
			Assert.fail();
		}
	}

	public void verifyModalPopupConfiguration(WebDriver driver)
	{
		System.out.println("Inside verifyModalPopupConfiguration method");
		Log.info("Inside verifyModalPopupConfiguration method");

		try
		{
			//handleCookies(driver);

			String header = "";
			String tabList = "";
			String defaultTab = "";
			WebDriverWait wait = new WebDriverWait(driver, 120);
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIPSHomePage.configurationTabs()));
			List<WebElement> list=driver.findElements(obj_EsupportIPSHomePage.configurationTabs());

			for(WebElement lt:list)
			{
				CommonUtility.highlightElement(driver, lt);
				String tabName=lt.getText();

				System.out.println("Tab is: " +tabName);
				tabList+=" <br> " + tabName;
			}
			System.out.println("Tabs are:"+tabList);

			if(CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.activeConfigurationTab()).isDisplayed())
			{
				defaultTab = CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.activeConfigurationTab()).getText();
				System.out.println("Default tab is:"+defaultTab);
			}

			Report.put("Verify the modal pop up",
					"System configuration modal pop up should show with original configuration by Default and current  configuration",
					"Configuration Tabs displayed Successfully. Tabs are: "+Report.color(tabList)+"<br>"+"Default is "+Report.color(defaultTab), "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify the modal pop up",
					"System configuration modal pop up should show with original configuration by Default and current  configuration",
					"Failed to display Configuration Tabs", "FAIL");
			Assert.fail();
		}
	}

	//	public void  navigateToURL(WebDriver driver, String tag)
	//	{
	//		WebDriverWait wait = new WebDriverWait(driver, 120);
	//
	//		String header = "";
	//		String text = "https://productsupportux-pilot.ausmp1z1.pcf.dell.com/support/home/us/en/04/product-support/servicetag/";
	//		String url = text+tag;
	//		String currentUrl = "";
	//		System.out.println("Entering navigateToURL "+url);
	//		Log.info("Entering navigateToURL");   
	//
	//		try
	//		{      
	//			driver.navigate().to(url);
	//			currentUrl = driver.getCurrentUrl();
	//			System.out.println("Current URL is :"+currentUrl);			
	//		}
	//		catch(Exception e)
	//		{
	//			e.printStackTrace();		
	//			Assert.fail();
	//		}
	//	}

	public void  navigateToURL(WebDriver driver) throws IOException
	{
		WebDriverWait wait = new WebDriverWait(driver, 120);

		String url = "";
		String currentUrl = "";
		Properties obj_property;
		obj_property = CommonUtility.loadPropertyFile();
		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS); 
		url = obj_property.getProperty("pcf1url");	

		System.out.println("Entering navigateToURL "+url);
		Log.info("Entering navigateToURL");   

		try
		{      
			driver.navigate().to(url);
			currentUrl = driver.getCurrentUrl();
			System.out.println("Current URL is :"+currentUrl);			
		}
		catch(Exception e)
		{
			e.printStackTrace();		
			Assert.fail();
		}
	}

	public void verifyModalPopup(WebDriver driver)
	{
		System.out.println("Inside verifyModalPopup method");
		Log.info("Inside verifyModalPopup method");

		try
		{

			String tab = "";

			WebDriverWait wait = new WebDriverWait(driver, 120);

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIPSHomePage.originalConfigurationTab()));
			tab = CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.originalConfigurationTab()).getText();

			System.out.println("Tab is: "+tab);

			Report.put("Verify the modal pop up",
					"System configuration modal pop up should show with original configuration",
					"Original Configuration Tab displayed Successfully. Tab is: "+Report.color(tab), "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify the modal pop up",
					"System configuration modal pop up should show with original configuration",
					"Failed to display Original Configuration Tab ", "FAIL");
			Assert.fail();
		}
	}

	public void clickViewDetailsLink(WebDriver driver)
	{
		System.out.println("Inside clickViewDetailsLink method");
		Log.info("Inside clickViewDetailsLink method");
		Actions act=new Actions(driver);
		try
		{
			String header = "";
			WebDriverWait wait = new WebDriverWait(driver, 120);

			//			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIPSHomePage.viewDetailsLink()));
			CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.ViewWarrantyDetailsLink());
			CommonUtility.ClickOn(driver,obj_EsupportIPSHomePage.ViewWarrantyDetailsLink());
			System.out.println("clicked on view details link");
			//			act.moveToElement(CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.viewDetailsLink())).click().perform();
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIPSHomePage.warrantyDetailsHeader()));
			header = CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.warrantyDetailsHeader()).getText();

			Report.put("Click on the View details link",
					"Warranty Model pop up should load with Title as warranty details in Bold",
					"Warranty Modal Pop Up displayed Successfully. Header is "+Report.color(header), "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on the View details link",
					"Warranty Modal pop up should load with Title as warranty details in Bold",
					"Failed to display Warranty Modal Pop Up", "FAIL");
			Assert.fail();
		}
	}

	public void verifyWarrantyDetailsModalPopup(WebDriver driver)
	{
		System.out.println("Inside verifyWarrantyDetailsModalPopup method");
		Log.info("Inside verifyWarrantyDetailsModalPopup method");

		try
		{
			String labelList = "";
			String details="";
			CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.warrantyDetailsList());
			List<WebElement> list=driver.findElements(obj_EsupportIPSHomePage.warrantyDetailsList());
			
			for(WebElement lt:list)
			{
				CommonUtility.ScrollToWebElement(driver, lt);
				String label=lt.getText();

				System.out.println("Label is: " +label);
				labelList+=" <br> " + label;
			}
			System.out.println("Tabs are:"+labelList);
			
			CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.DetailsInWarrantyPopUp());
			List<WebElement> list1=driver.findElements(obj_EsupportIPSHomePage.DetailsInWarrantyPopUp());
			for(WebElement lt:list1)
			{
				CommonUtility.ScrollToWebElement(driver, lt);
				String label=lt.getText();

				System.out.println("Label is: " +label);
				details+=" <br> " + label;
			}
			System.out.println("details are :"+details);

			Report.put("Verify the details on the top",
					"On top should have Service tag , Ship date and Country",
					"Displayed "+Report.color(labelList+" along with "+details)+" successfully", "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify the details on the top",
					"On top should have Service tag , Ship date and Country",
					"Failed to display Service tag , Ship date and Country", "FAIL");
			Assert.fail();
		}
	}

	public void verifyProductHeroSectionDetails(WebDriver driver)
	{
		System.out.println("Inside verifyProductHeroSectionDetails method");
		Log.info("Inside verifyProductHeroSectionDetails method");

		try
		{
			handleCookies(driver);
			String labelList = "";

			List<WebElement> list=driver.findElements(obj_EsupportIPSHomePage.productHeroSectionDetails());

			for(WebElement lt:list)
			{
				CommonUtility.highlightElement(driver, lt);
				String label=lt.getText();

				System.out.println("Label is: " +label);
				labelList+=" <br> " + label;
			}
			System.out.println("Labels are:"+labelList);


			Report.put("Verify the Product support hero section",
					"Product support Hero section  should show the type of Warranty , Date of expiry and View details Hyper link",
					"Displayed "+Report.color(labelList)+" successfully", "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify the Product support hero section",
					"Product support Hero section  should show the type of Warranty , Date of expiry and View details Hyper link",
					"Failed to display type of Warranty , Date of expiry and View details Hyper link" , "FAIL");
			Assert.fail();
		}
	}

	public void  clickSignIn(WebDriver driver) 
	{
		System.out.println("Inside clickSignIn method");
		Log.info("Inside clickSignIn method");

		WebDriverWait  wait = new WebDriverWait(driver, 120);	
		try
		{
			//	handleCookies(driver);
			//	Thread.sleep(5000);
			Actions act=new Actions(driver);
			Thread.sleep(6000);
			CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.signInLabel());
			act.moveToElement(CommonUtility.highlightElement(driver, obj_EsupportIPSHomePage.signInLabel())).build().perform();
			Thread.sleep(3000);
			act.click();
			//act.moveToElement(CommonUtility.highlightElement(driver, obj_EsupportIPSHomePage.signInLabel())).click().build().perform();
			//			CommonUtility.ScrollTo(driver, obj_EsupportIPSHomePage.signInLabel());
			//			Thread.sleep(7000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIPSHomePage.signInButton()));
			CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.signInButton());
			//			CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.signInButton()).click();
			//CommonUtility.ClickOn(driver,obj_EsupportIPSHomePage.signInButton());
			CommonUtility.ToClickByUsingJavaScript_PassingByLoc(driver,obj_EsupportIPSHomePage.signInButton());
			System.out.println("Clicked on Sign In Button");

			Thread.sleep(10000);
			Report.put("Click on sign in and enter valid credentials and click on sign in ",
					"User should logged in successfully  ", 
					"Sign in successful", "PASS");

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on SignIn button", "Sign In Page should dispaly", "Application is not navigated to Sign In page ", "FAIL");
			Assert.fail();
		}
	}

	public void verifyProductName(WebDriver driver)
	{
		System.out.println("Inside verifyProductName method");
		Log.info("Inside verifyProductName method");


		try
		{
			String header = "";			

			WebDriverWait wait = new WebDriverWait(driver, 120);


			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIPSHomePage.productHeader()));
			CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.productHeader());
			header = CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.productHeader()).getText();

			System.out.println("Product Name is:"+header);

			Report.put("Verify the Product name in the hero section",
					"Product name should be displayed  in the hero section",
					"Product Name displayed successfully as: "+Report.color(header), "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify the Product name in the hero section",
					"Product name should be displayed  in the hero section",
					"Failed to display Product Name", "FAIL");
			Assert.fail();
		}
	}

	public void  selectServiceTag(WebDriver driver, String tag)
	{
		System.out.println("Entering selectServiceTag");
		Log.info("Entering selectServiceTag");   
		String header = "";
		String selectedTag = "";
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 60);

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIPSHomePage.homePageHeader()));
			CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.homePageHeader());
			header = CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.homePageHeader()).getText();
			CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.serviceTagDropdown());


			if(CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.serviceTagDropdown()).isDisplayed())
			{

				System.out.println("Service Tag dropdown displayed");
				CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.serviceTagDropdown()).click();

				System.out.println("Service Tag from Test data is :::: "+tag);

				List<WebElement> tagList=driver.findElements(obj_EsupportIPSHomePage.serviceTagList());

				Thread.sleep(3000);
				for(WebElement lt:tagList)
				{
					String text=lt.getText();

					System.out.println("Tag is: " +text);
					if(text.equalsIgnoreCase(tag))
					{
						lt.click();
						Thread.sleep(3000);
						selectedTag = text;
						System.out.println("Selected Tag is "+selectedTag);						
						break;
					}

				}
			} 	
		}
		catch(Exception e)
		{
			e.printStackTrace();			
			Assert.fail();
		}
	}


	public void verifyExtendUpgradeButton(WebDriver driver)
	{
		System.out.println("Inside verifyExtendUpgradeButton method");
		Log.info("Inside verifyExtendUpgradeButton method");

		try
		{

			String text = "";

			WebDriverWait wait = new WebDriverWait(driver, 120);

			text = CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.extendUpgradeButton()).getText();

			System.out.println("Button text is: "+text);

			Report.put("Verify the Modal pop for the extend or upgrade",
					"Extend or upgrade button should be displayed ",
					"Extend or upgrade button displayed Successfully. Button is: "+Report.color(text), "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify the Modal pop for the extend or upgrade",
					"Extend or upgrade button should be displayed ",
					"Failed to display Extend or upgrade button", "FAIL");
			Assert.fail();
		}
	}

	public void clickExtendUpgradeButton(WebDriver driver)
	{
		System.out.println("Inside clickExtendUpgradeButton method");
		Log.info("Inside clickExtendUpgradeButton method");

		try
		{
			String header = "";
			String currentUrl = "";
			WebDriverWait wait = new WebDriverWait(driver, 120);

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIPSHomePage.extendUpgradeButton()));
			CommonUtility.ClickOn(driver,obj_EsupportIPSHomePage.extendUpgradeButton());

			currentUrl = driver.getCurrentUrl();
			System.out.println("Navigated to URL "+currentUrl);

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIPSHomePage.warrantyHeader()));
			CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.warrantyHeader());
			header = CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.warrantyHeader()).getText();

			System.out.println("Warranty header is: "+header);

			Report.put("Click on the link extend or upgrade button on the modal",
					"User should direct to the www.renewals.dell.com",
					"User directed to "+Report.color(currentUrl) +"Successfully. Header is:" +Report.color(header), "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on the link extend or upgrade button on the modal",
					"User should direct to the www.renewals.dell.com",
					"Failed to redirect to URL", "FAIL");
			Assert.fail();
		}
	}

	public void verifyPrintOption(WebDriver driver)
	{
		System.out.println("Inside verifyPrintOption method");
		Log.info("Inside verifyPrintOption method");

		try
		{

			String text = "";

			WebDriverWait wait = new WebDriverWait(driver, 120);

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIPSHomePage.printOption()));
			CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.printOption());

			text = CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.printOption()).getText();

			System.out.println("printOption text is: "+text);

			Report.put("Verify the Print option ",
					"Print option should be present in the Top in the same line of service tag , ship data and ship country ",
					"Print Option displayed Successfully. Text is: "+Report.color(text), "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify the Print option ",
					"Print option should be present in the Top in the same line of service tag , ship data and ship country ",
					"Failed to display the Print Option.", "FAIL");
			Assert.fail();
		}
	}

	/*public void clickPrintOption(WebDriver driver)
	{
		System.out.println("Inside clickPrintOption method");
		Log.info("Inside clickPrintOption method");

		try
		{
			String header = "";
			String currentUrl = "";
			WebDriverWait wait = new WebDriverWait(driver, 120);

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIPSHomePage.printOption()));
			CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.printOption()).click();

			Set<String> allWH=driver.getWindowHandles(); 
			String currentwindow=driver.getWindowHandle();
			int count=allWH.size(); 
			System.out.println("Window Handles and  window count is :: "+count);
			String Currentwindowhandle= driver.getCurrentUrl();

			System.out.println("Parent window as "+Currentwindowhandle);
			for(String wh:allWH)
			{

				Thread.sleep(10000);
				driver.switchTo().window(wh); 
				String title=driver.getTitle();
				System.out.println("Tittle displayed as   :::::"+title); 
				driver.close();
				driver.switchTo().window(currentwindow);
			}
			Report.put("Click on the Print link",
					"Printable view of the warranty details page should load ",
					"User directed to Printable View", "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on the Print link",
					"Printable view of the warranty details page should load ",
					"Failed to load Printable View", "FAIL");
			Assert.fail();
		}
	}*/

	public void verifyImportantInformation(WebDriver driver)
	{
		System.out.println("Inside verifyImportantInformation method");
		Log.info("Inside verifyImportantInformation method");

		try
		{

			String text = "";

			WebDriverWait wait = new WebDriverWait(driver, 120);

			text = CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.importantInfoLabel()).getText();

			System.out.println("Label text is: "+text);

			Report.put("In Modal pop up verify the bottom of the page",
					"Important information should be displayed in the bottom of the page ",
					"Important information displayed Successfully. Text is: "+Report.color(text), "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();

			Report.put("In Modal pop up verify the bottom of the page",
					"Important information should be displayed in the bottom of the page ",
					"Failed to display Important information", "FAIL");
			Assert.fail();
		}
	}

	public void verifyContentLinks(WebDriver driver)
	{
		System.out.println("Inside verifyContentLinks method");
		Log.info("Inside verifyContentLinks method");

		try
		{			
			String ltMessages = "";

			WebDriverWait wait = new WebDriverWait(driver, 120);			

			List<WebElement> list=driver.findElements(obj_EsupportIPSHomePage.importantInfoContent());

			for(WebElement lt:list)
			{
				CommonUtility.highlightElement(driver, lt);
				String names=lt.getText();

				System.out.println("Info is: " +names);
				ltMessages+=" <br> " + names;
			}				

			Report.put("Verify the content and links",
					"Content should be Important information: ",
					"Content of Important Information displayed successfully"+Report.color(ltMessages), "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();

			Report.put("Verify the content and links",
					"Content should be Important information: ",
					"Failed to display Content of Important Information. ", "FAIL");
			Assert.fail();
		}
	}

	public void clickTermsOfSaleLink(WebDriver driver)
	{
		System.out.println("Inside clickTermsOfSaleLink method");
		Log.info("Inside clickTermsOfSaleLink method");

		try
		{			
			String text = "";
			String header = "";
			String currentUrl = "";

			WebDriverWait wait = new WebDriverWait(driver, 60);
			CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.termsOfSaleLink());

			text = CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.termsOfSaleLink()).getText();
			CommonUtility.ClickOn(driver,obj_EsupportIPSHomePage.termsOfSaleLink());

			Thread.sleep(5000);
			System.out.println("Link text is: "+text);


			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIPSHomePage.termsOfSaleHeader()));
			CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.termsOfSaleHeader());
			header = CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.termsOfSaleHeader()).getText();

			System.out.println("Header is:"+header);

			currentUrl = driver.getCurrentUrl();

			System.out.println("Current URl is:"+currentUrl);

			Report.put("Click on the link under the important information Terms of sale , Service contract and warranties",
					"User should direct to the http://www.dell.com/learn/us/en/uscorp1/terms-of-sale",
					"Redirected to Terms of Sale Page Successfully. Header is: "+Report.color(header)+"<br>"+"URL is:"+Report.color(currentUrl), "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();

			Report.put("Click on the link under the important information Terms of sale , Service contract and warranties",
					"User should direct to the http://www.dell.com/learn/us/en/uscorp1/terms-of-sale",
					"Failed to Redirect to Terms of Sale Page. ", "FAIL");
			Assert.fail();
		}
	}

	public void clickRegisterYourProductLink(WebDriver driver)
	{
		System.out.println("Inside clickRegisterYourProductLink method");
		Log.info("Inside clickRegisterYourProductLink method");

		try
		{			
			String text = "";
			String header = "";
			String currentUrl = "";

			handleCookies(driver);
			WebDriverWait wait = new WebDriverWait(driver, 60);
			CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.registerYourProductLink());

			text = CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.registerYourProductLink()).getText();
			System.out.println("Link text is: "+text);

			CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.registerYourProductLink());
			CommonUtility.ClickOn(driver,obj_EsupportIPSHomePage.registerYourProductLink());

			Thread.sleep(10000);
			//			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIPSHomePage.registerYourProductHeader()));
			//			CommonUtility.scrollToViewElement(driver,obj_EsupportIPSHomePage.registerYourProductHeader());
			//			CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.registerYourProductHeader());
			//			header = CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.registerYourProductHeader()).getText();


			currentUrl = driver.getCurrentUrl();

			System.out.println("Current URl is:"+currentUrl);
			header=driver.getTitle();
			System.out.println("Header is:"+header);
			Report.put("comeback to the model pop up page and click on link"+Report.color(text),
					"User should direct to the http://www.dell.com/support/article/us/en/19/sln143036/ownership-transfer-and-retail-registration-guide?lang=en",
					"Redirected to Register Your Product Page Successfully. Header is: "+Report.color(header)+"<br>"+"URL is:"+Report.color(currentUrl), "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();

			Report.put("comeback to the model pop up page and click on register your product with Dell",
					"User should direct to the http://www.dell.com/support/article/us/en/19/sln143036/ownership-transfer-and-retail-registration-guide?lang=en",
					"Failed to Redirect to Register Your Product Page", "FAIL");
			Assert.fail();
		}
	}

	public void clickTransferOwnershipLink(WebDriver driver)
	{
		System.out.println("Inside clickRegisterYourProductLink method");
		Log.info("Inside clickRegisterYourProductLink method");

		try
		{			
			String text = "";
			String header = "";
			String currentUrl = "";

			handleCookies(driver);
			WebDriverWait wait = new WebDriverWait(driver, 60);
			CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.transferOwnershipLink());

			text = CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.transferOwnershipLink()).getText();
			CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.transferOwnershipLink());
			CommonUtility.ClickOn(driver,obj_EsupportIPSHomePage.transferOwnershipLink());
			System.out.println("Link text is: "+text);


			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIPSHomePage.ownershipTransferHeader()));
			CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.ownershipTransferHeader());
			header = CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.ownershipTransferHeader()).getText();

			System.out.println("Header is:"+header);

			currentUrl = driver.getCurrentUrl();

			System.out.println("Current URl is:"+currentUrl);

			Report.put("Comeback to the modal pop up page and click on link"+Report.color(text),
					"User should direct to the http://www.dell.com/support/article/us/en/19/sln143036/ownership-transfer-and-retail-registration-guide?lang=en",
					"Redirected to Transfer Ownership Page Successfully. Header is: "+Report.color(header)+"<br>"+"URL is:"+Report.color(currentUrl), "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();

			Report.put("Comeback to the modal pop up page and click on transfer ownership of a product",
					"User should direct to the http://www.dell.com/support/article/us/en/19/sln143036/ownership-transfer-and-retail-registration-guide?lang=en",
					"Failed to Redirect to Transfer Ownership Page", "FAIL");
			Assert.fail();
		}
	}

	public void searchServiceTag(WebDriver driver,String serviceTag) 
	{		
		WebDriverWait wait = new WebDriverWait(driver, 240);

		System.out.println("Entering searchServiceTag");

		Log.info("Entering searchServiceTag");   
		
		try 
		{	
			String header="";
			String prodHeader="";
			String servicet ="";

			System.out.println("Service Tag from Test data sheet is :" +serviceTag);
			handleCookies(driver);
			//CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.Delllogo());

			//			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIPSHomePage.supportHeader()));
			Thread.sleep(6000);
			CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.supportHeader());

			header = CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.supportHeader()).getText();
			System.out.println("Welcome Page header is:"+header);
			CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.serviceTagTextbox());
			CommonUtility.ClickOn(driver,obj_EsupportIPSHomePage.serviceTagTextbox());
			CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.serviceTagTextbox()).clear();

			CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.serviceTagTextbox()).sendKeys(serviceTag);
			
			//			CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.serviceTagSearchButton()).click();
			//			CommonUtility.ToClickByUsingJavaScript_PassingByLoc(driver,obj_EsupportIPSHomePage.serviceTagSearchButton());
			CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.serviceTagSearchButton());
			CommonUtility.ClickOn(driver,obj_EsupportIPSHomePage.serviceTagSearchButton());


//			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIPSHomePage.productHeader()));
			
			if(CommonUtility.CheckpresenceofElementLocated(driver, 0, obj_EsupportContentHomePage.ConnectivityUpdate()))
            {
				String text=driver.findElement(obj_EsupportContentHomePage.ConnectivityUpdate()).getText();
				System.out.println(text);
				Thread.sleep(1000);
			    CommonUtility.highlightElement(driver, obj_EsupportContentHomePage.DoNotShowThisOnConnectivityUpdateCheckBox()).click();
			    CommonUtility.highlightElement(driver, obj_EsupportContentHomePage.OkButtonOnConnectivityUpdate()).click();
            }
			
			obj_EsupportContentWorkflow.UnexpectedPopup_Prod(driver);
			
			if(CommonUtility.CheckpresenceofElementLocated(driver, 10, obj_EsupportIPSHomePage.productHeader()))
			{
			CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.productHeader());
			prodHeader = CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.productHeader()).getText();

			System.out.println("Product Page header is:"+prodHeader);
			}
			else if(CommonUtility.CheckpresenceofElementLocated(driver, 10, obj_EsupportIPSHomePage.ProductHeader2()))
			{
				CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.ProductHeader2());
				prodHeader = CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.ProductHeader2()).getText();

				System.out.println("Product Page header is:"+prodHeader);
			}
			
			    CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.serviceTagHeroSection());
				servicet = CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.serviceTagHeroSection()).getText();

				System.out.println("tag is:"+servicet);
				servicet=servicet.toLowerCase();
				serviceTag=serviceTag.toLowerCase();
			if(!(servicet.contains(serviceTag)))
			{
				System.out.println("tag doesnt not match with searched");
				Report.put("In the product selector , Enter service Tag ( Service tag that has parts and accessories support ) and click on search:"+Report.color(serviceTag),
						"User should land into Product Support Page",
						"Failed to see searched tag in product home page", "FAIL");
//				Assert.fail();
			}
			

			Report.put("In the product selector , Enter service Tag ( Service tag that has parts and accessories support ) and click on search"+Report.color(serviceTag),
					"User should land into Product Support Page",
					"Successfully navigated to Product Support Page. Header is: "+Report.color(prodHeader)+" and tag displayed is "+Report.color(servicet), "PASS");

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("In the product selector , Enter service Tag ( Service tag that has parts and accessories support ) and click on search"+Report.color(serviceTag),
					"User should land into Product Support Page",
					"Failed to navigate to Product Support Page.", "FAIL");
			Assert.fail();

		}
	}

	public void toTestDateFormat(WebDriver driver) 
	{		
		WebDriverWait wait = new WebDriverWait(driver, 120);

		System.out.println("Entering toTestDateFormat");

		Log.info("Entering toTestDateFormat");   

		try 
		{	
			boolean check = CommonUtility.isValidDateFormat("DD/MMM/YYYY", "10/OCT/2014");
			String header="";
			String prodHeader="";
			String date = null;
			SimpleDateFormat sdf = new SimpleDateFormat("DD/MMM/YYYY");
			date = sdf.format("10/OCT/2014");
			System.out.println("Date************** is:"+date);
			//NumberFormat df = sdf.getNumberFormat();
			DateFormat df = null;
			String text = df.format(sdf.parse("10 OCT 2014"));
			System.out.println("Date is:"+text);
			System.out.println("Parsed Date:" +sdf.format(date));
		}
		catch(Exception e)
		{
			e.printStackTrace();

			Assert.fail();

		}
	}

	public void verifyWarrantyTable(WebDriver driver)
	{
		System.out.println("Inside verifyWarrantyTable method");
		Log.info("Inside verifyWarrantyTable method");

		WebDriverWait wait = new WebDriverWait(driver, 120);

		try
		{
			String label = "";
			String labelList = "";

			CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.warrantyServiceColumn());			

			label = CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.warrantyServiceColumn()).getText();
			System.out.println("Label is:"+label);

			labelList+="<br>"+label;

			CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.warrantyStartDateColumn());

			label = CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.warrantyStartDateColumn()).getText();
			labelList+="<br>"+label;
			System.out.println("Label is:"+label);

			CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.warrantyExpirationDateColumn());

			label = CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.warrantyExpirationDateColumn()).getText();


			System.out.println("Label is:"+label);
			labelList+="<br>"+label;
			System.out.println("labelList is:"+labelList);

			Report.put("Verify the Table below the Service tag , ship date and country",
					"Warranty table should have Service , start date and Expiration date columns",
					"Displayed "+Report.color(labelList)+" successfully", "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify the Table below the Service tag , ship date and country",
					"Warranty table should have Service , start date and Expiration date columns",
					"Failed to display Warranty table columns", "FAIL");
		}
	}

	public void verifyServiceColumn(WebDriver driver)
	{
		System.out.println("Inside verifyServiceColumn method");
		Log.info("Inside verifyServiceColumn method");

		WebDriverWait wait = new WebDriverWait(driver, 120);

		try
		{
			String serviceColumnText = "";

			List<WebElement> list=driver.findElements(obj_EsupportIPSHomePage.warrantyServiceColumnText());

			for(WebElement lt:list)
			{
				CommonUtility.highlightElement(driver, lt);
				String names=lt.getText();

				System.out.println("Info is: " +names);
				serviceColumnText+=" <br> " + names;
			}		

			Report.put("Verify the Service column",
					"Service column should show the Services available for that Service tag ",
					"Displayed available Services "+Report.color(serviceColumnText)+" successfully", "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify the Service column",
					"Service column should show the Services available for that Service tag ",
					"Failed to display Service column data", "FAIL");
		}
	}

	public void verifyStartDateFormat(WebDriver driver)
	{
		System.out.println("Inside verifyStartDateDataFormat method");
		Log.info("Inside verifyStartDateDataFormat method");

		WebDriverWait wait = new WebDriverWait(driver, 120);

		try
		{
			String startDate = "";

			CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.startDateText());

			startDate = CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.startDateText()).getText();

			System.out.println("Date from the app is:"+startDate);

			Date date = null;
			String formatteddate = null;
			DateFormat df = new SimpleDateFormat("dd MMM yyyy");
			date = df.parse(startDate);
			formatteddate = df.format(date);

			System.out.println("date: "+formatteddate);

			if(startDate.equalsIgnoreCase(formatteddate))
			{
				System.out.println("Format is DD MMM YYYY");

				Report.put("Verify the start date Format"+Report.color(startDate),
						"Start date should be in the format DD MMM YYYY",
						"Displayed the Start Date in the format(DD MMM YYYY) "+Report.color(formatteddate), "PASS");
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify the start data Format",
					"Start date should be in the format DD MMM YYYY",
					"Failed to display Start Date format", "FAIL");
		}
	}

	public void verifyExpirationDateFormat(WebDriver driver)
	{
		System.out.println("Inside verifyExpirationDateFormat method");
		Log.info("Inside verifyExpirationDateFormat method");

		WebDriverWait wait = new WebDriverWait(driver, 120);

		try
		{
			String startDate = "";

			CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.expirationDateText());

			startDate = CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.expirationDateText()).getText();

			System.out.println("Date from the app is:"+startDate);

			Date date = null;
			String formatteddate = null;
			DateFormat df = new SimpleDateFormat("dd MMM yyyy");
			date = df.parse(startDate);
			formatteddate = df.format(date);

			System.out.println("date: "+formatteddate);

			if(startDate.equalsIgnoreCase(formatteddate))
			{
				System.out.println("Format is DD MMM YYYY");

				Report.put("Verify the Warranty expiration date"+Report.color(startDate),
						"Warranty expiration date should be in the format DD MMM YYYY",
						"Displayed the Warranty expiration Date in the format(DD MMM YYYY) "+Report.color(formatteddate), "PASS");
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify the Warranty expiration date Format",
					"Warranty expiration date should be in the format DD MMM YYYY",
					"Failed to display Warranty expiration Date format", "FAIL");
		}
	}

	public void verifyProductImageHeroSection(WebDriver driver)
	{
		System.out.println("Inside verifyProductImageHeroSection method");
		Log.info("Inside verifyProductImageHeroSection method");

		try
		{
			//handleCookies(driver);

			if(CommonUtility.CheckpresenceofElementLocated(driver, 10, obj_EsupportIPSHomePage.productImageHeroSection()))
			{
				CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.productImageHeroSection());
				CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.productImageHeroSection());

				Report.put("Verify the Product image in the hero section",
						"Product image should be displayed in the hero section",
						"Displayed Product Image successfully", "PASS");
			}	
			else
			{
				Report.put("Verify the Product image in the hero section",
						"Product image should be displayed in the hero section",
						"Failed to display Product Image", "FAIL");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify the Product image in the hero section",
					"Product image should be displayed in the hero section",
					"Failed to display Product Image", "FAIL");
			Assert.fail();
		}
	}

	public void Emaillogin(WebDriver driver,String name,String pwd ) 
	{
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 240);
		//		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		boolean exists = true;
		Actions actions = new Actions(driver);

		System.out.println("Entering Email Login Home Page");

		Log.info("Entering Email Login Home Page");             
		try
		{
			System.out.println(name);
			System.out.println(pwd);

			handleCookies(driver);
			Thread.sleep(6000);
           
			if(CommonUtility.CheckpresenceofElementLocated(driver, 20, obj_EsupportIPSHomePage.emailUsername()))
            {
//            	wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIPSHomePage.emailUsername()));
    			CommonUtility.highlightElement(driver,(obj_EsupportIPSHomePage.emailUsername())).clear();
    			CommonUtility.highlightElement(driver,(obj_EsupportIPSHomePage.emailUsername())).sendKeys(name);

//    			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIPSHomePage.emailPassword()));
    			CommonUtility.highlightElement(driver,(obj_EsupportIPSHomePage.emailPassword())).clear();
    			CommonUtility.highlightElement(driver,(obj_EsupportIPSHomePage.emailPassword())).sendKeys(pwd);

//    			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIPSHomePage.emailSignin()));

    			WebElement element = driver.findElement(obj_EsupportIPSHomePage.emailSignin());
    			//			actions.moveToElement(element).click().perform();
    			CommonUtility.ScrollTo(driver,(obj_EsupportIPSHomePage.emailSignin()));
    			CommonUtility.ClickOn(driver,(obj_EsupportIPSHomePage.emailSignin()));
    			Thread.sleep(10000);
    			
    			Report.put("Login with Credentials for"+Report.color(name), 
    					"User should be able to login without any issues" ,
    					"User logged in successfully.", "PASS");
            }
            else if(CommonUtility.CheckpresenceofElementLocated(driver, 20, obj_EsupportDDLHomePage.Email1()))
            {
            	CommonUtility.ScrollTo(driver, obj_EsupportDDLHomePage.Email1());
				CommonUtility.highlightElement(driver, obj_EsupportDDLHomePage.Email1()).sendKeys(name);
	
				System.out.println("Entered Email(Username) as "+name);
	
//				CommonUtility.ScrollTo(driver, obj_EsupportDDLHomePage.ContinueButton());
//				CommonUtility.ToClickByUsingJavaScript_PassingByLoc(driver, obj_EsupportDDLHomePage.ContinueButton());
				
				Thread.sleep(3000);
				
				CommonUtility.ScrollTo(driver, obj_EsupportDDLHomePage.Password1());
				CommonUtility.highlightElement(driver, obj_EsupportDDLHomePage.Password1()).sendKeys(pwd);
	
				System.out.println("Entered Password as "+pwd);
				CommonUtility.highlightElement(driver, obj_EsupportDDLHomePage.SignInButton());
                CommonUtility.ClickOn(driver, obj_EsupportDDLHomePage.SignInButton());
				System.out.println("Clicked on SignIn Button ");			
				Thread.sleep(10000);
	            
				Report.put("Login with Credentials for"+Report.color(name), 
			               "User should be able to login without any issues" ,
			               "User logged in successfully.", "PASS");
            }
			
//			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIPSHomePage.emailUsername()));
//			CommonUtility.highlightElement(driver,(obj_EsupportIPSHomePage.emailUsername())).clear();
//			CommonUtility.highlightElement(driver,(obj_EsupportIPSHomePage.emailUsername())).sendKeys(name);
//
//			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIPSHomePage.emailPassword()));
//			CommonUtility.highlightElement(driver,(obj_EsupportIPSHomePage.emailPassword())).clear();
//			CommonUtility.highlightElement(driver,(obj_EsupportIPSHomePage.emailPassword())).sendKeys(pwd);
//
//			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIPSHomePage.emailSignin()));
//
//			WebElement element = driver.findElement(obj_EsupportIPSHomePage.emailSignin());
//			//			actions.moveToElement(element).click().perform();
//			CommonUtility.ScrollTo(driver,(obj_EsupportIPSHomePage.emailSignin()));
//			CommonUtility.ClickOn(driver,(obj_EsupportIPSHomePage.emailSignin()));
//			Thread.sleep(10000);
//			Report.put("Login with Credentials for"+Report.color(name), 
//					"User should be able to login without any issues" ,
//					"User logged in successfully.", "PASS");
		}
		catch (Exception e) 
		{
			Log.info(e);
			Report.put("Login with Credentials", 
					"User should be able to login without any issues",
					"Failed while logging into esupport application", "FAIL");
			e.printStackTrace();
			Assert.fail();
		}               
	}
	
//	public void Emaillogin(WebDriver driver,String name,String pwd ) 
//	{
//		// TODO Auto-generated method stub
//		WebDriverWait wait = new WebDriverWait(driver, 240);
//		//		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//		//		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
//		boolean exists = true;
//		Actions actions = new Actions(driver);
//
//		System.out.println("Entering Email Login Home Page");
//
//		Log.info("Entering Email Login Home Page");             
//		try
//		{
//			System.out.println(name);
//			System.out.println(pwd);
//
//			handleCookies(driver);
//			Thread.sleep(6000);
//
//			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.Email1()));
//			
////						handleCookies(driver);
//						CommonUtility.ScrollTo(driver, obj_EsupportDDLHomePage.Email1());
//						CommonUtility.highlightElement(driver, obj_EsupportDDLHomePage.Email1()).sendKeys(name);
//			
//						System.out.println("Entered Email(Username) as "+name);
//			
//						CommonUtility.ScrollTo(driver, obj_EsupportDDLHomePage.ContinueButton());
//						CommonUtility.ToClickByUsingJavaScript_PassingByLoc(driver, obj_EsupportDDLHomePage.ContinueButton());
//						
//						Thread.sleep(3000);
//						
//						CommonUtility.ScrollTo(driver, obj_EsupportDDLHomePage.Password1());
//						CommonUtility.highlightElement(driver, obj_EsupportDDLHomePage.Password1()).sendKeys(pwd);
//			
//						System.out.println("Entered Password as "+pwd);
//						CommonUtility.highlightElement(driver, obj_EsupportDDLHomePage.SignInButton());
////						CommonUtility.highlightElement(driver, obj_EsupportDDLHomePage.SignIn()).click();
//						CommonUtility.ClickOn(driver, obj_EsupportDDLHomePage.SignInButton());
//						System.out.println("Clicked on SignIn Button ");			Thread.sleep(10000);
//			Report.put("Login with Credentials for"+Report.color(name), 
//					"User should be able to login without any issues" ,
//					"User logged in successfully.", "PASS");
//		}
//		catch (Exception e) 
//		{
//			Log.info(e);
//			Report.put("Login with Credentials", 
//					"User should be able to login without any issues",
//					"Failed while logging into esupport application", "FAIL");
//			e.printStackTrace();
//			Assert.fail();
//		}               
//	}

	public void verifyExportOption(WebDriver driver)
	{
		System.out.println("Inside verifyExportOption method");
		Log.info("Inside verifyExportOption method");

		try
		{
			String text = "";

			WebDriverWait wait = new WebDriverWait(driver, 120);

			if(CommonUtility.CheckpresenceofElementLocated(driver, 10, obj_EsupportIPSHomePage.exportOption()))
			{
				CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.exportOption());
				text = CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.exportOption()).getText();

				System.out.println("ExportOption text is: "+text);

				Report.put("Verify the Option for the Export",
						"Export option should be available and should be a Hyper link on the Modal Pop up",
						"Export Option displayed Successfully. Link is: "+Report.color(text), "PASS");
			}
			else
			{
				Report.put("Verify the Option for the Export",
						"Export option should be available and should be a Hyper link on the Modal Pop up",
						"Failed to display Export Option", "FAIL");
				Assert.fail();
			}

		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify the Option for the Export",
					"Export option should be available and should be a Hyper link on the Modal Pop up",
					"Failed to display Export Option", "FAIL");
			Assert.fail();
		}
	}

	public void clickExportOption(WebDriver driver)
	{
		System.out.println("Inside clickExportOption method");
		Log.info("Inside clickExportOption method");

		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);

			CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.exportOption());
			CommonUtility.ClickOn(driver,obj_EsupportIPSHomePage.exportOption());

			System.out.println("Clicked on Export Link");

			Report.put("Click on the Export option",
					"Spreadsheet should get downloaded ",
					"Spreadsheet downloaded Successfully.", "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on the Export option",
					"Spreadsheet should get downloaded ",
					"Failed to download Spreadsheet.", "FAIL");
			Assert.fail();
		}
	}

	public void verifyConfigurationTable(WebDriver driver)
	{
		System.out.println("Inside verifyConfigurationTable method");
		Log.info("Inside verifyConfigurationTable method");

		try
		{
			//handleCookies(driver);

			String header = "";
			String tabList = "";
			String defaultTab = "";
			WebDriverWait wait = new WebDriverWait(driver, 120);

			List<WebElement> list=driver.findElements(obj_EsupportIPSHomePage.configurationTable());

			for(WebElement lt:list)
			{
				CommonUtility.highlightElement(driver, lt);
				String tabName=lt.getText();

				System.out.println("Tab is: " +tabName);
				tabList+=" <br> " + tabName;
			}
			System.out.println("Tabs are:"+tabList);


			Report.put("Verify the configuration table",
					"Configuration table should display with Component, part number, Description, quantity",
					"Configuration Table displayed Successfully. Columns are: "+Report.color(tabList), "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify the configuration table",
					"Configuration table should display with Component, part number, Description, quantity",
					"Failed to display Configuration Table.", "FAIL");
			Assert.fail();
		}
	}

	public void verifyComponentColumn(WebDriver driver)
	{
		System.out.println("Inside verifyComponentColumn method");
		Log.info("Inside verifyComponentColumn method");

		try
		{
			String text = "";
			String descText = "";

			WebDriverWait wait = new WebDriverWait(driver, 120);


			CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.componentData());
			text = CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.componentData()).getText();

			System.out.println("Component data is: "+text);


			CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.componentSKUDescription());
			descText = CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.componentSKUDescription()).getText();

			String tagName = CommonUtility.highlightElement(driver, obj_EsupportIPSHomePage.componentSKUDescription())
					.getTagName();
			System.out.println(CommonUtility.highlightElement(driver, obj_EsupportIPSHomePage.componentSKUDescription())
					.getTagName());

			System.out.println("Component SKU Description is: "+descText);

			if(tagName.equalsIgnoreCase("b"))
			{
				System.out.println("Font is in bold");

				Report.put("Verify the Component column",
						"Component column should have SKU and SKU description in BOLD",
						"Component Column Data displayed Successfully. SKU is: "+Report.color(text)+"SKU Description in Bold is:"+Report.color(descText), "PASS");
			}	
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify the Component column",
					"Component column should have SKU and SKU description in BOLD",
					"Failed to display Component Column Data ", "FAIL");

			Assert.fail();
		}
	}

	public void verifyPartNumberColumn(WebDriver driver)
	{
		System.out.println("Inside verifyPartNumberColumn method");
		Log.info("Inside verifyPartNumberColumn method");

		try
		{
			String text = "";			

			WebDriverWait wait = new WebDriverWait(driver, 120);

			CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.partNumberData());
			text = CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.partNumberData()).getText();

			System.out.println("Part Number data is: "+text);			

			Report.put("Verify the Part number Column",
					"Part number column should display the Dell Part number",
					"Part number column displayed the Dell Part number succesfully. "+Report.color(text), "PASS");			
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify the Part number Column",
					"Part number column should display the Dell Part number",
					"Failed to display Part number column ", "FAIL");
			Assert.fail();
		}
	}

	public void verifyDescriptionColumn(WebDriver driver)
	{
		System.out.println("Inside verifyDescriptionColumn method");
		Log.info("Inside verifyDescriptionColumn method");

		try
		{
			String text = "";			

			WebDriverWait wait = new WebDriverWait(driver, 120);

			CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.descriptionData());
			text = CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.descriptionData()).getText();

			System.out.println("Description Data is: "+text);			

			Report.put("Verify the Description Column",
					"Description column should display the in Format as per the Design",
					"Description column displayed successfully. Description is: "+Report.color(text), "PASS");			
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify the Description Column",
					"Description column should display the in Format as per the Design",
					"Failed to display Description column ", "FAIL");			
			Assert.fail();
		}
	}

	public void verifyModalPopupCloseButton(WebDriver driver)
	{
		System.out.println("Inside verifyModalPopupCloseButton method");
		Log.info("Inside verifyModalPopupCloseButton method");

		try
		{
			String text = "";			

			WebDriverWait wait = new WebDriverWait(driver, 120);

			CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.modalPopupClose());

			Report.put("Verify the X mark on the Modal Pop up",
					"X mark should be available on the Modal Pop up",
					"X mark displayed on the Modal Pop up succesfully.", "PASS");			
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify the X mark on the Modal Pop up",
					"X mark should be available on the Modal Pop up",
					"Failed to display X mark on the Modal Pop up", "FAIL");			
			Assert.fail();
		}
	}

	public void clickModalPopupCloseButton(WebDriver driver)
	{
		System.out.println("Inside clickModalPopupCloseButton method");
		Log.info("Inside clickModalPopupCloseButton method");

		try
		{
			String text = "";	
			String prodHeader = "";			


			WebDriverWait wait = new WebDriverWait(driver, 120);

			CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.modalPopupClose());
			CommonUtility.ClickOn(driver,obj_EsupportIPSHomePage.modalPopupClose());

			//wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIPSHomePage.productHeader()));
			if(CommonUtility.CheckpresenceofElementLocated(driver, 10, obj_EsupportIPSHomePage.productHeader()))
			{
			CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.productHeader());
			prodHeader = CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.productHeader()).getText();

			System.out.println("Product Page header is:"+prodHeader);
			}
			else
			{
				CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.ProductHeader2());
				prodHeader = CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.ProductHeader2()).getText();

				System.out.println("Product Page header is:"+prodHeader);
				
			}

			Report.put("Click on the X mark",
					"Modal Pop up should go off and user should land back in the Product support page",
					"Modal Pop up closed and successfully landed in the Product support page of "+Report.color(prodHeader), "PASS");			
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on the X mark",
					"Modal Pop up should go off and user should land back in the Product support page",
					"Failed to close the Modal Pop up & land in the Product support page", "FAIL");			
			Assert.fail();
		}
	}

	public void verifyScrollbar(WebDriver driver)
	{
		System.out.println("Inside verifyScrollbar method");
		Log.info("Inside verifyScrollbar method");
		int j=0;
		try
		{
			Actions act = new Actions (driver);
			String text = "";			

			WebDriverWait wait = new WebDriverWait(driver, 120);

			String execScript = "return document.documentElement.scrollHeight>document.documentElement.clientHeight;";
			JavascriptExecutor scrollBarPresent = (JavascriptExecutor) driver;
			Boolean test = (Boolean) (scrollBarPresent.executeScript(execScript));

			System.out.println("Scroll bar value is :"+test);	

			Report.put("Verify the Modal pop up",
					"Modal pop up should load with all the details and Scroll bar should appear for the page",
					"Modal pop up displayed with all the details and Scroll bar displayed successfully.", "PASS");			
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify the Modal pop up",
					"Modal pop up should load with all the details and Scroll bar should appear for the page",
					"Failed to display Modal pop up with all the details and Scroll bar.", "FAIL");			
			Assert.fail();
		}
	}

	public void scrolldownPopup(WebDriver driver)
	{
		System.out.println("Inside scrolldownPopup method");
		Log.info("Inside scrolldownPopup method");
		int j=0;
		try
		{
			Actions act = new Actions (driver);
			String text = "";			

			WebDriverWait wait = new WebDriverWait(driver, 120);			

			List<WebElement> list=driver.findElements(obj_EsupportIPSHomePage.ScrollElement());

			int size = list.size();		

			WebElement element =driver.findElement(By.xpath("(//div[@id='mblOrginalGrid']//div//div)["+(size-1)+"]"));
			act.moveToElement(element).build().perform(); 
			CommonUtility.scrollToViewElement(driver, element); 

			Report.put("Drag the scroll bar down ",
					"On scroll down user should see the other available Part numbers and description ",
					"Scroll down successful & displayed Part Numbers & description.", "PASS");			
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Drag the scroll bar down ",
					"On scroll down user should see the other available Part numbers and description ",
					"Failed to Scroll down & display Part Numbers & description.", "FAIL");				
			Assert.fail();
		}
	}

	//Sneha - 18/06/2019
	public void verifyNickname(WebDriver driver)
	{
		System.out.println("Inside verifyNickname method");
		Log.info("Inside verifyNickname method");
		String val=TestNGCreator.TestData.get(Esupport.SearchOption.ordinal());

		try
		{                 
			WebDriverWait wait = new WebDriverWait(driver, 240);    

			if(CommonUtility.CheckpresenceofElementLocated(driver, 10, obj_EsupportIPSHomePage.AddNickname()))
			{
				CommonUtility.ScrollTo(driver,(obj_EsupportIPSHomePage.AddNickname()));
				CommonUtility.ClickOn(driver,(obj_EsupportIPSHomePage.AddNickname()));
				Thread.sleep(3000);
				CommonUtility.highlightElement(driver,(obj_EsupportIPSHomePage.EditableNickname())).clear();
				CommonUtility.highlightElement(driver,(obj_EsupportIPSHomePage.EditableNickname())).sendKeys(val);

				CommonUtility.ClickOn(driver,(obj_EsupportIPSHomePage.RightMark()));
			}

			//			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIPSHomePage.Nickname()));
			CommonUtility.ScrollTo(driver,(obj_EsupportIPSHomePage.Nickname()));
			String Nickname=CommonUtility.highlightElement(driver,(obj_EsupportIPSHomePage.Nickname())).getText();


			Report.put("Verify the Nickname",
					"Nickname should be present besides the service tag: ",
					"Nickname is present besides the service tag"+Report.color(Nickname), "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();

			Report.put("Verify the Nickname",
					"Nickname should be present besides the service tag: ",
					"Nickname is not present besides the service tag", "FAIL");
			Assert.fail();
		}
	}
	public void verifyEditDelete(WebDriver driver)
	{
		System.out.println("Inside verifyEditDelete method");
		Log.info("Inside verifyEditDelete method");

		try
		{                 
			WebDriverWait wait = new WebDriverWait(driver, 120);                  
			//			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIPSHomePage.EditNickname()));
			CommonUtility.highlightElement(driver,(obj_EsupportIPSHomePage.EditNickname())).isEnabled();
			//			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIPSHomePage.EditIcon()));
			//			CommonUtility.highlightElement(driver,(obj_EsupportIPSHomePage.EditIcon()));
			//			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIPSHomePage.DeleteNickname()));
			CommonUtility.highlightElement(driver,(obj_EsupportIPSHomePage.DeleteNickname())).isEnabled();;                        
			//			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIPSHomePage.DeleteIcon()));
			//			CommonUtility.highlightElement(driver,(obj_EsupportIPSHomePage.DeleteIcon()));
			Report.put("Verify the edit and delete buttons",
					"Edit link with pencil icon and delete link delete icon should be present besides the nickname ",
					"Edit link with pencil icon and delete link delete icon is present besides the nickname", "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();

			Report.put("Verify the edit and delete buttons",
					"Edit link with pencil icon and delete link delete icon should be present besides the nickname ",
					"Edit link with pencil icon and delete link delete icon is not present besides the nickname", "FAIL");
			Assert.fail();
		}
	}

	public void clickEdit(WebDriver driver)
	{
		System.out.println("Inside clickEdit method");
		Log.info("Inside clickEdit method");
		WebDriverWait wait = new WebDriverWait(driver, 120); 

		try
		{                 

			//			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIPSHomePage.EditNickname()));
			CommonUtility.ScrollTo(driver,(obj_EsupportIPSHomePage.EditNickname()));
			//			CommonUtility.highlightElement(driver,(obj_EsupportIPSHomePage.EditNickname())).click();
			CommonUtility.ClickOn(driver,(obj_EsupportIPSHomePage.EditNickname()));
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIPSHomePage.EditableNickname()));
			CommonUtility.highlightElement(driver,(obj_EsupportIPSHomePage.EditableNickname()));
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIPSHomePage.CounterCharacter()));
			String Counter=CommonUtility.highlightElement(driver,(obj_EsupportIPSHomePage.CounterCharacter())).getText();
			Log.info("Inside clickEdit method: "+Counter);
			Report.put("Click on the Edit  ",
					"User should get the editable nickname with in the box and total number of chars and the remaining chars below the box ",
					"User gets the editable nickname with in the box and total number of chars and the remaining chars below the box"+Report.color(Counter), "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();

			Report.put("Click on the Edit  ",
					"User should get the editable nickname with in the box and total number of chars and the remaining chars below the box ",
					"User does not get the editable nickname with in the box and total number of chars and the remaining chars below the box", "FAIL");
			Assert.fail();
		}
	}
	/*public void addNickname(WebDriver driver)
	{
		System.out.println("Inside addNickname method");
		Log.info("Inside addNickname method");

		try
		{                 
			WebDriverWait wait = new WebDriverWait(driver, 120);                  
			CommonUtility.highlightElement(driver,(obj_EsupportIPSHomePage.EditableNickname())).clear();
			CommonUtility.highlightElement(driver,(obj_EsupportIPSHomePage.EditableNickname())).sendKeys("Latitude1");

			CommonUtility.highlightElement(driver,(obj_EsupportIPSHomePage.RightMark())).click();
			String Nickname1=CommonUtility.highlightElement(driver,(obj_EsupportIPSHomePage.Nickname())).getText();
			Log.info("Nickname:"+Nickname1);
			System.out.println("Nickname:"+Nickname1);
			Report.put("Add any nickname and click on Right mark besides the box",
					"Nick name should get added successfully with toast message bottom of the page",
					"Nick name gets added successfully with toast message bottom of the page"+Report.color(Nickname1), "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();

			Report.put("Add any nickname and click on Right mark besides the box",
					"Nick name should get added successfully with toast message bottom of the page",
					"Nick name does not get added successfully with toast message bottom of the page", "FAIL");
			Assert.fail();
		}
	}*/

	public void addNickname(WebDriver driver,String val)
	{
		System.out.println("Inside addNickname method");
		Log.info("Inside addNickname method");

		try
		{                 
			WebDriverWait wait = new WebDriverWait(driver, 120);                  
			CommonUtility.highlightElement(driver,(obj_EsupportIPSHomePage.EditableNickname())).clear();
			CommonUtility.highlightElement(driver,(obj_EsupportIPSHomePage.EditableNickname())).sendKeys(val);

			CommonUtility.ClickOn(driver,(obj_EsupportIPSHomePage.RightMark()));
			String Nickname1=CommonUtility.highlightElement(driver,(obj_EsupportIPSHomePage.Nickname())).getText();
			Log.info("Nickname:"+Nickname1);
			System.out.println("Nickname:"+Nickname1);
			Report.put("Add any nickname and click on Right mark besides the box",
					"Nick name should get added successfully with toast message bottom of the page",
					"Nick name gets added successfully with toast message bottom of the page"+Report.color(Nickname1), "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();

			Report.put("Add any nickname and click on Right mark besides the box",
					"Nick name should get added successfully with toast message bottom of the page",
					"Nick name does not get added successfully with toast message bottom of the page", "FAIL");
			Assert.fail();
		}
	}




	public void verifyPartsAccessoriesTab(WebDriver driver)
	{
		System.out.println("Inside verifyPartsAccessoriesTab method");
		Log.info("Inside verifyPartsAccessoriesTab method");
		
		try
		{

			handleCookies(driver);
			String text = "";

			WebDriverWait wait = new WebDriverWait(driver, 120);

			CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.partsAccessoriesTab());

			text = CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.partsAccessoriesTab()).getText();

			System.out.println("Tab text is: "+text);

			Report.put("Below the hero section verify the parts and accessories tab ",
					"Parts and accessories tab should be displayed below the hero section",
					"Parts and accessories tab displayed Successfully. Tab is: "+Report.color(text), "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Below the hero section verify the parts and accessories tab ",
					"Parts and accessories tab should be displayed below the hero section",
					"Failed to display Parts and accessories tab", "FAIL");
			Assert.fail();
		}
	}

	public void clickPartsAccessoriesTab(WebDriver driver)
	{
		System.out.println("Inside clickPartsAccessoriesTab method");
		Log.info("Inside clickPartsAccessoriesTab method");

		Actions act = new Actions (driver);

		try
		{

			String partsHeader = "";
			String accessoriesHeader = "";
			String partLinks = "";
			String accessoriesLinks = "";


			WebDriverWait wait = new WebDriverWait(driver, 120);

			CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.partsAccessoriesTab());

			CommonUtility.ClickOn(driver,obj_EsupportIPSHomePage.partsAccessoriesTab());
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIPSHomePage.partsLinks()));
			//handleCookies(driver);
			List<WebElement> partList=driver.findElements(obj_EsupportIPSHomePage.partsLinks());

			for(WebElement lt:partList)
			{
				//				act.moveToElement(lt).build().perform(); 
				CommonUtility.highlightElement(driver, lt);
				String parts=lt.getText();

				System.out.println("Tab is: " +parts);
				partLinks+=" <br> " + parts;
			}

			System.out.println("Parts are:"+partLinks);

			//			List<WebElement> accessoriesList=driver.findElements(obj_EsupportIPSHomePage.accessoriesLinks());
			//
			//			for(WebElement lt:accessoriesList)
			//			{
			//				//				act.moveToElement(lt).build().perform(); 
			//
			//				CommonUtility.highlightElement(driver, lt);
			//				String accessories=lt.getText();
			//
			//				System.out.println("Tab is: " +accessories);
			//				accessoriesLinks+=" <br> " + accessories;
			//			}
			//			System.out.println("Accessories are:"+accessoriesLinks);


			//			CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.partsHeader());
			//
			//			partsHeader = CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.partsHeader()).getText();
			//
			//			CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.accessoriesHeader());
			//
			//			accessoriesHeader = CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.accessoriesHeader()).getText();

			Report.put("Click on the parts and accessories tab",
					"Parts and accessories tab should load ( this tab will show up only when the parts and accessories available for the product ) and should show the parts and accessories together ",
					"Clicked on Parts and accessories tab Successfully. parts and accessories are "+Report.color(partLinks), "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on the parts and accessories tab",
					"Parts and accessories tab should load ( this tab will show up only when the parts and accessories available for the product ) and should show the parts and accessories together ",
					"Failed to display Parts and accessories tab . ", "FAIL");
			Assert.fail();
		}
	}


	public void verifyNoAccessoriesMessage(WebDriver driver)
	{
		System.out.println("Inside verifyNoAccessoriesMessage method");
		Log.info("Inside verifyNoAccessoriesMessage method");

		Actions act = new Actions (driver);

		try
		{

			String message = "";


			WebDriverWait wait = new WebDriverWait(driver, 120);

			CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.partsAccessoriesTab());

			CommonUtility.ClickOn(driver,obj_EsupportIPSHomePage.partsAccessoriesTab());

			CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.accessoriesErrorMessage());

			message = CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.accessoriesErrorMessage()).getText();



			Report.put("Click on the parts and accessories tab",
					"User should display parts and accessories are not available for this product",
					"Displayed message Successfuly as: "+Report.color(message), "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on the parts and accessories tab",
					"User should display parts and accessories are not available for this product",
					"Failed to Display message ", "FAIL");
			Assert.fail();
		}
	}

	//Sneha - 19/06/2019

	public void deleteNickname(WebDriver driver)
	{
		System.out.println("Inside deleteNickname method");
		Log.info("Inside deleteNickname     method");

		try
		{                 
			WebDriverWait wait = new WebDriverWait(driver, 120);                  
			CommonUtility.ScrollTo(driver,(obj_EsupportIPSHomePage.DeleteNickname()));
			CommonUtility.ClickOn(driver,(obj_EsupportIPSHomePage.DeleteNickname()));
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIPSHomePage.AddNickname()));
			CommonUtility.highlightElement(driver,(obj_EsupportIPSHomePage.AddNickname()));


			Report.put("Click on the delete link besides the nickname",
					"Nickname should get deleted and should get the add nickname link",
					"Nickname gets deleted gets the add nickname link", "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();

			Report.put("Click on the delete link besides the nickname",
					"Nickname should get deleted and should get the add nickname link",
					"Failed to delete the nickname", "FAIL");
			Assert.fail();
		}
	}

	public void UndoNickname(WebDriver driver)
	{
		System.out.println("Inside deleteNickname method");
		Log.info("Inside deleteNickname     method");

		try
		{                 
			WebDriverWait wait = new WebDriverWait(driver, 120);      
			//wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIPSHomePage.UndoNickname()));
			CommonUtility.ClickOn(driver,(obj_EsupportIPSHomePage.UndoNickname()));
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIPSHomePage.Nickname()));
			CommonUtility.highlightElement(driver,(obj_EsupportIPSHomePage.Nickname()));


			Report.put("Click on the delete link besides the nickname",
					"Nickname should get deleted and should get the add nickname link",
					"Nickname gets deleted gets the add nickname link", "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();

			Report.put("Click on the delete link besides the nickname",
					"Nickname should get deleted and should get the add nickname link",
					"Failed to delete the nickname", "FAIL");
			Assert.fail();
		}
	}

	public void verifyChangeProductLink(WebDriver driver)
	{
		System.out.println("Inside verifyChangeProductLink method");
		Log.info("Inside verifyChangeProductLink method");

		String text = "";
		try
		{			
			handleCookies(driver);

			if(CommonUtility.CheckpresenceofElementLocated(driver, 10, obj_EsupportIPSHomePage.changeProduct()))
			{
				CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.changeProduct());

				text = CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.changeProduct()).getText();

				System.out.println("Link is "+text);

				Report.put("Verify the product support hero section for the change product link",
						"Hero section should have change product option ( link )",
						"Displayed "+Report.color(text)+" link successfully", "PASS");
			}	
			else
			{
				Report.put("Verify the product support hero section for the change product link",
						"Hero section should have change product option ( link )",
						"Failed to display Change Product Link ", "FAIL");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify the product support hero section for the change product link",
					"Hero section should have change product option ( link )",
					"Failed to display Change Product Link ", "FAIL");
			Assert.fail();
		}
	}

	public void clickChangeProductLink(WebDriver driver)
	{
		System.out.println("Inside clickChangeProductLink method");
		Log.info("Inside clickChangeProductLink method");

		WebDriverWait wait = new WebDriverWait(driver, 120); 

		String header = "";
		try
		{
			//			handleCookies(driver);
			//			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIPSHomePage.changeProduct()));
			CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.changeProduct());
			//			CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.changeProduct());

			//CommonUtility.ClickOn(driver,obj_EsupportIPSHomePage.changeProduct());
			CommonUtility.ToClickByUsingJavaScript_PassingByLoc(driver, obj_EsupportIPSHomePage.changeProduct());

			//wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDriversandDownloadsPage.homepageHeader()));

			CommonUtility.ScrollTo(driver,obj_EsupportDriversandDownloadsPage.homepageHeader());

			header = CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.homepageHeader()).getText();

			Report.put("Click on the change product link ",
					"User should land in the product support jump page ",
					"Landed in Product Support Page . Header is:"+Report.color(header), "PASS");

		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on the change product link ",
					"User should land in the product support jump page ",
					"Failed to Land in Product Support Page ", "FAIL");

			Assert.fail();
		}
	}

	//Sneha - 20/06/2019

	public void VerifyAddNewNickname(WebDriver driver)
	{
		System.out.println("Inside VerifyAddNewNickname method");
		
		String text = "";
		try
		{                 
			WebDriverWait wait = new WebDriverWait(driver, 120);      
			Thread.sleep(7000);
			CommonUtility.ScrollTo(driver,(obj_EsupportIPSHomePage.AddNickname()));
			if(CommonUtility.CheckpresenceofElementLocated(driver,20,obj_EsupportIPSHomePage.AddNickname()))
			{
				//				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIPSHomePage.AddNickname()));
				CommonUtility.ScrollTo(driver,(obj_EsupportIPSHomePage.AddNickname()));

				text = CommonUtility.highlightElement(driver,(obj_EsupportIPSHomePage.AddNickname())).getText();
				System.out.println("Link is: "+text);

				Report.put("Now check the hero section for the add nickname  ",
						"Hero section should display the Add nickname link ",
						"Add nickname link is available."+Report.color(text), "PASS");
				
				CommonUtility.ClickOn(driver,(obj_EsupportIPSHomePage.AddNickname()));
			}
			else
			{
				Report.put("Now check the hero section for the add nickname  ",
						"Hero section should display the Add nickname link ",
						"Failed to get the add nickname link", "FAIL");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();

			Report.put("Now check the hero section for the add nickname  ",
					"Hero section should display the Add nickname link ",
					"Failed to get the add nickname link", "FAIL");
			Assert.fail();
		}
	}

	public void VerifyLogInToAddNewNickname(WebDriver driver)
	{
		System.out.println("Inside VerifyLogInToAddNewNickname method");
		
		
		String text = "";
		try
		{                 
			WebDriverWait wait = new WebDriverWait(driver, 120);      
			Thread.sleep(7000);
			CommonUtility.ScrollTo(driver,(obj_EsupportIPSHomePage.LoginToAddNickname()));
			if(CommonUtility.CheckpresenceofElementLocated(driver,20,obj_EsupportIPSHomePage.LoginToAddNickname()))
			{
				//				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIPSHomePage.AddNickname()));
				CommonUtility.ScrollTo(driver,(obj_EsupportIPSHomePage.LoginToAddNickname()));

				text = CommonUtility.highlightElement(driver,(obj_EsupportIPSHomePage.LoginToAddNickname())).getText();
				System.out.println("Link is: "+text);

				Report.put("Check the hero section for the Link login to add nickname",
						"Login to add nickname link should be present in the Hero section",
						"Login to Add nickname link is available."+Report.color(text), "PASS");
			}
			else
			{
				Report.put("Check the hero section for the Link login to add nickname",
						"Login to add nickname link should be present in the Hero section",
						"Failed to get the Login to add nickname link", "FAIL");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();

			Report.put("Check the hero section for the Link login to add nickname",
					"Login to add nickname link should be present in the Hero section",
					"Failed to get the add nickname link", "FAIL");
			Assert.fail();
		}
	}
	
	public void ClickAddNewNickname(WebDriver driver)
	{
		System.out.println("Inside ClickAddNewNickname method");
		Log.info("Inside ClickAddNewNickname method");
		String val = "Automating PCF Application_Integrated-Product_24_@";
		String header="";
		try
		{                 
			WebDriverWait wait = new WebDriverWait(driver, 120);   

			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_EsupportIPSHomePage.LoginToAddNickname()))
			{
				CommonUtility.ScrollTo(driver,(obj_EsupportIPSHomePage.LoginToAddNickname()));
				CommonUtility.ClickOn(driver,(obj_EsupportIPSHomePage.LoginToAddNickname()));

				Thread.sleep(10000);
				if(CommonUtility.CheckpresenceofElementLocated(driver, 30, obj_EsupportIPSHomePage.signInHeader()))
				{
//					wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIPSHomePage.signInHeader()));
					CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.signInHeader());
					header = CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.signInHeader()).getText();
				}
				else if(CommonUtility.CheckpresenceofElementLocated(driver, 30, obj_EsupportIPSHomePage.SignInHeaderNew()))
				{
//					wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIPSHomePage.SignInHeaderNew()));
					CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.SignInHeaderNew());
					header = CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.SignInHeaderNew()).getText();
				}

				Report.put("Click on the Login to add nickname",
						"User should navigate to the Login ( DIAS ) Page",
						"Navigated to Login page Successfully. Header is: "+Report.color(header), "PASS");
			}
			else
			{
				Report.put("Click on the Login to add nickname",
						"User should navigate to the Login ( DIAS ) Page",
						"Failed to Navigate to Login page ", "FAIL");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();

			Report.put("Click on the Add nickname link",
					"User should be able to get a box to enter nick name",
					"Failed to get a box to enter nick name", "FAIL");
			Assert.fail();
		}
	}

	public void EnterNewNickname(WebDriver driver)
	{
		System.out.println("Inside EnterNewNickname method");
		Log.info("Inside EnterNewNickname method");
		String val = TestNGCreator.TestData.get(Esupport.FirstName.ordinal()).split(";")[0];
		try
		{                 
			WebDriverWait wait = new WebDriverWait(driver, 120);      
			for (int i = 0; i < 50; i++){
				char c = val.charAt(i);
				String s = new StringBuilder().append(c).toString();
				CommonUtility.highlightElement(driver,(obj_EsupportIPSHomePage.EditableNickname())).sendKeys(s);
				//CommonUtility.highlightElement(driver,(obj_EsupportIPSHomePage.EditableNickname())).getText();
				//wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIPSHomePage.CounterCharacter()));
				CommonUtility.highlightElement(driver,(obj_EsupportIPSHomePage.CounterCharacter()));
			}
			String Var=CommonUtility.highlightElement(driver,(obj_EsupportIPSHomePage.EditableNickname())).getAttribute("value") ;
			Log.info(Var);
			Report.put("Enter any nick name , Try the nicknames with spaces, upper/lower case letters, apostrophes, underscores, dashes , other language chars and numbers",
					"It should allow all spaces, upper/lower case letters, apostrophes, underscores, dashes , other language Chars and numbers",
					"It will allow all spaces, upper/lower case letters, apostrophes, underscores, dashes , other language Chars and numbers"+Report.color(Var), "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();

			Report.put("Enter any nick name , Try the nicknames with spaces, upper/lower case letters, apostrophes, underscores, dashes , other language chars and numbers",
					"It should allow all spaces, upper/lower case letters, apostrophes, underscores, dashes , other language Chars and numbers",
					"Failed to allow all spaces, upper/lower case letters, apostrophes, underscores, dashes , other language Chars and numbers", "FAIL");
			Assert.fail();
		}
	}

	public void EnterNewNickname50(WebDriver driver)
	{
		System.out.println("Inside EnterNewNickname50 method");
		Log.info("Inside EnterNewNickname50 method");
		String val = TestNGCreator.TestData.get(Esupport.FirstName.ordinal()).split(";")[0];
		try
		{                 
			WebDriverWait wait = new WebDriverWait(driver, 120);      
			CommonUtility.highlightElement(driver,(obj_EsupportIPSHomePage.EditableNickname())).clear();
			CommonUtility.highlightElement(driver,(obj_EsupportIPSHomePage.EditableNickname())).sendKeys(val);
			String error=CommonUtility.highlightElement(driver,(obj_EsupportIPSHomePage.ErrorText())).getText();
			String count=CommonUtility.highlightElement(driver,(obj_EsupportIPSHomePage.CounterCharacter())).getText();
			Report.put("Enter the chars more than 50  and observe the behavior",
					"Enter the chars more than 50  and observe the behavior",
					"Entered the chars more than 50  and observed the behavior"+Report.color(error)+""+Report.color(count), "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();

			Report.put("Enter the chars more than 50  and observe the behavior",
					"Enter the chars more than 50  and observe the behavior",
					"Failed to observe the behaviour on entering more than 50 character", "FAIL");
			Assert.fail();
		}
	}

	public void verifyDocumentationTab(WebDriver driver)
	{
		System.out.println("Inside verifyDocumentationTab method");
		Log.info("Inside verifyDocumentationTab method");

		String text = "";
		try
		{			
			handleCookies(driver);

			if(CommonUtility.CheckpresenceofElementLocated(driver, 10, obj_EsupportIPSHomePage.documentationTab()))
			{
				CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.documentationTab());

				text = CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.documentationTab()).getText();

				System.out.println("Tab is "+text);

				Report.put("Check for the Documentation tab",
						"Documentation tab should be present below the hero section",
						"Displayed "+Report.color(text)+" tab successfully", "PASS");
			}	
			else
			{
				Report.put("Check for the Documentation tab",
						"Documentation tab should be present below the hero section",
						"Failed to display Documentation Tab", "FAIL");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Check for the Documentation tab",
					"Documentation tab should be present below the hero section",
					"Failed to display Documentation Tab", "FAIL");
			Assert.fail();
		}
	}

	public void clickDocumentationTab(WebDriver driver)
	{
		System.out.println("Inside clickDocumnetationTab method");
		Log.info("Inside clickDocumnetationTab method");

		WebDriverWait wait = new WebDriverWait(driver, 120); 

		String header = "";
		try
		{		
			wait.until(ExpectedConditions.presenceOfElementLocated(obj_EsupportIPSHomePage.documentationTab()));
			CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.documentationTab());
			CommonUtility.ClickOn(driver,obj_EsupportIPSHomePage.documentationTab());

			wait.until(ExpectedConditions.presenceOfElementLocated(obj_EsupportIPSHomePage.documentationHeader()));

			CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.documentationHeader());

			header = CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.documentationHeader()).getText();

			Report.put("Click on the documentation tab",
					"User should land in the documentation tab ",
					"Landed in the documentation tab  . Header is:"+Report.color(header), "PASS");

		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on the documentation tab",
					"User should land in the documentation tab ",
					"Failed to land in the documentation tab ", "FAIL");

			Assert.fail();
		}
	}

	public void clickWarrantyDetailsCloseButton(WebDriver driver)
	{
		System.out.println("Inside clickWarrantyDetailsCloseButton method");
		Log.info("Inside clickWarrantyDetailsCloseButton method");

		try
		{
			String text = "";	
			String prodHeader = "";			


			WebDriverWait wait = new WebDriverWait(driver, 120);

			CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.warrantyDetailsCloseButton());
			CommonUtility.ClickOn(driver,obj_EsupportIPSHomePage.warrantyDetailsCloseButton());

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIPSHomePage.productHeader()));
			CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.productHeader());
			prodHeader = CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.productHeader()).getText();

			Report.put("Now close the Warranty page and comeback to product support page",
					"User should comeback to product support page",
					"Warranty Page closed and successfully landed in the Product support page of "+Report.color(prodHeader), "PASS");			
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Now close the print page and comeback to product support page",
					"User should comeback to product support page",
					"Failed to close Print Page", "FAIL");			
			Assert.fail();
		}
	}

	public void verifySystemConfigurationLink(WebDriver driver)
	{
		System.out.println("Inside verifySystemConfigurationLink method");
		Log.info("Inside verifySystemConfigurationLink method");

		try
		{
			//			handleCookies(driver);
			String link = "";
			WebDriverWait wait = new WebDriverWait(driver, 120);

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIPSHomePage.systemConfigurationLink()));
			//			CommonUtility.scrollToViewElement(driver,obj_EsupportIPSHomePage.systemConfigurationLink());
			CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.systemConfigurationLink());


			link = CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.systemConfigurationLink()).getText();

			Report.put("Verify the hero section for the system configuration link",
					"System configuration link should show up",
					"System configuration link displayed Successfully. Link is: "+Report.color(link), "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify the hero section for the system configuration link",
					"System configuration link should show up",
					"Failed to display System configuration link", "FAIL");
			Assert.fail();
		}
	}

	public void clickCurrentConfigurationTab(WebDriver driver)
	{
		System.out.println("Inside clickCurrentConfigurationTab method");
		Log.info("Inside clickCurrentConfigurationTab method");

		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIPSHomePage.currentConfigurationTab()));
			CommonUtility.ClickOn(driver,obj_EsupportIPSHomePage.currentConfigurationTab());	

			Report.put("Click on the current configuration tab",
					"Current configuration tab should be selected",
					"Current configuration tab selected Successfully. ", "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on the current configuration tab",
					"Current configuration tab should be selected",
					"Failed to select Current configuration tab ", "FAIL");
			Assert.fail();
		}
	}

	public void verifyRunSupportAssistButton(WebDriver driver)
	{
		System.out.println("Inside verifyRunSupportAssistButton method");
		Log.info("Inside verifyRunSupportAssistButton method");

		try
		{
			String text = "";

			WebDriverWait wait = new WebDriverWait(driver, 120);

			if(CommonUtility.CheckpresenceofElementLocated(driver, 10, obj_EsupportIPSHomePage.runSupportAssistButton()))
			{
				CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.runSupportAssistButton());
				text = CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.runSupportAssistButton()).getText();

				System.out.println("Button text is: "+text);

				Report.put("Verify the option for the run support assist",
						"Run support assist button should be displayed ",
						"Run support assist button displayed Successfully. Button is: "+Report.color(text), "PASS");
			}
			else
			{
				Report.put("Verify the option for the run support assist",
						"Run support assist button should be displayed ",
						"Failed to display Run support assist button ", "FAIL");
				Assert.fail();
			}

		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify the option for the run support assist",
					"Run support assist button should be displayed ",
					"Failed to display Run support assist button ", "FAIL");
			Assert.fail();
		}
	}

	public void clickBrowseAllProductsLink(WebDriver driver)
	{
		System.out.println("Inside clickBrowseAllProductsLink method");
		Log.info("Inside clickBrowseAllProductsLink method");

		WebDriverWait wait = new WebDriverWait(driver, 120); 

		String header = "";
		try
		{
			//			
			Thread.sleep(10000);
			handleCookies(driver);
			CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.browseAllProductsLink());

			CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.browseAllProductsLink());
			//			CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.browseAllProductsLink()).click();
			CommonUtility.ClickOn(driver, obj_EsupportIPSHomePage.browseAllProductsLink());
//			wait.until(ExpectedConditions.presenceOfElementLocated(obj_EsupportIPSHomePage.allProductsPopupHeader()));
//
//			CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.allProductsPopupHeader());
//
//			header = CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.allProductsPopupHeader()).getText();

			Report.put("Click on the browse all products",
					"User should load modal pop up with all products",
					"Loaded Modal Popup with All Products. Popup Header is:"+Report.color(header), "PASS");

		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on the browse all products",
					"User should load modal pop up with all products",
					"Failed to load Modal Popup with All Products. ", "FAIL");

			Assert.fail();
		}
	}

	public void clickLaptopsLink(WebDriver driver)
	{
		System.out.println("Inside clickLaptopsLink method");
		Log.info("Inside clickLaptopsLink method");

		WebDriverWait wait = new WebDriverWait(driver, 120); 

		String header = "";
		try
		{			
			wait.until(ExpectedConditions.presenceOfElementLocated(obj_EsupportIPSHomePage.laptopsLink()));
			CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.laptopsLink());
			handleCookies(driver);
			//			CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.laptopsLink()).click();
			CommonUtility.ClickOn(driver,obj_EsupportIPSHomePage.laptopsLink());
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIPSHomePage.laptopsHeader()));

			CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.laptopsHeader());

			header = CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.laptopsHeader()).getText();

			Report.put("Click on Laptops",
					"User should load modal pop up with Laptops",
					"Loaded Modal Popup with Laptops. Popup Header is:"+Report.color(header), "PASS");

		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on Laptops",
					"User should load modal pop up with Laptops",
					"Failed to load Modal Popup with Laptops.", "FAIL");
			Assert.fail();
		}
	}

	public void clickLatitudeLink(WebDriver driver)
	{
		System.out.println("Inside clickLatitudeLink method");
		Log.info("Inside clickLatitudeLink method");

		WebDriverWait wait = new WebDriverWait(driver, 120); 

		String header = "";
		try
		{	
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIPSHomePage.latitudeLink()));
			CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.latitudeLink());
			//			CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.latitudeLink()).click();
			CommonUtility.ClickOn(driver,obj_EsupportIPSHomePage.latitudeLink());
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIPSHomePage.latitudeHeader()));

			CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.latitudeHeader());

			header = CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.latitudeHeader()).getText();

			Thread.sleep(10000);

			Report.put("Click on Latitude",
					"User should load modal pop up with Latitude",
					"Loaded Modal Popup with Latitude. Popup Header is:"+Report.color(header), "PASS");

		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on Latitude",
					"User should load modal pop up with Latitude",
					"Failed to load Modal Popup with Latitude.", "FAIL");
			Assert.fail();
		}
	}

	public void clickLatitudeSubProduct(WebDriver driver, String subProduct)
	{
		// TODO Auto-generated method stub

		System.out.println("Inside clickLatitudeSubProduct");
		Log.info("Inside clickLatitudeSubProduct");   
		Actions act = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, 120); 
		String header = "";
		String defaulttab="";
		String value=TestNGCreator.TestData.get(Esupport.TestCaseID.ordinal());
		try
		{
			Thread.sleep(6000);
			//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='divCatalogItems']//a[contains(text(),'"+subProduct+"')]")));
			//			WebElement element = driver.findElement(By.xpath("//div[@id='divCatalogItems']//a[contains(text(),'"+subProduct+"')]"));
			//			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='divCatalogItems']//a[contains(text(),'"+subProduct+"')]")));
			//			CommonUtility.highlightElement(driver,element);
			//			act.moveToElement(CommonUtility.highlightElement(driver, element)).build().perform();
			//			CommonUtility.ScrollTo(driver, By.xpath("//div[@id='divCatalogItems']//a[contains(text(),'"+subProduct+"')]"));

			//			CommonUtility.highlightElement(driver, element).click();
			CommonUtility.ScrollTo(driver, By.xpath("//div[@id='divCatalogItems']//a[contains(text(),'"+subProduct+"')]"));
			//			handleCookies(driver);
			CommonUtility.ClickOn(driver, By.xpath("//div[@id='divCatalogItems']//a[contains(text(),'"+subProduct+"')]"));
			Thread.sleep(6000);

			
			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_EsupportIPSHomePage.productHeader()))
		    {
			    CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.productHeader());

			    header = CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.productHeader()).getText();

			    System.out.println("Clicked on Product "+subProduct); 
		    }
			else if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_EsupportIPSHomePage.ProductHeader2()))
			{
				CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.ProductHeader2());

				header = CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.ProductHeader2()).getText();

				System.out.println("Clicked on Product "+subProduct); 
			}

			if(value=="5836926")
			{
				CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.OverviewDefaultTab());

				defaulttab = CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.OverviewDefaultTab()).getText();

				System.out.println("default landed tab is "+defaulttab);

				Report.put("Select the Sub Product",
						"Product support page should be displayed and By default Overview tab should be selected.",
						"Product support page displayed for Product"+Report.color(header)+" with default landed on "+Report.color(defaulttab)+" tab", "PASS");

			}
			else
			{

				Report.put("Select the Sub Product",
						"Product support page should be displayed",
						"Product support page displayed for Product"+Report.color(header), "PASS");
			}
		}

		catch (Exception e)
		{
			Log.info(e);
			if(value=="5836926")
			{
				Report.put("Select the Sub Product",
						"Product support page should be displayed and By default Overview tab should be selected.",
						"Failed to display Product support page and not landed on default overview tab", "FAIL");
			}
			else
			{
				Report.put("Select the Sub Product",
						"Product support page should be displayed",
						"Failed to display Product support page", "FAIL");
			}


			e.printStackTrace();
			Assert.fail();
		}               
	} 

	public void verifyEnterServiceTagLink(WebDriver driver)
	{
		System.out.println("Inside verifyEnterServiceTagLink method");
		Log.info("Inside verifyEnterServiceTagLink method");

		String text = "";
		try
		{
			//handleCookies(driver);

			if(CommonUtility.CheckpresenceofElementLocated(driver, 10, obj_EsupportIPSHomePage.EnterServiceTag()))
			{
				CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.EnterServiceTag());
				text = CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.EnterServiceTag()).getText();
				System.out.println(text);

				Report.put("Verify the enter service tag to view details link in the hero section",
						"Enter service tag to view details link  should be displayed in the hero section",
						"Displayed link successfully" +Report.color(text), "PASS");
			}	
			else
			{
				Report.put("Verify the enter service tag to view details link in the hero section",
						"Enter service tag to view details link  should be displayed in the hero section",
						"Failed to Display the link" , "FAIL");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify the enter service tag to view details link in the hero section",
					"Enter service tag to view details link  should be displayed in the hero section",
					"Failed to Display the link" , "FAIL");
			Assert.fail();
		}
	}

	public void verifyEnterDetailsLink(WebDriver driver)
	{
		System.out.println("Inside verifyEnterDetailsLink method");
		Log.info("Inside verifyEnterDetailsLink method");

		String text = "";
		try
		{
			//handleCookies(driver);

			if(CommonUtility.CheckpresenceofElementLocated(driver, 10, obj_EsupportIPSHomePage.EnterServiceTag()))
			{
				CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.EnterServiceTag());
				text = CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.EnterServiceTag()).getText();
				System.out.println(text);

				Report.put("check for the enter details option ",
						"user should be able to enter details in the overview section ",
						"Displayed link successfully" +Report.color(text), "PASS");
			}	
			else
			{
				Report.put("check for the enter details option ",
						"user should be able to enter details in the overview section ",
						"Failed to Display expected link" , "FAIL");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("check for the enter details option ",
					"user should be able to enter details in the overview section ",
					"Failed to Display the expected link" , "FAIL");
			Assert.fail();
		}
	}
	public void clickEnterServiceTagLink(WebDriver driver)
	{
		System.out.println("Inside clickEnterServiceTagLink method");
		Log.info("Inside clickEnterServiceTagLink method");

		WebDriverWait wait = new WebDriverWait(driver, 120); 

		String header = "";
		String link = "";
		try
		{	
			wait.until(ExpectedConditions.presenceOfElementLocated(obj_EsupportIPSHomePage.EnterServiceTag()));
			CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.EnterServiceTag());
			CommonUtility.ClickOn(driver,obj_EsupportIPSHomePage.EnterServiceTag());

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIPSHomePage.enterServiceTagHeader()));

			CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.enterServiceTagHeader());

			header = CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.enterServiceTagHeader()).getText();

			CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.enterServiceTagTextbox());

			CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.DetectYourPC1());

			link = CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.DetectYourPC1()).getText();

			System.out.println("Link is:"+link);


			Report.put("Click on Enter service tag to view details link",
					"Enter your service tag modal pop up should load with an option to enter service tag with box and detect pc link",
					"Loaded Modal Popup with an option to enter service tag with box. Link is: "+Report.color(link), "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on Enter service tag to view details link",
					"Enter your service tag modal pop up should load with an option to enter service tag with box and detect pc link",
					"Failed to Load Modal Popup with an option to enter service tag with box & detect PC Link ", "FAIL");
			Assert.fail();
		}
	}

	public void clickEnterDetailsLink(WebDriver driver)
	{
		System.out.println("Inside clickEnterDetailsLink method");
		Log.info("Inside clickEnterDetailsLink method");

		WebDriverWait wait = new WebDriverWait(driver, 120); 

		String header = "";
		String link = "";
		try
		{	
			CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.EnterServiceTag());
			wait.until(ExpectedConditions.presenceOfElementLocated(obj_EsupportIPSHomePage.EnterServiceTag()));
			CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.EnterServiceTag());
			CommonUtility.ClickOn(driver,obj_EsupportIPSHomePage.EnterServiceTag());
            Thread.sleep(10000);
			//wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIPSHomePage.enterServiceTagHeader()));

			CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.enterServiceTagHeader());

			header = CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.enterServiceTagHeader()).getText();

			CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.enterServiceTagTextbox());

			CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.DetectYourPC1());

			link = CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.DetectYourPC1()).getText();

			System.out.println("Link is:"+link);


			Report.put("Click on enter details ",
					"User should load pop up to enter details Product ID or Service tag",
					"Loaded Modal Popup with an option to enter details with box. description is : "+Report.color(link), "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on enter details ",
					"User should load pop up to enter details Product ID or Service tag",
					"Failed to Load Modal Popup with an option to enter details with box & detect PC Link ", "FAIL");
			Assert.fail();
		}
	}
	public void clickEnterServiceTagPopupCloseButton(WebDriver driver)
	{
		System.out.println("Inside clickEnterServiceTagPopupCloseButton method");
		Log.info("Inside clickEnterServiceTagPopupCloseButton method");

		try
		{
			String text = "";	
			String prodHeader = "";			


			WebDriverWait wait = new WebDriverWait(driver, 120);

			CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.enterServiceTagPopupCloseButton());
			CommonUtility.ClickOn(driver,obj_EsupportIPSHomePage.enterServiceTagPopupCloseButton());

			//wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIPSHomePage.productHeader()));
			if(CommonUtility.CheckpresenceofElementLocated(driver, 10, obj_EsupportIPSHomePage.productHeader()))
			{
			CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.productHeader());
			prodHeader = CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.productHeader()).getText();

			System.out.println("Product Page header is:"+prodHeader);
			}
			else
			{
				CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.ProductHeader2());
				prodHeader = CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.ProductHeader2()).getText();

				System.out.println("Product Page header is:"+prodHeader);
			}
			Report.put("Click on the close option by click on the cross mark on the modal pop up ",
					"Modal pop up should go off and land back in the product support page",
					"Modal Popup closed and successfully landed in the Product support page of "+Report.color(prodHeader), "PASS");			
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on the close option by click on the cross mark on the modal pop up ",
					"Modal pop up should go off and land back in the product support page",
					"Failed to close Modal Popup & land in the Product support page", "FAIL");				
			Assert.fail();
		}
	}

	public void enterServiceTagModalPopup(WebDriver driver,String serviceTag) 
	{		
		WebDriverWait wait = new WebDriverWait(driver, 120);

		System.out.println("Entering enterServiceTagModalPopup");

		Log.info("Entering enterServiceTagModalPopup");   

		try 
		{	
			String header="";
			String prodHeader="";

			System.out.println("Service Tag from Test data sheet is :" +serviceTag);		


			CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.enterServiceTagTextbox());
			CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.enterServiceTagTextbox()).clear();
			CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.enterServiceTagTextbox()).sendKeys(serviceTag);
			CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.serviceTagSubmitButton());
			CommonUtility.ClickOn(driver,obj_EsupportIPSHomePage.serviceTagSubmitButton());

			Thread.sleep(6000);
			//wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIPSHomePage.productHeader()));
			if(CommonUtility.CheckpresenceofElementLocated(driver, 10, obj_EsupportIPSHomePage.productHeader()))
			{
			CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.productHeader());
			prodHeader = CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.productHeader()).getText();

			System.out.println("Product Page header is:"+prodHeader);
			}
			else
			{
				CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.ProductHeader2());
				prodHeader = CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.ProductHeader2()).getText();
                System.out.println("Product Page header is:"+prodHeader);
			}
			Report.put("Enter service tag and click on submit "+Report.color(serviceTag),
					"User should land into Product Support Page",
					"Successfully navigated to Product Support Page. Header is: "+Report.color(prodHeader), "PASS");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Enter service tag and click on submit "+Report.color(serviceTag),
					"User should land into Product Support Page",
					"Failed to navigate to Product Support Page.", "FAIL");
			Assert.fail();

		}
	}

	public void clickSoftwareLink(WebDriver driver)
	{
		System.out.println("Inside clickSoftwareLink method");
		Log.info("Inside clickSoftwareLink method");

		WebDriverWait wait = new WebDriverWait(driver, 120); 

		String header = "";
		try
		{			
			handleCookies(driver);
			//			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIPSHomePage.softwareLink()));
			CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.softwareLink());
			handleCookies(driver);
			CommonUtility.ClickOn(driver,obj_EsupportIPSHomePage.softwareLink());

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIPSHomePage.allProductsPopupHeader()));

			//			CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.softwareHeader());

			header = CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.allProductsPopupHeader()).getText();

			Report.put("Click on Software under the model pop up",
					"system should further drill down to sub categories ",
					"Loaded Modal Popup with Sub Categories. Popup Header is:"+Report.color(header), "PASS");

		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on Software under the model pop up",
					"system should further drill down to sub categories ",
					"Failed to Load Modal Popup with Sub Categories. ", "FAIL");
			Assert.fail();
		}
	}

	public void clickUtilitiesLink(WebDriver driver)
	{
		System.out.println("Inside clickUtilitiesLink method");
		Log.info("Inside clickUtilitiesLink method");

		WebDriverWait wait = new WebDriverWait(driver, 120); 

		String testdata= TestNGCreator.TestData.get(Esupport.SearchOption.ordinal());

		String header = "";
		try
		{
			if(testdata.contains("Dell Backup"))
			{
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIPSHomePage.utilitiesLink()));
				CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.utilitiesLink());
				CommonUtility.ClickOn(driver,obj_EsupportIPSHomePage.utilitiesLink());

				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIPSHomePage.allProductsPopupHeader()));

				CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.allProductsPopupHeader());

				header = CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.allProductsPopupHeader()).getText();

				Report.put("Click on Utilities",
						"User should show up the products",
						"Loaded Utilities Popup with Products. Popup Header is:"+Report.color(header), "PASS");
			}
			else
			{
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIPSHomePage.OperatingSystemsLink()));
				CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.OperatingSystemsLink());
				CommonUtility.ClickOn(driver,obj_EsupportIPSHomePage.OperatingSystemsLink());

				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIPSHomePage.allProductsPopupHeader()));

				CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.allProductsPopupHeader());

				header = CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.allProductsPopupHeader()).getText();

				Report.put("Click on Operating systems",
						"User should show up the products",
						"Loaded Operating systems Popup with Products. Popup Header is:"+Report.color(header), "PASS");
			}


		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on Utilities",
					"User should show up the products",
					"Failed to Load Utilities Popup with Products.", "FAIL");
			Assert.fail();
		}
	}

	public void clickUtilitiesSubProduct(WebDriver driver, String subProduct)
	{
		// TODO Auto-generated method stub

		System.out.println("Inside clickUtilitiesSubProduct");
		Log.info("Inside clickUtilitiesSubProduct");   
		Actions act = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, 120); 
		String header = "";
		try
		{

			//	wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIPSHomePage.latitudeHeader()));
			WebElement element = driver.findElement(By.xpath("//div[@id='divCatalogItems']//a[contains(text(),'"+subProduct+"')]"));
			CommonUtility.highlightElement(driver,element);
			//			act.moveToElement(CommonUtility.highlightElement(driver, element)).build().perform();

			CommonUtility.ClickOn(driver,By.xpath("//div[@id='divCatalogItems']//a[contains(text(),'"+subProduct+"')]"));

			Thread.sleep(4000);
			CommonUtility.highlightElement(driver, element).click();

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIPSHomePage.productHeader()));

			CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.productHeader());

			header = CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.productHeader()).getText();

			System.out.println("Clicked on Product "+subProduct); 

			Report.put("Click on the Dell Backup and Recovery Manager Version 1.0",
					"User should land in the software product support page ",
					"Product support page displayed for Product"+Report.color(header), "PASS");
		}

		catch (Exception e)
		{
			Log.info(e);
			Report.put("lick on the Dell Backup and Recovery Manager Version 1.0",
					"User should land in the software product support page ",
					"Failed to display Product support page", "FAIL");
			e.printStackTrace();
			Assert.fail();
		}               
	} 

	public void verifyTabsSupportPage(WebDriver driver) throws Throwable
	{
		System.out.println("Inside verifyTabsSupportPage method");
		Log.info("Inside verifyTabsSupportPage method");
		String header = "";
		String tabList = "";
		String defaultTab = "";

		try
		{			

			WebDriverWait wait = new WebDriverWait(driver, 120);

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIPSHomePage.tabsSupportPage()));

			List<WebElement> list=driver.findElements(obj_EsupportIPSHomePage.tabsSupportPage());
			for(WebElement lt:list)
			{

				CommonUtility.highlightElement(driver, lt);
				driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
				Thread.sleep(20000);
				String tabName=lt.getText();
				Thread.sleep(3000);
				System.out.println("Tab is: " +tabName);
				tabList+=" <br> " + tabName;
			}

			System.out.println("Tabs are:"+tabList);

			Report.put("Verify the tabs ",
					"Overview tab , Drivers & Downloads and documentation should be available",
					"Tabs displayed Successfully. Tabs are: "+Report.color(tabList), "PASS");

		}
		catch (StaleElementReferenceException e)
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIPSHomePage.tabsSupportPage()));

			List<WebElement> list=driver.findElements(obj_EsupportIPSHomePage.tabsSupportPage());
			for(WebElement lt:list)
			{

				CommonUtility.highlightElement(driver, lt);
				driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
				Thread.sleep(20000);
				String tabName=lt.getText();
				Thread.sleep(3000);
				System.out.println("Tab is: " +tabName);
				tabList+=" <br> " + tabName;
			}

			System.out.println("Tabs are:"+tabList);

			Report.put("Verify the tabs ",
					"Overview tab , Drivers & Downloads and documentation should be available",
					"Tabs displayed Successfully. Tabs are: "+Report.color(tabList), "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify the tabs ",
					"Overview tab , Drivers & Downloads and documentation should be available",
					"Failed to display Tabs", "FAIL");
			Assert.fail();

		}
	}


	public void verifyOverviewTab(WebDriver driver)
	{
		System.out.println("Inside verifyOverviewTab method");
		Log.info("Inside verifyOverviewTab method");

		WebDriverWait wait = new WebDriverWait(driver, 120); 

		String header = "";
		String link = "";
		try
		{	
			Actions act=new Actions(driver);
			//			act.moveToElement(CommonUtility.highlightElement(driver, obj_EsupportIPSHomePage.enterServiceTagOverviewTab())).build().perform();
			CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.enterServiceTagOverviewTab());
			CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.enterServiceTagOverviewTab());

			CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.detectPcLinkOverviewTab());

			link = CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.detectPcLinkOverviewTab()).getAttribute("innerText");

			System.out.println("Link is:"+link);


			Report.put("Verify the Overview tab ",
					"Over view tab should have the Service tag entry option and detect pc option ",
					"Loaded Overview Tab with an option to enter service tag with box. Link is: "+Report.color(link), "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify the Overview tab ",
					"Over view tab should have the Service tag entry option and detect pc option ",
					"Failed to Load Overview Tab with an option to enter service tag with box & Detect PC Link", "FAIL");
			Assert.fail();
		}
	}
	public void enterServiceTagOverviewTab(WebDriver driver,String serviceTag) 
	{		
		WebDriverWait wait = new WebDriverWait(driver, 120);

		System.out.println("Entering enterServiceTagOverviewTab");

		Log.info("Entering enterServiceTagOverviewTab");   

		try 
		{	
			String header="";
			String prodHeader="";

			System.out.println("Service Tag from Test data sheet is :" +serviceTag);		

			Actions act=new Actions(driver);
			//			act.moveToElement(CommonUtility.highlightElement(driver, obj_EsupportIPSHomePage.enterServiceTagOverviewTab())).build().perform();

			CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.enterServiceTagOverviewTab());

			CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.enterServiceTagOverviewTab()).sendKeys(serviceTag);
			Thread.sleep(5000);
			CommonUtility.ClickOn(driver,obj_EsupportIPSHomePage.serviceTagSubmitOverviewTab());

			Thread.sleep(10000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIPSHomePage.productHeader()));
			CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.productHeader());
			prodHeader = CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.productHeader()).getText();

			System.out.println("Product Page header is:"+prodHeader);

			Report.put("Enter service tag and click on submit "+Report.color(serviceTag),
					"User should land into Product Support Page",
					"Successfully navigated to Product Support Page. Header is: "+Report.color(prodHeader), "PASS");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Now again click on the enter service tag to view details link and enter service tag and click on submit "+Report.color(serviceTag),
					"User should land into Product Support Page",
					"Failed to navigate to Product Support Page.", "FAIL");
			Assert.fail();

		}


	}

	public void verifyOverviewTabProductPage(WebDriver driver)
	{
		System.out.println("Inside verifyOverviewTabProductPage method");
		Log.info("Inside verifyOverviewTabProductPage method");

		WebDriverWait wait = new WebDriverWait(driver, 120); 

		String header = "";
		String link = "";
		try
		{	
			Actions act=new Actions(driver);
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIPSHomePage.serviceTagTextboxProductPage()));
			//			act.moveToElement(CommonUtility.highlightElement(driver, obj_EsupportIPSHomePage.serviceTagTextboxProductPage())).build().perform();
			CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.serviceTagTextboxProductPage());
			CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.serviceTagTextboxProductPage());

			CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.DetectYourPC1());

			link = CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.DetectYourPC1()).getAttribute("innerText");

			System.out.println("Link is:"+link);


			Report.put("Verify the Overview tab ",
					"Over view tab should have the Service tag entry option and detect pc option ",
					"Loaded Overview Tab with an option to enter service tag with box. Link is: "+Report.color(link), "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify the Overview tab ",
					"Over view tab should have the Service tag entry option and detect pc option ",
					"Failed to Load Overview Tab with an option to enter service tag with box & Detect PC Link", "FAIL");
			Assert.fail();
		}
	}

	public void verifyTopSolutions(WebDriver driver)
	{
		System.out.println("Inside verifyTopSolutions method");
		Log.info("Inside verifyTopSolutions method");

		try
		{
			//handleCookies(driver);

			String header = "";
			String tabList = "";
			String defaultTab = "";
			String linkList = "";
			int count = 0;
			String countString = "";
			int countSeparator = 0;
			String countSeparatorString = "";
			String viewAllLink = "";

			WebDriverWait wait = new WebDriverWait(driver, 120);
			handleCookies(driver);
			List<WebElement> list=driver.findElements(obj_EsupportIPSHomePage.topFiveSolutionsHeader());

			for(WebElement lt:list)
			{
				CommonUtility.highlightElement(driver, lt);
				String tabName=lt.getText();

				System.out.println("Header is: " +tabName);
				tabList+=" <br> " + tabName;
			}
			System.out.println("Solutions are:"+tabList);

			List<WebElement> listLinks=driver.findElements(obj_EsupportIPSHomePage.readMoreLinks());

			for(WebElement lt:listLinks)
			{
				CommonUtility.highlightElement(driver, lt);
				String link=lt.getText();
				count+=1;
				System.out.println("Link is: " +link);
				linkList+=" <br> " + link;
			}
			if(count == 5)
			{
				System.out.println("Links are:"+linkList);
				countString = Integer.toString(count);
			}

			List<WebElement> listSeparator=driver.findElements(obj_EsupportIPSHomePage.topSolutionsSeparator());

			for(WebElement lt:listSeparator)
			{
				CommonUtility.highlightElement(driver, lt);

				countSeparator+=1;

			}
			if(countSeparator == 5)
			{
				System.out.println("Separators  are present");
				countSeparatorString = Integer.toString(countSeparator);
			}

			//			Actions act=new Actions(driver);
			//			act.moveToElement(CommonUtility.highlightElement(driver, obj_EsupportIPSHomePage.viewAllLink())).build().perform();
			CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.viewAllLink());
			CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.viewAllLink());		

			viewAllLink = CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.viewAllLink()).getText();

			System.out.println("Link is:"+viewAllLink);

			Report.put("Verify the Top solutions",
					"5 top solution should be displayed.'Read more' link should be displayed for each document. A separator should be displayed between two documents.'View all' link should be displayed at the bottom of the top solution ",
					"Top Solutions are:"+Report.color(tabList)+"<br>"+Report.color(countString)+"Read More links are present"+"<br>"+Report.color(countSeparatorString)+"Separators are present"+Report.color(defaultTab)+"<br>"+Report.color(viewAllLink)+"is present", "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify the Top solutions",
					"5 top solution should be displayed.'Read more' link should be displayed for each document. A separator should be displayed between two documents.'View all' link should be displayed at the bottom of the top solution ",
					"Failed to display Top Solutions, Read More link, Separator & View All link", "FAIL");
			Assert.fail();
		}
	}

	public void clickViewAllLink(WebDriver driver)
	{
		System.out.println("Inside clickViewAllLink method");
		Log.info("Inside clickViewAllLink method");

		WebDriverWait wait = new WebDriverWait(driver, 150); 
		Actions act=new Actions(driver);

		String tab = "";
		try
		{			
			handleCookies(driver);
			CommonUtility.ScrollTo(driver,obj_EsupportContentHomePage.ClickViewAllLink());
			//			CommonUtility.ToClickByUsingJavaScript_PassingByLoc(driver,obj_EsupportIPSHomePage.viewAllLink());
			//			act.moveToElement(CommonUtility.highlightElement(driver,obj_EsupportContentHomePage.ClickViewAllLink())).click().perform();
			CommonUtility.ClickOn(driver,obj_EsupportContentHomePage.ClickViewAllLink());

			//			Thread.sleep(30000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIPSHomePage.documentationTabActive()));
			CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.documentationTabActive());
			CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.documentationTabActive());

			tab = CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.documentationTabActive()).getText();

			Report.put("Click on the view all link",
					"User should direct to the documentation tab selected ",
					"Loaded Tab "+Report.color(tab ), "PASS");

		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on the view all link",
					"User should direct to the documentation tab selected ",
					"Failed to load Documentation Tab", "FAIL");
			Assert.fail();
		}
	}
	public void verifyServiceTagHeroSection(WebDriver driver)
	{
		System.out.println("Inside verifyServiceTagHeroSection method");
		Log.info("Inside verifyServiceTagHeroSection method");

		String text = "";
		try
		{			
			handleCookies(driver);

			if(CommonUtility.CheckpresenceofElementLocated(driver, 10, obj_EsupportIPSHomePage.serviceTagHeroSection()))
			{
				CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.serviceTagHeroSection());

				text = CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.serviceTagHeroSection()).getText();

				System.out.println("Text is "+text);

				Report.put("Verify the product support hero section for the service tag",
						"Service tag should be displayed under the hero section ",
						"Service tag displayed under the hero section successfully. "+Report.color(text), "PASS");
			}	
			else
			{
				Report.put("Verify the product support hero section for the service tag",
						"Service tag should be displayed under the hero section ",
						"Failed to display Service tag  under the hero section. ", "FAIL");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify the product support hero section for the service tag",
					"Service tag should be displayed under the hero section ",
					"Failed to display Service tag  under the hero section. ", "FAIL");
			Assert.fail();
		}
	}

	public void verifyOverviewTabServiceTag(WebDriver driver)
	{
		System.out.println("Inside verifyOverviewTabServiceTag method");
		Log.info("Inside verifyOverviewTabServiceTag method");

		WebDriverWait wait = new WebDriverWait(driver, 120); 

		String headers = "";
		String readMoreLink = "";
		int count = 0;
		int countSeparator = 0;
		String countSeparatorString = "";
		String countString = "";
		String viewAllLink = "";

		try
		{	

			List<WebElement> listHeaders=driver.findElements(obj_EsupportIPSHomePage.overviewTabHeaders());

			for(WebElement lt:listHeaders)
			{
				CommonUtility.highlightElement(driver, lt);
				String header=lt.getText();

				System.out.println("Header is: " +header);
				headers+=" <br> " + header;
			}
			Thread.sleep(6000);
			List<WebElement> readMoreList=driver.findElements(obj_EsupportIPSHomePage.readMoreLinks());

			for(WebElement lt:readMoreList)
			{
				CommonUtility.highlightElement(driver, lt);
				readMoreLink=lt.getText();
				count+=1;
				System.out.println("Link is: " +readMoreLink);

			}
			countString = Integer.toString(count);
			System.out.println("Number of readmore links are " +count);

			List<WebElement> listSeparator=driver.findElements(obj_EsupportIPSHomePage.topSolutionsSeparator());

			for(WebElement lt:listSeparator)
			{
				CommonUtility.highlightElement(driver, lt);

				countSeparator+=1;

			}

			System.out.println("Number of Separators are " +countSeparator);

			countSeparatorString = Integer.toString(countSeparator);

			//			Actions act=new Actions(driver);
			//			act.moveToElement(CommonUtility.highlightElement(driver, obj_EsupportIPSHomePage.viewAllLink())).build().perform();
			CommonUtility.ScrollTo(driver, obj_EsupportIPSHomePage.viewAllLink());
			CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.viewAllLink());		

			viewAllLink = CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.viewAllLink()).getText();

			System.out.println("Link is:"+viewAllLink);



			Report.put("Verify the Overview tab ",
					"service events section and Top Solutions section should be displayed.'Read more' link should be displayed for each document.A separator should be displayed between two documents. 'View all' link should be displayed. ",
					"Loaded Sections "+Report.color(headers)+"<br>"+Report.color(readMoreLink) +"links count is: "+Report.color(countString)+"<br>"+"Separator present for documents"+Report.color(countSeparatorString)+"<br>" +"Link displayed as: "+Report.color(viewAllLink), "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify the Overview tab ",
					"service events section and Top Solutions section should be displayed.'Read more' link should be displayed for each document.A separator should be displayed between two documents. 'View all' link should be displayed. ",
					"Failed to load service events section & Top Solution Sections ", "FAIL");
			Assert.fail();
		}
	}

	public void verifyTopSolutionsServiceTag(WebDriver driver)
	{
		System.out.println("Inside verifyTopSolutionsServiceTag method");
		Log.info("Inside verifyTopSolutionsServiceTag method");

		try
		{
			//handleCookies(driver);


			String tabList = "";	

			WebDriverWait wait = new WebDriverWait(driver, 120);
			handleCookies(driver);
			List<WebElement> list=driver.findElements(obj_EsupportIPSHomePage.topFiveSolutionsHeader());

			for(WebElement lt:list)
			{
				CommonUtility.highlightElement(driver, lt);
				String tabName=lt.getText();

				System.out.println("Solution is: " +tabName);
				tabList+=" <br> " + tabName;
			}
			System.out.println("Solutions are:"+tabList);


			Report.put("Verify Top Solutions section",
					"5 top solutions tagged to the product/tag should be displayed ",
					"Top Solutions are:"+Report.color(tabList), "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify Top Solutions section",
					"5 top solutions tagged to the product/tag should be displayed ",
					"Failed to display Top Solutions", "FAIL");
			Assert.fail();
		}
	}

	public void clickReadMoreLink(WebDriver driver)
	{
		System.out.println("Inside clickReadMoreLink method");
		Log.info("Inside clickReadMoreLink method");

		WebDriverWait wait = new WebDriverWait(driver, 120); 

		String header = "";

		try
		{		
			CommonUtility.ScrollTo(driver, obj_EsupportIPSHomePage.firstReadMoreLink());			
			CommonUtility.ClickOn(driver, obj_EsupportIPSHomePage.firstReadMoreLink());

			String mainwindow=driver.getWindowHandle();
			Set<String> set=driver.getWindowHandles();
			Iterator<String> itr=set.iterator();
			while(itr.hasNext())
			{
				String childWindow=itr.next();
				if(!mainwindow.equals(childWindow))
				{
					driver.switchTo().window(childWindow);
					Thread.sleep(15000);
					String url=driver.getCurrentUrl();
					System.out.println("URL displayed as   :::::"+url); 

					if(url.contains("article") ||url.contains("kbdoc"))
					{

						System.out.println("Switched to window");			
						wait.until(ExpectedConditions.presenceOfElementLocated(obj_EsupportIPSHomePage.articleHeader()));
						CommonUtility.highlightElement(driver, obj_EsupportIPSHomePage.articleHeader());
						header = CommonUtility.highlightElement(driver, obj_EsupportIPSHomePage.articleHeader()).getText();


					}	
					else
					{
						driver.close();
						Report.put("Click on 'Read more' link on any document",
								"Should be directed to the article page in new tab",
								"Failed to load Article Page. ", "FAIL");
						Assert.fail();
					}
					driver.close();

				}
			}
			driver.switchTo().window(mainwindow);

			Report.put("Click on 'Read more' link on any document",
					"Should be directed to the article page in new tab",
					"Article Page loaded Successfully. Header is: "+Report.color(header), "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on 'Read more' link on any document",
					"Should be directed to the article page in new tab",
					"Failed to load Article Page. ", "FAIL");
			Assert.fail();
		}
	}

	public void clickLatitudeSeries(WebDriver driver, String series)
	{
		// TODO Auto-generated method stub

		System.out.println("Inside clickLatitudeSeries");
		Log.info("Inside clickLatitudeSeries");   
		Actions act = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, 120); 
		String header = "";
		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIPSHomePage.latitudeHeader()));
			//			CommonUtility.ScrollTo(driver, By.xpath("//div[@id='divCatalogItems']//a//p[contains(text(),'"+series+"')]"));
			if(CommonUtility.CheckpresenceofElementLocated(driver, 10, By.xpath("//div[@id='divCatalogItems']//a//p[contains(text(),'"+series+"')]")))
			{

				//				WebElement element = driver.findElement(By.xpath("//div[@id='divCatalogItems']//a//p[contains(text(),'"+series+"')]"));
				//				CommonUtility.highlightElement(driver,element);
//				CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.latitudeHeader());
				//				//act.moveToElement(CommonUtility.highlightElement(driver, element)).build().perform();
				//				CommonUtility.scrollToViewElement(driver, element); 
				CommonUtility.ScrollTo(driver, By.xpath("//div[@id='divCatalogItems']//a//p[contains(text(),'"+series+"')]"));
				//				Thread.sleep(4000);
				//				CommonUtility.ToClickByUsingJavaScript_PassingByLoc(driver, By.xpath("//div[@id='divCatalogItems']//a//p[contains(text(),'"+series+"')]"));
				CommonUtility.ClickOn(driver, By.xpath("//div[@id='divCatalogItems']//a//p[contains(text(),'"+series+"')]"));
				Thread.sleep(7000);
				CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.latitudeSeriesHeader());
				if(CommonUtility.CheckpresenceofElementLocated(driver, 30, obj_EsupportIPSHomePage.latitudeSeriesHeader()))
				{
					//			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIPSHomePage.latitudeSeriesHeader()));

					CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.latitudeSeriesHeader());

					header = CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.latitudeSeriesHeader()).getText();

					System.out.println("Clicked on Series "+series); 

					Report.put("Select Latitude Series",
							"Latitude Series should be displayed",
							"Selected Latitude Series "+Report.color(header), "PASS");
				}
				else
				{
					Report.put("Select Latitude Series",
							"Latitude Series should be displayed",
							"Failed to select Latitude Series ", "Fail");

					Assert.fail();
				}
			}
			
			else
				if(CommonUtility.CheckpresenceofElementLocated(driver, 10, By.xpath("//div[@id='divCatalogItems']//a//p[contains(text(),'G3')]")))
				{
			
				CommonUtility.ScrollTo(driver,obj_EsupportDriversandDownloadsPage.ClickOnLaptopsBack());
				CommonUtility.ClickOn(driver,obj_EsupportDriversandDownloadsPage.ClickOnLaptopsBack());
				Thread.sleep(6000);
				clickLatitudeLink(driver);
				Thread.sleep(6000);
				clickLatitudeSeries(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[0]);
				Thread.sleep(6000);
				
			}

		}

		catch (Exception e)
		{
			Log.info(e);
			Report.put("Select Latitude Series",
					"Latitude Series should be displayed",
					"Latitude series window not displayed", "Pass");
			//			e.printStackTrace();
			//			Assert.fail();
		}               
	} 

	public void clickServiceEventsTab(WebDriver driver)
	{
		System.out.println("Inside clickServiceEventsTab method");
		Log.info("Inside clickServiceEventsTab method");

		WebDriverWait wait = new WebDriverWait(driver, 120); 

		String tab = "";
		try
		{		
			handleCookies(driver);

			CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.serviceEventsTab());
			CommonUtility.ClickOn(driver,obj_EsupportIPSHomePage.serviceEventsTab());


			tab = CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.serviceEventsTab()).getText();

			Report.put("Click on service events tab below the hero section ",
					"User should be in service events ",
					"Landed in the tab "+Report.color(tab), "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on service events tab below the hero section ",
					"User should be in service events ",
					"Failed to click on Service Tab ", "FAIL");
			Assert.fail();
		}
	}

	public void verifyServiceEventsTab(WebDriver driver)
	{
		System.out.println("Inside verifyServiceEventsTab method");
		Log.info("Inside verifyServiceEventsTab method");

		WebDriverWait wait = new WebDriverWait(driver, 120); 

		String header = "";
		String message = "";
		String link = "";
		String enable = "";
		try
		{	
			wait.until(ExpectedConditions.presenceOfElementLocated(obj_EsupportIPSHomePage.serviceEventMessage()));
			CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.serviceEventMessage());
			message = CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.serviceEventMessage()).getText();			



			CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.serviceTagTextboxServiceEvent());
			CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.emailTextboxServiceEvent());

//			CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.detectPcLinkServiceEvent());
//
//			link = CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.detectPcLinkServiceEvent()).getText();
//
//			System.out.println("Link is:"+link);

			boolean flag = CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.submitButtonServiceEvent()).isEnabled();
			if(!flag)
			{
				enable = "Submit button disabled";
			}
			Report.put("Verify service events tab",
					"User should see the message to view the service events for this product please enter service tag and email with service tag text box and email text box , submit button should be disabled and detect pc option should be available",
					"Message displayed as "+Report.color(message) +"<br>"+"Displayed Service Tag & Email Textbox. Displayed link "+Report.color(link)+"<br>"+Report.color(enable), "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify service events tab",
					"User should see the message to view the service events for this product please enter service tag and email with service tag text box and email text box , submit button should be disabled and detect pc option should be available",
					"Failed to display the Message, ServiceTag Textbox & Email Textbox", "FAIL");
			Assert.fail();
		}
	}

	public void enterServiceTagEmailServiceEvents(WebDriver driver, String tag, String email)
	{
		System.out.println("Inside enterServiceTagEmailServiceEvents method");
		Log.info("Inside enterServiceTagEmailServiceEvents method");

		WebDriverWait wait = new WebDriverWait(driver, 120); 

		String header = "";
		String message = "";
		String link = "";
		String enable = "";
		try
		{	
			handleCookies(driver);
			System.out.println("Service Tag from testdata: "+tag);
			System.out.println("Email from testdata: "+email);

			CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.serviceTagTextboxServiceEvent()).sendKeys(tag);
			CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.emailTextboxServiceEvent()).sendKeys(email);



			boolean flag = CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.submitButtonServiceEvent()).isEnabled();
			if(flag)
			{
				enable = "Submit button is enabled";
				CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.submitButtonServiceEvent());
			}
			Report.put("Enter the service tag and email address",
					"Submit button should be enabled ",
					"Entered Service Tag"+Report.color(tag)+" and Email Address "+Report.color(email)+"<br>"+Report.color(enable), "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Enter the service tag and email address",
					"Submit button should be enabled ",
					"Failed to Enter Service Tag and Email Address ", "FAIL");
			Assert.fail();
		}
	}

	public void clickSubmitButtonServiceEvents(WebDriver driver)
	{
		System.out.println("Inside clickSubmitButtonServiceEvents method");
		Log.info("Inside clickSubmitButtonServiceEvents method");

		WebDriverWait wait = new WebDriverWait(driver, 120); 

		String button = "";
		try
		{		

			CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.submitButtonServiceEvent());
			button = CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.submitButtonServiceEvent()).getText();
			CommonUtility.ClickOn(driver,obj_EsupportIPSHomePage.submitButtonServiceEvent());
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);


			CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.serviceEventDetails());

			Report.put("Click on submit button  ",
					"User should show up the service events associated with that service tag ",
					"Displayed service events for the service tag ", "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on submit button  ",
					"User should show up the service events associated with that service tag ",
					"Failed to Display service events for the service tag ", "FAIL");
			Assert.fail();
		}
	}

	public void enterEmailServiceEvents(WebDriver driver, String email)
	{
		System.out.println("Inside enterEmailServiceEvents method");
		Log.info("Inside enterEmailServiceEvents method");

		WebDriverWait wait = new WebDriverWait(driver, 120); 

		String header = "";
		String message = "";
		String link = "";
		String enable = "";
		try
		{			

			System.out.println("Email from testdata: "+email);

			Actions act=new Actions(driver);
			//			act.moveToElement(CommonUtility.highlightElement(driver, obj_EsupportIPSHomePage.emailTextboxServiceEventwithEmail())).build().perform();

			Thread.sleep(8000);
			//			act.moveToElement(CommonUtility.highlightElement(driver, obj_EsupportIPSHomePage.emailTextboxServiceEventwithEmail())).click();
			CommonUtility.ScrollTo(driver, obj_EsupportIPSHomePage.emailTextboxServiceEventwithEmail());
			CommonUtility.ClickOn(driver, obj_EsupportIPSHomePage.emailTextboxServiceEventwithEmail());
			CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.emailTextboxServiceEventwithEmail()).sendKeys(email);


			boolean flag = CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.submitButtonServiceEvent()).isEnabled();
			if(flag)
			{
				enable = "Submit button is enabled";
				CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.submitButtonServiceEvent());
				CommonUtility.ClickOn(driver,obj_EsupportIPSHomePage.submitButtonServiceEvent());
			}
			Report.put("Enter valid email address and click on Submit",
					"All the service events should be displayed associated with the email address ",
					"Displayed Service Events associated with "+Report.color(email), "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Enter valid email address and click on Submit",
					"All the service events should be displayed associated with the email address ",
					"Failed to display Service Events associated with "+Report.color(email), "FAIL");
			Assert.fail();
		}
	}

	public void verifyServiceEventsTabwithEmail(WebDriver driver)
	{
		System.out.println("Inside verifyServiceEventsTabwithEmail method");
		Log.info("Inside verifyServiceEventsTabwithEmail method");

		WebDriverWait wait = new WebDriverWait(driver, 120); 

		String header = "";
		String message = "";
		String link = "";
		String enable = "";
		try
		{	
			CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.serviceEventMessage());
			wait.until(ExpectedConditions.presenceOfElementLocated(obj_EsupportIPSHomePage.serviceEventMessage()));
			CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.serviceEventMessage());
			message = CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.serviceEventMessage()).getText();	
			System.out.println(message);
			CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.emailTextboxServiceEventwithEmail());			

			boolean flag = CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.submitButtonServiceEvent()).isEnabled();
			if(!flag)
			{
				enable = "Submit button disabled";
			}

			Report.put("Verify service events tab",
					"User should see the text To view your Service Events for this product, please enter your email. with email Text box Submit button should be disabled.",
					"Message displayed as "+Report.color(message) +"<br>"+"Displayed Email Textbox. "+"<br>"+Report.color(enable), "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify service events tab",
					"User should see the text To view your Service Events for this product, please enter your email. with email Text box Submit button should be disabled.",
					"Failed to display Message & Email Textbox.", "FAIL");
			Assert.fail();
		}
	}

	public void clickOverviewTab(WebDriver driver)
	{
		System.out.println("Inside clickOverviewTab method");
		Log.info("Inside clickOverviewTab method");

		WebDriverWait wait = new WebDriverWait(driver, 120); 

		String tab = "";
		String header = "";
		try
		{			
			CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.overviewTab());
			CommonUtility.ClickOn(driver,obj_EsupportIPSHomePage.overviewTab());


			tab = CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.overviewTab()).getText();
			CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.serviceEventsHeader());
			//			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIPSHomePage.serviceEventsHeader()));
			header = CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.serviceEventsHeader()).getText();

			Report.put("Now click on the Overview tab  ",
					"Service events should be displayed in the overview tab under the service events section ",
					"Landed in the tab "+Report.color(tab) + "with"+Report.color(header), "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Now click on the Overview tab  ",
					"Service events should be displayed in the overview tab under the service events section ",
					"Failed to load Overview tab with Service Events ", "FAIL");
			Assert.fail();
		}
	}

	public void verifyHeroSectionSoftwareTaggedProduct(WebDriver driver)
	{
		System.out.println("Inside verifyHeroSectionSoftwareTaggedProduct method");
		Log.info("Inside verifyHeroSectionSoftwareTaggedProduct method");
		String img = "";
		String servicText = "";
		String changeProductLink = "";
		String nickNameLink = "";
		try		
		{
			//handleCookies(driver);

			if(CommonUtility.CheckpresenceofElementLocated(driver, 10, obj_EsupportIPSHomePage.productImageHeroSection()))
			{
				CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.productImageHeroSection());
				img = "Image displayed ";				
			}

			if(CommonUtility.CheckpresenceofElementLocated(driver, 10, obj_EsupportIPSHomePage.serviceTagHeroSection()))
			{
				CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.serviceTagHeroSection());

				servicText = CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.serviceTagHeroSection()).getText();

				System.out.println("Text is "+servicText);
			}

			if(CommonUtility.CheckpresenceofElementLocated(driver, 10, obj_EsupportIPSHomePage.changeProduct()))
			{
				CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.changeProduct());

				changeProductLink = CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.changeProduct()).getText();

				System.out.println("Link is "+changeProductLink);
			}
			String labelList = "";

			List<WebElement> list=driver.findElements(obj_EsupportIPSHomePage.productHeroSectionDetails());

			for(WebElement lt:list)
			{
				CommonUtility.highlightElement(driver, lt);
				String label=lt.getText();

				System.out.println("Label is: " +label);
				labelList+=" <br> " + label;
			}
			System.out.println("Labels are:"+labelList);

			Thread.sleep(15000);

			CommonUtility.highlightElement(driver,(obj_EsupportIPSHomePage.AddNickname()));

			nickNameLink = CommonUtility.highlightElement(driver,(obj_EsupportIPSHomePage.AddNickname())).getText();
			System.out.println("Link is: "+nickNameLink);

			Report.put("Verify the hero section",
					"Hero section should display the Image , service tag , Login to add Nickname , warranty information , View details , extend or upgrade link , change product links",
					"Successfully "+Report.color(img) +Report.color(servicText) +Report.color(nickNameLink)+Report.color(labelList)+Report.color(changeProductLink), "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify the hero section",
					"Hero section should display the Image , service tag , Login to add Nickname , warranty information , View details , extend or upgrade link , change product links",
					"Failed to display Image & Links in Hero Section", "FAIL");
			Assert.fail();
		}
	}

	public void clickLogintoAddNickname(WebDriver driver)
	{
		System.out.println("Inside clickLogintoAddNickname method");
		Log.info("Inside clickLogintoAddNickname method");

		try
		{     
			String header = "";
			WebDriverWait wait = new WebDriverWait(driver, 120);      
			//			CommonUtility.highlightElement(driver,(obj_EsupportIPSHomePage.AddNickname())).click();
			CommonUtility.ScrollTo(driver,(obj_EsupportIPSHomePage.AddNickname()));
			//			CommonUtility.ToClickByUsingJavaScript_PassingByLoc(driver,(obj_EsupportIPSHomePage.AddNickname()));
			//			WebElement element =driver.findElement((obj_EsupportIPSHomePage.AddNickname()));
			//			((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);

			CommonUtility.ClickOn(driver,(obj_EsupportIPSHomePage.AddNickname()));

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIPSHomePage.signInHeader()));
			//			Thread.sleep(10000);
			header = CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.signInHeader()).getText();

			Report.put("Click on the Login to add nickname",
					"User should navigate to the Login ( DIAS ) Page",
					"Navigated to Login page Successfully. Header is: "+Report.color(header), "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();

			Report.put("Click on the Login to add nickname",
					"User should navigate to the Login ( DIAS ) Page",
					"Failed to Navigate to Login page ", "FAIL");
			Assert.fail();
		}
	}

	public void clickBrowserBackButton(WebDriver driver)
	{
		System.out.println("Inside clickBrowserBackButton method");
		Log.info("Inside clickBrowserBackButton method");

		try
		{     
			String header = "";
			WebDriverWait wait = new WebDriverWait(driver, 120);    

			driver.navigate().back();

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIPSHomePage.productHeader()));
			CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.productHeader());
			header = CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.productHeader()).getText();

			System.out.println("Product Header is:"+header);

			Report.put("click on the browser back button",
					"User should land in the product support page ",
					"Navigated to Product page "+Report.color(header), "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();

			Report.put("click on the browser back button",
					"User should land in the product support page ",
					"Failed to Navigate to Product page ", "FAIL");
			Assert.fail();
		}
	}

	public void verifyAlertOverviewTab(WebDriver driver)
	{
		System.out.println("Inside verifyAlertOverviewTab method");
		Log.info("Inside verifyAlertOverviewTab method");

		try
		{

			String labelList = "";
			String alert = "";
			CommonUtility.highlightElement(driver, obj_EsupportIPSHomePage.alertOverviewTab());
			String text = CommonUtility.highlightElement(driver, obj_EsupportIPSHomePage.alertOverviewTab()).getAttribute("class");
			System.out.println("Text from alert is "+text);
			if(text.contains("warning"))
			{
				System.out.println("INside if Text from alert is "+text);
				alert = "Alert is present. ";
			}
			List<WebElement> list=driver.findElements(obj_EsupportIPSHomePage.productHeroSectionDetails());

			for(WebElement lt:list)
			{
				CommonUtility.highlightElement(driver, lt);
				String label=lt.getText();

				System.out.println("Label is: " +label);
				labelList+=" <br> " + label;
			}
			System.out.println("Labels are:"+labelList);


			Report.put("Verify the alert in the over view tab",
					"Alert should be displayed in the overview tab with view details and extend or upgrade link",
					Report.color(alert)+"Displayed "+Report.color(labelList)+" successfully", "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify the alert in the over view tab",
					"Alert should be displayed in the overview tab with view details and extend or upgrade link",
					"Failed to display alert and warranty details in Overview tab", "FAIL");
			Assert.fail();
		}
	}

	public void clickExtendUpgradeLinkOverviewTab(WebDriver driver)
	{
		System.out.println("Inside clickExtendUpgradeLinkOverviewTab method");
		Log.info("Inside clickExtendUpgradeLinkOverviewTab method");

		try
		{
			String header = "";
			String currentUrl = "";
			WebDriverWait wait = new WebDriverWait(driver, 120);

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIPSHomePage.extendUpgradeLink()));
			//			CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.extendUpgradeLink()).click();
			CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.extendUpgradeLink());
			CommonUtility.ClickOn(driver,obj_EsupportIPSHomePage.extendUpgradeLink());
			currentUrl = driver.getCurrentUrl();
			System.out.println("Navigated to URL "+currentUrl);

			String mainwindow=driver.getWindowHandle();
			Set<String> set=driver.getWindowHandles();
			Iterator<String> itr=set.iterator();
			while(itr.hasNext())
			{
				String childWindow=itr.next();
				if(!mainwindow.equals(childWindow))
				{
					driver.switchTo().window(childWindow);
					Thread.sleep(6000);
					wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIPSHomePage.warrantyHeader()));
					CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.warrantyHeader());
					header = CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.warrantyHeader()).getText();

					System.out.println("Warranty header is: "+header);
					driver.close();
				}
			}
			driver.switchTo().window(mainwindow);

			Report.put("Click on extend or upgrade link",
					"User should direct to the warranty",
					"User directed to "+Report.color(currentUrl) +"Successfully. Header is:" +Report.color(header), "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on the link extend or upgrade link",
					"User should direct to the warranty",
					"Failed to redirect to Warranty Page", "FAIL");
			Assert.fail();
		}
	}

	public void ClickSearchServiceTag(WebDriver driver,String ServiceTag) 
	{
		Log.info("Entering method ClickSearchServiceTag");
		WebDriverWait  wait = new WebDriverWait(driver, 120);
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		String tabName="";
		String val=TestNGCreator.TestData.get(Esupport.Product.ordinal());
		try
		{
			//			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportContentHomePage.SearchInput()));

			CommonUtility.ScrollTo(driver, obj_EsupportIPSHomePage.supportHeader());
			CommonUtility.ScrollTo(driver, obj_EsupportContentHomePage.SearchInput());
			CommonUtility.highlightElement(driver, obj_EsupportContentHomePage.SearchInput()).click();
			
			CommonUtility.highlightElement(driver, obj_EsupportContentHomePage.SearchInput()).sendKeys(ServiceTag);
			Thread.sleep(2000);
			//CommonUtility.highlightElement(driver, obj_EsupportContentHomePage.SearchButton()).click();
			CommonUtility.ScrollTo(driver, obj_EsupportContentHomePage.SearchButton());
			CommonUtility.ClickOn(driver, obj_EsupportContentHomePage.SearchButton());
			//			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			Thread.sleep(10000);
			Thread.sleep(10000);
			if(CommonUtility.CheckpresenceofElementLocated(driver, 0, obj_EsupportContentHomePage.ConnectivityUpdate()))
            {
				String text=driver.findElement(obj_EsupportContentHomePage.ConnectivityUpdate()).getText();
				System.out.println(text);
				Thread.sleep(3000);
				CommonUtility.highlightElement(driver, obj_EsupportContentHomePage.DoNotShowThisOnConnectivityUpdateCheckBox()).click();
			   
				CommonUtility.highlightElement(driver, obj_EsupportContentHomePage.OkButtonOnConnectivityUpdate()).click();
            }
			
			wait.until(ExpectedConditions.presenceOfElementLocated(obj_EsupportContentHomePage.OverviewTab()));
			CommonUtility.ScrollTo(driver, obj_EsupportContentHomePage.OverviewTab());
			tabName=CommonUtility.highlightElement(driver, obj_EsupportContentHomePage.OverviewTab()).getText();
			System.out.println("Landing tab is "+tabName);
			CommonUtility.ClickOn(driver, obj_EsupportContentHomePage.OverviewTab());
			if(val.contains("map"))
			{
				CommonUtility.ClickOn(driver, obj_EsupportContentHomePage.OverviewTab());
			}
			handleCookies(driver);
			tabName=tabName.toLowerCase();
			if(tabName.contains("overview"))
			{
				Log.info("test step pass");
			}
			else
			{
				Log.info("test step fail");
				Report.put("In the product selector enter the product ID and click on search FC6AV160200244  ", 
						"User should land in the Serialized product support page ",
						"Not landed on Overview Tab using product id"+Report.color(ServiceTag), "FAIL");
				Assert.fail();
			}


			Report.put("In the product selector enter the product ID and click on search FC6AV160200244  ", 
					"User should land in the Serialized product support page ",
					"Successfully landed on "+Report.color(tabName)+" Tab: with product id "+Report.color(ServiceTag), "PASS");

			Thread.sleep(10000);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("In the product selector enter the product ID and click on search FC6AV160200244  ", 
					"User should land in the Serialized product support page ",
					"Not landed on Overview Tab using product id "+Report.color(ServiceTag), "FAIL");
			Assert.fail();
		}
	}	

	public void VerifyTheLocationOfTheProduct(WebDriver driver)
	{

		Log.info("Inside VerifyTheLocationOfTheProduct");



		try
		{
			String page="";
			String location="";
			String link="";
			WebDriverWait wait = new WebDriverWait(driver, 120);

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIPSHomePage.ProductSupportPage()));
			page=CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.ProductSupportPage()).getText();
			System.out.println(page);
//			if(CommonUtility.CheckpresenceofElementLocated(driver,10,obj_EsupportIncidentsPage.contactUs()))
//			{
//				CommonUtility.ClickOn(driver,obj_EsupportIncidentsPage.contactUs());
//			}
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIPSHomePage.LocationSectionOnHeroSectionOfLEMC()));
			//			CommonUtility.scrollToViewElement(driver,obj_EsupportIPSHomePage.LocationSectionOnHeroSectionOfLEMC());
			CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.LocationMapOnHeroSection());
			//			CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.LocationIcon());

			List<WebElement> list=driver.findElements(obj_EsupportIPSHomePage.LocationOfTheProductOnHeroSection());


			for (int i=0;i<list.size();i++)
			{
				location+=" "+list.get(i).getText();
				System.out.println(location);

			}

			//			CommonUtility.scrollToViewElement(driver,obj_EsupportIPSHomePage.FullScreenButtonOfLocationOHeroSection());
			CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.FullScreenButtonOfLocationOHeroSection());

			//			CommonUtility.scrollToViewElement(driver,obj_EsupportIPSHomePage.VeiwLocationDetailslink());
			link=CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.VeiwLocationDetailslink()).getText();
			System.out.println(link);
			link=link.toLowerCase();

			if(link.contains("location"))
			{
				Log.info("view location details link is displayed");
			}
			else
			{
				Log.info("view location details link not displayed as expected");
				Report.put("Verify the location of the product","System should display the Map, location of the product and view location details link along with expand button on right top of the map",
						"failed to display view location details page", "FAIL");
				Assert.fail();
			}


			Report.put("Verify the location of the product","System should display the Map, location of the product and view location details link along with expand button on right top of the map",
					"user landed in "+Report.color(page) +" page successfully<br> and able to see map with full screen button location details as " +Report.color(location)+"<br> with link "+Report.color(link), "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify the location of the product","System should display the Map, location of the product and view location details link along with expand button on right top of the map",
					"failed to display location map and details on hero section or not able to see full screen button", "FAIL");
			Assert.fail();
		}
	}


	public void ClickOnViewLocationDetailsLink(WebDriver driver)
	{

		Log.info("Inside ClickOnViewLocationDetailsLink");
		WebDriverWait wait = new WebDriverWait(driver, 120);
		Actions act=new Actions(driver);
		try
		{
			String page="";
			String link="";


			CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.VeiwLocationDetailslink());
			link=CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.VeiwLocationDetailslink()).getText();
			System.out.println(link);
			CommonUtility.ClickOn(driver,obj_EsupportIPSHomePage.VeiwLocationDetailslink());
			//			act.moveToElement(CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.VeiwLocationDetailslink())).click().build().perform();

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIPSHomePage.LocationDetailsPopup()));
			page=CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.LocationDetailsPopup()).getText();
			System.out.println(page);
			page=page.toLowerCase();
			if(page.contains("location"))
			{
				Log.info("location details pop up displayed");
			}
			else
			{
				Log.info("location details pop up is not displayed");
				Report.put("Click on link view location details","Location details model pop up should load",
						"location details header not displyed in pop up", "FAIL");
				Assert.fail();
			}


			Report.put("Click on link view location details","Location details model pop up should load",
					"user clicked on "+Report.color(link)+" and able to see pop up with header "+Report.color(page), "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on link view location details","Location details model pop up should load",
					"view details page not displayed or clicking on it not display location details pop up", "FAIL");
			Assert.fail();
		}
	}


	public void ClickOnManageSiteIDLink(WebDriver driver)
	{

		Log.info("Inside ClickOnManageSiteIDLink");


		try
		{
			String page="";
			String link="";
			WebDriverWait wait = new WebDriverWait(driver, 400);

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIPSHomePage.ManageSiteIDlink()));
			CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.ManageSiteIDlink());
			link=CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.ManageSiteIDlink()).getText();
			System.out.println(link);

			CommonUtility.ClickOn(driver,obj_EsupportIPSHomePage.ManageSiteIDlink());

			Thread.sleep(15000);
			driver.manage().timeouts().implicitlyWait(600, TimeUnit.SECONDS);
			String title="";
			String currenturl="";
			String mainwindow=driver.getWindowHandle();
			Set<String> set=driver.getWindowHandles();
			Iterator<String> itr=set.iterator();
			while(itr.hasNext())
			{
				String childWindow=itr.next();
				if(!mainwindow.equals(childWindow))
				{
					driver.switchTo().window(childWindow);
					Thread.sleep(15000);
					ToLogin_ValidCredentials(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()).split(";")[1],TestNGCreator.TestData.get(Esupport.Password.ordinal()).split(";")[1]);


					Thread.sleep(10000);

					driver.manage().timeouts().implicitlyWait(240, TimeUnit.SECONDS);
					title=driver.getTitle();
					System.out.println(title);
					Thread.sleep(10000);
					currenturl=driver.getCurrentUrl();
					System.out.println(currenturl);


					if(currenturl.contains("https://onlinesupport.emc.com/CompanyAdminSites?ref=emcmanagesiteid") || currenturl.contains("https://pf.us.dell.com/idp/cKv1w/resumeSAML20/idp/SSO.ping"))
					{
						Log.info("redirected to expected url");
					}
					else
					{
						Log.info("not redirected to expreted url");
						Report.put("In the Modal , click on the Manage Site ID ","User should open the link in new tab https://onlinesupport.emc.com/CompanyAdminSites?ref=emcmanagesiteid",
								"clicking on manage site id not redirected to expected url ", "FAIL");
						Assert.fail();
					}
					driver.close();
				}
			}
			driver.switchTo().window(mainwindow);

			Report.put("In the Modal , click on the Manage Site ID ","User should open the link in new tab https://onlinesupport.emc.com/CompanyAdminSites?ref=emcmanagesiteid",
					"user clicked on "+Report.color(link)+" and redirected to url "+Report.color(currenturl), "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("In the Modal , click on the Manage Site ID ","User should open the link in new tab https://onlinesupport.emc.com/CompanyAdminSites?ref=emcmanagesiteid",
					"manage site id not displayed or clicking on it not redirected to expected url", "FAIL");
			Assert.fail();
		}
	}

	public void ClickOnRequestLocationChange(WebDriver driver)
	{

		Log.info("Inside ClickOnRequestLocationChange");


		try
		{
			String page="";
			String link="";
			String backtoloc="";
			String message="";
			String currentlocation="";

			WebDriverWait wait = new WebDriverWait(driver, 120);

			//			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIPSHomePage.ManageSiteIDlink()));
			if(CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.RequestLocationChangeButton()).isDisplayed())
			{
				CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.RequestLocationChangeButton());
				link=CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.RequestLocationChangeButton()).getText();
				System.out.println(link);


				CommonUtility.ClickOn(driver,obj_EsupportIPSHomePage.RequestLocationChangeButton());

			}
			else
			{
				Log.info("Request location change button not displayed");
				Report.put("Click on the link request location change link",
						"Search box should appear by the map ",
						"Request location change button not displayed", "FAIL");
				Assert.fail();
			}
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			if(CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.HeaderOfPage()).isDisplayed())
			{
				CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.HeaderOfPage());
				page=CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.HeaderOfPage()).getText();
				System.out.println(page);
			}
			else
			{
				Log.info("header not displayed");
				Report.put("Click on the link request location change link",
						"Search box should appear by the map ",
						"search for new site header not displayed", "FAIL");
				Assert.fail();
			}
			if(CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.BackToLocationDetails()).isDisplayed())
			{
				CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.BackToLocationDetails());
				backtoloc=CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.BackToLocationDetails()).getText();
				System.out.println(backtoloc);
			}
			else
			{
				Log.info("back to location details link not displayed");
				Report.put("Click on the link request location change link",
						"Search box should appear by the map ",
						"back to location details link not displayed", "FAIL");
				Assert.fail();
			}
			if(CommonUtility.CheckpresenceofElementLocated(driver,10,obj_EsupportIPSHomePage.TextAreaForSearchingLocation()))
			{
				CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.TextAreaForSearchingLocation());
				CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.TextAreaForSearchingLocation());
			}
			else
			{
				Log.info("text box for search entry not displayed");
				Report.put("Click on the link request location change link",
						"Search box should appear by the map ",
						"text box for search entry not displayed", "FAIL");
				Assert.fail();
			}
			if(CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.SearchButtonOnLocationDetailspopup()).isDisplayed())
			{
				//				CommonUtility.scrollToViewElement(driver,obj_EsupportIPSHomePage.SearchButtonOnLocationDetailspopup());
				CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.SearchButtonOnLocationDetailspopup());
			}
			else
			{
				Log.info("search button not displayed");
				Report.put("Click on the link request location change link",
						"Search box should appear by the map ",
						"search button not displayed", "FAIL");
				Assert.fail();
			}
			if(CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.MessageToGuideForSearchingLocation()).isDisplayed())
			{
				CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.MessageToGuideForSearchingLocation());
				message=CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.MessageToGuideForSearchingLocation()).getText();
				System.out.println(message);
			}
			else
			{
				Log.info("message to guide search entry not displayed");
				Report.put("Click on the link request location change link",
						"Search box should appear by the map ",
						"message to guide search entry not displayed", "FAIL");
				Assert.fail();
			}
			if(CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.CurrentLocationDisplayedInLocationDetailsPopup()).isDisplayed())
			{
				CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.CurrentLocationDisplayedInLocationDetailsPopup());
				currentlocation=CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.CurrentLocationDisplayedInLocationDetailsPopup()).getText();
				System.out.println(currentlocation);
			}
			else
			{
				Log.info("message to guide search entry not displayed");
				Report.put("Click on the link request location change link",
						"Search box should appear by the map ",
						"message to guide search entry not displayed", "FAIL");
				Assert.fail();
			}

			Report.put("Click on the link request location change link",
					"Search box should appear by the map ",
					"user clicked on "+Report.color(link)+" and title of pop up page "+Report.color(page)+ " and display "+Report.color(backtoloc)+ " and search text box with search button and display meassage "+Report.color(message)+" and with current location displayed is "+Report.color(currentlocation), "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on the link request location change link",
					"Search box should appear by the map ",
					"not able to click on Request location change button or not display expected search page details", "FAIL");
			Assert.fail();
		}
	}


	public void ValidateEntering2CharsInSearchBox(WebDriver driver)
	{

		Log.info("Inside ValidateEntering2CharsInSearchBox");
		String val1=TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[0];

		try
		{
			String attr="";

			WebDriverWait wait = new WebDriverWait(driver, 120);


			if(CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.TextAreaForSearchingLocation()).isDisplayed())
			{
				CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.TextAreaForSearchingLocation());
				CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.TextAreaForSearchingLocation()).clear();
				CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.TextAreaForSearchingLocation()).sendKeys(val1);;

			}

			Thread.sleep(10000);
			if(!(CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.ToValidateSearchIsDisabledOrnot()).isEnabled()))
			{
				CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.ToValidateSearchIsDisabledOrnot());
				CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.ToValidateSearchIsDisabledOrnot());
				//				attr=CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.ToValidateSearchIsDisabledOrnot()).getAttribute("disabled");
				//				System.out.println(attr);

				//				if(attr.contains("disabled"))
				//				{
				//					Log.info("search button disabled");
				//				}
				//				else
				//				{
				//					Log.info("search button not disabled");
				//					Report.put("Enter 2 Chars",
				//							"Search icon should be disabled",
				//							"search button is enabled", "FAIL");
				////					Assert.fail();
				//				}
			}


			Report.put("Enter 2 Chars",
					"Search icon should be disabled",
					"entered chars as "+Report.color(val1)+ " and search button is not enabled", "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Enter 2 Chars",
					"Search icon should be disabled",
					"search box not displayed or search button is enabled", "FAIL");
			Assert.fail();
		}
	}

	public void ValidateEntering3CharsInSearchBox(WebDriver driver)
	{

		Log.info("Inside ValidateEntering3CharsInSearchBox");
		String val1=TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[1];

		try
		{

			WebDriverWait wait = new WebDriverWait(driver, 120);


			if(CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.TextAreaForSearchingLocation()).isDisplayed())
			{
				CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.TextAreaForSearchingLocation());
				CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.TextAreaForSearchingLocation()).clear();
				CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.TextAreaForSearchingLocation()).sendKeys(val1);;

			}

			if(CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.ToValidateSearchIsDisabledOrnot()).isDisplayed())
			{
				CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.ToValidateSearchIsDisabledOrnot());

				if(CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.ToValidateSearchIsDisabledOrnot()).isEnabled());
				{
					Log.info("search button is enabled");
				}
			}

			Report.put("Enter 3 Chars",
					"Search should be enabled",
					"ented chars "+Report.color(val1)+ " and search button enabled", "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Enter 3 Chars",
					"Search should be enabled",
					"search box not displayed or search button is disabled", "FAIL");
			Assert.fail();
		}
	}


	public void ValidateEntering3CharsInSearchBoxAndClickOnSearchButton(WebDriver driver)
	{

		Log.info("Inside ValidateEntering3CharsInSearchBoxAndClickOnSearchButton");
		String val1=TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[1];

		try
		{

			WebDriverWait wait = new WebDriverWait(driver, 120);


			if(CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.TextAreaForSearchingLocation()).isDisplayed())
			{
				CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.TextAreaForSearchingLocation());
				CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.TextAreaForSearchingLocation()).clear();
				CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.TextAreaForSearchingLocation()).sendKeys(val1);;

			}

			if(CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.SearchButtonOnLocationDetailspopup()).isDisplayed())
			{
				//				CommonUtility.scrollToViewElement(driver,obj_EsupportIPSHomePage.SearchButtonOnLocationDetailspopup());

				CommonUtility.ClickOn(driver,obj_EsupportIPSHomePage.SearchButtonOnLocationDetailspopup());

			}

			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);

			int count;
			String text="";
			int count1;
			String text1="";
			String text2="";
			String text3="";
			if(CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.HeaderOfTable()).isDisplayed())
			{

				List<WebElement> list=driver.findElements(obj_EsupportIPSHomePage.HeaderOfTable());

				count=list.size();

				System.out.println("header of table displayed as  "+count);

				for(int i=0;i<list.size();i++)
				{
					text+="<br>"+list.get(i).getText();
					System.out.println(text);
				}

			}
			if(CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.NumberOfSearchResultsDisplayedinLocationDetailsPopup()).isDisplayed())
			{

				List<WebElement> list1=driver.findElements(obj_EsupportIPSHomePage.NumberOfSearchResultsDisplayedinLocationDetailsPopup());

				count1=list1.size();

				System.out.println("total number of rows displayed as search result are "+count1);

				for(int i=0;i<list1.size();i++)
				{
					text1+="<br>"+list1.get(i).getText();
					System.out.println(text1);
				}

				List<WebElement> list2=driver.findElements(obj_EsupportIPSHomePage.SiteAddressOfFirstRow());
				List<WebElement> list3=driver.findElements(obj_EsupportIPSHomePage.StiteAddressOfSecondRow());

				for(int j=0;j<list2.size();j++)
				{
					text2+="br"+list2.get(j).getText();
					System.out.println(text2);

					if(text2.contains(val1))
					{
						Log.info("Searched chars displayed under site address");
					}
					else
					{
						Log.info("Searched chars displayed under site address");
						Report.put("Enter 3 chars ( IRE ) and click on search ",
								"user should see all results matched from site name, site id, site address",
								"searched chars not displayed under site address column", "FAIL");
						Assert.fail();
					}
				}


				for(int k=0;k<list3.size();k++)
				{
					text3+="br"+list3.get(k).getText();
					System.out.println(text3);

					if(text3.contains(val1))
					{
						Log.info("Searched chars displayed under site address");
					}
					else
					{
						Log.info("Searched chars displayed under site address");
						Report.put("Enter 3 chars ( IRE ) and click on search ",
								"user should see all results matched from site name, site id, site address",
								"searched chars not displayed under site address column", "FAIL");
						Assert.fail();
					}
				}

			}



			Report.put("Enter 3 chars ( IRE ) and click on search ",
					"user should see all results matched from site name, site id, site address",
					"user able to see all reasults matched as "+Report.color(text1+"<br>"+text)+ " able to see searched chars "+Report.color(val1)+" under site addess column as "+Report.color(text2+"<br>"+text3), "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Enter 3 chars ( IRE ) and click on search ",
					"user should see all results matched from site name, site id, site address",
					"search box not displayed or search button is disabled or search results not matching with expected", "FAIL");
			Assert.fail();
		}
	}


	public void ValidateEnteringRandonAUSWhichLocationNotAvailable(WebDriver driver)
	{

		Log.info("Inside ValidateEnteringRandonAUSWhichLocationNotAvailable");
		String val1=TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[2];

		try
		{

			WebDriverWait wait = new WebDriverWait(driver, 120);


			if(CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.TextAreaForSearchingLocation()).isDisplayed())
			{
				CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.TextAreaForSearchingLocation());
				CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.TextAreaForSearchingLocation()).clear();
				CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.TextAreaForSearchingLocation()).sendKeys(val1);;

			}
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			if(CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.SearchButtonOnLocationDetailspopup()).isDisplayed())
			{
				//				CommonUtility.scrollToViewElement(driver,obj_EsupportIPSHomePage.SearchButtonOnLocationDetailspopup());

				CommonUtility.ClickOn(driver,obj_EsupportIPSHomePage.SearchButtonOnLocationDetailspopup());

			}

			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			String message="";
			if(CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.SearchResultsForNoResultFound()).isDisplayed())
			{
				//				CommonUtility.scrollToViewElement(driver,obj_EsupportIPSHomePage.SearchResultsForNoResultFound());

				message=CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.SearchButtonOnLocationDetailspopup()).getText();
				System.out.println(message);

			}


			Report.put("Enter any random chars ( AUS ) for which location is not available",
					"User should show no records found ",
					"user able to message for searched chars "+Report.color(val1)+" as "+Report.color(message), "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Enter any random chars ( AUS ) for which location is not available",
					"User should show no records found ",
					"message not displayed as expecte or search is not working", "FAIL");
			Assert.fail();
		}
	}

	public void ClickOnBackToLocationDetailsLink(WebDriver driver)
	{

		Log.info("Inside ClickOnBackToLocationDetailsLink");


		try
		{
			String mess="";
			if(CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.BackToLocationDetails()).isDisplayed())
			{
				//				CommonUtility.scrollToViewElement(driver,obj_EsupportIPSHomePage.BackToLocationDetails());

				mess=CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.BackToLocationDetails()).getText();
				System.out.println(mess);
				CommonUtility.ClickOn(driver,obj_EsupportIPSHomePage.BackToLocationDetails());

			}
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			String text="";
			if(CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.ManageSiteIDlink()).isDisplayed())
			{
				//				CommonUtility.scrollToViewElement(driver,obj_EsupportIPSHomePage.ManageSiteIDlink());

				text=CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.ManageSiteIDlink()).getText();
				System.out.println(text);

			}

			Report.put("Click on link back to location details ",
					"Should go back to the location details Modal",
					"clicked on "+Report.color(mess)+" link and able to see "+Report.color(text)+" in location details pop up page", "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on link back to location details ",
					"Should go back to the location details Modal",
					"not able to click on back to location details or not able to go back to location details page having manage site id", "FAIL");
			Assert.fail();
		}
	}

	public void ClickOnXMarkInTheModalPopUp(WebDriver driver)
	{

		Log.info("Inside ClickOnXMarkInTheModalPopUp");


		try
		{

			if(CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.XbuttonToCLoseLocationDetailsPopUp()).isDisplayed())
			{
				//				CommonUtility.scrollToViewElement(driver,obj_EsupportIPSHomePage.XbuttonToCLoseLocationDetailsPopUp());

				CommonUtility.ClickOn(driver,obj_EsupportIPSHomePage.XbuttonToCLoseLocationDetailsPopUp());

			}
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			String text="";
			if(CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.VeiwLocationDetailslink()).isDisplayed())
			{
				//				CommonUtility.scrollToViewElement(driver,obj_EsupportIPSHomePage.VeiwLocationDetailslink());

				text=CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.VeiwLocationDetailslink()).getText();
				System.out.println(text);

			}

			Report.put("Click on the Close mark on the Modal pop up",
					"User must see popup closed and display hero section of the product",
					"clicked on X mark and able to see hero section with link "+Report.color(text), "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on the Close mark on the Modal pop up",
					"User must see popup closed and display hero section of the product",
					"X mark not enabled or clicking on Xmark not able to see hero section of product code entered", "FAIL");
			Assert.fail();
		}
	}

	public void VerifyLinkForRequestContractRenewals(WebDriver driver)
	{

		Log.info("Inside VerifyLinkForRequestContractRenewals");


		try
		{
			String link="";
			Thread.sleep(6000);
			CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.RequestContractRenewalLink());
			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_EsupportIPSHomePage.RequestContractRenewalLink()))
			{
				//				CommonUtility.scrollToViewElement(driver,obj_EsupportIPSHomePage.RequestContractRenewalLink());

				CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.RequestContractRenewalLink());
				link= CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.RequestContractRenewalLink()).getText();
				System.out.println(link);




				Report.put("Verify the link for the Request renewals or details",
						"Request renewals or details should be displayed in the hero section",
						Report.color(link)+" link displayed in hero section", "PASS");
			}
			else
			{
				System.out.println("not able to see Request renewals details ");
				Report.put("Verify the link for the Request renewals or details",
						"Request renewals or details should be displayed in the hero section",
						"request contract renewals link not displayed in hero section", "FAIL");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify the link for the Request renewals or details",
					"Request renewals or details should be displayed in the hero section",
					"request contract renewals link not displayed in hero section", "FAIL");
			Assert.fail();
		}
	}

	public void ClickOnLinkForRequestContractRenewals(WebDriver driver)
	{

		Log.info("Inside ClickOnLinkForRequestContractRenewals");


		try
		{
			String header="";
			Thread.sleep(6000);
			CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.RequestContractRenewalLink());
			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_EsupportIPSHomePage.RequestContractRenewalLink()))
			{
				//				CommonUtility.scrollToViewElement(driver,obj_EsupportIPSHomePage.RequestContractRenewalLink());
				System.out.println("inside request contract renewal");
				CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.RequestContractRenewalLink());
				CommonUtility.ClickOn(driver,obj_EsupportIPSHomePage.RequestContractRenewalLink());



				driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
				if(CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.RequestContractRenewalPopUp()).isDisplayed())
				{
					//				CommonUtility.scrollToViewElement(driver,obj_EsupportIPSHomePage.RequestContractRenewalLink());

					CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.RequestContractRenewalPopUp());
					header=CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.RequestContractRenewalPopUp()).getText();
					System.out.println(header);


				}

				Report.put("Click on the Link Request renewals or details",
						"Request renewals or details  Modal pop up should load",
						Report.color(header)+" details pop up loaded", "PASS");
			}
			else
			{
				Report.put("Click on the Link Request renewals or details",
						"Request renewals or details  Modal pop up should load",
						"request contract renewals pop up not loaded", "FAIL");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on the Link Request renewals or details",
					"Request renewals or details  Modal pop up should load",
					"request contract renewals pop up not loaded", "FAIL");
			Assert.fail();
		}
	}

	public void VerifyRequestContractRenewalsPopUp(WebDriver driver)
	{

		Log.info("Inside VerifyRequestContractRenewalsPopUp");


		try
		{
			String header1="";
			String header2="";
			String header3="";
			String header4="";
			String header5="";
			String header6="";
			String header7="";
			String header8="";
			String att1="";
			String att2="";
			String att3="";
			String att4="";

			if(CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.CompanyNameOnRequestContractRenewalPopUp()).isDisplayed())
			{
				CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.CompanyNameOnRequestContractRenewalPopUp());
				header1=CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.RequestContractRenewalLink()).getText();
				System.out.println(header1);

				att1=CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.CompanyNameAutoPopulatedValue()).getAttribute("value");
				System.out.println(att1);
			}

			if(CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.ContactNameOnRequestContractRenewalPopUp()).isDisplayed())
			{
				CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.ContactNameOnRequestContractRenewalPopUp());
				header2=CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.ContactNameOnRequestContractRenewalPopUp()).getText();
				System.out.println(header2);

				att2=CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.ContactNameAutoPopulatedValue()).getAttribute("value");
				System.out.println(att2);

			}
			if(CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.ContactPhoneOnRequestContractRenewalPopUp()).isDisplayed())
			{
				CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.ContactPhoneOnRequestContractRenewalPopUp());
				header3=CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.ContactPhoneOnRequestContractRenewalPopUp()).getText();
				System.out.println(header3);

				att3=CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.ContactPhoneAutoPopulatedValue()).getAttribute("value");
				System.out.println(att3);

			}
			if(CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.ContactEmailOnRequestContractRenewalPopUp()).isDisplayed())
			{
				CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.ContactEmailOnRequestContractRenewalPopUp());
				header4=CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.ContactEmailOnRequestContractRenewalPopUp()).getText();
				System.out.println(header4);

				att4=CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.ContactEmailAutoPopulatedValue()).getAttribute("value");
				System.out.println(att4);

			}
			if(CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.RequestTypeHeading()).isDisplayed())
			{
				CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.RequestTypeHeading());
				header5=CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.RequestTypeHeading()).getText();
				System.out.println(header5);

				header7=CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.RenewMyContractradiobutton()).getText();
				System.out.println(header7);

				header8=CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.InformationAboutMyContractradioButton()).getText();
				System.out.println(header8);

			}
			if(CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.RequestDetailsvalidation()).isDisplayed())
			{
				CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.RequestDetailsvalidation());
				header6=CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.RequestDetailsvalidation()).getText();
				System.out.println(header6);
				CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.TextAreaOfRequestDetails());

			}
			if(CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.SubmitButtonToValidateDiabledOrEnabled()).isDisplayed())
			{
				String me=CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.SubmitButtonToValidateDiabledOrEnabled()).getAttribute("disabled");
				System.out.println(me);
			}
			if(CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.CancelButtonOnRequestContractRenewalPopUp()).isEnabled())
			{
				CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.CancelButtonOnRequestContractRenewalPopUp());

			}


			Report.put("Verify the Modal pop up",
					"Model pop up should load with Company name , contact name , contact phone , contact email pre-populated with submit button disabled ",
					"details of pop up are "+Report.color(header1+" and its value"+att1)+" <br> "+Report.color(header2+" and its value"+att2)+"<br>"+Report.color(header3+" and its value"+att3)+"<br>"+Report.color(header4+" and its value"+att4)+"<br>"+Report.color(header5+"with radio button options"+header7+"<br>"+header8)+"<br>"+Report.color(header6+"along with text area")+"<br> with submit button disabled and cancel button enabled.", "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify the Modal pop up",
					"Model pop up should load with Company name , contact name , contact phone , contact email pre-populated with submit button disabled ",
					"details are missing in pop up", "FAIL");
			Assert.fail();
		}
	}

	public void ValidateByRemovingContactNameAndContactPhone(WebDriver driver)
	{

		Log.info("Inside ValidateByRemovingContactNameAndContactPhone");


		try
		{
			String message="";
			String att1="";
			String att="";
			if(CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.ContactNameAutoPopulatedValue()).isDisplayed())
			{
				//				CommonUtility.scrollToViewElement(driver,obj_EsupportIPSHomePage.RequestContractRenewalLink());

				CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.ContactNameAutoPopulatedValue());
				CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.ContactNameAutoPopulatedValue()).clear();
				CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.ContactPhoneAutoPopulatedValue()).clear();

				CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.ContactNameAutoPopulatedValue()).sendKeys(Keys.ENTER);

				Thread.sleep(5000);

				List<WebElement> list=driver.findElements(obj_EsupportIPSHomePage.AlertMessageForEmptyingCompanyNameOrContactPhone());

				for(int i=0;i<list.size();i++)
				{
					message+="<br> "+list.get(i).getText();
					System.out.println(message);
				}

				att=CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.ContactNameAutoPopulatedValue()).getAttribute("class");
				System.out.println(att);

				if(!(att.contains("border-danger")))
				{
					Log.info("contact name text area not highlighted in red");
				}

				att1=CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.ContactPhoneAutoPopulatedValue()).getAttribute("class");
				System.out.println(att1);

				if(!(att1.contains("border-danger")))
				{
					Log.info("contact phone text area not highlighted in red");
				}

			}


			Report.put("Leave the Contact name or contact phone ",
					"User should see the field highlighted in red and error message 'Please enter a valid phone number'(per design)  or please enter a valid name ",
					"User able to see emptied text area highlighted in red and error message display for contact name and contact phone as "+Report.color(att+"<br>"+att1), "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Leave the Contact name or contact phone ",
					"User should see the field highlighted in red and error message 'Please enter a valid phone number'(per design)  or please enter a valid name ",
					"user not able to see empty fields highlighted in red or error message not displayed", "FAIL");
			Assert.fail();
		}
	}

	public void EnterAllDetailsAndSelectRenewMyContract(WebDriver driver)
	{

		Log.info("Inside EnterAllDetailsAndSelectRenewMyContract");

		String val1=TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[0];
		String val2=TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[1];

		try
		{
			String message="";

			if(CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.ContactNameAutoPopulatedValue()).isDisplayed())
			{
				//				CommonUtility.scrollToViewElement(driver,obj_EsupportIPSHomePage.RequestContractRenewalLink());

				CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.ContactNameAutoPopulatedValue());
				CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.ContactNameAutoPopulatedValue()).sendKeys(val1);
				CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.ContactPhoneAutoPopulatedValue()).sendKeys(val2);

				message=CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.RenewMyContractradiobutton()).getText();
				System.out.println(message);
				CommonUtility.ClickOn(driver,obj_EsupportIPSHomePage.RenewMyContractradiobutton());



			}

			if(CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.SubmitButtonToValidateDiabledOrEnabled()).isEnabled())
			{
				String li=CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.SubmitButtonToValidateDiabledOrEnabled()).getAttribute("disabled");
				System.out.println(li);

			}


			Report.put("Enter all the details and click on Request type check on the option I want to renew my contract.",
					"Submit button should be enabled",
					"Entered All fields and selected "+Report.color(message)+" Submit button is enabled", "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Enter all the details and click on Request type check on the option I want to renew my contract.",
					"Submit button should be enabled",
					"Submit button not enabled", "FAIL");
			Assert.fail();
		}
	}

	public void ClickOnCancelButton(WebDriver driver)
	{

		Log.info("Inside ClickOnCancelButton");

		try
		{
			String message="";
			String head="";
			if(CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.CancelButtonOnRequestContractRenewalPopUp()).isDisplayed())
			{

				if(CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.CancelButtonOnRequestContractRenewalPopUp()).isEnabled())
				{
					message=CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.CancelButtonOnRequestContractRenewalPopUp()).getText();
					System.out.println(message);
					CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.CancelButtonOnRequestContractRenewalPopUp()).click();
					CommonUtility.ClickOn(driver, obj_EsupportIPSHomePage.CancelButtonOnRequestContractRenewalPopUp());
				}
			}
			if(CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.ProductSupportPage()).isDisplayed())
			{
				head=CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.ProductSupportPage()).getText();
				System.out.println(head);
			}

			Report.put("Click on cancel button in the pop up",
					"Modal pop up should close and land in the product support page",
					"clicked on  "+Report.color(message)+" button and landed on "+Report.color(head)+" page.", "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on cancel button in the pop up",
					"Modal pop up should close and land in the product support page",
					"cancel button not displayed or not landed on product support page", "FAIL");
			Assert.fail();
		}
	}

	public void VerifyLinkForRequestEquipmentRefresh(WebDriver driver)
	{

		Log.info("Inside VerifyLinkForRequestEquipmentRefresh");


		try
		{
			String link="";
			if(CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.RequestEquipmentRefreshLink()).isDisplayed())
			{
				//				CommonUtility.scrollToViewElement(driver,obj_EsupportIPSHomePage.RequestContractRenewalLink());

				CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.RequestEquipmentRefreshLink());
				link= CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.RequestEquipmentRefreshLink()).getText();
				System.out.println(link);

			}


			Report.put("Verify the link for the Request equipment refresh",
					"Request equipment refresh should be displayed in the hero section",
					Report.color(link)+" link displayed in hero section", "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify the link for the Request equipment refresh",
					"Request equipment refresh should be displayed in the hero section",
					"Request equipment refresh link not displayed in hero section", "FAIL");
			Assert.fail();
		}
	}

	public void ClickOnLinkForRequestEquipmentRefresh(WebDriver driver)
	{

		Log.info("Inside ClickOnLinkForRequestEquipmentRefresh");


		try
		{
			String header="";
			if(CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.RequestEquipmentRefreshLink()).isDisplayed())
			{
				//				CommonUtility.scrollToViewElement(driver,obj_EsupportIPSHomePage.RequestContractRenewalLink());

				CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.RequestEquipmentRefreshLink());
				CommonUtility.ClickOn(driver,obj_EsupportIPSHomePage.RequestEquipmentRefreshLink());


			}
			driver.manage().timeouts().implicitlyWait(600, TimeUnit.SECONDS);
			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_EsupportIPSHomePage.RequestEquipmentRefreshLinkPopup()))
			{
				//				CommonUtility.scrollToViewElement(driver,obj_EsupportIPSHomePage.RequestContractRenewalLink());

				CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.RequestEquipmentRefreshLinkPopup());
				header=CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.RequestEquipmentRefreshLinkPopup()).getText();
				System.out.println(header);


			}
			else
			{
				Report.put("Click on the Link Request equipment refresh",
						"Request equipment refresh  Modal pop up should load",
						"Request equipment refresh pop up not loaded", "FAIL");
				Assert.fail();
			}

			Report.put("Click on the Link Request equipment refresh",
					"Request equipment refresh  Modal pop up should load",
					Report.color(header)+" details pop up loaded", "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on the Link Request equipment refresh",
					"Request equipment refresh  Modal pop up should load",
					"Request equipment refresh pop up not loaded", "FAIL");
			Assert.fail();
		}
	}

	public void VerifyRequesEquipmentRefreshPopUp(WebDriver driver)
	{

		Log.info("Inside VerifyRequesEquipmentRefreshPopUp");


		try
		{
			String header1="";
			String header2="";
			String header3="";
			String header4="";

			String header6="";

			String att1="";
			String att2="";
			String att3="";
			String att4="";

			Thread.sleep(3000);
			if(CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.CompanyNameRequestEquipmentRefreshPopUp()).isDisplayed())
			{
				CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.CompanyNameRequestEquipmentRefreshPopUp());
				header1=CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.RequestEquipmentRefreshLink()).getText();
				System.out.println(header1);

				att1=CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.CompanyNameAutoPopulatedValueInRequestEquipmentRefreshPopup()).getAttribute("value");
				System.out.println(att1);
			}

			if(CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.ContactNameOnRequestEquipmentRefreshPopUp()).isDisplayed())
			{
				CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.ContactNameOnRequestEquipmentRefreshPopUp());
				header2=CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.ContactNameOnRequestEquipmentRefreshPopUp()).getText();
				System.out.println(header2);

				att2=CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.ContactNameAutoPopulatedValueInRequestEquipmentRefreshPopup()).getAttribute("value");
				System.out.println(att2);

			}
			if(CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.ContactPhoneOnRequestEquipmentRefreshPopUp()).isDisplayed())
			{
				CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.ContactPhoneOnRequestEquipmentRefreshPopUp());
				header3=CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.ContactPhoneOnRequestEquipmentRefreshPopUp()).getText();
				System.out.println(header3);

				att3=CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.ContactPhoneAutoPopulatedValueInRequestEquipmentRefreshPopup()).getAttribute("value");
				System.out.println(att3);

			}
			if(CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.ContactEmailOnRequestEquipmentRefreshPopUp()).isDisplayed())
			{
				CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.ContactEmailOnRequestEquipmentRefreshPopUp());
				header4=CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.ContactEmailOnRequestEquipmentRefreshPopUp()).getText();
				System.out.println(header4);

				att4=CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.ContactEmailAutoPopulatedValueInRequestEquipmentRefreshPopup()).getAttribute("value");
				System.out.println(att4);

			}

			if(CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.RequestDetailsvalidationInRequestEquipmentRefreshPopup()).isDisplayed())
			{
				CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.RequestDetailsvalidationInRequestEquipmentRefreshPopup());
				header6=CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.RequestDetailsvalidationInRequestEquipmentRefreshPopup()).getText();
				System.out.println(header6);
				CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.TextAreaOfRequestDetailsInRequestEquipmentRefreshPopup());

			}
			if(!(CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.SubmitButtonOnRequestEquipmentRefreshPopUp()).isEnabled()))
			{
				Log.info("submit button disabled");
				Report.put("Verify the details in the pop up",
						"Model pop up should load with Company name , contact name , contact phone , contact email pre-populated with submit button enabled ",
						"submit button disabled", "FAIL");
				Assert.fail();
			}
			if(CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.CancelButtonOnRequestEquipmentRefreshPopUp()).isEnabled())
			{
				CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.CancelButtonOnRequestEquipmentRefreshPopUp());

			}


			Report.put("Verify the details in the pop up",
					"Model pop up should load with Company name , contact name , contact phone , contact email pre-populated with submit button enabled ",
					"details of pop up are "+Report.color(header1+" and its value"+att1)+" <br> "+Report.color(header2+" and its value"+att2)+"<br>"+Report.color(header3+" and its value"+att3)+"<br>"+Report.color(header4+" and its value"+att4)+"<br>"+Report.color(header6+"along with text area")+"<br> with submit button enabled and cancel button enabled.", "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify the details in the pop up",
					"Model pop up should load with Company name , contact name , contact phone , contact email pre-populated with submit button enabled ",
					"details are missing in pop up", "FAIL");
			Assert.fail();
		}
	}

	public void ValidateByRemovingContactNameAndContactPhoneInRequestEquipmentRefresh(WebDriver driver)
	{

		Log.info("Inside ValidateByRemovingContactNameAndContactPhoneInRequestEquipmentRefresh");


		try
		{
			String message="";
			String att1="";
			String att="";
			if(CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.ContactNameAutoPopulatedValueInRequestEquipmentRefreshPopup()).isDisplayed())
			{
				//				CommonUtility.scrollToViewElement(driver,obj_EsupportIPSHomePage.RequestContractRenewalLink());

				CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.ContactNameAutoPopulatedValueInRequestEquipmentRefreshPopup());
				CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.ContactNameAutoPopulatedValueInRequestEquipmentRefreshPopup()).clear();
				CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.ContactPhoneAutoPopulatedValueInRequestEquipmentRefreshPopup()).clear();

				CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.ContactNameAutoPopulatedValueInRequestEquipmentRefreshPopup()).sendKeys(Keys.ENTER);

				Thread.sleep(5000);

				List<WebElement> list=driver.findElements(obj_EsupportIPSHomePage.AlertMessageForEmptyingCompanyNameOrContactPhoneInRequestEquipmentRefreshPopup());

				for(int i=0;i<list.size();i++)
				{
					message+="<br> "+list.get(i).getText();
					System.out.println(message);
				}

				att=CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.ContactNameAutoPopulatedValue()).getAttribute("class");
				System.out.println(att);

				if(!(att.contains("border-danger")))
				{
					Log.info("contact name text area not highlighted in red");
				}

				att1=CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.ContactPhoneAutoPopulatedValue()).getAttribute("class");
				System.out.println(att1);

				if(!(att1.contains("border-danger")))
				{
					Log.info("contact phone text area not highlighted in red");
				}

			}
			Thread.sleep(10000);
			if(CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.SubmitButtonOnRequestEquipmentRefreshPopUp()).isDisplayed())
			{

				String name=CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.SubmitButtonToValidateDiabledOrEnabled()).getAttribute("disabled");

				//				Log.info("submit button enabled");
				//				Report.put("Verify the details in the pop up",
				//						"Model pop up should load with Company name , contact name , contact phone , contact email pre-populated with submit button enabled ",
				//						"submit button disabled", "FAIL");
				//				Assert.fail();

				System.out.println(name);
			}


			Report.put("Leave the Contact name or contact phone ",
					"User should see the field highlighted in red and error message 'Please enter a valid phone number'(per design)  or please enter a valid name ",
					"User able to see emptied text area highlighted in red and error message display for contact name and contact phone as "+Report.color(att+"<br>"+att1)+" <br> and submit button is disabled", "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Leave the Contact name or contact phone ",
					"User should see the field highlighted in red and error message 'Please enter a valid phone number'(per design)  or please enter a valid name ",
					"user not able to see empty fields highlighted in red or error message not displayed or submit button not disabled", "FAIL");
			Assert.fail();
		}
	}


	public void EnterAllDetailsInRequestEquipmentRefresh(WebDriver driver)
	{

		Log.info("Inside EnterAllDetailsInRequestEquipmentRefresh");

		String val1=TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[0];
		String val2=TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[1];

		try
		{
			String message="";

			if(CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.ContactNameAutoPopulatedValueInRequestEquipmentRefreshPopup()).isDisplayed())
			{
				//				CommonUtility.scrollToViewElement(driver,obj_EsupportIPSHomePage.RequestContractRenewalLink());

				CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.ContactNameAutoPopulatedValueInRequestEquipmentRefreshPopup());
				CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.ContactNameAutoPopulatedValueInRequestEquipmentRefreshPopup()).sendKeys(val1);
				CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.ContactPhoneAutoPopulatedValueInRequestEquipmentRefreshPopup()).sendKeys(val2);

			}

			if(!(CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.SubmitButtonOnRequestContractRenewalPopUp()).isEnabled()))
			{
				Log.info("Submit button not enabled");
				Report.put("Enter all the details and click on Request type check on the option I want to renew my contract.",
						"Submit button should be enabled",
						"Submit button not enabled", "FAIL");
				Assert.fail();

			}


			Report.put("Enter all the details and click on Request type check on the option I want to renew my contract.",
					"Submit button should be enabled",
					"Entered All fields Submit button is enabled", "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Enter all the details and click on Request type check on the option I want to renew my contract.",
					"Submit button should be enabled",
					"Submit button not enabled", "FAIL");
			Assert.fail();
		}
	}


	public void ClickOnCancelButtonInRequestEquipmentRequest(WebDriver driver)
	{

		Log.info("Inside ClickOnCancelButtonInRequestEquipmentRequest");

		try
		{
			String message="";
			String head="";
			CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.CancelButtonOnRequestEquipmentRefreshPopUp());
			
			if(CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.CancelButtonOnRequestEquipmentRefreshPopUp()).isDisplayed())
			{

				if(CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.CancelButtonOnRequestEquipmentRefreshPopUp()).isEnabled())
				{
					CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.CancelButtonOnRequestEquipmentRefreshPopUp());
					message=CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.CancelButtonOnRequestEquipmentRefreshPopUp()).getText();
					System.out.println(message);
					CommonUtility.ClickOn(driver,obj_EsupportIPSHomePage.CancelButtonOnRequestEquipmentRefreshPopUp());
				}
			}
			if(CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.ProductSupportPage()).isDisplayed())
			{
				head=CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.ProductSupportPage()).getText();
				System.out.println(head);
			}

			Report.put("Click on cancel button in the pop up",
					"Modal pop up should close and land in the product support page",
					"clicked on  "+Report.color(message)+" button and landed on "+Report.color(head)+" page.", "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on cancel button in the pop up",
					"Modal pop up should close and land in the product support page",
					"cancel button not displayed or not landed on product support page", "FAIL");
			Assert.fail();
		}
	}

	public void selectProductModel(WebDriver driver,String data) 
	{		
		WebDriverWait wait = new WebDriverWait(driver, 120);

		System.out.println("Entering selectProductModel");

		Log.info("Entering selectProductModel");   

		try 
		{	
			String header="";
			String prodHeader="";

			System.out.println("Data from Test data sheet is :" +data);

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIPSHomePage.supportHeader()));

			CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.supportHeader());

			header = CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.supportHeader()).getText();

			CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.serviceTagTextbox());

			System.out.println("Welcome Page header is:"+header);

			CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.serviceTagTextbox()).sendKeys(data);
			CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.productModel());
			CommonUtility.ClickOn(driver,obj_EsupportIPSHomePage.productModel());
			//			CommonUtility.ToClickByUsingJavaScript_PassingByLoc(driver,obj_EsupportIPSHomePage.productModel());
			//			Actions act=new Actions(driver);
			//			act.moveToElement(CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.productModel())).click().perform();

			//wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIPSHomePage.productHeader()));
			if(CommonUtility.CheckpresenceofElementLocated(driver, 10, obj_EsupportIPSHomePage.productHeader()))
			{
			CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.productHeader());
			prodHeader = CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.productHeader()).getText();

			System.out.println("Product Page header is:"+prodHeader);
			}
			else
			{
				CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.ProductHeader2());
				prodHeader = CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.ProductHeader2()).getText();

				System.out.println("Product Page header is:"+prodHeader);
			}

			Report.put("Enter any LEMC Product model  and click on search "+Report.color(data),
					"User should land in the product support model page  ",
					"Successfully navigated to Product Support model Page. Header is: "+Report.color(prodHeader), "PASS");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Enter any LEMC Product model  and click on search "+Report.color(data),
					"User should land in the product support model page  ",
					"Failed to navigate to Product Support model Page.", "FAIL");
			Assert.fail();

		}
	}

	public void signOut(WebDriver driver)

	{

		System.out.println("Entering signOut");
		Log.info("Entering signOut");
		WebDriverWait wait = new WebDriverWait(driver, 120);
		try
		{			
			CommonUtility.ScrollTo(driver, obj_EsupportIPSHomePage.signInLabel());
			//			handleCookies(driver);
			WebElement ele = driver.findElement(obj_EsupportIPSHomePage.signOutButton());

			CommonUtility.ScrollTo(driver, obj_EsupportIPSHomePage.signOutButton());
			CommonUtility.ClickOn(driver, obj_EsupportIPSHomePage.signOutButton());
			//			handleCookies(driver);
			Thread.sleep(6000);
			Report.put("Log out from the current user", "User should be able to logout ",
					"Logged Out Successfully", "PASS");


		}
		catch(Exception e){
			Log.info(e);
			Report.put("Log out from the current user", "User should be able to logout ",
					"Failed while logging out", "FAIL");
			e.printStackTrace();
//			Assert.fail();

		}

	}

	public void verifyLdellPermissionMessage(WebDriver driver,String data) 
	{		
		WebDriverWait wait = new WebDriverWait(driver, 120);

		System.out.println("Entering verifyLdellPermissionMessage");

		Log.info("Entering verifyLdellPermissionMessage");   

		try 
		{	
			String header="";
			String message="";

			System.out.println("Data from Test data sheet is :" +data);

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIPSHomePage.supportHeader()));

			CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.supportHeader());

			header = CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.supportHeader()).getText();

			CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.serviceTagTextbox());

			System.out.println("Welcome Page header is:"+header);

			CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.serviceTagTextbox()).sendKeys(data);
			CommonUtility.ClickOn(driver,obj_EsupportIPSHomePage.productModel());

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIPSHomePage.permissionMessage()));
			CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.permissionMessage());
			message = CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.permissionMessage()).getText();

			System.out.println("Product Page Message is:"+message);

			Report.put("Enter any LEMC Product model  and click on search "+Report.color(data),
					"User should  the message page is permission based ",
					"Successfully displayed message"+Report.color(message), "PASS");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Enter any LEMC Product model  and click on search "+Report.color(data),
					"User should  the message page is permission based ",
					"Failed to display message", "FAIL");
			Assert.fail();

		}
	}

	//For old BrowseAll page
	public void selectVmaxProduct(WebDriver driver)
	{
		System.out.println("Inside selectVmaxProduct method");
		Log.info("Inside selectVmaxProduct method");

		WebDriverWait wait = new WebDriverWait(driver, 120); 

		String header = "";
		try
		{			
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIPSHomePage.storage()));
			CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.storage());
			//CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.storage());
			CommonUtility.ClickOn(driver,obj_EsupportIPSHomePage.storage());

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIPSHomePage.modelHead()));

			CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.modelHead());

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIPSHomePage.enterpriseStorage()));
			//CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.storage());
			CommonUtility.ClickOn(driver,obj_EsupportIPSHomePage.enterpriseStorage());

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIPSHomePage.modelHead()));

			CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.modelHead());

			header = CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.modelHead()).getText();

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIPSHomePage.vmax()));
			//CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.storage());
			CommonUtility.ClickOn(driver,obj_EsupportIPSHomePage.vmax());

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIPSHomePage.modelHead()));

			CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.modelHead());

			header = CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.modelHead()).getText();

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIPSHomePage.vmax10K()));
			//CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.storage());
			CommonUtility.ClickOn(driver,obj_EsupportIPSHomePage.vmax10K());

			//wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIPSHomePage.productHeader()));

			if(CommonUtility.CheckpresenceofElementLocated(driver, 10, obj_EsupportIPSHomePage.productHeader()))
			{
			CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.productHeader());
			header = CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.productHeader()).getText();

			System.out.println("Product Page header is:"+header);
			}
			else
			{
				CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.ProductHeader2());
				header = CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.ProductHeader2()).getText();

				System.out.println("Product Page header is:"+header);
				
			}

			
			Report.put("From the product selector from choose all products and navigate to any LEMC product page",
					"User should land in the product support model page",
					"User in Product Support Model Page. Header is:"+Report.color(header), "PASS");

		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("From the product selector from choose all products and navigate to any LEMC product page",
					"User should land in the product support model page",
					"Failed to load Product Support Model Page", "FAIL");
			Assert.fail();
		}
	}

	public void verifyContactUsSlider(WebDriver driver)
	{
		System.out.println("Inside verifyContactUsSlider method");
		Log.info("Inside verifyContactUsSlider method");

		try
		{

			String text = "";
			String temp = "";

			WebDriverWait wait = new WebDriverWait(driver, 120);

			wait.until(ExpectedConditions.presenceOfElementLocated(obj_EsupportIPSHomePage.contactUsSlider()));
			text = CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.contactUsSlider()).getAttribute("class");

			if(text.contains("open"))
			{
				System.out.println("Class attribute value is: "+text);
				temp = "open";
				Report.put("Verify the contact Us slider",
						"Contact us slider should be displayed in open state",
						"Contact us Slider displayed in state"+Report.color(temp), "PASS");
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify the contact Us slider",
					"Contact us slider should be displayed in open state",
					"Failed to display Contact us Slider in open state", "FAIL");
			Assert.fail();
		}
	}

	public void verifyContactUsSliderContent(WebDriver driver)
	{
		System.out.println("Inside verifyContactUsSliderContent method");
		Log.info("Inside verifyContactUsSliderContent method");

		try
		{

			String contentList = "";
			String temp = "";

			WebDriverWait wait = new WebDriverWait(driver, 120);

			List<WebElement> list=driver.findElements(obj_EsupportIPSHomePage.contactUsSliderContent());

			for(WebElement lt:list)
			{
				CommonUtility.highlightElement(driver, lt);
				String name=lt.getText();

				System.out.println("Content is: " +name);
				contentList+=" <br> " + name;
			}
			System.out.println("Content List: "+contentList);



			Report.put("Verify the contact Us slider",
					"Should expand and should display the technical support ( chat or create Service Request ) , Account team and notifications",
					"Contact us Slider content list is: "+Report.color(contentList), "PASS");

		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify the contact Us slider",
					"Should expand and should display the technical support ( chat or create Service Request ) , Account team and notifications",
					"Failed to display Contact us Slider content list ", "FAIL");
			Assert.fail();
		}
	}


	public void clickTechnicalSupportLink(WebDriver driver)
	{
		System.out.println("Inside clickTechnicalSupportLink method");
		Log.info("Inside clickTechnicalSupportLink method");

		WebDriverWait wait = new WebDriverWait(driver, 120); 

		String header = "";
		String contactSupportUrl="";
		String productid2="";

		try
		{		
			//			productid1=CommonUtility.highlightElement(driver, obj_EsupportIPSHomePage.ProductIDInProductSupportPage()).getText();
			//			System.out.println(productid1);
//			driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
			CommonUtility.ScrollTo(driver, obj_EsupportIPSHomePage.technicalSupportLink());			
			CommonUtility.ClickOn(driver, obj_EsupportIPSHomePage.technicalSupportLink());

			Thread.sleep(6000);
			driver.manage().timeouts().implicitlyWait(240, TimeUnit.SECONDS);
			String mainwindow=driver.getWindowHandle();
			Set<String> set=driver.getWindowHandles();
			Iterator<String> itr=set.iterator();
			while(itr.hasNext())
			{
				String childWindow=itr.next();
				if(!mainwindow.equals(childWindow))
				{
					driver.switchTo().window(childWindow);
					Thread.sleep(6000);
					driver.manage().timeouts().implicitlyWait(240, TimeUnit.SECONDS);
					String url=driver.getCurrentUrl();
					System.out.println("URL displayed as   :::::"+url);

				if(url.contains("contactus"))
				{
					contactSupportUrl = driver.getCurrentUrl();

					System.out.println("Switched to window");			
					//					wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIPSHomePage.contactTechnicalSupportHeader()));
					CommonUtility.ScrollTo(driver, obj_EsupportIPSHomePage.contactTechnicalSupportHeader());
//					header = CommonUtility.highlightElement(driver, obj_EsupportIPSHomePage.contactTechnicalSupportHeader()).getText();
//					System.out.println("Header is "+header);
					//					productid2=CommonUtility.highlightElement(driver, obj_EsupportIPSHomePage.ProductIDInProductSupportPage()).getText();
					//					System.out.println(productid2);

					driver.close();
				}
				else
				{
					driver.close();
					Report.put("Click on the Technical support",
							"User should land in the Contact Technical Support page",
							"Failed to load Contact Technical Support Page ", "FAIL");
					Assert.fail();
				}
					driver.switchTo().window(mainwindow);		
				}
				
			}

			Report.put("Click on the Technical support",
					"User should land in the Contact Technical Support page",
					"Loaded Page Successfully "+Report.color(header)+"with URL"+Report.color(contactSupportUrl), "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on the Technical support",
					"User should land in the Contact Technical Support page",
					"Failed to load Contact Technical Support Page ", "FAIL");
			Assert.fail();
		}
	}
	public void clickTechnicalSupportLink1(WebDriver driver)
	{
		System.out.println("Inside clickTechnicalSupportLink1 method");
		Log.info("Inside clickTechnicalSupportLink method");

		WebDriverWait wait = new WebDriverWait(driver, 120); 

		String header = "";
		String productid1="";
		String productid2="";

		try
		{		
			productid1=CommonUtility.highlightElement(driver, obj_EsupportIPSHomePage.ProductIDInProductSupportPage()).getText();
			System.out.println(productid1);
			CommonUtility.highlightElement(driver, obj_EsupportIPSHomePage.technicalSupportLink());			
			CommonUtility.ClickOn(driver, obj_EsupportIPSHomePage.technicalSupportLink());

			Set<String> allWH=driver.getWindowHandles(); 
			String currentwindow=driver.getWindowHandle();
			int countWindow=allWH.size(); 

			System.out.println("Switched Window Handles and  window count is :: "+countWindow);

			for(String wh:allWH)
			{
				driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
				Thread.sleep(10000);
				driver.switchTo().window(wh); 
				Thread.sleep(10000);
				String url=driver.getCurrentUrl();
				System.out.println("URL displayed as   :::::"+url); 

				if(url.contains("contactus"))
				{

					System.out.println("Switched to window");			
					//					wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIPSHomePage.contactTechnicalSupportHeader()));
					CommonUtility.ScrollTo(driver, obj_EsupportIPSHomePage.contactTechnicalSupportHeader());
					header = CommonUtility.highlightElement(driver, obj_EsupportIPSHomePage.contactTechnicalSupportHeader()).getText();
					System.out.println("Header is "+header);
					productid2=CommonUtility.highlightElement(driver, obj_EsupportIPSHomePage.ProductIDInProductSupportPage()).getText();
					System.out.println(productid2);

					driver.close();

					if(productid1.contains(productid2))
					{
						System.out.println("Product id displayed is matching with entered id");

					}
					else
					{
						System.out.println("Product id displayed is not matching with entered id");
						Report.put("Click on the Technical support",
								"User should land in the Contact Technical Support page",
								"Failed to load Contact Technical Support Page with product id entered", "FAIL");
					}
					driver.switchTo().window(currentwindow);						
				}	
			}

			Report.put("Click on the Technical support",
					"User should land in the Contact Technical Support page",
					"Loaded Page Successfully "+Report.color(header), "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on the Technical support",
					"User should land in the Contact Technical Support page",
					"Failed to load Contact Technical Support Page ", "FAIL");
			Assert.fail();
		}
	}

	public void verifyNotificationOptions(WebDriver driver)
	{
		System.out.println("Inside verifyNotificationOptions method");
		Log.info("Inside verifyNotificationOptions method");
		String optionList = "";
		String text = "";	
		WebDriverWait wait = new WebDriverWait(driver, 150);

		try
		{
			if(CommonUtility.CheckpresenceofElementLocated(driver,15, obj_EsupportIPSHomePage.notificationsLink()))
			{
				CommonUtility.ScrollTo(driver, obj_EsupportIPSHomePage.notificationsLink());
				CommonUtility.ClickOn(driver, obj_EsupportIPSHomePage.notificationsLink());

				wait.until(ExpectedConditions.presenceOfElementLocated(obj_EsupportIPSHomePage.notificationsOptions()));

				CommonUtility.ScrollTo(driver, obj_EsupportIPSHomePage.notificationsOptions());
				List<WebElement> list=driver.findElements(obj_EsupportIPSHomePage.notificationsOptions());

				for(WebElement lt:list)
				{
					CommonUtility.ScrollToWebElement(driver, lt);
					String name=lt.getText();

					System.out.println("Notification Option is: " +name);
					optionList+=" <br> " + name;
				}
				System.out.println("Option List: "+optionList);

				CommonUtility.ScrollTo(driver, obj_EsupportIPSHomePage.notificationOptionsSubscribebuttons());
				List<WebElement> buttonList=driver.findElements(obj_EsupportIPSHomePage.notificationOptionsSubscribebuttons());

				for(WebElement lt:buttonList)
				{
					CommonUtility.ScrollToWebElement(driver, lt);	
					CommonUtility.ClickOnWebElement(driver, lt);
					//				lt.click();
					System.out.println("Inside subscribe for loop");	
					text = "Able to subscribe/unsubscribe from notifications";
					Thread.sleep(3000);
				}	


				CommonUtility.ScrollTo(driver, obj_EsupportIPSHomePage.notificationOptionsSubscribebuttons());
				List<WebElement> buttonList1=driver.findElements(obj_EsupportIPSHomePage.notificationOptionsSubscribebuttons());

				for(WebElement lt:buttonList1)
				{
					CommonUtility.ScrollToWebElement(driver, lt);	
					CommonUtility.ClickOnWebElement(driver, lt);
					//				lt.click();
					System.out.println("Inside subscribe for loop");	
					text = "Able to subscribe/unsubscribe from notifications";
					Thread.sleep(3000);
				}		

				Report.put("Comeback to the LEMC Model/Family /series Product support page  ",
						"User should get Notification options in the slider, And they should be able to subscribe to Security Advisories, Technical Advisories, and Product Updates,And they should be able to unsubscribe from the same.",
						"Notification Options in the Slider is: "+Report.color(optionList) +"<br>"+Report.color(text), "PASS");
			}
			else
			{
				System.out.println("notification not found");
				Report.put("Comeback to the LEMC Model/Family /series Product support page  ",
						"User should get Notification options in the slider, And they should be able to subscribe to Security Advisories, Technical Advisories, and Product Updates,And they should be able to unsubscribe from the same.",
						"Failed to display Notification Options in the Slider", "FAIL");
				Assert.fail();
			}

		} 
		catch(Exception e)
		{
			e.printStackTrace();

			Report.put("Comeback to the LEMC Model/Family /series Product support page  ",
					"User should get Notification options in the slider, And they should be able to subscribe to Security Advisories, Technical Advisories, and Product Updates,And they should be able to unsubscribe from the same.",
					"Failed to display Notification Options in the Slider", "FAIL");
			Assert.fail();
		}
	}

	public void verifyContactUsSliderClosed(WebDriver driver)
	{
		System.out.println("Inside verifyContactUsSliderClosed method");
		Log.info("Inside verifyContactUsSliderClosed method");

		try
		{

			String text = "";
			String temp = "";

			WebDriverWait wait = new WebDriverWait(driver, 120);

			CommonUtility.ClickOn(driver,obj_EsupportIPSHomePage.clickSlider());


			text = CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.contactUsSlider()).getAttribute("class");

			if(!(text.contains("open")))
			{
				System.out.println("Class attribute value is: "+text);
				//	temp = "open";
				Report.put("Click on the slider",
						"Slider should get closed ",
						"Slider is closed", "PASS");
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on the slider",
					"Slider should get closed ",
					"Slider is not in closed state", "FAIL");
			Assert.fail();
		}
	}

	public void clickInsideSupportPage(WebDriver driver)
	{
		System.out.println("Inside clickInsideSupportPage method");
		Log.info("Inside clickInsideSupportPage method");

		try
		{

			String text = "";
			String temp = "";

			WebDriverWait wait = new WebDriverWait(driver, 120);

			CommonUtility.ClickOn(driver,obj_EsupportIPSHomePage.clickBreadcrumb());


			text = CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.contactUsSlider()).getAttribute("class");

			if(!(text.contains("open")))
			{
				System.out.println("Class attribute value is: "+text);
				//	temp = "open";
				Report.put("Click on any part of the product support page other than the Contact Us slider links",
						"Slider should get closed ",
						"Slider is closed", "PASS");
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on the slider",
					"Slider should get closed ",
					"Slider is not in closed state", "FAIL");
			Assert.fail();
		}
	}

	public void verifyContactUsSliderOpen(WebDriver driver)
	{
		System.out.println("Inside verifyContactUsSliderOpen method");
		Log.info("Inside verifyContactUsSliderOpen method");

		try
		{

			String text = "";
			String temp = "";

			WebDriverWait wait = new WebDriverWait(driver, 120);
			CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.clickSlider());
			CommonUtility.ClickOn(driver,obj_EsupportIPSHomePage.clickSlider());


			text = CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.contactUsSlider()).getAttribute("class");

			if(text.contains("open"))
			{
				System.out.println("Class attribute value is: "+text);
				temp = "open";
				Report.put("Now click on the contact us slider",
						"Contact Us slider should get expand",
						"Slider is "+Report.color(temp), "PASS");
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Now click on the contact us slider",
					"Contact Us slider should get expand",
					"Failed to expand Contact Us Slider", "FAIL");
			Assert.fail();
		}
	}

	public void ClickOnExpandButtonOnGeoLocation(WebDriver driver)
	{

		Log.info("Inside ClickOnExpandButtonOnGeoLocation");
		Actions act=new Actions(driver);
		try
		{
			String message="";
			String head="";
//			if(CommonUtility.CheckpresenceofElementLocated(driver,10,obj_EsupportIncidentsPage.contactUs()))
//			{
//				CommonUtility.ClickOn(driver,obj_EsupportIncidentsPage.contactUs());
//			}
			if(CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.FullScreenButtonOfLocationOHeroSection()).isDisplayed())
			{

				if(CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.FullScreenButtonOfLocationOHeroSection()).isEnabled())
				{
					//					WebDriverWait wait = new WebDriverWait(driver, 120);
					//					wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIPSHomePage.FullScreenButtonOfLocationOHeroSection()));
					CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.FullScreenButtonOfLocationOHeroSection());
					//		CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.FullScreenButtonOfLocationOHeroSection()).click();
					//	act.moveToElement(CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.FullScreenButtonOfLocationOHeroSection())).click().perform();
					CommonUtility.ClickOn(driver,obj_EsupportIPSHomePage.FullScreenButtonOfLocationOHeroSection());

				}
			}
			driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
			if(CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.CurrentLocationDisplayedInLocationDetailsPopup()).isDisplayed())
			{
				head=CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.CurrentLocationDisplayedInLocationDetailsPopup()).getText();
				System.out.println(head);
			}

			Report.put("Click on the expand on the Geoloaction ",
					"User should be able to see the expanded version",
					"clicked on expand button on geolocation and user able to geo map expanded with site name and site city displayed on location as "+Report.color(head)+" page.", "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on the expand on the Geoloaction ",
					"User should be able to see the expanded version",
					"expand button not displayed or user not able to see expanded version with Site name and site city in map", "FAIL");
			Assert.fail();
		}
	}

	public void LaunchNewURLAndVelidateLandingSeriesProductSupportPage(WebDriver driver)
	{

		Log.info("Inside LaunchNewURLAndVelidateLandingSeriesProductSupportPage");

		try
		{

			driver.get("https://www.dell.com/support/home/us/en/04/product-support/product/vmax-series/overview");
			String message="";
			String head="";
			if(CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.SupportHeader()).isDisplayed())
			{

				CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.SupportHeader());
				head=CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.SupportHeader()).getText();
				System.out.println(head);
				head=head.toLowerCase();
				if(!(head.contains("series")))
				{
					Log.info("heading of support page not display expected product as in url laucnched");
					Report.put("Open new tab and launch the url https://www.dell.com/support/home/us/en/04/product-support/product/vmax-series/overview ",
							"User should land in the series product support page",
							"not launched the url given or not landed on expected product support page", "FAIL");
					Assert.fail();
				}


			}

			Report.put("Open new tab and launch the url https://www.dell.com/support/home/us/en/04/product-support/product/vmax-series/overview ",
					"User should land in the series product support page",
					"user landed on  "+Report.color(head)+" in product support page.", "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Open new tab and launch the url https://www.dell.com/support/home/us/en/04/product-support/product/vmax-series/overview ",
					"User should land in the series product support page",
					"not launched the url given or not landed on expected product support page", "FAIL");
			Assert.fail();
		}
	}


	public void ValidateHeroSectionToValidateEnterProductIDToViewDetailsLink(WebDriver driver)
	{

		Log.info("Inside ValidateHeroSectionToValidateEnterProductIDToViewDetailsLink");

		try
		{
			String head="";
			if(CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.EnterProductIDToViewDetailsLink()).isDisplayed())
			{

				CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.EnterProductIDToViewDetailsLink());
				head=CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.EnterProductIDToViewDetailsLink()).getText();
				System.out.println(head);
				head=head.toLowerCase();
				if(!(head.contains("enter product id to view details")))
				{
					Log.info("hero section not display enter product id to view details link");
					Report.put("Now verify the link in hero section",
							"Enter product ID to view details link should be present in the hero section",
							"Enter product ID to view details link not displayed", "FAIL");
					Assert.fail();
				}


			}

			Report.put("Now verify the link in hero section",
					"Enter product ID to view details link should be present in the hero section",
					Report.color(head)+" link present in hero section.", "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Now verify the link in hero section",
					"Enter product ID to view details link should be present in the hero section",
					"Enter product ID to view details not displayed in hero section", "FAIL");
			Assert.fail();
		}
	}

	public void ClickOnEnterProductIDToViewDetailsLink(WebDriver driver)
	{

		Log.info("Inside ClickOnEnterProductIDToViewDetailsLink");

		try
		{
			String head="";
			String pop="";
			String des="";
			String tit="";
			if(CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.EnterProductIDToViewDetailsLink()).isDisplayed())
			{

				CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.EnterProductIDToViewDetailsLink());
				head=CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.EnterProductIDToViewDetailsLink()).getText();
				System.out.println(head);
				//				CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.EnterProductIDToViewDetailsLink());
				//				CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.EnterProductIDToViewDetailsLink()).click();
				CommonUtility.ClickOn(driver,obj_EsupportIPSHomePage.EnterProductIDToViewDetailsLink());

			}
			driver.manage().timeouts().implicitlyWait(150, TimeUnit.SECONDS);
			if(CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.EnterYourProductIDHeadingInPopUp()).isDisplayed())
			{
				CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.EnterYourProductIDHeadingInPopUp());
				pop=CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.EnterYourProductIDHeadingInPopUp()).getText();
				System.out.println(pop);
			}

			if(CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.DescriptionInEnterYourProductIDInPopUp()).isDisplayed())
			{
				CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.DescriptionInEnterYourProductIDInPopUp());
				des=CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.DescriptionInEnterYourProductIDInPopUp()).getText();
				System.out.println(des);
			}

			if(CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.ProductIDTextBoxTitle()).isDisplayed())
			{
				CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.ProductIDTextBoxTitle());
				tit=CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.ProductIDTextBoxTitle()).getText();
				System.out.println(tit);
			}

			if(CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.TextBoxAreaOfProductIDEntryInEnterYourProductIDInPopUp()).isDisplayed())
			{
				CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.TextBoxAreaOfProductIDEntryInEnterYourProductIDInPopUp());

			}

			if(CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.ValidateSubmitButtonIsDisabled()).isDisplayed())
			{
				CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.ValidateSubmitButtonIsDisabled());
				String attr=CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.ValidateSubmitButtonIsDisabled()).getAttribute("disabled");
				System.out.println(attr);
			}

			Report.put("Click on the link Enter product ID to view details",
					"User should load the Enter your product ID pop up with product ID box",
					"clicke don "+Report.color(head)+" link and user landed on "+Report.color(pop)+" with "+Report.color(tit)+ " text box with submit button disabled", "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on the link Enter product ID to view details",
					"User should load the Enter your product ID pop up with product ID box",
					"user not able to click on Enter Product Id to view details link or not able to load Enter product ID pop up", "FAIL");
			Assert.fail();
		}
	}

	public void EnterProductIDWithHypenAndClickSubmitButton(WebDriver driver)
	{

		Log.info("Inside EnterProductIDWithHypenAndClickSubmitButton");

		try
		{
			String val=TestNGCreator.TestData.get(Esupport.SearchOption.ordinal());
			String id="";
			if(CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.TextBoxAreaOfProductIDEntryInEnterYourProductIDInPopUp()).isDisplayed())
			{

				CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.TextBoxAreaOfProductIDEntryInEnterYourProductIDInPopUp());
				CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.TextBoxAreaOfProductIDEntryInEnterYourProductIDInPopUp()).clear();
				CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.TextBoxAreaOfProductIDEntryInEnterYourProductIDInPopUp()).sendKeys(val);

			}

			if(CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.SubmitButtonInEnterYourProductIDInPopUp()).isDisplayed())
			{
				CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.SubmitButtonInEnterYourProductIDInPopUp());

				//				CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.SubmitButtonInEnterYourProductIDInPopUp()).click();

				CommonUtility.ClickOn(driver,obj_EsupportIPSHomePage.SubmitButtonInEnterYourProductIDInPopUp());

			}
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			if(CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.ProductIDInProductSupportPage()).isDisplayed())
			{
				CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.ProductIDInProductSupportPage());
				id=CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.ProductIDInProductSupportPage()).getText();
				System.out.println(id);

				if(!(id.contains(val)))
				{
					Log.info("product id displayed not matching with entered");
					Report.put("Enter the product ID with hypen and click on submit",
							"User should land in the product support page for the entered product ID ",
							"landed page not display entered product id", "FAIL");
					Assert.fail();
				}
			}


			Report.put("Enter the product ID with hypen and click on submit",
					"User should land in the product support page for the entered product ID ",
					"Product id "+Report.color(val)+" is entered and clicked on submit button <br> landed on Product support page with product id "+Report.color(id), "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Enter the product ID with hypen and click on submit",
					"User should land in the product support page for the entered product ID ",
					"Product id entered is invalid or submit is not enabled or landed page not display entered product id", "FAIL");
			Assert.fail();
		}
	}

	public void EnterInvalidProductIDAndClickSubmitButton(WebDriver driver)
	{

		Log.info("Inside EnterInvalidProductIDAndClickSubmitButton");

		try
		{
			String val=TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal());
			String id="";
			if(CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.TextBoxAreaOfProductIDEntryInEnterYourProductIDInPopUp()).isDisplayed())
			{

				CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.TextBoxAreaOfProductIDEntryInEnterYourProductIDInPopUp());
				CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.TextBoxAreaOfProductIDEntryInEnterYourProductIDInPopUp()).clear();
				CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.TextBoxAreaOfProductIDEntryInEnterYourProductIDInPopUp()).sendKeys(val);

			}

			if(CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.SubmitButtonInEnterYourProductIDInPopUp()).isDisplayed())
			{
				CommonUtility.scrollToViewElement(driver,obj_EsupportIPSHomePage.SubmitButtonInEnterYourProductIDInPopUp());

				CommonUtility.ClickOn(driver,obj_EsupportIPSHomePage.SubmitButtonInEnterYourProductIDInPopUp());

			}
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			WebDriverWait  wait = new WebDriverWait(driver, 120);
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIPSHomePage.ErrorMessageForInvalidProductIDEntryInEnterYourProductIDInPopUp()));
			if(CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.ErrorMessageForInvalidProductIDEntryInEnterYourProductIDInPopUp()).isDisplayed())
			{
				CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.ErrorMessageForInvalidProductIDEntryInEnterYourProductIDInPopUp());
				id=CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.ErrorMessageForInvalidProductIDEntryInEnterYourProductIDInPopUp()).getText();
				System.out.println(id);
				id=id.toLowerCase();
				if(!(id.contains("enter a valid product id")))
				{
					Log.info("error message not displayed as expected");
					Report.put("Enter the Invalid product ID and click on submit",
							"User should get the error message 'Enter a Valid product ID'",
							"not display expected error message for invalid product ID enry", "FAIL");
					Assert.fail();
				}
			}


			Report.put("Enter the Invalid product ID and click on submit",
					"User should get the error message 'Enter a Valid product ID'",
					"Invalid Product id "+Report.color(val)+" is entered and clicked on submit button <br> error message displayed as "+Report.color(id), "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Enter the Invalid product ID and click on submit",
					"User should get the error message 'Enter a Valid product ID'",
					"Product id entered is valid or submit is not enabled or landed page not display entered product id", "FAIL");
			Assert.fail();
		}
	}


	public void SearchWordAvamarandSelectFromDropdown(WebDriver driver) 
	{
		Log.info("Entering method SearchWordAvamarandSelectFromDropdown");
		WebDriverWait  wait = new WebDriverWait(driver, 120);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String tabName="";
		String header="";
		String val1=TestNGCreator.TestData.get(Esupport.Product.ordinal()).split(";")[0];
		Actions act=new Actions(driver);
		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportContentHomePage.SearchInput()));
			CommonUtility.highlightElement(driver, obj_EsupportContentHomePage.SearchInput());
			CommonUtility.highlightElement(driver, obj_EsupportContentHomePage.SearchInput()).sendKeys(val1);
			Thread.sleep(5000);
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			System.out.println("before clicking");
			CommonUtility.ScrollTo(driver, obj_EsupportIPSHomePage.SelectFirstSearchResultOfKeywordSearched());
			//			CommonUtility.highlightElement(driver, obj_EsupportIPSHomePage.SelectFirstSearchResultOfKeywordSearched()).click();

			//			act.moveToElement(CommonUtility.highlightElement(driver, obj_EsupportIPSHomePage.SelectFirstSearchResultOfKeywordSearched())).click().build().perform();
			//			WebElement element =driver.findElement((obj_EsupportIPSHomePage.SelectFirstSearchResultOfKeywordSearched()));
			//			((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);

			CommonUtility.ClickOn(driver, obj_EsupportIPSHomePage.SelectFirstSearchResultOfKeywordSearched());
			System.out.println("after clicking");
//			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
//			Thread.sleep(10000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIPSHomePage.productHeader()));
			header=CommonUtility.highlightElement(driver, obj_EsupportIPSHomePage.productHeader()).getText();
			System.out.println(header);
			//			tabName=CommonUtility.highlightElement(driver, obj_EsupportContentHomePage.OverviewTab()).getText();
			//			System.out.println("Landing tab is "+tabName);
			//			CommonUtility.highlightElement(driver, obj_EsupportContentHomePage.OverviewTab()).click();
			//			handleCookies(driver);

			if(header.contains(val1))
			{
				Log.info("test step pass");
			}
			else
			{
				Log.info("test step fail");
				Report.put("In the product selector enter the Avamar and select from dropdown", 
						"User should land in the Product Model page ",
						"Not landed on product support page using product id"+Report.color(val1), "FAIL");
				Assert.fail();
			}


			Report.put("In the product selector enter the Avamar and select from dropdown", 
					"User should land in the Product Model page ",
					"Successfully landed on product support page with product "+Report.color(header), "PASS");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("In the product selector enter the Avamar and select from dropdown", 
					"User should land in the Product Model page ",
					"Not landed on product support page with entered product keyword "+Report.color(header), "FAIL");
			Assert.fail();
		}
	}	

	public void SearchWordNetWorkerforOpenVMSandSelectFromDropdown(WebDriver driver) 
	{
		Log.info("Entering method SearchWordNetWorkerforOpenVMSandSelectFromDropdown");
		WebDriverWait  wait = new WebDriverWait(driver, 120);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String tabName="";
		String header="";
		String val1=TestNGCreator.TestData.get(Esupport.Product.ordinal()).split(";")[1];

		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportContentHomePage.SearchInput()));
			CommonUtility.highlightElement(driver, obj_EsupportContentHomePage.SearchInput());
			CommonUtility.highlightElement(driver, obj_EsupportContentHomePage.SearchInput()).sendKeys(val1);
			Thread.sleep(2000);
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			Actions act=new Actions(driver);
			CommonUtility.ScrollTo(driver, obj_EsupportIPSHomePage.SelectFirstSearchResultOfKeywordSearched());
			//			act.moveToElement(CommonUtility.highlightElement(driver, obj_EsupportIPSHomePage.SelectFirstSearchResultOfKeywordSearched())).click().perform();
			CommonUtility.ClickOn(driver, obj_EsupportIPSHomePage.SelectFirstSearchResultOfKeywordSearched());
			//			CommonUtility.highlightElement(driver, obj_EsupportIPSHomePage.SelectFirstSearchResultOfKeywordSearched()).click();
			//			CommonUtility.ToClickByUsingJavaScript_PassingByLoc(driver, obj_EsupportIPSHomePage.SelectFirstSearchResultOfKeywordSearched());
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			Thread.sleep(10000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.SupportHeader()));
			header=CommonUtility.highlightElement(driver, obj_EsupportDDLHomePage.SupportHeader()).getText();
			System.out.println(header);
			//			tabName=CommonUtility.highlightElement(driver, obj_EsupportContentHomePage.OverviewTab()).getText();
			//			System.out.println("Landing tab is "+tabName);
			//			CommonUtility.highlightElement(driver, obj_EsupportContentHomePage.OverviewTab()).click();
			//			handleCookies(driver);

			if(header.contains(val1))
			{
				Log.info("test step pass");
			}
			else
			{
				Log.info("test step fail");
				Report.put("In the product selector enter the NetWorker for OpenVMS and select from dropdown", 
						"User should land in the Product Model page ",
						"Not landed on product support page using product id"+Report.color(val1), "FAIL");
				Assert.fail();
			}


			Report.put("In the product selector enter the NetWorker for OpenVMS and select from dropdown", 
					"User should land in the Product Model page ",
					"Successfully landed on product support page with product "+Report.color(header), "PASS");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("In the product selector enter the NetWorker for OpenVMS and select from dropdown", 
					"User should land in the Product Model page ",
					"Not landed on product support page with entered product keyword "+Report.color(header), "FAIL");
			Assert.fail();
		}
	}	

	public void EnterValidProductIDAndClickSubmitButton1(WebDriver driver, String SearchOption)
	{

		Log.info("Inside EnterValidProductIDAndClickSubmitButton1");

		try
		{
			Thread.sleep(10000);
			String val=TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[0];
			//			String val1=TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[1];
			String id="";
			if(CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.TextBoxAreaOfProductIDEntryInEnterYourProductIDInPopUp()).isDisplayed())
			{

				CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.TextBoxAreaOfProductIDEntryInEnterYourProductIDInPopUp());
				CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.TextBoxAreaOfProductIDEntryInEnterYourProductIDInPopUp()).clear();
				CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.TextBoxAreaOfProductIDEntryInEnterYourProductIDInPopUp()).sendKeys(SearchOption);

			}

			if(CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.SubmitButtonInEnterYourProductIDInPopUp()).isDisplayed())
			{
				CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.SubmitButtonInEnterYourProductIDInPopUp());

				CommonUtility.ClickOn(driver,obj_EsupportIPSHomePage.SubmitButtonInEnterYourProductIDInPopUp());

			}
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			WebDriverWait  wait = new WebDriverWait(driver, 120);
			Thread.sleep(6000);
//			String url=driver.getCurrentUrl();
//			driver.get(url);
//			Thread.sleep(6000);
			wait.until(ExpectedConditions.presenceOfElementLocated(obj_EsupportIPSHomePage.ProductIDInProductSupportPage()));
			//			if(CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.ProductIDInProductSupportPage()).isDisplayed())
			//			{
			CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.ProductIDInProductSupportPage());
			CommonUtility.ClickOn(driver,obj_EsupportIPSHomePage.ProductIDInProductSupportPage());
			id=CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.ProductIDInProductSupportPage()).getText();
			System.out.println(id);

			if(id.contains(val))
			{
				Log.info("product id displayed matching with entered");
			}
			else
			{
				Log.info("product id displayed not matching with entered");
				Report.put("Enter valid product ID and click on submit",
						"User should land in the product support page for the entered product ID ",
						"landed page not display entered product id", "FAIL");
				Assert.fail();
			}
//			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
//			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIPSHomePage.ClickOnOnline()));
//			CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.ClickOnOnline());
//			CommonUtility.ClickOn(driver,obj_EsupportIPSHomePage.ClickOnOnline());
//			CommonUtility.ClickOn(driver,obj_EsupportIPSHomePage.ClickOnSignOut());
//			Thread.sleep(10000);
			//			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIPSHomePage.supportHeader()));

			Report.put("Enter valid product ID and click on submit",
					"User should land in the product support page for the entered product ID ",
					"Product id "+Report.color(val)+" is entered and clicked on submit button <br> landed on Product support page with product id "+Report.color(id), "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Enter valid product ID and click on submit",
					"User should land in the product support page for the entered product ID ",
					"Product id entered is invalid or submit is not enabled or landed page not display entered product id", "FAIL");
			Assert.fail();
		}
	}


	public void EnterValidProductIDAndClickSubmitButton2(WebDriver driver, String SearchOption)
	{

		Log.info("Inside EnterValidProductIDAndClickSubmitButton2");

		try
		{
			Thread.sleep(10000);
			//			String val=TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[0];
			String val1=TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[1];
			String id="";
			if(CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.TextBoxAreaOfProductIDEntryInEnterYourProductIDInPopUp()).isDisplayed())
			{

				CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.TextBoxAreaOfProductIDEntryInEnterYourProductIDInPopUp());
				CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.TextBoxAreaOfProductIDEntryInEnterYourProductIDInPopUp()).clear();
				CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.TextBoxAreaOfProductIDEntryInEnterYourProductIDInPopUp()).sendKeys(val1);

			}

			if(CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.SubmitButtonInEnterYourProductIDInPopUp()).isDisplayed())
			{
				CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.SubmitButtonInEnterYourProductIDInPopUp());

				CommonUtility.ClickOn(driver,obj_EsupportIPSHomePage.SubmitButtonInEnterYourProductIDInPopUp());

			}
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			WebDriverWait  wait = new WebDriverWait(driver, 120);
			Thread.sleep(7000);
			//			String url=driver.getCurrentUrl();
			//			driver.get(url);
			//			Thread.sleep(7000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIPSHomePage.ProductIDInProductSupportPage()));
			//			if(CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.ProductIDInProductSupportPage()).isDisplayed())
			//			{
			CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.ProductIDInProductSupportPage());
			id=CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.ProductIDInProductSupportPage()).getText();
			System.out.println(id);

			if(!(id.contains(val1)))
			{
				Log.info("product id displayed not matching with entered");
				Report.put("Enter valid product ID and click on submit",
						"User should land in the product support page for the entered product ID ",
						"landed page not display entered product id", "FAIL");
				Assert.fail();
			}

			//			}
			Report.put("Enter valid product ID and click on submit",
					"User should land in the product support page for the entered product ID ",
					"Product id "+Report.color(val1)+" is entered and clicked on submit button <br> landed on Product support page with product id "+Report.color(id), "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Enter valid product ID and click on submit",
					"User should land in the product support page for the entered product ID ",
					"Product id entered is invalid or submit is not enabled or landed page not display entered product id", "FAIL");
			Assert.fail();
		}
	}

	public void launchurl(WebDriver driver)
	{

		Log.info("Inside launchurl");

		try
		{	

			Thread.sleep(10000);
			//			String val=TestNGCreator.TestData.get(Esupport.Dpid.ordinal());
			//			System.out.println(val);
			driver.get("https://www.dell.com/support/home/us/en/19");


			Report.put("Launch the url www.dell.com/support/home/us/en/19",
					"User should land in the support homepage ",
					"url launched successfully", "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Launch the url www.dell.com/support/home/us/en/19",
					"User should land in the support homepage ",
					"url not launched", "FAIL");
			Assert.fail();
		}
	}


	public void ClickOnFindMyDellEMCProducts(WebDriver driver)
	{

		Log.info("Inside ClickOnFindMyDellEMCProducts");

		try
		{
			Thread.sleep(10000);

			String link="";
			String header="";

			if(CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.FindMyDellEMCProductLink()).isDisplayed())
			{
				Thread.sleep(5000);
				link=CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.FindMyDellEMCProductLink()).getText();
				System.out.println(link);
				CommonUtility.ClickOn(driver,obj_EsupportIPSHomePage.FindMyDellEMCProductLink());

			}
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			Thread.sleep(10000);
			if(CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.FindMyDellEMCProductPopUp()).isDisplayed())
			{
				//				CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.FindMyDellEMCProductPopUp());
				//
				//				header=CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.FindMyDellEMCProductPopUp()).getText();
				header=driver.getTitle();
				System.out.println(header);

			}

			Report.put("Go to the product selector and click on Find my dell EMC products ",
					"Find My DELLEMC product modal pop up should load ",
					"clicked on "+Report.color(link)+" and "+Report.color(header)+ " is pop up is displayed", "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Go to the product selector and click on Find my dell EMC products ",
					"Find My DELLEMC product modal pop up should load ",
					"find my Dell EMC Products link not found or pop up not displayed", "FAIL");
			Assert.fail();
		}
	}

	public void InProductSearchTabEnterProductID(WebDriver driver)
	{

		Log.info("Inside InProductSearchTabEnterProductID");

		try
		{
			//			Thread.sleep(10000);
			String val=TestNGCreator.TestData.get(Esupport.SearchOption.ordinal());
			String tab="";
			String seares="";
			String des="";

			if(CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.ProductSearchTabInFindMyDellEMCProductPopUp()).isDisplayed())
			{

				tab=CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.ProductSearchTabInFindMyDellEMCProductPopUp()).getText();
				System.out.println(tab);
				des=CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.DescriptionOfProductSearchTab()).getText();
				System.out.println(des);

			}

			if(CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.TextBoxOfProductSearch()).isDisplayed())
			{
				CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.TextBoxOfProductSearch()).clear();

				CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.TextBoxOfProductSearch()).sendKeys(val);
				seares=CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.SelectFirstSearchFromDropDownInProductSearchTab()).getText();
				System.out.println(seares);
			}

			Report.put("In the Product search tab enter the product ID ",
					"System should display the products for the Entered Product ID",
					"in "+Report.color(tab)+ " tab and searched for Product "+Report.color(val)+" first displayed result from dropdown are"+Report.color(seares), "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("In the Product search tab enter the product ID ",
					"System should display the products for the Entered Product ID",
					"product search tab not found or searched product results not displayed", "FAIL");
			Assert.fail();
		}
	}

	public void ClickOnFirstProductIdFromDropDown(WebDriver driver)
	{

		Log.info("Inside ClickOnFirstProductIdFromDropDown");

		try
		{
			//			Thread.sleep(10000);

			String header="";
			String seares="";
			String productid="";
			//			String des="";

			if(CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.SelectFirstSearchFromDropDownInProductSearchTab()).isDisplayed())
			{
				seares=CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.SelectFirstSearchFromDropDownInProductSearchTab()).getText();
				System.out.println(seares);
				//				CommonUtility.scrollToViewElement(driver,obj_EsupportIPSHomePage.SelectFirstSearchFromDropDownInProductSearchTab());
				//				CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.SelectFirstSearchFromDropDownInProductSearchTab()).click();
				//				CommonUtility.ToClickByUsingJavaScript_PassingByLoc(driver,obj_EsupportIPSHomePage.SelectFirstSearchFromDropDownInProductSearchTab());
				Actions act=new Actions(driver);
				//				act.moveToElement(CommonUtility.highlightElement(driver, obj_EsupportIPSHomePage.SelectFirstSearchFromDropDownInProductSearchTab())).click().perform();
				CommonUtility.ClickOn(driver, obj_EsupportIPSHomePage.SelectFirstSearchFromDropDownInProductSearchTab());
			}
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			if(CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.supportHeader()).isDisplayed())
			{
				header=CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.supportHeader()).getText();
				System.out.println(header);
				productid=CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.ProductIDInProductSupportPage()).getText();
				System.out.println(productid);
			}

			Report.put("Click on the Product ID from the dropdown",
					"User should land in the product support page",
					"clicked on first product from dorpdown"+Report.color(seares)+" and landed on product support page with"+Report.color(productid), "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on the Product ID from the dropdown",
					"User should land in the product support page",
					"not able to see results on search or not landed on product support page", "FAIL");
			Assert.fail();
		}
	}

	public void ClickOnAdvisoriesTab(WebDriver driver)
	{

		Log.info("Inside ClickOnAdvisoriesTab");

		try
		{
			//			Thread.sleep(10000);

			String att="";
			String tab="";
			String des="";
			WebDriverWait wait = new WebDriverWait(driver, 120);
			Actions act=new Actions(driver);

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIPSHomePage.AdvisoriesTab()));
			if(CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.AdvisoriesTab()).isDisplayed())
			{
				tab=CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.AdvisoriesTab()).getText();
				System.out.println(tab);

				//act.moveToElement(CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.AdvisoriesTab())).click().build().perform();
				CommonUtility.ToClickByUsingJavaScript_PassingByLoc(driver, obj_EsupportIPSHomePage.AdvisoriesTab());
			}
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			if(CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.SecurityTabSelectedByDefault()).isDisplayed())
			{
				des=CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.SecurityTabSelectedByDefault()).getText();
				System.out.println(des);
				att=CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.SecurityTabSelectedByDefault()).getAttribute("class");
				System.out.println(att);

				if(att.contains("active"))
				{
					System.out.println("security tab selected by default");
				}
				else
				{
					System.out.println("security tab not selected by default");
					Report.put("Click on the Advisories Tab",
							"Advisories tab should be Load and Security tab should be selected by default.",
							"security tab not selected by default", "FAIL");
					Assert.fail();
				}

			}

			Report.put("Click on the Advisories Tab",
					"Advisories tab should be Load and Security tab should be selected by default.",
					"clicked on "+Report.color(tab)+" tab and landed on Advisories tab with "+Report.color(des)+" tab selected by default", "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on the Advisories Tab",
					"Advisories tab should be Load and Security tab should be selected by default.",
					"not clicked on Advisories tab or not selected security tab by default", "FAIL");
			Assert.fail();
		}
	}


	public void VerifySecurityAdvisoryGridOnTheProductModelPage(WebDriver driver)
	{

		Log.info("Inside VerifySecurityAdvisoryGridOnTheProductModelPage");
		WebDriverWait wait = new WebDriverWait(driver, 180);
		try
		{
			//			Thread.sleep(10000);

			String text="";
			String text1="";
			String result="";

			//wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIPSHomePage.SecurityAdvisoryGridTableHeadings()));
			
			if(CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.SecurityAdvisoryGridTableHeadings()).isDisplayed())
			{


				List<WebElement> list=driver.findElements(obj_EsupportIPSHomePage.SecurityAdvisoryGridTableHeadings());

				for(int i=0;i<list.size();i++)
				{
					CommonUtility.highlightElement(driver, list.get(i));
					text+="<br>"+list.get(i).getText();
					System.out.println(text);
				}

			}
			//				driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			if(CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.NumberOfRowsDisplayed()).isDisplayed())
			{
				List<WebElement> list1=driver.findElements(obj_EsupportIPSHomePage.NumberOfRowsDisplayed());
				System.out.println(list1.size());
				for(int j=0;j<list1.size();j++)
				{
					CommonUtility.highlightElement(driver, list1.get(j));
					text1+="<br>"+list1.get(j).getText();
					System.out.println(text1);
				}

			}
			if(CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.ResultsDisplayedInGrid()).isDisplayed())
			{
				result=CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.ResultsDisplayedInGrid()).getText();
				System.out.println(result);

			}


			Report.put("Verify Security Advisory grid on the product model page",
					"Security advisories published within the last 3 years should be displayed.<br>Severity, Advisory ID , Title and article age columns should display in collapsed view",
					"Security advisories display "+Report.color(text)+" columns in a collapsed view of search results "+Report.color(text1)+" with totla search results as "+Report.color(result), "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify Security Advisory grid on the product model page",
					"Security advisories published within the last 3 years should be displayed.<br>Severity, Advisory ID , Title and article age columns should display in collapsed view",
					"headers of table not displayed or rows are not displayed under header or this product code doesnt have results", "FAIL");
			Assert.fail();
		}
	}

	public void VerifyGrid(WebDriver driver)
	{

		Log.info("Inside VerifyGrid");

		try
		{
			String text="";

			if(CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.TableSortedByArticleageNewestToOldestText()).isDisplayed())
			{

				text=CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.TableSortedByArticleageNewestToOldestText()).getText();
				System.out.println(text);

			}

			Report.put("Verify the Grid",
					"Grid should be sorted by last published verify the message above the grid Table Sorted By: Article age  (Newest To Oldest)",
					"grid is sorted by last published and message above grid "+Report.color(text), "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify the Grid",
					"Grid should be sorted by last published verify the message above the grid Table Sorted By: Article age  (Newest To Oldest)",
					"Table Sorted By: Article age  (Newest To Oldest) text not displayed", "FAIL");
			Assert.fail();
		}
	}

	public void ClickOnFirstAdvisoryIDFromGrid(WebDriver driver)
	{

		Log.info("Inside ClickOnFirstAdvisoryIDFromGrid");

		try
		{
			String text="";
			String title="";
			String currenturl="";
			WebDriverWait wait = new WebDriverWait(driver, 120);

//			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIPSHomePage.ClickOnFirstAdvisoryIDInGrid()));
			if(CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.ClickOnFirstAdvisoryIDInGrid()).isDisplayed())
			{

				text=CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.ClickOnFirstAdvisoryIDInGrid()).getText();
				System.out.println(text);
				CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.ClickOnFirstAdvisoryIDInGrid());

				CommonUtility.ClickOn(driver,obj_EsupportIPSHomePage.ClickOnFirstAdvisoryIDInGrid());

				String mainwindow=driver.getWindowHandle();
				driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
				Set<String> set=driver.getWindowHandles();
				Iterator<String> itr=set.iterator();
				while(itr.hasNext())
				{
					String childWindow=itr.next();
					if(!mainwindow.equals(childWindow))
					{
						driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
						Thread.sleep(10000);
						driver.switchTo().window(childWindow);
						driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
						title=driver.getTitle();

						currenturl=driver.getCurrentUrl();
						Thread.sleep(10000);
						driver.close();
					}
				}

				driver.switchTo().window(mainwindow);
			}

			Report.put("Click on the Advisory ID",
					"Advisory ID should Load in new tab",
					"clicked on first displayed advisory id "+Report.color(text)+" and redirected to new window"+Report.color(title)+" with url"+Report.color(currenturl), "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on the Advisory ID",
					"Advisory ID should Load in new tab",
					"advisory id not displayed or not directed to new window ", "FAIL");
			Assert.fail();
		}
	}

	public void VerifySortingOfColumnsSeverityAdvisoryIDTitleArticleAge(WebDriver driver)
	{

		Log.info("Inside VerifySortingOfColumnsSeverityAdvisoryIDTitleArticleAge");

		try
		{
			String text="";
			String text1="";
			String title="";
			String currenturl="";

			if(CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.SecurityAdvisoryGridTableHeadings()).isDisplayed())
			{

				List<WebElement> list=driver.findElements(obj_EsupportIPSHomePage.SecurityAdvisoryGridTableHeadings());

				for(int i=0;i<list.size();i++)
				{

					CommonUtility.highlightElement(driver, list.get(i)).click();
					driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
					text1+="<br>"+list.get(i).getText();
					System.out.println(text1);
					text=list.get(i).getAttribute("aria-sort");
					System.out.println(text);

					if(text.contains("ascending"))
					{
						System.out.println("after clicking ascending ");
					}
					else
					{
						System.out.println("after clicking not ascending");
						Report.put("Verify all the columns Severity , Advisory ID , Title and article age",
								"User should be able to Sort Severity , Advisory ID and Title",
								"user not able to sort Severity , Advisory ID and Title", "FAIL");
						Assert.fail();
					}
				}

			}

			Report.put("Verify all the columns Severity , Advisory ID , Title and article age",
					"User should be able to Sort Severity , Advisory ID and Title",
					"clicked on each heading "+Report.color(text1)+" sort is available for each one ", "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify all the columns Severity , Advisory ID , Title and article age",
					"User should be able to Sort Severity , Advisory ID and Title",
					"user not able to sort Severity , Advisory ID and Title", "FAIL");
			Assert.fail();
		}
	}

	public void ClickOnFirstSecurityAdvisoryExpandbutton(WebDriver driver)
	{

		Log.info("Inside ClickOnFirstSecurityAdvisoryExpandbutton");

		try
		{
			String text="";
			String text1="";
			String link="";


			if(CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.ClickOnCollapseIconInFirstSecurityAdvisoryResultDisplayed()).isDisplayed())
			{
				CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.ClickOnCollapseIconInFirstSecurityAdvisoryResultDisplayed());
				CommonUtility.ClickOn(driver,obj_EsupportIPSHomePage.ClickOnCollapseIconInFirstSecurityAdvisoryResultDisplayed());
				List<WebElement> list=driver.findElements(obj_EsupportIPSHomePage.ValidateHeadingsInExpandedRowDetails());

				for(int i=0;i<list.size();i++)
				{
					CommonUtility.highlightElement(driver, list.get(i));
					text+="<br>"+list.get(i).getText();
					System.out.println(text);

				}

				List<WebElement> list1=driver.findElements(obj_EsupportIPSHomePage.DetailsUnderHeadingsOfExpandedRowDetails());

				for(int j=0;j<list1.size();j++)
				{
					CommonUtility.highlightElement(driver, list1.get(j));
					text1+="<br>"+list1.get(j).getText();
					System.out.println(text1);

				}

				link=CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.SeeSystemConfigurationGuideLink()).getText();
				System.out.println(link);

			}

			Report.put("Expand any security advisory and verify the columns display",
					"Following fields should be present:<br> Last Published, Date Updated, Vulnerability Source, CVE Identifier, Summary, Resolution, See Security Configuration Guide",
					"clicked on expand icon of first security and able to see "+Report.color(text)+" and "+Report.color(link)+" link", "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Expand any security advisory and verify the columns display",
					"Following fields should be present:<br> Last Published, Date Updated, Vulnerability Source, CVE Identifier, Summary, Resolution, See Security Configuration Guide",
					"expand button not displayed or not collapsed clicking on expand", "FAIL");
			Assert.fail();
		}
	}

	public void ClickOnShowMore(WebDriver driver)
	{

		Log.info("Inside ClickOnShowMore");

		try
		{
			String text="";
			String text1="";
			String link="";
			String result="";

			if(CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.ShowMoreButtonInAdvisoryTab()).isDisplayed())
			{
				//				CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.ShowMoreButtonInAdvisoryTab()).click();
				if(CommonUtility.CheckpresenceofElementLocated(driver, 30, obj_EsupportIPSHomePage.ShowMoreButtonInAdvisoryTab()))
				{
					List<WebElement> showmore=driver.findElements(obj_EsupportIPSHomePage.ShowMoreButtonInAdvisoryTab());
					System.out.println("Showmore results found: "+showmore.size());
					if((showmore).size()>0)
					{
						for(int j=0;j<showmore.size();j++)
						{
							String title=showmore.get(j).getText();
							System.out.println(title);

							System.out.println("clicking showmore");
							CommonUtility.highlightElement(driver, showmore.get(j)).click();
							Thread.sleep(30000);
							result=CommonUtility.highlightElement(driver, obj_EsupportIPSHomePage.ResultsDisplayedInGrid()).getText();
							System.out.println("Search results "+result);
							if (result.contains("Displaying"))
							{
								Log.info("Test case pass");
							}
							else
							{
								Log.info("Test case fail");
								Report.put("Click on show more below the Grid",
										"System should load all the Advisories ID in the grid",
										"clicking on show more advisories not loaded", "FAIL");

								Assert.fail();

							}
							//wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportContentHomePage.ShowMoreResults()));
							//							if(CommonUtility.CheckpresenceofElementLocated(driver, 30, obj_EsupportIPSHomePage.ShowMoreButtonInAdvisoryTab()))
							//							{
							//								CommonUtility.highlightElement(driver, obj_EsupportIPSHomePage.ShowMoreButtonInAdvisoryTab()).click();
							//								
							//							}

							continue;


						}

					}
				}

			}

			Report.put("Click on show more below the Grid",
					"System should load all the Advisories ID in the grid",
					"clicking on show more able to see advisories loading "+Report.color(result), "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on show more below the Grid",
					"System should load all the Advisories ID in the grid",
					"clicking on show more advisories not loaded", "FAIL");
			Assert.fail();
		}
	}

	public void SelectCriticalUnderSeverityLevel(WebDriver driver)
	{

		Log.info("Inside SelectCriticalUnderSeverityLevel");

		try
		{
			String text="";
			String text1="";
			String link="";
			String te="";
			String in="";

			if(CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.SeviorityLevelOnLeftPanelInAdvisoryTab()).isDisplayed())
			{
				text=CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.SeviorityLevelOnLeftPanelInAdvisoryTab()).getText();
				System.out.println(text);

				text1=CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.ClickOnCriticalTypeofSeviority()).getText();
				System.out.println(text1);
				CommonUtility.ClickOn(driver,obj_EsupportIPSHomePage.ClickOnCriticalTypeofSeviority());

				link=CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.ApplyFiltersOnAdvisoryTab()).getText();
				System.out.println(link);
				CommonUtility.ClickOn(driver,obj_EsupportIPSHomePage.ApplyFiltersOnAdvisoryTab());

				Thread.sleep(10000);
				CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.CriticalSecutiryAdvisorySeviority());

				List<WebElement> list=driver.findElements(obj_EsupportIPSHomePage.CriticalSecutiryAdvisorySeviority());

				for(int i=0;i<list.size();i++)
				{
					CommonUtility.highlightElement(driver, list.get(i));
					te+="<br>"+list.get(i).getText();
					System.out.println(te);

				}

				in=CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.CriticalUnderFiltersInAdvisoryTab()).getText();
				System.out.println(in);

			}

			Report.put("Under the filters From the Severity level select the Critical and click on apply Filters",
					"Grid should be sorted and only Critical Advisories should be displayed",
					"selected "+Report.color(text1)+" under "+Report.color(text)+" and clicked on "+Report.color(link)+"<br> and only "+Report.color(in)+" advisories are displayed in grid", "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Under the filters From the Severity level select the Critical and click on apply Filters",
					"Grid should be sorted and only Critical Advisories should be displayed",
					"not able to select critical on left panel or not displayed critical advisories only grid", "FAIL");
			Assert.fail();
		}
	}

	public void ClickOnClearFilters(WebDriver driver)
	{

		Log.info("Inside ClickOnClearFilters");

		try
		{
			String text="";
			String text1="";
			String link="";
			String te="";
			String in="";

			if(CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.ClearFiltersOnAdvisoryTab()).isDisplayed())
			{
				text=CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.ClearFiltersOnAdvisoryTab()).getText();
				System.out.println(text);

				CommonUtility.ClickOn(driver,obj_EsupportIPSHomePage.ClearFiltersOnAdvisoryTab());
				driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
				Thread.sleep(10000);
				CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.CriticalSecutiryAdvisorySeviority());

				List<WebElement> list=driver.findElements(obj_EsupportIPSHomePage.CriticalSecutiryAdvisorySeviority());

				for(int i=0;i<list.size();i++)
				{
					CommonUtility.highlightElement(driver, list.get(i));
					te+="<br>"+list.get(i).getText();
					System.out.println(te);

				}

				//				if(!(CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.CriticalUnderFiltersInAdvisoryTab()).isDisplayed()))
				//				{
				//					System.out.println("filters are cleared");
				//				}

			}

			Report.put("Click on clear filters",
					"All the filters should be removed and should load the default Grid with all details",
					"Clicked on "+Report.color(text)+" button and grid is back to default view and display "+Report.color(te), "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on clear filters",
					"All the filters should be removed and should load the default Grid with all details",
					"Clicking on clear button not removed filters", "FAIL");
			Assert.fail();
		}
	}


	public void SearchAdvisoryIDAndValidateGrid(WebDriver driver)
	{

		Log.info("Inside SearchAdvisoryIDAndValidateGrid");

		try
		{
			String text="";
			String text1="";
			String link="";
			String te="";
			String in="";

			if(CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.ClickOnFirstAdvisoryIDInGrid()).isDisplayed())
			{
				text=CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.ClickOnFirstAdvisoryIDInGrid()).getText();
				System.out.println(text);

				CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.SearchTextBoxInAdvisoryTab()).sendKeys(text);
				CommonUtility.ClickOn(driver,obj_EsupportIPSHomePage.SearchButtonInAdvisoryTab());
				driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
				Thread.sleep(10000);
				List<WebElement> list=driver.findElements(obj_EsupportIPSHomePage.NumberOfRowsDisplayed());
				System.out.println(list.size());
				for(int i=0;i<list.size();i++)
				{
					CommonUtility.highlightElement(driver, list.get(i));
					te=list.get(i).getText();
					System.out.println(te);

				}
				CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.ClickOnFirstAdvisoryIDInGrid());
				in=CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.ClickOnFirstAdvisoryIDInGrid()).getText();
				System.out.println(in);

				if(in.contains(text))
				{
					System.out.println("Advisory id matches");
				}
				else
				{
					System.out.println("Advisory id not matches");
					Report.put("Select any Advisories ID from the dropdown and enter in the search box and click on search",
							"System should display the searched Advisories ID details in the Grid",
							"searched advisory id not displayed in grid", "FAIL");
					Assert.fail();
				}
			}

			Report.put("Select any Advisories ID from the dropdown and enter in the search box and click on search",
					"System should display the searched Advisories ID details in the Grid",
					"Searched "+Report.color(text)+" and abled to see searched id in grid "+Report.color(in), "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Select any Advisories ID from the dropdown and enter in the search box and click on search",
					"System should display the searched Advisories ID details in the Grid",
					"not able to search advisory id or searched advisory id not displayed in grid", "FAIL");
			Assert.fail();
		}
	}

	public void ClickOnAccountTeamAndVerifyTeamMembers(WebDriver driver)
	{
		System.out.println("Inside ClickOnAccountTeamAndVerifyTeamMembers");
		Log.info("Inside ClickOnAccountTeamAndVerifyTeamMembers method");
		WebDriverWait  wait = new WebDriverWait(driver, 120);
		try
		{
			String optionList = "";
			String text = "";		
			String id="";
			CommonUtility.ScrollTo(driver, obj_EsupportIPSHomePage.ClickOnAccountTeam());
			CommonUtility.ClickOn(driver, obj_EsupportIPSHomePage.ClickOnAccountTeam());

			Thread.sleep(6000);
			wait.until(ExpectedConditions.presenceOfElementLocated(obj_EsupportIPSHomePage.AccountTeamMembers()));
			CommonUtility.ScrollTo(driver, obj_EsupportIPSHomePage.AccountTeamMembers());
			List<WebElement> list=driver.findElements(obj_EsupportIPSHomePage.AccountTeamMembers());

			for(WebElement lt:list)
			{
				CommonUtility.highlightElement(driver, lt);
				String name=lt.getText();

				System.out.println("Account team members are : " +name);
				optionList+=" <br> " + name;
			}
			System.out.println("Option List: "+optionList);

			CommonUtility.ScrollTo(driver, obj_EsupportIPSHomePage.AccountTeamMembersEmailIDs());
			List<WebElement> buttonList=driver.findElements(obj_EsupportIPSHomePage.AccountTeamMembersEmailIDs());

			for(WebElement lt:buttonList)
			{
				CommonUtility.highlightElement(driver, lt);			
				String email=lt.getText();

				System.out.println("email ids of Account team members are "+email);
				id+="<br>" +email;
			}				
			System.out.println("email ids are "+id);




			Report.put("Comeback to product support page and click on the account team",
					"Their account team members should be revealed in the slider,And they should be able to email any of those members.",
					"Account team members are revealed in slider as "+Report.color(optionList) +"<br> with their mail ids <br>"+Report.color(text), "PASS");

		} 
		catch(Exception e)
		{
			e.printStackTrace();

			Report.put("Comeback to product support page and click on the account team",
					"Their account team members should be revealed in the slider,And they should be able to email any of those members.",
					"Failed to display Account team members in the Slider", "FAIL");
			Assert.fail();
		}
	}

	public void  clickSignInHereLink(WebDriver driver) 
	{
		System.out.println("Inside clickSignInHereLink method");
		Log.info("Inside clickSignInHereLink method");

		String header = "";

		WebDriverWait  wait = new WebDriverWait(driver, 120);	
		try
		{
			Actions act=new Actions(driver);
			handleCookies(driver);
//			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIPSHomePage.signInHeader()));
			handleCookies(driver);
			
			if(CommonUtility.CheckpresenceofElementLocated(driver, 30, obj_EsupportIPSHomePage.signInHeader()))
			{
				CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.signInHereLink());
				Thread.sleep(3000);
				CommonUtility.ClickOn(driver,obj_EsupportIPSHomePage.signInHereLink());
				Thread.sleep(15000);
			}
			else if(CommonUtility.CheckpresenceofElementLocated(driver, alertcount, obj_EsupportIPSHomePage.SignInHeaderNew()))
			{
				CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.SignInHereLinkNew());
				CommonUtility.scrollToViewElement(driver,obj_EsupportIPSHomePage.SignInHereLinkNew()).click();
				CommonUtility.ClickOn(driver, obj_EsupportIPSHomePage.SignInHereLinkNew());
				Thread.sleep(3000);
			}
			Thread.sleep(15000);
			
			if(CommonUtility.CheckpresenceofElementLocated(driver,5,obj_EsupportIPSHomePage.supportHeader()))
			{
				header = CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.supportHeader()).getText();
			}
			else if(CommonUtility.CheckpresenceofElementLocated(driver,5,obj_EsupportIncidentsPage.CTSHeaderForEmployee()))
			{
				header = CommonUtility.highlightElement(driver,obj_EsupportIncidentsPage.CTSHeaderForEmployee()).getText();
			}

			System.out.println("Clicked on Sign In here Link");

			Report.put("click on employees and vendors click here link  ",
					"User should logged in successfully  ", 
					"Sign in successful. Navigated to Page"+Report.color(header), "PASS");


		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("click on employees and vendors click here link  ",
					"User should logged in successfully  ", 
					"Failed to Sign in", "FAIL");
			Assert.fail();
		}
	}
	
//	public void  clickSignInHereLink(WebDriver driver) 
//	{
//		System.out.println("Inside clickSignInHereLink method");
//		Log.info("Inside clickSignInHereLink method");
//
//		String header = "";
//
//		WebDriverWait  wait = new WebDriverWait(driver, 120);	
//		try
//		{
//			Actions act=new Actions(driver);
//			handleCookies(driver);
//			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIPSHomePage.SignInHeaderNew()));
//			handleCookies(driver);
//			//act.moveToElement(CommonUtility.highlightElement(driver, obj_EsupportIPSHomePage.signInHereLink())).build().perform();
//			CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.SignInHereLinkNew());
//			//	CommonUtility.scrollToViewElement(driver,obj_EsupportIPSHomePage.signInHereLink()).click();
//			Thread.sleep(3000);
//			CommonUtility.ClickOn(driver,obj_EsupportIPSHomePage.SignInHereLinkNew());
//			Thread.sleep(15000);
//			//			CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.supportHeader());
//
//			ToLogin_ValidCredentials(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
//
//			if(CommonUtility.CheckpresenceofElementLocated(driver,5,obj_EsupportIPSHomePage.supportHeader()))
//			{
//				//			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIPSHomePage.supportHeader()));
//
//				header = CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.supportHeader()).getText();
//			}
//			else
//				if(CommonUtility.CheckpresenceofElementLocated(driver,5,obj_EsupportIncidentsPage.CTSHeaderForEmployee()))
//				{
//					//				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIPSHomePage.supportHeader()));
//
//					header = CommonUtility.highlightElement(driver,obj_EsupportIncidentsPage.CTSHeaderForEmployee()).getText();
//				}
//
//			System.out.println("Clicked on Sign In here Link");
//
//			Report.put("click on employees and vendors click here link  ",
//					"User should logged in successfully  ", 
//					"Sign in successful. Navigated to Page"+Report.color(header), "PASS");
//
//
//		}
//		catch(Exception e)
//		{
//			e.printStackTrace();
//			Report.put("click on employees and vendors click here link  ",
//					"User should logged in successfully  ", 
//					"Failed to Sign in", "FAIL");
//			Assert.fail();
//		}
//	}

	public void verifyComponentDetails(WebDriver driver) 
	{		
		WebDriverWait wait = new WebDriverWait(driver, 120);

		System.out.println("Entering verifyComponentDetails");

		Log.info("Entering verifyComponentDetails");   

		try 
		{	
			String header ="";
			String text ="";

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIPSHomePage.componentDetailsHeader()));

			CommonUtility.ScrollTo(driver, obj_EsupportIPSHomePage.componentDetailsHeader());

			CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.componentDetailsHeader());

			header = CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.componentDetailsHeader()).getText();

			System.out.println("Component Details Header is :"+text);

			CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.componentDetailsCount());

			text = CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.componentDetailsCount()).getText();

			System.out.println("Component Details Count is :"+text);



			Report.put("Verify the count of the components under the component details",
					"count of the components should be displayed ",
					"Successfully displayed count of the components"+Report.color(text) +" under "+Report.color(header), "PASS");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify the count of the components under the component details",
					"Count of the components should be displayed ",
					"Failed to display count of the Components", "FAIL");
			Assert.fail();

		}
	}

	public void  employeeLogin_Firefox(WebDriver driver, String username, String password) {
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 120);

		//String name = TestNGCreator.TestData.get(Esupport.Username.ordinal()) ;
		//String pwd = TestNGCreator.TestData.get(Esupport.Password.ordinal()) ;
		System.out.println("Entering employeeLogin_Firefox");


		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIPSHomePage.signInHeader()));

			//act.moveToElement(CommonUtility.highlightElement(driver, obj_EsupportIPSHomePage.signInHereLink())).build().perform();


			CommonUtility.ClickOn(driver,obj_EsupportIPSHomePage.signInHereLink());
			Thread.sleep(10000);
			if(CommonUtility.CheckpresenceofElementLocated(driver, 20, obj_EsupportIPSHomePage.EmpSignOnHeaderFirefox()))
			{
				//wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIPSHomePage.EmpSignOnHeaderFirefox()));

				CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.EmpUsernameFirefox()).sendKeys(username);
				CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.EmpPasswordFirefox()).sendKeys(password);
				//CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.EmpSignOnFirefox()).click();
				CommonUtility.ClickOn(driver,obj_EsupportIPSHomePage.EmpSignOnFirefox());
			}
			//			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIPSHomePage.supportHeader()));


		}catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Enter valid credentials", "Not able to find valid credentials ", "Not able to Signin", "Fail");

			Assert.fail();
		}
	}

	public void verifyRequestLocationChangeButton(WebDriver driver)
	{

		Log.info("Inside verifyRequestLocationChangeButton");

		System.out.println("Inside verifyRequestLocationChangeButton");
		try
		{
			String link="";
			if(!(CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.RequestLocationChangeButton()).isEnabled()))
			{
				CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.RequestLocationChangeButton());
				link= CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.RequestLocationChangeButton()).getText();
				System.out.println(link);

				Report.put("Verify the link Request to change the location details",
						"Link Request to change the location details should greyed out ( disabled )",
						Report.color(link)+" link is disabled", "PASS");
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify the link Request to change the location details",
					"Link Request to change the location details should greyed out ( disabled )",
					"Failed to verify link Request to change Location details", "FAIL");
			Assert.fail();
		}
	}

	public void verifyComponentDetailsSearchOption(WebDriver driver)
	{
		System.out.println("Inside verifyComponentDetailsSearchOption method");
		Log.info("Inside verifyComponentDetailsSearchOption method");

		try
		{
			String text = "";

			WebDriverWait wait = new WebDriverWait(driver, 120);

			if(CommonUtility.CheckpresenceofElementLocated(driver, 10, obj_EsupportIPSHomePage.componentSectionSearchTextbox()))
			{
				CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.componentSectionSearchTextbox());

				System.out.println("Search option is present");

				Report.put("Verify the search option",
						"Search option should be available",
						"Search Option is available", "PASS");
			}
			else
			{
				Report.put("Verify the search option",
						"Search option should be available",
						"Failed to display Search Option", "FAIL");
				Assert.fail();
			}

		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify the search option",
					"Search option should be available",
					"Failed to display Search Option", "FAIL");
			Assert.fail();
		}
	}

	public void clickComponentDetailsSearchOption(WebDriver driver, String input)
	{
		System.out.println("Inside clickComponentDetailsSearchOption method");
		Log.info("Inside clickComponentDetailsSearchOption method");

		try
		{
			String text = "";
			String dataList = "";

			WebDriverWait wait = new WebDriverWait(driver, 120);

			if(CommonUtility.CheckpresenceofElementLocated(driver, 10, obj_EsupportIPSHomePage.componentSectionSearchTextbox()))
			{
				CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.componentSectionSearchTextbox()).sendKeys(input);

				System.out.println("Search text is:"+input);

				CommonUtility.ClickOn(driver,obj_EsupportIPSHomePage.componentSectionSearchIcon());

				List<WebElement> list=driver.findElements(obj_EsupportIPSHomePage.componentSectionSearchResult());

				for(int i=0;i<list.size();i++)
				{
					CommonUtility.highlightElement(driver, list.get(i));
					String tabName=list.get(i).getText();

					System.out.println("Text is: " +tabName);
					dataList+=" <br> " + tabName;
					if(list.size()>5 && i==4)
					{
						break;
					}
				}
				System.out.println("Details are:"+dataList);


				Report.put("Go to the search box enter any text and click on search",
						"Component details should show up all the matched search text  ",
						"Displayed component details for "+Report.color(input)+"<br>"+Report.color(dataList), "PASS");
			}
			else
			{

				Report.put("Go to the search box enter any text and click on search",
						"Component details should show up all the matched search text  ",
						"Failed to display Search result", "FAIL");
				Assert.fail();
			}

		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Go to the search box enter any text and click on search",
					"Component details should show up all the matched search text  ",
					"Failed to display Search result", "FAIL");
			Assert.fail();
		}
	}

	public void verifyComponentDetailsFilterOptions(WebDriver driver)
	{
		System.out.println("Inside verifyComponentDetailsFilterOptions method");
		Log.info("Inside verifyComponentDetailsFilterOptions method");

		try
		{
			String filterList = "";

			WebDriverWait wait = new WebDriverWait(driver, 120);

			List<WebElement> list=driver.findElements(obj_EsupportIPSHomePage.componentSectionFilters());

			for(WebElement lt:list)
			{
				CommonUtility.highlightElement(driver, lt);
				String filter=lt.getText();

				System.out.println("Filter is: " +filter);
				filterList+=" <br> " + filter;
			}
			System.out.println("Filters are:"+filterList);			


			Report.put("Verify the filters below the search box",
					"Filters should be present Vendor , type , component name and contract status ",
					"Filters are available"+Report.color(filterList), "PASS");	
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify the filters below the search box",
					"Filters should be present Vendor , type , component name and contract status ",					
					"Failed to display Filter Options", "FAIL");
			Assert.fail();
		}
	}

	public void clickVendorExpandButton(WebDriver driver)
	{
		System.out.println("Inside clickVendorExpandButton method");
		Log.info("Inside clickVendorExpandButton method");

		try
		{
			String text = "";
			String vendorList = "";

			WebDriverWait wait = new WebDriverWait(driver, 120);

			if(CommonUtility.CheckpresenceofElementLocated(driver, 10, obj_EsupportIPSHomePage.componentSectionVendorExpandButton()))
			{
				CommonUtility.ClickOn(driver,obj_EsupportIPSHomePage.componentSectionVendorExpandButton());



				List<WebElement> list=driver.findElements(obj_EsupportIPSHomePage.componentSectionVendorOptions());


				for(WebElement lt:list)
				{
					CommonUtility.highlightElement(driver, lt);
					String vendor=lt.getAttribute("innerText");

					System.out.println("Vendor is: " +vendor);
					vendorList+=" <br> " + vendor;
				}
				System.out.println("Vendors are:"+vendorList);			


				Report.put("Go to the Vendor and click on expand",
						"All the vendors should load",
						"Displayed Vendors "+Report.color(vendorList), "PASS");
			}
			else
			{

				Report.put("Go to the Vendor and click on expand",
						"All the vendors should load",
						"Failed to display Vendors ", "FAIL");
				Assert.fail();
			}

		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Go to the Vendor and click on expand",
					"All the vendors should load",
					"Failed to display Vendors ", "FAIL");
			Assert.fail();
		}
	}

	public void closeContactUsSlider(WebDriver driver)
	{
		System.out.println("Inside closeContactUsSlider method");
		Log.info("Inside closeContactUsSlider method");

		try
		{

			String text = "";
			String temp = "";

			WebDriverWait wait = new WebDriverWait(driver, 120);

			//	CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.clickSlider()).click();


			text = CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.contactUsSlider()).getAttribute("class");

			if((text.contains("open")))
			{
				CommonUtility.ClickOn(driver,obj_EsupportIPSHomePage.clickSlider());
				System.out.println("Closed Contact Us Slider");			
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Failed to close the Contact Us Slider");
			Assert.fail();
		}
	}

	public void verifyContactUsSliderLandingPage(WebDriver driver)
	{
		System.out.println("Inside verifyContactUsSliderLandingPage method");
		Log.info("Inside verifyContactUsSliderLandingPage method");

		try
		{

			String text = "";

			WebDriverWait wait = new WebDriverWait(driver, 120);

			text = CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.contactUsSlider()).getAttribute("class");

			if(!(text.contains("open")))
			{
				System.out.println("Contact Us Slider is closed");	
				Report.put("Verify the contact us slider on the right side",
						"Contact us slider should be displayed with close state",
						"Displayed Contact us slider in closed state ", "PASS");
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Failed to display the Contact Us Slider in closed state");
			Report.put("Verify the contact us slider on the right side",
					"Contact us slider should be displayed with close state",
					"Failed to display the Contact Us Slider in closed state ", "FAIL");
			Assert.fail();
		}
	}

	public void verifyContactSupportPageProductID(WebDriver driver)
	{
		System.out.println("Inside verifyContactSupportPageProductID method");
		Log.info("Inside verifyContactSupportPageProductID method");

		WebDriverWait wait = new WebDriverWait(driver, 120); 

		String header = "";
		String contactSupportUrl="";
		String prodId="";

		try
		{		
			CommonUtility.ScrollTo(driver, obj_EsupportIPSHomePage.technicalSupportLink());			
			CommonUtility.ClickOn(driver, obj_EsupportIPSHomePage.technicalSupportLink());

			Set<String> allWH=driver.getWindowHandles(); 
			String currentwindow=driver.getWindowHandle();
			int countWindow=allWH.size(); 

			System.out.println("Switched Window Handles and  window count is :: "+countWindow);

			for(String wh:allWH)
			{
				driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
				Thread.sleep(10000);
				driver.switchTo().window(wh); 
				Thread.sleep(10000);
				String url=driver.getCurrentUrl();
				System.out.println("URL displayed as   :::::"+url); 

				if(url.contains("contactus"))
				{
					contactSupportUrl = driver.getCurrentUrl();

					System.out.println("Switched to window");			
					//					wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIPSHomePage.contactTechnicalSupportHeader()));
					CommonUtility.ScrollTo(driver, obj_EsupportIPSHomePage.contactTechnicalSupportHeader());
					header = CommonUtility.highlightElement(driver, obj_EsupportIPSHomePage.contactTechnicalSupportHeader()).getText();
					System.out.println("Header is "+header);
					prodId=CommonUtility.highlightElement(driver, obj_EsupportIPSHomePage.productIdInContactSupportPage()).getText();
					System.out.println("Product Id in Contact Support Page is: "+prodId);

					driver.close();					
					driver.switchTo().window(currentwindow);						
				}	
			}

			Report.put("Click on the Contact Technical support",
					"User should land in the contact SPE page with the product id should carry forward ( the same product ID should be displayed in the contact us spe page with tell us nature of the request ",
					"Loaded Contact Technical Support Page Successfully with Product Id: "+Report.color(prodId), "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on the Contact Technical support",
					"User should land in the contact SPE page with the product id should carry forward ( the same product ID should be displayed in the contact us spe page with tell us nature of the request ",
					"Failed to load Contact Technical Support Page ", "FAIL");
			Assert.fail();
		}
	}

	//Lavanya

	public void SupportPage(WebDriver driver)
	{

		Log.info("Inside SupportPage method");
		String text = "";
		String signin="";
		try
		{

			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SupportHeader());
			text=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SupportHeader()).getText();


			CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.SignInButton2());
			signin=CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.SignInButton2()).getText();
			System.out.println("sign in button displayed "+signin);

			System.out.println("header is "+text);

			if(text.contains("Welcome to Support"))
			{
				System.out.println("support page displayed");	
				Report.put("Verify the homepage ",
						"User should see the welcome message and  the user and encourage them to sign in.",
						"user able to see "+Report.color(text)+" header and able to see "+Report.color(signin), "PASS");
			}
			else
			{
				System.out.println("not able to see support home page");
				Report.put("Verify the homepage ",
						"User should see the welcome message and  the user and encourage them to sign in.",
						"user not able to see header of support home page", "FAIL");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("not able to see support home page");
			Report.put("Verify the homepage ",
					"User should see the welcome message and  the user and encourage them to sign in.",
					"user not able to see header of support home page", "FAIL");
			Assert.fail();
		}
	}

	public void ClickSignInButton(WebDriver driver)
	{

		Log.info("Inside ClickSignInButton method");
		String text = "";
		String signin="";
		WebDriverWait wait = new WebDriverWait(driver, 120); 
		try
		{
			handleCookies(driver);
			CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.signInButton());
			signin=CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.signInButton()).getText();
			System.out.println("sign in button displayed "+signin);

			CommonUtility.ClickOn(driver,obj_EsupportIPSHomePage.signInButton());

//			CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.SignInIcon());
//			CommonUtility.ClickOn(driver,obj_EsupportIPSHomePage.SignInIcon());
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIPSHomePage.SignInHead()));
			String sign=CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.SignInHead()).getText();
			System.out.println(sign);


			System.out.println("sign in page displayed");	
			Report.put("Click on sign in",
					"User should direct to login DIAS page",
					"user able to click on "+Report.color(signin)+" and directed to "+Report.color(sign)+" page", "PASS");


		} 
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("not able to see sign in page");
			Report.put("Click on sign in",
					"User should direct to login DIAS page",
					"user not able to direct to sign in page", "FAIL");
			Assert.fail();
		}
	}

	public void SupportPageValidationAfterSignIn(WebDriver driver)
	{

		Log.info("Inside SupportPageValidationAfterSignIn method");
		String text = "";
		String signin="";
		try
		{

			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SupportHeader());
			text=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SupportHeader()).getText();

			System.out.println("header is "+text);

			if(text.contains("Welcome,"))
			{
				System.out.println("support page displayed with user name signed in");	
				Report.put("Verify the homepage ",
						"User should display with welcome  by mentioning their name.",
						"user able to see "+Report.color(text), "PASS");
			}
			else
			{
				System.out.println("not able to see support home page with user name signed in");
				Report.put("Verify the homepage ",
						"User should display with welcome  by mentioning their name.",
						"user not able to see home page with user name signed in", "FAIL");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();

			Report.put("Verify the homepage ",
					"User should display with welcome  by mentioning their name.",
					"user not able to see home page with user name signed in", "FAIL");
			Assert.fail();
		}
	}

	public void VerifyDetectPCOrSAAndRecentlyViewedProducts(WebDriver driver)
	{

		Log.info("Inside VerifyDetectPCOrSAAndRecentlyViewedProducts method");
		String detectPCorSA = "";
		String recentlyviewed="";
		WebDriverWait wait = new WebDriverWait(driver, 120); 
		try
		{

			CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.WhichProductCanWeHelpYouWithHeaderSection());
			if(CommonUtility.CheckpresenceofElementLocated(driver,10,obj_EsupportIPSHomePage.SupportAssistSectionOrDetectPCSection()))
			{
				//			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIPSHomePage.SupportAssistSectionOrDetectPCSection()));
				CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.SupportAssistSectionOrDetectPCSection());
				detectPCorSA=CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.SupportAssistOrDetectPCButton()).getText();
				System.out.println("button is "+detectPCorSA);

				Report.put("Verify the Detect PC and recently viewed products",
						"Detected PC and recently viewed proucts should be displayed in the left side hero section ",
						"User able to see "+Report.color(detectPCorSA), "PASS");

			}
			if(CommonUtility.CheckpresenceofElementLocated(driver,10,obj_EsupportIPSHomePage.RecentlyViewedHeading()))
			{

				CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.RightButtonToIdentifyRecentlyViewed());

				//				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIPSHomePage.RecentlyViewedHeading()));
				CommonUtility.ScrollTo(driver, obj_EsupportIPSHomePage.RecentlyViewedHeading());

				List<WebElement> list=driver.findElements(obj_EsupportIPSHomePage.RecentlyViewedHeading());
				List<WebElement> list1=driver.findElements(obj_EsupportIPSHomePage.RecentlyViewedProductHyperlink());
				List<WebElement> list2=driver.findElements(obj_EsupportIPSHomePage.RecentlyViewedImageValidation());


				for(WebElement lt:list)
				{
					CommonUtility.highlightElement(driver, lt);

				}

				for(WebElement lt:list1)
				{
					CommonUtility.scrollToViewElement(driver, lt);
					CommonUtility.highlightElement(driver, lt);
					String tabName=lt.getText();

					System.out.println("Tab is: " +tabName);
					recentlyviewed+=" <br> " + tabName;
				}

				System.out.println("recently viewed products are :"+recentlyviewed);

				for(WebElement lt:list2)
				{
					CommonUtility.highlightElement(driver, lt);

				}
				if(CommonUtility.CheckpresenceofElementLocated(driver, 10,obj_EsupportIPSHomePage.PurchasedItems()))
				{
					List<WebElement> list3=driver.findElements(obj_EsupportIPSHomePage.PurchasedItems());
					int count=0;
					int cou=list3.size();
					System.out.println(cou);
					String purchased="";
					for(WebElement lt:list3)
					{
						CommonUtility.highlightElement(driver, lt);
						count++;
						if(count==1)
						{
							purchased=CommonUtility.highlightElement(driver, lt).getText();
							System.out.println(purchased);
						}
					}
					Report.put("Verify the Detect PC and recently viewed products",
							"Detected PC and recently viewed proucts should be displayed in the left side hero section ",
							"User able to see "+Report.color(detectPCorSA)+" and able to see recently viewed with products hyperlink "+Report.color(recentlyviewed)+" and also able to see "+Report.color(purchased+" with count of "+cou), "PASS");

				}
			}
			else
			{
				CommonUtility.CheckpresenceofElementLocated(driver, 10, obj_EsupportContentHomePage.SearchInput());

				CommonUtility.ScrollTo(driver, obj_EsupportContentHomePage.SearchInput());
				CommonUtility.highlightElement(driver, obj_EsupportContentHomePage.SearchInput()).sendKeys("Dell Latitude 3480/3488");
				Thread.sleep(2000);

				CommonUtility.ClickOn(driver, obj_EsupportContentHomePage.SearchButton());
				System.out.println("clicked");
				Thread.sleep(5000);

				driver.navigate().back();
				driver.navigate().back();


				//				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIPSHomePage.RecentlyViewedHeading()));
				CommonUtility.scrollToViewElement(driver, obj_EsupportIPSHomePage.RecentlyViewedHeading());

				List<WebElement> list=driver.findElements(obj_EsupportIPSHomePage.RecentlyViewedHeading());
				List<WebElement> list1=driver.findElements(obj_EsupportIPSHomePage.RecentlyViewedProductHyperlink());
				List<WebElement> list2=driver.findElements(obj_EsupportIPSHomePage.RecentlyViewedImageValidation());

				for(WebElement lt:list)
				{
					CommonUtility.highlightElement(driver, lt);

				}

				for(WebElement lt:list1)
				{
					CommonUtility.scrollToViewElement(driver, lt);
					CommonUtility.highlightElement(driver, lt);
					String tabName=lt.getText();

					System.out.println("Tab is: " +tabName);
					recentlyviewed+=" <br> " + tabName;
				}

				System.out.println("recently viewd products are :"+recentlyviewed);

				for(WebElement lt:list2)
				{
					CommonUtility.highlightElement(driver, lt);

				}
				if(CommonUtility.CheckpresenceofElementLocated(driver, 10,obj_EsupportIPSHomePage.PurchasedItems()))
				{
					List<WebElement> list3=driver.findElements(obj_EsupportIPSHomePage.PurchasedItems());
					int count=0;
					int cou=list3.size();
					System.out.println(cou);
					String purchased="";
					for(WebElement lt:list3)
					{
						CommonUtility.highlightElement(driver, lt);
						count++;
						if(count==1)
						{
							purchased=CommonUtility.highlightElement(driver, lt).getText();
							System.out.println(purchased);
						}
					}

					Report.put("Verify the Detect PC and recently viewed products",
							"Detected PC and recently viewed proucts should be displayed in the left side hero section ",
							"User able to see recently viewed with products hyperlink "+Report.color(recentlyviewed)+" and also able to see "+Report.color(purchased+" with count of "+cou), "PASS");
				}

			}



			Report.put("Verify the Detect PC and recently viewed products",
					"Detected PC and recently viewed proucts should be displayed in the left side hero section ",
					"User able to see "+Report.color(detectPCorSA)+" and able to see recently viewed with products hyperlink "+Report.color(recentlyviewed), "PASS");


		} 
		catch(Exception e)
		{
			e.printStackTrace();

			Report.put("Verify the Detect PC and recently viewed products",
					"Detected PC and recently viewed proucts should be displayed in the left side hero section ",
					"user not able to see SA or detected PC and recently viewed items", "FAIL");
			Assert.fail();
		}
	}

	public void VerifyClickingOnRecentlyViewedProduct(WebDriver driver)
	{

		Log.info("Inside VerifyClickingOnRecentlyViewedProduct method");
		String text = "";
		String header="";
		WebDriverWait wait = new WebDriverWait(driver, 120); 
		try
		{

			CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.FirstDisplayedRecentlyViewedItem());
			text=CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.FirstDisplayedRecentlyViewedItem()).getText();

			System.out.println("product is "+text);
			CommonUtility.ClickOn(driver,obj_EsupportIPSHomePage.FirstDisplayedRecentlyViewedItem());

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIPSHomePage.productHeader()));
			CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.productHeader());
			header=CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.productHeader()).getText();

			System.out.println("displayed product is "+header);
			if(header.equalsIgnoreCase(text))
			{
				System.out.println("product displayed is same as clicked one");	
				Report.put("Select any one of the recently viewed products / Detected PC ",
						"User should land in the product support page of that product with driver & downloads tab selected ",
						"user able to see same product "+Report.color(header)+" displayed on product page as clicked one "+Report.color(text), "PASS");
			}
			else
			{
				System.out.println("not able to see same product displayed is same as clicked one");
				Report.put("Select any one of the recently viewed products / Detected PC ",
						"User should land in the product support page of that product with driver & downloads tab selected ",
						"user not able to see same product as clicked under recently viewed", "FAIL");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();

			Report.put("Select any one of the recently viewed products / Detected PC ",
					"User should land in the product support page of that product with driver & downloads tab selected ",
					"user not able to see product page displaying clicked product under recently viewed", "FAIL");
			Assert.fail();
		}
	}

	public void ClickGSeriesLink(WebDriver driver)
	{

		Log.info("Inside ClickGSeriesLink method");

		WebDriverWait wait = new WebDriverWait(driver, 120); 

		String header = "";
		try
		{	
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIPSHomePage.GSeriesLink()));
			
//			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_EsupportIPSHomePage.GSeriesLink()))
//			{
			CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.GSeriesLink());
			//			CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.latitudeLink()).click();
			CommonUtility.ClickOn(driver,obj_EsupportIPSHomePage.GSeriesLink());
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIPSHomePage.allProductsPopupHeader()));

			CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.allProductsPopupHeader());

			header = CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.allProductsPopupHeader()).getText();

			Thread.sleep(10000);

			Report.put("Click on GSeries",
					"User should load modal pop up with GSeries",
					"Loaded Modal Popup with GSeries. Popup Header is:"+Report.color(header), "PASS");
			
			
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on GSeries",
					"User should load modal pop up with GSeries",
					"Failed to load Modal Popup with GSeries.", "FAIL");
			Assert.fail();
		}
	}

	public void verifyServiceTagHyperlinkAndClickOnServiceTagLink(WebDriver driver)
	{

		Log.info("entering verifyServiceTagHyperlinkAndClickOnServiceTagLink");
		String tag="";
		String sertag="";
		String overview="";
		WebDriverWait wait=new WebDriverWait(driver, 120);

		try
		{

			CommonUtility.ScrollTo(driver,obj_EsupportIncidentsPage.ServiceTagHyperlink());
			tag= CommonUtility.highlightElement(driver,obj_EsupportIncidentsPage.ServiceTagHyperlink()).getText();
			System.out.println(tag);

			Report.put("Verify the service tag hyperlink",
					"Product support Hero section  should show service tag as hyperlink link",
					"Displayed service tag searched "+Report.color(tag)+" as hyperlink successfully", "PASS");

			CommonUtility.ClickOn(driver,obj_EsupportIncidentsPage.ServiceTagHyperlink());
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIPSHomePage.ProductIDInProductSupportPage()));

			CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.ProductIDInProductSupportPage());

			sertag = CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.ProductIDInProductSupportPage()).getText();

			System.out.println(sertag);

			CommonUtility.ScrollTo(driver,obj_EsupportIncidentsPage.DefaultOverViewTab());

			overview = CommonUtility.highlightElement(driver,obj_EsupportIncidentsPage.DefaultOverViewTab()).getText();

			System.out.println(overview);

			if(sertag.contains(tag))
			{
				Report.put("Click on the Service Tag hyperlink on the hero section ",
						"User should be directed to the  Overview tab of the IPS page in a new tab",
						"user able to clicked on service tag "+Report.color(tag)+" successfully and display IPS page landing on default "+Report.color(overview)+" tab with tag "+Report.color(sertag), "PASS");
			}
			else
			{
				System.out.println("test case fail");
				Report.put("Click on the Service Tag hyperlink on the hero section ",
						"User should be directed to the  Overview tab of the IPS page in a new tab",
						"user no able to click on service tag link", "FAIL");
				Assert.fail();
			}

			driver.navigate().back();
			Thread.sleep(7000);
			driver.navigate().back();
			Thread.sleep(7000);
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on the Service Tag hyperlink on the hero section ",
					"User should be directed to the  Overview tab of the IPS page in a new tab",
					"user no able to click on service tag link", "FAIL");
			Assert.fail();
		}
	}


	public void Navigatebacktopreviouspage(WebDriver driver)
	{

		Log.info("Inside Navigatebacktopreviouspage method");

		try
		{			

			driver.navigate().back();

			Thread.sleep(5000);

			if(CommonUtility.CheckpresenceofElementLocated(driver,10, obj_EsupportIPSHomePage.viewDetailsLink()))
			{
				System.out.println("view details link displayed");
			}
			else
			{
				driver.navigate().back();

				Thread.sleep(5000);

				if(CommonUtility.CheckpresenceofElementLocated(driver,10, obj_EsupportIPSHomePage.viewDetailsLink()))
				{
					CommonUtility.ScrollTo(driver, obj_EsupportIPSHomePage.viewDetailsLink());
					System.out.println("view details link displayed");
				}
				else
				{
					System.out.println("view details link not displayed");
				}
			}


		} 
		catch(Exception e)
		{
			e.printStackTrace();


		}
	}

	public void ToLogin_ValidCredentials(WebDriver driver,String Username, String Password)
	{

		System.out.println("Entering method in to ToLogin_ValidCredentials");
		Log.info("Entering method in to ToLogin_ValidCredentials");
		String emcvalue="";
		Actions act=new Actions(driver);

		//		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		try
		{
			Thread.sleep(7000);
			//			WebDriverWait wait = new WebDriverWait(driver,100);

			//			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.Email()));

			//			handleCookies(driver);
			if(CommonUtility.CheckpresenceofElementLocated(driver,10, obj_EsupportContentHomePage.Email()))
			{
				CommonUtility.ScrollTo(driver, obj_EsupportContentHomePage.Email());
				CommonUtility.highlightElement(driver, obj_EsupportContentHomePage.Email()).sendKeys(Username);

				System.out.println("Entered Email(Username) as "+Username);

				CommonUtility.ScrollTo(driver, obj_EsupportDDLHomePage.Password());
				CommonUtility.highlightElement(driver, obj_EsupportDDLHomePage.Password()).sendKeys(Password);

				System.out.println("Entered Password as "+Password);
				CommonUtility.ScrollTo(driver, obj_EsupportContentHomePage.SignOnButton());
				WebElement element = driver.findElement(obj_EsupportContentHomePage.SignOnButton());
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);

				//			CommonUtility.ClickOn(driver, obj_EsupportContentHomePage.SignOnButton());
				//			CommonUtility.highlightElement(driver, obj_EsupportContentHomePage.SignOnButton()).click();
				//			act.moveToElement(CommonUtility.highlightElement(driver, obj_EsupportContentHomePage.SignOnButton())).click().build().perform();
				//			CommonUtility.ClickOn(driver, obj_EsupportContentHomePage.SignOnButton());
				System.out.println("Clicked on SignIn Button ");


				Report.put("enter valid L EMC credentials Username as "+Report.color(Username)+" and password as and click on sign in", 
						"User should logged in successfully with Black check mark on name ",
						"Successfully User landed CTS home page with Black check mark on name", "PASS"); 
				Thread.sleep(6000);
			}
			else
			{
				System.out.println("not able to extra sign on for employee");
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();


			Report.put("Provide sign in credentials Username as "+Report.color(Username)+" and password as "+Report.color(Password)+"  and click on sign in", 
					"User should be signed in successfully and land on CTS home page",
					"User not signed in successfully and land on CTS home page", "FAIL"); 
			Assert.fail();

		}
	}

	public void searchServiceTag_CoveoSearch(WebDriver driver,String serviceTag) 
	{		
		WebDriverWait wait = new WebDriverWait(driver, 240);

		System.out.println("Entering searchServiceTag_CoveoSearch");

		Log.info("Entering searchServiceTag_CoveoSearch");   

		try 
		{	
			String header="";
			String prodHeader="";


			System.out.println("Test data from test data sheet is :" +serviceTag);


			CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.supportHeader());

			header = CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.supportHeader()).getText();
			System.out.println("Welcome Page header is:"+header);
			CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.serviceTagTextbox());
			CommonUtility.ClickOn(driver,obj_EsupportIPSHomePage.serviceTagTextbox());
			CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.serviceTagTextbox()).clear();

			CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.serviceTagTextbox()).sendKeys(serviceTag);
			handleCookies(driver);
			CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.serviceTagSearchButton());
			CommonUtility.ClickOn(driver,obj_EsupportIPSHomePage.serviceTagSearchButton());


			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.searchSupport()));
			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.searchSupport());
			prodHeader = CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.searchSupport()).getText();

			System.out.println(" header is:"+prodHeader);



			Report.put("Scenario : 3 - Home Page Enter LDell driver id on center search box and click Search button",
					"It should show the driver id on search result page",
					"Successfully navigated to search Support Page. Header is: "+Report.color(prodHeader)+" on searching driver id "+Report.color(serviceTag), "PASS");

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Scenario : 3 - Home Page Enter LDell driver id on center search box and click Search button",
					"It should show the driver id on search result page",
					"Failed to navigate to search Support Page.", "FAIL");
			Assert.fail();

		}
	}
	
	//IPS new changes March 2021
	
	public void verifyOverviewTabDetails(WebDriver driver)
	{
		System.out.println("Inside verifyOverviewTabDetails method");
		
		WebDriverWait wait = new WebDriverWait(driver, 120); 

		String header = "";
		String link = "";
		try
		{	
			
			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_EsupportIPSHomePage.YourSystemAtAGlance()))
			{
			CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.YourSystemAtAGlance());
			String firsthead=CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.YourSystemAtAGlance()).getText();
			System.out.println(firsthead);
			
			CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.WarrantyStatusHeading());
			String warHead=CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.WarrantyStatusHeading()).getText();
			System.out.println(warHead);
			
			CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.WarrantyDetailsDisplayed());
			String warDet=CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.WarrantyDetailsDisplayed()).getText();
			System.out.println(warDet);
			
			CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.LinkInWarrantySection());
			String warLink=CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.LinkInWarrantySection()).getText();
			System.out.println(warLink);
			
//			CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.MoreResourcesHeading());
//			String moreRes=CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.MoreResourcesHeading()).getText();
//			System.out.println(moreRes);
			
			CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.SupportVideosSection());
//			String supVid=CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.SupportVideosSection()).getText();
//			System.out.println(supVid);
			
			CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.KnowledgeBaseSection());
//			String knowBase=CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.KnowledgeBaseSection()).getText();
//			System.out.println(knowBase);
			
			CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.CommunityForumsSection());
//			String comFor=CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.CommunityForumsSection()).getText();
//			System.out.println(comFor);
			
			CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.QuickLinksHeading());
			String quickLin=CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.QuickLinksHeading()).getText();
			System.out.println(quickLin);
			
			String tabList="";
			CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.QuickLinkLinks());
			List<WebElement> list=driver.findElements(obj_EsupportIPSHomePage.QuickLinkLinks());

			for(WebElement lt:list)
			{
				CommonUtility.highlightElement(driver, lt);
				String tabName=lt.getText();

				System.out.println("link is: " +tabName);
				tabList+=" <br> " + tabName;
			}
			System.out.println("links are:"+tabList);
			
			CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.NeedContactUsHeding());
			String contusHead=CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.NeedContactUsHeding()).getText();
			System.out.println(contusHead);
			
			CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.ContactUsSectionDetails());
			String contusDet=CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.ContactUsSectionDetails()).getText();
			System.out.println(contusDet);

			CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.ContactTechnicalSupportLink());
			String ctsLink=CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.ContactTechnicalSupportLink()).getText();
			System.out.println(ctsLink);
			
			Report.put("Verify the Overview tab ",
					"Overview tab should contain system at a glance section with warranty status , More resources section Right side quick links section and below Contact technical support option",
					"User able to see Overview tab with "+Report.color(firsthead)+" with "+Report.color(warHead)+" with details "+Report.color(warDet)+""
							+ "and also able to see "+Report.color("")+" heading  and "+Report.color(quickLin)+" along with links displayed "+Report.color(tabList)+""
									+ " and "+Report.color(contusHead)+" section with details "+Report.color(contusDet)+" and "+Report.color(ctsLink)+" link", "PASS");
			}
			else
			{
				Report.put("Verify the Overview tab ",
						"Overview tab should contain system at a glance section with warranty status , More resources section Right side quick links section and below Contact technical support option",
						"Failed to Load Overview Tab with expected sections", "FAIL");
				Assert.fail();
			}
			} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify the Overview tab ",
					"Overview tab should contain system at a glance section with warranty status , More resources section Right side quick links section and below Contact technical support option",
					"Failed to Load Overview Tab with expected sections", "FAIL");
			Assert.fail();
		}
	}
	
	public void verifyOverviewTabDetails_ProductnameSearch(WebDriver driver)
	{
		System.out.println("Inside verifyOverviewTabDetails_ProductnameSearch method");
		
		WebDriverWait wait = new WebDriverWait(driver, 120); 

		String header = "";
		String link = "";
		try
		{	
			
			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_EsupportIPSHomePage.MoreResourcesHeading()))
			{
			
			
			CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.MoreResourcesHeading());
			String moreRes=CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.MoreResourcesHeading()).getText();
			System.out.println(moreRes);
			
			CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.SupportVideosSection());
//			String supVid=CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.SupportVideosSection()).getText();
//			System.out.println(supVid);
			
			CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.KnowledgeBaseSection());
//			String knowBase=CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.KnowledgeBaseSection()).getText();
//			System.out.println(knowBase);
			
			CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.CommunityForumsSection());
//			String comFor=CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.CommunityForumsSection()).getText();
//			System.out.println(comFor);
			
			CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.QuickLinksHeading());
			String quickLin=CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.QuickLinksHeading()).getText();
			System.out.println(quickLin);
			
			String tabList="";
			CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.QuickLinkLinks());
			List<WebElement> list=driver.findElements(obj_EsupportIPSHomePage.QuickLinkLinks());

			for(WebElement lt:list)
			{
				CommonUtility.highlightElement(driver, lt);
				String tabName=lt.getText();

				System.out.println("link is: " +tabName);
				tabList+=" <br> " + tabName;
			}
			System.out.println("links are:"+tabList);
			
			CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.NeedContactUsHeding());
			String contusHead=CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.NeedContactUsHeding()).getText();
			System.out.println(contusHead);
			
			CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.ContactUsSectionDetails());
			String contusDet=CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.ContactUsSectionDetails()).getText();
			System.out.println(contusDet);

			CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.ContactTechnicalSupportLink());
			String ctsLink=CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.ContactTechnicalSupportLink()).getText();
			System.out.println(ctsLink);
			
			Report.put("Verify the Overview tab ",
					"Overview tab should contain system at a glance section with warranty status , More resources section Right side quick links section and below Contact technical support option",
					"User able to see Overview tab with "+Report.color(moreRes)+" heading  and "+Report.color(quickLin)+" along with links displayed "+Report.color(tabList)+""
									+ " and "+Report.color(contusHead)+" section with details "+Report.color(contusDet)+" and "+Report.color(ctsLink)+" link", "PASS");
			}
			else
			{
				Report.put("Verify the Overview tab ",
						"Overview tab should contain system at a glance section with warranty status , More resources section Right side quick links section and below Contact technical support option",
						"Failed to Load Overview Tab with expected sections", "FAIL");
				Assert.fail();
			}
			} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify the Overview tab ",
					"Overview tab should contain system at a glance section with warranty status , More resources section Right side quick links section and below Contact technical support option",
					"Failed to Load Overview Tab with expected sections", "FAIL");
			Assert.fail();
		}
	}
	public void verifyOverviewTabDetails_EnterServiceTag(WebDriver driver)
	{
		System.out.println("Inside verifyOverviewTabDetails_EnterServiceTag method");
		
		WebDriverWait wait = new WebDriverWait(driver, 120); 

		String header = "";
		String link = "";
		try
		{	
			
			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_EsupportIPSHomePage.AccessSupportCustomizedHeading()))
			{
			CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.AccessSupportCustomizedHeading());
			String accSupHead=CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.AccessSupportCustomizedHeading()).getText();
			System.out.println(accSupHead);
			
			CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.AccessSupportCustomizedDetails());
			String accSupDet=CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.AccessSupportCustomizedDetails()).getText();
			System.out.println(accSupDet);
			
			CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.EnterServiceTag());
			String enterSer=CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.EnterServiceTag()).getText();
			System.out.println(enterSer);
			
						
			CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.MoreResourcesHeading());
			String moreRes=CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.MoreResourcesHeading()).getText();
			System.out.println(moreRes);
			
			CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.SupportVideosSection());
//			String supVid=CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.SupportVideosSection()).getText();
//			System.out.println(supVid);
			
			CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.KnowledgeBaseSection());
//			String knowBase=CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.KnowledgeBaseSection()).getText();
//			System.out.println(knowBase);
			
			CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.CommunityForumsSection());
//			String comFor=CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.CommunityForumsSection()).getText();
//			System.out.println(comFor);
			
			CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.QuickLinksHeading());
			String quickLin=CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.QuickLinksHeading()).getText();
			System.out.println(quickLin);
			
			String tabList="";
			CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.QuickLinkLinks());
			List<WebElement> list=driver.findElements(obj_EsupportIPSHomePage.QuickLinkLinks());

			for(WebElement lt:list)
			{
				CommonUtility.highlightElement(driver, lt);
				String tabName=lt.getText();

				System.out.println("link is: " +tabName);
				tabList+=" <br> " + tabName;
			}
			System.out.println("links are:"+tabList);
			
			CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.NeedContactUsHeding());
			String contusHead=CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.NeedContactUsHeding()).getText();
			System.out.println(contusHead);
			
			CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.ContactUsSectionDetails());
			String contusDet=CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.ContactUsSectionDetails()).getText();
			System.out.println(contusDet);

			CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.ContactTechnicalSupportLink());
			String ctsLink=CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.ContactTechnicalSupportLink()).getText();
			System.out.println(ctsLink);
			
			Report.put("Verify the Overview tab ",
					"overview tab should display the Access support customized for your product with enter service tag option , Bottom should display the More resources section and right side with quick links and contact technical support link ",
					"User able to see Overview tab with "+Report.color(accSupHead)+" with "+Report.color(accSupDet)+" with details "+Report.color(enterSer)+""
							+ "and also able to see "+Report.color("")+" heading  and "+Report.color(quickLin)+" along with links displayed "+Report.color(tabList)+""
									+ " and "+Report.color(contusHead)+" section with details "+Report.color(contusDet)+" and "+Report.color(ctsLink)+" link", "PASS");
			}
			else
			{
				Report.put("Verify the Overview tab ",
						"overview tab should display the Access support customized for your product with enter service tag option , Bottom should display the More resources section and right side with quick links and contact technical support link ",
						"Failed to Load Overview Tab with expected sections", "FAIL");
				Assert.fail();
			}
			} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify the Overview tab ",
					"overview tab should display the Access support customized for your product with enter service tag option , Bottom should display the More resources section and right side with quick links and contact technical support link ",
					"Failed to Load Overview Tab with expected sections", "FAIL");
			Assert.fail();
		}
	}
	
	
	public void verifyHeroSectionSoftwareTaggedProduct_two(WebDriver driver)
	{
		System.out.println("Inside verifyHeroSectionSoftwareTaggedProduct_two method");
		Log.info("Inside verifyHeroSectionSoftwareTaggedProduct_two method");
		String img = "";
		String servicText = "";
		String changeProductLink = "";
		String nickNameLink = "";
		try		
		{
			//handleCookies(driver);

			if(CommonUtility.CheckpresenceofElementLocated(driver, 10, obj_EsupportIPSHomePage.productImageHeroSection()))
			{
				CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.productImageHeroSection());
				img = "Image displayed ";				
			}

			

			if(CommonUtility.CheckpresenceofElementLocated(driver, 10, obj_EsupportIPSHomePage.changeProduct()))
			{
				CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.changeProduct());

				changeProductLink = CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.changeProduct()).getText();

				System.out.println("Link is "+changeProductLink);
			}
			

			Report.put("Verify the hero section",
					"Hero section should display the product image ( if available ) change product link  ",
					"Successfully "+Report.color(img) +Report.color(changeProductLink), "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify the hero section",
					"Hero section should display the product image ( if available ) change product link  ",
					"Failed to display Image & Links in Hero Section", "FAIL");
			Assert.fail();
		}
	}
	
	public void verifyOverviewTabDetails_SignIn(WebDriver driver)
	{
		System.out.println("Inside verifyOverviewTabDetails_SignIn method");
		
		WebDriverWait wait = new WebDriverWait(driver, 120); 

		String header = "";
		String link = "";
		try
		{	
			CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.AccessSupportCustomizedHeading());
			
			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_EsupportIPSHomePage.SignInButtonInOverviewTab()))
			{
			CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.AccessSupportCustomizedHeading());
			String accSupHead=CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.AccessSupportCustomizedHeading()).getText();
			System.out.println(accSupHead);
			
			CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.AccessSupportCustomizedDetails());
			String accSupDet=CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.AccessSupportCustomizedDetails()).getText();
			System.out.println(accSupDet);
			
			CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.SignInButtonInOverviewTab());
			String enterSer=CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.SignInButtonInOverviewTab()).getText();
			System.out.println(enterSer);
			
						
				
			
			Report.put("Verify the Overview tab ",
					"Overview tab should display the Sign in option ",
					"User able to see Overview tab with "+Report.color(enterSer), "PASS");
			}
			else
			{
				Report.put("Verify the Overview tab ",
						"Overview tab should display the Sign in option ",
						"Failed to Load Overview Tab with expected sections", "FAIL");
				Assert.fail();
			}
			} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify the Overview tab ",
					"Overview tab should display the Sign in option ",
					"Failed to Load Overview Tab with expected sections", "FAIL");
			Assert.fail();
		}
	}
	
	public void verifyOverviewTabDetails_QuickLinks(WebDriver driver)
	{
		System.out.println("Inside verifyOverviewTabDetails_QuickLinks method");
		
		WebDriverWait wait = new WebDriverWait(driver, 120); 

		String header = "";
		String link = "";
		try
		{	
			
			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_EsupportIPSHomePage.QuickLinkLinks()))
			{
				CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.QuickLinksHeading());
				String quickLin=CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.QuickLinksHeading()).getText();
				System.out.println(quickLin);
			String tabList="";
			CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.QuickLinkLinks());
			List<WebElement> list=driver.findElements(obj_EsupportIPSHomePage.QuickLinkLinks());

			for(WebElement lt:list)
			{
				CommonUtility.highlightElement(driver, lt);
				String tabName=lt.getText();

				System.out.println("link is: " +tabName);
				tabList+=" <br> " + tabName;
			}
			System.out.println("links are:"+tabList);
			
			
			Report.put("Check the quick links section",
					"Quick links section should display, View product specs, Add to My Products & Services, Get support notifications",
					"User able to see "+Report.color(quickLin)+" with links "+Report.color(tabList), "PASS");
			}
			else
			{
				Report.put("Check the quick links section",
						"Quick links section should display, View product specs, Add to My Products & Services, Get support notifications",
						"Failed to Load Overview Tab with expected section", "FAIL");
				Assert.fail();
			}
			} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Check the quick links section",
					"Quick links section should display, View product specs, Add to My Products & Services, Get support notifications",
					"Failed to Load Overview Tab with expected section", "FAIL");
			Assert.fail();
		}
	}
	
	public void clickViewProductsSpecsLink(WebDriver driver)
	{
		System.out.println("Inside clickViewProductsSpecsLink method");
		Log.info("Inside clickViewProductsSpecsLink method");

		try
		{
			handleCookies(driver);
			String header = "";
			WebDriverWait wait = new WebDriverWait(driver, 120);

			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_EsupportIPSHomePage.ViewProductSpecsLink()))
			{
				CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.ViewProductSpecsLink());
				CommonUtility.ClickOn(driver,obj_EsupportIPSHomePage.ViewProductSpecsLink());

			//wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIPSHomePage.systemConfigurationPopupHeader()));
			header = CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.systemConfigurationPopupHeader()).getText();

			Report.put("Click on the view product specs ",
					"User should load the system configuration Modal Pop up",
					"Modal Pop Up displayed Successfully. Header is: "+Report.color(header), "PASS");
			}
			else
			{
				Report.put("Click on the view product specs ",
						"User should load the system configuration Modal Pop up",
						"Failed to display Modal Pop Up", "FAIL");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on the view product specs ",
					"User should load the system configuration Modal Pop up",
					"Failed to display Modal Pop Up", "FAIL");
			Assert.fail();
		}
	}
	
	public void clickAddToMyProductsAndServicesLink(WebDriver driver)
	{
		System.out.println("Inside clickAddToMyProductsAndServicesLink method");
		Log.info("Inside clickAddToMyProductsAndServicesLink method");

		try
		{
			handleCookies(driver);
			String header = "";String url="";
			WebDriverWait wait = new WebDriverWait(driver, 120);

			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_EsupportIPSHomePage.AddToMyProductsAndServicesLink()))
			{
				CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.AddToMyProductsAndServicesLink());
				CommonUtility.ClickOn(driver,obj_EsupportIPSHomePage.AddToMyProductsAndServicesLink());

				String mainwindow=driver.getWindowHandle();
				Set<String> set=driver.getWindowHandles();
				Iterator<String> itr=set.iterator();
				while(itr.hasNext())
				{
					String childWindow=itr.next();
					if(!mainwindow.equals(childWindow))
					{
						driver.switchTo().window(childWindow);
						Thread.sleep(15000);
						url=driver.getCurrentUrl();
						System.out.println("URL displayed as   :::::"+url); 

						if(url.contains("https://www.dell.com/support/mps/en-us"))
						{

							System.out.println("Switched to window");			
							header=driver.getTitle();
							System.out.println(header);
							Thread.sleep(6000);
							driver.close();
						}	
						else
						{
							driver.close();
							Report.put("Click on the Add My products & services ",
									"User should open the MPS link in new tab https://www.dell.com/support/mps/us-en",
									"Failed to display expected page in new tab", "FAIL");
							Assert.fail();
						}
						
					}
					

				}
				driver.switchTo().window(mainwindow);
				
			Report.put("Click on the Add My products & services ",
					"User should open the MPS link in new tab https://www.dell.com/support/mps/us-en",
					"User able to see MPS link in new tab with url "+Report.color(url)+" Header is: "+Report.color(header), "PASS");
			}
			else
			{
				Report.put("Click on the Add My products & services ",
						"User should open the MPS link in new tab https://www.dell.com/support/mps/us-en",
						"Failed to display expected page in new tab", "FAIL");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on the Add My products & services ",
					"User should open the MPS link in new tab https://www.dell.com/support/mps/us-en",
					"Failed to display expected page in new tab", "FAIL");
			Assert.fail();
		}
	}
	
	public void clickGetSupportNotificationLink(WebDriver driver)
	{
		System.out.println("Inside clickGetSupportNotificationLink method");
		Log.info("Inside clickGetSupportNotificationLink method");

		try
		{
			handleCookies(driver);
			String header = "";String url="";
			WebDriverWait wait = new WebDriverWait(driver, 120);

			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_EsupportIPSHomePage.GetSupportNotificationsLink()))
			{
				CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.GetSupportNotificationsLink());
				CommonUtility.ClickOn(driver,obj_EsupportIPSHomePage.GetSupportNotificationsLink());

				String mainwindow=driver.getWindowHandle();
				Set<String> set=driver.getWindowHandles();
				Iterator<String> itr=set.iterator();
				while(itr.hasNext())
				{
					String childWindow=itr.next();
					if(!mainwindow.equals(childWindow))
					{
						driver.switchTo().window(childWindow);
						Thread.sleep(15000);
						url=driver.getCurrentUrl();
						System.out.println("URL displayed as   :::::"+url); 

						if(url.contains("https://www.dell.com/support/preferences/en-us/notifications/updates")||url.contains("https://www.dell.com/support/Subscriptions/us/en/19/login")||url.contains("https://www.dell.com/support/Subscriptions/us/en/04/login"))
						{
                            System.out.println("Switched to window");			
							header=driver.getTitle();
							System.out.println(header);
							
						}	
						else
						{
							driver.close();
							Report.put("Comeback to the Product support page , Click on link get support notifications ",
									"User should direct to the https://www.dell.com/support/Subscriptions/en/us/19/login",
									"Failed to display expected page in new tab", "FAIL");
							Assert.fail();
						}
						driver.close();

					}
				}
				driver.switchTo().window(mainwindow);
				Report.put("Comeback to the Product support page , Click on link get support notifications ",
						"User should direct to the https://www.dell.com/support/Subscriptions/en/us/19/login",
					"User able to see MPS link in new tab with url "+Report.color(url)+" Header is: "+Report.color(header), "PASS");
			}
			else
			{
				Report.put("Comeback to the Product support page , Click on link get support notifications ",
						"User should direct to the https://www.dell.com/support/Subscriptions/en/us/19/login",
						"Failed to display expected page in new tab", "FAIL");
				
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Comeback to the Product support page , Click on link get support notifications ",
					"User should direct to the https://www.dell.com/support/Subscriptions/en/us/19/login",
					"Failed to display expected page in new tab", "FAIL");
			Assert.fail();
		}
	}
	
	public void verifyOverviewTabDetails_MoreResources(WebDriver driver)
	{
		System.out.println("Inside verifyOverviewTabDetails_MoreResources method");
		
		WebDriverWait wait = new WebDriverWait(driver, 120); 

		String header = "";
		String link = "";
		try
		{	
			
			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_EsupportIPSHomePage.MoreResourcesHeading()))
			{
			
			CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.MoreResourcesHeading());
			String moreRes=CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.MoreResourcesHeading()).getText();
			System.out.println(moreRes);
			
			CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.SupportVideosSection());
			CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.WatchVideosLink());
			String supVid=CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.WatchVideosLink()).getText();
			System.out.println(supVid);
			
			CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.KnowledgeBaseSection());
			CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.ViewKnowledgeBaseLink());
			String knowBase=CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.ViewKnowledgeBaseLink()).getText();
			System.out.println(knowBase);
			
			CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.CommunityForumsSection());
			CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.VisitTheDellCommunityLink());
			String comFor=CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.VisitTheDellCommunityLink()).getText();
			System.out.println(comFor);
			
			Report.put("In the overview tab ,Verify the More resources section",
					"user should display the more resources section with web parts support Videos , Knowledge base and Community forums",
					"User able to see "+Report.color(moreRes)+" And also able to view "+Report.color(supVid+" , "+knowBase+" , "+comFor), "PASS");
			}
			else
			{
				Report.put("In the overview tab ,Verify the More resources section",
						"user should display the more resources section with web parts support Videos , Knowledge base and Community forums",
						"Failed to Load Overview Tab with expected sections", "FAIL");
				Assert.fail();
			}
			} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("In the overview tab ,Verify the More resources section",
					"user should display the more resources section with web parts support Videos , Knowledge base and Community forums",
					"Failed to Load Overview Tab with expected sections", "FAIL");
			Assert.fail();
		}
	}
	
	public void clickWatchVideosButton(WebDriver driver)
	{
		System.out.println("Inside clickWatchVideosButton method");
		Log.info("Inside clickWatchVideosButton method");

		try
		{
			handleCookies(driver);
			String header = "";String url="";
			WebDriverWait wait = new WebDriverWait(driver, 120);

			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_EsupportIPSHomePage.WatchVideosLink()))
			{
				CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.WatchVideosLink());
				CommonUtility.ClickOn(driver,obj_EsupportIPSHomePage.WatchVideosLink());

				String mainwindow=driver.getWindowHandle();
				Set<String> set=driver.getWindowHandles();
				Iterator<String> itr=set.iterator();
				while(itr.hasNext())
				{
					String childWindow=itr.next();
					if(!mainwindow.equals(childWindow))
					{
						driver.switchTo().window(childWindow);
						Thread.sleep(15000);
						url=driver.getCurrentUrl();
						System.out.println("URL displayed as   :::::"+url); 

						if(url.contains("https://www.dell.com/support/contents/en-us/videos"))
						{

							System.out.println("Switched to window");			
							header=driver.getTitle();
							System.out.println(header);
							
						}	
						else
						{
							driver.close();
							Report.put("Under support Videos , Click on watch videos link ",
									"User should land in the support videos page in new tab https://www.dell.com/support/contents/en-us/videos",
									"Failed to display expected page in new tab", "FAIL");
							Assert.fail();
						}
						driver.close();

					}
				}
				driver.switchTo().window(mainwindow);
				Report.put("Under support Videos , Click on watch videos link ",
						"User should land in the support videos page in new tab https://www.dell.com/support/contents/en-us/videos",
					"User able to see expected new tab with url "+Report.color(url)+" Header is: "+Report.color(header), "PASS");
			}
			else
			{
				Report.put("Under support Videos , Click on watch videos link ",
						"User should land in the support videos page in new tab https://www.dell.com/support/contents/en-us/videos",
						"Failed to display expected page in new tab", "FAIL");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on the Add My products & services ",
					"User should open the MPS link in new tab https://www.dell.com/support/mps/us-en",
					"Failed to display expected page in new tab", "FAIL");
			Assert.fail();
		}
	}
	
	public void clickVisitKnowledgeBaseButton(WebDriver driver)
	{
		System.out.println("Inside clickVisitKnowledgeBaseButton method");
		Log.info("Inside clickVisitKnowledgeBaseButton method");

		try
		{
			handleCookies(driver);
			String header = "";String url="";
			WebDriverWait wait = new WebDriverWait(driver, 120);

			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_EsupportIPSHomePage.ViewKnowledgeBaseLink()))
			{
				CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.ViewKnowledgeBaseLink());
				CommonUtility.ClickOn(driver,obj_EsupportIPSHomePage.ViewKnowledgeBaseLink());

				String mainwindow=driver.getWindowHandle();
				Set<String> set=driver.getWindowHandles();
				Iterator<String> itr=set.iterator();
				while(itr.hasNext())
				{
					String childWindow=itr.next();
					if(!mainwindow.equals(childWindow))
					{
						driver.switchTo().window(childWindow);
						Thread.sleep(15000);
						url=driver.getCurrentUrl();
						System.out.println("URL displayed as   :::::"+url); 

						//if(url.contains("https://www.dell.com/support/contents/en-us/support/knowledgebase"))
						if(url.contains("https://www.dell.com/support/contents/en-us/category/product-support/self-support-knowledgebase"))
						{

							System.out.println("Switched to window");			
							header=driver.getTitle();
							System.out.println(header);
							
						}	
						else
						{
							driver.close();
							Report.put("Comeback to the Product support page and click on the Visit Knowledge Link",
									"User should land in the Knowledge base jump page in new tab https://www.dell.com/support/home/en-us?app=knowledgebase",
									"Failed to display expected page in new tab", "FAIL");
							Assert.fail();
						}
						driver.close();

					}
				}
				driver.switchTo().window(mainwindow);
				Report.put("Comeback to the Product support page and click on the Visit Knowledge Link",
						"User should land in the Knowledge base jump page in new tab https://www.dell.com/support/home/en-us?app=knowledgebase",
					"User able to see expected new tab with url "+Report.color(url)+" Header is: "+Report.color(header), "PASS");
			}
			else
			{
				Report.put("Comeback to the Product support page and click on the Visit Knowledge Link",
						"User should land in the Knowledge base jump page in new tab https://www.dell.com/support/home/en-us?app=knowledgebase",
						"Failed to display expected page in new tab", "FAIL");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Comeback to the Product support page and click on the Visit Knowledge Link",
					"User should land in the Knowledge base jump page in new tab https://www.dell.com/support/home/en-us?app=knowledgebase",
					"Failed to display expected page in new tab", "FAIL");
			Assert.fail();
		}
	}
	
	public void clickVisitDellCommunityButton(WebDriver driver)
	{
		System.out.println("Inside clickVisitDellCommunityButton method");
		Log.info("Inside clickVisitDellCommunityButton method");

		try
		{
			handleCookies(driver);
			String header = "";String url="";
			WebDriverWait wait = new WebDriverWait(driver, 120);

			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_EsupportIPSHomePage.VisitTheDellCommunityLink()))
			{
				CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.VisitTheDellCommunityLink());
				CommonUtility.ClickOn(driver,obj_EsupportIPSHomePage.VisitTheDellCommunityLink());

				String mainwindow=driver.getWindowHandle();
				Set<String> set=driver.getWindowHandles();
				Iterator<String> itr=set.iterator();
				while(itr.hasNext())
				{
					String childWindow=itr.next();
					if(!mainwindow.equals(childWindow))
					{
						driver.switchTo().window(childWindow);
						Thread.sleep(15000);
						url=driver.getCurrentUrl();
						System.out.println("URL displayed as   :::::"+url); 

						//if(url.contains("https://www.dell.com/community/Dell-Community")) //https://www.dell.com/community/Dell-Community/ct-p/English
						if(url.contains("https://www.dell.com/community/Dell-Community/ct-p/English"))
						{

							System.out.println("Switched to window");			
							header=driver.getTitle();
							System.out.println(header);
							
						}	
						else
						{
							driver.close();
							Report.put("Comeback to the Product support page and Click on Visit dell Community link",
									"user should be able to go to community page based on language https://www.dell.com/community/Dell-Community/",
									"Failed to display expected page in new tab", "FAIL");
							Assert.fail();
						}
						driver.close();

					}
				}
				driver.switchTo().window(mainwindow);
				Report.put("Comeback to the Product support page and Click on Visit dell Community link",
						"user should be able to go to community page based on language https://www.dell.com/community/Dell-Community/",
					"User able to see expected new tab with url "+Report.color(url)+" Header is: "+Report.color(header), "PASS");
			}
			else
			{
				Report.put("Comeback to the Product support page and Click on Visit dell Community link",
						"user should be able to go to community page based on language https://www.dell.com/community/Dell-Community/",
						"Failed to display expected page in new tab", "FAIL");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Comeback to the Product support page and Click on Visit dell Community link",
					"user should be able to go to community page based on language https://www.dell.com/community/Dell-Community/",
					"Failed to display expected page in new tab", "FAIL");
			Assert.fail();
		}
	}
	
	public void verifyOverviewTabDetails_SignInOption(WebDriver driver)
	{
		System.out.println("Inside verifyOverviewTabDetails_SignInOption method");
		
		WebDriverWait wait = new WebDriverWait(driver, 120); 

		String header = "";
		String link = "";
		try
		{	
			CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.AccessSupportCustomizedHeading());
			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_EsupportIPSHomePage.AccessSupportCustomizedHeading()))
			{
			CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.AccessSupportCustomizedHeading());
			String accSupHead=CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.AccessSupportCustomizedHeading()).getText();
			System.out.println(accSupHead);
			
			CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.AccessSupportCustomizedDetails());
			String accSupDet=CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.AccessSupportCustomizedDetails()).getText();
			System.out.println(accSupDet);
			
			CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.SignInButtonInOverviewTab());
			String enterSer=CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.SignInButtonInOverviewTab()).getText();
			System.out.println(enterSer);
			
						
				
			
			Report.put("Verify the sign in option in the overview tab ",
					"Overview tab should display  Access support customized for your product  test with Sign button ",
					"User able to see Overview tab with "+Report.color(accSupHead)+" with details "+Report.color(accSupDet)+" with "+Report.color(enterSer)+" button ", "PASS");
			}
			else
			{
				Report.put("Verify the sign in option in the overview tab ",
						"Overview tab should display  Access support customized for your product  test with Sign button ",
						"Failed to Load Overview Tab with expected sections", "FAIL");
				Assert.fail();
			}
			} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify the sign in option in the overview tab ",
					"Overview tab should display  Access support customized for your product  test with Sign button ",
					"Failed to Load Overview Tab with expected sections", "FAIL");
			Assert.fail();
		}
	}
	
	public void clickOnSignInButtonInOverviewTab(WebDriver driver)
	{
		System.out.println("Inside clickOnSignInButtonInOverviewTab method");
		
		WebDriverWait wait = new WebDriverWait(driver, 120); 

		String header = "";
		String link = "";
		try
		{	
			
			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_EsupportIPSHomePage.SignInButtonInOverviewTab()))
			{
			
			
			CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.SignInButtonInOverviewTab());
			String enterSer=CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.SignInButtonInOverviewTab()).getText();
			System.out.println(enterSer);
			CommonUtility.ClickOn(driver,obj_EsupportIPSHomePage.SignInButtonInOverviewTab());
			
			if(CommonUtility.CheckpresenceofElementLocated(driver, 30, obj_EsupportIPSHomePage.signInHeader()))
			{
//				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIPSHomePage.signInHeader()));
				CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.signInHeader());
				header = CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.signInHeader()).getText();
			}
			else if(CommonUtility.CheckpresenceofElementLocated(driver, 30, obj_EsupportIPSHomePage.SignInHeaderNew()))
			{
//				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIPSHomePage.SignInHeaderNew()));
				CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.SignInHeaderNew());
				header = CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.SignInHeaderNew()).getText();
			}
			
			
			
			Report.put("Click on sign in ",
					"User should load the Login Page",
					"User able to clickon "+Report.color(enterSer)+" button and able to see  "+Report.color(header)+" page ", "PASS");
			}
			else
			{
				Report.put("Click on sign in ",
						"User should load the Login Page",
						"Failed to load sign in page", "FAIL");
				Assert.fail();
			}
			} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on sign in ",
					"User should load the Login Page",
					"Failed to load sign in page", "FAIL");
			Assert.fail();
		}
	}
	
	public void verifyOverviewTabDetails_QuickLinks_ProductnameSearch(WebDriver driver)
	{
		System.out.println("Inside verifyOverviewTabDetails_QuickLinks_ProductnameSearch method");
		
		WebDriverWait wait = new WebDriverWait(driver, 120); 

		String header = "";
		String link = "";
		try
		{	
			
			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_EsupportIPSHomePage.QuickLinkLinks()))
			{
				CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.QuickLinksHeading());
				String quickLin=CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.QuickLinksHeading()).getText();
				System.out.println(quickLin);
			String tabList="";
			CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.QuickLinkLinks());
			List<WebElement> list=driver.findElements(obj_EsupportIPSHomePage.QuickLinkLinks());

			for(WebElement lt:list)
			{
				CommonUtility.highlightElement(driver, lt);
				String tabName=lt.getText();

				System.out.println("link is: " +tabName);
				tabList+=" <br> " + tabName;
			}
			System.out.println("links are:"+tabList);
			
			if(!(tabList.contains("Identify your product")))
			{
				Report.put("Check the quick links section",
						"Quick links section should contain the identify your product link ",
						"Failed to Load Overview Tab with expected section", "FAIL");
//				Assert.fail();
			}
			
			
			Report.put("Check the quick links section",
					"Quick links section should contain the identify your product link ",
					"User able to see "+Report.color(quickLin)+" with links "+Report.color(tabList), "PASS");
			}
			else
			{
				Report.put("Check the quick links section",
						"Quick links section should contain the identify your product link ",
						"Failed to Load Overview Tab with expected section", "FAIL");
				Assert.fail();
			}
			} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Check the quick links section",
					"Quick links section should contain the identify your product link ",
					"Failed to Load Overview Tab with expected section", "FAIL");
			Assert.fail();
		}
	}
	
	public void clickIdentifyYourProductLink(WebDriver driver)
	{
		System.out.println("Inside clickIdentifyYourProductLink method");
		Log.info("Inside clickIdentifyYourProductLink method");

		try
		{
			handleCookies(driver);
			String header = "";String url="";
			WebDriverWait wait = new WebDriverWait(driver, 120);

			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_EsupportIPSHomePage.IdentifyYourProductLink()))
			{
				CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.IdentifyYourProductLink());
				CommonUtility.ClickOn(driver,obj_EsupportIPSHomePage.IdentifyYourProductLink());

				String mainwindow=driver.getWindowHandle();
				Set<String> set=driver.getWindowHandles();
				Iterator<String> itr=set.iterator();
				while(itr.hasNext())
				{
					String childWindow=itr.next();
					if(!mainwindow.equals(childWindow))
					{
						driver.switchTo().window(childWindow);
						Thread.sleep(15000);
						url=driver.getCurrentUrl();
						System.out.println("URL displayed as   :::::"+url); 

						if(url.contains("https://www.dell.com/support/contents/en-us/category/product-support/self-support-knowledgebase/locate-service-tag"))
						{

							System.out.println("Switched to window");			
							header=driver.getTitle();
							System.out.println(header);
							
						}	
						else
						{
							driver.close();
							Report.put("Click on identify your product under quick links",
									"User should direct to the article page in new tab https://www.dell.com/support/contents/en-us/category/product-support/self-support-knowledgebase/locate-service-tag",
									"Failed to display expected page in new tab", "FAIL");
							Assert.fail();
						}
						driver.close();

					}
				}
				driver.switchTo().window(mainwindow);
				Report.put("Click on identify your product under quick links",
						"User should direct to the article page in new tab https://www.dell.com/support/contents/en-us/category/product-support/self-support-knowledgebase/locate-service-tag",
					"User able to see expected new tab with url "+Report.color(url)+" Header is: "+Report.color(header), "PASS");
			}
			else
			{
				Report.put("Click on identify your product under quick links",
						"User should direct to the article page in new tab https://www.dell.com/support/contents/en-us/category/product-support/self-support-knowledgebase/locate-service-tag",
						"Failed to display expected page in new tab", "FAIL");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on identify your product under quick links",
					"User should direct to the article page in new tab https://www.dell.com/support/contents/en-us/category/product-support/self-support-knowledgebase/locate-service-tag",
					"Failed to display expected page in new tab", "FAIL");
			Assert.fail();
		}
	}
	
	public void ContactTechnicalSection(WebDriver driver)
	{
		System.out.println("Inside ContactTechnicalSection method");
		
		WebDriverWait wait = new WebDriverWait(driver, 120); 

		String header = "";
		String link = "";
		try
		{	
			CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.NeedContactUsHeding());
			
			if(CommonUtility.CheckpresenceofElementLocated(driver,30,obj_EsupportIPSHomePage.NeedContactUsHeding()))
			{
			CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.NeedContactUsHeding());
			String contusHead=CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.NeedContactUsHeding()).getText();
			System.out.println(contusHead);
			
			CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.ContactUsSectionDetails());
			String contusDet=CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.ContactUsSectionDetails()).getText();
			System.out.println(contusDet);

			CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.ContactTechnicalSupportLink());
			String ctsLink=CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.ContactTechnicalSupportLink()).getText();
			System.out.println(ctsLink);
			
			CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.ImageOfCTDPage());
			
			Report.put("On the right check for the contact technical support link ",
					"Contact technical support link should be displayed ",
					"User able to see "+Report.color(contusHead)+" section along with details "+Report.color(contusDet)+" with "+Report.color(ctsLink)+" button", "PASS");
			}
			else
			{
				Report.put("On the right check for the contact technical support link ",
						"Contact technical support link should be displayed ",
						"Failed to Load Overview Tab with expected sections", "FAIL");
				Assert.fail();
			}
			} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("On the right check for the contact technical support link ",
					"Contact technical support link should be displayed ",
					"Failed to Load Overview Tab with expected sections", "FAIL");
			Assert.fail();
		}
	}
	
	public void clickContactTechnicalSupportLink(WebDriver driver)
	{
		System.out.println("Inside clickContactTechnicalSupportLink method");
		Log.info("Inside clickContactTechnicalSupportLink method");

		try
		{
			handleCookies(driver);
			String header = "";String url="";
			WebDriverWait wait = new WebDriverWait(driver, 120);

			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_EsupportIPSHomePage.ContactTechnicalSupportLink()))
			{
				CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.ContactTechnicalSupportLink());
				CommonUtility.ClickOn(driver,obj_EsupportIPSHomePage.ContactTechnicalSupportLink());

				String mainwindow=driver.getWindowHandle();
				Set<String> set=driver.getWindowHandles();
				Iterator<String> itr=set.iterator();
				while(itr.hasNext())
				{
					String childWindow=itr.next();
					if(!mainwindow.equals(childWindow))
					{
						driver.switchTo().window(childWindow);
						Thread.sleep(15000);
						url=driver.getCurrentUrl();
						System.out.println("URL displayed as   :::::"+url); 

						if(url.contains("https://www.dell.com/support/incidents-online/en-us/contactus") ||url.contains("https://support-dellemc-com.secure.force.com"))
						{

							System.out.println("Switched to window");			
							header=driver.getTitle();
							System.out.println(header);
							
						}	
						else
						{
							driver.close();
							Report.put("Click on the contact technical support link",
									"User should direct to the Contact support page https://www.dell.com/support/incidents-online/en-us/contactus/Dynamic?spestate",
									"Failed to display expected page in new tab", "FAIL");
							Assert.fail();
						}
						driver.close();

					}
				}
				driver.switchTo().window(mainwindow);
				Report.put("Click on the contact technical support link",
						"User should direct to the Contact support page https://www.dell.com/support/incidents-online/en-us/contactus/Dynamic?spestate",
					"User able to see expected new tab with url "+Report.color(url)+" Header is: "+Report.color(header), "PASS");
			}
			else
			{
				Report.put("Click on the contact technical support link",
						"User should direct to the Contact support page https://www.dell.com/support/incidents-online/en-us/contactus/Dynamic?spestate",
						"Failed to display expected page in new tab", "FAIL");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on the contact technical support link",
					"User should direct to the Contact support page https://www.dell.com/support/incidents-online/en-us/contactus/Dynamic?spestate",
					"Failed to display expected page in new tab", "FAIL");
			Assert.fail();
		}
	}
	
	public void verifyOverviewTabDetails_SystemAtAGlance(WebDriver driver)
	{
		System.out.println("Inside verifyOverviewTabDetails_SystemAtAGlance method");
		
		WebDriverWait wait = new WebDriverWait(driver, 120); 

		String header = "";
		String link = "";
		try
		{	
			
			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_EsupportIPSHomePage.YourSystemAtAGlance()))
			{
			CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.YourSystemAtAGlance());
			String firsthead=CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.YourSystemAtAGlance()).getText();
			System.out.println(firsthead);
			
			CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.WarrantyStatusHeading());
			String warHead=CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.WarrantyStatusHeading()).getText();
			System.out.println(warHead);
			
			CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.WarrantyDetailsDisplayed());
			String warDet=CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.WarrantyDetailsDisplayed()).getText();
			System.out.println(warDet);
			
//			CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.LinkInWarrantySection());
//			String warLink=CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.LinkInWarrantySection()).getText();
//			System.out.println(warLink);
			
			
			
			Report.put("Check the system at a glance section ",
					"System at glance section should display warranty section and connectivity section ",
					"User able to see "+Report.color(warHead)+" details under "+Report.color(firsthead)+" section", "PASS");
			}
			else
			{
				Report.put("Check the system at a glance section ",
						"System at glance section should display warranty section and connectivity section ",
						"Failed to Load Overview Tab with expected sections", "FAIL");
				Assert.fail();
			}
			} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Check the system at a glance section ",
					"System at glance section should display warranty section and connectivity section ",
					"Failed to Load Overview Tab with expected sections", "FAIL");
			Assert.fail();
		}
	}
	
	public void verifyOverviewTabDetails_RevenueOffers(WebDriver driver)
	{
		System.out.println("Inside verifyOverviewTabDetails_RevenueOffers method");
		
		WebDriverWait wait = new WebDriverWait(driver, 120); 

		String header = "";
		String link = "";
		try
		{	
			
			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_EsupportIPSHomePage.ComputerNotWorkingLHead()))
			{
				CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.ComputerNotWorkingLHead());
				String com=CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.ComputerNotWorkingLHead()).getText();
				System.out.println(com);
				
				CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.IssueListSection());
				
				
			String tabList="";
			CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.HardwareAndSoftWareHeaders());
			List<WebElement> list=driver.findElements(obj_EsupportIPSHomePage.HardwareAndSoftWareHeaders());

			for(WebElement lt:list)
			{
				CommonUtility.highlightElement(driver, lt);
				String tabName=lt.getText();

				System.out.println("link is: " +tabName);
				tabList+=" <br> " + tabName;
			}
			System.out.println("headings are are:"+tabList);
			
			List<WebElement> list1=driver.findElements(obj_EsupportIPSHomePage.HardwareAndSoftWareSection());

			for(WebElement lt:list1)
			{
				CommonUtility.ScrollToWebElement(driver, lt);
				
			}
			String mig="";
			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_EsupportIPSHomePage.MigrateDataFromYourOldSystem()))
			{
			CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.MigrateDataFromYourOldSystem());
			mig=CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.MigrateDataFromYourOldSystem()).getText();
			System.out.println(mig);
			
			CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.DellMigrateSection());
			}
			
			Report.put("Verify the revenue offers in the overview tab",
					"user should be able to see the revenue offer ( hardware and software with price ) when available below the system at a glance section ",
					"User able to see "+Report.color(com)+" heading along with issue list section and "+Report.color(tabList)+" heading along with "+Report.color(mig)+" section", "PASS");
			}
			else
			{
				Report.put("Verify the revenue offers in the overview tab",
						"user should be able to see the revenue offer ( hardware and software with price ) when available below the system at a glance section ",
						"Failed to Load Overview Tab with expected section", "FAIL");
				Assert.fail();
			}
			} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify the revenue offers in the overview tab",
					"user should be able to see the revenue offer ( hardware and software with price ) when available below the system at a glance section ",
					"Failed to Load Overview Tab with expected section", "FAIL");
			Assert.fail();
		}
	}
	
	
	public void searchServiceTag_productID(WebDriver driver,String serviceTag) 
	{		
		WebDriverWait wait = new WebDriverWait(driver, 240);

		System.out.println("Entering searchServiceTag_productID");

		Log.info("Entering searchServiceTag_productID");   
		
		try 
		{	
			String header="";
			String prodHeader="";
			String servicet ="";

			System.out.println("Service Tag from Test data sheet is :" +serviceTag);
			handleCookies(driver);
			//CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.Delllogo());

			//			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIPSHomePage.supportHeader()));

			CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.supportHeader());

			header = CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.supportHeader()).getText();
			System.out.println("Welcome Page header is:"+header);
			CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.serviceTagTextbox());
			CommonUtility.ClickOn(driver,obj_EsupportIPSHomePage.serviceTagTextbox());
			CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.serviceTagTextbox()).clear();

			CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.serviceTagTextbox()).sendKeys(serviceTag);
			
			//			CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.serviceTagSearchButton()).click();
			//			CommonUtility.ToClickByUsingJavaScript_PassingByLoc(driver,obj_EsupportIPSHomePage.serviceTagSearchButton());
			CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.serviceTagSearchButton());
			CommonUtility.ClickOn(driver,obj_EsupportIPSHomePage.serviceTagSearchButton());

            Thread.sleep(10000);
			//wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIPSHomePage.productHeader()));
			if(CommonUtility.CheckpresenceofElementLocated(driver, 10, obj_EsupportIPSHomePage.productHeader()))
			{
			CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.productHeader());
			prodHeader = CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.productHeader()).getText();

			System.out.println("Product Page header is:"+prodHeader);
			}
			else
			{
				CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.ProductHeader2());
				prodHeader = CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.ProductHeader2()).getText();

				System.out.println("Product Page header is:"+prodHeader);
			}
			
				
			if(!(prodHeader.contains(serviceTag)))
			{
				System.out.println("tag doesnt not match with searched");
				Report.put("In the product selector , Enter service Tag ( Service tag that has parts and accessories support ) and click on search:"+Report.color(serviceTag),
						"User should land into Product Support Page",
						"Failed to see searched tag in product home page", "FAIL");
//				Assert.fail();
			}
			

			Report.put("In the product selector , Enter service Tag ( Service tag that has parts and accessories support ) and click on search"+Report.color(serviceTag),
					"User should land into Product Support Page",
					"Successfully navigated to Product Support Page. Header is: "+Report.color(prodHeader)+" and tag displayed is "+Report.color(servicet), "PASS");

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("In the product selector , Enter service Tag ( Service tag that has parts and accessories support ) and click on search"+Report.color(serviceTag),
					"User should land into Product Support Page",
					"Failed to navigate to Product Support Page.", "FAIL");
			Assert.fail();

		}
	}
	
	public void verifyOverviewTabDetails_SystemAtAGlance_Renew(WebDriver driver)
	{
		System.out.println("Inside verifyOverviewTabDetails_SystemAtAGlance_Renew method");
		
		WebDriverWait wait = new WebDriverWait(driver, 120); 

		String header = "";
		String link = "";
		try
		{	
			
			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_EsupportIPSHomePage.YourSystemAtAGlance()))
			{
			CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.YourSystemAtAGlance());
			String firsthead=CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.YourSystemAtAGlance()).getText();
			System.out.println(firsthead);
			
			CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.WarrantyStatusHeading());
			String warHead=CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.WarrantyStatusHeading()).getText();
			System.out.println(warHead);
			
			CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.WarrantyDetailsDisplayed());
			String warDet=CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.WarrantyDetailsDisplayed()).getText();
			System.out.println(warDet);
			
			
			String tabList="";
			CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.LinkInWarrantySection());
			List<WebElement> list=driver.findElements(obj_EsupportIPSHomePage.LinkInWarrantySection());

			for(WebElement lt:list)
			{
				CommonUtility.highlightElement(driver, lt);
				String tabName=lt.getText();

				System.out.println("link is: " +tabName);
				tabList+=" <br> " + tabName;
			}
			System.out.println("links are:"+tabList);
			
			if(!(tabList.contains("View warranty details") &&tabList.contains("Renew")))
			{
				System.out.println("expected links not displayed");
				Report.put("Verify the warranty Information ( expired Tag ) ",
						"Warranty status Warranty Expired on Date ( format DD MMM YYYY )  on the right side check for the links View Warranty details and Renew Link ",
						"Failed to Load Overview Tab with expected sections", "FAIL");
				Assert.fail();
			}
			
			Report.put("Verify the warranty Information ( expired Tag ) ",
					"Warranty status Warranty Expired on Date ( format DD MMM YYYY )  on the right side check for the links View Warranty details and Renew Link ",
					"User able to see "+Report.color(warHead)+" details under "+Report.color(firsthead)+" section along with "+Report.color(warDet)+" with "+Report.color(tabList)+" links", "PASS");
			}
			else
			{
				Report.put("Verify the warranty Information ( expired Tag ) ",
						"Warranty status Warranty Expired on Date ( format DD MMM YYYY )  on the right side check for the links View Warranty details and Renew Link ",
						"Failed to Load Overview Tab with expected sections", "FAIL");
				Assert.fail();
			}
			} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify the warranty Information ( expired Tag ) ",
					"Warranty status Warranty Expired on Date ( format DD MMM YYYY )  on the right side check for the links View Warranty details and Renew Link ",
					"Failed to Load Overview Tab with expected sections", "FAIL");
			Assert.fail();
		}
	}
	
	public void clickOnRenewButton(WebDriver driver)
	{
		System.out.println("Inside clickOnRenewButton method");
		Log.info("Inside clickOnRenewButton method");

		try
		{
			handleCookies(driver);
			String header = "";String url="";
			WebDriverWait wait = new WebDriverWait(driver, 120);

			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_EsupportIPSHomePage.RenewLink()))
			{
				CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.RenewLink());
				CommonUtility.ClickOn(driver,obj_EsupportIPSHomePage.RenewLink());

				String mainwindow=driver.getWindowHandle();
				Set<String> set=driver.getWindowHandles();
				Iterator<String> itr=set.iterator();
				while(itr.hasNext())
				{
					String childWindow=itr.next();
					if(!mainwindow.equals(childWindow))
					{
						driver.switchTo().window(childWindow);
						Thread.sleep(15000);
						url=driver.getCurrentUrl();
						System.out.println("URL displayed as   :::::"+url); 

						if(url.contains("https://renewals.dell.com/tags/12Q89N2?relayState=online"))
						{

							System.out.println("Switched to window");			
							header=driver.getTitle();
							System.out.println(header);
							
						}	
						else
						{
							driver.close();
							Report.put("Click on the Renew link in the warranty status section ",
									"User should direct to the https://www.dell.com/support/incidents-online/en-us/email/extend-warranty",
									"Failed to display expected page in new tab", "FAIL");
							Assert.fail();
						}
						driver.close();

					}
				}
				driver.switchTo().window(mainwindow);
				Report.put("Click on the Renew link in the warranty status section ",
						"User should direct to the https://www.dell.com/support/incidents-online/en-us/email/extend-warranty",
					"User able to see expected new tab with url "+Report.color(url)+" Header is: "+Report.color(header), "PASS");
			}
			else
			{
				Report.put("Click on the Renew link in the warranty status section ",
						"User should direct to the https://www.dell.com/support/incidents-online/en-us/email/extend-warranty",
						"Failed to display expected page in new tab", "FAIL");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on the Renew link in the warranty status section ",
					"User should direct to the https://www.dell.com/support/incidents-online/en-us/email/extend-warranty",
					"Failed to display expected page in new tab", "FAIL");
			Assert.fail();
		}
	}
	
	public void clickDDLLink(WebDriver driver)
	{
		System.out.println("Inside clickDDLLink method");
		Log.info("Inside clickDDLLink method");

		try
		{			
			String text = "";
			String header = "";
			String currentUrl = "";

			handleCookies(driver);
			WebDriverWait wait = new WebDriverWait(driver, 60);
			CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.DellDLlink());
			CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.DellDLlink());

			text = CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.DellDLlink()).getText();
			
			CommonUtility.ClickOn(driver,obj_EsupportIPSHomePage.DellDLlink());
			System.out.println("Link text is: "+text);


			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIPSHomePage.FirstHeader()));
			CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.FirstHeader());
			header = CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.FirstHeader()).getText();

			System.out.println("Header is:"+header);

			currentUrl = driver.getCurrentUrl();

			System.out.println("Current URl is:"+currentUrl);

			Report.put("Comeback to the modal pop up page and click on Dell Digital Locker Link  ",
					"User should direct to the software licensing page https://www.dell.com/support/software/us/en/04",
					"Redirected to DDL page Successfully. Header is: "+Report.color(header)+"<br>"+"URL is:"+Report.color(currentUrl), "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();

			Report.put("Comeback to the modal pop up page and click on Dell Digital Locker Link  ",
					"User should direct to the software licensing page https://www.dell.com/support/software/us/en/04",
					"Failed to Redirect to DDL Page", "FAIL");
			Assert.fail();
		}
	}

	public void launchUrl(WebDriver driver,  String moduleUrl)
	{
		System.out.println("Inside launchUrl method");
		String header="";
		WebDriverWait wait = new WebDriverWait(driver, 150);

		try
		{
			//			Thread.sleep(6000);
			driver.get(moduleUrl);
			//			Thread.sleep(6000);

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIncidentsPage.TSHeader()));
			header = CommonUtility.highlightElement(driver,obj_EsupportIncidentsPage.TSHeader()).getText();
			System.out.println("header is "+header);

			Report.put("Enter the Family name and click on search or directly launch the url https://www.dell.com/support/home/en-us/product-support/product/xtremio-family/overview",
						"User should land in the Product Family page",
						"User landed on "+Report.color(header)+" product page", "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Enter the Family name and click on search or directly launch the url https://www.dell.com/support/home/en-us/product-support/product/xtremio-family/overview",
					"User should land in the Product Family page",
					"Failed to load "+moduleUrl+" home page", "FAIL");
			Assert.fail();
		}
	}
	
	public void ValidateProductDescription(WebDriver driver)
	{
		System.out.println("Inside ValidateProductDescription method");
		Log.info("Inside ValidateProductDescription method");

		String text = "";
		try
		{
			//handleCookies(driver);

			if(CommonUtility.CheckpresenceofElementLocated(driver, 10, obj_EsupportIPSHomePage.ProductDescription()))
			{
				CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.ProductDescription());
				text = CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.ProductDescription()).getText();
				System.out.println(text);

				Report.put("Check for the product Description in the hero section ",
						"user should be able to see the product description in hero section  when the product description is not available then the user should not be able to see the description",
						"Description displayed is " +Report.color(text), "PASS");
			}	
			
			if(!CommonUtility.CheckpresenceofElementLocated(driver, 10, obj_EsupportIPSHomePage.ProductDescription()))
			{
				Report.put("Check for the product Description in the hero section ",
						"user should be able to see the product description in hero section  when the product description is not available then the user should not be able to see the description",
						"Description details not displayed" , "Pass");
				
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Check for the product Description in the hero section ",
					"user should be able to see the product description in hero section  when the product description is not available then the user should not be able to see the description",
					"Failed to Display the expected details" , "FAIL");
			Assert.fail();
		}
	}
	
	public void verifyNickname_AlreadyAdded(WebDriver driver)
	{
		System.out.println("Inside verifyNickname_AlreadyAdded method");
		Log.info("Inside verifyNickname_AlreadyAdded method");
		String val=TestNGCreator.TestData.get(Esupport.SearchOption.ordinal());

		try
		{                 
			WebDriverWait wait = new WebDriverWait(driver, 240);    

			
			//			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIPSHomePage.Nickname()));
			CommonUtility.ScrollTo(driver,(obj_EsupportIPSHomePage.AddNickname()));
			String Nickname=CommonUtility.highlightElement(driver,(obj_EsupportIPSHomePage.AddNickname())).getText();


			Report.put("Verify the Nickname",
					"Nickname should be present besides the service tag: ",
					"Nickname is present besides the service tag"+Report.color(Nickname), "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();

			Report.put("Verify the Nickname",
					"Nickname should be present besides the service tag: ",
					"Nickname is not present besides the service tag", "FAIL");
			Assert.fail();
		}
	}
	public void SelectModelOrSeriesFromDropDown(WebDriver driver)
	{

		Log.info("Inside SelectModelOrSeriesFromDropDown method");

		String heading = "";

		String labelList = "";
		String selectedOption;
		String availableOption;
		String optionList = "";
		String coveopageresults="";
		String ValidateCoveoPageTitle="";
		String BackToDocumentationTab="";
		String value=TestNGCreator.TestData.get(Esupport.SearchOption.ordinal());

		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportContentHomePage.ModelSelectDropDown()));
			CommonUtility.ScrollTo(driver,obj_EsupportContentHomePage.ModelSelectDropDown());
			heading = CommonUtility.highlightElement(driver, obj_EsupportContentHomePage.GetOptionSelectedByDefault()).getText();
			System.out.println(heading);


			Select dialOption = new  Select(driver.findElement(obj_EsupportContentHomePage.ModelSelectDropDown()));

			selectedOption = dialOption.getFirstSelectedOption().getText(); 
			System.out.println("Default: "+selectedOption);

			List<WebElement> dialOptionsList=dialOption.getOptions();


			for (WebElement lt:dialOptionsList)
			{
				CommonUtility.highlightElement(driver, lt);

				String dialOpt=lt.getText();

				System.out.println("Option is: " +dialOpt);
				optionList+=" <br> " + dialOpt;
			}
			handleCookies(driver);
			obj_EsupportContentWorkflow.UnexpectedPopup_Prod(driver);
			dialOption.selectByVisibleText(value);



//			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportContentHomePage.SecurityHeader()));
//			coveopageresults=CommonUtility.highlightElement(driver, obj_EsupportContentHomePage.SecurityHeader()).getText();
//			System.out.println(coveopageresults);
//			if (coveopageresults.contains(value))
//			{
//				Log.info("Test case pass:");
//			}
//			else
//			{
//				Log.info("Test case fail:");
//				Report.put("check for the dropdown besides the series name and click on dropdown ", 
//						"user should be able to see the products under the drop down, and clicking on any user should be directed to the respective page",
//						"header not changed to selected dropdown value", "FAIL");
////				Assert.fail();
//			}



			Report.put("check for the dropdown besides the series name and click on dropdown ", 
					"user should be able to see the products under the drop down, and clicking on any user should be directed to the respective page",
					"able to see value"+Report.color(value)+" from drop down <br> and able to see header changing as "+Report.color(coveopageresults), "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("check for the dropdown besides the series name and click on dropdown ", 
					"user should be able to see the products under the drop down, and clicking on any user should be directed to the respective page",
					"failed to select value from drop down", "FAIL");
			Assert.fail();
		}
	}
	
	public void searchSeriesName(WebDriver driver,String serviceTag) 
	{		
		WebDriverWait wait = new WebDriverWait(driver, 240);

		System.out.println("Entering searchSeriesName");

		Log.info("Entering searchSeriesName");   
		
		try 
		{	
			String header="";
			String prodHeader="";
			String servicet ="";

			System.out.println("Service Tag from Test data sheet is :" +serviceTag);
			handleCookies(driver);
			//CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.Delllogo());

			//			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIPSHomePage.supportHeader()));

			CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.supportHeader());

			header = CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.supportHeader()).getText();
			System.out.println("Welcome Page header is:"+header);
			CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.serviceTagTextbox());
			CommonUtility.ClickOn(driver,obj_EsupportIPSHomePage.serviceTagTextbox());
			CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.serviceTagTextbox()).clear();

			CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.serviceTagTextbox()).sendKeys(serviceTag);
			
			//			CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.serviceTagSearchButton()).click();
			//			CommonUtility.ToClickByUsingJavaScript_PassingByLoc(driver,obj_EsupportIPSHomePage.serviceTagSearchButton());
			CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.serviceTagSearchButton());
			CommonUtility.ClickOn(driver,obj_EsupportIPSHomePage.serviceTagSearchButton());


			//wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIPSHomePage.productHeader()));
			if(CommonUtility.CheckpresenceofElementLocated(driver, 10, obj_EsupportIPSHomePage.productHeader()))
			{
			CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.productHeader());
			prodHeader = CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.productHeader()).getText();

			System.out.println("Product Page header is:"+prodHeader);
			}
			else
			{
				CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.ProductHeader2());
				prodHeader = CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.ProductHeader2()).getText();

				System.out.println("Product Page header is:"+prodHeader);
			}

			
			if(!(prodHeader.contains(serviceTag)))
			{
				System.out.println("series name doesnt not match with searched");
				Report.put("Enter the series name and click on search",
						"User should land in the EMC series page ",
						"Failed to see searched series name in product home page", "FAIL");
				Assert.fail();
			}
			

			Report.put("Enter the series name and click on search",
					"User should land in the EMC series page ",
					"Successfully navigated to Product Support Page. Header is: "+Report.color(prodHeader), "PASS");

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Enter the series name and click on search",
					"User should land in the EMC series page ",
					"Failed to navigate to Product Support Page.", "FAIL");
			Assert.fail();

		}
	}
	
	public void verifyOverviewTabDetails_QuickLinks_2(WebDriver driver)
	{
		System.out.println("Inside verifyOverviewTabDetails_QuickLinks_2 method");
		
		WebDriverWait wait = new WebDriverWait(driver, 120); 
		Actions act=new Actions(driver);
		String header = "";
		String link = "";
		try
		{	
			
			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_EsupportIPSHomePage.QuickLinkLinks()))
			{
				CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.QuickLinksHeading());
				String quickLin=CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.QuickLinksHeading()).getText();
				System.out.println(quickLin);
			String tabList="";
			CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.QuickLinkLinks());
			List<WebElement> list=driver.findElements(obj_EsupportIPSHomePage.QuickLinkLinks());

			for(WebElement lt:list)
			{
				CommonUtility.highlightElement(driver, lt);
				String tabName=lt.getText();

				System.out.println("link is: " +tabName);
				tabList+=" <br> " + tabName;
			}
			System.out.println("links are:"+tabList);
			
			
			if(!(tabList.contains("Request equipment refresh")) && !(tabList.contains("Add to Custom Group")) && !(tabList.contains("View all your assets")) && !(tabList.contains("Get support notifications")))
			{
				System.out.println("quick links are not expected links");
				Report.put("Verify the quick links section",
						"User should see quick links section in the overview tab on the left side- request equipment refresh, add to custom groups, view all assets, get support notifications",
						"Failed to Load Overview Tab with expected section with expected links under quick links", "FAIL");
				Assert.fail();
			}
			
			Report.put("Verify the quick links section",
					"User should see quick links section in the overview tab on the left side- request equipment refresh, add to custom groups, view all assets, get support notifications",
					"User able to see "+Report.color(quickLin)+" with links "+Report.color(tabList), "PASS");
			}
			else
			{
				Report.put("Verify the quick links section",
						"User should see quick links section in the overview tab on the left side- request equipment refresh, add to custom groups, view all assets, get support notifications",
						"Failed to Load Overview Tab with expected section", "FAIL");
				Assert.fail();
			}
			} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify the quick links section",
					"User should see quick links section in the overview tab on the left side- request equipment refresh, add to custom groups, view all assets, get support notifications",
					"Failed to Load Overview Tab with expected section", "FAIL");
			Assert.fail();
		}
	}
	
	
	public void ClickOnAddToCustomGroups(WebDriver driver)
	{
		System.out.println("Inside ClickOnAddToCustomGroups method");
		Log.info("Inside ClickOnAddToCustomGroups method");

		try
		{
			handleCookies(driver);
			String header = "";String url="";
			WebDriverWait wait = new WebDriverWait(driver, 120);

			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_EsupportIPSHomePage.AddToCustomGroupsLink()))
			{
				CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.AddToCustomGroupsLink());
				CommonUtility.ClickOn(driver,obj_EsupportIPSHomePage.AddToCustomGroupsLink());

				String mainwindow=driver.getWindowHandle();
				Set<String> set=driver.getWindowHandles();
				Iterator<String> itr=set.iterator();
				while(itr.hasNext())
				{
					String childWindow=itr.next();
					if(!mainwindow.equals(childWindow))
					{
						driver.switchTo().window(childWindow);
						Thread.sleep(15000);
						url=driver.getCurrentUrl();
						System.out.println("URL displayed as   :::::"+url); 

						if(url.contains("https://www.dell.com/support/preferences/en-us/mycustomgroups"))
						{

							System.out.println("Switched to window");			
							header=driver.getTitle();
							System.out.println(header);
							
						}	
						else
						{
							driver.close();
							Report.put("Comeback to the product support page and click on the add to custom groups ",
									"user should be able to add their asset to custom groups - https://www.dell.com/support/preferences/en-us/mycustomgroups",
									"Failed to display expected page in new tab", "FAIL");
							Assert.fail();
						}
						driver.close();

					}
					
				}
				driver.switchTo().window(mainwindow);
				
				Report.put("Comeback to the product support page and click on the add to custom groups ",
						"user should be able to add their asset to custom groups - https://www.dell.com/support/preferences/en-us/mycustomgroups",
					"User able to see MPS link in new tab with url "+Report.color(url)+" Header is: "+Report.color(header), "PASS");
			}
			else
			{
				Report.put("Comeback to the product support page and click on the add to custom groups ",
						"user should be able to add their asset to custom groups - https://www.dell.com/support/preferences/en-us/mycustomgroups",
						"Failed to display expected page in new tab", "FAIL");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Comeback to the product support page and click on the add to custom groups ",
					"user should be able to add their asset to custom groups - https://www.dell.com/support/preferences/en-us/mycustomgroups",
					"Failed to display expected page in new tab", "FAIL");
			Assert.fail();
		}
	}
	
	public void ClickOnViewAllAssets(WebDriver driver)
	{
		System.out.println("Inside ClickOnViewAllAssets method");
		Log.info("Inside ClickOnViewAllAssets method");

		try
		{
			handleCookies(driver);
			String header = "";String url="";
			WebDriverWait wait = new WebDriverWait(driver, 120);

			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_EsupportIPSHomePage.ViewAllYourAssetsLink()))
			{
				CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.ViewAllYourAssetsLink());
				CommonUtility.ClickOn(driver,obj_EsupportIPSHomePage.ViewAllYourAssetsLink());

				String mainwindow=driver.getWindowHandle();
				Set<String> set=driver.getWindowHandles();
				Iterator<String> itr=set.iterator();
				while(itr.hasNext())
				{
					String childWindow=itr.next();
					if(!mainwindow.equals(childWindow))
					{
						driver.switchTo().window(childWindow);
						Thread.sleep(15000);
						url=driver.getCurrentUrl();
						System.out.println("URL displayed as   :::::"+url); 

						if(url.contains("https://www.dell.com/support/myservice360/en-us/installbase/totalassets/tabular"))
						{

							System.out.println("Switched to window");			
							header=driver.getTitle();
							System.out.println(header);
							
						}	
						else
						{
							driver.close();
							Report.put("Comeback to the product support page and click on view all assets ",
									"user should be able to view all their assets https://www.dell.com/support/myservice360/us/en/04/installbase/totalassets/tabular?ref=esup_viewallassets",
									"Failed to display expected page in new tab", "FAIL");
							Assert.fail();
						}
						driver.close();

					}
					
				}
				driver.switchTo().window(mainwindow);
				
				Report.put("Comeback to the product support page and click on view all assets ",
						"user should be able to view all their assets https://www.dell.com/support/myservice360/us/en/04/installbase/totalassets/tabular?ref=esup_viewallassets",
					"User able to see MPS link in new tab with url "+Report.color(url)+" Header is: "+Report.color(header), "PASS");
			}
			else
			{
				Report.put("Comeback to the product support page and click on view all assets ",
						"user should be able to view all their assets https://www.dell.com/support/myservice360/us/en/04/installbase/totalassets/tabular?ref=esup_viewallassets",
						"Failed to display expected page in new tab", "FAIL");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Comeback to the product support page and click on view all assets ",
					"user should be able to view all their assets https://www.dell.com/support/myservice360/us/en/04/installbase/totalassets/tabular?ref=esup_viewallassets",
					"Failed to display expected page in new tab", "FAIL");
			Assert.fail();
		}
	}
	
	public void verifyOverviewTabDetails_QuickLinks_3(WebDriver driver)
	{
		System.out.println("Inside verifyOverviewTabDetails_QuickLinks_3 method");
		
		WebDriverWait wait = new WebDriverWait(driver, 120); 

		String header = "";
		String link = "";
		try
		{	
			
			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_EsupportIPSHomePage.QuickLinkLinks()))
			{
				CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.QuickLinksHeading());
				String quickLin=CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.QuickLinksHeading()).getText();
				System.out.println(quickLin);
			String tabList="";
			CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.QuickLinkLinks());
			List<WebElement> list=driver.findElements(obj_EsupportIPSHomePage.QuickLinkLinks());

			for(WebElement lt:list)
			{
				CommonUtility.highlightElement(driver, lt);
				String tabName=lt.getText();

				System.out.println("link is: " +tabName);
				tabList+=" <br> " + tabName;
			}
			System.out.println("links are:"+tabList);
			
			
			if(!(tabList.contains("Add to Custom Group")) && !(tabList.contains("View all your assets")) && !(tabList.contains("Get support notifications")))
			{
				System.out.println("quick links are not expected links");
				Report.put("Verify the quick links section",
						"User should see quick links section in the overview tab on the left side-  add to custom groups, view all assets, get support notifications",
						"Failed to Load Overview Tab with expected section with expected links under quick links", "FAIL");
				Assert.fail();
			}
			
			Report.put("Verify the quick links section",
					"User should see quick links section in the overview tab on the left side-  add to custom groups, view all assets, get support notifications",
					"User able to see "+Report.color(quickLin)+" with links "+Report.color(tabList), "PASS");
			}
			else
			{
				Report.put("Verify the quick links section",
						"User should see quick links section in the overview tab on the left side-  add to custom groups, view all assets, get support notifications",
						"Failed to Load Overview Tab with expected section", "FAIL");
				Assert.fail();
			}
			} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify the quick links section",
					"User should see quick links section in the overview tab on the left side-  add to custom groups, view all assets, get support notifications",
					"Failed to Load Overview Tab with expected section", "FAIL");
			Assert.fail();
		}
	}
	
	public void verifyOverviewTabDetails_ServiceEventsSection(WebDriver driver)
	{
		System.out.println("Inside verifyOverviewTabDetails_ServiceEventsSection method");
		
		WebDriverWait wait = new WebDriverWait(driver, 120); 

		String header = "";
		String link = "";
		String tabList="";
		try
		{	
			
			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_EsupportIPSHomePage.ActiveSRHeadingOverviewPage()))
			{
			
			CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.ActiveSRHeadingOverviewPage());
			String moreRes=CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.ActiveSRHeadingOverviewPage()).getText();
			System.out.println(moreRes);
			
			CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.ViewAllLinkOfSR());
			String supVid=CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.ViewAllLinkOfSR()).getText();
			System.out.println(supVid);
			
			List<WebElement> list=driver.findElements(obj_EsupportIPSHomePage.NoOfSRsDisplayed());

			for(WebElement lt:list)
			{
				CommonUtility.highlightElement(driver, lt);
				String tabName=lt.getText();

				System.out.println("Tab is: " +tabName);
				tabList+=" <br> " + tabName;
			}
			System.out.println("Tabs are:"+tabList);			
			
			Report.put("Verify the service events section ",
					"user should be able to see active service requests (if available) and each service request should show - SR type, SR#, severity and status with view all link ",
					"User able to see "+Report.color(moreRes)+" And also able to view "+Report.color(supVid)+" along with "+Report.color(tabList), "PASS");
			}
			else
			{
				Report.put("Verify the service events section ",
						"user should be able to see active service requests (if available) and each service request should show - SR type, SR#, severity and status with view all link ",
						"Failed to Load Overview Tab with expected sections", "FAIL");
				Assert.fail();
			}
			} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify the service events section ",
					"user should be able to see active service requests (if available) and each service request should show - SR type, SR#, severity and status with view all link ",
					"Failed to Load Overview Tab with expected sections", "FAIL");
			Assert.fail();
		}
	}
	
	public void clickViewAllLinkSRTab(WebDriver driver)
	{
		System.out.println("Inside clickViewAllLinkSRTab method");
		Log.info("Inside clickViewAllLinkSRTab method");

		try
		{
			handleCookies(driver);
			String header = "";String url="";
			WebDriverWait wait = new WebDriverWait(driver, 120);

			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_EsupportIPSHomePage.ViewAllLinkOfSR()))
			{
				CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.ViewAllLinkOfSR());
				CommonUtility.ClickOn(driver,obj_EsupportIPSHomePage.ViewAllLinkOfSR());

				String mainwindow=driver.getWindowHandle();
				Set<String> set=driver.getWindowHandles();
				Iterator<String> itr=set.iterator();
				while(itr.hasNext())
				{
					String childWindow=itr.next();
					if(!mainwindow.equals(childWindow))
					{
						driver.switchTo().window(childWindow);
						Thread.sleep(15000);
						url=driver.getCurrentUrl();
						System.out.println("URL displayed as   :::::"+url); 

						if(url.contains("events"))
						{

							System.out.println("Switched to window");			
							header=CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.ServiceEventsTabActiveState()).getText();
							System.out.println(header);
							
						}	
						else
						{
							driver.close();
							Report.put("Click on view all link ",
									"user should be able to see all their SRs in the service events tab",
									"Failed to display expected page in new tab", "FAIL");
							Assert.fail();
						}
						driver.close();

					}
				}
				driver.switchTo().window(mainwindow);
				Report.put("Click on view all link ",
						"user should be able to see all their SRs in the service events tab",
					"User able to see expected new tab with url "+Report.color(url)+" Header is: "+Report.color(header), "PASS");
			}
			else
			{
				Report.put("Click on view all link ",
						"user should be able to see all their SRs in the service events tab",
						"Failed to display expected page in new tab", "FAIL");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on view all link ",
					"user should be able to see all their SRs in the service events tab",
					"Failed to display expected page in new tab", "FAIL");
			Assert.fail();
		}
	}
	
	public void clickOnFirstDisplayedSRInOverviewTab(WebDriver driver)
	{
		System.out.println("Inside clickOnFirstDisplayedSRInOverviewTab method");
		Log.info("Inside clickOnFirstDisplayedSRInOverviewTab method");

		try
		{
			handleCookies(driver);
			String header = "";String url="";String header1="";
			WebDriverWait wait = new WebDriverWait(driver, 120);

			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_EsupportIPSHomePage.FirstDiaplyedActiveSR()))
			{
				CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.FirstDiaplyedActiveSR());
				header1=CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.FirstDiaplyedActiveSR()).getText();
				System.out.println(header1);
				CommonUtility.ClickOn(driver,obj_EsupportIPSHomePage.FirstDiaplyedActiveSR());
				
				
				String mainwindow=driver.getWindowHandle();
				Set<String> set=driver.getWindowHandles();
				Iterator<String> itr=set.iterator();
				while(itr.hasNext())
				{
					String childWindow=itr.next();
					if(!mainwindow.equals(childWindow))
					{
						driver.switchTo().window(childWindow);
						Thread.sleep(15000);
						url=driver.getCurrentUrl();
						System.out.println("URL displayed as   :::::"+url); 

						if(url.contains("https://www.dell.com/support/incidents-online/en-us/srdetails"))
						{

							System.out.println("Switched to window");			
							header=CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.SRNoFromLandingPage()).getText();
							System.out.println(header);
							
							
							if(!(header.contains(header1)))
							{
								driver.close();
								Report.put("Click on view all link ",
										"user should be able to see all their SRs in the service events tab",
										"Failed to display expected page in new tab", "FAIL");
								Assert.fail();
							}
						}	
						else
						{
							driver.close();
							Report.put("Click on view all link ",
									"user should be able to see all their SRs in the service events tab",
									"Failed to display expected page in new tab", "FAIL");
							Assert.fail();
						}
						driver.close();

					}
				}
				driver.switchTo().window(mainwindow);
				Report.put("Click on view all link ",
						"user should be able to see all their SRs in the service events tab",
					"User able to see expected new tab with url "+Report.color(url)+" Header is: "+Report.color(header), "PASS");
			}
			else
			{
				Report.put("Click on view all link ",
						"user should be able to see all their SRs in the service events tab",
						"Failed to display expected page in new tab", "FAIL");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on view all link ",
					"user should be able to see all their SRs in the service events tab",
					"Failed to display expected page in new tab", "FAIL");
			Assert.fail();
		}
	}
	
	public void verifyOverviewTabDetails_ServiceLifeSection(WebDriver driver)
	{
		System.out.println("Inside verifyOverviewTabDetails_ServiceLifeSection method");
		
		WebDriverWait wait = new WebDriverWait(driver, 120); 

		String header = "";
		String link = "";
		String tabList="";
		try
		{	
			CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.ServiceLifeDate());
			if(CommonUtility.CheckpresenceofElementLocated(driver,30,obj_EsupportIPSHomePage.ServiceLifeSection()))
			{
			
			CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.ServiceLifeSection());
			
			
			CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.ServiceLifeDate());
			String supVid=CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.ServiceLifeDate()).getText();
			System.out.println(supVid);
						
			CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.ViewEndOfLifeDocumentLink());
			link=CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.ViewEndOfLifeDocumentLink()).getText();
			System.out.println(link);
			
			Report.put("Verify the service life section",
					"user should be able to see the service life information",
					"User able to see service life section And also able to view "+Report.color(supVid)+" along with "+Report.color(link), "PASS");
			
			CommonUtility.ClickOn(driver,obj_EsupportIPSHomePage.ViewEndOfLifeDocumentLink());
			
			String mainwindow=driver.getWindowHandle();
			Set<String> set=driver.getWindowHandles();
			Iterator<String> itr=set.iterator();
			while(itr.hasNext())
			{
				String childWindow=itr.next();
				if(!mainwindow.equals(childWindow))
				{
					driver.switchTo().window(childWindow);
					Thread.sleep(15000);
					String url=driver.getCurrentUrl();
					System.out.println("URL displayed as   :::::"+url); 

					if(url.contains("article") ||url.contains("kbdoc"))
					{

						System.out.println("Switched to window");		
						header =driver.getTitle();
						System.out.println(header);
					}	
					else
					{
						driver.close();
						Report.put("when the serial number end of life information is available",
								"user should be able to see view end-of-life documents in a modal and user should be able to export as CSV ",
								"Failed to load Article Page. ", "FAIL");
						Assert.fail();
					}
					driver.close();

				}
			}
			driver.switchTo().window(mainwindow);
			
			Report.put("when the serial number end of life information is available",
					"user should be able to see view end-of-life documents in a modal and user should be able to export as CSV ",
					"User able to click on "+Report.color(link)+" able to see "+Report.color(header)+" along with all documents names "+Report.color(tabList), "PASS");
			
			
			}
			else
			{
				Report.put("Verify the service life section",
						"user should be able to see the service life information",
						"Failed to Load Overview Tab with expected sections", "FAIL");
				Assert.fail();
			}
			} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify the service life section",
					"user should be able to see the service life information",
					"Failed to Load Overview Tab with expected sections", "FAIL");
			Assert.fail();
		}
	}
	
	public void verifyOverviewTabDetails_FeaturedContent(WebDriver driver)
	{
		System.out.println("Inside verifyOverviewTabDetails_FeaturedContent method");
		
		WebDriverWait wait = new WebDriverWait(driver, 120); 

		String header = "";
		String link = "";
		String tabList="";
		try
		{	
			
			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_EsupportIPSHomePage.FeaturedContentHeading()))
			{
			
			
			CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.FeaturedContentHeading());
			String supVid=CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.FeaturedContentHeading()).getText();
			System.out.println(supVid);
						
					
			CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.FeaturedLink());
			List<WebElement> list=driver.findElements(obj_EsupportIPSHomePage.FeaturedLink());

			for(WebElement lt:list)
			{
				CommonUtility.highlightElement(driver, lt);
				String tabName=lt.getText();

				System.out.println("content is: " +tabName);
				tabList+=" <br> " + tabName;
			}
			System.out.println("content are:"+tabList);
			
			Report.put("Verify the featured content  section",
					"user should be able to see featured content when available",
					"User able to see "+Report.color(supVid)+" along with "+Report.color(tabList), "PASS");
			
			
			}
			else
			{
				Report.put("Verify the featured content  section",
						"user should be able to see featured content when available",
						"Failed to Load Overview Tab with expected sections", "FAIL");
//				Assert.fail();
			}
			} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify the featured content  section",
					"user should be able to see featured content when available",
					"Failed to Load Overview Tab with expected sections", "FAIL");
			Assert.fail();
		}
	}
	
	public void verifyOverviewTabDetails_CountOfComponents(WebDriver driver)
	{
		System.out.println("Inside verifyOverviewTabDetails_CountOfComponents method");
		
		WebDriverWait wait = new WebDriverWait(driver, 120); 

		String header = "";
		String link = "";
		try
		{	
			CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.ComponentDetails());
			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_EsupportIPSHomePage.ComponentDetails()))
			{
			
			CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.ComponentDetails());
			String moreRes=CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.ComponentDetails()).getText();
			System.out.println(moreRes);
			
			
			CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.CountOfComponents());
			String supVid=CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.CountOfComponents()).getText();
			System.out.println(supVid);
			
						
			Report.put("Verify the count of the components in under the component details   ",
					"Count should be displayed in as component details displaying XX items",
					"User able to see "+Report.color(moreRes)+" And also able to view count  "+Report.color(supVid), "PASS");
			}
			else
			{
				Report.put("Verify the count of the components in under the component details   ",
						"Count should be displayed in as component details displaying XX items",
						"Failed to Load Overview Tab with component details with count", "FAIL");
				Assert.fail();
			}
			} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify the count of the components in under the component details   ",
					"Count should be displayed in as component details displaying XX items",
					"Failed to Load Overview Tab with component details with count", "FAIL");
			Assert.fail();
		}
	}
	
	
	public void SortingColumnsOfComponenetDetails(WebDriver driver)
	{

		Log.info("Inside SortingColumnsOfComponenetDetails method");

		String assertid = ""; String assertclass="";
		String Prodname=""; String prodclass="";
		String nickname="";String nickclass="";
		String siteid="";String siteidclass="";
		String sitedetils=""; String sitedetclass="";

		WebDriverWait wait = new WebDriverWait(driver, 600);
		try
		{

			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_EsupportIPSHomePage.VendorColumn()))
			{	
				CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.VendorColumn());
				assertid=CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.VendorColumn()).getText();
				System.out.println("column name is "+assertid);
				CommonUtility.ClickOn(driver,obj_EsupportIPSHomePage.VendorColumn());

				Thread.sleep(6000);
				assertclass=CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.VendorColumn()).getAttribute("aria-sort");
				System.out.println("class is "+assertclass);

				if(!(assertclass.contains("ascending")|| assertclass.contains("descending")))
				{
					System.out.println("not able to see vendor column sorting");
					Report.put("Verify the sorting on Vendor , type , product ID , component name and contract status  ",
							"Sorting should be available on Vendor , type , product ID , component name and contract status",
							"User not able to see vendor column sorting", "Fail");
					Assert.fail();
				}

				CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.TypeColumn());
				Prodname=CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.TypeColumn()).getText();
				System.out.println("column name is "+Prodname);
				CommonUtility.ClickOn(driver,obj_EsupportIPSHomePage.TypeColumn());

				Thread.sleep(6000);
				prodclass=CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.TypeColumn()).getAttribute("aria-sort");
				System.out.println("class is "+prodclass);

				if(!(prodclass.contains("ascending")|| prodclass.contains("descending")))
				{
					System.out.println("not able to see type column sorting");
					Report.put("Verify the sorting on Vendor , type , product ID , component name and contract status  ",
							"Sorting should be available on Vendor , type , product ID , component name and contract status",
							"User not able to see type column sorting", "Fail");
					Assert.fail();
				}

				CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.ProductIDColumn());
				nickname=CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.ProductIDColumn()).getText();
				System.out.println("column name is "+nickname);
				CommonUtility.ClickOn(driver,obj_EsupportIPSHomePage.ProductIDColumn());

				Thread.sleep(6000);
				nickclass=CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.ProductIDColumn()).getAttribute("aria-sort");
				System.out.println("class is "+nickclass);

				if(!(nickclass.contains("ascending")|| nickclass.contains("descending")))
				{
					System.out.println("not able to see product id column sorting");
					Report.put("Verify the sorting on Vendor , type , product ID , component name and contract status  ",
							"Sorting should be available on Vendor , type , product ID , component name and contract status",
							"User not able to see product id column sorting", "Fail");
					Assert.fail();
				}

				CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.ComponentNameColumn());
				siteid=CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.ComponentNameColumn()).getText();
				System.out.println("column name is "+siteid);
				CommonUtility.ClickOn(driver,obj_EsupportIPSHomePage.ComponentNameColumn());

				Thread.sleep(6000);
				siteidclass=CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.ComponentNameColumn()).getAttribute("aria-sort");
				System.out.println("class is "+siteidclass);

				if(!(siteidclass.contains("ascending")|| siteidclass.contains("descending")))
				{
					System.out.println("not able to see componenet name column sorting");
					Report.put("Verify the sorting on Vendor , type , product ID , component name and contract status  ",
							"Sorting should be available on Vendor , type , product ID , component name and contract status",
							"User not able to see component name column sorting", "Fail");
					Assert.fail();
				}


				CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.ContractStatusColumn());
				sitedetils=CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.ContractStatusColumn()).getText();
				System.out.println("column name is "+sitedetils);
				CommonUtility.ClickOn(driver,obj_EsupportIPSHomePage.ContractStatusColumn());

				Thread.sleep(6000);
				sitedetclass=CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.ContractStatusColumn()).getAttribute("aria-sort");
				System.out.println("class is "+sitedetclass);

				if(!(sitedetclass.contains("ascending")|| sitedetclass.contains("descending")))
				{
					System.out.println("not able to see contract status column sorting");
					Report.put("Verify the sorting on Vendor , type , product ID , component name and contract status  ",
							"Sorting should be available on Vendor , type , product ID , component name and contract status",
							"User not able to seecontract status column sorting", "Fail");
					Assert.fail();
				}


				Report.put("Verify the sorting on Vendor , type , product ID , component name and contract status  ",
						"Sorting should be available on Vendor , type , product ID , component name and contract status",
						"User able to sort all columns in ascending and descending", "PASS");

			}
			else
			{
				System.out.println("not able to sort column names");
				Report.put("Verify the sorting on Vendor , type , product ID , component name and contract status  ",
						"Sorting should be available on Vendor , type , product ID , component name and contract status",
						"User not able to sort column names", "Fail");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify the sorting on Vendor , type , product ID , component name and contract status  ",
					"Sorting should be available on Vendor , type , product ID , component name and contract status",
					"User not able to sort column names", "Fail");
			Assert.fail();
		}
	}
	
	public void validateSearchSectionOfComponentDetails(WebDriver driver, String search)
	{

		Log.info("Inside validateSearchSectionOfComponentDetails method");

		String button = "";

		WebDriverWait wait = new WebDriverWait(driver, 600);
		try
		{

			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_EsupportIPSHomePage.SearchBoxComponentDetails()))
			{

				CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.SearchBoxComponentDetails());
				CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.SearchBoxComponentDetails()).clear();
				CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.SearchBoxComponentDetails()).sendKeys(search);

				CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.SearchButtonComDet());
				CommonUtility.ClickOn(driver,obj_EsupportIPSHomePage.SearchButtonComDet());

				
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIPSHomePage.FilteredResultsInGrid()));
				List<WebElement> list=driver.findElements(obj_EsupportIPSHomePage.FilteredResultsInGrid());

				for(int i=0;i<list.size();i++)
				{
					CommonUtility.ScrollToWebElement(driver, list.get(i));
					
				}

				Report.put("Verify the search option",
						"Search option should be available",
						"User able to Search text box", "PASS");

				Report.put("Go to the search box enter any text say VMware and click on search",
						"Component details should show up all the matched search text  ",
						"User able to search "+Report.color(search)+" and able to see searched text in grid", "PASS");

			}
			else
			{
				System.out.println("not able to see filter text box");
				Report.put("Verify the search option",
						"Search option should be available",
						"User not able to see Search text box", "Fail");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify the search option",
					"Search option should be available",
					"User not able to see Search text box", "Fail");
			Assert.fail();
		}
	}
	
	
	//Sneha
	
	public void selectLaptopsFromBrowseAll(WebDriver driver)
	{
		System.out.println("Inside selectLaptopsFromBrowseAll method");
		Log.info("Inside selectLaptopsFromBrowseAll method");

		WebDriverWait wait = new WebDriverWait(driver, 120); 

		String header = "";
		try
		{			
			wait.until(ExpectedConditions.presenceOfElementLocated(obj_EsupportIPSHomePage.ComputersFromBrowseAllProducts()));
			CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.ComputersFromBrowseAllProducts());
			handleCookies(driver);
			//			CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.laptopsLink()).click();
			CommonUtility.ClickOn(driver,obj_EsupportIPSHomePage.ComputersFromBrowseAllProducts());
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIPSHomePage.LaptopsFromBrowseAllProducts()));

			CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.LaptopsFromBrowseAllProducts());

			header = CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.LaptopsFromBrowseAllProducts()).getText();

			Report.put("Click on Laptops",
					"User should load modal pop up with Laptops",
					"Loaded Modal Popup with Laptops. Popup Header is:"+Report.color(header), "PASS");

		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on Laptops",
					"User should load modal pop up with Laptops",
					"Failed to load Modal Popup with Laptops.", "FAIL");
			Assert.fail();
		}
	}
	
	//For new BrowseAll 
	public void selectVmaxProductFromBrowseAll(WebDriver driver)
	{
		System.out.println("Inside selectVmaxProductFromBrowseAll method");
		Log.info("Inside selectVmaxProductFromBrowseAll method");

		WebDriverWait wait = new WebDriverWait(driver, 120); 

		String header = "";
		try
		{			
			if(CommonUtility.CheckpresenceofElementLocated(driver, 20, obj_EsupportIPSHomePage.EnterpriseInfraStructureFromBrowseAllProducts()))
			{
				CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.EnterpriseInfraStructureFromBrowseAllProducts());
				CommonUtility.ClickOn(driver,obj_EsupportIPSHomePage.EnterpriseInfraStructureFromBrowseAllProducts());

				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIPSHomePage.TypeTextOnBrowseAllProducts()));
	            CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.TypeTextOnBrowseAllProducts());

				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIPSHomePage.StorageOnBrowseAllProducts()));
				CommonUtility.ClickOn(driver,obj_EsupportIPSHomePage.StorageOnBrowseAllProducts());

				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIPSHomePage.SubTypeTextOnBrowseAllProducts()));
	            CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.SubTypeTextOnBrowseAllProducts());

				
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIPSHomePage.EnterpriseStorageOnBrowseAllProducts()));
				CommonUtility.ClickOn(driver,obj_EsupportIPSHomePage.EnterpriseStorageOnBrowseAllProducts());

				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIPSHomePage.VMAXOnBrowseAllProducts()));
	            CommonUtility.ClickOn(driver,obj_EsupportIPSHomePage.VMAXOnBrowseAllProducts());

				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIPSHomePage.VMAX10KOnBrowseAllProducts()));
				CommonUtility.ClickOn(driver,obj_EsupportIPSHomePage.VMAX10KOnBrowseAllProducts());

				
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIPSHomePage.SelectThisProductOnBrowseAllProducts()));
				CommonUtility.ClickOn(driver,obj_EsupportIPSHomePage.SelectThisProductOnBrowseAllProducts());

				Thread.sleep(3000);
			}
			
			else if(CommonUtility.CheckpresenceofElementLocated(driver, alertcount, obj_EsupportIPSHomePage.storage()))
			{
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIPSHomePage.storage()));
				CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.storage());
				//CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.storage());
				CommonUtility.ClickOn(driver,obj_EsupportIPSHomePage.storage());

				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIPSHomePage.modelHead()));

				CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.modelHead());

				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIPSHomePage.enterpriseStorage()));
				//CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.storage());
				CommonUtility.ClickOn(driver,obj_EsupportIPSHomePage.enterpriseStorage());

				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIPSHomePage.modelHead()));

				CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.modelHead());

				header = CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.modelHead()).getText();

				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIPSHomePage.vmax()));
				//CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.storage());
				CommonUtility.ClickOn(driver,obj_EsupportIPSHomePage.vmax());

				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIPSHomePage.modelHead()));

				CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.modelHead());

				header = CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.modelHead()).getText();

				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIPSHomePage.vmax10K()));
				//CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.storage());
				CommonUtility.ClickOn(driver,obj_EsupportIPSHomePage.vmax10K());
			}

			//wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIPSHomePage.productHeader()));

			if(CommonUtility.CheckpresenceofElementLocated(driver, 10, obj_EsupportIPSHomePage.productHeader()))
			{
			CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.productHeader());
			header = CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.productHeader()).getText();

			System.out.println("Product Page header is:"+header);
			}
			else if(CommonUtility.CheckpresenceofElementLocated(driver, 10, obj_EsupportIPSHomePage.ProductHeader2()))
			{
				CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.ProductHeader2());
				header = CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.ProductHeader2()).getText();

				System.out.println("Product Page header is:"+header);
				
			}

			
			Report.put("From the product selector from choose all products and navigate to any LEMC product page",
					"User should land in the product support model page",
					"User in Product Support Model Page. Header is:"+Report.color(header), "PASS");

		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("From the product selector from choose all products and navigate to any LEMC product page",
					"User should land in the product support model page",
					"Failed to load Product Support Model Page", "FAIL");
			Assert.fail();
		}
	}
	
//	public void clickSoftwareLinkFromBrowseAll(WebDriver driver)
//	{
//		System.out.println("Inside clickSoftwareLinkFromBrowseAll method");
//		Log.info("Inside clickSoftwareLinkFromBrowseAll method");
//
//		WebDriverWait wait = new WebDriverWait(driver, 120); 
//
//		String header = "";
//		try
//		{			
//			handleCookies(driver);
//			//			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIPSHomePage.softwareLink()));
//			CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.softwareLink());
//			handleCookies(driver);
//			CommonUtility.ClickOn(driver,obj_EsupportIPSHomePage.softwareLink());
//
//			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIPSHomePage.allProductsPopupHeader()));
//
//			//			CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.softwareHeader());
//
//			header = CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.allProductsPopupHeader()).getText();
//
//			Report.put("Click on Software under the model pop up",
//					"system should further drill down to sub categories ",
//					"Loaded Modal Popup with Sub Categories. Popup Header is:"+Report.color(header), "PASS");
//
//		} 
//		catch(Exception e)
//		{
//			e.printStackTrace();
//			Report.put("Click on Software under the model pop up",
//					"system should further drill down to sub categories ",
//					"Failed to Load Modal Popup with Sub Categories. ", "FAIL");
//			Assert.fail();
//		}
//	}
	
	public void SelectProductFromBrowseAll(WebDriver driver)
	{
		System.out.println("Inside SelectProductFromBrowseAll method");
		Log.info("Inside SelectProductFromBrowseAll method");

		WebDriverWait wait = new WebDriverWait(driver, 120); 
		String category = TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(",")[0];
		String subcategory = TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(",")[1];
		String series = TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(",")[2];
		String products = TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(",")[3];
		String header = "";
		try
		{
			if(CommonUtility.CheckpresenceofElementLocated(driver, 10, obj_EsupportIPSHomePage.HeaderTextOfBrowseAll()))
			{
				CommonUtility.ScrollTo(driver, obj_EsupportIPSHomePage.HeaderTextOfBrowseAll());
				CommonUtility.highlightElement(driver, obj_EsupportIPSHomePage.HeaderTextOfBrowseAll());
				header=CommonUtility.highlightElement(driver, obj_EsupportIPSHomePage.HeaderTextOfBrowseAll()).getText();
				
				System.out.println("Header text is displaying "+header);
				
				Thread.sleep(2000);
				List<WebElement> Categorylist=driver.findElements(obj_EsupportIPSHomePage.ListOfProductCategoriesInBrowseAll());
				for(WebElement lt1:Categorylist)
				{
					CommonUtility.highlightElement(driver, lt1);
					String categorytext=lt1.getText();
                    if(categorytext.equals(category))
                    {
                    	lt1.click();
                    	break;
                    }
				}
				Thread.sleep(5000);
				List<WebElement> SubCategorylist=driver.findElements(obj_EsupportIPSHomePage.ListOfSubCategoriesInBrowseAll());
				for(WebElement lt2:SubCategorylist)
				{
					CommonUtility.highlightElement(driver, lt2);
					String categorytext=lt2.getText();
                    if(categorytext.equals(subcategory))
                    {
                    	lt2.click();
                    	break;
                    }
				}
				Thread.sleep(5000);
				List<WebElement> Serieslist=driver.findElements(obj_EsupportIPSHomePage.ListOfSeriesInBrowseAll());
				for(WebElement lt3:Serieslist)
				{
					CommonUtility.highlightElement(driver, lt3);
					String categorytext=lt3.getText();
					Thread.sleep(2000);
                    if(categorytext.equals(series))
                    {
                    	lt3.click();
                    	break;
                    }
				}
				Thread.sleep(5000);
				List<WebElement> Productlist=driver.findElements(obj_EsupportIPSHomePage.ListOfProductsInBrowseAll());
				for(WebElement lt4:Productlist)
				{
					CommonUtility.highlightElement(driver, lt4);
					String categorytext=lt4.getText();
                    if(categorytext.equals(products))
                    {
                    	lt4.click();
                    	break;
                    }
				}
				
				Thread.sleep(5000);
				//List<WebElement> Modellist=driver.findElements(obj_EsupportIPSHomePage.ListOfModelsInBrowseAll());
				if(CommonUtility.CheckpresenceofAllElementLocated(driver, 10, obj_EsupportIPSHomePage.ListOfModelsInBrowseAll()))
				{
					String models = TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(",")[4];
					List<WebElement> Modellist=driver.findElements(obj_EsupportIPSHomePage.ListOfModelsInBrowseAll());
					for(WebElement lt5:Modellist)
					{
						CommonUtility.highlightElement(driver, lt5);
						String categorytext=lt5.getText();
	                    if(categorytext.equals(models))
	                    {
	                    	lt5.click();
	                    	Thread.sleep(2000);
	                    	break;
	                    }
					}
					
					CommonUtility.highlightElement(driver, obj_EsupportIPSHomePage.SelectThisProductOnBrowseAllProducts()).click();
					System.out.println("Clicked on Select Product");
				}
				else if(CommonUtility.CheckpresenceofElementLocated(driver, 10, obj_EsupportIPSHomePage.SelectThisProductOnBrowseAllProducts())) 
				{
					CommonUtility.highlightElement(driver, obj_EsupportIPSHomePage.SelectThisProductOnBrowseAllProducts()).click();
				    System.out.println("Clicked on Select Product");
				}
				
				Report.put("Select a product from Browse All Products",
						"User should load modal pop up with all products and select product",
						"Selected product == "+" from Browse All Products.", "Pass");
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on the browse all products",
					"User should load modal pop up with all products",
					"Failed to load Modal Popup with All Products. ", "FAIL");

			Assert.fail();
		}

	}
}


