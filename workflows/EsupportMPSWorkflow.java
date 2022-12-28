
package com.dell.delta_uat_automation.esupport.workflows;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.csvreader.CsvReader;
import com.dell.delta_uat_automation.utility.CommonUtility;
import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.Log;
import com.dell.delta_uat_automation.utility.Report;
import com.dell.delta_uat_automation.utility.TestNGCreator;


public class EsupportMPSWorkflow extends BaseFlow {

	Random rand = new Random();
	public EsupportIncidentsWorkflow obj_EsupportIncidentsWorkflow = new EsupportIncidentsWorkflow();
	public EsupportIPSWorkflow obj_EsupportIPSWorkflow = new EsupportIPSWorkflow();
	int  n = rand.nextInt() + 1;
	String s=Integer.toString(n);
	public void handleCookies(WebDriver driver)
	{
		System.out.println("Handle Cookies");
		Log.info("Handle Cookies");	
		try{
			WebDriverWait wait = new WebDriverWait(driver, 50);
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
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
		catch(Exception ex){


		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);

	}  


	public void  toClick_SignIn(WebDriver driver) {
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 120);

		try{
			wait = new WebDriverWait(driver, 50);
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			if(CommonUtility.highlightElement(driver,obj_EsupportMPSPage.signIn()).isDisplayed())
			{
				System.out.println("Sign In is selected");
				CommonUtility.highlightElement(driver,obj_EsupportMPSPage.signIn()).click();
				Report.put("Click on Sign in.", "User should be navigate to 'Dell Account Sign In' page", "Successfully navigated to navigate to 'Dell Account Sign In' page", "Pass");

			}}catch(Exception e)
		{
				e.printStackTrace();
				Report.put("Click on Sign in.", "User should be navigate to 'Dell Account Sign In' page", "Not able to navigate 'Dell Account Sign In' page", "FAIL");

				Assert.fail();
		}
	}


	public void  Login(WebDriver driver) {
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 120);

		String name = TestNGCreator.TestData.get(Esupport.Username.ordinal()) ;
		String pwd = TestNGCreator.TestData.get(Esupport.Password.ordinal()) ;
		System.out.println("Entering Login Home Page");

		Log.info("Entering Login Home Page");        

		try{
			wait = new WebDriverWait(driver, 50);
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			//handleCookies(driver);

			CommonUtility.highlightElement(driver,obj_EsupportMPSPage.userName()).sendKeys(name);

			CommonUtility.highlightElement(driver,obj_EsupportMPSPage.password()).sendKeys(pwd);
			Thread.sleep(3000);
			CommonUtility.highlightElement(driver,obj_EsupportMPSPage.userSignIn()).click();
			Thread.sleep(3000);
			if(CommonUtility.highlightElement(driver,obj_EsupportMPSPage.warrentyHeading()).isDisplayed())
			{
				//wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportMPSPage.warrentyHeading()));
				Report.put("Provide the credentials and click on Sign in.", "User should be able to see 'My PRODUCTS AND SERVICES' page with all tabs.", "Successfully navigated to navigate to 'My PRODUCTS AND SERVICES'", "Pass");
			}
		}catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Provide the credentials and click on Sign in.", "User should be able to see 'My PRODUCTS AND SERVICES' page with all tabs.", "Not able to navigate 'My PRODUCTS AND SERVICES'", "FAIL");
			Assert.fail();
		}
	}
	public void clickFaqs(WebDriver driver)
	{
		System.out.println("Click FAQ");
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
		String faqList = "";
		try{
			wait = new WebDriverWait(driver, 50);
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			//handleCookies(driver);
			Thread.sleep(5000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportMPSPage.ProductServicesTab()));
			CommonUtility.highlightElement(driver,obj_EsupportMPSPage.ProductServicesTab());

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportMPSPage.FaqTab()));
			CommonUtility.highlightElement(driver,obj_EsupportMPSPage.FaqTab()).click();



			List<WebElement> list=driver.findElements(obj_EsupportMPSPage.FaqLists());

			for(WebElement lt:list)
			{
				CommonUtility.highlightElement(driver, lt);    
				String tabName=lt.getText();
				System.out.println("Faq is: " +tabName);
				faqList+=" <br> " + tabName;
			}

			System.out.println("FAQs are:"+faqList);
			Report.put("Click on FAQs tab.", "The tab should display the FAQ list.", "The tab displays the FAQ list."+Report.color(faqList), "PASS");

		}
		catch(Exception ex){

			ex.printStackTrace();
			Report.put("Click on FAQs tab.", "The tab should display the FAQ list.", "The tab does not display the FAQ list.", "Fail");
			Assert.fail();
		}

	}  

	public void  MPSLogin(WebDriver driver) {
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 120);

		String name = TestNGCreator.TestData.get(Esupport.Username.ordinal()) ;
		String pwd = TestNGCreator.TestData.get(Esupport.Password.ordinal()) ;
		System.out.println("Entering Login Home Page");

		Log.info("Entering Login Home Page");        

		try{
			wait = new WebDriverWait(driver, 50);
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportMPSPage.MpsPageHeader()));
			CommonUtility.highlightElement(driver,obj_EsupportMPSPage.MpsPageHeader());
			Report.put("Navigate to MPS page ", 
					"User should be able to see 'My Products and Services' page with Login option. ", 
					"Successfully Navigated to MPS Page", "PASS");

			CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.MpsSignIn());
			CommonUtility.ClickOn(driver,obj_EsupportMPSPage.MpsSignIn());
			//handleCookies(driver);

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportMPSPage.DellImg()));
			CommonUtility.highlightElement(driver,obj_EsupportMPSPage.DellImg());

			Report.put("Click on Sign in", 
					"User should be naviagate to 'Dell Account Sign In' page. ", 
					"Successfully Navigated to MPS Page", "PASS");


			CommonUtility.highlightElement(driver,obj_EsupportMPSPage.userName()).clear();
			CommonUtility.highlightElement(driver,obj_EsupportMPSPage.userName()).sendKeys(name);
			CommonUtility.highlightElement(driver,obj_EsupportMPSPage.password()).clear();
			Thread.sleep(3000);
			CommonUtility.highlightElement(driver,obj_EsupportMPSPage.password()).sendKeys(pwd);

			CommonUtility.highlightElement(driver,obj_EsupportMPSPage.userSignIn()).click();


			Report.put("Provide the credentials and click on Sign in. ", 
					"Application should navigate to MPS page and it should display the following tabs", 
					"Successfully Navigated to MPS Page", "PASS");

			Thread.sleep(3000);


			Report.put("Enter Valid User Name and Password click on Sign In button ", "Application should navigate to Support Notifications page and it should display available Subscriptions and Drivers Subscriptions should display under Driver updates", "Successfully Drivers Subscriptions page is displayed ", "Pass");

		}catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Enter valid credentials", "Not able to find valid credentials ", "Not able to Signin in to the Drivers and downloads", "Fail");

			Assert.fail();
		}
	}
	public void  validateTabs(WebDriver driver)
	{
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 120);

		String wartab = "";
		String pltab = "";
		String fadtab = "";
		String groupstab = "";
		String faqstab = "";

		Log.info("Entering validateTabs");        

		try{

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportMPSPage.MpsHeader()));
			CommonUtility.highlightElement(driver,obj_EsupportMPSPage.MpsHeader());

			if(CommonUtility.highlightElement(driver,obj_EsupportMPSPage.WarrantyTab()).isDisplayed())
			{

				CommonUtility.highlightElement(driver,obj_EsupportMPSPage.WarrantyTab());
				wartab = CommonUtility.highlightElement(driver,obj_EsupportMPSPage.WarrantyTab()).getText();
			}

			if(CommonUtility.highlightElement(driver,obj_EsupportMPSPage.ProductListTab()).isDisplayed())
			{

				CommonUtility.highlightElement(driver,obj_EsupportMPSPage.ProductListTab());
				pltab = CommonUtility.highlightElement(driver,obj_EsupportMPSPage.ProductListTab()).getText();
			}

			if(CommonUtility.highlightElement(driver,obj_EsupportMPSPage.FindAddProductsTab()).isDisplayed())
			{

				CommonUtility.highlightElement(driver,obj_EsupportMPSPage.FindAddProductsTab());
				fadtab = CommonUtility.highlightElement(driver,obj_EsupportMPSPage.FindAddProductsTab()).getText();
			}

			if(CommonUtility.highlightElement(driver,obj_EsupportMPSPage.GroupsTab()).isDisplayed())
			{

				CommonUtility.highlightElement(driver,obj_EsupportMPSPage.GroupsTab());
				groupstab = CommonUtility.highlightElement(driver,obj_EsupportMPSPage.GroupsTab()).getText();
			}

			if(CommonUtility.highlightElement(driver,obj_EsupportMPSPage.FaqsTab()).isDisplayed())
			{

				CommonUtility.highlightElement(driver,obj_EsupportMPSPage.FaqsTab());
				faqstab = CommonUtility.highlightElement(driver,obj_EsupportMPSPage.FaqsTab()).getText();
			}



			Report.put("Application should navigate to MPS page and it should display the following tabs ", 
					"Warranty status, Product List, Find & Add Products, Groups, FAQS Tab must be displayed",
					"Tabs displayed successfully" +Report.color(wartab)+"<br>"+Report.color(pltab)+"<br>"+Report.color(fadtab)+"<br>"+Report.color(groupstab)+"<br>"+Report.color(faqstab),"PASS");  
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Application should navigate to MPS page and it should display the following tabs ", 
					"Warranty status, Product List, Find & Add Products, Groups, FAQS Tab must be displayed",
					"Tabs display failed", "FAIL");  
			Assert.fail();
		}
	}


	public void  validateCustomerElements(WebDriver driver)
	{
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 120);

		String submitButton = "";
		String selcountrymul = "";
		String selcountrysingle = "";
		String submitButtonSingle = "";
		Actions act=new Actions(driver);


		Log.info("Entering validateCustomerElements");        

		try
		{

			CommonUtility.scrollToViewElement(driver, obj_EsupportMPSPage.SubmitButtonMultiple());
			//act.moveToElement(CommonUtility.highlightElement(driver, obj_EsupportMPSPage.SubmitButtonMultiple())).build().perform();
			if(CommonUtility.highlightElement(driver,obj_EsupportMPSPage.MultipleCustomerNumberBox()).isDisplayed())
			{

				CommonUtility.highlightElement(driver,obj_EsupportMPSPage.MultipleCustomerNumberBox());

			}

			if(CommonUtility.highlightElement(driver,obj_EsupportMPSPage.CountryDropdownMultiple()).isDisplayed())
			{

				CommonUtility.highlightElement(driver,obj_EsupportMPSPage.CountryDropdownMultiple());
				Select selCountry = new  Select(driver.findElement(obj_EsupportMPSPage.CountryDropdownMultiple()));



				selcountrymul = selCountry.getFirstSelectedOption().getText();
				System.out.println("Selected option is "+selcountrymul);

			}

			if(CommonUtility.highlightElement(driver,obj_EsupportMPSPage.SubmitButtonMultiple()).isDisplayed())
			{

				CommonUtility.highlightElement(driver,obj_EsupportMPSPage.SubmitButtonMultiple());
				submitButton = CommonUtility.highlightElement(driver,obj_EsupportMPSPage.SubmitButtonMultiple()).getText();
				System.out.println("Submit button text mutliple is "+submitButton);
			}

			if(CommonUtility.highlightElement(driver,obj_EsupportMPSPage.CustomerNumberTextbox()).isDisplayed())
			{

				CommonUtility.highlightElement(driver,obj_EsupportMPSPage.CustomerNumberTextbox());

			}

			if(CommonUtility.highlightElement(driver,obj_EsupportMPSPage.CountryDropdownSingle()).isDisplayed())
			{

				CommonUtility.highlightElement(driver,obj_EsupportMPSPage.CountryDropdownSingle());
				Select selCountry = new  Select(driver.findElement(obj_EsupportMPSPage.CountryDropdownMultiple()));


				//CountryDropdownMultiple.selectByVisibleText("Customer Number"); 
				selcountrysingle = selCountry.getFirstSelectedOption().getText();
				System.out.println("Selected option is "+selcountrysingle);

			}

			if(CommonUtility.highlightElement(driver,obj_EsupportMPSPage.SubmitButtonSingle()).isDisplayed())
			{

				CommonUtility.highlightElement(driver,obj_EsupportMPSPage.SubmitButtonSingle());
				submitButtonSingle = CommonUtility.highlightElement(driver,obj_EsupportMPSPage.SubmitButtonSingle()).getText();
				System.out.println("Submit button text Single is "+submitButtonSingle);
			}

			Report.put("Application should provide the text box to enter customer numbers along with country dropdown and Find Products button and it should also display another text box for single customer number along with country drop down and Find Products button", 
					"All the elements  must be displayed",
					"Elements displayed successfully" +Report.color(selcountrymul)+"<br>"+Report.color(submitButton)+"<br>"+Report.color(selcountrysingle)+"<br>"+Report.color(submitButtonSingle), "PASS");  
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Application should provide the text box to enter customer numbers along with country dropdown and Find Products button and it should also display another text box for single customer number along with country drop down and Find Products button", 
					"All the elements  must be displayed",
					"Elements display failed", "FAIL");  
			Assert.fail();
		}
	}

	public void  enterCustomerNumber(WebDriver driver)
	{
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 120);

		String custNumber = TestNGCreator.TestData.get(Esupport.CustomerNumber.ordinal());
		String selcountrysingle = "";
		String country = TestNGCreator.TestData.get(Esupport.Country.ordinal());

		String ServiceTagTHeader = "";
		String DescriptionTHeader = "";
		String ModelTHeader = "";
		String DateShippedTHeader = "";
		String WarrantyServiceTHeader = "";
		String DaysRemainingTHeader = "";




		Log.info("Entering enterCustomerNumber");        

		try{

			if(CommonUtility.highlightElement(driver,obj_EsupportMPSPage.CustomerNumberTextbox()).isDisplayed())
			{
				CommonUtility.highlightElement(driver,obj_EsupportMPSPage.CustomerNumberTextbox()).sendKeys(custNumber);
				if(CommonUtility.highlightElement(driver,obj_EsupportMPSPage.CountryDropdownSingle()).isDisplayed())
				{
					Select selCountry = new  Select(driver.findElement(obj_EsupportMPSPage.CountryDropdownSingle()));

					selcountrysingle = selCountry.getFirstSelectedOption().getText();
					if(selcountrysingle.equals(country))
					{
						System.out.println("Selected option is "+country);
					}
					else
					{
						selCountry.selectByVisibleText(country);
						selcountrysingle = selCountry.getFirstSelectedOption().getText();
						System.out.println("Selected option is "+selcountrysingle);
					}

				}
				if(CommonUtility.highlightElement(driver,obj_EsupportMPSPage.SubmitButtonSingle()).isDisplayed())
				{
					CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.SubmitButtonSingle());
					CommonUtility.ClickOn(driver,obj_EsupportMPSPage.SubmitButtonSingle());
				}

				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportMPSPage.FindAddProductsHeader()));

				if(CommonUtility.highlightElement(driver,obj_EsupportMPSPage.ServiceTagTHeader()).isDisplayed())
				{
					CommonUtility.highlightElement(driver,obj_EsupportMPSPage.ServiceTagTHeader());
					ServiceTagTHeader = CommonUtility.highlightElement(driver,obj_EsupportMPSPage.ServiceTagTHeader()).getText();
					System.out.println("Header is: "+ServiceTagTHeader);
				}

				if(CommonUtility.highlightElement(driver,obj_EsupportMPSPage.DescriptionTHeader()).isDisplayed())
				{
					CommonUtility.highlightElement(driver,obj_EsupportMPSPage.DescriptionTHeader());
					DescriptionTHeader = CommonUtility.highlightElement(driver,obj_EsupportMPSPage.DescriptionTHeader()).getText();
					System.out.println("Header is: "+DescriptionTHeader);
				}

				if(CommonUtility.highlightElement(driver,obj_EsupportMPSPage.ModelTHeader()).isDisplayed())
				{
					CommonUtility.highlightElement(driver,obj_EsupportMPSPage.ModelTHeader());
					ModelTHeader = CommonUtility.highlightElement(driver,obj_EsupportMPSPage.ModelTHeader()).getText();
					System.out.println("Header is: "+ModelTHeader);
				}

				if(CommonUtility.highlightElement(driver,obj_EsupportMPSPage.DateShippedTHeader()).isDisplayed())
				{
					CommonUtility.highlightElement(driver,obj_EsupportMPSPage.DateShippedTHeader());
					DateShippedTHeader = CommonUtility.highlightElement(driver,obj_EsupportMPSPage.DateShippedTHeader()).getText();
					System.out.println("Header is: "+DateShippedTHeader);
				}

				if(CommonUtility.highlightElement(driver,obj_EsupportMPSPage.WarrantyServiceTHeader()).isDisplayed())
				{
					CommonUtility.highlightElement(driver,obj_EsupportMPSPage.WarrantyServiceTHeader());
					WarrantyServiceTHeader = CommonUtility.highlightElement(driver,obj_EsupportMPSPage.WarrantyServiceTHeader()).getText();
					System.out.println("Header is: "+WarrantyServiceTHeader);
				}

				if(CommonUtility.highlightElement(driver,obj_EsupportMPSPage.DaysRemainingTHeader()).isDisplayed())
				{
					CommonUtility.highlightElement(driver,obj_EsupportMPSPage.DaysRemainingTHeader());
					DaysRemainingTHeader = CommonUtility.highlightElement(driver,obj_EsupportMPSPage.DaysRemainingTHeader()).getText();
					System.out.println("Header is: "+DaysRemainingTHeader);
				}

				Report.put("Enter 12 digit customer number in single customer number text box and select country as united states and Click on Find Products",
						"Application should navigate to Product List tab and it should display the products details related to the selected customer ",
						"Navigated to Product List Tab Successfully. Table Headers are: "+Report.color(ServiceTagTHeader)+"<br>"+ Report.color(DescriptionTHeader)+"<br>"
								+Report.color(ModelTHeader)+"<br>"
								+Report.color(DateShippedTHeader)+"<br>"+Report.color(WarrantyServiceTHeader)+"<br>"+Report.color(DaysRemainingTHeader), "PASS");
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Enter 12 digit customer number in single customer number text box and select country as united states and Click on Find Products",
					"Application should navigate to Product List tab and it should display the products details related to the selected customer ",
					"Navigated to Product List Tab failed.", "FAIL");
			Assert.fail();
		}
	}
	//Sudha
	public void  toClick_GroupsTab(WebDriver driver) {
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 120);
		String createGroup="";
		try{
			wait = new WebDriverWait(driver, 50);
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

			if(CommonUtility.highlightElement(driver,obj_EsupportMPSPage.groupsTab()).isDisplayed())
			{
				System.out.println("Click on Groups Tab");
				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.groupsTab());
				CommonUtility.ClickOn(driver,obj_EsupportMPSPage.groupsTab());
				Thread.sleep(10000);
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportMPSPage.createNewGroup()));
				createGroup=CommonUtility.highlightElement(driver,obj_EsupportMPSPage.createNewGroup()).getText();
				System.out.println("Header is : "+createGroup);
				Report.put("Click on 'Groups' tab.", "User should be able to see the created groups", "User able to see" +Report.color(createGroup), "Pass");

			}
		}catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on 'Groups' tab.", "User should be able to see the created groups", "User not able to see" +Report.color(createGroup), "FAIL");

			Assert.fail();
		}
	}


	public void  toClick_CreateNewGroup(WebDriver driver) {
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 120);
		String PopupHeading="";
		try{
			wait = new WebDriverWait(driver, 50);
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			Thread.sleep(6000);
			System.out.println("Click on Create New Groups button");
			CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.createNewGroup());
			CommonUtility.ClickOn(driver,obj_EsupportMPSPage.createNewGroup());
			Thread.sleep(6000);
			OpenThePopWindow(driver);
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportMPSPage.popupHeading()));
			PopupHeading=CommonUtility.highlightElement(driver,obj_EsupportMPSPage.popupHeading()).getText();


			//System.out.println("Header is : "+PopupHeading);
			Report.put("Click on Create a new Group", "User should be able to see 'Create a group' pop up", "User able to see" +Report.color(PopupHeading)+ "pop up", "Pass");


		}catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on 'Groups' tab.", "User should be able to see the created groups", "User not able to see" +Report.color(PopupHeading)+ "pop up", "FAIL");

			Assert.fail();
		}
	}


	public void  toGive_GroupName(WebDriver driver, String name) {
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 120);
		String SuccessMessage="";

		try{
			wait = new WebDriverWait(driver, 50);
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

			System.out.println("Give Group name");
			CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.groupName());
			CommonUtility.highlightElement(driver,obj_EsupportMPSPage.groupName()).sendKeys(name);
			CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.saveGroup());
			CommonUtility.ClickOn(driver,obj_EsupportMPSPage.saveGroup());
			Thread.sleep(6000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportMPSPage.createNewGroup()));

			SuccessMessage=CommonUtility.highlightElement(driver,obj_EsupportMPSPage.successMsg()).getText();


			System.out.println("Success Message : "+SuccessMessage);
			Report.put("Give a Group name and click on Save group", "User should be able to see success message and Group should be created successfully", "User able to see" +Report.color(SuccessMessage), "Pass");


		}catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Give a Group name and click on Save group", "User should be able to see success message and Group should be created successfully", "User able to see" +Report.color(SuccessMessage), "FAIL");

			Assert.fail();
		}
	}

	public void  toClick_AddProducts(WebDriver driver, String name) {
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 120);
		String ProductList="";
		try{
			wait = new WebDriverWait(driver, 50);
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

			System.out.println("Click on Add products");
			//CommonUtility.scrollToViewElement(driver,obj_EsupportMPSPage.addproducts());
			((JavascriptExecutor)driver).executeScript("scroll(0, 500)"); 
			Thread.sleep(3000);

			String path="(//div[contains(@class,'col-sm')]//a[contains(normalize-space(),'"+name+"')]//following::p//a[text()='Add Products'])[1]]";
			System.out.println(path);


			driver.findElement(By.xpath(path)).click();
			Thread.sleep(3000);

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportMPSPage.productListHeader()));
			ProductList=CommonUtility.highlightElement(driver,obj_EsupportMPSPage.productListHeader()).getText();


			//System.out.println("Header is : "+PopupHeading);
			Report.put("Click On 'Add products'", "User should be navigated to 'Product List'", "User is navigated to" +Report.color(ProductList)+ "tab", "Pass");


		}catch(Exception e)
		{
			e.printStackTrace();

			Assert.fail();
		}
	}

	public void  toSelect_AddProducts(WebDriver driver) {
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 120);

		String SuccessMessage="";
		try{
			wait = new WebDriverWait(driver, 50);
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

			System.out.println("Select products");
			CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.productItem());
			CommonUtility.ClickOn(driver,obj_EsupportMPSPage.productItem());

			CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.addGroup());
			CommonUtility.ClickOn(driver,obj_EsupportMPSPage.addGroup());
			Thread.sleep(6000);

			//wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportMPSPage.successMsg()));
			SuccessMessage=CommonUtility.highlightElement(driver,obj_EsupportMPSPage.successtoaddGroup()).getText();


			//System.out.println("Header is : "+PopupHeading);
			Report.put("Select the check box and click on 'Add to group' button.", "Success message should be displayed to the user and Products should be added successfully.", "User is navigated to" +Report.color(SuccessMessage), "Pass");


		}catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Select the check box and click on 'Add to group' button.", "Success message should be displayed to the user and Products should be added successfully.", "User is navigated to" +Report.color(SuccessMessage), "FAIL");
			Assert.fail();
		}
	}

	public void  toVerify_Links(WebDriver driver) {
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 120);
		String ProductList="";
		try{
			wait = new WebDriverWait(driver, 50);
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

			System.out.println("Verify the Links");
			String path="//div[@class='col-sm-7']/h3/a[contains(text(),'"+s+"')]/../following-sibling::p/a[contains(text(),'Remove Products' )]";
			System.out.println(path);
			CommonUtility.highlightElement(driver,obj_EsupportMPSPage.export());
			CommonUtility.highlightElement(driver,obj_EsupportMPSPage.rename());
			CommonUtility.highlightElement(driver,obj_EsupportMPSPage.delete());

			String export=CommonUtility.highlightElement(driver,obj_EsupportMPSPage.export()).getText();
			String rename=CommonUtility.highlightElement(driver,obj_EsupportMPSPage.rename()).getText();
			String delete=CommonUtility.highlightElement(driver,obj_EsupportMPSPage.delete()).getText();

			if(driver.findElement(obj_EsupportMPSPage.export()).isDisplayed())
			{
				if(driver.findElement(obj_EsupportMPSPage.rename()).isDisplayed())
				{
					if(driver.findElement(obj_EsupportMPSPage.delete()).isDisplayed())
					{

						System.out.println(export);
						Thread.sleep(30000);

						//CommonUtility.highlightElement(driver,obj_EsupportMPSPage.export()).click();

						System.out.println(rename);
						Thread.sleep(6000);
						CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.renameLink());
						CommonUtility.ClickOn(driver,obj_EsupportMPSPage.renameLink());
						Thread.sleep(10000);
						OpenThePopWindow(driver);
						CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.cancelButton());
						CommonUtility.ClickOn(driver,obj_EsupportMPSPage.cancelButton());
						Thread.sleep(5000);

						System.out.println(delete);
						CommonUtility.ClickOn(driver,obj_EsupportMPSPage.delete());
						CommonUtility.ClickOn(driver,obj_EsupportMPSPage.delete());
						OpenThePopWindow(driver);
						Thread.sleep(5000);
						CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.closeButton());

						CommonUtility.ClickOn(driver,obj_EsupportMPSPage.closeButton());


						Report.put("Test for 'Export','rename','delete' links",
								"All the links("+Report.color(export)+","+Report.color(rename)+","+Report.color(delete)+")should be work as expected",
								"Links are working as expected. ", "PASS");
					}
				}
			}


		}catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Test for 'Export','rename','delete' links",
					"All the links should be work as expected",
					"Links are not working as expected. ", "FAIL");
			Assert.fail();
		}
	}
	public void  toClick_RemoveProducts(WebDriver driver) {
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 120);
		String ProductList="";
		try{
			wait = new WebDriverWait(driver, 50);
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

			System.out.println("Click on Remove products");
			//CommonUtility.scrollToViewElement(driver,obj_EsupportMPSPage.addproducts());
			((JavascriptExecutor)driver).executeScript("scroll(0, 500)"); 
			Thread.sleep(3000);
			String path="//div[@class='col-sm-7']/h3/a[contains(text(),'"+s+"')]/../following-sibling::p/a[contains(text(),'Remove Products' )]";
			System.out.println(path);


			driver.findElement(By.xpath(path)).click();
			Thread.sleep(3000);


			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportMPSPage.productListHeader()));
			ProductList=CommonUtility.highlightElement(driver,obj_EsupportMPSPage.productListHeader()).getText();
			System.out.println("Remove Products");
			CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.productItem());
			CommonUtility.ClickOn(driver,obj_EsupportMPSPage.productItem());

			CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.removeFromGroup());
			CommonUtility.ClickOn(driver,obj_EsupportMPSPage.removeFromGroup());


			Report.put("Click on remove produts", "Added products should be removed successfully", "Products removed successfully", "Pass");


		}catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on remove produts", "Added products should be removed successfully", "Products not removed successfully", "FAIL");

			Assert.fail();
		}
	}
	//Sujatha
	public void  ALLTabsMPSPage(WebDriver driver) {
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 120);


		System.out.println("Entering  in Function ALLTabsMPSPage");

		Log.info("Entering  in Function ALLTabsMPSPage");        

		try{

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportMPSPage.mPSHeader()));
			String MPSHeader=CommonUtility.highlightElement(driver,obj_EsupportMPSPage.mPSHeader()).getText();
			Report.put("Provide the credentials and click on Sign in. ", "User should be able to see "+Report.color(MPSHeader)+" page with all tabs.", "Successfully User should be able to naviagate to 'Dell Account Sign In' page. ", "Pass");


			//	handleCookies(driver);

			String ltMessages="";
			CommonUtility.highlightElement(driver,obj_EsupportMPSPage.aLLTabsMPSPage());

			List<WebElement> list=driver.findElements(obj_EsupportMPSPage.aLLTabsMPSPage());

			for(WebElement lt:list)
			{
				CommonUtility.highlightElement(driver, lt);
				String names=lt.getText();

				System.out.println("Alert Name is: " +names);
				ltMessages+=" <br> " + names;


			}


			Report.put("User is able to navigate and see all the Tabs. ", "User should be able to see Tabs Like "
					+Report.color(ltMessages), "Successfully User should be able to see all the Tabs in My Products and Services page ", "Pass");



		}catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Provide the credentials and click on Sign in.", "User should be able to see 'My PRODUCTS AND SERVICES' page with all tabs.", "Not able to navigate 'My PRODUCTS AND SERVICES'", "FAIL");
			Assert.fail();
		}
	}


	public void  ClickonFindProducts(WebDriver driver) {
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 120);


		System.out.println("Entering  in Function ClickonFindProductse");

		Log.info("Entering  in Function ClickonFindProducts");        

		try{


			CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.ClickonFindProducts());
			CommonUtility.ClickOn(driver,obj_EsupportMPSPage.ClickonFindProducts());
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportMPSPage.findProductsByHeader()));
			String findProductsByHeader=CommonUtility.highlightElement(driver,obj_EsupportMPSPage.findProductsByHeader()).getText();

			Report.put("Click on 'Find & Add Products' tab.  ", "User should be able to see "+Report.color(findProductsByHeader)+" by drop down box and a text box to enter Service tags. ", "Successfully User should be able to see Find products by drop down box and a text box to enter Service tags. ", "Pass");



			// Report.put("Enter Valid User Name and Password click on Sign In button ", "Application should navigate to Support Notifications page and it should display available Subscriptions and Drivers Subscriptions should display under Driver updates", "Successfully Drivers Subscriptions page is displayed ", "Pass");

		}catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Enter valid credentials", "Not able to find valid credentials ", "Not able to Signin in to the Drivers and downloads", "FAIL");

			Assert.fail();
		}
	}

	public void  ToSelect_Servicetag(WebDriver driver) {
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 120);


		System.out.println("Entering  in Function ToSelect_Servicetag");

		Log.info("Entering  in Function ToSelect_Servicetag");        

		try{


			Select select = new Select(CommonUtility.highlightElement(driver,obj_EsupportMPSPage.findProductsByDD()));
			WebElement option =select.getFirstSelectedOption();
			String defaultItem = option.getText();
			System.out.println(defaultItem); 


			Report.put("Select Service tag option from 'Find support by' drop down box ByDeafault  ", "User should be able to select the "+Report.color(defaultItem)+" successfully. ", "User should be able to select the option successfully.", "Pass");


		}catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Select Service tag option from 'Find support by' drop down box ByDeafault  ", "User is not able to select the options . ", "User is not able to select the options.", "FAIL");

			Assert.fail();
		}
	}
	public void  ToEnterService_ClickFIndProducts(WebDriver driver, String Servicetag) {
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 120);


		System.out.println("Entering  in Function ToEnterService_ClickFIndProducts");

		Log.info("Entering  in Function ToEnterService_ClickFIndProducts");        

		try{

			ClickonFindProducts(driver);

			CommonUtility.highlightElement(driver,obj_EsupportMPSPage.serviceTagHeaderTextbox()).sendKeys(Servicetag);
			CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.clickonServicetabFindProducts());
			CommonUtility.ClickOn(driver,obj_EsupportMPSPage.clickonServicetabFindProducts());

			Report.put("Provide the service tag and click on 'Find products'.  ", "User should be able see the product details.", "successfully User should be able see the product details.", "Pass");


		}catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Select Service tag option from 'Find support by' drop down box ByDeafault  ", "User is not able to select the options . ", "User is not able to select the options.", "FAIL");

			Assert.fail();
		}
	}

	public void  ToDeleteServiceTag_Productlink(WebDriver driver, String Servicetag) {
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 120);


		System.out.println("Entering  in Function ToDeleteServiceTag_Productlink");

		Log.info("Entering  in Function ToDeleteServiceTag_Productlink");        

		try{
			CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.clickonOnProductLink());
			CommonUtility.ClickOn(driver,obj_EsupportMPSPage.clickonOnProductLink());

			Thread.sleep(6000);

			CommonUtility.highlightElement(driver,obj_EsupportMPSPage.productlinkServiceTag()).sendKeys(Servicetag);

			Thread.sleep(6000);
			CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.productlinkServiceTagsearch());
			CommonUtility.ClickOn(driver,obj_EsupportMPSPage.productlinkServiceTagsearch());

			Thread.sleep(3000);




			if(CommonUtility.CheckpresenceofElementLocated(driver, 10, obj_EsupportMPSPage.noProductsfound()))
			{

				String noProductsfound=CommonUtility.highlightElement(driver,obj_EsupportMPSPage.noProductsfound()).getText();

				System.out.println("Companyname is displayed.."+noProductsfound);


			}
			else
			{
				Actions act=new Actions(driver);

				Thread.sleep(4000);

				CommonUtility.highlightElement(driver,obj_EsupportMPSPage.serviceCheckboxclick());
				// CommonUtility.highlightElement(driver,obj_EsupportMPSPage.serviceCheckboxclick()).sendKeys(Keys.ENTER);
				//CommonUtility.highlightElement(driver,obj_EsupportMPSPage.serviceCheckboxclick()).click();

				WebElement element =driver.findElement(By.xpath("//div[@class='chex checkBoxGrid']//input"));
				act.moveToElement(element).build().perform();
				((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);  




				Thread.sleep(5000);


				CommonUtility.highlightElement(driver,obj_EsupportMPSPage.selectActionDDDelete());

				Thread.sleep(2000);


				Select selState = new  Select(driver.findElement(obj_EsupportMPSPage.selectActionDDDelete()));
				selState.selectByVisibleText("Delete from My Products List");


				Thread.sleep(6000);
				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.selectActionDDDeleteApply());
				CommonUtility.ClickOn(driver,obj_EsupportMPSPage.selectActionDDDeleteApply());
				Thread.sleep(6000);

				if(CommonUtility.highlightElement(driver,obj_EsupportMPSPage.selectActionDDDeleteApplyPOPUP()).isDisplayed())
				{
					//					CommonUtility.highlightElement(driver,obj_EsupportMPSPage.selectActionDDDeleteApplyPOPUP()).click();
					CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.selectActionDDDeleteApplyPOPUP());
					CommonUtility.ClickOn(driver,obj_EsupportMPSPage.selectActionDDDeleteApplyPOPUP());
				}

				Thread.sleep(6000);

			}


		}catch(Exception e)
		{
			e.printStackTrace();

			Assert.fail();
		}
	}

	public void  ToClickAddSelectProduct(WebDriver driver) {
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 120);


		System.out.println("Entering  in Function v");

		Log.info("Entering  in Function ToClickAddSelectProduct");        

		try{
			CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.clickAddSelectProduct());
			CommonUtility.ClickOn(driver,obj_EsupportMPSPage.clickAddSelectProduct());



			Report.put("Click on 'Add selected products'.   ", "The product should be added successfully.", "successfully The product should be added", "Pass");


		}catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on 'Add selected products'.   ", "The product is not added successfully.", "The product is not added successfully.", "Pass");

			Assert.fail();
		}
	}

	public void  ToVerifyViewProductLink(WebDriver driver) {
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 120);


		System.out.println("Entering  in Function ToVerifyViewProductLink");

		Log.info("Entering  in Function ToVerifyViewProductLink");        

		try{
			Thread.sleep(6000);
			ToClickAddSelectProduct(driver);
			Thread.sleep(6000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportMPSPage.viewProductLinkHeader()));
			CommonUtility.highlightElement(driver,obj_EsupportMPSPage.viewProductLinkHeader());
			//Report.put("Provide the credentials and click on Sign in. ", "User should be able to see "+Report.color(MPSHeader)+" page with all tabs.", "Successfully User should be able to naviagate to 'Dell Account Sign In' page. ", "Pass");
			CommonUtility.highlightElement(driver,obj_EsupportMPSPage.viewProductLink());
			String viewProductLinkHeader=CommonUtility.highlightElement(driver,obj_EsupportMPSPage.viewProductLinkHeader()).getText();



			Report.put("Click on "+Report.color(viewProductLinkHeader)+" hyper link.   ", "The page should be navigated to 'Product list' tab.", "successfully The page should be navigated to 'Product list' tab.", "PASS");


		}catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Select Service tag option from 'Find support by' drop down box ByDeafault  ", "User is not able to select the options . ", "User is not able to select the options.", "FAIL");

			Assert.fail();
		}
	}


	public void  ToVerifyServiceTag_inProductlink(WebDriver driver, String Servicetag) {
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 120);


		System.out.println("Entering  in Function ToVerifyServiceTag_inProductlink");

		Log.info("Entering  in Function ToVerifyServiceTag_inProductlink");        

		try{
			CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.clickonOnProductLink());
			CommonUtility.ClickOn(driver,obj_EsupportMPSPage.clickonOnProductLink());

			Thread.sleep(6000);

			CommonUtility.highlightElement(driver,obj_EsupportMPSPage.productlinkServiceTag()).sendKeys(Servicetag);
			CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.productlinkServiceTagsearch());
			CommonUtility.ClickOn(driver,obj_EsupportMPSPage.productlinkServiceTagsearch());

			Thread.sleep(6000);




			if(CommonUtility.CheckpresenceofElementLocated(driver, 10, obj_EsupportMPSPage.noProductsfound()))
			{

				String noProductsfound=CommonUtility.highlightElement(driver,obj_EsupportMPSPage.noProductsfound()).getText();

				System.out.println("Companyname is displayed.."+noProductsfound);

				Report.put("Provide the service tag and click on 'Search' icon.  ", "User is not able to see the product.", "User is not able to see the product.", "PASS");


			}
			else
			{

				Thread.sleep(3000);

				CommonUtility.highlightElement(driver,obj_EsupportMPSPage.viewProductLinksearch());

				String viewProductLinksearch=CommonUtility.highlightElement(driver,obj_EsupportMPSPage.viewProductLinksearch()).getText();

				Report.put("Provide the service tag and click on 'Search' icon.  ", "User should be able to see the product. with ServiceTag as "+Report.color(viewProductLinksearch), "Successfully User should be able to see the product.", "PASS");


				Thread.sleep(2000);

			}


		}catch(Exception e)
		{
			e.printStackTrace();

			Assert.fail();
		}
	}




	public void  clickOnFindAddProduct(WebDriver driver)
	{
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 120);



		Log.info("Entering clickOnFindAddProduct");        

		try{

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportMPSPage.mPSHeader()));
			CommonUtility.highlightElement(driver,obj_EsupportMPSPage.mPSHeader());

			CommonUtility.highlightElement(driver,obj_EsupportMPSPage.FindAddProductsTab()).click();

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportMPSPage.FindAddProductsHeader()));
			if(CommonUtility.highlightElement(driver,obj_EsupportMPSPage.FindAddProductsHeader()).isDisplayed())
			{
				CommonUtility.highlightElement(driver,obj_EsupportMPSPage.FindAddProductsHeader());

				Report.put("Click on Find & Add Products",
						"Application should display Find & Add products page",
						"Find & Add products page displayed Successfully", "PASS");
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on Find & Add Products",
					"Application should display Find & Add products page",
					"Failed to display Find & Add products page", "FAIL");
			Assert.fail();
		}
	}
	public void  selectCustomerNumber(WebDriver driver)
	{
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 120);
		String custNumber = TestNGCreator.TestData.get(Esupport.CustomerNumber.ordinal()); 

		Log.info("Entering selectCustomerNumber");        

		try{
			if(CommonUtility.highlightElement(driver,obj_EsupportMPSPage.FindProdDropdown()).isDisplayed()) 
			{
				//CommonUtility.highlightElement(driver,obj_EsupportMPSPage.FindProdDropdown()).click(); 
				Select selProdBy = new  Select(driver.findElement(obj_EsupportMPSPage.FindProdDropdown()));


				selProdBy.selectByVisibleText("Customer Number"); 
				String selectedopt = selProdBy.getFirstSelectedOption().getText();
				System.out.println("Selected option is "+selectedopt);
				Thread.sleep(10000);
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on Find & Add Products",
					"Application should display Find & Add products page",
					"Failed to display Find & Add products page", "FAIL");
			Assert.fail();
		}
	}


	public void  TOselect_CustomerNumber(WebDriver driver)
	{
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 120);
		String custNumber = TestNGCreator.TestData.get(Esupport.CustomerNumber.ordinal()); 

		Log.info("Entering in Function TOselect_CustomerNumber");        

		try{
			if(CommonUtility.highlightElement(driver,obj_EsupportMPSPage.CustomerNumberTextbox()).isDisplayed())
			{
				CommonUtility.highlightElement(driver,obj_EsupportMPSPage.CustomerNumberTextbox()).sendKeys(custNumber);

			}

			if(CommonUtility.highlightElement(driver,obj_EsupportMPSPage.SubmitButtonSingle()).isDisplayed())
			{
				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.SubmitButtonSingle());
				CommonUtility.ClickOn(driver,obj_EsupportMPSPage.SubmitButtonSingle());
			}


			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportMPSPage.VerifyingProductcustomerList()));
			CommonUtility.highlightElement(driver,obj_EsupportMPSPage.VerifyingProductcustomerList());

			String VerifyingProductcustomerList=CommonUtility.highlightElement(driver,obj_EsupportMPSPage.VerifyingProductcustomerList()).getText();

			Report.put("Navigate to Find & Add Products tab and Select customer number",
					"User should be able to see the product. as"+Report.color(VerifyingProductcustomerList),
					"Successfully User should be able to see the product", "PASS");
		}

		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on Find & Add Products",
					"Application should display Find & Add products page",
					"Failed to display Find & Add products page", "FAIL");
			Assert.fail();
		}
	}
	public void  selectOrderNumber(WebDriver driver)
	{
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 120);
		String custNumber = TestNGCreator.TestData.get(Esupport.CustomerNumber.ordinal()); 

		Log.info("Entering selectCustomerNumber");        

		try{
			if(CommonUtility.highlightElement(driver,obj_EsupportMPSPage.FindProdDropdown()).isDisplayed()) 
			{
				//CommonUtility.highlightElement(driver,obj_EsupportMPSPage.FindProdDropdown()).click(); 
				Select selProdBy = new  Select(driver.findElement(obj_EsupportMPSPage.FindProdDropdown()));


				selProdBy.selectByVisibleText("Order Number"); 
				String selectedopt = selProdBy.getFirstSelectedOption().getText();
				System.out.println("Selected option is "+selectedopt);
				Thread.sleep(10000);
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on Find & Add Products",
					"Application should display Find & Add products page",
					"Failed to display Find & Add products page", "FAIL");
			Assert.fail();
		}
	}

	public void  TOselect_OrderNumber(WebDriver driver)
	{
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 120);
		String orderNumber = TestNGCreator.TestData.get(Esupport.OrderNumber.ordinal()); 

		Log.info("Entering in Function TOselect_CustomerNumber");        

		try{
			if(CommonUtility.highlightElement(driver,obj_EsupportMPSPage.orderNumberTextbox()).isDisplayed())
			{
				CommonUtility.highlightElement(driver,obj_EsupportMPSPage.orderNumberTextbox()).sendKeys(orderNumber);

			}
			Thread.sleep(5000);

			if(CommonUtility.highlightElement(driver,obj_EsupportMPSPage.submitOrdernumberButton()).isDisplayed())
			{
				//CommonUtility.highlightElement(driver,obj_EsupportMPSPage.submitOrdernumberButton()).click();
				CommonUtility.ToClickByUsingJavaScript_PassingByLoc(driver, obj_EsupportMPSPage.submitOrdernumberButton());
			}
			Thread.sleep(10000);

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportMPSPage.VerifyingProductcustomerList()));
			CommonUtility.highlightElement(driver,obj_EsupportMPSPage.VerifyingProductcustomerList());

			String VerifyingProductcustomerList=CommonUtility.highlightElement(driver,obj_EsupportMPSPage.VerifyingProductcustomerList()).getText();

			Report.put("Navigate to Find & Add Products tab and Select Order number",
					"User should be able to see the product. as"+Report.color(VerifyingProductcustomerList),
					"Successfully User should be able to see the product", "PASS");
		}

		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Navigate to Find & Add Products tab and Select Order number",
					"User should be not able to see the product. as",
					"User should not be able to see the product", "FAIL");
			Assert.fail();
		}
	}

	public void  TOVerify_ChooseFile(WebDriver driver)
	{
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 120);



		Log.info("Entering TOVerify_ChooseFile");        

		try{

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportMPSPage.chooseFileButton()));
			CommonUtility.highlightElement(driver,obj_EsupportMPSPage.chooseFileButton());

			if(CommonUtility.highlightElement(driver,obj_EsupportMPSPage.chooseFileButton()).isDisplayed())
			{
				Report.put("Navigate to Find & Add Products tab and Verify 'Choose file' button. ",
						"User is able to see a 'Choose file' button",
						"Successfully User is able to see a 'Choose file' button", "PASS");

			}




		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Navigate to Find & Add Products tab and Verify 'Choose file' button. ",
					"User is not able to see a 'Choose file' button",
					"User is not able to see a 'Choose file' button", "FAIL");
			Assert.fail();
		}
	}


	//Lavanya, MPS PCF Jan 15th
	public void VerifyPageNumbersDisplayingUnderPaginationSection(WebDriver driver)
	{

		Log.info("VerifyPageNumbersDisplayingUnderPaginationSection");	
		WebDriverWait wait = new WebDriverWait(driver, 120);
		String text="";
		String testcase=TestNGCreator.TestData.get(Esupport.TestCaseID.ordinal());

		try
		{
			if(CommonUtility.CheckpresenceofElementLocated(driver, 15, obj_EsupportMPSPage.PageinPaginationInMyProductsPage()))
			{

				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.PageinPaginationInMyProductsPage());
				String pagesdisplayed=CommonUtility.highlightElement(driver,obj_EsupportMPSPage.PageinPaginationInMyProductsPage()).getText();
				System.out.println(pagesdisplayed);

				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.PageNoTextPaginationInMyProductsPage());
				text=CommonUtility.highlightElement(driver,obj_EsupportMPSPage.PageNoTextPaginationInMyProductsPage()).getText(); 
				System.out.println(text);

				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.NumberOfPagesInMyProductsPage());
				String noofpages=CommonUtility.highlightElement(driver,obj_EsupportMPSPage.NumberOfPagesInMyProductsPage()).getText(); 
				System.out.println(noofpages);

				Report.put("Verify page numbers are displayed in the pagination section", 
						"Page numbers are displayed 1st page display and followed by total number of pages present" ,
						"User able to see "+Report.color(pagesdisplayed)+" section and display "+Report.color(text)+" page by default with number of pages as "+Report.color(noofpages), "PASS");

			}
			else
			{
				System.out.println("pages displayed pagination section not displayed");
				Report.put("Verify page numbers are displayed in the pagination section", 
						"Page numbers are displayed 1st page display and followed by total number of pages present" ,
						"failed to display pages displayed pagination section", "FAIL");
				Assert.fail();
			}

		}
		catch(Exception e)
		{
			Log.info(e);
			Report.put("Verify page numbers are displayed in the pagination section", 
					"Page numbers are displayed 1st page display and followed by total number of pages present" ,
					"failed to display pages displayed pagination section", "FAIL");
			e.printStackTrace();
			Assert.fail();
		}

	} 


	public void ValidatePreviousWillBeGreyedOutWhenUserIsOn1stPageIfMoreThanOnePagePresent(WebDriver driver)
	{

		Log.info("Entering ValidatePreviousWillBeGreyedOutWhenUserIsOn1stPageIfMoreThanOnePagePresent method");	
		WebDriverWait wait = new WebDriverWait(driver, 120);
		String text="";
		String testcase=TestNGCreator.TestData.get(Esupport.TestCaseID.ordinal());
		try
		{
			if(CommonUtility.CheckpresenceofElementLocated(driver, 15, obj_EsupportMPSPage.PageNoTextPaginationInMyProductsPage()))
			{

				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.PageNoTextPaginationInMyProductsPage());
				String pagesdisplayed=CommonUtility.highlightElement(driver,obj_EsupportMPSPage.PageNoTextPaginationInMyProductsPage()).getText();
				System.out.println(pagesdisplayed);

				if(pagesdisplayed.equals("1"))
				{

					CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.FirstPageArrowMarkInMyProductsPage());
					CommonUtility.highlightElement(driver,obj_EsupportMPSPage.FirstPageArrowMarkInMyProductsPage());

					CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.PreviousPageArrowMarkInMyProductsPage());
					CommonUtility.highlightElement(driver,obj_EsupportMPSPage.PreviousPageArrowMarkInMyProductsPage());

				}


				Report.put("When user is on 1st page then 'Previous' text will be greyed out indicating it is disabled.", 
						"The 'previous'  option on the first page is greyed out indicating its disabled " ,
						"When User is on "+Report.color(pagesdisplayed)+" page, Previous arrow mark is greyed out and disabled for user", "PASS");

			}
			else
			{
				System.out.println("pages displayed pagination section not displayed");
				Report.put("When user is on 1st page then 'Previous' text will be greyed out indicating it is disabled.", 
						"The 'previous'  option on the first page is greyed out indicating its disabled " ,
						"failed to display pages displayed pagination section", "FAIL");
				Assert.fail();
			}

		}
		catch(Exception e)
		{
			Log.info(e);
			Report.put("When user is on 1st page then 'Previous' text will be greyed out indicating it is disabled.", 
					"The 'previous'  option on the first page is greyed out indicating its disabled " ,
					"failed to display pages displayed pagination section", "FAIL");
			e.printStackTrace();
			Assert.fail();
		}

	} 


	public void ValidateNextWillBeGreyedOutWhenUserIsOnLastPageIfMoreThanOnePagePresent(WebDriver driver)
	{

		Log.info("Entering ValidateNextWillBeGreyedOutWhenUserIsOnLastPageIfMoreThanOnePagePresent method");	
		WebDriverWait wait = new WebDriverWait(driver, 120);
		String text="";
		String testcase=TestNGCreator.TestData.get(Esupport.TestCaseID.ordinal());
		try
		{
			if(CommonUtility.CheckpresenceofElementLocated(driver, 15, obj_EsupportMPSPage.LastPageArrowMarkInMyProductsPage()))
			{

				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.LastPageArrowMarkInMyProductsPage());
				CommonUtility.ClickOn(driver,obj_EsupportMPSPage.LastPageArrowMarkInMyProductsPage());

				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportMPSPage.PageNoTextPaginationInMyProductsPage()));
				String pagesdisplayed=CommonUtility.highlightElement(driver,obj_EsupportMPSPage.PageNoTextPaginationInMyProductsPage()).getText();
				System.out.println(pagesdisplayed);

				if(!(pagesdisplayed.equals("1")))
				{

					CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.NextPageArrowMarkInMyProductsPage());
					CommonUtility.highlightElement(driver,obj_EsupportMPSPage.NextPageArrowMarkInMyProductsPage());

					CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.LastPageArrowMarkInMyProductsPage());
					CommonUtility.highlightElement(driver,obj_EsupportMPSPage.LastPageArrowMarkInMyProductsPage());

				}


				Report.put("When user is on last page then 'Next' text  will be greyed out indicating it is disabled.", 
						"The 'next' option on the last page is greyed out indicating its disabled" ,
						"When User is on "+Report.color(pagesdisplayed)+" page, Next arrow mark is greyed out and disabled for user", "PASS");

			}
			else
			{
				System.out.println("last page arrow mark not dispayed");
				Report.put("When user is on last page then 'Next' text  will be greyed out indicating it is disabled.", 
						"The 'next' option on the last page is greyed out indicating its disabled" ,
						"last page arrow mark disabled", "FAIL");
				Assert.fail();
			}

		}
		catch(Exception e)
		{
			Log.info(e);
			Report.put("When user is on last page then 'Next' text  will be greyed out indicating it is disabled.", 
					"The 'next' option on the last page is greyed out indicating its disabled" ,
					"last page arrow mark disabled", "FAIL");
			e.printStackTrace();
			Assert.fail();
		}

	} 

	public void  clickSignIn(WebDriver driver, String Username,String Password) 
	{
		System.out.println("Inside clickSignIn");
		WebDriverWait  wait = new WebDriverWait(driver, 120);
		Actions act=new Actions(driver);

		String header="";
		String faqList="";

		try
		{
			driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);


			if(CommonUtility.CheckpresenceofElementLocated(driver,10, obj_EsupportMPSPage.MPSPageHeading()))
			{
				handleCookies(driver);
				CommonUtility.ScrollTo(driver, obj_EsupportMPSPage.MPSPageHeading());
				header=CommonUtility.highlightElement(driver, obj_EsupportMPSPage.MPSPageHeading()).getText();
				System.out.println(header);

				Report.put("Launch the url https://www.dell.com/support/mps/en-us/myproducts", 
						"User should land in the My products and services login page", 
						"User able to launch url successfully and laded on "+Report.color(header)+" page", "PASS");

			}
			else
			{
				System.out.println("failed to land in MPS page");
				Report.put("Launch the url https://www.dell.com/support/mps/en-us/myproducts", 
						"User should land in the My products and services login page", 
						"Failed to land on MPS page", "FAIL");
			}
			if(CommonUtility.CheckpresenceofElementLocated(driver,10, obj_EsupportMPSPage.SignInButtonOnMPSPage()))
			{
				CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.CountrySelector());
				CommonUtility.ScrollTo(driver, obj_EsupportMPSPage.SignInButtonOnMPSPage());
				CommonUtility.ClickOn(driver, obj_EsupportMPSPage.SignInButtonOnMPSPage());
			
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.Email()));

				handleCookies(driver);
				CommonUtility.ScrollTo(driver, obj_EsupportDDLHomePage.Email());
				CommonUtility.highlightElement(driver, obj_EsupportDDLHomePage.Email()).clear();
				CommonUtility.highlightElement(driver, obj_EsupportDDLHomePage.Email()).click();
				CommonUtility.highlightElement(driver, obj_EsupportDDLHomePage.Email()).sendKeys(Username);

				System.out.println("Entered Email(Username) as "+Username);

				CommonUtility.ScrollTo(driver, obj_EsupportDDLHomePage.Password());
				CommonUtility.highlightElement(driver, obj_EsupportDDLHomePage.Password()).clear();
				CommonUtility.highlightElement(driver, obj_EsupportDDLHomePage.Password()).click();
				CommonUtility.highlightElement(driver, obj_EsupportDDLHomePage.Password()).sendKeys(Password);

				System.out.println("Entered Password as "+Password);
				CommonUtility.ScrollTo(driver, obj_EsupportDDLHomePage.SignIn());
				CommonUtility.ClickOn(driver, obj_EsupportDDLHomePage.SignIn());
				System.out.println("Clicked on SignIn Button ");

