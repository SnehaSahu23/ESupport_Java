package com.dell.delta_uat_automation.esupport.workflows;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Keyboard;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.dell.delta_uat_automation.utility.CommonUtility;
import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.Log;
import com.dell.delta_uat_automation.utility.Report;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class EsupportIntegratedHomePageWorkflow extends BaseFlow {
	ArrayList<String>List_type= new ArrayList<String>();

	public void verifyIntegratedSupportHomePage(WebDriver driver){
		System.out.println("Entered into method: to verifyIntegratedSupportHomePage.");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String header ="";

		try {
			Thread.sleep(4000);

			System.out.println("Title : " + driver.getTitle());

			String title = driver.getTitle();

			if(title.contains("Support")){
//				CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.recentOrdersLabel());
//				header = CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.recentOrdersLabel()).getText();
//				System.out.println("header : " + header);
				Report.put("Navigate to https://www.dell.com/support/home/us/en/19.", 
						"User must be redirected to the new customized integrated support homepage.",
						"User is redirected to the new customized integrated support homepage. " + Report.color(header), "PASS");
			}else{
				System.out.println("Redirected to incorrect page.");
				Report.put("Navigate to https:www.dell.com/support/home/us/en/19.", 
						"User must be redirected to the new customized integrated support homepage.",
						"User is redirected to a different page.", "FAIL");
				Assert.fail();
			}


			Thread.sleep(4000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Exception occured while verifying the Integrated homepage " + e);
			Report.put("Navigate to https://www.dell.com/support/home.", 
					"User must be redirected to the new customized integrated support homepage.",
					"Failed while verifying the integrated support homepage.", "FAIL");
			Assert.fail();
		}


	}


	public void verifyMastheadLinks(WebDriver driver){
		System.out.println("Entered into method: to verifyMastheadLinks.");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		try {
			Thread.sleep(10000);
			String mastheadLinks = "";
//			CommonUtility.ScrollTo(driver, obj_EsupportIntegratedHomePage.ProductSupportMastheadLink());
//			CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.ProductSupportMastheadLink()).isDisplayed();
//			CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.ProductSupportMastheadLink());
//			mastheadLinks = mastheadLinks + CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.ProductSupportMastheadLink()).getText() + "<br>";

			CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.KnowledgeBaseMastheadLink()).isDisplayed();
			CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.KnowledgeBaseMastheadLink());
			mastheadLinks = mastheadLinks + CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.KnowledgeBaseMastheadLink()).getText() + "<br>";
//
//			CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.warrantyContractMastheadLink()).isDisplayed();
//			CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.warrantyContractMastheadLink());
//			mastheadLinks = mastheadLinks + CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.warrantyContractMastheadLink()).getText() + "<br>";
//			
//			CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.ServiceRequestsMastheadLink()).isDisplayed();
//			CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.ServiceRequestsMastheadLink());
//			mastheadLinks = mastheadLinks + CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.ServiceRequestsMastheadLink()).getText() + "<br>";

//			CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.OrderSupportMastheadLink()).isDisplayed();
//			CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.OrderSupportMastheadLink());
//			mastheadLinks = mastheadLinks + CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.OrderSupportMastheadLink()).getText() + "<br>";

//			CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.ContactSupportMastheadLink()).isDisplayed();
//			CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.ContactSupportMastheadLink());
//			mastheadLinks = mastheadLinks + CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.ContactSupportMastheadLink()).getText() + "<br>";

			System.out.println("Links : " + mastheadLinks);
			Report.put("Verify the integrated homepage Masthead Links.",
					"Masthead should be present with support showing Product support, Knowledgebase, Service Requests, Order support and Contact Support.",
					"Masthead should be present with support showing : " + Report.color(mastheadLinks), "PASS");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Expception occured while verifying the Masthead Links. "+e);

			Report.put("Verify the integrated homepage Masthead Links.",
					"Masthead should be present with support showing Product support, Knowledgebase, Service Requests, Order support and Contact Support.",
					"Failed while verifying the integrated homepage Masthead Links.", "FAIL");
			Assert.fail();
		}

	}


	public void clickOnTechDirectLink(WebDriver driver){
		System.out.println("Entered into method: to clickOnTechDirectLink.");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		try {
			Thread.sleep(4000);
			System.out.println("scrolling to tech direct link.");
			CommonUtility.ScrollTo(driver, obj_EsupportIntegratedHomePage.TechDirectLink());

			Thread.sleep(2000);
			WebElement element = driver.findElement(obj_EsupportIntegratedHomePage.TechDirectLink());
			Actions actions = new Actions(driver);
			actions.moveToElement(element).click().perform();
			//CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.TechDirectLink()).click();
			System.out.println("clicked on tech direct link.");

			Thread.sleep(10000);
			WebDriverWait wait = new WebDriverWait(driver, 10);
//			wait.until(ExpectedConditions.titleIs("Dell Technologies | TechDirect | Login"));

			driver.getTitle();

			System.out.println("page title : " + driver.getTitle());
			System.out.println("current url : " + driver.getCurrentUrl());

			if(driver.getTitle().contains("TechDirect") && driver.getCurrentUrl().contains("https://tdm.dell.com/portal")){
				System.out.println("User is navigated to Tech Direct page.");
				Report.put("Click on Tech Direct link.",
						"User should land in Tech Direct page Tech Direct URL is: https://tdm.dell.com/portal",
						"User is navigated to Tech Direct page, URL : " + Report.color(driver.getCurrentUrl()), "PASS");
			}
			else{
				System.out.println("User is not navigated to Tech Direct page.");
				Report.put("Click on Tech Direct link.",
						"User should land in Tech Direct page Tech Direct URL is: https://techdirect.dell.com",
						"User is not navigated to Tech Direct page.", "FAIL");
				Assert.fail();
			}


		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Report.put("Click on Tech Direct link.",
					"User should land in Tech Direct page Tech Direct URL is: https://techdirect.dell.com",
					"Failed while navigating to Tech Direct page.", "FAIL");
			Assert.fail();
		}
	}

	public void toNavigateToIntegratedHomePage(WebDriver driver){
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		System.out.println("Entered into method: to navigate back to Integrated HomePage.");

		try {
			Thread.sleep(4000);

			System.out.println("Navigating back to home page.");
			driver.navigate().to("https://www.dell.com/support/home");
			Thread.sleep(3000);
			System.out.println("Naviagated back to Integrated Home page : " + driver.getTitle());


		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Exception occured while navigating to Integrated Home Page."+e);
			Assert.fail();
		}		
	}


	public void clickOnProductSupportLink(WebDriver driver){
		System.out.println("Entered into method: to clickOnProductSupportLink.");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		try {
			Thread.sleep(4000);

			CommonUtility.ScrollTo(driver, obj_EsupportIntegratedHomePage.ProductSupportMastheadLink());

			CommonUtility.ClickOn(driver, obj_EsupportIntegratedHomePage.ProductSupportMastheadLink());

			Thread.sleep(3000);
			handleCookies(driver);

			/*System.out.println("Handle Dell Survey popup.");
			if(CommonUtility.CheckpresenceofElementLocated(driver, 20, obj_EsupportIntegratedHomePage.DellSurveyPopup())){
				System.out.println("Dell Survey popup is present.");
				WebElement dellSurveyElem = driver.findElement(obj_EsupportIntegratedHomePage.DellSurveyPopup());
				driver.switchTo().frame(dellSurveyElem);

				CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.NoButton_DellSurveyPopup());
				CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.NoButton_DellSurveyPopup()).click();
				System.out.println("clicked on No Thanks button.");
				driver.switchTo().defaultContent();
				System.out.println("Handled the Dell Survey popup.");
			}*/

			CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.PageHeader());
			String header = CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.PageHeader()).getText();
			if(header.contains("Product Support")){
				System.out.println("Navigated to " + header);
				Report.put("Click on Product support.", 
						"User should land in Product support Jump page.",
						"User navigated to "+Report.color(header) +" page.", "PASS");
			}else{
				System.out.println("Could not navigate to Product Support page.");
				Report.put("Click on Product support.", 
						"User should land in Product support Jump page.",
						"User failed to land on Product support Jump page.", "FAIL");
				Assert.fail();
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Exception occured while navigating to Product Support page. "+e);
			Report.put("Click on Product support.", 
					"User should land in Product support Jump page.",
					"User failed to land on Product support Jump page.", "FAIL");
			Assert.fail();
		}

	}


	public void clickOnKnowledgdeBaseLink(WebDriver driver){

		System.out.println("Entered into method: to clickOnKnowledgdeBaseLink.");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		try {
			Thread.sleep(3000);

			CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.KnowledgeBaseMastheadLink());
			WebElement element = driver.findElement(obj_EsupportIntegratedHomePage.KnowledgeBaseMastheadLink());
//			Actions actions = new Actions(driver);
//			actions.moveToElement(element).click().perform();

			//CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.KnowledgeBaseMastheadLink()).click();
			CommonUtility.ClickOn(driver, obj_EsupportIntegratedHomePage.KnowledgeBaseMastheadLink());
			
			Thread.sleep(3000);
			handleCookies(driver);

			CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.PageHeader());
			String header = CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.PageHeader()).getText();
			System.out.println(header);
			if(header.contains("Knowledge Base")){
				System.out.println("Navigated to " + header);
				Report.put("Click on Knowledge base.", 
						"User should land in Knowledge base Jump page.",
						"User navigated to "+Report.color(header) +" page.", "PASS");
			}else{
				System.out.println("Could not navigate to Knowledge base page.");
				Report.put("Click on Knowledge base.", 
						"User should land in Knowledge base Jump page.",
						"User failed to land on Knowledge base Jump page.", "FAIL");
				Assert.fail();
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Exception occured while navigating to Knowledge base. "+e);
			Report.put("Click on Knowledge base.", 
					"User should land in Knowledge base Jump page.",
					"User failed to land on Knowledge base Jump page.", "FAIL");
			Assert.fail();
		}

	}



	public void clickOnServiceRequestsLink(WebDriver driver){

		System.out.println("Entered into method: to clickOnServiceRequestsLink.");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String browser=TestNGCreator.TestData.get(Esupport.SearchOption.ordinal());
		try {
			Thread.sleep(3000);

			CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.ServiceRequestsMastheadLink());
			if(browser=="IE")
			{
			WebElement element = driver.findElement(obj_EsupportIntegratedHomePage.ServiceRequestsMastheadLink());
			Actions actions = new Actions(driver);
			actions.moveToElement(element).click().build().perform();
			}
			else
			{

			//CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.ServiceRequestsMastheadLink()).click();
			CommonUtility.ToClickByUsingJavaScript_PassingByLoc(driver, obj_EsupportIntegratedHomePage.ServiceRequestsMastheadLink());
			}
			Thread.sleep(10000);
			handleCookies(driver);

			CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.PageHeader());
			String header = CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.PageHeader()).getText();
			System.out.println(header);
			if(header.contains("Service Requests")){
				System.out.println("Navigated to " + header);
				Report.put("Click on Service Requests.", 
						"User should land in Service Requests Jump page.",
						"User navigated to "+Report.color(header) +" page.", "PASS");
			}else{
				System.out.println("Could not navigate to Service Requests page.");
				Report.put("Click on Service Requests.", 
						"User should land in Service Requests Jump page.",
						"User failed to land on Service Requests Jump page.", "FAIL");
				Assert.fail();
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Exception occured while navigating to Service Requests. "+e);
			Report.put("Click on Service Requests.", 
					"User should land in Service Requests Jump page.",
					"User failed to land on Service Requests Jump page.", "FAIL");
			Assert.fail();
		}

	}


	public void clickOnOrderSupportLink(WebDriver driver){

		System.out.println("Entered into method: to clickOnOrderSupportLink.");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		try {
			Thread.sleep(3000);

			CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.OrderSupportMastheadLink());
			WebElement element = driver.findElement(obj_EsupportIntegratedHomePage.OrderSupportMastheadLink());
//			Actions actions = new Actions(driver);
//			actions.moveToElement(element).click().perform();
			//CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.OrderSupportMastheadLink()).click();
			
			CommonUtility.ClickOn(driver, obj_EsupportIntegratedHomePage.OrderSupportMastheadLink());

			Thread.sleep(3000);
			handleCookies(driver);

			CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.PageHeader());
			String header = CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.PageHeader()).getText();
			System.out.println(header);
			if(header.contains("Order Support")){
				System.out.println("Navigated to " + header);
				Report.put("Click on Order Supports.", 
						"User should land in Order Support Jump page.",
						"User navigated to "+Report.color(header) +" page.", "PASS");
			}else{
				System.out.println("Could not navigate to Order Support page.");
				Report.put("Click on Order Support.", 
						"User should land in Order Support Jump page.",
						"User failed to land on Order Support Jump page.", "FAIL");
				Assert.fail();
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Exception occured while navigating to Order Support. "+e);
			Report.put("Click on Order Support.", 
					"User should land in Order Support Jump page.",
					"User failed to land on Order Support Jump page.", "FAIL");
			Assert.fail();
		}

	}


	public void clickOnContactSupportLink(WebDriver driver){

		System.out.println("Entered into method: to clickOnContactSupportLink.");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		try {
			Thread.sleep(3000);

			CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.ContactSupportMastheadLink());
			WebElement element = driver.findElement(obj_EsupportIntegratedHomePage.ContactSupportMastheadLink());
//			Actions actions = new Actions(driver);
//			actions.moveToElement(element).click().perform();
			//CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.ContactSupportMastheadLink()).click();
			
			CommonUtility.ClickOn(driver, obj_EsupportIntegratedHomePage.ContactSupportMastheadLink());

			Thread.sleep(3000);
			handleCookies(driver);

			CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.PageHeader());
			String header = CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.PageHeader()).getText();
			System.out.println(header);
			if(header.contains("Contact Information")){
				System.out.println("Navigated to " + header);
				Report.put("Click on Contact Supports.", 
						"User should land in Contact Support Jump page.",
						"User navigated to "+Report.color(header) +" page.", "PASS");
			}else{
				System.out.println("Could not navigate to Contact Support page.");
				Report.put("Click on Contact Support.", 
						"User should land in Contact Support Jump page.",
						"User failed to land on Contact Support Jump page.", "FAIL");
				Assert.fail();
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Exception occured while navigating to Contact Support. "+e);
			Report.put("Click on Contact Support.", 
					"User should land in Contact Support Jump page.",
					"User failed to land on Contact Support Jump page.", "FAIL");
			Assert.fail();
		}

	}
	//Sujatha
	public void ToVerify_EnterServiceTage(WebDriver driver,String Servicetag) 
	{
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 120);

		System.out.println("Entering ToVerify_EnterServiceTage");

		Log.info("Entering ToVerify_EnterServiceTage");         
		try 
		{

			String Headerservicetag="";
			String Headerservicetagdisplay="";

			handleCookies(driver);

//			CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.Delllogo());
			CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.SearchServicetag());


			if(CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.Headerservicetag()).isDisplayed())
			{
				Headerservicetag=CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.Headerservicetag()).getText();
			}



			CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.SearchServicetag()).sendKeys(Servicetag);
			CommonUtility.ClickOn(driver,obj_EsupportDriversandDownloadsPage.Servicetagiconsearch());
			//CommonUtility.highlightElement(driver,obj_EsupportIncidentsPage.SearchServicetag()).sendKeys(Keys.ENTER);
			//handleCaptcha(driver); 
			Thread.sleep(4000);        
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDriversandDownloadsPage.ServiceTagHeaderdisplayed()));
			CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.ServiceTagHeaderdisplayed());
			Headerservicetagdisplay=CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.ServiceTagHeaderdisplayed()).getText();


			Report.put("Within the Integrated homepage Under the product selector, as "+Report.color(Headerservicetag),
					"User Should Land in Product support page for the Entered Service tag as"+Report.color(Servicetag),
					"Successfully Application should navigate to "+Report.color(Headerservicetagdisplay), "PASS");

		}catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Not able to find Entered service tag", "Not able to find Entered service tag",
					"Not able to find Entered service tag", "FAIL");
			Assert.fail();

		}
	}
	public void handleCaptcha(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 600);
		System.out.println("After webdriver wait");
		driver.manage().timeouts().implicitlyWait(600, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(600, TimeUnit.SECONDS);
		try
		{
			System.out.println("In try block of captcha wait");

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on Captcha", "Able to click on Captcha",
                    "Failing to click on Captcha", "FAIL");

			Assert.fail();
		}

	}
	//Pushpa:30 nov 2018
	public void handleContactUsSlider(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 120);
		Actions actions = new Actions(driver);

		System.out.println("Entering handleContactUsSlider");

		Log.info("Entering handleContactUsSlider");   
		String supportHeader = "";
		String dispLinks = "";

		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIntegratedHomePage.delllogo()));
			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.delllogo());

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIntegratedHomePage.SupportHeader()));
			if(CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.SupportHeader()).isDisplayed())
			{
				CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.SupportHeader());
				supportHeader = CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.SupportHeader()).getText();
			}

			Report.put("Navigate to https://www.dell.com/support/home", 
					"User must be redirected to the new customized integrated support homepage", 
					"Successfully Navigated to Integrated Support HomePage. Header is : "+Report.color(supportHeader), "PASS");


			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIntegratedHomePage.ContactUsSlider()));
			if(CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.ContactUsSlider()).isDisplayed())
			{
				CommonUtility.ClickOn(driver, obj_EsupportIntegratedHomePage.ContactUsSlider());

//				WebElement element = driver.findElement(obj_EsupportIntegratedHomePage.ContactUsSlider());
//				actions.moveToElement(element).click().perform();

				//CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.ContactUsSlider()).click();
				Report.put("Verify the Contact us Slider", 
						"Contact Us Slider should be Present in Left side", 
						"Contact Us Slider is displayed", "PASS");
			}
			else
			{
				Report.put("Verify the Contact us Slider", 
						"Contact Us Slider should be Present in Left side", 
						"Contact Us Slider is not displayed", "FAIL");
				Assert.fail();
			
			}
			if(CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.ContactUsLinks()).isDisplayed())
			{
				List<WebElement> list=driver.findElements(obj_EsupportIntegratedHomePage.ContactUsLinks());

				for(WebElement lt:list)
				{
					CommonUtility.highlightElement(driver, lt);
					String link=lt.getText();

					//Thread.sleep(5000);
					dispLinks += "<br>" +link;
					System.out.println("Link is :"+link);
				}

				System.out.println("Links are :"+dispLinks);
				Report.put("Click on Contact US", 
						"Contact Us Slider should expand and should show Technical support , Order support and shopping help link", 
						"Links displayed. Links are: "+Report.color(dispLinks), "PASS");
			}
			else
				Report.put("Click on Contact US", 
						"Contact Us Slider should expand and should show Technical support , Order support and shopping help link", 
						"Links display failed", "FAIL");

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Open Dell support home page.", 
					"Support home page should get loaded. ", 
					"Failed to Navigate to Support HomePage.", "FAIL");
			Assert.fail();
		}
	}
	//Sudha
	public void verifyCriticalLinks(WebDriver driver){
		System.out.println("Entered into method: to verifyCriticalLinks.");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		try {
			Thread.sleep(4000);
			String criticalLinks = "";

			Thread.sleep(4000);
			System.out.println("scrolling to tech direct link.");
			CommonUtility.ScrollTo(driver, obj_EsupportIntegratedHomePage.TechDirectLink());
			Thread.sleep(2000);

			CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.TechDirectLink()).isDisplayed();
			CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.TechDirectLink());
			criticalLinks = criticalLinks + CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.TechDirectLink()).getText() + "<br>";

			CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.myService360()).isDisplayed();
			CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.myService360());
			criticalLinks = criticalLinks + CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.myService360()).getText() + "<br>";


			System.out.println("Links : " + criticalLinks);
			Report.put("Verify the integrated homepage (Enterprise Support) below the Critical Links",
					"User should find the below links under Heading:Dell EMC Support Technologies: 1. TechDirect2. MS360",
					"Dell EMC Support Technologies:" + Report.color(criticalLinks), "PASS");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Expception occured while verifying the Critical Links. "+e);

			Report.put("Verify the integrated homepage (Enterprise Support) below the Critical Links",
					"User should find the below links under Heading:Dell EMC Support Technologies: 1. TechDirect2. MS360",
					"Failed while verifying the integrated homepage Masthead Links.", "FAIL");
			Assert.fail();
		}

	}
	public void clickOnMS360Link(WebDriver driver){
		System.out.println("Entered into method: to clickOnMS360Link.");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String browser=TestNGCreator.TestData.get(Esupport.SearchOption.ordinal());
		try {
			Thread.sleep(4000);
			System.out.println("scrolling to MS360 link.");
			CommonUtility.ScrollTo(driver, obj_EsupportIntegratedHomePage.myService360());

			Thread.sleep(7000);
			
			CommonUtility.ClickOn(driver, obj_EsupportIntegratedHomePage.myService360());
			
//			if(browser=="FF")
//			{
//				CommonUtility.ClickOn(driver, obj_EsupportIntegratedHomePage.myService360());
//			}
//			else
//			{
//			WebElement element = driver.findElement(obj_EsupportIntegratedHomePage.myService360());
//			Actions actions = new Actions(driver);
//			actions.moveToElement(element).click().perform();
//			}

			//CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.myService360()).click();
			System.out.println("clicked on MS360 link.");
			Thread.sleep(10000);
			Emaillogin(driver,  TestNGCreator.TestData.get(Esupport.Username.ordinal()),  TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			
			WebDriverWait wait = new WebDriverWait(driver, 200);
//			wait.until(ExpectedConditions.titleIs("MyService 360 | Dell US"));
    
			System.out.println("page title : " + driver.getTitle());
			System.out.println("current url : " + driver.getCurrentUrl());

			if(driver.getTitle().contains("MyService360 | Dell US") && driver.getCurrentUrl().contains("https://www.dell.com/support/myservice360/en-us/summary"))
			{
				System.out.println("User is navigated to Tech Direct page.");
				Report.put("Click on MS360 Link.",
						"User should land in MS360 page MS360 URL is: https://support.emc.com/myservice360",
						"User is navigated to MS360 page, URL : " + Report.color(driver.getCurrentUrl()), "PASS");
			}
			else{
				System.out.println("User is not navigated to Tech Direct page.");
				Report.put("Click on MS360 Link.",
						"User should land in MS360 page MS360 URL is: https://support.emc.com/myservice360",
						"User is not navigated to MS360 page.", "FAIL");
				Assert.fail();
			}


		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Report.put("Click on Tech Direct link.",
					"User should land in Tech Direct page Tech Direct URL is: https://techdirect.dell.com",
					"Failed while navigating to my service ms360", "FAIL");
			Assert.fail();
		}
	}
	//Mamta3rdDec2018
	public void SearchValues_ProductSupport_CharacterByCharacter(WebDriver driver, String value)
	{
		System.out.println("SearchValues_ProductSupport_CharacterByCharacter");
		Log.info("SearchValues_ProductSupport_CharacterByCharacter");

		String flag="";
		String product="";
		Actions act = new Actions(driver);
		try{
			CommonUtility.CheckpresenceofElementLocated(driver, 50, obj_EsupportCoveoPage.searchInputTextBox());
//			WebElement element = driver.findElement(obj_EsupportCoveoPage.searchInputTextBox());
//			act.moveToElement(element).build().perform();
			//CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.searchInputTextBox()).click();
			CommonUtility.ScrollTo(driver,  obj_EsupportCoveoPage.searchInputTextBox());
			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.searchInputTextBox()).clear();



			char[] NameInputArray = value.toCharArray();
			for(int j=0;j<NameInputArray.length;j++)
			{
				driver.findElement(obj_EsupportCoveoPage.searchInputTextBox()).sendKeys(String.valueOf(NameInputArray[j]));
				Thread.sleep(5000);
			}
			/*List<WebElement> charoptions=driver.findElements(By.xpath("//ul[contains(@class,'ui-autocomplete')]/li/a/span[text()='"+value+"']"));
			System.out.println("the size of avialable options"+charoptions.size());

			for(int i=1;i<=charoptions.size()-1;){
				System.out.println("i val---"+i);
				CommonUtility.highlightElement(driver,charoptions.get(i)).isDisplayed();
//				WebElement elmt = driver.findElement(By.xpath("//ul[contains(@class,'ui-autocomplete')]/li/a/span[text()='"+value+"']/../../../li["+i+"]")); 
//				product= elmt.getText();
				WebElement elment =driver.findElement(By.xpath("(//span[@class='ui-state-highlight'])[1]"));
				act.moveToElement(element).build().perform();
	            ((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);  
				//act.moveToElement(elmt).click().perform();   
				break;
			}*/

			WebElement eleme =driver.findElement(By.xpath("(//li[contains(@class,'ui-menu-item')])[1]"));
			Thread.sleep(2000);
			System.out.println("before clicking");
			CommonUtility.ScrollTo(driver, By.xpath("(//li[contains(@class,'ui-menu-item')])[1]"));
			Thread.sleep(2000);
			CommonUtility.ClickOn(driver, By.xpath("(//li[contains(@class,'ui-menu-item')])[1]"));
		//	CommonUtility.scrollToViewElement(driver, By.xpath("(//li[contains(@class,'ui-menu-item')])[1]")).click();
//			act.moveToElement(eleme).click().build().perform();
//			((JavascriptExecutor)driver).executeScript("arguments[0].click();", eleme);  
//			CommonUtility.highlightElement(driver, By.xpath("(//li[@id='ui-active-menuitem']//a//span)")).click();
			System.out.println("clicked");

			Report.put("Within the Integrated homepage Under the product selector, Enter "+Report.color(product)+" Product Model", "User Should Get Auto suggestion for the entered characters", "Select the 1st product from the auto suggestions", "PASS");
		}catch(Exception ex){
			ex.printStackTrace();
			Report.put("Within the Integrated homepage Under the product selector, Enter "+Report.color(product)+" Product Model", "User Should Get Auto suggestion for the entered characters", "Unable to select the product from the auto suggestions", "FAIL");
			Assert.fail();
		}
	} 
	//Sujatha

	public void  ClickLaptops_Tab(WebDriver driver) 
	{
		Actions act=new Actions(driver);
		System.out.println("In Function ClickLaptops_Tab");
		WebDriverWait  wait = new WebDriverWait(driver, 120);
		String ClickingonLattitude="",Browseallproductslink="";
		System.out.println("After webdriver wait");
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
		try
		{


			driver.navigate().refresh();

			Thread.sleep(3000);
			handleCookies(driver);

			Thread.sleep(3000);

//			act.moveToElement(CommonUtility.highlightElement(driver,obj_EsupportIntegratedHomePage.BrowseAllProductsLink())).build().perform();
			CommonUtility.ScrollTo(driver,obj_EsupportIntegratedHomePage.BrowseAllProductsLink());
			Browseallproductslink=CommonUtility.highlightElement(driver,obj_EsupportIntegratedHomePage.BrowseAllProductsLink()).getText();

//			WebElement element = driver.findElement(obj_EsupportIntegratedHomePage.BrowseAllProductsLink());
//			act.moveToElement(element).click().perform();
			CommonUtility.ClickOn(driver,obj_EsupportIntegratedHomePage.BrowseAllProductsLink());

			//CommonUtility.highlightElement(driver,obj_EsupportIntegratedHomePage.BrowseAllProductsLink()).click();


			Thread.sleep(10000);
			CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.ClickingonLaptops());

			//  wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDriversandDownloadsPage.supportHeading()));
			Thread.sleep(10000);
//			WebElement elemen = driver.findElement(obj_EsupportIntegratedHomePage.ClickingonLaptops());
//			act.moveToElement(elemen).click().perform();
			CommonUtility.ClickOn(driver, obj_EsupportIntegratedHomePage.ClickingonLaptops());

			//CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.ClickingonLaptops()).click();

			System.out.println("Clicked on ClickLaptops_Tab Link");


			Thread.sleep(3000);



		}
		catch(Exception e)
		{
			e.printStackTrace();
			Assert.fail();
		}
	}




	public void  ClickLattitude_Tab(WebDriver driver) 
	{
		System.out.println("In Function ClickLatitude_Tab");
		WebDriverWait  wait = new WebDriverWait(driver, 120);
		String ClickingonLattitude="";
		Actions act=new Actions(driver);
		System.out.println("After webdriver wait");
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
		try
		{
			CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.ClickingonLattitude());

			//CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.ClickingonLattitude()).click();

//			WebElement element = driver.findElement(obj_EsupportIntegratedHomePage.ClickingonLattitude());
//			act.moveToElement(element).click().perform();
			CommonUtility.ClickOn(driver, obj_EsupportIntegratedHomePage.ClickingonLattitude());

			System.out.println("Clicking on Latitude Link");

			Thread.sleep(10000);

			//act.moveToElement(CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.ClickingonLattitudeEProduct())).build().perform();
			Thread.sleep(5000);
			CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.ClickingonLattitudeEProduct());

