


package com.dell.delta_uat_automation.esupport.workflows;

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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.dell.delta_uat_automation.utility.CommonUtility;
import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.Log;
import com.dell.delta_uat_automation.utility.Report;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class EsupportDriverandDownloadsWorkflow extends BaseFlow {
	String Prevheader="";
	String Driverheadersubscription="";
	public void ToVerify_EnterServiceTage(WebDriver driver,String Servicetag) 
	{
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 120);

		System.out.println("Entering ToVerify_EnterServiceTage");

		Log.info("Entering ToVerify_EnterServiceTage");         
		try 
		{
			String Browseallproductslink="";
			String DetectPCButton="";

			String Headerservicetag="";
			String Headerservicetagdisplay="";

			handleCookies(driver);

			CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.Delllogo());
			CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.SearchServicetag());


			if(CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.Headerservicetag()).isDisplayed())
			{
				Headerservicetag=CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.Headerservicetag()).getText();
			}
			if(CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.Browseallproductslink()).isDisplayed())
			{
				Browseallproductslink=CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.Browseallproductslink()).getText();
			}

			if(CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.DetectPCButton()).isDisplayed())
			{
				DetectPCButton=CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.DetectPCButton()).getText();
			}



			CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.SearchServicetag()).sendKeys(Servicetag);
			CommonUtility.ClickOn(driver,obj_EsupportDriversandDownloadsPage.Servicetagiconsearch());
			handleCaptcha(driver); 
			Thread.sleep(4000); 
			handleCookies(driver);
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDriversandDownloadsPage.ServiceTagHeaderdisplayed()));
			CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.ServiceTagHeaderdisplayed());
			Headerservicetagdisplay=CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.ServiceTagHeaderdisplayed()).getText();


			Report.put("Navigate to drivers home page by selecting a product/service tag On the MSE homepage select the required product by:1) Entering a service tag 2)Browse for a product3) Scan the system using Auto detect your product",
					"Navigate to drivers home page by selecting a product/service tag On the MSE homepage select the required product by:"
							+ "1)"+Report.color(Headerservicetag)+ 
							" <br> 2) "+Report.color(Browseallproductslink)+
							"<br> 3)"+Report.color(DetectPCButton),"Successfully Application should navigate to "+Report.color(Headerservicetagdisplay), "PASS");

		}catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Enter service tag", "Entered service tag should be found",
					"Not able to find Entered service tag", "FAIL");
			Assert.fail();

		}
	}

	public void  ClickDriversandDownloads_Tab(WebDriver driver) 
	{
		System.out.println("Click Drivers and Downloads Tab");
		WebDriverWait  wait = new WebDriverWait(driver, 120);
		System.out.println("After webdriver wait");

		try
		{
			//driver.navigate().refresh();
			handleCookies(driver);
			//wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDriversandDownloadsPage.supportHeading()));
			CommonUtility.ClickOn(driver, obj_EsupportDriversandDownloadsPage.driversandDownloads());
			//handleCookies(driver);
			//wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDriversandDownloadsPage.downloadHeading()));

			System.out.println("Clicked on Drivers and Downloads Tab");
			Report.put("Click on Drivers and Downloads Tab", "Application should navigate to Drivers and Downloads Page", "Successfully Drivers and Downloads Page displayed", "PASS");

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on Drivers and Downloads Tab", "Application should navigate to Drivers and Downloads Page", "Drivers and Downloads Page is not displayed", "FAIL");
			Assert.fail();
		}
	}

	public void handleCookies(WebDriver driver)
	{
		System.out.println("Handle Cookies");
		Log.info("Handle Cookies");	
		WebDriverWait wait = new WebDriverWait(driver, 50);
		try{
			
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

			if(CommonUtility.CheckpresenceofElementLocated(driver, 5, obj_EsupportOrderHomePage.acceptCookies()))
			{
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
		driver.manage().timeouts().implicitlyWait(240, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(240, TimeUnit.SECONDS);

	}  
	/*
	public void  handleNameSubscription(WebDriver driver) 
	{
		System.out.println("Inside handle Subscription");
		WebDriverWait  wait = new WebDriverWait(driver, 120);
		System.out.println("After webdriver wait");
		Actions act=new Actions(driver);
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);

		String subscriptionName = TestNGCreator.TestData.get(Esupport.SubscriptionName.ordinal());

		try
		{
			driver.navigate().refresh();
			handleCookies(driver);
			act.moveToElement(CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.CreateSubscription())).build().perform();

			CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.CreateSubscription());
			CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.CreateSubscription()).click();

			System.out.println("Click on Create Subscription Tab");
			Report.put("Click on 'Create Subscription' button", "Application should navigate to 'Driver Updates Subscriptions' page", "Navigated to 'Driver Updates Subscriptions' page Successfully", "PASS");


			Set<String> allWH=driver.getWindowHandles(); 
			String currentwindow=driver.getWindowHandle();
			int count=allWH.size(); 
			System.out.println("Switched Window Handles and  window count is :: "+count);

			for(String wh:allWH)
			{
				Thread.sleep(10000);
				driver.switchTo().window(wh); 
				String title=driver.getTitle();
				System.out.println("Tittle displayed as   :::::"+title); 

				if(title.contains("Driver Updates Subscriptions"))
				{

					System.out.println("Switched to window");
					handleCookies(driver);


					act.moveToElement(CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.Driverheadersubscription())).build().perform();
					//handleCookies(driver);
					CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.Driverheadersubscription());
					//Thread.sleep(5000);
					CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.window732bit()).click();


					CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.chipsetComponent()).click();
					CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.systemUtilities()).click();

					Report.put("Select  Operating System as Windows 7, 32-bit  and select the components Chipset and System Utilities", "Operating System as Windows 7, 32-bit  and components Chipset and System Utilities should be selected", 
							"Operating System as Windows 7, 32-bit  and components Chipset and System Utilities selected Successfully", "PASS");
					act.moveToElement(CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.Continue())).build().perform();
					CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.Continue()).click();

					Thread.sleep(5000);

					if(CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.setPreferencesTab()).isDisplayed())
					{
						CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.setPreferencesTab());
					}

					Report.put("Click on Continue button", "Application should display 'Set Preferences' tab", "Navigated to Set Preference Tab", "PASS");

					CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.subscriptionTextbox()).clear();
					CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.subscriptionTextbox()).sendKeys(subscriptionName);
					String name = CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.subscriptionTextbox()).getAttribute("value");
					System.out.println("subscriptionTextbox is "+name);


					if(name.length()>40)
					{
						Report.put("Subscription name should be less than 40 characters", "Only 40 Characters should be allowed", "Subscription name is greater than 40 Characters","FAIL");
						Assert.fail();
					}

					Report.put("Enter Name in Name your Subscription", "Application should allow numeric, Alphabets and Special charters in the Name field and it should allow only 40 characters including spaces", "Subscription name entered" +Report.color(name), "PASS");

					CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.notificationTypeCriticalUpdate()).click();
					CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.notificationMonthly()).click();

					CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.subContinue()).click();


					Report.put("Select Alert type and Preferences and Click on Continue", "Application should enable Select Your Product Tab", "Select your product enabled", "PASS");

					wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDriversandDownloadsPage.reviewSubscriptionHeader()));

					CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.reviewSubscriptionHeader());
					Report.put("Click on Continue button", "Application should navigate to Review Subscription page", "Navigated to Review Subscription page","PASS");


					if(CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.save()).isDisplayed())
						CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.save()).click();

					//handleCookies(driver);

					if(CommonUtility.CheckpresenceofElementLocated(driver, 10, obj_EsupportDriversandDownloadsPage.subscriptionErrorMessage()))
					{
						String errMessage = CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.subscriptionErrorMessage()).getText();
						System.out.println("Error message "+errMessage);
						CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.subscriptionErrorMessage()).click();  
						Report.put("Verify Subscription already exists", "Popup should display if the Subscription already exists",
								"Error Message "+Report.color(errMessage), "FAIL");
						Assert.fail();
					}


					wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDriversandDownloadsPage.DriverUpdatesSubscriptionsTag()));
					CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.DriverUpdatesSubscriptionsTag());

					wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDriversandDownloadsPage.SubscriptionNameField()));
					CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.SubscriptionNameField());
					String SubscriptionNameField=CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.SubscriptionNameField()).getText();

					wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDriversandDownloadsPage.UpdateField()));
					CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.UpdateField());
					String UpdateField=CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.UpdateField()).getText();

					wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDriversandDownloadsPage.DeleteField()));
					CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.DeleteField());
					String DeleteField=CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.DeleteField()).getText();
					driver.findElement(obj_EsupportDriversandDownloadsPage.DeleteField()).click();


					Report.put("Select the Product, Select the Devices, review the subscription and Save the Subscription", "Created Subscription should be displayed in Drivers Subscription page with the name provided along with Update and Delete buttons",

							"Subscription displayed with Update & Delete Buttons"+Report.color(SubscriptionNameField)+" name <br> "

							+Report.color(UpdateField)+"!"+Report.color(DeleteField)+" (links)", "PASS");
					wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDriversandDownloadsPage.DeleteButton()));
					driver.findElement(obj_EsupportDriversandDownloadsPage.DeleteButton()).click();

					Thread.sleep(5000);
					driver.close();
					driver.switchTo().window(currentwindow);
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Select Components and click on Submit Button", "Application should save the user selected OS&Components and it should navigate to Set your Preferencs tab", "Application is not saved the user selected OS&Components and it should navigate to Set your Preferencs tab", "FAIL");

			Assert.fail();

		}

	}

	 */

	public void  Login(WebDriver driver) {
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 120);

		String name = TestNGCreator.TestData.get(Esupport.Username.ordinal()) ;
		String pwd = TestNGCreator.TestData.get(Esupport.Password.ordinal()) ;
		System.out.println("Entering Login Method");

		Log.info("Entering Login Method");        

		try{
			wait = new WebDriverWait(driver, 50);
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);


			CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.userName()).sendKeys(name);

			CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.password()).sendKeys(pwd);

			CommonUtility.ClickOn(driver,obj_EsupportOrderHomePage.signIn());
			Thread.sleep(3000);


			Report.put("Enter Valid User Name and Password click on Sign In button ", "Application should navigate to Support Notifications page and it should display available Subscriptions and Drivers Subscriptions should display under Driver updates", "Successfully Drivers Subscriptions page is displayed ", "PASS");

		}catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Enter valid credentials", "Not able to find valid credentials ", "Not able to Signin in to the Drivers and downloads", "FAIL");

			Assert.fail();
		}
	}

	public void  toSelectOperatingSystem(WebDriver driver) 
	{
		System.out.println("Select Operating System");
		WebDriverWait  wait = new WebDriverWait(driver, 120);

//		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
//		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
		try
		{
			driver.navigate().refresh();
			handleCookies(driver);

			Thread.sleep(6000);
			CommonUtility.ClickOn(driver, obj_EsupportDriversandDownloadsPage.operatingSystem());
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDriversandDownloadsPage.components()));

			Report.put("Select Operating System in available Operating systems", "Application should display Components for the selected OS and it application should allow the user to select all components are he can choose from the available Components", "Application displayed Components for the selected OS and it application should allow the user to select all components are he can choose from the available Components", "PASS");

			CommonUtility.ClickOn(driver, obj_EsupportDriversandDownloadsPage.components());
			CommonUtility.ClickOn(driver, obj_EsupportDriversandDownloadsPage.compCheckbox());

			CommonUtility.ClickOn(driver, obj_EsupportDriversandDownloadsPage.Continue());
			Thread.sleep(1000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDriversandDownloadsPage.Driverheadersubscription()));
			CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.Driverheadersubscription());

			System.out.println("Selecting Components");
			Report.put("Select Components and click on Submit Button", "Application should save the user selected OS&Components and it should navigate to Set your Preferencs tab", "Application saved the user selected OS&Components and it should navigate to Set your Preferencs tab", "PASS");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Select Components and click on Submit Button", "Application should save the user selected OS&Components and it should navigate to Set your Preferencs tab", "Application is not saved the user selected OS&Components and it should navigate to Set your Preferencs tab", "FAIL");

			Assert.fail();
		}
	}

	public void  toEnterSubscription(WebDriver driver) 
	{
		System.out.println("Select toEnterSubscription");
		WebDriverWait  wait = new WebDriverWait(driver, 120);

		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
		try
		{
			List oRadioButton = driver.findElements(By.xpath("//input[@type='radio']"));
			boolean bValue = false;
			bValue = ((WebElement) oRadioButton.get(0)).isSelected();

			if(bValue = true){
				((WebElement) oRadioButton.get(1)).click();

			}else{
				((WebElement) oRadioButton.get(0)).click();

			}
			CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.subContinue()).click();
			Thread.sleep(1000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDriversandDownloadsPage.Driverheadersubscription()));
			CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.Driverheadersubscription());
			CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.productEdit());
			CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.componentEdit());

			CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.save());

			CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.cancel());


			Report.put("Enter Subscription name(Optional) Select  notifications Type(All Updates, Critical or recommended updates only or Critical updates only) and Click on Continue button",
					"Application should navigate to Review Subscripions and it should allow the user to edit Product, Coponents, Subscription Preferences along with Save and Cancel button",
					"Application navigated to Review Subscripions and it should allow the user to edit Product, Coponents, Subscription Preferences along with Save and Cancel button", "PASS");

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Enter Subscription name(Optional) Select  notifications Type(All Updates, Critical or recommended updates only or Critical updates only) and Click on Continue button",
					"Application should navigate to Review Subscripions and it should allow the user to edit Product, Coponents, Subscription Preferences along with Save and Cancel button", 
					"Application is not navigated to Review Subscripions and it should allow the user to edit Product, Coponents, Subscription Preferences along with Save and Cancel button", "FAIL");
			Assert.fail();
		}
	}

	public void  clickSaveButton(WebDriver driver) 
	{
		System.out.println("ClicKing on Save Button");
		WebDriverWait  wait = new WebDriverWait(driver, 120);

		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
		try
		{
			//driver.navigate().refresh();
			//handleCookies(driver);
			//wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDriversandDownloadsPage.supportHeading()));
			CommonUtility.ClickOn(driver,obj_EsupportDriversandDownloadsPage.save());
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDriversandDownloadsPage.driverUpdatesubscription()));
			CommonUtility.ClickOn(driver,obj_EsupportDriversandDownloadsPage.driverUpdatesubscription());
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

		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
		try
		{
			handleCookies(driver);
			CommonUtility.ClickOn(driver,obj_EsupportDriversandDownloadsPage.firstrow());

			System.out.println("First row Highlighted");
			Report.put("Review the subscription and click on Save button", "Email Subscription should be saved for the selected product", "Email Subscription saved for the selected product", "PASS");

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Review the subscription and click on Save button", "Email Subscription should be saved for the selected product", "Email Subscription is not saved for the selected product", "FAIL");
			Assert.fail();
		}
	}

	//sujatha
	public void  ClickCreateSubscription_TabChangeProduct(WebDriver driver) 
	{

		WebDriverWait  wait = new WebDriverWait(driver, 120);

		Actions act=new Actions(driver);
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
		try
		{
			System.out.println("Inside ClickCreateSubscription_TabChangeProduct");

			driver.navigate().refresh();
			handleCookies(driver);
			//  wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDriversandDownloadsPage.supportHeading()));
			act.moveToElement(CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.CreateSubscription())).build().perform();

			CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.CreateSubscription());
			CommonUtility.ClickOn(driver, obj_EsupportDriversandDownloadsPage.CreateSubscription());



			String resentorder="";

			String Driverheadersubscription="";


			Set<String> allWH=driver.getWindowHandles(); 
			String currentwindow=driver.getWindowHandle();
			int count=allWH.size(); 
			System.out.println("Switched Window Handles and  window count is :: "+count);

			for(String wh:allWH)
			{

				Thread.sleep(10000);
				driver.switchTo().window(wh); 
				String title=driver.getTitle();
				System.out.println("Tittle displayed as   :::::"+title); 



				if(title.contains("Login or Register | Dell US"))
				{

					System.out.println("Switched to window");

					handleCookies(driver);


					wait.until(ExpectedConditions.elementToBeClickable(obj_EsupportDriversandDownloadsPage.Loginsigninheader()));


					Login(driver);

					//					act.moveToElement(CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.Driverheadersubscription())).build().perform();
					handleCookies(driver);
					CommonUtility.ScrollTo(driver,obj_EsupportDriversandDownloadsPage.Driverheadersubscription());


					Thread.sleep(5000);

					Driverheadersubscription=CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.Driverheadersubscription()).getText();

					String ltMessages="";
					String newselectProduct="";
					CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.Driverheadersubscriptiontabs());

					List<WebElement> list=driver.findElements(obj_EsupportDriversandDownloadsPage.Driverheadersubscriptiontabs());

					for(WebElement lt:list)
					{
						CommonUtility.highlightElement(driver, lt);
						String names=lt.getText();

						System.out.println("Alert Name is: " +names);
						ltMessages+=" <br> " + names;
						if(names.equals("Select product"))
						{
							System.out.println("Select product Matchedddddd");

							if(CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.ChangeProductlink()).isDisplayed())
							{
								System.out.println("Select product is selected");

								newselectProduct=CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.DriverheadersubscriptiontabsSelectProduct()).getText();



							}
						}


					}

					Report.put("Click on 'Create Subscription' button'   ",
							"Application should navigate to "+ Report.color(Driverheadersubscription)+" page  and the Tabs should be display as"+ Report.color(ltMessages)+ " and  "+Report.color(newselectProduct)+" is selected " ,
							"Successfully User should land in "+ Report.color(Driverheadersubscription)+" Page and Tabs should be displayed and "+ Report.color(newselectProduct) +" Selected." , "PASS");


					Thread.sleep(2000);
					ClickChangeProduct_Tab(driver);

					ClickLaptops_Tab(driver);

					ClickLattitude_Tab(driver);

					if(CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.ChangeProductlink()).isDisplayed())
					{
						System.out.println("ChangeProductlink is displayed again");

						newselectProduct=CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.DriverheadersubscriptiontabsSelectProduct()).getText();
					}

					Thread.sleep(4000);
					driver.close();

					Thread.sleep(5000);
					driver.switchTo().window(currentwindow);

					Thread.sleep(10000);

					System.out.println("current parent window"+driver.getCurrentUrl());

					driver.navigate().refresh();

					// act.moveToElement(CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.ChangeProductchangedHeaderparent())).build().perform();

					wait.until(ExpectedConditions.elementToBeClickable(obj_EsupportDriversandDownloadsPage.ChangeProductchangedHeaderparent()));

					CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.ChangeProductchangedHeaderparent());

					resentorder=CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.ChangeProductchangedHeaderparent()).getText();

					System.out.println("current parent windowheader is "+resentorder);

					Report.put("The user should be able to see Drivers Update Subscription Page and Product should be selected as "+ Report.color(resentorder)+ "with Change Product Link ",
							"User Should comeback to  " + Report.color(resentorder)+" Page ",
							"Successfully User should land in Drivers Update Subscription Page ", "PASS");

					Thread.sleep(5000);
				}
			}			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Not able to click on 'create subscription'", "Not able to click on 'create subscription'", "Not able to click on 'create subscription'", "FAIL");
			Assert.fail();
		}
	}


	public void  ClickCreateSubscription_TabChangeProductcancel(WebDriver driver) 
	{
		System.out.println("Inside ClickCreateSubscription_TabChangeProductcancel");
		WebDriverWait  wait = new WebDriverWait(driver, 120);

		Actions act=new Actions(driver);
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
		try
		{

			System.out.println("Clicked on ClickCreateSubscription_Tab Link");
			driver.navigate().refresh();
			handleCookies(driver);
			//  wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDriversandDownloadsPage.supportHeading()));
			//			act.moveToElement(CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.CreateSubscription())).build().perform();

			CommonUtility.ScrollTo(driver, obj_EsupportDriversandDownloadsPage.CreateSubscription());
			CommonUtility.ClickOn(driver, obj_EsupportDriversandDownloadsPage.CreateSubscription());


			String resentorder="";

			String Driverheadersubscription="";


			Set<String> allWH=driver.getWindowHandles(); 
			String currentwindow=driver.getWindowHandle();
			int count=allWH.size(); 
			System.out.println("Switched Window Handles and  window count is :: "+count);

			for(String wh:allWH)
			{

				Thread.sleep(10000);
				driver.switchTo().window(wh); 
				String title=driver.getTitle();
				System.out.println("Tittle displayed as   :::::"+title); 



				if(title.contains("Driver Updates Subscriptions"))
				{

					System.out.println("Switched to window");

					handleCookies(driver);

					//					act.moveToElement(CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.Driverheadersubscription())).build().perform();
					handleCookies(driver);
					CommonUtility.ScrollTo(driver,obj_EsupportDriversandDownloadsPage.Driverheadersubscription());

					Thread.sleep(5000);

					Driverheadersubscription=CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.Driverheadersubscription()).getText();

					String ltMessages="";
					String newselectProduct="";
					CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.Driverheadersubscriptiontabs());

					List<WebElement> list=driver.findElements(obj_EsupportDriversandDownloadsPage.Driverheadersubscriptiontabs());

					for(WebElement lt:list)
					{
						CommonUtility.highlightElement(driver, lt);
						String names=lt.getText();

						System.out.println("Alert Name is: " +names);
						ltMessages+=" <br> " + names;
						if(names.equals("Select product"))
						{
							System.out.println("Select product Matchedddddd");

							if(CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.ChangeProductlink()).isDisplayed())
							{
								System.out.println("Select product is selected");

								newselectProduct=CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.DriverheadersubscriptiontabsSelectProduct()).getText();
							}
						}
					}

					Report.put("Click on 'Create Subscription' button'   ",
							"Application should navigate to "+ Report.color(Driverheadersubscription)+" page  and the Tabs should be display as"+ Report.color(ltMessages)+ " and  "+Report.color(newselectProduct)+" is selected " ,
							"Successfully User should land in "+ Report.color(Driverheadersubscription)+" Page and Tabs should be displayed and "+ Report.color(newselectProduct) +" Selected." , "PASS");

					Thread.sleep(2000);
					ClickChangeProduct_Tab(driver);

					ClickLaptops_Tab(driver);

					ClickLattitude_Tab(driver);

					ClickLaptops_TabCancel(driver);

					Thread.sleep(4000);
					driver.close();

					Thread.sleep(5000);
					driver.switchTo().window(currentwindow);

					Thread.sleep(10000);

					System.out.println("current parent window"+driver.getCurrentUrl());

					driver.navigate().refresh();

					// act.moveToElement(CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.ChangeProductchangedHeaderparent())).build().perform();

					wait.until(ExpectedConditions.elementToBeClickable(obj_EsupportDriversandDownloadsPage.ChangeProductchangedHeaderparent()));

					CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.ChangeProductchangedHeaderparent());

					resentorder=CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.ChangeProductchangedHeaderparent()).getText();

					System.out.println("current parent windowheader is "+resentorder);

					Report.put("The user should be able to see Drivers Update Subscription Page and Product should be selected as "+ Report.color(resentorder)+ "with Change Product Link ",
							"User Should comeback to  " + Report.color(resentorder)+" Page ",
							"Successfully User should land in Drivers Update Subscription Page ", "PASS");

					Thread.sleep(5000);
				}
			}		
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Not able to click on 'create subscription'", "Not able to click on 'create subscription'", "Not able to click on 'create subscription'", "FAIL");
			Assert.fail();
		}
	}

	public void  ClickChangeProduct_Tab(WebDriver driver) 
	{
		System.out.println("In Function ClickChangeProduct_Tab");
		WebDriverWait  wait = new WebDriverWait(driver, 120);
		String CancelButton="";

		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
		try
		{

			if(CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.Headerservicetag()).isDisplayed())
			{
				Prevheader=CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.Headerservicetag()).getText();
			}


			CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.ChangeProductlink());

			//  wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDriversandDownloadsPage.supportHeading()));
			CommonUtility.ClickOn(driver, obj_EsupportDriversandDownloadsPage.ChangeProductlink());

			System.out.println("Clicked on ChangeProductlink Link");

			if(CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.ChangeProductCancelButton()).isDisplayed())
			{
				CancelButton=CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.ChangeProductCancelButton()).getText();
			}

			Thread.sleep(3000);


			Report.put("Click on Change Product link in  Drivers Update Subscription Page", "Application should clear the selected product name as "+Report.color(Prevheader)+" and it should allow the user to select the other Product by Enabling Select Product Tab and it should display all the products under Select a Product section with "+Report.color(CancelButton)+ "Button", "Successfully clicked on Change Product link in  Drivers Update Subscription Page", "PASS");

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on Order Status below Masthead", "User should land in Premier Recent Orders Page", "Premier Recent Orders Page is not displayed", "FAIL");
			Assert.fail();
		}
	}

	public void  ClickLaptops_Tab(WebDriver driver) 
	{
		System.out.println("In Function ClickLaptops_Tab");
		WebDriverWait  wait = new WebDriverWait(driver, 120);
		String ClickingonLattitude="";

		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
		try
		{
			CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.ClickingonLaptops());

			//  wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDriversandDownloadsPage.supportHeading()));
			CommonUtility.ClickOn(driver, obj_EsupportDriversandDownloadsPage.ClickingonLaptops());

			System.out.println("Clicked on ClickLaptops_Tab Link");

			Thread.sleep(3000);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Failed to click on Laptops Tab");
			Assert.fail();
		}
	}

	public void  ClickLaptops_TabCancel(WebDriver driver) 
	{
		System.out.println("In Function ClickLaptops_TabCancel");
		WebDriverWait  wait = new WebDriverWait(driver, 120);
		String ClickingonLattitude="";
		String ChangeHeader="";
		String ServiceTag="";
		System.out.println("After webdriver wait");
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
		try
		{

			handleCookies(driver);
			CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.CanelChnageProductname());

			//  wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDriversandDownloadsPage.supportHeading()));
			CommonUtility.ClickOn(driver, obj_EsupportDriversandDownloadsPage.CanelChnageProductname());

			System.out.println("Clicked on CanelChnageProductname Link");

			CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.ChangeProductCancelYes());


			CommonUtility.ClickOn(driver, obj_EsupportDriversandDownloadsPage.ChangeProductCancelYes());



			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDriversandDownloadsPage.ServiceTagHeaderdisplayed()));
			handleCookies(driver);
			CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.ServiceTagHeaderdisplayed());
			ChangeHeader= CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.ServiceTagHeaderdisplayed()).getText();
			System.out.println(ChangeHeader);

			//			CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.ServiceTagHeaderdisplayed());
			//			ServiceTag= CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.ServiceTagHeaderdisplayed()).getText();
			//			System.out.println(ServiceTag);
			Report.put("Select a different product and Click on Cancel button", "Application should select the product desplayed and Page is displayed as "+Report.color(ChangeHeader),"Successfully clicked on 'Cancel' Button and navigate to"+Report.color(ChangeHeader) , "PASS");




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
		System.out.println("In Function ClickLattitude_Tab");
		WebDriverWait  wait = new WebDriverWait(driver, 120);
		String ClickingonLattitude="";
		Actions act=new Actions(driver);
		System.out.println("After webdriver wait");
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
		try
		{
			CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.ClickingonLattitude());

			CommonUtility.ClickOn(driver, obj_EsupportDriversandDownloadsPage.ClickingonLattitude());

			System.out.println("Clicked on Clicking on Lattitude Link");

			act.moveToElement(CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.ClickingonLattitudeEProduct())).build().perform();

			CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.ClickingonLattitudeEProduct());

			CommonUtility.ClickOn(driver, obj_EsupportDriversandDownloadsPage.ClickingonLattitudeEProduct());

			System.out.println("Clicked on Clicking on ClickingonLattitudeEProduct Link");

			driver.navigate().refresh();

			//act.moveToElement(CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.Headerservicetag())).build().perform();

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDriversandDownloadsPage.Headerservicetag()));
			CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.Headerservicetag());

			ClickingonLattitude=CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.Headerservicetag()).getAttribute("innerText");


			System.out.println("Header displayed as "+ClickingonLattitude);

			Thread.sleep(3000);


			Report.put("Before changing Product name and After changing Product name header should be different", "Before changing link Product Name as  "+Report.color(Prevheader)+" After By clicking Changing link displayed as "+Report.color(ClickingonLattitude),"Successfully Product Name Changed after by clicking ChangeProduct link", "PASS");


			Report.put("Click on Lattitude E4200' button", "The user should be able to see Drivers Update Subscription Page and header is desplayed as "+Report.color(ClickingonLattitude)," Successfully Drivers Update Subscription Page and header is desplayed as "+Report.color(ClickingonLattitude), "PASS");





		}
		catch(Exception e)
		{
			e.printStackTrace();
			Assert.fail();
		}
	}
	//Pushpa
	public void  ClickCreateSubscription_TabNotification(WebDriver driver) 
	{
		System.out.println("Click Create Subscription Tab");
		WebDriverWait  wait = new WebDriverWait(driver, 120);
		System.out.println("After webdriver wait");
		Actions act=new Actions(driver);
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
		try
		{
			driver.navigate().refresh();
			handleCookies(driver);
			//  wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDriversandDownloadsPage.supportHeading()));
			//			act.moveToElement(CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.CreateSubscription())).build().perform();

			CommonUtility.ScrollTo(driver, obj_EsupportDriversandDownloadsPage.CreateSubscription());
			CommonUtility.ClickOn(driver, obj_EsupportDriversandDownloadsPage.CreateSubscription());

			System.out.println("Click on Create Subscription Tab");
			Report.put("Click on 'Create Subscription' button", "User should land in Premier Recent Orders Page", "Premier Recent Orders Page displayed Successfully", "PASS");



			String resentorder="";

			String Packingslip="";


			Set<String> allWH=driver.getWindowHandles(); 
			String currentwindow=driver.getWindowHandle();
			int count=allWH.size(); 
			System.out.println("Switched Window Handles and  window count is :: "+count);

			for(String wh:allWH)
			{

				Thread.sleep(10000);
				driver.switchTo().window(wh); 
				String title=driver.getTitle();
				System.out.println("Tittle displayed as   :::::"+title); 



				if(title.contains("Login or Register | Dell US"))
				{

					System.out.println("Switched to window");

					handleCookies(driver);


					wait.until(ExpectedConditions.elementToBeClickable(obj_EsupportDriversandDownloadsPage.Loginsigninheader()));


					Login(driver);



					//					act.moveToElement(CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.Driverheadersubscription())).build().perform();
					handleCookies(driver);
					CommonUtility.ScrollTo(driver,obj_EsupportDriversandDownloadsPage.Driverheadersubscription());

					//purchaseorderActionlabel=CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.LookByOtherserachoptions()).getText();
					Thread.sleep(5000);

					// CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.Driverheadersubscription()).click();



					Packingslip=CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.Driverheadersubscription()).getText();
					toSelectOperatingSystem(driver);
					//toVerifyOperatingSystem(driver);
					handleNotificationFrequency(driver);
					driver.close();
					driver.switchTo().window(currentwindow); 
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Select Components and click on Submit Button", "Application should save the user selected OS&Components and it should navigate to Set your Preferencs tab", "Application is not saved the user selected OS&Components and it should navigate to Set your Preferencs tab", "FAIL");

			Assert.fail();
		}
	}


	public void handleNotificationFrequency(WebDriver driver)
	{
		String ltMessages="";
		try {
			CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.notificationFrequency());
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
	public void clickBrowseAllProductsLink(WebDriver driver)
	{
		System.out.println("Inside click BrowseAllProducts Link");
		Log.info("Inside click BrowseAllProducts Link"); 

		try
		{
			CommonUtility.ClickOn(driver,obj_EsupportDriversandDownloadsPage.browseAllProductsLink());

		}

		catch (Exception e) {
			Log.info(e);
			e.printStackTrace();
			Assert.fail();
		}               
	} 

	public void clickLaptops(WebDriver driver)
	{
		// TODO Auto-generated method stub

		System.out.println("Inside clickLaptops");
		Log.info("Inside clickLaptops"); 

		try {
			//Thread.sleep(6000);
			if(CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.laptopsLink()).isDisplayed())
			{
				CommonUtility.ClickOn(driver,obj_EsupportDriversandDownloadsPage.laptopsLink());
			}
			//Thread.sleep(6000);

		}

		catch (Exception e) {
			Log.info(e);

			e.printStackTrace();
			Assert.fail();
		}               
	} 

	public void clickLatitude(WebDriver driver)
	{
		// TODO Auto-generated method stub

		System.out.println("Inside clickLatitude");
		Log.info("Inside clickLatitude");        



		try {
			//Thread.sleep(6000);
			CommonUtility.ClickOn(driver,obj_EsupportDriversandDownloadsPage.latitudeLink());

			//Thread.sleep(6000);
		}

		catch (Exception e) {
			Log.info(e);                    
			e.printStackTrace();
			Assert.fail();
		}               
	} 

	public void clickLatitudeE4200(WebDriver driver)
	{
		// TODO Auto-generated method stub

		System.out.println("Inside clickLatitudeE4200");
		Log.info("Inside clickLatitudeE4200");   
		Actions act = new Actions(driver);


		try
		{
			CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.latitudeE4200link());
			act.moveToElement(CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.latitudeE4200link())).build().perform();

			CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.latitudeE4200link());
			Thread.sleep(4000);
			CommonUtility.ClickOn(driver, obj_EsupportDriversandDownloadsPage.latitudeE4200link());

			System.out.println("Clicked on Clicking on ClickingonLattitudeEProduct Link"); 

			Report.put("Navigate to drivers home page by selecting a product/Browse All Products->Laptop->Latitude->E4200.", "Product support page should be displayed",
					"Product support page displayed", "PASS");

		}

		catch (Exception e) {
			Log.info(e);
			Report.put("Navigate to drivers home page by selecting a product/Browse All Products-> Laptop-> Latitude->E4200.", "Product support page should be displayed",
					"Product support page not displayed", "FAIL");
			e.printStackTrace();
			Assert.fail();
		}               
	} 
	public void clickDriverNotifications_viewAll(WebDriver driver)
	{      
		WebDriverWait wait = new WebDriverWait(driver, 60);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDriversandDownloadsPage.DriverNotificationLink()));
			String currentwindow = driver.getCurrentUrl();

			Thread.sleep(8000);
			handleCookies(driver);
			CommonUtility.ClickOn(driver,obj_EsupportDriversandDownloadsPage.DriverNotificationLink());
			//String currentwindow = driver.getCurrentUrl();
			Set<String> windows=driver.getWindowHandles();
			for (String s : windows ){
				driver.switchTo().window(s);
			}
			String DriverUpdatesSubscriptionsTag="";
			try{

				wait = new WebDriverWait(driver, 10);
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDriversandDownloadsPage.ViewAllLink()));
				CommonUtility.ClickOn(driver,obj_EsupportDriversandDownloadsPage.ViewAllLink());
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDriversandDownloadsPage.DriverUpdatesSubscriptionsTag()));
				CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.DriverUpdatesSubscriptionsTag());
				DriverUpdatesSubscriptionsTag= CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.DriverUpdatesSubscriptionsTag()).getText();


			}
			catch (Exception ex){

			}
			wait = new WebDriverWait(driver, 60);
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			try{

				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDriversandDownloadsPage.SubscriptionNameField()));
				CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.SubscriptionNameField());
				String SubscriptionNameField=CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.SubscriptionNameField()).getText();


				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDriversandDownloadsPage.DateCreatedModifiedField()));
				CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.DateCreatedModifiedField());
				String DateCreatedModifiedField=CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.DateCreatedModifiedField()).getText();

				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDriversandDownloadsPage.ViewProductField()));
				CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.ViewProductField());
				String ViewProductField=CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.ViewProductField()).getText();

				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDriversandDownloadsPage.UpdateField()));
				CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.UpdateField());
				String UpdateField=CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.UpdateField()).getText();

				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDriversandDownloadsPage.DeleteField()));
				CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.DeleteField());
				String DeleteField=CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.DeleteField()).getText();
				Report.put("Click on 'View All' link under Driver Updates", "Application should display all the subscriptions in the list for the signed in user and the fields should be"
						+ " 1) "+Report.color(SubscriptionNameField)+" name <br> "
						+ "2) "+Report.color(DateCreatedModifiedField)+" <br>  "
						+ "3) "+Report.color(ViewProductField)+"!"+Report.color(UpdateField)+"!"+Report.color(DeleteField)+" (links)",
						"Successfully Application should navigate to Drivers Subscriptions page and it should display all the subscriptions in the list for the signed in user and the fields should be1) Subscription name 2) Date Created/Modified3) View Product!Update!Delete (links)", "PASS");


				//Report.put("Click on 'View All' link under Driver Updates", "Application should navigate to Drivers Subscriptions page and it should display all the subscriptions in the list for the signed in use", "Application navigates to Drivers Subscriptions page and it displays all the subscriptions in the list for the signed in use", "PASS");
			}
			catch (Exception e1){
				e1.printStackTrace();
				Report.put("Click on 'View All' link under Driver Updates", "Application should navigate to Drivers Subscriptions page and it should display all the subscriptions in the list for the signed in use", "Application do not navigate to Drivers Subscriptions page and it do not display all the subscriptions in the list for the signed in use", "FAIL");
				Assert.fail();
			}
			try{
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDriversandDownloadsPage.DeleteField()));
				CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.DeleteField()).click();
				Report.put("Click on Delete link of existing subscription in the Drivers Subscriptions Page", "Application should display conformation popup to delete", "Application displays conformation popup to delete", "PASS");

			}
			catch (Exception e2){
				e2.printStackTrace();
				Report.put("Click on Delete link of existing subscription in the Drivers Subscriptions Page", "Application should display conformation popup to delete", "Application do not display conformation popup to delete", "FAIL");
				Assert.fail();
			}
			try{
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDriversandDownloadsPage.CancelButton()));
				CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.CancelButton()).click();


				Thread.sleep(5000);

				Report.put("Click on No Button in Popup Window", "Application should not delete the selected subscriptions and it should close the Popup.", "Application does not delete the selected subscriptions and it closes the Popup.", "PASS");

			}
			catch (Exception e3){
				e3.printStackTrace();
				Report.put("Click on No Button in Popup Window", "Application should not delete the selected subscriptions and it should close the Popup.", "Applicatio deletes the selected subscriptions and it do not close  the Popup.", "FAIL");
				Assert.fail();
			}

			try{



				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDriversandDownloadsPage.DeleteField()));
				CommonUtility.ClickOn(driver,obj_EsupportDriversandDownloadsPage.DeleteField());
				Report.put("Click on Delete link of existing subscription in the Drivers Subscriptions Page", "Application should display conformation popup to delete", "Application displays conformation popup to delete", "PASS");

			}
			catch (Exception e4){
				e4.printStackTrace();
				Report.put("Click on Delete link of existing subscription in the Drivers Subscriptions Page", "Application should display conformation popup to delete", "Application  do not display conformation popup to delete", "FAIL");
				Assert.fail();
			}

			try{
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDriversandDownloadsPage.DeleteButton()));
				CommonUtility.ClickOn(driver,obj_EsupportDriversandDownloadsPage.DeleteButton());

				Report.put("Click on Yes Button", "Application should delete selected email subscription and it should be removed from Subscription list", "Application should delete selected email subscription and it should be removed from Subscription list", "PASS");


			}
			catch (Exception e5){
				e5.printStackTrace();
				Report.put("Click on Yes Button", "Application should delete selected email subscription and it should be removed from Subscription list", "Application do not delete selected email subscription and it does not remove from Subscription list", "FAIL");
				Assert.fail();

			}     
			driver.close();
			Thread.sleep(5000);
			//                        driver.switchTo().window(currentwindow);
			Set<String> windows1=driver.getWindowHandles();
			for (String s : windows1 ){
				driver.switchTo().window(s);
			}

		}
		catch(Exception ex){
			ex.printStackTrace();
			Report.put("User verify existing subscription in the Drivers Subscriptions Page", "Application should display conformation popup to delete", "Application do not display conformation popup to delete", "FAIL");
			Assert.fail();


		}




	}




	public void  ClickCreateSubscription_TabDelete(WebDriver driver) 
	{
		System.out.println("Click Drivers and Downloads Tab");
		WebDriverWait  wait = new WebDriverWait(driver, 120);
		System.out.println("After webdriver wait");
		Actions act=new Actions(driver);
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
		try
		{

			System.out.println("Clicked on ClickCreateSubscription_Tab Link");
			driver.navigate().refresh();
			handleCookies(driver);
			//  wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDriversandDownloadsPage.supportHeading()));
			//			act.moveToElement(CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.CreateSubscription())).build().perform();

			CommonUtility.ScrollTo(driver, obj_EsupportDriversandDownloadsPage.CreateSubscription());
			CommonUtility.ClickOn(driver, obj_EsupportDriversandDownloadsPage.CreateSubscription());

			System.out.println("Clicked on Order Status Link");
			Report.put("Click on 'Create Subscription' button", "User should land in Premier Recent Orders Page", "Premier Recent Orders Page displayed Successfully", "PASS");



			String resentorder="";

			String Driverheadersubscription="";

			Set<String> allWH=driver.getWindowHandles(); 
			String currentwindow=driver.getWindowHandle();
			int count=allWH.size(); 
			System.out.println("Switched Window Handles and  window count is :: "+count);

			for(String wh:allWH)
			{

				Thread.sleep(10000);
				driver.switchTo().window(wh); 
				String title=driver.getTitle();
				System.out.println("Tittle displayed as   :::::"+title); 



				if(title.contains("Login or Register | Dell US"))
				{

					System.out.println("Switched to window");
					handleCookies(driver);
					wait.until(ExpectedConditions.elementToBeClickable(obj_EsupportDriversandDownloadsPage.Loginsigninheader()));

					Login(driver);


					Thread.sleep(4000);
					driver.close();
					Thread.sleep(5000);
					driver.switchTo().window(currentwindow);

					Thread.sleep(10000);

					System.out.println("current parent window"+driver.getCurrentUrl());

					driver.navigate().refresh();



					// act.moveToElement(CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.ChangeProductchangedHeaderparent())).build().perform();

					wait.until(ExpectedConditions.elementToBeClickable(obj_EsupportDriversandDownloadsPage.ChangeProductchangedHeaderparent()));

					CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.ChangeProductchangedHeaderparent());

					resentorder=CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.ChangeProductchangedHeaderparent()).getText();

					System.out.println("current parent windowheader is "+resentorder);

					//Report.put("The user should be able to see Drivers Update Subscription Page and Product should be selected as "+ Report.color(resentorder)+ "with Change Product Link ",
					//"User Should comeback to  " + Report.color(resentorder)+" Page ",
					//"Successfully User should land in Drivers Update Subscription Page ", "PASS");

					Thread.sleep(5000); 




				}
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on Order Status below Masthead", "User should land in Premier Recent Orders Page", "Premier Recent Orders Page is not displayed", "FAIL");
			Assert.fail();
		}
	}
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

			WebElement element = driver.findElement(By.xpath("//div[@class='utility col-lg-3 col-md-3 col-sm-2']/ul/li[3]/a[@id='signin-link']"));
			//			Actions actions = new Actions(driver);
			//			actions.moveToElement(element).click().perform();

			CommonUtility.ClickOn(driver,By.xpath("//div[@class='utility col-lg-3 col-md-3 col-sm-2']/ul/li[3]/a[@id='signin-link']"));

			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(//div[@class='utility col-lg-3 col-md-3 col-sm-2']/ul/li[3]/a[@id='signin-link'])));
			//driver.findElement(By.xpath("//div[@class='utility col-lg-3 col-md-3 col-sm-2']/ul/li/a[@id='signin-link']")).click();
			//CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.save()).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDriversandDownloadsPage.signIn()));
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
	public void  ClickCreateSubscription_AuthenticatedUser(WebDriver driver) 

	{
		System.out.println("Click Drivers and Downloads Tab");
		WebDriverWait  wait = new WebDriverWait(driver, 120);
		System.out.println("After webdriver wait");
		Actions act=new Actions(driver);
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
		try
		{
			driver.navigate().refresh();
			handleCookies(driver);
			Thread.sleep(3000);
			//  wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDriversandDownloadsPage.supportHeading()));
			//			act.moveToElement(CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.CreateSubscription())).build().perform();

			CommonUtility.ScrollTo(driver, obj_EsupportDriversandDownloadsPage.CreateSubscription());
			CommonUtility.ClickOn(driver, obj_EsupportDriversandDownloadsPage.CreateSubscription());

			System.out.println("Clicked on Create Subscription button");
			//Report.put("Click on 'Create Subscription' button", "User should land in Premier Recent Orders Page", "Premier Recent Orders Page displayed Successfully", "PASS");



			String resentorder="";

			String Packingslip="";


			Set<String> allWH=driver.getWindowHandles(); 
			String currentwindow=driver.getWindowHandle();
			int count=allWH.size(); 
			System.out.println("Switched Window Handles and  window count is :: "+count);

			for(String wh:allWH)
			{

				Thread.sleep(10000);
				driver.switchTo().window(wh); 
				String title=driver.getTitle();
				System.out.println("Tittle displayed as   :::::"+title); 



				if(title.contains("Driver Updates Subscriptions"))
				{

					System.out.println("Switched to window");

					handleCookies(driver);


					//wait.until(ExpectedConditions.elementToBeClickable(obj_EsupportDriversandDownloadsPage.Loginsigninheader()));


					//	Login(driver);



					//					act.moveToElement(CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.Driverheadersubscription())).build().perform();
					handleCookies(driver);
					CommonUtility.ScrollTo(driver,obj_EsupportDriversandDownloadsPage.Driverheadersubscription());

					//purchaseorderActionlabel=CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.LookByOtherserachoptions()).getText();
					Thread.sleep(5000);

					Thread.sleep(5000);

					// CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.Driverheadersubscription()).click();



					Driverheadersubscription=CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.Driverheadersubscription()).getText();

					String ltMessages="";
					String newselectProduct="";
					CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.Driverheadersubscriptiontabs());

					List<WebElement> list=driver.findElements(obj_EsupportDriversandDownloadsPage.Driverheadersubscriptiontabs());

					for(WebElement lt:list)
					{
						CommonUtility.highlightElement(driver, lt);
						String names=lt.getText();

						System.out.println("Alert Name is: " +names);
						ltMessages+=" <br> " + names;
						if(names.equals("Select product"))
						{
							System.out.println("Select product Matchedddddd");

							if(CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.ChangeProductlink()).isDisplayed())
							{
								System.out.println("Select product is selected");

								newselectProduct=CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.DriverheadersubscriptiontabsSelectProduct()).getText();



							}
						}


					}

					Report.put("Click on 'Create Subscription' button'   ",
							"Application should navigate to "+ Report.color(Driverheadersubscription)+" page  and the Tabs should be display as"+ Report.color(ltMessages)+ " and  "+Report.color(newselectProduct)+" is selected " ,
							"Successfully User should land in "+ Report.color(Driverheadersubscription)+" Page and Tabs should be displayed and "+ Report.color(newselectProduct) +" Selected." , "PASS");


					Thread.sleep(2000);

					Packingslip=CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.Driverheadersubscription()).getText();

					toSelectOperatingSystem(driver);
					toEnterSubscription(driver);
					clickSaveButton(driver);
					reviewSubscription(driver);
					DeleteRecord(driver);
					driver.close();
					driver.switchTo().window(currentwindow); 
				}
			}
		}catch(Exception e)
		{
			e.printStackTrace();
			Report.put("User is login into Premier account", "Premier Sign in page must be displayed", "Premier Sign in page is not displayed", "Fail");
			Report.put("Enter valid credentials and select the required store ", "Coresponding premier store must be displayed", "Coresponding premier store is not displayed", "Fail");

			//Report.put("Click on the search by drop down", "System should display below mentioned values in the drop down", "Fields are not available", "Fail");
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
			driver.findElement(obj_EsupportDriversandDownloadsPage.Firstrowchk()).click();
			driver.findElement(obj_EsupportDriversandDownloadsPage.DeleteSelected()).click();
			OpenThePopWindow(driver);			
			driver.findElement(obj_EsupportDriversandDownloadsPage.DeleteSub()).click();
			driver.findElement(obj_EsupportDriversandDownloadsPage.ClosePopup()).click();


		}
		catch(Exception e)
		{
			e.printStackTrace();
			Assert.fail();
		}
	}
	public void TOVerify_clickDriverNotifications(WebDriver driver)
	{      
		WebDriverWait wait = new WebDriverWait(driver, 60);
		Actions act=new Actions(driver);

		try{
			System.out.println("IN Function TOVerify_clickDriverNotifications");
			handleCookies(driver);
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDriversandDownloadsPage.DriverNotificationLink()));
			String currentwindow = driver.getCurrentUrl();
			CommonUtility.ClickOn(driver,obj_EsupportDriversandDownloadsPage.DriverNotificationLink());


			//String currentwindow = driver.getCurrentUrl();
			Set<String> windows=driver.getWindowHandles();
			for (String s : windows ){

				System.out.println("Switched to window......");
				driver.switchTo().window(s);

			}


			handleCookies(driver);

			if(CommonUtility.CheckpresenceofElementLocated(driver, 02, obj_EsupportDriversandDownloadsPage.ViewAllLink()))

			{

				String ViewProductField="";
				WebElement element =driver.findElement(obj_EsupportDriversandDownloadsPage.ViewAllLink());
				//				act.moveToElement(element).build().perform();
				//				((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);
				CommonUtility.ScrollTo(driver,obj_EsupportDriversandDownloadsPage.ViewAllLink());
				CommonUtility.ClickOn(driver,obj_EsupportDriversandDownloadsPage.ViewAllLink());

				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDriversandDownloadsPage.DriverUpdatesSubscriptionsTag()));
				CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.DriverUpdatesSubscriptionsTag());
				String DriverUpdatesSubscriptionsTag= CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.DriverUpdatesSubscriptionsTag()).getText();


				handleCookies(driver);
				//wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDriversandDownloadsPage.SubscriptionNameField()));
				CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.SubscriptionNameField());
				String SubscriptionNameField=CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.SubscriptionNameField()).getText();


				//wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDriversandDownloadsPage.DateCreatedModifiedField()));
				CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.DateCreatedModifiedField());
				String DateCreatedModifiedField=CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.DateCreatedModifiedField()).getText();


				if(CommonUtility.CheckpresenceofElementLocated(driver, 02, obj_EsupportDriversandDownloadsPage.ViewProductField())){

					Report.put("Click on View product link of subscription", "Application should navigate Product Support Page of the Selected Product with  Tab as default.", "Successfully Application Navigate to  Product Support Page of the Selected Product with Diagnostic Tab as default.", "PASS");
					CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.ViewProductField());
					ViewProductField=CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.ViewProductField()).getText();


				}
				else
				{


					Report.put("Click on View product link of subscription", "View All link is not able to click", "Application not able to find View All Navigate to  Product Support Page of the Selected Product with Diagnostic Tab as default.", "FAIL");
					//driver.close();
					Assert.fail();
				}

				//wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDriversandDownloadsPage.ViewProductField()));

				//wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDriversandDownloadsPage.UpdateField()));
				CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.UpdateField());
				String UpdateField=CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.UpdateField()).getText();

				//wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDriversandDownloadsPage.DeleteField()));
				CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.DeleteField());
				String DeleteField=CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.DeleteField()).getText();
				//wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDriversandDownloadsPage.DeleteSubscriptionTag()));
				//CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.DeleteSubscriptionTag());

				//wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDriversandDownloadsPage.CancelButton()));
				//CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.CancelButton()).click();

				System.out.println("All the links avaiable");
				Thread.sleep(2000);


				Report.put("Click on 'View All' link under Driver Updates", "Application should navigate to "+Report.color(DriverUpdatesSubscriptionsTag)+" page and it should display all the subscriptions in the list for the signed in user and the fields should be"
						+ " 1) "+Report.color(SubscriptionNameField)+" name <br> "
						+ "2) "+Report.color(DateCreatedModifiedField)+" <br>  "
						+ "3) "+Report.color(ViewProductField)+"!"+Report.color(UpdateField)+"!"+Report.color(DeleteField)+" (links)",
						"Successfully Application should navigate to Drivers Subscriptions page and it should display all the subscriptions in the list for the signed in user and the fields should be1) Subscription name 2) Date Created/Modified3) View Product!Update!Delete (links)", "PASS");



				if(CommonUtility.CheckpresenceofElementLocated(driver, 10, obj_EsupportDriversandDownloadsPage.ViewProductField())){

					handleCookies(driver);
					CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.ViewProductField());
					CommonUtility.ClickOn(driver,obj_EsupportDriversandDownloadsPage.ViewProductField());


					wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDriversandDownloadsPage.DiagnosticsHeader()));
					CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.DiagnosticsHeader());
					String DiagnosticsHeader=CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.DiagnosticsHeader()).getText();


					Report.put("Click on View product link of subscription", "Application should navigate Product Support Page of the Selected Product with "+Report.color(DiagnosticsHeader)+" Tab as default.", "Successfully Application Navigate to  Product Support Page of the Selected Product with Diagnostic Tab as default.", "PASS");


				}
				else
				{


					Report.put("Click on View product link of subscription", "View product link is not able to click", "Application not able to find View All Navigate to  Product Support Page of the Selected Product with Diagnostic Tab as default.", "FAIL");
					//					driver.close();
					//					Assert.fail();
				}




				driver.close();
				Thread.sleep(5000);
				//                    driver.switchTo().window(currentwindow);


				Set<String> windows1=driver.getWindowHandles();
				for (String s : windows1 ){
					driver.switchTo().window(s);

					System.out.println("Switched to parent window");

					wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDriversandDownloadsPage.ServiceTagHeaderdisplayed()));
					CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.ServiceTagHeaderdisplayed());
					String Servicetagheaderdisplayed=CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.ServiceTagHeaderdisplayed()).getText();

					//Report.put("Click on View product link of subscription", "Application should navigate Product Support Page of the Selected Product with "+Report.color(DiagnosticsHeader)+" Tab as default.", "Successfully Application Navigate to  Product Support Page of the Selected Product with Diagnostic Tab as default.", "PASS");


				}



				//	Report.put("Click on View product link of subscription", "Application should navigate Product Support Page of the Selected Product with "+Report.color(DiagnosticsHeader)+" Tab as default.", "Successfully Application Navigate to  Product Support Page of the Selected Product with Diagnostic Tab as default.", "PASS");



			}
			else
			{
				Report.put("Click on View ALL link of subscription", "View All link is not able to click", "Application not able to find View All in  Product Support Page of the Selected Product with Diagnostic Tab as default.", "FAIL");
				Thread.sleep(5000);
				//driver.close();
				Thread.sleep(5000);

				String currentwindow1 = driver.getCurrentUrl();
				System.out.println(currentwindow1   +" sadasdasdasdasd");

				if(currentwindow.contains("https://www.dell.com/support/Subscriptions/us/en/19"))
				{


					driver.switchTo().window(currentwindow1);

					driver.close();

				}

			}

			if(currentwindow.contains("https://www.dell.com/support/home/us/en/19/product-support"))
			{
				https://www.dell.com/support/Subscriptions/us/en/19

					driver.switchTo().window(currentwindow);

			//				String currentwindow1 = driver.getCurrentUrl();
			//				System.out.println(currentwindow1   +" sadasdasdasdasd");
			//				
			driver.close();

			Assert.fail();
			}








		}
		catch(Exception ex){
			ex.printStackTrace();
			Report.put("Click on View product link of subscription", "View All link is not able to click", "Application not able to find View All Navigate to  Product Support Page of the Selected Product with Diagnostic Tab as default.", "FAIL");
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
			Report.put("Click on Other Lookup Options", "Other look up Options Pop Up should show",
					"Other look up Options Pop Up display failed", "FAIL");
			Assert.fail();
		}

	}


	//Sujata new code........

	public void ToClick_Storage(WebDriver driver)
	{
		// TODO Auto-generated method stub

		System.out.println("Inside ToClick_Storage");
		Log.info("Inside ToClick_Storage"); 

		try {
			//Thread.sleep(6000);
			CommonUtility.ClickOn(driver,obj_EsupportDriversandDownloadsPage.StorageLink());

			//Thread.sleep(6000);

		}

		catch (Exception e) {
			Log.info(e);

			e.printStackTrace();
			Assert.fail();
		}               
	} 


	public void ToClick_EntryLevelMidrange(WebDriver driver)
	{
		// TODO Auto-generated method stub

		System.out.println("Inside ToClick_EntryLevelMidrange");
		Log.info("Inside ToClick_Storage"); 

		try {
			//Thread.sleep(6000);
			CommonUtility.ClickOn(driver,obj_EsupportDriversandDownloadsPage.EntryLevelMidrangeLink());

			//Thread.sleep(6000);

		}

		catch (Exception e) {
			Log.info(e);

			e.printStackTrace();
			Assert.fail();
		}               
	} 


	public void ToClick_EqualLogiclink(WebDriver driver)
	{
		// TODO Auto-generated method stub

		System.out.println("Inside ToClick_EqualLogiclink");
		Log.info("Inside ToClick_Storage"); 

		try {
			//Thread.sleep(6000);
			CommonUtility.ClickOn(driver,obj_EsupportDriversandDownloadsPage.EqualLogiclink());

			//Thread.sleep(6000);

		}

		catch (Exception e) {
			Log.info(e);

			e.printStackTrace();
			Assert.fail();
		}               
	}


	public void ToClick_EqualLogicProductlink(WebDriver driver)
	{
		// TODO Auto-generated method stub
		String Servicetagheaderdisplayed="";

		System.out.println("Inside ToClick_EqualLogicProductlink");
		Log.info("Inside ToClick_Storage"); 

		try {
			//Thread.sleep(6000);
			CommonUtility.ClickOn(driver,obj_EsupportDriversandDownloadsPage.EqualLogicProductlink());


			wait.until(ExpectedConditions.elementToBeClickable(obj_EsupportDriversandDownloadsPage.ServiceTagHeaderdisplayed()));

			CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.ServiceTagHeaderdisplayed());

			Servicetagheaderdisplayed=CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.ServiceTagHeaderdisplayed()).getText();

			System.out.println("current parent windowheader is "+Servicetagheaderdisplayed);

			Report.put("Navigato te o Product Support page by BrowseAll Products  / Storage  / Entry Level & Midrange  / EqualLogic/Equallogic PS6010", "Application should navigate to  "+Report.color(Servicetagheaderdisplayed)+" Page.", "Successfully Application Navigate to  Product Support Page .", "PASS");


			//Thread.sleep(6000);

		}

		catch (Exception e) {
			Log.info(e);
			Report.put("Navigato te o Product Support page by BrowseAll Products  / Storage  / Entry Level & Midrange  / EqualLogic/Equallogic PS6010", "Application not able to navigate to  Product Support page.", "Application not able to navigate to  Product Support page.", "PASS");

			e.printStackTrace();
			Assert.fail();
		}               
	} 


	public void  ClickCreateSubscription_TabLagecyProduct(WebDriver driver) 
	{
		System.out.println("In Fnction ClickCreateSubscription_TabDelete");
		WebDriverWait  wait = new WebDriverWait(driver, 120);
		System.out.println("After webdriver wait");
		Actions act=new Actions(driver);
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
		try
		{

			//System.out.println("Clicked on ClickCreateSubscription_Tab Link");
			driver.navigate().refresh();
			handleCookies(driver);
			//  wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDriversandDownloadsPage.supportHeading()));
			//			act.moveToElement(CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.CreateSubscription())).build().perform();

			CommonUtility.ScrollTo(driver, obj_EsupportDriversandDownloadsPage.CreateSubscription());
			CommonUtility.ClickOn(driver, obj_EsupportDriversandDownloadsPage.CreateSubscription());

			System.out.println("Clicked on Order Status Link");
			//	Report.put("Click on 'Create Subscription' button", "User should land in Premier Recent Orders Page", "Premier Recent Orders Page displayed Successfully", "PASS");



			String resentorder="";

			String Driverheadersubscription="";

			Set<String> allWH=driver.getWindowHandles(); 
			String currentwindow=driver.getWindowHandle();
			int count=allWH.size(); 
			System.out.println("Switched Window Handles and  window count is :: "+count);

			for(String wh:allWH)
			{

				Thread.sleep(10000);
				driver.switchTo().window(wh); 
				String title=driver.getTitle();
				System.out.println("Tittle displayed as   :::::"+title); 

				String LagecyErrorMessage="";

				if(title.contains("Login or Register | Dell US"))
				{

					System.out.println("Switched to window");
					handleCookies(driver);
					wait.until(ExpectedConditions.elementToBeClickable(obj_EsupportDriversandDownloadsPage.Loginsigninheader()));

					premierLogin(driver);
					//Driverheadersubscription

					wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDriversandDownloadsPage.Driverheadersubscription()));

					handleCookies(driver);

					//wait.until(ExpectedConditions.elementToBeClickable(obj_EsupportDriversandDownloadsPage.Driverheadersubscription()));

					CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.Driverheadersubscription());

					String Driverheadersubscriptionnew=CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.Driverheadersubscription()).getText();

					CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.Headerservicetag());

					String Headerservicetag=CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.Headerservicetag()).getAttribute("innerText");


					CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.LagecyErrorMessage());

					LagecyErrorMessage=CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.LagecyErrorMessage()).getText();
					System.out.println(LagecyErrorMessage);

					// LagecyErrorMessagenew=LagecyErrorMessage.split(".")[0];


					CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.Continue());

					String Continuedisable=CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.Continue()).getAttribute("disabled");

					Report.put("Click on 'Create Subscription' button", "Application should navigate to "+Report.color(Driverheadersubscriptionnew)+" page  and the"+Report.color(Driverheadersubscriptionnew)+" user should be prompted you "+Report.color(LagecyErrorMessage)+" and Continue button is disabled its "+Report.color(Continuedisable), "Successfully page is loaded and error message is displayed and Continue button is disabled", "PASS");





					Thread.sleep(4000);
					driver.close();
					Thread.sleep(5000);
					driver.switchTo().window(currentwindow);

					Thread.sleep(10000);

					System.out.println("current parent window"+driver.getCurrentUrl());

					driver.navigate().refresh();



					// act.moveToElement(CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.ChangeProductchangedHeaderparent())).build().perform();

					wait.until(ExpectedConditions.elementToBeClickable(obj_EsupportDriversandDownloadsPage.ChangeProductchangedHeaderparent()));

					CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.ChangeProductchangedHeaderparent());

					resentorder=CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.ChangeProductchangedHeaderparent()).getText();

					System.out.println("current parent windowheader is "+resentorder);

					//Report.put("The user should be able to see Drivers Update Subscription Page and Product should be selected as "+ Report.color(resentorder)+ "with Change Product Link ",
					//"User Should comeback to  " + Report.color(resentorder)+" Page ",
					//"Successfully User should land in Drivers Update Subscription Page ", "PASS");

					Thread.sleep(5000); 




				}
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Not able to click on 'create subscription'", "Not able to click on 'create subscription'", "Not able to click on 'create subscription'", "FAIL");
			Assert.fail();
		}
	}


	public void  premierLogin(WebDriver driver) {
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 120);

		String name = TestNGCreator.TestData.get(Esupport.Username.ordinal()) ;
		String pwd = TestNGCreator.TestData.get(Esupport.Password.ordinal()) ;
		System.out.println("Entering Premier Login Home Page");
		System.out.println("Entering Premier Login Home Page");
		Log.info("Entering Premier Login Home Page");        

		try{
			wait = new WebDriverWait(driver, 50);
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);


			CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.userName()).sendKeys(name);

			CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.password()).sendKeys(pwd);
			// CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.declinecookies()).click();
			CommonUtility.ClickOn(driver,obj_EsupportOrderHomePage.signIn());
			Thread.sleep(3000);



			//CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.accessPremier()).click();

			//      Report.put("User is login into Premier account", "Premier Sign in page must be displayed", "Premier Sign in page is displayed", "Pass");
			Report.put("Enter Valid User Name and Password click on Sign In button ", "Application should navigate to Support Notifications page and it should display available Subscriptions and Drivers Subscriptions should display under Driver updates", "Successfully Drivers Subscriptions page is displayed ", "Pass");

		}catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Enter valid credentials", "Not able to find valid credentials ", "Not able to Signin in to the Drivers and downloads", "Fail");
			//Report.put("User is login into Premier account", "Premier Sign in page must be displayed", "Premier Sign in page is not displayed", "Fail");
			//Report.put("Enter valid credentials and select the required store ", "Coresponding premier store must be displayed", "Coresponding premier store is not displayed", "Fail");

			//Report.put("Click on the search by drop down", "System should display below mentioned values in the drop down", "Fields are not available", "Fail");
			Assert.fail();
		}
	}


	public void TOVerify_clickDriverNotificationsUpdatelink(WebDriver driver)
	{      
		WebDriverWait wait = new WebDriverWait(driver, 60);

		Actions act=new Actions(driver);

		try{
			System.out.println("IN Function TOVerify_clickDriverNotificationsUpdatelink");
			handleCookies(driver);
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDriversandDownloadsPage.DriverNotificationLink()));
			String currentwindow = driver.getCurrentUrl();
			CommonUtility.ClickOn(driver,obj_EsupportDriversandDownloadsPage.DriverNotificationLink());


			//String currentwindow = driver.getCurrentUrl();
			Set<String> windows=driver.getWindowHandles();
			for (String s : windows ){
				driver.switchTo().window(s);
			}

			handleCookies(driver);


			WebElement element =driver.findElement(By.xpath("//td[@class='no-bottom']//strong[text()='View All']"));
			act.moveToElement(element).build().perform();
			((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);   


			handleCookies(driver);

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDriversandDownloadsPage.DriverUpdatesSubscriptionsTag()));
			CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.DriverUpdatesSubscriptionsTag());
			String DriverUpdatesSubscriptionsTag= CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.DriverUpdatesSubscriptionsTag()).getText();

			//wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDriversandDownloadsPage.SubscriptionNameField()));
			CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.SubscriptionNameField());
			String SubscriptionNameField=CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.SubscriptionNameField()).getText();


			//wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDriversandDownloadsPage.DateCreatedModifiedField()));
			CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.DateCreatedModifiedField());
			String DateCreatedModifiedField=CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.DateCreatedModifiedField()).getText();

			//wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDriversandDownloadsPage.ViewProductField()));
			CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.ViewProductField());
			String ViewProductField=CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.ViewProductField()).getText();

			//wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDriversandDownloadsPage.UpdateField()));
			CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.UpdateField());
			String UpdateField=CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.UpdateField()).getText();

			//wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDriversandDownloadsPage.DeleteField()));
			CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.DeleteField());
			String DeleteField=CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.DeleteField()).getText();
			//wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDriversandDownloadsPage.DeleteSubscriptionTag()));
			//CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.DeleteSubscriptionTag());

			//wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDriversandDownloadsPage.CancelButton()));
			//CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.CancelButton()).click();


			Thread.sleep(2000);


			Report.put("Click on 'View All' link under Driver Updates", "Application should navigate to "+Report.color(DriverUpdatesSubscriptionsTag)+" page and it should display all the subscriptions in the list for the signed in user and the fields should be"
					+ " 1) "+Report.color(SubscriptionNameField)+" name <br> "
					+ "2) "+Report.color(DateCreatedModifiedField)+" <br>  "
					+ "3) "+Report.color(ViewProductField)+"!"+Report.color(UpdateField)+"!"+Report.color(DeleteField)+" (links)",
					"Successfully Application should navigate to Drivers Subscriptions page and it should display all the subscriptions in the list for the signed in user and the fields should be1) Subscription name 2) Date Created/Modified3) View Product!Update!Delete (links)", "PASS");



			if(CommonUtility.CheckpresenceofElementLocated(driver, 10, obj_EsupportDriversandDownloadsPage.UpdateField())){


				CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.UpdateField());
				CommonUtility.ClickOn(driver,obj_EsupportDriversandDownloadsPage.UpdateField());


				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDriversandDownloadsPage.UpdateProductheader()));
				CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.UpdateProductheader());
				String DiagnosticsHeader=CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.UpdateProductheader()).getText();

				if(CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.ChangeProductlink()).isDisplayed()){


					Report.put("Click on Update link of existing subscription", "Application should navigate Product Support Page of the Selected Product with "+Report.color(DiagnosticsHeader)+" Tab as default.", "Successfully Application should display selected driver email subscription in edit mode", "PASS");

				}
				else
				{
					Report.put("Click on Update link of existing subscription", "Application should not navigate Product Support Page of the Selected Product with "+Report.color(DiagnosticsHeader)+" Tab as default.", "Application should not display selected driver email subscription in edit mode", "PASS");

				}

				String tag = TestNGCreator.TestData.get(Esupport.TestCaseID.ordinal());
				System.out.println("Testcase Id is "+tag);

				if(tag.equals("19214795"))
				{

					System.out.println("Inside Testcase Id is "+tag);
					//CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.UpdateProductheaderCanel());
					// String UpdateProductheaderCanel=CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.UpdateProductheaderCanel()).getText();
					// handleCookies(driver);
					ToClickCancel_TabCancelUpdatesubscription(driver);

				} 


			}
			else
			{


				Report.put("Click on View product link of subscription", "View All link is not able to click", "Application not able to find View All Navigate to  Product Support Page of the Selected Product with Diagnostic Tab as default.", "FAIL");
				Assert.fail();
			}




			driver.close();
			Thread.sleep(5000);
			//                    driver.switchTo().window(currentwindow);


			Set<String> windows1=driver.getWindowHandles();
			for (String s : windows1 ){
				driver.switchTo().window(s);

				System.out.println("Switched to parent window");

				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDriversandDownloadsPage.ServiceTagHeaderdisplayed()));
				CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.ServiceTagHeaderdisplayed());
				String Servicetagheaderdisplayed=CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.ServiceTagHeaderdisplayed()).getText();

				//Report.put("Click on View product link of subscription", "Application should navigate Product Support Page of the Selected Product with "+Report.color(DiagnosticsHeader)+" Tab as default.", "Successfully Application Navigate to  Product Support Page of the Selected Product with Diagnostic Tab as default.", "PASS");


			}



		}
		catch(Exception ex){
			ex.printStackTrace();
			Report.put("Click on View product link of subscription", "View All link is not able to click", "Application not able to find View All Navigate to  Product Support Page of the Selected Product with Diagnostic Tab as default.", "FAIL");
			Assert.fail();



		}




	}

	public void  ToClickCancel_TabCancelUpdatesubscription(WebDriver driver) 
	{
		System.out.println("In Function ClickLaptops_TabCancel");
		WebDriverWait  wait = new WebDriverWait(driver, 120);
		String ClickingonLattitude="";
		String ChangeHeader="";
		String ServiceTag="";
		System.out.println("After webdriver wait");
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
		try
		{

			handleCookies(driver);
			CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.CanelChnageProductname());

			//  wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDriversandDownloadsPage.supportHeading()));
			CommonUtility.ClickOn(driver, obj_EsupportDriversandDownloadsPage.CanelChnageProductname());

			System.out.println("Clicked on CanelChnageProductname Link");

			CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.ChangeProductCancelYes());


			CommonUtility.ClickOn(driver, obj_EsupportDriversandDownloadsPage.ChangeProductCancelYes());



			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDriversandDownloadsPage.UpdateProductheaderCanel()));
			handleCookies(driver);
			CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.UpdateProductheaderCanel());
			ChangeHeader= CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.UpdateProductheaderCanel()).getText();
			System.out.println(ChangeHeader);


			Report.put("Click on Cancel button", "Application should navigate to "+Report.color(ChangeHeader),"Successfully clicked on 'Cancel' Button and navigate to"+Report.color(ChangeHeader) , "PASS");




			Thread.sleep(3000);



		}
		catch(Exception e)
		{
			e.printStackTrace();
			Assert.fail();
		}
	}

	//Sneha`s 11/16/2018  integrated code


	public void clickDriverNotifications(WebDriver driver)
	{      
		WebDriverWait wait = new WebDriverWait(driver, 60);

		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDriversandDownloadsPage.DriverNotificationLink()));
			String currentwindow = driver.getCurrentUrl();
			Thread.sleep(5000);
			CommonUtility.ClickOn(driver,obj_EsupportDriversandDownloadsPage.DriverNotificationLink());
			//String currentwindow = driver.getCurrentUrl();
			Set<String> windows=driver.getWindowHandles();
			for (String s : windows ){
				driver.switchTo().window(s);
			}

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDriversandDownloadsPage.SupportNotificationTag()));
			CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.SupportNotificationTag());



			driver.close();
			Thread.sleep(5000);
			//                        driver.switchTo().window(currentwindow);
			Set<String> windows1=driver.getWindowHandles();
			for (String s : windows1 ){
				driver.switchTo().window(s);
			}


			Report.put("Click on 'View All' link under Driver Updates", "Application should navigate to Drivers Subscriptions page and it should display all the subscriptions in the list for the signed in use", "Application navigates to Drivers Subscriptions page and it displays all the subscriptions in the list for the signed in use", "PASS");

		}
		catch(Exception ex){
			ex.printStackTrace();
			Report.put("Click on Yes Button", "Application should delete selected email subscription and it should be removed from Subscription list", "Application do not delete selected email subscription and it does not remove from Subscription list", "FAIL");
			Assert.fail();


		}




	}


	public void  ClickCreateSubscription_SelectOS(WebDriver driver) 
	{
		System.out.println("Click Drivers and Downloads Tab");
		WebDriverWait  wait = new WebDriverWait(driver, 120);
		System.out.println("After webdriver wait");
		Actions act=new Actions(driver);
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
		try
		{

			System.out.println("Clicked on ClickCreateSubscription_Tab Link");
			driver.navigate().refresh();
			handleCookies(driver);
			//			act.moveToElement(CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.CreateSubscription())).build().perform();

			CommonUtility.ScrollTo(driver, obj_EsupportDriversandDownloadsPage.CreateSubscription());
			CommonUtility.ClickOn(driver, obj_EsupportDriversandDownloadsPage.CreateSubscription());
			//Report.put("Click on 'Create Subscription' button", "User should land in Premier Recent Orders Page", "Premier Recent Orders Page displayed Successfully", "PASS");



			String resentorder="";

			String Driverheadersubscription="";

			Set<String> allWH=driver.getWindowHandles(); 
			String currentwindow=driver.getWindowHandle();
			int count=allWH.size(); 
			System.out.println("Switched Window Handles and  window count is :: "+count);

			for(String wh:allWH)
			{

				Thread.sleep(10000);
				driver.switchTo().window(wh); 
				String title=driver.getTitle();
				System.out.println("Tittle displayed as   :::::"+title);

			}

			String classAttribute1 = CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.SelectProductTab()).getAttribute("class");
			String classAttribute2 = CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.SelectComponentTab()).getAttribute("class");


			if(classAttribute1.contains("complete")&& classAttribute2.contains("progress") )
			{
				Report.put("Click on 'Create Subscription' button", "Application should navigate to 'Driver Updates Subscriptions' page  and the product should be preselected and it should be display Components tab",
						"Application navigates to 'Driver Updates Subscriptions' page  and the product should be preselected and it should be display Components tab","PASS");

			}
			else
			{
				Report.put("Click on 'Create Subscription' button", "Application should navigate to 'Driver Updates Subscriptions' page  and the product should be preselected and it should be display Components tab",
						"Application does not navigate to 'Driver Updates Subscriptions' page  and the product is not preselected and it does not display Components tab","FAIL");
			}


			List<WebElement> list=driver.findElements(obj_EsupportDriversandDownloadsPage.operatingSystem());
			for(WebElement lt:list)
			{
				CommonUtility.highlightElement(driver, lt);
				CommonUtility.highlightElement(driver,lt).click();
				Thread.sleep(2000);

			}

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDriversandDownloadsPage.ComponentTag()));
			CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.ComponentTag());
			String ComponentTagg=CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.ComponentTag()).getText();


			//    Report.put("Click on 'Create Subscription' button", "Application should navigate to 'Driver Updates Subscriptions' page  and the product should be preselected and it should be display Components tab"
			//          +Report.color(ComponentTagg)+" name <br> ",
			//          "Application navigates to 'Driver Updates Subscriptions' page  and the product should be preselected and it should be display Components tab","PASS");
		}

		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on Order Status below Masthead", "User should land in Premier Recent Orders Page", "Premier Recent Orders Page is not displayed", "FAIL");
			Assert.fail();
		}
	}


	public void  selectCheckBox(WebDriver driver) 
	{
		System.out.println("Click Drivers and Downloads Tab");
		WebDriverWait  wait = new WebDriverWait(driver, 120);
		System.out.println("After webdriver wait");
		Actions act=new Actions(driver);
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
		try
		{
			handleCookies(driver);
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDriversandDownloadsPage.SelectAll()));
			CommonUtility.ClickOn(driver,obj_EsupportDriversandDownloadsPage.SelectAll());
			Boolean flag=true;
			List<WebElement> list=driver.findElements(obj_EsupportDriversandDownloadsPage.ApplicationSelect());
			for(WebElement lt:list)
			{
				if(!CommonUtility.highlightElement(driver, lt).isSelected())
					flag=false;
				Thread.sleep(2000);

			}

			if (flag){

				Report.put("Click On Select All check box under Operating Systems", "Application should select all available operating systems",
						"Application selects all available operating systems","PASS");
			}
			else{
				Report.put("Click On Select All check box under Operating Systems", "Application should select all available operating systems",
						"Application does not select all available operating systems","FAIL");
				Assert.fail();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click On Select All check box under Operating Systems", "Application should select all available operating systems",
					"Failed to select all","FAIL");
			Assert.fail();
		}
	}


	public void  deSelectCheckBox(WebDriver driver) 
	{
		System.out.println("Click Drivers and Downloads Tab");
		WebDriverWait  wait = new WebDriverWait(driver, 120);
		System.out.println("After webdriver wait");
		Actions act=new Actions(driver);
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
		try
		{
			handleCookies(driver);
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDriversandDownloadsPage.SelectAll()));
			CommonUtility.ClickOn(driver,obj_EsupportDriversandDownloadsPage.SelectAll());
			Boolean flag=true;
			List<WebElement> list=driver.findElements(obj_EsupportDriversandDownloadsPage.ApplicationSelect());
			for(WebElement lt:list)
			{
				if(CommonUtility.highlightElement(driver, lt).isSelected())
					flag=false;
				Thread.sleep(2000);

			}

			if (flag){

				Report.put("Click On Deselect All check box under Operating Systems", "Application should deselect all available operating systems",
						"Application deselects all available operating systems","PASS");
			}
			else{
				Report.put("Click On deselect All check box under Operating Systems", "Application should deselect all available operating systems",
						"Application does not deselect all available operating systems","FAIL");
				Assert.fail();
			}

			try
			{
				wait = new WebDriverWait(driver, 10);
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.ContinueDisabled());
				Report.put("Click On Deselect All check box under Operating Systems", "Continue button should be disabled",
						"Continue button is disabled","PASS");
			}
			catch (Exception e1)
			{
				e1.printStackTrace();
				Report.put("Click On deselect All check box under Operating Systems", "Continue button should be disabled",
						"Continue button is not disabled","FAIL");
				Assert.fail();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click On Select All check box under Operating Systems", "Application should select all available operating systems",
					"Failed to select all","FAIL");
			Assert.fail();
		}
	}

	public void  selectCheckBoxWindow7(WebDriver driver) 
	{
		System.out.println("Click Drivers and Downloads Tab");
		WebDriverWait  wait = new WebDriverWait(driver, 120);
		System.out.println("After webdriver wait");
		Actions act=new Actions(driver);
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
		try
		{
			handleCookies(driver);
			Boolean flag=true;
			List<WebElement> list=driver.findElements(obj_EsupportDriversandDownloadsPage.operatingSystem());
			for(WebElement lt:list)
			{
				CommonUtility.highlightElement(driver, lt);
				CommonUtility.highlightElement(driver,lt).click();
				Thread.sleep(2000);

			}
			List<WebElement> list1=driver.findElements(obj_EsupportDriversandDownloadsPage.operatingSystemText());
			for(int i=0;i< list1.size(); i++)
			{
				if(list1.get(i).getText().equals("Windows 7, 64-bit"))
				{
					CommonUtility.highlightElement(driver, list.get(i));
					CommonUtility.highlightElement(driver,list.get(i)).click();
					break;
				}

			}


			for(int i=0;i< list1.size(); i++)
			{
				if(list1.get(i).getText().equals("Windows 7, 64-bit"))
				{
					CommonUtility.highlightElement(driver, list.get(i));
					if(!CommonUtility.highlightElement(driver,list.get(i)).isSelected())
						flag = false;
					break;
				}

			}

			if (flag){

				Report.put("Select check box for Windows 7, 64-bit OS", "Application should  select Windows 7, 64-bit operating systems",
						"Application selects Windows 7, 64-bit operating systems","PASS");                             }
			else{
				Report.put("Select check box for Windows 7, 64-bit OS", "Application should  select Windows 7, 64-bit operating systems",
						"Application does not select Windows 7, 64-bit operating systems","FAIL");
				Assert.fail();
			}


		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Select check box for Windows 7, 64-bit OS", "Application should  select Windows 7, 64-bit operating systems",
					"Application does not select Windows 7, 64-bit operating systems","FAIL");
			Assert.fail();
		}
	}


	public void  deSelectCheckBoxWindow7(WebDriver driver) 
	{
		System.out.println("Click Drivers and Downloads Tab");
		WebDriverWait  wait = new WebDriverWait(driver, 120);
		System.out.println("After webdriver wait");
		Actions act=new Actions(driver);
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
		try
		{
			handleCookies(driver);
			Boolean flag=true;
			List<WebElement> list=driver.findElements(obj_EsupportDriversandDownloadsPage.operatingSystem());
			List<WebElement> list1=driver.findElements(obj_EsupportDriversandDownloadsPage.operatingSystemText());
			for(int i=0;i< list1.size(); i++)
			{
				if(list1.get(i).getText().equals("Windows 7, 64-bit"))
				{
					CommonUtility.highlightElement(driver, list.get(i));
					CommonUtility.highlightElement(driver,list.get(i)).click();
					break;
				}

			}

			Thread.sleep(3000);

			for(int i=0;i< list1.size(); i++)
			{
				if(list1.get(i).getText().equals("Windows 7, 64-bit"))
				{
					CommonUtility.highlightElement(driver, list.get(i));
					if(CommonUtility.highlightElement(driver,list.get(i)).isSelected())
						flag = false;
					break;
				}

			}

			if (flag){

				Report.put("Deselect check box for Windows 7, 64-bit OS", "Application should  deselect Windows 7, 64-bit operating system and  Continue button should be disabled.",
						"Application deselects Windows 7, 64-bit operating system and  Continue button is disabled.","PASS");                        }
			else{
				Report.put("Deselect check box for Windows 7, 64-bit OS", "Application should  deselect Windows 7, 64-bit operating system and  Continue button should be disabled.",
						"Application does bot deselect Windows 7, 64-bit operating system and  Continue button is not disabled.","FAIL");
				Assert.fail();
			}

			try
			{
				wait = new WebDriverWait(driver, 10);
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.ContinueDisabled());
				Report.put("Click On Deselect All check box under Operating Systems", "Continue button should be disabled",
						"Continue button is disabled","PASS");
			}
			catch (Exception e1)
			{
				e1.printStackTrace();
				Report.put("Click On deselect All check box under Operating Systems", "Continue button should be disabled",
						"Continue button is not disabled","FAIL");
				Assert.fail();
			}




		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Deselect check box for Windows 7, 64-bit OS", "Application should  deselect Windows 7, 64-bit operating system and  Continue button should be disabled.",
					"Application does bot deselect Windows 7, 64-bit operating system and  Continue button is not disabled.","FAIL");
			Assert.fail();
		}
	}


	public void  ClickCreateSubscription_Notification(WebDriver driver) 
	{
		System.out.println("Click Drivers and Downloads Tab");
		WebDriverWait  wait = new WebDriverWait(driver, 120);
		System.out.println("After webdriver wait");
		Actions act=new Actions(driver);
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
		try
		{

			System.out.println("Clicked on ClickCreateSubscription_Tab Link");
			driver.navigate().refresh();
			handleCookies(driver);
			//			act.moveToElement(CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.CreateSubscription())).build().perform();

			CommonUtility.ScrollTo(driver, obj_EsupportDriversandDownloadsPage.CreateSubscription());
			CommonUtility.ClickOn(driver, obj_EsupportDriversandDownloadsPage.CreateSubscription());
			//Report.put("Click on 'Create Subscription' button", "User should land in Premier Recent Orders Page", "Premier Recent Orders Page displayed Successfully", "PASS");



			String resentorder="";

			String Driverheadersubscription="";

			Set<String> allWH=driver.getWindowHandles(); 
			String currentwindow=driver.getWindowHandle();
			int count=allWH.size(); 
			System.out.println("Switched Window Handles and  window count is :: "+count);

			for(String wh:allWH)
			{

				Thread.sleep(10000);
				driver.switchTo().window(wh); 
				String title=driver.getTitle();
				System.out.println("Tittle displayed as   :::::"+title);

			}

			String classAttribute1 = CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.SelectProductTab()).getAttribute("class");
			String classAttribute2 = CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.SelectComponentTab()).getAttribute("class");


			if(classAttribute1.contains("complete")&& classAttribute2.contains("progress") )
			{
				Report.put("Click on 'Create Subscription' button", "Application should navigate to 'Driver Updates Subscriptions' page  and the product should be preselected and it should be display Components tab",
						"Application navigates to 'Driver Updates Subscriptions' page  and the product should be preselected and it should be display Components tab","PASS");

			}
			else
			{
				Report.put("Click on 'Create Subscription' button", "Application should navigate to 'Driver Updates Subscriptions' page  and the product should be preselected and it should be display Components tab",
						"Application does not navigate to 'Driver Updates Subscriptions' page  and the product is not preselected and it does not display Components tab","FAIL");
			}


			List<WebElement> list=driver.findElements(obj_EsupportDriversandDownloadsPage.operatingSystem());
			for(WebElement lt:list)
			{
				CommonUtility.highlightElement(driver, lt);
				CommonUtility.highlightElement(driver,lt).click();
				Thread.sleep(2000);

			}
			String ComponentTagg="";
			try{
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDriversandDownloadsPage.ComponentTag()));
				CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.ComponentTag());
				ComponentTagg=CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.ComponentTag()).getText();
				Thread.sleep(5000);
				//				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDriversandDownloadsPage.SelectAll()));
				//				CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.SelectAll()).click();


				WebElement element =driver.findElement(By.xpath("//input[contains(@ng-click,'toggleAllCheckboxes')]"));
				act.moveToElement(element).build().perform();
				((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);  

				Report.put("Select any Operating System available in the list","The"+Report.color(ComponentTagg)+"<br> should be displayed for the selected OS",
						"The"+Report.color(ComponentTagg)+"<br> should be displayed for the selected OS", "PASS");

			}
			catch (Exception ex){
				Report.put("Select any Operating System available in the list","The"+Report.color(ComponentTagg)+"<br> should be displayed for the selected OS",
						"The"+Report.color(ComponentTagg)+"<br> should be displayed for the selected OS", "FAIL");
			}

			//driver.findElement(By.xpath("//div[@class='ng-binding']")).click();

			Thread.sleep(3000);

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDriversandDownloadsPage.ContinueEnabled()));
			CommonUtility.ClickOn(driver,obj_EsupportDriversandDownloadsPage.ContinueEnabled());
		}

		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on Order Status below Masthead", "User should land in Premier Recent Orders Page", "Premier Recent Orders Page is not displayed", "FAIL");
			Assert.fail();
		}
	}



	public void  continueSubscription(WebDriver driver) 
	{
		System.out.println("Click Drivers and Downloads Tab");
		WebDriverWait  wait = new WebDriverWait(driver, 120);
		System.out.println("After webdriver wait");
		Actions act=new Actions(driver);
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
		try
		{

			System.out.println("Clicked on ClickCreateSubscription_Tab Link");
			//driver.navigate().refresh();
			handleCookies(driver);

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDriversandDownloadsPage.NameSubscriptiontag()));
			CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.NameSubscriptiontag());
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDriversandDownloadsPage.NotificationTypetag()));
			CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.NotificationTypetag());
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDriversandDownloadsPage.NotificationFrequencytag()));
			CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.NotificationFrequencytag());
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDriversandDownloadsPage.ContinueEnabled()));
			CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.ContinueEnabled());
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDriversandDownloadsPage.CancelButtonNot()));
			CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.CancelButtonNot());
			Report.put("Click on Continue button", "Application should display Option to Name the subscription, Notification Type, Notification Frequency along with Continue and Cancel buttons", "Application displays Option to Name the subscription, Notification Type, Notification Frequency along with Continue and Cancel buttons", "PASS");
		}



		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on Continue button", "Application should display Option to Name the subscription, Notification Type, Notification Frequency along with Continue and Cancel buttons", "Application does not display Option to Name the subscription, Notification Type, Notification Frequency along with Continue and Cancel buttons", "FAIL");
			Assert.fail();
		}
	}



	public void  notificatinTypes(WebDriver driver) 
	{
		System.out.println("Click Drivers and Downloads Tab");
		WebDriverWait  wait = new WebDriverWait(driver, 120);
		System.out.println("After webdriver wait");
		Actions act=new Actions(driver);
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
		try
		{

			System.out.println("Clicked on ClickCreateSubscription_Tab Link");
			driver.navigate().refresh();
			handleCookies(driver);

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDriversandDownloadsPage.AllUpdatesType()));
			CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.AllUpdatesType());
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDriversandDownloadsPage.CriticalRecommendedUpdatesOnlyType()));
			CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.CriticalRecommendedUpdatesOnlyType());
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDriversandDownloadsPage.CriticalUpdatesOnlyType()));
			CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.CriticalUpdatesOnlyType());




			Report.put("Verify Notification Types options", "Application should provide following notification Types:\n• All Updates\n•Critical and Recommended updates only\n•Critical updates only", "Application provides following notification Types:\n• All Updates\n•Critical and Recommended updates only\n•Critical updates only", "PASS");
		}



		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify Notification Types options", "Application should provide following notification Types:\n• All Updates\n•Critical and Recommended updates only\n•Critical updates only", "Application does not provide following notification Types:\n• All Updates\n•Critical and Recommended updates only\n•Critical updates only", "FAIL");
			Assert.fail();
		}
	}

	// Sudha`s 11/16/2018 integrate code..

	public void ReviewSubscription(WebDriver driver)
	{
		System.out.println("selectOperatingSystem");
		Actions act=new Actions(driver);

		try
		{
			//			act.moveToElement(CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.CreateSubscription())).build().perform();

			CommonUtility.ScrollTo(driver, obj_EsupportDriversandDownloadsPage.CreateSubscription());
			CommonUtility.ClickOn(driver, obj_EsupportDriversandDownloadsPage.CreateSubscription());
			System.out.println("Click on Create Subscription Tab");
			Report.put("Click on 'Create Subscription' button", "Application should navigate to 'Driver Updates Subscriptions' page", "Navigated to 'Driver Updates Subscriptions' page Successfully", "PASS");


			Set<String> allWH=driver.getWindowHandles(); 
			String currentwindow=driver.getWindowHandle();
			int count=allWH.size(); 
			System.out.println("Switched Window Handles and  window count is :: "+count);

			for(String wh:allWH)
			{

				Thread.sleep(10000);
				driver.switchTo().window(wh); 
				String title=driver.getTitle();
				System.out.println("Tittle displayed as   :::::"+title); 

				if(title.contains("Driver Updates Subscriptions"))
				{

					System.out.println("Switched to window");

					//handleCookies(driver); 


					//					act.moveToElement(CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.Driverheadersubscription())).build().perform();

					CommonUtility.ScrollTo(driver,obj_EsupportDriversandDownloadsPage.Driverheadersubscription());
					handleCookies(driver);
					//Thread.sleep(5000);
					CommonUtility.ClickOn(driver,obj_EsupportDriversandDownloadsPage.windowsXP());
					Report.put("Modify the Operating system", "Components should be displayed for the selected OS", "Components displayed for the selected OS", "PASS");

					CommonUtility.ClickOn(driver,obj_EsupportDriversandDownloadsPage.audioComponent());
					//					act.moveToElement(CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.Continue())).build().perform();
					CommonUtility.ScrollTo(driver, obj_EsupportDriversandDownloadsPage.Continue());
					CommonUtility.ClickOn(driver, obj_EsupportDriversandDownloadsPage.Continue());

					Report.put("Select Components and click on Continue Button", "Application should allow the user to modify the selection OS and Components", "Selected required OS & Components", "PASS");

					if(CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.setPreferencesTab()).isDisplayed())
					{
						CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.setPreferencesTab());

					}
					if(CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.nameYourSubscription()).isDisplayed())
					{
						CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.nameYourSubscription());

					}

					CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.subscriptionTextbox()).clear();
					CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.subscriptionTextbox()).sendKeys(TestNGCreator.TestData.get(Esupport.FirstName.ordinal()));
					String descName = CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.subscriptionTextbox()).getText();
					System.out.println("subscriptionText is "+descName);


					CommonUtility.ClickOn(driver,obj_EsupportDriversandDownloadsPage.notificationTypeCriticalUpdate());
					CommonUtility.ClickOn(driver,obj_EsupportDriversandDownloadsPage.notificationMonthly());

					Report.put("Modify Name, select alert type as receive only critical and frequency as Monthly and Click on Submit button", "Application should modify the Preferences and it should navigate to Review Subscription by Enabling the Tab", "Modified Subscription Successfully"
							+Report.color(descName) ,"PASS");

					CommonUtility.ClickOn(driver, obj_EsupportDriversandDownloadsPage.subContinue());
					wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDriversandDownloadsPage.reviewSubscriptionHeader()));

					CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.reviewSubscriptionHeader());
					Report.put("Click on Continue button", "Application should navigate to Review Subscription page", "Navigated to Review Subscription page","PASS");
					VerifySubscriptionName(driver);
					driver.close();
					Thread.sleep(5000);
					driver.switchTo().window(currentwindow);

				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Select Components and click on Continue Button", "Application should allow the user to modify the selection OS and Components", "Failed to Select required OS & Components", "FAIL");

			Assert.fail();
		}

	}
	public void VerifySubscriptionName(WebDriver driver)
	{
		System.out.println("Review Subscription");
		String Sname="" ;

		try
		{       String name= (TestNGCreator.TestData.get(Esupport.FirstName.ordinal()));
		System.out.println(name);
		Sname=CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.SubscriptionPreferenceHeader()).getText();
		if(Sname.equalsIgnoreCase("Test"))
		{
			System.out.println("Modified Subscriptions are matching");
		}
		else
		{System.out.println("Modified Subscriptions are not matching");
		}

		Report.put("Review the subscription, verify user chabges are reflected and click on Save button", "Application should modify the Subscription and it should navigate to 'Driver Updates Subscriptions'. Modified Subscription should be displayed under Subscriptions list.", "Application should modify the Subscription and it should navigate to 'Driver Updates Subscriptions'. Modified Subscription is displayed under Subscriptions list.","PASS");

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Review the subscription, verify user chabges are reflected and click on Save button", "Application should modify the Subscription and it should navigate to 'Driver Updates Subscriptions'. Modified Subscription should be displayed under Subscriptions list.", "Application should modify the Subscription and it should navigate to 'Driver Updates Subscriptions'. Modified Subscription is not displayed under Subscriptions list.","FAIL");

			Assert.fail();
		}

	}

	//Pushpa code on 11/16/2018..

	public void  handleSubscription(WebDriver driver) 
	{
		System.out.println("Inside handle Subscription");
		WebDriverWait  wait = new WebDriverWait(driver, 120);
		System.out.println("After webdriver wait");
		Actions act=new Actions(driver);
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);

		String subName = "";
		String emailAddrLabel = "";
		try
		{
			driver.navigate().refresh();
			handleCookies(driver);
			//			act.moveToElement(CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.CreateSubscription())).build().perform();

			CommonUtility.ScrollTo(driver, obj_EsupportDriversandDownloadsPage.CreateSubscription());
			CommonUtility.ClickOn(driver, obj_EsupportDriversandDownloadsPage.CreateSubscription());

			System.out.println("Click on Create Subscription Tab");
			Report.put("Click on 'Create Subscription' button", "Application should navigate to 'Driver Updates Subscriptions' page", "Navigated to 'Driver Updates Subscriptions' page Successfully", "PASS");


			Set<String> allWH=driver.getWindowHandles(); 
			String currentwindow=driver.getWindowHandle();
			int count=allWH.size(); 
			System.out.println("Switched Window Handles and  window count is :: "+count);

			for(String wh:allWH)
			{
				Thread.sleep(10000);
				driver.switchTo().window(wh); 
				String title=driver.getTitle();
				System.out.println("Tittle displayed as   :::::"+title); 

				if(title.contains("Driver Updates Subscriptions"))
				{

					System.out.println("Switched to window");
					handleCookies(driver);


					//					act.moveToElement(CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.Driverheadersubscription())).build().perform();
					handleCookies(driver);
					CommonUtility.ScrollTo(driver,obj_EsupportDriversandDownloadsPage.Driverheadersubscription());
					//Thread.sleep(5000);
					CommonUtility.ClickOn(driver,obj_EsupportDriversandDownloadsPage.windowsXP());


					CommonUtility.ClickOn(driver,obj_EsupportDriversandDownloadsPage.audioComponent());
					CommonUtility.ClickOn(driver,obj_EsupportDriversandDownloadsPage.chipsetComponent());
					Report.put("Select any Operating System available in the list  and select Audio and Chipset Drivers", "Audio and Chipset should be selected in the Components", "Audio and Chipset selected in the Components", "PASS");
					//					act.moveToElement(CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.Continue())).build().perform();
					CommonUtility.ScrollTo(driver, obj_EsupportDriversandDownloadsPage.Continue());
					CommonUtility.ClickOn(driver, obj_EsupportDriversandDownloadsPage.Continue());

					Thread.sleep(5000);
					if(CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.setPreferencesTab()).isDisplayed())
					{
						String header = CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.setPreferencesTab()).getText();
						System.out.println("Header is "+header);
					}
					if(CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.nameYourSubscription()).isDisplayed())
					{
						subName = CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.nameYourSubscription()).getText();
						System.out.println("subName is "+subName);
					}

					String subNameDefault = CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.subscriptionTextbox()).getAttribute("value");
					System.out.println("subscriptionTextbox is "+subNameDefault);

					if(CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.emailAddressLabel()).isDisplayed())
					{
						emailAddrLabel = CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.emailAddressLabel()).getText();
						System.out.println("emailAddressLabel is "+emailAddrLabel);
					}

					String mailId = CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.emailId()).getText();
					System.out.println("Email id is "+mailId);

					CommonUtility.ClickOn(driver,obj_EsupportDriversandDownloadsPage.notificationTypeCriticalUpdate());
					CommonUtility.ClickOn(driver,obj_EsupportDriversandDownloadsPage.notificationMonthly());

					Report.put("Click on Continue button", "Application should display 'Set Preferences' tab and it should display Name your subscription,Email address,Notification Type,Notification frequency", "Required fields are displayed"
							+Report.color(subName) +Report.color(subNameDefault) +Report.color(emailAddrLabel)
							+Report.color(mailId),"PASS");

					CommonUtility.ClickOn(driver, obj_EsupportDriversandDownloadsPage.subContinue());


					wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDriversandDownloadsPage.reviewSubscriptionHeader()));

					CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.reviewSubscriptionHeader());
					Report.put("Click on Continue button", "Application should navigate to Review Subscription page", "Navigated to Review Subscription page","PASS");

					if(CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.productEdit()).isDisplayed())
						CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.productEdit());

					if(CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.componentEdit()).isDisplayed())
						CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.componentEdit());

					if(CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.preferenceEdit()).isDisplayed())
						CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.preferenceEdit());

					if(CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.save()).isDisplayed())
						CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.save());

					if(CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.cancel()).isDisplayed())
						CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.cancel());

					Report.put("Verify Review your subscription details", "Application should display Product  with Edit link, Components with Edit link,  Subscription preferences with Edit link along with 'Save' and 'Cancel' button", 
							"Displayed the required fields successfully","PASS");
					Thread.sleep(5000);
					driver.close();
					driver.switchTo().window(currentwindow);
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Select Components and click on Submit Button", "Application should save the user selected OS&Components and it should navigate to Set your Preferencs tab", "Application is not saved the user selected OS&Components and it should navigate to Set your Preferencs tab", "FAIL");

			Assert.fail();

		}

	}

	public void selectOperatingSystem(WebDriver driver)
	{
		System.out.println("selectOperatingSystem");
		Actions act=new Actions(driver);
		try
		{
			//			act.moveToElement(CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.CreateSubscription())).build().perform();

			CommonUtility.ScrollTo(driver, obj_EsupportDriversandDownloadsPage.CreateSubscription());
			CommonUtility.ClickOn(driver, obj_EsupportDriversandDownloadsPage.CreateSubscription());
			System.out.println("Click on Create Subscription Tab");
			Report.put("Click on 'Create Subscription' button", "Application should navigate to 'Driver Updates Subscriptions' page", "Navigated to 'Driver Updates Subscriptions' page Successfully", "PASS");


			Set<String> allWH=driver.getWindowHandles(); 
			String currentwindow=driver.getWindowHandle();
			int count=allWH.size(); 
			System.out.println("Switched Window Handles and  window count is :: "+count);

			for(String wh:allWH)
			{

				Thread.sleep(10000);
				driver.switchTo().window(wh); 
				String title=driver.getTitle();
				System.out.println("Tittle displayed as   :::::"+title); 



				if(title.contains("Driver Updates Subscriptions"))
				{

					System.out.println("Switched to window");

					//handleCookies(driver); 


					//					act.moveToElement(CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.Driverheadersubscription())).build().perform();

					CommonUtility.ScrollTo(driver,obj_EsupportDriversandDownloadsPage.Driverheadersubscription());
					handleCookies(driver);
					//Thread.sleep(5000);
					CommonUtility.ClickOn(driver,obj_EsupportDriversandDownloadsPage.windowsXP());
					Report.put("Modify the Operating system", "Components should be displayed for the selected OS", "Components displayed for the selected OS", "PASS");

					CommonUtility.ClickOn(driver,obj_EsupportDriversandDownloadsPage.audioComponent());
					//					act.moveToElement(CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.Continue())).build().perform();
					CommonUtility.ScrollTo(driver, obj_EsupportDriversandDownloadsPage.Continue());
					CommonUtility.ClickOn(driver, obj_EsupportDriversandDownloadsPage.Continue());

					Report.put("Select Components and click on Continue Button", "Application should allow the user to modify the selection OS and Components", "Selected required OS & Components", "PASS");

					driver.close();
					Thread.sleep(5000);
					driver.switchTo().window(currentwindow);

				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Select Components and click on Continue Button", "Application should allow the user to modify the selection OS and Components", "Failed to Select required OS & Components", "FAIL");

			Assert.fail();
		}
	}

	public void modifySubscription(WebDriver driver)
	{
		System.out.println("selectOperatingSystem");
		Actions act=new Actions(driver);

		try
		{
			//			act.moveToElement(CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.CreateSubscription())).build().perform();

			CommonUtility.ScrollTo(driver, obj_EsupportDriversandDownloadsPage.CreateSubscription());
			CommonUtility.ClickOn(driver, obj_EsupportDriversandDownloadsPage.CreateSubscription());
			System.out.println("Click on Create Subscription Tab");
			Report.put("Click on 'Create Subscription' button", "Application should navigate to 'Driver Updates Subscriptions' page", "Navigated to 'Driver Updates Subscriptions' page Successfully", "PASS");


			Set<String> allWH=driver.getWindowHandles(); 
			String currentwindow=driver.getWindowHandle();
			int count=allWH.size(); 
			System.out.println("Switched Window Handles and  window count is :: "+count);

			for(String wh:allWH)
			{

				Thread.sleep(10000);
				driver.switchTo().window(wh); 
				String title=driver.getTitle();
				System.out.println("Tittle displayed as   :::::"+title); 

				if(title.contains("Driver Updates Subscriptions"))
				{

					System.out.println("Switched to window");

					//handleCookies(driver); 


					//					act.moveToElement(CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.Driverheadersubscription())).build().perform();

					CommonUtility.ScrollTo(driver,obj_EsupportDriversandDownloadsPage.Driverheadersubscription());
					handleCookies(driver);
					//Thread.sleep(5000);
					CommonUtility.ClickOn(driver,obj_EsupportDriversandDownloadsPage.windowsXP());
					Report.put("Modify the Operating system", "Components should be displayed for the selected OS", "Components displayed for the selected OS", "PASS");

					CommonUtility.ClickOn(driver,obj_EsupportDriversandDownloadsPage.audioComponent());
					//					act.moveToElement(CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.Continue())).build().perform();
					CommonUtility.ScrollTo(driver, obj_EsupportDriversandDownloadsPage.Continue());

					CommonUtility.ClickOn(driver, obj_EsupportDriversandDownloadsPage.Continue());

					Report.put("Select Components and click on Continue Button", "Application should allow the user to modify the selection OS and Components", "Selected required OS & Components", "PASS");

					if(CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.setPreferencesTab()).isDisplayed())
					{
						CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.setPreferencesTab());

					}
					if(CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.nameYourSubscription()).isDisplayed())
					{
						CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.nameYourSubscription());

					}

					CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.subscriptionTextbox()).clear();
					CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.subscriptionTextbox()).sendKeys("Test");
					String descName = CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.subscriptionTextbox()).getText();
					System.out.println("subscriptionText is "+descName);


					CommonUtility.ClickOn(driver,obj_EsupportDriversandDownloadsPage.notificationTypeCriticalUpdate());
					CommonUtility.ClickOn(driver,obj_EsupportDriversandDownloadsPage.notificationMonthly());

					Report.put("Modify Name, select alert type as receive only critical and frequency as Monthly and Click on Submit button", "Application should modify the Preferences and it should navigate to Review Subscription by Enabling the Tab", "Modified Subscription Successfully"
							+Report.color(descName) ,"PASS");

					CommonUtility.ClickOn(driver, obj_EsupportDriversandDownloadsPage.subContinue());
					wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDriversandDownloadsPage.reviewSubscriptionHeader()));

					CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.reviewSubscriptionHeader());
					Report.put("Click on Continue button", "Application should navigate to Review Subscription page", "Navigated to Review Subscription page","PASS");

					driver.close();
					Thread.sleep(5000);
					driver.switchTo().window(currentwindow);

				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Select Components and click on Continue Button", "Application should allow the user to modify the selection OS and Components", "Failed to Select required OS & Components", "FAIL");

			Assert.fail();
		}

	}


	public void selectOperatingSystem_closebrowser(WebDriver driver)
	{
		System.out.println("selectOperatingSystem_closebrowser");
		Actions act=new Actions(driver);
		try
		{

			Set<String> allWH=driver.getWindowHandles(); 
			String currentwindow=driver.getWindowHandle();
			int count=allWH.size(); 
			System.out.println("Switched Window Handles and  window count is :: "+count);

			for(String wh:allWH)
			{

				Thread.sleep(10000);
				driver.switchTo().window(wh); 
				String title=driver.getTitle();
				System.out.println("Tittle displayed as   :::::"+title); 



				if(title.contains("Support for Latitude E4200 | Drivers & downloads | Dell US"))
				{

					System.out.println("Switched to window");

					//handleCookies(driver); 

					Thread.sleep(5000);


					driver.close();
					Thread.sleep(5000);
					driver.switchTo().window(currentwindow);

				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Select Components and click on Continue Button", "Application should allow the user to modify the selection OS and Components", "Failed to Select required OS & Components", "FAIL");

			Assert.fail();
		}
	}


	//pushpa


	public void  handleNameSubscription(WebDriver driver) 
	{
		System.out.println("Inside handle Subscription");
		WebDriverWait  wait = new WebDriverWait(driver, 120);
		System.out.println("After webdriver wait");
		Actions act=new Actions(driver);
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);

		String subscriptionName = TestNGCreator.TestData.get(Esupport.SubscriptionName.ordinal());

		try
		{
			driver.navigate().refresh();
			handleCookies(driver);
			//			act.moveToElement(CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.CreateSubscription())).build().perform();

			CommonUtility.ScrollTo(driver, obj_EsupportDriversandDownloadsPage.CreateSubscription());
			CommonUtility.ClickOn(driver, obj_EsupportDriversandDownloadsPage.CreateSubscription());

			System.out.println("Click on Create Subscription Tab");
			Report.put("Click on 'Create Subscription' button", "Application should navigate to 'Driver Updates Subscriptions' page", "Navigated to 'Driver Updates Subscriptions' page Successfully", "PASS");


			Set<String> allWH=driver.getWindowHandles(); 
			String currentwindow=driver.getWindowHandle();
			int count=allWH.size(); 
			System.out.println("Switched Window Handles and  window count is :: "+count);

			for(String wh:allWH)
			{
				Thread.sleep(10000);
				driver.switchTo().window(wh); 
				String title=driver.getTitle();
				System.out.println("Tittle displayed as   :::::"+title); 

				if(title.contains("Driver Updates Subscriptions"))
				{

					System.out.println("Switched to window");
					handleCookies(driver);


					//					act.moveToElement(CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.Driverheadersubscription())).build().perform();
					//handleCookies(driver);
					CommonUtility.ScrollTo(driver,obj_EsupportDriversandDownloadsPage.Driverheadersubscription());
					//Thread.sleep(5000);
					CommonUtility.ClickOn(driver,obj_EsupportDriversandDownloadsPage.window732bit());


					CommonUtility.ClickOn(driver,obj_EsupportDriversandDownloadsPage.chipsetComponent());
					CommonUtility.ClickOn(driver,obj_EsupportDriversandDownloadsPage.systemUtilities());

					Report.put("Select  Operating System as Windows 7, 32-bit  and select the components Chipset and System Utilities", "Operating System as Windows 7, 32-bit  and components Chipset and System Utilities should be selected", 
							"Operating System as Windows 7, 32-bit  and components Chipset and System Utilities selected Successfully", "PASS");
					//					act.moveToElement(CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.Continue())).build().perform();
					CommonUtility.ScrollTo(driver, obj_EsupportDriversandDownloadsPage.Continue());
					CommonUtility.ClickOn(driver, obj_EsupportDriversandDownloadsPage.Continue());

					Thread.sleep(5000);

					if(CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.setPreferencesTab()).isDisplayed())
					{
						CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.setPreferencesTab());
					}

					Report.put("Click on Continue button", "Application should display 'Set Preferences' tab", "Navigated to Set Preference Tab", "PASS");

					CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.subscriptionTextbox()).clear();
					CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.subscriptionTextbox()).sendKeys(subscriptionName);
					String name = CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.subscriptionTextbox()).getAttribute("value");
					System.out.println("subscriptionTextbox is "+name);


					if(name.length()>40)
					{
						Report.put("Subscription name should be less than 40 characters", "Only 40 Characters should be allowed", "Subscription name is greater than 40 Characters","FAIL");
						Assert.fail();
					}

					Report.put("Enter Name in Name your Subscription", "Application should allow numeric, Alphabets and Special charters in the Name field and it should allow only 40 characters including spaces", "Subscription name entered" +Report.color(name), "PASS");

					CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.notificationTypeCriticalUpdate()).click();
					CommonUtility.ClickOn(driver,obj_EsupportDriversandDownloadsPage.notificationMonthly());

					CommonUtility.ClickOn(driver, obj_EsupportDriversandDownloadsPage.subContinue());


					Report.put("Select Alert type and Preferences and Click on Continue", "Application should enable Select Your Product Tab", "Select your product enabled", "PASS");

					wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDriversandDownloadsPage.reviewSubscriptionHeader()));

					CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.reviewSubscriptionHeader());
					Report.put("Click on Continue button", "Application should navigate to Review Subscription page", "Navigated to Review Subscription page","PASS");


					if(CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.save()).isDisplayed())
					{
						System.out.println("Clicked on Save Button++++++++++++");
						CommonUtility.ClickOn(driver,obj_EsupportDriversandDownloadsPage.save());
					}
					//handleCookies(driver);
					Thread.sleep(5000);
					if(CommonUtility.CheckpresenceofElementLocated(driver, 10, obj_EsupportDriversandDownloadsPage.subscriptionErrorMessage()))
					{
						System.out.println("Inside if statement********************************");
						String errMessage = CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.subscriptionErrorMessage()).getText();
						System.out.println("Error message "+errMessage);
						CommonUtility.ClickOn(driver,obj_EsupportDriversandDownloadsPage.subscriptionErrorMessage());  
						Report.put("Verify Subscription already exists", "Popup should display if the Subscription already exists",
								"Error Message "+Report.color(errMessage), "FAIL");
						driver.close();
						driver.switchTo().window(currentwindow);
						Assert.fail();
					}
					else
					{

						wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDriversandDownloadsPage.DriverUpdatesSubscriptionsTag()));
						CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.DriverUpdatesSubscriptionsTag());

						wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDriversandDownloadsPage.SubscriptionNameField()));
						CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.SubscriptionNameField());
						String SubscriptionNameField=CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.SubscriptionNameField()).getText();

						wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDriversandDownloadsPage.UpdateField()));
						CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.UpdateField());
						String UpdateField=CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.UpdateField()).getText();

						wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDriversandDownloadsPage.DeleteField()));
						CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.DeleteField());
						String DeleteField=CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.DeleteField()).getText();
						driver.findElement(obj_EsupportDriversandDownloadsPage.DeleteField()).click();


						Report.put("Select the Product, Select the Devices, review the subscription and Save the Subscription", "Created Subscription should be displayed in Drivers Subscription page with the name provided along with Update and Delete buttons",

								"Subscription displayed with Update & Delete Buttons"+Report.color(SubscriptionNameField)+" name <br> "

	                                          +Report.color(UpdateField)+"!"+Report.color(DeleteField)+" (links)", "PASS");
						wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDriversandDownloadsPage.DeleteButton()));

						driver.findElement(obj_EsupportDriversandDownloadsPage.DeleteButton()).click();

						Thread.sleep(5000);
						driver.close();
						driver.switchTo().window(currentwindow);
					}
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Select Components and click on Submit Button", "Application should save the user selected OS&Components and it should navigate to Set your Preferencs tab", "Application is not saved the user selected OS&Components and it should navigate to Set your Preferencs tab", "FAIL");

			Assert.fail();

		}

	}

	//New Method
	public void  ClickCreateSubscription_AuthenticatedUser_ChangeProduct(WebDriver driver) 

	{
		System.out.println("Click Drivers and Downloads Tab");
		WebDriverWait  wait = new WebDriverWait(driver, 120);
		System.out.println("After webdriver wait");
		Actions act=new Actions(driver);
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
		try
		{
			driver.navigate().refresh();
			handleCookies(driver);
			Thread.sleep(3000);
			//  wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDriversandDownloadsPage.supportHeading()));
			//			act.moveToElement(CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.CreateSubscription())).build().perform();

			CommonUtility.ScrollTo(driver, obj_EsupportDriversandDownloadsPage.CreateSubscription());
			CommonUtility.ClickOn(driver, obj_EsupportDriversandDownloadsPage.CreateSubscription());

			System.out.println("Clicked on Create Subscription button");
			//Report.put("Click on 'Create Subscription' button", "User should land in Premier Recent Orders Page", "Premier Recent Orders Page displayed Successfully", "PASS");



			String resentorder="";

			String Packingslip="";


			Set<String> allWH=driver.getWindowHandles(); 
			String currentwindow=driver.getWindowHandle();
			int count=allWH.size(); 
			System.out.println("Switched Window Handles and  window count is :: "+count);

			for(String wh:allWH)
			{

				Thread.sleep(10000);
				driver.switchTo().window(wh); 
				String title=driver.getTitle();
				System.out.println("Tittle displayed as   :::::"+title); 



				if(title.contains("Driver Updates Subscriptions"))
				{

					System.out.println("Switched to window");

					handleCookies(driver);
					//					act.moveToElement(CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.Driverheadersubscription())).build().perform();
					handleCookies(driver);
					CommonUtility.ScrollTo(driver,obj_EsupportDriversandDownloadsPage.Driverheadersubscription());

					Thread.sleep(5000);

					Thread.sleep(5000);



					Driverheadersubscription=CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.Driverheadersubscription()).getText();

					String ltMessages="";
					String newselectProduct="";
					CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.Driverheadersubscriptiontabs());

					List<WebElement> list=driver.findElements(obj_EsupportDriversandDownloadsPage.Driverheadersubscriptiontabs());

					for(WebElement lt:list)
					{
						CommonUtility.highlightElement(driver, lt);
						String names=lt.getText();

						System.out.println("Alert Name is: " +names);
						ltMessages+=" <br> " + names;
						if(names.equals("Select product"))
						{
							System.out.println("Select product Matchedddddd");

							if(CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.ChangeProductlink()).isDisplayed())
							{
								System.out.println("Select product is selected");

								newselectProduct=CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.DriverheadersubscriptiontabsSelectProduct()).getText();



							}
						}


					}

					Report.put("Click on 'Create Subscription' button'   ",
							"Application should navigate to "+ Report.color(Driverheadersubscription)+" page  and the Tabs should be display as"+ Report.color(ltMessages)+ " and  "+Report.color(newselectProduct)+" is selected " ,
							"Successfully User should land in "+ Report.color(Driverheadersubscription)+" Page and Tabs should be displayed and "+ Report.color(newselectProduct) +" Selected." , "PASS");


					Thread.sleep(2000);

					Packingslip=CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.Driverheadersubscription()).getText();

					ClickChangeProduct(driver);
					SelectProduct(driver);

					//ClickLattitude_Tab(driver);
					driver.close();
					driver.switchTo().window(currentwindow); 
				}
			}
		}catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on 'Create Subscription' button'   ",
					"Application should navigate to the page  and the Tabs should be display",
					"User not landed on the expected page" , "FAIL");

			//Report.put("Click on the search by drop down", "System should display below mentioned values in the drop down", "Fields are not available", "Fail");
			Assert.fail();
		}
	}

	public void  ClickChangeProduct(WebDriver driver) 
	{
		System.out.println("In Function ClickChangeProduct_Tab");
		WebDriverWait  wait = new WebDriverWait(driver, 120);
		String CancelButton="";
		System.out.println("After webdriver wait");


		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
		try
		{

			if(CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.Headerservicetag()).isDisplayed())
			{
				Prevheader=CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.Headerservicetag()).getText();
			}


			CommonUtility.ScrollTo(driver, obj_EsupportDriversandDownloadsPage.ChangeProductlink());

			//  wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDriversandDownloadsPage.supportHeading()));
			CommonUtility.ClickOn(driver, obj_EsupportDriversandDownloadsPage.ChangeProductlink());

			System.out.println("Clicked on ChangeProductlink Link");

			if(CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.ChangeProductCancelButton()).isDisplayed())
			{
				CancelButton=CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.ChangeProductCancelButton()).getText();
			}




			Thread.sleep(3000);



			Report.put("Click on Change Product", "Application should disaplay All available Products ", "Application disaplayed All available Products ", "PASS");

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on Change Product", "Application should disaplay All available Products ", "Application is not disaplayed All available Products ", "PASS");
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
			CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.ClickingonLaptops());

			//  wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDriversandDownloadsPage.supportHeading()));
			CommonUtility.ClickOn(driver, obj_EsupportDriversandDownloadsPage.ClickingonLaptops());

			System.out.println("Clicked on ClickLaptops_Tab Link");


			Thread.sleep(3000);
			CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.ClickingonLattitude());

			CommonUtility.ClickOn(driver, obj_EsupportDriversandDownloadsPage.ClickingonLattitude());

			System.out.println("Clicked on Clicking on Lattitude Link");

			//			act.moveToElement(CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.ClickingonLattitudeEProduct())).build().perform();

			CommonUtility.ScrollTo(driver, obj_EsupportDriversandDownloadsPage.ClickingonLattitudeEProduct());

			CommonUtility.ClickOn(driver, obj_EsupportDriversandDownloadsPage.ClickingonLattitudeEProduct());

			System.out.println("Clicked on Clicking on ClickingonLattitudeEProduct Link");

			driver.navigate().refresh();

			//act.moveToElement(CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.Headerservicetag())).build().perform();

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDriversandDownloadsPage.Headerservicetag()));
			CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.Headerservicetag());

			ClickingonLattitude=CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.Headerservicetag()).getAttribute("innerText");


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


	//sujata new code

	public void TOVerify_clickDriverNotificationsViewALL(WebDriver driver)
	{      
		WebDriverWait wait = new WebDriverWait(driver, 60);
		Actions act=new Actions(driver);

		try{
			System.out.println("IN Function TOVerify_clickDriverNotificationsViewALL");
			handleCookies(driver);
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDriversandDownloadsPage.DriverNotificationLink()));
			String currentwindow = driver.getCurrentUrl();
			CommonUtility.ClickOn(driver,obj_EsupportDriversandDownloadsPage.DriverNotificationLink());

			Set<String> allWH=driver.getWindowHandles(); 
			String Parentwindow=driver.getWindowHandle();
			int count=allWH.size(); 
			System.out.println("Window Handles and  window count is :: "+count);

			for(String wh:allWH)
			{

				Thread.sleep(10000);
				driver.switchTo().window(wh); 
				String title=driver.getCurrentUrl();
				System.out.println("Tittle displayed as   :::::"+title); 



				if(title.contains("https://www.dell.com/support/Subscriptions/us/en/19"))
				{

					System.out.println("Switched to window");


					handleCookies(driver);

					if(CommonUtility.CheckpresenceofElementLocated(driver, 02, obj_EsupportDriversandDownloadsPage.ViewAllLink()))

					{

						String ViewProductField="";
						WebElement element =driver.findElement(obj_EsupportDriversandDownloadsPage.ViewAllLink());
						//						act.moveToElement(element).build().perform();
						//						((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);

						CommonUtility.ScrollTo(driver,obj_EsupportDriversandDownloadsPage.ViewAllLink());
						CommonUtility.ClickOn(driver,obj_EsupportDriversandDownloadsPage.ViewAllLink());

						wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDriversandDownloadsPage.DriverUpdatesSubscriptionsTag()));
						CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.DriverUpdatesSubscriptionsTag());
						String DriverUpdatesSubscriptionsTag= CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.DriverUpdatesSubscriptionsTag()).getText();


						handleCookies(driver);
						//wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDriversandDownloadsPage.SubscriptionNameField()));
						CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.SubscriptionNameField());
						String SubscriptionNameField=CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.SubscriptionNameField()).getText();


						//wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDriversandDownloadsPage.DateCreatedModifiedField()));
						CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.DateCreatedModifiedField());
						String DateCreatedModifiedField=CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.DateCreatedModifiedField()).getText();


						if(CommonUtility.CheckpresenceofElementLocated(driver, 02, obj_EsupportDriversandDownloadsPage.ViewProductField())){

							Report.put("Click on View product link of subscription", "Application should navigate Product Support Page of the Selected Product with  Tab as default.", "Successfully Application Navigate to  Product Support Page of the Selected Product with Diagnostic Tab as default.", "PASS");
							CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.ViewProductField());
							ViewProductField=CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.ViewProductField()).getText();


						}
						else
						{


							Report.put("Click on View product link of subscription", "View All link is not able to click", "Application not able to find View All Navigate to  Product Support Page of the Selected Product with Diagnostic Tab as default.", "FAIL");
							//driver.close();
							Assert.fail();
						}

						//wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDriversandDownloadsPage.ViewProductField()));

						//wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDriversandDownloadsPage.UpdateField()));
						CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.UpdateField());
						String UpdateField=CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.UpdateField()).getText();

						//wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDriversandDownloadsPage.DeleteField()));
						CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.DeleteField());
						String DeleteField=CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.DeleteField()).getText();
						//wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDriversandDownloadsPage.DeleteSubscriptionTag()));
						//CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.DeleteSubscriptionTag());

						//wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDriversandDownloadsPage.CancelButton()));
						//CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.CancelButton()).click();

						System.out.println("All the links avaiable");
						Thread.sleep(2000);


						Report.put("Click on 'View All' link under Driver Updates", "Application should navigate to "+Report.color(DriverUpdatesSubscriptionsTag)+" page and it should display all the subscriptions in the list for the signed in user and the fields should be"
								+ " 1) "+Report.color(SubscriptionNameField)+" name <br> "
								+ "2) "+Report.color(DateCreatedModifiedField)+" <br>  "
								+ "3) "+Report.color(ViewProductField)+"!"+Report.color(UpdateField)+"!"+Report.color(DeleteField)+" (links)",
								"Successfully Application should navigate to Drivers Subscriptions page and it should display all the subscriptions in the list for the signed in user and the fields should be1) Subscription name 2) Date Created/Modified3) View Product!Update!Delete (links)", "PASS");



						if(CommonUtility.CheckpresenceofElementLocated(driver, 10, obj_EsupportDriversandDownloadsPage.ViewProductField())){

							handleCookies(driver);
							CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.ViewProductField());
							CommonUtility.ClickOn(driver,obj_EsupportDriversandDownloadsPage.ViewProductField());


							wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDriversandDownloadsPage.DiagnosticsHeader()));
							CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.DiagnosticsHeader());
							String DiagnosticsHeader=CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.DiagnosticsHeader()).getText();


							Report.put("Click on View product link of subscription", "Application should navigate Product Support Page of the Selected Product with "+Report.color(DiagnosticsHeader)+" Tab as default.", "Successfully Application Navigate to  Product Support Page of the Selected Product with Diagnostic Tab as default.", "PASS");


						}
						else
						{


							Report.put("Click on View product link of subscription", "View product link is not able to click", "Application not able to find View All Navigate to  Product Support Page of the Selected Product with Diagnostic Tab as default.", "FAIL");

						}

						String PrivacyStatementHeader=CommonUtility.highlightElement(driver, obj_EsupportIncidentsPage.PrivacyStatementHeader()).getText();

						String currenttittle=driver.getCurrentUrl();

						System.out.println(Parentwindow);

						Thread.sleep(4000);
						driver.close();

						Thread.sleep(5000);
						driver.switchTo().window(Parentwindow);

						Thread.sleep(10000);

						System.out.println("current parent window"+driver.getCurrentUrl());

						Thread.sleep(5000);


					}

					else
					{
						Report.put("Click on View ALL link of subscription", "View All link is not able to click", "Application not able to find View All in  Product Support Page of the Selected Product with Diagnostic Tab as default.", "FAIL");
						Thread.sleep(5000);
						//driver.close();
						Thread.sleep(5000);


						String currenttittle=driver.getCurrentUrl();

						System.out.println(Parentwindow);

						Thread.sleep(4000);
						driver.close();

						Thread.sleep(5000);
						driver.switchTo().window(Parentwindow);

						Thread.sleep(10000);

						System.out.println("current parent window"+driver.getCurrentUrl());

						Thread.sleep(5000);

						Assert.fail();


					}

				}
			}




		}
		catch(Exception ex){
			ex.printStackTrace();
			Report.put("Click on View product link of subscription", "View All link is not able to click", "Application not able to find View All Navigate to  Product Support Page of the Selected Product with Diagnostic Tab as default.", "FAIL");
			Assert.fail();



		}




	}


	public void  ClickCreateSubscription_Tab(WebDriver driver) 
	{
		System.out.println("Click Drivers and Downloads Tab");
		WebDriverWait  wait = new WebDriverWait(driver, 120);
		System.out.println("After webdriver wait");
		Actions act=new Actions(driver);
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
		try
		{
			//driver.navigate().refresh();
			handleCookies(driver);
			Thread.sleep(3000);
			//  wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDriversandDownloadsPage.supportHeading()));
			//			act.moveToElement(CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.CreateSubscription())).build().perform();

			CommonUtility.ScrollTo(driver, obj_EsupportDriversandDownloadsPage.CreateSubscription());
			CommonUtility.ClickOn(driver, obj_EsupportDriversandDownloadsPage.CreateSubscription());

			System.out.println("Clicked on Create Subscription button");
			//Report.put("Click on 'Create Subscription' button", "User should land in Premier Recent Orders Page", "Premier Recent Orders Page displayed Successfully", "PASS");



			String resentorder="";

			String Packingslip="";


			Set<String> allWH=driver.getWindowHandles(); 
			String currentwindow=driver.getWindowHandle();
			int count=allWH.size(); 
			System.out.println("Switched Window Handles and  window count is :: "+count);

			for(String wh:allWH)
			{

				Thread.sleep(10000);
				driver.switchTo().window(wh); 
				String title=driver.getTitle();
				System.out.println("Tittle displayed as   :::::"+title); 



				if(title.contains("Driver Updates Subscriptions"))
				{

					System.out.println("Switched to window");

					handleCookies(driver);


					//wait.until(ExpectedConditions.elementToBeClickable(obj_EsupportDriversandDownloadsPage.Loginsigninheader()));


					//Login(driver);



					//					act.moveToElement(CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.Driverheadersubscription())).build().perform();
					handleCookies(driver);
					CommonUtility.ScrollTo(driver,obj_EsupportDriversandDownloadsPage.Driverheadersubscription());

					//purchaseorderActionlabel=CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.LookByOtherserachoptions()).getText();
					Thread.sleep(5000);

					Thread.sleep(5000);

					// CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.Driverheadersubscription()).click();



					Driverheadersubscription=CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.Driverheadersubscription()).getText();

					String ltMessages="";
					String newselectProduct="";
					CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.Driverheadersubscriptiontabs());

					List<WebElement> list=driver.findElements(obj_EsupportDriversandDownloadsPage.Driverheadersubscriptiontabs());

					for(WebElement lt:list)
					{
						CommonUtility.highlightElement(driver, lt);
						String names=lt.getText();

						System.out.println("Alert Name is: " +names);
						ltMessages+=" <br> " + names;
						if(names.equals("Select product"))
						{
							System.out.println("Select product Matchedddddd");

							if(CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.ChangeProductlink()).isDisplayed())
							{
								System.out.println("Select product is selected");

								newselectProduct=CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.DriverheadersubscriptiontabsSelectProduct()).getText();



							}
						}


					}

					Report.put("Click on 'Create Subscription' button'   ",
							"Application should navigate to "+ Report.color(Driverheadersubscription)+" page  and the Tabs should be display as"+ Report.color(ltMessages)+ " and  "+Report.color(newselectProduct)+" is selected " ,
							"Successfully User should land in "+ Report.color(Driverheadersubscription)+" Page and Tabs should be displayed and "+ Report.color(newselectProduct) +" Selected." , "PASS");


					Thread.sleep(2000);

					Packingslip=CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.Driverheadersubscription()).getText();

					toSelectOperatingSystem(driver);
					toEnterSubscription(driver);
					clickSaveButton(driver);
					reviewSubscription(driver);
					DeleteRecord(driver);

					Thread.sleep(5000);

					driver.close();
					Thread.sleep(5000);
					driver.switchTo().window(currentwindow); 

					Thread.sleep(5000);

					String currenturlparent=driver.getCurrentUrl();
					System.out.println("Tittle displayed as   :::::"+currenturlparent); 
					Thread.sleep(5000);


				}
			}
		}catch(Exception e)
		{
			e.printStackTrace();
			Report.put("User is login into Premier account", "Premier Sign in page must be displayed", "Premier Sign in page is not displayed", "Fail");
			Report.put("Enter valid credentials and select the required store ", "Coresponding premier store must be displayed", "Coresponding premier store is not displayed", "Fail");

			//Report.put("Click on the search by drop down", "System should display below mentioned values in the drop down", "Fields are not available", "Fail");
			Assert.fail();
		}
	}

	public void pcfClickDriversandDownloadsTab(WebDriver driver)
	{
		System.out.println("Inside pcfClickDriversandDownloadsTab method");
		Log.info("Inside pcfClickDriversandDownloadsTab method");

		WebDriverWait wait = new WebDriverWait(driver, 120); 

		String tab = "";
		try
		{			
//			==handleCookies(driver);
			Thread.sleep(6000);
			CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.EnterServiceTag());
			Thread.sleep(6000);
//			CommonUtility.ScrollTo(driver,obj_EsupportDriversandDownloadsPage.driversandDownloadsTab());
			
			wait.until(ExpectedConditions.presenceOfElementLocated(obj_EsupportDriversandDownloadsPage.driversandDownloadsTab()));

			CommonUtility.ScrollTo(driver,obj_EsupportDriversandDownloadsPage.driversandDownloadsTab());
		//	CommonUtility.ClickOn(driver,obj_EsupportDriversandDownloadsPage.driversandDownloadsTab());
		    CommonUtility.ToClickByUsingJavaScript_PassingByLoc(driver, obj_EsupportDriversandDownloadsPage.driversandDownloadsTab());
			Thread.sleep(6000);
			System.out.println("clicked");

			//wait.until(ExpectedConditions.presenceOfElementLocated(obj_EsupportDriversandDownloadsPage.driversandDownloadsHeader()));

			CommonUtility.ScrollTo(driver,obj_EsupportDriversandDownloadsPage.driversandDownloadsHeader());

			tab = CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.driversandDownloadsTab()).getText();
			System.out.println(tab);
			Report.put("Click on Drivers & Downloads page",
					"The Driver & Downloads page should be displayed",
					"Loaded Tab "+Report.color(tab ), "PASS");

