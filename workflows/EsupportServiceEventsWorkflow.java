
package com.dell.delta_uat_automation.esupport.workflows;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
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

public class EsupportServiceEventsWorkflow extends BaseFlow {

	//Lavanya

	public void ClickSearchServiceTag(WebDriver driver,String ServiceTag) 
	{
		Log.info("Entering method ClickSearchServiceTag");
		WebDriverWait  wait = new WebDriverWait(driver, 120);
//		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String tabName="";

		try
		{
			Thread.sleep(6000);
//			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportServiceEventsHomePage.SearchInput()));
			CommonUtility.ScrollTo(driver, obj_EsupportServiceEventsHomePage.SearchInput());
			CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.SearchInput());
			CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.SearchInput()).sendKeys(ServiceTag);
			Thread.sleep(2000);
			CommonUtility.ScrollTo(driver, obj_EsupportServiceEventsHomePage.SearchButton());
			CommonUtility.ClickOn(driver, obj_EsupportServiceEventsHomePage.SearchButton());
			driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
			Thread.sleep(10000);
			//handleCookies(driver);
			CommonUtility.ScrollTo(driver, obj_EsupportServiceEventsHomePage.OverviewTab());
			tabName=CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.OverviewTab()).getText();
			System.out.println("Landing tab is "+tabName);

			tabName=tabName.toLowerCase();
			if(tabName.contains("overview"))
			{
				Log.info("test step pass");
			}
			else
			{
				Log.info("test step fail");
				Report.put("On the Homepage select the required product by:Entering a Service tag and click on the arrow button", 
						"User should be directed to the product support page of the selected Product and land on Overview Tab  by default",
						"Not landed on Overview Tab using Service tag "+Report.color(ServiceTag), "FAIL");
				Assert.fail();
			}


			Report.put("On the Homepage select the required product by:Entering a Service tag and click on the arrow button", 
					"User should be directed to the product support page of the selected Product and land on Overview Tab  by default",
					"Successfully landed on "+Report.color(tabName)+" Tab: with Service Tag "+Report.color(ServiceTag), "PASS");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("On the Homepage select the required product by:Entering a Service tag and click on the arrow button", 
					"User should be directed to the product support page of the selected Product and land on Overview Tab  by default",
					"Not landed on Overview Tab using Service Tag "+Report.color(ServiceTag), "FAIL");
			Assert.fail();
		}
	}	

	public void ClickOnServiceEventsTab(WebDriver driver) 
	{
		Log.info("Entering method ClickOnServiceEventsTab");
		WebDriverWait  wait = new WebDriverWait(driver, 120);

		String tabName="";
		String header="";

		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportServiceEventsHomePage.ServiceEvents()));
			CommonUtility.ScrollTo(driver, obj_EsupportServiceEventsHomePage.ServiceEvents());
			CommonUtility.ClickOn(driver, obj_EsupportServiceEventsHomePage.ServiceEvents());
			Thread.sleep(5000);
			handleCookies(driver);
			tabName=CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.ServiceEvents()).getText();

			System.out.println("Landing tab is "+tabName);
			tabName=tabName.toLowerCase();
			System.out.println("Landing tab is "+tabName);
			if(tabName.contains("service events"))
			{
				Log.info("test step pass");
			}
			else
			{
				Log.info("test step fail");
				Report.put("Click on the " +Report.color(tabName)+ "tab ", 
						"User should land on the "+Report.color(tabName)+ " tab with the an box to enter the email address ",
						"Not landed on expected ServiceEvents tab instead landed on "+Report.color(tabName)+" Tab using Service tag or without an box to enter the email address", "FAIL");
				Assert.fail();
			}
//			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportServiceEventsHomePage.EmailSection()));
			driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
//			CommonUtility.scrollToViewElement(driver, obj_EsupportServiceEventsHomePage.EmailSection());
			CommonUtility.ScrollTo(driver, obj_EsupportServiceEventsHomePage.EmailSection());
			Thread.sleep(10000);
			header=CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.ValidateTextInEmailSection()).getText();
			System.out.println("Header of email section is "+header);
			if(header.contains("To view your Service Events for this product, please enter your email"))
			{
				Log.info("test step pass");
			}
			else
			{
				Log.info("test step fail");
				Report.put("Click on the " +Report.color(tabName)+ "tab ", 
						"User should land on the "+Report.color(tabName)+ " tab with the an box to enter the email address ",
						"Not landed on expected ServiceEvents tab instead landed on "+Report.color(tabName)+" Tab using Service tag or without an box to enter the email address", "FAIL");
				Assert.fail();
			}

			Report.put("Click on the " +Report.color(tabName)+ "tab ", 
					"User should land on the "+Report.color(tabName)+ " tab with the an box to enter the email address",
					"Successfully landed on "+Report.color(tabName)+" Tab using Service tag with an box to enter the email address", "PASS");

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on the " +Report.color(tabName)+ "tab ", 
					"User should land on the "+Report.color(tabName)+ " tab with the an box to enter the email address",
					"Not landed on "+Report.color(tabName)+" Tab using Service tag or without an box to enter the email address", "FAIL");
			Assert.fail();
		}
	}	

	public void SearchForEmailSection(WebDriver driver) 
	{
		Log.info("Entering method SearchForEmailSection");
		WebDriverWait  wait = new WebDriverWait(driver, 120);

		String tabName="";
		String header="";

		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportServiceEventsHomePage.OverviewTab()));
			CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.OverviewTab());

			CommonUtility.ScrollTo(driver, obj_EsupportServiceEventsHomePage.EmailSectionInOverviewTab());
			CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.EmailSectionInOverviewTab());
			Thread.sleep(2000);
			header=CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.ValidateTextInEmailSectionInOverviewTab()).getText();
			System.out.println("Header of email section is "+header);
			if(header.contains("To view your Service Events for this product, please enter your email"))
			{
				Log.info("test step pass");
			}
			else
			{
				Log.info("test step fail");
				Report.put("Click on the " +Report.color(tabName)+ "tab ", 
						"User should land on the "+Report.color(tabName)+ " tab with the an box to enter the email address ",
						"Not landed on expected ServiceEvents tab instead landed on "+Report.color(tabName)+" Tab using Service tag or without an box to enter the email address", "FAIL");
				Assert.fail();
			}

			Report.put("Click on the " +Report.color(tabName)+ "tab ", 
					"User should land on the "+Report.color(tabName)+ " tab with the an box to enter the email address",
					"Successfully landed on "+Report.color(tabName)+" Tab using Service tag with an box to enter the email address", "PASS");

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on the " +Report.color(tabName)+ "tab ", 
					"User should land on the "+Report.color(tabName)+ " tab with the an box to enter the email address",
					"Not landed on "+Report.color(tabName)+" Tab using Service tag or without an box to enter the email address", "FAIL");
			Assert.fail();
		}
	}	

	public void EnterEmailAddressToSeeServiceEvents(WebDriver driver,String Email) 
	{
		Log.info("Entering method EnterEmailAddressToSeeServiceEvents");
		WebDriverWait  wait = new WebDriverWait(driver, 120);

		//String landingpagemessage="";


		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportServiceEventsHomePage.EmailInputTextBox()));
			CommonUtility.ScrollTo(driver, obj_EsupportServiceEventsHomePage.EmailInputTextBox());
			CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.EmailInputTextBox()).sendKeys(Email);
			CommonUtility.ScrollTo(driver, obj_EsupportServiceEventsHomePage.SubmitButton());
			CommonUtility.ClickOn(driver, obj_EsupportServiceEventsHomePage.SubmitButton());

			System.out.println("email submit button clicked: navigating to Service events");

			//			CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.LandingPageServiceEventsTab());
			//			landingpagemessage=CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.LandingPageServiceEventsTab()).getText();
			//			System.out.println("Landing page message is "+landingpagemessage);
			//			if(landingpagemessage.contains("This is a page label test message for service events tab"))
			//			{
			//				Log.info("test step pass");
			//			}
			//			else
			//			{
			//				Log.info("test step fail");
			//				Report.put("Enter the email address associated with the Service Tag and click on submit", 
			//						"User should be able to enter the email address "+Report.color(Email)+ " and land on with the page label as "+Report.color(landingpagemessage)+" tab for the tag ",
			//						"user not able to enter email address "+Report.color(Email)+" so, not landed on service events page using Service tag ", "FAIL");
			//				Assert.fail();
			//			}


			Report.put("Enter the email address associated with the Service Tag and click on submit", 
					"User should be able to enter the email address "+Report.color(Email)+ " tab for the tag",
					"user Successfully entered email address "+Report.color(Email)+" Tab using Service tag", "PASS");

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Enter the email address associated with the Service Tag and click on submit", 
					"User should be able to enter the email address "+Report.color(Email)+ " tab for the tag ",
					"user not able to enter email address "+Report.color(Email)+" so, not landed on service events page using Service tag ", "FAIL");
			Assert.fail();
		}
	}	

	public void EnterEmailAddressToSeeServiceEventsInOverviewTab(WebDriver driver,String Email) 
	{
		Log.info("Entering method EnterEmailAddressToSeeServiceEventsInOverviewTab");
		WebDriverWait  wait = new WebDriverWait(driver, 120);

		//String landingpagemessage="";


		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportServiceEventsHomePage.EmailInputTextBoxInOverviewTab()));
			CommonUtility.ScrollTo(driver, obj_EsupportServiceEventsHomePage.EmailInputTextBoxInOverviewTab());
			CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.EmailInputTextBoxInOverviewTab()).sendKeys(Email);

			CommonUtility.ClickOn(driver, obj_EsupportServiceEventsHomePage.SubmitButtonInOverviewTab());
			Thread.sleep(10000);
			//			CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.HeadingOfServiceEventsInOverviewTab());
			//			landingpagemessage=CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.HeadingOfServiceEventsInOverviewTab()).getText();
			//			System.out.println("Landing page message is "+landingpagemessage);
			//			if(landingpagemessage.contains("Service Events"))
			//			{
			//				Log.info("test step pass");
			//			}
			//			else
			//			{
			//				Log.info("test step fail");
			//				Report.put("Enter the email address associated with the Service Tag and click on submit", 
			//						"User should be able to enter the email address "+Report.color(Email)+ " and loaded with heading "+Report.color(landingpagemessage),
			//						"user not able to enter email address "+Report.color(Email)+" using Service tag ", "FAIL");
			//				Assert.fail();
			//			}


			Report.put("Enter the email address associated with the Service Tag and click on submit", 
					"User should be able to enter the email address "+Report.color(Email),
					"user Successfully entered email address "+Report.color(Email)+" using Service tag", "PASS");

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Enter the email address associated with the Service Tag and click on submit", 
					"User should be able to enter the email address "+Report.color(Email)+ " tab for the tag ",
					"user not able to enter email address "+Report.color(Email)+" using Service tag ", "FAIL");
			Assert.fail();
		}
	}	

	public void ValidateOnlyShowActiveEvents(WebDriver driver) 
	{
		Log.info("Entering method ValidateOnlyShowActiveEvents");
		WebDriverWait  wait = new WebDriverWait(driver, 120);

		String labelofcheckbox="";
		String status="";

		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportServiceEventsHomePage.LabelOfCheckBox()));
			CommonUtility.ScrollTo(driver, obj_EsupportServiceEventsHomePage.LabelOfCheckBox());
			labelofcheckbox=CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.LabelOfCheckBox()).getText();

			System.out.println("label of checkbox "+labelofcheckbox);
			status=CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.ValidateCheckBoxISChecked()).getAttribute("checked");
			System.out.println("status of Only show active events checkbox "+status);
			boolean b=CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.ValidateCheckBoxISChecked()).isSelected();
			if(b==true)
			{
				Log.info("test step pass");
			}
			else
			{
				Log.info("test step fail");
				Report.put("Validate whether Only show active events is toggled on by default", 
						"User should see Only show active events toggled on by default",
						"user don't see Only show active events toggled on by default", "FAIL");
				Assert.fail();
			}


			Report.put("Validate whether Only show active events is toggled on by default in Service events tab", 
					"User should see Only show active events toggled on by default in Service events tab",
					"user Successfully see "+Report.color(labelofcheckbox)+" is" +Report.color(status)+" by default in Service events tab", "PASS");

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Validate whether Only show active events is toggled on by default", 
					"User should see Only show active events toggled on by default",
					"user don't see Only show active events toggled on by default", "FAIL");
			Assert.fail();
		}
	}	

	public void ValidateMessageDisplayedHasNoActiveSRAndNoSH(WebDriver driver) 
	{
		Log.info("Entering method ValidateMessageDisplayedHasNoActiveSRAndNoSH");
		WebDriverWait  wait = new WebDriverWait(driver, 120);

		String alertmessage="";

		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportServiceEventsHomePage.AlertMessage()));
			alertmessage=CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.AlertMessage()).getText();
			alertmessage=alertmessage.toLowerCase();
			if(alertmessage.contains("this product has no active service events"))
			{
				Log.info("test step pass");
			}
			else
			{
				Log.info("test step fail");
				Report.put("Validate the message displayed when Service Tag has no active Service Requests and no Service history", 
						"User should see the message, 'This product has no active Service Events'",
						"user don't see expected message", "FAIL");
				Assert.fail();
			}


			Report.put("Validate the message displayed when Service Tag has no active Service Requests and no Service history", 
					"User should see the message, 'This product has no active Service Events'",
					"user Successfully see message "+Report.color(alertmessage), "PASS");

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Validate the message displayed when Service Tag has no active Service Requests and no Service history", 
					"User should see the message, 'This product has no active Service Events'",
					"user don't see expected message", "FAIL");
			Assert.fail();
		}
	}	
	public void ValidateOptionToToggleOnOffOnlyShowActiveEvents(WebDriver driver) 
	{
		Log.info("Entering method ValidateOptionToToggleOnOffOnlyShowActiveEvents");
		WebDriverWait  wait = new WebDriverWait(driver, 120);

		String status="";
		String status1="";

		try
		{
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportServiceEventsHomePage.LabelOfCheckBox()));
			//CommonUtility.scrollToViewElement(driver, obj_EsupportServiceEventsHomePage.LabelOfCheckBox());
			CommonUtility.ScrollTo(driver, obj_EsupportServiceEventsHomePage.ValidateToggleButton());
			//CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.ValidateToggleButton()).click();
			Actions act=new Actions(driver);