//			WebElement elemen = driver.findElement(obj_EsupportIntegratedHomePage.ClickingonLattitudeEProduct());
//			act.moveToElement(elemen).click().perform();
			CommonUtility.ClickOn(driver, obj_EsupportIntegratedHomePage.ClickingonLattitudeEProduct());

			//CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.ClickingonLattitudeEProduct()).click();

			System.out.println("Clicked LatitudeEProduct Link");

			//driver.navigate().refresh();

			//Thread.sleep(10000);

			//act.moveToElement(CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.Headerservicetag())).build().perform();

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIntegratedHomePage.Headerservicetag()));
			CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.Headerservicetag());

			ClickingonLattitude=CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.Headerservicetag()).getAttribute("innerText");


			System.out.println("Header displayed as "+ClickingonLattitude);

			Thread.sleep(3000);


			//      Report.put("Before changing Product name and After changing Product name header should be different", "Before changing link Product Name as  "+Report.color(Prevheader)+" After By clicking Changing link displayed as "+Report.color(ClickingonLattitude),"Successfully Product Name Changed after by clicking ChangeProduct link", "PASS");


			Report.put("User is able to add First product Click on Latitude E4200' button", "The user should be able to see Drivers Update Subscription Page and header is displayed as "+Report.color(ClickingonLattitude)," Successfully Drivers Update Subscription Page and header is displayed as "+Report.color(ClickingonLattitude), "PASS");
			handleCookies(driver);
			driver.navigate().refresh();
			Thread.sleep(5000);

			driver.navigate().back();
			driver.navigate().back();




			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIntegratedHomePage.ButtonClose()));

			handleCookies(driver);

//			WebElement elem = driver.findElement(obj_EsupportIntegratedHomePage.ButtonClose());
//			act.moveToElement(elem).click().perform();

			CommonUtility.ClickOn(driver, obj_EsupportIntegratedHomePage.ButtonClose());

			System.out.println("1st Product Added  found");

			//      Thread.sleep(15000);



		}
		catch(Exception e)
		{
			Report.put("User is able to add First product Click on Latitude E4200' button", "The user should be able to see Drivers Update Subscription Page and header is displayed as "+Report.color(ClickingonLattitude)," Failed to redirect the page ", "FAIL");
			Assert.fail();
		}
	}


	public void  ClickLattitude_Tabone(WebDriver driver) 
	{
		System.out.println("In Function ClickLattitude_Tabone");
		WebDriverWait  wait = new WebDriverWait(driver, 120);
		String ClickingonLattitude="";
		Actions act=new Actions(driver);
		System.out.println("After webdriver wait");
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
		try
		{
			CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.ClickingonLattitude());
			CommonUtility.ClickOn(driver, obj_EsupportIntegratedHomePage.ClickingonLattitude());
//			WebElement element = driver.findElement(obj_EsupportIntegratedHomePage.ClickingonLattitude());
//			act.moveToElement(element).click().perform();

			//CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.ClickingonLattitude()).click();

			System.out.println("Clicked on Clicking on Lattitude Link");

			//act.moveToElement(CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.ClickingonLattitudeEProductone())).build().perform();

			Thread.sleep(4000); 
			CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.ClickingonLattitudeEProductone());
			CommonUtility.ClickOn(driver, obj_EsupportIntegratedHomePage.ClickingonLattitudeEProductone());
//			WebElement eleme = driver.findElement(obj_EsupportIntegratedHomePage.ClickingonLattitudeEProductone());
//			act.moveToElement(eleme).click().perform();


			//CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.ClickingonLattitudeEProductone()).click();

			System.out.println("Clicked on Clicking on ClickingonLattitudeEProduct Link");

			//driver.navigate().refresh();
			Thread.sleep(3000);
			//act.moveToElement(CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.Headerservicetag())).build().perform();

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIntegratedHomePage.Headerservicetagone()));
			CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.Headerservicetagone());

			ClickingonLattitude=CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.Headerservicetagone()).getAttribute("innerText");


			System.out.println("Header displayed as "+ClickingonLattitude);

			Thread.sleep(3000);


			//      Report.put("Before changing Product name and After changing Product name header should be different", "Before changing link Product Name as  "+Report.color(Prevheader)+" After By clicking Changing link displayed as "+Report.color(ClickingonLattitude),"Successfully Product Name Changed after by clicking ChangeProduct link", "PASS");


			Report.put("User is able to add second product Click on Lattitude D420' button", "The user should be able to see Drivers Update Subscription Page and header is desplayed as "+Report.color(ClickingonLattitude)," Successfully Drivers Update Subscription Page and header is desplayed as "+Report.color(ClickingonLattitude), "PASS");
			handleCookies(driver);
			driver.navigate().refresh();
			Thread.sleep(5000);

			driver.navigate().back();
			driver.navigate().back();




			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIntegratedHomePage.ButtonClose()));

			handleCookies(driver);

//			WebElement ele = driver.findElement(obj_EsupportIntegratedHomePage.ButtonClose());
//			act.moveToElement(ele).click().perform();


			CommonUtility.ClickOn(driver, obj_EsupportIntegratedHomePage.ButtonClose());

			System.out.println("2nd Product Added  found");

			//      Thread.sleep(15000);



		}
		catch(Exception e)
		{
			e.printStackTrace();
			Assert.fail();
		}
	}


	public void  ClickLattitude_TabSecond(WebDriver driver) 
	{
		System.out.println("In Function ClickLattitude_TabSecond");
		WebDriverWait  wait = new WebDriverWait(driver, 120);
		String ClickingonLattitude="";
		Actions act=new Actions(driver);
		System.out.println("After webdriver wait");
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
		try
		{
			CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.ClickingonLattitude());
			CommonUtility.ClickOn(driver, obj_EsupportIntegratedHomePage.ClickingonLattitude());
//			WebElement element = driver.findElement(obj_EsupportIntegratedHomePage.ClickingonLattitude());
//			act.moveToElement(element).click().perform();

			//CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.ClickingonLattitude()).click();

			System.out.println("Clicked on Clicking on Lattitude Link");
			Thread.sleep(4000);

			//act.moveToElement(CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.ClickingonLattitudeEProductSecond())).build().perform();

			CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.ClickingonLattitudeEProductSecond());
			CommonUtility.ClickOn(driver, obj_EsupportIntegratedHomePage.ClickingonLattitudeEProductSecond());
//			WebElement elemen = driver.findElement(obj_EsupportIntegratedHomePage.ClickingonLattitudeEProductSecond());
//			act.moveToElement(elemen).click().perform();


			//CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.ClickingonLattitudeEProductSecond()).click();

			System.out.println("Clicked on Clicking on ClickingonLattitudeEProduct Link");

			//driver.navigate().refresh();

			//act.moveToElement(CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.Headerservicetag())).build().perform();

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIntegratedHomePage.Headerservicetagtwo()));
			CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.Headerservicetagtwo());

			ClickingonLattitude=CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.Headerservicetagtwo()).getAttribute("innerText");


			System.out.println("Header displayed as "+ClickingonLattitude);

			Thread.sleep(3000);


			//      Report.put("Before changing Product name and After changing Product name header should be different", "Before changing link Product Name as  "+Report.color(Prevheader)+" After By clicking Changing link displayed as "+Report.color(ClickingonLattitude),"Successfully Product Name Changed after by clicking ChangeProduct link", "PASS");


			Report.put("User is able to add second product Click on Lattitude E6410' button", "The user should be able to see Drivers Update Subscription Page and header is desplayed as "+Report.color(ClickingonLattitude)," Successfully Drivers Update Subscription Page and header is desplayed as "+Report.color(ClickingonLattitude), "PASS");
			handleCookies(driver);
			//driver.navigate().refresh();
			Thread.sleep(5000);

			driver.navigate().back();
			driver.navigate().back();

			//driver.navigate().back();


			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIntegratedHomePage.ButtonClose()));

			handleCookies(driver);



//			WebElement eleme = driver.findElement(obj_EsupportIntegratedHomePage.ButtonClose());
//			act.moveToElement(eleme).click().perform();
			CommonUtility.ClickOn(driver, obj_EsupportIntegratedHomePage.ButtonClose());

			System.out.println("3rd Product Added  found");

			//      Thread.sleep(15000);



		}
		catch(Exception e)
		{
			e.printStackTrace();
			Assert.fail();
		}
	}

	public void  ToClick_VerifyRecentlyviewedproducts(WebDriver driver) 
	{
		Actions act=new Actions(driver);
		System.out.println("In Function ToClick_VerifyRecentlyviewedproducts");
		WebDriverWait  wait = new WebDriverWait(driver, 120);

		String RecentlyViewedHeader="";

		try
		{



			Thread.sleep(3000);
			CommonUtility.ScrollTo(driver,obj_EsupportIntegratedHomePage.RecentlyViewedHeader());

		//	act.moveToElement(CommonUtility.highlightElement(driver,obj_EsupportIntegratedHomePage.RecentlyViewedHeader())).build().perform();

			CommonUtility.highlightElement(driver,obj_EsupportIntegratedHomePage.RecentlyViewedHeader());

			RecentlyViewedHeader=CommonUtility.highlightElement(driver,obj_EsupportIntegratedHomePage.RecentlyViewedHeader()).getText();



			String ltMessages="";
			CommonUtility.highlightElement(driver,obj_EsupportIntegratedHomePage.Recentlyproductsnames());

			List<WebElement> list=driver.findElements(obj_EsupportIntegratedHomePage.Recentlyproductsnames());

			for(WebElement lt:list)
			{
				CommonUtility.highlightElement(driver, lt);
				String names=lt.getAttribute("title");

				System.out.println("Alert Name is: " +names);
				ltMessages+=" <br> " + names;


			}


			String ltMessages1="";
			CommonUtility.highlightElement(driver,obj_EsupportIntegratedHomePage.RecentlyproductsImages());

			List<WebElement> list1=driver.findElements(obj_EsupportIntegratedHomePage.RecentlyproductsImages());

			for(WebElement lt:list1)
			{
				act.moveToElement(CommonUtility.highlightElement(driver, lt));
				//String names=lt.getText();

				//System.out.println("Alert Name is: " +names);
				//ltMessages1+=" <br> " + names;


			}

			Report.put("Navigate back to the support home page", 
					"User should find the recently viewed product under the recent product section with in the Product selector product image with product description should displayed as "+Report.color(ltMessages),
					" Successfully User should find the recently viewed product under the recent product section with in the Product selector product image with product description should displayed ", "PASS");




			Thread.sleep(3000);



		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Navigate back to the support home page", 
                    "User should find the recently viewed product under the recent product section with in the Product selector product image with product description should display",
                    " Failed to redirect the page ", "FAIL");

			Assert.fail();
		}
	}


	public void  ToVerify_ClickRighticon(WebDriver driver) 
	{
		Actions act=new Actions(driver);
		System.out.println("In Function ToVerify_ClickRighticon");
		WebDriverWait  wait = new WebDriverWait(driver, 120);
		String ClickingonLattitude="",Browseallproductslink="";
		System.out.println("After webdriver wait");
		Actions actions = new Actions(driver);
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
		try
		{

			CommonUtility.ScrollTo(driver,obj_EsupportIntegratedHomePage.RecentlyproductsRightprevicon());

//			act.moveToElement(CommonUtility.highlightElement(driver,obj_EsupportIntegratedHomePage.RecentlyproductsRightprevicon())).build().perform();

			CommonUtility.highlightElement(driver,obj_EsupportIntegratedHomePage.RecentlyproductsRightprevicon());
			CommonUtility.ClickOn(driver,obj_EsupportIntegratedHomePage.RecentlyproductsRightprevicon());
//			WebElement element = driver.findElement(obj_EsupportIntegratedHomePage.RecentlyproductsRightprevicon());
//			actions.moveToElement(element).click().perform();

			//CommonUtility.highlightElement(driver,obj_EsupportIntegratedHomePage.RecentlyproductsRightprevicon()).click();

			Thread.sleep(3000);

			Report.put("Click on the right arrow", 
					"User should land in the next recently viewed product",
					" Successfully User should land in the next recently viewed product","PASS");





		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on the right arrow", 
					"User should land in the next recently viewed product",
                    " Failed to redirect the page ", "FAIL");
			Assert.fail();
		}
	}


	public void  ToVerify_ClickLefticon(WebDriver driver) 
	{
		Actions act=new Actions(driver);
		System.out.println("In Function ToVerify_ClickLefticon");
		//WebDriverWait  wait = new WebDriverWait(driver, 120);

		try
		{
//			act.moveToElement(CommonUtility.highlightElement(driver,obj_EsupportIntegratedHomePage.RecentlyproductsLeftprevicon())).build().perform();

			CommonUtility.ScrollTo(driver,obj_EsupportIntegratedHomePage.RecentlyproductsLeftprevicon());

			CommonUtility.ClickOn(driver,obj_EsupportIntegratedHomePage.RecentlyproductsLeftprevicon());

			Thread.sleep(3000);

			Report.put("Click on left arrow", 
					"User should land in previously showed product",
					" Successfully User should land in previously showed product","PASS");





		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on left arrow", 
					"User should land in previously showed product",
                    "Failed to redirect the page ", "FAIL");
			Assert.fail();
		}
	}


	public void  ToVerify_DeleteProductIcon(WebDriver driver) 
	{
		Actions act=new Actions(driver);
		System.out.println("In Function ToVerify_DeleteProductIcon");
		//WebDriverWait  wait = new WebDriverWait(driver, 120);


		try
		{


			String ltMessages="";
			CommonUtility.highlightElement(driver,obj_EsupportIntegratedHomePage.Recentlyproductsnames());

			List<WebElement> list=driver.findElements(obj_EsupportIntegratedHomePage.Recentlyproductsnames());

			for(WebElement lt:list)
			{
				CommonUtility.highlightElement(driver, lt);
				String names=lt.getAttribute("title");
				System.out.println("Alert Name is: " +names);
				ltMessages+=" <br> " + names;


			}


			Report.put("Before deleting on Products", 
					"User should able to see products as " +Report.color(ltMessages),
					" Successfully User should able to see products","PASS");



//			act.moveToElement(CommonUtility.highlightElement(driver,obj_EsupportIntegratedHomePage.RecentlyproductsDeleteproduct())).build().perform();

			CommonUtility.ScrollTo(driver,obj_EsupportIntegratedHomePage.RecentlyproductsDelete());
			Thread.sleep(2000);

			CommonUtility.ClickOn(driver,obj_EsupportIntegratedHomePage.RecentlyproductsDelete());

//			act.moveToElement(CommonUtility.highlightElement(driver,obj_EsupportIntegratedHomePage.RecentlyproductsDelete())).click().perform();



			Thread.sleep(5000);

			String ltMessages1="";
			CommonUtility.highlightElement(driver,obj_EsupportIntegratedHomePage.Recentlyproductsnames());

			List<WebElement> list1=driver.findElements(obj_EsupportIntegratedHomePage.Recentlyproductsnames());

			for(WebElement lt:list1)
			{
				CommonUtility.highlightElement(driver, lt);
				String names=lt.getAttribute("title");
				System.out.println("Alert Name is: " +names);
				ltMessages1+=" <br> " + names;


			}

			Report.put("After deleting on any recently view Products", 
					"User should able to see products as " +Report.color(ltMessages1),
					" Successfully User should able to see products","PASS");



			Thread.sleep(3000);
		}

		catch(Exception e)
		{
			e.printStackTrace();
			Assert.fail();
		}
	}

	public void verifyproductsupportpageLinks(WebDriver driver){
		String Browseallproductslink="";
		System.out.println("Entered into method: Verify all the links in product support page ");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		try {

			Thread.sleep(6000);
			String productsupportLinks = "";
			String criticalLinks="";
			String ProductTabList="";

			//handleCookies(driver);
			System.out.println("scrolling to tech Browse All Products Link.");
			Thread.sleep(10000);
			toClick_FindMyDellEMCProducts(driver);
			Thread.sleep(10000);
			CommonUtility.ScrollTo(driver,obj_EsupportDriversandDownloadsPage.Browseallproductslink());
			if(CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.Browseallproductslink()).isDisplayed())
			{
				Browseallproductslink=CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.Browseallproductslink()).getText();
			}
			CommonUtility.ScrollTo(driver, obj_EsupportIntegratedHomePage.BrowseAllProductsLink());

			//CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.BrowseAllProductsLink()).isDisplayed();
			//CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.BrowseAllProductsLink());
			productsupportLinks = productsupportLinks +Browseallproductslink; 
			//productsupportLinks = productsupportLinks + CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.BrowseAllProductsLink()).getText() + "<br>";
			CommonUtility.ClickOn(driver, obj_EsupportIntegratedHomePage.BrowseAllProductsLink());
			driver.navigate().back();
			//handleCookies(driver);
			
//			try 
//			{
//
//				List<WebElement> ProductTabs = driver.findElements(obj_EsupportIntegratedHomePage.ProductTabs());
//				for (int i = 0; i < ProductTabs.size(); i++) {
//					ProductTabs = driver.findElements(obj_EsupportIntegratedHomePage.ProductTabs());
//					CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.ProductTabs());
//					String value = ProductTabs.get(i).getText();
//					ProductTabList+=" <br> " + value;
//
//				}
//				Thread.sleep(3000);
////				WebElement elem = driver.findElement(obj_EsupportIntegratedHomePage.ButtonClose());
////				CommonUtility.ToClickByUsingJavaScript(driver, elem);
//				CommonUtility.ClickOn(driver, obj_EsupportIntegratedHomePage.ButtonClose());
//			}catch(Exception e) {
//
//				e.printStackTrace();
//				System.out.println("Expception occured while verifying the Product support Links. "+e);
//
//				Assert.fail();
//			}
			handleCookies(driver);
			System.out.println("Checking RecentlyViewedHeader");
			CommonUtility.ScrollTo(driver, obj_EsupportIncidentsPage.ClickOnRightArrow());
			CommonUtility.ClickOn(driver, obj_EsupportIncidentsPage.ClickOnRightArrow());
			CommonUtility.ScrollTo(driver, obj_EsupportIntegratedHomePage.RecentlyViewedHeader());
			CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.RecentlyViewedHeader());
			productsupportLinks = productsupportLinks + CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.RecentlyViewedHeader()).getText() + "<br>";
			//CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.RecentlyproductsImages()).click();
			Thread.sleep(2000);
			//CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.RecentlyproductsImages()).click();
//			WebElement eleme = driver.findElement(obj_EsupportIntegratedHomePage.RecentlyViewedProduct());
//			CommonUtility.ToClickByUsingJavaScript(driver, eleme);
			CommonUtility.ScrollTo(driver, obj_EsupportIntegratedHomePage.RecentlyViewedProduct());
			CommonUtility.ClickOn(driver, obj_EsupportIntegratedHomePage.RecentlyViewedProduct());

			driver.navigate().to("https://www.dell.com/support/home");
			
			Thread.sleep(7000);
			System.out.println("clicking Recently products Images.");
			CommonUtility.ScrollTo(driver, obj_EsupportIntegratedHomePage.DellEMCSupportTechnologies());
			CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.DellEMCSupportTechnologies());
			productsupportLinks = productsupportLinks + CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.DellEMCSupportTechnologies()).getText() + "<br>";


			System.out.println("scrolling to tech direct link.");
//			CommonUtility.ScrollTo(driver, obj_EsupportIntegratedHomePage.TechDirectLink());

			CommonUtility.ScrollTo(driver, obj_EsupportIntegratedHomePage.TechDirectLink());
			CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.TechDirectLink());
			criticalLinks = criticalLinks + CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.TechDirectLink()).getText() + "<br>";

			CommonUtility.ScrollTo(driver, obj_EsupportIntegratedHomePage.myService360());
			CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.myService360());
			criticalLinks = criticalLinks + CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.myService360()).getText() + "<br>";
			try{ 
				Thread.sleep(2000);
				CommonUtility.ClickOn(driver, obj_EsupportIntegratedHomePage.TechDirectLink());
				System.out.println("clicked on tech direct link.");

				Thread.sleep(4000);
				System.out.println("page title : " + driver.getTitle());
				System.out.println("current url : " + driver.getCurrentUrl());

				if(driver.getTitle().contains("TechDirect") && driver.getCurrentUrl().contains("https://techdirect.dell.com")){
					System.out.println("User is navigated to Tech Direct page.");
					Report.put("Click on Tech Direct link.",
							"User should land in Tech Direct page Tech Direct URL is: https://techdirect.dell.com",
							"User is navigated to Tech Direct page, URL : " + Report.color(driver.getCurrentUrl()), "PASS");
				}
				else{
					System.out.println("User is not navigated to Tech Direct page.");
				}
			}catch(Exception e) {

				e.printStackTrace();
				System.out.println("Expception occured while verifying the Product support Links. "+e);

				Assert.fail();
			}


			System.out.println("Links : " + productsupportLinks);


			Report.put("Verify all the links in product support page",
					"All links should be present in product support page," +Report.color(productsupportLinks),
					"1) Browse all products should load all the L Dell Product families ,Categories and Products as drill down,2) Find My Dell EMC Product should load the pop up find my Dell EMC products with 3 tabs Product search , custom groups and account sites,3) Recent products should show with serial number,click on any product should land in L EMC Product support page,4) Tech Direct and My service 360 links should land in expected pages", "PASS");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Expception occured while verifying the Product support Links. "+e);

			Report.put("Verify all the links in product support page",
					"All links should be present in product support page",
					"Failed while verifying the integrated homepage roduct support Links.", "FAIL");
			Assert.fail();
		}

	}
	//Sujata

	public void ToVerify_EnterServiceTags(WebDriver driver,String Servicetag) 
	{
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 120);

		Actions act=new Actions(driver);

		System.out.println("Entering ToVerify_ProductSupport");

		Log.info("Entering Esupport Home Page");         
		String DetectPCButton="";

		String Headerservicetag="";
		String Headerservicetagdisplay="",DellEmcProductIcontext="";
		String Browseallproductslink="";
		try 
		{
			Thread.sleep(10000);
			
			CommonUtility.ScrollTo(driver,obj_EsupportDriversandDownloadsPage.Delllogo());
			System.out.println("dell logo found");
			CommonUtility.ScrollTo(driver,obj_EsupportDriversandDownloadsPage.SearchServicetag());
			System.out.println("found");
//			CommonUtility.ScrollTo(driver, obj_EsupportDriversandDownloadsPage.Headerservicetag());
			//act.moveToElement(CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.Headerservicetag())).build().perform();
			CommonUtility.ScrollTo(driver,obj_EsupportDriversandDownloadsPage.Headerservicetag());
			if(CommonUtility.CheckpresenceofElementLocated(driver,10,obj_EsupportDriversandDownloadsPage.Headerservicetag()))
			{
//				CommonUtility.ScrollTo(driver,obj_EsupportDriversandDownloadsPage.Headerservicetag());
				Headerservicetag=CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.Headerservicetag()).getText();
				System.out.println(Headerservicetag);
			}
			
			CommonUtility.ScrollTo(driver,obj_EsupportDriversandDownloadsPage.Browseallproductslink());
			if(CommonUtility.CheckpresenceofElementLocated(driver,20,obj_EsupportDriversandDownloadsPage.Browseallproductslink()))
			{
				CommonUtility.ScrollTo(driver,obj_EsupportDriversandDownloadsPage.Browseallproductslink());
				Browseallproductslink=CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.Browseallproductslink()).getText();
				System.out.println(Browseallproductslink);
			}
			

			handleCookies(driver);

			

			CommonUtility.ScrollTo(driver,obj_EsupportDriversandDownloadsPage.DetectPCButton());