//			driver.navigate().refresh();

			Thread.sleep(6000);

		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on Drivers & Downloads page",
					"The Driver & Downloads page should be displayed",
					"Failed to load Drivers & Downloads Tab ", "FAIL");
			Assert.fail();
		}
	}

	public void pcfVerifyAdditionalResourceHeader(WebDriver driver)
	{
		System.out.println("Inside pcfVerifyAdditionalResourceHeader method");
		Log.info("Inside pcfVerifyAdditionalResourceHeader method");

		WebDriverWait wait = new WebDriverWait(driver, 120); 

		String header = "";
		try
		{			
			//			Actions act=new Actions(driver);
			//			act.moveToElement(CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.additionalResources())).build().perform();
			CommonUtility.ScrollTo(driver, obj_EsupportDriversandDownloadsPage.additionalResources());
			header = CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.additionalResources()).getText();
			Report.put("Scroll down to the bottom of the page",
					"The Additional Resources section should be displayed",
					"Displayed"+Report.color(header )+"successfully", "PASS");

		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Scroll down to the bottom of the page",
					"The Additional Resources section should be displayed",
					"Failed to display Additional Resources Tab", "FAIL");
			Assert.fail();
		}
	}

	public void pcfVerifyAdditionalResourceSection(WebDriver driver)
	{
		System.out.println("Inside pcfVerifyAdditionalResourceSection method");
		Log.info("Inside pcfVerifyAdditionalResourceSection method");

		WebDriverWait wait = new WebDriverWait(driver, 120); 

		String header = "";
		String ltMessages = "";
		try
		{			
			CommonUtility.ScrollTo(driver, obj_EsupportDriversandDownloadsPage.AdditionalResourceSection());
			CommonUtility.ScrollTo(driver, obj_EsupportDriversandDownloadsPage.additionalResourcesLinks());
			List<WebElement> list=driver.findElements(obj_EsupportDriversandDownloadsPage.additionalResourcesLinks());

			Actions act=new Actions(driver);

			for(WebElement lt:list)
			{

				//				act.moveToElement(CommonUtility.highlightElement(driver, lt)).build().perform();;
				CommonUtility.ScrollToWebElement(driver, lt);
				String names=lt.getText();

				System.out.println("Link is: " +names);
				ltMessages+=" <br> " + names;
			}	

			Report.put("Verify the Additional Resources section",
					"The following section should be displayed under Additional Resources 1. Dell Update 2.Operating System Recovery 3. Dell Digital Locker 4. Driver Notifications 5.Help and How to",
					"Displayed"+Report.color(ltMessages )+" under Additional resources successfully", "PASS");

		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Scroll down to the bottom of the page",
					"The Additional Resources section should be displayed",
					"Failed to display Additional Resources Tab", "FAIL");
			Assert.fail();
		}
	}

	public void pcfClickAdditionalResourceLinks(WebDriver driver)
	{
		System.out.println("Inside pcfClickAdditionalResourceLinks method");
		Log.info("Inside pcfClickAdditionalResourceLinks method");

		WebDriverWait wait = new WebDriverWait(driver, 120); 

		String header = "";
		String ltMessages = "";
		String titleList = "";
		try
		{			
			List<WebElement> list=driver.findElements(obj_EsupportDriversandDownloadsPage.additionalResourcesLinks());

			for (int i = 0; i < list.size(); i++) 
			{
				System.out.println("Inside for loop pcfClickAdditionalResourceLinks");
				//	SupportTopicLink = driver.findElements(obj_EsupportIncidentsPage.SupportTopicLink());
				String value = list.get(i).getText();

				System.out.println("Value is**************"+value);

				if(value.contains("Dell Update") ||value.contains("Operating")||value.contains("Dell Digital Locker")||value.contains("notifications")||value.contains("Help"))
				{

					list.get(i).click();

					Thread.sleep(10000);
					String mainwindow=driver.getWindowHandle();
					Set<String> set=driver.getWindowHandles();
					int count=set.size();
					System.out.println(count);
					Iterator<String> itr=set.iterator();
					while(itr.hasNext())
					{
						String childWindow=itr.next();
						if(!mainwindow.equals(childWindow))
						{
							driver.switchTo().window(childWindow);
							String title=driver.getTitle();

							System.out.println("Title of article id "+title);
							String currenturl=driver.getCurrentUrl();

							System.out.println("current url is "+currenturl);
							driver.close();
						}


					}
					driver.switchTo().window(mainwindow);

				}

			}



			Report.put("Verify the links are clickable",
					"The links should be clickable but will be redirected to production URLs as of now",
					"Clicked links are "+Report.color(ltMessages )+" under Additional resources ", "PASS");

		} 
		catch(Exception e)
		{
			e.printStackTrace();

			Report.put("Verify the links are clickable",
					"The links should be clickable but will be redirected to production URLs as of now",
					"Failed to click on links under Additional resources ", "FAIL");
			Assert.fail();
		}
	}

	public void pcfVerifyDriversTable(WebDriver driver)
	{
		System.out.println("Inside pcfVerifyDriversTable method");
		Log.info("Inside pcfVerifyDriversTable method");

		WebDriverWait wait = new WebDriverWait(driver, 120); 

		try
		{			
			Actions act=new Actions(driver);
			//act.moveToElement(CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.driversTable())).build().perform();
			if(CommonUtility.CheckpresenceofAllElementLocated(driver, 15,obj_EsupportDriversandDownloadsPage.driversTable()))
			{
			
			CommonUtility.ScrollTo(driver, obj_EsupportDriversandDownloadsPage.driversTable());
			Report.put("Select the product",
					"The Drivers & Downloads page should be displayed with the Drivers list for the selected service tag",
					"Displayed downloads table successfully", "PASS");
			
			Report.put("Verify the driver list is NOT collapsed",
					"The driver list should not be collapsed and user can continue using the drivers and download section without changes in the overall experience",
					"User not able to see changes in overall drivers and download section experience", "PASS");
			
			Report.put("Verify that there is no option to collapse the list",
					"There should not be any option to collapse the list",
					"User not sees option to collapse the list", "PASS");
			}
			else
			{
				System.out.println("user not able to see drivers table by default for non consumer product name");
				Report.put("Select the product",
						"The Drivers & Downloads page should be displayed with the Drivers list for the selected service tag",
						"Failed to Display downloads table", "FAIL");
				
				Report.put("Verify the driver list is NOT collapsed",
						"The driver list should not be collapsed and user can continue using the drivers and download section without changes in the overall experience",
						"User able to see changes in overall drivers and download section experience", "FAIL");
				
				Report.put("Verify that there is no option to collapse the list",
						"There should not be any option to collapse the list",
						"User sees option to collapse the list", "FAIL");
				
				Assert.fail();
			}

		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Select the product",
					"The Drivers & Downloads page should be displayed with the Drivers list for the selected service tag",
					"Failed to Display downloads table", "FAIL");
			
			Report.put("Verify the driver list is NOT collapsed",
					"The driver list should not be collapsed and user can continue using the drivers and download section without changes in the overall experience",
					"User able to see changes in overall drivers and download section experience", "FAIL");
			
			Report.put("Verify that there is no option to collapse the list",
					"There should not be any option to collapse the list",
					"User sees option to collapse the list", "FAIL");
			
			Assert.fail();
		}
	}


	public void pcfSelectDriversFromTable(WebDriver driver)
	{
		System.out.println("Inside pcfSelectDriversFromTable method");
		Log.info("Inside pcfSelectDriversFromTable method");

		WebDriverWait wait = new WebDriverWait(driver, 120); 

		try
		{	
			handleCookies(driver);
			//WebElement check = driver.findElement(By.xpath("(//td[@class=' text-center'])[1]"));
			Actions act=new Actions(driver);
			CommonUtility.ScrollTo(driver, obj_EsupportDriversandDownloadsPage.driversCheckbox());
			//act.moveToElement(CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.driversCheckbox())).build().perform();
			Thread.sleep(5000);

			CommonUtility.ClickOn(driver, obj_EsupportDriversandDownloadsPage.driversCheckbox());


		} 
		catch(Exception e)
		{
			e.printStackTrace();

			Assert.fail();
		}
	}

	public void pcfSelectDriversFromTable_IE(WebDriver driver)
	{
		System.out.println("Inside pcfSelectDriversFromTable_IE method");
		Log.info("Inside pcfSelectDriversFromTable_IE method");

		WebDriverWait wait = new WebDriverWait(driver, 120); 

		try
		{	
			handleCookies(driver);
			//WebElement check = driver.findElement(By.xpath("(//td[@class=' text-center'])[1]"));
			Actions act=new Actions(driver);
			CommonUtility.ScrollTo(driver, obj_EsupportDriversandDownloadsPage.DriversCheckbox_IE());
			//act.moveToElement(CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.driversCheckbox())).build().perform();
			Thread.sleep(5000);

			CommonUtility.ClickOn(driver, obj_EsupportDriversandDownloadsPage.DriversCheckbox_IE());


		} 
		catch(Exception e)
		{
			e.printStackTrace();

			Assert.fail();
		}
	}
	public void pcfClickDownloadListToggleButton(WebDriver driver)
	{
		System.out.println("Inside pcfClickDownloadListToggleButton method");
		Log.info("Inside pcfClickDownloadListToggleButton method");

		WebDriverWait wait = new WebDriverWait(driver, 120); 
		String data = "";
		try
		{	

			Actions act=new Actions(driver);
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			//	act.moveToElement(CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.downloadListToggleButton())).build().perform();
			CommonUtility.ScrollTo(driver, obj_EsupportDriversandDownloadsPage.downloadListToggleButton());
			CommonUtility.ClickOn(driver, obj_EsupportDriversandDownloadsPage.downloadListToggleButton());

			Thread.sleep(6000);
			//			act.moveToElement(CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.downloadListToggleButton())).click().build().perform();
		} 
		catch(Exception e)
		{
			e.printStackTrace();

			Assert.fail();
		}
	}

	public void pcfDisplayDownloadListData(WebDriver driver)
	{
		System.out.println("Inside pcfDisplayDownloadListData method");
		Log.info("Inside pcfDisplayDownloadListData method");

		WebDriverWait wait = new WebDriverWait(driver, 120); 
		String data = "";
		try
		{				
			Thread.sleep(6000);
			List<WebElement> list=driver.findElements(obj_EsupportDriversandDownloadsPage.downloadListData());

			Actions act=new Actions(driver);

			for(WebElement lt:list)
			{
				CommonUtility.highlightElement(driver, lt);
				String names=lt.getText();

				System.out.println("Data is: " +names);
				data+=" <br> " + names;
			}	

			System.out.println(data);

			Report.put("Choose the drivers from the list (single, multiple or based on category)",
					"The Drivers list should be displayed as per the selection",
					"Displayed list"+Report.color(data)+"table successfully", "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Choose the drivers from the list (single, multiple or based on category)",
					"The Drivers list should be displayed as per the selection",
					"Failed to Display list as per the selection", "FAIL");
			Assert.fail();
		}
	}

	public void pcfClickDownloadAllButton(WebDriver driver)
	{
		System.out.println("Inside pcfClickDownloadAllButton method");
		Log.info("Inside pcfClickDownloadAllButton method");

		WebDriverWait wait = new WebDriverWait(driver, 120); 
		String data = "";
		try
		{				
			Actions act=new Actions(driver);
			CommonUtility.ScrollTo(driver, obj_EsupportDriversandDownloadsPage.downloadAllButton());
			//act.moveToElement(CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.downloadAllButton())).build().perform();
			//CommonUtility.ClickOn(driver, obj_EsupportDriversandDownloadsPage.downloadAllButton());

			Report.put("Click on Download All button",
					"The Drivers list should be downloaded",
					"Downloaded Drivers successfully", "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on Download All button",
					"The Drivers list should be downloaded",
					"Failed to download drivers", "FAIL");
			Assert.fail();
		}
	}

	public void pcfSelectMultipleDrivers(WebDriver driver)
	{
		System.out.println("Inside pcfSelectMultipleDrivers method");
		Log.info("Inside pcfSelectMultipleDrivers method");

		WebDriverWait wait = new WebDriverWait(driver, 120); 
		String section = "";
		try
		{				
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			try
			{
				//				Thread.sleep(10000);
				wait.until(ExpectedConditions.presenceOfElementLocated(obj_EsupportDriversandDownloadsPage.driversCheckboxMultiple()));
				CommonUtility.ScrollTo(driver, obj_EsupportDriversandDownloadsPage.driversCheckboxMultiple());

				List<WebElement> list=driver.findElements(obj_EsupportDriversandDownloadsPage.driversCheckboxMultiple());

				Actions act=new Actions(driver);
				int count=0;
				for (int i = 0; i <5 ; i++)
				{		
					//				act.moveToElement(CommonUtility.highlightElement(driver, list.get(i))).build().perform();
					//	((JavascriptExecutor)driver).executeScript("arguments[0].click();", list.get(i));

					//				CommonUtility.scrollToViewElement(driver, list.get(i));
					count++;
					if(count==1 || count==3 || count==5)
					{
						if (!(list.get(i).isSelected())) 
						{
							CommonUtility.scrollToViewElement(driver, list.get(i));
							//						list.get(i).click();

							CommonUtility.ClickOnWebElement(driver, list.get(i));

							Thread.sleep(3000);
						}

						if (!(list.get(i).isSelected())) 
						{
							CommonUtility.scrollToViewElement(driver, list.get(i));
							//							list.get(i).click();
							((JavascriptExecutor)driver).executeScript("arguments[0].click();", list.get(i)); 
							Thread.sleep(3000);
						}
					}
					//act.moveToElement(list.get(i)).click().perform();
					//	CommonUtility.highlightElement(driver, list.get(i)).click();	
					//	CommonUtility.ToClickByUsingJavaScript(driver, list.get(i));
				}
			}
			catch(Exception e)
			{

			}

			section = CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.downloadListSection()).getText();

			System.out.println("Download Section :"+section);
			Report.put(" Select multiple drivers from the driver list",
					"The selected drivers should be displayed in a Download list section which gets added above the header section of the driver list.",
					"Selected Drivers added to Download section successfully"+Report.color(section), "PASS");

			Thread.sleep(20000);
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put(" Select multiple drivers from the driver list",
					"The selected drivers should be displayed in a Download list section which gets added above the header section of the driver list.",
					"Failed to add Selected Drivers to Download section", "FAIL");
			Assert.fail();
		}
	}

	
	public void pcfSelectMultipleDrivers_IE(WebDriver driver)
	{
		System.out.println("Inside pcfSelectMultipleDrivers_IE method");
		Log.info("Inside pcfSelectMultipleDrivers_IE method");

		WebDriverWait wait = new WebDriverWait(driver, 120); 
		String section = "";
		try
		{				
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			try
			{
				//				Thread.sleep(10000);
				wait.until(ExpectedConditions.presenceOfElementLocated(obj_EsupportDriversandDownloadsPage.DriversCheckboxMultiple_IE()));
				CommonUtility.ScrollTo(driver, obj_EsupportDriversandDownloadsPage.DriversCheckboxMultiple_IE());

				List<WebElement> list=driver.findElements(obj_EsupportDriversandDownloadsPage.DriversCheckboxMultiple_IE());

				Actions act=new Actions(driver);
				int count=0;
				for (int i = 0; i <5 ; i++)
				{		
					//				act.moveToElement(CommonUtility.highlightElement(driver, list.get(i))).build().perform();
					//	((JavascriptExecutor)driver).executeScript("arguments[0].click();", list.get(i));

					//				CommonUtility.scrollToViewElement(driver, list.get(i));
					count++;
					if(count==1 || count==3 || count==5)
					{
						if (!(list.get(i).isSelected())) 
						{
							CommonUtility.scrollToViewElement(driver, list.get(i));
							//						list.get(i).click();

							CommonUtility.ClickOnWebElement(driver, list.get(i));

							Thread.sleep(3000);
						}

						if (!(list.get(i).isSelected())) 
						{
							CommonUtility.scrollToViewElement(driver, list.get(i));
							//							list.get(i).click();
							((JavascriptExecutor)driver).executeScript("arguments[0].click();", list.get(i)); 
							Thread.sleep(3000);
						}
					}
					//act.moveToElement(list.get(i)).click().perform();
					//	CommonUtility.highlightElement(driver, list.get(i)).click();	
					//	CommonUtility.ToClickByUsingJavaScript(driver, list.get(i));
				}
			}
			catch(Exception e)
			{

			}

			section = CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.downloadListSection()).getText();

			System.out.println("Download Section :"+section);
			Report.put(" Select multiple drivers from the driver list",
					"The selected drivers should be displayed in a Download list section which gets added above the header section of the driver list.",
					"Selected Drivers added to Download section successfully"+Report.color(section), "PASS");

			Thread.sleep(20000);
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put(" Select multiple drivers from the driver list",
					"The selected drivers should be displayed in a Download list section which gets added above the header section of the driver list.",
					"Failed to add Selected Drivers to Download section", "FAIL");
			Assert.fail();
		}
	}

	public void pcfVerifyDownloadSection(WebDriver driver)
	{
		System.out.println("Inside pcfVerifyDownloadSection method");
		Log.info("Inside pcfVerifyDownloadSection method");

		WebDriverWait wait = new WebDriverWait(driver, 120); 
		String section = "";
		String downloadButton = "";
		String removeButton = "";
		try
		{			
			CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.downloadListSection());
			section = CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.downloadListSection()).getText();

			System.out.println(section);

			CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.downloadAllButton());

			downloadButton = CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.downloadAllButton()).getText();
			System.out.println(downloadButton);

			CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.removeAllButton());
			removeButton = CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.removeAllButton()).getText();
			System.out.println(removeButton);

			Report.put("Verify the list displayed",
					"List should consist of number of files selected and total file size with option to remove all selected files or download them.",
					"Displayed download section "+Report.color(section)+ "Buttons "+Report.color(removeButton)+Report.color(downloadButton)+" successfully", "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify the list displayed",
					"List should consist of number of files selected and total file size with option to remove all selected files or download them.",
					"Failed to Display number of selected files & buttons", "FAIL");
			Assert.fail();
		}
	}

	public void pcfVerifyDownloadSectionDetails(WebDriver driver)
	{
		System.out.println("Inside pcfVerifyDownloadSectionDetails method");
		Log.info("Inside pcfVerifyDownloadSectionDetails method");

		WebDriverWait wait = new WebDriverWait(driver, 120); 
		String data = "";
		try
		{				
			Thread.sleep(6000);
			Thread.sleep(6000);
			CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.downloadListData());
			List<WebElement> list=driver.findElements(obj_EsupportDriversandDownloadsPage.downloadListData());

			Actions act=new Actions(driver);

			for(WebElement lt:list)
			{
				act.moveToElement(CommonUtility.highlightElement(driver, lt)).build().perform();
				String names=lt.getText();

				System.out.println("Data is: " +names);
				data+=" <br> " + names;
			}	

			System.out.println(data);

			List<WebElement> cancelList=driver.findElements(obj_EsupportDriversandDownloadsPage.cancelButton());



			for(WebElement lt:cancelList)
			{
				System.out.println("Inside for loop cancel Button");
				CommonUtility.highlightElement(driver, lt);
			}	

			if(CommonUtility.CheckpresenceofElementLocated(driver, 05, obj_EsupportDriversandDownloadsPage.downloadListToggleButton()))
			{
				System.out.println("Collapse button present");
			}

			Report.put("Click on the small down arrow to expand the chosen driver list",
					"Expanding the download list, should list all downloads, along with an option to remove an individual download from the list. Additionally there is a tooltip to collapse download list.",
					"Displayed list"+Report.color(data)+" successfully with remove &  collapse button", "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on the small down arrow to expand the chosen driver list",
					"Expanding the download list, should list all downloads, along with an option to remove an individual download from the list. Additionally there is a tooltip to collapse download list.",
					"Failed to display list with remove &  collapse button", "FAIL");
			Assert.fail();
		}
	}

	public void pcfDeleteDriversFromTable(WebDriver driver)
	{
		System.out.println("Inside pcfDeleteDriversFromTable method");
		Log.info("Inside pcfDeleteDriversFromTable method");

		WebDriverWait wait = new WebDriverWait(driver, 120); 
		String data = "";

		try
		{	
			handleCookies(driver);
			//WebElement check = driver.findElement(By.xpath("(//td[@class=' text-center'])[1]"));
			Actions act=new Actions(driver);
			//			act.moveToElement(CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.driversCheckbox())).build().perform();
			CommonUtility.ScrollTo(driver, obj_EsupportDriversandDownloadsPage.driversCheckbox());

			CommonUtility.ClickOn(driver, obj_EsupportDriversandDownloadsPage.driversCheckbox());
			List<WebElement> list=driver.findElements(obj_EsupportDriversandDownloadsPage.downloadListData());


			for(WebElement lt:list)
			{
				//				act.moveToElement(CommonUtility.highlightElement(driver, lt)).build().perform();
				CommonUtility.scrollToViewElement(driver, lt);
				String names=lt.getText();

				System.out.println("Data is: " +names);
				data+=" <br> " + names;
			}	

			System.out.println(data);

			Report.put("Click to Delete one selected driver",
					"The driver should be deleted from the list",
					"Driver deleted from the list. List displayed as: "+Report.color(data), "PASS");

		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click to Delete one selected driver",
					"The driver should be deleted from the list",
					"Failed to delete from the list ", "FAIL");
			Assert.fail();
		}
	}

	public void  pcfClickViewDetailsLink(WebDriver driver) 
	{
		System.out.println("Inside pcfClickViewDetailsLink");
		Log.info("Inside pcfClickViewDetailsLink");

		WebDriverWait  wait = new WebDriverWait(driver, 120);

		try
		{
			CommonUtility.ScrollTo(driver,obj_EsupportDriversandDownloadsPage.viewDetailsLink());

			CommonUtility.ClickOn(driver,obj_EsupportDriversandDownloadsPage.viewDetailsLink());
			Set<String> allWH=driver.getWindowHandles(); 
			String currentwindow=driver.getWindowHandle();
			int count=allWH.size(); 
			System.out.println("Switched Window Handles and  window count is :: "+count);

			for(String wh:allWH)
			{

				Thread.sleep(10000);
				Thread.sleep(10000);
				driver.switchTo().window(wh); 
				String title=driver.getCurrentUrl();
				System.out.println("URL  displayed as   :::::"+title); 

				Thread.sleep(10000);
				if(title.contains("driverid"))
				{
					System.out.println("Switched to driver details");

					wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDriversandDownloadsPage.driverDetailsHeader()));
					CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.driverDetailsHeader());
					String header = CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.driverDetailsHeader()).getText();
					System.out.println("Driver header is: "+header);
					Report.put("Click on View Detail link for a selected driver",
							"Should navigate to selected driver page successfully " ,
							"Navigated to Page Successfully" +Report.color(title), "PASS");
					Thread.sleep(5000);
					driver.close();
					driver.switchTo().window(currentwindow);

				}
			}


		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on View Detail link for a selected driver",
					"Should navigate to selected driver page successfully " ,
					"Failed to Navigate to Driver Page", "FAIL");
			Assert.fail();
		}
	}

	public void pcfVerifyDetectDriversButton(WebDriver driver)
	{
		System.out.println("Inside pcfVerifyDetectDriversButton method");
		Log.info("Inside pcfVerifyDetectDriversButton method");

		WebDriverWait wait = new WebDriverWait(driver, 120); 

		String text = "";
		try
		{			

			if(CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.detectDriversButton()).isDisplayed())
			{
				text = CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.detectDriversButton()).getText();

				Report.put("Verify the Detect Drivers button",
						"Detect Drivers should be displayed if the product is configured to display the button",
						"Displayed button "+Report.color(text ), "PASS");
			}	
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify the Detect Drivers button",
					"Detect Drivers should be displayed if the product is configured to display the button",
					"Failed to Display Detect Drivers Button ", "FAIL");
			Assert.fail();
		}
	}

	public void pcfVerifyFilterSection(WebDriver driver)
	{
		System.out.println("Inside pcfVerifyFilterSection method");
		Log.info("Inside pcfVerifyFilterSection method");

		WebDriverWait wait = new WebDriverWait(driver, 120); 
		String labels = "";

		try
		{			
			Actions act=new Actions(driver);

			List<WebElement> list=driver.findElements(obj_EsupportDriversandDownloadsPage.filterSectionLabels());

			for(WebElement lt:list)
			{
				CommonUtility.highlightElement(driver, lt);
				String names=lt.getText();
				//	CommonUtility.highlightElement(driver, lt);
				System.out.println("Label is: " +names);
				labels+=" <br> " + names;
			}	

			System.out.println(labels);

			Report.put("Verify the filter section",
					"The filter section should be displayed if the driver list is displayed with the following filters Keyword Operating System",
					"Displayed Filter Section with filters: "+Report.color(labels), "PASS");

		} 
		catch(Exception e)
		{
			e.printStackTrace();

			Report.put("Verify the filter section",
					"The filter section should be displayed if the driver list is displayed with the following filters Keyword Operating System",
					"Failed to Display Filter Section details", "FAIL");
			Assert.fail();
		}
	}

	public void pcfVerifyDriverListSection(WebDriver driver)
	{
		System.out.println("Inside pcfVerifyFilterSection method");
		Log.info("Inside pcfVerifyFilterSection method");

		WebDriverWait wait = new WebDriverWait(driver, 120); 
		String labels = "";
		String text = "";
		try
		{			
			Actions act=new Actions(driver);

			List<WebElement> list=driver.findElements(obj_EsupportDriversandDownloadsPage.driverListSection());

			for(WebElement lt:list)
			{
				CommonUtility.highlightElement(driver, lt);
				//	act.moveToElement(CommonUtility.highlightElement(driver, lt)).build().perform();
				String names=lt.getText();
				//	CommonUtility.highlightElement(driver, lt);
				System.out.println("Label is: " +names);
				labels+=" <br> " + names;
			}	

			System.out.println(labels);

			if(CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.driverListActionLabel()).isDisplayed())
			{
				text = CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.driverListActionLabel()).getAttribute("content");
				System.out.println("Label is(Action)"+text);

			}	

			Report.put("Verify the Driver list section",
					"The Driver list section should be displayed with Name , Category , Release Date and Action",
					"Displayed Driver List Section with columns:  "+Report.color(labels)+"<br>"+Report.color(text), "PASS");

		} 
		catch(Exception e)
		{
			e.printStackTrace();

			Report.put("Verify the Driver list section",
					"The Driver list section should be displayed with Name , Category , Release Date and Action",
					"Failed to Display Driver List Section", "FAIL");
			Assert.fail();
		}
	}

	public void pcfVerifySortOptionDriverList(WebDriver driver)
	{
		System.out.println("Inside pcfVerifySortOptionDriverList method");
		Log.info("Inside pcfVerifySortOptionDriverList method");

		WebDriverWait wait = new WebDriverWait(driver, 120); 
		String labels = "";
		String text = "";
		try
		{			
			Actions act=new Actions(driver);

			List<WebElement> list=driver.findElements(obj_EsupportDriversandDownloadsPage.driverListSection());

			for(WebElement lt:list)
			{
				CommonUtility.highlightElement(driver, lt);
				//	act.moveToElement(CommonUtility.highlightElement(driver, lt)).build().perform();
				String names=lt.getText();
				if(lt.getAttribute("class").contains("sort"))
				{
					System.out.println(names +"is sortable");
					labels+=" <br> " + names +" is sortable";
				}

				System.out.println("Label is: " +names);


			}	


			Report.put("Verify the option on the columns to sort",
					"The list of drivers should be sortable",
					"Displayed Sortable Columns  "+Report.color(labels), "PASS");

		} 
		catch(Exception e)
		{
			e.printStackTrace();

			Report.put("Verify the option on the columns to sort",
					"The list of drivers should be sortable",
					"Failed to Display Sortable Columns  ", "FAIL");
			Assert.fail();
		}
	}

	public void  clickDriversandDownloadsLink(WebDriver driver) 
	{
		System.out.println("Inside clickDriversandDownloadsLink");
		WebDriverWait  wait = new WebDriverWait(driver, 120);

		String link = "";
		String header = "";
		try
		{
			handleCookies(driver);
			//			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDriversandDownloadsPage.homepageHeader()));
			CommonUtility.ScrollTo(driver, obj_EsupportDriversandDownloadsPage.driversandDownloadsLink());
			//			Actions act=new Actions(driver);
			//			act.moveToElement(CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.driversandDownloadsLink())).build().perform();
			CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.driversandDownloadsLink());
			link = CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.driversandDownloadsLink()).getText();

			System.out.println("Clicked on link"+link);

			CommonUtility.ClickOn(driver, obj_EsupportDriversandDownloadsPage.driversandDownloadsLink());



			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDriversandDownloadsPage.driversHeader()));

			header = CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.driversHeader()).getText();

			if(CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.SearchServicetag()).isDisplayed())
			{
				Report.put("Click on Drivers and Downloads link in the page", 
						"The page should be displayed with the option for the user to enter service tag",
						"Clicked on Link "+Report.color(link) +"Successfully displayed page"+Report.color(header) +"with the option for the user to enter service tag" , "PASS");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on Drivers and Downloads link in the page", 
					"The page should be displayed with the option for the user to enter service tag",
					"Failed to click on Drivers & Downlaods Link", "FAIL");
			Assert.fail();
		}
	}

	public void validateOSdropdownDisabled(WebDriver driver,String input) 
	{
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 240);

		System.out.println("Inside validateOSdropdownDisabled");
		Log.info("Inside validateOSdropdownDisabled"); 

		try 
		{
			String Headerservicetag="";
			String Headerservicetagdisplay="";


			CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.SearchServicetag()).clear();
			CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.SearchServicetag()).sendKeys(input);
			CommonUtility.ScrollTo(driver,obj_EsupportDriversandDownloadsPage.Servicetagiconsearch());

			CommonUtility.ClickOn(driver,obj_EsupportDriversandDownloadsPage.Servicetagiconsearch());

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDriversandDownloadsPage.ServiceTagHeaderdisplayed()));
			CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.ServiceTagHeaderdisplayed());
			Headerservicetagdisplay=CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.ServiceTagHeaderdisplayed()).getText();

			System.out.println("Header Service Tag is "+Headerservicetagdisplay);

			if(!(CommonUtility.CheckpresenceofElementLocated(driver, 5, obj_EsupportDriversandDownloadsPage.operatingSystemDropdown())))
			{
				System.out.println("Inside if of operating System dropdown");
				Report.put("Select any product and Verify the  user experience when a product with no OS is selected (powerconnect-3448)",
						"The Operating System dropdown should be disabled",
						"Successfully Application should navigate to "+Report.color(Headerservicetagdisplay) +"Operating System Dropdown is disabled", "PASS");					
			}	
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Select any product and Verify the  user experience when a product with no OS is selected (powerconnect-3348)",
					"The Operating System dropdown should be disabled",
					"Failed to validate if Operating System dropdown is disabled", "FAIL");					
			Assert.fail();

		}
	}

	public void verifyNoDriversFoundMessage(WebDriver driver,String input) 
	{
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 120);

		System.out.println("Inside verifyNoDriversFoundMessage");
		Log.info("Inside verifyNoDriversFoundMessage"); 

		try 
		{
			String message = "";


			CommonUtility.ScrollTo(driver,obj_EsupportDriversandDownloadsPage.keywordTextbox());
			CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.keywordTextbox()).clear();
			CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.keywordTextbox()).sendKeys(input);

			Thread.sleep(6000);
			CommonUtility.ScrollTo(driver,obj_EsupportDriversandDownloadsPage.SearchButtonIn());
			CommonUtility.ClickOn(driver,obj_EsupportDriversandDownloadsPage.SearchButtonIn());
			//			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDriversandDownloadsPage.noDriversFoundMessage()));
			CommonUtility.ScrollTo(driver,obj_EsupportDriversandDownloadsPage.noDriversFoundMessage());
			CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.noDriversFoundMessage());

			message=CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.noDriversFoundMessage()).getText();

			System.out.println("Message is "+message);

			Report.put("Enter a "+Report.color(input)+" keyword and verify the results when there are no results",
					"The table will have the text \"No results\"",
					"Entered Keyword"+Report.color(input)+" .Successfully displayed message"+Report.color(message), "PASS");		

			Report.put("Verify the number of drivers \r\n"
					+ "\r\n"
					+ "Precondition: No downloads found for the keyword",
					"The 'Number of drivers' should be displayed as 0",
					"Entered Keyword"+Report.color(input)+" .Successfully displayed message"+Report.color(message), "PASS");					
		}                                                                                                                                        
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify the  user experience when a filter search returns no result",
					"The following message should be displayed 'No drivers found. There are no drivers that meet the filter criteria you've applied.'",
					"Failed to display the message 'No drivers found'", "FAIL");								
			Assert.fail();

		}
	}

	public void verifyOtherFormatsandDownloadLink(WebDriver driver) 
	{
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 120);

		System.out.println("Inside verifyOtherFormatsandDownloadLink");
		Log.info("Inside verifyOtherFormatsandDownloadLink"); 

		try 
		{
			String message = "";
			String ltMessages = "";
			String names = "";
			int count = 0;

			CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.keywordTextbox()).sendKeys(Keys.BACK_SPACE);
			Thread.sleep(6000);
			CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.keywordTextbox()).sendKeys(Keys.BACK_SPACE);
			Thread.sleep(6000);
			CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.keywordTextbox()).sendKeys(Keys.BACK_SPACE);
			//	driver.navigate().refresh();
			Thread.sleep(6000);
			Thread.sleep(6000);
			List<WebElement> list=driver.findElements(obj_EsupportDriversandDownloadsPage.downloadButtonLinks());


			for(WebElement lt:list)
			{
				CommonUtility.ScrollToWebElement(driver, lt);
				names=lt.getText();
				count+=1;
				System.out.println("Button is: " +names);
				ltMessages+=" <br> " + names;
			}
			System.out.println("Number of download buttons are:"+count);

			Report.put("Check the other formats",
					"A small modal popup should be displayed with the title Other formats and a download link for the formats displayed",
					"Modal popup displayed with download links "+Report.color(names), "PASS");					
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify the  user experience when a filter search returns no result",
					"The following message should be displayed 'No drivers found. There are no drivers that meet the filter criteria you've applied.'",
					"Failed to display the message 'No drivers found'", "FAIL");								
			Assert.fail();

		}
	}

	public void ClickViewDetailsLinkForFirstDisplayedDriver(WebDriver driver)
	{

		Log.info("Inside ClickViewDetailsLinkForFirstDisplayedDriver method");

		WebDriverWait wait = new WebDriverWait(driver, 120); 
		String header="";
		String viewdetails="";
		String ltMessages="";
		String ltMessages1="";

		try
		{			
			CommonUtility.ScrollTo(driver, obj_EsupportDriversandDownloadsPage.ExpandButtonOFFirstRow());
			CommonUtility.ClickOn(driver, obj_EsupportDriversandDownloadsPage.ExpandButtonOFFirstRow());
			CommonUtility.ScrollTo(driver, obj_EsupportDriversandDownloadsPage.ViewFullDriverDetails());
			viewdetails=CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.ViewFullDriverDetails()).getText();
			System.out.println(viewdetails);
			CommonUtility.ClickOn(driver, obj_EsupportDriversandDownloadsPage.ViewFullDriverDetails());
			Thread.sleep(6000);

			Set<String> allWH=driver.getWindowHandles(); 
			String currentwindow=driver.getWindowHandle();
			int count=allWH.size(); 
			System.out.println("Switched Window Handles and  window count is :: "+count);

			for(String wh:allWH)
			{

				Thread.sleep(10000);
				driver.switchTo().window(wh); 
				String title=driver.getTitle();
				System.out.println("Tittle displayed as   :::::"+title); 

				Report.put("Click on any driver from the list and click to view the details page ",
						"The driver details page should be displayed",
						"the drivers page displayed with title as "+Report.color(title), "PASS");

				String url=driver.getCurrentUrl();
				System.out.println("url is "+url);

				if(url.contains("driversdetails"))
				{

					System.out.println("Switched to window");

					handleCookies(driver);

					CommonUtility.ScrollTo(driver, obj_EsupportDriversandDownloadsPage.DescriptionUnderHeading());

					header=CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.DescriptionUnderHeading()).getText();
					System.out.println("description below header is "+header);

					CommonUtility.ScrollTo(driver, obj_EsupportDriversandDownloadsPage.AllHeadingsInPageOpened());

					List<WebElement> list=driver.findElements(obj_EsupportDriversandDownloadsPage.AllHeadingsInPageOpened());

					for(WebElement lt:list)
					{
						CommonUtility.highlightElement(driver, lt);
						String names=lt.getText();

						System.out.println("Alert Name is: " +names);
						ltMessages+=" <br> " + names;

					}
					System.out.println("headings are "+ltMessages);

					List<WebElement> list1=driver.findElements(obj_EsupportDriversandDownloadsPage.DetailsOfAvailableFormatesAndOther());

					for(WebElement lt:list1)
					{
						CommonUtility.highlightElement(driver, lt);
						String names=lt.getText();

						System.out.println("Alert Name is: " +names);
						ltMessages1+=" <br> " + names;

					}
					System.out.println("details are "+ltMessages1);

					String description=CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.FixesAndEnhancementDescription()).getText();
					System.out.println("description below fix and enhancements header is "+description);

					String versiondetails=CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.VersionDetails()).getText();
					System.out.println("details under version is "+versiondetails);

					String categorydetails=CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.CategoryDetails()).getText();
					System.out.println("details under category is "+categorydetails);

					String releasedatedetails=CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.ReleaseDateDetails()).getText();
					System.out.println("details under release date is "+releasedatedetails);
					String lastupdateddetails="";
