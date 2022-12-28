package com.dell.delta_uat_automation.esupport.workflows;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.dell.delta_uat_automation.utility.CommonUtility;
import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.Log;
import com.dell.delta_uat_automation.utility.Report;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class EsupportRetailAssetWorkflow extends BaseFlow {

	public void homePage(WebDriver driver,String servicetag) {
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 120);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		boolean exists = true;


		System.out.println("Entering Esupport Retail Asset Transfer Page");
		Log.info("Entering Esupport Retail Asset Transfer Page");		
		try {


			CommonUtility.highlightElement(driver,obj_EsupportRetailAssetPage.delllogo()); 
			//CommonUtility.highlightElement(driver,obj_EsupportRetailAssetPage.declinecookies()).click();
			handleCookies(driver);

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportRetailAssetPage.registrationHeading()));
			CommonUtility.highlightElement(driver,obj_EsupportRetailAssetPage.registrationHeading());


			CommonUtility.highlightElement(driver,obj_EsupportRetailAssetPage.ownershipTransfer()).click();

			CommonUtility.highlightElement(driver,obj_EsupportRetailAssetPage.serviceTag()).sendKeys(servicetag);

			Report.put("Provide the service tag.", "Service tag should reflect in the service tag text box.",
					"Service tag is reflecting in the service tag text box", "PASS");


		} catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Provide the service tag.", "Service tag should reflect in the service tag text box.",
					"Service tag is not reflecting in the service tag text box", "FAIL");
			Assert.fail();
		}
	}
	public void clickOnContinue(WebDriver driver)
	{

		System.out.println("Click on Continue");
		Log.info("Click on Continue");

		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);
		//	CommonUtility.highlightElement(driver,obj_EsupportRetailAssetPage.scontinue()).sendKeys(Keys.ENTER);
			CommonUtility.ToClickByUsingJavaScript_PassingByLoc(driver, obj_EsupportRetailAssetPage.scontinue());


			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportRetailAssetPage.previousOwnerDetails()));
			CommonUtility.highlightElement(driver, obj_EsupportRetailAssetPage.previousOwnerDetails());

			Report.put("Enter the details and Click on submit ", "User should be able to see 'Previous owner details' page.",
					"User redirected to 'Previous owner details' page.", "PASS");


		} catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Enter the details and Click on submit ", "User should be able to see 'Previous owner details' page.",
					"User not redirected to 'Previous owner details' page.", "FAIL");
			Assert.fail();
		}
	}
	
	public void privacyStatement_IE(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 600);
		System.out.println("After webdriver wait");
		driver.manage().timeouts().implicitlyWait(600, TimeUnit.SECONDS);
		//             driver.manage().timeouts().pageLoadTimeout(600, TimeUnit.SECONDS);
		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportRetailAssetPage.DellPrivacyStatement()));
			CommonUtility.highlightElement(driver, obj_EsupportRetailAssetPage.DellPrivacyStatement()).click();
			Thread.sleep(5000);

			String currentWindow = driver.getWindowHandle();
			Set<String> allWH=driver.getWindowHandles();
			int n=allWH.size();
			System.out.println("count of windows is "+n);
			System.out.println(allWH);

			for(String wh:allWH)
			{
				Thread.sleep(5000);
				driver.switchTo().window(wh); 
				String title=driver.getTitle();
				System.out.println("Tittle displayed as : "+title);


				if(title.equalsIgnoreCase("Privacy Statement | Dell"))
				{
					System.out.println("inside  Privacy Statement | Dell:::::::::");
					String currentUrl = driver.getCurrentUrl();
					System.out.println("Current URl is  inside delllllllllll:::::: "+currentUrl);


					wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportRetailAssetPage.PrivacyStatement()));
					CommonUtility.scrollToViewElement(driver, obj_EsupportRetailAssetPage.PrivacyStatement());
					CommonUtility.highlightElement(driver, obj_EsupportRetailAssetPage.PrivacyStatement()).click();

					Thread.sleep(5000);
					wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportRetailAssetPage.PrivacyStatementHeader()));
					handleCookies(driver);


					wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportRetailAssetPage.Termsandconditions()));
					CommonUtility.scrollToViewElement(driver, obj_EsupportRetailAssetPage.Termsandconditions()); 
					CommonUtility.highlightElement(driver, obj_EsupportRetailAssetPage.Termsandconditions()); 
					CommonUtility.highlightElement(driver, obj_EsupportRetailAssetPage.Termsandconditions()).click();
					wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportRetailAssetPage.TermsandconditionsHeader()));


					String currentWindowone = driver.getWindowHandle();
					Set<String> allWHone=driver.getWindowHandles();
					int nnew=allWHone.size();
					System.out.println("count of windows is "+nnew);
					System.out.println(allWHone);

					for(String wh1:allWHone)
					{
						Thread.sleep(5000);
						driver.switchTo().window(wh1); 
						String title1=driver.getTitle();
						System.out.println("Tittle displayed as : after runnnnnnnn::::::: "+title1);
						if(title1.equalsIgnoreCase("Terms of Sale | Dell"))
						{
							System.out.println("inside  Privacy Statement | Dell:::::::::");
							String currentUrlone = driver.getCurrentUrl();
							System.out.println("Current URl is  inside delllllllllll::::::  currentUrlone "+currentUrlone);


							//wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportRetailAssetPage.PrivacyStatement()));

							driver.close();

							Thread.sleep(5000);
						}
					}
				}
			}       
			driver.switchTo().window(currentWindow);

			Thread.sleep(10000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportRetailAssetPage.RegisterButton()));
			CommonUtility.highlightElement(driver, obj_EsupportRetailAssetPage.RegisterButton()).click();

			Report.put("Check for Privacy statement link in every page and Terms & Conditions link",
					"All links should work fine",
					"All links works fine", "PASS");
			Report.put("Fill all the options and click on Register ", 
					"The service tag should be registered successfully.",
					"The service tag registeres successfully.", "PASS");

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Check for Privacy statement link in every page and Terms & Conditions link",
					"All links should work fine",
					"All links does not work fine", "FAIL");
			Report.put("Fill all the options and click on Register ", 
					"The service tag should be registered successfully.",
					"The service tag does not register successfully.", "FAIL");
			Assert.fail();
		}

	}
	public void selectIntendedUse(WebDriver driver, String option)
	{

		System.out.println("Inside selectIntendedUse");
		Log.info("Inside selectIntendedUse");

		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);
			//CommonUtility.highlightElement(driver,obj_EsupportRetailAssetPage.intendedUseDropdown()).click();
			CommonUtility.ToClickByUsingJavaScript_PassingByLoc(driver, obj_EsupportRetailAssetPage.intendedUseDropdown());

			Select selAction = new  Select(driver.findElement(obj_EsupportRetailAssetPage.intendedUseDropdown()));

			if(option.contains("Home"))
			{
				selAction.selectByVisibleText("Home"); 
				System.out.println(option);
			}
		} catch(Exception e)
		{
			e.printStackTrace();
			Assert.fail();
		}
	}
	public void PreviousOwnerDetails(WebDriver driver,String cname, String fname,String lname, String email, String address, String city, String zip, String phone, String option,boolean flag)
    {

          System.out.println("Entering Previous Owner Details");
          Log.info("Entering Previous Owner Details");

          try
          {
                 WebDriverWait wait = new WebDriverWait(driver, 120);
                 if(CommonUtility.CheckpresenceofElementLocated(driver, 30, obj_EsupportRetailAssetPage.companyName()))
                 CommonUtility.highlightElement(driver,obj_EsupportRetailAssetPage.companyName()).sendKeys(cname); 
          //CommonUtility.highlightElement(driver,obj_EsupportRetailAssetPage.companyName()).sendKeys(cname);
          CommonUtility.highlightElement(driver,obj_EsupportRetailAssetPage.firstName()).sendKeys(fname);

          CommonUtility.highlightElement(driver,obj_EsupportRetailAssetPage.lastName()).sendKeys(lname);
          CommonUtility.highlightElement(driver,obj_EsupportRetailAssetPage.email()).sendKeys(email);
          CommonUtility.highlightElement(driver,obj_EsupportRetailAssetPage.streetAddress()).sendKeys(address);
          CommonUtility.highlightElement(driver,obj_EsupportRetailAssetPage.city()).sendKeys(city);
          driver.findElement(obj_EsupportRetailAssetPage.stateDropdown()).click();

                 if(flag)
                 {

                       Select selAction = new  Select(driver.findElement(obj_EsupportRetailAssetPage.stateDropdown()));

                       if(option.contains("Karnataka"))
                       {
                              selAction.selectByVisibleText("Karnataka"); 
                              System.out.println(option);
                       }
                 } 




          CommonUtility.highlightElement(driver,obj_EsupportRetailAssetPage.zip()).sendKeys(zip);
          CommonUtility.highlightElement(driver,obj_EsupportRetailAssetPage.phone()).sendKeys(phone);

          CommonUtility.highlightElement(driver,obj_EsupportRetailAssetPage.previousOwnerContinue()).click();


          wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportRetailAssetPage.newOwnerLabel()));
                 CommonUtility.highlightElement(driver, obj_EsupportRetailAssetPage.newOwnerLabel());

                 Report.put("Provide all the relevant details of the Previous Owner in the text fields anc click Continue button. ", "It should navigate to New Owner Details page.",
                              "User redirected to 'New Owner Details' page.", "PASS");


          } catch(Exception e)
          {
                 e.printStackTrace();
                 Report.put("Provide all the relevant details of the Previous Owner in the text fields anc click Continue button. ", "It should navigate to New Owner Details page.",
                              "User not redirected to 'New Owner Details' page.", "FAIL");
                 Assert.fail();
          }
    }

    public void NewOwnerDetails(WebDriver driver,String cname, String fname,String lname, String email, String address, String city, String zip, String phone, String option,String Country )
    {

          System.out.println("Entering Previous Owner Details");
          Log.info("Entering Previous Owner Details");

          try
          {
                 WebDriverWait wait = new WebDriverWait(driver, 120);


          CommonUtility.highlightElement(driver,obj_EsupportRetailAssetPage.firstName()).sendKeys(fname);

          CommonUtility.highlightElement(driver,obj_EsupportRetailAssetPage.newOwnerLastName()).sendKeys(lname);
          CommonUtility.highlightElement(driver,obj_EsupportRetailAssetPage.email()).sendKeys(email);
          CommonUtility.highlightElement(driver,obj_EsupportRetailAssetPage.streetAddress()).sendKeys(address);
          CommonUtility.highlightElement(driver,obj_EsupportRetailAssetPage.city()).sendKeys(city);
          driver.findElement(obj_EsupportRetailAssetPage.stateDropdown()).click();
                 Select countrySel =new Select(driver.findElement(obj_EsupportRetailAssetPage.countryDropdown())); 

                 
                 String tag = TestNGCreator.TestData.get(Esupport.TestCaseID.ordinal());
             System.out.println("Testcase Id is "+tag);
             
            // if(tag.equals("5773037"))
         //    {
             countrySel.selectByVisibleText(Country); 
            // }

                 //countrySel.selectByVisibleText(Country); 

                 Select selAction = new  Select(driver.findElement(obj_EsupportRetailAssetPage.stateDropdown()));

                 if(option.contains("Karnataka"))
                 {
                        selAction.selectByVisibleText("Karnataka"); 
                       System.out.println(option);
                 }


          CommonUtility.highlightElement(driver,obj_EsupportRetailAssetPage.zip()).sendKeys(zip);
          CommonUtility.highlightElement(driver,obj_EsupportRetailAssetPage.phone()).sendKeys(phone);


                 Select Country1 =new Select(driver.findElement(obj_EsupportRetailAssetPage.countryDropdown())); 
                 WebElement Countryoptions=Country1.getFirstSelectedOption();
                 String defaultCountry=Countryoptions.getText();
                 System.out.println(defaultCountry); 

                 if(defaultCountry.equalsIgnoreCase("India"))
                 {
                       System.out.println("Done");
                 if(CommonUtility.highlightElement(driver,obj_EsupportRetailAssetPage.gstIdLabel()).isDisplayed())
                       {
                              System.out.println("GST code of the state should auto populate in the GST Code field");
                              Report.put("Provide all relevant details of the new Owner in relevant text boxes.If the Country selected for New Owner is India, A new field GST ID should appear at the bottom.Click Continue Button.",
                                           "user should be able to see the text boxes to fill the new owner details.When the Country selected is India, Upon selecting State, the GST code of the state should auto populate in the GST Code field.",
                                           "GST code of the state is auto populated in the GST Code field.", "PASS");
                              // CommonUtility.highlightElement(driver,obj_EsupportRetailAssetPage.previousOwnerContinue()).click();

                       }
                       else
                       {
                              Report.put("Provide all relevant details of the new Owner in relevant text boxes.If the Country selected for New Owner is India, A new field GST ID should appear at the bottom.Click Continue Button.",
                                           "user should be able to see the text boxes to fill the new owner details.When the Country selected is India, Upon selecting State, the GST code of the state should auto populate in the GST Code field.",
                                           "GST code of the state is not auto populated in the GST Code field.", "FAIL");
                       }
                 }
          CommonUtility.highlightElement(driver,obj_EsupportRetailAssetPage.previousOwnerContinue()).click();
                 Thread.sleep(2000);


                 //if(tag.equals("5773037"))
          //   {
                        if(CommonUtility.CheckpresenceofElementLocated(driver, 30, obj_EsupportRetailAssetPage.popupContinue()))
                       CommonUtility.highlightElement(driver,obj_EsupportRetailAssetPage.popupContinue()).click();  
            // }

          wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportRetailAssetPage.warrantyLabel()));
                 CommonUtility.highlightElement(driver, obj_EsupportRetailAssetPage.warrantyLabel());




          } catch(Exception e)
          {
                 e.printStackTrace();
                 Report.put("Provide all relevant details of the new Owner in relevant text boxes.If the Country selected for New Owner is India, A new field GST ID should appear at the bottom.Click Continue Button.",
                              "user should be able to see the text boxes to fill the new owner details.When the Country selected is India, Upon selecting State, the GST code of the state should auto populate in the GST Code field.",
                              "GST code of the state is not auto populated in the GST Code field.", "FAIL");
                 Assert.fail();
          }
    }

	public void VerifyOwnerdetails(WebDriver driver)
	{

		System.out.println("Verify Owner details");
		Log.info("Verify Owner details");

		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);
			CommonUtility.highlightElement(driver,obj_EsupportRetailAssetPage.editNewOwnerLink()).click();

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportRetailAssetPage.newOwnerLabel()));
			CommonUtility.highlightElement(driver, obj_EsupportRetailAssetPage.newOwnerLabel());

			driver.navigate().back();

			CommonUtility.highlightElement(driver,obj_EsupportRetailAssetPage.editPreviousOwnerLink()).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportRetailAssetPage.previousOwnerDetails()));
			CommonUtility.highlightElement(driver, obj_EsupportRetailAssetPage.previousOwnerDetails());


			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportRetailAssetPage.previousOwnerDetails()));
			CommonUtility.highlightElement(driver, obj_EsupportRetailAssetPage.previousOwnerDetails());

			driver.navigate().back();

			Report.put("Verify the details of the Previouse Owner and New Owner details entered.Click Edit link of Previous Owner.Clicke Edit link of New Owner",
					"The details of the Previous and New owner should match the details entered.It should navigate to Previous Owner details page.It should navigate to New Owner details page","Details of the Previous and New owner is matching with the details entered", "PASS");


		} catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify the details of the Previouse Owner and New Owner details entered.Click Edit link of Previous Owner.Clicke Edit link of New Owner",
					"The details of the Previous and New owner should match the details entered.It should navigate to Previous Owner details page.It should navigate to New Owner details page","Details of the Previous and New owner is not  matching with the details entered", "FAIL");
			Assert.fail();
		}
	}
	public void clickOnFinalsContinue(WebDriver driver)
	{

		System.out.println("Click on Continue");
		Log.info("Click on Continue");

		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);
			CommonUtility.highlightElement(driver,obj_EsupportRetailAssetPage.agreementCheckbox()).click();

			CommonUtility.highlightElement(driver,obj_EsupportRetailAssetPage.finalcontinue()).click();

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportRetailAssetPage.successMessageLabel()));
			CommonUtility.highlightElement(driver, obj_EsupportRetailAssetPage.successMessageLabel());

			Report.put("Review the details and click on Continue button.", "User should get Ownership Transfer acknowledgement.",
					"User redirected to 'Ownership Transfer acknowledgement' page.", "PASS");


		} catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Review the details and click on Continue button.", "User should get Ownership Transfer acknowledgement.",
					"User not redirected to 'Ownership Transfer acknowledgement' page.", "FAIL");

			Assert.fail();
		}
	}
	//sneha
	public void retailContinue(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 600);
		System.out.println("After webdriver wait");
		driver.manage().timeouts().implicitlyWait(600, TimeUnit.SECONDS);
		//             driver.manage().timeouts().pageLoadTimeout(600, TimeUnit.SECONDS);
		try
		{
			System.out.println("In retailContinue method");
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportRetailAssetPage.scontinue()));
			CommonUtility.highlightElement(driver, obj_EsupportRetailAssetPage.scontinue()).click();
			Thread.sleep(3000);
			try{
				wait = new WebDriverWait(driver, 20);
				System.out.println("After webdriver wait");
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportRetailAssetPage.ErrorServiceTag()));
				CommonUtility.highlightElement(driver, obj_EsupportRetailAssetPage.ErrorServiceTag());
				//Report.put("Click on Other Lookup Options", "Other look up Options Pop Up should show",
				//                           "Other look up Options Pop Up display failed", "FAIL");
				//Assert.fail();
			}
			catch(Exception exp)
			{


			}
			wait = new WebDriverWait(driver, 600);
			System.out.println("After webdriver wait");
			driver.manage().timeouts().implicitlyWait(600, TimeUnit.SECONDS);
			Report.put("Check for the Continue button.", "Continue button should be enabled.",
					"Continue button is enabled.", "PASS");

			Report.put("Click on Continue button.", "User should be navigated to Registration Information page.",
					"User navigates to Registration Information page.", "PASS");

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Check for the Continue button.", "Continue button should be enabled.",
					"Continue button is not enabled.", "FAIL");

			Report.put("Click on Continue button.", "User should be navigated to Registration Information page.",
					"User does not navigate to Registration Information page.", "FAIL");
			Assert.fail();
		}

	}
	public void retailInformation(WebDriver driver,String FirstName,String LastName,String Email,String StreetAddress,String Optional,String City,String ZipCode,String AreaCode,String PhoneNumber)
	{
		WebDriverWait wait = new WebDriverWait(driver, 600);
		System.out.println("After webdriver wait");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportRetailAssetPage.RegistrationInformationHeading()));
			CommonUtility.highlightElement(driver,obj_EsupportRetailAssetPage.RegistrationInformationHeading());

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportRetailAssetPage.CountrySelect()));
			CommonUtility.highlightElement(driver,obj_EsupportRetailAssetPage.CountrySelect());
			Thread.sleep(2000);

			List<WebElement> elements = driver.findElements(obj_EsupportRetailAssetPage.CountrySelectDropdown());

			for (int i = 1; i < elements.size(); i++) {
				String Account=elements.get(i).getText();
				CommonUtility.highlightElement(driver,elements.get(i));
				System.out.println(Account); 
				if(Account.equalsIgnoreCase("India"))
				{

					CommonUtility.highlightElement(driver, elements.get(i)).click();
					break;
				}
			}
			Thread.sleep(5000);
			CommonUtility.scrollToViewElement(driver, obj_EsupportRetailAssetPage.GstidLabel());
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportRetailAssetPage.GstidLabel()));
			CommonUtility.highlightElement(driver,obj_EsupportRetailAssetPage.GstidLabel()).isDisplayed();

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportRetailAssetPage.FirstNameInput()));
			CommonUtility.highlightElement(driver,obj_EsupportRetailAssetPage.FirstNameInput()).sendKeys(FirstName);


			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportRetailAssetPage.LastNameInput()));
			CommonUtility.highlightElement(driver,obj_EsupportRetailAssetPage.LastNameInput()).sendKeys(LastName);


			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportRetailAssetPage.EmailInput()));
			CommonUtility.highlightElement(driver,obj_EsupportRetailAssetPage.EmailInput()).sendKeys(Email);


			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportRetailAssetPage.StreetAddressInput()));
			CommonUtility.highlightElement(driver,obj_EsupportRetailAssetPage.StreetAddressInput()).sendKeys(StreetAddress);


			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportRetailAssetPage.OptionalAddressInput()));
			CommonUtility.highlightElement(driver,obj_EsupportRetailAssetPage.OptionalAddressInput()).sendKeys(Optional);

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportRetailAssetPage.StateSelect()));
			CommonUtility.highlightElement(driver,obj_EsupportRetailAssetPage.StateSelect());
			Thread.sleep(2000);

			List<WebElement> elements1 = driver.findElements(obj_EsupportRetailAssetPage.StateSelectDropdown());

			for (int i = 1; i < elements1.size(); i++) {
				String Account=elements1.get(i).getText();
				CommonUtility.highlightElement(driver,elements1.get(i));
				System.out.println(Account); 
				if(Account.equalsIgnoreCase("Karnataka"))
				{

					CommonUtility.highlightElement(driver, elements1.get(i)).click();
					break;
				}
			}
			Thread.sleep(5000);

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportRetailAssetPage.CityInput()));
			CommonUtility.highlightElement(driver,obj_EsupportRetailAssetPage.CityInput()).sendKeys(City);

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportRetailAssetPage.ZipCodeInput()));
			CommonUtility.highlightElement(driver,obj_EsupportRetailAssetPage.ZipCodeInput()).sendKeys(ZipCode);

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportRetailAssetPage.AreaCodeInput()));
			CommonUtility.highlightElement(driver,obj_EsupportRetailAssetPage.AreaCodeInput()).sendKeys(AreaCode);

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportRetailAssetPage.PhoneNumberInput()));
			CommonUtility.highlightElement(driver,obj_EsupportRetailAssetPage.PhoneNumberInput()).sendKeys(PhoneNumber);


			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportRetailAssetPage.AgreementClick()));
			CommonUtility.highlightElement(driver,obj_EsupportRetailAssetPage.AgreementClick()).click();

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportRetailAssetPage.RegistrationInformationContinue()));
			CommonUtility.highlightElement(driver,obj_EsupportRetailAssetPage.RegistrationInformationContinue()).click();

			Report.put("Fill all the relevant details in the text boxes.Select State after setting the Country to India",
					"Selecting State from the dropdown when India is selected, should auto populate GST ID of the state.",
					"Selecting State from the dropdown when India is selected, auto populates GST ID of the state.", "PASS");

			Report.put("Click Continue button afer filling the relevant details.", "Clicking Continue button should navigate to Additional Information page.",
					"Clicking Continue button should navigate to Additional Information page.", "PASS");


		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Fill all the relevant details in the text boxes.Select State after setting the Country to India",
					"Selecting State from the dropdown when India is selected, should auto populate GST ID of the state.",
					"Selecting State from the dropdown when India is selected, does not auto populate GST ID of the state.", "FAIL");

			Report.put("Click Continue button afer filling the relevant details.", "Clicking Continue button should navigate to Additional Information page.",
					"Clicking Continue button does not navigate to Additional Information page.", "FAIL");
			Assert.fail();
		}

	}

	public void addressVerification(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 600);
		System.out.println("After webdriver wait");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		try
		{
			String Country="";
			String State="";
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportRetailAssetPage.RadioButtonClick()));
			CommonUtility.highlightElement(driver, obj_EsupportRetailAssetPage.RadioButtonClick()).click();

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportRetailAssetPage.SelectAddressButton()));
			CommonUtility.highlightElement(driver, obj_EsupportRetailAssetPage.SelectAddressButton()).click();

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportRetailAssetPage.AdditionalInformationTag()));
			CommonUtility.highlightElement(driver, obj_EsupportRetailAssetPage.AdditionalInformationTag());

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportRetailAssetPage.ExtendedServicePlan()));
			CommonUtility.highlightElement(driver, obj_EsupportRetailAssetPage.ExtendedServicePlan());

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportRetailAssetPage.ContactVisibility()));
			CommonUtility.highlightElement(driver, obj_EsupportRetailAssetPage.ContactVisibility());


			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportRetailAssetPage.PreviousButton()));
		//	CommonUtility.highlightElement(driver, obj_EsupportRetailAssetPage.PreviousButton()).click();
			CommonUtility.ToClickByUsingJavaScript_PassingByLoc(driver, obj_EsupportRetailAssetPage.PreviousButton());


			Select sele =new Select(CommonUtility.highlightElement(driver, obj_EsupportRetailAssetPage.CountrySelect()));           
			WebElement options=sele.getFirstSelectedOption();
			String defaultItem=options.getText();

			System.out.println(defaultItem); 
			if(defaultItem.equalsIgnoreCase("India"))
			{
				Country="country value is retained";
			}

			String FirstNameInput=CommonUtility.highlightElement(driver, obj_EsupportRetailAssetPage.FirstNameInput()).getAttribute("value");
			if(FirstNameInput.equalsIgnoreCase(TestNGCreator.TestData.get(Esupport.FirstName.ordinal())))
			{
				FirstNameInput="FirstName value is retained";
			}
			String LastNameInput=CommonUtility.highlightElement(driver, obj_EsupportRetailAssetPage.LastNameInput()).getAttribute("value");
			if(LastNameInput.equalsIgnoreCase(TestNGCreator.TestData.get(Esupport.LastName.ordinal())))
			{
				LastNameInput="LastName value is retained";
			}
			String EmailInput=CommonUtility.highlightElement(driver, obj_EsupportRetailAssetPage.EmailInput()).getAttribute("value");
			if(EmailInput.equalsIgnoreCase(TestNGCreator.TestData.get(Esupport.Email.ordinal())))
			{
				EmailInput="Email value is retained";
			}
			String StreetAddressInput=CommonUtility.highlightElement(driver, obj_EsupportRetailAssetPage.StreetAddressInput()).getAttribute("value");
			if(StreetAddressInput.equalsIgnoreCase(TestNGCreator.TestData.get(Esupport.StreetAddress.ordinal())))
			{
				StreetAddressInput="StreetAddress value is retained";
			}
			String OptionalAddressInput=CommonUtility.highlightElement(driver, obj_EsupportRetailAssetPage.OptionalAddressInput()).getAttribute("value");
			if(OptionalAddressInput.equalsIgnoreCase(TestNGCreator.TestData.get(Esupport.Optional.ordinal())))
			{
				OptionalAddressInput="Optional value is retained";
			}

			Select sele1 =new Select(CommonUtility.highlightElement(driver, obj_EsupportRetailAssetPage.StateSelect()));           
			WebElement options1=sele.getFirstSelectedOption();
			String defaultItem1=options.getText();

			System.out.println(defaultItem1); 
			if(defaultItem1.equalsIgnoreCase("Karnataka"))
			{
				State="State value is retained";
			}


			String CityInput=CommonUtility.highlightElement(driver, obj_EsupportRetailAssetPage.CityInput()).getAttribute("value");
			if(CityInput.equalsIgnoreCase(TestNGCreator.TestData.get(Esupport.City.ordinal())))
			{
				CityInput="City value is retained";
			}
			String ZipCodeInput=CommonUtility.highlightElement(driver, obj_EsupportRetailAssetPage.ZipCodeInput()).getAttribute("value");
			if(ZipCodeInput.equalsIgnoreCase(TestNGCreator.TestData.get(Esupport.PostalCode.ordinal())))
			{
				ZipCodeInput="ZipCode value is retained";
			}
			String AreaCodeInput=CommonUtility.highlightElement(driver, obj_EsupportRetailAssetPage.AreaCodeInput()).getAttribute("value");
			if(AreaCodeInput.equalsIgnoreCase(TestNGCreator.TestData.get(Esupport.AreaCode.ordinal())))
			{
				AreaCodeInput="AreaCode value is retained";
			}
			String PhoneNumberInput=CommonUtility.highlightElement(driver, obj_EsupportRetailAssetPage.PhoneNumberInput()).getAttribute("value");
			if(PhoneNumberInput.equalsIgnoreCase(TestNGCreator.TestData.get(Esupport.PhoneNumber.ordinal())))
			{
				PhoneNumberInput="PhoneNumber value is retained";
			}
			String GstidInput=CommonUtility.highlightElement(driver, obj_EsupportRetailAssetPage.GstidInput()).getAttribute("value");
			if(!(GstidInput.equals("")))
			{
				GstidInput="Gstid value is retained";
			}



			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportRetailAssetPage.AgreementClick()));
			CommonUtility.highlightElement(driver, obj_EsupportRetailAssetPage.AgreementClick()).click();

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportRetailAssetPage.RegistrationInformationContinue()));
			CommonUtility.highlightElement(driver, obj_EsupportRetailAssetPage.RegistrationInformationContinue()).click();

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportRetailAssetPage.RadioButtonClick()));
			CommonUtility.highlightElement(driver, obj_EsupportRetailAssetPage.RadioButtonClick()).click();

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportRetailAssetPage.SelectAddressButton()));
			CommonUtility.highlightElement(driver, obj_EsupportRetailAssetPage.SelectAddressButton()).click();

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportRetailAssetPage.AdditionalInformationTag()));
			CommonUtility.highlightElement(driver, obj_EsupportRetailAssetPage.AdditionalInformationTag());
			Report.put("Check Address verification system",
					"Address verification system should popup with suggestions in the address",
					"Address verification system should popup with suggestions in the address", "PASS");
			Report.put("Check for the options in the page.Did you purchase Extended Service Plan, and contact info confirmation fields should be present.", 
					"All the options should be available as per screenshot.",
					"All the options is available as per screenshot.", "PASS");

			Report.put("Click Previous Button", 
					"Clicking Previous button should retain all the details entered by the Uer in all the pages",
					"Clicking Previous button retains all the details entered by the Uer in all the pages", "PASS");

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Check Address verification system",
					"Address verification system should popup with suggestions in the address",
					"Address verification system does not popup with suggestions in the address", "FAIL");
			Report.put("Check for the options in the page.Did you purchase Extended Service Plan, and contact info confirmation fields should be present.", 
					"All the options should be available as per screenshot.",
					"All the options is not  available as per screenshot.", "FAIL");
			Report.put("Click Previous Button", 
					"Clicking Previous button should retain all the details entered by the Uer in all the pages",
					"Clicking Previous button does not retain all the details entered by the Uer in all the pages", "FAIL");
			Assert.fail();
		}

	}

	public void privacyStatement(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 600);
		System.out.println("After webdriver wait");
		driver.manage().timeouts().implicitlyWait(600, TimeUnit.SECONDS);
		//             driver.manage().timeouts().pageLoadTimeout(600, TimeUnit.SECONDS);
		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportRetailAssetPage.DellPrivacyStatement()));
			CommonUtility.highlightElement(driver, obj_EsupportRetailAssetPage.DellPrivacyStatement()).click();
			Thread.sleep(5000);
			Set<String> windows=driver.getWindowHandles();
			System.out.println(windows);
			for (String s : windows ){
				driver.switchTo().window(s);
			}
			Thread.sleep(25000);

			CommonUtility.scrollToViewElement(driver, obj_EsupportRetailAssetPage.PrivacyStatement());
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportRetailAssetPage.PrivacyStatement()));
			CommonUtility.highlightElement(driver, obj_EsupportRetailAssetPage.PrivacyStatement()).click();

			Thread.sleep(5000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportRetailAssetPage.PrivacyStatementHeader()));
			handleCookies(driver);

			CommonUtility.scrollToViewElement(driver, obj_EsupportRetailAssetPage.Termsandconditions()); 
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportRetailAssetPage.Termsandconditions()));
			CommonUtility.highlightElement(driver, obj_EsupportRetailAssetPage.Termsandconditions()).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportRetailAssetPage.TermsandconditionsHeader()));
			driver.close();
			Set<String> windows1=driver.getWindowHandles();
			for (String s : windows1 ){
				driver.switchTo().window(s);
			}
			Thread.sleep(5000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportRetailAssetPage.RegisterButton()));
			CommonUtility.highlightElement(driver, obj_EsupportRetailAssetPage.RegisterButton()).click();

			Report.put("Check for Privacy statement link in every page and Terms & Conditions link",
					"All links should work fine",
					"All links works fine", "PASS");
			Report.put("Fill all the options and click on Register ", 
					"The service tag should be registered successfully.",
					"The service tag registeres successfully.", "PASS");




		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Check for Privacy statement link in every page and Terms & Conditions link",
					"All links should work fine",
					"All links does not work fine", "FAIL");
			Report.put("Fill all the options and click on Register ", 
					"The service tag should be registered successfully.",
					"The service tag does not register successfully.", "FAIL");
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
//			if(CommonUtility.CheckpresenceofElementLocated(driver, 30, obj_EsupportOrderHomePage.declinecookies()))
//				CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.declinecookies()).click(); else
			if(CommonUtility.CheckpresenceofElementLocated(driver, 30, obj_EsupportOrderHomePage.AcceptCookies()))
			{
				CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.AcceptCookies()).click(); 
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


	public void homePage_ServiceTag(WebDriver driver,String servicetag) {
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 120);
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
//		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		boolean exists = true;


		System.out.println("Entering Esupport Retail Asset Transfer Page");
		Log.info("Entering Esupport Retail Asset Transfer Page");             
		try {

			System.out.println("Driver URL----->"+driver.getCurrentUrl());
			CommonUtility.highlightElement(driver,obj_EsupportRetailAssetPage.delllogo()); 
			//CommonUtility.highlightElement(driver,obj_EsupportRetailAssetPage.declinecookies()).click();


			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportRetailAssetPage.registrationHeading()));
			CommonUtility.highlightElement(driver,obj_EsupportRetailAssetPage.registrationHeading());
			
			handleCookies(driver);
			
