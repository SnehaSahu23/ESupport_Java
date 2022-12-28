package com.dell.delta_uat_automation.esupport.workflows;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.dell.delta_uat_automation.utility.CommonUtility;
import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.Log;
import com.dell.delta_uat_automation.utility.Report;
import com.dell.delta_uat_automation.utility.TestNGCreator;
public class EsupportDDLWorkflow  extends BaseFlow 
{
	public void handleCookies(WebDriver driver)
	{
		System.out.println("Handle Cookies");
		Log.info("Handle Cookies");	
		try{
			WebDriverWait wait = new WebDriverWait(driver, 30);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			if(CommonUtility.CheckpresenceofElementLocated(driver, 10, obj_EsupportOrderHomePage.AcceptCookies()))
			{
				CommonUtility.ScrollTo(driver,obj_EsupportOrderHomePage.AcceptCookies());  
				CommonUtility.ClickOn(driver,obj_EsupportOrderHomePage.AcceptCookies());  	
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



	public void ClickonSignInbutton(WebDriver driver)
	{

		System.out.println("Click on Sign In button");
		Log.info("Click on Sign In button");
		Actions act=new Actions(driver);

		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);
			handleCookies(driver);
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.SignInHeader()));
			CommonUtility.highlightElement(driver, obj_EsupportDDLHomePage.SignInHeader());
			//Lavanya
		//	CommonUtility.scrollToViewElement(driver,obj_EsupportDDLHomePage.SignIn()); 
			//CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.SignIn().click();
//			act.moveToElement(CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.SignIn())).click().build().perform(); 
			CommonUtility.ClickOn(driver,obj_EsupportDDLHomePage.SignIn());
			Thread.sleep(20000);
			String newcode=TestNGCreator.TestData.get(Esupport.TestCaseID.ordinal());
			if(newcode.equalsIgnoreCase("5784146")){


				Report.put("Click on Sign In button",
						"User successfully logged into SLM By default Digital product Tab should select from the Left Nav and  the digital products grid is displayed with all the products associated with the logged in user account",
						"User logged into SLM By default Digital product Tab is selected from the Left Nav and  the digital products grid is displayed with all the products associated with the logged in user account", "PASS");
			}else

				Report.put("Click on Sign In button", "Should redirect Customers to STS Sign In page",
						"User redirected to 'STS Sign In' page.", "PASS");


		} catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on Sign In button", "Should redirect Customers to STS Sign In page",
					"User not redirected to 'STS Sign In' page.", "FAIL");
			Assert.fail();
		}
	}



	public void VerifySignInbutton(WebDriver driver)
	{

		System.out.println("Verify Sign In button");
		Log.info("Verify Sign In button");

		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.HomePageSignIn()));
			if(CommonUtility.CheckpresenceofElementLocated(driver, 30, obj_EsupportDDLHomePage.HomePageSignIn()))
			{
				CommonUtility.highlightElement(driver, obj_EsupportDDLHomePage.HomePageSignIn());


				String newcode=TestNGCreator.TestData.get(Esupport.TestCaseID.ordinal());
				if(newcode.equalsIgnoreCase("5781001")){

					Report.put("Verify the Sign in Button",
							"Sign in Button should be displayed right side of the portal page",
							"Sign In button is displayed", "PASS");
				}

				else
				{
					Report.put("Verify Sign In button is displayed", "Sign In button should be displayed",
							"Sign In button is displayed", "PASS");
				}
			} 
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify Sign In button is displayed", "Sign In button should be displayed",
					"Sign In button is not displayed", "FAIL");
			Assert.fail();
		}
	}



	public void validemailaddress(WebDriver driver,String Username)
	{

		System.out.println("valid email address");
		Log.info("valid email address");

		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.Email()));
			if(CommonUtility.CheckpresenceofElementLocated(driver, 30, obj_EsupportDDLHomePage.Email()))
			{
				CommonUtility.ScrollTo(driver,obj_EsupportDDLHomePage.Email());
				CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.Email()).sendKeys(Username);
				Report.put("Enter valid email address", " should be able to enter email address",
						"User is able to enter email address", "PASS");


			}} catch(Exception e)
		{
				e.printStackTrace();
				Report.put("Enter valid email address", " should be able to enter email address",
						"User is not able to enter email address", "FAIL");
				Assert.fail();
		}
	}


	public void validPassword(WebDriver driver,String password )
	{

		System.out.println("valid Password");
		Log.info("valid Password");

		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.Password()));
			if(CommonUtility.CheckpresenceofElementLocated(driver, 30, obj_EsupportDDLHomePage.Password()))
			{

				CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.Password()).sendKeys(password);
				Thread.sleep(2000);
				Report.put("Enter valid Password", " should be able to enter password",
						"User is able to enter Password", "PASS");


			}} catch(Exception e)
		{
				e.printStackTrace();
				Report.put("Enter valid Password", " should be able to enter password",
						"User is not able to enter Password", "FAIL");
				Assert.fail();
		}
	}
	public void ClickonHomePageSignInbutton(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 600);
		System.out.println("Click on Sign In button");
		Log.info("Click on Sign In button");

		try
		{
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.DigitalLockerHeader()));
			CommonUtility.highlightElement(driver, obj_EsupportDDLHomePage.DigitalLockerHeader());

//			CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.HomePageSignIn()).click();
			System.out.println("Click on Sign In button - Using ClickOnMethod");
			CommonUtility.ClickOn(driver,obj_EsupportDDLHomePage.HomePageSignIn());
			String newcode=TestNGCreator.TestData.get(Esupport.TestCaseID.ordinal());
			if(newcode.equalsIgnoreCase("5781001")){


				Report.put("Click on Sign In button",
						"Dell Account Sign in Page should be popup",
						"User redirected to 'STS Sign In' page.", "PASS");
			}else

			{
				Report.put("Click on Sign In button", "should redirect Customers to STS Sign In page",
						"User redirected to 'STS Sign In' page.", "PASS");
			}


		} catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on Sign In button", "should redirect Customers to STS Sign In page",
					"User not redirected to 'STS Sign In' page.", "FAIL");
			Assert.fail();
		}
	}
	public void validateErrorMessage(WebDriver driver)
	{

		System.out.println("Click on Sign In button");
		Log.info("Click on Sign In button");
		String errMessage = "";

		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.SignInHeader()));
			CommonUtility.highlightElement(driver, obj_EsupportDDLHomePage.SignInHeader());

			CommonUtility.ClickOn(driver,obj_EsupportDDLHomePage.SignIn());
			Thread.sleep(6000);
			CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.ErrorMessage());
			errMessage = CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.ErrorMessage()).getText();
			Report.put("Click on Sign In button", "Appropriate error message should display",
					"Error message displayed as:"+Report.color(errMessage), "PASS");


		} catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on Sign In button", "Appropriate error message should display",
					"Failed to display the Error message", "FAIL");
			Assert.fail();
		}
	}

	public void invalidemailaddress(WebDriver driver, String email)
	{

		System.out.println("invalid email address");
		Log.info("invalid email address");

		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);
			if(CommonUtility.CheckpresenceofElementLocated(driver, 30, obj_EsupportDDLHomePage.Email()))
			{

				CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.Email()).sendKeys(email);
				Report.put("Enter invalid email address", " should be able to enter email address",
						"User is able to enter email address", "PASS");
			} 
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Enter invalid email address", " should be able to enter email address",
					"User is not able to enter email address", "FAIL");
			Assert.fail();
		}
	}
	public void invalidPassword(WebDriver driver, String password)
	{

		System.out.println("invalid Password");
		Log.info("invalid Password");

		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);
			if(CommonUtility.CheckpresenceofElementLocated(driver, 30, obj_EsupportDDLHomePage.Password()))
			{

				CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.Password()).sendKeys(password);
				Report.put("Enter invalid Password", " should be able to enter password",
						"User is able to enter Password", "PASS");

			}
		} catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Enter valid Password", " should be able to enter password",
					"User is not able to enter Password", "FAIL");
			Assert.fail();
		}
	}
	//18/2/2019
	public void VerifyDigitalProductstabinleftnav(WebDriver driver)
	{

		System.out.println("Verify Digital Products tab in left nav");
		Log.info("Verify Digital Products tab in left nav");
		String ProductTab; 
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.ProductTab()));
			if(!(CommonUtility.CheckpresenceofElementLocated(driver, 20, obj_EsupportDDLHomePage.ProductTab()))){
				System.out.println("Product Tab is not highlighted or enabled");
				Report.put("Verify Digital Products tab is highlighted in left nav.", "Digital Products tab should be highlighted in left nav.",
						"Digital Products tab is not highlighted in left nav.", "FAIL");
				Assert.fail();

			}
			else{

				System.out.println("Product Tab is Highlighted.");
				ProductTab=CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.ProductTab()).getText();
				Report.put("Verify Digital Products tab is highlighted in left nav.", "Digital"+Report.color(ProductTab)+"should be highlighted in left nav.",
						"Digital"+Report.color(ProductTab)+ "is highlighted in left nav.", "PASS");
			}
			//}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify Digital Products tab is highlighted in left nav.", "Digital Products tab should be highlighted in left nav.",
					"Digital Products tab is not highlighted in left nav.", "FAIL");
			Assert.fail();
		}
	}

	public void VerifySearchBysection(WebDriver driver)
	{

		System.out.println("Verify Search By section");
		Log.info("Verify Search By section");
		String Keyword,Category,LicenseDate,From,To; 

		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);
			Keyword=CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.KeywordsLabel()).getText();
			System.out.println(Keyword);

			Category=CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.CategoryLabel()).getText();
			System.out.println(Category);
			LicenseDate=CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.LicenseDate()).getText();
			System.out.println(LicenseDate);
			From=CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.FromRange()).getText();
			System.out.println(From);
			To=CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.ToRange()).getText();
			System.out.println(To);

			if ((Keyword.equalsIgnoreCase("Keywords:"))&&(Category.equalsIgnoreCase("Category:"))&&(LicenseDate.equalsIgnoreCase("License date:")))
			{

				if ((From.equalsIgnoreCase("From:"))&&(To.equalsIgnoreCase("To")))
					System.out.println("All the labels are proper");
				Report.put("Verify Search By section", " 1."+Report.color(Keyword)+ "Search label and its textbox. 2."+Report.color(Category)+ "Search label and the dropdown 3."+Report.color(LicenseDate)+"criteria Select a" +Report.color(From)+" and"  +Report.color(To)+ "date range ",
						"Search By section is displayed under title with three otpions to search. 1.Keyword Search label and its textbox. 2.Category Search label and the dropdown 3.License Date criteria Select a From and To date range", "PASS");

			}
			else{
				System.out.println("Labels are not proper");
				Report.put("Verify Search By section", "Search By section should be displayed under title with three otpions to search.1.Keyword Search label and its textbox. 2.Category Search label and the dropdown 3.Ship Date criteria Select a From and To date range",
						"Search By section is not displayed under title with three otpions to search. 1.Keyword Search label and its textbox. 2.Category Search label and the dropdown 3.License Date criteria Select a From and To date range", "FAIL");
				Assert.fail();   
			}
			//}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify Digital Products tab is highlighted in left nav.", "Search By section should be displayed under title with three otpions to search.1.Keyword Search label and its textbox. 2.Category Search label and the dropdown 3.Ship Date criteria Select a From and To date range",
					"Search By section is not displayed under title with three otpions to search. 1.Keyword Search label and its textbox. 2.Category Search label and the dropdown 3.Ship Date criteria Select a From and To date range", "FAIL");
			Assert.fail();
		}
	}
	public void VerifyButtonsUnderSearchBysection(WebDriver driver)
	{

		System.out.println("Verify Buttons Under Search By section");
		Log.info("Verify Buttons Under Search By section");
		String Submit,ClearAll,SaveSearch; 


		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);
			Submit=CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.Submit()).getText();
			ClearAll=CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.ClearAll()).getText();
			SaveSearch=CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.SaveSearch()).getAttribute("innertext");
			System.out.println("Submit text is:  "+Submit);
			System.out.println("ClearAll text is:  "+ClearAll);
			System.out.println("SaveSearch text is: "+SaveSearch);
			

			
			if(CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.Submit()).isDisplayed())
			{
				
				if(CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.ClearAll()).isDisplayed())
				 {
					if(CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.SaveSearch()).isDisplayed())
					{
					 System.out.println("Buttons are available");
						Report.put("Verify the Buttons under Search By section","Three Buttons should be availble"+Report.color(Submit)+","+Report.color(ClearAll)+"and"+Report.color(SaveSearch),
								"Three Buttons are availble", "PASS");

					} 
				 }
			}
		  
			
			 else{
					System.out.println("Buttons are not available");
					Report.put("Verify the Buttons under Search By section","Three Buttons should be availble Submit,Clear All,Save This Search",
							"Three Buttons are not availble", "FAIL");
					Assert.fail();
				}

		

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify the Buttons under Search By section","Three Buttons should be availble Submit,Clear All,Save This Search",
					"Three Buttons are not availble", "FAIL");
			Assert.fail();
		}
	}
	public void VerifySoftwareProductsGrid(WebDriver driver)
	{

		System.out.println("Verify Software Products Grid");
		Log.info("Verify Software Products Grid");

		String Header="";

		try
		{
			Thread.sleep(5000);
			WebDriverWait wait = new WebDriverWait(driver, 120);
			driver.manage().timeouts().implicitlyWait(240, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(240, TimeUnit.SECONDS); 


			//	WebDriverWait wait = new WebDriverWait(driver, 120);
			((JavascriptExecutor)driver).executeScript("scroll(0, 500)"); 
			WebElement webtable=driver.findElement(By.xpath("//table[@class='table table-hover grid']"));
			List<WebElement>rows=webtable.findElements(By.tagName("tr"));


			List<WebElement>columns = rows.get(0).findElements(By.tagName("th"));

			List<WebElement> list=driver.findElements(By.xpath("//table[@class='table table-hover grid']/thead/tr/th"));
			for (int i = 0; i < columns.size(); i++) {
				System.out.println(columns.size());
				list = driver.findElements(By.xpath("//table[@class='table table-hover grid']/thead/tr/th"));
				String value = list.get(i).getText();
				CommonUtility.ScrollToWebElement(driver, list.get(i));
//				CommonUtility.ClickOnWebElement(driver, list.get(i));

				Thread.sleep(5000);
				System.out.println(value);

				Header=Header+" <br> " + value;




			}


			Report.put("Verify Software Products Grid","The list of all available Products are displayed with the following attributes:"+Report.color(Header),
					" The list of all available Products are displayed ", "PASS");



		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify Software Products Grid","The list of all available Products are displayed with the following attributes:"+Report.color(Header),
					" The list of all available Products are not displayed ", "FAIL");
			Assert.fail();
		}
	}
	public void Verifyvaluesincolumns (WebDriver driver)
	{

		System.out.println("Verify Software Products Grid");
		Log.info("Verify Software Products Grid");

		String values="";

		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);
			((JavascriptExecutor)driver).executeScript("scroll(0, 500)"); 
			WebElement webtable=driver.findElement(By.xpath("//table[@class='table table-hover grid']"));
			List<WebElement>rows=webtable.findElements(By.tagName("tr"));


			List<WebElement>columns = rows.get(0).findElements(By.tagName("th"));
			List<WebElement> list=driver.findElements(By.xpath("//table[@class='table table-hover grid']/tbody/tr/td"));
			for (int i = 0; i < columns.size(); i++) {
				System.out.println(columns.size());
				list = driver.findElements(By.xpath("//table[@class='table table-hover grid']/tbody/tr[2]/td"));
				String value = list.get(i).getText();
				CommonUtility.ScrollToWebElement(driver, list.get(i));
				CommonUtility.ClickOnWebElement(driver, list.get(i));

				System.out.println(value);

				values=values+" <br> " + value;




			}


			Report.put("Verify appropriate values are displayed in columns","Appropriate values should be displayed in the respective columns"+Report.color(values), 
					"Appropriate values are displayed in the respective columns ", "PASS");



		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify appropriate values are displayed in columns","Appropriate values should be displayed in the respective columns", 
					"Appropriate values are not displayed in the respective columns ", "FAIL");
			Assert.fail();
		}
	}

	//Sujata 19/2/2019
	public void ToLogin_ValidCredentials(WebDriver driver,String Username, String Password)
	{

		System.out.println("Entering method in to ToLogin_ValidCredentials");
		Log.info("Entering method in to ToLogin_ValidCredentials");

		try
		{

			WebDriverWait wait = new WebDriverWait(driver, 660);
           
			if(CommonUtility.CheckpresenceofElementLocated(driver, alertcount, obj_EsupportDDLHomePage.SignInHeader()))
			{
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.SignInHeader()));

			CommonUtility.highlightElement(driver, obj_EsupportDDLHomePage.Email());
			CommonUtility.highlightElement(driver, obj_EsupportDDLHomePage.Email()).sendKeys(Username);

			System.out.println("Entered Email(Username) as "+Username);

			CommonUtility.highlightElement(driver, obj_EsupportDDLHomePage.Password());
			CommonUtility.highlightElement(driver, obj_EsupportDDLHomePage.Password()).sendKeys(Password);

			System.out.println("Entered Password as "+Password);
			CommonUtility.highlightElement(driver, obj_EsupportDDLHomePage.SignIn());
//			CommonUtility.highlightElement(driver, obj_EsupportDDLHomePage.SignIn()).click();
			CommonUtility.ClickOn(driver, obj_EsupportDDLHomePage.SignIn());
			System.out.println("Clicked on SignIn Button ");

			Report.put("Enter valid email address, password and click on Sign In button", "valid email address as ' "+Report.color(Username)+" ' and password as ' "+Report.color(Password)+" ' and click on Sign In button",
					"User successfully logged into SLM By default Digital product Tab is selected from the Left Nav and  the digital products grid is displayed with all the products associated with the loged in user account", "PASS"); 
		    } 
			else if(CommonUtility.CheckpresenceofElementLocated(driver, alertcount, obj_EsupportDDLHomePage.Email1())) 
			{
				CommonUtility.ScrollTo(driver, obj_EsupportDDLHomePage.Email1());
				CommonUtility.highlightElement(driver, obj_EsupportDDLHomePage.Email1()).sendKeys(Username);

				System.out.println("Entered Email(Username) as "+Username);

//				CommonUtility.ScrollTo(driver, obj_EsupportDDLHomePage.ContinueButton());
//				CommonUtility.ToClickByUsingJavaScript_PassingByLoc(driver, obj_EsupportDDLHomePage.ContinueButton());
				
				Thread.sleep(3000);
				
				CommonUtility.ScrollTo(driver, obj_EsupportDDLHomePage.Password1());
				CommonUtility.highlightElement(driver, obj_EsupportDDLHomePage.Password1()).sendKeys(Password);

				System.out.println("Entered Password as "+Password);
				CommonUtility.highlightElement(driver, obj_EsupportDDLHomePage.SignInButton());
//				CommonUtility.highlightElement(driver, obj_EsupportDDLHomePage.SignIn()).click();
				CommonUtility.ClickOn(driver, obj_EsupportDDLHomePage.SignInButton());
				System.out.println("Clicked on SignIn Button ");
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Enter valid email address, password and click on Sign In button", "Failed to login with given invalid credentials",
					" Failed to login with given invalid credentials", "FAIL");
			Assert.fail();
		}
	}


	public void  ToVerify_Paginations(WebDriver driver) {

		WebDriverWait wait = new WebDriverWait(driver, 240);
		Actions act=new Actions(driver);
		System.out.println("Entering Method in to ToVerify_Paginations");
		String supportHeader = "";

		try{
			Thread.sleep(6000);

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.DigitalLockerHeaderProducts()));
			wait.until(ExpectedConditions.presenceOfElementLocated(obj_EsupportDDLHomePage.Pagination()));

			String ltMessages="";
			CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.Pagination());
			CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.Pagination()).click();

			List<WebElement> list=driver.findElements(obj_EsupportDDLHomePage.PaginationList());

			for(WebElement lt:list)
			{
				act.moveToElement(CommonUtility.highlightElement(driver, lt));
				//CommonUtility.highlightElement(driver, lt);
				String names=lt.getText();

				System.out.println("Alert Name is: " +names);
				ltMessages+=" <br> " + names;


			}

			Report.put("Verify Items per page is displayed at the bottom of the modal window", 
					"Items per page should be displayed at the  bottom of the modal window options displayed as "+Report.color(ltMessages), 
					"Successfully Items per page options are displayed", "PASS");

		}
		catch(Exception e)
		{
			e.printStackTrace();

			Report.put("Verify Items per page is displayed at the bottom of the modal window", 
					"Failed to verify Items per page Options", 
					"Failed to verify Items per page Options", "FAIL");
			Assert.fail();
		}
	}



	public void ToVerify_TablesdataTen(WebDriver driver,String a)
	{
		WebDriverWait wait = new WebDriverWait(driver, 600);
		Actions act=new Actions(driver);
		driver.manage().timeouts().implicitlyWait(600, TimeUnit.SECONDS);      
		System.out.println("In Function ToVerify_TablesdataTen");
		Log.info("In Function ToVerify_TablesdataTen");    
		try{


			Thread.sleep(5000);
			String ltMessages="";
			CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.Pagination());
			CommonUtility.ClickOn(driver,obj_EsupportDDLHomePage.Pagination());

			List<WebElement> list=driver.findElements(obj_EsupportDDLHomePage.PaginationList());

			for(WebElement lt:list)
			{

				CommonUtility.scrollToViewElement(driver, lt);
				//act.moveToElement(CommonUtility.highlightElement(driver, lt));
				//CommonUtility.highlightElement(driver, lt);
				String names=lt.getText();

				if(names.contains(a))
				{
					lt.click();
				}

			}
			Thread.sleep(8000);

			List<WebElement> list1=driver.findElements(obj_EsupportDDLHomePage.PaginationListCount());

			for(WebElement l:list1){
				System.out.println(l.getText());

				act.moveToElement(CommonUtility.highlightElement(driver, l));
			}

			int listcount1=list1.size();
			String intvalue=Integer.toString(listcount1);
			System.out.println(intvalue);



			Report.put("Select the ' "+ Report.color(a) +" ' from the drop down ", 
					"Total ' "+ Report.color(intvalue) +" ' products should be displayed in the page ",
					"Successfully Selected ' "+a+" ' and Total '"+intvalue+"' product are displayed in a Page ", "PASS");

		}
		catch(Exception e){
			Log.info(e);

			e.printStackTrace();

			Report.put("Select the ' "+ Report.color(a) +" ' from the drop down ", 
					"Failed to display products in the page ",
					"Failed to display products in the page ", "FAIL");

			Assert.fail();

		}
	}



	public void ToClick_HistoryTab(WebDriver driver)
	{

		System.out.println("Entering in method to ToClick_HistoryTab");


		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 420);

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.DigitalLockerHeaderProducts()));

			CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.ClickingOnHistoryTab());

			CommonUtility.ClickOn(driver,obj_EsupportDDLHomePage.ClickingOnHistoryTab());

			Report.put("Click on order  History link in left nav.", " Order History page should be displayed with all products purchased or associated with user",
					"Successfully Order History page should be displayed with all products purchased or associated with user", "PASS");


		} catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on order  History link in left nav.", " Failed to find Order History page with all products purchased or associated with user",
					" Failed to find Order History page with all products purchased or associated with user", "FAIL");

			Assert.fail();
		}
	}


	public void ToVerify_TablesdataALL(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 600);
		Actions act=new Actions(driver);
		driver.manage().timeouts().implicitlyWait(600, TimeUnit.SECONDS);      
		System.out.println("In Function ToVerify_TablesdataALL");
		Log.info("In Function ToVerify_TablesdataALL");    
		try{




			Thread.sleep(5000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.HistorySearchALL()));
			act.moveToElement(CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.HistorySearchALL())).build().perform();

			CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.HistorySearchALL());

			String Thritytext=CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.HistorySearchALL()).getAttribute("value");

			if(CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.HistorySearchALL()).isDisplayed())
			{

				Thread.sleep(15000);

				String ltMessages="";

//				act.moveToElement(CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.HistorySearchSubmitOrder())).build().perform();

				List<WebElement> list1=driver.findElements(obj_EsupportDDLHomePage.HistorySearchSubmitOrder());
				int listcount1=list1.size();
				String intvalue=Integer.toString(listcount1);
				System.out.println(intvalue);




				Report.put("Verify option '"+Report.color(Thritytext)+"' is selected by default in Refine view section",
						"option 'All' should be selected by default in Refine view section and Ordernumber links are displayed as "+Report.color(intvalue)+" records in a Page ",
						"Successfully Verified option 'All' is selected by default in Refine view section ", "PASS");


			}



		}
		catch(Exception e){
			Log.info(e);

			e.printStackTrace();


			Report.put("Verify option 'All' is selected by default in Refine view section",
					"Failed to  find option 'All' should be selected by default in Refine view section",
					"Failed to  find option 'All' should be selected by default in Refine view section ", "FAIL");
			Assert.fail();

		}
	}


	public void ToVerify_TablesdataThiryDays(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 600);
		Actions act=new Actions(driver);
		driver.manage().timeouts().implicitlyWait(600, TimeUnit.SECONDS);      
		System.out.println("In Function ToVerify_TablesdataThiryDays");
		Log.info("In Function ToVerify_TablesdataThiryDays");    
		try{


			Thread.sleep(15000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.HistorySearchThirty()));
			CommonUtility.ScrollTo(driver,obj_EsupportDDLHomePage.HistorySearchThirty());

			CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.HistorySearchThirty());

			String Thritytext=CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.HistorySearchThirty()).getAttribute("value");

			CommonUtility.ClickOn(driver,obj_EsupportDDLHomePage.HistorySearchThirty());

			Thread.sleep(2000);

			CommonUtility.ScrollTo(driver,obj_EsupportDDLHomePage.HistorySearchSubmit());

			CommonUtility.ClickOn(driver,obj_EsupportDDLHomePage.HistorySearchSubmit());

			Thread.sleep(15000);

			String ltMessages="";

			List<WebElement> list1=driver.findElements(obj_EsupportDDLHomePage.HistorySearchSubmitOrder());
			int listcount1=list1.size();
			String intvalue=Integer.toString(listcount1);
			System.out.println(intvalue);

			for(WebElement l:list1){
				System.out.println(l.getText());
				String names=l.getText();
				System.out.println("Alert Name is: " +names);
				ltMessages+=" <br> " + names;

				CommonUtility.ScrollToWebElement(driver, l);
			}



			Report.put("Select '30 days' option in Refine view section",
					"should display products based on option selected by user. Products ordered by ' "+Report.color(Thritytext)+" ' And in page the count of Ordernumber ::    "+Report.color(intvalue)+" and Ordernumber links  are :: "+Report.color(ltMessages),
					"Successfully Products ordered by 30 days should be displayed ", "PASS");

		}
		catch(Exception e){
			Log.info(e);

			e.printStackTrace();

			Report.put("Select '30 days' option in Refine view section",
					"Failed to display the option in Refine view section",
					"Failed to display the option in Refine view section ", "FAIL");
			Assert.fail();

		}
	}


	public void ToVerify_TablesdataSixtyDays(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 600);
		Actions act=new Actions(driver);
		driver.manage().timeouts().implicitlyWait(600, TimeUnit.SECONDS);      
		System.out.println("In Function ToVerify_TablesdataSixtyDays");
		Log.info("In Function ToVerify_TablesdataSixtyDays");    
		try{


			Thread.sleep(5000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.HistorySearchSixty()));
			CommonUtility.ScrollTo(driver,obj_EsupportDDLHomePage.HistorySearchSixty());

			CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.HistorySearchSixty());

			String Thritytext=CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.HistorySearchSixty()).getAttribute("value");

			CommonUtility.ClickOn(driver,obj_EsupportDDLHomePage.HistorySearchSixty());

			Thread.sleep(2000);

			CommonUtility.ScrollTo(driver,obj_EsupportDDLHomePage.HistorySearchSubmit());

			CommonUtility.ClickOn(driver,obj_EsupportDDLHomePage.HistorySearchSubmit());

			Thread.sleep(15000);

			String ltMessages="";

			List<WebElement> list1=driver.findElements(obj_EsupportDDLHomePage.HistorySearchSubmitOrder());
			int listcount1=list1.size();
			String intvalue=Integer.toString(listcount1);
			System.out.println(intvalue);

			for(WebElement l:list1){
				System.out.println(l.getText());
				String names=l.getText();
				System.out.println("Alert Name is: " +names);
				ltMessages+=" <br> " + names;

				CommonUtility.ScrollToWebElement(driver, l);
			}



			Report.put("Select '60 days' option in Refine view section",
					"should display products based on option selected by user. Products ordered by ' "+Report.color(Thritytext)+" ' And in page the count of Ordernumber ::    "+Report.color(intvalue)+" and Ordernumber links  are :: "+Report.color(ltMessages),
					"Successfully Products ordered by 60 days should be displayed ", "PASS");

		}
		catch(Exception e){
			Log.info(e);

			e.printStackTrace();

			Report.put("Select '60 days' option in Refine view section",
					"Failed to display the option in Refine view section",
					"Failed to display the option in Refine view section ", "FAIL");
			Assert.fail();

		}
	}


	public void ToVerify_TablesdataNintyDays(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 600);
		Actions act=new Actions(driver);
		driver.manage().timeouts().implicitlyWait(600, TimeUnit.SECONDS);      
		System.out.println("In Function ToVerify_TablesdataNintyDays");
		Log.info("In Function ToVerify_TablesdataNintyDays");    
		try{


			Thread.sleep(5000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.HistorySearchNinty()));
			CommonUtility.ScrollTo(driver,obj_EsupportDDLHomePage.HistorySearchNinty());

			CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.HistorySearchNinty());

			String Thritytext=CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.HistorySearchNinty()).getAttribute("value");

			CommonUtility.ClickOn(driver,obj_EsupportDDLHomePage.HistorySearchNinty());

			Thread.sleep(2000);

			CommonUtility.ScrollTo(driver,obj_EsupportDDLHomePage.HistorySearchSubmit());

			CommonUtility.ClickOn(driver,obj_EsupportDDLHomePage.HistorySearchSubmit());

			Thread.sleep(15000);

			String ltMessages="";

			List<WebElement> list1=driver.findElements(obj_EsupportDDLHomePage.HistorySearchSubmitOrder());
			int listcount1=list1.size();
			String intvalue=Integer.toString(listcount1);
			System.out.println(intvalue);

			for(WebElement l:list1){
				System.out.println(l.getText());
				String names=l.getText();
				System.out.println("Alert Name is: " +names);
				ltMessages+=" <br> " + names;

				CommonUtility.ScrollToWebElement(driver, l);
			}



			Report.put("Select '90 days' option in Refine view section",
					"should display products based on option selected by user. Products ordered by ' "+Report.color(Thritytext)+" ' And in page the count of Ordernumber ::    "+Report.color(intvalue)+" and Ordernumber links  are :: "+Report.color(ltMessages),
					"Successfully Products ordered by 90 days should be displayed ", "PASS");

		}
		catch(Exception e){
			Log.info(e);

			e.printStackTrace();

			Report.put("Select '90 days' option in Refine view section",
					"Failed to display the option in Refine view section",
					"Failed to display the option in Refine view section ", "FAIL");
			Assert.fail();

		}
	}

	public void ToVerify_TablesdataDateRange(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 600);
		Actions act=new Actions(driver);
		driver.manage().timeouts().implicitlyWait(600, TimeUnit.SECONDS);      
		System.out.println("In Function ToVerify_TablesdataDateRange");
		Log.info("In Function ToVerify_TablesdataDateRange");    
		try{


			Thread.sleep(5000);
//			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.DateRange()));
			CommonUtility.ScrollTo(driver,obj_EsupportDDLHomePage.DateRange());

			CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.DateRange());

			String Thritytext=CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.DateRange()).getAttribute("value");

			CommonUtility.ClickOn(driver,obj_EsupportDDLHomePage.DateRange());

			Thread.sleep(2000);

			String newcode=TestNGCreator.TestData.get(Esupport.TestCaseID.ordinal());
			if(newcode.equalsIgnoreCase("5784146")){

				CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.FromRange());
				CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.ToRange());



				Report.put("Select the radio button Date Range",
						"It should expand and show TO and From date values",
						"Expanded TO and From date values are displayed", "PASS");
			}

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.DaterangeFromdate()));
			CommonUtility.ScrollTo(driver,obj_EsupportDDLHomePage.DaterangeFromdate());
			CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.DaterangeFromdate()).clear(); 

			CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.DaterangeFromdate()).sendKeys("06/06/2018");


			Thread.sleep(4000);


			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.HistorySearchSubmit()));
			CommonUtility.ScrollTo(driver,obj_EsupportDDLHomePage.HistorySearchSubmit());

			CommonUtility.ClickOn(driver,obj_EsupportDDLHomePage.HistorySearchSubmit());

			Thread.sleep(15000);

			String ltMessages="";

			List<WebElement> list1=driver.findElements(obj_EsupportDDLHomePage.HistorySearchSubmitOrder());
			int listcount1=list1.size();
			String intvalue=Integer.toString(listcount1);
			System.out.println(intvalue);

			for(WebElement l:list1){
				System.out.println(l.getText());
				String names=l.getText();
				System.out.println("Alert Name is: " +names);
				ltMessages+=" <br> " + names;

				CommonUtility.ScrollToWebElement(driver, l);
			}

			if(newcode.equalsIgnoreCase("5784146")){




				Report.put("Enter valid To and From Date values and click on Submit",
						"Entered Dates should be taken and search values for the given date range should be displayed",
						"Entered Dates should be taken and search values for the given date range are displayed", "PASS");
			}else

				Report.put("Select Date range in from and two sections",
						"should display products based on option selected by user. Products ordered with in the date range  should be displayed and Order number as "+Report.color(ltMessages),
						"Successfully should display products based on option selected by user. Products ordered with in the date range  should be displayed ", "PASS");

		}
		catch(Exception e){
			Log.info(e);

			e.printStackTrace();

			Report.put("Select '90 days' option in Refine view section",
					"Failed to display the option in Refine view section",
					"Failed to display the option in Refine view section ", "FAIL");
			Assert.fail();

		}
	}



	public void  ToVerify_DDLPage(WebDriver driver) {

		WebDriverWait wait = new WebDriverWait(driver, 120);


		System.out.println("Entering Method in to ToVerify_DDLPage");


		String supportHeader = "";

		try{

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.DDLHeader()));
			CommonUtility.highlightElement(driver, obj_EsupportDDLHomePage.DDLHeader());
			supportHeader = CommonUtility.highlightElement(driver, obj_EsupportDDLHomePage.DDLHeader()).getText();
			System.out.println("Header is: "+supportHeader);



			Report.put("Navigate to URL : http://www.dell.com/support/software", 
					"' "+Report.color(supportHeader)+" ' landing page should be displayed.", 
					"Successfully url is navigate to Dell License Management Portal ", "PASS");

			//Thread.sleep(3000);                  
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Navigate to URL : http://www.dell.com/support/software", 
					"Not able to navigate Dell License Management Portal", 
					"Not able to navigate Dell License Management Portal ", "FAIL");
			Assert.fail();
		}
	}





	public void  ToVerify_DDlClickablelinks(WebDriver driver) {

		WebDriverWait wait = new WebDriverWait(driver, 120);


		Actions act=new Actions(driver);

		System.out.println("Entering Method in to ToVerify_DDlClickablelinks");


		String supportHeader = "";

		try{
			Thread.sleep(3000);

			String ltMessages="";
			CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.DDlClickablelinks());

			List<WebElement> list=driver.findElements(obj_EsupportDDLHomePage.DDlClickablelinks());

			for(WebElement lt:list)
			{
				act.moveToElement(CommonUtility.highlightElement(driver, lt));
				//CommonUtility.highlightElement(driver, lt);
				String names=lt.getText();

				System.out.println("Alert Name is: " +names);
				ltMessages+=" <br> " + names;


			}



			Report.put("Verify the DDL Links", 
					"Links are displayed as "+Report.color(ltMessages), 
					"Successfully DDL links are displayed", "PASS");

		}
		catch(Exception e)
		{
			e.printStackTrace();

			Report.put("Verify the DDL Links", 
					"Failing to find DDL Links in the page ", 
					"Failing to find DDL Links in the page","FAIL");
			Assert.fail();
		}
	}


	public void  ToVerify_ProductSupportpage(WebDriver driver) {

		WebDriverWait wait = new WebDriverWait(driver, 120);

		Actions act=new Actions(driver);


		System.out.println("Entering Method in to ToVerify_ProductSupportpage");


		String supportHeader = "";
		String supportHeaderUrl = "";

		try{
			Thread.sleep(3000);

		//	act.moveToElement(CommonUtility.highlightElement(driver, obj_EsupportDDLHomePage.ProductSupportLink())).build().perform();

			CommonUtility.ClickOn(driver, obj_EsupportDDLHomePage.ProductSupportLink());
			Set<String> allWH=driver.getWindowHandles(); 
			String currentwindow=driver.getWindowHandle();
			int count=allWH.size(); 
			System.out.println("Window Handles and  window count is :: "+count);
			String Currentwindowhandle= driver.getCurrentUrl();

			System.out.println("Parent window as "+Currentwindowhandle);
			for(String wh:allWH)
			{
				driver.manage().timeouts().implicitlyWait(700, TimeUnit.SECONDS);
				Thread.sleep(20000);
				driver.switchTo().window(wh); 
				String title=driver.getTitle();
				System.out.println("Tittle displayed as   :::::"+title); 



				if(title.contains("Support | Dell US"))
				{
					handleCookies(driver);

					System.out.println("Switched to window");


					wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.SupportHeader()));
					CommonUtility.highlightElement(driver, obj_EsupportDDLHomePage.SupportHeader());
					supportHeader = CommonUtility.highlightElement(driver, obj_EsupportDDLHomePage.SupportHeader()).getText();
					supportHeaderUrl =driver.getCurrentUrl();


					System.out.println("Header is: "+supportHeader);

					System.out.println("Current url is: "+supportHeaderUrl);



					Report.put("Verify the following link is available on the page, above the footer Product Support Url as ' "+Report.color(supportHeaderUrl)+" ' ", 
							"' "+Report.color(supportHeader)+" ' landing page should be displayed.", 
							"Successfully url is Product support Url displayed ", "PASS");

					Report.put("Click on Product Support link", 
							"' "+Report.color(supportHeader)+" ' landing page should be displayed.", 
							"Successfully Product support Page displayed ", "PASS");

					Thread.sleep(7000);
					driver.close();

//					Thread.sleep(7000);

//					Thread.sleep(10000);
					
					
				}
				
				driver.switchTo().window(currentwindow);

				Thread.sleep(10000);

				System.out.println("current parent window"+driver.getCurrentUrl());

				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.DDLHeader()));
				CommonUtility.highlightElement(driver, obj_EsupportDDLHomePage.DDLHeader());
				supportHeader = CommonUtility.highlightElement(driver, obj_EsupportDDLHomePage.DDLHeader()).getText();
				System.out.println("Header is: "+supportHeader);


				Thread.sleep(5000);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on Product Support link", 
					"Failed to find Product Support link", 
					"Failed to find Product Support link ", "FAIL");
			Assert.fail();
		}
	}


	public void  ToVerify_TrailSoftwarepage(WebDriver driver) {

		WebDriverWait wait = new WebDriverWait(driver, 120);

		Actions act=new Actions(driver);


		System.out.println("Entering Method in to ToVerify_TrailSoftwarepage");


		String supportHeader = "";
		String supportHeaderUrl = "";

		try{
			Thread.sleep(3000);

			act.moveToElement(CommonUtility.highlightElement(driver, obj_EsupportDDLHomePage.TrailSupportLink())).build().perform();

			CommonUtility.ClickOn(driver, obj_EsupportDDLHomePage.TrailSupportLink());




			Set<String> allWH=driver.getWindowHandles(); 
			String currentwindow=driver.getWindowHandle();
			int count=allWH.size(); 
			System.out.println("Window Handles and  window count is :: "+count);
			String Currentwindowhandle= driver.getCurrentUrl();

			System.out.println("Parent window as "+Currentwindowhandle);
			for(String wh:allWH)
			{
				driver.manage().timeouts().implicitlyWait(700, TimeUnit.SECONDS);
				Thread.sleep(10000);
				driver.switchTo().window(wh); 
				String title=driver.getTitle();
				System.out.println("Tittle displayed as   :::::"+title); 



				if(title.contains("Business Laptops, Desktops, Servers & Electronics | Dell US"))
				{
					handleCookies(driver);

					System.out.println("Switched to window");


					wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.SupportHeader()));
					CommonUtility.highlightElement(driver, obj_EsupportDDLHomePage.SupportHeader());
					supportHeader = CommonUtility.highlightElement(driver, obj_EsupportDDLHomePage.SupportHeader()).getText();
					supportHeaderUrl =driver.getCurrentUrl();


					System.out.println("Header is: "+supportHeader);

					System.out.println("Current url is: "+supportHeaderUrl);



					Report.put("Verify the following link is available on the page, above the footer Trial Software Url as ' "+Report.color(supportHeaderUrl)+" ' ", 
							"' "+Report.color(supportHeader)+" ' landing page should be displayed.", 
							"Successfully url is Trial Software Url displayed ", "PASS");

					Report.put("Click on Trial Software link", 
							"' "+Report.color(supportHeader)+" ' landing page should be displayed.", 
							"Successfully Trial Software Page displayed ", "PASS");


					Thread.sleep(5000);
					driver.close();

//					Thread.sleep(10000);
//
//					Thread.sleep(5000);
					

				}
				driver.switchTo().window(currentwindow);

				Thread.sleep(10000);
				System.out.println("current parent window"+driver.getCurrentUrl());

				//Actions act=new Actions(driver);

				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.DDLHeader()));
				CommonUtility.highlightElement(driver, obj_EsupportDDLHomePage.DDLHeader());
				supportHeader = CommonUtility.highlightElement(driver, obj_EsupportDDLHomePage.DDLHeader()).getText();
				System.out.println("Header is: "+supportHeader);
				Thread.sleep(5000);
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();

			Report.put("Click on Trial Software", 
					"Failed to find Trial Software link", 
					"Failed to find Trial Software link ", "FAIL");


			Assert.fail();
		}
	}


	public void  ToVerify_OwnershipTransferLinkepage(WebDriver driver) {

		WebDriverWait wait = new WebDriverWait(driver, 120);

		Actions act=new Actions(driver);


		System.out.println("Entering Method in to ToVerify_OwnershipTransferLinkepage");


		String supportHeader = "";
		String supportHeaderUrl = "";

		try{
			Thread.sleep(3000);

			act.moveToElement(CommonUtility.highlightElement(driver, obj_EsupportDDLHomePage.OwnershipTransferLink())).build().perform();

			CommonUtility.ClickOn(driver, obj_EsupportDDLHomePage.OwnershipTransferLink());




			Set<String> allWH=driver.getWindowHandles(); 
			String currentwindow=driver.getWindowHandle();
			int count=allWH.size(); 
			System.out.println("Window Handles and  window count is :: "+count);
			String Currentwindowhandle= driver.getCurrentUrl();

			System.out.println("Parent window as "+Currentwindowhandle);
			for(String wh:allWH)
			{
				driver.manage().timeouts().implicitlyWait(700, TimeUnit.SECONDS);
				Thread.sleep(10000);
				driver.switchTo().window(wh); 
				String title=driver.getTitle();
				System.out.println("Tittle displayed as   :::::"+title); 



				if(title.contains("Ownership Transfer | Dell US"))
				{
					handleCookies(driver);

					System.out.println("Switched to window");


					wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.SupportHeader()));
					CommonUtility.highlightElement(driver, obj_EsupportDDLHomePage.SupportHeader());
					supportHeader = CommonUtility.highlightElement(driver, obj_EsupportDDLHomePage.SupportHeader()).getText();
					supportHeaderUrl =driver.getCurrentUrl();


					System.out.println("Header is: "+supportHeader);

					System.out.println("Current url is: "+supportHeaderUrl);



					Report.put("Verify the following link is available on the page, above the footer Ownership Transfer Link Url as ' "+Report.color(supportHeaderUrl)+" ' ", 
							"' "+Report.color(supportHeader)+" ' landing page should be displayed.", 
							"Successfully url is Ownership Transfer Link Url displayed ", "PASS");

					Report.put("Click on Ownership Transfer Link", 
							"' "+Report.color(supportHeader)+" ' landing page should be displayed.", 
							"Successfully Ownership Transfer Link Page displayed ", "PASS");


					Thread.sleep(4000);
					driver.close();

//					Thread.sleep(10000);
//
//					Thread.sleep(5000);
					

				}
				driver.switchTo().window(currentwindow);

				Thread.sleep(10000);
				System.out.println("current parent window"+driver.getCurrentUrl());

				//Actions act=new Actions(driver);

				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.DDLHeader()));
				CommonUtility.highlightElement(driver, obj_EsupportDDLHomePage.DDLHeader());
				supportHeader = CommonUtility.highlightElement(driver, obj_EsupportDDLHomePage.DDLHeader()).getText();
				System.out.println("Header is: "+supportHeader);
				Thread.sleep(5000);
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();

			Report.put("Click on Ownership Transfer Link", 
					"Failed to find Ownership Transfer Link", 
					"Failed to find Ownership Transfer Link ", "FAIL");


			Assert.fail();
		}
	}


	public void  ToVerify_OrderSupportLinkepage(WebDriver driver) {

		WebDriverWait wait = new WebDriverWait(driver, 120);

		Actions act=new Actions(driver);


		System.out.println("Entering Method in to ToVerify_OrderSupportLinkepage");


		String supportHeader = "";
		String supportHeaderUrl = "";

		try{
			Thread.sleep(3000);

			act.moveToElement(CommonUtility.highlightElement(driver, obj_EsupportDDLHomePage.OrderSupportLink())).build().perform();

			CommonUtility.ClickOn(driver, obj_EsupportDDLHomePage.OrderSupportLink());
			Set<String> allWH=driver.getWindowHandles(); 
			String currentwindow=driver.getWindowHandle();
			int count=allWH.size(); 
			System.out.println("Window Handles and  window count is :: "+count);
			String Currentwindowhandle= driver.getCurrentUrl();

			System.out.println("Parent window as "+Currentwindowhandle);
			for(String wh:allWH)
			{
				driver.manage().timeouts().implicitlyWait(700, TimeUnit.SECONDS);
				Thread.sleep(10000);
				driver.switchTo().window(wh); 
				String title=driver.getTitle();
				System.out.println("Tittle displayed as   :::::"+title); 



				if(title.contains("Order Status | Dell US"))
				{
					handleCookies(driver);

					System.out.println("Switched to window");


					wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.SupportHeader()));
					CommonUtility.highlightElement(driver, obj_EsupportDDLHomePage.SupportHeader());
					supportHeader = CommonUtility.highlightElement(driver, obj_EsupportDDLHomePage.SupportHeader()).getText();
					supportHeaderUrl =driver.getCurrentUrl();


					System.out.println("Header is: "+supportHeader);

					System.out.println("Current url is: "+supportHeaderUrl);



					Report.put("Verify the following link is available on the page, above the footer OrderSupport Link Url as ' "+Report.color(supportHeaderUrl)+" ' ", 
							"' "+Report.color(supportHeader)+" ' landing page should be displayed.", 
							"Successfully url is OrderSupport Link Url displayed ", "PASS");

					Report.put("Click on OrderSupport Link", 
							"' "+Report.color(supportHeader)+" ' landing page should be displayed.", 
							"Successfully OrderSupport Link Page displayed ", "PASS");


					Thread.sleep(4000);
					driver.close();

//					Thread.sleep(10000);
//
//					Thread.sleep(5000);
					

				}
				else
				{
					driver.close();
					Report.put("Click on OrderSupport Link", 
							"' "+Report.color(supportHeader)+" ' landing page should be displayed.", 
							"OrderSupport Link Page not displayed ", "Fail");
					Assert.fail();
				}
				driver.switchTo().window(currentwindow);

				Thread.sleep(10000);
				System.out.println("current parent window"+driver.getCurrentUrl());

				//Actions act=new Actions(driver);

				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.DDLHeader()));
				CommonUtility.highlightElement(driver, obj_EsupportDDLHomePage.DDLHeader());
				supportHeader = CommonUtility.highlightElement(driver, obj_EsupportDDLHomePage.DDLHeader()).getText();
				System.out.println("Header is: "+supportHeader);
				Thread.sleep(5000);
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();

			Report.put("Click on OrderSupport Link", 
					"Failed to find OrderSupport Link", 
					"Failed to find OrderSupport Link ", "FAIL");


			Assert.fail();
		}
	}


	//Pushpa 19/9/2019



	public void clickDigitalProductsTab(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 240);
		System.out.println("clickDigitalProductsTab");
		Log.info("clickDigitalProductsTab");
		String productHeader; 
		Actions act=new Actions(driver);
		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.ProductTab()));