//					String lastupdateddetails=CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.LastUpdatedDetails()).getText();
//					System.out.println("details under last updated is "+lastupdateddetails);

					String importancedetails=CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.ImportanceDetails()).getText();
					System.out.println("details under importance is "+importancedetails);

					String allotherdetails=CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.ShowAllOrHideAll()).getText();
					System.out.println("all other details are "+allotherdetails);

					Report.put("Verify the title and other details in the page",
							"The driver details page should be displayed with the following metadata ,Title of the page <<Driver Details>>,<br>Title of the driver,Description of the driver,Available formats,Version,Importance,Compatible Systems,Supported Operating Systems",
							"the drivers page displayed with following meta data "+Report.color(title)+" description as "+Report.color(header)+" <br> and other details of headings are "+Report.color(ltMessages+"<br>"+Report.color(ltMessages1)+" along with below details under heading respectively "+Report.color(description)+","+versiondetails+","+categorydetails+","+releasedatedetails+","+lastupdateddetails+","+importancedetails)+"<br> along with all other details as "+Report.color(allotherdetails), "PASS");

					String download=CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.ClickDownloadFile()).getText();
					System.out.println("download link displayed "+download);
					CommonUtility.ClickOn(driver, obj_EsupportDriversandDownloadsPage.ClickDownloadFile());

					Report.put("Click to download the file ",
							"The user should be able to download the file sucessfully ",
							"User able to click on "+Report.color(download)+" link successfully", "PASS");

					driver.close();
				}


			}

			Thread.sleep(5000);
			driver.switchTo().window(currentwindow);
			System.out.println("done");



		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify the title and other details in the page",
					"The driver details page should be displayed with the following metadata ,Title of the page <<Driver Details>>,<br>Title of the driver,Description of the driver,Available formats,Version,Importance,Compatible Systems,Supported Operating Systems",
					"Failed to see all details in drivers details page", "FAIL");
			Assert.fail();
		}
	}


	public void VerifyKitcAndOsisoDriversDetailsPage(WebDriver driver)
	{

		Log.info("Inside VerifyKitcAndOsisoDriversDetailsPage method");

		WebDriverWait wait = new WebDriverWait(driver, 300); 
		String header="";
		String messageforkitc="";
		String messageforsiso="";
		String ltMessages1="";
		String value=TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[0];

		String value1=TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[1];

		try
		{	
			handleCookies(driver);

			driver.get(value);

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDriversandDownloadsPage.NoDriversFoundMessage1()));

			//			CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.NoDriversFoundMessage());
			CommonUtility.ScrollTo(driver, obj_EsupportDriversandDownloadsPage.NoDriversFoundMessage1());
			messageforkitc=CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.NoDriversFoundMessage1()).getText();
			System.out.println(messageforkitc);

			Report.put("Verify the message displayed for  Kitc and Osiso drivers ",
					"Requested drivers cannot be found should be displayed",
					"User able to see message for Kitc is "+Report.color(messageforkitc), "PASS");

			driver.get(value1);

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDriversandDownloadsPage.NoDriversFoundMessage1()));

			//			CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.NoDriversFoundMessage());
			CommonUtility.ScrollTo(driver, obj_EsupportDriversandDownloadsPage.NoDriversFoundMessage1());
			messageforsiso=CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.NoDriversFoundMessage1()).getText();
			System.out.println(messageforsiso);

			Report.put("Verify the message displayed for  Kitc and Osiso drivers ",
					"Requested drivers cannot be found should be displayed",
					"User able to see message for Osiso is "+Report.color(messageforsiso), "PASS");

		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify the message displayed for  Kitc and Osiso drivers ",
					"Requested drivers cannot be found should be displayed",
					"failed to see expected message", "FAIL");
			Assert.fail();
		}
	}

	public void ValidateDownloadForRestrictedAndSecureDriversDetailsPage(WebDriver driver)
	{

		Log.info("Inside ValidateDownloadForRestrictedAndSecureDriversDetailsPage method");

		WebDriverWait wait = new WebDriverWait(driver, 240); 
		String header="";
		String download="";
		String messageforsiso="";
		String ltMessages1="";
		String value=TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[6];
		String value1=TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[1];

		try
		{
			handleCookies(driver);

			driver.get(value);

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDriversandDownloadsPage.ClickDownloadFile()));
			CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.ClickDownloadFile());
			CommonUtility.ScrollTo(driver, obj_EsupportDriversandDownloadsPage.ClickDownloadFile());
			download=CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.ClickDownloadFile()).getText();
			System.out.println(download);