//			CommonUtility.ScrollTo(driver,obj_EsupportRetailAssetPage.ServiceTagInput());
//
//			CommonUtility.ClickOn(driver,obj_EsupportRetailAssetPage.ServiceTagInput());
//			CommonUtility.highlightElement(driver,obj_EsupportRetailAssetPage.ServiceTagInput()).sendKeys(servicetag);


			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportRetailAssetPage.SelectIntendedUse()));
			CommonUtility.scrollToViewElement(driver,obj_EsupportRetailAssetPage.SelectIntendedUse());
			CommonUtility.ToClickByUsingJavaScript_PassingByLoc(driver, obj_EsupportRetailAssetPage.SelectIntendedUse());
			Thread.sleep(2000);
			handleCookies(driver);

			List<WebElement> elements = driver.findElements(obj_EsupportRetailAssetPage.SelectIntendedUseDropdown());
			for (int i = 1; i < elements.size(); i++) {
				String Account=elements.get(i).getText();
				CommonUtility.highlightElement(driver,elements.get(i));
				System.out.println(Account); 
				if(Account.contains("Home"))
				{

					CommonUtility.highlightElement(driver, elements.get(i)).click();
					break;
				}
			}
			Thread.sleep(5000);

			Report.put("Provide the service tag.", "Service tag should reflect in the service tag text box.",
					"Service tag is reflecting in the service tag text box", "PASS");

			Report.put("Select Intended use from the dropdown.", "After selecting an option from Intended Use dropdown, the Continue button should get enabled.",
					"After selecting an option from Intended Use dropdown, the Continue button gets enabled.", "PASS");




		} catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Provide the service tag.", "Service tag should reflect in the service tag text box.",
					"Service tag is not reflecting in the service tag text box", "FAIL");
			Report.put("Select Intended use from the dropdown.", "After selecting an option from Intended Use dropdown, the Continue button should get enabled.",
					"After selecting an option from Intended Use dropdown, the Continue button does not get enabled.", "FAIL");


			Assert.fail();
		}
	}
	//pushpa
	public void clickOwnershipTransfer(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 120);
		driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
		//driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

		System.out.println("Entering Esupport Retail Asset Transfer Page");
		Log.info("Entering Esupport Retail Asset Transfer Page");

		try
		{
			CommonUtility.highlightElement(driver,obj_EsupportRetailAssetPage.delllogo()); 
			//handleCookies(driver);
//			try
//			{
//				CommonUtility.highlightElement(driver,obj_EsupportRetailAssetPage.declinecookies()).click();
//			}
//			catch(Exception e1)
//			{
//				e1.printStackTrace();
//			}
			CommonUtility.highlightElement(driver,obj_EsupportRetailAssetPage.registrationHeading());


			CommonUtility.ScrollTo(driver,obj_EsupportRetailAssetPage.ownershipTransfer());
			CommonUtility.ClickOn(driver,obj_EsupportRetailAssetPage.ownershipTransfer());
//			String mainwindow=driver.getWindowHandle();
//			Set<String> set=driver.getWindowHandles();
//			int count=set.size();
//			System.out.println("window count is "+count);
//			Iterator<String> itr=set.iterator();
//			while(itr.hasNext())
//			{
//				String childWindow=itr.next();
//				if(!mainwindow.equals(childWindow))
//				{
//					Thread.sleep(6000);
//					driver.switchTo().window(childWindow);
//					Thread.sleep(6000);
//				String title=driver.getTitle();
//				System.out.println(title);
//				
//				if(title.contains("Ownership"))
//				{
//				validateElementsDisplayed(driver);
//				
//				handleCookies(driver);
//				clickMutlipleRadioButton(driver);
//				handleCookies(driver);
//				enterTag1(driver, TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(",")[0]);
//				enterTag2(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(",")[1]);
//				enterTag3(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(",")[2]);
//				enterTag4(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(",")[3]);
//				enterTag5(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(",")[4]);
//				checkAddAnotherButton(driver);
//				handleCookies(driver);
//				clickOnContinue(driver);
//				validatePrivacyStatementLink(driver);
//				handleCookies(driver);
//				PreviousOwnerDetails(driver,TestNGCreator.TestData.get(Esupport.CompanyName.ordinal()),TestNGCreator.TestData.get(Esupport.FirstName.ordinal()),TestNGCreator.TestData.get(Esupport.LastName.ordinal()),TestNGCreator.TestData.get(Esupport.Email.ordinal()), 
//						TestNGCreator.TestData.get(Esupport.StreetAddress.ordinal()),TestNGCreator.TestData.get(Esupport.City.ordinal()),TestNGCreator.TestData.get(Esupport.PostalCode.ordinal()),TestNGCreator.TestData.get(Esupport.PhoneNumber.ordinal()),TestNGCreator.TestData.get(Esupport.State.ordinal()),false);
//				selectIntendedUse(driver,"Home");
//				NewOwnerDetails(driver,TestNGCreator.TestData.get(Esupport.CompanyName.ordinal()),TestNGCreator.TestData.get(Esupport.FirstName.ordinal()),TestNGCreator.TestData.get(Esupport.LastName.ordinal()),TestNGCreator.TestData.get(Esupport.Email.ordinal()), 
//						TestNGCreator.TestData.get(Esupport.StreetAddress.ordinal()),TestNGCreator.TestData.get(Esupport.City.ordinal()),TestNGCreator.TestData.get(Esupport.PostalCode.ordinal()),TestNGCreator.TestData.get(Esupport.PhoneNumber.ordinal()), TestNGCreator.TestData.get(Esupport.State.ordinal()),TestNGCreator.TestData.get(Esupport.Country.ordinal()));
//				VerifyOwnerdetails(driver);
//				clickOnFinalsContinue(driver);
//				
//				
//				}
//				Thread.sleep(6000);
//				driver.close();
//				Thread.sleep(6000);
//				}
//
//				System.out.println("Parent window handle is "+mainwindow);
//				driver.switchTo().window(mainwindow);

//			}

			Report.put("Navigate to Ownership Transfer Page", "User should be able to see Warranty and Ownership Transfer page",
					"Navigated to Ownership Transfer Page successfully", "PASS");

		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Navigate to Ownership Transfer Page", "User should be able to see Warranty and Ownership Transfer page",
					"Navigation to Ownership Transfer Page failed", "FAIL");
			Assert.fail();
		}
	}

	public void validateElementsDisplayed(WebDriver driver) 
	{
		System.out.println("Inside validate Elements Displayed");
		Log.info("Inside validate Elements Displayed");
		try
		{
//			Thread.sleep(10000);
//			CommonUtility.ScrollTo(driver,obj_EsupportRetailAssetPage.singleRadioButton());
			if(CommonUtility.CheckpresenceofElementLocated(driver,20,obj_EsupportRetailAssetPage.singleRadioButton()))
			{
				System.out.println("Single Radio Button Displayed");
				Report.put("Single Radio Button should be Displayed", "Single Radio Button Displayed",
						"Single Radio Button Displayed successfully", "PASS");
			}
			else 
			{
				Report.put("Single Radio Button should be Displayed", "Single Radio Button Displayed",
						"Single Radio Button Display failed", "FAIL");
			Assert.fail();
		}
			CommonUtility.ScrollTo(driver,obj_EsupportRetailAssetPage.multipleProductRadioButton());
			if(CommonUtility.CheckpresenceofElementLocated(driver,20,obj_EsupportRetailAssetPage.multipleProductRadioButton()))
			{
				System.out.println("Multiple Radio Button Displayed");
				Report.put("Multiple Radio Button should be Displayed", "Multiple Radio Button Displayed",
						"Multiple Radio Button Displayed successfully", "PASS");
			}
			else 
			{
				Report.put("Multiple Radio Button should be Displayed", "Multiple Radio Button Displayed",
						"Multiple Radio Button Display failed", "FAIL");
				Assert.fail();
			}
			CommonUtility.ScrollTo(driver,obj_EsupportRetailAssetPage.serviceTag());
			if(CommonUtility.CheckpresenceofElementLocated(driver,20,obj_EsupportRetailAssetPage.serviceTag()))
			{
				System.out.println("Service Tag Displayed");
				Report.put("Service Tag should be Displayed", "Service Tag Displayed",
						"Service Tag Displayed successfully", "PASS");
			}
			else 
			{
				Report.put("Service Tag should be Displayed", "Service Tag Displayed",
						"Service Tag Display failed", "FAIL");
				Assert.fail();
			}
			CommonUtility.ScrollTo(driver,obj_EsupportRetailAssetPage.detectYourProductButton());
			if(CommonUtility.CheckpresenceofElementLocated(driver,20,obj_EsupportRetailAssetPage.detectYourProductButton()))
			{
				System.out.println("Detect Your Product Button Displayed");
				Report.put("Detect Your Product Button should be Displayed", "Detect Your Product Button Displayed",
						"Detect Your Product Button Displayed successfully", "PASS");
			}
			else 
			{
				Report.put("Detect Your Product Button should be Displayed", "Detect Your Product Button Displayed",
						"Detect Your Product Button Display failed", "FAIL");
				Assert.fail();
			}
			CommonUtility.ScrollTo(driver,obj_EsupportRetailAssetPage.scontinue());
			if(CommonUtility.CheckpresenceofElementLocated(driver,20,obj_EsupportRetailAssetPage.scontinue()))
			{
				System.out.println("Continue Button Displayed");
				Report.put("Continue Button should be Displayed", "Continue Button Displayed",
						"Continue Button Displayed successfully", "PASS");
			}
			else 
			{
				Report.put("Continue Button should be Displayed", "Continue Button Displayed",
						"Continue Button Display failed", "FAIL");
				Assert.fail();
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Assert.fail();
		}
	}

	public void clickMutlipleRadioButton(WebDriver driver) 
	{
		System.out.println("Inside read Multiple Tag");
		Log.info("Inside read Multiple Tag");
		try {

			//driver.navigate().refresh();
			Thread.sleep(6000);
			CommonUtility.ScrollTo(driver,obj_EsupportRetailAssetPage.multipleProductRadioButton());
			CommonUtility.ClickOn(driver,obj_EsupportRetailAssetPage.multipleProductRadioButton());
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Assert.fail();
		}

	}
	public void enterTag1(WebDriver driver,String servicetag) 
	{
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 120);
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
//		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

		System.out.println("Inside Enter Tag1");
		Log.info("Inside Enter Tag1");

		try 
		{
			System.out.println("Service Tag is "+servicetag);
			CommonUtility.ScrollTo(driver,obj_EsupportRetailAssetPage.addAnotherButton1());
			CommonUtility.highlightElement(driver,obj_EsupportRetailAssetPage.addTag1Textbox()).clear();
			CommonUtility.highlightElement(driver,obj_EsupportRetailAssetPage.addTag1Textbox()).sendKeys(servicetag);
			CommonUtility.ScrollTo(driver,obj_EsupportRetailAssetPage.addAnotherButton1());
			CommonUtility.ClickOn(driver,obj_EsupportRetailAssetPage.addAnotherButton1());
			Thread.sleep(6000);
			if(CommonUtility.CheckpresenceofElementLocated(driver, 30,obj_EsupportRetailAssetPage.invalidServiceTagMessage()))
			{
				String errMsg = CommonUtility.highlightElement(driver,obj_EsupportRetailAssetPage.invalidServiceTagMessage()).getText();
				System.out.println("Invalid Service Tag "+errMsg);
				Report.put("Validate Service Tag 1", "Service tag should be valid.",
						"Invalid Service Tag "+Report.colorFail(errMsg), "FAIL");
				Assert.fail();
			}
			else
				Report.put("Enter Service Tag 1", "Service tag should be valid",
						"Entered Service Tag 1", "PASS");


		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Provide the service tag.", "Service tag should reflect in the service tag text box.",
					"Service tag is not reflecting in the service tag text box", "FAIL");
			Assert.fail();
		}
	}
	public void enterTag2(WebDriver driver,String servicetag) 
	{
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 120);
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
//		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

		System.out.println("Inside Enter Tag2");
		Log.info("Inside Enter Tag2");

		try 
		{
			System.out.println("Service Tag is "+servicetag);
			CommonUtility.ScrollTo(driver,obj_EsupportRetailAssetPage.addTag2Textbox());
			CommonUtility.highlightElement(driver,obj_EsupportRetailAssetPage.addTag2Textbox()).clear();
			CommonUtility.highlightElement(driver,obj_EsupportRetailAssetPage.addTag2Textbox()).sendKeys(servicetag);
			CommonUtility.ScrollTo(driver,obj_EsupportRetailAssetPage.addAnotherButton2());
			CommonUtility.ClickOn(driver,obj_EsupportRetailAssetPage.addAnotherButton2());

			if(CommonUtility.CheckpresenceofElementLocated(driver, 30,obj_EsupportRetailAssetPage.invalidServiceTagMessage()))
			{
				String errMsg = CommonUtility.highlightElement(driver,obj_EsupportRetailAssetPage.invalidServiceTagMessage()).getText();
				System.out.println("Invalid Service Tag "+errMsg);
				Report.put("Validate Service Tag", "Service tag should be valid.",
						"Invalid Service Tag "+Report.colorFail(errMsg), "FAIL");
				Assert.fail();
			}
			else
				Report.put("Enter Service Tag2", "Service tag should be valid",
						"Entered Service Tag2", "PASS");


		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Provide the service tag.", "Service tag should reflect in the service tag text box.",
					"Service tag is not reflecting in the service tag text box", "FAIL");
			Assert.fail();
		}
	}
	public void enterTag3(WebDriver driver,String servicetag) 
	{
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 120);
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
//		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

		System.out.println("Inside Enter Tag3");
		Log.info("Inside Enter Tag3");

		try 
		{
			System.out.println("Service Tag is "+servicetag);
			CommonUtility.ScrollTo(driver,obj_EsupportRetailAssetPage.addTag3Textbox());
			CommonUtility.highlightElement(driver,obj_EsupportRetailAssetPage.addTag3Textbox()).clear();
			CommonUtility.highlightElement(driver,obj_EsupportRetailAssetPage.addTag3Textbox()).sendKeys(servicetag);
			Thread.sleep(3000);
			CommonUtility.ScrollTo(driver,obj_EsupportRetailAssetPage.addAnotherButton3());
			CommonUtility.ClickOn(driver,obj_EsupportRetailAssetPage.addAnotherButton3());

			if(CommonUtility.CheckpresenceofElementLocated(driver, 30,obj_EsupportRetailAssetPage.invalidServiceTagMessage()))
			{
				String errMsg = CommonUtility.highlightElement(driver,obj_EsupportRetailAssetPage.invalidServiceTagMessage()).getText();
				System.out.println("Invalid Service Tag "+errMsg);
				Report.put("Validate Service Tag", "Service tag should be valid.",
						"Invalid Service Tag "+Report.colorFail(errMsg), "FAIL");
				Assert.fail();
			}
			else
				Report.put("Enter Service Tag3", "Service tag should be valid",
						"Entered Service Tag3", "PASS");


		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Provide the service tag.", "Service tag should reflect in the service tag text box.",
					"Service tag is not reflecting in the service tag text box", "FAIL");
			Assert.fail();
		}
	}
	public void enterTag4(WebDriver driver,String servicetag) 
	{
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 120);
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
//		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

		System.out.println("Inside Enter Tag4");
		Log.info("Inside Enter Tag4");

		try 
		{
			System.out.println("Service Tag is "+servicetag);
			CommonUtility.ScrollTo(driver,obj_EsupportRetailAssetPage.addTag4Textbox());
			CommonUtility.highlightElement(driver,obj_EsupportRetailAssetPage.addTag4Textbox()).clear();
			CommonUtility.highlightElement(driver,obj_EsupportRetailAssetPage.addTag4Textbox()).sendKeys(servicetag);
			CommonUtility.ScrollTo(driver,obj_EsupportRetailAssetPage.addAnotherButton4());
			CommonUtility.ClickOn(driver,obj_EsupportRetailAssetPage.addAnotherButton4());

			if(CommonUtility.CheckpresenceofElementLocated(driver, 30,obj_EsupportRetailAssetPage.invalidServiceTagMessage()))
			{
				String errMsg = CommonUtility.highlightElement(driver,obj_EsupportRetailAssetPage.invalidServiceTagMessage()).getText();
				System.out.println("Invalid Service Tag "+errMsg);
				Report.put("Validate Service Tag", "Service tag should be valid.",
						"Invalid Service Tag "+Report.colorFail(errMsg), "FAIL");
				Assert.fail();
			}
			else
				Report.put("Enter Service Tag 4", "Service tag should be valid",
						"Entered Service Tag 4", "PASS");


		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Provide the service tag.", "Service tag should reflect in the service tag text box.",
					"Service tag is not reflecting in the service tag text box", "FAIL");
			Assert.fail();
		}
	}
	public void enterTag5(WebDriver driver,String servicetag) 
	{
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 120);
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
//		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

		System.out.println("Inside Enter Tag5");
		Log.info("Inside Enter Tag5");

		try 
		{
			System.out.println("Service Tag is "+servicetag);
//			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportRetailAssetPage.addTag5Textbox()));
			CommonUtility.ScrollTo(driver,obj_EsupportRetailAssetPage.addTag5Textbox());
			CommonUtility.highlightElement(driver,obj_EsupportRetailAssetPage.addTag5Textbox()).clear();
			CommonUtility.highlightElement(driver,obj_EsupportRetailAssetPage.addTag5Textbox()).sendKeys(servicetag);
			CommonUtility.ScrollTo(driver,obj_EsupportRetailAssetPage.addAnotherButton5());
			CommonUtility.ClickOn(driver,obj_EsupportRetailAssetPage.addAnotherButton5());

			if(CommonUtility.CheckpresenceofElementLocated(driver, 30,obj_EsupportRetailAssetPage.invalidServiceTagMessage()))
			{
				String errMsg = CommonUtility.highlightElement(driver,obj_EsupportRetailAssetPage.invalidServiceTagMessage()).getText();
				System.out.println("Invalid Service Tag "+errMsg);
				Report.put("Validate Service Tag", "Service tag should be valid.",
						"Invalid Service Tag "+Report.colorFail(errMsg), "FAIL");
				Assert.fail();
			}
			else
				Report.put("Enter Service Tag 5", "Service tag should be valid",
						"Entered Service Tag 5", "PASS");


		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Provide the service tag.", "Service tag should reflect in the service tag text box.",
					"Service tag is not reflecting in the service tag text box", "FAIL");
			Assert.fail();
		}
	}

	public void checkAddAnotherButton(WebDriver driver)
	{
		try
		{
			if(!CommonUtility.CheckpresenceofElementLocated(driver, 30, obj_EsupportRetailAssetPage.addAnotherButton5()))
			{
				Report.put("After adding 5 tags Add Button should not be displayed", "Add Button should not be displayed",
						"Add Button is not displayed", "PASS");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("After adding 5 tags Add Button should not be displayed.", "Add Button should not be displayed",
					"Add Button is displayed", "FAIL");
			Assert.fail();
		}
	}
	public void validatePrivacyStatementLink(WebDriver driver)
	{

		System.out.println("Click on Privacy Statement");
		Log.info("Click on Privacy Statement");

		try
		{
			CommonUtility.ScrollTo(driver, obj_EsupportRetailAssetPage.privacyStatementLink());
			CommonUtility.ClickOn(driver, obj_EsupportRetailAssetPage.privacyStatementLink());
			Set<String> allWH=driver.getWindowHandles(); 
			String currentwindow=driver.getWindowHandle();
			int count=allWH.size(); 
			System.out.println("Switched Window Handles and  window count is :: "+count);
			for(String wh:allWH)
			{
				Thread.sleep(5000);
				driver.switchTo().window(wh); 
				String title=driver.getTitle();
				System.out.println("Tittle displayed as : "+title);
				if(title.equalsIgnoreCase("Privacy Statement | Dell"))
				{
					driver.switchTo().window(wh);
					CommonUtility.highlightElement(driver, obj_EsupportRetailAssetPage.privacyLabel()).click();
					driver.close();

				}
				Thread.sleep(4000);

				System.out.println("Parent window handle is "+currentwindow);
				driver.switchTo().window(currentwindow);


			}



			Report.put("Check Privacy Statement link", "A new window should popup Dell Privacy Statement",
					"Dell Privacy Statement Popup displayed ", "PASS");


		} catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Check Privacy Statement link", "A new window should popup Dell Privacy Statement",
					"Dell Privacy Statement Popup display failed", "FAIL");
			Assert.fail();
		}
	}
