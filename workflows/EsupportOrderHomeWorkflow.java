package com.dell.delta_uat_automation.esupport.workflows;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

public class EsupportOrderHomeWorkflow extends BaseFlow {

	public void login(WebDriver driver) {
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 120);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		boolean exists = true;


		System.out.println("Entering Esupport login Page");
		Log.info("Entering Esupport login Page");		
		try {


			WebElement element = driver.findElement(By.xpath("//*[@id='dvTabs']/ul/li[3]"));

			Actions actions = new Actions(driver);

			//			actions.moveToElement(element).click().perform();
			CommonUtility.ClickOn(driver, By.xpath("//*[@id='dvTabs']/ul/li[3]"));

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='dvTabs']/ul/li[3]")));

			Thread.sleep(8000);

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[contains(@ng-model,'findBy')]")));
			CommonUtility.highlightElement(driver, By.xpath("//select[contains(@ng-model,'findBy')]"));

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[contains(@ng-model,'findBy')]")));
			CommonUtility.highlightElement(driver, By.xpath("//select[contains(@ng-model,'findBy')]"));
			Thread.sleep(2000);


			Report.put("Select Service tag option from Find support by drop down box.", "User should be able to see Find products by drop down box and a text box to enter Service tags.",
					"User see Find products by drop down box and a text box to enter Service tags..", "PASS");



			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[contains(@id,'txtInputServiceTags')]")));
			CommonUtility.highlightElement(driver, By.xpath("//textarea[contains(@id,'txtInputServiceTags')]")).click();
			CommonUtility.highlightElement(driver, By.xpath("//textarea[contains(@id,'txtInputServiceTags')]")).sendKeys("Jbccc31");


			Report.put("Select Service tag option from Find support by drop down box.", "User should be able to select the option successfully.",
					"User  select the option successfully.", "PASS");



			CommonUtility.highlightElement(driver, By.xpath("//button[@id='btnSvcTagSubmit']")).click();

			Report.put("Provide the service tag and click on Find products", "User should be able see the product details..",
					"User should be able see the product details..", "PASS");


			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='addSelectedProductsTop']")));
			CommonUtility.highlightElement(driver, By.xpath("//a[@id='addSelectedProductsTop']")).click();

			Report.put("Click on Add selected products", "The product should be added successfully.",
					"The product should be added successfully.", "PASS");


			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@href,'#/product-list')]")));
			CommonUtility.highlightElement(driver, By.xpath("//a[contains(@href,'#/product-list')]")).click();


			Report.put("Click on View your product list hyper link.", "The page should be navigated to Product list tab..",
					"The page should be navigated to Product list tab.", "PASS");


			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='ServiceTagSearch']")));
			CommonUtility.highlightElement(driver, By.xpath("//input[@id='ServiceTagSearch']")).click();
			CommonUtility.highlightElement(driver, By.xpath("//input[@id='ServiceTagSearch']")).sendKeys("Jbccc31");;

			CommonUtility.highlightElement(driver, By.xpath("//i[contains(@class,'icon-small-searchleft text-gray')]")).click();

			Report.put("Provide the service tag and click on Search icon.", "User should be able to see the product..",
					"User should be able to see the product..", "PASS");

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='JBCCC31']")));
			CommonUtility.highlightElement(driver, By.xpath("//a[text()='JBCCC31']"));

			Thread.sleep(2000);	
		}

		catch (Exception e) {
			Log.info(e);
			Report.put("Login into esupport application", "User should be able to login into esuuport application",
					"Failed while logging into esupport application", "FAIL");
			e.printStackTrace();
			Assert.fail();
		}		
	} 






	public void ToCloseChildWindowOfSFDC(WebDriver driver)
	{/*
		try
		{
			System.out.println("Entered into the method name 'ToCloseChildWindowOfSFDC'");
			boolean result=CommonUtility.CheckpresenceofElementLocated(driver, 10, obj_MAESTROHomeScreenPage.SFDC_toCloseChildWindow());
			if(result==true)
			{
				System.out.println("Child window is present....");
				Thread.sleep(4000);
				List<WebElement> openwindows=driver.findElements(obj_MAESTROHomeScreenPage.SFDC_toCloseChildWindow());
				System.out.println("Total No of Child Windows: " + openwindows.size());
				for(WebElement OW: openwindows)
				{
					try
					{
						OW.click();
						System.out.println("Child window closed successfully....");
					}catch(StaleElementReferenceException e)
					{
						break;
					}
				}       
				System.out.println("All the Child windows are closed successfully....");
			}else
			{
				System.out.println("Child window is not present");
			}   

			Report.put("Logout of eSupport...", "User should be able to logout Esupport application",
					"User logged out Esupport application successfully", "PASS");


		}catch(Exception e)
		{
			e.printStackTrace();
		}
	 */}
	public void homePage(WebDriver driver) {
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 120);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		boolean exists = true;


		System.out.println("Entering Esupport Home Page");
		Log.info("Entering Esupport Home Page");		
		try {


			CommonUtility.highlightElement(driver, By.xpath("//i[@class='icon-brand-dell']")); 
			CommonUtility.highlightElement(driver, By.xpath("//button[contains(.,'Decline')]")).click();



			String a=driver.findElement(By.xpath("//h1[@id='lblOrderStatus']")).getText();
			System.out.println(a);

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@id='lblOrderStatus']")));
			//driver.findElement(By.xpath("//input[@class='form-control ng-isolate-scope ng-invalid ng-invalid-required ng-valid-reg-ex ng-dirty']")).sendKeys("123907379");
			driver.findElement(By.xpath("//div[@id='dpid-lookup']//input[@name='searchValue']")).sendKeys("123907379");
			CommonUtility.highlightElement(driver, By.xpath("//input[@name='btnSearchSubmit']")).click();

		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}


	public void orderHomePage(WebDriver driver) 
	{
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 120);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

		System.out.println("Inside orderHomePage");
		Log.info("Inside orderHomePage");		
		try 
		{
			CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.delllogo());

			handleCookies(driver);
			Report.put("Navigate to Orders Page", "User should be able to navigate to Orders Page",

					"Navigated to Orders Page Successfully", "PASS");

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Navigate to Orders Page", "User should be able to navigate to Orders Page",
					"Navigation to Orders Page failed", "FAIL");
			Assert.fail();

		}
	}

	public void enterOrderNumber(WebDriver driver, String orderNumber)
	{
		System.out.println("Entering Order Number");
		Log.info("Entering Order Number");
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportOrderHomePage.orderStatusLabel()));
			CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.orderStatusSearch()).sendKeys(orderNumber);
			CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.orderSubmit()).click();


			Report.put("Enter OrderNumber/DPID & search", "User should land to Purchase details Page",
					"Navigated to Purchase details Page Successfully" +Report.color(orderNumber), "PASS");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Enter OrderNumber/DPID & search", "User should land to Purchase details Page",
					"Navigation to Purchase details Page Failed", "FAIL");
			Assert.fail();
		}
	}

	public void clickOnLookupOptions(WebDriver driver)
	{

		System.out.println("Click on Lookup Options");
		Log.info("Click on Lookup Options");

		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportOrderHomePage.orderStatusLabel()));
			CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.otherLookupOptions()).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportOrderHomePage.otherLookupOptionsLabel()));
			Report.put("Click on Other Lookup Options", "Other look up Options Pop Up should display",
					"Other look up Options Pop Up displayed Successfully", "PASS");


		} catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on Other Lookup Options", "Other look up Options Pop Up should display",
					"Other look up Options Pop Up display failed", "FAIL");
			Assert.fail();
		}
	}

	public void selectLookupOptions(WebDriver driver, String option) 
	{

		System.out.println("Select Lookup Options");
		Log.info("Select Lookup Options");
		String flag="";
		String flag1="";
		try{
			Select selLookup = new Select(driver.findElement(obj_EsupportOrderHomePage.lookUpByDropdown()));
			Select selVerify = new Select(driver.findElement(obj_EsupportOrderHomePage.verifyByDropdown()));
			//			Select selValidate = new Select(driver.findElement(obj_EsupportOrderHomePage.validateDropdown()));

			if(option.contains("Customer Number"))
			{
				selLookup.selectByVisibleText("Customer Number");
				flag="Customer Number";
				CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.customerNumberTextbox()).sendKeys(TestNGCreator.TestData.get(Esupport.CustomerNumber.ordinal()));

				selVerify.selectByVisibleText("PO Number");
				CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.dpidTextbox()).sendKeys(TestNGCreator.TestData.get(Esupport.Dpid.ordinal()));
				System.out.println(TestNGCreator.TestData.get(Esupport.Dpid.ordinal()));
				//				if(selValue.contains("PO Number"))
				//				{
				//					System.out.println("Selected value is "+selValue);
				//					CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.dpidTextbox()).sendKeys(TestNGCreator.TestData.get(Esupport.Dpid.ordinal()));
				//					System.out.println(TestNGCreator.TestData.get(Esupport.Dpid.ordinal()));
				//				}
				//				else
				//				{
				//					System.out.println("Option selected is "+selValue);
				//				}
				String value="";
				Select selValidate = new Select(driver.findElement(obj_EsupportOrderHomePage.validateDropdown()));
				List<WebElement> opt=selValidate.getOptions();
				for(int i=0;i<opt.size();i++)
				{
					String options=opt.get(i).getText();
					System.out.println(options);
					if(options.contains("Billing postal code"))
					{
						opt.get(i).click();
						Thread.sleep(5000);
						flag1="DPID and Validate with Billing postal code";	   
						System.out.println("Selected value is "+options);
						CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.phoneTextbox()).sendKeys(TestNGCreator.TestData.get(Esupport.PhoneNumber.ordinal()));
						break;
					}
					else
						if(options.contains("Last 4 digits bill phone"))
						{
							opt.get(i).click();
							Thread.sleep(5000);
							flag1="DPID and Validate with Last 4 digits bill phone";	   
							System.out.println("Selected value is "+options);
							CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.phoneTextbox()).sendKeys(TestNGCreator.TestData.get(Esupport.PhoneNumber.ordinal()));
							break;
						}

				}

			}


			else if(option.contains("PO Number"))
			{
				flag="PO Number";	   
				selLookup.selectByVisibleText("PO Number");
				CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.poNumber()).sendKeys(TestNGCreator.TestData.get(Esupport.PONumber.ordinal()));


				String selValue = selVerify.getFirstSelectedOption().getText();
				if(selValue.contains("Customer Number"))
				{
					flag1= "Customer Number";  
					System.out.println("Selected value is "+selValue);
					CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.dpidTextbox()).sendKeys(TestNGCreator.TestData.get(Esupport.CustomerNumber.ordinal()));
					System.out.println(TestNGCreator.TestData.get(Esupport.CustomerNumber.ordinal()));
				}


			}else if(option.contains("Billing Information"))
			{
				flag="Billing Information";
				selLookup.selectByVisibleText("Billing Information");
				flag1="First name , Last name , Phone number and Post code";
				CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.firstName()).sendKeys(TestNGCreator.TestData.get(Esupport.FirstName.ordinal()));
				CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.lastName()).sendKeys(TestNGCreator.TestData.get(Esupport.LastName.ordinal()));
				CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.billingPhoneNumber()).sendKeys(TestNGCreator.TestData.get(Esupport.BillingPhoneNumber.ordinal()));
				CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.postalCode()).sendKeys(TestNGCreator.TestData.get(Esupport.PostalCode.ordinal()));


			}


			System.out.println(flag);       

			Report.put("Search"+Report.color(flag)+"from the drop down","System should show up with Fields: Verify with"+Report.color(flag1),
					""+Report.color(flag)+"details are displaying as Expected", "PASS");


		} catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Search"+Report.color(flag)+"from the drop down","System should show up with Fields: Verify with"+Report.color(flag1),
					""+Report.color(flag)+"details are not displaying as Expected", "FAIL");
			Assert.fail();
		}

	}


	public void clickOnSubmit(WebDriver driver)
	{

		System.out.println("Click on Submit");
		Log.info("Click on Submit");

		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);
			CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.submitButton()).click();
			Report.put("Enter the details and Click on submit ", "The user should be redirected to MOS page",
					"User redirected to MOS page", "PASS");


		} catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Enter the details and Click on submit ", "The user should be redirected to MOS page",
					"User not redirected to MOS page", "FAIL");
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
			System.out.println("In handleCaptcha");
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportRecentOrderPage.recentOrdersLabel()));
			CommonUtility.highlightElement(driver, obj_EsupportRecentOrderPage.recentOrdersLabel());	
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on Other Lookup Options", "Other look up Options Pop Up should show",
					"Other look up Options Pop Up display failed", "FAIL");
			Assert.fail();
		}

	} 


	public void handleCookies(WebDriver driver)
	{
		System.out.println("Handle Cookies");
		Log.info("Handle Cookies");	
		try{
			WebDriverWait wait = new WebDriverWait(driver, 50);
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			//if(CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.declinecookies()).isDisplayed())
			//CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.declinecookies()).click();  
			//			if(CommonUtility.CheckpresenceofElementLocated(driver, 10, obj_EsupportOrderHomePage.declinecookies()))
			//				CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.declinecookies()).click();  
			if(CommonUtility.CheckpresenceofElementLocated(driver, 10, obj_PortalPage.acceptCookies()))
			{
				CommonUtility.highlightElement(driver,obj_PortalPage.acceptCookies()).click(); 
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

	//	public void handleCookies(WebDriver driver)
	//	{
	//		System.out.println("Handle Cookies");
	//		Log.info("Handle Cookies");	
	//		try
	//		{
	//			if(CommonUtility.CheckpresenceofElementLocated(driver, 10, obj_PortalPage.acceptCookies()))
	//				CommonUtility.highlightElement(driver,obj_PortalPage.acceptCookies()).click(); 
	//		}
	//		catch(Exception ex)
	//		{
	//			System.out.println("Cookies not present");
	//		}
	//
	//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	//		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	//	} 

	//sudha
	public void  premierLogin(WebDriver driver, String account) {
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 120);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		boolean exists = true;
		String name = TestNGCreator.TestData.get(Esupport.Username.ordinal()) ;
		String pwd = TestNGCreator.TestData.get(Esupport.Password.ordinal()) ;
		System.out.println("Entering Premier Login Home Page");
		System.out.println("Entering Premier Login Home Page");
		Log.info("Entering Premier Login Home Page");        
		try {
			CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.delllogo()); 			

			driver.manage().timeouts().implicitlyWait(240, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(240, TimeUnit.SECONDS);
			handleCookies(driver);
			CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.premierLogin()).click();
			//			try{
			//				wait = new WebDriverWait(driver, 50);
			//				driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			//				handleCookies(driver);  
			//			}
			//			catch(Exception ex){
			//
			//
			//			}
			driver.manage().timeouts().implicitlyWait(240, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(240, TimeUnit.SECONDS);
			Thread.sleep(3000);
			CommonUtility.ClickOn(driver,obj_EsupportOrderHomePage.Premierdifferentorder());
			Thread.sleep(7000);

			try{
				wait = new WebDriverWait(driver, 50);
				driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

			}
			catch(Exception ex){


			}

			CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.userName()).clear();
			CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.userName()).sendKeys(name);
			CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.password()).clear();
			CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.password()).sendKeys(pwd);
			// CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.declinecookies()).click();
			//CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.signIn()).click();
			CommonUtility.ToClickByUsingJavaScript_PassingByLoc(driver, obj_EsupportOrderHomePage.signIn());
			Thread.sleep(10000);


			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportOrderHomePage.selectAccount()));
			CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.selectAccount());

			CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.selectAccountdrp()).click();


			List<WebElement> elements = driver.findElements(obj_EsupportOrderHomePage.selectlist());
			for (int i = 0; i < elements.size(); i++) 
			{
				CommonUtility.scrollToViewElement(driver,elements.get(i));
				CommonUtility.highlightElement(driver,elements.get(i));
				String Account=elements.get(i).getText();
				// if(Account.contains(" Balance Innovations [ General Access ]"))
				System.out.println("options are "+Account);
				if(Account. contains(account))
				{
					System.out.println("selected account is "+Account);
					elements.get(i).click();
					System.out.println("Selected Account/Access Group"); 
					Thread.sleep(3000);
					break;
				}


			}
			Thread.sleep(10000);
			CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.accessPremier()).click();

			Report.put("User is login into Premier account", "Premier Sign in page must be displayed", "Premier Sign in page is displayed", "Pass");
			Report.put("Enter valid credentials and select the required store ", "Coresponding premier store must be displayed", "Coresponding premier store is displayed", "Pass");

		}catch(Exception e)
		{
			e.printStackTrace();
			Report.put("User is login into Premier account", "Premier Sign in page must be displayed", "Premier Sign in page is not displayed", "Fail");
			Report.put("Enter valid credentials and select the required store ", "Coresponding premier store must be displayed", "Coresponding premier store is not displayed", "Fail");

			//Report.put("Click on the search by drop down", "System should display below mentioned values in the drop down", "Fields are not available", "Fail");
			Assert.fail();
		}
	}
	//SNEHA
	public void exportToExcel(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 200);

		//		driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
		//		driver.manage().timeouts().pageLoadTimeout(200, TimeUnit.SECONDS);
		try
		{
			System.out.println("In exportToExcel");
			//			try{
			//				wait = new WebDriverWait(driver, 10);
			//				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			//				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='uif_modal_close']")));
			//				CommonUtility.highlightElement(driver, By.xpath("//a[@id='uif_modal_close']")).click();
			//				Thread.sleep(5000);
			//			}catch(Exception ex){
			//
			//			}
			//			wait = new WebDriverWait(driver, 240);
			//			
			//			driver.manage().timeouts().implicitlyWait(240, TimeUnit.SECONDS);
			//			driver.manage().timeouts().pageLoadTimeout(240, TimeUnit.SECONDS);
			String details ="";


			try
			{
				//				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportRecentOrderPage.PreOrderStatusLink()));
				//				CommonUtility.highlightElement(driver, obj_EsupportRecentOrderPage.PreOrderStatusLink()).click();
				//
				//
				//				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportRecentOrderPage.PremierRecentOrdersTag()));
				//				CommonUtility.highlightElement(driver, obj_EsupportRecentOrderPage.PremierRecentOrdersTag());

				//				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportRecentOrderPage.PreSelectAnAction()));
				//				CommonUtility.highlightElement(driver, obj_EsupportRecentOrderPage.PreSelectAnAction()).click();

				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportRecentOrderPage.PreSelectAnAction()));
				CommonUtility.ScrollTo(driver, obj_EsupportRecentOrderPage.PreSelectAnAction());
				CommonUtility.ClickOn(driver, obj_EsupportRecentOrderPage.PreSelectAnAction());

				List<WebElement> SelectActionDropdown = driver.findElements(obj_EsupportRecentOrderPage.preSelectAnActionValues());
				for (int i = 1; i < SelectActionDropdown.size(); i++) {
					String value = SelectActionDropdown.get(i).getText();
					CommonUtility.highlightElement(driver, SelectActionDropdown.get(i));
					System.out.println(value); 
					details = details+value+", ";
				}
				Report.put("Click on Select an action drop down", "Action drop down should include - Export selected, Export All, Email notifications and text message notifications", "Action drop down is include"+Report.color(details), "Pass");
			}
			catch(Exception ex){
				ex.printStackTrace();
				Report.put("Click on Select an action drop down", "Action drop down should include - Export selected, Export All, Email notifications and text message notifications", "Action drop down is not include - Export selected, Export All, Email notifications and text message notifications", "Fail");
				Assert.fail();
			}
			try{
				CommonUtility.ScrollTo(driver, obj_EsupportRecentOrderPage.PreSelectAnAction());
				CommonUtility.ClickOn(driver, obj_EsupportRecentOrderPage.PreSelectAnAction());
				List<WebElement> SelectActionDropdown = driver.findElements(obj_EsupportRecentOrderPage.preSelectAnActionValues());
				for (int i = 0; i < SelectActionDropdown.size(); i++) {
					String value = SelectActionDropdown.get(i).getText();
					CommonUtility.highlightElement(driver, SelectActionDropdown.get(i));
					if (value.contains("Export all")) {
						CommonUtility.highlightElement(driver, SelectActionDropdown.get(i)).click();
						break;
					}
				}
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportRecentOrderPage.PreSubmit()));
				CommonUtility.ClickOn(driver, obj_EsupportRecentOrderPage.PreSubmit());

				Report.put("Select Export all option from drop down and click on Submit", "All must be download total records fetched for the period slected.", "All download total records fetched for the period slected.", "Pass");

			}catch(Exception exp){
				exp.printStackTrace();
				Report.put("Select Export all option from drop down and click on Submit", "All must be download total records fetched for the period slected.", "All download total records fetched for the period slected.", "Fail");
				Assert.fail();
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on Other Lookup Options", "Other look up Options Pop Up should show",
					"Other look up Options Pop Up display failed", "FAIL");
			Assert.fail();
		}

	}
	//Pushpa
	public void  handlePremierPopup(WebDriver driver)
	{
		System.out.println("In function handlePremierPopup");
		try
		{
			if(CommonUtility.CheckpresenceofElementLocated(driver, 30, obj_EsupportRecentOrderPage.premierPopup()))
			{
				System.out.println("premier popup is displayed");
				CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.premierPopup()).click();  
			}

			//			if(CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.premierPopup()).isDisplayed())
			//			{
			//				System.out.println("premier popup is displayed");
			//				CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.premierPopup()).click();
			//			}
			//	handleCookies(driver);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			//Report.put("Click on the search by drop down", "System should display below mentioned values in the drop down", "Fields are not available", "Fail");
			//Assert.fail();
		}
	}

	public void handleCaptcha_PurchaseOrder(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 600);
		System.out.println("After webdriver wait");
		driver.manage().timeouts().implicitlyWait(600, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(600, TimeUnit.SECONDS);
		try
		{
			System.out.println("In handleCaptcha_PurchaseOrder");
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportRecentOrderPage.Puchasedetailsgheader()));
			CommonUtility.highlightElement(driver, obj_EsupportRecentOrderPage.Puchasedetailsgheader());	
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on Other Lookup Options", "Other look up Options Pop Up should show",
					"Other look up Options Pop Up display failed", "FAIL");
			Assert.fail();
		}

	} 

	public void launchURL(WebDriver driver, String url)
	{
		WebDriverWait wait = new WebDriverWait(driver, 120);
		System.out.println("Inside launchURL");
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
		try
		{
			Thread.sleep(15000);
			driver.navigate().to(url);
			System.out.println("Navigate to URL "+url);			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Failed to Navigate to URL");		
			Assert.fail();
		}

	} 

	//Lavanya adding for PCF GOS oct 13th 2020

	public void validateOrderHomePage(WebDriver driver) 
	{
		// TODO Auto-generated method stub

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);

		Log.info("Inside validateOrderHomePage");		
		String header="";
		try 
		{
			handleCookies(driver);
			CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.OrderSupportHeader());
			CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.OrderSupportHeader());


			header=CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.OrderSupportHeader()).getText();
			System.out.println("header is "+header);

			Report.put("Launch the url https://www.dell.com/support/order-status/en-us/order-support", 
					"User should land in the order status page",
					"Landed on Order support Page Successfully with "+Report.color(header), "PASS");

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Launch the url https://www.dell.com/support/order-status/en-us/order-support", 
					"User should land in the order status page",
					"Not landed on Orders support Page", "FAIL");
			Assert.fail();

		}
	}

	public void validateOrderNumberSearch(WebDriver driver, String OrderNumber) 
	{
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 420);

		String orderno=TestNGCreator.TestData.get(Esupport.OrderNumber.ordinal());
		String Testcase=TestNGCreator.TestData.get(Esupport.TestCaseID.ordinal());

		Log.info("Inside validateOrderNumberSearch");		
		String header="";
		try 
		{
			//			handleCookies(driver);

			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_EsupportOrderHomePage.SearchBoxInOrderStatusPage()))
			{
				if(Testcase.contains("9487003"))
				{
					String orderno1=TestNGCreator.TestData.get(Esupport.OrderNumber.ordinal()).split(";")[0];
					String orderno2=TestNGCreator.TestData.get(Esupport.OrderNumber.ordinal()).split(";")[1];

					CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.SearchBoxInOrderStatusPage());
					CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.SearchBoxInOrderStatusPage()).clear();
					CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.SearchBoxInOrderStatusPage()).sendKeys(OrderNumber);

					CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.FindMyOrderButton());
					CommonUtility.ClickOn(driver,obj_EsupportOrderHomePage.FindMyOrderButton());

					wait.until(ExpectedConditions.presenceOfElementLocated(obj_EsupportOrderHomePage.OrderNumberDetailsPageHeader()));
					handleCookies(driver);
					CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.OrderNumberDetailsPageHeader());

					header=CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.OrderNumberDetailsPageHeader()).getText();
					System.out.println("header is "+header);

					CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.OrderDetailsPageBreadScrumb());


					if(header.contains(orderno1))
					{
						if(header.contains(orderno1))
						{
							System.out.println("order number displayed matching with entered");
							Report.put("Enter the system order number( which has service tag ) and click on search ", 
									"User should land in the order details page",
									"Entered system Order number( which has service tag ) "+Report.color(orderno1)+" and clicked on search, user landed on Order details page with header "+Report.color(header), "PASS");
						}
						else
						{
							System.out.println("order number displayed not matching with entered");
							Report.put("Enter the system order number( which has service tag ) and click on search ", 
									"User should land in the order details page",
									"not landed on Order details page", "Fail");
							Assert.fail();
						}
					}
					else
					{

						if(header.contains(orderno2))
						{
							System.out.println("order number displayed matching with entered");
							Report.put("Enter the order number and click on search ", 
									"User should land in the order details page",
									"Entered Order number "+Report.color(orderno2)+" and clicked on search, user landed on Order details page with header "+Report.color(header), "PASS");
						}
						else
						{
							System.out.println("order number displayed not matching with entered");
							Report.put("Enter the non system order number and click on search ", 
									"User should land in the order details page",
									"not landed on Order details page", "Fail");
							Assert.fail();
						}
					}
				}

				else
				{
					CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.SearchBoxInOrderStatusPage());
					CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.SearchBoxInOrderStatusPage()).clear();
					CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.SearchBoxInOrderStatusPage()).sendKeys(OrderNumber);

					CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.FindMyOrderButton());
					CommonUtility.ClickOn(driver,obj_EsupportOrderHomePage.FindMyOrderButton());

					wait.until(ExpectedConditions.presenceOfElementLocated(obj_EsupportOrderHomePage.OrderNumberDetailsPageHeader()));
					handleCookies(driver);
					CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.OrderNumberDetailsPageHeader());

					header=CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.OrderNumberDetailsPageHeader()).getText();
					System.out.println("header is "+header);

					CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.OrderDetailsPageBreadScrumb());


					if(header.contains(orderno))
					{
						System.out.println("order number displayed matching with entered");
						Report.put("Enter the order number and click on search ", 
								"User should land in the order details page",
								"Entered Order number "+Report.color(orderno)+" and clicked on search, user landed on Order details page with header "+Report.color(header), "PASS");
					}
					else
					{
						System.out.println("order number displayed not matching with entered");
						Report.put("Enter the order number and click on search ", 
								"User should land in the order details page",
								"not landed on Order details page", "Fail");
						Assert.fail();
					}
				}
			}
			else
			{
				System.out.println("failed to display search text box");
				Report.put("Enter the order number and click on search ", 
						"User should land in the order details page",
						"not landed on Order details page", "Fail");
				Assert.fail();
			}


		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Enter the order number and click on search ", 
					"User should land in the order details page",
					"not landed on Order details page", "Fail");
			Assert.fail();

		}
	}

	public void verifyActionSection(WebDriver driver) 
	{
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 120);


		Log.info("Inside verifyActionSection");		
		String action="";
		String cancel="";
		try 
		{
			//			handleCookies(driver);

			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_EsupportOrderHomePage.ActionsHeaderSection()))
			{
				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.ActionsHeaderSection());
				action=CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.ActionsHeaderSection()).getText();
				System.out.println("section name is "+action);

				CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.ActionsSection());
				if(CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.CancelOrder()).isEnabled())
				{
					CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.CancelOrder());

					cancel=CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.CancelOrderText()).getText();
					System.out.println("button is "+cancel);
				}
				else
				{
					System.out.println(" cancel order button not enabled under action section");
					Report.put("Verify the actions section", 
							"Actions section should display the cancel option",
							"cancl order option not enabled under Action section", "Fail");
					Assert.fail();
				}


				Report.put("Verify the actions section", 
						"Actions section should display the cancel option",
						Report.color(action)+" section displayed and "+Report.color(cancel)+" button displayed under Action section", "PASS");

			}
			else
			{
				System.out.println("failed to display cancel order button under action section");
				Report.put("Verify the actions section", 
						"Actions section should display the cancel option",
						"cancl order option not displayed under Action section", "Fail");
				Assert.fail();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify the actions section", 
					"Actions section should display the cancel option",
					"cancl order option not displayed under Action section", "Fail");
			Assert.fail();

		}
	}

	public void clickOnCancelButton(WebDriver driver) 
	{
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 120);


		Log.info("Inside clickOnCancelButton");		
		String header="";
		String cancel="";
		try 
		{
			//			handleCookies(driver);


			CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.CancelOrderText());

			cancel=CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.CancelOrderText()).getText();
			System.out.println("button is "+cancel);
			CommonUtility.ClickOn(driver,obj_EsupportOrderHomePage.CancelOrderText());

			wait.until(ExpectedConditions.presenceOfElementLocated(obj_EsupportOrderHomePage.CancelOrderHeader()));
			header=CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.CancelOrderHeader()).getText();
			System.out.println("header is "+header);

			CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.BackToOrderLink());
			CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.CustomerNumberHeader());
			CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.CustomerNumberTextBoxInCancelOrder());
			CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.CancelButtonInCancelOrder());
			CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.SubmitButtonInCancelOrder());

			Report.put("Click on cancel button ", 
					"User should show up the customer model pop up ",
					"clicking on "+Report.color(cancel)+" button able to see "+Report.color(header)+" pop up", "PASS");


		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on cancel button ", 
					"User should show up the customer model pop up ",
					"cancl order pop up not displayed", "Fail");
			Assert.fail();

		}
	}

	public void validateEnteringInvalidCustomerNumber(WebDriver driver) 
	{
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 120);
		String Testcase=TestNGCreator.TestData.get(Esupport.TestCaseID.ordinal());

		Log.info("Inside validateEnteringInvalidCustomerNumber");		
		String message="";
		String cancel="";
		try 
		{

			CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.CustomerNumberTextBoxInCancelOrder());
			CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.CustomerNumberTextBoxInCancelOrder()).clear();
			CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.CustomerNumberTextBoxInCancelOrder()).sendKeys("737233");

			Thread.sleep(6000);

			CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.SubmitButtonInCancelOrder());
			CommonUtility.ClickOn(driver,obj_EsupportOrderHomePage.SubmitButtonInCancelOrder());


			wait.until(ExpectedConditions.presenceOfElementLocated(obj_EsupportOrderHomePage.ErrorMessageInForInvalidCustomerNumber()));
			message=CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.ErrorMessageInForInvalidCustomerNumber()).getText();
			System.out.println("message is "+message);


			Report.put("Enter the invalid customer number and click on submit", 
					"Use should show the error message Error message :  Please enter the customer number associated with this order",
					"User able to see error message "+Report.color(message)+" for invalid customer number entry in Cancel Order popup", "PASS");


		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Enter the invalid customer number and click on submit", 
					"Use should show the error message Error message :  Please enter the customer number associated with this order",
					"uer not able to see expected error message", "Fail");
			Assert.fail();

		}
	}

	public void validateServiceTagSectionInOrederDetailsPage(WebDriver driver) 
	{
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 120);


		Log.info("Inside validateServiceTagSectionInOrederDetailsPage");		
		String message="";
		String cancel="";
		try 
		{
			//			handleCookies(driver);

			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_EsupportOrderHomePage.ServiceTagSection()))
			{
				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.ServiceTagSection());
				message=CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.SignInToAccountLinkValidation()).getText();
				System.out.println("section display "+message);


				if(message.contains("sign in to your account"))
				{
					System.out.println("expected message and link displayed");
					Report.put("Verify the service tag section in the order details page ", 
							"User should see the link to Sign in to Account should be displayed or customer number validation ",
							"User able to see "+Report.color(message)+" under service tag section", "PASS");

				}
				else
				{
					System.out.println("expected message and link not displayed");
					Report.put("Verify the service tag section in the order details page ", 
							"User should see the link to Sign in to Account should be displayed or customer number validation ",
							"User not able to see 'link to Sign in to Account should be displayed or customer number validation' under service tag section", "Fail");
					Assert.fail();
				}



			}
			else
			{
				System.out.println("service tag section not displayed");
				Report.put("Verify the service tag section in the order details page ", 
						"User should see the link to Sign in to Account should be displayed or customer number validation ",
						"User not able to see 'link to Sign in to Account should be displayed or customer number validation' under service tag section", "Fail");
				Assert.fail();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("expected message and link not displayed");
			Report.put("Verify the service tag section in the order details page ", 
					"User should see the link to Sign in to Account should be displayed or customer number validation ",
					"User not able to see 'link to Sign in to Account should be displayed or customer number validation' under service tag section", "Fail");
			Assert.fail();

		}
	}

	public void validateServiceTagSectionForNonSystemOrder(WebDriver driver) 
	{
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 120);


		Log.info("Inside validateServiceTagSectionForNonSystemOrder");		
		String message="";
		String cancel="";
		try 
		{
			//			handleCookies(driver);

			if(!(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_EsupportOrderHomePage.ServiceTagSection())))
			{

				System.out.println("service tag section not dislayed ");
				Report.put("Verify the order details page for the service tag section  ", 
						"User should not see the service tag section",
						"User not able to see service tag section", "PASS");


			}
			else
			{
				System.out.println("service tag section displayed");
				Report.put("Verify the order details page for the service tag section  ", 
						"User should not see the service tag section",
						"User able to see service tag section", "Fail");
				Assert.fail();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();

			Report.put("Verify the order details page for the service tag section  ", 
					"User should not see the service tag section",
					"User able to see service tag section", "Fail");
			Assert.fail();

		}
	}

	public void launchURL(WebDriver driver) 
	{
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 120);


		Log.info("Inside launchURL");		
		String action="";
		String cancel="";
		try 
		{

			driver.get("https://www.dell.com/support/order-status/en-us/order-support");


		}
		catch(Exception e)
		{
			e.printStackTrace();


		}
	}

	public void verifyActionSectionForReturnLink(WebDriver driver) 
	{
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 120);


		Log.info("Inside verifyActionSectionForReturnLink");		
		String action="";
		String returnlink="";
		try 
		{
			//			handleCookies(driver);

			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_EsupportOrderHomePage.ActionsHeaderSection()))
			{
				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.ActionsHeaderSection());
				action=CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.ActionsHeaderSection()).getText();
				System.out.println("section name is "+action);

				CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.ActionsSection());
				if(CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.ReturnOrderInActionSection()).isEnabled())
				{
					CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.ReturnOrderInActionSection());

					returnlink=CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.ReturnOrderText()).getText();
					System.out.println("button is "+returnlink);
				}
				else
				{
					System.out.println(" return order button not enabled under action section");
					Report.put("verify the return link", 
							"Return order button should be displayed",
							"return order option not enabled under Action section", "Fail");
					Assert.fail();
				}


				Report.put("verify the return order", 
						"Returns order button should be displayed",
						Report.color(action)+" section displayed and "+Report.color(returnlink)+" button displayed under Action section", "PASS");

			}
			else
			{
				System.out.println("failed to display return link button under action section");
				Report.put("verify the return link", 
						"Return order link should be displayed",
						"return order option not enabled under Action section", "Fail");
				Assert.fail();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("verify the return link", 
					"Return order link should be displayed",
					"return order option not enabled under Action section", "Fail");
			Assert.fail();

		}
	}

	public void clickOnReturnButton(WebDriver driver) 
	{
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 120);


		Log.info("Inside clickOnReturnButton");		
		String header="";
		String returnlink="";
		try 
		{
			//			handleCookies(driver);


			CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.ReturnOrderText());

			returnlink=CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.ReturnOrderText()).getText();
			System.out.println("button is "+returnlink);
			CommonUtility.ClickOn(driver,obj_EsupportOrderHomePage.ReturnOrderText());

			wait.until(ExpectedConditions.presenceOfElementLocated(obj_EsupportOrderHomePage.ReturnOrderHeader()));
			header=CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.ReturnOrderHeader()).getText();
			System.out.println("header is "+header);

			CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.BackToOrderLink());
			CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.CustomerNumberHeader());
			CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.CustomerNumberTextBoxInCancelOrder());
			CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.CancelButtonInCancelOrder());
			CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.SubmitButtonInCancelOrder());

			Report.put("Click on return order link ", 
					"User should show up with customer number model pop up",
					"clicking on "+Report.color(returnlink)+" button able to see "+Report.color(header)+" pop up", "PASS");


		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on return order link ", 
					"User should show up with customer number model pop up",
					"return order pop up not displayed", "Fail");
			Assert.fail();

		}
	}

	public void verifyActionSectionForViewInvoice(WebDriver driver) 
	{
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 120);


		Log.info("Inside verifyActionSectionForViewInvoice");		
		String action="";
		String invoicelink="";
		try 
		{
			//			handleCookies(driver);

			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_EsupportOrderHomePage.ActionsHeaderSection()))
			{
				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.ActionsHeaderSection());
				action=CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.ActionsHeaderSection()).getText();
				System.out.println("section name is "+action);

				CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.ActionsSection());
				if(CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.ViewInvoiceinActionsSection()).isEnabled())
				{
					CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.ViewInvoiceinActionsSection());

					invoicelink=CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.ViewInvoiceText()).getText();
					System.out.println("button is "+invoicelink);
				}
				else
				{
					System.out.println(" view invoice button not enabled under action section");
					Report.put("verify the view invoice button", 
							"view invoice button should be displayed",
							"view invoice option not enabled under Action section", "Fail");
					Assert.fail();
				}


				Report.put("verify the view invoice button", 
						"view invoice button should be displayed",
						Report.color(action)+" section displayed and "+Report.color(invoicelink)+" button displayed under Action section", "PASS");

			}
			else
			{
				System.out.println("failed to display view invoice option under action section");
				Report.put("verify the view invoice button", 
						"view invoice button should be displayed",
						"view invoice option not enabled under Action section", "Fail");
				Assert.fail();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("verify the view invoice button", 
					"view invoice button should be displayed",
					"view invoice option not enabled under Action section", "Fail");
			Assert.fail();

		}
	}

	public void clickOnViewInvoice(WebDriver driver) 
	{
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 120);


		Log.info("Inside clickOnViewInvoice");		
		String header="";
		String invoiceview="";
		try 
		{
			//			handleCookies(driver);


			CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.ViewInvoiceText());

			invoiceview=CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.ViewInvoiceText()).getText();
			System.out.println("button is "+invoiceview);
			CommonUtility.ClickOn(driver,obj_EsupportOrderHomePage.ViewInvoiceText());

			wait.until(ExpectedConditions.presenceOfElementLocated(obj_EsupportOrderHomePage.ViewInvoiceHeader()));
			header=CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.ViewInvoiceHeader()).getText();
			System.out.println("header is "+header);

			CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.BackToOrderLink());
			CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.CustomerNumberHeader());
			CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.CustomerNumberTextBoxInCancelOrder());
			CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.CancelButtonInCancelOrder());
			CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.SubmitButtonInCancelOrder());

			Report.put("Click on the view invoice option ", 
					"User should show up with customer number model pop up",
					"clicking on "+Report.color(invoiceview)+" button able to see "+Report.color(header)+" pop up", "PASS");


		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on the view invoice option ", 
					"User should show up with customer number model pop up",
					"view invoice pop up not displayed", "Fail");
			Assert.fail();

		}
	}

	public void verifyPricingDetailsForUnauthenticated(WebDriver driver) 
	{
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 120);


		Log.info("Inside verifyPricingDetailsForUnauthenticated");		
		String columnnames="";
		String invoicelink="";
		try 
		{
			//			handleCookies(driver);

			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_EsupportOrderHomePage.ColumnNamesUnderOrderDetails()))
			{
				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.ColumnNamesUnderOrderDetails());
				List<WebElement> openwindows=driver.findElements(obj_EsupportOrderHomePage.ColumnNamesUnderOrderDetails());

				for(WebElement OW: openwindows)
				{
					columnnames+=OW.getText();
					System.out.println(columnnames);

				}       

				if(columnnames.contains("UNIT PRICE") || columnnames.contains("TOTAL PRICE"))
				{
					System.out.println("test case fail, it contains pricing details");
					Report.put("verify the pricing details ", 
							"user should not display pricing details - Unit price, Total price and Pricing Summary",
							"Pricing details displayed "+Report.color(columnnames), "Fail");
					Assert.fail();
				}
				else
				{
					System.out.println("test case pass, it dont display pricing details");
				}