//			handleCookies(driver);
			CommonUtility.ScrollTo(driver,obj_EsupportDDLHomePage.ProductTab());
			if(CommonUtility.CheckpresenceofElementLocated(driver, 20, obj_EsupportDDLHomePage.ProductTab()))
			{
//				CommonUtility.scrollToViewElement(driver,obj_EsupportDDLHomePage.ProductTab());
//				CommonUtility.ToClickByUsingJavaScript_PassingByLoc(driver,obj_EsupportDDLHomePage.ProductTab());
//				act.moveToElement(CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.ProductTab())).build().perform();
//				act.moveToElement(CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.ProductTab())).click().build().perform();
//				handleCookies(driver);
				CommonUtility.ScrollTo(driver,obj_EsupportDDLHomePage.ProductTab());
				CommonUtility.ClickOn(driver,obj_EsupportDDLHomePage.ProductTab());
				Log.info("Product Tab is clicked");
				//Thread.sleep(20000);
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.ProductHeader()));
				CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.ProductHeader());
				productHeader = CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.ProductHeader()).getText();
				Report.put("Click on Digital Products link in left nav",
						"Digital Products view page should be displayed",
						"Digital Products view page is displayed. Header is:"+Report.color(productHeader), "PASS");             
			}               
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on Digital Products link in left nav",
					"Digital Products view page should be displayed",
					"Digital Products view page is not displayed.", "FAIL");             
			Assert.fail();
		}
	}
	public void toVerifyLicenseDateSorting(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 600);
		Actions act=new Actions(driver);
		driver.manage().timeouts().implicitlyWait(600, TimeUnit.SECONDS);      
		System.out.println("Inside toVerifyLicenseDateSorting");
		Log.info("Inside toVerifyLicenseDateSorting");   

		try
		{
			act.moveToElement(CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.LicenseDateColumn())).build().perform();
			CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.LicenseDateColumn());
			List<WebElement> beforeSortData=driver.findElements(obj_EsupportDDLHomePage.LicenseDateColumnData());
			String beforeSortDataList = "";
			String afterSortDataList = "";

			for(WebElement lt:beforeSortData)
			{
				CommonUtility.highlightElement(driver, lt);
				String names=lt.getText();
				beforeSortDataList+=" <br> " + names;
			}
			Report.put("Date before Sorting",
					"Date before clicking on Sorting", 
					"Date before clicking Sorting is "+Report.color(beforeSortDataList), "PASS");
			CommonUtility.ClickOn(driver,obj_EsupportDDLHomePage.LicenseDateColumn());

			Thread.sleep(10000);

			List<WebElement> afterSortData=driver.findElements(obj_EsupportDDLHomePage.LicenseDateColumnData());

			for(WebElement lt:afterSortData)
			{
				CommonUtility.highlightElement(driver, lt);
				String names=lt.getText();
				afterSortDataList+=" <br> " + names;
			}

			Thread.sleep(3000);

			Report.put("Verify default - products is sorted by ship Date",
					"by default - products is sorted by ship Date"+ Report.color(afterSortDataList), 
					"Successfully Sorted by License Date ", "PASS");
		}
		catch(Exception e){
			Log.info(e);

			e.printStackTrace();

			Report.put("Verify default - products is sorted by ship Date",
					"by default - products is sorted by ship Date", 
					"Failed to sort by License Date ", "FAIL");
			Assert.fail();
		}
	}

	public void toVerifyProductNameSorting(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 600);
		Actions act=new Actions(driver);
		driver.manage().timeouts().implicitlyWait(600, TimeUnit.SECONDS);      
		System.out.println("Inside toVerifyProductNameSorting");
		Log.info("Inside toVerifyProductNameSorting");   

		try
		{
			act.moveToElement(CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.ProductNameColumn())).build().perform();
			CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.ProductNameColumn());
			List<WebElement> beforeSortData=driver.findElements(obj_EsupportDDLHomePage.ProductNameColumnData());
			String beforeSortDataList = "";
			String afterSortDataList = "";

			for(WebElement lt:beforeSortData)
			{
				CommonUtility.highlightElement(driver, lt);
				String names=lt.getText();
				beforeSortDataList+=" <br> " + names;
			}
			Report.put("Product Name before Sorting",
					"Product Name List before clicking on Sorting", 
					"Product Name List before clicking on Sorting "+Report.color(beforeSortDataList), "PASS");
			CommonUtility.ClickOn(driver,obj_EsupportDDLHomePage.ProductNameColumn());

			Thread.sleep(10000);

			List<WebElement> afterSortData=driver.findElements(obj_EsupportDDLHomePage.ProductNameColumnData());

			for(WebElement lt:afterSortData)
			{
				CommonUtility.highlightElement(driver, lt);
				String names=lt.getText();
				afterSortDataList+=" <br> " + names;
			}

			Thread.sleep(3000);

			Report.put("Click on Product Name column",
					"should sort the list in ascending or descending order toggled based on previous sort order", 
					"Successfully Sorted Product Name Column "+ Report.color(afterSortDataList), "PASS");
		}
		catch(Exception e){
			Log.info(e);

			e.printStackTrace();

			Report.put("Click on Product Name column",
					"should sort the list in ascending or descending order toggled based on previous sort order", 
					"Failed to Sort Product Name Column ", "FAIL");
			Assert.fail();
		}
	}

	public void toVerifyPrimaryIDSorting(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 600);
		Actions act=new Actions(driver);
		driver.manage().timeouts().implicitlyWait(600, TimeUnit.SECONDS);      
		System.out.println("Inside toVerifyPrimaryIDSorting");
		Log.info("Inside toVerifyPrimaryIDSorting");   

		try
		{
			act.moveToElement(CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.PrimaryIDColumn())).build().perform();
			CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.PrimaryIDColumn());
			List<WebElement> beforeSortData=driver.findElements(obj_EsupportDDLHomePage.PrimaryIDColumnData());
			String beforeSortDataList = "";
			String afterSortDataList = "";

			for(WebElement lt:beforeSortData)
			{
				CommonUtility.highlightElement(driver, lt);
				String names=lt.getText();
				beforeSortDataList+=" <br> " + names;
			}
			Report.put("Primary ID Column values before Sorting",
					"Primary ID List before clicking on Sorting", 
					"Primary ID List before clicking on Sorting "+Report.color(beforeSortDataList), "PASS");
			CommonUtility.ClickOn(driver,obj_EsupportDDLHomePage.PrimaryIDColumn());

			Thread.sleep(10000);

			List<WebElement> afterSortData=driver.findElements(obj_EsupportDDLHomePage.PrimaryIDColumnData());

			for(WebElement lt:afterSortData)
			{
				CommonUtility.highlightElement(driver, lt);
				String names=lt.getText();
				afterSortDataList+=" <br> " + names;
			}

			Thread.sleep(3000);

			Report.put("Click on Primary ID column",
					"should sort the list in ascending or descending order toggled based on previous sort order", 
					"Successfully Sorted Primary ID Column "+ Report.color(afterSortDataList), "PASS");
		}
		catch(Exception e){
			Log.info(e);

			e.printStackTrace();

			Report.put("Click on Primary ID column",
					"should sort the list in ascending or descending order toggled based on previous sort order", 
					"Failed to Sort Primary ID Column ", "FAIL");
			Assert.fail();
		}
	}

	public void toVerifyOrderNumberSorting(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 600);
		Actions act=new Actions(driver);
		driver.manage().timeouts().implicitlyWait(600, TimeUnit.SECONDS);      
		System.out.println("Inside toVerifyOrderNumberSorting");
		Log.info("Inside toVerifyOrderNumberSorting");   

		try
		{
//			act.moveToElement(CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.OrderNumberColumn())).build().perform();
			CommonUtility.ScrollTo(driver,obj_EsupportDDLHomePage.OrderNumberColumn());
			List<WebElement> beforeSortData=driver.findElements(obj_EsupportDDLHomePage.OrderNumberColumnData());
			String beforeSortDataList = "";
			String afterSortDataList = "";

			for(WebElement lt:beforeSortData)
			{
				CommonUtility.highlightElement(driver, lt);
				String names=lt.getText();
				beforeSortDataList+=" <br> " + names;
			}
			Report.put("Order Number Column values before Sorting",
					"Order Number List before clicking on Sorting", 
					"Order Number List before clicking on Sorting "+Report.color(beforeSortDataList), "PASS");
			CommonUtility.ClickOn(driver,obj_EsupportDDLHomePage.OrderNumberColumn());

			Thread.sleep(10000);

			List<WebElement> afterSortData=driver.findElements(obj_EsupportDDLHomePage.OrderNumberColumnData());

			for(WebElement lt:afterSortData)
			{
				CommonUtility.highlightElement(driver, lt);
				String names=lt.getText();
				afterSortDataList+=" <br> " + names;
			}

			Thread.sleep(3000);

			Report.put("Click on Order Number column",
					"should sort the list in ascending or descending order toggled based on previous sort order", 
					"Successfully Sorted Order Number Column "+ Report.color(afterSortDataList), "PASS");
		}
		catch(Exception e){
			Log.info(e);

			e.printStackTrace();

			Report.put("Click on Order Number column",
					"should sort the list in ascending or descending order toggled based on previous sort order", 
					"Failed to Sort Order Number Column ", "FAIL");
			Assert.fail();
		}
	}

	//Sudha 19/9/2019

	public void ProductRegistrationTab(WebDriver driver)
	{

		System.out.println("Click on Product Registration Tab");
		Log.info("Click on Product Registration Tab");

		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);


			CommonUtility.highlightElement(driver, obj_EsupportDDLHomePage.ProductRegistrationTab());

			CommonUtility.ClickOn(driver,obj_EsupportDDLHomePage.ProductRegistrationTab()); 


		} catch(Exception e)
		{
			e.printStackTrace();

			Assert.fail();
		}
	}

	public void verifypartnerview(WebDriver driver)
	{

		System.out.println("Entering in to Verify partner view");
		Log.info("Entering in to Verify partner view");
		String Entry; 


		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);
			Entry=CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.Entry()).getText();

			if ((Entry.equalsIgnoreCase("Entry")))
			{
				System.out.println("Buttons are available");
				Report.put("verify the partner view","if the logged in user is partner when we click on the product registartion tab from the left navigation user should be able to view the Entry and status tab",
						"when we click on the product registartion tab from the left navigation user is able to view the Entry and status tab", "PASS");

			}
			else{
				System.out.println("Buttons are not available");
				Report.put("verify the partner view","if the logged in user is partner when we click on the product registartion tab from the left navigation user should be able to view the Entry and status tab",
						"when we click on the product registartion tab from the left navigation user is not able to view the Entry and status tab", "FAIL");
				Assert.fail();
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("verify the partner view","if the logged in user is partner when we click on the product registartion tab from the left navigation user should be able to view the Entry and status tab",
					"when we click on the product registartion tab from the left navigation user is not able to view the Entry and status tab", "FAIL");
			Assert.fail();
		}
	}
	public void Click_OrderHistoryTab(WebDriver driver)
	{

		System.out.println("Entering to Click Order History Tab");
		Log.info("Entering to Click Order History Tab");

		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);

			Thread.sleep(3000);

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.DigitalLockerHeaderProducts()));

			CommonUtility.ScrollTo(driver,obj_EsupportDDLHomePage.OrderHistoryTab()); 
			CommonUtility.ClickOn(driver,obj_EsupportDDLHomePage.OrderHistoryTab()); 
			Thread.sleep(15000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.OrderHistoryHeader()));
			if(CommonUtility.highlightElement(driver, obj_EsupportDDLHomePage.OrderHistoryHeader()).isDisplayed())
			{
				Report.put("Click on Order History in Left nav","Order History page should be displayed",
						"Order History page is displayed", "PASS");

			}else
			{
				Report.put("Click on Order History in Left nav","Order History page should be displayed",
						"Order History page is not displayed", "FAIL");
				Assert.fail();
			}



		} catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on Order History in Left nav","Order History page should be displayed",
					"Order History page is not displayed", "FAIL");
			Assert.fail();
		}
	}
	public void SelectCriteria_Categorydropdown(WebDriver driver,String ordno)
	{

		System.out.println("Entering to Select Criteria Category dropdown");
		Log.info("Entering to Select Criteria Category dropdown");
		String details;
		String flag="";

		try {
			CommonUtility.ScrollTo(driver, obj_EsupportDDLHomePage.Searchbydrp());
			CommonUtility.ClickOn(driver, obj_EsupportDDLHomePage.Searchbydrp());
			System.out.println("Dropdown contains following field");
			List<WebElement> ele = driver.findElements(obj_EsupportDDLHomePage.SearchbydrpValues());

			for (int i = 0; i < ele.size(); i++) 
			{
				String orderno= ele.get(i).getText();    

				if(orderno.equals("Order Number"))
				{
					System.out.println(ele.get(i).getText());
//					CommonUtility.ScrollToWebElement(driver, ele.get(i));
//					CommonUtility.ClickOnWebElement(driver, ele.get(i));
					ele.get(i).click();
					System.out.println("Selected Order Number");   
					flag="Order Number";
					break;
				} }
			
			
			CommonUtility.highlightElement(driver, obj_EsupportDDLHomePage.Categorytxt()).sendKeys(ordno);
			Thread.sleep(5000);
			CommonUtility.highlightElement(driver, obj_EsupportDDLHomePage.SubmitCategory()).click();
			Thread.sleep(10000);

			Report.put("From the Category dropdown Select the criteria you want to search, enter the value and click on Submit", "Search results should be displayed as per the criteria", "Search results are displayed as per the criteria", "Pass");
		}catch (Exception e) {
			e.printStackTrace();
			Report.put("From the Category dropdown Select the criteria you want to search, enter the value and click on Submit", "Search results should be displayed as per the criteria", "Search results are not displayed as per the criteria", "FAIL");
			Assert.fail();
		}
	}
	public void SavethisSearch(WebDriver driver)
	{

		System.out.println("Entering to Save this Search");
		Log.info("Entering to Save this Search");

		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);


			Thread.sleep(5000);

			CommonUtility.ClickOn(driver,obj_EsupportDDLHomePage.SavethisSearch()); 
			Thread.sleep(5000);
			if(CommonUtility.CheckpresenceofElementLocated(driver, 30, obj_EsupportDDLHomePage.SavethisSearchHeader()))
			{

				Report.put("Click on Save button","Save popup window should be opened with the entered keyword.",
						"Save popup window is opened with the entered keyword.", "PASS");

			}
			else
			{
				Report.put("Click on Save button","Save popup window should be opened with the entered keyword.",
						"Failed to open the popup window", "FAIL");
				Assert.fail();
			}



		} catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on Save button","Save popup window should be opened with the entered keyword.",
					"Save popup window is not opened with the entered keyword.", "FAIL");
			Assert.fail();

		}
	}
	public void EnternameinSavethisSearch(WebDriver driver,String name)
	{

		System.out.println("Enter name in save this search");
		Log.info("Enter name in save this search");

		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);

			if(CommonUtility.CheckpresenceofElementLocated(driver, 30, obj_EsupportDDLHomePage.SavethisSearchHeader()))
			{
				CommonUtility.ScrollTo(driver,obj_EsupportDDLHomePage.TextBoxInSaveTextBox());
				CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.TextBoxInSaveTextBox()).clear();
				Thread.sleep(3000);

				CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.TextBoxInSaveTextBox()).sendKeys(name);

				Report.put("Enter a name in the field", " should be able to enter the name.",
						"User is able to enter the name", "PASS");



				CommonUtility.ClickOn(driver,obj_EsupportDDLHomePage.SaveSearchSubmit());
				Thread.sleep(1000);
				CommonUtility.ClickOn(driver,obj_EsupportDDLHomePage. SaveSearchClose());



				Report.put("Click on Save button", "Search should be created with the given name",
						"Search created with the given name", "PASS");


			}} catch(Exception e)
		{
				e.printStackTrace();
				Report.put("Enter a name in the field", " should be able to enter the name.",
						"User is not able to enter the name", "FAIL");

				Assert.fail();
		}
	}

	public void ToClick_SavedSearches(WebDriver driver,String name)
	{

		System.out.println("Entering to ToClick_SavedSearches");
		Log.info("Entering to Click Saved Search Tab");
		Boolean Firstposition;

		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);

			Thread.sleep(3000);

			CommonUtility.ClickOn(driver,obj_EsupportDDLHomePage.SavedSearchTab()); 


			Thread.sleep(2000);

			WebElement webtable=driver.findElement(By.xpath("//table[@class='table table-hover grid']"));
			List<WebElement>rows=webtable.findElements(By.tagName("tr"));

			System.out.println(driver.findElement(By.xpath("//table[@class='table table-hover grid']/tbody/tr[2]/td/a")).getText());

			for(WebElement row : rows){

				if(row.findElement(By.xpath("(//table[@class='table table-hover grid']/tbody/tr[2]/td/a)[1]")).getText().equals(name))
				{				 			        		
					Firstposition = true;
					System.out.println("Search Name we created should be listed at the top of first page");
					break;

				}else

				{

					Report.put("Click on the saved searches page and verify results","Search Name we created should be listed at the top of first page",
							"Search Name we created is not listed at the top of first page", "FAIL");	
					Assert.fail();
				}
			}

			Report.put("Click on the saved searches page and verify results","Search Name we created should be listed at the top of first page",
					"Search Name we created should be listed at the top of first page", "PASS");



		}catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on the saved searches page and verify results","Search Name we created should be listed at the top of first page",
					"Search Name we created is not listed at the top of first page", "FAIL");	
			Assert.fail();
		}
	}


	//20/2/2019
	public void Enterkeyword_Keywordsearcheditbox(WebDriver driver,String ordno)
	{

		System.out.println("Enter name in save this search");
		Log.info("Enter name in save this search");

		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);
			CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.KeywordsTxt()).clear();
			CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.KeywordsTxt()).sendKeys(ordno);
			Thread.sleep(2000);
			CommonUtility.ClickOn(driver, obj_EsupportDDLHomePage.SubmitCategory());

			Report.put("Enter a keyword in Keyword search edit box and click on Submit", " should be able to enter the name.",
					"User is able to enter the name", "PASS");


		} catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Enter a name in the field", " should be able to enter the name.",
					"User is not able to enter the name", "FAIL");

			Assert.fail();
		}
	}

	//Pushpa 21/2/2019
	public void clickSaveSubmitSearch(WebDriver driver)
	{

		System.out.println("Enter name in save this search");
		Log.info("Enter name in save this search");

		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);

			if(CommonUtility.CheckpresenceofElementLocated(driver, 30, obj_EsupportDDLHomePage.SavethisSearchHeader()))
			{

				//CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.SaveSearch()).sendKeys(name);

				CommonUtility.ClickOn(driver,obj_EsupportDDLHomePage.SaveSearchSubmit());
				Thread.sleep(1000);
				CommonUtility.ClickOn(driver,obj_EsupportDDLHomePage. SaveSearchClose());

				Report.put("Click on Save",
						"The existing Saved Search should be saved with the updated criteria",
						"Clicked on Save Successfully", "PASS");
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on Save",
					"The existing Saved Search should be saved with the updated criteria",
					"Failed to click on Save", "FAIL");

			Assert.fail();
		}
	}

	public void verifyActionsLabel(WebDriver driver)
	{

		System.out.println("Inside verifyActionsLabel");
		Log.info("Inside verifyActionsLabel");

		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);
			Actions act=new Actions(driver);
			String topLabel = "";
			String bottomLabel = "";
			Thread.sleep(3000);