//				CommonUtility.ScrollTo(driver, obj_EsupportMPSPage.MPSLandingPageAfterSignIn());
//				String wel=CommonUtility.highlightElement(driver, obj_EsupportMPSPage.MPSLandingPageAfterSignIn()).getText();
//				System.out.println(wel);

				CommonUtility.ScrollTo(driver, obj_EsupportMPSPage.MPSPageHeading());
				String MPS=CommonUtility.highlightElement(driver, obj_EsupportMPSPage.MPSPageHeading()).getText();
				System.out.println(MPS);

				List<WebElement> list=driver.findElements(obj_EsupportMPSPage.TwoTabsInLandingPage());

				for(WebElement lt:list)
				{
					CommonUtility.highlightElement(driver, lt);    
					String tabName=lt.getText();
					System.out.println("tab is: " +tabName);
					faqList+=" <br> " + tabName;
				}

				System.out.println("tabs are:"+faqList);

				CommonUtility.ScrollTo(driver, obj_EsupportMPSPage.MyProductsTabActive());
				String myproduct=CommonUtility.highlightElement(driver, obj_EsupportMPSPage.MyProductsTabActive()).getText();
				System.out.println(myproduct);

				Report.put("Click on sign in and enter valid credentials and click on sign in ", 
						"User should logged in successfully and should load the two tabs -My Products and Service Requests they should be able to see a list of their products (Shipping date <7 years )  By Default My products tab should be selected ", 
						"User successfulyy logged in and able to see "+Report.color("")+" with heading "+Report.color(MPS)+" and able to see tabs "+Report.color(faqList)+" and laded on "+Report.color(myproduct)+" tab by default", "PASS");
			}


			else
			{
				System.out.println("sign in button not displayed");
				Report.put("Click on sign in and enter valid credentials and click on sign in ", 
						"User should logged in successfully and should load the two tabs -My Products and Service Requests they should be able to see a list of their products (Shipping date <7 years )  By Default My products tab should be selected ", 
						"failed to see sign in button", "FAIL");
				Assert.fail();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on sign in and enter valid credentials and click on sign in ", 
					"User should logged in successfully and should load the two tabs -My Products and Service Requests they should be able to see a list of their products (Shipping date <7 years )  By Default My products tab should be selected ", 
					"failed to see sign in button", "FAIL");
			Assert.fail();
		}
	}

	public void  validateOptionsAboveGridInMyProductsTab(WebDriver driver) 
	{
		System.out.println("Inside validateOptionsAboveGridInMyProductsTab");
		WebDriverWait  wait = new WebDriverWait(driver, 120);
		Actions act=new Actions(driver);

		String header="";
		String faqList="";

		try
		{
			if(CommonUtility.CheckpresenceofElementLocated(driver,10, obj_EsupportMPSPage.SelectGroupText()))
			{

				CommonUtility.ScrollTo(driver, obj_EsupportMPSPage.SelectGroupText());
				String selgrp=CommonUtility.highlightElement(driver, obj_EsupportMPSPage.SelectGroupText()).getText();
				System.out.println(selgrp);

				CommonUtility.ScrollTo(driver, obj_EsupportMPSPage.AllProductsDropDownValue());
				String drpdown=CommonUtility.highlightElement(driver, obj_EsupportMPSPage.AllProductsDropDownValue()).getText();
				System.out.println(drpdown);

				CommonUtility.ScrollTo(driver, obj_EsupportMPSPage.AddProductsTab());
				String addProtab=CommonUtility.highlightElement(driver, obj_EsupportMPSPage.AddProductsTab()).getText();
				System.out.println(addProtab);

				CommonUtility.ScrollTo(driver, obj_EsupportMPSPage.CreateOrEditGroupTab());
				String creatEdittab=CommonUtility.highlightElement(driver, obj_EsupportMPSPage.CreateOrEditGroupTab()).getText();
				System.out.println(creatEdittab);

				CommonUtility.ScrollTo(driver, obj_EsupportMPSPage.DownloadButtonInMyProductsTab());
				String download=CommonUtility.highlightElement(driver, obj_EsupportMPSPage.DownloadButtonInMyProductsTab()).getText();
				System.out.println(download);

				CommonUtility.ScrollTo(driver, obj_EsupportMPSPage.FilterButton());
				String filter=CommonUtility.highlightElement(driver, obj_EsupportMPSPage.FilterButton()).getText();
				System.out.println(filter);

				CommonUtility.ScrollTo(driver, obj_EsupportMPSPage.SearchTextBoxInMyProductsPage());
				String searchwatermark=CommonUtility.highlightElement(driver, obj_EsupportMPSPage.SearchTextBoxInMyProductsPage()).getAttribute("placeholder");
				System.out.println(searchwatermark);

				Report.put("Verify the options on above the grid ", 
						"User should display Select group : all products , Add products button , create / Edit groups button on left side and  to the right Filter option , Download option and search box with search (minimum 3 Chars) water mark ", 
						"User able to see "+Report.color(selgrp+" with deafault selected value "+drpdown)+" and "+Report.color(addProtab)+" and "+Report.color(creatEdittab)+" also with "+Report.color(download+" and "+filter)+" and search tesxt box along with "+Report.color(searchwatermark)+" water mark", "PASS");

			}
			else
			{
				System.out.println("Failed to see expected fields above grid");
				Report.put("Verify the options on above the grid ", 
						"User should display Select group : all products , Add products button , create / Edit groups button on left side and  to the right Filter option , Download option and search box with search (minimum 3 Chars) water mark ", 
						"Failed to see expected fields above grid", "FAIL");
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify the options on above the grid ", 
					"User should display Select group : all products , Add products button , create / Edit groups button on left side and  to the right Filter option , Download option and search box with search (minimum 3 Chars) water mark ", 
					"Failed to see expected fields above grid", "FAIL");
			Assert.fail();
		}
	}

	public void verifyColumnNamesInGrid(WebDriver driver)
	{

		Log.info("Inside verifyColumnNamesInGrid method");

		String button = "";
		String header = "";
		String hide="";
		String labelList="";
		WebDriverWait wait = new WebDriverWait(driver, 240);
		try
		{

			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_EsupportMPSPage.ColumnNamesInMyProductsGrid()))
			{

				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.ColumnNamesInMyProductsGrid());	
				List<WebElement> list=driver.findElements(obj_EsupportMPSPage.ColumnNamesInMyProductsGrid());

				for(WebElement lt:list)
				{
					CommonUtility.highlightElement(driver, lt);
					String label=lt.getText();

					System.out.println("column name is : " +label);
					labelList+=" <br> " + label;
				}
				System.out.println("column names are:"+labelList);


				Report.put("Verify the Grid Columns",
						"Grid page should display the columns Product name ( First column)  , nickname , service tag , activity , Warranty type and expiration ",
						"User able to see Grid details with columns "+Report.color(labelList), "PASS");

			}
			else
			{
				System.out.println("not able to see grid details");
				Report.put("Verify the Grid Columns",
						"Grid page should display the columns Product name ( First column)  , nickname , service tag , activity , Warranty type and expiration ",
						"Failed to see Grid details", "Fail");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify the Grid Columns",
					"Grid page should display the columns Product name ( First column)  , nickname , service tag , activity , Warranty type and expiration ",
					"Failed to see Grid details", "Fail");
			Assert.fail();
		}
	}

	public void vlidateSortingColumns(WebDriver driver)
	{

		Log.info("Inside vlidateSortingColumns method");

		String assertid = ""; String assertclass="";
		String Prodname=""; String prodclass="";
		String nickname="";String nickclass="";
		String siteid="";String siteidclass="";
		String sitedetils=""; String sitedetclass="";

		WebDriverWait wait = new WebDriverWait(driver, 600);
		try
		{

			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_EsupportMPSPage.ProductNameSorting()))
			{	
				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.ProductNameSorting());
				assertid=CommonUtility.highlightElement(driver,obj_EsupportMPSPage.ProductNameSorting()).getText();
				System.out.println("column name is "+assertid);
				CommonUtility.ClickOn(driver,obj_EsupportMPSPage.ProductNameSorting());

				Thread.sleep(6000);
				assertclass=CommonUtility.highlightElement(driver,obj_EsupportMPSPage.ProductNameAfterSort()).getAttribute("class");
				System.out.println("class is "+assertclass);

				if(!(assertclass.contains("sorting_desc")|| assertclass.contains("sorting_asc")))
				{
					System.out.println("failed to sort product name");
					Report.put("Verify the sorting option for the columns",
							"Should be able to sort  (ascending ,descending) for the following columns Product Name Nickname, Service Tag, Warranty Type, Expiration, ascending sort or the descending sort should be indicated at each of the columns",
							"failed to sort product name", "Fail");
					Assert.fail();
				}

				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.NicknameSorting());
				Prodname=CommonUtility.highlightElement(driver,obj_EsupportMPSPage.NicknameSorting()).getText();
				System.out.println("column name is "+Prodname);
				CommonUtility.ClickOn(driver,obj_EsupportMPSPage.NicknameSorting());

				Thread.sleep(6000);
				prodclass=CommonUtility.highlightElement(driver,obj_EsupportMPSPage.NickNameAfterSort()).getAttribute("class");
				System.out.println("class is "+prodclass);

				if(!(prodclass.contains("sorting_desc")|| prodclass.contains("sorting_asc")))
				{
					System.out.println("failed to sort nick name");
					Report.put("Verify the sorting option for the columns",
							"Should be able to sort  (ascending ,descending) for the following columns Product Name Nickname, Service Tag, Warranty Type, Expiration, ascending sort or the descending sort should be indicated at each of the columns",
							"failed to sort nick name", "Fail");
					Assert.fail();
				}

				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.ServiceTagSorting());
				nickname=CommonUtility.highlightElement(driver,obj_EsupportMPSPage.ServiceTagSorting()).getText();
				System.out.println("column name is "+nickname);
				CommonUtility.ClickOn(driver,obj_EsupportMPSPage.ServiceTagSorting());

				Thread.sleep(6000);
				nickclass=CommonUtility.highlightElement(driver,obj_EsupportMPSPage.ServiceTagAfterSort()).getAttribute("class");
				System.out.println("class is "+nickclass);

				if(!(nickclass.contains("sorting_desc")|| nickclass.contains("sorting_asc")))
				{
					System.out.println("failed to sort service tag");
					Report.put("Verify the sorting option for the columns",
							"Should be able to sort  (ascending ,descending) for the following columns Product Name Nickname, Service Tag, Warranty Type, Expiration, ascending sort or the descending sort should be indicated at each of the columns",
							"failed to sort service tag", "Fail");
					Assert.fail();
				}

				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.WarrantyTypeSorting());
				siteid=CommonUtility.highlightElement(driver,obj_EsupportMPSPage.WarrantyTypeSorting()).getText();
				System.out.println("column name is "+siteid);
				CommonUtility.ClickOn(driver,obj_EsupportMPSPage.WarrantyTypeSorting());

				Thread.sleep(6000);
				siteidclass=CommonUtility.highlightElement(driver,obj_EsupportMPSPage.WarrantyTypeAfterSort()).getAttribute("class");
				System.out.println("class is "+siteidclass);

				if(!(siteidclass.contains("sorting_desc")|| siteidclass.contains("sorting_asc")))
				{
					System.out.println("failed to sort warranty type");
					Report.put("Verify the sorting option for the columns",
							"Should be able to sort  (ascending ,descending) for the following columns Product Name Nickname, Service Tag, Warranty Type, Expiration, ascending sort or the descending sort should be indicated at each of the columns",
							"failed to sort warranty type", "Fail");
					Assert.fail();
				}


				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.ExpirationSorting());
				sitedetils=CommonUtility.highlightElement(driver,obj_EsupportMPSPage.ExpirationSorting()).getText();
				System.out.println("column name is "+sitedetils);
				CommonUtility.ClickOn(driver,obj_EsupportMPSPage.ExpirationSorting());

				Thread.sleep(6000);
				sitedetclass=CommonUtility.highlightElement(driver,obj_EsupportMPSPage.ExpirationAfterSort()).getAttribute("class");
				System.out.println("class is "+sitedetclass);

				if(!(sitedetclass.contains("sorting_desc")|| sitedetclass.contains("sorting_asc")))
				{
					System.out.println("failed to sort expiration");
					Report.put("Verify the sorting option for the columns",
							"Should be able to sort  (ascending ,descending) for the following columns Product Name Nickname, Service Tag, Warranty Type, Expiration, ascending sort or the descending sort should be indicated at each of the columns",
							"failed to sort expiration", "Fail");
					Assert.fail();
				}


				Report.put("Verify the sorting option for the columns",
						"Should be able to sort  (ascending ,descending) for the following columns Product Name Nickname, Service Tag, Warranty Type, Expiration, ascending sort or the descending sort should be indicated at each of the columns",
						"User able to sort all columns in ascending and descending", "PASS");

			}
			else
			{
				System.out.println("failed to sort column names");
				Report.put("Verify the sorting option for the columns",
						"Should be able to sort  (ascending ,descending) for the following columns Product Name Nickname, Service Tag, Warranty Type, Expiration, ascending sort or the descending sort should be indicated at each of the columns",
						"failed to sort column names", "Fail");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify the sorting option for the columns",
					"Should be able to sort  (ascending ,descending) for the following columns Product Name Nickname, Service Tag, Warranty Type, Expiration, ascending sort or the descending sort should be indicated at each of the columns",
					"failed to sort column names", "Fail");
			Assert.fail();
		}
	}

	public void verifyCreateOrEditGroupsLink(WebDriver driver)
	{

		Log.info("Inside verifyCreateOrEditGroupsLink method");

		String button = "";
		String header = "";
		String hide="";
		String labelList="";
		WebDriverWait wait = new WebDriverWait(driver, 240);
		try
		{

			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_EsupportMPSPage.CreateOrEditGroupTab()))
			{

				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.CreateOrEditGroupTab());	
				String createedittab=CommonUtility.highlightElement(driver,obj_EsupportMPSPage.CreateOrEditGroupTab()).getText();
				System.out.println(createedittab);

				Report.put("Verify the Create / Edit Groups link ",
						"User should be able to see 'Create/Edit Groups' as a link in the HUD",
						"User able to see "+Report.color(createedittab)+" link", "PASS");

			}
			else
			{
				System.out.println("failed to see create or edit link");
				Report.put("Verify the Create / Edit Groups link ",
						"User should be able to see 'Create/Edit Groups' as a link in the HUD",
						"Failed to see create or edit link", "Fail");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify the Create / Edit Groups link ",
					"User should be able to see 'Create/Edit Groups' as a link in the HUD",
					"Failed to see create or edit link", "Fail");
			Assert.fail();
		}
	}

	public void clickOnCreateOrEditGroupsLink(WebDriver driver, String groupName)
	{

		Log.info("Inside clickOnCreateOrEditGroupsLink method");

		WebDriverWait wait = new WebDriverWait(driver, 240);
		try
		{

			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_EsupportMPSPage.CreateOrEditGroupTab()))
			{

				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.CreateOrEditGroupTab());	
				String createedittab=CommonUtility.highlightElement(driver,obj_EsupportMPSPage.CreateOrEditGroupTab()).getText();
				System.out.println(createedittab);
				CommonUtility.ClickOn(driver,obj_EsupportMPSPage.CreateOrEditGroupTab());

				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportMPSPage.CreateOrEditGroupHeader()));
				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.CreateOrEditGroupHeader());	
				String header=CommonUtility.highlightElement(driver,obj_EsupportMPSPage.CreateOrEditGroupHeader()).getText();
				System.out.println(header);

				Report.put("Click on the Create / Edit Groups link",
						"Create/Edit groups modal should open       Modal title - Create / Edit Groups",
						"CLicking on "+Report.color(createedittab)+" link, user able to see "+Report.color(header)+" header of pop up", "PASS");

				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.GroupNameHeading());
				String popuptitle=CommonUtility.highlightElement(driver,obj_EsupportMPSPage.GroupNameHeading()).getText();
				System.out.println("pop up header "+popuptitle);

				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.GroupNameTextBox());	
				String legnth=CommonUtility.highlightElement(driver,obj_EsupportMPSPage.GroupNameTextBox()).getAttribute("maxlength");
				System.out.println("max length is "+legnth);

				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.SaveGroupButton());	
				String dis=CommonUtility.highlightElement(driver,obj_EsupportMPSPage.SaveGroupButton()).getAttribute("disabled");
				System.out.println("button is "+dis);

				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.SaveAndAddProductsButton());	
				String disabled=CommonUtility.highlightElement(driver,obj_EsupportMPSPage.SaveAndAddProductsButton()).getAttribute("disabled");
				System.out.println("button is "+disabled);

				Report.put("Verify the group name box",
						"Text box  with title (Group Name) :Ability to enter special characters and multi-language support.Max Character limit -100",
						"User able to see "+Report.color(popuptitle)+" with text box of maximum length it allows "+Report.color(legnth), "PASS");

				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.GroupNameTextBox());	
				CommonUtility.highlightElement(driver,obj_EsupportMPSPage.GroupNameTextBox()).clear();
				CommonUtility.highlightElement(driver,obj_EsupportMPSPage.GroupNameTextBox()).sendKeys(groupName);

				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.SaveGroupButton());	
				String savebutton=CommonUtility.highlightElement(driver,obj_EsupportMPSPage.SaveGroupButton()).getText();
				System.out.println("button is "+savebutton);

				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.SaveAndAddProductsButton());	
				String saveaddprodbutton=CommonUtility.highlightElement(driver,obj_EsupportMPSPage.SaveAndAddProductsButton()).getText();
				System.out.println("button is "+saveaddprodbutton);

				Report.put("Enter the group name",
						"Save Group name button and save and add products should be enabled",
						"User enters group name "+Report.color(groupName)+" and sees "+Report.color(savebutton+" and "+saveaddprodbutton)+" are enabled", "PASS");


			}
			else
			{
				System.out.println("failed to see create or edit link");
				Report.put("Verify the Create / Edit Groups link ",
						"User should be able to see 'Create/Edit Groups' as a link in the HUD",
						"Failed to see create or edit link", "Fail");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify the Create / Edit Groups link ",
					"User should be able to see 'Create/Edit Groups' as a link in the HUD",
					"Failed to see create or edit link", "Fail");
			Assert.fail();
		}
	}

	public void clickOnSaveAndAddProductButton(WebDriver driver)
	{

		Log.info("Inside clickOnSaveAndAddProductButton method");

		String button = "";
		String header = "";
		String hide="";
		String labelList="";
		WebDriverWait wait = new WebDriverWait(driver, 240);
		try
		{

			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_EsupportMPSPage.SaveAndAddProductsButton()))
			{

				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.SaveAndAddProductsButton());	
				String saveadd=CommonUtility.highlightElement(driver,obj_EsupportMPSPage.SaveAndAddProductsButton()).getText();
				System.out.println(saveadd);
				CommonUtility.ClickOn(driver,obj_EsupportMPSPage.SaveAndAddProductsButton());	
				Thread.sleep(6000);
				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.AddItemHeading());	
				String additem=CommonUtility.highlightElement(driver,obj_EsupportMPSPage.AddItemHeading()).getText();
				System.out.println(additem);

				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.NewGroupNameHeading());	
				String Groupname=CommonUtility.highlightElement(driver,obj_EsupportMPSPage.NewGroupNameHeading()).getText();
				System.out.println(Groupname);

				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.ProductListBeforeSelectingAnyProducts());	
				String prodlist=CommonUtility.highlightElement(driver,obj_EsupportMPSPage.ProductListBeforeSelectingAnyProducts()).getText();
				System.out.println(prodlist);

				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.InstructionToSelectTheProducts());	
				String instruction=CommonUtility.highlightElement(driver,obj_EsupportMPSPage.InstructionToSelectTheProducts()).getText();
				System.out.println(instruction);

				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.SaveGroupButtonInAddItemPage());	
				String disabled=CommonUtility.highlightElement(driver,obj_EsupportMPSPage.SaveGroupButtonInAddItemPage()).getAttribute("disabled");
				System.out.println("save button is "+disabled);

				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.FilterButtonInAddItemPage());	

				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.FilterSearchTextBoxInAddItemPage());	

				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.ColumnNamesOfGridInAddItemPAge());	
				List<WebElement> list=driver.findElements(obj_EsupportMPSPage.ColumnNamesOfGridInAddItemPAge());
				List<WebElement> list1=driver.findElements(obj_EsupportMPSPage.NumberOfRowsOdProductsDisplayed());

				int count=list1.size();
				System.out.println("total number of products displayed in a page are "+count);
				for(WebElement lt:list)
				{
					CommonUtility.highlightElement(driver, lt);
					String label=lt.getText();

					System.out.println("column name is : " +label);
					labelList+=" <br> " + label;
				}
				System.out.println("column names are:"+labelList);

				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.SelectAllCheckBox());	

				Report.put("Click on Save and add products",
						"User should open the grid with list 1. Add Items : [Group name ] as the title of the page <br>2. Product List : [n] Results ;this grid lists down all the assets in the user's list (Validated and invalidated included) <br>3.Select the products you want to add to \" [Group name] \".<br>4.Save Group button in disabled state until at least one product is selected to be added to the group. <br>5. Select All button The following columns with data values should be displayed in the grid  for the user's product list :",
						"User clicks on "+Report.color(saveadd)+" button and "+Report.color(additem)+" page pop up opens with group name "+Report.color(Groupname)
						+" details "+Report.color(prodlist+" along with instructions "+instruction)+" and Save button is "+Report.color(disabled)
						+" with filter link and filter search box with select all check box with  rows of products displayed by default is "+count, "PASS");

			}
			else
			{
				System.out.println("failed to see save and add product button");
				Report.put("Click on Save and add products",
						"User should open the grid with list 1. Add Items : [Group name ] as the title of the page <br>2. Product List : [n] Results ;this grid lists down all the assets in the user's list (Validated and invalidated included) <br>3.Select the products you want to add to \" [Group name] \".<br>4.Save Group button in disabled state until at least one product is selected to be added to the group. <br>5. Select All button The following columns with data values should be displayed in the grid  for the user's product list :",
						"Failed to see save and add product button", "Fail");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on Save and add products",
					"User should open the grid with list 1. Add Items : [Group name ] as the title of the page <br>2. Product List : [n] Results ;this grid lists down all the assets in the user's list (Validated and invalidated included) <br>3.Select the products you want to add to \" [Group name] \".<br>4.Save Group button in disabled state until at least one product is selected to be added to the group. <br>5. Select All button The following columns with data values should be displayed in the grid  for the user's product list :",
					"Failed to see save and add product button", "Fail");
			Assert.fail();
		}
	}

	public void selectProductsFromGrid(WebDriver driver)
	{

		Log.info("Inside selectProductsFromGrid method");

		String button = "";
		String header = "";
		String hide="";
		String labelList="";
		WebDriverWait wait = new WebDriverWait(driver, 240);
		try
		{

			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_EsupportMPSPage.SelectAllCheckBox()))
			{

				if(CommonUtility.CheckpresenceofElementLocated(driver,05,obj_EsupportMPSPage.SelectAllCheckBox()))
				{
					CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.SelectAllCheckBox());	
					//CommonUtility.ClickOn(driver,obj_EsupportMPSPage.SelectAllCheckBox());
					CommonUtility.ToClickByUsingJavaScript_PassingByLoc(driver,obj_EsupportMPSPage.SelectAllCheckBox());
					Thread.sleep(3000);
				}

				//				if(CommonUtility.CheckpresenceofElementLocated(driver,05,obj_EsupportMPSPage.FirstCheckBoxOfProduct()))
				//				{
				//				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.FirstCheckBoxOfProduct());	
				//				CommonUtility.ClickOn(driver,obj_EsupportMPSPage.FirstCheckBoxOfProduct());
				//				Thread.sleep(3000);
				//				}
				//				
				//				if(CommonUtility.CheckpresenceofElementLocated(driver,05,obj_EsupportMPSPage.SecondCheckBoxOfProduct()))
				//				{
				//				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.SecondCheckBoxOfProduct());	
				//				CommonUtility.ClickOn(driver,obj_EsupportMPSPage.SecondCheckBoxOfProduct());
				//				Thread.sleep(3000);
				//				}
				//				
				//				if(CommonUtility.CheckpresenceofElementLocated(driver,05,obj_EsupportMPSPage.ThirdCheckBoxOfProduct()))
				//				{
				//				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.ThirdCheckBoxOfProduct());	
				//				CommonUtility.ClickOn(driver,obj_EsupportMPSPage.ThirdCheckBoxOfProduct());
				//				Thread.sleep(3000);
				//				}
				//				
				//				if(CommonUtility.CheckpresenceofElementLocated(driver,05,obj_EsupportMPSPage.ForthCheckBoxOfProduct()))
				//				{
				//				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.ForthCheckBoxOfProduct());	
				//				CommonUtility.ClickOn(driver,obj_EsupportMPSPage.ForthCheckBoxOfProduct());
				//				Thread.sleep(3000);
				//				}
				//				
				//				if(CommonUtility.CheckpresenceofElementLocated(driver,05,obj_EsupportMPSPage.FifthCheckBoxOfProduct()))
				//				{
				//				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.FifthCheckBoxOfProduct());	
				//				CommonUtility.ClickOn(driver,obj_EsupportMPSPage.FifthCheckBoxOfProduct());
				//				Thread.sleep(3000);
				//				}
				//				
				//				if(CommonUtility.CheckpresenceofElementLocated(driver,05,obj_EsupportMPSPage.SixthCheckBoxOfProduct()))
				//				{
				//				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.SixthCheckBoxOfProduct());	
				//				CommonUtility.ClickOn(driver,obj_EsupportMPSPage.SixthCheckBoxOfProduct());
				//				Thread.sleep(3000);
				//				}

				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.ProductListBeforeSelectingAnyProducts());	
				String prodlist=CommonUtility.highlightElement(driver,obj_EsupportMPSPage.ProductListBeforeSelectingAnyProducts()).getText();
				System.out.println(prodlist);

				if(prodlist.contains("0"))
				{
					System.out.println("failed to see added products count");
					Report.put("Select the products",
							"1. Product List : [n ] results ;shows the total count of the items selected to be added to this group 2. Select the products you want to add to \" [Group name] \".3. Save Group button enabled.",
							"Failed to see added products count", "Fail");
					//Assert.fail();
				}
				else
				{
					System.out.println("able to see added count");	
				}
				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.SaveGroupButtonInAddItemPage());	
				String savegroup=CommonUtility.highlightElement(driver,obj_EsupportMPSPage.SaveGroupButtonInAddItemPage()).getText();
				System.out.println("button is "+savegroup);

				Report.put("Select the products",
						"1. Product List : [n ] results ;shows the total count of the items selected to be added to this group 2. Select the products you want to add to \" [Group name] \".3. Save Group button enabled.",
						"User selectes product and able to see "+Report.color(prodlist)+" added with selected count with "+Report.color(savegroup)+" button enabled", "PASS");

			}
			else
			{
				System.out.println("failed to see check box");
				Report.put("Select the products",
						"1. Product List : [n ] results ;shows the total count of the items selected to be added to this group 2. Select the products you want to add to \" [Group name] \".3. Save Group button enabled.",
						"Failed to see check box", "Fail");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Select the products",
					"1. Product List : [n ] results ;shows the total count of the items selected to be added to this group 2. Select the products you want to add to \" [Group name] \".3. Save Group button enabled.", 
					"Failed to see check box", "Fail");
			Assert.fail();
		}
	}

	public void clickOnSaveGroup(WebDriver driver)
	{

		Log.info("Inside clickOnSaveGroup method");

		String button = "";
		String header = "";
		String hide="";
		String labelList="";
		WebDriverWait wait = new WebDriverWait(driver, 240);
		try
		{

			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_EsupportMPSPage.SaveGroupButtonInAddItemPage()))
			{

				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.SaveGroupButtonInAddItemPage());	
				String savetab=CommonUtility.highlightElement(driver,obj_EsupportMPSPage.SaveGroupButtonInAddItemPage()).getText();
				System.out.println(savetab);
				CommonUtility.ClickOn(driver,obj_EsupportMPSPage.SaveGroupButtonInAddItemPage());

				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportMPSPage.AlertMessage()));


				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.AlertMessage());	
				String message=CommonUtility.highlightElement(driver,obj_EsupportMPSPage.AlertMessage()).getText();
				System.out.println(message);


				Report.put("click on save group",
						"User is taken back to the 'Create /Edit Group' modal with a success message displayed in green color bar :New Group Created. [Group Name] [n ] items .",
						"User able to click on "+Report.color(savetab)+" button and able to see successful message "+Report.color(message), "PASS");

			}
			else
			{
				System.out.println("failed to see save group button");
				Report.put("click on save group",
						"User is taken back to the 'Create /Edit Group' modal with a success message displayed in green color bar :New Group Created. [Group Name] [n ] items .",
						"Failed to see save group button", "Fail");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("click on save group",
					"User is taken back to the 'Create /Edit Group' modal with a success message displayed in green color bar :New Group Created. [Group Name] [n ] items .",
					"Failed to see save group button", "Fail");
			Assert.fail();
		}
	}

	public void clickOn3DotsOfFirstDisplayedRow(WebDriver driver)
	{

		Log.info("Inside clickOn3DotsOfFirstDisplayedRow method");

		String button = "";
		String header = "";
		String hide="";
		String labelList="";
		WebDriverWait wait = new WebDriverWait(driver, 240);
		try
		{

			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_EsupportMPSPage.ThreeDotsIcon()))
			{

				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.ThreeDotsIcon());	
				CommonUtility.ClickOn(driver, obj_EsupportMPSPage.ThreeDotsIcon());
