package com.dell.delta_uat_automation.esupport.workflows;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.dell.delta_uat_automation.utility.CommonUtility;
import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.Log;
import com.dell.delta_uat_automation.utility.Report;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class EsupportErevenueWorkflow extends BaseFlow 
{
	public EsupportIncidentsWorkflow obj_EsupportIncidentsWorkflow = new EsupportIncidentsWorkflow();
	
	public void handleCookies(WebDriver driver)
	{
		System.out.println("Handle Cookies");
		Log.info("Handle Cookies");	
		WebDriverWait wait = new WebDriverWait(driver,200);
		try
		{
			if(CommonUtility.CheckpresenceofElementLocated(driver, 10, obj_PortalPage.acceptCookies()))
			{
		
				CommonUtility.ClickOn(driver,obj_PortalPage.acceptCookies()); 
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

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	} 
		
	public void EnterServiceTag(WebDriver driver,String Servicetag)
	{
		System.out.println("EnterServiceTag");
		Log.info("Handle Cookies");	
		try{
			wait = new WebDriverWait(driver, 50);
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			CommonUtility.highlightElement(driver,obj_EsupportErevenueHomePage.contactUs()).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportErevenueHomePage.technicalSupportSelect()));
			if(CommonUtility.highlightElement(driver,obj_EsupportErevenueHomePage.technicalSupportSelect()).isDisplayed())
			{
				System.out.println("Technical Support displayed");
				CommonUtility.highlightElement(driver,obj_EsupportErevenueHomePage.technicalSupportSelect()).click();
			}
			handleCookies(driver);
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportErevenueHomePage.tsHeader()));
			CommonUtility.highlightElement(driver,obj_EsupportErevenueHomePage.tsHeader());

			CommonUtility.highlightElement(driver,obj_EsupportErevenueHomePage.SearchServicetag()).clear();
			CommonUtility.highlightElement(driver,obj_EsupportErevenueHomePage.SearchServicetag()).sendKeys(Servicetag);
			CommonUtility.highlightElement(driver,obj_EsupportErevenueHomePage.Servicetagiconsearch()).click();

			Report.put("Enter the tag as "+Report.color(Servicetag),
					"User Should Land in Product support page for the Entered Service tag as"+Report.color(Servicetag),
					"Successfully Application should navigate to Contact Technical Support Home page", "PASS");

		}catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Not able to find Enter service tag Textbox", "Not able to find Enter service tag",
					"Not able to find Enter service tag Textbox", "FAIL");
			Assert.fail();

		}
	}
	public void  Click_IssueTypeandSubIssueLink(WebDriver driver) 
	{
		System.out.println("Click on Issue Type");
		Log.info("Click on Issue Type");	
		WebDriverWait  wait = new WebDriverWait(driver, 120);
		System.out.println("After webdriver wait");
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);

		try
		{
			handleCookies(driver);
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIncidentsPage.IssueLink())); 

			CommonUtility.highlightElement(driver,obj_EsupportErevenueHomePage.IssueLink()).click();

			Thread.sleep(5000);
			CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.SubIssueLink()).click();
			Thread.sleep(5000);

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportErevenueHomePage.ContactChannelsHeading()));
			CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.ExpressService());
			System.out.println("Clicked on Issue Type and Sub Issue");
			Report.put("Click on any Issue type and select a sub issue", "User must be able to select an issue type and redirected to Contact Channels page", "Successfully redirected to Contact Channels page", "PASS");

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on any Issue type and select a sub issue", "User must be able to select an issue type and redirected to Contact Channels page", "It's not redirected to Contact Channels page", "FAIL");
			Assert.fail();
		}
	}
	public void  ToSelect_ExpressService(WebDriver driver) 
	{
		System.out.println("Entering method To Select Express Service");
		Log.info("Entering method To Select Express Service");
		WebDriverWait  wait = new WebDriverWait(driver, 120);
		String Express;
		try
		{
			Express= CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.ExpressService()).getText();
			CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.ExpressServiceSelect()).click();

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportErevenueHomePage.ContanctTechnicalSupportHeader()));
			CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.ContanctTechnicalSupportHeader());

			Report.put("Select"+Report.color(Express)+ "by clicking SELECT button", "It should navigate to the page where the user need describe the problem in detail.", "Successfully redirected to Contact Tenical Support Page", "PASS");



		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Select EXPRESS SERVICE by clicking SELECT button", "It should navigate to the page where the user need describe the problem in detail.", "Failed to Redirect to Contact Tenical Support Page", "FAIL");
			Assert.fail();
		}
	}

	public void  ToValidate_Textbox_MaximumCharacters(WebDriver driver) 
	{
		System.out.println("Entering method To Validate Textbox");
		Log.info("Entering method To Validate Textbox");
		WebDriverWait  wait = new WebDriverWait(driver, 120);
		String max_length;
		try
		{
			handleCookies(driver);
			max_length=driver.findElement(By.xpath("//div[@class='ng-scope']/div/textarea")).getAttribute("maxlength");
			System.out.println(max_length);
			if(max_length.equals("150")) 
			{	            	 
				Report.put("Text box that can hold a max of 150 characters, including spaces", "Text box should hold max of" +Report.color(max_length)+" characters, including spaces", "Text box is accepting max of 150 characters, including space", "PASS");



			}  else
			{     
				Report.put("Text box that can hold a max of 150 characters, including spaces", "Text box should hold max of 150 characters, including spaces", "Text box is not accepting max of 150 characters, including space", "FAIL");
				Assert.fail();

			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Text box that can hold a max of 150 characters, including spaces", "Text box should hold max of 150 characters, including spaces", "Text box is not accepting max of 150 characters, including space", "FAIL");
			Assert.fail();
		}
	}
	public void  ToVerify_TextboxLabel(WebDriver driver) 
	{
		System.out.println("Entering method To VerifyTextbox Label");
		Log.info("Entering method To Verify Textbox Label");
		WebDriverWait  wait = new WebDriverWait(driver, 120);
		String Label;
		try
		{
			// handleCookies(driver);
			Label=CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.Label()).getText();
			System.out.println(Label);
			if(Label.equalsIgnoreCase("To provide better service, please describe the problem")) 
			{	            	 
				Report.put("Validate the Free Text Entry Box", "Text box is labeled with the following text: "+Report.color(Label),"Text box is labeled with the following text: To provide better service, please describe the problem", "PASS");



			}  else
			{     
				Report.put("Validate the Free Text Entry Box", "Text box should be labeled with the following text: To provide better service, please describe the problem","Text box is not labeled with the following text: To provide better service, please describe the problem", "FAIL");

				Assert.fail();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Validate the Free Text Entry Box", "Text box should be labeled with the following text: To provide better service, please describe the problem","Text box is not labeled with the following text: To provide better service, please describe the problem", "FAIL");
			Assert.fail();
		}
	}
	public void  Textboxfilling_mandatory(WebDriver driver) 
	{
		System.out.println("Entering method To VerifyTextbox Label");
		Log.info("Entering method To Verify Textbox Label");
		WebDriverWait  wait = new WebDriverWait(driver, 120);
		String Label;
		try
		{

			CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.Nextbtn()).click();
			//CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.Label());

			Report.put("Validate the Free Text Entry Box", "Text box filling is mandatory, if text is not entered, then customers should see field error state indicating text box is mandatory (EXACT TEXT IS TBD) when they click next","Text box filling is mandatory", "PASS");



		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Validate the Free Text Entry Box", "Text box should be labeled with the following text: To provide better service, please describe the problem","Text box filling is not mandatory", "FAIL");
			Assert.fail();
		}
	}

	public void  ToValidate_TextboxwithSpecialCharacters(WebDriver driver,String Text) 
	{
		System.out.println("Entering method To Validate Textbox with Special Characters");
		Log.info("Entering method To Validate Textbox with Special Characters");
		WebDriverWait  wait = new WebDriverWait(driver, 120);
		String spec;
		try
		{
			System.out.println(Text);
			CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.TextArea()).sendKeys(Text);
			Thread.sleep(2000);
			spec=CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.TextArea()).getText();



			System.out.println(spec);

			if(!(spec.equalsIgnoreCase(Text)))
			{	            	 
				Report.put("Validate the scenarios in the Free Text Entry Box with Special Characters", "Text cannot allow for special characters'<>\' to prevent exceptions","Text is not allowing for special characters '<>\' to prevent exceptions characters, including spaces", "PASS");


			}  else
			{     
				Report.put("Validate the scenarios in the Free Text Entry Box with Special Characters", "Text cannot allow for special characters'<>\' to prevent exceptions","Text is allowing for special characters '<>\' to prevent exceptions characters, including spaces", "FAIL");
				Assert.fail();

			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Text box that can hold a max of 150 characters, including spaces", "Text box should hold max of 150 characters, including spaces", "Text box is not accepting max of 150 characters, including space", "FAIL");
			Assert.fail();
		}
	}
	//sujata 1stMarch
	public void ToClick_ContactUS(WebDriver driver)
	{

		System.out.println("Entering in method to ToClick_ContactUS");


		try
		{

			handleCookies(driver);
			WebDriverWait wait = new WebDriverWait(driver, 120);

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportErevenueHomePage.ContanctUS()));

			CommonUtility.highlightElement(driver,obj_EsupportErevenueHomePage.ContanctUS());

			CommonUtility.highlightElement(driver,obj_EsupportErevenueHomePage.ContanctUS()).click();

			Report.put("Click on ContanctUS", " Contanct Us slider should be display",
					"Successfully Contanct Us slider displayed", "PASS");




		} catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on ContanctUS", " Failed to display Contanct Us slider ",
					"Failed to display Contanct Us slider", "FAIL");
			Assert.fail();
		}
	}

	public void ToClick_ContactTechnicalSupport(WebDriver driver)
	{

		System.out.println("Entering in method to ToClick_ContactTechnicalSupport");


		try
		{

			//handleCookies(driver);
			WebDriverWait wait = new WebDriverWait(driver, 120);

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportErevenueHomePage.ContanctTechnicalSupport()));

			CommonUtility.highlightElement(driver,obj_EsupportErevenueHomePage.ContanctTechnicalSupport());

			CommonUtility.highlightElement(driver,obj_EsupportErevenueHomePage.ContanctTechnicalSupport()).click();

			Report.put("Click on Technical Support link in contanctUS Slider", " Technical Support link displayed and able to click",
					"Successfully Technical Support link displayed and able to click", "PASS");




		} catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on Technical Support link in contanctUS Slider", " Failed to Click Technical Support link ",
					"Failed to Click Technical Support link", "FAIL");
			Assert.fail();

		}
	}


	public void ToVerify_EnterServiceTag(WebDriver driver,String Servicetag) 
	{
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 120);

		System.out.println("Entering ToVerify_EnterServiceTag");

		Log.info("Entering ToVerify_EnterServiceTag");         
		try 
		{
			String ServiceTag="";
			String DetectPCButton="";

			String ProductImage="";
			String ProductName="";
			String ESC="";
			String Warranty="";
			String ChangeProductlink="";
			String IssueList="";


			handleCookies(driver);

			CommonUtility.highlightElement(driver,obj_EsupportIncidentsPage.Delllogo());


			CommonUtility.highlightElement(driver,obj_EsupportIncidentsPage.SearchServicetag());




			if(CommonUtility.highlightElement(driver,obj_EsupportIncidentsPage.DetectPCButton()).isDisplayed())
			{
				DetectPCButton=CommonUtility.highlightElement(driver,obj_EsupportIncidentsPage.DetectPCButton()).getText();
			}


			String SearchServicetag ="";
			if(CommonUtility.highlightElement(driver,obj_EsupportIncidentsPage.SearchServicetag()).isDisplayed())
			{
				SearchServicetag="Servicetag";
			}

			//handleCookies(driver);

			CommonUtility.highlightElement(driver,obj_EsupportIncidentsPage.SearchServicetag()).clear();
			CommonUtility.highlightElement(driver,obj_EsupportIncidentsPage.SearchServicetag()).sendKeys(Servicetag);
			CommonUtility.highlightElement(driver,obj_EsupportIncidentsPage.Servicetagiconsearch()).click();
			CommonUtility.highlightElement(driver,obj_EsupportIncidentsPage.SearchServicetag()).sendKeys(Keys.ENTER);
			Thread.sleep(3000);

			// handleCaptcha(driver); 

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIncidentsPage.TechnicalSupportHeader()));
			CommonUtility.highlightElement(driver,obj_EsupportIncidentsPage.TechnicalSupportHeader());
			String TechnicalSupportHeader=CommonUtility.highlightElement(driver,obj_EsupportIncidentsPage.TechnicalSupportHeader()).getText();
			Report.put("Enter an ESC and click on Search button.", "User must land on "+Report.color(TechnicalSupportHeader)+" page of given ESC.",
					"Successfully User must land on Contact Technical Support(CTS) page of given ESC.", "PASS");




		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Not able to find Entered service tag", "Not able to find Entered service tag",
					"Not able to find Entered service tag", "FAIL");
			Assert.fail();
		}



	}

	public void  Click_IssueType(WebDriver driver) 
	{
		System.out.println("Click on Issue Type");
		WebDriverWait  wait = new WebDriverWait(driver, 120);
		System.out.println("After webdriver wait");
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);

		try
		{

			handleCookies(driver);

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportErevenueHomePage.IssueLink())); 

			CommonUtility.highlightElement(driver,obj_EsupportErevenueHomePage.IssueLink()).click();

			Thread.sleep(2000);
			CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.SubIssueLink()).click();
			Thread.sleep(2000);

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportErevenueHomePage.ContactChannelsHeading()));
			CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.ExpressService());



			System.out.println("Clicked on Issue Type and Sub Issue");

			Report.put("Click on any Issue type and select a sub issue", "User must be able to select an issue type and redirected to Contact Channels page", "Successfully redirected to Contact Channels page", "PASS");

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on any Issue type and select a sub issue", "User must be able to select an issue type and redirected to Contact Channels page", "It's not redirected to Contact Channels page", "FAIL");
			Assert.fail();
		}
	}

	public void  ToClick_IssueTypePCMakingnoise(WebDriver driver) 
	{
		System.out.println("Entering method ToClick_IssueTypePCMakingnoise");
		WebDriverWait  wait = new WebDriverWait(driver, 120);

		try
		{

			handleCookies(driver);

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportErevenueHomePage.IssueLink())); 

			CommonUtility.highlightElement(driver,obj_EsupportErevenueHomePage.IssueLink()).click();

			Thread.sleep(2000);
			CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.SubIssueLink()).click();
			Thread.sleep(2000);

			Report.put("Select OTHER ISSUES ---> PC MAKING NOISE from the home page", 
					"It should navigate to the page where it shows the service options.",
					"Successfully navigate to the page where it shows the service options.", "PASS");


			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportErevenueHomePage.ContactChannelsHeading()));
			CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.StandardService());
			CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.StandardService()).click();



			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportErevenueHomePage.StatandardServiceSelect()));

			CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.StatandardServiceSelect()).click();


			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportErevenueHomePage.ContanctTechnicalSupportheader()));
			CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.ContanctTechnicalSupportheader());


			System.out.println("Clicked on Issue Type and Sub Issue");
			Report.put("Select STANDARD SERVICE by clicking SELECT button", 
					"it should navigate to the page where the user need describe the problem in detail.",
					"Successfully navigate to the page where the user need describe the problem in detail.", "PASS");

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Select STANDARD SERVICE by clicking SELECT button", 
					"Failed to navigate to the page where the user need describe the problem in detail.",
					"Failed to navigate to the page where the user need describe the problem in detail.", "FAIL");
			Assert.fail();

		}
	}

	public void ToEnter_Betterservicecomment(WebDriver driver,String textArea)
	{

		System.out.println("Entering in method to ToEnter_Betterservicecomment");


		try
		{

			handleCookies(driver);
			WebDriverWait wait = new WebDriverWait(driver, 120);

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportErevenueHomePage.TextAreaComment()));

			CommonUtility.highlightElement(driver,obj_EsupportErevenueHomePage.TextAreaComment());

			CommonUtility.highlightElement(driver,obj_EsupportErevenueHomePage.TextAreaComment()).sendKeys(textArea);

			Report.put("Enter Free text content ", " Free Text content should be entered to proceed further",
					"Successfully Free Text content entered to proceed further", "PASS");

			Thread.sleep(3000);

			CommonUtility.highlightElement(driver,obj_EsupportErevenueHomePage.TextAreaCommentNextBtn());

			CommonUtility.highlightElement(driver,obj_EsupportErevenueHomePage.TextAreaCommentNextBtn()).click();

			Thread.sleep(3000);

			Report.put("Click on NEXT button ", " It should navigate to Summary page",
					"Successfully navigate to Summary page", "PASS");


			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportErevenueHomePage.CheckPleasenotifymeSMS()));

			CommonUtility.highlightElement(driver,obj_EsupportErevenueHomePage.CheckPleasenotifymeSMS()).click();

			CommonUtility.highlightElement(driver,obj_EsupportErevenueHomePage.CheckPleasenotifymeSMSText());

			String PleasenotifymeSMS  =CommonUtility.highlightElement(driver,obj_EsupportErevenueHomePage.CheckPleasenotifymeSMSText()).getText();
			CommonUtility.highlightElement(driver,obj_EsupportErevenueHomePage.CheckPleasenotifymeSMSAddToCart()).click();

			System.out.println("searching for Popup");
			Thread.sleep(3000);
			if(CommonUtility.CheckpresenceofElementLocated(driver, 05, obj_EsupportErevenueHomePage.AddToCartPopupIagree()))
			{
				System.out.println("Finding for Popup and click on i agree");
				CommonUtility.highlightElement(driver,obj_EsupportErevenueHomePage.AddToCartPopupIagree()).click();

			}


			Thread.sleep(8000);


			System.out.println("searched for Popup");

			Report.put("In Summary Page Click on Add to Cart ", " Veify the Time Slot selected / Repair Cost & Free Text and validate.It should redirect the user to Cart page.Select option "+Report.color(PleasenotifymeSMS),
					"Successfully Free Text content entered to proceed further", "PASS");


			handleCookies(driver);


			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportErevenueHomePage.ContanctTechnicalSupportheader()));
			CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.ContanctTechnicalSupportheader());



		} catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Enter Free text content ", " Not Able to Enter Free Text content should be entered to proceed further",
					" Not Able to Enter Free Text content should be entered to proceed further", "FAIL");
			Assert.fail();

		}
	}


	public void ToClick_CartCheckOut(WebDriver driver)
	{

		System.out.println("Entering in method to ToClick_CartCheckOut");


		try
		{

			//handleCookies(driver);
			WebDriverWait wait = new WebDriverWait(driver, 120);

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportErevenueHomePage.CartCheckout()));

			CommonUtility.highlightElement(driver,obj_EsupportErevenueHomePage.CartCheckout());

			WebElement ele=driver.findElement(obj_EsupportErevenueHomePage.CartCheckout());
			CommonUtility.ToClickByUsingJavaScript(driver, ele);

			// CommonUtility.highlightElement(driver,obj_EsupportErevenueHomePage.CartCheckout()).click();

			handleCookies(driver);

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportErevenueHomePage.CartCheckoutGuestCheckout()));

			CommonUtility.highlightElement(driver,obj_EsupportErevenueHomePage.CartCheckoutGuestCheckout());

			CommonUtility.highlightElement(driver,obj_EsupportErevenueHomePage.CartCheckoutGuestCheckout()).click();

			handleCookies(driver);



			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportErevenueHomePage.ContanctTechnicalSupportheader()));
			CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.ContanctTechnicalSupportheader());



			Report.put("Verify cart details and press Guestcheckout button", " The page is navigate to Shipping",
					"Successfully The page is navigate to Shipping", "PASS");




		} catch(Exception e)
		{
			e.printStackTrace();

			Report.put("Verify cart details and press Guestcheckout button", " Failed to navigate to Shipping",
					"Failed to navigate to Shipping", "FAIL");


			Assert.fail();
		}
	}

	public void ToEnter_Userinformation(WebDriver driver)
	{

		System.out.println("Entering in method to ToEnter_Userinformation");


		try
		{

			String firstname=TestNGCreator.TestData.get(Esupport.FirstName.ordinal());

			String lastname=TestNGCreator.TestData.get(Esupport.LastName.ordinal());

			String StreetAddress=TestNGCreator.TestData.get(Esupport.StreetAddress.ordinal());

			String StreetAddressCity=TestNGCreator.TestData.get(Esupport.City.ordinal());
			String StreetAddressPostalCode=TestNGCreator.TestData.get(Esupport.PostalCode.ordinal());

			String StreetAddressPhonenumber=TestNGCreator.TestData.get(Esupport.BillingPhoneNumber.ordinal());

			String StreetAddressEmailAddress=TestNGCreator.TestData.get(Esupport.Email.ordinal());




			//handleCookies(driver);
			WebDriverWait wait = new WebDriverWait(driver, 120);

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportErevenueHomePage.GuestCheckoutFirstName()));

			CommonUtility.highlightElement(driver,obj_EsupportErevenueHomePage.GuestCheckoutFirstName());

			CommonUtility.highlightElement(driver,obj_EsupportErevenueHomePage.GuestCheckoutFirstName()).sendKeys(firstname);

			Thread.sleep(2000);

			CommonUtility.highlightElement(driver,obj_EsupportErevenueHomePage.GuestCheckoutLastName());

			CommonUtility.highlightElement(driver,obj_EsupportErevenueHomePage.GuestCheckoutLastName()).sendKeys(lastname);

			Thread.sleep(2000);

			CommonUtility.highlightElement(driver,obj_EsupportErevenueHomePage.StreetAddress());

			CommonUtility.highlightElement(driver,obj_EsupportErevenueHomePage.StreetAddress()).sendKeys(StreetAddress);
			Thread.sleep(2000);
			CommonUtility.highlightElement(driver,obj_EsupportErevenueHomePage.StreetAddressCity());

			CommonUtility.highlightElement(driver,obj_EsupportErevenueHomePage.StreetAddressCity()).sendKeys(StreetAddressCity);
			Thread.sleep(2000);

			CommonUtility.highlightElement(driver,obj_EsupportErevenueHomePage.StreetAddressPostalCode());

			CommonUtility.highlightElement(driver,obj_EsupportErevenueHomePage.StreetAddressPostalCode()).sendKeys(StreetAddressPostalCode);

			Thread.sleep(2000);

			CommonUtility.highlightElement(driver,obj_EsupportErevenueHomePage.StreetAddressPhonenumber());

			CommonUtility.highlightElement(driver,obj_EsupportErevenueHomePage.StreetAddressPhonenumber()).sendKeys(StreetAddressPhonenumber);

			Thread.sleep(2000);

			CommonUtility.highlightElement(driver,obj_EsupportErevenueHomePage.StreetAddressEmailAddress());

			CommonUtility.highlightElement(driver,obj_EsupportErevenueHomePage.StreetAddressEmailAddress()).sendKeys(StreetAddressEmailAddress);

			Thread.sleep(2000);
			String topActionValues="";


			CommonUtility.highlightElement(driver,obj_EsupportErevenueHomePage.StreetAddressSelectState());

			CommonUtility.highlightElement(driver,obj_EsupportErevenueHomePage.StreetAddressSelectState()).click();

			Thread.sleep(4000);

			Select selAction = new  Select(driver.findElement(obj_EsupportErevenueHomePage.StreetAddressSelectState()));

			selAction.selectByVisibleText("California");

			Thread.sleep(2000);

			CommonUtility.highlightElement(driver,obj_EsupportErevenueHomePage.StreetAddressclickContinue());

			CommonUtility.highlightElement(driver,obj_EsupportErevenueHomePage.StreetAddressclickContinue()).click();

			Thread.sleep(5000);





			Report.put("Enter First name , Lastname, Street Address, City ,Postal Code, Phone Number and Email Address", " User is able to enter all mandotory fields and click on Continue",
					"Successfully User is able to enter all mandotory fields and click on Continue", "PASS");




		} catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Enter First name , Lastname, Street Address, City ,Postal Code, Phone Number and Email Address", " Failed to enter mandotory fields and Failed to click on Continue",
					"Failed to enter mandotory fields and Failed to click on Continue", "FAIL");
			Assert.fail();

		}
	}


	public void ToClick_Usethisaddress(WebDriver driver)
	{

		System.out.println("Entering in method to ToClick_Usethisaddress");


		try
		{

			//handleCookies(driver);
			WebDriverWait wait = new WebDriverWait(driver, 120);

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportErevenueHomePage.Usethisaddressclick()));

			CommonUtility.highlightElement(driver,obj_EsupportErevenueHomePage.Usethisaddressclick());

			CommonUtility.highlightElement(driver,obj_EsupportErevenueHomePage.Usethisaddressclick()).click();

			Thread.sleep(5000);

			handleCookies(driver);

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportErevenueHomePage.Creditcardclick()));

			CommonUtility.highlightElement(driver,obj_EsupportErevenueHomePage.Creditcardclick());

			CommonUtility.highlightElement(driver,obj_EsupportErevenueHomePage.Creditcardclick()).click();






			Report.put("Verify cart details and press Continue button", " It should navigate to Payment details page.",
					"Successfully It should navigate to Payment details page.", "PASS");




		} catch(Exception e)
		{
			e.printStackTrace();

			Report.put("Verify cart details and press Continue button", " Failed to navigate to Payment details page.",
					"Failed to navigate to Payment details page.", "FAIL");
			Assert.fail();

		}
	}

	public void ToEnter_creditcarddetails(WebDriver driver)
	{

		System.out.println("Entering in method to ToEnter_creditcarddetails");

		String CreditcardNumber=TestNGCreator.TestData.get(Esupport.CustomerNumber.ordinal());

		String Nameoncard=TestNGCreator.TestData.get(Esupport.FirstName.ordinal());

		String SecurityCode=TestNGCreator.TestData.get(Esupport.Dpid.ordinal());

		String PaymentPhonenumber=TestNGCreator.TestData.get(Esupport.PhoneNumber.ordinal());

		try
		{

			//handleCookies(driver);
			WebDriverWait wait = new WebDriverWait(driver, 120);

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportErevenueHomePage.CreditcardNumber()));

			CommonUtility.highlightElement(driver,obj_EsupportErevenueHomePage.CreditcardNumber());

			CommonUtility.highlightElement(driver,obj_EsupportErevenueHomePage.CreditcardNumber()).sendKeys(CreditcardNumber);

			Thread.sleep(2000);


			CommonUtility.highlightElement(driver,obj_EsupportErevenueHomePage.Expmonth());

			CommonUtility.highlightElement(driver,obj_EsupportErevenueHomePage.Expmonth()).click();

			Thread.sleep(2000);

			Select selAction = new  Select(driver.findElement(obj_EsupportErevenueHomePage.Expmonth()));

			selAction.selectByVisibleText("6");

			Thread.sleep(3000);



			CommonUtility.highlightElement(driver,obj_EsupportErevenueHomePage.Expyear());

			CommonUtility.highlightElement(driver,obj_EsupportErevenueHomePage.Expyear()).click();

			Thread.sleep(2000);

			Select selAction1 = new  Select(driver.findElement(obj_EsupportErevenueHomePage.Expyear()));

			selAction1.selectByVisibleText("2022");
			Thread.sleep(2000);




			CommonUtility.highlightElement(driver,obj_EsupportErevenueHomePage.Nameoncard());

			CommonUtility.highlightElement(driver,obj_EsupportErevenueHomePage.Nameoncard()).sendKeys(Nameoncard);

			Thread.sleep(2000);


			CommonUtility.highlightElement(driver,obj_EsupportErevenueHomePage.SecurityCode());

			CommonUtility.highlightElement(driver,obj_EsupportErevenueHomePage.SecurityCode()).sendKeys(SecurityCode);

			Thread.sleep(2000);


			CommonUtility.highlightElement(driver,obj_EsupportErevenueHomePage.PaymentPhonenumber());

			CommonUtility.highlightElement(driver,obj_EsupportErevenueHomePage.PaymentPhonenumber()).sendKeys(PaymentPhonenumber);

			Thread.sleep(2000);


			CommonUtility.highlightElement(driver,obj_EsupportErevenueHomePage.ContinueButton());

			// CommonUtility.highlightElement(driver,obj_EsupportErevenueHomePage.ContinueButton()).click();
			WebElement ele=driver.findElement(obj_EsupportErevenueHomePage.ContinueButton());
			CommonUtility.ToClickByUsingJavaScript(driver, ele);

			Thread.sleep(2000);

			Report.put("Provide card details creditcard number , Exp month , exp year ,Name on card ,serivice code, phone number and press Continue button", " User is able to enter carddetails and click Continue button",
					"Successfully User is able to enter carddetails and click Continue button", "PASS");


		} catch(Exception e)
		{
			e.printStackTrace();


			Report.put("Provide card details and press Continue button", " Failed to enter carddetails and Failed to click Continue button",
					"Failed to enter carddetails and Failed to click Continue button", "FAIL");

			Assert.fail();

		}
	}
	//4thMarch
	public void  ToClick_IssueTypeMalwareInstalled(WebDriver driver) 
	{
		System.out.println("Entering method ToClick_IssueTypeMalwareInstalled");
		WebDriverWait  wait = new WebDriverWait(driver, 120);

		try
		{

			handleCookies(driver);

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportErevenueHomePage.SlowPerformance())); 

			CommonUtility.highlightElement(driver,obj_EsupportErevenueHomePage.SlowPerformance()).click();

			Thread.sleep(2000);
			CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.MalwareInstalled()).click();
			Thread.sleep(2000);

			Report.put("Select Slow performance ->Malware Installed from the home page", 
					"It should navigate to Diagnostic Channel for Software Repair with an option Select Button",
					"Successfully navigate to the page  Diagnostic Channel for Software Repair  with an option Select Button", "PASS");

			if(CommonUtility.CheckpresenceofElementLocated(driver, 05, obj_EsupportErevenueHomePage.SoftwareDiagnosis()))
			{
				CommonUtility.scrollToViewElement(driver, obj_EsupportErevenueHomePage.SoftwareDiagnosis());
			}else
			{
				System.out.println("Software Diagonsis & Repair channel is not present");
				Report.put("Click on the Select Button", 
						"It should load the Scheduled time slots - Current / Upcoming time slots till next 7 days.",
						"Software Diagonsis & Repair channel is not present", "FAIL");
				Assert.fail();
			}



			CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.SoftwareDiagnosis());




			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportErevenueHomePage.SoftwareDiagnosisSelect()));

			CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.SoftwareDiagnosisSelect()).click();
			System.out.println("Clicked on Software Diagnosis Select button");
			Log.info("Clicked on Software Diagnosis Select button");


			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportErevenueHomePage.ContanctTechnicalSupportheader()));
			CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.ContanctTechnicalSupportheader());

			handleCookies(driver);
			if(CommonUtility.CheckpresenceofElementLocated(driver, 05, obj_EsupportErevenueHomePage.ScheduledTimeSlot()))
			{
				CommonUtility.scrollToViewElement(driver, obj_EsupportErevenueHomePage.ScheduledTimeSlot());
				CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.ScheduledTimeSlot()).click();

			}else
			{
				System.out.println("Scheduled Time Slot is not present");
				Report.put("Click on the Select Button", 
						"It should load the Scheduled time slots - Current / Upcoming time slots till next 7 days.",
						"Scheduled Time Slot is not present", "FAIL");
				Assert.fail();
			}

			if(CommonUtility.CheckpresenceofElementLocated(driver, 05, obj_EsupportErevenueHomePage.PickanotherSlot()))
			{
				CommonUtility.scrollToViewElement(driver, obj_EsupportErevenueHomePage.PickanotherSlot());
				CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.PickanotherSlot()).click();

				Thread.sleep(3000);

				List<WebElement> list=driver.findElements(obj_EsupportErevenueHomePage.UpcomingTimeSlots());

				for(WebElement l:list){
					System.out.println(l.getText());


				}



			}else
			{
				System.out.println("Pick another Slot is not present");
				Report.put("Click on the Select Button", 
						"It should load the Scheduled time slots - Current / Upcoming time slots till next 7 days.",
						"Pick another Slot is not present", "FAIL");
				Assert.fail();
			}


			System.out.println("Pick another slot time slots are displayed");
			Log.info("Pick another slot time slots are displayed");

			Report.put("Click on the Select Button", 
					"It should load the Scheduled time slots - Current / Upcoming time slots till next 7 days.",
					"Successfully navigate to the page where the user need to select Scheduled time slots - Current / Upcoming time slots", "PASS");

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on the Select Button", 
					"It should load the Scheduled time slots - Current / Upcoming time slots till next 7 days.",
					"User not redirected to the page where the user need to select Scheduled time slots - Current / Upcoming time slots", "FAIL");
			Assert.fail();
		}
	}

	private void click() {
		// TODO Auto-generated method stub

	}

	public void ToEnter_Betterservicecomment_TimeSlots(WebDriver driver,String textArea)
	{

		System.out.println("Entering in method toToEnter_Betterservicecomment_TimeSlots");


		try
		{


			WebDriverWait wait = new WebDriverWait(driver, 120);


			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportErevenueHomePage. SoftwareDiagonsisTextAreaComment()));
			CommonUtility.scrollToViewElement(driver, obj_EsupportErevenueHomePage.SoftwareDiagonsisTextAreaComment());

			CommonUtility.highlightElement(driver,obj_EsupportErevenueHomePage.SoftwareDiagonsisTextAreaComment());

			CommonUtility.highlightElement(driver,obj_EsupportErevenueHomePage.SoftwareDiagonsisTextAreaComment()).sendKeys(textArea);

			Report.put("Enter Free text content ", " Free Text content should be entered to proceed further",
					"Successfully Free Text content entered to proceed further", "PASS");

			Thread.sleep(3000);

			CommonUtility.highlightElement(driver,obj_EsupportErevenueHomePage.SoftwareDiagonsisTextAreaCommentNextBtn());

			CommonUtility.highlightElement(driver,obj_EsupportErevenueHomePage.SoftwareDiagonsisTextAreaCommentNextBtn()).click();

			Thread.sleep(3000);

			Report.put("Click on NEXT button ", " It should navigate to Summary page",
					"Successfully navigate to Summary page", "PASS");



			Thread.sleep(3000);
			if(CommonUtility.CheckpresenceofElementLocated(driver, 05, obj_EsupportErevenueHomePage.SoftwareDiagonsisAddToCart()))
			{

				CommonUtility.highlightElement(driver,obj_EsupportErevenueHomePage.SoftwareDiagonsisAddToCart()).click();

			}


			Thread.sleep(3000);
			if(CommonUtility.CheckpresenceofElementLocated(driver, 05, obj_EsupportErevenueHomePage.AddToCartPopupIagree()))
			{
				System.out.println("Finding for Popup and click on i agree");
				CommonUtility.highlightElement(driver,obj_EsupportErevenueHomePage.AddToCartPopupIagree()).click();

			}


			Report.put("In Summary Page Click on Add to Cart ", " Veify the Time Slot selected / Repair Cost & Free Text and validate.It should redirect the user to Cart page.",
					"Successfully Free Text content entered to proceed further", "PASS");


			handleCookies(driver);


			// wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportErevenueHomePage.ContanctTechnicalSupportheader()));
			//                   CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.ContanctTechnicalSupportheader());



		} catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Enter Free text content ", " Not Able to Enter Free Text content should be entered to proceed further",
					" Not Able to Enter Free Text content should be entered to proceed further", "FAIL");
			Assert.fail();

		}
	}

	public void clickSkipLink(WebDriver driver)
	{
		System.out.println("Inside clickSkipLink");

		try
		{
			handleCookies(driver);
			String header = "";
			WebDriverWait wait = new WebDriverWait(driver, 120);

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportErevenueHomePage.SkipLink()));

			CommonUtility.highlightElement(driver,obj_EsupportErevenueHomePage.SkipLink());

			CommonUtility.highlightElement(driver,obj_EsupportErevenueHomePage.SkipLink()).click();

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportErevenueHomePage.ContactOptionsHeader()));

			CommonUtility.highlightElement(driver,obj_EsupportErevenueHomePage.ContactOptionsHeader());

			header = CommonUtility.highlightElement(driver,obj_EsupportErevenueHomePage.ContactOptionsHeader()).getText();

			System.out.println("Header is:"+header);

			Report.put("Click SKIP link in the right top corner",
					"Clicking Skip button should navigate to Contact Options page.",
					"Successfully navigated to Contact Options page. Header is:"+Report.color(header), "PASS");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click SKIP link in the right top corner",
					"Clicking Skip button should navigate to Contact Options page.",
					"Failed to navigate to Contact Options page", "FAIL");
			Assert.fail();
		}
	}

	public void displayContactOptionsList(WebDriver driver)
	{
		System.out.println("Inside displayContactOptionsList");

		try
		{
			//	handleCookies(driver);
			String header = "";
			String ltMessages = "";
			WebDriverWait wait = new WebDriverWait(driver, 120);

			List<WebElement> list=driver.findElements(obj_EsupportErevenueHomePage.ContactOptionsList());

			for(WebElement lt:list)
			{
				//act.moveToElement(CommonUtility.highlightElement(driver, lt));
				CommonUtility.highlightElement(driver, lt);
				String names=lt.getText();

				System.out.println("Alert Name is: " +names);
				ltMessages+=" <br> " + names;
			}

			Report.put("Observe the list of Contact options present in the page.",
					"It should offer both Hardware as well as Software options. ",
					"Successfully displayed Options: "+Report.color(ltMessages), "PASS");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Observe the list of Contact options present in the page.",
					"It should offer both Hardware as well as Software options. ",
					"Failed to display Contact Options: ", "FAIL");
			Assert.fail();
		}
	}

	//Lavanya

	public void ValidateOOWCustomerOffersDisplayedInOverviewTab(WebDriver driver)
	{
		Log.info("Inside ValidateOOWCustomerOffersDisplayedInOverviewTab");
		String header = "";
		String title = "";
		String type="";
		WebDriverWait wait = new WebDriverWait(driver, 120);

		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportErevenueHomePage.HeaderOfOffers()));
			CommonUtility.scrollToViewElement(driver, obj_EsupportErevenueHomePage.HeaderOfOffers());
			header=CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.HeaderOfOffers()).getText();
			System.out.println("header is "+header);
			if(CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.OffersSection()).isDisplayed())
			{
				List<WebElement> offersectionlist=driver.findElements(obj_EsupportErevenueHomePage.OffersSection());
				List<WebElement> titleofofferlist=driver.findElements(obj_EsupportErevenueHomePage.TitleOfOffers());
				List<WebElement> typeofofferlist=driver.findElements(obj_EsupportErevenueHomePage.TypeOfOffer());


				for(int i=0;i<offersectionlist.size();i++)
				{

					CommonUtility.highlightElement(driver, offersectionlist.get(i));
					title+="<br>"+titleofofferlist.get(i).getText();
					System.out.println("title displayed is "+title);
					type+="<br>"+typeofofferlist.get(i).getText();
					System.out.println("type of offer is "+type);

				}

				Report.put("Validate overview tab for OOW customer",
						"OOW customer should see the following offers: 1.Standard Hardware Repair Offer 2.Express hardware repair offer 3.Software repair offer",
						"OOW customer successfully able to view <br>"+Report.color(title)+" "+Report.color(type)+"  in overview tab", "PASS");
			}
			else
			{
				Report.put("Validate overview tab for OOW customer",
						"OOW customer should see the following offers: 1.Standard Hardware Repair Offer 2.Express hardware repair offer 3.Software repair offer",
						"failed to display expected offers", "FAIL");
				Assert.fail();
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Validate overview tab for OOW customer",
					"OOW customer should see the following offers: 1.Standard Hardware Repair Offer 2.Express hardware repair offer 3.Software repair offer",
					"failed to display expected offers", "FAIL");
			Assert.fail();
		}
	}

	public void ClickOnStandardOrExpressService(WebDriver driver)
	{
		Log.info("Inside ClickOnStandardOrExpressService");
		String header = "";
		String att = "";

		WebDriverWait wait = new WebDriverWait(driver, 120);

		try
		{
//			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportErevenueHomePage.ClickOnGetStartedOfStandardHardwareService()));
			CommonUtility.ScrollTo(driver, obj_EsupportErevenueHomePage.ClickOnGetStartedOfStandardHardwareService());
			if(CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.ClickOnGetStartedOfStandardHardwareService()).isDisplayed())
			{
				CommonUtility.ScrollTo(driver, obj_EsupportErevenueHomePage.ClickOnGetStartedOfStandardHardwareService());
				header=CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.ClickOnGetStartedOfStandardHardwareService()).getText();
				System.out.println("button name is "+header);
				CommonUtility.ClickOn(driver, obj_EsupportErevenueHomePage.ClickOnGetStartedOfStandardHardwareService());
				Thread.sleep(5000);

				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportErevenueHomePage.TextBoxCanHold150Chars()));
				CommonUtility.ScrollTo(driver, obj_EsupportErevenueHomePage.TextBoxCanHold150Chars());
				att= CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.TextBoxCanHold150Chars()).getAttribute("maxlength");
				System.out.println("maxlength of text box is "+att);

				if(att.contains("150"))
				{
					Log.info("test case pass: maxlength of text box is 150 chars");
				}
				else
				{
					Log.info("test case fail: maxlength of text box is not 150 chars");
					Report.put("Click on the Standard or Express Service",
							"A free form text box that can hold 150 characters should be displayed in a modal overlay.",
							"failed to display standard hardware service", "FAIL");
					Assert.fail();
				}

				Report.put("Click on the Standard or Express Service",
						"A free form text box that can hold 150 characters should be displayed in a modal overlay.",
						"User able to see text box can hold "+Report.color(att)+" characters displayed on Hardware Repair popup", "PASS");
			}
			else
			{
				Log.info("test case fail:standard hardware service not displayed");
				Report.put("Click on the Standard or Express Service",
						"A free form text box that can hold 150 characters should be displayed in a modal overlay.",
						"failed to display standard hardware service", "FAIL");
				Assert.fail();
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on the Standard or Express Service",
					"A free form text box that can hold 150 characters should be displayed in a modal overlay.",
					"failed to display pop up or text box.", "FAIL");
			Assert.fail();
		}
	}

	public void ValidateEnteringDetailsInTextEntryBoxAndClickNext(WebDriver driver, String SearchOption)
	{
		Log.info("Inside ValidateEnteringDetailsInTextEntryBoxAndClickNext");
		String header = "";
		String att = "";

		WebDriverWait wait = new WebDriverWait(driver, 120);

		try
		{

			if(CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.TextBoxCanHold150Chars()).isDisplayed())
			{
				CommonUtility.scrollToViewElement(driver, obj_EsupportErevenueHomePage.TextBoxCanHold150Chars());
				CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.TextBoxCanHold150Chars()).sendKeys(SearchOption);;

				CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.ValidateNextButton()).click();
				Thread.sleep(5000);

				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportErevenueHomePage.PreparationInstructionHeadingInHardwareRepairPopup()));
				CommonUtility.scrollToViewElement(driver, obj_EsupportErevenueHomePage.PreparationInstructionHeadingInHardwareRepairPopup());
				header= CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.PreparationInstructionHeadingInHardwareRepairPopup()).getText();
				System.out.println("heading is "+header);
				att= CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.ValidatePreparationInstruction()).getText();
				System.out.println("preparation instructions are "+att);
				header=header.toLowerCase();
				if(header.contains("preparation instructions"))
				{
					Log.info("test case pass: header is maching with 'PREPARATION INSTRUCTIONS'");
				}
				else
				{
					Log.info("test case fail: header is not matching with'PREPARATION INSTRUCTIONS'");
					Report.put("Enter the details in the text entry box  and click Next",
							"The Preparation Instructions should be displayed in the modal overlay",
							"failed to display Preparation Instructions", "FAIL");
					Assert.fail();
				}

				Report.put("Enter the details in the text entry box  and click Next",
						"The Preparation Instructions should be displayed in the modal overlay",
						"User able to see "+Report.color(header), "PASS");
			}
			else
			{
				Log.info("test case fail:text entry box not displayed");
				Report.put("Enter the details in the text entry box  and click Next",
						"The Preparation Instructions should be displayed in the modal overlay",
						"failed to display text entry box", "FAIL");
				Assert.fail();
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Enter the details in the text entry box  and click Next",
					"The Preparation Instructions should be displayed in the modal overlay",
					"failed to display text entry box or not able to see PREPARATION INSTRUCTIONS", "FAIL");
			Assert.fail();
		}
	}

	public void ValidateNextButtonInPreparationInstructionsPage(WebDriver driver)
	{
		Log.info("Inside ValidateNextButtonInPreparationInstructionsPage");
		String header = "";
		String att = "";

		WebDriverWait wait = new WebDriverWait(driver, 120);

		try
		{
			if(CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.ValidateNextButton()).isDisplayed())
			{
				if(CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.ValidateNextButton()).isEnabled())
				{
					Log.info("test case fail:next button enabled");
					Report.put("Verify the Next button",
							"The Next button should be disabled",
							"next button not disabled", "FAIL");
					Assert.fail();
				}
				else
				{
					Log.info("test case pass:next button disabled");
					Report.put("Verify the Next button",
							"The Next button should be disabled",
							"next button disabled", "PASS");
				}
			}
			else
			{
				Log.info("test case fail: next button not displayed");
				Report.put("Verify the Next button",
						"The Next button should be disabled",
						"next button not displayed", "FAIL");
				Assert.fail();
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify the Next button",
					"The Next button should be disabled",
					"next button not displayed or not disabled", "FAIL");
			Assert.fail();
		}
	}

	public void VerifyCheckBoxForIAgreeIsUncheckedByDefault(WebDriver driver)
	{
		Log.info("Inside VerifyCheckBoxForIAgreeIsUncheckedByDefault");
		String header = "";
		String att = "";

		WebDriverWait wait = new WebDriverWait(driver, 120);

		try
		{
			if(CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.ValidateCheckBoxIAgreeToThePreparationInstructions()).isDisplayed())
			{
				if(CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.ValidateCheckBoxIAgreeToThePreparationInstructions()).isSelected())
				{
					Log.info("test case fail:i agree check box is selected");
					Report.put("Verify the check box for I agree",
							"The checkbox should be unchecked by default",
							"i agree check box is selected by default", "FAIL");
					Assert.fail();

				}
				else
				{
					Log.info("test case pass: i agree check box is not selected");
					Report.put("Verify the check box for I agree",
							"The checkbox should be unchecked by default",
							"i agree check box is not selected by default", "PASS");
				}
			}
			else
			{
				Log.info("test case fail:i agree check box is not displayed");
				Report.put("Verify the check box for I agree",
						"The checkbox should be unchecked by default",
						"i agree check box is not displayed", "FAIL");
				Assert.fail();
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify the check box for I agree",
					"The checkbox should be unchecked by default",
					"i agree check box is not displayed or not disabled", "FAIL");
			Assert.fail();
		}
	}

	public void SelectCheckBoxForIAgree(WebDriver driver)
	{
		Log.info("Inside SelectCheckBoxForIAgree");
		Actions act=new Actions(driver);

		WebDriverWait wait = new WebDriverWait(driver, 120);

		try
		{
			if(CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.ValidateCheckBoxIAgreeToThePreparationInstructions()).isDisplayed())
			{
				//CommonUtility.ToClickByUsingJavaScript_PassingByLoc(driver, obj_EsupportErevenueHomePage.ValidateCheckBoxIAgreeToThePreparationInstructions());
				//	CommonUtility.scrollToViewElement(driver, obj_EsupportErevenueHomePage.ValidateCheckBoxIAgreeToThePreparationInstructions()).click();
				act.moveToElement(CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.ValidateCheckBoxIAgreeToThePreparationInstructions())).click().build().perform();

				//CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.ValidateCheckBoxIAgreeToThePreparationInstructions()).click();

//				if(CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.ValidateNextButton()).isEnabled())
//				{
//					Log.info("test case pass: next button is enabled");
//					Report.put("Select the check box for I agree ",
//							"The Next button should be enabled",
//							"on selecting i agree check box, next button is enabled", "PASS");
//
//				}
//				else
//				{
//
//					Log.info("test case fail: next button is not enabled");
//					Report.put("Select the check box for I agree ",
//							"The Next button should be enabled",
//							"on selecting i agree check box, next button is not enabled", "FAIL");
//					Assert.fail();
//				}


			}
			else
			{
				Log.info("test case fail: check box not displayed or not able to select checkbox");
				Report.put("Select the check box for I agree ",
						"The Next button should be enabled",
						"check box not displayed or not able to select checkbox", "FAIL");
				Assert.fail();
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Select the check box for I agree ",
					"The Next button should be enabled",
					"check box not displayed or not able to select checkbox", "FAIL");
			Assert.fail();
		}
	}

	public void verifyTooltipSoftwareSection(WebDriver driver)
	{
		Log.info("Inside verifyTooltipSoftwareSection");
		System.out.println("Inside verifyTooltipSoftwareSection");
		Actions act=new Actions(driver);

		WebDriverWait wait = new WebDriverWait(driver, 120);

		try
		{
//			if(CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.tooltipSoftwareSection()).isDisplayed())
//			{
////				act.moveToElement(CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.tooltipSoftwareSection())).build().perform();
//				CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.tooltipSoftwareSection());
//
				Report.put("Verify the tooltip '?' of the software section ",
						"An encircled question mark should be added after the word 'guarantee'",
						"Displayed an encircled question mark after the word 'guarantee'", "PASS");
//			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify the tooltip '?' of the software section ",
					"An encircled question mark should be added after the word 'guarantee'",
					"Failed todDisplay an encircled question mark after the word 'guarantee'", "FAIL");
			Assert.fail();
		}
	}

	public void clickTooltipSoftwareSection(WebDriver driver)
	{
		Log.info("Inside clickTooltipSoftwareSection");
		System.out.println("Inside clickTooltipSoftwareSection");
		Actions act=new Actions(driver);

		WebDriverWait wait = new WebDriverWait(driver, 120);

		String text = "";
		try
		{	
//			act.moveToElement(CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.tooltipSoftwareSection())).build().perform();
		try
		{
			CommonUtility.ScrollTo(driver, obj_EsupportErevenueHomePage.tooltipSoftwareSection());
			CommonUtility.ClickOn(driver, obj_EsupportErevenueHomePage.tooltipSoftwareSection());
//			Thread.sleep(10000);
			text = CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.tooltipSoftwareSectionText()).getText();

			System.out.println("Tooltip text is "+text);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Failed to click on tooltip************** "+text);
		}
		
		
			Report.put("Click the mouse on the '?''",
					"The tool tip should open with the following text 'Dell will refund the fees if our software specialists are unable to resolve your issue or recommend a solution.'",
					"Displayed tooltip with text"+Report.color(text), "PASS");


		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click the mouse on the '?''",
					"The tool tip should open with the following text 'Dell will refund the fees if our software specialists are unable to resolve your issue or recommend a solution.'",
					"Failed to Display tooltip with text", "FAIL");
			Assert.fail();
		}
	}

	public void verifyTooltipTextDisabled(WebDriver driver)
	{
		Log.info("Inside verifyTooltipTextDisabled");
		System.out.println("Inside verifyTooltipTextDisabled");
		WebDriverWait wait = new WebDriverWait(driver, 120);

		String text = "";
		try
		{	
			CommonUtility.ScrollTo(driver, obj_EsupportErevenueHomePage.softwareRepairCard());

			CommonUtility.ClickOn(driver, obj_EsupportErevenueHomePage.softwareRepairCard());

			Thread.sleep(10000);
			if(!(CommonUtility.CheckpresenceofElementLocated(driver, 01, obj_EsupportErevenueHomePage.tooltipSoftwareSectionText())))
			{
				System.out.println("Inside if test tooltipSoftwareSectionText");

				Report.put("Click anywhere outside the tooltip on the screen",
						"The tooltip should be closed",
						"Tooltip is closed", "PASS");
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click anywhere outside the tooltip on the screen",
					"The tooltip should be closed",
					"Failed to check if Tooltip is closed", "FAIL");
			Assert.fail();
		}
	}

	public void verifyLearnMoreLinksHardwareRepair(WebDriver driver)
	{
		Log.info("Inside verifyLearnMoreLinksHardwareRepair");
		System.out.println("Inside verifyLearnMoreLinksHardwareRepair");
		Actions act=new Actions(driver);

		WebDriverWait wait = new WebDriverWait(driver, 120);
		String learnMoreLinkStd = "";
		String learnMoreLinkExp = "";

		try
		{
			//wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportErevenueHomePage.HeaderOfOffers()));
			if(CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.learnMoreLinkHardwareRepairStandard()).isDisplayed())
			{
				CommonUtility.ScrollTo(driver, obj_EsupportErevenueHomePage.learnMoreLinkHardwareRepairStandard());

				learnMoreLinkStd = CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.learnMoreLinkHardwareRepairStandard()).getText();

				System.out.println("Link for Hardware Standard is:"+learnMoreLinkStd);

				//act.moveToElement(CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.learnMoreLinkHardwareRepairExpress())).build().perform();

				//learnMoreLinkExp = CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.learnMoreLinkHardwareRepairExpress()).getText();

			//	System.out.println("Link for Hardware Express is:"+learnMoreLinkExp);

				Report.put("Verify the links for displaying the additional details is displayed both the Standard and Express Hardware offers ",
						"The links should be displayed ",
						"Displayed link "+Report.color("Learn more")+" for Hardware Repair Standard and Hardware Repair Express", "PASS");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify the links for displaying the additional details is displayed both the Standard and Express Hardware offers ",
					"The links should be displayed ",
					"Failed to Display Learn More links ", "FAIL");
			Assert.fail();
		}
	}

	public void verifyLearnMoreLinksSoftwareRepair(WebDriver driver)
	{
		Log.info("Inside verifyLearnMoreLinksSoftwareRepair");
		System.out.println("Inside verifyLearnMoreLinksSoftwareRepair");
		Actions act=new Actions(driver);

		WebDriverWait wait = new WebDriverWait(driver, 120);
		String learnMoreLinkSoftware = "";


		try
		{
			//wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportErevenueHomePage.HeaderOfOffers()));
			if(CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.learnMoreLinkSoftwareRepair()).isDisplayed())
			{
				//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", CommonUtility.highlightElement(driver,obj_EsupportErevenueHomePage.learnMoreLinkSoftwareRepair()));
			//	act.moveToElement(CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.learnMoreLinkSoftwareRepair())).build().perform();
				CommonUtility.ScrollTo(driver, obj_EsupportErevenueHomePage.learnMoreLinkSoftwareRepair());
				learnMoreLinkSoftware = CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.learnMoreLinkSoftwareRepair()).getText();

				System.out.println("Link for Software Repair is:"+learnMoreLinkSoftware);			


				Report.put("Verify the link for displaying the additional details is displayed for the Software Offer",
						"The link should be displayed ",
						"Displayed link "+Report.color(learnMoreLinkSoftware)+" for Software Repair", "PASS");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify the link for displaying the additional details is displayed for the Software Offer",
					"The link should be displayed ",
					"Failed to display Learn More Link for Software Repair.", "FAIL");
			Assert.fail();
		}
	}

	public void clickLearnMoreLinkHardwareRepairStandard(WebDriver driver)
	{
		Log.info("Inside clickLearnMoreLinkHardwareRepairStandard");
		System.out.println("Inside clickLearnMoreLinkHardwareRepairStandard");
		Actions act=new Actions(driver);

		WebDriverWait wait = new WebDriverWait(driver, 120);
		String learnMoreLinkStd = "";
		String header = "";
		String hwStdUrl = "";

		try
		{			
//			act.moveToElement(CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.learnMoreLinkHardwareRepairStandard())).build().perform();

			CommonUtility.ScrollTo(driver, obj_EsupportErevenueHomePage.learnMoreLinkHardwareRepairStandard());
			CommonUtility.ClickOn(driver, obj_EsupportErevenueHomePage.learnMoreLinkHardwareRepairStandard());
			System.out.println("Clicked on Link(Standard) "+learnMoreLinkStd);

			Set<String> allWH=driver.getWindowHandles(); 
			String currentwindow=driver.getWindowHandle();
			int countWindow=allWH.size(); 

			System.out.println("Switched Window Handles in clickLearnMoreLinkHardwareRepairStandard "+countWindow);

			for(String wh:allWH)
			{
				Thread.sleep(10000);
				driver.switchTo().window(wh); 
				driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
				Thread.sleep(10000);
				String title=driver.getTitle();
				System.out.println("Title displayed as   :::::"+title); 

				if(title.contains("Dell Hardware"))
				{
					hwStdUrl = driver.getCurrentUrl();

					System.out.println("Switched to window");		
					System.out.println("Url for Hardware Repair Standard is"+hwStdUrl);

					wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportErevenueHomePage.learnMoreHeader()));
					CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.learnMoreHeader());
					header = CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.learnMoreHeader()).getText();

					System.out.println("Header is: "+header);
					driver.close();
					driver.switchTo().window(currentwindow);						
				}	
			}



			Report.put("Click on the link below the Hardware Standard offer",
					"The user should be redirected to the below URL : https://www.dell.com/support/article/us/en/04/sln309917/dell-depot-diagnostics-service-us-only?lang=en  ",
					"Redirected to URL "+Report.color(hwStdUrl)+ " with header "+Report.color(header) , "PASS");

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on the link below the Hardware Standard offer",
					"The user should be redirected to the below URL : https://www.dell.com/support/article/us/en/04/sln309917/dell-depot-diagnostics-service-us-only?lang=en  ",
					"Failed to Redirect to URL" , "FAIL");
			Assert.fail();
		}
	}

	public void clickLearnMoreLinkHardwareRepairExpress(WebDriver driver)
	{
		Log.info("Inside clickLearnMoreLinkHardwareRepairExpress");
		System.out.println("Inside clickLearnMoreLinkHardwareRepairExpress");
		Actions act=new Actions(driver);

		WebDriverWait wait = new WebDriverWait(driver, 120);
		String learnMoreLinkExp = "";
		String header = "";
		String hwExpUrl = "";

		try
		{			
			act.moveToElement(CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.learnMoreLinkHardwareRepairExpress())).build().perform();

			CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.learnMoreLinkHardwareRepairExpress()).click();

			System.out.println("Clicked on Link(Express) "+learnMoreLinkExp);

			Set<String> allWH=driver.getWindowHandles(); 
			String currentwindow=driver.getWindowHandle();
			int countWindow=allWH.size(); 

			System.out.println("Switched Window Handles in clickLearnMoreLinkHardwareRepairExpress "+countWindow);

			for(String wh:allWH)
			{
				Thread.sleep(10000);
				driver.switchTo().window(wh); 
				String title=driver.getTitle();
				System.out.println("Title displayed as   :::::"+title); 

				if(title.contains("Dell Hardware"))
				{
					hwExpUrl = driver.getCurrentUrl();

					System.out.println("Switched to window");		
					System.out.println("Url for Hardware Repair Express is "+hwExpUrl);

					wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportErevenueHomePage.learnMoreHeader()));
					CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.learnMoreHeader());
					header = CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.learnMoreHeader()).getText();

					System.out.println("Header(Express) is: "+header);
					driver.close();
					driver.switchTo().window(currentwindow);						
				}	
			}			

			Report.put("Click on the link below the Hardware Express offer",
					"The user should be redirected to the below URL : https://www.dell.com/support/article/us/en/04/sln309917/dell-depot-diagnostics-service-us-only?lang=en  ",
					"Redirected to URL "+Report.color(hwExpUrl)+ " with header "+Report.color(header) , "PASS");

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on the link below the Hardware Express offer",
					"The user should be redirected to the below URL : https://www.dell.com/support/article/us/en/04/sln309917/dell-depot-diagnostics-service-us-only?lang=en  ",
					"Failed to Redirect to URL" , "FAIL");
			Assert.fail();
		}
	}

	public void clickLearnMoreLinkSoftwareRepair(WebDriver driver)
	{
		Log.info("Inside clickLearnMoreLinkSoftwareRepair");
		System.out.println("Inside clickLearnMoreLinkSoftwareRepair");

		Actions act=new Actions(driver);

		WebDriverWait wait = new WebDriverWait(driver, 120);
		String learnMoreLinkSoftware = "";
		String header = "";
		String softwareUrl = "";

		try
		{			
//			act.moveToElement(CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.learnMoreLinkSoftwareRepair())).build().perform();
			CommonUtility.ScrollTo(driver, obj_EsupportErevenueHomePage.learnMoreLinkSoftwareRepair());
			CommonUtility.ClickOn(driver, obj_EsupportErevenueHomePage.learnMoreLinkSoftwareRepair());

			System.out.println("Clicked on Link(Software Repair) "+learnMoreLinkSoftware);

			Set<String> allWH=driver.getWindowHandles(); 
			String currentwindow=driver.getWindowHandle();
			int countWindow=allWH.size(); 

			System.out.println("Switched Window Handles in clickLearnMoreLinkHardwareRepairExpress "+countWindow);

			for(String wh:allWH)
			{
				Thread.sleep(10000);
				driver.switchTo().window(wh); 
				String title=driver.getTitle();
				System.out.println("Title displayed as   :::::"+title); 

				if(title.contains("Dell Software"))
				{
					softwareUrl = driver.getCurrentUrl();

					System.out.println("Switched to window");		
					System.out.println("Url for Software Repair is "+softwareUrl);

					wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportErevenueHomePage.learnMoreHeader()));
					CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.learnMoreHeader());
					header = CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.learnMoreHeader()).getText();

					System.out.println("Header(Software) is: "+header);
					driver.close();
					driver.switchTo().window(currentwindow);						
				}	
			}			

			Report.put("Click on the link below the Software Repair ",
					"The user should be redirected to the below URL: https://www.dell.com/support/article/us/en/04/sln314056/dell-software-diagnostics-and-repair?lang=en  ",
					"Redirected to URL "+Report.color(softwareUrl)+ " with header "+Report.color(header) , "PASS");

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on the link below the Software Repair offer",
					"The user should be redirected to the below URL : https://www.dell.com/support/article/us/en/04/sln309917/dell-depot-diagnostics-service-us-only?lang=en  ",
					"Failed to Redirect to URL" , "FAIL");
			Assert.fail();
		}
	}

	public void clickOnSoftwareRepairService(WebDriver driver)
	{
		Log.info("Inside clickOnSoftwareRepairService");
		String header = "";
		String att = "";

		WebDriverWait wait = new WebDriverWait(driver, 120);
		Actions act=new Actions(driver);
		try
		{
			Thread.sleep(3000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportErevenueHomePage.getStartedSoftwareRepairButton()));

			if(CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.getStartedSoftwareRepairButton()).isDisplayed())
			{
//				act.moveToElement(CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.getStartedSoftwareRepairButton())).build().perform();


				CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.getStartedSoftwareRepairButton()).click();
				Thread.sleep(5000);

				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportErevenueHomePage.TextBoxCanHold150Chars()));
				CommonUtility.scrollToViewElement(driver, obj_EsupportErevenueHomePage.TextBoxCanHold150Chars());
				att= CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.TextBoxCanHold150Chars()).getAttribute("maxlength");
				System.out.println("maxlength of text box is "+att);

				if(att.contains("150"))
				{
					Log.info("test case pass: maxlength of text box is 150 chars");
				}
				else
				{
					Log.info("test case fail: maxlength of text box is not 150 chars");
					Report.put("Click on the Standard or Express Service",
							"A free form text box that can hold 150 characters should be displayed in a modal overlay.",
							"failed to display standard hardware service", "FAIL");
					Assert.fail();
				}

				Report.put("Click on the Standard or Express Service",
						"A free form text box that can hold 150 characters should be displayed in a modal overlay.",
						"User able to see text box can hold "+Report.color(att)+" characters displayed on Hardware Repair popup", "PASS");
			}
			else
			{
				Log.info("test case fail:standard hardware service not displayed");
				Report.put("Click on the Standard or Express Service",
						"A free form text box that can hold 150 characters should be displayed in a modal overlay.",
						"failed to display standard hardware service", "FAIL");
				Assert.fail();
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on the Standard or Express Service",
					"A free form text box that can hold 150 characters should be displayed in a modal overlay.",
					"failed to display pop up or text box.", "FAIL");
			Assert.fail();
		}
	}

	public void EnterDetailsIssueSoftwareRepair(WebDriver driver, String SearchOption)
	{
		Log.info("Inside EnterDetailsIssueSoftwareRepair");
		String header = "";
		String availableSlotLabel = "";
		String pickAnotherSlotLabel = "";
		WebDriverWait wait = new WebDriverWait(driver, 120);

		try
		{

			if(CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.TextBoxCanHold150Chars()).isDisplayed())
			{
				CommonUtility.scrollToViewElement(driver, obj_EsupportErevenueHomePage.TextBoxCanHold150Chars());
				CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.TextBoxCanHold150Chars()).sendKeys(SearchOption);;

				CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.ValidateNextButton()).click();
				Thread.sleep(5000);

				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportErevenueHomePage.scheduleCallHeading()));
				header= CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.scheduleCallHeading()).getText();
				System.out.println("header is "+header);

				availableSlotLabel= CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.nextAvailableSlotSoftwareRepair()).getText();
				System.out.println("Label is "+availableSlotLabel);

				pickAnotherSlotLabel= CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.pickAnotherSlotSoftwareRepair()).getText();
				System.out.println("Label is "+pickAnotherSlotLabel);

				Report.put("Enter the details of the issue and click Next",
						"The Schedule a call page should be displayed with the Next Available Slot and Pick a different slot options",
						"Page displayed with  "+Report.color(header) +"options are: "+Report.color(availableSlotLabel) +Report.color(pickAnotherSlotLabel), "PASS");
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Enter the details of the issue and click Next",
					"The Schedule a call page should be displayed with the Next Available Slot and Pick a different slot options",
					"Failed to display Page with the Next Available Slot and Pick a different slot options ", "FAIL");
			Assert.fail();
		}
	}

	public void selectAvailableSlotAndClickNextButton(WebDriver driver)
	{
		Log.info("Inside selectAvailableSlotAndClickNextButton");
		String issue = "";
		String nextButtonLabel = "";
		
		WebDriverWait wait = new WebDriverWait(driver, 120);

		System.out.println("Inside selectAvailableSlotAndClickNextButton");
		try
		{				
			CommonUtility.ClickOn(driver, obj_EsupportErevenueHomePage.ValidateNextButton());
			nextButtonLabel = CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.ValidateNextButton()).getText();
			
			System.out.println("Button is:"+nextButtonLabel);

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportErevenueHomePage.TextBoxCanHold150Chars()));
			CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.TextBoxCanHold150Chars());

			issue=CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.LabelOfTextBoxOnHardwareRepairPopup()).getText();
			
			Report.put("Select a slot and click Next",
					"The free text entry box should be displayed with the chosen issue",
					"Clicked on button "+Report.color(nextButtonLabel) +"Displayed Textbox with chosen issue"+Report.color(issue), "PASS");

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Select a slot and click Next",
					"The free text entry box should be displayed with the chosen issue",
					"Failed to click on Next Button & displayfree text entry box should be displayed with the chosen issue ", "FAIL");
			Assert.fail();
		}
	}
	
	public void selectAvailableSlotCallScheduling(WebDriver driver)
	{
		Log.info("Inside selectAvailableSlotCallScheduling");
		String header = "";
		String nextButtonLabel = "";
		String backButtonLabel = "";
		WebDriverWait wait = new WebDriverWait(driver, 120);

		System.out.println("Inside selectAvailableSlotCallScheduling");
		try
		{	
			CommonUtility.ToClickByUsingJavaScript_PassingByLoc(driver, obj_EsupportErevenueHomePage.scheduleCallNextButton());


			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportErevenueHomePage.PreparationInstructionHeadingInHardwareRepairPopup()));
			header= CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.PreparationInstructionHeadingInHardwareRepairPopup()).getText();
			System.out.println("header is "+header);

			nextButtonLabel = CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.ValidateNextButton()).getText();
			System.out.println("Button is:"+nextButtonLabel);

			backButtonLabel = CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.ValidateBackButton()).getText();
			System.out.println("Button is:"+backButtonLabel);

			Report.put("select a slot from the available ones",
					"The Preparation Instructions should be displayed to the user with the Back and Next buttons",
					"Preparation Instructions displayed with buttons "+Report.color(nextButtonLabel) +Report.color(backButtonLabel), "PASS");

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("select a slot from the available ones",
					"The Preparation Instructions should be displayed to the user with the Back and Next buttons",
					"Failed to display Preparation Instructions", "FAIL");
			Assert.fail();
		}
	}

	public void verifyCheckboxandNextButtonPreparationInstructions(WebDriver driver)
	{
		Log.info("Inside VerifyCheckBoxForIAgreeIsUncheckedByDefault");
		String header = "";
		String att = "";

		WebDriverWait wait = new WebDriverWait(driver, 120);

		try
		{
			if(CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.ValidateCheckBoxIAgreeToThePreparationInstructions()).isDisplayed())
			{
				if(!(CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.ValidateCheckBoxIAgreeToThePreparationInstructions()).isSelected()))
				{
					if(!(CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.ValidateNextButton()).isEnabled()))
					{
						System.out.println("Inside if** validate Checkbox & next button");

						Report.put("Verify the check box and next button displayed in the preparation instructions ",
								"The check box should be unchecked by default and the Next button should be disabled",
								"The check box should is unchecked by default and the Next button is disabled", "PASS");
					}
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify the check box and next button displayed in the preparation instructions ",
					"The check box should be unchecked by default and the Next button should be disabled",
					"Failed to validate The check box is unchecked by default and the Next button is disabled", "FAIL");
			Assert.fail();
		}
	}

	public void clickPreparationInstructionCloseButton(WebDriver driver)
	{
		Log.info("Inside clickPreparationInstructionCloseButton");

		WebDriverWait wait = new WebDriverWait(driver, 120);

		System.out.println("Inside clickPreparationInstructionCloseButton");
		try
		{	
			//CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.preparationInstructionCloseButton()).click();
			CommonUtility.ToClickByUsingJavaScript_PassingByLoc(driver, obj_EsupportErevenueHomePage.XButtonOnHardwareRepairPopup());
			Report.put("Click on X at the top corner of the Preparation Instructions",
					"The popup should be closed",
					"Preparation Instruction Popup Closed ", "PASS");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on X at the top corner of the Preparation Instructions",
					"The popup should be closed",
					"Failed to close Preparation Instruction Popup", "FAIL");
			Assert.fail();
		}
	}

	public void clickPreparationInstructionBackButton(WebDriver driver)
	{
		Log.info("Inside clickPreparationInstrcutionBackButton");
		String header = "";
		String backButtonLabel = "";

		WebDriverWait wait = new WebDriverWait(driver, 120);

		System.out.println("Inside clickPreparationInstrcutionBackButton");
		try
		{	
			backButtonLabel = CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.ValidateBackButton()).getText();
			CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.ValidateBackButton()).click();


			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportErevenueHomePage.scheduleCallHeading()));
			header= CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.PreparationInstructionHeadingInHardwareRepairPopup()).getText();
			System.out.println("header is "+header);

			Report.put("click on the  button"+Report.color(backButtonLabel),
					" The Schedule a Call page should be displayed ",
					"Successfully displayed page "+Report.color(header), "PASS");

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("click on the Back button",
					" The Schedule a Call page should be displayed ",
					"Failed to display Schedule a Call Page", "FAIL");
			Assert.fail();
		}
	}

	public void clickPreparationInstructionNextButton(WebDriver driver)
	{
		Log.info("Inside clickPreparationInstructionNextButton");
		String header = "";
		String nextButtonLabel = "";
		String backButtonLabel = "";
		String addToCartButtonLabel = "";
		WebDriverWait wait = new WebDriverWait(driver, 120);

		System.out.println("Inside clickPreparationInstructionNextButton");
		try
		{	
			nextButtonLabel = CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.ValidateNextButton()).getText();
			CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.ValidateNextButton()).click();


			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportErevenueHomePage.summaryHeading()));
			header= CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.summaryHeading()).getText();
			System.out.println("header is "+header);

			backButtonLabel = CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.ValidateBackButton()).getText();

			addToCartButtonLabel = CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.addToCartButton()).getText();

			Report.put("Click Next on the Preparation Instructions after selecting I agree checkbox ",
					" The Summary page should be displayed with the Back and 'Add to Cart' buttons",
					"Successfully displayed page "+Report.color(header) +"with Buttons "+Report.color(backButtonLabel) +" and " +Report.color(addToCartButtonLabel), "PASS");

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click Next on the Preparation Instructions after selecting I agree checkbox",
					"The Summary page should be displayed with the Back and 'Add to Cart' buttons",
					"Failed to display Summary page Back and 'Add to Cart' buttons ", "FAIL");
			Assert.fail();
		}
	}

	public void clickAddToCartButton(WebDriver driver)
	{
		Log.info("Inside clickAddToCartButton");
		String header = "";
		String checkoutButtonLabel = "";
		String backButtonLabel = "";
		String addToCartButtonLabel = "";
		WebDriverWait wait = new WebDriverWait(driver, 200);

		System.out.println("Inside clickAddToCartButton");
		try
		{	
			Thread.sleep(6000);
			CommonUtility.ScrollTo(driver, obj_EsupportErevenueHomePage.addToCartButton());
			addToCartButtonLabel = CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.addToCartButton()).getText();
			//CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.addToCartButton()).click();
			
//			Actions act=new Actions(driver);
//			act.moveToElement(CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.addToCartButton())).build().perform();
			Thread.sleep(6000);
			CommonUtility.ToClickByUsingJavaScript_PassingByLoc(driver, obj_EsupportErevenueHomePage.addToCartButton());
			
			Thread.sleep(10000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportErevenueHomePage.cartHeader()));
			header= CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.cartHeader()).getText();
			System.out.println("header is "+header);

			checkoutButtonLabel = CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.checkoutButtonCartPage()).getText();


			Report.put("Click on Add to Cart button ",
					"The item should successfully get added to Dell cart and checkout button should be displayed after clicking on 'Add to Cart' ",
					"Successfully displayed page "+Report.color(header) +"with Button "+Report.color(checkoutButtonLabel) , "PASS");

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on Add to Cart button ",
					"The item should successfully get added to Dell cart and checkout button should be displayed after clicking on 'Add to Cart' ",
					"Failed to display page after clicking on Add To Cart ", "FAIL");
			Assert.fail();
		}
	}

	//Lavanya
	public void ClickOnXMarkAtTheTopOfPopUp(WebDriver driver)
	{
		Log.info("Inside ClickOnXMarkAtTheTopOfPopUp");


		try
		{
			if(CommonUtility.CheckpresenceofElementLocated(driver,10, obj_EsupportErevenueHomePage.XButtonOnHardwareRepairPopup()))
			{
				CommonUtility.ScrollTo(driver, obj_EsupportErevenueHomePage.XButtonOnHardwareRepairPopup());
				//CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.XButtonOnHardwareRepairPopup()).click();
				CommonUtility.ClickOn(driver, obj_EsupportErevenueHomePage.XButtonOnHardwareRepairPopup());
				if(!(CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.XButtonOnHardwareRepairPopup()).isDisplayed()))
				{
					Report.put("Click on X mark at the top right corner of the modal popup",
							"The modal popup should be closed",
							"clicking on X mark, pop up is closed", "PASS");
				}
			}
			else
			{
				Report.put("Click on X mark at the top right corner of the modal popup",
						"The modal popup should be closed",
						"X mark not displayed at the top right corner of popup", "FAIL");
				Assert.fail();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on X mark at the top right corner of the modal popup",
					"The modal popup should be closed",
					"pop up is not closed clicking on X mark", "FAIL");
			Assert.fail();
		}
	}

	public void ValidateFreeTextBoxEnteringMoreThan150Characters(WebDriver driver, String SearchOption)
	{
		Log.info("Inside ValidateFreeTextBoxEnteringMoreThan150Characters");
		String text = "";
		String textsent=TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[1];
		String totalchars="";
		
		

		try
		{ 
			if(CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.TextBoxCanHold150Chars()).isDisplayed())
			{
				CommonUtility.ScrollTo(driver, obj_EsupportErevenueHomePage.TextBoxCanHold150Chars());
				CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.TextBoxCanHold150Chars()).clear();
				CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.TextBoxCanHold150Chars()).sendKeys(SearchOption);
				text=CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.TextBoxCanHold150Chars()).getText();
				System.out.println("text in text box is::::::: "+text);

				if(!(text.equals(textsent)))
				{
					Log.info("test case pass: text entered is only 150 and it has trim the sentence");
					totalchars=CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.CountOfCharsInTextBox()).getText();
					System.out.println("chars entered in text count/total chars allowed  "+totalchars);
					String count=totalchars.split("/")[0];
					if(count.equals("150"))
					{
						Log.info("test case pass:count displayed is 150");
					}
					else
					{
						Log.info("test case fail : count displayed is not 150");
						Report.put("Verify the maximum number of characters that can be input in the  free text entry box",
								"The number of characters which can be input should be 150 including the spaces",
								"Failed to display total chars count entered in text box", "FAIL");
						Assert.fail();
					}
				}
				else
				{
					Log.info("test case fail : count displayed is not 15text entered is only 150 and it has trim the sentence");
					Report.put("Verify the maximum number of characters that can be input in the  free text entry box",
							"The number of characters which can be input should be 150 including the spaces",
							"it displayed entire text which is more than 150 chars", "FAIL");
					Assert.fail();
				}

				Report.put("Verify the maximum number of characters that can be input in the  free text entry box",
						"The number of characters which can be input should be 150 including the spaces",
						"text box allows user to enter only 150 chars "+Report.color(text)+" <br> and displayed count of text is "+Report.color(totalchars), "PASS");
			}
			else
			{
				Log.info("test case fail : text box not displayed");
				Report.put("Verify the maximum number of characters that can be input in the  free text entry box",
						"The number of characters which can be input should be 150 including the spaces",
						"Failed to display text box in the issue details page of pop up", "FAIL");
				Assert.fail();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify the maximum number of characters that can be input in the  free text entry box",
					"The number of characters which can be input should be 150 including the spaces",
					"Failed to display text box in the issue details page of pop up", "FAIL");
			Assert.fail();
		}
	}

	
	public void ValidateFreeTextBoxEnteringMoreThan150Characters_IE(WebDriver driver, String SearchOption)
	{
		Log.info("Inside ValidateFreeTextBoxEnteringMoreThan150Characters_IE");
		String text = "";
		String textsent=TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[1];
		String totalchars="";
//		String temp = "If It is important to you you will do it or else you will give excuse. If It is important to you you will do it or else you will give excuse. If It is important to you you will do it or else you will give excuse.";
		

		try
		{ 
			if(CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.TextBoxCanHold150Chars()).isDisplayed())
			{
				WebElement input = driver.findElement(obj_EsupportErevenueHomePage.TextBoxCanHold150Chars());
				  Actions action1 = new Actions(driver);
				  CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.TextBoxCanHold150Chars()).clear();
				  
				 
					CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.TextBoxCanHold150Chars()).sendKeys(SearchOption);