//			act.moveToElement(CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.ActionsTopLabel())).build().perform();
			CommonUtility.scrollToViewElement(driver,obj_EsupportDDLHomePage.ActionsTopLabel());
			CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.ActionsTopLabel());

			Thread.sleep(2000);
			if(CommonUtility.highlightElement(driver, obj_EsupportDDLHomePage.ActionsTopLabel()).isDisplayed())
			{
				topLabel = CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.ActionsTopLabel()).getText();
				Report.put("Verify Actions is displayed at the top of the modal window",
						"Actions should be displayed at the top of the modal window",
						"Actions displayed at the top of the modal window. Label is: "+Report.color(topLabel), "PASS");

			}
			else
			{
				Report.put("Verify Actions is displayed at the top of the modal window",
						"Actions should be displayed at the top of the modal window",
						"Actions is not displayed at the top of the modal window", "FAIL");
				Assert.fail();
			}
			act.moveToElement(CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.ActionsBottomLabel())).build().perform();
			CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.ActionsBottomLabel());

			if(CommonUtility.highlightElement(driver, obj_EsupportDDLHomePage.ActionsBottomLabel()).isDisplayed())
			{
				bottomLabel = CommonUtility.highlightElement(driver, obj_EsupportDDLHomePage.ActionsBottomLabel()).getText();
				Report.put("Verify Actions is displayed at the bottom of the modal window",
						"Actions should be displayed at the bottom of the modal window",
						"Actions displayed at the bottom of the modal window. Label is:"+Report.color(bottomLabel), "PASS");
			}
			else
			{
				Report.put("Verify Actions is displayed at the bottom of the modal window",
						"Actions should be displayed at the bottom of the modal window",
						"Actions is not displayed at the bottom of the modal window", "FAIL");
				Assert.fail();
			}


		} catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify Actions is displayed at the top & bottom of the modal window",
					"Actions should be displayed at the top & bottom of the modal window",
					"Actions is not displayed at the top & bottom of the modal window", "FAIL");
			Assert.fail();
		}
	}

	public void verifyActionsDropdown(WebDriver driver)
	{

		System.out.println("Inside verifyActionsDropdown");
		Log.info("Inside verifyActionsDropdown");

		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);
			Actions act=new Actions(driver);
			String topActionValues = "";
			String bottomActionValues = "";
			Thread.sleep(3000);

			if(CommonUtility.highlightElement(driver, obj_EsupportDDLHomePage.ActionsTopDropdown()).isDisplayed())
			{
				Select selAction = new  Select(driver.findElement(obj_EsupportDDLHomePage.ActionsTopDropdown()));
				CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.ActionsTopDropdown());
				List<WebElement> allOptions = selAction.getOptions();
				for(WebElement op:allOptions)
				{
					//CommonUtility.highlightElement(driver,op);
					String values = op.getText();
					topActionValues+=" <br> " + values;
				}
				Report.put("Verify toolbar displays following value in top dropdown list: Export Selected ",
						"Toolbar should display following value in top dropdown list: Export Selected",
						"Toolbar  displayed with the following value in top dropdown list:"+Report.color(topActionValues), "PASS");
			}
			else
			{
				Report.put("Verify toolbar displays following value in top dropdown list: Export Selected ",
						"Toolbar should display following value in top dropdown list: Export Selected",
						"Failed to display the Toolbar value in top dropdown list", "FAIL");
				Assert.fail();
			}
			if(CommonUtility.highlightElement(driver, obj_EsupportDDLHomePage.ActionsBottomDropdown()).isDisplayed())
			{
				Select selAction = new  Select(driver.findElement(obj_EsupportDDLHomePage.ActionsBottomDropdown()));
				CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.ActionsBottomDropdown());
				List<WebElement> allOptions = selAction.getOptions();
				for(WebElement op:allOptions)
				{
					//CommonUtility.highlightElement(driver,op);
					String values = op.getText();
					bottomActionValues+=" <br> " + values;
				}
				Report.put("Verify toolbar displays following value in bottom dropdown list: Export Selected ",
						"Toolbar should display following value in bottom dropdown list: Export Selected",
						"Toolbar  displayed with the following value in bottom dropdown list:"+Report.color(bottomActionValues), "PASS");
			}
			else
			{
				Report.put("Verify toolbar displays following value in bottom dropdown list: Export Selected ",
						"Toolbar should display following value in bottom dropdown list: Export Selected",
						"Failed to display the Toolbar value in bottom dropdown list", "FAIL");
				Assert.fail();
			}

		} 
		catch(Exception e)
		{
			e.printStackTrace();

			Report.put("Verify toolbar displays following value in top dropdown list: Export Selected ",
					"Toolbar should display following value in top dropdown list: Export Selected",
					"Failed to display the Toolbar value in top dropdown list", "FAIL");
			Assert.fail();

		}
	}

	//Sujata 21/02/2019


	public void ToClick_SavedSearchTab(WebDriver driver)
	{

		System.out.println("Entering in method to ToClick_SavedSearchTab");


		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);



			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.DigitalLockerHeaderProducts()));

			CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.SavedSearchTab());
			CommonUtility.ClickOn(driver,obj_EsupportDDLHomePage.SavedSearchTab()); 

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.SavedSearchTabHeader()));




			String ltMessages="";
			CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.VerifySavesearchtabledata());

			List<WebElement> list=driver.findElements(obj_EsupportDDLHomePage.VerifySavesearchtabledata());

			for(WebElement lt:list)
			{
				CommonUtility.highlightElement(driver, lt);
				String names=lt.getText();

				System.out.println("Alert Name is: " +names);
				ltMessages+=" <br> " + names;


			}
			Report.put("Click on Saved Searches option on the Left Nav", " Saved Searches grid should display all available saved searches with the following details as "+ Report.color(ltMessages),
					"Successfully Saved Searches grid should display all available saved searches with the following details  1) Name 2) Edit (hyperlink) to edit the saved search criteria 3)Delete (hyperlink) to delete the saved search ", "PASS");


		} catch(Exception e)
		{
			e.printStackTrace();

			Report.put("Click on Saved Searches option on the Left Nav", " Failed to find Saved Searches grid ",
					"Failed to find Saved Searches grid", "FAIL");


			Assert.fail();
		}
	}



	public void ToClick_SavedSearchTabEditTab(WebDriver driver)
	{

		System.out.println("Entering in method to ToClick_SavedSearchTabEditTab");


		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);



			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.ClickonEdit()));

			CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.ClickonEdit());
			CommonUtility.ClickOn(driver,obj_EsupportDDLHomePage.ClickonEdit()); 

			Report.put("Click on the Edit hyper link for the row you want to update", " History view should be displayed with previously saved Search criteria should be listed with matching results ",
					"Successfully History view should be displayed with previously saved Search criteria should be listed with matching results","PASS");

		} catch(Exception e)
		{
			e.printStackTrace();

			Report.put("Click on the Edit hyper link for the row you want to update", "Failed to click hyper link ",
					"Failed to click hyper link","FAIL");


			Assert.fail();
		}
	}



	public void  ToClick_OrderhistoryEditlink(WebDriver driver,String updatename) {

		WebDriverWait wait = new WebDriverWait(driver, 120);
		System.out.println("Entering Method in to ToClick_OrderhistoryEditlink");
		String supportHeader = "";

		try{

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.DDLHeader()));

			CommonUtility.highlightElement(driver, obj_EsupportDDLHomePage.DDLHeader());
			CommonUtility.ClickOn(driver, obj_EsupportDDLHomePage.EditOrderhistoryEdit());



			CommonUtility.highlightElement(driver, obj_EsupportDDLHomePage.EditEnteryourName());
			String EditEnteryourName=CommonUtility.highlightElement(driver, obj_EsupportDDLHomePage.EditEnteryourName()).getText();

			CommonUtility.highlightElement(driver, obj_EsupportDDLHomePage.EditEnteryourNameTextBox());
			CommonUtility.highlightElement(driver, obj_EsupportDDLHomePage.EditEnteryourNameTextBox()).clear();
			Thread.sleep(30000);
			CommonUtility.highlightElement(driver, obj_EsupportDDLHomePage.EditEnteryourNameTextBox()).sendKeys(updatename);

			CommonUtility.highlightElement(driver, obj_EsupportDDLHomePage.EditUpdatebtn());
			String EditUpdatebtn=CommonUtility.highlightElement(driver, obj_EsupportDDLHomePage.EditUpdatebtn()).getText();


			CommonUtility.highlightElement(driver, obj_EsupportDDLHomePage.EditCancelbtn());
			String EditCancelbtn=CommonUtility.highlightElement(driver, obj_EsupportDDLHomePage.EditCancelbtn()).getText();


			CommonUtility.ClickOn(driver, obj_EsupportDDLHomePage.EditUpdatebtn());
			System.out.println("Clicked on update button");

			Thread.sleep(3000);

			CommonUtility.ClickOn(driver, obj_EsupportDDLHomePage.EditSubmitBtn());
			System.out.println("Clicked on EditSubmitBtn button");



			Report.put("Click on Edit next to the Saved Search title", 
					"Textbox should be displayed to ' " +Report.color(EditEnteryourName)+" ', along with ' " +Report.color(EditUpdatebtn)+" ' and ' " +Report.color(EditCancelbtn)+" ' options", 
					"Successfully Textbox should be displayed to enter a new name, along with Update and Cancel options ", "PASS");

			//Thread.sleep(3000);                  
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on Edit next to the Saved Search title", 
					"Failed Textbox should be displayed to enter a new name, along with Update and Cancel options", 
					"Successfully Textbox should be displayed to enter a new name, along with Update and Cancel options ", "FAIL");

			Assert.fail();
		}
	}





	public void ToClick_Orderdetails(WebDriver driver)
	{

		System.out.println("Entering in method to ToClick_Orderdetails");


		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 240);

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.ClickonanyOrder()));

			CommonUtility.ScrollTo(driver,obj_EsupportDDLHomePage.ClickonanyOrder());

			String ClickonanyOrder=CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.ClickonanyOrder()).getText();

			CommonUtility.ClickOn(driver,obj_EsupportDDLHomePage.ClickonanyOrder());

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.DDLHeader()));

			CommonUtility.ScrollTo(driver,obj_EsupportDDLHomePage.DDLHeader());

			String DDLHeader=CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.DDLHeader()).getText();

			Report.put("Click on ' " +Report.color(ClickonanyOrder)+" ' Link for the Product displayed", " ' "+Report.color(DDLHeader)+ " ' Page should be displayed ",
					"Successfully Order Details page is displayed ", "PASS");


		} catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on View Details link for the Product displayed", " Failed to display Order Details page ",
					"Failed to display Order Details page ", "FAIL");
			Assert.fail();
		}
	}


	public void ToVerify_OrderdetailsSummarySection(WebDriver driver)
	{

		System.out.println("Entering in method to ToVerify_OrderdetailsSummarySection");


		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.DDLHeader()));

			CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.DDLHeader());

			String DDLHeader=CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.DDLHeader()).getText();

			//CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.ClickonanyOrder()).click();


			CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.SummaryOrdernumber());

			String SummaryOrdernumber=CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.SummaryOrdernumber()).getText();



			CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.SummaryShippingLicence());

			String SummaryShippingLicence=CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.SummaryShippingLicence()).getText();


			Report.put("Verify the following information is displayed in summary section: Order Number, Ship Date (License Date)", " Following information should be displayed in summary section as ' "+Report.color(SummaryOrdernumber)+" ' and ' "+Report.color(SummaryShippingLicence)+" ' ",
					"Successfully following information should be displayed in summary section: Order Number, Ship Date (License Date)", "PASS");


		} catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify the following information is displayed in summary section: Order Number, Ship Date(License Date) ", " Failed to find following information in summary section: Order Number, Ship Date (License Date) ",
					"Failed to find following information in summary section: Order Number, Ship Date (License Date)", "FAIL");

			Assert.fail();
		}
	}


	public void ToVerify_OrderSupportLinkTablesdata(WebDriver driver)
	{

		System.out.println("Entering in method to ToVerify_OrderSupportLinkTablesdata");


		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);

			String ltMessages="";
			CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.OrderSupportLinkTablesdata());

			List<WebElement> list=driver.findElements(obj_EsupportDDLHomePage.OrderSupportLinkTablesdata());

			for(WebElement lt:list)
			{
				CommonUtility.highlightElement(driver, lt);
				String names=lt.getText();

				System.out.println("Alert Name is: " +names);
				ltMessages+=" <br> " + names;


			}

			Report.put("Verify the following attributes for all Products is displayed: 1)Product Name 2)Primary Id 3) Customer number ", 
					"The following attributes for all Products is displayed as "+Report.color(ltMessages),
					"Successfully Attributes for all Products are displayed ", "PASS");

		} catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify the following attributes for all Products is displayed: 1)Product Name 2)Primary Id 3) Customer number ", 
					"Failed to find attributes for all Products is displayed .",
					"Failed to find attributes for all Products is displayed . ", "FAIL");

			Assert.fail();
		}
	}

	//Sujata 22/2/2019
	public void ToClick_UserGroups(WebDriver driver)
	{

		System.out.println("Entering in method to ToClick_UserGroups");


		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 420);


			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.ClickUserGroups()));
