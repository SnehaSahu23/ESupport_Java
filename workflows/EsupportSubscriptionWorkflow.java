

package com.dell.delta_uat_automation.esupport.workflows;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
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



public class EsupportSubscriptionWorkflow extends BaseFlow {
	//Mamta
	ArrayList<String>List_type= new ArrayList<String>();
	//Sudha
	String User1count="";
	String User2count="";
	int count1,count2;
	String[] username=TestNGCreator.TestData.get(Esupport.Username.ordinal()).split(";");   
	String[] password=TestNGCreator.TestData.get(Esupport.Password.ordinal()).split(";");

	public void handleCookies(WebDriver driver)
	{
		System.out.println("Handle Cookies");
		Log.info("Handle Cookies");	
		try{
			WebDriverWait wait = new WebDriverWait(driver, 50);
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			if(CommonUtility.CheckpresenceofElementLocated(driver, 5, obj_EsupportOrderHomePage.acceptCookies()))
			{
				CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.acceptCookies()).click(); 	
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
		driver.manage().timeouts().implicitlyWait(240, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(240, TimeUnit.SECONDS);

	}  


	public void  TOClick_LOGINSigninButton(WebDriver driver,String username,String pwd) 
	{
		System.out.println("Entering method to TOClick_LOGINSigninButton");
		WebDriverWait  wait = new WebDriverWait(driver, 120);

		try
		{
			String ManualDocheader="";
			//driver.navigate().refresh();
			handleCookies(driver);

			CommonUtility.highlightElement(driver, obj_EsupportSubscriptionHomePage.Signinclick());
			CommonUtility.highlightElement(driver, obj_EsupportSubscriptionHomePage.Signinclick()).click();

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportSubscriptionHomePage.UserName()));

			CommonUtility.highlightElement(driver,obj_EsupportSubscriptionHomePage.UserName()).clear();
			CommonUtility.highlightElement(driver,obj_EsupportSubscriptionHomePage.UserName()).sendKeys(username);
			CommonUtility.highlightElement(driver,obj_EsupportSubscriptionHomePage.Password()).clear();
			CommonUtility.highlightElement(driver,obj_EsupportSubscriptionHomePage.Password()).sendKeys(pwd);

			CommonUtility.highlightElement(driver,obj_EsupportSubscriptionHomePage.SignIn()).click();
			Thread.sleep(1000);



			Report.put("Enter the Username and Password and click on sign in ",
					"Enter the '"+Report.color(username)+"' and '"+Report.color(pwd)+"' and click on sign in", 
					"User should sucessfully logged in to subscriptions page ", "PASS");

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Enter the Username and Password and click on sign in ",
					"User is not able to login with the creadentials", 
					"User is not able to login with the creadentials", "FAIL");
			Assert.fail();
		}
	}


	public void  TOClick_CreateSubscriptionButton(WebDriver driver) 
	{
		System.out.println("Entering in to method TOClick_CreateSubscriptionButton");
		WebDriverWait  wait = new WebDriverWait(driver, 120);
		System.out.println("After webdriver wait");
		Actions act=new Actions(driver);

		try
		{
			Thread.sleep(6000);
			//handleCookies(driver);
			Thread.sleep(3000);

			//	handleCookies(driver);


			wait.until(ExpectedConditions.elementToBeClickable(obj_EsupportSubscriptionHomePage.ClickOnSubscription()));


			CommonUtility.ScrollTo(driver,obj_EsupportSubscriptionHomePage.ClickOnSubscription());

			CommonUtility.ClickOn(driver,obj_EsupportSubscriptionHomePage.ClickOnSubscription());


			//			act.moveToElement(CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.Driverheadersubscription())).build().perform();
			handleCookies(driver);
			Thread.sleep(6000);
			CommonUtility.ScrollTo(driver,obj_EsupportDriversandDownloadsPage.Driverheadersubscription());
			//			Thread.sleep(5000);


			String Driverheadersubscription=CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.Driverheadersubscription()).getText();



			Report.put("Click on new subscription under the Drivers updates   ",
					"User should get the "+ Report.color(Driverheadersubscription)+" page and select product highlighted with all products and list of family products " ,
					"Successfully User should land in "+ Report.color(Driverheadersubscription)+" Page. " , "PASS");


			Thread.sleep(2000);

			String Packingslip=CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.Driverheadersubscription()).getText();




		}catch(Exception e)
		{
			e.printStackTrace();
			Report.put("User is login into Premier account", "Premier Sign in page must be displayed", "Premier Sign in page is not displayed", "Fail");
			Report.put("Enter valid credentials and select the required store ", "Coresponding premier store must be displayed", "Coresponding premier store is not displayed", "Fail");

			//Report.put("Click on the search by drop down", "System should display below mentioned values in the drop down", "Fields are not available", "Fail");
			Assert.fail();
		}
	}


	public void  toSelectOperatingSystem(WebDriver driver) 
	{
		System.out.println("Select Operating System");
		WebDriverWait  wait = new WebDriverWait(driver, 120);
		System.out.println("After webdriver wait");
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		//		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
		try
		{
			//			driver.navigate().refresh();
			//handleCookies(driver);
			//wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDriversandDownloadsPage.operatingSystem()));
			Thread.sleep(5000);
			CommonUtility.ScrollTo(driver, obj_EsupportDriversandDownloadsPage.operatingSystem());
			CommonUtility.ClickOn(driver, obj_EsupportDriversandDownloadsPage.operatingSystem());
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDriversandDownloadsPage.components()));

			Report.put("Select Operating System in available Operating systems", "Application should display Components for the selected OS and it application should allow the user to select all components are he can choose from the available Components", "Application displayed Components for the selected OS and it application should allow the user to select all components are he can choose from the available Components", "PASS");
			//Report.put("Select Operating System in available Operating systems", "Application should display Components for the selected OS and it application should allow the user to select all components are he can choose from the available Components", "Application is not displayed Components for the selected OS and it application should allow the user to select all components are he can choose from the available Components", "FAIL");
			CommonUtility.ScrollTo(driver, obj_EsupportDriversandDownloadsPage.components());
			//			CommonUtility.ClickOn(driver, obj_EsupportDriversandDownloadsPage.components());
			CommonUtility.ScrollTo(driver, obj_EsupportDriversandDownloadsPage.compCheckbox());
			CommonUtility.ClickOn(driver, obj_EsupportDriversandDownloadsPage.compCheckbox());

			Report.put("select any 1 operating system", "user should show with list of components with list  ",
					"Successfully user should show with list of components with list ", "PASS");

			((JavascriptExecutor)driver).executeScript("arguments[0].click();", CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.Continue())); 
			//CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.Continue()).sendKeys(Keys.ENTER);
			Thread.sleep(1000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDriversandDownloadsPage.Driverheadersubscription()));
			CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.Driverheadersubscription());

			System.out.println("Selecting Components");

			Report.put("select any one from the list say application ", "User Should select the application and continue should be enabled   ",
					"Successfully User Should select the application and continue should be enabled  ", "PASS");


		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("select any 1 operating system", "User is not able to show with list of components with list  ",
					"User is not able to show with list of components with list ", "FAIL");

			Assert.fail();
		}
	}
	public void  toEnterSubscription(WebDriver driver) 
	{
		System.out.println("Select Operating System");
		WebDriverWait  wait = new WebDriverWait(driver, 120);
		System.out.println("After webdriver wait");
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		//		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
		try
		{
			List oRadioButton = driver.findElements(By.xpath("//label[@class='custom-control-label']"));
			boolean bValue = false;
			bValue = ((WebElement) oRadioButton.get(0)).isSelected();

			if(bValue = true){
				((WebElement) oRadioButton.get(1)).click();

			}else{
				((WebElement) oRadioButton.get(0)).click();

			}
			//CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.subContinue()).submit();
			((JavascriptExecutor)driver).executeScript("arguments[0].click();", CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.subContinue())); 
			Thread.sleep(1000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDriversandDownloadsPage.Driverheadersubscription()));
			CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.Driverheadersubscription());
			CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.productEdit());
			CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.componentEdit());

			CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.save());

			CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.cancel());


			Report.put("Enter Subscription name(Optional) Select  notifications Type(All Updates, Critical or recommended updates only or Critical updates only) and Click on Continue button", "Application should navigate to Review Subscripions and it should allow the user to edit Product, Coponents, Subscription Preferences along with Save and Cancel button", "Application navigated to Review Subscripions and it should allow the user to edit Product, Coponents, Subscription Preferences along with Save and Cancel button", "PASS");

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Enter Subscription name(Optional) Select  notifications Type(All Updates, Critical or recommended updates only or Critical updates only) and Click on Continue button", "Application should navigate to Review Subscripions and it should allow the user to edit Product, Coponents, Subscription Preferences along with Save and Cancel button", "Application is not navigated to Review Subscripions and it should allow the user to edit Product, Coponents, Subscription Preferences along with Save and Cancel button", "FAIL");
			Assert.fail();
		}
	}
	public void  clickSaveButton(WebDriver driver) 
	{
		System.out.println("ClicKing on Save Button");
		WebDriverWait  wait = new WebDriverWait(driver, 120);
		System.out.println("After webdriver wait");
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
		try
		{
			//driver.navigate().refresh();
			//handleCookies(driver);
			//wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDriversandDownloadsPage.supportHeading()));
			CommonUtility.ScrollTo(driver,obj_EsupportDriversandDownloadsPage.save());
			CommonUtility.ClickOn(driver,obj_EsupportDriversandDownloadsPage.save());
			//			((JavascriptExecutor)driver).executeScript("arguments[0].click();", CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.save())); 
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDriversandDownloadsPage.driverUpdatesubscription()));
			//			CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.driverUpdatesubscription()).click();
			System.out.println("Clicked on Save Button");
			Report.put("Click on Save button", "Subscription should be saved. Application should navigate to Driver Updates Subscriptions page and it should display saved Subscription in  Subscriptions grid.", "Application navigated to Driver Updates Subscriptions page and it should display saved Subscription in  Subscriptions grid.", "PASS");

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on Save button", "Subscription should be saved. Application should navigate to Driver Updates Subscriptions page and it should display saved Subscription in  Subscriptions grid.", "Application is not navigated to Driver Updates Subscriptions page and it should display saved Subscription in  Subscriptions grid.", "FAIL");
			Assert.fail();
		}
	}
	public void  reviewSubscription(WebDriver driver) 
	{
		System.out.println("Review Subscription");
		WebDriverWait  wait = new WebDriverWait(driver, 120);
		System.out.println("After webdriver wait");
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		//		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
		try
		{
			//handleCookies(driver);
			CommonUtility.ScrollTo(driver,obj_EsupportDriversandDownloadsPage.firstrow());
			CommonUtility.ClickOn(driver,obj_EsupportDriversandDownloadsPage.firstrow());

			System.out.println("First row Highlighted");
			Report.put("Review the subscription and click on Save button", "Email Subscription should be saved for the selected product", "Email Subscription saved for the selected product", "PASS");

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Review the subscription and click on Save button", "Email Subscription should be saved for the selected product", "Email Subscription is not saved for the selected product", "PASS");

			Assert.fail();
		}
	}

	public void  DeleteRecord(WebDriver driver) 
	{


		System.out.println("ClicKing on Save Button");
		WebDriverWait  wait = new WebDriverWait(driver, 120);
		System.out.println("After webdriver wait");
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
		try
		{
			Thread.sleep(5000);
			//driver.findElement(obj_EsupportDriversandDownloadsPage.Firstrowchk()).click();
			//			driver.findElement(obj_EsupportDriversandDownloadsPage.DeleteSelected());
			CommonUtility.ScrollTo(driver, obj_EsupportDriversandDownloadsPage.DeleteSelected());
			CommonUtility.ClickOn(driver, obj_EsupportDriversandDownloadsPage.DeleteSelected());
			OpenThePopWindow(driver);			

			CommonUtility.ScrollTo(driver, obj_EsupportDriversandDownloadsPage.DeleteSub());
			CommonUtility.ClickOn(driver, obj_EsupportDriversandDownloadsPage.DeleteSub());

			//			driver.findElement(obj_EsupportDriversandDownloadsPage.DeleteSub()).click();
			//driver.findElement(obj_EsupportDriversandDownloadsPage.ClosePopup()).click();

			CommonUtility.ScrollTo(driver, obj_EsupportDriversandDownloadsPage.ClosePopup());
			CommonUtility.ClickOn(driver, obj_EsupportDriversandDownloadsPage.ClosePopup());
			//			((JavascriptExecutor)driver).executeScript("arguments[0].click();", CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.ClosePopup())); 
			//			Thread.sleep(5000);

			Report.put("Again click on delete button besides the subscription", 
					"User should get screen delete subscriptions with message this will permanently delete the subscription ", 
					"Successfully user should get screen delete subscriptions with message this will permanently delete the subscription ", "PASS");


		}
		catch(Exception e)
		{
			e.printStackTrace();

			Report.put("Again click on delete button besides the subscription", 
					"User is not able to get screen delete subscriptions with message this will permanently delete the subscription ", 
					"User is not able to get screen delete subscriptions with message this will permanently delete the subscription", "FAIL");

			Assert.fail();
		}
	}

	public void  SelectProduct(WebDriver driver) 
	{
		System.out.println("In Function Select Product");
		WebDriverWait  wait = new WebDriverWait(driver, 120);
		String ClickingonLattitude="";
		System.out.println("After webdriver wait");
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
		Actions act=new Actions(driver);
		try
		{
			CommonUtility.ScrollTo(driver, obj_EsupportDriversandDownloadsPage.ClickingonLaptops());

			//  wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDriversandDownloadsPage.supportHeading()));
			CommonUtility.ClickOn(driver, obj_EsupportDriversandDownloadsPage.ClickingonLaptops());

			System.out.println("Clicked on ClickLaptops_Tab Link");

			Report.put("Click on any product , Click on Laptops", "It should drill down to another level with series of  names like inispiron  , latitude etc", 
					"Successfully it should drill down to another level with series of  names like inispiron  , latitude etc", "PASS");

			Thread.sleep(3000);
			CommonUtility.ScrollTo(driver, obj_EsupportDriversandDownloadsPage.ClickingonLattitude());

			CommonUtility.ClickOn(driver, obj_EsupportDriversandDownloadsPage.ClickingonLattitude());
			Thread.sleep(3000);
			System.out.println("Clicked on Lattitude Link");
			CommonUtility.ScrollTo(driver, obj_EsupportSubscriptionHomePage.latitudeSeries());
			CommonUtility.ClickOn(driver, obj_EsupportSubscriptionHomePage.latitudeSeries());
			Thread.sleep(3000);
			Report.put("Click on latitude", 
					"User should again drill down to list of the available products under latitude", 
					"Successfully User should again drill down to list of the available products under latitude", "PASS");


			//			act.moveToElement(CommonUtility.highlightElement(driver, obj_EsupportSubscriptionHomePage.ClickonD410Product())).build().perform();
			//
			//			CommonUtility.highlightElement(driver, obj_EsupportSubscriptionHomePage.ClickonD410Product());
			//
			//			CommonUtility.highlightElement(driver, obj_EsupportSubscriptionHomePage.ClickonD410Product()).click();

			//			act.moveToElement(CommonUtility.highlightElement(driver, obj_EsupportSubscriptionHomePage.latitudeProduct())).build().perform();
			CommonUtility.ScrollTo(driver, obj_EsupportSubscriptionHomePage.latitudeProduct());
			CommonUtility.ClickOn(driver, obj_EsupportSubscriptionHomePage.latitudeProduct());

			System.out.println("Clicked on latitude product Link");

			Report.put("Select any available product model say Latitude D410 ", 
					"User should land in select components of that selected model , operating systems", 
					"Successfully User should land in select components of that selected model , operating systems", "PASS");


			//			driver.navigate().refresh();

			//act.moveToElement(CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.Headerservicetag())).build().perform();

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportSubscriptionHomePage.HeaderOfProductSelected()));
			CommonUtility.highlightElement(driver, obj_EsupportSubscriptionHomePage.HeaderOfProductSelected());

			ClickingonLattitude=CommonUtility.highlightElement(driver, obj_EsupportSubscriptionHomePage.HeaderOfProductSelected()).getAttribute("innerText");


			System.out.println("Header displayed as "+ClickingonLattitude);

			Thread.sleep(3000);



		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on Change Product", "Application should disaplay All available Products ", "Application disaplayed All available Products ", "PASS");
			Assert.fail();
		}
	}

	public void handleNotificationFrequency(WebDriver driver)
	{
		String ltMessages="";
		try {
			CommonUtility.ScrollTo(driver,obj_EsupportDriversandDownloadsPage.notificationFrequency());
			List<WebElement> list=driver.findElements(obj_EsupportDriversandDownloadsPage.notificationFrequency());

			for(WebElement lt:list)
			{
				CommonUtility.highlightElement(driver, lt);
				String names=lt.getText();

				System.out.println("Alert Name is: " +names);
				ltMessages+=" <br> " + names;


			}
			System.out.println("options------------------>"+ltMessages);
			Report.put("Verify Notification Frequency options", "Application should provide following notification Types: Daily,Weekly,Every Two Weeks,Monthly", "Notification Frequency options "+Report.color(ltMessages), "PASS");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public void  ToCancelDeleteRecord(WebDriver driver) 
	{
		System.out.println("Entering method in to the ToCancelDeleteRecord");
		WebDriverWait  wait = new WebDriverWait(driver, 120);
		System.out.println("After webdriver wait");

		try
		{
			CommonUtility.ScrollTo(driver, obj_EsupportDriversandDownloadsPage.Firstrowchk());
			CommonUtility.ClickOn(driver, obj_EsupportDriversandDownloadsPage.Firstrowchk());

			CommonUtility.ScrollTo(driver, obj_EsupportDriversandDownloadsPage.DeleteSelected());
			CommonUtility.ClickOn(driver, obj_EsupportDriversandDownloadsPage.DeleteSelected());
			//driver.findElement(obj_EsupportDriversandDownloadsPage.Firstrowchk()).click();
			//driver.findElement(obj_EsupportDriversandDownloadsPage.DeleteSelected()).click();
			OpenThePopWindow(driver);			
			//driver.findElement(obj_EsupportDriversandDownloadsPage.DeleteSub()).click();
			CommonUtility.ScrollTo(driver, obj_EsupportSubscriptionHomePage.CancelButton());
			CommonUtility.ClickOn(driver, obj_EsupportSubscriptionHomePage.CancelButton());
			//driver.findElement(obj_EsupportSubscriptionHomePage.CancelButton()).click();
			Report.put("Click on Cancel", "should go back to the Driver subscriptions page", "Successfully should go back to the Driver subscriptions page ", "PASS");


		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on Cancel", "Not able to display Driver subscriptions page", 
					"Not able to display Driver subscriptions page ", "FAIL");


			Assert.fail();
		}
	}


	public void  TOVerifyFieldsServiceRequestSubscription(WebDriver driver) 
	{
		System.out.println("Entering in method TOVerify_FieldsServiceRequestSubscription");
		WebDriverWait  wait = new WebDriverWait(driver, 120);

		try
		{
			//	handleCookies(driver);
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportSubscriptionHomePage.SupportPageHeader()));
			CommonUtility.highlightElement(driver,obj_EsupportSubscriptionHomePage.SupportPageHeader());

			String supportHeader=CommonUtility.highlightElement(driver,obj_EsupportSubscriptionHomePage.SupportPageHeader()).getText();

			String Messages="";
			CommonUtility.highlightElement(driver,obj_EsupportSubscriptionHomePage.Supportnotificationfields());

			List<WebElement> list=driver.findElements(obj_EsupportSubscriptionHomePage.Supportnotificationfields());


			for(int i=0;i<2;i++)
			{
				CommonUtility.highlightElement(driver,By.xpath("//p/strong)[i]"));
				String field=driver.findElement(By.xpath("//p/strong)[i]")).getText();
				System.out.println("Fields: " +field);
				Messages+=" <br> " + field;
			}
			String field1=CommonUtility.highlightElement(driver,obj_EsupportSubscriptionHomePage.TypeofNotification1()).getText();
			String field2=CommonUtility.highlightElement(driver,obj_EsupportSubscriptionHomePage.TypeofNotification2()).getText();

			Messages+=" <br> " + field1;
			Messages+=" <br> " + field2;

			Report.put("Verify the Fields", "should have fields"+Report.color(Messages), "All fields Name your subscription ( optional ) with Box,Type of Notifications,Service Requests status changes with check box and Parts shipment or On-site repair status changes with check box", "PASS");

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify the Fields", "should have fields Name your subscription ( optional ) with Box, Type of NotificationsService Requests status changes with check box Parts shipment or On-site repair status changes with check box","Page is not able to navigate ServiceRequest Subscription ", "FAIL");

			Assert.fail();
		}
	}


	//sudha


	public void  ClickPremierSignIn(WebDriver driver) 
	{
		System.out.println("Clicking Premier SignIn");
		WebDriverWait  wait = new WebDriverWait(driver, 120);
		System.out.println("After webdriver wait");
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
		try
		{


			Thread.sleep(4000);
			WebElement element = driver.findElement(By.xpath("//a[@id='lnkPremier']"));
			Actions actions = new Actions(driver);
			actions.moveToElement(element).click().perform();


			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportSubscriptionHomePage.PremierSignInHeading()));


			System.out.println("Clicked on Premier Sign In Page displayed");
			Report.put("Click on sign in to premier", "User should land in premier sign in page", "Application navigated to Premier Sign In page ", "PASS");

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on sign in to premier", "User should land in premier sign in page", "Application is not navigated to Sign In page ", "FAIL");
			Assert.fail();
		}
	}

	public void  premierLogin(WebDriver driver, String account) 
	{
		System.out.println("Clicking Premier SignIn");
		WebDriverWait  wait = new WebDriverWait(driver, 120);
		System.out.println("After webdriver wait");
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		//            driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
		String name = TestNGCreator.TestData.get(Esupport.Username.ordinal()) ;
		String pwd = TestNGCreator.TestData.get(Esupport.Password.ordinal()) ;
		try
		{
			//   handleCookies(driver);
			CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.userName()).clear();
			CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.userName()).sendKeys(name);
			CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.password()).clear();
			CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.password()).sendKeys(pwd);
			CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.signIn());
			CommonUtility.ClickOn(driver,obj_EsupportOrderHomePage.signIn());
			Thread.sleep(3000);


			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportOrderHomePage.selectAccount()));
			CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.selectAccount());

			if(CommonUtility.CheckpresenceofElementLocated(driver, 30, obj_EsupportOrderHomePage.selectAccountdrp()))
			{
				System.out.println("Account dropdown is present");

				Report.put("Enter the premier credentials and click on sign in", "User should show with select account or access group with dropdown list of all the accounts with that user name", "User is selecting account or access group with dropdown list of all the accounts with that user name", "PASS");

			}else
			{
				System.out.println("Account dropdown is not present");

				Report.put("Enter the premier credentials and click on sign in", "User should show with select account or access group with dropdown list of all the accounts with that user name", "User is not able to select account or access group with dropdown list of all the accounts with that user name", "FAIL");
				Assert.fail();
			}

			Thread.sleep(4000);
			CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.selectAccountdrp());
			CommonUtility.ClickOn(driver,obj_EsupportOrderHomePage.selectAccountdrp());


			List<WebElement> elements = driver.findElements(obj_EsupportOrderHomePage.selectlist());
			for (int i = 0; i < elements.size(); i++) {
				String Account=elements.get(i).getText();
				// if(Account.contains(" Balance Innovations [ General Access ]"))

				if(Account. contains(account))
				{

					CommonUtility.ScrollToWebElement(driver, elements.get(i));
					CommonUtility.ClickOnWebElement(driver, elements.get(i));
					System.out.println("Selected Account/Access Group"); 
					Thread.sleep(3000);
					break;
				}
			}
			Thread.sleep(3000);
			CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.accessPremier());
			CommonUtility.ClickOn(driver,obj_EsupportOrderHomePage.accessPremier());

			Thread.sleep(4000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportSubscriptionHomePage.PremierHomeHeader()));
			Report.put("Select any store say balance innovations", "User should land in subscriptions page for the premier store", "User landed in subscriptions page for the premier store", "PASS");


		}catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Select any store say balance innovations", "User should land in subscriptions page for the premier store", "User is not landed in subscriptions page for the premier store", "FAIL");
			Assert.fail();
		}
	}
	public void  TOVerify_Supportnotificationsheadersubheader(WebDriver driver) 
	{
		System.out.println("Entering in method TOVerify_Supportnotificationsheadersubheader");
		WebDriverWait  wait = new WebDriverWait(driver, 120);

		try
		{
			//	handleCookies(driver);
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportSubscriptionHomePage.SupportnotificationHeader()));
			CommonUtility.highlightElement(driver,obj_EsupportSubscriptionHomePage.SupportnotificationHeader());

			String supportNotification=CommonUtility.highlightElement(driver,obj_EsupportSubscriptionHomePage.SupportnotificationHeader()).getText();

			String ltMessages="";
			CommonUtility.highlightElement(driver,obj_EsupportSubscriptionHomePage.Supportnotificationfields());

			List<WebElement> list=driver.findElements(obj_EsupportSubscriptionHomePage.Supportnotificationfields());

			for(WebElement lt:list)
			{
				CommonUtility.highlightElement(driver, lt);
				String names=lt.getText();

				System.out.println("Alert Name is: " +names);
				ltMessages+=" <br> " + names;


			}


			Report.put("Verify the page", "Page is navigate to '"+Report.color(supportNotification)+"' and the subHeaders displayed as "+Report.color(ltMessages), "Successfully Heading should be support notifications with Service Requests , Driver updates , support articles and Preferences Management center with new subscription Button under each Requests  ", "PASS");

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify the page", "Page is not able to navigate Support Notification ","Page is not able to navigate Support Notification ", "FAIL");

			Assert.fail();
		}
	}

	//Sudha 6thFeb
	public void  TOVerify_ServiceRequestSubscription(WebDriver driver) 
	{
		System.out.println("Entering in method TOVerify_Supportnotificationsheadersubheader");
		WebDriverWait  wait = new WebDriverWait(driver, 120);

		try
		{
			handleCookies(driver);
			//wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportSubscriptionHomePage.SupportnotificationHeader()));
			//CommonUtility.highlightElement(driver,obj_EsupportSubscriptionHomePage.SupportnotificationHeader());


			//String supportHeader=CommonUtility.highlightElement(driver,obj_EsupportSubscriptionHomePage.SupportPageHeader()).getText();

			String Messages="";
			//CommonUtility.highlightElement(driver,obj_EsupportSubscriptionHomePage.Supportnotificationfields());

			//List<WebElement> list=driver.findElements(obj_EsupportSubscriptionHomePage.Supportnotificationfields());


			for(int i=0;i<2;i++)
			{
				CommonUtility.highlightElement(driver,By.xpath("//p/strong)[i]"));
				String field=driver.findElement(By.xpath("//p/strong)[i]")).getText();
				System.out.println("Fields: " +field);
				Messages+=" <br> " + field;
			}
			String field1=CommonUtility.highlightElement(driver,obj_EsupportSubscriptionHomePage.TypeofNotification1()).getText();
			String field2=CommonUtility.highlightElement(driver,obj_EsupportSubscriptionHomePage.TypeofNotification2()).getText();

			Messages+=" <br> " + field1;
			Messages+=" <br> " + field2;

			Report.put("Verify the Fields", "should have fields"+Report.color(Messages), "All fields Name your subscription ( optional ) with Box,Type of Notifications,Service Requests status changes with check box and Parts shipment or On-site repair status changes with check box", "PASS");

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify the Fields", "should have fields Name your subscription ( optional ) with Box, Type of NotificationsService Requests status changes with check box Parts shipment or On-site repair status changes with check box","Page is not able to navigate ServiceRequest Subscription ", "FAIL");

			Assert.fail();
		}
	}

	public void  TOClick_CreateSubscriptionButton_ServiceRequests(WebDriver driver) 
	{
		System.out.println("Entering in to method TOClick_CreateSubscriptionButton_ServiceRequests");
		WebDriverWait  wait = new WebDriverWait(driver, 120);
		System.out.println("After webdriver wait");
		Actions act=new Actions(driver);

		try
		{
			Thread.sleep(6000);
			//handleCookies(driver);
			//Thread.sleep(3000);

			handleCookies(driver);


			wait.until(ExpectedConditions.elementToBeClickable(obj_EsupportSubscriptionHomePage.NewSubscription()));


			CommonUtility.highlightElement(driver,obj_EsupportSubscriptionHomePage.NewSubscription());

			CommonUtility.highlightElement(driver,obj_EsupportSubscriptionHomePage.NewSubscription()).click();


			act.moveToElement(CommonUtility.highlightElement(driver,obj_EsupportSubscriptionHomePage.SupportPageHeader())).build().perform();
			handleCookies(driver);
			CommonUtility.highlightElement(driver,obj_EsupportSubscriptionHomePage.SupportPageHeader());
			Thread.sleep(5000);


			String ServiceRequestsheader=CommonUtility.highlightElement(driver, obj_EsupportSubscriptionHomePage.SupportPageHeader()).getText();



			Report.put("Click on New subscriptions below the Service Request",
					"User should go to the"+ Report.color(ServiceRequestsheader)+" page with set your preferences highlighted " ,
					"Successfully User should land in "+ Report.color(ServiceRequestsheader)+" Page. " , "PASS");







		}catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on New subscriptions below the Service Request","User should go to the Service Request page with set your preferences highlighted " ,"User is not redirected to Service Request page","FAIL");

			Assert.fail();
		}
	}
}