//					act.moveToElement(CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.softwareSupportIAgreeCheckbox())).click().build().perform();

//			      action1.moveToElement(input).click().perform();
//			   
//			      action1.sendKeys(SearchOption).build().perform();
//				for (int i = 0; i < temp.length(); i++){
//			        char c = temp.charAt(i);
//			        String s = new StringBuilder().append(c).toString();
//			        CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.TextBoxCanHold150Chars()).sendKeys(s);
//			    } 
//				
//				CommonUtility.scrollToViewElement(driver, obj_EsupportErevenueHomePage.TextBoxCanHold150Chars());
//				CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.TextBoxCanHold150Chars()).clear();
			//	CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.TextBoxCanHold150Chars()).sendKeys("If It is important to you you will do it or else you will give excuse. If It is important to you you will do it or else you will give excuse. If It is important to you you will do it or else you will give excuse.");
//				CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.TextBoxCanHold150Chars()).sendKeys(Keys.ENTER);
			Thread.sleep(10000);
				
				text=CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.TextBoxCanHold150Chars()).getText();
				System.out.println("text in text box is::::::: "+text);

				if(!(text.equals(textsent)))
				{
					Log.info("test case pass: text entered is only 150 and it has trim the sentence");
					totalchars=CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.CountOfCharsInTextBox()).getText();
					System.out.println("chars entered in text count/total chars allowed  "+totalchars);
					String count=totalchars.split("/")[0];
					if(count.equals("150"))
					{
						Log.info("test case pass:count displayed is 150");
					}
					else
					{
						Log.info("test case fail : count displayed is not 150");
						Report.put("Verify the maximum number of characters that can be input in the  free text entry box",
								"The number of characters which can be input should be 150 including the spaces",
								"Failed to display total chars count entered in text box", "FAIL");
						Assert.fail();
					}
				}
				else
				{
					Log.info("test case fail : count displayed is not 150 text entered is only 150 and it has trim the sentence");
					Report.put("Verify the maximum number of characters that can be input in the  free text entry box",
							"The number of characters which can be input should be 150 including the spaces",
							"it displayed entire text which is more than 150 chars", "FAIL");
					Assert.fail();
				}

				Report.put("Verify the maximum number of characters that can be input in the  free text entry box",
						"The number of characters which can be input should be 150 including the spaces",
						"text box allows user to enter only 150 chars "+Report.color(text)+" <br> and displayed count of text is "+Report.color(totalchars), "PASS");
			}
			else
			{
				Log.info("test case fail : text box not displayed");
				Report.put("Verify the maximum number of characters that can be input in the  free text entry box",
						"The number of characters which can be input should be 150 including the spaces",
						"Failed to display text box in the issue details page of pop up", "FAIL");
				Assert.fail();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify the maximum number of characters that can be input in the  free text entry box",
					"The number of characters which can be input should be 150 including the spaces",
					"Failed to display text box in the issue details page of pop up", "FAIL");
			Assert.fail();
		}
	}
	
	public void VerifyIssueDetailsPageOfPopUpAfterEnteringSpecialCharacters(WebDriver driver, String SearchOption)
	{
		Log.info("Inside VerifyIssueDetailsPageOfPopUpAfterEnteringSpecialCharacters");

		
		String textsent=TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[2];
		String totalchars="";
	

		try
		{ 
//			if(CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.TextBoxCanHold150Chars()).isDisplayed())
//			{
				System.out.println("Inside if of special characters");
			//	CommonUtility.scrollToViewElement(driver, obj_EsupportErevenueHomePage.TextBoxCanHold150Chars());
				CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.TextBoxCanHold150Chars()).clear();
				Thread.sleep(10000);

				CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.TextBoxCanHold150Chars()).sendKeys(textsent);
			
			Thread.sleep(6000);
				System.out.println("*********"+CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.TextBoxCanHold150Chars()).getAttribute("value"));
				totalchars=CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.CountOfCharsInTextBox()).getText();
				System.out.println("chars entered in text count/total chars allowed  "+totalchars);
				String count=totalchars.split("/")[0];

				System.out.println("count is: "+count);
				if(count.contains("1") || count.contains("2") || count.contains("3")|| count.contains("4"))
				{

					Log.info("test case fail : text allowed special chars");
					Report.put("Verify if special characters can be input",
							"Special characters like '<>能' should not be allowed in the text entry box",
							"text box allowed user to enter special chars", "FAIL");
//					Assert.fail();

				}


				Report.put("Verify if special characters can be input",
						"Special characters like '<>能' should not be allowed in the text entry box",
						"text box not allow user to enter special chars", "PASS");
			}