//				CommonUtility.ToClickByUsingJavaScript_PassingByLoc(driver, obj_EsupportMPSPage.ThreeDotsIcon());	

				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportMPSPage.AddToGroupOption()));
				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.AddToGroupOption());	
				String addToGroup=CommonUtility.highlightElement(driver,obj_EsupportMPSPage.AddToGroupOption()).getText();	
				System.out.println(addToGroup);

				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.AddOrEditNicknameOption());	
				String addOrEdit=CommonUtility.highlightElement(driver,obj_EsupportMPSPage.AddOrEditNicknameOption()).getText();	
				System.out.println(addOrEdit);

				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.RemoveProductOption());	
				String removeProduct=CommonUtility.highlightElement(driver,obj_EsupportMPSPage.RemoveProductOption()).getText();	
				System.out.println(removeProduct);

				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.ContactSupportOption());	
				String contactSupport=CommonUtility.highlightElement(driver,obj_EsupportMPSPage.ContactSupportOption()).getText();	
				System.out.println(contactSupport);


				Report.put("Go to any row and click on the 3 dots (...)",
						"User should expand the list with add to group , add / edit nickname , remove product and contact support ",
						"User clicks on 3 dots ... "+Report.color(addToGroup+" <br> "+addOrEdit+" <br> "+removeProduct+" <br> "+contactSupport), "PASS");

			}
			else
			{
				System.out.println("failed to see 3 dots ...");
				Report.put("Go to any row and click on the 3 dots (...)",
						"User should expand the list with add to group , add / edit nickname , remove product and contact support ",
						"failed to see 3 dots ...", "Fail");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Go to any row and click on the 3 dots (...)",
					"User should expand the list with add to group , add / edit nickname , remove product and contact support ",
					"failed to see 3 dots ...", "Fail");
			Assert.fail();
		}
	}

	public void selectRemoveGroup(WebDriver driver)
	{

		Log.info("Inside selectRemoveGroup method");

		String button = "";
		String header = "";
		String hide="";
		String labelList="";
		WebDriverWait wait = new WebDriverWait(driver, 240);
		try
		{

			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_EsupportMPSPage.RemoveProductOption()))
			{

				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.RemoveProductOption());	
				String removeProduct=CommonUtility.highlightElement(driver,obj_EsupportMPSPage.RemoveProductOption()).getText();	
				System.out.println(removeProduct);
				CommonUtility.ClickOn(driver,obj_EsupportMPSPage.RemoveProductOption());	

				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportMPSPage.RemoveProductPopUpHeader()));
				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.RemoveProductPopUpHeader());	
				String popuphead=CommonUtility.highlightElement(driver,obj_EsupportMPSPage.RemoveProductPopUpHeader()).getText();	
				System.out.println(popuphead);

				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.XMarkPopUp());

				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.PopUpBody());	
				String popupbody=CommonUtility.highlightElement(driver,obj_EsupportMPSPage.PopUpBody()).getText();	
				System.out.println(popupbody);

				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.CancelButtonInPopUp());	
				String cancel=CommonUtility.highlightElement(driver,obj_EsupportMPSPage.CancelButtonInPopUp()).getText();	
				System.out.println(cancel);

				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.RemoveButtonInPopUp());	
				String remove=CommonUtility.highlightElement(driver,obj_EsupportMPSPage.RemoveButtonInPopUp()).getText();	
				System.out.println(remove);

				Report.put("Click on remove product ",
						"User should get the Remove product pop up Product name will be removed from your My Products list and all groups.This Action cannot be undone. Are you sure you want to remove this product? with cancel and remove button enabled ",
						"User clicks on "+Report.color(removeProduct)+" and able to see pop up with "+Report.color(popuphead)+" header with "+Report.color(popupbody)+" with "+Report.color(cancel)+" and "+Report.color(remove)+" buttons", "PASS");

			}
			else
			{
				System.out.println("failed to see remove button ...");
				Report.put("Click on remove product ",
						"User should get the Remove product pop up Product name will be removed from your My Products list and all groups.This Action cannot be undone. Are you sure you want to remove this product? with cancel and remove button enabled ",
						"failed to see remove button", "Fail");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on remove product ",
					"User should get the Remove product pop up Product name will be removed from your My Products list and all groups.This Action cannot be undone. Are you sure you want to remove this product? with cancel and remove button enabled ",
					"failed to see remove button", "Fail");
			Assert.fail();
		}
	}

	public void clickOnRemoveButton(WebDriver driver)
	{

		Log.info("Inside clickOnRemoveButton method");

		String button = "";
		String header = "";
		String hide="";
		String labelList="";
		WebDriverWait wait = new WebDriverWait(driver, 240);
		try
		{

			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_EsupportMPSPage.RemoveButtonInPopUp()))
			{
				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.RemoveButtonInPopUp());	
				String remove=CommonUtility.highlightElement(driver,obj_EsupportMPSPage.RemoveButtonInPopUp()).getText();	
				System.out.println(remove);
				CommonUtility.ClickOn(driver,obj_EsupportMPSPage.RemoveButtonInPopUp());

				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.RemovalSuccessMessage());	
				String message=CommonUtility.highlightElement(driver,obj_EsupportMPSPage.RemovalSuccessMessage()).getText();	
				System.out.println(message);

				Report.put("Click on remove button ",
						"User should get the success toast message product name has been remove successfully from the product list and product should get removed",
						"User clicks on "+Report.color(remove)+" button and able to see "+Report.color(message)+" message", "PASS");

			}
			else
			{
				System.out.println("failed to click on remove button ...");
				Report.put("Click on remove button ",
						"User should get the success toast message product name has been remove successfully from the product list and product should get removed",
						"failed to see remove button", "Fail");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on remove button ",
					"User should get the success toast message product name has been remove successfully from the product list and product should get removed",
					"failed to see remove button", "Fail");
			Assert.fail();
		}
	}

	public void selectContactTechnicalSupport(WebDriver driver)
	{

		Log.info("Inside selectContactTechnicalSupport method");

		String cts = "";
		String product = "";
		String hide="";
		String labelList="";
		WebDriverWait wait = new WebDriverWait(driver, 240);
		try
		{

			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_EsupportMPSPage.ContactSupportOption()))
			{
				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.ContactSupportOption());	
				String contactSupport=CommonUtility.highlightElement(driver,obj_EsupportMPSPage.ContactSupportOption()).getText();	
				System.out.println(contactSupport);
				CommonUtility.ClickOn(driver,obj_EsupportMPSPage.ContactSupportOption());

				Thread.sleep(10000);
				String mainwindow=driver.getWindowHandle();
				Set<String> set=driver.getWindowHandles();
				int count=set.size();
				System.out.println("window count is "+count);

				Iterator<String> itr=set.iterator();
				while(itr.hasNext())
				{
					String childWindow=itr.next();
					if(!mainwindow.equals(childWindow))
					{
						driver.switchTo().window(childWindow);
						
						if(CommonUtility.CheckpresenceofElementLocated(driver,30,obj_EsupportIncidentsPage.HeaderOfNewPopUpInContactUS()))
						{

							CommonUtility.ScrollTo(driver,obj_EsupportIncidentsPage.NoButtonOfPopup());
							System.out.println("scrolled to option");
							Thread.sleep(5000);
							CommonUtility.ClickOn(driver,obj_EsupportIncidentsPage.NoButtonOfPopup());

						}
						
						CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.CTSHomePage());	
//						cts=CommonUtility.highlightElement(driver,obj_EsupportMPSPage.CTSHomePage()).getText();	
//						System.out.println(cts);
//
//						CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.ProductName());	
//						product=CommonUtility.highlightElement(driver,obj_EsupportMPSPage.ProductName()).getText();	
//						System.out.println(product);
						driver.close();
					}


				}
				driver.switchTo().window(mainwindow);




				Report.put("Click on Contact support",
						"User should direct to the contact support page with product information in new tab ",
						"User clicks on "+Report.color(contactSupport)+" option and landed on "+Report.color(cts)+" with product name "+Report.color(product), "PASS");

			}
			else
			{
				System.out.println("failed to see contact technical support");
				Report.put("Click on Contact support",
						"User should direct to the contact support page with product information in new tab ",
						"failed to see contact technical support", "Fail");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on Contact support",
					"User should direct to the contact support page with product information in new tab ",
					"failed to see contact technical support", "Fail");
			Assert.fail();
		}
	}

	public void selectAddToGroup(WebDriver driver)
	{

		Log.info("Inside selectAddToGroup method");

		String faqList = "";
		String header = "";
		String values="";
		String labelList="";
		WebDriverWait wait = new WebDriverWait(driver, 240);
		try
		{

			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_EsupportMPSPage.AddToGroupOption()))
			{
				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.AddToGroupOption());	
				String addToGroup=CommonUtility.highlightElement(driver,obj_EsupportMPSPage.AddToGroupOption()).getText();	
				System.out.println(addToGroup);
				CommonUtility.ClickOn(driver,obj_EsupportMPSPage.AddToGroupOption());

				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportMPSPage.AddToGroupHeader()));
				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.AddToGroupHeader());	
				String  popupheader=CommonUtility.highlightElement(driver,obj_EsupportMPSPage.AddToGroupHeader()).getText();	
				System.out.println(popupheader);

				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.XMarkOfAddToGroup());	

				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.AddToGroupInstructionLine1());
				String  instruc1=CommonUtility.highlightElement(driver,obj_EsupportMPSPage.AddToGroupInstructionLine1()).getText();	
				System.out.println(instruc1);

				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.AddToGroupInstructionLine2());
				String  instruc2=CommonUtility.highlightElement(driver,obj_EsupportMPSPage.AddToGroupInstructionLine2()).getText();	
				System.out.println(instruc2);

				List<WebElement> list=driver.findElements(obj_EsupportMPSPage.ColumnNamesOfAddToGroup());

				for(WebElement lt:list)
				{
					CommonUtility.highlightElement(driver, lt);    
					String tabName=lt.getText();
					System.out.println("column is: " +tabName);
					faqList+=" <br> " + tabName;
				}

				System.out.println("columns are:"+faqList);

				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.ProductRowValue());
				String  product=CommonUtility.highlightElement(driver,obj_EsupportMPSPage.ProductRowValue()).getText();	
				System.out.println(product);

				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.ServiceTagDisplayedInTable());
				String  sertag=CommonUtility.highlightElement(driver,obj_EsupportMPSPage.ServiceTagDisplayedInTable()).getText();	
				System.out.println(sertag);

				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.SelectGroupDropDown());

				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.CancelButtonInAddToProduct());
				String  cancel=CommonUtility.highlightElement(driver,obj_EsupportMPSPage.CancelButtonInAddToProduct()).getText();	
				System.out.println(cancel);

				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.AddProductButton());
				String  addprod=CommonUtility.highlightElement(driver,obj_EsupportMPSPage.AddProductButton()).getAttribute("disabled");	
				System.out.println(addprod);

				Report.put("Click on add to group ",
						"User should load the Add to group Modal pop up with product with image , service tag and group as dropdown",
						"User clicks on"+Report.color(addToGroup)+" able to see "+Report.color(popupheader)+" header, with instructions "+Report.color(instruc1+" and "+instruc2)+" grid with column names "+Report.color(faqList)+" along with values "+Report.color(product+" <br> "+sertag+" along with select group dorpdown values and with "+Report.color(cancel)+" and add product button in disabled state"), "PASS");

				CommonUtility.ClickOn(driver,obj_EsupportMPSPage.SelectGroupDropDown());

				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.ColumnNamesOfAddToGroup());
				List<WebElement> list1=driver.findElements(obj_EsupportMPSPage.ColumnNamesOfAddToGroup());

				for(WebElement lt:list1)
				{
					CommonUtility.highlightElement(driver, lt);    
					String tabName=lt.getText();
					System.out.println("value is: " +tabName);
					values+=" <br> " + tabName;
				}

				System.out.println("values are:"+values);


				Report.put("Click on select group ",
						"user should display with all the groups associated with that account",
						"user clicks on select group and able to see groups "+Report.color(values), "PASS");

				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.FiestDropDownValuesOfGroups());
				CommonUtility.ClickOn(driver,obj_EsupportMPSPage.FiestDropDownValuesOfGroups());

				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.AddProductButton());
				String  addprod1=CommonUtility.highlightElement(driver,obj_EsupportMPSPage.AddProductButton()).getText();	
				System.out.println(addprod1);

				Report.put("Select any group",
						"Add Product button should be enabled",
						"User selects first displayed value from dropdown and able to see "+Report.color(addprod1)+" button enabled", "PASS");

				CommonUtility.ClickOn(driver,obj_EsupportMPSPage.AddProductButton());

				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.SuccessMessageAfterAddingAddToProduct());
				String  message=CommonUtility.highlightElement(driver,obj_EsupportMPSPage.SuccessMessageAfterAddingAddToProduct()).getText();	
				System.out.println(message);

				Report.put("click on add product button",
						"Product name should get added to the group with toast message for few seconds ",
						"User clicks on "+Report.color(addprod1)+" button and should see success message as "+Report.color(message), "PASS");


			}
			else
			{
				System.out.println("failed to see add to group button");
				Report.put("Click on add to group ",
						"User should load the Add to group Modal pop up with product with image , service tag and group as dropdown",
						"failed to see add to group button", "Fail");

				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on add to group ",
					"User should load the Add to group Modal pop up with product with image , service tag and group as dropdown",
					"failed to see add to group button", "Fail");
			Assert.fail();
		}
	}

	public void clickOnExpandButtonOfFirstDisplayedRow(WebDriver driver)
	{

		Log.info("Inside clickOnExpandButtonOfFirstDisplayedRow method");

		String button = "";
		String header = "";
		String labelList1="";
		String labelList="";
		WebDriverWait wait = new WebDriverWait(driver, 240);
		try
		{

			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_EsupportMPSPage.FirstDisplayedExpandButtonInMyProducts()))
			{

				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.FirstDisplayedExpandButtonInMyProducts());	
				CommonUtility.ClickOn(driver,obj_EsupportMPSPage.FirstDisplayedExpandButtonInMyProducts());	

				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportMPSPage.ExpandButtonInMyProducts()));

				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.ImageInExpandedView());	

				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.HeadingsOfDisplayedFields());	
				List<WebElement> list=driver.findElements(obj_EsupportMPSPage.HeadingsOfDisplayedFields());

				for(WebElement lt:list)
				{
					CommonUtility.highlightElement(driver, lt);    
					String tabName=lt.getText();
					System.out.println("heading is: " +tabName);
					labelList+=" <br> " + tabName;
				}

				System.out.println("headings are:"+labelList);


				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.DetailsDisplayedUnderHeading());	
				List<WebElement> list1=driver.findElements(obj_EsupportMPSPage.DetailsDisplayedUnderHeading());

				for(WebElement lt:list1)
				{
					CommonUtility.highlightElement(driver, lt);    
					String tabName=lt.getText();
					System.out.println("details is: " +tabName);
					labelList1+=" <br> " + tabName;
				}

				System.out.println("details are:"+labelList1);


				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.ContractStatusDetails());
				String  contractdetail=CommonUtility.highlightElement(driver,obj_EsupportMPSPage.ContractStatusDetails()).getText();	
				System.out.println(contractdetail);
				
				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.ExtendOrUpgradeOrRenewLink());
				String  extend=CommonUtility.highlightElement(driver,obj_EsupportMPSPage.ExtendOrUpgradeOrRenewLink()).getText();	
				System.out.println(extend);

				String parts="";
				if(CommonUtility.highlightElement(driver,obj_EsupportMPSPage.PartsAndAccessoriesLinkInMyProducts()).isDisplayed())
				{
					CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.PartsAndAccessoriesLinkInMyProducts());	
					parts=CommonUtility.highlightElement(driver,obj_EsupportMPSPage.PartsAndAccessoriesLinkInMyProducts()).getText();
					System.out.println(parts);
					Thread.sleep(3000);
				}
				else
				{
					System.out.println("parts and accessaries link not displayed");
				}
				String doc="";
				if(CommonUtility.highlightElement(driver,obj_EsupportMPSPage.DocumentationInMyProducts()).isDisplayed())
				{
					CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.DocumentationInMyProducts());	
					doc=CommonUtility.highlightElement(driver,obj_EsupportMPSPage.DocumentationInMyProducts()).getText();
					System.out.println(doc);
					Thread.sleep(3000);
				}
				else
				{
					System.out.println("documentation link not displayed");
				}

				String diag="";
				if(CommonUtility.highlightElement(driver,obj_EsupportMPSPage.DiagnosticsInMyProducts()).isDisplayed())
				{
					CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.DiagnosticsInMyProducts());	
					diag=CommonUtility.highlightElement(driver,obj_EsupportMPSPage.DiagnosticsInMyProducts()).getText();
					System.out.println(diag);
					Thread.sleep(3000);
				}
				else
				{
					System.out.println("diagnistics link not displayed");
				}

				String driv="";
				if(CommonUtility.highlightElement(driver,obj_EsupportMPSPage.DriversAndDownloadsInMyProducts()).isDisplayed())
				{
					CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.DriversAndDownloadsInMyProducts());	
					driv=CommonUtility.highlightElement(driver,obj_EsupportMPSPage.DriversAndDownloadsInMyProducts()).getText();
					System.out.println(driv);
					Thread.sleep(3000);
				}
				else
				{
					System.out.println("drivers and downloads link not displayed");
				}

				Report.put("Go to any row and click on expand ( click on down arrow button)",
						"User should expand details  , and show the product image ,Product Type ,Shipped Date, Contract Status and links Part & accessories , documentation and diagnostics ",
						"User able to click on expand button and sees collapse button along with other details "+Report.color(labelList+" along with "+labelList1+" "+contractdetail)+" along with other links "+Report.color(parts+" , "+doc+" , "+diag+" , "+driv)+" links along with "+Report.color(extend)+" link", "PASS");

			}
			else
			{
				System.out.println("failed to see expand button");
				Report.put("Go to any row and click on expand ( click on down arrow button)",
						"User should expand details  , and show the product image ,Product Type ,Shipped Date, Contract Status and links Part & accessories , documentation and diagnostics ",
						"failed to see expand button", "Fail");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Go to any row and click on expand ( click on down arrow button)",
					"User should expand details  , and show the product image ,Product Type ,Shipped Date, Contract Status and links Part & accessories , documentation and diagnostics ",
					"failed to see expand button", "Fail");
			Assert.fail();
		}
	}

	public void clickOnPartsAndAccessoriesLink(WebDriver driver)
	{

		Log.info("Inside clickOnPartsAndAccessoriesLink method");

		String cts = "";
		String product = "";
		String hide="";
		String labelList="";
		WebDriverWait wait = new WebDriverWait(driver, 240);
		try
		{

			if(CommonUtility.highlightElement(driver,obj_EsupportMPSPage.PartsAndAccessoriesLinkInMyProducts()).isDisplayed())
			{

				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.PartsAndAccessoriesLinkInMyProducts());	
				String removeProduct=CommonUtility.highlightElement(driver,obj_EsupportMPSPage.PartsAndAccessoriesLinkInMyProducts()).getText();	
				System.out.println(removeProduct);
				CommonUtility.ClickOn(driver,obj_EsupportMPSPage.PartsAndAccessoriesLinkInMyProducts());	

				Thread.sleep(6000);
				String mainwindow=driver.getWindowHandle();
				Set<String> set=driver.getWindowHandles();
				int count=set.size();
				System.out.println("window count is "+count);

				Iterator<String> itr=set.iterator();
				while(itr.hasNext())
				{
					String childWindow=itr.next();
					if(!mainwindow.equals(childWindow))
					{
						driver.switchTo().window(childWindow);

						CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.MPSPageHeading());	
						cts=CommonUtility.highlightElement(driver,obj_EsupportMPSPage.MPSPageHeading()).getText();	
						System.out.println(cts);

						CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.PartsAndAccessoriesTab());	
						product=CommonUtility.highlightElement(driver,obj_EsupportMPSPage.PartsAndAccessoriesTab()).getText();	
						System.out.println(product);

						if(product.contains("Parts"))
						{
							System.out.println("test case pass");
						}
						else
						{
							System.out.println("failed to land on part & accessories tab as default tab");
							Report.put("Click on the part & accessories link",
									"User should open product support page in new tab with Part & Accessories tab selected",
									"failed to land on part & accessories tab", "Fail");
							Assert.fail();
						}
						driver.close();
					}


				}
				driver.switchTo().window(mainwindow);

				Report.put("Click on the part & accessories link",
						"User should open product support page in new tab with Part & Accessories tab selected",
						"User able to click on "+Report.color(removeProduct)+" link and landed on prodduct page with heading "+Report.color(cts)+" and default landed tab is "+Report.color(product), "PASS");

			}
			else
			{
				System.out.println("failed to see part & accessories link");
				Report.put("Click on the part & accessories link",
						"User should open product support page in new tab with Part & Accessories tab selected",
						"failed to see part & accessories link for selected enxpand button product", "Pass");

			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on the part & accessories link",
					"User should open product support page in new tab with Part & Accessories tab selected",
					"failed to see part & accessories link", "Fail");
			Assert.fail();
		}
	}

	public void clickOnDocumentationLink(WebDriver driver)
	{

		Log.info("Inside clickOnDocumentationLink method");

		String cts = "";
		String product = "";
		String hide="";
		String labelList="";
		WebDriverWait wait = new WebDriverWait(driver, 240);
		try
		{

			if(CommonUtility.highlightElement(driver,obj_EsupportMPSPage.DocumentationInMyProducts()).isDisplayed())
			{

				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.DocumentationInMyProducts());	
				String removeProduct=CommonUtility.highlightElement(driver,obj_EsupportMPSPage.DocumentationInMyProducts()).getText();	
				System.out.println(removeProduct);
				CommonUtility.ClickOn(driver,obj_EsupportMPSPage.DocumentationInMyProducts());	

				Thread.sleep(6000);
				String mainwindow=driver.getWindowHandle();
				Set<String> set=driver.getWindowHandles();
				int count=set.size();
				System.out.println("window count is "+count);

				Iterator<String> itr=set.iterator();
				while(itr.hasNext())
				{
					String childWindow=itr.next();
					if(!mainwindow.equals(childWindow))
					{
						driver.switchTo().window(childWindow);

						CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.MPSPageHeading());	
						cts=CommonUtility.highlightElement(driver,obj_EsupportMPSPage.MPSPageHeading()).getText();	
						System.out.println(cts);

						CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.DocumentationTab());	
						product=CommonUtility.highlightElement(driver,obj_EsupportMPSPage.DocumentationTab()).getText();	
						System.out.println(product);

						if(product.contains("Documentation"))
						{
							System.out.println("test case pass");
						}
						else
						{
							System.out.println("failed to land on documentation tab");
							Report.put("Comeback to the expanded page and click on the Documentation link",
									"User should open product support page in new tab with Documentation tab selected",
									"failed to land on documentation tab", "Fail");
							Assert.fail();
						}
						driver.close();
					}


				}
				driver.switchTo().window(mainwindow);

				Report.put("Comeback to the expanded page and click on the Documentation link",
						"User should open product support page in new tab with Documentation tab selected",
						"User able to click on "+Report.color(removeProduct)+" link and landed on product page with heading "+Report.color(cts)+" and default landed tab is "+Report.color(product), "PASS");

			}
			else
			{
				System.out.println("failed to see Documentation link");
				Report.put("Comeback to the expanded page and click on the Documentation link",
						"User should open product support page in new tab with Documentation tab selected",
						"failed to see Documentation link for selected enxpand button product", "Pass");

			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Comeback to the expanded page and click on the Documentation link",
					"User should open product support page in new tab with Documentation tab selected",
					"failed to see Documentation link", "Fail");
			Assert.fail();
		}
	}

	public void clickOnDiagnosticsLink(WebDriver driver)
	{

		Log.info("Inside clickOnDiagnosticsLink method");

		String cts = "";
		String product = "";
		String hide="";
		String labelList="";
		WebDriverWait wait = new WebDriverWait(driver, 240);
		try
		{

			if(CommonUtility.highlightElement(driver,obj_EsupportMPSPage.DiagnosticsInMyProducts()).isDisplayed())
			{

				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.DiagnosticsInMyProducts());	
				String removeProduct=CommonUtility.highlightElement(driver,obj_EsupportMPSPage.DiagnosticsInMyProducts()).getText();	
				System.out.println(removeProduct);
				CommonUtility.ClickOn(driver,obj_EsupportMPSPage.DiagnosticsInMyProducts());	

				Thread.sleep(6000);
				String mainwindow=driver.getWindowHandle();
				Set<String> set=driver.getWindowHandles();
				int count=set.size();
				System.out.println("window count is "+count);

				Iterator<String> itr=set.iterator();
				while(itr.hasNext())
				{
					String childWindow=itr.next();
					if(!mainwindow.equals(childWindow))
					{
						driver.switchTo().window(childWindow);

						CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.MPSPageHeading());	
						cts=CommonUtility.highlightElement(driver,obj_EsupportMPSPage.MPSPageHeading()).getText();	
						System.out.println(cts);

						CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.DiagnosticsTab());	
						product=CommonUtility.highlightElement(driver,obj_EsupportMPSPage.DiagnosticsTab()).getText();	
						System.out.println(product);

						if(product.contains("Diagnostics"))
						{
							System.out.println("test case pass");
						}
						else
						{
							System.out.println("failed to land on Diagnostics tab");
							Report.put("Comeback to the expanded page and click on the Diagnostics link ",
									"User should open product support page in new tab with Diagnostics tab selected ",
									"failed to land on Diagnostics tab", "Fail");
							Assert.fail();
						}
						driver.close();
					}


				}
				driver.switchTo().window(mainwindow);

				Report.put("Comeback to the expanded page and click on the Diagnostics link ",
						"User should open product support page in new tab with Diagnostics tab selected ",
						"User able to click on "+Report.color(removeProduct)+" link and landed on product page with heading "+Report.color(cts)+" and default landed tab is "+Report.color(product), "PASS");

			}
			else
			{
				System.out.println("failed to see Diagnostics link");
				Report.put("Comeback to the expanded page and click on the Diagnostics link ",
						"User should open product support page in new tab with Diagnostics tab selected ",
						"failed to see Diagnostics link for selected enxpand button product", "Pass");

			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Comeback to the expanded page and click on the Diagnostics link ",
					"User should open product support page in new tab with Diagnostics tab selected ",
					"failed to see Diagnostics link", "Fail");
			Assert.fail();
		}
	}

	public void clickOnDriversAndDownloadsLink(WebDriver driver)
	{

		Log.info("Inside clickOnDriversAndDownloadsLink method");

		String cts = "";
		String product = "";
		String hide="";
		String labelList="";
		WebDriverWait wait = new WebDriverWait(driver, 240);
		try
		{

			if(CommonUtility.highlightElement(driver,obj_EsupportMPSPage.DriversAndDownloadsInMyProducts()).isDisplayed())
			{

				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.DriversAndDownloadsInMyProducts());	
				String removeProduct=CommonUtility.highlightElement(driver,obj_EsupportMPSPage.DriversAndDownloadsInMyProducts()).getText();	
				System.out.println(removeProduct);
				CommonUtility.ClickOn(driver,obj_EsupportMPSPage.DriversAndDownloadsInMyProducts());	

				Thread.sleep(6000);
				String mainwindow=driver.getWindowHandle();
				Set<String> set=driver.getWindowHandles();
				int count=set.size();
				System.out.println("window count is "+count);

				Iterator<String> itr=set.iterator();
				while(itr.hasNext())
				{
					String childWindow=itr.next();
					if(!mainwindow.equals(childWindow))
					{
						driver.switchTo().window(childWindow);

						CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.MPSPageHeading());	
						cts=CommonUtility.highlightElement(driver,obj_EsupportMPSPage.MPSPageHeading()).getText();	
						System.out.println(cts);

						CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.DriversAndDownloadTab());	
						product=CommonUtility.highlightElement(driver,obj_EsupportMPSPage.DriversAndDownloadTab()).getText();	
						System.out.println(product);

						if(product.contains("Drivers"))
						{
							System.out.println("test case pass");
						}
						else
						{
							System.out.println("failed to land on  Drivers and Downloads tab");
							Report.put("Comeback to the expanded page and click on the Drivers and Downloads link ",
									"User should open product support page in new tab with Drivers and Downloads tab selected ",
									"failed to land on Drivers and Downloads tab", "Fail");
							Assert.fail();
						}
						driver.close();
					}


				}
				driver.switchTo().window(mainwindow);

				Report.put("Comeback to the expanded page and click on the Drivers and Downloads link ",
						"User should open product support page in new tab with Drivers and Downloads tab selected ",
						"User able to click on "+Report.color(removeProduct)+" link and landed on product page with heading "+Report.color(cts)+" and default landed tab is "+Report.color(product), "PASS");

			}
			else
			{
				System.out.println("failed to see Drivers and Downloads link");
				Report.put("Comeback to the expanded page and click on the Drivers and Downloads link ",
						"User should open product support page in new tab with Drivers and Downloads tab selected ",
						"failed to see Drivers and Downloads link for selected enxpand button product", "Pass");

			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Comeback to the expanded page and click on the Drivers and Downloads link ",
					"User should open product support page in new tab with Drivers and Downloads tab selected ",
					"failed to see Drivers and Downloads link", "Fail");
			Assert.fail();
		}
	}


	public void clickOnExtendOrUpgradeLink(WebDriver driver)
	{

		Log.info("Inside clickOnExtendOrUpgradeLink method");

		String cts = "";
		String product = "";
		String hide="";
		String labelList="";
		WebDriverWait wait = new WebDriverWait(driver, 240);
		try
		{

			if(CommonUtility.highlightElement(driver,obj_EsupportMPSPage.ExtendOrUpgradeOrRenewLink()).isDisplayed())
			{

				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.ExtendOrUpgradeOrRenewLink());	
				String removeProduct=CommonUtility.highlightElement(driver,obj_EsupportMPSPage.ExtendOrUpgradeOrRenewLink()).getText();	
				System.out.println(removeProduct);
				CommonUtility.ClickOn(driver,obj_EsupportMPSPage.ExtendOrUpgradeOrRenewLink());	

				Thread.sleep(6000);
				String mainwindow=driver.getWindowHandle();
				Set<String> set=driver.getWindowHandles();
				int count=set.size();
				System.out.println("window count is "+count);

				Iterator<String> itr=set.iterator();
				while(itr.hasNext())
				{
					String childWindow=itr.next();
					if(!mainwindow.equals(childWindow))
					{
						driver.switchTo().window(childWindow);

						CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.MPSPageHeading());	
						cts=CommonUtility.highlightElement(driver,obj_EsupportMPSPage.MPSPageHeading()).getText();	
						System.out.println(cts);

						String url=driver.getCurrentUrl();
						System.out.println(url);

						if(cts.contains("Extend"))
						{
							System.out.println("test case pass");
						}
						else
						{
							System.out.println("failed to land on  extend or upgrade your warranty page");
							Report.put("Comeback to the expanded page and click on the extend or upgrade link ( product which has the link )",
									"User should open extend or upgrade your warranty page in new tab  ",
									"failed to land on extend or upgrade your warranty page in new tab", "Fail");
							//Assert.fail();
						}
						driver.close();
					}


				}
				driver.switchTo().window(mainwindow);

				Report.put("Comeback to the expanded page and click on the extend or upgrade link ( product which has the link )",
						"User should open extend or upgrade your warranty page in new tab  ",
						"User able to click on "+Report.color(removeProduct)+" link and landed on product page with heading "+Report.color(cts), "PASS");

			}
			else
			{
				System.out.println("failed to see extend or upgradelink");
				Report.put("Comeback to the expanded page and click on the extend or upgrade link ( product which has the link )",
						"User should open extend or upgrade your warranty page in new tab  ",
						"failed to see extend or upgrade link for selected enxpand button product", "Pass");

			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Comeback to the expanded page and click on the extend or upgrade link ( product which has the link )",
					"User should open extend or upgrade your warranty page in new tab  ",
					"failed to see extend or upgrade link", "Fail");
			Assert.fail();
		}
	}

	public void validateDownloadButtonAboveGrid(WebDriver driver)
	{

		Log.info("Inside validateDownloadButtonAboveGrid method");

		String button = "";
		String header = "";
		String hide="";
		String labelList="";
		WebDriverWait wait = new WebDriverWait(driver, 240);
		try
		{

			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_EsupportMPSPage.DownloadButtonInMyProductsTab()))
			{

				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.DownloadButtonInMyProductsTab());	
				String download=CommonUtility.highlightElement(driver,obj_EsupportMPSPage.DownloadButtonInMyProductsTab()).getText();	
				System.out.println(download);


				Report.put("Above the grid on the right side check for the option download ",
						"user will be able to see a an icon with a label \"Download\"",
						"User able to see "+Report.color(download)+" link", "PASS");

			}
			else
			{
				System.out.println("failed to see download link");
				Report.put("Above the grid on the right side check for the option download ",
						"user will be able to see a an icon with a label \"Download\"",
						"failed to see download link", "Fail");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Above the grid on the right side check for the option download ",
					"user will be able to see a an icon with a label \"Download\"",
					"failed to see download link", "Fail");
			Assert.fail();
		}
	}

	public void ClickDownloadButtonAboveGrid_Chrome(WebDriver driver)
	{

		Log.info("Inside ClickDownloadButtonAboveGrid_Chrome method");

		String button = "";
		String header = "";
		String hide="";
		String labelList="";
		WebDriverWait wait = new WebDriverWait(driver, 240);
		try
		{

			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_EsupportMPSPage.DownloadButtonInMyProductsTab()))
			{

				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.DownloadButtonInMyProductsTab());	
				String download=CommonUtility.highlightElement(driver,obj_EsupportMPSPage.DownloadButtonInMyProductsTab()).getText();	
				System.out.println(download);
				CommonUtility.ClickOn(driver,obj_EsupportMPSPage.DownloadButtonInMyProductsTab());	

				Report.put("Click on the download icon",
						"csv file should get downloaded",
						"User clicks on "+Report.color(download)+" link and successfully downloads csv file", "PASS");

				Thread.sleep(6000);