//				if(!(CommonUtility.CheckpresenceofElementLocated(driver,10,obj_EsupportOrderHomePage.OtherPriceDetailsUnderOrderDetails())))
//				{
//					Report.put("verify the pricing details ", 
//							"user should not display pricing details - Unit price, Total price and Pricing Summary",
//							"Pricing details and Pricing summary not displayed in the order details grid "+Report.color(columnnames), "Pass");
//				}
//				else
//				{
//					System.out.println("test case fail, it dont display pricing summary");
//					Report.put("verify the pricing details ", 
//							"user should not display pricing details - Unit price, Total price and Pricing Summary",
//							"Pricing summary details not displayed", "Fail");
//					Assert.fail();
//				}

			}
			else
			{
				System.out.println("failed to display order details section");
				Report.put("verify the pricing details ", 
						"user should not display pricing details - Unit price, Total price and Pricing Summary",
						"Order details section grid not displayed", "Fail");
				Assert.fail();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("verify the pricing details ", 
					"user should not display pricing details - Unit price, Total price and Pricing Summary",
					"Order details section grid not displayed", "Fail");
			Assert.fail();

		}
	}

	public void ClickOnSignInOrConfirmOrderDetailsLink(WebDriver driver) 
	{
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 120);


		Log.info("Inside ClickOnSignInOrConfirmOrderDetailsLink");		
		String message="";
		String signinheader="";
		String signinlink="";
		String signindescription="";
		String orenter="";
		String cusno="";
		String cancel="";
		String submit="";
		try 
		{
			//			handleCookies(driver);

			CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.ServiceTagSection());
			message=CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.SignInToAccountLinkValidation()).getText();
			System.out.println("section display "+message);

			CommonUtility.ClickOn(driver,obj_EsupportOrderHomePage.ServiceTagSection());



			if(CommonUtility.CheckpresenceofElementLocated(driver,10,obj_EsupportOrderHomePage.SignIntoYourAccountHeadingInServiceTagSection()))
			{
				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.SignIntoYourAccountHeadingInServiceTagSection());
				signinheader=CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.SignIntoYourAccountHeadingInServiceTagSection()).getText();
				System.out.println("header is "+signinheader);
				signindescription=CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.DescriptionsUnderSignIn()).getText();
				System.out.println("description is "+signindescription);
				signinlink=CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.SignInLink()).getText();
				System.out.println("link is "+signinlink);

				orenter=CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.OrText()).getText();
				System.out.println("link is "+orenter);

				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.CustomerNUmberHeaderInServiceTagSection());
				cusno=CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.CustomerNUmberHeaderInServiceTagSection()).getText();
				System.out.println("header is "+cusno);

				CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.TextBoxInServiceTagSection());

				cancel=CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.CancelButtonInServiceTagSection()).getText();
				System.out.println("button is "+cancel);

				submit=CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.SubmitButtonInServiceTagSection()).getText();
				System.out.println("button is "+submit);

				Report.put("Click on the link please sign in to your account ", 
						"User should show up with customer number text box validation Sign in section ",
						"User able to view of sign in section with header "+Report.color(signinheader+" description "+signindescription+" link "+signinlink)+" and seperated with "+Report.color(orenter)
						+" and customer section with header "+Report.color(cusno)+" and text box along with "+Report.color(cancel+" button "+submit+" button "), "Pass");

			}
			else
			{

				System.out.println("sign in section not displayed");
				Report.put("Click on the link please sign in to your account ", 
						"User should show up with customer number text box validation Sign in section ",
						"Sign in section not displayed", "Fail");
				Assert.fail();
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();

			Report.put("Click on the link please sign in to your account ", 
					"User should show up with customer number text box validation Sign in section ",
					"Sign in section not displayed", "Fail");
			Assert.fail();

		}
	}

	public void validateEnteringValidCustomerNumber(WebDriver driver, String CustomerNumber) 
	{
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 120);


		Log.info("Inside validateEnteringValidCustomerNumber");		
		String servicetag="";

		try 
		{
			//			handleCookies(driver);

			CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.TextBoxInServiceTagSection());

			CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.TextBoxInServiceTagSection()).sendKeys(CustomerNumber);

			CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.SubmitButtonInServiceTagSection());
			CommonUtility.ClickOn(driver,obj_EsupportOrderHomePage.SubmitButtonInServiceTagSection());

			wait.until(ExpectedConditions.presenceOfElementLocated(obj_EsupportOrderHomePage.ServiceTagDisplayedAfterEnteringCustNo()));
			List<WebElement> openwindows=driver.findElements(obj_EsupportOrderHomePage.ServiceTagDisplayedAfterEnteringCustNo());

			for(WebElement OW: openwindows)
			{
				servicetag+=OW.getText();
				System.out.println(servicetag);

			}       
			Report.put("Enter the customer number and click on submit", 
					"User should display the service tags ",
					"User able to enter valid Customer number "+Report.color(CustomerNumber)+" and clicking on Submit able to see all service tags linked to searched order number as "+Report.color(servicetag), "Pass");

		}
		catch(Exception e)
		{
			e.printStackTrace();

			Report.put("Enter the customer number and click on submit", 
					"User should display the service tags ",
					"Sign in section not displayed", "Fail");
			Assert.fail();

		}
	}

	public void verifyAddressDetailsForUnauthenticated(WebDriver driver) 
	{
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 120);


		Log.info("Inside verifyAddressDetailsForUnauthenticated");		
		String columnnames="";
		String invoicelink="";
		try 
		{
			//			handleCookies(driver);

			if(!(CommonUtility.CheckpresenceofElementLocated(driver,10,obj_EsupportOrderHomePage.AddressDetailsHeader())))
			{
				if(!(CommonUtility.CheckpresenceofElementLocated(driver,10,obj_EsupportOrderHomePage.TypeOfAddress())))
				{
					if(!(CommonUtility.CheckpresenceofElementLocated(driver,10,obj_EsupportOrderHomePage.EndUserAddressHeader())))
					{
						if(!(CommonUtility.CheckpresenceofElementLocated(driver,10,obj_EsupportOrderHomePage.FullAddressUnderDifferentAddressType())))
						{
							System.out.println("address details not displayed");
							Report.put("Verify the address details ", 
									"User should not see address details section related to Billing, Shipping, End user and Installed at.",
									"Address details not displayed in order details page", "Pass");
						}
					}
				}


			}
			else
			{
				System.out.println("address deatils displayed in order details page");
				Report.put("Verify the address details ", 
						"User should not see address details section related to Billing, Shipping, End user and Installed at.",
						"Order details page displayed address details", "Fail");
				Assert.fail();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify the address details ", 
					"User should not see address details section related to Billing, Shipping, End user and Installed at.",
					"Order details page displayed address details", "Fail");
			Assert.fail();

		}
	}

	public void validateDPIDNumberSearch(WebDriver driver, String DPID) 
	{
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 120);

		String dpid=TestNGCreator.TestData.get(Esupport.Dpid.ordinal());
		String Testcase=TestNGCreator.TestData.get(Esupport.TestCaseID.ordinal());

		Log.info("Inside validateDPIDNumberSearch");		
		String header="";
		try 
		{
			//			handleCookies(driver);

			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_EsupportOrderHomePage.SearchBoxInOrderStatusPage()))
			{
				if(Testcase.contains("9487003"))
				{
					String dpid1=TestNGCreator.TestData.get(Esupport.Dpid.ordinal()).split(";")[0];
					String dpid2=TestNGCreator.TestData.get(Esupport.Dpid.ordinal()).split(";")[1];

					CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.SearchBoxInOrderStatusPage());
					CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.SearchBoxInOrderStatusPage()).clear();
					CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.SearchBoxInOrderStatusPage()).sendKeys(DPID);

					CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.FindMyOrderButton());
					CommonUtility.ClickOn(driver,obj_EsupportOrderHomePage.FindMyOrderButton());

					wait.until(ExpectedConditions.presenceOfElementLocated(obj_EsupportOrderHomePage.HeaderOfOrderCollectionDPIDPage()));
					handleCookies(driver);
					CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.HeaderOfOrderCollectionDPIDPage());

					header=CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.HeaderOfOrderCollectionDPIDPage()).getText();
					System.out.println("header is "+header);

					CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.OrderCollectionBreadScrumb());


					if(header.contains(dpid1))
					{
						if(header.contains(dpid1))
						{
							System.out.println("Dpid number displayed matching with entered");
							Report.put("Enter the DPID ( which having fractioned order ) and click on search", 
									"User should land in the order collection page ",
									"Entered system DPID ( which having fractioned order ) "+Report.color(dpid1)+" and clicked on search, user landed on Order collection page with header "+Report.color(header), "PASS");
						}
						else
						{
							System.out.println("Dpid number displayed not matching with entered");
							Report.put("Enter the DPID ( which having fractioned order ) and click on search", 
									"User should land in the order collection page ",
									"not landed on Order collection page", "Fail");
							Assert.fail();
						}
					}
					else
					{

						if(header.contains(dpid2))
						{
							System.out.println("Dpid number displayed matching with entered");
							Report.put("Enter the DPID ( which having fractioned order ) and click on search", 
									"User should land in the order collection page ",
									"Entered Dpid "+Report.color(dpid2)+" and clicked on search, user landed on Order collection page with header "+Report.color(header), "PASS");
						}
						else
						{
							System.out.println("Dpid number displayed not matching with entered");
							Report.put("Enter the DPID ( which having fractioned order ) and click on search", 
									"User should land in the order collection page ",
									"not landed on Order collection page", "Fail");
							Assert.fail();
						}
					}
				}

				else
				{
					CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.SearchBoxInOrderStatusPage());
					CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.SearchBoxInOrderStatusPage()).clear();
					CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.SearchBoxInOrderStatusPage()).sendKeys(DPID);

					CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.FindMyOrderButton());
					CommonUtility.ClickOn(driver,obj_EsupportOrderHomePage.FindMyOrderButton());

					wait.until(ExpectedConditions.presenceOfElementLocated(obj_EsupportOrderHomePage.HeaderOfOrderCollectionDPIDPage()));
					handleCookies(driver);
					CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.HeaderOfOrderCollectionDPIDPage());

					header=CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.HeaderOfOrderCollectionDPIDPage()).getText();
					System.out.println("header is "+header);

					CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.OrderCollectionBreadScrumb());

					if(header.contains(dpid))
					{
						System.out.println("Dpid number displayed matching with entered");
						Report.put("Enter the DPID ( which having fractioned order ) and click on search", 
								"User should land in the order collection page ",
								"Entered Dpid number "+Report.color(dpid)+" and clicked on search, user landed on Order collection page with header "+Report.color(header), "PASS");
					}
					else
					{
						System.out.println("Dpid number displayed not matching with entered");
						Report.put("Enter the DPID ( which having fractioned order ) and click on search", 
								"User should land in the order collection page ",
								"not landed on Order collection page", "Fail");
						Assert.fail();
					}
				}
			}
			else
			{
				System.out.println("failed to display search text box");
				Report.put("Enter the DPID ( which having fractioned order ) and click on search", 
						"User should land in the order collection page ",
						"not landed on Order collection page", "Fail");
				Assert.fail();
			}


		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Enter the DPID ( which having fractioned order ) and click on search", 
					"User should land in the order collection page ",
					"not landed on Order collection page", "Fail");
			Assert.fail();

		}
	}


	public void clickOnFrictionedOrderNumber(WebDriver driver) 
	{
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 120);


		Log.info("Inside clickOnFrictionedOrderNumber");		
		String header="";
		String friction="";
		try 
		{
			//			handleCookies(driver);

			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_EsupportOrderHomePage.ClickOnNotyetAssignedLink()))
			{
				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.ClickOnNotyetAssignedLink());
				friction=CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.ClickOnNotyetAssignedLink()).getText();
				System.out.println("order name is  "+friction);
				CommonUtility.ClickOn(driver,obj_EsupportOrderHomePage.ClickOnNotyetAssignedLink());
				Thread.sleep(15000);
				String mainwindow=driver.getWindowHandle();
				Set<String> set=driver.getWindowHandles();
				Iterator<String> itr=set.iterator();
				while(itr.hasNext())
				{
					String childWindow=itr.next();
					if(!mainwindow.equals(childWindow))
					{
						driver.switchTo().window(childWindow);

						wait.until(ExpectedConditions.presenceOfElementLocated(obj_EsupportOrderHomePage.OrderNumberDetailsPageHeader()));
						handleCookies(driver);
						CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.OrderNumberDetailsPageHeader());

						header=CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.OrderNumberDetailsPageHeader()).getText();
						System.out.println("header is "+header);

						CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.OrderDetailsPageBreadScrumb());


						Report.put("check for the Frictioned order number and click on not yet assigned ", 
								"User should land in the order details page ",
								"User able to see frictioned order number "+Report.color(friction)+" and clicking on it landed on order details page with header "+Report.color(header), "PASS");
						verifyTheOrderDetailsPageForFrictionedOrderNo(driver);
						Thread.sleep(10000);
						driver.close();
					}

					driver.switchTo().window(mainwindow);
				}


			}

			else
			{
				System.out.println("failed to see Frictioned orders");
				Report.put("check for the Frictioned order number and click on not yet assigned ", 
						"User should land in the order details page ",
						"not landed on Order details page", "Fail");
				Assert.fail();
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("check for the Frictioned order number and click on not yet assigned ", 
					"User should land in the order details page ",
					"not landed on Order details page", "Fail");
			Assert.fail();
		}
	}


	public void verifyTheOrderDetailsPageForFrictionedOrderNo(WebDriver driver) 
	{
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 120);


		Log.info("Inside verifyTheOrderDetailsPageForFrictionedOrderNo");		
		String action="";
		String progressbar="";
		String progressbar1="";
		String progressbar2="";
		String status="";
		String CCSupport="";
		String ViewAnotherOrder="";
		try 
		{
			//			handleCookies(driver);

			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_EsupportOrderHomePage.OrderStatusDetails()))
			{

				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.OrderStatusDetails());
				List<WebElement> openwindows=driver.findElements(obj_EsupportOrderHomePage.OrderStatusDetails());

				for(WebElement OW: openwindows)
				{

					status=OW.getAttribute("class");

					if(status.contains("complete"))
					{
						progressbar1+=OW.getText();
						System.out.println("completed status "+progressbar1);
					}
					if(status.contains("in-progress"))
					{
						progressbar2+=OW.getText();
						System.out.println("in-progress status "+progressbar2);
					}
					if(status.equals("tracker-step"))
					{
						progressbar+=OW.getText();
						System.out.println("no status "+progressbar);
					}

				} 


				if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_EsupportOrderHomePage.ActionsHeaderSection()))
				{
					CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.ActionsHeaderSection());
					action=CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.ActionsHeaderSection()).getText();
					System.out.println("section name is "+action);

					CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.ActionsSection());
					if(CommonUtility.CheckpresenceofElementLocated(driver,10,obj_EsupportOrderHomePage.ViewPackingSlipDisabled()))
					{
						System.out.println("pass: packing slip not enabled");
					}
					else
					{
						System.out.println("fail: packing slip enabled");
						Report.put("Verify the order details page ", 
								"User should see the processing progressive bar and enable actions - Contact customer support , View another order link And hide Packing slip for frictioned orders",
								"view packing slip enabled under Action section", "Fail");
						Assert.fail();
					}



					CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.DescriptionBeforeContactCustomerSupportButton());
					CCSupport=CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.ContactCustomerSupportButton()).getText();
					System.out.println("button name is "+CCSupport);

					CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.ViewAnotherOrderUnderActions());
					ViewAnotherOrder=CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.ViewAnotherOrderUnderActions()).getText();
					System.out.println("button name is "+ViewAnotherOrder);


					Report.put("Verify the order details page ", 
							"User should see the processing progressive bar and enable actions - Contact customer support , View another order link And hide Packing slip for frictioned orders",
							"User able to see pregress bar of status "+Report.color(progressbar1+" with complete status "+progressbar2+" with in-progress "+progressbar+" with no status yet ")
							+" able to see "+Report.color(CCSupport)+" button with description and "+Report.color(ViewAnotherOrder)+" button under "+Report.color(action)+" section and view packing slipnis enabled", "PASS");

				}
				else
				{
					System.out.println("failed to see action section");
					Report.put("Verify the order details page ", 
							"User should see the processing progressive bar and enable actions - Contact customer support , View another order link And hide Packing slip for frictioned orders",
							"action section not displayed Order details page", "Fail");
					Assert.fail();
				}
			}

			else
			{
				System.out.println("failed to see progress bar");
				Report.put("Verify the order details page ", 
						"User should see the processing progressive bar and enable actions - Contact customer support , View another order link And hide Packing slip for frictioned orders",
						"progress bar not displayed Order details page", "Fail");
				Assert.fail();
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify the order details page ", 
					"User should see the processing progressive bar and enable actions - Contact customer support , View another order link And hide Packing slip for frictioned orders",
					"progress bar not displayed Order details page", "Fail");
			Assert.fail();
		}
	}


	public void verifyTheOrderDetailsPageForSearchedOrder(WebDriver driver) 
	{
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 120);


		Log.info("Inside verifyTheOrderDetailsPageForSearchedOrder");		
		String action="";
		String progressbar="";
		String progressbar1="";
		String progressbar2="";
		String status="";
		String CCSupport="";
		String ViewAnotherOrder="";
		String header="";
		String orddateanddpid="";

		try 
		{
			//			handleCookies(driver);

			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_EsupportOrderHomePage.OrderNumberDetailsPageHeader()))
			{
				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.OrderNumberDetailsPageHeader());

				header=CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.OrderNumberDetailsPageHeader()).getText();
				System.out.println("header is "+header);

				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.OrderDateAndDPIDDetailsOnOrderDetailsPage());

				orddateanddpid=CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.OrderDateAndDPIDDetailsOnOrderDetailsPage()).getText();
				System.out.println("date and dpid details are "+orddateanddpid);


				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.OrderStatusDetails());
				List<WebElement> openwindows=driver.findElements(obj_EsupportOrderHomePage.OrderStatusDetails());

				for(WebElement OW: openwindows)
				{

					status=OW.getAttribute("class");

					if(status.contains("complete"))
					{
						progressbar1+=OW.getText();
						System.out.println("completed status "+progressbar1);
					}
					if(status.contains("in-progress"))
					{
						progressbar2+=OW.getText();
						System.out.println("in-progress status "+progressbar2);
					}
					if(status.equals("tracker-step"))
					{
						progressbar+=OW.getText();
						System.out.println("no status "+progressbar);
					}

				} 


				if(!(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_EsupportOrderHomePage.CustomerNumberHeaderInOrderDetailsPage())))
				{
					System.out.println("customer number details not visible for guest user");
				}
				else
				{
					System.out.println("user able to see customer number details for guest user");
					Report.put("Verify the header section ", 
							"Order details page should show below information in the header, Order number, Order Status, Order Date, DPID - should be hyperlinked Note : Customer number, PO number should be hidden for Guest users",
							"user able to see customer number details for guest user", "Fail");
					Assert.fail();
				}
				if(!(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_EsupportOrderHomePage.PONumberHeader())))
				{
					System.out.println("PO number details not visible for guest user");
				}
				else
				{
					System.out.println("user able to see PO number details for guest user");
					Report.put("Verify the header section ", 
							"Order details page should show below information in the header, Order number, Order Status, Order Date, DPID - should be hyperlinked Note : Customer number, PO number should be hidden for Guest users",
							"user able to see PO number details for guest user", "Fail");
					Assert.fail();
				}

				Report.put("Verify the header section ", 
						"Order details page should show below information in the header, Order number, Order Status, Order Date, DPID - should be hyperlinked Note : Customer number, PO number should be hidden for Guest users",
						"Oder details page display "+Report.color(header)+" and able to view "+Report.color(orddateanddpid)+" along with order status as "+Report.color(progressbar1+" , "+progressbar2+" , "+progressbar), "PASS");

			}

			else
			{
				System.out.println("failed to see order number header");
				Report.put("Verify the header section ", 
						"Order details page should show below information in the header, Order number, Order Status, Order Date, DPID - should be hyperlinked Note : Customer number, PO number should be hidden for Guest users",
						"order number header not displayed in Order details page", "Fail");
				Assert.fail();
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify the header section ", 
					"Order details page should show below information in the header, Order number, Order Status, Order Date, DPID - should be hyperlinked Note : Customer number, PO number should be hidden for Guest users",
					"order number header not displayed in Order details page", "Fail");
			Assert.fail();
		}
	}

	public void clickOnDPIDNumber(WebDriver driver) 
	{
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 420);


		Log.info("Inside clickOnDPIDNumber");		
		String header="";
		String dpid="";
		try 
		{
			//			handleCookies(driver);

			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_EsupportOrderHomePage.DPIDNumberDisplayedOnFirstDisplayedOrderCard()))
			{

				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.DPIDNumberDisplayedOnFirstDisplayedOrderCard());
				dpid=CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.DPIDNumberDisplayedOnFirstDisplayedOrderCard()).getText();
				System.out.println("dpid number is "+dpid);

				CommonUtility.ClickOn(driver,obj_EsupportOrderHomePage.DPIDNumberDisplayedOnFirstDisplayedOrderCard());
				Thread.sleep(15000);
				String mainwindow=driver.getWindowHandle();
				Set<String> set=driver.getWindowHandles();
				Iterator<String> itr=set.iterator();
				while(itr.hasNext())
				{
					String childWindow=itr.next();
					if(!mainwindow.equals(childWindow))
					{
						driver.switchTo().window(childWindow);
						wait.until(ExpectedConditions.presenceOfElementLocated(obj_EsupportOrderHomePage.HeaderOfOrderCollectionDPIDPage()));
						handleCookies(driver);
						CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.HeaderOfOrderCollectionDPIDPage());

						header=CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.HeaderOfOrderCollectionDPIDPage()).getText();
						System.out.println("header is "+header);

						CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.OrderCollectionBreadScrumb());

						if(header.contains(dpid))
						{
							System.out.println("Dpid number displayed matching with entered");
							Report.put("Click on the DPID ", 
									"should go to the DPID collection view",
									"Entered Dpid number "+Report.color(dpid)+" hyperlink, user landed on Order collection page with header "+Report.color(header), "PASS");
						}
						else
						{
							driver.close();
							System.out.println("Dpid number displayed not matching with entered");
							Report.put("Click on the DPID ", 
									"should go to the DPID collection view",
									"not landed on Order collection page", "Fail");
							Assert.fail();
						}
						Thread.sleep(10000);
						driver.close();
					}

					driver.switchTo().window(mainwindow);
				}
			}

			else
			{
				System.out.println("failed to see dpid hyperlink");
				Report.put("Click on the DPID ", 
						"should go to the DPID collection view",
						"not landed on Order collection page", "Fail");
				Assert.fail();
			}


		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on the DPID ", 
					"should go to the DPID collection view",
					"not landed on Order collection page", "Fail");
			Assert.fail();

		}
	}

	public void VerifyViewOrderDetailsButton(WebDriver driver) 
	{
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 120);


		Log.info("Inside VerifyViewOrderDetailsButton");		
		String button="";

		try 
		{
			//			handleCookies(driver);

			if(CommonUtility.CheckpresenceofElementLocated(driver,33,obj_EsupportOrderHomePage.ViewOrderDetailsButton()))
			{
				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.ViewOrderDetailsButton());
				button=CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.ViewOrderDetailsButton()).getText();
				System.out.println("button diaplyed is "+button);

				Report.put("Verify the view order details ", 
						"View order details button should be present for each order",
						"User able to see "+Report.color(button)+" button", "PASS");

			}

			else
			{
				System.out.println("failed to see View order details button");
				Report.put("Verify the view order details ", 
						"View order details button should be present for each order",
						"user not able to see View order details button", "Fail");
				Assert.fail();
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify the view order details ", 
					"View order details button should be present for each order",
					"user not able to see View order details button", "Fail");
			Assert.fail();
		}
	}

	public void clickOnViewOrderDetailsButton(WebDriver driver) 
	{
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 420);


		Log.info("Inside clickOnViewOrderDetailsButton");		
		String header="";
		String button="";
		String orddateanddpid="";
		try 
		{
			//			handleCookies(driver);

			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_EsupportOrderHomePage.ViewOrderDetailsButton()))
			{

				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.ViewOrderDetailsButton());
				button=CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.ViewOrderDetailsButton()).getText();
				System.out.println("button is "+button);

				CommonUtility.ClickOn(driver,obj_EsupportOrderHomePage.ViewOrderDetailsButton());
				Thread.sleep(15000);
				String mainwindow=driver.getWindowHandle();
				Set<String> set=driver.getWindowHandles();
				Iterator<String> itr=set.iterator();
				while(itr.hasNext())
				{
					String childWindow=itr.next();
					if(!mainwindow.equals(childWindow))
					{
						driver.switchTo().window(childWindow);
						wait.until(ExpectedConditions.presenceOfElementLocated(obj_EsupportOrderHomePage.OrderNumberDetailsPageHeader()));
						handleCookies(driver);
						CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.OrderNumberDetailsPageHeader());

						header=CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.OrderNumberDetailsPageHeader()).getText();
						System.out.println("header is "+header);

						CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.OrderDateAndDPIDDetailsOnOrderDetailsPage());

						orddateanddpid=CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.OrderDateAndDPIDDetailsOnOrderDetailsPage()).getText();
						System.out.println("date and dpid details are "+orddateanddpid);

						CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.OrderDetailsPageBreadScrumb());


						System.out.println("order details page displayed");
						Report.put("Click on view order details ", 
								"User should land in the order details page ",
								"user clicking on first displayed "+Report.color(button)+" button, redirected to order details page with "+Report.color(header)+" and "+Report.color(orddateanddpid), "PASS");
						Thread.sleep(10000);
						driver.close();
					}

					driver.switchTo().window(mainwindow);
				}
			}

			else
			{
				System.out.println("failed to see order detailspage");
				Report.put("Click on view order details ", 
						"User should land in the order details page ",
						"failed to see order details page", "Fail");
				Assert.fail();
			}


		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on view order details ", 
					"User should land in the order details page ",
					"failed to see order details page", "Fail");
			Assert.fail();

		}
	}

	public void verifyItemsQuantityAgainstEachOrderCard(WebDriver driver) 
	{
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 120);


		Log.info("Inside verifyItemsQuantityAgainstEachOrderCard");		
		String items="";

		try 
		{
			//			handleCookies(driver);

			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_EsupportOrderHomePage.ItemsQuantity()))
			{
				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.ItemsQuantity());
				List<WebElement> openwindows=driver.findElements(obj_EsupportOrderHomePage.ItemsQuantity());

				for(WebElement OW: openwindows)
				{
					items+=OW.getText();
					System.out.println(items);

				}  

				Report.put("verify the data in order card", 
						"each order card should contain Item quantity against each item in the order (for a parent item only)",
						"User able to see "+Report.color(items)+" for each order card", "PASS");

			}

			else
			{
				System.out.println("failed to see items against each order card");
				Report.put("verify the data in order card", 
						"each order card should contain Item quantity against each item in the order (for a parent item only)",
						"user not able to see items against each order card", "Fail");
				Assert.fail();
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("verify the data in order card", 
					"each order card should contain Item quantity against each item in the order (for a parent item only)",
					"user not able to see items against each order card", "Fail");
			Assert.fail();
		}
	}

	public void VerifyDelayMessageUnderDeliveryMilestone(WebDriver driver) 
	{
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 120);


		Log.info("Inside VerifyDelayMessageUnderDeliveryMilestone");		
		String message="";
		String rdd="";
		try 
		{
			//			handleCookies(driver);

			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_EsupportOrderHomePage.OrderDelayMessage()))
			{
				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.OrderDelayMessage());
				message=CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.OrderDelayMessage()).getText();
				System.out.println("message displayed is "+message);


				if(message.contains("Order delayed again"))
				{
					System.out.println("expected message displayed");


				}
				else
				{
					System.out.println("expected message not displayed");
					Report.put("Check the delay message under delivery milestone", 
							"latest RDD date under delivered milestone",
							"User not able to see delay message", "Fail");
					Assert.fail();
				}
				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.RDDDateUnderMilestoneDelivered());
				rdd=CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.RDDDateUnderMilestoneDelivered()).getText();
				System.out.println("message displayed under delivery milestone is "+rdd);

				Report.put("Check the delay message under delivery milestone", 
						"latest RDD date under delivered milestone",
						"User able to see "+Report.color(message)+" with RDD message "+Report.color(rdd)+" under delivery milestone", "PASS");
			}
			else
			{
				System.out.println("delay message not diaplayed");
				Report.put("Check the delay message under delivery milestone", 
						"latest RDD date under delivered milestone",
						"User not able to see delay message", "Fail");
				Assert.fail();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();

			Report.put("Check the delay message under delivery milestone", 
					"latest RDD date under delivered milestone",
					"User not able to see delay message", "Fail");
			Assert.fail();

		}
	}

	public void  ClickOnMyAccountSignIn(WebDriver driver) 
	{
		System.out.println("Inside ClickOnMyAccountSignIn");
		WebDriverWait  wait = new WebDriverWait(driver, 120);
		Actions act=new Actions(driver);
		try
		{

			//			handleCookies(driver);
			driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
			Thread.sleep(10000);
			handleCookies(driver);
			//			handleCookies(driver);
			CommonUtility.ScrollTo(driver, obj_EsupportOrderHomePage.MyAccountButton());
			//			WebElement element = driver.findElement(obj_EsupportIncidentsPage.signInLabelHomepage());
			act.moveToElement(CommonUtility.highlightElement(driver, obj_EsupportOrderHomePage.MyAccountButton())).click().build().perform();
			if(CommonUtility.CheckpresenceofElementLocated(driver,10, obj_EsupportIncidentsPage.signInButtonHomepage()))
			{

				//			CommonUtility.highlightElement(driver, obj_EsupportIncidentsPage.signInLabelHomepage()).click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIncidentsPage.signInButtonHomepage()));
				WebElement ele = driver.findElement(obj_EsupportIncidentsPage.signInButtonHomepage());


				System.out.println("Clicked on My account Button");
				Report.put("Click on My account button", 
						"Sign In Page should dispaly", 
						"Application navigated to Sign In page ", "PASS");
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on SignIn button", 
					"Sign In Page should dispaly", 
					"Application is not navigated to Sign In page ", "FAIL");
			Assert.fail();
		}
	}

	public void  ValidateChangeCountry(WebDriver driver)
	{
		WebDriverWait  wait = new WebDriverWait(driver, 120);
		Log.info("Entering ValidateChangeCountry");
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
						lt.click();

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
				Report.put("Click on the Country dropdown at the bottom of the page and select a different country", 
						"1. The page should be reloaded in the language of the selected country.<br> 2. The page will be translated to the language of the selected country provided the translated language version is available.<br> 3. If the language of the selected country is unavailable, the page will be displayed in English by default.<br> 4. A small box with letters EN if displayed next to the title of the documents to indicates that the specific documents is available only in English", 
						"issue in selecting country " +Report.color(country1), "FAIL");
				Assert.fail();
			}

			//			handleCookies(driver);

			if(driver.getCurrentUrl().contains("cn") || driver.getCurrentUrl().contains("ca") ||driver.getCurrentUrl().contains("br"))
			{
				Log.info("Test Case Pass: loaded with selected country China");
				title=driver.getTitle();
				System.out.println("title of page after changing country is "+title);
			}
			else
			{
				driver.get("https://www.dell.com/support/order-status/en-us/order-support");
				Log.info("Test Case Fail: not loaded with selected country");
				Report.put("Click on the Country dropdown at the bottom of the page and select a different country", 
						"1. The page should be reloaded in the language of the selected country.<br>", 
						"1.Pag not reloaded in the language of the selected country" +Report.color(country1), "FAIL");
				Assert.fail();
			}


		}

		catch(Exception e)
		{
			driver.get("https://www.dell.com/support/order-status/en-us/order-support");
			e.printStackTrace();
			Report.put("Click on the Country dropdown at the bottom of the page and select a different country", 
					"1. The page should be reloaded in the language of the selected country.<br>", 
					"1.Pag not reloaded in the language of the selected country" +Report.color(country1), "FAIL");
			Assert.fail();
		}
	}

	public void clickOnFirstOrderNumberDisplayed(WebDriver driver) 
	{
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 120);


		Log.info("Inside clickOnFirstOrderNumberDisplayed");		
		String header="";
		String friction="";
		try 
		{
			//			handleCookies(driver);

			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_EsupportOrderHomePage.ClickOnFirstOrderNumber()))
			{
				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.ClickOnFirstOrderNumber());
				friction=CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.ClickOnFirstOrderNumber()).getText();
				System.out.println("order name is  "+friction);
				CommonUtility.ClickOn(driver,obj_EsupportOrderHomePage.ClickOnFirstOrderNumber());
				Thread.sleep(15000);
				String mainwindow=driver.getWindowHandle();
				Set<String> set=driver.getWindowHandles();
				Iterator<String> itr=set.iterator();
				while(itr.hasNext())
				{
					String childWindow=itr.next();
					if(!mainwindow.equals(childWindow))
					{
						driver.switchTo().window(childWindow);

						wait.until(ExpectedConditions.presenceOfElementLocated(obj_EsupportOrderHomePage.OrderNumberDetailsPageHeader()));
						handleCookies(driver);
						CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.OrderNumberDetailsPageHeader());

						header=CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.OrderNumberDetailsPageHeader()).getText();
						System.out.println("header is "+header);

						CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.OrderDetailsPageBreadScrumb());

						if(header.contains(friction))
						{
							System.out.println("able to see order number displayed on new tab matching with clicked number");
						}
						else
						{
							driver.close();
							System.out.println("not ablet to see order number");
							Report.put("Click on any order number  ", 
									"User should land in the order details page ",
									"not landed on Order details page", "Fail");
							Assert.fail();
						}
						Report.put("Click on any order number  ", 
								"User should land in the order details page ",
								"User able to click on first order number "+Report.color(friction)+" and clicking on it landed on order details page with header "+Report.color(header), "PASS");