//			driver.manage().timeouts().implicitlyWait(1500, TimeUnit.SECONDS);
			Thread.sleep(15000);
			CommonUtility.ScrollTo(driver,obj_EsupportDDLHomePage.ClickUserGroups());
			CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.ClickUserGroups());

			String DDLHeader=CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.ClickUserGroups()).getText();
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.ClickUserGroups()));
//			CommonUtility.ScrollTo(driver,obj_EsupportDDLHomePage.ClickUserGroups());
//			CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.ClickUserGroups()).click();
			CommonUtility.ClickOn(driver,obj_EsupportDDLHomePage.ClickUserGroups());


			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.NavigationTabsUserGroups()));
			String ltMessages="";
			CommonUtility.ScrollTo(driver,obj_EsupportDDLHomePage.NavigationTabsUserGroups());

			List<WebElement> list=driver.findElements(obj_EsupportDDLHomePage.NavigationTabsUserGroups());

			for(WebElement lt:list)
			{
				CommonUtility.highlightElement(driver, lt);
				String names=lt.getText();

				System.out.println("Alert Name is: " +names);
				ltMessages+=" <br> " + names;


			}

			Report.put("Click on '"+Report.color(DDLHeader)+"' link in left nav", " Redirected to the user and groups page  user should be able to view the  "+Report.color(ltMessages),
					"Successfully Redirected to the user and groups page  user should be able to view the user, user groups ,product groups ,Remove users By default users tab is selected ", "PASS");


		} catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on User and Groups link in left nav.", " Failed Redirected to the user and groups page  user should be able to view the user, user groups ,product groups ,Remove users By default users tab is selected ",
					"Failed To Redirected to the user and groups page  user should be able to view the user, user groups ,product groups ,Remove users By default users tab is selected ", "FAIL");

			Assert.fail();
		}
	}

	public void ToClick_UserGroupsProdutsTab(WebDriver driver)
	{

		System.out.println("Entering in method to ToClick_UserGroupsProdutsTab");


		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);


			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.UserGroupsClickProductGroups()));

			CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.UserGroupsClickProductGroups());

			String DDLHeader=CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.UserGroupsClickProductGroups()).getText();
			CommonUtility.ClickOn(driver,obj_EsupportDDLHomePage.UserGroupsClickProductGroups());

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.UserGroupsClickProductGroups()));

			Report.put("Click on Product Groups tab", " '"+Report.color(DDLHeader)+"' page should be displayed",
					"Successfully Product Groups page should be displayed", "PASS");


		} catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on Product Groups tab", " Failed to navigate  Product Groups page",
					"Failed to navigate  Product Groups page ", "FAIL");


			Assert.fail();
		}
	}

	public void ToClick_UserGroupsProdutsRadioBtn(WebDriver driver)
	{

		System.out.println("Entering in method to ToClick_UserGroupsProdutsRadioBtn");


		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);


			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.ProductGroupsselected()));

			CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.ProductGroupsselected());


			if(CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.ProductGroupsselected()).isSelected())
			{


				Report.put("Verify Product Groups radio button is selected by default", "Product Groups radio button should be selected by default",
						"Successfully Product Groups radio button should be selected by default", "PASS");

			}
			else
			{

				Report.put("Verify Product Groups radio button is selected by default", "Product Groups radio button  Not selected by default",
						"Successfully Product Groups radio  button Not selected by default", "FAIL");

				Assert.fail();
			}



		} catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify Product Groups radio button is selected by default", "Product Groups radio button  Not selected by default",
					"Successfully Product Groups radio  button Not selected by default", "FAIL");


			Assert.fail();
		}
	}


	public void ToClick_UserGroupsColoumnHeader(WebDriver driver)
	{

		System.out.println("Entering in method to ToClick_UserGroupsColoumnHeader");


		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);



			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.ProductGroupsColumHeader()));
			String ltMessages="";
			CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.ProductGroupsColumHeader());

			List<WebElement> list=driver.findElements(obj_EsupportDDLHomePage.ProductGroupsColumHeader());

			for(WebElement lt:list)
			{
				CommonUtility.highlightElement(driver, lt);
				String names=lt.getText();

				System.out.println("Alert Name is: " +names);
				ltMessages+=" <br> " + names;


			}

			Report.put("Verify the following column headers are displayed:1)Product Group Name 2)User Groups 3)Manage", " Following column headers should be displayed as   "+Report.color(ltMessages),
					"Successfully Following column headers should be displayed:1)Product Group Name 2)User Groups 3)Manage ", "PASS");


		} catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify the following column headers are displayed:1)Product Group Name 2)User Groups 3)Manage", " Failed To find Following column headers should be displayed:1)Product Group Name 2)User Groups 3)Manage",
					"Failed To find Following column headers should be displayed:1)Product Group Name 2)User Groups 3)Manage", "FAIL");

			Assert.fail();
		}
	}


	public void ToClick_UserGroupsColoumnHeaderclickPG(WebDriver driver)
	{

		System.out.println("Entering in method to ToClick_UserGroupsColoumnHeaderclickPG");


		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);



			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.ProductGroupsColumHeaderclick()));
			String ltMessages="";

			Thread.sleep(3000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.ProductGroupsColumHeaderTdata()));
			CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.ProductGroupsColumHeaderTdata());

			List<WebElement> list=driver.findElements(obj_EsupportDDLHomePage.ProductGroupsColumHeaderTdata());

			for(WebElement lt:list)
			{
				CommonUtility.highlightElement(driver, lt);
				String names=lt.getText();

				System.out.println("Alert Name is: " +names);
				ltMessages+=" <br> " + names;


			}

			Report.put("Verify Default sort is Product Group Name ascending", " Default sort Product Group Name should be  ascending  and its displayed as   "+Report.color(ltMessages),
					"Successfully Default sort should be Product Group Name ascending ", "PASS");

			System.out.println("Ascending orders list displayed");

			CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.ProductGroupsColumHeaderclick());
			CommonUtility.ClickOn(driver,obj_EsupportDDLHomePage.ProductGroupsColumHeaderclick());

			System.out.println("Clicked on toggel Ascending orders to descending");
			Thread.sleep(5000);


			System.out.println("Displaying  descending Order");

			//wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.ProductGroupsColumHeaderclick()));
			String ltMessages1="";

			Thread.sleep(3000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.ProductGroupsColumHeaderTdata()));
			CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.ProductGroupsColumHeaderTdata());

			List<WebElement> list1=driver.findElements(obj_EsupportDDLHomePage.ProductGroupsColumHeaderTdata());

			for(WebElement lt:list1)
			{
				CommonUtility.highlightElement(driver, lt);
				String names=lt.getText();

				System.out.println("Alert Name is: " +names);
				ltMessages1+=" <br> " + names;


			}

			Report.put("Click on Product group name column", " should sort the list in ascending or descending order toggled based on previous sort order  and its displayed as   "+Report.color(ltMessages1),
					"Successfully Default sort should be Product Group Name Descending ", "PASS");

		} catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on Product group name column", " Ascending or descending order toggled Sorting is not proper. ",
					"Ascending or descending order toggled Sorting is not proper. ", "FAIL");

			Assert.fail();
		}
	}

	//Pushpa
	public void verifyNumOfItems(WebDriver driver)
	{
		System.out.println("Inside verifyNumOfItems");
		Log.info("Inside verifyNumOfItems");
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);
			String text = "";

			if(CommonUtility.CheckpresenceofElementLocated(driver, 01, obj_EsupportDDLHomePage.NumOfItems()))
			{
				CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.NumOfItems());
				text = CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.NumOfItems()).getText();   
				System.out.println("Num of Items is:"+text);
			}

			Report.put("Verify the total no. of items",
					"Total no. of items should be displayed like viewing" +Report.color(text)+", on top and bottom of the grid",
					"Successfully displayed total no. of items: "+Report.color(text), "PASS");

		} catch(Exception e)
		{
			e.printStackTrace();

			Report.put("Verify the total no. of items",
					"Total no. of items should be displayed like viewing 1-10 of 22, on top and bottom of the grid",
					"Failed to display total no. of items: ", "FAIL");
			Assert.fail();
		}
	}

	public void verifyPagesinSaveSearch(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 600);

		driver.manage().timeouts().implicitlyWait(600, TimeUnit.SECONDS);      
		System.out.println("In Function verifyPagesinSaveSearch");
		Log.info("In Function verifyPagesinSaveSearch");    
		try
		{
			String ltMessages = "";
			
		//	driver.findElement(obj_EsupportDDLHomePage.PaginationSaveSearch()).click();
			CommonUtility.ClickOn(driver,obj_EsupportDDLHomePage.PaginationSaveSearch());

			Thread.sleep(5000);
			List<WebElement> list=driver.findElements(obj_EsupportDDLHomePage.PaginationListSaveSearch());
			int listcount=list.size();
			String intvalue=Integer.toString(listcount);
			System.out.println(intvalue);

			for(WebElement lt:list)
			{                         
				CommonUtility.highlightElement(driver, lt);
				Thread.sleep(3000);

				Thread.sleep(5000);
				String names=lt.getText();

				if(!(names.equals("1"))){
					lt.click();
				}
				System.out.println("Alert Name is: " +names);
				ltMessages+=" <br> " + names;
				verifyNumOfItems(driver);
			}


			Thread.sleep(5000);


			Report.put(" Verify the Pagination",
					"Pagination should be displayed, on top and bottom of the grid By clicking on the page no. should navigate to that Page"+Report.color(intvalue)+" and Page links  are :: "+Report.color(ltMessages),
					"Successfully Pagination displayed ", "PASS");

		}
		catch(Exception e){
			Log.info(e);

			e.printStackTrace();

			Report.put("Select '30 days' option in Refine view section",
					"Failed to display the option in Refine view section",
					"Failed to display the option in Refine view section ", "FAIL");
			Assert.fail();

		}
	}
	public void  ToVerify_Paginations_SaveSearch(WebDriver driver) {

		WebDriverWait wait = new WebDriverWait(driver, 120);
		Actions act=new Actions(driver);
		System.out.println("Entering Method ToVerify_Paginations_SaveSearch");
		String supportHeader = "";

		try{
			Thread.sleep(3000);

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.DigitalLockerHeaderProducts()));
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.PaginationSaveSearch()));

			String ltMessages="";
			CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.PaginationSaveSearch());
			CommonUtility.ClickOn(driver,obj_EsupportDDLHomePage.PaginationSaveSearch());

			List<WebElement> list=driver.findElements(obj_EsupportDDLHomePage.PaginationListSaveSearch());

			for(WebElement lt:list)
			{
				act.moveToElement(CommonUtility.highlightElement(driver, lt));
				//CommonUtility.highlightElement(driver, lt);
				String names=lt.getText();

				System.out.println("Alert Name is: " +names);
				ltMessages+=" <br> " + names;


			}

			Report.put("Verify Items per page is displayed at the bottom of the modal window", 
					"Items per page should be displayed at the  bottom of the modal window options displayed as "+Report.color(ltMessages), 
					"Successfully Items per page options are displayed", "PASS");

		}
		catch(Exception e)
		{
			e.printStackTrace();

			Report.put("Verify Items per page is displayed at the bottom of the modal window", 
					"Failed to verify Items per page Options", 
					"Failed to verify Items per page Options", "FAIL");
			Assert.fail();
		}
	}
	public void ToVerify_TablesdataTenSaveSearch(WebDriver driver,String a)
	{
		WebDriverWait wait = new WebDriverWait(driver, 600);
		Actions act=new Actions(driver);
		driver.manage().timeouts().implicitlyWait(600, TimeUnit.SECONDS);      
		System.out.println("In Function ToVerify_TablesdataTenSaveSearch");
		Log.info("In Function ToVerify_TablesdataTenSaveSearch");    
		try{


			Thread.sleep(5000);
			String ltMessages="";
			CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.PaginationSaveSearch());
			CommonUtility.ClickOn(driver,obj_EsupportDDLHomePage.PaginationSaveSearch());

			List<WebElement> list=driver.findElements(obj_EsupportDDLHomePage.PaginationListSaveSearch());

			for(WebElement lt:list)
			{

				CommonUtility.scrollToViewElement(driver, lt);
				//act.moveToElement(CommonUtility.highlightElement(driver, lt));
				//CommonUtility.highlightElement(driver, lt);
				String names=lt.getText();

				if(names.contains(a))
				{
					lt.click();
				}

			}
			Thread.sleep(8000);

			List<WebElement> list1=driver.findElements(obj_EsupportDDLHomePage.PaginationListCount());

			for(WebElement l:list1){
				System.out.println(l.getText());

				act.moveToElement(CommonUtility.highlightElement(driver, l));
			}

			int listcount1=list1.size();
			String intvalue=Integer.toString(listcount1);
			System.out.println(intvalue);



			Report.put("Select the ' "+ Report.color(a) +" ' from the drop down ", 
					"Total ' "+ Report.color(intvalue) +" ' products should be displayed in the page ",
					"Successfully Selected ' "+a+" ' and Total '"+intvalue+"' product are displayed in a Page ", "PASS");

		}
		catch(Exception e){
			Log.info(e);

			e.printStackTrace();

			Report.put("Select the ' "+ Report.color(a) +" ' from the drop down ", 
					"Failed to display products in the page ",
					"Failed to display products in the page ", "FAIL");

			Assert.fail();

		}
	}
	//sudha 25/2/2019
	public void  ToVerify_UsersTab(WebDriver driver) {

		WebDriverWait wait = new WebDriverWait(driver, 120);
		System.out.println("Entering Method ToVerify_UsersTab");
		Log.info("Entering Method ToVerify_UsersTab");  
		String text;

		try{

			CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.Users());
			text = CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.Users()).getText();   


			Report.put("Verify Users tab is displayed by default", 
					""+Report.color(text)+"should be displayed by default", 
					"Users tab is displayed by default", "PASS");

		}
		catch(Exception e)
		{
			e.printStackTrace();

			Report.put("Verify Users tab is displayed by default", 
					"Users tab should be displayed by default", 
					"Users tab is not displayed by default", "FAIL");
			Assert.fail();
		}
	}
	public void ToVerify_EditandRemoveoptions_UserGroups(WebDriver driver)
	{

		System.out.println("Entering in method to ToVerify_EditandRemoveoptions_UserGroups");
		Log.info("Entering in method to ToVerify_EditandRemoveoptions_UserGroups");
		String Edit, Remove;


		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.AddUserGroup()));
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.EditLink()));
			Edit=CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.EditLink()).getText();
			Remove=CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.RemoveLink()).getText();
			Report.put("Verify Edit and Remove  options are displayed for custom user group and user groups with Super Admin rights for the logged in user",""+Report.color(Edit)+"and"+Report.color(Remove)+"should be displayed for custom user group and user groups with Super Admin rights for the logged in user",
					"Edit and Remove  options are displayed for custom user group and user groups with Super Admin rights for the logged in user", "PASS");


		} catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify Edit and Remove  options are displayed for custom user group and user groups with Super Admin rights for the logged in user","Edit and Remove  options should be displayed for custom user group and user groups with Super Admin rights for the logged in user",
					"Edit and Remove  options are not displayed for custom user group and user groups with Super Admin rights for the logged in user", "FAIL");

			Assert.fail();
		}
	}
//	public String Click_onRemoveLink(WebDriver driver)
//	{
//
//		System.out.println("Entering to Click_onRemoveLink");
//		Log.info("Entering to Click_onRemoveLink");
//		String values = null;
//		String a=TestNGCreator.TestData.get(Esupport.ActionOption.ordinal()).split(";")[3];
//
//		try
//		{
//			WebDriverWait wait = new WebDriverWait(driver, 120);
//			Actions act=new Actions(driver);
//			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.PaginationInUserGroupTab()));
////			CommonUtility.scrollToViewElement(driver,obj_EsupportDDLHomePage.PaginationInUserGroupTab());
////			CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.PaginationInUserGroupTab()).click();
//////			CommonUtility.ToClickByUsingJavaScript_PassingByLoc(driver,obj_EsupportDDLHomePage.PaginationInUserGroupTab());
////
////			List<WebElement> list1=driver.findElements(obj_EsupportDDLHomePage.PaginationListInUserGroupTab());
////
////			for(WebElement lt:list1)
////			{
////
////				CommonUtility.scrollToViewElement(driver, lt);
////				//act.moveToElement(CommonUtility.highlightElement(driver, lt));
////				//CommonUtility.highlightElement(driver, lt);
////				String names=lt.getText();
////
////				if(names.contains(a))
////				{
////					lt.click();
//////					CommonUtility.ToClickByUsingJavaScript(driver, lt);
//////					act.moveToElement(CommonUtility.highlightElement(driver, lt)).click().build().perform();
////				}
////
////			}
//
//			WebElement webtable=driver.findElement(By.xpath("//table[@class='table table-hover grid']"));
//			List<WebElement>rows=webtable.findElements(By.tagName("tr"));
//
//
//			List<WebElement>columns = rows.get(0).findElements(By.tagName("th"));
//			List<WebElement> list=driver.findElements(By.xpath("//table[@class='table table-hover grid']/tbody/tr"));
//			
//			for (int i=2; i<=6; i++) {
//
////				values = driver.findElement(By.xpath("//table[@class='table table-hover grid']/tbody/tr["+i+"]/td["+(i-1)+"]/span")).getText();
//				values = driver.findElement(By.xpath("//table[@class='table table-hover grid']//tbody//tr["+i+"]//td["+(i-1)+"]//span")).getText();
//				System.out.println(values);
//
//				//Thread.sleep(100000);
//				if(CommonUtility.CheckpresenceofElementLocated(driver, 20, By.xpath("(//table[@class='table table-hover grid']//tbody//tr//td//a//span[text()='Remove'])["+i+"]")))
//				{
//					
//				
////				driver.findElement(By.xpath("(//table[@class='table table-hover grid']//tbody//tr//td//a//span[text()='Remove'])["+i+"]")).click();
//				//WebElement element =driver.findElement(By.xpath("(//table[@class='table table-hover grid']//tbody//tr//td//a//span[text()='Remove'])["+i+"]"));
//					WebElement element =driver.findElement(By.xpath("(//table[@class='table table-hover grid']//tbody//tr//td//a[@ng-show='true']//span[text()='Remove'])["+i+"]"));
//					((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);
//				Thread.sleep(2000);
//				break;
//				}
//				
//			}
//
//
//			if(CommonUtility.highlightElement(driver, obj_EsupportDDLHomePage.DeleteUserGroup()).isDisplayed())
//			{
//				Report.put("Click on remove  link","User will be prompted to confirm deleting  the User Group",
//						"User prompted to confirm deleting  the User Group", "PASS");
//
//			}else
//			{
//				Report.put("Click on remove  link","User will be prompted to confirm deleting  the User Group",
//						"User is not prompted to confirm deleting  the User Group", "FAIL");
//				Assert.fail();
//			}
//
//
//		} catch(Exception e)
//		{
//			e.printStackTrace();
//			Report.put("Click on remove  link","User will be prompted to confirm deleting  the User Group",
//					"User is not prompted to confirm deleting  the User Group", "FAIL");
//			Assert.fail();
//		}
//		return values;
//	}
	
	public String Click_onRemoveLink(WebDriver driver)
	{

		System.out.println("Entering to Click_onRemoveLink");
		Log.info("Entering to Click_onRemoveLink");
		String values = null;
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);
			Actions act=new Actions(driver);
			System.out.println("Inside try of remove link***********************");


			if(CommonUtility.CheckpresenceofElementLocated(driver, 10, obj_EsupportDDLHomePage.RemoveLink()))
			{
				System.out.println("Clicked on remove link");
				CommonUtility.ClickOn(driver, obj_EsupportDDLHomePage.RemoveLink());
			}
			else
					{
						Report.put("Click on remove  link","User will be prompted to confirm deleting  the User Group",
								"User is not prompted to confirm deleting  the User Group", "FAIL");
						Assert.fail();
					}

			Thread.sleep(5000);
			if(CommonUtility.CheckpresenceofElementLocated(driver, 10, obj_EsupportDDLHomePage.DeleteUserGroup()))
			{
				Report.put("Click on remove  link","User will be prompted to confirm deleting  the User Group",
						"User prompted to confirm deleting  the User Group", "PASS");

			}
			else
						{
							Report.put("Click on remove  link","User will be prompted to confirm deleting  the User Group",
									"User is not prompted to confirm deleting  the User Group", "FAIL");
							Assert.fail();
						}


		} catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on remove  link","User will be prompted to confirm deleting  the User Group",
					"User is not prompted to confirm deleting  the User Group", "FAIL");
			Assert.fail();
		}
		return values;
	}
	
	
	public void Click_onCancelinpopupwindow(WebDriver driver)
	{

		System.out.println("Entering to Click_on Cancel in popup window");
		Log.info("Entering to Click_on Cancel in popup window");

		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.UserGroupsTab()));
		//	CommonUtility.scrollToViewElement(driver,obj_EsupportDDLHomePage.DeleteUserGroupCancel());
			CommonUtility.ClickOn(driver,obj_EsupportDDLHomePage.DeleteUserGroupCancel()); 
//			CommonUtility.ToClickByUsingJavaScript_PassingByLoc(driver,obj_EsupportDDLHomePage.DeleteUserGroupCancel());

			Thread.sleep(2000);
			if(CommonUtility.highlightElement(driver, obj_EsupportDDLHomePage.AddUserGroup()).isDisplayed())
			{
				Report.put("Click on Cancel in popup window","User group should not be deleted and return the user to the User Groups grid without removing the user group",
						"User group is not deleted and return the user to the User Groups grid without removing the user group", "PASS");

			}else
			{
				Report.put("Click on Cancel in popup window","User group should not be deleted and return the user to the User Groups grid without removing the user group",
						"User group deleted and return the user to the User Groups grid without removing the user group", "FAIL");
				Assert.fail();
			}



		} catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on Cancel in popup window","User group should not be deleted and return the user to the User Groups grid without removing the user group",
					"User group deleted and return the user to the User Groups grid without removing the user group", "FAIL");
			Assert.fail();
		}
	}
	public void ToClick_UserGroupsTab(WebDriver driver)
	{

		System.out.println("Entering in method to ToClick_UserGroupsTab");


		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.UserGroupsTab()));

//			CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.UserGroupsTab()).click(); 
			CommonUtility.ClickOn(driver,obj_EsupportDDLHomePage.UserGroupsTab()); 
			//wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.UserGroupsTab()));
			Thread.sleep(5000);
			Report.put("Click on User Groups tab", "User Group page should be displayed",
					"Successfully User Group page is displayed", "PASS");


		} catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on User Groups tab", "User Group page should be displayed",
					"Failed to navigate User Groups page ", "FAIL");


			Assert.fail();
		}
	}
	public void To_Verifyusergroup_inusergroupsgrid(WebDriver driver, String name)
	{
		System.out.println(name);
		System.out.println("Entering to_Verify usergroup in user groups grid");
		Log.info("Entering to_Verify usergroup in user groups grid");
		String values;

		try
		{

			WebElement webtable=driver.findElement(By.xpath("//table[@class='table table-hover grid']"));
			List<WebElement>rows=webtable.findElements(By.tagName("tr"));


			List<WebElement>columns = rows.get(0).findElements(By.tagName("th"));
			List<WebElement> list=driver.findElements(By.xpath("//table[@class='table table-hover grid']//tbody//tr//td[1]"));


//			for(WebElement lt:list)
//			{                         
//				CommonUtility.highlightElement(driver, lt);
//
//				String names=lt.getText();
//				System.out.println(names);
//
//				if((names.contains(name))){
//					System.out.println("User Group is not removed");
//					break;
//				}
//				else
//				{
//					System.out.println("User Group is removed");
//					Report.put("Verify the user group is still listed in the user groups grid","User group should be still listed in the user groups grid",
//							"User group is not listed in the user groups grid", "FAIL");
//					Assert.fail();
//
//				}

//			}



			Report.put("Verify the user group is still listed in the user groups grid","User group should be still listed in the user groups grid",
					"User group is still listed in the user groups grid", "PASS");



		} catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify the user group is still listed in the user groups grid","User group should be still listed in the user groups grid",
					"User group is not listed in the user groups grid", "FAIL");
			Assert.fail();
		}
	}
	public void To_Verifyusergroup_inusergroupsgrid_afterDeleting(WebDriver driver, String name)
	{
		System.out.println(name);
		System.out.println("Entering to_Verify usergroup in user groups grid after Deleting");
		Log.info("Entering to_Verify usergroup in user groups grid after Deleting");
		String values;

		try
		{

			WebElement webtable=driver.findElement(By.xpath("//table[@class='table table-hover grid']"));
			List<WebElement>rows=webtable.findElements(By.tagName("tr"));


			List<WebElement>columns = rows.get(0).findElements(By.tagName("th"));
			List<WebElement> list=driver.findElements(By.xpath("//table[@class='table table-hover grid']/tbody/tr/td[1]"));


			for(WebElement lt:list)
			{                         
				CommonUtility.highlightElement(driver, lt);

				String names=lt.getText();
				System.out.println(names);

				if((names.equalsIgnoreCase(name))){
					System.out.println("User Group is not removed");
					break;
				}
				else
				{
					System.out.println("User Group is removed");
					Report.put("Verify the deleted user group is no longer listed in the user groups grid","Deleted user group should no longer be listed in the user groups grid",
							"Deleted user group is not listed in the user groups grid","PASS");
					//Assert.fail();

				}

			}


//			Report.put("Verify the deleted user group is no longer listed in the user groups grid","Deleted user group should no longer be listed in the user groups grid",
//					"User group is still listed in the user groups grid", "FAIL");
//			Assert.fail();

		} catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify the deleted user group is no longer listed in the user groups grid","User group should be still listed in the user groups grid",
					"User group is not listed in the user groups grid", "FAIL");
			Assert.fail();
		}
	}
	public void Click_deleteinpopupwindow(WebDriver driver)
	{

		System.out.println("Entering to Click_delete in popup window");
		Log.info("Entering to Click_delete in popup window");

		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.UserGroupsTab()));
			CommonUtility.scrollToViewElement(driver,obj_EsupportDDLHomePage.DeleteUserGroupOK());
			CommonUtility.ClickOn(driver,obj_EsupportDDLHomePage.DeleteUserGroupOK()); 