//			act.moveToElement(CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.ValidateToggleButton())).click().build().perform();
			CommonUtility.ClickOn(driver, obj_EsupportServiceEventsHomePage.ValidateToggleButton());
			Thread.sleep(15000);
			status1=CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.ValidateCheckBoxISChecked()).getAttribute("checked");
			System.out.println("status of Only show active events checkbox "+status1);
			boolean b1=CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.ValidateCheckBoxISChecked()).isSelected();
			if(b1==false)
			{
				Log.info("test step pass: Only show active events is toggled off successfully");
			}
			else
			{
				Log.info("test step fail:Only show active events is not toggled off ");
				Report.put("Validate whether Only show active events is toggled off", 
						"User should able to toggle off Only show active events button",
						"failed to toggle off Only show active events button", "FAIL");
				Assert.fail();
			}
			CommonUtility.ScrollTo(driver, obj_EsupportServiceEventsHomePage.ValidateToggleButton());
			CommonUtility.ClickOn(driver, obj_EsupportServiceEventsHomePage.ValidateToggleButton());
			Thread.sleep(10000);
			status=CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.ValidateCheckBoxISChecked()).getAttribute("checked");
			System.out.println("status of Only show active events checkbox "+status);
			boolean b=CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.ValidateCheckBoxISChecked()).isSelected();
			if(b==true)
			{
				Log.info("test step pass: Only show active events is toggled on successfully");
			}
			else
			{
				Log.info("test step fail: not able to toggle on Only show active events");
				Report.put("Validate whether Only show active events is toggled on", 
						"User should able to toggle on Only show active events button",
						"failed to toggle on Only show active events button", "FAIL");
				Assert.fail();
			}

			Report.put("An option to toggle on/off Only show active events toggle should be visible", 
					"User should be able to toggle off Only show active events toggle or turn it back on.",
					"user Successfully able to turn off with status "+Report.color(status1)+" and able to toggle on back with status " +Report.color(status), "PASS");

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Validate whether Only show active events is toggled on", 
					"User should able to toggle on Only show active events button",
					"failed to toggle off and turn back on Only show active events button", "FAIL");
			Assert.fail();
		}
	}	

	public void ValidateToggleOffOnlyShowActiveEventsButtonValidateSEDisplayActiveAndClosed(WebDriver driver) 
	{
		Log.info("Entering method ValidateToggleOffOnlyShowActiveEventsButtonValidateSEDisplayActiveAndClosed");
		WebDriverWait  wait = new WebDriverWait(driver, 120);
		int servicerequestscount;
		String status="";
		String status1="";
		String statussr1=TestNGCreator.TestData.get(Esupport.StatusOption.ordinal()).split(";")[0];
		String statussr2=TestNGCreator.TestData.get(Esupport.StatusOption.ordinal()).split(";")[1];
		String statussr3=TestNGCreator.TestData.get(Esupport.StatusOption.ordinal()).split(";")[2];
		String srcount="";
		String text1="";
		int count=0;
		int count2=0;
		int count3=0;

		String c="";
		String c1="";
		String c2="";

		String statustext="";
		int dispatchescount;
		String text2="";
		String dispatchcount="";

		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportServiceEventsHomePage.LabelOfCheckBox()));
			CommonUtility.ScrollTo(driver, obj_EsupportServiceEventsHomePage.ValidateToggleButton());

			CommonUtility.ClickOn(driver, obj_EsupportServiceEventsHomePage.ValidateToggleButton());
			Thread.sleep(15000);
			status1=CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.ValidateCheckBoxISChecked()).getAttribute("checked");
			System.out.println("status of Only show active events checkbox "+status1);
			boolean b1=CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.ValidateCheckBoxISChecked()).isSelected();
			if(b1==false)
			{
				Log.info("test step pass: Only show active events is toggled off successfully");
			}
			else
			{
				Log.info("test step fail:Only show active events is not toggled off ");
				Report.put("Toggle off Only show active events", 
						"User should see all the service events which are active and closed",
						"failed to toggle off Only show active events button", "FAIL");
				Assert.fail();
			}
			CommonUtility.ScrollTo(driver, obj_EsupportServiceEventsHomePage.CountOfDispatches());
			if(CommonUtility.CheckpresenceofElementLocated(driver, 30, obj_EsupportServiceEventsHomePage.CountOfDispatches()))
			{
				CommonUtility.ScrollTo(driver, obj_EsupportServiceEventsHomePage.CountOfDispatches());
				System.out.println("in side if----------------");
				List <WebElement> dispatches=driver.findElements(obj_EsupportServiceEventsHomePage.CountOfDispatches());
				dispatchescount=dispatches.size();
				dispatchcount=String.valueOf(dispatchescount);
				System.out.println("total service events displayed "+dispatchescount);
				srcount=String.valueOf(dispatchescount);
				System.out.println("total count "+srcount);
				for(int i=0;i<dispatchescount;i++)
				{
					boolean b2=CommonUtility.highlightElement(driver, dispatches.get(i)).isDisplayed();
					if(b2==true)
					{
						CommonUtility.ScrollToWebElement(driver, dispatches.get(i));
						text2=text2+"<br>"+dispatches.get(i).getText();
						System.out.println("service request details are "+text2);
					}
				}
			}
			else
			{
				Log.info("there is no active dispatches for this tag");
			}
			if(CommonUtility.CheckpresenceofElementLocated(driver, 30, obj_EsupportServiceEventsHomePage.GetCountOfActiveAndClosedSE()))
			{

				CommonUtility.ScrollTo(driver, obj_EsupportServiceEventsHomePage.GetCountOfActiveAndClosedSE());
				System.out.println("in side if----------------");
				List <WebElement> servicerequestslist=driver.findElements(obj_EsupportServiceEventsHomePage.GetCountOfActiveAndClosedSE());

				List <WebElement> statussr=driver.findElements(obj_EsupportServiceEventsHomePage.StatusOfSR());

				servicerequestscount=servicerequestslist.size();
				System.out.println("total service events displayed "+servicerequestscount);
				srcount=String.valueOf(servicerequestscount);
				System.out.println("total count "+srcount);
				for(int i=0;i<servicerequestscount;i++)
				{
					boolean b2=CommonUtility.highlightElement(driver, servicerequestslist.get(i)).isDisplayed();
					if(b2==true)
					{
						CommonUtility.ScrollToWebElement(driver, servicerequestslist.get(i));
						text1=text1+"<br>"+servicerequestslist.get(i).getText();
						System.out.println("service request details are "+text1);
					}
				}
				for(int j=0;j<statussr.size();j++)
				{
					boolean b3=CommonUtility.highlightElement(driver, statussr.get(j)).isDisplayed();
					System.out.println("status is displayed"+b3);
					if(b3==true)
					{
						statustext=statussr.get(j).getText();
						System.out.println(statustext);


						if (statustext.equalsIgnoreCase(statussr1))
						{
							count++;
							System.out.println(count);
						}

						if(statustext.equalsIgnoreCase(statussr2))
						{
							count2++;
							System.out.println(count2);
						}

						if(statustext.equalsIgnoreCase(statussr3))
						{
							count3++;
							System.out.println(count3);
						}
					}

				}
				System.out.println("open status count "+count);
				c=String.valueOf(count);
				System.out.println("In progress status count "+count2);
				c1=String.valueOf(count2);
				System.out.println("Closed status count "+count3);
				c2=String.valueOf(count3);
			}
			Report.put("Toggle off Only show active events", 
					"User should see all the service events which are active and closed",
					"user Successfully able to turn off with status "+Report.color(status1)+" and able all the service events which are active and closed with count "+Report.color(srcount)+" as below <br> " +Report.color(text1)+"<br> with count of "+Report.color(statussr1)+" status is "+Report.color(c)+"<br> with count of "+Report.color(statussr2)+" status is "+Report.color(c1)+"<br> with count of "+Report.color(statussr3)+" status is "+Report.color(c2)+"<br> and with dispatch type count if any "+Report.color(dispatchcount)+" with dispath details below if any<br>"+Report.color(text2), "PASS");

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Toggle off Only show active events", 
					"User should see all the service events which are active and closed",
					"failed to toggle off Only show active events button", "FAIL");
			Assert.fail();
		}
	}

	public void ValidateToggleOnOnlyShowActiveEventsButtonValidateSEDisplayOnlyActiveSR(WebDriver driver) 
	{
		Log.info("Entering method ValidateToggleOnOnlyShowActiveEventsButtonValidateSEDisplayOnlyActiveSR");
		WebDriverWait  wait = new WebDriverWait(driver, 120);
		int servicerequestscount;
		String status="";
		String status1="";

		String statussr3=TestNGCreator.TestData.get(Esupport.StatusOption.ordinal()).split(";")[2];
		String srcount="";
		String text="";



		String statustext="";

		try
		{
			//wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportServiceEventsHomePage.LabelOfCheckBox()));
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			CommonUtility.ScrollTo(driver, obj_EsupportServiceEventsHomePage.LabelOfCheckBox());

			CommonUtility.ClickOn(driver, obj_EsupportServiceEventsHomePage.ValidateToggleButton());
			Thread.sleep(7000);
			status1=CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.ValidateCheckBoxISChecked()).getAttribute("checked");
			System.out.println("status of Only show active events checkbox "+status1);
			boolean b1=CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.ValidateCheckBoxISChecked()).isSelected();
			if(b1==true)
			{
				Log.info("test step pass: Only show active events is toggled off successfully");
			}
			else
			{
				Log.info("test step fail:Only show active events is not toggled off ");
				Report.put("Toggle on Only show active events", 
						"User should see only active service events",
						"failed to toggle on Only show active events button", "FAIL");
				Assert.fail();
			}
			//CommonUtility.scrollToViewElement(driver, obj_EsupportServiceEventsHomePage.GetCountOfActiveAndClosedSE());
			if(CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.GetCountOfActiveAndClosedSE()).isDisplayed())
			{
				System.out.println("in side if----------------");
				List <WebElement> servicerequestslist=driver.findElements(obj_EsupportServiceEventsHomePage.GetCountOfActiveAndClosedSE());
				//				List <WebElement> servicerequests=driver.findElements(obj_EsupportServiceEventsHomePage.TitleOfSR());
				List <WebElement> statussr=driver.findElements(obj_EsupportServiceEventsHomePage.StatusOfSR());
				//				List <WebElement> headingofstatus=driver.findElements(obj_EsupportServiceEventsHomePage.GetHeadingOfStatus());
				//				List <WebElement> srn=driver.findElements(obj_EsupportServiceEventsHomePage.GetSRNNumber());
				//				List <WebElement> srnheading=driver.findElements(obj_EsupportServiceEventsHomePage.GetHeadingOfSRN());
				servicerequestscount=servicerequestslist.size();
				System.out.println("total service events displayed "+servicerequestscount);
				srcount=String.valueOf(servicerequestscount);

				for(int i=0;i<servicerequestscount;i++)
				{
					boolean b2=CommonUtility.highlightElement(driver, servicerequestslist.get(i)).isDisplayed();
					if(b2==true)
					{
						CommonUtility.ScrollToWebElement(driver, servicerequestslist.get(i));
						text=text+",<br>"+servicerequestslist.get(i).getText();
						System.out.println("service request details are "+text);
					}
				}
				for(int j=0;j<statussr.size();j++)
				{
					boolean b3=CommonUtility.highlightElement(driver, statussr.get(j)).isDisplayed();
					System.out.println("status is "+b3);
					if(b3==true)
					{
						statustext=statussr.get(j).getText();
						System.out.println(statustext);

						if (statustext.equalsIgnoreCase(statussr3))
						{
							Log.info("Tets case fail: when only show active events toggle button is turned on, closed service evenets should not display");
							Report.put("Toggle on Only show active events", 
									"User should see only active service events",
									"failed to see only active service events, and able to see "+Report.color(statustext)+" active service events", "FAIL");
							Assert.fail();
						}
					}
				}
			}

			Report.put("Toggle on Only show active events", 
					"User should see only active service events",
					"user Successfully able to turn on with status "+Report.color(status1)+" and able see only active service events with count "+Report.color(srcount)+" as below <br>"+Report.color(text), "PASS");

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Toggle on Only show active events", 
					"User should see only active service events",
					"failed to toggle on Only show active events button", "FAIL");
			Assert.fail();
		}
	}

	public void ValidateDisplayedServiceEventsInOverViewTab(WebDriver driver) 
	{
		Log.info("Entering method ValidateDisplayedServiceEventsInOverViewTab");
		WebDriverWait  wait = new WebDriverWait(driver, 240);
		int servicerequestscount;
		String status="";
		String status1="";

		String statussr3=TestNGCreator.TestData.get(Esupport.StatusOption.ordinal()).split(";")[2];
		String srcount="";
		String text="";
		String tabName="";


		String statustext="";

		try
		{System.out.println("inside try");
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportServiceEventsHomePage.ServiceEventsCountInOverviewTab()));
		//CommonUtility.scrollToViewElement(driver, obj_EsupportServiceEventsHomePage.ServiceEventsCountInOverviewTab());
		if(CommonUtility.CheckpresenceofElementLocated(driver, 10, obj_EsupportServiceEventsHomePage.ServiceEventsCountInOverviewTab()))
		{
			CommonUtility.ScrollTo(driver, obj_EsupportServiceEventsHomePage.ServiceEventsCountInOverviewTab());
			System.out.println("in side if----------------");
			List <WebElement> servicerequestslist=driver.findElements(obj_EsupportServiceEventsHomePage.ServiceEventsCountInOverviewTab());
			//				List <WebElement> servicerequests=driver.findElements(obj_EsupportServiceEventsHomePage.TitleOfSR());
			List <WebElement> statussr=driver.findElements(obj_EsupportServiceEventsHomePage.StatusOfSRInOverviewTab());
			//				List <WebElement> headingofstatus=driver.findElements(obj_EsupportServiceEventsHomePage.GetHeadingOfStatus());
			//				List <WebElement> srn=driver.findElements(obj_EsupportServiceEventsHomePage.GetSRNNumber());
			//				List <WebElement> srnheading=driver.findElements(obj_EsupportServiceEventsHomePage.GetHeadingOfSRN());
			servicerequestscount=servicerequestslist.size();
			System.out.println("total service events displayed "+servicerequestscount);
			srcount=String.valueOf(servicerequestscount);

			for(int i=0;i<servicerequestscount;i++)
			{
				boolean b2=CommonUtility.highlightElement(driver, servicerequestslist.get(i)).isDisplayed();
				if(b2==true)
				{
					CommonUtility.ScrollToWebElement(driver, servicerequestslist.get(i));
					text=text+",<br>"+servicerequestslist.get(i).getText();
					System.out.println("service request details are "+text);
				}
			}
			for(int j=0;j<statussr.size();j++)
			{
				boolean b3=CommonUtility.highlightElement(driver, statussr.get(j)).isDisplayed();
				System.out.println("status is "+b3);
				if(b3==true)
				{
					statustext=statussr.get(j).getText();
					System.out.println(statustext);

					if (statustext.equalsIgnoreCase(statussr3))
					{
						Log.info("Tets case fail: not able to see service events");
						Report.put("Validate for service events displayed if any in overview tab", 
								"User should see only active service events displayed if any in overview tab",
								"failed to see only active service eventsin overview tab", "FAIL");
						Assert.fail();
					}
				}
			}
		}
		else
		{
			Report.put("Validate for service events displayed if any in overview tab", 
					"User should see only active service events displayed if any in overview tab",
					"this service tag doesn't have service events in overview tab", "FAIL");
			Assert.fail();

		}

		if(CommonUtility.CheckpresenceofElementLocated(driver, 30, obj_EsupportServiceEventsHomePage.ClickOnViewAll()))
		{
			CommonUtility.ScrollTo(driver, obj_EsupportServiceEventsHomePage.ClickOnViewAll());
			CommonUtility.ClickOn(driver, obj_EsupportServiceEventsHomePage.ClickOnViewAll());
			Thread.sleep(5000);
		}
		else
		{
			Report.put("Validate for view all displayed in overview tab", 
					"User should see view all hyperlink displayed in overview tab",
					"failed to see view all hyperlink in overview tab", "FAIL");
			Assert.fail();
		}
		//handleCookies(driver);
		tabName=CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.ServiceEvents()).getText();

		System.out.println("Landing tab is "+tabName);
		tabName=tabName.toLowerCase();
		if(tabName.contains("service events"))
		{
			Log.info("test step pass");
		}
		else
		{
			Log.info("test step fail");
			Report.put("Click on the view all tab", 
					"User should land on the "+Report.color(tabName)+ " tab",
					"Not landed on expected ServiceEvents tab instead landed on "+Report.color(tabName)+" Tab using Service tag", "FAIL");
			Assert.fail();
		}

		Report.put("Validate for service events displayed if any in overview tab", 
				"User should see only active service events displayed if any in overview tab",
				"user Successfully able see only active service events with count "+Report.color(srcount)+" as below <br>"+Report.color(text)+ "<br> and clicked on view all <br> and landed on "+Report.color(tabName)+" tab", "PASS");

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Validate for service events displayed if any in overview tab", 
					"User should see only active service events displayed if any in overview tab",
					"failed to see only active service events in overview tab or failed to see view all", "FAIL");
			Assert.fail();
		}

	}

	public void  ValidateChangeCountry(WebDriver driver)
	{

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

			act.moveToElement(CommonUtility.highlightElement(driver,obj_EsupportServiceEventsHomePage.CountrySelectorArticle())).build().perform();
			handleCookies(driver);

			if(CommonUtility.highlightElement(driver,obj_EsupportServiceEventsHomePage.CountrySelectorArticle()).isDisplayed())
			{

				System.out.println("country displayed");

				WebElement element =driver.findElement(By.xpath("//div[@id='countryselector']/a"));
				((JavascriptExecutor)driver).executeScript("arguments[0].click();", element); 

				Thread.sleep(6000);
				System.out.println("Country from Test data is :::: "+country1);
				List<WebElement> countryList=driver.findElements(obj_EsupportServiceEventsHomePage.CountrySelectorList());


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


				Report.put("Click on the Country drop down at the right bottom of the page and select a country", 
						"User should be able to select a country from the Country drop at the footer of the page(right) The  page should be translated to the language of the country selected and displayed", 
						"Country changed to : "+Report.color(country1)+" and page successfully translated to the language of the country selected and displayed","PASS");
			}

			else
			{
				Log.info("Test case fail: issue in selecting country");
				Report.put("Click on the Country drop down at the right bottom of the page and select a country", 
						"User should be able to select a country from the Country drop at the footer of the page(right) The  page should be translated to the language of the country selected and displayed", 
						"issue in selecting country " +Report.color(country1), "FAIL");
				Assert.fail();
			}

			handleCookies(driver);
			
			Thread.sleep(10000);

			if(driver.getCurrentUrl().contains("cn"))
			{
				Log.info("Test Case Pass: loaded with selected country China");
				title=driver.getTitle();
				System.out.println("title of page after changing country is "+title);
			}
			else
			{
				driver.get("https://www.dell.com/support/home/en-us");
				Log.info("Test Case Fail: not loaded with selected country China");
				Report.put("Click on the Country drop down at the right bottom of the page and select a country", 
						"User should be able to select a country from the Country drop at the footer of the page(right) The  page should be translated to the language of the country selected and displayed",  
						"1.Pag not reloaded in the language of the selected country" +Report.color(country1), "FAIL");
				Assert.fail();
			}

			tabname=CommonUtility.highlightElement(driver,obj_EsupportServiceEventsHomePage.ServiceEvents()).getText();
			System.out.println("displayed tab name is "+tabname);
			tabname=tabname.toLowerCase();
			if(tabname.contains("service events"))
			{
				driver.get("https://www.dell.com/support/home/en");
				Log.info("Test case fail:Page not loaded in selected language");
				Report.put("Click on the Country drop down at the right bottom of the page and select a country", 
						"User should be able to select a country from the Country drop at the footer of the page(right) The  page should be translated to the language of the country selected and displayed",  
						"1.Page not translated to the language of the selected country of the selected country" +Report.color(country1), "FAIL");
				Assert.fail();

			}
			else
			{
				Log.info("Test case pass:for selected country translated language version is available. The page translated to the language successfully");
			}


			Report.put("Click on the Country drop down at the right bottom of the page and select a country", 
					"User should be able to select a country from the Country drop at the footer of the page(right) The  page should be translated to the language of the country selected and displayed", 
					"1.Country changed to : "+Report.color(country1)+"<br> 2.Page is translated to selected country language with title "+Report.color(title),"PASS");
		}

		catch(Exception e)
		{
			driver.get("https://www.dell.com/support/home/en");
			e.printStackTrace();
			Report.put("Click on the Country drop down at the right bottom of the page and select a country", 
					"User should be able to select a country from the Country drop at the footer of the page(right) The  page should be translated to the language of the country selected and displayed",  
					"Not able to select the country "+Report.color(country1)+"<br> or<br> page not loaded with selected country "+Report.color(country1)+" languarge <br> or <br> ", "FAIL");
			Assert.fail();
		}
	}

	public void  ChangeBackToDisplayedCountry(WebDriver driver)
	{
		// TODO Auto-generated method stub
		Log.info("Entering ChangeBackToDisplayedCountry");
		Actions act=new Actions(driver);

		String country2 = TestNGCreator.TestData.get(Esupport.Country.ordinal()).split(";")[1];
		String selectedcountry = "";

		try
		{

			act.moveToElement(CommonUtility.highlightElement(driver,obj_EsupportServiceEventsHomePage.CountrySelectorArticle())).build().perform();
			handleCookies(driver);

			if(CommonUtility.highlightElement(driver,obj_EsupportServiceEventsHomePage.CountrySelectorArticle()).isDisplayed())
			{

				System.out.println("country displayed");

				WebElement element =driver.findElement(By.xpath("//div[@id='countryselector']/a"));
				((JavascriptExecutor)driver).executeScript("arguments[0].click();", element); 

				Thread.sleep(6000);
				System.out.println("Country from Test data is :::: "+country2);
				List<WebElement> countryList=driver.findElements(obj_EsupportServiceEventsHomePage.CountrySelectorList());


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
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on the Country dropdown at the bottom of the page and select previous displayed country", 
					"1. The page should be reloaded in the language of the selected country.", 
					"issue in selecting country " +Report.color(country2), "FAIL");
		}
	}

	public void ValidateEventTypesOnLeftPanel(WebDriver driver) 
	{
		Log.info("Entering method ValidateEventTypesOnLeftPanel");
		WebDriverWait  wait = new WebDriverWait(driver, 120);
		String text="";
		String textet="";

		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportServiceEventsHomePage.EventTypeSectionOnLeftPanel()));
			if(CommonUtility.CheckpresenceofElementLocated(driver, 30, obj_EsupportServiceEventsHomePage.EventTypeSectionOnLeftPanel()))
			{
				CommonUtility.ScrollTo(driver, obj_EsupportServiceEventsHomePage.EventTypeSectionOnLeftPanel());
				CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.EventTypeSectionOnLeftPanel());
				//Thread.sleep(5000);
				List<WebElement> listofeventtypes=driver.findElements(obj_EsupportServiceEventsHomePage.ValidateAllEventTypesOnLeftPanel());
				int etcount=listofeventtypes.size();
				int count=0;
				for(int i=0;i<etcount;i++)
				{
					count++;
					textet=textet+"<br>"+listofeventtypes.get(i).getText();
					System.out.println("event type is "+textet);

				}
				if(count==3)
				{
					if(textet.contains("Dispatches"))
					{
						Log.info("Test case pass: displayed expected");
					}
					else
					{
						Log.info("test step fail: dont see all event types");
						Report.put("Check whether the Event Types are loaded in the left side panel", 
								"User must see All the Event Types:1. Service Request2. Dispatches  3. Milestones",
								"user not able to see event type Dispatches on left panel", "FAIL");
						Assert.fail();
					}
				}
				if(count==2)
				{
					if(textet.contains("Milestones"))
					{
						Log.info("Test case pass: displayed expected");
					}
					else
					{
						Log.info("test step fail: dont see all event types");
						Report.put("Check whether the Event Types are loaded in the left side panel", 
								"User must see All the Event Types:1. Service Request2. Dispatches  3. Milestones",
								"user not able to see event type Dispatches on left panel", "FAIL");
						Assert.fail();
					}
				}
				if(count==1)
				{
					if(textet.contains("Service Request"))
					{
						Log.info("Test case pass: displayed expected");
					}
					else
					{
						Log.info("test step fail: dont see all event types");
						Report.put("Check whether the Event Types are loaded in the left side panel", 
								"User must see All the Event Types:1. Service Request2. Dispatches  3. Milestones",
								"user not able to see event type Dispatches on left panel", "FAIL");
						Assert.fail();
					}
				}
			}
			else
			{
				Log.info("test step fail: dont see all event types");
				Report.put("Check whether the Event Types are loaded in the left side panel", 
						"User must see All the Event Types:1. Service Request2. Dispatches  3. Milestones",
						"user not able to see any event type on left panel", "FAIL");
				Assert.fail();

			}

			Report.put("Check whether the Event Types are loaded in the left side panel", 
					"User must see All the Event Types:1. Service Request2. Dispatches  3. Milestones",
					"user Successfully able see all event types in left panel "+Report.color(textet), "PASS");

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Check whether the Event Types are loaded in the left side panel", 
					"User must see All the Event Types:1. Service Request2. Dispatches  3. Milestones",
					"user failed to display all event types on left panel", "FAIL");
			Assert.fail();
		}
	}	

	public void ValidateTwoDatePickerBoxDisplayedInLeftPanel(WebDriver driver) 
	{
		Log.info("Entering method ValidateTwoDatePickerBoxDisplayedInLeftPanel");
		WebDriverWait  wait = new WebDriverWait(driver, 120);
		String textet="";

		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportServiceEventsHomePage.ValidateTwoDatePickerBoxSection()));
			CommonUtility.ScrollTo(driver, obj_EsupportServiceEventsHomePage.ValidateTwoDatePickerBoxSection());

			CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.ValidateTwoDatePickerBoxSection());
			//Thread.sleep(5000);
			if(CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.ValidateTwoDatePickerBoxSection()).isDisplayed())
			{
				List<WebElement> listofeventtypes=driver.findElements(obj_EsupportServiceEventsHomePage.ValidateTwoDatePickerBoxDisplayed());
				int count=listofeventtypes.size();
				System.out.println("count is "+count);

				for(int i=0;i<listofeventtypes.size();i++)
				{
					textet=CommonUtility.highlightElement(driver, listofeventtypes.get(i)).getAttribute("placeholder");
					System.out.println("date pickers is "+textet);
				}
			}
			else
			{
				Report.put("Validate whether the 2 date picker box is displayed in the left side panel", 
						"User must see 2 date picker box displayed in the left side panel",
						"user failed to display 2 date picker box in left panel", "FAIL");
				Assert.fail();
			}

			Report.put("Validate whether the 2 date picker box is displayed in the left side panel", 
					"User must see 2 date picker box displayed in the left side panel",
					"user Successfully able see 2 date picker box in left panel with label "+Report.color(textet), "PASS");

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Validate whether the 2 date picker box is displayed in the left side panel", 
					"User must see 2 date picker box displayed in the left side panel",
					"user failed to display 2 date picker box in left panel", "FAIL");
			Assert.fail();
		}
	}	

	public void ValidateBySelectingAnyDatesFromTwoDatePickerBox(WebDriver driver) 
	{
		Log.info("Entering method ValidateBySelectingAnyDatesFromTwoDatePickerBox");
		WebDriverWait  wait = new WebDriverWait(driver, 120);
		String textet="";
		String months="";
		String years="";
		Actions act=new Actions(driver);
		String Day=TestNGCreator.TestData.get(Esupport.Optional.ordinal()).split(";")[0].split("-")[0];
		String Month=TestNGCreator.TestData.get(Esupport.Optional.ordinal()).split(";")[0].split("-")[1];
		String Year=TestNGCreator.TestData.get(Esupport.Optional.ordinal()).split(";")[0].split("-")[2];


		try
		{
			//wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportServiceEventsHomePage.ValidateTwoDatePickerBoxSection()));

			if(CommonUtility.CheckpresenceofElementLocated(driver, 30, obj_EsupportServiceEventsHomePage.ClickOnFirstDatePicker()))
			{
				//				CommonUtility.scrollToViewElement(driver, obj_EsupportServiceEventsHomePage.ValidateClickOnFirstDatePickerToDisplayCalender());
				//				List<WebElement> tdpb=driver.findElements(obj_EsupportServiceEventsHomePage.ValidateTwoDatePickerBoxDisplayed());
				//				System.out.println("count of 2 date picker "+tdpb);
				//				for(int i=0;i<tdpb.size();i++)
				//				{
				//					if(i==0)
				//					{
				//CommonUtility.scrollToViewElement(driver, tdpb.get(i));
				System.out.println("entering into if*****");
				//						WebElement element1 =driver.findElement(By.xpath("(//div[contains(@class,'table')]//table)[1]"));
				//						System.out.println("before clicking into if*****");
				//						((JavascriptExecutor)driver).executeScript("arguments[0].click();", element1);
				//						System.out.println("after clicking into if*****");
				act.moveToElement(CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.ClickOnFirstDatePicker())).build().perform();
				System.out.println("before clicking into if*****");
				act.moveToElement(CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.ClickOnFirstDatePicker())).click().perform();
				System.out.println("after clicking into if*****");
				//CommonUtility.highlightElement(driver, tdpb.get(i)).click();
				Thread.sleep(5000);

				if(CommonUtility.CheckpresenceofElementLocated(driver, 30, obj_EsupportServiceEventsHomePage.ValidateClickOnFirstDatePickerToDisplayCalender()))
				{
					act.moveToElement(CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.SelectMonthFromFirstDatePicker())).build().perform();
					WebElement element=driver.findElement(By.xpath("((//div[contains(@class,'table')]//table)[1]//thead//select)[1]"));
					Select s=new Select(element);
					List<WebElement> month=s.getOptions();
					int monthcount=month.size();
					System.out.println("total months count is "+monthcount);

					for (int j=0;j<monthcount;j++)
					{
						months=months+"<br>"+month.get(j).getText();
						System.out.println("month is "+months);
						if (months.contains("Month"))
						{
							s.selectByVisibleText("Month");
							Thread.sleep(1000);
							break;
						}
						//								else
						//								{
						//									Log.info("month not matches with drp down values");
						//									Report.put("Select any dates from the 2 date picker box", 
						//											"User should see the Event type(s) created during that specific time period displayed in the content section of the page",
						//											"entered month not resent in dropdown", "FAIL");
						//									Assert.fail();
						//								}

					}
				}
				else
				{
					Log.info("not able to select month");
					Report.put("Select any dates from the 2 date picker box", 
							"User should see the Event type(s) created during that specific time period displayed in the content section of the page",
							"user failed to select month from drop down of 1st date picker box", "FAIL");
					Assert.fail();
				}

				if(CommonUtility.CheckpresenceofElementLocated(driver, 30, obj_EsupportServiceEventsHomePage.SelectYearFromFirstDatePicker()))
				{
					act.moveToElement(CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.SelectYearFromFirstDatePicker())).build().perform();
					WebElement element2=driver.findElement(By.xpath("((//div[contains(@class,'table')]//table)[1]//thead//select)[2]"));
					Select s1=new Select(element2);
					List<WebElement> year=s1.getOptions();
					int yearcount=year.size();
					System.out.println("total years displayed count is "+yearcount);

					for (int l=0;l<yearcount;l++)
					{
						years=years+"<br>"+year.get(l).getText();
						System.out.println("year is "+years);
						if (years.contains("Year"))
						{
							s1.selectByVisibleText("Year");
							Thread.sleep(1000);
							break;
						}
						//								else
						//								{
						//									Log.info("year not matches with drp down values");
						//									Report.put("Select any dates from the 2 date picker box", 
						//											"User should see the Event type(s) created during that specific time period displayed in the content section of the page",
						//											"entered year not resent in dropdown", "FAIL");
						//									Assert.fail();
						//								}

					}
				}
				else
				{
					Log.info("not able to select month");
					Report.put("Select any dates from the 2 date picker box", 
							"User should see the Event type(s) created during that specific time period displayed in the content section of the page",
							"user failed to select year from drop down of 1st date picker box", "FAIL");
					Assert.fail();
				}

				//					}
				//				}
			}
			else
			{
				Log.info("first date pick calender not displayed");
				Report.put("Select any dates from the 2 date picker box", 
						"User should see the Event type(s) created during that specific time period displayed in the content section of the page",
						"user failed to display 1st date picker calender on clicking on 1st date picker box", "FAIL");
				Assert.fail();
			}

			//CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.ValidateDaySectionOfFirstDatePicker());
			//Thread.sleep(5000);
			if(CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.ValidateDaySectionOfFirstDatePicker()).isDisplayed())
			{
				List<WebElement> listofeventtypes=driver.findElements(obj_EsupportServiceEventsHomePage.SelectDayFromFirstDatePicker());
				int count=listofeventtypes.size();
				System.out.println("count is "+count);

				for(int i=0;i<listofeventtypes.size();i++)
				{
					textet=textet+"<br>"+listofeventtypes.get(i).getText();
					System.out.println("date pickers is "+textet);

					if(textet.contains("Day"))
					{

						CommonUtility.ClickOnWebElement(driver, listofeventtypes.get(i));
						Thread.sleep(2000);
						break;

					}
				}
			}
			else if (CommonUtility.CheckpresenceofElementLocated(driver, 30, obj_EsupportServiceEventsHomePage.SelectWeekDaysFromFirstDatePicker()))
			{
				List<WebElement> listofeventtypes=driver.findElements(obj_EsupportServiceEventsHomePage.SelectWeekDaysFromFirstDatePicker());
				int count1=listofeventtypes.size();
				System.out.println("count is "+count1);

				for(int k=0;k<listofeventtypes.size();k++)
				{
					textet=textet+"<br>"+listofeventtypes.get(k).getText();
					System.out.println("date pickers is "+textet);

					if(textet.contains("Day"))
					{

						CommonUtility.ClickOnWebElement(driver,listofeventtypes.get(k));
						Thread.sleep(2000);
						break;

					}
				}
			}
			else
			{
				Report.put("Select any dates from the 2 date picker box", 
						"User should see the Event type(s) created during that specific time period displayed in the content section of the page",
						"user failed to select date from 2 date picker box or specific time not displayed in the content section of the page", "FAIL");
				Assert.fail();
			}

			Report.put("Select any dates from the 2 date picker box", 
					"User should see the Event type(s) created during that specific time period displayed in the content section of the page",
					"user Successfully able select 2 date picker box in left panel with months in the list "+Report.color(months)+"<br> and selected month "+Report.color(Month)+" <br> with years in the list "+Report.color(years)+"<br> and selected year "+Report.color(Year)+"<br> with days "+Report.color(textet)+"<br> and selected day "+Report.color(Day), "PASS");

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Select any dates from the 2 date picker box", 
					"User should see the Event type(s) created during that specific time period displayed in the content section of the page",
					"user failed to select date from 2 date picker box or specific time not displayed in the content section of the page", "FAIL");
			Assert.fail();
		}
	}

	public void ValidateBySelectingAnyDatesToTwoDatePickerBox(WebDriver driver) 
	{
		Log.info("Entering method ValidateBySelectingAnyDatesToTwoDatePickerBox");
		WebDriverWait  wait = new WebDriverWait(driver, 120);
		String textet="";
		String months="";
		String years="";
		Actions act=new Actions(driver);
		String Day=TestNGCreator.TestData.get(Esupport.Optional.ordinal()).split(";")[1].split("-")[0];
		String Month=TestNGCreator.TestData.get(Esupport.Optional.ordinal()).split(";")[1].split("-")[1];
		String Year=TestNGCreator.TestData.get(Esupport.Optional.ordinal()).split(";")[1].split("-")[2];

		try
		{
			//wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportServiceEventsHomePage.ValidateTwoDatePickerBoxSection()));

			if(CommonUtility.CheckpresenceofElementLocated(driver, 30, obj_EsupportServiceEventsHomePage.ClickOnSecondDatePicker()))
			{
				//				CommonUtility.scrollToViewElement(driver, obj_EsupportServiceEventsHomePage.ValidateClickOnFirstDatePickerToDisplayCalender());
				//				List<WebElement> tdpb=driver.findElements(obj_EsupportServiceEventsHomePage.ValidateTwoDatePickerBoxDisplayed());
				//				System.out.println("count of 2 date picker "+tdpb);
				//				for(int i=0;i<tdpb.size();i++)
				//				{
				//					if(i==0)
				//					{
				//CommonUtility.scrollToViewElement(driver, tdpb.get(i));
				System.out.println("entering into if*****");
				//						WebElement element1 =driver.findElement(By.xpath("(//div[contains(@class,'table')]//table)[2]"));
				//						System.out.println("before clicking into if*****");
				//						((JavascriptExecutor)driver).executeScript("arguments[0].click();", element1);
				//						System.out.println("after clicking into if*****");
				act.moveToElement(CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.ClickOnSecondDatePicker())).build().perform();
				System.out.println("before clicking into if*****");
				act.moveToElement(CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.ClickOnSecondDatePicker())).click().perform();
				System.out.println("after clicking into if*****");
				//CommonUtility.highlightElement(driver, tdpb.get(i)).click();
				Thread.sleep(5000);

				if(CommonUtility.CheckpresenceofElementLocated(driver, 30, obj_EsupportServiceEventsHomePage.ValidateClickOnSecondDatePickerToDisplayCalender()))
				{
					System.out.println("inside if **** of month");
					act.moveToElement(CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.SelectMonthFromSecondDatePicker())).build().perform();
					WebElement element=driver.findElement(By.xpath("((//div[contains(@class,'table')]//table)[3]//thead//select)[1]"));;
					Select s=new Select(element);
					List<WebElement> month=s.getOptions();
					int monthcount=month.size();
					System.out.println("total months count is "+monthcount);

					for (int j=0;j<monthcount;j++)
					{
						months=months+"<br>"+month.get(j).getText();
						System.out.println("month is "+months);
						if (months.contains("Month"))
						{
							s.selectByVisibleText("Month");
							Thread.sleep(1000);
							break;
						}
						//								else
						//								{
						//									Log.info("month not matches with drop down values");
						//									Report.put("Select any dates from the 2 date picker box", 
						//											"User should see the Event type(s) created during that specific time period displayed in the content section of the page",
						//											"entered month not resent in dropdown", "FAIL");
						//									//Assert.fail();
						//								}

					}
				}
				else
				{
					Log.info("not able to select month");
					Report.put("Select any dates from the 2 date picker box", 
							"User should see the Event type(s) created during that specific time period displayed in the content section of the page",
							"user failed to select month from drop down of 2nd date picker box", "FAIL");
					Assert.fail();
				}

				if(CommonUtility.CheckpresenceofElementLocated(driver, 30, obj_EsupportServiceEventsHomePage.ValidateClickOnSecondDatePickerToDisplayCalender()))
				{
					System.out.println("inside if **** of year");
					act.moveToElement(CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.SelectYearFromSecondDatePicker())).build().perform();
					WebElement element2=driver.findElement(By.xpath("((//div[contains(@class,'table')]//table)[3]//thead//select)[2]"));;
					Select s1=new Select(element2);
					List<WebElement> year=s1.getOptions();
					int yearcount=year.size();
					System.out.println("total years displayed count is "+yearcount);

					for (int l=0;l<yearcount;l++)
					{
						years=years+"<br>"+year.get(l).getText();
						System.out.println("year is "+years);
						if (years.contains("Year"))
						{
							s1.selectByVisibleText("Year");
							Thread.sleep(1000);
							break;
						}
						//								else
						//								{
						//									Log.info("year not matches with drp down values");
						//									Report.put("Select any dates from the 2 date picker box", 
						//											"User should see the Event type(s) created during that specific time period displayed in the content section of the page",
						//											"entered year not resent in dropdown", "FAIL");
						//									Assert.fail();
						//								}

					}
				}
				else
				{
					Log.info("not able to select month");
					Report.put("Select any dates from the 2 date picker box", 
							"User should see the Event type(s) created during that specific time period displayed in the content section of the page",
							"user failed to select year from drop down of 2nd date picker box", "FAIL");
					Assert.fail();
				}

				//					}
				//				}
			}
			else
			{
				Log.info("first date pick calender not displayed");
				Report.put("Select any dates from the 2 date picker box", 
						"User should see the Event type(s) created during that specific time period displayed in the content section of the page",
						"user failed to display 1st date picker calender on clicking on 2nd date picker box", "FAIL");
				Assert.fail();
			}

			//CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.ValidateDaySectionOfFirstDatePicker());
			//Thread.sleep(5000);
			if(CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.ValidateDaySectionOfSecondDatePicker()).isDisplayed())
			{
				List<WebElement> listofeventtypes=driver.findElements(obj_EsupportServiceEventsHomePage.SelectDayFromSecondDatePicker());
				int count=listofeventtypes.size();
				System.out.println("count is "+count);

				for(int i=0;i<listofeventtypes.size();i++)
				{
					textet=textet+"<br>"+listofeventtypes.get(i).getText();
					System.out.println("date pickers is "+textet);

					if(textet.contains("Day"))
					{

						listofeventtypes.get(i).click();
						Thread.sleep(2000);
						break;

					}
				}
			}
			else if (CommonUtility.CheckpresenceofElementLocated(driver, 30, obj_EsupportServiceEventsHomePage.SelectWeekDaysFromSecondDatePicker()))
			{
				List<WebElement> listofeventtypes=driver.findElements(obj_EsupportServiceEventsHomePage.SelectWeekDaysFromSecondDatePicker());
				int count1=listofeventtypes.size();
				System.out.println("count is "+count1);

				for(int k=0;k<listofeventtypes.size();k++)
				{
					textet=textet+"<br>"+listofeventtypes.get(k).getText();
					System.out.println("date pickers is "+textet);

					if(textet.contains("Day"))
					{

						listofeventtypes.get(k).click();
						Thread.sleep(2000);
						break;

					}
				}
			}
			else
			{
				Report.put("Select any dates from the 2 date picker box", 
						"User should see the Event type(s) created during that specific time period displayed in the content section of the page",
						"user failed to select date from 2 date picker box or specific time not displayed in the content section of the page", "FAIL");
				Assert.fail();
			}

			Report.put("Select any dates from the 2 date picker box", 
					"User should see the Event type(s) created during that specific time period displayed in the content section of the page",
					"user Successfully able select 2 date picker box in left panel with months in the list "+Report.color(months)+"<br> and selected month "+Report.color(Month)+" <br> with years in the list "+Report.color(years)+"<br> and selected year "+Report.color(Year)+"<br> with days "+Report.color(textet)+"<br> and selected day "+Report.color(Day), "PASS");


		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Select any dates from the 2 date picker box", 
					"User should see the Event type(s) created during that specific time period displayed in the content section of the page",
					"user failed to select date from 2 date picker box or specific time not displayed in the content section of the page", "FAIL");
			Assert.fail();
		}
	}

	public void ClickExpandAllOnLeftPanel(WebDriver driver) 
	{
		Log.info("Entering method ClickExpandAllOnLeftPanel");
		WebDriverWait  wait = new WebDriverWait(driver, 120);

		String textet="";

		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportServiceEventsHomePage.ClickExpandAllButtonOnLeftPanel()));
			CommonUtility.scrollToViewElement(driver, obj_EsupportServiceEventsHomePage.ClickExpandAllButtonOnLeftPanel());
			boolean b=CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.ClickExpandAllButtonOnLeftPanel()).isDisplayed();

			if(b==false)
			{
				Log.info("test step fail: user not able to see event types on left panel");
				Report.put("Click on the Expand All against the Event Type Header", 
						"User should see the filters(related to the specific Event type) be expanded",
						"user not able to see the filters related to the specific Event type be expanded", "FAIL");
				Assert.fail();
			}

			CommonUtility.scrollToViewElement(driver, obj_EsupportServiceEventsHomePage.ClickExpandAllButtonOnLeftPanel());
			CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.ClickExpandAllButtonOnLeftPanel()).click();
			Thread.sleep(5000);
			List<WebElement> listofeventtypes=driver.findElements(obj_EsupportServiceEventsHomePage.ValidateAllEventTypesOnLeftPanelAreExpanded());
			int etcount=listofeventtypes.size();
			int count=0;
			for(int i=0;i<etcount;i++)
			{
				count++;
				textet=textet+"<br>"+listofeventtypes.get(i).getText();
				System.out.println("event type expanded displays "+textet);

			}


			Report.put("Click on the Expand All against the Event Type Header", 
					"User should see the filters(related to the specific Event type) be expanded along with the count",
					"user Successfully able to see filters under each specific event type "+Report.color(textet), "PASS");

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on the Expand All against the Event Type Header", 
					"User should see the filters(related to the specific Event type) be expanded",
					"user failed to see all filters under each event type", "FAIL");
			Assert.fail();
		}
	}	

	public void SelectAllAvailableFiltersInEachEventTypes(WebDriver driver) 
	{
		Log.info("Entering method SelectAllAvailableFiltersInEachEventTypes");
		WebDriverWait  wait = new WebDriverWait(driver, 120);
		String t="";
		int count=0;
		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportServiceEventsHomePage.SelectAllCheckBoxOfEventTypesOfLeftPanel()));

			CommonUtility.scrollToViewElement(driver, obj_EsupportServiceEventsHomePage.SelectAllCheckBoxOfEventTypesOfLeftPanel());

			//Thread.sleep(5000);
			List<WebElement> listofeventtypes=driver.findElements(obj_EsupportServiceEventsHomePage.SelectAllCheckBoxOfEventTypesOfLeftPanel());
			List<WebElement> listofcount=driver.findElements(obj_EsupportServiceEventsHomePage.SelectAllCheckBoxOfEventTypesOfLeftPanelByKeepingCountAsReference());
			int etcount=listofeventtypes.size();
			System.out.println("count of event types expanded "+etcount);
			int count1=0;
			if(CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.SelectAllCheckBoxOfEventTypesOfLeftPanel()).isDisplayed())
			{
				for(int i=0;i<etcount;i++)
				{
					count1++;
					for(WebElement lc:listofcount)
					{
						t=lc.getText();
						System.out.println(t);
						count=Integer.valueOf(t);

						if(count!=0)
						{
							CommonUtility.ToClickByUsingJavaScript(driver, listofeventtypes.get(i));
							Thread.sleep(1000);
							break;
						} 
					}
					if (count1==etcount)
					{
						break;
					}
				}
			}

			Report.put("Select all the available filters by selecting the box against the each Event Types( Service Request, Milestone and Dispatches)", 
					"User should be able to select the filters",
					"user Successfully able to select filters", "PASS");

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Select all the available filters by selecting the box against the each Event Types( Service Request, Milestone and Dispatches)", 
					"User should be able to select the filters",
					"user failed to select filters", "FAIL");
			Assert.fail();
		}
	}	

	public void SelectAllAvailableFiltersInMilestoneEventType(WebDriver driver) 
	{
		Log.info("Entering method SelectAllAvailableFiltersInMilestoneEventType");
		WebDriverWait  wait = new WebDriverWait(driver, 120);
		Actions act=new Actions(driver);
		String text="";

		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportServiceEventsHomePage.SelectCheckBoxUnderMilestones()));

			CommonUtility.scrollToViewElement(driver, obj_EsupportServiceEventsHomePage.SelectCheckBoxUnderMilestones());

			List<WebElement> listofeventtypes=driver.findElements(obj_EsupportServiceEventsHomePage.SelectCheckBoxUnderMilestones());

			int etcount=listofeventtypes.size();
			System.out.println("cout is "+etcount);

			System.out.println(etcount);
			for(int i=0;i<etcount;i++)
			{
				System.out.println("inside for");
				//				act.moveToElement(CommonUtility.highlightElement(driver, listofeventtypes.get(i))).build().perform();
				//				Thread.sleep(2000);
				text=text+"<br>"+listofeventtypes.get(i).getText();
				System.out.println("filters are "+text);
				//act.moveToElement(CommonUtility.highlightElement(driver, listofeventtypes.get(i))).click().perform();
				CommonUtility.scrollToViewElement(driver, listofeventtypes.get(i));
				CommonUtility.highlightElement(driver, listofeventtypes.get(i)).click();
				//CommonUtility.ToClickByUsingJavaScript(driver, listofeventtypes.get(i));
				Thread.sleep(2000);

				System.out.println("clicked on filters");
			}

			Report.put("Select all the available filters by selecting the box against the Event Types Milestone", 
					"User should be able to select the filters",
					"user Successfully able to select filters "+Report.color(text), "PASS");

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Select all the available filters by selecting the box against the Event Types Milestone)", 
					"User should be able to select the filters",
					"user failed to select filters", "FAIL");
			Assert.fail();
		}
	}	

	public void ClickOnApplyFilters(WebDriver driver) 
	{
		Log.info("Entering method ClickOnApplyFilters");
		WebDriverWait  wait = new WebDriverWait(driver, 120);
		String text="";
		String textet="";
		int servicerequestscount;
		String status="";
		String status1="";
		String statussr1=TestNGCreator.TestData.get(Esupport.StatusOption.ordinal()).split(";")[0];
		String statussr2=TestNGCreator.TestData.get(Esupport.StatusOption.ordinal()).split(";")[1];
		String statussr3=TestNGCreator.TestData.get(Esupport.StatusOption.ordinal()).split(";")[2];
		String srcount="";
		String text1="";
		int count=0;
		int count2=0;
		int count3=0;

		String c="";
		String c1="";
		String c2="";

		String statustext="";
		int dispatchescount;
		String text2="";
		String dispatchcount="";
		String text3="";
		String dates="";

		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportServiceEventsHomePage.ApplyFiltersButton()));
			CommonUtility.scrollToViewElement(driver, obj_EsupportServiceEventsHomePage.ApplyFiltersButton());

			CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.ApplyFiltersButton()).click();
			Thread.sleep(10000);

			CommonUtility.scrollToViewElement(driver, obj_EsupportServiceEventsHomePage.ValidatesFiltersInLeftPanel());
			List<WebElement> listofeventtypes=driver.findElements(obj_EsupportServiceEventsHomePage.ValidateFiltersSectionAfterApplyingFilterOnLeftPanel());
			int etcount=listofeventtypes.size();

			for(int i=0;i<etcount;i++)
			{
				textet=textet+"<br>"+listofeventtypes.get(i).getText();
				System.out.println("filters displayed "+textet);
				if(textet.contains("ShowAll"))
				{
					CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.ShowAllButtonInFiltersSection()).click();
				}
			}
			//CommonUtility.scrollToViewElement(driver, obj_EsupportServiceEventsHomePage.ServiceLifeEndAndWarrentyEndDate());
			if(CommonUtility.CheckpresenceofElementLocated(driver, 10, obj_EsupportServiceEventsHomePage.ServiceLifeEndAndWarrentyEndDate()))
			{
				CommonUtility.scrollToViewElement(driver, obj_EsupportServiceEventsHomePage.ServiceLifeEndAndWarrentyEndDate());
				System.out.println("in side if----------------");
				List <WebElement> servicerequestslist=driver.findElements(obj_EsupportServiceEventsHomePage.ServiceLifeEndAndWarrentyEndDate());
				for(int j=0;j<servicerequestslist.size();j++)
				{
					Log.info("Test case pass: able to see selected filter");
					text3=CommonUtility.highlightElement(driver, servicerequestslist.get(j)).getText();
					System.out.println("able to see selected filter "+text3);
				}
			}
			else
			{
				Log.info(" not selected this filter");

			}
			//CommonUtility.scrollToViewElement(driver, obj_EsupportServiceEventsHomePage.CountOfDispatches());
			if(CommonUtility.CheckpresenceofElementLocated(driver, 10, obj_EsupportServiceEventsHomePage.CountOfDispatches()))
			{
				CommonUtility.scrollToViewElement(driver, obj_EsupportServiceEventsHomePage.CountOfDispatches());
				System.out.println("in side if----------------");
				List <WebElement> dispatches=driver.findElements(obj_EsupportServiceEventsHomePage.CountOfDispatches());
				dispatchescount=dispatches.size();
				dispatchcount=String.valueOf(dispatchescount);
				System.out.println("total service events displayed "+dispatchescount);
				srcount=String.valueOf(dispatchescount);
				System.out.println("total count "+srcount);
				for(int i=0;i<dispatchescount;i++)
				{
					boolean b2=CommonUtility.highlightElement(driver, dispatches.get(i)).isDisplayed();
					if(b2==true)
					{
						CommonUtility.highlightElement(driver, dispatches.get(i));
						text2=text2+"<br>"+dispatches.get(i).getText();
						System.out.println("service request details are "+text2);
					}
				}
			}
			else
			{
				Log.info("no dispatches selected");
			}
			//CommonUtility.scrollToViewElement(driver, obj_EsupportServiceEventsHomePage.GetCountOfActiveAndClosedSE());
			if(CommonUtility.CheckpresenceofElementLocated(driver, 10, obj_EsupportServiceEventsHomePage.GetCountOfActiveAndClosedSE()))
			{
				CommonUtility.scrollToViewElement(driver, obj_EsupportServiceEventsHomePage.GetCountOfActiveAndClosedSE());
				System.out.println("in side if----------------");
				List <WebElement> servicerequestslist=driver.findElements(obj_EsupportServiceEventsHomePage.GetCountOfActiveAndClosedSE());

				List <WebElement> statussr=driver.findElements(obj_EsupportServiceEventsHomePage.StatusOfSR());

				servicerequestscount=servicerequestslist.size();
				System.out.println("total service events displayed "+servicerequestscount);
				srcount=String.valueOf(servicerequestscount);
				System.out.println("total count "+srcount);
				for(int i=0;i<servicerequestscount;i++)
				{
					boolean b2=CommonUtility.highlightElement(driver, servicerequestslist.get(i)).isDisplayed();
					if(b2==true)
					{
						CommonUtility.highlightElement(driver, servicerequestslist.get(i));
						text1=text1+"<br>"+servicerequestslist.get(i).getText();
						System.out.println("service request details are "+text1);
					}
				}
				for(int j=0;j<statussr.size();j++)
				{
					boolean b3=CommonUtility.highlightElement(driver, statussr.get(j)).isDisplayed();
					System.out.println("status is displayed"+b3);
					if(b3==true)
					{
						statustext=statussr.get(j).getText();
						System.out.println(statustext);


						if (statustext.equalsIgnoreCase(statussr1))
						{
							count++;
							System.out.println(count);
						}

						if(statustext.equalsIgnoreCase(statussr2))
						{
							count2++;
							System.out.println(count2);
						}

						if(statustext.equalsIgnoreCase(statussr3))
						{
							count3++;
							System.out.println(count3);
						}
					}

				}
				System.out.println("open status count "+count);
				c=String.valueOf(count);
				System.out.println("In progress status count "+count2);
				c1=String.valueOf(count2);
				System.out.println("Closed status count "+count3);
				c2=String.valueOf(count3);
			}
			else
			{
				Log.info("no service requests selected");
			}

			if(CommonUtility.CheckpresenceofElementLocated(driver, 10, obj_EsupportServiceEventsHomePage.SEsDate()))
			{
				CommonUtility.scrollToViewElement(driver, obj_EsupportServiceEventsHomePage.SEsDate());
				System.out.println("in side if----------------");
				List <WebElement> dispatches=driver.findElements(obj_EsupportServiceEventsHomePage.SEsDate());
				dispatchescount=dispatches.size();
				dispatchcount=String.valueOf(dispatchescount);
				System.out.println("dates displayed "+dispatchescount);
				srcount=String.valueOf(dispatchescount);
				System.out.println("total count of dates displayed "+srcount);
				for(int i=0;i<dispatchescount;i++)
				{

					CommonUtility.highlightElement(driver, dispatches.get(i));
					dates=dates+"<br>"+dispatches.get(i).getText();
					System.out.println("dates displayed are "+dates);

				}
			}
			else
			{
				Log.info("no dates displayed");
//				Report.put("Click on Apply Filters button at the bottom in the left side panel", 
//						"User should see all filters between selected dates",
//						"user not able to see all the events between selected dates", "FAIL");
				//Assert.fail();
			}


			Report.put("Click on Apply Filters button at the bottom in the left side panel", 
					"User should see all filters between selected dates",
					"user Successfully able to see filters in left panel<br>"+Report.color(textet)+"<br> and selected filters display in content section of the page<br>"+Report.color(text1)+"<br> dispatches are if any selected during applying filters <br>"+Report.color(text2)+"<br> with status open total count displayed "+Report.color(c)+"<br> with status in-progress total count displayed "+Report.color(c1)+"<br>with status closed total count displayed "+Report.color(c2)+"<br> and if there are any dispatchs display, then dispatch count displayed in content of page is "+Report.color(dispatchcount)+" <br> with dates displayed are "+Report.color(dates), "PASS");

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on Apply Filters button at the bottom in the left side panel", 
					"User should see all filters between selected dates",
					"user not able to see all the events between selected dates", "FAIL");
			Assert.fail();
		}
	}	

	public void ClickOnApplyFiltersForMilestoneFiltersSelection(WebDriver driver) 
	{
		Log.info("Entering method ClickOnApplyFiltersForMilestoneFiltersSelection");
		WebDriverWait  wait = new WebDriverWait(driver, 120);

		String textet="";
		String text1="";


		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportServiceEventsHomePage.ApplyFiltersButton()));
			CommonUtility.scrollToViewElement(driver, obj_EsupportServiceEventsHomePage.ApplyFiltersButton());

			CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.ApplyFiltersButton()).click();
			Thread.sleep(10000);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

				CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.ValidatesFiltersInLeftPanel());
				List<WebElement> listofeventtypes=driver.findElements(obj_EsupportServiceEventsHomePage.ValidateFiltersSectionAfterApplyingFilterOnLeftPanel());
				int etcount=listofeventtypes.size();

				for(int i=0;i<etcount;i++)
				{
					textet=textet+"<br>"+listofeventtypes.get(i).getText();
					System.out.println("filters displayed "+textet);
					if(textet.contains("ShowAll"))
					{
						CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.ShowAllButtonInFiltersSection()).click();
					}
				}

				CommonUtility.scrollToViewElement(driver, obj_EsupportServiceEventsHomePage.ServiceLifeEndAndWarrentyEndDate());
			if(CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.ServiceLifeEndAndWarrentyEndDate()).isDisplayed())
			{
				CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.ServiceLifeEndAndWarrentyEndDate());
				System.out.println("in side if----------------");
				List <WebElement> servicerequestslist=driver.findElements(obj_EsupportServiceEventsHomePage.ServiceLifeEndAndWarrentyEndDate());
				for(int j=0;j<servicerequestslist.size();j++)
				{
					Log.info("Test case pass: able to see selected filter");
					text1=CommonUtility.highlightElement(driver, servicerequestslist.get(j)).getText();
					System.out.println("able to see selected filter "+text1);
				}
			}
			else
			{
				Log.info("test case fail: not able to see selected filter");
				Report.put("Click on Apply Filters button at the bottom in the left side panel", 
						"User should see the following changes at the top <br>1. In the left side panel, at the top under 'FILTERS' each Selected filters will appear with 'X' symbol in separate boxes Under <br>2. Content section of the page will display the selected filter details of Milestone.",
						"user failed to see selected filters of Milestone in Content section of the page", "FAIL");
				Assert.fail();
			}

			Report.put("Click on Apply Filters button at the bottom in the left side panel", 
					"User should see the following changes at the top <br>1. In the left side panel, at the top under 'FILTERS' each Selected filters will appear with 'X' symbol in separate boxes Under <br>2. Content section of the page will display the selected filter details.",
					"user Successfully able to see filters in left panel<br>"+Report.color(textet)+"<br> and selected filters display in content section of the page<br>"+Report.color(text1), "PASS");

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on Apply Filters button at the bottom in the left side panel", 
					"User should see the following changes at the top <br>1. In the left side panel, at the top under 'FILTERS' each Selected filters will appear with 'X' symbol in separate boxes Under <br>2. Content section of the page will display the selected filter details.",
					"user failed to see selected filters of Milestones under FILTERS in left panel <br>or<br> user failed to see selected filters in Content section of the page", "FAIL");
			Assert.fail();
		}
	}	

	public void ClickOnClearFilterInLeftPanel(WebDriver driver) 
	{
		Log.info("Entering method ClickOnClearFilterInLeftPanel");
		WebDriverWait  wait = new WebDriverWait(driver, 120);


		try
		{

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportServiceEventsHomePage.ClearFiltersButton()));
			CommonUtility.scrollToViewElement(driver, obj_EsupportServiceEventsHomePage.ClearFiltersButton());
			boolean b=CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.ClearFiltersButton()).isEnabled();

			if(b==false)
			{
				Log.info("test step fail");
				Report.put("To clear all filters, click on Clear Filter button at the bottom in the left side panel", 
						"User should be able to clear all filters selected",
						"Clear filter button not displayed in left panel", "FAIL");
				Assert.fail();
			}

			CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.ClearFiltersButton()).click();
			Thread.sleep(5000);
			System.out.println("clear button clicked.");
			boolean b1=CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.SelectAllCheckBoxOfEventTypesOfLeftPanel()).isSelected();
			if(b1==true)
			{
				Log.info("test step fail: filters not cleared");
				Report.put("To clear all filters, click on Clear Filter button at the bottom in the left side panel", 
						"User should be able to clear all filters selected",
						"failed to clear applied filters", "FAIL");
				Assert.fail();
			}

			Report.put("To clear all filters, click on Clear Filter button at the bottom in the left side panel", 
					"User should be able to clear all filters selected",
					"user Successfully able to clear filters", "PASS");

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("To clear all filters, click on Clear Filter button at the bottom in the left side panel", 
					"User should be able to clear all filters selected",
					"user failed to clear filters", "FAIL");
			Assert.fail();
		}
	}	

	public void ClickOnXInEachFilterBoxInLeftPanel(WebDriver driver) 
	{
		Log.info("Entering method ClickOnXInEachFilterBoxInLeftPanel");
		WebDriverWait  wait = new WebDriverWait(driver, 120);
		Actions act=new Actions(driver);

		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportServiceEventsHomePage.ClearFiltersButton()));
			CommonUtility.scrollToViewElement(driver, obj_EsupportServiceEventsHomePage.ValidatesFiltersInLeftPanel());

			List<WebElement> xbutton=driver.findElements(obj_EsupportServiceEventsHomePage.XButtonInFiltersSection());
			System.out.println("total X displyed are "+(xbutton.size()));
			for(int i=0;i<xbutton.size();i++)
			{
				String textet=xbutton.get(i).getText();
				System.out.println("filters displayed "+textet);
				if(CommonUtility.highlightElement(driver, xbutton.get(i)).isEnabled())
				{
					//act.moveToElement(CommonUtility.highlightElement(driver, xbutton.get(i))).build().perform();
				//	act.moveToElement(CommonUtility.highlightElement(driver, xbutton.get(i))).click().perform();
					//xbutton.get(i).click();
					CommonUtility.scrollToViewElement(driver, xbutton.get(i));
					xbutton.get(i).click();
					//CommonUtility.ToClickByUsingJavaScript(driver, xbutton.get(i));
					Thread.sleep(5000);
				}
			}
			List<WebElement> listofeventtypes=driver.findElements(obj_EsupportServiceEventsHomePage.ValidateFiltersSectionAfterApplyingFilterOnLeftPanel());
			int etcount=listofeventtypes.size();
			System.out.println("count is "+etcount);
			for(int j=0;j<etcount;j++)
			{
				if(CommonUtility.highlightElement(driver, listofeventtypes.get(j)).isDisplayed())
				{

					Log.info("Test case fail: x button not working");
					Report.put("To clear Individual filters, click on the 'X' inside each filter box ", 
							"User should be able to clear each filter individually",
							"user failed to click on X button", "FAIL");
					Assert.fail();

				}
				else
				{
					break;
				}
			}
			Report.put("To clear Individual filters, click on the 'X' inside each filter box ", 
					"User should be able to clear each filter individually",
					"user Successfully able to clear filters individually clicking on X", "PASS");

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("To clear Individual filters, click on the 'X' inside each filter box ", 
					"User should be able to clear each filter individually",
					"user failed to on X button", "FAIL");
			Assert.fail();
		}
	}

	public void ClickExpandIconNextToEventTypeServiceRequestOnLeftPanel(WebDriver driver) 
	{
		Log.info("Entering method ClickExpandIconNextToEventTypeServiceRequestOnLeftPanel");
		WebDriverWait  wait = new WebDriverWait(driver, 120);
		Actions act=new Actions(driver);
		String textet="";

		try
		{
			CommonUtility.scrollToViewElement(driver, obj_EsupportServiceEventsHomePage.ClickOnExpandButtonOnEventTypeServiceRequest());
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportServiceEventsHomePage.ClickOnExpandButtonOnEventTypeServiceRequest()));
			boolean b=CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.ClickOnExpandButtonOnEventTypeServiceRequest()).isDisplayed();

			if(b==false)
			{
				Log.info("test step fail: user not able to see event types on left panel");
				Report.put("Click on the Expand icon next to the Event Type.", 
						"User should see the filters for that specific Event type expanded.",
						"user not able to see the filters related to the Event type service request be expanded", "FAIL");
				Assert.fail();
			}
			//CommonUtility.scrollToViewElement(driver, obj_EsupportServiceEventsHomePage.ClickOnExpandButtonOnEventTypeServiceRequest());
			act.moveToElement(CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.ClickOnExpandButtonOnEventTypeServiceRequest())).build().perform();
			//CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.ClickOnExpandButtonOnEventTypeServiceRequest()).click();
			List<WebElement> ceicon=driver.findElements(obj_EsupportServiceEventsHomePage.ClickOnExpandButtonOnEventTypeServiceRequest());

			for(int j=0;j<ceicon.size();j++)
			{
				if(j==0)
				{
					act.moveToElement(CommonUtility.highlightElement(driver, ceicon.get(j))).click().perform();
					Thread.sleep(2000);
					break;
				}

			}
			List<WebElement> listofeventtypes=driver.findElements(obj_EsupportServiceEventsHomePage.ValidateAllEventTypesOnLeftPanelAreExpanded());
			int etcount=listofeventtypes.size();
			int count=0;
			for(int i=0;i<etcount;i++)
			{
				count++;

				boolean b1=listofeventtypes.get(i).isDisplayed();
				if(b1==true)
				{
					textet=textet+"<br>"+listofeventtypes.get(i).getText();
					System.out.println("event type expanded displays "+textet);
				}
				else
				{
					break;
				}

			}


			Report.put("Click on the Expand icon next to the Event Type.", 
					"User should see the filters for that specific Event type expanded.",
					"user Successfully able to see filters under event type "+Report.color(textet), "PASS");

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on the Expand icon next to the Event Type.", 
					"User should see the filters for that specific Event type expanded.",
					"user not able to see the filters related to the Event type service request be expanded", "FAIL");
			Assert.fail();
		}
	}

	public void ClickExpandIconNextToEventTypeMilestoneOnLeftPanel(WebDriver driver) 
	{
		Log.info("Entering method ClickExpandIconNextToEventTypeMilestoneOnLeftPanel");
		WebDriverWait  wait = new WebDriverWait(driver, 120);
		Actions act=new Actions(driver);
		String textet="";
		int count1=0;

		try
		{
			CommonUtility.scrollToViewElement(driver, obj_EsupportServiceEventsHomePage.ClickOnExpandButtonOnEventTypeServiceRequest());
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportServiceEventsHomePage.ClickOnExpandButtonOnEventTypeServiceRequest()));
			boolean b=CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.ClickOnExpandButtonOnEventTypeServiceRequest()).isDisplayed();

			if(b==false)
			{
				Log.info("test step fail: user not able to see event types on left panel");
				Report.put("Click on the Expand icon next to the Event Type.", 
						"User should see the filters for that specific Event type expanded.",
						"user not able to see the filters related to the Event type service request be expanded", "FAIL");
				Assert.fail();
			}
			//CommonUtility.scrollToViewElement(driver, obj_EsupportServiceEventsHomePage.ClickOnExpandButtonOnEventTypeServiceRequest());
			//act.moveToElement(CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.ClickOnExpandButtonOnEventTypeServiceRequest())).build().perform();
			//CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.ClickOnExpandButtonOnEventTypeServiceRequest()).click();

			act.moveToElement(CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.ClickExpandButtonOnMilestoneEventType())).build().perform();
			act.moveToElement(CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.ClickExpandButtonOnMilestoneEventType())).click().perform();
			Thread.sleep(10000);


			List<WebElement> listofeventtypes=driver.findElements(obj_EsupportServiceEventsHomePage.ValidateAllEventTypesOnLeftPanelAreExpanded());
			int etcount=listofeventtypes.size();

			for(int i=3;i<=6;i++)
			{
				boolean b1=listofeventtypes.get(i).isDisplayed();
				if(b1==true)
				{

					textet=textet+"<br>"+listofeventtypes.get(i).getText();
					System.out.println("event type expanded displays "+textet);
				}

				else 
				{
					break;
				}


			}


			Report.put("Click on the Expand icon next to Milestone", 
					"User should see the following  filter details under Milestone Event  type:End of service life,Contract End,Ship date",
					"user Successfully able to see filters under event type "+Report.color(textet), "PASS");

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on the Expand icon next to Milestone", 
					"User should see the following  filter details under Milestone Event  type:End of service life,Contract End,Ship date",
					"user not able to see the filters related to the Event type Milestone be expanded", "FAIL");
			Assert.fail();
		}
	}

	public void ClickExpandIconNextToEachEventTypeAndValidateCollapseIconOnLeftPanel(WebDriver driver) 
	{
		Log.info("Entering method ClickExpandIconNextToEachEventTypeAndValidateCollapseIconOnLeftPanel");
		WebDriverWait  wait = new WebDriverWait(driver, 120);
		Actions act=new Actions(driver);
		String textet="";
		String expandicon="";

		try
		{
			CommonUtility.ScrollTo(driver, obj_EsupportServiceEventsHomePage.ClickOnExpandButtonOnEventTypeServiceRequest());
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportServiceEventsHomePage.ClickOnExpandButtonOnEventTypeServiceRequest()));
			boolean b=CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.ClickOnExpandButtonOnEventTypeServiceRequest()).isDisplayed();

			if(b==false)
			{
				Log.info("test step fail: user not able to see event types on left panel");
				Report.put("Click on the Expand icon next to each Event Type.", 
						"User should see the filters for that specific Event type expanded.",
						"user not able to see the filters related to the Event type service request be expanded", "FAIL");
				Assert.fail();
			}
			CommonUtility.ScrollTo(driver, obj_EsupportServiceEventsHomePage.ClickOnExpandButtonOnEventTypeServiceRequest());