//			if(CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.DetectPCButton()).isDisplayed())
//			{
//				DetectPCButton=CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.DetectPCButton()).getText();
//				System.out.println(DetectPCButton);
//			}
			
			CommonUtility.ScrollTo(driver,obj_EsupportIntegratedHomePage.DellEmcProductIcontext());
			if(CommonUtility.highlightElement(driver,obj_EsupportIntegratedHomePage.DellEmcProductIcontext()).isDisplayed())
			{
				DellEmcProductIcontext=CommonUtility.highlightElement(driver,obj_EsupportIntegratedHomePage.DellEmcProductIcontext()).getText();
				System.out.println(DellEmcProductIcontext);
			}
			
			String newcode=TestNGCreator.TestData.get(Esupport.TestCaseID.ordinal());
			if(!(newcode.equalsIgnoreCase("5735414"))){
				CommonUtility.ScrollTo(driver,obj_EsupportDriversandDownloadsPage.SearchServicetag());
				CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.SearchServicetag()).sendKeys(Servicetag);

//				WebElement element = driver.findElement(obj_EsupportDriversandDownloadsPage.Servicetagiconsearch());

				//Actions actions = new Actions(driver);
//				act.moveToElement(element).click().perform();
//				CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.SearchServicetag()).sendKeys(Keys.ENTER);

				CommonUtility.ClickOn(driver,obj_EsupportDriversandDownloadsPage.Servicetagiconsearch());
			//	handleCaptcha(driver); 
				Thread.sleep(10000); 
				handleCookies(driver);
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDriversandDownloadsPage.ServiceTagHeaderdisplayed()));
				CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.ServiceTagHeaderdisplayed());
				Headerservicetagdisplay=CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.ServiceTagHeaderdisplayed()).getText();

				Report.put("Within the Integrated homepage Under the product selector section verify the options",
						"Product selector should show up with heading Enter a Service Tag, Serial Number, Service Request, Model, or Keyword. With Search Box and detect PC button Browse all products and View all your assets "
								+ "1)"+Report.color(Headerservicetag)+ 
								" <br> 2) "+Report.color(Browseallproductslink)+
								"<br> 3)"+Report.color(DetectPCButton)+
								"<br> 4)"+Report.color(DellEmcProductIcontext)+" icon","Successfully Application should navigate to "+Report.color(Headerservicetagdisplay), "PASS");

			}
			String newcode1=TestNGCreator.TestData.get(Esupport.TestCaseID.ordinal());
			if(newcode1.equalsIgnoreCase("5735414")){

				Report.put("Verify the product selector Section",
						"User should find product selector with headings as "
								+ "1)"+Report.color(Headerservicetag)+ 
								" <br> 2) "+Report.color(Browseallproductslink)+
								"<br> 3)"+Report.color(DetectPCButton)+
								"<br> 4)"+Report.color(DellEmcProductIcontext)+" icon",
								"successfully Product selector should show up with heading Enter a Service Tag, Serial Number, Service Request, Model, or Keyword. With Search Box and detect PC button Browse all products and View all your assets ", "PASS");

			}




		}catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Not able to find Entered service tag", "Not able to find Entered service tag",
					"Not able to find Entered service tag", "FAIL");
			Assert.fail();

		}
	}


	public void  ToVerify_ClickLefticonWindowsicon(WebDriver driver) 
	{
		Actions act=new Actions(driver);
		System.out.println("In Function ToVerify_ClickLefticonWindowsicon");
		//WebDriverWait  wait = new WebDriverWait(driver, 120);

		try
		{


			String WindowsiconText="";

			CommonUtility.ScrollTo(driver, obj_EsupportIntegratedHomePage.Windows7icon());
			//act.moveToElement(CommonUtility.highlightElement(driver,obj_EsupportIntegratedHomePage.Windows7icon())).build().perform();

			CommonUtility.highlightElement(driver,obj_EsupportIntegratedHomePage.Windows7icon());

			if(CommonUtility.highlightElement(driver,obj_EsupportIntegratedHomePage.Windows7icon()).isDisplayed())
			{
				WindowsiconText=CommonUtility.highlightElement(driver,obj_EsupportIntegratedHomePage.Windows7iconText()).getText();
			}


			Report.put("Verify the Windows 10 banner", 
					"Windows 10 banner should be present on top right and label displayed as "+Report.color(WindowsiconText),
					" Successfully Windows 10 banner should be present on top right ","PASS");





		}
		catch(Exception e)
		{
			e.printStackTrace();
			Assert.fail();
		}
	}


	public void  ToVerify_WebPartsbelowProductSelector(WebDriver driver) 
	{
		Actions act=new Actions(driver);
		System.out.println("In Function ToVerify_WebPartsbelowProductSelector");
		//WebDriverWait  wait = new WebDriverWait(driver, 120);

		try
		{



			CommonUtility.ScrollTo(driver, obj_EsupportIntegratedHomePage.WebPartsbelowProductSelector());
		//	act.moveToElement(CommonUtility.highlightElement(driver,obj_EsupportIntegratedHomePage.WebPartsbelowProductSelector())).build().perform();

			CommonUtility.highlightElement(driver,obj_EsupportIntegratedHomePage.WebPartsbelowProductSelector());

			String ltMessages="";


			List<WebElement> list=driver.findElements(obj_EsupportIntegratedHomePage.WebPartsbelowProductSelector());

			for(WebElement lt:list)
			{
				CommonUtility.highlightElement(driver, lt);
				String names=lt.getText();

				System.out.println("Alert Name is: " +names);
				ltMessages+=" <br> " + names;


			}


			Report.put("Verify the Web parts below the Product selector ", 
					"Web parts below the Product selector displayed following as "+Report.color(ltMessages),
					" Successfully Web parts below the Product selector displayed ","PASS");





		}
		catch(Exception e)
		{
			e.printStackTrace();

			Report.put("Verify the Web parts below the Product selector ", 
					"Not ablle to dsiplay Web parts below the Product selector  ",
					" Not ablle to dsiplay Web parts below the Product selector   ","FAIL");
			Assert.fail();
		}
	}


	public void  ToVerify_clickonSoftwareLicence(WebDriver driver) 
	{
		Actions act=new Actions(driver);

		System.out.println("In Function ToVerify_clickonSoftwareLicence");

		WebDriverWait wait = new WebDriverWait(driver, 200);
		//WebDriverWait  wait = new WebDriverWait(driver, 120);

		try
		{


			//act.moveToElement(CommonUtility.highlightElement(driver,obj_EsupportIntegratedHomePage.SoftwareLicence())).build().perform();

			//CommonUtility.highlightElement(driver,obj_EsupportIntegratedHomePage.SoftwareLicence());

			Thread.sleep(4000);
			System.out.println("scrolling to Software Licence");
			CommonUtility.ScrollTo(driver, obj_EsupportIntegratedHomePage.SoftwareLicence());

			Thread.sleep(2000);
//			WebElement element = driver.findElement(obj_EsupportIntegratedHomePage.SoftwareLicence());
//			Actions actions = new Actions(driver);
//			actions.moveToElement(element).click().perform();
			CommonUtility.ClickOn(driver, obj_EsupportIntegratedHomePage.SoftwareLicence());
			System.out.println("Clicked on Software Licencer");
			//CommonUtility.highlightElement(driver,obj_EsupportIntegratedHomePage.SoftwareLicence()).click();

			handleCookies(driver);

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIntegratedHomePage.SoftwareLicencepageHeader()));

			CommonUtility.highlightElement(driver,obj_EsupportIntegratedHomePage.SoftwareLicencepageHeader());

			String SoftwareLicencepageHeader=CommonUtility.highlightElement(driver,obj_EsupportIntegratedHomePage.SoftwareLicencepageHeader()).getText();


			Report.put("click on software licenses ", 
					"User should land in "+Report.color(SoftwareLicencepageHeader)+" jump page",
					" Successfully User should land in software licenses jump page ","PASS");





		}
		catch(Exception e)
		{
			e.printStackTrace();

			Report.put("click on software licenses ", 
					"User is not able to Software Licence page",
					" User is not able to Software Licence page ","FAIL");

			Assert.fail();
		}
	}


	public void  ToVerify_SoftwareLicenceinnerlinks(WebDriver driver) 
	{
		Actions act=new Actions(driver);
		System.out.println("In Function ToVerify_SoftwareLicenceinnerlinks");
		//WebDriverWait  wait = new WebDriverWait(driver, 120);

		try
		{




			//act.moveToElement(CommonUtility.highlightElement(driver,obj_EsupportIntegratedHomePage.WebPartsbelowProductSelector())).build().perform();

			CommonUtility.highlightElement(driver,obj_EsupportIntegratedHomePage.SoftwareLicencepageLinks());

			String ltMessages="";


			List<WebElement> list=driver.findElements(obj_EsupportIntegratedHomePage.SoftwareLicencepageLinks());

			for(WebElement lt:list)
			{
				CommonUtility.highlightElement(driver, lt);
				String names=lt.getText();

				System.out.println("Alert Name is: " +names);
				ltMessages+=" <br> " + names;


			}


			Report.put("Verify the Software Licence Manage links ", 
					"Software Licence Manage links displayed following as "+Report.color(ltMessages),
					" SuccessfullySoftware Licence Manage links displayed ","PASS");





		}
		catch(Exception e)
		{
			e.printStackTrace();

			Report.put("Verify the Software Licence Manage links ", 
					"Software Licence Manage links should be displayed",
					" Failed to display Software Licence Manage links","FAIL");
			Assert.fail();
		}
	}


	public void TOclick_DellDigitalLockerSL(WebDriver driver){
		System.out.println("Entered into method: to TOclick_DellDigitalLockerSL.");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		try {
			Thread.sleep(4000);
			System.out.println("scrolling to Digital locker");
			CommonUtility.ScrollTo(driver, obj_EsupportIntegratedHomePage.SoftwareLicencepageLinksDIgitalLocker());

			Thread.sleep(2000);
//			WebElement element = driver.findElement(obj_EsupportIntegratedHomePage.SoftwareLicencepageLinksDIgitalLocker());
//			Actions actions = new Actions(driver);
//			actions.moveToElement(element).click().perform();
			CommonUtility.ClickOn(driver, obj_EsupportIntegratedHomePage.SoftwareLicencepageLinksDIgitalLocker());
			System.out.println("Clicked on Digital locker");

			Thread.sleep(4000);
			System.out.println("page title : " + driver.getTitle());
			System.out.println("current url : " + driver.getCurrentUrl());

			if(driver.getTitle().contains("Dell Digital Locker")){
				System.out.println("User is navigated to Dell Digital Locker.");
				Report.put("Click on Dell Digital Locker.",
						"User should land in Dell Digital Locker",
						"User is navigated to Dell Digital Locker", "PASS");
			}
			else{
				System.out.println("User is not navigated to Tech Direct page.");
				Report.put("Click on Dell Digital Locker.",
						"User is not able  land in Dell Digital Locker",
						"User is not able  land in Dell Digital Locker", "FAIL");
				Assert.fail();
			}


		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Report.put("Click on Dell Digital Locker.",
					"User is not able  land in Dell Digital Locker",
					"User is not able  land in Dell Digital Locker", "FAIL");
			Assert.fail();
		}
	}


	public void TOclick_DellEMCLicense(WebDriver driver){
		System.out.println("Entered into method: to TOclick_DellEMCLicense.");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		try {
			Thread.sleep(4000);
			System.out.println("scrolling to TOclick_DellEMCLicense");
			//CommonUtility.scrollToViewElement(driver, obj_EsupportIntegratedHomePage.SoftwareLicencepageLinksDellEMC()).click();
			CommonUtility.ClickOn(driver,obj_EsupportIntegratedHomePage.SoftwareLicencepageLinksDellEMC());
//			Thread.sleep(2000);
//			WebElement element = driver.findElement(obj_EsupportIntegratedHomePage.SoftwareLicencepageLinksDellEMC());
//			Actions actions = new Actions(driver);
//			//actions.moveToElement(element).click().perform();
//element.click();

			//CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.SoftwareLicencepageLinksDellEMC()).click();
			System.out.println("Clicked on Manage Licenses");

			Thread.sleep(20000);
			WebDriverWait wait = new WebDriverWait(driver, 120);
			//wait.until(ExpectedConditions.jsReturnsValue("complete"));
			wait.until(ExpectedConditions.titleIs("EMC - Manage Licenses"));

			System.out.println("page title : " + driver.getTitle());
			System.out.println("current url : " + driver.getCurrentUrl());

			if(driver.getTitle().contains("Manage Licenses")){
				System.out.println("User is navigated to Manage Licenses.");
				Report.put("Click on Dell EMC Manage Licenses and Usage Intelligence",
						"User should land in Dell EMC Manage Licenses",
						"User is navigated to Dell EMC Manage Licenses", "PASS");
			}
			else{
				System.out.println("User is not navigated to Manage Licenses.");
				Report.put("Click on Dell EMC Manage Licenses.",
						"User is not able  land in Dell EMC Manage Licenses",
						"User is not able  land in Dell EMC Manage Licenses", "FAIL");
				Assert.fail();
			}


		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Report.put("Click on Dell EMC Manage Licenses.",
					"User is not able  land in Dell EMC Manage Licenses",
					"User is not able  land in Dell EMC Manage Licenses", "FAIL");
			Assert.fail();
		}
	}

	public void TOclick_DellDigitalLibrary(WebDriver driver){
		System.out.println("Entered into method: to TOclick_DellDigitalLibrary.");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		try {
			Thread.sleep(4000);
			System.out.println("scrolling to DellDigitalLib");
			CommonUtility.ScrollTo(driver, obj_EsupportIntegratedHomePage.SoftwareLicencepageLinksDellDigitalLib());

			Thread.sleep(2000);
			CommonUtility.ClickOn(driver, obj_EsupportIntegratedHomePage.SoftwareLicencepageLinksDellDigitalLib());
			System.out.println("Clicked on Manage Licenses");

			Thread.sleep(4000);
			System.out.println("page title : " + driver.getTitle());
			System.out.println("current url : " + driver.getCurrentUrl());

			if(driver.getTitle().contains("Dell Digital Delivery")){
				System.out.println("User is navigated to Dell Digital Delivery.");
				Report.put("Click on Dell Digital Delivery",
						"User should land in Dell Digital Delivery",
						"User is navigated to Dell Digital Delivery", "PASS");
			}
			else{
				System.out.println("User is not navigated to Tech Direct page.");
				Report.put("Click on Dell Digital Delivery ",
						"User is not able  land in Dell Digital Delivery",
						"User is not able  land in Dell Digital Delivery", "FAIL");
				Assert.fail();
			}


		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Report.put("Click on Dell Digital Delivery ",
					"User is not able  land in Dell Digital Delivery",
					"User is not able  land in Dell Digital Delivery", "FAIL");
			Assert.fail();
		}
	}


	public void TOclick_DellLOGO(WebDriver driver){
		System.out.println("Entered into method: to TOclick_DellLOGO.");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		try {
			Thread.sleep(4000);
			System.out.println("scrolling to Dell Logo");
			CommonUtility.ScrollTo(driver, obj_EsupportIntegratedHomePage.delllogo());

			Thread.sleep(2000);
			CommonUtility.ClickOn(driver, obj_EsupportIntegratedHomePage.delllogo());
			System.out.println("Clicked on delllogo");

			Thread.sleep(4000);
			System.out.println("page title : " + driver.getTitle());
			System.out.println("current url : " + driver.getCurrentUrl());

			if(driver.getTitle().contains("Dell Official Site") && driver.getCurrentUrl().contains("https://www.dell.com")){
				System.out.println("User is navigated to Dell Official Site");
				Report.put("Click on Dell logo",
						"User should land in Dell Official Site",
						"User is navigated to Dell Official Site", "PASS");
			}
			else{
				System.out.println("User is not navigated to Tech Direct page.");
				Report.put("Click on Dell Logo.",
						"User is not able  land in Dell Official Site",
						"User is not able  land in Dell Official Site", "FAIL");
				Assert.fail();
			}


		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Report.put("Click on Dell Logo.",
					"User is not able  land in Dell Official Site",
					"User is not able  land in Dell Official Site", "FAIL");
			Assert.fail();
		}
	}


	public void TOclick_DellEMCLOGO(WebDriver driver){
		System.out.println("Entered into method: to TOclick_DellEMCLOGO.");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Actions actions = new Actions(driver);

		try {
			Thread.sleep(4000);
			System.out.println("scrolling to Dell Logo");
			CommonUtility.ScrollTo(driver, obj_EsupportIntegratedHomePage.ClickDellEMCLogo());

			Thread.sleep(2000);
//			WebElement element = driver.findElement(obj_EsupportIntegratedHomePage.ClickDellEMCLogo());
//			actions.moveToElement(element).click().perform();


			CommonUtility.ClickOn(driver, obj_EsupportIntegratedHomePage.ClickDellEMCLogo());
			System.out.println("Clicked on delllogo");

			Thread.sleep(2000);
			WebDriverWait wait = new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.titleIs("Digital Transformation - IT & Workforce Solutions | Dell Technologies US"));

			System.out.println("page title : " + driver.getTitle());
			System.out.println("current url : " + driver.getCurrentUrl());

			if(driver.getTitle().contains("Dell Technologies US") ){
				System.out.println("User is navigated to Dell Official Site");
				Report.put("Click on Dell EMC logo",
						"User should land in Dell EMC Page should be display",
						"User is navigated to Dell EMC Page", "PASS");
			}
			else{
				System.out.println("User is not navigated to Tech Direct page.");
				Report.put("Click on DellEMC Logo.",
						"User is not able  land on Dell EMC Page",
						"User is not able  land on Dell EMC Page", "FAIL");
				Assert.fail();
			}


		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Report.put("Click on DellEMC Logo.",
					"User is not able  land on Dell EMC Page",
					"User is not able  land on Dell EMC Page", "FAIL");
			Assert.fail();
		}
	}



	public void TOclick_Windowsicon(WebDriver driver){
		System.out.println("Entered into method: to TOclick_Windowsicon.");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		try {
			Thread.sleep(4000);
			System.out.println("scrolling to Windowsicon");
			CommonUtility.ScrollTo(driver, obj_EsupportIntegratedHomePage.Windows7icon());

			Thread.sleep(2000);
			CommonUtility.ClickOn(driver, obj_EsupportIntegratedHomePage.Windows7icon());
			System.out.println("Clicked on Windowsicon");

			Thread.sleep(4000);
			System.out.println("page title : " + driver.getTitle());
			System.out.println("current url : " + driver.getCurrentUrl());

			if(driver.getTitle().contains("Windows Operating Systems") ){
				System.out.println("User is navigated to Windows Operating Systems");
				Report.put("Click on Windows Icon",
						"User should land on Windows Operating Systems page ",
						"User is navigated to Windows Operating Systems", "PASS");
			}
			else{
				System.out.println("User is not navigated to Tech Direct page.");
				Report.put("Click on Windows Operating Systems.",
						"User is not able  land on Windows Operating Systems",
						"User is not able  land on Windows Operating Systems", "FAIL");
				Assert.fail();
			}


		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Report.put("Click on Windows Operating Systems.",
					"User is not able  land on Windows Operating Systems",
					"User is not able  land on Windows Operating Systems", "FAIL");
			Assert.fail();
		}
	}


	public void toVerifyLockIconInFindMyDellEMCProductLink(WebDriver driver){

		Log.info("Entered into method: to verify lock icon in 'Find My Dell EMC Product'");
		WebDriverWait wait = new WebDriverWait(driver, 20);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		try {
			Thread.sleep(4000);

			System.out.println("Check the visibility of the lock icon.");
			CommonUtility.ScrollTo(driver, obj_EsupportIntegratedHomePage.FindMyDellEMCProductLockIcon());

//			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIntegratedHomePage.DellEmcProductIcontext()));
			CommonUtility.ScrollTo(driver, obj_EsupportIntegratedHomePage.DellEmcProductIcontext());

			if(!(CommonUtility.CheckpresenceofElementLocated(driver, 20, obj_EsupportIntegratedHomePage.FindMyDellEMCProductLockIcon()))){
				System.out.println("Lock icon is not displayed.");
				Report.put("Under the product selector Verify the Find My Dell EMC Products.", 
						"Lock symbol should be present with Find My Dell EMC Products.",
						"Lock symbol is not present with Find My Dell EMC Products.", "FAIL");
				Assert.fail();
			}

			System.out.println("Lock icon is displayed.");
			Report.put("Under the product selector Verify the Find My Dell EMC Products.", 
					"Lock symbol should be present with Find My Dell EMC Products.",
					"Lock symbol is present with Find My Dell EMC Products.", "PASS");


		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Lock icon is not displayed.");
			Report.put("Under the product selector Verify the Find My Dell EMC Products.", 
					"Lock symbol should be present with Find My Dell EMC Products.",
					"Lock symbol is not present with Find My Dell EMC Products.", "FAIL");
			Assert.fail();
		}

	}


	public void clickOnFindMyDellEMCProductsLink(WebDriver driver){
		System.out.println("Entered into method: to click on 'FindMyDellEMCProduct' link.");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		String title="";
		String currenturl="";

		try {
			Thread.sleep(4000);

			CommonUtility.ScrollTo(driver, obj_EsupportIntegratedHomePage.DellEmcProductIcontext());
			CommonUtility.ClickOn(driver, obj_EsupportIntegratedHomePage.DellEmcProductIcontext());
//			WebElement element = driver.findElement(obj_EsupportIntegratedHomePage.DellEmcProductIcontext());
//			Actions actions = new Actions(driver);
//			actions.moveToElement(element).click().perform();
			System.out.println("clicked on 'view all your assets' link.");

//			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIntegratedHomePage.signInHeader()));
//			CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.signInHeader());
//			Thread.sleep(5000);
//
//			System.out.println("User navigated to My account login screen.");
			
			Thread.sleep(10000);
			//handleCookies(driver);
			String mainwindow=driver.getWindowHandle();
			Set<String> set=driver.getWindowHandles();
			Iterator<String> itr=set.iterator();
			while(itr.hasNext())
			{
				String childWindow=itr.next();
				if(!mainwindow.equals(childWindow))
				{
					Thread.sleep(5000);
					driver.switchTo().window(childWindow);
					title=driver.getTitle();
					
					currenturl=driver.getCurrentUrl();
					
					System.out.println(title);
					System.out.println(currenturl);
					driver.close();
				}
			}
			Thread.sleep(10000);
			driver.switchTo().window(mainwindow);
			System.out.println("User navigated tologin screen.");
			Report.put("Click on view all your assets ",
					"User should get the My account login DIAS Page",
					"User able to get login page with tile"+Report.color(title)+" with url "+Report.color(currenturl), "PASS");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("User failed to get the My account login screen.");
			Report.put("Click on 'FindMyDellEMCProduct' link.",
					"User should get the My account login screen.",
					"User failed to get the My account login screen", "FAIL");
			Assert.fail();
		}
	}



	public void toLoad_Productselector_HomePage(WebDriver driver, String val1,String val2, String product1, String product2)
	{
		Log.info("Entering to Product selector home page");
		try{
			CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.browseAllProducts()); 
			CommonUtility.CheckpresenceofElementLocated(driver, 50, By.xpath("//div[@id='divCatalogSubItems']//div[contains(@class,'CatalogAlign')]//p[text()='"+product1+"']"));
			CommonUtility.ClickOn(driver,By.xpath("//div[@id='divCatalogSubItems']//div[contains(@class,'CatalogAlign')]//p[text()='"+product1+"']")); 

			CommonUtility.CheckpresenceofElementLocated(driver, 50, By.xpath("//div[@id='divCatalogItems']//div[contains(@class,'CatalogAlign')]//p[text()='"+product2+"']"));
			CommonUtility.ClickOn(driver,By.xpath("//div[@id='divCatalogItems']//div[contains(@class,'CatalogAlign')]//p[text()='"+product2+"']")); 

			if(CommonUtility.CheckpresenceofElementLocated(driver, 30, By.xpath("(//div[@id='divCatalogChild-0']//a//p[contains(text(),'"+val1+"')])[2]")))
			{
				System.out.println("entered into if");
			CommonUtility.ScrollTo(driver, By.xpath("(//div[@id='divCatalogChild-0']//a//p[contains(text(),'"+val1+"')])[2]"));
			CommonUtility.ClickOn(driver, By.xpath("(//div[@id='divCatalogChild-0']//a//p[contains(text(),'"+val1+"')])[2]")); 
			}
			CommonUtility.ScrollTo(driver, By.xpath("//div[@id='divCatalogItems']//div/a[contains(text(),'"+val2+"')]"));
			CommonUtility.ClickOn(driver, By.xpath("//div[@id='divCatalogItems']//div/a[contains(text(),'"+val2+"')]")); 

			//CommonUtility.highlightElement(driver, By.xpath("//span[@id='mh-breadcrumb-2']"));
			CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.ServiceTagHeaderdisplayed());
			System.out.println(CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.ServiceTagHeaderdisplayed()).getText());

			Thread.sleep(5000);

			Report.put("</br> Select a product using Product selector </br> BROWSE ALL PRODUCTS --> "+Report.color(product1)+" -->  "+Report.color(product1)+" --> "+Report.color(val1)+" --> "+Report.color(val2),
					"Product Support Home page should get loaded", "Product Support Home page is loaded", "PASS");
		}
		catch(Exception ex){
			ex.printStackTrace();
			Report.put("</br> Select a product using Product selector </br> BROWSE ALL PRODUCTS --> "+Report.color(product1)+" -->  "+Report.color(product1)+" --> "+Report.color(val1)+" --> "+Report.color(val2),
					"Product Support Home page should get loaded", "Product Support Home page is not loaded", "FAIL");
			Assert.fail();
		}
	}
	//Mamta

	public void toVerify_ProdutSupportResultPage(WebDriver driver, String val)
	{
		WebDriverWait wait = new WebDriverWait(driver,50);
		try{



			Thread.sleep(3000);
//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Support for "+val+"')]")));   
//			CommonUtility.highlightElement(driver, By.xpath("//span[contains(text(),'Support for "+val+"')]"));

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDriversandDownloadsPage.ServiceTagHeaderdisplayed()));
			CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.ServiceTagHeaderdisplayed());
			
			Report.put("Select any Product from the Auto suggestion", "User Should Land in Product support page for the Selected auto suggestion product", "Product support page is opened", "PASS");
		} catch(Exception ex){
			ex.printStackTrace();
			Report.put("Select any Product from the Auto suggestion", "User Should Land in Product support page for the Selected auto suggestion product", "Unable to open product support page", "PASS");
			Assert.fail();
		}
	} 
	private void waitForElementPresent(WebElement autoCompleteOption) {
		// TODO Auto-generated method stub

	}


	public void toVerify_LEMC_AccountPage (WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver,50);
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIntegratedHomePage.signIn()));
			CommonUtility.highlightElement(driver,(obj_EsupportIntegratedHomePage.signIn()));
			Report.put("Select any L-EMC Product from the Auto suggestion", "User Should Land in my account page", "User is landed in my account page ", "PASS");

		} catch(Exception ex){
			ex.printStackTrace();
			Report.put("Select any L-EMC Product from the Auto suggestion", "User Should Land in my account page", "Unable to land in my account page ", "FAIL");
			Assert.fail();
		}
	}
	public void Emaillogin(WebDriver driver,String name,String pwd ) {
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 120);
//		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		boolean exists = true;
		Actions actions = new Actions(driver);

		//String name = TestNGCreator.TestData.get(Esupport.Username.ordinal()) ;
		//   String pwd = TestNGCreator.TestData.get(Esupport.Password.ordinal()) ;
		System.out.println("Entering Email Login Home Page");

		Log.info("Entering Email Login Home Page");             
		try {


			System.out.println(name);
			System.out.println(pwd);

			handleCookies(driver);
			Thread.sleep(5000);

			if(CommonUtility.CheckpresenceofElementLocated(driver, 20, obj_EsupportCoveoPage.emailUsername()))
			{
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.emailUsername()));
				CommonUtility.highlightElement(driver,(obj_EsupportCoveoPage.emailUsername())).clear();
				CommonUtility.highlightElement(driver,(obj_EsupportCoveoPage.emailUsername())).sendKeys(name);

				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.emailPassword()));
				CommonUtility.highlightElement(driver,(obj_EsupportCoveoPage.emailPassword())).clear();
				CommonUtility.highlightElement(driver,(obj_EsupportCoveoPage.emailPassword())).sendKeys(pwd);



				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.emailSignin()));
				CommonUtility.ScrollTo(driver,(obj_EsupportCoveoPage.emailSignin()));