//				getColumnNamesFromGrid_CompareWithDownloadedExcelColumns_Chrome(driver);
				Thread.sleep(6000);

			}
			else
			{
				System.out.println("failed to see download link");
				Report.put("Click on the download icon",
						"csv file should get downloaded",
						"failed to see download link", "Fail");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on the download icon",
					"csv file should get downloaded",
					"failed to see download link", "Fail");
			Assert.fail();
		}
	}

	
	public void ClickDownloadButtonAboveGrid_Chrome_SRTab(WebDriver driver)
	{

		Log.info("Inside ClickDownloadButtonAboveGrid_Chrome_SRTab method");

		String button = "";
		String header = "";
		String hide="";
		String labelList="";
		WebDriverWait wait = new WebDriverWait(driver, 240);
		try
		{

			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_EsupportMPSPage.DownloadButtonInMyProductsTab()))
			{

				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.DownloadButtonInMyProductsTab());	
				String download=CommonUtility.highlightElement(driver,obj_EsupportMPSPage.DownloadButtonInMyProductsTab()).getText();	
				System.out.println(download);
				CommonUtility.ClickOn(driver,obj_EsupportMPSPage.DownloadButtonInMyProductsTab());	

				Report.put("Click on the download icon",
						"csv file should get downloaded",
						"User clicks on "+Report.color(download)+" link and successfully downloads csv file", "PASS");

				Thread.sleep(6000);
				getColumnNamesFromGrid_CompareWithDownloadedExcelColumns_Chrome_SRTab(driver);
				Thread.sleep(6000);

			}
			else
			{
				System.out.println("failed to see download link");
				Report.put("Click on the download icon",
						"csv file should get downloaded",
						"failed to see download link", "Fail");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on the download icon",
					"csv file should get downloaded",
					"failed to see download link", "Fail");
			Assert.fail();
		}
	}
	public void getColumnNamesFromGrid_CompareWithDownloadedExcelColumns_Chrome(WebDriver driver)
	{

		Log.info("Inside getColumnNamesFromGrid_CompareWithDownloadedExcelColumns_Chrome method");


		String labelList="";
		Properties obj_property = new Properties();
		String path="";
		WebDriverWait wait = new WebDriverWait(driver, 240);

		String ProductName="";String NickName="";String ServiceTag="";String WarrantyType="";
		String Expiration="";String ProductType="";String ShippedDate="";String ContractStatus="";
		
		String[] columns=new String[] {"ProductName"," test", " test1"} ;
		try
		{

			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_EsupportMPSPage.ColumnNamesInMyProductsGrid()))
			{

				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.ColumnNamesInMyProductsGrid());	
				List<WebElement> list=driver.findElements(obj_EsupportMPSPage.ColumnNamesInMyProductsGrid());

				for(WebElement lt:list)
				{
					CommonUtility.highlightElement(driver, lt);
					String label=lt.getText();

					System.out.println("column name is : " +label);
					labelList+=" <br> " + label;
				}
				System.out.println("column names are:"+labelList);

				if (TestNGCreator.TestData.get(Esupport.StartUrl.ordinal()).toUpperCase().contains("MPS"))
				{
					obj_property = CommonUtility.loadPropertyFile();

					obj_property.getProperty("chromeDownloadedFilePath");

					path=obj_property.getProperty("chromeDownloadedFilePath");

					Reader reader = Files.newBufferedReader(Paths.get(path));
		            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withHeaderComments()
		                    .withIgnoreHeaderCase()
		                    .withTrim());
		            
		            for (CSVRecord csvRecord : csvParser) 
		            {
		            	 columns[0] = csvRecord.get(0);
		            	 System.out.println("column 0 "+ProductName);
		            	
		            	 NickName = csvRecord.get(1);
		                 System.out.println("column 1 "+NickName);
		                 
		                 ServiceTag = csvRecord.get(2);
		                 System.out.println("column 2 "+ServiceTag);
		                 
		                 WarrantyType = csvRecord.get(3);
		                 System.out.println("column 3 "+WarrantyType);
		                
		                 Expiration = csvRecord.get(4);
		                 System.out.println("column 4 "+Expiration);
		                
		                 ProductType = csvRecord.get(5);
		                 System.out.println("column 5 "+ProductType);
		                 
		                 ShippedDate = csvRecord.get(6);
		                 System.out.println("column 6 "+ShippedDate);
		                 
		                 ContractStatus = csvRecord.get(7);
		                 System.out.println("column 7 "+ContractStatus);
		        
		                 if(columns[0] .contains("ProductName"))
		                 {
		                	 Report.put("Click on the downloaded file and Verify the download file ",
		     						"exported file should contain the entire My Products data for the following columns :Product Name,Service Tag,Nickname,Warranty Type,Expiration,Assigned To,Product Type,Shipped Date,Contract Status ",
		     						"User able to see column "+Report.color(ProductName), "PASS");

		                	 if(NickName.contains("NickName"))
			                 {
		                		 
			                 }
		                	 else
		                	 {
		                		 
		                	 }
		                	 if(NickName.contains("NickName"))
		                	 {
		                		 
		                	 }
		                 }
		                 else
		                 {
		                	 break;
		                 }
		                
		                 if(NickName.contains("NickName"))
		                 {
		                	 Report.put("Click on the downloaded file and Verify the download file ",
		     						"exported file should contain the entire My Products data for the following columns :Product Name,Service Tag,Nickname,Warranty Type,Expiration,Assigned To,Product Type,Shipped Date,Contract Status ",
		     						"User able to see column "+Report.color(NickName), "PASS");

		                 }
		                 if(ServiceTag.contains("ServiceTag"))
		                 {
		                	 Report.put("Click on the downloaded file and Verify the download file ",
		     						"exported file should contain the entire My Products data for the following columns :Product Name,Service Tag,Nickname,Warranty Type,Expiration,Assigned To,Product Type,Shipped Date,Contract Status ",
		     						"User able to see column "+Report.color(ServiceTag), "PASS");

		                 }
		                 if(WarrantyType.contains("WarrantyType"))
		                 {
		                	 Report.put("Click on the downloaded file and Verify the download file ",
		     						"exported file should contain the entire My Products data for the following columns :Product Name,Service Tag,Nickname,Warranty Type,Expiration,Assigned To,Product Type,Shipped Date,Contract Status ",
		     						"User able to see column "+Report.color(WarrantyType), "PASS");

		                 }
		                 if(Expiration.contains("Expiration"))
		                 {
		                	 Report.put("Click on the downloaded file and Verify the download file ",
		     						"exported file should contain the entire My Products data for the following columns :Product Name,Service Tag,Nickname,Warranty Type,Expiration,Assigned To,Product Type,Shipped Date,Contract Status ",
		     						"User able to see column "+Report.color(Expiration), "PASS");

		                 }
		                 if(ProductType.contains("ProductType"))
		                 {
		                	 Report.put("Click on the downloaded file and Verify the download file ",
		     						"exported file should contain the entire My Products data for the following columns :Product Name,Service Tag,Nickname,Warranty Type,Expiration,Assigned To,Product Type,Shipped Date,Contract Status ",
		     						"User able to see column "+Report.color(ProductType), "PASS");

		                 }
		                 if(ShippedDate.contains("ShippedDate"))
		                 {
		                	 Report.put("Click on the downloaded file and Verify the download file ",
		     						"exported file should contain the entire My Products data for the following columns :Product Name,Service Tag,Nickname,Warranty Type,Expiration,Assigned To,Product Type,Shipped Date,Contract Status ",
		     						"User able to see column "+Report.color(ShippedDate), "PASS");

		                 }
		                 if(ContractStatus.contains("ContractStatus"))
		                 {
		                	 Report.put("Click on the downloaded file and Verify the download file ",
		     						"exported file should contain the entire My Products data for the following columns :Product Name,Service Tag,Nickname,Warranty Type,Expiration,Assigned To,Product Type,Shipped Date,Contract Status ",
		     						"User able to see column "+Report.color(ContractStatus), "PASS");

		                 }
		            }
		            
				}
				
			}
			else
			{
				System.out.println("failed to see download link");
				Report.put("Click on the downloaded file and Verify the download file ",
						"exported file should contain the entire My Products data for the following columns :Product Name,Service Tag,Nickname,Warranty Type,Expiration,Assigned To,Product Type,Shipped Date,Contract Status ",
						"failed to see download link", "Fail");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on the downloaded file and Verify the download file ",
					"exported file should contain the entire My Products data for the following columns :Product Name,Service Tag,Nickname,Warranty Type,Expiration,Assigned To,Product Type,Shipped Date,Contract Status ",
					"failed to see download link", "Fail");
			Assert.fail();
		}
	}

	
	public void getColumnNamesFromGrid_CompareWithDownloadedExcelColumns_Chrome_SRTab(WebDriver driver)
	{

		Log.info("Inside getColumnNamesFromGrid_CompareWithDownloadedExcelColumns_Chrome_SRTab method");


		String labelList="";
		Properties obj_property = new Properties();
		String path="";
		WebDriverWait wait = new WebDriverWait(driver, 240);

		String ProductName="";String NickName="";String ServiceTag="";String WarrantyType="";
		String Expiration="";String ProductType="";String ShippedDate="";String ContractStatus="";
		try
		{

			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_EsupportMPSPage.ColumnNamesInServiceRequestGrid()))
			{

				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.ColumnNamesInServiceRequestGrid());	
				List<WebElement> list=driver.findElements(obj_EsupportMPSPage.ColumnNamesInServiceRequestGrid());

				for(WebElement lt:list)
				{
					CommonUtility.highlightElement(driver, lt);
					String label=lt.getText();

					System.out.println("column name is : " +label);
					labelList+=" <br> " + label;
				}
				System.out.println("column names are:"+labelList);

				if (TestNGCreator.TestData.get(Esupport.StartUrl.ordinal()).toUpperCase().contains("MPS"))
				{
					obj_property = CommonUtility.loadPropertyFile();

					obj_property.getProperty("chromeDownloadedSRPath");

					path=obj_property.getProperty("chromeDownloadedSRPath");

					Reader reader = Files.newBufferedReader(Paths.get(path));
		            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withHeaderComments()
		                    .withIgnoreHeaderCase()
		                    .withTrim());
		            
		            for (CSVRecord csvRecord : csvParser) 
		            {
		            	 ProductName = csvRecord.get(0);
		            	 System.out.println("column 0 "+ProductName);
		            	
		            	 NickName = csvRecord.get(1);
		                 System.out.println("column 1 "+NickName);
		                 
		                 ServiceTag = csvRecord.get(2);
		                 System.out.println("column 2 "+ServiceTag);
		                 
		                 WarrantyType = csvRecord.get(3);
		                 System.out.println("column 3 "+WarrantyType);
		                
		                 Expiration = csvRecord.get(4);
		                 System.out.println("column 4 "+Expiration);
		                
		                 ProductType = csvRecord.get(5);
		                 System.out.println("column 5 "+ProductType);
		                 
		                 if(ProductName.contains("SRNumber")) 
		 	 				{
		                	 Report.put("Click on the downloaded file and Verify the download file ",
		     						"exported file should contain the entire My Products data for the following columns :SRNumber	Status	Severity	PrimaryContact	RequestAge	ServiceTag",
		     						"User able to see column name"+Report.color(ProductName), "PASS");
		 	 					
		 	 				}
		                 if(NickName.contains("Status")) 
		 	 				{
		                	 Report.put("Click on the downloaded file and Verify the download file ",
			     						"exported file should contain the entire My Products data for the following columns :SRNumber	Status	Severity	PrimaryContact	RequestAge	ServiceTag",
		     						"User able to see column name"+Report.color(NickName), "PASS");
		 	 					
		 	 				}
		                 
		                 if(ServiceTag.contains("Severity")) 
		 	 				{
		                	 Report.put("Click on the downloaded file and Verify the download file ",
			     						"exported file should contain the entire My Products data for the following columns :SRNumber	Status	Severity	PrimaryContact	RequestAge	ServiceTag",
		     						"User able to see column name"+Report.color(ServiceTag), "PASS");
		 	 					
		 	 				}
		                 
		                 if(WarrantyType.contains("PrimaryContact")) 
		 	 				{
		                	 Report.put("Click on the downloaded file and Verify the download file ",
			     						"exported file should contain the entire My Products data for the following columns :SRNumber	Status	Severity	PrimaryContact	RequestAge	ServiceTag",
		     						"User able to see column name"+Report.color(WarrantyType), "PASS");
		 	 					
		 	 				}
		                 
		                 if(Expiration.contains("RequestAge")) 
		 	 				{
		                	 Report.put("Click on the downloaded file and Verify the download file ",
			     						"exported file should contain the entire My Products data for the following columns :SRNumber	Status	Severity	PrimaryContact	RequestAge	ServiceTag",
		     						"User able to see column name"+Report.color(Expiration), "PASS");
		 	 					
		 	 				}
		                 if(ProductType.contains("ServiceTag")) 
		 	 				{
		                	 Report.put("Click on the downloaded file and Verify the download file ",
			     						"exported file should contain the entire My Products data for the following columns :SRNumber	Status	Severity	PrimaryContact	RequestAge	ServiceTag",
		     						"User able to see column name"+Report.color(ProductType), "PASS");
		 	 					
		 	 				}
		            }
		            
				}


			}
			else
			{
				System.out.println("failed to see download link");
				 Report.put("Click on the downloaded file and Verify the download file ",
  						"exported file should contain the entire My Products data for the following columns :SRNumber	Status	Severity	PrimaryContact	RequestAge	ServiceTag",
						"failed to see download link", "Fail");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			 Report.put("Click on the downloaded file and Verify the download file ",
						"exported file should contain the entire My Products data for the following columns :SRNumber	Status	Severity	PrimaryContact	RequestAge	ServiceTag",
					"failed to see download link", "Fail");
			Assert.fail();
		}
	}
	public void deleteDownoadedFile(WebDriver driver)
	{

		Log.info("Entering deleteDownoadedFile method");	
		WebDriverWait wait = new WebDriverWait(driver, 120);
		Actions act=new Actions(driver);
		String expand="";
		String header="";
		Properties obj_property = new Properties();
		String path="";
		try
		{
			if (TestNGCreator.TestData.get(Esupport.StartUrl.ordinal()).toUpperCase().contains("MPS"))
			{
				obj_property = CommonUtility.loadPropertyFile();

				obj_property.getProperty("chromeDownloadedFilePath");

				path=obj_property.getProperty("chromeDownloadedFilePath");

				Thread.sleep(6000);
				Path path1 = Paths.get(path); 

				// delete File 
				try { 

					Files.delete(path1); 
					Thread.sleep(6000);
					System.out.println("File deleted successfully"); 
				} 
				catch (IOException e) { 

					System.out.println("Failed to delete the file"); 
					e.printStackTrace(); 
				} 
				
				String url=driver.getCurrentUrl();
				driver.get(url);
			}

		}
		catch(Exception e)
		{
			Log.info(e);

			Assert.fail();
		}

	} 

	public void deleteDownoadedFile_SRTab(WebDriver driver)
	{

		Log.info("Entering deleteDownoadedFile_SRTab method");	
		WebDriverWait wait = new WebDriverWait(driver, 120);
		Actions act=new Actions(driver);
		String expand="";
		String header="";
		Properties obj_property = new Properties();
		String path="";
		try
		{
			if (TestNGCreator.TestData.get(Esupport.StartUrl.ordinal()).toUpperCase().contains("MPS"))
			{
				obj_property = CommonUtility.loadPropertyFile();

				obj_property.getProperty("chromeDownloadedSRPath");

				path=obj_property.getProperty("chromeDownloadedSRPath");

				Thread.sleep(6000);
				Path path1 = Paths.get(path); 

				// delete File 
				try { 

					Files.delete(path1); 
					Thread.sleep(6000);
					System.out.println("File deleted successfully"); 
				} 
				catch (IOException e) { 

					System.out.println("Failed to delete the file"); 
					e.printStackTrace(); 
				} 
				
				String url=driver.getCurrentUrl();
				driver.get(url);
			}

		}
		catch(Exception e)
		{
			Log.info(e);

			Assert.fail();
		}

	} 

	public void validateFilterSection(WebDriver driver, String search)
	{

		Log.info("Inside validateFilterSection method");

		String button = "";

		WebDriverWait wait = new WebDriverWait(driver, 600);
		try
		{

			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_EsupportMPSPage.SearchTextBoxInMyProductsPage()))
			{

				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.SearchTextBoxInMyProductsPage());
				CommonUtility.highlightElement(driver,obj_EsupportMPSPage.SearchTextBoxInMyProductsPage()).clear();
				CommonUtility.highlightElement(driver,obj_EsupportMPSPage.SearchTextBoxInMyProductsPage()).sendKeys(search);

				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.SearchButtonInMyProductsTab());
				CommonUtility.ClickOn(driver,obj_EsupportMPSPage.SearchButtonInMyProductsTab());

				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportMPSPage.FilteredTextInMyProductsPage()));
				List<WebElement> list=driver.findElements(obj_EsupportMPSPage.FilteredTextInMyProductsPage());

				for(int i=0;i<list.size();i++)
				{
					CommonUtility.ScrollToWebElement(driver, list.get(i));
				}

				Report.put("Scenario 2 : If the user has searched for any 'string' on the grid and then clicked on 'Download' -only the result set from the search should be downloaded . Above the grid on right side Enter in any text in search box and click on search",
						"User should display the entered search in the Grid in highlight ",
						"User able to search using filter and able to see searched option highlighted and able to see clear (X) option", "PASS");

			}
			else
			{
				System.out.println("not able to see filter text box");
				Report.put("Scenario 2 : If the user has searched for any 'string' on the grid and then clicked on 'Download' -only the result set from the search should be downloaded . Above the grid on right side Enter in any text in search box and click on search",
						"User should display the entered search in the Grid in highlight ",
						"User not able to see filter text box", "Fail");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Scenario 2 : If the user has searched for any 'string' on the grid and then clicked on 'Download' -only the result set from the search should be downloaded . Above the grid on right side Enter in any text in search box and click on search",
					"User should display the entered search in the Grid in highlight ",
					"User not able to see filter text box", "Fail");
			Assert.fail();
		}
	}

	public void ClickDownloadButtonAboveGrid_AfterFilter(WebDriver driver)
	{

		Log.info("Inside ClickDownloadButtonAboveGrid_AfterFilter method");

		String ProductName = "";
		String header = "";
		String hide="";
		String labelList="";
		Properties obj_property = new Properties();
		String path="";
		WebDriverWait wait = new WebDriverWait(driver, 240);
		try
		{

			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_EsupportMPSPage.DownloadButtonInMyProductsTab()))
			{
				Thread.sleep(6000);
				Thread.sleep(10000);
				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.DownloadButtonInMyProductsTab());	
				String download=CommonUtility.highlightElement(driver,obj_EsupportMPSPage.DownloadButtonInMyProductsTab()).getText();	
				System.out.println(download);
				Thread.sleep(6000);
				CommonUtility.ClickOn(driver,obj_EsupportMPSPage.DownloadButtonInMyProductsTab());	

				Report.put("Click on the download icon",
						"csv file should get downloaded",
						"User clicks on "+Report.color(download)+" link and successfully downloads csv file", "PASS");

			}

		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on the download icon",
					"csv file should get downloaded",
					"failed to see download link", "Fail");
			Assert.fail();
		}
	}
	
	public void clickOnServiceRequestTab(WebDriver driver)
	{

		Log.info("Inside clickOnServiceRequestTab method");

		String button = "";
		String header = "";
		String hide="";
		String labelList="";
		WebDriverWait wait = new WebDriverWait(driver, 240);
		try
		{

			if(CommonUtility.CheckpresenceofElementLocated(driver,20,obj_EsupportMPSPage.ServiceRequestsBeforeClicking()))
			{

				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.ServiceRequestsBeforeClicking());	
				String servicetab=CommonUtility.highlightElement(driver,obj_EsupportMPSPage.ServiceRequestsBeforeClicking()).getText();	
				System.out.println(servicetab);
				CommonUtility.ClickOn(driver,obj_EsupportMPSPage.ServiceRequestsBeforeClicking());

				
//				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportMPSPage.ServiceRequestsAfterClicking()));
				Thread.sleep(15000);
				Report.put("Click on the Service Requests tab",
						"Service requests tab should be selected",
						"User able to click on "+Report.color(servicetab)+" tab successfully", "PASS");

			}
			else
			{
				System.out.println("failed to see service events tab");
				Report.put("Click on the Service Requests tab",
						"Service requests tab should be selected",
						"failed to see service events tab", "Fail");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on the Service Requests tab",
					"Service requests tab should be selected",
					"failed to see service events tab", "Fail");
			Assert.fail();
		}
	}
	
	public void clickOnContactSupportLink_SRTab(WebDriver driver)
	{

		Log.info("Inside clickOnContactSupportLink_SRTab method");

		String cts = "";
		String header = "";
		String hide="";
		String labelList="";
		WebDriverWait wait = new WebDriverWait(driver, 240);
		try
		{

			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_EsupportMPSPage.ContactSupportButtonInSRPage()))
			{

				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.ContactSupportButtonInSRPage());	
				String ctbutton=CommonUtility.highlightElement(driver,obj_EsupportMPSPage.ContactSupportButtonInSRPage()).getText();	
				System.out.println(ctbutton);
				CommonUtility.ClickOn(driver,obj_EsupportMPSPage.ContactSupportButtonInSRPage());

				
				Thread.sleep(6000);
				String mainwindow=driver.getWindowHandle();
				Set<String> set=driver.getWindowHandles();
				int count=set.size();
				System.out.println("window count is "+count);

				Iterator<String> itr=set.iterator();
				while(itr.hasNext())
				{
					String childWindow=itr.next();
					if(!mainwindow.equals(childWindow))
					{
						driver.switchTo().window(childWindow);

						String url=driver.getCurrentUrl();
						System.out.println(url);
						
						CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.MPSPageHeading());	
						cts=CommonUtility.highlightElement(driver,obj_EsupportMPSPage.MPSPageHeading()).getText();	
						System.out.println(cts);

						
						driver.close();
					}


				}
				driver.switchTo().window(mainwindow);
				Report.put("Click on the contact support below the HUD section",
						"User should land in the contact technical support landing page in new tab",
						"User able to click on "+Report.color(ctbutton)+" link successfully and landed on "+Report.color(cts)+" home page", "PASS");

			}
			else
			{
				System.out.println("failed to see contact support link");
				Report.put("Click on the contact support below the HUD section",
						"User should land in the contact technical support landing page in new tab",
						"failed to see contact support link", "Fail");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on the contact support below the HUD section",
					"User should land in the contact technical support landing page in new tab",
					"failed to see contact support link", "Fail");
			Assert.fail();
		}
	}
	
	public void verifyColumnNamesInGrid_SRTab(WebDriver driver)
	{

		Log.info("Inside verifyColumnNamesInGrid_SRTab method");

		String button = "";
		String header = "";
		String hide="";
		String labelList="";
		WebDriverWait wait = new WebDriverWait(driver, 240);
		try
		{

			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_EsupportMPSPage.ColumnNamesInServiceRequestGrid()))
			{

				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.ColumnNamesInServiceRequestGrid());	
				List<WebElement> list=driver.findElements(obj_EsupportMPSPage.ColumnNamesInServiceRequestGrid());

				for(WebElement lt:list)
				{
					CommonUtility.highlightElement(driver, lt);
					String label=lt.getText();

					System.out.println("column name is : " +label);
					labelList+=" <br> " + label;
				}
				System.out.println("column names are:"+labelList);


				Report.put("Verify the Grid Columns",
						"Grid columns should be SR NUMBER	STATUS	SEVERITY	PRIMARY CONTACT	REQUEST AGE	SERVICE TAG",
						"User able to see Grid details with columns "+Report.color(labelList), "PASS");

			}
			else
			{
				System.out.println("not able to see grid details");
				Report.put("Verify the Grid Columns",
						"Grid columns should be SR NUMBER	STATUS	SEVERITY	PRIMARY CONTACT	REQUEST AGE	SERVICE TAG",
						"Failed to see Grid details", "Fail");
				//Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify the Grid Columns",
					"Grid columns should be SR NUMBER	STATUS	SEVERITY	PRIMARY CONTACT	REQUEST AGE	SERVICE TAG",
					"Failed to see Grid details", "Fail");
			Assert.fail();
		}
	}
	
	
	public void clickOnExpandButtonOfFirstDisplayedRow_SRTab(WebDriver driver)
	{

		Log.info("Inside clickOnExpandButtonOfFirstDisplayedRow_SRTab method");

		String button = "";
		String header = "";
		String labelList1="";
		String labelList="";
		WebDriverWait wait = new WebDriverWait(driver, 240);
		try
		{

			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_EsupportMPSPage.FirstDisplayedExpandButton()))
			{

				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.FirstDisplayedExpandButton());	
				CommonUtility.ClickOn(driver,obj_EsupportMPSPage.FirstDisplayedExpandButton());	