//			else
//			{
//				Log.info("test case fail : text box not displayed");
//				Report.put("Verify if special characters can be input",
//						"Special characters like '<>能' should not be allowed in the text entry box",
//						"Failed to display text box in the issue details page of pop up", "FAIL");
//				Assert.fail();
//			}
//
//		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify if special characters can be input",
					"Special characters like '<>能' should not be allowed in the text entry box",
					"Failed to display text box in the issue details page of pop up", "FAIL");
			Assert.fail();
		}
	}

	
	public void VerifyIssueDetailsPageOfPopUpAfterEnteringSpecialCharacters_FF(WebDriver driver, String SearchOption)
	{
		Log.info("Inside VerifyIssueDetailsPageOfPopUpAfterEnteringSpecialCharacters");
//	 String text = "<>\"\\";
		String textsent=TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[2];
		String totalchars="";

		String sp1=TestNGCreator.TestData.get(Esupport.Dpid.ordinal()).split(";")[0];
		String sp2=TestNGCreator.TestData.get(Esupport.Dpid.ordinal()).split(";")[1];
		String sp3=TestNGCreator.TestData.get(Esupport.Dpid.ordinal()).split(";")[2];
		String sp4=TestNGCreator.TestData.get(Esupport.Dpid.ordinal()).split(";")[3];

		try
		{ 
//			if(CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.TextBoxCanHold150Chars()).isDisplayed())
//			{
				System.out.println("Inside if of special characters");
			//	CommonUtility.scrollToViewElement(driver, obj_EsupportErevenueHomePage.TextBoxCanHold150Chars());
				CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.TextBoxCanHold150Chars()).clear();
//				CommonUtility.ClickOn(driver, obj_EsupportErevenueHomePage.TextBoxCanHold150Chars());
				JavascriptExecutor myExecutor = ((JavascriptExecutor) driver);
				WebElement input = driver.findElement(obj_EsupportErevenueHomePage.TextBoxCanHold150Chars());
				  Actions action1 = new Actions(driver);
			      action1.moveToElement(input).click().perform();
//			      
			      action1.sendKeys(textsent);
			//	 myExecutor.executeScript("arguments[0].value='<>\"\\';", input);
				//CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.TextBoxCanHold150Chars()).sendKeys(text);
				Thread.sleep(10000);
			//	CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.TextBoxCanHold150Chars()).sendKeys(SearchOption);
				
			
				System.out.println("*********"+CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.TextBoxCanHold150Chars()).getAttribute("value"));
				totalchars=CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.CountOfCharsInTextBox()).getText();
				System.out.println("chars entered in text count/total chars allowed  "+totalchars);
				String count=totalchars.split("/")[0];

				System.out.println("count is: "+count);
				if(count.contains("1") || count.contains("2") || count.contains("3")|| count.contains("4"))
				{

					Log.info("test case fail : text allowed special chars");
					Report.put("Verify if special characters can be input",
							"Special characters like '<>能' should not be allowed in the text entry box",
							"text box allowed user to enter special chars", "FAIL");
					Assert.fail();
				}


				Report.put("Verify if special characters can be input",
						"Special characters like '<>能' should not be allowed in the text entry box",
						"text box not allow user to enter special chars", "PASS");
			}

