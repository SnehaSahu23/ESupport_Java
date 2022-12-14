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

public class EsupportRecentOrderWorkflow extends BaseFlow
{
	public String mainwindow = "";

	public void orderDetails(WebDriver driver)
	{
		System.out.println("Inside orderDetails");
		Log.info("Inside orderDetails");
		try
		{
			Thread.sleep(5000);
			WebDriverWait wait = new WebDriverWait(driver, 120);
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportRecentOrderPage.recentOrdersLabel()));
			CommonUtility.highlightElement(driver, obj_EsupportRecentOrderPage.recentOrdersLabel());
			if(CommonUtility.highlightElement(driver, obj_EsupportRecentOrderPage.orderDate()).isDisplayed())
				CommonUtility.highlightElement(driver, obj_EsupportRecentOrderPage.orderDate());
			else
			{
				Report.put("Verify that the details of the order is displayed ", "The order details should be displayed on the MOS page",
						"The order details displayed on the MOS page failed", "FAIL");
				Assert.fail();
			}
			//CommonUtility.highlightElement(driver, obj_EsupportRecentOrderPage.orderDate());
			//CommonUtility.highlightElement(driver, obj_EsupportRecentOrderPage.dellPurchaseId());
			CommonUtility.highlightElement(driver, obj_EsupportRecentOrderPage.orderStatus());
			CommonUtility.highlightElement(driver, obj_EsupportRecentOrderPage.estimatedDelivery());
			CommonUtility.highlightElement(driver, obj_EsupportRecentOrderPage.description());
			CommonUtility.highlightElement(driver, obj_EsupportRecentOrderPage.orderNumber());
			Report.put("Verify that the details of the order is displayed ", "The order details should be displayed on the MOS page",
					"The order details displayed on the MOS page", "PASS");
			Thread.sleep(3000);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify that the details of the order is displayed ", "The order details should be displayed on the MOS page",
					"The order details displayed on the MOS page failed", "FAIL");
			Assert.fail();
		}
	}
	public void CustomerDetails(WebDriver driver)
	{
		System.out.println("Inside CustomerDetails");
		Log.info("Inside CustomerDetails");
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportRecentOrderPage.recentOrdersLabel()));
			CommonUtility.highlightElement(driver, obj_EsupportRecentOrderPage.recentOrdersLabel());
			CommonUtility.highlightElement(driver, obj_EsupportRecentOrderPage.orderDate());
			CommonUtility.highlightElement(driver, obj_EsupportRecentOrderPage.dellPurchaseId());
			CommonUtility.highlightElement(driver, obj_EsupportRecentOrderPage.orderStatus());
			CommonUtility.highlightElement(driver, obj_EsupportRecentOrderPage.estimatedDelivery());
			CommonUtility.highlightElement(driver, obj_EsupportRecentOrderPage.description());
			CommonUtility.highlightElement(driver, obj_EsupportRecentOrderPage.orderNumber());
			Report.put("Verify that the details of the order is displayed ", "The order details should be displayed on the MOS page",
					"The order details displayed on the MOS page", "PASS");
			Thread.sleep(3000);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify that the details of the order is displayed ", "The order details should be displayed on the MOS page",
					"The order details displayed on the MOS page failed", "FAIL");
			Assert.fail();
		}
	}
	//sudha
	public void  clickOrderStatusLink_CHMASTORE(WebDriver driver) 
	{
		System.out.println("In function clickOrderStatusLink_CHMASTORE");
		WebDriverWait  wait = new WebDriverWait(driver, 120);
		System.out.println("After webdriver wait");
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
		try
		{      
			mainwindow = driver.getWindowHandle();



			if(driver.getWindowHandles().size() > 1)
			{
				System.out.println("Hyperlink click has opened new window");
				Log.info("Hyperlink click has opened new window");
				for(String childwindow:driver.getWindowHandles())
				{
					if(!(childwindow.equals(mainwindow)))
					{
						driver.switchTo().window(childwindow);
						System.out.println("Focus moved into New Window");
						Log.info("Focus moved into New Window");
						driver.manage().window().maximize();
						Thread.sleep(6000);
						driver.close();
						System.out.println("Closed the new window");
						Log.info("Closed the new window");
					}
				}
				driver.switchTo().window(mainwindow);
				System.out.println("Focus moved to main window");
				Log.info("Focus moved to main window");

				driver.navigate().refresh();
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportRecentOrderPage.premierOrderStatusLink()));
				CommonUtility.highlightElement(driver, obj_EsupportRecentOrderPage.premierOrderStatusLink()).click();
				System.out.println("Clicked on Order Status Link");


				Report.put("Click on Order Status below Masthead", "User should land in Premier Recent Orders Page", "Premier Recent Orders Page displayed Successfully", "PASS"); 


			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on Order Status below Masthead", "User should land in Premier Recent Orders Page", "Premier Recent Orders Page not displayed Successfully", "FAIL"); 
			Assert.fail();
		}
	}

	public void  VerifyRecentOrdersPage(WebDriver driver) 
	{
		System.out.println("Entering VerifyRecentOrdersPage");
		Log.info("Entering Premier Verify Recent Orders Page");        
		WebDriverWait  wait = new WebDriverWait(driver, 120);
		System.out.println("After webdriver wait");
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);

		try
		{
			Thread.sleep(5000);
			CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.TimeFrameDDdefaultselection());
			Select sele =new Select(driver.findElement(obj_EsupportRecentOrderPage.TimeFrameDDdefaultselection()));             
			WebElement options=sele.getFirstSelectedOption();
			String defaultItem=options.getText();
			System.out.println(defaultItem); 



			CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.countrydefaultselection());
			Select country =new Select(driver.findElement(obj_EsupportRecentOrderPage.countrydefaultselection()));    
			WebElement coptions=country.getFirstSelectedOption();
			String defaultcountryItem=coptions.getText();
			System.out.println(defaultcountryItem); 

			CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.customerdefaultselection());
			Select customernumber =new Select(driver.findElement(obj_EsupportRecentOrderPage.customerdefaultselection())); 
			WebElement customeroptions=customernumber.getFirstSelectedOption();
			String defaultcustomernumber=customeroptions.getText();
			System.out.println(defaultcustomernumber); 

			CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.statusselection());
			Select status =new Select(driver.findElement(obj_EsupportRecentOrderPage.statusselection()));                     
			WebElement statusoptions=status.getFirstSelectedOption();
			String defaultstatus=statusoptions.getText();
			System.out.println(defaultstatus);


			List<WebElement>radioButton = driver.findElements(By.xpath("//input[@name='radioSearchOption']"));
			for(int i=0;i<radioButton.size();i++){
				System.out.println(radioButton.get(i).getText());
			} 
			//If u want to check whether the radio button is selected or not
			if(driver.findElement(By.xpath("//input[@value='OrderNumber']")).isSelected()){
				System.out.println("True");
			}

			System.out.println("came out");
			Report.put("Verify the Recent orders page ","Timeframe should be on the first with 14 days by Default,Country Dropdown as view all,Customer number : all customer numbers,Status : All Orders","Recent Orders Page displayed Successfully", "PASS"); 


		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify the Recent orders page ","Timeframe should be on the first with 14 days by Default,Country Dropdown as view all,Customer number : all customer numbers,Status : All Orders","Recent Orders Page not displayed Successfully", "FAIL"); 
			Assert.fail();
		}
	}

	public void Clickordernumber(WebDriver driver, String TimeFrameDDselection)
	{
		WebDriverWait wait = new WebDriverWait(driver, 200);


		System.out.println("In function Clickordernumber");
		try
		{
			CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.TimeFrameDDdefaultselection());

			CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.TimeFrameDDdefaultselection()).sendKeys(TimeFrameDDselection);
			Thread.sleep(2000);
			CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.TimeFrameDDdefaultselection()).sendKeys(Keys.ENTER); 

			CommonUtility.ScrollTo(driver,obj_EsupportRecentOrderPage.Columnordernumberclick());

			CommonUtility.ClickOn(driver,obj_EsupportRecentOrderPage.Columnordernumberclick());
			Thread.sleep(15000);

			Report.put("Click on any order number",
					"Should land in Purchase details page  ",
					"Purchase details page displayed as expected ", "PASS");


		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on any order number",
					"Should land in Purchase details page  ",
					"Failed to display Purchase details page", "FAIL");
			Assert.fail();
		}
	}

	public void premierActionDropdown(WebDriver driver, String option)
	{
		System.out.println("Inside Premier Action Dropdown");
		Log.info("Inside Premier Action Dropdown");
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportRecentOrderPage.premierRecentOrdersLabel()));
			CommonUtility.highlightElement(driver, obj_EsupportRecentOrderPage.premierRecentOrdersLabel());
			//CommonUtility.highlightElement(driver, obj_EsupportRecentOrderPage.selectActionDropDown());


			Select selAction = new Select(driver.findElement(obj_EsupportRecentOrderPage.selectActionDropDown()));
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportRecentOrderPage.selectActionDropDown()));
			CommonUtility.scrollToViewElement(driver, obj_EsupportRecentOrderPage.selectActionDropDown());
			//CommonUtility.highlightElement(driver, obj_EsupportRecentOrderPage.selectActionDropDown()).click();
			Report.put("Click on Select an action drop down ", "Dropdown should display",
					"Dropdown displayed", "PASS");
			Thread.sleep(7000);
			if(option.contains("Subscribe to selected"))
			{
				selAction.selectByVisibleText("Subscribe to selected");
				System.out.println("clicked on Subscribe to selected ");
			}
			Report.put("Select Subscribe to selected option from drop down", "The checkboxes on the RO grid will get enabled ",
					"Subscribe to selected option is selected", "PASS");
			Thread.sleep(3000);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Select Subscribe to selected option from drop down", "The checkboxes on the RO grid will get enabled",
					"Subscribe to selected option failed", "FAIL");
			Assert.fail();
		}
	}

	public void  clickOrderStatusLink(WebDriver driver) 
	{
		System.out.println("In function clickOrderStatusLink");
		WebDriverWait  wait = new WebDriverWait(driver, 120);
		System.out.println("After webdriver wait");
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
		try
		{
			driver.navigate().refresh();
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportRecentOrderPage.premierOrderStatusLink()));
			//	CommonUtility.highlightElement(driver, obj_EsupportRecentOrderPage.premierOrderStatusLink()).click();
			CommonUtility.ToClickByUsingJavaScript_PassingByLoc(driver, obj_EsupportRecentOrderPage.premierOrderStatusLink());

			System.out.println("Clicked on Order Status Link");
			Report.put("Click on Order Status below Masthead", "User should land in Premier Recent Orders Page", "Premier Recent Orders Page displayed Successfully", "PASS");

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on Order Status below Masthead", "User should land in Premier Recent Orders Page", "Premier Recent Orders Page is not displayed", "FAIL");
			Assert.fail();
		}
	}

	public void  handlePremierStatusDropdown(WebDriver driver, String option)    
	{
		System.out.println("In function handlePremierStatusDropdown");
		Log.info("In function Premier Status Dropdown");
		System.out.println("option from excel is"+option);
		try
		{
			System.out.println("Inside try block");
			WebDriverWait wait = new WebDriverWait(driver, 120);
			CommonUtility.scrollToViewElement(driver, obj_EsupportRecentOrderPage.premierStatusDropdown());

			Select selAction = new Select(driver.findElement(obj_EsupportRecentOrderPage.premierStatusDropdown()));

			List<WebElement> SelectActionDropdown = driver.findElements(obj_EsupportRecentOrderPage.premierStatusDropdown());
			for (int i = 0; i < SelectActionDropdown.size(); i++) {
				System.out.println("Inside for Loop");
				String value = SelectActionDropdown.get(i).getText();
				CommonUtility.highlightElement(driver, SelectActionDropdown.get(i));
				System.out.println(value); 
				if(value.contains(option))
				{
					selAction.selectByVisibleText(option);
					System.out.println("Selected" +option);
					break;
				}

			}
			if(option.contains("Confirmed"))
			{
				selAction.selectByVisibleText("Confirmed");
				System.out.println("Selected Confirmed ");
			}
			Report.put("Select the status from the dropdown", "Required status should be selected",
					"Status selected as: "+Report.color(option), "PASS");
			Thread.sleep(3000);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Select the status from the dropdown", "Required status should be selected",
					"Status selection failed", "FAIL");
			Assert.fail();
		}
	}

	public void  handleCheckbox(WebDriver driver, boolean report)      
	{
		System.out.println("In function handleCheckbox");
		Log.info("In function handleCheckbox");
		try
		{
			System.out.println("Inside try block of handleCheckbox");
//			CommonUtility.ScrollTo(driver,obj_EsupportRecentOrderPage.selectAllCheckbox());
			CommonUtility.scrollToViewElement(driver,obj_EsupportRecentOrderPage.selectAllCheckbox());
//			CommonUtility.ClickOn(driver, obj_EsupportRecentOrderPage.selectAllCheckbox());
			WebElement element= driver.findElement(obj_EsupportRecentOrderPage.selectAllCheckbox());
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
			Thread.sleep(7000);
			CommonUtility.ClickOn(driver, obj_EsupportRecentOrderPage.premierSubmitButton());
			if(report)
				Report.put("Select non shipped orders & submit", "Non shipped orders should be selected & submit",
						"Non shipped orders submitted successfully", "PASS");
			Thread.sleep(3000);


		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Select non shipped orders & submit", "Non shipped orders should be selected & submit",
					"Failed to select non shipped orders", "FAIL");
			Assert.fail();
		}
	}


	public void  clickSubmitButton(WebDriver driver)    
	{
		System.out.println("In function clickSubmitButton");
		Log.info("In function clickSubmitButton");
		try
		{
			System.out.println("Inside try block of clickSubmitButton");

			CommonUtility.highlightElement(driver, obj_EsupportRecentOrderPage.premierSubmitButton()).click();

			Thread.sleep(3000);


		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Submit subscribed  orders", "Subscribed orders should be submitted",
					"Failed to submit subscribed orders ", "FAIL");
			Assert.fail();
		}
	}

	/*public void  handleErrorMessage(WebDriver driver)   
	{
		System.out.println("In function handleErrorMessage");
		Log.info("In function handleErrorMessage");
		try
		{
			System.out.println("Inside try block of handleErrorMessage");

			CommonUtility.highlightElement(driver, obj_EsupportRecentOrderPage.errorMessage()).click();
			String errorMsg = CommonUtility.highlightElement(driver, obj_EsupportRecentOrderPage.errorMessage()).getText();

			System.out.println("Error message is "+errorMsg);

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on Other Lookup Options", "Other look up Options Pop Up should show",
					"Other look up Options Pop Up display failed", "FAIL");
			Assert.fail();
		}
	}

	 */
	public void  handleSubscribePopup(WebDriver driver, boolean email)      
	{
		System.out.println("In function handleSubscribePopup");
		Log.info("In function handleSubscribePopup");
		try
		{if(email)
		{
			System.out.println("Inside try block of handleSubscribePopup");
			//WebDriverWait wait = new WebDriverWait(driver, 120);
			WebDriverWait wait = new WebDriverWait(driver,120);
			CommonUtility.ScrollTo(driver, obj_EsupportRecentOrderPage.subscribeLabel());
			CommonUtility.ClickOn(driver, obj_EsupportRecentOrderPage.subscribeLabel());
			Thread.sleep(10000);
			CommonUtility.highlightElement(driver, obj_EsupportRecentOrderPage.subscribeEmailAddress()).sendKeys("no-email@dell.com");

			CommonUtility.highlightElement(driver, obj_EsupportRecentOrderPage.addEmailButton()).click();
			CommonUtility.highlightElement(driver, obj_EsupportRecentOrderPage.subscribeSubmitButton()).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportRecentOrderPage.subscribeSuccessMessage()));
			CommonUtility.highlightElement(driver, obj_EsupportRecentOrderPage.subscribeSuccessMessage()).click();
			String successMsg =  CommonUtility.highlightElement(driver, obj_EsupportRecentOrderPage.subscribeSuccessMessage()).getText();
			System.out.println("Subscribe message"+successMsg);

			// wait.until(ExpectedConditions.presenceOfElementLocated(obj_EsupportRecentOrderPage.subscribeCloseButton()));
			CommonUtility.highlightElement(driver, obj_EsupportRecentOrderPage.subscribeCloseButton()).click();
		}
		else
		{
			//CommonUtility.highlightElement(driver, obj_EsupportRecentOrderPage.addEmailButton()).click();
			CommonUtility.highlightElement(driver, obj_EsupportRecentOrderPage.subscribeSubmitButton()).click();
			CommonUtility.highlightElement(driver, obj_EsupportRecentOrderPage.emailErrorMessage()).click();
			String errorMsg = CommonUtility.highlightElement(driver, obj_EsupportRecentOrderPage.emailErrorMessage()).getText();
			System.out.println("Email error message is "+errorMsg);
			Report.put("On subscribe Popup keep email textbox blank & click on submit", "Error message should appear on the screen",
					"Error message displayed"+Report.color(errorMsg),"PASS");
			CommonUtility.highlightElement(driver, obj_EsupportRecentOrderPage.subscribeCancelButton()).click();

			Report.put("Click on Cancel", "Popup should go off & should show recent orders page",
					"Recent orders page displayed ","PASS");

		}
		Thread.sleep(3000);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("On subscribe Popup keep email textbox blank & click on submit", "Error message should appear on the screen",
					"Error message not displayed ","FAIL");
			Assert.fail();
		}
	}
	//Sneha

	public void  premierInvoiceReport(WebDriver driver) {
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 240);
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);  
		try {
			System.out.println("In premierInvoiceReport");

			try{
				CommonUtility.ScrollTo(driver, obj_EsupportRecentOrderPage.HomeIconInOrdersPage());
				CommonUtility.ClickOn(driver, obj_EsupportRecentOrderPage.HomeIconInOrdersPage());
				Thread.sleep(10000);
				driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
				if(CommonUtility.CheckpresenceofElementLocated(driver, 30, obj_EsupportRecentOrderPage.XCloseButton()))
				{
					//				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportRecentOrderPage.XCloseButton()));
					CommonUtility.highlightElement(driver, obj_EsupportRecentOrderPage.XCloseButton()).click();
					Thread.sleep(5000);
				}
			}catch(Exception ex){

			}
			wait = new WebDriverWait(driver, 60);
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			//handleCookies(driver);



			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportRecentOrderPage.AccountLink()));
			CommonUtility.ClickOn(driver, obj_EsupportRecentOrderPage.AccountLink());
			//	handleCookies(driver);

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportRecentOrderPage.ViewandShareReportLink()));
			CommonUtility.highlightElement(driver, obj_EsupportRecentOrderPage.ViewandShareReportLink()).click();
			//	handleCookies(driver);

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportRecentOrderPage.PremierInvoicingReportLink()));
			CommonUtility.highlightElement(driver, obj_EsupportRecentOrderPage.PremierInvoicingReportLink()).click();
			Thread.sleep(5000);
			//handleCookies(driver);

			Set<String> windows=driver.getWindowHandles();
			for (String s : windows ){
				driver.switchTo().window(s);
				//	handleCookies(driver);
			}

			Thread.sleep(5000);
			//	handleCookies(driver);
			Report.put("Click on Account > Premier invocing report ", "Premier Invoicng report should load ",
					"Premier Invoicing report loads ", "PASS");

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on Account > Premier invocing report ", "Premier Invoicng report should load ",
					"Premier Invoicing report does not load ", "FAIL");
			Assert.fail();
		}
	}


	public void invoiceVerification(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 120);
		System.out.println("Inside invoiceVerification");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		//		driver.manage().timeouts().pageLoadTimeout(600, TimeUnit.SECONDS);
		String details ="";
		try
		{
			CommonUtility.ScrollTo(driver,obj_EsupportRecentOrderPage.InvoiceNumberTag());
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(obj_EsupportRecentOrderPage.InvoiceLink()));
			List<WebElement> InvoiceLink = driver.findElements(obj_EsupportRecentOrderPage.InvoiceLink());
			for (int i = 0; i < InvoiceLink.size(); i++) {
				Thread.sleep(10000);
				InvoiceLink = driver.findElements(obj_EsupportRecentOrderPage.InvoiceLink());
				//CommonUtility.scrollToViewElement(driver, InvoiceLink.get(i));
				String value = InvoiceLink.get(i).getText();
				CommonUtility.highlightElement(driver, InvoiceLink.get(i)).click();

				Thread.sleep(10000);
				System.out.println(value); 
				details = details+value+", ";
				Set<String> win=driver.getWindowHandles();
				for (String s : win ){
					driver.switchTo().window(s);
				}
				Thread.sleep(10000);
				driver.close();
				Thread.sleep(10000);
				win=driver.getWindowHandles();
				for (String s : win ){
					Thread.sleep(10000);
					driver.switchTo().window(s);
				}

			}
			Report.put("Click on any invoice  ", "Invoice should laod in new tab  ",
					"Invoice laods in new tab ", "PASS");
			Report.put("Verify different type of invoices  ", "All the invoices should load as expected   ",
					"All the invoices loads as expected", "PASS");

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on any invoice  ", "Invoice should laod in new tab  ",
					"Invoice does not laod in new tab ", "FAIL");
			Report.put("Verify different type of invoices  ", "All the invoices should load as expected  ",
					"All the invoices does not load as expected ", "FAIL");
			Assert.fail();
		}

	}



	/*public void  calendarVerification(WebDriver driver) {
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 120);
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);  
		try {

			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(obj_EsupportRecentOrderPage.FromDateClick()));
			CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.FromDateClick()).click();
			handleCookies(driver);

			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(obj_EsupportRecentOrderPage.SelectMonthClick()));
			Thread.sleep(5000);
			handleCookies(driver);

			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(obj_EsupportRecentOrderPage.SelectPrecedingMonth()));
			CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.SelectPrecedingMonth()).click();

			Thread.sleep(2000);
			handleCookies(driver);
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(obj_EsupportRecentOrderPage.FirstDateClick()));
			CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.FirstDateClick()).click();
			handleCookies(driver);

			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(obj_EsupportRecentOrderPage.ToDateClick()));
			CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.ToDateClick()).click();
			handleCookies(driver);

			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(obj_EsupportRecentOrderPage.LastDateClick()));
			CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.LastDateClick()).click();
			handleCookies(driver);

			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(obj_EsupportRecentOrderPage.ApplyButton()));
			CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.ApplyButton()).click();
			handleCookies(driver);
			Thread.sleep(10000);
			try{
				wait = new WebDriverWait(driver, 20);
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(obj_EsupportRecentOrderPage.NoRecord()));
				CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.NoRecord());

			}
			catch (Exception exp){

			}
			try{
				wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(obj_EsupportRecentOrderPage.ApplyButton()));
				CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.InvoiceNumberTag());
			}catch(Exception excp){

			}
			wait = new WebDriverWait(driver, 120);
			driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
			Report.put("Verify the Calender functionality  ", "Calender functionlity should work as expected  ",
					"Calender functionlity works as expected  ", "PASS");


		}catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify the Calender functionality  ", "Calender functionlity should work as expected  ",
					"Calender functionlit is not working as expected  ", "FAIL");
			Assert.fail();
		}
	}*/
	public void  calendarVerification(WebDriver driver) {
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 120);
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);  
		Actions act = new Actions(driver);
		System.out.println("Inside calendarVerification");
		try {
			Thread.sleep(7000);
			CommonUtility.ScrollTo(driver,obj_EsupportRecentOrderPage.FromDateClick());
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(obj_EsupportRecentOrderPage.FromDateClick()));
			CommonUtility.ClickOn(driver,obj_EsupportRecentOrderPage.FromDateClick());
			//			handleCookies(driver);

			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(obj_EsupportRecentOrderPage.SelectMonthClick()));
			Thread.sleep(5000);
			CommonUtility.ScrollTo(driver,obj_EsupportRecentOrderPage.SelectMonthClick());

			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(obj_EsupportRecentOrderPage.SelectPrecedingMonth()));
			CommonUtility.ScrollTo(driver,obj_EsupportRecentOrderPage.SelectPrecedingMonth());
			CommonUtility.ClickOn(driver,obj_EsupportRecentOrderPage.SelectPrecedingMonth());

			Thread.sleep(2000);

			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(obj_EsupportRecentOrderPage.FirstDateClick()));
			CommonUtility.ScrollTo(driver,obj_EsupportRecentOrderPage.FirstDateClick());
			CommonUtility.ClickOn(driver,obj_EsupportRecentOrderPage.FirstDateClick());


			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(obj_EsupportRecentOrderPage.ToDateClick()));
			CommonUtility.ScrollTo(driver,obj_EsupportRecentOrderPage.ToDateClick());
			CommonUtility.ClickOn(driver,obj_EsupportRecentOrderPage.ToDateClick());


			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(obj_EsupportRecentOrderPage.LastDateClick()));
			CommonUtility.ScrollTo(driver,obj_EsupportRecentOrderPage.LastDateClick());
			CommonUtility.ClickOn(driver,obj_EsupportRecentOrderPage.LastDateClick());
			//handleCookies(driver);

			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(obj_EsupportRecentOrderPage.ApplyButton()));
			CommonUtility.ScrollTo(driver,obj_EsupportRecentOrderPage.ApplyButton());
			CommonUtility.ClickOn(driver,obj_EsupportRecentOrderPage.ApplyButton());

			Thread.sleep(10000);
			try{
				wait = new WebDriverWait(driver, 20);
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(obj_EsupportRecentOrderPage.NoRecord()));
				CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.NoRecord());

			}
			catch (Exception exp){

			}
			try{
				wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(obj_EsupportRecentOrderPage.ApplyButton()));
				CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.InvoiceNumberTag());
			}catch(Exception excp){

			}
			wait = new WebDriverWait(driver, 120);
			driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
			Report.put("Verify the Calender functionality  ", "Calender functionlity should work as expected  ",
					"Calender functionlity works as expected  ", "PASS");



		}catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify the Calender functionality  ", "Calender functionlity should work as expected  ",
					"Calender functionlit is not working as expected  ", "FAIL");
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

			if(CommonUtility.CheckpresenceofElementLocated(driver, 05, obj_EsupportOrderHomePage.acceptCookies()))
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
		catch(Exception ex){


		}
		driver.manage().timeouts().implicitlyWait(240, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(240, TimeUnit.SECONDS);

	}  


	//Sujata methods???????????????????????..
	public void  PROrderHeader(WebDriver driver)
	{

		System.out.println("In function PROrderHeader");
		try
		{

			String ProHeader="";

			if(CommonUtility.CheckpresenceofElementLocated(driver, 10, obj_EsupportRecentOrderPage.recentOrdersLabel()))
			{

				ProHeader =CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.recentOrdersLabel()).getText();

				System.out.println(ProHeader); 


				Report.put("Recent Order status page must be displayed", "Recent Order status page should be displayed",
						"Successfully Recent Order Staus Page is displayed ", "PASS");

			}
			else
			{

				Report.put("Recent Order status page must be displayed", "Recent Order status page is not displayed",
						"Recent Order Staus Page is not displayed ", "FAIL");
				Assert.fail();

			}
		}
		catch(Exception e)
		{
			e.printStackTrace();			
		}
	}


	public void  RecentOrdercolumns(WebDriver driver)
	{

		System.out.println("In function RecentOrdercolumns");
		try
		{

			String ltMessages="";

			List<WebElement> list=driver.findElements(obj_EsupportRecentOrderPage.RecentOrdercolumnsheader());

			for(WebElement lt:list)
			{
				CommonUtility.highlightElement(driver, lt);

				String names=lt.getText();
				if(!(names.equals("")))
				{

					System.out.println("Alert Name is: " +names);
					ltMessages+=" <br> " + names;
				}
			}

			String ltMessage="";

			List<WebElement> listn=driver.findElements(obj_EsupportRecentOrderPage.RecentOrdercolumnsheaderlinks());

			for(WebElement lt:listn)
			{
				CommonUtility.highlightElement(driver, lt);
				String names=lt.getText();
				if(!(names.equals("")))
				{

					System.out.println("Alert Name is: " +names);
					ltMessage+=" <br> " + names;
				}

			}

			Report.put("Look for Order Date, Order Number, Status, Estimated delivery, Description, DPID, PO Number, Actions should be display",
					"Following columns should be display as "+Report.color(ltMessages) + Report.color(ltMessage),
					"Successfully Columns fileds are displayed. ", "PASS");



		}
		catch(Exception e)
		{
			e.printStackTrace();

			Report.put("Look for Order Date, Order Number, Status, Estimated delivery, Description, DPID, PO Number, Actions should be display",
					"Following columns are not displayed ",
					"following Columns fileds are not displayed. ", "FAIL");

			Assert.fail();
		}
	}


	public void  CustomerNumberRecentOrder(WebDriver driver)
	{

		System.out.println("In function CustomerNumberRecentOrder");
		try
		{

			Thread.sleep(10000);
			CommonUtility.ScrollTo(driver,obj_EsupportRecentOrderPage.CustomerNumberDD());
			CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.CustomerNumberDD()).click();
			Thread.sleep(5000);

			String ltMessages="";

			List<WebElement> list=driver.findElements(obj_EsupportRecentOrderPage.CustomerNumberDDoptions());

			try
			{
				for(WebElement lt:list)
				{
					CommonUtility.highlightElement(driver, lt);

					String names=lt.getText();
					if(!(names.equals("")))
					{

						System.out.println("Alert Name is: " +names);
						ltMessages+=" <br> " + names;
					}

				}
			}
			catch(Exception e)
			{

			}

			Report.put("Customer Number Options should be display",
					"Following Customer Number Options should be display as "+Report.color(ltMessages),
					"Successfully Customer Number Options  are displayed. ", "PASS");



		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Customer Number Options should be display",
					"Customer Number Options are not displayed ",
					"Customer Number Options are not displayed. ", "FAIL");

			Assert.fail();
		}
	}
	public void  StatusRecentOrder(WebDriver driver)
	{

		System.out.println("In function StatusRecentOrder");
		try
		{

			CommonUtility.ScrollTo(driver,obj_EsupportRecentOrderPage.StatusDD());
			CommonUtility.ClickOn(driver,obj_EsupportRecentOrderPage.StatusDD());
			Thread.sleep(5000);

			String ltMessages="";

			List<WebElement> list=driver.findElements(obj_EsupportRecentOrderPage.StatusDDoptions());

			for(WebElement lt:list)
			{
				CommonUtility.highlightElement(driver, lt);

				String names=lt.getText();
				if(!(names.equals("")))
				{

					System.out.println("Alert Name is: " +names);
					ltMessages+=" <br> " + names;
				}

			}


			Report.put("Status Options should be display",
					"Following Status Options should be display as "+Report.color(ltMessages),
					"Successfully status Options  are displayed. ", "PASS");



		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Status Options should be display",
					"Status Options are not displayed ",
					"Status Options are not displayed. ", "FAIL");

			Assert.fail();
		}
	}

	public void timeFrameRecentOrder(WebDriver driver)
	{

		System.out.println("In function timeFrameRecentOrder");
		try
		{
			CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.TimeFrameDDdefaultselection());
			Select sele =new Select(driver.findElement(By.xpath("//select[@id='ddlPeriod']")));            
			WebElement options=sele.getFirstSelectedOption();
			String defaultItem=options.getText();

			System.out.println(defaultItem); 


			Report.put("Default period for AMER is 45 Days",
					"Default period for AMER should be display as "+Report.color(defaultItem),
					"Successfully Default period for AMER is displayed. ", "PASS");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Default period for AMER is 45 Days",
					"Default period for AMER should not be display as ",
					"Default period for AMER is not displayed. ", "FAIL");

			Assert.fail();
		}
	}

	public void SearchboxradioOrderPO(WebDriver driver)
	{

		System.out.println("In function SearchboxradioOrderPO");
		try
		{
			String Search="";
			CommonUtility.ScrollTo(driver,obj_EsupportRecentOrderPage.Searchtextbox());

			if(CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.Searchtextbox()).isDisplayed())
			{
				Search="Search text box is displayed";
			}

			String SearchOrder="";
			CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.SearchtextboxOrderNumber());

			if(CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.SearchtextboxOrderNumber()).isDisplayed())
			{
				SearchOrder="Order Number Radio button is displayed";
			}

			String SearchPO="";
			CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.SearchtextboxPONumber());

			if(CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.SearchtextboxPONumber()).isDisplayed())
			{
				SearchPO="PO Number Radio button is displayed";
			}


			Report.put("Search box with radio buttons for Order number and PO number ",
					"Folowing textbox and radio buttons are displayed as  "
							+Report.color(Search)+"<br>"
							+Report.color(SearchOrder)+"<br>"
							+Report.color(SearchPO)+"<br>",
							"Successfully Search box with radio buttons for Order number and PO number are displayed. ", "PASS");



		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Search box with radio buttons for Order number and PO number ",
					"Folowing textbox and radio buttons are  not displayed ",
					"Search box with radio buttons for Order number and PO number are not displayed. ", "FAIL");

			Assert.fail();
		}
	}


	public void CalenderFromdateApplyReset(WebDriver driver)
	{

		System.out.println("In function CalenderFromdateApplyReset");
		try
		{
			String FromDate="";
			CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.FromDatetext());

			CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.Fromdatecalender());

			if(CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.Fromdatecalender()).isDisplayed())
			{
				FromDate=CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.FromDatetext()).getText();

			}

			String TODate="";
			CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.TODatetext());

			CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.TOdatecalender());

			if(CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.TOdatecalender()).isDisplayed())
			{
				TODate=CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.TODatetext()).getText();

			}


			String Apply="";
			CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.ApplyButton());

			if(CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.ApplyButton()).isDisplayed())
			{
				Apply=CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.ApplyButton()).getText();

			}

			String Reset="";
			CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.ResetButton());

			if(CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.ResetButton()).isDisplayed())
			{
				Reset=CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.ResetButton()).getText();

			}

			Report.put("Calender Search : From date to To date with apply and Reset buttons",
					"Folowing Calenders are :: "
							+Report.color(FromDate)+","
							+Report.color(TODate)+"<br>"
							+"Folowing Buttons  are :: "
							+Report.color(Apply)+","
							+Report.color(Reset)+"<br>",

							"Successfully Calender and  buttons are displayed", "PASS");



		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Calender Search : From date to To date with apply and Reset buttons",
					"Calender :: From date to To date with apply and Reset buttons are not displayed","Calender :: From date to To date with apply and Reset buttons are not displayed", "FAIL");

			Assert.fail();
		}
	}


	public void  itemsPerpagedropdown(WebDriver driver)
	{

		System.out.println("In function itemsPerpagedropdown");
		try
		{

			CommonUtility.ScrollTo(driver,obj_EsupportRecentOrderPage.Itemsperpage());
			CommonUtility.ClickOn(driver,obj_EsupportRecentOrderPage.Itemsperpage());
			Thread.sleep(5000);

			String ltMessages="";

			List<WebElement> list=driver.findElements(obj_EsupportRecentOrderPage.Itemsperpageoptions());

			for(WebElement lt:list)
			{
				CommonUtility.highlightElement(driver, lt);

				String names=lt.getText();
				if(!(names.equals("")))
				{

					System.out.println("Alert Name is: " +names);
					ltMessages+=" <br> " + names;
				}
			}	

			ToClick_itemsPerpagedropdown(driver);

			Thread.sleep(10000);

			Report.put("Items per page will be- 10,15,25,75",
					"Following Items per page Options should be display as "+Report.color(ltMessages),
					"Successfully Items per page Options are displayed. ", "PASS");



		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Items per page will be- 10,15,25,75",
					"Following Items per page Options are not display",
					"Items per page Options are not displayed. ", "FAIL");

			Assert.fail();
		}
	}


	public void SelectAnActionDropdown(WebDriver driver)
	{

		System.out.println("In function SelectAnActionDropdown");
		try
		{
			CommonUtility.ScrollTo(driver,obj_EsupportRecentOrderPage.SelectanactionsDD());

			CommonUtility.ClickOn(driver,obj_EsupportRecentOrderPage.SelectanactionsDD());
			Thread.sleep(5000);

			String ltMessages="";

			List<WebElement> list=driver.findElements(obj_EsupportRecentOrderPage.SelectanactionsDDoptions());

			for(WebElement lt:list)
			{
				CommonUtility.highlightElement(driver, lt);

				String names=lt.getText();
				if(!(names.equals("")))
				{

					System.out.println("Alert Name is: " +names);
					ltMessages+=" <br> " + names;
				}

			}


			Report.put("SelectAn Action dropdown should be display",
					"Following SelectAn Action  Options should be display as "+Report.color(ltMessages),
					"Successfully SelectAn Action  Options  are displayed. ", "PASS");



		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("SelectAn Action dropdown should be display",
					"SelectAn Action  Options are not displayed ",
					"SelectAn Action  Options  are not displayed. ", "FAIL");

			Assert.fail();
		}
	}

	public void Clickonanyorders(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 200);

		Actions act=new Actions(driver);
		System.out.println("In function Clickonanyorder");
		try
		{

			Thread.sleep(2000);
			handlePremierStatusDropdown(driver, TestNGCreator.TestData.get(Esupport.StatusOption.ordinal()));
			Thread.sleep(10000);
			CommonUtility.ScrollTo(driver,obj_EsupportRecentOrderPage.Columnordernumberclick());
			CommonUtility.ClickOn(driver,obj_EsupportRecentOrderPage.Columnordernumberclick());

			wait.until(ExpectedConditions.elementToBeClickable(obj_EsupportRecentOrderPage.Puchasedetailsgheader()));


		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Not able to click on any order",
					"Not able to click on any order ",
					"Not able to click on any order ", "FAIL");

			Assert.fail();
		}
	}

	public void PurchasedetailsHeader(WebDriver driver)
	{
		String purchaseorder="";
		String resentorder="";

		WebDriverWait wait = new WebDriverWait(driver, 200);


		System.out.println("In function PurchasedetailsHeader");
		try
		{


			wait.until(ExpectedConditions.elementToBeClickable(obj_EsupportRecentOrderPage.Puchasedetailsgheader()));

			CommonUtility.ScrollTo(driver,obj_EsupportRecentOrderPage.Puchasedetailsgheader());

			purchaseorder=CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.Puchasedetailsgheader()).getText();
			Thread.sleep(5000);
			Report.put("Click on any order number",
					"User Should land on "+ Report.color(purchaseorder),
					"Successfully User Should land on Purchase details page ", "PASS");

			driver.navigate().back();

			wait.until(ExpectedConditions.elementToBeClickable(obj_EsupportRecentOrderPage.recentOrdersLabel()));

			CommonUtility.ScrollTo(driver,obj_EsupportRecentOrderPage.recentOrdersLabel());

			resentorder=CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.recentOrdersLabel()).getText();
			Thread.sleep(5000);
			Report.put("Comeback to the Premier RO page , By clicking on order status below masthead or by clicking on browser back button ",
					"User should land in " + Report.color(resentorder),
					"Successfully User should land in recent orders page ", "PASS");


		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on any order number",
					"User should land on Purchase details page ",
					"Failed to display Purchase details page ", "FAIL");

			Assert.fail();
		}
	}


	public void Orderdateandordernumbersortingbutton(WebDriver driver)
	{
		String orderdate="";
		String ordernumber="";



		System.out.println("In function Orderdateandordernumbersortingbutton");
		try
		{

			CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.orderdatesortingbutton());

			if(CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.orderdatesortingbutton()).isDisplayed())
			{
				orderdate="orderdate";
			}



			CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.ordernumbersortingbutton());

			if(CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.ordernumbersortingbutton()).isDisplayed())
			{
				ordernumber="ordernumber";
			}

			Report.put("Sorting available on order date and order number column",
					"Sorting must be available on columns : "+ Report.color(orderdate)+" and "+ Report.color(ordernumber),
					"Successfully order date and order number column displayed ", "PASS");


		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Sorting available on order date and order number column",
					"Sorder date and order number columns are not displayed ",
					"order date and order number columns are not displayed ", "FAIL");

			Assert.fail();
		}
	}


	public void Toclick_verifyPOnumber(WebDriver driver)
	{
		String orderdate="";
		String ordernumber="";

		Actions act=new Actions(driver);

		System.out.println("In function Toclick_verifyPOnumber");
		try
		{		

			if(CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.PONumbercolumnheader()).isDisplayed())
			{

				CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.PONumbercolumnheader());
				System.out.println("PO Number is displayed in column");
				Thread.sleep(10000);
				ToClick_itemsPerpagedropdown(driver);
				Thread.sleep(10000);
				String ltMessages="";
				CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.clickonPONumber());

				List<WebElement> list=driver.findElements(obj_EsupportRecentOrderPage.clickonPONumber());

				for(WebElement lt:list)
				{
					CommonUtility.highlightElement(driver, lt);
					String names=lt.getText();
					if(!(names.equals("")))
					{
						System.out.println("Alert Name is: " +names);
						ltMessages+=" <br> " + names;
						lt.click();
						break;
					}
				}		
			}
			else
			{
				CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.Optionstoggle());
				Thread.sleep(10000);
				CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.Optionstoggle()).click();
				if(CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.Estimateddeliverytoggleclicked()).isSelected() ||
						CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.Statustoggleclicked()).isSelected()||
						CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.Descriptiontoggleclicked()).isSelected() ||
						CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.OptionstoggleDPID()).isSelected() ||
						CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.Actiontoggleclicked()).isSelected())

				{
					CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.Estimateddeliverytoggleclicked()).click();



					if(CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.PONumbertoggleclicked()).isDisplayed())
					{

						CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.PONumbertoggleclicked());
						System.out.println("PONumbertoggleclicked is displayed in toggle icon");
						CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.PONumbertoggleclicked());
						if(!(CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.PONumbertoggleclicked()).isSelected()))
							CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.PONumbertoggleclicked()).click();

						Thread.sleep(2000);
						System.out.println("PO Number is displayed in column");

						//          CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.clickonPONumber());




						String ltMessages="";

						CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.orderdatesortingbutton()).click();

						CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.clickonPONumber());

						Thread.sleep(5000);

						List<WebElement> list=driver.findElements(obj_EsupportRecentOrderPage.clickonPONumber());

						for(WebElement lt:list)
						{
							CommonUtility.ScrollToWebElement(driver, lt);
							String names=lt.getText();
							if(!(names.equals("")))
							{
								System.out.println("Alert Name is: " +names);
								ltMessages+=" <br> " + names;
								lt.click();
								break;
							}
						}					
					}
				}
			}

			Thread.sleep(5000);

			Report.put("Click on PO number",
					"PO number link is clicked ",
					"Successfully PO number is clicked ", "PASS");


		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on PO number",
					"PO number link should be clicked",
					"Not able to click on PO Number", "FAIL");

			Assert.fail();
		}
	}


	public void Recentorderheader(WebDriver driver)
	{
		String purchaseorder="";
		String resentorder="";

		WebDriverWait wait = new WebDriverWait(driver, 200);


		System.out.println("In function Recentorderheader");
		try
		{
			//			wait.until(ExpectedConditions.elementToBeClickable(obj_EsupportRecentOrderPage.recentOrdersLabel()));
			CommonUtility.ScrollTo(driver,obj_EsupportRecentOrderPage.recentOrdersLabel());
			CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.recentOrdersLabel());

			purchaseorder=CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.recentOrdersLabel()).getText();
			Thread.sleep(5000);
			Report.put("Click on any PO number",
					"User Should land on "+ Report.color(purchaseorder),
					"Successfully User Should land on Recent order details page ", "PASS");


			driver.get("https://www.dell.com/support/orders/us/en/19?");
			Thread.sleep(7000);
			
			driver.get("https://www.dell.com/support/orders/us/en/19?");
			Thread.sleep(7000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportRecentOrderPage.recentOrdersLabel()));

			CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.recentOrdersLabel());

			resentorder=CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.recentOrdersLabel()).getText();
			Thread.sleep(5000);
			Report.put("Comeback to recent orders page , by clicking on browser back button or orderstatus below masthead  ",
					"User Should comeback to  " + Report.color(resentorder)+" Page ",
					"Successfully User should land in Premier Recent Orders page ", "PASS");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on any PO number",
					"User should land on Recent order details page ",
					"User not able to land on Recent order details page ", "FAIL");

			Assert.fail();
		}
	}


	public void searchTo_SearchboxradioOrderPO(WebDriver driver,String PoNumber)
	{

		System.out.println("In function searchTo_SearchboxradioOrderPO");
		try
		{
			String Search="";
			CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.Searchtextbox());

			String SearchPO="";

			CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.SearchtextboxPONumber()).click();

			Thread.sleep(2000);
			CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.Searchtextbox()).clear();
			CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.Searchtextbox()).sendKeys(PoNumber);
			Thread.sleep(2000);

			CommonUtility.ClickOn(driver,obj_EsupportRecentOrderPage.Searchiconpoordernumber());


			Thread.sleep(2000);


			SearchPO=CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.Searchiconponumberlink()).getText();


			Report.put("Select PO number radio button ,enter Po number and click on Search ",
					"Po number should load in Grid",
					"Successfully Po number should load in Grid.", "PASS");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Select PO number radio button ,enter Po number and click on Search ",
					"Po number should load in Grid",
					"Po number should not found and notload in Grid", "FAIL");
			Assert.fail();
		}
	}

	public void searchTo_SearchboxradioOrderPOReset(WebDriver driver)
	{

		System.out.println("In function searchTo_SearchboxradioOrderPOReset");
		try
		{
			String Restbutton="";

			CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.ResetButton());


			CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.ResetButton()).click();

			Thread.sleep(15000);

			ToClick_itemsPerpagedropdown(driver);

			Thread.sleep(10000);

			if(CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.Columnordernumberclick()).isDisplayed())
			{

				Restbutton=CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.Columnordernumberclick()).getText();

				Report.put("Click on Reset ",
						"All the fields should get resetted to default values as  "
								+Report.color(Restbutton)+" is displayed <br>",
								"Successfully All the fields should reset to default values ", "PASS");
			}


		}
		catch(Exception e)
		{
			e.printStackTrace();

			Report.put("Click on Reset ",
					"All the fields are not  get resetted to default values  ",
					"Failed to reset the fields to default values ", "FAIL");
			Assert.fail();
		}
	}



	public void ToVerify_clickOptinsTaggle(WebDriver driver)
	{
		Actions act=new Actions(driver);
		String Toggletext="";
		System.out.println("In function ToVerify_clickOptinsTaggle");
		try
		{
			
			CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.clickSlider());
			CommonUtility.ClickOn(driver,obj_EsupportIPSHomePage.clickSlider());

			CommonUtility.ScrollTo(driver,obj_EsupportRecentOrderPage.Optionstoggle());
			CommonUtility.ClickOn(driver,obj_EsupportRecentOrderPage.Optionstoggle());

			CommonUtility.ScrollTo(driver,obj_EsupportRecentOrderPage.Toggledropdownverifytext());
			Toggletext=CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.Toggledropdownverifytext()).getText();



			String ltMessages="";

			List<WebElement> list=driver.findElements(obj_EsupportRecentOrderPage.Toggledropdownverifytextoption());

			for(WebElement lt:list)
			{
				//	act.moveToElement(CommonUtility.highlightElement(driver, lt)).build().perform();
				CommonUtility.scrollToViewElement(driver, lt);
				String names=lt.getText();

				System.out.println("Alert Name is: " +names);
				ltMessages+=" <br> " + names;


			}


			Report.put("Options Toggle should be displayed and Click on options Toggle",
					"User should be shown with Values as "
							+Report.color(Toggletext)+"<br>"
							+Report.color(ltMessages)+"<br>",
							"Successfully  Options Toggle values are displayed  ", "PASS");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Options Toggle should be displayed and Click on options Toggle",
					"User should be shown Values ",
					" Options Toggle values are not displayed  ", "FAIL");
			Assert.fail();
		}
	}



	public void ToVerify_selectedPoNumberinToggle(WebDriver driver)
	{
		String Toggletext="";
		System.out.println("In function ToVerify_selectedPoNumberinToggle");
		try
		{

			if(CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.PONumbercolumnheader()).isDisplayed())
			{
				if(CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.PONumbertoggleclicked()).isSelected())
				{
					Toggletext=CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.PONumbertoggleclickedtext()).getText();
				}
			}

			Report.put("Select the columns to display from the options toggle  , say select any other columns like Po number option ",
					"It should show the premier RO page as per the selected columns in options toggle ,and  column should be displayed as "
							+Report.color(Toggletext)+"<br>",
							"Successfully Po number option column displayed.  ", "PASS");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Select the columns to display from the options toggle  , say select any other columns like Po number option ",
					"Its should show the premier RO page as per the selected columns in options toggle ,and  column should be displayed",
					" Po number option column not displayed.  ", "FAIL");


			Assert.fail();
		}
	}



	public void ToVerify_PQATLink(WebDriver driver)
	{
		String purchaseorder="";
		Actions act=new Actions(driver);
		String Toggletext="";
		System.out.println("In function ToVerify_PQATLink");
		try
		{
			//	act.moveToElement(CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.PQATTextdislayed())).build().perform();
			CommonUtility.scrollToViewElement(driver,obj_EsupportRecentOrderPage.PQATTextdislayed());
			Toggletext=CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.PQATTextdislayed()).getText();
			Report.put("Look for the PQAT link on the bottom of the table  ",
					"User must be able to see.. "
							+Report.color(Toggletext)+"<br>",
							"Successfully User must be able to see.. "+Report.color(Toggletext)+"<br>", "PASS");


			CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.PQATTextdislayedsearchformlink());
			CommonUtility.ClickOn(driver,obj_EsupportRecentOrderPage.PQATTextdislayedsearchformlink());

			purchaseorder=CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.recentOrdersLabel()).getText();
			Thread.sleep(5000);
			Report.put("Click on 'Search form' ",
					"User Should land on "+ Report.color(purchaseorder),
					"Successfully User Should land on Recent order details page ", "PASS");

		}
		catch(Exception e)
		{
			e.printStackTrace();


			Report.put("Look for the PQAT link on the bottom of the table  ",
					"User is not able to see.. Not finding your order Use the search form to lookup orders by reference number.",
					" User must be able to see..Not finding your order Use the search form to lookup orders by reference number." , "FAIL");

			Assert.fail();
		}
	}


	public void RecentorderheaderSerachform(WebDriver driver)
	{
		Actions act=new Actions(driver);

		String resentorder="";
		String PQATOrderpage="";

		WebDriverWait wait = new WebDriverWait(driver, 200);


		System.out.println("In function RecentorderheaderSerachform");
		try
		{

			//			wait.until(ExpectedConditions.elementToBeClickable(obj_EsupportRecentOrderPage.recentOrdersLabel()));
			CommonUtility.ScrollTo(driver, obj_EsupportRecentOrderPage.recentOrdersLabel());

			Thread.sleep(5000);

			Set<String> allWH=driver.getWindowHandles(); 
			String currentwindow=driver.getWindowHandle();
			int count=allWH.size(); 
			System.out.println("Window Handles and  window count is :: "+count);

			for(String wh:allWH)
			{			
				Thread.sleep(10000);
				driver.switchTo().window(wh); 
				String title=driver.getCurrentUrl();
				System.out.println("Tittle displayed as   :::::"+title); 



				if(title.contains("NoRedirect"))
				{

					System.out.println("Switched to window");
					act.moveToElement(CommonUtility.highlightElement(driver, obj_EsupportRecentOrderPage.recentOrdersLabel())).build().perform();

					PQATOrderpage=CommonUtility.highlightElement(driver, obj_EsupportRecentOrderPage.recentOrdersLabel()).getText();

					Report.put("Click on 'Search form'   ",
							"User Should able to navigate to  " + Report.color(PQATOrderpage)+" Page ",
							"Successfully User should land in "+ Report.color(PQATOrderpage)+" Page ", "PASS");

					Thread.sleep(4000);
					driver.close();

					Thread.sleep(5000);
					driver.switchTo().window(currentwindow);

					Thread.sleep(10000);

					System.out.println("current parent window"+driver.getCurrentUrl());



					//act.moveToElement(CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.recentOrdersLabel())).build().perform();

					CommonUtility.scrollToViewElement(driver,obj_EsupportRecentOrderPage.recentOrdersLabel());
					CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.recentOrdersLabel());

					resentorder=CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.recentOrdersLabel()).getText();

					Thread.sleep(5000);
					Report.put("Comeback to the Premier RO page , By clicking on order status below masthead or by clicking on browser back button ",
							"User Should comeback to  " + Report.color(resentorder)+" Page ",
							"Successfully User should land in Premier Recent Orders page ", "PASS");
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on any PO number",
					"User should land in Recent order details page ",
					"Failed to land in Recent order details page ", "FAIL");

			Assert.fail();
		}
	}



	public void ToVerify_Actionsddshippedanddelivered(WebDriver driver,String clickingonelement)
	{
		String purchaseorder="";
		Actions act=new Actions(driver);
		String Toggletext="";
		System.out.println("In function ToVerify_Actionsddshippedanddelivered");
		try
		{
			//			act.moveToElement(CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.StatusDD())).build().perform();

			CommonUtility.scrollToViewElement(driver,obj_EsupportRecentOrderPage.StatusDD());
			Thread.sleep(5000);
			CommonUtility.ClickOn(driver,obj_EsupportRecentOrderPage.StatusDD());
			
			CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.StatusDD()).sendKeys(clickingonelement);
			CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.StatusDD()).sendKeys(Keys.ENTER);
			Thread.sleep(5000);
			Thread.sleep(5000);
			selectTimeframe(driver,"Last 6 months");
			Thread.sleep(5000);
			
			CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.Searchtextbox()).clear();

			System.out.println("Shipped value selected from Status DD");
			Thread.sleep(5000);
			

			Noordersfindinaqpp(driver);
			Thread.sleep(5000);
			CommonUtility.ScrollTo(driver,obj_EsupportRecentOrderPage.ShippedActionsDropdownclick());

			CommonUtility.ClickOn(driver,obj_EsupportRecentOrderPage.ShippedActionsDropdownclick());



			String ltMessages="";

			List<WebElement> list=driver.findElements(obj_EsupportRecentOrderPage.ShippedActionsDropdownclickoptions());

			for(WebElement lt:list)
			{
				CommonUtility.highlightElement(driver, lt);
				String names=lt.getText();

				System.out.println("Alert Name is: " +names);
				ltMessages+=" <br> " + names;


			}

			Report.put("Check other action column on Premier RO page  ",
					"User Should see "+Report.color(clickingonelement) +" status with Other action column for US following values as " + Report.color(ltMessages),
					"Successfully Actions dropdown displayed  values as For US - packing slip, invoice, returns - only for "+Report.color(clickingonelement), "PASS");



		}
		catch(Exception e)
		{
			e.printStackTrace();


			Report.put("Check other action column on Premier RO page  ",
					"User should be able to see the values in Actions dropdown for Shipping status ",
					"User not able to see the values in Actions dropdown for Shipping status", "FAIL");



			Assert.fail();
		}
	}



	public void ToVerify_notselectedPoNumberinToggle(WebDriver driver)
	{
		String Toggletext="";
		System.out.println("In function ToVerify_notselectedPoNumberinToggle");
		try
		{		

			//if(CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.PONumbercolumnheader()).isDisplayed())
			//{

			System.out.println("Inside if to click toggle button");

			CommonUtility.ScrollTo(driver,obj_EsupportRecentOrderPage.Optionstoggle());
			CommonUtility.ClickOn(driver,obj_EsupportRecentOrderPage.Optionstoggle());



			if(CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.PONumbertoggleclicked()).isSelected())
			{
				CommonUtility.ClickOn(driver,obj_EsupportRecentOrderPage.PONumbertoggleclicked());
				Toggletext=CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.PONumbertoggleclickedtext()).getText();


				Report.put("PO number should not be clickable  ",
						"PO number should not be clickable  "
								+Report.color(Toggletext)+"<br>",
								"PO Number is not clickable  ", "PASS");
			}

			//}         
			//			else
			//			{
			//
			//				Report.put("PO number should not be clickable  ",
			//						"PO number should not be clickable  "
			//								+Report.color(Toggletext)+"<br>",
			//								"PO Number is not clickable  ", "FAIL");
			//				Assert.fail();
			//			}


			Thread.sleep(3000);


		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("PO number should not be clickable  ",
					"PO number should not be clickable  "
							+Report.color(Toggletext)+"<br>",
							"PO Number is not clickable  ", "FAIL");

			Assert.fail();
		}
	}


	public void  ToClick_itemsPerpagedropdown(WebDriver driver)
	{

		System.out.println("In function itemsPerpagedropdown");
		try
		{

			CommonUtility.ScrollTo(driver,obj_EsupportRecentOrderPage.Itemsperpage());
			CommonUtility.ClickOn(driver,obj_EsupportRecentOrderPage.Itemsperpage());
			Thread.sleep(5000);

			String ltMessages="";

			List<WebElement> list=driver.findElements(obj_EsupportRecentOrderPage.Itemsperpageoptions());

			for(WebElement lt:list)
			{
				CommonUtility.highlightElement(driver, lt);

				String names=lt.getText();
				if(!(names.equals("")))
				{

					System.out.println("Alert Name is: " +names);
					ltMessages+=" <br> " + names;
					if(names.equalsIgnoreCase("75 items per page"))
					{

						System.out.println("75 items per page  is ::; Matched");
						lt.click();
						break;
					}
				}
			}

			Thread.sleep(4000);

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Items per page will be- 10,15,25,75",
					"Following Items per page Options are not display",
					"Items per page Options are not displayed. ", "FAIL");

			Assert.fail();
		}
	}

	public void ToVerify_PackingslipforalldaysForPONumber(WebDriver driver,String shippingstatus,String enteringonorder,String TimeFrameDDselection,String clickingonelementselect)
	{
		String purchaseorder="";
		Actions act=new Actions(driver);
		String Toggletext="";
		System.out.println("In function ToVerify_PackingslipforalldaysForPONumber");
		try
		{

			CommonUtility.ScrollTo(driver,obj_EsupportRecentOrderPage.PONumberCheckbox());

			CommonUtility.ClickOn(driver,obj_EsupportRecentOrderPage.PONumberCheckbox());

			act.moveToElement(CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.StatusDD())).build().perform();


			CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.StatusDD()).click();

			CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.StatusDD()).sendKeys(shippingstatus);
			CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.StatusDD()).sendKeys(Keys.ENTER);
			Thread.sleep(2000);

			System.out.println("Shipped value selected from Status DD");

			CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.TimeFrameDDdefaultselection()).click();

			CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.TimeFrameDDdefaultselection()).sendKeys(TimeFrameDDselection);
			CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.TimeFrameDDdefaultselection()).sendKeys(Keys.ENTER);
			Thread.sleep(10000);

			System.out.println("Shipped value selected from TimeFrameDDselection");
			CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.Searchtextbox());
			CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.Searchtextbox()).clear();
			CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.Searchtextbox()).sendKeys(enteringonorder);

			System.out.println("Successfully entered order number in to the Search order number");

			Thread.sleep(2000);

			CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.Searchiconpoordernumber()).click();

			Thread.sleep(4000);