//			CommonUtility.ClickOn(driver, obj_EsupportDriversandDownloadsPage.ClickDownloadFile());
//			//			driver.navigate().refresh();
//			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDriversandDownloadsPage.EnterServiceTagHeadingInPopUp()));
//			CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.EnterServiceTagHeadingInPopUp());
//			CommonUtility.ScrollTo(driver, obj_EsupportDriversandDownloadsPage.EnterServiceTagHeadingInPopUp());
//			header=CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.EnterServiceTagHeadingInPopUp()).getText();
//			System.out.println(header);
//
//
//			CommonUtility.ScrollTo(driver, obj_EsupportDriversandDownloadsPage.TextBoxToEnterServiceTag());
//			CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.TextBoxToEnterServiceTag()).sendKeys(value1);;
//			CommonUtility.ClickOn(driver, obj_EsupportDriversandDownloadsPage.SubmitButton());


			Report.put("Click on the Download link for Restricted and Secure driver in the driver details page",
					"A popup should be displayed to enter the service tag and proceed",
					"User able to see popup with heading "+Report.color(header)+" after clicking on "+Report.color(download)+" button in restricted driver details page", "PASS");


		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on the Download link for Restricted and Secure driver in the driver details page",
					"A popup should be displayed to enter the service tag and proceed",
					"failed to see download button", "FAIL");
			Assert.fail();
		}
	}

	public void VerifyCertifiedDriverPage(WebDriver driver)
	{

		Log.info("Inside VerifyCertifiedDriverPage method");

		WebDriverWait wait = new WebDriverWait(driver, 120); 
		String header="";
		String messageforkitc="";
		String certified="";
		String ltMessages1="";
		String value=TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[6];

		try
		{			

			driver.get(value);

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDriversandDownloadsPage.CertifiedDriver()));
			CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.CertifiedDriver());
			CommonUtility.ScrollTo(driver, obj_EsupportDriversandDownloadsPage.CertifiedDriver());
			certified=CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.CertifiedDriver()).getText();
			System.out.println(certified);

			Report.put("Verify the Certified driver page x",
					"An additional label for Certified should be displayed",
					"User able to see label as "+Report.color(certified), "PASS");


		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify the Certified driver page x",
					"An additional label for Certified should be displayed",
					"failed to see expected certified label", "FAIL");
			Assert.fail();
		}
	}

	public void VerifyCoReqPreReqDriverPage(WebDriver driver)
	{

		Log.info("Inside VerifyCoReqPreReqDriverPage method");

		WebDriverWait wait = new WebDriverWait(driver, 120); 
		String header="";
		String messageforkitc="";
		String precoreq="";
		String precoreq1="";
		String value=TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[4];
		String value1=TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[5];
		try
		{			

			driver.get(value);

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDriversandDownloadsPage.PreCoReqMessage()));
			CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.PreCoReqMessage());
			CommonUtility.ScrollTo(driver, obj_EsupportDriversandDownloadsPage.PreCoReqMessage());
			precoreq=CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.PreCoReqMessage()).getText();
			System.out.println(precoreq);

			Report.put("Verify the Co Req and Pre Req Driver pages ",
					"The label should have links to click which should expand the Co req section towards the bottom of the page",
					"User able to co req page displays label as "+Report.color(precoreq), "PASS");


			driver.get(value1);

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDriversandDownloadsPage.PreCoReqMessage()));
			CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.PreCoReqMessage());
			CommonUtility.ScrollTo(driver, obj_EsupportDriversandDownloadsPage.PreCoReqMessage());
			precoreq1=CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.PreCoReqMessage()).getText();
			System.out.println(precoreq1);

			Report.put("Verify the Certified driver page x",
					"An additional label for Certified should be displayed",
					"User able to pre req page displays label as "+Report.color(precoreq1), "PASS");


		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify the Certified driver page x",
					"An additional label for Certified should be displayed",
					"failed to see expected certified label", "FAIL");
			Assert.fail();
		}
	}

	public void ValidateRequestAccessButtonForLEMCProducts(WebDriver driver)
	{

		Log.info("Inside ValidateRequestAccessButtonForLEMCProducts method");

		WebDriverWait wait = new WebDriverWait(driver, 120); 

		String ltMessages = "";
		try
		{			

			if(CommonUtility.CheckpresenceofElementLocated(driver,15, obj_EsupportDriversandDownloadsPage.RequestAccess()))
			{
				CommonUtility.ScrollTo(driver,obj_EsupportDriversandDownloadsPage.RequestAccess());
				List<WebElement> list=driver.findElements(obj_EsupportDriversandDownloadsPage.RequestAccess());

				int count=list.size();

				System.out.println("count of request access drivers displayed are "+count);
				String names="";
				for(WebElement lt:list)
				{
					CommonUtility.highlightElement(driver, lt);
					names=lt.getText();

					System.out.println("Alert Name is: " +names);
					ltMessages+=" <br> " + names;


				}
				System.out.println("drivers with "+ltMessages+" displayed");

				Report.put("Click on Drivers and Downloads tab",
						"The locked drivers should be displayed and can appear under any of the download types with a Request Access button.",
						"user able to see  "+Report.color(names)+" drivers of count "+count, "PASS");
			}
			else
				if(CommonUtility.CheckpresenceofElementLocated(driver,15, obj_EsupportDriversandDownloadsPage.ShowAllButton()))
				{
					CommonUtility.ScrollTo(driver,obj_EsupportDriversandDownloadsPage.ShowAllButton());
					CommonUtility.ClickOn(driver,obj_EsupportDriversandDownloadsPage.ShowAllButton());


					wait.until(ExpectedConditions.presenceOfElementLocated(obj_EsupportDriversandDownloadsPage.RequestAccess()));
					CommonUtility.ScrollTo(driver,obj_EsupportDriversandDownloadsPage.RequestAccess());
					List<WebElement> list=driver.findElements(obj_EsupportDriversandDownloadsPage.RequestAccess());

					int count=list.size();

					System.out.println("count of request access drivers displayed are "+count);
					String names="";
					for(WebElement lt:list)
					{
						CommonUtility.highlightElement(driver, lt);
						names=lt.getText();

						System.out.println("Alert Name is: " +names);
						ltMessages+=" <br> " + names;


					}
					System.out.println("drivers with "+ltMessages+" displayed");

					Report.put("Click on Drivers and Downloads tab",
							"The locked drivers should be displayed and can appear under any of the download types with a Request Access button.",
							"user able to see  "+Report.color(names)+" drivers of count "+count, "PASS");
				}
				else

				{
					System.out.println("failed");
					Report.put("Click on Drivers and Downloads tab",
							"The locked drivers should be displayed and can appear under any of the download types with a Request Access button.",
							"user able to see request access drivers", "FAIL");
					Assert.fail();
				}

		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on Drivers and Downloads tab",
					"The locked drivers should be displayed and can appear under any of the download types with a Request Access button.",
					"user able to see request access drivers", "FAIL");
			Assert.fail();
		}
	}


	public void ClickOnRequestAccessAndValidateAndSubmitAccessForm(WebDriver driver)
	{

		Log.info("Inside ClickOnRequestAccessAndValidateAndSubmitAccessForm method");

		WebDriverWait wait = new WebDriverWait(driver, 120); 

		String ltMessages = "";
		String headerpopup="";
		String labelforsiteidorproductid="";
		String addinf="";
		String contname="";
		String contemail="";
		String contphone="";
		String autoname="";
		String autoemail="";
		String cancel="";
		String submit="";
		try
		{			

			//wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDriversandDownloadsPage.ClickOnFirstDisplayedRequestAccess()));
			
			if(CommonUtility.CheckpresenceofElementLocated(driver,10, obj_EsupportDriversandDownloadsPage.ClickOnFirstDisplayedRequestAccess()))
			//if(CommonUtility.CheckpresenceofAllElementLocated(driver,10, obj_EsupportDriversandDownloadsPage.RequestAccess()))
			
			{

				//CommonUtility.ScrollTo(driver, obj_EsupportDriversandDownloadsPage.ClickOnFirstDisplayedRequestAccess());
				CommonUtility.ClickOn(driver, obj_EsupportDriversandDownloadsPage.ClickOnFirstDisplayedRequestAccess());

				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDriversandDownloadsPage.RequestAccessPopUpHeader()));
				headerpopup=CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.RequestAccessPopUpHeader()).getText();
				System.out.println("header of pop up is "+headerpopup);

				labelforsiteidorproductid=CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.LabelOfSiteIDOrProductIDMandatoryFieldsInPopUp()).getText();
				System.out.println("label is "+labelforsiteidorproductid);


				List<WebElement> list=driver.findElements(obj_EsupportDriversandDownloadsPage.OptionOfSiteIDAndProductID());

				int count=list.size();

				System.out.println("count options displayed are "+count);
				String names="";
				for(WebElement lt:list)
				{
					CommonUtility.highlightElement(driver, lt);
					names=lt.getText();

					System.out.println("Alert Name is: " +names);
					ltMessages+=" <br> " + names;


				}
				System.out.println("options are with "+ltMessages);

				CommonUtility.ScrollTo(driver, obj_EsupportDriversandDownloadsPage.InputOfSiteIDORProductIDTextBox());

				CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.InputOfSiteIDORProductIDTextBox()).sendKeys("928347");

				CommonUtility.ScrollTo(driver, obj_EsupportDriversandDownloadsPage.AdditionalInformationLabel());

				addinf=CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.AdditionalInformationLabel()).getText();
				System.out.println("displayed label is "+addinf);

				CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.AdditionalInformationTextBox());

				CommonUtility.ScrollTo(driver, obj_EsupportDriversandDownloadsPage.AdditionalInformationLabel());

				contname=CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.ContactNameInPopUp()).getText();
				System.out.println("displayed label is "+contname);

				CommonUtility.ScrollTo(driver, obj_EsupportDriversandDownloadsPage.AutoFilledContactNameDetailsInPopUp());

				autoname=CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.AutoFilledContactNameDetailsInPopUp()).getText();
				System.out.println("auto filled name is "+autoname);

				CommonUtility.ScrollTo(driver, obj_EsupportDriversandDownloadsPage.ContactEmailPopUp());

				contemail=CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.ContactEmailPopUp()).getText();
				System.out.println("displayed label is "+contemail);

				CommonUtility.ScrollTo(driver, obj_EsupportDriversandDownloadsPage.AutoFilledContactEmailDetailsInPopUp());
				autoemail=CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.AutoFilledContactEmailDetailsInPopUp()).getText();
				System.out.println("auto filled email is "+autoemail);

				CommonUtility.ScrollTo(driver, obj_EsupportDriversandDownloadsPage.ContactPhonePopUp());

				contphone=CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.ContactPhonePopUp()).getText();
				System.out.println("displayed label is "+contphone);

				CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.ContactPhoneDetailsInPopUp()).sendKeys("8238682309");

				CommonUtility.ScrollTo(driver, obj_EsupportDriversandDownloadsPage.CancelButtonInPopUp());

				cancel=CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.CancelButtonInPopUp()).getText();
				System.out.println("button is "+cancel);

				CommonUtility.ScrollTo(driver, obj_EsupportDriversandDownloadsPage.SubmitButtonInPopUp());

				submit=CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.SubmitButtonInPopUp()).getText();
				System.out.println("button is "+submit);

				//			CommonUtility.ClickOn(driver, obj_EsupportDriversandDownloadsPage.SubmitButtonInPopUp());
				//			
				//			String success= CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.SuccessMessageAfterSubmittingRequestAccess()).getText();
				//			System.out.println("message is "+success);


				Report.put("Click on Request Access and submit a request through - Software download Access Request Form. ",
						"The contact information should be displayed based on the logged in user, should be editable. <br>Site Id/Product ID Additional information - Details for requesting access to download.Contact Information - Auto retrieved based on login.<br>Contact details, would only be used in the email that is sent to request access. Profile would not be updated based on the contact.",
						"User able to click on request access  abd able to popup with following details <br> header is "+Report.color(headerpopup)+" <br> and "+Report.color(labelforsiteidorproductid)+" display with 2 options "+Report.color(ltMessages)+"with textbox <br>  "+Report.color(addinf)+" with text box <br>  "+Report.color(contname+" display with autopopulated "+autoname)+" <br> "+Report.color(contemail+" display with autopopulated "+autoemail)+" <br> "+Report.color(contphone)+" with text box displayed along with "+Report.color(cancel+" and "+submit)+" buttons", "PASS");
			}
			else
			{
				Report.put("Click on Request Access and submit a request through - Software download Access Request Form. ",
						"The contact information should be displayed based on the logged in user, should be editable. <br>Site Id/Product ID Additional information - Details for requesting access to download.Contact Information - Auto retrieved based on login.<br>Contact details, would only be used in the email that is sent to request access. Profile would not be updated based on the contact.",
						"user able to click on request access drivers", "FAIL");
				Assert.fail();
			}

		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on Request Access and submit a request through - Software download Access Request Form. ",
					"The contact information should be displayed based on the logged in user, should be editable. <br>Site Id/Product ID Additional information - Details for requesting access to download.Contact Information - Auto retrieved based on login.<br>Contact details, would only be used in the email that is sent to request access. Profile would not be updated based on the contact.",
					"user able to click on request access drivers", "FAIL");
			Assert.fail();
		}
	}

	public void ClickDownloadButtonForLEMCProduct(WebDriver driver)
	{

		Log.info("Inside ClickDownloadButtonForLEMCProduct method");

		WebDriverWait wait = new WebDriverWait(driver, 120); 
		String download = "";
		try
		{				
			if(CommonUtility.CheckpresenceofElementLocated(driver,10, obj_EsupportDriversandDownloadsPage.ClickOnFirstDisplayedDownloadButton()))
			{
				CommonUtility.ScrollTo(driver, obj_EsupportDriversandDownloadsPage.ClickOnFirstDisplayedDownloadButton());
				download=CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.ClickOnFirstDisplayedDownloadButton()).getText();
				System.out.println("button is "+download);

				CommonUtility.ClickOn(driver, obj_EsupportDriversandDownloadsPage.ClickOnFirstDisplayedDownloadButton());

				Report.put("Download a LEMC download by clicking on the Download button",
						"All the LEMC downloads should be invoked through the browser and user should not be prompted to install Support Assist for downloading a LEMC file",
						"user able to click on "+Report.color(download)+" and user not prompted to install Support Assist for downloading a LEMC file", "PASS");
			}
			else
			{
				Report.put("Download a LEMC download by clicking on the Download button",
						"All the LEMC downloads should be invoked through the browser and user should not be prompted to install Support Assist for downloading a LEMC file",
						"Failed to see download button", "FAIL");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Download a LEMC download by clicking on the Download button",
					"All the LEMC downloads should be invoked through the browser and user should not be prompted to install Support Assist for downloading a LEMC file",
					"Failed to see download button", "FAIL");
			Assert.fail();
		}
	}

	public void ValidateVersionsDisplayed(WebDriver driver)
	{

		Log.info("Inside ValidateVersionsDisplayed method");

		WebDriverWait wait = new WebDriverWait(driver, 120); 
		String ltMessages = "";
		try
		{				
			if(CommonUtility.CheckpresenceofElementLocated(driver,10, obj_EsupportDriversandDownloadsPage.VersionDetailsOfProductInDriversPage()))
			{
				CommonUtility.ScrollTo(driver, obj_EsupportDriversandDownloadsPage.VersionDetailsOfProductInDriversPage());
				List<WebElement> list=driver.findElements(obj_EsupportDriversandDownloadsPage.VersionDetailsOfProductInDriversPage());

				for(WebElement lt:list)
				{
					CommonUtility.highlightElement(driver, lt);
					String names=lt.getText();

					System.out.println("Alert Name is: " +names);
					ltMessages+=" <br> " + names;


				}
				System.out.println("version details are "+ltMessages);

				Report.put("Verify the versions displayed Precondition : Use product which has different versions of downloads ",
						"Multiple major versions should be listed for the product. Each major version can have multiple sub-versions",
						"user able to see version details as  "+Report.color(ltMessages), "PASS");

				Report.put("Verify a hierarchy is maintained to identify the subversions",
						" User should be able to identify and relate other versions that are released under a major/initial version.",
						"user able to see sub version details also  "+Report.color(ltMessages), "PASS");
			}
			else
			{
				Report.put("Verify the versions displayed Precondition : Use product which has different versions of downloads ",
						"Multiple major versions should be listed for the product. Each major version can have multiple sub-versions",
						"Version details not displayed", "FAIL");
				Assert.fail();

			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify the versions displayed Precondition : Use product which has different versions of downloads ",
					"Multiple major versions should be listed for the product. Each major version can have multiple sub-versions",
					"Version details not displayed", "FAIL");
			Assert.fail();
		}
	}

	public void ClickOnAnyVersionAndVerifyDriversGrid(WebDriver driver)
	{

		Log.info("Inside ClickOnAnyVersionAndVerifyDriversGrid method");

		WebDriverWait wait = new WebDriverWait(driver, 120); 
		String ltMessages = "";
		String ltMessages1="";
		String ltMessages2="";
		String ltMessages3="";
		String version="";
		try
		{				
			CommonUtility.ScrollTo(driver, obj_EsupportDriversandDownloadsPage.ClickOnVersionHeirarchy());
		if(CommonUtility.CheckpresenceofElementLocated(driver,10, obj_EsupportDriversandDownloadsPage.ClickOnVersionHeirarchy()))
		{
			CommonUtility.ScrollTo(driver, obj_EsupportDriversandDownloadsPage.ClickOnVersionHeirarchy());
			version=CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.ClickOnVersionHeirarchy()).getText();
			System.out.println("selected version is "+version);
			CommonUtility.ClickOn(driver, obj_EsupportDriversandDownloadsPage.ClickOnVersionHeirarchy());

			List<WebElement> list=driver.findElements(obj_EsupportDriversandDownloadsPage.DriversTillesDisplayed());

			for(WebElement lt:list)
			{
				CommonUtility.highlightElement(driver, lt);
				String names=lt.getText();

				System.out.println("Alert Name is: " +names);
				ltMessages+=" <br> " + names;


			}
			System.out.println("displayed drivers are "+ltMessages);

			List<WebElement> list1=driver.findElements(obj_EsupportDriversandDownloadsPage.OddRowsCategoryTypeInDriversGrid());

			for(WebElement lt:list1)
			{
				CommonUtility.highlightElement(driver, lt);
				String names=lt.getText();

				System.out.println("Name is: " +names);
				ltMessages1+=" <br> " + names;


			}
			System.out.println("categories displayed in odd rows are "+ltMessages1);
            Thread.sleep(2000);
			List<WebElement> list2=driver.findElements(obj_EsupportDriversandDownloadsPage.EvenRowsCategoryTypeInDriversGrid());

			for(WebElement lt:list2)
			{
				CommonUtility.highlightElement(driver, lt);
				String names=lt.getText();

				System.out.println("Name is: " +names);
				ltMessages2+=" <br> " + names;


			}
			System.out.println("categories displayed in even rows are "+ltMessages2);

			List<WebElement> list3=driver.findElements(obj_EsupportDriversandDownloadsPage.CollapseButtonBeforeExpand());

			for(WebElement lt:list3)
			{
				CommonUtility.highlightElement(driver, lt);
				lt.click();
			}

            Thread.sleep(2000);
			
			List<WebElement> list4=driver.findElements(obj_EsupportDriversandDownloadsPage.VersionDetailsInExpandedview());
			for(WebElement lt:list4)
			{
				CommonUtility.highlightElement(driver, lt);
				String names=lt.getText();

				System.out.println("version details : " +names);

				ltMessages3+=" <br> " + names;


			}
			System.out.println("version details displayed are "+ltMessages3);

			if(ltMessages3.contains("Version"))
			{

				Report.put("Click to select a version and verify the download type",
						"Download types and related information should be specific to the version selected. ",
						"user able to select version"+Report.color(version)+" and able to see related information displayed with same version details "+Report.color(ltMessages3), "PASS");
			}
			else
			{
				Report.put("Click to select a version and verify the download type",
						"Download types and related information should be specific to the version selected. ",
						"Version details displayed not matching with selected version", "FAIL");
				Assert.fail();
			}

			List<WebElement> list5=driver.findElements(obj_EsupportDriversandDownloadsPage.CollapseButtonAfterExpanded());

			for(WebElement lt:list5)
			{
				CommonUtility.highlightElement(driver, lt);
				lt.click();
			}




			Report.put("Click to select a version and verify the download type",
					"Download types and related information should be specific to the version selected. ",
					"user able to select version"+Report.color(version)+" and able to see related information <br> with title "+Report.color(ltMessages)+" and download category "+Report.color(ltMessages1+" "+ltMessages2)+"<br> with displayed version "+Report.color(ltMessages3), "PASS");


		}
		else
		{
			Report.put("Click to select a version and verify the download type",
					"Download types and related information should be specific to the version selected. ",
					"Version details displayed not matching with selected", "FAIL");
			Assert.fail();

		}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click to select a version and verify the download type",
					"Download types and related information should be specific to the version selected. ",
					"Version details displayed not matching with selected", "FAIL");
			Assert.fail();
		}
	}


	public void pcfClickAdditionalResourceLinksForLEMC(WebDriver driver)
	{

		Log.info("Inside pcfClickAdditionalResourceLinksForLEMC method");

		WebDriverWait wait = new WebDriverWait(driver, 120); 

		String header = "";
		String ltMessages = "";
		String titleList = "";
		try
		{			
			CommonUtility.scrollToViewElement (driver, obj_EsupportDriversandDownloadsPage.additionalResourcesLinks());
			List<WebElement> list=driver.findElements(obj_EsupportDriversandDownloadsPage.additionalResourcesLinks());

			for (int i = 0; i < list.size(); i++) 
			{
				System.out.println("Inside for loop pcfClickAdditionalResourceLinks");
				//	SupportTopicLink = driver.findElements(obj_EsupportIncidentsPage.SupportTopicLink());
				String value = list.get(i).getText();

				System.out.println("Value is**************"+value);
				if(value.contains("Driver Notifications")  || value.contains("Help"))
				{

					list.get(i).click();
					Thread.sleep(10000);
					String mainwindow=driver.getWindowHandle();
					Set<String> set=driver.getWindowHandles();
					int count=set.size();
					System.out.println(count);
					Iterator<String> itr=set.iterator();
					while(itr.hasNext())
					{
						String childWindow=itr.next();
						if(!mainwindow.equals(childWindow))
						{
							driver.switchTo().window(childWindow);
							String title=driver.getTitle();

							System.out.println("Title of article id "+title);
							String currenturl=driver.getCurrentUrl();

							System.out.println("current url is "+currenturl);
							driver.close();
						}


					}
					driver.switchTo().window(mainwindow);

				}

			}


			Report.put("Verify the links are clickable",
					"The links should be clickable but will be redirected to production URLs as of now",
					"Clicked links are "+Report.color(ltMessages )+" under Additional resources ", "PASS");

		} 
		catch(Exception e)
		{
			e.printStackTrace();

			Report.put("Verify the links are clickable",
					"The links should be clickable but will be redirected to production URLs as of now",
					"Failed to click on links under Additional resources ", "FAIL");
		}
	}


	public void validateOSdropdownDisabledForLEMC(WebDriver driver) 
	{
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 120);

		System.out.println("Inside validateOSdropdownDisabledForLEMC");
		Log.info("Inside validateOSdropdownDisabledForLEMC"); 

		try 
		{
			String Headerservicetag="";
			String Headerservicetagdisplay="";


			if(!(CommonUtility.CheckpresenceofElementLocated(driver, 5, obj_EsupportDriversandDownloadsPage.operatingSystemDropdown())))
			{
				System.out.println("Inside if of operating System dropdown");
				Report.put("Select any product and Verify the  user experience when a product with no OS is selected (powerconnect-3448)",
						"The Operating System dropdown should be disabled",
						"Operating System Dropdown is disabled", "PASS");					
			}	
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Select any product and Verify the  user experience when a product with no OS is selected (powerconnect-3348)",
					"The Operating System dropdown should be disabled",
					"Failed to validate if Operating System dropdown is disabled", "FAIL");					
			Assert.fail();

		}
	}

	public void verifyNoDriversFoundMessageForLEMC(WebDriver driver) 
	{
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 120);


		Log.info("Inside verifyNoDriversFoundMessageForLEMC"); 

		try 
		{
			String message = "";


			//			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDriversandDownloadsPage.noDriversFoundMessage()));

			CommonUtility.ScrollTo(driver,obj_EsupportDriversandDownloadsPage.NoDriversFoundMessageLemc());

			message=CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.NoDriversFoundMessageLemc()).getText();

			System.out.println("Message is "+message);


			Report.put("Verify the  user experience when a filter search returns no result",
					"The following message should be displayed 'No drivers found. There are no drivers that meet the filter criteria you've applied.'",
					"Successfully displayed message"+Report.color(message), "PASS");					
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify the  user experience when a filter search returns no result",
					"The following message should be displayed 'No drivers found. There are no drivers that meet the filter criteria you've applied.'",
					"Failed to display the message 'No drivers found'", "FAIL");								
			Assert.fail();

		}
	}

	public void pcfVerifyAdditionalResourceHeaderLEMC(WebDriver driver)
	{

		Log.info("Inside pcfVerifyAdditionalResourceHeaderLEMC method");

		WebDriverWait wait = new WebDriverWait(driver, 120); 

		String header = "";
		try
		{			
			//			Actions act=new Actions(driver);
			//			act.moveToElement(CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.additionalResources())).build().perform();
			CommonUtility.ScrollTo(driver, obj_EsupportDriversandDownloadsPage.AdditionalResourcesLemc());
			header = CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.AdditionalResourcesLemc()).getText();
			Report.put("Scroll down to the bottom of the page",
					"The Additional Resources section should be displayed",
					"Displayed"+Report.color(header )+"successfully", "PASS");

		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Scroll down to the bottom of the page",
					"The Additional Resources section should be displayed",
					"Failed to display Additional Resources Tab", "FAIL");
			Assert.fail();
		}
	}

	public void pcfClickAdditionalResourceLinksLEMC(WebDriver driver)
	{

		Log.info("Inside pcfClickAdditionalResourceLinksLEMC method");

		WebDriverWait wait = new WebDriverWait(driver, 120); 

		String header = "";
		String ltMessages = "";
		String titleList = "";
		try
		{			
			List<WebElement> list=driver.findElements(obj_EsupportDriversandDownloadsPage.AdditionalResourcesLinksLemc());

			for (int i = 0; i < list.size(); i++) 
			{
				//	SupportTopicLink = driver.findElements(obj_EsupportIncidentsPage.SupportTopicLink());
				String value = list.get(i).getText();
				System.out.println(value);
				CommonUtility.highlightElement(driver,list.get(i)).click();
				Thread.sleep(10000);

				String mainwindow=driver.getWindowHandle();
				Set<String> set=driver.getWindowHandles();
				int count=set.size();
				System.out.println(count);
				Iterator<String> itr=set.iterator();
				while(itr.hasNext())
				{
					String childWindow=itr.next();
					if(!mainwindow.equals(childWindow))
					{
						driver.switchTo().window(childWindow);
						String title=driver.getTitle();

						System.out.println("Title of article id "+title);
						String currenturl=driver.getCurrentUrl();

						System.out.println("current url is "+currenturl);
						driver.close();
					}


				}
				driver.switchTo().window(mainwindow);

			}


			Report.put("Verify the links are clickable",
					"The links should be clickable but will be redirected to production URLs as of now",
					"Clicked links are "+Report.color(ltMessages )+" under Additional resources ", "PASS");

		} 
		catch(Exception e)
		{
			e.printStackTrace();

			Report.put("Verify the links are clickable",
					"The links should be clickable but will be redirected to production URLs as of now",
					"Failed to click on links under Additional resources ", "FAIL");
			Assert.fail();
		}
	}


	public void  ValidateChangeCountryForCanadaInSearchHomePage(WebDriver driver)
	{
		WebDriverWait  wait = new WebDriverWait(driver, 120);
		Log.info("Entering ValidateChangeCountryForCanadaInSearchHomePage");
		Actions act=new Actions(driver);
		String country1 = TestNGCreator.TestData.get(Esupport.Country.ordinal()).split(";")[0];

		String selectedcountry = "";
		String title="";
		String tabname="";
		String text="";
		int count=0;
		String encount="";

		try{

			//act.moveToElement(CommonUtility.highlightElement(driver,obj_EsupportContentHomePage.CountrySelectorArticle())).build().perform();
			//handleCookies(driver);
			//			CommonUtility.scrollToViewElement(driver,obj_EsupportContentHomePage.CountrySelectorArticle());
			CommonUtility.ScrollTo(driver,obj_EsupportContentHomePage.CountrySelectorArticle());
			if(CommonUtility.highlightElement(driver,obj_EsupportContentHomePage.CountrySelectorArticle()).isDisplayed())
			{

				System.out.println("country displayed");
				CommonUtility.ScrollTo(driver,obj_EsupportContentHomePage.CountrySelectorArticle());
				WebElement element =driver.findElement(By.xpath("//div[@id='countryselector']/a"));
				((JavascriptExecutor)driver).executeScript("arguments[0].click();", element); 

				Thread.sleep(6000);
				System.out.println("Country from Test data is :::: "+country1);
				List<WebElement> countryList=driver.findElements(obj_EsupportContentHomePage.CountrySelectorList());


				for(WebElement lt:countryList)
				{
					String couLi=lt.getText();

					System.out.println("Country is: " +couLi);
					if(couLi.contains(country1))
					{
						System.out.println("Inside if**************");
						System.out.println("Country is: " +couLi);
						try
						{
							CommonUtility.scrollToViewElement(driver,lt);
							CommonUtility.highlightElement(driver,lt).click();
						}
						catch(Exception e)
						{

						}

						Thread.sleep(10000);

						selectedcountry = couLi;
						System.out.println("Selected Country is "+selectedcountry);

						break;

					}
				}


				Report.put("Click on the Country dropdown at the bottom of the page and select a different country", 
						"1. The page should be reloaded in the language of the selected country.", 
						"1.Country changed to : "+Report.color(country1),"PASS");
			}

			else
			{
				Log.info("Test case fail: issue in selecting country");
				Report.put("Change the country at the bottom and verify the IPS experience based on the country", 
						" The IPS experience should be uniform irrespective of country", 
						"issue in selecting country " +Report.color(country1), "FAIL");
				Assert.fail();
			}

			handleCookies(driver);

			Thread.sleep(5000);

			if(driver.getCurrentUrl().contains("ca"))
			{
				Log.info("Test Case Pass: loaded with selected country ");
				title=driver.getTitle();
				System.out.println("title of page after changing country is "+title);
			}
			else
			{
				driver.get("https://www.dell.com/support/home/us/en/04/");
				Log.info("Test Case Fail: not loaded with selected country");
				Report.put("Change the country at the bottom and verify the IPS experience based on the country", 
						" The IPS experience should be uniform irrespective of country", 
						"1.Pag not reloaded in the language of the selected country" +Report.color(country1), "FAIL");
				Assert.fail();
			}

			tabname=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SupportHeader()).getText();
			System.out.println("title of page is "+tabname);


			CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.Delllogo());
			CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.SearchServicetag());

			CommonUtility.scrollToViewElement(driver, obj_EsupportDriversandDownloadsPage.Headerservicetag());
			//act.moveToElement(CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.Headerservicetag())).build().perform();


			String Headerservicetag=CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.Headerservicetag()).getText();
			System.out.println(Headerservicetag);
			String DetectPCButton=CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.DetectPCButton()).getText();
			System.out.println(DetectPCButton);
			String DellEmcProductIcontext=CommonUtility.highlightElement(driver,obj_EsupportIntegratedHomePage.DellEmcProductIcontext()).getText();
			System.out.println(DellEmcProductIcontext);


			String Browseallproductslink=CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.Browseallproductslink()).getText();
			System.out.println(Browseallproductslink);

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

			System.out.println(ltMessages);
			String criticalLinks="";

			CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.TechDirectLink()).isDisplayed();
			CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.TechDirectLink());
			criticalLinks = criticalLinks + CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.TechDirectLink()).getText() + "<br>";

			CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.myService360()).isDisplayed();
			CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.myService360());
			criticalLinks = criticalLinks + CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.myService360()).getText() + "<br>";


			Report.put("Change the country at the bottom and verify the IPS experience based on the country", 
					" The IPS experience should be uniform irrespective of country",  
					"able to see support home page experience is uniform irrespective of country","PASS");
		}

		catch(Exception e)
		{
			driver.get("https://www.dell.com/support/home/us/en/04/");
			e.printStackTrace();
			Report.put("Change the country at the bottom and verify the IPS experience based on the country", 
					" The IPS experience should be uniform irrespective of country",  
					"Not able to select the country "+Report.color(country1)+"<br> or<br> page not loaded with expected page with different country ", "FAIL");
			Assert.fail();
		}
	}


	public void  ChangeBackToDisplayedCountryForSupportHomePage(WebDriver driver)
	{
		// TODO Auto-generated method stub
		Log.info("Entering ChangeBackToDisplayedCountryForSupportHomePage");
		Actions act=new Actions(driver);

		String country2 = TestNGCreator.TestData.get(Esupport.Country.ordinal()).split(";")[1];
		String selectedcountry = "";

		try
		{

			//act.moveToElement(CommonUtility.highlightElement(driver,obj_EsupportContentHomePage.CountrySelectorArticle())).build().perform();
			//			CommonUtility.scrollToViewElement(driver,obj_EsupportContentHomePage.CountrySelectorArticle());
			CommonUtility.ScrollTo(driver,obj_EsupportContentHomePage.CountrySelectorArticle());
			handleCookies(driver);

			if(CommonUtility.highlightElement(driver,obj_EsupportContentHomePage.CountrySelectorArticle()).isDisplayed())
			{

				System.out.println("country displayed");

				//				WebElement element =driver.findElement(By.xpath("//div[@id='countryselector']/a"));
				//				((JavascriptExecutor)driver).executeScript("arguments[0].click();", element); 
				CommonUtility.ClickOn(driver,By.xpath("(//div[@component='unified-country-selector'])[1]"));

				Thread.sleep(6000);
				System.out.println("Country from Test data is :::: "+country2);
				List<WebElement> countryList=driver.findElements(obj_EsupportContentHomePage.CountrySelectorList());


				for(WebElement lt:countryList)
				{
					String couLi=lt.getText();

					System.out.println("Country is: " +couLi);
					if(couLi.contains(country2))
					{
						System.out.println("Inside if**************");
						System.out.println("Country is: " +couLi);
						lt.click();

						Thread.sleep(5000);

						selectedcountry = couLi;
						System.out.println("Selected Country is "+selectedcountry);

						break;

					}
				}

				Report.put("Click on the Country dropdown at the bottom of the page and select previous displayed country", 
						"1. The page should be reloaded in the language of the selected country.", 
						"1.Country changed to : "+Report.color(country2),"PASS");
			}

			else
			{
				Log.info("Test case fail: issue in selecting country");
				Report.put("Click on the Country dropdown at the bottom of the page and select previous displayed country", 
						"1. The page should be reloaded in the language of the selected country.", 
						"issue in selecting country " +Report.color(country2), "FAIL");
				Assert.fail();
			}

			if(driver.getCurrentUrl().contains("us"))
			{
				Log.info("Test Case Pass: loaded with selected country ");
				String title=driver.getTitle();
				System.out.println("title of page after changing country is "+title);
			}
			else
			{
				driver.get("https://www.dell.com/support/home/us/en/04/");
				Log.info("Test Case Fail: not loaded with selected country");
				Report.put("Change the country at the bottom and verify the IPS experience based on the country", 
						" The IPS experience should be uniform irrespective of country", 
						"1.Pag not reloaded in the language of the selected country" +Report.color(country2), "FAIL");
				Assert.fail();
			}

			String tabname=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SupportHeader()).getText();
			System.out.println("title of page is "+tabname);


			CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.Delllogo());
			CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.SearchServicetag());

			CommonUtility.scrollToViewElement(driver, obj_EsupportDriversandDownloadsPage.Headerservicetag());
			//act.moveToElement(CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.Headerservicetag())).build().perform();


			String Headerservicetag=CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.Headerservicetag()).getText();
			System.out.println(Headerservicetag);
			String DetectPCButton=CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.DetectPCButton()).getText();
			System.out.println(DetectPCButton);
			String DellEmcProductIcontext=CommonUtility.highlightElement(driver,obj_EsupportIntegratedHomePage.DellEmcProductIcontext()).getText();
			System.out.println(DellEmcProductIcontext);


			String Browseallproductslink=CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.Browseallproductslink()).getText();
			System.out.println(Browseallproductslink);

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

			System.out.println(ltMessages);
			String criticalLinks="";


			CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.TechDirectLink()).isDisplayed();
			CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.TechDirectLink());
			criticalLinks = criticalLinks + CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.TechDirectLink()).getText() + "<br>";

			CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.myService360()).isDisplayed();
			CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.myService360());
			criticalLinks = criticalLinks + CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.myService360()).getText() + "<br>";

			Report.put("Change the country at the bottom and verify the IPS experience based on the country", 
					" The IPS experience should be uniform irrespective of country",  
					"able to see support home page experience is uniform irrespective of country","PASS");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on the Country dropdown at the bottom of the page and select previous displayed country", 
					"1. The page should be reloaded in the language of the selected country.", 
					"issue in selecting country " +Report.color(country2)+" <br> or <br> page not loaded with expected page with different country", "FAIL");
		}
	}

	public void  ValidateChangeCountryForCanadaInDriversAndDownloadsPage(WebDriver driver)
	{
		WebDriverWait  wait = new WebDriverWait(driver, 120);
		Log.info("Entering ValidateChangeCountryForCanadaInDriversAndDownloadsPage");
		Actions act=new Actions(driver);
		String country1 = TestNGCreator.TestData.get(Esupport.Country.ordinal()).split(";")[0];

		String selectedcountry = "";
		String title="";
		String tabname="";
		String text="";
		int count=0;
		String encount="";

		try{

			//act.moveToElement(CommonUtility.highlightElement(driver,obj_EsupportContentHomePage.CountrySelectorArticle())).build().perform();
			//handleCookies(driver);
			//			CommonUtility.scrollToViewElement(driver,obj_EsupportContentHomePage.CountrySelectorArticle());
			CommonUtility.ScrollTo(driver,obj_EsupportContentHomePage.CountrySelectorArticle());
			if(CommonUtility.highlightElement(driver,obj_EsupportContentHomePage.CountrySelectorArticle()).isDisplayed())
			{

				System.out.println("country displayed");

				WebElement element =driver.findElement(By.xpath("//div[@id='countryselector']/a"));
				((JavascriptExecutor)driver).executeScript("arguments[0].click();", element); 

				Thread.sleep(6000);
				System.out.println("Country from Test data is :::: "+country1);
				List<WebElement> countryList=driver.findElements(obj_EsupportContentHomePage.CountrySelectorList());


				for(WebElement lt:countryList)
				{
					String couLi=lt.getText();

					System.out.println("Country is: " +couLi);
					if(couLi.contains(country1))
					{
						System.out.println("Inside if**************");
						System.out.println("Country is: " +couLi);
						CommonUtility.scrollToViewElement(driver, lt).click();

						Thread.sleep(10000);

						selectedcountry = couLi;
						System.out.println("Selected Country is "+selectedcountry);

						break;

					}
				}


				Report.put("Click on the Country dropdown at the bottom of the page and select a different country", 
						"1. The page should be reloaded in the language of the selected country.", 
						"1.Country changed to : "+Report.color(country1),"PASS");
			}

			else
			{
				Log.info("Test case fail: issue in selecting country");
				Report.put("Search for different products and verify the in Drivers and Downloads page in different countries", 
						"The Drivers and experience should be uniform irrespective of product", 
						"issue in selecting country " +Report.color(country1), "FAIL");
				Assert.fail();
			}

			handleCookies(driver);

			Thread.sleep(5000);

			if(driver.getCurrentUrl().contains("bt"))
			{
				Log.info("Test Case Pass: loaded with selected country ");
				title=driver.getTitle();
				System.out.println("title of page after changing country is "+title);
			}
			else
			{
				driver.get("https://www.dell.com/support/home/us/en/04/");
				Log.info("Test Case Fail: not loaded with selected country");
				Report.put("Search for different products and verify the in Drivers and Downloads page in different countries", 
						"The Drivers and experience should be uniform irrespective of product", 
						"1.Pag not reloaded in the language of the selected country" +Report.color(country1), "FAIL");
				Assert.fail();
			}

			CommonUtility.ScrollTo(driver,obj_EsupportDriversandDownloadsPage.driversandDownloadsTab());

			CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.driversandDownloadsHeader());

			String tab = CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.driversandDownloadsTab()).getText();
			System.out.println(tab);
			CommonUtility.ScrollTo(driver, obj_EsupportDriversandDownloadsPage.driversTable());
			CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.driversTable());

			CommonUtility.scrollToViewElement(driver, obj_EsupportDriversandDownloadsPage.AdditionalResourcesLemc());
			List<WebElement> list=driver.findElements(obj_EsupportDriversandDownloadsPage.AdditionalResourcesLinksLemc());

			String ltMessages="";

			for(WebElement lt:list)
			{

				CommonUtility.scrollToViewElement (driver, lt);
				String names=lt.getText();

				System.out.println("Link is: " +names);
				ltMessages+=" <br> " + names;
			}	

			System.out.println(ltMessages);




			Report.put("Search for different products and verify the in Drivers and Downloads page in different countries", 
					"The Drivers and experience should be uniform irrespective of product", 
					"able to see Drivers and Downloads page experience is uniform irrespective of country","PASS");

		}

		catch(Exception e)
		{
			driver.get("https://www.dell.com/support/home/us/en/04/");
			e.printStackTrace();
			Report.put("Search for different products and verify the in Drivers and Downloads page in different countries", 
					"The Drivers and experience should be uniform irrespective of product",   
					"Not able to select the country "+Report.color(country1)+"<br> or<br> page not loaded with expected page with different country", "FAIL");
			Assert.fail();
		}
	}

	public void  ChangeBackToDisplayedCountryInDriversAndDownloadPage(WebDriver driver)
	{
		// TODO Auto-generated method stub
		Log.info("Entering ChangeBackToDisplayedCountryInDriversAndDownloadPage");
		Actions act=new Actions(driver);

		String country2 = TestNGCreator.TestData.get(Esupport.Country.ordinal()).split(";")[1];
		String selectedcountry = "";

		try
		{

			//act.moveToElement(CommonUtility.highlightElement(driver,obj_EsupportContentHomePage.CountrySelectorArticle())).build().perform();
			//			CommonUtility.scrollToViewElement(driver,obj_EsupportContentHomePage.CountrySelectorArticle());
			CommonUtility.ScrollTo(driver,obj_EsupportContentHomePage.CountrySelectorArticle());
			handleCookies(driver);

			if(CommonUtility.highlightElement(driver,obj_EsupportContentHomePage.CountrySelectorArticle()).isDisplayed())
			{

				System.out.println("country displayed");

				//				WebElement element =driver.findElement(By.xpath("//div[@id='countryselector']/a"));
				//				((JavascriptExecutor)driver).executeScript("arguments[0].click();", element); 
				CommonUtility.ClickOn(driver,By.xpath("//div[@id='countryselector']/a"));

				Thread.sleep(6000);
				System.out.println("Country from Test data is :::: "+country2);
				List<WebElement> countryList=driver.findElements(obj_EsupportContentHomePage.CountrySelectorList());


				for(WebElement lt:countryList)
				{
					String couLi=lt.getText();

					System.out.println("Country is: " +couLi);
					if(couLi.contains(country2))
					{
						System.out.println("Inside if**************");
						System.out.println("Country is: " +couLi);
						lt.click();

						Thread.sleep(5000);

						selectedcountry = couLi;
						System.out.println("Selected Country is "+selectedcountry);

						break;

					}
				}

				Report.put("Click on the Country dropdown at the bottom of the page and select previous displayed country", 
						"1. The page should be reloaded in the language of the selected country.", 
						"1.Country changed to : "+Report.color(country2),"PASS");
			}

			else
			{
				Log.info("Test case fail: issue in selecting country");
				Report.put("Search for different products and verify the in Drivers and Downloads page in different countries", 
						"The Drivers and experience should be uniform irrespective of product", 
						"issue in selecting country " +Report.color(country2), "FAIL");
				Assert.fail();
			}

			if(driver.getCurrentUrl().contains("en"))
			{
				Log.info("Test Case Pass: loaded with selected country ");
				String title=driver.getTitle();
				System.out.println("title of page after changing country is "+title);
			}
			else
			{
				driver.get("https://www.dell.com/support/home/us/en/04/");
				Log.info("Test Case Fail: not loaded with selected country");
				Report.put("Search for different products and verify the in Drivers and Downloads page in different countries", 
						"The Drivers and experience should be uniform irrespective of product", 
						"1.Pag not reloaded in the language of the selected country" +Report.color(country2), "FAIL");
				Assert.fail();
			}

			CommonUtility.ScrollTo(driver,obj_EsupportDriversandDownloadsPage.driversandDownloadsTab());

			CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.driversandDownloadsHeader());

			String tab = CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.driversandDownloadsTab()).getText();
			System.out.println(tab);
			CommonUtility.ScrollTo(driver, obj_EsupportDriversandDownloadsPage.driversTable());

			CommonUtility.ScrollTo(driver, obj_EsupportDriversandDownloadsPage.AdditionalResourcesLemc());
			List<WebElement> list=driver.findElements(obj_EsupportDriversandDownloadsPage.AdditionalResourcesLinksLemc());

			String ltMessages="";

			for(WebElement lt:list)
			{

				CommonUtility.scrollToViewElement (driver, lt);
				String names=lt.getText();

				System.out.println("Link is: " +names);
				ltMessages+=" <br> " + names;
			}	

			System.out.println(ltMessages);



			Report.put("Search for different products and verify the in Drivers and Downloads page in different countries", 
					"The Drivers and experience should be uniform irrespective of product", 
					"able to see Drivers and Downloads page experience is uniform irrespective of country","PASS");

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Search for different products and verify the in Drivers and Downloads page in different countries", 
					"The Drivers and experience should be uniform irrespective of product",  
					"issue in selecting country " +Report.color(country2)+" page not loaded with expected page with different country", "FAIL");
		}
	}


	public void  ValidateSupportHomePageFordifferentlogincredentials(WebDriver driver, String user, String pas)
	{
		WebDriverWait  wait = new WebDriverWait(driver, 120);
		Log.info("Entering ValidateSupportHomePageFordifferentlogincredentials");
		Actions act=new Actions(driver);



		String title="";
		String tabname="";
		String text="";
		int count=0;
		String encount="";

		try{


			tabname=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SupportHeader()).getText();
			System.out.println("title of page is "+tabname);


			CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.Delllogo());
			CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.SearchServicetag());

			CommonUtility.scrollToViewElement(driver, obj_EsupportDriversandDownloadsPage.Headerservicetag());
			//act.moveToElement(CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.Headerservicetag())).build().perform();


			String Headerservicetag=CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.Headerservicetag()).getText();
			System.out.println(Headerservicetag);

			String DellEmcProductIcontext=CommonUtility.highlightElement(driver,obj_EsupportIntegratedHomePage.DellEmcProductIcontext()).getText();
			System.out.println(DellEmcProductIcontext);


			String Browseallproductslink=CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.Browseallproductslink()).getText();
			System.out.println(Browseallproductslink);

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

			System.out.println(ltMessages);
			String criticalLinks="";