//pushpa new code......
	
	public void privacyStatement_IEone(WebDriver driver)
    {
            WebDriverWait wait = new WebDriverWait(driver, 600);
            System.out.println("After webdriver wait");
            driver.manage().timeouts().implicitlyWait(600, TimeUnit.SECONDS);
            //             driver.manage().timeouts().pageLoadTimeout(600, TimeUnit.SECONDS);
            try
            {
//            wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportRetailAssetPage.DellPrivacyStatement()));
                    CommonUtility.ScrollTo(driver, obj_EsupportRetailAssetPage.DellPrivacyStatement());
                    CommonUtility.ClickOn(driver, obj_EsupportRetailAssetPage.DellPrivacyStatement());
                    Thread.sleep(5000);

                    String currentWindow = driver.getWindowHandle();
                    Set<String> allWH=driver.getWindowHandles();
                    int n=allWH.size();
                    System.out.println("count of windows is "+n);
                    System.out.println(allWH);

                    for(String wh:allWH)
                    {
                            Thread.sleep(5000);
                            driver.switchTo().window(wh); 
                            String title=driver.getTitle();
                            System.out.println("Tittle displayed as : "+title);


                            if(title.equalsIgnoreCase("Privacy Statement | Dell"))
                            {
                                    System.out.println("inside  Privacy Statement | Dell:::::::::");
                                    String currentUrl = driver.getCurrentUrl();
                                    System.out.println("Current URl is  inside delllllllllll:::::: "+currentUrl);


                            wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportRetailAssetPage.PrivacyStatement()));
                                    CommonUtility.ScrollTo(driver, obj_EsupportRetailAssetPage.PrivacyStatement());
                                    CommonUtility.ClickOn(driver, obj_EsupportRetailAssetPage.PrivacyStatement());

                                    Thread.sleep(5000);
                            wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportRetailAssetPage.PrivacyStatementHeader()));
                                    handleCookies(driver);


                            wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportRetailAssetPage.Termsandconditions()));
                                    CommonUtility.ScrollTo(driver, obj_EsupportRetailAssetPage.Termsandconditions()); 
                                    CommonUtility.highlightElement(driver, obj_EsupportRetailAssetPage.Termsandconditions()); 
                                    CommonUtility.ClickOn(driver, obj_EsupportRetailAssetPage.Termsandconditions());
                            wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportRetailAssetPage.TermsandconditionsHeader()));


                                    String currentWindowone = driver.getWindowHandle();
                                    Set<String> allWHone=driver.getWindowHandles();
                                    int nnew=allWHone.size();
                                    System.out.println("count of windows is "+nnew);
                                    System.out.println(allWHone);

                                    for(String wh1:allWHone)
                                    {
                                            Thread.sleep(5000);
                                            driver.switchTo().window(wh1); 
                                            String title1=driver.getTitle();
                                            System.out.println("Tittle displayed as : after runnnnnnnn::::::: "+title1);
                                            if(title1.equalsIgnoreCase("Terms of Sale | Dell"))
                                            {
                                                    System.out.println("inside  Privacy Statement | Dell:::::::::");
                                                    String currentUrlone = driver.getCurrentUrl();
                                                    System.out.println("Current URl is  inside delllllllllll::::::  currentUrlone "+currentUrlone);


                                            //wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportRetailAssetPage.PrivacyStatement()));

                                                    driver.close();

                                                    Thread.sleep(5000);
                                            }
                                    }
                            }
                    }       
                    driver.switchTo().window(currentWindow);

                    Thread.sleep(10000);
            wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportRetailAssetPage.RegisterButton()));
                    CommonUtility.ScrollTo(driver, obj_EsupportRetailAssetPage.RegisterButton());
                    CommonUtility.ClickOn(driver, obj_EsupportRetailAssetPage.RegisterButton());
                    Report.put("Check for Privacy statement link in every page and Terms & Conditions link",
                                    "All links should work fine",
                                    "All links works fine", "PASS");
                    Report.put("Fill all the options and click on Register ", 
                                    "The service tag should be registered successfully.",
                                    "The service tag registeres successfully.", "PASS");

            }
            catch(Exception e)
            {
                    e.printStackTrace();
                    Report.put("Check for Privacy statement link in every page and Terms & Conditions link",
                                    "All links should work fine",
                                    "All links does not work fine", "FAIL");
                    Report.put("Fill all the options and click on Register ", 
                                    "The service tag should be registered successfully.",
                                    "The service tag does not register successfully.", "FAIL");
                    Assert.fail();
            }

    }