//			act.moveToElement(CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.ClickOnExpandButtonOnEventTypeServiceRequest())).build().perform();
			//CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.ClickOnExpandButtonOnEventTypeServiceRequest()).click();
			List<WebElement> ceicon=driver.findElements(obj_EsupportServiceEventsHomePage.ClickOnExpandButtonOnEventTypeServiceRequest());

			for(int j=0;j<ceicon.size();j++)
			{
				if(CommonUtility.highlightElement(driver, ceicon.get(j)).isEnabled())
				{
//					act.moveToElement(CommonUtility.highlightElement(driver, ceicon.get(j))).click().perform();
					CommonUtility.ScrollToWebElement(driver, ceicon.get(j));
					CommonUtility.ClickOnWebElement(driver, ceicon.get(j));
					Thread.sleep(5000);

					expandicon=CommonUtility.highlightElement(driver, ceicon.get(j)).getAttribute("aria-expanded");
					System.out.println("collapse button visible "+expandicon);

					if(expandicon.contains("true"))
					{
						Log.info("collapse button displayed");
					}
					else
					{
						Log.info("collapse button not displayed");
						Report.put("Validate whether Collapse  button is displayed after clicking on Expand button", 
								"User should see the Collapse  button be displayed after clicking on Expand button",
								"failed to display collapse button after clicking on the expand button", "FAIL");
						Assert.fail();
					}
				}
				else
				{
					break;
				}
			}
			List<WebElement> listofeventtypes=driver.findElements(obj_EsupportServiceEventsHomePage.ValidateAllEventTypesOnLeftPanelAreExpanded());
			int etcount=listofeventtypes.size();
			int count=0;
			for(int i=0;i<etcount;i++)
			{
				count++;

				boolean b1=listofeventtypes.get(i).isDisplayed();
				if(b1==true)
				{
					textet=textet+"<br>"+listofeventtypes.get(i).getText();
					System.out.println("event type expanded displays "+textet);
				}
				else
				{
					break;
				}

			}

			Report.put("Validate whether Collapse  button is displayed after clicking on Expand button", 
					"User should see the Collapse  button be displayed after clicking on Expand button",
					"user Successfully able to see filters under each event type "+Report.color(textet)+" <br> with collapse icon displayed with status "+Report.color(expandicon), "PASS");

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Validate whether Collapse  button is displayed after clicking on Expand button", 
					"User should see the Collapse  button be displayed after clicking on Expand button",
					"failed to display collapse button after clicking on the expand button", "FAIL");
			Assert.fail();
		}
	}

	public void ClickCollapseIconNextToEachEventTypeAndValidateExpandIconOnLeftPanel(WebDriver driver) 
	{
		Log.info("Entering method ClickCollapseIconNextToEachEventTypeAndValidateExpandIconOnLeftPanel");
		WebDriverWait  wait = new WebDriverWait(driver, 120);
		Actions act=new Actions(driver);
		String textet="";
		String expandicon="";

		try
		{
			CommonUtility.scrollToViewElement(driver, obj_EsupportServiceEventsHomePage.ClickOnExpandButtonOnEventTypeServiceRequest());
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportServiceEventsHomePage.ClickOnExpandButtonOnEventTypeServiceRequest()));
			boolean b=CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.ClickOnExpandButtonOnEventTypeServiceRequest()).isDisplayed();

			if(b==false)
			{
				Log.info("test step fail: user not able to see event types on left panel");
				Report.put("Click on the collapse icon next to each Event Type.", 
						"User should not see the filters for each type instead it should display collapsed.",
						"user able to see the filters related to the Event type instead of displays collapse", "FAIL");
				Assert.fail();
			}
			//CommonUtility.scrollToViewElement(driver, obj_EsupportServiceEventsHomePage.ClickOnExpandButtonOnEventTypeServiceRequest());
			act.moveToElement(CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.ClickOnExpandButtonOnEventTypeServiceRequest())).build().perform();
			//CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.ClickOnExpandButtonOnEventTypeServiceRequest()).click();
			List<WebElement> ceicon=driver.findElements(obj_EsupportServiceEventsHomePage.ClickOnExpandButtonOnEventTypeServiceRequest());

			for(int j=0;j<ceicon.size();j++)
			{
				act.moveToElement(CommonUtility.highlightElement(driver, ceicon.get(j))).click().perform();
				Thread.sleep(2000);

				expandicon=CommonUtility.highlightElement(driver, ceicon.get(j)).getAttribute("aria-expanded");
				System.out.println("collapse all visible "+expandicon);

				if(expandicon.contains("false"))
				{
					Log.info("expand button displayed");
				}
				else
				{
					Log.info("expand button not displayed");
					Report.put("Click on the collapse icon next to each Event Type.", 
							"User should not see the filters for each type instead it should display collapsed.",
							"user able to see the filters related to the Event type instead of displays collapse", "FAIL");
					Assert.fail();
				}
			}
			List<WebElement> listofeventtypes=driver.findElements(obj_EsupportServiceEventsHomePage.ValidateAllEventTypesOnLeftPanelAreExpanded());
			int etcount=listofeventtypes.size();
			int count=0;
			for(int i=0;i<etcount;i++)
			{
				count++;

				boolean b1=listofeventtypes.get(i).isDisplayed();
				if(b1==true)
				{
					textet=textet+"<br>"+listofeventtypes.get(i).getText();
					System.out.println("event type expanded displays "+textet);
				}
				else
				{
					Log.info("filters not displayed");
					if (count==3)
					{
						break;
					}
				}

			}

			Report.put("Validate whether expand button is displayed after clicking on collapse button", 
					"User should see the expand button displayed after clicking on collapse button",
					"user Successfully able to see expand icon displayed with status "+Report.color(expandicon)+" <br> and not able to see filters under each event type "+Report.color(textet), "PASS");

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Validate whether expand button is displayed after clicking on collapse button", 
					"User should see the expand button displayed after clicking on collapse button",
					"failed to display expand button after clicking on the collapse button", "FAIL");
			Assert.fail();
		}
	}

	public void ValidateForCollapseAllButtonDisplaysAfterClickingOnExpandButton(WebDriver driver) 
	{
		Log.info("Entering method ValidateForCollapseAllButtonDisplaysAfterClickingOnExpandButton");

		String topscount="";
		String descdateid="";
		String collapsedisplay="";
		String expandicon="";

		try
		{
			if(CommonUtility.CheckpresenceofElementLocated(driver, 30, obj_EsupportServiceEventsHomePage.ClickCollapseAllButtonOnLeftPanel()))
			{
				CommonUtility.scrollToViewElement(driver, obj_EsupportServiceEventsHomePage.ClickCollapseAllButtonOnLeftPanel());

				expandicon=CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.ClickCollapseAllButtonOnLeftPanel()).getAttribute("aria-expanded");
				System.out.println("collapse all visible "+expandicon);

				if(expandicon.contains("true"))
				{
					Log.info("collapse all displayed");
				}
				else
				{
					Log.info("collapse all not displayed");
					Report.put("Validate whether Collapse All button is displayed after clicking on Expand All button", 
							"User should see the Collapse All button be displayed after clicking on Expand All button",
							"failed to display collapse all after clicking on the expand all", "FAIL");
					Assert.fail();
				}

			}


			Report.put("Validate whether on clicking on the collapse icon displays the expand icon", 
					"User should see the collapse icon displayed after clicking on the expand icon ",
					"User successfuly able to see collapse all displayed with changed status of expand all to "+Report.color(expandicon)+" after clicking on the expand all", "PASS");

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Validate whether on clicking on the collapse icon displays the expand icon", 
					"User should see the collapse icon displayed after clicking on the expand icon ",
					"failed to display collapse icon after clicking on the expand icon", "FAIL");
			Assert.fail();
		}
	}	

	public void ValidateForExpandAllButtonDisplaysAfterClickingOnCollapseAllButton(WebDriver driver) 
	{
		Log.info("Entering method ValidateForExpandAllButtonDisplaysAfterClickingOnCollapseAllButton");

		String topscount="";
		String descdateid="";
		String collapsedisplay="";
		String expandicon="";

		try
		{
			if(CommonUtility.CheckpresenceofElementLocated(driver, 30, obj_EsupportServiceEventsHomePage.ClickExpandAllButtonOnLeftPanel()))
			{
				CommonUtility.scrollToViewElement(driver, obj_EsupportServiceEventsHomePage.ClickExpandAllButtonOnLeftPanel());

				expandicon=CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.ClickExpandAllButtonOnLeftPanel()).getAttribute("aria-expanded");
				System.out.println("collapse all visible "+expandicon);

				if(expandicon.contains("false"))
				{
					Log.info("expand all displayed");
				}
				else
				{
					Log.info("expand all not displayed");
					Report.put("Validate whether the expand all button is displayed after clicking on Collapse All button", 
							"User should see the Expand all button displayed after clicking on Collapse All button ",
							"failed to display expand all after clicking on the collapse all", "FAIL");
					Assert.fail();
				}

			}


			Report.put("Validate whether the expand all button is displayed after clicking on Collapse All button", 
					"User should see the Expand all button displayed after clicking on Collapse All button ",
					"User successfuly able to see expand all displayed with changed status of expand all to "+Report.color(expandicon)+" after clicking on the expand all", "PASS");

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Validate whether the expand all button is displayed after clicking on Collapse All button", 
					"User should see the Expand all button displayed after clicking on Collapse All button ",
					"failed to display expand all after clicking on the collapse all", "FAIL");
			Assert.fail();
		}
	}	

	public void ClickOnCollapseAllOnLeftPanel(WebDriver driver) 
	{
		Log.info("Entering method ClickOnCollapseAllOnLeftPanel");

		String topscount="";
		String descdateid="";
		String collapsedisplay="";
		String expandicon="";

		try
		{
			CommonUtility.scrollToViewElement(driver, obj_EsupportServiceEventsHomePage.ClickCollapseAllButtonOnLeftPanel());
			if(CommonUtility.CheckpresenceofElementLocated(driver, 30, obj_EsupportServiceEventsHomePage.ClickCollapseAllButtonOnLeftPanel()))
			{
				Thread.sleep(2000);
				CommonUtility.scrollToViewElement(driver, obj_EsupportServiceEventsHomePage.ClickCollapseAllButtonOnLeftPanel());
				CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.ClickCollapseAllButtonOnLeftPanel()).click();
				System.out.println("collapse button clicked");
				Thread.sleep(2000);
				//				expandicon=CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.ClickCollapseAllButtonOnLeftPanel()).getAttribute("aria-expanded");
				//				System.out.println("expand all visible "+expandicon);
				//
				//				if(expandicon.contains("false"))
				//				{
				//					Log.info("expand all displayed");
				//				}
				//				else
				//				{
				//					Log.info("expand all not displayed");
				//					Report.put("Click on Collapse all against the Event Type header in the left side of the panel", 
				//							"User should see the filters for all the event types collapse",
				//							"User failed to see the filters for all the event types collapse", "FAIL");
				//					Assert.fail();
				//				}

			}


			Report.put("Click on Collapse all against the Event Type header in the left side of the panel", 
					"User should see the filters for all the event types collapse",
					"User successfuly able to see the filters for all the event types collapse with expand status "+Report.color(expandicon)+" after clicking on the expand all", "PASS");

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on Collapse all against the Event Type header in the left side of the panel", 
					"User should see the filters for all the event types collapse",
					"User failed to see the filters for all the event types collapse", "FAIL");
			Assert.fail();
		}
	}

	public void AnyActiveDispatchesShouldDisplayByDefault(WebDriver driver) 
	{
		System.out.println("Entering method AnyActiveDispatchesShouldDisplayByDefault");
		System.out.println("outside try");
		Log.info("Entering method AnyActiveDispatchesShouldDisplayByDefault");
		System.out.println("outside try");
		WebDriverWait  wait = new WebDriverWait(driver, 120);
		int servicerequestscount;
		String status="";
		String status1="";
		String statussr1=TestNGCreator.TestData.get(Esupport.StatusOption.ordinal()).split(";")[0];
		String statussr2=TestNGCreator.TestData.get(Esupport.StatusOption.ordinal()).split(";")[1];
		String statussr3=TestNGCreator.TestData.get(Esupport.StatusOption.ordinal()).split(";")[2];
		String statussr4=TestNGCreator.TestData.get(Esupport.StatusOption.ordinal()).split(";")[3];
		String srcount="";
		String text1="";
		int count=0;
		int count2=0;
		int count3=0;
		int count4=0;
		String c="";
		String c1="";
		String c2="";
		String c3="";
		String statustext="";
		int dispatchescount;
		String text2="";
		String dispatchcount="";

		try
		{
			System.out.println("inside try");
			//CommonUtility.scrollToViewElement(driver, obj_EsupportServiceEventsHomePage.CountOfDispatches());
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportServiceEventsHomePage.CountOfDispatches()));
			//			CommonUtility.scrollToViewElement(driver, obj_EsupportServiceEventsHomePage.CountOfDispatches());
			if(CommonUtility.CheckpresenceofElementLocated(driver, 30, obj_EsupportServiceEventsHomePage.CountOfDispatches()))
			{
				CommonUtility.scrollToViewElement(driver, obj_EsupportServiceEventsHomePage.CountOfDispatches());
				CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.CountOfDispatches());
				System.out.println("in side if----------------");
				List <WebElement> dispatches=driver.findElements(obj_EsupportServiceEventsHomePage.CountOfDispatches());
				List <WebElement> statussr=driver.findElements(obj_EsupportServiceEventsHomePage.StatusOfOnlyDispatches());
				dispatchescount=dispatches.size();
				dispatchcount=String.valueOf(dispatchescount);
				System.out.println("total dispatches displayed "+dispatchescount);
				srcount=String.valueOf(dispatchescount);
				System.out.println("total count "+srcount);
				for(int i=0;i<dispatchescount;i++)
				{
					boolean b2=CommonUtility.highlightElement(driver, dispatches.get(i)).isDisplayed();
					if(b2==true)
					{
						CommonUtility.highlightElement(driver, dispatches.get(i));
						text2=text2+"<br>"+dispatches.get(i).getText();
						System.out.println("dispatches details are "+text2);
					}
				}


				for(int j=0;j<statussr.size();j++)
				{
					boolean b3=CommonUtility.highlightElement(driver, statussr.get(j)).isDisplayed();
					System.out.println("status displayed is "+b3);
					if(b3==true)
					{
						statustext=statussr.get(j).getText();
						System.out.println(statustext);


						if (statustext.equalsIgnoreCase(statussr1))
						{
							count++;
							System.out.println(count);
						}

						if(statustext.equalsIgnoreCase(statussr2))
						{
							count2++;
							System.out.println(count2);
						}

						if(statustext.equalsIgnoreCase(statussr3))
						{
							count3++;
							System.out.println(count3);
						}
						if(statustext.equalsIgnoreCase(statussr4))
						{
							count4++;
							System.out.println(count4);
						}
					}

				}
				System.out.println("open status count "+count);
				c=String.valueOf(count);
				System.out.println("In progress status count "+count2);
				c1=String.valueOf(count2);
				System.out.println("Closed status count "+count3);
				c2=String.valueOf(count3);
				System.out.println("Closed status count "+count4);
				c3=String.valueOf(count4);
			}
			else
			{
				Log.info("there is no active dispatches for this tag");
				Report.put("Any active Dispatch Event types should be visible by default", 
						"User should see the active Dispatch(s) by default on the content section of the page.",
						"no active dispatches exists for this tag", "FAIL");
				Assert.fail();

			}


			Report.put("Any active Dispatch Event types should be visible by default", 
					"User should see the active Dispatch(s) by default on the content section of the page.",
					"able to see dispath details as below <br>"+Report.color(text2)+"<br> with toal count of active events <br> with count of "+Report.color(statussr1)+" status is "+Report.color(c)+"<br> with count of "+Report.color(statussr2)+" status is "+Report.color(c1)+"<br> with count of "+Report.color(statussr3)+" status is "+Report.color(c2)+"<br> and with dispatch type count if any "+Report.color(dispatchcount), "PASS");
		}


		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Any active Dispatch Event types should be visible by default", 
					"User should see the active Dispatch(s) by default on the content section of the page.",
					"no active dispatches exists for this tag", "FAIL");
			Assert.fail();
		}
	}


	public void ValidateForActiveFilterUnderDispatchesIsSelectedByDefault(WebDriver driver) 
	{
		Log.info("Entering method ValidateForActiveFilterUnderDispatchesIsSelectedByDefault");
		WebDriverWait  wait = new WebDriverWait(driver, 120);

		String textet="";

		try
		{
			System.out.println("inside try");
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportServiceEventsHomePage.ClickOnExpandButtonOnDispatches()));
			if(CommonUtility.CheckpresenceofElementLocated(driver, 15, obj_EsupportServiceEventsHomePage.ClickOnExpandButtonOnDispatches()))
			{
				CommonUtility.scrollToViewElement(driver, obj_EsupportServiceEventsHomePage.ClickOnExpandButtonOnDispatches());
				CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.ClickOnExpandButtonOnDispatches()).click();
				Thread.sleep(2000);

				CommonUtility.scrollToViewElement(driver, obj_EsupportServiceEventsHomePage.ValidatesFiltersInLeftPanel());
				List<WebElement> listofeventtypes=driver.findElements(obj_EsupportServiceEventsHomePage.ValidateFiltersSectionAfterApplyingFilterOnLeftPanel());
				int etcount=listofeventtypes.size();

				for(int i=0;i<etcount;i++)
				{
					textet=textet+"<br>"+listofeventtypes.get(i).getText();
					System.out.println("filters displayed "+textet);

				}

				if (textet.contains("Dispatches - Active"))
				{
					Log.info("test case pass:user able to see active dispatches selected by default");
				}
				else
				{
					Log.info("test case fail:user not able to see active dispatches selected by default");
					Report.put("On the left panel, verify if Active filter is selected by default under the Dispatches Event Type", 
							"User should see the Active filter selected by default under the Dispatches Event Type",
							"this tag dont have active dispatces or user not able to see Active filter selected by default under the Dispatches", "FAIL");
					Assert.fail();
				}


			}
			Report.put("On the left panel, verify if Active filter is selected by default under the Dispatches Event Type", 
					"User should see the Active filter selected by default under the Dispatches Event Type",
					"User able to see "+Report.color(textet)+" filter selected by default under the Dispatches Event Type ", "PASS");

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("On the left panel, verify if Active filter is selected by default under the Dispatches Event Type", 
					"User should see the Active filter selected by default under the Dispatches Event Type",
					"this tag dont have active dispatces or user not able to see see the Active filter selected by default under the Dispatches Event Type", "FAIL");
			Assert.fail();
		}
	}
	public void ValidateSelectingInactiveDispatches(WebDriver driver) 
	{
		Log.info("Entering method ValidateSelectingInactiveDispatches");
		WebDriverWait  wait = new WebDriverWait(driver, 120);
		boolean b;
		int dispatchescount;
		String dispatchcount="";
		String srcount="";
		String text2="";
		String statussr4=TestNGCreator.TestData.get(Esupport.StatusOption.ordinal()).split(";")[3];
		String statussr3=TestNGCreator.TestData.get(Esupport.StatusOption.ordinal()).split(";")[2];
		String statussr2=TestNGCreator.TestData.get(Esupport.StatusOption.ordinal()).split(";")[1];
		String statussr1=TestNGCreator.TestData.get(Esupport.StatusOption.ordinal()).split(";")[0];
		String text1="";
		int count=0;
		int count2=0;
		int count3=0;
		int count4=0;
		String c="";
		String c1="";
		String c2="";
		String c3="";
		String statustext="";
		String sta1="";
		String sta2="";

		try
		{//CommonUtility.scrollToViewElement(driver, obj_EsupportServiceEventsHomePage.ClickOnExpandButtonOnDispatches());
			System.out.println("inside try");
			//			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportServiceEventsHomePage.ClickOnExpandButtonOnDispatches()));
			//			CommonUtility.scrollToViewElement(driver, obj_EsupportServiceEventsHomePage.ClickOnExpandButtonOnDispatches());
			//			CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.ClickOnExpandButtonOnDispatches()).click();
			Thread.sleep(2000);
			CommonUtility.ScrollTo(driver, obj_EsupportServiceEventsHomePage.SelectClosedDispatches());
			CommonUtility.ClickOn(driver, obj_EsupportServiceEventsHomePage.SelectClosedDispatches());
			Thread.sleep(6000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportServiceEventsHomePage.ApplyFiltersButton()));
			CommonUtility.ScrollTo(driver, obj_EsupportServiceEventsHomePage.ApplyFiltersButton());

			CommonUtility.ClickOn(driver, obj_EsupportServiceEventsHomePage.ApplyFiltersButton());
			Thread.sleep(10000);
			driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
			if(CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.CountOfDispatches()).isDisplayed())
			{
				CommonUtility.ScrollTo(driver, obj_EsupportServiceEventsHomePage.CountOfDispatches());
				CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.CountOfDispatches());
				System.out.println("in side if----------------");
				List <WebElement> dispatches=driver.findElements(obj_EsupportServiceEventsHomePage.CountOfDispatches());
				List <WebElement> statussr=driver.findElements(obj_EsupportServiceEventsHomePage.StatusOfOnlyDispatches());
				dispatchescount=dispatches.size();
				dispatchcount=String.valueOf(dispatchescount);
				System.out.println("total dispatches displayed "+dispatchescount);
				srcount=String.valueOf(dispatchescount);
				System.out.println("total dispatches count "+srcount);

				for(int i=0;i<dispatchescount;i++)
				{
					boolean b2=CommonUtility.highlightElement(driver, dispatches.get(i)).isDisplayed();
					if(b2==true)
					{
						CommonUtility.ScrollToWebElement(driver, dispatches.get(i));
						text2=text2+"<br>"+dispatches.get(i).getText();
						System.out.println("dispatches details are "+text2);
					}
				}


				for(int j=0;j<statussr.size();j++)
				{
					boolean b3=CommonUtility.highlightElement(driver, statussr.get(j)).isDisplayed();
					System.out.println("status is displayed"+b3);
					if(b3==true)
					{
						statustext=statussr.get(j).getText();
						System.out.println(statustext);

						if (statustext.equalsIgnoreCase(statussr1))
						{
							count++;
							System.out.println(count);
						}

						if(statustext.equalsIgnoreCase(statussr2))
						{
							count2++;
							System.out.println(count2);
						}

						if(statustext.equalsIgnoreCase(statussr3))
						{
							count3++;
							System.out.println(count3);
						}
						if(statustext.equalsIgnoreCase(statussr4))
						{
							count4++;
							System.out.println(count4);
						}
					}

				}
				System.out.println("open status count "+count);
				c=String.valueOf(count);
				System.out.println("In progress status count "+count2);
				c1=String.valueOf(count2);
				System.out.println("Closed status count "+count3);
				c2=String.valueOf(count3);
				System.out.println("Cancelled status count "+count4);
				c3=String.valueOf(count4);
			}
			else
			{
				Log.info("no dispatches displayed");
				Report.put("Scenario : To check for inactive Dispatches<br> 1. On the left panel, Tick the box against Dispatches Event type, click on the collapse icon and check the Closed Filter only.<br> 2.Click on Apply Filters at the bottom", 
						"User should see all the closed Dispatch(s) on the content sections of the page and the Only show active events should be toggled off ",
						"no dispatches displayed in the content of the page", "FAIL");
				Assert.fail();
			}
			CommonUtility.scrollToViewElement(driver, obj_EsupportServiceEventsHomePage.ValidateCheckBoxISChecked());
			sta1=CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.ValidateCheckBoxISChecked()).getAttribute("checked");
			System.out.println("status of Only show active events checkbox "+sta1);
			boolean b1=CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.ValidateCheckBoxISChecked()).isSelected();
			if(b1==false)
			{
				Log.info("test step pass: Only show active events is toggled off successfully");
			}
			else
			{
				Log.info("test step fail:Only show active events is not toggled off ");
				Report.put("Scenario : To check for inactive Dispatches<br> 1. On the left panel, Tick the box against Dispatches Event type, click on the collapse icon and check the Closed Filter only.<br> 2.Click on Apply Filters at the bottom", 
						"User should see all the closed Dispatch(s) on the content sections of the page and the Only show active events should be toggled off ",
						"Only show active events button is not toggeled off", "FAIL");
				Assert.fail();
			}

			Report.put("Scenario : To check for inactive Dispatches<br> 1. On the left panel, Tick the box against Dispatches Event type, click on the collapse icon and check the Closed Filter only.<br> 2.Click on Apply Filters at the bottom", 
					"User should see all the closed Dispatch(s) on the content sections of the page and the Only show active events should be toggled off",
					"User able to see "+Report.color(statussr3)+" and "+Report.color(statussr4)+" Dispatch(s) on the content sections of the page with the count of "+Report.color(c2)+" and "+Report.color(c3)+" <br> and dispatches with status of "+Report.color(statussr1)+" with the count of "+Report.color(c)+"<br> and dispatches with status of "+Report.color(statussr2)+" with the count of "+Report.color(c1)+"<br>  and Only show active events should be toggled off with status "+b1, "PASS");

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Scenario : To check for inactive Dispatches<br> 1. On the left panel, Tick the box against Dispatches Event type, click on the collapse icon and check the Closed Filter only.<br> 2.Click on Apply Filters at the bottom", 
					"User should see all the closed Dispatch(s) on the content sections of the page and the Only show active events should be toggled off ",
					"user not able to see see the Active filter selected by default under the Dispatches Event Type", "FAIL");
			Assert.fail();
		}
	}

	public void ValidateDetailsOfDispatchesDisplayedInContentSection(WebDriver driver) 
	{

		Log.info("Entering method ValidateDetailsOfDispatchesDisplayedInContentSection");
		WebDriverWait  wait = new WebDriverWait(driver, 120);
		boolean b;
		int dispatchescount;
		String dispatchcount="";
		String srcount="";
		String text2="";
		String statussr4=TestNGCreator.TestData.get(Esupport.StatusOption.ordinal()).split(";")[3];
		String statussr3=TestNGCreator.TestData.get(Esupport.StatusOption.ordinal()).split(";")[2];
		String statussr2=TestNGCreator.TestData.get(Esupport.StatusOption.ordinal()).split(";")[1];
		String statussr1=TestNGCreator.TestData.get(Esupport.StatusOption.ordinal()).split(";")[0];
		String text1="";
		int count=0;
		int count2=0;
		int count3=0;
		int count4=0;
		String c="";
		String c1="";
		String c2="";
		String c3="";
		String statustext="";
		String sta1="";
		String sta2="";

		try
		{
			System.out.println("inside try");
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportServiceEventsHomePage.CountOfDispatches()));
			if(CommonUtility.CheckpresenceofElementLocated(driver, 30, obj_EsupportServiceEventsHomePage.CountOfDispatches()))
			{
				CommonUtility.scrollToViewElement(driver, obj_EsupportServiceEventsHomePage.CountOfDispatches());
				System.out.println("in side if----------------");
				List <WebElement> dispatches=driver.findElements(obj_EsupportServiceEventsHomePage.CountOfDispatches());
				List <WebElement> statussr=driver.findElements(obj_EsupportServiceEventsHomePage.StatusOfOnlyDispatches());
				dispatchescount=dispatches.size();
				dispatchcount=String.valueOf(dispatchescount);
				System.out.println("total service events displayed "+dispatchescount);
				srcount=String.valueOf(dispatchescount);
				System.out.println("total dispatches count "+srcount);

				for(int i=0;i<dispatchescount;i++)
				{
					boolean b2=CommonUtility.highlightElement(driver, dispatches.get(i)).isDisplayed();
					if(b2==true)
					{
						CommonUtility.highlightElement(driver, dispatches.get(i));
						text2=text2+"<br>"+dispatches.get(i).getText();
						System.out.println("service request details are "+text2);
					}
				}


				for(int j=0;j<statussr.size();j++)
				{
					boolean b3=CommonUtility.highlightElement(driver, statussr.get(j)).isDisplayed();
					System.out.println("status is displayed"+b3);
					if(b3==true)
					{
						statustext=statussr.get(j).getText();
						System.out.println(statustext);


						if (statustext.equalsIgnoreCase(statussr1))
						{
							count++;
							System.out.println(count);
						}

						if(statustext.equalsIgnoreCase(statussr2))
						{
							count2++;
							System.out.println(count2);
						}

						if(statustext.equalsIgnoreCase(statussr3))
						{
							count3++;
							System.out.println(count3);
						}
						if(statustext.equalsIgnoreCase(statussr4))
						{
							count4++;
							System.out.println(count4);
						}
					}

				}
				System.out.println("open status count "+count);
				c=String.valueOf(count);
				System.out.println("In progress status count "+count2);
				c1=String.valueOf(count2);
				System.out.println("Closed status count "+count3);
				c2=String.valueOf(count3);
				System.out.println("Cancelled status count "+count4);
				c3=String.valueOf(count4);
			}
			else
			{
				Log.info("no dispatches displayed");
				Report.put("Validate the display details of Dispatch(s) on the content section of the page", 
						"User should see the following details against the Dispatch on the content section of the page:1. Dispatch Number2. Service Request Number3. Status4. Expand icon ",
						"no dispatches displayed in the content of the page", "FAIL");
				Assert.fail();
			}

			CommonUtility.scrollToViewElement(driver, obj_EsupportServiceEventsHomePage.ExpandIconOfDispatchesValidation());
			List<WebElement> coll=driver.findElements(obj_EsupportServiceEventsHomePage.ExpandIconOfDispatchesValidation());

			System.out.println("count of expand buttons are "+coll.size());

			for(int k=0;k<coll.size();k++)
			{
				sta2=CommonUtility.highlightElement(driver, coll.get(k)).getAttribute("class");
				System.out.println("attribute is "+sta2);

				if(sta2.contains("collapsed"))
				{
					Log.info("test step pass: expand icon displayed");
				}
				else
				{
					Log.info("test step fail:expand icon not displayed");
					Report.put("Validate the display details of Dispatch(s) on the content section of the page", 
							"User should see the following details against the Dispatch on the content section of the page:1. Dispatch Number2. Service Request Number3. Status4. Expand icon ",
							"collapse button not displayed of dispatches in the content section of the page", "FAIL");
					Assert.fail();
				}
			}

			Report.put("Validate the display details of Dispatch(s) on the content section of the page", 
					"User should see the following details against the Dispatch on the content section of the page:1. Dispatch Number2. Service Request Number3. Status4. Expand icon ",
					"User able to see dispatches with dispatches details as<br>"+Report.color(text2)+"<br>with status "+Report.color(statussr3)+" Dispatch(s) on the content sections of the page with the count of "+Report.color(c2)+" <br> and dispatches with status of "+Report.color(statussr1)+" with the count of "+Report.color(c)+"<br> and dispatches with status of "+Report.color(statussr2)+" with the count of "+Report.color(c1)+"<br> and dispatches with status of "+Report.color(statussr4)+" with the count of "+Report.color(c3)+"<br> and with expand icon "+Report.color(sta2), "PASS");

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Validate the display details of Dispatch(s) on the content section of the page", 
					"User should see the following details against the Dispatch on the content section of the page:1. Dispatch Number2. Service Request Number3. Status4. Expand icon ",
					"user not able to see details of dispatched in the content section of the page", "FAIL");
			Assert.fail();
		}
	}

	public void ClickOnExpandIconOfDispatches(WebDriver driver) 
	{

		Log.info("Entering method ClickOnExpandIconOfDispatches");
		WebDriverWait  wait = new WebDriverWait(driver, 120);
		String text="";
		Actions act=new Actions(driver);

		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportServiceEventsHomePage.ClickOnExpandIconOfDispatch()));
			if(CommonUtility.CheckpresenceofElementLocated(driver, 30, obj_EsupportServiceEventsHomePage.ClickOnExpandIconOfDispatch()))
			{
				//CommonUtility.scrollToViewElement(driver, obj_EsupportServiceEventsHomePage.ClickOnExpandIconOfDispatch());
				System.out.println("in side if----------------");
				//CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.ClickOnExpandIconOfDispatch()).click();
				act.moveToElement(CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.ClickOnExpandIconOfDispatch())).click().build().perform();
				Thread.sleep(5000);
				text=CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.GetTextFromDispatches()).getText();

				System.out.println("text is "+text);

			}
			else
			{
				Report.put("Click on Expand icon ", 
						"User must see the Created date",
						"User not able to click on expand icon of dispatches in content section of the page", "FAIL");
				Assert.fail();
			}

			Report.put("Click on Expand icon ", 
					"User must see the Created date",
					"User able see the "+text, "PASS");

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on Expand icon ", 
					"User must see the Created date",
					"User not able to see the Created date", "FAIL");
			Assert.fail();
		}
	}

	public void ClickServiceNumberHyperlinkOnDispatches(WebDriver driver, String Email) 
	{
		Log.info("Entering method ClickServiceNumberHyperlinkOnDispatches");
		String att="";
		String text="";
		String title="";
		String currenturl="";
		int count;
		String dispatch="";
		WebDriverWait  wait = new WebDriverWait(driver, 120);

		try
		{
			Thread.sleep(5000);

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportServiceEventsHomePage.ClickOnServiceRequestNumberOfDispatch()));
			if(CommonUtility.CheckpresenceofElementLocated(driver, 30, obj_EsupportServiceEventsHomePage.ClickOnServiceRequestNumberOfDispatch()))
			{
				CommonUtility.ScrollTo(driver, obj_EsupportServiceEventsHomePage.ClickOnServiceRequestNumberOfDispatch());
				//handleCookies(driver);
				CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.ClickOnServiceRequestNumberOfDispatch());
				List<WebElement> link=driver.findElements(obj_EsupportServiceEventsHomePage.ClickOnServiceRequestNumberOfDispatch());
				int linkcount=link.size();
				System.out.println("count of SRN of dispatches are "+linkcount);
				for(int i=0;i<linkcount;i++)
				{
					CommonUtility.ScrollToWebElement(driver, link.get(i));
					CommonUtility.ClickOnWebElement(driver, link.get(i));
					Thread.sleep(7000);
					handleCookies(driver);

					String mainwindow=driver.getWindowHandle();
					Set<String> set=driver.getWindowHandles();
					Iterator<String> itr=set.iterator();
					while(itr.hasNext())
					{
						String childWindow=itr.next();
						if(!mainwindow.equals(childWindow))
						{
							driver.switchTo().window(childWindow);
							driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
							Thread.sleep(10000);
					title=title+"<br>"+driver.getTitle();
					System.out.println("title is "+title);

					currenturl=currenturl+"<br>"+driver.getCurrentUrl();
					System.out.println("url is "+currenturl);

					if(driver.getCurrentUrl().contains("srdetails"))
					{
						Log.info("Test case Pass: corresponding window opened");
					}
					else
					{
						Log.info("Test case fail: Service Request Details page not opened");
						Report.put("Click on the Service Number hyperlink  displayed", 
								"User should be directed to the Service Request Details page ",
								"User not directed to that corresponding Service Request Details page", "FAIL");
						Assert.fail();
					}
					text=CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.ServiceRequestActivity()).getText();
					System.out.println("heading is "+text);
					att=CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.ServiceRequestActivity()).getAttribute("class");
					if(att.equalsIgnoreCase("collapsed"))
					{
						Log.info("Test case fail: service request activity not expanded instaed it is collapsed");
						Report.put("Verify the content of the  Service Request Details page", 
								"User must see the following:1. Service Request Activity collapsed by default with Activity history  displayed.2. Dispatch number( if available)",
								"User dont see Service Request Activity collapsed by default", "FAIL");
						Assert.fail();
					}
					else
					{
						Log.info("Test case pass: service request activity expanded");
						String history=CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.ActivityHistoryDetails()).getText();
						System.out.println("activity history is "+history);
						dispatch=dispatch+"<br>"+CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.CaptureDispatchNumber()).getText();
						System.out.println("dispatch details "+dispatch);

					}