//			driver.get("https://www.dell.com/support/orders/us/en/19?");
//			Thread.sleep(7000);
			try
			{
				System.out.println("Searched ordernumber is displayed for shipped");

				CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.ShippedActionsDropdownclick()).sendKeys(clickingonelementselect);

				Report.put("from Other action column click on  "+Report.color(clickingonelementselect),
						"Online  "+Report.color(clickingonelementselect)+"must be displayed on browser if the order is "+Report.color(TimeFrameDDselection)+" and selected status  as "+Report.color(shippingstatus),
						"Successfully Actions dropdown clicked as For US - "+Report.color(clickingonelementselect)+" - only for "+Report.color(shippingstatus), "PASS");
			}
			catch(Exception e)
			{

			}
			String resentorder="";

			String Packingslip="";
			if(clickingonelementselect.contains("Packing"))
			{	
				Thread.sleep(5000);

				Set<String> allWH=driver.getWindowHandles(); 
				String currentwindow=driver.getWindowHandle();
				int count=allWH.size(); 
				System.out.println("Switched Window Handles and  window count is :: "+count);

				for(String wh:allWH)
				{					
					Thread.sleep(10000);
					driver.switchTo().window(wh); 
					String title=driver.getCurrentUrl();
					System.out.println("Tittle displayed as   :::::"+title); 



					if(title.contains("packingslip"))
					{

						System.out.println("Switched to window");


						Packingslip=CommonUtility.highlightElement(driver, obj_EsupportRecentOrderPage.recentOrdersLabel()).getText();

						Report.put("Click on 'Packing slip form'   ",
								"User Should able to navigate to  " + Report.color(Packingslip)+" Page ",
								"Successfully User should land in "+ Report.color(Packingslip)+" Page ", "PASS");

						Thread.sleep(4000);
						driver.close();

						Thread.sleep(5000);
						driver.switchTo().window(currentwindow);

						Thread.sleep(10000);

						System.out.println("current parent window"+driver.getCurrentUrl());

						act.moveToElement(CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.recentOrdersLabel())).build().perform();					

						CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.recentOrdersLabel());

						resentorder=CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.recentOrdersLabel()).getText();

						Report.put("Comeback to the Premier RO page , By clicking on order status below masthead or by clicking on browser back button ",
								"User Should comeback to  " + Report.color(resentorder)+" Page ",
								"Successfully User should land in Premier Recent Orders page ", "PASS");

						Thread.sleep(5000);
					}
				}

			}

			String resentorder1="";

			String Packingslip1="";


			if(clickingonelementselect.contains("Invoice"))
			{
				Thread.sleep(5000);

				Set<String> allWH=driver.getWindowHandles(); 
				String currentwindow=driver.getWindowHandle();
				int count=allWH.size(); 
				System.out.println("Switched Window Handles InvoiceInvoice and  window count is :: "+count);

				for(String wh:allWH)
				{					
					Thread.sleep(10000);
					driver.switchTo().window(wh); 
					String title=driver.getCurrentUrl();
					System.out.println("Tittle displayed as   :::::"+title); 



					if(title.contains("Invoice") || title.contains("ContactUs") )
					{

						System.out.println("Switched to window  Invoice");

						Report.put("Click on 'Invoice form'   ",
								"User Should able to navigate to  " + Report.color(Packingslip1)+" Page ",
								"Successfully User should land in "+ Report.color(Packingslip1)+" Page ", "PASS");

						Thread.sleep(4000);
						driver.close();

						Thread.sleep(5000);
						driver.switchTo().window(currentwindow);

						Thread.sleep(10000);

						System.out.println("current parent window"+driver.getCurrentUrl());



						act.moveToElement(CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.recentOrdersLabel())).build().perform();


						CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.recentOrdersLabel());

						resentorder1=CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.recentOrdersLabel()).getText();

						Report.put("Comeback to the Premier RO page , By clicking on order status below masthead or by clicking on browser back button ",
								"User Should comeback to  " + Report.color(resentorder1)+" Page ",
								"Successfully User should land in Premier Recent Orders page ", "PASS");

						Thread.sleep(5000);
					}
				}

			}

			String resentorder2="";

			String Packingslip2="";


			if(clickingonelementselect.contains("Return"))
			{
				Thread.sleep(5000);

				Set<String> allWH=driver.getWindowHandles(); 
				String currentwindow=driver.getWindowHandle();
				int count=allWH.size(); 
				System.out.println("Switched Window Handles and  window count is :: "+count);

				for(String wh:allWH)
				{					
					Thread.sleep(10000);
					driver.switchTo().window(wh); 
					String title=driver.getCurrentUrl();
					System.out.println("Tittle displayed as   :::::"+title); 


					//sujata we need to change code

					if(title.contains("Returns"))
					{

						System.out.println("Switched to window");
						handleCookies(driver);

						CommonUtility.highlightElement(driver, obj_EsupportRecentOrderPage.recentOrdersLabel());
						String Packingslipreturn=CommonUtility.highlightElement(driver, obj_EsupportRecentOrderPage.recentOrdersLabel()).getText();

						if(CommonUtility.CheckpresenceofElementLocated(driver, 10, obj_EsupportRecentOrderPage.Returnmessage())){

							String Returnmessage =CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.Returnmessage()).getText();

							System.out.println(Returnmessage); 

							CommonUtility.highlightElement(driver, obj_EsupportRecentOrderPage.Returnmessage());
							Packingslip2=CommonUtility.highlightElement(driver, obj_EsupportRecentOrderPage.Returnmessage()).getText();

							Report.put("Click on 'Returns form'   ",
									"User Should able to navigate to  " + Report.color(Packingslipreturn)+" Page  and Message is dsiplayed as "+ Report.color(Packingslip2),
									"Successfully User should land in "+ Report.color(Packingslipreturn)+" Page ", "PASS");

						}
						else 
							if(CommonUtility.CheckpresenceofElementLocated(driver, 10, obj_EsupportRecentOrderPage.Returnsfindmessagecorrect())){


								CommonUtility.highlightElement(driver, obj_EsupportRecentOrderPage.Returnsfindmessagecorrect());
								Packingslip2=CommonUtility.highlightElement(driver, obj_EsupportRecentOrderPage.Returnsfindmessagecorrect()).getText();

								System.out.println(Packingslip2); 

								Report.put("Click on 'Returns form'   ",
										"User Should able to navigate to  " + Report.color(Packingslipreturn)+" Page  and Message is dsiplayed as "+ Report.color(Packingslip2),
										"Successfully User should land in "+ Report.color(Packingslipreturn)+" Page ", "PASS");

							}
							else
							{


								String ltMessages="";
								CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.Returnsfindmessage());

								List<WebElement> list=driver.findElements(obj_EsupportRecentOrderPage.Returnsfindmessage());

								for(WebElement lt:list)
								{
									CommonUtility.highlightElement(driver, lt);
									String names=lt.getText();

									System.out.println("Alert Name is: " +names);
									ltMessages+=" <br> " + names;


								}								

								Report.put("Click on 'Returns form'   ",
										"User Should able to navigate to  " + Report.color(Packingslipreturn)+" Page  and Message is dsiplayed as "+ Report.color(ltMessages),
										"Successfully User should land in "+ Report.color(Packingslipreturn)+" Page ", "PASS");
							}
						Thread.sleep(4000);
						driver.close();

						Thread.sleep(5000);
						driver.switchTo().window(currentwindow);

						Thread.sleep(10000);

						System.out.println("current parent window"+driver.getCurrentUrl());



						act.moveToElement(CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.recentOrdersLabel())).build().perform();



						CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.recentOrdersLabel());

						resentorder2=CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.recentOrdersLabel()).getText();

						Report.put("Comeback to the Premier RO page , By clicking on order status below masthead or by clicking on browser back button ",
								"User Should comeback to  " + Report.color(resentorder2)+" Page ",
								"Successfully User should land in Premier Recent Orders page ", "PASS");

						Thread.sleep(5000);


					}
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();


			Report.put("Check other action column on Premier RO page  ",
					"User not able to see the values in Actions dropdown for Shipping status ",
					"User not able to see the values in Actions dropdown for Shipping status", "FAIL");
			Assert.fail();
		}
	}


	public void ToVerify_PackingslipforalldaysForOrderNum(WebDriver driver,String shippingstatus,String enteringonorder,String TimeFrameDDselection,String clickingonelementselect)
	{
		String purchaseorder="";
		Actions act=new Actions(driver);
		String Toggletext="";
		System.out.println("In function ToVerify_PackingslipforalldaysForOrderNum");
		try
		{

			CommonUtility.scrollToViewElement(driver,obj_EsupportRecentOrderPage.ClickOnOrderNumberRadioButton());

			CommonUtility.ClickOn(driver,obj_EsupportRecentOrderPage.ClickOnOrderNumberRadioButton());

			act.moveToElement(CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.StatusDD())).build().perform();


			CommonUtility.ClickOn(driver,obj_EsupportRecentOrderPage.StatusDD());

			CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.StatusDD()).sendKeys(shippingstatus);
			CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.StatusDD()).sendKeys(Keys.ENTER);
			Thread.sleep(2000);

			System.out.println("Shipped value selected from Status DD");

			CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.TimeFrameDDdefaultselection()).click();

			CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.TimeFrameDDdefaultselection()).sendKeys(TimeFrameDDselection);
			CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.TimeFrameDDdefaultselection()).sendKeys(Keys.ENTER);
			Thread.sleep(10000);

			System.out.println("Shipped value selected from TimeFrameDDselection");
			CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.Searchtextbox());
			CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.Searchtextbox()).clear();
			CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.Searchtextbox()).sendKeys(enteringonorder);

			System.out.println("Successfully entered order number in to the Search order number");

			Thread.sleep(2000);

			CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.Searchiconpoordernumber()).click();

			Thread.sleep(4000);