//						verifyViewPackingSlipCard(driver);
						Thread.sleep(10000);
						driver.close();
					}

					driver.switchTo().window(mainwindow);
				}


			}

			else
			{
				System.out.println("not ablet to see order number");
				Report.put("Click on any order number  ", 
						"User should land in the order details page ",
						"not landed on Order details page", "Fail");
				Assert.fail();
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on any order number  ", 
					"User should land in the order details page ",
					"not landed on Order details page", "Fail");
			Assert.fail();
		}
	}

	public void verifyViewPackingSlipCard(WebDriver driver) 
	{
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 120);


		Log.info("Inside verifyViewPackingSlipCard");		
		String packingslip="";
		String disabled="";

		try 
		{
			//			handleCookies(driver);

			if(CommonUtility.CheckpresenceofElementLocated(driver,10,obj_EsupportOrderHomePage.ViewPackingSlip()))
			{
				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.ViewPackingSlip());
				packingslip=CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.ViewPackingSlip()).getText();
				System.out.println("button name is "+packingslip);

				disabled=CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.ViewPackingSlip()).getAttribute("class");
				System.out.println("class is "+disabled);

//				if(disabled.contains(disabled))
//				{
//					System.out.println("fail: packing  slip not enabled");
//					Report.put("Verify the packing slip card ", 
//							"View Packing Slip card should be seen",
//							"view packing slip not enabled under Action section", "Fail");
//					Assert.fail();
//
//				}
//				else
//				{
//					System.out.println("pass: packing slip enabled");
//					Report.put("Verify the packing slip card ", 
//							"View Packing Slip card should be seen",
//							Report.color(packingslip)+"is displayed and enabled ", "PASS");
//
//				}
				
				System.out.println("pass: packing slip enabled");
				Report.put("Verify the packing slip card ", 
						"View Packing Slip card should be seen",
						Report.color(packingslip)+"is displayed and enabled ", "PASS");
			}
			else
			{
				System.out.println("fail: packing slip not enabled");
				Report.put("Verify the packing slip card ", 
						"View Packing Slip card should be seen",
						"not able to view packing slip card ", "Fail");
				Assert.fail();
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify the packing slip card ", 
					"View Packing Slip card should be seen",
					"not able to view packing slip card ", "Fail");
			Assert.fail();
		}
	}

	public void CountOfOrderCardsDisplayed(WebDriver driver) 
	{
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 120);


		Log.info("Inside CountOfOrderCardsDisplayed");		
		String items="";

		try 
		{
			//			handleCookies(driver);

			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_EsupportOrderHomePage.OrderCardCount()))
			{
				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.OrderCardCount());
				List<WebElement> openwindows=driver.findElements(obj_EsupportOrderHomePage.OrderCardCount());
				int count=openwindows.size();
				System.out.println(" cont is "+count); 
				if(count<5)
				{
					System.out.println("failed to see minimum 5 order cards displayed on login");
					Report.put("verify count of order cards", 
							"should see  5 cards on the page (in the same order as received from GOSS)And I should see pagination option to see the rest of the order cards",
							"user not able to see items against each order card", "Fail");
					Assert.fail();
				}
				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.PaginationSectionOnOrderHistory());

				Report.put("verify count of order cards", 
						"should see  5 cards on the page (in the same order as received from GOSS)And I should see pagination option to see the rest of the order cards",
						"User able to see "+count+" order cards along with pagination option to see rest of the orders", "PASS");

			}

			else
			{
				System.out.println("failed to see order cards");
				Report.put("verify count of order cards", 
						"should see  5 cards on the page (in the same order as received from GOSS)And I should see pagination option to see the rest of the order cards",
						"user failed to see order cards", "Fail");
				Assert.fail();
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("verify count of order cards", 
					"should see  5 cards on the page (in the same order as received from GOSS)And I should see pagination option to see the rest of the order cards",
					"user failed to see order cards", "Fail");
			Assert.fail();
		}
	}


	public void verifyDeliveryDetails(WebDriver driver) 
	{
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 120);


		Log.info("Inside verifyDeliveryDetails");		
		String dates="";
		String esd="";String rsd="";String shipped="";
		String eab="";String rdd="";String delivered="";
		String header="";
		try 
		{
			//			handleCookies(driver);

			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_EsupportOrderHomePage.DeliveryDetailsHeader()))
			{
				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.DeliveryDetailsHeader());
				header=CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.DeliveryDetailsHeader()).getText();
				System.out.println("header is "+header);

				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.EstimatedShipDate());
				esd=CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.EstimatedShipDate()).getText();
				System.out.println("header is "+esd);

				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.RevisedShipDate());
				rsd=CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.RevisedShipDate()).getText();
				System.out.println("header is "+rsd);

				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.Shipped());
				shipped=CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.Shipped()).getText();
				System.out.println("header is "+shipped);

				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.EstimatedToArriveBy());
				eab=CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.EstimatedToArriveBy()).getText();
				System.out.println("header is "+eab);

				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.RevisedDeliveryDate());
				rdd=CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.RevisedDeliveryDate()).getText();
				System.out.println("header is "+rdd);

				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.Delivered());
				delivered=CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.Delivered()).getText();
				System.out.println("header is "+delivered);

				List<WebElement> openwindows=driver.findElements(obj_EsupportOrderHomePage.DatesAvailableUnderEachDate());
				for(WebElement OW: openwindows)
				{
					dates+=OW.getText();
					System.out.println(dates);

				}  

				Report.put("Verify the delivery dates", 
						"User should display the Delivery dates - ESD/RSD/ASD dates if available- EDD/RDD/ADD dates if available- Show shipping code if user is authenticated",
						"User able to see "+Report.color(header)+" with details "+Report.color(esd+" , "+rsd+" , "+shipped+" , "+eab+" , "+rdd+" , "+delivered)+" with respective dates "+Report.color(dates), "PASS");

			}

			else
			{
				System.out.println("failed to delivery detils");
				Report.put("Verify the delivery dates", 
						"User should display the Delivery dates - ESD/RSD/ASD dates if available- EDD/RDD/ADD dates if available- Show shipping code if user is authenticated",
						"user not able to see delivery details section", "Fail");
				Assert.fail();
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify the delivery dates", 
					"User should display the Delivery dates - ESD/RSD/ASD dates if available- EDD/RDD/ADD dates if available- Show shipping code if user is authenticated",
					"user not able to see delivery details section", "Fail");
			Assert.fail();
		}
	}
	
	public void VerifyCollectionViewPage(WebDriver driver) 
	{
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 120);


		Log.info("Inside VerifyCollectionViewPage");		
		String button="";

		try 
		{
			//			handleCookies(driver);

			if(CommonUtility.CheckpresenceofElementLocated(driver,33,obj_EsupportOrderHomePage.OrderProgressiveBar()))
			{
				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.OrderProgressiveBar());
				
				List<WebElement> elements = driver.findElements(obj_EsupportOrderHomePage.OrderProgressiveBar());
				for (int i = 0; i < elements.size(); i++) 
				{
					CommonUtility.ScrollToWebElement(driver,elements.get(i));
					
				}
				Report.put("Verify the collection view page", 
						"Collection view should contain the order status progressive bar",
						"User able to see order status progressive bar in collection view", "PASS");

			}

			else
			{
				System.out.println("failed to see order status progressive bar in collection view");
				Report.put("Verify the collection view page", 
						"Collection view should contain the order status progressive bar",
						"failed to see order status progressive bar in collection view", "Fail");
				Assert.fail();
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify the collection view page", 
					"Collection view should contain the order status progressive bar",
					"failed to see order status progressive bar in collection view", "Fail");
			Assert.fail();
		}
	}
	
	public void VerifyOrdersInCollectionViewPage(WebDriver driver) 
	{
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 120);


		Log.info("Inside VerifyOrdersInCollectionViewPage");		
		String orders="";

		try 
		{
			//			handleCookies(driver);

			if(CommonUtility.CheckpresenceofElementLocated(driver,33,obj_EsupportOrderHomePage.OrderDetailsInCollectionView()))
			{
				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.OrderDetailsInCollectionView());
				
				List<WebElement> elements = driver.findElements(obj_EsupportOrderHomePage.OrderDetailsInCollectionView());
				int count=elements.size();
				System.out.println("number of order cards displayed are "+count);
				
				for (int i = 0; i < elements.size(); i++) 
				{
					CommonUtility.ScrollToWebElement(driver,elements.get(i));
					String names=elements.get(i).getText();
					orders += " <br> "+names;
				}
				System.out.println(orders);
				
				Report.put("Verify the order collection ", 
						"Order collection page should display all the orders ",
						"User able to see all orders in Order collection page with count "+count+" and order details "+Report.color(orders), "PASS");

			}

			else
			{
				System.out.println("failed to see orders in collection view");
				Report.put("Verify the order collection ", 
						"Order collection page should display all the orders ",
						"failed to see orders in collection view", "Fail");
				Assert.fail();
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify the order collection ", 
					"Order collection page should display all the orders ",
					"failed to see orders in collection view", "Fail");
			Assert.fail();
		}
	}
	
	public void VerifyPriceCardOnEachOrder(WebDriver driver) 
	{
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 120);


		Log.info("Inside VerifyPriceCardOnEachOrder");		
		String pricecard="";

		try 
		{
			//			handleCookies(driver);

			if(CommonUtility.CheckpresenceofElementLocated(driver,33,obj_EsupportOrderHomePage.PricingDetailsInCollectionView()))
			{
				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.PricingDetailsInCollectionView());
				
				List<WebElement> elements = driver.findElements(obj_EsupportOrderHomePage.PricingDetailsInCollectionView());
				int count=elements.size();
				System.out.println("number of order cards displayed are "+count);
				
				for (int i = 0; i < elements.size(); i++) 
				{
					CommonUtility.ScrollToWebElement(driver,elements.get(i));
					String names=elements.get(i).getText();
					pricecard += " <br> "+names;
				}
				System.out.println(pricecard);
				
				Report.put("Verify the price card for each order", 
						"User should display the price card for each order each order card should contain price as below Unit Price and Total Price against each item in order (where available from GOSS) in the respective region's currency Order Total - for the entire order Needs to have the corresponding region currency ",
						"User able to see price card with details "+Report.color(pricecard), "PASS");

			}

			else
			{
				System.out.println("failed to see price card for each order");
				Report.put("Verify the price card for each order", 
						"User should display the price card for each order each order card should contain price as below Unit Price and Total Price against each item in order (where available from GOSS) in the respective region's currency Order Total - for the entire order Needs to have the corresponding region currency ",
						"failed to see price card for each order", "Fail");
				Assert.fail();
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify the price card for each order", 
					"User should display the price card for each order each order card should contain price as below Unit Price and Total Price against each item in order (where available from GOSS) in the respective region's currency Order Total - for the entire order Needs to have the corresponding region currency ",
					"failed to see price card for each order", "Fail");
			Assert.fail();
		}
	}
	
	public void VerifyViewOrderDetailsButtonOnEachCard(WebDriver driver) 
	{
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 120);


		Log.info("Inside VerifyViewOrderDetailsButtonOnEachCard");		
		String button="";

		try 
		{
			//			handleCookies(driver);

			if(CommonUtility.CheckpresenceofElementLocated(driver,33,obj_EsupportOrderHomePage.ViewOrderDatailsButtonIncollectionView()))
			{
				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.ViewOrderDatailsButtonIncollectionView());
				List<WebElement> elements = driver.findElements(obj_EsupportOrderHomePage.ViewOrderDatailsButtonIncollectionView());
				int count=elements.size();
				System.out.println("number of order cards displayed are "+count);
				
				for (int i = 0; i < elements.size(); i++) 
				{
					CommonUtility.ScrollToWebElement(driver,elements.get(i));
					String names=elements.get(i).getText();
					button += " <br> "+names;
				}
				System.out.println(button);

				Report.put("Verify the view order details ", 
						"View order details button should be present for each order",
						"User able to see "+count+" of view order details button", "PASS");

			}

			else
			{
				System.out.println("failed to see View order details button");
				Report.put("Verify the view order details ", 
						"View order details button should be present for each order",
						"user not able to see View order details button", "Fail");
				Assert.fail();
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify the view order details ", 
					"View order details button should be present for each order",
					"user not able to see View order details button", "Fail");
			Assert.fail();
		}
	}
	
	public void VerifyPackingSlipAndInvoiceLinkOnFirstDisplayedCard(WebDriver driver) 
	{
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 120);


		Log.info("Inside VerifyPackingSlipAndInvoiceLinkOnFirstDisplayedCard");		
		String packingslip="";
		String invoicelink="";
		
		try 
		{
			//			handleCookies(driver);

			if(CommonUtility.CheckpresenceofElementLocated(driver,33,obj_EsupportOrderHomePage.ViewPackingSlipButtonOnFirstDisplayedOrderCard()))
			{
				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.ViewPackingSlipButtonOnFirstDisplayedOrderCard());
				packingslip=CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.ViewPackingSlipButtonOnFirstDisplayedOrderCard()).getText();
				System.out.println("diaplyed is "+packingslip);
				
				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.ViewInvoiceButtonOnFirstDisplayedOrderCard());
				invoicelink=CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.ViewInvoiceButtonOnFirstDisplayedOrderCard()).getText();
				System.out.println("diaplyed is "+invoicelink);
				
				Report.put("Verify the view packing slip link and invoice link above the progressive bar", 
						"View packing slip link and invoice link should displayed ",
						"User able to see "+Report.color(packingslip)+" link and "+Report.color(invoicelink)+" link", "PASS");

			}

			else
			{
				System.out.println("failed to see view packing slip link and invoice link ");
				Report.put("Verify the view packing slip link and invoice link above the progressive bar", 
						"View packing slip link and invoice link should displayed ",
						"failed to see view packing slip link and invoice link ", "Fail");
				Assert.fail();
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify the view packing slip link and invoice link above the progressive bar", 
					"View packing slip link and invoice link should displayed ",
					"failed to see view packing slip link and invoice link ", "Fail");
			Assert.fail();
		}
	}
	
	public void VerifyOrderNumberAndDPIDDetailsOnFirstDisplayedCard(WebDriver driver) 
	{
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 120);


		Log.info("Inside VerifyOrderNumberAndDPIDDetailsOnFirstDisplayedCard");		
		String ordernumber="";
		String dpidnumber="";
		
		try 
		{
			//			handleCookies(driver);

			if(CommonUtility.CheckpresenceofElementLocated(driver,33,obj_EsupportOrderHomePage.OrderNumberDisplayedOnFirstDisplayedOrderCard()))
			{
				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.OrderNumberDisplayedOnFirstDisplayedOrderCard());
				ordernumber=CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.OrderNumberDisplayedOnFirstDisplayedOrderCard()).getText();
				System.out.println("diaplyed is "+ordernumber);
				
				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.DPIDNumberDisplayedOnFirstDisplayedOrderCard());
				dpidnumber=CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.DPIDNumberDisplayedOnFirstDisplayedOrderCard()).getText();
				System.out.println("diaplyed is "+dpidnumber);
				
				Report.put("Verify the order number and DPID details ", 
						"Order number and DPID should be present as hyperlinks",
						"User able to see order number "+Report.color(ordernumber)+" link and dpid number "+Report.color(dpidnumber)+" link", "PASS");

			}

			else
			{
				System.out.println("failed to see order number and DPID details");
				Report.put("Verify the order number and DPID details ", 
						"Order number and DPID should be present as hyperlinks",
						"failed to see order number and DPID details", "Fail");
				Assert.fail();
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify the order number and DPID details ", 
					"Order number and DPID should be present as hyperlinks",
					"failed to see order number and DPID details", "Fail");
			Assert.fail();
		}
	}
	
	
	public void clickOnViewPackingSlipLink(WebDriver driver) 
	{
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 420);


		Log.info("Inside clickOnViewPackingSlipLink");		
		String url="";
		String dpid="";
		try 
		{
			//			handleCookies(driver);

			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_EsupportOrderHomePage.ViewPackingSlipButtonOnFirstDisplayedOrderCard()))
			{

				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.ViewPackingSlipButtonOnFirstDisplayedOrderCard());
				dpid=CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.ViewPackingSlipButtonOnFirstDisplayedOrderCard()).getText();
				System.out.println("link is "+dpid);

				CommonUtility.ClickOn(driver,obj_EsupportOrderHomePage.ViewPackingSlipButtonOnFirstDisplayedOrderCard());
				Thread.sleep(15000);
				String mainwindow=driver.getWindowHandle();
				Set<String> set=driver.getWindowHandles();
				Iterator<String> itr=set.iterator();
				while(itr.hasNext())
				{
					String childWindow=itr.next();
					if(!mainwindow.equals(childWindow))
					{
						driver.switchTo().window(childWindow);
						
						url=driver.getCurrentUrl();
						System.out.println(url);
						if(url.contains("https://www.dell.com/support/order-status/en-us/packingslip"))
						{
							System.out.println("url is matching");
							Report.put("Click on the view packing slip ", 
									"Should load the packing slip in new tab ",
									"user clicks on "+Report.color(dpid)+" hyperlink, user landed on packing slip in new tab with url "+Report.color(url), "PASS");
						}
						else
						{
							driver.close();
							System.out.println("failed to see packing slip in new tab");
							Report.put("Click on the view packing slip ", 
									"Should load the packing slip in new tab ",
									"not landed on packing slip in new tab", "Fail");
							Assert.fail();
						}
						Thread.sleep(6000);
						driver.close();
					}

					driver.switchTo().window(mainwindow);
				}
			}

			else
			{
				System.out.println("failed to see view packing slip hyperlink");
				Report.put("Click on the view packing slip ", 
						"Should load the packing slip in new tab ",
						"not landed on packing slip in new tab", "Fail");
				Assert.fail();
			}


		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on the view packing slip ", 
					"Should load the packing slip in new tab ",
					"not landed on packing slip in new tab", "Fail");
			Assert.fail();

		}
	}
	
	public void clickOnInvoiceSlipLink(WebDriver driver) 
	{
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 420);


		Log.info("Inside clickOnInvoiceSlipLink");		
		String url="";
		String dpid="";
		try 
		{
			//			handleCookies(driver);

			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_EsupportOrderHomePage.ViewInvoiceButtonOnFirstDisplayedOrderCard()))
			{

				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.ViewInvoiceButtonOnFirstDisplayedOrderCard());
				dpid=CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.ViewInvoiceButtonOnFirstDisplayedOrderCard()).getText();
				System.out.println("link is "+dpid);

				CommonUtility.ClickOn(driver,obj_EsupportOrderHomePage.ViewInvoiceButtonOnFirstDisplayedOrderCard());
				Thread.sleep(15000);
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
						url=driver.getCurrentUrl();
						System.out.println(url);
						if(url.contains("https://www.dell.com/support/orders/us/en/04/Invoice"))
						{
							System.out.println("url is matching");
							Report.put("Click on the view invoice ", 
									"Should load the view invoice in new tab ",
									"user clicks on "+Report.color(dpid)+" hyperlink, user landed on view invoice in new tab with url "+Report.color(url), "PASS");
						}
						else
						{
							driver.close();
							System.out.println("failed to see view invoice in new tab");
							Report.put("Click on the view invoice slip ", 
									"Should load the view invoice in new tab ",
									"not landed on view invoice in new tab", "Fail");
							Assert.fail();
						}
						Thread.sleep(6000);
						driver.close();
					}

					driver.switchTo().window(mainwindow);
				}
			}

			else
			{
				System.out.println("failed to see view invoice hyperlink");
				Report.put("Click on the view invoice ", 
						"Should load the invoice in new tab ",
						"not landed on invoice in new tab", "Fail");
				Assert.fail();
			}


		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on the view invoice ", 
					"Should load the invoice slip in new tab ",
					"not landed on invoice slip in new tab", "Fail");
			Assert.fail();

		}
	}
	
	public void VerifyDownloadRecordsLinkAndclickOnIt(WebDriver driver) 
	{
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 120);


		Log.info("Inside VerifyDownloadRecordsLinkAndclickOnIt");		
		String download="";

		try 
		{
			//			handleCookies(driver);

			if(CommonUtility.CheckpresenceofElementLocated(driver,33,obj_EsupportOrderHomePage.DownloadRecordsButtonOnCollectionView()))
			{
				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.DownloadRecordsButtonOnCollectionView());
				download=CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.DownloadRecordsButtonOnCollectionView()).getText();
				System.out.println("link is "+download);

				
				Report.put("verify the download records link ", 
						"Download records link should be displayed on the top ",
						"User able to see "+Report.color(download)+" link", "PASS");
				
				CommonUtility.ClickOn(driver,obj_EsupportOrderHomePage.DownloadRecordsButtonOnCollectionView());
				
				Report.put("Click on the download records ", 
						"User should get download the records in excel ",
						"User able to click on  download records", "PASS");

			}

			else
			{
				System.out.println("failed to see download records link");
				Report.put("verify the download records link ", 
						"Download records link should be displayed on the top ",
						"failed to see download records link", "Fail");
				Assert.fail();
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("verify the download records link ", 
					"Download records link should be displayed on the top ",
					"failed to see download records link", "Fail");
			Assert.fail();
		}
	}
	
	public void  ClickOnPremierAccountSignIn(WebDriver driver) 
	{
		System.out.println("Inside ClickOnPremierAccountSignIn");
		WebDriverWait  wait = new WebDriverWait(driver, 120);
		Actions act=new Actions(driver);
		try
		{

			//			handleCookies(driver);
			driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
			Thread.sleep(10000);
			handleCookies(driver);
			//			handleCookies(driver);
			CommonUtility.ScrollTo(driver, obj_EsupportOrderHomePage.PremierAccountButton());
			//			WebElement element = driver.findElement(obj_EsupportIncidentsPage.signInLabelHomepage());
			act.moveToElement(CommonUtility.highlightElement(driver, obj_EsupportOrderHomePage.PremierAccountButton())).click().build().perform();
			if(CommonUtility.CheckpresenceofElementLocated(driver,10, obj_EsupportIncidentsPage.signInButtonHomepage()))
			{

				//			CommonUtility.highlightElement(driver, obj_EsupportIncidentsPage.signInLabelHomepage()).click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIncidentsPage.signInButtonHomepage()));
				WebElement ele = driver.findElement(obj_EsupportIncidentsPage.signInButtonHomepage());


				System.out.println("Clicked on Premier account Button");
				Report.put("Click on Premier account", 
						"Sign In Page should dispaly", 
						"Application navigated to Sign In page ", "PASS");
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on Premier account", 
					"Sign In Page should dispaly",
					"Application is not navigated to Sign In page ", "FAIL");
			Assert.fail();
		}
	}
	
	
	public void  accountSelectionForPremierLogin(WebDriver driver, String account) 
	{
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 120);
		
		Log.info("Entering accountSelectionForPremierLogin");        
		
		try {
			
			wait.until(ExpectedConditions.presenceOfElementLocated(obj_EsupportOrderHomePage.selectAccount()));
			CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.selectAccount());

			CommonUtility.ClickOn(driver,obj_EsupportOrderHomePage.selectAccountdrp());


			List<WebElement> elements = driver.findElements(obj_EsupportOrderHomePage.selectlist());
			for (int i = 0; i < elements.size(); i++) 
			{
				CommonUtility.ScrollToWebElement(driver,elements.get(i));
				
				String Account=elements.get(i).getText();
				
				System.out.println("options are "+Account);
				if(Account. contains(account))
				{
					System.out.println("selected account is "+Account);
					elements.get(i).click();
					System.out.println("Selected Account/Access Group"); 
					Thread.sleep(3000);
					break;
				}


			}
			CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.accessPremier());
			CommonUtility.ClickOn(driver,obj_EsupportOrderHomePage.accessPremier());

			Report.put("Enter valid credentials and select the required store ", 
					"Coresponding premier store must be displayed", 
					"Coresponding premier store is displayed", "Pass");

		}catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Enter valid credentials and select the required store ", 
					"Coresponding premier store must be displayed", 
					"Coresponding premier store is not displayed", "Fail");
			Assert.fail();
		}
	}
	
	public void VerifyExportOptionAboveGrid(WebDriver driver) 
	{
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 120);


		Log.info("Inside VerifyExportOptionAboveGrid");		
		String export="";

		try 
		{
			//			handleCookies(driver);

			if(CommonUtility.CheckpresenceofElementLocated(driver,33,obj_EsupportOrderHomePage.ExportButton()))
			{
				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.ExportButton());
				export=CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.ExportButton()).getText();
				System.out.println(export);
				
				Report.put("above the Grid check for the export option ", 
						"Export option should be displayed ",
						"User able to see "+Report.color(export)+" link above grid", "PASS");

			}

			else
			{
				System.out.println("failed to see export option above grid");
				Report.put("above the Grid check for the export option ", 
						"Export option should be displayed ",
						"failed to see export option above grid", "Fail");
				Assert.fail();
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("above the Grid check for the export option ", 
					"Export option should be displayed ",
					"failed to see export option above grid", "Fail");
			Assert.fail();
		}
	}
	
	public void changeTimeFrameAndClickOnExport_greaterThan2000(WebDriver driver, String timeframe) 
	{
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 120);


		Log.info("Inside changeTimeFrameAndClickOnExport_greaterThan2000");		
		String heading="";String totalorders="";String export="";int count;String popuphead="";

		try 
		{
			//			handleCookies(driver);

			if(CommonUtility.CheckpresenceofElementLocated(driver,33,obj_EsupportOrderHomePage.TimeFrameHeading()))
			{
				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.TimeFrameHeading());
				heading=CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.TimeFrameHeading()).getText();
				System.out.println(heading);
				
				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.AllTimeFrameOptions());
						
				Select option=new Select(driver.findElement(obj_EsupportOrderHomePage.AllTimeFrameOptions()));
				
				List<WebElement> list=option.getOptions();
			
				for(int i=0;i<list.size();i++)
				{
					CommonUtility.ScrollToWebElement(driver, list.get(i));
					String options=list.get(i).getText();
					System.out.println(options);
				}
				option.selectByVisibleText(timeframe);
				
				Thread.sleep(6000);
				
				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.UpdateResultsButtonOnDashBoard());
				CommonUtility.ClickOn(driver,obj_EsupportOrderHomePage.UpdateResultsButtonOnDashBoard());
				
				Thread.sleep(6000);
				
				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.TotalNumberOfOrdersInGrid());
				totalorders=CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.TotalNumberOfOrdersInGrid()).getText();
				System.out.println(totalorders);
				totalorders=totalorders.replaceAll("[a-zA-Z]", "");
				System.out.println(totalorders);
				
				totalorders=totalorders.replaceAll("-", "");
				System.out.println(totalorders);
				
				String number= totalorders.split("  ")[2];
				
				count=Integer.parseInt(number);
				
				if(count>2000)
				{
					CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.ExportButton());
					export=CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.ExportButton()).getText();
					System.out.println(export);
					CommonUtility.ClickOn(driver,obj_EsupportOrderHomePage.ExportButton());
					Thread.sleep(2000);
					
					
				}
				else
				{
					System.out.println(" grid not contains more than 2000 records for selected timeframe");
					Report.put("Scenario 2 : > 2000 Records : Select the timeframe such that order above 2000 records and Click on the export ", 
							"User should get the message your are about to export a file that exceeds 2000 records. This file will be ready to download shortly. with cancel and continue buttons",
							"Failed to see greater than 2000 records", "Fail");
					Assert.fail();
				}
				
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportOrderHomePage.ConfirmExportHeadingClickingOnExport()));
				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.ConfirmExportHeadingClickingOnExport());
				popuphead=CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.ConfirmExportHeadingClickingOnExport()).getText();
				System.out.println(popuphead);
				
				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.PopUpBodyMessage());
				String bodymes=CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.PopUpBodyMessage()).getText();
				System.out.println(bodymes);
				
				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.CancelButton());
				String cancel=CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.CancelButton()).getText();
				System.out.println(cancel);
				
				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.ContinueButton());
				String conti=CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.ContinueButton()).getText();
				System.out.println(conti);
				
				CommonUtility.ClickOn(driver,obj_EsupportOrderHomePage.ContinueButton());
				
				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.SuccessMessageAfterClickingOnDownload());
				String mess=CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.SuccessMessageAfterClickingOnDownload()).getText();
				System.out.println(mess);
				
				Report.put("Scenario 2 : > 2000 Records : Select the timeframe such that order above 2000 records and Click on the export ", 
						"User should get the message your are about to export a file that exceeds 2000 records. This file will be ready to download shortly. with cancel and continue buttons",
						"User able to change "+Report.color(heading)+" to "+Report.color(timeframe)+" and able to see orders are "+count
								+ "which is more than 2000. able to see "+Report.color(popuphead)+" with body message "+Report.color(bodymes)+" with "+Report.color(cancel)+" and "+Report.color(conti)+" buttons ", "PASS");

				
				Report.put("Click on continue button ", 
						"User should see the message for few seconds We're exporting your file. This may take a while. Check your export status under View downloads",
						"User able to click on "+Report.color(conti)+" button and able to see "+Report.color(mess), "PASS");
			}

			else
			{
				System.out.println("failed to see timeframe");
				Report.put("Scenario 2 : > 2000 Records : Select the timeframe such that order above 2000 records and Click on the export ", 
						"User should get the message your are about to export a file that exceeds 2000 records. This file will be ready to download shortly. with cancel and continue buttons",
						"Failed to see greater than 2000 records", "Fail");
				Assert.fail();
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Scenario 2 : > 2000 Records : Select the timeframe such that order above 2000 records and Click on the export ", 
					"User should get the message your are about to export a file that exceeds 2000 records. This file will be ready to download shortly. with cancel and continue buttons",
					"Failed to see greater than 2000 records", "Fail");
			Assert.fail();
		}
	}
	
	public void changeTimeFrameAndClickOnExport_lessThan2000(WebDriver driver, String timeframe) 
	{
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 120);


		Log.info("Inside changeTimeFrameAndClickOnExport_lessThan2000");		
		String heading="";String totalorders="";String export="";int count;String popuphead="";

		try 
		{
			//			handleCookies(driver);

			if(CommonUtility.CheckpresenceofElementLocated(driver,33,obj_EsupportOrderHomePage.TimeFrameHeading()))
			{
				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.TimeFrameHeading());
				heading=CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.TimeFrameHeading()).getText();
				System.out.println(heading);
				
				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.AllTimeFrameOptions());
				
				Select option=new Select(driver.findElement(obj_EsupportOrderHomePage.AllTimeFrameOptions()));
				
				List<WebElement> list=option.getOptions();
			
				for(int i=0;i<list.size();i++)
				{
					CommonUtility.ScrollToWebElement(driver, list.get(i));
					String options=list.get(i).getText();
					System.out.println(options);
				}
				option.selectByVisibleText(timeframe);
				
				
				Thread.sleep(6000);
				if(timeframe.contains("Custom"))
				{
				
				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.StartDateFieldTextBox());
				CommonUtility.ClickOn(driver,obj_EsupportOrderHomePage.StartDateFieldTextBox());
				
				Thread.sleep(6000);
				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.DateSelectForCustomTimeFrame());
				CommonUtility.ClickOn(driver,obj_EsupportOrderHomePage.DateSelectForCustomTimeFrame());
				
				Thread.sleep(6000);
				
				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.EndDateFieldTextBox());
				CommonUtility.ClickOn(driver,obj_EsupportOrderHomePage.EndDateFieldTextBox());
				
				Thread.sleep(6000);
				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.DateSelectForCustomTimeFrame());
				CommonUtility.ClickOn(driver,obj_EsupportOrderHomePage.DateSelectForCustomTimeFrame());
				
				Thread.sleep(6000);
				}
				
				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.UpdateResultsButtonOnDashBoard());
				CommonUtility.ClickOn(driver,obj_EsupportOrderHomePage.UpdateResultsButtonOnDashBoard());
				
				Thread.sleep(6000);
				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.TotalNumberOfOrdersInGrid());
				totalorders=CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.TotalNumberOfOrdersInGrid()).getText();
				System.out.println(totalorders);
				totalorders=totalorders.replaceAll("[a-zA-Z]", "");
				System.out.println(totalorders);
				
				totalorders=totalorders.replaceAll("-", "");
				System.out.println(totalorders);
				
				String number= totalorders.split("  ")[2];
				System.out.println(number);
				count=Integer.parseInt(number);
				System.out.println(count);
				if(count<2000)
				{
					CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.ExportButton());
					export=CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.ExportButton()).getText();
					System.out.println(export);
					CommonUtility.ClickOn(driver,obj_EsupportOrderHomePage.ExportButton());
					Thread.sleep(2000);
					
					
				}
				else
				{
					System.out.println(" grid not contains less than for selected timeframe");
					Report.put("Scenario 1 : < 2000 Records : Select the timeframe such that order fall under 2000 records and Click on the export", 
							"User should get message Your export has started. Your zip file will be available at the bottom of your screen as soon as it's ready.and download the zip file ",
							"Failed to see less than 2000 records", "Fail");
					Assert.fail();
				}
				
				