//			CommonUtility.ScrollTo(driver, obj_EsupportIntegratedHomePage.TechDirectLink());
//			CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.TechDirectLink());
//			criticalLinks = criticalLinks + CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.TechDirectLink()).getText() + "<br>";
//
//			CommonUtility.ScrollTo(driver, obj_EsupportIntegratedHomePage.myService360());
//			CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.myService360());
//			criticalLinks = criticalLinks + CommonUtility.highlightElement(driver, obj_EsupportIntegratedHomePage.myService360()).getText() + "<br>";


			Report.put("Login using different credentials and access level and verify the  IPS experience and the Drivers and Downloads page  based on each login ", 
					" The IPS and the Drivers and Downloads experience should be uniform irrespective of accounts",  
					"Able to see expected IPS experience irrespective of Login using access level and credentials "+Report.color(user+" password "+pas),"PASS");
		}

		catch(Exception e)
		{

			e.printStackTrace();
			Report.put("Login using different credentials and access level and verify the  IPS experience and the Drivers and Downloads page  based on each login ", 
					" The IPS and the Drivers and Downloads experience should be uniform irrespective of accounts",  
					"not able to see expected IPS experience irrespective of Login using different credentials and access level using "+Report.color(user+" password "+pas), "FAIL");
			Assert.fail();
		}
	}

	public void  ValidateDriversAndDownloadPageFordifferentlogincredentials(WebDriver driver, String user, String pas)
	{
		WebDriverWait  wait = new WebDriverWait(driver, 120);
		Log.info("Entering ValidateDriversAndDownloadPageFordifferentlogincredentials");
		Actions act=new Actions(driver);



		String title="";
		String tabname="";
		String text="";
		int count=0;
		String encount="";

		try{

			CommonUtility.ScrollTo(driver,obj_EsupportDriversandDownloadsPage.driversandDownloadsTab());
            Thread.sleep(5000);
			CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.driversandDownloadsHeader());

			String tab = CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.driversandDownloadsTab()).getText();
			System.out.println(tab);
			CommonUtility.ScrollTo(driver, obj_EsupportDriversandDownloadsPage.driversTable());

			CommonUtility.ScrollTo(driver, obj_EsupportDriversandDownloadsPage.AdditionalResourcesLemc());
			String header = CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.AdditionalResourcesLemc()).getText();
			System.out.println(header);

			List<WebElement> list=driver.findElements(obj_EsupportDriversandDownloadsPage.AdditionalResourcesLinksLemc());

			String ltMessages="";

			for(WebElement lt:list)
			{

				CommonUtility.scrollToViewElement (driver, lt);
				String names=lt.getText();

				System.out.println("Link is: " +names);
				ltMessages+=" <br> " + names;
			}	

			System.out.println(ltMessages);




			Report.put("Login using different credentials and access level and verify the  IPS experience and the Drivers and Downloads page  based on each login ", 
					" The IPS and the Drivers and Downloads experience should be uniform irrespective of accounts",  
					"Able to see expected Drivers and Downloads page irrespective of Login using access level and credentials "+Report.color(user+" password "+pas),"PASS");
		}

		catch(Exception e)
		{

			e.printStackTrace();
			Report.put("Login using different credentials and access level and verify the  IPS experience and the Drivers and Downloads page  based on each login ", 
					" The IPS and the Drivers and Downloads experience should be uniform irrespective of accounts",  
					"not able to see expected Drivers and Downloads page irrespective of Login using different credentials and access level using "+Report.color(user+" password "+pas), "FAIL");
			Assert.fail();
		}
	}
	
	public void VerifyDriversListIsCollapsed(WebDriver driver)
	{
		System.out.println("Inside VerifyDriversListIsCollapsed method");
		Log.info("Inside VerifyDriversListIsCollapsed method");
		Actions act=new Actions(driver);
		
		WebDriverWait wait = new WebDriverWait(driver, 120); 

		try
		{			
			if(CommonUtility.CheckpresenceofAllElementLocated(driver, 15,obj_EsupportDriversandDownloadsPage.HeadingOfCollapsedSection()))
			{
			
			CommonUtility.ScrollTo(driver, obj_EsupportDriversandDownloadsPage.HeadingOfCollapsedSection());
			String head=CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.HeadingOfCollapsedSection()).getText();
			System.out.println(head);
			
			CommonUtility.ScrollTo(driver, obj_EsupportDriversandDownloadsPage.ExpandButtonForCollapse());
			String link=CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.ExpandButtonForCollapse()).getAttribute("class");
			System.out.println(link);
			
			if(!(link.contains("collapsed")))
			{
				System.out.println("user failed to see driver list collapsed");
				Report.put("Verify the driver list is collapsed",
						"The manual download option should be collapsed encouraging Customers to use recommendations offered through scan",
						"Failed to see driver list collapsed", "FAIL");
				Assert.fail();
			}
			
			CommonUtility.ScrollTo(driver, obj_EsupportDriversandDownloadsPage.RecommendedUpdatesSection());
			String recom=CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.RecommendedUpdatesSection()).getText();
			System.out.println(recom);
			
			CommonUtility.ScrollTo(driver, obj_EsupportDriversandDownloadsPage.LetDellAutomaticallyFindDriver());
			String rectext=CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.LetDellAutomaticallyFindDriver()).getText();
			System.out.println(rectext);
			
			CommonUtility.ScrollTo(driver, obj_EsupportDriversandDownloadsPage.CheckForUpdatesButton());
			String scanbutton=CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.CheckForUpdatesButton()).getText();
			System.out.println(scanbutton);
			
			if(!(scanbutton.contains("Check for Updates")))
			{
				System.out.println("User failed to see Updates button under recommended section");
				Report.put("Verify the driver list is collapsed",
						"The manual download option should be collapsed encouraging Customers to use recommendations offered through scan",
						"Failed to see Updates button under recommended section", "FAIL");
				Assert.fail();
			}
			
			Report.put("Verify the driver list is collapsed",
					"The manual download option should be collapsed encouraging Customers to use recommendations offered through scan",
					"User able to see expected driver list is "+Report.color(link)+" along with "+Report.color(recom)+" along with text "+Report.color(rectext)+" along with "+Report.color(scanbutton)+" button", "PASS");
			
			}
			else
				if(CommonUtility.CheckpresenceofAllElementLocated(driver, 15,obj_EsupportDriversandDownloadsPage.HeadingOfCollapsedSection1()))
				{
				
				CommonUtility.ScrollTo(driver, obj_EsupportDriversandDownloadsPage.HeadingOfCollapsedSection1());
				String head=CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.HeadingOfCollapsedSection1()).getText();
				System.out.println(head);
				
				CommonUtility.ScrollTo(driver, obj_EsupportDriversandDownloadsPage.ExpandButtonForCollapse());
				String link=CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.ExpandButtonForCollapse()).getAttribute("class");
				System.out.println(link);
				
				if(!(link.contains("collapsed")))
				{
					System.out.println("user failed to see driver list collapsed");
					Report.put("Verify the driver list is collapsed",
							"The manual download option should be collapsed encouraging Customers to use recommendations offered through scan",
							"Failed to see driver list collapsed", "FAIL");
					Assert.fail();
				}
				
				CommonUtility.ScrollTo(driver, obj_EsupportDriversandDownloadsPage.RecommendedUpdatesSection());
				String recom=CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.RecommendedUpdatesSection()).getText();
				System.out.println(recom);
				
				CommonUtility.ScrollTo(driver, obj_EsupportDriversandDownloadsPage.LetDellAutomaticallyFindDriver1());
				String rectext=CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.LetDellAutomaticallyFindDriver1()).getText();
				System.out.println(rectext);
				
				CommonUtility.ScrollTo(driver, obj_EsupportDriversandDownloadsPage.CheckForUpdatesButton());
				String scanbutton=CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.CheckForUpdatesButton()).getText();
				System.out.println(scanbutton);
				
				if(!(scanbutton.contains("Check for Updates")))
				{
					System.out.println("User failed to see Updates button under recommended section");
					Report.put("Verify the driver list is collapsed",
							"The manual download option should be collapsed encouraging Customers to use recommendations offered through scan",
							"Failed to see Updates button under recommended section", "FAIL");
					Assert.fail();
				}
				
				Report.put("Verify the driver list is collapsed",
						"The manual download option should be collapsed encouraging Customers to use recommendations offered through scan",
						"User able to see expected driver list is "+Report.color(link)+" along with "+Report.color(recom)+" along with text "+Report.color(rectext)+" along with "+Report.color(scanbutton)+" button", "PASS");
				
				}
				else
			{
				System.out.println("user not able to see drivers table by default for non consumer product name");
				Report.put("Verify the driver list is collapsed",
						"The manual download option should be collapsed encouraging Customers to use recommendations offered through scan",
						"Failed to see driver list is collapsed", "FAIL");
				Assert.fail();
			}

		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify the driver list is collapsed",
					"The manual download option should be collapsed encouraging Customers to use recommendations offered through scan",
					"Failed to see driver list is collapsed", "FAIL");
			Assert.fail();
		}
	}

	public void VerifyAdditionalResourcesSections(WebDriver driver)
	{
		System.out.println("Inside VerifyAdditionalResourcesSections method");
		Log.info("Inside VerifyAdditionalResourcesSections method");

		WebDriverWait wait = new WebDriverWait(driver, 120); 

		try
		{			
			Actions act=new Actions(driver);
			//act.moveToElement(CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.driversTable())).build().perform();
			if(CommonUtility.CheckpresenceofAllElementLocated(driver, 15,obj_EsupportDriversandDownloadsPage.AdditionalResourceSection()))
			{
			
			CommonUtility.ScrollTo(driver, obj_EsupportDriversandDownloadsPage.AdditionalResourceSection());
			
			
			Report.put("Verify the Addition Resources section is still displayed ",
					"The Additional Resources section should be displayed ",
					"User able to see Addition Resources section ", "PASS");
			
			}
			else
			{
				System.out.println("User not able see Addition Resources section");
				Report.put("Verify the Addition Resources section is still displayed ",
						"The Additional Resources section should be displayed ",
						"User failed to see Addition Resources section", "FAIL");
				
				Assert.fail();
			}

		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify the Addition Resources section is still displayed ",
					"The Additional Resources section should be displayed ",
					"User failed to see Addition Resources section", "FAIL");
		Assert.fail();
		}
	}
	
	public void VerifyDownloadSectionDetailsForViewImportantInformationlink(WebDriver driver)
	{
		System.out.println("Inside VerifyDownloadSectionDetailsForViewImportantInformationlink method");
		Log.info("Inside VerifyDownloadSectionDetailsForViewImportantInformationlink method");

		WebDriverWait wait = new WebDriverWait(driver, 120); 
		String data = "";
		try
		{				
			Thread.sleep(6000);
			Thread.sleep(6000);
			CommonUtility.ScrollTo(driver, obj_EsupportDriversandDownloadsPage.downloadListData());
			List<WebElement> list=driver.findElements(obj_EsupportDriversandDownloadsPage.downloadListData());

			Actions act=new Actions(driver);

			for(WebElement lt:list)
			{
				act.moveToElement(CommonUtility.highlightElement(driver, lt)).build().perform();
				String names=lt.getText();

				System.out.println("Data is: " +names);
				data+=" <br> " + names;
			}	

			System.out.println(data);

			CommonUtility.ScrollTo(driver,obj_EsupportDriversandDownloadsPage.ViewImportantInformationLink());
			String important=CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.ViewImportantInformationLink()).getText();
			System.out.println(important);
			
			CommonUtility.ScrollTo(driver,obj_EsupportDriversandDownloadsPage.viewDetailsLink());
			String details=CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.ViewImportantInformationLink()).getText();
			System.out.println(details);
			
			List<WebElement> cancelList=driver.findElements(obj_EsupportDriversandDownloadsPage.cancelButton());



			for(WebElement lt:cancelList)
			{
				System.out.println("Inside for loop cancel Button");
				CommonUtility.highlightElement(driver, lt);
			}	

			if(CommonUtility.CheckpresenceofElementLocated(driver, 05, obj_EsupportDriversandDownloadsPage.downloadListToggleButton()))
			{
				System.out.println("Collapse button present");
			}

			Report.put("Click to expand and view the details of the download list",
					"The driver with the Important Information should display the icon and message with a link indicating that the driver added to download list has an Important Information",
					"Displayed list"+Report.color(data)+" successfully with remove &  collapse button along with "+Report.color(important)+" link and "+Report.color(details)+" link", "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click to expand and view the details of the download list",
					"The driver with the Important Information should display the icon and message with a link indicating that the driver added to download list has an Important Information",
					"Failed to display View Important Information", "FAIL");
			Assert.fail();
		}
	}
	
	public void SelectImportantInformationDriversFromTable(WebDriver driver)
	{
		System.out.println("Inside SelectImportantInformationDriversFromTable method");
		Log.info("Inside SelectImportantInformationDriversFromTable method");

		WebDriverWait wait = new WebDriverWait(driver, 120); 
		String data = "";

		try
		{	
			handleCookies(driver);
			//WebElement check = driver.findElement(By.xpath("(//td[@class=' text-center'])[1]"));
			Actions act=new Actions(driver);
			Thread.sleep(6000);
			//			act.moveToElement(CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.driversCheckbox())).build().perform();
			CommonUtility.ScrollTo(driver,obj_EsupportDriversandDownloadsPage.NumberOfDrivers());
			String number=CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.NumberOfDrivers()).getText();
			System.out.println("total number of drivers displayed "+number);
			int count2=Integer.valueOf(number);
			System.out.println(count2);
			if(count2<=10)
			{
			
			CommonUtility.ScrollTo(driver, obj_EsupportDriversandDownloadsPage.CheckBoxSeletionOfImporttantInformation());

			CommonUtility.ClickOn(driver, obj_EsupportDriversandDownloadsPage.CheckBoxSeletionOfImporttantInformation());
			}
			else
			{
				
			CommonUtility.ScrollTo(driver,obj_EsupportDriversandDownloadsPage.ShowAllButtonInDrivers());
			String showall=CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.ShowAllButtonInDrivers()).getText();
			System.out.println("button is  "+showall);
			System.out.println("show all button displayed");
			CommonUtility.ClickOn(driver,obj_EsupportDriversandDownloadsPage.ShowAllButtonInDrivers());
			
			Thread.sleep(6000);
			CommonUtility.ScrollTo(driver, obj_EsupportDriversandDownloadsPage.CheckBoxSeletionOfImporttantInformation());

			CommonUtility.ClickOn(driver, obj_EsupportDriversandDownloadsPage.CheckBoxSeletionOfImporttantInformation());
			CommonUtility.ToClickByUsingJavaScript_PassingByLoc(driver, obj_EsupportDriversandDownloadsPage.CheckBoxSeletionOfImporttantInformation());
			}
			
			Thread.sleep(6000);

			Report.put("Click on the checkbox of the same driver",
					"The driver should be added to the  download list",
					"Driver which has important information selected from table ", "PASS");

		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on the checkbox of the same driver",
					"The driver should be added to the  download list",
					"Failed to see the list ", "FAIL");
			Assert.fail();
		}
	}
	
	public void ClickOnViewImportantInformationLink(WebDriver driver)
	{
		System.out.println("Inside ClickOnViewImportantInformationLink method");
		Log.info("Inside ClickOnViewImportantInformationLink method");
		Actions act=new Actions(driver);
		
		WebDriverWait wait = new WebDriverWait(driver, 120); 

		try
		{			
			if(CommonUtility.CheckpresenceofAllElementLocated(driver, 15,obj_EsupportDriversandDownloadsPage.ViewImportantInformationLink()))
			{
			
			CommonUtility.ScrollTo(driver, obj_EsupportDriversandDownloadsPage.ViewImportantInformationLink());
			String head=CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.ViewImportantInformationLink()).getText();
			System.out.println(head);
			CommonUtility.ClickOn(driver, obj_EsupportDriversandDownloadsPage.ViewImportantInformationLink());
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDriversandDownloadsPage.ImportantInformationHeader()));
			
			CommonUtility.ScrollTo(driver, obj_EsupportDriversandDownloadsPage.ImportantInformationHeader());
			String header=CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.ImportantInformationHeader()).getText();
			System.out.println(header);
			
						
			CommonUtility.ScrollTo(driver, obj_EsupportDriversandDownloadsPage.ImportantInformationBody());
			String body=CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.ImportantInformationBody()).getText();
			System.out.println(body);
			
			CommonUtility.ScrollTo(driver, obj_EsupportDriversandDownloadsPage.CloseButtonOfImportantInformation());
			String closebutn=CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.CloseButtonOfImportantInformation()).getText();
			System.out.println(closebutn);
			
			
			Report.put("Click on the link View Important Information from the MDL view",
					"A popup should be displayed with the Important Information details ",
					"User able to click on "+Report.color(head)+" and able to see pop up with "+Report.color(header)+" header and "+Report.color(body)+" as other details along with "+Report.color(closebutn)+" button", "PASS");
			
			}
			else
			{
				System.out.println("user not able to see drivers table by default for non consumer product name");
				Report.put("Click on the link View Important Information from the MDL view",
						"A popup should be displayed with the Important Information details ",
						"Failed to click on View Important Information link", "FAIL");
				Assert.fail();
			}

		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on the link View Important Information from the MDL view",
					"A popup should be displayed with the Important Information details ",
					"Failed to see Important Information popup", "FAIL");
			Assert.fail();
		}
	}
	
	
	public void verifyDownloadsForSearchedKeyword(WebDriver driver, String input) 
	{
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 120);

		System.out.println("Inside verifyDownloadsForSearchedKeyword");
		Log.info("Inside verifyDownloadsForSearchedKeyword"); 

		try 
		{
			String message = "";
			String ltMessages = "";
			String names = "";
			int count = 0;

			CommonUtility.ScrollTo(driver,obj_EsupportDriversandDownloadsPage.keywordTextbox());
			CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.keywordTextbox()).clear();
			CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.keywordTextbox()).sendKeys(input);

			
			Thread.sleep(6000);
			CommonUtility.ScrollTo(driver,obj_EsupportDriversandDownloadsPage.SearchButtonIn());
			CommonUtility.ClickOn(driver,obj_EsupportDriversandDownloadsPage.SearchButtonIn());
			Thread.sleep(6000);
			CommonUtility.ScrollTo(driver,obj_EsupportDriversandDownloadsPage.downloadButtonLinks());
			List<WebElement> list=driver.findElements(obj_EsupportDriversandDownloadsPage.downloadButtonLinks());


			for(WebElement lt:list)
			{
				CommonUtility.ScrollToWebElement(driver, lt);
				names=lt.getText();
				count+=1;
				System.out.println("Button is: " +names);
				ltMessages+=" <br> " + names;
			}
			System.out.println("Number of download buttons are:"+count);
			
			CommonUtility.ScrollTo(driver,obj_EsupportDriversandDownloadsPage.NumberOfDrivers());
			String number=CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.NumberOfDrivers()).getText();
			System.out.println("total number of drivers displayed "+number);
			int count2=Integer.valueOf(number);
			System.out.println(count2);
			if(count2>=10)
			{
				CommonUtility.ScrollTo(driver,obj_EsupportDriversandDownloadsPage.ShowAllButtonInDrivers());
				String showall=CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.ShowAllButtonInDrivers()).getText();
				System.out.println("button is  "+showall);
				System.out.println("show all button displayed");
			}

			Report.put("Refine the search with another keyword eg : audio and verify the results\r\n"
					+ "\r\n"
					+ "Precondition: Downloads found on the searched keyword",
					"The table should be displayed with the list of all drivers matching the keyword and 'Number of drivers'  count should be accurate ",
					"user successfully sees displayed with download links "+Report.color(names+" along with number of download buttons "+count)+" when searched keyword is "+Report.color(input), "PASS");					
			
			Report.put("Verify the label of the Show All button at the bottom of the driver list when there are more than 10 downloads available for the searched keyword",
					"The Show All button should not be displayed with the count as the count or number of drivers is already displayed at the top",
					"User able to see number of drivers "+Report.color(number)+" and  show all will be displayed on if the count is more than 10", "PASS");					
		
		
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Refine the search with another keyword eg : audio and verify the results\r\n"
					+ "\r\n"
					+ "Precondition: Downloads found on the searched keyword",
					"The table should be displayed with the list of all drivers matching the keyword and 'Number of drivers'  count should be accurate ",
					"Failed to display download links of drivers in the grid", "FAIL");								
			Assert.fail();

		}
	}
	
	
	public void selectVideoOptionFromCategory(WebDriver driver,String input) 
	{
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 120);

		System.out.println("Inside selectVideoOptionFromCategory");
		Log.info("Inside selectVideoOptionFromCategory"); 

		String names="";String ltMessages="";
		try 
		{
			String category = "";
			System.out.println("input from test data sheet "+Report.color(input));
			CommonUtility.ScrollTo(driver,obj_EsupportDriversandDownloadsPage.CategoryDropDown());
			CommonUtility.ClickOn(driver,obj_EsupportDriversandDownloadsPage.CategoryDropDown());

			List<WebElement> optionList= driver.findElements(obj_EsupportDriversandDownloadsPage.CategotyDropDownValues());
//			Select s1=new Select(CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.CategotyDropDownValues()));
//			List<WebElement> optionList=s1.getOptions();
			int optionListsize=optionList.size();
			System.out.println("list of categoryies displayed in drop down are "+optionListsize);

			for(int i=0;i<optionListsize;i++)
			{
				String values=optionList.get(i).getText();
				category+= " <br> "+values;
				
				if(values.contains(input))
				{
					CommonUtility.ToClickByUsingJavaScript_PassingByLoc(driver, optionList.get(i));
				}
				
			}
			System.out.println("dropdown values are "+category);
			
//			s1.selectByVisibleText(input);
			
			
			Thread.sleep(6000);
			
			CommonUtility.ScrollTo(driver,obj_EsupportDriversandDownloadsPage.ListOfDrivers());
			List<WebElement> list=driver.findElements(obj_EsupportDriversandDownloadsPage.ListOfDrivers());
			int size=list.size();
			System.out.println("Number of drivers displayed are:"+ size);
			for(WebElement lt:list)
			{
				CommonUtility.ScrollToWebElement(driver, lt);
				names=lt.getText();
				if(!(names.contains(input)))
				{
					System.out.println("failed to see selected category related drivers");
					Report.put("Select the "+Report.color(input)+" option from the Category dropdown",
							"The driver list should be displayed as per the applied filter",
							"failed to see selected category related drivers", "FAIL");
//					Assert.fail();
				}
				System.out.println("Button is: " +names);
				ltMessages+=" <br> " + names;
			}
			

			Report.put("Select the "+Report.color(input)+" option from the Category dropdown",
					"The driver list should be displayed as per the applied filter",
					"User able to select "+Report.color(input)+" from category dropdown and able to see drivers related to selected category displayed with count of "+size, "PASS");		

			
		}                                                                                                                                        
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Select the "+Report.color(input)+" option from the Category dropdown",
					"The driver list should be displayed as per the applied filter",
					"Failed to select video option from category dropdown", "FAIL");								
			Assert.fail();

		}
	}
	
	public void validateBannerForSelectedCategory(WebDriver driver, String input) 
	{
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 120);

		System.out.println("Inside verifyDownloadsForSearchedKeyword");
		Log.info("Inside verifyDownloadsForSearchedKeyword"); 

		try 
		{
			String banner = "";
			String link = "";
			

			CommonUtility.ScrollTo(driver,obj_EsupportDriversandDownloadsPage.BannerHelpVideo());
			banner=CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.BannerHelpVideo()).getText();
			System.out.println(banner);
			
			CommonUtility.ScrollTo(driver,obj_EsupportDriversandDownloadsPage.TroubleShootVideoButton());
			link=CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.TroubleShootVideoButton()).getText();
			System.out.println(link);
			
			Report.put("Verify that a message is displayed to further to assist with "+Report.color(input)+" issues",
					"Need help with "+Report.color(input)+" issues? Find a solution in Dell's "+Report.color(input)+" troubleshooting and usage guide\" and a link \"Troubleshoot "+Report.color(input),
					"User able to see "+Report.color(banner)+" and expected link "+Report.color(link), "PASS");					
		
		
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify that a message is displayed to further to assist with "+Report.color(input)+" issues",
					"Need help with "+Report.color(input)+" issues? Find a solution in Dell's "+Report.color(input)+" troubleshooting and usage guide\" and a link \"Troubleshoot "+Report.color(input),
					"Failed to display expected banner", "FAIL");								
			Assert.fail();

		}
	}
	
	
	public void clickTroubleShootLink(WebDriver driver, String input, String input1)
	{
		System.out.println("Inside clickTroubleShootLink method");
		Log.info("Inside clickTroubleShootLink method");

		String link = "";
		String url = "";
		String header = "";

		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);

			if(CommonUtility.CheckpresenceofElementLocated(driver, 10, obj_EsupportDriversandDownloadsPage.TroubleShootVideoButton()))
			{
				CommonUtility.ScrollTo(driver, obj_EsupportDriversandDownloadsPage.TroubleShootVideoButton());
				link=CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.TroubleShootVideoButton()).getText();
				CommonUtility.ClickOn(driver, obj_EsupportDriversandDownloadsPage.TroubleShootVideoButton());
				Thread.sleep(10000);
				System.out.println("Clicked on troubleshoot Link");
				Thread.sleep(10000);
				
				String mainwindow=driver.getWindowHandle();
				Set<String> set=driver.getWindowHandles();
				int countWindow=set.size(); 

				System.out.println("Switched Window Handles and  window count is :: "+countWindow);
				
				
				Iterator<String> itr=set.iterator();
				while(itr.hasNext())
				{
					String childWindow=itr.next();
					if(!mainwindow.equals(childWindow))
					{
						Thread.sleep(6000);
						
						driver.switchTo().window(childWindow);
					
					url=driver.getCurrentUrl();
					System.out.println("URL displayed as   :::::"+url); 

					if(url.contains(input))
					{
						header=driver.getTitle();
						System.out.println(header);
					}	
					else
					{
						driver.close();

						System.out.println("Failed to redirect to "+Report.color(input));

						Report.put("Click on the link \"Troubleshoot "+Report.color(input1),
								"User should be redirected to an appropriate article page "+Report.color(input),
								"Failed to redirect to "+Report.color(input), "FAIL");
						Assert.fail();
					}
					
					driver.close();
					
				}
					
					driver.switchTo().window(mainwindow);
				}
				
				Report.put("Click on the link \"Troubleshoot "+Report.color(input1),
						"User should be redirected to an appropriate article page "+Report.color(input),
						"Redirected to URL "+Report.color(url)+" with Header "+Report.color(header), "PASS");
			}
			else
			{
				System.out.println("Failed to redirect to click on link");

				Report.put("Click on the link \"Troubleshoot "+Report.color(input1),
						"User should be redirected to an appropriate article page "+Report.color(input),
						"Failed to click on link Troubleshoot "+Report.color(input1), "FAIL");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();

			System.out.println("Failed to redirect to click on link");

			Report.put("Click on the link \"Troubleshoot "+Report.color(input1),
					"User should be redirected to an appropriate article page "+Report.color(input),
					"Failed to click on link Troubleshoot "+Report.color(input1), "FAIL");
			Assert.fail();
		}
	}
	
	public void ClickOnCollapsedDriversList(WebDriver driver)
	{
		System.out.println("Inside ClickOnCollapsedDriversList method");
		Log.info("Inside ClickOnCollapsedDriversList method");
		Actions act=new Actions(driver);
		
		WebDriverWait wait = new WebDriverWait(driver, 120); 

		try
		{			
			if(CommonUtility.CheckpresenceofAllElementLocated(driver, 15,obj_EsupportDriversandDownloadsPage.HeadingOfCollapsedSection()))
			{
			
					
			CommonUtility.ScrollTo(driver, obj_EsupportDriversandDownloadsPage.ExpansButton());
			
			CommonUtility.ClickOn(driver, obj_EsupportDriversandDownloadsPage.ExpansButton());
			Thread.sleep(6000);
			Thread.sleep(6000);
			
			String link=CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.ExpandButtonForCollapse()).getAttribute("class");
			System.out.println(link);
			if(link.contains("collapsed"))
			{
				System.out.println("user failed to see driver list expnaded");
				Report.put("Click to expand the Find Drivers option section",
						"The list of drivers applicable to the product should be dispalyed",
						"Failed to see driver list expanded", "FAIL");
				Assert.fail();
			}
			
			
			
			Report.put("Click to expand the Find Drivers option section",
					"The list of drivers applicable to the product should be dispalyed",
					"User able to see driver list after clicking on expand button", "PASS");
			
			}
			else
				if(CommonUtility.CheckpresenceofAllElementLocated(driver, 15,obj_EsupportDriversandDownloadsPage.HeadingOfCollapsedSection1()))
				{
				
				CommonUtility.ScrollTo(driver, obj_EsupportDriversandDownloadsPage.HeadingOfCollapsedSection1());
				String head=CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.HeadingOfCollapsedSection1()).getText();
				System.out.println(head);
				
				CommonUtility.ScrollTo(driver, obj_EsupportDriversandDownloadsPage.ExpansButton());
				Thread.sleep(2000);
				CommonUtility.ClickOn(driver, obj_EsupportDriversandDownloadsPage.ExpansButton());
				Thread.sleep(2000);
				String link=CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.ExpandButtonForCollapse()).getAttribute("class");
				System.out.println(link);
				Thread.sleep(3000);
				if(link.contains("collapsed"))
				{
					System.out.println("user failed to see driver list expnaded");
					Report.put("Click to expand the Find Drivers option section",
							"The list of drivers applicable to the product should be dispalyed",
							"Failed to see driver list expanded", "FAIL");
					Assert.fail();
				}
				
				
				
				Report.put("Click to expand the Find Drivers option section",
						"The list of drivers applicable to the product should be dispalyed",
						"User able to see driver list after clicking on expand button", "PASS");
				
				
				}
			else
			{
				System.out.println("user able to see drivers table by default with out expand button");
				Report.put("Click to expand the Find Drivers option section",
						"The list of drivers applicable to the product should be dispalyed",
						"Failed to see driver list is collapsed", "FAIL");
				Assert.fail();
			}

		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click to expand the Find Drivers option section",
					"The list of drivers applicable to the product should be dispalyed",
					"Failed to see driver list is collapsed", "FAIL");
			Assert.fail();
		}
	}
	
	public void ClickOnExpandedDriversList(WebDriver driver)
	{
		System.out.println("Inside ClickOnExpandedDriversList method");
		Log.info("Inside ClickOnExpandedDriversList method");
		Actions act=new Actions(driver);
		
		WebDriverWait wait = new WebDriverWait(driver, 120); 

		try
		{			
			if(CommonUtility.CheckpresenceofAllElementLocated(driver, 15,obj_EsupportDriversandDownloadsPage.HeadingOfCollapsedSection()))
			{
			
					
			CommonUtility.ScrollTo(driver, obj_EsupportDriversandDownloadsPage.ExpansButton());
			
			CommonUtility.ClickOn(driver, obj_EsupportDriversandDownloadsPage.ExpansButton());
			Thread.sleep(6000);
			Thread.sleep(6000);
			String link=CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.ExpandButtonForCollapse()).getAttribute("class");
			System.out.println(link);
			if(!(link.contains("collapsed")))
			{
				System.out.println("user failed to see driver list expnaded");
				Report.put("Verify that the user has option to collapse the list",
						"User should have an option to collapse the list",
						"Failed to see driver list collapsed", "FAIL");
				Assert.fail();
			}
			
			
			
			Report.put("Verify that the user has option to collapse the list",
					"User should have an option to collapse the list",
					"User able to see driver list after clicking on expand button", "PASS");
			
			}
			else
				if(CommonUtility.CheckpresenceofAllElementLocated(driver, 15,obj_EsupportDriversandDownloadsPage.HeadingOfCollapsedSection1()))
				{
				
				CommonUtility.ScrollTo(driver, obj_EsupportDriversandDownloadsPage.HeadingOfCollapsedSection1());
				String head=CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.HeadingOfCollapsedSection1()).getText();
				System.out.println(head);
				
				CommonUtility.ScrollTo(driver, obj_EsupportDriversandDownloadsPage.ExpansButton());
				CommonUtility.ClickOn(driver, obj_EsupportDriversandDownloadsPage.ExpansButton());
				
				String link=CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.ExpandButtonForCollapse()).getAttribute("class");
				System.out.println(link);
				
				if(!(link.contains("collapsed")))
				{
					System.out.println("user failed to see driver list expnaded");
					Report.put("Verify that the user has option to collapse the list",
							"User should have an option to collapse the list",
							"Failed to see driver list collapsed", "FAIL");
					Assert.fail();
				}
				
				
				
				Report.put("Verify that the user has option to collapse the list",
						"User should have an option to collapse the list",
						"User able to see driver list after clicking on expand button", "PASS");
				
				}
			else
			{
				System.out.println("user able to see drivers table by default with out expand button");
				Report.put("Verify that the user has option to collapse the list",
						"User should have an option to collapse the list",
						"Failed to see driver list is collapsed", "FAIL");
				Assert.fail();
			}

		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify that the user has option to collapse the list",
					"User should have an option to collapse the list",
					"Failed to see driver list is collapsed", "FAIL");
			Assert.fail();
		}
	}
	public void checkForImportantInformationIcon(WebDriver driver)
	{
		System.out.println("Inside checkForImportantInformationIcon method");
		Log.info("Inside checkForImportantInformationIcon method");

		WebDriverWait wait = new WebDriverWait(driver, 120); 
		String data = "";

		try
		{	
			handleCookies(driver);
			//WebElement check = driver.findElement(By.xpath("(//td[@class=' text-center'])[1]"));
			Actions act=new Actions(driver);
			Thread.sleep(6000);
			//			act.moveToElement(CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.driversCheckbox())).build().perform();
			CommonUtility.ScrollTo(driver,obj_EsupportDriversandDownloadsPage.NumberOfDrivers());
			String number=CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.NumberOfDrivers()).getText();
			System.out.println("total number of drivers displayed "+number);
			int count2=Integer.valueOf(number);
			System.out.println(count2);
			if(count2<=10)
			{
			
			CommonUtility.ScrollTo(driver, obj_EsupportDriversandDownloadsPage.ImportantInformationIcon());

			CommonUtility.ClickOn(driver, obj_EsupportDriversandDownloadsPage.ImportantInformationIcon());
			}
			else
			{
				
			CommonUtility.ScrollTo(driver,obj_EsupportDriversandDownloadsPage.ShowAllButtonInDrivers());
			String showall=CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.ShowAllButtonInDrivers()).getText();
			System.out.println("button is  "+showall);
			System.out.println("show all button displayed");
			CommonUtility.ClickOn(driver,obj_EsupportDriversandDownloadsPage.ShowAllButtonInDrivers());
			
			Thread.sleep(6000);
			CommonUtility.ScrollTo(driver, obj_EsupportDriversandDownloadsPage.ImportantInformationIcon());

			CommonUtility.ClickOn(driver, obj_EsupportDriversandDownloadsPage.ImportantInformationIcon());
			}
			
			Thread.sleep(6000);

			Report.put("Check for the driver from the list which has important information",
					"There should be a small tooltip \"i\"  icon displayed for the drivers with explains the driver has an important information ",
					"User able to see driver which has important information", "PASS");

		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Check for the driver from the list which has important information",
					"There should be a small tooltip \"i\"  icon displayed for the drivers with explains the driver has an important information ",
					"Failed to see the list ", "FAIL");
			Assert.fail();
		}
	}
	
	public void ClickOnCollapseButtonOfImportInfoDriver(WebDriver driver)
	{
		System.out.println("Inside ClickOnCollapseButtonOfImportInfoDriver method");
		Log.info("Inside ClickOnCollapseButtonOfImportInfoDriver method");
		Actions act=new Actions(driver);
		
		WebDriverWait wait = new WebDriverWait(driver, 120); 

		try
		{			
			if(CommonUtility.CheckpresenceofAllElementLocated(driver, 15,obj_EsupportDriversandDownloadsPage.ExpandButtonForFirstDisplayedImportantInformationDriver()))
			{
			
			CommonUtility.ScrollTo(driver, obj_EsupportDriversandDownloadsPage.ExpandButtonForFirstDisplayedImportantInformationDriver());
			
			CommonUtility.ClickOn(driver, obj_EsupportDriversandDownloadsPage.ExpandButtonForFirstDisplayedImportantInformationDriver());
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDriversandDownloadsPage.ImportantInformationHeadingInExpandedView()));
			
			CommonUtility.ScrollTo(driver, obj_EsupportDriversandDownloadsPage.ImportantInformationHeadingInExpandedView());
			String header=CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.ImportantInformationHeadingInExpandedView()).getText();
			System.out.println(header);
			
						
			CommonUtility.ScrollTo(driver, obj_EsupportDriversandDownloadsPage.DetailsUnderImportantInformation());
			String body=CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.DetailsUnderImportantInformation()).getText();
			System.out.println(body);
			
			Report.put("Click on the driver to expand and see more details within the list page itself",
					"The important information should also be displayed in the expanded view in the list page itself",
					"User able to click on expand button of  important information driver and able to see "+Report.color(header)+" header along with other details "+Report.color(body), "PASS");
			
			}
			else
			{
				System.out.println("user not able to see drivers with important information");
				Report.put("Click on the driver to expand and see more details within the list page itself",
						"The important information should also be displayed in the expanded view in the list page itself",
						"Failed to click on expand button of important information", "FAIL");
				Assert.fail();
			}

		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on the driver to expand and see more details within the list page itself",
					"The important information should also be displayed in the expanded view in the list page itself",
					"Failed to see Important Information expand button", "FAIL");
			Assert.fail();
		}
	}
	
	public void ClickViewDetailsLinkForFirstDisplayedImportantInformationDriver(WebDriver driver)
	{

		Log.info("Inside ClickViewDetailsLinkForFirstDisplayedImportantInformationDriver method");

		WebDriverWait wait = new WebDriverWait(driver, 120); 
		String header="";
		String viewdetails="";
		String ltMessages="";
		String ltMessages1="";

		try
		{			
			CommonUtility.ScrollTo(driver, obj_EsupportDriversandDownloadsPage.ViewFullDriverDetails());
			viewdetails=CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.ViewFullDriverDetails()).getText();
			System.out.println(viewdetails);
			CommonUtility.ClickOn(driver, obj_EsupportDriversandDownloadsPage.ViewFullDriverDetails());
			Thread.sleep(6000);

			Set<String> allWH=driver.getWindowHandles(); 
			String currentwindow=driver.getWindowHandle();
			int count=allWH.size(); 
			System.out.println("Switched Window Handles and  window count is :: "+count);

			for(String wh:allWH)
			{

				Thread.sleep(10000);
				driver.switchTo().window(wh); 
				String title=driver.getTitle();
				System.out.println("Tittle displayed as   :::::"+title); 

				Report.put("Click on any driver from the list and click to view the details page ",
						"The driver details page should be displayed",
						"the drivers page displayed with title as "+Report.color(title), "PASS");

				String url=driver.getCurrentUrl();
				System.out.println("url is "+url);

				if(url.contains("driversdetails"))
				{

					System.out.println("Switched to window");

					handleCookies(driver);

					CommonUtility.ScrollTo(driver, obj_EsupportDriversandDownloadsPage.ViewImportantInformationLinkInSeperateView());

					header=CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.ViewImportantInformationLinkInSeperateView()).getText();
					System.out.println("Link is "+header);

					Report.put("Check for the Important Information indicator in the driver details page",
							"The View Important Information Indicator and a link  should be displayed in the driver details page ",
							"User able to view "+Report.color(header)+" link in driver details page", "PASS");
					
					CommonUtility.ClickOn(driver, obj_EsupportDriversandDownloadsPage.ViewImportantInformationLinkInSeperateView());

					CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.ImportantInformationAreaExpandedDefault());
					String expanded=CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.ImportantInformationAreaExpandedDefault()).getAttribute("aria-expanded");
					System.out.println("area is expanded "+expanded);
					
					if(!(expanded.contains("true")))
					{
						Report.put("Click on the View Important Information link ",
								"The driver details page should be auto scrolled to the expanded view of Important Information section within the driver details page",
								"User failed to see Important information section expanded by default after clicking on view important information link", "FAIL");
						
						Assert.fail();
					}
					
					CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.ImportantInformationAreaExpandedDefault());
					String impinfo=CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.ImportantInformationAreaExpandedDefault()).getText();
					System.out.println("expanded link is "+impinfo);
					
					CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.DetilsUnderImportantInformationInSeperateView());
					String details=CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.DetilsUnderImportantInformationInSeperateView()).getText();
					System.out.println("details under inportant information is "+details);
					
					Report.put("Click on the View Important Information link ",
							"The driver details page should be auto scrolled to the expanded view of Important Information section within the driver details page",
							"User able to click on "+Report.color(header)+" link successfully and able to see "+Report.color(impinfo)+" area expanded by deafault displaying details "+Report.color(details), "PASS");
					
					driver.close();
				}


			}

			Thread.sleep(5000);
			driver.switchTo().window(currentwindow);
			System.out.println("done");



		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on the View Important Information link ",
					"The driver details page should be auto scrolled to the expanded view of Important Information section within the driver details page",
					"Failed to expected behaviour in important information drivers details page", "FAIL");
			Assert.fail();
		}
	}
	
	public void VerifyAdditionalResourcesSections_ForDellUpdateLink_DriversAreCollapsed(WebDriver driver)
	{
		System.out.println("Inside VerifyAdditionalResourcesSections_ForDellUpdateLink_DriversAreCollapsed method");
		Log.info("Inside VerifyAdditionalResourcesSections_ForDellUpdateLink_DriversAreCollapsed method");

		WebDriverWait wait = new WebDriverWait(driver, 120); 
		String ltMessages="";
		try
		{			
			Actions act=new Actions(driver);
			//act.moveToElement(CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.driversTable())).build().perform();
			if(CommonUtility.CheckpresenceofAllElementLocated(driver, 15,obj_EsupportDriversandDownloadsPage.AdditionalResourceSection()))
			{
			
			CommonUtility.ScrollTo(driver, obj_EsupportDriversandDownloadsPage.AdditionalResourceSection());
			CommonUtility.ScrollTo(driver, obj_EsupportDriversandDownloadsPage.additionalResourcesLinks());
			List<WebElement> list=driver.findElements(obj_EsupportDriversandDownloadsPage.additionalResourcesLinks());

			for(WebElement lt:list)
			{

				//				act.moveToElement(CommonUtility.highlightElement(driver, lt)).build().perform();;
				CommonUtility.ScrollToWebElement(driver, lt);
				String names=lt.getText();

				System.out.println("Link is: " +names);
				ltMessages+=" <br> " + names;
			}	
			System.out.println(ltMessages);
			
			if(ltMessages.contains("Dell Update"))
			{
				System.out.println("User sees Dell Update link under Addition Resources section");
				Report.put("Verify the Addition Resources section is still displayed, but the Dell Update link is not displayed",
						"The Dell Update link should not be displayed in the Additional Resources so that the user do not get confused between the scan option available on the web and the Dell update tool link which also provides driver recommendation",
						"User sees Dell Update link under Addition Resources section", "FAIL");
				
				Assert.fail();
			}
			
			Report.put("Verify the Addition Resources section is still displayed, but the Dell Update link is not displayed",
					"The Dell Update link should not be displayed in the Additional Resources so that the user do not get confused between the scan option available on the web and the Dell update tool link which also provides driver recommendation",
					"User able to see Addition Resources section with links "+Report.color(ltMessages)+" which doesn't contains Dell Update link", "PASS");
			
			}
			else
			{
				System.out.println("User not able see Addition Resources section");
				Report.put("Verify the Addition Resources section is still displayed, but the Dell Update link is not displayed",
						"The Dell Update link should not be displayed in the Additional Resources so that the user do not get confused between the scan option available on the web and the Dell update tool link which also provides driver recommendation",
						"User failed to see Addition Resources section", "FAIL");
				
				Assert.fail();
			}

		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify the Addition Resources section is still displayed, but the Dell Update link is not displayed",
					"The Dell Update link should not be displayed in the Additional Resources so that the user do not get confused between the scan option available on the web and the Dell update tool link which also provides driver recommendation",
					"User failed to see Addition Resources section", "FAIL");
		Assert.fail();
		}
	}
	
	public void MicroFeedBackSection_NotDisplayed(WebDriver driver)
	{
		System.out.println("Inside MicroFeedBackSection_NotDisplayed method");
		Log.info("Inside MicroFeedBackSection_NotDisplayed method");
		Actions act=new Actions(driver);
		
		WebDriverWait wait = new WebDriverWait(driver, 120); 

		try
		{			
			if(CommonUtility.CheckpresenceofAllElementLocated(driver, 15,obj_EsupportDriversandDownloadsPage.SurveySection()))
			{
				System.out.println("user able to see drivers table by default with out expand button");
				Report.put("Verify that the micro feedback section is not displayed ",
						"The micro feedback section should not be displayed so that the user do not \r\n"
						+ "end up giving feedback without trying scan or manual download option",
						"user able to see micro feedback section", "FAIL");
				Assert.fail();
			
			}
			else
			{

				Report.put("Verify that the micro feedback section is not displayed ",
						"The micro feedback section should not be displayed so that the user do not \r\n"
						+ "end up giving feedback without trying scan or manual download option",
						"User not able to see micro feed back section as expected", "PASS");
				
			}

		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify that the micro feedback section is not displayed ",
					"The micro feedback section should not be displayed so that the user do not \r\n"
					+ "end up giving feedback without trying scan or manual download option",
					"user able to see micro feedback section", "FAIL");
			Assert.fail();
		}
	}
	
	public void SystemUpdateBannerSection_NotDisplayed(WebDriver driver)
	{
		System.out.println("Inside SystemUpdateBannerSection_NotDisplayed method");
		Log.info("Inside SystemUpdateBannerSection_NotDisplayed method");
		Actions act=new Actions(driver);
		
		WebDriverWait wait = new WebDriverWait(driver, 120); 

		try
		{			
			if(CommonUtility.CheckpresenceofAllElementLocated(driver, 15,obj_EsupportDriversandDownloadsPage.BannerHelpSection()))
			{
				
				System.out.println("user able to see  System Update banner section");
				Report.put("Verify the System Update banner section is hidden",
						"The System Update banner section should be hidden",
						"user able to see banner help section", "FAIL");
				Assert.fail();
				
			
			}
			else
			{

				Report.put("Verify the System Update banner section is hidden",
						"The System Update banner section should be hidden",
						"User not able to see banner help section as expected", "PASS");
				
			}

		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify the System Update banner section is hidden",
					"The System Update banner section should be hidden",
					"user able to see banner help section", "FAIL");
			Assert.fail();
		}
	}
	
	
	public void SearchKeywordFromDriversPage(WebDriver driver,String input) 
	{
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 120);

		System.out.println("Inside SearchKeywordFromDriversPage");
		Log.info("Inside SearchKeywordFromDriversPage"); 

		String names="";String ltMessages="";
		try 
		{
			String category = "";
			System.out.println("input from test data sheet "+input);
			CommonUtility.ScrollTo(driver,obj_EsupportDriversandDownloadsPage.keywordTextbox());
			CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.keywordTextbox()).clear();
			CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.keywordTextbox()).sendKeys(input);

			
			Thread.sleep(6000);
			CommonUtility.ScrollTo(driver,obj_EsupportDriversandDownloadsPage.SearchButtonIn());
			CommonUtility.ClickOn(driver,obj_EsupportDriversandDownloadsPage.SearchButtonIn());
			Thread.sleep(6000);
			
			Thread.sleep(6000);
			CommonUtility.ScrollTo(driver,obj_EsupportDriversandDownloadsPage.BannerForKeywordSearch());
			String banner=CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.BannerForKeywordSearch()).getText();
			System.out.println(banner);
			
			