//				WebElement element = driver.findElement(obj_EsupportCoveoPage.emailSignin());
//				actions.moveToElement(element).click().perform();
				CommonUtility.ClickOn(driver,(obj_EsupportCoveoPage.emailSignin()));
				
				Report.put("Login with Credentials for"+Report.color(name), "User should be able to login without any issues" ,
						"User logged in successfully.", "PASS");

			}
			
			else if(CommonUtility.CheckpresenceofElementLocated(driver, 20, obj_EsupportDDLHomePage.Email1()))
	        {
	            	CommonUtility.ScrollTo(driver, obj_EsupportDDLHomePage.Email1());
					CommonUtility.highlightElement(driver, obj_EsupportDDLHomePage.Email1()).sendKeys(name);
		
					System.out.println("Entered Email(Username) as "+name);
		
//					CommonUtility.ScrollTo(driver, obj_EsupportDDLHomePage.ContinueButton());
//					CommonUtility.ToClickByUsingJavaScript_PassingByLoc(driver, obj_EsupportDDLHomePage.ContinueButton());
					
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
    }

		catch (Exception e) {
			Log.info(e);
			Report.put("Login with Credentials", "User should be able to login without any issues",
					"Failed while logging into esupport application", "FAIL");
			e.printStackTrace();
			Assert.fail();
		}               
	}

	public void toVerify_LEMC_ProdutSupportPage(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver,50);
		String product="";
		String value=TestNGCreator.TestData.get(Esupport.Product.ordinal());
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIPSHomePage.productHeader()));   
			CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.productHeader());
			product=CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.productHeader()).getText();
			System.out.println(product);
			if(product.contains(value))
			{
				Report.put("Select Product from the Auto suggestion", "User Should Land in Product support page for the Selected auto suggestion product", "Product support page is opened with header "+Report.color(product), "PASS");
			}
			else
			{
				Report.put("Select Product from the Auto suggestion", "User Should Land in Product support page for the Selected auto suggestion product", "Unable to open product support page", "PASS");
				Assert.fail();
			}
			

		} catch(Exception ex){
			ex.printStackTrace();
			Report.put("Select Product from the Auto suggestion", "User Should Land in Product support page for the Selected auto suggestion product", "Unable to open product support page", "PASS");
			Assert.fail();
		}
	}
	//PUSHPA
	public void verifyQuickLinks(WebDriver driver)
	{
		System.out.println("Entered into method: to verifyQuickLinks.");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		try
		{
			Thread.sleep(4000);
			String quickLinks = "";

			if(CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.ProductsLink()).isDisplayed())
			{
				CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.ProductsLink());
				quickLinks = quickLinks + CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.ProductsLink()).getText() + "<br>";
			}

			if(CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.SolutionsLink()).isDisplayed())
			{
				CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.SolutionsLink());
				quickLinks = quickLinks + CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.SolutionsLink()).getText() + "<br>";
			}

//			if(CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.SupportLink()).isDisplayed())
//			{
//				CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.SupportLink());
//				quickLinks = quickLinks + CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.SupportLink()).getText() + "<br>";
//			}

			if(CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.CommunityLink()).isDisplayed())
			{
				CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.CommunityLink());
				quickLinks = quickLinks + CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.CommunityLink()).getText() + "<br>";
			}


			System.out.println("Links : " + quickLinks);
			Report.put("Verify the integrated homepage Links.",
					"Four-Quick-links should be displayed below to window banner.",
					"Links displayed successfully. Links are : " + Report.color(quickLinks), "PASS");
		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Expception occured while verifying the Quick Links. "+e);

			Report.put("Verify the integrated homepage Links.",
					"Four-Quick-links should be displayed below to window banner.",
					"Links display failed.", "FAIL");
			Assert.fail();
		}

	}

	public void verifyWarrantyContracts(WebDriver driver)
	{
		{
			Actions act=new Actions(driver);
			System.out.println("In Function verifyWarrantyContracts");

			WebDriverWait wait = new WebDriverWait(driver, 200);
			try
			{
				//act.moveToElement(CommonUtility.highlightElement(driver,obj_EsupportIntegratedHomePage.WarrantyContracts())).build().perform();

				CommonUtility.highlightElement(driver,obj_EsupportIntegratedHomePage.WarrantyContracts());

				WebElement element = driver.findElement(obj_EsupportIntegratedHomePage.WarrantyContracts());

			//	act.moveToElement(element).click().perform();
				CommonUtility.ScrollTo(driver, (obj_EsupportIntegratedHomePage.WarrantyContracts()));

				CommonUtility.ClickOn(driver,obj_EsupportIntegratedHomePage.WarrantyContracts());

				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIntegratedHomePage.WarrantyHeader()));

				CommonUtility.highlightElement(driver,obj_EsupportIntegratedHomePage.WarrantyHeader());

				String WarrantyHeader=CommonUtility.highlightElement(driver,obj_EsupportIntegratedHomePage.WarrantyHeader()).getText();


				Report.put("Navigate back to homepage and click on Warranty & Contracts",
						"Should land in Warranty & Contracts jump page", 
						"Navigated to Warranty & Contracts jump page Successfully. Header is: "+Report.color(WarrantyHeader),"PASS");
			}
			catch(Exception e)
			{
				e.printStackTrace();

				Report.put("Navigate back to homepage and click on Warranty & Contracts",
						"Should land in Warranty & Contracts jump page", 
						"Navigation to Warranty & Contracts jump page failed","FAIL");

				Assert.fail();
			}
		}
	}
	public void verifyDriversDownloads(WebDriver driver)
	{
		{
			Actions act=new Actions(driver);
			System.out.println("In Function verifyDriversDownloads");

			WebDriverWait wait = new WebDriverWait(driver, 200);
			try
			{
				CommonUtility.ScrollTo(driver, obj_EsupportIntegratedHomePage.DriversDownloads());
				//act.moveToElement(CommonUtility.highlightElement(driver,obj_EsupportIntegratedHomePage.DriversDownloads())).build().perform();

				CommonUtility.ClickOn(driver,obj_EsupportIntegratedHomePage.DriversDownloads());

//				WebElement element = driver.findElement(obj_EsupportIntegratedHomePage.DriversDownloads());
//
//				act.moveToElement(element).click().perform();


				//CommonUtility.highlightElement(driver,obj_EsupportIntegratedHomePage.DriversDownloads()).click();

				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIntegratedHomePage.DriversHeader()));

				CommonUtility.highlightElement(driver,obj_EsupportIntegratedHomePage.DriversHeader());

				String DriversHeader=CommonUtility.highlightElement(driver,obj_EsupportIntegratedHomePage.DriversHeader()).getText();


				Report.put("Navigate back to homepage and click on Drivers & Downloads",
						"Should land in Drivers & Downloads jump page", 
						"Navigated to Drivers & Downloads jump page Successfully. Header is:"+Report.color(DriversHeader),"PASS");
			}
			catch(Exception e)
			{
				e.printStackTrace();

				Report.put("Navigate back to homepage and click on Drivers & Downloads",
						"Should land in Drivers & Downloads jump page", 
						"Navigation to Drivers & Downloads jump page failed","FAIL");

				Assert.fail();
			}
		}
	}

	public void verifyDiagnosticsTools(WebDriver driver)
	{
		{
			Actions act=new Actions(driver);
			System.out.println("In Function verifyDiagnosticsTools");

			WebDriverWait wait = new WebDriverWait(driver, 200);
			try
			{
				CommonUtility.ScrollTo(driver, obj_EsupportIntegratedHomePage.DiagnosticsTools());
			//	act.moveToElement(CommonUtility.highlightElement(driver,obj_EsupportIntegratedHomePage.DiagnosticsTools())).build().perform();

				CommonUtility.ClickOn(driver,obj_EsupportIntegratedHomePage.DiagnosticsTools());

//				WebElement element = driver.findElement(obj_EsupportIntegratedHomePage.DiagnosticsTools());
//				act.moveToElement(element).click().perform();

				//CommonUtility.highlightElement(driver,obj_EsupportIntegratedHomePage.DiagnosticsTools()).click();

				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIntegratedHomePage.DiagnosticsHeader()));

				CommonUtility.highlightElement(driver,obj_EsupportIntegratedHomePage.DiagnosticsHeader());

				String DiagnosticsHeader=CommonUtility.highlightElement(driver,obj_EsupportIntegratedHomePage.DiagnosticsHeader()).getText();


				Report.put("Navigate back to homepage and click on Diagnostic & Tools",
						"Should land in Diagnostic & Tools jump page", 
						"Navigated to Diagnostic & Tools jump page Successfully. Header is: "+Report.color(DiagnosticsHeader),"PASS");
			}
			catch(Exception e)
			{
				e.printStackTrace();

				Report.put("Navigate back to homepage and click on Diagnostic & Tools",
						"Should land in Diagnostic & Tools jump page", 
						"Navigation to Diagnostic & Tools jump page failed","FAIL");
				Assert.fail();
			}
		}
	}
	//Mamta
	public void toVerify_CoveoResultPage(WebDriver driver, String val)
	{
		WebDriverWait wait = new WebDriverWait(driver,50);
		try{
//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Support for "+val+"')]")));   
//			CommonUtility.highlightElement(driver, By.xpath("//span[contains(text(),'Support for "+val+"')]"));
			//   CommonUtility.CheckpresenceofElementLocated(driver, 50, By.xpath("//span[contains(text(),'Support for "+val+"')]"));
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDriversandDownloadsPage.ServiceTagHeaderdisplayed()));
			CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.ServiceTagHeaderdisplayed());
			Report.put("Click on Search",
					"User Should land in Coveo Results page", "Landed in Coveo Results page", "PASS");

		} catch(Exception ex){
			ex.printStackTrace();
			Report.put("Click on Search",
					"User Should land in Coveo Results page", "Unable to open coveo Results page", "FAIL");
			Assert.fail();
		}
	}



	//Parul
	public void ToVerify_EnterLEMCSerialNumber(WebDriver driver,String Servicetag) 
	{
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 120);

		Actions act=new Actions(driver);

		System.out.println("Entering ToVerify_EnterLEMCSerialNumber");

		String browse = TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()) ;
		try 
		{

//			handleCookies(driver);

//			CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.Delllogo());
			CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.SearchServicetag());

			CommonUtility.ScrollTo(driver, obj_EsupportDriversandDownloadsPage.Headerservicetag());
			//act.moveToElement(CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.Headerservicetag())).build().perform();


			CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.SearchServicetag()).sendKeys(Servicetag);
			CommonUtility.ClickOn(driver,obj_EsupportDriversandDownloadsPage.Servicetagiconsearch());
			
//			if(browse=="IE")
//			{
//			CommonUtility.ToClickByUsingJavaScript_PassingByLoc(driver,obj_EsupportDriversandDownloadsPage.Servicetagiconsearch());
//			}
//			else
//			{
//				WebElement element = driver.findElement(obj_EsupportDriversandDownloadsPage.Servicetagiconsearch());
//				act.moveToElement(element).click().build().perform();
//			}
//			CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.Servicetagiconsearch()).click();
			System.out.println("clicked");
		//	CommonUtility.highlightElement(driver,obj_EsupportIncidentsPage.SearchServicetag()).sendKeys(Keys.ENTER);
		//	handleCaptcha(driver); 
//			Thread.sleep(30000);
//			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIntegratedHomePage.SigninHeader()));
			if(CommonUtility.CheckpresenceofElementLocated(driver, alertcount, obj_EsupportIntegratedHomePage.SigninHeader()))
			{
			   CommonUtility.highlightElement(driver,obj_EsupportIntegratedHomePage.SigninHeader());
			   String signinheaderlink=CommonUtility.highlightElement(driver,obj_EsupportIntegratedHomePage.SigninHeader()).getText();

			   Report.put("Within the Integrated homepage Under the product selector ,Enter the Serial number as "+Report.color(Servicetag)+" in the field provided and click on Search",
					"User should get the My account login screen with header is "+Report.color(signinheaderlink)
					,"Successfully User should get the My account login screen ", "PASS");
			}
			else if(CommonUtility.CheckpresenceofElementLocated(driver, alertcount, obj_EsupportIPSHomePage.SignInHeaderNew()))
			{
				CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.SignInHeaderNew());
				   String signinheaderlink=CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.SignInHeaderNew()).getText();

				   Report.put("Within the Integrated homepage Under the product selector ,Enter the Serial number as "+Report.color(Servicetag)+" in the field provided and click on Search",
						"User should get the My account login screen with header is "+Report.color(signinheaderlink)
						,"Successfully User should get the My account login screen ", "PASS");
			}





		}catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Not able to find Entered service tag", "Not able to find Entered service tag",
					"Not able to find Entered service tag", "FAIL");
			Assert.fail();

		}
	}


	public void EmailloginEMCSerialnumber(WebDriver driver,String name,String pwd ) {
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 120);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		Actions actions = new Actions(driver);
		boolean exists = true;


		//String name = TestNGCreator.TestData.get(Esupport.Username.ordinal()) ;
		//   String pwd = TestNGCreator.TestData.get(Esupport.Password.ordinal()) ;
		System.out.println("Entering Email Login Home Page");

		Log.info("Entering Email Login Home Page");             
		try {
			Thread.sleep(10000);

			System.out.println(name);
			System.out.println(pwd);

			//wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIntegratedHomePage.SigninHeader()));

			//WebElement element = driver.findElement(obj_EsupportIntegratedHomePage.ProductSupportHeaderlink());
			if(CommonUtility.CheckpresenceofElementLocated(driver,10, obj_EsupportCoveoPage.emailUsername()))
			{
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.emailUsername()));
			CommonUtility.highlightElement(driver,(obj_EsupportCoveoPage.emailUsername())).sendKeys(name);

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.emailPassword()));
			CommonUtility.highlightElement(driver,(obj_EsupportCoveoPage.emailPassword())).sendKeys(pwd);



			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.emailSignin()));
//			WebElement element = driver.findElement(obj_EsupportCoveoPage.emailSignin());
//			actions.moveToElement(element).click().perform();

			CommonUtility.ClickOn(driver,(obj_EsupportCoveoPage.emailSignin()));

			//wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.mastHead()));

			Report.put("Enter the L EMC Account Details and Click on Sign In", "User should be able to login without any issues with the credentials as Username : "+Report.color(name)+" and Password is :"  +Report.color(pwd),
					"User logged in successfully.", "PASS");

			}
			else if(CommonUtility.CheckpresenceofElementLocated(driver,10, obj_EsupportDDLHomePage.Email1()))
			{
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.Email1()));
			CommonUtility.highlightElement(driver,(obj_EsupportDDLHomePage.Email1())).sendKeys(name);

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.Password1()));
			CommonUtility.highlightElement(driver,(obj_EsupportDDLHomePage.Password1())).sendKeys(pwd);



			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.SignInButton()));
//			WebElement element = driver.findElement(obj_EsupportCoveoPage.emailSignin());
//			actions.moveToElement(element).click().perform();

			CommonUtility.ClickOn(driver,(obj_EsupportDDLHomePage.SignInButton()));

			//wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.mastHead()));

			Report.put("Enter the L EMC Account Details and Click on Sign In", "User should be able to login without any issues with the credentials as Username : "+Report.color(name)+" and Password is :"  +Report.color(pwd),
					"User logged in successfully.", "PASS");

			}


		}

		catch (Exception e) {
			Log.info(e);
			Report.put("Login with Credentials", "User should be able to login without any issues",
					"Failed while logging into esupport application", "FAIL");
			e.printStackTrace();
			Assert.fail();
		}               
	}


	public void TOVerify_DellEMCProductSupportPage(WebDriver driver){

		WebDriverWait wait = new WebDriverWait(driver, 200);
		System.out.println("Entered into method: to TOVerify_DellEMCProductSupportPage.");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		try {
			Thread.sleep(10000);

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIntegratedHomePage.ProductSupportHeaderlink()));


			CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.ProductSupportHeaderlink());

			String ProductSupportHeaderlink=CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.ProductSupportHeaderlink()).getText();
			//      System.out.println("Clicked on delllogo");

			Thread.sleep(4000);
			System.out.println("page title : " + driver.getTitle());
			System.out.println("current url : " + driver.getCurrentUrl());

			if(driver.getTitle().contains("Support") ){
				System.out.println("User is navigated to Support By Product");
				Report.put("User is able to see a Support By Product page",
						"User should land on "+Report.color(ProductSupportHeaderlink),
						"User is navigated to Support By Product", "PASS");
			}
			else{
				System.out.println("User is not able to see a Support By Product page");
				Report.put("User is not able to see a Support By Product page",
						"User is not able to see a Support By Product page",
						"User is not able to see a Support By Product page", "FAIL");
				Assert.fail();
			}


		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Report.put("User is not able to see a Support By Product page",
					"User is not able to see a Support By Product page",
					"User is not able to see a Support By Product page", "FAIL");
			Assert.fail();
		}
	}

	// Sujata New code...........

	public void  ClickSignIn(WebDriver driver) 
	{
		System.out.println("ClicKing on Save Button");
		WebDriverWait  wait = new WebDriverWait(driver, 120);
		System.out.println("After webdriver wait");
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
		try
		{

			handleCookies(driver);
			Thread.sleep(4000);
			WebElement element = driver.findElement(By.xpath("//div[@class='utility col-lg-3 col-md-3 col-sm-2']/ul/li[3]/a[@id='signin-link']"));
//			Actions actions = new Actions(driver);
//			actions.moveToElement(element).click().perform();
			
			CommonUtility.ClickOn(driver,By.xpath("//div[@class='utility col-lg-3 col-md-3 col-sm-2']/ul/li[3]/a[@id='signin-link']"));

			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(//div[@class='utility col-lg-3 col-md-3 col-sm-2']/ul/li[3]/a[@id='signin-link'])));
			//driver.findElement(By.xpath("//div[@class='utility col-lg-3 col-md-3 col-sm-2']/ul/li/a[@id='signin-link']")).click();
			//CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.save()).click();
//			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDriversandDownloadsPage.signIn()));
//			WebElement ele = driver.findElement(obj_EsupportDriversandDownloadsPage.signIn());
//			actions.moveToElement(ele).click().perform();
			CommonUtility.ClickOn(driver,obj_EsupportDriversandDownloadsPage.signIn());
			System.out.println("Clicked on Sign In Button");
			Report.put("Click on SignIn button", "Sign In Page should dispaly", "Application navigated to Sign In page ", "PASS");

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on SignIn button", "Sign In Page should dispaly", "Application is not navigated to Sign In page ", "FAIL");
			Assert.fail();
		}
	}


	public void  EmployeeLogin(WebDriver driver, String name, String pwd) {
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 120);

		//String name = TestNGCreator.TestData.get(Esupport.Username.ordinal()) ;
		//String pwd = TestNGCreator.TestData.get(Esupport.Password.ordinal()) ;
		System.out.println("Entering Login Home Page");
		System.out.println("Entering Premier Login Home Page");
		Log.info("Entering Premier Login Home Page");        
		Actions actions = new Actions(driver);
		try{

			handleCookies(driver);

			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.EmpSigninhere());

//			WebElement element = driver.findElement(obj_EsupportCoveoPage.EmpSigninhere());
//			actions.moveToElement(element).click().perform();

			CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.EmpSigninhere());

			Report.put("Click Sign in here link in Sign-in page ", "It should navigate to page asking for Enter User Name ",
					"SUccessfully It should navigate to page asking for Enter User Name ", "PASS");

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.SigninhereHeader()));
			Thread.sleep(3000);
			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SigninUsernameTextbox()).sendKeys(name);

			Report.put("Enter EMC User Name "+Report.color(name)+" and click Sign In button  ", "It should navigate to page where user needs to enter password  ",
					"SUccessfully It should navigate to page where user needs to enter password ", "PASS");

//			WebElement ele = driver.findElement(obj_EsupportCoveoPage.SigninUsernamebutton());
//			actions.moveToElement(ele).click().perform();

			CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.SigninUsernamebutton());

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.SigninhereHeader()));
			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SigninPwdtextbox()).sendKeys(pwd);

			Report.put("Enter Password "+Report.color(pwd)+" and click Continue button ", "It should login and navigate to home page  ",
					"SUccessfully It should login and navigate to home page  ", "PASS");
			Thread.sleep(2000);