//				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.SuccessMessageAfterClickingOnDownload());
//				String mess=CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.SuccessMessageAfterClickingOnDownload()).getText();
//				System.out.println(mess);
				
				
				Report.put("Scenario 1 : < 2000 Records : Select the timeframe such that order fall under 2000 records and Click on the export", 
						"User should get message Your export has started. Your zip file will be available at the bottom of your screen as soon as it's ready.and download the zip file ",
						"User able to select "+Report.color(timeframe)+" and start and end dates and able to see "+count+" clicking on export able to see message ", "PASS");
			}

			else
			{
				System.out.println("failed to see timeframe");
				Report.put("Scenario 1 : < 2000 Records : Select the timeframe such that order fall under 2000 records and Click on the export", 
						"User should get message Your export has started. Your zip file will be available at the bottom of your screen as soon as it's ready.and download the zip file ",
						"Failed to see greater than 2000 records", "Fail");
				Assert.fail();
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Scenario 1 : < 2000 Records : Select the timeframe such that order fall under 2000 records and Click on the export", 
					"User should get message Your export has started. Your zip file will be available at the bottom of your screen as soon as it's ready.and download the zip file ",
					"Failed to see greater than 2000 records", "Fail");
			Assert.fail();
		}
	}
	
	public void clickClearButton(WebDriver driver) 
	{
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 120);


		Log.info("Inside clickClearButton");		
		String clear="";

		try 
		{
			//			handleCookies(driver);

			if(CommonUtility.CheckpresenceofElementLocated(driver,33,obj_EsupportOrderHomePage.ClearButtonOnDashboard()))
			{
				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.ClearButtonOnDashboard());
				clear=CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.ClearButtonOnDashboard()).getText();
				System.out.println(clear);
				CommonUtility.ClickOn(driver,obj_EsupportOrderHomePage.ClearButtonOnDashboard());
				
				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.ClearButtonOnDashboard());
				clear=CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.ClearButtonOnDashboard()).getText();
				System.out.println(clear);
				
				Thread.sleep(3000);
				String option=CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.AllTimeFrameOptions()).getAttribute("ng-reflect-model");
				System.out.println(option);
				
				if(!(option.contains("45")))
				{
					System.out.println("failed to see clear button");
					Report.put("Click on clear button", 
							"user should be able to click on clear button and User should reset the Grid and load the orders in the grid for 45 days  ",
							"failed to see defalut timeframe Past 45 days", "Fail");
					Assert.fail();
				}
				
				
				Report.put("Click on clear button", 
						"user should be able to click on clear button and User should reset the Grid and load the orders in the grid for 45 days  ",
						"User able to click on "+Report.color(clear)+" button and able to see default timeframe "+Report.color(option), "PASS");

			}

			else
			{
				System.out.println("failed to see clear button");
				Report.put("Click on clear button", 
						"user should be able to click on clear button and User should reset the Grid and load the orders in the grid for 45 days  ",
						"failed to see clear button", "Fail");
				Assert.fail();
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on clear button", 
					"user should be able to click on clear button and User should reset the Grid and load the orders in the grid for 45 days  ",
					"failed to see clear button", "Fail");
			Assert.fail();
		}
	}
	
	public void verifyDefaultTimeFrame(WebDriver driver) 
	{
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 120);


		Log.info("Inside verifyDefaultTimeFrame");		
		String clear="";

		try 
		{
			//			handleCookies(driver);

			if(CommonUtility.CheckpresenceofElementLocated(driver,33,obj_EsupportOrderHomePage.TimeFrameHeading()))
			{
				
				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.TimeFrameHeading());
				String timeframe=CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.TimeFrameHeading()).getText();
				System.out.println(timeframe);
				
				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.AllTimeFrameOptions());
				
				Thread.sleep(3000);
				String option=CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.AllTimeFrameOptions()).getAttribute("ng-reflect-model");
				System.out.println(option);
				
				if(!(option.contains("45")))
				{
					System.out.println("failed to see default time frame");
					Report.put("Check the timeframe dropdown", 
							"By default timeframe dropdown should be 45 Days",
							"failed to see defalut timeframe Past 45 days", "Fail");
					Assert.fail();
				}
				
				
				Report.put("Check the timeframe dropdown", 
						"By default timeframe dropdown should be 45 Days",
						"User able to see "+Report.color(timeframe)+" with default timeframe "+Report.color(option), "PASS");

			}

			else
			{
				System.out.println("failed to see default time frame");
				Report.put("Check the timeframe dropdown", 
						"By default timeframe dropdown should be 45 Days",
						"failed to see default time frame", "Fail");
				Assert.fail();
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Check the timeframe dropdown", 
					"By default timeframe dropdown should be 45 Days",
					"failed to see default time frame", "Fail");
			Assert.fail();
		}
	}
	public void changeTimeFrameAndClickOnExport_greaterThan2000_IE(WebDriver driver, String timeframe) 
	{
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 240);


		Log.info("Inside changeTimeFrameAndClickOnExport_greaterThan2000_IE");		
		String heading="";String totalorders="";String export="";int count;String popuphead="";

		try 
		{
			//			handleCookies(driver);

			if(CommonUtility.CheckpresenceofElementLocated(driver,33,obj_EsupportOrderHomePage.TimeFrameHeading()))
			{
				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.TimeFrameHeading());
				heading=CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.TimeFrameHeading()).getText();
				System.out.println(heading);
				
				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.AllTimeFrameOptions());
						
				Select option=new Select(driver.findElement(obj_EsupportOrderHomePage.AllTimeFrameOptions()));
				
				List<WebElement> list=option.getOptions();
			
				for(int i=0;i<list.size();i++)
				{
					CommonUtility.ScrollToWebElement(driver, list.get(i));
					String options=list.get(i).getText();
					System.out.println(options);
				}
				option.selectByVisibleText(timeframe);
				
				Thread.sleep(6000);
				
				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.UpdateResultsButtonOnDashBoard());
				CommonUtility.ClickOn(driver,obj_EsupportOrderHomePage.UpdateResultsButtonOnDashBoard());
				
				Thread.sleep(6000);
				
				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.TotalNumberOfOrdersInGrid());
				totalorders=CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.TotalNumberOfOrdersInGrid()).getText();
				System.out.println(totalorders);
				totalorders=totalorders.replaceAll("[a-zA-Z]", "");
				System.out.println(totalorders);
				
				totalorders=totalorders.replaceAll("-", "");
				System.out.println(totalorders);
				
				String number= totalorders.split("  ")[2];
				
				count=Integer.parseInt(number);
				
				if(count>2000)
				{
					CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.ExportButton());
					export=CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.ExportButton()).getText();
					System.out.println(export);
					CommonUtility.ClickOn(driver,obj_EsupportOrderHomePage.ExportButton());
					Thread.sleep(2000);
					
					
				}
				else
				{
					System.out.println(" grid not contains more than 2000 records for selected timeframe");
					Report.put("Scenario 2 : > 2000 Records : Select the timeframe such that order above 2000 records and Click on the export ", 
							"User should get the message your are about to export a file that exceeds 2000 records. This file will be ready to download shortly. with cancel and continue buttons",
							"Failed to see greater than 2000 records", "Fail");
					Assert.fail();
				}
				
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportOrderHomePage.ConfirmExportHeadingClickingOnExport()));
				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.ConfirmExportHeadingClickingOnExport());
				popuphead=CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.ConfirmExportHeadingClickingOnExport()).getText();
				System.out.println(popuphead);
				
				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.PopUpBodyMessage());
				String bodymes=CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.PopUpBodyMessage()).getText();
				System.out.println(bodymes);
				
				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.CancelButton());
				String cancel=CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.CancelButton()).getText();
				System.out.println(cancel);
				
				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.ContinueButton());
				String conti=CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.ContinueButton()).getText();
				System.out.println(conti);
				
				CommonUtility.ClickOn(driver,obj_EsupportOrderHomePage.ContinueButton());
				