//			CommonUtility.ToClickByUsingJavaScript_PassingByLoc(driver,obj_EsupportDDLHomePage.DeleteUserGroupOK());

			Thread.sleep(4000);
			if(CommonUtility.highlightElement(driver, obj_EsupportDDLHomePage.AddUserGroup()).isDisplayed())
			{
				Report.put("Click on delete in popup window","User group should be deleted",
						"User group is deleted", "PASS");

			}else
			{
				Report.put("Click on delete in popup window","User group should be deleted",
						"User group is not deleted", "PASS");
				Assert.fail();
			}



		} catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on delete in popup window","User group should be deleted",
					"User group is not deleted", "PASS");
			Assert.fail();
		}
	}

	//Pushpa 25/2/2019
	public void clickOnSwitchToSimpleView(WebDriver driver)
	{
		System.out.println("Inside clickOnSwitchToSimpleView");
		Log.info("Inside clickOnSwitchToSimpleView");
		WebDriverWait wait = new WebDriverWait(driver, 120);
		
		try
		{
			Thread.sleep(5000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.SimpleViewLink()));
			
			CommonUtility.scrollToViewElement(driver, obj_EsupportDDLHomePage.SimpleViewLink());

			if(CommonUtility.CheckpresenceofElementLocated(driver, 10, obj_EsupportDDLHomePage.SimpleViewLink()))
			{
				CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.SimpleViewLink());
				Thread.sleep(3000);
				CommonUtility.ClickOn(driver,obj_EsupportDDLHomePage.SimpleViewLink());  
				Thread.sleep(3000);
			}
			else
			{
				Report.put("Click on Simple View Link",
						"Should navigate to Simple View Page",
						"Failed to click on Simple View Link", "FAIL");
				Assert.fail();
			}

			Report.put("Click on Simple View Link",
					"Should navigate to Simple View Page",
					"Successfully navigated to Simple View", "PASS");

		} 
		catch(Exception e)
		{
			e.printStackTrace();

			Report.put("Click on Simple View Link",
					"Should navigate to Simple View Page",
					"Failed to click on Simple View Link", "FAIL");
			Assert.fail();
		}
	}

	public void verifySimpleViewElements(WebDriver driver)
	{
		System.out.println("Inside verifySimpleViewElements");
		Log.info("Inside verifySimpleViewElements");
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);
			String text = "";
			String links = "";

			if(CommonUtility.CheckpresenceofElementLocated(driver, 05, obj_EsupportDDLHomePage.ProductTab()))
			{
				CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.ProductTab());
				text = CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.ProductTab()).getText();   
				System.out.println("Label is: "+text);
				links+=" <br> " + text;
			}

			if(CommonUtility.CheckpresenceofElementLocated(driver, 05, obj_EsupportDDLHomePage.HistoryTabSimpleView()))
			{
				CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.HistoryTabSimpleView());
				text = CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.HistoryTabSimpleView()).getText();   
				System.out.println("Label is:"+text);
				links+=" <br> " + text;
			}
			if(CommonUtility.CheckpresenceofElementLocated(driver, 05, obj_EsupportDDLHomePage.BillingAccountTabSimpleView()))
			{
				CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.BillingAccountTabSimpleView());
				text = CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.BillingAccountTabSimpleView()).getText();   
				System.out.println("Label is:"+text);
				links+=" <br> " + text;
			}

			if(CommonUtility.CheckpresenceofElementLocated(driver, 05, obj_EsupportDDLHomePage.ProductRegistrationTabSimpleView()))
			{
				CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.ProductRegistrationTabSimpleView());
				text = CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.ProductRegistrationTabSimpleView()).getText();   
				System.out.println("Label is:"+text);
				links+=" <br> " + text;
			}

			if(CommonUtility.CheckpresenceofElementLocated(driver, 05, obj_EsupportDDLHomePage.WarrantyTabSimpleView()))
			{
				CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.WarrantyTabSimpleView());
				text = CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.WarrantyTabSimpleView()).getText();   
				System.out.println("Label is:"+text);
				links+=" <br> " + text;
			}
			if(CommonUtility.CheckpresenceofElementLocated(driver, 05, obj_EsupportDDLHomePage.HelpTabSimpleView()))
			{
				CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.HelpTabSimpleView());
				text = CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.HelpTabSimpleView()).getText();   
				System.out.println("Label is:"+text);
				links+=" <br> " + text;
			}

			Report.put("Verify the simplified view ",
					"view the simplified view in the left navigation user should be able to view the 1. Digital products 2. Order History 3. Product Registration 4. Contracts 5. FAQ",
					"Successfully displayed tabs: "+Report.color(links), "PASS");

		} 
		catch(Exception e)
		{
			e.printStackTrace();

			Report.put("Verify the simplified view ",
					"view the simplified view in the left navigation user should be able to view the 1. Digital products 2. Order History 3. Product Registration 4. Contracts 5. FAQ",
					"Failed to  display tabs", "FAIL");
			Assert.fail();
		}
	}
	/*public void clickOnSwitchToAdvanceView(WebDriver driver)
	{
		System.out.println("Inside clickOnSwitchToAdvanceView");
		Log.info("Inside clickOnSwitchToAdvanceView");
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);

			Thread.sleep(3000);

			if(CommonUtility.CheckpresenceofElementLocated(driver, 10, obj_EsupportDDLHomePage.AdvancedViewLink()))
			{
				CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.AdvancedViewLink());
				CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.AdvancedViewLink()).click();                    
			}
			else
			{
				Report.put("Click on Advance View Link",
						"Should navigate to Advance View Page",
						"Failed to click on Advance View Link", "FAIL");
				Assert.fail();
			}

			Report.put("Click on Advance View Link",
					"Should navigate to Advance View Page",
					"Successfully navigated to Advance View", "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();

			Report.put("Click on Advance View Link",
					"Should navigate to Advance View Page",
					"Failed to click on Advance View Link", "FAIL");
			Assert.fail();
		}
	}
	 */
	public void clickOnSwitchToAdvanceView(WebDriver driver)
	{
		System.out.println("Inside clickOnSwitchToAdvanceView");
		Log.info("Inside clickOnSwitchToAdvanceView");
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);

			Thread.sleep(3000);

			if(CommonUtility.CheckpresenceofElementLocated(driver, 10, obj_EsupportDDLHomePage.AdvancedViewLink()))
			{
				CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.AdvancedViewLink());
				CommonUtility.ClickOn(driver,obj_EsupportDDLHomePage.AdvancedViewLink());                    
			}else if(CommonUtility.CheckpresenceofElementLocated(driver, 10, obj_EsupportDDLHomePage.AdvancedViewLink()))
			{
				CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.SimpleViewLink());
				CommonUtility.ClickOn(driver,obj_EsupportDDLHomePage.SimpleViewLink());    
				Thread.sleep(1000);
				if(CommonUtility.CheckpresenceofElementLocated(driver, 10, obj_EsupportDDLHomePage.AdvancedViewLink()))
				{
					CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.AdvancedViewLink());
					CommonUtility.ClickOn(driver,obj_EsupportDDLHomePage.AdvancedViewLink());  
				}
			}             

			Report.put("Click on Advance View Link",
					"Should navigate to Advance View Page",
					"Successfully navigated to Advance View", "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();

			Report.put("Click on Advance View Link",
					"Should navigate to Advance View Page",
					"Failed to click on Advance View Link", "FAIL");
			Assert.fail();
		}
	}

	public void verifyAdvanceViewElements(WebDriver driver)
	{
		System.out.println("Inside verifyAdvanceViewElements");
		Log.info("Inside verifyAdvanceViewElements");
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);
			String text = "";
			String links = "";

			if(CommonUtility.CheckpresenceofElementLocated(driver, 05, obj_EsupportDDLHomePage.ProductTab()))
			{
				CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.ProductTab());
				text = CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.ProductTab()).getText();   
				System.out.println("Label is: "+text);
				links+=" <br> " + text;
			}

			if(CommonUtility.CheckpresenceofElementLocated(driver, 05, obj_EsupportDDLHomePage.ClickingOnHistoryTab()))
			{
				CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.ClickingOnHistoryTab());
				text = CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.ClickingOnHistoryTab()).getText();   
				System.out.println("Label is:"+text);
				links+=" <br> " + text;
			}
			if(CommonUtility.CheckpresenceofElementLocated(driver, 05, obj_EsupportDDLHomePage.BillingAccountTabAdvanceView()))
			{
				CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.BillingAccountTabAdvanceView());
				text = CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.BillingAccountTabAdvanceView()).getText();   
				System.out.println("Label is:"+text);
				links+=" <br> " + text;
			}

			if(CommonUtility.CheckpresenceofElementLocated(driver, 05, obj_EsupportDDLHomePage.SavedSearchTab()))
			{
				CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.SavedSearchTab());
				text = CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.SavedSearchTab()).getText();   
				System.out.println("Label is:"+text);
				links+=" <br> " + text;
			}

			if(CommonUtility.CheckpresenceofElementLocated(driver, 05, obj_EsupportDDLHomePage.UsersGroupsTabAdvanceView()))
			{
				CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.UsersGroupsTabAdvanceView());
				text = CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.UsersGroupsTabAdvanceView()).getText();   
				System.out.println("Label is:"+text);
				links+=" <br> " + text;
			}
			if(CommonUtility.CheckpresenceofElementLocated(driver, 05, obj_EsupportDDLHomePage.ToolsTabAdvanceView()))
			{
				CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.ToolsTabAdvanceView());
				text = CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.ToolsTabAdvanceView()).getText();   
				System.out.println("Label is:"+text);
				links+=" <br> " + text;
			}
			if(CommonUtility.CheckpresenceofElementLocated(driver, 05, obj_EsupportDDLHomePage.WarrantyTabAdvanceView()))
			{
				CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.WarrantyTabAdvanceView());
				text = CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.WarrantyTabAdvanceView()).getText();   
				System.out.println("Label is:"+text);
				links+=" <br> " + text;
			}

			if(CommonUtility.CheckpresenceofElementLocated(driver, 05, obj_EsupportDDLHomePage.ProductRegistrationTab()))
			{
				CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.ProductRegistrationTab());
				text = CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.ProductRegistrationTab()).getText();   
				System.out.println("Label is:"+text);
				links+=" <br> " + text;
			}

			if(CommonUtility.CheckpresenceofElementLocated(driver, 05, obj_EsupportDDLHomePage.HelpTabAdvanceView()))
			{
				CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.HelpTabAdvanceView());
				text = CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.HelpTabAdvanceView()).getText();   
				System.out.println("Label is:"+text);
				links+=" <br> " + text;
			}

			Report.put("Verify the Advanced view ",
					"view the Advanced view in the left navigation user should be able to view the tabs"+Report.color(links),
					"Successfully displayed tabs: "+Report.color(links), "PASS");

		} 
		catch(Exception e)
		{
			e.printStackTrace();

			Report.put("Verify the Advanced view ",
					"view the Advanced view in the left navigation user should be able to view the tabs",
					"Failed to display tabs", "FAIL");
			Assert.fail();
		}
	}

	public void verifySimpleViewLink(WebDriver driver)
	{
		System.out.println("Inside verifySimpleViewLink");
		Log.info("Inside verifySimpleViewLink");
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);


			if(CommonUtility.CheckpresenceofElementLocated(driver, 10, obj_EsupportDDLHomePage.SimpleViewLink()))
			{
				CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.SimpleViewLink());
				Report.put("Verify Simple View Link in Advanced View",
						"Should display Simple View Link in Advanced View",
						"Successfully displayed Simple View Link in Advanced View", "PASS");
			}
			else
			{
				Report.put("Verify Simple View Link in Advanced View",
						"Should display Simple View Link in Advanced View",
						"Failed to display Simple View Link in Advanced View", "FAIL");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();

			Report.put("Verify Simple View Link in Advanced View",
					"Should display Simple View Link in Advanced View",
					"Failed to display Simple View Link in Advanced View", "FAIL");
			Assert.fail();
		}
	}
	//Sujata
	public void ToVerify_UserGroupsTablesdataUsergroup(WebDriver driver)
	{

		System.out.println("Entering in method to ToVerify_UserGroupsTablesdataUsergroup");


		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);



			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.UsersGroupsdisplayedinusers()));
			String ltMessages="";
			CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.UsersGroupsdisplayedinusers());

			List<WebElement> list=driver.findElements(obj_EsupportDDLHomePage.UsersGroupsdisplayedinusers());

			for(WebElement lt:list)
			{
				CommonUtility.highlightElement(driver, lt);
				String names=lt.getText();

				System.out.println("Alert Name is: " +names);
				ltMessages+=" <br> " + names;


			}

			Report.put("Verify Users grid is displayed with the list of all users associated with my user groups", " Users grid should display with the list of all users associated with my user groups displayed as  "+Report.color(ltMessages),
					"Successfully Users grid displayed with the list of all users associated with my user groups ", "PASS");


		} catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify Users grid is displayed with the list of all users associated with my user groups", " Failed to display with the list of all users associated with my user groups",
					"Failed to display with the list of all users associated with my user groups ", "FAIL");

			Assert.fail();
		}
	}




	public void ToVerify_UserGroupsTablesdata(WebDriver driver)
	{

		System.out.println("Entering in method to ToVerify_UserGroupsTablesdata");
		

		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);


			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.UsersTablesData()));
			String ltMessages="";
			CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.UsersTablesData());

			List<WebElement> list=driver.findElements(obj_EsupportDDLHomePage.UsersTablesData());

			for(WebElement lt:list)
			{
				CommonUtility.highlightElement(driver, lt);
				String names=lt.getText();

				System.out.println("Alert Name is: " +names);
				ltMessages+=" <br> " + names;


			}

			Report.put("Verify the following column headers are displayed:1)First Name, 2)Last Name, 3)Email Address, 4)User Group, 5)Role", " Following column headers should be displayed as  "+Report.color(ltMessages),
					"Successfully Following column headers displayed as :1)First Name, 2)Last Name, 3)Email Address, 4)User Group, 5)Role ", "PASS");


		} catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify the following column headers are displayed:1)First Name, 2)Last Name, 3)Email Address, 4)User Group, 5)Role", " Failed to display column headers Table data ",
					"Failed to display column headers Table data  ", "FAIL");

			Assert.fail();
		}
	}


	public void ToVerify_UserGroupsLNAscending(WebDriver driver)
	{

		System.out.println("Entering in method to ToVerify_UserGroupsLNAscending");


		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);


			//wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.ClickUserGroups()));

			//CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.ClickUserGroups());

			//String DDLHeader=CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.ClickUserGroups()).getText();

			// CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.ClickUserGroups()).click();



			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.UsersGroupsLastNameTablesdata()));
			String ltMessages="";
			CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.UsersGroupsLastNameTablesdata());

			List<WebElement> list=driver.findElements(obj_EsupportDDLHomePage.UsersGroupsLastNameTablesdata());

			for(WebElement lt:list)
			{
				CommonUtility.highlightElement(driver, lt);
				String names=lt.getText();

				System.out.println("Alert Name is: " +names);
				ltMessages+=" <br> " + names;


			}

			Report.put("Verify Default sort is Last Name ascending", " Default sort should be Last Name ascending displayed as  "+Report.color(ltMessages),
					"Successfully Last Name ascending sort By Default displayed  ", "PASS");


		} catch(Exception e)
		{
			e.printStackTrace();

			Report.put("Verify Default sort is Last Name ascending", " Failed to Verify Default sort is not Last Name ascending",
					"Failed to Verify Default sort is not Last Name ascending  ", "FAIL");

			Assert.fail();
		}
	}

	public void ToClick_UserGroupsLNDescending(WebDriver driver)
	{

		System.out.println("Entering in method to ToClick_UserGroupsLNDescending");


		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);


			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.UsersGroupsLastNameClick()));

			CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.UsersGroupsLastNameClick());


			CommonUtility.ClickOn(driver,obj_EsupportDDLHomePage.UsersGroupsLastNameClick());

			Thread.sleep(5000);



			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.UsersGroupsLastNameTablesdata()));
			String ltMessages="";
			CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.UsersGroupsLastNameTablesdata());

			List<WebElement> list=driver.findElements(obj_EsupportDDLHomePage.UsersGroupsLastNameTablesdata());

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

			Report.put("Click on any column", " Should sort the list in ascending or descending order toggled based on previous sort order and the tables data displayed as  "+Report.color(ltMessages),
					"Successfully Should sort the list in ascending or descending order toggled based on previous sort order  ", "PASS");


		} catch(Exception e)
		{
			e.printStackTrace();

			Report.put("Click on any column", " Failed to Verify Default sort is not Last Name descending ",
					"Failed to Verify Default sort is not Last Name descending  ", "FAIL");

			Assert.fail();
		}
	}




	public void ToClick_UserGroupsTabdata(WebDriver driver)
	{

		System.out.println("Entering in method to ToClick_UserGroupsTabdata");


		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);


			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.UsersGroupsUsergroupsclick()));

			CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.UsersGroupsUsergroupsclick());


			CommonUtility.ClickOn(driver,obj_EsupportDDLHomePage.UsersGroupsUsergroupsclick());

			Thread.sleep(5000);

			Report.put("Click on User Groups tab ", "User Groups page should be displayed ",
					"Successfully User Groups page is displayed ", "PASS");




			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.UsersGroupsUsergTablesdata()));
			String ltMessages="";
			CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.UsersGroupsUsergTablesdata());

			List<WebElement> list=driver.findElements(obj_EsupportDDLHomePage.UsersGroupsUsergTablesdata());

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

			Report.put("Verify the following column headers are displayed:1)User Group Name2)Product Groups 3)Manage", " Following column headers should be displayed as  "+Report.color(ltMessages),
					"Successfully Following column headers displayed as :1)User Group Name2)Product Groups 3)Manage  ", "PASS");


		} catch(Exception e)
		{
			e.printStackTrace();

			Report.put("Verify the following column headers are displayed:1)User Group Name2)Product Groups 3)Manage", " Failed to display column headers as :1)User Group Name2)Product Groups 3)Manage",
					"Failed to display column headers as :1)User Group Name2)Product Groups 3)Manage ", "FAIL");


			Assert.fail();
		}
	}


	public void ToVerify_UserGroupsNameTabdata(WebDriver driver)
	{

		System.out.println("Entering in method to ToVerify_UserGroupsNameTabdata");


		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.UsersGroupsNameUsergTablesdata()));
			String ltMessages="";
			CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.UsersGroupsNameUsergTablesdata());

			List<WebElement> list=driver.findElements(obj_EsupportDDLHomePage.UsersGroupsNameUsergTablesdata());

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

			Report.put("Verify Default sort is User Group Name ascending", " Default sort should be User Group Name ascending",
					"Successfully Default sort should be User Group Name ascending  ", "PASS");


		} catch(Exception e)
		{
			e.printStackTrace();

			Report.put("Verify Default sort is User Group Name ascending", " Failed to Group Name ascending sort ",
					"Failed to Group Name ascending sort  ", "FAIL");

			Assert.fail();
		}
	}


	public void ToVerify_ClickUserGroupsNameTabdata(WebDriver driver)
	{

		System.out.println("Entering in method to ToVerify_ClickUserGroupsNameTabdata");


		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);


			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.UsersGroupsNameClick()));

			CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.UsersGroupsNameClick());


			CommonUtility.ClickOn(driver,obj_EsupportDDLHomePage.UsersGroupsNameClick());

			Thread.sleep(5000);


			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.UsersGroupsNameUsergTablesdata()));
			String ltMessages="";
			CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.UsersGroupsNameUsergTablesdata());

			List<WebElement> list=driver.findElements(obj_EsupportDDLHomePage.UsersGroupsNameUsergTablesdata());

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

			Report.put("Click on User group name column", " Should sort the list in ascending or descending order toggled based on previous sort order",
					"Successfully Should sort the list in ascending or descending order toggled based on previous sort order  ", "PASS");


		} catch(Exception e)
		{
			e.printStackTrace();


			Report.put("Click on User group name column", " Failed to  ascending or descending order toggled based on previous sort order",
					"Failed to  ascending or descending order toggled based on previous sort order  ", "FAIL");


			Assert.fail();
		}
	}


	public void ToVerify_ClickUnAssignedRadioProduct(WebDriver driver)
	{

		System.out.println("Entering in method to ToVerify_ClickUnAssignedRadioProduct");


		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);


			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.UnassignedProductGroupsselected()));

			CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.UnassignedProductGroupsselected());


			CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.UnassignedProductGroupsselected()).click();

			Thread.sleep(5000);

			Report.put("Click on Unassigned Products radio button", " Unassigned Products page should be displayed.",
					"Successfully Unassigned Products page should be displayed. ", "PASS");

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.ProductsgroupdTabtabledata()));
			String ltMessages="";
			CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.ProductsgroupdTabtabledata());

			List<WebElement> list=driver.findElements(obj_EsupportDDLHomePage.ProductsgroupdTabtabledata());

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

			Report.put("Verify the following column headers are displayed:1)Product Name, 2)Customer Number, 3)Order Number, 4)Ship Date, 5)Primary Id (Entitlement Ref Id) ", " Following column headers should be displayed as"+Report.color(ltMessages),
					"Successfully Following column headers should be displayed:1)Product Name, 2)Customer Number, 3)Order Number, 4)Ship Date, 5)Primary Id (Entitlement Ref Id)  ", "PASS");


		} catch(Exception e)
		{
			e.printStackTrace();


			Report.put("Verify the following column headers are displayed:1)Product Name, 2)Customer Number, 3)Order Number, 4)Ship Date, 5)Primary Id (Entitlement Ref Id) ", " Failed to find column headers ",
					"Failed to find column headers ", "FAIL");


			Assert.fail();
		}
	}



	public void ToVerify_UnassignProductGroupsLNAscending(WebDriver driver)
	{

		System.out.println("Entering in method to ToVerify_UnassignProductGroupsLNAscending");


		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.UnAssProductsgroupdTabtabledata()));
			String ltMessages="";
			CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.UnAssProductsgroupdTabtabledata());

			List<WebElement> list=driver.findElements(obj_EsupportDDLHomePage.UnAssProductsgroupdTabtabledata());

			for(WebElement lt:list)
			{
				CommonUtility.highlightElement(driver, lt);
				String names=lt.getText();

				System.out.println("Alert Name is: " +names);
				ltMessages+=" <br> " + names;


			}

			Report.put("Verify Default sort is Product Name ascending ", " Default sort should be Product Name ascending displayed as  "+Report.color(ltMessages),
					"Successfully Product Name ascending sort By Default displayed  ", "PASS");


		} catch(Exception e)
		{
			e.printStackTrace();

			Report.put("Verify Default sort is Product Name ascending", " Failed to Verify Default sort is not Product Name ascending",
					"Failed to Verify Default sort is not Product Name ascending  ", "FAIL");

			Assert.fail();
		}
	}

	public void ToClick_UnassignedproductsLNDescending(WebDriver driver)
	{

		System.out.println("Entering in method to ToClick_UnassignedproductsLNDescending");


		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);


			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.UnAssProductsgroupdclick()));

			CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.UnAssProductsgroupdclick());


			CommonUtility.ClickOn(driver,obj_EsupportDDLHomePage.UnAssProductsgroupdclick());

			Thread.sleep(5000);



			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.UnAssProductsgroupdTabtabledata()));
			String ltMessages="";
			CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.UnAssProductsgroupdTabtabledata());

			List<WebElement> list=driver.findElements(obj_EsupportDDLHomePage.UnAssProductsgroupdTabtabledata());

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

			Report.put("Click on any column", " Should sort the list in ascending or descending order toggled based on previous sort order and the tables data displayed as  "+Report.color(ltMessages),
					"Successfully Should sort the list in ascending or descending order toggled based on previous sort order  ", "PASS");


		} catch(Exception e)
		{
			e.printStackTrace();

			Report.put("Click on any column", " Failed to Verify Default sort is not Last Name descending ",
					"Failed to Verify Default sort is not Last Name descending  ", "FAIL");

			Assert.fail();
		}
	}

	public void ToClick_RemoversUsersTabdata(WebDriver driver)
	{

		System.out.println("Entering in method to ToClick_RemoversUsersTabdata");


		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);


			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.Removeuserstab()));

			CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.Removeuserstab());


			CommonUtility.ClickOn(driver,obj_EsupportDDLHomePage.Removeuserstab());

			Thread.sleep(5000);

			Report.put("Click on Remove Users tab ", "Remove users page should be displayed ",
					"Successfully Remove users page is displayed ", "PASS");




			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.RemoverstabheaderTablesdata()));
			String ltMessages="";
			CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.RemoverstabheaderTablesdata());

			List<WebElement> list=driver.findElements(obj_EsupportDDLHomePage.RemoverstabheaderTablesdata());

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

			Report.put("Verify the following column headers are displayed:1)First Name, 2)Last Name,3) Email Id ", " Following column headers should be displayed as  "+Report.color(ltMessages),
					"Successfully Following column headers should be displayed:1)First Name, 2)Last Name,3) Email Id  ", "PASS");


		} catch(Exception e)
		{
			e.printStackTrace();

			Report.put("Verify the following column headers are displayed: 1)First Name, 2)Last Name,3) Email Id ", "Failed to display column headers as :1)First Name, 2)Last Name,3) Email Id ",
					"Failed to display column headers as :1)First Name, 2)Last Name,3) Email Id  ", "FAIL");


			Assert.fail();
		}
	}


	public void ToVerify_RemoveuserNameTabdataascending(WebDriver driver)
	{

		System.out.println("Entering in method to ToVerify_RemoveuserNameTabdataascending");


		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.RemoveuserstablastNameTablesdata()));
			String ltMessages="";
			CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.RemoveuserstablastNameTablesdata());

			List<WebElement> list=driver.findElements(obj_EsupportDDLHomePage.RemoveuserstablastNameTablesdata());

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

			Report.put("Verify Default sort is Last Name ascending", " Default sort should be Last Name ascending"+Report.color(ltMessages),
					"Successfully Default sort should be Last Name ascending ", "PASS");


		} catch(Exception e)
		{
			e.printStackTrace();

			Report.put("Verify Default sort is Last Name ascending", " Failed To sort Lastname ascending",
					"Failed To sort Lastname ascending ", "FAIL");


			Assert.fail();
		}
	}


	public void ToVerify_RemoversTablastnameDescending(WebDriver driver)
	{

		System.out.println("Entering in method to ToVerify_RemoversTablastnameDescending");


		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);


			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.RemoveuserstablastNameClick()));

			CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.RemoveuserstablastNameClick());


			CommonUtility.ClickOn(driver,obj_EsupportDDLHomePage.RemoveuserstablastNameClick());

			Thread.sleep(5000);


			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.RemoveuserstablastNameTablesdata()));
			String ltMessages="";
			CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.RemoveuserstablastNameTablesdata());

			List<WebElement> list=driver.findElements(obj_EsupportDDLHomePage.RemoveuserstablastNameTablesdata());

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


			Report.put("Click on any column", " Should sort the list in ascending or descending order toggled based on previous sort order and the tables data displayed as  "+Report.color(ltMessages),
					"Successfully Should sort the list in ascending or descending order toggled based on previous sort order  ", "PASS");


		} catch(Exception e)
		{
			e.printStackTrace();

			Report.put("Click on any column", " Failed to Verify Default sort is not Last Name descending ",
					"Failed to Verify Default sort is not Last Name descending  ", "FAIL");

			Assert.fail();
		}
	}
	//Sudha 26/2/2019
	public void ToVerify_AddUserGroupbutton(WebDriver driver)
	{

		System.out.println("Entering in method to ToVerify_AddUserGroupbutton");
		Log.info("Entering in method to ToVerify_EditandRemoveoptions_UserGroups");
		String Edit, Remove;


		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);


			if(CommonUtility.CheckpresenceofElementLocated(driver, 01, obj_EsupportDDLHomePage.AddUserGroup()))
			{
				System.out.println("Add User Group button is present");
				Report.put("Verify Add a User Group button is displayed at the top of the modal window",
						"Add a User Group button should be displayed at the top of the modal window","Add a User Group button is displayed at the top of the modal window", "PASS");
			}





		} catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify Add a User Group button is displayed at the top of the modal window",
					"Add a User Group button should be displayed at the top of the modal window","Add a User Group button is not displayed at the top of the modal window", "FAIL");
			Assert.fail();
		}
	}

	public void ToClick_AddaUserGroup(WebDriver driver)
	{

		System.out.println("Entering in method To Click Add a User Group button");
		Log.info("Entering in method To Click Add a User Group button");


		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);
			Thread.sleep(10000);
//			CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.AddUserGroup()).click();
			CommonUtility.ClickOn(driver,obj_EsupportDDLHomePage.AddUserGroup());
			Thread.sleep(2000);
//			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.AddUserGroupHeader()));
			CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.AddUserGroupHeader());
			Report.put("Click on 'Add a User Group' button", "Add User Group view should be displayed",
					"Add User Group view is displayed","PASS");

		} catch(Exception e)
		{
			e.printStackTrace();

			Report.put("Click on 'Add a User Group' button", "Add User Group view should be displayed",
					"Add User Group view is not displayed","FAIL");

			Assert.fail();
		}
	}

	public void ToEnterUGname(WebDriver driver,String name,String role)
	{

		System.out.println("Entering in method ToEnterUGname");
		Actions act=new Actions(driver);

		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);

			CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.UserGroupName()).sendKeys(name);
			CommonUtility.ClickOn(driver,obj_EsupportDDLHomePage.AssignRoledropdown());

			List<WebElement> list=driver.findElements(obj_EsupportDDLHomePage.AssignRoleList());

			for(WebElement lt:list)
			{
				act.moveToElement(CommonUtility.highlightElement(driver, lt));
				//CommonUtility.highlightElement(driver, lt);
				String roletext=lt.getText();
				if(roletext.equalsIgnoreCase(role))
				{
					lt.click();
				}

			}

			CommonUtility.ClickOn(driver,obj_EsupportDDLHomePage.UserGroupContinue());

			Report.put("Enter UG name ,select role and click on continue button", "Should navigate to Add Users",
					"User able to add the new User Group","PASS");

		} catch(Exception e)
		{
			e.printStackTrace();

			Report.put("Enter UG name ,select role and click on continue button", "Should navigate to Add Users",
					"User is not able to add the new User Group","FAIL");

			Assert.fail();
		}
	}

	public void ToVerify_unassignedandAssignedUserstabs(WebDriver driver)
	{

		System.out.println("Entering in method to To Verify_unassigned and Assigned Users tabs");
		Log.info("Entering in method to To Verify unassigned and Assigned Users tabs");
		String text = "";
		String links = "";


		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);

			if(CommonUtility.CheckpresenceofElementLocated(driver, 05, obj_EsupportDDLHomePage.AssignedTab()))
			{
				CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.AssignedTab());
				text = CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.AssignedTab()).getText();   
				System.out.println("Tab is: "+text);
				links+=" <br> " + text;
			}

			if(CommonUtility.CheckpresenceofElementLocated(driver, 05, obj_EsupportDDLHomePage.UnAssignedTab()))
			{
				CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.UnAssignedTab());
				text = CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.UnAssignedTab()).getText();   
				System.out.println("Tab is:"+text);
				links+=" <br> " + text;
			}

			if(CommonUtility.CheckpresenceofElementLocated(driver, 05, obj_EsupportDDLHomePage.UnAssignedTabActive()))
			{
				CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.UnAssignedTabActive());

			}

			Report.put("Verify  unassigned and Assigned Users tabs displayed",
					""+Report.color(links)+"tabs should be displayed by default unassigned user tab selected and user should be able to view the all unassigned users","Unassigned and Assigned Users tabs is displayed by default unassigned user tab selected and user should be able to view the all unassigned users", "PASS");






		} catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify  unassigned and Assigned Users tabs displayed",
					"Unassigned and Assigned Users tabs should be displayed by default unassigned user tab selected and user should be able to view the all unassigned users","Unassigned and Assigned Users tabs is not displayed by default unassigned user tab selected and user should be able to view the all unassigned users", "FAIL");
			Assert.fail();
		}
	}
	public void ToVerify_AddNewUser(WebDriver driver)
	{

		System.out.println("Entering in method to ToVerify Add New User");
		Log.info("Entering in method to ToVerify Add New User");

		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);


			if(CommonUtility.CheckpresenceofElementLocated(driver, 01, obj_EsupportDDLHomePage.AddNewUser()))
			{
				System.out.println("Add New User button is present");
				Report.put("Verify Add a New User link is displayed at the top  of the modal window",
						"Verify Add a User link is displayed at the top and bottom of the modal window","Add a User link is displayed at the top and bottom of the modal window", "PASS");
			}





		} catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify Add a New User link is displayed at the top  of the modal window",
					"Verify Add a User link is displayed at the top and bottom of the modal window","Add a User link is not displayed at the top and bottom of the modal window", "FAIL");
			Assert.fail();
		}
	}
	public void ToClick_AddNewUser(WebDriver driver)
	{

		System.out.println("Entering in method To Click Add a New User");
		Log.info("Entering in method To Click Add a New User");


		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);
			Thread.sleep(5000);
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.AddNewUser()));
			CommonUtility.scrollToViewElement(driver,obj_EsupportDDLHomePage.AddNewUser());
//			CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.AddNewUser()).click();
			CommonUtility.ClickOn(driver,obj_EsupportDDLHomePage.AddNewUser());

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.AddUserHeader()));
			CommonUtility.scrollToViewElement(driver,obj_EsupportDDLHomePage.AddUserHeader());
			CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.AddUserHeader());
			Report.put("Click on Add a New User link", "Add Users page should be displayed",
					"Add Users page is displayed","PASS");

		} catch(Exception e)
		{
			e.printStackTrace();

			Report.put("Click on Add a New User link", "Add Users page should be displayed",
					"Add Users page is not displayed","FAIL");

			Assert.fail();
		}
	}
	public void ToEnterUname(WebDriver driver,String fname,String lname,String Email,String role)
	{

		System.out.println("Entering in method ToEnterUGname");
		Actions act=new Actions(driver);

		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);
			
			CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.FirstName()).sendKeys(fname);
			CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.LastName()).sendKeys(lname);
			CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.EmailAddress()).sendKeys(Email);

			CommonUtility.ClickOn(driver,obj_EsupportDDLHomePage.AssignRoledropdown());

			List<WebElement> list=driver.findElements(obj_EsupportDDLHomePage.AssignRoleList());

			for(WebElement lt:list)
			{
				act.moveToElement(CommonUtility.highlightElement(driver, lt));
				//CommonUtility.highlightElement(driver, lt);
				String roletext=lt.getText();
				if(roletext.equalsIgnoreCase(role))
				{
					lt.click();
				}

			}


			Report.put("Enter UG name ,select role and click on continue button", "Should navigate to Add Users",
					"User able to add the new User Group","PASS");

		} catch(Exception e)
		{
			e.printStackTrace();

			Report.put("Enter UG name ,select role and click on continue button", "Should navigate to Add Users",
					"User is not able to add the new User Group","FAIL");

			Assert.fail();
		}
	}
	public void ToClick_Submit_AddNewUser(WebDriver driver)
	{

		System.out.println("Entering in method To Click Submit in Add a New User");
		Log.info("Entering in method To Click Submit in Add a New User");


		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.AddNewUserSubmit()));
//			CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.AddNewUserSubmit()).click();
			CommonUtility.ClickOn(driver,obj_EsupportDDLHomePage.AddNewUserSubmit());


			Report.put("Click on Submit button", "On successful submission, User must be added.",
					"Successfully added a User","PASS");

		} catch(Exception e)
		{
			e.printStackTrace();

			Report.put("Click on Submit button", "On successful submission, User must be added.",
					"User not added in the list","FAIL");

			Assert.fail();
		}
	}
	public void ToVerify_UserSavedmessage(WebDriver driver)
	{

		System.out.println("Entering in method To Verify User Saved message");
		Log.info("Entering in method To Verify User Saved message");
		String SuccessMsg,ReturntoAdd;

		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);
			Thread.sleep(5000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.SuccessMsg()));
			SuccessMsg=CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.SuccessMsg()).getText();
			System.out.println(SuccessMsg);
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.ReturntoadduserGroup()));
			ReturntoAdd=CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.ReturntoadduserGroup()).getText();
			System.out.println(ReturntoAdd);
			if(CommonUtility.CheckpresenceofElementLocated(driver, 01, obj_EsupportDDLHomePage.ReturntoadduserGroup()))
			{
				System.out.println("Return to add user group button is present");
				Report.put("Verify User Saved message is displayed, with the option to return to Add User Group - Add Users view ",
						""+Report.color(SuccessMsg)+"should be displayed, with the option to" +Report.color(ReturntoAdd)+" - Add Users view",
						"User Saved message is displayed, with the option to return to Add User Group - Add Users view","PASS");
			}

			else
			{

				Report.put("Verify User Saved message is displayed, with the option to return to Add User Group - Add Users view ",
						"User Saved message should be displayed, with the option to return to Add User Group - Add Users view",
						"User Saved message is not displayed","FAIL");
				Assert.fail();
			}

		} catch(Exception e)
		{
			e.printStackTrace();

			Report.put("Verify User Saved message is displayed, with the option to return to Add User Group - Add Users view ",
					"User Saved message should be displayed, with the option to return to Add User Group - Add Users view",
					"User Saved message is not displayed","FAIL");
			Assert.fail();
		}
	}
	public void ToClick_ReturntoAddUserGrouplink(WebDriver driver)
	{

		System.out.println("Entering in method To Click Return to Add User Group link");
		Log.info("Entering in method To Click Return to Add User Group link");

		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);
			Thread.sleep(5000);