//Sneha
	
	public void VerifyOwnershipTransferPage (WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 600);
        System.out.println("Entered method VerifyOwnershipTransferPage");
        driver.manage().timeouts().implicitlyWait(600, TimeUnit.SECONDS);
        
        try
        {
        	driver.get("https://www.dell.com/support/assets-transfer/en-us");
        	
        	wait.until((ExpectedConditions.visibilityOfElementLocated(obj_EsupportRetailAssetPage.WarrantyOwnerShipTransferHeaderText())));
       
            System.out.println("Page Title is : "+driver.getTitle());
            if(driver.getTitle().contains("Ownership Transfer"))
            {
            	Report.put("Hit the URL https://www.dell.com/support/assets-transfer/en-us", 
            			"User should land on Ownership Transfer page", 
            			"User successfully landed on "+Report.color(driver.getTitle())+" page", "Pass");
            }
            else
            {
            	Report.put("Hit the URL https://www.dell.com/support/assets-transfer/en-us", 
            			"User should land on Ownership Transfer page", 
            			"User failed landing on Ownership Transfer page", "Fail");
            	Assert.fail();
            	
            }
        }
        catch(Exception e)
        {
        	 e.printStackTrace();
        	 Report.put("Hit the URL https://www.dell.com/support/assets-transfer/en-us", 
         			"User should land on Ownership Transfer page", 
         			"User failed landing on Ownership Transfer page", "Fail");
        	 Assert.fail();
        }
	}
	
	public void SelectSingleProductRadioButton(WebDriver driver)
	{
	    WebDriverWait wait = new WebDriverWait(driver, 600);
        System.out.println("Entered method SelectSingleProductRadioButton");
        driver.manage().timeouts().implicitlyWait(600, TimeUnit.SECONDS);
        
       try
       {
    	   if(CommonUtility.CheckpresenceofElementLocated(driver, 20, obj_EsupportRetailAssetPage.HowManyProductsText()))
           {
    		   Boolean result1=driver.findElement(obj_EsupportRetailAssetPage.SingleProductRadioButton()).isDisplayed();
    		   Boolean result2=driver.findElement(obj_EsupportRetailAssetPage.UpToFiveProductsRadioButton()).isDisplayed();
    		   
    		   if(result1==true && result2==true)
    		   {
    		      CommonUtility.ScrollTo(driver, obj_EsupportRetailAssetPage.SingleProductRadioButton());
    		      CommonUtility.ClickOn(driver, obj_EsupportRetailAssetPage.SingleProductRadioButton());
    		      Thread.sleep(8000);
    		   
    		      System.out.println("Clicked on SingleProductRadioButton");
    		   
    		      Report.put("Verify Single Radio button and click on Single Product Radio button", 
    	       			    "User should select Single Product Radio button", 
    	       		    	"User successfully selected Single Product Radio button", "Pass");
    		   }
           }
    	   else
    	   {
    		   Report.put("Verify Single Radio button and click on Single Radio button", 
    	       			"User should select Single Radio button", 
    	       			"User failed select Single Radio button", "Fail");
    		   Assert.fail();
    	   }
       }
       catch(Exception e)
       {
    	 e.printStackTrace();
      	 Report.put("Verify Single Radio button and click on Single Radio button", 
       			"User should select Single Radio button", 
       			"User failed select Single Radio button", "Fail");
      	 Assert.fail();
       }
        
	}
	
	public void ClickOnDetectPC(WebDriver driver)
	{
		 WebDriverWait wait = new WebDriverWait(driver, 600);
	     System.out.println("Entered method ClickOnDetectPC");
	     driver.manage().timeouts().implicitlyWait(600, TimeUnit.SECONDS);
	     
	     try
	     {
	    	 if(CommonUtility.CheckpresenceofElementLocated(driver, 20, obj_EsupportRetailAssetPage.DetectPCButton()))
	    	 {
	    		 CommonUtility.ScrollTo(driver, obj_EsupportRetailAssetPage.DetectPCButton());
	    		 CommonUtility.ClickOn(driver, obj_EsupportRetailAssetPage.DetectPCButton());
	    		 Thread.sleep(8000);
	    		 System.out.println("Clicked on DetectPC button");
	    		 
	    		 Report.put("Verify DetectPC button and click on DetectPC button", 
	 	       			"User should click on DetectPC button", 
	 	       			"User clicked on DetectPC button", "Pass");
	    	 }
	     }
	     catch(Exception e)
	     {
	    	 e.printStackTrace();
	      	 Report.put("Verify DetectPC button and click on DetectPC button", 
	       			"User should click DetectPC button", 
	       			"User failed to click DetectPC button", "Fail");
	      	 Assert.fail();
	     }
	}
	
	public void ClickOnContinueButton(WebDriver driver)
	{
		 WebDriverWait wait = new WebDriverWait(driver, 600);
	     System.out.println("Entered method ClickOnContinueButton");
	     driver.manage().timeouts().implicitlyWait(600, TimeUnit.SECONDS);
	     
	     try
	     {
	    	 if(CommonUtility.CheckpresenceofElementLocated(driver, 20, obj_EsupportRetailAssetPage.ContinueButton()))
	    	 {
	    		 CommonUtility.ScrollTo(driver, obj_EsupportRetailAssetPage.ContinueButton());
	    		 CommonUtility.ClickOn(driver, obj_EsupportRetailAssetPage.ContinueButton());
	    		 Thread.sleep(4000);
	    		 System.out.println("Clicked on Continue button");
	    		 
	    		 Report.put("Verify Continue button and click on Continue button", 
	 	       			"User should click on Continue button", 
	 	       			"User clicked on Continue button", "Pass");
	    	 }
	     }
	     catch(Exception e)
	     {
	    	 e.printStackTrace();
	      	 Report.put("Verify Continue button and click on Continue button", 
	       			"User should click Continue button", 
	       			"User failed to click Continue button", "Fail");
	      	 Assert.fail();
	     }
	}

	public void FillPreviousOwnerDetails(WebDriver driver)
	{
		 WebDriverWait wait = new WebDriverWait(driver, 600);
	     System.out.println("Entered method FillPreviousOwnerDetails");
	     driver.manage().timeouts().implicitlyWait(600, TimeUnit.SECONDS);
	     
	     try 
	     {
	    	
	    	 if(CommonUtility.CheckpresenceofElementLocated(driver, 20, obj_EsupportRetailAssetPage.PreviousOwnerDetailsHeaderText()))
	    	 {
	    		 CommonUtility.ScrollTo(driver, obj_EsupportRetailAssetPage.PreviousOwnerDetailsHeaderText());
	    		 
	    		 String text=driver.findElement(obj_EsupportRetailAssetPage.PreviousOwnerDetailsHeaderText()).getText();
	    		 
	    		 System.out.println("User landed on "+text+" page");
	    		 
	    		 CommonUtility.ScrollTo(driver, obj_EsupportRetailAssetPage.CompanyNameFieldOnPreviousOwnerDetailsPage());
	    		 CommonUtility.highlightElement(driver, obj_EsupportRetailAssetPage.CompanyNameFieldOnPreviousOwnerDetailsPage()).clear();
	    		 CommonUtility.highlightElement(driver, obj_EsupportRetailAssetPage.CompanyNameFieldOnPreviousOwnerDetailsPage()).sendKeys("Old Company");
	    	     Thread.sleep(3000);
	    		 
	    		 CommonUtility.ScrollTo(driver, obj_EsupportRetailAssetPage.ZipCodeFieldOnPreviousOwnerDetailsPage());
	    		 CommonUtility.highlightElement(driver, obj_EsupportRetailAssetPage.ZipCodeFieldOnPreviousOwnerDetailsPage()).clear();
	    		 CommonUtility.highlightElement(driver, obj_EsupportRetailAssetPage.ZipCodeFieldOnPreviousOwnerDetailsPage()).sendKeys("123456");
	    		 Thread.sleep(3000);
	    		 
	    		 CommonUtility.ScrollTo(driver, obj_EsupportRetailAssetPage.FirstNameFieldOnPreviousOwnerDetailsPage());
	    		 CommonUtility.highlightElement(driver, obj_EsupportRetailAssetPage.FirstNameFieldOnPreviousOwnerDetailsPage()).clear();
	    		 CommonUtility.highlightElement(driver, obj_EsupportRetailAssetPage.FirstNameFieldOnPreviousOwnerDetailsPage()).sendKeys("FirstName1");
	    		 Thread.sleep(3000);
	    		 
	    		 CommonUtility.ScrollTo(driver, obj_EsupportRetailAssetPage.LastNameFieldOnPreviousOwnerDetailsPage());
	    		 CommonUtility.highlightElement(driver, obj_EsupportRetailAssetPage.LastNameFieldOnPreviousOwnerDetailsPage()).clear();
	    		 CommonUtility.highlightElement(driver, obj_EsupportRetailAssetPage.LastNameFieldOnPreviousOwnerDetailsPage()).sendKeys("LastName1");
	    		 Thread.sleep(3000);
	    		 
	    		 CommonUtility.ScrollTo(driver, obj_EsupportRetailAssetPage.EmailFieldOnPreviousOwnerDetailsPage());
	    		 CommonUtility.highlightElement(driver, obj_EsupportRetailAssetPage.EmailFieldOnPreviousOwnerDetailsPage()).clear();
	    		 CommonUtility.highlightElement(driver, obj_EsupportRetailAssetPage.EmailFieldOnPreviousOwnerDetailsPage()).sendKeys("email1@email.com");
	    		 Thread.sleep(3000);
	    		 
	    		 CommonUtility.ScrollTo(driver, obj_EsupportRetailAssetPage.CustomerIDFieldOnPreviousOwnerDetailsPage());
	    		 CommonUtility.highlightElement(driver, obj_EsupportRetailAssetPage.CustomerIDFieldOnPreviousOwnerDetailsPage()).clear();
	    		 CommonUtility.highlightElement(driver, obj_EsupportRetailAssetPage.CustomerIDFieldOnPreviousOwnerDetailsPage()).sendKeys("CustomerId1");
	    		 Thread.sleep(3000);
	    		 
	    		 CommonUtility.ScrollTo(driver, obj_EsupportRetailAssetPage.StreerAddressFieldOnPreviousOwnerDetailsPage());
	    		 CommonUtility.highlightElement(driver, obj_EsupportRetailAssetPage.StreerAddressFieldOnPreviousOwnerDetailsPage()).clear();
	    		 CommonUtility.highlightElement(driver, obj_EsupportRetailAssetPage.StreerAddressFieldOnPreviousOwnerDetailsPage()).sendKeys("StreetAddress1");
	    		 Thread.sleep(3000);
	    		 
	    		 CommonUtility.ScrollTo(driver, obj_EsupportRetailAssetPage.PhoneFieldOnPreviousOwnerDetailsPage());
	    		 CommonUtility.highlightElement(driver, obj_EsupportRetailAssetPage.PhoneFieldOnPreviousOwnerDetailsPage()).clear();
	    		 CommonUtility.highlightElement(driver, obj_EsupportRetailAssetPage.PhoneFieldOnPreviousOwnerDetailsPage()).sendKeys("1234567890");
	    		 Thread.sleep(3000);
	    		 
	    		 ClickOnContinueButton(driver);
	    		 
	    		 Report.put("Verify Previous Owner Details page and fill all the mandatory fields", 
	 	       			"User should able to verify Previous Owner Details page and fill all the mandatory fields", 
	 	       			"User successfully verified the Previous Owner Details page and successfullyfilled all the fields", "pass");
	    	 }
	    	 else
	    	 {
	    		 Report.put("Verify Previous Owner Details page and fill all the mandatory fields", 
	 	       			"User should able to verify Previous Owner Details page and fill all the mandatory fields", 
	 	       			"User failed to verify Previous Owner Details page and fill all the mandatory fields", "Fail");
	 	      	 Assert.fail();
	    	 }
	     }
	     catch(Exception e)
	     {
	    	 e.printStackTrace();
	      	 Report.put("Verify Previous Owner Details page and fill all the mandatory fields", 
	       			"User should able to verify Previous Owner Details page and fill all the mandatory fields", 
	       			"User failed to verify Previous Owner Details page and fill all the mandatory fields", "Fail");
	      	 Assert.fail();
	     }
	}
	
	public void selectStateInNewOwnerDetails(WebDriver driver, String state)
	{

		System.out.println("Inside selectStateInNewOwnerDetails");
		Log.info("Inside selectStateInNewOwnerDetails");

		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);
			
			CommonUtility.ToClickByUsingJavaScript_PassingByLoc(driver, obj_EsupportRetailAssetPage.StateDropDownOnNewOwnerDetailsPage());

			Select selAction = new  Select(driver.findElement(obj_EsupportRetailAssetPage.StateDropDownOnNewOwnerDetailsPage()));

			if(state.contains("Karnataka"))
			{
				selAction.selectByVisibleText("Karnataka"); 
				System.out.println(state);
			}
		} catch(Exception e)
		{
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	public void FillNewOwnerDetailsPage(WebDriver driver, String option, String state, String GSTINno)
	{
		 WebDriverWait wait = new WebDriverWait(driver, 600);
	     System.out.println("Entered method FillPreviousOwnerDetails");
	     driver.manage().timeouts().implicitlyWait(600, TimeUnit.SECONDS);
	     
	     try
	     {
	    	 if(CommonUtility.CheckpresenceofElementLocated(driver, 20, obj_EsupportRetailAssetPage.NewOwnerDetailsHeaderText()))
	    	 {
	    		 CommonUtility.ScrollTo(driver, obj_EsupportRetailAssetPage.NewOwnerDetailsHeaderText());
	    		 
	    		 String text=driver.findElement(obj_EsupportRetailAssetPage.NewOwnerDetailsHeaderText()).getText();
	    		 
	    		 System.out.println("User landed on "+text+" page");
	    		 
	    		 selectIntendedUse(driver, option);
	    		 Thread.sleep(3000);
	    		 
	    		 CommonUtility.ScrollTo(driver, obj_EsupportRetailAssetPage.FirstNameOnNewOwnerDetailsPage());
	    		 CommonUtility.highlightElement(driver, obj_EsupportRetailAssetPage.FirstNameOnNewOwnerDetailsPage()).clear();
	    		 CommonUtility.highlightElement(driver, obj_EsupportRetailAssetPage.FirstNameOnNewOwnerDetailsPage()).sendKeys("FirstName1");
	    		 Thread.sleep(3000);
	    		 
	    		 CommonUtility.ScrollTo(driver, obj_EsupportRetailAssetPage.LastNameOnNewOwnerDetailsPage());
	    		 CommonUtility.highlightElement(driver, obj_EsupportRetailAssetPage.LastNameOnNewOwnerDetailsPage()).clear();
	    		 CommonUtility.highlightElement(driver, obj_EsupportRetailAssetPage.LastNameOnNewOwnerDetailsPage()).sendKeys("LastName1");
	    		 Thread.sleep(3000);
	    		 
	    		 CommonUtility.ScrollTo(driver, obj_EsupportRetailAssetPage.EmailOnNewOwnerDetailsPage());
	    		 CommonUtility.highlightElement(driver, obj_EsupportRetailAssetPage.EmailOnNewOwnerDetailsPage()).clear();
	    		 CommonUtility.highlightElement(driver, obj_EsupportRetailAssetPage.EmailOnNewOwnerDetailsPage()).sendKeys("email1@email.com");
	    		 Thread.sleep(3000);
	    		 
	    		 CommonUtility.ScrollTo(driver, obj_EsupportRetailAssetPage.CustomerIDOnNewOwnerDetailsPage());
	    		 CommonUtility.highlightElement(driver, obj_EsupportRetailAssetPage.CustomerIDOnNewOwnerDetailsPage()).clear();
	    		 CommonUtility.highlightElement(driver, obj_EsupportRetailAssetPage.CustomerIDOnNewOwnerDetailsPage()).sendKeys("CustomerId1");
	    		 Thread.sleep(3000);
	    		 
	    		 CommonUtility.ScrollTo(driver, obj_EsupportRetailAssetPage.StreetAddressOnNewOwnerDetailsPage());
	    		 CommonUtility.highlightElement(driver, obj_EsupportRetailAssetPage.StreetAddressOnNewOwnerDetailsPage()).clear();
	    		 CommonUtility.highlightElement(driver, obj_EsupportRetailAssetPage.StreetAddressOnNewOwnerDetailsPage()).sendKeys("StreetAddress1");
	    		 Thread.sleep(3000);
	    		 
	    		 CommonUtility.ScrollTo(driver, obj_EsupportRetailAssetPage.CityOnNewOwnerDetailsPage());
	    		 CommonUtility.highlightElement(driver, obj_EsupportRetailAssetPage.CityOnNewOwnerDetailsPage()).clear();
	    		 CommonUtility.highlightElement(driver, obj_EsupportRetailAssetPage.CityOnNewOwnerDetailsPage()).sendKeys("1234567890");
	    		 Thread.sleep(3000);
	    		 
	    		 CommonUtility.ScrollTo(driver, obj_EsupportRetailAssetPage.ZipCodeOnNewOwnerDetailsPage());
	    		 CommonUtility.highlightElement(driver, obj_EsupportRetailAssetPage.ZipCodeOnNewOwnerDetailsPage()).clear();
	    		 CommonUtility.highlightElement(driver, obj_EsupportRetailAssetPage.ZipCodeOnNewOwnerDetailsPage()).sendKeys("123456");
	    		 Thread.sleep(3000);
	    		 
	    		 CommonUtility.ScrollTo(driver, obj_EsupportRetailAssetPage.PhoneOnNewOwnerDetailsPage());
	    		 CommonUtility.highlightElement(driver, obj_EsupportRetailAssetPage.PhoneOnNewOwnerDetailsPage()).clear();
	    		 CommonUtility.highlightElement(driver, obj_EsupportRetailAssetPage.PhoneOnNewOwnerDetailsPage()).sendKeys("123456");
	    		 Thread.sleep(3000);
	    		 
	    		 selectStateInNewOwnerDetails(driver, state);
	    		 selectGSTINNumber(driver, GSTINno);
	    		 
	    		 ClickOnContinueButton(driver);
	    		 
	    		 VerifyCoverageAndAvailabilityNoticePopUp(driver);
	    		 
	    		 Report.put("Verify New Owner Details page and fill all the mandatory fields", 
	 	       			"User should able to verify New Owner Details page and fill all the mandatory fields", 
	 	       			"User successfully verified the New Owner Details page and successfullyfilled all the fields", "pass");
	    	 }
	    	 
	    	 else
	    	 {
	    		 Report.put("Verify New Owner Details page and fill all the mandatory fields", 
	 	       			"User should able to verify New Owner Details page and fill all the mandatory fields", 
	 	       			"User failed to verify New Owner Details page and fill all the mandatory fields", "Fail");
	 	      	 Assert.fail();
	    	 }
	     }
	     catch(Exception e)
	     {
	    	 e.printStackTrace();
	      	 Report.put("Verify New Owner Details page and fill all the mandatory fields", 
	       			"User should able to verify New Owner Details page and fill all the mandatory fields", 
	       			"User failed to verify New Owner Details page and fill all the mandatory fields", "Fail");
	      	 Assert.fail();
	     }
	}
	
	public void VerifyCoverageAndAvailabilityNoticePopUp(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 600);
	     System.out.println("Entered method VerifyCoverageAndAvailabilityNoticePopUp");
	     driver.manage().timeouts().implicitlyWait(600, TimeUnit.SECONDS);
	     
	     try
	     {
	    	if(CommonUtility.CheckpresenceofElementLocated(driver, 20, obj_EsupportRetailAssetPage.CoverageAndAvailabilityNoticeHeaderText())) 
	    	{
	    		CommonUtility.ScrollTo(driver, obj_EsupportRetailAssetPage.ContinueButtonOnCoverageNoticePopUp());
	    		CommonUtility.ClickOn(driver, obj_EsupportRetailAssetPage.ContinueButtonOnCoverageNoticePopUp());
	    	
	    		Report.put("Verify Coverage And Availability Notice PopUp", 
		       			"User should verify Coverage And Availability Notice PopUp", 
		       			"User successfully verified Coverage And Availability Notice PopUp", "Pass");
	    	}
	     }
	     catch(Exception e)
	     {
	    	 e.printStackTrace();
	      	 Report.put("Verify Coverage And Availability Notice PopUp", 
	       			"User should verify Coverage And Availability Notice PopUp", 
	       			"User failed to verify Coverage And Availability Notice PopUp", "Fail");
	      	 Assert.fail();
	     }
	}
	
	public void VerifyReviewPage(WebDriver driver)
	{
		 WebDriverWait wait = new WebDriverWait(driver, 600);
	     System.out.println("Entered method VerifyReviewPage");
	     driver.manage().timeouts().implicitlyWait(600, TimeUnit.SECONDS);
	     
	     try
	     {
	    	 if(CommonUtility.CheckpresenceofElementLocated(driver, 20, obj_EsupportRetailAssetPage.ReviewProductHeaderText()))
	    	 {
	    		 CommonUtility.ScrollTo(driver, obj_EsupportRetailAssetPage.ReviewProductHeaderText());
	    		 
	    		 String text=driver.findElement(obj_EsupportRetailAssetPage.ReviewProductHeaderText()).getText();
	    		 
	    		 System.out.println("User landed on "+text+" page");
	    		 Thread.sleep(3000);
	    		 
	    		 CommonUtility.ScrollTo(driver, obj_EsupportRetailAssetPage.IHaveReadCheckBox());
	    		 CommonUtility.highlightElement(driver, obj_EsupportRetailAssetPage.IHaveReadCheckBox()).click();
	    		 
//	    		 CommonUtility.ClickOn(driver, obj_EsupportRetailAssetPage.SubmitButton());
	    	 }
	     }
	     catch(Exception e)
	     {
	    	 e.printStackTrace();
	      	 Report.put("Verify New Owner Details page and fill all the mandatory fields", 
	       			"User should able to verify New Owner Details page and fill all the mandatory fields", 
	       			"User failed to verify New Owner Details page and fill all the mandatory fields", "Fail");
	      	 Assert.fail();
	     }
	     
	}
	
	public void selectGSTINNumber(WebDriver driver, String option)
	{

		System.out.println("Inside selectIntendedUse");
		Log.info("Inside selectIntendedUse");

		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);
			CommonUtility.ToClickByUsingJavaScript_PassingByLoc(driver, obj_EsupportRetailAssetPage.GSTINNumberDropDownOnNewOwnerDetailsPage());

			Select selAction = new  Select(driver.findElement(obj_EsupportRetailAssetPage.GSTINNumberDropDownOnNewOwnerDetailsPage()));

			if(option.contains("Unregistered"))
			{
				selAction.selectByVisibleText("Unregistered"); 
				System.out.println(option);
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Assert.fail();
		}
	}

	public void VerifyTransferReqSubmittedOrNot(WebDriver driver)
	{
		 WebDriverWait wait = new WebDriverWait(driver, 600);
	     System.out.println("Entered method VerifyReviewPage");
	     driver.manage().timeouts().implicitlyWait(600, TimeUnit.SECONDS);
	     String text;
	     String number;
	     
	     try
	     {
	    	 if(CommonUtility.highlightElement(driver,obj_EsupportRetailAssetPage.TransferSubmittedHeaderText()).isDisplayed())
	    	 {
	    		 text= driver.findElement(obj_EsupportRetailAssetPage.TransferSubmittedHeaderText()).getText();
	    		 System.out.println("Displaying header as "+text);
	    		 
	    		 Boolean confirmationNumber= driver.findElement(obj_EsupportRetailAssetPage.TransferSubmittedHeaderText()).isDisplayed();
	    		 number=driver.findElement(obj_EsupportRetailAssetPage.TransferSubmittedHeaderText()).getText();
	    		 if(confirmationNumber==true)
	    		 {
	    			 System.out.println("Cnfiration displaying as "+number);
	    		 }
	    		 
	    		 Report.put("Validate Transfer Request Submitted message and a confirmation number displayed" , 
	          			"User should able see Transfer Request Submitted and a confirmation number", 
	          			"User successfully getting header text "+Report.color(text), "Pass");
	    	 }
	     }
	     catch(Exception e)
	     {
	    	 e.printStackTrace();
        	 Report.put("Validate Transfer Request Submitted message and a confirmation number displayed" , 
         			"User should able see Transfer Request Submitted and a confirmation number", 
         			"User failed validate Transfer Request Submitted message and a confirmation number displayed", "Fail");
        	 Assert.fail();
	     }
	}
	
	public void ClickOnDownloadCSVTemplateButton(WebDriver driver)
	{
		 WebDriverWait wait = new WebDriverWait(driver, 600);
	     System.out.println("Entered method ClickOnDownloadCSVTemplateButton");
	     driver.manage().timeouts().implicitlyWait(600, TimeUnit.SECONDS);
	     
	     try
	     {
	    	 if(CommonUtility.CheckpresenceofElementLocated(driver, 20, obj_EsupportRetailAssetPage.DownloadCSVTemplateButton()))
	    	 {
	    		 CommonUtility.ScrollTo(driver, obj_EsupportRetailAssetPage.DownloadCSVTemplateButton());
	    		 CommonUtility.ClickOn(driver, obj_EsupportRetailAssetPage.DownloadCSVTemplateButton());
	    		 Thread.sleep(10000);
	    		 System.out.println("Clicked on DownloadCSVTemplateButton button");
	    		 
	    		 Report.put("Verify Continue button and click on DownloadCSVTemplateButton button", 
	 	       			"User should click on DownloadCSVTemplateButton button", 
	 	       			"User clicked on DownloadCSVTemplateButton button", "Pass");
	    	 }
	     }
	     catch(Exception e)
	     {
	    	 e.printStackTrace();
	      	 Report.put("Verify Continue button and click on DownloadCSVTemplateButton button", 
	       			"User should click DownloadCSVTemplateButton button", 
	       			"User failed to click DownloadCSVTemplateButton button", "Fail");
	      	 Assert.fail();
	     }
	}
	
	public void ClickOnChooseFileButton(WebDriver driver)
	{
		 WebDriverWait wait = new WebDriverWait(driver, 600);
	     System.out.println("Entered method ClickOnChooseFileButton");
	     driver.manage().timeouts().implicitlyWait(600, TimeUnit.SECONDS);
	     
	     try
	     {
	    	 if(CommonUtility.CheckpresenceofElementLocated(driver, 20, obj_EsupportRetailAssetPage.ChooseFileButton()))
	    	 {
	    		 CommonUtility.ScrollTo(driver, obj_EsupportRetailAssetPage.ChooseFileButton());
	    		 CommonUtility.ClickOn(driver, obj_EsupportRetailAssetPage.ChooseFileButton());
	    		 Thread.sleep(4000);
	    		 System.out.println("Clicked on ChooseFileButton button");
	    		 
	    		 Report.put("Verify Continue button and click on ChooseFileButton button", 
	 	       			"User should click on ChooseFileButton button", 
	 	       			"User clicked on ChooseFileButton button", "Pass");
	    	 }
	     }
	     catch(Exception e)
	     {
	    	 e.printStackTrace();
	      	 Report.put("Verify Continue button and click on ChooseFileButton button", 
	       			"User should click ChooseFileButton button", 
	       			"User failed to click ChooseFileButton button", "Fail");
	      	 Assert.fail();
	     }
	}

	public void VerifyBulkTransferPage (WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 600);
        System.out.println("Entered method VerifyBulkTransferPage");
        driver.manage().timeouts().implicitlyWait(600, TimeUnit.SECONDS);
        
        try
        {
        	driver.get("https://www.dell.com/support/assets-transfer/en-us/bulktransfer");
        	
        	wait.until((ExpectedConditions.visibilityOfElementLocated(obj_EsupportRetailAssetPage.MultipleProductTransferHeaderText())));
            String headerText=driver.findElement(obj_EsupportRetailAssetPage.MultipleProductTransferHeaderText()).getText();
        	System.out.println("Displaying Header as "+headerText);
            
            System.out.println("Page Title is : "+driver.getTitle());
            if(driver.getTitle().contains("Bulk Transfer"))
            {
            	Report.put("Hit the URL https://www.dell.com/support/assets-transfer/en-us/bulktransfer", 
            			"User should land on Bulk Transfer page", 
            			"User successfully landed on "+driver.getTitle()+" page", "Pass");
            }
            else
            {
            	Report.put("Hit the URL https://www.dell.com/support/assets-transfer/en-us/bulktransfer", 
            			"User should land on Bulk Transfer page", 
            			"User failed landing on Bulk Transfer page", "Fail");
            	Assert.fail();
            	
            }
        }
        catch(Exception e)
        {
        	 e.printStackTrace();
        	 Report.put("Hit the URL https://www.dell.com/support/assets-transfer/en-us", 
         			"User should land on Ownership Transfer page", 
         			"User failed landing on Ownership Transfer page", "Fail");
        	 Assert.fail();
        }
	}
	
	//Upload File using Robot
	public void UploadFileThroughRobot(WebDriver driver, String path)
	{
		WebDriverWait wait = new WebDriverWait(driver, 600);
        System.out.println("Entered method UploadCompletedTemplate");
        driver.manage().timeouts().implicitlyWait(600, TimeUnit.SECONDS);
        
        try
        {
        	Thread.sleep(5000);
        	Robot r=new Robot();
        	
        	StringSelection s=new StringSelection(path);
        	Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s,null);
        	
        	r.keyPress(KeyEvent.VK_CONTROL);
        	r.keyPress(KeyEvent.VK_V);
        	
        	r.keyRelease(KeyEvent.VK_V);
        	r.keyRelease(KeyEvent.VK_CONTROL);
        	
        	
        	r.keyPress(KeyEvent.VK_ENTER);
        	r.keyRelease(KeyEvent.VK_ENTER);
        	Thread.sleep(10000);
        }
        catch(Exception e)
        {
       	 e.printStackTrace();
       	 Report.put("Hit the URL https://www.dell.com/support/assets-transfer/en-us", 
        			"User should land on Ownership Transfer page", 
        			"User failed landing on Ownership Transfer page", "Fail");
       	 Assert.fail();
       }
	}

    public void ClickOnUploadCompletedCSVTemplateButton(WebDriver driver)
    {
    	WebDriverWait wait = new WebDriverWait(driver, 600);
        System.out.println("Entered method ClickOnUploadCompletedCSVTemplateButton");
        driver.manage().timeouts().implicitlyWait(600, TimeUnit.SECONDS);
        
        try
        {
        	if(CommonUtility.CheckpresenceofElementLocated(driver, 20, obj_EsupportRetailAssetPage.UploadCompletedCSVButton()))
	    	 {
	    		 CommonUtility.ScrollTo(driver, obj_EsupportRetailAssetPage.UploadCompletedCSVButton());
	    		 CommonUtility.ClickOn(driver, obj_EsupportRetailAssetPage.UploadCompletedCSVButton());
	    		 Thread.sleep(4000);
	    		 System.out.println("Clicked on UploadCompletedCSV button");
	    		 
	    		 Report.put("Verify Continue button and click on UploadCompletedCSV button", 
	 	       			"User should click on UploadCompletedCSV button", 
	 	       			"User clicked on UploadCompletedCSV button", "Pass");
	    	 }	
        }
        catch(Exception e)
        {
        	e.printStackTrace();
	      	 Report.put("Verify Continue button and click on UploadCompletedCSV button", 
	       			"User should click UploadCompletedCSV button", 
	       			"User failed to click UploadCompletedCSV button", "Fail");
	      	 Assert.fail();	
        }
    }

    public void VerifyFileHasAttachedOrNot (WebDriver driver)
    {
    	WebDriverWait wait = new WebDriverWait(driver, 600);
        System.out.println("Entered method VerifyFileHasAttachedOrNot");
        driver.manage().timeouts().implicitlyWait(600, TimeUnit.SECONDS);
        
        try
        {
        	if(CommonUtility.CheckpresenceofElementLocated(driver, 20, obj_EsupportRetailAssetPage.UploadCompletedCSVButton()) &&
        			CommonUtility.CheckpresenceofElementLocated(driver, 20, obj_EsupportRetailAssetPage.ChoosedFile()))
        	{
        		String text=driver.findElement(obj_EsupportRetailAssetPage.ChoosedFile()).getText();
        		
        		if(text.contains(".csv"))
        		{
        			System.out.println("Choosen file is "+text);
        			Report.put("Verify choosen file has successfully attached or not", 
    	 	       			"File should be attached succefully", 
    	 	       			"File has attached successfully named as "+text, "Pass");
        		}
        		else
        		{
        			Report.put("Verify choosen file has successfully attached or not", 
    	 	       			"File should be attached succefully is csv form", 
    	 	       			"File does not contain csv ", "Fail");
            		Assert.fail();
        		}
        	}
        	else
        	{
        		Report.put("Verify choosen file has successfully attached or not", 
	 	       			"File should be attached succefullu", 
	 	       			"File could not be attached ", "Fail");
        		Assert.fail();
        	}
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        	Report.put("Verify choosen file has successfully attached or not", 
 	       			"File should be attached succefullu", 
 	       			"File could not be attached ", "Fail");
	      	 Assert.fail();	
        }
    }
}