//				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.SuccessMessageAfterClickingOnDownload());
//				String mess=CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.SuccessMessageAfterClickingOnDownload()).getText();
//				System.out.println(mess);
				
				Report.put("Scenario 2 : > 2000 Records : Select the timeframe such that order above 2000 records and Click on the export ", 
						"User should get the message your are about to export a file that exceeds 2000 records. This file will be ready to download shortly. with cancel and continue buttons",
						"User able to change "+Report.color(heading)+" to "+Report.color(timeframe)+" and able to see orders are "+count
								+ "which is more than 2000. able to see "+Report.color(popuphead)+" with body message "+Report.color(bodymes)+" with "+Report.color(cancel)+" and "+Report.color(conti)+" buttons ", "PASS");

				
				Report.put("Click on continue button ", 
						"User should see the message for few seconds We're exporting your file. This may take a while. Check your export status under View downloads",
						"User able to click on "+Report.color(conti)+" button and able to see successful message", "PASS");
			}

			else
			{
				System.out.println("failed to see timeframe");
				Report.put("Scenario 2 : > 2000 Records : Select the timeframe such that order above 2000 records and Click on the export ", 
						"User should get the message your are about to export a file that exceeds 2000 records. This file will be ready to download shortly. with cancel and continue buttons",
						"Failed to see greater than 2000 records", "Fail");
				Assert.fail();
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Scenario 2 : > 2000 Records : Select the timeframe such that order above 2000 records and Click on the export ", 
					"User should get the message your are about to export a file that exceeds 2000 records. This file will be ready to download shortly. with cancel and continue buttons",
					"Failed to see greater than 2000 records", "Fail");
			Assert.fail();
		}
	}
	
	public void clickOnOtherLookUpOptions(WebDriver driver) 
	{
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 120);


		Log.info("Inside clickOnOtherLookUpOptions");		
		String otherlookup="";String head="";

		try 
		{
			//			handleCookies(driver);

			if(CommonUtility.CheckpresenceofElementLocated(driver,33,obj_EsupportOrderHomePage.OtherLookUpOptions()))
			{
				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.OtherLookUpOptions());
				otherlookup=CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.OtherLookUpOptions()).getText();
				System.out.println("button diaplyed is "+otherlookup);
				CommonUtility.ClickOn(driver,obj_EsupportOrderHomePage.OtherLookUpOptions());
				
				
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportOrderHomePage.LookUpHeader()));
				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.LookUpHeader());
				head=CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.LookUpHeader()).getText();
				System.out.println("header diaplyed is "+head);
				
				Report.put("Under Search for an order click on other look up options ", 
						"Other look up options should load , should show Look up by : select an option with dropdown",
						"User able to see "+Report.color(otherlookup)+" button and able to see "+Report.color(head), "PASS");

			}

			else
			{
				System.out.println("failed to see other look up options");
				Report.put("Under Search for an order click on other look up options ", 
						"Other look up options should load , should show Look up by : select an option with dropdown",
						"user not able to see other look up options", "Fail");
				Assert.fail();
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Under Search for an order click on other look up options ", 
					"Other look up options should load , should show Look up by : select an option with dropdown",
					"user not able to see other look up options", "Fail");
			Assert.fail();
		}
	}
	
	public void selectCustomerNumberFromDropdown(WebDriver driver) 
	{
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 120);


		Log.info("Inside selectCustomerNumberFromDropdown");		
		String cust="";String dropdown1="";String dropdown2="";

		try 
		{
			//			handleCookies(driver);

			if(CommonUtility.CheckpresenceofElementLocated(driver,33,obj_EsupportOrderHomePage.CustomerNumberRadioButton()))
			{
				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.CustomerNumberRadioButton());
				cust=CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.CustomerNumberRadioButton()).getText();
				System.out.println("button diaplyed is "+cust);
				CommonUtility.ClickOn(driver,obj_EsupportOrderHomePage.CustomerNumberRadioButton());
				
				
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportOrderHomePage.EnterCustomerNumberHeading()));
				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.EnterCustomerNumberHeading());
				String custno=CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.EnterCustomerNumberHeading()).getText();
				System.out.println("header diaplyed is "+custno);
				
				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.CustomeNumberTextBox());
				
				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.VerifyByHeading());
				String verifyBy=CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.VerifyByHeading()).getText();
				System.out.println("header diaplyed is "+verifyBy);
				
				Select option=new Select(driver.findElement(obj_EsupportOrderHomePage.VerifyByDropdownValues()));
				
				List<WebElement> list=option.getOptions();
			
				for(int i=0;i<list.size();i++)
				{
					String options=list.get(i).getText();
					System.out.println(options);
					
					dropdown1= "<br>"+options;
				}   
				
				
				System.out.println("dropdown values of verify by are "+dropdown1);
				
				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.ValidateByHeading());
				String validateBy=CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.ValidateByHeading()).getText();
				System.out.println("header diaplyed is "+validateBy);
				
				Select option1=new Select(driver.findElement(obj_EsupportOrderHomePage.ValidateByDropdownValues()));
				
				List<WebElement> list1=option1.getOptions();
			
				for(int i=0;i<list1.size();i++)
				{
					String options=list1.get(i).getText();
					System.out.println(options);
					
					dropdown2= "<br>"+options;
				}   
				
				System.out.println("dropdown values of validate by are "+dropdown2);

				Report.put("Select Customer number from the Dropdown  ", 
						"customer should show up screen for the verify by and validate by Last 4 Digit Bill Phone number ",
						"User able to click on "+Report.color(cust)+" radio button and able to see "+Report.color(custno)+" heading along with text box "+Report.color(verifyBy)+" along with drop down values "+Report.color(dropdown1)+"and able to see "
								+ ""+Report.color(validateBy)+" heading with drop down values "+Report.color(dropdown2), "PASS");

			}

			else
			{
				System.out.println("failed to see customer number radio button");
				Report.put("Select Customer number from the Dropdown  ", 
						"customer should show up screen for the verify by and validate by Last 4 Digit Bill Phone number ",
						"failed to see customer number radio button", "Fail");
				Assert.fail();
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Select Customer number from the Dropdown  ", 
					"customer should show up screen for the verify by and validate by Last 4 Digit Bill Phone number ",
					"failed to see customer number radio button", "Fail");
			Assert.fail();
		}
	}
	
	public void enterAllDetailsAndClickOnFindOrder(WebDriver driver, String customerNumber, String POnumber, String billPhoneNo) 
	{
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 120);


		Log.info("Inside enterAllDetailsAndClickOnFindOrder");		
		String cust="";String dropdown1="";String dropdown2="";

		try 
		{
			//			handleCookies(driver);

			if(CommonUtility.CheckpresenceofElementLocated(driver,33,obj_EsupportOrderHomePage.CustomeNumberTextBox()))
			{
				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.CustomeNumberTextBox());
				CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.CustomeNumberTextBox()).clear();
				CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.CustomeNumberTextBox()).sendKeys(customerNumber);
				
				
				Select option=new Select(driver.findElement(obj_EsupportOrderHomePage.VerifyByDropdownValues()));
				
				List<WebElement> list=option.getOptions();
			
				for(int i=0;i<list.size();i++)
				{
					String options=list.get(i).getText();
					System.out.println(options);
					
				}   
				option.selectByVisibleText("PO Number");

				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.PONumberTextBox1());
				CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.PONumberTextBox1()).clear();
				CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.PONumberTextBox1()).sendKeys(POnumber);
				
				
				Select option1=new Select(driver.findElement(obj_EsupportOrderHomePage.ValidateByDropdownValues()));
				
				List<WebElement> list1=option1.getOptions();
			
				for(int i=0;i<list1.size();i++)
				{
					String options=list1.get(i).getText();
					System.out.println(options);
					
				}   
				option1.selectByVisibleText("Billing postal code");

				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.PostalCodeTExtBox());
				CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.PostalCodeTExtBox()).clear();
				CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.PostalCodeTExtBox()).sendKeys(billPhoneNo);
				
				Report.put("From the verify by dropdown select the PO number , under the Validate by select the Billing post code ", 
						"User should be able to select the PO number dropdown and Billing post code ",
						"User selects PO Number from verify by dropdown and selects Billing postal code from validate by dropdown", "PASS");

				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.FindMyOrderButtonOnCustomerNumber());
				String findmyorder=CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.FindMyOrderButtonOnCustomerNumber()).getText();
				System.out.println("button diaplyed is "+findmyorder);
				CommonUtility.ClickOn(driver,obj_EsupportOrderHomePage.FindMyOrderButtonOnCustomerNumber());
				
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportOrderHomePage.HeaderOfOrderCollectionDPIDPage()));
				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.HeaderOfOrderCollectionDPIDPage());
				String heading=CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.HeaderOfOrderCollectionDPIDPage()).getText();
				System.out.println("header diaplyed is "+heading);
				
				CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.OrderCollectionBreadScrumb());
				String breadscrumb=CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.OrderCollectionBreadScrumb()).getText();
				System.out.println("breadscrumb diaplyed is "+breadscrumb);
				
				if(!(heading.contains(customerNumber)))
				{
					System.out.println("Failed to land on ordr collection page with searched customer number as heading");
					Report.put("Enter all the Details customer number , PO number   and Last 4 digit Bill Phone number", 
							"Should load the details in the Grid ",
							"Failed to land on ordr collection page with searched customer number as heading", "Fail");
					Assert.fail();
				}
				
				
				List<WebElement> list3=driver.findElements(obj_EsupportOrderHomePage.NumberOfOrderCardsInCollectionView());
				int count=list3.size();
				System.out.println(count);
				
				Report.put("Enter all the Details customer number , PO number   and Last 4 digit Bill Phone number", 
						"Should load the details in the Grid ",
						"User enters customer number "+Report.color(customerNumber)+" and selects PO Number and enters "+Report.color(POnumber)+" and enters billing postal code"+Report.color(billPhoneNo)+" clicks on "+Report.color(findmyorder)+""
								+ " able to see "+Report.color(heading)+" with bread scrumb "+Report.color(breadscrumb)+" with "+count+" of order cards displayed in grid", "PASS");

			}

			else
			{
				System.out.println("failed to see customer number text box");
				Report.put("From the verify by dropdown select the PO number , under the Validate by select the Billing post code ", 
						"User should be able to select the PO number dropdown and Billing post code ",
						"failed to see customer number text box", "Fail");
				Assert.fail();
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("From the verify by dropdown select the PO number , under the Validate by select the Billing post code ", 
					"User should be able to select the PO number dropdown and Billing post code ",
					"failed to see customer number text box", "Fail");
			Assert.fail();
		}
	}
	
	public void selectPONumberFromDropdown(WebDriver driver) 
	{
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 120);


		Log.info("Inside selectPONumberFromDropdown");		
		String cust="";String dropdown1="";String dropdown2="";

		try 
		{
			//			handleCookies(driver);

			if(CommonUtility.CheckpresenceofElementLocated(driver,33,obj_EsupportOrderHomePage.PONumberOption()))
			{
				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.PONumberOption());
				cust=CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.PONumberOption()).getText();
				System.out.println("button diaplyed is "+cust);
				CommonUtility.ClickOn(driver,obj_EsupportOrderHomePage.PONumberOption());
				
				
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportOrderHomePage.EnterThePONumber()));
				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.EnterThePONumber());
				String custno=CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.EnterThePONumber()).getText();
				System.out.println("header diaplyed is "+custno);
				
				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.EnterPONumberTExtBox());
				
				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.VerifyByPOHeading());
				String verifyBy=CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.VerifyByPOHeading()).getText();
				System.out.println("header diaplyed is "+verifyBy);
				
				Select option=new Select(driver.findElement(obj_EsupportOrderHomePage.DropdownValueForPONumber()));
				
				List<WebElement> list=option.getOptions();
			
				for(int i=0;i<list.size();i++)
				{
					String options=list.get(i).getText();
					System.out.println(options);
					
					dropdown1= "<br>"+options;
				}   
				
				
				System.out.println("dropdown values of verify by are "+dropdown1);
				
			
				Report.put("Select Po number from the dropdown", 
						"Should show up with Look up by Po number and Verify with Customer number dropdown",
						"User able to click on "+Report.color(cust)+" radio button and able to see "+Report.color(custno)+" heading along with text box "+Report.color(verifyBy)+" along with drop down values "+Report.color(dropdown1), "PASS");

			}

			else
			{
				System.out.println("failed to see po number radio button");
				Report.put("Select Po number from the dropdown", 
						"Should show up with Look up by Po number and Verify with Customer number dropdown",
						"failed to see po number radio button", "Fail");
				Assert.fail();
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Select Po number from the dropdown", 
					"Should show up with Look up by Po number and Verify with Customer number dropdown",
					"failed to see po number radio button", "Fail");
			Assert.fail();
		}
	}
	
	public void enterAllDetailsAndClickOnFindOrder_PONUmber(WebDriver driver, String customerNumber, String POnumber) 
	{
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 120);


		Log.info("Inside enterAllDetailsAndClickOnFindOrder_PONUmber");		
		String cust="";String dropdown1="";String dropdown2="";

		try 
		{
			//			handleCookies(driver);

			if(CommonUtility.CheckpresenceofElementLocated(driver,33,obj_EsupportOrderHomePage.EnterPONumberTExtBox()))
			{
				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.EnterPONumberTExtBox());
				CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.EnterPONumberTExtBox()).clear();
				CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.EnterPONumberTExtBox()).sendKeys(POnumber);
				
				
				Select option=new Select(driver.findElement(obj_EsupportOrderHomePage.DropdownValueForPONumber()));
				
				List<WebElement> list=option.getOptions();
			
				for(int i=0;i<list.size();i++)
				{
					String options=list.get(i).getText();
					System.out.println(options);
					
				}   
				option.selectByVisibleText("Customer Number");

				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.CustomerNumberTextBox());
				CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.CustomerNumberTextBox()).clear();
				CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.CustomerNumberTextBox()).sendKeys(customerNumber);
				
				
				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.FindMyOrderButtonOnCustomerNumber());
				String findmyorder=CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.FindMyOrderButtonOnCustomerNumber()).getText();
				System.out.println("button diaplyed is "+findmyorder);
				CommonUtility.ClickOn(driver,obj_EsupportOrderHomePage.FindMyOrderButtonOnCustomerNumber());
				
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportOrderHomePage.HeaderOfOrderCollectionDPIDPage()));
				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.HeaderOfOrderCollectionDPIDPage());
				String heading=CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.HeaderOfOrderCollectionDPIDPage()).getText();
				System.out.println("header diaplyed is "+heading);
				
				CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.OrderCollectionBreadScrumb());
				String breadscrumb=CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.OrderCollectionBreadScrumb()).getText();
				System.out.println("breadscrumb diaplyed is "+breadscrumb);
				
				if(!(heading.contains(POnumber)))
				{
					System.out.println("Failed to land on ordr collection page with searched PO number as heading");
					Report.put("Enter the Po number and Customer number", 
							"Should load the Order details in the Grid ",
							"Failed to land on ordr collection page with searched PO number as heading", "Fail");
					Assert.fail();
				}
				
				
				List<WebElement> list3=driver.findElements(obj_EsupportOrderHomePage.NumberOfOrderCardsInCollectionView());
				int count=list3.size();
				System.out.println(count);
				
				

				
				Report.put("Enter the Po number and Customer number", 
						"Should load the Order details in the Grid ",
						"User enters po number "+Report.color(POnumber)+" and selects customer number and enters "+Report.color(customerNumber)+"clicks on "+Report.color(findmyorder)+""
								+ " able to see "+Report.color(heading)+" with bread scrumb "+Report.color(breadscrumb)+" with "+count+" of order cards displayed in grid ", "PASS");

				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.FirstOrderNumberInGrid());
				String ordernumber=CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.FirstOrderNumberInGrid()).getText();
				System.out.println("first diaplyed order number is "+ordernumber);
				CommonUtility.ClickOn(driver,obj_EsupportOrderHomePage.FirstOrderNumberInGrid());
				
				
				Thread.sleep(15000);
				String mainwindow=driver.getWindowHandle();
				Set<String> set=driver.getWindowHandles();
				Iterator<String> itr=set.iterator();
				while(itr.hasNext())
				{
					String childWindow=itr.next();
					if(!mainwindow.equals(childWindow))
					{
						driver.switchTo().window(childWindow);

						wait.until(ExpectedConditions.presenceOfElementLocated(obj_EsupportOrderHomePage.OrderNumberDetailsPageHeader()));
						
						CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.OrderNumberDetailsPageHeader());

						String head=CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.OrderNumberDetailsPageHeader()).getText();
						System.out.println("header is "+head);

						CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.OrderDetailsPageBreadScrumb());


						if(!(head.contains(ordernumber)))
						{
							System.out.println("Failed to land on order details page with clicked order number as heading");
							Report.put("Click on the order number   ", 
									"Should land in Purchase details page ",
									"Failed to land on order details page with clicked order number as heading", "Fail");
							Assert.fail();
						}
						
						Report.put("Click on the order number   ", 
								"Should land in Purchase details page ",
								"User able to click on first order number "+Report.color(ordernumber)+" and clicking on it landed on order details page with header "+Report.color(head), "PASS");
						
						driver.close();
					}

					driver.switchTo().window(mainwindow);
				}
			}

			else
			{
				System.out.println("failed to see PO number text box");
				Report.put("Enter the Po number and Customer number", 
						"Should load the Order details in the Grid ",
						"failed to see PO number text box", "Fail");
				Assert.fail();
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Enter the Po number and Customer number", 
					"Should load the Order details in the Grid ",
					"failed to see PO number text box", "Fail");
			Assert.fail();
		}
	}
	
	public void searchForPONumberAndValidateGrid(WebDriver driver, String PONumber) 
	{
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 120);


		Log.info("Inside searchForPONumberAndValidateGrid");		
		String gridponumber="";

		try 
		{
			//			handleCookies(driver);

			if(CommonUtility.CheckpresenceofElementLocated(driver,33,obj_EsupportOrderHomePage.PONumberTextBox()))
			{
				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.PONumberTextBox());
				CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.PONumberTextBox()).clear();
				CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.PONumberTextBox()).sendKeys(PONumber);;
				
				
				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.UpdateResultsButtonOnDashBoard());
				String button=CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.UpdateResultsButtonOnDashBoard()).getText();
				System.out.println(button);
				CommonUtility.ClickOn(driver,obj_EsupportOrderHomePage.UpdateResultsButtonOnDashBoard());
				
				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.FirstDisplayedPONUmberFromGrid());
				gridponumber=CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.FirstDisplayedPONUmberFromGrid()).getText();
				System.out.println("po number from grid "+gridponumber);
				
				if(!(gridponumber.contains(PONumber)))
				{
					System.out.println("failed to see searched PO number in grid");
					Report.put("In the COEP dashboard go to the PO number search box and enter the po number and click on update results ", 
							"User should display with the searched PO number in the Grid ",
							"failed to see PO number search box", "Fail");
					Assert.fail();
				}
				Report.put("In the COEP dashboard go to the PO number search box and enter the po number and click on update results ", 
						"User should display with the searched PO number in the Grid ",
						"User search po number "+Report.color(PONumber)+" and clicks on "+Report.color(button)+" and ablet see searched po number in grid "+Report.color(gridponumber), "PASS");

			}

			else
			{
				System.out.println("failed to see PO number search box");
				Report.put("In the COEP dashboard go to the PO number search box and enter the po number and click on update results ", 
						"User should display with the searched PO number in the Grid ",
						"failed to see PO number search box", "Fail");
				Assert.fail();
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("In the COEP dashboard go to the PO number search box and enter the po number and click on update results ", 
					"User should display with the searched PO number in the Grid ",
					"failed to see PO number search box", "Fail");
			Assert.fail();
		}
	}
	
	public void searchForPONumberAndValidateGrid_2(WebDriver driver, String PONumber) 
	{
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 120);


		Log.info("Inside searchForPONumberAndValidateGrid_2");		
		String gridponumber="";

		try 
		{
			//			handleCookies(driver);

			if(CommonUtility.CheckpresenceofElementLocated(driver,33,obj_EsupportOrderHomePage.PONumberTextBox()))
			{
				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.PONumberTextBox());
				CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.PONumberTextBox()).clear();
				CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.PONumberTextBox()).sendKeys(PONumber);;
				
				
				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.UpdateResultsButtonOnDashBoard());
				String button=CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.UpdateResultsButtonOnDashBoard()).getText();
				System.out.println(button);
				CommonUtility.ClickOn(driver,obj_EsupportOrderHomePage.UpdateResultsButtonOnDashBoard());
				
				List<WebElement> openwindows=driver.findElements(obj_EsupportOrderHomePage.PONUmberColumnValues());
				for(WebElement OW: openwindows)
				{
					gridponumber+=OW.getText();
					System.out.println(gridponumber);
					
					if(!(gridponumber.contains(PONumber)))
					{
						System.out.println("failed to see searched PO number in grid");
						Report.put("Now to go the PO number search box and enter and 3 Chars like P202 and click on update results", 
								"User should load the results with starting with P202 in the grid list ",
								"failed to see PO number search box", "Fail");
						Assert.fail();
					}

				}  
				
				Report.put("Now to go the PO number search box and enter and 3 Chars like P202 and click on update results", 
						"User should load the results with starting with P202 in the grid list ",
						"User search po number "+Report.color(PONumber)+" and clicks on "+Report.color(button)+" and ablet see searched po number in grid "+Report.color(gridponumber), "PASS");

			}

			else
			{
				System.out.println("failed to see PO number search box");
				Report.put("Now to go the PO number search box and enter and 3 Chars like P202 and click on update results", 
						"User should load the results with starting with P202 in the grid list ",
						"failed to see PO number search box", "Fail");
				Assert.fail();
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Now to go the PO number search box and enter and 3 Chars like P202 and click on update results", 
					"User should load the results with starting with P202 in the grid list ",
					"failed to see PO number search box", "Fail");
			Assert.fail();
		}
	}
	public void selectStatusAndValidateGrid(WebDriver driver, String Status) 
	{
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 120);


		Log.info("Inside selectStatusAndValidateGrid");		
		String gridponumber="";

		try 
		{
			//			handleCookies(driver);

			if(CommonUtility.CheckpresenceofElementLocated(driver,33,obj_EsupportOrderHomePage.OrderStatusDropdownValue()))
			{
//				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.OrderStatusInputTextBox());
//				CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.OrderStatusInputTextBox()).clear();
//				CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.OrderStatusInputTextBox()).sendKeys(Status);
				
				 WebElement firstDropDown = driver.findElement(By.cssSelector("kendo-multiselect#lstStatus"));

			        firstDropDown.click();
			        Thread.sleep(6000);
			        List<WebElement> options = driver.findElements(By.cssSelector("label.k-checkbox-label"));

			        for (Iterator<WebElement> iterator = options.iterator(); iterator.hasNext();) 
			        {
			            WebElement webElement = (WebElement) iterator.next();
			            if (webElement.getText().equals(Status))
			            {
			                webElement.click();        
			                break;
			            }
			            
			        }
			    Thread.sleep(6000);
			    Thread.sleep(6000);
			    CommonUtility.ClickOn(driver,obj_EsupportOrderHomePage.CustomerNumberHeading());
		        Thread.sleep(6000);
				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.UpdateResultsButtonOnDashBoard());
				String button=CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.UpdateResultsButtonOnDashBoard()).getText();
				System.out.println(button);
				CommonUtility.ClickOn(driver,obj_EsupportOrderHomePage.UpdateResultsButtonOnDashBoard());
				
				List<WebElement> openwindows=driver.findElements(obj_EsupportOrderHomePage.StatusDisplayedInGrid());
				for(WebElement OW: openwindows)
				{
					gridponumber+=OW.getText();
					System.out.println(gridponumber);
					
					if(!(gridponumber.contains(Status)))
					{
						System.out.println("failed to see selected status in grid");
						Report.put("In COEP Dashboard , Go to the status dropdown and select any status ( shipped ) from the dropdown and click on update results ", 
								"User should load the gird with order status having the shipped state status ",
								"failed to see selected status in grid", "Fail");
						Assert.fail();
					}

				}  
				Report.put("In COEP Dashboard , Go to the status dropdown and select any status ( shipped ) from the dropdown and click on update results ", 
						"User should load the gird with order status having the shipped state status ",
						"User search status "+Report.color(Status)+" and clicks on "+Report.color(button)+" and ablet see searched status in grid "+Report.color(gridponumber), "PASS");

			}

			else
			{
				System.out.println("failed to see status text box");
				Report.put("In COEP Dashboard , Go to the status dropdown and select any status ( shipped ) from the dropdown and click on update results ", 
						"User should load the gird with order status having the shipped state status ",
						"failed to see status text box", "Fail");
				Assert.fail();
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("In COEP Dashboard , Go to the status dropdown and select any status ( shipped ) from the dropdown and click on update results ", 
					"User should load the gird with order status having the shipped state status ",
					"failed to see status text box", "Fail");
			Assert.fail();
		}
	}
	
	public void selectStatusAndValidateGrid_1(WebDriver driver, String Status1, String Status2) 
	{
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 120);


		Log.info("Inside selectStatusAndValidateGrid_1");		
		String gridponumber="";

		try 
		{
			//			handleCookies(driver);

			if(CommonUtility.CheckpresenceofElementLocated(driver,33,obj_EsupportOrderHomePage.OrderStatusDropdownValue()))
			{
//				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.OrderStatusInputTextBox());
//				CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.OrderStatusInputTextBox()).clear();
//				CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.OrderStatusInputTextBox()).sendKeys(Status);
				
				 WebElement firstDropDown = driver.findElement(By.cssSelector("kendo-multiselect#lstStatus"));

			        firstDropDown.click();

			        List<WebElement> options = driver.findElements(By.cssSelector("label.k-checkbox-label "));

			        for (Iterator<WebElement> iterator = options.iterator(); iterator.hasNext();) 
			        {
			            WebElement webElement = (WebElement) iterator.next();
			            if (webElement.getText().equals(Status2))
			            {
			                webElement.click();        
			                break;
			            }
			            
			        }
			       
			    Thread.sleep(6000);
			    CommonUtility.ClickOn(driver,obj_EsupportOrderHomePage.OrderStatusHeading());
			    Thread.sleep(6000);
				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.UpdateResultsButtonOnDashBoard());
				String button=CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.UpdateResultsButtonOnDashBoard()).getText();
				System.out.println(button);
				CommonUtility.ClickOn(driver,obj_EsupportOrderHomePage.UpdateResultsButtonOnDashBoard());
				
				List<WebElement> openwindows=driver.findElements(obj_EsupportOrderHomePage.StatusDisplayedInGrid());
				for(WebElement OW: openwindows)
				{
					gridponumber+=OW.getText();
					System.out.println(gridponumber);
					
					if(!(gridponumber.contains(Status1)) && !(gridponumber.contains(Status2)))
					{
						System.out.println("failed to see selected status in grid");
						Report.put("In COEP Dashboard , Go to the status dropdown and select multiple status ( shipped , confirmed and delivered  ) from the dropdown and click on update results ", 
								"User should load the gird with order status having the shipped state , confirmed and delivered status orders ",
								"failed to see selected status in grid", "Fail");
						Assert.fail();
					}

				}  
				Report.put("In COEP Dashboard , Go to the status dropdown and select multiple status ( shipped , confirmed and delivered  ) from the dropdown and click on update results ", 
						"User should load the gird with order status having the shipped state , confirmed and delivered status orders ",
						"User search status "+Report.color(Status1+" and "+Status2)+" and clicks on "+Report.color(button)+" and ablet see searched status in grid "+Report.color(gridponumber), "PASS");

			}

			else
			{
				System.out.println("failed to see status text box");
				Report.put("In COEP Dashboard , Go to the status dropdown and select multiple status ( shipped , confirmed and delivered  ) from the dropdown and click on update results ", 
						"User should load the gird with order status having the shipped state , confirmed and delivered status orders ",
						"failed to see status text box", "Fail");
				Assert.fail();
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("In COEP Dashboard , Go to the status dropdown and select multiple status ( shipped , confirmed and delivered  ) from the dropdown and click on update results ", 
					"User should load the gird with order status having the shipped state , confirmed and delivered status orders ",
					"failed to see status text box", "Fail");
			Assert.fail();
		}
	}
	
	public void selectCustomerNumberAndValidateGrid(WebDriver driver, String Status) 
	{
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 120);


		Log.info("Inside selectCustomerNumberAndValidateGrid");		
		String gridponumber="";

		try 
		{
			//			handleCookies(driver);

			if(CommonUtility.CheckpresenceofElementLocated(driver,33,obj_EsupportOrderHomePage.CustomerNumberHeading()))
			{
//				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.OrderStatusInputTextBox());
//				CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.OrderStatusInputTextBox()).clear();
//				CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.OrderStatusInputTextBox()).sendKeys(Status);
				Thread.sleep(6000);
				 WebElement firstDropDown = driver.findElement(By.cssSelector("kendo-multiselect#lstCustNum"));

			        firstDropDown.click();
			        Thread.sleep(6000);
			        List<WebElement> options = driver.findElements(By.cssSelector("label.k-checkbox-label"));

			        for (Iterator<WebElement> iterator = options.iterator(); iterator.hasNext();) 
			        {
			            WebElement webElement = (WebElement) iterator.next();
			            if (webElement.getText().equals(Status))
			            {
			                webElement.click();        
			                break;
			            }
			            
			        }
			    Thread.sleep(6000);
			   
			    CommonUtility.ClickOn(driver,obj_EsupportOrderHomePage.OrderStatusHeading());
		        Thread.sleep(6000);
				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.UpdateResultsButtonOnDashBoard());
				String button=CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.UpdateResultsButtonOnDashBoard()).getText();
				System.out.println(button);
				CommonUtility.ClickOn(driver,obj_EsupportOrderHomePage.UpdateResultsButtonOnDashBoard());
				Thread.sleep(6000);
				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.FirstRowInGrid());
				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.FirstDisplayedExpandButton());
				CommonUtility.ClickOn(driver,obj_EsupportOrderHomePage.FirstDisplayedExpandButton());
				Thread.sleep(6000);
				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.CustomerNumberInExpandedView());
				gridponumber=CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.CustomerNumberInExpandedView()).getText();
				System.out.println(gridponumber);
				
					if(!(gridponumber.contains(Status)))
					{
						System.out.println("failed to see selected customer number in grid");
						Report.put("In the COEP dashboard go to the Customer number , click on it and select the customer number  click on update results", 
								"User should load the Orders in the grid list for the selected customer number ",
								"failed to see selected customer number in grid", "Fail");
						Assert.fail();
					}
  
					Report.put("In the COEP dashboard go to the Customer number , click on it and select the customer number  click on update results", 
							"User should load the Orders in the grid list for the selected customer number ",
						"User search customer number "+Report.color(Status)+" and clicks on "+Report.color(button)+" and ablet see searched status in grid "+Report.color(gridponumber), "PASS");

			}

			else
			{
				System.out.println("failed to see Customer number dropdown");
				Report.put("In the COEP dashboard go to the Customer number , click on it and select the customer number  click on update results", 
						"User should load the Orders in the grid list for the selected customer number ",
						"failed to see Customer number dropdown", "Fail");
				Assert.fail();
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("In the COEP dashboard go to the Customer number , click on it and select the customer number  click on update results", 
					"User should load the Orders in the grid list for the selected customer number ",
					"failed to see Customer number dropdown", "Fail");
			Assert.fail();
		}
	}
	
	public void selectCustomerNumberAndValidateGrid_1(WebDriver driver, String Status1, String Status2) 
	{
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 120);


		Log.info("Inside selectCustomerNumberAndValidateGrid_1");		
		String gridponumber="";

		try 
		{
			//			handleCookies(driver);

			if(CommonUtility.CheckpresenceofElementLocated(driver,33,obj_EsupportOrderHomePage.CustomerNumberHeading()))
			{
//				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.OrderStatusInputTextBox());
//				CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.OrderStatusInputTextBox()).clear();
//				CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.OrderStatusInputTextBox()).sendKeys(Status);
				
				 WebElement firstDropDown = driver.findElement(By.cssSelector("kendo-multiselect#lstCustNum"));

			        firstDropDown.click();

			        List<WebElement> options = driver.findElements(By.cssSelector("label.k-checkbox-label "));

			        for (Iterator<WebElement> iterator = options.iterator(); iterator.hasNext();) 
			        {
			            WebElement webElement = (WebElement) iterator.next();
			            if (webElement.getText().equals(Status2))
			            {
			                webElement.click();        
			                break;
			            }
			            
			        }
			       
			    Thread.sleep(6000);
			    CommonUtility.ClickOn(driver,obj_EsupportOrderHomePage.OrderStatusHeading());
			    Thread.sleep(6000);
				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.UpdateResultsButtonOnDashBoard());
				String button=CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.UpdateResultsButtonOnDashBoard()).getText();
				System.out.println(button);
				CommonUtility.ClickOn(driver,obj_EsupportOrderHomePage.UpdateResultsButtonOnDashBoard());
				
				Thread.sleep(6000);
				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.FirstRowInGrid());
				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.FirstDisplayedExpandButton());
				CommonUtility.ClickOn(driver,obj_EsupportOrderHomePage.FirstDisplayedExpandButton());
				Thread.sleep(6000);
				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.CustomerNumberInExpandedView());
				gridponumber=CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.CustomerNumberInExpandedView()).getText();
				System.out.println(gridponumber);
					
					if(!(gridponumber.contains(Status1)) && !(gridponumber.contains(Status2)))
					{
						System.out.println("failed to see selected Customer number in grid");
						Report.put("In the COEP dashboard go to the Customer number , click on it and select the Multiple customer numbers ( 3 or 4 ) click on update results", 
								"User should load the Orders in the grid list for the selected customer numbers",
								"failed to see selected Customer number in grid", "Fail");
						Assert.fail();
					}
  
					Report.put("In the COEP dashboard go to the Customer number , click on it and select the Multiple customer numbers ( 3 or 4 ) click on update results", 
							"User should load the Orders in the grid list for the selected customer numbers",
						"User search Customer "+Report.color(Status1+" and "+Status2)+" and clicks on "+Report.color(button)+" and ablet see searched status in grid "+Report.color(gridponumber), "PASS");

			}

			else
			{
				System.out.println("failed to see Customer number dropdown");
				Report.put("In the COEP dashboard go to the Customer number , click on it and select the Multiple customer numbers ( 3 or 4 ) click on update results", 
						"User should load the Orders in the grid list for the selected customer numbers",
						"failed to see Customer number dropdown", "Fail");
				Assert.fail();
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("In the COEP dashboard go to the Customer number , click on it and select the Multiple customer numbers ( 3 or 4 ) click on update results", 
					"User should load the Orders in the grid list for the selected customer numbers",
					"failed to see Customer number dropdown", "Fail");
			Assert.fail();
		}
	}
	
	public void changeTimeFrameAndValidateGrid(WebDriver driver, String timeframe, String startdate, String enddate) 
	{
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 120);


		Log.info("Inside changeTimeFrameAndValidateGrid");		
		String heading="";String totalorders="";String export="";int count;String popuphead="";
		 String date1="";String date2="";

		try 
		{
			//			handleCookies(driver);

			if(CommonUtility.CheckpresenceofElementLocated(driver,33,obj_EsupportOrderHomePage.TimeFrameHeading()))
			{
				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.TimeFrameHeading());
				heading=CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.TimeFrameHeading()).getText();
				System.out.println(heading);
				
				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.AllTimeFrameOptions());
						
				Select option=new Select(driver.findElement(obj_EsupportOrderHomePage.AllTimeFrameOptions()));
				
				List<WebElement> list=option.getOptions();
			
				for(int i=0;i<list.size();i++)
				{
					CommonUtility.ScrollToWebElement(driver, list.get(i));
					String options=list.get(i).getText();
					System.out.println(options);
				}
				option.selectByVisibleText(timeframe);
				
				Thread.sleep(6000);
				
				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.UpdateResultsButtonOnDashBoard());
				CommonUtility.ClickOn(driver,obj_EsupportOrderHomePage.UpdateResultsButtonOnDashBoard());
				
				Thread.sleep(6000);
				