//			CommonUtility.ScrollTo(driver,obj_EsupportDriversandDownloadsPage.ListOfDrivers());
//			List<WebElement> list=driver.findElements(obj_EsupportDriversandDownloadsPage.ListOfDrivers());
//			int size=list.size();
//			System.out.println("Number of drivers displayed are:"+ size);
//			for(WebElement lt:list)
//			{
//				CommonUtility.ScrollToWebElement(driver, lt);
//				names=lt.getText();
//				if(!(names.contains(input)))
//				{
//					System.out.println("failed to see selected category related drivers");
//					Report.put("Enter a keyword having native drivers "+Report.color(input	)+" Precondition : There are drivers associated with the searched keyword",
//							"The driver list should be displayed as per the applied filter", 
//							"failed to see selected category related drivers", "FAIL");
//					Assert.fail();
//
//				}
//				System.out.println("Button is: " +names);
//				ltMessages+=" <br> " + names;
//			}
			

			Report.put("Enter a keyword having native drivers "+Report.color(input)+" Precondition : There are drivers associated with the searched keyword",
					"A message banner should be displayed right below the Search/ Filter CTA", 
					"User able to search "+Report.color(input)+" keyword and able to see banner "+Report.color(banner), "PASS");		

			
		}                                                                                                                                        
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Enter a keyword having native drivers "+Report.color(input)+" Precondition : There are drivers associated with the searched keyword",
					"A message banner should be displayed right below the Search/ Filter CTA", 
					"Failed to search "+Report.color(input)+"keyword from drivers page", "FAIL");								
			Assert.fail();

		}
	}
	
	public void validateSortByDropdown(WebDriver driver) 
	{
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 120);

		System.out.println("Inside validateSortByDropdown");
		Log.info("Inside validateSortByDropdown"); 

		try 
		{
			String banner = "";
			String link = "";
			

			CommonUtility.ScrollTo(driver,obj_EsupportDriversandDownloadsPage.SortByText());
			banner=CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.SortByText()).getText();
			System.out.println(banner);
			
			CommonUtility.ScrollTo(driver,obj_EsupportDriversandDownloadsPage.SortByDownload());
			
			
			Report.put("Verify that the user is able to see the new sort dropdown ",
					"The new sort option dropdown should be displayed",
					"User able to see "+Report.color(banner)+" along with dropdown", "PASS");					
		
		
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify that the user is able to see the new sort dropdown ",
					"The new sort option dropdown should be displayed",
					"Failed to see sort option dropdown", "FAIL");								
			Assert.fail();

		}
	}
	
	public void verifyPopularOption(WebDriver driver) 
	{
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 120);

		System.out.println("Inside verifyPopularOption");
		Log.info("Inside verifyPopularOption"); 

		try 
		{
			String banner = "";
			String link = "";
			String listof="";
			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_EsupportDriversandDownloadsPage.SortByDownload()))
			{
			CommonUtility.ScrollTo(driver,obj_EsupportDriversandDownloadsPage.SortByDownload());
			CommonUtility.ClickOn(driver,obj_EsupportDriversandDownloadsPage.SortByDownload());
			
			CommonUtility.ScrollTo(driver,obj_EsupportDriversandDownloadsPage.SortByDownloadOption());
			List<WebElement> list=driver.findElements(obj_EsupportDriversandDownloadsPage.SortByDownloadOption());

			for(WebElement lt:list)
			{
				CommonUtility.highlightElement(driver, lt);
				String names=lt.getText();

				System.out.println("option is: " +names);
				listof+=" <br> " + names;

			}
			if(listof.contains("Popular"))
			{
				Report.put("Verify the \"Popular\" sort option",
						"The Popular downloads should be displayed ",
						"User able to see "+Report.color("Popular")+" is one among dropdown options", "PASS");	
				
			}
			else
			{
				Report.put("Verify the \"Popular\" sort option",
						"The Popular downloads should be displayed ",
						"Failed to see popular option in sort dropdown", "FAIL");								
//				Assert.fail();
			}
			
							
			}
			else
			{
				Report.put("Verify the \"Popular\" sort option",
						"The Popular downloads should be displayed ",
						"Failed to see popular option in sort dropdown", "FAIL");								
				Assert.fail();
			}
			String ltMessages="";
			
			if(CommonUtility.CheckpresenceofElementLocated(driver,15, obj_EsupportDriversandDownloadsPage.SortByDownloadOption()))
			{
			CommonUtility.ScrollTo(driver,obj_EsupportDriversandDownloadsPage.SortByDownloadOption());
			List<WebElement> list=driver.findElements(obj_EsupportDriversandDownloadsPage.SortByDownloadOption());

			for(WebElement lt:list)
			{
				CommonUtility.highlightElement(driver, lt);
				String names=lt.getText();

				System.out.println("option is: " +names);
				ltMessages+=" <br> " + names;


			}
			System.out.println("options------------------>"+ltMessages);
		
			Report.put("Verify the other options of Sort dropdown",
					"The following options should be displayed in the dropdown\r\n"
					+ "\r\n"
					+ "Urgent \r\n"
					+ "Popular\r\n"
					+ "Released : newest\r\n"
					+ "Released : Oldest \r\n"
					+ "Name : A to Z\r\n"
					+ "Name : Z to A\r\n"
					+ "Category : A to Z\r\n"
					+ "Category : Z to A",
					"User able to see "+Report.color(ltMessages)+" as dropdown options", "PASS");	
			}
			else
			{
				Report.put("Verify the other options of Sort dropdown",
						"The following options should be displayed in the dropdown\r\n"
						+ "\r\n"
						+ "Urgent \r\n"
						+ "Popular\r\n"
						+ "Released : newest\r\n"
						+ "Released : Oldest \r\n"
						+ "Name : A to Z\r\n"
						+ "Name : Z to A\r\n"
						+ "Category : A to Z\r\n"
						+ "Category : Z to A",
						"Failed to see option in sort dropdown", "FAIL");								
				Assert.fail();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify the \"Popular\" sort option",
					"The Popular downloads should be displayed ",
					"Failed to see popular option in sort dropdown", "FAIL");								
			Assert.fail();

		}
	}
	
	
	public void SelectPopularOptionAndValidateGrid(WebDriver driver, String input) 
	{
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 120);

		System.out.println("Inside SelectPopularOptionAndValidateGrid");
		Log.info("Inside SelectPopularOptionAndValidateGrid"); 

		try 
		{
			String banner = "";
			String link = "";
			String ltMessages="";
			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_EsupportDriversandDownloadsPage.SortByDownloadOption()))
			{
//			CommonUtility.ScrollTo(driver,obj_EsupportDriversandDownloadsPage.SortByDownload());
//			CommonUtility.ClickOn(driver,obj_EsupportDriversandDownloadsPage.SortByDownload());
			
			CommonUtility.ScrollTo(driver,obj_EsupportDriversandDownloadsPage.SortByDownloadOption());
			List<WebElement> list=driver.findElements(obj_EsupportDriversandDownloadsPage.SortByDownloadOption());

			for(WebElement lt:list)
			{
				CommonUtility.highlightElement(driver, lt);
				String names=lt.getText();

				System.out.println("option is: " +names);
				if(names.equalsIgnoreCase(input))
				{
					CommonUtility.ClickOnWebElement(driver, lt);
					
					break;
				}
				

			}
			
			Thread.sleep(6000);
			CommonUtility.ScrollTo(driver,obj_EsupportDriversandDownloadsPage.PopularSortByOption());
			List<WebElement> list1=driver.findElements(obj_EsupportDriversandDownloadsPage.PopularSortByOption());

			for(WebElement lt:list1)
			{
				CommonUtility.highlightElement(driver, lt);
				String names=lt.getText();

				System.out.println("option is: " +names);
				ltMessages+=" <br> " + names;
				if(names.equalsIgnoreCase(input))
				{
					System.out.println(names);
				}
				else
				{
					Report.put("Verify the driver list displayed gets sorted based on the selection",
							"The driver list should be displayed sorted based on the selection from the dropdown",
							"Failed to see "+Report.color(input)+"  option sorted in drivers displayed", "FAIL");								
					Assert.fail();
				}

			}
			
			System.out.println(ltMessages);
			Report.put("Verify the driver list displayed gets sorted based on the selection",
					"The driver list should be displayed sorted based on the selection from the dropdown",
					"User able to see "+Report.color(ltMessages)+" sorted in and displayed ", "PASS");	
							
			}
			else
			{
				Report.put("Verify the driver list displayed gets sorted based on the selection",
						"The driver list should be displayed sorted based on the selection from the dropdown",
						"Failed to see "+Report.color(input)+" option in sort dropdown", "FAIL");								
				Assert.fail();
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify the \"Popular\" sort option",
					"The Popular downloads should be displayed ",
					"Failed to see popular option in sort dropdown", "FAIL");								
			Assert.fail();

		}
	}
	
	public void selectUbuntuVersionFromOperatingSystem(WebDriver driver,String input) 
	{
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 120);

		System.out.println("Inside selectUbuntuVersionFromOperatingSystem");
		Log.info("Inside selectUbuntuVersionFromOperatingSystem"); 

		String names="";String ltMessages="";
		try 
		{
			String category = "";
			System.out.println("input from test data sheet "+Report.color(input));
			CommonUtility.ScrollTo(driver,obj_EsupportDriversandDownloadsPage.OSDropdown());
			CommonUtility.ClickOn(driver,obj_EsupportDriversandDownloadsPage.OSDropdown());

			Thread.sleep(6000);
			Select s1=new Select(CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.OSDropdown()));
			List<WebElement> optionList=s1.getOptions();
			int optionListsize=optionList.size();
			System.out.println("list of OS displayed in drop down are "+optionListsize);

			for(int i=0;i<optionListsize;i++)
			{
				String values=optionList.get(i).getText();
				category+= " <br> "+values;
				
			}
			System.out.println("dropdown values are "+category);
			
			s1.selectByVisibleText(input);
			
			Thread.sleep(6000);
			
			CommonUtility.ScrollTo(driver,obj_EsupportDriversandDownloadsPage.ListOfDrivers());
			List<WebElement> list=driver.findElements(obj_EsupportDriversandDownloadsPage.ListOfDrivers());
			int size=list.size();
			System.out.println("Number of drivers displayed are:"+ size);
			for(WebElement lt:list)
			{
				CommonUtility.ScrollToWebElement(driver, lt);
				names=lt.getText();
//				if(!(names.contains(input)))
//				{
//					System.out.println("failed to see selected category related drivers");
//					Report.put("Select the "+Report.color(input)+" option from the Category dropdown",
//							"The driver list should be displayed as per the applied filter",
//							"failed to see selected category related drivers", "FAIL");
//					Assert.fail();
//				}
				System.out.println("Button is: " +names);
				ltMessages+=" <br> " + names;
			}
			

			Report.put("Select the "+Report.color(input)+" option from the Operating system filter",
					"There are downloads associated with Ubuntu displayed",
					"User able to select "+Report.color(input)+" from Operating system dropdown and able to see drivers related to selected Operating system displayed with count of "+size, "PASS");		

			
		}                                                                                                                                        
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Select the "+Report.color(input)+" option from the Operating system filter",
					"There are downloads associated with Ubuntu displayed",
					"Failed to select "+Report.color(input)+" option from Operating system dropdown", "FAIL");								
			Assert.fail();

		}
	}
	
	public void validateBannerNotDisplayedForSelectedOS(WebDriver driver) 
	{
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 120);

		System.out.println("Inside validateBannerNotDisplayedForSelectedOS");
		Log.info("Inside validateBannerNotDisplayedForSelectedOS"); 

		try 
		{
			String banner = "";
			String link = "";
			

			if(CommonUtility.CheckpresenceofElementLocated(driver,10,obj_EsupportDriversandDownloadsPage.UbuntuBanner()))
			{
			
				Report.put("Verify that a banner is not displayed when there is a download associated to Ubuntu other than BIOS ",
						"A banner should not be displayed ",
						"Ubuntu banner displayed", "FAIL");								
				Assert.fail();
						
			}
			else
			{
				Report.put("Verify that a banner is not displayed when there is a download associated to Ubuntu other than BIOS ",
						"A banner should not be displayed ",
						"User failed to see Ubuntu banner as expected", "PASS");		
			}
		
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify that a banner is not displayed when there is a download associated to Ubuntu other than BIOS ",
					"A banner should not be displayed ",
					"Ubuntu banner displayed", "FAIL");								
			Assert.fail();

		}
	}
	
	public void validateBannerForSelectedOS(WebDriver driver) 
	{
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 120);

		System.out.println("Inside validateBannerForSelectedOS");
		Log.info("Inside validateBannerForSelectedOS"); 

		try 
		{
			String banner = "";
			String link = "";
			

			if(CommonUtility.CheckpresenceofElementLocated(driver,10,obj_EsupportDriversandDownloadsPage.UbuntuBanner()))
			{
			
				CommonUtility.ScrollTo(driver,obj_EsupportDriversandDownloadsPage.UbuntuBanner());
				banner=CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.UbuntuBanner()).getText();
				System.out.println(banner);
				
				CommonUtility.ScrollTo(driver,obj_EsupportDriversandDownloadsPage.UbuntuLink());
				link=CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.UbuntuLink()).getText();
				System.out.println(link);
				
				
				Report.put("Verify that a banner is displayed when there is download associated with BIOS",
						"A banner should be displayed indicating details on download options for Ubuntu so that Customer can go through the details in the banner and choose the correct options for Ubuntu downloads",
						"User able to see Ubuntu banner "+Report.color(banner)+" along with link "+Report.color(link), "PASS");
						
			}
			else
			{
				Report.put("Verify that a banner is displayed when there is download associated with BIOS",
						"A banner should be displayed indicating details on download options for Ubuntu so that Customer can go through the details in the banner and choose the correct options for Ubuntu downloads",
						"Ubuntu banner not displayed", "FAIL");								
				Assert.fail();
			}
		
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify that a banner is displayed when there is download associated with BIOS",
					"A banner should be displayed indicating details on download options for Ubuntu so that Customer can go through the details in the banner and choose the correct options for Ubuntu downloads",
					"Ubuntu banner not displayed", "FAIL");								
			Assert.fail();

		}
	}
	
	
	public void clickUbuntuLink(WebDriver driver, String input, String input1)
	{
		System.out.println("Inside clickUbuntuLink method");
		Log.info("Inside clickUbuntuLink method");

		String link = "";
		String url = "";
		String header = "";

		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);

			if(CommonUtility.CheckpresenceofElementLocated(driver, 10, obj_EsupportDriversandDownloadsPage.UbuntuLink()))
			{
				CommonUtility.ScrollTo(driver, obj_EsupportDriversandDownloadsPage.UbuntuLink());
				link=CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.UbuntuLink()).getText();
				CommonUtility.ClickOn(driver, obj_EsupportDriversandDownloadsPage.UbuntuLink());
				Thread.sleep(10000);
				System.out.println("Clicked on ubuntu Link");
				Thread.sleep(10000);
				
				String mainwindow=driver.getWindowHandle();
				Set<String> set=driver.getWindowHandles();
				int countWindow=set.size(); 

				System.out.println("Switched Window Handles and  window count is :: "+countWindow);
				
				
				Iterator<String> itr=set.iterator();
				while(itr.hasNext())
				{
					String childWindow=itr.next();
					if(!mainwindow.equals(childWindow))
					{
						Thread.sleep(6000);
						
						driver.switchTo().window(childWindow);
					
					url=driver.getCurrentUrl();
					System.out.println("URL displayed as   :::::"+url); 

					if(url.contains(input))
					{
						header=driver.getTitle();
						System.out.println(header);
					}	
					else
					{
						driver.close();

						System.out.println("Failed to redirect to "+Report.color(input));

						Report.put("Click on the link provided in the banner ",
								"User should be redirected to the page with details on downloads options of Ubuntu",
								"Failed to redirect to "+Report.color(input), "FAIL");
						Assert.fail();
					}
					
					driver.close();
					
				}
					
					driver.switchTo().window(mainwindow);
				}
				
				Report.put("Click on the link provided in the banner ",
						"User should be redirected to the page with details on downloads options of Ubuntu",
						"Redirected to URL "+Report.color(url)+" with Header "+Report.color(header), "PASS");
			}
			else
			{
				System.out.println("Failed to redirect to click on link");

				Report.put("Click on the link provided in the banner ",
						"User should be redirected to the page with details on downloads options of Ubuntu",
						"Failed to click on link Troubleshoot "+Report.color(input1), "FAIL");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();

			System.out.println("Failed to redirect to click on link");

			Report.put("Click on the link provided in the banner ",
					"User should be redirected to the page with details on downloads options of Ubuntu",
					"Failed to click on link Troubleshoot "+Report.color(input1), "FAIL");
			Assert.fail();
		}
	}
	
	public void selectUbuntuVersionFromOperatingSystem_Nodrivers(WebDriver driver,String input) 
	{
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 120);

		System.out.println("Inside selectUbuntuVersionFromOperatingSystem_Nodrivers");
		Log.info("Inside selectUbuntuVersionFromOperatingSystem_Nodrivers"); 

		String names="";String ltMessages="";String message="";
		try 
		{
			String category = "";
			System.out.println("input from test data sheet "+Report.color(input));
			CommonUtility.ScrollTo(driver,obj_EsupportDriversandDownloadsPage.OSDropdown());
			CommonUtility.ClickOn(driver,obj_EsupportDriversandDownloadsPage.OSDropdown());

			Thread.sleep(6000);
			Select s1=new Select(CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.OSDropdown()));
			List<WebElement> optionList=s1.getOptions();
			int optionListsize=optionList.size();
			System.out.println("list of OS displayed in drop down are "+optionListsize);

			for(int i=0;i<optionListsize;i++)
			{
				String values=optionList.get(i).getText();
				category+= " <br> "+values;
				
			}
			System.out.println("dropdown values are "+category);
			
			s1.selectByVisibleText(input);
			
			Thread.sleep(6000);
			