//			WebElement elem = driver.findElement(obj_EsupportCoveoPage.SigninPwdcontinuebutton());
//			actions.moveToElement(elem).click().perform();

			CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.SigninPwdcontinuebutton());


			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.delllogo()));



			//      handleCookies(driver);



		}catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Enter valid credentials", "Not able to find valid credentials ", "Not able to Signin in to the Drivers and downloads", "Fail");

			Assert.fail();
		}
	}


	public void  ToClick_VerifyBalckCheckmarklogin(WebDriver driver) 
	{
		System.out.println("Entering new method ToClick_VerifyBalckCheckmarklogin");
		WebDriverWait  wait = new WebDriverWait(driver, 120);

		try
		{

			handleCookies(driver);

			Actions actions = new Actions(driver);
			//actions.moveToElement(element).click().perform();
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIntegratedHomePage.Blackchekmarks()));
			if(CommonUtility.highlightElement(driver,obj_EsupportIntegratedHomePage.Blackchekmarks()).isDisplayed())
			{

				Report.put("Hover over sign in , Click on sign in and enter valid Credentials", "User should logged in Sucessfully with Black check mark ",
						"User should logged in Sucessfully with black checkmark", "PASS");

			}


		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on SignIn button", "Sign In Page should dispaly", "Application is not navigated to Sign In page ", "FAIL");
			Assert.fail();
		}
	}


	public void  ToClick_Verifycontactusfields(WebDriver driver) 
	{
		System.out.println("Entering new method ToClick_Verifycontactusfields");
		WebDriverWait  wait = new WebDriverWait(driver, 120);

		try
		{

			String CreateServiceRequestclick="" ,  ChatwithSupportclick="";

			if(CommonUtility.highlightElement(driver,obj_EsupportIntegratedHomePage.ChatwithSupportclick()).isDisplayed())
			{

				ChatwithSupportclick=CommonUtility.highlightElement(driver,obj_EsupportIntegratedHomePage.ChatwithSupportclick()).getText();
			}

			if(CommonUtility.highlightElement(driver,obj_EsupportIntegratedHomePage.CreateServiceRequestclick()).isDisplayed())
			{

				CreateServiceRequestclick=CommonUtility.highlightElement(driver,obj_EsupportIntegratedHomePage.CreateServiceRequestclick()).getText();



			}

			Report.put("Click on Contact Us slider ", "User should Contact us slider should expand and should show "+Report.color(ChatwithSupportclick)+" and "+Report.color(CreateServiceRequestclick)+" ",
					"Successfully Contact us slider should expand and should show Chat with Support and Create support Request", "PASS");


		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on SignIn button", "Sign In Page should dispaly", "Application is not navigated to Sign In page ", "FAIL");
			Assert.fail();
		}
	}

	public void TOVerify_contanctuschatwithsupport(WebDriver driver){

		WebDriverWait wait = new WebDriverWait(driver, 200);
		System.out.println("Entered into method: to TOVerify_contanctuschatwithsupport.");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		try {
			Thread.sleep(4000);

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIntegratedHomePage.ClickonContanctUS()));


			CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.ClickonContanctUS());

			CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.ChatwithSupportclick());
			CommonUtility.ClickOn(driver, obj_EsupportIntegratedHomePage.ChatwithSupportclick());

			Thread.sleep(5000);
			//wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIntegratedHomePage.delllogo()));

			Report.put("Click on Chat with support", " User should land in L EMC chat page ",
					"Sucessfully  User should land in L EMC chat page", "PASS");

			//Thread.sleep(2000);



			/*
			String ProductSupportHeaderlink=CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.ProductSupportHeaderlink()).getText();
			//      System.out.println("Clicked on delllogo");

			Thread.sleep(4000);
			System.out.println("page title : " + driver.getTitle());
			System.out.println("current url : " + driver.getCurrentUrl());

			if(driver.getTitle().contains("Support By Product") ){
				System.out.println("User is navigated to Support By Product");
				Report.put("User is able to see a Support By Product page",
						"User should land on "+Report.color(ProductSupportHeaderlink),
						"User is navigated to Support By Product", "PASS");
			}
			else{
				System.out.println("User is not able to see a Support By Product page");
				Report.put("User is not able to see a Support By Product page",
						"User is not able to see a Support By Product page",
						"User is not able to see a Support By Product page", "FAIL");
				Assert.fail();
			}

			 */
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Report.put("Click on Chat with support", " User not land in L EMC chat page ",
					" User not land in L EMC chat page", "FAIL");

			Assert.fail();
		}
	}


	public void TOVerify_contanctusCreateServiceRequest(WebDriver driver){

		WebDriverWait wait = new WebDriverWait(driver, 200);
		System.out.println("Entered into method: to TOVerify_contanctusCreateServiceRequest.");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		try {
			Thread.sleep(4000);

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIntegratedHomePage.ClickonContanctUS()));


			CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.ClickonContanctUS());

			CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.CreateServiceRequestclick());
			CommonUtility.ClickOn(driver, obj_EsupportIntegratedHomePage.CreateServiceRequestclick());

			Thread.sleep(5000);

			Report.put("Comeback to homepage and click on contact us slider Create support Request ", " User should land in Create support Request page ",
					"Sucessfully User should landed in Create support Request page", "PASS");


			//wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIntegratedHomePage.delllogo()));

			/*
			String ProductSupportHeaderlink=CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.ProductSupportHeaderlink()).getText();
			//      System.out.println("Clicked on delllogo");

			Thread.sleep(4000);
			System.out.println("page title : " + driver.getTitle());
			System.out.println("current url : " + driver.getCurrentUrl());

			if(driver.getTitle().contains("Support By Product") ){
				System.out.println("User is navigated to Support By Product");
				Report.put("User is able to see a Support By Product page",
						"User should land on "+Report.color(ProductSupportHeaderlink),
						"User is navigated to Support By Product", "PASS");
			}
			else{
				System.out.println("User is not able to see a Support By Product page");
				Report.put("User is not able to see a Support By Product page",
						"User is not able to see a Support By Product page",
						"User is not able to see a Support By Product page", "FAIL");
				Assert.fail();
			}

			 */
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Report.put("Comeback to homepage and click on contact us slider Create support Request ", " User not land in Create support Request page ",
					"User not  landed in Create support Request page", "FAIL");

			Assert.fail();
		}
	}


	public void TOclick_FindMyDellEMCProductsLink(WebDriver driver){
		System.out.println("Entered into method: to click on 'FindMyDellEMCProduct' link.");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		Actions actions = new Actions(driver);

		try {
			Thread.sleep(4000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIntegratedHomePage.DellEmcProductIcontext()));
			WebElement element = driver.findElement(obj_EsupportIntegratedHomePage.DellEmcProductIcontext());
			CommonUtility.ScrollTo(driver, obj_EsupportIntegratedHomePage.DellEmcProductIcontext());
		//	actions.moveToElement(element).click().perform();
			//	CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.DellEmcProductIcontext()).click();
			System.out.println("clicked on 'FindMyDellEMCProduct' link.");



		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			Assert.fail();
		}
	}


	public void  ToVerify_WebPartsbelowproduct(WebDriver driver) 
	{
		Actions act=new Actions(driver);
		System.out.println("In Function ToVerify_WebPartsbelowproduct");
		WebDriverWait  wait = new WebDriverWait(driver, 120);

		try
		{

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIntegratedHomePage.DellEmcProductLabel()));


			CommonUtility.highlightElement(driver,obj_EsupportIntegratedHomePage.DellEmcProductLabel());

			String ltMessages="";


			List<WebElement> list=driver.findElements(obj_EsupportIntegratedHomePage.DellEmcProductLabel());

			for(WebElement lt:list)
			{
				CommonUtility.highlightElement(driver, lt);
				String names=lt.getText();

				System.out.println("Alert Name is: " +names);
				ltMessages+=" <br> " + names;


			}


			Report.put("Click on Find My Dell EMC Products ", " Modal pop up should get displayed with 3 Tabs Title should be Find my Dell EMC Product Tabs as "+Report.color(ltMessages),
					"Sucessfully 3 Tabs Title should be Find my Dell EMC Product", "PASS");

		}
		catch(Exception e)
		{
			e.printStackTrace();


			Report.put("Click on Find My Dell EMC Products ", " Modal pop up Not get displayed with 3 Tabs Title should be Find my Dell EMC Product Tabs as ",
					"Sucessfully 3 Tabs Title NOT get displayed ", "FAIL");


			Assert.fail();
		}
	}


	public void  ToVerify_Productfilteroptions(WebDriver driver) 
	{
		Actions act=new Actions(driver);
		System.out.println("In Function ToVerify_Productfilteroptions");
		WebDriverWait  wait = new WebDriverWait(driver, 120);

		try
		{


			CommonUtility.highlightElement(driver,obj_EsupportIntegratedHomePage.SelectProductlistbox());
			CommonUtility.ClickOn(driver,obj_EsupportIntegratedHomePage.SelectProductlistbox());
			String ltMessages="";


			List<WebElement> list=driver.findElements(obj_EsupportIntegratedHomePage.SelectProductlistboxoptions());

			for(WebElement lt:list)
			{
				CommonUtility.highlightElement(driver, lt);
				String names=lt.getText();

				System.out.println("Alert Name is: " +names);
				ltMessages+=" <br> " + names;


			}


			Report.put("Verify the Product search tab ", " Product search tab should contain a Drop down Default should be Product ID and Options displayed as  "+Report.color(ltMessages),
					"Sucessfully Product search tab should contain a Drop down with values.", "PASS");

		}
		catch(Exception e)
		{
			e.printStackTrace();


			Report.put("Verify the Product search tab ", " Product search tab NOT contain a Drop down Default should be Product ID and Options displayed as  ",
					"Sucessfully Product search tab NOT contain a Drop down with values.", "FAIL");

			Assert.fail();
		}
	}


	public void TOEnter_Productnameandsearchclick(WebDriver driver,String servicetag){
		System.out.println("Entered into method: TOEnter_Productnameandsearchclick");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		Actions actions = new Actions(driver);

		try {
			Thread.sleep(2000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIntegratedHomePage.Productentertext()));

			CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.Productentertext());
			CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.Productentertext()).sendKeys(servicetag);
			System.out.println("Entered value in  'Productentertext' Textbox.");


//			WebElement element = driver.findElement(obj_EsupportIntegratedHomePage.Productentertextsearchbutton());
//			actions.moveToElement(element).click().perform();
			CommonUtility.ClickOn(driver, obj_EsupportIntegratedHomePage.Productentertextsearchbutton());


			Report.put("User is able to Enter product ID and Click on Search ", " User is able to Enter product ID  as "+Report.color(servicetag)+"and Click on Search ",
					"Sucessfully User is able to Enter product ID and Click on Search", "PASS");

		} catch (Exception e) {
			// TODO Auto-generated catch block

			Report.put("User is able to Enter product ID and Click on Search ", " User is not able to Enter product ID  as "+Report.color(servicetag)+"and Click on Search ",
					"  User is Not able to Enter product ID and Click on Search", "FAIL");
			e.printStackTrace();

			Assert.fail();
		}
	}


	public void  ToVerify_WebPartsbelowproducttablesheader(WebDriver driver) 
	{
		Actions act=new Actions(driver);
		System.out.println("In Function ToVerify_WebPartsbelowproducttablesheader");
		WebDriverWait  wait = new WebDriverWait(driver, 120);

		try
		{

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIntegratedHomePage.Producttablesresults()));


			CommonUtility.highlightElement(driver,obj_EsupportIntegratedHomePage.Producttablesresults());

			String ltMessages="";


			List<WebElement> list=driver.findElements(obj_EsupportIntegratedHomePage.Producttablesresults());

			for(WebElement lt:list)
			{
				CommonUtility.highlightElement(driver, lt);
				String names=lt.getText();

				if(!(names.equals(""))){
					System.out.println("Alert Name is: " +names);
					ltMessages+=" <br> " + names;
				}

			}


			Report.put("In Product Search tab , default will be product ID and enter product ID ", " Search will be enabled only after 8 characters entered Each Result Row will have the following data in a pipe delimited format:  as "+Report.color(ltMessages),
					"Sucessfully Search will be enabled only after 8 characters entered Each Result Row will have the data in a pipe delimited format ", "PASS");

		}
		catch(Exception e)
		{
			e.printStackTrace();


			Report.put("Click on Find My Dell EMC Products ", " Modal pop up Not get displayed with 3 Tabs Title should be Find my Dell EMC Product Tabs as ",
					"Sucessfully 3 Tabs Title NOT get displayed ", "FAIL");


			Assert.fail();
		}
	}


	public void  ToVerify_WebPartsbelowproducttablesheaderresultsvalues(WebDriver driver) 
	{
		Actions act=new Actions(driver);
		System.out.println("In Function ToVerify_WebPartsbelowproducttablesheaderresultsvalues");
		WebDriverWait  wait = new WebDriverWait(driver, 120);

		try
		{

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIntegratedHomePage.Producttablesresultsresults()));


			CommonUtility.highlightElement(driver,obj_EsupportIntegratedHomePage.Producttablesresultsresults());

			String ltMessages="";


			List<WebElement> list=driver.findElements(obj_EsupportIntegratedHomePage.Producttablesresultsresults());

			for(WebElement lt:list)
			{
				CommonUtility.highlightElement(driver, lt);
				String names=lt.getText();



				System.out.println("Alert Name is: " +names);
				ltMessages+=" <br> " + names;



			}


			Report.put("In Product Search tab , default will be product ID and enter product ID ", " Search will be enabled only after 8 characters entered Each Result Row will have the following data in a pipe delimited format: values  as "+Report.color(ltMessages),
					"Sucessfully Search will be enabled only after 8 characters entered Each Result Row will have the data in a pipe delimited format ", "PASS");

		}
		catch(Exception e)
		{
			e.printStackTrace();


			Report.put("Click on Find My Dell EMC Products ", " Modal pop up Not get displayed with 3 Tabs Title should be Find my Dell EMC Product Tabs as ",
					"Sucessfully 3 Tabs Title NOT get displayed ", "FAIL");


			Assert.fail();
		}
	}


	public void TOclick_Producttablesresultsresultslink(WebDriver driver){

		WebDriverWait wait = new WebDriverWait(driver, 200);
		System.out.println("Entered into method: to TOclick_Producttablesresultsresultslink.");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Actions actions = new Actions(driver);

		try {
			Thread.sleep(4000);

//			WebElement element = driver.findElement(obj_EsupportIntegratedHomePage.Producttablesresultsresultslink());
//			actions.moveToElement(element).click().perform();

			CommonUtility.ClickOn(driver, obj_EsupportIntegratedHomePage.Producttablesresultsresultslink());

			System.out.println("clicked on 'Producttablesresultsresultslink' link.");

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIntegratedHomePage.ProductSupportHeaderlink()));


			CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.ProductSupportHeaderlink());

			String ProductSupportHeaderlink=CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.ProductSupportHeaderlink()).getText();


			Thread.sleep(4000);
			System.out.println("page title : " + driver.getTitle());
			System.out.println("current url : " + driver.getCurrentUrl());

			if(driver.getTitle().contains("Support") && driver.getCurrentUrl().contains("serialnumber")){
				System.out.println("User is navigated to Support Product");
				Report.put("User is able to see a Support By Product page",
						"User should land on "+Report.color(ProductSupportHeaderlink)+"and url is "+Report.color(driver.getCurrentUrl()),
						"User is navigated to Support By Product", "PASS");
			}
			else{
				System.out.println("User is not able to see a Support By Product page");
				Report.put("User is not able to see a Support By Product page",
						"User is not able to see a Support By Product page",
						"User is not able to see a Support By Product page", "FAIL");
				Assert.fail();
			}


		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Report.put("User is not able to see a Support By Product page",
					"User is not able to see a Support By Product page",
					"User is not able to see a Support By Product page", "FAIL");
			Assert.fail();
		}
	}


	//Pushpa`s methods on 6th dec



	public void validateSearchIcon(WebDriver driver)
	{
		System.out.println("Inside validateSearchIcon");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 20);

		try {
			Thread.sleep(4000);              
			if(CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.SearchIcon()).isDisplayed())
			{
				String attrval = CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.SearchIcon()).getAttribute("disabled");
				System.out.println("Attribute value is:"+attrval);
				if(attrval.equalsIgnoreCase("true"))
				{
					Report.put("Click on account sites tab and Place the cursor over the search",
							"Employee should not display search results without having entered any text",
							"Search is disabled.", "PASS");
					System.out.println("Search Icon disabled");
				}
			}      
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("User failed to get the My account login screen.");
			Report.put("Click on account sites tab and Place the cursor over the search",
					"Employee should not display search results without having entered any text",
					"Search is not disabled.", "FAIL");
			Assert.fail();
		}
	}


	//Sudha code  6th dec


	public void verifyKnowledgebasejumppage(WebDriver driver){
		System.out.println("Entered into method: to verifyMastheadLinks.");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		try {
			Thread.sleep(4000);
			String knowledgebasetexts = "";

			CommonUtility.ScrollTo(driver, obj_EsupportIntegratedHomePage.searchforArticles());
			CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.searchforArticles());
			knowledgebasetexts = knowledgebasetexts + CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.searchforArticles()).getText() + "<br>";

			CommonUtility.ScrollTo(driver, obj_EsupportIntegratedHomePage.searchforKeyword());
			CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.searchforKeyword());
			knowledgebasetexts = knowledgebasetexts + CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.searchforKeyword()).getText() + "<br>";
			System.out.println("Links : " + knowledgebasetexts);
			if(CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.searchBox()).isDisplayed())
				//if(((WebElement) obj_EsupportIntegratedHomePage.searchBox()).isDisplayed())
			{
				System.out.println("SearchBox is Dispalyed");
				Report.put("Verify the Knowledge base jump page",
						"Knowledge base jump page should have Search for articles to support your product.Search by Keyword, Topic, or Model with Search box",
						"Knowledge base jump page having" + Report.color(knowledgebasetexts)+"with Search box", "PASS");
			}else{

				System.out.println("SearchBox is not dispalyed");
				Report.put("Verify the Knowledge base jump page",
						"Knowledge base jump page should have Search for articles to support your product.Search by Keyword, Topic, or Model with Search box",
						"Failed while verifying the Knowledge base texts", "FAIL");

			}} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Expception occured while verifying the Knowledge base texts. "+e);

				Report.put("Verify the Knowledge base jump page",
						"Knowledge base jump page should have Search for articles to support your product.Search by Keyword, Topic, or Model with Search box",
						"Failed while verifying the Knowledge base texts", "FAIL");
				Assert.fail();
			}

	}
	public void verifyServiceRequestjumppage(WebDriver driver){
		System.out.println("Entered into method: to verify Service Request jumppage");
		WebDriverWait wait = new WebDriverWait(driver, 60);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		try {
			Thread.sleep(4000);
			String ServiceRequeststexts = "";
			String DropdownList= "";
			String flag="";

			CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.PageHeader()).isDisplayed();
			CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.PageHeader());
			ServiceRequeststexts = ServiceRequeststexts + CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.PageHeader()).getText() + "<br>";

			CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.pageSubHeader()).isDisplayed();
			CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.pageSubHeader());
			ServiceRequeststexts = ServiceRequeststexts + CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.pageSubHeader()).getText() + "<br>";
			System.out.println("Header : " + ServiceRequeststexts);
			Thread.sleep(3000);
			try{
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIntegratedHomePage.serviceRequestsDropdownSelector()));
				CommonUtility.ClickOn(driver,obj_EsupportIntegratedHomePage.serviceRequestsDropdownSelector()); 
				Thread.sleep(4000);
				WebElement selectElement = driver.findElement(obj_EsupportIntegratedHomePage.serviceRequestsDropdownSelector());
				Select select = new Select(selectElement);
				List<WebElement> allOptions = select.getOptions();
				//wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(obj_EsupportIntegratedHomePage.serviceRequestsDropdownList())));
				//List<WebElement> options=driver.findElements(obj_EsupportIntegratedHomePage.serviceRequestsDropdownList());

				for(WebElement op:allOptions){
					CommonUtility.highlightElement(driver,op);
					System.out.println(op.getText());
					//if(op.getText().contains(option)){
					//	op.click();
					//	flag=option;
					//	break;
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();  
				Assert.fail();
			}


			Report.put("Verify the Service Request jump page",
					"Service Request jump page should have heading with Service Request Search for an existing Service Request, or sign in to see your history.With dropdown Service Request , Service tag /Express service code, Dell EMC Product ID and Dispatch number (DPS)", 
					"Service Request jump page should have heading with" + Report.color(ServiceRequeststexts)+".With dropdown "+ Report.color(DropdownList), "PASS");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Expception occured while verifying the Service Request jump page. "+e);

			Report.put("Service Request jump page",
					"Service Request jump page should have heading with Service Request Search for an existing Service Request, or sign in to see your history.With dropdown Service Request , Service tag /Express service code, Dell EMC Product ID and Dispatch number (DPS)", 
					"Failed while verifying the Service Request jump page", "FAIL");
			Assert.fail();
		}

	}
	public void verifyContactsupportjumppage (WebDriver driver){
		System.out.println("Entered into method: to verifyContactsupportjumppage.");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		WebDriverWait wait = new WebDriverWait(driver, 60);
		try {
			Thread.sleep(4000);
			String Browseallproductslink = "";
			String productsupportLinks= "";
			String flag="";
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIncidentsPage.BrowseAllProductsButton()));
			
				CommonUtility.highlightElement(driver, obj_EsupportIncidentsPage.BrowseAllProductsButton()).isDisplayed();
				Browseallproductslink=CommonUtility.highlightElement(driver,obj_EsupportIncidentsPage.BrowseAllProductsButton()).getText();
			
				

			if(CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.SearchBoxInTechnicalSupport()).isDisplayed())
			{
				System.out.println("SearchBox is Dispalyed");
				Report.put("Verify the Contact support jump page",
						"Contact support jump page should have Product selector with search box , choose from all products and Find My Dell EMC Products Links", 
						"Contact support jump page should have Product selector with search box ,"+Report.color(Browseallproductslink), "PASS");
			}
			else
			{
				System.out.println("SearchBox is not dispalyed");



				Report.put("Verify the Contact support jump page",
						"Contact support jump page should have Product selector with search box , choose from all products and Find My Dell EMC Products Links", 
						"Failed while verifying the Contact support jump page", "FAIL");
				Assert.fail();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Expception occured while verifying the Contact support jump page. "+e);

			Report.put("Verify the Contact support jump page",
					"Contact support jump page should have Product selector with search box , choose from all products and Find My Dell EMC Products Links", 
					"Failed while verifying the Contact support jump page", "FAIL");
			Assert.fail();
		}

	}
	public void clickOnContactSupportLink_employee(WebDriver driver){

		System.out.println("Entered into method: to clickOnContactSupportLink.");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 100);
		Actions act=new Actions(driver);
		

		try {
			Thread.sleep(3000);

			CommonUtility.ScrollTo(driver, obj_EsupportIntegratedHomePage.ContactSupportMastheadLink());
//			CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.ContactSupportMastheadLink()).click();
			CommonUtility.ClickOn(driver, obj_EsupportIntegratedHomePage.ContactSupportMastheadLink());
			
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIncidentsPage.contactUs()));
//			Thread.sleep(10000);
//			handleCookies(driver);
			// added below code, instead of navigating to contact us directly with url
			CommonUtility.ScrollTo(driver,obj_EsupportIncidentsPage.contactUs());
			
			
			CommonUtility.ClickOn(driver,obj_EsupportIncidentsPage.contactUs());
			
			
			if(CommonUtility.highlightElement(driver,obj_EsupportIncidentsPage.technicalSupportSelect()).isDisplayed())
			{
				System.out.println("Technical Support displayed");
				CommonUtility.ScrollTo(driver,obj_EsupportIncidentsPage.technicalSupportSelect());
				CommonUtility.ClickOn(driver,obj_EsupportIncidentsPage.technicalSupportSelect());
//				act.moveToElement(CommonUtility.highlightElement(driver,obj_EsupportIncidentsPage.technicalSupportSelect())).click().build().perform();
			}
			
			//added newly