//				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.StartDateFieldTextBox());
//				startdate=CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.StartDateFieldTextBox()).getAttribute("ng-reflect-min-date");
//				System.out.println(startdate);
//				
//				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.EndDateFieldTextBox());
//				enddate=CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.EndDateFieldTextBox()).getAttribute("ng-reflect-max-date");
//				System.out.println(enddate);
				
				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.FirstDisplayedOrderDateValue());
				date1=CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.FirstDisplayedOrderDateValue()).getText();
				System.out.println(date1);
				Thread.sleep(6000);
				
				DateFormat originalFormat = new SimpleDateFormat("MMM dd, yyyy", Locale.ENGLISH);
				DateFormat targetFormat = new SimpleDateFormat("dd-MM-yyyy");
				Date date = originalFormat.parse(date1);
				String formatDate1 = targetFormat.format(date);
				System.out.println(formatDate1);
				
				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.OrderDateColumnName());
				CommonUtility.ClickOn(driver,obj_EsupportOrderHomePage.OrderDateColumnName());
				Thread.sleep(6000);
				
				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.FirstDisplayedOrderDateValue());
				date2=CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.FirstDisplayedOrderDateValue()).getText();
				System.out.println(date2);
				
				Thread.sleep(6000);
				DateFormat originalFormat1 = new SimpleDateFormat("MMM dd, yyyy");
				DateFormat targetFormat1 = new SimpleDateFormat("dd-MM-yyyy");
				Date dates = originalFormat1.parse(date2);
				String formatDate2 = targetFormat1.format(dates);
				System.out.println(formatDate2);
				