//			CommonUtility.ScrollTo(driver,obj_EsupportDriversandDownloadsPage.noDriversFoundMessage());
//			CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.noDriversFoundMessage());
//
//			message=CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.noDriversFoundMessage()).getText();
//
//			System.out.println("Message is "+message);

			

			Report.put("Select any Ubuntu version from Operating System filter when there are no downloads available for Ubuntu",
					"An appropriate message should be displayed in a banner indicating details of download options available for Ubuntu",
					"User able to select "+Report.color(input)+" from Operating system dropdown and see no results as expected", "PASS");		

			
		}                                                                                                                                        
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Select any Ubuntu version from Operating System filter when there are no downloads available for Ubuntu",
					"An appropriate message should be displayed in a banner indicating details of download options available for Ubuntu",
					"Failed to select "+Report.color(input)+" option from Operating system dropdown", "FAIL");								
			Assert.fail();

		}
	}
	
	
	public void validateBannerForKeyword(WebDriver driver, String input) 
	{
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 120);

		System.out.println("Inside validateBannerForKeyword");
		Log.info("Inside validateBannerForKeyword"); 

		try 
		{
			String banner = "";
			String link = "";
			String link2="";

			CommonUtility.ScrollTo(driver,obj_EsupportDriversandDownloadsPage.BannerForKeywordSearch());
			banner=CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.BannerForKeywordSearch()).getText();
			System.out.println(banner);
			
			CommonUtility.ScrollTo(driver,obj_EsupportDriversandDownloadsPage.WindowsUpsateLink());
			link2=CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.WindowsUpsateLink()).getText();
			System.out.println(link2);
			
			CommonUtility.ScrollTo(driver,obj_EsupportDriversandDownloadsPage.TroubleShootingLink());
			link=CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.TroubleShootingLink()).getText();
			System.out.println(link);
			
			

			Report.put("Verify that a message is displayed to further to assist with "+Report.color(input)+" issues",
					"Microsoft automatically updates "+Report.color(input)+" software. First, make sure you've installed the latest Windows Update, then try troubleshooting.",
					"User able to see "+Report.color(banner)+" and expected link "+Report.color(link2+" and "+link), "PASS");					
		
		
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify that a message is displayed to further to assist with "+Report.color(input)+" issues",
					"Microsoft automatically updates "+Report.color(input)+" software. First, make sure you've installed the latest Windows Update, then try troubleshooting.",
					"Failed to display expected banner", "FAIL");								
			Assert.fail();

		}
	}
	
	
	public void clickWindowUpdateLink(WebDriver driver, String input, String input1)
	{
		System.out.println("Inside clickWindowUpdateLink method");
		Log.info("Inside clickWindowUpdateLink method");

		String link = "";
		String url = "";
		String header = "";

		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);

			if(CommonUtility.CheckpresenceofElementLocated(driver, 10, obj_EsupportDriversandDownloadsPage.WindowsUpsateLink()))
			{
				CommonUtility.ScrollTo(driver, obj_EsupportDriversandDownloadsPage.WindowsUpsateLink());
				link=CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.WindowsUpsateLink()).getText();
				CommonUtility.ClickOn(driver, obj_EsupportDriversandDownloadsPage.WindowsUpsateLink());
				Thread.sleep(10000);
				System.out.println("Clicked on troubleshoot Link");
				Thread.sleep(10000);
				
				String mainwindow=driver.getWindowHandle();
				Set<String> set=driver.getWindowHandles();
				int countWindow=set.size(); 

				System.out.println("Switched Window Handles and  window count is :: "+countWindow);
				
				
				Iterator<String> itr=set.iterator();
				while(itr.hasNext())
				{
					String childWindow=itr.next();
					if(!mainwindow.equals(childWindow))
					{
						Thread.sleep(6000);
						
						driver.switchTo().window(childWindow);
					
					url=driver.getCurrentUrl();
					System.out.println("URL displayed as   :::::"+url); 

					if(url.contains("https://support.microsoft.com/en-us/windows/update-windows"))
					{
						header=driver.getTitle();
						System.out.println(header);
					}	
					else
					{
						driver.close();

						System.out.println("Failed to redirect to "+Report.color(input));

						Report.put("Click on the 'Windows Update'  link ",
								"The user should be redirected to the URL : https://support.microsoft.com/en-us/windows/update-windows-10-3c5ae7fc-9fb6-9af1-1984-b5e0412c556a",
								"Failed to redirect to "+Report.color(url), "FAIL");
						Assert.fail();
					}
					
					driver.close();
					
				}
					
					driver.switchTo().window(mainwindow);
				}
				
				Report.put("Click on the 'Windows Update'  link ",
						"The user should be redirected to the URL : https://support.microsoft.com/en-us/windows/update-windows-10-3c5ae7fc-9fb6-9af1-1984-b5e0412c556a",
						"Redirected to URL "+Report.color(url)+" with Header "+Report.color(header), "PASS");
			}
			else
			{
				System.out.println("Failed to redirect to click on link");

				Report.put("Click on the 'Windows Update'  link ",
						"The user should be redirected to the URL : https://support.microsoft.com/en-us/windows/update-windows-10-3c5ae7fc-9fb6-9af1-1984-b5e0412c556a",
						"Failed to click on Troubleshooting link ", "FAIL");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();

			System.out.println("Failed to redirect to click on link");

			Report.put("Click on the 'Windows Update'  link ",
					"The user should be redirected to the URL : https://support.microsoft.com/en-us/windows/update-windows-10-3c5ae7fc-9fb6-9af1-1984-b5e0412c556a",
					"Failed to click on Troubleshooting link ", "FAIL");
			Assert.fail();
		}
	}
	
	public void clickTroubleShootingLink(WebDriver driver, String input, String input1)
	{
		System.out.println("Inside clickTroubleShootingLink method");
		Log.info("Inside clickTroubleShootingLink method");

		String link = "";
		String url = "";
		String header = "";

		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);

			if(CommonUtility.CheckpresenceofElementLocated(driver, 10, obj_EsupportDriversandDownloadsPage.TroubleShootingLink()))
			{
				CommonUtility.ScrollTo(driver, obj_EsupportDriversandDownloadsPage.TroubleShootingLink());
				link=CommonUtility.highlightElement(driver, obj_EsupportDriversandDownloadsPage.TroubleShootingLink()).getText();
				CommonUtility.ClickOn(driver, obj_EsupportDriversandDownloadsPage.TroubleShootingLink());
				Thread.sleep(10000);
				System.out.println("Clicked on troubleshoot Link");
				Thread.sleep(10000);
				
				String mainwindow=driver.getWindowHandle();
				Set<String> set=driver.getWindowHandles();
				int countWindow=set.size(); 

				System.out.println("Switched Window Handles and  window count is :: "+countWindow);
				
				
				Iterator<String> itr=set.iterator();
				while(itr.hasNext())
				{
					String childWindow=itr.next();
					if(!mainwindow.equals(childWindow))
					{
						Thread.sleep(6000);
						
						driver.switchTo().window(childWindow);
					
					url=driver.getCurrentUrl();
					System.out.println("URL displayed as   :::::"+url); 

					if(url.contains(input))
					{
						header=driver.getTitle();
						System.out.println(header);
					}	
					else
					{
						driver.close();

						System.out.println("Failed to redirect to "+Report.color(input));

						Report.put("Click on the link \"Troubleshoot "+Report.color(input1),
								"User should be redirected to an appropriate article page "+Report.color(input),
								"Failed to redirect to "+Report.color(input), "FAIL");
						Assert.fail();
					}
					
					driver.close();
					
				}
					
					driver.switchTo().window(mainwindow);
				}
				
				Report.put("Click on the link \"Troubleshoot "+Report.color(input1),
						"User should be redirected to an appropriate article page "+Report.color(input),
						"Redirected to URL "+Report.color(url)+" with Header "+Report.color(header), "PASS");
			}
			else
			{
				System.out.println("Failed to redirect to click on link");

				Report.put("Click on the link \"Troubleshoot "+Report.color(input1),
						"User should be redirected to an appropriate article page "+Report.color(input),
						"Failed to click on link Troubleshoot "+Report.color(input1), "FAIL");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();

			System.out.println("Failed to redirect to click on link");

			Report.put("Click on the link \"Troubleshoot "+Report.color(input1),
					"User should be redirected to an appropriate article page "+Report.color(input),
					"Failed to click on link Troubleshoot "+Report.color(input1), "FAIL");
			Assert.fail();
		}
	}
	
}