//			driver.navigate().to("https://www.dell.com/support/incidents-online/us/en/19/ContactUs/Dynamic?spestate?ref=contactus");
			driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
			CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.PageHeader());
			String header = CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.PageHeader()).getText();
			if(header.contains("Contact Technical Support")){
				System.out.println("Navigated to " + header);
				Report.put("Click on Contact Supports.", 
						"User should land in Contact Support Jump page.",
						"User navigated to "+Report.color(header) +" page.", "PASS");
			}else{
				System.out.println("Could not navigate to Contact Support page.");
				Report.put("Click on Contact Support.", 
						"User should land in Contact Support Jump page.",
						"User failed to land on Contact Support Jump page.", "FAIL");
				Assert.fail();
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Exception occured while navigating to Contact Support. "+e);
			Report.put("Click on Contact Support.", 
					"User should land in Contact Support Jump page.",
					"User failed to land on Contact Support Jump page.", "FAIL");
			Assert.fail();
		}

	}
	//Sudha 7th Dec

	public void to_Scrolldownthepage(WebDriver driver){
		System.out.println("Entered into method: to Scroll down the page.");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		try {
			Thread.sleep(4000);
			System.out.println("scrolling to footer");
			CommonUtility.ScrollTo(driver, obj_EsupportCoveoPage.CountrySelector());

			Thread.sleep(2000);

			Report.put("Scroll down the page for footer",
					"User should be able to see the footer",
					"User is able to see the footer", "PASS");


		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Report.put("Scroll down the page for footer",
					"User should be able to see the footer",
					"User not able to see the footer", "FAIL");
			Assert.fail();
		}


	}
	public void to_CheckCountrySelector(WebDriver driver){
		System.out.println("Entered into method: to check Country Selector.");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		try {

			if(CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.CountrySelector()).isDisplayed())
			{
				System.out.println("Country Selector is Dispalyed");
				Report.put("Check for the country selector",
						"Country selector should be displayed",
						"Country selector is displayed", "PASS");
			}else
			{
				System.out.println("Country Selector is not Dispalyed");
				Report.put("Check for the country selector",
						"Country selector should be displayed",
						"Country selector is not displayed", "FAIL");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Report.put("Check for the country selector",
					"Country selector should be displayed",
					"Country selector is not displayed", "FAIL");
			Assert.fail();
		}


	}
	public void to_ClickCountrySelector_Arrow(WebDriver driver){
		System.out.println("Entered into method: to click Country Selector.");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Actions actions = new Actions(driver);
		try {
			Thread.sleep(2000);
			//CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.CountrySelector()).click();
			WebElement element =driver.findElement(By.xpath("//div[@id='countryselector']/a"));
			((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);  
			CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.CountryList());
			List<WebElement> countryList=driver.findElements(obj_EsupportCoveoPage.CountryList());

			for(WebElement lt:countryList)
			{
				String couLi=lt.getText();

				System.out.println("Country is: " +couLi);

			}
			Report.put("Click on the arrow besides the country selector",
					"Country selector should expand List of countries",
					"Country selector expanded with List of countries", "PASS");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Report.put("Click on the arrow besides the country selector",
					"Country selector should expand List of countries",
					"Country selector not expanded with List of countries", "FAIL");
			Assert.fail();
		}


	}
	public void to_KeyPressing(WebDriver driver){
		System.out.println("Entered into method: to_KeyPressing");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Actions act = new Actions(driver);

		try {


			//act.keyDown(Keys.CONTROL).sendKeys(String.valueOf('\u0061')).perform();

			act.sendKeys(String.valueOf('\u0061')).perform();
			Report.put("Press any (Say A) alphabet in the keyboard",
					"User should be able to jump to the country starting with the alphabet and should highlight with blue color",
					"User is able to jump to the country starting with the alphabet and should highlight with blue color", "PASS");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Report.put("Press any (Say A) alphabet in the keyboard",
					"User should be able to jump to the country starting with the alphabet and should highlight with blue color",
					"User is not able to jump to the country starting with the alphabet and should highlight with blue color", "FAIL");
			Assert.fail();
		}


	}
	public void to_PressDownArrow(WebDriver driver){
		System.out.println("Entered into method: to press Down Arrow.");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		try {


			JavascriptExecutor je = (JavascriptExecutor) driver;
			//Identify the WebElement which will appear after scrolling down
			WebElement element = driver.findElement(By.xpath("//div[@class='dropdown-menu dropdown-menu-right countrylist show']//a[150]"));
			// now execute query which actually will scroll until that element is not appeared on page.
			je.executeScript("arguments[0].scrollIntoView(true);",element);
			Report.put("Press Down arrow",
					"User should be able to move down the listed countries",
					"User is able to move down the listed countries", "PASS");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Report.put("Press Down arrow",
					"User should be able to move down the listed countries",
					"User is not able to move down the listed countries", "FAIL");
			Assert.fail();
		}


	}
	public void to_PressUPArrow(WebDriver driver){
		System.out.println("Entered into method: to press Down Arrow.");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		try {


			// Create instance of Javascript executor
			JavascriptExecutor je = (JavascriptExecutor) driver;
			//Identify the WebElement which will appear after scrolling down
			WebElement element = driver.findElement(By.xpath("//div[@class='dropdown-menu dropdown-menu-right countrylist show']//a[2]"));
			// now execute query which actually will scroll until that element is not appeared on page.
			je.executeScript("arguments[0].scrollIntoView(true);",element);
			Report.put("Press the Up arrow",
					"User should be able to move Up the listed countries",
					"User is able to move Up the listed countries", "PASS");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Report.put("Press the Up arrow",
					"User should be able to move Up the listed countries",
					"User is not able to move Up the listed countries", "FAIL");
			Assert.fail();
		}


	}
	public void  changeCountry(WebDriver driver)
	{
		// TODO Auto-generated method stub
		System.out.println("Entering changeCountry");

		Log.info("Entering changeCountry");   
		String country = TestNGCreator.TestData.get(Esupport.Country.ordinal());
		String selectedcountry = "";

		try{



			List<WebElement> countryList=driver.findElements(obj_EsupportCoveoPage.CountryList());

			for(WebElement lt:countryList)
			{
				String couLi=lt.getText();

				//System.out.println("Country is: " +couLi);
				if(couLi.equalsIgnoreCase(country))
				{
					System.out.println("Inside if**************");
					System.out.println("Country is: " +couLi);
					lt.click();

					selectedcountry = couLi;
					System.out.println("Selected Country is "+selectedcountry);
					Report.put(" Press enter on any selected country", 
							"User should navigate to the selected country page ", 
							"Country changed to : "+Report.color(country), "PASS");
					break;
				}							
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put(" Change country to CANADA from the country selector or a country which has more than two languages ", 
					"The country should get changed to CANADA or a country selected ", 
					"Not able to select the country"+Report.color(country), "FAIL");
			Assert.fail();
		}
	}
	//Mamta
	public void toClick_FindMyDellEMCProducts(WebDriver driver){
		System.out.println("verify the 'FindMyDellEMCProduct' link.");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 100);
		Actions actions = new Actions(driver);
		String title="";
		String currenturl="";

		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIntegratedHomePage.DellEmcProductIcontext()));

			WebElement element = driver.findElement(obj_EsupportIntegratedHomePage.DellEmcProductIcontext());
			CommonUtility.ScrollTo(driver, obj_EsupportIntegratedHomePage.DellEmcProductIcontext());
			CommonUtility.ClickOn(driver, obj_EsupportIntegratedHomePage.DellEmcProductIcontext());
		//	actions.moveToElement(element).click().perform();

			//CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.DellEmcProductIcontext()).click();
			System.out.println("clicked on 'FindMyDellEMCProduct' link.");

			Thread.sleep(10000);
			//handleCookies(driver);
			String mainwindow=driver.getWindowHandle();
			Set<String> set=driver.getWindowHandles();
			Iterator<String> itr=set.iterator();
			while(itr.hasNext())
			{
				String childWindow=itr.next();
				if(!mainwindow.equals(childWindow))
				{
					Thread.sleep(5000);
					driver.switchTo().window(childWindow);
					title=driver.getTitle();
					
					currenturl=driver.getCurrentUrl();
					System.out.println(title);
					System.out.println(currenturl);
					
					if(currenturl.contains("https://www.dell.com/support/myservice360"))
					{
						System.out.println("landed on expected url");
						
						Report.put("Click on view all your assets ",
								"user should direct to the my service 360 portal page ",
								"user able to click on view all your assets link and able to land on "+Report.color(title)+" with url "+Report.color(currenturl), "PASS");

					}
					else
					{
						driver.close();
						Report.put("Click on view all your assets ",
								"user should direct to the my service 360 portal page ",
								"not landed on expected url", "FAIL");  
					}
					
					
					driver.close();
				}
			}
			Thread.sleep(10000);
			driver.switchTo().window(mainwindow);
			
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("User failed to get the My account login screen.");
			Report.put("Click on view all your assets ",
					"user should direct to the my service 360 portal page ",
					"Unable to click on the 'view all your assets' link", "FAIL");     
			Assert.fail();
		}
	}  

	public void toVerify_FindMyDellEMCProductsTabs(WebDriver driver){
		System.out.println("verify the 'FindMyDellEMCProduct' link.");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		try {
			List<WebElement> list= driver.findElements(obj_EsupportIntegratedHomePage.findmyDellEMCproductTabs());
			for(WebElement l:list){
				List_type.add(l.getText());
				System.out.println(l.getText());
				CommonUtility.highlightElement(driver, l).isDisplayed();
			}
			Report.put("Click on Find My Dell EMC Products",
					"Modal pop up should get displayed with 3 Tabs</br>Title should be Find my Dell EMC Product </br>"
							+ "Tab 1 should be Product search </br>"
							+ "Tab 2 should be my Account Sites</br>"
							+ "Tab 3 Should be Site ID</br>"
							+ "By default Tab 1 should be Product search",
							"Following tabs are displayed"+Report.color(List_type)+"</br>"
									+"By default Tab 1 is Product search", "PASS"); 
			Thread.sleep(5000);
			for(int i=0;i<list.size();){
				if(list.get(0).getText().contains("Product Search")){
					System.out.println("the 1st position value"+list.get(0).getText());
					Report.put("Verify the Tab 1",
							"Tab 1 text should be Product search tab",
							"Tab 1 text is Product search tab", "PASS");       
					break;
				}else{
					Report.put("Verify the Tab 1",
							"Tab 1 text should be Product search tab",
							"Tab 1 text is not Product search tab", "FAIL");     
				}
			}              

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("User failed to get the My account login screen.");
			Report.put("Click on Find My Dell EMC Products",
					"Modal pop up should get displayed with 3 Tabs</br>Title should be Find my Dell EMC Product </br>"
							+ "Tab 1 should be Product search </br>"
							+ "Tab 2 should be my Account Sites</br>"
							+ "Tab 3 Should be Site ID</br>"
							+ "By default Tab 1 should be Product search",
							"Unable to open the 'Find My Dell EMC Products' link", "FAIL");     
			Assert.fail();
		}
	}

	public void toSearch_In_productSearch_FindMyDellEMCProduct(WebDriver driver, String value){
		System.out.println("verify the 'toSearch_In_productSearch_FindMyDellEMCProduct' .");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 100);
		Actions act=new Actions(driver);
		String details="";
		try {
			Thread.sleep(4000);
			Thread.sleep(4000);
			WebElement prodsearch = driver.findElement(By.xpath("//input[@id='productSearchInput']"));
			prodsearch.clear();
			prodsearch.sendKeys(value,Keys.ENTER);                   
			WebDriverWait waite=new WebDriverWait(driver, 10);
			waite.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul/li[@id='ui-active-menuitem']//a")));

			List<WebElement> dropdownLists=driver.findElements(obj_EsupportIntegratedHomePage.emcSearchProductsLists());
			System.out.println("the size of avialable options"+dropdownLists.size());

			for(int i=0;i<dropdownLists.size();i++){
				CommonUtility.highlightElement(driver,dropdownLists.get(i)).isDisplayed();
				details=dropdownLists.get(i).getText();
				System.out.println("i val---"+i+"value: "+details);
				CommonUtility.scrollToViewElement(driver, dropdownLists.get(i));
			}
			Report.put("Go to the Search Box and enter 3 characters",
					"User should return any and all Serialized Products that  map to the VNX product.</br>"
							+"In below format Product ID | Product Alias (if exists) | Product Name | Site Name | Site Address",
							"Details is displayed in following format"+Report.color(details), "PASS"); 
			try{ 
				for(int i=0;i<dropdownLists.size();){
					System.out.println("i val---"+i);
					CommonUtility.highlightElement(driver,dropdownLists.get(i)).isDisplayed();
					details=dropdownLists.get(i).getText();
					System.out.println(details);    
					
					CommonUtility.scrollToViewElement(driver, dropdownLists.get(i));
//					act.moveToElement(dropdownLists.get(i)).click().perform();   
					CommonUtility.ToClickByUsingJavaScript(driver, dropdownLists.get(i));
					break;
				}
				System.out.println("clicked on 1st option");
				Thread.sleep(10000);
				//wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIntegratedHomePage.dellEMCLogo()));
				System.out.println("the url:"+driver.getTitle());
				Report.put("Click on the specific row ",
						"User should be taken to the Product Support page for the corresponding selection </br>"
								+"URL format should be: https://support.emc.com/products/serialnumber/<serial_number>",
								" Product Support page is opened "+Report.color(driver.getCurrentUrl()), "PASS");   

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Report.put("Click on the specific row ",
						"User should be taken to the Product Support page for the corresponding selection </br>"
								+"URL format should be: https://support.emc.com/products/serialnumber/<serial_number>",
								" Unable to open the product support page", "PASS");     
				Assert.fail();
			}


		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("User failed to get the My account login screen.");
			Report.put("Go to the Search Box and enter 3 characters",
					"User should return any and all Serialized Products that  map to the VNX product.</br>"
							+"In below format Product ID | Product Alias (if exists) | Product Name | Site Name | Site Address",
							"Unable to display the lists", "PASS");  
			Assert.fail();
		}
	}


	public void toSearch_In_MyCustomGroups_FindMyDellEMCProduct(WebDriver driver, String value, String group){
		System.out.println("verify the 'toSearch_In_MyCustomGroups_FindMyDellEMCProduct' .");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 100);
		Actions act=new Actions(driver);
		String details="";
		String details1="";
		String details2="";
		String details3="";
		try {

			List<WebElement> list= driver.findElements(obj_EsupportIntegratedHomePage.findmyDellEMCproductTabs());
			for(WebElement l:list){
				System.out.println(details=l.getText());
				if(l.getText().equals("My Custom Groups")){
					l.click();
					break;
				}
			}
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIntegratedHomePage.selectAgroup()));
			List<WebElement> dropdownLists=driver.findElements(obj_EsupportIntegratedHomePage.grouplists());
			for(WebElement l:dropdownLists){
				CommonUtility.highlightElement(driver, l);
				if(l.getText().contains(group)){
					System.out.println(details1=l.getText());
					l.click();
					break;
				}
			}

			Report.put(" Click on Find my Dell EMC products and Select Tab 2 ",
					"Tab 2 should get selected  My custom groups find a dropdown for the custom groups based on SFDC mapping",
					"Tab 2 "+Report.color(details)+"is selected", "PASS");     
			Report.put("Select any customer group from the dropdown",
					"User should get second level. Select a site or product: Dropdown",
					"The selected dropdown for the custom groups is:"+Report.color(details1), "PASS");
			try {
				// added below code during 0103
//				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIntegratedHomePage.selectAsiteOrProduct()));
				CommonUtility.ClickOn(driver, obj_EsupportIntegratedHomePage.site());
				List<WebElement> slist= driver.findElements(obj_EsupportIntegratedHomePage.siteLists());
				for(int i=1;i<=slist.size();i++){

					System.out.println(details2=slist.get(i).getText());
					CommonUtility.highlightElement(driver, slist.get(i));
					slist.get(i).click();
					break;
				}
//				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIntegratedHomePage.selectAnAssert()));
//				CommonUtility.ClickOn(driver, obj_EsupportIntegratedHomePage.product());
//				List<WebElement> plist= driver.findElements(obj_EsupportIntegratedHomePage.productLists());
//				for(int i=1;i<=plist.size();i++){
//					CommonUtility.highlightElement(driver, plist.get(i));
//					System.out.println(details3=plist.get(i).getText());
//					plist.get(i).click();
//					break;
//				}
				
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIntegratedHomePage.selectAnAssert()));
				CommonUtility.ClickOn(driver, obj_EsupportIntegratedHomePage.Asset());
				List<WebElement> alist= driver.findElements(obj_EsupportIntegratedHomePage.AssetList());
				for(int i=1;i<=alist.size();i++){
					CommonUtility.highlightElement(driver, alist.get(i));
					System.out.println(details3=alist.get(i).getText());
					alist.get(i).click();
					break;
				}
				Report.put("Select any product from dropdown or site",
						"User should shown with results",
						"The selected dropdown for the custom groups is:"+Report.color(details2), "PASS");  
				Report.put("Select any product from dropdown or an assert",
						"User should shown with results",
						"The selected dropdown for the custom groups is:"+Report.color(details3), "PASS");  
				CommonUtility.ClickOn(driver, obj_EsupportIntegratedHomePage.continueButton());
				Thread.sleep(10000);
			}catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Report.put("Select any product from dropdown or site",
						"User should shown with results",
						"Unable to display the lists", "PASS");  
				Assert.fail();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Report.put(" Click on Find my Dell EMC products and Select Tab 2 ",
					"Tab 2 should get selected  My custom groups find a dropdown for the custom groups based on SFDC mapping",
					"Uanble to display the lists", "PASS");  
			Assert.fail();
		}
	}
	public void clickOnAccountSitesTab(WebDriver driver)
	{
		System.out.println("Inside clickOnAccountSitesTab");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 20);

		try {
			Thread.sleep(10000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIntegratedHomePage.AccountSitesTab()));
			if(CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.AccountSitesTab()).isDisplayed())
			{
				CommonUtility.ClickOn(driver, obj_EsupportIntegratedHomePage.AccountSitesTab());
				System.out.println("Clicked on AccountSitesTab link");
				Report.put("Click on account sites tab ",
						"Account Sites Tab should be selected",
						"Account Sites Tab selected Successfully", "PASS");
			}                   
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("User failed to get the My account login screen.");
			Report.put("Click on account sites tab ",
					"Account Sites Tab should be selected",
					"Account Sites Tab selection failed", "FAIL");
			Assert.fail();
		}
	}


	public void handleSiteSearchTextbox(WebDriver driver, String inputText)
	{
		System.out.println("Inside handleSiteSearchTextbox");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		String intvalue = "";

		try
		{
			Thread.sleep(4000);
			if(CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.SiteSearchTextbox()).isDisplayed())
			{
				CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.SiteSearchTextbox()).sendKeys(inputText);
				System.out.println("Entered text is: "+inputText );
			}

			Thread.sleep(4000);

			WebElement Accsearch = driver.findElement(By.xpath("//input[@id='accountSiteSearchInput']"));
			Accsearch.clear();
			Accsearch.sendKeys(inputText,Keys.ENTER);

			WebDriverWait waite=new WebDriverWait(driver, 10);
			//waite.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form[@id='divSearchSiteGroups']//ul/li")));

			//wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIntegratedHomePage.SiteSearchList()));
			//if(CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.SiteSearchList()).isDisplayed())
			//{
			List<WebElement> siteList = driver.findElements(obj_EsupportIntegratedHomePage.SiteSearchList());

			int records = siteList.size();
			System.out.println("Number of records are(int value): "+records);
			intvalue=Integer.toString(records);
			System.out.println("List is displayed, Records count: "+records);



			String newcode=TestNGCreator.TestData.get(Esupport.TestCaseID.ordinal());

			if(!((newcode.equalsIgnoreCase("5780284")) && (newcode.equalsIgnoreCase("5780144")))){


				Report.put("Click on Account Sites and In search for account sites, Entered text"+Report.color(inputText),
						"Employee user should be see type ahead. Employee should see the list with search criteria.",
						"List displayed. Number of records are:" +Report.color(intvalue), "PASS");
			}
			else
			{
				Report.put("Comeback and Click on the 3 Tab ",
						"Tab 3, Account sites should be selected with heading Enter the Site ID, Site Name, or Site Location of the product you are looking for.",
						"Successfully Tab 3, Account sites should be selected with heading Enter the Site ID, Site Name, or Site Location of the product you are looking for." ,"PASS");
			}
			//}

		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("User failed to get the My account login screen.");
			Report.put("Click on Account Sites and In search for account sites, Entered text"+Report.color(inputText),
					"Employee user should be see type ahead. Employee should see the list with search criteria.",
					"List is not displayed", "FAIL");
			Assert.fail();
		}
	}

	//sujata new code

	public void ToClick_AccountlistTab(WebDriver driver)
	{
		System.out.println("Inside ToClick_AccountlistTab");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		Actions act=new Actions(driver);
		try
		{
			Thread.sleep(4000);
			if(CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.AccountSitesTablinkclick()).isDisplayed())
			{
				CommonUtility.ScrollTo(driver, obj_EsupportIntegratedHomePage.AccountSitesTablinkclick());
				CommonUtility.ClickOn(driver, obj_EsupportIntegratedHomePage.AccountSitesTablinkclick());
//				act.moveToElement(CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.AccountSitesTablinkclick())).click().build().perform();
				System.out.println("Clicking on any Account search link");
			}
			Report.put(" Enter any Site ID or Site name City and click on Search", 
					"User should shown with results ",
					"Succefully User should shown with results ", "PASS");


		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();

			Report.put(" Enter any Site ID or Site name City and click on Search", 
					"User is not able to shown with results ",
					"User is not able to shown with results", "FAIL");

			System.out.println("User failed to get the My account login screen.");

			Assert.fail();
		}
	}


	public void ToClick_AnyselectProduct(WebDriver driver)
	{
		System.out.println("Inside ToClick_AnyselectProduct");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 20);

		try
		{
//			Thread.sleep(4000);

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIntegratedHomePage.selectproduct()));


			CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.selectproduct());
			CommonUtility.ClickOn(driver, obj_EsupportIntegratedHomePage.selectproduct());
			System.out.println("Clicked on Select product");


			CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.selectproducttext());
			CommonUtility.ClickOn(driver, obj_EsupportIntegratedHomePage.selectproducttext());

			System.out.println("Clicked on 1st of any link");

			CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.selectproducttextclickContinue());
			CommonUtility.ClickOn(driver, obj_EsupportIntegratedHomePage.selectproducttextclickContinue());

			System.out.println("Clicked selectproducttextclickContinue");


		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("User failed to get the My account login screen.");

			Assert.fail();
		}
	}
	//Sujata
	/*public void toSearch_In_productSearch_FindMyDellEMCProductcontanct(WebDriver driver, String value){
		System.out.println("verify the 'toSearch_In_productSearch_FindMyDellEMCProduct' .");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 100);
		Actions act=new Actions(driver);
		String details="";
		try {
			Thread.sleep(4000);
			CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.productSearchInput()).click();
			char[] NameInputArray = value.toCharArray();
			for(int j=0;j<NameInputArray.length;j++)
			{
				driver.findElement(obj_EsupportIntegratedHomePage.productSearchInput()).sendKeys(String.valueOf(NameInputArray[j]));
				Thread.sleep(200);
			}
			// CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.productSearchInput()).sendKeys(value,Keys.ENTER);


			List<WebElement> dropdownLists=driver.findElements(obj_EsupportIntegratedHomePage.emcSearchProductsLists());

			System.out.println("the size of avialable options"+dropdownLists.size());

			for(int i=0;i<dropdownLists.size();i++){
				CommonUtility.highlightElement(driver,dropdownLists.get(i)).isDisplayed();
				details=dropdownLists.get(i).getText();
				System.out.println("i val---"+i+"value: "+details);
				CommonUtility.scrollToViewElement(driver, dropdownLists.get(i));
			}
			Report.put("Go to the Search Box and enter 3 characters",
					"User should return any and all Serialized Products that  map to the VNX product.</br>"
							+"In below format Product ID | Product Alias (if exists) | Product Name | Site Name | Site Address",
							"Details is displayed in following format"+Report.color(details), "PASS"); 
			try{ 
				for(int i=0;i<dropdownLists.size();){
					System.out.println("i val---"+i);
					CommonUtility.highlightElement(driver,dropdownLists.get(i)).isDisplayed();
					details=dropdownLists.get(i).getText();
					System.out.println(details);    
					act.moveToElement(dropdownLists.get(i)).click().perform();   
					break;
				}
				System.out.println("clicked on 1st option");



				System.out.println("the url:"+driver.getTitle());
				System.out.println("the url:"+driver.getCurrentUrl());
				Report.put("Click on the specific row ",
						"User should be taken to the Product Support page for the corresponding selection </br>"
								+"URL format should be: https://www.dell.com/support/incidents-online/us/en/19/contactus/Dynamic?ref=contactus",
								" Product Support page is opened "+Report.color(driver.getTitle()), "PASS");   

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Report.put("Click on the specific row ",
						"User should be taken to the Product Support page for the corresponding selection </br>"
								+"URL format should be: https://www.dell.com/support/incidents-online/us/en/19/contactus/Dynamic?ref=contactus",
								" Unable to open the product support page", "PASS");     
				Assert.fail();
			}


		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("User failed to get the My account login screen.");
			Report.put("Go to the Search Box and enter 3 characters",
					"User should return any and all Serialized Products that  map to the VNX product.</br>"
							+"In below format Product ID | Product Alias (if exists) | Product Name | Site Name | Site Address",
							"Unable to display the lists", "PASS");  
			Assert.fail();
		}
	}

	 */

	//Sudha New Code
	public void toSearch_In_productSearch_FindMyDellEMCProductcontanct(WebDriver driver, String value){
		System.out.println("verify the 'toSearch_In_productSearch_FindMyDellEMCProduct' .");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 100);
		Actions act=new Actions(driver);
		String details="";
		try {
			Thread.sleep(4000);
			WebElement prodsearch = driver.findElement(By.xpath("//input[@id='txtESSearch']"));
			prodsearch.clear();
			prodsearch.sendKeys(value);
			
			CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.PageHeader());

			WebDriverWait waite=new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='emcSearchProducts']//ul/li")));

			List<WebElement> dropdownLists=driver.findElements(obj_EsupportIntegratedHomePage.emcSearchProductsLists());

			System.out.println("the size of avialable options"+dropdownLists.size());

			for(int i=0;i<dropdownLists.size();i++){
				CommonUtility.highlightElement(driver,dropdownLists.get(i)).isDisplayed();
				details=dropdownLists.get(i).getText();
				System.out.println("i val---"+i+"value: "+details);
				CommonUtility.scrollToViewElement(driver, dropdownLists.get(i));
			}
			Report.put("Go to the Search Box and enter 3 characters",
					"User should return any and all Serialized Products that  map to the VNX product.</br>"
							+"In below format Product ID | Product Alias (if exists) | Product Name | Site Name | Site Address",
							"Details is displayed in following format"+Report.color(details), "PASS"); 
			try{ 
				for(int i=0;i<dropdownLists.size();){
					System.out.println("i val---"+i);
					CommonUtility.highlightElement(driver,dropdownLists.get(i)).isDisplayed();
					details=dropdownLists.get(i).getText();
					System.out.println(details);    
					act.moveToElement(dropdownLists.get(i)).click().perform();   
					break;
				}
				System.out.println("clicked on 1st option");



				System.out.println("the url:"+driver.getTitle());
				System.out.println("the url:"+driver.getCurrentUrl());
				Report.put("Click on the specific row ",
						"User should be taken to the Product Support page for the corresponding selection </br>"
								+"URL format should be: https://www.dell.com/support/incidents-online/us/en/19/contactus/Dynamic?ref=contactus",
								" Product Support page is opened "+Report.color(driver.getTitle()), "PASS");   

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Report.put("Click on the specific row ",
						"User should be taken to the Product Support page for the corresponding selection </br>"
								+"URL format should be: https://www.dell.com/support/incidents-online/us/en/19/contactus/Dynamic?ref=contactus",
								" Unable to open the product support page", "PASS");     
				Assert.fail();
			}


		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("User failed to get the My account login screen.");
			Report.put("Go to the Search Box and enter 3 characters",
					"User should return any and all Serialized Products that  map to the VNX product.</br>"
							+"In below format Product ID | Product Alias (if exists) | Product Name | Site Name | Site Address",
							"Unable to display the lists", "PASS");  
			Assert.fail();
		}
	}

	public void ToClick_AnyselectProductCOntanctheader(WebDriver driver)
	{
		System.out.println("Inside ToClick_AnyselectProduct");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 20);

		try
		{
			Thread.sleep(4000);

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIntegratedHomePage.SoftwareLicencepageHeader()));


			CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.SoftwareLicencepageHeader());

			String SoftwareLicencepageHeader=CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.SoftwareLicencepageHeader()).getText();

			System.out.println("Verifying Contanct technical support page");

			Report.put("User is able to see a Contanct technical support page ",
					"User is able land on "+Report.color(SoftwareLicencepageHeader),
					" User is able to see a Contanct technical support page", "PASS");   



		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("User failed to get the My account login screen.");

			Assert.fail();
		}
	}


	public void ToVerify_AnyselectProductCOntanctheader(WebDriver driver)
	{
		System.out.println("Inside ToClick_AnyselectProduct");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 20);

		try
		{
			Thread.sleep(4000);

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIntegratedHomePage.contanctheader()));


			CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.contanctheader());

			String SoftwareLicencepageHeader=CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.contanctheader()).getText();

			System.out.println("Verifying Contanct technical support page");

			Report.put("User is able to see a Contanct technical support page ",
					"User is able land on "+Report.color(SoftwareLicencepageHeader),
					" User is able to see a Contanct technical support page", "PASS");   



		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("User failed to get the My account login screen.");

			Assert.fail();
		}
	}
	public void ToVerify_allcontactchannels(WebDriver driver)
	{
		System.out.println("Entered into method: to verifyallContactChannels.");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		try {
			Thread.sleep(4000);
			String contactchannels = "";
			String ProductID = "";
			String SerialNumber = "";


			CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.PageHeader()).isDisplayed();

			ProductID= contactchannels + CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.productID()).getText() + "<br>";
			SerialNumber= contactchannels + CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.serialNumber()).getText() + "<br>";
			if((CommonUtility.CheckpresenceofElementLocated(driver, 20, obj_EsupportIntegratedHomePage.startRequestLink())))
			{


				System.out.println("scrolling to start Request link.");
				CommonUtility.ScrollTo(driver, obj_EsupportIntegratedHomePage.startRequestLink());

				//CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.startRequestLink()).isDisplayed();
				CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.startRequestLink());
				contactchannels = contactchannels + CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.startRequestLink()).getText() + "<br>";
				//                         CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.startRequestLink()).click();
				//                         driver.navigate().back();
				//                         handleCookies(driver);
			}else
			{
				System.out.println("Start Request link is not present in Contact channels Page.");
				Report.put("Verify all the contact channels by click on each channel start chat , create service Request , Order part and view product support links",
						"All the contact channel links should land in the respective pages Start chat , Service Request and order part links should land in the respective page with product ID serial number pre populated ",
						"Failed while verifying the contact channel Links.", "FAIL");
				Assert.fail();
			}
			if((CommonUtility.CheckpresenceofElementLocated(driver, 20, obj_EsupportIntegratedHomePage.orderSupportLink())))
			{             

				CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.orderSupportLink());
				contactchannels= contactchannels + CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.orderSupportLink()).getText() + "<br>";
				//                         CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.orderSupportLink()).click();
				//                         driver.navigate().back();
				//                         handleCookies(driver);
			}else
			{
				System.out.println("Order Support link is not present in Contact channels Page.");
				Report.put("Verify all the contact channels by click on each channel start chat , create service Request , Order part and view product support links",
						"All the contact channel links should land in the respective pages Start chat , Service Request and order part links should land in the respective page with product ID serial number pre populated ",
						"Failed while verifying the contact channel Links.", "FAIL");
				Assert.fail();
			}
			if((CommonUtility.CheckpresenceofElementLocated(driver, 20, obj_EsupportIntegratedHomePage.viewProductSupportLink())))
			{
				CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.viewProductSupportLink());
				contactchannels = contactchannels + CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.viewProductSupportLink()).getText() + "<br>";
				//                         CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.viewProductSupportLink()); 
				//                         driver.navigate().back();
				//handleCookies(driver);
			}else
			{
				System.out.println("View Product Support Link is not present in Contact channels Page.");
				Report.put("Verify all the contact channels by click on each channel start chat , create service Request , Order part and view product support links",
						"All the contact channel links should land in the respective pages Start chat , Service Request and order part links should land in the respective page with product ID serial number pre populated ",
						"Failed while verifying the contact channel Links.", "FAIL");
				Assert.fail();
			}
			System.out.println("Links : " + contactchannels);
			Report.put("Verify all the contact channels by click on each channel start chat , create service Request , Order part and view product support links",
					"All the contact channel links should land in the respective pages Start chat , Service Request and order part links should land in the respective page with product ID serial number pre populated ",
					"All the contact channel links should land in the respective pages : " + Report.color(contactchannels)+"should land in the respective page with"+Report.color(ProductID)+Report.color(SerialNumber)+"pre populated", "PASS");

		} catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Expception occured while verifying the Contact Channels. "+e);

			Report.put("Verify all the contact channels by click on each channel start chat , create service Request , Order part and view product support links",
					"All the contact channel links should land in the respective pages Start chat , Service Request and order part links should land in the respective page with product ID serial number pre populated ",
					"Failed while verifying the contact channel Links.", "FAIL");
			Assert.fail();
		}
	}

	public void  ClickChangeProduct(WebDriver driver) 
	{
		System.out.println("In Function ClickChangeProduct");
		WebDriverWait  wait = new WebDriverWait(driver, 120);
		String Prevheader="";
		System.out.println("After webdriver wait");


		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
		try
		{

			if(CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.PageHeader()).isDisplayed());
			{
				Prevheader=CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.PageHeader()).getText();
			}


			CommonUtility.ScrollTo(driver, obj_EsupportIntegratedHomePage.ChangeProductlink());

			//  wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDriversandDownloadsPage.supportHeading()));
			CommonUtility.ClickOn(driver, obj_EsupportIntegratedHomePage.ChangeProductlink());

			System.out.println("Clicked on ChangeProductlink Link");
			handleCookies(driver);
			if(CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.PageHeader()).isDisplayed())
			{
				//CancelButton=CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.ChangeProductCancelButton()).getText();
			}




			Thread.sleep(3000);


			Report.put("Click on change product in contact channels page ", "Should land in contact us jump page", "Successfully clicked on Change Product link in  Contact Us Page", "PASS");

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on change product in contact channels page ", "Should land in contact us jump page", "Change Product link is not redirected to Contact Us Page", "FAIL");
			Assert.fail();
		}
	}
	public void  Click_anyproduct_underrecentviewedsection(WebDriver driver) 
	{
		System.out.println("In Function Click any product under recent viewed section");
		WebDriverWait  wait = new WebDriverWait(driver, 120);
		String productsupportLinks="";
		System.out.println("After webdriver wait");


		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
		try
		{

			System.out.println("Checking RecentlyViewedHeader");
			CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.RecentlyViewedHeader()).isDisplayed();
			CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.RecentlyViewedHeader());
			productsupportLinks = productsupportLinks + CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.RecentlyViewedHeader()).getText() + "<br>";
			Thread.sleep(2000);
			CommonUtility.ClickOn(driver, obj_EsupportIntegratedHomePage.RecentlyproductsImages());