//				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportMPSPage.CollapseButton()));

				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.ImageInExpandedView());	

				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.HeadingsOfDisplayedFields());	
				List<WebElement> list=driver.findElements(obj_EsupportMPSPage.HeadingsOfDisplayedFields());

				for(WebElement lt:list)
				{
					CommonUtility.highlightElement(driver, lt);    
					String tabName=lt.getText();
					System.out.println("heading is: " +tabName);
					labelList+=" <br> " + tabName;
				}

				System.out.println("headings are:"+labelList);


				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.DetailsDisplayedUnderHeading());	
				List<WebElement> list1=driver.findElements(obj_EsupportMPSPage.DetailsDisplayedUnderHeading());

				for(WebElement lt:list1)
				{
					CommonUtility.highlightElement(driver, lt);    
					String tabName=lt.getText();
					System.out.println("details is: " +tabName);
					labelList1+=" <br> " + tabName;
				}

				System.out.println("details are:"+labelList1);

				Report.put("Go to any row and click on expand ( click on down arrow button)",
						"User should expand the row and details SR Create Date, Request Type, Warranty Type, Warranty Expiration",
						"User able to click on expand button and clicking on it able to see collapse button along with other detais following "+Report.color(labelList)+" and "+Report.color(labelList1), "PASS");

			}
			else
			{
				System.out.println("failed to see expand button");
				Report.put("Go to any row and click on expand ( click on down arrow button)",
						"User should expand the row and details SR Create Date, Request Type, Warranty Type, Warranty Expiration",
						"failed to see expand button", "Fail");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Go to any row and click on expand ( click on down arrow button)",
					"User should expand the row and details SR Create Date, Request Type, Warranty Type, Warranty Expiration",
					"failed to see expand button", "Fail");
			Assert.fail();
		}
	}
	
	public void validateFilterOptionAboveGrid(WebDriver driver)
	{

		Log.info("Inside validateFilterOptionAboveGrid method");

		String button = "";
		String header = "";
		String hide="";
		String labelList="";
		WebDriverWait wait = new WebDriverWait(driver, 240);
		try
		{

			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_EsupportMPSPage.FilterButton()))
			{

				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.FilterButton());	
				String filter=CommonUtility.highlightElement(driver,obj_EsupportMPSPage.FilterButton()).getText();	
				System.out.println(filter);


				Report.put("Verify the Filter option below the Hud section ",
						"Filter icon should be displayed above the grid with the label \"Filter\"",
						"User able to see "+Report.color(filter)+" link above grid", "PASS");

			}
			else
			{
				System.out.println("failed to see Filter link");
				Report.put("Verify the Filter option below the Hud section ",
						"Filter icon should be displayed above the grid with the label \"Filter\"",
						"failed to see Filter link", "Fail");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify the Filter option below the Hud section ",
					"Filter icon should be displayed above the grid with the label \"Filter\"",
					"failed to see Filter link", "Fail");
			Assert.fail();
		}
	}
	
	public void ClickFilterOptionAboveGridValidateOptionsDisplayed(WebDriver driver)
	{

		Log.info("Inside ClickFilterOptionAboveGridValidateOptionsDisplayed method");

		String button = "";
		String header = "";
		String hide="";
		String labelList="";
		WebDriverWait wait = new WebDriverWait(driver, 240);
		try
		{

			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_EsupportMPSPage.FilterButton()))
			{
				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.FilterButton());	
				String filter=CommonUtility.highlightElement(driver,obj_EsupportMPSPage.FilterButton()).getText();	
				System.out.println(filter);
				CommonUtility.ClickOn(driver,obj_EsupportMPSPage.FilterButton());	
				
				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.FilterByHeader());	
				header=CommonUtility.highlightElement(driver,obj_EsupportMPSPage.FilterByHeader()).getText();	
				System.out.println(header);
				
				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.FilterOptions());	
				List<WebElement> list=driver.findElements(obj_EsupportMPSPage.FilterOptions());

				for(WebElement lt:list)
				{
					CommonUtility.highlightElement(driver, lt);
					String label=lt.getText();

					System.out.println("filters option is : " +label);
					labelList+=" <br> " + label;
				}
				System.out.println("filters options are:"+labelList);
				
				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.ClearAllDisabledState());
				
				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.XMarkInFilterByPopUp());
				
				Report.put("Click on the Filter link ",
						"user is able to open the \"FILTER BY\" window  and following options will be displayed inside the Filter By window Product Name Warranty Type And a button is displayed at the bottom left with the label 'Clear All' and should be disabled",
						"User able to see "+Report.color(filter)+" link above grid sees "+Report.color(header)+" header with filter options "+Report.color(labelList)+" with clear all button in disabled state", "PASS");

			}
			else
			{
				System.out.println("failed to see Filter link");
				Report.put("Click on the Filter link ",
						"user is able to open the \"FILTER BY\" window  and following options will be displayed inside the Filter By window Product Name Warranty Type And a button is displayed at the bottom left with the label 'Clear All' and should be disabled",
						"failed to see Filter link", "Fail");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on the Filter link ",
					"user is able to open the \"FILTER BY\" window  and following options will be displayed inside the Filter By window Product Name Warranty Type And a button is displayed at the bottom left with the label 'Clear All' and should be disabled",
					"failed to see Filter link", "Fail");
			Assert.fail();
		}
	}
	
	public void clickOnProductName_Filter(WebDriver driver)
	{

		Log.info("Inside clickOnProductName_Filter method");

		String button = "";
		String header = "";
		String hide="";
		String labelList="";
		WebDriverWait wait = new WebDriverWait(driver, 240);
		try
		{

			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_EsupportMPSPage.ProductNameFilterOption()))
			{
				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.RowsDisplayedInGrid());	
				List<WebElement> list2=driver.findElements(obj_EsupportMPSPage.RowsDisplayedInGrid());
				int count1=list2.size();
				System.out.println(count1);

				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.ProductNameFilterOption());	
				String filter=CommonUtility.highlightElement(driver,obj_EsupportMPSPage.ProductNameFilterOption()).getText();	
				System.out.println(filter);
				CommonUtility.ClickOn(driver,obj_EsupportMPSPage.ProductNameFilterOption());	
				
				
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportMPSPage.ProductNameHeading()));
				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.ProductNameHeading());	
				header=CommonUtility.highlightElement(driver,obj_EsupportMPSPage.ProductNameHeading()).getText();	
				System.out.println(header);
				
				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.SearchTextBoxInProductName());
				
				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.ProductNameOptionsInFilterByPopUp());	
				List<WebElement> list=driver.findElements(obj_EsupportMPSPage.ProductNameOptionsInFilterByPopUp());

				for(WebElement lt:list)
				{
					CommonUtility.highlightElement(driver, lt);
					String label=lt.getText();

					System.out.println("product name is : " +label);
					labelList+=" <br> " + label;
				}
				System.out.println("product names displayed are:"+labelList);
				
				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.ResetSelectionButton());
				if(!(CommonUtility.highlightElement(driver,obj_EsupportMPSPage.ResetSelectionButton()).isEnabled()));
				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.ApplySelectedButton());
				if(!(CommonUtility.highlightElement(driver,obj_EsupportMPSPage.ApplySelectedButton()).isEnabled()));
				
				Report.put("Click on the product name ",
						"Product name with search option and list of the product names associated with account should be displayed ",
						"User clicks on "+Report.color(filter)+" with heading "+Report.color(header)+" and product options displayed "+Report.color(labelList), "PASS");

				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.ProductNameOptionsInFilterByPopUp());	
				List<WebElement> list1=driver.findElements(obj_EsupportMPSPage.ProductNameOptionsInFilterByPopUp());

				int count=0;
				for(int i=0; i<=list1.size(); i++)
				{
					count++;
					if(count==1)
					{
						CommonUtility.ScrollToWebElement(driver,list1.get(i));
						CommonUtility.ClickOnWebElement(driver,list1.get(i));
					}
					else
					{
						break;
					}
				}
				
				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.ResetSelectionButton());
				CommonUtility.highlightElement(driver,obj_EsupportMPSPage.ResetSelectionButton()).isEnabled();
				
				
				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.ApplySelectedButton());
				CommonUtility.highlightElement(driver,obj_EsupportMPSPage.ApplySelectedButton()).isEnabled();
				CommonUtility.ClickOn(driver,obj_EsupportMPSPage.ApplySelectedButton());
				
				
				Report.put("Select any product name check box ",
						"Reset selection and Apply selected buttons should be enabled ",
						"User able to select first option displayed and able to see apply selected and reset selection buttons enabled", "PASS");
				
				
				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.RowsDisplayedInGrid());	
				List<WebElement> list3=driver.findElements(obj_EsupportMPSPage.RowsDisplayedInGrid());
				int count2=list3.size();
				System.out.println(count2);
				
				Thread.sleep(6000);
				clickXButtonOnFilterPopUp(driver);
				Thread.sleep(6000);
				
				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.ProductNameAboveGridAfterApplyingFilter());
				String pname=CommonUtility.highlightElement(driver,obj_EsupportMPSPage.ProductNameAboveGridAfterApplyingFilter()).getText();
				System.out.println(pname);
				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.XButtonOFProductName());
				CommonUtility.ClickOn(driver,obj_EsupportMPSPage.XButtonOFProductName());
				
				if(count1>=count2)
				{
					Report.put("Click on button apply selected ",
							"Modal window should go off and product name selected should be displayed in the gird list with the filter by Modal window open ",
							"User clicks on apply selected successfully and able to see grid display filtered product with row count number in grid  "+count2+" with "+Report.color(pname)+" above the grid", "PASS");
					
				}
				else
				{
					System.out.println("failed to see filter apllied");
					Report.put("Click on button apply selected ",
							"Modal window should go off and product name selected should be displayed in the gird list with the filter by Modal window open ",
							"Failed to see filter applied", "Fail");
//					Assert.fail();
				}
				