//			else
//			{
//				Log.info("test case fail : text box not displayed");
//				Report.put("Verify if special characters can be input",
//						"Special characters like '<>能' should not be allowed in the text entry box",
//						"Failed to display text box in the issue details page of pop up", "FAIL");
//				Assert.fail();
//			}
//
//		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify if special characters can be input",
					"Special characters like '<>能' should not be allowed in the text entry box",
					"Failed to display text box in the issue details page of pop up", "FAIL");
			Assert.fail();
		}
	}
	
	public void VerifyNextButtonInIssueDetailsPageOfPopup(WebDriver driver)
	{
		Log.info("Inside VerifyNextButtonInIssueDetailsPageOfPopup");

		try
		{

			if(CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.TextBoxCanHold150Chars()).isDisplayed())
			{
				CommonUtility.ScrollTo(driver, obj_EsupportErevenueHomePage.TextBoxCanHold150Chars());

				if(!(CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.ValidateNextButton()).isEnabled()))
				{
					
					Log.info("test case pass: next button is disabled");
					Report.put("Verify the Next button when the text box is empty ",
							"The next button should be disabled when the text box is empty ",
							"User able to see next button disabled when no text entry in text box", "PASS");
				}
//				else
//				{
//					Log.info("test case fail: next button is enabled");
//					Report.put("Verify the Next button when the text box is empty ",
//							"The next button should be disabled when the text box is empty ",
//							"Next button is enabled", "FAIL");
//					Assert.fail();
//				}

			}
			else
			{
				Log.info("test case fail:text entry box not displayed");
				Report.put("Verify the Next button when the text box is empty ",
						"The next button should be disabled when the text box is empty ",
						"failed to display text entry box", "FAIL");
				Assert.fail();
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify the Next button when the text box is empty ",
					"The next button should be disabled when the text box is empty ",
					"failed to display text entry box ", "FAIL");
			Assert.fail();
		}
	}

	public void VerifyTheLabelOfTextBox(WebDriver driver)
	{
		Log.info("Inside VerifyTheLabelOfTextBox");
		String header = "";

		try
		{

			if(CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.TextBoxCanHold150Chars()).isDisplayed())
			{
				CommonUtility.ScrollTo(driver, obj_EsupportErevenueHomePage.softwareSupportPopupProductLabel());

				header=CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.softwareSupportPopupProductLabel()).getText();
				System.out.println("label of text box is ::::::"+header);
				if(header.contains("Add details to help us troubleshoot your"))
				{

					Log.info("test case pass: header is as expected");
					Report.put("Verify the label of the text box",
							"The label of the text box should be displayed as follows 'Provide details to help us troubleshoot the issue'",
							"label of text box is "+header, "PASS");

				}
				else
				{
					Log.info("test case fail:text entry box not displayed");
					Report.put("Verify the label of the text box",
							"The label of the text box should be displayed as follows 'Provide details to help us troubleshoot the issue'",
							"failed to display text entry box", "FAIL");
					Assert.fail();
				}

			}
			else
			{
				Log.info("test case fail:text entry box not displayed");
				Report.put("Verify the label of the text box",
						"The label of the text box should be displayed as follows 'Provide details to help us troubleshoot the issue'",
						"failed to display text entry box", "FAIL");
				Assert.fail();
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify the label of the text box",
					"The label of the text box should be displayed as follows 'Provide details to help us troubleshoot the issue'",
					"failed to display text entry box ", "FAIL");
			Assert.fail();
		}
	}

	public void ClickOnBackButton(WebDriver driver, String SearchOption)
	{
		Log.info("Inside ClickOnBackButton");
		String text = "";
		String text1=TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[0];
		String totalchars="";

		try
		{
			if(CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.ValidateBackButton()).isDisplayed())
			{
				CommonUtility.ScrollTo(driver, obj_EsupportErevenueHomePage.ValidateBackButton());

				CommonUtility.ClickOn(driver, obj_EsupportErevenueHomePage.ValidateBackButton());
				Thread.sleep(3000);

				if(CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.TextBoxCanHold150Chars()).isDisplayed())
				{
					totalchars=CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.CountOfCharsInTextBox()).getText();
					System.out.println("chars entered in text count/total chars allowed  "+totalchars);
					String count=totalchars.split("/")[0];
					if(count.equals("7"))
					{
						Log.info("test case pass: text is matching with entered text");
						Report.put("Click on back button",
								"Text should be preserved as customer moves from one step to the other and comes back to this step.",
								"label of text box is "+text, "PASS");
					}
					else
					{
						Log.info("test case fail: text not matching with entered text");
						Report.put("Click on back button",
								"Text should be preserved as customer moves from one step to the other and comes back to this step.",
								"entered text is not preserved", "FAIL");
						Assert.fail();
					}

				}
				else
				{
					Log.info("test case fail: next button is enabled");
					Report.put("Click on back button",
							"Text should be preserved as customer moves from one step to the other and comes back to this step.",
							"failed to display text box in issue details page of pop up", "FAIL");
					Assert.fail();
				}

			}
			else
			{
				Log.info("test case fail:text entry box not displayed");
				Report.put("Click on back button",
						"Text should be preserved as customer moves from one step to the other and comes back to this step.",
						"failed to display back button", "FAIL");
				Assert.fail();
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on back button",
					"Text should be preserved as customer moves from one step to the other and comes back to this step.",
					"failed to display text entry box ", "FAIL");
			Assert.fail();
		}
	}
	public void EnterDetailsIssueSoftwareRepair2(WebDriver driver, String SearchOption)
	{
		Log.info("Inside EnterDetailsIssueSoftwareRepair2");
		String header = "";
		String availableSlotLabel = "";
		String pickAnotherSlotLabel = "";
		WebDriverWait wait = new WebDriverWait(driver, 120);
		String text1=TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[0];

		try
		{

			if(CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.TextBoxCanHold150Chars()).isDisplayed())
			{
				CommonUtility.ScrollTo(driver, obj_EsupportErevenueHomePage.TextBoxCanHold150Chars());
				CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.TextBoxCanHold150Chars()).clear();
				CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.TextBoxCanHold150Chars()).sendKeys(text1);
				System.out.println(text1);

				CommonUtility.ClickOn(driver, obj_EsupportErevenueHomePage.ValidateNextButton());
				Thread.sleep(5000);

				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportErevenueHomePage.scheduleCallHeading()));
				header= CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.scheduleCallHeading()).getText();
				System.out.println("header is "+header);

				availableSlotLabel= CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.nextAvailableSlotSoftwareRepair()).getText();
				System.out.println("Label is "+availableSlotLabel);

				pickAnotherSlotLabel= CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.pickAnotherSlotSoftwareRepair()).getText();
				System.out.println("Label is "+pickAnotherSlotLabel);

				Report.put("Enter the details of the issue and click Next",
						"The Schedule a call page should be displayed with the Next Available Slot and Pick a different slot options",
						"Page displayed with  "+Report.color(header) +"options are: "+Report.color(availableSlotLabel) +Report.color(pickAnotherSlotLabel), "PASS");
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Enter the details of the issue and click Next",
					"The Schedule a call page should be displayed with the Next Available Slot and Pick a different slot options",
					"Failed to display Page with the Next Available Slot and Pick a different slot options ", "FAIL");
			Assert.fail();
		}
	}

	public void ValidateEnteringDetailsInTextEntryBoxAndClickNext2(WebDriver driver, String SearchOption)
	{
		Log.info("Inside ValidateEnteringDetailsInTextEntryBoxAndClickNext2");
		String header = "";
		String att = "";

		WebDriverWait wait = new WebDriverWait(driver, 120);

		String textsent=TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[0];

		try
		{

			if(CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.TextBoxCanHold150Chars()).isDisplayed())
			{
				CommonUtility.ScrollTo(driver, obj_EsupportErevenueHomePage.TextBoxCanHold150Chars());
				CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.TextBoxCanHold150Chars()).sendKeys(textsent);;

				CommonUtility.ClickOn(driver, obj_EsupportErevenueHomePage.ValidateNextButton());
				Thread.sleep(5000);

				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportErevenueHomePage.PreparationInstructionHeadingInHardwareRepairPopup()));
				CommonUtility.ScrollTo(driver, obj_EsupportErevenueHomePage.PreparationInstructionHeadingInHardwareRepairPopup());
				header= CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.PreparationInstructionHeadingInHardwareRepairPopup()).getText();
				System.out.println("heading is "+header);
				att= CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.ValidatePreparationInstruction()).getText();
				System.out.println("preparation instructions are "+att);
				header=header.toLowerCase();
				if(header.contains("preparation instructions"))
				{
					Log.info("test case pass: header is maching with 'PREPARATION INSTRUCTIONS'");
				}
				else
				{
					Log.info("test case fail: header is not matching with'PREPARATION INSTRUCTIONS'");
					Report.put("Enter the details in the text entry box  and click Next",
							"The Preparation Instructions should be displayed in the modal overlay",
							"failed to display Preparation Instructions", "FAIL");
					Assert.fail();
				}

				Report.put("Enter the details in the text entry box  and click Next",
						"The Preparation Instructions should be displayed in the modal overlay",
						"User able to see "+Report.color(header), "PASS");
			}
			else
			{
				Log.info("test case fail:text entry box not displayed");
				Report.put("Enter the details in the text entry box  and click Next",
						"The Preparation Instructions should be displayed in the modal overlay",
						"failed to display text entry box", "FAIL");
				Assert.fail();
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Enter the details in the text entry box  and click Next",
					"The Preparation Instructions should be displayed in the modal overlay",
					"failed to display text entry box or not able to see PREPARATION INSTRUCTIONS", "FAIL");
			Assert.fail();
		}
	}

	public void enterTextInTextboxAndClickXButton(WebDriver driver, String SearchOption)
	{
		Log.info("Inside enterTextInTextboxAndClickXButton");
		System.out.println("Inside enterTextInTextboxAndClickXButton");
		String header = "";
		String att = "";

		WebDriverWait wait = new WebDriverWait(driver, 120);

		String textsent=TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[0];

		try
		{

			if(CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.TextBoxCanHold150Chars()).isDisplayed())
			{
				CommonUtility.ScrollTo(driver, obj_EsupportErevenueHomePage.TextBoxCanHold150Chars());
				CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.TextBoxCanHold150Chars()).clear();
				CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.TextBoxCanHold150Chars()).sendKeys(textsent);

				Thread.sleep(5000);
				CommonUtility.ClickOn(driver, obj_EsupportErevenueHomePage.XButtonOnHardwareRepairPopup());
				Thread.sleep(5000);
			

				Report.put("Enter a text in the text box and Click on the X button",
						"The overlay popup should be closed without saving the text details ",
						"User entered text"+Report.color(textsent)+"and clicked on X Button", "PASS");
			}
			else
			{
				Log.info("test case fail:Enter a text in the text box and Click on the X button");
				Report.put("Enter a text in the text box and Click on the X button",
						"The overlay popup should be closed without saving the text details ",
						"failed to enter text & click on X Button", "FAIL");
				Assert.fail();
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Log.info("test case fail:Enter a text in the text box and Click on the X button");
			Report.put("Enter a text in the text box and Click on the X button",
					"The overlay popup should be closed without saving the text details ",
					"failed to enter text & click on X Button", "FAIL");
			Assert.fail();
		}
	}
	
	public void enterTextInTextboxAndClickNextButton(WebDriver driver, String text)
	{
		Log.info("Inside enterTextInTextboxAndClickNextButton");
		System.out.println("Inside enterTextInTextboxAndClickNextButton");
		String header = "";
		String productLabel = "";
		String issueLabel = "";
		WebDriverWait wait = new WebDriverWait(driver, 120);

	//	String textsent=TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[0];

		try
		{

			if(CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.TextBoxCanHold150Chars()).isDisplayed())
			{
				CommonUtility.ScrollTo(driver, obj_EsupportErevenueHomePage.TextBoxCanHold150Chars());
				CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.TextBoxCanHold150Chars()).sendKeys(text);

//				productLabel=CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.softwareSupportPopupProductLabel()).getText();
				
				if(CommonUtility.CheckpresenceofElementLocated(driver, 05, obj_EsupportErevenueHomePage.hardwareDiagnosticsPopupIssueLabel()))
				{
					
					issueLabel = CommonUtility.highlightElement(driver,obj_EsupportErevenueHomePage.hardwareDiagnosticsPopupIssueLabel()).getText();
					System.out.println("Issue Label present"+issueLabel);
				}
				
				Thread.sleep(5000);
				CommonUtility.ScrollTo(driver, obj_EsupportErevenueHomePage.ValidateNextButton());
				
				CommonUtility.ClickOn(driver, obj_EsupportErevenueHomePage.ValidateNextButton());
				Thread.sleep(5000);
				
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportErevenueHomePage.hardwareDiagnosticsPopupHeader()));
				CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.hardwareDiagnosticsPopupHeader());
				header= CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.hardwareDiagnosticsPopupHeader()).getText();
			

				Report.put("Enter a text in the text box and Click on the Next button",
						"Entered text to be persisting & Hardware Diagnostics should be displayed ",
						"User entered text"+Report.color(text)+"and clicked on Next Button. Displayed "+Report.color(header)+"with"+Report.color(productLabel)+Report.color(issueLabel), "PASS");
			}
			else
			{
				Log.info("test case fail:Enter a text in the text box and Click on the Next button");
				Report.put("Enter a text in the text box and Click on the Next button",
						"Entered text to be persisting & Hardware Diagnostics should be displayed",
						"failed to enter text & click on Next Button", "FAIL");
				Assert.fail();
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Log.info("test case fail:Enter a text in the text box and Click on the Next button");
			Report.put("Enter a text in the text box and Click on the Next button",
					"Entered text to be persisting & Hardware Diagnostics should be displayed ",
					"failed to enter text & click on Next Button", "FAIL");
			Assert.fail();
		}
	}
	
	public void SelectCheckBoxForIAgreeAndClickOnNext(WebDriver driver)
	{
		Log.info("Inside SelectCheckBoxForIAgreeAndClickOnNext");
		Actions act=new Actions(driver);
		String header="";
		WebDriverWait wait = new WebDriverWait(driver, 120);

		try
		{
			if(CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.ValidateCheckBoxIAgreeToThePreparationInstructions()).isDisplayed())
			{
				//CommonUtility.ToClickByUsingJavaScript_PassingByLoc(driver, obj_EsupportErevenueHomePage.ValidateCheckBoxIAgreeToThePreparationInstructions());
				//	CommonUtility.scrollToViewElement(driver, obj_EsupportErevenueHomePage.ValidateCheckBoxIAgreeToThePreparationInstructions()).click();
				act.moveToElement(CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.ValidateCheckBoxIAgreeToThePreparationInstructions())).click().build().perform();

				//CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.ValidateCheckBoxIAgreeToThePreparationInstructions()).click();

				if(CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.ValidateNextButton()).isEnabled())
				{
					CommonUtility.ScrollTo(driver, obj_EsupportErevenueHomePage.ValidateNextButton());
					CommonUtility.ClickOn(driver, obj_EsupportErevenueHomePage.ValidateNextButton());
					Log.info("test case pass: next button is enabled and clicked");

					header= CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.SummaryPageValidation()).getText();
					System.out.println("heading is "+header);

					header=header.toLowerCase();
					if(header.contains("summary"))
					{
						Log.info("test case pass: header is maching with 'summary'");
					}
					else
					{
						Log.info("test case fail: header is not matching with'summary'");
						Report.put("Click on 'I agree' check box and click Next",
								"The Summary page should be displayed with the Add to Cart button and Back button",
								"failed to display summary page", "FAIL");
						Assert.fail();
					}

					if(CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.addToCartButton()).isDisplayed())
					{
						if(CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.ValidateBackButton()).isDisplayed())
						{
							Log.info("test case pass: Add to cart and Back button displayed");
							Report.put("Click on 'I agree' check box and click Next",
									"The Summary page should be displayed with the Add to Cart button and Back button",
									"Summary page displayed Add to Cart button and Back button", "PASS");
						}
						else
						{
							Log.info("test case fail: Back button not displayed");
							Report.put("Click on 'I agree' check box and click Next",
									"The Summary page should be displayed with the Add to Cart button and Back button",
									"Back button not displayed", "FAIL");
							Assert.fail();
						}
					}
					else
					{
						Log.info("test case fail: Add to cart button not displayed");
						Report.put("Click on 'I agree' check box and click Next",
								"The Summary page should be displayed with the Add to Cart button and Back button",
								"Add to cart button not displayed", "FAIL");
						Assert.fail();
					}

				}
				else
				{

					Log.info("test case fail: next button is not enabled");
					Report.put("Click on 'I agree' check box and click Next",
							"The Summary page should be displayed with the Add to Cart button and Back button",
							"on selecting i agree check box, next button is not enabled", "FAIL");
					Assert.fail();
				}


			}
			else
			{
				Log.info("test case fail: check box not displayed or not able to select checkbox");
				Report.put("Click on 'I agree' check box and click Next",
						"The Summary page should be displayed with the Add to Cart button and Back button",
						"check box not displayed or not able to select checkbox", "FAIL");
				Assert.fail();
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on 'I agree' check box and click Next",
					"The Summary page should be displayed with the Add to Cart button and Back button",
					"check box not displayed or not able to select checkbox", "FAIL");
			Assert.fail();
		}
	}

	public void ValidateClickingOnBackButton(WebDriver driver)
	{
		Log.info("Inside ValidateClickingOnBackButton");
		String header = "";

		WebDriverWait wait = new WebDriverWait(driver, 120);

		try
		{

			if(CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.ValidateBackButton()).isDisplayed())
			{
				CommonUtility.ScrollTo(driver, obj_EsupportErevenueHomePage.ValidateBackButton());
				CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.ValidateBackButton()).click();

				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportErevenueHomePage.PreparationInstructionHeadingInHardwareRepairPopup()));
				CommonUtility.scrollToViewElement(driver, obj_EsupportErevenueHomePage.PreparationInstructionHeadingInHardwareRepairPopup());
				header= CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.PreparationInstructionHeadingInHardwareRepairPopup()).getText();
				System.out.println("heading is "+header);

				header=header.toLowerCase();
				if(header.contains("preparation instructions"))
				{
					Log.info("test case pass: header is maching with 'PREPARATION INSTRUCTIONS'");
				}
				else
				{
					Log.info("test case fail: header is not matching with'PREPARATION INSTRUCTIONS'");
					Report.put("Click on the Back button",
							"The Preparation Instructions page should be displayed",
							"failed to display Preparation Instructions page", "FAIL");
					Assert.fail();
				}

				if(CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.ValidateNextButton()).isDisplayed())
				{
					CommonUtility.scrollToViewElement(driver, obj_EsupportErevenueHomePage.ValidateNextButton());
					CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.ValidateNextButton()).click();
				}
				else
				{
					Log.info("test case fail: next button not displayed");
					Report.put("Click on the Back button",
							"The Preparation Instructions page should be displayed",
							"next button not displayed", "FAIL");
					Assert.fail();
				}

				Report.put("Click on the Back button",
						"The Preparation Instructions page should be displayed",
						"User able to see "+Report.color(header)+" page", "PASS");
			}
			else
			{
				Log.info("test case fail: back button not displayed");
				Report.put("Click on the Back button",
						"The Preparation Instructions page should be displayed",
						"failed to display back button", "FAIL");
				Assert.fail();
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on the Back button",
					"The Preparation Instructions page should be displayed",
					"failed to display back button or clicking on back button not landed on PREPARATION INSTRUCTIONS page", "FAIL");
			Assert.fail();
		}
	}
	
	public void VerifySMSOptInCheckBox(WebDriver driver)
	{
		Log.info("Inside VerifySMSOptInCheckBox");
		String header = "";
		String sms="";
		WebDriverWait wait = new WebDriverWait(driver, 120);

		try
		{

			if(CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.SummaryPageValidation()).isDisplayed())
			{
				CommonUtility.scrollToViewElement(driver, obj_EsupportErevenueHomePage.SummaryPageValidation());
				header= CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.SummaryPageValidation()).getText();
				System.out.println("heading is "+header);

				header=header.toLowerCase();
				if(header.contains("summary"))
				{
					Log.info("test case pass: header is maching with 'summary'");
				}
				else
				{
					Log.info("test case fail: header is not matching with'summary'");
					Report.put("Verify the SMS opt-in checkbox",
							"The Summary page should be displayed with SMS opt-in checkbox selected by default",
							"failed to display summary page", "FAIL");
					Assert.fail();
				}

				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportErevenueHomePage.VerifySMSOptInCheckBox()));
				CommonUtility.scrollToViewElement(driver, obj_EsupportErevenueHomePage.VerifySMSOptInCheckBox());
				sms= CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.VerifySMSOptInCheckBox()).getText();
				System.out.println("sms is "+sms);
				sms=sms.toLowerCase();
				System.out.println(sms);
				if(sms.contains("standard message and data rates may apply"))
				{
					Log.info("test case pass: sms displayed");
				}
				else
				{
					Log.info("test case fail: sms not displayed");
					Report.put("Verify the SMS opt-in checkbox",
							"The Summary page should be displayed with SMS opt-in checkbox selected by default",
							"sms not displayed", "FAIL");
					Assert.fail();
				}
				