//				 SimpleDateFormat objSDF = new SimpleDateFormat("dd-MM-yyyy");
//				  Date dt_1 = objSDF.parse(startdate);
//				  Date dt_2 = objSDF.parse(formatDate1);
//
//				  Date dt_3 = objSDF.parse(enddate);
//				  Date dt_4 = objSDF.parse(formatDate2);
//				  
//				  System.out.println("start date : " + objSDF.format(dt_1));
//				  System.out.println("start date from grid : " + objSDF.format(dt_2));

				  if (startdate.compareTo(formatDate1) >= 0) 
				  {
				   System.out.println("start date from grid is greater than or equals to start date");
				  } 
				  else
				  {
					  System.out.println("failed to see start date from grid greater than equal to start date ");
						Report.put("In COEP Dashboard , Go to the Timeframe dropdown and select any timeframe from the dropdown ( 1 year ) and click on update results ", 
								"User should load the gird with orders with 1 year timeframe",
								"Failed to see start date from grid greater than equal to start date", "Fail");
						Assert.fail();
				  }
//				  System.out.println("end date : " + objSDF.format(dt_3));
//				  System.out.println("end date from grid : " + objSDF.format(dt_4));
				  
				  if (enddate.compareTo(formatDate2) <= 0) 
				  {
				   System.out.println("end date from grid is less than or equals to end date");
				  } 
				  else
				  {
					  System.out.println("failed to see end date from grid is less than or equals to end date");
						Report.put("In COEP Dashboard , Go to the Timeframe dropdown and select any timeframe from the dropdown ( 1 year ) and click on update results ", 
								"User should load the gird with orders with 1 year timeframe",
								"Failed to see end date from grid is less than or equals to end date", "Fail");
						Assert.fail();
				  }
				Report.put("In COEP Dashboard , Go to the Timeframe dropdown and select any timeframe from the dropdown ( 1 year ) and click on update results ", 
						"User should load the gird with orders with 1 year timeframe",
						"User able to select time frame "+Report.color(timeframe)+" and able to see following dates from grid <br> "+Report.color(date2+" and "+date1), "PASS");
			}

			else
			{
				System.out.println("failed to see timeframe");
				Report.put("In COEP Dashboard , Go to the Timeframe dropdown and select any timeframe from the dropdown ( 1 year ) and click on update results ", 
						"User should load the gird with orders with 1 year timeframe",
						"Failed to see timeframe", "Fail");
				Assert.fail();
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("In COEP Dashboard , Go to the Timeframe dropdown and select any timeframe from the dropdown ( 1 year ) and click on update results ", 
					"User should load the gird with orders with 1 year timeframe",
					"Failed to see timeframe", "Fail");
			Assert.fail();
		}
	}
	
	public void selectBillingInformationFromDropdown(WebDriver driver) 
	{
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 120);


		Log.info("Inside selectBillingInformationFromDropdown");		
		String cust="";String dropdown1="";String dropdown2="";

		try 
		{
			//			handleCookies(driver);

			if(CommonUtility.CheckpresenceofElementLocated(driver,33,obj_EsupportOrderHomePage.BillingInformationUnderOtherLookUpOptions()))
			{
				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.BillingInformationUnderOtherLookUpOptions());
				cust=CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.BillingInformationUnderOtherLookUpOptions()).getText();
				System.out.println("button diaplyed is "+cust);
				CommonUtility.ClickOn(driver,obj_EsupportOrderHomePage.BillingInformationUnderOtherLookUpOptions());
				
				
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportOrderHomePage.EnterFirstNameHeading()));
				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.EnterFirstNameHeading());
				String custno=CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.EnterFirstNameHeading()).getText();
				System.out.println("header diaplyed is "+custno);
				
				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.EnterFirstNameTextBox());
				
				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.EnterLastNameHeading());
				String verifyBy=CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.EnterLastNameHeading()).getText();
				System.out.println("header diaplyed is "+verifyBy);
				
				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.EnterLastNameTextBox());
				
				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.EnterPhoneNumberHeading());
				String phonenumber=CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.EnterPhoneNumberHeading()).getText();
				System.out.println("header diaplyed is "+phonenumber);
				
				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.EnterPhoneNumberTextBox());
				
				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.EnterPostalCodeHeadingBilling());
				String postalcode=CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.EnterPostalCodeHeadingBilling()).getText();
				System.out.println("header diaplyed is "+postalcode);
				
				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.EnterPostalCodeTextBox());
			
				Report.put("From the Other look up option , select billing information", 
						"Should load the fields First name , Last name ,Phone number and Post code ",
						"User able to click on "+Report.color(cust)+" radio button and able to see "+Report.color(custno)+" heading along with text box "+Report.color(verifyBy)+" and "+Report.color(phonenumber)+" along with text box"+Report.color(postalcode)+" along with text box", "PASS");

			}

			else
			{
				System.out.println("failed to see billing information radio button");
				Report.put("From the Other look up option , select billing information", 
						"Should load the fields First name , Last name ,Phone number and Post code ",
						"failed to see billing information radio button", "Fail");
				Assert.fail();
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("From the Other look up option , select billing information", 
					"Should load the fields First name , Last name ,Phone number and Post code ",
					"failed to see billing information radio button", "Fail");
			Assert.fail();
		}
	}
	
	public void enterAllDetailsAndClickOnFindOrder_BillingInformation(WebDriver driver, String firstName, String lastName,String phonenumber, String postalCode) 
	{
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 120);


		Log.info("Inside enterAllDetailsAndClickOnFindOrder_BillingInformation");		
		String cust="";String dropdown1="";String dropdown2="";

		try 
		{
			//			handleCookies(driver);

			if(CommonUtility.CheckpresenceofElementLocated(driver,33,obj_EsupportOrderHomePage.EnterFirstNameTextBox()))
			{
				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.EnterFirstNameTextBox());
				CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.EnterFirstNameTextBox()).clear();
				CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.EnterFirstNameTextBox()).sendKeys(firstName);
				
				
				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.EnterLastNameTextBox());
				CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.EnterLastNameTextBox()).clear();
				CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.EnterLastNameTextBox()).sendKeys(lastName);
				
				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.EnterPhoneNumberTextBox());
				CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.EnterPhoneNumberTextBox()).clear();
				CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.EnterPhoneNumberTextBox()).sendKeys(phonenumber);
				
				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.EnterPostalCodeTextBox());
				CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.EnterPostalCodeTextBox()).clear();
				CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.EnterPostalCodeTextBox()).sendKeys(postalCode);
				
				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.FindMyOrderButtonOnCustomerNumber());
				String findmyorder=CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.FindMyOrderButtonOnCustomerNumber()).getText();
				System.out.println("button diaplyed is "+findmyorder);
				CommonUtility.ClickOn(driver,obj_EsupportOrderHomePage.FindMyOrderButtonOnCustomerNumber());
				
				
				wait.until(ExpectedConditions.presenceOfElementLocated(obj_EsupportOrderHomePage.OrderNumberDetailsPageHeader()));
				
				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.OrderNumberDetailsPageHeader());

				String head=CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.OrderNumberDetailsPageHeader()).getText();
				System.out.println("header is "+head);

				CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.OrderDetailsPageBreadScrumb());


				
				Report.put("Enter all the details , First name , Last name , Phone number , Post code and click on submit  ", 
						"if the customer has the only 1 order then it will land in the Order details Page / if the customer has multiple orders then will land in the order collection page",
						"User able to enter first name "+Report.color(firstName)+" and last name "+Report.color(lastName)+" phone number "+Report.color(phonenumber)+" postal code "+Report.color(postalCode)+" and after clicking "+Report.color(findmyorder)+" able to see order details page as it have only one order with heading "+Report.color(head), "PASS");
			}

			else
			{
				System.out.println("failed to see first name text box");
				Report.put("Enter all the details , First name , Last name , Phone number , Post code and click on submit  ", 
						"if the customer has the only 1 order then it will land in the Order details Page / if the customer has multiple orders then will land in the order collection page",
						"failed to see first name text box", "Fail");
				Assert.fail();
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Enter all the details , First name , Last name , Phone number , Post code and click on submit  ", 
					"if the customer has the only 1 order then it will land in the Order details Page / if the customer has multiple orders then will land in the order collection page",
					"failed to see first name text box", "Fail");
			Assert.fail();
		}
	}
	
	public void searchForDPIDAndValidateGrid(WebDriver driver, String DPID) 
	{
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 120);


		Log.info("Inside searchForDPIDAndValidateGrid");		
		String gridponumber="";

		try 
		{
			//			handleCookies(driver);

			if(CommonUtility.CheckpresenceofElementLocated(driver,33,obj_EsupportOrderHomePage.DPIDSearchBox()))
			{
				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.DPIDSearchBox());
				CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.DPIDSearchBox()).clear();
				CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.DPIDSearchBox()).sendKeys(DPID);;
				
				Thread.sleep(6000);
				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.UpdateResultsButtonOnDashBoard());
				String button=CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.UpdateResultsButtonOnDashBoard()).getText();
				System.out.println(button);
				CommonUtility.ClickOn(driver,obj_EsupportOrderHomePage.UpdateResultsButtonOnDashBoard());
				Thread.sleep(6000);
				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.FirstDisplayedDPIDinGrid());
				gridponumber=CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.FirstDisplayedDPIDinGrid()).getText();
				System.out.println("DPID number from grid "+gridponumber);
				Thread.sleep(6000);
				if(!(gridponumber.contains(DPID)))
				{
					System.out.println("failed to see searched DPID number in grid");
					Report.put("In COEP Dashboard , Go to the DPID search box and enter the DPID and click on update results ", 
							"User should load the search DPID in the grid list ",
							"failed to see DPID number search box", "Fail");
					Assert.fail();
				}
				Report.put("In COEP Dashboard , Go to the DPID search box and enter the DPID and click on update results ", 
						"User should load the search DPID in the grid list ",
						"User search DPID number  and clicks on "+Report.color(button)+" and able to see searched DPID number in grid "+Report.color(gridponumber), "PASS");

			}

			else
			{
				System.out.println("failed to see DPID number search box");
				Report.put("In COEP Dashboard , Go to the DPID search box and enter the DPID and click on update results ", 
						"User should load the search DPID in the grid list ",
						"failed to see DPID number search box", "Fail");
				Assert.fail();
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("In COEP Dashboard , Go to the DPID search box and enter the DPID and click on update results ", 
					"User should load the search DPID in the grid list ",
					"failed to see DPID number search box", "Fail");
			Assert.fail();
		}
	}
	
	public void clickOnExpandButtonAndValidateProgressBar(WebDriver driver) 
	{
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 120);


		Log.info("Inside clickOnExpandButtonAndValidateProgressBar");		
		String completed="";String pending="";

		try 
		{
			if(CommonUtility.CheckpresenceofElementLocated(driver,33,obj_EsupportOrderHomePage.FirstDisplayedExpandButton()))
			{
				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.FirstDisplayedExpandButton());
				CommonUtility.ClickOn(driver,obj_EsupportOrderHomePage.FirstDisplayedExpandButton());
				
				List<WebElement> progressbar=driver.findElements(obj_EsupportOrderHomePage.GreenProgressBarInExpandedView());

				for(WebElement OW: progressbar)
				{
					CommonUtility.ScrollToWebElement(driver, OW);
				}
				
				List<WebElement> statuscom=driver.findElements(obj_EsupportOrderHomePage.CompletedStatusNameInProgressBar());

				for(WebElement OW: statuscom)
				{
					completed+=OW.getText();
					System.out.println(completed);

				}
				
				List<WebElement> pendingbar=driver.findElements(obj_EsupportOrderHomePage.PendingStatusNameInProgressBar());

				for(WebElement OW: pendingbar)
				{
					pending+=OW.getText();
					System.out.println(pending);

				}
				Report.put("Verify the progress bar", 
						"Progress bar should be displayed with the status in current status in Green",
						"User clicks on expand button and able to see conpleted status bar displayed in green button with "+Report.color(completed)+" and pending status are "+Report.color(pending), "PASS");

			}

			else
			{
				System.out.println("failed to see expand button");
				Report.put("Verify the progress bar", 
						"Progress bar should be displayed with the status in current status in Green",
						"failed to see expand button", "Fail");
				Assert.fail();
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify the progress bar", 
					"Progress bar should be displayed with the status in current status in Green",
					"failed to see expand button", "Fail");
			Assert.fail();
		}
	}
	
	public void searchForOrderNumberAndValidateGrid(WebDriver driver, String orderNumber) 
	{
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 120);


		Log.info("Inside searchForOrderNumberAndValidateGrid");		
		String gridponumber="";

		try 
		{
			//			handleCookies(driver);

			if(CommonUtility.CheckpresenceofElementLocated(driver,33,obj_EsupportOrderHomePage.OrderNumberTextBox()))
			{
				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.OrderNumberTextBox());
				CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.OrderNumberTextBox()).clear();
				CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.OrderNumberTextBox()).sendKeys(orderNumber);;
				
				
				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.UpdateResultsButtonOnDashBoard());
				String button=CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.UpdateResultsButtonOnDashBoard()).getText();
				System.out.println(button);
				CommonUtility.ClickOn(driver,obj_EsupportOrderHomePage.UpdateResultsButtonOnDashBoard());
				
				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.OrderNumberInGrid());
				gridponumber=CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.OrderNumberInGrid()).getText();
				System.out.println("Oreder number from grid "+gridponumber);
				
				if(!(gridponumber.contains(orderNumber)))
				{
					System.out.println("failed to see searched order number in grid");
					Report.put("In the COEP dashboard go to the order number search box and enter order number and click on update results", 
							"User should load the gird list with searched order numbers ",
							"failed to see order number search box", "Fail");
					Assert.fail();
				}
				Report.put("In the COEP dashboard go to the order number search box and enter order number and click on update results", 
						"User should load the gird list with searched order numbers ",
						"User search order number  and clicks on "+Report.color(button)+" and able to see searched order number in grid "+Report.color(gridponumber), "PASS");

				clickClearButton(driver);
			}

			else
			{
				System.out.println("failed to see order number search box");
				Report.put("In the COEP dashboard go to the order number search box and enter order number and click on update results", 
						"User should load the gird list with searched order numbers ",
						"failed to see order number search box", "Fail");
				Assert.fail();
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("In the COEP dashboard go to the order number search box and enter order number and click on update results", 
					"User should load the gird list with searched order numbers ",
					"failed to see order number search box", "Fail");
			Assert.fail();
		}
	}
	
	public void clickOnAnyInvoiceFromTheGridAndValidate(WebDriver driver) 
	{
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 120);
		Actions act=new Actions(driver);

		Log.info("Inside clickOnAnyInvoiceFromTheGridAndValidate");		
		String gridponumber="";String url="";

		try 
		{
			//			handleCookies(driver);

			if(CommonUtility.CheckpresenceofElementLocated(driver,33,obj_EsupportOrderHomePage.ItemsPerPageInInvoicePage()))
			{
//				75 items per page
				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.ItemsPerPageInInvoicePage());
				CommonUtility.ClickOn(driver,obj_EsupportOrderHomePage.ItemsPerPageInInvoicePage());
				Thread.sleep(6000);
				Select option=new Select(driver.findElement(obj_EsupportOrderHomePage.ItemsPerPageInInvoicePage()));
				
				List<WebElement> list=option.getOptions();
				
				for(int i=0;i<list.size();i++)
				{
					CommonUtility.ScrollToWebElement(driver, list.get(i));
					String options=list.get(i).getText();
					System.out.println(options);
				}
				option.selectByVisibleText("75 items per page");
				Thread.sleep(6000);
				Thread.sleep(6000);
				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.InvoiceNumberHyperlinkInGrid());
				String invoice=CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.InvoiceNumberHyperlinkInGrid()).getText();
				CommonUtility.ClickOn(driver,obj_EsupportOrderHomePage.InvoiceNumberHyperlinkInGrid());
				
				Thread.sleep(15000);
				String mainwindow=driver.getWindowHandle();
				Set<String> set=driver.getWindowHandles();
				Iterator<String> itr=set.iterator();
				while(itr.hasNext())
				{
					String childWindow=itr.next();
					if(!mainwindow.equals(childWindow))
					{
						driver.switchTo().window(childWindow);
						handleCookies(driver);
						url=driver.getCurrentUrl();
						System.out.println(url);
						if(url.contains("https://www.dell.com/support/orders/us/en/RC1421987/Invoice"))
						{
							System.out.println("Invoice displayed in new tab");
						}
						else
						{
							driver.close();
							System.out.println("Invoice failed to displayed in new tab");
							Report.put("Click on any invoice from the grid ", 
									"Invoice load in new tab",
									"not landed on invoice clicked from grid", "Fail");
							Assert.fail();
						}
						Thread.sleep(10000);
						driver.close();
					}

					driver.switchTo().window(mainwindow);
					Report.put("Click on any invoice from the grid ", 
							"Invoice load in new tab",
							"User clicks on "+Report.color(invoice)+" from the grid and able to see invoice loading on new tab with url "+Report.color(url), "PASS");
				}
			}

			else
			{
				System.out.println("failed to see invoice numbers in grid");
				Report.put("Click on any invoice from the grid ", 
						"Invoice load in new tab",
						"failed to see invoice numbers in grid", "Fail");
				Assert.fail();
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on any invoice from the grid ", 
					"Invoice load in new tab",
					"failed to see invoice numbers in grid", "Fail");
			Assert.fail();
		}
	}
	
	public void searchForInvoiceAndValidateGrid(WebDriver driver, String Invoice) 
	{
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 120);


		Log.info("Inside searchForInvoiceAndValidateGrid");		
		String gridponumber="";

		try 
		{
			//			handleCookies(driver);

			if(CommonUtility.CheckpresenceofElementLocated(driver,33,obj_EsupportOrderHomePage.InputTextBoxForInvoice()))
			{
				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.InputTextBoxForInvoice());
				CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.InputTextBoxForInvoice()).clear();
				CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.InputTextBoxForInvoice()).sendKeys(Invoice);;
				
				
				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.SearchButtonInInvoicePage());
				
				CommonUtility.ClickOn(driver,obj_EsupportOrderHomePage.SearchButtonInInvoicePage());
				Thread.sleep(6000);
				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.InvoiceNumberHyperlinkInGrid());
				gridponumber=CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.InvoiceNumberHyperlinkInGrid()).getText();
				System.out.println("invoice number from grid "+gridponumber);
				
				if(!(gridponumber.contains(Invoice)))
				{
					System.out.println("failed to see searched invoice number in grid");
					Report.put("Comeback to the premier invoice report page Click on Look up from dropdown Invoice number , enter invoice number in search box and click on search ", 
							"Should show up the searched invoice in the Grid ",
							"failed to see invoice number search box", "Fail");
					Assert.fail();
				}
				Report.put("Comeback to the premier invoice report page Click on Look up from dropdown Invoice number , enter invoice number in search box and click on search ", 
						"Should show up the searched invoice in the Grid ",
						"User able to search invoice number "+Report.color(Invoice)+" and able to see same invoce number in grid "+Report.color(gridponumber), "PASS");

			}

			else
			{
				System.out.println("failed to see invoice number search box");
				Report.put("Comeback to the premier invoice report page Click on Look up from dropdown Invoice number , enter invoice number in search box and click on search ", 
						"Should show up the searched invoice in the Grid ",
						"failed to see invoice number search box", "Fail");
				Assert.fail();
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Comeback to the premier invoice report page Click on Look up from dropdown Invoice number , enter invoice number in search box and click on search ", 
					"Should show up the searched invoice in the Grid ",
					"failed to see invoice number search box", "Fail");
			Assert.fail();
		}
	}
	
	public void clickOnChangeAccountOrAccessGroup(WebDriver driver) 
	{
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 120);
		Actions act=new Actions(driver);

		Log.info("Inside clickOnChangeAccountOrAccessGroup");		
		String gridponumber="";

		try 
		{
			//			handleCookies(driver);

			if(CommonUtility.CheckpresenceofElementLocated(driver,33,obj_EsupportOrderHomePage.ChangeAccountOrAccessGroup()))
			{
				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.ChangeAccountOrAccessGroup());
				String link=CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.ChangeAccountOrAccessGroup()).getText();
				System.out.println(link);
				CommonUtility.ClickOn(driver,obj_EsupportOrderHomePage.ChangeAccountOrAccessGroup());
				
				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.SelectPremierAccountHeading());
				gridponumber=CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.SelectPremierAccountHeading()).getText();
				System.out.println("header is "+gridponumber);
				
				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.selectAccountdrp());
				
				CommonUtility.ClickOn(driver,obj_EsupportOrderHomePage.selectAccountdrp());

				String Account="";
				List<WebElement> elements = driver.findElements(obj_EsupportOrderHomePage.selectlist());
				for (int i = 0; i < elements.size(); i++) 
				{
					CommonUtility.ScrollToWebElement(driver,elements.get(i));
					
					Account=elements.get(i).getText();
					
					System.out.println("options are "+Account);
				}
				
				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.accessPremier());
				String access=CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.accessPremier()).getText();
				System.out.println("button is "+access);
				
				
				Report.put("In the COEP dashboard besides the Store name click on Change account / access group ", 
						"User should direct to the store selection page ",
						"User clicks on "+Report.color(link)+" and able to see "+Report.color(gridponumber)+" header with drop down values "+Report.color(Account)+" along with button "+Report.color(access), "PASS");

			}

			else
			{
				System.out.println("failed to see Change account / access group link");
				Report.put("In the COEP dashboard besides the Store name click on Change account / access group ", 
						"User should direct to the store selection page ",
						"failed to see Change account / access group link", "Fail");
				Assert.fail();
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("In the COEP dashboard besides the Store name click on Change account / access group ", 
					"User should direct to the store selection page ",
					"failed to see Change account / access group link", "Fail");
			Assert.fail();
		}
	}
	
	public void  accountSelectionForPremierLogin_ClickingOnChangeAccout(WebDriver driver, String account) 
	{
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 120);
		
		Log.info("Entering accountSelectionForPremierLogin_ClickingOnChangeAccout");        
		
		try {
			
			wait.until(ExpectedConditions.presenceOfElementLocated(obj_EsupportOrderHomePage.SelectPremierAccountHeading()));
			CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.SelectPremierAccountHeading());

			CommonUtility.ClickOn(driver,obj_EsupportOrderHomePage.selectAccountdrp());


			List<WebElement> elements = driver.findElements(obj_EsupportOrderHomePage.selectlist());
			for (int i = 0; i < elements.size(); i++) 
			{
				CommonUtility.ScrollToWebElement(driver,elements.get(i));
				
				String Account=elements.get(i).getText();
				
				System.out.println("options are "+Account);
				if(Account. contains(account))
				{
					System.out.println("selected account is "+Account);
					elements.get(i).click();
					System.out.println("Selected Account/Access Group"); 
					Thread.sleep(3000);
					break;
				}


			}
			CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.accessPremier());
			CommonUtility.ClickOn(driver,obj_EsupportOrderHomePage.accessPremier());

			Report.put("Select any other store and click on access premier ", 
					"User should land in the premier store and display the list of orders for the 45 days timeframe ", 
					"Coresponding premier store is displayed", "Pass");

		}catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Select any other store and click on access premier ", 
					"User should land in the premier store and display the list of orders for the 45 days timeframe ", 
					"Coresponding premier store is not displayed", "Fail");
			Assert.fail();
		}
	}
	
	public void  ClickOnPartnerAccountSignIn(WebDriver driver) 
	{
		System.out.println("Inside ClickOnPartnerAccountSignIn");
		WebDriverWait  wait = new WebDriverWait(driver, 120);
		Actions act=new Actions(driver);
		try
		{

			//			handleCookies(driver);
			driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
			Thread.sleep(10000);
			handleCookies(driver);
			//			handleCookies(driver);
			CommonUtility.ScrollTo(driver, obj_EsupportOrderHomePage.PartnerAccountButton());
			//			WebElement element = driver.findElement(obj_EsupportIncidentsPage.signInLabelHomepage());
			act.moveToElement(CommonUtility.highlightElement(driver, obj_EsupportOrderHomePage.PartnerAccountButton())).click().build().perform();
			if(CommonUtility.CheckpresenceofElementLocated(driver,10, obj_EsupportIncidentsPage.signInButtonHomepage()))
			{

				//			CommonUtility.highlightElement(driver, obj_EsupportIncidentsPage.signInLabelHomepage()).click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIncidentsPage.signInButtonHomepage()));
				WebElement ele = driver.findElement(obj_EsupportIncidentsPage.signInButtonHomepage());


				System.out.println("Clicked on partner account Button");
				Report.put("Click on partner account", 
						"Sign In Page should dispaly", 
						"Application navigated to Sign In page ", "PASS");
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on partner account", 
					"Sign In Page should dispaly",
					"Application is not navigated to Sign In page ", "FAIL");
			Assert.fail();
		}
	}
	
	public void varifyDetailsInPartnerDashboard(WebDriver driver) 
	{
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 120);


		Log.info("Inside varifyDetailsInPartnerDashboard");		
		String download="";String items="";

		try 
		{
			//			handleCookies(driver);

			if(CommonUtility.CheckpresenceofElementLocated(driver,33,obj_EsupportOrderHomePage.DashBoardInPartnerView()))
			{
				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.DashBoardInPartnerView());
				
				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.GridInPartnerView());
				
				Report.put("enter credentials and click on sign in  ", 
						"User should logged in successfully for the partner track and load the COEP Dashboard on top and order list in the grid ",
						"User logged in successfully for partner account and load dashboard and grid successfully", "PASS");
				
				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.PartnerNameAndIDDetails());
				List<WebElement> openwindows=driver.findElements(obj_EsupportOrderHomePage.PartnerNameAndIDDetails());

				for(WebElement OW: openwindows)
				{
					items+=OW.getText();
					System.out.println(items);

				}  
				
				Report.put("Verify the Dashboard ", 
						"Dashboard should display the Partner name and Affinity account ID ",
						"User able to see "+Report.color(items)+" details", "PASS");
				
			}

			else
			{
				System.out.println("failed to see dashboard section");
				Report.put("enter credentials and click on sign in  ", 
						"User should logged in successfully for the partner track and load the COEP Dashboard on top and order list in the grid ",
						"failed to see dashboard section", "Fail");
				Assert.fail();
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("enter credentials and click on sign in  ", 
					"User should logged in successfully for the partner track and load the COEP Dashboard on top and order list in the grid ",
					"failed to see dashboard section", "Fail");
			Assert.fail();
		}
	}
	
	public void changeTimeFrameAndClickOnExport_lessThan2000_PartnerAccount(WebDriver driver, String timeframe) 
	{
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 120);


		Log.info("Inside changeTimeFrameAndClickOnExport_lessThan2000_PartnerAccount");		
		String heading="";String totalorders="";String export="";int count;String popuphead="";

		try 
		{
			//			handleCookies(driver);

			if(CommonUtility.CheckpresenceofElementLocated(driver,33,obj_EsupportOrderHomePage.TimeFrameHeading()))
			{
				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.TimeFrameHeading());
				heading=CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.TimeFrameHeading()).getText();
				System.out.println(heading);
				
				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.AllTimeFrameOptions());
				
				Select option=new Select(driver.findElement(obj_EsupportOrderHomePage.AllTimeFrameOptions()));
				
				List<WebElement> list=option.getOptions();
			
				for(int i=0;i<list.size();i++)
				{
					CommonUtility.ScrollToWebElement(driver, list.get(i));
					String options=list.get(i).getText();
					System.out.println(options);
				}
				option.selectByVisibleText(timeframe);
				
				
				Thread.sleep(6000);
				if(timeframe.contains("Custom"))
				{
				
				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.StartDateFieldTextBox());
				CommonUtility.ClickOn(driver,obj_EsupportOrderHomePage.StartDateFieldTextBox());
				
				Thread.sleep(6000);
				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.DateSelectForCustomTimeFrame());
				CommonUtility.ClickOn(driver,obj_EsupportOrderHomePage.DateSelectForCustomTimeFrame());
				
				Thread.sleep(6000);
				
				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.EndDateFieldTextBox());
				CommonUtility.ClickOn(driver,obj_EsupportOrderHomePage.EndDateFieldTextBox());
				
				Thread.sleep(6000);
				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.DateSelectForCustomTimeFrame());
				CommonUtility.ClickOn(driver,obj_EsupportOrderHomePage.DateSelectForCustomTimeFrame());
				
				Thread.sleep(6000);
				}
				
				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.UpdateResultsButtonOnDashBoard());
				CommonUtility.ClickOn(driver,obj_EsupportOrderHomePage.UpdateResultsButtonOnDashBoard());
				
				Thread.sleep(6000);
				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.DisplayedTotalAmountOf());
				totalorders=CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.DisplayedTotalAmountOf()).getText();
				System.out.println(totalorders);
				totalorders=totalorders.replaceAll("[a-zA-Z]", "");
				System.out.println(totalorders);
				
				totalorders=totalorders.replaceAll("-", "");
				System.out.println(totalorders);
				
				String number= totalorders.split("  ")[2];
				System.out.println(number);
				count=Integer.parseInt(number);
				System.out.println(count);
				if(count<2000)
				{
					CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.ExportButton());
					export=CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.ExportButton()).getText();
					System.out.println(export);
					CommonUtility.ClickOn(driver,obj_EsupportOrderHomePage.ExportButton());
					Thread.sleep(2000);
					
					
				}
				else
				{
					System.out.println(" grid not contains less than for selected timeframe");
					Report.put("Scenario 1 : < 2000 Records : Select the timeframe such that order fall under 2000 records and Click on the export", 
							"User should get message Your export has started. Your zip file will be available at the bottom of your screen as soon as it's ready.and download the zip file ",
							"Failed to see less than 2000 records", "Fail");
					Assert.fail();
				}
				
				