//				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.RowsDisplayedInGrid());	
//				List<WebElement> list4=driver.findElements(obj_EsupportMPSPage.RowsDisplayedInGrid());
//				int count3=list4.size();
//				System.out.println(count3);
				
				
				Report.put("Close the product name mark above the grid ",
						"My products should reset to the original view and display all the assets associated with account ",
						"User able to see clicking on x mark on product name filter grid is refreshed with original data with count of rows as "+count2, "PASS");
				
				
			}
			else
			{
				System.out.println("failed to see product name filter");
				Report.put("Click on the product name ",
						"Product name with search option and list of the product names associated with account should be displayed ",
						"failed to see product name filter", "Fail");

				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on the product name ",
					"Product name with search option and list of the product names associated with account should be displayed ",
					"failed to see product name filter", "Fail");
			Assert.fail();
		}
	}
	
	
	public void clickXButtonOnFilterPopUp(WebDriver driver)
	{

		Log.info("Inside clickXButtonOnFilterPopUp method");

		String button = "";
		String header = "";
		String hide="";
		String labelList="";
		WebDriverWait wait = new WebDriverWait(driver, 240);
		try
		{

			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_EsupportMPSPage.XMarkInFilterByPopUp()))
			{

				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.XMarkInFilterByPopUp());	
				CommonUtility.ClickOn(driver,obj_EsupportMPSPage.XMarkInFilterByPopUp());	

				Thread.sleep(6000);
				Report.put("Click on the  close cross icon displayed at the top right corner",
						"User should close the window filter by",
						"User able to click on Xbutton and filter window get closed", "PASS");

			}
			else
			{
				System.out.println("failed to see X mark on filter popup");
				Report.put("Click on the  close cross icon displayed at the top right corner",
						"User should close the window filter by",
						"failed to see X mark on filter popup", "Fail");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on the  close cross icon displayed at the top right corner",
					"User should close the window filter by",
					"failed to see X mark on filter popup", "Fail");
			Assert.fail();
		}
	}
	
	public void clickOnWarrantyType_Filter(WebDriver driver)
	{

		Log.info("Inside clickOnWarrantyType_Filter method");

		String button = "";
		String header = "";
		String hide="";
		String labelList="";
		WebDriverWait wait = new WebDriverWait(driver, 240);
		Actions act=new Actions(driver);
		
		try
		{

			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_EsupportMPSPage.WarrantyTypeFilterOption()))
			{
				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.RowsDisplayedInGrid());	
				List<WebElement> list2=driver.findElements(obj_EsupportMPSPage.RowsDisplayedInGrid());
				int count1=list2.size();
				System.out.println(count1);

				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.WarrantyTypeFilterOption());	
				String filter=CommonUtility.highlightElement(driver,obj_EsupportMPSPage.WarrantyTypeFilterOption()).getText();	
				System.out.println(filter);
				CommonUtility.ClickOn(driver,obj_EsupportMPSPage.WarrantyTypeFilterOption());	
				
				
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportMPSPage.ProductNameHeading()));
				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.ProductNameHeading());	
				header=CommonUtility.highlightElement(driver,obj_EsupportMPSPage.ProductNameHeading()).getText();	
				System.out.println(header);
				
				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.SearchTextBoxInProductName());
				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.ProductNameOptionsInFilterByPopUp());	
				List<WebElement> list=driver.findElements(obj_EsupportMPSPage.ProductNameOptionsInFilterByPopUp());

				for(WebElement lt:list)
				{
					CommonUtility.highlightElement(driver, lt);
					String label=lt.getText();

					System.out.println("product name is : " +label);
					labelList+=" <br> " + label;
				}
				System.out.println("product names displayed are:"+labelList);
				
				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.ResetSelectionButton());
				if(!(CommonUtility.highlightElement(driver,obj_EsupportMPSPage.ResetSelectionButton()).isEnabled()));
				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.ApplySelectedButton());
				if(!(CommonUtility.highlightElement(driver,obj_EsupportMPSPage.ApplySelectedButton()).isEnabled()));
				
				Report.put("select the warranty type option ",
						"User should display with the warranty types expired , pro support , pro support plus and unknow",
						"User clicks on "+Report.color(filter)+" with heading "+Report.color(header)+" and product options displayed "+Report.color(labelList), "PASS");

				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.ProductNameOptionsInFilterByPopUp());	
				List<WebElement> list1=driver.findElements(obj_EsupportMPSPage.ProductNameOptionsInFilterByPopUp());

				int count=0;
				for(int i=0; i<=list1.size(); i++)
				{
					count++;
					if(count==1)
					{
						CommonUtility.ScrollToWebElement(driver,list1.get(i));
						CommonUtility.ClickOnWebElement(driver,list1.get(i));
						
					}
					else
					{
						break;
					}
				}
				
				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.ResetSelectionButton());
				CommonUtility.highlightElement(driver,obj_EsupportMPSPage.ResetSelectionButton()).isEnabled();
				
				
				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.ApplySelectedButton());
				CommonUtility.highlightElement(driver,obj_EsupportMPSPage.ApplySelectedButton()).isEnabled();
				CommonUtility.ClickOn(driver,obj_EsupportMPSPage.ApplySelectedButton());
				
				Report.put("select the pro support check box ",
						"Reset selection and Apply selected buttons should be enabled ",
						"User able to select first option displayed and able to see apply selected and reset selection buttons enabled", "PASS");
				
				
				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.RowsDisplayedInGrid());	
				List<WebElement> list3=driver.findElements(obj_EsupportMPSPage.RowsDisplayedInGrid());
				int count2=list3.size();
				System.out.println(count2);
				
				Thread.sleep(6000);
				clickXButtonOnFilterPopUp(driver);
				Thread.sleep(6000);
				
				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.WarrantyTypesAboveGridAfterSelectingFilter());
				String pname=CommonUtility.highlightElement(driver,obj_EsupportMPSPage.WarrantyTypesAboveGridAfterSelectingFilter()).getText();
				System.out.println(pname);
				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.XButtonOFWarrantyType());
				CommonUtility.ClickOn(driver,obj_EsupportMPSPage.XButtonOFWarrantyType());
				
				if(count1>=count2)
				{
					Report.put("Click on button apply selected ",
							"Modal window should go off and warranty type selected should be displayed in the gird list with the filter by Modal window open ",
							"User clicks on apply selected successfully and able to see grid display filtered product with row count number in grid  "+count2+" with "+Report.color(pname)+" above the grid", "PASS");
					
				}
				else
				{
					System.out.println("failed to see filter apllied");
					Report.put("Click on button apply selected ",
							"Modal window should go off and warranty type selected should be displayed in the gird list with the filter by Modal window open ",
							"Failed to see filter applied", "Fail");
					//Assert.fail();
				}
				