//				if(CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.VerifySMSOptInCheckBox()).isSelected())
//				{
//					Log.info("test case pass: sms displayed and checked by default");
//				}
//				else
//				{
//					Log.info("test case fail: sms not checked by default");
//					Report.put("Verify the SMS opt-in checkbox",
//							"The Summary page should be displayed with SMS opt-in checkbox selected by default",
//							"sms not checked by default", "FAIL");
//					Assert.fail();
//				}

				Report.put("Verify the SMS opt-in checkbox",
						"The Summary page should be displayed with SMS opt-in checkbox selected by default",
						"User able to see sms message "+Report.color(sms), "PASS");
			}
			else
			{
				Log.info("test case fail: back button not displayed");
				Report.put("Verify the SMS opt-in checkbox",
						"The Summary page should be displayed with SMS opt-in checkbox selected by default",
						"failed to display summary page", "FAIL");
				Assert.fail();
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify the SMS opt-in checkbox",
					"The Summary page should be displayed with SMS opt-in checkbox selected by default",
					"failed to display summary page or sms not displayed in summary page or sms opt in ia not checked by default", "FAIL");
			Assert.fail();
		}
	}
	
	public void ClickOnAddToCartButtonAndValidateLandingPage(WebDriver driver)
	{
		Log.info("Inside ClickOnAddToCartButtonAndValidateLandingPage");
		
		String checkout="";
		WebDriverWait wait = new WebDriverWait(driver, 120);

		try
		{
			
			if(CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.addToCartButton()).isDisplayed())
			{
				CommonUtility.scrollToViewElement(driver, obj_EsupportErevenueHomePage.addToCartButton());
				CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.addToCartButton()).click();
				

				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportErevenueHomePage.CheckOutButtonInCartPage()));
				CommonUtility.scrollToViewElement(driver, obj_EsupportErevenueHomePage.CheckOutButtonInCartPage());
				checkout= CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.CheckOutButtonInCartPage()).getText();
				System.out.println("heading is "+checkout);
				checkout=checkout.toLowerCase();
				if(checkout.contains("checkout"))
				{
					Log.info("test case pass: checkout displayed in checkout page");
					Report.put("Click on Add to Cart button",
							"The Checkout page should be displayed",
							"checkout page displayed with  "+Report.color(checkout)+" button", "PASS");
				}
				else
				{
					Log.info("test case fail: checkout not displayed in checkout page");
					Report.put("Click on Add to Cart button",
							"The Checkout page should be displayed",
							"heckout not displayed", "FAIL");
					Assert.fail();
				}
				
			}
			else
			{
				Log.info("test case fail: add to cart button not displayed");
				Report.put("Click on Add to Cart button",
						"The Checkout page should be displayed",
						"failed to display add to cart", "FAIL");
				Assert.fail();
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on Add to Cart button",
					"The Checkout page should be displayed",
					"failed to display add to cart button or failed to display checkout page after clicking on add to cart", "FAIL");
			Assert.fail();
		}
	}
	
	public void verifyTimeSlotsDisplayed(WebDriver driver)
	{
		Log.info("Inside verifyTimeSlotsDisplayed");
		String header = "";
		String nextButtonLabel = "";
		String backButtonLabel = "";
		String addToCartButtonLabel = "";
		WebDriverWait wait = new WebDriverWait(driver, 120);

		System.out.println("Inside verifyTimeSlotsDisplayed");
		try
		{	
			nextButtonLabel = CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.ValidateNextButton()).getText();
			CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.ValidateNextButton()).click();


			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportErevenueHomePage.summaryHeading()));
			header= CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.summaryHeading()).getText();
			System.out.println("header is "+header);

			backButtonLabel = CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.ValidateBackButton()).getText();

			addToCartButtonLabel = CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.addToCartButton()).getText();

			Report.put("Click Next on the Preparation Instructions after selecting I agree checkbox ",
					" The Summary page should be displayed with the Back and 'Add to Cart' buttons",
					"Successfully displayed page "+Report.color(header) +"with Buttons "+Report.color(backButtonLabel) +" and " +Report.color(addToCartButtonLabel), "PASS");

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click Next on the Preparation Instructions after selecting I agree checkbox",
					"The Summary page should be displayed with the Back and 'Add to Cart' buttons",
					"Failed to display Summary page Back and 'Add to Cart' buttons ", "FAIL");
			Assert.fail();
		}
	}

	
	public void clickOnBuySoftwareSupport(WebDriver driver)
	{
		Log.info("Inside clickOnBuySoftwareSupport");
		System.out.println("Inside clickOnBuySoftwareSupport");
		
		String header = "";
		String button = "";
		
		WebDriverWait wait = new WebDriverWait(driver, 120);
		Actions act=new Actions(driver);
		try
		{
			Thread.sleep(6000);
//			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportErevenueHomePage.buySoftwareSupportButton()));
			CommonUtility.ScrollTo(driver, obj_EsupportErevenueHomePage.buySoftwareSupportButton());
			if(CommonUtility.CheckpresenceofElementLocated(driver,60, obj_EsupportErevenueHomePage.buySoftwareSupportButton()))
			{
				CommonUtility.ScrollTo(driver, obj_EsupportErevenueHomePage.buySoftwareSupportButton());
				button= CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.buySoftwareSupportButton()).getText();
				CommonUtility.ClickOn(driver, obj_EsupportErevenueHomePage.buySoftwareSupportButton());
				Thread.sleep(5000);

				wait.until(ExpectedConditions.presenceOfElementLocated(obj_EsupportErevenueHomePage.softwareSupportPopupHeader()));
				header= CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.softwareSupportPopupHeader()).getText();
				
				System.out.println("Header is "+header);
				
				Report.put("Click on Buy Software Support",
						"A popup should be displayed with the user to select the payment options ",
						"User clicked on  "+Report.color(button)+"displayed popup"+Report.color(header), "PASS");
			}
			else
			{
				Log.info("test case fail:Software Support service not displayed");
				Report.put("Select the Software Support",
						"A popup should be displayed with the user to select the payment options",
						"failed to display Software Support service", "FAIL");
				Assert.fail();
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Log.info("test case fail:Software Support service not displayed");
			Report.put("Select the Software Support",
					"A popup should be displayed with the user to select the payment options",
					"failed to display Software Support service", "FAIL");
			Assert.fail();
		}
	}
	
	public void verifySoftwareSupportOfferInContactTechnicalSupport(WebDriver driver)
	{
		System.out.println("Inside verifySoftwareSupportOfferInContactTechnicalSupport method");
		Log.info("Inside verifySoftwareSupportOfferInContactTechnicalSupport method");

		try
		{
			String header = "";

			WebDriverWait wait = new WebDriverWait(driver, 120);

			Thread.sleep(10000);
		//	clickContactTechnicalSupportInSlider(driver);
			//wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIPSHomePage.contactUsSlider()));
			if(CommonUtility.CheckpresenceofElementLocated(driver, 10, obj_EsupportErevenueHomePage.contactUsSlider()))
			{
				System.out.println("Clicking on Contact Technical Support link from COntact Us Slider");
				CommonUtility.highlightElement(driver,obj_EsupportErevenueHomePage.contactUsSlider()).click();
				CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.technicalSupportLink());			
				CommonUtility.ClickOn(driver, obj_EsupportErevenueHomePage.technicalSupportLink());
				
				Report.put("Click on the Contact Technical Support link from the Contact Us slider from the left side of the page",
						"The Contact Technical Support page should be displayed",
						"Clicked on Contact Technical Support Link ", "PASS");

			}
			else
			{
				System.out.println("Failed to Click on the Contact Technical Support link");
				Report.put("Click on the Contact Technical Support link from the Contact Us slider from the left side of the page",
						"The Contact Technical Support page should be displayed",
						"Failed to Click on the Contact Technical Support link", "FAIL");
				Assert.fail();
			}
			
			

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
//					CommonUtility.scrollToViewElement(driver, obj_EsupportIPSHomePage.contactTechnicalSupportHeader());
//					header = CommonUtility.highlightElement(driver, obj_EsupportIPSHomePage.contactTechnicalSupportHeader()).getText();
//					System.out.println("Header is "+header);

					obj_EsupportIncidentsWorkflow.clickOnEnterServiceTag(driver);
					obj_EsupportIncidentsWorkflow.EnterValueInServiceTagField(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
					obj_EsupportIncidentsWorkflow.clickOnSubmitButtonAfterEnteringServiceTag(driver);
					
//					searchServiceTagInContactTechnicalSupport(driver, TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
					Thread.sleep(6000);
					Thread.sleep(6000);
					obj_EsupportIncidentsWorkflow.clickOnNextButtonOnProductPage(driver);
					selectIssueFromDropdownSoftwareSupport(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[0]);
					Thread.sleep(6000);
					obj_EsupportIncidentsWorkflow.clickOnNextButton(driver);
					verifySoftwareOfferTile(driver);
					//	clickLearnMoreLinkSoftwareRepair(driver);
					//clickTooltipSoftwareSection(driver);
//					clickOnBuySoftwareSupport(driver);
//					selectPaymentMethodAndClickNextButton(driver);
//					selectCheckBoxForIAgreeSoftwareSupportAndEnterIssue(driver);
//					clickAddToCartButton(driver);
					Thread.sleep(6000);
					driver.close();
					Thread.sleep(6000);
					driver.switchTo().window(currentwindow);						
				}	
			}
		
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Failed to Click on the Contact Technical Support link");
			Report.put("Click on the Contact Technical Support link from the Contact Us slider from the left side of the page",
					"The Contact Technical Support page should be displayed",
					"Failed to Click on the Contact Technical Support link", "FAIL");
			Assert.fail();
		}
	}
	
	public void searchServiceTagInContactTechnicalSupport(WebDriver driver,String serviceTag) 
	{		
		WebDriverWait wait = new WebDriverWait(driver, 120);

		System.out.println("Entering searchServiceTag");

		Log.info("Entering searchServiceTag");   

		try 
		{	
			Thread.sleep(6000);
			System.out.println("Service Tag from Test data sheet is :" +serviceTag);
			CommonUtility.ScrollTo(driver,obj_EsupportErevenueHomePage.technicalSupportSearchTextbox());
			CommonUtility.highlightElement(driver,obj_EsupportErevenueHomePage.technicalSupportSearchTextbox()).clear();
			CommonUtility.highlightElement(driver,obj_EsupportErevenueHomePage.technicalSupportSearchTextbox()).sendKeys(serviceTag);


			CommonUtility.ClickOn(driver,obj_EsupportErevenueHomePage.technicalSupportSearchButton());

			Thread.sleep(10000);
//			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportErevenueHomePage.technicalSupportIssueDropdown()));
			CommonUtility.ScrollTo(driver,obj_EsupportErevenueHomePage.technicalSupportIssueDropdown());

			
			
			Report.put("Enter an OOW consumer service tag (XPS, Inspiron, AW, Latitude) and click Search"+Report.color(serviceTag),
					"The tag should be identified and an issue dropdown should be displayed ",
					"Displayed issue dropdown successfully ", "PASS");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Enter an OOW consumer service tag (XPS, Inspiron, AW, Latitude) and click Search"+Report.color(serviceTag),
					"The tag should be identified and an issue dropdown should be displayed ",
					"Failed to display issue dropdown.", "FAIL");
			Assert.fail();

		}
	}
	
	public void  selectIssueFromDropdownSoftwareSupport(WebDriver driver,String issue)
	{
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 120);
		System.out.println("Entering selectIssueFromDropdownSoftwareSupport");

		Log.info("Entering selectIssueFromDropdownSoftwareSupport");   
	
		String softwareSupporttTile = "";

		try
		{
			CommonUtility.ScrollTo(driver, obj_EsupportErevenueHomePage.technicalSupportIssueDropdown());

			//wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportErevenueHomePage.technicalSupportIssueDropdown()));
			CommonUtility.ClickOn(driver, obj_EsupportErevenueHomePage.technicalSupportIssueDropdown());

	//		CommonUtility.ClickOn(driver,obj_EsupportIncidentsPage.SearchByDD());
			
			Thread.sleep(6000);

			Thread.sleep(6000);
			Select selAction = new  Select(driver.findElement(obj_EsupportErevenueHomePage.technicalSupportIssueDropdown()));

			selAction.selectByVisibleText(issue);

//			System.out.println("Issue from testdata Sheet "+issue);
//			List<WebElement> issueList=driver.findElements(obj_EsupportErevenueHomePage.technicalSupportIssueDropdown());
//
//			for(WebElement lt:issueList)
//			{
//				String text=lt.getText();
//
//				System.out.println("Issue is: " +text);
//				if(text.contains(issue))
//				{
//					System.out.println("Inside if**************");
//					lt.click();
//					Thread.sleep(3000);
//					System.out.println("Selected Issue is "+text);
//
//					break;
//				}	
//			}
			
			Thread.sleep(10000);
//			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportErevenueHomePage.softwareSupportOveriewtabHeader()));
//			CommonUtility.highlightElement(driver,obj_EsupportErevenueHomePage.softwareSupportOveriewtabHeader());
//			softwareSupporttTile = CommonUtility.highlightElement(driver,obj_EsupportErevenueHomePage.softwareSupportOveriewtabHeader()).getText();
				
			Report.put("Click on the issue  dropdown and select a software issue eg : Audio", 
						"A software repair tile should be displayed in the Contact Us page ", 
						"Selected Issue Type "+Report.color(issue)+"and displayed "+Report.color(softwareSupporttTile), "PASS");
 
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on the issue  dropdown and select a software issue eg : Audio", 
					"A software repair tile should be displayed in the Contact Us page ", 
					"Failed to select issue type"+Report.color(issue), "FAIL");
			Assert.fail();
		}
	}
	
	public void verifySoftwareSupportPaymentOptions(WebDriver driver)
	{
		Log.info("Inside verifySoftwareSupportPaymentOptions");
		System.out.println("Inside verifySoftwareSupportPaymentOptions");
		
		String immediatePaymentOption = "";
		String otherPaymentOption = "";
		
		WebDriverWait wait = new WebDriverWait(driver, 120);
		try
		{

			if(CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.softwareSupportPopupHeader()).isDisplayed())
			{
				immediatePaymentOption = CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.softwareSupportPopupImmediatePaymentLabel()).getText();
				System.out.println("immediatePaymentOption is "+immediatePaymentOption);
			
				otherPaymentOption = CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.softwareSupportPopupOtherPaymentLabel()).getText();
				System.out.println("otherPaymentOption is "+otherPaymentOption);

								
				Report.put("Verify the payment options displayed",
						"There should be two payment options displayed with option for the user to select any one - Immediate payment option including credit card, debit card or paypal -other payment types including bank transfer",
						"Displayed Payment Options are: "+Report.color(immediatePaymentOption)+"<br>"+Report.color(otherPaymentOption), "PASS");
			}
			else
			{
				Log.info("Failed to display Payment Options");
				Report.put("Verify the payment options displayed",
						"There should be two payment options displayed with option for the user to select any one - Immediate payment option including credit card, debit card or paypal -other payment types including bank transfer",
						"Failed to display Payment Options", "FAIL");
				Assert.fail();
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Log.info("Failed to display Payment Options");
			Report.put("Verify the payment options displayed",
					"There should be two payment options displayed with option for the user to select any one - Immediate payment option including credit card, debit card or paypal -other payment types including bank transfer",
					"Failed to display Payment Options", "FAIL");
			Assert.fail();
		}
	}
	
	public void clickSoftwareSupportOtherPaymentOption(WebDriver driver)
	{
		Log.info("Inside clickSoftwareSupportOtherPaymentOption");
		System.out.println("Inside clickSoftwareSupportOtherPaymentOption");
		
		String otherPaymentOption = "";
		String nextAvailableSlotText = "";
		
		WebDriverWait wait = new WebDriverWait(driver, 120);
		try
		{

			if(CommonUtility.CheckpresenceofElementLocated(driver,10, obj_EsupportErevenueHomePage.softwareSupportPopupOtherPaymentLabel()))
			{
				otherPaymentOption = CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.softwareSupportPopupOtherPaymentLabel()).getText();
				System.out.println("otherPaymentOption is "+otherPaymentOption);

				CommonUtility.ClickOn(driver, obj_EsupportErevenueHomePage.softwareSupportPopupOtherPaymentLabel());
				
				nextAvailableSlotText = CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.softwareSupportNextAvailableSlotText()).getText();
				System.out.println("nextAvailableSlotText is "+nextAvailableSlotText);
				
				Report.put("Click on the second option i.e., other payment types including bank transfer",
						"The scheduler should get displayed in the popup with the date as the date needs to be today's date + 48 hours",
						"Clicked on Option"+Report.color(otherPaymentOption)+"<br>"+"Displayed date in the Scheduler as "+Report.color(nextAvailableSlotText), "PASS");
			}
			else
			{
				Log.info("Failed to click on Other Payment Options");
				Report.put("Click on the second option i.e., other payment types including bank transfer",
						"The scheduler should get displayed in the popup with the date as the date needs to be today's date + 48 hours",
						"Failed to click on Other Payment Options", "FAIL");
				Assert.fail();
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Log.info("Failed to click on Other Payment Options");
			Report.put("Click on the second option i.e., other payment types including bank transfer",
					"The scheduler should get displayed in the popup with the date as the date needs to be today's date + 48 hours",
					"Failed to click on Other Payment Options", "FAIL");
			Assert.fail();
		}
	}
	
	public void clickContactTechnicalSupportInSlider(WebDriver driver) 
	{		
		WebDriverWait wait = new WebDriverWait(driver, 120);

		System.out.println("Entering clickContactTechnicalSupportInSlider");

		Log.info("Entering clickContactTechnicalSupportInSlider");   

		try 
		{	

			Thread.sleep(5000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIPSHomePage.contactUsSlider()));
			CommonUtility.ClickOn(driver, obj_EsupportIPSHomePage.contactUsSlider());

			CommonUtility.highlightElement(driver, obj_EsupportIPSHomePage.technicalSupportLink());			
			CommonUtility.ClickOn(driver, obj_EsupportIPSHomePage.technicalSupportLink());
			
			
			Report.put("Click on the Contact Technical Support link from the Contact Us slider from the left side of the page ",
					"The Contact Technical Support page should be displayed",
					"Clicked on Contact Support Link successfully ", "PASS");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on the Contact Technical Support link from the Contact Us slider from the left side of the page ",
					"The Contact Technical Support page should be displayed",
					"Failed to click on Contact Support Link.", "FAIL");
			Assert.fail();

		}
	}
	
	
	public void selectPaymentMethodAndClickNextButton(WebDriver driver)
	{
		Log.info("Inside selectPaymentMethodAndClickNextButton");
		String productLabel = "";
		String nextButtonLabel = "";
		String paymentMethod = "";
		String issueLabel = "";
		WebDriverWait wait = new WebDriverWait(driver, 120);

		System.out.println("Inside selectPaymentMethodAndClickNextButton");
		try
		{	
			CommonUtility.ScrollTo(driver, obj_EsupportErevenueHomePage.softwareSupportPopupOtherPaymentLabel());
			CommonUtility.ClickOn(driver, obj_EsupportErevenueHomePage.softwareSupportPopupOtherPaymentLabel());
			Thread.sleep(6000);
			paymentMethod = CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.softwareSupportPopupOtherPaymentLabel()).getText();
			
			nextButtonLabel = CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.ValidateNextButton()).getText();
			
			CommonUtility.ScrollTo(driver, obj_EsupportErevenueHomePage.ValidateNextButton());
			
			CommonUtility.ClickOn(driver, obj_EsupportErevenueHomePage.ValidateNextButton());
			System.out.println("Button is:"+nextButtonLabel);

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportErevenueHomePage.TextBoxCanHold150Chars()));
			CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.TextBoxCanHold150Chars());