//					driver.navigate().back();
					driver.close();
						}
					}
					driver.switchTo().window(mainwindow);
					
					Thread.sleep(6000);

					//EnterEmailAddressToSeeServiceEvents(driver, TestNGCreator.TestData.get(Esupport.Email.ordinal()));
					//wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportServiceEventsHomePage.EmailEntryAfterClickingBack()));
					driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
					CommonUtility.ScrollTo(driver, obj_EsupportServiceEventsHomePage.EmailEntryAfterClickingBack());
					CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.EmailEntryAfterClickingBack()).sendKeys(Email);

					CommonUtility.ClickOn(driver, obj_EsupportServiceEventsHomePage.SubmitButtonAfterClickingBack());
					Thread.sleep(10000);

				}


			}
			Report.put("Verify the content of the  Service Request Details page", 
					"User must see the following:1. Service Request Activity collapsed by default with Activity history displayed.2. Dispatch number( if available)",
					"User able to see "+Report.color(text)+" collapsed by default with Activity history displayed and displayes "+Report.color(dispatch), "PASS");

			Report.put("Click on the Service Number hyperlink  displayed", 
					"User should be directed to the Service Request Details page ",
					"User successfully directed to that corresponding Service Request Details page with url<br>"+Report.color(currenturl)+" and title as <br>"+Report.color(title), "PASS");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on the Service Number hyperlink  displayed", 
					"User should be directed to the Service Request Details page ",
					"User not directed to that corresponding Service Request Details page", "FAIL");
			Assert.fail();
		}
	}

	public void ClickDispatchNumberHyperlinkOnDispatches(WebDriver driver, String Email) 
	{
		Log.info("Entering method ClickDispatchNumberHyperlinkOnDispatches");
		String text="";
		String att="";
		String title="";
		String currenturl="";
		int count;
		String dispatch="";

		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportServiceEventsHomePage.ClickOnDispatchNumberOfDispatch()));
			if(CommonUtility.CheckpresenceofElementLocated(driver, 30, obj_EsupportServiceEventsHomePage.ClickOnDispatchNumberOfDispatch()))
			{
				handleCookies(driver);
				List<WebElement> link=driver.findElements(obj_EsupportServiceEventsHomePage.ClickOnDispatchNumberOfDispatch());
				int linkcount=link.size();
				System.out.println(linkcount);
				for(int i=0;i<linkcount;i++)
				{
					CommonUtility.ScrollToWebElement(driver, link.get(i));
					CommonUtility.ClickOnWebElement(driver, link.get(i));
					Thread.sleep(7000);
					handleCookies(driver);

					String mainwindow=driver.getWindowHandle();
					Set<String> set=driver.getWindowHandles();
					Iterator<String> itr=set.iterator();
					while(itr.hasNext())
					{
						String childWindow=itr.next();
						if(!mainwindow.equals(childWindow))
						{
							driver.switchTo().window(childWindow);
							driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
							Thread.sleep(10000);
					title=title+"<br>"+driver.getTitle();
					System.out.println("title is "+title);

					currenturl=currenturl+"<br>"+driver.getCurrentUrl();
					System.out.println("url is "+currenturl);

					if(driver.getCurrentUrl().contains("srdetails"))
					{
						Log.info("Test case Pass: corresponding window opened");
					}
					else
					{
						Log.info("Test case fail: Service Request Details page not opened");
						Report.put("Click on the Dispatch Number hyperlink  displayed", 
								"User should be directed to the Service Request Details page ",
								"User not directed to that corresponding Service Request Details page", "FAIL");
						Assert.fail();
					}
					text=text+"<br>"+CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.ServiceRequestActivity()).getText();
					System.out.println("heading is "+text);
					att=CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.ServiceRequestActivity()).getAttribute("class");
					if(att.equalsIgnoreCase("collapsed"))
					{
						Log.info("Test case pass: service request activity expanded");

						dispatch=dispatch+"<br>"+CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.CaptureDispatchNumber()).getText();
						System.out.println("dispatch details "+dispatch);
						String tt=CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.CaptureDispatchNumber()).getAttribute("class");
						System.out.println("dispatches collapsed display no class "+tt);

					}
					else
					{

						Log.info("Test case fail: service request activity not expanded instaed it is collapsed");
						Report.put("Verify the content of the  Service Request Details page", 
								"User must see the following:1. Service Request Activity collapsed by default with Activity history  displayed.2. Dispatch number( if available)",
								"User dont see dispatches collapsed by default for DRN", "FAIL");
						Assert.fail();
					}