//				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.RowsDisplayedInGrid());	
//				act.moveToElement(CommonUtility.highlightElement(driver, obj_EsupportMPSPage.RowsDisplayedInGrid())).build().perform();
//				List<WebElement> list4=driver.findElements(obj_EsupportMPSPage.RowsDisplayedInGrid());
//				int count3=list4.size();
//				System.out.println(count3);
				
				
				Report.put("Close the warranty type mark above the grid",
						"My products should reset to the original view and display all the assets associated with account ",
						"User able to see clicking on x mark on product name filter grid is refreshed with original data with count of rows as "+count2, "PASS");
				
				
			}
			else
			{
				System.out.println("failed to see warranty type option filter");
				Report.put("select the warranty type option ",
						"User should display with the warranty types expired , pro support , pro support plus and unknow",
						"failed to see warranty type option filter", "Fail");

				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("select the warranty type option ",
					"User should display with the warranty types expired , pro support , pro support plus and unknow",
					"failed to see warranty type option filter", "Fail");
			Assert.fail();
		}
	}
	
	//Sneha
	public void SignInToPremierAccount(WebDriver driver, String Username,String Password, String sel)
	{
		System.out.println("Inside SignInToPremierAccount");
		WebDriverWait  wait = new WebDriverWait(driver, 120);
		Actions act=new Actions(driver);
		

		String header="";
		String faqList="";

		try
		{
			
			driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
            Thread.sleep(5000);
			if(CommonUtility.CheckpresenceofElementLocated(driver,10, obj_EsupportMPSPage.MPSPageHeading()))
			{
				handleCookies(driver);
				CommonUtility.ScrollTo(driver, obj_EsupportMPSPage.MPSPageHeading());
				header=CommonUtility.highlightElement(driver, obj_EsupportMPSPage.MPSPageHeading()).getText();
				System.out.println(header);

				Report.put("Launch the url https://www.dell.com/support/mps/en-us/myproducts", 
						"User should land in the My products and services login page", 
						"User able to launch url successfully and laded on "+Report.color(header)+" page", "PASS");

			}
			else
			{
				System.out.println("failed to land in MPS page");
				Report.put("Launch the url https://www.dell.com/support/mps/en-us/myproducts", 
						"User should land in the My products and services login page", 
						"Failed to land on MPS page", "FAIL");
			}
			if(CommonUtility.CheckpresenceofElementLocated(driver,10, obj_EsupportMPSPage.SignInToYourAccount()))
			{
				
				String SigninText= driver.findElement(obj_EsupportMPSPage.SignInToYourAccount()).getText();
				System.out.print(SigninText);
				String SigninDesText= driver.findElement(obj_EsupportMPSPage.SignInToYourAccountDescription()).getText();
				System.out.print(SigninDesText);
				
				CommonUtility.CheckpresenceofElementLocated(driver, 10, obj_EsupportMPSPage.PremierAccountButton());
				CommonUtility.ScrollTo(driver, obj_EsupportMPSPage.PremierAccountButton());
				CommonUtility.ToClickByUsingJavaScript_PassingByLoc(driver, obj_EsupportMPSPage.PremierAccountButton());


				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.Email()));

				handleCookies(driver);
				CommonUtility.ScrollTo(driver, obj_EsupportDDLHomePage.Email());
				CommonUtility.highlightElement(driver, obj_EsupportDDLHomePage.Email()).clear();
				CommonUtility.highlightElement(driver, obj_EsupportDDLHomePage.Email()).click();
				CommonUtility.highlightElement(driver, obj_EsupportDDLHomePage.Email()).sendKeys(Username);

				System.out.println("Entered Email(Username) as "+Username);

				CommonUtility.ScrollTo(driver, obj_EsupportDDLHomePage.Password());
				CommonUtility.highlightElement(driver, obj_EsupportDDLHomePage.Password()).clear();
				CommonUtility.highlightElement(driver, obj_EsupportDDLHomePage.Password()).click();
				CommonUtility.highlightElement(driver, obj_EsupportDDLHomePage.Password()).sendKeys(Password);

				System.out.println("Entered Password as "+Password);
				CommonUtility.ScrollTo(driver, obj_EsupportDDLHomePage.SignIn());
				CommonUtility.ClickOn(driver, obj_EsupportDDLHomePage.SignIn());
				System.out.println("Clicked on SignIn Button ");

				selectPremierAccountFromDropdown(driver, sel);
				
//				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportMPSPage.SelectAccountText()));
//				CommonUtility.ScrollTo(driver, obj_EsupportMPSPage.SelectAccountText());
//				String SelectAccountText=CommonUtility.highlightElement(driver, obj_EsupportMPSPage.SelectAccountText()).getText();
//				System.out.println("SelectAccountText");
//				
//				Select s=new Select(driver.findElement(obj_EsupportMPSPage.SelectAccountDropDown()));
//				CommonUtility.ClickOn(driver, obj_EsupportMPSPage.SelectAccountDropDown());
//				
//				s.selectByVisibleText("Balance Innovations [ Administrator ]");
//				
//				CommonUtility.ClickOn(driver, obj_EsupportMPSPage.AccessPremierButton());
				
				Thread.sleep(5000);
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportMPSPage.MPSPageHeading()));
				CommonUtility.ScrollTo(driver, obj_EsupportMPSPage.MPSPageHeading());
				String MPS=CommonUtility.highlightElement(driver, obj_EsupportMPSPage.MPSPageHeading()).getText();
				System.out.println(MPS);

				List<WebElement> list=driver.findElements(obj_EsupportMPSPage.TwoTabsInLandingPage());

				for(WebElement lt:list)
				{
					CommonUtility.highlightElement(driver, lt);    
					String tabName=lt.getText();
					System.out.println("tab is: " +tabName);
					faqList+=" <br> " + tabName;
				}

				System.out.println("tabs are:"+faqList);

				CommonUtility.ScrollTo(driver, obj_EsupportMPSPage.MyProductsTabActive());
				String myproduct=CommonUtility.highlightElement(driver, obj_EsupportMPSPage.MyProductsTabActive()).getText();
				System.out.println(myproduct);

				Report.put("Click on sign in and enter valid credentials and click on sign in ", 
						"User should logged in successfully and should load the two tabs -My Products and Service Requests they should be able to see a list of their products (Shipping date <7 years )  By Default My products tab should be selected ", 
						"User successfulyy logged in and able to see "+Report.color("")+" with heading "+Report.color(MPS)+" and able to see tabs "+Report.color(faqList)+" and laded on "+Report.color(myproduct)+" tab by default", "PASS");
			}


			else
			{
				System.out.println("sign in button not displayed");
				Report.put("Click on sign in and enter valid credentials and click on sign in ", 
						"User should logged in successfully and should load the two tabs -My Products and Service Requests they should be able to see a list of their products (Shipping date <7 years )  By Default My products tab should be selected ", 
						"failed to see sign in button", "FAIL");
				Assert.fail();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on sign in and enter valid credentials and click on sign in ", 
					"User should logged in successfully and should load the two tabs -My Products and Service Requests they should be able to see a list of their products (Shipping date <7 years )  By Default My products tab should be selected ", 
					"failed to see sign in button", "FAIL");
			Assert.fail();
		}
	}
	
	public void SignInToMyAccount(WebDriver driver, String Username,String Password)
	{
		System.out.println("Inside SignInToPremierAccount");
		WebDriverWait  wait = new WebDriverWait(driver, 120);
		Actions act=new Actions(driver);
		

		String header="";
		String faqList="";

		try
		{
			
			driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);

           Thread.sleep(5000);
			if(CommonUtility.CheckpresenceofElementLocated(driver,10, obj_EsupportMPSPage.MPSPageHeading()))
			{
				handleCookies(driver);
				CommonUtility.ScrollTo(driver, obj_EsupportMPSPage.MPSPageHeading());
				header=CommonUtility.highlightElement(driver, obj_EsupportMPSPage.MPSPageHeading()).getText();
				System.out.println(header);

				Report.put("Launch the url https://www.dell.com/support/mps/en-us/myproducts", 
						"User should land in the My products and services login page", 
						"User able to launch url successfully and laded on "+Report.color(header)+" page", "PASS");

			}
			else
			{
				System.out.println("failed to land in MPS page");
				Report.put("Launch the url https://www.dell.com/support/mps/en-us/myproducts", 
						"User should land in the My products and services login page", 
						"Failed to land on MPS page", "FAIL");
			}
			if(CommonUtility.CheckpresenceofElementLocated(driver,10, obj_EsupportMPSPage.SignInToYourAccount()))
			{
				
				String SigninText= driver.findElement(obj_EsupportMPSPage.SignInToYourAccount()).getText();
				System.out.print(SigninText);
				String SigninDesText= driver.findElement(obj_EsupportMPSPage.SignInToYourAccountDescription()).getText();
				System.out.print(SigninDesText);
				
				CommonUtility.CheckpresenceofElementLocated(driver, 10, obj_EsupportMPSPage.MyAccountButton());
				CommonUtility.ScrollTo(driver, obj_EsupportMPSPage.MyAccountButton());
				CommonUtility.ToClickByUsingJavaScript_PassingByLoc(driver, obj_EsupportMPSPage.MyAccountButton());


//				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.Email()));
				if(CommonUtility.CheckpresenceofElementLocated(driver, 20, obj_EsupportDDLHomePage.Email()))
				{
				    handleCookies(driver);
				    CommonUtility.ScrollTo(driver, obj_EsupportDDLHomePage.Email());
				    CommonUtility.highlightElement(driver, obj_EsupportDDLHomePage.Email()).clear();
				    CommonUtility.highlightElement(driver, obj_EsupportDDLHomePage.Email()).click();
				    CommonUtility.highlightElement(driver, obj_EsupportDDLHomePage.Email()).sendKeys(Username);

			    	System.out.println("Entered Email(Username) as "+Username);

				    CommonUtility.ScrollTo(driver, obj_EsupportDDLHomePage.Password());
				    CommonUtility.highlightElement(driver, obj_EsupportDDLHomePage.Password()).clear();
				    CommonUtility.highlightElement(driver, obj_EsupportDDLHomePage.Password()).click();
				    CommonUtility.highlightElement(driver, obj_EsupportDDLHomePage.Password()).sendKeys(Password);

			    	System.out.println("Entered Password as "+Password);
			    	CommonUtility.ScrollTo(driver, obj_EsupportDDLHomePage.SignIn());
				    CommonUtility.ClickOn(driver, obj_EsupportDDLHomePage.SignIn());
				    System.out.println("Clicked on SignIn Button ");
				}
				
				else if(CommonUtility.CheckpresenceofElementLocated(driver, 20, obj_EsupportDDLHomePage.Email1()))
	            {
	            	CommonUtility.ScrollTo(driver, obj_EsupportDDLHomePage.Email1());
					CommonUtility.highlightElement(driver, obj_EsupportDDLHomePage.Email1()).sendKeys(Username);
		
					System.out.println("Entered Email(Username) as "+Username);
		
					Thread.sleep(2000);
					
					CommonUtility.ScrollTo(driver, obj_EsupportDDLHomePage.Password1());
					CommonUtility.highlightElement(driver, obj_EsupportDDLHomePage.Password1()).sendKeys(Password);
		
					System.out.println("Entered Password as "+Password);
					CommonUtility.highlightElement(driver, obj_EsupportDDLHomePage.SignInButton());
	                CommonUtility.ClickOn(driver, obj_EsupportDDLHomePage.SignInButton());
					System.out.println("Clicked on SignIn Button ");			
					Thread.sleep(10000);
	            }					
			     	
				Thread.sleep(5000);
			    wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportMPSPage.MPSPageHeading()));
			    CommonUtility.ScrollTo(driver, obj_EsupportMPSPage.MPSPageHeading());
			    String MPS=CommonUtility.highlightElement(driver, obj_EsupportMPSPage.MPSPageHeading()).getText();
			    System.out.println(MPS);
			    List<WebElement> list=driver.findElements(obj_EsupportMPSPage.TwoTabsInLandingPage());

			   	for(WebElement lt:list)
			    {
				    CommonUtility.highlightElement(driver, lt);    
			    	String tabName=lt.getText();
			    	System.out.println("tab is: " +tabName);
				    faqList+=" <br> " + tabName;
		     	}

			     	System.out.println("tabs are:"+faqList);

				    CommonUtility.ScrollTo(driver, obj_EsupportMPSPage.MyProductsTabActive());
				    String myproduct=CommonUtility.highlightElement(driver, obj_EsupportMPSPage.MyProductsTabActive()).getText();
				    System.out.println(myproduct);

			    	Report.put("Click on sign in and enter valid credentials and click on sign in ", 
						"User should logged in successfully and should load the two tabs -My Products and Service Requests they should be able to see a list of their products (Shipping date <7 years )  By Default My products tab should be selected ", 
						"User successfulyy logged in and able to see "+Report.color("")+" with heading "+Report.color(MPS)+" and able to see tabs "+Report.color(faqList)+" and laded on "+Report.color(myproduct)+" tab by default", "PASS");
			}
            else
			{
				System.out.println("sign in button not displayed");
				Report.put("Click on sign in and enter valid credentials and click on sign in ", 
						"User should logged in successfully and should load the two tabs -My Products and Service Requests they should be able to see a list of their products (Shipping date <7 years )  By Default My products tab should be selected ", 
						"failed to see sign in button", "FAIL");
				Assert.fail();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on sign in and enter valid credentials and click on sign in ", 
					"User should logged in successfully and should load the two tabs -My Products and Service Requests they should be able to see a list of their products (Shipping date <7 years )  By Default My products tab should be selected ", 
					"failed to see sign in button", "FAIL");
			Assert.fail();
		}
	}
	
	public void ClickOnAddProduct(WebDriver driver)
    {
    	WebDriverWait wait = new WebDriverWait(driver, 600);
        System.out.println("Entered method ClickOnAddProduct");
        driver.manage().timeouts().implicitlyWait(600, TimeUnit.SECONDS);
        
        try
        {
        	if(CommonUtility.CheckpresenceofElementLocated(driver, 20, obj_EsupportMPSPage.AddProductButtonOnMyProducts()))
	    	 {
	    		 CommonUtility.ScrollTo(driver, obj_EsupportMPSPage.AddProductButtonOnMyProducts());
	    		 CommonUtility.ClickOn(driver, obj_EsupportMPSPage.AddProductButtonOnMyProducts());
	    		 Thread.sleep(4000);
	    		 System.out.println("Clicked on AddProductButtonOnMyProducts button");
	    		 
	    		 Report.put("Verify Continue button and click on AddProductButtonOnMyProducts button", 
	 	       			"User should click on AddProductButtonOnMyProducts button", 
	 	       			"User clicked on AddProductButtonOnMyProducts button", "Pass");
	    	 }	
        }
        catch(Exception e)
        {
        	e.printStackTrace();
	      	 Report.put("Verify Continue button and click on AddProductButtonOnMyProducts button", 
	       			"User should click AddProductButtonOnMyProducts button", 
	       			"User failed to click AddProductButtonOnMyProducts button", "Fail");
	      	 Assert.fail();	
        }
    }
	
	public void VerifyAddProductHeaderText(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 600);
        System.out.println("Entered method ClickOnAddProduct");
        driver.manage().timeouts().implicitlyWait(600, TimeUnit.SECONDS);
        String Headertext;
        
        try
        {
        	if(CommonUtility.CheckpresenceofElementLocated(driver, 20, obj_EsupportMPSPage.AddProductsHeaderText()))
        	{
        		Headertext=driver.findElement(obj_EsupportMPSPage.AddProductsHeaderText()).getText();
        		if(Headertext.equals("Add Products"))
        		{
        			System.out.println("Header text is --- "+Headertext);
        			Report.put("Verify header text after clicking on Add Products", 
        	       			"Header text should displayed as Add Products", 
        	       			"User successfully verified header text as "+Report.color(Headertext), "Pass");
        		}
        		else
        		{
        			Report.put("Verify header text after clicking on Add Products", 
        	       			"Header text should displayed as Add Products", 
        	       			"User failed to verify header text", "Fail");
        		}
        	}
        }
        catch(Exception e)
        {
        	Report.put("Verify header text after clicking on Add Products", 
	       			"Header text should displayed as Add Products", 
	       			"User failed to verify header text", "Fail");
        }
	}
	
	public void AddCustomerOrderNumberPostalCode(WebDriver driver, String CustomerNo, String OrderNo, String PostalCode)
	{
		WebDriverWait wait = new WebDriverWait(driver, 600);
        System.out.println("Entered method ClickOnAddProduct");
        driver.manage().timeouts().implicitlyWait(600, TimeUnit.SECONDS);
        
        try
        {
        	wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportMPSPage.CustomerNumberTextbox()));
            CommonUtility.ScrollTo(driver, obj_EsupportMPSPage.CustomerNumberTextbox());
            CommonUtility.highlightElement(driver, obj_EsupportMPSPage.CustomerNumberTextbox()).sendKeys(CustomerNo);
            
            CommonUtility.ScrollTo(driver, obj_EsupportMPSPage.orderNumberTextbox());
            CommonUtility.highlightElement(driver, obj_EsupportMPSPage.orderNumberTextbox()).sendKeys(OrderNo);
            
            CommonUtility.ScrollTo(driver, obj_EsupportMPSPage.PostalCodeTextBox());
            CommonUtility.highlightElement(driver, obj_EsupportMPSPage.PostalCodeTextBox()).sendKeys(PostalCode);
            
            Report.put("Add CustomerNumber, OrderNumber, Postal Code", 
	       			"User should Add CustomerNumber, OrderNumber, Postal Code", 
	       			"User successfully Added CustomerNumber,OrderNumber,Postal Code as "+Report.color(CustomerNo+","+OrderNo+","+PostalCode)+" respectively", "Pass");
        }
        catch(Exception e)
        {
        	e.printStackTrace();
	      	 Report.put("Add CustomerNumber, OrderNumber, Postal Code", 
	       			"User should Add CustomerNumber, OrderNumber, Postal Code", 
	       			"User failed to Add CustomerNumber, OrderNumber, Postal Code", "Fail");
	      	 Assert.fail();	
        }
	}
	
    public void ClickOnFindProductsButton(WebDriver driver)
    {
    	WebDriverWait wait = new WebDriverWait(driver, 600);
        System.out.println("Entered method ClickOnFindProductButton");
        driver.manage().timeouts().implicitlyWait(600, TimeUnit.SECONDS);
        
        try
        {
        	if(CommonUtility.CheckpresenceofElementLocated(driver, 20, obj_EsupportMPSPage.FindProductsButton()))
	    	 {
	    		 CommonUtility.ScrollTo(driver, obj_EsupportMPSPage.FindProductsButton());
	    		 CommonUtility.ClickOn(driver, obj_EsupportMPSPage.FindProductsButton());
	    		 Thread.sleep(4000);
	    		 System.out.println("Clicked on FindProductsButton button");
	    		 
	    		 Report.put("Verify Continue button and click on FindProducts button", 
	 	       			"User should click on FindProducts button", 
	 	       			"User clicked on FindProducts button", "Pass");
	    	 }	
        }
        catch(Exception e)
        {
        	e.printStackTrace();
	      	 Report.put("Verify Continue button and click on FindProducts button", 
	       			"User should click FindProducts button", 
	       			"User failed to click FindProducts button", "Fail");
	      	 Assert.fail();	
        }
    }

    public void ClickOnSupportMenuAndVerifyMyProductAndService(WebDriver driver)
    {
    	WebDriverWait wait = new WebDriverWait(driver, 600);
        System.out.println("Entered method ClickOnSupportMenuFromMastHead");
        driver.manage().timeouts().implicitlyWait(600, TimeUnit.SECONDS);
        String text;
        try
        {
        	if(CommonUtility.CheckpresenceofElementLocated(driver, n, obj_EsupportMPSPage.SupportMenuFromMastHead()))
        	{
        		CommonUtility.ScrollTo(driver, obj_EsupportMPSPage.SupportMenuFromMastHead());
        		CommonUtility.highlightElement(driver, obj_EsupportMPSPage.SupportMenuFromMastHead()).click();
        		Thread.sleep(3000);
        		
        		
        		
        		wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportMPSPage.MyProductsAndServicesOnSubNav()));
        		
        		Boolean result=driver.findElement(obj_EsupportMPSPage.MyProductsAndServicesOnSubNav()).isDisplayed();
        		text=driver.findElement(obj_EsupportMPSPage.MyProductsAndServicesOnSubNav()).getText();
        		
        		if(result==true) 
        		{
        			
        			CommonUtility.highlightElement(driver, obj_EsupportMPSPage.MyProductsAndServicesOnSubNav());
        		}
        		
        		Report.put("User click on SupportMenu button", 
    	       			"User should be able to see \\\"My Products and Services\\\" on the sub navigation bar", 
    	       			"User is able to see "+Report.color(text), "Pass");
        	}
        	else
        	{
        		Report.put("User click on SupportMenu button", 
    	       			"User should be able to see \\\"My Products and Services\\\" on the sub navigation bar", 
    	       			"User failed to click My Products and Services button", "Fail");
        	}
        }
        catch(Exception e)
        {
        	e.printStackTrace();
	      	 Report.put("Verify Continue button and click on SupportMenu button", 
	       			"User should click SupportMenu button", 
	       			"User failed to click SupportMenu button", "Fail");
	      	 Assert.fail();	
        }
    }

    public void ClickOnMyProductAndServiceSubNav(WebDriver driver)
    {
    	WebDriverWait wait = new WebDriverWait(driver, 600);
        System.out.println("Entered method ClickOnSupportMenuFromMastHead");
        driver.manage().timeouts().implicitlyWait(600, TimeUnit.SECONDS);
        String text;
        try
        {
            if(CommonUtility.CheckpresenceofElementLocated(driver, 20, obj_EsupportMPSPage.MyProductsAndServicesOnSubNav()))	
            {
            	CommonUtility.ScrollTo(driver, obj_EsupportMPSPage.MyProductsAndServicesOnSubNav());
            	CommonUtility.highlightElement(driver, obj_EsupportMPSPage.MyProductsAndServicesOnSubNav()).click();
            }
            Report.put("Verify Continue button and click on MyProductsAndServicesOnSubNav button", 
 	       			"User should click on MyProductsAndServicesOnSubNav button", 
 	       			"User clicked on MyProductsAndServicesOnSubNav button", "Pass");
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        	Report.put("Verify Continue button and click on MyProductsAndServicesOnSubNav button", 
	       			"User should click MyProductsAndServicesOnSubNav button", 
	       			"User failed to click MyProductsAndServicesOnSubNav button", "Fail");
	      	 Assert.fail();
        }
    }
 
    public void ValidateMyProductsAndServicePage(WebDriver driver)
    {    	
    	WebDriverWait wait = new WebDriverWait(driver, 600);
        System.out.println("Entered method ValidateMyProductsAndServicePage");
        driver.manage().timeouts().implicitlyWait(600, TimeUnit.SECONDS);
        String header;
        String role;
        
        try
        {
        	if(CommonUtility.CheckpresenceofElementLocated(driver, 20, obj_EsupportMPSPage.MPSPageHeading()))
        	{
        		CommonUtility.ScrollTo(driver, obj_EsupportMPSPage.MPSPageHeading());
        		CommonUtility.highlightElement(driver, obj_EsupportMPSPage.MPSPageHeading());
        		header=driver.findElement(obj_EsupportMPSPage.MPSPageHeading()).getText();
        	    role=driver.findElement(obj_EsupportMPSPage.RoleAsSiteAdmin()).getText();
        	    if(header.contains("My Products and Services") && role.equals("SiteAdmin"))
        	    {
        	    	System.out.println("Header text is --"+header);
        	    	System.out.println("Role is --"+role);
        	    	Report.put("User validate My Products and Services page", "User should able to see the header text and Role",
        	    			"User validated header text as "+Report.color(header)+" and Role as "+Report.color(role), "Pass");
        	    }
        	    else
        	    {
        	    	Report.put("User validate My Products and Services page", "User should able to see the header text and Role",
        	    			"User failed to validat header text and Role", "Pass");
        	    	Assert.fail();
        	    }
        	}
        }
        catch(Exception e)
        {
        	Report.put("User validate My Products and Services page", "User should able to see the header text and Role",
	    			"User failed to validat header text and Role", "Pass");
	    	Assert.fail();
        }
    }
    
    public void ValidateMyProductsTab(WebDriver driver)
    {
    	WebDriverWait wait = new WebDriverWait(driver, 600);
        System.out.println("Entered method ValidateMyProductsTab");
        driver.manage().timeouts().implicitlyWait(600, TimeUnit.SECONDS);
        
    	try
    	{
    		if(CommonUtility.CheckpresenceofElementLocated(driver, 20, obj_EsupportMPSPage.MyProductsTabActive()))
    		{
    			handleCookies(driver);
    			CommonUtility.ScrollTo(driver, obj_EsupportMPSPage.MyProductsTabActive());
    			CommonUtility.highlightElement(driver, obj_EsupportMPSPage.MyProductsTabActive()).click();
    		    Thread.sleep(5000);
    		    
    		    handleCookies(driver);
    		    
    		    CommonUtility.ScrollTo(driver, obj_EsupportMPSPage.ListOfColumnNamesInMyProductsTab());
    		    List<WebElement> columns=driver.findElements(obj_EsupportMPSPage.ListOfColumnNamesInMyProductsTab());
    		    Boolean result1=driver.findElement(obj_EsupportMPSPage.ListOfColumnNamesInMyProductsTab()).isDisplayed();
    		    Boolean result2=driver.findElement(obj_EsupportMPSPage.ListOfThreeDotButton()).isDisplayed();
    		    Boolean result3=driver.findElement(obj_EsupportMPSPage.ListOfExpandButtonInMyProductsTab()).isDisplayed();
    		   
    		    if(result1==true && result2==true && result3==true)
    		    {
    		    	System.out.println("Total available Columns are"+columns.size());
    		    	for(int i=0; i<columns.size();i++)
    		    	{
    		    		System.out.println(columns.get(i).getText());
    		    	}
    		    }
    		    Report.put("User clicks on MyProducts Tab","User should be able to see the Grid view ",
    		    		"User successfully validated grid view","Pass");
    		}
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    		Report.put("User clicks on MyProducts Tab","User should be able to see the Grid view ",
		    		"User failed validating grid view","Fail");
    		Assert.fail();
    	}
    }

    public void ClickOnServiceTagInMyProductsTab(WebDriver driver)
    {
    	WebDriverWait wait = new WebDriverWait(driver, 600);
        System.out.println("Entered method ClickOnServiceTagInMyProductsTab");
        driver.manage().timeouts().implicitlyWait(600, TimeUnit.SECONDS);
        String prodHeader;
        
        try
        {
        	if(CommonUtility.highlightElement(driver,obj_EsupportMPSPage.ListOfUnderlinedServiceTagInMyProductsTab()).isDisplayed())
        	{
        		List<WebElement> l=driver.findElements(obj_EsupportMPSPage.ListOfUnderlinedServiceTagInMyProductsTab());
        		System.out.println("Total number of clickable servicetag is "+l.size());
        		
        		for(int i=0; i<=l.size();i++)
        		{
        			CommonUtility.highlightElement(driver, l.get(i)).click();
        			Thread.sleep(5000);
        			break;
        		}
        		
        		String mainwindow=driver.getWindowHandle();
				Set<String> set=driver.getWindowHandles();
				int count=set.size();
				System.out.println("window count is "+count);

				Iterator<String> itr=set.iterator();
				while(itr.hasNext())
				{
					String childWindow=itr.next();
					if(!mainwindow.equals(childWindow))
					{
						driver.switchTo().window(childWindow);
						
						if(CommonUtility.CheckpresenceofElementLocated(driver, 10, obj_EsupportIPSHomePage.ProductHeader2()))
						{
							CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.ProductHeader2());
							prodHeader = CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.ProductHeader2()).getText();

							System.out.println("Product Page header is:"+prodHeader);
							
							Report.put("User click on any underlined Service tag", "User should land on Product Support page", 
									"User successfully landed on Product Support page"+Report.color(prodHeader), "Pass");
						}
						
					    driver.close();
					}
				}
				driver.switchTo().window(mainwindow);
        	    
			}
        }
        catch(Exception e)
        {
        	Report.put("User click on any underlined Service tag", "User should land on Product Support page", 
					"User failed to land on Product Support page", "Fail");
        }
    }

    public void clickOnSupportServicesIconOnActiveColumn(WebDriver driver)
    {
    	WebDriverWait wait = new WebDriverWait(driver, 600);
        System.out.println("Entered method ValidateMyProductsTab");
        driver.manage().timeouts().implicitlyWait(600, TimeUnit.SECONDS);
        Actions act=new Actions(driver);
        
        try 
        {
        	if(CommonUtility.highlightElement(driver, obj_EsupportMPSPage.ListOfSupportServiceIconInActivityColumn()).isDisplayed())
        	{
        		List<WebElement> list=driver.findElements(obj_EsupportMPSPage.ListOfSupportServiceIconInActivityColumn());
        		int count=list.size();
        		System.out.println("Total values present in Activity column is "+count);
        		Thread.sleep(3000);
        		for(int i=0; i<count; i++)
        		{
        		   act.moveToElement(list.get(i)).build().perform();	
        		   Thread.sleep(3000);
        		   Boolean result=driver.findElement(obj_EsupportMPSPage.ToolTipTextOfActivityColumnValues()).isDisplayed();
        		   String tooltip=driver.findElement(obj_EsupportMPSPage.ToolTipTextOfActivityColumnValues()).getText();
        		   Thread.sleep(3000);
        		   if(result==true && tooltip.contains("Support Services"))
        		   {
        			   CommonUtility.highlightElement(driver, obj_EsupportMPSPage.ToolTipTextOfActivityColumnValues()).click();
        			   System.out.println("User clicked on"+tooltip);
        			   Thread.sleep(5000);
        			   
        			   if(CommonUtility.CheckpresenceofElementLocated(driver, 20, obj_EsupportMPSPage.SupportServicesDetailsHeader()))
        			   {
        				   String header=driver.findElement(obj_EsupportMPSPage.SupportServicesDetailsHeader()).getText();
        				   System.out.println("Popup displaying with Headertext -- "+header );
        				   Thread.sleep(3000);
        				   CommonUtility.highlightElement(driver, obj_EsupportMPSPage.XButtonToCloseSupportServicePopup());
        				   
        				   Report.put("User verify Activity column values and click on \"Support Services\" icon", 
           	        			"User should able to see Support Service tooltip text and after clicking Support Service Details popup should open",
           	        			"User successfully validateed"+Report.color(header)+"Pop up", "Pass");
        				   break; 
        			   }
        			   else      			   
        			   {
        				   System.out.println("Some issue with data, Support Services Details Popup is not displaying");
//        				   Assert.fail();
        			   }
        			 break;  
        			}
        		   else
        		   {
        			   System.out.println("Support Services is not present in Activity column ");
        		   }
        		}
        	}
        	
        	Report.put("User Hover on the Activity column and click on  \"Support Services\" icon", 
        			"User should able to see Support Service tooltip text and after clicking Support Service Details popup should open",
        			"User successfully validated Support Service Details", "Pass");
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        	Report.put("User Hover on the Activity column and click on  \"Support Services\" icon", 
        			"User should able to see Support Service tooltip text and after clicking Support Service Details popup should open",
        			"User failed to validate Support Service Details", "Fail");
        	Assert.fail();
        }
    }

    public void clickOnServiceRequestIconOnActiveColumn(WebDriver driver)
    {
    	WebDriverWait wait = new WebDriverWait(driver, 600);
        System.out.println("Entered method ValidateMyProductsTab");
        driver.manage().timeouts().implicitlyWait(600, TimeUnit.SECONDS);
        Actions act=new Actions(driver);
        
        try 
        {
        	if(CommonUtility.CheckpresenceofAllElementLocated(driver, 20, obj_EsupportMPSPage.ListOfServiceRequestIconInActivityColumn()))
        	{
        		List<WebElement> list=driver.findElements(obj_EsupportMPSPage.ListOfServiceRequestIconInActivityColumn());
        		int count=list.size();
        		System.out.println("Total values present in Activity column is "+count);
        		
        		for(int i=0; i<count; i++)
        		{
        		   act.moveToElement(list.get(i)).build().perform();	
        		   CommonUtility.ScrollTo(driver, obj_EsupportMPSPage.ToolTipTextOfActivityColumnValues());
        		   Boolean result=driver.findElement(obj_EsupportMPSPage.ToolTipTextOfActivityColumnValues()).isDisplayed();
        		   String tooltip=driver.findElement(obj_EsupportMPSPage.ToolTipTextOfActivityColumnValues()).getText();
        		   Thread.sleep(3000);
        		   if(result==true && tooltip.equals("Service Request"))
        		   {
        			   CommonUtility.highlightElement(driver, obj_EsupportMPSPage.ToolTipTextOfActivityColumnValues()).click();
        			   System.out.println("User clicked on"+tooltip);
        			   Thread.sleep(5000);
        			   break;
        			}
        		   else
        		   {
        			   System.out.println("Support Services is not present in Activity column ");
        		   }
        		}
        		
        		String mainwindow=driver.getWindowHandle();
				Set<String> set=driver.getWindowHandles();
				int windowcount=set.size();
				System.out.println("window count is "+windowcount);

				Iterator<String> itr=set.iterator();
				while(itr.hasNext())
				{
					String childWindow=itr.next();
					if(!mainwindow.equals(childWindow))
					{
						driver.switchTo().window(childWindow);
						
						System.out.println(driver.getTitle());
						if(driver.getTitle().contains("Service Request Details"))
						{
							System.out.println("test case passed");
						}
						else
						{
							System.out.println("Window title is not matching");
						}
					    driver.close();
					}
				}
				driver.switchTo().window(mainwindow);
        	}
        	
        	Report.put("User Hover on the Activity column and click on  \"Services Request \" icon", 
        			"User should able to see Services Request tooltip text and after clicking new Services Request window should open",
        			"User successfully validated Services Request window", "Pass");
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        	Report.put("User Hover on the Activity column and click on  \"Services Request \" icon", 
        			"User should able to see Services Request tooltip text and after clicking new Services Request window should open",
        			"User failed to validate Services Request window", "Fail");
        	Assert.fail();
        }
    }
   
    public void clickOnWarrantyStatus_Filter(WebDriver driver)
	{

		Log.info("Inside clickOnWarrantyType_Filter method");

		String button = "";
		String header = "";
		String hide="";
		String labelList="";
		WebDriverWait wait = new WebDriverWait(driver, 240);
		Actions act=new Actions(driver);
		
		try
		{

			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_EsupportMPSPage.WarrantyStatusFilterOption()))
			{
				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.RowsDisplayedInGrid());	
				List<WebElement> list2=driver.findElements(obj_EsupportMPSPage.RowsDisplayedInGrid());
				int count1=list2.size();
				System.out.println(count1);

				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.WarrantyStatusFilterOption());	
				String filter=CommonUtility.highlightElement(driver,obj_EsupportMPSPage.WarrantyStatusFilterOption()).getText();	
				System.out.println(filter);
				CommonUtility.ClickOn(driver,obj_EsupportMPSPage.WarrantyStatusFilterOption());	
				
				
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportMPSPage.ProductNameHeading()));
				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.ProductNameHeading());	
				header=CommonUtility.highlightElement(driver,obj_EsupportMPSPage.ProductNameHeading()).getText();	
				System.out.println(header);
			
				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.ProductNameOptionsInFilterByPopUp());	
				List<WebElement> list=driver.findElements(obj_EsupportMPSPage.ProductNameOptionsInFilterByPopUp());

				for(WebElement lt:list)
				{
					CommonUtility.highlightElement(driver, lt);
					String label=lt.getText();

					System.out.println("product name is : " +label);
					labelList+=" <br> " + label;
				}
				System.out.println("product names displayed are:"+labelList);
				
				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.ResetSelectionButton());
				if(!(CommonUtility.highlightElement(driver,obj_EsupportMPSPage.ResetSelectionButton()).isEnabled()));
				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.ApplySelectedButton());
				if(!(CommonUtility.highlightElement(driver,obj_EsupportMPSPage.ApplySelectedButton()).isEnabled()));
				
				Report.put("select the warranty status option ",
						"User should display with the warranty status expired , pro support , pro support plus and unknow",
						"User clicks on "+Report.color(filter)+" with heading "+Report.color(header)+" and product options displayed "+Report.color(labelList), "PASS");

				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.ProductNameOptionsInFilterByPopUp());	
				List<WebElement> list1=driver.findElements(obj_EsupportMPSPage.ProductNameOptionsInFilterByPopUp());

				int count=0;
				for(int i=0; i<=list1.size(); i++)
				{
					count++;
					if(count==1)
					{
						CommonUtility.ScrollToWebElement(driver,list1.get(i));
						CommonUtility.ClickOnWebElement(driver,list1.get(i));
						
					}
					else
					{
						break;
					}
				}
				
				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.ResetSelectionButton());
				CommonUtility.highlightElement(driver,obj_EsupportMPSPage.ResetSelectionButton()).isEnabled();
				
				
				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.ApplySelectedButton());
				CommonUtility.highlightElement(driver,obj_EsupportMPSPage.ApplySelectedButton()).isEnabled();
				CommonUtility.ClickOn(driver,obj_EsupportMPSPage.ApplySelectedButton());
				
				Report.put("select the warranty status radio button",
						"Reset selection and Apply selected buttons should be enabled ",
						"User able to select first option displayed and able to see apply selected and reset selection buttons enabled", "PASS");
				
				
				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.RowsDisplayedInGrid());	
				List<WebElement> list3=driver.findElements(obj_EsupportMPSPage.RowsDisplayedInGrid());
				int count2=list3.size();
				System.out.println(count2);
				
				Thread.sleep(6000);
				clickXButtonOnFilterPopUp(driver);
				Thread.sleep(6000);
				
				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.WarrantyStatusAboveGridAfterSelectingFilter());
				String pname=CommonUtility.highlightElement(driver,obj_EsupportMPSPage.WarrantyStatusAboveGridAfterSelectingFilter()).getText();
				System.out.println(pname);
				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.XButtonOFWarrantyStatus());
				CommonUtility.ClickOn(driver,obj_EsupportMPSPage.XButtonOFWarrantyStatus());
				
				if(count1>=count2)
				{
					Report.put("Click on button apply selected ",
							"Modal window should go off and warranty type selected should be displayed in the gird list with the filter by Modal window open ",
							"User clicks on apply selected successfully and able to see grid display filtered product with row count number in grid  "+count2+" with "+Report.color(pname)+" above the grid", "PASS");
					
				}
				else
				{
					System.out.println("failed to see filter apllied");
					Report.put("Click on button apply selected ",
							"Modal window should go off and warranty status selected should be displayed in the gird list with the filter by Modal window open ",
							"Failed to see filter applied", "Fail");
					//Assert.fail();
				}
				