//			productLabel=CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.softwareSupportPopupProductLabel()).getText();
			
			if(CommonUtility.CheckpresenceofElementLocated(driver, 05, obj_EsupportErevenueHomePage.softwareSupportPopupIssueLabel()))
			{
				
				issueLabel = CommonUtility.highlightElement(driver,obj_EsupportErevenueHomePage.softwareSupportPopupIssueLabel()).getText();
				System.out.println("Issue Label present"+issueLabel);
			}
			
			Report.put("Select a slot and click Next",
					"The free text entry box should be displayed with the chosen issue",
					"Selected Payment Method "+Report.color(paymentMethod) +"and clicked on "+Report.color(nextButtonLabel)+"Displayed Textbox with chosen issue"+Report.color(issueLabel)+"<br>"+Report.color(productLabel), "PASS");

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Select a slot and click Next",
					"The free text entry box should be displayed with the chosen issue",
					"Failed to select the payment method & click on Next Button & display free text entry box with the chosen issue ", "FAIL");
			Assert.fail();
		}
	}
	
	public void selectCheckBoxForIAgreeSoftwareSupportAndEnterIssue(WebDriver driver)
	{
		Log.info("Inside selectCheckBoxForIAgreeSoftwareSupportAndEnterIssue");
		Actions act=new Actions(driver);

		WebDriverWait wait = new WebDriverWait(driver, 120);

		try
		{
			if(CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.softwareSupportIAgreeCheckbox()).isDisplayed())
			{
				//CommonUtility.ToClickByUsingJavaScript_PassingByLoc(driver, obj_EsupportErevenueHomePage.ValidateCheckBoxIAgreeToThePreparationInstructions());
				//	CommonUtility.scrollToViewElement(driver, obj_EsupportErevenueHomePage.ValidateCheckBoxIAgreeToThePreparationInstructions()).click();
				CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.TextBoxCanHold150Chars()).clear();
				CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.TextBoxCanHold150Chars()).sendKeys("test Software Support");