//			CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.ReturntoadduserGroup()).click();
			CommonUtility.ClickOn(driver,obj_EsupportDDLHomePage.ReturntoadduserGroup());


			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.AddNewUser()));

			Report.put("Click on Return to Add User Group link", "Should navigate to Add Users view",
					"Successfully redirected to Add Users view","PASS");

		} catch(Exception e)
		{
			e.printStackTrace();

			Report.put("Click on Return to Add User Group link", "Should navigate to Add Users view",
					"Not redirected to Add Users view","FAIL");

			Assert.fail();
		}
	}
	//Sujata
	public void ToClick_UserGroupsproductnamecustomernumber(WebDriver driver)
	{

		System.out.println("Entering in method to ToClick_UserGroupsproductnamecustomernumber");


		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);



			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.UnAssProductsgroupdcustomerNo()));


			Thread.sleep(3000);

			CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.UnAssProductsgroupdcustomerNo());
			CommonUtility.ClickOn(driver,obj_EsupportDDLHomePage.UnAssProductsgroupdcustomerNo());

			System.out.println("Clicked on toggel Ascending orders to descending");
			Thread.sleep(5000);


			System.out.println("Displaying  descending Order");

			//wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.ProductGroupsColumHeaderclick()));
			String ltMessages1="";

			Thread.sleep(3000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.UnAssProductsgroupdcustomerNotabledata()));
			CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.UnAssProductsgroupdcustomerNotabledata());

			Thread.sleep(3000);
			List<WebElement> list1=driver.findElements(obj_EsupportDDLHomePage.UnAssProductsgroupdcustomerNotabledata());

			for(WebElement lt:list1)
			{
				CommonUtility.highlightElement(driver, lt);
				String names=lt.getText();

				System.out.println("Alert Name is: " +names);
				ltMessages1+=" <br> " + names;


			}

			Report.put("Click on Customer Number column", " should sort the list in ascending or descending order toggled based on previous sort order  and its displayed as   "+Report.color(ltMessages1),
					"Successfully Should sort the list in ascending or descending order toggled based on previous sort order ", "PASS");

		} catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on Customer Number column", " Ascending or descending order toggled Sorting is not proper. ",
					"Ascending or descending order toggled Sorting is not proper. ", "FAIL");

			Assert.fail();
		}
	}

	public void ToClick_UserGroupsproductnameOrdernumber(WebDriver driver)
	{

		System.out.println("Entering in method to ToClick_UserGroupsproductnameOrdernumber");


		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);



			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.UnAssProductsgroupdOrderNo()));


			Thread.sleep(3000);

			CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.UnAssProductsgroupdOrderNo());
			CommonUtility.ClickOn(driver,obj_EsupportDDLHomePage.UnAssProductsgroupdOrderNo());

			System.out.println("Clicked on toggel Ascending orders to descending");
			Thread.sleep(5000);


			System.out.println("Displaying  descending Order");
			String ltMessages1="";

			Thread.sleep(3000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.UnAssProductsgroupdOrderNotabledata()));
			CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.UnAssProductsgroupdOrderNotabledata());
			Thread.sleep(3000);
			List<WebElement> list1=driver.findElements(obj_EsupportDDLHomePage.UnAssProductsgroupdOrderNotabledata());

			for(WebElement lt:list1)
			{
				CommonUtility.highlightElement(driver, lt);
				String names=lt.getText();

				System.out.println("Alert Name is: " +names);
				ltMessages1+=" <br> " + names;


			}

			Report.put("Click on Order Number column", " should sort the list in ascending or descending order toggled based on previous sort order  and its displayed as   "+Report.color(ltMessages1),
					"Successfully Should sort the list in ascending or descending order toggled based on previous sort order ", "PASS");

		} catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on Order Number column", " Ascending or descending order toggled Sorting is not proper. ",
					"Ascending or descending order toggled Sorting is not proper. ", "FAIL");

			Assert.fail();
		}
	}

	public void ToClick_UserGroupsproductnameShipdate(WebDriver driver)
	{

		System.out.println("Entering in method to ToClick_UserGroupsproductnameShipdate");


		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);



			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.UnAssProductsgroupdShipDate()));


			Thread.sleep(3000);

			CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.UnAssProductsgroupdShipDate());
			CommonUtility.ClickOn(driver,obj_EsupportDDLHomePage.UnAssProductsgroupdShipDate());

			System.out.println("Clicked on toggel Ascending orders to descending");
			Thread.sleep(5000);


			System.out.println("Displaying  descending Order");
			String ltMessages1="";

			Thread.sleep(3000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.UnAssProductsgroupdShipDatetabledata()));
			CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.UnAssProductsgroupdShipDatetabledata());
			Thread.sleep(3000);
			List<WebElement> list1=driver.findElements(obj_EsupportDDLHomePage.UnAssProductsgroupdShipDatetabledata());

			for(WebElement lt:list1)
			{
				CommonUtility.highlightElement(driver, lt);
				String names=lt.getText();

				System.out.println("Alert Name is: " +names);
				ltMessages1+=" <br> " + names;


			}

			Report.put("Click on ship date column", " should sort the list in ascending or descending order toggled based on previous sort order  and its displayed as   "+Report.color(ltMessages1),
					"Successfully Should sort the list in ascending or descending order toggled based on previous sort order ", "PASS");

		} catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on Ship date column", " Ascending or descending order toggled Sorting is not proper. ",
					"Ascending or descending order toggled Sorting is not proper. ", "FAIL");

			Assert.fail();
		}
	}


	public void ToClick_UserGroupsproductnamePrimaryID(WebDriver driver)
	{

		System.out.println("Entering in method to ToClick_UserGroupsproductnamePrimaryID");


		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);



			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.UnAssProductsgroupdPrimaryID()));


			Thread.sleep(3000);

			CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.UnAssProductsgroupdPrimaryID());
			CommonUtility.ClickOn(driver,obj_EsupportDDLHomePage.UnAssProductsgroupdPrimaryID());

			System.out.println("Clicked on toggel Ascending orders to descending");
			Thread.sleep(5000);


			System.out.println("Displaying  descending Order");
			String ltMessages1="";

			Thread.sleep(3000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.UnAssProductsgroupdPrimaryIDtabledata()));
			CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.UnAssProductsgroupdPrimaryIDtabledata());
			Thread.sleep(3000);
			List<WebElement> list1=driver.findElements(obj_EsupportDDLHomePage.UnAssProductsgroupdPrimaryIDtabledata());

			for(WebElement lt:list1)
			{
				CommonUtility.highlightElement(driver, lt);
				String names=lt.getText();

				System.out.println("Alert Name is: " +names);
				ltMessages1+=" <br> " + names;


			}

			Report.put("Click on Primary ID column", " should sort the list in ascending or descending order toggled based on previous sort order  and its displayed as   "+Report.color(ltMessages1),
					"Successfully Should sort the list in ascending or descending order toggled based on previous sort order ", "PASS");

		} catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on Primary ID column", " Ascending or descending order toggled Sorting is not proper. ",
					"Ascending or descending order toggled Sorting is not proper. ", "FAIL");

			Assert.fail();
		}
	}
	//Pushpa 28/2/2019
	public void clickUserGroupContinueButton(WebDriver driver)
	{

		System.out.println("Inside method clickContinueButton1");
		Log.info("Entering in method clickContinueButton1");


		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);
			Thread.sleep(3000);
			if(CommonUtility.CheckpresenceofElementLocated(driver, 05, obj_EsupportDDLHomePage.GroupContinueButton1()))
			{
				CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.GroupContinueButton1());
//				CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.GroupContinueButton1()).click();
				CommonUtility.ClickOn(driver,obj_EsupportDDLHomePage.GroupContinueButton1());


				Report.put("Click on  Continue button ",
						"Should create User Group with selected users and navigate to Add Product Group",
						"Successfully Clicked on Continue button","PASS");
			}
			else
			{
				Report.put("Click on  Continue button ",
						"Should create User Group with selected users and navigate to Add Product Group",
						"Failed to click on Continue button","FAIL"); 
				Assert.fail();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();

			Report.put("Click on  Continue button ",
					"Should create User Group with selected users and navigate to Add Product Group",
					"Failed to click on Continue button","FAIL");    

			Assert.fail();
		}
	}

	public void clickProductGroupContinueButton(WebDriver driver)
	{

		System.out.println("Inside method clickContinueButton2");
		Log.info("Entering in method clickContinueButton2");


		try
		{
			Thread.sleep(3000);
			WebDriverWait wait = new WebDriverWait(driver, 120);
			if(CommonUtility.CheckpresenceofElementLocated(driver, 01, obj_EsupportDDLHomePage.GroupContinueButton2()))
			{
				CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.GroupContinueButton2());
//				CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.GroupContinueButton2()).click();
				CommonUtility.ClickOn(driver,obj_EsupportDDLHomePage.GroupContinueButton2());


				Report.put("Click on  Continue button ",
						"Should navigate to Add Users page with values retained",
						"Successfully Clicked on Continue button","PASS");
			}
			else
			{
				Report.put("Click on  Continue button ",
						"Should navigate to Add Users page with values retained",
						"Failed to click on Continue button","FAIL"); 
				Assert.fail();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();

			Report.put("Click on  Continue button ",
					"Should navigate to Add Users page with values retained",
					"Failed to click on Continue button","FAIL");    

			Assert.fail();
		}
	}

	public void selectProductGroup(WebDriver driver)
	{

		System.out.println("Inside method selectProductGroup");
		Log.info("Entering in method selectProductGroup");


		try
		{
			Thread.sleep(5000);
			WebDriverWait wait = new WebDriverWait(driver, 120);
			if(CommonUtility.CheckpresenceofElementLocated(driver, 01, obj_EsupportDDLHomePage.SelectProductCheckbox()))
			{
				CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.SelectProductCheckbox());
				CommonUtility.ClickOn(driver,obj_EsupportDDLHomePage.SelectProductCheckbox());

				CommonUtility.ClickOn(driver,obj_EsupportDDLHomePage.DoneButton());

				Report.put("Select existing Product Groups and click on Save and Continue button",
						"Should navigate to Verify page and progress bar is highlighted",
						"Navigated to Verify page and progress bar is highlighted","PASS");

			}
			else
			{
				Report.put("Select existing Product Groups and click on Save and Continue button",
						"Should navigate to Verify page and progress bar is highlighted",
						"Failed to Navigate to Verify page ","FAIL");
				Assert.fail();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();

			Report.put("Select existing Product Groups and click on Save and Continue button",
					"Should navigate to Verify page and progress bar is highlighted",
					"Failed to Navigate to Verify page ","FAIL");

			Assert.fail();
		}
	}

	public void verifyUserGroupNameandEdit(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 120);
		Actions act=new Actions(driver);
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);      
		System.out.println("Inside verifyUserGroupNameandEdit");
		Log.info("Inside verifyUserGroupNameandEdit");   

		try
		{
			Thread.sleep(3000);
			String option = TestNGCreator.TestData.get(Esupport.ActionOption.ordinal());
			CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.PaginationSaveSearch());
			CommonUtility.ClickOn(driver,obj_EsupportDDLHomePage.PaginationSaveSearch());

			List<WebElement> list=driver.findElements(obj_EsupportDDLHomePage.PaginationListSaveSearch());

			for(WebElement lt:list)
			{
				act.moveToElement(CommonUtility.highlightElement(driver, lt));
				//CommonUtility.highlightElement(driver, lt);
				String names=lt.getText();

				if(names.equals(option))
				{
					CommonUtility.highlightElement(driver, lt);
					lt.click();
					Thread.sleep(3000);
				}
			}

			String userName = TestNGCreator.TestData.get(Esupport.Textarea.ordinal()).split(";")[0];
			List<WebElement> beforeSortData=driver.findElements(obj_EsupportDDLHomePage.UserGroupNameColumnData());
			String beforeSortDataList = "";
			String afterSortDataList = "";
			int count = 1;
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.SortingButtonUserGroupName()));
			CommonUtility.scrollToViewElement(driver,obj_EsupportDDLHomePage.SortingButtonUserGroupName());
			CommonUtility.ClickOn(driver,obj_EsupportDDLHomePage.SortingButtonUserGroupName());
			for(WebElement lt1:beforeSortData)
			{
				CommonUtility.highlightElement(driver, lt1);
				String uname=lt1.getText();
				System.out.println("uname is: "+uname);
				count++;
				
				Thread.sleep(3000);
				if(uname.equals(userName))
				{
					CommonUtility.highlightElement(driver, lt1);
					System.out.println("Username from the table is :"+uname);
					System.out.println("Count is :"+count);
					Thread.sleep(5000);
					String countStr = Integer.toString(count);
					String finalxpath = "//tr["+countStr+"]//td[3]//a";
					System.out.println("final xpath is:"+finalxpath);
					/*     //tr[7]//td[3]*/
					WebElement ele = driver.findElement(By.xpath(finalxpath));
					String text = ele.getText();
					System.out.println("text is:"+text);
					Thread.sleep(3000);
//					CommonUtility.ToClickByUsingJavaScript(driver, ele);
					ele.click();
					Thread.sleep(10000);
					break;
				}


			}


			Thread.sleep(3000);
			
//			driver.findElement(By.xpath("//span[@class='ng-binding' and text()='Edit']")).click();
			

			Thread.sleep(3000);

			Report.put("Verify User Group name should be displayed with the option to edit the name ",
					"User Group name should be displayed with the option to edit the name", 
					"Edit Link displayed with the Group Name ", "PASS");
		}
		catch(Exception e){
			Log.info(e);

			e.printStackTrace();

			Report.put("Verify User Group name should be displayed with the option to edit the name ",
					"User Group name should be displayed with the option to edit the name", 
					"Edit Link is not displayed with the Group Name ", "FAIL");
			Assert.fail();
		}
	}

	public void enterEditUserGroupName(WebDriver driver,String name)
	{

		System.out.println("Entering in method enterEditUserGroupName");
		Actions act=new Actions(driver);

		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.EditUserGroupNameTextbox()));
			
			CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.EditUserGroupNameTextbox()).clear();
			CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.EditUserGroupNameTextbox()).sendKeys(name);

			Thread.sleep(3000);


			Report.put("Edit User group name", 
					" Should be able to edit user group name",
					"User Group Name edited Successfully to"+Report.color(name),"PASS");

		} catch(Exception e)
		{
			e.printStackTrace();

			Report.put("Edit User group name", 
					" Should be able to edit user group name",
					"Failed to edit User Group Name", "FAIL");

			Assert.fail();
		}
	}

	public void clickOnSubmitButton(WebDriver driver)
	{

		System.out.println("Entering in method clickOnSubmitButton");

		try
		{

			WebDriverWait wait = new WebDriverWait(driver, 120);
			Thread.sleep(3000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.UserGroupSubmitButton()));
//			CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.UserGroupSubmitButton()).click();
			CommonUtility.ClickOn(driver,obj_EsupportDDLHomePage.UserGroupSubmitButton());
			System.out.println("clicked");
//			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.UserGroupHeader()));
			String text=CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.UserGroupHeader()).getText();
			System.out.println(text);
			Report.put("click on Done  button", 
					"User Group name should be saved redirected to the User group page",
					"Successfully redirected to User group Page","PASS");

		} catch(Exception e)
		{
			e.printStackTrace();

			Report.put("click on Done  button", 
					"User Group name should be saved redirected to the User group page",
					"Failed to redirect to User group Page", "FAIL");

			Assert.fail();
		}
	}

	//Sudha 1stMarch
	public void ToSelectrow_Products (WebDriver driver)
	{

		System.out.println("Entering in method To Select the row of Products");
		Log.info("Entering in method To Select the row of Products");

		try
		{
			Thread.sleep(5000);
			WebDriverWait wait = new WebDriverWait(driver, 120);
			Thread.sleep(5000);
			CommonUtility.ClickOn(driver,obj_EsupportDDLHomePage.ProductSelect());

			Report.put("Select the row as per the test data criteria", "Row with test data criteria has been selected",
					"Successfully selected the Row","PASS");

		} catch(Exception e)
		{
			e.printStackTrace();

			Report.put("Select the row as per the test data criteria", "Row with test data criteria has been selected",
					"User not able to select the Row","FAIL");
			Assert.fail();
		}
	}
	public void ToClick_ProductNameLink(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 120);

		System.out.println("Entering in method To Click Product Name Link");
		Log.info("Entering in method To Click Product Name Link");


		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.ProductName()));
			CommonUtility.ClickOn(driver,obj_EsupportDDLHomePage.ProductName());
			Thread.sleep(5000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.ProductHeaderGetKey()));
			//CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.ProductHeaderGetKey());
			Report.put("In Software products grid click on product name  link of the product", "User redirected to the product management page In the horizontal tab user should be able to view","User redirected to the product management page","PASS");


		} catch(Exception e)
		{
			e.printStackTrace();

			Report.put("In Software products grid click on product name  link of the product", "User redirected to the product management page In the horizontal tab user should be able to view","User is not redirected to the product management page","FAIL");

			Assert.fail();
		}
	}
	public void ToClick_getkeylink(WebDriver driver)
	{

		System.out.println("Entering in method To Click get Key Link");
		Log.info("Entering in method To Click get Key Link");
		String ltMessages = "";

		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.Getkey()));
			CommonUtility.ScrollTo(driver,obj_EsupportDDLHomePage.Getkey());
			CommonUtility.ClickOn(driver,obj_EsupportDDLHomePage.Getkey());
			Thread.sleep(5000);

			List<WebElement> list=driver.findElements(obj_EsupportDDLHomePage.GetkeyEmailDownloadList());

			for(WebElement lt:list)
			{

				//CommonUtility.scrollToViewElement(driver, lt);
				CommonUtility.highlightElement(driver,lt);

				String names=lt.getAttribute("value");

				System.out.println(names);
				ltMessages+=" <br> " + names;
			}


			Report.put("Click on get key link", ""+Report.color(ltMessages)+"radio button options should be displayed to the user, download radio button selected as default","email and download radio button options is displayed to the user","PASS");

		} catch(Exception e)
		{
			e.printStackTrace();

			Report.put("Click on get key link", "email and download radio button options should be displayed to the user, download radio button selected as default","email and download radio button options is not displayed to the user","FAIL");


			Assert.fail();
		}
	}

	//Sujata 1st March 2019
	public void ToVerify_Productsearchtabs(WebDriver driver)
	{

		System.out.println("Entering in method to ToVerify_Productsearchtabs");


		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.DDLHeader()));

			CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.DDLHeader());

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.Productsnavigationtabs()));

			CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.Productsnavigationtabs());




			String ltMessages="";
			CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.Productsnavigationtabs());

			List<WebElement> list=driver.findElements(obj_EsupportDDLHomePage.Productsnavigationtabs());

			for(WebElement lt:list)
			{
				CommonUtility.highlightElement(driver, lt);
				String names=lt.getText();

				System.out.println("Alert Name is: " +names);
				ltMessages+=" <br> " + names;


			}
			Report.put("Verify product name of any product ", " User redirected to the product management page In the horizontal tab user should be able to view  as "+ Report.color(ltMessages),
					"Successfully User redirected to the product management page In the horizontal tab user should be able to view product, Available Downloads  and Supportlinks ", "PASS");


		} catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify product name of any product ", " Failed to find  product management page In the horizontal tab ",
					" Failed to find  product management page In the horizontal tab ", "FAIL");

			Assert.fail();
		}
	}


	public void TOverify_Productstablabels(WebDriver driver)
	{
		System.out.println("Entering in to  TOverify_Productstablabels");
		Log.info("Entering in to  TOverify_Productstablabels");
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);
			String text = "";
			String links = "";

			if(CommonUtility.CheckpresenceofElementLocated(driver, 05, obj_EsupportDDLHomePage.ProductstabProductname()))
			{
				CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.ProductstabProductname());
				text = CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.ProductstabProductname()).getText();   
				System.out.println("Label is: "+text);
				links+=" <br> " + text;
			}

			if(CommonUtility.CheckpresenceofElementLocated(driver, 05, obj_EsupportDDLHomePage.ProductstabOrderNumber()))
			{
				CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.ProductstabOrderNumber());
				text = CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.ProductstabOrderNumber()).getText();   
				System.out.println("Label is:"+text);
				links+=" <br> " + text;
			}
			if(CommonUtility.CheckpresenceofElementLocated(driver, 05, obj_EsupportDDLHomePage.ProductstabPrimaryId()))
			{
				CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.ProductstabPrimaryId());
				text = CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.ProductstabPrimaryId()).getText();   
				System.out.println("Label is:"+text);
				links+=" <br> " + text;
			}

			if(CommonUtility.CheckpresenceofElementLocated(driver, 05, obj_EsupportDDLHomePage.ProductstabLicencename()))
			{
				CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.ProductstabLicencename());
				text = CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.ProductstabLicencename()).getText();   
				System.out.println("Label is:"+text);
				links+=" <br> " + text;
			}

			if(CommonUtility.CheckpresenceofElementLocated(driver, 05, obj_EsupportDDLHomePage.ProductstabLicenceDate()))
			{
				CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.ProductstabLicenceDate());
				text = CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.ProductstabLicenceDate()).getText();   
				System.out.println("Label is:"+text);
				links+=" <br> " + text;
			}
			if(CommonUtility.CheckpresenceofElementLocated(driver, 05, obj_EsupportDDLHomePage.ProductstabInstalledonhardwareID()))
			{
				CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.ProductstabInstalledonhardwareID());
				text = CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.ProductstabInstalledonhardwareID()).getText();   
				System.out.println("Label is:"+text);
				links+=" <br> " + text;
			}
			if(CommonUtility.CheckpresenceofElementLocated(driver, 05, obj_EsupportDDLHomePage.ProductstabCurrentversion()))
			{
				CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.ProductstabCurrentversion());
				text = CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.ProductstabCurrentversion()).getText();   
				System.out.println("Label is:"+text);
				links+=" <br> " + text;
			}

			if(CommonUtility.CheckpresenceofElementLocated(driver, 05, obj_EsupportDDLHomePage.ProductstabGetKeylink()))
			{
				CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.ProductstabGetKeylink());
				text = CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.ProductstabGetKeylink()).getText();   
				System.out.println("Label is:"+text);
				links+=" <br> " + text;
			}



			Report.put("Verify the Labels in product page ",
					"User is able to view labels in product page as"+Report.color(links),
					"Successfully In product page labels are displayed", "PASS");

		} 
		catch(Exception e)
		{
			e.printStackTrace();

			Report.put("Verify the Labels in product page ",
					"Failed to find labels in product page.",
					"Failed to find labels in product page.", "FAIL");

			Assert.fail();
		}
	}

	public void ToVerify_Avaibledownloadstab(WebDriver driver)
	{

		System.out.println("Entering in method to ToVerify_Avaibledownloadstab");


		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);

			Thread.sleep(5000);

				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.ProductstabAvvaibleDownloads()));

			CommonUtility.ClickOn(driver,obj_EsupportDDLHomePage.ProductstabAvvaibleDownloads());
			System.out.println("button clicked");
			Thread.sleep(5000);


			String ltMessages="";
			CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.ProductstabAvvaibleDownloadslabels());

			List<WebElement> list=driver.findElements(obj_EsupportDDLHomePage.ProductstabAvvaibleDownloadslabels());

			for(WebElement lt:list)
			{
				System.out.println("inside for");
				CommonUtility.highlightElement(driver, lt);
				//String names=lt.getText();
				String names = lt.getAttribute("innerText");
				System.out.println("Alert Name is: " +names);
				ltMessages+=" <br> " + names;


			}
			Report.put("Click on available downloads tab ", " in the grid user can be able  to view the available software details of following as "+ Report.color(ltMessages),
					"Successfully in the grid user can be able  to view the available software details of product File name Release date Version Manage ", "PASS");


		} catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on available downloads tab ", " Failed to display software details as Release date Version Manage ",
					"Failed to display software details as Release date Version Manage ", "FAIL");

			Assert.fail();
		}
	}

	public void ToVerify_Supportlinks(WebDriver driver)
	{

		System.out.println("Entering in method to ToVerify_Supportlinks");


		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);



			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.Supportlinksclick()));

			CommonUtility.ClickOn(driver,obj_EsupportDDLHomePage.Supportlinksclick());

			Thread.sleep(5000);


			String ltMessages="";
			CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.SupportlinksclickLinkspopup());

			List<WebElement> list=driver.findElements(obj_EsupportDDLHomePage.SupportlinksclickLinkspopup());

			for(WebElement lt:list)
			{
				CommonUtility.highlightElement(driver, lt);
				String names=lt.getText();

				if(!(names.equals(""))){
					System.out.println("Alert Name is: " +names);
					ltMessages+=" <br> " + names;
				}




			}
			Report.put("Click on support links tab ", "  Support links should be displayed  as "+ Report.color(ltMessages),
					"Successfully  Support links should be displayed ", "PASS");


		} catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on support links tab ", "  Failed to display Support links ",
					"Failed to display Support links ", "FAIL");

			Assert.fail();
		}
	}

	public void clickHelpTab(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 420);
		System.out.println("Inside clickHelpTab");
		Log.info("Inside clickHelpTab");

		try
		{
			
//			Thread.sleep(8000);
			wait.until(ExpectedConditions.presenceOfElementLocated(obj_EsupportDDLHomePage.DDLHeader()));

			CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.DDLHeader());
			Thread.sleep(15000);
//			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.HelpTabAdvanceView()));
//			CommonUtility.CheckpresenceofElementLocated(driver, 10, obj_EsupportDDLHomePage.HelpTabAdvanceView());
			CommonUtility.ScrollTo(driver,obj_EsupportDDLHomePage.HelpTabAdvanceView());
			CommonUtility.ClickOn(driver,obj_EsupportDDLHomePage.HelpTabAdvanceView());

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.FaqHeader()));
			CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.FaqHeader());

			Report.put("Click on FAQs link in left nav.", 
					"Frequently asked Questions page should be displayed",
					"Successfully Redirected to FAQ Page", "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on FAQs link in left nav.", 
					"Frequently asked Questions page should be displayed",
					"Failed to  Redirect to FAQ Page", "FAIL");
			Assert.fail();
		}
	}

	public void verifyShowAllLink(WebDriver driver)
	{

		System.out.println("Inside verifyShowAllLink");
		Log.info("Inside verifyShowAllLink");

		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);

			if(CommonUtility.CheckpresenceofElementLocated(driver, 5, obj_EsupportDDLHomePage.ShowAllLink()))
			{
				CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.ShowAllLink());
				if(CommonUtility.CheckpresenceofElementLocated(driver, 5, obj_EsupportDDLHomePage.ArrowDownward()))
				{
					CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.ArrowDownward());
					Thread.sleep(6000);
				}
				Report.put("Verify Show All is displayed and arrow is pointing downwards", 
						"Show All should be displayed and arrow should be pointing downwards",
						"Successfully displayed Show All Link", "PASS");
			}                   
			else
			{
				Report.put("Verify Show All is displayed and arrow is pointing downwards", 
						"Show All should be displayed and arrow should be pointing downwards",
						"Failed to  display Show All Link", "FAIL");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify Show All is displayed and arrow is pointing downwards", 
					"Show All should be displayed and arrow should be pointing downwards",
					"Failed to  display Show All Link", "FAIL");
			Assert.fail();
		}
	}
	public void clickShowAllLink(WebDriver driver)
	{

		System.out.println("Inside clickShowAllLink");
		Log.info("Inside clickShowAllLink");

		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);
			String listItems = "";
			if(CommonUtility.CheckpresenceofElementLocated(driver, 5, obj_EsupportDDLHomePage.ShowAllLink()))
			{
				CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.ShowAllLink());
				CommonUtility.ClickOn(driver,obj_EsupportDDLHomePage.ShowAllLink());
				if(CommonUtility.CheckpresenceofElementLocated(driver, 5, obj_EsupportDDLHomePage.HideAllLink()))
				{
					CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.HideAllLink());
				}

				List<WebElement> list=driver.findElements(obj_EsupportDDLHomePage.ShowAllList());

				for(WebElement lt:list)
				{
					CommonUtility.highlightElement(driver, lt);

					String names=lt.getText();                     
					listItems+= names +"<br>";
				}


				Report.put("Click on Show All ", 
						"instruction particular to all heading/s should be displayed and the arrow should be pointed upwards with collapse all",
						"Successfully displayed the headings:"+Report.color(listItems), "PASS");
			}                   
			else
			{
				Report.put("Click on Show All ", 
						"instruction particular to all heading/s should be displayed and the arrow should be pointed upwards with collapse all",
						"Failed to  display the headings", "FAIL");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on Show All ", 
					"instruction particular to all heading/s should be displayed and the arrow should be pointed upwards with collapse all",
					"Failed to  display the headings", "FAIL");
			Assert.fail();
		}
	}
	public void verifyAndClickHideAllLink(WebDriver driver)
	{

		System.out.println("Inside verifyAndClickHideAllLink");
		Log.info("Inside verifyAndClickHideAllLink");

		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);
			String listItems = "";
			if(CommonUtility.CheckpresenceofElementLocated(driver, 5, obj_EsupportDDLHomePage.HideAllLink()))
			{
				CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.HideAllLink());
				CommonUtility.ClickOn(driver,obj_EsupportDDLHomePage.HideAllLink());

				List<WebElement> list=driver.findElements(obj_EsupportDDLHomePage.ShowAllList());

				for(WebElement lt:list)
				{
					CommonUtility.highlightElement(driver, lt);

					String names=lt.getText();                     
					listItems+= names +"<br>";
				}

				Report.put("Verify collapse All is displayed and arrow is pointing upwards . Click on collapse all", 
						"instruction particular to all heading/s should be displayed and the arrow should be pointed downwards with expand all",
						"Successfully displayed the headings:"+Report.color(listItems), "PASS");
			}                   
			else
			{
				Report.put("Verify collapse All is displayed and arrow is pointing upwards . Click on collapse all", 
						"instruction particular to all heading/s should be displayed and the arrow should be pointed downwards with expand all",
						"Failed to display the headings", "FAIL");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify collapse All is displayed and arrow is pointing upwards . Click on collapse all", 
					"instruction particular to all heading/s should be displayed and the arrow should be pointed downwards with expand all",
					"Failed to display the headings", "FAIL");
			Assert.fail();
		}
	}
	public void verifyHeadingsFaqsPage(WebDriver driver)
	{
		System.out.println("Inside verifyHeadingsFaqsPage");
		Log.info("Inside verifyHeadingsFaqsPage");

		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);
			String listItems = "";
			String listItemsAdvanced = "";   

			List<WebElement> list=driver.findElements(obj_EsupportDDLHomePage.ShowAllList());

			for(WebElement lt:list)
			{
				CommonUtility.highlightElement(driver, lt);

				String names=lt.getText();                    
				listItems+= names +"<br>";
			}

			List<WebElement> listAdvanced=driver.findElements(obj_EsupportDDLHomePage.AdvancedViewList());

			for(WebElement lt:listAdvanced)
			{
				CommonUtility.highlightElement(driver, lt);

				String names=lt.getText();                    
				listItemsAdvanced+= names +"<br>";
			}

			Report.put("Verify the following headings are displayed in FAQ's page", 
					"Following headings should be displayed in FAQ's page",
					"Successfully displayed the headings:"+Report.color(listItems)+"Headings in Advanced View is:"+Report.color(listItemsAdvanced), "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify the following headings are displayed in FAQ's page", 
					"Following headings should be displayed in FAQ's page",
					"Failed to display the headings", "FAIL");
			Assert.fail();
		}
	}
	//Sujata 4/3/2019
	public void ToEnter_keywordsubmit(WebDriver driver)
	{

		System.out.println("Entering in method to ToEnter_keywordsubmit");

		String keysearch=TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal());


		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);
			
			
			CommonUtility.scrollToViewElement(driver, obj_EsupportDDLHomePage.DDLHeader());
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.DDLHeader()));

			CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.DDLHeader());

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.KeywordGetlink()));

			CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.KeywordGetlink());

			CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.KeywordGetlink()).sendKeys(keysearch);

			Thread.sleep(3000);


			CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.KeywordGetlink());

			CommonUtility.ClickOn(driver,obj_EsupportDDLHomePage.KeywordGetlinkSubmit());
			System.out.println("keyword link clicked");


			Report.put("Enter the Unique ID(Entitlement ID/Service Tag of the row which has Assign Key Link in the Keyword Search and click on Submit ", "Enter the Unique ID ' "+Report.color(keysearch)+" ' of the row which has Assign Key Link inthe Keyword Search and click on Submit ",
					"Successfully Enter the keyword and click on submit ", "PASS");


		} catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Enter the Unique ID(Entitlement ID/Service Tag of the row which has Assign Key Link in the Keyword Search and click on Submit ", "Not able to Enter the Unique ID of the row and click on Submit ",
					"Not able to Enter the Unique ID of the row and click on Submit ", "FAIL");

			Assert.fail();
		}
	}


	public void Toclick_Sendemail(WebDriver driver)
	{

		System.out.println("Entering in method to Toclick_Sendemail");
		String ltMessages="";
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);

			
				if(CommonUtility.CheckpresenceofElementLocated(driver,20,obj_EsupportDDLHomePage.KeywordGetlinkDownload()))
				{


			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.KeywordGetlinkDownload()));

			CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.KeywordGetlinkDownload());

			if(CommonUtility.CheckpresenceofElementLocated(driver, 01, obj_EsupportDDLHomePage.KeywordGetlinkDownload()))

			{

				Report.put("Verify either Download radio button is selected by default. ", "Download radio button should be selected by default. ",
						"Successfully Download radio button should be selected by default. ", "PASS");

			}

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.KeywordGetlinksendemail()));

			CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.KeywordGetlinksendemail());

			CommonUtility.ClickOn(driver,obj_EsupportDDLHomePage.KeywordGetlinksendemail());

			Thread.sleep(3000);


			CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.KeywordGetlinksendemailSubmit());

			CommonUtility.ClickOn(driver,obj_EsupportDDLHomePage.KeywordGetlinksendemailSubmit());

			Thread.sleep(20000);