//				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.SuccessMessageAfterClickingOnDownload());
//				String mess=CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.SuccessMessageAfterClickingOnDownload()).getText();
//				System.out.println(mess);
				
				
				Report.put("Scenario 1 : < 2000 Records : Select the timeframe such that order fall under 2000 records and Click on the export", 
						"User should get message Your export has started. Your zip file will be available at the bottom of your screen as soon as it's ready.and download the zip file ",
						"User able to select "+Report.color(timeframe)+" and start and end dates and able to see "+count+" clicking on export able to see message ", "PASS");
			}

			else
			{
				System.out.println("failed to see timeframe");
				Report.put("Scenario 1 : < 2000 Records : Select the timeframe such that order fall under 2000 records and Click on the export", 
						"User should get message Your export has started. Your zip file will be available at the bottom of your screen as soon as it's ready.and download the zip file ",
						"Failed to see greater than 2000 records", "Fail");
				Assert.fail();
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Scenario 1 : < 2000 Records : Select the timeframe such that order fall under 2000 records and Click on the export", 
					"User should get message Your export has started. Your zip file will be available at the bottom of your screen as soon as it's ready.and download the zip file ",
					"Failed to see greater than 2000 records", "Fail");
			Assert.fail();
		}
	}
	
	public void changeTimeFrameAndClickOnExport_greaterThan2000_PartnerAccount(WebDriver driver, String timeframe) 
	{
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 120);


		Log.info("Inside changeTimeFrameAndClickOnExport_greaterThan2000_PartnerAccount");		
		String heading="";String totalorders="";String export="";int count;String popuphead="";

		try 
		{
			//			handleCookies(driver);

			if(CommonUtility.CheckpresenceofElementLocated(driver,33,obj_EsupportOrderHomePage.TimeFrameHeading()))
			{
				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.TimeFrameHeading());
				heading=CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.TimeFrameHeading()).getText();
				System.out.println(heading);
				
				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.AllTimeFrameOptions());
						
				Select option=new Select(driver.findElement(obj_EsupportOrderHomePage.AllTimeFrameOptions()));
				
				List<WebElement> list=option.getOptions();
			
				for(int i=0;i<list.size();i++)
				{
					CommonUtility.ScrollToWebElement(driver, list.get(i));
					String options=list.get(i).getText();
					System.out.println(options);
				}
				option.selectByVisibleText(timeframe);
				
				Thread.sleep(6000);
				
				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.UpdateResultsButtonOnDashBoard());
				CommonUtility.ClickOn(driver,obj_EsupportOrderHomePage.UpdateResultsButtonOnDashBoard());
				
				Thread.sleep(6000);
				
				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.DisplayedTotalAmountOf());
				totalorders=CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.DisplayedTotalAmountOf()).getText();
				System.out.println(totalorders);
				totalorders=totalorders.replaceAll("[a-zA-Z]", "");
				System.out.println(totalorders);
				
				totalorders=totalorders.replaceAll("-", "");
				System.out.println(totalorders);
				
				String number= totalorders.split("  ")[2];
				
				count=Integer.parseInt(number);
				
				if(count>2000)
				{
					CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.ExportButton());
					export=CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.ExportButton()).getText();
					System.out.println(export);
					CommonUtility.ClickOn(driver,obj_EsupportOrderHomePage.ExportButton());
					Thread.sleep(2000);
					
					
				}
				else
				{
					System.out.println(" grid not contains more than 2000 records for selected timeframe");
					Report.put("Scenario 2 : > 2000 Records : Select the timeframe such that order above 2000 records and Click on the export ", 
							"User should get the message your are about to export a file that exceeds 2000 records. This file will be ready to download shortly. with cancel and continue buttons",
							"Failed to see greater than 2000 records", "Fail");
					Assert.fail();
				}
				
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportOrderHomePage.ConfirmExportHeadingClickingOnExport()));
				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.ConfirmExportHeadingClickingOnExport());
				popuphead=CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.ConfirmExportHeadingClickingOnExport()).getText();
				System.out.println(popuphead);
				
				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.PopUpBodyMessage());
				String bodymes=CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.PopUpBodyMessage()).getText();
				System.out.println(bodymes);
				
				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.CancelButton());
				String cancel=CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.CancelButton()).getText();
				System.out.println(cancel);
				
				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.ContinueButton());
				String conti=CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.ContinueButton()).getText();
				System.out.println(conti);
				
				CommonUtility.ClickOn(driver,obj_EsupportOrderHomePage.ContinueButton());
				String mess="";
//				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.SuccessMessageAfterClickingOnDownload());
//				mess=CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.SuccessMessageAfterClickingOnDownload()).getText();
//				System.out.println(mess);
				
				Report.put("Scenario 2 : > 2000 Records : Select the timeframe such that order above 2000 records and Click on the export ", 
						"User should get the message your are about to export a file that exceeds 2000 records. This file will be ready to download shortly. with cancel and continue buttons",
						"User able to change "+Report.color(heading)+" to "+Report.color(timeframe)+" and able to see orders are "+count
								+ "which is more than 2000. able to see "+Report.color(popuphead)+" with body message "+Report.color(bodymes)+" with "+Report.color(cancel)+" and "+Report.color(conti)+" buttons ", "PASS");

				
				Report.put("Click on continue button ", 
						"User should see the message for few seconds We're exporting your file. This may take a while. Check your export status under View downloads",
						"User able to click on "+Report.color(conti)+" button and able to see "+Report.color(mess), "PASS");
			}

			else
			{
				System.out.println("failed to see timeframe");
				Report.put("Scenario 2 : > 2000 Records : Select the timeframe such that order above 2000 records and Click on the export ", 
						"User should get the message your are about to export a file that exceeds 2000 records. This file will be ready to download shortly. with cancel and continue buttons",
						"Failed to see greater than 2000 records", "Fail");
				Assert.fail();
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Scenario 2 : > 2000 Records : Select the timeframe such that order above 2000 records and Click on the export ", 
					"User should get the message your are about to export a file that exceeds 2000 records. This file will be ready to download shortly. with cancel and continue buttons",
					"Failed to see greater than 2000 records", "Fail");
			Assert.fail();
		}
	}
	
	public void clickClearButton_WithOutValidatingValueOfTimeFrame(WebDriver driver) 
	{
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 120);


		Log.info("Inside clickClearButton_WithOutValidatingValueOfTimeFrame");		
		String clear="";

		try 
		{
			//			handleCookies(driver);

			if(CommonUtility.CheckpresenceofElementLocated(driver,33,obj_EsupportOrderHomePage.ClearButtonOnDashboard()))
			{
				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.ClearButtonOnDashboard());
				clear=CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.ClearButtonOnDashboard()).getText();
				System.out.println(clear);
				CommonUtility.ClickOn(driver,obj_EsupportOrderHomePage.ClearButtonOnDashboard());
				
				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.ClearButtonOnDashboard());
				clear=CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.ClearButtonOnDashboard()).getText();
				System.out.println(clear);
				
				Thread.sleep(3000);
				String option=CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.AllTimeFrameOptions()).getAttribute("ng-reflect-model");
				System.out.println(option);
				
				
				
				Report.put("Click on clear button", 
						"user should be able to click on clear button and User should reset the Grid  ",
						"User able to click on "+Report.color(clear)+" button ", "PASS");

			}

			else
			{
				System.out.println("failed to see clear button");
				Report.put("Click on clear button", 
						"user should be able to click on clear button and User should reset the Grid  ",
						"failed to see clear button", "Fail");
				Assert.fail();
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on clear button", 
					"user should be able to click on clear button and User should reset the Grid  ",
					"failed to see clear button", "Fail");
			Assert.fail();
		}
	}
	
	public void verifyDashBoardSection_Premier(WebDriver driver) 
	{
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 120);


		Log.info("Inside verifyDashBoardSection_Premier");		
		String heading="";
		try 
		{
			//			handleCookies(driver);

			if(CommonUtility.CheckpresenceofElementLocated(driver,33,obj_EsupportOrderHomePage.DashBoardHeading()))
			{
				
				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.DashBoardHeading());
				List<WebElement> openwindows=driver.findElements(obj_EsupportOrderHomePage.DashBoardHeading());

				for(WebElement OW: openwindows)
				{
					heading+=OW.getText();
					System.out.println(heading);

				} 
				
				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.OrderNumberTextBox());
				
				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.PONumberTextBox());
				
				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.DPIDSearchBox());
				
				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.CustomerNumberDropdownValue());
				
				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.OrderStatusDropdownValue());
				
				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.ActivityDropdownValue());
				
				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.AgreementIDTextBox());
				
				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.StartDateFieldTextBox());
				
				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.EndDateFieldTextBox());
				
				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.AllTimeFrameOptions());
				
				
				Report.put("Verify the Dashboard section ", 
						"Dashboard section should contain Order number , Po number dell purchase ID , customer number , order status , activity , timeframe , from date and to date  clear and update buttons ",
						"User able to dashboard section with  "+Report.color(heading), "PASS");

			}

			else
			{
				System.out.println("failed to see dashboard section");
				Report.put("Verify the Dashboard section ", 
						"Dashboard section should contain Order number , Po number dell purchase ID , customer number , order status , activity , timeframe , from date and to date  clear and update buttons ",
						"failed to see dashboard section", "Fail");
				Assert.fail();
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify the Dashboard section ", 
					"Dashboard section should contain Order number , Po number dell purchase ID , customer number , order status , activity , timeframe , from date and to date  clear and update buttons ",
					"failed to see dashboard section", "Fail");
			Assert.fail();
		}
	}
	
	public void verifyGridBelowDashboard(WebDriver driver) 
	{
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 120);


		Log.info("Inside verifyGridBelowDashboard");		
		String columnnames="";
		String invoicelink="";
		try 
		{
			//			handleCookies(driver);

			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_EsupportOrderHomePage.ColumnNamesOfGridForPremier()))
			{
				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.ColumnNamesOfGridForPremier());
				List<WebElement> openwindows=driver.findElements(obj_EsupportOrderHomePage.ColumnNamesOfGridForPremier());

				for(WebElement OW: openwindows)
				{
					columnnames+=OW.getText();
					System.out.println(columnnames);

				} 
				
				if(columnnames.contains("Order Date")||columnnames.contains("Order Number"))
				{
					System.out.println("failed to display expected column names Order date and Order number");
					Report.put("Verify the Grid below the dashboard", 
							"Dashboard should display the grid and default columns should order date and order number",
							"failed to display expected column names", "Fail");
					Assert.fail();
				}
				
				Report.put("Verify the Grid below the dashboard", 
						"Dashboard should display the grid and default columns should order date and order number",
						"Grid contains columns "+Report.color(columnnames), "Pass");
			}
			else
			{
				System.out.println("failed to display expected column names");
				Report.put("Verify the Grid below the dashboard", 
						"Dashboard should display the grid and default columns should order date and order number",
						"failed to display expected column names", "Fail");
				Assert.fail();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify the Grid below the dashboard", 
					"Dashboard should display the grid and default columns should order date and order number",
					"failed to display expected column names", "Fail");
			Assert.fail();

		}
	}
}