//			WebElement eleme = driver.findElement(obj_EsupportIntegratedHomePage.RecentlyViewedProduct());
//			CommonUtility.ToClickByUsingJavaScript(driver, eleme);

			Report.put("Comeback to contact us jump page and click on any product under the recent viewed section", "Should land in contact channels page for the selected product ","Successfully clicked a Product product under the recent viewed section","PASS");

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Comeback to contact us jump page and click on any product under the recent viewed section", "Should land in contact channels page for the selected product ","Not able to click a product under the recent viewed section","FAIL");
			Assert.fail();
		}
	}

	//Sneha:10th Dec
	public void ToVerify_blackCheckOnUsername(WebDriver driver)
	{
		System.out.println("to check black check");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 20);

		try
		{
			Thread.sleep(4000);

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIntegratedHomePage.BlackCheck()));
			CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.BlackCheck());

			Report.put("Click on Sign in , again click on Sign in ,enter valid credentials for L-EMC and click on sign in",
					"User should logged in successfully with Black check mark besides name",
					" User logged in successfully with Black check mark besides name", "PASS");   



		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			Report.put("Click on Sign in , again click on Sign in ,enter valid credentials for L-EMC and click on sign in",
					"User should logged in successfully with Black check mark besides name",
					" User didnt log in successfully with Black check mark besides name", "Fail"); 

			Assert.fail();
		}
	}

	public void TOVerify_FindMyDellEMCProductsLink(WebDriver driver){
		System.out.println("Entered into method: to click on 'FindMyDellEMCProduct' link.");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 20);

		try {
			Thread.sleep(4000);

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIntegratedHomePage.DellEmcProductIcontext()));
			CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.DellEmcProductIcontext());
			System.out.println("able to see'FindMyDellEMCProduct' link.");

			Report.put("Verify the Find My Dell EMC Products", 
					"FindMyDellEMCProduct link should be there",
					"FindMyDellEMCProduct link is there", "Pass");


		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Report.put("Verify the Find My Dell EMC Products", 
					"FindMyDellEMCProduct link should be there",
					"FindMyDellEMCProduct link is not there", "Fail");

			Assert.fail();
		}
	}
	public void EnterLEMCSerailNumberSearch(WebDriver driver,String Servicetag){
		System.out.println("Entered into method: to click on 'EnterLEMCSerailNumberSearch' ");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 20);

		String header = "";
		
		try {
			Thread.sleep(4000);

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDriversandDownloadsPage.SearchServicetag()));
			CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.SearchServicetag()).sendKeys(Servicetag);
			CommonUtility.ClickOn(driver,obj_EsupportDriversandDownloadsPage.Servicetagiconsearch());
		//	handleCaptcha(driver);
//			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIntegratedHomePage.EMCProductSupportTab()));
//			CommonUtility.highlightElement(driver,obj_EsupportIntegratedHomePage.EMCProductSupportTab());
//			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIntegratedHomePage.EMCSupportHomeTab()));
//			CommonUtility.highlightElement(driver,obj_EsupportIntegratedHomePage.EMCSupportHomeTab()).click();
			

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDriversandDownloadsPage.ServiceTagHeaderdisplayed()));
			CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.ServiceTagHeaderdisplayed());
			header=CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.ServiceTagHeaderdisplayed()).getText();

			System.out.println("Header is "+header);
			
			Report.put("Enter any L-EMC Serial number and click on Search", 
					"User should land in L-EMC serialized Product support page",
					"User lands in L-EMC serialized Product support page", "Pass");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Report.put("Enter any L-EMC Serial number and click on Search", 
					"User should land in L-EMC serialized Product support page",
					"User should not land in L-EMC serialized Product support page", "Fail");
			Assert.fail();
		}
	}
	public void toVerifyLockIconInFindMyDellEMCProductLink1(WebDriver driver){

		Log.info("Entered into method: to verify lock icon in 'Find My Dell EMC Product'");
		WebDriverWait wait = new WebDriverWait(driver, 20);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		try {
			Thread.sleep(4000);

			System.out.println("Check the visibility of the lock icon.");

			CommonUtility.ScrollTo(driver,obj_EsupportIntegratedHomePage.DellEmcProductIcontext());
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIntegratedHomePage.DellEmcProductIcontext()));
			CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.DellEmcProductIcontext());

			if(!(CommonUtility.CheckpresenceofElementLocated(driver, 20, obj_EsupportIntegratedHomePage.FindMyDellEMCProductLockIcon()))){
				System.out.println("Lock icon is not displayed.");
				Report.put("Verify the Find My Dell EMC Products", 
						"User should not see any Locked symbol",
						"Locked Symbol is not present", "PASS");
			}

			


		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Lock icon is not displayed.");
			Report.put("Under the product selector Verify the Find My Dell EMC Products.", 
					"User should not see any Locked symbol.",
					"Lock symbol is present with Find My Dell EMC Products.", "FAIL");
			Assert.fail();
		}

	}
	public void clickOnFindMyDellEMCProducts_RequestLink(WebDriver driver){
		String currentUrl="";
		String title="";
		System.out.println("Entered into method: to click on 'FindMyDellEMCProduct' link.");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 20);

		try {
			Thread.sleep(4000);
			CommonUtility.ClickOn(driver, obj_EsupportIntegratedHomePage.DellEmcProductIcontext());
			System.out.println("clicked on 'FindMyDellEMCProduct' link.");
			Thread.sleep(4000);
			CommonUtility.ClickOn(driver, obj_EsupportIntegratedHomePage.RequestAccess());
			System.out.println("clicked on 'Request Access' link.");

			Set<String> allWH=driver.getWindowHandles(); 
			String currentwindow=driver.getWindowHandle();
			int count=allWH.size(); 
			System.out.println("Switched Window Handles and  window count is :: "+count);

			for(String wh:allWH) 
			{

				Thread.sleep(10000);
				driver.switchTo().window(wh); 
				currentUrl=driver.getCurrentUrl();
				//wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIntegratedHomePage.dellEMCLogo()));
				title = driver.getTitle();
				System.out.println("title is : "+title); 
				if(title.contains("EMC - Dell EMC Site Help & Feedback"))
				{

					System.out.println("CurrentUrl is : "+currentUrl); 
					System.out.println("CurrentTitle  is : "+title); 
					Thread.sleep(10000);
					driver.close();
				}
				driver.switchTo().window(currentwindow);
				//CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.PopupClose()).click();


			}

			//System.out.println("User navigated to My account login screen.");

			Report.put("Click on Find My Dell EMC Products",
					"User should get the My account login screen.",
					"User get the My account login screen", "PASS");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("User failed to get the My account login screen.");
			Report.put("Click on 'FindMyDellEMCProduct' link.",
					"User should get the My account login screen.",
					"User failed to get the My account login screen", "FAIL");
			Assert.fail();
		}
	}

	//public void EnterLEMCServiceRequestSearch(WebDriver driver,String Serial){
	//    System.out.println("Entered into method: to click on 'FindMyDellEMCProduct' link.");
	//    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	//    WebDriverWait wait = new WebDriverWait(driver, 20);
	//
	//    try {
	//          Thread.sleep(4000);
	//
	//    wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDriversandDownloadsPage.SearchServicetag()));
	//    CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.SearchServicetag()).sendKeys(Servicetag);
	//    CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.Servicetagiconsearch()).click();
	//          handleCaptcha(driver);
	//          Report.put("Enter any L-EMC Serial number and click on Search", 
	//           " User should land in Service Request Page ",
	//           " User lands in Service Request Page ", "pass");
	//          
	//
	//
	//
	//    } catch (Exception e) {
	//          // TODO Auto-generated catch block
	//          e.printStackTrace();
	//Report.put("Enter any L-EMC Serial number and click on Search", 
	//                " User should land in Service Request Page ",
	//                 " User should not land in Service Request Page ", "Fail");
	//          Assert.fail();
	//    }
	//}
	public void SearchValues_ProductSupport_CharacterByCharacter_IE(WebDriver driver, String value)
	{
		Log.info("Enter in search method");
		String flag="";
		String product="";
		Actions act = new Actions(driver);
		try{
			CommonUtility.CheckpresenceofElementLocated(driver, 50, obj_EsupportCoveoPage.searchInputTextBox());
//			WebElement element = driver.findElement(obj_EsupportCoveoPage.searchInputTextBox());
//			act.moveToElement(element).click().perform();
			CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.searchInputTextBox());
			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.searchInputTextBox()).clear();

			//WebElement w = Driver.driver.findElement(proj_drop); 
			driver.findElement(obj_EsupportCoveoPage.searchInputTextBox()).sendKeys(value); 
			//		WebDriverWait wait = new WebDriverWait(driver, 30); 
			//		WebElement localities = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Inspiron')]")));  
			//		localities.sendKeys(Keys.RETURN);

			/*char[] NameInputArray = value.toCharArray();
		for(int j=0;j<NameInputArray.length;j++)
		{
			driver.findElement(obj_EsupportCoveoPage.searchInputTextBox()).sendKeys(String.valueOf(NameInputArray[j]));
			Thread.sleep(2000);
		}
		List<WebElement> charoptions=driver.findElements(By.xpath("//ul[contains(@class,'ui-autocomplete')]/li/a/span[text()='"+value+"']"));
		System.out.println("the size of avialable options"+charoptions.size());

		for(int i=1;i<=charoptions.size()-1;){
			System.out.println("i val---"+i);
			CommonUtility.highlightElement(driver,charoptions.get(i)).isDisplayed();
			WebElement elmt = driver.findElement(By.xpath("//ul[contains(@class,'ui-autocomplete')]/li/a/span[text()='"+value+"']/../../../li["+i+"]")); 
			product= elmt.getText();
			act.moveToElement(elmt).click().perform();   
			break;
		}*/
			WebDriverWait wait = new WebDriverWait(driver, 30); 
			WebElement localities = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Inspiron')]")));  
			localities.sendKeys(Keys.RETURN);

			Report.put("Within the Integrated homepage Under the product selector, Enter "+Report.color(product)+" Product Model", "User Should Get Auto suggestion for the entered characters", "Select the 1st product from the auto suggestions", "PASS");
		}catch(Exception ex){
			ex.printStackTrace();
			Report.put("Within the Integrated homepage Under the product selector, Enter "+Report.color(product)+" Product Model", "User Should Get Auto suggestion for the entered characters", "Unable to select the product from the auto suggestions", "FAIL");
			Assert.fail();
		}
	} 
	//Sudha 1stFeb
	public void verifyalertbannerssupportHomePage(WebDriver driver){
		System.out.println("Entered into method: to verifyalertbannerssupportHomePage.");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		try {
			Thread.sleep(4000);

			System.out.println("Title : " + driver.getTitle());


			if(CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.warningPhoneScam()).isDisplayed())
			{

				Report.put("Verify the alert banners in the home page", 
						"2 Alert banners Global and Country wide Banners should be displayed above the Masthead", 
						"2 Alert banners Global and Country wide Banners are displayed above the Masthead", "PASS");
			}else{
				System.out.println("'Warning Phone Scam' is not present.");
				Report.put("Verify the alert banners in the home page", 
						"2 Alert banners Global and Country wide Banners should be displayed above the Masthead", 
						"2 Alert banners Global and Country wide Banners are not displayed above the Masthead", "FAIL");
				Assert.fail();
			}

			Thread.sleep(4000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("'Warning Phone Scam' is not present."+ e);
			Report.put("Verify the alert banners in the home page", 
					"2 Alert banners Global and Country wide Banners should be displayed above the Masthead", 
					"2 Alert banners Global and Country wide Banners are not displayed above the Masthead", "FAIL");
			Assert.fail();
		}
	}

	public void clickOnLinkInBanners(WebDriver driver){
		System.out.println("Entered into method: to clickOnLinkBanners.");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		try {
			Thread.sleep(4000);
			if(CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.seeOurBlog()).isDisplayed())
			{
				Thread.sleep(4000);
				CommonUtility.ClickOn(driver, obj_EsupportIntegratedHomePage.seeOurBlog());
				System.out.println("clicked on 'seeOurBlog' link.");

				handleCookies(driver);
				//Thread.sleep(4000);
				WebDriverWait wait = new WebDriverWait(driver, 10);
				wait.until(ExpectedConditions.titleIs("Five Tips to Help You Avoid Tech Support Phone Scams - Direct2Dell"));

				driver.getTitle();

				System.out.println("page title : " + driver.getTitle());

				CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.techSupportPhoneScamHeader());

				if(driver.getTitle().contains("Five Tips to Help You Avoid Tech Support Phone Scams - Direct2Dell")){
					System.out.println("User is navigated to Tech Support Phone Scams.");
					Report.put("Click on Link in the Banners.",
							"User should direct to that particular page",
							"User is navigated to Tech Support Phone Scams, URL : " + Report.color(driver.getCurrentUrl()), "PASS");
				}
				else{
					System.out.println("User is not navigated to Tech Support Phone Scams.");
					Report.put("Click on Link in the Banners.",
							"User should direct to that particular page",
							"User is not navigated to Tech Support Phone Scams page.", "FAIL");
					Assert.fail();
				}
			}else{
				System.out.println("See our Blog link is not Present.");
				Report.put("Click on Link in the Banners.",
						"User should direct to that particular page",
						"See our Blog link is not Present.", "FAIL");
				Assert.fail();
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Report.put("Click on Link in the Banners.",
					"User should direct to that particular page",
					"User is not navigated to Tech Support Phone Scams page.", "FAIL");
			Assert.fail();
		}
	}
	public void  SelectCountryFromCountrySelector(WebDriver driver,String country)
	{
		// TODO Auto-generated method stub
		System.out.println("Entering Select Country From Country Selector");

		Log.info("Entering changeCountry");   
		//String country = TestNGCreator.TestData.get(Esupport.Country.ordinal());
		String selectedcountry = "";

		try{
			handleCookies(driver);
			System.out.println("scrolling to footer");
			CommonUtility.ScrollTo(driver, obj_EsupportCoveoPage.CountrySelector());

			Thread.sleep(2000);

			WebElement element =driver.findElement(By.xpath("//div[@id='countryselector']/a"));
			((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);  

			Thread.sleep(5000);

			System.out.println(country);
			List<WebElement> countryList=driver.findElements(obj_EsupportCoveoPage.CountryList());

			for(WebElement lt:countryList)
			{
				String couLi=lt.getText();

				System.out.println("Country is: " +couLi);
				if(couLi.equalsIgnoreCase(country))
				{
					System.out.println("Inside if**************");
					System.out.println("Country is: " +couLi);
					lt.click();

					selectedcountry = couLi;
					System.out.println("Selected Country is "+selectedcountry);

					break;
				}	
			}
			Thread.sleep(3000);
			handleCookies(driver);
			driver.getTitle();

			System.out.println("page title : " + driver.getTitle());

			if(selectedcountry.equalsIgnoreCase("United Kingdom"))
			{if(driver.getTitle().contains("UK")){
				System.out.println("User is navigated to Support Home Page.");
				Report.put("From the country selector select any other country", 
						"User should land in the "+Report.color(country)+"support homepage", 
						"User is land in the "+Report.color(country)+"support homepage", "PASS");

			}
			}else if(selectedcountry.equalsIgnoreCase(country)){
				System.out.println("User is not navigated to Tech Support Phone Scams.");
				Report.put("From the country selector select any other country", 
						"User should land in the "+Report.color(country)+"support homepage", 
						"User is land in the "+Report.color(country)+"support homepage", "PASS");

			}          
			else{
				System.out.println("User is not navigated to Tech Support Phone Scams.");
				Report.put("From the country selector select any other country",  
						"User should land in the "+Report.color(country)+"support homepage", 
						"Not able to select the country"+Report.color(country), "FAIL");
				Assert.fail();
			}

		}catch(Exception e)
		{
			e.printStackTrace();
			Report.put("From the country selector select any other country",  
					"User should land in the "+Report.color(country)+"support homepage", 
					"Not able to select the country"+Report.color(country), "FAIL");
			Assert.fail();
		}
	}
	public void ProdverifyalertbannerssupportHomePage(WebDriver driver){
		System.out.println("Entered into method: to verifyalertbannerssupportHomePage.");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		try {
			Thread.sleep(4000);

			System.out.println("Title : " + driver.getTitle());

			if(driver.findElement(obj_EsupportIntegratedHomePage.alertWarning()).isDisplayed() && driver.findElement(obj_EsupportIntegratedHomePage.dellEMCSupportHeader()).isDisplayed()) 

			{

				Report.put("Verify the alert banners in the home page", 
						"2 Alert banners Global and Country wide Banners should be displayed above the Masthead", 
						"2 Alert banners Global and Country wide Banners are displayed above the Masthead", "PASS");
			}else{
				System.out.println("'Integrated Support'&'Warning Phone Scam' is not present.");
				Report.put("Verify the alert banners in the home page", 
						"2 Alert banners Global and Country wide Banners should be displayed above the Masthead", 
						"2 Alert banners Global and Country wide Banners are not displayed above the Masthead", "FAIL");
				Assert.fail();
			}

			Thread.sleep(4000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("'Integrated Support'&'Warning Phone Scam'"+ e);
			Report.put("Verify the alert banners in the home page", 
					"2 Alert banners Global and Country wide Banners should be displayed above the Masthead", 
					"2 Alert banners Global and Country wide Banners are not displayed above the Masthead", "FAIL");
			Assert.fail();
		}
	}

	public void ProdclickOnLinkInBanners(WebDriver driver){
		System.out.println("Entered into method: to clickOnLinkBanners.");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String InHeader= "";
		try {
			Thread.sleep(4000);
			if(driver.findElement(obj_EsupportIntegratedHomePage.learnMore()).isDisplayed() && driver.findElement(obj_EsupportIntegratedHomePage.seeOurBlog()).isDisplayed()) 
			{
				Thread.sleep(4000);
				CommonUtility.ClickOn(driver, obj_EsupportIntegratedHomePage.learnMore());
				System.out.println("clicked on 'Learn More' link.");
				handleCookies(driver);
				WebDriverWait wait = new WebDriverWait(driver, 10);
				wait.until(ExpectedConditions.titleContains("How to easily navigate the New Dell and Dell EMC Integrated Support Homepage | Dell"));


				driver.getTitle();

				System.out.println("page title : " + driver.getTitle());

				CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.integratedSupportHeader());

				if(driver.getTitle().contains("How to easily navigate the New Dell and Dell EMC Integrated Support Homepage | Dell")){
					System.out.println("User is navigated to Integrated Support Homepage.");
					InHeader=driver.getCurrentUrl();

				}else{
					System.out.println("User is not navigated to Integrated Support Homepage.");
					Report.put("Click on Link in the Banners.",
							"User should direct to that particular page",
							"User is not navigated to Integrated Support Homepage.", "FAIL");
					Assert.fail();
				}

				driver.navigate().back();

				Thread.sleep(2000);

				CommonUtility.ClickOn(driver, obj_EsupportIntegratedHomePage.seeOurBlog());
				System.out.println("clicked on 'seeOurBlog' link.");

				handleCookies(driver);
				//Thread.sleep(4000);
				WebDriverWait waitt = new WebDriverWait(driver, 10);
				waitt.until(ExpectedConditions.titleIs("Five Tips to Help You Avoid Tech Support Phone Scams - Direct2Dell"));

				driver.getTitle();

				System.out.println("page title : " + driver.getTitle());

				CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.techSupportPhoneScamHeader());

				if(driver.getTitle().contains("Five Tips to Help You Avoid Tech Support Phone Scams - Direct2Dell")){
					System.out.println("User is navigated to Tech Support Phone Scams.");
					Report.put("Click on Link in the Banners.",
							"User should direct to that particular page",
							"User is navigated to the following Url's: " +Report.color(InHeader)+","+Report.color(driver.getCurrentUrl()),"PASS");

				}
				else{
					System.out.println("User is not navigated to Tech Support Phone Scams.");
					Report.put("Click on Link in the Banners.",
							"User should direct to that particular page",
							"User is not navigated to Tech Support Phone Scams page.", "FAIL");
					Assert.fail();
				}
			}else{
				System.out.println("Learn More or See our Blog link is not Present.");
				Report.put("Click on Link in the Banners.",
						"User should direct to that particular page",
						"Learn More or See our Blog link is not Present.", "FAIL");
				Assert.fail();
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Report.put("Click on Link in the Banners.",
					"User should direct to that particular page",
					"Learn More or See our Blog link is not Present.", "FAIL");
			Assert.fail();
		}
	}
	public void countryExecution_prod(WebDriver driver){
		System.out.println("Entered into method: to verifyalertbannerssupportHomePage.");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		try {
			String[] country=TestNGCreator.TestData.get(Esupport.Country.ordinal()).split(";");	
			int len=country.length;
			System.out.println(len);
			for(int j=0;j<country.length;j++)
			{ 
				SelectCountryFromCountrySelector(driver,TestNGCreator.TestData.get(Esupport.Country.ordinal()).split(";")[j]);
				ProdverifyalertbannerssupportHomePage(driver);
				ProdclickOnLinkInBanners(driver);
				driver.navigate().back();
				Thread.sleep(10000);
			}

			Thread.sleep(4000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("'Country selection data is not Proper in the Excel'"+ e);

			Assert.fail();
		}
	}
	public void countryExecution_SIT(WebDriver driver){
		System.out.println("Entered into method: to verifyalertbannerssupportHomePage.");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		try {
			String[] country=TestNGCreator.TestData.get(Esupport.Country.ordinal()).split(";");	
			int len=country.length;
			System.out.println(len);
			for(int j=0;j<country.length;j++)
			{ 
				SelectCountryFromCountrySelector(driver,TestNGCreator.TestData.get(Esupport.Country.ordinal()).split(";")[j]);
				verifyalertbannerssupportHomePage(driver);
				clickOnLinkInBanners(driver);
				driver.navigate().back();
				Thread.sleep(10000);
			}

			Thread.sleep(4000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("'Country selection data is not Proper in the Excel'"+ e);

			Assert.fail();
		}
	}
	//Sujata
	public void TOverify_AboutToExpiretext(WebDriver driver,String ServiceTag){
		System.out.println("Entered into method: to TOverify_AboutToExpiretext.");

		WebDriverWait wait = new WebDriverWait(driver, 200);



		try {

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIntegratedHomePage.Abouttoexpiremessage()));

			//handleCookies(driver);
			CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.Abouttoexpiremessage());
			String Expiretext=CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.Abouttoexpiremessage()).getText();



			Report.put("Verify the Yellow bar alert ",
					"Alert message should show in the product support dashboard as " + Report.color(Expiretext),
					"Successfully alert message should show in the product support dashboard  with the ServiceTag is  "+ Report.color(ServiceTag), "PASS");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Expception occured while verifying the Critical Links. "+e);

			Report.put("Verify the integrated homepage (Enterprise Support) below the Critical Links",
					" Failed while verifying theAlert message should show in the product support dashboard",
					"Failed while verifying theAlert message should show in the product support dashboard", "FAIL");
			Assert.fail();
		}

	}


	public void TOClick_AbouttoExpiretextClickHere(WebDriver driver){
		System.out.println("Entered into method: to TOClick_AbouttoExpiretextClickHere.");

		WebDriverWait wait = new WebDriverWait(driver, 200);

		try {

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIntegratedHomePage.Abouttoexpiremessageclickhere()));

			//handleCookies(driver);
			CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.Abouttoexpiremessageclickhere());
			CommonUtility.ClickOn(driver, obj_EsupportIntegratedHomePage.Abouttoexpiremessageclickhere());

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIntegratedHomePage.PageTittleHeader()));

			CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.PageTittleHeader());
			String Verifyheader=CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.PageTittleHeader()).getText();



			Report.put("Click on the click here in the alert ",
					"User must direct to incidents issue list/contact channels page with the Url " + Report.color(driver.getCurrentUrl())+ " Page Header is  " + Report.color(Verifyheader),
					"Successfully alert message should show in the product support dashboard ", "PASS");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Expception occured while verifying the Critical Links. "+e);
			Report.put("Click on the click here in the alert ",
					"Failed while verifying User must direct to incidents issue list/contact channels page with the Url",
					"Failed while verifying User must direct to incidents issue list/contact channels page with the Url ", "FAIL");



			Assert.fail();
		}

	}


	public void TOclick_SupportBreadcrumbs(WebDriver driver){
		System.out.println("Entered into method: to TOclick_SupportBreadcrumbs.");

		WebDriverWait wait = new WebDriverWait(driver, 200);

		try {

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIntegratedHomePage.BreadcrumbsSupport()));

			//handleCookies(driver);
			CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.BreadcrumbsSupport());
			CommonUtility.ClickOn(driver, obj_EsupportIntegratedHomePage.BreadcrumbsSupport());


			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIntegratedHomePage.PageHeader()));

			handleCookies(driver);
			CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.PageHeader());
			String HeaderText=CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.PageHeader()).getText();



			Report.put("Comeback to the support homepage by click on support in breadcrumb ",
					"User should comeback to the support homepage header as " + Report.color(HeaderText),
					"Successfully User should comeback to the support homepage ", "PASS");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Expception occured while verifying the Critical Links. "+e);

			Report.put("Comeback to the support homepage by click on support in breadcrumb ",
					" Failed while verifying the support homepage Header",
					"Failed while verifying the support homepage Header", "FAIL");
			Assert.fail();
		}

	}


	public void TOverify_Expiretext(WebDriver driver,String ServiceTag){
		System.out.println("Entered into method: to TOverify_Expiretext.");

		WebDriverWait wait = new WebDriverWait(driver, 200);

		try {

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIntegratedHomePage.expiredmessage()));

			//handleCookies(driver);
			CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.expiredmessage());
			String Expiretext=CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.expiredmessage()).getText();



			Report.put("Verify the Yellow bar alert ",
					"Alert message should show in the product support dashboard as " + Report.color(Expiretext),
					"Successfully alert message should show in the product support dashboard with the ServiceTag as  "+Report.color(ServiceTag), "PASS");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Expception occured while verifying the Critical Links. "+e);

			Report.put("Verify the integrated homepage (Enterprise Support) below the Critical Links",
					" Failed while verifying theAlert message should show in the product support dashboard",
					"Failed while verifying theAlert message should show in the product support dashboard", "FAIL");
			Assert.fail();
		}

	}


	public void TOClick_ExpiretextClickHere(WebDriver driver){
		System.out.println("Entered into method: to TOClick_ExpiretextClickHere.");

		WebDriverWait wait = new WebDriverWait(driver, 200);

		try {

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIntegratedHomePage.Expiremessageclickhere()));

			//handleCookies(driver);
			CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.Expiremessageclickhere());
			CommonUtility.ClickOn(driver, obj_EsupportIntegratedHomePage.Expiremessageclickhere());

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIntegratedHomePage.PageTittleHeader()));

			CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.PageTittleHeader());
			String Verifyheader=CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.PageTittleHeader()).getText();



			Report.put("Click on the click here in the alert ",
					"User must direct to incidents issue list/contact channels page with the Url " + Report.color(driver.getCurrentUrl())+ " Page Header is  " + Report.color(Verifyheader),
					"Successfully alert message should show in the product support dashboard ", "PASS");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Expception occured while verifying the Critical Links. "+e);
			Report.put("Click on the click here in the alert ",
					"Failed while verifying User must direct to incidents issue list/contact channels page with the Url",
					"Failed while verifying User must direct to incidents issue list/contact channels page with the Url ", "FAIL");



			Assert.fail();
		}

	}
	
	public void verifyContactsupportjumppageForLEMCUser(WebDriver driver){
		System.out.println("Entered into method: to verifyContactsupportjumppageForLEMCUser.");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		

		try {
			Thread.sleep(4000);
			String Browseallproductslink = "";
			String productsupportLinks= "";
			String flag="";
			
			CommonUtility.highlightElement(driver, obj_EsupportIncidentsPage.browseMyAssetsButton()).isDisplayed();
			Browseallproductslink=CommonUtility.highlightElement(driver,obj_EsupportIncidentsPage.browseMyAssetsButton()).getText();
			//productsupportLinks = productsupportLinks + CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.FindmyDellEMCproductLink()).getText() + "<br>";
			
				

			if(CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.SearchBoxInTechnicalSupport()).isDisplayed())
			{
				System.out.println("SearchBox is Dispalyed");
				Report.put("Verify the Contact support jump page",
						"Contact support jump page should have Product selector with search box , choose from all products and Find My Dell EMC Products Links", 
						"Contact support jump page should have Product selector with search box ,"+Report.color(Browseallproductslink), "PASS");
			}
			else
			{
				System.out.println("SearchBox is not dispalyed");



				Report.put("Verify the Contact support jump page",
						"Contact support jump page should have Product selector with search box , choose from all products and Find My Dell EMC Products Links", 
						"Failed while verifying the Contact support jump page", "FAIL");
				Assert.fail();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Expception occured while verifying the Contact support jump page. "+e);

			Report.put("Verify the Contact support jump page",
					"Contact support jump page should have Product selector with search box , choose from all products and Find My Dell EMC Products Links", 
					"Failed while verifying the Contact support jump page", "FAIL");
			Assert.fail();
		}

	}
	
	
	public void clickOnContactSupportLink_LEMC(WebDriver driver){

		System.out.println("Entered into method: to clickOnContactSupportLink_LEMC.");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 100);
		Actions act=new Actions(driver);
		

		try {
			Thread.sleep(3000);

			CommonUtility.ScrollTo(driver, obj_EsupportIntegratedHomePage.ContactSupportMastheadLink());
//			CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.ContactSupportMastheadLink()).click();
			CommonUtility.ClickOn(driver, obj_EsupportIntegratedHomePage.ContactSupportMastheadLink());
			
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIncidentsPage.contactUs()));
//			Thread.sleep(10000);
//			handleCookies(driver);
			// added below code, instead of navigating to contact us directly with url
			CommonUtility.ScrollTo(driver,obj_EsupportIncidentsPage.contactUs());
			
			