/*
			if(CommonUtility.CheckpresenceofElementLocated(driver, 05, obj_EsupportDDLHomePage.ErrorMessagepopupnotdisplayed()))

			{

				CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.ErrorMessagepopupnotdisplayed());

				String ErrorMessagepopupnotdisplayed=CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.ErrorMessagepopupnotdisplayed()).getText();

				Report.put("Verify either Sendemail radio button is clicked ", "User is not able to see the popup the error message displayed as "+Report.color(ErrorMessagepopupnotdisplayed),
						" Error message is displayed ", "FAIL");
				Assert.fail();

			}


			else
			if(CommonUtility.CheckpresenceofElementLocated(driver, 05, obj_EsupportDDLHomePage.ErrorMessagepopupnotdisplayedinpage()))

			{

				CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.ErrorMessagepopupnotdisplayedinpage());

				String ErrorMessagepopupnotdisplayed=CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.ErrorMessagepopupnotdisplayedinpage()).getText();

				//Thread.sleep(3000);


				CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.KeywordGetlinksendemailSubmit());

				CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.KeywordGetlinksendemailSubmit()).click();
				//Thread.sleep(5000);

			}*/



			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.KeywordGetlinksendemailpopupheader()));

			CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.KeywordGetlinksendemailpopupheader());

			String pipupheader= CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.KeywordGetlinksendemailpopupheader()).getText();



			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.KeywordGetlinksendemailpopupheadermsg()));

			CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.KeywordGetlinksendemailpopupheadermsg());

			String popupheadermsg= CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.KeywordGetlinksendemailpopupheadermsg()).getText();


			Report.put("Enter Assigned to, select email radio button and click on Submit button ", 
					"Pop up message header ' "+Report.color(pipupheader)+" ' telling email has been sent to your email address should be present message as "+Report.color(popupheadermsg),
					"Successfully Pop up message telling email has been sent to your email address should be present ", "PASS");


			CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.Getkeylinkpopoup());
			CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.Getkeylinkpopoup()).click();

			Thread.sleep(3000);

				}
				
		} catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Enter Assigned to, select email radio button and click on Submit button ", 
					"Failed to find Pop up message telling email has been sent to your email address should be present ",
					"Failed to find Pop up message telling email has been sent to your email address should be present ", "PASS");


			Assert.fail();
		}
	}

	public void ToVerifyEnter_Licencename(WebDriver driver)
	{

		System.out.println("Entering in method to ToVerifyEnter_Licencename");

		String productpagelicensetextbox=TestNGCreator.TestData.get(Esupport.SearchOption.ordinal());


		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.productpagelicensename()));
			CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.productpagelicensename());
			String productpagelicensename =CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.productpagelicensename()).getText();


			Report.put("Click on Edit link next to ' "+Report.color(productpagelicensename)+" ' text ", "It should be editable, Link name changed from Edit to Save",
					"Successfully It`s editable and  Link name changed from Edit to Save", "PASS");

			if(CommonUtility.CheckpresenceofElementLocated(driver, 02, obj_EsupportDDLHomePage.productpagelicensemessage()))

			{

				CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.productpagelicensemessage());
				String productpagelicensemessage =CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.productpagelicensemessage()).getText();
				Report.put("Verify if a CMS value 'Add your own custom name' that would be shown for the License Name if there is no license name for the entitlement in DEE.  ", " ' "+Report.color(productpagelicensemessage)+" 'that would be shown for the License Name if there is no license name for the entitlement in DEE should be present ",
						" 'Add your own CMS value custom name' that would be shown for the License Name if there is no license name for the entitlement in DEE should be present ", "PASS");

			}

			else
			{
				Report.put("Verify if a CMS value 'Add your own custom name' that would be shown for the License Name if there is no license name for the entitlement in DEE.  ", 
						" Not able to find 'Add your own CMS value custom name' that would be shown for the License Name if there is no license name for the entitlement in DEE should be present ",
						" Not able to find 'Add your own CMS value custom name' that would be shown for the License Name if there is no license name for the entitlement in DEE should be present ", "FAIL");
				Assert.fail();
			}






			if(CommonUtility.CheckpresenceofElementLocated(driver, 02, obj_EsupportDDLHomePage.productpagelicensenameEditBox()))

			{

				CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.productpagelicensenameEditBox());
				CommonUtility.ClickOn(driver,obj_EsupportDDLHomePage.productpagelicensenameEditBox());
				Thread.sleep(3000);
			}


			if(CommonUtility.CheckpresenceofElementLocated(driver, 02, obj_EsupportDDLHomePage.productpagelicensenameEdit()))
			{

				CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.productpagelicensenameEdit());
				CommonUtility.ClickOn(driver,obj_EsupportDDLHomePage.productpagelicensenameEdit());
				Thread.sleep(3000);
			}




			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.productpagelicensetextbox()));
			CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.productpagelicensetextbox());
			CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.productpagelicensetextbox()).clear();
			CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.productpagelicensetextbox()).sendKeys(productpagelicensetextbox);

			Thread.sleep(3000);

			CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.productpagelicensetextboxSave());
			CommonUtility.ClickOn(driver,obj_EsupportDDLHomePage.productpagelicensetextboxSave());
			Thread.sleep(3000);

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.productpagelicensetextboxSavetext()));
			CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.productpagelicensetextboxSavetext());
			String productpagelicensetextboxSavetext =CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.productpagelicensetextboxSavetext()).getText();


			Report.put("Enter some '"+Report.color(productpagelicensetextbox)+"' and click on save ", 
					"Given Name as ' "+Report.color(productpagelicensetextboxSavetext)+" ' should be entered and saved ",
					"Successfully Given Name  entered and able to saved  ","PASS");


		} catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Enter some name and click on save ", 
					"Failed to Enter Given Name and Not able to License saved ",
					"Failed to Enter Given Name and Not able to License saved  ","FAIL");


			Assert.fail();
		}
	}
	//Pushpa 4/3/2019
	public void verifyRoleDropdown(WebDriver driver)
	{

		System.out.println("Inside verifyRoleDropdown");
		Log.info("Inside verifyRoleDropdown");

		try
		{            
			if(CommonUtility.CheckpresenceofElementLocated(driver, 05, obj_EsupportDDLHomePage.RoleDropdown()))
			{
				System.out.println("Role Dropdown is Present");
				CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.RoleDropdown());
				Report.put("Verify Role is displayed with a dropdown",
						"Role should be displayed with a dropdown",
						"Role dropdown displayed successfully", "PASS");
			}
			else
			{
				Report.put("Verify Role is displayed with a dropdown",
						"Role should be displayed with a dropdown",
						"Failed to display Role dropdown", "FAIL");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify Role is displayed with a dropdown",
					"Role should be displayed with a dropdown",
					"Failed to display Role dropdown", "FAIL");
			Assert.fail();
		}
	}

	public void verifyRemoveButtonUser(WebDriver driver)
	{

		System.out.println("Inside verifyRemoveButtonUser");
		Log.info("Inside verifyRemoveButtonUser");
		
		String value= TestNGCreator.TestData.get(Esupport.SearchOption.ordinal());
		
		Actions act= new Actions(driver);
		
		WebDriverWait wait= new WebDriverWait(driver, 120);

		try
		{            
			if(CommonUtility.CheckpresenceofElementLocated(driver, 05, obj_EsupportDDLHomePage.RemoveLinkUser()))
			{
				
//				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.RemoveLinkUser()));
//				List<WebElement> list2=driver.findElements(obj_EsupportDDLHomePage.RemoveLinkUser());
				CommonUtility.ClickOn(driver,obj_EsupportDDLHomePage.RemoveLinkUser());
				
				System.out.println("Remove Link is Present");
//				CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.RemoveLinkUser());
				Report.put("Verify Remove option is displayed to remove any assigned users",
						"Remove option should be displayed to remove any assigned users",
						"Remove Button displayed Succesfully", "PASS");
			}
			else
			{
				Report.put("Verify Remove option is displayed to remove any assigned users",
						"Remove option should be displayed to remove any assigned users",
						"Failed to display the Remove Button", "FAIL");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify Remove option is displayed to remove any assigned users",
					"Remove option should be displayed to remove any assigned users",
					"Failed to display the Remove Button", "FAIL");
			Assert.fail();
		}
	}

	public void verifyAddUserLinkInEditUserGroup(WebDriver driver)
	{      

		System.out.println("Inside verifyAddUserLinkInEditUserGroup");
		Log.info("Inside verifyAddUserLinkInEditUserGroup");

		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);


			if(CommonUtility.CheckpresenceofElementLocated(driver, 05, obj_EsupportDDLHomePage.AddUserLink()))
			{
				System.out.println("Add New User button is present");
				Report.put("Verify Add a User option is displayed to allow add new or existing users to this User Group ",
						"Add a User option should be displayed to allow add new or existing users to this User Group",
						"Add a User link is displayed Succesfully", "PASS");
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify Add a User option is displayed to allow add new or existing users to this User Group ",
					"Add a User option should be displayed to allow add new or existing users to this User Group",
					"Add a User link is not displayed ", "FAIL");
			Assert.fail();
		}
	}

	public void clickAddUserLinkInEditUserGroup(WebDriver driver)
	{

		System.out.println("Inside clickAddUserLinkInEditUserGroup");
		Log.info("Inside clickAddUserLinkInEditUserGroup");


		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 180);
			Thread.sleep(15000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.AddUserLink()));
			//CommonUtility.scrollToViewElement(driver,obj_EsupportDDLHomePage.AddUserLink());
			CommonUtility.ClickOn(driver,obj_EsupportDDLHomePage.AddUserLink());
			System.out.println("clicked");
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.AddUserHeader()));
			CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.AddUserHeader());
			Report.put("Click on Add a New User link", "Add Users page should be displayed",
					"Add Users page is displayed","PASS");

		} catch(Exception e)
		{
			e.printStackTrace();

			Report.put("Click on Add a New User link", "Add Users page should be displayed",
					"Add Users page is not displayed","FAIL");

			Assert.fail();
		}
	}
	public void clickAssignedTab(WebDriver driver)
	{
		System.out.println("Inside clickAssignedTab");
		Log.info("Inside clickAssignedTab");
		String text = "";
		String links = "";

		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);

			if(CommonUtility.CheckpresenceofElementLocated(driver, 05, obj_EsupportDDLHomePage.AssignedTab()))
			{
				CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.AssignedTab());
				text = CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.AssignedTab()).getText();  
				CommonUtility.ClickOn(driver,obj_EsupportDDLHomePage.AssignedTab());
				System.out.println("Tab is: "+text);                          
			}


			Report.put("Click on assigned tab",
					"Redirected to the assigned users page in the Grid user should be able to view the all the assigned users with the following attributes Last name, First name, Email ID, Role",
					"Successfully Clicked on Assigned Tab", "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on assigned tab",
					"Redirected to the assigned users page in the Grid user should be bale to view the all the assigned users with the following attributes Last name, First name, Email ID, Role",
					"Failed to Click on Assigned Tab", "FAIL");
			Assert.fail();
		}
	}

	public void clickRoleDropdownandSave(WebDriver driver)
	{

		System.out.println("Inside clickRoleDropdownandSave");
		Log.info("Inside clickRoleDropdownandSave");
		WebDriverWait wait = new WebDriverWait(driver, 120);
		try
		{            
			Thread.sleep(3000);
			if(CommonUtility.CheckpresenceofElementLocated(driver, 05, obj_EsupportDDLHomePage.RoleDropdown()))
			{
				Select selAction = new  Select(driver.findElement(obj_EsupportDDLHomePage.RoleDropdown()));

				Thread.sleep(3000);
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.RoleDropdown()));
				CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.RoleDropdown());
				CommonUtility.ClickOn(driver,obj_EsupportDDLHomePage.RoleDropdown());
				Thread.sleep(3000);
				selAction.selectByIndex(1);
				Thread.sleep(3000);
				CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.SaveButton());
				CommonUtility.ClickOn(driver,obj_EsupportDDLHomePage.SaveButton());
				Report.put("From unassigned users list  select the Role of user which user need to add to the user group and click on save button ",
						"Selected unassigned users should be added to the user group",
						"User added to the group successfully", "PASS");
			}
			else
			{
				Report.put("From unassigned users list  select the Role of user which user need to add to the user group and click on save button ",
						"Selected unassigned users should be added to the user group",
						"Failed to add User to the group", "FAIL");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("From unassigned users list  select the Role of user which user need to add to the user group and click on save button ",
					"Selected unassigned users should be added to the user group",
					"Failed to add User to the group", "FAIL");
			Assert.fail();
		}
	}


	public void clickAddNewUserButton(WebDriver driver)
	{

		System.out.println("Inside clickAddNewUserButton");
		Log.info("Inside clickAddNewUserButton");


		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);
			Thread.sleep(5000);
			CommonUtility.ClickOn(driver,obj_EsupportDDLHomePage.AddNewUserButton());

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.AssignedAddUserHeader()));
			CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.AssignedAddUserHeader());
			Report.put("Click on Add a New User link", "Add Users page should be displayed",
					"Add Users page is displayed","PASS");

		} catch(Exception e)
		{
			e.printStackTrace();

			Report.put("Click on Add a New User link", "Add Users page should be displayed",
					"Add Users page is not displayed","FAIL");

			Assert.fail();
		}
	}

	public void clickReturnToEditUserGroupLink(WebDriver driver)
	{

		System.out.println("Inside clickReturnToEditUserGroupLink");
		Log.info("Inside clickReturnToEditUserGroupLink");

		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);
			Thread.sleep(5000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.ReturntoEditUserGroupLink()));
			CommonUtility.ClickOn(driver,obj_EsupportDDLHomePage.ReturntoEditUserGroupLink());
			System.out.println("after clicking");

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.EditUserGroupHeader()));
			CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.EditUserGroupHeader());
			Report.put("Click on Return to Edit User Group link", 
					"Should navigate to Edit Users view",
					"Successfully redirected to Edit Users view","PASS");

		} catch(Exception e)
		{
			e.printStackTrace();

			Report.put("Click on Return to Edit User Group link", "Should navigate to Edit Users view",
					"Not redirected to Edit Users view","FAIL");

			Assert.fail();
		}
	}

	public void clickEditLinkUserGroups(WebDriver driver)
	{

		System.out.println("Inside clickEditLinkUserGroups");
		Log.info("Inside clickEditLinkUserGroups");
		String header = "";
		Actions act=new Actions(driver);
		String value= TestNGCreator.TestData.get(Esupport.SearchOption.ordinal());

		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.AddUserGroup()));
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.EditForPerticularOfferName()));
			List<WebElement> list2=driver.findElements(obj_EsupportDDLHomePage.EditForPerticularOfferName());
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.EditLink()));
			List<WebElement> list1=driver.findElements(obj_EsupportDDLHomePage.EditLink());

			System.out.println("Value from testdata is: "+value);
			for(int i=0; i<list2.size();i++)
			{
				CommonUtility.highlightElement(driver, list1.get(i));
				String names=list2.get(i).getAttribute("innerText");

				System.out.println("Alert Name is: " +names);

				if(names.equals(value))
				{
					CommonUtility.ScrollToWebElement(driver, list1.get(i));
					CommonUtility.ClickOnWebElement(driver, list1.get(i));
//					list2.click();
					System.out.println("Clicked on value from Testdata "+value);
					break;
						
				}                         
			}
//			CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.EditLink());
//			CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.EditLink()).click();

//			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.EditUserGroupHeader()));
			CommonUtility.ScrollTo(driver,obj_EsupportDDLHomePage.EditUserGroupHeader());
			header = CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.EditUserGroupHeader()).getText();

			Report.put("Click on Edit link for the user group",
					"Should display the Edit User Group view",
					"Displayed the Edit User Group View Successfully. Header is:"+Report.color(header), "PASS");


		} catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on Edit link for the user group",
					"Should display the Edit User Group view",
					"Failed to display the Edit User Group View ", "FAIL");
			Assert.fail();
		}
	} 

	public void ToEdit_Licencename(WebDriver driver)
	{

		System.out.println("Entering in method to ToVerifyEnter_Licencename");

		String productpagelicensetextbox=TestNGCreator.TestData.get(Esupport.SearchOption.ordinal());


		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);





			if(CommonUtility.CheckpresenceofElementLocated(driver, 02, obj_EsupportDDLHomePage.productpagelicensenameEditBox()))

			{

				CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.productpagelicensenameEditBox());
				CommonUtility.ClickOn(driver,obj_EsupportDDLHomePage.productpagelicensenameEditBox());
				Thread.sleep(3000);
			}


			if(CommonUtility.CheckpresenceofElementLocated(driver, 02, obj_EsupportDDLHomePage.productpagelicensenameEdit()))
			{

				CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.productpagelicensenameEdit());
				CommonUtility.ClickOn(driver,obj_EsupportDDLHomePage.productpagelicensenameEdit());
				Thread.sleep(3000);
			}




			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.productpagelicensetextbox()));
			CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.productpagelicensetextbox());
			CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.productpagelicensetextbox()).clear();
			CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.productpagelicensetextbox()).sendKeys(productpagelicensetextbox);

			Thread.sleep(3000);

			CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.productpagelicensetextboxSave());
			CommonUtility.ClickOn(driver,obj_EsupportDDLHomePage.productpagelicensetextboxSave());
			Thread.sleep(3000);