//				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.RowsDisplayedInGrid());	
//				act.moveToElement(CommonUtility.highlightElement(driver, obj_EsupportMPSPage.RowsDisplayedInGrid())).build().perform();
//				List<WebElement> list4=driver.findElements(obj_EsupportMPSPage.RowsDisplayedInGrid());
//				int count3=list4.size();
//				System.out.println(count3);
				
				
				Report.put("Close the warranty status mark above the grid",
						"My products should reset to the original view and display all the assets associated with account ",
						"User able to see clicking on x mark on product name filter grid is refreshed with original data with count of rows as "+count2, "PASS");
				
				
			}
			else
			{
				System.out.println("failed to see warranty status option filter");
				Report.put("select the warranty status option ",
						"User should display with the warranty status expired , pro support , pro support plus and unknow",
						"failed to see warranty status option filter", "Fail");

				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("select the warranty type option ",
					"User should display with the warranty types expired , pro support , pro support plus and unknow",
					"failed to see warranty type option filter", "Fail");
			Assert.fail();
		}
	}
    
    public void clickOnExportTableButton(WebDriver driver)
    {
    	Log.info("Inside clickOnExportTableButton method");

		String Buttontext="";
		WebDriverWait wait = new WebDriverWait(driver, 240);
		
		try
		{
			if(CommonUtility.CheckpresenceofElementLocated(driver, 20, obj_EsupportMPSPage.ExportTableButton()))
			{
				CommonUtility.ScrollTo(driver, obj_EsupportMPSPage.ExportTableButton());
				Buttontext = driver.findElement(obj_EsupportMPSPage.ExportTableButton()).getText();
				CommonUtility.highlightElement(driver, obj_EsupportMPSPage.ExportTableButton()).click();
				Thread.sleep(10000);
				
				System.out.println("Clicked on Export Table Button");
	    		 
	    		 Report.put("Verify Continue button and click on Export Table button", 
	 	       			"User should click on Export Table button", 
	 	       			"User clicked on "+Report.color(Buttontext), "Pass");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify Continue button and click on Export Table button", 
 	       			"User should click on Export Table button", 
 	       			"User unable to click on Export Button", "Fail");
	      	Assert.fail();	
		}
    }
    
    public void validateFilterSection(WebDriver driver)
    {
    	Log.info("Inside validateFilterSection method");
        String text = "";

		WebDriverWait wait = new WebDriverWait(driver, 600);
		try
		{
			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_EsupportMPSPage.FirstServiceTagValue()))
			{
				CommonUtility.ScrollTo(driver, obj_EsupportMPSPage.FirstServiceTagValue());
				text=CommonUtility.highlightElement(driver, obj_EsupportMPSPage.FirstServiceTagValue()).getText();
			    System.out.println(text);
			}

			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_EsupportMPSPage.SearchTextBoxInMyProductsPage()))
			{
				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.SearchTextBoxInMyProductsPage());
				CommonUtility.highlightElement(driver,obj_EsupportMPSPage.SearchTextBoxInMyProductsPage()).clear();
				CommonUtility.highlightElement(driver,obj_EsupportMPSPage.SearchTextBoxInMyProductsPage()).sendKeys(text);
			}
			
			CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.SearchButtonInMyProductsTab());
			CommonUtility.ClickOn(driver,obj_EsupportMPSPage.SearchButtonInMyProductsTab());

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportMPSPage.FilteredTextInMyProductsPage()));
			List<WebElement> list=driver.findElements(obj_EsupportMPSPage.FilteredTextInMyProductsPage());

			for(int i=0;i<list.size();i++)
			{
				CommonUtility.ScrollToWebElement(driver, list.get(i));
			}

			Report.put("If the user has searched for any 'string' on the grid ",
					"User should get the grid data filtered,  using the searched text",
					"User able to get the grid data filtered,  using the searched text "+Report.color(text), "PASS");

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("If the user has searched for any 'string' on the grid ",
					"User should get the grid data filtered,  using the searched text",
					"User failed to get the grid data filtered,  using the searched text ", "Fail");
			Assert.fail();
		}

    }
    
    public void clickOnSwitchToPremierAccount(WebDriver driver)
    {
    	Log.info("Inside clickOnSwitchToPremierAccount method");

		String Buttontext="";
		WebDriverWait wait = new WebDriverWait(driver, 240);
		
		try
		{
			if(CommonUtility.CheckpresenceofElementLocated(driver, 20, obj_EsupportMPSPage.SwitchToAnotherPremierAccount()))
			{
				CommonUtility.ScrollTo(driver, obj_EsupportMPSPage.SwitchToAnotherPremierAccount());
				Buttontext = driver.findElement(obj_EsupportMPSPage.SwitchToAnotherPremierAccount()).getText();
//				CommonUtility.highlightElement(driver, obj_EsupportMPSPage.SwitchToAnotherPremierAccount()).click();
				CommonUtility.ClickOn(driver, obj_EsupportMPSPage.SwitchToAnotherPremierAccount());
				Thread.sleep(10000);
				
				System.out.println("Clicked on Switch To Another Premier Account Button");
	    		 
	    		 Report.put("Verify Continue button and click on SwitchToAnotherPremierAccount button", 
	 	       			"User should click on SwitchToAnotherPremierAccount button", 
	 	       			"User clicked on "+Report.color(Buttontext), "Pass");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify Continue button and click on SwitchToAnotherPremierAccount button", 
 	       			"User should click on SwitchToAnotherPremierAccount button", 
 	       			"User unable to click on SwitchToAnotherPremierAccount", "Fail");
	      	Assert.fail();	
		}
    }
    
    public void selectPremierAccountFromDropdown(WebDriver driver, String sel)
    {
    	Log.info("Inside selectPremierAccount method");
        WebDriverWait wait = new WebDriverWait(driver, 240);
		
    	try
    	{
    		wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportMPSPage.SelectAccountText()));
			CommonUtility.ScrollTo(driver, obj_EsupportMPSPage.SelectAccountText());
			String SelectAccountText=CommonUtility.highlightElement(driver, obj_EsupportMPSPage.SelectAccountText()).getText();
			System.out.println("SelectAccountText");
			
			Select s=new Select(driver.findElement(obj_EsupportMPSPage.SelectAccountDropDown()));
			CommonUtility.ClickOn(driver, obj_EsupportMPSPage.SelectAccountDropDown());
			
			s.selectByVisibleText(sel);//"Balance Innovations [ Administrator ]"
			
			CommonUtility.ClickOn(driver, obj_EsupportMPSPage.AccessPremierButton());
			
			Thread.sleep(5000);
			
			Report.put("Select the required account and click on Access Premier", 
					"User should be able to select required account", 
					"User selected Premier account as"+Report.color(sel)+" And clicked on Access Premier", "Pass");
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    		Report.put("Select the required account and click on Access Premier", 
					"User should be able to select required account", 
					"User failed to select Premier account as"+Report.color(sel)+" And clicked on Access Premier", "Fail");
	      	Assert.fail();	
    	}
    }

    public void ValidateServiceRequestTab(WebDriver driver)
    {
    	WebDriverWait wait = new WebDriverWait(driver, 600);
        System.out.println("Entered method ValidateMyServiceTab");
        driver.manage().timeouts().implicitlyWait(600, TimeUnit.SECONDS);
        
    	try
    	{
    		if(CommonUtility.CheckpresenceofElementLocated(driver, 20, obj_EsupportMPSPage.MyProductsTabActive()))
    		{
    			handleCookies(driver);
    			CommonUtility.ScrollTo(driver, obj_EsupportMPSPage.ServiceRequestTabActive());
    			CommonUtility.highlightElement(driver, obj_EsupportMPSPage.ServiceRequestTabActive()).click();
    		    Thread.sleep(5000);
    		    
    		    handleCookies(driver);
    		    
    		    CommonUtility.ScrollTo(driver, obj_EsupportMPSPage.ListOfColumnNamesInMyProductsTab());
    		    List<WebElement> columns=driver.findElements(obj_EsupportMPSPage.ListOfColumnNamesInMyProductsTab());
    		    Boolean result1=driver.findElement(obj_EsupportMPSPage.ListOfColumnNamesInMyProductsTab()).isDisplayed();
    		    Boolean result2=driver.findElement(obj_EsupportMPSPage.ListOfExpandButtonInServiceRequestTab()).isDisplayed();
    		   
    		    if(result1==true && result2==true)
    		    {
    		    	System.out.println("Total available Columns are"+columns.size());
    		    	for(int i=0; i<columns.size();i++)
    		    	{
    		    		String columnName=columns.get(i).getText();
    		    		System.out.println(columnName);
    		    		Report.put("User clicks on ServiceRequest Tab","User should be able to see the Grid view ",
    	    		    		"User successfully validated column name"+Report.color(columnName),"Pass");
    		    	}
    		    }
    		    Report.put("User clicks on MyProducts Tab","User should be able to see the Grid view ",
    		    		"User successfully validated grid view","Pass");
    		}
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    		Report.put("User clicks on MyProducts Tab","User should be able to see the Grid view ",
		    		"User failed validating grid view","Fail");
    		Assert.fail();
    	}
    }

    public void ClickOnServiceTagInServiceRequestTab(WebDriver driver)
    {
    	WebDriverWait wait = new WebDriverWait(driver, 600);
        System.out.println("Entered method ClickOnServiceTagInServiceRequestTab");
        driver.manage().timeouts().implicitlyWait(600, TimeUnit.SECONDS);
        String prodHeader;
        
        try
        {
        	if(CommonUtility.highlightElement(driver,obj_EsupportMPSPage.ListOfUnderlinedServiceTagInServiceRequestTab()).isDisplayed())
        	{
        		List<WebElement> l=driver.findElements(obj_EsupportMPSPage.ListOfUnderlinedServiceTagInServiceRequestTab());
        		System.out.println("Total number of clickable servicetag is "+l.size());
        		
        		for(int i=0; i<=l.size();i++)
        		{
        			CommonUtility.highlightElement(driver, l.get(i)).click();
        			Thread.sleep(5000);
        			break;
        		}
        		
        		String mainwindow=driver.getWindowHandle();
				Set<String> set=driver.getWindowHandles();
				int count=set.size();
				System.out.println("window count is "+count);

				Iterator<String> itr=set.iterator();
				while(itr.hasNext())
				{
					String childWindow=itr.next();
					if(!mainwindow.equals(childWindow))
					{
						driver.switchTo().window(childWindow);
						
						if(CommonUtility.CheckpresenceofElementLocated(driver, 10, obj_EsupportIPSHomePage.ProductHeader2()))
						{
							CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.ProductHeader2());
							prodHeader = CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.ProductHeader2()).getText();

							System.out.println("Product Page header is:"+prodHeader);
							
							Report.put("User click on any underlined Service tag", "User should land on Product Support page", 
									"User successfully landed on Product Support page"+Report.color(prodHeader), "Pass");
						}
						
					    driver.close();
					}
				}
				driver.switchTo().window(mainwindow);
        	    
			}
        }
        catch(Exception e)
        {
        	Report.put("User click on any underlined Service tag", "User should land on Product Support page", 
					"User failed to land on Product Support page", "Fail");
        }
    }
    
    public void ClickOnSRNumberInServiceRequestTab(WebDriver driver)
    {
    	WebDriverWait wait = new WebDriverWait(driver, 600);
        System.out.println("Entered method ClickOnSRNumberInServiceRequestTab");
        driver.manage().timeouts().implicitlyWait(600, TimeUnit.SECONDS);
        String Header;
        
        try
        {
        	if(CommonUtility.highlightElement(driver,obj_EsupportMPSPage.ListOfSRNumberOnServiceRequestTab()).isDisplayed())
        	{
        		List<WebElement> l=driver.findElements(obj_EsupportMPSPage.ListOfSRNumberOnServiceRequestTab());
        		System.out.println("Total number of clickable SRNumber is "+l.size());
        		
        		for(int i=0; i<=l.size();i++)
        		{
        			CommonUtility.highlightElement(driver, l.get(i)).click();
        			Thread.sleep(5000);
        			break;
        		}
        		
        		String mainwindow=driver.getWindowHandle();
				Set<String> set=driver.getWindowHandles();
				int count=set.size();
				System.out.println("window count is "+count);

				Iterator<String> itr=set.iterator();
				while(itr.hasNext())
				{
					String childWindow=itr.next();
					if(!mainwindow.equals(childWindow))
					{
						driver.switchTo().window(childWindow);
						
						if(CommonUtility.CheckpresenceofElementLocated(driver, 10, obj_EsupportMPSPage.ServiceRequestDetailsHeader()))
						{
							CommonUtility.highlightElement(driver,obj_EsupportMPSPage.ServiceRequestDetailsHeader());
							Header = CommonUtility.highlightElement(driver,obj_EsupportMPSPage.ServiceRequestDetailsHeader()).getText();

							System.out.println("Product Page header is:"+Header);
							
							Report.put("User click on any underlined Service tag", "User should land on Service Request Details page", 
									"User successfully landed on Service Request Details page"+Report.color(Header), "Pass");
						}
						
					    driver.close();
					}
				}
				driver.switchTo().window(mainwindow);
        	    
			}
        }
        catch(Exception e)
        {
        	Report.put("User click on any underlined Service tag", "User should land on Service Request Details page", 
					"User failed to land on Service Request Details page", "Fail");
        }
    }

    public void ClickOnStatusName_Filter(WebDriver driver)
    {
    	Log.info("Inside ClickOnStatusName_Filter method");

		String button = "";
		String header = "";
		String hide="";
		String labelList="";
		WebDriverWait wait = new WebDriverWait(driver, 240);
		try
		{

			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_EsupportMPSPage.StatusNameFilterOption()))
			{
				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.RowsDisplayedInGrid());	
				List<WebElement> list2=driver.findElements(obj_EsupportMPSPage.RowsDisplayedInGrid());
				int count1=list2.size();
				System.out.println(count1);

				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.StatusNameFilterOption());	
				String filter=CommonUtility.highlightElement(driver,obj_EsupportMPSPage.StatusNameFilterOption()).getText();	
				System.out.println(filter);
				CommonUtility.ClickOn(driver,obj_EsupportMPSPage.StatusNameFilterOption());	
				
				
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportMPSPage.ProductNameHeading()));
				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.ProductNameHeading());	
				header=CommonUtility.highlightElement(driver,obj_EsupportMPSPage.ProductNameHeading()).getText();	
				System.out.println(header);
				
				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.SearchTextBoxInProductName());
				
				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.ProductNameOptionsInFilterByPopUp());	
				List<WebElement> list=driver.findElements(obj_EsupportMPSPage.ProductNameOptionsInFilterByPopUp());

				for(WebElement lt:list)
				{
					CommonUtility.highlightElement(driver, lt);
					String label=lt.getText();

					System.out.println("product name is : " +label);
					labelList+=" <br> " + label;
				}
				System.out.println("product names displayed are:"+labelList);
				
				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.ResetSelectionButton());
				if(!(CommonUtility.highlightElement(driver,obj_EsupportMPSPage.ResetSelectionButton()).isEnabled()));
				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.ApplySelectedButton());
				if(!(CommonUtility.highlightElement(driver,obj_EsupportMPSPage.ApplySelectedButton()).isEnabled()));
				
				Report.put("Click on the product name ",
						"Product name with search option and list of the product names associated with account should be displayed ",
						"User clicks on "+Report.color(filter)+" with heading "+Report.color(header)+" and product options displayed "+Report.color(labelList), "PASS");

				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.ProductNameOptionsInFilterByPopUp());	
				List<WebElement> list1=driver.findElements(obj_EsupportMPSPage.ProductNameOptionsInFilterByPopUp());

				int count=0;
				for(int i=0; i<=list1.size(); i++)
				{
					count++;
					if(count==1)
					{
						CommonUtility.ScrollToWebElement(driver,list1.get(i));
						CommonUtility.ClickOnWebElement(driver,list1.get(i));
					}
					else
					{
						break;
					}
				}
				
				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.ResetSelectionButton());
				CommonUtility.highlightElement(driver,obj_EsupportMPSPage.ResetSelectionButton()).isEnabled();
				
				
				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.ApplySelectedButton());
				CommonUtility.highlightElement(driver,obj_EsupportMPSPage.ApplySelectedButton()).isEnabled();
				CommonUtility.ClickOn(driver,obj_EsupportMPSPage.ApplySelectedButton());
				
				
				Report.put("Select any product name check box ",
						"Reset selection and Apply selected buttons should be enabled ",
						"User able to select first option displayed and able to see apply selected and reset selection buttons enabled", "PASS");
				
				
				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.RowsDisplayedInGrid());	
				List<WebElement> list3=driver.findElements(obj_EsupportMPSPage.RowsDisplayedInGrid());
				int count2=list3.size();
				System.out.println(count2);
				
				Thread.sleep(6000);
				clickXButtonOnFilterPopUp(driver);
				Thread.sleep(6000);
				
				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.StatusNameAboveGridAfterApplyingFilter());
				String pname=CommonUtility.highlightElement(driver,obj_EsupportMPSPage.StatusNameAboveGridAfterApplyingFilter()).getText();
				System.out.println(pname);
				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.XButtonOFProductName());
				CommonUtility.ClickOn(driver,obj_EsupportMPSPage.XButtonOFProductName());
				
				if(count1>=count2)
				{
					Report.put("Click on button apply selected ",
							"Modal window should go off and product name selected should be displayed in the gird list with the filter by Modal window open ",
							"User clicks on apply selected successfully and able to see grid display filtered product with row count number in grid  "+count2+" with "+Report.color(pname)+" above the grid", "PASS");
					
				}
				else
				{
					System.out.println("failed to see filter apllied");
					Report.put("Click on button apply selected ",
							"Modal window should go off and product name selected should be displayed in the gird list with the filter by Modal window open ",
							"Failed to see filter applied", "Fail");
//					Assert.fail();
				}
				

				Report.put("Close the product name mark above the grid ",
						"My products should reset to the original view and display all the assets associated with account ",
						"User able to see clicking on x mark on product name filter grid is refreshed with original data with count of rows as "+count2, "PASS");
				
				
			}
			else
			{
				System.out.println("failed to see product name filter");
				Report.put("Click on the product name ",
						"Product name with search option and list of the product names associated with account should be displayed ",
						"failed to see product name filter", "Fail");

				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on the product name ",
					"Product name with search option and list of the product names associated with account should be displayed ",
					"failed to see product name filter", "Fail");
			Assert.fail();
		}
    }
    
    public void ClickOnSeverityName_Filter(WebDriver driver)
    {
    	Log.info("Inside ClickOnStatusName_Filter method");

		String button = "";
		String header = "";
		String hide="";
		String labelList="";
		WebDriverWait wait = new WebDriverWait(driver, 240);
		try
		{

			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_EsupportMPSPage.SeverityNameFilterOption()))
			{
				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.RowsDisplayedInGrid());	
				List<WebElement> list2=driver.findElements(obj_EsupportMPSPage.RowsDisplayedInGrid());
				int count1=list2.size();
				System.out.println(count1);

				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.SeverityNameFilterOption());	
				String filter=CommonUtility.highlightElement(driver,obj_EsupportMPSPage.SeverityNameFilterOption()).getText();	
				System.out.println(filter);
				CommonUtility.ClickOn(driver,obj_EsupportMPSPage.SeverityNameFilterOption());	
				
				
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportMPSPage.ProductNameHeading()));
				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.ProductNameHeading());	
				header=CommonUtility.highlightElement(driver,obj_EsupportMPSPage.ProductNameHeading()).getText();	
				System.out.println(header);
				
				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.SearchTextBoxInProductName());
				
				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.ProductNameOptionsInFilterByPopUp());	
				List<WebElement> list=driver.findElements(obj_EsupportMPSPage.ProductNameOptionsInFilterByPopUp());

				for(WebElement lt:list)
				{
					CommonUtility.highlightElement(driver, lt);
					String label=lt.getText();

					System.out.println("product name is : " +label);
					labelList+=" <br> " + label;
				}
				System.out.println("product names displayed are:"+labelList);
				
				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.ResetSelectionButton());
				if(!(CommonUtility.highlightElement(driver,obj_EsupportMPSPage.ResetSelectionButton()).isEnabled()));
				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.ApplySelectedButton());
				if(!(CommonUtility.highlightElement(driver,obj_EsupportMPSPage.ApplySelectedButton()).isEnabled()));
				
				Report.put("Click on the product name ",
						"Product name with search option and list of the product names associated with account should be displayed ",
						"User clicks on "+Report.color(filter)+" with heading "+Report.color(header)+" and product options displayed "+Report.color(labelList), "PASS");

				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.ProductNameOptionsInFilterByPopUp());	
				List<WebElement> list1=driver.findElements(obj_EsupportMPSPage.ProductNameOptionsInFilterByPopUp());

				int count=0;
				for(int i=0; i<=list1.size(); i++)
				{
					count++;
					if(count==1)
					{
						CommonUtility.ScrollToWebElement(driver,list1.get(i));
						CommonUtility.ClickOnWebElement(driver,list1.get(i));
					}
					else
					{
						break;
					}
				}
				
				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.ResetSelectionButton());
				CommonUtility.highlightElement(driver,obj_EsupportMPSPage.ResetSelectionButton()).isEnabled();
				
				
				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.ApplySelectedButton());
				CommonUtility.highlightElement(driver,obj_EsupportMPSPage.ApplySelectedButton()).isEnabled();
				CommonUtility.ClickOn(driver,obj_EsupportMPSPage.ApplySelectedButton());
				
				
				Report.put("Select any product name check box ",
						"Reset selection and Apply selected buttons should be enabled ",
						"User able to select first option displayed and able to see apply selected and reset selection buttons enabled", "PASS");
				
				
				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.RowsDisplayedInGrid());	
				List<WebElement> list3=driver.findElements(obj_EsupportMPSPage.RowsDisplayedInGrid());
				int count2=list3.size();
				System.out.println(count2);
				
				Thread.sleep(6000);
				clickXButtonOnFilterPopUp(driver);
				Thread.sleep(6000);
				
				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.SeverityNameAboveGridAfterApplyingFilter());
				String pname=CommonUtility.highlightElement(driver,obj_EsupportMPSPage.SeverityNameAboveGridAfterApplyingFilter()).getText();
				System.out.println(pname);
				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.XButtonOFProductName());
				CommonUtility.ClickOn(driver,obj_EsupportMPSPage.XButtonOFProductName());
				
				if(count1>=count2)
				{
					Report.put("Click on button apply selected ",
							"Modal window should go off and product name selected should be displayed in the gird list with the filter by Modal window open ",
							"User clicks on apply selected successfully and able to see grid display filtered product with row count number in grid  "+count2+" with "+Report.color(pname)+" above the grid", "PASS");
					
				}
				else
				{
					System.out.println("failed to see filter apllied");
					Report.put("Click on button apply selected ",
							"Modal window should go off and product name selected should be displayed in the gird list with the filter by Modal window open ",
							"Failed to see filter applied", "Fail");
//					Assert.fail();
				}
				

				Report.put("Close the product name mark above the grid ",
						"My products should reset to the original view and display all the assets associated with account ",
						"User able to see clicking on x mark on product name filter grid is refreshed with original data with count of rows as "+count2, "PASS");
				
				
			}
			else
			{
				System.out.println("failed to see product name filter");
				Report.put("Click on the product name ",
						"Product name with search option and list of the product names associated with account should be displayed ",
						"failed to see product name filter", "Fail");

				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on the product name ",
					"Product name with search option and list of the product names associated with account should be displayed ",
					"failed to see product name filter", "Fail");
			Assert.fail();
		}
    }
    
    public void ClickOnServiceTag_Filter(WebDriver driver)
    {
    	Log.info("Inside ClickOnServiceTag_Filter method");

		String button = "";
		String header = "";
		String hide="";
		String labelList="";
		WebDriverWait wait = new WebDriverWait(driver, 240);
		try
		{

			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_EsupportMPSPage.ServiceTagNameFilterOption()))
			{
				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.RowsDisplayedInGrid());	
				List<WebElement> list2=driver.findElements(obj_EsupportMPSPage.RowsDisplayedInGrid());
				int count1=list2.size();
				System.out.println(count1);

				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.ServiceTagNameFilterOption());	
				String filter=CommonUtility.highlightElement(driver,obj_EsupportMPSPage.ServiceTagNameFilterOption()).getText();	
				System.out.println(filter);
				CommonUtility.ClickOn(driver,obj_EsupportMPSPage.ServiceTagNameFilterOption());	
				
				
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportMPSPage.ProductNameHeading()));
				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.ProductNameHeading());	
				header=CommonUtility.highlightElement(driver,obj_EsupportMPSPage.ProductNameHeading()).getText();	
				System.out.println(header);
				
				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.SearchTextBoxInProductName());
				
				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.ProductNameOptionsInFilterByPopUp());	
				List<WebElement> list=driver.findElements(obj_EsupportMPSPage.ProductNameOptionsInFilterByPopUp());

				for(WebElement lt:list)
				{
					CommonUtility.highlightElement(driver, lt);
					String label=lt.getText();

					System.out.println("product name is : " +label);
					labelList+=" <br> " + label;
				}
				System.out.println("product names displayed are:"+labelList);
				
				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.ResetSelectionButton());
				if(!(CommonUtility.highlightElement(driver,obj_EsupportMPSPage.ResetSelectionButton()).isEnabled()));
				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.ApplySelectedButton());
				if(!(CommonUtility.highlightElement(driver,obj_EsupportMPSPage.ApplySelectedButton()).isEnabled()));
				
				Report.put("Click on the product name ",
						"Product name with search option and list of the product names associated with account should be displayed ",
						"User clicks on "+Report.color(filter)+" with heading "+Report.color(header)+" and product options displayed "+Report.color(labelList), "PASS");

				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.ProductNameOptionsInFilterByPopUp());	
				List<WebElement> list1=driver.findElements(obj_EsupportMPSPage.ProductNameOptionsInFilterByPopUp());

				int count=0;
				for(int i=0; i<=list1.size(); i++)
				{
					count++;
					if(count==1)
					{
						CommonUtility.ScrollToWebElement(driver,list1.get(i));
						CommonUtility.ClickOnWebElement(driver,list1.get(i));
					}
					else
					{
						break;
					}
				}
				
				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.ResetSelectionButton());
				CommonUtility.highlightElement(driver,obj_EsupportMPSPage.ResetSelectionButton()).isEnabled();
				
				
				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.ApplySelectedButton());
				CommonUtility.highlightElement(driver,obj_EsupportMPSPage.ApplySelectedButton()).isEnabled();
				CommonUtility.ClickOn(driver,obj_EsupportMPSPage.ApplySelectedButton());
				
				
				Report.put("Select any product name check box ",
						"Reset selection and Apply selected buttons should be enabled ",
						"User able to select first option displayed and able to see apply selected and reset selection buttons enabled", "PASS");
				
				
				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.RowsDisplayedInGrid());	
				List<WebElement> list3=driver.findElements(obj_EsupportMPSPage.RowsDisplayedInGrid());
				int count2=list3.size();
				System.out.println(count2);
				
				Thread.sleep(6000);
				clickXButtonOnFilterPopUp(driver);
				Thread.sleep(6000);
				
				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.ServiceTagNameAboveGridAfterApplyingFilter());
				String pname=CommonUtility.highlightElement(driver,obj_EsupportMPSPage.ServiceTagNameAboveGridAfterApplyingFilter()).getText();
				System.out.println(pname);
				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.XButtonOFProductName());
				CommonUtility.ClickOn(driver,obj_EsupportMPSPage.XButtonOFProductName());
				
				if(count1>=count2)
				{
					Report.put("Click on button apply selected ",
							"Modal window should go off and product name selected should be displayed in the gird list with the filter by Modal window open ",
							"User clicks on apply selected successfully and able to see grid display filtered product with row count number in grid  "+count2+" with "+Report.color(pname)+" above the grid", "PASS");
					
				}
				else
				{
					System.out.println("failed to see filter apllied");
					Report.put("Click on button apply selected ",
							"Modal window should go off and product name selected should be displayed in the gird list with the filter by Modal window open ",
							"Failed to see filter applied", "Fail");
//					Assert.fail();
				}
				

				Report.put("Close the product name mark above the grid ",
						"My products should reset to the original view and display all the assets associated with account ",
						"User able to see clicking on x mark on product name filter grid is refreshed with original data with count of rows as "+count2, "PASS");
				
				
			}
			else
			{
				System.out.println("failed to see product name filter");
				Report.put("Click on the product name ",
						"Product name with search option and list of the product names associated with account should be displayed ",
						"failed to see product name filter", "Fail");

				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on the product name ",
					"Product name with search option and list of the product names associated with account should be displayed ",
					"failed to see product name filter", "Fail");
			Assert.fail();
		}
    }
    
    public void  clickMyAccount(WebDriver driver) 
	{
		System.out.println("Inside clickMyAccount method");
		Log.info("Inside clickMyAccount method");

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
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportMPSPage.MyAccountInSignInLabel()));
			CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.MyAccountInSignInLabel());
			//			CommonUtility.highlightElement(driver,obj_EsupportIPSHomePage.signInButton()).click();
			//CommonUtility.ClickOn(driver,obj_EsupportIPSHomePage.signInButton());
			CommonUtility.ToClickByUsingJavaScript_PassingByLoc(driver,obj_EsupportMPSPage.MyAccountInSignInLabel());
			System.out.println("Clicked on My Account In Button");

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportMPSPage.OverviewTab()));
			
			Thread.sleep(10000);
			Report.put("Click on My Account",
					"User should click on My Account", 
					"Clicked on MyAccount In successful", "PASS");

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on My Account",
					"User should click on My Account", 
					"Unable to click on MyAccount In successful", "Fail");
			Assert.fail();
		}
	}
    
    public void ChangeAccountTypeDropDown(WebDriver driver) 
	{
		System.out.println("Inside ChangeAccountTypeDropDown method");
		Log.info("Inside ChangeAccountTypeDropDown method");

		WebDriverWait  wait = new WebDriverWait(driver, 120);	
		try
		{
			Actions act=new Actions(driver);
			Thread.sleep(6000);
			CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.ChangeAccountDropDown());
			CommonUtility.highlightElement(driver, obj_EsupportMPSPage.ChangeAccountDropDown()).click();
			
			Thread.sleep(2000);
			CommonUtility.highlightElement(driver, obj_EsupportMPSPage.PremierAccountDropdownValue()).click();
			
			Thread.sleep(3000);
			
			System.out.println("Clicked on PremierAccountDropdownValue Button");

			Thread.sleep(10000);
			Report.put("Change account from Business to PremierAccount from DropdownValue",
					"User should able to change Business to PremierAccount", 
					"User successfully changed account from Business account to PremierAccount", "PASS");

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Change account from Business to PremierAccount from DropdownValue",
					"User should able to change Business to PremierAccount", 
					"User unable to change account from Business account to PremierAccount", "Fail");
			Assert.fail();
		}
	}

    public void ClickOnSupportHistory(WebDriver driver)
    {
    	System.out.println("Inside ClickOnSupportHistory method");
		Log.info("Inside ClickOnSupportHistory method");
		WebDriverWait wait = new WebDriverWait(driver, 240);
		try
		{
			Actions act=new Actions(driver);
			Thread.sleep(6000);
			CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.DellSupport());
			CommonUtility.highlightElement(driver, obj_EsupportMPSPage.DellSupport()).click();
			
			Thread.sleep(2000);
			CommonUtility.highlightElement(driver, obj_EsupportMPSPage.SupportHistory()).click();
			
			Thread.sleep(3000);
			
			System.out.println("Clicked on SupportHistory Button");

			Thread.sleep(10000);
			Report.put("Click on DellSupport and then click on Support History",
					"User should able to click on Support History", 
					"User successfully clicked on Support History", "PASS");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on DellSupport and then click on Support History",
					"User should able to click on Support History", 
					"User failed to click on Support History", "Fail");
			Assert.fail();
		}

    }

    public void VerifySupportHistoryPage(WebDriver driver)
    {
    	WebDriverWait wait = new WebDriverWait(driver, 600);
        System.out.println("Entered method VerifySupportHistoryPage");
        driver.manage().timeouts().implicitlyWait(600, TimeUnit.SECONDS);
        String accountType;
        String role;
        
        try
        {
        	if(CommonUtility.CheckpresenceofElementLocated(driver, 20, obj_EsupportMPSPage.AccountType()))
        	{
        		CommonUtility.ScrollTo(driver, obj_EsupportMPSPage.AccountType());
        		CommonUtility.highlightElement(driver, obj_EsupportMPSPage.AccountType());
        		accountType=driver.findElement(obj_EsupportMPSPage.PremierAccountDropdownValue()).getText();
        	    role=driver.findElement(obj_EsupportMPSPage.RoleAsSiteAdmin()).getText();
        	    
        	    Boolean result1=CommonUtility.highlightElement(driver, obj_EsupportMPSPage.AboutAccessRoles()).isDisplayed();
        	    Boolean result2=CommonUtility.highlightElement(driver, obj_EsupportMPSPage.SwitchToAnotherPremierAccount()).isDisplayed();
        	    Boolean result3=CommonUtility.highlightElement(driver, obj_EsupportMPSPage.AccessGroup()).isDisplayed();
        	    
        	    if(accountType.contains("Premier Account") && role.equals("SiteAdmin") && result1==true && result2==true && result3==true)
        	    {
        	    	System.out.println("AccountType text is --"+accountType);
        	    	System.out.println("Role is --"+role);
        	    	Report.put("User validate Verify Support History Page", 
        	    			"User should able to see AccountType as PremierAccount,AboutAccessRoles,SwitchToAnotherPremierAccount,AccessGroup & Role",
        	    			"User validated header text as "+Report.color(accountType)+" and Role as "+Report.color(role), "Pass");
        	    }
        	    else
        	    {
        	    	Report.put("User validate Verify Support History Page", 
        	    			"User should able to see AccountType as PremierAccount,AboutAccessRoles,SwitchToAnotherPremierAccount,AccessGroup & Role",
        	    			"User failed to validat header text and Role", "Fail");
        	    	Assert.fail();
        	    }
        	}
        }
        catch(Exception e)
        {
        	Report.put("User validate My Products and Services page", "User should able to see the header text and Role",
	    			"User failed to validat header text and Role", "Pass");
	    	Assert.fail();
        }
    }

    public void VerifyGridOfSupportHistory(WebDriver driver)
    {
    	System.out.println("Inside VerifyGridOfSupportHistory");
		WebDriverWait  wait = new WebDriverWait(driver, 120);
		Actions act=new Actions(driver);

		String labelList="";
		String faqList="";
		
		try
		{
			 if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_EsupportMPSPage.ListOfColumnNamesInSupportHistoryPage()))
			 {

					CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.ListOfColumnNamesInSupportHistoryPage());	
					List<WebElement> list=driver.findElements(obj_EsupportMPSPage.ListOfColumnNamesInSupportHistoryPage());

					for(WebElement lt:list)
					{
						CommonUtility.highlightElement(driver, lt);
						String label=lt.getText();

						System.out.println("column name is : " +label);
						labelList+=" <br> " + label;
					}
					System.out.println("column names are:"+labelList);


					Report.put("Verify the Grid Columns in Support History",
							"Grid page should display the columns",
							"User able to see Grid details with columns "+Report.color(labelList), "PASS");
                }
				else
				{
					System.out.println("not able to see grid details");
					Report.put("Verify the Grid Columns",
							"Grid page should display the columns",
							"Failed to see Grid details", "Fail");
					Assert.fail();
				}
			} 
			catch(Exception e)
			{
				e.printStackTrace();
				Report.put("Verify the Grid Columns",
						"Grid page should display the columns",
						"Failed to see Grid details", "Fail");
				Assert.fail();
			}
		}
	
    public void VerifyAdditionalDetailsOfAnyRowInSupportHistory(WebDriver driver)
    {
    	
    	Log.info("Inside clickOnExpandButtonOfFirstDisplayedRow method");

		String button = "";
		String header = "";
		String labelList1="";
		String labelList="";
		WebDriverWait wait = new WebDriverWait(driver, 240);
		try
		{

			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_EsupportMPSPage.FirstDisplayedExpandButton()))
			{

				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.FirstDisplayedExpandButton());	
				CommonUtility.ClickOn(driver,obj_EsupportMPSPage.FirstDisplayedExpandButton());	

				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.ImageInExpandedView());	

				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.HeadingsOfDisplayedFields());	
				List<WebElement> list=driver.findElements(obj_EsupportMPSPage.HeadingsOfDisplayedFields());

				for(WebElement lt:list)
				{
					CommonUtility.highlightElement(driver, lt);    
					String tabName=lt.getText();
					System.out.println("heading is: " +tabName);
					labelList+=" <br> " + tabName;
				}

				System.out.println("headings are:"+labelList);


				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.DetailsDisplayedUnderHeading());	
				List<WebElement> list1=driver.findElements(obj_EsupportMPSPage.DetailsDisplayedUnderHeading());

				for(WebElement lt:list1)
				{
					CommonUtility.highlightElement(driver, lt);    
					String tabName=lt.getText();
					System.out.println("details is: " +tabName);
					labelList1+=" <br> " + tabName;
				}

				System.out.println("details are:"+labelList1);


				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.ContractStatusDetails());
				String  contractdetail=CommonUtility.highlightElement(driver,obj_EsupportMPSPage.ContractStatusDetails()).getText();	
				System.out.println(contractdetail);
				
				CommonUtility.ScrollTo(driver,obj_EsupportMPSPage.ExtendOrUpgradeOrRenewLink());
				String  extend=CommonUtility.highlightElement(driver,obj_EsupportMPSPage.ExtendOrUpgradeOrRenewLink()).getText();	
				System.out.println(extend);

				

				Report.put("Go to any row and click on expand ( click on down arrow button)",
						"User should expand details  , and show the product image ,Product Type ,Shipped Date, Contract Status ",
						"User able to click on expand button and sees collapse button along with other details "+Report.color(labelList+" along with "+labelList1+" "+contractdetail)+" along with other links "+" links along with "+Report.color(extend)+" link", "PASS");

			}
			else
			{
				System.out.println("failed to see expand button");
				Report.put("Go to any row and click on expand ( click on down arrow button)",
						"User should expand details , and show the product image ,Product Type ,Shipped Date, Contract Status ",
						"failed to see expand button", "Fail");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Go to any row and click on expand ( click on down arrow button)",
					"User should expand details  , and show the product image ,Product Type ,Shipped Date, Contract Status and links Part & accessories , documentation and diagnostics ",
					"failed to see expand button", "Fail");
			Assert.fail();
		}
    	
    }
    
}