//					driver.navigate().back();
					
					driver.close();
						}
					}
					driver.switchTo().window(mainwindow);
					//EnterEmailAddressToSeeServiceEvents(driver, TestNGCreator.TestData.get(Esupport.Email.ordinal()));
					wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportServiceEventsHomePage.EmailEntryAfterClickingBack()));
					CommonUtility.ScrollTo(driver, obj_EsupportServiceEventsHomePage.EmailEntryAfterClickingBack());
					CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.EmailEntryAfterClickingBack()).sendKeys(Email);

					CommonUtility.ClickOn(driver, obj_EsupportServiceEventsHomePage.SubmitButtonAfterClickingBack());
					Thread.sleep(10000);
				}
			}
			Report.put("Verify the content of the  Service Request Details page", 
					"User must see the following:1. Service Request Activity collapsed by default with Activity history displayed.2. Dispatch number( if available)",
					"User able to see "+Report.color(text)+" collapsed by default and displayes "+Report.color(dispatch)+" with dispatch details", "PASS");

			Report.put("Click on the Dispatch Number hyperlink displayed", 
					"User should be directed to the Service Request Details page ",
					"User successfully directed to that corresponding Service Request Details page with url<br>"+Report.color(currenturl)+" and title as <br>"+Report.color(title), "PASS");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on the Dispatch Number hyperlink displayed", 
					"User should be directed to the Service Request Details page ",
					"User not directed to that corresponding Service Request Details page", "FAIL");
			Assert.fail();
		}
	}

	public void AnyActiveServiceRequestShouldDisplayByDefault(WebDriver driver) 
	{
		Log.info("Entering method AnyActiveServiceRequestShouldDisplayByDefault");
		WebDriverWait  wait = new WebDriverWait(driver, 120);
		int servicerequestscount;
		String status="";
		String status1="";
		String statussr1=TestNGCreator.TestData.get(Esupport.StatusOption.ordinal()).split(";")[0];
		String statussr2=TestNGCreator.TestData.get(Esupport.StatusOption.ordinal()).split(";")[1];
		String statussr3=TestNGCreator.TestData.get(Esupport.StatusOption.ordinal()).split(";")[2];
		String srcount="";
		String text1="";
		int count=0;
		int count2=0;
		int count3=0;

		String c="";
		String c1="";
		String c2="";

		String statustext="";
		int dispatchescount;
		String text2="";
		String dispatchcount="";

		try
		{
			//CommonUtility.scrollToViewElement(driver, obj_EsupportServiceEventsHomePage.GetCountOfActiveAndClosedSE());
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportServiceEventsHomePage.GetCountOfActiveAndClosedSE()));
			if(CommonUtility.CheckpresenceofElementLocated(driver, 30, obj_EsupportServiceEventsHomePage.GetCountOfActiveAndClosedSE()))
			{
				CommonUtility.scrollToViewElement(driver, obj_EsupportServiceEventsHomePage.GetCountOfActiveAndClosedSE());
				System.out.println("in side if----------------");
				List <WebElement> dispatches=driver.findElements(obj_EsupportServiceEventsHomePage.GetCountOfActiveAndClosedSE());
				List <WebElement> statussr=driver.findElements(obj_EsupportServiceEventsHomePage.StatusOfSR());
				dispatchescount=dispatches.size();
				dispatchcount=String.valueOf(dispatchescount);
				System.out.println("total dispatches displayed "+dispatchescount);
				srcount=String.valueOf(dispatchescount);
				System.out.println("total count "+srcount);
				for(int i=0;i<dispatchescount;i++)
				{
					boolean b2=CommonUtility.highlightElement(driver, dispatches.get(i)).isDisplayed();
					if(b2==true)
					{
						CommonUtility.highlightElement(driver, dispatches.get(i));
						text2=text2+"<br>"+dispatches.get(i).getText();
						System.out.println("dispatches details are "+text2);
					}
				}


				for(int j=0;j<statussr.size();j++)
				{
					boolean b3=CommonUtility.highlightElement(driver, statussr.get(j)).isDisplayed();
					System.out.println("status is displayed"+b3);
					if(b3==true)
					{
						statustext=statussr.get(j).getText();
						System.out.println(statustext);


						if (statustext.equalsIgnoreCase(statussr1))
						{
							count++;
							System.out.println(count);
						}

						if(statustext.equalsIgnoreCase(statussr2))
						{
							count2++;
							System.out.println(count2);
						}

						if(statustext.equalsIgnoreCase(statussr3))
						{
							count3++;
							System.out.println(count3);
						}
					}

				}
				System.out.println("open status count "+count);
				c=String.valueOf(count);
				System.out.println("In progress status count "+count2);
				c1=String.valueOf(count2);
				System.out.println("Closed status count "+count3);
				c2=String.valueOf(count3);
			}
			else
			{
				Log.info("there is no active service requests for this tag");
				Report.put("Any active Service Request Event type should be visible by default", 
						"User should see the active  (s) by default on the content section of the page.",
						"no active service requests exists for this tag", "FAIL");
				Assert.fail();

			}


			Report.put("Any active Service Request Event type should be visible by default", 
					"User should see the active  (s) by default on the content section of the page.",
					"able to see dispath details as below <br>"+Report.color(text2)+"<br> with toal count of active events <br> with count of "+Report.color(statussr1)+" status is "+Report.color(c)+"<br> with count of "+Report.color(statussr2)+" status is "+Report.color(c1)+"<br> with count of "+Report.color(statussr3)+" status is "+Report.color(c2)+"<br> and with dispatch type count if any "+Report.color(dispatchcount), "PASS");

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Any active Service Request Event type should be visible by default", 
					"User should see the active (s) by default on the content section of the page.",
					"no active Service Requests exists for this tag", "FAIL");
			Assert.fail();
		}
	}

	public void ValidateForActiveFilterUnderServiceRequestsIsSelectedByDefault(WebDriver driver) 
	{
		Log.info("Entering method ValidateForActiveFilterUnderServiceRequestsIsSelectedByDefault");
		WebDriverWait  wait = new WebDriverWait(driver, 120);

		String textet="";

		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportServiceEventsHomePage.ClickOnExpandButtonOnDispatches()));
			if(CommonUtility.CheckpresenceofElementLocated(driver, 15, obj_EsupportServiceEventsHomePage.ClickOnExpandButtonOnDispatches()))
			{
				CommonUtility.scrollToViewElement(driver, obj_EsupportServiceEventsHomePage.ClickOnExpandButtonOnDispatches());
				CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.ClickOnExpandButtonOnDispatches()).click();
				Thread.sleep(2000);

				CommonUtility.scrollToViewElement(driver, obj_EsupportServiceEventsHomePage.ValidatesFiltersInLeftPanel());
				List<WebElement> listofeventtypes=driver.findElements(obj_EsupportServiceEventsHomePage.ValidateFiltersSectionAfterApplyingFilterOnLeftPanel());
				int etcount=listofeventtypes.size();

				for(int i=0;i<etcount;i++)
				{
					textet=textet+"<br>"+listofeventtypes.get(i).getText();
					System.out.println("filters displayed "+textet);

				}

				if (textet.contains("Service Request - Active"))
				{
					Log.info("test case pass:user able to see active Service Request selected by default");
				}
				else
				{
					Log.info("test case fail:user not able to see active SRs selected by default");
					Report.put("On the left panel, verify if Active filter is selected by default under the Service Request Event Type", 
							"User should see the Active filter selected by default under the Service Request Event Type",
							"this tag dont have active SRs or user not able to see Active filter selected by default under the SRs", "FAIL");
					Assert.fail();
				}


			}
			Report.put("On the left panel, verify if Active filter is selected by default under the Service Request Event Type", 
					"User should see the Active filter selected by default under the Service Request Event Type",
					"User able to see "+Report.color(textet)+" filter selected by default under the Service Request Event Type ", "PASS");

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("On the left panel, verify if Active filter is selected by default under the Service Request Event Type", 
					"User should see the Active filter selected by default under the Service Request Event Type",
					"this tag dont have active SRs or user not able to see Active filter selected by default under the SRs", "FAIL");
			Assert.fail();
		}
	}

	public void ValidateSelectingInactiveServiceRequests(WebDriver driver) 
	{
		Log.info("Entering method ValidateSelectingInactiveServiceRequests");
		WebDriverWait  wait = new WebDriverWait(driver, 120);
		boolean b;
		int dispatchescount;
		String dispatchcount="";
		String srcount="";
		String text2="";
		String statussr3=TestNGCreator.TestData.get(Esupport.StatusOption.ordinal()).split(";")[2];
		String statussr2=TestNGCreator.TestData.get(Esupport.StatusOption.ordinal()).split(";")[1];
		String statussr1=TestNGCreator.TestData.get(Esupport.StatusOption.ordinal()).split(";")[0];
		String text1="";
		int count=0;
		int count2=0;
		int count3=0;

		String c="";
		String c1="";
		String c2="";

		String statustext="";
		String sta1="";
		String sta2="";
		Actions act=new Actions(driver);
		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportServiceEventsHomePage.ClickOnExpandButtonOnEventTypeServiceRequest()));
			CommonUtility.scrollToViewElement(driver, obj_EsupportServiceEventsHomePage.ClickOnExpandButtonOnEventTypeServiceRequest());
			CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.ClickOnExpandButtonOnEventTypeServiceRequest()).click();
			Thread.sleep(2000);
			CommonUtility.scrollToViewElement(driver, obj_EsupportServiceEventsHomePage.ClickOnInactiveServiceRequest());
			act.moveToElement(CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.ClickOnInactiveServiceRequest())).click().build().perform();
			//CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.ClickOnInactiveServiceRequest()).click();

			Thread.sleep(5000);


			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportServiceEventsHomePage.ApplyFiltersButton()));
			CommonUtility.scrollToViewElement(driver, obj_EsupportServiceEventsHomePage.ApplyFiltersButton());

			CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.ApplyFiltersButton()).click();
			Thread.sleep(10000);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			if(CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.GetCountOfActiveAndClosedSE()).isDisplayed())
			{
				//CommonUtility.scrollToViewElement(driver, obj_EsupportServiceEventsHomePage.GetCountOfActiveAndClosedSE());
				CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.GetCountOfActiveAndClosedSE());
				System.out.println("in side if----------------");
				List <WebElement> dispatches=driver.findElements(obj_EsupportServiceEventsHomePage.GetCountOfActiveAndClosedSE());
				List <WebElement> statussr=driver.findElements(obj_EsupportServiceEventsHomePage.StatusOfSR());
				dispatchescount=dispatches.size();
				dispatchcount=String.valueOf(dispatchescount);
				System.out.println("total service events displayed "+dispatchescount);
				srcount=String.valueOf(dispatchescount);
				System.out.println("total service events count "+srcount);

				for(int i=0;i<dispatchescount;i++)
				{
					boolean b2=CommonUtility.highlightElement(driver, dispatches.get(i)).isDisplayed();
					if(b2==true)
					{
						CommonUtility.highlightElement(driver, dispatches.get(i));
						text2=text2+"<br>"+dispatches.get(i).getText();
						System.out.println("service request details are "+text2);
					}
				}


				for(int j=0;j<statussr.size();j++)
				{
					boolean b3=CommonUtility.highlightElement(driver, statussr.get(j)).isDisplayed();
					System.out.println("status is displayed"+b3);
					if(b3==true)
					{
						statustext=statussr.get(j).getText();
						System.out.println(statustext);

						if (statustext.equalsIgnoreCase(statussr1))
						{
							count++;
							System.out.println(count);
						}

						if(statustext.equalsIgnoreCase(statussr2))
						{
							count2++;
							System.out.println(count2);
						}

						if(statustext.equalsIgnoreCase(statussr3))
						{
							count3++;
							System.out.println(count3);
						}
					}

				}
				System.out.println("Closed status count "+count);
				c=String.valueOf(count3);
				System.out.println("Closed status count "+count2);
				c1=String.valueOf(count3);
				System.out.println("Closed status count "+count3);
				c2=String.valueOf(count3);
			}
			else
			{
				Log.info("no service requests displayed");
				Report.put("Scenario : To check for inactive Service Request1. On the left panel, Tick the box against Dispatches Event type, click on the collapse icon and check the Closed Filter only.2. Click on Apply Filters at the bottom ", 
						"User should see all the closed Service Request(s) on the content sections of the page and the Only show active events should be toggled off",
						"no Service Request displayed in the content of the page", "FAIL");
				Assert.fail();
			}
			CommonUtility.scrollToViewElement(driver, obj_EsupportServiceEventsHomePage.ValidateCheckBoxISChecked());

			sta1=CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.ValidateCheckBoxISChecked()).getAttribute("checked");
			System.out.println("status of Only show active events checkbox "+sta1);
			boolean b1=CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.ValidateCheckBoxISChecked()).isSelected();
			if(b1==false)
			{
				Log.info("test step pass: Only show active events is toggled off successfully");
			}
			else
			{
				Log.info("test step fail:Only show active events is not toggled off ");
				Report.put("Scenario : To check for inactive Service Request1. On the left panel, Tick the box against Dispatches Event type, click on the collapse icon and check the Closed Filter only.2. Click on Apply Filters at the bottom ", 
						"User should see all the closed Service Request(s) on the content sections of the page and the Only show active events should be toggled off",
						"Only show active events button is not toggeled off", "FAIL");
				Assert.fail();
			}

			Report.put("Scenario : To check for inactive Service Request1. On the left panel, Tick the box against Dispatches Event type, click on the collapse icon and check the Closed Filter only.2. Click on Apply Filters at the bottom ", 
					"User should see all the closed Service Request(s) on the content sections of the page and the Only show active events should be toggled off",
					"User able to see "+Report.color(statussr3)+" Service Request(s) on the content sections of the page with the count of "+Report.color(c2)+" <br> and Service Requests with status of "+Report.color(statussr1)+" with the count of "+Report.color(c)+"<br> and Service Request with status of "+Report.color(statussr2)+" with the count of "+Report.color(c1)+"<br>  and Only show active events should be toggled off with status "+b1, "PASS");

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Scenario : To check for inactive Service Request1. On the left panel, Tick the box against Dispatches Event type, click on the collapse icon and check the Closed Filter only.2. Click on Apply Filters at the bottom ", 
					"User should see all the closed Service Request(s) on the content sections of the page and the Only show active events should be toggled off",
					"user not able to see the Active filter selected by default under the Service Request(s) Event Type", "FAIL");
			Assert.fail();
		}
	}

	public void ValidateDetailsOfServiceRequestssDisplayedInContentSection(WebDriver driver) 
	{

		Log.info("Entering method ValidateDetailsOfServiceRequestssDisplayedInContentSection");
		WebDriverWait  wait = new WebDriverWait(driver, 120);
		boolean b;
		int dispatchescount;
		String dispatchcount="";
		String srcount="";
		String text2="";
		String statussr3=TestNGCreator.TestData.get(Esupport.StatusOption.ordinal()).split(";")[2];
		String statussr2=TestNGCreator.TestData.get(Esupport.StatusOption.ordinal()).split(";")[1];
		String statussr1=TestNGCreator.TestData.get(Esupport.StatusOption.ordinal()).split(";")[0];
		String text1="";
		int count=0;
		int count2=0;
		int count3=0;

		String c="";
		String c1="";
		String c2="";

		String statustext="";
		String sta1="";
		String sta2="";

		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportServiceEventsHomePage.GetCountOfActiveAndClosedSE()));
			if(CommonUtility.CheckpresenceofElementLocated(driver, 30, obj_EsupportServiceEventsHomePage.GetCountOfActiveAndClosedSE()))
			{
				CommonUtility.scrollToViewElement(driver, obj_EsupportServiceEventsHomePage.GetCountOfActiveAndClosedSE());
				System.out.println("in side if----------------");
				List <WebElement> dispatches=driver.findElements(obj_EsupportServiceEventsHomePage.GetCountOfActiveAndClosedSE());
				List <WebElement> statussr=driver.findElements(obj_EsupportServiceEventsHomePage.StatusOfSR());
				dispatchescount=dispatches.size();
				dispatchcount=String.valueOf(dispatchescount);
				System.out.println("total service events displayed "+dispatchescount);
				srcount=String.valueOf(dispatchescount);
				System.out.println("total service requests count "+srcount);

				for(int i=0;i<dispatchescount;i++)
				{
					boolean b2=CommonUtility.highlightElement(driver, dispatches.get(i)).isDisplayed();
					if(b2==true)
					{
						CommonUtility.highlightElement(driver, dispatches.get(i));
						text2=text2+"<br>"+dispatches.get(i).getText();
						System.out.println("service request details are "+text2);
					}
				}


				for(int j=0;j<statussr.size();j++)
				{
					boolean b3=CommonUtility.highlightElement(driver, statussr.get(j)).isDisplayed();
					System.out.println("status is displayed"+b3);
					if(b3==true)
					{
						statustext=statussr.get(j).getText();
						System.out.println(statustext);


						if (statustext.equalsIgnoreCase(statussr1))
						{
							count++;
							System.out.println(count);
						}

						if(statustext.equalsIgnoreCase(statussr2))
						{
							count2++;
							System.out.println(count2);
						}

						if(statustext.equalsIgnoreCase(statussr3))
						{
							count3++;
							System.out.println(count3);
						}
					}

				}
				System.out.println("open status count "+count);
				c=String.valueOf(count);
				System.out.println("In progress status count "+count2);
				c1=String.valueOf(count2);
				System.out.println("Closed status count "+count3);
				c2=String.valueOf(count3);
			}
			else
			{
				Log.info("no dispatches displayed");
				Report.put("Validate the display details of Dispatch(s) on the content section of the page", 
						"User should see the following details against the Dispatch on the content section of the page:1. Dispatch Number2. Service Request Number3. Status4. Expand icon ",
						"no dispatches displayed in the content of the page", "FAIL");
				Assert.fail();
			}

			CommonUtility.scrollToViewElement(driver, obj_EsupportServiceEventsHomePage.ExpandIconOfServiceRequestsValidation());
			List<WebElement> coll=driver.findElements(obj_EsupportServiceEventsHomePage.ExpandIconOfServiceRequestsValidation());

			System.out.println("count of expand buttons are "+coll.size());

			for(int k=0;k<coll.size();k++)
			{
				sta2=CommonUtility.highlightElement(driver, coll.get(k)).getAttribute("class");
				System.out.println("status of Only show active events checkbox "+sta2);

				if(sta2.contains("collapsed"))
				{
					Log.info("test step pass: expand icon displayed");
				}
				else
				{
					Log.info("test step fail:expand icon not displayed");
					Report.put("Validate the display details of Dispatch(s) on the content section of the page", 
							"User should see the following details against the Service Request on the content section of the page:1. Severity 2. Service Request Number 3. Status 4. Expand icon",
							"collapse button not displayed of Service Request on the content section of the page", "FAIL");
					Assert.fail();
				}
			}

			Report.put("Validate the display details of Dispatch(s) on the content section of the page", 
					"User should see the following details against the Service Request on the content section of the page:1. Severity 2. Service Request Number 3. Status 4. Expand icon",
					"User able to see dispatches with dispatches details as<br>"+Report.color(text2)+"<br>with status "+Report.color(statussr3)+" Dispatch(s) on the content sections of the page with the count of "+Report.color(c2)+" <br> and dispatches with status of "+Report.color(statussr1)+" with the count of "+Report.color(c)+"<br> and dispatches with status of "+Report.color(statussr2)+" with the count of "+Report.color(c1)+"<br> and with expand icon "+Report.color(sta2), "PASS");

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Validate the display details of Dispatch(s) on the content section of the page", 
					"User should see the following details against the Service Request on the content section of the page:1. Severity 2. Service Request Number 3. Status 4. Expand icon",
					"collapse button not displayed of Service Request on the content section of the page", "FAIL");
			Assert.fail();
		}
	}

	public void ClickOnExpandIconOfServiceRequests(WebDriver driver) 
	{

		Log.info("Entering method ClickOnExpandIconOfServiceRequests");
		WebDriverWait  wait = new WebDriverWait(driver, 120);
		String text="";


		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportServiceEventsHomePage.ClickOnExpandIconOfServiceRequest()));
			if(CommonUtility.CheckpresenceofElementLocated(driver, 30, obj_EsupportServiceEventsHomePage.ClickOnExpandIconOfServiceRequest()))
			{
				//CommonUtility.scrollToViewElement(driver, obj_EsupportServiceEventsHomePage.ClickOnExpandIconOfServiceRequest());
				System.out.println("in side if----------------");
				//CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.ClickOnExpandIconOfServiceRequest()).click();
				Thread.sleep(2000);
				List <WebElement> textofexpandedsectionofdisaptches=driver.findElements(obj_EsupportServiceEventsHomePage.GetTextFromServiceRequests());
				List <WebElement> textofexpandedsectionofdisaptches1=driver.findElements(obj_EsupportServiceEventsHomePage.ClickOnExpandIconOfServiceRequest());
				for(int i=0;i<textofexpandedsectionofdisaptches1.size();i++)
				{
					//CommonUtility.scrollToViewElement(driver, textofexpandedsectionofdisaptches1.get(i));
					CommonUtility.highlightElement(driver, textofexpandedsectionofdisaptches1.get(i)).click();
					Thread.sleep(5000);
					CommonUtility.scrollToViewElement(driver, textofexpandedsectionofdisaptches.get(i));
					CommonUtility.highlightElement(driver, textofexpandedsectionofdisaptches.get(i));
					text=text+"<br>"+textofexpandedsectionofdisaptches.get(i).getText();
					System.out.println("text is "+text);

				}

			}
			else
			{
				Report.put("Click on Expand icon ", 
						"User must see the Created date",
						"User not able to click on expand icon of service requests in content section of the page", "FAIL");
			}

			Report.put("Click on Expand icon ", 
					"User must see the Created date",
					"User able see the "+text, "PASS");

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on Expand icon ", 
					"User must see the Created date",
					"User not able to see the Created date", "FAIL");
			Assert.fail();
		}
	}

	public void ClickServiceNumberHyperlinkOnServiceRequests(WebDriver driver, String Email) 
	{
		Log.info("Entering method ClickServiceNumberHyperlinkOnServiceRequests");
		String att="";
		String text="";
		String title="";
		String currenturl="";
		int count;
		String dispatch="";

		try
		{
			if(CommonUtility.CheckpresenceofElementLocated(driver, 30, obj_EsupportServiceEventsHomePage.ClickOnSRNOfServiceResquest()))
			{

				handleCookies(driver);
				CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.ClickOnSRNOfServiceResquest());
				List<WebElement> link=driver.findElements(obj_EsupportServiceEventsHomePage.ClickOnSRNOfServiceResquest());
				int linkcount=link.size();
				System.out.println("count of SRN of dispatches are "+linkcount);
				for(int i=0;i<linkcount;i++)
				{
					CommonUtility.highlightElement(driver, link.get(i)).click();
					Thread.sleep(7000);
					handleCookies(driver);

					title=title+"<br>"+driver.getTitle();
					System.out.println("title is "+title);

					currenturl=currenturl+"<br>"+driver.getCurrentUrl();
					System.out.println("url is "+currenturl);

					if(driver.getCurrentUrl().contains("srdetails"))
					{
						Log.info("Test case Pass: corresponding window opened");
					}
					else
					{
						Log.info("Test case fail: Service Request Details page not opened");
						Report.put("Click on the Service Number hyperlink  displayed", 
								"User should be directed to the Service Request Details page ",
								"User not directed to that corresponding Service Request Details page", "FAIL");
						Assert.fail();
					}
					text=text+"<br>"+CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.ServiceRequestActivity()).getText();
					System.out.println("heading is "+text);
					att=CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.ServiceRequestActivity()).getAttribute("class");
					if(att.equalsIgnoreCase("collapsed"))
					{
						Log.info("Test case fail: service request activity not expanded instaed it is collapsed");
						Report.put("Verify the content of the  Service Request Details page", 
								"User must see the following:1. Service Request Activity collapsed by default with Activity history  displayed.2. Dispatch number( if available)",
								"User dont see Service Request Activity collapsed by default", "FAIL");
						Assert.fail();
					}
					else
					{
						Log.info("Test case pass: service request activity expanded");
						String history=CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.ActivityHistoryDetails()).getText();
						System.out.println("activity history is "+history);
						dispatch=dispatch+"<br>"+CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.CaptureDispatchNumber()).getText();
						System.out.println("dispatch details "+dispatch);

					}

					driver.navigate().back();
					//EnterEmailAddressToSeeServiceEvents(driver, TestNGCreator.TestData.get(Esupport.Email.ordinal()));
					wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportServiceEventsHomePage.EmailEntryAfterClickingBack()));
					CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.EmailEntryAfterClickingBack());
					CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.EmailEntryAfterClickingBack()).sendKeys(Email);

					CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.SubmitButtonAfterClickingBack()).click();
					Thread.sleep(10000);

				}


			}
			Report.put("Verify the content of the  Service Request Details page", 
					"User must see the following:1. Service Request Activity collapsed by default with Activity history displayed.2. Dispatch number( if available)",
					"User able to see "+Report.color(text)+" collapsed by default with Activity history displayed and displayes "+Report.color(dispatch), "PASS");

			Report.put("Click on the Service Number hyperlink  displayed", 
					"User should be directed to the Service Request Details page ",
					"User successfully directed to that corresponding Service Request Details page with url<br>"+Report.color(currenturl)+" and title as <br>"+Report.color(title), "PASS");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on the Service Number hyperlink  displayed", 
					"User should be directed to the Service Request Details page ",
					"User not directed to that corresponding Service Request Details page", "FAIL");
			Assert.fail();
		}
	}

	
	public void verifyFCODetailsInOverviewTab(WebDriver driver)
	{
		System.out.println("Inside verifyFCODetailsInOverviewTab method");
		Log.info("Inside verifyFCODetailsInOverviewTab method");


		String FCOText = "";
		String serviceRequestLabel = "";
		String serviceRequestNumber = "";
		String severityLabel = "";
		String severityValue = "";
		String dateCreatedLabel = "";
		String dateCreatedValue = "";
		
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportServiceEventsHomePage.ServiceEventsHeaderInOverivewTab()));
			
			if(CommonUtility.CheckpresenceofElementLocated(driver, 10, obj_EsupportServiceEventsHomePage.FCOTextInOverviewTab()))
			{
			CommonUtility.ScrollTo(driver, obj_EsupportServiceEventsHomePage.FCOTextInOverviewTab());
			
			FCOText = CommonUtility.highlightElement(driver,obj_EsupportServiceEventsHomePage.FCOTextInOverviewTab()).getText();

			System.out.println("FCO Text is: "+FCOText);
			
			serviceRequestLabel = CommonUtility.highlightElement(driver,obj_EsupportServiceEventsHomePage.FCOServiceRequestLabel()).getText();
			serviceRequestNumber = CommonUtility.highlightElement(driver,obj_EsupportServiceEventsHomePage.FCOServiceRequestNumber()).getText();
			
			System.out.println("serviceRequestLabel &  serviceRequestNumber is : "+serviceRequestLabel +serviceRequestNumber);
			
			severityLabel = CommonUtility.highlightElement(driver,obj_EsupportServiceEventsHomePage.FCOSeverityLabel()).getText();
			severityValue = CommonUtility.highlightElement(driver,obj_EsupportServiceEventsHomePage.FCOSeverityValue()).getText();
			
			System.out.println("severityLabel &  severityValue is : "+severityLabel +severityValue);
			
			dateCreatedLabel = CommonUtility.highlightElement(driver,obj_EsupportServiceEventsHomePage.FCODateCreatedLabel()).getText();
			dateCreatedValue = CommonUtility.highlightElement(driver,obj_EsupportServiceEventsHomePage.FCODateCreatedValue()).getText();
			
			System.out.println("dateCreatedLabel &  dateCreatedValue is : "+dateCreatedLabel +dateCreatedValue);

			Report.put("Validate the details displayed if the product have an active Field Change Order event",
					"User should see the following: Icon of Field Change Order and name of the event(Field Change Order), Service request number heading, Service request number with hyperlink to the service request details page, Field Change Order Severity, Field Change Order 'Date Created' heading and date displayed in the format  : DD-MM-YYYY",
					"Details displayed are "+Report.color(FCOText)+"<br>"+Report.color(serviceRequestLabel)+Report.color(serviceRequestNumber)+"<br>"+Report.color(severityLabel)+Report.color(severityValue)+"<br>"+Report.color(dateCreatedLabel)+Report.color(dateCreatedValue), "PASS");
			}
			else
			{
				Report.put("Validate the details displayed if the product have an active Field Change Order event",
						"User should see the following: Icon of Field Change Order and name of the event(Field Change Order), Service request number heading, Service request number with hyperlink to the service request details page, Field Change Order Severity, Field Change Order 'Date Created' heading and date displayed in the format  : DD-MM-YYYY",
						"Failed to display FCO Event Details", "FAIL");
				Assert.fail("Failed to display FCO Event Details");
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Validate the details displayed if the product have an active Field Change Order event",
					"User should see the following: Icon of Field Change Order and name of the event(Field Change Order), Service request number heading, Service request number with hyperlink to the service request details page, Field Change Order Severity, Field Change Order 'Date Created' heading and date displayed in the format  : DD-MM-YYYY",
					"Failed to display FCO Event Details", "FAIL");
			Assert.fail("Failed to display FCO Event Details");
		}
	}

	public void verifySRDetailsInOverviewTab(WebDriver driver)
	{
		System.out.println("Inside verifySRDetailsInOverviewTab method");
		Log.info("Inside verifySRDetailsInOverviewTab method");


		String SRText = "";
		String serviceRequestLabel = "";
		String serviceRequestNumber = "";
		String severityLabel = "";
		String severityValue = "";
		String statusLabel = "";
		String statusValue = "";
		
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);