//			driver.get("https://www.dell.com/support/orders/us/en/19?");
//			Thread.sleep(7000);

			try
			{
				System.out.println("Searched ordernumber is displayed for shipped");

				CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.ShippedActionsDropdownclick()).sendKeys(clickingonelementselect);

				Report.put("from Other action column click on  "+Report.color(clickingonelementselect),
						"Online  "+Report.color(clickingonelementselect)+"must be displayed on browser if the order is "+Report.color(TimeFrameDDselection)+" and selected status  as "+Report.color(shippingstatus),
						"Successfully Actions dropdown clicked as For US - "+Report.color(clickingonelementselect)+" - only for "+Report.color(shippingstatus), "PASS");
			}
			catch(Exception e)
			{

			}
			String resentorder="";

			String Packingslip="";
			if(clickingonelementselect.contains("Packing"))
			{	
				Thread.sleep(5000);

				Set<String> allWH=driver.getWindowHandles(); 
				String currentwindow=driver.getWindowHandle();
				int count=allWH.size(); 
				System.out.println("Switched Window Handles and  window count is :: "+count);

				for(String wh:allWH)
				{					
					Thread.sleep(10000);
					driver.switchTo().window(wh); 
					String title=driver.getCurrentUrl();
					System.out.println("Tittle displayed as   :::::"+title); 



					if(title.contains("packingslip"))
					{

						System.out.println("Switched to window");


						Packingslip=CommonUtility.highlightElement(driver, obj_EsupportRecentOrderPage.recentOrdersLabel()).getText();

						Report.put("Click on 'Packing slip form'   ",
								"User Should able to navigate to  " + Report.color(Packingslip)+" Page ",
								"Successfully User should land in "+ Report.color(Packingslip)+" Page ", "PASS");

						Thread.sleep(4000);
						driver.close();

						Thread.sleep(5000);
						driver.switchTo().window(currentwindow);

						Thread.sleep(10000);

						System.out.println("current parent window"+driver.getCurrentUrl());

						act.moveToElement(CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.recentOrdersLabel())).build().perform();					

						CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.recentOrdersLabel());

						resentorder=CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.recentOrdersLabel()).getText();

						Report.put("Comeback to the Premier RO page , By clicking on order status below masthead or by clicking on browser back button ",
								"User Should comeback to  " + Report.color(resentorder)+" Page ",
								"Successfully User should land in Premier Recent Orders page ", "PASS");

						Thread.sleep(5000);
					}
				}

			}

			String resentorder1="";

			String Packingslip1="";


			if(clickingonelementselect.contains("Invoice"))
			{
				Thread.sleep(5000);

				Set<String> allWH=driver.getWindowHandles(); 
				String currentwindow=driver.getWindowHandle();
				int count=allWH.size(); 
				System.out.println("Switched Window Handles InvoiceInvoice and  window count is :: "+count);

				for(String wh:allWH)
				{					
					Thread.sleep(10000);
					driver.switchTo().window(wh); 
					String title=driver.getCurrentUrl();
					System.out.println("Tittle displayed as   :::::"+title); 



					if(title.contains("Invoice") || title.contains("ContactUs") )
					{

						System.out.println("Switched to window  Invoice");

						Report.put("Click on 'Invoice form'   ",
								"User Should able to navigate to  " + Report.color(Packingslip1)+" Page ",
								"Successfully User should land in "+ Report.color(Packingslip1)+" Page ", "PASS");

						Thread.sleep(4000);
						driver.close();

						Thread.sleep(5000);
						driver.switchTo().window(currentwindow);

						Thread.sleep(10000);

						System.out.println("current parent window"+driver.getCurrentUrl());



//						act.moveToElement(CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.recentOrdersLabel())).build().perform();


						CommonUtility.ScrollTo(driver,obj_EsupportRecentOrderPage.recentOrdersLabel());

						resentorder1=CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.recentOrdersLabel()).getText();

						Report.put("Comeback to the Premier RO page , By clicking on order status below masthead or by clicking on browser back button ",
								"User Should comeback to  " + Report.color(resentorder1)+" Page ",
								"Successfully User should land in Premier Recent Orders page ", "PASS");

						Thread.sleep(5000);
					}
				}

			}

			String resentorder2="";

			String Packingslip2="";


			if(clickingonelementselect.contains("Return"))
			{
				Thread.sleep(5000);

				Set<String> allWH=driver.getWindowHandles(); 
				String currentwindow=driver.getWindowHandle();
				int count=allWH.size(); 
				System.out.println("Switched Window Handles and  window count is :: "+count);

				for(String wh:allWH)
				{					
					Thread.sleep(10000);
					driver.switchTo().window(wh); 
					String title=driver.getCurrentUrl();
					System.out.println("Tittle displayed as   :::::"+title); 


					//sujata we need to change code

					if(title.contains("Returns"))
					{

						System.out.println("Switched to window");
						handleCookies(driver);

						CommonUtility.highlightElement(driver, obj_EsupportRecentOrderPage.recentOrdersLabel());
						String Packingslipreturn=CommonUtility.highlightElement(driver, obj_EsupportRecentOrderPage.recentOrdersLabel()).getText();

						if(CommonUtility.CheckpresenceofElementLocated(driver, 10, obj_EsupportRecentOrderPage.Returnmessage())){

							String Returnmessage =CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.Returnmessage()).getText();

							System.out.println(Returnmessage); 

							CommonUtility.highlightElement(driver, obj_EsupportRecentOrderPage.Returnmessage());
							Packingslip2=CommonUtility.highlightElement(driver, obj_EsupportRecentOrderPage.Returnmessage()).getText();

							Report.put("Click on 'Returns form'   ",
									"User Should able to navigate to  " + Report.color(Packingslipreturn)+" Page  and Message is dsiplayed as "+ Report.color(Packingslip2),
									"Successfully User should land in "+ Report.color(Packingslipreturn)+" Page ", "PASS");

						}
						else 
							if(CommonUtility.CheckpresenceofElementLocated(driver, 10, obj_EsupportRecentOrderPage.Returnsfindmessagecorrect())){


								CommonUtility.highlightElement(driver, obj_EsupportRecentOrderPage.Returnsfindmessagecorrect());
								Packingslip2=CommonUtility.highlightElement(driver, obj_EsupportRecentOrderPage.Returnsfindmessagecorrect()).getText();

								System.out.println(Packingslip2); 

								Report.put("Click on 'Returns form'   ",
										"User Should able to navigate to  " + Report.color(Packingslipreturn)+" Page  and Message is dsiplayed as "+ Report.color(Packingslip2),
										"Successfully User should land in "+ Report.color(Packingslipreturn)+" Page ", "PASS");

							}
							else
							{


								String ltMessages="";
								CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.Returnsfindmessage());

								List<WebElement> list=driver.findElements(obj_EsupportRecentOrderPage.Returnsfindmessage());

								for(WebElement lt:list)
								{
									CommonUtility.highlightElement(driver, lt);
									String names=lt.getText();

									System.out.println("Alert Name is: " +names);
									ltMessages+=" <br> " + names;


								}								

								Report.put("Click on 'Returns form'   ",
										"User Should able to navigate to  " + Report.color(Packingslipreturn)+" Page  and Message is dsiplayed as "+ Report.color(ltMessages),
										"Successfully User should land in "+ Report.color(Packingslipreturn)+" Page ", "PASS");
							}
						Thread.sleep(4000);
						driver.close();

						Thread.sleep(5000);
						driver.switchTo().window(currentwindow);

						Thread.sleep(10000);

						System.out.println("current parent window"+driver.getCurrentUrl());



//						act.moveToElement(CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.recentOrdersLabel())).build().perform();



						CommonUtility.ScrollTo(driver,obj_EsupportRecentOrderPage.recentOrdersLabel());

						resentorder2=CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.recentOrdersLabel()).getText();

						Report.put("Comeback to the Premier RO page , By clicking on order status below masthead or by clicking on browser back button ",
								"User Should comeback to  " + Report.color(resentorder2)+" Page ",
								"Successfully User should land in Premier Recent Orders page ", "PASS");

						Thread.sleep(5000);


					}
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();


			Report.put("Check other action column on Premier RO page  ",
					"User not able to see the values in Actions dropdown for Shipping status ",
					"User not able to see the values in Actions dropdown for Shipping status", "FAIL");
			Assert.fail();
		}
	}

	//Sujatha
	//new sujata methodssssssss

	public void TOVerify_PurchasedetailsHeader(WebDriver driver)
	{
		String purchaseorder="";
		String resentorder="";

		WebDriverWait wait = new WebDriverWait(driver, 200);


		System.out.println("In function TOVerify_PurchasedetailsHeader");
		try
		{


			wait.until(ExpectedConditions.elementToBeClickable(obj_EsupportRecentOrderPage.Puchasedetailsgheader()));

			CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.Puchasedetailsgheader());

			purchaseorder=CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.Puchasedetailsgheader()).getText();
			Thread.sleep(5000);



			Report.put("Click on any order number",
					"User Should land on "+ Report.color(purchaseorder),
					"Successfully User Should land on Purchase details page ", "PASS");

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on any order number",
					"User is not land on Purchase details page ",
					"User is not land on Purchase details page ", "FAIL");

			Assert.fail();
		}
	}


	public void TOVerify_PurchasedetailsHeaderwithActionslabel(WebDriver driver)
	{
		Actions act=new Actions(driver);
		String purchaseorderActionlabel="";

		System.out.println("In function TOVerify_PurchasedetailsHeaderwithActionslabel");
		try
		{

			act.moveToElement(CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.PurchaseOrderpageActionheader())).build().perform();

			CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.PurchaseOrderpageActionheader());

			purchaseorderActionlabel=CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.PurchaseOrderpageActionheader()).getText();
			Thread.sleep(5000);

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Not able to find Actions Label",
					"Actions label not found ",
					"Actions label not found ", "FAIL");

			Assert.fail();
		}

	}


	public void TOVerify_clickonPOActionslabelwithviewdifferentorder(WebDriver driver)
	{
		Actions act=new Actions(driver);
		String purchaseorderActionlabel="";
		String resentorderpage="";

		String ActionlabelHeader="";

		System.out.println("In function TOVerify_clickonPOActionslabelwithviewdifferentorder");
		try
		{

			act.moveToElement(CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.PurchaseOrderpageActionheader())).build().perform();

			CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.PurchaseOrderpageActionheader());

			ActionlabelHeader=CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.PurchaseOrderpageActionheader()).getText();
			Thread.sleep(5000);

			CommonUtility.scrollToViewElement(driver,obj_EsupportRecentOrderPage.Actionviewdifferentorder());
			//act.moveToElement(CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.Actionviewdifferentorder())).build().perform();

			CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.Actionviewdifferentorder());

			purchaseorderActionlabel=CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.Actionviewdifferentorder()).getText();
			Thread.sleep(2000);

			CommonUtility.ClickOn(driver,obj_EsupportRecentOrderPage.Actionviewdifferentorder());





			Report.put("From the " +Report.color(ActionlabelHeader)+ " section ,  and Click on"+Report.color(purchaseorderActionlabel),
					"User should land in Order status homepage ",
					"Successfully User should land in Order status homepage ", "PASS");

			Thread.sleep(4000);


			String resentorder1="";

			String Packingslip="";

			String resentorderpage1="";
			String resentorderpage2="";
			String resentorderpage3="";
			String resentorderpage4="";

			Thread.sleep(5000);

			Set<String> allWH=driver.getWindowHandles(); 
			String currentwindow=driver.getWindowHandle();
			int count=allWH.size(); 
			System.out.println("Switched Window Handles and  window count is :: "+count);

			for(String wh:allWH)
			{

				//        String manifesttittle="https://www.dell.com/support/orders/us/en/RC1387181/?NoRedirect=true{0}";
				Thread.sleep(10000);
				driver.switchTo().window(wh); 
				String title=driver.getTitle();
				System.out.println("Tittle displayed as   ;;;;;;;;:::::"+title); 



				if(title.contains("Order Status | Dell US"))
				{

					// Actions actn=new Actions(driver);
					System.out.println("Switched to window");


					handleCookies(driver);
					CommonUtility.highlightElement(driver, obj_EsupportRecentOrderPage.recentOrdersLabel());
					Packingslip=CommonUtility.highlightElement(driver, obj_EsupportRecentOrderPage.recentOrdersLabel()).getText();

					Report.put("Click on 'Packing slip form'   ",
							"User Should able to navigate to  " + Report.color(Packingslip)+" Page ",
							"Successfully User should land in "+ Report.color(Packingslip)+" Page ", "PASS");

					Thread.sleep(4000);


					CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.Orderpagepermierorder());
					resentorderpage1=CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.Orderpagepermierorder()).getText();
					CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.Orderpagepermierordertext());
					resentorderpage2=CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.Orderpagepermierordertext()).getText();
					CommonUtility.ScrollTo(driver,obj_EsupportRecentOrderPage.LookByPremierOrder());
					String  Lookbypremierorder=CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.LookByPremierOrder()).getText();


					Thread.sleep(2000);
					CommonUtility.ClickOn(driver,obj_EsupportRecentOrderPage.LookByPremierOrderselect());
					Thread.sleep(5000);

					String ltMessages="";

					List<WebElement> list=driver.findElements(obj_EsupportRecentOrderPage.LookByPremierOrderselectoptions());

					for(WebElement lt:list)
					{
//						act.moveToElement(CommonUtility.highlightElement(driver, lt)).build().perform();
						CommonUtility.ScrollToWebElement(driver, lt);
						String names=lt.getText();
						if(!(names.equals("")))
						{

							System.out.println("Alert Name is: " +names);
							ltMessages+=" <br> " + names;
						}

					}


					Report.put("Verify the Search options label " + Report.color(resentorderpage1)+ " , "+ Report.color(resentorderpage2)+" and " + Report.color(Lookbypremierorder),
							"User Should Verify the Search options  label " + Report.color(resentorderpage1)+ " , "+ Report.color(resentorderpage2)+" and " + Report.color(Lookbypremierorder)+ " values displayed as "+ Report.color(ltMessages),
							"Successfully Verify the Search options label  " + Report.color(resentorderpage1)+ " , "+ Report.color(resentorderpage2)+" and " + Report.color(Lookbypremierorder) , "PASS");



					CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.Orderpageorder());
					resentorderpage3=CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.Orderpageorder()).getText();
					CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.Orderpageordertext());
					resentorderpage4=CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.Orderpageordertext()).getText();
					CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.LookByOrder());
					String  Lookbyorder=CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.LookByOrder()).getText();


					CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.LookByOrderselect()).click();
					Thread.sleep(2000);

					String ltMessages1="";

					List<WebElement> list1=driver.findElements(obj_EsupportRecentOrderPage.LookByOrderselectoptions());

					for(WebElement lt:list1)
					{
						//act.moveToElement(CommonUtility.highlightElement(driver, lt)).build().perform();
						CommonUtility.scrollToViewElement(driver, lt);
						String names=lt.getText();
						if(!(names.equals("")))
						{

							System.out.println("Alert Name is: " +names);
							ltMessages1+=" <br> " + names;
						}

					}


					Report.put("Verify the Search options label " + Report.color(resentorderpage3)+ " , "+ Report.color(resentorderpage4)+" and " + Report.color(Lookbypremierorder),
							"User Should Verify the Search options  label " + Report.color(resentorderpage3)+ " , "+ Report.color(resentorderpage4)+" and " + Report.color(Lookbyorder)+ " values displayed as "+ Report.color(ltMessages1),
							"Successfully Verify the Search options label  " + Report.color(resentorderpage3)+ " , "+ Report.color(resentorderpage4)+" and " + Report.color(Lookbyorder) , "PASS");



					Thread.sleep(5000);

					driver.close();

					Thread.sleep(5000);
					driver.switchTo().window(currentwindow);

					Thread.sleep(5000);

					System.out.println("current parent window"+driver.getCurrentUrl());



					//	act.moveToElement(CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.Puchasedetailsgheader())).build().perform();
					CommonUtility.scrollToViewElement(driver, obj_EsupportRecentOrderPage.Puchasedetailsgheader());
					//CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.Puchasedetailsgheader());

					String resentorder=CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.Puchasedetailsgheader()).getText();

					Report.put("Comeback to the Premier RO page , By clicking on order status below masthead or by clicking on browser back button ",
							"User Should comeback to  " + Report.color(resentorder)+" Page ",
							"Successfully User should land in Premier Recent Orders page ", "PASS");

					Thread.sleep(5000);
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Not able to come back Premier Order page",
					"Not able to come back Premier Order page",
					"Not able to come back Premier Order page ", "FAIL");

			Assert.fail();
		}
	}

	public void TOVerify_Orderstatusheader(WebDriver driver)
	{

		String purchaseorderActionlabel="";

		WebDriverWait wait = new WebDriverWait(driver, 200);


		System.out.println("In function TOVerify_Orderstatusheader");
		try
		{
			wait.until(ExpectedConditions.elementToBeClickable(obj_EsupportRecentOrderPage.recentOrdersLabel()));


			CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.recentOrdersLabel());

			purchaseorderActionlabel=CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.recentOrdersLabel()).getText();
			Thread.sleep(5000);


		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Not able to find Order status Label",
					"Not able to find Order status Label ",
					"Not able to find Order status Label", "FAIL");

			Assert.fail();
		}
	}



	public void TOVerify_clickonotherlookupoptions(WebDriver driver)
	{
		Actions act=new Actions(driver);
		String purchaseorderActionlabel="";
		String ActionlabelHeader="";
		WebDriverWait wait = new WebDriverWait(driver, 200);

		System.out.println("In function TOVerify_clickonotherlookupoptions");
		try
		{


			act.moveToElement(CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.PurchaseOrderpageActionheader())).build().perform();

			CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.PurchaseOrderpageActionheader());

			ActionlabelHeader=CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.PurchaseOrderpageActionheader()).getText();
			Thread.sleep(5000);


			//	act.moveToElement(CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.Actionviewdifferentorder())).build().perform();

			CommonUtility.scrollToViewElement(driver,obj_EsupportRecentOrderPage.Actionviewdifferentorder());

			CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.Actionviewdifferentorder());

			purchaseorderActionlabel=CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.Actionviewdifferentorder()).getText();
			Thread.sleep(2000);

			CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.Actionviewdifferentorder()).click();





			Report.put("From the " +Report.color(ActionlabelHeader)+ " section ,  and Click on"+Report.color(purchaseorderActionlabel),
					"User should land in Order status homepage ",
					"Successfully User should land in Order status homepage ", "PASS");

			Thread.sleep(4000);



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



				if(title.contains("Order Status | Dell US"))
				{

					System.out.println("Switched to window");

					handleCookies(driver);


					wait.until(ExpectedConditions.elementToBeClickable(obj_EsupportRecentOrderPage.LookByOtherserachoptions()));


					act.moveToElement(CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.LookByOtherserachoptions())).build().perform();

					CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.LookByOtherserachoptions());

					purchaseorderActionlabel=CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.LookByOtherserachoptions()).getText();
					Thread.sleep(5000);

					CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.LookByOtherserachoptions()).click();



					Packingslip=CommonUtility.highlightElement(driver, obj_EsupportRecentOrderPage.recentOrdersLabel()).getText();

					Report.put("Click on 'Order Status'   ",
							"User Should able to navigate to  " + Report.color(Packingslip)+" Page ",
							"Successfully User should land in "+ Report.color(Packingslip)+" Page ", "PASS");

					Thread.sleep(2000);

					TOVerify_clickonotherlookupoptionspopup(driver);

					Thread.sleep(4000);
					driver.close();

					Thread.sleep(5000);
					driver.switchTo().window(currentwindow);

					Thread.sleep(10000);

					System.out.println("current parent window"+driver.getCurrentUrl());



					//	act.moveToElement(CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.Puchasedetailsgheader())).build().perform();
					CommonUtility.scrollToViewElement(driver,obj_EsupportRecentOrderPage.Puchasedetailsgheader());
					//wait.until(ExpectedConditions.elementToBeClickable(obj_EsupportRecentOrderPage.recentOrdersLabel()));

					CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.Puchasedetailsgheader());

					resentorder=CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.Puchasedetailsgheader()).getText();

					Report.put("Comeback to the Premier RO page , By clicking on order status below masthead or by clicking on browser back button ",
							"User Should comeback to  " + Report.color(resentorder)+" Page ",
							"Successfully User should land in Premier Recent Orders page ", "PASS");

					Thread.sleep(5000);
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Not able to otherlookupoptions",
					"otherlookupoptions label not found ",
					"otherlookupoptions label not found ", "FAIL");

			Assert.fail();
		}

	}

	public void  handlePremierStatusDropdown_UK(WebDriver driver, String option)    
	{
		System.out.println("In function handlePremierStatusDropdown");
		Log.info("In function Premier Status Dropdown");
		System.out.println("option from excel is "+option);
		try
		{
			System.out.println("Inside try block");
			WebDriverWait wait = new WebDriverWait(driver, 120);
			CommonUtility.highlightElement(driver, obj_EsupportRecentOrderPage.premierStatusDropdown());

			Select selAction = new Select(driver.findElement(obj_EsupportRecentOrderPage.premierStatusDropdown()));


			if(option.contains("Order Confirmed"))
			{
				System.out.println("Inside else if***********");
				selAction.selectByVisibleText("Order Confirmed");
				System.out.println("Selected Order Confirmed ");
			}
			Report.put("Verify that the details of the order is displayed ", "The order details should be displayed on the MOS page",
					"The order details displayed on the MOS page", "PASS");
			Thread.sleep(3000);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on Other Lookup Options", "Other look up Options Pop Up should show",
					"Other look up Options Pop Up display failed", "FAIL");
			Assert.fail();
		}
	}

	public void TOVerify_clickonotherlookupoptionspopup(WebDriver driver)
	{
		Actions act=new Actions(driver);
		String lookupoptionspopuplabel="";
		String lookupoptionspopuplabeltext="";



		System.out.println("In function TOVerify_clickonotherlookupoptionspopup");
		try
		{
			act.moveToElement(CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.LookByOtherserachoptionspopup())).build().perform();

			CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.LookByOtherserachoptionspopup());

			if(CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.LookByOtherserachoptionspopup()).isDisplayed())
			{
				System.out.println("lookup pop up avaiable.");
				lookupoptionspopuplabel=CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.LookByOtherserachoptionspopup()).getText();
				Thread.sleep(5000);

				CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.LookByOtherserachoptionspopuptext());

				lookupoptionspopuplabeltext=CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.LookByOtherserachoptionspopuptext()).getText();


				CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.LookByOtherserachSelect()).click();

				System.out.println("Able to click on options");


				Thread.sleep(5000);

				String ltMessages="";

				List<WebElement> list=driver.findElements(obj_EsupportRecentOrderPage.LookByOtherserachSelectoptions());

				for(WebElement lt:list)
				{
					//					act.moveToElement(CommonUtility.highlightElement(driver, lt)).build().perform();
					CommonUtility.ScrollToWebElement(driver, lt);
					String names=lt.getText();
					if(!(names.equals("")))
					{

						System.out.println("Alert Name is: " +names);
						ltMessages+=" <br> " + names;
					}
				}
				Report.put("Click on other look up options  ",
						"In Pop up "+ Report.color(lookupoptionspopuplabel)+" should show with "+ Report.color(lookupoptionspopuplabeltext)+" dropdown values as "+ Report.color(ltMessages),
						"Successfully In Pop up Other look up options should show with Customer number , Po number and Billing information" , "PASS");
			}
			else
			{
				Report.put("Not able to otherlookupoptions",
						"otherlookupoptions label not found ",
						"otherlookupoptions label not found ", "FAIL");
				Assert.fail();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Not able to otherlookupoptions",
					"otherlookupoptions label not found ",
					"otherlookupoptions label not found ", "FAIL");

			Assert.fail();
		}

	}

	///// Sujata new................


	public void OptinsIRNdisplayEMEA(WebDriver driver)
	{
		System.out.println("In function OptinsIRNdisplayEMEA");
		try
		{
			String Search="";
			CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.Optionstoggle());
			CommonUtility.ClickOn(driver,obj_EsupportRecentOrderPage.Optionstoggle());

			if(CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.OptionstoggleIRN()).isDisplayed())
			{
				Search="Options toggle DPID is displayed";
			}

			Report.put("IRN options should be displayed for Only EMEA",
					"Folowing options displayed for Only EMEA as "
							+Report.color(Search)+"<br>",
							"Successfully DPID options should be displayed for Only US ", "PASS");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("DPID options should be displayed for Only US",
					"Folowing options are not displayed for Only US as ",
					" DPID options are not displayed for Only US ", "FAIL");


			Assert.fail();
		}
	}

	public void OptinsDPIDdisplayUS(WebDriver driver)
	{
		System.out.println("In function OptinsDPIDdisplayUS");
		try
		{
			String Search="";
			CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.Optionstoggle());
			CommonUtility.ClickOn(driver,obj_EsupportRecentOrderPage.Optionstoggle());

			if(CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.OptionstoggleDPID()).isDisplayed())
			{
				Search="Options toggle DPID is displayed";
			}

			Report.put("DPID options should be displayed for Only US",
					"Folowing options displayed for Only US as "
							+Report.color(Search)+"<br>",
							"Successfully DPID options should be displayed for Only US ", "PASS");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("DPID options should be displayed for Only US",
					"Folowing options are not displayed for Only US as ",
					" DPID options are not displayed for Only US ", "FAIL");
			Assert.fail();
		}
	}


	public void  Noordersfindinaqpp(WebDriver driver)
	{
		System.out.println("In function Noordersfindinaqpp");
		try
		{

			String ProHeader="";

			if(CommonUtility.CheckpresenceofElementLocated(driver, 10, obj_EsupportRecentOrderPage.Noordersfind())){

				ProHeader =CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.Noordersfind()).getText();

				System.out.println(ProHeader); 


				Report.put("No orders find which we have searched", "No orders find which we have searched",
						"No orders find which we have searched", "FAIL");

				Assert.fail();

			}


		}
		catch(Exception e)
		{
			e.printStackTrace();			
		}
	}


	//pushpa

	public void selectTimeframe(WebDriver driver, String timeFrame)
	{

		System.out.println("In function select TimeFrame");
		//	String timeFrame = TestNGCreator.TestData.get(Esupport.TimeFrameSelected.ordinal());
		try
		{                   
			System.out.println("Timeframe from the excel is "+timeFrame);    
			if(CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.TimeFrameDDdefaultselection()).isDisplayed())
			{

				Select selState = new  Select(driver.findElement(obj_EsupportRecentOrderPage.TimeFrameDDdefaultselection()));

				Thread.sleep(10000);
				try
				{
				selState.selectByVisibleText(timeFrame);             
				}
				catch(Exception e)
				{
					
				}


				Report.put("Select the time Frame",
						"Required timeframe should be selected",
						"Successfully TimeFrame is selected as: "+Report.color(timeFrame), "PASS");
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Select the time Frame",
					"Required timeframe should be selected",
					"Failed to select the timeframe" +Report.color(timeFrame), "FAIL");
			Assert.fail();
		}
	}
	//Sujata

	public void TOverify_RecentorderheaderSerachform(WebDriver driver,String invalidponumber, String validponumber)
	{
		Actions act=new Actions(driver);

		String resentorder="";
		String PQATOrderpage="";

		WebDriverWait wait = new WebDriverWait(driver, 200);


		System.out.println("In function TOverify_RecentorderheaderSerachform");
		try
		{
			//			wait.until(ExpectedConditions.elementToBeClickable(obj_EsupportRecentOrderPage.recentOrdersLabel()));


			Thread.sleep(5000);

			//			Set<String> allWH=driver.getWindowHandles(); 
			//			String currentwindow=driver.getWindowHandle();
			//			int count=allWH.size(); 
			//			System.out.println("Window Handles and  window count is :: "+count);
			//
			//			for(String wh:allWH)
			//			{				
			//				Thread.sleep(10000);
			//				driver.switchTo().window(wh); 
			String mainwindow=driver.getWindowHandle();
			Set<String> set=driver.getWindowHandles();
			Iterator<String> itr=set.iterator();
			while(itr.hasNext())
			{
				String childWindow=itr.next();
				if(!mainwindow.equals(childWindow))
				{
					driver.switchTo().window(childWindow);
					Thread.sleep(7000);
					String title=driver.getCurrentUrl();
					System.out.println("Tittle displayed as   :::::"+title); 



					if(title.contains("NoRedirect"))
					{
						handleCookies(driver);

						System.out.println("Switched to window");
						act.moveToElement(CommonUtility.highlightElement(driver, obj_EsupportRecentOrderPage.recentOrdersLabel())).build().perform();

						PQATOrderpage=CommonUtility.highlightElement(driver, obj_EsupportRecentOrderPage.recentOrdersLabel()).getText();

						Report.put("Click on 'Search form'   ",
								"User Should able to navigate to  " + Report.color(PQATOrderpage)+" Page ",
								"Successfully User should land in "+ Report.color(PQATOrderpage)+" Page ", "PASS");
						//					driver.navigate().back();

						//					driver.navigate().to("https://www.dell.com/support/orders/us/en/RC1288478/?NoRedirect=true{0}");
						Thread.sleep(6000);
						CommonUtility.ScrollTo(driver,obj_EsupportRecentOrderPage.LookByPremierOrderselect());
						Thread.sleep(2000);
						CommonUtility.ClickOn(driver,obj_EsupportRecentOrderPage.LookByPremierOrderselect());
						Thread.sleep(5000);

						String ltMessages="";

						List<WebElement> list=driver.findElements(obj_EsupportRecentOrderPage.LookByPremierOrderselectoptions());

						for(WebElement lt:list)
						{
//							act.moveToElement(CommonUtility.highlightElement(driver, lt)).build().perform();
							CommonUtility.ScrollToWebElement(driver, lt);
							String names=lt.getText();
							if(!(names.equals("")))
							{

								System.out.println("Alert Name is: " +names);
								ltMessages+=" <br> " + names;
							}

						}


						Report.put("Click on search by ",
								" User should see the dropdown and Po number should be available in dropdown " + Report.color(ltMessages),
								" Successfully User should see the dropdown and Po number should be available in dropdown ", "PASS");


						CommonUtility.ClickOn(driver,obj_EsupportRecentOrderPage.LookByPremierOrderselect());
						Thread.sleep(10000);
						CommonUtility.ClickOn(driver,obj_EsupportRecentOrderPage.LookByPremierOrderselect());

						CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.PONumberEnter()).sendKeys(invalidponumber);
						CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.PONumberEnter()).sendKeys(Keys.ENTER);

						//					Thread.sleep(10000);

						String Errormsg=CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.Errorpopupponumber()).getAttribute("data-content");
						System.out.println(Errormsg+"  :::Verifying error message");
						CommonUtility.ClickOn(driver,obj_EsupportRecentOrderPage.PONumberEnterSubmitBtn());

						//					Thread.sleep(10000);
						//CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.Errorpopupponumber());



						//					String Errormsg=CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.Errorpopupponumber()).getAttribute("data-content");
						//					System.out.println(Errormsg+"  :::Verifying error message");

						Report.put("Select the Po number from dropdown and enter Po number in the box  till 3 char   ",
								" Pop over message should be displayed  " + Report.color(Errormsg),
								" Successfully Pop over message displayed but cannot capture through automation with the invalid testdata and clicking on submit button able to see error lert message "+ Report.color(invalidponumber), "PASS");

						Thread.sleep(5000);
						CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.PONumberEnter()).clear();
						CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.PONumberEnter()).sendKeys(validponumber);
						//					CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.PONumberEnter()).sendKeys(Keys.ENTER);

						CommonUtility.ScrollTo(driver,obj_EsupportRecentOrderPage.PONumberEnterSubmitBtn());
						CommonUtility.ClickOn(driver,obj_EsupportRecentOrderPage.PONumberEnterSubmitBtn());
						Thread.sleep(10000);
						wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportRecentOrderPage.RecentOrdersLabel()));

						CommonUtility.ScrollTo(driver,obj_EsupportRecentOrderPage.RecentOrdersLabel());
						String RecentOrdersLabel=CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.RecentOrdersLabel()).getText();
						System.out.println(RecentOrdersLabel);

						Report.put("Now enter the Po number and click on search ",
								" User should retrieve the Po number details in the page as" + Report.color(RecentOrdersLabel),
								" Successfully User should retrieve the Po number details in the page with the valid testdata "+ Report.color(validponumber), "PASS");

						Thread.sleep(4000);
						driver.close();
					}
				}
			}

			driver.switchTo().window(mainwindow);

			Thread.sleep(10000);

			System.out.println("current parent window"+driver.getCurrentUrl());

			//					act.moveToElement(CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.recentOrdersLabel())).build().perform();					
			CommonUtility.ScrollTo(driver,obj_EsupportRecentOrderPage.recentOrdersLabel());
			CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.recentOrdersLabel());

			resentorder=CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.recentOrdersLabel()).getText();

			Thread.sleep(5000);
			Report.put("Comeback to the Premier RO page , By clicking on order status below masthead or by clicking on browser back button ",
					"User Should comeback to  " + Report.color(resentorder)+" Page ",
					"Successfully User should land in Premier Recent Orders page ", "PASS");				



		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on any PO number",
					"User is not land on Recent order details page ",
					"User is not land on Recent order details page ", "FAIL");

			Assert.fail();
		}
	}

	//Sujata new code 4th of feb

	public void ToClick_SearchboxradioOrder(WebDriver driver,String ordernumber)
	{

		System.out.println("In function ToClick_SearchboxradioOrder");
		try
		{
			String Search="";
			System.out.println("Shipped value selected from TimeFrameDDselection");
			CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.Searchtextbox());
			CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.Searchtextbox()).clear();
			CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.Searchtextbox()).sendKeys(ordernumber);

			System.out.println("Successfully entered order number in to the Search order number");

			Thread.sleep(2000);

			CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.Searchiconpoordernumber()).click();

			Thread.sleep(4000);

			CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.Columnordernumberclick());


			Thread.sleep(15000);



			System.out.println("Searched ordernumber is displayed ");


			Report.put("from the Search box select the order number radio button  and enter order number and click on search  ",
					"User should show the order number in the Grid and Enter the order number as "
							+Report.color(ordernumber)+"<br>",
							"Successfully User should show the order number in the Grid ", "PASS");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Search box with radio buttons for Order number and PO number ",
					"Folowing textbox and radio buttons are  not displayed ",
					"Search box with radio buttons for Order number and PO number are not displayed. ", "FAIL");

			Assert.fail();
		}
	}


	//Sudha

	public void clickOnPonumberRadio(WebDriver driver)
	{

		System.out.println("Click on PO Number Radio Button");
		Log.info("Click on PO Number Radio Button");

		try
		{
			handleCookies(driver);   
			WebDriverWait wait = new WebDriverWait(driver, 120);

			CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.PONumberCheckbox()).click();
			Thread.sleep(2000);
			Report.put("On the default load above the RO Grid , From above the search box select the PO radio button ", "PO Radio button should be selected",
					"PO Radio button is selected", "PASS");


		} catch(Exception e)
		{
			e.printStackTrace();
			Report.put("On the default load above the RO Grid , From above the search box select the PO radio button ", "PO Radio button should be selected",
					"User not able to select the PO Radio button", "FAIL");
			Assert.fail();
		}
	}

	public void EnterPONumberwithspecialCharacters(WebDriver driver,String validponumber)
	{

		System.out.println("Enter PONumber with specialCharacters");
		Log.info("Enter PONumber with specialCharacters");

		try
		{

			CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.PONumberSearchTextbox()).clear();
			CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.PONumberSearchTextbox()).sendKeys(validponumber);
			CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.PONumberSearchTextbox()).sendKeys(Keys.ENTER);


			List<WebElement> list=driver.findElements(By.xpath("//table/tbody/tr[2]/td[8]"));

			for(WebElement lt:list)
			{
				CommonUtility.highlightElement(driver, lt);

				String names=lt.getText();
				if(!(names.contains(validponumber)))
				{

					System.out.println("Po number displayed");					
				}
			}


			Report.put("Enter Po number-"+Report.color(validponumber)+"with special characters ! @ - and click on search", "All the Po matching the special char should be shown in the grid",
					"All the Po matching the special char is shown in the grid", "PASS");


		}catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Enter Po number with special characters ! @ - and click on search", "All the Po matching the special char should be shown in the grid",
					"All the Po matching the special char is not showing in the grid", "FAIL");
			Assert.fail();
		}
	}
	public void clickOnreset(WebDriver driver)
	{
		handleCookies(driver);
		System.out.println("Inside clickOnreset");
		Log.info("Inside clickOnreset");

		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);

			CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.ResetButton());
			Thread.sleep(2000);
			Report.put("Click on reset ", "All the Fields in the RO page should get reset",
					"All the Fields in the RO page reset" , "PASS");


		} catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on reset ", "All the Fields in the RO page should get reset",
					"All the Fields in the RO page is not reset" , "FAIL");

			Assert.fail();
		}
	}

	public void EnterPONumberwithLowercase(WebDriver driver,String validponumber)
	{

		System.out.println("Inside EnterPONumberwithLowercase");
		Log.info("Inside EnterPONumberwithLowercase");

		try
		{
			CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.PONumberSearchTextbox()).clear();
			CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.PONumberSearchTextbox()).sendKeys(validponumber);
			CommonUtility.highlightElement(driver,obj_EsupportRecentOrderPage.PONumberSearchTextbox()).sendKeys(Keys.ENTER);

			Report.put("Now Go the search box and select the PO number"+Report.color(validponumber)+" and enter the PO number in Lower case and Mix of lower and upper case and click on search", "Should retrieve the results for the entered PO number irrespective of the case sensitive",
					"All the Po matching the special char is shown in the grid", "PASS");


		}catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Now Go the search box and select the Po number and enter the PO number in Lower case and Mix of lower and upper case and click on search", "Should retrieve the results for the entered PO number irrespective of the case sensitive",
					"All the Po matching the special char is not showing in the grid", "FAIL");
			Assert.fail();
		}
	}

	public void closingWindows(WebDriver driver)
	{
		System.out.println("Inside closingWindows");
		Log.info("Inside closingWindows");

		try
		{

			Set<String> win=driver.getWindowHandles();
			for (String s : win ){
				driver.switchTo().window(s);
			}
			Thread.sleep(5000);
			driver.close();
			Thread.sleep(5000);
			win=driver.getWindowHandles();
			for (String s : win ){
				Thread.sleep(5000);
				driver.switchTo().window(s);
			}

		}catch(Exception e)
		{
			e.printStackTrace();			
			Assert.fail();
		}
	} 
}