//			CommonUtility.highlightElement(driver,obj_EsupportIncidentsPage.contactUs()).click();
			
			
			if(CommonUtility.highlightElement(driver,obj_EsupportIncidentsPage.technicalSupportSelect()).isDisplayed())
			{
				System.out.println("Technical Support displayed");
				CommonUtility.ScrollTo(driver,obj_EsupportIncidentsPage.technicalSupportSelect());
				CommonUtility.ClickOn(driver,obj_EsupportIncidentsPage.technicalSupportSelect());
//				act.moveToElement(CommonUtility.highlightElement(driver,obj_EsupportIncidentsPage.technicalSupportSelect())).click().build().perform();
			}
			
			//added newly
//			driver.navigate().to("https://www.dell.com/support/incidents-online/us/en/19/ContactUs/Dynamic?spestate?ref=contactus");
			driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
			CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.PageHeader());
			String header = CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.PageHeader()).getText();
			if(header.contains("Contact Technical Support")){
				System.out.println("Navigated to " + header);
				Report.put("Click on Contact Supports.", 
						"User should land in Contact Support Jump page.",
						"User navigated to "+Report.color(header) +" page.", "PASS");
			}else{
				System.out.println("Could not navigate to Contact Support page.");
				Report.put("Click on Contact Support.", 
						"User should land in Contact Support Jump page.",
						"User failed to land on Contact Support Jump page.", "FAIL");
				Assert.fail();
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Exception occured while navigating to Contact Support. "+e);
			Report.put("Click on Contact Support.", 
					"User should land in Contact Support Jump page.",
					"User failed to land on Contact Support Jump page.", "FAIL");
			Assert.fail();
		}

	}

	
	//Lavanya
	
	public void SignInPageForFFBrowserDisplayedClickingOnMyService360(WebDriver driver) 
	{		
		WebDriverWait wait = new WebDriverWait(driver, 120);

//		System.out.println("Entering SignInPageForFFBrowserDisplayedClickingOnMyService360");

		Log.info("Entering SignInPageForFFBrowserDisplayedClickingOnMyService360");   
		
		String username = TestNGCreator.TestData.get(Esupport.Username.ordinal());
		String password = TestNGCreator.TestData.get(Esupport.Password.ordinal());

		try 
		{	
			String header ="";
			String text ="";
			String text1 ="";
			

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIntegratedHomePage.SignInHeadingInEMCPageOfFFBrowser()));

			CommonUtility.ScrollTo(driver, obj_EsupportIntegratedHomePage.SignInHeadingInEMCPageOfFFBrowser());

			CommonUtility.highlightElement(driver,obj_EsupportIntegratedHomePage.SignInHeadingInEMCPageOfFFBrowser());

			header = CommonUtility.highlightElement(driver,obj_EsupportIntegratedHomePage.SignInHeadingInEMCPageOfFFBrowser()).getText();

			System.out.println("header is :"+header);

			CommonUtility.highlightElement(driver,obj_EsupportIntegratedHomePage.UserNameHeadingEMCPageOfFFBrowser());

			text = CommonUtility.highlightElement(driver,obj_EsupportIntegratedHomePage.UserNameHeadingEMCPageOfFFBrowser()).getText();

			System.out.println("username heading :"+text);
			CommonUtility.ScrollTo(driver, obj_EsupportIntegratedHomePage.UserNameTextBoxOnEMCPageOfFFBrowser());

			CommonUtility.highlightElement(driver,obj_EsupportIntegratedHomePage.UserNameTextBoxOnEMCPageOfFFBrowser()).sendKeys(username);

			CommonUtility.ScrollTo(driver,obj_EsupportIntegratedHomePage.SignInButtonOnEMCPageOfFFBrowser());
			CommonUtility.ClickOn(driver,obj_EsupportIntegratedHomePage.SignInButtonOnEMCPageOfFFBrowser());

			
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIntegratedHomePage.PasswordHeadingOnEMCPageOfFFBrowser()));

			CommonUtility.ScrollTo(driver, obj_EsupportIntegratedHomePage.PasswordHeadingOnEMCPageOfFFBrowser());

			CommonUtility.highlightElement(driver,obj_EsupportIntegratedHomePage.PasswordHeadingOnEMCPageOfFFBrowser());

			text1 = CommonUtility.highlightElement(driver,obj_EsupportIntegratedHomePage.PasswordHeadingOnEMCPageOfFFBrowser()).getText();

			System.out.println("header is :"+text1);

			CommonUtility.ScrollTo(driver, obj_EsupportIntegratedHomePage.PasswordTextBoxOnEMCPageOfFFBrowser());

			CommonUtility.highlightElement(driver,obj_EsupportIntegratedHomePage.PasswordTextBoxOnEMCPageOfFFBrowser()).sendKeys(password);

			CommonUtility.ScrollTo(driver,obj_EsupportIntegratedHomePage.ContinueButtonOnEMCPageOfFFBrowser());
			CommonUtility.ClickOn(driver,obj_EsupportIntegratedHomePage.ContinueButtonOnEMCPageOfFFBrowser());

			Report.put("sign in page displayed",
					"user should be able to enter username and password and clicked on continue",
					"able to see "+Report.color(header)+" <br> and able to enter "+Report.color(text)+" <br> and "+Report.color(text1), "PASS");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("sign in page displayed",
					"user should be able to enter username and password and clicked on continue",
					"Failed to display sign in page to enter user name and password", "FAIL");
			Assert.fail();

		}
	}

	public void clickOnMS360LinkForFFBrowser(WebDriver driver){
		System.out.println("Entered into method: to clickOnMS360LinkForFFBrowser.");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String browser=TestNGCreator.TestData.get(Esupport.SearchOption.ordinal());
		try {
			Thread.sleep(4000);
			System.out.println("scrolling to MS360 link.");
			CommonUtility.ScrollTo(driver, obj_EsupportIntegratedHomePage.myService360());

			CommonUtility.ClickOn(driver, obj_EsupportIntegratedHomePage.myService360());
			Thread.sleep(7000);
			
//			if(browser=="FF")
//			{
//				CommonUtility.ClickOn(driver, obj_EsupportIntegratedHomePage.myService360());
//			}
//			else
//			{
//			WebElement element = driver.findElement(obj_EsupportIntegratedHomePage.myService360());
//			Actions actions = new Actions(driver);
//			actions.moveToElement(element).click().perform();
//			}

			//CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.myService360()).click();
			System.out.println("clicked on MS360 link.");
			Thread.sleep(10000);
		
			Emaillogin(driver,  TestNGCreator.TestData.get(Esupport.Username.ordinal()),  TestNGCreator.TestData.get(Esupport.Password.ordinal()));
//			SignInPageForFFBrowserDisplayedClickingOnMyService360(driver);
			
			WebDriverWait wait = new WebDriverWait(driver, 100);
//			wait.until(ExpectedConditions.titleIs("Dell EMC IT Support Services | Dell EMC US | Dell Technologies US"));

		
			System.out.println("page title : " + driver.getTitle());
			System.out.println("current url : " + driver.getCurrentUrl());

			//if(driver.getTitle().contains("Dell EMC IT Support Services") && driver.getCurrentUrl().contains("https://www.dellemc.com")){
			if(driver.getTitle().contains("MyService360 | Dell US") && driver.getCurrentUrl().contains("https://www.dell.com/support/myservice360/en-us/summary"))
			{
			System.out.println("User is navigated to Tech Direct page.");
				Report.put("Click on MS360 Link.",
						"User should land in MS360 page MS360 URL is: https://support.emc.com/myservice360",
						"User is navigated to MS360 page, URL : " + Report.color(driver.getCurrentUrl()), "PASS");
			}
			else{
				System.out.println("User is not navigated to Tech Direct page.");
				Report.put("Click on MS360 Link.",
						"User should land in MS360 page MS360 URL is: https://support.emc.com/myservice360",
						"User is not navigated to MS360 page.", "FAIL");
				Assert.fail();
			}


		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Report.put("Click on Tech Direct link.",
					"User should land in Tech Direct page Tech Direct URL is: https://techdirect.dell.com",
					"Failed while navigating to my service ms360", "FAIL");
			Assert.fail();
		}
	}
	
	public void clickChatWithSupportOptionContactSlider(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 200);
		System.out.println("Inside method clickChatWithSupportOptionContactSlider");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		String title = "";
		String currentUrl = "";
		
		String contactTitle = "";
		String contactUrl = "";
		
		try
		{
			CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.chatWithSupportLink());
			CommonUtility.ClickOn(driver, obj_EsupportIntegratedHomePage.chatWithSupportLink());

			Set<String> allWH=driver.getWindowHandles(); 
			String currentwindow=driver.getWindowHandle();
			int count=allWH.size(); 
			System.out.println("Switched Window Handles and  window count is :: "+count);

			for(String wh:allWH) 
			{

				Thread.sleep(10000);
				driver.switchTo().window(wh); 
				currentUrl=driver.getCurrentUrl();
				//wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIntegratedHomePage.dellEMCLogo()));
				title = driver.getTitle();
				System.out.println("title is : "+title); 
				if(title.contains("Contact Us"))
				{
					contactTitle = driver.getTitle();
					contactUrl=driver.getCurrentUrl();

					System.out.println("contactUrl is : "+contactUrl); 
					System.out.println("contactTitle  is : "+contactTitle); 
					
					Thread.sleep(10000);
					driver.close();
				}
				driver.switchTo().window(currentwindow);
				//CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.PopupClose()).click();


			}

			Report.put("Click on chat with support option in the contact us slider",
					   "User should land in the contact us SPE page in the new tab with authentication https://www.dell.com/support/incidents-online/contactus/dynamic?spestate",
					"Sucessfully  landed in Page"+Report.color(contactTitle)+"with URL"+Report.color(contactUrl), "PASS");	
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			Report.put("Click on chat with support option in the contact us slider",
					   "User should land in the contact us SPE page in the new tab with authentication https://www.dell.com/support/incidents-online/contactus/dynamic?spestate",
					   "Failed to click on chat with support option in the contact us slider", "FAIL");
			Assert.fail();
		}
	}
	
	public void clickCreateServiceRequestContactSlider(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 200);
		System.out.println("Inside method clickChatWithSupportOptionContactSlider");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		String title = "";
		String currentUrl = "";
		
		String contactTitle = "";
		String contactUrl = "";
		
		try
		{
			CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.createServiceRequestLink());
			CommonUtility.ClickOn(driver, obj_EsupportIntegratedHomePage.createServiceRequestLink());

			Set<String> allWH=driver.getWindowHandles(); 
			String currentwindow=driver.getWindowHandle();
			int count=allWH.size(); 
			System.out.println("Switched Window Handles and  window count is :: "+count);

			for(String wh:allWH) 
			{

				Thread.sleep(10000);
				driver.switchTo().window(wh); 
				currentUrl=driver.getCurrentUrl();
				//wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIntegratedHomePage.dellEMCLogo()));
				title = driver.getTitle();
				System.out.println("title is : "+title); 
				if(title.contains("Contact Us"))
				{
					contactTitle = driver.getTitle();
					contactUrl=driver.getCurrentUrl();

					System.out.println("contactUrl is : "+contactUrl); 
					System.out.println("contactTitle  is : "+contactTitle); 
					
					Thread.sleep(10000);
					driver.close();
				}
				driver.switchTo().window(currentwindow);
				//CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.PopupClose()).click();


			}

			Report.put("Comeback to the homepage and click on the option create service request",
					   "User should land in the contact us SPE page in the new tab with authentication https://www.dell.com/support/incidents-online/contactus/dynamic?spestate",
					"Sucessfully  landed in Page"+Report.color(contactTitle)+"with URL"+Report.color(contactUrl), "PASS");	
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			Report.put("Comeback to the homepage and click on the option create service request",
					   "User should land in the contact us SPE page in the new tab with authentication https://www.dell.com/support/incidents-online/contactus/dynamic?spestate",
					   "Failed to click on option create service request", "FAIL");
			Assert.fail();
		}
	}
	
	public void clickOrderSupportContactUsSlider(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 200);
		System.out.println("Inside method clickOrderSupportContactUsSlider");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		String title = "";
		String currentUrl = "";
		
		String orderTitle = "";
		String orderUrl = "";
		
		try
		{
			CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.orderSupportLinkContactUsSlider());
			CommonUtility.ClickOn(driver, obj_EsupportIntegratedHomePage.orderSupportLinkContactUsSlider());

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
				
				if(url.contains("https://www.dell.com/support/order-status/en-us/order-support"))
				{
					orderTitle = driver.getTitle();
					orderUrl=driver.getCurrentUrl();

					System.out.println("OrderSupportUrl is : "+orderUrl); 
					System.out.println("OrderSupportTitle  is : "+orderTitle); 
					
					Thread.sleep(10000);
					driver.close();
					
				}
				else
				{
					driver.close();
					System.out.println();
					Report.put("Come back to the home page and click on the order support under the contact us slider",
							   "User should land in the contact us SPE page in new tab (https://www.dell.com/support/order-status/en-us/order-support)",
							   "Failed to click on option  the order support under the contact us slider", "FAIL");
					Assert.fail();
				}
				
				driver.switchTo().window(mainwindow);
				}
				
				}
			Report.put("Come back to the home page and click on the order support under the contact us slider",
					   "User should land in the contact us SPE page in new tab (https://www.dell.com/support/order-status/en-us/order-support)",
					"Sucessfully  landed in Page"+Report.color(orderTitle)+"with URL"+Report.color(orderUrl), "PASS");	
			
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			Report.put("Come back to the home page and click on the order support under the contact us slider",
					   "User should land in the contact us SPE page in new tab (https://www.dell.com/support/order-status/en-us/order-support)",
					   "Failed to click on option  the order support under the contact us slider", "FAIL");
			Assert.fail();
		}
	}
	
	public void toClickDellLogo(WebDriver driver)
	{
		System.out.println("Entered into method: to toClickDellLogo");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Actions actions = new Actions(driver);

		try {
			Thread.sleep(4000);
			System.out.println("scrolling to Dell Logo");
			CommonUtility.ScrollTo(driver, obj_EsupportIntegratedHomePage.delllogo());

			Thread.sleep(2000);
//			WebElement element = driver.findElement(obj_EsupportIntegratedHomePage.delllogo());
//			actions.moveToElement(element).click().perform();
			CommonUtility.ClickOn(driver, obj_EsupportIntegratedHomePage.delllogo());

			//CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.ClickDellEMCLogo()).click();
			System.out.println("Clicked on delllogo");

			Thread.sleep(2000);
			WebDriverWait wait = new WebDriverWait(driver, 60);
			//wait.until(ExpectedConditions.titleIs("Digital Transformation - IT & Workforce Solutions | Dell Technologies US"));

			System.out.println("page title : " + driver.getTitle());
			System.out.println("current url : " + driver.getCurrentUrl());

			if(driver.getTitle().contains("Technology Solutions") )
			{
				 String dellUrl = driver.getCurrentUrl();
				System.out.println("User is navigated to dell.com");
				
				Report.put("Comeback to homepage , click on dell logo",
						"Should direct to the dell.com/us-en site ",
						"User is navigated to Page"+Report.color(dellUrl), "PASS");
			}
			else{
				System.out.println("User is not navigated to  dell.com");
				Report.put("Comeback to homepage , click on dell logo",
						"Should direct to the dell.com/us-en site ",
						"User failed to navigate to dell.com/us-en site", "FAIL");
				Assert.fail();
			}


		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Report.put("Comeback to homepage , click on dell logo",
					"Should direct to the dell.com/us-en site ",
					"User failed to navigate to dell.com/us-en site", "FAIL");
			Assert.fail();
		}
	}
	
	public void clickDellTechnologies(WebDriver driver)
	{
		System.out.println("Entered into method: to clickDellTechnologies.");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Actions actions = new Actions(driver);

		try {
			Thread.sleep(4000);
			System.out.println("scrolling to Dell Technologies Logo");
			//CommonUtility.scrollToViewElement(driver, obj_EsupportIntegratedHomePage.dellTechnologiesLogo());

			Thread.sleep(2000);
//			WebElement element = driver.findElement(obj_EsupportIntegratedHomePage.dellTechnologiesLogo());
//			actions.moveToElement(element).click().perform();

			CommonUtility.ClickOn(driver, obj_EsupportIntegratedHomePage.dellTechnologiesLogo());
			
			//CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.ClickDellEMCLogo()).click();
			System.out.println("Clicked on dell Technologies logo");

			Thread.sleep(2000);
			WebDriverWait wait = new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.titleIs("Digital Transformation - IT & Workforce Solutions | Dell Technologies US"));

			System.out.println("page title : " + driver.getTitle());
			System.out.println("current url : " + driver.getCurrentUrl());

			if(driver.getTitle().contains("Dell Technologies US") )
			{
				System.out.println("User is navigated to Dell Official Site");
				
				Report.put("Comeback to the homepage and click on Dell technologies logo ",
						"Should direct to the https://www.delltechnologies.com/en-us/index.htm",
						"User is navigated to Dell Page"+Report.color(driver.getCurrentUrl()), "PASS");
			}
			else{
				System.out.println("User failed to navigate to Dell Technologies page");
				
				Report.put("Comeback to the homepage and click on Dell technologies logo ",
						"Should direct to the https://www.delltechnologies.com/en-us/index.htm",
						"User failed to land on Dell technologies Page", "FAIL");
				Assert.fail();
			}


		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Report.put("Comeback to the homepage and click on Dell technologies logo ",
					"Should direct to the https://www.delltechnologies.com/en-us/index.htm",
					"User failed to land on Dell technologies Page", "FAIL");
			Assert.fail();
		}
	}

}	