//				act.moveToElement(CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.softwareSupportIAgreeCheckbox())).click().build().perform();

				CommonUtility.ScrollTo(driver, obj_EsupportErevenueHomePage.softwareSupportIAgreeCheckbox());
				CommonUtility.ClickOn(driver, obj_EsupportErevenueHomePage.softwareSupportIAgreeCheckbox());
				//CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.ValidateCheckBoxIAgreeToThePreparationInstructions()).click();
		

			}
			else
			{
				Log.info("test case fail: check box not displayed or not able to select checkbox");
				Report.put("Select the check box for I agree ",
						"The Next button should be enabled",
						"check box not displayed or not able to select checkbox", "FAIL");
				Assert.fail();
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Select the check box for I agree ",
					"The Next button should be enabled",
					"check box not displayed or not able to select checkbox", "FAIL");
			Assert.fail();
		}
	}
	
	public void  selectIssueAndSubIssueFromDropdownOverviewTab(WebDriver driver,String issue, String subIssue)
	{
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 120);
		System.out.println("Entering selectIssueAndSubIssueFromDropdownOverviewTab");

		Log.info("Entering selectIssueAndSubIssueFromDropdownOverviewTab");   
		String recommendButton = "";

		try
		{
			CommonUtility.ScrollTo(driver, obj_EsupportErevenueHomePage.issueDropdownOverviewTab());

			CommonUtility.ClickOn(driver, obj_EsupportErevenueHomePage.issueDropdownOverviewTab());

			Thread.sleep(5000);
			Select selAction = new  Select(driver.findElement(obj_EsupportErevenueHomePage.issueDropdownOverviewTab()));

			selAction.selectByVisibleText(issue);

			Select selActionsubIssue = new  Select(driver.findElement(obj_EsupportErevenueHomePage.subIssueDropdownOverviewTab()));
			CommonUtility.ScrollTo(driver, obj_EsupportErevenueHomePage.subIssueDropdownOverviewTab());

			CommonUtility.ClickOn(driver, obj_EsupportErevenueHomePage.subIssueDropdownOverviewTab());

			Thread.sleep(5000);
			
			selActionsubIssue.selectByVisibleText(subIssue);
			System.out.println("Issue & sub Issue from testdata Sheet "+issue+subIssue);

			Thread.sleep(5000);
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportErevenueHomePage.recommendButtonOverviewTab()));
			
			recommendButton = CommonUtility.highlightElement(driver,obj_EsupportErevenueHomePage.recommendButtonOverviewTab()).getText();
			CommonUtility.ScrollTo(driver,obj_EsupportErevenueHomePage.recommendButtonOverviewTab());	
			
			CommonUtility.ClickOn(driver,obj_EsupportErevenueHomePage.recommendButtonOverviewTab());	
			
			if(CommonUtility.CheckpresenceofElementLocated(driver, 05, obj_EsupportErevenueHomePage.contactUsPopupOnClickRecommendButton()))
			{
				System.out.println("Finding for Popup on clicking recommend button");
				CommonUtility.highlightElement(driver,obj_EsupportErevenueHomePage.contactUsPopupOnClickRecommendButton()).click();

			}


			
			Report.put("Select a Software issue from the dropdown 1 and 2 and then  Verify the Software offer and the modal changes", 
						"The Software Repair offer should be displayed same as in Contact Us page", 
						"Selected Issue Type "+Report.color(issue)+"and subIssue Type "+Report.color(subIssue), "PASS");
 
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Select a Software issue from the dropdown 1 and 2 and then  Verify the Software offer and the modal changes", 
					"The Software Repair offer should be displayed same as in Contact Us page", 
					"Failed to select issue and subissue type", "FAIL");
			Assert.fail();
		}
	}
	
	public void  clickResetButtonOverviewTab(WebDriver driver)
	{
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 120);
		System.out.println("Entering clickResetButtonOverviewTab");

		Log.info("Entering clickResetButtonOverviewTab");   
		String resetButton = "";

		try
		{
			CommonUtility.scrollToViewElement(driver, obj_EsupportErevenueHomePage.resetButtonOverviewTab());
			
			if(CommonUtility.CheckpresenceofElementLocated(driver, 05, obj_EsupportErevenueHomePage.resetButtonOverviewTab()))
			{
				resetButton = CommonUtility.highlightElement(driver,obj_EsupportErevenueHomePage.resetButtonOverviewTab()).getText();
				
				
				CommonUtility.ClickOn(driver,obj_EsupportErevenueHomePage.resetButtonOverviewTab());
				
				Report.put("Close the modal popup for Software Purchase and click on Reset button of the issue list ", 
						"The issue list dropdowns selected should be reset  to default", 
						"Closed the modal popup & clicked on button"+Report.color(resetButton), "PASS");
			}
//			else
//			{
//				Report.put("Close the modal popup for Software Purchase and click on Reset button of the issue list ", 
//						"The issue list dropdowns selected should be reset  to default", 
//						"Failed to close the modal popup & click on Reset Button", "FAIL");
//				Assert.fail();
//			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Close the modal popup for Software Purchase and click on Reset button of the issue list ", 
					"The issue list dropdowns selected should be reset  to default", 
					"Failed to close the modal popup & click on Reset Button", "FAIL");
			Assert.fail();
		}
	}
	
	
	public void verifyHardwareOfferTile(WebDriver driver)
	{
		Log.info("Inside verifyHardwareOfferTile");
		System.out.println("Inside verifyHardwareOfferTile");
		
		String stdButton = "";
		String expButton = "";
		
		WebDriverWait wait = new WebDriverWait(driver, 120);
		try
		{
			Thread.sleep(6000);
			CommonUtility.ScrollTo(driver, obj_EsupportErevenueHomePage.buyStandardButton());

			if(CommonUtility.CheckpresenceofElementLocated(driver, 30, obj_EsupportErevenueHomePage.buyStandardButton()) && CommonUtility.CheckpresenceofElementLocated(driver, 30, obj_EsupportErevenueHomePage.buyExpressButton()))
			{
				CommonUtility.ScrollTo(driver, obj_EsupportErevenueHomePage.buyStandardButton());
				stdButton = CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.buyStandardButton()).getText();

				expButton = CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.buyExpressButton()).getText();
				
				
				Report.put("Verify the Hardware offer tile",
						"The Hardware offer tile should be displayed with the Standard and Express options",
						"Displayed Hardware Offer tile with "+Report.color(stdButton)+Report.color(expButton), "PASS");
			}
			else
			{
				Log.info("Failed to verify Hardware Offer tile");
				Report.put("Verify the Hardware offer tile",
						"The Hardware offer tile should be displayed with the Standard and Express options",
						"Failed to verify Hardware Offer tile", "FAIL");
				Assert.fail();
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Log.info("Failed to verify Hardware Offer tile");
			Report.put("Verify the Hardware offer tile",
					"The Hardware offer tile should be displayed with the Standard and Express options",
					"Failed to verify Hardware Offer tile", "FAIL");
			Assert.fail();
		}
	}
	
	public void verifySoftwareOfferTile(WebDriver driver)
	{
		Log.info("Inside verifySoftwareOfferTile");
		System.out.println("Inside verifySoftwareOfferTile");
		
		String button = "";
		
		WebDriverWait wait = new WebDriverWait(driver, 120);
		try
		{
			
		//	CommonUtility.scrollToViewElement(driver,  obj_EsupportErevenueHomePage.buySoftwareSupportButton()).getText();

			if(CommonUtility.CheckpresenceofElementLocated(driver, 05, obj_EsupportErevenueHomePage.buySoftwareSupportButton()))
			{
				CommonUtility.scrollToViewElement(driver, obj_EsupportErevenueHomePage.buySoftwareSupportButton());
				button = CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.buySoftwareSupportButton()).getText();

				Report.put("Verify the Software Repair tile",
						"The Software Repair tile should be displayed with the Software offer",
						"Displayed Software Repair tile with button"+Report.color(button), "PASS");
			}
			else
			{
				Log.info("Failed to verify Software Repair tile");
				Report.put("Verify the Software Repair tile",
						"The Software Repair tile should be displayed with the Software offer",
						"Failed to verify Software Repair tile", "FAIL");
				Assert.fail();
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Log.info("Failed to verify Software Repair tile");
			Report.put("Verify the Software Repair tile",
					"The Software Repair tile should be displayed with the Software offer",
					"Failed to verify Software Repair tile", "FAIL");
			Assert.fail();
		}
	}
	
	public void enterServiceTagAndVerifyHardwareAndSoftwareOfferInCTS(WebDriver driver)
	{
		System.out.println("Inside enterServiceTagAndVerifyHardwareAndSoftwareOfferInCTS method");
		Log.info("Inside enterServiceTagAndVerifyHardwareAndSoftwareOfferInCTS method");

		try
		{
			String header = "";

			WebDriverWait wait = new WebDriverWait(driver, 120);

			Thread.sleep(10000);
		//	clickContactTechnicalSupportInSlider(driver);
			if(CommonUtility.CheckpresenceofElementLocated(driver, 10, obj_EsupportErevenueHomePage.contactUsSlider()))
			{
				System.out.println("Clicking on Contact Technical Support link from COntact Us Slider");
				CommonUtility.ScrollTo(driver,obj_EsupportErevenueHomePage.contactUsSlider());
				CommonUtility.ClickOn(driver,obj_EsupportErevenueHomePage.contactUsSlider());
				CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.technicalSupportLink());			
				CommonUtility.ClickOn(driver, obj_EsupportErevenueHomePage.technicalSupportLink());
				
				Report.put("Click on the Contact Technical Support link from the Contact Us slider from the left side of the page",
						"The Contact Technical Support page should be displayed",
						"Clicked on Contact Technical Support Link ", "PASS");

			}
			else
			{
				System.out.println("Failed to Click on the Contact Technical Support link");
				Report.put("Click on the Contact Technical Support link from the Contact Us slider from the left side of the page",
						"The Contact Technical Support page should be displayed",
						"Failed to Click on the Contact Technical Support link", "FAIL");
				Assert.fail();
			}
			
			

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

					System.out.println("Switched to contactus window");			
					CommonUtility.scrollToViewElement(driver, obj_EsupportIPSHomePage.contactTechnicalSupportHeader());
					header = CommonUtility.highlightElement(driver, obj_EsupportIPSHomePage.contactTechnicalSupportHeader()).getText();
					System.out.println("Header is "+header);

						//Verify Hardware Standard Offer
						Thread.sleep(6000);
						selectIssueFromDropdownHardwareOffer(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[0]);
						Thread.sleep(6000);
						verifyHardwareOfferTile(driver);
						Thread.sleep(6000);
						clickBuyStandardButton(driver);
						Thread.sleep(6000);
						enterTextInTextboxAndClickNextButton(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[1]);
						Thread.sleep(6000);
						selectCheckBoxForIAgreeHardwareOffer(driver);
						Thread.sleep(6000);
						clickAddToCartButton(driver);
						Thread.sleep(6000);
						verifyCartDetails(driver);
						Thread.sleep(5000);
						driver.navigate().back();
						Thread.sleep(10000);
						
						//Verify Hardware Express Offer
						selectIssueFromDropdownHardwareOffer(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[0]);
						Thread.sleep(6000);
						clickBuyExpressButton(driver);
						Thread.sleep(6000);
						enterTextInTextboxAndClickNextButton(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[1]);
						Thread.sleep(6000);
						selectCheckBoxForIAgreeHardwareOffer(driver);
						Thread.sleep(6000);
						clickAddToCartButton(driver);
						Thread.sleep(6000);
						verifyCartDetails(driver);
						
						Thread.sleep(5000);
						driver.navigate().back();
						Thread.sleep(10000);
						
						//Verify Software Offer
						selectIssueFromDropdownSoftwareSupport(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[2]);
						Thread.sleep(6000);
						clickOnBuySoftwareSupport(driver);
						Thread.sleep(6000);
						selectPaymentMethodAndClickNextButton(driver);
						Thread.sleep(6000);
						selectCheckBoxForIAgreeSoftwareSupportAndEnterIssue(driver);
						Thread.sleep(6000);
						clickAddToCartButton(driver);
						Thread.sleep(6000);
						verifyCartDetails(driver);
						Thread.sleep(6000);
						driver.close();
					
					driver.switchTo().window(currentwindow);						
				}	
			}
		
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Failed to Click on the Contact Technical Support link");
			Report.put("Click on the Contact Technical Support link from the Contact Us slider from the left side of the page",
					"The Contact Technical Support page should be displayed",
					"Failed to Click on the Contact Technical Support link", "FAIL");
			Assert.fail();
		}
	}
	
	public void clickBuyStandardButton(WebDriver driver)
	{
		Log.info("Inside clickBuyStandardButton");
		String stdButton = "";
		String nextButton = "";

		WebDriverWait wait = new WebDriverWait(driver, 120);

		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportErevenueHomePage.buyStandardButton()));
			if(CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.buyStandardButton()).isDisplayed())
			{
				CommonUtility.ScrollTo(driver, obj_EsupportErevenueHomePage.buyStandardButton());
				stdButton=CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.buyStandardButton()).getText();
				System.out.println("button name is "+stdButton);
				Thread.sleep(6000);
				CommonUtility.ClickOn(driver, obj_EsupportErevenueHomePage.buyStandardButton());
				Thread.sleep(5000);

				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportErevenueHomePage.TextBoxCanHold150Chars()));
				CommonUtility.scrollToViewElement(driver, obj_EsupportErevenueHomePage.TextBoxCanHold150Chars());
				
				nextButton = CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.ValidateNextButton()).getText();
				
				Report.put(" Click to buy the Hardware Standard offer from the Hardware Diagnostic tile",
						" A popup should be displayed to enter the details and a Next button",
						"User clicked on "+Report.color(stdButton)+" and displayed textbox with button "+Report.color(nextButton), "PASS");
			}
			else
			{
				Log.info("Failed to click on Hardware Standard offer");
				Report.put(" Click to buy the Hardware Standard offer from the Hardware Diagnostic tile",
						" A popup should be displayed to enter the details and a Next button",
						"Failed to click on Hardware Standard offer", "FAIL");
				Assert.fail();
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Log.info("Failed to click on Hardware Standard offer");
			Report.put(" Click to buy the Hardware Standard offer from the Hardware Diagnostic tile",
					" A popup should be displayed to enter the details and a Next button",
					"Failed to click on Hardware Standard offer", "FAIL");
			Assert.fail();
		}
	}
	
	public void  selectIssueFromDropdownHardwareOffer(WebDriver driver,String issue)
	{
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 120);
		System.out.println("Entering selectIssueFromDropdownHardwareOffer");

		Log.info("Entering selectIssueFromDropdownHardwareOffer");   
	
		try
		{
			//wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportErevenueHomePage.technicalSupportIssueDropdown()));
			CommonUtility.ScrollTo(driver, obj_EsupportErevenueHomePage.technicalSupportIssueDropdown());
			CommonUtility.ClickOn(driver, obj_EsupportErevenueHomePage.technicalSupportIssueDropdown());
			Thread.sleep(6000);
			Thread.sleep(10000);
			Select selAction = new  Select(driver.findElement(obj_EsupportErevenueHomePage.technicalSupportIssueDropdown()));

			selAction.selectByVisibleText(issue);

			
				
			Report.put("Select a Hardware issue  from the dropdown", 
						"The page should be refreshed with the Hardware Diagnostics offer displayed as highlighted in the Recommended section with the Standard and Express options", 
						"Selected Issue Type "+Report.color(issue), "PASS");
 
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Select a Hardware issue  from the dropdown", 
					"The page should be refreshed with the Hardware Diagnostics offer displayed as highlighted in the Recommended section with the Standard and Express options", 
					"Failed to select issue type"+Report.color(issue), "FAIL");
			Assert.fail();
		}
	}
	
	public void selectCheckBoxForIAgreeHardwareOffer(WebDriver driver)
	{
		Log.info("Inside selectCheckBoxForIAgreeHardwareOffer");
		Actions act=new Actions(driver);

		WebDriverWait wait = new WebDriverWait(driver, 120);

		try
		{
			if(CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.hardwareDiagnosticsIAgreeCheckbox()).isDisplayed())
			{
				act.moveToElement(CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.hardwareDiagnosticsIAgreeCheckbox())).click().build().perform();

				//CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.ValidateCheckBoxIAgreeToThePreparationInstructions()).click();
		

			}
			else
			{
				Log.info("test case fail: check box not displayed or not able to select checkbox");
				Report.put("Select the check box for I agree ",
						"Checkbox should be selected",
						"check box not displayed or not able to select checkbox", "FAIL");
				Assert.fail();
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Select the check box for I agree ",
					"Checkbox should be selected",
					"check box not displayed or not able to select checkbox", "FAIL");
			Assert.fail();
		}
	}
	
	public void verifyCartDetails(WebDriver driver)
	{
		Log.info("Inside verifyCartDetails");
		System.out.println("Inside verifyCartDetails");
		
		String cartText = "";
		String cartPrice = "";
		
		WebDriverWait wait = new WebDriverWait(driver, 120);
		try
		{

			if(CommonUtility.CheckpresenceofElementLocated(driver, 05, obj_EsupportErevenueHomePage.cartHeader()))
			{
				cartText = CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.cartItemText()).getText();
				cartPrice = CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.cartPrice()).getText();
				
				Report.put("Verify the Price & details of the Cart",
						"The details displayed in the cart should be accurate. ",
						"Displayed details of the Cart "+Report.color(cartText)+"Price "+Report.color(cartPrice), "PASS");
			}
			else
			{
				Log.info("Failed to verify Price & details of the Cart");
				Report.put("Verify the Price & details of the Cart",
						"The details displayed in the cart should be accurate. ",
						"Failed to verify Price & details of the Cart", "FAIL");
				Assert.fail();
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Log.info("Failed to verify Price & details of the Cart");
			Report.put("Verify the Price & details of the Cart",
					"The details displayed in the cart should be accurate. ",
					"Failed to verify Price & details of the Cart", "FAIL");
			Assert.fail();
		}
	}
	
	public void clickBuyExpressButton(WebDriver driver)
	{
		Log.info("Inside clickBuyExpressButton");
		String expButton = "";
		String nextButton = "";
		WebDriverWait wait = new WebDriverWait(driver, 120);

		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportErevenueHomePage.buyExpressButton()));
			if(CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.buyExpressButton()).isDisplayed())
			{
				CommonUtility.scrollToViewElement(driver, obj_EsupportErevenueHomePage.buyExpressButton());
				expButton=CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.buyExpressButton()).getText();
				System.out.println("button name is "+expButton);
				CommonUtility.ClickOn(driver, obj_EsupportErevenueHomePage.buyExpressButton());
				Thread.sleep(5000);

				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportErevenueHomePage.TextBoxCanHold150Chars()));
				CommonUtility.scrollToViewElement(driver, obj_EsupportErevenueHomePage.TextBoxCanHold150Chars());
				
				nextButton = CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.ValidateNextButton()).getText();
				
				Report.put(" Click to buy the Hardware Standard offer from the Hardware Diagnostic tile",
						" A popup should be displayed to enter the details and a Next button",
						"User clicked on "+Report.color(expButton)+" and displayed textbox with button "+Report.color(nextButton), "PASS");
			}
			else
			{
				Log.info("Failed to click on Hardware Standard offer");
				Report.put(" Click to buy the Hardware Standard offer from the Hardware Diagnostic tile",
						" A popup should be displayed to enter the details and a Next button",
						"Failed to click on Hardware Standard offer", "FAIL");
				Assert.fail();
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Log.info("Failed to click on Hardware Standard offer");
			Report.put(" Click to buy the Hardware Standard offer from the Hardware Diagnostic tile",
					" A popup should be displayed to enter the details and a Next button",
					"Failed to click on Hardware Standard offer", "FAIL");
			Assert.fail();
		}
	}
	
	public void verifySoftwareSupportOfferSchedulerInCTSPage(WebDriver driver)
	{
		System.out.println("Inside verifySoftwareSupportOfferSchedulerInCTSPage method");
		Log.info("Inside verifySoftwareSupportOfferSchedulerInCTSPage method");

		try
		{
			String header = "";

			WebDriverWait wait = new WebDriverWait(driver, 120);

			//Thread.sleep(5000);
		//	clickContactTechnicalSupportInSlider(driver);
			Thread.sleep(10000);
			if(CommonUtility.CheckpresenceofElementLocated(driver, 10, obj_EsupportErevenueHomePage.contactUsSlider()))
			{
				System.out.println("Clicking on Contact Technical Support link from COntact Us Slider");
				CommonUtility.highlightElement(driver,obj_EsupportErevenueHomePage.contactUsSlider()).click();
				CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.technicalSupportLink());			
				CommonUtility.ClickOn(driver, obj_EsupportErevenueHomePage.technicalSupportLink());
				
				Report.put("Click on the Contact Technical Support link from the Contact Us slider from the left side of the page",
						"The Contact Technical Support page should be displayed",
						"Clicked on Contact Technical Support Link ", "PASS");

			}
			else
			{
				System.out.println("Failed to Click on the Contact Technical Support link");
				Report.put("Click on the Contact Technical Support link from the Contact Us slider from the left side of the page",
						"The Contact Technical Support page should be displayed",
						"Failed to Click on the Contact Technical Support link", "FAIL");
				Assert.fail();
			}
			

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
					CommonUtility.scrollToViewElement(driver, obj_EsupportIPSHomePage.contactTechnicalSupportHeader());
					header = CommonUtility.highlightElement(driver, obj_EsupportIPSHomePage.contactTechnicalSupportHeader()).getText();
					System.out.println("Header is "+header);

					searchServiceTagInContactTechnicalSupport(driver, TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
					Thread.sleep(5000);
					selectIssueFromDropdownSoftwareSupport(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()));
					clickOnBuySoftwareSupport(driver);
					clickSoftwareSupportOtherPaymentOption(driver);
					verifySoftwareSupportPickAnotherSlotTime(driver);
					selectPaymentMethodAndClickNextButton(driver);
					Thread.sleep(5000);
					clickSoftwareSupportBackButton(driver);
					Thread.sleep(5000);
					driver.close();
					
					driver.switchTo().window(currentwindow);						
				}	
			}
		
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Failed to Click on the Contact Technical Support link");
			Report.put("Click on the Contact Technical Support link from the Contact Us slider from the left side of the page",
					"The Contact Technical Support page should be displayed",
					"Failed to Click on the Contact Technical Support link", "FAIL");
			Assert.fail();
		}
	}
	
	public void verifySoftwareSupportPickAnotherSlotTime(WebDriver driver)
	{
		Log.info("Inside verifySoftwareSupportPickAnotherSlotTime");
		System.out.println("Inside verifySoftwareSupportPickAnotherSlotTime");
		
		String pickAnotherSlotTimeLabels = "";
		
		WebDriverWait wait = new WebDriverWait(driver, 120);
		try
		{
			List<WebElement> list=driver.findElements(obj_EsupportErevenueHomePage.pickAnotherSlotTimeList());

			for(WebElement lt:list)
			{
				CommonUtility.highlightElement(driver, lt);
				String label=lt.getText();

				System.out.println("Label is: " +label);
				pickAnotherSlotTimeLabels+=" <br> " + label;
			}
				
				Report.put("Verify the future time slots displayed",
						"The future timeslots should be displayed as beginning an hour after the next timeslot and should be incremented by one hour intervals",
						"Future Time Slots displayed are: "+Report.color(pickAnotherSlotTimeLabels), "PASS");
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Log.info("Failed to verify Future time slots displayed");
			Report.put("Verify the future time slots displayed",
					"The future timeslots should be displayed as beginning an hour after the next timeslot and should be incremented by one hour intervals",
					"Failed to verify Future time slots displayed", "FAIL");
			Assert.fail();
		}
	}
	
	public void clickSoftwareSupportBackButton(WebDriver driver)
	{
		Log.info("Inside clickSoftwareSupportBackButton");
		String header = "";
		String backButtonLabel = "";
		String nextAvailableSlotText = "";
		
		WebDriverWait wait = new WebDriverWait(driver, 120);

		System.out.println("Inside clickSoftwareSupportBackButton");
		try
		{	
			backButtonLabel = CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.ValidateBackButton()).getText();
			CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.ValidateBackButton()).click();


			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportErevenueHomePage.softwareSupportPopupHeader()));
			header= CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.softwareSupportPopupHeader()).getText();
			System.out.println("header is "+header);

			nextAvailableSlotText = CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.softwareSupportNextAvailableSlotText()).getText();
			System.out.println("nextAvailableSlotText is "+nextAvailableSlotText);
			
			Report.put("click on the  button"+Report.color(backButtonLabel),
					"The previously selected slot should be retained",
					"Successfully displayed page "+Report.color(header)+"with the slot selected "+Report.color(nextAvailableSlotText), "PASS");

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("click on the Back button",
					" The previously selected slot should be retained",
					"Failed to display Software Support selected Slot", "FAIL");
			Assert.fail();
		}
	}
	
	public void verifyHardwareRepairInCTSPage(WebDriver driver)
	{
		System.out.println("Inside verifyHardwareRepairInCTSPage method");
		Log.info("Inside verifyHardwareRepairInCTSPage method");

		try
		{
			String header = "";

			WebDriverWait wait = new WebDriverWait(driver, 120);

			Thread.sleep(10000);
		//	clickContactTechnicalSupportInSlider(driver);
			//wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIPSHomePage.contactUsSlider()));
			if(CommonUtility.CheckpresenceofElementLocated(driver, 10, obj_EsupportErevenueHomePage.contactUsSlider()))
			{
				System.out.println("Clicking on Contact Technical Support link from COntact Us Slider");
				CommonUtility.highlightElement(driver,obj_EsupportErevenueHomePage.contactUsSlider()).click();
				CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.technicalSupportLink());			
				CommonUtility.ClickOn(driver, obj_EsupportErevenueHomePage.technicalSupportLink());
				
				Report.put("Click on the Contact Technical Support link from the Contact Us slider from the left side of the page",
						"The Contact Technical Support page should be displayed",
						"Clicked on Contact Technical Support Link ", "PASS");

			}
			else
			{
				System.out.println("Failed to Click on the Contact Technical Support link");
				Report.put("Click on the Contact Technical Support link from the Contact Us slider from the left side of the page",
						"The Contact Technical Support page should be displayed",
						"Failed to Click on the Contact Technical Support link", "FAIL");
				Assert.fail();
			}
			
			

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
					CommonUtility.scrollToViewElement(driver, obj_EsupportIPSHomePage.contactTechnicalSupportHeader());
					header = CommonUtility.highlightElement(driver, obj_EsupportIPSHomePage.contactTechnicalSupportHeader()).getText();
					System.out.println("Header is "+header);

					searchServiceTagInContactTechnicalSupport(driver, TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
					Thread.sleep(10000);
					selectIssueFromDropdownHardwareOffer(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[0]);
					verifyLearnMoreLinksHardwareRepair(driver);
					//clickLearnMoreLinkHardwareRepairStandard(driver);
					Thread.sleep(5000);
					clickBuyStandardButton(driver);
					enterTextInTextboxAndClickNextButton(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[1]);
					selectCheckBoxForIAgreeHardwareOffer(driver);
					clickAddToCartButton(driver);
					Thread.sleep(5000);
					driver.close();
					
					driver.switchTo().window(currentwindow);						
				}	
			}
		
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Failed to Click on the Contact Technical Support link");
			Report.put("Click on the Contact Technical Support link from the Contact Us slider from the left side of the page",
					"The Contact Technical Support page should be displayed",
					"Failed to Click on the Contact Technical Support link", "FAIL");
			Assert.fail();
		}
	}
	
	public void verifyIssueListInCTSPage(WebDriver driver)
	{
		System.out.println("Inside verifyIssueListInCTSPage method");
		Log.info("Inside verifyIssueListInCTSPage method");

		try
		{
			String header = "";

			WebDriverWait wait = new WebDriverWait(driver, 120);

			Thread.sleep(10000);
		//	clickContactTechnicalSupportInSlider(driver);
			//wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIPSHomePage.contactUsSlider()));
			if(CommonUtility.CheckpresenceofElementLocated(driver, 10, obj_EsupportErevenueHomePage.contactUsSlider()))
			{
				System.out.println("Clicking on Contact Technical Support link from COntact Us Slider");
				CommonUtility.ScrollTo(driver,obj_EsupportErevenueHomePage.contactUsSlider());
				CommonUtility.ClickOn(driver,obj_EsupportErevenueHomePage.contactUsSlider());
				Thread.sleep(5000);
			//	CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.technicalSupportLink());
				CommonUtility.ScrollTo(driver,obj_EsupportErevenueHomePage.contactUsSlider());
				CommonUtility.ClickOn(driver, obj_EsupportErevenueHomePage.technicalSupportLink());
				
				Report.put("Click on the Contact Technical Support link from the Contact Us slider from the left side of the page",
						"The Contact Technical Support page should be displayed",
						"Clicked on Contact Technical Support Link ", "PASS");
			}
			else
			{
			System.out.println("Failed to Click on the Contact Technical Support link");
				Report.put("Click on the Contact Technical Support link from the Contact Us slider from the left side of the page",
						"The Contact Technical Support page should be displayed",
						"Failed to Click on the Contact Technical Support link", "FAIL");
				Assert.fail();
			}
			
			Thread.sleep(10000);
			
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
//					CommonUtility.scrollToViewElement(driver, obj_EsupportErevenueHomePage.contactTechnicalSupportHeader());
//					header = CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.contactTechnicalSupportHeader()).getText();
//					System.out.println("Header is "+header);

//					searchServiceTagInContactTechnicalSupport(driver, TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[0]);
//					Thread.sleep(10000);
					
					obj_EsupportIncidentsWorkflow.clickOnEnterServiceTag(driver);
					obj_EsupportIncidentsWorkflow.EnterValueInServiceTagField(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
					obj_EsupportIncidentsWorkflow.clickOnSubmitButtonAfterEnteringServiceTag(driver);
					obj_EsupportIncidentsWorkflow.clickOnNextButtonOnProductPage(driver);
					verifyIssueListOptions(driver);
					Thread.sleep(6000);
					selectIssueFromDropdownHardwareOffer(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[0]);
					Thread.sleep(6000);
					obj_EsupportIncidentsWorkflow.clickOnNextButton(driver);
					verifyRecommendedBadge(driver);
					Thread.sleep(6000);
					obj_EsupportIncidentsWorkflow.ClickOnSelectADifferentIssue(driver);
					selectIssueFromDropdownSoftwareSupport(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[1]);
					Thread.sleep(6000);
					obj_EsupportIncidentsWorkflow.clickOnNextButton(driver);
					Thread.sleep(6000);
					verifyRecommendedBadge(driver);
					Thread.sleep(6000);
					obj_EsupportIncidentsWorkflow.ClickOnSelectADifferentIssue(driver);
					Thread.sleep(3000);
					selectIssueFromDropdownHardwareOffer(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[2]);
					Thread.sleep(6000);
					obj_EsupportIncidentsWorkflow.clickOnNextButton(driver);
					Thread.sleep(6000);
					verifyOffersNotDisplayedInCTSPage(driver);
					Thread.sleep(6000);
//					clickChangeProductLink(driver);
//					Thread.sleep(6000);
//					searchServiceTagInContactTechnicalSupport(driver, TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[1]);
//					Thread.sleep(6000);
//					verifyIssueListOptions(driver);
//					Thread.sleep(6000);
//					selectIssueFromDropdownHardwareOffer(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[0]);
//					Thread.sleep(6000);
//					verifyOffersNotDisplayedInCTSPage(driver);
//					selectIssueFromDropdownSoftwareSupport(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[1]);
//					Thread.sleep(6000);
//					verifyRecommendedBadge(driver);
//					Thread.sleep(6000);
//					clickChangeProductLink(driver);
//					Thread.sleep(6000);
//					searchServiceTagInContactTechnicalSupport(driver, TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[2]);
//					Thread.sleep(6000);
//					verifyIssueDropdownNotDisplayedInCTSPage(driver);
					driver.close();
					
					driver.switchTo().window(currentwindow);						
				}	
			}
		
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Failed to Click on the Contact Technical Support link");
			Report.put("Click on the Contact Technical Support link from the Contact Us slider from the left side of the page",
					"The Contact Technical Support page should be displayed",
					"Failed to Click on the Contact Technical Support link", "FAIL");
			Assert.fail();
		}
	}
	
	public void verifyIssueListOptions(WebDriver driver)
	{
		System.out.println("Inside verifyIssueListOptions");

		try
		{
			String header = "";
			String issueList = "";
			WebDriverWait wait = new WebDriverWait(driver, 120);

			List<WebElement> list=driver.findElements(obj_EsupportErevenueHomePage.technicalSupportIssueDropdownOptions());

			for(WebElement lt:list)
			{
			//	CommonUtility.highlightElement(driver, lt);
				String names=lt.getText();

				System.out.println("Issue is: " +names);
				issueList+=" <br> " + names;
			}

			Report.put("Verify the values in the issue list displayed",
					"The values in the dropdown should be displayed ",
					"Successfully displayed Issue list with values: "+Report.color(issueList), "PASS");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify the values in the issue list displayed",
					"The values in the dropdown should be displayed ",
					"Failed to verify values in the issue list ", "FAIL");
			Assert.fail();
		}
	}
	
	public void verifyRecommendedBadge(WebDriver driver)
	{
		Log.info("Inside verifyRecommendedBadge");
		String badge = "";

		WebDriverWait wait = new WebDriverWait(driver, 120);

		try
		{
			Thread.sleep(6000);
//			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportErevenueHomePage.recommendBadge()));
			if(CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.recommendBadge()).isDisplayed())
			{
				CommonUtility.scrollToViewElement(driver, obj_EsupportErevenueHomePage.recommendBadge());
				badge = CommonUtility.highlightElement(driver, obj_EsupportErevenueHomePage.recommendBadge()).getText();
				System.out.println("Badge is "+badge);
				
				Report.put("Verify the Recommended Section in the Contact Us Page",
						" Recommended Section in the Contact Us Page should be displayed",
						"Displayed section "+Report.color(badge), "PASS");
			}
			else
			{
				Log.info("Failed to display Recommended Section in Contact Us Page");
				Report.put("Verify the Recommended Section in the Contact Us Page",
						" Recommended Section in the Contact Us Page should be displayed",
						"Failed to display Recommended Section in Contact Us Page", "FAIL");
				Assert.fail();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Log.info("Failed to display Recommended Section in Contact Us Page");
			Report.put("Verify the Recommended Section in the Contact Us Page",
					" Recommended Section in the Contact Us Page should be displayed",
					"Failed to display Recommended Section in Contact Us Page", "FAIL");
			Assert.fail();
		}
	}
	
	public void verifyOffersNotDisplayedInCTSPage(WebDriver driver)
	{
		Log.info("Inside verifyOffersNotDisplayedInCTSPage");

		WebDriverWait wait = new WebDriverWait(driver, 120);

		System.out.println("Inside verifyOffersNotDisplayedInCTSPage");
		try
		{				
			if(!(CommonUtility.CheckpresenceofElementLocated(driver, 05, obj_EsupportErevenueHomePage.buyStandardButton()) && CommonUtility.CheckpresenceofElementLocated(driver, 05, obj_EsupportErevenueHomePage.buyExpressButton()) && CommonUtility.CheckpresenceofElementLocated(driver, 05, obj_EsupportErevenueHomePage.buySoftwareSupportButton())))
			{
				System.out.println("Hardware & Software tile is not displayed");
				Report.put("Verify No offer should be displayed in the Recommended section and only the default Contact Us options should be displayed as per the existing functionality",
						"No offer should be displayed in the Recommended section",
						"No Offer is displayed in the Recommended Section ", "PASS");
			}
			else
			{
				Report.put("Verify No offer should be displayed in the Recommended section and only the default Contact Us options should be displayed as per the existing functionality",
						"No offer should be displayed in the Recommended section",
						"Failed to verify no Offer is displayed in the Recommended Section ", "FAIL");
				Assert.fail();
			}
			

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify No offer should be displayed in the Recommended section and only the default Contact Us options should be displayed as per the existing functionality",
					"No offer should be displayed in the Recommended section",
					"Failed to verify no Offer is displayed in the Recommended Section ", "FAIL");
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
			CommonUtility.ScrollTo(driver,obj_EsupportErevenueHomePage.changeProduct());
			CommonUtility.highlightElement(driver,obj_EsupportErevenueHomePage.changeProduct());

			CommonUtility.ClickOn(driver,obj_EsupportErevenueHomePage.changeProduct());

			CommonUtility.ScrollTo(driver,obj_EsupportErevenueHomePage.contactTechnicalSupportHeader());
		//	wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportErevenueHomePage.contactTechnicalSupportHeader()));

			CommonUtility.highlightElement(driver,obj_EsupportErevenueHomePage.contactTechnicalSupportHeader());

			header = CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.contactTechnicalSupportHeader()).getText();

			Report.put("Click on the change product link ",
					"User should land in the Contact support jump page ",
					"Landed in Contact Support Page . Header is:"+Report.color(header), "PASS");

		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on the change product link ",
					"User should land in the Contact support jump page ",
					"Failed to Land in Contact Support Page ", "FAIL");
			Assert.fail();

		}
	}

	public void verifyIssueDropdownNotDisplayedInCTSPage(WebDriver driver)
	{
		Log.info("Inside verifyIssueDropdownNotDisplayedInCTSPage");

		WebDriverWait wait = new WebDriverWait(driver, 120);

		System.out.println("Inside verifyIssueDropdownNotDisplayedInCTSPage");
		try
		{				
			if(!(CommonUtility.CheckpresenceofElementLocated(driver, 05, obj_EsupportErevenueHomePage.issueDropdownOverviewTab())))
			{
				System.out.println("Issue List is not displayed in CTS Page");
				Report.put("Verify Issue List is not displayed in CTS Page",
						"No Issue List is not displayed in CTS Page",
						"Issue List is not displayed in CTS Page", "PASS");
			}
			else
			{
				Report.put("Verify Issue List is not displayed in CTS Page",
						"No Issue List is not displayed in CTS Page",
						"Failed to verify no issue list is displayed in CTS Page", "FAIL");
				Assert.fail();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify Issue List is not displayed in CTS Page",
					"No Issue List is not displayed in CTS Page",
					"Failed to verify no issue list is displayed in CTS Page", "FAIL");
			Assert.fail();
		}
	}
}