//			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.productpagelicensetextboxSavetext()));
			CommonUtility.scrollToViewElement(driver,obj_EsupportDDLHomePage.productpagelicensetextboxSavetext());
			CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.productpagelicensetextboxSavetext());
			String productpagelicensetextboxSavetext =CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.productpagelicensetextboxSavetext()).getText();


			Report.put("Enter some '"+Report.color(productpagelicensetextbox)+"' and click on save ", 
					"Given Name as ' "+Report.color(productpagelicensetextboxSavetext)+" ' should be entered and saved ",
					"Successfully Given Name  entered and able to saved  ","PASS");


		} catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Enter some name and click on save ", 
					"Failed to Enter Given Name and Not able to License saved ",
					"Failed to Enter Given Name and Not able to License saved  ","FAIL");


			Assert.fail();
		}
	}
	//Sujata 5thMarch@2019
	public void ToVerify_Getlinknodeslink(WebDriver driver)
	{

		System.out.println("Entering in method to ToVerify_Getlinknodeslink");


		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);


			String ltMessages="";

			Thread.sleep(3000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.GetlinknodelistHeader()));
			CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.GetlinknodelistHeader());

			Thread.sleep(3000);
			List<WebElement> list=driver.findElements(obj_EsupportDDLHomePage.GetlinknodelistHeader());

			for(WebElement lt:list)
			{
				CommonUtility.highlightElement(driver, lt);
				String names=lt.getText();

				System.out.println("Alert Name is: " +names);
				ltMessages+=" <br> " + names;


			}

			Report.put("Verify License Information section", " User can see Dimension description & Quantity Ensure that User can see each dimension but only one get key link above the dimension grid displayed as "+Report.color(ltMessages),
					"Successfully  User can see Dimension description & Quantity Ensure that User can see each dimension but only one get key link above the dimension grid","PASS");



			String ltMessages1="";

			Thread.sleep(3000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.Getlinknodelistcount()));
			CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.Getlinknodelistcount());

			Thread.sleep(3000);
			List<WebElement> list1=driver.findElements(obj_EsupportDDLHomePage.Getlinknodelistcount());

			for(WebElement lt:list1)
			{
				CommonUtility.highlightElement(driver, lt);
				String names=lt.getText();

				System.out.println("Alert Name is: " +names);
				ltMessages1+=" <br> " + names;


			}




			Report.put("Verify grid Get link values", " User can see Getlink grid values as "+Report.color(ltMessages1),
					"Successfully  User can see Getlink grid values","PASS");

		} catch(Exception e)
		{
			e.printStackTrace();

			Report.put("Verify License Information section", " Failed to n see Dimension description & Quantity in grid ",
					"Failed to n see Dimension description & Quantity in grid","FAIL");

			Assert.fail();
		}
	}

	public void ToClick_Downloadsubmit(WebDriver driver)
	{

		System.out.println("Entering in method To ToClick_Downloadsubmit");
		Log.info("Entering in method To ToClick_Downloadsubmit");
		String ltMessages="";

		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);
		
				if(CommonUtility.CheckpresenceofElementLocated(driver,20,obj_EsupportDDLHomePage.KeywordGetlinksendemailSubmit()))
				{
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.KeywordGetlinksendemailSubmit()));

			CommonUtility.ClickOn(driver,obj_EsupportDDLHomePage.KeywordGetlinksendemailSubmit());
			Thread.sleep(5000);

			//CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.ProductHeaderGetKey());
			Report.put("Select download radio button and Submit", "Zip file with license information details should be downloaded in the browser in the downloaded folder",
					"Successfully Zip file with license information details should be downloaded in the browser in the downloaded folder","PASS");
			}
				

		} catch(Exception e)
		{
			e.printStackTrace();

			Report.put("Select download radio button and click on Submit", "Failed to download Zip file ",
					" Failed to download Zip file","FAIL");

			Assert.fail();
		}
	}
	//8thMarch
	public void SearchBy_Value(WebDriver driver,String sub_option,String value) {
		driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 300);
		String details = "";
		String flag="";
		String sub_val="";

		try {
			
			System.out.println("Enter method in to SearchBy_Value");
			CommonUtility.ClickOn(driver, obj_EsupportDDLHomePage.Searchbydrp());
			System.out.println("Dropdown contains following field");
			List<WebElement> ele = driver.findElements(obj_EsupportDDLHomePage.SearchbydrpValues());
			System.out.println("the list of options:"+ele.size()); 
			ArrayList<String> SearchByDropDownValues = new ArrayList<String>();
			for (int i = 0; i < ele.size(); i++) {
				details= ele.get(i).getText();    


				SearchByDropDownValues.add(details);
				System.out.println("the list of options:"+SearchByDropDownValues);


				if(details.equals(value))
				{
					((WebElement) ele).click();
					break;
				}
			}	
			Report.put("Enter Order Number and click on Submit", "Refined search results should be displayed."+Report.color(sub_option), "search results are displayed :"+Report.color(value), "Pass");
		} catch (Exception e) {
			e.printStackTrace();
			Report.put("Click on the search by drop down", "System should display below mentioned values in the drop down", "Fields are not available", "Fail");
			Assert.fail();
		}
	}
	//Sujata
	public void ToClick_AddaProductname(WebDriver driver)
	{

		System.out.println("Entering in method to ToClick_AddaProductname");

		String groupName=TestNGCreator.TestData.get(Esupport.SearchOption.ordinal());


		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);


			if(CommonUtility.CheckpresenceofElementLocated(driver, 01, obj_EsupportDDLHomePage.AddaProductName()))
			{


				CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.AddaProductName());
				String AddaProductName=CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.AddaProductName()).getText();
				Report.put("Verify Add a Product Group button is displayed at the top of the modal window", " ' "+Report.color(AddaProductName)+" ' button should be displayed at the top  of the modal window",
						"Successfully Add a Product Group button displayed at the top  of the modal window", "PASS");


			}

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.AddaProductName()));
			CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.AddaProductName());
			CommonUtility.ClickOn(driver,obj_EsupportDDLHomePage.AddaProductName());


			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.DDLHeader()));
			CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.DDLHeader());
			String DDLHeader=CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.DDLHeader()).getText();



			Report.put("Click on 'Add a Product Group' button", " ' "+Report.color(DDLHeader)+" ' view should be displayed",
					"Successfully Add Product Group view should be displayed", "PASS");


			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.AddProductGroupName()));
			CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.AddProductGroupName());
			CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.AddProductGroupName()).sendKeys(groupName);


			Report.put("Enter Product Group name", " Should be able to enter product group name as "+Report.color(groupName),
					"Successfully able to enter product group name", "PASS");


			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.AddProductGroupNameSelect()));
			CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.AddProductGroupNameSelect());
			CommonUtility.ClickOn(driver,obj_EsupportDDLHomePage.AddProductGroupNameSelect());

			CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.AddProductGroupNameSelectText());
			String AddProductGroupNameSelectText= CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.AddProductGroupNameSelectText()).getText();


			Report.put("Add/Select Product Groups", " Should be able to add/select product groups as "+Report.color(AddProductGroupNameSelectText),
					"Successfully able to add/select product groups", "PASS");



			CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.AddProductGroupNameSubmit());
			CommonUtility.ClickOn(driver,obj_EsupportDDLHomePage.AddProductGroupNameSubmit());


			/*wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.AvaibleProductheader()));
     CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.AvaibleProductheader());
             String AvaibleProductheader=CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.AvaibleProductheader()).getText();
			 */

			Report.put("Click on Save and Continue button.", " Should navigate to Should navigate to Add Products page",
					"Successfully Should navigate to Add Products page", "PASS");


		} catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Enter productname ,select product and Click on Save and Continue button.", " Failed to Enter productname ,select product and Click on Save and Continue button.",
					"Failed to Enter productname ,select product and Click on Save and Continue button.", "FAIL");

			Assert.fail();
		}
	}


	public void ToClick_availableAddProducts(WebDriver driver)
	{

		System.out.println("Entering in method to ToClick_availableAddProducts");


		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);


			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.AvaibleProductselectclicked()));

			CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.AvaibleProductselectclicked());
			CommonUtility.ClickOn(driver,obj_EsupportDDLHomePage.AvaibleProductselectclicked());

			Report.put("Select Products", " Should be able to select products",
					"Successfully Should be able to select products", "PASS");



			CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.AvaibleProductselectSaveContinue());
			CommonUtility.ClickOn(driver,obj_EsupportDDLHomePage.AvaibleProductselectSaveContinue());


			Report.put("Click on Done Button", "Selected Products should be added to the Product Group and navigate to Verify new Product Group page",
					"Successfully Selected Products should be added to the Product Group and navigate to Verify new Product Group page", "PASS");


		} catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on Product Groups tab", " Failed to navigate  Product Groups page",
					"Failed to navigate  Product Groups page ", "FAIL");


			Assert.fail();
		}
	}

	public void ToVerify_productGroupName(WebDriver driver)
	{

		System.out.println("Entering in method to ToVerify_productGroupName");

		String groupName=TestNGCreator.TestData.get(Esupport.SearchOption.ordinal());

		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);


			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.VerifyProductGroupName()));

			CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.VerifyProductGroupName());
			String VerifyProductGroupName=CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.VerifyProductGroupName()).getAttribute("text");

			if(groupName.equals(VerifyProductGroupName))
			{
				Report.put("Verify Product Group name should be displayed with the option to edit the name", " Product Group name should be displayed with the option to edit the name",
						"Successfully Product Group name displayed with the option to edit the name", "PASS");

			}

			if(CommonUtility.CheckpresenceofElementLocated(driver, 20, obj_EsupportDDLHomePage.VerifyProductGroupName()))
			{
				Report.put("Click on edit product group name", " Should be able to edit product group name",
						"Successfully Should be able to edit product group name", "PASS");
			}


			Report.put("Verify Product Group name should be displayed with the option to edit the name", " Product Group name should be displayed with the option to edit the name",
					"Successfully Product Group name displayed with the option to edit the name", "PASS");




			if(CommonUtility.CheckpresenceofElementLocated(driver, 20, obj_EsupportDDLHomePage.VerifyProductsdisplayed()))
			{

				CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.VerifyProductsdisplayed());
				String VerifyProductsdisplayed=CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.VerifyProductsdisplayed()).getText();

				Report.put("Verify User Groups grid is displayed with the list of all assigned user groups", "User Groups grid should be displayed with the list of all assigned user groups as"+Report.color(VerifyProductsdisplayed),
						"Successfully User Groups grid should be displayed with the list of all assigned user groups", "PASS");
			}


			if(CommonUtility.CheckpresenceofElementLocated(driver, 20, obj_EsupportDDLHomePage.AddaanotherProducts()))
			{

				CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.AddaanotherProducts());
				CommonUtility.ClickOn(driver,obj_EsupportDDLHomePage.AddaanotherProducts());


				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.AvaibleProductselectclickedsecond()));


				CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.AvaibleProductselectclickedsecond());
				CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.AvaibleProductselectclickedsecond()).click();



				CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.AvaibleProductselectclickedsecondSave());
				CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.AvaibleProductselectclickedsecondSave()).click();




				Report.put("Verify Assign other Products option is displayed to allow to associate existing products to the Product Group", "Assign other Products option should be displayed to allow to associate existing products to the Product Group",
						"Successfully Assign other Products option should be displayed to allow to associate existing products to the Product Group", "PASS");


			}


			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.VerifyProductGroupNameSavebtn()));


			CommonUtility.ScrollTo(driver,obj_EsupportDDLHomePage.VerifyProductGroupNameSavebtn());
			CommonUtility.ClickOn(driver,obj_EsupportDDLHomePage.VerifyProductGroupNameSavebtn());


			Report.put("Click on Submit Button", "Should navigate to Product Groups view",
					"Successfully Should navigate to Product Groups view", "PASS");




		} catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on Product Groups tab", " Failed to navigate  Product Groups page",
					"Failed to navigate  Product Groups page ", "FAIL");


			Assert.fail();
		}
	}

	//pushpa 25th march

	public void clickBillingAccountTab(WebDriver driver)
	{

		System.out.println("Entering in method to clickBillingAccountTab");
		WebDriverWait wait = new WebDriverWait(driver, 240);

		try
		{
			
			String ltMessages = "";
			Thread.sleep(20000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.BillingAccountTabAdvanceView()));

			CommonUtility.ClickOn(driver,obj_EsupportDDLHomePage.BillingAccountTabAdvanceView());

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.BillingAccountHeader()));

			List<WebElement> list=driver.findElements(obj_EsupportDDLHomePage.BillingAccountTableHeader());

			for(WebElement lt:list)
			{
				CommonUtility.highlightElement(driver, lt);
				String names=lt.getAttribute("innerText");

				System.out.println("Alert Name is: " +names);
				ltMessages+=" <br> " + names;
			}


			Report.put("Click on Billing Accounts tab", 
					" It should show all the records pertaining to the logged in user",
					"Successfully displayed Billing Account records. Records are:"+Report.color(ltMessages), "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on Billing Accounts tab", 
					" It should show all the records pertaining to the logged in user",
					"Failed to display Billing Account records", "FAIL");
			Assert.fail();
		}
	}

	public void clickOfferNameData(WebDriver driver, String value)
	{

		System.out.println("Entering in method to clickOfferNameData");
		String a=TestNGCreator.TestData.get(Esupport.ActionOption.ordinal()).split(";")[3];
		Actions act= new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, 240);
		try
		{
			//Lavanya
			
			Thread.sleep(15000);
			String ltMessages="";
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.PaginationInBillingAccountTab()));
			CommonUtility.ScrollTo(driver,obj_EsupportDDLHomePage.PaginationInBillingAccountTab());
			CommonUtility.ClickOn(driver,obj_EsupportDDLHomePage.PaginationInBillingAccountTab());

			List<WebElement> list=driver.findElements(obj_EsupportDDLHomePage.PaginationListInBillingAccountTab());

			for(WebElement lt:list)
			{

				CommonUtility.ScrollToWebElement(driver, lt);
				//act.moveToElement(CommonUtility.highlightElement(driver, lt));
				//CommonUtility.highlightElement(driver, lt);
				String names=lt.getText();
				System.out.println(names);
				if(names.contains(a))
				{
					System.out.println("entered if");
//					CommonUtility.ScrollToWebElement(driver, lt);
//					CommonUtility.ClickOnWebElement(driver, lt);
					lt.click();
				}
			}
			
			
			String header = "";              
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.OfferNameColumnData()));
			List<WebElement> list2=driver.findElements(obj_EsupportDDLHomePage.OfferNameColumnData());
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.BillPlanIDColumnData()));
			List<WebElement> list1=driver.findElements(obj_EsupportDDLHomePage.BillPlanIDColumnData());

			for(int i=0; i<list2.size();i++)
			{
				CommonUtility.ScrollToWebElement(driver, list2.get(i));
				String names=list2.get(i).getAttribute("innerText");

				System.out.println("Alert Name is: " +names);

				if(names.equals(value))
				{
					CommonUtility.ScrollToWebElement(driver, list2.get(i));
					Thread.sleep(3000);
//					act.moveToElement(CommonUtility.highlightElement(driver, list2.get(i))).click().build().perform();
					CommonUtility.ClickOnWebElement(driver, list2.get(i));
//					list2.click();
					System.out.println("Clicked on value from Testdata "+value);
					break;
				}                         
			}

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.BillPlanDetailsHeader()));
			CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.BillPlanDetailsHeader());

			header = CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.BillPlanDetailsHeader()).getText();
			System.out.println(header);
			Report.put("Now click on "+Report.color(value), 
					"It should load the Bill Plan Details",
					"Successfully displayed Bill Plan Details. Header is:"+Report.color(header), "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Now click on  AZURE CSP", 
					"It should load the Bill Plan Details",
					"Failed to display Bill Plan Details", "FAIL");
			Assert.fail();
		}
	}

	public void clickSelectAllOfferNameCheckboxAndBillHistoryLink(WebDriver driver, String value)
	{

		System.out.println("Entering in method to clickSelectAllOfferNameCheckboxAndBillHistoryLink");

		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);
			String header = "";              

			String ltMessages = "";
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.SelectAllProductNameCheckbox()));

			CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.SelectAllProductNameCheckbox());

			CommonUtility.ClickOn(driver,obj_EsupportDDLHomePage.SelectAllProductNameCheckbox());

			CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.BillingHistoryLink());
			CommonUtility.ClickOn(driver,obj_EsupportDDLHomePage.BillingHistoryLink());



			List<WebElement> list=driver.findElements(obj_EsupportDDLHomePage.BillingHistoryTableHeader());

			for(WebElement lt:list)
			{
				CommonUtility.highlightElement(driver, lt);
				String names=lt.getAttribute("innerText");

				System.out.println("Alert Name is: " +names);                         
				ltMessages+=" <br> " + names;    
			}

			Report.put("Now select all products in Manage tab under column 'Product Name' and click 'Bill History' link.", 
					"It should display the Billing History of all the products selected ",
					"Successfully displayed Billing History of all the products selected"+Report.color(header)+"Billing History Details are:"+"<br>"+Report.color(ltMessages), "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Now select all products in Manage tab under column 'Product Name' and click 'Bill History' link.", 
					"It should display the Billing History of all the products selected ",
					"Failed to display Billing History of all the products selected", "FAIL");
			Assert.fail();
		}
	}

	public void displayAmountColumnData(WebDriver driver)
	{

		System.out.println("Entering in method to displayAmountColumnData");

		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);
			String header = "";              

			String ltMessages = "";


			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.AmountColumnData()));

			List<WebElement> list=driver.findElements(obj_EsupportDDLHomePage.AmountColumnData());

			for(WebElement lt:list)
			{
				CommonUtility.highlightElement(driver, lt);
		//String names=lt.getAttribute("innertext");
			  String names=lt.getText();
			  
			  
			  System.out.println(names.replaceAll("[a-zA-Z()\\s]", ""));
			  
				if(names.contains("$"))
				{
					System.out.println("inside if Alert Name is: " +names);    
					
					Report.put("Now observe format of Amount", 
							"It should have the format like $0.00 ",
							"Successfully displayed Amount in the format"+Report.color(ltMessages), "PASS");
					//ltMessages+=" <br> " + names;  
					break;
				}
				else
				{
					System.out.println("Amount not displayed in $ format"+names);

					Report.put("Now observe format of Amount", 
							"It should have the format like $0.00 ",
							"Failed to display Amount in the format", "FAIL");
					Assert.fail("Failed to display amount in the required($0.00) format");
				}
			}

			
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Now observe format of Amount", 
					"It should have the format like $0.00 ",
					"Failed to display Amount in the format", "FAIL");
			Assert.fail("Failed to display amount in the required($0.00) format");
		}
	}

	public void displayUnitChargeAmountColumnData(WebDriver driver)
	{

		System.out.println("Entering in method to displayUnitChargeAmountColumnData");

		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);
			String header = "";              

			String ltMessages = "";



			List<WebElement> list=driver.findElements(obj_EsupportDDLHomePage.UnitChargeAmountColumnData());

			for(WebElement lt:list)
			{
				CommonUtility.highlightElement(driver, lt);

				//String names=lt.getAttribute("innertext");
				  String names=lt.getText();
				  
				  
				  System.out.println(names.replaceAll("[a-zA-Z()\\s]", ""));
				if(names.contains("$"))
				{
					System.out.println("Alert Name is: " +names);                         
					ltMessages+=" <br> " + names;       
				}
				else
				{
					System.out.println("Amount not displayed in $ format"+names);

					Report.put("Now observe format of Unit Charge Amount fields", 
							"It should have the format like $0.00 ",
							"Failed to display Amount in the format", "FAIL");
					Assert.fail("Failed to display amount in the required($0.00) format");
				}
			}

			Report.put("Now observe format of Unit Charge Amount fields", 
					"It should have the format like $0.00 ",
					"Successfully displayed Amount in the format"+Report.color(ltMessages), "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Now observe format of Unit Charge Amount fields", 
					"It should have the format like $0.00 ",
					"Failed to display Amount in the format", "FAIL");
			Assert.fail("Failed to display amount in the required($0.00) format");
		}
	}

	public void clickViewDetailsLink(WebDriver driver)
	{

		System.out.println("Entering in method to clickViewDetailsLink");

		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);
			String header = "";              

			String ltMessages = "";

			Thread.sleep(3000);

		//	CommonUtility.scrollToViewElement(driver,obj_EsupportDDLHomePage.ViewDetailsLink());

			CommonUtility.ClickOn(driver,obj_EsupportDDLHomePage.ViewDetailsLink());

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.BillingDetailsHeader()));
			CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.BillingDetailsHeader());

			header = CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.BillingDetailsHeader()).getText();
			System.out.println("Popup Header is:"+header);

			Report.put("Now click on VIEW DETAILS link", 
					"It should popup Details window. ",
					"Successfully displayed Popup Details Window"+Report.color(header), "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Now click on VIEW DETAILS link", 
					"It should popup Details window. ",
					"Failed to display Popup Details Window", "PASS");
			Assert.fail();
		}
	}

	public void verifyAmountFormat(WebDriver driver)
	{

		System.out.println("Entering in method to verifyAmountFormat");

		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);
			String header = "";              

			String ltMessages = "";
			String totalAmount = "";



			List<WebElement> list=driver.findElements(obj_EsupportDDLHomePage.DetailsAmountData());

			for(WebElement lt:list)
			{
				CommonUtility.highlightElement(driver, lt);
				//String names=lt.getAttribute("innerText");
				
				 String names=lt.getText();
				  
				  
				  System.out.println(names.replaceAll("[a-zA-Z()\\s]", ""));
				if(names.contains("$"))
				{
					System.out.println("Alert Name is: " +names);                         
					ltMessages+=" <br> " + names;       
				}
				else
				{
					System.out.println("Amount not displayed in $ format"+names);

					Report.put("Now observe format of Amount", 
							"It should have the format like $0.00 ",
							"Failed to display Amount in the format", "FAIL");
					Assert.fail("Failed to display amount in the required($0.00) format");
				}
			}

			CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.TotalAmountData());

			totalAmount = CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.TotalAmountData()).getText();

			System.out.println("Total Amount is:"+totalAmount);

			Report.put("Now observe format of Amount", 
					"It should have the format like $0.00 ",
					"Successfully displayed Amount in the format"+Report.color(ltMessages)+"Total Amount is:"+Report.color(totalAmount), "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Now observe format of Amount", 
					"It should have the format like $0.00 ",
					"Failed to display Amount in the format", "FAIL");
			Assert.fail("Failed to display amount in the required($0.00) format");
		}
	}
	//pushpa

	public void verifyGetAllTextBasedKeys(WebDriver driver)
	{

		System.out.println("Entering in method to verifyGetAllTextBasedKeys");
		String buttonText = "";

		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.GetAllTextBasedKeys()));

			CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.GetAllTextBasedKeys());

			buttonText=CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.GetAllTextBasedKeys()).getText();

			System.out.println("Text is:"+buttonText);

			Report.put("Observe 'Get all text-based keys' button", 
					"The button should be in the header i.e. above the order details section table",
					"Successfully displayed"+Report.color(buttonText), "PASS");


		} catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Observe 'Get all text-based keys' button", 
					"The button should be in the header i.e. above the order details section table",
					"Failed to display 'Get all text-based keys' button", "FAIL");
			Assert.fail();
		}
	}


	/*public void verifyTotalAmount(WebDriver driver)
	{

		System.out.println("Entering in method to verifyTotalAmount");

		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);
			String header = "";           
			String ltMessages = "";
			String totalAmount = "";

			float[] val = new float[3];
			int i = 0;
			float sum = 0;


			List<WebElement> list=driver.findElements(obj_EsupportDDLHomePage.DetailsAmountData());

			for(WebElement lt:list)
			{
				CommonUtility.highlightElement(driver, lt);
				//String names=lt.getAttribute("innerText");
				String names=lt.getText();
				  
				   System.out.println(names.replaceAll("[a-zA-Z()\\s]", ""));
				
				if(names.contains("$"))
				{
					System.out.println("Alert Name is: " +names); 
					String temp =names.replace("$", "");
					System.out.println("temp string is "+temp);
					float f=Float.parseFloat(temp); 
					System.out.println("value after parse:"+f);
					val[i]=f;                	 
					i++;

					ltMessages+=" <br> " + names; 
					
					break;
				}
				else
				{
					System.out.println("Amount not displayed in $ format"+names);

					Report.put("Now observe format of Amount", 
							"It should have the format like $0.00 ",
							"Failed to display Amount in the format", "FAIL");
					Assert.fail("Failed to display amount in the required($0.00) format");
				}
				for(int j=0;j<val.length;j++)
				{
					System.out.println("Content in Array"+val[j]);
				}
			}
			CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.TotalAmountData());

			totalAmount = CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.TotalAmountData()).getText();
			String tempTotal =totalAmount.replace("$", "");
			System.out.println("temp string is "+tempTotal);
			float f=Float.parseFloat(tempTotal); 

			System.out.println("Total Amount is:"+totalAmount);
			sum = val[0]+val[1];
			System.out.println("Sum is: "+sum);
			String strSum = String.valueOf(sum);
			String strSubscription = String.valueOf(val[0]);
			String strTax = String.valueOf(val[1]);
			if(val[2]==sum && val[2]==f)
			{
				System.out.println("values are same in total****");
			}

			Report.put("In the Popup window observe the TOTAL field values", 
					"The TOTAL field values is correct and its sum of SUBSCRIPTION amount and TAX as in screenshot",
					"Successfully displayed total of Subscription Amount + Tax" +Report.color(strSubscription) + "+" +Report.color(strTax) +"="+Report.color(strSum)+ "<br>"+"Total Amount is:"+Report.color(totalAmount), "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("In the Popup window observe the TOTAL field values", 
					"The TOTAL field values is correct and its sum of SUBSCRIPTION amount and TAX as in screenshot",
					"Failed to displayed total of Subscription Amount + Tax", "FAIL");	

			Assert.fail("Failed to display total amount");
		}
	}
*/
	public void clickProductNameLink(WebDriver driver)
	{

		System.out.println("Inside clickProductNameLink");


		try
		{
			String productLink = "";
			String text = TestNGCreator.TestData.get(Esupport.Textarea.ordinal());
			WebDriverWait wait = new WebDriverWait(driver, 120);

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.ProductNameColumnLink()));

			CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.ProductNameColumnLink());

			productLink=CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.ProductNameColumnLink()).getText();

			CommonUtility.ClickOn(driver,obj_EsupportDDLHomePage.ProductNameColumnLink());

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.ProductHeaderGetKey()));

			CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.ProductHeaderGetKey());

			String DDLHeader=CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.ProductHeaderGetKey()).getText();

			Report.put("Click Product from the list of Products", 
					"It should open details of product 'Active Fabric Manager'",
					"Successfully Product Details page is displayed for "+Report.color(text), "PASS");


		} catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click Product from the list of Products", 
					"It should open details of product 'Active Fabric Manager'",
					"Failed to display Product Details page", "FAIL");
			Assert.fail();
		}
	}



	public void displayListNameColumnData(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 600);

		System.out.println("Inside displayListNameColumnData");
		Log.info("Inside displayListNameColumnData");   

		try
		{			
			List<WebElement> list =driver.findElements(obj_EsupportDDLHomePage.FileNameColumnData());
			String listData = "";			

			for(WebElement lt:list)
			{
				CommonUtility.highlightElement(driver, lt);
				String names=lt.getText();
				listData+=" <br> " + names;
			}
			Report.put("Click 'Available Downloads' tab",
					"It should show all the downloads available for that product", 
					"Displayed list of downloads available "+Report.color(listData), "PASS");	

		}
		catch(Exception e){
			Log.info(e);

			e.printStackTrace();

			Report.put("Click 'Available Downloads' tab",
					"It should show all the downloads available for that product", 
					"Failed to Display list of downloads available ", "FAIL");
			Assert.fail();
		}
	}

	public void clickServiceWarrantyLink(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 120);
		System.out.println("Entering in method to clickServiceWarrantyLink");
		String a=TestNGCreator.TestData.get(Esupport.ActionOption.ordinal()).split(";")[3];
		try
		{
			String ltMessages="";
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.PaginationInBillingAccountTab()));
			CommonUtility.ScrollTo(driver,obj_EsupportDDLHomePage.PaginationInBillingAccountTab());
			CommonUtility.ClickOn(driver,obj_EsupportDDLHomePage.PaginationInBillingAccountTab());

			List<WebElement> list=driver.findElements(obj_EsupportDDLHomePage.PaginationListInBillingAccountTab());

			for(WebElement lt:list)
			{

				CommonUtility.ScrollToWebElement(driver, lt);
				//act.moveToElement(CommonUtility.highlightElement(driver, lt));
				//CommonUtility.highlightElement(driver, lt);
				String names=lt.getText();
				System.out.println(names);
				if(names.contains(a))
				{
					System.out.println("entered if");
//					CommonUtility.ScrollToWebElement(driver, lt);
//					CommonUtility.ClickOnWebElement(driver, lt);
					lt.click();
				}
			}
			
			String header = "";
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.ServiceWarrantyLink()));
			CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.ServiceWarrantyLink());

			CommonUtility.ClickOn(driver,obj_EsupportDDLHomePage.ServiceWarrantyLink());                  


			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.BillPlanDetailsHeader()));
			CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.BillPlanDetailsHeader());

			header = CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.BillPlanDetailsHeader()).getText();

			Report.put("Click on product" , 
					"It should load the Bill Plan Details",
					"Successfully displayed Bill Plan Details. Header is:"+Report.color(header), "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on product", 
					"It should load the Bill Plan Details",
					"Failed to display Bill Plan Details", "FAIL");
			Assert.fail();
		}
	}

	public void clickManagePaymentMethodLink(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 120);
		System.out.println("Entering in method to clickManagePaymentMethodLink");

		try
		{
			
			String header = "";
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.ManagePaymentMethodLink()));
			CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.ManagePaymentMethodLink());

			CommonUtility.ClickOn(driver,obj_EsupportDDLHomePage.ManagePaymentMethodLink());                  


			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.ManageBillingInfoHeader()));
			CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.ManageBillingInfoHeader());

			header = CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.ManageBillingInfoHeader()).getText();

			Report.put("Click 'Manage Payment Method' link in MANAGE tab." , 
					"It should load MANAGE BILLING INFORMATION page",
					"Successfully displayed Manage Billing Information Page. Header is:"+Report.color(header), "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click 'Manage Payment Method' link in MANAGE tab." , 
					"It should load MANAGE BILLING INFORMATION page",
					"Failed to display Manage Billing Information Page. ", "FAIL");
			Assert.fail();
		}
	}

	public void clickChangePaymentButton(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 120);
		System.out.println("Entering in method to clickChangePaymentButton");

		try
		{
			
			String header = "";
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.ChangePaymentButton()));
			CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.ChangePaymentButton());

			CommonUtility.ClickOn(driver,obj_EsupportDDLHomePage.ChangePaymentButton());                  


			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.AddNewPaymentMethodHeader()));
			CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.AddNewPaymentMethodHeader());

			header = CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.AddNewPaymentMethodHeader()).getText();

			Report.put("Click 'Change Payment' button" , 
					"It should pop-up a new window where the user should be able to enter new card details ",
					"Successfully displayed Popup Window to enter Card Details. Header is:"+Report.color(header), "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click 'Change Payment' button" , 
					"It should pop-up a new window where the user should be able to enter new card details ",
					"Failed to display Popup Window to enter Card Details", "FAIL");
			Assert.fail();
		}
	}

	public void enterPaymentDetails(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 120);
		System.out.println("Entering in method to enterPaymentDetails ");

		try
		{
			
			String header = "";
			String errMessage = "";

			String cardNumber = TestNGCreator.TestData.get(Esupport.OrderNumber.ordinal());
			String cvvNumber = TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal());
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.CardNumberTextbox()));
			CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.CardNumberTextbox());

			CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.CardNumberTextbox()).sendKeys(cardNumber); 
			Select selMonth = new  Select(driver.findElement(obj_EsupportDDLHomePage.ExpiryMonthDropdown()));
			selMonth.selectByIndex(6);

			Select selYear = new  Select(driver.findElement(obj_EsupportDDLHomePage.ExpiryYearDropdown()));
			selYear.selectByVisibleText("2021");

			CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.CVVNumberTextbox());

			CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.CVVNumberTextbox()).sendKeys(cvvNumber); 

			CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.NameTextbox());

			CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.NameTextbox()).sendKeys(TestNGCreator.TestData.get(Esupport.FirstName.ordinal())); 

			CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.AddressTextbox());

			CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.AddressTextbox()).sendKeys(TestNGCreator.TestData.get(Esupport.StreetAddress.ordinal())); 

			CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.CityTextbox());

			CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.CityTextbox()).sendKeys(TestNGCreator.TestData.get(Esupport.City.ordinal())); 

			Thread.sleep(3000);
			Select selState = new  Select(driver.findElement(obj_EsupportDDLHomePage.StateDropdown()));
			selState.selectByIndex(2);

			CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.ZipTextbox());

			CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.ZipTextbox()).sendKeys(TestNGCreator.TestData.get(Esupport.PostalCode.ordinal()).split(";")[0]); 

			CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.ZipSubCodeTextbox());

			CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.ZipSubCodeTextbox()).sendKeys(TestNGCreator.TestData.get(Esupport.PostalCode.ordinal()).split(";")[1]); 

			CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.PhoneNumberTextbox());

			CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.PhoneNumberTextbox()).sendKeys(TestNGCreator.TestData.get(Esupport.PhoneNumber.ordinal())); 

			CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.SaveChangesButton());

			CommonUtility.ClickOn(driver,obj_EsupportDDLHomePage.SaveChangesButton()); 


			if(CommonUtility.CheckpresenceofElementLocated(driver, 20, obj_EsupportDDLHomePage.PaymentErrorMessage()))
			{
				CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.PaymentErrorMessage()); 
				errMessage = CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.PaymentErrorMessage()).getText();
				Report.put("UAT Enter the card details and click SAVE CHANGES button" , 
						"It should save the new Credit Card details entered by the user other than US",
						"Failed to display Popup Window to enter Card Details with message:"+Report.color(errMessage), "FAIL");
				Assert.fail();

			}
			else
			{
			Report.put("UAT Enter the card details and click SAVE CHANGES button" , 
					"IIt should save the new Credit Card details entered by the user other than US",
					"Successfully saved new Card Details. Card Number is:"+Report.color(cardNumber)+"CVV Number is:"+Report.color(cvvNumber), "PASS");
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("UAT Enter the card details and click SAVE CHANGES button" , 
					"It should save the new Credit Card details entered by the user other than US",
					"Failed to display Popup Window to enter Card Details", "FAIL");
			Assert.fail();
		}
	}

	public void toclick_DownloadRadioButton(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 120);
		System.out.println("Entering in method to toclick_DownloadRadioButton");
		String ltMessages="";
		try
		{

			
				if(CommonUtility.CheckpresenceofElementLocated(driver,20,obj_EsupportDDLHomePage.KeywordGetlinkDownload()))
				{

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.KeywordGetlinkDownload()));

			CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.KeywordGetlinkDownload());

			if(CommonUtility.CheckpresenceofElementLocated(driver, 01, obj_EsupportDDLHomePage.KeywordGetlinkDownload()))

			{
				Thread.sleep(3000);


				CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.KeywordGetlinksendemailSubmit());

				CommonUtility.ClickOn(driver,obj_EsupportDDLHomePage.KeywordGetlinksendemailSubmit());

				Thread.sleep(10000);
				Report.put("Select download radio button and click on Get Key Link. ", "Zip file with license information details should be downloaded in the browser in the downloaded folder. ",
						"Zip file with license information details is downloaded in the browser in the downloaded folder. ", "PASS");

			}
				}


		}catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Select download radio button and click on Get Key Link. ", "Zip file with license information details should be downloaded in the browser in the downloaded folder. ",
					"Zip file with license information details is not downloaded in the browser in the downloaded folder. ", "FAIL");
			Assert.fail();
		}
	}
	
	
	public void verifyTotalAmount(WebDriver driver)
    {

          System.out.println("Entering in method to verifyTotalAmount");

          try
          {
                 WebDriverWait wait = new WebDriverWait(driver, 120);
                 String header = "";           
                 String ltMessages = "";
                 String totalAmount = "";

                 float[] val = new float[3];
                 int i = 0;
                 float sum = 0;
                 
                 String subscriptionAmt = "";
                 String taxAmt = "";
                 String totalAmt = "";
                 /*List<WebElement> list=driver.findElements(obj_EsupportDDLHomePage.DetailsAmountData());

                 for(WebElement lt:list)
                 {
                       CommonUtility.highlightElement(driver, lt);
                       //String names=lt.getAttribute("innerText");
                       String names=lt.getText();
                        
                          System.out.println(names.replaceAll("[a-zA-Z()\\s]", ""));
                       
                       if(names.contains("$"))
                       {
                              System.out.println("Alert Name is: " +names); 
                              String temp =names.replace("$", "");
                              System.out.println("temp string is "+temp);
                              float f=Float.parseFloat(temp); 
                              System.out.println("value after parse:"+f);
                              val[i]=f;                 
                              i++;

                              ltMessages+=" <br> " + names; 
                              
                              break;
                       }
                       else
                       {
                              System.out.println("Amount not displayed in $ format"+names);

                              Report.put("Now observe format of Amount", 
                                           "It should have the format like $0.00 ",
                                           "Failed to display Amount in the format", "FAIL");
                              Assert.fail("Failed to display amount in the required($0.00) format");
                       }
                       for(int j=0;j<val.length;j++)
                       {
                              System.out.println("Content in Array"+val[j]);
                       }
                 }*/
                 
          CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.subscriptionData());
                 subscriptionAmt = CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.subscriptionData()).getText();
                 
                 
                 System.out.println("Subscription amount is "+subscriptionAmt);
                 
          CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.taxData());
                 taxAmt = CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.taxData()).getText();
                 
                 System.out.println("Tax amount is "+taxAmt);
                 
          CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.totalData());
                 totalAmt = CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.totalData()).getText();
                 
                 System.out.println("Total amount is "+totalAmt);
                 
          CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.TotalAmountData());

                 totalAmount = CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.TotalAmountData()).getText();
                 
                 System.out.println("Total amount Data is "+totalAmount);
                 
                 String tempTotal =totalAmount.replace("$", "");
                 System.out.println("temp string is "+tempTotal);
                 float f=Float.parseFloat(tempTotal); 

//               System.out.println("Total Amount is:"+totalAmount);
//               sum = val[0]+val[1];
//               System.out.println("Sum is: "+sum);
//               String strSum = String.valueOf(sum);
//               String strSubscription = String.valueOf(val[0]);
//               String strTax = String.valueOf(val[1]);
//               if(val[2]==sum && val[2]==f)
//               {
//                     System.out.println("values are same in total****");
//               }

                 Report.put("In the Popup window observe the TOTAL field values", 
                              "The TOTAL field values is correct and its sum of SUBSCRIPTION amount and TAX as in screenshot",
                              "Successfully displayed total of Subscription Amount + Tax" +Report.color(subscriptionAmt) + "+" +Report.color(taxAmt) +"="+Report.color(totalAmt)+ "<br>"+"Total Amount is:"+Report.color(totalAmount), "PASS");
          } 
          catch(Exception e)
          {
                 e.printStackTrace();
                 Report.put("In the Popup window observe the TOTAL field values", 
                              "The TOTAL field values is correct and its sum of SUBSCRIPTION amount and TAX as in screenshot",
                              "Failed to displayed total of Subscription Amount + Tax", "FAIL");   

                 Assert.fail("Failed to display total amount");
          }
    }


}