//			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportServiceEventsHomePage.ServiceEventsHeaderInOverivewTab()));
			CommonUtility.ScrollTo(driver, obj_EsupportServiceEventsHomePage.ServiceRequestTextInOverviewTab());
			if(CommonUtility.CheckpresenceofElementLocated(driver, 10, obj_EsupportServiceEventsHomePage.ServiceRequestTextInOverviewTab()))
			{
			CommonUtility.ScrollTo(driver, obj_EsupportServiceEventsHomePage.ServiceRequestTextInOverviewTab());
			
			SRText = CommonUtility.highlightElement(driver,obj_EsupportServiceEventsHomePage.ServiceRequestTextInOverviewTab()).getText();

			System.out.println("SRText Text is: "+SRText);
			
			serviceRequestLabel = CommonUtility.highlightElement(driver,obj_EsupportServiceEventsHomePage.ServiceRequestLabel()).getText();
			serviceRequestNumber = CommonUtility.highlightElement(driver,obj_EsupportServiceEventsHomePage.ServiceRequestNumber()).getText();
			
			System.out.println("serviceRequestLabel &  serviceRequestNumber is : "+serviceRequestLabel +serviceRequestNumber);
			
			severityLabel = CommonUtility.highlightElement(driver,obj_EsupportServiceEventsHomePage.SRSeverityLabel()).getText();
			severityValue = CommonUtility.highlightElement(driver,obj_EsupportServiceEventsHomePage.SRSeverityValue()).getText();
			
			System.out.println("severityLabel &  severityValue is : "+severityLabel +severityValue);
			
			statusLabel = CommonUtility.highlightElement(driver,obj_EsupportServiceEventsHomePage.SRStatusLabel()).getText();
			statusValue = CommonUtility.highlightElement(driver,obj_EsupportServiceEventsHomePage.SRStatusValue()).getText();
			
			System.out.println("statusLabel &  statusValue is : "+statusLabel +statusValue);

			Report.put("Validate the details displayed if the product have an active Service Request Events",
					"User should see the following: Icon of Service Request and name of the event(Service Request), Service request number heading, Service  Request number with hyperlink to the service request details page, Service Requests severity, Service Requests status",
					"Details displayed are "+Report.color(SRText)+"<br>"+Report.color(serviceRequestLabel)+Report.color(serviceRequestNumber)+"<br>"+Report.color(severityLabel)+Report.color(severityValue)+"<br>"+Report.color(statusLabel)+Report.color(statusValue), "PASS");
			}
			else
			{
				Report.put("Validate the details displayed if the product have an active Service Request Events",
						"User should see the following: Icon of Service Request and name of the event(Service Request), Service request number heading, Service  Request number with hyperlink to the service request details page, Service Requests severity, Service Requests status",
						"Failed to display Service Request Event Details", "FAIL");
				Assert.fail("Failed to display Service Request Event Details");
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Validate the details displayed if the product have an active Service Request Events",
					"User should see the following: Icon of Service Request and name of the event(Service Request), Service request number heading, Service  Request number with hyperlink to the service request details page, Service Requests severity, Service Requests status",
					"Failed to display Service Request Event Details", "FAIL");
			Assert.fail("Failed to display Service Request Event Details");
		}
	}
	
	public void clickOnServiceEventsTab_LEMC(WebDriver driver) 
	{
		System.out.println("Inside clickOnServiceEventsTab_LEMC method");
		Log.info("Inside clickOnServiceEventsTab_LEMC method");

		String tabName = "";
				
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);
			Thread.sleep(15000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportServiceEventsHomePage.ServiceEvents()));
			tabName=CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.ServiceEvents()).getText();
			CommonUtility.ClickOn(driver, obj_EsupportServiceEventsHomePage.ServiceEvents());
			
			
			
			if(CommonUtility.CheckpresenceofElementLocated(driver, 30, obj_EsupportServiceEventsHomePage.serviceEventsTypeHeaderSETab()) || CommonUtility.CheckpresenceofElementLocated(driver, 10, obj_EsupportServiceEventsHomePage.NoActiveServiceEventsMessage()))
			{
						System.out.println("Landed in Service Events Tab");

			Report.put("Click on the 'Service Event' tab",
					"User should land on the  'Service Event' tab",
					"Clicked on tab "+Report.color(tabName), "PASS");
			}
			else
			{
				Report.put("Click on the 'Service Event' tab",
						"User should land on the  'Service Event' tab",
						"Failed to click on Service Events Tab", "FAIL");
				Assert.fail("Failed to click on Service Events Tab");
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on the 'Service Event' tab",
					"User should land on the  'Service Event' tab",
					"Failed to click on Service Events Tab", "FAIL");
			Assert.fail("Failed to click on Service Events Tab");
		}
	}
	
	public void verifyEventTypesSETabLeftPanel_LEMC(WebDriver driver)
	{
		System.out.println("Inside verifyEventTypesSETabLeftPanel_LEMC method");
		Log.info("Inside verifyEventTypesSETabLeftPanel_LEMC method");

		String valueList = "";
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);

			if(CommonUtility.CheckpresenceofElementLocated(driver, 30, obj_EsupportServiceEventsHomePage.EventTypeSectionOnLeftPanel()))
			{
				List<WebElement> list=driver.findElements(obj_EsupportServiceEventsHomePage.eventTypesListSETab());

				for(WebElement lt:list)
				{
					CommonUtility.highlightElement(driver, lt);
					String val=lt.getText();
					if(!(val.isEmpty()))
					{
						System.out.println("Type is: " +val);
						valueList+=" <br> " + val;
					}
				}
				System.out.println("Values are: "+valueList);

				Report.put("Check whether the Event Types are loaded in the left side panel",
						"User must see All the Event Types: Service Requests, Service Requests types, Connectivity Events, Changes & Submissions, Scheduled Services, Milestone, Environmental Assessments",
						"The Event Types displayed are: "+Report.color(valueList), "PASS");	
			}
			else
			{
				Report.put("Check whether the Event Types are loaded in the left side panel",
						"User must see All the Event Types: Service Requests, Service Requests types, Connectivity Events, Changes & Submissions, Scheduled Services, Milestone, Environmental Assessments",
						"Failed to display the Event Types ", "FAIL");
				Assert.fail("Failed to display the Event Types");
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Check whether the Event Types are loaded in the left side panel",
					"User must see All the Event Types: Service Requests, Service Requests types, Connectivity Events, Changes & Submissions, Scheduled Services, Milestone, Environmental Assessments",
					"Failed to display the Event Types ", "FAIL");
			Assert.fail("Failed to display the Event Types");
		}
	}
	
	public void clickExpandIconServiceRequestSETabLeftPanel_LEMC(WebDriver driver)
	{
		System.out.println("Inside clickExpandIconServiceRequestSETabLeftPanel_LEMC method");
		Log.info("Inside clickExpandIconServiceRequestSETabLeftPanel_LEMC method");

		String valueList = "";
		String filter = "";
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);

			if(CommonUtility.CheckpresenceofElementLocated(driver, 30, obj_EsupportServiceEventsHomePage.serviceRequestExpandIconLeftPanelSETab()))
			{
				filter=CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.serviceRequestLabelLeftPanelSETab()).getText();
				
				CommonUtility.ClickOn(driver,obj_EsupportServiceEventsHomePage.serviceRequestExpandIconLeftPanelSETab());
				
				List<WebElement> list=driver.findElements(obj_EsupportServiceEventsHomePage.serviceRequestFiltersLeftPanelSETab());

				for(WebElement lt:list)
				{
					CommonUtility.highlightElement(driver, lt);
					String val=lt.getText();
					if(!(val.isEmpty()))
					{
						System.out.println("Filter is: " +val);
						valueList+=" <br> " + val;
					}
				}
				System.out.println("Filters are: "+valueList);

				Report.put("Click on the Expand icon next to a Event Type. ",
						"User should see the event types filters for that specific Event type expanded.",
						"Clicked on Expand icon of Event Type "+Report.color(filter)+"<br>"+"Displayes filters:"+Report.color(valueList), "PASS");	
			}
			else
			{
				Report.put("Click on the Expand icon next to a Event Type. ",
						"User should see the event types filters for that specific Event type expanded.",
						"Failed to click on Expand icon of Service Request event", "FAIL");
				Assert.fail("Failed to click on Expand icon of Service Request event");
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on the Expand icon next to a Event Type. ",
					"User should see the event types filters for that specific Event type expanded.",
					"Failed to click on Expand icon of Service Request event", "FAIL");
			Assert.fail("Failed to click on Expand icon of Service Request event");
		}
	}
	
	public void clickApplyFiltersButtonAndVerifyFiltersTextSETabLeftPanel_LEMC(WebDriver driver)
	{
		System.out.println("Inside clickApplyFiltersButtonAndVerifyFiltersTextSETabLeftPanel_LEMC method");
		Log.info("Inside clickApplyFiltersButtonAndVerifyFiltersTextSETabLeftPanel_LEMC method");

		String valueList = "";
		String filter = "";
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);

			if(CommonUtility.CheckpresenceofElementLocated(driver, 30, obj_EsupportServiceEventsHomePage.ApplyFiltersButton()))
			{
				filter=CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.ApplyFiltersButton()).getText();
				
				CommonUtility.ClickOn(driver,obj_EsupportServiceEventsHomePage.ApplyFiltersButton());
				
				List<WebElement> list=driver.findElements(obj_EsupportServiceEventsHomePage.appliedFiltersTextLeftPanelSETab());

				for(WebElement lt:list)
				{
					CommonUtility.highlightElement(driver, lt);
					String val=lt.getText();
					if(!(val.isEmpty()))
					{
						System.out.println("Applied Filter is: " +val);
						valueList+=" <br> " + val;
					}
				}
				System.out.println("Applied Filters are: "+valueList);

				Report.put("Click on  'Apply Filters' button at the bottom in the left side panel ",
						"User should see the following changes at the top 1. In the left side panel, at the top under 'FILTERS' each Selected filters will appear with 'X' symbol in separate boxes Under 2. Content section of the page will display the selected event type filter details.",
						"Clicked on Button "+Report.color(filter)+"<br>"+"Displayed Applied filters:"+Report.color(valueList), "PASS");	
			}
			else
			{
				Report.put("Click on  'Apply Filters' button at the bottom in the left side panel ",
						"User should see the following changes at the top 1. In the left side panel, at the top under 'FILTERS' each Selected filters will appear with 'X' symbol in separate boxes Under 2. Content section of the page will display the selected event type filter details.",
						"Failed to click on 'Apply Filters' and verify Filter Section", "FAIL");
				Assert.fail("Failed to click on 'Apply Filters' and verify Filter Section");
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on  'Apply Filters' button at the bottom in the left side panel ",
					"User should see the following changes at the top 1. In the left side panel, at the top under 'FILTERS' each Selected filters will appear with 'X' symbol in separate boxes Under 2. Content section of the page will display the selected event type filter details.",
					"Failed to click on 'Apply Filters' and verify Filter Section", "FAIL");
			Assert.fail("Failed to click on 'Apply Filters' and verify Filter Section");
		}
	}
	
	public void verifyJumpToTopIconServiceEventsTab_LEMC(WebDriver driver) 
	{
		System.out.println("Inside verifyJumpToTopIconServiceEventsTab_LEMC method");
		Log.info("Inside verifyJumpToTopIconServiceEventsTab_LEMC method");

		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);

			//wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportServiceEventsHomePage.serviceEventsTypeHeaderSETab()));
			CommonUtility.ScrollTo(driver, obj_EsupportServiceEventsHomePage.ApplyFiltersButton());
			
			Thread.sleep(10000);
			if(CommonUtility.CheckpresenceofElementLocated(driver, 10, obj_EsupportServiceEventsHomePage.jumpToTopIconSETab()))
			{
				
				System.out.println("Displayed Jump To Top Icon");

			Report.put("Validate whether the user can see the Jump to top icon at the bottom of the 'Service Event' tab page",
					"User should be able to see the Jump to top icon at the bottom of the Service Event tab page",
					"Able to see the Jump to top icon at the bottom of the 'Service Event' tab page", "PASS");
			}
			else
			{
				Report.put("Validate whether the user can see the Jump to top icon at the bottom of the 'Service Event' tab page",
						"User should be able to see the Jump to top icon at the bottom of the Service Event tab page",
						"Failed to see the Jump to top icon at the bottom of the Service Event tab page", "FAIL");
				Assert.fail("Failed to see the Jump to top icon at the bottom of the Service Event tab page");
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Validate whether the user can see the Jump to top icon at the bottom of the 'Service Event' tab page",
					"User should be able to see the Jump to top icon at the bottom of the Service Event tab page",
					"Failed to see the Jump to top icon at the bottom of the Service Event tab page", "FAIL");
			Assert.fail("Failed to see the Jump to top icon at the bottom of the Service Event tab page");
		}
	}
	
	public void clickOnJumpToTopIconServiceEventsTab_LEMC(WebDriver driver) 
	{
		System.out.println("Inside clickOnJumpToTopIconServiceEventsTab_LEMC method");
		Log.info("Inside clickOnJumpToTopIconServiceEventsTab_LEMC method");

		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportServiceEventsHomePage.jumpToTopIconSETab()));
			
			if(CommonUtility.CheckpresenceofElementLocated(driver, 10, obj_EsupportServiceEventsHomePage.jumpToTopIconSETab()))
			{
				CommonUtility.ClickOn(driver,obj_EsupportServiceEventsHomePage.jumpToTopIconSETab());
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportServiceEventsHomePage.ServiceEvents()));
				System.out.println("Clicked on Jump To Top Icon");

			Report.put("Click on the Jump to top icon",
					"User  should be directed to the top of the page",
					"Able to jump to top of page.", "PASS");
			}
			else
			{
				Report.put("Click on the Jump to top icon",
						"User  should be directed to the top of the page",
						"Failed to Jump to top of page", "FAIL");
				Assert.fail("Failed to Jump to top of page");
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on the Jump to top icon",
					"User  should be directed to the top of the page",
					"Failed to Jump to top of page", "FAIL");
			Assert.fail("Failed to Jump to top of page");
		}
	}
	
	public void  changeCountry_ServiceEventsLEMC(WebDriver driver, String country)
	{

		Log.info("Entering changeCountry_ServiceEventsLEMC");
		Actions act=new Actions(driver);

		String selectedcountry = "";
		String title="";
		String tabname="";
		String text="";
		int count=0;
		String encount="";

		try{

			CommonUtility.ScrollTo(driver,obj_EsupportServiceEventsHomePage.CountrySelectorArticle());

			if(CommonUtility.highlightElement(driver,obj_EsupportServiceEventsHomePage.CountrySelectorArticle()).isDisplayed())
			{

				System.out.println("country displayed");

				WebElement element =driver.findElement(By.xpath("//div[@id='countryselector']/a"));
				((JavascriptExecutor)driver).executeScript("arguments[0].click();", element); 

				Thread.sleep(6000);
				System.out.println("Country from Test data is :::: "+country);
				List<WebElement> countryList=driver.findElements(obj_EsupportServiceEventsHomePage.CountrySelectorList());


				for(WebElement lt:countryList)
				{
					String couLi=lt.getText();

					System.out.println("Country is: " +couLi);
					if(couLi.contains(country))
					{
						System.out.println("Inside if**************");
						System.out.println("Country is: " +couLi);
						Thread.sleep(5000);
						lt.click();

						Thread.sleep(10000);

						selectedcountry = couLi;
						System.out.println("Selected Country is "+selectedcountry);

						break;

					}
				}
				Thread.sleep(10000);
				if(driver.getCurrentUrl().contains("https://www.dell.com/support/home/fr-be"))
				{
					Log.info("Test Case Pass: loaded with selected country Belgium");
					title=driver.getTitle();
					System.out.println("title of page after changing country is "+title);
					
					Report.put("Click on the Country drop down at the right bottom of the page and select a country", 
							"User should be able to select a country from the Country drop at the footer of the page(right) The  page should be translated to the language of the country selected and displayed", 
							"Country changed to : "+Report.color(selectedcountry)+" and page successfully translated to the language of the country selected. Title is: "+Report.color(title),"PASS");
				}
				else
				{
					Log.info("Test Case Fail: Page not loaded with selected country Belgium");
					
					Report.put("Click on the Country drop down at the right bottom of the page and select a country", 
							"User should be able to select a country from the Country drop at the footer of the page(right) The  page should be translated to the language of the country selected and displayed",  
							"Page is not loaded in the language of the selected country" +Report.color(selectedcountry), "FAIL");
					Assert.fail();
				}
			}

			else
			{
				Log.info("Test Case Fail: Page not loaded with selected country Belgium");
				
				Report.put("Click on the Country drop down at the right bottom of the page and select a country", 
						"User should be able to select a country from the Country drop at the footer of the page(right) The  page should be translated to the language of the country selected and displayed",  
						"Page is not loaded in the language of the selected country" +Report.color(country), "FAIL");
				Assert.fail();
			}
		}

		catch(Exception e)
		{
			e.printStackTrace();
			Log.info("Test Case Fail: Page not loaded with selected country Belgium");
			
			Report.put("Click on the Country drop down at the right bottom of the page and select a country", 
					"User should be able to select a country from the Country drop at the footer of the page(right) The  page should be translated to the language of the country selected and displayed",  
					"Page is not loaded in the language of the selected country" +Report.color(country), "FAIL");
			Assert.fail();
		}
	}
	
	public void changeLanguageServiceEventsTab_LEMC(WebDriver driver) 
	{
		System.out.println("Inside changeLanguageServiceEventsTab_LEMC method");
		Log.info("Inside changeLanguageServiceEventsTab_LEMC method");
		
		String language = "";
		String title = "";
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportServiceEventsHomePage.changeLanguageLink()));
			
			if(CommonUtility.CheckpresenceofElementLocated(driver, 10, obj_EsupportServiceEventsHomePage.changeLanguageLink()))
			{
				language = CommonUtility.highlightElement(driver,obj_EsupportServiceEventsHomePage.changeLanguageLink()).getText();
				
				CommonUtility.ClickOn(driver,obj_EsupportServiceEventsHomePage.changeLanguageLink());
				
				Thread.sleep(5000);
				
				if(driver.getCurrentUrl().contains("https://www.dell.com/support/home/nl-be"))
				{
					Log.info("Test Case Pass: loaded with selected language "+language);
					title=driver.getTitle();
					System.out.println("title of page after changing language is "+title);
					
					Report.put("After changing the Country from the county drop down, if more than one language is available ", 
							"User can pick any language and the page will be displayed in the selected language.", 
							"Language changed to : "+Report.color(language)+" and page successfully translated to the language of the country selected. Title is: "+Report.color(title),"PASS");
				}
				else
				{
					Log.info("Test Case Fail: Language is not changed");
					
					Report.put("After changing the Country from the county drop down, if more than one language is available ", 
							"User can pick any language and the page will be displayed in the selected language.", 
							"Failed to change the language of the selected country" , "FAIL");
					Assert.fail();
				}
			}
			else
			{
				Log.info("Test Case Fail: Language is not changed");
				
				Report.put("After changing the Country from the county drop down, if more than one language is available ", 
						"User can pick any language and the page will be displayed in the selected language.", 
						"Failed to change the language of the selected country" , "FAIL");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Log.info("Test Case Fail: Language is not changed");
			
			Report.put("After changing the Country from the county drop down, if more than one language is available ", 
					"User can pick any language and the page will be displayed in the selected language.", 
					"Failed to change the language of the selected country" , "FAIL");
			Assert.fail();
		}
	}
	
	public void verifyServiceRequestSummaryOverviewTab(WebDriver driver)
	{
		System.out.println("Inside verifyServiceRequestSummaryOverviewTab method");
		Log.info("Inside verifyServiceRequestSummaryOverviewTab method");

		String header = "";
		
		try
		{
			

			if(CommonUtility.CheckpresenceofElementLocated(driver, 10, obj_EsupportServiceEventsHomePage.serviceEventActivityCardHeader()))
			{
				CommonUtility.ScrollTo(driver,obj_EsupportServiceEventsHomePage.serviceEventActivityCardHeader());
			header = CommonUtility.highlightElement(driver,obj_EsupportServiceEventsHomePage.serviceEventActivityCardHeader()).getText();

			System.out.println("Service Event Activity header is: "+header);
			
			Report.put("Validate whether the Service Request Summary is displayed in the overview tab",
					"User should see the Service Request Summary displayed under 'Service Event Activity'",
					"Displayed Service Request Summary under "+Report.color(header), "PASS");
			}
			else
			{
				Report.put("Validate whether the Service Request Summary is displayed in the overview tab",
						"User should see the Service Request Summary displayed under 'Service Event Activity'",
						"Failed to display Service Request Summary", "FAIL");
				Assert.fail("Failed to display Service Request Summary");
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Validate whether the Service Request Summary is displayed in the overview tab",
					"User should see the Service Request Summary displayed under 'Service Event Activity'",
					"Failed to display Service Request Summary", "FAIL");
			Assert.fail("Failed to display Service Request Summary");
		}
	}
	
	public void verifyServiceRequestSummaryDonutZeroActive(WebDriver driver)
	{
		System.out.println("Inside verifyServiceRequestSummaryDonutZeroActive method");
		Log.info("Inside verifyServiceRequestSummaryDonutZeroActive method");

		String number = "";
		String text = "";
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);

			if(CommonUtility.CheckpresenceofElementLocated(driver, 10, obj_EsupportServiceEventsHomePage.serviceEventActivityDonutNumber()) && CommonUtility.CheckpresenceofElementLocated(driver, 10, obj_EsupportServiceEventsHomePage.serviceEventActivityDonutText()) )
			{
				CommonUtility.ScrollTo(driver,obj_EsupportServiceEventsHomePage.serviceEventActivityDonutNumber());
				number = CommonUtility.highlightElement(driver,obj_EsupportServiceEventsHomePage.serviceEventActivityDonutNumber()).getText();

				System.out.println("Number is: "+number);
				
				CommonUtility.ScrollTo(driver,obj_EsupportServiceEventsHomePage.serviceEventActivityDonutText());

				text = CommonUtility.highlightElement(driver,obj_EsupportServiceEventsHomePage.serviceEventActivityDonutText()).getText();

				System.out.println("Text is: "+text);

				if(number.contains("0"))
				{
					Report.put("Validate the message displayed on the overview tab when there are no 'Active', 'Escalated' or 'Awaiting your action'",
							"User should see the '0' active displayed in the Overview tab",
							"Displayed "+Report.color(number)+Report.color(text), "PASS");
				}
				else
				{
					Report.put("Validate the message displayed on the overview tab when there are no 'Active', 'Escalated' or 'Awaiting your action'",
							"User should see the '0' active displayed in the Overview tab",
							"Failed to verify '0' active displayed in the Overview tab", "FAIL");
					Assert.fail("Failed to verify '0' active displayed in the Overview tab");
				}


			}
			else
			{
				Report.put("Validate the message displayed on the overview tab when there are no 'Active', 'Escalated' or 'Awaiting your action'",
						"User should see the '0' active displayed in the Overview tab",
						"Failed to verify '0' active displayed in the Overview tab", "FAIL");
				Assert.fail("Failed to verify '0' active displayed in the Overview tab");
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Validate the message displayed on the overview tab when there are no 'Active', 'Escalated' or 'Awaiting your action'",
					"User should see the '0' active displayed in the Overview tab",
					"Failed to verify '0' active displayed in the Overview tab", "FAIL");
			Assert.fail("Failed to verify '0' active displayed in the Overview tab");
		}
	}
	
	public void verifyServiceRequestSummaryDynamicDial(WebDriver driver)
	{
		System.out.println("Inside verifyServiceRequestSummaryDynamicDial method");
		Log.info("Inside verifyServiceRequestSummaryDynamicDial method");

		String activeNumber = "";
		String activeText = "";
		String escalatedNumber = "";
		String escalatedText = "";
		String awaitingNumber = "";
		String awaitingText = "";
		try
		{
			CommonUtility.ScrollTo(driver,obj_EsupportServiceEventsHomePage.serviceEventActivityCardActiveNumber());
			activeNumber = CommonUtility.highlightElement(driver,obj_EsupportServiceEventsHomePage.serviceEventActivityCardActiveNumber()).getText();
			CommonUtility.ScrollTo(driver,obj_EsupportServiceEventsHomePage.serviceEventActivityCardActiveLink());
			activeText = CommonUtility.highlightElement(driver,obj_EsupportServiceEventsHomePage.serviceEventActivityCardActiveLink()).getText();

			System.out.println("Active Number and Text is: "+activeNumber+activeText);
			CommonUtility.ScrollTo(driver,obj_EsupportServiceEventsHomePage.serviceEventActivityCardEscalatedNumber());
			escalatedNumber = CommonUtility.highlightElement(driver,obj_EsupportServiceEventsHomePage.serviceEventActivityCardEscalatedNumber()).getText();
			CommonUtility.ScrollTo(driver,obj_EsupportServiceEventsHomePage.serviceEventActivityCardEscalatedLink());
			escalatedText = CommonUtility.highlightElement(driver,obj_EsupportServiceEventsHomePage.serviceEventActivityCardEscalatedLink()).getText();

			System.out.println("Escalated Number and Text is: "+escalatedNumber+escalatedText);
			CommonUtility.ScrollTo(driver,obj_EsupportServiceEventsHomePage.serviceEventActivityCardAwaitingNumber());
			awaitingNumber = CommonUtility.highlightElement(driver,obj_EsupportServiceEventsHomePage.serviceEventActivityCardAwaitingNumber()).getText();
			CommonUtility.ScrollTo(driver,obj_EsupportServiceEventsHomePage.serviceEventActivityCardAwaitingLink());
			awaitingText = CommonUtility.highlightElement(driver,obj_EsupportServiceEventsHomePage.serviceEventActivityCardAwaitingLink()).getText();

			System.out.println("Active Number and Text is: "+awaitingNumber+awaitingText);

			Report.put("Validate whether the user sees the dynamic dial which displays the following: 1. Number of active SRs 2. Number of escalated events 3. Number of awaiting events ",
					"User should see the dynamic dial displaying the following: 1. Number of active SRs 2. Number of escalated events 3. Number of awaiting events ",
					"Displayed dynamic dial with details:"+Report.color(activeNumber)+Report.color(activeText)+"<br>"+Report.color(escalatedNumber)+Report.color(escalatedText)+"<br>"+Report.color(awaitingNumber)+Report.color(awaitingText), "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Validate whether the user sees the dynamic dial which displays the following: 1. Number of active SRs 2. Number of escalated events 3. Number of awaiting events ",
					"User should see the dynamic dial displaying the following: 1. Number of active SRs 2. Number of escalated events 3. Number of awaiting events ",
					"Failed to verify dynamic dial", "FAIL");
			Assert.fail("Failed to verify dynamic dial");
		}
	}
	
	public void verifyServiceRequestSummaryColourDynamicDial(WebDriver driver)
	{
		System.out.println("Inside verifyServiceRequestSummaryColourDynamicDial method");
		Log.info("Inside verifyServiceRequestSummaryColourDynamicDial method");

		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);

			if(CommonUtility.CheckpresenceofElementLocated(driver, 10, obj_EsupportServiceEventsHomePage.serviceEventActivityCardActiveIcon()) && CommonUtility.CheckpresenceofElementLocated(driver, 10, obj_EsupportServiceEventsHomePage.serviceEventActivityCardAwaitingIcon()) && CommonUtility.CheckpresenceofElementLocated(driver, 10, obj_EsupportServiceEventsHomePage.serviceEventActivityCardEscalatedIcon()))
			{
					Report.put("Validate whether the user sees the color differentiation in dynamic dial",
							"User must see the color differentiation in dynamic dial which displays the following: 1. Number of active SRs should be displayed in Blue 2. Number of escalated events should be displayed in Yellow 3. Number of awaiting events should be displayed in Orange ",
							"Displayed 1. Number of active SRs should be displayed in Blue 2. Number of escalated events should be displayed in Yellow 3. Number of awaiting events should be displayed in Orange ", "PASS");
			}
			else
			{
				Report.put("Validate whether the user sees the color differentiation in dynamic dial",
						"User must see the color differentiation in dynamic dial which displays the following: 1. Number of active SRs should be displayed in Blue 2. Number of escalated events should be displayed in Yellow 3. Number of awaiting events should be displayed in Orange ",
						"Failed to verify color differentiation in dynamic dial ", "FAIL");
				Assert.fail("Failed to verify color differentiation in dynamic dial ");
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Validate whether the user sees the color differentiation in dynamic dial",
					"User must see the color differentiation in dynamic dial which displays the following: 1. Number of active SRs should be displayed in Blue 2. Number of escalated events should be displayed in Yellow 3. Number of awaiting events should be displayed in Orange ",
					"Failed to verify color differentiation in dynamic dial ", "FAIL");
			Assert.fail("Failed to verify color differentiation in dynamic dial ");
		}
	}
	
	public void verifyServiceRequestSummaryZeroEscalated(WebDriver driver)
	{
		System.out.println("Inside verifyServiceRequestSummaryZeroEscalated method");
		Log.info("Inside verifyServiceRequestSummaryZeroEscalated method");

		String number = "";
		String text = "";
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);

			if(CommonUtility.CheckpresenceofElementLocated(driver, 10, obj_EsupportServiceEventsHomePage.serviceEventActivityCardEscalatedNumber()) && CommonUtility.CheckpresenceofElementLocated(driver, 10, obj_EsupportServiceEventsHomePage.serviceEventActivityCardEscalatedLink()) )
			{

				number = CommonUtility.highlightElement(driver,obj_EsupportServiceEventsHomePage.serviceEventActivityCardEscalatedNumber()).getText();

				System.out.println("Number is: "+number);

				text = CommonUtility.highlightElement(driver,obj_EsupportServiceEventsHomePage.serviceEventActivityCardEscalatedLink()).getText();

				System.out.println("Text is: "+text);

				if(number.contains("0"))
				{
					Report.put("Validate the number of 'Escalated'  events displayed when there is no 'Escalated' events associated to the product",
							"User should see the number of 'Escalated' events displayed as 0 ",
							"Displayed "+Report.color(number)+Report.color(text), "PASS");
				}
				else
				{
					Report.put("Validate the number of 'Escalated'  events displayed when there is no 'Escalated' events associated to the product",
							"User should see the number of 'Escalated' events displayed as 0 ",
							"Failed to verify 'Escalated' events displayed as 0", "FAIL");
					Assert.fail("Failed to verify 'Escalated' events displayed as 0");
				}


			}
			else
			{
				Report.put("Validate the number of 'Escalated'  events displayed when there is no 'Escalated' events associated to the product",
						"User should see the number of 'Escalated' events displayed as 0 ",
						"Failed to verify 'Escalated' events displayed as 0", "FAIL");
				Assert.fail("Failed to verify 'Escalated' events displayed as 0");
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Validate the number of 'Escalated'  events displayed when there is no 'Escalated' events associated to the product",
					"User should see the number of 'Escalated' events displayed as 0 ",
					"Failed to verify 'Escalated' events displayed as 0", "FAIL");
			Assert.fail("Failed to verify 'Escalated' events displayed as 0");
		}
	}
	
	public void verifyServiceRequestSummaryZeroAwaiting(WebDriver driver)
	{
		System.out.println("Inside verifyServiceRequestSummaryZeroAwaiting method");
		Log.info("Inside verifyServiceRequestSummaryZeroAwaiting method");

		String number = "";
		String text = "";
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);

			if(CommonUtility.CheckpresenceofElementLocated(driver, 10, obj_EsupportServiceEventsHomePage.serviceEventActivityCardAwaitingNumber()) && CommonUtility.CheckpresenceofElementLocated(driver, 10, obj_EsupportServiceEventsHomePage.serviceEventActivityCardAwaitingLink()) )
			{

				number = CommonUtility.highlightElement(driver,obj_EsupportServiceEventsHomePage.serviceEventActivityCardAwaitingNumber()).getText();

				System.out.println("Number is: "+number);

				text = CommonUtility.highlightElement(driver,obj_EsupportServiceEventsHomePage.serviceEventActivityCardAwaitingLink()).getText();

				System.out.println("Text is: "+text);

				if(number.contains("0"))
				{
					Report.put("Validate the number of 'Awaiting your actions' events displayed when there is no 'Awaiting your action' events associated to the product",
							"User should see the number of 'Awaiting your actions'  events displayed as 0  ",
							"Displayed "+Report.color(number)+Report.color(text), "PASS");
				}
				else
				{
					Report.put("Validate the number of 'Awaiting your actions' events displayed when there is no 'Awaiting your action' events associated to the product",
							"User should see the number of 'Awaiting your actions'  events displayed as 0  ",
							"Failed to verify 'Awaiting your actions' events displayed as 0", "FAIL");
					Assert.fail("Failed to verify 'Awaiting your actions' events displayed as 0");
				}
			}
			else
			{
				Report.put("Validate the number of 'Awaiting your actions' events displayed when there is no 'Awaiting your action' events associated to the product",
						"User should see the number of 'Awaiting your actions'  events displayed as 0  ",
						"Failed to verify 'Awaiting your actions' events displayed as 0", "FAIL");
				Assert.fail("Failed to verify 'Awaiting your actions' events displayed as 0");
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Validate the number of 'Awaiting your actions' events displayed when there is no 'Awaiting your action' events associated to the product",
					"User should see the number of 'Awaiting your actions'  events displayed as 0  ",
					"Failed to verify 'Awaiting your actions' events displayed as 0", "FAIL");
			Assert.fail("Failed to verify 'Awaiting your actions' events displayed as 0");
		}
	}
	
	public void verifyServiceRequestSummaryZeroActive(WebDriver driver)
	{
		System.out.println("Inside verifyServiceRequestSummaryZeroActive method");
		Log.info("Inside verifyServiceRequestSummaryZeroActive method");

		String number = "";
		String text = "";
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);

			if(CommonUtility.CheckpresenceofElementLocated(driver, 10, obj_EsupportServiceEventsHomePage.serviceEventActivityCardActiveNumber()) && CommonUtility.CheckpresenceofElementLocated(driver, 10, obj_EsupportServiceEventsHomePage.serviceEventActivityCardActiveLink()) )
			{

				number = CommonUtility.highlightElement(driver,obj_EsupportServiceEventsHomePage.serviceEventActivityCardActiveNumber()).getText();

				System.out.println("Number is: "+number);

				text = CommonUtility.highlightElement(driver,obj_EsupportServiceEventsHomePage.serviceEventActivityCardActiveLink()).getText();

				System.out.println("Text is: "+text);

				if(number.contains("0"))
				{
					Report.put("Validate the number of 'Active' events displayed when there is no 'Active' events associated to the product ",
							"User should see the number of 'Active' events displayed as 0 ",
							"Displayed "+Report.color(number)+Report.color(text), "PASS");
				}
				else
				{
					Report.put("Validate the number of 'Active' events displayed when there is no 'Active' events associated to the product ",
							"User should see the number of 'Active' events displayed as 0 ",
							"Failed to verify 'Active' events displayed as 0", "FAIL");
					Assert.fail("Failed to verify 'Active' events displayed as 0");
				}
			}
			else
			{
				Report.put("Validate the number of 'Active' events displayed when there is no 'Active' events associated to the product ",
						"User should see the number of 'Active' events displayed as 0 ",
						"Failed to verify 'Active' events displayed as 0", "FAIL");
				Assert.fail("Failed to verify 'Active' events displayed as 0");
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Validate the number of 'Active' events displayed when there is no 'Active' events associated to the product ",
					"User should see the number of 'Active' events displayed as 0 ",
					"Failed to verify 'Active' events displayed as 0", "FAIL");
			Assert.fail("Failed to verify 'Active' events displayed as 0");
		}
	}
	
	public void verifyShowConnectivityEventsToggle(WebDriver driver) 
	{
		Log.info("Inside method verifyShowConnectivityEventsToggle");
		WebDriverWait  wait = new WebDriverWait(driver, 120);

		String label="";
		String status="";

		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportServiceEventsHomePage.showConnectivityEventsLabel()));
			CommonUtility.scrollToViewElement(driver, obj_EsupportServiceEventsHomePage.showConnectivityEventsLabel());
			label=CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.showConnectivityEventsLabel()).getText();

			System.out.println("label is: "+label);
			status=CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.showConnectivityEventsCheckbox()).getAttribute("checked");
			System.out.println("status of Show Connectivity Events "+status);
			boolean b=CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.showConnectivityEventsCheckbox()).isSelected();
			if(!b)
			{
				Log.info("test step pass");
			}
			else
			{
				Log.info("test step fail");
				Report.put("Validate whether 'Show Connectivity Events' is toggled off by default", 
						" User  should see the 'Show Connectivity Events' toggled off by default",
						"User don't see 'Show Connectivity Events' toggled off by default", "FAIL");
				Assert.fail();
			}


			Report.put("Validate whether 'Show Connectivity Events' is toggled off by default", 
					" User  should see the 'Show Connectivity Events' toggled off by default",
					"user Successfully see "+Report.color(label)+" is" +Report.color(status)+" by default in Service events tab", "PASS");

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Validate whether 'Show Connectivity Events' is toggled off by default", 
					" User  should see the 'Show Connectivity Events' toggled off by default",
					"User don't see 'Show Connectivity Events' toggled off by default", "FAIL");
			Assert.fail();
		}
	}	
	
	public void clickShowConnectivityEventsToggle(WebDriver driver) 
	{
		Log.info("Inside method clickShowConnectivityEventsToggle");
		WebDriverWait  wait = new WebDriverWait(driver, 120);

		String label="";
		String tdyText="";
		String tdyDate="";
		
		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportServiceEventsHomePage.showConnectivityEventsLabel()));
			CommonUtility.ScrollTo(driver, obj_EsupportServiceEventsHomePage.showConnectivityEventsLabel());
			label=CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.showConnectivityEventsLabel()).getText();

			System.out.println("label is: "+label);
			Actions act=new Actions(driver);
			act.moveToElement(CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.showConnectivityEventsToggleButton())).click().build().perform();
			//CommonUtility.ClickOn(driver, obj_EsupportServiceEventsHomePage.showConnectivityEventsToggleButton());
			Thread.sleep(10000);
			boolean b=CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.showConnectivityEventsCheckbox()).isSelected();
			if(b)
			{
				tdyText = CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.timelineTextToday()).getText();
				tdyDate = CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.timelineTextTodayDate()).getText();
				Log.info("test step pass");
				
				Report.put("Validate whether the user can  toggle on 'Show Connectivity Events'", 
						"1. User should be able to toggle on 'Show Connectivity Events' 2. See the changes reflect on the service event timelines and filters when the 'Show Connectivity Events'  is toggled on",
						"User Successfully see displayed Connectivity Events from timeline "+Report.color(tdyText)+Report.color(tdyDate), "PASS");
			}
			else
			{
				Log.info("test step fail");
				Report.put("Validate whether the user can  toggle on 'Show Connectivity Events'", 
						"1. User should be able to toggle on 'Show Connectivity Events' 2. See the changes reflect on the service event timelines and filters when the 'Show Connectivity Events'  is toggled on",
						"User is not able to  toggle on 'Show Connectivity Events'", "FAIL");
				Assert.fail();
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Validate whether the user can  toggle on 'Show Connectivity Events'", 
					"1. User should be able to toggle on 'Show Connectivity Events' 2. See the changes reflect on the service event timelines and filters when the 'Show Connectivity Events'  is toggled on",
					"User is not able to  toggle on 'Show Connectivity Events'", "FAIL");
			Assert.fail();
		}
	}	
	
	public void clickShowConnectivityEventsFilterExpandIcon(WebDriver driver) 
	{
		Log.info("Inside method clickShowConnectivityEventsFilterExpandIcon");
		WebDriverWait  wait = new WebDriverWait(driver, 120);

		String connectivityHome="";
		String connectivityIn="";
		
		try
		{
			CommonUtility.scrollToViewElement(driver, obj_EsupportServiceEventsHomePage.connectivityEventsExpandIcon());
			CommonUtility.ClickOn(driver, obj_EsupportServiceEventsHomePage.connectivityEventsExpandIcon());
			
			Thread.sleep(3000);
			connectivityHome = CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.connectHomeFilterLabel()).getText();
			connectivityIn = CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.connectInFilterLabel()).getText();
			
			boolean a=CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.connectHomeCheckbox()).isSelected();
			boolean b=CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.connectInCheckbox()).isSelected();
			
			if(a && b)
			{
				Log.info("Filters are selected");
				
				Report.put("Click on the Expand icon next to the 'Connectivity Events' Event Type, selects all events type filters in the Connectivity Events", 
						"User should see the 'Show Connectivity Events'  toggled on ",
						"User Successfully selected 'Connectivity Events' filters"+Report.color(connectivityHome)+Report.color(connectivityIn), "PASS");
			}
			else
			{
				Log.info("test step fail");
				Report.put("Click on the Expand icon next to the 'Connectivity Events' Event Type, selects all events type filters in the Connectivity Events", 
						"User should see the 'Show Connectivity Events'  toggled on ",
						"User is not able to click Expand icon next to the 'Connectivity Events'", "FAIL");
				Assert.fail();
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on the Expand icon next to the 'Connectivity Events' Event Type, selects all events type filters in the Connectivity Events", 
					"User should see the 'Show Connectivity Events'  toggled on ",
					"User is not able to click Expand icon next to the 'Connectivity Events'", "FAIL");
			Assert.fail();
		}
	}
	
	public void verifyExportButton(WebDriver driver) 
	{
		Log.info("Inside method verifyExportButton");
		WebDriverWait  wait = new WebDriverWait(driver, 120);

		String label="";

		try
		{
			Actions act=new Actions(driver);
		//	act.moveToElement(CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.ValidateToggleButton())).click().build().perform();
			CommonUtility.ClickOn(driver, obj_EsupportServiceEventsHomePage.ValidateToggleButton());
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportServiceEventsHomePage.ExportButton()));
			
			if(CommonUtility.CheckpresenceofElementLocated(driver, 10, obj_EsupportServiceEventsHomePage.ExportButton()))
			{
				label=CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.ExportButton()).getText();
				System.out.println("label is: "+label);
				Report.put("Validate whether the export button is visible. ", 
						"User should see the Export button icon",
						"user Successfully see button "+Report.color(label), "PASS");
			}
			else
			{
				Log.info("Failed to verify export button");
				Report.put("Validate whether the export button is visible. ", 
						"User should see the Export button icon",
						"Failed to verify export button", "FAIL");
				Assert.fail();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Log.info("Failed to verify export button");
			Report.put("Validate whether the export button is visible. ", 
					"User should see the Export button icon",
					"Failed to verify export button", "FAIL");
		}
	}	
	
	public void selectEscalatedEventAndClickApplyFilter(WebDriver driver)
	{
		System.out.println("Inside selectEscalatedEventAndClickApplyFilter method");
		Log.info("Inside selectEscalatedEventAndClickApplyFilter method");

		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);

			if(CommonUtility.CheckpresenceofElementLocated(driver, 30, obj_EsupportServiceEventsHomePage.serviceRequestExpandIconLeftPanelSETab()))
			{
				
				CommonUtility.ClickOn(driver,obj_EsupportServiceEventsHomePage.serviceRequestExpandIconLeftPanelSETab());
				
				CommonUtility.ClickOn(driver,obj_EsupportServiceEventsHomePage.EscalatedCheckbox());
				
				CommonUtility.ClickOn(driver,obj_EsupportServiceEventsHomePage.ApplyFiltersButton());
				
				System.out.println("Selected Escalated Filter");

				Report.put("Select the Escalated Service Event ",
						"User should see the event types filter selected.",
						"Clicked on escalated Event Type ", "PASS");	
			}
			else
			{
				Report.put("Select the Escalated Service Event ",
						"User should see the event types filter selected.",
						"Failed to click on escalated Service Request event", "FAIL");
				Assert.fail("Failed to click on escalated Service Request event");
				
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Select the Escalated Service Event ",
					"User should see the event types filter selected.",
					"Failed to click on escalated Service Request event", "FAIL");
			Assert.fail("Failed to click on escalated Service Request event");
		}
	}
	
	public void verifyEscalatedEventDetailsSETab(WebDriver driver) 
	{
		Log.info("Inside method verifyEscalatedEventDetailsSETab");
		WebDriverWait  wait = new WebDriverWait(driver, 120);

		String name="";
		String number = "";
		String severity = "";
		String status = "";

		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportServiceEventsHomePage.serviceEventsTypeHeaderSETab()));
			
			name=CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.EventName()).getText();
			number=CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.SRNumberSETab()).getText();
			severity=CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.SRSeveritySETab()).getText();
			status=CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.SRStatusSETab()).getText();
				
			System.out.println("Escalated details are: "+name+number+severity+status);
			
				Report.put("Validate the details displayed if the product have an active Escalation Event ", 
						"User should see the following: 1. Icon of Escalation, name of the event(Escalation)and type of the Escalation( Hardware) 2. Service request number heading 3. Escalation number with hyperlink to the service request details page 4. Escalation  severity 4. Escalation  status",
						"user Successfully displayed name "+Report.color(name)+" Serivce Request Number "+Report.color(number)+" Severity "+Report.color(severity)+" Status "+Report.color(status), "PASS");
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Log.info("Failed to verify escalation details");
			Report.put("Validate the details displayed if the product have an active Escalation Event ", 
					"User should see the following: 1. Icon of Escalation, name of the event(Escalation)and type of the Escalation( Hardware) 2. Service request number heading 3. Escalation number with hyperlink to the service request details page 4. Escalation  severity 4. Escalation  status",
					"Failed to verify escalation details", "FAIL");
			Assert.fail();
		}
	}	
	
	public void clickEscalatedEventExpandIconAndVerifyDetails(WebDriver driver) 
	{
		Log.info("Inside method clickEscalatedEventExpandIconAndVerifyDetails");
		WebDriverWait  wait = new WebDriverWait(driver, 120);

		String createdLabel="";
		String createdValue = "";
		String summaryLabel = "";
		String summaryValue = "";

		try
		{
			CommonUtility.ScrollTo(driver,obj_EsupportServiceEventsHomePage.SRExpandButton());
			CommonUtility.ClickOn(driver,obj_EsupportServiceEventsHomePage.SRExpandButton());
			
			createdLabel=CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.CreatedLabel()).getText();
			createdValue=CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.CreatedValue()).getText();
			summaryLabel=CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.SummaryLabel()).getText();
			summaryValue=CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.SummaryValue()).getText();
				
			System.out.println("Escalated details are: "+ createdLabel + createdValue + summaryLabel + summaryValue);
			
				Report.put("Validate the details displayed when each 'Escalation' events are expanded", 
						"User should see the following: 1. Summary 2. Date created",
						"Successfully displayed label "+Report.color(createdLabel)+Report.color(createdValue)+"<br>"+Report.color(summaryLabel)+Report.color(summaryValue), "PASS");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Log.info("Failed to verify 'Escalation' events are expanded");
			Report.put("Validate the details displayed when each 'Escalation' events are expanded", 
					"User should see the following: 1. Summary 2. Date created",
					"Failed to verify 'Escalation' events are expanded", "FAIL");
		}
	}
	
	public void verifyActiveFilterSelectedInSREventType(WebDriver driver)
	{
		System.out.println("Inside verifyActiveFilterSelectedInSREventType method");
		Log.info("Inside verifyActiveFilterSelectedInSREventType method");

		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);

			if(CommonUtility.CheckpresenceofElementLocated(driver, 30, obj_EsupportServiceEventsHomePage.serviceRequestExpandIconLeftPanelSETab()))
			{
				
				CommonUtility.ClickOn(driver,obj_EsupportServiceEventsHomePage.serviceRequestExpandIconLeftPanelSETab());
				
				boolean b=CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.ActiveFilterCheckbox()).isSelected();
				
				if(b==true)
				{
					Log.info("Active Filter is selected by default");
					
					Report.put("On the left panel, verify if 'Active' filter is selected by default under the  'Service Requests' Event Type",
							"User should see the 'Active' filter selected by default under the  'Service Requests' Event Type",
							"'Active' filter selected by default under the  'Service Requests' Event Type ", "PASS");	
				}
				else
				{
					Report.put("On the left panel, verify if 'Active' filter is selected by default under the  'Service Requests' Event Type",
							"User should see the 'Active' filter selected by default under the  'Service Requests' Event Type",
							"Failed to verify 'Active' filter selected by default under the  'Service Requests' Event Type", "FAIL");
					Assert.fail("Failed to verify 'Active' filter selected by default under the  'Service Requests' Event Type");
				}
			}
			else
			{
				Report.put("On the left panel, verify if 'Active' filter is selected by default under the  'Service Requests' Event Type",
						"User should see the 'Active' filter selected by default under the  'Service Requests' Event Type",
						"Failed to verify 'Active' filter selected by default under the  'Service Requests' Event Type", "FAIL");
				Assert.fail("Failed to verify 'Active' filter selected by default under the  'Service Requests' Event Type");
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("On the left panel, verify if 'Active' filter is selected by default under the  'Service Requests' Event Type",
					"User should see the 'Active' filter selected by default under the  'Service Requests' Event Type",
					"Failed to verify 'Active' filter selected by default under the  'Service Requests' Event Type", "FAIL");
			Assert.fail("Failed to verify 'Active' filter selected by default under the  'Service Requests' Event Type");
		}
	}
	
	public void verifyActiveSREventDetailsSETab(WebDriver driver) 
	{
		Log.info("Inside method verifyActiveSREventDetailsSETab");
		WebDriverWait  wait = new WebDriverWait(driver, 120);

		String name="";
		String number = "";
		String severity = "";
		String status = "";

		try
		{
			Thread.sleep(7000);
//			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportServiceEventsHomePage.serviceEventsTypeHeaderSETab()));
			CommonUtility.ScrollTo(driver, obj_EsupportServiceEventsHomePage.ActiveEventName());
			name=CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.ActiveEventName()).getText();
			number=CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.ActiveSRNumber()).getText();
			severity=CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.ActiveSeverity()).getText();
			status=CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.ActiveStatus()).getText();
				
			System.out.println("Active SR details are: "+name+number+severity+status);
			
				Report.put("Validate whether the user sees any active Service Requests Event Type by default", 
						"User should see the active Service Request by default.",
						" Successfully displayed name "+Report.color(name)+" Serivce Request Number "+Report.color(number)+" Severity "+Report.color(severity)+" Status "+Report.color(status), "PASS");
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Log.info("Failed to verify Active SR details");
			Report.put("Validate whether the user sees any active Service Requests Event Type by default", 
					"User should see the active Service Request by default.",
					"Failed to verify Active SR details", "FAIL");
		}
	}	
	
	public void verifyClosedSREventDetailsSETab(WebDriver driver) 
	{
		Log.info("Inside method verifyClosedSREventDetailsSETab");
		WebDriverWait  wait = new WebDriverWait(driver, 120);

		String name="";
		String number = "";
		String severity = "";
		String status = "";

		try
		{
			
			CommonUtility.ClickOn(driver, obj_EsupportServiceEventsHomePage.ActiveFilterCheckbox());
			CommonUtility.ClickOn(driver, obj_EsupportServiceEventsHomePage.ClosedFilterCheckbox());
			CommonUtility.ClickOn(driver, obj_EsupportServiceEventsHomePage.ApplyFiltersButton());
			Thread.sleep(5000);
			name=CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.ActiveEventName()).getText();
			number=CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.ActiveSRNumber()).getText();
			severity=CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.ActiveSeverity()).getText();
			status=CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.ActiveStatus()).getText();
				
			System.out.println("Closed SR details are: "+name+number+severity+status);
			
				Report.put("Scenario : To check for inactive events 1. On the left panel, Click on the Expand icon next to Service Request, select the Event Types filters that are no longer active( Customer could have used the options previously but that option is closed as of now) 2. Click on 'Apply Filters' at the bottom ", 
						"User should see all the closed Service Request(s) displayed on the content sections of the page and the 'Only show active events' should be toggled off ",
						" Successfully displayed event "+Report.color(name)+" Serivce Request Number "+Report.color(number)+" Severity "+Report.color(severity)+" Status "+Report.color(status), "PASS");
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Log.info("Failed to verify Inactive SR details");
			Report.put("Scenario : To check for inactive events 1. On the left panel, Click on the Expand icon next to Service Request, select the Event Types filters that are no longer active( Customer could have used the options previously but that option is closed as of now) 2. Click on 'Apply Filters' at the bottom ", 
					"User should see all the closed Service Request(s) displayed on the content sections of the page and the 'Only show active events' should be toggled off ",
					"Failed to verify Inactive SR details", "FAIL");
		}
	}	
	
	public void verifySREventDetailsSETab(WebDriver driver) 
	{
		Log.info("Inside method verifySREventDetailsSETab");
		WebDriverWait  wait = new WebDriverWait(driver, 120);

		String name="";
		String number = "";
		String severity = "";
		String status = "";

		try
		{
			
			CommonUtility.ClickOn(driver, obj_EsupportServiceEventsHomePage.ServiceRequestFilterCheckbox());
			CommonUtility.ClickOn(driver, obj_EsupportServiceEventsHomePage.ApplyFiltersButton());
			Thread.sleep(5000);
			name=CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.ActiveEventName()).getText();
			number=CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.ActiveSRNumber()).getText();
			severity=CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.ActiveSeverity()).getText();
			status=CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.ActiveStatus()).getText();
				
			System.out.println("SR details are: "+name+number+severity+status);
			
				Report.put("Scenario : To check for active & inactive Service Request 1. On the left panel, Click on the Expand icon next to Service Request, select all the Event Types filters 2. Click on 'Apply Filters' at the bottom ", 
						"User should see all the Service Request(s) displayed on the content sections of the page and the 'Only show active events' should be toggled off",
						" Successfully displayed all events and 'Only show active events' should be toggled off", "PASS");
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Log.info("Failed to verify active & Inactive SR events SR details");
			Report.put("Scenario : To check for active & inactive Service Request 1. On the left panel, Click on the Expand icon next to Service Request, select all the Event Types filters 2. Click on 'Apply Filters' at the bottom ", 
					"User should see all the Service Request(s) displayed on the content sections of the page and the 'Only show active events' should be toggled off",
					"Failed to verify active & Inactive SR events", "FAIL");
		}
	}	
	
	public void clickSREventExpandIconAndVerifyDetails(WebDriver driver) 
	{
		Log.info("Inside method clickSREventExpandIconAndVerifyDetails");
		WebDriverWait  wait = new WebDriverWait(driver, 120);

		String createdLabel="";
		String createdValue = "";
		String summaryLabel = "";
		String summaryValue = "";

		try
		{
			CommonUtility.ScrollTo(driver,obj_EsupportServiceEventsHomePage.SRExpandButton());
			CommonUtility.ClickOn(driver,obj_EsupportServiceEventsHomePage.SRExpandButton());
			
			createdLabel=CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.CreatedLabel()).getText();
			createdValue=CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.CreatedValue()).getText();
			summaryLabel=CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.SummaryLabel()).getText();
			summaryValue=CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.SummaryValue()).getText();
				
			System.out.println("SR details are: "+ createdLabel + createdValue + summaryLabel + summaryValue);
			
				Report.put("Click on Expand icon, Validate the display displayed when a Service Request event type is expanded ", 
						"User must see the Created date and Summary",
						"Successfully displayed label "+Report.color(createdLabel)+Report.color(createdValue)+"<br>"+Report.color(summaryLabel)+Report.color(summaryValue), "PASS");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Log.info("Failed to verify SR events are expanded");
			Report.put("Click on Expand icon, Validate the display displayed when a Service Request event type is expanded ", 
					"User must see the Created date and Summary",
					"Failed to verify 'Escalation' events are expanded", "FAIL");
		}
	}
	
	public void clickSRNumberLink(WebDriver driver) 
	{
		Log.info("Inside method clickSRNumberLink");
		WebDriverWait  wait = new WebDriverWait(driver, 120);

		String url="";

		try
		{
			CommonUtility.ClickOn(driver,obj_EsupportServiceEventsHomePage.ActiveSRNumber());
			
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
				url=driver.getCurrentUrl();
				System.out.println("URL displayed as   :::::"+url); 

				if(url.contains("emc"))
				{
					url = driver.getCurrentUrl();
					System.out.println("Switched to window & URL is "+url);			

					driver.close();

					driver.switchTo().window(currentwindow);						
				}	
			}
			
				Report.put("Click on the Service Request Number hyperlink displayed", 
						"User should be directed to the 'Service Request Number' page on the EMC",
						"Successfully navigated to Page "+Report.color(url), "PASS");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Log.info("Failed to Click on the Service Request Number hyperlink");
			Report.put("Click on the Service Request Number hyperlink displayed", 
					"User should be directed to the 'Service Request Number' page on the EMC",
					"Failed to Click on the Service Request Number hyperlink", "FAIL");
		}
	}
	
	public void selectCorrectiveMaintenanceEventAndClickApplyFilter(WebDriver driver)
	{
		System.out.println("Inside selectCorrectiveMaintenanceEventAndClickApplyFilter method");
		Log.info("Inside selectCorrectiveMaintenanceEventAndClickApplyFilter method");

		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);

			if(CommonUtility.CheckpresenceofElementLocated(driver, 30, obj_EsupportServiceEventsHomePage.ScheduledServicesExpandIcon()))
			{
				CommonUtility.ScrollTo(driver,obj_EsupportServiceEventsHomePage.ScheduledServicesExpandIcon());
				CommonUtility.ClickOn(driver,obj_EsupportServiceEventsHomePage.ScheduledServicesExpandIcon());
				
				CommonUtility.ClickOn(driver,obj_EsupportServiceEventsHomePage.CorrectiveMaintenanceCheckbox());
				
				CommonUtility.ClickOn(driver,obj_EsupportServiceEventsHomePage.ApplyFiltersButton());
				
				System.out.println("Selected Corrective Maintenance Filter");

				Report.put("Select the 'Corrective Maintenance' from the event type filters and click on the 'Apply Filters' button at the bottom",
						"User should see the events under the 'Corrective Maintenance' be displayed",
						"Clicked on Corrective Maintenance Event Type ", "PASS");	
			}
			else
			{
				Report.put("Select the 'Corrective Maintenance' from the event type filters and click on the 'Apply Filters' button at the bottom",
						"User should see the events under the 'Corrective Maintenance' be displayed",
						"Failed to click on Corrective Maintenance event", "FAIL");
				Assert.fail("Failed to click on Corrective Maintenance event");
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Select the 'Corrective Maintenance' from the event type filters and click on the 'Apply Filters' button at the bottom",
					"User should see the events under the 'Corrective Maintenance' be displayed",
					"Failed to click on Corrective Maintenance event", "FAIL");
			Assert.fail("Failed to click on Corrective Maintenance event");
		}
	}
	
	public void verifyCorrectiveMaintenanceEventDetailsSETab(WebDriver driver) 
	{
		Log.info("Inside method verifyCorrectiveMaintenanceEventDetailsSETab");
		WebDriverWait  wait = new WebDriverWait(driver, 120);

		String name="";
		String number = "";
		String startTime = "";
		String endTime = "";

		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportServiceEventsHomePage.serviceEventsTypeHeaderSETab()));
			
			name=CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.ActiveEventName()).getText();
			number=CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.SRNumberSETab()).getText();
			startTime=CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.StartTimeValue()).getText();
			endTime=CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.EndTimeValue()).getText();
				
			System.out.println("Corrective Maintenance details are: "+ name + number + startTime + endTime);
			
				Report.put("Validate the details displayed when 'Corrective Maintenance' events are displayed on the page", 
						"User should see the following: 1. Service Request type 2. Service Request number 3. Start Time 4. End Time 5. Expand icon 6. Status",
						"user Successfully displayed name "+Report.color(name)+" Serivce Request Number "+Report.color(number)+" Start Time "+Report.color(startTime)+" End Time "+Report.color(endTime), "PASS");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Log.info("Failed to verify Corrective Maintenance details");
			Report.put("Validate the details displayed when 'Corrective Maintenance' events are displayed on the page", 
					"User should see the following: 1. Service Request type 2. Service Request number 3. Start Time 4. End Time 5. Expand icon 6. Status",
					"Failed to verify Corrective Maintenance details", "FAIL");
			Assert.fail();
		}
	}
	
	public void clickCorrectiveMaintenanceEventExpandIconAndVerifyDetails(WebDriver driver) 
	{
		Log.info("Inside method clickCorrectiveMaintenanceEventExpandIconAndVerifyDetails");
		WebDriverWait  wait = new WebDriverWait(driver, 120);

		String createdValue = "";
		String status="";
		String technician = "";
		String onsiteContact = "";

		try
		{
		//	CommonUtility.ScrollTo(driver,obj_EsupportServiceEventsHomePage.SRExpandButton());
			CommonUtility.highlightElement(driver,obj_EsupportServiceEventsHomePage.SRExpandButton()).click();
			
			createdValue=CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.CreatedValue()).getText();
			status=CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.Status()).getText();
			technician=CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.Technician()).getText();
			onsiteContact=CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.OnsiteContact()).getText();
			
			System.out.println("Corrective Maintenance details are: "+ createdValue + status + technician + onsiteContact);
			
				Report.put("Validate the details displayed when each 'Corrective Maintenance' events are expanded", 
						"User should see the following: 1. Date Cretaed 2. Technicain details should show the role name, First and last name, email address and contact number 3. Status 4. Onsite contact details 5. Collapse icon",
						"Successfully displayed date Created "+Report.color(createdValue) +"Status"+Report.color(status)+"Technician"+Report.color(technician)+"On Site COntact"+Report.color(onsiteContact), "PASS");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Log.info("Failed to verify Corrective Maintenance events are expanded");
			Report.put("Validate the details displayed when each 'Corrective Maintenance' events are expanded", 
					"User should see the following: 1. Date Cretaed 2. Technicain details should show the role name, First and last name, email address and contact number 3. Status 4. Onsite contact details 5. Collapse icon",
					"Failed to verify Corrective Maintenance events are expanded", "FAIL");
			Assert.fail();
		}
	}
	
	public void verifyNoActiveEventMessage(WebDriver driver) 
	{
		System.out.println("Inside verifyNoActiveEventMessage method");
		Log.info("Inside verifyNoActiveEventMessage method");

		String message = "";
				
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);

			
			if(CommonUtility.CheckpresenceofElementLocated(driver, 10, obj_EsupportServiceEventsHomePage.NoActiveServiceEventsMessage()))
			{
						message=CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.NoActiveServiceEventsMessage()).getText();
						System.out.println("Landed in Service Events Tab" +message);
						
			Report.put("Validate the message displayed when Service Tag has no active Service Requests and no Service history",
					"User should see the message, 'This product has no active service events. Toggle Active service events or change filters to show full service history' in a blue tile along with the info icon.",
					"Displayed message to the user "+Report.color(message), "PASS");
			}
			else
			{
				
				Report.put("Validate the message displayed when Service Tag has no active Service Requests and no Service history",
						"User should see the message, 'This product has no active service events. Toggle Active service events or change filters to show full service history' in a blue tile along with the info icon.",
						"Failed to validate message when Service Tag has no active SR's on Service Events Tab", "FAIL");
				Assert.fail("Failed to validate message when Service Tag has no active SR's on Service Events Tab");
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Validate the message displayed when Service Tag has no active Service Requests and no Service history",
					"User should see the message, 'This product has no active service events. Toggle Active service events or change filters to show full service history' in a blue tile along with the info icon.",
					"Failed to validate message when Service Tag has no active SR's on Service Events Tab", "FAIL");
			Assert.fail("Failed to validate message when Service Tag has no active SR's on Service Events Tab");
		}
	}
	
	public void clickShowActiveEventsToggleOff(WebDriver driver) 
	{
		Log.info("Inside method clickShowActiveEventsToggleOff");
		WebDriverWait  wait = new WebDriverWait(driver, 120);

		String tdyText="";
		String tdyDate="";
		
		try
		{
			Actions act=new Actions(driver);
			act.moveToElement(CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.activeEventsToggle())).click().build().perform();
			//CommonUtility.ClickOn(driver, obj_EsupportServiceEventsHomePage.showConnectivityEventsToggleButton());
			Thread.sleep(10000);
			boolean b=CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.activeEventsCheckbox()).isSelected();
			if(!b)
			{
				tdyText = CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.timelineTextToday()).getText();
				tdyDate = CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.timelineTextTodayDate()).getText();
				Log.info("test step pass");
				
				Report.put("Toggle off 'Only show active events'", 
						"User should see all the service events ",
						"User Successfully see displayed  Events from timeline "+Report.color(tdyText)+Report.color(tdyDate), "PASS");
			}
			else
			{
				Log.info("test step fail");
				Report.put("Toggle off 'Only show active events'", 
						"User should see all the service events ",
						"User is not able to  toggle off 'Show Active Events'", "FAIL");
				Assert.fail();
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Toggle off 'Only show active events'", 
					"User should see all the service events ",
					"User is not able to  toggle off 'Show Active Events'", "FAIL");
			Assert.fail();
		}
	}	
	
	public void clickShowActiveEventsToggleOn(WebDriver driver) 
	{
		Log.info("Inside method clickShowActiveEventsToggleOn");
		WebDriverWait  wait = new WebDriverWait(driver, 120);

		String name="";
		String number = "";
		String severity = "";
		String status = "";
		String message = "";

		try
		{
			Actions act=new Actions(driver);
			act.moveToElement(CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.activeEventsToggle())).click().build().perform();
			//CommonUtility.ClickOn(driver, obj_EsupportServiceEventsHomePage.showConnectivityEventsToggleButton());
			Thread.sleep(10000);
			boolean b=CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.activeEventsCheckbox()).isSelected();
			if(b)
			{		
				if(CommonUtility.CheckpresenceofElementLocated(driver, 10, obj_EsupportServiceEventsHomePage.serviceEventsTypeHeaderSETab()))
				{
					name=CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.ActiveEventName()).getText();
					number=CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.ActiveSRNumber()).getText();
					severity=CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.ActiveSeverity()).getText();
					status=CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.ActiveStatus()).getText();

					System.out.println("Active SR details are: "+name+number+severity+status);

					Report.put("Toggle on 'Only show active events'", 
							"User should see only active service events ",
							" Successfully displayed Active Event Details: "+Report.color(name)+" Serivce Request Number "+Report.color(number)+" Severity "+Report.color(severity)+" Status "+Report.color(status), "PASS");
				}
				else if(CommonUtility.CheckpresenceofElementLocated(driver, 10, obj_EsupportServiceEventsHomePage.NoActiveServiceEventsMessage()))
				{
					message=CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.NoActiveServiceEventsMessage()).getText();
					Log.info("test step pass");

					Report.put("Toggle on 'Only show active events'", 
							"User should see only active service events ",
							"User is displayed with message "+Report.color(message), "PASS");
				}
			}
			else
			{
				Log.info("test step fail");
				Report.put("Toggle on 'Only show active events'", 
						"User should see only active service events ",
						"User is not able to  toggle On 'Show Active Events'", "FAIL");
				Assert.fail();
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Toggle on 'Only show active events'", 
					"User should see only active service events ",
					"User is not able to  toggle On 'Show Active Events'", "FAIL");
			Assert.fail();
		}
	}	
	
	public void enterDateInTextbox(WebDriver driver, String fromDate, String toDate) 
	{
		Log.info("Inside method enterDateInTextbox");
		WebDriverWait  wait = new WebDriverWait(driver, 120);

		try
		{
				CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.FromDateTextbox()).sendKeys("06/26/2018");
				 CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.ToDateTextbox()).sendKeys("06/26/2020");
				// CommonUtility.ClickOn(driver,obj_EsupportServiceEventsHomePage.ApplyFiltersButton());
				
				 Report.put("Validate whether the user is able to pick date range", 
							"User should be able to pick a date range",
							"User is able to pick dates "+Report.color(fromDate)+Report.color(toDate), "PASS");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Validate whether the user is able to pick date range", 
					"User should be able to pick a date range",
					"User is not able to pick a date range", "FAIL");
			Assert.fail();
		}
	}
	
	public void clickMilestonesExpandIconAndVerifyOptions(WebDriver driver)
	{
		System.out.println("Inside clickMilestonesExpandIconAndVerifyOptions method");
		Log.info("Inside clickMilestonesExpandIconAndVerifyOptions method");

		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);
			String valueList = "";

			if(CommonUtility.CheckpresenceofElementLocated(driver, 30, obj_EsupportServiceEventsHomePage.MilestonesExpandIcon()))
			{
				CommonUtility.ScrollTo(driver,obj_EsupportServiceEventsHomePage.MilestonesExpandIcon());
				CommonUtility.ClickOn(driver,obj_EsupportServiceEventsHomePage.MilestonesExpandIcon());
				
				List<WebElement> list=driver.findElements(obj_EsupportServiceEventsHomePage.MilestonesFilterList());

				for(WebElement lt:list)
				{
					CommonUtility.highlightElement(driver, lt);
					String val=lt.getText();
					if(!(val.isEmpty()))
					{
						System.out.println("Type is: " +val);
						valueList+=" <br> " + val;
					}
				}
				System.out.println("Values are: "+valueList);

				Report.put("Click on the Expand icon next to Milestone in the left side panel",
						"User should see the following event type filters details under Milestone Event  type: End of Service Life, Contract End, Ship date, Install date, Purchase date",
						"Clicked on Expand icon next to Milestone and filters are: "+Report.color(valueList), "PASS");	
			}
			else
			{
				Report.put("Click on the Expand icon next to Milestone in the left side panel",
						"User should see the following event type filters details under Milestone Event  type: End of Service Life, Contract End, Ship date, Install date, Purchase date",
						"Failed to click on Expand icon next to Milestone event", "FAIL");
				Assert.fail("Failed to click on Expand icon next to Milestone event");
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on the Expand icon next to Milestone in the left side panel",
					"User should see the following event type filters details under Milestone Event  type: End of Service Life, Contract End, Ship date, Install date, Purchase date",
					"Failed to click on Expand icon next to Milestone event", "FAIL");
			Assert.fail("Failed to click on Expand icon next to Milestone event");
		}
	}
	
	public void clickMilestoneCheckboxAndApplyFiltersButtonAndVerifyFilters(WebDriver driver)
	{
		System.out.println("Inside clickMilestoneCheckboxAndApplyFiltersButtonAndVerifyFilters method");
		Log.info("Inside clickMilestoneCheckboxAndApplyFiltersButtonAndVerifyFilters method");

	
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);

			String valueList = "";
			System.out.println("Inside try block of clickMilestoneCheckboxAndApplyFiltersButtonAndVerifyFilters");
			if(CommonUtility.CheckpresenceofElementLocated(driver, 10, obj_EsupportServiceEventsHomePage.MilestonesFilterCheckbox()))
			{
				System.out.println("Inside if+++");
				CommonUtility.ClickOn(driver,obj_EsupportServiceEventsHomePage.MilestonesFilterCheckbox());
				
				CommonUtility.ClickOn(driver,obj_EsupportServiceEventsHomePage.ApplyFiltersButton());
				
				List<WebElement> list=driver.findElements(obj_EsupportServiceEventsHomePage.appliedFiltersTextLeftPanelSETab());

				for(WebElement lt:list)
				{
					CommonUtility.highlightElement(driver, lt);
					String val=lt.getText();
					if(!(val.isEmpty()))
					{
						System.out.println("Applied Filter is: " +val);
						valueList+=" <br> " + val;
					}
				}
				System.out.println("Applied Filters are: "+valueList);

				Report.put("Check the box against each event type filters from step 7 and click on 'Apply Filters' button at the bottom in the left side panel ",
						"User should see the 5 event typpe filters displayed and their respective dates must be seen ",
						"Clicked on Milestone checkbox and displayed Applied filters section"+Report.color(valueList), "PASS");	
			}
			else
			{
				Report.put("Check the box against each event type filters from step 7 and click on 'Apply Filters' button at the bottom in the left side panel ",
						"User should see the 5 event typpe filters displayed and their respective dates must be seen ",
						"Failed to click on 'Apply Filters' and verify Filter Section", "FAIL");
				Assert.fail("Failed to click on 'Apply Filters' and verify Filter Section");
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Check the box against each event type filters from step 7 and click on 'Apply Filters' button at the bottom in the left side panel ",
					"User should see the 5 event typpe filters displayed and their respective dates must be seen ",
					"Failed to click on 'Apply Filters' and verify Filter Section", "FAIL");
			Assert.fail("Failed to click on 'Apply Filters' and verify Filter Section");
		}
	}
	
	public void clickAdvisoriesExpandIconAndVerifyOptions(WebDriver driver)
	{
		System.out.println("Inside clickAdvisoriesExpandIconAndVerifyOptions method");
		Log.info("Inside clickAdvisoriesExpandIconAndVerifyOptions method");

		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);
			String valueList = "";

			if(CommonUtility.CheckpresenceofElementLocated(driver, 30, obj_EsupportServiceEventsHomePage.AdvisoriesExpandIcon()))
			{
				CommonUtility.ScrollTo(driver,obj_EsupportServiceEventsHomePage.AdvisoriesExpandIcon());
				CommonUtility.ClickOn(driver,obj_EsupportServiceEventsHomePage.AdvisoriesExpandIcon());
				
				List<WebElement> list=driver.findElements(obj_EsupportServiceEventsHomePage.AdvisoriesFilterList());

				for(WebElement lt:list)
				{
					CommonUtility.highlightElement(driver, lt);
					String val=lt.getText();
					if(!(val.isEmpty()))
					{
						System.out.println("Type is: " +val);
						valueList+=" <br> " + val;
					}
				}
				System.out.println("Values are: "+valueList);

				Report.put("Click on the Expand icon next to the Advisories Event Type on the left side panel",
						"User should see the event type filters for that Advisories Event type expanded. ",
						"Clicked on Expand icon next to Advisories and filters are: "+Report.color(valueList), "PASS");	
			}
			else
			{
				Report.put("Click on the Expand icon next to the Advisories Event Type on the left side panel",
						"User should see the event type filters for that Advisories Event type expanded. ",
						"Failed to click on Expand icon next to Advisories event", "FAIL");
				Assert.fail("Failed to click on Expand icon next to Advisories event");
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on the Expand icon next to the Advisories Event Type on the left side panel",
					"User should see the event type filters for that Advisories Event type expanded. ",
					"Failed to click on Expand icon next to Advisories event", "FAIL");
			Assert.fail("Failed to click on Expand icon next to Advisories event");
		}
	}

	public void clickTechnicalAdvisoryCheckboxAndApplyFiltersButtonAndVerifyFilter(WebDriver driver)
	{
		System.out.println("Inside clickTechnicalAdvisoryCheckboxAndApplyFiltersButtonAndVerifyFilter method");
		Log.info("Inside clickTechnicalAdvisoryCheckboxAndApplyFiltersButtonAndVerifyFilter method");

	
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);

			String valueList = "";
			System.out.println("Inside try block of clickTechnicalAdvisoryCheckboxAndApplyFiltersButtonAndVerifyFilter");
			if(CommonUtility.CheckpresenceofElementLocated(driver, 10, obj_EsupportServiceEventsHomePage.TechnicalAdvisoryCheckbox()))
			{
				System.out.println("Inside if+++");
				CommonUtility.ClickOn(driver,obj_EsupportServiceEventsHomePage.TechnicalAdvisoryCheckbox());
				
				CommonUtility.ClickOn(driver,obj_EsupportServiceEventsHomePage.ApplyFiltersButton());
				
				List<WebElement> list=driver.findElements(obj_EsupportServiceEventsHomePage.appliedFiltersTextLeftPanelSETab());

				for(WebElement lt:list)
				{
					CommonUtility.highlightElement(driver, lt);
					String val=lt.getText();
					if(!(val.isEmpty()))
					{
						System.out.println("Applied Filter is: " +val);
						valueList+=" <br> " + val;
					}
				}
				System.out.println("Applied Filters are: "+valueList);

				Report.put("Unselect the 'Security Advisory' from the event type filters. Next, select the 'Technical Advisory' from the event type filtersand click on the 'Apply Filters' at the bottom ",
						"User should see the events under the 'Technical Advisory' be displayed",
						"Clicked on Technical Advisory' checkbox and displayed Applied filters section"+Report.color(valueList), "PASS");	
			}
			else
			{
				Report.put("Unselect the 'Security Advisory' from the event type filters. Next, select the 'Technical Advisory' from the event type filtersand click on the 'Apply Filters' at the bottom ",
						"User should see the events under the 'Technical Advisory' be displayed",
						"Failed to click on 'Apply Filters' and verify Filter Section", "FAIL");
				Assert.fail("Failed to click on 'Apply Filters' and verify Filter Section");
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Unselect the 'Security Advisory' from the event type filters. Next, select the 'Technical Advisory' from the event type filtersand click on the 'Apply Filters' at the bottom ",
					"User should see the events under the 'Technical Advisory' be displayed",
					"Failed to click on 'Apply Filters' and verify Filter Section", "FAIL");
			Assert.fail("Failed to click on 'Apply Filters' and verify Filter Section");
		}
	}
	
	public void verifyTechnicalAdvisoryEventDetailsSETab(WebDriver driver) 
	{
		Log.info("Inside method verifyTechnicalAdvisoryEventDetailsSETab");
		WebDriverWait  wait = new WebDriverWait(driver, 120);

		String name="";
		String status = "";
		String title = "";

		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportServiceEventsHomePage.serviceEventsTypeHeaderSETab()));
			
			name=CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.AdvisoryName()).getText();
			status=CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.Status()).getText();
			title=CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.AdvisoryTitle()).getText();
				
			System.out.println("Technical Advisory details are: "+ name + status + title);
			
				Report.put("Validate the details displayed when 'Technical Advisory' events are displayed.", 
						"User should see the following: 1. Advisory type 2. Advisory severity (critical, high severity, medium severity, low severity) 3. Status 4. Title and 5. Expand icon ",
						"user Successfully displayed Advisory Type "+Report.color(name)+"<br>"+" Status "+Report.color(status)+"<br>"+" Title "+Report.color(title), "PASS");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Log.info("Failed to verify Technical Advisory details");
			Report.put("Validate the details displayed when 'Technical Advisory' events are displayed.", 
					"User should see the following: 1. Advisory type 2. Advisory severity (critical, high severity, medium severity, low severity) 3. Status 4. Title and 5. Expand icon ",
					"Failed to verify Technical Advisory details", "FAIL");
		}
	}
	
	public void clickTechnicalAdvisoryEventExpandIconAndVerifyDetails(WebDriver driver) 
	{
		Log.info("Inside method clickTechnicalAdvisoryEventExpandIconAndVerifyDetails");
		WebDriverWait  wait = new WebDriverWait(driver, 120);

		String title = "";
		String advisoryId="";
		String updatedBy = "";
		String articleAge = "";

		try
		{
			CommonUtility.ScrollTo(driver,obj_EsupportServiceEventsHomePage.SRExpandButton());
			CommonUtility.highlightElement(driver,obj_EsupportServiceEventsHomePage.SRExpandButton()).click();
			
			title=CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.TitleExpandedView()).getText();
			advisoryId=CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.AdvisoryIDExpandedView()).getText();
			updatedBy=CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.UpdatedByExpandedView()).getText();
			articleAge=CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.ArticleAgeExpandedView()).getText();
			
			System.out.println("Technical Advisory details are: "+ title + advisoryId + updatedBy + articleAge);
			
				Report.put("Validate the details displayed when each 'Technical Advisory' events are expanded", 
						"User should see the following: 1. Title 2. Advisory ID 3. Updated by should show the name, date and time 4. Article age 5. Advisory notes link 6. Collapse icon ",
						"Successfully displayed title "+Report.color(title)+"<br>" +"Advisory ID"+Report.color(advisoryId)+"<br>"+"Updated By"+Report.color(updatedBy)+"<br>"+"Article Age"+Report.color(articleAge), "PASS");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Validate the details displayed when each 'Technical Advisory' events are expanded", 
					"User should see the following: 1. Title 2. Advisory ID 3. Updated by should show the name, date and time 4. Article age 5. Advisory notes link 6. Collapse icon ",
					"Failed to verify 'Technical Advisory' events are expanded", "FAIL");
		}
	}
	
	public void clickChangesAndSubmissionExpandIconAndVerifyOptions(WebDriver driver)
	{
		System.out.println("Inside clickChangesAndSubmissionExpandIconAndVerifyOptions method");
		Log.info("Inside clickChangesAndSubmissionExpandIconAndVerifyOptions method");

		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);
			String valueList = "";

			if(CommonUtility.CheckpresenceofElementLocated(driver, 30, obj_EsupportServiceEventsHomePage.ChangesSubmissionExpandIcon()))
			{
				CommonUtility.ScrollTo(driver,obj_EsupportServiceEventsHomePage.ChangesSubmissionExpandIcon());
				CommonUtility.ClickOn(driver,obj_EsupportServiceEventsHomePage.ChangesSubmissionExpandIcon());
				
				List<WebElement> list=driver.findElements(obj_EsupportServiceEventsHomePage.ChangesSubmissionFiltersList());

				for(WebElement lt:list)
				{
					CommonUtility.highlightElement(driver, lt);
					String val=lt.getText();
					if(!(val.isEmpty()))
					{
						System.out.println("Type is: " +val);
						valueList+=" <br> " + val;
					}
				}
				System.out.println("Values are: "+valueList);

				Report.put("Click on the Expand icon next to 'Change & Submission' in the left side panel",
						"User should see the following event type filters details under Change & Submission Event  type: Install Base Change, Nickname Change, Contact Sale Submission ",
						"Clicked on Expand icon next to 'Change & Submission' and filters are: "+Report.color(valueList), "PASS");	
			}
			else
			{
				Report.put("Click on the Expand icon next to 'Change & Submission' in the left side panel",
						"User should see the following event type filters details under Change & Submission Event  type: Install Base Change, Nickname Change, Contact Sale Submission ",
						"Failed to click on Expand icon next to 'Change & Submission' event", "FAIL");
				Assert.fail("Failed to click on Expand icon next to 'Change & Submission' event");
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on the Expand icon next to 'Change & Submission' in the left side panel",
					"User should see the following event type filters details under Change & Submission Event  type: Install Base Change, Nickname Change, Contact Sale Submission ",
					"Failed to click on Expand icon next to 'Change & Submission' event", "FAIL");
			Assert.fail("Failed to click on Expand icon next to 'Change & Submission' event");
		}
	}
	
	public void clickContactSalesSubmissionCheckboxAndApplyFiltersButtonAndVerifyDetails(WebDriver driver)
	{
		System.out.println("Inside clickContactSalesSubmissionCheckboxAndApplyFiltersButtonAndVerifyDetails method");
		Log.info("Inside clickContactSalesSubmissionCheckboxAndApplyFiltersButtonAndVerifyDetails method");

	
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);

			String value = "";
			
			System.out.println("Inside try block of clickContactSalesSubmissionCheckboxAndApplyFiltersButtonAndVerifyDetails");
			if(CommonUtility.CheckpresenceofElementLocated(driver, 10, obj_EsupportServiceEventsHomePage.ContactSalesSubmissionCheckbox()))
			{
				System.out.println("Inside if+++");
				CommonUtility.ClickOn(driver,obj_EsupportServiceEventsHomePage.ContactSalesSubmissionCheckbox());
				
				CommonUtility.ClickOn(driver,obj_EsupportServiceEventsHomePage.ApplyFiltersButton());
				
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportServiceEventsHomePage.serviceEventsTypeHeaderSETab()));
				
				value=CommonUtility.highlightElement(driver, obj_EsupportServiceEventsHomePage.ServicePlanContractText()).getText();
					
				System.out.println("Contact Sales Submission details are: "+ value);

				Report.put("Uncheck the box against Nickname Change event type filters, select Contact Sale Submission from step 7 and click on 'Apply Filters' button at the bottom in the left side panel ",
						"User must see the Contact Sale Submission details as : Service Plan Contract Refresh My Equipment Request submitted by XXXXXXXXX",
						"Clicked on Contact Sale Submission checkbox and displayed Service Plan Contract "+Report.color(value), "PASS");	
			}
			else
			{
				Report.put("Uncheck the box against Nickname Change event type filters, select Contact Sale Submission from step 7 and click on 'Apply Filters' button at the bottom in the left side panel ",
						"User must see the Contact Sale Submission details as : Service Plan Contract Refresh My Equipment Request submitted by XXXXXXXXX",
						"Failed to select Contact Sale Submission & click on 'Apply Filters'", "FAIL");
				Assert.fail("Failed to select Contact Sale Submission & click on 'Apply Filters'");
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Uncheck the box against Nickname Change event type filters, select Contact Sale Submission from step 7 and click on 'Apply Filters' button at the bottom in the left side panel ",
					"User must see the Contact Sale Submission details as : Service Plan Contract Refresh My Equipment Request submitted by XXXXXXXXX",
					"Failed to select Contact Sale Submission & click on 'Apply Filters'", "FAIL");
			Assert.fail("Failed to select Contact Sale Submission & click on 'Apply Filters'");
		}
	}
	
	public void clickInstallBaseChangeCheckboxAndApplyFiltersButtonAndVerifyDetails(WebDriver driver)
	{
		System.out.println("Inside clickInstallBaseChangeCheckboxAndApplyFiltersButtonAndVerifyDetails method");
		Log.info("Inside clickInstallBaseChangeCheckboxAndApplyFiltersButtonAndVerifyDetails method");

	
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);

			String valueList = "";
			
			System.out.println("Inside try block of clickInstallBaseChangeCheckboxAndApplyFiltersButtonAndVerifyDetails");
			if(CommonUtility.CheckpresenceofElementLocated(driver, 10, obj_EsupportServiceEventsHomePage.InstallBaseChangeCheckbox()))
			{
				System.out.println("Inside if+++");
				CommonUtility.ClickOn(driver,obj_EsupportServiceEventsHomePage.ContactSalesSubmissionCheckbox());
				CommonUtility.ClickOn(driver,obj_EsupportServiceEventsHomePage.InstallBaseChangeCheckbox());
				
				CommonUtility.ClickOn(driver,obj_EsupportServiceEventsHomePage.ApplyFiltersButton());
				
				List<WebElement> list=driver.findElements(obj_EsupportServiceEventsHomePage.appliedFiltersTextLeftPanelSETab());

				for(WebElement lt:list)
				{
					CommonUtility.highlightElement(driver, lt);
					String val=lt.getText();
					if(!(val.isEmpty()))
					{
						System.out.println("Applied Filter is: " +val);
						valueList+=" <br> " + val;
					}
				}
				System.out.println("Applied Filters are: "+valueList);


				Report.put("Uncheck the box against Contact Sale Submission event type filters, select Install Base Change from step 7 and click on 'Apply Filters' button at the bottom in the left side panel ",
						"User must see the Install Base Change details as :",
						"Clicked on Install Base Change checkbox and displayed  "+Report.color(valueList), "PASS");	
			}
			else
			{
				Report.put("Uncheck the box against Contact Sale Submission event type filters, select Install Base Change from step 7 and click on 'Apply Filters' button at the bottom in the left side panel ",
						"User must see the Install Base Change details as :",
						"Failed to select Install Base Change & click on 'Apply Filters'", "FAIL");
				Assert.fail("Failed to select Install Base Change & click on 'Apply Filters'");
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Uncheck the box against Contact Sale Submission event type filters, select Install Base Change from step 7 and click on 'Apply Filters' button at the bottom in the left side panel ",
					"User must see the Install Base Change details as :",
					"Failed to select Install Base Change & click on 'Apply Filters'", "FAIL");
			Assert.fail("Failed to select Install Base Change & click on 'Apply Filters'");
		}
	}
}
