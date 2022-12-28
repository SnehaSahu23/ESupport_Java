package com.dell.delta_uat_automation.esupport.workflows;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
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

public class EsupportPortalWorkflow extends BaseFlow 
{
	public void handleCookies(WebDriver driver)
	{
		System.out.println("Handle Cookies");
		WebDriverWait wait = new WebDriverWait(driver, 50);
		Log.info("Handle Cookies");	
		try
		{
			if(CommonUtility.CheckpresenceofElementLocated(driver, 5, obj_PortalPage.acceptCookies()))
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
		catch(Exception ex)
		{
			System.out.println("Cookies not present");
		}

		driver.manage().timeouts().implicitlyWait(02, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(02, TimeUnit.SECONDS);
	} 

	public void clickIncidentManagementTab(WebDriver driver)
	{
		System.out.println("Inside clickIncidentManagementTab method");
		Log.info("Inside clickIncidentManagementTab method");


		String tab = "";
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);

			//CommonUtility.ToClickByUsingJavaScript_PassingByLoc(driver,obj_PortalPage.incidentManagementTab());
			CommonUtility.ScrollTo(driver,(obj_PortalPage.incidentManagementTab()));
			CommonUtility.ClickOn(driver,obj_PortalPage.incidentManagementTab());
			tab = CommonUtility.highlightElement(driver,obj_PortalPage.incidentManagementTab()).getText();

			System.out.println("Clicked on "+tab);

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.incidentManagementTable()));

			CommonUtility.ScrollTo(driver,(obj_PortalPage.incidentManagementTable()));
			CommonUtility.highlightElement(driver,obj_PortalPage.incidentManagementTable());

			Report.put("Click on the Incident management tab",
					"The Incident Management should be displayed ",
					Report.color(tab)+"displayed successfully.", "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on the Incident management tab",
					"The Incident Management should be displayed ",
					"Failed to load Incident Management  page", "FAIL");
			Assert.fail();
		}
	}

	public void clickIncidentManagementSummaryViewFilterButton(WebDriver driver)
	{
		System.out.println("Inside clickIncidentManagementSummaryViewFilterButton method");
		Log.info("Inside clickIncidentManagementSummaryViewFilterButton method");


		String filterButton = "";
		String filterByHeader = "";

		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);

			CommonUtility.scrollToViewElement(driver,(obj_PortalPage.incidentManagementSummaryViewFilterButton()));
			filterButton = CommonUtility.highlightElement(driver,obj_PortalPage.incidentManagementSummaryViewFilterButton()).getText();

			CommonUtility.highlightElement(driver,obj_PortalPage.incidentManagementSummaryViewFilterButton()).click();



			System.out.println("Clicked on "+filterButton);

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.incidentManagementFilterByPopupHeader()));

			CommonUtility.highlightElement(driver,obj_PortalPage.incidentManagementFilterByPopupHeader());

			filterByHeader = CommonUtility.highlightElement(driver,obj_PortalPage.incidentManagementFilterByPopupHeader()).getText();

			System.out.println("Header is"+filterByHeader);

			Report.put("Click on the filter button above the SR grid",
					"A window slides should open from the right side of the screen with the label 'Filter By'",
					"Clicked on button"+Report.color(filterButton)+"above the SR grid"+"displayed window with label"+Report.color(filterByHeader), "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();

			Report.put("Click on the filter button above the SR grid",
					"A window slides should open from the right side of the screen with the label 'Filter By'",
					"Failed to click on Filter button above the SR grid", "FAIL");
			Assert.fail();
		}
	}

	public void applyIncidentManagementSummaryViewFilter(WebDriver driver)
	{
		System.out.println("Inside applyIncidentManagementSummaryViewFilter method");
		Log.info("Inside applyIncidentManagementSummaryViewFilter method");


		String option = "";
		String srHeader = "";
		String srStatusLabel = "";
		String filterBreadcrumb = "";
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);


			if(CommonUtility.highlightElement(driver,obj_PortalPage.incidentManagementFilterByPopupClearAllButton()).isEnabled())
			{
				CommonUtility.highlightElement(driver,obj_PortalPage.incidentManagementFilterByPopupClearAllButton()).click();
				System.out.println("Clicked on Clear All Button in Filter By Popup");
				clickIncidentManagementSummaryViewFilterButton(driver);
			}
			CommonUtility.scrollToViewElement(driver,(obj_PortalPage.incidentManagementFilterByPopupSRStatus()));
			option = CommonUtility.highlightElement(driver,obj_PortalPage.incidentManagementFilterByPopupSRStatus()).getText();

			CommonUtility.highlightElement(driver,obj_PortalPage.incidentManagementFilterByPopupSRStatus()).click();

			System.out.println("Clicked on option "+option);

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.incidentManagementFilterByPopupSRStatusHeader()));

			CommonUtility.highlightElement(driver,obj_PortalPage.incidentManagementFilterByPopupSRStatusHeader());

			srHeader = CommonUtility.highlightElement(driver,obj_PortalPage.incidentManagementFilterByPopupSRStatusHeader()).getText();

			System.out.println("Header is "+srHeader);


			CommonUtility.highlightElement(driver,obj_PortalPage.incidentManagementFilterByPopupSRStatusClosedLabel());

			srStatusLabel = CommonUtility.highlightElement(driver,obj_PortalPage.incidentManagementFilterByPopupSRStatusClosedLabel()).getText();

			System.out.println("SR Status Label is "+srStatusLabel);

			CommonUtility.scrollToViewElement(driver,(obj_PortalPage.incidentManagementFilterByPopupSRStatusClosedCheckbox()));

			CommonUtility.ToClickByUsingJavaScript_PassingByLoc(driver,obj_PortalPage.incidentManagementFilterByPopupSRStatusClosedCheckbox());

			CommonUtility.scrollToViewElement(driver,(obj_PortalPage.incidentManagementFilterByPopupApplySelectedButton())).click();



			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.incidentManagementFilterByPopupHeader()));
			CommonUtility.highlightElement(driver,obj_PortalPage.incidentManagementFilterByPopupCloseButton()).click();

			CommonUtility.highlightElement(driver,obj_PortalPage.incidentManagementFilterBreadcrumbSRStatus());
			filterBreadcrumb = CommonUtility.highlightElement(driver,obj_PortalPage.incidentManagementFilterBreadcrumbSRStatus()).getText();

			System.out.println("Filter displayed in breadcrumb "+filterBreadcrumb);

			Report.put("Apply a filter or select a view",
					"The Filter breadcrumbs should be displayed to reflect that the filter or visualization has been applied ",
					"Clicked on filter"+Report.color(option)+"with" + Report.color(srStatusLabel)+".Displayed filter in breadcrumb"+Report.color(filterBreadcrumb), "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();

			Report.put("Apply a filter or select a view",
					"The Filter breadcrumbs should be displayed to reflect that the filter or visualization has been applied ",
					"Failed to Apply the Filter", "FAIL");
			Assert.fail();
		}
	}

	public void clickIncidentManagementClearAllButton(WebDriver driver)
	{
		System.out.println("Inside clickIncidentManagementClearAllButton method");
		Log.info("Inside clickIncidentManagementClearAllButton method");


		String clearAllButton = "";

		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);

			CommonUtility.highlightElement(driver,(obj_PortalPage.incidentManagementFilterBreadcrumbClearAll()));
			clearAllButton = CommonUtility.highlightElement(driver,obj_PortalPage.incidentManagementFilterBreadcrumbClearAll()).getText();

			CommonUtility.highlightElement(driver,obj_PortalPage.incidentManagementFilterBreadcrumbClearAll()).click();					

			System.out.println("Clicked on "+clearAllButton);

			if(!(CommonUtility.CheckpresenceofElementLocated(driver, 5, obj_PortalPage.incidentManagementFilterBreadcrumbClearAll())))
			{
				System.out.println("Clear All is not present in breadcrumb");

				Report.put("Clear the filter and verify the breadcrumbs ",
						"The breadcrumbs should be cleared",
						"Clicked on button"+Report.color(clearAllButton), "PASS");
			}
			else
			{
				Report.put("Clear the filter and verify the breadcrumbs ",
						"The breadcrumbs should be cleared",
						"Failed to Clear the Filter", "FAIL");
				Assert.fail();
			}


		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Clear the filter and verify the breadcrumbs ",
					"The breadcrumbs should be cleared",
					"Failed to Clear the Filter", "FAIL");
			Assert.fail();
		}
	}

	public void clickIncidentManagementEscalationsButton(WebDriver driver)
	{
		System.out.println("Inside clickIncidentManagementEscalationsButton method");
		Log.info("Inside clickIncidentManagementEscalationsButton method");


		String escalationsButton = "";
		String escalationsBreadcrumb = "";
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);

			CommonUtility.highlightElement(driver,(obj_PortalPage.incidentManagementEscalationsButton()));
			escalationsButton = CommonUtility.highlightElement(driver,obj_PortalPage.incidentManagementEscalationsButton()).getText();

			CommonUtility.highlightElement(driver,obj_PortalPage.incidentManagementEscalationsButton()).click();					

			System.out.println("Clicked on "+escalationsButton);


			CommonUtility.highlightElement(driver,(obj_PortalPage.incidentManagementFilterBreadcrumbEscalations()));
			escalationsBreadcrumb = CommonUtility.highlightElement(driver,obj_PortalPage.incidentManagementFilterBreadcrumbEscalations()).getText();


			System.out.println("Displayed breadcrumb "+escalationsButton);

			Report.put("Select the Escalations from left menu ",
					"The breadcrumb should display the Escalations",
					"Clicked on button"+Report.color(escalationsButton)+"displayed "+Report.color(escalationsBreadcrumb)+"in the breadcrumb", "PASS");	
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Select the Escalations from left menu ",
					"The breadcrumb should display the Escalations",
					"Failed to Select the Escalations from left menu", "FAIL");
			Assert.fail();
		}
	}

	public void verifyIncidentManagementSummaryViewFilterEscalationsOption(WebDriver driver)
	{
		System.out.println("Inside verifyIncidentManagementSummaryViewFilterEscalationsOption method");
		Log.info("Inside verifyIncidentManagementSummaryViewFilterEscalationsOption method");


		String option = "";
		String escalationsHeader = "";
		String escalationSelectAll = "";
		String escalationOpen = "";
		String escalationClosed = "";

		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);

			CommonUtility.scrollToViewElement(driver,(obj_PortalPage.incidentManagementFilterByPopupEscalations()));
			option = CommonUtility.highlightElement(driver,obj_PortalPage.incidentManagementFilterByPopupEscalations()).getText();

			CommonUtility.highlightElement(driver,obj_PortalPage.incidentManagementFilterByPopupEscalations()).click();

			System.out.println("Clicked on option "+option);

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.incidentManagementFilterByPopupEscalationsHeader()));

			CommonUtility.highlightElement(driver,obj_PortalPage.incidentManagementFilterByPopupEscalationsHeader());

			escalationsHeader = CommonUtility.highlightElement(driver,obj_PortalPage.incidentManagementFilterByPopupEscalationsHeader()).getText();

			System.out.println("Header is "+escalationsHeader);


			CommonUtility.highlightElement(driver,obj_PortalPage.incidentManagementFilterByPopupEscalationsSelectAll());

			escalationSelectAll = CommonUtility.highlightElement(driver,obj_PortalPage.incidentManagementFilterByPopupEscalationsSelectAll()).getText();

			System.out.println("Label is "+escalationSelectAll);


			CommonUtility.highlightElement(driver,obj_PortalPage.incidentManagementFilterByPopupEscalationsOpen());

			escalationOpen = CommonUtility.highlightElement(driver,obj_PortalPage.incidentManagementFilterByPopupEscalationsOpen()).getText();

			System.out.println("Label is "+escalationOpen);

			CommonUtility.highlightElement(driver,obj_PortalPage.incidentManagementFilterByPopupEscalationsClosed());

			escalationClosed = CommonUtility.highlightElement(driver,obj_PortalPage.incidentManagementFilterByPopupEscalationsClosed()).getText();

			System.out.println("Label is "+escalationClosed);

			CommonUtility.scrollToViewElement(driver,(obj_PortalPage.incidentManagementFilterByPopupEscalationsHeader())).click();
			CommonUtility.highlightElement(driver,obj_PortalPage.incidentManagementFilterByPopupCloseButton()).click();

			Report.put("Verify the Summary view ",
					"The summary view of Escalations should be displayed with 3 options under the Filter By ->Escalations :Select All/Open/Closed ",
					"Clicked on filter"+Report.color(option)+"displayed with options "+Report.color(escalationSelectAll)+"<br>"+Report.color(escalationOpen)+"<br>"+Report.color(escalationClosed), "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();

			Report.put("Verify the Summary view ",
					"The summary view of Escalations should be displayed with 3 options under the Filter By ->Escalations :Select All/Open/Closed ",
					"Failed to display Escalations in Summary View", "FAIL");
			Assert.fail();
		}
	}

	public void clickIncidentManagementExpandButton(WebDriver driver)
	{
		System.out.println("Inside clickIncidentManagementExpandButton method");
		Log.info("Inside clickIncidentManagementExpandButton method");


		String expandButton = "";
		String expandHeader = "";

		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);

			CommonUtility.scrollToViewElement(driver,(obj_PortalPage.incidentManagementExpandButton()));
			expandButton = CommonUtility.highlightElement(driver,obj_PortalPage.incidentManagementExpandButton()).getText();

			CommonUtility.highlightElement(driver,obj_PortalPage.incidentManagementExpandButton()).click();

			System.out.println("Clicked on "+expandButton);

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.incidentManagementExpandHeader()));

			CommonUtility.highlightElement(driver,obj_PortalPage.incidentManagementExpandHeader());

			expandHeader = CommonUtility.highlightElement(driver,obj_PortalPage.incidentManagementExpandHeader()).getText();

			System.out.println("Header is "+expandHeader);

			Report.put("Click on the Expand Button",
					"A popup should open with the expanded view",
					"Clicked on button"+Report.color(expandButton)+"above the SR grid"+"displayed window with header"+Report.color(expandHeader), "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();


			Report.put("Click on the Expand Button",
					"A popup should open with the expanded view",
					"Failed to click on Expand button above the SR grid", "FAIL");
			Assert.fail();
		}
	}

	public void verifyIncidentManagementExpandViewFilterEscalationsOption(WebDriver driver)
	{
		System.out.println("Inside verifyIncidentManagementExpandViewFilterEscalationsOption method");
		Log.info("Inside verifyIncidentManagementExpandViewFilterEscalationsOption method");


		String option = "";
		String escalationsHeader = "";
		String escalationSelectAll = "";
		String escalationOpen = "";
		String escalationClosed = "";
		String escalationNeverEscalated = "";
		String escalationNone = "";

		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);


			//CommonUtility.scrollToViewElement(driver,(obj_PortalPage.incidentManagementFilterByPopupEscalations()));

			option = CommonUtility.highlightElement(driver,obj_PortalPage.incidentManagementFilterByPopupEscalations()).getText();
			CommonUtility.ToClickByUsingJavaScript_PassingByLoc(driver,obj_PortalPage.incidentManagementFilterByPopupEscalations());
			//	CommonUtility.highlightElement(driver,obj_PortalPage.incidentManagementFilterByPopupEscalations()).click();

			System.out.println("Clicked on option "+option);

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.incidentManagementFilterByPopupEscalationsHeader()));

			CommonUtility.scrollToViewElement(driver,(obj_PortalPage.incidentManagementFilterByPopupEscalationsHeader()));
			CommonUtility.highlightElement(driver,obj_PortalPage.incidentManagementFilterByPopupEscalationsHeader());

			escalationsHeader = CommonUtility.highlightElement(driver,obj_PortalPage.incidentManagementFilterByPopupEscalationsHeader()).getText();

			System.out.println("Header is "+escalationsHeader);


			CommonUtility.highlightElement(driver,obj_PortalPage.incidentManagementFilterByPopupEscalationsSelectAll());

			escalationSelectAll = CommonUtility.highlightElement(driver,obj_PortalPage.incidentManagementFilterByPopupEscalationsSelectAll()).getText();

			System.out.println("Label is "+escalationSelectAll);


			CommonUtility.highlightElement(driver,obj_PortalPage.incidentManagementFilterByPopupEscalationsOpen());

			escalationOpen = CommonUtility.highlightElement(driver,obj_PortalPage.incidentManagementFilterByPopupEscalationsOpen()).getText();

			System.out.println("Label is "+escalationOpen);

			CommonUtility.highlightElement(driver,obj_PortalPage.incidentManagementFilterByPopupEscalationsClosed());

			escalationClosed = CommonUtility.highlightElement(driver,obj_PortalPage.incidentManagementFilterByPopupEscalationsClosed()).getText();

			System.out.println("Label is "+escalationClosed);

			CommonUtility.highlightElement(driver,obj_PortalPage.incidentManagementFilterByPopupEscalationsNeverEscalated());

			escalationNeverEscalated = CommonUtility.highlightElement(driver,obj_PortalPage.incidentManagementFilterByPopupEscalationsNeverEscalated()).getText();

			System.out.println("Label is "+escalationNeverEscalated);

			CommonUtility.highlightElement(driver,obj_PortalPage.incidentManagementFilterByPopupEscalationsNone());

			escalationNone = CommonUtility.highlightElement(driver,obj_PortalPage.incidentManagementFilterByPopupEscalationsNone()).getText();

			System.out.println("Label is "+escalationNone);

			CommonUtility.scrollToViewElement(driver,(obj_PortalPage.incidentManagementFilterByPopupEscalationsHeader())).click();
			CommonUtility.highlightElement(driver,obj_PortalPage.incidentManagementFilterByPopupCloseButton()).click();

			Report.put("Verify the Expanded view ",
					"Expanded view should be displayed with the following Filter By options->Escalations :  Select All/Open/Closed/Never Escalated / None",
					"Clicked on filter"+Report.color(option)+"displayed with options "+Report.color(escalationSelectAll)+"<br>"+Report.color(escalationOpen)+"<br>"+Report.color(escalationClosed)+"<br>"+Report.color(escalationNeverEscalated)+"<br>"+Report.color(escalationNone), "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();

			Report.put("Verify the Expanded view ",
					"Expanded view should be displayed with the following Filter By options->Escalations :  Select All/Open/Closed/Never Escalated / None",
					"Failed to display Escalations in Expanded View", "FAIL");
			Assert.fail();
		}
	}

	//Lavanya

	public void ClickOnIncidentManagementTab(WebDriver driver)
	{

		Log.info("ClickOnIncidentManagementTab");	
		WebDriverWait wait = new WebDriverWait(driver, 240);
		String text="";
		String text1="";
		driver.manage().timeouts().implicitlyWait(35000, TimeUnit.SECONDS);
		String value=TestNGCreator.TestData.get(Esupport.Dpid.ordinal());
		try
		{
//			Thread.sleep(30000);
			//			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.IncidentsManagementTab()));
			if(CommonUtility.CheckpresenceofElementLocated(driver, 50, obj_PortalPage.IncidentsManagementTab()))
			{

				CommonUtility.ScrollTo(driver,obj_PortalPage.IncidentsManagementTab());
				CommonUtility.ClickOn(driver,obj_PortalPage.IncidentsManagementTab()); 
				
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.AfterClickingIncidentsManagementTab()));
				String tab=CommonUtility.highlightElement(driver,obj_PortalPage.AfterClickingIncidentsManagementTab()).getText();
				System.out.println(tab);
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.SRsTabDefault()));
				text=CommonUtility.highlightElement(driver,obj_PortalPage.SRsTabDefault()).getText(); 
				System.out.println(text);
				text1=CommonUtility.highlightElement(driver,obj_PortalPage.TableViewDefaultDisplay()).getText(); 
				System.out.println(text1);

				Report.put("Navigate to the SR/Incident Management tab by clicking on it", 
						"User will see Open SRs in tabular view." ,
						"User able to click on "+Report.color(tab)+" tab and able to see "+Report.color(text+" displays in "+text1)+" view", "PASS");
			}
			else
			{
				System.out.println("not ble to see Incidents Management tab");
				Report.put("Navigate to the SR/Incident Management tab by clicking on it", 
						"User will see Open SRs in tabular view." ,
						"Failed to click on Incident Management tab", "FAIL");

				Assert.fail();
			}

		}
		catch(Exception e)
		{
			Log.info(e);
			Report.put("Navigate to the SR/Incident Management tab by clicking on it", 
					"User will see Open SRs in tabular view." ,
					"Failed to click on Incident Management tab", "FAIL");
			e.printStackTrace();
			Assert.fail();
		}

	} 

	public void VerifyPageNumbersDisplayingUnderPaginationSection(WebDriver driver)
	{

		Log.info("VerifyPageNumbersDisplayingUnderPaginationSection");	
		WebDriverWait wait = new WebDriverWait(driver, 120);
		String text="";

		try
		{
			if(CommonUtility.CheckpresenceofElementLocated(driver, 15, obj_PortalPage.PagesDisplayedInPagination()))
			{

				CommonUtility.scrollToViewElement(driver,obj_PortalPage.PagesDisplayedInPagination());
				String pagesdisplayed=CommonUtility.highlightElement(driver,obj_PortalPage.PagesDisplayedInPagination()).getText();
				System.out.println(pagesdisplayed);

				CommonUtility.scrollToViewElement(driver,obj_PortalPage.PageNumberDisplayed());
				text=CommonUtility.highlightElement(driver,obj_PortalPage.PageNumberDisplayed()).getText(); 
				System.out.println(text);


				Report.put("Verify page numbers are displayed in the pagination section", 
						"Page numbers are displayed 1st page display and followed by total number of pages present" ,
						"User able to see "+Report.color(pagesdisplayed)+" section and display "+Report.color(text)+" page by default", "PASS");

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

		try
		{
			if(CommonUtility.CheckpresenceofElementLocated(driver, 15, obj_PortalPage.PageNumberDisplayed()))
			{

				CommonUtility.scrollToViewElement(driver,obj_PortalPage.PageNumberDisplayed());
				String pagesdisplayed=CommonUtility.highlightElement(driver,obj_PortalPage.PageNumberDisplayed()).getText();
				System.out.println(pagesdisplayed);

				if(pagesdisplayed.equals("1"))
				{

					CommonUtility.scrollToViewElement(driver,obj_PortalPage.GoToFirstPageArrowMark());
					CommonUtility.highlightElement(driver,obj_PortalPage.GoToFirstPageArrowMark());

					CommonUtility.scrollToViewElement(driver,obj_PortalPage.GoToPreviousPageArrowMark());
					CommonUtility.highlightElement(driver,obj_PortalPage.GoToPreviousPageArrowMark());

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

		try
		{
			if(CommonUtility.CheckpresenceofElementLocated(driver, 15, obj_PortalPage.GoToLastPageArrowMark()))
			{

				CommonUtility.scrollToViewElement(driver,obj_PortalPage.GoToLastPageArrowMark());
				CommonUtility.highlightElement(driver,obj_PortalPage.GoToLastPageArrowMark()).click();

				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.PageNumberDisplayed()));
				String pagesdisplayed=CommonUtility.highlightElement(driver,obj_PortalPage.PageNumberDisplayed()).getText();
				System.out.println(pagesdisplayed);

				if(!(pagesdisplayed.equals("1")))
				{

					CommonUtility.scrollToViewElement(driver,obj_PortalPage.GoToNextPageArrowMarkDisabled());
					CommonUtility.highlightElement(driver,obj_PortalPage.GoToNextPageArrowMarkDisabled());

					CommonUtility.scrollToViewElement(driver,obj_PortalPage.GoToLastPageArrowMarkDisabled());
					CommonUtility.highlightElement(driver,obj_PortalPage.GoToLastPageArrowMarkDisabled());

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


	public void SelectPerticularPageAndValidateBackFilledColor(WebDriver driver)
	{

		Log.info("Entering SelectPerticularPageAndValidateBackFilledColor method");	
		WebDriverWait wait = new WebDriverWait(driver, 120);
		Actions act=new Actions(driver);
		String color="";

		try
		{
			if(CommonUtility.CheckpresenceofElementLocated(driver, 15, obj_PortalPage.PageNumberDisplayed()))
			{
				//				CommonUtility.scrollToViewElement(driver, obj_PortalPage.PageNumberDisplayed());
				act.moveToElement(driver.findElement(obj_PortalPage.PageNumberDisplayed())).click().build().perform();
				Thread.sleep(6000);
				color=driver.findElement(obj_PortalPage.PageNumberDisplayed()).getCssValue("color");
				System.out.println(color);
//				Thread.sleep(10000);

				if(color.equals("rgba(0, 0, 0, 1)"))
				{

					System.out.println("page number is black color font");

				}


				Report.put("When user is on a particular page then that page number is selected and selection is displayed in black color font", 
						"Pages which are not selected should displayed in black color font" ,
						"When User is on selected page number, selection display black color font", "PASS");

			}
			else
			{
				System.out.println("pages displayed pagination section not displayed");
				Report.put("When user is on a particular page then that page number is selected and selection is displayed in black color font", 
						"Pages which are not selected should displayed in black color font" ,
						"not able to see pages number displayed", "FAIL");
				Assert.fail();
			}
		}
		catch(Exception e)
		{
			Log.info(e);
			Report.put("When user is on a particular page then that page number is selected and selection is displayed in black color font", 
					"Pages which are not selected should displayed in black color font" ,
					"not able to see pages number displayed", "FAIL");
			e.printStackTrace();
			Assert.fail();
		}

	} 

	public void ValidatePageSizeSelectorSection(WebDriver driver)
	{

		Log.info("Entering ValidatePageSizeSelectorSection method");	
		WebDriverWait wait = new WebDriverWait(driver, 120);
		Actions act=new Actions(driver);
		String sizesection="";
		String defaultsizeofpage="";
		String dropdownvalues="";
		try
		{
			if(CommonUtility.CheckpresenceofElementLocated(driver, 15, obj_PortalPage.PageSizeSection()))
			{

				CommonUtility.scrollToViewElement(driver,obj_PortalPage.PageSizeSection());	
				sizesection=CommonUtility.highlightElement(driver,obj_PortalPage.PageSizeSection()).getText();
				System.out.println(sizesection);

				CommonUtility.scrollToViewElement(driver,obj_PortalPage.DefaultDisplayedPerPageValue());	
				defaultsizeofpage=CommonUtility.highlightElement(driver,obj_PortalPage.DefaultDisplayedPerPageValue()).getText();
				System.out.println(defaultsizeofpage);

				List<WebElement> list=driver.findElements(obj_PortalPage.DropDownValuesUnderPageSizeSection());
				for(WebElement lt:list)
				{
					CommonUtility.highlightElement(driver, lt);
					String tabName=lt.getText();

					System.out.println("Tab is: " +tabName);
					dropdownvalues+=" <br> " + tabName;
				}
				System.out.println("Tabs are:"+dropdownvalues);


				if(defaultsizeofpage.equals("10"))
				{

					System.out.println(" default page size is 10");

				}


				Report.put("Validate if Page Size selector section - Default size is 10 that will be in Black text indicating the user that it is the selected page", 
						"Default size should be 10 & should be in Black text indicating the user that it is the selected page" ,
						"Page size section displayed and display "+Report.color(defaultsizeofpage)+" number per page as size and <br> also display all different options as "+Report.color(dropdownvalues), "PASS");

			}
			else
			{
				System.out.println("page size section not displayed");
				Report.put("Validate if Page Size selector section - Default size is 10 that will be in Black text indicating the user that it is the selected page", 
						"Default size should be 10 & should be in Black text indicating the user that it is the selected page" ,
						"not able to see page size section", "FAIL");
				Assert.fail();
			}
		}
		catch(Exception e)
		{
			Log.info(e);
			Report.put("Validate if Page Size selector section - Default size is 10 that will be in Black text indicating the user that it is the selected page", 
					"Default size should be 10 & should be in Black text indicating the user that it is the selected page" ,
					"not able to see page size section", "FAIL");
			e.printStackTrace();
			Assert.fail();
		}

	} 

	public void VerifySearchBoxSearchingAnyCharacters(WebDriver driver)
	{

		Log.info("Entering VerifySearchBoxSearchingAnyCharacters method");	
		WebDriverWait wait = new WebDriverWait(driver, 120);
		Actions act=new Actions(driver);
		String placeholder="";
		String header="";
		String displayedvalues="";
		String displayedvalues1="";
		String displayedvalues2="";
		String message="";
		String value=TestNGCreator.TestData.get(Esupport.SearchOption.ordinal());
		try
		{
			if(CommonUtility.CheckpresenceofElementLocated(driver, 15, obj_PortalPage.SearchTextBox()))
			{

				CommonUtility.ScrollTo(driver,obj_PortalPage.SearchTextBox());	
				placeholder=CommonUtility.highlightElement(driver,obj_PortalPage.SearchTextBox()).getAttribute("placeholder");
				System.out.println(placeholder);
				CommonUtility.highlightElement(driver,obj_PortalPage.SearchTextBox()).sendKeys(value);

				CommonUtility.ScrollTo(driver,obj_PortalPage.SearchButton());
				CommonUtility.ClickOn(driver,obj_PortalPage.SearchButton());

				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.HeaderOfThePopUp()));


				CommonUtility.ScrollTo(driver,obj_PortalPage.HeaderOfThePopUp());	
				header=CommonUtility.highlightElement(driver,obj_PortalPage.HeaderOfThePopUp()).getText();
				System.out.println("header is "+header);

				if(CommonUtility.CheckpresenceofElementLocated(driver, 15, obj_PortalPage.CountOfRowsDisplayed()))
				{

					List<WebElement> list=driver.findElements(obj_PortalPage.CountOfRowsDisplayed());
					List<WebElement> list1=driver.findElements(obj_PortalPage.RowsDisplayedUnderTable1());
					List<WebElement> list2=driver.findElements(obj_PortalPage.ValuesDisplayedUnderOtherDetailsTable());
					int count=list.size();
					System.out.println("count of values displayed are "+count);
					for(WebElement lt:list)
					{
						CommonUtility.highlightElement(driver, lt);
						String tabName=lt.getText();

						System.out.println("Tab is: " +tabName);
						displayedvalues+=" <br> " + tabName;
					}
					System.out.println("Tabs are:"+displayedvalues);

					int counts=0;
					for(WebElement lt:list1)
					{
						CommonUtility.scrollToViewElement(driver, lt);
						CommonUtility.highlightElement(driver, lt);
						String tabName=lt.getText();

						System.out.println("Tab is: " +tabName);
						displayedvalues1+=" <br> " + tabName;

						if(displayedvalues1.contains(value))
						{
							counts++;

						}
					}
					System.out.println("Tabs are:"+displayedvalues1);

					System.out.println("count of matching in first table are "+counts);

					int countss=0;
					for(WebElement lt:list2)
					{
						CommonUtility.highlightElement(driver, lt);
						String tabName=lt.getText();

						System.out.println("Tab is: " +tabName);
						displayedvalues2+=" <br> " + tabName;

						if(displayedvalues1.contains(value))
						{
							countss++;
						}
					}
					System.out.println("Tabs are:"+displayedvalues2);

					System.out.println("count of matching in second table are "+countss);

					int total=counts+countss;
					System.out.println("total count is "+total);


					Report.put("User verify Search box in the tabular view & types in the character in search box & Hit Enter or click on search icon", 
							"An expanded full screen should open up & Data should be filtered based on the search text ‘<searchText>example:searchText :66785" ,
							"user enters data as "+Report.color(value)+" in search box and able to click on search button and <br> expanded full view with header "+Report.color(header)+" displayed <br> with filtered searched data and count of displayed results are "+count+" along with SR number displayed "+Report.color(displayedvalues1), "PASS");

				}
				else
				{

					wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.HeaderOfThePopUp()));


					CommonUtility.scrollToViewElement(driver,obj_PortalPage.SearchedDataNotFoundMessage());	
					message=CommonUtility.highlightElement(driver,obj_PortalPage.SearchedDataNotFoundMessage()).getText();
					System.out.println("header is "+message);

					System.out.println("page size section not displayed");
					Report.put("User verify Search box in the tabular view & types in the character in search box & Hit Enter or click on search icon", 
							"An expanded full screen should open up & Data should be filtered based on the search text ‘<searchText>example:searchText :66785" ,
							"Searched data not found and display message as "+Report.color(message), "PASS");

				}
			}

			else
			{
				System.out.println("search text box not found");
				Report.put("User verify Search box in the tabular view & types in the character in search box & Hit Enter or click on search icon", 
						"An expanded full screen should open up & Data should be filtered based on the search text ‘<searchText>example:searchText :66785" ,
						"not able to see search text box", "FAIL");
				Assert.fail();
			}
		}
		catch(Exception e)
		{
			Log.info(e);
			Report.put("User verify Search box in the tabular view & types in the character in search box & Hit Enter or click on search icon", 
					"An expanded full screen should open up & Data should be filtered based on the search text ‘<searchText>example:searchText :66785" ,
					"not able to see search text box", "FAIL");
			e.printStackTrace();
			Assert.fail();
		}

	} 

	public void ClickOnExpandButton(WebDriver driver)
	{

		Log.info("Entering ClickOnExpandButton method");	
		WebDriverWait wait = new WebDriverWait(driver, 120);
		Actions act=new Actions(driver);
		String expand="";
		String header="";


		try
		{
			if(CommonUtility.CheckpresenceofElementLocated(driver, 15, obj_PortalPage.ExpandButtonOnTabularView()))
			{

				CommonUtility.ScrollTo(driver,obj_PortalPage.ExpandButtonOnTabularView());	
				expand=CommonUtility.highlightElement(driver,obj_PortalPage.ExpandButtonOnTabularView()).getText();
				System.out.println(expand);
				CommonUtility.ClickOn(driver,obj_PortalPage.ExpandButtonOnTabularView());

				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.HeaderOfThePopUp()));


				CommonUtility.ScrollTo(driver,obj_PortalPage.HeaderOfThePopUp());	
				header=CommonUtility.highlightElement(driver,obj_PortalPage.HeaderOfThePopUp()).getText();
				System.out.println("header is "+header);

				Report.put("User goes to the View All and is able to see  an icon with a label \"Download\" ", 
						"The CSV file should get downloaded" ,
						"User should be able to see "+Report.color(expand)+" button and able to expand tabular view with header "+Report.color(header), "PASS");

			}


			else
			{
				System.out.println("expand button not displayed for tabular view");
				Report.put("User goes to the View All and is able to see  an icon with a label \"Download\" ", 
						"The CSV file should get downloaded" ,
						"not able to see expand button", "FAIL");
				Assert.fail();
			}
		}
		catch(Exception e)
		{
			Log.info(e);
			Report.put("User goes to the View All and is able to see  an icon with a label \"Download\" ", 
					"The CSV file should get downloaded" ,
					"not able to see expand button", "FAIL");
			e.printStackTrace();
			Assert.fail();
		}

	} 

	public void ClickOnHeaderOfColumnOnGridInTheFullScreen(WebDriver driver)
	{

		Log.info("Entering ClickOnHeaderOfColumnOnGridInTheFullScreen method");	
		WebDriverWait wait = new WebDriverWait(driver, 120);
		Actions act=new Actions(driver);
		String placeholder="";
		String header="";
		String displayedvalues="";
		String displayedvalues1="";
		String displayedvalues2="";
		String message="";
		String value=TestNGCreator.TestData.get(Esupport.SearchOption.ordinal());
		try
		{
			if(CommonUtility.CheckpresenceofElementLocated(driver, 15, obj_PortalPage.HeaderOfThePopUp()))
			{

				if(CommonUtility.CheckpresenceofElementLocated(driver, 15, obj_PortalPage.CountOfRowsDisplayed()))
				{

					List<WebElement> list=driver.findElements(obj_PortalPage.HeadingsOfTable1());
					List<WebElement> list1=driver.findElements(obj_PortalPage.OtherDetailsDisplayedInResultPopUp());


					for(WebElement lt:list)
					{
						CommonUtility.scrollToViewElement(driver, lt);
						CommonUtility.highlightElement(driver, lt).click();
						Thread.sleep(7000);

					}


					for(WebElement lt:list1)
					{

						CommonUtility.scrollToViewElement(driver, lt);
						CommonUtility.highlightElement(driver, lt).click();
						Thread.sleep(7000);
					}

					Report.put("The columns on the grid in the Full screen view can be sorted by clicking on the header ", 
							"user able to click on header in the full screen view and user able to sort the column header" ,
							"user able to sort items clicking on column headers in expanded view of the grid", "PASS");

				}
				else
				{

					wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.HeaderOfThePopUp()));


					CommonUtility.scrollToViewElement(driver,obj_PortalPage.SearchedDataNotFoundMessage());	
					message=CommonUtility.highlightElement(driver,obj_PortalPage.SearchedDataNotFoundMessage()).getText();
					System.out.println("header is "+message);

					System.out.println("page size section not displayed");
					Report.put("The columns on the grid in the Full screen view can be sorted by clicking on the header ", 
							"user able to click on header in the full screen view and user able to sort the column header" ,
							"coulmns not found in grid and display message as "+Report.color(message), "PASS");

				}
			}

			else
			{
				System.out.println("expanded view not found");
				Report.put("The columns on the grid in the Full screen view can be sorted by clicking on the header ", 
						"user able to click on header in the full screen view and user able to sort the column header" ,
						"not able to see expanded view", "FAIL");
				Assert.fail();
			}
		}
		catch(Exception e)
		{
			Log.info(e);
			Report.put("The columns on the grid in the Full screen view can be sorted by clicking on the header ", 
					"user able to click on header in the full screen view and user able to sort the column header" ,
					"not able to see expanded view", "FAIL");
			e.printStackTrace();
			Assert.fail();
		}

	} 

	public void ClickOnOnsiteServicesTabOnLeftMenu(WebDriver driver)
	{

		Log.info("ClickOnOnsiteServicesTabOnLeftMenu");	
		WebDriverWait wait = new WebDriverWait(driver, 240);
		String text="";
		String text1="";
		String text2="";
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		try
		{
			//			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.IncidentsManagementTab()));
			if(CommonUtility.CheckpresenceofElementLocated(driver, 50, obj_PortalPage.OnlineServicesButton()))
			{
				CommonUtility.scrollToViewElement(driver,obj_PortalPage.OnlineServicesButton());
				text=CommonUtility.highlightElement(driver,obj_PortalPage.OnlineServicesButton()).getText(); 
				System.out.println(text);
				CommonUtility.highlightElement(driver,obj_PortalPage.OnlineServicesButton()).click();

				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.HeadingsInColumnsOfGridInOnsiteServices()));

				List<WebElement> list=driver.findElements(obj_PortalPage.HeadingsInColumnsOfGridInOnsiteServices());


				for(WebElement lt:list)
				{
					CommonUtility.highlightElement(driver, lt);
					String heading=lt.getText();

					System.out.println(heading);

					text1+=" <br> "+heading;
				}
				System.out.println("headings are "+text1);

				try
				{

					List<WebElement> list1=driver.findElements(obj_PortalPage.ValuesUnderGridInOnsiteServices());


					for(WebElement lt:list1)
					{
						Thread.sleep(7000);
						CommonUtility.highlightElement(driver, lt);
						String values=lt.getText();

						System.out.println(values);

						text2+=" <br> "+values;
					}
					System.out.println("headings are "+text2);
				}
				catch(Exception e)
				{
					Log.info(e);

				}

				Report.put("Click on the Onsite services menu from the left", 
						"The Onsite Services should be displayed" ,
						"Able to click on "+Report.color(text)+" from the left and all details deisplayed under Onsite Services", "PASS");
			}
			else
			{
				System.out.println("not ble to see Onsite Services button");
				Report.put("Click on the Onsite services menu from the left", 
						"The Onsite Services should be displayed" ,
						"Onsite Services not displayed", "FAIL");

				Assert.fail();
			}

		}
		catch(Exception e)
		{
			Log.info(e);
			Report.put("Click on the Onsite services menu from the left", 
					"The Onsite Services should be displayed" ,
					"Onsite Services not displayed", "FAIL");
			e.printStackTrace();
			Assert.fail();
		}

	} 


	public void ClickOnMap(WebDriver driver)
	{

		Log.info("ClickOnMap");	
		WebDriverWait wait = new WebDriverWait(driver, 240);
		String text="";
		String text1="";
		String map="";
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		Actions act=new Actions(driver);
		String value=TestNGCreator.TestData.get(Esupport.Dpid.ordinal());
		try
		{
			//			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.IncidentsManagementTab()));
			if(CommonUtility.CheckpresenceofElementLocated(driver, 50, obj_PortalPage.MapButtonUnderIncidentManagementTab()))
			{
				CommonUtility.scrollToViewElement(driver,obj_PortalPage.MapButtonUnderIncidentManagementTab());
				map=CommonUtility.highlightElement(driver,obj_PortalPage.MapButtonUnderIncidentManagementTab()).getText();
				System.out.println(map);
				CommonUtility.highlightElement(driver,obj_PortalPage.MapButtonUnderIncidentManagementTab()).click(); 
				driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
				Thread.sleep(10000);
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.WhiteSpotsThatIndicateSiteLocation()));
				List<WebElement> list=driver.findElements(obj_PortalPage.WhiteSpotsThatIndicateSiteLocation());


				for(WebElement lt:list)
				{
					if(value=="ED")
					{

						act.moveToElement(CommonUtility.highlightElement(driver, lt)).build().perform();
						CommonUtility.highlightElement(driver, lt);
					}
					else
					{
//						CommonUtility.scrollToViewElement(driver, lt);

						act.moveToElement(CommonUtility.highlightElement(driver, lt)).build().perform();
						CommonUtility.highlightElement(driver, lt);
					}


				}


				Report.put("Click on the geospatial icon", 
						"The sites should be displayed as white spots and the user should be able to click on the spots" ,
						"user able to click on "+Report.color(map)+" and able to see white spots", "PASS");
			}
			else
			{
				System.out.println("not ble to see map icon/hyperlink");
				Report.put("Click on the geospatial icon", 
						"The sites should be displayed as white spots and the user should be able to click on the spots" ,
						"Failed to click on map", "FAIL");

				Assert.fail();
			}

		}
		catch(Exception e)
		{
			Log.info(e);
			Report.put("Click on the geospatial icon", 
					"The sites should be displayed as white spots and the user should be able to click on the spots" ,
					"Failed to click on map", "FAIL");
			e.printStackTrace();
			Assert.fail();
		}

	} 


	public void ClickOnAnyWhiteSpotThatIndicatesSiteLocation(WebDriver driver)
	{

		Log.info("ClickOnAnyWhiteSpotThatIndicatesSiteLocation");	
		WebDriverWait wait = new WebDriverWait(driver, 240);
		String text="";
		String text1="";
		String map="";
		String text2="";
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		Actions act=new Actions(driver);
		String value=TestNGCreator.TestData.get(Esupport.Dpid.ordinal());
		try
		{
			//			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.IncidentsManagementTab()));
			if(CommonUtility.CheckpresenceofElementLocated(driver, 50, obj_PortalPage.WhiteSpotsThatIndicateSiteLocation()))
			{
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.WhiteSpotsThatIndicateSiteLocation()));
				List<WebElement> list=driver.findElements(obj_PortalPage.WhiteSpotsThatIndicateSiteLocation());
				for( int i=0;i<=list.size();i++)
				{
					if(i==0)
					{

						if(value=="ED")
						{
							CommonUtility.scrollToViewElement(driver, list.get(i));
							//							CommonUtility.highlightElement(driver, list.get(i)).click();
							WebElement element =driver.findElement(By.xpath("(//*[@class='sba-geo-map-marker sba-geo-map-circle-bubble'])["+i+"]"));
							((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);
						}
						else
						{
							CommonUtility.scrollToViewElement(driver, list.get(i));
							//						CommonUtility.highlightElement(driver, list.get(i)).click();
							//						CommonUtility.ToClickByUsingJavaScript_PassingByLoc(driver, list.get(i));
							act.moveToElement(CommonUtility.highlightElement(driver, list.get(i))).click().build().perform();
						}

						wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.HeaderOnPopUpDisplayedClickingOnWhiteSpot()));
						text1=CommonUtility.highlightElement(driver, obj_PortalPage.HeaderOnPopUpDisplayedClickingOnWhiteSpot()).getText();
						System.out.println("header is "+text1);
						List<WebElement> list1=driver.findElements(obj_PortalPage.DetailsIndisePopUpDisplayedClickingOnWhiteSpot());

						for(WebElement lt:list1)
						{
							CommonUtility.scrollToViewElement(driver, list.get(i));
							CommonUtility.highlightElement(driver, list.get(i));
							String values=lt.getText();
							System.out.println("displayed "+values);

							text+=" <br> "+values;
							break;
						}
						System.out.println("displayed values in pop are "+text);
						text2=CommonUtility.highlightElement(driver, obj_PortalPage.CircleInPopUpInMapView()).getText();
						System.out.println(text2);
					}
				}


				Report.put("Click on any of the white spots that indicate site location", 
						"A popup with the data points  should be displayed depending on the context" ,
						"user able to click on white spot and able to see pop up with header "+Report.color(text1)+" and able to see details displayed as "+Report.color(text+" and circle display "+text2), "PASS");
			}
			else
			{
				System.out.println("not ble to see white spots");
				Report.put("Click on any of the white spots that indicate site location", 
						"A popup with the data points  should be displayed depending on the context" ,
						"failed to click on white spot", "FAIL");

				Assert.fail();
			}

		}
		catch(Exception e)
		{
			Log.info(e);
			Report.put("Click on any of the white spots that indicate site location", 
					"A popup with the data points  should be displayed depending on the context" ,
					"failed to click on white spot", "FAIL");
			e.printStackTrace();
			Assert.fail();
		}

	} 

	public void ClickOnDataPoint(WebDriver driver)
	{

		Log.info("ClickOnDataPoint");	
		WebDriverWait wait = new WebDriverWait(driver, 240);
		String text="";
		String text1="";
		String header="";
		String displayedvalues="";
		String displayedvalues1="";
		String displayedvalues2="";
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		Actions act=new Actions(driver);
		//		String value=TestNGCreator.TestData.get(Esupport.Dpid.ordinal());
		int count=0;
		try
		{
			//			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.IncidentsManagementTab()));
			if(CommonUtility.CheckpresenceofElementLocated(driver, 50, obj_PortalPage.DataPointClick()))
			{
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.DataPointClick()));
				CommonUtility.scrollToViewElement(driver, obj_PortalPage.DataPointClick());
				CommonUtility.highlightElement(driver, obj_PortalPage.DataPointClick()).click();


				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.HeaderOfThePopUp()));


				CommonUtility.scrollToViewElement(driver,obj_PortalPage.HeaderOfThePopUp());	
				header=CommonUtility.highlightElement(driver,obj_PortalPage.HeaderOfThePopUp()).getText();
				System.out.println("header is "+header);

				if(CommonUtility.CheckpresenceofElementLocated(driver, 15, obj_PortalPage.CountOfRowsDisplayed()))
				{

					List<WebElement> list=driver.findElements(obj_PortalPage.CountOfRowsDisplayed());
					List<WebElement> list1=driver.findElements(obj_PortalPage.RowsDisplayedUnderTable1());
					List<WebElement> list2=driver.findElements(obj_PortalPage.ValuesDisplayedUnderOtherDetailsTable());
					count=list.size();
					System.out.println("count of values displayed are "+count);
					for(WebElement lt:list)
					{
						CommonUtility.highlightElement(driver, lt);
						String tabName=lt.getText();

						System.out.println("Tab is: " +tabName);
						displayedvalues+=" <br> " + tabName;
					}
					System.out.println("Tabs are:"+displayedvalues);


					for(WebElement lt:list1)
					{
						CommonUtility.scrollToViewElement(driver, lt);
						CommonUtility.highlightElement(driver, lt);
						String tabName=lt.getText();

						System.out.println("Tab is: " +tabName);
						displayedvalues1+=" <br> " + tabName;


					}
					System.out.println("Tabs are:"+displayedvalues1);



					for(WebElement lt:list2)
					{
						CommonUtility.highlightElement(driver, lt);
						String tabName=lt.getText();

						System.out.println("Tab is: " +tabName);
						displayedvalues2+=" <br> " + tabName;


					}
					System.out.println("Tabs are:"+displayedvalues2);


				}

				Report.put("Click on the data point", 
						"A full screen should be displayed filtered based on the data point that was clicked on" ,
						"user able to click on data first data point and able to see expanded view filtered and displayed "+count+" rows", "PASS");
			}
			else
			{
				System.out.println("not ble to see white spots");
				Report.put("Click on the data point", 
						"A full screen should be displayed filtered based on the data point that was clicked on" ,
						"failed to click on data point", "FAIL");

				Assert.fail();
			}
		}
		catch(Exception e)
		{
			Log.info(e);
			Report.put("Click on the data point", 
					"A full screen should be displayed filtered based on the data point that was clicked on" ,
					"failed to click on data point", "FAIL");
			e.printStackTrace();
			Assert.fail();
		}

	} 

	public void verifyIncidentManagementDefaultSelectedFilter(WebDriver driver)
	{
		System.out.println("Inside verifyIncidentManagementDefaultSelectedFilter method");
		Log.info("Inside verifyIncidentManagementDefaultSelectedFilter method");


		String totalSRButton = "";
		String srBreadcrumb = "";
		String status = "";
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);

			CommonUtility.highlightElement(driver,(obj_PortalPage.incidentManagementTotalSRButton()));
			totalSRButton = CommonUtility.highlightElement(driver,obj_PortalPage.incidentManagementTotalSRButton()).getText();

			CommonUtility.highlightElement(driver,obj_PortalPage.incidentManagementTotalSRButton()).click();					

			System.out.println("Clicked on "+totalSRButton);


			CommonUtility.highlightElement(driver,(obj_PortalPage.incidentManagementFilterBreadcrumbSRStatus()));
			srBreadcrumb = CommonUtility.highlightElement(driver,obj_PortalPage.incidentManagementFilterBreadcrumbSRStatus()).getText();


			System.out.println("Displayed default breadcrumb "+srBreadcrumb);

			CommonUtility.highlightElement(driver,(obj_PortalPage.incidentManagementStatusValueFirstRow()));
			status = CommonUtility.highlightElement(driver,obj_PortalPage.incidentManagementStatusValueFirstRow()).getText();

			if(status.equalsIgnoreCase("Open"))
			{
				System.out.println("Displayed SRs with status "+status);	

				Report.put("Click on the Service Requests tab to verify the default selected filter when the user lands on the page",
						"The default selected filter should be set for Status filter set to all Open SRs.",
						"Clicked on button"+Report.color(totalSRButton)+"displayed "+Report.color(srBreadcrumb)+"in the breadcrumb"+" with default status "+Report.color(status), "PASS");	
			}
			else
			{
				System.out.println("Failed to Display SR's with Status Open");

				Report.put("Click on the Service Requests tab to verify the default selected filter when the user lands on the page",
						"The default selected filter should be set for Status filter set to all Open SRs.",
						"Failed to Select the Total SRs & display dafault filter as SR Status", "FAIL");
				Assert.fail("Failed to display SRs with Open Status");
			}		
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on the Service Requests tab to verify the default selected filter when the user lands on the page",
					"The default selected filter should be set for Status filter set to all Open SRs.",
					"Failed to Select the Total SRs & display dafault filter as SR Status", "FAIL");
			Assert.fail();
		}
	}

	public void verifyIncidentManagementExpandButton(WebDriver driver)
	{
		System.out.println("Inside verifyIncidentManagementExpandButton method");
		Log.info("Inside verifyIncidentManagementExpandButton method");


		String expandButton = "";

		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);

			CommonUtility.scrollToViewElement(driver,(obj_PortalPage.incidentManagementExpandButton()));
			expandButton = CommonUtility.highlightElement(driver,obj_PortalPage.incidentManagementExpandButton()).getText();

			System.out.println("Displayed Button "+expandButton);

			if(CommonUtility.CheckpresenceofElementLocated(driver, 10, obj_PortalPage.incidentManagementExpandIcon()))
			{
				CommonUtility.highlightElement(driver,obj_PortalPage.incidentManagementExpandIcon());

				Report.put("Verify the icon with label 'Expand' is displayed",
						"The icon with label Expand should be displayed",
						"Displayed button "+Report.color(expandButton)+" with icon", "PASS");
			}
			else				
			{
				Report.put("Verify the icon with label 'Expand' is displayed",
						"The icon with label Expand should be displayed",
						"Failed to displayed the icon with label 'Expand'", "FAIL");
				Assert.fail("Failed to display the icon with label 'Expand'");
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify the icon with label 'Expand' is displayed",
					"The icon with label Expand should be displayed",
					"Failed to display the icon with label 'Expand'", "FAIL");
			Assert.fail();
		}
	}



	public void closeIncidentManagementExpandedViewFilterAndTable(WebDriver driver)
	{
		System.out.println("Inside closeIncidentManagementExpandedViewFilterAndTable method");
		Log.info("Inside closeIncidentManagementExpandedViewFilterAndTable method");

		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);

			CommonUtility.highlightElement(driver,obj_PortalPage.incidentManagementFilterByPopupCloseButton());
			CommonUtility.highlightElement(driver,obj_PortalPage.incidentManagementFilterByPopupCloseButton()).click();

			CommonUtility.scrollToViewElement(driver,(obj_PortalPage.incidentManagementExpandViewCloseButton()));
			CommonUtility.highlightElement(driver,obj_PortalPage.incidentManagementExpandViewCloseButton());
			CommonUtility.highlightElement(driver,obj_PortalPage.incidentManagementExpandViewCloseButton()).click();

			System.out.println("Closed Expanded View");

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.incidentManagementTable()));

			CommonUtility.scrollToViewElement(driver,(obj_PortalPage.incidentManagementTable()));
			CommonUtility.highlightElement(driver,obj_PortalPage.incidentManagementTable());


			Report.put("Close Filter By menu and close the Expanded data table",
					"Data table should go back to non-Expanded view",
					"Closed Filter By menu & closed the expanded table", "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Close Filter By menu and close the Expanded data table",
					"Data table should go back to non-Expanded view",
					"Failed to Close Filter By menu and close the Expanded data table", "FAIL");
			Assert.fail();
		}
	}

	public void applyIncidentManagementExpandedViewFilter(WebDriver driver)
	{
		System.out.println("Inside applyIncidentManagementExpandedViewFilter method");
		Log.info("Inside applyIncidentManagementExpandedViewFilter method");


		String option = "";
		String srHeader = "";
		String srStatusLabel = "";
		String filterBreadcrumb = "";
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);


			if(CommonUtility.highlightElement(driver,obj_PortalPage.incidentManagementFilterByPopupClearAllButton()).isEnabled())
			{
				CommonUtility.highlightElement(driver,obj_PortalPage.incidentManagementFilterByPopupClearAllButton()).click();
				System.out.println("Clicked on Clear All Button in Filter By Popup");
				clickIncidentManagementSummaryViewFilterButton(driver);
			}
			CommonUtility.scrollToViewElement(driver,(obj_PortalPage.incidentManagementExpandViewCloseButton()));
			//	CommonUtility.scrollToViewElement(driver,(obj_PortalPage.incidentManagementFilterByPopupSRStatus()));
			option = CommonUtility.highlightElement(driver,obj_PortalPage.incidentManagementFilterByPopupSRStatus()).getText();

			CommonUtility.highlightElement(driver,obj_PortalPage.incidentManagementFilterByPopupSRStatus()).click();

			System.out.println("Clicked on option "+option);

			CommonUtility.scrollToViewElement(driver,(obj_PortalPage.incidentManagementFilterByPopupSRStatusHeader()));
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.incidentManagementFilterByPopupSRStatusHeader()));

			CommonUtility.highlightElement(driver,obj_PortalPage.incidentManagementFilterByPopupSRStatusHeader());

			srHeader = CommonUtility.highlightElement(driver,obj_PortalPage.incidentManagementFilterByPopupSRStatusHeader()).getText();

			System.out.println("Header is "+srHeader);

			//			CommonUtility.scrollToViewElement(driver,(obj_PortalPage.incidentManagementExpandViewCloseButton()));
			//			CommonUtility.scrollToViewElement(driver,(obj_PortalPage.incidentManagementFilterByPopupSRStatusHeader()));
			CommonUtility.highlightElement(driver,obj_PortalPage.incidentManagementFilterByPopupSRStatusClosedLabel());

			srStatusLabel = CommonUtility.highlightElement(driver,obj_PortalPage.incidentManagementFilterByPopupSRStatusClosedLabel()).getText();

			System.out.println("SR Status Label is "+srStatusLabel);

			CommonUtility.scrollToViewElement(driver,(obj_PortalPage.incidentManagementFilterByPopupSRStatusClosedCheckbox()));

			CommonUtility.ToClickByUsingJavaScript_PassingByLoc(driver,obj_PortalPage.incidentManagementFilterByPopupSRStatusClosedCheckbox());

			CommonUtility.scrollToViewElement(driver,(obj_PortalPage.incidentManagementFilterByPopupApplySelectedButton())).click();

			CommonUtility.scrollToViewElement(driver,(obj_PortalPage.incidentManagementExpandViewCloseButton()));

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.incidentManagementFilterByPopupHeader()));
			CommonUtility.highlightElement(driver,obj_PortalPage.incidentManagementFilterByPopupCloseButton()).click();

			CommonUtility.highlightElement(driver,obj_PortalPage.incidentManagementFilterBreadcrumbSRStatus());
			filterBreadcrumb = CommonUtility.highlightElement(driver,obj_PortalPage.incidentManagementFilterBreadcrumbSRStatus()).getText();

			System.out.println("Filter displayed in breadcrumb "+filterBreadcrumb);

			Report.put("Apply a filter or select a view",
					"The Filter breadcrumbs should be displayed to reflect that the filter or visualization has been applied ",
					"Clicked on filter"+Report.color(option)+"with" + Report.color(srStatusLabel)+".Displayed filter in breadcrumb"+Report.color(filterBreadcrumb), "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();

			Report.put("Apply a filter or select a view",
					"The Filter breadcrumbs should be displayed to reflect that the filter or visualization has been applied ",
					"Failed to Apply the Filter", "FAIL");
			Assert.fail();
		}
	}

	public void verifyIncidentManagementExpandViewColumns(WebDriver driver)
	{
		System.out.println("Inside verifyIncidentManagementExpandViewColumns method");
		Log.info("Inside verifyIncidentManagementExpandViewColumns method");

		
		String expandButton = "";
		String expandHeader = "";
		String columns = "";
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);
			
			CommonUtility.scrollToViewElement(driver,(obj_PortalPage.incidentManagementExpandButton()));
			expandButton = CommonUtility.highlightElement(driver,obj_PortalPage.incidentManagementExpandButton()).getText();
			
			CommonUtility.highlightElement(driver,obj_PortalPage.incidentManagementExpandButton()).click();
								
			System.out.println("Clicked on "+expandButton);

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.incidentManagementExpandHeader()));
		
			CommonUtility.highlightElement(driver,obj_PortalPage.incidentManagementExpandHeader());

			expandHeader = CommonUtility.highlightElement(driver,obj_PortalPage.incidentManagementExpandHeader()).getText();
			
			System.out.println("Header is "+expandHeader);
			
			Thread.sleep(5000);
			
			CommonUtility.scrollToViewElement(driver,(obj_PortalPage.incidentManagementExpandViewColumns()));
			List<WebElement> list=driver.findElements(obj_PortalPage.incidentManagementExpandViewColumns());

			for(WebElement lt:list)
			{
				CommonUtility.scrollToViewElement(driver, lt);
				String colName=lt.getText();
				if(!(colName.isEmpty()))
				{
					System.out.println("Column is: " +colName);
					columns+=" <br> " + colName;
				}
			}
			System.out.println("Columns are:"+columns);
			
			if(CommonUtility.CheckpresenceofElementLocated(driver, 10, obj_PortalPage.incidentManagementExpandViewScrollbar()))
			{
				CommonUtility.highlightElement(driver,obj_PortalPage.incidentManagementExpandViewScrollbar());
				
				Report.put("Click on the icon",
						"A full screen should be displayed  with <List of columns> of the Service Requests listed with a scroll bar",
						"Clicked on icon and displayed columns "+Report.color(columns)+" with scrollbar", "PASS");
			}
			else				
			{
				Report.put("Click on the icon",
						"A full screen should be displayed  with <List of columns> of the Service Requests listed with a scroll bar",
						"Failed to display the columns with the Scrollbar", "FAIL");
				Assert.fail("Failed to display the columns with the Scrollbar");
			}			
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on the icon",
					"A full screen should be displayed  with <List of columns> of the Service Requests listed with a scroll bar",
					"Failed to display the columns with the Scrollbar", "FAIL");
			Assert.fail();
		}
	}

	public void verifyIncidentManagementSRSpecificFilters(WebDriver driver)
	{
		System.out.println("Inside verifyIncidentManagementSRSpecificFilters method");
		Log.info("Inside verifyIncidentManagementSRSpecificFilters method");


		String filterButton = "";
		String filterByHeader = "";
		String srFilterList = "";
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);

			CommonUtility.scrollToViewElement(driver,(obj_PortalPage.incidentManagementSummaryViewFilterButton()));
			filterButton = CommonUtility.highlightElement(driver,obj_PortalPage.incidentManagementSummaryViewFilterButton()).getText();

			CommonUtility.highlightElement(driver,obj_PortalPage.incidentManagementSummaryViewFilterButton()).click();

			System.out.println("Clicked on "+filterButton);

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.incidentManagementFilterByPopupHeader()));

			CommonUtility.highlightElement(driver,obj_PortalPage.incidentManagementFilterByPopupHeader());

			filterByHeader = CommonUtility.highlightElement(driver,obj_PortalPage.incidentManagementFilterByPopupHeader()).getText();

			System.out.println("Header is"+filterByHeader);			

			List<WebElement> list=driver.findElements(obj_PortalPage.incidentManagementFilterValuesList());

			for(WebElement lt:list)
			{
				CommonUtility.highlightElement(driver, lt);
				String filterName=lt.getText();
				if(!(filterName.isEmpty()))
				{
					System.out.println("Filter is: " +filterName);
					srFilterList+=" <br> " + filterName;
				}
			}
			System.out.println("Filters are:"+srFilterList);

			Report.put("Verify the SR specific filters",
					"The following filters should be displayed -Date Range, TLA Flag, Install Base Status, Product Family, Product Name, Site ID, Customer Name, Service Plan Level, Product ID, Product Alias, SR Status including Open, Primary Contact, SR status, Severity",
					"SR specific filters are: "+Report.color(srFilterList), "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();

			Report.put("Verify the SR specific filters",
					"The following filters should be displayed -Date Range, TLA Flag, Install Base Status, Product Family, Product Name, Site ID, Customer Name, Service Plan Level, Product ID, Product Alias, SR Status including Open, Primary Contact, SR status, Severity",
					"Failed to display SR specific filters", "FAIL");
			Assert.fail();
		}
	}

	public void clickIncidentManagementTotalSrsButton(WebDriver driver)
	{
		System.out.println("Inside clickIncidentManagementTotalSrsButton method");
		Log.info("Inside clickIncidentManagementTotalSrsButton method");


		String totalSRButton = "";

		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);

			CommonUtility.highlightElement(driver,(obj_PortalPage.incidentManagementTotalSRButton()));
			totalSRButton = CommonUtility.highlightElement(driver,obj_PortalPage.incidentManagementTotalSRButton()).getText();

			CommonUtility.highlightElement(driver,obj_PortalPage.incidentManagementTotalSRButton()).click();					

			System.out.println("Clicked on "+totalSRButton);			

			Report.put("Click on the Total SRs on the left side",
					"Total SRs should be selected",
					"Clicked on button"+Report.color(totalSRButton), "PASS");	

		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on the Total SRs on the left side",
					"Total SRs should be selected",
					"Failed to Select the Total SRs ", "FAIL");
			Assert.fail();
		}
	}

	public void clickIncidentManagementSiteIdColumnDropdownArrow(WebDriver driver)
	{
		System.out.println("Inside clickIncidentManagementSiteIdColumnDropdownArrow method");
		Log.info("Inside clickIncidentManagementSiteIdColumnDropdownArrow method");


		String srNumber = "";
		String serviceTag = "";
		String status = "";
		
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);

			CommonUtility.scrollToViewElement(driver,(obj_PortalPage.incidentManagementSiteIdDownArrow()));
			CommonUtility.highlightElement(driver,(obj_PortalPage.incidentManagementSiteIdDownArrow())).click();
			
			CommonUtility.highlightElement(driver,obj_PortalPage.incidentManagementExpandedSiteIdSRNumber());
			srNumber = CommonUtility.highlightElement(driver,obj_PortalPage.incidentManagementExpandedSiteIdSRNumber()).getAttribute("innerHTML");

			System.out.println("SR Number is :"+Report.color(srNumber));
			
			CommonUtility.highlightElement(driver,obj_PortalPage.incidentManagementExpandedSiteIdServiceTag());	

			serviceTag = CommonUtility.highlightElement(driver,obj_PortalPage.incidentManagementExpandedSiteIdServiceTag()).getAttribute("innerHTML");

			System.out.println("Service Tag is :"+Report.color(serviceTag));
			
			CommonUtility.highlightElement(driver,obj_PortalPage.incidentManagementExpandedSiteIdStatus());	

			status = CommonUtility.highlightElement(driver,obj_PortalPage.incidentManagementExpandedSiteIdStatus()).getText();

			System.out.println("Status is :"+Report.color(status));
			

			Report.put("User clicks on the drop down arrow at the extreme right under SITE ID column of any SR ",
					"the user should be able to see the following data points at the top - SR Number, PRODUCT ID, Status ",
					"Clicked on drop down arrow under SITE ID column of any SR. The data points at the top are: "+Report.color(srNumber)+Report.color(serviceTag)+Report.color(status), "PASS");	

		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on the Total SRs on the left side",
					"Total SRs should be selected",
					"Failed to Select the Total SRs ", "FAIL");
			Assert.fail();
		}
	}

	public void verifyIncidentManagementSiteIdColumnDataPoints(WebDriver driver)
	{
		System.out.println("Inside verifyIncidentManagementSiteIdColumnDataPoints method");
		Log.info("Inside verifyIncidentManagementSiteIdColumnDataPoints method");

		String dataList = "";	

		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);

			CommonUtility.scrollToViewElement(driver,(obj_PortalPage.incidentManagementExpandedSiteIdDataPoints()));
			List<WebElement> list=driver.findElements(obj_PortalPage.incidentManagementExpandedSiteIdDataPoints());

			for(WebElement lt:list)
			{
				CommonUtility.highlightElement(driver, lt);
				String data=lt.getText();
				if(!(data.isEmpty()))
				{
					System.out.println("Data is: " +data);
					dataList+=" <br> " + data;
				}
			}
			System.out.println("Data Points are: "+dataList);

			Report.put("User verifies that he/she is able to  see the following data points under the same view above , PRODUCT NAME, CREATE/UPDATE DATE, SR TITLE/SUMMARY, SEVERITY, ESCALATION ICON, REQUEST AGE, PRIMARY CONTACT, TECHNICAL SUPPORT OWNER, ACTION OWNER, SR Type, ONSITE SITE with Icons indicating Scheduled/Unscheduled, Site ID, Solution, Part Group, Part Serial Number",
					"The user should be able to see the following data points as expected PRODUCT NAME, CREATE/UPDATE DATE, SR TITLE/SUMMARY, SEVERITY, ESCALATION ICON, REQUEST AGE, PRIMARY CONTACT, TECHNICAL SUPPORT OWNER, ACTION OWNER, SR Type, ONSITE SITE with Icons indicating Scheduled/Unscheduled, Site ID, Solution, Part Group, Part Serial Number",
					"The data points displayed are: "+Report.color(dataList), "PASS");	
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("User verifies that he/she is able to  see the following data points under the same view above , PRODUCT NAME, CREATE/UPDATE DATE, SR TITLE/SUMMARY, SEVERITY, ESCALATION ICON, REQUEST AGE, PRIMARY CONTACT, TECHNICAL SUPPORT OWNER, ACTION OWNER, SR Type, ONSITE SITE with Icons indicating Scheduled/Unscheduled, Site ID, Solution, Part Group, Part Serial Number",
					"The user should be able to see the following data points as expected PRODUCT NAME, CREATE/UPDATE DATE, SR TITLE/SUMMARY, SEVERITY, ESCALATION ICON, REQUEST AGE, PRIMARY CONTACT, TECHNICAL SUPPORT OWNER, ACTION OWNER, SR Type, ONSITE SITE with Icons indicating Scheduled/Unscheduled, Site ID, Solution, Part Group, Part Serial Number",
					"Failed to display the data points as expected ", "FAIL");
			Assert.fail();
		}
	}

	public void verifyIncidentManagementDefaultSelectedFilterExpandedView(WebDriver driver)
	{
		System.out.println("Inside verifyIncidentManagementDefaultSelectedFilterExpandedView method");
		Log.info("Inside verifyIncidentManagementDefaultSelectedFilterExpandedView method");


		String srBreadcrumb = "";
		String status = "";
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);					

			CommonUtility.highlightElement(driver,obj_PortalPage.incidentManagementFilterByPopupCloseButton()).click();

			CommonUtility.highlightElement(driver,(obj_PortalPage.incidentManagementFilterBreadcrumbSRStatus()));
			srBreadcrumb = CommonUtility.highlightElement(driver,obj_PortalPage.incidentManagementFilterBreadcrumbSRStatus()).getText();

			System.out.println("Displayed default breadcrumb "+srBreadcrumb);

			CommonUtility.scrollToViewElement(driver,(obj_PortalPage.incidentManagementStatusValueFirstRow()));
			CommonUtility.highlightElement(driver,(obj_PortalPage.incidentManagementStatusValueFirstRow()));
			status = CommonUtility.highlightElement(driver,obj_PortalPage.incidentManagementStatusValueFirstRow()).getText();

			if(status.equalsIgnoreCase("Open"))
			{
				System.out.println("Displayed SRs with status "+status);	

				Report.put("The user should be able to see default Filters carried from the Normal View ",
						"The default selected filter should be set for Status filter set to all Open SRs.",
						"Displayed "+Report.color(srBreadcrumb)+"in the breadcrumb"+" with default status "+Report.color(status), "PASS");	
			}
			else
			{
				System.out.println("Failed to Display SR's with Status Open");

				Report.put("The user should be able to see default Filters carried from the Normal View ",
						"The default selected filter should be set for Status filter set to all Open SRs.",
						"Failed to Select the Total SRs & display dafault filter as SR Status", "FAIL");
				Assert.fail("Failed to display SRs with Open Status");
			}		
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on the Service Requests tab to verify the default selected filter when the user lands on the page",
					"The default selected filter should be set for Status filter set to all Open SRs.",
					"Failed to Select the Total SRs & display dafault filter as SR Status", "FAIL");
			Assert.fail();
		}
	}

	//Lavanya

	public void ClickOnGraph(WebDriver driver)
	{

		Log.info("ClickOnGraph");	
		WebDriverWait wait = new WebDriverWait(driver, 240);
		String text="";
		String text1="";
		String map="";
		String text2="";
		String defaults="";
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		Actions act=new Actions(driver);
		String value=TestNGCreator.TestData.get(Esupport.Dpid.ordinal());
		try
		{
			//			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.IncidentsManagementTab()));
			if(CommonUtility.CheckpresenceofElementLocated(driver, 50, obj_PortalPage.GraphsButton()))
			{
				CommonUtility.scrollToViewElement(driver,obj_PortalPage.GraphsButton());
				map=CommonUtility.highlightElement(driver,obj_PortalPage.GraphsButton()).getText();
				System.out.println(map);
				CommonUtility.highlightElement(driver,obj_PortalPage.GraphsButton()).click(); 
				driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
				Thread.sleep(10000);
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.ServiceRequestSeverityLevelHeader()));

				text2=CommonUtility.highlightElement(driver,obj_PortalPage.ServiceRequestSeverityLevelHeader()).getText();
				System.out.println("header is "+text2);

				defaults=CommonUtility.highlightElement(driver,obj_PortalPage.SeverityLevelDisplayedInGrapgView()).getText();
				System.out.println("default view displayed is "+defaults);
				List<WebElement> list=driver.findElements(obj_PortalPage.SeverityLevelRangeDisplayedInGraphView());


				for(WebElement lt:list)
				{
					if(value=="ED")
					{

						act.moveToElement(CommonUtility.highlightElement(driver, lt)).build().perform();
						CommonUtility.highlightElement(driver, lt);

					}
					else
					{
						CommonUtility.scrollToViewElement(driver, lt);

						//					act.moveToElement(CommonUtility.highlightElement(driver, lt)).build().perform();
						CommonUtility.highlightElement(driver, lt);
					}

					text=lt.getText();
					text1+=" <br> "+text;
				}
				System.out.println("severity levels displayed are "+text1);

				Report.put("Click on the Graph view and User navigates to Graph View of the Service Requests page & is in context of Total SRs defaulted to Open SRs", 
						"User should be able to see a visualization that depicts the severity of the Total SRs defaulted to Open SRs" ,
						"user able to click on "+Report.color(map)+" and able to see heading of "+Report.color(text2)+" and <br> defaulted with "+Report.color(defaults)+" and <br> display all severity as "+Report.color(text1), "PASS");
			}
			else
			{
				System.out.println("not ble to see graph icon/hyperlink");
				Report.put("Click on the Graph view and User navigates to Graph View of the Service Requests page & is in context of Total SRs defaulted to Open SRs", 
						"User should be able to see a visualization that depicts the severity of the Total SRs defaulted to Open SRs" ,
						"Failed to click on graph", "FAIL");

				Assert.fail();
			}

		}
		catch(Exception e)
		{
			Log.info(e);
			Report.put("Click on the Graph view and User navigates to Graph View of the Service Requests page & is in context of Total SRs defaulted to Open SRs", 
					"User should be able to see a visualization that depicts the severity of the Total SRs defaulted to Open SRs" ,
					"Failed to click on graph", "FAIL");
			e.printStackTrace();
			Assert.fail();
		}

	} 


	public void ValidateDefaultDisplayedGraphView(WebDriver driver)
	{

		Log.info("ValidateDefaultDisplayedGraphView");	
		WebDriverWait wait = new WebDriverWait(driver, 240);
		String text="";
		String text1="";
		String map="";
		String text2="";
		String defaults="";
		String text3="";
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		Actions act=new Actions(driver);
		String value=TestNGCreator.TestData.get(Esupport.Dpid.ordinal());
		try
		{
			//			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.IncidentsManagementTab()));
			if(CommonUtility.CheckpresenceofElementLocated(driver, 50, obj_PortalPage.GraphsButton()))
			{
				CommonUtility.scrollToViewElement(driver,obj_PortalPage.GraphsButton());
				map=CommonUtility.highlightElement(driver,obj_PortalPage.GraphsButton()).getText();
				System.out.println(map);


				text2=CommonUtility.highlightElement(driver,obj_PortalPage.ServiceRequestSeverityLevelHeader()).getText();
				System.out.println("header is "+text2);

				defaults=CommonUtility.highlightElement(driver,obj_PortalPage.SeverityLevelDisplayedInGrapgView()).getText();
				System.out.println("default view displayed is "+defaults);
				List<WebElement> list=driver.findElements(obj_PortalPage.SeverityLevelRangeDisplayedInGraphView());


				for(WebElement lt:list)
				{
					if(value=="ED")
					{

						act.moveToElement(CommonUtility.highlightElement(driver, lt)).build().perform();
						CommonUtility.highlightElement(driver, lt);

					}
					else
					{
						CommonUtility.scrollToViewElement(driver, lt);

						//					act.moveToElement(CommonUtility.highlightElement(driver, lt)).build().perform();
						CommonUtility.highlightElement(driver, lt);
					}

					text=lt.getText();
					text1+=" <br> "+text;
				}
				System.out.println("severity levels displayed are "+text1);


				List<WebElement> list1=driver.findElements(obj_PortalPage.OpenSeverityGraphView());


				for(WebElement lt:list1)
				{
					if(value=="ED")
					{

						act.moveToElement(CommonUtility.highlightElement(driver, lt)).build().perform();
						CommonUtility.highlightElement(driver, lt);

					}
					else
					{
						CommonUtility.scrollToViewElement(driver, lt);

						//					act.moveToElement(CommonUtility.highlightElement(driver, lt)).build().perform();
						CommonUtility.highlightElement(driver, lt);
					}


				}

				List<WebElement> list2=driver.findElements(obj_PortalPage.OpenAndClosedSeverityRequests());


				for(WebElement lt:list2)
				{
					if(value=="ED")
					{

						act.moveToElement(CommonUtility.highlightElement(driver, lt)).build().perform();
						CommonUtility.highlightElement(driver, lt);

					}
					else
					{
						CommonUtility.scrollToViewElement(driver, lt);

						//					act.moveToElement(CommonUtility.highlightElement(driver, lt)).build().perform();
						CommonUtility.highlightElement(driver, lt);
					}
					String text4=lt.getText();

					text3+=" <br> "+text4;
				}

				System.out.println("count of open service requests are "+text3);

				Report.put("User verifies if he's able to differentiate the count of Severity further filtered by status of Open", 
						"User should be able to differentiate the count of Severity further filtered by status of Open ( where the default filter is set to Open)" ,
						"user able to click on "+Report.color(map)+" and able to see heading of "+Report.color(text2)+" and <br> defaulted with "+Report.color(defaults)+" and <br> display all severity as "+Report.color(text1)+" along with total count of SRs"+Report.color(text3)+" <br> along with Graph bars", "PASS");
			}
			else
			{
				System.out.println("not ble to see graph icon/hyperlink");
				Report.put("User verifies if he's able to differentiate the count of Severity further filtered by status of Open", 
						"User should be able to differentiate the count of Severity further filtered by status of Open ( where the default filter is set to Open)" ,
						"Failed to click on graph", "FAIL");

				Assert.fail();
			}

		}
		catch(Exception e)
		{
			Log.info(e);
			Report.put("User verifies if he's able to differentiate the count of Severity further filtered by status of Open", 
					"User should be able to differentiate the count of Severity further filtered by status of Open ( where the default filter is set to Open)" ,
					"Failed to click on graph", "FAIL");
			e.printStackTrace();
			Assert.fail();
		}

	} 


	public void ClickOnAnyOfGraphBarAndValidateForExpandView(WebDriver driver)
	{

		Log.info("ClickOnAnyOfGraphBarAndValidateForExpandView");	
		WebDriverWait wait = new WebDriverWait(driver, 240);
		String displayedvalues="";
		String displayedvalues1="";
		String displayedvalues2="";
		String message="";
		String header="";
		String text3="";
		int count=0;
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		Actions act=new Actions(driver);
		String value=TestNGCreator.TestData.get(Esupport.Dpid.ordinal());
		try
		{
			//			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.IncidentsManagementTab()));
			if(CommonUtility.CheckpresenceofElementLocated(driver, 50, obj_PortalPage.OpenSeverityGraphView()))
			{


				List<WebElement> list3=driver.findElements(obj_PortalPage.OpenSeverityGraphView());


				for(int i=0;i<list3.size();i++)
				{
					if(value=="ED")
					{

						act.moveToElement(CommonUtility.highlightElement(driver, list3.get(i))).build().perform();
						CommonUtility.highlightElement(driver, list3.get(i));

					}
					else
					{
						CommonUtility.scrollToViewElement(driver, list3.get(i));

						//					act.moveToElement(CommonUtility.highlightElement(driver, lt)).build().perform();
						CommonUtility.highlightElement(driver, list3.get(i));
					}

					if(i==0)
					{
						CommonUtility.scrollToViewElement(driver, list3.get(i));

						//						act.moveToElement(CommonUtility.highlightElement(driver, lt)).build().perform();
						CommonUtility.highlightElement(driver, list3.get(i)).click();
					}
				}

				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.HeaderOfThePopUp()));


				CommonUtility.scrollToViewElement(driver,obj_PortalPage.HeaderOfThePopUp());	
				header=CommonUtility.highlightElement(driver,obj_PortalPage.HeaderOfThePopUp()).getText();
				System.out.println("header is "+header);

				if(CommonUtility.CheckpresenceofElementLocated(driver, 15, obj_PortalPage.CountOfRowsDisplayed()))
				{

					List<WebElement> list=driver.findElements(obj_PortalPage.CountOfRowsDisplayed());
					List<WebElement> list1=driver.findElements(obj_PortalPage.RowsDisplayedUnderTable1());
					List<WebElement> list2=driver.findElements(obj_PortalPage.ValuesDisplayedUnderOtherDetailsTable());
					count=list.size();
					System.out.println("count of values displayed are "+count);
					for(WebElement lt:list)
					{
						CommonUtility.highlightElement(driver, lt);
						String tabName=lt.getText();

						System.out.println("Tab is: " +tabName);
						displayedvalues+=" <br> " + tabName;
					}
					System.out.println("Tabs are:"+displayedvalues);


					for(WebElement lt:list1)
					{
						CommonUtility.scrollToViewElement(driver, lt);
						CommonUtility.highlightElement(driver, lt);
						String tabName=lt.getText();

						System.out.println("Tab is: " +tabName);
						displayedvalues1+=" <br> " + tabName;


					}
					System.out.println("Tabs are:"+displayedvalues1);



					for(WebElement lt:list2)
					{
						CommonUtility.highlightElement(driver, lt);
						String tabName=lt.getText();

						System.out.println("Tab is: " +tabName);
						displayedvalues2+=" <br> " + tabName;

					}
					System.out.println("Tabs are:"+displayedvalues2);


				}

				Report.put("User verifies he's able to click on the final view to see an expanded view of the filtered down data", 
						"User should be able to click on the final view to see an expanded view of the filtered down data" ,
						"able to click on graph bar and expanded view displayed with header "+Report.color(header)+" along with filtered data in the grid of count "+count, "PASS");
			}
			else
			{

				Report.put("User verifies he's able to click on the final view to see an expanded view of the filtered down data", 
						"User should be able to click on the final view to see an expanded view of the filtered down data" ,
						"Failed to click on graph bar", "FAIL");

				Assert.fail();
			}

		}
		catch(Exception e)
		{
			Log.info(e);
			Report.put("User verifies he's able to click on the final view to see an expanded view of the filtered down data", 
					"User should be able to click on the final view to see an expanded view of the filtered down data" ,
					"Failed to click on graph bar", "FAIL");
			e.printStackTrace();
			Assert.fail();
		}

	} 

	public void ValidateIfSeverityS4AndS7DisplayIfCountIsNotZero(WebDriver driver)
	{

		Log.info("ValidateIfSeverityS4AndS7DisplayIfCountIsNotZero");	
		WebDriverWait wait = new WebDriverWait(driver, 240);
		String text="";
		String text1="";
		String map="";
		String text2="";
		String defaults="";
		String text3="";
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		Actions act=new Actions(driver);
		String value=TestNGCreator.TestData.get(Esupport.Dpid.ordinal());
		try
		{
			//			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.IncidentsManagementTab()));
			if(CommonUtility.CheckpresenceofElementLocated(driver, 50, obj_PortalPage.SeverityLevelRangeDisplayedInGraphView()))
			{

				List<WebElement> list=driver.findElements(obj_PortalPage.SeverityLevelRangeDisplayedInGraphView());


				for(WebElement lt:list)
				{
					if(value=="ED")
					{

						act.moveToElement(CommonUtility.highlightElement(driver, lt)).build().perform();
						CommonUtility.highlightElement(driver, lt);

					}
					else
					{
						CommonUtility.scrollToViewElement(driver, lt);

						//					act.moveToElement(CommonUtility.highlightElement(driver, lt)).build().perform();
						CommonUtility.highlightElement(driver, lt);
					}

					text=lt.getText();
					text1+=" <br> "+text;
				}
				System.out.println("severity levels displayed are "+text1);


				List<WebElement> list1=driver.findElements(obj_PortalPage.OpenSeverityGraphView());


				for(WebElement lt:list1)
				{
					if(value=="ED")
					{

						act.moveToElement(CommonUtility.highlightElement(driver, lt)).build().perform();
						CommonUtility.highlightElement(driver, lt);

					}
					else
					{
						CommonUtility.scrollToViewElement(driver, lt);

						//					act.moveToElement(CommonUtility.highlightElement(driver, lt)).build().perform();
						CommonUtility.highlightElement(driver, lt);
					}


				}

				List<WebElement> list2=driver.findElements(obj_PortalPage.OpenAndClosedSeverityRequests());


				for(WebElement lt:list2)
				{
					if(value=="ED")
					{

						act.moveToElement(CommonUtility.highlightElement(driver, lt)).build().perform();
						CommonUtility.highlightElement(driver, lt);

					}
					else
					{
						CommonUtility.scrollToViewElement(driver, lt);

						//					act.moveToElement(CommonUtility.highlightElement(driver, lt)).build().perform();
						CommonUtility.highlightElement(driver, lt);
					}
					String text4=lt.getText();

					text3+=" <br> "+text4;
				}

				System.out.println("count of open service requests are "+text3);

				if(text3=="0")
				{
					if(text1.contains("Severity 4")||text1.contains("Severity 7"))
					{
						System.out.println("count is zero but still display Severity 4 or Severity 7");
						Report.put("User verifies SRs of Severity S4 and S7 is reflecting only if the count is not zero", 
								"User should see SRs of Severity S4 and S7 only if the count is not zero" ,
								"able to see Severity 4 or Severity 7 even though count is zero", "FAIL");

						Assert.fail();
					}

				}

				Report.put("User verifies SRs of Severity S4 and S7 is reflecting only if the count is not zero", 
						"User should see SRs of Severity S4 and S7 only if the count is not zero" ,
						"user able to see severity level 4 and 7 only if count is not zero as below <br> "+Report.color(text1+" count of "+text3), "PASS");
			}
			else
			{
				System.out.println("not ble to see graph icon/hyperlink");
				Report.put("User verifies SRs of Severity S4 and S7 is reflecting only if the count is not zero", 
						"User should see SRs of Severity S4 and S7 only if the count is not zero" ,
						"Failed to see severity levels in graph view", "FAIL");

				Assert.fail();
			}

		}
		catch(Exception e)
		{
			Log.info(e);
			Report.put("User verifies SRs of Severity S4 and S7 is reflecting only if the count is not zero", 
					"User should see SRs of Severity S4 and S7 only if the count is not zero" ,
					"Failed to see severity levels in graph view", "FAIL");
			e.printStackTrace();
			Assert.fail();
		}

	} 

	public void ClickOnFilterAndApplyAnyFilterAndValidateSameFiltersAppliedToTabularAndMapView(WebDriver driver)
	{

		Log.info("ClickOnFilterAndApplyAnyFilterAndValidateSameFiltersAppliedToTabularAndMapView");	
		WebDriverWait wait = new WebDriverWait(driver, 240);
		String text="";
		String text1="";
		String map="";
		String text2="";
		String defaults="";
		String text3="";
		String text4="";
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		Actions act=new Actions(driver);
		String value=TestNGCreator.TestData.get(Esupport.Dpid.ordinal());
		try
		{
			//			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.IncidentsManagementTab()));
			if(CommonUtility.CheckpresenceofElementLocated(driver, 50, obj_PortalPage.FilterButton()))
			{
				CommonUtility.scrollToViewElement(driver,obj_PortalPage.FilterButton());
				map=CommonUtility.highlightElement(driver,obj_PortalPage.FilterButton()).getText();
				System.out.println(map);
				CommonUtility.highlightElement(driver,obj_PortalPage.FilterButton()).click(); 
				driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
				Thread.sleep(5000);
				driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
				//				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.ProductNameInFiltersWindow()));
				CommonUtility.scrollToViewElement(driver,obj_PortalPage.ProductNameInFiltersWindow());
				text2=CommonUtility.highlightElement(driver,obj_PortalPage.ProductNameInFiltersWindow()).getText();
				System.out.println("Filter is "+text2);
				CommonUtility.highlightElement(driver,obj_PortalPage.ProductNameInFiltersWindow()).click();
				Thread.sleep(5000);
				driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
				CommonUtility.scrollToViewElement(driver,obj_PortalPage.AppSyncOptionUnderProductNameInFilterWindow());
				defaults=CommonUtility.highlightElement(driver,obj_PortalPage.AppSyncOptionUnderProductNameInFilterWindow()).getText();
				System.out.println("sub filter selected  is "+defaults);

				CommonUtility.highlightElement(driver,obj_PortalPage.AppSyncOptionUnderProductNameInFilterWindow()).click();

				CommonUtility.scrollToViewElement(driver,obj_PortalPage.ApplySelectedInFilterWindow());
				text3=CommonUtility.highlightElement(driver,obj_PortalPage.ApplySelectedInFilterWindow()).getText();
				System.out.println("text is "+text3);

				CommonUtility.highlightElement(driver,obj_PortalPage.ApplySelectedInFilterWindow()).click();
				CommonUtility.scrollToViewElement(driver,obj_PortalPage.XButtonOnFilterWindow());
				CommonUtility.highlightElement(driver,obj_PortalPage.XButtonOnFilterWindow()).click();

				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.SeverityLevelRangeDisplayedInGraphView()));
				List<WebElement> list=driver.findElements(obj_PortalPage.SeverityLevelRangeDisplayedInGraphView());


				for(WebElement lt:list)
				{
					if(value=="ED")
					{

						act.moveToElement(CommonUtility.highlightElement(driver, lt)).build().perform();
						CommonUtility.highlightElement(driver, lt);

					}
					else
					{
						CommonUtility.scrollToViewElement(driver, lt);

						//					act.moveToElement(CommonUtility.highlightElement(driver, lt)).build().perform();
						CommonUtility.highlightElement(driver, lt);
					}

					text=lt.getText();
					text1+=" <br> "+text;
				}
				System.out.println("severity levels displayed are "+text1);

				List<WebElement> list1=driver.findElements(obj_PortalPage.BreadScrumbsOnGraphView());


				for(WebElement lt:list1)
				{
					if(value=="ED")
					{

						act.moveToElement(CommonUtility.highlightElement(driver, lt)).build().perform();
						CommonUtility.highlightElement(driver, lt);

					}
					else
					{
						CommonUtility.scrollToViewElement(driver, lt);

						//					act.moveToElement(CommonUtility.highlightElement(driver, lt)).build().perform();
						CommonUtility.highlightElement(driver, lt);
					}

					text=lt.getText();
					text4+=" <br> "+text;
				}
				System.out.println("Breadscrumbs are "+text4);


				ClickOnTabularViewAndCheckBreadScrumbAndClickBackToGraphView(driver);
				ClickOnMapViewAndCheckBreadScrumbAndClickBackToGraphView(driver);

				Report.put("User verifies to apply filters on the visualizations", 
						"User should be able to apply filters on the visualizations and the same filters should get applied to the tabular and geo-views too" ,
						"user able to click on "+Report.color(map)+" and able to see "+Report.color(text2)+" and <br> sub filter "+Report.color(defaults)+" and after clicking "+Report.color(text3)+"<br> user able to see filters as "+Report.color(text1)+" <br> with breadscrumbs as "+Report.color(text4), "PASS");
			}
			else
			{
				System.out.println("not ble to see filter button or it is disabled");
				Report.put("User verifies to apply filters on the visualizations", 
						"User should be able to apply filters on the visualizations and the same filters should get applied to the tabular and geo-views too" ,
						"Failed to click on Filter button", "FAIL");

				Assert.fail();
			}

		}
		catch(Exception e)
		{
			Log.info(e);
			Report.put("User verifies to apply filters on the visualizations", 
					"User should be able to apply filters on the visualizations and the same filters should get applied to the tabular and geo-views too" ,
					"Failed to click on Filter button", "FAIL");
			e.printStackTrace();
			Assert.fail();
		}

	} 


	public void ClickOnXButtonOfSRStatusInBreadScrumbAndValidateGraphView(WebDriver driver)
	{

		Log.info("ClickOnXButtonOfSRStatusInBreadScrumbAndValidateGraphView");	
		WebDriverWait wait = new WebDriverWait(driver, 240);
		String text="";
		String text1="";
		String map="";
		String text2="";
		String defaults="";
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		Actions act=new Actions(driver);
		String value=TestNGCreator.TestData.get(Esupport.Dpid.ordinal());
		try
		{
			//			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.IncidentsManagementTab()));
			if(CommonUtility.CheckpresenceofElementLocated(driver, 50, obj_PortalPage.XButtonToCloseBreadscrumFilter()))
			{
				CommonUtility.scrollToViewElement(driver,obj_PortalPage.XButtonToCloseBreadscrumFilter());

				CommonUtility.highlightElement(driver,obj_PortalPage.XButtonToCloseBreadscrumFilter()).click(); 
				driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
				Thread.sleep(10000);
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.BreadScrumbsOnGraphView()));


				List<WebElement> list=driver.findElements(obj_PortalPage.BreadScrumbsOnGraphView());


				for(WebElement lt:list)
				{
					if(value=="ED")
					{

						act.moveToElement(CommonUtility.highlightElement(driver, lt)).build().perform();
						CommonUtility.highlightElement(driver, lt);

					}
					else
					{
						CommonUtility.scrollToViewElement(driver, lt);

						//					act.moveToElement(CommonUtility.highlightElement(driver, lt)).build().perform();
						CommonUtility.highlightElement(driver, lt);
					}

					text=lt.getText();
					text1+=" <br> "+text;
				}
				System.out.println("Breadscrumbs are "+text1);

				if(text1.contains("SR Status"))
				{
					System.out.println("SR Status not removed from breadscrumb");
					Report.put("User is in Graph view of Total SRs & default Open SRs filter is applied and user clicks on the X mark on the Open SRs/Status breadcrumb", 
							"Status breadcrumb should get removed & the visualization graph gets refreshed." ,
							"Failed to X mark of SR Status filter under breadscrumb", "FAIL");

					Assert.fail();
				}

				Report.put("User is in Graph view of Total SRs & default Open SRs filter is applied and user clicks on the X mark on the Open SRs/Status breadcrumb", 
						"Status breadcrumb should get removed & the visualization graph gets refreshed." ,
						"user able to click on X mark and able to see Bread scrumb SR Status removed from bread scrumb and <br> Filters displayed under Breadscrumb after removal of SR status Filter are  "+Report.color(text1), "PASS");
			}
			else
			{
				System.out.println("X button not displayed under breadscrumb of SR Status");
				Report.put("User is in Graph view of Total SRs & default Open SRs filter is applied and user clicks on the X mark on the Open SRs/Status breadcrumb", 
						"Status breadcrumb should get removed & the visualization graph gets refreshed." ,
						"Failed to click X mark of SR Status filter under breadscrumb", "FAIL");

				Assert.fail();
			}

		}
		catch(Exception e)
		{
			Log.info(e);
			Report.put("User is in Graph view of Total SRs & default Open SRs filter is applied and user clicks on the X mark on the Open SRs/Status breadcrumb", 
					"Status breadcrumb should get removed & the visualization graph gets refreshed." ,
					"Failed to click X mark of SR Status filter under breadscrumb", "FAIL");
			e.printStackTrace();
			Assert.fail();
		}

	} 


	public void ValidateGraphViewAfterRemovalOfSRStatusFilter(WebDriver driver)
	{

		Log.info("ValidateGraphViewAfterRemovalOfSRStatusFilter");	
		WebDriverWait wait = new WebDriverWait(driver, 240);
		String text="";
		String text1="";
		String map="";
		String text2="";
		String defaults="";
		String text3="";
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		Actions act=new Actions(driver);
		String value=TestNGCreator.TestData.get(Esupport.Dpid.ordinal());
		try
		{
			//			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.IncidentsManagementTab()));
			if(CommonUtility.CheckpresenceofElementLocated(driver, 50, obj_PortalPage.ServiceRequestSeverityLevelHeader()))
			{
				text2=CommonUtility.highlightElement(driver,obj_PortalPage.ServiceRequestSeverityLevelHeader()).getText();
				System.out.println("header is "+text2);
				List<WebElement> list3=driver.findElements(obj_PortalPage.SeverityLevelDisplayedInGrapgView());
				for(WebElement lt:list3)
				{
					CommonUtility.highlightElement(driver, lt);
					String text5=lt.getText();
					defaults+=" <br> "+text5;
				}

				System.out.println("default view displayed now are "+defaults);
				List<WebElement> list=driver.findElements(obj_PortalPage.SeverityLevelRangeDisplayedInGraphView());


				for(WebElement lt:list)
				{
					if(value=="ED")
					{

						act.moveToElement(CommonUtility.highlightElement(driver, lt)).build().perform();
						CommonUtility.highlightElement(driver, lt);

					}
					else
					{
						CommonUtility.scrollToViewElement(driver, lt);

						//					act.moveToElement(CommonUtility.highlightElement(driver, lt)).build().perform();
						CommonUtility.highlightElement(driver, lt);
					}

					text=lt.getText();
					text1+=" <br> "+text;
				}
				System.out.println("severity levels displayed are "+text1);


				List<WebElement> list1=driver.findElements(obj_PortalPage.OpenSeverityGraphView());


				for(WebElement lt:list1)
				{
					if(value=="ED")
					{

						act.moveToElement(CommonUtility.highlightElement(driver, lt)).build().perform();
						CommonUtility.highlightElement(driver, lt);

					}
					else
					{
						CommonUtility.scrollToViewElement(driver, lt);

						//					act.moveToElement(CommonUtility.highlightElement(driver, lt)).build().perform();
						CommonUtility.highlightElement(driver, lt);
					}


				}

				List<WebElement> list2=driver.findElements(obj_PortalPage.OpenAndClosedSeverityRequests());


				for(WebElement lt:list2)
				{
					if(value=="ED")
					{

						act.moveToElement(CommonUtility.highlightElement(driver, lt)).build().perform();
						CommonUtility.highlightElement(driver, lt);

					}
					else
					{
						CommonUtility.scrollToViewElement(driver, lt);

						//					act.moveToElement(CommonUtility.highlightElement(driver, lt)).build().perform();
						CommonUtility.highlightElement(driver, lt);
					}
					String text4=lt.getText();

					text3+=" <br> "+text4;
				}

				System.out.println("count of open and closed service requests are "+text3);

				Report.put("User is  in graph view of Total SRs & default status filter is removed", 
						"The bar graphs displayed for Open/Closed SRs and grouped by severity should be comparative in terms of display." ,
						"user able see heading of "+Report.color(text2)+" and <br> display both "+Report.color(defaults)+" and <br> display all severity as "+Report.color(text1)+" along with total count of SRs Open and Closed "+Report.color(text3)+" <br> along with Graph bars respectively", "PASS");
			}
			else
			{
				System.out.println("not able to see graph view");
				Report.put("User is  in graph view of Total SRs & default status filter is removed", 
						"The bar graphs displayed for Open/Closed SRs and grouped by severity should be comparative in terms of display." ,
						"Failed to see bars in graph view", "FAIL");

				Assert.fail();
			}

		}
		catch(Exception e)
		{
			Log.info(e);
			Report.put("User is  in graph view of Total SRs & default status filter is removed", 
					"The bar graphs displayed for Open/Closed SRs and grouped by severity should be comparative in terms of display." ,
					"Failed to see bars in graph view", "FAIL");
			e.printStackTrace();
			Assert.fail();
		}

	} 

	public void ClickOnTabularViewAndCheckBreadScrumbAndClickBackToGraphView(WebDriver driver)
	{

		Log.info("ClickOnTabularViewAndCheckBreadScrumbAndClickBackToGraphView");	
		WebDriverWait wait = new WebDriverWait(driver, 240);
		String text="";
		String text1="";
		String map="";
		String text2="";
		String defaults="";
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		Actions act=new Actions(driver);
		String value=TestNGCreator.TestData.get(Esupport.Dpid.ordinal());
		String value2=TestNGCreator.TestData.get(Esupport.SearchOption.ordinal());
		try
		{
			Thread.sleep(5000);
			CommonUtility.scrollToViewElement(driver,obj_PortalPage.ClickOnTabularView());
			//			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.IncidentsManagementTab()));
			if(CommonUtility.CheckpresenceofElementLocated(driver, 10, obj_PortalPage.ClickOnTabularView()))
			{
				CommonUtility.scrollToViewElement(driver,obj_PortalPage.ClickOnTabularView());
				map=CommonUtility.highlightElement(driver,obj_PortalPage.ClickOnTabularView()).getText();
				System.out.println(map);
				CommonUtility.highlightElement(driver,obj_PortalPage.ClickOnTabularView()).click(); 
				driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
				Thread.sleep(10000);
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.BreadScrumbsOnGraphView()));


				List<WebElement> list=driver.findElements(obj_PortalPage.BreadScrumbsOnGraphView());


				for(WebElement lt:list)
				{
					if(value=="ED")
					{

						act.moveToElement(CommonUtility.highlightElement(driver, lt)).build().perform();
						CommonUtility.highlightElement(driver, lt);

					}
					else
					{
						CommonUtility.scrollToViewElement(driver, lt);

						//					act.moveToElement(CommonUtility.highlightElement(driver, lt)).build().perform();
						CommonUtility.highlightElement(driver, lt);
					}

					text=lt.getText();
					text1+=" <br> "+text;
				}
				System.out.println("breadscrumbs displayed are "+text1);

				if(!(text1.contains(value2)))
				{
					System.out.println("not ble to see expected filter in breadscrumb");
					Report.put("User verifies to apply filters on the visualizations ", 
							"User should be able to apply filters on the visualizations and the same filters should get applied to the tabular and geo-views too" ,
							"Failed to see filter"+value2+" in breadscrumb in tabular view", "FAIL");

					Assert.fail();
				}

				Report.put("User verifies to apply filters on the visualizations ", 
						"User should be able to apply filters on the visualizations and the same filters should get applied to the tabular and geo-views too" ,
						"user able to click on "+Report.color(map)+" and able to see breadscrumb as "+Report.color(text1), "PASS");
			}
			else
			{
				System.out.println("not able to see tabular icon/hyperlink");
				Report.put("User verifies to apply filters on the visualizations ", 
						"User should be able to apply filters on the visualizations and the same filters should get applied to the tabular and geo-views too" ,
						"Failed to click on tabular link", "FAIL");

				Assert.fail();
			}

		}
		catch(Exception e)
		{
			Log.info(e);
			Report.put("User verifies to apply filters on the visualizations ", 
					"User should be able to apply filters on the visualizations and the same filters should get applied to the tabular and geo-views too" ,
					"Failed to click on tabular link", "FAIL");
			e.printStackTrace();
			Assert.fail();
		}

	} 

	public void ClickOnMapViewAndCheckBreadScrumbAndClickBackToGraphView(WebDriver driver)
	{

		Log.info("ClickOnMapViewAndCheckBreadScrumbAndClickBackToGraphView");	
		WebDriverWait wait = new WebDriverWait(driver, 240);
		String text="";
		String text1="";
		String map="";
		String text2="";
		String defaults="";
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		Actions act=new Actions(driver);
		String value=TestNGCreator.TestData.get(Esupport.Dpid.ordinal());
		String value2=TestNGCreator.TestData.get(Esupport.SearchOption.ordinal());
		try
		{
			Thread.sleep(5000);
			CommonUtility.scrollToViewElement(driver,obj_PortalPage.MapButtonUnderIncidentManagementTab());
			//			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.IncidentsManagementTab()));
			if(CommonUtility.CheckpresenceofElementLocated(driver, 10, obj_PortalPage.MapButtonUnderIncidentManagementTab()))
			{
				CommonUtility.scrollToViewElement(driver,obj_PortalPage.MapButtonUnderIncidentManagementTab());
				map=CommonUtility.highlightElement(driver,obj_PortalPage.MapButtonUnderIncidentManagementTab()).getText();
				System.out.println(map);
				CommonUtility.highlightElement(driver,obj_PortalPage.MapButtonUnderIncidentManagementTab()).click(); 
				driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
				Thread.sleep(10000);
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.BreadScrumbsOnGraphView()));


				List<WebElement> list=driver.findElements(obj_PortalPage.BreadScrumbsOnGraphView());


				for(WebElement lt:list)
				{
					if(value=="ED")
					{

						act.moveToElement(CommonUtility.highlightElement(driver, lt)).build().perform();
						CommonUtility.highlightElement(driver, lt);

					}
					else
					{
						CommonUtility.scrollToViewElement(driver, lt);

						//					act.moveToElement(CommonUtility.highlightElement(driver, lt)).build().perform();
						CommonUtility.highlightElement(driver, lt);
					}

					text=lt.getText();
					text1+=" <br> "+text;
				}
				System.out.println("breadscrumb displayed are "+text1);

				if(!(text1.contains(value2)))
				{
					System.out.println("not able to see product name in breadscrumb in map view");
					Report.put("User verifies to apply filters on the visualizations ", 
							"User should be able to apply filters on the visualizations and the same filters should get applied to the tabular and geo-views too" ,
							"Failed to see filter"+Report.color(value2)+" in breadscrumb in map view", "FAIL");

					Assert.fail();
				}

				Report.put("User verifies to apply filters on the visualizations ", 
						"User should be able to apply filters on the visualizations and the same filters should get applied to the tabular and geo-views too" ,
						"user able to click on "+Report.color(map)+" and able to see breadscrumb as "+Report.color(text1), "PASS");
			}
			else
			{
				System.out.println("not able to see map icon/hyperlink");
				Report.put("User verifies to apply filters on the visualizations ", 
						"User should be able to apply filters on the visualizations and the same filters should get applied to the tabular and geo-views too" ,
						"Failed to click on map link", "FAIL");

				Assert.fail();
			}

		}
		catch(Exception e)
		{
			Log.info(e);
			Report.put("User verifies to apply filters on the visualizations ", 
					"User should be able to apply filters on the visualizations and the same filters should get applied to the tabular and geo-views too" ,
					"Failed to click on map link", "FAIL");
			e.printStackTrace();
			Assert.fail();
		}

	} 


	public void ClickOnEscalations(WebDriver driver)
	{

		Log.info("ClickOnEscalations");	
		WebDriverWait wait = new WebDriverWait(driver, 240);
		String text="";
		String text1="";
		String map="";
		String text2="";
		String defaults="";
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		Actions act=new Actions(driver);
		String value=TestNGCreator.TestData.get(Esupport.Dpid.ordinal());
		try
		{
			//			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.IncidentsManagementTab()));
			if(CommonUtility.CheckpresenceofElementLocated(driver, 50, obj_PortalPage.EscalationsTabOnLeftMenu()))
			{
				CommonUtility.scrollToViewElement(driver,obj_PortalPage.EscalationsTabOnLeftMenu());
				map=CommonUtility.highlightElement(driver,obj_PortalPage.EscalationsTabOnLeftMenu()).getText();
				System.out.println(map);
				CommonUtility.highlightElement(driver,obj_PortalPage.EscalationsTabOnLeftMenu()).click(); 
				driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
				Thread.sleep(10000);
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.OpenEscalationsOnTabularView()));


				List<WebElement> list=driver.findElements(obj_PortalPage.OpenEscalationsOnTabularView());


				for(WebElement lt:list)
				{
					if(value=="ED")
					{

						act.moveToElement(CommonUtility.highlightElement(driver, lt)).build().perform();
						CommonUtility.highlightElement(driver, lt);

					}
					else
					{
						CommonUtility.scrollToViewElement(driver, lt);

						//					act.moveToElement(CommonUtility.highlightElement(driver, lt)).build().perform();
						CommonUtility.highlightElement(driver, lt);
					}


				}


				Report.put("User navigates to Escalation ", 
						"User should be able to see Open escalations by default" ,
						"User navigates to "+Report.color(map)+" and abl to see only open escalations displayed by default", "PASS");
			}
			else
			{
				System.out.println("not ble to see escalations in left menu");
				Report.put("User navigates to Escalation ", 
						"User should be able to see Open escalations by default" ,
						"Failed to click on escalations", "FAIL");

				Assert.fail();
			}

		}
		catch(Exception e)
		{
			Log.info(e);
			Report.put("User navigates to Escalation ", 
					"User should be able to see Open escalations by default" ,
					"Failed to click on escalations", "FAIL");
			e.printStackTrace();
			Assert.fail();
		}

	} 

	public void ClickOnGraphViewInTheEscalationsContext(WebDriver driver)
	{

		Log.info("ClickOnGraphViewInTheEscalationsContext");	
		WebDriverWait wait = new WebDriverWait(driver, 240);
		String text="";
		String text1="";
		String map="";
		String text2="";
		String defaults="";
		String text3="";
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		Actions act=new Actions(driver);
		String value=TestNGCreator.TestData.get(Esupport.Dpid.ordinal());
		try
		{
			//			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.IncidentsManagementTab()));
			if(CommonUtility.CheckpresenceofElementLocated(driver, 50, obj_PortalPage.GraphsButton()))
			{
				CommonUtility.scrollToViewElement(driver,obj_PortalPage.GraphsButton());
				map=CommonUtility.highlightElement(driver,obj_PortalPage.GraphsButton()).getText();
				System.out.println(map);
				CommonUtility.highlightElement(driver,obj_PortalPage.GraphsButton()).click(); 
				driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
				Thread.sleep(10000);
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.ServiceRequestSeverityLevelHeader()));

				text2=CommonUtility.highlightElement(driver,obj_PortalPage.ServiceRequestSeverityLevelHeader()).getText();
				System.out.println("header is "+text2);

				defaults=CommonUtility.highlightElement(driver,obj_PortalPage.TypeOfEscalationsDisplayed()).getText();
				System.out.println("default view displayed is "+defaults);

				CommonUtility.scrollToViewElement(driver,obj_PortalPage.OpenEscalationsGraphBar());

				CommonUtility.highlightElement(driver,obj_PortalPage.OpenEscalationsGraphBar());

				List<WebElement> list=driver.findElements(obj_PortalPage.CountOfOpenEscalationsInGraphView());


				for(WebElement lt:list)
				{
					if(value=="ED")
					{

						act.moveToElement(CommonUtility.highlightElement(driver, lt)).build().perform();
						CommonUtility.highlightElement(driver, lt);

					}
					else
					{
						CommonUtility.scrollToViewElement(driver, lt);

						//					act.moveToElement(CommonUtility.highlightElement(driver, lt)).build().perform();
						CommonUtility.highlightElement(driver, lt);
					}

					text=lt.getText();
					text1+=" <br> "+text;
				}
				System.out.println("count of open escalations displayed "+text1);

				Report.put("User navigates to Graphs in the Escalation context view ", 
						"User should be able to see a visualization that depicts the escalations of the Total SRs defaulted to Open SRs" ,
						"user able to click on "+Report.color(map)+" and able to see heading of "+Report.color(text2)+" and <br> defaulted with "+Report.color(defaults)+" and <br> display escalations bar with total count as "+Report.color(text1), "PASS");
			}
			else
			{
				System.out.println("not ble to see graph icon/hyperlink");
				Report.put("User navigates to Graphs in the Escalation context view ", 
						"User should be able to see a visualization that depicts the escalations of the Total SRs defaulted to Open SRs" ,
						"Failed to click on graph", "FAIL");

				Assert.fail();
			}

		}
		catch(Exception e)
		{
			Log.info(e);
			Report.put("User navigates to Graphs in the Escalation context view ", 
					"User should be able to see a visualization that depicts the escalations of the Total SRs defaulted to Open SRs" ,
					"Failed to click on graph", "FAIL");
			e.printStackTrace();
			Assert.fail();
		}

	} 


	public void ClickOnFilterAndApplyAnyFilterAndValidateSameFiltersAppliedToTabularAndMapViewInTheEscalationsContext(WebDriver driver)
	{

		Log.info("ClickOnFilterAndApplyAnyFilterAndValidateSameFiltersAppliedToTabularAndMapViewInTheEscalationsContext");	
		WebDriverWait wait = new WebDriverWait(driver, 240);
		String text="";
		String text1="";
		String map="";
		String text2="";
		String defaults="";
		String text3="";
		String text4="";
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		Actions act=new Actions(driver);
		String value=TestNGCreator.TestData.get(Esupport.Dpid.ordinal());
		try
		{
			//			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.IncidentsManagementTab()));
			if(CommonUtility.CheckpresenceofElementLocated(driver, 50, obj_PortalPage.FilterButton()))
			{
				CommonUtility.scrollToViewElement(driver,obj_PortalPage.FilterButton());
				map=CommonUtility.highlightElement(driver,obj_PortalPage.FilterButton()).getText();
				System.out.println(map);
				CommonUtility.highlightElement(driver,obj_PortalPage.FilterButton()).click(); 
				driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
				Thread.sleep(5000);
				driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
				//				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.ProductNameInFiltersWindow()));
				CommonUtility.scrollToViewElement(driver,obj_PortalPage.ProductNameInFiltersWindow());
				text2=CommonUtility.highlightElement(driver,obj_PortalPage.ProductNameInFiltersWindow()).getText();
				System.out.println("Filter is "+text2);
				CommonUtility.highlightElement(driver,obj_PortalPage.ProductNameInFiltersWindow()).click();
				Thread.sleep(5000);
				driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
				CommonUtility.scrollToViewElement(driver,obj_PortalPage.AvamarDataStoreGen4SProductNameSubFilterWindow());
				defaults=CommonUtility.highlightElement(driver,obj_PortalPage.AvamarDataStoreGen4SProductNameSubFilterWindow()).getText();
				System.out.println("sub filter selected  is "+defaults);

				CommonUtility.highlightElement(driver,obj_PortalPage.AvamarDataStoreGen4SProductNameSubFilterWindow()).click();

				CommonUtility.scrollToViewElement(driver,obj_PortalPage.ApplySelectedInFilterWindow());
				text3=CommonUtility.highlightElement(driver,obj_PortalPage.ApplySelectedInFilterWindow()).getText();
				System.out.println("text is "+text3);

				CommonUtility.highlightElement(driver,obj_PortalPage.ApplySelectedInFilterWindow()).click();
				CommonUtility.scrollToViewElement(driver,obj_PortalPage.XButtonOnFilterWindow());
				CommonUtility.highlightElement(driver,obj_PortalPage.XButtonOnFilterWindow()).click();

				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.OpenEscalationsGraphBar()));
				CommonUtility.scrollToViewElement(driver,obj_PortalPage.OpenEscalationsGraphBar());

				CommonUtility.highlightElement(driver,obj_PortalPage.OpenEscalationsGraphBar());

				List<WebElement> list=driver.findElements(obj_PortalPage.CountOfOpenEscalationsInGraphView());


				for(WebElement lt:list)
				{
					if(value=="ED")
					{

						act.moveToElement(CommonUtility.highlightElement(driver, lt)).build().perform();
						CommonUtility.highlightElement(driver, lt);

					}
					else
					{
						CommonUtility.scrollToViewElement(driver, lt);

						//					act.moveToElement(CommonUtility.highlightElement(driver, lt)).build().perform();
						CommonUtility.highlightElement(driver, lt);
					}

					text=lt.getText();
					text1+=" <br> "+text;
				}
				System.out.println("count of open escalations displayed "+text1);

				List<WebElement> list1=driver.findElements(obj_PortalPage.BreadScrumbsOnGraphView());


				for(WebElement lt:list1)
				{
					if(value=="ED")
					{

						act.moveToElement(CommonUtility.highlightElement(driver, lt)).build().perform();
						CommonUtility.highlightElement(driver, lt);

					}
					else
					{
						CommonUtility.scrollToViewElement(driver, lt);

						//					act.moveToElement(CommonUtility.highlightElement(driver, lt)).build().perform();
						CommonUtility.highlightElement(driver, lt);
					}

					text=lt.getText();
					text4+=" <br> "+text;
				}
				System.out.println("Breadscrumbs are "+text4);

				ClickOnTabularViewAndCheckBreadScrumbAndClickBackToGraphView(driver);
				ClickOnMapViewAndCheckBreadScrumbAndClickBackToGraphView(driver);

				Report.put("User verifies to apply filters on the visualizations", 
						"User should be able to apply filters on the visualizations and the same filters should get applied to the tabular and geo-views too" ,
						"user able to click on "+Report.color(map)+" and able to see "+Report.color(text2)+" and <br> sub filter "+Report.color(defaults)+" and after clicking "+Report.color(text3)+"<br> user able to see filters as "+Report.color(text1)+" <br> with breadscrumbs as "+Report.color(text4), "PASS");
			}
			else
			{
				System.out.println("not ble to see filter button or it is disabled");
				Report.put("User verifies to apply filters on the visualizations", 
						"User should be able to apply filters on the visualizations and the same filters should get applied to the tabular and geo-views too" ,
						"Failed to click on Filter button", "FAIL");

				Assert.fail();
			}

		}
		catch(Exception e)
		{
			Log.info(e);
			Report.put("User verifies to apply filters on the visualizations", 
					"User should be able to apply filters on the visualizations and the same filters should get applied to the tabular and geo-views too" ,
					"Failed to click on Filter button", "FAIL");
			e.printStackTrace();
			Assert.fail();
		}

	} 

	public void ClickOnXButtonOfProductNameInBreadScrumbAndValidateGraphView(WebDriver driver)
	{

		Log.info("ClickOnXButtonOfProductNameInBreadScrumbAndValidateGraphView");	
		WebDriverWait wait = new WebDriverWait(driver, 240);
		String text="";
		String text1="";
		String map="";
		String text2="";
		String text4="";
		String defaults="";
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		Actions act=new Actions(driver);
		String value=TestNGCreator.TestData.get(Esupport.Dpid.ordinal());
		try
		{
			//			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.IncidentsManagementTab()));
			if(CommonUtility.CheckpresenceofElementLocated(driver, 50, obj_PortalPage.XButtonOnBreadScrumbForProductName()))
			{
				CommonUtility.scrollToViewElement(driver,obj_PortalPage.XButtonOnBreadScrumbForProductName());

				CommonUtility.highlightElement(driver,obj_PortalPage.XButtonOnBreadScrumbForProductName()).click(); 
				driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
				Thread.sleep(10000);
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.BreadScrumbsOnGraphView()));


				List<WebElement> list=driver.findElements(obj_PortalPage.BreadScrumbsOnGraphView());


				for(WebElement lt:list)
				{
					if(value=="ED")
					{

						act.moveToElement(CommonUtility.highlightElement(driver, lt)).build().perform();
						CommonUtility.highlightElement(driver, lt);

					}
					else
					{
						CommonUtility.scrollToViewElement(driver, lt);

						//					act.moveToElement(CommonUtility.highlightElement(driver, lt)).build().perform();
						CommonUtility.highlightElement(driver, lt);
					}

					text=lt.getText();
					text1+=" <br> "+text;
				}
				System.out.println("Breadscrumbs are "+text1);

				CommonUtility.scrollToViewElement(driver,obj_PortalPage.OpenEscalationsGraphBar());

				CommonUtility.highlightElement(driver,obj_PortalPage.OpenEscalationsGraphBar());

				List<WebElement> list1=driver.findElements(obj_PortalPage.CountOfOpenEscalationsInGraphView());


				for(WebElement lt:list1)
				{
					if(value=="ED")
					{

						act.moveToElement(CommonUtility.highlightElement(driver, lt)).build().perform();
						CommonUtility.highlightElement(driver, lt);

					}
					else
					{
						CommonUtility.scrollToViewElement(driver, lt);

						//					act.moveToElement(CommonUtility.highlightElement(driver, lt)).build().perform();
						CommonUtility.highlightElement(driver, lt);
					}

					text=lt.getText();
					text4+=" <br> "+text;
				}
				System.out.println("count of open escalations displayed "+text4);

				if(text1.contains("Product Name"))
				{
					System.out.println("Product name not removed from breadscrumb");
					Report.put("User has applied filters from Filter menu & click on X mark on any filter breadcrumb", 
							"User should see that the filter/breadcrumb gets removed Graph/Visualization gets updated as per the filter removal" ,
							"Failed to X mark of Product Name filter under breadscrumb", "FAIL");

					Assert.fail();
				}

				Report.put("User has applied filters from Filter menu & click on X mark on any filter breadcrumb", 
						"User should see that the filter/breadcrumb gets removed Graph/Visualization gets updated as per the filter removal" ,
						"user able to click on X mark and able to see Bread scrumb Product Name removed from bread scrumb and <br> Filters displayed under Breadscrumb after removal of SR status Filter are  "+Report.color(text1), "PASS");
			}
			else
			{
				System.out.println("X button not displayed under breadscrumb of Product name");
				Report.put("User has applied filters from Filter menu & click on X mark on any filter breadcrumb", 
						"User should see that the filter/breadcrumb gets removed Graph/Visualization gets updated as per the filter removal" ,
						"Failed to click X mark of Product Name filter under breadscrumb", "FAIL");

				Assert.fail();
			}

		}
		catch(Exception e)
		{
			Log.info(e);
			Report.put("User has applied filters from Filter menu & click on X mark on any filter breadcrumb", 
					"User should see that the filter/breadcrumb gets removed Graph/Visualization gets updated as per the filter removal" ,
					"Failed to click X mark of Product Name filter under breadscrumb", "FAIL");
			e.printStackTrace();
			Assert.fail();
		}

	} 

	public void ClickOnInstallBaseTab(WebDriver driver)
	{

		Log.info("ClickOnInstallBaseTab");	
		WebDriverWait wait = new WebDriverWait(driver, 240);
		String text="";
		String text1="";
		driver.manage().timeouts().implicitlyWait(100000, TimeUnit.SECONDS);
		String value=TestNGCreator.TestData.get(Esupport.Dpid.ordinal());
		try
		{
			Thread.sleep(30000);
			//			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.IncidentsManagementTab()));
			if(CommonUtility.CheckpresenceofElementLocated(driver, 20000, obj_PortalPage.InstallBaseTab()))
			{

				if((value=="ED") || (value=="IE"))
				{
					Thread.sleep(7000);
					CommonUtility.scrollToViewElement(driver,obj_PortalPage.InstallBaseTab());
					CommonUtility.ToClickByUsingJavaScript_PassingByLoc(driver,obj_PortalPage.InstallBaseTab()); 
				}
				else
				{
					Thread.sleep(7000);
					CommonUtility.scrollToViewElement(driver,obj_PortalPage.InstallBaseTab());
					CommonUtility.highlightElement(driver,obj_PortalPage.InstallBaseTab()).click(); 
				}

				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.AfterClickingOnInstallBase()));
				String tab=CommonUtility.highlightElement(driver,obj_PortalPage.AfterClickingOnInstallBase()).getText();
				System.out.println(tab);
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.AssetsOnLeftRailDefaultClickingOnInstallBase()));
				text=CommonUtility.highlightElement(driver,obj_PortalPage.AssetsOnLeftRailDefaultClickingOnInstallBase()).getText(); 
				System.out.println(text);
				text1=CommonUtility.highlightElement(driver,obj_PortalPage.TableViewDefaultDisplay()).getText(); 
				System.out.println(text1);

				Report.put("user navigates to the install base page", 
						"user is on install base page in Assets in Tabular view default." ,
						"User able to click on "+Report.color(tab)+" tab and able to see "+Report.color(text+" displays in "+text1)+" view", "PASS");
			}
			else
			{
				System.out.println("not ble to see install base tab");
				Report.put("user navigates to the install base page", 
						"user is on install base page in Assets in Tabular view default." ,
						"Failed to click on install base tab", "FAIL");

				Assert.fail();
			}

		}
		catch(Exception e)
		{
			Log.info(e);
			Report.put("user navigates to the install base page", 
					"user is on install base page in Assets in Tabular view default." ,
					"Failed to click on install base tab", "FAIL");
			e.printStackTrace();
			Assert.fail();
		}

	} 

	public void ClickOnFilterAndValidateInstanceIDDisplayedInFilterSectionInInstallBase(WebDriver driver)
	{

		Log.info("ClickOnFilterAndValidateInstanceIDDisplayedInFilterSectionInInstallBase");	
		WebDriverWait wait = new WebDriverWait(driver, 240);
		String text="";
		String text1="";
		String map="";
		String text2="";
		String defaults="";
		String text3="";
		String text4="";
		String text5="";
		String text6="";
		String text7="";
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		Actions act=new Actions(driver);
		String value=TestNGCreator.TestData.get(Esupport.Dpid.ordinal());
		String value2=TestNGCreator.TestData.get(Esupport.SearchOption.ordinal());
		try
		{
			//			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.IncidentsManagementTab()));
			if(CommonUtility.CheckpresenceofElementLocated(driver, 50, obj_PortalPage.FilterButton()))
			{
				CommonUtility.scrollToViewElement(driver,obj_PortalPage.FilterButton());
				map=CommonUtility.highlightElement(driver,obj_PortalPage.FilterButton()).getText();
				System.out.println(map);
				CommonUtility.highlightElement(driver,obj_PortalPage.FilterButton()).click(); 
				driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
				Thread.sleep(5000);
				driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.FilterByHeader()));
				text5=CommonUtility.highlightElement(driver,obj_PortalPage.FilterByHeader()).getText();
				System.out.println(text5);
				CommonUtility.scrollToViewElement(driver,obj_PortalPage.InstanceIDINFilterWindow());
				text2=CommonUtility.highlightElement(driver,obj_PortalPage.InstanceIDINFilterWindow()).getText();
				System.out.println("Filter is "+text2);

				Report.put("user clicks on Filter icon above the ib grid ", 
						"user should be able to see window slides open from the left side of the screen with the label 'Filter By' the following 'Instance ID' option is displayed inside the filter By drawer window" ,
						"user able to click on "+Report.color(map)+" and able to see window slides open from left side of screen with label "+Report.color(text5)+" <br> and able to see option "+Report.color(text2)+" displayed inside filter window", "PASS");


				defaults=CommonUtility.highlightElement(driver,obj_PortalPage.ClearAllButtonInFilterWindow()).getText();
				System.out.println("clear all button displayed "+defaults);

				Report.put("expanding icon is displayed at the right of each of the filter options ", 
						"user should be able to view expanding icon is displayed at the right of each of the filter options" ,
						"user able to see expand icon", "PASS");
				Report.put("button is displayed at the bottom left with the label 'Clear All'", 
						"user  should be able to view  button is displayed at the bottom left with the label 'Clear All'" ,
						"user able to see "+Report.color(defaults)+" button at the bottom left of filter window", "PASS");


				CommonUtility.highlightElement(driver,obj_PortalPage.InstanceIDINFilterWindow()).click();
				Thread.sleep(5000);
				driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
				CommonUtility.scrollToViewElement(driver,obj_PortalPage.SearchBoxInInstanceIDOptionExpandedInFilterWindow());
				String description=CommonUtility.highlightElement(driver,obj_PortalPage.DescriptionUnderSearchBoxOfInstanceIDExpandedView()).getText();
				System.out.println("description displayed is "+description);

				Report.put("user clicks on Filter icon above the ib grid and user clicks on the expanding icon of the 'Instance ID' option", 
						"user  should be able to see the user's Instance IDs view with search box and description" ,
						"user able to see "+Report.color(text2)+" and search box with description as "+Report.color(description), "PASS");


				CommonUtility.highlightElement(driver,obj_PortalPage.SearchBoxInInstanceIDOptionExpandedInFilterWindow()).sendKeys(value2);

				Report.put("user enters values in search box", 
						"user  should be able to see the user's Instance IDs listed as options under Install Base Status:" ,
						"user enter values as "+Report.color(value2)+" and see options listed ", "PASS");

				String firstoption=CommonUtility.highlightElement(driver,obj_PortalPage.SelectSearchedFirstResultDisplayedInFilterWindow()).getText();
				System.out.println(firstoption);
				CommonUtility.highlightElement(driver,obj_PortalPage.SelectSearchedFirstResultDisplayedInFilterWindow()).click();

				CommonUtility.scrollToViewElement(driver,obj_PortalPage.ApplySelectedInFilterWindow());
				text3=CommonUtility.highlightElement(driver,obj_PortalPage.ApplySelectedInFilterWindow()).getText();
				System.out.println("text is "+text3);

				Report.put("apply filter button is displayed with the label 'Apply Selected'", 
						"user  should be able to see apply filter button is displayed with the label 'Apply Selected'" ,
						"user able to see "+Report.color(text3), "PASS");

				text6=CommonUtility.highlightElement(driver,obj_PortalPage.ResetSelectedButtonInFilterWindow()).getText();
				System.out.println("text is "+text6);

				Report.put("reset selection button is displayed with the label 'Reset Selection'", 
						"user  should be able to view reset selection button is displayed with the label 'Reset Selection'" ,
						"user able to see "+Report.color(text6), "PASS");

				Report.put("user clicks on the expanding icon of the 'Instance ID' option and clicks one of the Instance ID value checkbox to select the filter ", 
						"user  should be able to click on the expanding icon  of the 'Instance ID' option and clicks one of the Instance ID value checkbox to select the filter " ,
						"user able to select first option displayed "+Report.color(firstoption)+" which contains searched value "+Report.color(value2), "PASS");

				CommonUtility.highlightElement(driver,obj_PortalPage.ApplySelectedInFilterWindow()).click();

				Report.put("user clicks on the 'Apply Selected' button ", 
						"Instance ID Filter section collapses" ,
						"user clicks on "+Report.color(text3)+" and able to see Instance ID Filter section collapses", "PASS");


				CommonUtility.scrollToViewElement(driver,obj_PortalPage.XButtonOnFilterWindow());
				CommonUtility.highlightElement(driver,obj_PortalPage.XButtonOnFilterWindow()).click();

				Report.put("close cross icon is displayed at the top right corner and clicks on cross icon to close the Filter By window ", 
						"the filter by window collapses" ,
						"user able to click on X mark displayed on right top corner of filter window and able to see filter by window collapses", "PASS");

				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.HeadingsOfTable1()));
				List<WebElement> list=driver.findElements(obj_PortalPage.HeadingsOfTable1());
				List<WebElement> list2=driver.findElements(obj_PortalPage.RowsDisplayedUnderTable1());
				List<WebElement> list3=driver.findElements(obj_PortalPage.CountOfRowsDisplayed());
				int count=list3.size();
				System.out.println(count);
				for(WebElement lt:list)
				{
					if(value=="ED")
					{

						act.moveToElement(CommonUtility.highlightElement(driver, lt)).build().perform();
						CommonUtility.highlightElement(driver, lt);

					}
					else
					{
						CommonUtility.scrollToViewElement(driver, lt);

						//					act.moveToElement(CommonUtility.highlightElement(driver, lt)).build().perform();
						CommonUtility.highlightElement(driver, lt);
					}

					text=lt.getText();
					text1+=" <br> "+text;
				}
				System.out.println("heading displayed are "+text1);

				for(WebElement lt:list2)
				{
					if(value=="ED")
					{

						act.moveToElement(CommonUtility.highlightElement(driver, lt)).build().perform();
						CommonUtility.highlightElement(driver, lt);

					}
					else
					{
						CommonUtility.scrollToViewElement(driver, lt);

						//					act.moveToElement(CommonUtility.highlightElement(driver, lt)).build().perform();
						CommonUtility.highlightElement(driver, lt);
					}

					text=lt.getText();
					text7+=" <br> "+text;
				}
				System.out.println("values displayed under heading in grid "+text7);

				List<WebElement> list1=driver.findElements(obj_PortalPage.BreadScrumbsOnGraphView());


				for(WebElement lt:list1)
				{
					if(value=="ED")
					{

						act.moveToElement(CommonUtility.highlightElement(driver, lt)).build().perform();
						CommonUtility.highlightElement(driver, lt);

					}
					else
					{
						CommonUtility.scrollToViewElement(driver, lt);

						//					act.moveToElement(CommonUtility.highlightElement(driver, lt)).build().perform();
						CommonUtility.highlightElement(driver, lt);
					}

					text=lt.getText();
					text4+=" <br> "+text;
				}
				System.out.println("Breadscrumbs are "+text4);


				Report.put("Validate applied filters are reflecting in tabular view of install base", 
						"user should be able to view a numeric value is displayed on the filter icon above the ib grid " ,
						"user able to see breadscrumb added with Instance ID as "+Report.color(text4)+" and grid with headings "+Report.color(text1)+" and<br> count of rows displayed are "+count+" with values "+Report.color(text7), "PASS");


			} 
			else
			{
				System.out.println("not ble to see filter button or it is disabled");
				Report.put("User verifies to apply filters on the tabular view of install base", 
						"User should be able to apply filters on the tabular view of install base and the same filters should get applied to the grid" ,
						"Failed to click on Filter button/or issue in applying filter", "FAIL");

				Assert.fail();
			}

		}
		catch(Exception e)
		{
			Log.info(e);
			Report.put("User verifies to apply filters on the tabular view of install base", 
					"User should be able to apply filters on the tabular view of install base and the same filters should get applied to the grid" ,
					"Failed to click on Filter button/or issue in applying filter", "FAIL");
			e.printStackTrace();
			Assert.fail();
		}

	} 


	public void ValidateTabsInPortalView(WebDriver driver)
	{

		Log.info("ValidateTabsInPortalView");	
		WebDriverWait wait = new WebDriverWait(driver, 240);
		String text="";
		String text1="";
		String map="";
		String text2="";
		String defaults="";
		String text3="";
		String text4="";
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		Actions act=new Actions(driver);
		String value=TestNGCreator.TestData.get(Esupport.Dpid.ordinal());
		try
		{
			Thread.sleep(10000);
			//			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.IncidentsManagementTab()));
			if(CommonUtility.CheckpresenceofElementLocated(driver, 500, obj_PortalPage.TabsOnPortalView()))
			{

				List<WebElement> list=driver.findElements(obj_PortalPage.TabsOnPortalView());


				for(WebElement lt:list)
				{
					if(value=="ED")
					{

						act.moveToElement(CommonUtility.highlightElement(driver, lt)).build().perform();
						CommonUtility.highlightElement(driver, lt);

					}
					else
					{
						CommonUtility.scrollToViewElement(driver, lt);

						//					act.moveToElement(CommonUtility.highlightElement(driver, lt)).build().perform();
						CommonUtility.highlightElement(driver, lt);
					}

					text=lt.getText();
					text1+=" <br> "+text;
				}
				System.out.println("tabs are "+text1);

				Report.put("system display  tabs:Summary,HEALTH & RISK,INSTALL BASE,INCIDENT MANAGEMENT", 
						"user  should be able to view the tabs:Summary,HEALTH & RISK,INSTALL BASE,INCIDENT MANAGEMENT" ,
						"user able to see tabs "+Report.color(text1), "PASS");
			}
			else
			{
				System.out.println("not able to see tabs");
				Report.put("system display  tabs:Summary,HEALTH & RISK,INSTALL BASE,INCIDENT MANAGEMENT", 
						"user  should be able to view the tabs:Summary,HEALTH & RISK,INSTALL BASE,INCIDENT MANAGEMENT" ,
						"Failed to see tabs", "FAIL");

				Assert.fail();
			}

		}
		catch(Exception e)
		{
			Log.info(e);
			Report.put("system display  tabs:Summary,HEALTH & RISK,INSTALL BASE,INCIDENT MANAGEMENT", 
					"user  should be able to view the tabs:Summary,HEALTH & RISK,INSTALL BASE,INCIDENT MANAGEMENT" ,
					"Failed to see tabs", "FAIL");
			e.printStackTrace();
			Assert.fail();
		}

	} 

	public void ValidateGridColumnsWhenUserSelectedAssetsMenu(WebDriver driver)
	{

		Log.info("ValidateGridColumnsWhenUserSelectedAssetsMenu");	
		WebDriverWait wait = new WebDriverWait(driver, 240);
		String text="";
		String text1="";
		String map="";
		String text2="";
		String defaults="";
		String text3="";
		String text4="";
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		Actions act=new Actions(driver);
		String value=TestNGCreator.TestData.get(Esupport.Dpid.ordinal());
		try
		{
			//			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.IncidentsManagementTab()));
			if(CommonUtility.CheckpresenceofElementLocated(driver, 50, obj_PortalPage.HeadingsOfTable1()))
			{

				List<WebElement> list=driver.findElements(obj_PortalPage.HeadingsOfTable1());

				try
				{
					for(WebElement lt:list)
					{
						if(value=="ED")
						{

							act.moveToElement(CommonUtility.highlightElement(driver, lt)).build().perform();
							CommonUtility.highlightElement(driver, lt);

						}
						else
						{
							CommonUtility.scrollToViewElement(driver, lt);

							//					act.moveToElement(CommonUtility.highlightElement(driver, lt)).build().perform();
							CommonUtility.highlightElement(driver, lt);
						}

						text=lt.getText();
						text1+=" <br> "+text;
					}
					System.out.println("columns are "+text1);
				}
				catch(Exception e)
				{

				}
				Report.put("system display grid with following columns when user is in Assets in left menu :PRODUCT ID,PRODUCT NAME ,SITE ID, CUSTOMER NAME ,PRODUCT NICKNAME,PRODUCT TYPE,INSTALL STATUS,INSTALL BASE", 
						"user should be able to see a grid with columns:PRODUCT ID,PRODUCT NAME ,SITE ID, CUSTOMER NAME ,PRODUCT NICKNAME,PRODUCT TYPE,INSTALL STATUS,INSTALL BASE" ,
						"user able to see tabs grid columns as "+Report.color(text1), "PASS");
			}
			else
			{
				System.out.println("not able to see columns in grid");
				Report.put("system display grid with following columns when user is in Assets in left menu :PRODUCT ID,PRODUCT NAME ,SITE ID, CUSTOMER NAME ,PRODUCT NICKNAME,PRODUCT TYPE,INSTALL STATUS,INSTALL BASE", 
						"user should be able to see a grid with columns:PRODUCT ID,PRODUCT NAME ,SITE ID, CUSTOMER NAME ,PRODUCT NICKNAME,PRODUCT TYPE,INSTALL STATUS,INSTALL BASE" ,
						"Failed to see columns in grid", "FAIL");

				Assert.fail();
			}

		}
		catch(Exception e)
		{
			Log.info(e);
			Report.put("system display grid with following columns when user is in Assets in left menu :PRODUCT ID,PRODUCT NAME ,SITE ID, CUSTOMER NAME ,PRODUCT NICKNAME,PRODUCT TYPE,INSTALL STATUS,INSTALL BASE", 
					"user should be able to see a grid with columns:PRODUCT ID,PRODUCT NAME ,SITE ID, CUSTOMER NAME ,PRODUCT NICKNAME,PRODUCT TYPE,INSTALL STATUS,INSTALL BASE" ,
					"Failed to see columns in grid", "FAIL");
			e.printStackTrace();
			Assert.fail();
		}

	} 

	public void ValidateGridColumnsWhenUserSelectedConnectivityFromLeftMenu(WebDriver driver)
	{

		Log.info("ValidateGridColumnsWhenUserSelectedConnectivityFromLeftMenu");	
		WebDriverWait wait = new WebDriverWait(driver, 240);
		String text="";
		String text1="";
		String map="";
		String text2="";
		String defaults="";
		String text3="";
		String text4="";
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		Actions act=new Actions(driver);
		String value=TestNGCreator.TestData.get(Esupport.Dpid.ordinal());
		try
		{
			//			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.IncidentsManagementTab()));
			if(CommonUtility.CheckpresenceofElementLocated(driver, 50, obj_PortalPage.ConnectivityOnLeftRailOfInstallBase()))
			{
				CommonUtility.scrollToViewElement(driver, obj_PortalPage.ConnectivityOnLeftRailOfInstallBase());
				text2=CommonUtility.highlightElement(driver, obj_PortalPage.ConnectivityOnLeftRailOfInstallBase()).getText();
				System.out.println(text2);
				CommonUtility.highlightElement(driver, obj_PortalPage.ConnectivityOnLeftRailOfInstallBase()).click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.HeadingsOfTable1()));
				List<WebElement> list=driver.findElements(obj_PortalPage.HeadingsOfTable1());

				try
				{
					for(WebElement lt:list)
					{
						if(value=="ED")
						{

							act.moveToElement(CommonUtility.highlightElement(driver, lt)).build().perform();
							CommonUtility.highlightElement(driver, lt);

						}
						else
						{
							CommonUtility.scrollToViewElement(driver, lt);

							//					act.moveToElement(CommonUtility.highlightElement(driver, lt)).build().perform();
							CommonUtility.highlightElement(driver, lt);
						}

						text=lt.getText();
						text1+=" <br> "+text;
					}
					System.out.println("columns are "+text1);
				}
				catch(Exception e)
				{

				}

				Report.put("system display grid with following columns when user is in connectivity from left menu :PRODUCT ID,PRODUCT NAME ,SITE ID, CUSTOMER NAME ,PRODUCT NICKNAME,CONNECTION STATUS,CONNECTION TYPE,CONNECTION AGE ,LAST CONNECTED", 
						"user should be able to see a grid with columns:PRODUCT ID,PRODUCT NAME ,SITE ID, CUSTOMER NAME ,PRODUCT NICKNAME,CONNECTION STATUS,CONNECTION TYPE,CONNECTION AGE ,LAST CONNECTED" ,
						"user able to see tabs grid columns as "+Report.color(text1), "PASS");
			}
			else
			{
				System.out.println("not able to see columns in grid");
				Report.put("system display grid with following columns when user is in connectivity from left menu :PRODUCT ID,PRODUCT NAME ,SITE ID, CUSTOMER NAME ,PRODUCT NICKNAME,CONNECTION STATUS,CONNECTION TYPE,CONNECTION AGE ,LAST CONNECTED", 
						"user should be able to see a grid with columns:PRODUCT ID,PRODUCT NAME ,SITE ID, CUSTOMER NAME ,PRODUCT NICKNAME,CONNECTION STATUS,CONNECTION TYPE,CONNECTION AGE ,LAST CONNECTED" ,
						"Failed to see columns in grid", "FAIL");

				Assert.fail();
			}

		}
		catch(Exception e)
		{
			Log.info(e);
			Report.put("system display grid with following columns when user is in connectivity from left menu :PRODUCT ID,PRODUCT NAME ,SITE ID, CUSTOMER NAME ,PRODUCT NICKNAME,CONNECTION STATUS,CONNECTION TYPE,CONNECTION AGE ,LAST CONNECTED", 
					"user should be able to see a grid with columns:PRODUCT ID,PRODUCT NAME ,SITE ID, CUSTOMER NAME ,PRODUCT NICKNAME,CONNECTION STATUS,CONNECTION TYPE,CONNECTION AGE ,LAST CONNECTED" ,
					"Failed to see columns in grid", "FAIL");
			e.printStackTrace();
			Assert.fail();
		}

	} 

	public void ValidateGridColumnsWhenUserSelectedCodeLevelsFromLeftMenu(WebDriver driver)
	{

		Log.info("ValidateGridColumnsWhenUserSelectedCodeLevelsFromLeftMenu");	
		WebDriverWait wait = new WebDriverWait(driver, 240);
		String text="";
		String text1="";
		String map="";
		String text2="";
		String defaults="";
		String text3="";
		String text4="";
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		Actions act=new Actions(driver);
		String value=TestNGCreator.TestData.get(Esupport.Dpid.ordinal());
		try
		{
			//			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.IncidentsManagementTab()));
			if(CommonUtility.CheckpresenceofElementLocated(driver, 50, obj_PortalPage.CodeLevelsOnLeftRailOfInstallBase()))
			{
				CommonUtility.scrollToViewElement(driver, obj_PortalPage.CodeLevelsOnLeftRailOfInstallBase());
				text2=CommonUtility.highlightElement(driver, obj_PortalPage.CodeLevelsOnLeftRailOfInstallBase()).getText();
				System.out.println(text2);
				CommonUtility.highlightElement(driver, obj_PortalPage.CodeLevelsOnLeftRailOfInstallBase()).click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.HeadingsOfTable1()));
				List<WebElement> list=driver.findElements(obj_PortalPage.HeadingsOfTable1());

				try
				{
					for(WebElement lt:list)
					{
						if(value=="ED")
						{

							act.moveToElement(CommonUtility.highlightElement(driver, lt)).build().perform();
							CommonUtility.highlightElement(driver, lt);

						}
						else
						{
							CommonUtility.scrollToViewElement(driver, lt);

							//					act.moveToElement(CommonUtility.highlightElement(driver, lt)).build().perform();
							CommonUtility.highlightElement(driver, lt);
						}

						text=lt.getText();
						text1+=" <br> "+text;
					}
					System.out.println("columns are "+text1);
				}
				catch(Exception e)
				{

				}
				Report.put("system display grid with following columns when user is in code levels from left menu :PRODUCT ID,PRODUCT NAME ,SITE ID, CUSTOMER NAME ,PRODUCT NICKNAME,CODE LEVEL,TARGET -1 CODE,TARGET+1 CODE,INSTALLED CODE", 
						"user should be able to see a grid with columns:PRODUCT ID,PRODUCT NAME ,SITE ID, CUSTOMER NAME ,PRODUCT NICKNAME,CODE LEVEL,TARGET -1 CODE,TARGET+1 CODE,INSTALLED CODE" ,
						"user able to see tabs grid columns as "+Report.color(text1), "PASS");
			}
			else
			{
				System.out.println("not able to see columns in grid");
				Report.put("system display grid with following columns when user is in code levels from left menu :PRODUCT ID,PRODUCT NAME ,SITE ID, CUSTOMER NAME ,PRODUCT NICKNAME,CODE LEVEL,TARGET -1 CODE,TARGET+1 CODE,INSTALLED CODE", 
						"user should be able to see a grid with columns:PRODUCT ID,PRODUCT NAME ,SITE ID, CUSTOMER NAME ,PRODUCT NICKNAME,CODE LEVEL,TARGET -1 CODE,TARGET+1 CODE,INSTALLED CODE" ,
						"Failed to see columns in grid", "FAIL");

				Assert.fail();
			}

		}
		catch(Exception e)
		{
			Log.info(e);
			Report.put("system display grid with following columns when user is in code levels from left menu :PRODUCT ID,PRODUCT NAME ,SITE ID, CUSTOMER NAME ,PRODUCT NICKNAME,CODE LEVEL,TARGET -1 CODE,TARGET+1 CODE,INSTALLED CODE", 
					"user should be able to see a grid with columns:PRODUCT ID,PRODUCT NAME ,SITE ID, CUSTOMER NAME ,PRODUCT NICKNAME,CODE LEVEL,TARGET -1 CODE,TARGET+1 CODE,INSTALLED CODE" ,
					"Failed to see columns in grid", "FAIL");
			e.printStackTrace();
			Assert.fail();
		}

	} 

	public void ValidateGridColumnsWhenUserSelectedContractsFromLeftMenu(WebDriver driver)
	{

		Log.info("ValidateGridColumnsWhenUserSelectedContractsFromLeftMenu");	
		WebDriverWait wait = new WebDriverWait(driver, 240);
		String text="";
		String text1="";
		String map="";
		String text2="";
		String defaults="";
		String text3="";
		String text4="";
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		Actions act=new Actions(driver);
		String value=TestNGCreator.TestData.get(Esupport.Dpid.ordinal());
		try
		{
			//			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.IncidentsManagementTab()));
			if(CommonUtility.CheckpresenceofElementLocated(driver, 50, obj_PortalPage.ContractsOnLeftRailOfInstallBase()))
			{
				CommonUtility.scrollToViewElement(driver, obj_PortalPage.ContractsOnLeftRailOfInstallBase());
				text2=CommonUtility.highlightElement(driver, obj_PortalPage.ContractsOnLeftRailOfInstallBase()).getText();
				System.out.println(text2);
				CommonUtility.highlightElement(driver, obj_PortalPage.ContractsOnLeftRailOfInstallBase()).click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.HeadingsOfTable1()));
				List<WebElement> list=driver.findElements(obj_PortalPage.HeadingsOfTable1());

				try
				{
					for(WebElement lt:list)
					{

						if(value=="ED")
						{

							act.moveToElement(CommonUtility.highlightElement(driver, lt)).build().perform();
							CommonUtility.highlightElement(driver, lt);

						}
						else
						{

							CommonUtility.scrollToViewElement(driver, lt);

							//					act.moveToElement(CommonUtility.highlightElement(driver, lt)).build().perform();
							CommonUtility.highlightElement(driver, lt);

						}

						text=lt.getText();
						text1+=" <br> "+text;
					}
					System.out.println("columns are "+text1);
				}

				catch(Exception e)
				{

				}

				Report.put("system display grid with following columns when user is in contracts from left menu :PRODUCT ID,PRODUCT NAME ,SITE ID, CUSTOMER NAME ,PRODUCT NICKNAME,SALES ORDER,CONTRACT STATUS,CONTRACT Type,CONTRACT END DATE", 
						"user should be able to see a grid with columns:PRODUCT ID,PRODUCT NAME ,SITE ID, CUSTOMER NAME ,PRODUCT NICKNAME,SALES ORDER,CONTRACT STATUS,CONTRACT Type,CONTRACT END DATE" ,
						"user able to see tabs grid columns as "+Report.color(text1), "PASS");
			}
			else
			{
				System.out.println("not able to see columns in grid");
				Report.put("system display grid with following columns when user is in contracts from left menu :PRODUCT ID,PRODUCT NAME ,SITE ID, CUSTOMER NAME ,PRODUCT NICKNAME,SALES ORDER,CONTRACT STATUS,CONTRACT Type,CONTRACT END DATE", 
						"user should be able to see a grid with columns:PRODUCT ID,PRODUCT NAME ,SITE ID, CUSTOMER NAME ,PRODUCT NICKNAME,SALES ORDER,CONTRACT STATUS,CONTRACT Type,CONTRACT END DATE" ,
						"Failed to see columns in grid", "FAIL");

				Assert.fail();
			}

		}
		catch(Exception e)
		{
			Log.info(e);
			Report.put("system display grid with following columns when user is in contracts from left menu :PRODUCT ID,PRODUCT NAME ,SITE ID, CUSTOMER NAME ,PRODUCT NICKNAME,SALES ORDER,CONTRACT STATUS,CONTRACT Type,CONTRACT END DATE", 
					"user should be able to see a grid with columns:PRODUCT ID,PRODUCT NAME ,SITE ID, CUSTOMER NAME ,PRODUCT NICKNAME,SALES ORDER,CONTRACT STATUS,CONTRACT Type,CONTRACT END DATE" ,
					"Failed to see columns in grid", "FAIL");
			e.printStackTrace();
			Assert.fail();
		}

	} 

	public void ValidateTopViewMenuOnTheGrid(WebDriver driver)
	{

		Log.info("ValidateTopViewMenuOnTheGrid");	
		WebDriverWait wait = new WebDriverWait(driver, 240);
		String text="";
		String text1="";
		String map="";
		String text2="";
		String defaults="";
		String text3="";
		String text4="";
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		Actions act=new Actions(driver);
		String value=TestNGCreator.TestData.get(Esupport.Dpid.ordinal());
		try
		{
			//			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.IncidentsManagementTab()));
			if(CommonUtility.CheckpresenceofElementLocated(driver, 50, obj_PortalPage.AssetsOnLeftRailOfInstallBase()))
			{
				CommonUtility.scrollToViewElement(driver, obj_PortalPage.AssetsOnLeftRailOfInstallBase());
				text2=CommonUtility.highlightElement(driver, obj_PortalPage.AssetsOnLeftRailOfInstallBase()).getText();
				System.out.println(text2);
				CommonUtility.highlightElement(driver, obj_PortalPage.AssetsOnLeftRailOfInstallBase()).click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.TabsLocatedOnOfGrid()));

				List<WebElement> list=driver.findElements(obj_PortalPage.TabsLocatedOnOfGrid());


				for(WebElement lt:list)
				{
					if(value=="ED")
					{

						act.moveToElement(CommonUtility.highlightElement(driver, lt)).build().perform();
						CommonUtility.highlightElement(driver, lt);

					}
					else
					{
						CommonUtility.scrollToViewElement(driver, lt);

						//					act.moveToElement(CommonUtility.highlightElement(driver, lt)).build().perform();
						CommonUtility.highlightElement(driver, lt);
					}

					text=lt.getText();
					text1+=" <br> "+text;
				}
				System.out.println("tabs top view on grid are "+text1);

				Report.put("system display tabs located on the top of the grid that provides the ability to switch to the: Tabular,map, download", 
						"user  should be  able to see tabs located on the top of the grid that provides the ability to switch to the:Tabula, map, download" ,
						"user able to see tabs on top of the grid "+Report.color(text1), "PASS");

				Report.put("user should  navigates to the  top right of the grid", 
						"user  should be able to see an download icon that provides the ability to export the grid data, located towards the top right of the grid" ,
						"user able to see download icon", "PASS");
			}
			else
			{
				System.out.println("not able to see asset tab in left menu");
				Report.put("system display tabs located on the top of the grid that provides the ability to switch to the: Tabular,map,download", 
						"user  should be  able to see tabs located on the top of the grid that provides the ability to switch to the:Tabula, map,download" ,
						"Failed to see asset tab in left menu", "FAIL");

				Assert.fail();
			}

		}
		catch(Exception e)
		{
			Log.info(e);
			Report.put("system display tabs located on the top of the grid that provides the ability to switch to the: Tabular,map,download", 
					"user  should be  able to see tabs located on the top of the grid that provides the ability to switch to the:Tabula, map,download" ,
					"Failed to see asset tab in left menu", "FAIL");
			e.printStackTrace();
			Assert.fail();
		}

	} 

	public void ValidateLeftMentOnInstallBase(WebDriver driver)
	{

		Log.info("ValidateLeftMentOnInstallBase");	
		WebDriverWait wait = new WebDriverWait(driver, 240);
		String text="";
		String text1="";
		String map="";
		String text2="";
		String defaults="";
		String text3="";
		String text4="";
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		Actions act=new Actions(driver);
		String value=TestNGCreator.TestData.get(Esupport.Dpid.ordinal());
		try
		{
			//			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.IncidentsManagementTab()));
			if(CommonUtility.CheckpresenceofElementLocated(driver, 50, obj_PortalPage.LeftSideMenuListOfTheGridOfInstallBase()))
			{
				//				CommonUtility.scrollToViewElement(driver, obj_PortalPage.ContractsOnLeftRailOfInstallBase());
				//				text2=CommonUtility.highlightElement(driver, obj_PortalPage.ContractsOnLeftRailOfInstallBase()).getText();
				//				System.out.println(text2);
				//				CommonUtility.highlightElement(driver, obj_PortalPage.ContractsOnLeftRailOfInstallBase()).click();
				//				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.HeadingsOfTable1()));
				List<WebElement> list=driver.findElements(obj_PortalPage.LeftSideMenuListOfTheGridOfInstallBase());


				for(WebElement lt:list)
				{
					if(value=="ED")
					{

						act.moveToElement(CommonUtility.highlightElement(driver, lt)).build().perform();
						CommonUtility.highlightElement(driver, lt);

					}
					else
					{
						CommonUtility.scrollToViewElement(driver, lt);

						//					act.moveToElement(CommonUtility.highlightElement(driver, lt)).build().perform();
						CommonUtility.highlightElement(driver, lt);
					}

					text=lt.getText();
					text1+=" <br> "+text;
				}
				System.out.println("left menu tabs are "+text1);

				Report.put("syste display summary view options under the Tabular section located on the left side of the grid that provides the ability to switch to the:Assets summary,Connectivity,Code Levels,Contracts", 
						"user  should be able to view the following options under the tabular sections on the left side and user able to switch to user should see summary view options under the Tabular section located on the left side of the grid that provides the ability to switch to the:Assets summary,Connectivity,Code Levels,Contracts " ,
						"user able to see tabs grid columns as "+Report.color(text1), "PASS");
			}
			else
			{
				System.out.println("not able to see tabs in left menu ");
				Report.put("syste display summary view options under the Tabular section located on the left side of the grid that provides the ability to switch to the:Assets summary,Connectivity,Code Levels,Contracts", 
						"user  should be able to view the following options under the tabular sections on the left side and user able to switch to user should see summary view options under the Tabular section located on the left side of the grid that provides the ability to switch to the:Assets summary,Connectivity,Code Levels,Contracts " ,
						"Failed to see left menu tabs", "FAIL");

				Assert.fail();
			}

		}
		catch(Exception e)
		{
			Log.info(e);
			Report.put("syste display summary view options under the Tabular section located on the left side of the grid that provides the ability to switch to the:Assets summary,Connectivity,Code Levels,Contracts", 
					"user  should be able to view the following options under the tabular sections on the left side and user able to switch to user should see summary view options under the Tabular section located on the left side of the grid that provides the ability to switch to the:Assets summary,Connectivity,Code Levels,Contracts " ,
					"Failed to see left menu tabs", "FAIL");
			e.printStackTrace();
			Assert.fail();
		}

	} 


	public void VerifySearchBoxOnLeftLowerSideOfTheGrid(WebDriver driver)
	{

		Log.info("Entering VerifySearchBoxOnLeftLowerSideOfTheGrid method");	
		WebDriverWait wait = new WebDriverWait(driver, 120);
		Actions act=new Actions(driver);
		String placeholder="";
		String header="";
		String displayedvalues="";
		String displayedvalues1="";
		String displayedvalues2="";
		String message="";
		String value=TestNGCreator.TestData.get(Esupport.SearchOption.ordinal());
		try
		{
			if(CommonUtility.CheckpresenceofElementLocated(driver, 15, obj_PortalPage.SearchTextBox()))
			{

				CommonUtility.scrollToViewElement(driver,obj_PortalPage.SearchTextBox());	
				placeholder=CommonUtility.highlightElement(driver,obj_PortalPage.SearchTextBox()).getAttribute("placeholder");
				System.out.println(placeholder);

				CommonUtility.scrollToViewElement(driver,obj_PortalPage.SearchButton());
				CommonUtility.highlightElement(driver,obj_PortalPage.SearchButton());

				Report.put("user should see a search box on the left lower side of the grid, that provides the ability to search through the assets", 
						"user able see a search box on the left lower side of the grid, that provides the ability to search through the assets" ,
						"Searched data not found and display message as "+Report.color(message), "PASS");


			}

			else
			{
				System.out.println("search text box not found");
				Report.put("user should see a search box on the left lower side of the grid, that provides the ability to search through the assets", 
						"user able see a search box on the left lower side of the grid, that provides the ability to search through the assets" ,
						"not able to see search text box", "FAIL");
				Assert.fail();
			}
		}
		catch(Exception e)
		{
			Log.info(e);
			Report.put("user should see a search box on the left lower side of the grid, that provides the ability to search through the assets", 
					"user able see a search box on the left lower side of the grid, that provides the ability to search through the assets" ,
					"not able to see search text box", "FAIL");
			e.printStackTrace();
			Assert.fail();
		}

	} 

	public void ClickOnConnectivityFromLeftMenuInInstallBase(WebDriver driver)
	{

		Log.info("ClickOnConnectivityFromLeftMenuInInstallBase");	
		WebDriverWait wait = new WebDriverWait(driver, 240);
		String text="";
		String text1="";
		String map="";
		String text2="";
		String defaults="";
		String text3="";
		String text4="";
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		Actions act=new Actions(driver);
		String value=TestNGCreator.TestData.get(Esupport.Dpid.ordinal());
		try
		{
			CommonUtility.scrollToViewElement(driver, obj_PortalPage.ConnectivityOnLeftRailOfInstallBase());
			//			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.IncidentsManagementTab()));
			if(CommonUtility.CheckpresenceofElementLocated(driver, 50, obj_PortalPage.ConnectivityOnLeftRailOfInstallBase()))
			{
				CommonUtility.scrollToViewElement(driver, obj_PortalPage.ConnectivityOnLeftRailOfInstallBase());
				text2=CommonUtility.highlightElement(driver, obj_PortalPage.ConnectivityOnLeftRailOfInstallBase()).getText();
				System.out.println(text2);
				CommonUtility.highlightElement(driver, obj_PortalPage.ConnectivityOnLeftRailOfInstallBase()).click();
//				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.HeadingsOfTable1()));
//				List<WebElement> list=driver.findElements(obj_PortalPage.HeadingsOfTable1());
//
//				try
//				{
//					for(int i=0;i<list.size();i++)
//
//					{
//						if(i==1)
//						{
//
//							if(value=="ED")
//							{
//
//								act.moveToElement(CommonUtility.highlightElement(driver, list.get(i))).build().perform();
////								CommonUtility.highlightElement(driver, list.get(i));
//								CommonUtility.highlightElement(driver, list.get(i)).click();
//
//
//							}
//							else
//							{
//								//act.moveToElement(CommonUtility.highlightElement(driver, lt)).build().perform();
//
//								//act.moveToElement(CommonUtility.highlightElement(driver, lt)).build().perform();
//								CommonUtility.highlightElement(driver, list.get(i));
//								CommonUtility.highlightElement(driver, list.get(i)).click();
//							}
//
//
//						}
//					}
//
//				}
//				catch(Exception e)
//				{
//
//				}

				Report.put("User clicks on connectivity From left menu", 
						"user should be able to click on connectivity from left menu under install base" ,
						"user able click on "+Report.color(text2), "PASS");
			}
			else
			{
				System.out.println("not able to connectivity in left menu");
				Report.put("User clicks on connectivity From left menu", 
						"user should be able to click on connectivity from left menu under install base" ,
						"Failed to see connectivity in left menu", "FAIL");

				Assert.fail();
			}

		}
		catch(Exception e)
		{
			Log.info(e);
			Report.put("User clicks on connectivity From left menu", 
					"user should be able to click on connectivity from left menu under install base" ,
					"Failed to see connectivity in left menu", "FAIL");
			e.printStackTrace();
			Assert.fail();
		}

	} 

	public void ClickOnGraphUnderConnectivityContext(WebDriver driver)
	{

		Log.info("ClickOnGraphUnderConnectivityContext");	
		WebDriverWait wait = new WebDriverWait(driver, 240);
		String text="";
		String text1="";
		String map="";
		String text2="";
		String text3="";
		String defaults="";
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		Actions act=new Actions(driver);
		String value=TestNGCreator.TestData.get(Esupport.Dpid.ordinal());
		try
		{
			//			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.IncidentsManagementTab()));
			if(CommonUtility.CheckpresenceofElementLocated(driver, 50, obj_PortalPage.GraphsButton()))
			{
				CommonUtility.scrollToViewElement(driver,obj_PortalPage.GraphsButton());
				map=CommonUtility.highlightElement(driver,obj_PortalPage.GraphsButton()).getText();
				System.out.println(map);
				CommonUtility.highlightElement(driver,obj_PortalPage.GraphsButton()).click(); 
				driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
				Thread.sleep(10000);
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.ConnectivityAtGlanceInGraphViewUnderConnectivityContext()));

				text2=CommonUtility.highlightElement(driver,obj_PortalPage.ConnectivityAtGlanceInGraphViewUnderConnectivityContext()).getText();
				System.out.println("header is "+text2);

				defaults=CommonUtility.highlightElement(driver,obj_PortalPage.GraphViewOfConnectivity()).getText();
				System.out.println("graph view is "+defaults);
				List<WebElement> list=driver.findElements(obj_PortalPage.PercentageOfConnectivityDisplayedInGraphView());


				for(WebElement lt:list)
				{
					if(value=="ED")
					{

						act.moveToElement(CommonUtility.highlightElement(driver, lt)).build().perform();
						CommonUtility.highlightElement(driver, lt);

					}
					else
					{
						CommonUtility.scrollToViewElement(driver, lt);

						//					act.moveToElement(CommonUtility.highlightElement(driver, lt)).build().perform();
						CommonUtility.highlightElement(driver, lt);
					}

					text=lt.getText();
					text1+=" <br> "+text;
				}
				System.out.println("percentage of connectivity displayed are "+text1);


				List<WebElement> list1=driver.findElements(obj_PortalPage.ConnectivityStatusBarDisplayedInGraphView());


				for(WebElement lt:list1)
				{
					if(value=="ED")
					{

						act.moveToElement(CommonUtility.highlightElement(driver, lt)).build().perform();
						CommonUtility.highlightElement(driver, lt);

					}
					else
					{
						CommonUtility.scrollToViewElement(driver, lt);

						//					act.moveToElement(CommonUtility.highlightElement(driver, lt)).build().perform();
						CommonUtility.highlightElement(driver, lt);
					}

					text=lt.getText();
					text3+=" <br> "+text;
				}
				System.out.println("connectivity type displayed are "+text3+" along with percentage of connectivity "+text1);

				Report.put("Click on the Graph view and validate ", 
						"user should be able to see a graph view that depicts the connectivity of the total asset base that he has access to" ,
						"user able to click on "+Report.color(map)+" and able to see heading of "+Report.color(text2)+" and <br> defaulted with "+Report.color(defaults)+" and <br> display all severity as "+Report.color(text1), "PASS");
			}
			else
			{
				System.out.println("not able to see graph icon/hyperlink");
				Report.put("Click on the Graph view and validate ", 
						"user should be able to see a graph view that depicts the connectivity of the total asset base that he has access to" ,
						"Failed to click on graph", "FAIL");

				Assert.fail();
			}

		}
		catch(Exception e)
		{
			Log.info(e);
			Report.put("Click on the Graph view and validate ", 
					"user should be able to see a graph view that depicts the connectivity of the total asset base that he has access to" ,
					"Failed to click on graph", "FAIL");
			e.printStackTrace();
			Assert.fail();
		}

	} 

	public void ClickOnFilterAndValidateOptionsUnderConnectivity(WebDriver driver)
	{

		Log.info("ClickOnFilterAndValidateOptionsUnderConnectivity");	
		WebDriverWait wait = new WebDriverWait(driver, 240);
		String text="";
		String text1="";
		String map="";
		String text2="";
		String defaults="";
		String text3="";
		String text4="";
		String text5="";
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		Actions act=new Actions(driver);
		String value=TestNGCreator.TestData.get(Esupport.Dpid.ordinal());
		try
		{
			Thread.sleep(5000);
			CommonUtility.scrollToViewElement(driver,obj_PortalPage.FilterButton());
			//			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.IncidentsManagementTab()));
			if(CommonUtility.CheckpresenceofElementLocated(driver, 50, obj_PortalPage.FilterButton()))
			{
				//				act.moveToElement(CommonUtility.highlightElement(driver, obj_PortalPage.FilterButton())).build().perform();
				CommonUtility.scrollToViewElement(driver,obj_PortalPage.FilterButton());
				map=CommonUtility.highlightElement(driver,obj_PortalPage.FilterButton()).getText();
				System.out.println(map);
				CommonUtility.highlightElement(driver,obj_PortalPage.FilterButton()).click(); 
				driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
				Thread.sleep(5000);
				driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
				//				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.ProductNameInFiltersWindow()));
				CommonUtility.scrollToViewElement(driver,obj_PortalPage.ConnectivityStatusInFilterWindow());
				text2=CommonUtility.highlightElement(driver,obj_PortalPage.ConnectivityStatusInFilterWindow()).getText();
				System.out.println("Filter is "+text2);
				CommonUtility.highlightElement(driver,obj_PortalPage.ConnectivityStatusInFilterWindow()).click();
				Thread.sleep(5000);
				driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
				CommonUtility.scrollToViewElement(driver,obj_PortalPage.ConnectivityStatusHeading());
				defaults=CommonUtility.highlightElement(driver,obj_PortalPage.ConnectivityStatusHeading()).getText();
				System.out.println("sub filter selected  is "+defaults);

				CommonUtility.scrollToViewElement(driver,obj_PortalPage.SearchBoxInFilterWindow());
				CommonUtility.highlightElement(driver,obj_PortalPage.SearchBoxInFilterWindow());

				List<WebElement> list1=driver.findElements(obj_PortalPage.OptionsUnderConnectivityStatusInFilterWindow());


				for(WebElement lt:list1)
				{
					if(value=="ED")
					{

						act.moveToElement(CommonUtility.highlightElement(driver, lt)).build().perform();
						CommonUtility.highlightElement(driver, lt);

					}
					else
					{
						CommonUtility.scrollToViewElement(driver, lt);

						//					act.moveToElement(CommonUtility.highlightElement(driver, lt)).build().perform();
						CommonUtility.highlightElement(driver, lt);
					}

					text=lt.getText();
					text5+=" <br> "+text;
				}
				System.out.println("options under connectivity filter displayed "+text5);



				Report.put("User verifies filter button and filter by connectivity types", 
						"User should be able to see current Connected, Not Connected  options" ,
						"user able to click on "+Report.color(map)+" and able to see "+Report.color(text2)+" and <br> after clicking on it, able to see sub filter options "+Report.color(text5), "PASS");
			}
			else
			{
				System.out.println("not able to see filter button or it is disabled");
				Report.put("User verifies filter button and filter by connectivity types", 
						"User should be able to see current Connected, Not Connected  options" ,
						"Failed to click on Filter button", "FAIL");

				Assert.fail();
			}

		}
		catch(Exception e)
		{
			Log.info(e);
			Report.put("User verifies filter button and filter by connectivity types", 
					"User should be able to see current Connected, Not Connected  options" ,
					"Failed to click on Filter button", "FAIL");
			e.printStackTrace();
			Assert.fail();
		}

	} 


	public void ValidateFilterAppliedInGraphViewReflectingForTabularAndMapViewUnderConnectivityContext(WebDriver driver)
	{

		Log.info("ValidateFilterAppliedInGraphViewReflectingForTabularAndMapViewUnderConnectivityContext");	
		WebDriverWait wait = new WebDriverWait(driver, 240);
		String text="";
		String text1="";
		String map="";
		String text2="";
		String defaults="";
		String text3="";
		String text4="";
		String text5="";
		String text7="";
		String text8="";
		String text9="";
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		Actions act=new Actions(driver);
		String value=TestNGCreator.TestData.get(Esupport.Dpid.ordinal());
		try
		{
			//			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.IncidentsManagementTab()));
			if(CommonUtility.CheckpresenceofElementLocated(driver, 50, obj_PortalPage.OptionsUnderConnectivityStatusInFilterWindow()))
			{
				List<WebElement> list1=driver.findElements(obj_PortalPage.OptionsUnderConnectivityStatusInFilterWindow());


				for(int i=0;i<list1.size();i++)
				{

					if(i==1)
					{
						if(value=="ED")
						{

							act.moveToElement(CommonUtility.highlightElement(driver, list1.get(i))).build().perform();
							CommonUtility.highlightElement(driver, list1.get(i)).click();

						}
						else
						{
							CommonUtility.scrollToViewElement(driver, list1.get(i));

							//					act.moveToElement(CommonUtility.highlightElement(driver, lt)).build().perform();
							CommonUtility.highlightElement(driver, list1.get(i)).click();
						}
					}
				}


				CommonUtility.scrollToViewElement(driver,obj_PortalPage.ApplySelectedInFilterWindow());
				text3=CommonUtility.highlightElement(driver,obj_PortalPage.ApplySelectedInFilterWindow()).getText();
				System.out.println("text is "+text3);

				CommonUtility.highlightElement(driver,obj_PortalPage.ApplySelectedInFilterWindow()).click();
				CommonUtility.scrollToViewElement(driver,obj_PortalPage.XButtonOnFilterWindow());
				CommonUtility.highlightElement(driver,obj_PortalPage.XButtonOnFilterWindow()).click();

				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.BackToConnectivityAtAGlanceButton()));
				text2=CommonUtility.highlightElement(driver,obj_PortalPage.BackToConnectivityAtAGlanceButton()).getText();
				System.out.println("text is "+text2);
				text5=CommonUtility.highlightElement(driver,obj_PortalPage.HeaderAfterApplyingFilter()).getText();
				System.out.println("text is "+text5);

				List<WebElement> list=driver.findElements(obj_PortalPage.TabsOnGraphViewAfterApplyingFilters());


				for(WebElement lt:list)
				{
					if(value=="ED")
					{

						act.moveToElement(CommonUtility.highlightElement(driver, lt)).build().perform();
						CommonUtility.highlightElement(driver, lt);

					}
					else
					{
						CommonUtility.scrollToViewElement(driver, lt);

						//					act.moveToElement(CommonUtility.highlightElement(driver, lt)).build().perform();
						CommonUtility.highlightElement(driver, lt);
					}

					text=lt.getText();
					text1+=" <br> "+text;
				}
				System.out.println("sub headings displayed are "+text1);

				List<WebElement> list2=driver.findElements(obj_PortalPage.BreadScrumbsOnGraphView());


				for(WebElement lt:list2)
				{
					if(value=="ED")
					{

						act.moveToElement(CommonUtility.highlightElement(driver, lt)).build().perform();
						CommonUtility.highlightElement(driver, lt);

					}
					else
					{
						CommonUtility.scrollToViewElement(driver, lt);

						//					act.moveToElement(CommonUtility.highlightElement(driver, lt)).build().perform();
						CommonUtility.highlightElement(driver, lt);
					}

					text=lt.getText();
					text4+=" <br> "+text;
				}
				System.out.println("Breadscrumbs are "+text4);

				String text6=CommonUtility.highlightElement(driver,obj_PortalPage.ViewByHeaderOnGraphViewAfterApplyingFilters()).getText();
				System.out.println("text is "+text6);

				//				CommonUtility.scrollToViewElement(driver, obj_PortalPage.TextDisplayedUnderSubHeadingForConnectivityAfterApplyingFilter());
				List<WebElement> list3=driver.findElements(obj_PortalPage.TextDisplayedUnderSubHeadingForConnectivityAfterApplyingFilter());


				for(WebElement lt:list3)
				{
					if(value=="ED")
					{

						act.moveToElement(CommonUtility.highlightElement(driver, lt)).build().perform();
						CommonUtility.highlightElement(driver, lt);

					}
					else
					{
						CommonUtility.scrollToViewElement(driver, lt);

						//					act.moveToElement(CommonUtility.highlightElement(driver, lt)).build().perform();
						CommonUtility.highlightElement(driver, lt);
					}

					text=lt.getText();
					text7+=" <br> "+text;
				}
				System.out.println("displayed bars details are "+text7);

				List<WebElement> list4=driver.findElements(obj_PortalPage.CountOfConnectivityDisplayedInGraphBars());


				for(WebElement lt:list4)
				{
					if(value=="ED")
					{

						act.moveToElement(CommonUtility.highlightElement(driver, lt)).build().perform();
						CommonUtility.highlightElement(driver, lt);

					}
					else
					{
						CommonUtility.scrollToViewElement(driver, lt);

						//					act.moveToElement(CommonUtility.highlightElement(driver, lt)).build().perform();
						CommonUtility.highlightElement(driver, lt);
					}

					text=lt.getText();
					text8+=" <br> "+text;
				}
				System.out.println("count of connectivity displayed are "+text8);

				List<WebElement> list5=driver.findElements(obj_PortalPage.HeaderOfConnectivityDisplayedInGraphBars());


				for(WebElement lt:list5)
				{
					if(value=="ED")
					{

						act.moveToElement(CommonUtility.highlightElement(driver, lt)).build().perform();
						CommonUtility.highlightElement(driver, lt);

					}
					else
					{
						CommonUtility.scrollToViewElement(driver, lt);

						//					act.moveToElement(CommonUtility.highlightElement(driver, lt)).build().perform();
						CommonUtility.highlightElement(driver, lt);
					}

					text=lt.getText();
					text9+=" <br> "+text;
				}
				System.out.println("headers displayed are "+text9+" along with percentage count "+text8);

				List<WebElement> list6=driver.findElements(obj_PortalPage.BarsOnGraphViewAfterApplyingFilters());


				for(WebElement lt:list6)
				{
					System.out.println("inside for");
					if(value=="ED")
					{

						act.moveToElement(CommonUtility.highlightElement(driver, lt)).build().perform();
						CommonUtility.highlightElement(driver, lt);

					}
					else
					{
						CommonUtility.scrollToViewElement(driver, lt);

						//					act.moveToElement(CommonUtility.highlightElement(driver, lt)).build().perform();
						CommonUtility.highlightElement(driver, lt);
					}

					System.out.println("outside for");
				}

				ClickOnTabularViewAndCheckBreadScrumbAndClickBackToGraphView(driver);
				ClickOnMapViewAndCheckBreadScrumbAndClickBackToGraphView(driver);

				Report.put("User choose a specific option in filters and click on Apply selected ", 
						"user should see graph page refresh and display selected filter and the same filters should apply to the tabular and map in the Install base" ,
						"user able to click on "+Report.color(map)+" and able to see "+Report.color(text2)+" and <br> sub filter "+Report.color(defaults)+" and after clicking "+Report.color(text3)+"<br> user able to see filters as "+Report.color(text1)+" <br> with breadscrumbs as "+Report.color(text4), "PASS");
			}
			else
			{
				System.out.println("not able to see filter options");
				Report.put("User choose a specific option in filters and click on Apply selected ", 
						"user should see graph page refresh and display selected filter and the same filters should apply to the tabular and map in the Install base" ,
						"Failed to click on see connectivity filter options", "FAIL");

				Assert.fail();
			}

		}
		catch(Exception e)
		{
			Log.info(e);
			Report.put("User choose a specific option in filters and click on Apply selected ", 
					"user should see graph page refresh and display selected filter and the same filters should apply to the tabular and map in the Install base" ,
					"Failed to click on see connectivity filter options", "FAIL");
			e.printStackTrace();
			Assert.fail();
		}

	} 

	public void ClickOnCollapseIconAtRightMostColumnInTheGridForAnyAsset(WebDriver driver)
	{

		Log.info("entering ClickOnCollapseIconAtRightMostColumnInTheGridForAnyAsset");	
		WebDriverWait wait = new WebDriverWait(driver, 240);
		String text="";
		String text1="";
		String map="";
		String text2="";
		String defaults="";
		String text3="";
		String text4="";
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		Actions act=new Actions(driver);
		String value=TestNGCreator.TestData.get(Esupport.Dpid.ordinal());
		try
		{
			System.out.println("outside iff");
			Thread.sleep(5000);
			CommonUtility.scrollToViewElement(driver, obj_PortalPage.DropDownArrowOnFirstAssetOnRightMostColumn());
			//			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.IncidentsManagementTab()));
			if(CommonUtility.CheckpresenceofElementLocated(driver, 50, obj_PortalPage.DropDownArrowOnFirstAssetOnRightMostColumn()))
			{
				System.out.println("inside iffff****");
				//				act.moveToElement(CommonUtility.highlightElement(driver, obj_PortalPage.DropDownArrowOnFirstAssetOnRightMostColumn())).build().perform();
				CommonUtility.scrollToViewElement(driver, obj_PortalPage.DropDownArrowOnFirstAssetOnRightMostColumn());

				CommonUtility.highlightElement(driver, obj_PortalPage.DropDownArrowOnFirstAssetOnRightMostColumn()).click();

				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.ImageUnderDropDownAfterDropDownArrowClicked()));
				CommonUtility.scrollToViewElement(driver, obj_PortalPage.ImageUnderDropDownAfterDropDownArrowClicked());

				CommonUtility.highlightElement(driver, obj_PortalPage.ImageUnderDropDownAfterDropDownArrowClicked());

				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.DetailsUnderAfterDropDownArrowClicked()));
				List<WebElement> list=driver.findElements(obj_PortalPage.DetailsUnderAfterDropDownArrowClicked());

				try
				{
					for(WebElement lt:list)
					{
						if(value=="ED")
						{

							act.moveToElement(CommonUtility.highlightElement(driver, lt)).build().perform();
							CommonUtility.highlightElement(driver, lt);

						}
						else
						{
							CommonUtility.scrollToViewElement(driver, lt);

							//					act.moveToElement(CommonUtility.highlightElement(driver, lt)).build().perform();
							CommonUtility.highlightElement(driver, lt);
						}

						text=lt.getText();
						text1+=" <br> "+text;
					}
					System.out.println("details in expanded view are "+text1);
				}
				catch(Exception e)
				{

				}

				Report.put("user clicks on the drop down arrow at the far right of any asset ", 
						"User should be able to see the following data points for 'CONTRACT/WARRANTY' along with the existing columns, Contract/Warranty Status,Sales order number,Service Plan Level,End Date  " ,
						"user able to see click on collapse icon and able to see details as "+Report.color(text1), "PASS");
			}
			else
			{
				System.out.println("not able to collapse icon");
				Report.put("user clicks on the drop down arrow at the far right of any asset ", 
						"User should be able to see the following data points for 'CONTRACT/WARRANTY' along with the existing columns, Contract/Warranty Status,Sales order number,Service Plan Level,End Date  " ,
						"Failed to see collapse icon", "FAIL");

				Assert.fail();
			}

		}
		catch(Exception e)
		{
			Log.info(e);
			Report.put("user clicks on the drop down arrow at the far right of any asset ", 
					"User should be able to see the following data points for 'CONTRACT/WARRANTY' along with the existing columns, Contract/Warranty Status,Sales order number,Service Plan Level,End Date  " ,
					"Failed to see collapse icon", "FAIL");
			e.printStackTrace();
			Assert.fail();
		}

	} 

	public void ClickOnAnyWhiteSpotThatIndicatesSiteLocationUnderConnectivityContextValidate(WebDriver driver)
	{

		Log.info("ClickOnAnyWhiteSpotThatIndicatesSiteLocationUnderConnectivityContextValidate");	
		WebDriverWait wait = new WebDriverWait(driver, 240);
		String text="";
		String text1="";
		String map="";
		String text2="";
		String text3="";
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		Actions act=new Actions(driver);
		String value=TestNGCreator.TestData.get(Esupport.Dpid.ordinal());
		try
		{
			CommonUtility.scrollToViewElement(driver, obj_PortalPage.ConnectivityOnLeftRailOfInstallBase());
			//			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.IncidentsManagementTab()));
			if(CommonUtility.CheckpresenceofElementLocated(driver, 50, obj_PortalPage.ConnectivityOnLeftRailOfInstallBase()))
			{
				CommonUtility.scrollToViewElement(driver, obj_PortalPage.ConnectivityOnLeftRailOfInstallBase());
				text2=CommonUtility.highlightElement(driver, obj_PortalPage.ConnectivityOnLeftRailOfInstallBase()).getText();
				System.out.println("header is "+text2);
				CommonUtility.highlightElement(driver, obj_PortalPage.ConnectivityOnLeftRailOfInstallBase()).click();

				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.WhiteSpotsThatIndicateSiteLocation()));
				try
				{
					List<WebElement> list=driver.findElements(obj_PortalPage.WhiteSpotsThatIndicateSiteLocation());
					for( int i=0;i<=list.size();i++)
					{
						if(i==0)
						{

							if(value=="ED")
							{
								CommonUtility.scrollToViewElement(driver, list.get(i));
								//							CommonUtility.highlightElement(driver, list.get(i)).click();
								WebElement element =driver.findElement(By.xpath("(//*[@class='sba-geo-map-marker sba-geo-map-circle-bubble'])["+i+"]"));
								((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);
							}
							else
							{
								CommonUtility.scrollToViewElement(driver, list.get(i));
								//						CommonUtility.highlightElement(driver, list.get(i)).click();
								//						CommonUtility.ToClickByUsingJavaScript_PassingByLoc(driver, list.get(i));
								act.moveToElement(CommonUtility.highlightElement(driver, list.get(i))).click().build().perform();
							}



							wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.HeaderOnPopUpDisplayedClickingOnWhiteSpot()));
							text1=CommonUtility.highlightElement(driver, obj_PortalPage.HeaderOnPopUpDisplayedClickingOnWhiteSpot()).getText();
							System.out.println("header is "+text1);
							List<WebElement> list1=driver.findElements(obj_PortalPage.DetailsIndisePopUpDisplayedClickingOnWhiteSpot());

							for(WebElement lt:list1)
							{
								CommonUtility.scrollToViewElement(driver, list.get(i));
								CommonUtility.highlightElement(driver, list.get(i));
								String values=lt.getText();
								System.out.println("displayed "+values);

								text+=" <br> "+values;
								break;
							}
							System.out.println("displayed values in pop are "+text);
							text3=CommonUtility.highlightElement(driver, obj_PortalPage.CircleInPopUpInMapView()).getText();
							System.out.println(text3);
						}
					}
				}

				catch(Exception e)
				{

				}


				Report.put("User navigates to the Connectivity subtab under geo view, and clicks on any white spot displayed, a pop up on the right of the popup, the user tries to view a  replica of the Connectivity HUD with data points specifically for the site", 
						"A popup with the data points  should be displayed and user  should be able see a replica of the Connectivity HUD with data points specifically for the site " ,
						"user able to click "+Report.color(text2)+" on graph view and user able to click on white spot and able to see pop up with header "+Report.color(text1)+" and able to see details displayed as "+Report.color(text)+" and HUD displays on right side of popup with value as "+Report.color(text3), "PASS");
			}
			else
			{
				System.out.println("not able to see connectivity on left side menu in TB tab");
				Report.put("User navigates to the Connectivity subtab under geo view, and clicks on any white spot displayed, a pop up on the right of the popup, the user tries to view a  replica of the Connectivity HUD with data points specifically for the site", 
						"A popup with the data points  should be displayed and user  should be able see a replica of the Connectivity HUD with data points specifically for the site " ,
						"failed to click on connectivity on left side menu", "FAIL");

				Assert.fail();
			}

		}
		catch(Exception e)
		{
			Log.info(e);
			Report.put("User navigates to the Connectivity subtab under geo view, and clicks on any white spot displayed, a pop up on the right of the popup, the user tries to view a  replica of the Connectivity HUD with data points specifically for the site", 
					"A popup with the data points  should be displayed and user  should be able see a replica of the Connectivity HUD with data points specifically for the site " ,
					"failed to click on connectivity on left side menu", "FAIL");
			e.printStackTrace();
			Assert.fail();
		}

	} 


	public void ClickOnAnyWhiteSpotThatIndicatesSiteLocationUnderCodeLevelsContextValidate(WebDriver driver)
	{

		Log.info("ClickOnAnyWhiteSpotThatIndicatesSiteLocationUnderCodeLevelsContextValidate");	
		WebDriverWait wait = new WebDriverWait(driver, 240);
		String text="";
		String text1="";
		String map="";
		String text2="";
		String text3="";
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		Actions act=new Actions(driver);
		String value=TestNGCreator.TestData.get(Esupport.Dpid.ordinal());
		try
		{
			CommonUtility.scrollToViewElement(driver, obj_PortalPage.CodeLevelsOnLeftRailOfInstallBase());
			//			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.IncidentsManagementTab()));
			if(CommonUtility.CheckpresenceofElementLocated(driver, 50, obj_PortalPage.CodeLevelsOnLeftRailOfInstallBase()))
			{
				CommonUtility.scrollToViewElement(driver, obj_PortalPage.CodeLevelsOnLeftRailOfInstallBase());
				text2=CommonUtility.highlightElement(driver, obj_PortalPage.CodeLevelsOnLeftRailOfInstallBase()).getText();
				System.out.println("header is "+text2);
				CommonUtility.highlightElement(driver, obj_PortalPage.CodeLevelsOnLeftRailOfInstallBase()).click();

				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.WhiteSpotsThatIndicateSiteLocation()));
				try
				{
					List<WebElement> list=driver.findElements(obj_PortalPage.WhiteSpotsThatIndicateSiteLocation());
					for( int i=0;i<=list.size();i++)
					{
						if(i==0)
						{

							if(value=="ED")
							{
								CommonUtility.scrollToViewElement(driver, list.get(i));
								//							CommonUtility.highlightElement(driver, list.get(i)).click();
								WebElement element =driver.findElement(By.xpath("(//*[@class='sba-geo-map-marker sba-geo-map-circle-bubble'])["+i+"]"));
								((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);
							}
							else
							{
								CommonUtility.scrollToViewElement(driver, list.get(i));
								//						CommonUtility.highlightElement(driver, list.get(i)).click();
								//						CommonUtility.ToClickByUsingJavaScript_PassingByLoc(driver, list.get(i));
//								act.moveToElement(CommonUtility.highlightElement(driver, list.get(i))).click().build().perform();
								WebElement element =driver.findElement(By.xpath("(//*[@class='sba-geo-map-marker sba-geo-map-circle-bubble'])["+i+"]"));
								((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);

							}

							wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.HeaderOnPopUpDisplayedClickingOnWhiteSpot()));
							text1=CommonUtility.highlightElement(driver, obj_PortalPage.HeaderOnPopUpDisplayedClickingOnWhiteSpot()).getText();
							System.out.println("header is "+text1);
							List<WebElement> list1=driver.findElements(obj_PortalPage.DetailsIndisePopUpDisplayedClickingOnWhiteSpot());

							for(WebElement lt:list1)
							{
								CommonUtility.scrollToViewElement(driver, list.get(i));
								CommonUtility.highlightElement(driver, list.get(i));
								String values=lt.getText();
								System.out.println("displayed "+values);

								text+=" <br> "+values;
								break;
							}
							System.out.println("displayed values in pop are "+text);
							text3=CommonUtility.highlightElement(driver, obj_PortalPage.CircleInPopUpInMapView()).getText();
							System.out.println(text3);
						}
					}
				}
				catch(Exception e)
				{

				}


				Report.put("User navigates to the Code levels subtab under geo view, and clicks on any white spot displayed, a pop up on the right of the popup, the user tries to view a  replica of the Code levels HUD with data points specifically for the site", 
						"A popup with the data points  should be displayed and user  should be able see a replica of the Code levels HUD with data points specifically for the site " ,
						"user able to click "+Report.color(text2)+" on graph view and user able to click on white spot and able to see pop up with header "+Report.color(text1)+" and able to see details displayed as "+Report.color(text)+" and HUD displays on right side of popup with value as "+Report.color(text3), "PASS");
			}
			else
			{
				System.out.println("not able to see Code levels on left side menu in TB tab");
				Report.put("User navigates to the Code levels subtab under geo view, and clicks on any white spot displayed, a pop up on the right of the popup, the user tries to view a  replica of the Code levels HUD with data points specifically for the site", 
						"A popup with the data points  should be displayed and user  should be able see a replica of the Code levels HUD with data points specifically for the site " ,
						"failed to click on Code levels on left side menu", "FAIL");

				Assert.fail();
			}

		}
		catch(Exception e)
		{
			Log.info(e);
			Report.put("User navigates to the Code levels subtab under geo view, and clicks on any white spot displayed, a pop up on the right of the popup, the user tries to view a  replica of the Code levels HUD with data points specifically for the site", 
					"A popup with the data points  should be displayed and user  should be able see a replica of the Code levels HUD with data points specifically for the site " ,
					"failed to click on Code levels on left side menu", "FAIL");
			e.printStackTrace();
			Assert.fail();
		}

	} 

	public void ClickOnAnyWhiteSpotThatIndicatesSiteLocationUnderContractsContextValidate(WebDriver driver)
	{

		Log.info("ClickOnAnyWhiteSpotThatIndicatesSiteLocationUnderContractsContextValidate");	
		WebDriverWait wait = new WebDriverWait(driver, 240);
		String text="";
		String text1="";
		String map="";
		String text2="";
		String text3="";
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		Actions act=new Actions(driver);
		String value=TestNGCreator.TestData.get(Esupport.Dpid.ordinal());
		try
		{
			CommonUtility.scrollToViewElement(driver, obj_PortalPage.ContractsOnLeftRailOfInstallBase());
			//			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.IncidentsManagementTab()));
			if(CommonUtility.CheckpresenceofElementLocated(driver, 50, obj_PortalPage.ContractsOnLeftRailOfInstallBase()))
			{
				CommonUtility.scrollToViewElement(driver, obj_PortalPage.ContractsOnLeftRailOfInstallBase());
				text2=CommonUtility.highlightElement(driver, obj_PortalPage.ContractsOnLeftRailOfInstallBase()).getText();
				System.out.println("header is "+text2);
				CommonUtility.highlightElement(driver, obj_PortalPage.ContractsOnLeftRailOfInstallBase()).click();

				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.WhiteSpotsThatIndicateSiteLocation()));
				try
				{
				List<WebElement> list=driver.findElements(obj_PortalPage.WhiteSpotsThatIndicateSiteLocation());
				for( int i=0;i<=list.size();i++)
				{
					if(i==0)
					{

						if(value=="ED")
						{
							CommonUtility.scrollToViewElement(driver, list.get(i));
							//							CommonUtility.highlightElement(driver, list.get(i)).click();
							WebElement element =driver.findElement(By.xpath("(//*[@class='sba-geo-map-marker sba-geo-map-circle-bubble'])["+i+"]"));
							((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);
						}
						else
						{
							CommonUtility.scrollToViewElement(driver, list.get(i));
//							CommonUtility.highlightElement(driver, list.get(i)).click();
							//						CommonUtility.ToClickByUsingJavaScript_PassingByLoc(driver, list.get(i));
//							act.moveToElement(CommonUtility.highlightElement(driver, list.get(i))).click().build().perform();
							WebElement element =driver.findElement(By.xpath("(//*[@class='sba-geo-map-marker sba-geo-map-circle-bubble'])["+i+"]"));
							((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);
						}

						wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.HeaderOnPopUpDisplayedClickingOnWhiteSpot()));
						text1=CommonUtility.highlightElement(driver, obj_PortalPage.HeaderOnPopUpDisplayedClickingOnWhiteSpot()).getText();
						System.out.println("header is "+text1);
						List<WebElement> list1=driver.findElements(obj_PortalPage.DetailsIndisePopUpDisplayedClickingOnWhiteSpot());

						for(WebElement lt:list1)
						{
							Thread.sleep(5000);
							CommonUtility.scrollToViewElement(driver, list.get(i));
							CommonUtility.highlightElement(driver, list.get(i));
							String values=lt.getText();
							System.out.println("displayed "+values);

							text+=" <br> "+values;
							break;
						}
						System.out.println("displayed values in pop are "+text);
						text3=CommonUtility.highlightElement(driver, obj_PortalPage.CircleInPopUpInMapView()).getText();
						System.out.println(text3);
					}
				}
				}
				catch(Exception e)
				{
					
				}


				Report.put("User navigates to the Contracts subtab under geo view, and clicks on any white spot displayed, a pop up on the right of the popup, the user tries to view a  replica of the Contracts HUD with data points specifically for the site", 
						"A popup with the data points  should be displayed and user  should be able see a replica of the Contracts HUD with data points specifically for the site " ,
						"user able to click "+Report.color(text2)+" on graph view and user able to click on white spot and able to see pop up with header "+Report.color(text1)+" and able to see details displayed as "+Report.color(text)+" and HUD displays on right side of popup with value as "+Report.color(text3), "PASS");
			}
			else
			{
				System.out.println("not able to see Contracts on left side menu in TB tab");
				Report.put("User navigates to the Contracts subtab under geo view, and clicks on any white spot displayed, a pop up on the right of the popup, the user tries to view a  replica of the Contracts HUD with data points specifically for the site", 
						"A popup with the data points  should be displayed and user  should be able see a replica of the Contracts HUD with data points specifically for the site " ,
						"failed to click on Contracts on left side menu", "FAIL");

				Assert.fail();
			}

		}
		catch(Exception e)
		{
			Log.info(e);
			Report.put("User navigates to the Contracts subtab under geo view, and clicks on any white spot displayed, a pop up on the right of the popup, the user tries to view a  replica of the Contracts HUD with data points specifically for the site", 
					"A popup with the data points  should be displayed and user  should be able see a replica of the Contracts HUD with data points specifically for the site " ,
					"failed to click on Contracts on left side menu", "FAIL");
			e.printStackTrace();
			Assert.fail();
		}

	} 


	public void ValidateFilterConnectedAppliedInMapViewUnderConnectivityContextAndValidateHUDInWhiteSpotPopUpHUD(WebDriver driver)
	{

		Log.info("ValidateFilterConnectedAppliedInMapViewUnderConnectivityContextAndValidateHUDInWhiteSpotPopUpHUD");	
		WebDriverWait wait = new WebDriverWait(driver, 240);
		String text="";
		String text1="";
		String map="";
		String text2="";
		String defaults="";
		String text3="";
		String text4="";
		String text5="";
		String text7="";
		String text8="";
		String text9="";
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		Actions act=new Actions(driver);
		String value=TestNGCreator.TestData.get(Esupport.Dpid.ordinal());
		try
		{
			//			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.IncidentsManagementTab()));
			if(CommonUtility.CheckpresenceofElementLocated(driver, 50, obj_PortalPage.OptionsUnderConnectivityStatusInFilterWindow()))
			{
				List<WebElement> list1=driver.findElements(obj_PortalPage.OptionsUnderConnectivityStatusInFilterWindow());


				for(int i=0;i<list1.size();i++)
				{

					if(i==1)
					{
						if(value=="ED")
						{

							act.moveToElement(CommonUtility.highlightElement(driver, list1.get(i))).build().perform();
							CommonUtility.highlightElement(driver, list1.get(i)).click();

						}
						else
						{
							CommonUtility.scrollToViewElement(driver, list1.get(i));

							//					act.moveToElement(CommonUtility.highlightElement(driver, lt)).build().perform();
							CommonUtility.highlightElement(driver, list1.get(i)).click();
						}
					}
				}


				CommonUtility.scrollToViewElement(driver,obj_PortalPage.ApplySelectedInFilterWindow());
				text3=CommonUtility.highlightElement(driver,obj_PortalPage.ApplySelectedInFilterWindow()).getText();
				System.out.println("text is "+text3);

				CommonUtility.highlightElement(driver,obj_PortalPage.ApplySelectedInFilterWindow()).click();
				CommonUtility.scrollToViewElement(driver,obj_PortalPage.XButtonOnFilterWindow());
				CommonUtility.highlightElement(driver,obj_PortalPage.XButtonOnFilterWindow()).click();

				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.BreadScrumbsOnGraphView()));


				List<WebElement> list2=driver.findElements(obj_PortalPage.BreadScrumbsOnGraphView());


				for(WebElement lt:list2)
				{
					if(value=="ED")
					{

						act.moveToElement(CommonUtility.highlightElement(driver, lt)).build().perform();
						CommonUtility.highlightElement(driver, lt);

					}
					else
					{
						CommonUtility.scrollToViewElement(driver, lt);

						//					act.moveToElement(CommonUtility.highlightElement(driver, lt)).build().perform();
						CommonUtility.highlightElement(driver, lt);
					}

					text=lt.getText();
					text4+=" <br> "+text;
				}
				System.out.println("Breadscrumbs are "+text4);

				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.WhiteSpotsThatIndicateSiteLocation()));
				List<WebElement> list=driver.findElements(obj_PortalPage.WhiteSpotsThatIndicateSiteLocation());
				for( int i=0;i<=list.size();i++)
				{
					if(i==0)
					{

						if(value=="ED")
						{
							CommonUtility.scrollToViewElement(driver, list.get(i));
							//							CommonUtility.highlightElement(driver, list.get(i)).click();
							WebElement element =driver.findElement(By.xpath("(//*[@class='sba-geo-map-marker sba-geo-map-circle-bubble'])["+i+"]"));
							((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);
						}
						else
						{
							CommonUtility.scrollToViewElement(driver, list.get(i));
							//						CommonUtility.highlightElement(driver, list.get(i)).click();
							//						CommonUtility.ToClickByUsingJavaScript_PassingByLoc(driver, list.get(i));
							act.moveToElement(CommonUtility.highlightElement(driver, list.get(i))).click().build().perform();
						}

						wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.HeaderOnPopUpDisplayedClickingOnWhiteSpot()));
						text1=CommonUtility.highlightElement(driver, obj_PortalPage.HeaderOnPopUpDisplayedClickingOnWhiteSpot()).getText();
						System.out.println("header is "+text1);
						List<WebElement> list3=driver.findElements(obj_PortalPage.DetailsIndisePopUpDisplayedClickingOnWhiteSpot());

						for(WebElement lt:list3)
						{
							CommonUtility.scrollToViewElement(driver, list.get(i));
							CommonUtility.highlightElement(driver, list.get(i));
							String values=lt.getText();
							System.out.println("displayed "+values);

							text+=" <br> "+values;
							break;
						}
						System.out.println("details are "+text);
						CommonUtility.highlightElement(driver, obj_PortalPage.ScrollToElementOnHUDInPopUp());
						text2=CommonUtility.highlightElement(driver, obj_PortalPage.CircleInPopUpInMapView()).getText();
						System.out.println(text2);

						if(!(text2.contains("100%")))
						{
							System.out.println("not able to filtered connected data in HUD");
							Report.put("User choose to filter by 'Connected' and then switches to the Geoview.", 
									"The popup for a site will only show the Connected data for that site" ,
									"Failed to display filtered connected data in HUD in the popup", "FAIL");

							Assert.fail();
						}


					}
				}

				Report.put("User choose to filter by 'Connected' and then switches to the Geoview.", 
						"The popup for a site will only show the Connected data for that site" ,
						"user able to click on connected and able to see with breadscrumbs as "+Report.color(text4)+" and clicks on first white spot and able to see details as "+Report.color(text)+" <br> and able to see HUD on pop up disaplay only "+Report.color(text2), "PASS");
			}
			else
			{
				System.out.println("not able to see filter options");
				Report.put("User choose to filter by 'Connected' and then switches to the Geoview.", 
						"The popup for a site will only show the Connected data for that site" ,
						"Failed to click on connectivity filter options", "FAIL");

				Assert.fail();
			}

		}
		catch(Exception e)
		{
			Log.info(e);
			Report.put("User choose to filter by 'Connected' and then switches to the Geoview.", 
					"The popup for a site will only show the Connected data for that site" ,
					"Failed to click on connectivity filter options", "FAIL");
			e.printStackTrace();
			Assert.fail();
		}

	} 

	public void ClickOnFilterAndApplyAnyFilterWhichRsultsInConnectedAssetsZeroAndValidateSameInHUDInPopUp(WebDriver driver)
	{

		Log.info("ClickOnFilterAndApplyAnyFilterWhichRsultsInConnectedAssetsZeroAndValidateSameInHUDInPopUp");	
		WebDriverWait wait = new WebDriverWait(driver, 240);
		String text="";
		String text1="";
		String map="";
		String text2="";
		String defaults="";
		String text3="";
		String text4="";
		String text5="";
		String text6="";
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		Actions act=new Actions(driver);
		String value=TestNGCreator.TestData.get(Esupport.Dpid.ordinal());
		try
		{
			CommonUtility.scrollToViewElement(driver,obj_PortalPage.FilterButton());
			//			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.IncidentsManagementTab()));
			if(CommonUtility.CheckpresenceofElementLocated(driver, 50, obj_PortalPage.FilterButton()))
			{
				CommonUtility.scrollToViewElement(driver,obj_PortalPage.FilterButton());
				map=CommonUtility.highlightElement(driver,obj_PortalPage.FilterButton()).getText();
				System.out.println(map);
				CommonUtility.highlightElement(driver,obj_PortalPage.FilterButton()).click(); 
				driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
				Thread.sleep(5000);
				driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
				//				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.ProductNameInFiltersWindow()));
				CommonUtility.scrollToViewElement(driver,obj_PortalPage.ProductNameInFiltersWindow());
				text2=CommonUtility.highlightElement(driver,obj_PortalPage.ProductNameInFiltersWindow()).getText();
				System.out.println("Filter is "+text2);
				CommonUtility.highlightElement(driver,obj_PortalPage.ProductNameInFiltersWindow()).click();
				Thread.sleep(5000);
				driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
				CommonUtility.scrollToViewElement(driver,obj_PortalPage.AppSyncOptionUnderProductNameInFilterWindow());
				defaults=CommonUtility.highlightElement(driver,obj_PortalPage.AppSyncOptionUnderProductNameInFilterWindow()).getText();
				System.out.println("sub filter selected  is "+defaults);

				CommonUtility.highlightElement(driver,obj_PortalPage.AppSyncOptionUnderProductNameInFilterWindow()).click();

				CommonUtility.scrollToViewElement(driver,obj_PortalPage.ApplySelectedInFilterWindow());
				text3=CommonUtility.highlightElement(driver,obj_PortalPage.ApplySelectedInFilterWindow()).getText();
				System.out.println("text is "+text3);

				CommonUtility.highlightElement(driver,obj_PortalPage.ApplySelectedInFilterWindow()).click();
				CommonUtility.scrollToViewElement(driver,obj_PortalPage.XButtonOnFilterWindow());
				CommonUtility.highlightElement(driver,obj_PortalPage.XButtonOnFilterWindow()).click();

				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.BreadScrumbsOnGraphView()));


				List<WebElement> list2=driver.findElements(obj_PortalPage.BreadScrumbsOnGraphView());


				for(WebElement lt:list2)
				{
					if(value=="ED")
					{

						act.moveToElement(CommonUtility.highlightElement(driver, lt)).build().perform();
						CommonUtility.highlightElement(driver, lt);

					}
					else
					{
						CommonUtility.scrollToViewElement(driver, lt);

						//					act.moveToElement(CommonUtility.highlightElement(driver, lt)).build().perform();
						CommonUtility.highlightElement(driver, lt);
					}

					text=lt.getText();
					text4+=" <br> "+text;
				}
				System.out.println("Breadscrumbs are "+text4);

				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.WhiteSpotsThatIndicateSiteLocation()));
				List<WebElement> list=driver.findElements(obj_PortalPage.WhiteSpotsThatIndicateSiteLocation());
				for( int i=0;i<=list.size();i++)
				{
					if(i==0)
					{

						if(value=="ED")
						{
							CommonUtility.scrollToViewElement(driver, list.get(i));
							//							CommonUtility.highlightElement(driver, list.get(i)).click();
							WebElement element =driver.findElement(By.xpath("(//*[@class='sba-geo-map-marker sba-geo-map-circle-bubble'])["+i+"]"));
							((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);
						}
						else
						{
							CommonUtility.scrollToViewElement(driver, list.get(i));
							//						CommonUtility.highlightElement(driver, list.get(i)).click();
							//						CommonUtility.ToClickByUsingJavaScript_PassingByLoc(driver, list.get(i));
							act.moveToElement(CommonUtility.highlightElement(driver, list.get(i))).click().build().perform();
						}

						wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.HeaderOnPopUpDisplayedClickingOnWhiteSpot()));
						text1=CommonUtility.highlightElement(driver, obj_PortalPage.HeaderOnPopUpDisplayedClickingOnWhiteSpot()).getText();
						System.out.println("header is "+text1);
						List<WebElement> list3=driver.findElements(obj_PortalPage.DetailsIndisePopUpDisplayedClickingOnWhiteSpot());

						for(WebElement lt:list3)
						{
							CommonUtility.scrollToViewElement(driver, list.get(i));
							CommonUtility.highlightElement(driver, list.get(i));
							String values=lt.getText();
							System.out.println("displayed "+values);

							text5+=" <br> "+values;
							break;
						}
						System.out.println("details are "+text5);
						CommonUtility.highlightElement(driver, obj_PortalPage.ScrollToElementOnHUDInPopUp());
						text6=CommonUtility.highlightElement(driver, obj_PortalPage.CircleInPopUpInMapView()).getText();
						System.out.println(text6);

						if(!(text6.contains("0%")))
						{
							System.out.println("not able to see 0% connected in HUD");
							Report.put("User chooses to filter by Product Family or another filter which results in Connected assets equals 0 for a site", 
									"The popup for a site will only show the Not Connected and other data for that site." ,
									"Failed to display 0% connected in HUD in popup", "FAIL");

							Assert.fail();
						}


					}
				}

				Report.put("User chooses to filter by Product Family or another filter which results in Connected assets equals 0 for a site", 
						"The popup for a site will only show the Not Connected and other data for that site." ,
						"user able to click on "+Report.color(map)+" and able to see "+Report.color(text2)+" and <br> sub filter "+Report.color(defaults)+" and after clicking "+Report.color(text3)+"<br> user able to see filters as "+Report.color(text1)+" <br> with breadscrumbs as "+Report.color(text4)+" <br> and able to see details in popup displayed clicking on whitespot "+Report.color(text5)+" <br> and able to see HUD text as "+Report.color(text6), "PASS");
			}
			else
			{
				System.out.println("not ble to see filter button or it is disabled");
				Report.put("User chooses to filter by Product Family or another filter which results in Connected assets equals 0 for a site", 
						"The popup for a site will only show the Not Connected and other data for that site." ,
						"Failed to click on Filter button", "FAIL");

				Assert.fail();
			}

		}
		catch(Exception e)
		{
			Log.info(e);
			Report.put("User chooses to filter by Product Family or another filter which results in Connected assets equals 0 for a site", 
					"The popup for a site will only show the Not Connected and other data for that site." ,
					"Failed to click on Filter button", "FAIL");
			e.printStackTrace();
			Assert.fail();
		}

	} 
	
	public void ClickOnClearAllAtBreadScrumb(WebDriver driver)
	{

		Log.info("Entering ClickOnClearAllAtBreadScrumb");	
		WebDriverWait wait = new WebDriverWait(driver, 240);
		String text="";
		String text1="";
		String map="";
		String text2="";
		String defaults="";
		String text3="";
		String text4="";
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		Actions act=new Actions(driver);
		String value=TestNGCreator.TestData.get(Esupport.Dpid.ordinal());
		try
		{
			CommonUtility.ScrollTo(driver, obj_PortalPage.ClearAllHyperlinkOnFilterBreadscrumb());
			//			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.IncidentsManagementTab()));
			if(CommonUtility.CheckpresenceofElementLocated(driver, 50, obj_PortalPage.ClearAllHyperlinkOnFilterBreadscrumb()))
			{
				CommonUtility.ScrollTo(driver, obj_PortalPage.ClearAllHyperlinkOnFilterBreadscrumb());
				text2=CommonUtility.highlightElement(driver, obj_PortalPage.ClearAllHyperlinkOnFilterBreadscrumb()).getText();
				System.out.println(text2);
				CommonUtility.ClickOn(driver, obj_PortalPage.ClearAllHyperlinkOnFilterBreadscrumb());
//				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.HeadingsOfTable1()));
//				List<WebElement> list=driver.findElements(obj_PortalPage.HeadingsOfTable1());
//
//				try
//				{
//					for(int i=0;i<list.size();i++)
//
//					{
//						if(i==1)
//						{
//
//							if(value=="ED")
//							{
//
//								act.moveToElement(CommonUtility.highlightElement(driver, list.get(i))).build().perform();
////								CommonUtility.highlightElement(driver, list.get(i));
//								CommonUtility.highlightElement(driver, list.get(i)).click();
//
//
//							}
//							else
//							{
//								//act.moveToElement(CommonUtility.highlightElement(driver, lt)).build().perform();
//
//								//act.moveToElement(CommonUtility.highlightElement(driver, lt)).build().perform();
//								CommonUtility.highlightElement(driver, list.get(i));
//								CommonUtility.highlightElement(driver, list.get(i)).click();
//							}
//
//
//						}
//					}
//
//				}
//				catch(Exception e)
//				{
//
//				}
				Report.put("User clicks on clear all button at breadscrumb", 
						"user should be able to click on clear all button at breadscrumb" ,
						"able to click on "+Report.color(text2), "PASS");

			}
			else
			{
				System.out.println("not able to click on clear all");
				Report.put("User clicks on clear all button at breadscrumb", 
						"user should be able to click on clear all button at breadscrumb" ,
						"Failed to see cclear all", "FAIL");

				Assert.fail();
			}

		}
		catch(Exception e)
		{
			Log.info(e);
			Report.put("User clicks on clear all button at breadscrumb", 
					"user should be able to click on clear all button at breadscrumb" ,
					"Failed to see cclear all", "FAIL");
			e.printStackTrace();
			Assert.fail();
		}

	} 
	
	
	public void ClickOnAssetCircleInHUDAndValidateGridChangesUnderInstallBaseContext(WebDriver driver)
	{

		Log.info("Entering ClickOnAssetCircleInHUDAndValidateGridChangesUnderInstallBaseContext");	
		WebDriverWait wait = new WebDriverWait(driver, 240);
		String text="";
		String text1="";
		String map="";
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		Actions act=new Actions(driver);
		String value=TestNGCreator.TestData.get(Esupport.Dpid.ordinal());
		try
		{
//			CommonUtility.scrollToViewElement(driver,obj_PortalPage.AssetsCircleOnHUDForIBContext());
//			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.IncidentsManagementTab()));
			if(CommonUtility.CheckpresenceofElementLocated(driver, 50, obj_PortalPage.AssetsCircleOnHUDForIBContext()))
			{
//				act.moveToElement(CommonUtility.highlightElement(driver,obj_PortalPage.AssetsCircleOnHUDForIBContext())).build().perform();
				CommonUtility.scrollToViewElement(driver,obj_PortalPage.AssetsCircleOnHUDForIBContext());
				map=CommonUtility.highlightElement(driver,obj_PortalPage.AssetsCircleOnHUDForIBContext()).getText();
				System.out.println(map);
//				CommonUtility.highlightElement(driver,obj_PortalPage.AssetsCircleOnHUDForIBContext()).click(); 
				CommonUtility.ToClickByUsingJavaScript_PassingByLoc(driver,obj_PortalPage.AssetsCircleOnHUDForIBContext());
//				act.moveToElement(CommonUtility.highlightElement(driver,obj_PortalPage.AssetsCircleOnHUDForIBContext())).click().build().perform();
//				WebElement element =driver.findElement(obj_PortalPage.AssetsCircleOnHUDForIBContext());
				Thread.sleep(2000);
//				((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);
				
				driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
				Thread.sleep(5000);
				
				ValidateGridRefreshWithDataAfterClickingAssetsHUD(driver);


				Report.put("user clicks on the of the below HUDS :Total Assets,Connectivity,Code Levels,Contracts ", 
						"user should be able to click on the HUDS of the below subtabs and should be able to view the data & value  on the summary perspective options  in the grid:Total Assets,Connectivity,Code Levels,Contracts" ,
						"user able to click on "+Report.color(map)+" and able to data and value on the summary view refreshed to clicked type in HUD", "PASS");
			}
			else
			{
				System.out.println("not able to see Assets in HUD");
				Report.put("user clicks on the of the below HUDS :Total Assets,Connectivity,Code Levels,Contracts ", 
						"user should be able to click on the HUDS of the below subtabs and should be able to view the data & value  on the summary perspective options  in the grid:Total Assets,Connectivity,Code Levels,Contracts" ,
						"Failed to click on Assets in HUD", "FAIL");

				Assert.fail();
			}

		}
		catch(Exception e)
		{
			Log.info(e);
			Report.put("user clicks on the of the below HUDS :Total Assets,Connectivity,Code Levels,Contracts ", 
					"user should be able to click on the HUDS of the below subtabs and should be able to view the data & value  on the summary perspective options  in the grid:Total Assets,Connectivity,Code Levels,Contracts" ,
					"Failed to click on Assets in HUD", "FAIL");
			e.printStackTrace();
			Assert.fail();
		}

	} 
	
	public void ClickOnConnectivityCircleInHUDAndValidateGridChangesUnderInstallBaseContext(WebDriver driver)
	{

		Log.info("Entering ClickOnConnectivityCircleInHUDAndValidateGridChangesUnderInstallBaseContext");	
		WebDriverWait wait = new WebDriverWait(driver, 240);
		String text="";
		String text1="";
		String map="";
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		Actions act=new Actions(driver);
		String value=TestNGCreator.TestData.get(Esupport.Dpid.ordinal());
		try
		{
			//			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.IncidentsManagementTab()));
			if(CommonUtility.CheckpresenceofElementLocated(driver, 50, obj_PortalPage.ConnectivityOnLeftRailOfInstallBase()))
			{
				CommonUtility.scrollToViewElement(driver,obj_PortalPage.ConnectivityOnLeftRailOfInstallBase());
				map=CommonUtility.highlightElement(driver,obj_PortalPage.ConnectivityOnLeftRailOfInstallBase()).getText();
				System.out.println(map);
				CommonUtility.highlightElement(driver,obj_PortalPage.ConnectivityOnLeftRailOfInstallBase()).click(); 
				driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
				Thread.sleep(10000);
				
				ValidateGridRefreshWithDataAfterClickingConnectivityHUD(driver);


				Report.put("user clicks on the of the below HUDS :Total Assets,Connectivity,Code Levels,Contracts ", 
						"user should be able to click on the HUDS of the below subtabs and should be able to view the data & value  on the summary perspective options  in the grid:Total Assets,Connectivity,Code Levels,Contracts" ,
						"user able to click on "+Report.color(map)+" and able to data and value on the summary view refreshed to clicked type in HUD", "PASS");
			}
			else
			{
				System.out.println("not able to see connectivity in HUD");
				Report.put("user clicks on the of the below HUDS :Total Assets,Connectivity,Code Levels,Contracts ", 
						"user should be able to click on the HUDS of the below subtabs and should be able to view the data & value  on the summary perspective options  in the grid:Total Assets,Connectivity,Code Levels,Contracts" ,
						"Failed to click on connectivity in HUD", "FAIL");

				Assert.fail();
			}

		}
		catch(Exception e)
		{
			Log.info(e);
			Report.put("user clicks on the of the below HUDS :Total Assets,Connectivity,Code Levels,Contracts ", 
					"user should be able to click on the HUDS of the below subtabs and should be able to view the data & value  on the summary perspective options  in the grid:Total Assets,Connectivity,Code Levels,Contracts" ,
					"Failed to click on connectivity in HUD", "FAIL");
			e.printStackTrace();
			Assert.fail();
		}

	} 
	
	public void ClickOnCodeLevelsCircleInHUDAndValidateGridChangesUnderInstallBaseContext(WebDriver driver)
	{

		Log.info("Entering ClickOnCodeLevelsCircleInHUDAndValidateGridChangesUnderInstallBaseContext");	
		WebDriverWait wait = new WebDriverWait(driver, 240);
		String text="";
		String text1="";
		String map="";
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		Actions act=new Actions(driver);
		String value=TestNGCreator.TestData.get(Esupport.Dpid.ordinal());
		try
		{
			//			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.IncidentsManagementTab()));
			if(CommonUtility.CheckpresenceofElementLocated(driver, 50, obj_PortalPage.CodeLevelsOnLeftRailOfInstallBase()))
			{
				CommonUtility.scrollToViewElement(driver,obj_PortalPage.CodeLevelsOnLeftRailOfInstallBase());
				map=CommonUtility.highlightElement(driver,obj_PortalPage.CodeLevelsOnLeftRailOfInstallBase()).getText();
				System.out.println(map);
				CommonUtility.highlightElement(driver,obj_PortalPage.CodeLevelsOnLeftRailOfInstallBase()).click(); 
				driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
				Thread.sleep(10000);
				
				ValidateGridRefreshWithDataAfterClickingCodeLevelsHUD(driver);


				Report.put("user clicks on the of the below HUDS :Total Assets,Connectivity,Code Levels,Contracts ", 
						"user should be able to click on the HUDS of the below subtabs and should be able to view the data & value  on the summary perspective options  in the grid:Total Assets,Connectivity,Code Levels,Contracts" ,
						"user able to click on "+Report.color(map)+" and able to data and value on the summary view refreshed to clicked type in HUD", "PASS");
			}
			else
			{
				System.out.println("not able to see code leves in HUD");
				Report.put("user clicks on the of the below HUDS :Total Assets,Connectivity,Code Levels,Contracts ", 
						"user should be able to click on the HUDS of the below subtabs and should be able to view the data & value  on the summary perspective options  in the grid:Total Assets,Connectivity,Code Levels,Contracts" ,
						"Failed to click on code leves in HUD", "FAIL");

				Assert.fail();
			}

		}
		catch(Exception e)
		{
			Log.info(e);
			Report.put("user clicks on the of the below HUDS :Total Assets,Connectivity,Code Levels,Contracts ", 
					"user should be able to click on the HUDS of the below subtabs and should be able to view the data & value  on the summary perspective options  in the grid:Total Assets,Connectivity,Code Levels,Contracts" ,
					"Failed to click on code leves in HUD", "FAIL");
			e.printStackTrace();
			Assert.fail();
		}

	} 
	
	public void ClickOnContractsCircleInHUDAndValidateGridChangesUnderInstallBaseContext(WebDriver driver)
	{

		Log.info("Entering ClickOnContractsCircleInHUDAndValidateGridChangesUnderInstallBaseContext");	
		WebDriverWait wait = new WebDriverWait(driver, 240);
		String text="";
		String text1="";
		String map="";
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		Actions act=new Actions(driver);
		String value=TestNGCreator.TestData.get(Esupport.Dpid.ordinal());
		try
		{
			//			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.IncidentsManagementTab()));
			if(CommonUtility.CheckpresenceofElementLocated(driver, 50, obj_PortalPage.ContractsOnLeftRailOfInstallBase()))
			{
				CommonUtility.scrollToViewElement(driver,obj_PortalPage.ContractsOnLeftRailOfInstallBase());
				map=CommonUtility.highlightElement(driver,obj_PortalPage.ContractsOnLeftRailOfInstallBase()).getText();
				System.out.println(map);
				CommonUtility.highlightElement(driver,obj_PortalPage.ContractsOnLeftRailOfInstallBase()).click(); 
				driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
				Thread.sleep(10000);
				
				ValidateGridRefreshWithDataAfterClickingContractsHUD(driver);


				Report.put("user clicks on the of the below HUDS :Total Assets,Connectivity,Code Levels,Contracts ", 
						"user should be able to click on the HUDS of the below subtabs and should be able to view the data & value  on the summary perspective options  in the grid:Total Assets,Connectivity,Code Levels,Contracts" ,
						"user able to click on "+Report.color(map)+" and able to data and value on the summary view refreshed to clicked type in HUD", "PASS");
			}
			else
			{
				System.out.println("not able to see contracts in HUD");
				Report.put("user clicks on the of the below HUDS :Total Assets,Connectivity,Code Levels,Contracts ", 
						"user should be able to click on the HUDS of the below subtabs and should be able to view the data & value  on the summary perspective options  in the grid:Total Assets,Connectivity,Code Levels,Contracts" ,
						"Failed to click on contracts in HUD", "FAIL");

				Assert.fail();
			}

		}
		catch(Exception e)
		{
			Log.info(e);
			Report.put("user clicks on the of the below HUDS :Total Assets,Connectivity,Code Levels,Contracts ", 
					"user should be able to click on the HUDS of the below subtabs and should be able to view the data & value  on the summary perspective options  in the grid:Total Assets,Connectivity,Code Levels,Contracts" ,
					"Failed to click on contracts in HUD", "FAIL");
			e.printStackTrace();
			Assert.fail();
		}

	} 
	
	
	public void ValidateGridRefreshWithDataAfterClickingConnectivityHUD(WebDriver driver)
	{

		Log.info("Entering ValidateGridRefreshWithDataAfterClickingConnectivityHUD");	
		WebDriverWait wait = new WebDriverWait(driver, 240);
		String text="";
		String text1="";
		String map="";
		String text2="";
		String defaults="";
		String text3="";
		String text4="";
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		Actions act=new Actions(driver);
		String value=TestNGCreator.TestData.get(Esupport.Dpid.ordinal());
		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.ConnectivityOnLeftRailOfInstallBaseForActiveValidation()));
			if(CommonUtility.CheckpresenceofElementLocated(driver, 50, obj_PortalPage.ConnectivityOnLeftRailOfInstallBaseForActiveValidation()))
			{
				CommonUtility.scrollToViewElement(driver, obj_PortalPage.ConnectivityOnLeftRailOfInstallBaseForActiveValidation());
				text2=CommonUtility.highlightElement(driver, obj_PortalPage.ConnectivityOnLeftRailOfInstallBaseForActiveValidation()).getText();
				System.out.println(text2);

//				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.HeadingsOfTable1()));
				List<WebElement> list=driver.findElements(obj_PortalPage.HeadingsOfTable1());

				try
				{
					for(WebElement lt:list)
					{
						if(value=="ED")
						{

							act.moveToElement(CommonUtility.highlightElement(driver, lt)).build().perform();
							CommonUtility.highlightElement(driver, lt);

						}
						else
						{
							CommonUtility.scrollToViewElement(driver, lt);

							//					act.moveToElement(CommonUtility.highlightElement(driver, lt)).build().perform();
							CommonUtility.highlightElement(driver, lt);
						}

						text=lt.getText();
						text1+=" <br> "+text;
					}
					System.out.println("columns are "+text1);
				}
				catch(Exception e)
				{

				}

				Report.put("system display grid with following columns when user is in connectivity from left menu :PRODUCT ID,PRODUCT NAME ,SITE ID, CUSTOMER NAME ,PRODUCT NICKNAME,CONNECTION STATUS,CONNECTION TYPE,CONNECTION AGE ,LAST CONNECTED", 
						"user should be able to see a grid with columns:PRODUCT ID,PRODUCT NAME ,SITE ID, CUSTOMER NAME ,PRODUCT NICKNAME,CONNECTION STATUS,CONNECTION TYPE,CONNECTION AGE ,LAST CONNECTED" ,
						"user able to see tabs grid columns as "+Report.color(text1), "PASS");
			}
			else
			{
				System.out.println("not able to see columns in grid");
				Report.put("system display grid with following columns when user is in connectivity from left menu :PRODUCT ID,PRODUCT NAME ,SITE ID, CUSTOMER NAME ,PRODUCT NICKNAME,CONNECTION STATUS,CONNECTION TYPE,CONNECTION AGE ,LAST CONNECTED", 
						"user should be able to see a grid with columns:PRODUCT ID,PRODUCT NAME ,SITE ID, CUSTOMER NAME ,PRODUCT NICKNAME,CONNECTION STATUS,CONNECTION TYPE,CONNECTION AGE ,LAST CONNECTED" ,
						"Failed to see columns in grid", "FAIL");

				Assert.fail();
			}

		}
		catch(Exception e)
		{
			Log.info(e);
			Report.put("system display grid with following columns when user is in connectivity from left menu :PRODUCT ID,PRODUCT NAME ,SITE ID, CUSTOMER NAME ,PRODUCT NICKNAME,CONNECTION STATUS,CONNECTION TYPE,CONNECTION AGE ,LAST CONNECTED", 
					"user should be able to see a grid with columns:PRODUCT ID,PRODUCT NAME ,SITE ID, CUSTOMER NAME ,PRODUCT NICKNAME,CONNECTION STATUS,CONNECTION TYPE,CONNECTION AGE ,LAST CONNECTED" ,
					"Failed to see columns in grid", "FAIL");
			e.printStackTrace();
			Assert.fail();
		}

	} 
	
	public void ValidateGridRefreshWithDataAfterClickingCodeLevelsHUD(WebDriver driver)
	{

		Log.info("Entering ValidateGridRefreshWithDataAfterClickingCodeLevelsHUD");	
		WebDriverWait wait = new WebDriverWait(driver, 240);
		String text="";
		String text1="";
		String map="";
		String text2="";
		String defaults="";
		String text3="";
		String text4="";
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		Actions act=new Actions(driver);
		String value=TestNGCreator.TestData.get(Esupport.Dpid.ordinal());
		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.CodeLevelsOnLeftRailOfInstallBaseForActiveValidation()));
			if(CommonUtility.CheckpresenceofElementLocated(driver, 50, obj_PortalPage.CodeLevelsOnLeftRailOfInstallBaseForActiveValidation()))
			{
				CommonUtility.scrollToViewElement(driver, obj_PortalPage.CodeLevelsOnLeftRailOfInstallBaseForActiveValidation());
				text2=CommonUtility.highlightElement(driver, obj_PortalPage.CodeLevelsOnLeftRailOfInstallBaseForActiveValidation()).getText();
				System.out.println(text2);
				
//				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.HeadingsOfTable1()));
				List<WebElement> list=driver.findElements(obj_PortalPage.HeadingsOfTable1());

				try
				{
					for(WebElement lt:list)
					{
						if(value=="ED")
						{

							act.moveToElement(CommonUtility.highlightElement(driver, lt)).build().perform();
							CommonUtility.highlightElement(driver, lt);

						}
						else
						{
							CommonUtility.scrollToViewElement(driver, lt);

							//					act.moveToElement(CommonUtility.highlightElement(driver, lt)).build().perform();
							CommonUtility.highlightElement(driver, lt);
						}

						text=lt.getText();
						text1+=" <br> "+text;
					}
					System.out.println("columns are "+text1);
				}
				catch(Exception e)
				{

				}
				Report.put("system display grid with following columns when user is in code levels from left menu :PRODUCT ID,PRODUCT NAME ,SITE ID, CUSTOMER NAME ,PRODUCT NICKNAME,CODE LEVEL,TARGET -1 CODE,TARGET+1 CODE,INSTALLED CODE", 
						"user should be able to see a grid with columns:PRODUCT ID,PRODUCT NAME ,SITE ID, CUSTOMER NAME ,PRODUCT NICKNAME,CODE LEVEL,TARGET -1 CODE,TARGET+1 CODE,INSTALLED CODE" ,
						"user able to see tabs grid columns as "+Report.color(text1), "PASS");
			}
			else
			{
				System.out.println("not able to see columns in grid");
				Report.put("system display grid with following columns when user is in code levels from left menu :PRODUCT ID,PRODUCT NAME ,SITE ID, CUSTOMER NAME ,PRODUCT NICKNAME,CODE LEVEL,TARGET -1 CODE,TARGET+1 CODE,INSTALLED CODE", 
						"user should be able to see a grid with columns:PRODUCT ID,PRODUCT NAME ,SITE ID, CUSTOMER NAME ,PRODUCT NICKNAME,CODE LEVEL,TARGET -1 CODE,TARGET+1 CODE,INSTALLED CODE" ,
						"Failed to see columns in grid", "FAIL");

				Assert.fail();
			}

		}
		catch(Exception e)
		{
			Log.info(e);
			Report.put("system display grid with following columns when user is in code levels from left menu :PRODUCT ID,PRODUCT NAME ,SITE ID, CUSTOMER NAME ,PRODUCT NICKNAME,CODE LEVEL,TARGET -1 CODE,TARGET+1 CODE,INSTALLED CODE", 
					"user should be able to see a grid with columns:PRODUCT ID,PRODUCT NAME ,SITE ID, CUSTOMER NAME ,PRODUCT NICKNAME,CODE LEVEL,TARGET -1 CODE,TARGET+1 CODE,INSTALLED CODE" ,
					"Failed to see columns in grid", "FAIL");
			e.printStackTrace();
			Assert.fail();
		}

	} 
	
	public void ValidateGridRefreshWithDataAfterClickingContractsHUD(WebDriver driver)
	{

		Log.info("Entering ValidateGridRefreshWithDataAfterClickingContractsHUD");	
		WebDriverWait wait = new WebDriverWait(driver, 240);
		String text="";
		String text1="";
		String map="";
		String text2="";
		String defaults="";
		String text3="";
		String text4="";
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		Actions act=new Actions(driver);
		String value=TestNGCreator.TestData.get(Esupport.Dpid.ordinal());
		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.ContractsOnLeftRailOfInstallBaseForActiveValidation()));
			if(CommonUtility.CheckpresenceofElementLocated(driver, 50, obj_PortalPage.ContractsOnLeftRailOfInstallBaseForActiveValidation()))
			{
				CommonUtility.scrollToViewElement(driver, obj_PortalPage.ContractsOnLeftRailOfInstallBaseForActiveValidation());
				text2=CommonUtility.highlightElement(driver, obj_PortalPage.ContractsOnLeftRailOfInstallBaseForActiveValidation()).getText();
				System.out.println(text2);
				
//				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.HeadingsOfTable1()));
				List<WebElement> list=driver.findElements(obj_PortalPage.HeadingsOfTable1());

				try
				{
					for(WebElement lt:list)
					{
						if(value=="ED")
						{

							act.moveToElement(CommonUtility.highlightElement(driver, lt)).build().perform();
							CommonUtility.highlightElement(driver, lt);

						}
						else
						{
							CommonUtility.scrollToViewElement(driver, lt);

							//					act.moveToElement(CommonUtility.highlightElement(driver, lt)).build().perform();
							CommonUtility.highlightElement(driver, lt);
						}

						text=lt.getText();
						text1+=" <br> "+text;
					}
					System.out.println("columns are "+text1);
				}
				catch(Exception e)
				{

				}
				Report.put("system display grid with following columns when user is in code levels from left menu :PRODUCT ID,PRODUCT NAME ,SITE ID, CUSTOMER NAME ,PRODUCT NICKNAME,CODE LEVEL,TARGET -1 CODE,TARGET+1 CODE,INSTALLED CODE", 
						"user should be able to see a grid with columns:PRODUCT ID,PRODUCT NAME ,SITE ID, CUSTOMER NAME ,PRODUCT NICKNAME,CODE LEVEL,TARGET -1 CODE,TARGET+1 CODE,INSTALLED CODE" ,
						"user able to see tabs grid columns as "+Report.color(text1), "PASS");
			}
			else
			{
				System.out.println("not able to see columns in grid");
				Report.put("system display grid with following columns when user is in code levels from left menu :PRODUCT ID,PRODUCT NAME ,SITE ID, CUSTOMER NAME ,PRODUCT NICKNAME,CODE LEVEL,TARGET -1 CODE,TARGET+1 CODE,INSTALLED CODE", 
						"user should be able to see a grid with columns:PRODUCT ID,PRODUCT NAME ,SITE ID, CUSTOMER NAME ,PRODUCT NICKNAME,CODE LEVEL,TARGET -1 CODE,TARGET+1 CODE,INSTALLED CODE" ,
						"Failed to see columns in grid", "FAIL");

				Assert.fail();
			}

		}
		catch(Exception e)
		{
			Log.info(e);
			Report.put("system display grid with following columns when user is in code levels from left menu :PRODUCT ID,PRODUCT NAME ,SITE ID, CUSTOMER NAME ,PRODUCT NICKNAME,CODE LEVEL,TARGET -1 CODE,TARGET+1 CODE,INSTALLED CODE", 
					"user should be able to see a grid with columns:PRODUCT ID,PRODUCT NAME ,SITE ID, CUSTOMER NAME ,PRODUCT NICKNAME,CODE LEVEL,TARGET -1 CODE,TARGET+1 CODE,INSTALLED CODE" ,
					"Failed to see columns in grid", "FAIL");
			e.printStackTrace();
			Assert.fail();
		}

	} 
	
	public void ValidateGridRefreshWithDataAfterClickingAssetsHUD(WebDriver driver)
	{

		Log.info("Entering ValidateGridRefreshWithDataAfterClickingAssetsHUD");	
		WebDriverWait wait = new WebDriverWait(driver, 240);
		String text="";
		String text1="";
		String map="";
		String text2="";
		String defaults="";
		String text3="";
		String text4="";
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		Actions act=new Actions(driver);
		String value=TestNGCreator.TestData.get(Esupport.Dpid.ordinal());
		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.AssetsOnLeftRailOfInstallBaseForActiveValidation()));
			if(CommonUtility.CheckpresenceofElementLocated(driver, 50, obj_PortalPage.AssetsOnLeftRailOfInstallBaseForActiveValidation()))
			{
				CommonUtility.scrollToViewElement(driver, obj_PortalPage.AssetsOnLeftRailOfInstallBaseForActiveValidation());
				text2=CommonUtility.highlightElement(driver, obj_PortalPage.AssetsOnLeftRailOfInstallBaseForActiveValidation()).getText();
				System.out.println(text2);

//				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.HeadingsOfTable1()));
				List<WebElement> list=driver.findElements(obj_PortalPage.HeadingsOfTable1());

				try
				{
					for(WebElement lt:list)
					{
						if(value=="ED")
						{

							act.moveToElement(CommonUtility.highlightElement(driver, lt)).build().perform();
							CommonUtility.highlightElement(driver, lt);

						}
						else
						{
							CommonUtility.scrollToViewElement(driver, lt);

							//					act.moveToElement(CommonUtility.highlightElement(driver, lt)).build().perform();
							CommonUtility.highlightElement(driver, lt);
						}

						text=lt.getText();
						text1+=" <br> "+text;
					}
					System.out.println("columns are "+text1);
				}
				catch(Exception e)
				{

				}
				Report.put("system display grid with following columns when user is in Assets in left menu :PRODUCT ID,PRODUCT NAME ,SITE ID, CUSTOMER NAME ,PRODUCT NICKNAME,PRODUCT TYPE,INSTALL STATUS,INSTALL BASE", 
						"user should be able to see a grid with columns:PRODUCT ID,PRODUCT NAME ,SITE ID, CUSTOMER NAME ,PRODUCT NICKNAME,PRODUCT TYPE,INSTALL STATUS,INSTALL BASE" ,
						"user able to see tabs grid columns as "+Report.color(text1), "PASS");
			}
			else
			{
				System.out.println("not able to see columns in grid");
				Report.put("system display grid with following columns when user is in Assets in left menu :PRODUCT ID,PRODUCT NAME ,SITE ID, CUSTOMER NAME ,PRODUCT NICKNAME,PRODUCT TYPE,INSTALL STATUS,INSTALL BASE", 
						"user should be able to see a grid with columns:PRODUCT ID,PRODUCT NAME ,SITE ID, CUSTOMER NAME ,PRODUCT NICKNAME,PRODUCT TYPE,INSTALL STATUS,INSTALL BASE" ,
						"Failed to see columns in grid", "FAIL");

				Assert.fail();
			}

		}
		catch(Exception e)
		{
			Log.info(e);
			Report.put("system display grid with following columns when user is in Assets in left menu :PRODUCT ID,PRODUCT NAME ,SITE ID, CUSTOMER NAME ,PRODUCT NICKNAME,PRODUCT TYPE,INSTALL STATUS,INSTALL BASE", 
					"user should be able to see a grid with columns:PRODUCT ID,PRODUCT NAME ,SITE ID, CUSTOMER NAME ,PRODUCT NICKNAME,PRODUCT TYPE,INSTALL STATUS,INSTALL BASE" ,
					"Failed to see columns in grid", "FAIL");
			e.printStackTrace();
			Assert.fail();
		}

	} 
	
	public void ClickOnTabularView(WebDriver driver)
	{

		Log.info("Entering ClickOnTabularView");	
		WebDriverWait wait = new WebDriverWait(driver, 240);
		String text="";
		String text1="";
		String map="";
		String text2="";
		String defaults="";
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		Actions act=new Actions(driver);
		String value=TestNGCreator.TestData.get(Esupport.Dpid.ordinal());
		String value2=TestNGCreator.TestData.get(Esupport.SearchOption.ordinal());
		try
		{
			Thread.sleep(5000);
			CommonUtility.scrollToViewElement(driver,obj_PortalPage.ClickOnTabularView());
			//			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.IncidentsManagementTab()));
			if(CommonUtility.CheckpresenceofElementLocated(driver, 10, obj_PortalPage.ClickOnTabularView()))
			{
				CommonUtility.scrollToViewElement(driver,obj_PortalPage.ClickOnTabularView());
				map=CommonUtility.highlightElement(driver,obj_PortalPage.ClickOnTabularView()).getText();
				System.out.println(map);
				CommonUtility.highlightElement(driver,obj_PortalPage.ClickOnTabularView()).click(); 
//				driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
//				Thread.sleep(10000);
						
				Report.put("Click on Tabular view", 
						"User should be able to click on Tabular View" ,
						"user able to click on "+Report.color(map), "PASS");
			}
			else
			{
				System.out.println("not able to see tabular icon/hyperlink");
				Report.put("Click on Tabular view", 
						"User should be able to click on Tabular View" ,
						"Failed to click on tabular link", "FAIL");

				Assert.fail();
			}

		}
		catch(Exception e)
		{
			Log.info(e);
			Report.put("Click on Tabular view", 
					"User should be able to click on Tabular View" ,
					"Failed to click on tabular link", "FAIL");
			e.printStackTrace();
			Assert.fail();
		}

	} 
	
	
	public void ClickOnFilterAndApplyAnyFilterInTabularView(WebDriver driver)
	{

		Log.info("Entering ClickOnFilterAndApplyAnyFilterInTabularView");	
		WebDriverWait wait = new WebDriverWait(driver, 240);
		String text="";
		String text1="";
		String map="";
		String text2="";
		String defaults="";
		String text3="";
		String text4="";
		String text5="";
		String text6="";
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		Actions act=new Actions(driver);
		String value=TestNGCreator.TestData.get(Esupport.Dpid.ordinal());
		try
		{
			CommonUtility.scrollToViewElement(driver,obj_PortalPage.FilterButton());
			//			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.IncidentsManagementTab()));
			if(CommonUtility.CheckpresenceofElementLocated(driver, 50, obj_PortalPage.FilterButton()))
			{
				CommonUtility.scrollToViewElement(driver,obj_PortalPage.FilterButton());
				map=CommonUtility.highlightElement(driver,obj_PortalPage.FilterButton()).getText();
				System.out.println(map);
				CommonUtility.highlightElement(driver,obj_PortalPage.FilterButton()).click(); 
				driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
				Thread.sleep(5000);
				driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
				//				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.ProductNameInFiltersWindow()));
				CommonUtility.scrollToViewElement(driver,obj_PortalPage.ProductNameInFiltersWindow());
				text2=CommonUtility.highlightElement(driver,obj_PortalPage.ProductNameInFiltersWindow()).getText();
				System.out.println("Filter is "+text2);
				CommonUtility.highlightElement(driver,obj_PortalPage.ProductNameInFiltersWindow()).click();
				Thread.sleep(5000);
				driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
				CommonUtility.scrollToViewElement(driver,obj_PortalPage.AppSyncOptionUnderProductNameInFilterWindow());
				defaults=CommonUtility.highlightElement(driver,obj_PortalPage.AppSyncOptionUnderProductNameInFilterWindow()).getText();
				System.out.println("sub filter selected  is "+defaults);

				CommonUtility.highlightElement(driver,obj_PortalPage.AppSyncOptionUnderProductNameInFilterWindow()).click();

				CommonUtility.scrollToViewElement(driver,obj_PortalPage.ApplySelectedInFilterWindow());
				text3=CommonUtility.highlightElement(driver,obj_PortalPage.ApplySelectedInFilterWindow()).getText();
				System.out.println("text is "+text3);

				CommonUtility.highlightElement(driver,obj_PortalPage.ApplySelectedInFilterWindow()).click();
				CommonUtility.scrollToViewElement(driver,obj_PortalPage.XButtonOnFilterWindow());
				CommonUtility.highlightElement(driver,obj_PortalPage.XButtonOnFilterWindow()).click();

				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.BreadScrumbsOnGraphView()));


				List<WebElement> list2=driver.findElements(obj_PortalPage.BreadScrumbsOnGraphView());


				for(WebElement lt:list2)
				{
					if(value=="ED")
					{

						act.moveToElement(CommonUtility.highlightElement(driver, lt)).build().perform();
						CommonUtility.highlightElement(driver, lt);

					}
					else
					{
						CommonUtility.scrollToViewElement(driver, lt);

						//					act.moveToElement(CommonUtility.highlightElement(driver, lt)).build().perform();
						CommonUtility.highlightElement(driver, lt);
					}

					text=lt.getText();
					text4+=" <br> "+text;
				}
				System.out.println("Breadscrumbs are "+text4);

				
				Report.put("user applies a filter either via the filter menu or through data analysis And user clicks on the geospatial icon", 
						"user should be able to click on any of the white spots that indicate site location" ,
						"user able to click on "+Report.color(map)+" and able to see "+Report.color(text2)+" and <br> sub filter "+Report.color(defaults)+" and after clicking "+Report.color(text3)+"<br> user able to see filters as "+Report.color(text1)+" <br> with breadscrumbs as "+Report.color(text4), "PASS");
			}
			else
			{
				System.out.println("not ble to see filter button or it is disabled");
				Report.put("user applies a filter either via the filter menu or through data analysis And user clicks on the geospatial icon", 
						"user should be able to click on any of the white spots that indicate site location" ,
						"Failed to click on Filter button", "FAIL");

				Assert.fail();
			}

		}
		catch(Exception e)
		{
			Log.info(e);
			Report.put("user applies a filter either via the filter menu or through data analysis And user clicks on the geospatial icon", 
					"user should be able to click on any of the white spots that indicate site location" ,
					"Failed to click on Filter button", "FAIL");
			e.printStackTrace();
			Assert.fail();
		}

	} 
	
	public void clickIncidentManagementTotalSrHud(WebDriver driver)
	{
		System.out.println("Inside clickIncidentManagementTotalSrHud method");
		Log.info("Inside clickIncidentManagementTotalSrHud method");

		
		String tab = "";
		String att = "";
		try
		{
			Actions act=new Actions(driver);
			act.moveToElement(CommonUtility.highlightElement(driver, obj_PortalPage.incidentManagementOpenSrHud())).build().perform();
			act.moveToElement(CommonUtility.highlightElement(driver, obj_PortalPage.incidentManagementOpenSrHud())).click().perform();

			tab = CommonUtility.highlightElement(driver,obj_PortalPage.incidentManagementOpenSrHud()).getText();
			
			System.out.println("Clicked on "+tab);
			
			att=CommonUtility.highlightElement(driver,obj_PortalPage.incidentManagementTotalSRButton()).getAttribute("class");
			System.out.println(att);

			if(att.contains("active"))
			{
				System.out.println("Total SRs is selected");
				
				Report.put("User clicks on Total SRs HUD",
						"User should be able to see the <summary perspective> LEFT NAV selected in the SR grid",
						"User clicked on the HUD"+Report.color(tab), "PASS");
			}
			else
			{
				Report.put("User clicks on Total SRs HUD",
						"User should be able to see the <summary perspective> LEFT NAV selected in the SR grid",
						"Failed to click on Total SRs HUD", "FAIL");
				Assert.fail();	
			}			
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("User clicks on Total SRs HUD",
					"User should be able to see the <summary perspective> LEFT NAV selected in the SR grid",
					"Failed to click on Total SRs HUD", "FAIL");
			Assert.fail();	
		}
	}
	
	public void clickIncidentManagementTotalSrHud_edge(WebDriver driver)
	{
		System.out.println("Inside clickIncidentManagementTotalSrHud_edge method");
		Log.info("Inside clickIncidentManagementTotalSrHud_edge method");

		
		String tab = "";
		String att = "";
		try
		{
			Actions act=new Actions(driver);
//			act.moveToElement(CommonUtility.highlightElement(driver, obj_PortalPage.incidentManagementOpenSrHud())).build().perform();
//			act.moveToElement(CommonUtility.highlightElement(driver, obj_PortalPage.incidentManagementOpenSrHud())).click().perform();

			WebElement ele = driver.findElement(obj_PortalPage.incidentManagementOpenSrHud());
			CommonUtility.ToClickByUsingJavaScript(driver,ele);
		//	CommonUtility.highlightElement(driver,obj_PortalPage.incidentManagementOpenSrHud()).click();
			tab = CommonUtility.highlightElement(driver,obj_PortalPage.incidentManagementOpenSrHud()).getText();
			
			System.out.println("Clicked on "+tab);
			
			att=CommonUtility.highlightElement(driver,obj_PortalPage.incidentManagementTotalSRButton()).getAttribute("class");
			System.out.println(att);

			if(att.contains("active"))
			{
				System.out.println("Total SRs is selected");
				
				Report.put("User clicks on Total SRs HUD",
						"User should be able to see the <summary perspective> LEFT NAV selected in the SR grid",
						"User clicked on the HUD"+Report.color(tab), "PASS");
			}
			else
			{
				Report.put("User clicks on Total SRs HUD",
						"User should be able to see the <summary perspective> LEFT NAV selected in the SR grid",
						"Failed to click on Total SRs HUD", "FAIL");
				Assert.fail();	
			}			
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("User clicks on Total SRs HUD",
					"User should be able to see the <summary perspective> LEFT NAV selected in the SR grid",
					"Failed to click on Total SRs HUD", "FAIL");
			Assert.fail();	
		}
	}
	public void clickIncidentManagementOnsiteServicesHud(WebDriver driver)
	{
		System.out.println("Inside clickIncidentManagementOnsiteServicesHud method");
		Log.info("Inside clickIncidentManagementOnsiteServicesHud method");

		
		String tab = "";
		String att = "";
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);
			WebElement ele = driver.findElement(obj_PortalPage.incidentManagementOnsiteServiceHud());
			
			Actions act=new Actions(driver);
			act.moveToElement(CommonUtility.highlightElement(driver, obj_PortalPage.incidentManagementOnsiteServiceHud())).build().perform();
			act.moveToElement(CommonUtility.highlightElement(driver, obj_PortalPage.incidentManagementOnsiteServiceHud())).click().perform();

			tab = CommonUtility.highlightElement(driver,obj_PortalPage.incidentManagementOnsiteServiceHud()).getText();
			
			System.out.println("Clicked on "+tab);
			
			att=CommonUtility.highlightElement(driver,obj_PortalPage.incidentManagementOnsiteServicesButton()).getAttribute("class");
			System.out.println(att);

			if(att.contains("active"))
			{
				System.out.println("Onsite Services is selected");
				Report.put("User clicks on Onsite Services HUD",
						"User should be able to see the <summary perspective> LEFT NAV selected in the SR grid",
						"User clicked on the HUD"+Report.color(tab), "PASS");
			}
			else
			{
				Report.put("User clicks on Onsite Services HUD",
						"User should be able to see the <summary perspective> LEFT NAV selected in the SR grid",
						"Failed to click on Onsite Services HUD", "FAIL");
				Assert.fail();	
			}
			
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("User clicks on Onsite Services HUD",
					"User should be able to see the <summary perspective> LEFT NAV selected in the SR grid",
					"Failed to click on Onsite Services HUD", "FAIL");
			Assert.fail();
		}
	}
	
	public void clickIncidentManagementOnsiteServicesHud_firefox(WebDriver driver)
	{
		System.out.println("Inside clickIncidentManagementOnsiteServicesHud method");
		Log.info("Inside clickIncidentManagementOnsiteServicesHud method");

		
		String tab = "";
		String att = "";
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);
			//WebElement ele = driver.findElement(obj_PortalPage.incidentManagementOnsiteServiceHud());
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.incidentManagementOnsiteServiceHud()));
			CommonUtility.scrollToViewElement(driver,(obj_PortalPage.incidentManagementOnsiteServiceHud()));
			Thread.sleep(3000);
			CommonUtility.highlightElement(driver,(obj_PortalPage.incidentManagementOnsiteServiceHud())).click();
//			Actions act=new Actions(driver);
//			act.moveToElement(CommonUtility.highlightElement(driver, obj_PortalPage.incidentManagementOnsiteServiceHud())).build().perform();
//			act.moveToElement(CommonUtility.highlightElement(driver, obj_PortalPage.incidentManagementOnsiteServiceHud())).click().perform();

			tab = CommonUtility.highlightElement(driver,obj_PortalPage.incidentManagementOnsiteServiceHud()).getText();
			
			System.out.println("Clicked on "+tab);
			
			att=CommonUtility.highlightElement(driver,obj_PortalPage.incidentManagementOnsiteServicesButton()).getAttribute("class");
			System.out.println(att);

			if(att.contains("active"))
			{
				System.out.println("Onsite Services is selected");
				Report.put("User clicks on Onsite Services HUD",
						"User should be able to see the <summary perspective> LEFT NAV selected in the SR grid",
						"User clicked on the HUD"+Report.color(tab), "PASS");
			}
			else
			{
				Report.put("User clicks on Onsite Services HUD",
						"User should be able to see the <summary perspective> LEFT NAV selected in the SR grid",
						"Failed to click on Onsite Services HUD", "FAIL");
				Assert.fail();	
			}
			
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("User clicks on Onsite Services HUD",
					"User should be able to see the <summary perspective> LEFT NAV selected in the SR grid",
					"Failed to click on Onsite Services HUD", "FAIL");
			Assert.fail();
		}
	}
	
	public void clickIncidentManagementEscalationsHud(WebDriver driver)
	{
		System.out.println("Inside clickIncidentManagementEscalationsHud method");
		Log.info("Inside clickIncidentManagementEscalationsHud method");

		
		String tab = "";
		String att = "";
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);
			WebElement ele = driver.findElement(obj_PortalPage.incidentManagementEscalationsHud());
			
			Actions act=new Actions(driver);
			act.moveToElement(CommonUtility.highlightElement(driver, obj_PortalPage.incidentManagementEscalationsHud())).build().perform();
			act.moveToElement(CommonUtility.highlightElement(driver, obj_PortalPage.incidentManagementEscalationsHud())).click().perform();

			tab = CommonUtility.highlightElement(driver,obj_PortalPage.incidentManagementEscalationsHud()).getText();
			
			System.out.println("Clicked on "+tab);
			
			att=CommonUtility.highlightElement(driver,obj_PortalPage.incidentManagementEscalationsButton()).getAttribute("class");
			System.out.println(att);

			if(att.contains("active"))
			{
				System.out.println("Escalations is selected");
				
				Report.put("User clicks on Escalations HUD",
						"User should be able to see the <summary perspective> LEFT NAV selected in the SR grid",
						"User clicked on the HUD"+Report.color(tab), "PASS");
			}
			else
			{
				Report.put("User clicks on Escalations HUD",
						"User should be able to see the <summary perspective> LEFT NAV selected in the SR grid",
						"Failed to click on Escalations HUD", "FAIL");
				Assert.fail();	
			}
			
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("User clicks on Escalations HUD",
					"User should be able to see the <summary perspective> LEFT NAV selected in the SR grid",
					"Failed to click on Escalations HUD", "FAIL");
			Assert.fail();
		}
	}
	
	public void clickIncidentManagementPartsReplacedHud(WebDriver driver)
	{
		System.out.println("Inside clickIncidentManagementPartsReplacedHud method");
		Log.info("Inside clickIncidentManagementPartsReplacedHud method");

		
		String tab = "";
		String att = "";
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);
			WebElement ele = driver.findElement(obj_PortalPage.incidentManagementPartsReplacedHud());
			
			Actions act=new Actions(driver);
			act.moveToElement(CommonUtility.highlightElement(driver, obj_PortalPage.incidentManagementPartsReplacedHud())).build().perform();
			act.moveToElement(CommonUtility.highlightElement(driver, obj_PortalPage.incidentManagementPartsReplacedHud())).click().perform();

			tab = CommonUtility.highlightElement(driver,obj_PortalPage.incidentManagementPartsReplacedHud()).getText();
			
			System.out.println("Clicked on "+tab);
			
			att=CommonUtility.highlightElement(driver,obj_PortalPage.incidentManagementPartsReplacedButton()).getAttribute("class");
			System.out.println(att);

			if(att.contains("active"))
			{
				System.out.println("Parts Replaced is selected");
				
				Report.put("User clicks on Parts Replaced HUD",
						"User should be able to see the <summary perspective> LEFT NAV selected in the SR grid",
						"User clicked on the HUD"+Report.color(tab), "PASS");
			}
			else
			{
				Report.put("User clicks on Parts Replaced HUD",
						"User should be able to see the <summary perspective> LEFT NAV selected in the SR grid",
						"Failed to click on Parts Replaced HUD", "FAIL");
				Assert.fail();	
			}
			
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("User clicks on Parts Replaced HUD",
					"User should be able to see the <summary perspective> LEFT NAV selected in the SR grid",
					"Failed to click on Parts Replaced HUD", "FAIL");
			Assert.fail();
		}
	}
	
	public void clickInstallBaseTab(WebDriver driver)
	{
		System.out.println("Inside clickInstallBaseTab method");
		Log.info("Inside clickInstallBaseTab method");

		
		String tab = "";
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);
			
			Thread.sleep(5000);
			CommonUtility.highlightElement(driver,obj_PortalPage.installBaseTab()).click();
			tab = CommonUtility.highlightElement(driver,obj_PortalPage.installBaseTab()).getText();
			
			System.out.println("Clicked on "+tab);

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.incidentManagementTable()));
		
			CommonUtility.scrollToViewElement(driver,(obj_PortalPage.incidentManagementTable()));
			CommonUtility.highlightElement(driver,obj_PortalPage.incidentManagementTable());

			Report.put("User navigates to the install base page",
					"User is on the install base page",
					Report.color(tab)+"displayed successfully.", "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("User navigates to the install base page",
					"User is on the installed base page",
					"Failed to load Install Base page", "FAIL");
			Assert.fail();
		}
	}
	
	public void clickInstallBaseTotalAssetsButton(WebDriver driver)
	{
		System.out.println("Inside clickInstallBaseTotalAssetsButton method");
		Log.info("Inside clickInstallBaseTotalAssetsButton method");

		
		String tab = "";
		String att = "";
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);
			
			CommonUtility.highlightElement(driver,obj_PortalPage.installBaseTotalAssetsButton()).click();
			
			tab = CommonUtility.highlightElement(driver,obj_PortalPage.installBaseTotalAssetsButton()).getText();
			
			System.out.println("Clicked on "+tab);
			
			att=CommonUtility.highlightElement(driver,obj_PortalPage.installBaseTotalAssetsButton()).getAttribute("class");
			System.out.println(att);

			if(att.contains("active"))
			{
				System.out.println("Total Assets is selected");
				
				Report.put("User clicks on Total Assets",
						"User should be in the context of Total Assets",
						"User is in the context of "+Report.color(tab), "PASS");
			}
			else
			{
				Report.put("User clicks on Total Assets",
						"User should be in the context of Total Assets",
						"Failed to click on Total Assets", "FAIL");
				Assert.fail();	
			}
			
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("User clicks on Total Assets",
					"User should be in the context of Total Assets",
					"Failed to click on Total Assets", "FAIL");
			Assert.fail();
		}
	}
	
	public void verifyInstallBaseSpecificFilters(WebDriver driver)
	{
		System.out.println("Inside verifyInstallBaseSpecificFilters method");
		Log.info("Inside verifyInstallBaseSpecificFilters method");

		
		String filterButton = "";
		String filterByHeader = "";
		String filterList = "";
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);
			
			//CommonUtility.scrollToViewElement(driver,(obj_PortalPage.incidentManagementSummaryViewFilterButton()));
			filterButton = CommonUtility.highlightElement(driver,obj_PortalPage.incidentManagementSummaryViewFilterButton()).getText();
			
			Thread.sleep(5000);
			CommonUtility.highlightElement(driver,obj_PortalPage.incidentManagementSummaryViewFilterButton()).click();
			
			System.out.println("Clicked on "+filterButton);

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.incidentManagementFilterByPopupHeader()));
		
			CommonUtility.highlightElement(driver,obj_PortalPage.incidentManagementFilterByPopupHeader());

			filterByHeader = CommonUtility.highlightElement(driver,obj_PortalPage.incidentManagementFilterByPopupHeader()).getText();
			
			System.out.println("Header is"+filterByHeader);			

			List<WebElement> list=driver.findElements(obj_PortalPage.incidentManagementFilterValuesList());

			for(WebElement lt:list)
			{
				CommonUtility.highlightElement(driver, lt);
				String filterName=lt.getText();
				if(!(filterName.isEmpty()))
				{
					System.out.println("Filter is: " +filterName);
					filterList+=" <br> " + filterName;
				}
			}
			System.out.println("Filters are:"+filterList);
			
			Report.put("Constant < List of Filters> will be shown with the ability to pick specific values  below - TLA Flag, Install Base Status, Product Family, Product Name, Site ID, Customer Name, Contract Status, Service Plan Level, Product ID, Asset Type",
					"TLA Flag, Install Base Status, Product Family, Product Name, Site ID, Customer Name, Contract Status, Service Plan Level, Product ID, Asset Type",
					"List of filters are: "+Report.color(filterList), "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();

			Report.put("Constant < List of Filters> will be shown with the ability to pick specific values  below - TLA Flag, Install Base Status, Product Family, Product Name, Site ID, Customer Name, Contract Status, Service Plan Level, Product ID, Asset Type",
					"TLA Flag, Install Base Status, Product Family, Product Name, Site ID, Customer Name, Contract Status, Service Plan Level, Product ID, Asset Type",
					"Failed to display filters", "FAIL");
			Assert.fail();
		}
	}
	
	public void closeInstallBaseExpandedView(WebDriver driver)
	{
		System.out.println("Inside closeInstallBaseExpandedView method");
		Log.info("Inside closeInstallBaseExpandedView method");
		
		String buttonList = "";
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);
			
			
			CommonUtility.scrollToViewElement(driver,(obj_PortalPage.incidentManagementExpandViewCloseButton()));
			CommonUtility.highlightElement(driver,obj_PortalPage.incidentManagementExpandViewCloseButton());
			CommonUtility.highlightElement(driver,obj_PortalPage.incidentManagementExpandViewCloseButton()).click();
						
			System.out.println("Closed Expanded View");
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.incidentManagementTable()));
			
			CommonUtility.scrollToViewElement(driver,(obj_PortalPage.incidentManagementTable()));
			CommonUtility.highlightElement(driver,obj_PortalPage.incidentManagementTable());
			
			List<WebElement> list=driver.findElements(obj_PortalPage.installBaseButtonsList());

			for(WebElement lt:list)
			{
				CommonUtility.highlightElement(driver, lt);
				String buttonName=lt.getText();
				if(!(buttonName.isEmpty()))
				{
					System.out.println("Button is: " +buttonName);
					buttonList+=" <br> " + buttonName;
				}
			}
			System.out.println("Buttons are:"+buttonList);
			
			Report.put("User will be able to close the full screen and return back to the IB grid",
					"once user returns back to IB grid he should be able to see below: Total Assets, Connectivity, Code Levels, Contracts",
					"User able to see buttons in IB grid"+Report.color(buttonList), "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("User will be able to close the full screen and return back to the IB grid",
					"once user returns back to IB grid he should be able to see below: Total Assets, Connectivity, Code Levels, Contracts",
					"Failed to Close Expanded view & return to IB grid", "FAIL");
			Assert.fail();
		}
	}
	
	public void verifyExpandViewDateRange(WebDriver driver)
	{
		System.out.println("Inside verifyExpandViewDateRange method");
		Log.info("Inside verifyExpandViewDateRange method");

		
		String dateRange = "";
		
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);

			dateRange = CommonUtility.highlightElement(driver,obj_PortalPage.expandViewBreadcrumbDateRange()).getText();

			System.out.println("Displayed Date Range "+dateRange);
			
				
			Report.put("User verifies if a date range is present(2years-present date)",
						"user should be able to view a date range ((2years-present date))",
						"Displayed date range "+Report.color(dateRange), "PASS");
		
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("User verifies if a date range is present(2years-present date)",
					"user should be able to view a date range ((2years-present date))",
					"Failed to display date range", "FAIL");
			Assert.fail();
		}
	}
	
	public void verifyDateRangeFormat(WebDriver driver)
	{
		System.out.println("Inside verifyDateRangeFormat method");
		Log.info("Inside verifyDateRangeFormat method");

		WebDriverWait wait = new WebDriverWait(driver, 120);
		String temp = "";
		
		try
		{
			String dateRange = "";

			CommonUtility.highlightElement(driver,obj_PortalPage.expandViewBreadcrumbDateRange());

			dateRange = CommonUtility.highlightElement(driver,obj_PortalPage.expandViewBreadcrumbDateRange()).getText();

			System.out.println("Date from the app is:"+dateRange);
			
			String[] extractString = dateRange.split("-", 0);
			
			for (String a : extractString) 
			{
	            System.out.println(a);
	            temp = a.trim();
			}
			System.out.println("Extracted String is: "+temp);
			Date date = null;
			String formatteddate = null;
			DateFormat df = new SimpleDateFormat("dd MMM yyyy");
			date = df.parse(temp);
			formatteddate = df.format(date);

			System.out.println("date: "+formatteddate);

			if(temp.equalsIgnoreCase(formatteddate))
			{
				System.out.println("Format is DD MMM YYYY");

				Report.put("User  verifies if the date is in a format of DD Month Name YYYY "+Report.color(temp),
						"user should be able to see the date in a format of DD Month Name YYYY ",
						"Displayed the  Date in the format(DD MMM YYYY) "+Report.color(formatteddate), "PASS");
			}
			else
			{
				Report.put("User  verifies if the date is in a format of DD Month Name YYYY "+Report.color(temp),
						"user should be able to see the date in a format of DD Month Name YYYY ",
						"Failed to display  Date format", "FAIL");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("User  verifies if the date is in a format of DD Month Name YYYY "+Report.color(temp),
					"user should be able to see the date in a format of DD Month Name YYYY ",
					"Failed to display  Date format", "FAIL");
			Assert.fail();
		}
	}
	
	public void verifyLastUpdatedDateFormat(WebDriver driver)
	{
		System.out.println("Inside verifyLastUpdatedDateFormat method");
		Log.info("Inside verifyLastUpdatedDateFormat method");

		WebDriverWait wait = new WebDriverWait(driver, 120);

		try
		{
			String lastUpdatedDate = "";

			CommonUtility.highlightElement(driver,obj_PortalPage.expandViewLastUpdatedFirstRowValue());

			lastUpdatedDate = CommonUtility.highlightElement(driver,obj_PortalPage.expandViewLastUpdatedFirstRowValue()).getAttribute("innerHTML");

			System.out.println("Last Updated Date is: "+lastUpdatedDate);

			Date date = null;
			String formatteddate = null;
			DateFormat df = new SimpleDateFormat("MMM dd, yyyy hh:mm a");
			date = df.parse(lastUpdatedDate);
			formatteddate = df.format(date);

			System.out.println("date: "+formatteddate);

			if(lastUpdatedDate.equalsIgnoreCase(formatteddate))
			{
				System.out.println("Format is MMM dd, yyyy hh:mm a");

				Report.put("User verifies if a date time field ( like Last updated or SR create date) "+Report.color(lastUpdatedDate),
						"user should be able to see the date in a format of Month Name DD YYYY HH:MM AM/PM",
						"Displayed the  Date in the format(MMM dd, yyyy hh:mm a) "+Report.color(formatteddate), "PASS");
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("User verifies if a date time field ( like Last updated or SR create date) ",
					"user should be able to see the date in a format of Month Name DD YYYY HH:MM AM/PM",
					"Failed to display  Date in the format(MMM dd, yyyy hh:mm a)", "FAIL");
		}
	}
	
	public void clickInstallBaseConnectivityButton(WebDriver driver)
	{
		System.out.println("Inside clickInstallBaseConnectivityButton method");
		Log.info("Inside clickInstallBaseConnectivityButton method");

		
		String tab = "";
		String att = "";
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);
			
			CommonUtility.highlightElement(driver,obj_PortalPage.installBaseConnectivityButton()).click();
			
			tab = CommonUtility.highlightElement(driver,obj_PortalPage.installBaseConnectivityButton()).getText();
			
			System.out.println("Clicked on "+tab);
			
			att=CommonUtility.highlightElement(driver,obj_PortalPage.installBaseConnectivityButton()).getAttribute("class");
			System.out.println(att);

			if(att.contains("active"))
			{
				System.out.println("Connectivity is selected");
				
				Report.put("user is in the context of Connectivity",
						"user should be to able to see the connectivity option on the left side of the IB grid",
						"User is in the context of "+Report.color(tab), "PASS");
			}
			else
			{
				Report.put("user is in the context of Connectivity",
						"user should be to able to see the connectivity option on the left side of the IB grid",
						"Failed to click on Connectivity", "FAIL");
				Assert.fail();	
			}
			
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("user is in the context of Connectivity",
					"user should be to able to see the connectivity option on the left side of the IB grid",
					"Failed to click on Connectivity", "FAIL");
			Assert.fail();
		}
	}	
	
	public void ValidateHUDAndCircleInPopUpOnRightSide(WebDriver driver)
	{

		Log.info("Entering ValidateHUDAndCircleInPopUpOnRightSide");	
		WebDriverWait wait = new WebDriverWait(driver, 240);
		String text="";
		String text1="";
		String map="";
		String text2="";
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		Actions act=new Actions(driver);
		String value=TestNGCreator.TestData.get(Esupport.Dpid.ordinal());
		try
		{
			//			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.IncidentsManagementTab()));
			if(CommonUtility.CheckpresenceofElementLocated(driver, 50, obj_PortalPage.WhiteSpotsThatIndicateSiteLocation()))
			{
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.WhiteSpotsThatIndicateSiteLocation()));
				List<WebElement> list=driver.findElements(obj_PortalPage.WhiteSpotsThatIndicateSiteLocation());
				for( int i=0;i<=list.size();i++)
				{
					if(i==0)
					{

						if(value=="ED")
						{
							CommonUtility.scrollToViewElement(driver, list.get(i));
							//							CommonUtility.highlightElement(driver, list.get(i)).click();
							WebElement element =driver.findElement(By.xpath("(//*[@class='sba-geo-map-marker sba-geo-map-circle-bubble'])["+i+"]"));
							((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);
						}
						else
						{
							CommonUtility.scrollToViewElement(driver, list.get(i));
							//						CommonUtility.highlightElement(driver, list.get(i)).click();
							//						CommonUtility.ToClickByUsingJavaScript_PassingByLoc(driver, list.get(i));
							act.moveToElement(CommonUtility.highlightElement(driver, list.get(i))).click().build().perform();
						}

						wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.HeaderOnPopUpDisplayedClickingOnWhiteSpot()));
						text1=CommonUtility.highlightElement(driver, obj_PortalPage.HeaderOnPopUpDisplayedClickingOnWhiteSpot()).getText();
						System.out.println("header is "+text1);
						List<WebElement> list1=driver.findElements(obj_PortalPage.DetailsIndisePopUpDisplayedClickingOnWhiteSpot());

						for(WebElement lt:list1)
						{
							CommonUtility.scrollToViewElement(driver, list.get(i));
							CommonUtility.highlightElement(driver, list.get(i));
							String values=lt.getText();
							System.out.println("displayed "+values);

							text+=" <br> "+values;
							break;
						}
						System.out.println("displayed values in pop are "+text);
						text2=CommonUtility.highlightElement(driver, obj_PortalPage.CircleInPopUpInMapView()).getText();
						System.out.println(text2);
					}
				}


				Report.put("Click on any of the white spots that indicate site location", 
						"A popup with the data points  should be displayed depending on the context" ,
						"user able to click on white spot and able to see pop up with header "+Report.color(text1)+" and able to see details displayed as "+Report.color(text+" and circle display "+text2), "PASS");
			}
			else
			{
				System.out.println("not ble to see white spots");
				Report.put("Click on any of the white spots that indicate site location", 
						"A popup with the data points  should be displayed depending on the context" ,
						"failed to click on white spot", "FAIL");

				Assert.fail();
			}

		}
		catch(Exception e)
		{
			Log.info(e);
			Report.put("Click on any of the white spots that indicate site location", 
					"A popup with the data points  should be displayed depending on the context" ,
					"failed to click on white spot", "FAIL");
			e.printStackTrace();
			Assert.fail();
		}

	} 
	
	public void ClickOnPartsReplaced(WebDriver driver)
	{

		Log.info("Entering ClickOnPartsReplaced");	
		WebDriverWait wait = new WebDriverWait(driver, 240);
		String text="";
		String text1="";
		String map="";
		String text2="";
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		Actions act=new Actions(driver);
		String value=TestNGCreator.TestData.get(Esupport.Dpid.ordinal());
		try
		{
			//			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.IncidentsManagementTab()));
			if(CommonUtility.CheckpresenceofElementLocated(driver, 50, obj_PortalPage.WhiteSpotsThatIndicateSiteLocation()))
			{
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.WhiteSpotsThatIndicateSiteLocation()));
				List<WebElement> list=driver.findElements(obj_PortalPage.WhiteSpotsThatIndicateSiteLocation());
				for( int i=0;i<=list.size();i++)
				{
					if(i==0)
					{

						if(value=="ED")
						{
							CommonUtility.scrollToViewElement(driver, list.get(i));
							//							CommonUtility.highlightElement(driver, list.get(i)).click();
							WebElement element =driver.findElement(By.xpath("(//*[@class='sba-geo-map-marker sba-geo-map-circle-bubble'])["+i+"]"));
							((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);
						}
						else
						{
							CommonUtility.scrollToViewElement(driver, list.get(i));
							//						CommonUtility.highlightElement(driver, list.get(i)).click();
							//						CommonUtility.ToClickByUsingJavaScript_PassingByLoc(driver, list.get(i));
							act.moveToElement(CommonUtility.highlightElement(driver, list.get(i))).click().build().perform();
						}

						wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.HeaderOnPopUpDisplayedClickingOnWhiteSpot()));
						text1=CommonUtility.highlightElement(driver, obj_PortalPage.HeaderOnPopUpDisplayedClickingOnWhiteSpot()).getText();
						System.out.println("header is "+text1);
						List<WebElement> list1=driver.findElements(obj_PortalPage.DetailsIndisePopUpDisplayedClickingOnWhiteSpot());

						for(WebElement lt:list1)
						{
							CommonUtility.scrollToViewElement(driver, list.get(i));
							CommonUtility.highlightElement(driver, list.get(i));
							String values=lt.getText();
							System.out.println("displayed "+values);

							text+=" <br> "+values;
							break;
						}
						System.out.println("displayed values in pop are "+text);
						text2=CommonUtility.highlightElement(driver, obj_PortalPage.CircleInPopUpInMapView()).getText();
						System.out.println(text2);
					}
				}


				Report.put("Click on any of the white spots that indicate site location", 
						"A popup with the data points  should be displayed depending on the context" ,
						"user able to click on white spot and able to see pop up with header "+Report.color(text1)+" and able to see details displayed as "+Report.color(text+" and circle display "+text2), "PASS");
			}
			else
			{
				System.out.println("not ble to see white spots");
				Report.put("Click on any of the white spots that indicate site location", 
						"A popup with the data points  should be displayed depending on the context" ,
						"failed to click on white spot", "FAIL");

				Assert.fail();
			}

		}
		catch(Exception e)
		{
			Log.info(e);
			Report.put("Click on any of the white spots that indicate site location", 
					"A popup with the data points  should be displayed depending on the context" ,
					"failed to click on white spot", "FAIL");
			e.printStackTrace();
			Assert.fail();
		}

	} 
	
	public void clickInstallBaseCodeLevelsButton(WebDriver driver)
	{
		System.out.println("Inside clickInstallBaseCodeLevelsButton method");
		Log.info("Inside clickInstallBaseCodeLevelsButton method");

		
		String tab = "";
		String att = "";
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);
			
			CommonUtility.highlightElement(driver,obj_PortalPage.installBaseCodeLevelsButton()).click();
			
			tab = CommonUtility.highlightElement(driver,obj_PortalPage.installBaseCodeLevelsButton()).getText();
			
			System.out.println("Clicked on "+tab);
			
			att=CommonUtility.highlightElement(driver,obj_PortalPage.installBaseCodeLevelsButton()).getAttribute("class");
			System.out.println(att);

			if(att.contains("active"))
			{
				System.out.println("Code Levels is selected");
				
				Report.put("user is in the context of Code Levels",
						"user should be to able to see the Code Levels option on the left side of the IB grid",
						"User is in the context of "+Report.color(tab), "PASS");
			}
			else
			{
				Report.put("user is in the context of Code Levels",
						"user should be to able to see the Code Levels option on the left side of the IB grid",
						"Failed to click on Code Levels", "FAIL");
				Assert.fail();	
			}
			
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("user is in the context of Code Levels",
					"user should be to able to see the Code Levels option on the left side of the IB grid",
					"Failed to click on Code Levels", "FAIL");
			Assert.fail();
		}
	}
	
	public void clickInstallBaseContractsButton(WebDriver driver)
	{
		System.out.println("Inside clickInstallBaseContractsButton method");
		Log.info("Inside clickInstallBaseContractsButton method");

		
		String tab = "";
		String att = "";
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);
			
			CommonUtility.highlightElement(driver,obj_PortalPage.installBaseContractsButton()).click();
			
			tab = CommonUtility.highlightElement(driver,obj_PortalPage.installBaseContractsButton()).getText();
			
			System.out.println("Clicked on "+tab);
			
			att=CommonUtility.highlightElement(driver,obj_PortalPage.installBaseContractsButton()).getAttribute("class");
			System.out.println(att);

			if(att.contains("active"))
			{
				System.out.println("Contracts is selected");
				
				Report.put("user is in the context of Contracts",
						"user should be to able to see the Contracts option on the left side of the IB grid",
						"User is in the context of "+Report.color(tab), "PASS");
			}
			else
			{
				Report.put("user is in the context of Contracts",
						"user should be to able to see the Contracts option on the left side of the IB grid",
						"Failed to click on Contracts", "FAIL");
				Assert.fail();	
			}
			
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("user is in the context of Contracts",
					"user should be to able to see the Contracts option on the left side of the IB grid",
					"Failed to click on Contracts", "FAIL");
			Assert.fail();
		}
	}	
	
	public void verifyInstallBaseContextButtons(WebDriver driver)
	{
		System.out.println("Inside verifyInstallBaseContextButtons method");
		Log.info("Inside verifyInstallBaseContextButtons method");
		
		String buttonList = "";
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);
							
			List<WebElement> list=driver.findElements(obj_PortalPage.installBaseButtonsList());

			for(WebElement lt:list)
			{
				CommonUtility.highlightElement(driver, lt);
				String buttonName=lt.getText();
				if(!(buttonName.isEmpty()))
				{
					System.out.println("Button is: " +buttonName);
					buttonList+=" <br> " + buttonName;
				}
			}
			System.out.println("Buttons are:"+buttonList);
			
			Report.put("user is in the context of <InstallBase Context> ",
					"user  should be able to view the InstallBase Context - Total Assets, Connectivity, Code Levels, Contracts",
					"User able to view in IB grid"+Report.color(buttonList), "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("user is in the context of <InstallBase Context> ",
					"user  should be able to view the InstallBase Context - Total Assets, Connectivity, Code Levels, Contracts",
					"Failed to view InstallBase Context", "FAIL");
			Assert.fail();
		}
	}
	
	public void verifyIncidentManagementSummaryViewHUD(WebDriver driver)
	{
		System.out.println("Inside verifyIncidentManagementSummaryViewHUD method");
		Log.info("Inside verifyIncidentManagementSummaryViewHUD method");

		
		String openSrHud = "";
		String onsiteServiceHud = "";
		String escalationsHud = "";
		String partsReplacedHud = "";
		
		try
		{	
			if(CommonUtility.CheckpresenceofElementLocated(driver, 30, obj_PortalPage.incidentManagementOpenSrHud()))
			{
				openSrHud = CommonUtility.highlightElement(driver,obj_PortalPage.incidentManagementOpenSrHud()).getText();
			
				System.out.println("Displayed "+openSrHud);
			}
			else
			{
				System.out.println("Failed to display Open Sr HUD");
				Assert.fail();
			}
			
			if(CommonUtility.CheckpresenceofElementLocated(driver, 30, obj_PortalPage.incidentManagementOnsiteServiceHud()))
			{
				onsiteServiceHud = CommonUtility.highlightElement(driver,obj_PortalPage.incidentManagementOnsiteServiceHud()).getText();
			
				System.out.println("Displayed "+onsiteServiceHud);
			}
			else
			{
				System.out.println("Failed to display OnsiteService HUD");
				Assert.fail();
			}
			if(CommonUtility.CheckpresenceofElementLocated(driver, 30, obj_PortalPage.incidentManagementEscalationsHud()))
			{
				escalationsHud = CommonUtility.highlightElement(driver,obj_PortalPage.incidentManagementEscalationsHud()).getText();
			
				System.out.println("Displayed "+escalationsHud);
			}
			else
			{
				System.out.println("Failed to display Escalations HUD");
				Assert.fail();
			}
			if(CommonUtility.CheckpresenceofElementLocated(driver, 30, obj_PortalPage.incidentManagementPartsReplacedHud()))
			{
				partsReplacedHud = CommonUtility.highlightElement(driver,obj_PortalPage.incidentManagementPartsReplacedHud()).getText();						
				System.out.println("Displayed "+partsReplacedHud);
			}	
			else
			{
				System.out.println("Failed to display Parts Replaced HUD");
				Assert.fail();
			}
				
				Report.put("User verifies if able  to see a HUD with 4 summary perspectives Open SRs based on Total SRs, Onsite Services, Escalations and Parts Replaced",
						"User should be able to View a HUD with 4 summary perspectives Open SRs based on and default selected data set in the Total SRs, Onsite Services, Escalations and Top Parts Replaced HUD should be of Open SRs based on Total SRs represented by the image for Open SRs ",
						"Displayed HUD with 4 summary perspectives "+Report.color(openSrHud)+Report.color(onsiteServiceHud)+Report.color(escalationsHud)+Report.color(partsReplacedHud), "PASS");						
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("User verifies if able  to see a HUD with 4 summary perspectives Open SRs based on Total SRs, Onsite Services, Escalations and Parts Replaced",
					"User should be able to View a HUD with 4 summary perspectives Open SRs based on and default selected data set in the Total SRs, Onsite Services, Escalations and Top Parts Replaced HUD should be of Open SRs based on Total SRs represented by the image for Open SRs ",
					"Failed to display HUD with 4 summary perspectives ", "FAIL");
			Assert.fail();	
		}
	}
	
	public void verifyIncidentManagementIndividualKPIHUD(WebDriver driver)
	{
		System.out.println("Inside verifyIncidentManagementIndividualKPIHUD method");
		Log.info("Inside verifyIncidentManagementIndividualKPIHUD method");

		
		String onsiteServiceHud = "";
		String escalationsHud = "";
		String partsReplacedHud = "";
		
		try
		{	
			
			if(CommonUtility.CheckpresenceofElementLocated(driver, 30, obj_PortalPage.incidentManagementOnsiteServiceHud()))
			{
				onsiteServiceHud = CommonUtility.highlightElement(driver,obj_PortalPage.incidentManagementOnsiteServiceHud()).getText();
			
				System.out.println("Displayed KPI "+onsiteServiceHud);
			}
			else
			{
				System.out.println("Failed to display KPI OnsiteService HUD");
				Assert.fail();
			}
			if(CommonUtility.CheckpresenceofElementLocated(driver, 30, obj_PortalPage.incidentManagementEscalationsHud()))
			{
				escalationsHud = CommonUtility.highlightElement(driver,obj_PortalPage.incidentManagementEscalationsHud()).getText();
			
				System.out.println("Displayed KPI "+escalationsHud);
			}
			else
			{
				System.out.println("Failed to display KPI Escalations HUD");
				Assert.fail();
			}
			if(CommonUtility.CheckpresenceofElementLocated(driver, 30, obj_PortalPage.incidentManagementPartsReplacedHud()))
			{
				partsReplacedHud = CommonUtility.highlightElement(driver,obj_PortalPage.incidentManagementPartsReplacedHud()).getText();						
				System.out.println("Displayed KPI "+partsReplacedHud);
			}	
			else
			{
				System.out.println("Failed to display KPI Parts Replaced HUD");
				Assert.fail();
			}
				
				Report.put("User verifies if an individual KPI is selected for Onsite Services, Escalations and Parts Replaced",
						"User should be able to view an  individual KPI selected for Onsite Services, Escalations and Top Parts Replaced",
						"Displayed individual KPI selected for Onsite Services, Escalations and Top Parts Replaced "+Report.color(onsiteServiceHud)+Report.color(escalationsHud)+Report.color(partsReplacedHud), "PASS");						
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("User verifies if an individual KPI is selected for Onsite Services, Escalations and Parts Replaced",
					"User should be able to view an  individual KPI selected for Onsite Services, Escalations and Top Parts Replaced",
					"individual KPI selected for Onsite Services, Escalations and Top Parts Replaced ", "FAIL");
			Assert.fail();	
		}
	}
	
	public void hoverOverIncidentManagementEscalationsHUD(WebDriver driver)
	{
		System.out.println("Inside hoverOverIncidentManagementEscalationsHUD method");
		Log.info("Inside hoverOverIncidentManagementEscalationsHUD method");
		
		String escalationsHudValue = "";
		
		try
		{		
			if(CommonUtility.CheckpresenceofElementLocated(driver, 30, obj_PortalPage.incidentManagementEscalationsHudValue()))
			{
				Actions act=new Actions(driver);
				//act.moveToElement(CommonUtility.highlightElement(driver, obj_PortalPage.incidentManagementEscalationsHudValue())).build().perform();
				
				escalationsHudValue = CommonUtility.highlightElement(driver,obj_PortalPage.incidentManagementEscalationsHudValue()).getText();
			
				System.out.println("Escalations Value is: "+escalationsHudValue);
				
				if(escalationsHudValue!=null)
				{
					Report.put("User tries to  hover over the arcs of any of the other summary perspectives",
							"User should be able corresponding values ",
							"Displayed corresponding values for Escalations"+Report.color(escalationsHudValue), "PASS");	
				}
				else
				{
					System.out.println("Failed to display  Escalations value");
					Report.put("User tries to  hover over the arcs of any of the other summary perspectives",
							"User should be able corresponding values ",
							"Failed to display corresponding values for Escalations", "FAIL");						
					Assert.fail();
				}
			}
			else
			{
				System.out.println("Failed to display  Escalations value");
				Report.put("User tries to  hover over the arcs of any of the other summary perspectives",
						"User should be able corresponding values ",
						"Failed to display corresponding values for Escalations", "FAIL");						
				Assert.fail();
			}										
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("User tries to  hover over the arcs of any of the other summary perspectives",
					"User should be able corresponding values ",
					"Failed to display corresponding values for Escalations", "FAIL");			
			Assert.fail();	
		}
	}

	public void getIncidentManagementTotalSRHUDvalue(WebDriver driver)
	{
		System.out.println("Inside getIncidentManagementTotalSRHUDvalue method");
		Log.info("Inside getIncidentManagementTotalSRHUDvalue method");
		
		String totalSRHudValue = "";
		
		try
		{		
			if(CommonUtility.CheckpresenceofElementLocated(driver, 30, obj_PortalPage.incidentManagementTotalSRHudValue()))
			{
				
				totalSRHudValue = CommonUtility.highlightElement(driver,obj_PortalPage.incidentManagementTotalSRHudValue()).getText();
			
				System.out.println("Total SR Hud Value is: "+totalSRHudValue);
				
				if(totalSRHudValue!=null)
				{
					Report.put(" User verifies if the icon for Open SRs based on Total SRs is displayed ",
							"User should be able to see the icon for Open SRs based on Total SRs and user should be able to see the count of Open SRs based on Total SRs over the past 2 years",
							"Displayed corresponding values for Open SRs"+Report.color(totalSRHudValue), "PASS");	
				}
				else
				{
					System.out.println("Failed to display  Open SRs value");
					Report.put(" User verifies if the icon for Open SRs based on Total SRs is displayed ",
							"User should be able to see the icon for Open SRs based on Total SRs and user should be able to see the count of Open SRs based on Total SRs over the past 2 years",
							"Failed to display corresponding values for Open SRs", "FAIL");						
					Assert.fail();
				}
			}
			else
			{
				System.out.println("Failed to display  Open SRs value");
				Report.put(" User verifies if the icon for Open SRs based on Total SRs is displayed ",
						"User should be able to see the icon for Open SRs based on Total SRs and user should be able to see the count of Open SRs based on Total SRs over the past 2 years",
						"Failed to display corresponding values for Open SRs", "FAIL");							
				Assert.fail();
			}										
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Failed to display  Open SRs value");
			Report.put(" User verifies if the icon for Open SRs based on Total SRs is displayed ",
					"User should be able to see the icon for Open SRs based on Total SRs and user should be able to see the count of Open SRs based on Total SRs over the past 2 years",
					"Failed to display corresponding values for Open SRs", "FAIL");				
			Assert.fail();	
		}
	}

	public void verifyIncidentManagementSRStatusOpen(WebDriver driver)
	{
		System.out.println("Inside verifyIncidentManagementSRStatusOpen method");
		Log.info("Inside verifyIncidentManagementSRStatusOpen method");


		
		String status = "";
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);

			CommonUtility.highlightElement(driver,(obj_PortalPage.incidentManagementStatusValueFirstRow()));
			status = CommonUtility.highlightElement(driver,obj_PortalPage.incidentManagementStatusValueFirstRow()).getText();

			if((status.equalsIgnoreCase("Open")) || (status.equalsIgnoreCase("Working")) || (status.equalsIgnoreCase("Assigning")) || (status.equalsIgnoreCase("Complete")))
			{
				System.out.println("Displayed SRs with status "+status);	

				Report.put("User verifies Open SRs should be an SR that has a status of Open",
						"user should be able to see that the Open SRs should be an SR that has a status Open",
						"SR status is "+Report.color(status), "PASS");	
			}
			else
			{
				System.out.println("Failed to Display SR's with Status Open");

				Report.put("User verifies Open SRs should be an SR that has a status of Open",
						"user should be able to see that the Open SRs should be an SR that has a status Open",
						"Failed to Select the Total SRs & display SR with Status Open", "FAIL");
				Assert.fail("Failed to display SRs with Open Status");
			}		
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("User verifies Open SRs should be an SR that has a status of Open",
					"user should be able to see that the Open SRs should be an SR that has a status Open",
					"Failed to Select the Total SRs & display SR with Status Open", "FAIL");
			Assert.fail("Failed to display SRs with Open Status");
		}
	}
	
	public void hoverOverIncidentManagementTotalSRArcs(WebDriver driver)
	{
		System.out.println("Inside hoverOverIncidentManagementTotalSRArcs method");
		Log.info("Inside hoverOverIncidentManagementTotalSRArcs method");
		
		String totalSRArcValues = "";
		
		try
		{		
			

			List<WebElement> list=driver.findElements(obj_PortalPage.DropDownValuesUnderPageSizeSection());
			for(WebElement lt:list)
			{
				CommonUtility.highlightElement(driver, lt);
				String value=lt.getAttribute("value");
				String sev = lt.getAttribute("id");
				if(sev.contains("s1") || sev.contains("s2") || sev.contains("s1") || sev.contains("severityothers"))
				{
					System.out.println("Severity is: " +sev)	;
				}
					System.out.println("Arc is: " +value);
				totalSRArcValues+=" <br> " + value;
			}
			System.out.println("Arc Values are:"+totalSRArcValues);
			
					Report.put("User hovers over the arcs of Total SRs Donut chart ",
							"User should be able to hover over the arcs of Total SRs Donut chart and user should be able to see the count of Sev1, Sev 2, Sev 3 and total count of all other Sev SRs if they have count > 0",
							"Displayed corresponding values for arcs of Total SRs"+Report.color(totalSRArcValues), "PASS");	
				
								
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("User tries to  hover over the arcs of any of the other summary perspectives",
					"User should be able corresponding values ",
					"Failed to display corresponding values for Escalations", "FAIL");			
			Assert.fail();	
		}
	}
	
	public void verifyFirstSectionAccountName(WebDriver driver)
	{
		System.out.println("Inside verifyFirstSectionAccountName method");
		Log.info("Inside verifyFirstSectionAccountName method");

		String accName = "";

		try
		{		
			if(CommonUtility.CheckpresenceofElementLocated(driver, 30, obj_PortalPage.firstSectionAccountName()))
			{

				accName = CommonUtility.highlightElement(driver,obj_PortalPage.firstSectionAccountName()).getText();

				System.out.println("Account Name is: "+accName);

				if(accName!=null)
				{
					Report.put("User verifies 1st section ",
							"Within the 1st section towards the top left of the page, the user should see Account Name",
							"Displayed Account Name in the 1st Section "+Report.color(accName), "PASS");	
				}
				else
				{
					System.out.println("Failed to display  Account Name");

					Report.put("User verifies 1st section ",
							"Within the 1st section towards the top left of the page, the user should see Account Name",
							"Failed to display Account Name in the 1st Section", "FAIL");						
					Assert.fail();
				}
			}
			else
			{
				System.out.println("Failed to display  Account Name");

				Report.put("User verifies 1st section ",
						"Within the 1st section towards the top left of the page, the user should see Account Name",
						"Failed to display Account Name in the 1st Section", "FAIL");
				Assert.fail();
			}										
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Failed to display  Account Name");

			Report.put("User verifies 1st section ",
					"Within the 1st section towards the top left of the page, the user should see Account Name",
					"Failed to display Account Name in the 1st Section", "FAIL");
			Assert.fail();	
		}
	}
	
	public void verifyHealthScoreRisk(WebDriver driver)
	{
		System.out.println("Inside verifyHealthScoreRisk method");
		Log.info("Inside verifyHealthScoreRisk method");

		
		String healthScoreRisk = "";
		
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);
			
		//	CommonUtility.scrollToViewElement(driver,(obj_PortalPage.healthScoreRisk()));
			
			List<WebElement> list=driver.findElements(obj_PortalPage.healthScoreRisk());

			for(WebElement lt:list)
			{
				Thread.sleep(3000);
				//CommonUtility.scrollToViewElement(driver, lt);
				CommonUtility.highlightElement(driver, lt);
				String text=lt.getText();
				if(!(text.isEmpty()))
				{
					System.out.println("Text is: " +text);
					healthScoreRisk+=" <br> " + text;
				}
			}
			System.out.println("healthScoreRisk is:"+healthScoreRisk);
					
				
				Report.put("User verifies 2nd section",
						"Within the 2nd section towards the middle of the top section, the user should see Service Health Score / Risk",
						"Service Health Score / Risk  towards the middle of the top section "+Report.color(healthScoreRisk), "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("User verifies 2nd section",
					"Within the 2nd section towards the middle of the top section, the user should see Service Health Score / Risk",
					"Failed to display Service Health Score / Risk  towards the middle of the top section", "FAIL");
			Assert.fail();
		}
	}
	
	public void verifyPortalTabs(WebDriver driver)
	{
		System.out.println("Inside verifyPortalTabs method");
		Log.info("Inside verifyPortalTabs method");

		
		String tabs = "";
		
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);
			
			//CommonUtility.scrollToViewElement(driver,(obj_PortalPage.portalTabs()));
			
			List<WebElement> list=driver.findElements(obj_PortalPage.portalTabs());

			for(WebElement lt:list)
			{
				CommonUtility.scrollToViewElement(driver, lt);
				CommonUtility.highlightElement(driver, lt);
				String tab=lt.getText();
				if(!(tab.isEmpty()))
				{
					System.out.println("Tab is: " +tab);
					tabs+=" <br> " + tab;
				}
			}
			System.out.println("Tabs are: "+tabs);
					
				
				Report.put("User verifies 3rd section",
						"Within the 3rd section towards the middle of the page, the user should see 4 tabs Summary, Health&Risk, Install Base, Incident Management",
						"Tabs in the 3rd Section are:  "+Report.color(tabs), "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("User verifies 3rd section",
					"Within the 3rd section towards the middle of the page, the user should see 4 tabs Summary, Health&Risk, Install Base, Incident Management",
					"Failed to display 3rd section towards the middle of the page", "FAIL");
			Assert.fail();
		}
	}
	
	public void verifySummaryTabKPIs(WebDriver driver)
	{
		System.out.println("Inside verifySummaryTabKPIs method");
		Log.info("Inside verifySummaryTabKPIs method");

		
		String tabs = "";
		
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);
			
			CommonUtility.scrollToViewElement(driver,(obj_PortalPage.summaryTabKPIList()));
			
			List<WebElement> list=driver.findElements(obj_PortalPage.summaryTabKPIList());

			for(WebElement lt:list)
			{
				CommonUtility.scrollToViewElement(driver, lt);
				CommonUtility.highlightElement(driver, lt);
				String tab=lt.getText();
				if(!(tab.isEmpty()))
				{
					System.out.println("Tab is: " +tab);
					tabs+=" <br> " + tab;
				}
			}
			System.out.println("Tabs are: "+tabs);
					
				
				Report.put("User is on the Summary tab ",
						"On the top of the Summary tab, the user should see the following count of KPIs displayed All View, Open S1 Service Requests, Open Escalations, Unscheduled, Awaiting Action, FCO Backlog, TSE Backlog",
						"KPIs in the Summary tab are:  "+Report.color(tabs), "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("User is on the Summary tab ",
					"On the top of the Summary tab, the user should see the following count of KPIs displayed All View, Open S1 Service Requests, Open Escalations, Unscheduled, Awaiting Action, FCO Backlog, TSE Backlog",
					"Failed to display KPIs in the Summary tab", "FAIL");
			Assert.fail();
		}
	}
	
	public void clickHealthAndRiskTab(WebDriver driver)
	{
		System.out.println("Inside clickHealthAndRiskTab method");
		Log.info("Inside clickHealthAndRiskTab method");

		
		String tab = "";
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);
			
			Thread.sleep(10000);
			CommonUtility.highlightElement(driver,obj_PortalPage.healthAndRiskTab()).click();
			tab = CommonUtility.highlightElement(driver,obj_PortalPage.healthAndRiskTab()).getText();
			
			System.out.println("Clicked on "+tab);

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.healthAndRiskTable()));
		
			CommonUtility.scrollToViewElement(driver,(obj_PortalPage.healthAndRiskTable()));
			CommonUtility.highlightElement(driver,obj_PortalPage.healthAndRiskTable());

			Report.put("User navigates to the Health & Risk page",
					"User is on the Health & Risk page",
					Report.color(tab)+"displayed successfully.", "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("User navigates to the Health & Risk page",
					"User is on the Health & Risk page",
					"Failed to load Health & Risk page", "FAIL");
			Assert.fail();
		}
	}
	
	public void verifySecurityAndTechnicalAdvisoryGrid(WebDriver driver)
	{
		System.out.println("Inside verifySecurityAndTechnicalAdvisoryGrid method");
		Log.info("Inside verifySecurityAndTechnicalAdvisoryGrid method");

		String securityTab = "";
		String technicalTab = "";

		try
		{		

				securityTab = CommonUtility.highlightElement(driver,obj_PortalPage.securityAdvisoryTab()).getText();

				technicalTab = CommonUtility.highlightElement(driver,obj_PortalPage.technicalAdvisoryTab()).getText();
				
				System.out.println("Security Advisory Tab is: "+securityTab);

				System.out.println("Technical Advisory Tab is: "+technicalTab);

				if((securityTab!=null) && (technicalTab!=null))
				{
					Report.put("User verifies if able to see the Security Advisories and Technical Advisories options to the left of the grid ",
							"User should be able to view the Security Advisories and Technical Advisories options to the left of the grid 	",
							"Displayed Advisories grid in the left are: "+Report.color(securityTab), "PASS");	
				}
				else
				{
					System.out.println("Failed to display  Adivsories Tab in the left");

					Report.put("User verifies if able to see the Security Advisories and Technical Advisories options to the left of the grid ",
							"User should be able to view the Security Advisories and Technical Advisories options to the left of the grid 	",
							"Failed to display  Security Advisories and Technical Advisories options to the left of the grid ", "FAIL");						
					Assert.fail();
				}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Failed to display  Adivsories Tab in the left");

			Report.put("User verifies if able to see the Security Advisories and Technical Advisories options to the left of the grid ",
					"User should be able to view the Security Advisories and Technical Advisories options to the left of the grid 	",
					"Failed to display  Security Advisories and Technical Advisories options to the left of the grid ", "FAIL");						
			Assert.fail();
		}
	}
	
	public void clickSecurityAdvisoryTab(WebDriver driver)
	{
		System.out.println("Inside clickSecurityAdvisoryTab method");
		Log.info("Inside clickSecurityAdvisoryTab method");

		WebDriverWait wait = new WebDriverWait(driver, 120);
		
		String securityTab = "";
		String columns = "";
		try
		{		

			if(CommonUtility.CheckpresenceofElementLocated(driver, 30, obj_PortalPage.securityAdvisoryTab()))
			{
				securityTab = CommonUtility.highlightElement(driver,obj_PortalPage.securityAdvisoryTab()).getText();

				
				System.out.println("Security Advisory Tab is: "+securityTab);

				CommonUtility.highlightElement(driver,obj_PortalPage.securityAdvisoryTab()).click();
				
				Thread.sleep(5000);
				
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.securityAdvisoryColumns()));
				
				List<WebElement> list=driver.findElements(obj_PortalPage.securityAdvisoryColumns());

				for(WebElement lt:list)
				{
					CommonUtility.scrollToViewElement(driver, lt);
					CommonUtility.highlightElement(driver, lt);
					String col=lt.getText();
					if(!(col.isEmpty()))
					{
						System.out.println("Column is: " +col);
						columns+=" <br> " + col;
					}
				}
				System.out.println("Columns are: "+columns);
				
					Report.put("User clicks on the Security Advisory Tab  ",
							"User should be able to view the Security Advisories",
							"Clicked on tab "+Report.color(securityTab) +"with columns "+Report.color(columns), "PASS");	
				}
				else
				{
					System.out.println("Failed to click on Security Advisory Tab");

					Report.put("User clicks on the Security Advisory Tab  ",
							"User should be able to view the Security Advisories",
							"Failed to click  Security Advisory Tab", "FAIL");						
					Assert.fail();
				}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Failed to display  Adivsories Tab in the left");

			Report.put("User clicks on the Security Advisory Tab  ",
					"User should be able to view the Security Advisories",
					"Failed to click  Security Advisory Tab", "FAIL");				
			Assert.fail();
		}
	}
	
	public void verifySeverityColumn(WebDriver driver)
	{
		System.out.println("Inside verifySeverityColumn method");
		Log.info("Inside verifySeverityColumn method");

		String severityCol = "";
		String severityValue = "";
		try
		{		

			if(CommonUtility.CheckpresenceofElementLocated(driver, 30, obj_PortalPage.severityColumnHeading()))
			{
				severityCol = CommonUtility.highlightElement(driver,obj_PortalPage.severityColumnHeading()).getText();

				
				System.out.println("Severity Column Heading is: "+severityCol);

				severityValue = CommonUtility.highlightElement(driver,obj_PortalPage.severityColumnFirstRowValue()).getText();
				
				System.out.println("Severity Value is: "+severityValue);
				
				if((severityCol!=null) && (severityValue!=null))
				{
					System.out.println("Successfully displayed Severity Column & value");
				
					Report.put("User checks for severity column along with icon  ",
							"User should be able to view the severity column correct text each severity will also display the correct icon. From Critical-low",
							"Clicked on Security advisory tab and checked for column "+Report.color(severityCol)+" with Severity "+Report.color(severityValue), "PASS");	
				}
				else
				{
					System.out.println("Failed to check for severity column");

					Report.put("User checks for severity column along with icon  ",
							"User should be able to view the severity column correct text each severity will also display the correct icon. From Critical-low",
							"Failed to check for severity column", "FAIL");						
					Assert.fail();
				}
			}
			else
			{
				System.out.println("Failed to check for severity column");

				Report.put("User checks for severity column along with icon  ",
						"User should be able to view the severity column correct text each severity will also display the correct icon. From Critical-low",
						"Failed to check for severity column", "FAIL");						
				Assert.fail();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Failed to  check for severity column");

			Report.put("User checks for severity column along with icon  ",
					"User should be able to view the severity column correct text each severity will also display the correct icon. From Critical-low",
					"Failed to check for severity column", "FAIL");						
			Assert.fail();
		}
	}
	
	public void verifyAdvisoryColumn(WebDriver driver)
	{
		System.out.println("Inside verifyAdvisoryColumn method");
		Log.info("Inside verifyAdvisoryColumn method");

		String advisoryCol = "";
		String advisoryValue = "";
		try
		{		

			if(CommonUtility.CheckpresenceofElementLocated(driver, 30, obj_PortalPage.advisoryColumnHeading()))
			{
				advisoryCol = CommonUtility.highlightElement(driver,obj_PortalPage.advisoryColumnHeading()).getText();

				
				System.out.println("Advisory Column Heading is: "+advisoryCol);

				advisoryValue = CommonUtility.highlightElement(driver,obj_PortalPage.advisoryColumnFirstRowValue()).getText();
				
				System.out.println("Advisory Value is: "+advisoryValue);
				
				if((advisoryCol!=null) && (advisoryValue!=null))
				{
					System.out.println("Successfully displayed Advisory Column & value");
				
					Report.put("User verifies for the Advisory column ",
							"User should be able to view the advisory and the column will contain the advisory ID as a hyperlink",
							"Checked for column "+Report.color(advisoryCol)+" with Severity "+Report.color(advisoryValue), "PASS");	
				}
				else
				{
					System.out.println("Failed to check for Advisory column");

					Report.put("User verifies for the Advisory column ",
							"User should be able to view the advisory and the column will contain the advisory ID as a hyperlink",
							"Failed to check for Advisory column", "FAIL");						
					Assert.fail();
				}
			}
			else
			{
				System.out.println("Failed to check for Advisory column");

				Report.put("User verifies for the Advisory column ",
						"User should be able to view the advisory and the column will contain the advisory ID as a hyperlink",
						"Failed to check for Advisory column", "FAIL");						
				Assert.fail();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Failed to check for Advisory column");

			Report.put("User verifies for the Advisory column ",
					"User should be able to view the advisory and the column will contain the advisory ID as a hyperlink",
					"Failed to check for Advisory column", "FAIL");						
			Assert.fail();
		}
	}
	
	public void clickTechnicalAdvisoryTab(WebDriver driver)
	{
		System.out.println("Inside clickTechnicalAdvisoryTab method");
		Log.info("Inside clickTechnicalAdvisoryTab method");

		String technicalTab = "";
		String columns = "";
		try
		{		

			if(CommonUtility.CheckpresenceofElementLocated(driver, 30, obj_PortalPage.technicalAdvisoryTab()))
			{
				technicalTab = CommonUtility.highlightElement(driver,obj_PortalPage.technicalAdvisoryTab()).getText();

				
				System.out.println("Technical Advisory Tab is: "+technicalTab);

				CommonUtility.highlightElement(driver,obj_PortalPage.technicalAdvisoryTab()).click();
				Thread.sleep(5000);
				
				List<WebElement> list=driver.findElements(obj_PortalPage.technicalAdvisoryColumns());

				for(WebElement lt:list)
				{
					CommonUtility.scrollToViewElement(driver, lt);
					CommonUtility.highlightElement(driver, lt);
					String col=lt.getText();
					if(!(col.isEmpty()))
					{
						System.out.println("Column is: " +col);
						columns+=" <br> " + col;
					}
				}
				System.out.println("Columns are: "+columns);
				
					Report.put("User navigates to the Technical Advisory tab ",
							"User is on Technical Advisory tab should be able to view the following Grid : products, Severity, Advisory ID, Title, Status, Status updated by, Article",
							"Clicked on tab "+Report.color(technicalTab)+" with columns "+Report.color(columns), "PASS");	
				}
				else
				{
					System.out.println("Failed to click on Technical Advisory Tab");

					Report.put("User navigates to the Technical Advisory tab ",
							"User is on Technical Advisory tab should be able to view the following Grid : products, Severity, Advisory ID, Title, Status, Status updated by, Article",
							"Failed to click  Technical Advisory Tab", "FAIL");						
					Assert.fail();
				}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Failed to click on Technical Advisory Tab");

			Report.put("User navigates to the Technical Advisory tab ",
					"User is on Technical Advisory tab should be able to view the following Grid : products, Severity, Advisory ID, Title, Status, Status updated by, Article",
					"Failed to click  Technical Advisory Tab", "FAIL");						
			Assert.fail();
		}
	}
	
	public void clickInstallBaseVisualizationButton(WebDriver driver)
	{
		System.out.println("Inside clickInstallBaseVisualizationButton method");
		Log.info("Inside clickInstallBaseVisualizationButton method");

		
		String button = "";
		String header = "";
		
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);
			
			CommonUtility.highlightElement(driver,obj_PortalPage.visualizationsButton()).click();
			
			button = CommonUtility.highlightElement(driver,obj_PortalPage.visualizationsButton()).getText();
			
			System.out.println("Clicked on "+button);
			
			if(button!=null)
			{
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.visualizationsViewHeader()));
				header = CommonUtility.highlightElement(driver,obj_PortalPage.visualizationsViewHeader()).getText();
				
				Report.put("user navigates to Connectivity visualization  page (Graph View)",
						"User is on Connectivity visualization",
						"User is in the context of "+Report.color(button) +"with header "+Report.color(header), "PASS");
			}
			else
			{
				Report.put("user navigates to Connectivity visualization  page (Graph View)",
						"User is on Connectivity visualization",
						"Failed to navigate to Connectivity visualization  page (Graph View)", "FAIL");
				Assert.fail();	
			}
			
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("user navigates to Connectivity visualization  page (Graph View)",
					"User is on Connectivity visualization",
					"Failed to navigate to Connectivity visualization  page (Graph View)", "FAIL");
			Assert.fail();
		}
	}	
	
	
	public void clickVisualizationConnectedButton(WebDriver driver)
	{
		System.out.println("Inside clickVisualizationConnectedButton method");
		Log.info("Inside clickVisualizationConnectedButton method");

		
		String button = "";
		String header = "";
		
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);
			
			button = CommonUtility.highlightElement(driver,obj_PortalPage.visualizationsConnectedButton()).getText();
			
			CommonUtility.highlightElement(driver,obj_PortalPage.visualizationsConnectedButton()).click();
			

			
			System.out.println("Clicked on "+button);
			
			if(button!=null)
			{
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.connectivityBarChart()));
				
				Report.put("User clicks on connected  button on the Bar chart representing Connected / Non-Connected assets",
						"Full screen view should be displayed",
						"User clicked on "+Report.color(button) +"displaye Full Screen view successfully ", "PASS");
			}
			else
			{
				Report.put("User clicks on connected  button on the Bar chart representing Connected / Non-Connected assets",
						"Full screen view should be displayed",
						"Failed to click on Connected Button", "FAIL");
				Assert.fail();	
			}
			
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("User clicks on connected  button on the Bar chart representing Connected / Non-Connected assets",
					"Full screen view should be displayed",
					"Failed to click on Connected Button", "FAIL");
			Assert.fail();	
		}
	}
	
	public void applyConnectivityFilter(WebDriver driver)
	{
		System.out.println("Inside applyConnectivityFilter method");
		Log.info("Inside applyConnectivityFilter method");


		String option = "";
		String header = "";
		String notConnectedLabel = "";
		String filterBreadcrumb = "";
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);


			
			CommonUtility.scrollToViewElement(driver,(obj_PortalPage.connectivityStatusFilterOption()));
			option = CommonUtility.highlightElement(driver,obj_PortalPage.connectivityStatusFilterOption()).getText();

			CommonUtility.highlightElement(driver,obj_PortalPage.connectivityStatusFilterOption()).click();

			System.out.println("Clicked on option "+option);

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.connectivityStatusFilterOptionHeader()));

			CommonUtility.highlightElement(driver,obj_PortalPage.connectivityStatusFilterOptionHeader());

			header = CommonUtility.highlightElement(driver,obj_PortalPage.connectivityStatusFilterOptionHeader()).getText();

			System.out.println("Header is "+header);


			CommonUtility.highlightElement(driver,obj_PortalPage.connectivityStatusFilterOptionNotConnected());

			notConnectedLabel = CommonUtility.highlightElement(driver,obj_PortalPage.connectivityStatusFilterOptionNotConnected()).getText();

			System.out.println("Not Connected Label is "+notConnectedLabel);

			CommonUtility.scrollToViewElement(driver,(obj_PortalPage.connectivityStatusFilterOptionNotConnected()));

			CommonUtility.ToClickByUsingJavaScript_PassingByLoc(driver,obj_PortalPage.connectivityStatusFilterOptionNotConnected());

			CommonUtility.scrollToViewElement(driver,(obj_PortalPage.incidentManagementFilterByPopupApplySelectedButton())).click();



			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.incidentManagementFilterByPopupHeader()));
			CommonUtility.highlightElement(driver,obj_PortalPage.incidentManagementFilterByPopupCloseButton()).click();

			CommonUtility.highlightElement(driver,obj_PortalPage.breadcrumbConnectivityStatus());
			filterBreadcrumb = CommonUtility.highlightElement(driver,obj_PortalPage.breadcrumbConnectivityStatus()).getText();

			System.out.println("Filter displayed in breadcrumb "+filterBreadcrumb);

			Report.put("User changes the filter from  'Connected' to 'not connected' in the Filter By section ",
					"User  should be able to change the filter to 'Not Connected in the Filter By section ",
					"Clicked on filter"+Report.color(option)+"with" + Report.color(notConnectedLabel)+".Displayed filter in breadcrumb"+Report.color(filterBreadcrumb), "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();

			Report.put("User changes the filter from  'Connected' to 'not connected' in the Filter By section ",
					"User  should be able to change the filter to 'Not Connected in the Filter By section ",
					"Failed to Apply the Filter", "FAIL");
			Assert.fail();
		}
	}

	
	public void clickConnectivityBackButtonAndVerifyBreadcrumb(WebDriver driver)
	{
		System.out.println("Inside clickConnectivityBackButtonAndVerifyBreadcrumb method");
		Log.info("Inside clickConnectivityBackButtonAndVerifyBreadcrumb method");

		
		String button = "";
		String header = "";
		
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);
			
			button = CommonUtility.highlightElement(driver,obj_PortalPage.connectivityBackButton()).getText();
			
			CommonUtility.highlightElement(driver,obj_PortalPage.connectivityBackButton()).click();
		
			
			System.out.println("Clicked on "+button);
			
			if(button!=null)
			{
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.visualizationsViewHeader()));
				
				if(!(CommonUtility.CheckpresenceofElementLocated(driver, 10, obj_PortalPage.breadcrumbConnectivityStatus())))
				{
				Report.put("User closes the full screen view",
						"the applied filters in full screen should not be persisting in the normal view ",
						"User clicked on "+Report.color(button) +" applied filters in full screen is not persisting in the normal view", "PASS");
				}
			}
			else
			{
				Report.put("User closes the full screen view",
						"the applied filters in full screen should not be persisting in the normal view ",
						"Failed to close the full screen view", "FAIL");
				Assert.fail();	
			}
			
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("User clicks on connected  button on the Bar chart representing Connected / Non-Connected assets",
					"Full screen view should be displayed",
					"Failed to click on Connected Button", "FAIL");
			Assert.fail();	
		}
	}
	
	//Lavanya
	
			public void ClickOnFilterAndSelectsFilterWithNoDataAssociated(WebDriver driver)
			{

				Log.info("ClickOnFilterAndSelectsFilterWithNoDataAssociated");	
				WebDriverWait wait = new WebDriverWait(driver, 240);
				String text="";
				String text1="";
				String map="";
				String text2="";
				String defaults="";
				String text3="";
				String text4="";
				String text5="";
				String text6="";
				driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
				Actions act=new Actions(driver);
				String value=TestNGCreator.TestData.get(Esupport.Dpid.ordinal());
				try
				{
					Thread.sleep(5000);
					CommonUtility.scrollToViewElement(driver,obj_PortalPage.FilterButton());
					//			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.IncidentsManagementTab()));
					if(CommonUtility.CheckpresenceofElementLocated(driver, 50, obj_PortalPage.FilterButton()))
					{
						//				act.moveToElement(CommonUtility.highlightElement(driver, obj_PortalPage.FilterButton())).build().perform();
						CommonUtility.scrollToViewElement(driver,obj_PortalPage.FilterButton());
						map=CommonUtility.highlightElement(driver,obj_PortalPage.FilterButton()).getText();
						System.out.println(map);
						CommonUtility.highlightElement(driver,obj_PortalPage.FilterButton()).click(); 
						driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
						Thread.sleep(5000);
						driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
						//				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.ProductNameInFiltersWindow()));
						CommonUtility.scrollToViewElement(driver,obj_PortalPage.ProductFamilyInFilterWindow());
						text2=CommonUtility.highlightElement(driver,obj_PortalPage.ProductFamilyInFilterWindow()).getText();
						System.out.println("Filter is "+text2);
						CommonUtility.highlightElement(driver,obj_PortalPage.ProductFamilyInFilterWindow()).click();
						Thread.sleep(5000);
						driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
						CommonUtility.scrollToViewElement(driver,obj_PortalPage.ConnectivityStatusHeading());
						defaults=CommonUtility.highlightElement(driver,obj_PortalPage.ConnectivityStatusHeading()).getText();
						System.out.println("sub filter selected  is "+defaults);

						CommonUtility.scrollToViewElement(driver,obj_PortalPage.SearchBoxInFilterWindow());
						CommonUtility.highlightElement(driver,obj_PortalPage.SearchBoxInFilterWindow());
						
						CommonUtility.scrollToViewElement(driver,obj_PortalPage.NoneOptionInProductFamilySubWindowInFilterWindow());
						CommonUtility.highlightElement(driver,obj_PortalPage.NoneOptionInProductFamilySubWindowInFilterWindow()).click();
						
						CommonUtility.scrollToViewElement(driver,obj_PortalPage.ApplySelectedInFilterWindow());
						text3=CommonUtility.highlightElement(driver,obj_PortalPage.ApplySelectedInFilterWindow()).getText();
						System.out.println("text is "+text3);

						CommonUtility.highlightElement(driver,obj_PortalPage.ApplySelectedInFilterWindow()).click();
						CommonUtility.scrollToViewElement(driver,obj_PortalPage.XButtonOnFilterWindow());
						CommonUtility.highlightElement(driver,obj_PortalPage.XButtonOnFilterWindow()).click();

						wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.NoDataErrorMessageInInstallBase()));
						
						CommonUtility.scrollToViewElement(driver,obj_PortalPage.NoDataErrorMessageInInstallBase());
						text6=CommonUtility.highlightElement(driver,obj_PortalPage.NoDataErrorMessageInInstallBase()).getText();
						System.out.println("error message for no data is "+text6);

//						List<WebElement> list1=driver.findElements(obj_PortalPage.OptionsUnderConnectivityStatusInFilterWindow());
		//
		//
//						for(WebElement lt:list1)
//						{
//							if(value=="ED")
//							{
		//
//								act.moveToElement(CommonUtility.highlightElement(driver, lt)).build().perform();
//								CommonUtility.highlightElement(driver, lt);
		//
//							}
//							else
//							{
//								CommonUtility.scrollToViewElement(driver, lt);
		//
//								//					act.moveToElement(CommonUtility.highlightElement(driver, lt)).build().perform();
//								CommonUtility.highlightElement(driver, lt);
//							}
		//
//							text=lt.getText();
//							text5+=" <br> "+text;
//						}
//						System.out.println("options under connectivity filter displayed "+text5);



						Report.put("user applies filter where no data is associated ", 
								"user verifies an error message 'No data has been found for Connectivity in given in the  data set.NOTE :If you received this message as a result of applying filters, please modify to expand your filters and search again.' is displayed" ,
								"user able to click on "+Report.color(map)+" and able to see "+Report.color(text2)+" and <br> after clicking on None option able to see error meaages for no data as "+Report.color(text6), "PASS");
					}
					else
					{
						System.out.println("not able to see filter button or it is disabled");
						Report.put("user applies filter where no data is associated ", 
								"user verifies an error message 'No data has been found for Connectivity in given in the  data set.NOTE :If you received this message as a result of applying filters, please modify to expand your filters and search again.' is displayed" ,
								"Failed to click on Filter button", "FAIL");

						Assert.fail();
					}

				}
				catch(Exception e)
				{
					Log.info(e);
					Report.put("user applies filter where no data is associated ", 
							"user verifies an error message 'No data has been found for Connectivity in given in the  data set.NOTE :If you received this message as a result of applying filters, please modify to expand your filters and search again.' is displayed" ,
							"Failed to click on Filter button", "FAIL");
					e.printStackTrace();
					Assert.fail();
				}

			} 
			
			
			public void DoubleClickOnMapToZoomIn(WebDriver driver)
			{

				Log.info("Entering DoubleClickOnMapToZoomIn");	
				WebDriverWait wait = new WebDriverWait(driver, 240);
				String text="";
				String text1="";
				String map="";
				String text2="";
				String defaults="";
				String text3="";
				String text4="";
				String text5="";
				String text6="";
				driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
				Actions act=new Actions(driver);
				String value=TestNGCreator.TestData.get(Esupport.Dpid.ordinal());
				try
				{
					Thread.sleep(5000);

					if(CommonUtility.CheckpresenceofElementLocated(driver, 50, obj_PortalPage.WhiteSpotsThatIndicateSiteLocation()))
					{
						
						
						act.moveToElement(CommonUtility.highlightElement(driver, obj_PortalPage.WhiteSpotsThatIndicateSiteLocation())).doubleClick().build().perform();
						
						

						List<WebElement> list1=driver.findElements(obj_PortalPage.LocationNameForZoomOutMap());
		
		
						for(WebElement lt:list1)
						{
							if(value=="ED")
							{
		
								act.moveToElement(CommonUtility.highlightElement(driver, lt)).build().perform();
								CommonUtility.highlightElement(driver, lt);
		
							}
							else
							{
								CommonUtility.scrollToViewElement(driver, lt);
								CommonUtility.highlightElement(driver, lt);
							}
		
							text=lt.getText();
							text5+=" <br> "+text;
						}
						System.out.println("able to see location names on zoom in "+text5);



						Report.put("user  should be able to see location names on zoom in", 
								"User able to see location names on zoom in" ,
								"use able to zoom in and able to see location names as "+Report.color(text5), "PASS");
					}
					else
					{
						System.out.println("not able to see location names on zoom in");
						Report.put("user  should be able to see location names on zoom in", 
								"User able to see location names on zoom in" ,
								"Failed to double click on map", "FAIL");

						Assert.fail();
					}

				}
				catch(Exception e)
				{
					Log.info(e);
					Report.put("user  should be able to see location names on zoom in", 
							"User able to see location names on zoom in" ,
							"Failed to double click on map", "FAIL");
					e.printStackTrace();
					Assert.fail();
				}

			} 
			
			
			public void ValidateForLocationNamesForZoomOut(WebDriver driver)
			{

				Log.info("Entering ValidateForLocationNamesForZoomOut");	
				WebDriverWait wait = new WebDriverWait(driver, 240);
				String text="";
				String text1="";
				String map="";
				String text2="";
				String defaults="";
				String text3="";
				String text4="";
				String text5="";
				String text6="";
				driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
				Actions act=new Actions(driver);
				String value=TestNGCreator.TestData.get(Esupport.Dpid.ordinal());
				try
				{
					Thread.sleep(5000);

					if(CommonUtility.CheckpresenceofElementLocated(driver, 10, obj_PortalPage.LocationNameForZoomOutMap()))
					{
						
						
						System.out.println("able to see location names on zoom out");
						Report.put("user  should not be able to see location names on zoom out", 
								" location names should be removed on zoom out " ,
								"able to see location names on zoom out", "FAIL");
						Assert.fail();
						
					}
					else
					{
						Report.put("user  should not be able to see location names on zoom out", 
								" location names should be removed on zoom out " ,
								"use able to zoom out and not able to see location names on zoom out", "PASS");

					}

				}
				catch(Exception e)
				{
					Log.info(e);
					Report.put("user  should not be able to see location names on zoom out", 
							" location names should be removed on zoom out " ,
							"able to see location names on zoom out", "FAIL");
					e.printStackTrace();
					Assert.fail();
				}

			} 
			
			
			public void ValidateDefaultDisplayedContractsOnHUDContractsCircle(WebDriver driver)
			{

				Log.info("Entering ValidateDefaultDisplayedContractsOnHUDContractsCircle");	
				WebDriverWait wait = new WebDriverWait(driver, 240);
				String text="";
				String text1="";
				String map="";
				driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
				Actions act=new Actions(driver);
				String value=TestNGCreator.TestData.get(Esupport.Dpid.ordinal());
				try
				{
					
					if(CommonUtility.CheckpresenceofElementLocated(driver, 20, obj_PortalPage.DisplayedContractsInHUDByDefault()))
					{
//						CommonUtility.scrollToViewElement(driver,obj_PortalPage.DisplayedContractsInHUDByDefault());
						map=CommonUtility.highlightElement(driver,obj_PortalPage.DisplayedContractsInHUDByDefault()).getText();
						System.out.println(map);
						
						Report.put("user checks if able  to view to see the count of  assets with Contracts that have status of 'Expired' by default ", 
								"user should be able to see the count of  assets with Contracts that have status of 'Expired' by default" ,
								"user able to see "+Report.color(map)+" by default", "PASS");
					}
					else
					{
						System.out.println("not able to see see Expired contracts displayed by default on HUD of Contracts");
						Report.put("user checks if able  to view to see the count of  assets with Contracts that have status of 'Expired' by default ", 
								"user should be able to see the count of  assets with Contracts that have status of 'Expired' by default" ,
								"Failed to see Expired contracts displayed by default on HUD of Contracts", "FAIL");

						Assert.fail();
					}

				}
				catch(Exception e)
				{
					Log.info(e);
					Report.put("user checks if able  to view to see the count of  assets with Contracts that have status of 'Expired' by default ", 
							"user should be able to see the count of  assets with Contracts that have status of 'Expired' by default" ,
							"Failed to see Expired contracts displayed by default on HUD of Contracts", "FAIL");
					e.printStackTrace();
					Assert.fail();
				}

			} 
			
			public void ValidateMouseOverOnArcSectionsOfContractsHUD(WebDriver driver)
			{

				Log.info("Entering ValidateMouseOverOnArcSectionsOfContractsHUD");	
				WebDriverWait wait = new WebDriverWait(driver, 240);
				String text="";
				String text1="";
				String text2="";
				String text3="";
				String map="";
				driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
				Actions act=new Actions(driver);
				String value=TestNGCreator.TestData.get(Esupport.Dpid.ordinal());
				try
				{
					
					if(CommonUtility.CheckpresenceofElementLocated(driver, 20, obj_PortalPage.ExpiringWithin30DaysContractsInHUD()))
					{
//						Thread.sleep(7000);
//						CommonUtility.scrollToViewElement(driver,obj_PortalPage.ExpiringWithin30DaysContractsInHUD());
						act.moveToElement(CommonUtility.highlightElement(driver,obj_PortalPage.ExpiringWithin30DaysContractsInHUD())).build().perform();
//						act.moveToElement(CommonUtility.highlightElement(driver,obj_PortalPage.ExpiringWithin30DaysContractsInHUD())).click().build().perform();
						Thread.sleep(3000);
//						map=CommonUtility.highlightElement(driver,obj_PortalPage.GetTextFromContractsCircleInHUD()).getText();
						map=driver.findElement(obj_PortalPage.GetTextFromContractsCircleInHUD()).getText();
						System.out.println(map);
						
						Thread.sleep(5000);
						
//						CommonUtility.scrollToViewElement(driver,obj_PortalPage.ExpiringWithIn31To180DaysContractsInHUD());
//						CommonUtility.highlightElement(driver,obj_PortalPage.ExpiringWithIn31To180DaysContractsInHUD()).click();
						act.moveToElement(CommonUtility.highlightElement(driver,obj_PortalPage.ExpiringWithIn31To180DaysContractsInHUD())).build().perform();
//						act.moveToElement(CommonUtility.highlightElement(driver,obj_PortalPage.ExpiringWithIn31To180DaysContractsInHUD())).click().build().perform();
						Thread.sleep(3000);
//						text=CommonUtility.highlightElement(driver,obj_PortalPage.GetTextFromContractsCircleInHUD()).getText();
						text=driver.findElement(obj_PortalPage.GetTextFromContractsCircleInHUD()).getText();
						System.out.println(text);
						
						Thread.sleep(5000);
						
//						CommonUtility.scrollToViewElement(driver,obj_PortalPage.ContractSothersContractsInHUD());
//						CommonUtility.highlightElement(driver,obj_PortalPage.ContractSothersContractsInHUD()).click();
						act.moveToElement(CommonUtility.highlightElement(driver,obj_PortalPage.ContractSothersContractsInHUD())).build().perform();
//						act.moveToElement(CommonUtility.highlightElement(driver,obj_PortalPage.ContractSothersContractsInHUD())).click().build().perform();
						Thread.sleep(3000);
//						text1=CommonUtility.highlightElement(driver,obj_PortalPage.GetTextFromContractsCircleInHUD()).getText();
						text1=driver.findElement(obj_PortalPage.GetTextFromContractsCircleInHUD()).getText();
						System.out.println(text1);
						
						Thread.sleep(7000);
						
//						CommonUtility.scrollToViewElement(driver,obj_PortalPage.ExpiredContractsInHUD());
//						CommonUtility.highlightElement(driver,obj_PortalPage.ExpiredContractsInHUD()).click();
						act.moveToElement(CommonUtility.highlightElement(driver,obj_PortalPage.ExpiredContractsInHUD())).build().perform();
//						act.moveToElement(CommonUtility.highlightElement(driver,obj_PortalPage.ExpiredContractsInHUD())).click().build().perform();
						Thread.sleep(3000);
//						text2=CommonUtility.highlightElement(driver,obj_PortalPage.GetTextFromContractsCircleInHUD()).getText();
						text2=driver.findElement(obj_PortalPage.GetTextFromContractsCircleInHUD()).getText();
						System.out.println(text2);
						
						Report.put("user hovers the mouse over the the '<contractStatus>' sections of the CONTRACTS HUD", 
								"user should be able to see the count of assets with Contracts that have status of   '<contractStatus>' assets" ,
								"user able to mouse over on Expired contracts arc and see "+Report.color(text2)+" and user able to mouse over on Expiring with in 30 days contract arc and able to see "+Report.color(map)+"<br> and user able to mouse over on expiring with in 31 to 180 days contracts arc and able to see "+Report.color(text)+" <br> and able to mouse over on all other arc and able to see "+Report.color(text1), "PASS");
					}
					else
					{
						System.out.println("not able to see all arcs in HUD for contracts");
						Report.put("user hovers the mouse over the the '<contractStatus>' sections of the CONTRACTS HUD", 
								"user should be able to see the count of assets with Contracts that have status of   '<contractStatus>' assets" ,
								"Failed to mouse over on '<contractStatus>'", "FAIL");

						Assert.fail();
					}

				}
				catch(Exception e)
				{
					Log.info(e);
					Report.put("user hovers the mouse over the the '<contractStatus>' sections of the CONTRACTS HUD", 
							"user should be able to see the count of assets with Contracts that have status of   '<contractStatus>' assets" ,
							"Failed to mouse over on '<contractStatus>'", "FAIL");
					e.printStackTrace();
					Assert.fail();
				}

			} 
			
			public void ValidateIconAndHeadingMouseHoveringOnCenterOfContractsHUD(WebDriver driver)
			{

				Log.info("Entering ValidateIconAndHeadingMouseHoveringOnCenterOfContractsHUD ");	
				WebDriverWait wait = new WebDriverWait(driver, 240);
				String text="";
				String text1="";
				String map="";
				driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
				Actions act=new Actions(driver);
				String value=TestNGCreator.TestData.get(Esupport.Dpid.ordinal());
				try
				{
					
					if(CommonUtility.CheckpresenceofElementLocated(driver, 20, obj_PortalPage.GetContractsHeadingMouseHoveringOnIt()))
					{
						CommonUtility.scrollToViewElement(driver,obj_PortalPage.GetContractsHeadingMouseHoveringOnIt());
//						map=CommonUtility.highlightElement(driver,obj_PortalPage.DisplayedContractsInHUDByDefault()).getText();
//						System.out.println(map);
						
//						CommonUtility.highlightElement(driver,obj_PortalPage.DisplayedContractsInHUDByDefault()).click();
						CommonUtility.ToClickByUsingJavaScript_PassingByLoc(driver,obj_PortalPage.DisplayedContractsInHUDByDefault());
						
						CommonUtility.scrollToViewElement(driver,obj_PortalPage.ContractsIconOnHUD());
						CommonUtility.highlightElement(driver,obj_PortalPage.ContractsIconOnHUD());
								
								
						CommonUtility.scrollToViewElement(driver,obj_PortalPage.DisplayedContractsInHUDByDefault());
						text=CommonUtility.highlightElement(driver,obj_PortalPage.DisplayedContractsInHUDByDefault()).getText();
						System.out.println(text);
						
						
						
						Report.put("user  navigates to the label displayed as '<contractStatus>' respectively ", 
								"user should be able to mouse over the center of the Contracts HUD to see the icon for Contracts" ,
								"user able to mouse over on center of Contracts HUD and able to see contracts icon with details as "+Report.color(text)+" by default", "PASS");
					}
					else
					{
						System.out.println("not able to mouse over on center of Contracts HUD");
						Report.put("user  navigates to the label displayed as '<contractStatus>' respectively ", 
								"user should be able to mouse over the center of the Contracts HUD to see the icon for Contracts" ,
								"Failed to mouse over on center of Contracts HUD", "FAIL");

						Assert.fail();
					}

				}
				catch(Exception e)
				{
					Log.info(e);
					Report.put("user  navigates to the label displayed as '<contractStatus>' respectively ", 
							"user should be able to mouse over the center of the Contracts HUD to see the icon for Contracts" ,
							"Failed to mouse over on center of Contracts HUD", "FAIL");
					e.printStackTrace();
					Assert.fail();
				}

			} 
		
	public void verifyHealthAndRiskPaginationOptions(WebDriver driver)
	{
		System.out.println("Inside verifyHealthAndRiskPaginationOptions method");
		Log.info("Inside verifyHealthAndRiskPaginationOptions method");

		String paginationLeftText = "";
		String paginationRightText = "";
		try
		{		

			if(CommonUtility.CheckpresenceofElementLocated(driver, 30, obj_PortalPage.healthAndRiskPaginationOptionsLeft()) && CommonUtility.CheckpresenceofElementLocated(driver, 30, obj_PortalPage.healthAndRiskPageSelectorRight()))
			{
				paginationLeftText = CommonUtility.highlightElement(driver,obj_PortalPage.healthAndRiskPaginationOptionsLeft()).getText();

				paginationRightText = CommonUtility.highlightElement(driver,obj_PortalPage.healthAndRiskPageSelectorRight()).getText();
				
				System.out.println("Pagination Options at the left : "+paginationLeftText);
				
				System.out.println("Pagination Options at the right : "+paginationRightText);


				Report.put("User scroll down to the bottom of grid and verifies if user is able to see the pagination options at bottom left of grid",
    					"User should be able to see the page size selector option at bottom right ",
						"Displaying Pagination Options at the left "+Report.color(paginationLeftText)+" and Page Selector at the right "+Report.color(paginationRightText), "PASS");	
			}
			else
			{
				System.out.println("Failed to verify Pagination Options");

				Report.put("User scroll down to the bottom of grid and verifies if user is able to see the pagination options at bottom left of grid",
    					"User should be able to see the page size selector option at bottom right ",
						"Failed to verify Pagination Options", "FAIL");						
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Failed to verify Pagination Options");

			Report.put("User scroll down to the bottom of grid and verifies if user is able to see the pagination options at bottom left of grid",
					"User should be able to see the page size selector option at bottom right ",
					"Failed to verify Pagination Options", "FAIL");								
			Assert.fail();
		}
	}
	
	public void verifyHealthAndRiskPaginationOptionLeft(WebDriver driver)
	{
		System.out.println("Inside verifyHealthAndRiskPaginationOptionLeft method");
		Log.info("Inside verifyHealthAndRiskPaginationOptionLeft method");

		String paginationLeftText = "";
		String pageNumber = "";
		String temp = "";
		try
		{		

			if(CommonUtility.CheckpresenceofElementLocated(driver, 30, obj_PortalPage.healthAndRiskPaginationOptionsLeft()))
			{
				paginationLeftText = CommonUtility.highlightElement(driver,obj_PortalPage.healthAndRiskPaginationOptionsLeft()).getText();

				pageNumber = CommonUtility.highlightElement(driver,obj_PortalPage.healthAndRiskPageNumberTextbox()).getAttribute("value");
				
				System.out.println("Pagination Options at the left : "+paginationLeftText);
				
				System.out.println("Page Number : "+pageNumber);

				String[] extractString = paginationLeftText.split("Page", 0);
				
				for (String a : extractString) 
				{
		            System.out.println(a);
		            temp = a;
				}
				System.out.println("Extracted String is: "+temp);

				pageNumber = "Page " + pageNumber + temp;
				System.out.println("pageNumber****** is: "+pageNumber);
				
				Report.put("User verifies pagination option at bottom left as  |< < Page X of Y  > >| (where X is current page and Y is total no of pages)",
    					"User should be able to view the pagination option at bottom left as  |< < Page X of Y  > >| (where X is current page and Y is total no of pages) ",
						"Displaying Pagination Option at bottom left as "+Report.color(pageNumber), "PASS");	
			}
			else
			{
				System.out.println("Failed to verify Pagination Option at bottom left");

				Report.put("User verifies pagination option at bottom left as  |< < Page X of Y  > >| (where X is current page and Y is total no of pages)",
    					"User should be able to view the pagination option at bottom left as  |< < Page X of Y  > >| (where X is current page and Y is total no of pages) ",
						"Failed to verify Pagination Option at bottom left", "FAIL");						
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Failed to verify Pagination Option at bottom left");

			Report.put("User verifies pagination option at bottom left as  |< < Page X of Y  > >| (where X is current page and Y is total no of pages)",
					"User should be able to view the pagination option at bottom left as  |< < Page X of Y  > >| (where X is current page and Y is total no of pages) ",
					"Failed to verify Pagination Option at bottom left", "FAIL");						
			Assert.fail();
		}
	}
	
	public void verifyHealthAndRiskPaginationOptionRight(WebDriver driver)
	{
		System.out.println("Inside verifyHealthAndRiskPaginationOptionRight method");
		Log.info("Inside verifyHealthAndRiskPaginationOptionRight method");

		String paginationRightText = "";
		try
		{		

			if(CommonUtility.CheckpresenceofElementLocated(driver, 30, obj_PortalPage.healthAndRiskPageSelectorRight()))
			{
				paginationRightText = CommonUtility.highlightElement(driver,obj_PortalPage.healthAndRiskPageSelectorRight()).getText();
				
				System.out.println("Pagination Options at the right : "+paginationRightText);


				Report.put("User verifies if the page selector options at bottom right as Displaying 1-X of Y  X per page (where X is the page size and Y is the total no of records) ",
    					"User should be able to view the page selector options at bottom right as Displaying 1-X of Y  X per page.",
						"Displaying Page Selector at the right "+Report.color(paginationRightText), "PASS");	
			}
			else
			{
				System.out.println("Failed to verify page selector options at bottom right");

				Report.put("User verifies if the page selector options at bottom right as Displaying 1-X of Y  X per page (where X is the page size and Y is the total no of records) ",
    					"User should be able to view the page selector options at bottom right as Displaying 1-X of Y  X per page.",
						"Failed to verify page selector options at bottom right", "FAIL");						
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Failed to verify page selector options at bottom right");

			Report.put("User verifies if the page selector options at bottom right as Displaying 1-X of Y  X per page (where X is the page size and Y is the total no of records) ",
					"User should be able to view the page selector options at bottom right as Displaying 1-X of Y  X per page.",
					"Failed to verify page selector options at bottom right", "FAIL");								
			Assert.fail();
		}
	}
	
	public void enterHealthAndRiskPageNumberWithinRange(WebDriver driver)
	{
		System.out.println("Inside enterHealthAndRiskPageNumberWithinRange method");
		Log.info("Inside enterHealthAndRiskPageNumberWithinRange method");

		String paginationLeftText = "";
		String pageNumber = "";
		int intPageNumber = 0;
		int enterPageNum = 0;
		String temp = "";
		try
		{		

			if(CommonUtility.CheckpresenceofElementLocated(driver, 30, obj_PortalPage.healthAndRiskPaginationOptionsLeft()))
			{
				paginationLeftText = CommonUtility.highlightElement(driver,obj_PortalPage.healthAndRiskPaginationOptionsLeft()).getText();

				pageNumber = CommonUtility.highlightElement(driver,obj_PortalPage.healthAndRiskPageNumberTextbox()).getAttribute("value");
				
				System.out.println("Pagination Options at the left : "+paginationLeftText);
				
				System.out.println("Page Number : "+pageNumber);

				String[] extractString = paginationLeftText.split("of", 0);
				
				for (String a : extractString) 
				{
		            System.out.println(a);
		            temp = a;
				}
				temp = temp.replaceAll("\\s", "");
				System.out.println("Extracted String is: "+temp);
				
				
				intPageNumber = Integer.parseInt(temp);

				System.out.println("Integer Page Number is: "+intPageNumber);
				
				enterPageNum = intPageNumber-1;
				
				String newPageNumber = Integer.toString(enterPageNum); 
				
				System.out.println("New  Page Number is: "+newPageNumber);
				
				CommonUtility.scrollToViewElement(driver,(obj_PortalPage.healthAndRiskPageNumberTextbox()));
				CommonUtility.highlightElement(driver,obj_PortalPage.healthAndRiskPageNumberTextbox()).clear();
				CommonUtility.highlightElement(driver,obj_PortalPage.healthAndRiskPageNumberTextbox()).sendKeys(newPageNumber);
				CommonUtility.highlightElement(driver,obj_PortalPage.healthAndRiskPageNumberTextbox()).sendKeys(Keys.ENTER);
				paginationLeftText = CommonUtility.highlightElement(driver,obj_PortalPage.healthAndRiskPaginationOptionsLeft()).getText();
				System.out.println("New Pagination Options at the left : "+paginationLeftText);
				
				pageNumber = CommonUtility.highlightElement(driver,obj_PortalPage.healthAndRiskPageNumberTextbox()).getAttribute("value");
				System.out.println("AFter entering New Page Number : "+pageNumber);
				Thread.sleep(10000);
				
				Report.put("User click inside the box and verifies if able to enter any page number  from the available range and get navigated to that page",
    					"user should be navigated to the page number entered from the available range ",
						"Entered Page Number & navigated to Page "+Report.color(newPageNumber), "PASS");	
			}
			else
			{
				System.out.println("Failed to enter Page Number");

				Report.put("User click inside the box and verifies if able to enter any page number  from the available range and get navigated to that page",
    					"user should be navigated to the page number entered from the available range ",
						"Failed to Enter Page Number", "FAIL");						
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Failed to enter Page Number");

			Report.put("User click inside the box and verifies if able to enter any page number  from the available range and get navigated to that page",
					"user should be navigated to the page number entered from the available range ",
					"Failed to Enter Page Number", "FAIL");					
			Assert.fail();
		}
	}
	
	public void enterHealthAndRiskPageNumberOutsideRange(WebDriver driver)
	{
		System.out.println("Inside enterHealthAndRiskPageNumberOutsideRange method");
		Log.info("Inside enterHealthAndRiskPageNumberOutsideRange method");

		String paginationLeftText = "";
		String pageNumber = "";
		int intPageNumber = 0;
		int enterPageNum = 0;
		String temp = "";
		try
		{		

			if(CommonUtility.CheckpresenceofElementLocated(driver, 30, obj_PortalPage.healthAndRiskPaginationOptionsLeft()))
			{
				paginationLeftText = CommonUtility.highlightElement(driver,obj_PortalPage.healthAndRiskPaginationOptionsLeft()).getText();

				pageNumber = CommonUtility.highlightElement(driver,obj_PortalPage.healthAndRiskPageNumberTextbox()).getAttribute("value");
				
				System.out.println("Pagination Options at the left : "+paginationLeftText);
				
				System.out.println("Page Number : "+pageNumber);

				String[] extractString = paginationLeftText.split("of", 0);
				
				for (String a : extractString) 
				{
		            System.out.println(a);
		            temp = a;
				}
				temp = temp.replaceAll("\\s", "");
				System.out.println("Extracted String is: "+temp);
				
				
				intPageNumber = Integer.parseInt(temp);

				System.out.println("Integer Page Number is: "+intPageNumber);
				
				enterPageNum = intPageNumber+1;
				
				String newPageNumber = Integer.toString(enterPageNum); 
				
				System.out.println("New  Page Number is: "+newPageNumber);
				
				CommonUtility.scrollToViewElement(driver,(obj_PortalPage.healthAndRiskPageNumberTextbox()));
				CommonUtility.highlightElement(driver,obj_PortalPage.healthAndRiskPageNumberTextbox()).clear();
				CommonUtility.highlightElement(driver,obj_PortalPage.healthAndRiskPageNumberTextbox()).sendKeys(newPageNumber);
				CommonUtility.highlightElement(driver,obj_PortalPage.healthAndRiskPageNumberTextbox()).sendKeys(Keys.ENTER);
				paginationLeftText = CommonUtility.highlightElement(driver,obj_PortalPage.healthAndRiskPaginationOptionsLeft()).getText();
				System.out.println("New Pagination Options at the left : "+paginationLeftText);
				
				pageNumber = CommonUtility.highlightElement(driver,obj_PortalPage.healthAndRiskPageNumberTextbox()).getAttribute("value");
				System.out.println("AFter entering New Page Number : "+pageNumber);
				Thread.sleep(10000);
				
				Report.put("User enters a page number outside the page range",
    					"User remains on the same page  ",
						"Entered Page Number "+Report.color(newPageNumber)+ "and remains on to Page "+Report.color(pageNumber), "PASS");	
			}
			else
			{
				System.out.println("Failed to enter Page Number outside the page range");

				Report.put("User enters a page number outside the page range",
    					"User remains on the same page  ",
						"Failed to Enter Page Number outside the page range", "FAIL");						
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Failed to enter Page Number outside the page range");

			Report.put("User enters a page number outside the page range",
					"User remains on the same page  ",
					"Failed to Enter Page Number outside the page range", "FAIL");					
			Assert.fail();
		}
	}
	
	public void enterHealthAndRiskPageNumberCharacter(WebDriver driver)
	{
		System.out.println("Inside enterHealthAndRiskPageNumberCharacter method");
		Log.info("Inside enterHealthAndRiskPageNumberCharacter method");

		String paginationLeftText = "";
		String pageNumber = "";
		String newPageNumber = "c";
		String temp = "";
		try
		{		

			if(CommonUtility.CheckpresenceofElementLocated(driver, 30, obj_PortalPage.healthAndRiskPaginationOptionsLeft()))
			{
				paginationLeftText = CommonUtility.highlightElement(driver,obj_PortalPage.healthAndRiskPaginationOptionsLeft()).getText();

				pageNumber = CommonUtility.highlightElement(driver,obj_PortalPage.healthAndRiskPageNumberTextbox()).getAttribute("value");
				
				System.out.println("Pagination Options at the left : "+paginationLeftText);
				
				System.out.println("Page Number : "+pageNumber);


				CommonUtility.scrollToViewElement(driver,(obj_PortalPage.healthAndRiskPageNumberTextbox()));
				CommonUtility.highlightElement(driver,obj_PortalPage.healthAndRiskPageNumberTextbox()).clear();
				CommonUtility.highlightElement(driver,obj_PortalPage.healthAndRiskPageNumberTextbox()).sendKeys(newPageNumber);
				CommonUtility.highlightElement(driver,obj_PortalPage.healthAndRiskPageNumberTextbox()).sendKeys(Keys.ENTER);
				
				pageNumber = CommonUtility.highlightElement(driver,obj_PortalPage.healthAndRiskPageNumberTextbox()).getAttribute("value");
				System.out.println("AFter entering New Page Number : "+pageNumber);
				Thread.sleep(10000);
				
				Report.put("User tries to enter any character/special character in the box ",
    					"User remains on the same page  ",
						"Entered Page Number "+Report.color(newPageNumber)+ "and remains on to Page "+Report.color(pageNumber), "PASS");	
			}
			else
			{
				System.out.println("Failed to enter Page Number with character/special character");

				Report.put("User tries to enter any character/special character in the box ",
    					"User remains on the same page  ",
						"Failed to Enter Page Number with character/special character", "FAIL");						
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();

			System.out.println("Failed to enter Page Number with character/special character");

			Report.put("User tries to enter any character/special character in the box ",
					"User remains on the same page  ",
					"Failed to Enter Page Number with character/special character", "FAIL");				
			Assert.fail();
		}
	}
	
	public void verifyHealthAndRiskFirstPageButtonDisabled(WebDriver driver)
	{
		System.out.println("Inside verifyHealthAndRiskFirstPageButtonDisabled method");
		Log.info("Inside verifyHealthAndRiskFirstPageButtonDisabled method");

		String paginationLeftText = "";
		String pageNumber = "1";
		String classValue = "";
		try
		{		

			if(CommonUtility.CheckpresenceofElementLocated(driver, 30, obj_PortalPage.healthAndRiskPageNumberTextbox()))
			{
				
				CommonUtility.scrollToViewElement(driver,(obj_PortalPage.healthAndRiskPageNumberTextbox()));
				CommonUtility.highlightElement(driver,obj_PortalPage.healthAndRiskPageNumberTextbox()).clear();
				CommonUtility.highlightElement(driver,obj_PortalPage.healthAndRiskPageNumberTextbox()).sendKeys(pageNumber);
				CommonUtility.highlightElement(driver,obj_PortalPage.healthAndRiskPageNumberTextbox()).sendKeys(Keys.ENTER);
				
				pageNumber = CommonUtility.highlightElement(driver,obj_PortalPage.healthAndRiskPageNumberTextbox()).getAttribute("value");
				System.out.println("AFter entering Page Number : "+pageNumber);
				Thread.sleep(10000);
				
				classValue = CommonUtility.highlightElement(driver,obj_PortalPage.healthAndRiskFirstPageButton()).getAttribute("class");
				
				System.out.println("Class Attribute Value is: "+classValue);
				if(classValue.contains("disabled"))
				{
					System.out.println("Inside check disabled healthAndRiskFirstPageButton************* ");
					Report.put("User is in 1st page and clicks on |< button ",
		    				"User verifies nothing should happen in the grid and user should remain in same page and |< displays in disabled state. ",
							"Entered Page Number "+Report.color(pageNumber)+ "and user remains in same page and |< displays in disabled state.", "PASS");
				}	
				else
				{
					System.out.println("Failed to verify |< displayed in disabled state.");

					Report.put("User is in 1st page and clicks on |< button ",
		    				"User verifies nothing should happen in the grid and user should remain in same page and |< displays in disabled state. ",
							"Failed to verify |< displayed in disabled state.", "FAIL");						
					Assert.fail();
				}
			}
			else
			{
				System.out.println("Failed to verify |< displayed in disabled state.");

				Report.put("User is in 1st page and clicks on |< button ",
	    				"User verifies nothing should happen in the grid and user should remain in same page and |< displays in disabled state. ",
						"Failed to verify |< displayed in disabled state.", "FAIL");						
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();

			System.out.println("Failed to verify |< displayed in disabled state.");

			Report.put("User is in 1st page and clicks on |< button ",
    				"User verifies nothing should happen in the grid and user should remain in same page and |< displays in disabled state. ",
					"Failed to verify |< displayed in disabled state.", "FAIL");						
			Assert.fail();
		}
	}
	
	public void verifyHealthAndRiskPreviousPageButtonDisabled(WebDriver driver)
	{
		System.out.println("Inside verifyHealthAndRiskPreviousPageButtonDisabled method");
		Log.info("Inside verifyHealthAndRiskPreviousPageButtonDisabled method");

		String paginationLeftText = "";
		String pageNumber = "1";
		String classValue = "";
		try
		{		

			if(CommonUtility.CheckpresenceofElementLocated(driver, 30, obj_PortalPage.healthAndRiskPageNumberTextbox()))
			{
				
				CommonUtility.scrollToViewElement(driver,(obj_PortalPage.healthAndRiskPageNumberTextbox()));
				CommonUtility.highlightElement(driver,obj_PortalPage.healthAndRiskPageNumberTextbox()).clear();
				CommonUtility.highlightElement(driver,obj_PortalPage.healthAndRiskPageNumberTextbox()).sendKeys(pageNumber);
				CommonUtility.highlightElement(driver,obj_PortalPage.healthAndRiskPageNumberTextbox()).sendKeys(Keys.ENTER);
				
				pageNumber = CommonUtility.highlightElement(driver,obj_PortalPage.healthAndRiskPageNumberTextbox()).getAttribute("value");
				System.out.println("AFter entering Page Number : "+pageNumber);
				Thread.sleep(10000);
				
				classValue = CommonUtility.highlightElement(driver,obj_PortalPage.healthAndRiskPreviousPageButton()).getAttribute("class");
				
				System.out.println("Class Attribute Value is: "+classValue);
				
				if(classValue.contains("disabled"))
				{
					Report.put("User is in 1st page and clicks on < button",
		    				"User verifies nothing should happen in the grid and user should remain in same page and < displays in disabled state",
							"Entered Page Number "+Report.color(pageNumber)+ "and user remains in same page and < displays in disabled state.", "PASS");
				}	
				else
				{
					System.out.println("Failed to verify < displayed in disabled state.");

					Report.put("User is in 1st page and clicks on < button",
		    				"User verifies nothing should happen in the grid and user should remain in same page and < displays in disabled state",
							"Failed to verify < displayed in disabled state.", "FAIL");						
					Assert.fail();
				}
			}
			else
			{
				System.out.println("Failed to verify < displayed in disabled state.");

				Report.put("User is in 1st page and clicks on < button",
	    				"User verifies nothing should happen in the grid and user should remain in same page and < displays in disabled state",
						"Failed to verify < displayed in disabled state.", "FAIL");						
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();

			System.out.println("Failed to verify < displayed in disabled state.");

			Report.put("User is in 1st page and clicks on < button",
    				"User verifies nothing should happen in the grid and user should remain in same page and < displays in disabled state",
					"Failed to verify < displayed in disabled state.", "FAIL");						
			Assert.fail();
		}
	}
	
	public void verifyHealthAndRiskNextPageButtonDisabled(WebDriver driver)
	{
		System.out.println("Inside verifyHealthAndRiskNextPageButtonDisabled method");
		Log.info("Inside verifyHealthAndRiskNextPageButtonDisabled method");

		String paginationLeftText = "";
		String pageNumber = "1";
		String classValue = "";
		try
		{		

			if(CommonUtility.CheckpresenceofElementLocated(driver, 30, obj_PortalPage.healthAndRiskNextPageButton()))
			{
				
				CommonUtility.highlightElement(driver,obj_PortalPage.healthAndRiskLastPageButton()).click();
				
				
				classValue = CommonUtility.highlightElement(driver,obj_PortalPage.healthAndRiskNextPageButton()).getAttribute("class");
				
				System.out.println("Class Attribute Value is: "+classValue);
				
				if(classValue.contains("disabled"))
				{
					Report.put("User is in last page and clicks on > button",
		    				"User verifies nothing should happen in the grid and user should remain in same page and > displays in disabled state ",
							"User remains in same page and > displayed in disabled state.", "PASS");
				}	
				else
				{
					System.out.println("Failed to verify  > displayed in disabled state.");
					
					Report.put("User is in last page and clicks on > button",
		    				"User verifies nothing should happen in the grid and user should remain in same page and > displays in disabled state ",
							"Failed to verify > displayed in disabled state.", "FAIL");						
					Assert.fail();
				}
			}
			else
			{
				System.out.println("Failed to verify  > displayed in disabled state.");
				
				Report.put("User is in last page and clicks on > button",
	    				"User verifies nothing should happen in the grid and user should remain in same page and > displays in disabled state ",
						"Failed to verify > displayed in disabled state.", "FAIL");						
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();

			System.out.println("Failed to verify  > displayed in disabled state.");
			
			Report.put("User is in last page and clicks on > button",
    				"User verifies nothing should happen in the grid and user should remain in same page and > displays in disabled state ",
					"Failed to verify > displayed in disabled state.", "FAIL");						
			Assert.fail();
		}
	}
	
	public void verifyHealthAndRiskLastPageButtonDisabled(WebDriver driver)
	{
		System.out.println("Inside verifyHealthAndRiskLastPageButtonDisabled method");
		Log.info("Inside verifyHealthAndRiskLastPageButtonDisabled method");

		String paginationLeftText = "";
		String pageNumber = "1";
		String classValue = "";
		try
		{		

			if(CommonUtility.CheckpresenceofElementLocated(driver, 30, obj_PortalPage.healthAndRiskLastPageButton()))
			{
				
			//	CommonUtility.highlightElement(driver,obj_PortalPage.healthAndRiskLastPageButton()).click();
				
				
				classValue = CommonUtility.highlightElement(driver,obj_PortalPage.healthAndRiskLastPageButton()).getAttribute("class");
				
				System.out.println("Class Attribute Value is: "+classValue);
				
				if(classValue.contains("disabled"))
				{
					Report.put("User is in last page and clicks on >| button",
		    				"User verifies nothing should happen in the grid and user should remain in same page and >| displays in disabled state ",
							"User remains in same page and >| displayed in disabled state.", "PASS");
				}	
				else
				{
					System.out.println("Failed to verify  >| displayed in disabled state.");
					
					Report.put("User is in last page and clicks on >| button",
		    				"User verifies nothing should happen in the grid and user should remain in same page and >| displays in disabled state ",
							"Failed to verify >| displayed in disabled state.", "FAIL");						
					Assert.fail();
				}
			}
			else
			{
				System.out.println("Failed to verify  >| displayed in disabled state.");
				
				Report.put("User is in last page and clicks on >| button",
	    				"User verifies nothing should happen in the grid and user should remain in same page and >| displays in disabled state ",
						"Failed to verify >| displayed in disabled state.", "FAIL");						
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();

			System.out.println("Failed to verify  >| displayed in disabled state.");
			
			Report.put("User is in last page and clicks on >| button",
    				"User verifies nothing should happen in the grid and user should remain in same page and >| displays in disabled state ",
					"Failed to verify >| displayed in disabled state.", "FAIL");						
			Assert.fail();
		}
	}
	
	public void verifyHealthAndRiskNextPageNavigation(WebDriver driver)
	{
		System.out.println("Inside verifyHealthAndRiskNextPageNavigation method");
		Log.info("Inside verifyHealthAndRiskNextPageNavigation method");

		String paginationLeftText = "";
		String pageNumber = "";
		int intPageNumber = 0;
		int enterPageNum = 0;
		String temp = "";
		try
		{		

			if(CommonUtility.CheckpresenceofElementLocated(driver, 30, obj_PortalPage.healthAndRiskPaginationOptionsLeft()))
			{
				paginationLeftText = CommonUtility.highlightElement(driver,obj_PortalPage.healthAndRiskPaginationOptionsLeft()).getText();

				pageNumber = CommonUtility.highlightElement(driver,obj_PortalPage.healthAndRiskPageNumberTextbox()).getAttribute("value");
				
				System.out.println("Pagination Options at the left : "+paginationLeftText);
				
				System.out.println("Page Number : "+pageNumber);

				String[] extractString = paginationLeftText.split("of", 0);
				
				for (String a : extractString) 
				{
		            System.out.println(a);
		            temp = a;
				}
				temp = temp.replaceAll("\\s", "");
				System.out.println("Extracted String is: "+temp);
				
				
				intPageNumber = Integer.parseInt(temp);

				System.out.println("Integer Page Number is: "+intPageNumber);
				
				enterPageNum = intPageNumber-1;
				
				String newPageNumber = Integer.toString(enterPageNum); 
				
				System.out.println("New  Page Number is: "+newPageNumber);
				
				CommonUtility.scrollToViewElement(driver,(obj_PortalPage.healthAndRiskPageNumberTextbox()));
				CommonUtility.highlightElement(driver,obj_PortalPage.healthAndRiskPageNumberTextbox()).clear();
				CommonUtility.highlightElement(driver,obj_PortalPage.healthAndRiskPageNumberTextbox()).sendKeys(newPageNumber);
				CommonUtility.highlightElement(driver,obj_PortalPage.healthAndRiskPageNumberTextbox()).sendKeys(Keys.ENTER);
				paginationLeftText = CommonUtility.highlightElement(driver,obj_PortalPage.healthAndRiskPaginationOptionsLeft()).getText();
				System.out.println("New Pagination Options at the left : "+paginationLeftText);
				
				pageNumber = CommonUtility.highlightElement(driver,obj_PortalPage.healthAndRiskPageNumberTextbox()).getAttribute("value");
				System.out.println("AFter entering New Page Number : "+pageNumber);
				Thread.sleep(10000);
				CommonUtility.highlightElement(driver,obj_PortalPage.healthAndRiskNextPageButton()).click();
				
				Report.put("User navigates  to any page apart from last and first page and clicks on  > button",
    					"User should  be navigated to next page in the grid and so on.",
						"Entered Page Number & navigated to Page "+Report.color(newPageNumber), "PASS");	
			}
			else
			{
				System.out.println("Failed to navigate to Next Page");

				Report.put("User navigates  to any page apart from last and first page and clicks on  > button",
						"User should  be navigated to next page in the grid and so on.",
						"Failed to navigate to Next Page", "FAIL");						
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Failed to navigate to Next Page");

			Report.put("User navigates  to any page apart from last and first page and clicks on  > button",
					"User should  be navigated to next page in the grid and so on.",
					"Failed to navigate to Next Page", "FAIL");					
			Assert.fail();
		}
	}
	
	public void verifyHealthAndRiskLastPageNavigation(WebDriver driver)
	{
		System.out.println("Inside verifyHealthAndRiskLastPageNavigation method");
		Log.info("Inside verifyHealthAndRiskLastPageNavigation method");

		String paginationLeftText = "";
		String pageNumber = "";
		int intPageNumber = 0;
		int enterPageNum = 0;
		String temp = "";
		try
		{		

			if(CommonUtility.CheckpresenceofElementLocated(driver, 30, obj_PortalPage.healthAndRiskPaginationOptionsLeft()))
			{
				paginationLeftText = CommonUtility.highlightElement(driver,obj_PortalPage.healthAndRiskPaginationOptionsLeft()).getText();

				pageNumber = CommonUtility.highlightElement(driver,obj_PortalPage.healthAndRiskPageNumberTextbox()).getAttribute("value");
				
				System.out.println("Pagination Options at the left : "+paginationLeftText);
				
				System.out.println("Page Number : "+pageNumber);

				String[] extractString = paginationLeftText.split("of", 0);
				
				for (String a : extractString) 
				{
		            System.out.println(a);
		            temp = a;
				}
				temp = temp.replaceAll("\\s", "");
				System.out.println("Extracted String is: "+temp);
				
				
				intPageNumber = Integer.parseInt(temp);

				System.out.println("Integer Page Number is: "+intPageNumber);
				
				enterPageNum = intPageNumber-1;
				
				String newPageNumber = Integer.toString(enterPageNum); 
				
				System.out.println("New  Page Number is: "+newPageNumber);
				
				CommonUtility.scrollToViewElement(driver,(obj_PortalPage.healthAndRiskPageNumberTextbox()));
				CommonUtility.highlightElement(driver,obj_PortalPage.healthAndRiskPageNumberTextbox()).clear();
				CommonUtility.highlightElement(driver,obj_PortalPage.healthAndRiskPageNumberTextbox()).sendKeys(newPageNumber);
				CommonUtility.highlightElement(driver,obj_PortalPage.healthAndRiskPageNumberTextbox()).sendKeys(Keys.ENTER);
				paginationLeftText = CommonUtility.highlightElement(driver,obj_PortalPage.healthAndRiskPaginationOptionsLeft()).getText();
				System.out.println("New Pagination Options at the left : "+paginationLeftText);
				
				pageNumber = CommonUtility.highlightElement(driver,obj_PortalPage.healthAndRiskPageNumberTextbox()).getAttribute("value");
				System.out.println("AFter entering New Page Number : "+pageNumber);
				Thread.sleep(10000);
				CommonUtility.highlightElement(driver,obj_PortalPage.healthAndRiskLastPageButton()).click();
				
				Report.put("User navigates  to any page apart from last and first page and clicks on  >|  button",
    					"User should be navigated to the LAST page in the grid",
						"Entered Page Number & navigated to Last Page "+Report.color(newPageNumber), "PASS");	
			}
			else
			{
				System.out.println("Failed to navigate to Last Page");

				Report.put("User navigates  to any page apart from last and first page and clicks on  >|  button",
    					"User should be navigated to the LAST page in the grid",
						"Failed to navigate to LAST Page", "FAIL");						
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Failed to navigate to Last Page");

			Report.put("User navigates  to any page apart from last and first page and clicks on  >|  button",
					"User should be navigated to the LAST page in the grid",
					"Failed to navigate to LAST Page", "FAIL");							
			Assert.fail();
		}
	}
	
	public void verifyHealthAndRiskPreviousPageNavigation(WebDriver driver)
	{
		System.out.println("Inside verifyHealthAndRiskPreviousPageNavigation method");
		Log.info("Inside verifyHealthAndRiskPreviousPageNavigation method");

		String paginationLeftText = "";
		String pageNumber = "";
		int intPageNumber = 0;
		int enterPageNum = 0;
		String temp = "";
		try
		{		

			if(CommonUtility.CheckpresenceofElementLocated(driver, 30, obj_PortalPage.healthAndRiskPaginationOptionsLeft()))
			{
				paginationLeftText = CommonUtility.highlightElement(driver,obj_PortalPage.healthAndRiskPaginationOptionsLeft()).getText();

				pageNumber = CommonUtility.highlightElement(driver,obj_PortalPage.healthAndRiskPageNumberTextbox()).getAttribute("value");
				
				System.out.println("Pagination Options at the left : "+paginationLeftText);
				
				System.out.println("Page Number : "+pageNumber);

				String[] extractString = paginationLeftText.split("of", 0);
				
				for (String a : extractString) 
				{
		            System.out.println(a);
		            temp = a;
				}
				temp = temp.replaceAll("\\s", "");
				System.out.println("Extracted String is: "+temp);
				
				
				intPageNumber = Integer.parseInt(temp);

				System.out.println("Integer Page Number is: "+intPageNumber);
				
				enterPageNum = intPageNumber-1;
				
				String newPageNumber = Integer.toString(enterPageNum); 
				
				System.out.println("New  Page Number is: "+newPageNumber);
				
				CommonUtility.scrollToViewElement(driver,(obj_PortalPage.healthAndRiskPageNumberTextbox()));
				CommonUtility.highlightElement(driver,obj_PortalPage.healthAndRiskPageNumberTextbox()).clear();
				CommonUtility.highlightElement(driver,obj_PortalPage.healthAndRiskPageNumberTextbox()).sendKeys(newPageNumber);
				CommonUtility.highlightElement(driver,obj_PortalPage.healthAndRiskPageNumberTextbox()).sendKeys(Keys.ENTER);
				paginationLeftText = CommonUtility.highlightElement(driver,obj_PortalPage.healthAndRiskPaginationOptionsLeft()).getText();
				System.out.println("New Pagination Options at the left : "+paginationLeftText);
				
				pageNumber = CommonUtility.highlightElement(driver,obj_PortalPage.healthAndRiskPageNumberTextbox()).getAttribute("value");
				System.out.println("AFter entering New Page Number : "+pageNumber);
				Thread.sleep(10000);
				CommonUtility.highlightElement(driver,obj_PortalPage.healthAndRiskPreviousPageButton()).click();
				
				Report.put("User has navigated to any page apart from last and first page and clicks on < button ",
    					"User should be navigated to the previous page page in the grid  and so on",
						"Entered Page Number"+Report.color(newPageNumber)+" & navigated to Previous Page ", "PASS");	
			}
			else
			{
				System.out.println("Failed to navigate to Previous Page");

				Report.put("User has navigated to any page apart from last and first page and clicks on < button ",
    					"User should be navigated to the previous page page in the grid  and so on",
						"Failed to navigate to LAST Previous", "FAIL");						
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Failed to navigate to Previous Page");

			Report.put("User has navigated to any page apart from last and first page and clicks on < button ",
					"User should be navigated to the previous page page in the grid  and so on",
					"Failed to navigate to LAST Previous", "FAIL");						
			Assert.fail();
		}
	}
	
	public void verifyHealthAndRiskFirstPageNavigation(WebDriver driver)
	{
		System.out.println("Inside verifyHealthAndRiskFirstPageNavigation method");
		Log.info("Inside verifyHealthAndRiskFirstPageNavigation method");

		String paginationLeftText = "";
		String pageNumber = "";
		int intPageNumber = 0;
		int enterPageNum = 0;
		String temp = "";
		try
		{		

			if(CommonUtility.CheckpresenceofElementLocated(driver, 30, obj_PortalPage.healthAndRiskPaginationOptionsLeft()))
			{
				paginationLeftText = CommonUtility.highlightElement(driver,obj_PortalPage.healthAndRiskPaginationOptionsLeft()).getText();

				pageNumber = CommonUtility.highlightElement(driver,obj_PortalPage.healthAndRiskPageNumberTextbox()).getAttribute("value");
				
				System.out.println("Pagination Options at the left : "+paginationLeftText);
				
				System.out.println("Page Number : "+pageNumber);

				String[] extractString = paginationLeftText.split("of", 0);
				
				for (String a : extractString) 
				{
		            System.out.println(a);
		            temp = a;
				}
				temp = temp.replaceAll("\\s", "");
				System.out.println("Extracted String is: "+temp);
				
				
				intPageNumber = Integer.parseInt(temp);

				System.out.println("Integer Page Number is: "+intPageNumber);
				
				enterPageNum = intPageNumber-1;
				
				String newPageNumber = Integer.toString(enterPageNum); 
				
				System.out.println("New  Page Number is: "+newPageNumber);
				
				CommonUtility.scrollToViewElement(driver,(obj_PortalPage.healthAndRiskPageNumberTextbox()));
				CommonUtility.highlightElement(driver,obj_PortalPage.healthAndRiskPageNumberTextbox()).clear();
				CommonUtility.highlightElement(driver,obj_PortalPage.healthAndRiskPageNumberTextbox()).sendKeys(newPageNumber);
				CommonUtility.highlightElement(driver,obj_PortalPage.healthAndRiskPageNumberTextbox()).sendKeys(Keys.ENTER);
				paginationLeftText = CommonUtility.highlightElement(driver,obj_PortalPage.healthAndRiskPaginationOptionsLeft()).getText();
				System.out.println("New Pagination Options at the left : "+paginationLeftText);
				
				pageNumber = CommonUtility.highlightElement(driver,obj_PortalPage.healthAndRiskPageNumberTextbox()).getAttribute("value");
				System.out.println("AFter entering New Page Number : "+pageNumber);
				Thread.sleep(10000);
				CommonUtility.highlightElement(driver,obj_PortalPage.healthAndRiskPreviousPageButton()).click();
				
				Report.put("User has navigated to any page apart from last and first page and clicks on |< button ",
    					"User should be navigated to the FIRST page page in the grid  ",
						"Entered Page Number"+Report.color(newPageNumber)+" & navigated to First Page ", "PASS");	
			}
			else
			{
				System.out.println("Failed to navigate to FIRST Page");

				Report.put("User has navigated to any page apart from last and first page and clicks on |< button ",
    					"User should be navigated to the FIRST page page in the grid  ",
						"Failed to navigate to FIRST page", "FAIL");						
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Failed to navigate to FIRST Page");

			Report.put("User has navigated to any page apart from last and first page and clicks on |< button ",
					"User should be navigated to the FIRST page page in the grid  ",
					"Failed to navigate to FIRST page", "FAIL");					
			Assert.fail();
		}
	}
	
	public void verifyHealthAndRiskPageSelectorOptionsRight(WebDriver driver)
	{
		System.out.println("Inside verifyHealthAndRiskPageSelectorOptionsRight method");
		Log.info("Inside verifyHealthAndRiskPageSelectorOptionsRight method");

		String dropdownValues = "";
		
		try
		{	
			if(CommonUtility.CheckpresenceofElementLocated(driver, 30, obj_PortalPage.healthAndRiskPageSelectorDropdown()))
			{		
			
				WebElement selectElement = driver.findElement(obj_PortalPage.healthAndRiskPageSelectorDropdown());
				Select select = new Select(selectElement);
				List<WebElement> allOptions = select.getOptions();

				for(WebElement op:allOptions)
				{
					CommonUtility.highlightElement(driver,op);
					String value = op.getText();
					System.out.println("Value  is: " +value);
					dropdownValues+=" <br> " + value;
				}
				System.out.println("Dropdown Values : "+dropdownValues);

				Report.put("User navigates to the page selector section and clicks on the drop down box at the extreme bottom right of the page and  X drop-down(box)",
    					"User should be able to see the four options getting displayed:-10, 25, 50, 100",
						"Displaying Page Selector at the right and Dropdown Values are: "+Report.color(dropdownValues), "PASS");	
			}
			else
			{
				System.out.println("Failed to verify Page Dropdown Values at bottom right");

				Report.put("User navigates to the page selector section and clicks on the drop down box at the extreme bottom right of the page and  X drop-down(box)",
    					"User should be able to see the four options getting displayed:-10, 25, 50, 100",
						"Failed to verify Page Dropdown Values at bottom right", "FAIL");						
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Failed to verify Page Dropdown Values at bottom right");

			Report.put("User navigates to the page selector section and clicks on the drop down box at the extreme bottom right of the page and  X drop-down(box)",
					"User should be able to see the four options getting displayed:-10, 25, 50, 100",
					"Failed to verify Page Dropdown Values at bottom right", "FAIL");						
			Assert.fail();							
		}
	}
	
	public void selectHealthAndRiskPageSelectorDropdown(WebDriver driver)
	{
		System.out.println("Inside selectHealthAndRiskPageSelectorDropdown method");
		Log.info("Inside selectHealthAndRiskPageSelectorDropdown method");
		
		String paginationRightText = "";
		
		try
		{	
			if(CommonUtility.CheckpresenceofElementLocated(driver, 30, obj_PortalPage.healthAndRiskPageSelectorDropdown()))
			{		
			
				WebElement selectElement = driver.findElement(obj_PortalPage.healthAndRiskPageSelectorDropdown());
				Select select = new Select(selectElement);
				
				List<WebElement> allOptions = select.getOptions();

				Thread.sleep(5000);
				selectElement.click();
				Thread.sleep(5000);
				select.selectByIndex(1);
				
				WebElement selectedOption = select.getFirstSelectedOption();
				String option = selectedOption.getText();
			
				System.out.println("Selected Option is : "+option);
				
				paginationRightText = CommonUtility.highlightElement(driver,obj_PortalPage.healthAndRiskPageSelectorRight()).getText();
				
				System.out.println("Pagination Options at the right : "+paginationRightText);

				Report.put("User clicks on the page selector dropdown and selects  any value from the dropdown",
    					"User should be able to see selected value gets updated in the dropdown box, 'Displaying 1 to X of Y gets updated with X value.",
						"Selected value from the dropdown is: "+Report.color(option) +" and displayed "+Report.color(paginationRightText), "PASS");	
			}
			else
			{
				System.out.println("Failed to select value from the Dropdown.");

				Report.put("User clicks on the page selector dropdown and selects  any value from the dropdown",
    					"User should be able to see selected value gets updated in the dropdown box, 'Displaying 1 to X of Y gets updated with X value.",
						"Failed to select Page Dropdown Value ", "FAIL");						
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Failed to select value from the Dropdown.");

			Report.put("User clicks on the page selector dropdown and selects  any value from the dropdown",
					"User should be able to see selected value gets updated in the dropdown box, 'Displaying 1 to X of Y gets updated with X value.",
					"Failed to select Page Dropdown Value ", "FAIL");			
			Assert.fail();							
		}
	}
	
	public void clickSecurityAdvisoryIDFirstRow(WebDriver driver)
	{
		System.out.println("Inside clickSecurityAdvisoryIDFirstRow method");
		Log.info("Inside clickSecurityAdvisoryIDFirstRow method");

		String advisoryID = "";
		String affectedProdHeader = "";
		String prodList = "";
		
		WebDriverWait wait = new WebDriverWait(driver, 120);
		
		try
		{		

			if(CommonUtility.CheckpresenceofElementLocated(driver, 30, obj_PortalPage.advisoryColumnFirstRowValue()))
			{
				advisoryID = CommonUtility.highlightElement(driver,obj_PortalPage.advisoryColumnFirstRowValue()).getText();

				
				System.out.println("Clicked on Advisory ID "+advisoryID);

				CommonUtility.highlightElement(driver,obj_PortalPage.advisoryColumnFirstRowValue()).click();
				
				Thread.sleep(5000);		
				CommonUtility.scrollToViewElement(driver,(obj_PortalPage.advisoryDetailsPopupHeader()));

				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.advisoryDetailsPopupHeader()));
				
				
				if(CommonUtility.CheckpresenceofElementLocated(driver, 30, obj_PortalPage.advisoryDetailsPopupContent()))
				{
					affectedProdHeader = CommonUtility.highlightElement(driver,obj_PortalPage.advisoryDetailsPopupManageAffectedProductsHeader()).getText();

					
					System.out.println("Displayed "+affectedProdHeader);
					
					List<WebElement> list=driver.findElements(obj_PortalPage.advisoryDetailsPopupManageAffectedProductsList());
					for(WebElement lt:list)
					{
						CommonUtility.highlightElement(driver, lt);
						String prod=lt.getText();

						System.out.println("Product is: " +prod);
						prodList+=" <br> " + prod;
					}
					System.out.println("Products are:"+prodList);

				}
					Report.put("User clicks on Advisory ID in the Security Advisory grid   ",
							"Affected products view opens and User should be able to view  the expanded view of the article at the top of the page Manage Affected Products grid and  correct products are shown in the grid",
							"Clicked on Advisory ID "+Report.color(advisoryID) +"be able to view  the expanded view of the article at the top of the page. Displayed "+Report.color(affectedProdHeader) +"with Products "+Report.color(prodList), "PASS");	
				}
				else
				{
					System.out.println("Failed to click on Advisory ID ");

					Report.put("User clicks on Advisory ID in the Security Advisory grid   ",
							"Affected products view opens and User should be able to view  the expanded view of the article at the top of the page Manage Affected Products grid and  correct products are shown in the grid",
							"Failed to click on Advisory ID", "FAIL");						
					Assert.fail();
				}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Failed to click on Advisory ID ");

			Report.put("User clicks on Advisory ID in the Security Advisory grid   ",
					"Affected products view opens and User should be able to view  the expanded view of the article at the top of the page Manage Affected Products grid and  correct products are shown in the grid",
					"Failed to click on Advisory ID", "FAIL");						
			Assert.fail();
		}
	}
	
	public void verifyManageAffectedProductsColumns(WebDriver driver)
	{
		System.out.println("Inside verifyManageAffectedProductsColumns method");
		Log.info("Inside verifyManageAffectedProductsColumns method");
	
		String colList = "";
		
		WebDriverWait wait = new WebDriverWait(driver, 120);
		
		try
		{
			List<WebElement> list=driver.findElements(obj_PortalPage.advisoryDetailsPopupManageAffectedProductsColumns());
					for(WebElement lt:list)
					{
						CommonUtility.scrollToViewElement(driver, lt);
						String colName=lt.getText();
						if(!(colName.isEmpty()))
						{
							System.out.println("Column is: " +colName);
							colList+=" <br> " + colName;
						}
					}
					System.out.println("Columns are:"+colList);

				
					Report.put("Under Manage Affected Products grid User verifies the following columns are visible under the affected products view : Product Alias, Product ID, Instance ID, Site ID, Last Updated By, Date Updated, Notes, Resolution Tracking",
							"User should be able to view the following columns: Product Alias, Product ID, Instance ID, Site ID, Last Updated By, Date Updated, Notes, Resolution Tracking",
							"Columns displayed affected products are: "+Report.color(colList), "PASS");	
				
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Failed to verify Manage Affected Products grid Columns");

			Report.put("Under Manage Affected Products grid User verifies the following columns are visible under the affected products view : Product Alias, Product ID, Instance ID, Site ID, Last Updated By, Date Updated, Notes, Resolution Tracking",
					"User should be able to view the following columns: Product Alias, Product ID, Instance ID, Site ID, Last Updated By, Date Updated, Notes, Resolution Tracking",
					"Failed to verify Manage Affected Products grid Columns", "FAIL");						
			Assert.fail();
		}
	}
	
	public void verifyAdvisoryDetailsPopupProductsDefaultView(WebDriver driver)
	{
		System.out.println("Inside verifyAdvisoryDetailsPopupProductsDefaultView method");
		Log.info("Inside verifyAdvisoryDetailsPopupProductsDefaultView method");

		String advisoryID = "";
		String affectedProdHeader = "";
		String prodList = "";
		
		WebDriverWait wait = new WebDriverWait(driver, 120);
		
		try
		{		

			if(CommonUtility.CheckpresenceofElementLocated(driver, 20, obj_PortalPage.advisoryDetailsPopupManageAffectedProductsChevronUp()))
			{			
				CommonUtility.highlightElement(driver,obj_PortalPage.advisoryDetailsPopupManageAffectedProductsChevronUp());

				Report.put("User scrolls down the page and navigates to Manage Affected Products page ",
						"User should be able to see affected products grid is expanded ",
						"User is able to see affected products grid in expanded view", "PASS");	
			}					
			else
			{
				System.out.println("Failed to see affected products grid in expanded view");

				Report.put("User scrolls down the page and navigates to Manage Affected Products page ",
						"User should be able to see affected products grid is expanded ",
							"Failed to see affected products grid in expanded view", "FAIL");						
					Assert.fail();
				}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Failed to see affected products grid in expanded view");

			Report.put("User scrolls down the page and navigates to Manage Affected Products page ",
					"User should be able to see affected products grid is expanded ",
						"Failed to see affected products grid in expanded view", "FAIL");					
			Assert.fail();
		}
	}
	
	public void verifyAdvisoryDetailsPopupProductsCollapsedView(WebDriver driver)
	{
		System.out.println("Inside verifyAdvisoryDetailsPopupProductsCollapsedView method");
		Log.info("Inside verifyAdvisoryDetailsPopupProductsCollapsedView method");

		String advisoryID = "";
		String affectedProdHeader = "";
		String prodList = "";
		
		WebDriverWait wait = new WebDriverWait(driver, 120);
		
		try
		{		

			if(CommonUtility.CheckpresenceofElementLocated(driver, 20, obj_PortalPage.advisoryDetailsPopupManageAffectedProductsChevronUp()))
			{			
				CommonUtility.highlightElement(driver,obj_PortalPage.advisoryDetailsPopupManageAffectedProductsChevronUp()).click();

				if(CommonUtility.CheckpresenceofElementLocated(driver, 20, obj_PortalPage.advisoryDetailsPopupManageAffectedProductsChevronDown()))
				{
					Report.put("User clicks on the arrow icon in the product name/product family bar",
						"The product list for that family is collapsed",
						"The product list for that family is collapsed", "PASS");	
				}
				else
				{
					System.out.println("Failed to see affected products grid is collapsed");

					Report.put("User clicks on the arrow icon in the product name/product family bar",
							"The product list for that family is collapsed",
								"Failed to see affected products grid is collapsed", "FAIL");						
						Assert.fail();
					}
			}					
			else
			{
				System.out.println("Failed to see affected products grid is collapsed");

				Report.put("User clicks on the arrow icon in the product name/product family bar",
						"The product list for that family is collapsed",
							"Failed to see affected products grid is collapsed", "FAIL");						
					Assert.fail();
				}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Failed to see affected products grid is collapsed");

			Report.put("User clicks on the arrow icon in the product name/product family bar",
					"The product list for that family is collapsed",
						"Failed to see affected products grid is collapsed", "FAIL");						
				Assert.fail();
		}
	}
	
	public void verifyAdvisoryDetailsPopupProductsExpandedView(WebDriver driver)
	{
		System.out.println("Inside verifyAdvisoryDetailsPopupProductsExpandedView method");
		Log.info("Inside verifyAdvisoryDetailsPopupProductsExpandedView method");

		String advisoryID = "";
		String affectedProdHeader = "";
		String prodList = "";
		
		WebDriverWait wait = new WebDriverWait(driver, 120);
		
		try
		{		

			if(CommonUtility.CheckpresenceofElementLocated(driver, 20, obj_PortalPage.advisoryDetailsPopupManageAffectedProductsChevronDown()))
			{			
				CommonUtility.highlightElement(driver,obj_PortalPage.advisoryDetailsPopupManageAffectedProductsChevronDown()).click();

				if(CommonUtility.CheckpresenceofElementLocated(driver, 20, obj_PortalPage.advisoryDetailsPopupManageAffectedProductsChevronUp()))
				{
					Report.put("User clicks on the arrow icon in the product name/product family bar",
						"The product list for that family is expanded",
						"The product list for that family is expanded", "PASS");	
				}
				else
				{
					System.out.println("Failed to see affected products grid is expanded");

					Report.put("User clicks on the arrow icon in the product name/product family bar",
							"The product list for that family is expanded",
								"Failed to see affected products grid is expanded", "FAIL");						
						Assert.fail();
					}
			}					
			else
			{
				System.out.println("Failed to see affected products grid is expanded");

				Report.put("User clicks on the arrow icon in the product name/product family bar",
						"The product list for that family is expanded",
							"Failed to see affected products grid is expanded", "FAIL");						
					Assert.fail();
				}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Failed to see affected products grid is expanded");

			Report.put("User clicks on the arrow icon in the product name/product family bar",
					"The product list for that family is expanded",
						"Failed to see affected products grid is expanded", "FAIL");						
				Assert.fail();
		}
	}
	
	public void clickAdvisoryDetailsPopupCloseButton(WebDriver driver)
	{
		System.out.println("Inside clickAdvisoryDetailsPopupCloseButton method");
		Log.info("Inside clickAdvisoryDetailsPopupCloseButton method");

		
		WebDriverWait wait = new WebDriverWait(driver, 120);
		
		try
		{		

			if(CommonUtility.CheckpresenceofElementLocated(driver, 20, obj_PortalPage.advisoryDetailsPopupCloseButton()))
			{			
				CommonUtility.highlightElement(driver,obj_PortalPage.advisoryDetailsPopupCloseButton()).click();
			
			}					
			else
			{
				System.out.println("Failed to click Advisory Popup Close Button");								
				Assert.fail("Failed to click Advisory Popup Close Button");
				}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Failed to click Advisory Popup Close Button");					
			Assert.fail("Failed to click Advisory Popup Close Button");
		}
	}
	
	public void selectFilter(WebDriver driver, String filter)
	{
		System.out.println("Inside selectFilter");
		Log.info("Inside selectFilter");   
		
		Actions act = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, 120); 
		String header = "";
		
		try
		{			
				WebElement element = driver.findElement(By.xpath("//div[@class='filter-body']//ul//li//label[contains(text(),'"+filter+"')]"));
				CommonUtility.highlightElement(driver,element);
				CommonUtility.scrollToViewElement(driver, element); 
				Thread.sleep(4000);
				CommonUtility.ToClickByUsingJavaScript_PassingByLoc(driver, By.xpath("//div[@class='filter-body']//ul//li//label[contains(text(),'"+filter+"')]"));
				Thread.sleep(7000);
				
				System.out.println("Clicked on Filter "+filter); 
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.filterHeader()));

				Report.put("User selects the required Filter",
						"user  should be able to select the required filter ",
						"Selected Filter "+Report.color(filter), "PASS");
		}
		catch (Exception e)
		{
			Log.info(e);
			Report.put("User selects the required Filter",
					"user  should be able to select the required filter ",
					"Failed to select the filter", "FAIL");
			Assert.fail();
		}               
	} 
	
	public void clickFilterOption(WebDriver driver, String option)
	{
		// TODO Auto-generated method stub

		System.out.println("Inside clickFilterOption");
		Log.info("Inside clickFilterOption");   
		Actions act = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, 120); 
		String header = "";
		try
		{			
				WebElement element = driver.findElement(By.xpath("//div[@class='filter-body']//div//ul//li//span[text()='"+option+"']"));
				CommonUtility.highlightElement(driver,element);
				CommonUtility.scrollToViewElement(driver, element); 
				Thread.sleep(4000);
				CommonUtility.ToClickByUsingJavaScript_PassingByLoc(driver, By.xpath("//div[@class='filter-body']//div//ul//li//span[text()='"+option+"']"));
				Thread.sleep(7000);
				
				System.out.println("Clicked on Option "+option); 

				Report.put("User clicks on the required option",
						"User  should be able to choose the filter ",
						"Selected Filter Option "+Report.color(option), "PASS");
		}

		catch (Exception e)
		{
			Log.info(e);
			e.printStackTrace();
			Report.put("User clicks on the required option",
					"User  should be able to choose the filter ",
					"Failed to select Filter Option", "FAIL");
			Assert.fail();
		}               
	} 
	
	public void clickApplySelectedButton(WebDriver driver)
	{
		System.out.println("Inside clickApplySelectedButton");
		Log.info("Inside clickApplySelectedButton");   
		
		WebDriverWait wait = new WebDriverWait(driver, 120); 
		
		String button = "";
		try
		{	
			CommonUtility.scrollToViewElement(driver, obj_PortalPage.incidentManagementFilterByPopupApplySelectedButton()); 
			
			button = CommonUtility.highlightElement(driver, obj_PortalPage.incidentManagementFilterByPopupApplySelectedButton()).getText();
			
			CommonUtility.highlightElement(driver, obj_PortalPage.incidentManagementFilterByPopupApplySelectedButton()).click();
							
			System.out.println("Clicked on button "+button); 

			Report.put("User clicks on Apply Selected Button",
						"User  should be able click on  Apply Selected Button",
						"Clicked on Button "+Report.color(button), "PASS");
		}

		catch (Exception e)
		{
			Log.info(e);
			e.printStackTrace();
			Report.put("User clicks on Apply Selected Button",
					"User  should be able click on  Apply Selected Button",
					"Failed to click on Apply Selected Button", "FAIL");
			Assert.fail();
		}               
	} 
	
	public void verifyClearAllAndFilterCloseButton(WebDriver driver)
	{
		System.out.println("Inside verifyClearAllAndFilterCloseButton");
		Log.info("Inside verifyClearAllAndFilterCloseButton");   
		
		WebDriverWait wait = new WebDriverWait(driver, 120); 
		
		try
		{	
			if((CommonUtility.CheckpresenceofElementLocated(driver, 30, obj_PortalPage.incidentManagementFilterByPopupCloseButton())) && (CommonUtility.CheckpresenceofElementLocated(driver, 30, obj_PortalPage.incidentManagementFilterByPopupClearAllButton())))
			{
				CommonUtility.highlightElement(driver, obj_PortalPage.incidentManagementFilterByPopupCloseButton());
			
				CommonUtility.scrollToViewElement(driver, obj_PortalPage.incidentManagementFilterByPopupClearAllButton()); 
				
				CommonUtility.highlightElement(driver, obj_PortalPage.incidentManagementFilterByPopupClearAllButton());
							
				System.out.println("Displayed Clear All & X button "); 

				Report.put("user checks if a button is displayed at the bottom left with the label 'Clear All'",
						"user  should be able to verify a button displayed at the bottom left with the label 'clear all ' and  close cross icon is displayed at the top right corner",
						"Displayed Button with the label 'clear all ' and  close cross icon  at the top right corner", "PASS");
			}
			else
			{
				Report.put("user checks if a button is displayed at the bottom left with the label 'Clear All'",
						"user  should be able to verify a button displayed at the bottom left with the label 'clear all ' and  close cross icon is displayed at the top right corner",
						"Failed to display Button with the label 'clear all ' and  close cross icon  at the top right corner", "FAIL");
				Assert.fail();
			}
		}

		catch (Exception e)
		{
			Log.info(e);
			e.printStackTrace();
			Report.put("user checks if a button is displayed at the bottom left with the label 'Clear All'",
					"user  should be able to verify a button displayed at the bottom left with the label 'clear all ' and  close cross icon is displayed at the top right corner",
					"Failed to display Button with the label 'clear all ' and  close cross icon  at the top right corner", "FAIL");
			Assert.fail();
		}               
	} 
	
	public void clickFilterCloseButton(WebDriver driver)
	{
		System.out.println("Inside clickFilterCloseButton");
		Log.info("Inside clickFilterCloseButton");   
		
		WebDriverWait wait = new WebDriverWait(driver, 120); 
		
		try
		{	
			if(CommonUtility.CheckpresenceofElementLocated(driver, 30, obj_PortalPage.incidentManagementFilterByPopupCloseButton()))
			{
				CommonUtility.highlightElement(driver, obj_PortalPage.incidentManagementFilterByPopupCloseButton()).click();
				
							
				System.out.println("Clicked on Filter Close button"); 

				Report.put("User clicks on cross icon to close the Filter By window",
						"user should be back on in install base page ",
						"Clicked on close cross icon to close the Filter By window", "PASS");
			}
			else
			{
				Report.put("User clicks on cross icon to close the Filter By window",
						"user should be back on in install base page ",
						"Failed to click on close cross icon to close the Filter By window", "FAIL");
				Assert.fail("Failed to click on close cross icon to close the Filter By window");
			}
		}

		catch (Exception e)
		{
			Log.info(e);
			e.printStackTrace();
			Report.put("User clicks on cross icon to close the Filter By window",
					"user should be back on in install base page ",
					"Failed to click on close cross icon to close the Filter By window", "FAIL");
			Assert.fail("Failed to click on close cross icon to close the Filter By window");
		}               
	} 
	
	public void verifyProductFamilyFilterOptions(WebDriver driver)
	{
		// TODO Auto-generated method stub

		System.out.println("Inside verifyProductFamilyFilterOptions");
		Log.info("Inside verifyProductFamilyFilterOptions");   
		
		Actions act = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, 120); 
		
		String text1 = "Select All";
		String text2 = "None";
		String text3 = "AVAMAR";
		String text4 = "BACKUP AND RECOVERY";
		
		String selAll = "";
		String none = "";
		String avamar = "";
		String backupRecovery = "";
		
		String list = "";
		
		try
		{			
				WebElement element1 = driver.findElement(By.xpath("//div[@class='filter-body']//div//ul//li//label[text()=' "+text1+" ']"));
				
				selAll = element1.getText();
				
				WebElement element2 = driver.findElement(By.xpath("//div[@class='filter-body']//div//ul//li//span[text()='"+text2+"']"));
				
				none = element2.getText();
				
				WebElement element3 = driver.findElement(By.xpath("//div[@class='filter-body']//div//ul//li//span[text()='"+text3+"']"));
				
				avamar = element3.getText();
				
				WebElement element4 = driver.findElement(By.xpath("//div[@class='filter-body']//div//ul//li//span[text()='"+text4+"']"));
				
				backupRecovery = element4.getText();
				
				if((selAll.contains(text1)) && (none.contains(text2)) && (avamar.contains(text3)) && (backupRecovery.contains(text4)))
				{
					CommonUtility.highlightElement(driver,element1);
					Thread.sleep(2000);
					CommonUtility.highlightElement(driver,element2);
					Thread.sleep(2000);
					CommonUtility.highlightElement(driver,element3);
					Thread.sleep(2000);
					CommonUtility.highlightElement(driver,element4);				
								
					System.out.println("Displayed Options "+selAll+none+avamar+backupRecovery); 

					Report.put("User clicks on the expanding icon of the 'Product Family' option and choses the filter ",
						"User  should be able to see the options under Product Family. Select All, None, AVAMAR SW, BACKUP AND RECOVERY",
						"Displayed Filter Options "+Report.color(selAll) +"<br>"+Report.color(none)+"<br>"+Report.color(avamar)+"<br>"+Report.color(backupRecovery), "PASS");
				}
				else
				{
					Report.put("User clicks on the expanding icon of the 'Product Family' option and choses the filter ",
							"User  should be able to see the options under Product Family. Select All, None, AVAMAR SW, BACKUP AND RECOVERY",
							"Failed to display Product Family Filter Options", "FAIL");
					Assert.fail("Failed to display Product Family Filter Options");
				}
		}

		catch (Exception e)
		{
			Log.info(e);
			e.printStackTrace();
			Report.put("User clicks on the required option",
					"User  should be able to choose the filter ",
					"Failed to display Product Family Filter Options", "FAIL");
			Assert.fail("Failed to display Product Family Filter Options");
		}               
	} 
	
	public void verifyApplySelectedButton(WebDriver driver)
	{
		System.out.println("Inside verifyApplySelectedButton");
		Log.info("Inside verifyApplySelectedButton");   
		
		WebDriverWait wait = new WebDriverWait(driver, 120); 
		
		String button = "";
		try
		{	
			if(CommonUtility.CheckpresenceofElementLocated(driver, 30, obj_PortalPage.incidentManagementFilterByPopupApplySelectedButton()))
			{
			CommonUtility.scrollToViewElement(driver, obj_PortalPage.incidentManagementFilterByPopupApplySelectedButton()); 
			
			button = CommonUtility.highlightElement(driver, obj_PortalPage.incidentManagementFilterByPopupApplySelectedButton()).getText();
			
							
			System.out.println("Displayed button "+button); 

			Report.put("User verifies if a apply filter button is displayed with the label 'Apply Selected'",
						"User should be able to see an apply filter button is displayed with the label 'Apply Selected'",
						"Displayed Button "+Report.color(button), "PASS");
			}
			else
			{
				Report.put("User verifies if a apply filter button is displayed with the label 'Apply Selected'",
						"User should be able to see an apply filter button is displayed with the label 'Apply Selected'",
						"Failed to verify Apply Selected Button", "FAIL");
				Assert.fail("Failed to verify Apply Selected Button");
			}
		}
		catch (Exception e)
		{
			Log.info(e);
			e.printStackTrace();
			Report.put("User verifies if a apply filter button is displayed with the label 'Apply Selected'",
					"User should be able to see an apply filter button is displayed with the label 'Apply Selected'",
					"Failed to verify Apply Selected Button", "FAIL");
			Assert.fail("Failed to verify Apply Selected Button");
		}               
	} 
	
	public void verifyResetSelectionButton(WebDriver driver)
	{
		System.out.println("Inside verifyResetSelectionButton");
		Log.info("Inside verifyResetSelectionButton");   
		
		WebDriverWait wait = new WebDriverWait(driver, 120); 
		
		String button = "";
		try
		{	
			if(CommonUtility.CheckpresenceofElementLocated(driver, 30, obj_PortalPage.filterResetSelectionButton()))
			{
			CommonUtility.scrollToViewElement(driver, obj_PortalPage.filterResetSelectionButton()); 
			
			button = CommonUtility.highlightElement(driver, obj_PortalPage.filterResetSelectionButton()).getText();
			
							
			System.out.println("Displayed button "+button); 
			CommonUtility.highlightElement(driver, obj_PortalPage.filterResetSelectionButton()).click();

			Report.put("user verifies if a a reset selection button is displayed with the label 'Reset Selection'",
						"user should be able to see a reset selection button is displayed with the label 'Reset Selection'",
						"Displayed Button "+Report.color(button), "PASS");
			}
			else
			{
				Report.put("user verifies if a a reset selection button is displayed with the label 'Reset Selection'",
						"user should be able to see a reset selection button is displayed with the label 'Reset Selection'",
						"Failed to verify Reset Selection Button", "FAIL");
				Assert.fail("Failed to verify Reset Selection Button");
			}
		}
		catch (Exception e)
		{
			Log.info(e);
			e.printStackTrace();
			Report.put("user verifies if a a reset selection button is displayed with the label 'Reset Selection'",
					"user should be able to see a reset selection button is displayed with the label 'Reset Selection'",
					"Failed to verify Reset Selection Button", "FAIL");
			Assert.fail("Failed to verify Reset Selection Button");
		}               
	} 
	
	public void verifyFilterButtonNumber(WebDriver driver)
	{
		System.out.println("Inside verifyFilterButtonNumber");
		Log.info("Inside verifyFilterButtonNumber");   
		
		WebDriverWait wait = new WebDriverWait(driver, 120); 
		
		String num = "";
		try
		{	
			CommonUtility.scrollToViewElement(driver, obj_PortalPage.filterButtonNumberIcon()); 
			
			num = CommonUtility.highlightElement(driver, obj_PortalPage.filterButtonNumberIcon()).getText();
			
							
			System.out.println("Number displayed on Filter Button Icon is: "+num); 

			Report.put("User verifies Number displayed on Filter Button Icon",
						"User  should be able to verify Number displayed on Filter Button Icon",
						"Displayed Number on Filter Button Icon"+Report.color(num), "PASS");
		}

		catch (Exception e)
		{
			Log.info(e);
			e.printStackTrace();
			Report.put("User verifies Number displayed on Filter Button Icon",
					"User  should be able to verify Number displayed on Filter Button Icon",
					"Failed to display Number on Filter Button Icon", "FAIL");
			Assert.fail();
		}               
	} 
	
	public void clickClearAllButton(WebDriver driver)
	{
		System.out.println("Inside clickClearAllButton");
		Log.info("Inside clickClearAllButton");   
		
		WebDriverWait wait = new WebDriverWait(driver, 120); 
		
		try
		{	
			if(CommonUtility.CheckpresenceofElementLocated(driver, 30, obj_PortalPage.incidentManagementFilterByPopupClearAllButton()))
			{
				CommonUtility.highlightElement(driver, obj_PortalPage.incidentManagementFilterByPopupClearAllButton()).click();
				
							
				System.out.println("Clicked on Clear All button"); 

				Report.put("User clicks on Clear All Button",
						"user should be able to click on Clear All Button ",
						"Clicked on Clear All Button", "PASS");
			}
			else
			{
				Report.put("User clicks on Clear All Button",
						"user should be able to click on Clear All Button ",
						"Failed to click on Clear All Button", "FAIL");
				Assert.fail("Failed to click on Clear All Button");
			}
		}

		catch (Exception e)
		{
			Log.info(e);
			e.printStackTrace();
			Report.put("User clicks on Clear All Button",
					"user should be able to click on Clear All Button ",
					"Failed to click on Clear All Button", "FAIL");
			Assert.fail("Failed to click on Clear All Button");
		}               
	} 
	
	public void verifyNoDataFoundMessage(WebDriver driver)
	{
		System.out.println("Inside verifyNoDataFoundMessage");
		Log.info("Inside verifyNoDataFoundMessage");   
		
		WebDriverWait wait = new WebDriverWait(driver, 120); 
		
		String message = "";
		try
		{	
			CommonUtility.scrollToViewElement(driver, obj_PortalPage.noDataFoundMessage()); 
			
			message = CommonUtility.highlightElement(driver, obj_PortalPage.noDataFoundMessage()).getText();
			
							
			System.out.println("Message displayed : "+message); 

			Report.put("user clicks on cross icon to close the Filter By window ",
						"user should be able to see grid filtered “no records found”",
						"Displayed Message "+Report.color(message), "PASS");
		}

		catch (Exception e)
		{
			Log.info(e);
			e.printStackTrace();
			Report.put("user clicks on cross icon to close the Filter By window ",
					"user should be able to see grid filtered “no records found”",
					"Failed to display  grid filtered “no records found”", "FAIL");
			Assert.fail();
		}               
	} 
	
	public void verifyDefaultTextSearchTextbox(WebDriver driver)
	{
		System.out.println("Inside verifyDefaultTextSearchTextbox");
		Log.info("Inside verifyDefaultTextSearchTextbox");   
		
		WebDriverWait wait = new WebDriverWait(driver, 120); 
		
		String text = "";
		String msg = "";
		try
		{	
		//	CommonUtility.scrollToViewElement(driver, obj_PortalPage.searchTextboxInFilterPopup()); 
			
			text = CommonUtility.highlightElement(driver, obj_PortalPage.searchTextboxInFilterPopup()).getAttribute("value");
			
							
			System.out.println("Default text displayed : "+text); 
			
			CommonUtility.highlightElement(driver, obj_PortalPage.searchTextboxInFilterPopup()).sendKeys("1");

			msg = CommonUtility.highlightElement(driver, obj_PortalPage.searchTextErrorMessage()).getText();
			
			CommonUtility.highlightElement(driver, obj_PortalPage.filterHeader()).click();
			
			Report.put("user verifies if the default text as “Search” and user types in character in the search box   ",
					"user should be able to see default text disappears  and nd error message “No data available” is displayed when user enters a invalid product Family in the search box",
						"Displayed default text "+Report.color(text) +" Entered invalid data. Displayed error message "+Report.color(msg), "PASS");
		}

		catch (Exception e)
		{
			Log.info(e);
			e.printStackTrace();
			Report.put("user verifies if the default text as “Search” and user types in character in the search box   ",
					"user should be able to see default text disappears  and nd error message “No data available” is displayed when user enters a invalid product Family in the search box",
					"Failed to display  default text & validate error message", "FAIL");
			Assert.fail();
		}               
	}
	
	public void clickMapViewButton(WebDriver driver)
	{
		System.out.println("Inside clickMapViewButton");
		Log.info("Inside clickMapViewButton");   
		
		WebDriverWait wait = new WebDriverWait(driver, 120); 
		
		try
		{	
			if(CommonUtility.CheckpresenceofElementLocated(driver, 30, obj_PortalPage.mapViewButton()))
			{
				CommonUtility.scrollToViewElement(driver,(obj_PortalPage.mapViewButton()));
				CommonUtility.highlightElement(driver, obj_PortalPage.mapViewButton()).click();
				
							
				System.out.println("Clicked on Map View button"); 

				Report.put("User clicks on Map View",
						"user should be able to see Map View",
						"User is able to see Map View", "PASS");
			}
			else
			{
				Report.put("User clicks on Map View",
						"user should be able to see Map View",
						"Failed to click on Map View", "FAIL");
				Assert.fail("Failed to click on Map View");
			}
		}

		catch (Exception e)
		{
			Log.info(e);
			e.printStackTrace();
			Report.put("User clicks on Map View",
					"user should be able to see Map View",
					"Failed to click on Map View", "FAIL");
			Assert.fail("Failed to click on Map View");
		}               
	} 
	
	public void clickHealthRiskGraphView(WebDriver driver)
	{
		System.out.println("Inside clickHealthRiskGraphView method");
		Log.info("Inside clickHealthRiskGraphView method");

		
		String view = "";
		String button = "";
		
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);
			
			CommonUtility.highlightElement(driver,obj_PortalPage.visualizationsButton()).click();
			
			view = CommonUtility.highlightElement(driver,obj_PortalPage.visualizationsButton()).getText();
			
			System.out.println("Clicked on "+view);
			
			if(view!=null)
			{
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.incidentManagementSummaryViewFilterButton()));
				button = CommonUtility.highlightElement(driver,obj_PortalPage.incidentManagementSummaryViewFilterButton()).getText();
				
				Report.put("User clicks on the Graph view ",
						"User should be able to see Filter button at the right top of the page",
						"User clicks on "+Report.color(view) +" & displayed "+Report.color(button), "PASS");
			}
			else
			{
				System.out.println("Failed to click on the Graph view");	
				Report.put("User clicks on the Graph view ",
						"User should be able to see Filter button at the right top of the page",
						"Failed to click on the Graph view", "FAIL");
				Assert.fail("Failed to click on the Graph view");	
			}
			
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Failed to click on the Graph view");
			Report.put("User clicks on the Graph view ",
					"User should be able to see Filter button at the right top of the page",
					"Failed to click on the Graph view", "FAIL");
			Assert.fail("Failed to click on the Graph view");	
		}
	}
	
	public void verifyHealthAndRiskFilterBreadcrumb(WebDriver driver, String filter)
	{
		System.out.println("Inside verifyHealthAndRiskFilterBreadcrumb method");
		Log.info("Inside verifyHealthAndRiskFilterBreadcrumb method");


		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);

			WebElement element = driver.findElement(By.xpath("//div[@class='filter-breadcrumbs']//span[contains(text(),'"+filter+"')]"));
			CommonUtility.highlightElement(driver,element);
			

			System.out.println("Displayed filter in Breadcrumb "+filter);

			Report.put("Verify the filter applied in Breadcrumb ",
						"The breadcrumb should be displayed with applied filter",
						"Displayed filter in Breadcrumb"+Report.color(filter), "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify the filter applied in Breadcrumb ",
					"The breadcrumb should be displayed with applied filter",
					"Failed to display the applied filter in Breadcrumb", "FAIL");
			Assert.fail();
		}
	}
	
	public void clickChangeViewLink(WebDriver driver)
	{
		System.out.println("Inside clickChangeViewLink method");
		Log.info("Inside clickChangeViewLink method");

		
		String link = "";
		String button = "";
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);
			CommonUtility.ClickOn(driver, obj_PortalPage.changeViewLink());
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.siteIDCheckbox()));
			
			CommonUtility.ClickOn(driver, obj_PortalPage.siteIDCheckbox());		
			CommonUtility.ClickOn(driver, obj_PortalPage.updateButton());	
			System.out.println("Clicked on the ChangeView Link");		
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Failed to click on the ChangeView Link");			
		//	Assert.fail("Failed to click on the ChangeView Link");	
		}
	}
	
	public void clickTechnicalAdvisoryAmerRegionAndDownloadButton(WebDriver driver)
	{
		System.out.println("Inside clickTechnicalAdvisoryAmerRegionAndDownloadButton method");
		Log.info("Inside clickTechnicalAdvisoryAmerRegionAndDownloadButton method");

		String button = "";
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);
			CommonUtility.ClickOn(driver, obj_PortalPage.technicalAdvisoryGraphAmerRegion());
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.technicalAdvisoryGraphRegionPopupHeader()));
			
			CommonUtility.ClickOn(driver, obj_PortalPage.technicalAdvisoryGraphRegionPopupDownloadButton());
			
			button = CommonUtility.highlightElement(driver,obj_PortalPage.technicalAdvisoryGraphRegionPopupDownloadButton()).getText();
			
			System.out.println("Clicked on Button" +button);		
			
			Report.put("User clicks on the Total Issues Per Region links Download and click on Download button ",
				"Download should get completed and the data in the download should match the data shown in the UI",
				"Displayed & clicked on button "+Report.color(button), "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("User clicks on the Total Issues Per Region links Download and click on Download button ",
					"Download should get completed and the data in the download should match the data shown in the UI",
					"Failed to click on Download Button", "FAIL");
			Assert.fail("Failed to click on Download Button");
		}
	}
	
	public void clickTechnicalAdvisoryRegionPopupCloseButton(WebDriver driver)
	{
		System.out.println("Inside clickTechnicalAdvisoryRegionPopupCloseButton method");
		Log.info("Inside clickTechnicalAdvisoryRegionPopupCloseButton method");

		String header = "";
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);
			CommonUtility.ClickOn(driver, obj_PortalPage.technicalAdvisoryGraphRegionPopupCloseButton());
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.technicalAdvisoryGraphHeader()));
						
			header = CommonUtility.highlightElement(driver,obj_PortalPage.technicalAdvisoryGraphHeader()).getText();
			
			System.out.println("Displayed Header" +header);		
			
			Report.put("User clicks on X Button",
				"That should be taken to Health and Risk Graph View page ",
				"Clicked on  X Button & displayed "+Report.color(header), "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("User clicks on X Button",
					"That should be taken to Health and Risk Graph View page ",
					"Failed to click on X Button & display Health and Risk Graph View page ", "FAIL");
			Assert.fail("Failed to click on X Button & display Health and Risk Graph View page");
		}
	}
	
	public void verifyHealthAndRiskSearchTextbox(WebDriver driver)
	{
		System.out.println("Inside verifyHealthAndRiskSearchTextbox");
		Log.info("Inside verifyHealthAndRiskSearchTextbox");   
		
		WebDriverWait wait = new WebDriverWait(driver, 120); 
		
		String text = "";
		String msg = "";
		try
		{	
			CommonUtility.scrollToViewElement(driver, obj_PortalPage.healthAndRiskSearchTextbox()); 
			
			if(CommonUtility.CheckpresenceofElementLocated(driver, 10, obj_PortalPage.healthAndRiskSearchTextbox()))
			{			
							
				System.out.println("Displayed Search bar in Health & Risk Tab"); 
			
				Report.put(" Verify the search bar in the page",
						"Search Bar should be displayed below contextual view",
						"Displayed Search Bar below contextual view ", "PASS");
			}
			else
			{
				System.out.println("Failed to display Search bar in Health & Risk Tab"); 
			
				Report.put(" Verify the search bar in the page",
						"Search Bar should be displayed below contextual view",
						"Failed to display Search Bar below contextual view", "FAIL");
				Assert.fail("Failed to display Search Bar below contextual view");
			}
		}

		catch (Exception e)
		{
			Log.info(e);
			e.printStackTrace();
			System.out.println("Failed to display Search bar in Health & Risk Tab"); 			
			Report.put(" Verify the search bar in the page",
					"Search Bar should be displayed below contextual view",
					"Failed to display Search Bar below contextual view", "FAIL");
			Assert.fail("Failed to display Search Bar below contextual view");
		}               
	}
		
		public void verifyHealthAndRiskSearchTextboxDefaultText(WebDriver driver)
		{
			System.out.println("Inside verifyHealthAndRiskSearchTextboxDefaultText");
			Log.info("Inside verifyHealthAndRiskSearchTextboxDefaultText");   
			
			WebDriverWait wait = new WebDriverWait(driver, 120); 
			
			String text = "";
			try
			{	
				
				if(CommonUtility.CheckpresenceofElementLocated(driver, 10, obj_PortalPage.healthAndRiskSearchTextbox()))
				{			
					text = CommonUtility.highlightElement(driver, obj_PortalPage.healthAndRiskSearchTextbox()).getAttribute("placeholder");
								
					System.out.println("Default text displayed : "+text); 
				
					Report.put("Verify the default text in the search bar",
							"The default text in the search bar should be Search",
							"Displayed default text "+Report.color(text), "PASS");
				}
				else
				{
					System.out.println("Failed to verify the default text in the search bar"); 
				
					Report.put("Verify the default text in the search bar",
							"The default text in the search bar should be Search",
							"Failed to verify the default text in the search bar", "FAIL");
					Assert.fail("Failed to verify the default text in the search bar");
				}
			}

			catch (Exception e)
			{
				Log.info(e);
				e.printStackTrace();
				System.out.println("Failed to verify the default text in the search bar"); 
				
				Report.put("Verify the default text in the search bar",
						"The default text in the search bar should be Search",
						"Failed to verify the default text in the search bar", "FAIL");
				Assert.fail("Failed to verify the default text in the search bar");
			}               
		}
		
		public void AdvisoryAmerRegionAndDownloadButton(WebDriver driver)
		{
			System.out.println("Inside clickTechnicalAdvisoryAmerRegionAndDownloadButton method");
			Log.info("Inside clickTechnicalAdvisoryAmerRegionAndDownloadButton method");

			String button = "";
			try
			{
				WebDriverWait wait = new WebDriverWait(driver, 120);
				CommonUtility.ClickOn(driver, obj_PortalPage.technicalAdvisoryGraphAmerRegion());
				
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.technicalAdvisoryGraphRegionPopupHeader()));
				
				CommonUtility.ClickOn(driver, obj_PortalPage.technicalAdvisoryGraphRegionPopupDownloadButton());
				
				button = CommonUtility.highlightElement(driver,obj_PortalPage.technicalAdvisoryGraphRegionPopupDownloadButton()).getText();
				
				System.out.println("Clicked on Button" +button);		
				
				Report.put("User clicks on the Total Issues Per Region links Download and click on Download button ",
					"Download should get completed and the data in the download should match the data shown in the UI",
					"Displayed & clicked on button "+Report.color(button), "PASS");
			} 
			catch(Exception e)
			{
				e.printStackTrace();
				Report.put("User clicks on the Total Issues Per Region links Download and click on Download button ",
						"Download should get completed and the data in the download should match the data shown in the UI",
						"Failed to click on Download Button", "FAIL");
				Assert.fail("Failed to click on Download Button");
			}
		}
		
		public void verifyAdvisoryAmerRegionTotalIssues(WebDriver driver)
		{
			System.out.println("Inside verifyAdvisoryAmerRegionTotalIssues method");
			Log.info("Inside verifyAdvisoryAmerRegionTotalIssues method");

			String textList = "";
			try
			{
				WebDriverWait wait = new WebDriverWait(driver, 120);
				
				CommonUtility.ScrollTo(driver, obj_PortalPage.advisoryAmerRegionTotalIssues());
				
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.advisoryAmerRegionTotalIssues()));
				
				List<WebElement> list=driver.findElements(obj_PortalPage.advisoryAmerRegionTotalIssues());
			
				for(WebElement lt:list)
				{
					CommonUtility.highlightElement(driver, lt);
					String text=lt.getText();

					System.out.println("Text is: " +text);
					textList+=" <br> " + text;
				}
				System.out.println("Total Issues are:"+textList);
							
				
				Report.put("User verifies Total Issues Per Region ",
					"Total Issues are displayed for the Region",
					"Displayed Total Issues "+Report.color(textList), "PASS");
			} 
			catch(Exception e)
			{
				e.printStackTrace();
				Report.put("User verifies Total Issues Per Region ",
						"Total Issues are displayed for the Region",
						"Failed to verify Total Issues Per Region", "FAIL");
				Assert.fail("Failed to verify Total Issues Per Region");
			}
		}
		
		public void clickAdvisoryAmerRegionDonut(WebDriver driver)
		{
			System.out.println("Inside clickAdvisoryAmerRegionDonut method");
			Log.info("Inside clickAdvisoryAmerRegionDonut method");

			String header = "";
			try
			{
				WebDriverWait wait = new WebDriverWait(driver, 120);
				CommonUtility.ScrollTo(driver, obj_PortalPage.technicalAdvisoryGraphAmerRegion());
				
				CommonUtility.ClickOn(driver, obj_PortalPage.technicalAdvisoryGraphAmerRegion());
				
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.technicalAdvisoryGraphRegionPopupHeader()));
				
				header = CommonUtility.highlightElement(driver,obj_PortalPage.technicalAdvisoryGraphRegionPopupHeader()).getText();
				
				System.out.println("Displayed header " +header);		
				
				Report.put("User clicks on Total issues per region",
					"A popup should be displayed with the advisories data",
					"Displayed advisories data"+Report.color(header), "PASS");
			} 
			catch(Exception e)
			{
				e.printStackTrace();
				Report.put("User clicks on Total issues per region",
						"A popup should be displayed with the advisories data",
						"Failed to display advisories data", "FAIL");
				Assert.fail("Failed to display advisories data");
			}
		}
		
		public void verifyAdvisoryRegionNames(WebDriver driver)
		{
			System.out.println("Inside verifyAdvisoryRegionNames method");
			Log.info("Inside verifyAdvisoryRegionNames method");

			String textList = "";
			try
			{
				WebDriverWait wait = new WebDriverWait(driver, 120);
				
				CommonUtility.ScrollTo(driver, obj_PortalPage.graphViewAdvisoryRegionsList());
				
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.graphViewAdvisoryRegionsList()));
				
				List<WebElement> list=driver.findElements(obj_PortalPage.graphViewAdvisoryRegionsList());
			
				for(WebElement lt:list)
				{
					CommonUtility.highlightElement(driver, lt);
					String text=lt.getText();

					System.out.println("Text is: " +text);
					textList+=" <br> " + text;
				}
				System.out.println("Regions are:"+textList);
							
				
				Report.put("User verifies 3 geo regions are present - AMERICAS, EMEA, APJ under Regional Impact donut charts",
					"The 3 geo regions should be present   AMERICAS, EMEA, APJ ",
					"Displayed Geo Regions "+Report.color(textList), "PASS");
			} 
			catch(Exception e)
			{
				e.printStackTrace();
				Report.put("User verifies 3 geo regions are present - AMERICAS, EMEA, APJ under Regional Impact donut charts",
						"The 3 geo regions should be present   AMERICAS, EMEA, APJ ",
						"Failed to display Geo Regions", "FAIL");
				Assert.fail("Failed to display Geo Regions");
			}
		}
		
		public void verifyAdvisoryAmerRegionArcs(WebDriver driver)
		{
			System.out.println("Inside verifyAdvisoryAmerRegionArcs method");
			Log.info("Inside verifyAdvisoryAmerRegionArcs method");

			String textList = "";
			try
			{
				WebDriverWait wait = new WebDriverWait(driver, 120);
				
				CommonUtility.ScrollTo(driver, obj_PortalPage.advisoryAmerRegionArcs());
				
				List<WebElement> list=driver.findElements(obj_PortalPage.advisoryAmerRegionArcs());
			
				int arcCount = list.size();
				
				for(WebElement lt:list)
				{
					CommonUtility.highlightElement(driver, lt);
				}
				

				String strCount = Integer.toString(arcCount); 
				
				System.out.println("Displayed arcs with different Severity:"+arcCount);
							
				
				Report.put("User verifies that each region is divided into segments that display Severity",
					"Each region should be  divided into segments that displays the Severity",
					"Displayed region with different Severity "+Report.color(strCount), "PASS");
			} 
			catch(Exception e)
			{
				e.printStackTrace();
				Report.put("User verifies that each region is divided into segments that display Severity",
						"Each region should be  divided into segments that displays the Severity",
						"Failed to display region with different Severity", "FAIL");
				Assert.fail("Failed to display region with different Severity");
			}
		}
		
		public void verifyFiltersList(WebDriver driver)
		{
			System.out.println("Inside verifyFiltersList method");
			Log.info("Inside verifyFiltersList method");

			
			String filterButton = "";
			String filterByHeader = "";
			String filterList = "";
			try
			{
				WebDriverWait wait = new WebDriverWait(driver, 120);
				
				//CommonUtility.scrollToViewElement(driver,(obj_PortalPage.incidentManagementSummaryViewFilterButton()));
				filterButton = CommonUtility.highlightElement(driver,obj_PortalPage.incidentManagementSummaryViewFilterButton()).getText();
				
				Thread.sleep(5000);
				CommonUtility.highlightElement(driver,obj_PortalPage.incidentManagementSummaryViewFilterButton()).click();
				
				System.out.println("Clicked on "+filterButton);

				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.incidentManagementFilterByPopupHeader()));
			
				CommonUtility.highlightElement(driver,obj_PortalPage.incidentManagementFilterByPopupHeader());

				filterByHeader = CommonUtility.highlightElement(driver,obj_PortalPage.incidentManagementFilterByPopupHeader()).getText();
				
				System.out.println("Header is"+filterByHeader);			

				List<WebElement> list=driver.findElements(obj_PortalPage.incidentManagementFilterValuesList());

				for(WebElement lt:list)
				{
					CommonUtility.highlightElement(driver, lt);
					String filterName=lt.getText();
					if(!(filterName.isEmpty()))
					{
						System.out.println("Filter is: " +filterName);
						filterList+=" <br> " + filterName;
					}
				}
				System.out.println("Filters are:"+filterList);
				
				Report.put("User clicks on the Filter button ",
						"User should see the full set of common filters displayed with contextual filters",
						"List of filters are: "+Report.color(filterList), "PASS");
			} 
			catch(Exception e)
			{
				e.printStackTrace();

				Report.put("User clicks on the Filter button ",
						"User should see the full set of common filters displayed with contextual filters",
						"Failed to display filters", "FAIL");
				Assert.fail();
			}
		}
		
		public void clickSeverityBreadcrumbCrossButton(WebDriver driver)
		{
			System.out.println("Inside clickSeverityBreadcrumbCrossButton");
			Log.info("Inside clickSeverityBreadcrumbCrossButton");   
			
			String num = "";
			
			WebDriverWait wait = new WebDriverWait(driver, 120); 
			
			try
			{	
				if(CommonUtility.CheckpresenceofElementLocated(driver, 30, obj_PortalPage.severityBreadcrumbCrossButton()))
				{
					CommonUtility.highlightElement(driver, obj_PortalPage.severityBreadcrumbCrossButton()).click();
					
								
					System.out.println("Clicked on Severity BreadcrumbCross button"); 
					
					CommonUtility.scrollToViewElement(driver, obj_PortalPage.filterButtonNumberIcon()); 
					
					num = CommonUtility.highlightElement(driver, obj_PortalPage.filterButtonNumberIcon()).getText();
					
									
					System.out.println("Number displayed on Filter Button Icon is: "+num); 

					Report.put("User clicks  on the X in the breadcrumb",
							"The filter should get removed from the table and breadcrumb and the table refreshes with number of applied filters in the Filter button is updated",
							"Clicked on X in the breadcrumb and number of filters updated"+Report.color(num), "PASS");
				}
				else
				{
					Report.put("User clicks  on the X in the breadcrumb",
							"The filter should get removed from the table and breadcrumb and the table refreshes with number of applied filters in the Filter button is updated",
							"Failed to click on X in the breadcrumb", "FAIL");
					Assert.fail("Failed to click on X in the breadcrumb");
				}
			}

			catch (Exception e)
			{
				Log.info(e);
				e.printStackTrace();
				Report.put("User clicks  on the X in the breadcrumb",
						"The filter should get removed from the table and breadcrumb and the table refreshes with number of applied filters in the Filter button is updated",
						"Failed to click on X in the breadcrumb", "FAIL");
				Assert.fail("Failed to click on X in the breadcrumb");
			}               
		}
		
		public void verifyMultipleOptionsSeverityColumn(WebDriver driver)
		{
			System.out.println("Inside verifyMultipleOptionsSeverityColumn method");
			Log.info("Inside verifyMultipleOptionsSeverityColumn method");

			WebDriverWait wait = new WebDriverWait(driver, 120);
			
			String securityTab = "";
			String columns = "";
			try
			{		

				
					wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.severityColumnValues()));
					
					List<WebElement> list=driver.findElements(obj_PortalPage.severityColumnValues());


					for(WebElement lt:list)
					{
						CommonUtility.scrollToViewElement(driver, lt);
						CommonUtility.highlightElement(driver, lt);
						String col=lt.getText();
						if(!(col.isEmpty()))
						{
							System.out.println("Value is: " +col);
							columns+=" <br> " + col;
						}
					}
					System.out.println("Values are: "+columns);
					
						Report.put("User is on the filter list applying more than one data point from one filter to the dataset ",
								"Dataset in the table should get filtered based on the selected data points",
								"Filter applied on data points "+Report.color(columns), "PASS");	
					
			} 
			catch(Exception e)
			{
				e.printStackTrace();
				System.out.println("Failed to display  Filter List");

				Report.put("User is on the filter list applying more than one data point from one filter to the dataset ",
						"Dataset in the table should get filtered based on the selected data points",
						"Failed to display  Filter List", "FAIL");				
				Assert.fail();
			}
		}
		
		public void clickAdvisoryDownArrowFirstRow(WebDriver driver)
		{
			System.out.println("Inside clickAdvisoryDownArrowFirstRow method");
			Log.info("Inside clickAdvisoryDownArrowFirstRow method");

			String labelList = "";
			
			WebDriverWait wait = new WebDriverWait(driver, 120);
			
			try
			{		

				if(CommonUtility.CheckpresenceofElementLocated(driver, 30, obj_PortalPage.advisoryDownArrowFirstRow()))
				{

					
					System.out.println("Clicked on down arrow of advisory");

					CommonUtility.highlightElement(driver,obj_PortalPage.advisoryDownArrowFirstRow()).click();
					
					Thread.sleep(5000);		

						
						List<WebElement> list=driver.findElements(obj_PortalPage.advisoryExpandedViewLabelList());
						for(WebElement lt:list)
						{
							CommonUtility.highlightElement(driver, lt);
							String label=lt.getText();

							System.out.println("Label is: " +label);
							labelList+=" <br> " + label;
						}
						System.out.println("Labels are:"+labelList);

					
						Report.put("User navigates to Security Advisories Context grid view and clicks on the expand icon (down arrow) at the right end of any advisory row ",
								"The advisory row should expand and user should be able to view the  following labels with their correct value",
								"Clicked on expand icon at the end of advisory row and able to view labels"+Report.color(labelList), "PASS");	
				}
			} 
			catch(Exception e)
			{
				e.printStackTrace();
				System.out.println("Failed to click on the expand icon (down arrow) at the right end of any advisory row  ");

				Report.put("User navigates to Security Advisories Context grid view and clicks on the expand icon (down arrow) at the right end of any advisory row ",
						"The advisory row should expand and user should be able to view the  following labels with their correct value",
						"Failed to click on the expand icon (down arrow) at the right end of any advisory row  ", "FAIL");						
				Assert.fail();
			}
		}
		
		public void verifyAdvisoryExpandedViewElements(WebDriver driver)
		{
			System.out.println("Inside verifyAdvisoryExpandedViewElements method");
			Log.info("Inside verifyAdvisoryExpandedViewElements method");

			String filterButton = "";
			String downloadButton = "";

			try
			{		
				
				CommonUtility.ClickOn(driver, obj_PortalPage.incidentManagementExpandButton());

				CommonUtility.highlightElement(driver, obj_PortalPage.healthAndRiskSearchTextbox());
				
				filterButton = CommonUtility.highlightElement(driver, obj_PortalPage.incidentManagementSummaryViewFilterButton()).getText();
				
				downloadButton = CommonUtility.highlightElement(driver,obj_PortalPage.expandedViewDownloadButton()).getText();

				CommonUtility.highlightElement(driver,obj_PortalPage.incidentManagementExpandViewCloseButton());
					
					System.out.println("filterButton is: "+filterButton);

					System.out.println("downloadButton is: "+downloadButton);

						Report.put("Click on the Expand button  ",
								"The Expanded View is displayed with a search box in top left and there are 3 buttons in the right top(Filter, Download and close)",
								"The Expanded View is displayed with a search box in top left and there are buttons in the right top close, "+Report.color(filterButton)+Report.color(downloadButton), "PASS");	
					
			} 
			catch(Exception e)
			{
				e.printStackTrace();
				System.out.println("Failed to click on the Expand Button");

				Report.put("Click on the Expand button  ",
						"The Expanded View is displayed with a search box in top left and there are 3 buttons in the right top(Filter, Download and close)",
						"Failed to click on the Expand Button", "FAIL");						
				Assert.fail();
			}
		}
		
		public void verifyFilterBreadcrumbValues(WebDriver driver)
		{
			System.out.println("Inside verifyFilterBreadcrumbValues method");
			Log.info("Inside verifyFilterBreadcrumbValues method");

			WebDriverWait wait = new WebDriverWait(driver, 120);
			
			String breadcrumbs = "";
			try
			{		
					List<WebElement> list=driver.findElements(obj_PortalPage.filterBreadcrumbsList());


					for(WebElement lt:list)
					{
						CommonUtility.highlightElement(driver, lt);
						String val=lt.getText();
						if(!(val.isEmpty()))
						{
							System.out.println("Value is: " +val);
							breadcrumbs+=" <br> " + val;
						}
					}
					System.out.println("Breadcrumb Values are: "+breadcrumbs);
					
						Report.put("Verify the filter breadcrumbs  ",
								"The filter breadcrumbs should be displayed same as normal view",
								"Filters displayed in the breadcrumbs are: "+Report.color(breadcrumbs), "PASS");	
					
			} 
			catch(Exception e)
			{
				e.printStackTrace();
				System.out.println("Failed to display  breadcrumbs");

				Report.put("Verify the filter breadcrumbs  ",
						"The filter breadcrumbs should be displayed same as normal view",
						"Failed to display  Filter breadcrumbs", "FAIL");				
				Assert.fail();
			}
		}
		
		public void verifyExpandViewColumns(WebDriver driver)
		{
			System.out.println("Inside verifyExpandViewColumns method");
			Log.info("Inside verifyExpandViewColumns method");

			String columns = "";
			try
			{
				WebDriverWait wait = new WebDriverWait(driver, 120);
				
				
				CommonUtility.scrollToViewElement(driver,(obj_PortalPage.incidentManagementExpandViewColumns()));
				List<WebElement> list=driver.findElements(obj_PortalPage.incidentManagementExpandViewColumns());

				for(WebElement lt:list)
				{
					CommonUtility.scrollToViewElement(driver, lt);
					String colName=lt.getText();
					if(!(colName.isEmpty()))
					{
						System.out.println("Column is: " +colName);
						columns+=" <br> " + colName;
					}
				}
				System.out.println("Columns are:"+columns);
				
					
					Report.put("Verify the columns in the Expanded view ",
							"The columns should be displayed along with severity column",
							"Displayed columns in the expanded View"+Report.color(columns), "PASS");
			} 
			catch(Exception e)
			{
				e.printStackTrace();
				Report.put("Verify the columns in the Expanded view ",
						"The columns should be displayed along with severity column",
						"Failed to display the columns", "FAIL");
				Assert.fail();
			}
		}

		public void closeExpandedView(WebDriver driver)
		{
			System.out.println("Inside closeExpandedView method");
			Log.info("Inside closeExpandedView method");
			
			try
			{
				WebDriverWait wait = new WebDriverWait(driver, 120);
				
				
				CommonUtility.scrollToViewElement(driver,(obj_PortalPage.incidentManagementExpandViewCloseButton()));
				CommonUtility.highlightElement(driver,obj_PortalPage.incidentManagementExpandViewCloseButton());
				CommonUtility.highlightElement(driver,obj_PortalPage.incidentManagementExpandViewCloseButton()).click();
							
				System.out.println("Closed Expanded View");
				
				
				Report.put("Click on the close button in the expanded view",
						"User should be able to exit from the Expanded View",
						"User clicked on the close button from the Expanded View", "PASS");
			} 
			catch(Exception e)
			{
				e.printStackTrace();
				Report.put("Click on the close button in the expanded view",
						"User should be able to exit from the Expanded View",
						"Failed to Close Expanded view", "FAIL");
				Assert.fail();
			}
		}
		
		
		//Lavanya
		
		
		public void ValidateDefaultFilterInTabularViewInIBTabUnderAssets(WebDriver driver)
		{

			Log.info("ValidateDefaultFilterInTabularViewInIBTabUnderAssets");	
			WebDriverWait wait = new WebDriverWait(driver, 240);
			String text="";
			String text1="";
			String map="";
			String text2="";
			String defaults="";
			String text3="";
			String text4="";
			String text5="";
			String text7="";
			String text8="";
			String text9="";
			String asset="";
			String view="";
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			Actions act=new Actions(driver);
			String value=TestNGCreator.TestData.get(Esupport.Dpid.ordinal());
			try
			{
				if(CommonUtility.CheckpresenceofElementLocated(driver, 10, obj_PortalPage.DefaultAssetDisplayedUnderIB()))
					
				{
					
				asset =CommonUtility.highlightElement(driver,  obj_PortalPage.DefaultAssetDisplayedUnderIB()).getText();
				System.out.println("default menu displayed is " +asset);
				
				
				view =CommonUtility.highlightElement(driver,  obj_PortalPage.TableViewDefaultDisplay()).getText();
				System.out.println("default view displayed is " +view);
				
				List<WebElement> list2=driver.findElements(obj_PortalPage.BreadScrumbsOnGraphView());


					for(WebElement lt:list2)
					{
						
							CommonUtility.ScrollToWebElement(driver, lt);

							CommonUtility.highlightElement(driver, lt);
						
						text=lt.getText();
						text4+=" <br> "+text;
					}
					System.out.println("Breadscrumbs are "+text4);
					
					if(text4.contains("Install Base Status"))
					{
						Report.put("Verify the default filter  in the summary page in the Install base tab", 
								"Install Base Status should be set as the default filter in the summary page of Install Base" ,
								Report.color(text4)+" displayed as a default filter in the "+Report.color(view)+" of install base page", "PASS");
					
					}
					else
					{
						Report.put("Verify the default filter  in the summary page in the Install base tab", 
								"Install Base Status should be set as the default filter in the summary page of Install Base" ,
								"Failed see Install Base Status as default filter", "FAIL");
						Assert.fail();
					}

				}
				Report.put("Verify the default filter  in the summary page in the Install base tab", 
						"Install Base Status should be set as the default filter in the summary page of Install Base" ,
						Report.color(text4)+" displayed as a default filter in the "+Report.color(view)+" of install base page", "PASS");
				}
				
			
			catch(Exception e)
			{
				Log.info(e);
				Report.put("Verify the default filter  in the summary page in the Install base tab", 
						"Install Base Status should be set as the default filter in the summary page of Install Base" ,
						"Failed see Install Base Status as default filter", "FAIL");
				e.printStackTrace();
				Assert.fail();
			}

		} 
		
		public void ValidateDefaultFilterInSummaryPageWhenUserSelectedConnectivityFromLeftMenu(WebDriver driver)
		{

			Log.info("ValidateDefaultFilterInSummaryPageWhenUserSelectedConnectivityFromLeftMenu");	
			WebDriverWait wait = new WebDriverWait(driver, 240);
			String text="";
			String text1="";
			String map="";
			String text2="";
			String defaults="";
			String text3="";
			String text4="";
			String view="";
			
			driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
			Actions act=new Actions(driver);
			String value=TestNGCreator.TestData.get(Esupport.Dpid.ordinal());
			
			try
			{
				//			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.IncidentsManagementTab()));
				if(CommonUtility.CheckpresenceofElementLocated(driver, 50, obj_PortalPage.ConnectivityOnLeftRailOfInstallBase()))
				{
					CommonUtility.scrollToViewElement(driver, obj_PortalPage.ConnectivityOnLeftRailOfInstallBase());
					text2=CommonUtility.highlightElement(driver, obj_PortalPage.ConnectivityOnLeftRailOfInstallBase()).getText();
					System.out.println(text2);
					CommonUtility.highlightElement(driver, obj_PortalPage.ConnectivityOnLeftRailOfInstallBase()).click();
					wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.ConnectivityInIBselected()));
							
					
					view =CommonUtility.highlightElement(driver,  obj_PortalPage.TableViewDefaultDisplay()).getText();
					System.out.println("default view displayed is " +view);
					
					List<WebElement> list2=driver.findElements(obj_PortalPage.BreadScrumbsOnGraphView());


						for(WebElement lt:list2)
						{
							
								CommonUtility.ScrollToWebElement(driver, lt);

								CommonUtility.highlightElement(driver, lt);
							
							text=lt.getText();
							text4+=" <br> "+text;
						}
						System.out.println("Breadscrumbs are "+text4);
						
						if(text4.contains("Install Base Status"))
						{
							Report.put("Verify the default filter  in the all the summary pages by selecting Connectivity from left menu in IB page", 
									"Install Base Status should be set as the default filter in the summary page of Install Base" ,
									Report.color(text4)+" displayed as a default filter in the "+Report.color(view)+" of install base page under "+Report.color(text2)+" context", "PASS");
						
						}
						else
						{
							Report.put("Verify the default filter  in the all the summary pages by selecting Connectivity from left menu in IB page", 
									"Install Base Status should be set as the default filter in the summary page of Install Base" ,
									"Failed see Install Base Status as default filter", "FAIL");
							Assert.fail();
						}

					}
				Report.put("Verify the default filter  in the all the summary pages by selecting Connectivity from left menu in IB page", 
						"Install Base Status should be set as the default filter in the summary page of Install Base" ,
						Report.color(text4)+" displayed as a default filter in the "+Report.color(view)+" of install base page under "+Report.color(text2)+" context", "PASS");
			
				}
				
			catch(Exception e)
			{
				Log.info(e);
				Report.put("Verify the default filter  in the all the summary pages by selecting Connectivity from left menu in IB page", 
						"Install Base Status should be set as the default filter in the summary page of Install Base" ,
						"Failed see Install Base Status as default filter", "FAIL");
				e.printStackTrace();
				Assert.fail();
			}

		} 
		
		public void ValidateDefaultFilterInSummaryPageWhenUserSelectedCodeLevelsFromLeftMenu(WebDriver driver)
		{

			Log.info("ValidateDefaultFilterInSummaryPageWhenUserSelectedCodeLevelsFromLeftMenu");	
			WebDriverWait wait = new WebDriverWait(driver, 240);
			String text="";
			String text1="";
			String map="";
			String text2="";
			String defaults="";
			String text3="";
			String text4="";
			String view="";
			
			driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
			Actions act=new Actions(driver);
			String value=TestNGCreator.TestData.get(Esupport.Dpid.ordinal());
			
			try
			{
				//			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.IncidentsManagementTab()));
				if(CommonUtility.CheckpresenceofElementLocated(driver, 50, obj_PortalPage.CodeLevelsOnLeftRailOfInstallBase()))
				{
					CommonUtility.scrollToViewElement(driver, obj_PortalPage.CodeLevelsOnLeftRailOfInstallBase());
					text2=CommonUtility.highlightElement(driver, obj_PortalPage.CodeLevelsOnLeftRailOfInstallBase()).getText();
					System.out.println(text2);
					CommonUtility.highlightElement(driver, obj_PortalPage.CodeLevelsOnLeftRailOfInstallBase()).click();
					wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.CodeLevelsInIBselected()));
							
					
					view =CommonUtility.highlightElement(driver,  obj_PortalPage.TableViewDefaultDisplay()).getText();
					System.out.println("default view displayed is " +view);
					
					List<WebElement> list2=driver.findElements(obj_PortalPage.BreadScrumbsOnGraphView());


						for(WebElement lt:list2)
						{
							
								CommonUtility.ScrollToWebElement(driver, lt);

								CommonUtility.highlightElement(driver, lt);
							
							text=lt.getText();
							text4+=" <br> "+text;
						}
						System.out.println("Breadscrumbs are "+text4);
						
						if(text4.contains("Install Base Status"))
						{
							Report.put("Verify the default filter  in the all the summary pages by selecting Code Levels from left menu in IB page", 
									"Install Base Status should be set as the default filter in the summary page of Install Base" ,
									Report.color(text4)+" displayed as a default filter in the "+Report.color(view)+" of install base page under "+Report.color(text2)+" context", "PASS");
						
						}
						else
						{
							Report.put("Verify the default filter  in the all the summary pages by selecting Code Levels from left menu in IB page", 
									"Install Base Status should be set as the default filter in the summary page of Install Base" ,
									"Failed see Install Base Status as default filter", "FAIL");
							Assert.fail();
						}

					}
				Report.put("Verify the default filter  in the all the summary pages by selecting Code Levels from left menu in IB page", 
						"Install Base Status should be set as the default filter in the summary page of Install Base" ,
						Report.color(text4)+" displayed as a default filter in the "+Report.color(view)+" of install base page under "+Report.color(text2)+" context", "PASS");
			
				}
				
			catch(Exception e)
			{
				Log.info(e);
				Report.put("Verify the default filter  in the all the summary pages by selecting Code Levels from left menu in IB page", 
						"Install Base Status should be set as the default filter in the summary page of Install Base" ,
						"Failed see Install Base Status as default filter", "FAIL");
				e.printStackTrace();
				Assert.fail();
			}

		} 
		
		public void ValidateDefaultFilterInSummaryPageWhenUserSelectedContractsFromLeftMenu(WebDriver driver)
		{

			Log.info("ValidateDefaultFilterInSummaryPageWhenUserSelectedContractsFromLeftMenu");	
			WebDriverWait wait = new WebDriverWait(driver, 240);
			String text="";
			String text1="";
			String map="";
			String text2="";
			String defaults="";
			String text3="";
			String text4="";
			String view="";
			
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			Actions act=new Actions(driver);
			String value=TestNGCreator.TestData.get(Esupport.Dpid.ordinal());
			
			try
			{
				//			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.IncidentsManagementTab()));
				if(CommonUtility.CheckpresenceofElementLocated(driver, 50, obj_PortalPage.ContractsOnLeftRailOfInstallBase()))
				{
					CommonUtility.scrollToViewElement(driver, obj_PortalPage.ContractsOnLeftRailOfInstallBase());
					text2=CommonUtility.highlightElement(driver, obj_PortalPage.ContractsOnLeftRailOfInstallBase()).getText();
					System.out.println(text2);
					CommonUtility.highlightElement(driver, obj_PortalPage.ContractsOnLeftRailOfInstallBase()).click();
					wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.ContractsInIBSelected()));
							
					
					view =CommonUtility.highlightElement(driver,  obj_PortalPage.TableViewDefaultDisplay()).getText();
					System.out.println("default view displayed is " +view);
					
					List<WebElement> list2=driver.findElements(obj_PortalPage.BreadScrumbsOnGraphView());


						for(WebElement lt:list2)
						{
							
								CommonUtility.ScrollToWebElement(driver, lt);

								CommonUtility.highlightElement(driver, lt);
							
							text=lt.getText();
							text4+=" <br> "+text;
						}
						System.out.println("Breadscrumbs are "+text4);
						
						if(text4.contains("Install Base Status"))
						{
							Report.put("Verify the default filter  in the all the summary pages by selecting Contracts from left menu in IB page", 
									"Install Base Status should be set as the default filter in the summary page of Install Base" ,
									Report.color(text4)+" displayed as a default filter in the "+Report.color(view)+" of install base page under "+Report.color(text2)+" context", "PASS");
						
						}
						else
						{
							Report.put("Verify the default filter  in the all the summary pages by selecting Contracts from left menu in IB page", 
									"Install Base Status should be set as the default filter in the summary page of Install Base" ,
									"Failed see Install Base Status as default filter", "FAIL");
							Assert.fail();
						}

					}
				Report.put("Verify the default filter  in the all the summary pages by selecting Contracts from left menu in IB page", 
						"Install Base Status should be set as the default filter in the summary page of Install Base" ,
						Report.color(text4)+" displayed as a default filter in the "+Report.color(view)+" of install base page under "+Report.color(text2)+" context", "PASS");
			
				}
				
			catch(Exception e)
			{
				Log.info(e);
				Report.put("Verify the default filter  in the all the summary pages by selecting Contracts from left menu in IB page", 
						"Install Base Status should be set as the default filter in the summary page of Install Base" ,
						"Failed see Install Base Status as default filter", "FAIL");
				e.printStackTrace();
				Assert.fail();
			}

		} 
		
		
		public void ClickOnFilterAndValidateIBStatusDefaultSelectedOptionsDisplayedInInstallBasePage(WebDriver driver)
		{

			Log.info("ClickOnFilterAndValidateIBStatusDefaultSelectedOptionsDisplayedInInstallBasePage");	
			WebDriverWait wait = new WebDriverWait(driver, 120);
			String text="";
			String text1="";
			String map="";
			String text2="";
			String defaults="";
			String text3="";
			String text4="";
			String text5="";
			String text6="";
			String text7="";
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			Actions act=new Actions(driver);
			String value=TestNGCreator.TestData.get(Esupport.Dpid.ordinal());
			String value2=TestNGCreator.TestData.get(Esupport.SearchOption.ordinal());
			try
			{
				
				if(CommonUtility.CheckpresenceofElementLocated(driver, 10, obj_PortalPage.FilterButton()))
				{
					CommonUtility.scrollToViewElement(driver,obj_PortalPage.FilterButton());
					map=CommonUtility.highlightElement(driver,obj_PortalPage.FilterButton()).getText();
					System.out.println(map);
					CommonUtility.highlightElement(driver,obj_PortalPage.FilterButton()).click(); 
					
//					wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.FilterByHeader()));
//					text5=CommonUtility.highlightElement(driver,obj_PortalPage.FilterByHeader()).getText();
//					System.out.println(text5);
					CommonUtility.scrollToViewElement(driver,obj_PortalPage.IBStatusInFilterWindow());
					text2=CommonUtility.highlightElement(driver,obj_PortalPage.IBStatusInFilterWindow()).getText();
					System.out.println("Filter is "+text2);

					
					CommonUtility.ClickOn(driver,obj_PortalPage.IBStatusInFilterWindow());
					
					wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.IBStatusHeadingInFilterWindow()));
					
					List<WebElement> list2=driver.findElements(obj_PortalPage.DefaultSelectedFilterOptionsUnderIBInFilterWindow());


					for(WebElement lt:list2)
					{
						
							CommonUtility.ScrollToWebElement(driver, lt);

							CommonUtility.highlightElement(driver, lt);
						
						text=lt.getText();
						text4+=" <br> "+text;
					}
					System.out.println("options are "+text4);
				}
					
				Report.put("Click on Filter By and select Install Base Status", 
						"The following values should be selected by default on the Install Base Status -None,Awaiting Customer Install,Install,Install - T&M,Shipped,Reseller Maintained" ,
						"User Able to click on "+Report.color(map)+" and able to click on "+Report.color(text2)+" type of filter and able to see default selected options as "+Report.color(text4), "PASS");
			}
			catch(Exception e)
			{
				Log.info(e);
				Report.put("Click on Filter By and select Install Base Status", 
						"The following values should be selected by default on the Install Base Status -None,Awaiting Customer Install,Install,Install - T&M,Shipped,Reseller Maintained" ,
						"Failed to see all expected selected options", "FAIL");
				e.printStackTrace();
				Assert.fail();
			}

		} 
		
		public void ClickOnFilterAndValidateIBStatusDefaultNotSelectedOptionsDisplayedInInstallBasePage(WebDriver driver)
		{

			Log.info("ClickOnFilterAndValidateIBStatusDefaultNotSelectedOptionsDisplayedInInstallBasePage");	
			WebDriverWait wait = new WebDriverWait(driver, 120);
			String text="";
			String text1="";
			String map="";
			String text2="";
			String defaults="";
			String text3="";
			String text4="";
			String text5="";
			String text6="";
			String text7="";
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			Actions act=new Actions(driver);
			String value=TestNGCreator.TestData.get(Esupport.Dpid.ordinal());
			String value2=TestNGCreator.TestData.get(Esupport.SearchOption.ordinal());
			try
			{
				
				if(CommonUtility.CheckpresenceofElementLocated(driver, 10, obj_PortalPage.UnCheckedFilterOptionsUnderIBStatusInFilterWindow()))
				{
					List<WebElement> list2=driver.findElements(obj_PortalPage.UnCheckedFilterOptionsUnderIBStatusInFilterWindow());


					for(WebElement lt:list2)
					{
						
							CommonUtility.ScrollToWebElement(driver, lt);

							CommonUtility.highlightElement(driver, lt);
						
						text=lt.getText();
						text4+=" <br> "+text;
					}
					System.out.println("options are "+text4);
				}
					
				Report.put("Verify the unchecked values in the same filter", 
						"The following values should be unchecked by default- Expired,Deinstall - Cust Site,Deinstall -  Rtn to Mfg,Deinstall - Upgrade Conversion ,Competitor Maintained,Deinstall - Mech Rep" ,
						"User Able see not selected options as "+Report.color(text4), "PASS");
			}
			catch(Exception e)
			{
				Log.info(e);
				Report.put("Verify the unchecked values in the same filter", 
						"The following values should be unchecked by default- Expired,Deinstall - Cust Site,Deinstall -  Rtn to Mfg,Deinstall - Upgrade Conversion ,Competitor Maintained,Deinstall - Mech Rep" ,
						"Failed to see all expected not selected options", "FAIL");
				e.printStackTrace();
				Assert.fail();
			}

		} 
		
		public void ValidateDefaultFilterInTabularViewInIMTabUnderTotalSRs(WebDriver driver)
		{

			Log.info("ValidateDefaultFilterInTabularViewInIMTabUnderTotalSRs");	
			WebDriverWait wait = new WebDriverWait(driver, 240);
			String text="";
			String text1="";
			String map="";
			String text2="";
			String defaults="";
			String text3="";
			String text4="";
			String text5="";
			String text7="";
			String text8="";
			String text9="";
			String asset="";
			String view="";
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			Actions act=new Actions(driver);
			String value=TestNGCreator.TestData.get(Esupport.Dpid.ordinal());
			try
			{
				if(CommonUtility.CheckpresenceofElementLocated(driver, 10, obj_PortalPage.TotalSRsSelectedUnderIMPage()))
					
				{
					
				asset =CommonUtility.highlightElement(driver,  obj_PortalPage.TotalSRsSelectedUnderIMPage()).getText();
				System.out.println("default menu displayed is " +asset);
				
				
				view =CommonUtility.highlightElement(driver,  obj_PortalPage.TableViewDefaultDisplay()).getText();
				System.out.println("default view displayed is " +view);
				
				List<WebElement> list2=driver.findElements(obj_PortalPage.BreadScrumbsOnGraphView());


					for(WebElement lt:list2)
					{
						
							CommonUtility.ScrollToWebElement(driver, lt);

							CommonUtility.highlightElement(driver, lt);
						
						text=lt.getText();
						text4+=" <br> "+text;
					}
					System.out.println("Breadscrumbs are "+text4);
					
					if(text4.contains("Install Base Status"))
					{
						Report.put("Verify the default filter displayed on the Summary View of Incident Management page ", 
								"Install Base Status should be set as the default filter in the summary page of Install Base" ,
								Report.color(text4)+" displayed as a default filter in the "+Report.color(view)+" of install base page", "PASS");
					
					}
					else
					{
						Report.put("Verify the default filter displayed on the Summary View of Incident Management page ", 
								"The default filter should be displayed as Install Base Status" ,
								"Failed see Install Base Status as default filter", "FAIL");
						Assert.fail();
					}

				}
				Report.put("Verify the default filter displayed on the Summary View of Incident Management page ", 
						"The default filter should be displayed as Install Base Status" ,
						Report.color(text4)+" displayed as a default filter in the "+Report.color(view)+" of Incident management page", "PASS");
				}
				
			
			catch(Exception e)
			{
				Log.info(e);
				Report.put("Verify the default filter displayed on the Summary View of Incident Management page ", 
						"The default filter should be displayed as Install Base Status" ,
						"Failed see Install Base Status as default filter", "FAIL");
				e.printStackTrace();
				Assert.fail();
			}

		} 
		
		public void ValidateDefaultFilterInTabularViewInHealthAndRiskTabUnderFCO(WebDriver driver)
		{

			Log.info("ValidateDefaultFilterInTabularViewInHealthAndRiskTabUnderFCO");	
			WebDriverWait wait = new WebDriverWait(driver, 120);
			String text="";
			String text1="";
			String map="";
			String text2="";
			String defaults="";
			String text3="";
			String text4="";
			String text5="";
			String text7="";
			String text8="";
			String text9="";
			String asset="";
			String view="";
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			Actions act=new Actions(driver);
			String value=TestNGCreator.TestData.get(Esupport.Dpid.ordinal());
			try
			{
				if(CommonUtility.CheckpresenceofElementLocated(driver, 10, obj_PortalPage.FieldChangeOrderInHealthAndRisk()))
					
				{
					
				asset =CommonUtility.highlightElement(driver,  obj_PortalPage.FieldChangeOrderInHealthAndRisk()).getText();
				System.out.println("default menu displayed is " +asset);
				
				
				view =CommonUtility.highlightElement(driver,  obj_PortalPage.TableViewDefaultDisplay()).getText();
				System.out.println("default view displayed is " +view);
				
				List<WebElement> list2=driver.findElements(obj_PortalPage.BreadScrumbsOnGraphView());


					for(WebElement lt:list2)
					{
						
							CommonUtility.ScrollToWebElement(driver, lt);

							CommonUtility.highlightElement(driver, lt);
						
						text=lt.getText();
						text4+=" <br> "+text;
					}
					System.out.println("Breadscrumbs are "+text4);
					
					if(text4.contains("Install Base Status"))
					{
						Report.put("Verify the default filter pills displayed on the Health and Risks tab ", 
								"The default filter pills should be displayed as 'Install Base Status'" ,
								Report.color(text4)+" displayed as a default filter in the "+Report.color(view)+" of Health and risk page", "PASS");
					
					}
					else
					{
						Report.put("Verify the default filter pills displayed on the Health and Risks tab ", 
								"The default filter pills should be displayed as 'Install Base Status'" ,
								"Failed see Install Base Status as default filter", "FAIL");
						Assert.fail();
					}

				}
				Report.put("Verify the default filter pills displayed on the Health and Risks tab ", 
						"The default filter pills should be displayed as 'Install Base Status'" ,
						Report.color(text4)+" displayed as a default filter in the "+Report.color(view)+" of Health and risk page", "PASS");
				}
				
			
			catch(Exception e)
			{
				Log.info(e);
				Report.put("Verify the default filter pills displayed on the Health and Risks tab ", 
						"The default filter pills should be displayed as 'Install Base Status'" ,
						"Failed see Install Base Status as default filter", "FAIL");
				e.printStackTrace();
				Assert.fail();
			}

		} 
		
		
		public void ValidateDefaultFilterInSummaryPageWhenUserSelectedSecurityAdvisoriesFromLeftMenu(WebDriver driver)
		{

			Log.info("ValidateDefaultFilterInSummaryPageWhenUserSelectedSecurityAdvisoriesFromLeftMenu");	
			WebDriverWait wait = new WebDriverWait(driver, 120);
			String text="";
			String text1="";
			String map="";
			String text2="";
			String defaults="";
			String text3="";
			String text4="";
			String view="";
			
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			Actions act=new Actions(driver);
			String value=TestNGCreator.TestData.get(Esupport.Dpid.ordinal());
			
			try
			{
				//			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.IncidentsManagementTab()));
				if(CommonUtility.CheckpresenceofElementLocated(driver, 10, obj_PortalPage.securityAdvisoryTab()))
				{
					CommonUtility.scrollToViewElement(driver, obj_PortalPage.securityAdvisoryTab());
					text2=CommonUtility.highlightElement(driver, obj_PortalPage.securityAdvisoryTab()).getText();
					System.out.println(text2);
					CommonUtility.ClickOn(driver, obj_PortalPage.securityAdvisoryTab());
					wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.SecurityAdvisoriesActiveAfterSelected()));
							
					
					view =CommonUtility.highlightElement(driver,  obj_PortalPage.TableViewDefaultDisplay()).getText();
					System.out.println("default view displayed is " +view);
					
					List<WebElement> list2=driver.findElements(obj_PortalPage.BreadScrumbsOnGraphView());


						for(WebElement lt:list2)
						{
							
								CommonUtility.ScrollToWebElement(driver, lt);

								CommonUtility.highlightElement(driver, lt);
							
							text=lt.getText();
							text4+=" <br> "+text;
						}
						System.out.println("Breadscrumbs are "+text4);
						
						if(text4.contains("Install Base Status"))
						{
							Report.put("Verify the  default filter pills displayed on each of the Advisories in left side menus from the Health and Risks tab ", 
									"The default filter pills should be displayed as 'Install Base Status' in all Summary pages" ,
									Report.color(text4)+" displayed as a default filter in the "+Report.color(view)+" of install base page under "+Report.color(text2)+" context", "PASS");
						
						}
						else
						{
							Report.put("Verify the  default filter pills displayed on each of the Advisories in left side menus from the Health and Risks tab ", 
									"The default filter pills should be displayed as 'Install Base Status' in all Summary pages" ,
									"Failed see Install Base Status as default filter", "FAIL");
							Assert.fail();
						}

					}
				Report.put("Verify the  default filter pills displayed on each of the Advisories in left side menus from the Health and Risks tab ", 
						"The default filter pills should be displayed as 'Install Base Status' in all Summary pages" ,
						Report.color(text4)+" displayed as a default filter in the "+Report.color(view)+" of install base page under "+Report.color(text2)+" context", "PASS");
			
				}
				
			catch(Exception e)
			{
				Log.info(e);
				Report.put("Verify the  default filter pills displayed on each of the Advisories in left side menus from the Health and Risks tab ", 
						"The default filter pills should be displayed as 'Install Base Status' in all Summary pages" ,
						"Failed see Install Base Status as default filter", "FAIL");
				e.printStackTrace();
				Assert.fail();
			}

		} 
		
		public void ValidateDefaultFilterInSummaryPageWhenUserSelectedTSEFromLeftMenu(WebDriver driver)
		{

			Log.info("ValidateDefaultFilterInSummaryPageWhenUserSelectedTSEFromLeftMenu");	
			WebDriverWait wait = new WebDriverWait(driver, 120);
			String text="";
			String text1="";
			String map="";
			String text2="";
			String defaults="";
			String text3="";
			String text4="";
			String view="";
			
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			Actions act=new Actions(driver);
			String value=TestNGCreator.TestData.get(Esupport.Dpid.ordinal());
			
			try
			{
				//			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.IncidentsManagementTab()));
				if(CommonUtility.CheckpresenceofElementLocated(driver, 10, obj_PortalPage.TrackableServiceEventsTab()))
				{
					CommonUtility.scrollToViewElement(driver, obj_PortalPage.TrackableServiceEventsTab());
					text2=CommonUtility.highlightElement(driver, obj_PortalPage.TrackableServiceEventsTab()).getText();
					System.out.println(text2);
					CommonUtility.ClickOn(driver, obj_PortalPage.TrackableServiceEventsTab());
					wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.TrackableServiceEventsActiveAfterSelected()));
							
					
					view =CommonUtility.highlightElement(driver,  obj_PortalPage.TableViewDefaultDisplay()).getText();
					System.out.println("default view displayed is " +view);
					
					List<WebElement> list2=driver.findElements(obj_PortalPage.BreadScrumbsOnGraphView());


						for(WebElement lt:list2)
						{
							
								CommonUtility.ScrollToWebElement(driver, lt);

								CommonUtility.highlightElement(driver, lt);
							
							text=lt.getText();
							text4+=" <br> "+text;
						}
						System.out.println("Breadscrumbs are "+text4);
						
						if(text4.contains("Install Base Status"))
						{
							Report.put("Verify the  default filter pills displayed on each of the Advisories in left side menus from the Health and Risks tab ", 
									"The default filter pills should be displayed as 'Install Base Status' in all Summary pages" ,
									Report.color(text4)+" displayed as a default filter in the "+Report.color(view)+" of install base page under "+Report.color(text2)+" context", "PASS");
						
						}
						else
						{
							Report.put("Verify the  default filter pills displayed on each of the Advisories in left side menus from the Health and Risks tab ", 
									"The default filter pills should be displayed as 'Install Base Status' in all Summary pages" ,
									"Failed see Install Base Status as default filter", "FAIL");
							Assert.fail();
						}

					}
				Report.put("Verify the  default filter pills displayed on each of the Advisories in left side menus from the Health and Risks tab ", 
						"The default filter pills should be displayed as 'Install Base Status' in all Summary pages" ,
						Report.color(text4)+" displayed as a default filter in the "+Report.color(view)+" of install base page under "+Report.color(text2)+" context", "PASS");
			
				}
				
			catch(Exception e)
			{
				Log.info(e);
				Report.put("Verify the  default filter pills displayed on each of the Advisories in left side menus from the Health and Risks tab ", 
						"The default filter pills should be displayed as 'Install Base Status' in all Summary pages" ,
						"Failed see Install Base Status as default filter", "FAIL");
				e.printStackTrace();
				Assert.fail();
			}

		} 
		
		public void ValidateDefaultFilterInSummaryPageWhenUserSelectedTechnicalAdvisoriesFromLeftMenu(WebDriver driver)
		{

			Log.info("ValidateDefaultFilterInSummaryPageWhenUserSelectedTechnicalAdvisoriesFromLeftMenu");	
			WebDriverWait wait = new WebDriverWait(driver, 120);
			String text="";
			String text1="";
			String map="";
			String text2="";
			String defaults="";
			String text3="";
			String text4="";
			String view="";
			
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			Actions act=new Actions(driver);
			String value=TestNGCreator.TestData.get(Esupport.Dpid.ordinal());
			
			try
			{
				//			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.IncidentsManagementTab()));
				if(CommonUtility.CheckpresenceofElementLocated(driver, 10, obj_PortalPage.technicalAdvisoryTab()))
				{
					CommonUtility.scrollToViewElement(driver, obj_PortalPage.technicalAdvisoryTab());
					text2=CommonUtility.highlightElement(driver, obj_PortalPage.technicalAdvisoryTab()).getText();
					System.out.println(text2);
					CommonUtility.ClickOn(driver, obj_PortalPage.technicalAdvisoryTab());
					wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.TexhnicalAdvisoriesTabActiveAfterselected()));
							
					
					view =CommonUtility.highlightElement(driver,  obj_PortalPage.TableViewDefaultDisplay()).getText();
					System.out.println("default view displayed is " +view);
					
					List<WebElement> list2=driver.findElements(obj_PortalPage.BreadScrumbsOnGraphView());


						for(WebElement lt:list2)
						{
							
								CommonUtility.ScrollToWebElement(driver, lt);

								CommonUtility.highlightElement(driver, lt);
							
							text=lt.getText();
							text4+=" <br> "+text;
						}
						System.out.println("Breadscrumbs are "+text4);
						
						if(text4.contains("Install Base Status"))
						{
							Report.put("Verify the  default filter pills displayed on each of the Advisories in left side menus from the Health and Risks tab ", 
									"The default filter pills should be displayed as 'Install Base Status' in all Summary pages" ,
									Report.color(text4)+" displayed as a default filter in the "+Report.color(view)+" of install base page under "+Report.color(text2)+" context", "PASS");
						
						}
						else
						{
							Report.put("Verify the  default filter pills displayed on each of the Advisories in left side menus from the Health and Risks tab ", 
									"The default filter pills should be displayed as 'Install Base Status' in all Summary pages" ,
									"Failed see Install Base Status as default filter", "FAIL");
							Assert.fail();
						}

					}
				Report.put("Verify the  default filter pills displayed on each of the Advisories in left side menus from the Health and Risks tab ", 
						"The default filter pills should be displayed as 'Install Base Status' in all Summary pages" ,
						Report.color(text4)+" displayed as a default filter in the "+Report.color(view)+" of install base page under "+Report.color(text2)+" context", "PASS");
			
				}
				
			catch(Exception e)
			{
				Log.info(e);
				Report.put("Verify the  default filter pills displayed on each of the Advisories in left side menus from the Health and Risks tab ", 
						"The default filter pills should be displayed as 'Install Base Status' in all Summary pages" ,
						"Failed see Install Base Status as default filter", "FAIL");
				e.printStackTrace();
				Assert.fail();
			}

		} 
		
		public void verifyHealthAndRiskSearchTextboxAfterEnteringText(WebDriver driver)
		{
			System.out.println("Inside verifyHealthAndRiskSearchTextboxAfterEnteringText");
			Log.info("Inside verifyHealthAndRiskSearchTextboxAfterEnteringText");   
			
			WebDriverWait wait = new WebDriverWait(driver, 120); 
			
			String defaultText = "";
			String text = "";
			try
			{	
				
					defaultText = CommonUtility.highlightElement(driver, obj_PortalPage.healthAndRiskSearchTextbox()).getAttribute("placeholder");
								
					System.out.println("Default text displayed : "+defaultText); 
				
					CommonUtility.highlightElement(driver, obj_PortalPage.healthAndRiskSearchTextbox()).sendKeys("1");
					
					text = CommonUtility.highlightElement(driver, obj_PortalPage.healthAndRiskSearchTextbox()).getAttribute("value");
					System.out.println("text displayed : "+text);
					
					if(!(text.equals(defaultText)))
					{
						System.out.println("INside if***");
						Report.put("Verify the default search text disappears as soon as user enters first character in the search box",
							"The  default search text should disappear as soon as user enters first character in the search box",
							"Displayed default text "+Report.color(defaultText)+" Default text disappeared after entering "+Report.color(text), "PASS");
					}
					else
					{
					System.out.println("Failed to verify the default text disappears in the search bar"); 
				
					Report.put("Verify the default search text disappears as soon as user enters first character in the search box",
							"The  default search text should disappear as soon as user enters first character in the search box",
							"Failed to verify the default text disappears in the search bar", "FAIL");
					Assert.fail("Failed to verify the default text disappears in the search bar");
				}
			}

			catch (Exception e)
			{
				Log.info(e);
				e.printStackTrace();
				System.out.println("Failed to verify the default text disappears in the search bar"); 
				
				Report.put("Verify the default search text disappears as soon as user enters first character in the search box",
						"The  default search text should disappear as soon as user enters first character in the search box",
						"Failed to verify the default text disappears in the search bar", "FAIL");
				Assert.fail("Failed to verify the default text disappears in the search bar");
			}               
		}

		public void verifyHealthAndRiskSearchTextboxInvalidData(WebDriver driver, String value)
		{
			System.out.println("Inside verifyHealthAndRiskSearchTextboxInvalidData");
			Log.info("Inside verifyHealthAndRiskSearchTextboxInvalidData");   
			
			WebDriverWait wait = new WebDriverWait(driver, 120); 
			
			String message = "";
			String text = "";
			try
			{	
				
					CommonUtility.highlightElement(driver, obj_PortalPage.healthAndRiskSearchTextbox()).clear();
					
					CommonUtility.highlightElement(driver, obj_PortalPage.healthAndRiskSearchTextbox()).sendKeys(value);
					
					text = CommonUtility.highlightElement(driver, obj_PortalPage.healthAndRiskSearchTextbox()).getAttribute("value");
					System.out.println("text entered : "+text);
					
					CommonUtility.ClickOn(driver, obj_PortalPage.healthAndRiskSearchIcon());
					
					Thread.sleep(5000);
					wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.incidentManagementExpandHeader()));
					
					message = CommonUtility.highlightElement(driver, obj_PortalPage.invalidDataErrorMessage()).getText();
					
					
					if(!message.isEmpty())
					{
						System.out.println("Error message is: "+message);
						Report.put("Type in some invalid text in the search box and click search icon/Enter button",
							"'No Records Found' should be displayed in the grid",
							"Entered invalid text "+Report.color(value)+" displayed message "+Report.color(message), "PASS");
					}
					else
					{
					System.out.println("Failed to verify entering invalid text in the search box"); 
				
					Report.put("Type in some invalid text in the search box and click search icon/Enter button",
							"'No Records Found' should be displayed in the grid",
							"Failed to verify entering invalid text in the search box", "FAIL");
					Assert.fail("Failed to verify entering invalid text in the search box");
				}
			}

			catch (Exception e)
			{
				Log.info(e);
				e.printStackTrace();
				System.out.println("Failed to verify entering invalid text in the search box"); 
				
				Report.put("Type in some invalid text in the search box and click search icon/Enter button",
						"'No Records Found' should be displayed in the grid",
						"Failed to verify entering invalid text in the search box", "FAIL");
				Assert.fail("Failed to verify entering invalid text in the search box");
			}               
		}
		
		public void verifyHealthAndRiskSearchTextboxValidData(WebDriver driver, String value)
		{
			System.out.println("Inside verifyHealthAndRiskSearchTextboxValidData");
			Log.info("Inside verifyHealthAndRiskSearchTextboxValidData");   
			
			WebDriverWait wait = new WebDriverWait(driver, 120); 
			
			String prodName = "";
			String text = "";
			try
			{	
				
					CommonUtility.highlightElement(driver, obj_PortalPage.healthAndRiskSearchTextbox()).clear();
					
					CommonUtility.highlightElement(driver, obj_PortalPage.healthAndRiskSearchTextbox()).sendKeys(value);
					
					text = CommonUtility.highlightElement(driver, obj_PortalPage.healthAndRiskSearchTextbox()).getAttribute("value");
					System.out.println("text entered : "+text);
					
					CommonUtility.ClickOn(driver, obj_PortalPage.healthAndRiskSearchIcon());
					
					Thread.sleep(5000);
					wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.incidentManagementExpandHeader()));
					
					prodName = CommonUtility.highlightElement(driver, obj_PortalPage.prodNameColFirstRow()).getAttribute("innerHTML");
					
					System.out.println("Prod Name is: "+prodName);
					if(prodName.contains(value))
					{
						System.out.println("Prod Name is: "+prodName);
						
						Report.put("Type in characters with some relevant data in the search box and click search icon/Enter button ",
							" Service Request grid data should be filtered based on the search text ",
							"Entered text "+Report.color(value)+" filtered SR Grid data on search Text "+Report.color(prodName), "PASS");
					}
					else
					{
					System.out.println("Failed to verify entering valid text in the search box"); 
				
					Report.put("Type in characters with some relevant data in the search box and click search icon/Enter button ",
							" Service Request grid data should be filtered based on the search text ",
							"Failed to verify entering valid text in the search box", "FAIL");
					Assert.fail("Failed to verify entering valid text in the search box");
				}
			}

			catch (Exception e)
			{
				Log.info(e);
				e.printStackTrace();
				System.out.println("Failed to verify entering valid text in the search box"); 
				
				Report.put("Type in characters with some relevant data in the search box and click search icon/Enter button ",
						" Service Request grid data should be filtered based on the search text ",
						"Failed to verify entering valid text in the search box", "FAIL");
				Assert.fail("Failed to verify entering valid text in the search box");
			}               
		}
		
		public void verifySRCreateDateFilter(WebDriver driver)
		{
			System.out.println("Inside verifySRCreateDateFilter method");
			Log.info("Inside verifySRCreateDateFilter method");


			String filterButton = "";
			String filterByHeader = "";
			String srCreateDate = "";
			try
			{
				WebDriverWait wait = new WebDriverWait(driver, 120);

				CommonUtility.scrollToViewElement(driver,(obj_PortalPage.incidentManagementSummaryViewFilterButton()));
				filterButton = CommonUtility.highlightElement(driver,obj_PortalPage.incidentManagementSummaryViewFilterButton()).getText();

				CommonUtility.highlightElement(driver,obj_PortalPage.incidentManagementSummaryViewFilterButton()).click();

				System.out.println("Clicked on "+filterButton);

				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.incidentManagementFilterByPopupHeader()));

				CommonUtility.highlightElement(driver,obj_PortalPage.incidentManagementFilterByPopupHeader());

				filterByHeader = CommonUtility.highlightElement(driver,obj_PortalPage.incidentManagementFilterByPopupHeader()).getText();

				System.out.println("Header is"+filterByHeader);			

				srCreateDate = CommonUtility.highlightElement(driver,obj_PortalPage.SrCreateDateFilter()).getText();
				
				System.out.println("Filter is: "+srCreateDate);

				if(srCreateDate.contains("SR Create Date"))
				{
				Report.put("Click on the  Total SRs from the left menu in the Incident Management tab and verify the Filter By section",
						"The Filter By section should be displayed with the filter SR Create Date instead of SR Date",
						"Filter is: "+Report.color(srCreateDate), "PASS");
				}
				else
				{
					Report.put("Click on the  Total SRs from the left menu in the Incident Management tab and verify the Filter By section",
							"The Filter By section should be displayed with the filter SR Create Date instead of SR Date",
							"Failed to display SR Create Date filter", "FAIL");
					Assert.fail("Failed to display SR Create Date filter");
				}
			} 
			catch(Exception e)
			{
				e.printStackTrace();

				Report.put("Click on the  Total SRs from the left menu in the Incident Management tab and verify the Filter By section",
						"The Filter By section should be displayed with the filter SR Create Date instead of SR Date",
						"Failed to display SR Create Date filter", "FAIL");
				Assert.fail("Failed to display SR Create Date filter");
			}
		}
		
		public void verifyCheckboxAdvisoryRow(WebDriver driver)
		{
			System.out.println("Inside verifyCheckboxAdvisoryRow method");
			Log.info("Inside verifyCheckboxAdvisoryRow method");

			String label = "";

			try
			{
				WebDriverWait wait = new WebDriverWait(driver, 120);

				if((CommonUtility.CheckpresenceofElementLocated(driver, 10, obj_PortalPage.advisoryCheckboxFirstRow())) && (CommonUtility.CheckpresenceofElementLocated(driver, 10, obj_PortalPage.markAdvisoryLabel())))
				{
					CommonUtility.highlightElement(driver,(obj_PortalPage.markAdvisoryLabel()));
					label = CommonUtility.highlightElement(driver,obj_PortalPage.markAdvisoryLabel()).getText();

					System.out.println("Label is "+label);
					
					Report.put("User verifies if the  checkboxes are available to the left of each security advisory row  ",
							"User should be able to view the check boxes to the to the left of each security advisory row and can see 'Mark Advisory as: ' label above the grid on the left hand side ",
							"User is able to view the check boxes and label displayed as: "+Report.color(label), "PASS");
				}
				else
				{
					Report.put("User verifies if the  checkboxes are available to the left of each security advisory row  ",
							"User should be able to view the check boxes to the to the left of each security advisory row and can see 'Mark Advisory as: ' label above the grid on the left hand side ",
							"Failed to view the check boxes and see label 'Mark Advisory as: ' ", "FAIL");
					Assert.fail();
				}
			} 
			catch(Exception e)
			{
				e.printStackTrace();
				Report.put("User verifies if the  checkboxes are available to the left of each security advisory row  ",
						"User should be able to view the check boxes to the to the left of each security advisory row and can see 'Mark Advisory as: ' label above the grid on the left hand side ",
						"Failed to view the check boxes and see label 'Mark Advisory as: ' ", "FAIL");
				Assert.fail();
			}
		}
		
		public void verifyAdvisoryReviewAndNotApplicableButton(WebDriver driver)
		{
			System.out.println("Inside verifyAdvisoryReviewAndNotApplicableBUtton method");
			Log.info("Inside verifyAdvisoryReviewAndNotApplicableBUtton method");

			String reviewButton = "";
			String notApplicableButton = "";
			try
			{
				WebDriverWait wait = new WebDriverWait(driver, 120);

				if(!(CommonUtility.highlightElement(driver, obj_PortalPage.advisoryReviewButton()).isEnabled() && (CommonUtility.highlightElement(driver, obj_PortalPage.advisoryNotApplicableButton()).isEnabled())))
				{
					CommonUtility.highlightElement(driver,(obj_PortalPage.advisoryReviewButton()));
					reviewButton = CommonUtility.highlightElement(driver,obj_PortalPage.advisoryReviewButton()).getText();

					System.out.println("Review Button text is "+reviewButton);
					
					CommonUtility.highlightElement(driver,(obj_PortalPage.advisoryNotApplicableButton()));
					notApplicableButton = CommonUtility.highlightElement(driver,obj_PortalPage.advisoryNotApplicableButton()).getText();

					System.out.println("Not Applicable Button text is "+notApplicableButton);
					
					Report.put("User verifies 'Reviewed' & 'Not Applicable' buttons on the top of the row Mark Advisory As",
							"User should be able to view the check boxes to the to the left of each security advisory row and can see 'Mark Advisory as: ' label above the grid on the left hand side ",
							"User is able to view the buttons: "+Report.color(reviewButton)+Report.color(notApplicableButton), "PASS");
				}
				else
				{
					Report.put("User verifies 'Reviewed' & 'Not Applicable' buttons on the top of the row Mark Advisory As",
							"User should be able to view the check boxes to the to the left of each security advisory row and can see 'Mark Advisory as: ' label above the grid on the left hand side ",
							"Failed to view the buttons on top of row 'Mark Advisory as: ' ", "FAIL");
					Assert.fail();
				}
			} 
			catch(Exception e)
			{
				e.printStackTrace();
				Report.put("User verifies 'Reviewed' & 'Not Applicable' buttons on the top of the row Mark Advisory As",
						"User should be able to view the check boxes to the to the left of each security advisory row and can see 'Mark Advisory as: ' label above the grid on the left hand side ",
						"Failed to view the buttons on top of row 'Mark Advisory as: ' ", "FAIL");
				Assert.fail();
			}
		}
		
		public void verifyAdvisoryReviewButtonTooltip(WebDriver driver)
		{
			System.out.println("Inside verifyAdvisoryReviewButtonTooltip method");
			Log.info("Inside verifyAdvisoryReviewButtonTooltip method");

			String tooltip = "";
			try
			{
				WebDriverWait wait = new WebDriverWait(driver, 120);

				if(CommonUtility.CheckpresenceofElementLocated(driver, 10, obj_PortalPage.advisoryReviewButtonTooltip()))
				{
					
					CommonUtility.ScrollTo(driver,obj_PortalPage.incidentManagementSummaryViewFilterButton());
					CommonUtility.ScrollTo(driver,obj_PortalPage.advisoryReviewButton());
					Thread.sleep(5000);
					Actions act=new Actions(driver);
					act.moveToElement(driver.findElement(obj_PortalPage.advisoryReviewButton())).build().perform();
					Thread.sleep(20000);
//					WebElement toolTipElement = driver.findElement(By.cssSelector(".ui-tooltip"));
//				    String toolTipText = toolTipElement.getText();
//				    System.out.println("***************"+toolTipText);
					//CommonUtility.highlightElement(driver,(obj_PortalPage.advisoryReviewButtonTooltip()));
//					WebElement toolTip = driver.findElement(By.cssSelector("common-tooltip")); 
//					String toolTipText = toolTip.getText();
//					 System.out.println("toolTipText-->"+toolTipText); 
					tooltip = CommonUtility.highlightElement(driver,obj_PortalPage.advisoryReviewButtonTooltip()).getAttribute("outerHTML");

					System.out.println("Tooltip text is "+tooltip);
					
					
					Report.put("User verifies 'Reviewed' & 'Not Applicable' buttons on the top of the row Mark Advisory As",
							"User should be able to view the check boxes to the to the left of each security advisory row and can see 'Mark Advisory as: ' label above the grid on the left hand side ",
							"User is able to view the buttons: "+Report.color(tooltip), "PASS");
				}
				else
				{
					Report.put("User verifies 'Reviewed' & 'Not Applicable' buttons on the top of the row Mark Advisory As",
							"User should be able to view the check boxes to the to the left of each security advisory row and can see 'Mark Advisory as: ' label above the grid on the left hand side ",
							"Failed to view the buttons on top of row 'Mark Advisory as: ' ", "FAIL");
					Assert.fail();
				}
			} 
			catch(Exception e)
			{
				e.printStackTrace();
				Report.put("User verifies 'Reviewed' & 'Not Applicable' buttons on the top of the row Mark Advisory As",
						"User should be able to view the check boxes to the to the left of each security advisory row and can see 'Mark Advisory as: ' label above the grid on the left hand side ",
						"Failed to view the buttons on top of row 'Mark Advisory as: ' ", "FAIL");
				Assert.fail();
			}
		}
		
//		public void clickAdvisoryCheckboxWithStatusNew(WebDriver driver)
//		{
//			System.out.println("Inside clickAdvisoryCheckboxWithStatusNew method");
//			Log.info("Inside clickAdvisoryCheckboxWithStatusNew method");
//
//			try
//			{
//				WebDriverWait wait = new WebDriverWait(driver, 120);
//
//				CommonUtility.ClickOn(driver,obj_PortalPage.incidentManagementSummaryViewFilterButton());
//				
//				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.incidentManagementFilterByPopupHeader()));
//
//				CommonUtility.highlightElement(driver,obj_PortalPage.incidentManagementFilterByPopupHeader());
//				
//				CommonUtility.ClickOn(driver,obj_PortalPage.incidentManagementFilterByPopupClearAllButton());
//				
//				CommonUtility.ClickOn(driver,obj_PortalPage.remediationStatusFilter());
//				
//				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.remediationStatusHeader()));
//				
//				CommonUtility.ClickOn(driver,obj_PortalPage.remediationStatusNew());
//				
//				CommonUtility.ClickOn(driver,obj_PortalPage.incidentManagementFilterByPopupApplySelectedButton());
//				CommonUtility.ClickOn(driver,obj_PortalPage.incidentManagementFilterByPopupCloseButton());
//				
//				Thread.sleep(5000);
//				CommonUtility.ClickOn(driver,obj_PortalPage.advisoryCheckboxFirstRow());
//				
//				Thread.sleep(3000);
//				
//				if((CommonUtility.highlightElement(driver, obj_PortalPage.advisoryReviewButton()).isEnabled() && (CommonUtility.highlightElement(driver, obj_PortalPage.advisoryNotApplicableButton()).isEnabled())))
//				{
//					CommonUtility.highlightElement(driver,(obj_PortalPage.advisoryReviewButton()));
//
//					CommonUtility.highlightElement(driver,(obj_PortalPage.advisoryNotApplicableButton()));
//
//					System.out.println("Reviewed button & Not Applicable button enabled ");
//					
//					
//					Report.put("User selects some New/Updated advisories checkbox from the security advisory grid and hovers over Reviewed or Not Applicable buttons",
//							"User should be able view that the message pop up should NOT be displayed and Reviewed and Not Applicable buttons should be Enabled ",
//							"Enabled Reviewed and Not Applicable buttons ", "PASS");
//				}
//				else
//				{
//					Report.put("User selects some New/Updated advisories checkbox from the security advisory grid and hovers over Reviewed or Not Applicable buttons",
//							"User should be able view that the message pop up should NOT be displayed and Reviewed and Not Applicable buttons should be Enabled ",
//							"Failed to verify Reviewed and Not Applicable buttons should be Enabled ", "FAIL");
//					Assert.fail("Failed to verify Reviewed and Not Applicable buttons should be Enabled ");
//				}
//			} 
//			catch(Exception e)
//			{
//				e.printStackTrace();
//				Report.put("User selects some New/Updated advisories checkbox from the security advisory grid and hovers over Reviewed or Not Applicable buttons",
//						"User should be able view that the message pop up should NOT be displayed and Reviewed and Not Applicable buttons should be Enabled ",
//						"Failed to verify Reviewed and Not Applicable buttons should be Enabled ", "FAIL");
//				Assert.fail("Failed to verify Reviewed and Not Applicable buttons should be Enabled ");
//			}
//		}
		
		public void clickAdvisoryCheckboxAndClickReviewButton(WebDriver driver)
		{
			System.out.println("Inside clickAdvisoryCheckboxAndClickReviewButton method");
			Log.info("Inside clickAdvisoryCheckboxAndClickReviewButton method");

			try
			{
				WebDriverWait wait = new WebDriverWait(driver, 120);

				if((CommonUtility.highlightElement(driver, obj_PortalPage.advisoryReviewButton()).isSelected()))
				{
					System.out.println("Checkbox is already selected ");	
				}
				else
				{
					CommonUtility.ClickOn(driver,obj_PortalPage.advisoryCheckboxFirstRow());	
					System.out.println("Checkbox selected ");
				}
				
				Thread.sleep(3000);
				CommonUtility.ClickOn(driver,obj_PortalPage.advisoryReviewButton());

					CommonUtility.highlightElement(driver,(obj_PortalPage.advisoryNotApplicableButton()));

					System.out.println("Reviewed button & Not Applicable button enabled ");
					
					
					Report.put("User selects some New/Updated advisories checkbox from the security advisory grid and hovers over Reviewed or Not Applicable buttons",
							"User should be able view that the message pop up should NOT be displayed and Reviewed and Not Applicable buttons should be Enabled ",
							"Enabled Reviewed and Not Applicable buttons ", "PASS");
				
			} 
			catch(Exception e)
			{
				e.printStackTrace();
				Report.put("User selects some New/Updated advisories checkbox from the security advisory grid and hovers over Reviewed or Not Applicable buttons",
						"User should be able view that the message pop up should NOT be displayed and Reviewed and Not Applicable buttons should be Enabled ",
						"Failed to verify Reviewed and Not Applicable buttons should be Enabled ", "FAIL");
				Assert.fail("Failed to verify Reviewed and Not Applicable buttons should be Enabled ");
			}
		}
		
		public void clickProductNameFilterWithOptionNone(WebDriver driver)
		{
			System.out.println("Inside clickProductNameFilterWithOptionNone method");
			Log.info("Inside clickProductNameFilterWithOptionNone method");

			try
			{
				WebDriverWait wait = new WebDriverWait(driver, 120);

				Thread.sleep(5000);
				CommonUtility.ClickOn(driver,obj_PortalPage.incidentManagementSummaryViewFilterButton());
				
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.incidentManagementFilterByPopupHeader()));

				CommonUtility.highlightElement(driver,obj_PortalPage.incidentManagementFilterByPopupHeader());
				
				CommonUtility.ClickOn(driver,obj_PortalPage.incidentManagementFilterByPopupClearAllButton());
				
				CommonUtility.ClickOn(driver,obj_PortalPage.incidentManagementSummaryViewFilterButton());
				
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.incidentManagementFilterByPopupHeader()));

				CommonUtility.highlightElement(driver,obj_PortalPage.incidentManagementFilterByPopupHeader());
				
				CommonUtility.ClickOn(driver,obj_PortalPage.productNameFilter());
				
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.productNameHeader()));
				
				CommonUtility.ClickOn(driver,obj_PortalPage.productNameNone());
				
				CommonUtility.ClickOn(driver,obj_PortalPage.incidentManagementFilterByPopupApplySelectedButton());
				CommonUtility.ClickOn(driver,obj_PortalPage.incidentManagementFilterByPopupCloseButton());

				System.out.println("Applied Product Name filter with option None");
					
			} 
			catch(Exception e)
			{
				e.printStackTrace();
				Assert.fail("Failed to Apply Product Name filter with option None");
			}
		}
		
		public void verifyProductNameColumnWithValProductNameUnavailable(WebDriver driver)
		{
			System.out.println("Inside verifyProductNameColumnWithValProductNameUnavailable method");
			Log.info("Inside verifyProductNameColumnWithValProductNameUnavailable method");

			String prodName = "";
			
			try
			{	
				if(CommonUtility.CheckpresenceofElementLocated(driver, 30, obj_PortalPage.productNameColUnavailableVal()))
				{		
				
					prodName = CommonUtility.highlightElement(driver,obj_PortalPage.productNameColUnavailableVal()).getText();
					System.out.println("Prod Name Column Value is : "+prodName);

					if(prodName.contains("Product Name Unavailable"))
					{
						System.out.println("Product Name Unavailable displayed");
						Report.put("Check for the row where the product name is not available ",
	    					"'Product Name Unavailable' message should be displayed",
							"Displaying Product Name Column value is: "+Report.color(prodName), "PASS");	
					}
					else
					{
						System.out.println("Failed to verify 'Product Name Unavailable' value");

						Report.put("Check for the row where the product name is not available ",
		    					"'Product Name Unavailable' message should be displayed",
								"Failed to verify 'Product Name Unavailable'  value", "FAIL");						
						Assert.fail();
					}
				}
				else
				{
					System.out.println("Failed to verify 'Product Name Unavailable' value");

					Report.put("Check for the row where the product name is not available ",
	    					"'Product Name Unavailable' message should be displayed",
							"Failed to verify 'Product Name Unavailable'  value", "FAIL");						
					Assert.fail();
				}
			} 
			catch(Exception e)
			{
				e.printStackTrace();
					System.out.println("Failed to verify 'Product Name Unavailable' value");

					Report.put("Check for the row where the product name is not available ",
	    					"'Product Name Unavailable' message should be displayed",
							"Failed to verify 'Product Name Unavailable'  value", "FAIL");						
					Assert.fail();
			}
		}
		
		public void clickExpandArrowAndVerifyProductNameUnavailable(WebDriver driver)
		{
			System.out.println("Inside clickExpandArrowAndVerifyProductNameUnavailable method");
			Log.info("Inside clickExpandArrowAndVerifyProductNameUnavailable method");

			String prodName = "";
			
			try
			{	
				if(CommonUtility.CheckpresenceofElementLocated(driver, 30, obj_PortalPage.installBaseExpandRightArrow()))
				{		
					CommonUtility.ClickOn(driver,obj_PortalPage.installBaseExpandRightArrow());
					CommonUtility.highlightElement(driver,obj_PortalPage.productNameColUnavailableVal());
					prodName = CommonUtility.highlightElement(driver,obj_PortalPage.productNameColUnavailableVal()).getText();
					System.out.println("Prod Name Column Value is : "+prodName);

					if(prodName.contains("Product Name Unavailable"))
					{
						System.out.println("Product Name Unavailable displayed");
						Report.put("Click on the expanded view and verify the same row",
	    					"'Product Name Unavailable' message should be displayed",
							"Displaying Product Name  value is: "+Report.color(prodName), "PASS");	
					}
					else
					{
						System.out.println("Failed to verify 'Product Name Unavailable' value");

						Report.put("Click on the expanded view and verify the same row",
		    					"'Product Name Unavailable' message should be displayed",
								"Failed to verify 'Product Name Unavailable'  value", "FAIL");						
						Assert.fail();
					}
				}
				else
				{
					System.out.println("Failed to verify 'Product Name Unavailable' value");

					Report.put("Click on the expanded view and verify the same row",
	    					"'Product Name Unavailable' message should be displayed",
							"Failed to verify 'Product Name Unavailable'  value", "FAIL");						
					Assert.fail();
				}
			} 
			catch(Exception e)
			{
				e.printStackTrace();
					System.out.println("Failed to verify 'Product Name Unavailable' value");

					Report.put("Click on the expanded view and verify the same row",
	    					"'Product Name Unavailable' message should be displayed",
							"Failed to verify 'Product Name Unavailable'  value", "FAIL");						
					Assert.fail();
			}
		}
		
		public void clickAdvisoryDateFilterAndFilterDate(WebDriver driver)
		{
			System.out.println("Inside clickAdvisoryDateFilterAndFilterDate method");
			Log.info("Inside clickAdvisoryDateFilterAndFilterDate method");

			try
			{
				WebDriverWait wait = new WebDriverWait(driver, 120);

				Thread.sleep(5000);
				CommonUtility.ClickOn(driver,obj_PortalPage.incidentManagementSummaryViewFilterButton());
				
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.incidentManagementFilterByPopupHeader()));

				CommonUtility.highlightElement(driver,obj_PortalPage.incidentManagementFilterByPopupHeader());
				
				CommonUtility.ClickOn(driver,obj_PortalPage.advisoriesDateFilter());
				
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.advisoriesDateHeader()));
				
				CommonUtility.ClickOn(driver,obj_PortalPage.advisoryFilterFromDatePicker());
				
			//	CommonUtility.ClickOn(driver,obj_PortalPage.advisoryFilterDatePickerTodayButton());

				System.out.println("Applied Advisory Date filter");
				
				Report.put("User clicks on the Filter option and filter the date",
    					"Date picker opens up  and user should be able to select a valid date from picker with date range (Today - 2years)",
						"User clicked on Filter option & filter the date ", "PASS");		
			} 
			catch(Exception e)
			{
				e.printStackTrace();
				Report.put("User clicks on the Filter option and filter the date",
    					"Date picker opens up  and user should be able to select a valid date from picker with date range (Today - 2years)",
						"Failed to Click on Filter option & filter the date ", "FAIL");	
				Assert.fail("Failed to Click on Filter option & filter the date");
			}
		}
		
		public void verifyAdvisoryDateFilterInvalidDates(WebDriver driver)
		{
			System.out.println("Inside verifyAdvisoryDateFilterInvalidDates method");
			Log.info("Inside verifyAdvisoryDateFilterInvalidDates method");

			boolean prevDisabled = false;
			boolean nextDisabled = false;
			String classAtrribute = "";
			try
			{
				WebDriverWait wait = new WebDriverWait(driver, 120);

				Thread.sleep(5000);
				while(CommonUtility.highlightElement(driver,obj_PortalPage.advisoryFilterFromDatePickerPrevYearArrow()).isEnabled())
				{
					CommonUtility.ClickOn(driver,obj_PortalPage.advisoryFilterFromDatePickerPrevYearArrow());
					
					classAtrribute = CommonUtility.highlightElement(driver,obj_PortalPage.advisoryFilterFromDatePickerPrevYearArrow()).getAttribute("class");
					if(classAtrribute.contains("disabled"))
					{
						prevDisabled = true;
						System.out.println("prevDisabled value is "+prevDisabled);
						
						break;
					}
				}
				
				
				
				while(CommonUtility.highlightElement(driver,obj_PortalPage.advisoryFilterFromDatePickerNextYearArrow()).isEnabled())
				{
					CommonUtility.ClickOn(driver,obj_PortalPage.advisoryFilterFromDatePickerNextYearArrow());
					
					classAtrribute = CommonUtility.highlightElement(driver,obj_PortalPage.advisoryFilterFromDatePickerNextYearArrow()).getAttribute("class");
					if(classAtrribute.contains("disabled"))
					{
						nextDisabled = true;
						System.out.println("nextDisabled value is "+nextDisabled);
						break;
					}
				}
				
				if(prevDisabled && nextDisabled)
				{

					System.out.println("Validated clicking on invalid date");
					
					Report.put("User is seeing the From or To date picker",
	    					"Invalid dates - >3 years in the past and all future dates - should be shown inactive with those dates invisible ",
							"Displayed invalid dates invisible ", "PASS");		
				}
				else
				{
					Report.put("User clicks on the Filter option and filter the date",
	    					"Date picker opens up  and user should be able to select a valid date from picker with date range (Today - 2years)",
							"Failed to Display invalid dates as invisible", "FAIL");	
					Assert.fail("Failed to Display invalid dates as invisible");	
				}
				

			} 
			catch(Exception e)
			{
				e.printStackTrace();
				Report.put("User clicks on the Filter option and filter the date",
    					"Date picker opens up  and user should be able to select a valid date from picker with date range (Today - 2years)",
						"Failed to Display invalid dates as invisible", "FAIL");	
				Assert.fail("Failed to Display invalid dates as invisible");
			}
		}
		
		public void verifyDateFormatFromDatePicker(WebDriver driver)
		{
			System.out.println("Inside verifyDateFormatFromDatePicker method");
			Log.info("Inside verifyDateFormatFromDatePicker method");

			WebDriverWait wait = new WebDriverWait(driver, 120);
			String fromDate = "";
			try
			{
				fromDate = CommonUtility.highlightElement(driver,obj_PortalPage.advisoryFilterFromDatePickerTextbox()).getAttribute("value");

				System.out.println("From Date is: "+fromDate);

				Date date = null;
				String formatteddate = null;
				DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
			//	df.setLenient(false);
				date = df.parse(fromDate);
				formatteddate = df.format(date).toString();
		   //     dateNow = ft.format(dNow).toString();
				System.out.println("date: "+formatteddate);

				if(fromDate.contains(formatteddate))
				{
					System.out.println("Format is MM/DD/YYYY");

					Report.put("User selects a date in the To/From picker"+Report.color(fromDate),
							"Date format in the date text box should be  MM/DD/YYYY",
							"Displayed the  Date in the format(MM/DD/YYYY) "+Report.color(formatteddate), "PASS");
				}
				else
				{
					Report.put("User selects a date in the To/From picker"+Report.color(fromDate),
							"Date format in the date text box should be  MM/DD/YYYY",
							"Failed to display  Date in the format(MM/DD/YYYY)", "FAIL");
					Assert.fail();
				}
			} 
			catch(Exception e)
			{
				e.printStackTrace();
				Report.put("User selects a date in the To/From picker"+Report.color(fromDate),
						"Date format in the date text box should be  MM/DD/YYYY",
						"Failed to display  Date in the format(MM/DD/YYYY)", "FAIL");
				Assert.fail();
			}
		}
		
		public void clickAdvisoryDateFilterAndApplySelectedFromDate(WebDriver driver)
		{
			System.out.println("Inside clickAdvisoryDateFilterAndApplySelectedFromDate method");
			Log.info("Inside clickAdvisoryDateFilterAndApplySelectedFromDate method");

			String fromDate = "";
			try
			{
				WebDriverWait wait = new WebDriverWait(driver, 120);

				Thread.sleep(5000);
				
				CommonUtility.ClickOn(driver,obj_PortalPage.advisoriesDateFilter());
				
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.advisoriesDateHeader()));
				
				CommonUtility.ClickOn(driver,obj_PortalPage.advisoryFilterFromDatePicker());
				
				CommonUtility.ClickOn(driver,obj_PortalPage.advisoryFilterFromDatePickerPrevYearArrow());
				CommonUtility.ClickOn(driver,obj_PortalPage.advisoryFilterFromDatePickerNewDate());
				
				fromDate = CommonUtility.highlightElement(driver,obj_PortalPage.advisoryFilterFromDatePickerTextbox()).getAttribute("value");
				
				
				System.out.println("Applied from date is: "+fromDate);
				
				Date date = null;
				String formatteddate = null;
				DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
				date = df.parse(fromDate);
				formatteddate = df.format(date).toString();

				System.out.println("date: "+formatteddate);

				if(fromDate.contains(formatteddate))
				{
					System.out.println("Format is MM/DD/YYYY");
					CommonUtility.ClickOn(driver,obj_PortalPage.incidentManagementFilterByPopupApplySelectedButton());
					CommonUtility.ClickOn(driver,obj_PortalPage.incidentManagementFilterByPopupCloseButton());
					

					Report.put("User selects a date in the To/From picker"+Report.color(fromDate),
							"Date format in the date text box should be  MM/DD/YYYY",
							"Displayed the  Date in the format(MM/DD/YYYY) "+Report.color(formatteddate), "PASS");
				}
				else
				{
					Report.put("User clicks on the Filter option and filter the date",
	    					"Date picker opens up  and user should be able to select a valid date from picker with date range (Today - 2years)",
							"Failed to Click on Filter option & filter the date ", "FAIL");	
					Assert.fail("Failed to Click on Filter option & filter the date");
				}
				
			} 
			catch(Exception e)
			{
				e.printStackTrace();
				Report.put("User clicks on the Filter option and filter the date",
    					"Date picker opens up  and user should be able to select a valid date from picker with date range (Today - 2years)",
						"Failed to Click on Filter option & filter the date ", "FAIL");	
				Assert.fail("Failed to Click on Filter option & filter the date");
			}
		}

		public void clickExpandArrowAndVerifyConnectivityStatus(WebDriver driver)
		{
			System.out.println("Inside clickExpandArrowAndVerifyConnectivityStatus method");
			Log.info("Inside clickExpandArrowAndVerifyConnectivityStatus method");

			String connectivityStatus = "";
			
			try
			{	
				if(CommonUtility.CheckpresenceofElementLocated(driver, 30, obj_PortalPage.installBaseExpandRightArrow()))
				{		
					CommonUtility.ClickOn(driver,obj_PortalPage.installBaseExpandRightArrow());
					Thread.sleep(5000);
					CommonUtility.highlightElement(driver,obj_PortalPage.installBaseExpandRowConnectivityStatus());
					connectivityStatus = CommonUtility.highlightElement(driver,obj_PortalPage.installBaseExpandRowConnectivityStatus()).getText();
					System.out.println("Connectivity Status is : "+connectivityStatus);

					if(!(connectivityStatus.isEmpty()))
					{
						Report.put("User expands any of the Row  and verifies the connectivity status",
	    					" User should able to verify the connectivity status of the product /account ",
							"Displaying Connectivity Status: "+Report.color(connectivityStatus), "PASS");	
					}
					else
					{
						System.out.println("Failed to verify Connectivity Status value");

						Report.put("User expands any of the Row  and verifies the connectivity status",
		    					" User should able to verify the connectivity status of the product /account ",
								"Failed to verify Connectivity Status  value", "FAIL");						
						Assert.fail();
					}
				}
				else
				{
					System.out.println("Failed to verify Connectivity Status value");

					Report.put("User expands any of the Row  and verifies the connectivity status",
	    					" User should able to verify the connectivity status of the product /account ",
							"Failed to verify Connectivity Status  value", "FAIL");						
					Assert.fail();
				}
			} 
			catch(Exception e)
			{
				e.printStackTrace();
				System.out.println("Failed to verify Connectivity Status value");

				Report.put("User expands any of the Row  and verifies the connectivity status",
    					" User should able to verify the connectivity status of the product /account ",
						"Failed to verify Connectivity Status  value", "FAIL");						
				Assert.fail();
			}
		}
	
		public void clickConnectivityTabAndApplyConnectivityFilter(WebDriver driver)
		{
			System.out.println("Inside clickConnectivityTabAndApplyConnectivityFilter method");
			Log.info("Inside clickConnectivityTabAndApplyConnectivityFilter method");

			try
			{
				WebDriverWait wait = new WebDriverWait(driver, 120);

				String option = "";
				String text = "";
				
				CommonUtility.ClickOn(driver,obj_PortalPage.installBaseConnectivityButton());
				Thread.sleep(5000);
				CommonUtility.ClickOn(driver,obj_PortalPage.incidentManagementSummaryViewFilterButton());
				
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.incidentManagementFilterByPopupHeader()));

				CommonUtility.highlightElement(driver,obj_PortalPage.incidentManagementFilterByPopupHeader());
				
				CommonUtility.ClickOn(driver,obj_PortalPage.incidentManagementFilterByPopupClearAllButton());
				
				CommonUtility.ClickOn(driver,obj_PortalPage.incidentManagementSummaryViewFilterButton());
				
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.incidentManagementFilterByPopupHeader()));

				CommonUtility.highlightElement(driver,obj_PortalPage.incidentManagementFilterByPopupHeader());
				
				CommonUtility.ClickOn(driver,(obj_PortalPage.connectivityStatusFilterOption()));

				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.connectivityStatusFilterOptionHeader()));

				CommonUtility.highlightElement(driver,obj_PortalPage.connectivityStatusFilterOptionHeader());


				CommonUtility.ClickOn(driver,obj_PortalPage.connectivityStatusFilterOptionConnected());

				option = CommonUtility.highlightElement(driver,obj_PortalPage.connectivityStatusFilterOptionConnected()).getText();
				CommonUtility.ClickOn(driver, obj_PortalPage.incidentManagementFilterByPopupApplySelectedButton());

				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.incidentManagementFilterByPopupHeader()));
				CommonUtility.ClickOn(driver,obj_PortalPage.incidentManagementFilterByPopupCloseButton());

				Thread.sleep(10000);
				CommonUtility.highlightElement(driver,obj_PortalPage.connectivityHUDText());
				text = CommonUtility.highlightElement(driver,obj_PortalPage.connectivityHUDText()).getText();

				if(!(text.isEmpty()))
				{
					System.out.println("HUD text for Connectivity is "+text);
					
					
					Report.put("Click on Connectivity from the left and modify the Connectivity Filter from Filter by",
							"The Connectivity KPI should be updated and no other KPI should be updated",
							"Updated Connectivity KPI with filter "+Report.color(text), "PASS");
				}
				else
				{
					Report.put("Click on Connectivity from the left and modify the Connectivity Filter from Filter by",
							"The Connectivity KPI should be updated and no other KPI should be updated",
							"Failed to Update Connectivity KPI with filter ", "FAIL");
					Assert.fail("Failed to Update Connectivity KPI with filter ");
				}
			} 
			catch(Exception e)
			{
				e.printStackTrace();
				Report.put("Click on Connectivity from the left and modify the Connectivity Filter from Filter by",
						"The Connectivity KPI should be updated and no other KPI should be updated",
						"Failed to Update Connectivity KPI with filter ", "FAIL");
				Assert.fail("Failed to Update Connectivity KPI with filter ");
			}
		}
		
		public void clickCodelLevelTabAndApplyCodeLevelFilter(WebDriver driver)
		{
			System.out.println("Inside clickCodelLevelTabAndApplyCodeLevelFilter method");
			Log.info("Inside clickCodelLevelTabAndApplyCodeLevelFilter method");

			try
			{
				WebDriverWait wait = new WebDriverWait(driver, 120);

				String option = "";
				String text = "";
				
				CommonUtility.ClickOn(driver,obj_PortalPage.installBaseCodeLevelsButton());
				Thread.sleep(5000);
				CommonUtility.ClickOn(driver,obj_PortalPage.incidentManagementSummaryViewFilterButton());
				
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.incidentManagementFilterByPopupHeader()));

				CommonUtility.highlightElement(driver,obj_PortalPage.incidentManagementFilterByPopupHeader());
				
				CommonUtility.ClickOn(driver,obj_PortalPage.incidentManagementFilterByPopupClearAllButton());
				
				CommonUtility.ClickOn(driver,obj_PortalPage.incidentManagementSummaryViewFilterButton());
				
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.incidentManagementFilterByPopupHeader()));

				CommonUtility.highlightElement(driver,obj_PortalPage.incidentManagementFilterByPopupHeader());
				
				CommonUtility.ClickOn(driver,(obj_PortalPage.codeLevelFilter()));

				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.codeLevelFilterHeader()));

				CommonUtility.highlightElement(driver,obj_PortalPage.codeLevelFilterHeader());


				CommonUtility.ClickOn(driver,obj_PortalPage.codeLevelFilterTargetPlusOption());

				option = CommonUtility.highlightElement(driver,obj_PortalPage.codeLevelFilterTargetPlusOption()).getText();
				CommonUtility.ClickOn(driver, obj_PortalPage.incidentManagementFilterByPopupApplySelectedButton());

				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.incidentManagementFilterByPopupHeader()));
				CommonUtility.ClickOn(driver,obj_PortalPage.incidentManagementFilterByPopupCloseButton());

				Thread.sleep(10000);
				CommonUtility.highlightElement(driver,obj_PortalPage.codeLevelHUDText());
				text = CommonUtility.highlightElement(driver,obj_PortalPage.codeLevelHUDText()).getText();

				if(!(text.isEmpty()))
				{
					System.out.println("HUD text for Codel Level is "+text);
					
					
					Report.put("Click on Code Level Type from the left and modify the Code Level Type Filter from Filter By",
							"The Code Level KPI should be updated and no other KPI should be updated",
							"Updated Code Level KPI with filter "+Report.color(text), "PASS");
				}
				else
				{
					Report.put("Click on Code Level Type from the left and modify the Code Level Type Filter from Filter By",
							"The Code Level KPI should be updated and no other KPI should be updated",
							"Failed to Update Code Level KPI with filter ", "FAIL");
					Assert.fail("Failed to Update Code Level KPI with filter ");
				}
			} 
			catch(Exception e)
			{
				e.printStackTrace();
				Report.put("Click on Code Level Type from the left and modify the Code Level Type Filter from Filter By",
						"The Code Level KPI should be updated and no other KPI should be updated",
						"Failed to Update Code Level KPI with filter ", "FAIL");
				Assert.fail("Failed to Update Code Level KPI with filter ");
			}
		}
		
		public void clickContractsTabAndApplyContractsFilter(WebDriver driver)
		{
			System.out.println("Inside clickContractsTabAndApplyContractsFilter method");
			Log.info("Inside clickContractsTabAndApplyContractsFilter method");

			try
			{
				WebDriverWait wait = new WebDriverWait(driver, 120);

				String option = "";
				String text = "";
				
				CommonUtility.ClickOn(driver,obj_PortalPage.installBaseContractsButton());
				Thread.sleep(5000);
				CommonUtility.ClickOn(driver,obj_PortalPage.incidentManagementSummaryViewFilterButton());
				
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.incidentManagementFilterByPopupHeader()));

				CommonUtility.highlightElement(driver,obj_PortalPage.incidentManagementFilterByPopupHeader());
				
				CommonUtility.ClickOn(driver,obj_PortalPage.incidentManagementFilterByPopupClearAllButton());
				
				CommonUtility.ClickOn(driver,obj_PortalPage.incidentManagementSummaryViewFilterButton());
				
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.incidentManagementFilterByPopupHeader()));

				CommonUtility.highlightElement(driver,obj_PortalPage.incidentManagementFilterByPopupHeader());
				
				CommonUtility.ClickOn(driver,(obj_PortalPage.contractsFilter()));

				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.contractsFilterHeader()));

				CommonUtility.highlightElement(driver,obj_PortalPage.contractsFilterHeader());


				CommonUtility.ClickOn(driver,obj_PortalPage.contractsFilterExpiredOption());

				option = CommonUtility.highlightElement(driver,obj_PortalPage.contractsFilterExpiredOption()).getText();
				CommonUtility.ClickOn(driver, obj_PortalPage.incidentManagementFilterByPopupApplySelectedButton());

				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.incidentManagementFilterByPopupHeader()));
				CommonUtility.ClickOn(driver,obj_PortalPage.incidentManagementFilterByPopupCloseButton());

				Thread.sleep(10000);
				CommonUtility.highlightElement(driver,obj_PortalPage.contractsHUDText());
				text = CommonUtility.highlightElement(driver,obj_PortalPage.contractsHUDText()).getText();

				if(!(text.isEmpty()))
				{
					System.out.println("HUD text for Contracts is "+text);
					
					
					Report.put("Click on the Contract Category from the left and modify the Contract Category filter from the Filter By",
							"All the KPIs should be updated with the new filter data ",
							"Updated Contract KPI with filter "+Report.color(text), "PASS");
				}
				else
				{
					Report.put("Click on the Contract Category from the left and modify the Contract Category filter from the Filter By",
							"All the KPIs should be updated with the new filter data ",
							"Failed to Update Contract KPI with filter ", "FAIL");
					Assert.fail("Failed to Update Contract KPI with filter ");
				}
			} 
			catch(Exception e)
			{
				e.printStackTrace();
				Report.put("Click on the Contract Category from the left and modify the Contract Category filter from the Filter By",
						"All the KPIs should be updated with the new filter data ",
						"Failed to Update Contract KPI with filter ", "FAIL");
				Assert.fail("Failed to Update Contract KPI with filter ");
			}
		}
		
		public void clickTotalSRTabAndApplySRStatusFilter(WebDriver driver)
		{
			System.out.println("Inside clickTotalSRTabAndApplySRStatusFilter method");
			Log.info("Inside clickTotalSRTabAndApplySRStatusFilter method");

			try
			{
				WebDriverWait wait = new WebDriverWait(driver, 120);

				String option = "";
				String text = "";
				String onsiteServiceHud = "";
				String escalationsHud = "";
				String partsReplacedHud = "";
				CommonUtility.ClickOn(driver,obj_PortalPage.incidentManagementTotalSRButton());
				Thread.sleep(5000);
				CommonUtility.ClickOn(driver,obj_PortalPage.incidentManagementSummaryViewFilterButton());
				
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.incidentManagementFilterByPopupHeader()));

				CommonUtility.highlightElement(driver,obj_PortalPage.incidentManagementFilterByPopupHeader());
				
				CommonUtility.ClickOn(driver,obj_PortalPage.incidentManagementFilterByPopupClearAllButton());
				
				CommonUtility.ClickOn(driver,obj_PortalPage.incidentManagementSummaryViewFilterButton());
				
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.incidentManagementFilterByPopupHeader()));

				CommonUtility.highlightElement(driver,obj_PortalPage.incidentManagementFilterByPopupHeader());
				
				CommonUtility.ClickOn(driver,(obj_PortalPage.incidentManagementFilterByPopupSRStatus()));

				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.incidentManagementFilterByPopupSRStatusHeader()));

				CommonUtility.highlightElement(driver,obj_PortalPage.incidentManagementFilterByPopupSRStatusHeader());


				CommonUtility.ClickOn(driver,obj_PortalPage.incidentManagementFilterByPopupSRStatusClosedCheckbox());

				option = CommonUtility.highlightElement(driver,obj_PortalPage.incidentManagementFilterByPopupSRStatusClosedCheckbox()).getText();
				CommonUtility.ClickOn(driver, obj_PortalPage.incidentManagementFilterByPopupApplySelectedButton());

				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.incidentManagementFilterByPopupHeader()));
				CommonUtility.ClickOn(driver,obj_PortalPage.incidentManagementFilterByPopupCloseButton());

				Thread.sleep(10000);
				CommonUtility.highlightElement(driver,obj_PortalPage.incidentManagementOpenSrHud());
				text = CommonUtility.highlightElement(driver,obj_PortalPage.incidentManagementOpenSrHud()).getText();

				if(!(text.isEmpty()))
				{
					System.out.println("HUD text for Total SR is "+text);
					
						
					Report.put("Click on Incident Management tab and change any filter from the Filter By section",
							"All the Incident Management HUD KPIs should be updated w.r.t new filter",
							"Updated Incident Management KPI with filter "+Report.color(text), "PASS");
				}
				else
				{
					Report.put("Click on Incident Management tab and change any filter from the Filter By section",
							"All the Incident Management HUD KPIs should be updated w.r.t new filter",
							"Failed to Update Incident Management KPI with filter ", "FAIL");
					Assert.fail("Failed to Update Incident Management KPI with filter ");
				}
			} 
			catch(Exception e)
			{
				e.printStackTrace();
				Report.put("Click on Incident Management tab and change any filter from the Filter By section",
						"All the Incident Management HUD KPIs should be updated w.r.t new filter",
						"Failed to Update Incident Management KPI with filter ", "FAIL");
				Assert.fail("Failed to Incident Management KPI with filter ");
			}
		}
		
		public void searchServiceTagAndValidateSalesOrderNumber(WebDriver driver, String serviceTag)
		{
			System.out.println("Inside searchServiceTagAndValidateSalesOrderNumber");
			Log.info("Inside searchServiceTagAndValidateSalesOrderNumber");   
			
			WebDriverWait wait = new WebDriverWait(driver, 120); 
			
			String salesOrderNum = "";
			String text = "";
			try
			{					
					CommonUtility.highlightElement(driver, obj_PortalPage.healthAndRiskSearchTextbox()).sendKeys(serviceTag);
					
					System.out.println("Service Tag entered : "+serviceTag);
					
					CommonUtility.ClickOn(driver, obj_PortalPage.healthAndRiskSearchIcon());
					
					Thread.sleep(5000);
					wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.incidentManagementExpandHeader()));
					
					salesOrderNum = CommonUtility.highlightElement(driver, obj_PortalPage.salesOrderNumberValExpandedView()).getText();
					
					System.out.println("salesOrderNum value is : "+salesOrderNum);
					
					if(salesOrderNum.contains("Not Available"))
					{
						System.out.println("INside if***");
						Report.put("User verifies any sales order number of an asset which does not have data ",
							"User should not see 0 but can see the Not Available given under the sales order# if there is no data",
							"Displayed Sale Order Number as "+Report.color(salesOrderNum) +"for Service Tag"+Report.color(serviceTag), "PASS");
					}
					else
					{
					System.out.println("Failed to verify the Sale Order Number"); 
				
					Report.put("User verifies any sales order number of an asset which does not have data ",
							"User should not see 0 but can see the Not Available given under the sales order# if there is no data",
							"Failed to verify the Sale Order Number", "FAIL");
					Assert.fail("Failed to verify the Sale Order Number");
				}
			}

			catch (Exception e)
			{
				Log.info(e);
				e.printStackTrace();
				System.out.println("Failed to verify the Sale Order Number"); 
				
				Report.put("User verifies any sales order number of an asset which does not have data ",
						"User should not see 0 but can see the Not Available given under the sales order# if there is no data",
						"Failed to verify the Sale Order Number", "FAIL");
				Assert.fail("Failed to verify the Sale Order Number");
			}               
		}
		
		public void ClickOnContractsFromLeftMenuInInstallBase(WebDriver driver)
		{

			Log.info("ClickOnContractsFromLeftMenuInInstallBase");	
			WebDriverWait wait = new WebDriverWait(driver, 120);
			String text="";
			String text1="";
			String map="";
			String text2="";
			String defaults="";
			String text3="";
			String text4="";
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			Actions act=new Actions(driver);

			try
			{
				CommonUtility.scrollToViewElement(driver, obj_PortalPage.ContractsOnLeftRailOfInstallBase());
				//			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.IncidentsManagementTab()));
				if(CommonUtility.CheckpresenceofElementLocated(driver, 10, obj_PortalPage.ContractsOnLeftRailOfInstallBase()))
				{
					CommonUtility.scrollToViewElement(driver, obj_PortalPage.ContractsOnLeftRailOfInstallBase());
					text2=CommonUtility.highlightElement(driver, obj_PortalPage.ContractsOnLeftRailOfInstallBase()).getText();
					System.out.println(text2);
					CommonUtility.ClickOn(driver, obj_PortalPage.ContractsOnLeftRailOfInstallBase());
					wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.ContractsAfterClickingOnIt()));


					Report.put("User clicks on Contracts From left menu", 
							"user should be able to click on Contracts from left menu under install base" ,
							"user able click on "+Report.color(text2), "PASS");
				}
				else
				{
					System.out.println("not able to Contracts in left menu");
					Report.put("User clicks on Contracts From left menu", 
							"user should be able to click on Contracts from left menu under install base" ,
							"Failed to see Contracts in left menu", "FAIL");

					Assert.fail();
				}

			}
			catch(Exception e)
			{
				Log.info(e);
				Report.put("User clicks on Contracts From left menu", 
						"user should be able to click on Contracts from left menu under install base" ,
						"Failed to see Contracts in left menu", "FAIL");
				e.printStackTrace();
				Assert.fail();
			}

		} 

		public void ClickOnGraphUnderContractsContext(WebDriver driver)
		{

			Log.info("ClickOnGraphUnderContractsContext");	
			WebDriverWait wait = new WebDriverWait(driver, 120);
			String text="";
			String text1="";
			String map="";
			String text2="";
			String text3="";
			String text4="";
			String text5="";
			String defaults="";
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			Actions act=new Actions(driver);

			try
			{

				if(CommonUtility.CheckpresenceofElementLocated(driver, 10, obj_PortalPage.GraphsButton()))
				{
					CommonUtility.ScrollTo(driver,obj_PortalPage.GraphsButton());
					map=CommonUtility.highlightElement(driver,obj_PortalPage.GraphsButton()).getText();
					System.out.println(map);
					CommonUtility.ClickOn(driver,obj_PortalPage.GraphsButton()); 
					driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
					//					Thread.sleep(10000);
					wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.ContractByProductFamilyHeaderInGraphView()));

					text2=CommonUtility.highlightElement(driver,obj_PortalPage.ContractByProductFamilyHeaderInGraphView()).getText();
					System.out.println("header is "+text2);

					defaults=CommonUtility.highlightElement(driver,obj_PortalPage.ViewByHeaderInGraphView()).getText();
					System.out.println("view by is displayed as  "+defaults);

					String contractcategory=CommonUtility.highlightElement(driver,obj_PortalPage.ContractCategoryInGrahView()).getText();
					System.out.println("contract category not a hyperlink for now  "+contractcategory);

					String productfamily=CommonUtility.highlightElement(driver,obj_PortalPage.ProductFamilyHyperlink()).getText();
					System.out.println("product family is a hyperlink for now  "+productfamily);

					CommonUtility.highlightElement(driver,obj_PortalPage.ColorOfExpiredCategory());

					CommonUtility.highlightElement(driver,obj_PortalPage.ExpiresWithIn30DaysColor());
					CommonUtility.highlightElement(driver,obj_PortalPage.Expires31To90DaysColor());
					CommonUtility.highlightElement(driver,obj_PortalPage.Expires91To180DaysColor());
					CommonUtility.highlightElement(driver,obj_PortalPage.ExpiresBeyond180DaysColor());
					CommonUtility.highlightElement(driver,obj_PortalPage.TerminatedColor());
					CommonUtility.highlightElement(driver,obj_PortalPage.NAColor());



					List<WebElement> list3=driver.findElements(obj_PortalPage.ColorOfCategoryNamesDisplayed());


					for(WebElement lt:list3)
					{

						CommonUtility.scrollToViewElement(driver, lt);

						//							act.moveToElement(CommonUtility.highlightElement(driver, lt)).build().perform();
						CommonUtility.highlightElement(driver, lt);

					}

					List<WebElement> list=driver.findElements(obj_PortalPage.ListOfContractCategoryInGraphView());


					for(WebElement lt:list)
					{

						CommonUtility.scrollToViewElement(driver, lt);

						//							act.moveToElement(CommonUtility.highlightElement(driver, lt)).build().perform();
						CommonUtility.highlightElement(driver, lt);


						text=lt.getText();
						text1+=" <br> "+text;
					}
					System.out.println("list of contract categories are displayed are "+text1);

					Report.put("Click on the Graph button ", 
							"Contracts visualization is displayed by the following Contract Categories:Expired ,Expires within 30 days,Expires in 31-90 days,<br>  Expires in 91-180 days, Expires beyond 180 days, Contract Terminated, N/A" ,
							"User able to see contract categories as "+Report.color(text1), "PASS");

					List<WebElement> list1=driver.findElements(obj_PortalPage.CategoryGraphHeadings());


					for(WebElement lt:list1)
					{
						CommonUtility.scrollToViewElement(driver, lt);

						//							act.moveToElement(CommonUtility.highlightElement(driver, lt)).build().perform();
						CommonUtility.highlightElement(driver, lt);

						text=lt.getText();
						text3+=" <br> "+text;
					}
					System.out.println("categories in graph view displayed as "+text3);
					List<WebElement> list2=driver.findElements(obj_PortalPage.PercentageValuesOfGraphViewOfDifferentCategories());


					for(WebElement lt:list2)
					{
						CommonUtility.scrollToViewElement(driver, lt);

						//							act.moveToElement(CommonUtility.highlightElement(driver, lt)).build().perform();
						CommonUtility.highlightElement(driver, lt);

						text4=lt.getText();
						text5+=" <br> "+text4;
					}

					System.out.println("contract categories type displayed are "+text3+" along with percentage of categories "+text5);

					CommonUtility.CheckpresenceofElementLocated(driver,05,obj_PortalPage.ExpiredCategoryBarInGraphView());

					CommonUtility.CheckpresenceofElementLocated(driver,05,obj_PortalPage.ExpiresWithIn30DaysCategoryBarInGraphView());
					CommonUtility.CheckpresenceofElementLocated(driver,05,obj_PortalPage.Expires31to90DaysCategoryBarInGraphView());
					CommonUtility.CheckpresenceofElementLocated(driver,05,obj_PortalPage.Expires91To180DaysCategoryBarInGraphView());
					CommonUtility.CheckpresenceofElementLocated(driver,05,obj_PortalPage.ExpiresBeyond180DaysCategoryBarInGraphView());
					CommonUtility.CheckpresenceofElementLocated(driver,05,obj_PortalPage.TerminatedBarInGraphView());
					CommonUtility.CheckpresenceofElementLocated(driver,05,obj_PortalPage.NABarInGraphView());

					Report.put("Verify the title and other details of the page", 
							"The title of the page should be displayed as 'Contract Category' <br>- A legend of all the category should be displayed.<br>- Contract category link should be displayed in View By: section should be selected<br>-Contract category should not be displayed in blue hyperlinked text<br>-Product Family link  should be displayed in View By: section as a hyperlink" ,
							"user able to click on "+Report.color(map)+" and able to see heading of "+Report.color(text2)+" and <br> defaulted with "+Report.color(defaults)+" and display "+Report.color(contractcategory+ "and" +productfamily)+" <br> display contract categories type displayed are "+Report.color(text3)+" along with percentage of categories "+Report.color(text5)+" <br> Contract category not displayed in blue hyperlinked text<br>-Product Family link displayed in View By: section as a hyperlink", "PASS");
				}
				else
				{
					System.out.println("not able to see graph icon/hyperlink");
					Report.put("Verify the title and other details of the page", 
							"The title of the page should be displayed as 'Contract Category' <br>- A legend of all the category should be displayed.<br>- Contract category link should be displayed in View By: section should be selected<br>-Contract category should not be displayed in blue hyperlinked text<br>-Product Family link  should be displayed in View By: section as a hyperlink" ,
							"Failed to click on graph", "FAIL");

					Assert.fail();
				}

			}
			catch(Exception e)
			{
				Log.info(e);
				Report.put("Verify the title and other details of the page", 
						"The title of the page should be displayed as 'Contract Category' <br>- A legend of all the category should be displayed.<br>- Contract category link should be displayed in View By: section should be selected<br>-Contract category should not be displayed in blue hyperlinked text<br>-Product Family link  should be displayed in View By: section as a hyperlink" ,
						"Failed to see title and other details on graph view", "FAIL");
				e.printStackTrace();
				Assert.fail();
			}

		} 


		public void ClickOnProductFamilyLink(WebDriver driver)
		{

			Log.info("ClickOnProductFamilyLink");	
			WebDriverWait wait = new WebDriverWait(driver, 120);
			String text="";
			String text1="";
			String map="";
			String text2="";
			String text3="";
			String text4="";
			String text5="";
			String defaults="";
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			Actions act=new Actions(driver);

			try
			{

				if(CommonUtility.CheckpresenceofElementLocated(driver, 10, obj_PortalPage.ProductFamilyHyperlink()))
				{
					CommonUtility.ScrollTo(driver,obj_PortalPage.ProductFamilyHyperlink());
					map=CommonUtility.highlightElement(driver,obj_PortalPage.ProductFamilyHyperlink()).getText();
					System.out.println(map);
					CommonUtility.ClickOn(driver,obj_PortalPage.ProductFamilyHyperlink()); 
					driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
					//					Thread.sleep(10000);
					wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.ListOfContractCategoryInProductFamilyPage()));



					List<WebElement> list=driver.findElements(obj_PortalPage.ListOfContractCategoryInProductFamilyPage());


					for(WebElement lt:list)
					{

						CommonUtility.scrollToViewElement(driver, lt);

						//							act.moveToElement(CommonUtility.highlightElement(driver, lt)).build().perform();
						CommonUtility.highlightElement(driver, lt);


						text=lt.getText();
						text1+=" <br> "+text;
					}
					System.out.println("list of contract categories are displayed are "+text1);

					Report.put("Click on Product Family link in the View by section", 
							"The same legends should be displayed as in Contract Categories as below :Expired ,Expires within 30 days,Expires in 31-90 days,<br>  Expires in 91-180 days, Expires beyond 180 days, Contract Terminated, N/A" ,
							"User able to see click on "+Report.color(map)+"contract categories as "+Report.color(text1), "PASS");


				}
				else
				{
					System.out.println("not able to see product family hyperlink");
					Report.put("Click on Product Family link in the View by section", 
							"The same legends should be displayed as in Contract Categories as below :Expired ,Expires within 30 days,Expires in 31-90 days,<br>  Expires in 91-180 days, Expires beyond 180 days, Contract Terminated, N/A" ,
							"Failed to click on product family hyperlink", "FAIL");

					Assert.fail();
				}

			}
			catch(Exception e)
			{
				Log.info(e);
				Report.put("Click on Product Family link in the View by section", 
						"The same legends should be displayed as in Contract Categories as below :Expired ,Expires within 30 days,Expires in 31-90 days,<br>  Expires in 91-180 days, Expires beyond 180 days, Contract Terminated, N/A" ,
						"Failed to click on product family hyperlink", "FAIL");
				e.printStackTrace();
				Assert.fail();
			}

		} 

		public void ValidateContractByProductFamilyPage(WebDriver driver)
		{

			Log.info("ValidateContractByProductFamilyPage");	
			WebDriverWait wait = new WebDriverWait(driver, 120);
			String text="";
			String text1="";
			String map="";
			String text2="";
			String text3="";
			String text4="";
			String text5="";
			String defaults="";
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			Actions act=new Actions(driver);

			String viewmore="";
			String viewless="";
			try
			{
				CommonUtility.ScrollTo(driver,obj_PortalPage.CountOfBars());
				if(CommonUtility.CheckpresenceofElementLocated(driver, 10, obj_PortalPage.CountOfBars()))
				{
					CommonUtility.ScrollTo(driver,obj_PortalPage.CountOfBars());
					List<WebElement> list=driver.findElements(obj_PortalPage.CountOfBars());
					int count=list.size();
					System.out.println("total number of bars displayed in product family page are "+count);

					for(WebElement lt:list)
					{
						CommonUtility.highlightElement(driver, lt);

						text=lt.getText();
						text1+=" <br> "+text;
					}
					System.out.println("list of categories are displayed are "+text1);

					List<WebElement> list1=driver.findElements(obj_PortalPage.ValuesOfCategoriesInProductFamilyViewFirstBarDisplayed());


					int i1=0;
					for(WebElement lt:list1)
					{
						CommonUtility.highlightElement(driver, lt);

						text2=lt.getText();
						text3+=" <br> "+text2;
						System.out.println(text2);
						//						int i = Integer.valueOf(text2);
						//						System.out.println(i);
						//						i1=i1+i;
						//						System.out.println(i1);
					}

					System.out.println("values displayed for different catagories in first bar are "+text3);

					List<WebElement> list2=driver.findElements(obj_PortalPage.ValuesOfCategoriesInProductFamilyViewSecondBarDisplayed());


					int i2=0;
					for(WebElement lt:list2)
					{
						CommonUtility.highlightElement(driver, lt);

						text4=lt.getText();
						text5+=" <br> "+text4;
						int i = Integer.parseInt(text4);
						System.out.println(i);
						i2=i2+i;

					}
					System.out.println(i2);
					System.out.println("values displayed for different catagories in second bar are "+text5);

					if(i2>i1)
					{
						System.out.println("highest count product family bar not displayed on top ");
						Report.put("Verify the order of product families in the chart", 
								"The product family which has the highest count of assets in each contract category cumulatively is displayed as the first bar chart followed by the next and so on in decreasing order" ,
								"Failed to see highest count product family bar not displayed on top", "FAIL");
						Assert.fail();
					}

					if(count<5)
					{
						CommonUtility.ScrollTo(driver, obj_PortalPage.ViewMoreLink());
						viewmore=CommonUtility.highlightElement(driver, obj_PortalPage.ViewMoreLink()).getText();
						System.out.println(viewmore+" displayed");
						Thread.sleep(3000);
						CommonUtility.ScrollTo(driver, obj_PortalPage.ViewLessLink());
						viewless=CommonUtility.highlightElement(driver, obj_PortalPage.ViewLessLink()).getText();
						System.out.println(viewless+" displayed");

						Report.put("Scroll down the page and check for a View All link if the user has more than 5 product families", 
								"The View All link should be displayed at the bottom only if the  user has more than 5 product families" ,
								"User able to see "+Report.color(viewmore)+" link as total number of product family categories displayed are "+count+" which is more than 5 <br> and clicking on view more display "+Report.color(viewless), "PASS");
					}
					else
					{
						System.out.println("bars displayed are 5 or less than 5");
						Report.put("Scroll down the page and check for a View All link if the user has more than 5 product families", 
								"The View All link should be displayed at the bottom only if the  user has more than 5 product families" ,
								"User not able to see view more link as total number of categories displayed under product familt are "+count+" which is less than or equal to 5", "PASS");
					}

					Report.put("Verify the chart displayed in Contract by Product Family page", 
							"A horizontal stacked chart should be displayed with the stacked values are Contract Categories the bar charts as product families" ,
							"User able to Contract Categories the bar charts with "+Report.color(text1) , "PASS");



					Report.put("Verify the order of product families in the chart", 
							"The product family which has the highest count of assets in each contract category cumulatively is displayed as the first bar chart followed by the next and so on in decreasing order" ,
							"User able to see product families in order where highest count of assets displayed first in the chart like first diaplyes count is "+i1+" is greater than second displayed bar count "+i2, "PASS");


				}
				else
				{
					System.out.println("not able to see any chart displayed in product family");
					Report.put("Verify the chart displayed in Contract by Product Family page", 
							"A horizontal stacked chart should be displayed with the stacked values are Contract Categories the bar charts as product families" ,
							"not able to see any chart displayed in product family", "FAIL");

					Assert.fail();
				}

			}
			catch(Exception e)
			{
				Log.info(e);
				Report.put("Verify the chart displayed in Contract by Product Family page", 
						"A horizontal stacked chart should be displayed with the stacked values are Contract Categories the bar charts as product families" ,
						"not able to see any chart displayed in product family", "FAIL");
				e.printStackTrace();
				Assert.fail();
			}

		} 
		public void ClickOnAnyOfGraphBarAndValidateForExpandViewForIBPageUnderContractsContext(WebDriver driver)
		{

			Log.info("ClickOnAnyOfGraphBarAndValidateForExpandViewForIBPageUnderContractsContext");	
			WebDriverWait wait = new WebDriverWait(driver, 120);
			String displayedvalues="";
			String displayedvalues1="";
			String displayedvalues2="";
			String message="";
			String header="";
			String text3="";
			String text="";
			String text4="";
			int count=0;
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);


			try
			{

				if(CommonUtility.CheckpresenceofElementLocated(driver, 10, obj_PortalPage.ValuesOfCategoriesInProductFamilyViewFirstBarDisplayed()))
				{
					CommonUtility.ScrollTo(driver, obj_PortalPage.ValuesOfCategoriesInProductFamilyViewFirstBarDisplayed());

					List<WebElement> list3=driver.findElements(obj_PortalPage.ValuesOfCategoriesInProductFamilyViewFirstBarDisplayed());


					for(int i=0;i<list3.size();i++)
					{

						CommonUtility.scrollToViewElement(driver, list3.get(i));

						CommonUtility.highlightElement(driver, list3.get(i));


						if(i==0)
						{
							CommonUtility.scrollToViewElement(driver, list3.get(i));

							//						act.moveToElement(CommonUtility.highlightElement(driver, lt)).build().perform();
							CommonUtility.highlightElement(driver, list3.get(i)).click();
						}
					}

					wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.HeaderOfThePopUp()));


					CommonUtility.scrollToViewElement(driver,obj_PortalPage.HeaderOfThePopUp());	
					header=CommonUtility.highlightElement(driver,obj_PortalPage.HeaderOfThePopUp()).getText();
					System.out.println("header is "+header);

					List<WebElement> list4=driver.findElements(obj_PortalPage.BreadScrumbsOnGraphView());


					for(WebElement lt:list4)
					{

						CommonUtility.scrollToViewElement(driver, lt);

						CommonUtility.highlightElement(driver, lt);


						text=lt.getText();
						text4+=" <br> "+text;
					}
					System.out.println("Breadscrumbs are "+text4);

					if(text4.contains("Product Family") && text4.contains("Contract Category"))
					{
						System.out.println("displays filters as expected");
					}
					else
					{
						Report.put("Click on any section of the stacked bar chart for a particular product family ", 
								"The expanded table view with the following filtered items: -product family selected <br>-contract category selected on the stacked chart of the above product family" ,
								"Failed to see expected filters in expanded view", "FAIL");
						Assert.fail();
					}

					if(CommonUtility.CheckpresenceofElementLocated(driver, 15, obj_PortalPage.CountOfRowsDisplayed()))
					{

						List<WebElement> list=driver.findElements(obj_PortalPage.CountOfRowsDisplayed());
						List<WebElement> list1=driver.findElements(obj_PortalPage.RowsDisplayedUnderTable1());
						List<WebElement> list2=driver.findElements(obj_PortalPage.ValuesDisplayedUnderOtherDetailsTable());
						count=list.size();
						System.out.println("count of values displayed are "+count);
						for(WebElement lt:list)
						{
							CommonUtility.highlightElement(driver, lt);
							String tabName=lt.getText();

							System.out.println("Tab is: " +tabName);
							displayedvalues+=" <br> " + tabName;
						}
						System.out.println("Tabs are:"+displayedvalues);


						for(WebElement lt:list1)
						{
							CommonUtility.scrollToViewElement(driver, lt);
							CommonUtility.highlightElement(driver, lt);
							String tabName=lt.getText();

							System.out.println("Tab is: " +tabName);
							displayedvalues1+=" <br> " + tabName;


						}
						System.out.println("Tabs are:"+displayedvalues1);



						for(WebElement lt:list2)
						{
							CommonUtility.highlightElement(driver, lt);
							String tabName=lt.getText();

							System.out.println("Tab is: " +tabName);
							displayedvalues2+=" <br> " + tabName;

						}
						System.out.println("Tabs are:"+displayedvalues2);


					}

					Report.put("Click on any section of the stacked bar chart for a particular product family ", 
							"The expanded table view with the following filtered items: -product family selected <br>-contract category selected on the stacked chart of the above product family" ,
							"able to click on first subbar displayed and expanded view displayed with header "+Report.color(header)+" along with filtered data in the grid of count "+count+" with breadscrumb displays filters as "+Report.color(text4), "PASS");
				}
				else
				{

					Report.put("Click on any section of the stacked bar chart for a particular product family ", 
							"The expanded table view with the following filtered items: -product family selected <br>-contract category selected on the stacked chart of the above product family" ,
							"Failed to see first displayed bar under first product family displayed", "FAIL");

					Assert.fail();
				}

			}
			catch(Exception e)
			{
				Log.info(e);
				Report.put("Click on any section of the stacked bar chart for a particular product family ", 
						"The expanded table view with the following filtered items: -product family selected <br>-contract category selected on the stacked chart of the above product family" ,
						"Failed to click on first subbar under first displayed product family", "FAIL");
				e.printStackTrace();
				Assert.fail();
			}

		} 

		public void ClickOnFirstDisplayedProductFamilyNameAndValidateForExpandViewForIBPageUnderContractsContext(WebDriver driver)
		{

			Log.info("ClickOnFirstDisplayedProductFamilyNameAndValidateForExpandViewForIBPageUnderContractsContext");	
			WebDriverWait wait = new WebDriverWait(driver, 120);
			String displayedvalues="";
			String displayedvalues1="";
			String displayedvalues2="";
			String message="";
			String header="";
			String text3="";
			String text="";
			String text4="";
			int count=0;

			try
			{

				if(CommonUtility.CheckpresenceofElementLocated(driver, 10, obj_PortalPage.FirstProductFamilyName()))
				{

					CommonUtility.scrollToViewElement(driver, obj_PortalPage.FirstProductFamilyName());
					String productname=CommonUtility.highlightElement(driver, obj_PortalPage.FirstProductFamilyName()).getText();
					System.out.println(productname);

					CommonUtility.ClickOn(driver, obj_PortalPage.FirstProductFamilyName());


					wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.HeaderOfThePopUp()));


					CommonUtility.scrollToViewElement(driver,obj_PortalPage.HeaderOfThePopUp());	
					header=CommonUtility.highlightElement(driver,obj_PortalPage.HeaderOfThePopUp()).getText();
					System.out.println("header is "+header);

					List<WebElement> list4=driver.findElements(obj_PortalPage.BreadScrumbsOnGraphView());


					for(WebElement lt:list4)
					{

						CommonUtility.scrollToViewElement(driver, lt);

						CommonUtility.highlightElement(driver, lt);


						text=lt.getText();
						text4+=" <br> "+text;
					}
					System.out.println("Breadscrumbs are "+text4);

					if(text4.contains("Product Family"))
					{
						System.out.println("displays filters as expected");
					}

					if(text4.contains("Contract Category"))
					{
						System.out.println("displayed filters is not as expected");
						Report.put("Click on a particular product family label ", 
								"The expanded view should be displayed with the product family selected" ,
								"Failed to see expected filters applied in expanded view", "FAIL");
						Assert.fail();
					}

					if(CommonUtility.CheckpresenceofElementLocated(driver, 15, obj_PortalPage.CountOfRowsDisplayed()))
					{

						List<WebElement> list=driver.findElements(obj_PortalPage.CountOfRowsDisplayed());
						List<WebElement> list1=driver.findElements(obj_PortalPage.RowsDisplayedUnderTable1());
						List<WebElement> list2=driver.findElements(obj_PortalPage.ValuesDisplayedUnderOtherDetailsTable());
						count=list.size();
						System.out.println("count of values displayed are "+count);
						for(WebElement lt:list)
						{
							CommonUtility.highlightElement(driver, lt);
							String tabName=lt.getText();

							System.out.println("Tab is: " +tabName);
							displayedvalues+=" <br> " + tabName;
						}
						System.out.println("Tabs are:"+displayedvalues);


						for(WebElement lt:list1)
						{
							CommonUtility.scrollToViewElement(driver, lt);
							CommonUtility.highlightElement(driver, lt);
							String tabName=lt.getText();

							System.out.println("Tab is: " +tabName);
							displayedvalues1+=" <br> " + tabName;


						}
						System.out.println("Tabs are:"+displayedvalues1);



						for(WebElement lt:list2)
						{
							CommonUtility.highlightElement(driver, lt);
							String tabName=lt.getText();

							System.out.println("Tab is: " +tabName);
							displayedvalues2+=" <br> " + tabName;

						}
						System.out.println("Tabs are:"+displayedvalues2);


					}

					Report.put("Click on a particular product family label ", 
							"The expanded view should be displayed with the product family selected" ,
							"able to click on first displayed product name and expanded view displayed with header "+Report.color(header)+" along with filtered data in the grid of count "+count+" with breadscrumb displays filters as "+Report.color(text4), "PASS");
				}
				else
				{

					Report.put("Click on a particular product family label ", 
							"The expanded view should be displayed with the product family selected" ,
							"Failed to see first displayed displayed product name", "FAIL");

					Assert.fail();
				}

			}
			catch(Exception e)
			{
				Log.info(e);
				Report.put("Click on a particular product family label ", 
						"The expanded view should be displayed with the product family selected" ,
						"Failed to click on displayed product name", "FAIL");
				e.printStackTrace();
				Assert.fail();
			}

		} 

		public void ClickOnGraphUnderSecurityAdvisoriesContext(WebDriver driver)
		{

			Log.info("ClickOnGraphUnderSecurityAdvisoriesContext");	
			WebDriverWait wait = new WebDriverWait(driver, 120);
			String text="";
			String text1="";
			String map="";
			String text2="";
			String text3="";
			String text4="";
			String text5="";
			String defaults="";
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			Actions act=new Actions(driver);

			try
			{

				if(CommonUtility.CheckpresenceofElementLocated(driver, 10, obj_PortalPage.GraphsButton()))
				{
					CommonUtility.ScrollTo(driver,obj_PortalPage.GraphsButton());
					map=CommonUtility.highlightElement(driver,obj_PortalPage.GraphsButton()).getText();
					System.out.println(map);
					CommonUtility.ClickOn(driver,obj_PortalPage.GraphsButton()); 
					driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
					//					Thread.sleep(10000);
					wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.ContractByProductFamilyHeaderInGraphView()));

					text2=CommonUtility.highlightElement(driver,obj_PortalPage.ContractByProductFamilyHeaderInGraphView()).getText();
					System.out.println("header is "+text2);

					defaults=CommonUtility.highlightElement(driver,obj_PortalPage.ViewByHeaderInGraphView()).getText();
					System.out.println("view by is displayed as  "+defaults);

					String contractcategory=CommonUtility.highlightElement(driver,obj_PortalPage.ContractCategoryInGrahView()).getText();
					System.out.println("contract category not a hyperlink for now  "+contractcategory);

					String productfamily=CommonUtility.highlightElement(driver,obj_PortalPage.ProductFamilyHyperlink()).getText();
					System.out.println("product family is a hyperlink for now  "+productfamily);

					CommonUtility.highlightElement(driver,obj_PortalPage.ColorOfExpiredCategory());

					CommonUtility.highlightElement(driver,obj_PortalPage.ExpiresWithIn30DaysColor());
					CommonUtility.highlightElement(driver,obj_PortalPage.Expires31To90DaysColor());
					CommonUtility.highlightElement(driver,obj_PortalPage.Expires91To180DaysColor());
					CommonUtility.highlightElement(driver,obj_PortalPage.ExpiresBeyond180DaysColor());
					CommonUtility.highlightElement(driver,obj_PortalPage.TerminatedColor());
					CommonUtility.highlightElement(driver,obj_PortalPage.NAColor());



					List<WebElement> list3=driver.findElements(obj_PortalPage.ColorOfCategoryNamesDisplayed());


					for(WebElement lt:list3)
					{

						CommonUtility.scrollToViewElement(driver, lt);

						//							act.moveToElement(CommonUtility.highlightElement(driver, lt)).build().perform();
						CommonUtility.highlightElement(driver, lt);

					}

					List<WebElement> list=driver.findElements(obj_PortalPage.ListOfContractCategoryInGraphView());


					for(WebElement lt:list)
					{

						CommonUtility.scrollToViewElement(driver, lt);

						//							act.moveToElement(CommonUtility.highlightElement(driver, lt)).build().perform();
						CommonUtility.highlightElement(driver, lt);


						text=lt.getText();
						text1+=" <br> "+text;
					}
					System.out.println("list of contract categories are displayed are "+text1);

					Report.put("Click on the Graph button ", 
							"Contracts visualization is displayed by the following Contract Categories:Expired ,Expires within 30 days,Expires in 31-90 days,<br>  Expires in 91-180 days, Expires beyond 180 days, Contract Terminated, N/A" ,
							"User able to see contract categories as "+Report.color(text1), "PASS");

					List<WebElement> list1=driver.findElements(obj_PortalPage.CategoryGraphHeadings());


					for(WebElement lt:list1)
					{
						CommonUtility.scrollToViewElement(driver, lt);

						//							act.moveToElement(CommonUtility.highlightElement(driver, lt)).build().perform();
						CommonUtility.highlightElement(driver, lt);

						text=lt.getText();
						text3+=" <br> "+text;
					}
					System.out.println("categories in graph view displayed as "+text3);
					List<WebElement> list2=driver.findElements(obj_PortalPage.PercentageValuesOfGraphViewOfDifferentCategories());


					for(WebElement lt:list2)
					{
						CommonUtility.scrollToViewElement(driver, lt);

						//							act.moveToElement(CommonUtility.highlightElement(driver, lt)).build().perform();
						CommonUtility.highlightElement(driver, lt);

						text4=lt.getText();
						text5+=" <br> "+text4;
					}

					System.out.println("contract categories type displayed are "+text3+" along with percentage of categories "+text5);

					CommonUtility.CheckpresenceofElementLocated(driver,05,obj_PortalPage.ExpiredCategoryBarInGraphView());

					CommonUtility.CheckpresenceofElementLocated(driver,05,obj_PortalPage.ExpiresWithIn30DaysCategoryBarInGraphView());
					CommonUtility.CheckpresenceofElementLocated(driver,05,obj_PortalPage.Expires31to90DaysCategoryBarInGraphView());
					CommonUtility.CheckpresenceofElementLocated(driver,05,obj_PortalPage.Expires91To180DaysCategoryBarInGraphView());
					CommonUtility.CheckpresenceofElementLocated(driver,05,obj_PortalPage.ExpiresBeyond180DaysCategoryBarInGraphView());
					CommonUtility.CheckpresenceofElementLocated(driver,05,obj_PortalPage.TerminatedBarInGraphView());
					CommonUtility.CheckpresenceofElementLocated(driver,05,obj_PortalPage.NABarInGraphView());

					Report.put("Verify the title and other details of the page", 
							"The title of the page should be displayed as 'Contract Category' <br>- A legend of all the category should be displayed.<br>- Contract category link should be displayed in View By: section should be selected<br>-Contract category should not be displayed in blue hyperlinked text<br>-Product Family link  should be displayed in View By: section as a hyperlink" ,
							"user able to click on "+Report.color(map)+" and able to see heading of "+Report.color(text2)+" and <br> defaulted with "+Report.color(defaults)+" and display "+Report.color(contractcategory+ "and" +productfamily)+" <br> display contract categories type displayed are "+Report.color(text3)+" along with percentage of categories "+Report.color(text5)+" <br> Contract category not displayed in blue hyperlinked text<br>-Product Family link displayed in View By: section as a hyperlink", "PASS");
				}
				else
				{
					System.out.println("not able to see graph icon/hyperlink");
					Report.put("Verify the title and other details of the page", 
							"The title of the page should be displayed as 'Contract Category' <br>- A legend of all the category should be displayed.<br>- Contract category link should be displayed in View By: section should be selected<br>-Contract category should not be displayed in blue hyperlinked text<br>-Product Family link  should be displayed in View By: section as a hyperlink" ,
							"Failed to click on graph", "FAIL");

					Assert.fail();
				}

			}
			catch(Exception e)
			{
				Log.info(e);
				Report.put("Verify the title and other details of the page", 
						"The title of the page should be displayed as 'Contract Category' <br>- A legend of all the category should be displayed.<br>- Contract category link should be displayed in View By: section should be selected<br>-Contract category should not be displayed in blue hyperlinked text<br>-Product Family link  should be displayed in View By: section as a hyperlink" ,
						"Failed to see title and other details on graph view", "FAIL");
				e.printStackTrace();
				Assert.fail();
			}

		} 

		public void ClickOnFilterAndValidateEligibleForConnectivityFilter(WebDriver driver)
		{

			Log.info("ClickOnFilterAndValidateEligibleForConnectivityFilter");	
			WebDriverWait wait = new WebDriverWait(driver, 120);
			String text="";
			String text1="";
			String map="";
			String text2="";
			String defaults="";
			String text3="";
			String text4="";
			String text5="";
			String text6="";
			String text7="";
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			Actions act=new Actions(driver);
			int count;
			String displayedvalues1="";
			String displayedvalues="";
			String displayedvalues2="";

			try
			{

				if(CommonUtility.CheckpresenceofElementLocated(driver, 10, obj_PortalPage.FilterButton()))
				{
					CommonUtility.scrollToViewElement(driver,obj_PortalPage.FilterButton());
					map=CommonUtility.highlightElement(driver,obj_PortalPage.FilterButton()).getText();
					System.out.println(map);
					CommonUtility.highlightElement(driver,obj_PortalPage.FilterButton()).click(); 

					//					wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.FilterByHeader()));
					//					text5=CommonUtility.highlightElement(driver,obj_PortalPage.FilterByHeader()).getText();
					//					System.out.println(text5);
					CommonUtility.scrollToViewElement(driver,obj_PortalPage.EligibleForConnectivityFilterInFilterWindow());
					text2=CommonUtility.highlightElement(driver,obj_PortalPage.EligibleForConnectivityFilterInFilterWindow()).getText();
					System.out.println("Filter is "+text2);


					CommonUtility.ClickOn(driver,obj_PortalPage.EligibleForConnectivityFilterInFilterWindow());

					wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.EligibleForConnectivityHeaderInFilterWindow()));

					List<WebElement> list2=driver.findElements(obj_PortalPage.OptionsUnderEligibleForConnectivityFilter());


					for(WebElement lt:list2)
					{

						CommonUtility.ScrollToWebElement(driver, lt);

						CommonUtility.highlightElement(driver, lt);

						text=lt.getText();
						text4+=" <br> "+text;
					}
					System.out.println("options are "+text4);
				}

				defaults=CommonUtility.highlightElement(driver,obj_PortalPage.DefaultSelectedFilterOptionUnderEligibleForConnectivityFilter()).getText();
				System.out.println("default selected option is "+defaults);



				Report.put("Click on the Filter By button and verify the options for filter 'Eligible for Connectivity'", 
						"The following filter options should be displayed for 'Eligible for Connectivity', All,Eligible,Not Eligible" ,
						"User Able to click on "+Report.color(map)+" and able to click on "+Report.color(text2)+" type of filter and able to see options as "+Report.color(text4), "PASS");

				Report.put("Verify the default values selected within the  filter 'Eligible for Connectivity'", 
						"All option should be the default selected" ,
						"User Able to see defailt selected option is "+Report.color(map), "PASS");

				String noteligible=CommonUtility.highlightElement(driver,obj_PortalPage.NotEligibleOptionUnderEligibleForConnectivityFilter()).getText();
				System.out.println(noteligible);
				CommonUtility.ClickOn(driver,obj_PortalPage.NotEligibleOptionUnderEligibleForConnectivityFilter());

				CommonUtility.scrollToViewElement(driver,obj_PortalPage.ApplySelectedInFilterWindow());
				text3=CommonUtility.highlightElement(driver,obj_PortalPage.ApplySelectedInFilterWindow()).getText();
				System.out.println("text is "+text3);

				CommonUtility.ClickOn(driver,obj_PortalPage.ApplySelectedInFilterWindow());
				CommonUtility.scrollToViewElement(driver,obj_PortalPage.XButtonOnFilterWindow());
				CommonUtility.ClickOn(driver,obj_PortalPage.XButtonOnFilterWindow());



				ClickOnExpandButton(driver);

				List<WebElement> list4=driver.findElements(obj_PortalPage.BreadScrumbsOnGraphView());


				for(WebElement lt:list4)
				{

					CommonUtility.scrollToViewElement(driver, lt);

					CommonUtility.highlightElement(driver, lt);


					text=lt.getText();
					text4+=" <br> "+text;
				}
				System.out.println("Breadscrumbs are "+text4);


				if(text4.contains("Eligible for Connectivity"))
				{
					System.out.println("displayed filters is as expected");
				}
				else
				{
					System.out.println("displayed filters is not as expected");
					Report.put("Click on the Non Managed option in 'Eligible for Code Levels'", 
							"The expanded view should be displayed with the Eligible for Code Levels selected" ,
							"Failed to see expected filters applied in expanded view", "FAIL");
					Assert.fail();
				}


				if(CommonUtility.CheckpresenceofElementLocated(driver, 15, obj_PortalPage.CountOfRowsDisplayed()))
				{

					List<WebElement> list=driver.findElements(obj_PortalPage.CountOfRowsDisplayed());
					List<WebElement> list1=driver.findElements(obj_PortalPage.RowsDisplayedUnderTable1());
					List<WebElement> list2=driver.findElements(obj_PortalPage.ConnectivityStatusInExpandedViewAfterApplyingFilter());
					count=list.size();
					System.out.println("count of values displayed are "+count);
					for(WebElement lt:list)
					{
						CommonUtility.highlightElement(driver, lt);
						String tabName=lt.getText();

						System.out.println("Tab is: " +tabName);
						displayedvalues+=" <br> " + tabName;
					}
					System.out.println("Tabs are:"+displayedvalues);
					try
					{

						for(WebElement lt:list1)
						{

							//						CommonUtility.scrollToViewElement(driver, lt);
							CommonUtility.highlightElement(driver, lt);
							String tabName=lt.getText();

							System.out.println("Tab is: " +tabName);
							displayedvalues1+=" <br> " + tabName;



						}
						System.out.println("Tabs are:"+displayedvalues1);

					}
					catch(Exception e)
					{

					}

					for(WebElement lt:list2)
					{
						CommonUtility.highlightElement(driver, lt);
						String tabName=lt.getText();

						System.out.println("Tab is: " +tabName);
						displayedvalues2+=" <br> " + tabName;

					}
					System.out.println("Tabs are:"+displayedvalues2);

					CommonUtility.scrollToViewElement(driver,obj_PortalPage.XButtonOnExpandedView());
					CommonUtility.ClickOn(driver,obj_PortalPage.XButtonOnExpandedView());


					Report.put("Click on the Not Eligible option in 'Eligible for Connectivity'", 
							"All the assets with the value of Connection Status as Not Eligible should be filtered and displayed" ,
							"User Able to select "+Report.color(noteligible)+" option and all assets of count "+count+" <br> displayed with columns "+Report.color(displayedvalues1)+" and Connection Status displayed as "+Report.color(displayedvalues2), "PASS");
				}

			}
			catch(Exception e)
			{
				Log.info(e);
				Report.put("Click on the Filter By button and verify the options for filter 'Eligible for Connectivity'", 
						"The following filter options should be displayed for 'Eligible for Connectivity', All,Eligible,Not Eligible" ,
						"Failed to see all expected options", "FAIL");
				e.printStackTrace();
				Assert.fail();
			}

		} 

		public void ClickOnFilterAndValidateEligibleForCodeLevelsFilter(WebDriver driver)
		{

			Log.info("ClickOnFilterAndValidateEligibleForCodeLevelsFilter");	
			WebDriverWait wait = new WebDriverWait(driver, 120);
			String text="";
			String text1="";
			String map="";
			String text2="";
			String defaults="";
			String text3="";
			String text4="";
			String text5="";
			String text6="";
			String text7="";
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			Actions act=new Actions(driver);
			int count;
			String displayedvalues1="";
			String displayedvalues="";
			String displayedvalues2="";

			try
			{

				if(CommonUtility.CheckpresenceofElementLocated(driver, 10, obj_PortalPage.FilterButton()))
				{
					CommonUtility.scrollToViewElement(driver,obj_PortalPage.FilterButton());
					map=CommonUtility.highlightElement(driver,obj_PortalPage.FilterButton()).getText();
					System.out.println(map);
					CommonUtility.highlightElement(driver,obj_PortalPage.FilterButton()).click(); 

					//					wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.FilterByHeader()));
					//					text5=CommonUtility.highlightElement(driver,obj_PortalPage.FilterByHeader()).getText();
					//					System.out.println(text5);
					CommonUtility.scrollToViewElement(driver,obj_PortalPage.EligibleForCodeLevelsMgmtFilterInFilterWindow());
					text2=CommonUtility.highlightElement(driver,obj_PortalPage.EligibleForCodeLevelsMgmtFilterInFilterWindow()).getText();
					System.out.println("Filter is "+text2);


					CommonUtility.ClickOn(driver,obj_PortalPage.EligibleForCodeLevelsMgmtFilterInFilterWindow());

					wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.EligibleForConnectivityHeaderInFilterWindow()));

					List<WebElement> list2=driver.findElements(obj_PortalPage.OptionsUnderEligibleForConnectivityFilter());


					for(WebElement lt:list2)
					{

						CommonUtility.ScrollToWebElement(driver, lt);

						CommonUtility.highlightElement(driver, lt);

						text=lt.getText();
						text4+=" <br> "+text;
					}
					System.out.println("options are "+text4);
				}

				defaults=CommonUtility.highlightElement(driver,obj_PortalPage.DefaultSelectedFilterOptionUnderEligibleForConnectivityFilter()).getText();
				System.out.println("default selected option is "+defaults);



				Report.put("Click on the Filter By button and verify the options for filter 'Eligible for Code Levels'", 
						"The following filter options should be displayed for 'Eligible for Code Levels', All,Managed,Non Managed" ,
						"User Able to click on "+Report.color(map)+" and able to click on "+Report.color(text2)+" type of filter and able to see options as "+Report.color(text4), "PASS");

				Report.put("Verify the default values selected within the  filter 'Eligible for code levels'", 
						"All option should be the default selected" ,
						"User Able to see default selected option is "+Report.color(map), "PASS");

				String noteligible=CommonUtility.highlightElement(driver,obj_PortalPage.NonManagedOptionsUnderEligibleForCodeLevelsMgmtFilter()).getText();
				System.out.println(noteligible);
				CommonUtility.ClickOn(driver,obj_PortalPage.NonManagedOptionsUnderEligibleForCodeLevelsMgmtFilter());

				CommonUtility.scrollToViewElement(driver,obj_PortalPage.ApplySelectedInFilterWindow());
				text3=CommonUtility.highlightElement(driver,obj_PortalPage.ApplySelectedInFilterWindow()).getText();
				System.out.println("text is "+text3);

				CommonUtility.ClickOn(driver,obj_PortalPage.ApplySelectedInFilterWindow());
				CommonUtility.scrollToViewElement(driver,obj_PortalPage.XButtonOnFilterWindow());
				CommonUtility.ClickOn(driver,obj_PortalPage.XButtonOnFilterWindow());



				ClickOnExpandButton(driver);

				List<WebElement> list4=driver.findElements(obj_PortalPage.BreadScrumbsOnGraphView());


				for(WebElement lt:list4)
				{

					CommonUtility.scrollToViewElement(driver, lt);

					CommonUtility.highlightElement(driver, lt);


					text=lt.getText();
					text4+=" <br> "+text;
				}
				System.out.println("Breadscrumbs are "+text4);


				if(text4.contains("Eligible for Code Levels"))
				{
					System.out.println("displayed filters is as expected");
				}
				else
				{
					System.out.println("displayed filters is not as expected");
					Report.put("Click on the Not Eligible option in 'Eligible for Code Levels'", 
							"All the assets with the value ofclItemNumber as null should be displayed should be filtered and displayed" ,
							"Failed to see expected filters applied in expanded view", "FAIL");
					Assert.fail();
				}


				if(CommonUtility.CheckpresenceofElementLocated(driver, 15, obj_PortalPage.CountOfRowsDisplayed()))
				{

					List<WebElement> list=driver.findElements(obj_PortalPage.CountOfRowsDisplayed());
					List<WebElement> list1=driver.findElements(obj_PortalPage.RowsDisplayedUnderTable1());
					//					List<WebElement> list2=driver.findElements(obj_PortalPage.ConnectivityStatusInExpandedViewAfterApplyingFilter());
					count=list.size();
					System.out.println("count of values displayed are "+count);
					for(WebElement lt:list)
					{
						CommonUtility.highlightElement(driver, lt);
						String tabName=lt.getText();

						System.out.println("Tab is: " +tabName);
						displayedvalues+=" <br> " + tabName;
					}
					System.out.println("Tabs are:"+displayedvalues);


					for(WebElement lt:list1)
					{
						CommonUtility.scrollToViewElement(driver, lt);
						CommonUtility.highlightElement(driver, lt);
						String tabName=lt.getText();

						System.out.println("Tab is: " +tabName);
						displayedvalues1+=" <br> " + tabName;


					}
					System.out.println("Tabs are:"+displayedvalues1);



					//					for(WebElement lt:list2)
					//					{
					//						CommonUtility.highlightElement(driver, lt);
					//						String tabName=lt.getText();
					//
					//						System.out.println("Tab is: " +tabName);
					//						displayedvalues2+=" <br> " + tabName;
					//
					//					}
					//					System.out.println("Tabs are:"+displayedvalues2);

					Report.put("Click on the Non Managed option in 'Eligible for Code Levels'", 
							"All the assets with the value of Connection Status as Non Managed should be filtered and displayed" ,
							"User Able to select "+Report.color(noteligible)+" option and all assets of count "+count+" <br> displayed with columns "+Report.color(displayedvalues1), "PASS");
				}

			}
			catch(Exception e)
			{
				Log.info(e);
				Report.put("Click on the Filter By button and verify the options for filter 'Eligible for Code Levels'", 
						"The following filter options should be displayed for 'Eligible for Code Levels', All,Managed,Non Managed" ,
						"Failed to see all expected options", "FAIL");
				e.printStackTrace();
				Assert.fail();
			}

		} 


		public void ValidateFooterSectionInAllTabsOfPortalView(WebDriver driver)
		{

			Log.info("Entering method ValidateFooterSectionInAllTabsOfPortalView");	
			WebDriverWait wait = new WebDriverWait(driver, 120);
			String text="";
			String text1="";
			String map="";
			String text2="";
			String defaults="";
			String text3="";
			String text4="";
			String text5="";
			String country="";
			String country1="";
			String country2="";
			String country3="";
			String tab="";
			String tab1="";
			String tab2="";
			String tab3="";
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);

			try
			{
				if(CommonUtility.CheckpresenceofElementLocated(driver, 100, obj_PortalPage.TabsOnPortalView()))
				{
					try
					{

						List<WebElement> list=driver.findElements(obj_PortalPage.TabsOnPortalView());


						for(WebElement lt:list)
						{
							CommonUtility.scrollToViewElement(driver, lt);
							CommonUtility.highlightElement(driver, lt);
							text=lt.getText();
							text1+=" <br> "+text;
						}
						System.out.println("tabs are "+text1);
					}
					catch(Exception e)
					{
						System.out.println(e);
					}

					try
					{
						Thread.sleep(3000);
						CommonUtility.scrollToViewElement(driver,obj_PortalPage.SummaryTab());
						tab=CommonUtility.highlightElement(driver,obj_PortalPage.SummaryTab()).getText();
						CommonUtility.highlightElement(driver,obj_PortalPage.SummaryTab()).click();
						if(CommonUtility.CheckpresenceofElementLocated(driver, 10, obj_PortalPage.FooterLinks()))
						{
							CommonUtility.scrollToViewElement(driver,obj_PortalPage.FooterLinks());
							List<WebElement> list1=driver.findElements(obj_PortalPage.FooterLinks());


							for(WebElement lt:list1)
							{
								CommonUtility.scrollToViewElement(driver, lt);
								CommonUtility.highlightElement(driver, lt);
								text=lt.getText();
								text2+=" <br> "+text;
							}
							System.out.println("links in footer are "+text2);
							CommonUtility.scrollToViewElement(driver,obj_PortalPage.CountrySelector());
							country=CommonUtility.highlightElement(driver,obj_PortalPage.CountrySelector()).getText();
							System.out.println(country);

						}
						else
						{
							System.out.println("footer not present for summary tab");
							Report.put("User verifies that a common footer displaying at the bottom of all the pages: <br>Summary,H&R ,Install Base,Incident Management", 
									"A Common Footer should be displayed across all the pages in account management" ,
									"Failed to footer links for summary tab ", "FAIL");
							Assert.fail();
						}
					}
					catch(Exception e)
					{

					}


					try
					{

						CommonUtility.scrollToViewElement(driver,obj_PortalPage.healthAndRiskTab());
						tab1=CommonUtility.highlightElement(driver,obj_PortalPage.healthAndRiskTab()).getText();
						CommonUtility.highlightElement(driver,obj_PortalPage.healthAndRiskTab()).click();
						if(CommonUtility.CheckpresenceofElementLocated(driver, 10, obj_PortalPage.FooterLinks()))
						{
							CommonUtility.scrollToViewElement(driver,obj_PortalPage.FooterLinks());
							List<WebElement> list1=driver.findElements(obj_PortalPage.FooterLinks());


							for(WebElement lt:list1)
							{
								CommonUtility.scrollToViewElement(driver, lt);
								CommonUtility.highlightElement(driver, lt);
								String tex=lt.getText();
								text3+=" <br> "+tex;
							}
							System.out.println("links in footer are "+text3);
							CommonUtility.scrollToViewElement(driver,obj_PortalPage.CountrySelector());
							country1=CommonUtility.highlightElement(driver,obj_PortalPage.CountrySelector()).getText();
							System.out.println(country1);

						}
						else
						{
							System.out.println("footer not present for Health and Risk tab");
							Report.put("User verifies that a common footer displaying at the bottom of all the pages: <br>Summary,H&R ,Install Base,Incident Management", 
									"A Common Footer should be displayed across all the pages in account management" ,
									"Failed to footer links for Health and Risk tab ", "FAIL");

							Assert.fail();
						}
					}
					catch(Exception e)
					{

					}


					try
					{
						Thread.sleep(5000);
						try
						{
							CommonUtility.ScrollTo(driver,obj_PortalPage.InstallBaseTab());
							tab2=CommonUtility.highlightElement(driver,obj_PortalPage.InstallBaseTab()).getText();
							CommonUtility.highlightElement(driver,obj_PortalPage.InstallBaseTab()).click();
						}
						catch(Exception e)
						{
							System.out.println(e);
						}
						if(CommonUtility.CheckpresenceofElementLocated(driver, 10, obj_PortalPage.FooterLinks()))
						{
							CommonUtility.scrollToViewElement(driver,obj_PortalPage.FooterLinks());
							List<WebElement> list1=driver.findElements(obj_PortalPage.FooterLinks());


							for(WebElement lt:list1)
							{
								CommonUtility.scrollToViewElement(driver, lt);
								CommonUtility.highlightElement(driver, lt);
								String xt=lt.getText();
								text4+=" <br> "+xt;
							}
							System.out.println("links in footer are "+text4);
							CommonUtility.scrollToViewElement(driver,obj_PortalPage.CountrySelector());
							country2=CommonUtility.highlightElement(driver,obj_PortalPage.CountrySelector()).getText();
							System.out.println(country2);

						}
						else
						{
							System.out.println("footer not present for Install base tab");
							Report.put("User verifies that a common footer displaying at the bottom of all the pages: <br>Summary,H&R ,Install Base,Incident Management", 
									"A Common Footer should be displayed across all the pages in account management" ,
									"Failed to footer links for Install base tab ", "FAIL");
							Assert.fail();
						}

					}
					catch(Exception e)
					{

					}

					try
					{
						Thread.sleep(3000);
						CommonUtility.scrollToViewElement(driver,obj_PortalPage.IncidentsManagementTab());
						tab3=CommonUtility.highlightElement(driver,obj_PortalPage.IncidentsManagementTab()).getText();
						CommonUtility.highlightElement(driver,obj_PortalPage.IncidentsManagementTab()).click();
						if(CommonUtility.CheckpresenceofElementLocated(driver, 10, obj_PortalPage.FooterLinks()))
						{
							CommonUtility.scrollToViewElement(driver,obj_PortalPage.FooterLinks());
							List<WebElement> list1=driver.findElements(obj_PortalPage.FooterLinks());


							for(WebElement lt:list1)
							{
								CommonUtility.scrollToViewElement(driver, lt);
								CommonUtility.highlightElement(driver, lt);
								String ex=lt.getText();
								text5+=" <br> "+ex;
							}
							System.out.println("links in footer are "+text5);
							CommonUtility.scrollToViewElement(driver,obj_PortalPage.CountrySelector());
							country3=CommonUtility.highlightElement(driver,obj_PortalPage.CountrySelector()).getText();
							System.out.println(country3);

						}
						else
						{
							System.out.println("footer not present for Incident management tab");
							Report.put("User verifies that a common footer displaying at the bottom of all the pages: <br>Summary,H&R ,Install Base,Incident Management", 
									"A Common Footer should be displayed across all the pages in account management" ,
									"Failed to footer links for Incident management tab ", "FAIL");
							Assert.fail();
						}
					}
					catch(Exception e)
					{

					}




					Report.put("User verifies that a common footer displaying at the bottom of all the pages: <br>Summary,H&R ,Install Base,Incident Management", 
							"A Common Footer should be displayed across all the pages in account management" ,
							"user able to see footer as "+Report.color(text2+"<br>"+country)+" for "+Report.color(tab)+" tab <bt> and for tab "+Report.color(tab1)+" tab able to see footer as "+Report.color(text3+"<br>"+country1)+" <br> and for tab "+Report.color(tab2)+" able to see footer with links "+Report.color(text4+"<br>"+country2)+" anf for tab "+Report.color(tab3)+" able to see footer with links "+Report.color(text5+"<br>"+country3), "PASS");
				}
				else
				{
					System.out.println("not able to see tabs");
					Report.put("system display  tabs:Summary,HEALTH & RISK,INSTALL BASE,INCIDENT MANAGEMENT", 
							"user  should be able to view the tabs:Summary,HEALTH & RISK,INSTALL BASE,INCIDENT MANAGEMENT" ,
							"Failed to see tabs", "FAIL");

					Assert.fail();
				}

			}
			catch(Exception e)
			{
				Log.info(e);
				Report.put("User verifies that a common footer displaying at the bottom of all the pages: <br>Summary,H&R ,Install Base,Incident Management", 
						"A Common Footer should be displayed across all the pages in account management" ,
						"Failed to see tabs in account management", "FAIL");
				e.printStackTrace();
				Assert.fail();
			}

		} 

		public void ValidateWindowPoPUpWitMArketingMessageAboutNewPortalExperience(WebDriver driver)
		{

			Log.info("ValidateWindowPoPUpWitMArketingMessageAboutNewPortalExperience");	
			WebDriverWait wait = new WebDriverWait(driver, 120);
			String text="";
			String url="";
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);

			try
			{
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.WindowPopUpWithMarketingMessage()));
				CommonUtility.scrollToViewElement(driver,obj_PortalPage.WindowPopUpWithMarketingMessage());
				text=CommonUtility.highlightElement(driver,obj_PortalPage.IncidentsManagementTab()).getText();
				System.out.println("header of popup is "+text);

				Report.put("User verifies a modal window popping up with the marketing message about the new portal experience", 
						"User should see a modal window popping up with the marketing message about the new portal experience" ,
						"user able to see window pop up with marketing message about the new portal experience with header "+Report.color(text), "PASS");


				url= driver.getCurrentUrl();

				if(url.contains("https://www.dell.com/support/myservice360/us/en/04/summary"))
				{
					Report.put("Also if user tries to login to portal link", 
							"Users should be auto redirected to the below new portal page https://www.dell.com/support/myservice360/us/en/04/summary" ,
							"User able to see url displayed is "+Report.color(url), "PASS");
				}
				else
				{
					Report.put("Also if user tries to login to portal link", 
							"Users should be auto redirected to the below new portal page https://www.dell.com/support/myservice360/us/en/04/summary" ,
							"Failed to see expected landing url", "FAIL");

					Assert.fail();
				}

			}
			catch(Exception e)
			{
				Log.info(e);
				Report.put("User verifies a modal window popping up with the marketing message about the new portal experience", 
						"User should see a modal window popping up with the marketing message about the new portal experience" ,
						"Failed to see window pop up with with the marketing message about the new portal experience", "FAIL");
				e.printStackTrace();
				Assert.fail();
			}

		} 

		public void ValidateTotalAssetsCircleInHUD(WebDriver driver)
		{

			Log.info("Entering ValidateTotalAssetsCircleInHUD");	
			WebDriverWait wait = new WebDriverWait(driver, 120);
			String text="";
			String text1="";
			String text2="";
			String text3="";

			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);

			try
			{

				//			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.TotalSRsCircleOnHUDAfterUnderIMTabsDefaultView()));
				if(CommonUtility.CheckpresenceofElementLocated(driver, 10, obj_PortalPage.AssetsCircleOnHUDForIBContextAfterSelectingAssetsFromIBGrid()))
				{
					Thread.sleep(7000);
					CommonUtility.scrollToViewElement(driver,obj_PortalPage.AssetsCircleOnHUDForIBContextAfterSelectingAssetsFromIBGrid());
					CommonUtility.highlightElement(driver,obj_PortalPage.AssetsCircleOnHUDForIBContextAfterSelectingAssetsFromIBGrid());

					CommonUtility.scrollToViewElement(driver,obj_PortalPage.NameDisplayedINKPIForINstallBaseByDefault());
					text=CommonUtility.highlightElement(driver,obj_PortalPage.NameDisplayedINKPIForINstallBaseByDefault()).getText(); 
					System.out.println("value displayed by total  "+text);

					CommonUtility.scrollToViewElement(driver,obj_PortalPage.ValueDisplayedINKPIForINstallBaseByDefault());
					text1=CommonUtility.highlightElement(driver,obj_PortalPage.ValueDisplayedINKPIForINstallBaseByDefault()).getText(); 
					System.out.println("value displayed by total  "+text1);

					System.out.println("text displayed in HUD under IB tab total Assets context are "+text1+" "+text);

					Report.put("Verify the KPI displayed at the top", 
							"The  KPI for Total Assets should be displayed as the primary KPI" ,
							"User able to see circle highlighted and displayed Total Assets as "+text1+" "+text, "PASS");

					CommonUtility.scrollToViewElement(driver,obj_PortalPage.HardwareAssetsDisplayedInHUD());
					String hardware=CommonUtility.highlightElement(driver,obj_PortalPage.HardwareAssetsDisplayedInHUD()).getAttribute("value"); 
					System.out.println("number of hardware number of assets displayed are "+hardware);

					CommonUtility.scrollToViewElement(driver,obj_PortalPage.SoftwareAssetsDisplayedInHUD());
					String software=CommonUtility.highlightElement(driver,obj_PortalPage.SoftwareAssetsDisplayedInHUD()).getAttribute("value"); 
					System.out.println("number of software number of assets displayed are  "+software);


					Report.put("Verify the data arcs displayed in the KPI", 
							"All the data arcs (Hardware + Software) are displayed in highlighted blue color at all times" ,
							"User able to see arcs of hardware number of assets "+Report.color(hardware)+" and arcs of software number of assets"+Report.color(software)+" and displayed in highlighted blue color at all times", "PASS");
				}

				else
				{
					System.out.println("not able to see Expected circle in HUD");
					Report.put("Verify the KPI displayed at the top", 
							"The  KPI for Total Assets should be displayed as the primary KPI" ,
							"Failed to see Expected circle in HUD ", "FAIL");

					Assert.fail();
				}

			}
			catch(Exception e)
			{
				Log.info(e);
				System.out.println("not able to see Expected circle in HUD");
				Report.put("Verify the KPI displayed at the top", 
						"The  KPI for Total Assets should be displayed as the primary KPI" ,
						"Failed to see Expected circle in HUD ", "FAIL");
				e.printStackTrace();
				Assert.fail();
			}

		} 

		public void ValidateOpenSRsCircleInHUD(WebDriver driver)
		{

			Log.info("Entering ValidateOpenSRsCircleInHUD");	
			WebDriverWait wait = new WebDriverWait(driver, 120);
			String text="";
			String text1="";
			String text2="";
			String text3="";

//			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);

			try
			{
				CommonUtility.ScrollTo(driver,obj_PortalPage.TotalSRsCircleOnHUDAfterUnderIMTabsDefaultView());
				
				if(CommonUtility.CheckpresenceofElementLocated(driver, 33, obj_PortalPage.TotalSRsCircleOnHUDAfterUnderIMTabsDefaultView()))
				{
					
					CommonUtility.ScrollTo(driver,obj_PortalPage.TotalSRsCircleOnHUDAfterUnderIMTabsDefaultView());
					CommonUtility.highlightElement(driver,obj_PortalPage.TotalSRsCircleOnHUDAfterUnderIMTabsDefaultView());

					CommonUtility.ScrollTo(driver,obj_PortalPage.NameDisplayedINKPIForIncidentManagementByDefault());
					text2=CommonUtility.highlightElement(driver,obj_PortalPage.NameDisplayedINKPIForIncidentManagementByDefault()).getText(); 
					System.out.println("value displayed by total  "+text2);

					CommonUtility.ScrollTo(driver,obj_PortalPage.ValueDisplayedINKPIForIncidentManagementByDefault());
					text3=CommonUtility.highlightElement(driver,obj_PortalPage.ValueDisplayedINKPIForIncidentManagementByDefault()).getText(); 
					System.out.println("value displayed by total  "+text3);

					System.out.println("text displayed in HUD under IM tab total SRs context are "+text3+" "+text2);

					Report.put("Verify the KPI displayed at the top", 
							"The KPI for open SRs displayed as the primary KPI" ,
							"User able to see circle highlighted and displayed open SRs as "+text3+" "+text2, "PASS");

					}
				else 
					CommonUtility.ScrollTo(driver,obj_PortalPage.TotalSRsCircleOnHUDAfterUnderIMTabsDefaultView_IE());
				
					if(CommonUtility.CheckpresenceofElementLocated(driver, 33, obj_PortalPage.TotalSRsCircleOnHUDAfterUnderIMTabsDefaultView_IE()))
					{
						
						CommonUtility.ScrollTo(driver,obj_PortalPage.TotalSRsCircleOnHUDAfterUnderIMTabsDefaultView_IE());
						CommonUtility.highlightElement(driver,obj_PortalPage.TotalSRsCircleOnHUDAfterUnderIMTabsDefaultView_IE());

						Thread.sleep(6000);
						CommonUtility.ScrollTo(driver,obj_PortalPage.NameDisplayedINKPIForIncidentManagementByDefault_IE());
						text2=CommonUtility.highlightElement(driver,obj_PortalPage.NameDisplayedINKPIForIncidentManagementByDefault_IE()).getText(); 
						System.out.println("value displayed by total  "+text2);
						Thread.sleep(6000);
						CommonUtility.ScrollTo(driver,obj_PortalPage.ValueDisplayedINKPIForIncidentManagementByDefault_IE());
						text3=CommonUtility.highlightElement(driver,obj_PortalPage.ValueDisplayedINKPIForIncidentManagementByDefault_IE()).getText(); 
						System.out.println("value displayed by total  "+text3);

						System.out.println("text displayed in HUD under IM tab total SRs context are "+text3+" "+text2);

						Report.put("Verify the KPI displayed at the top", 
								"The KPI for Open SRs displayed as the primary KPI" ,
								"User able to see circle highlighted and displayed open SRs as "+text3+" "+text2, "PASS");

					}
				
				else 
				{
					System.out.println("not able to see Expected circle in HUD");
					Report.put("Verify the KPI displayed at the top", 
							"The KPI for open SRs displayed as the primary KPI" ,
							"Failed to to see Expected circle in HUD ", "FAIL");

					Assert.fail();
				}

			}
			catch(Exception e)
			{
				Log.info(e);
				System.out.println("not able to see Expected circle in HUD");
				Report.put("Verify the KPI displayed at the top", 
						"The KPI for open SRs displayed as the primary KPI" ,
						"Failed to to see Expected circle in HUD ", "FAIL");
				e.printStackTrace();
				Assert.fail();
			}

		} 
		
		public void clickAdvisoryCheckboxWithStatusNewAndClickReview(WebDriver driver)
		{
			System.out.println("Inside clickAdvisoryCheckboxWithStatusNewAndClickReview method");
			Log.info("Inside clickAdvisoryCheckboxWithStatusNewAndClickReview method");

			try
			{
				WebDriverWait wait = new WebDriverWait(driver, 120);

				CommonUtility.ClickOn(driver,obj_PortalPage.incidentManagementSummaryViewFilterButton());

				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.incidentManagementFilterByPopupHeader()));

				CommonUtility.highlightElement(driver,obj_PortalPage.incidentManagementFilterByPopupHeader());

				CommonUtility.ClickOn(driver,obj_PortalPage.incidentManagementFilterByPopupClearAllButton());

				CommonUtility.ClickOn(driver,obj_PortalPage.remediationStatusFilter());

				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.remediationStatusHeader()));

				CommonUtility.ClickOn(driver,obj_PortalPage.remediationStatusNew());

				CommonUtility.ClickOn(driver,obj_PortalPage.incidentManagementFilterByPopupApplySelectedButton());
				CommonUtility.ClickOn(driver,obj_PortalPage.incidentManagementFilterByPopupCloseButton());

				Thread.sleep(5000);
				CommonUtility.ClickOn(driver,obj_PortalPage.advisoryCheckboxFirstRow());

				Thread.sleep(3000);

				CommonUtility.ClickOn(driver,(obj_PortalPage.advisoryReviewButton()));

				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.advisoryReviewedPopupHeader()));	

				if(CommonUtility.CheckpresenceofElementLocated(driver, 10, obj_PortalPage.advisoryReviewedPopupHeader()))
				{
					Report.put("User selects some New/Updated advisories checkbox from the security advisory  and clicks on the Reviewed button",
							"Multi select modal window should be displayed",
							"MultiSelect modal window displayed", "PASS");
				}
				else
				{
					Report.put("User selects some New/Updated advisories checkbox from the security advisory  and clicks on the Reviewed button",
							"Multi select modal window should be displayed",
							"Failed to verify MultiSelect modal window displayed ", "FAIL");
					Assert.fail("Failed to verify MultiSelect modal window displayed ");
				}
			} 
			catch(Exception e)
			{
				e.printStackTrace();
				Report.put("User selects some New/Updated advisories checkbox from the security advisory  and clicks on the Reviewed button",
						"Multi select modal window should be displayed",
						"Failed to verify MultiSelect modal window displayed ", "FAIL");
				Assert.fail("Failed to verify MultiSelect modal window displayed ");
			}
		}
		
		public void hoverOverAdvisoryAmerRegionArcCritical(WebDriver driver)
		{
			System.out.println("Inside hoverOverAdvisoryAmerRegionArcCritical method");
			Log.info("Inside hoverOverAdvisoryAmerRegionArcCritical method");

			String textList = "";
			try
			{
				WebDriverWait wait = new WebDriverWait(driver, 120);
				
				Actions act = new Actions(driver);
				act.moveToElement(CommonUtility.highlightElement(driver, obj_PortalPage.advisoryAmerRegionArcCritical())).build().perform();
						
				System.out.println("Highlighted Arc with Severity Critical ");
							
				
				Report.put("User hover over on one of the segment",
					"It should highlight the severity of that particular segment",
					"Highlighted Arc with Severity Critical ", "PASS");
			} 
			catch(Exception e)
			{
				e.printStackTrace();
				Report.put("User hover over on one of the segment",
						"It should highlight the severity of that particular segment",
						"Failed to highlight Arc with Severity Critical", "FAIL");
				Assert.fail("Failed to highlight Arc with Severity Critical");
			}
		}
		
		public void verifySeverityTableAllRegions(WebDriver driver)
		{
			System.out.println("Inside verifySeverityTableAllRegions method");
			Log.info("Inside verifySeverityTableAllRegions method");

			
			String severityList = "";
			try
			{
				WebDriverWait wait = new WebDriverWait(driver, 120);
				
				CommonUtility.ScrollTo(driver,(obj_PortalPage.severityListAllRegions()));
				
				List<WebElement> list=driver.findElements(obj_PortalPage.severityListAllRegions());

				for(WebElement lt:list)
				{
					String val=lt.getText();
					if(!(val.isEmpty()))
					{
						System.out.println("Value is: " +val);
						severityList+=" <br> " + val;
					}
				}
				System.out.println("List Values are:"+severityList);
				
					Report.put("User verifies a severity table on the left hand side of the Regional Impact donut charts",
							"User should be able to see a severity table at Left hand side with below options and the color of each field should match to the chart Critical, High, Medium, Low",
							"Displayed Severity Table on the left & the values are "+Report.color(severityList), "PASS");
			} 
			catch(Exception e)
			{
				e.printStackTrace();
				Report.put("User verifies a severity table on the left hand side of the Regional Impact donut charts",
						"User should be able to see a severity table at Left hand side with below options and the color of each field should match to the chart Critical, High, Medium, Low",
						"Failed to display Severity Table on the left", "FAIL");
				Assert.fail();
			}
		}
		
		public void verifyRegionalImpactChartTabs(WebDriver driver)
		{
			System.out.println("Inside verifyRegionalImpactChartTabs method");
			Log.info("Inside verifyRegionalImpactChartTabs method");

			String pendingTab = "";
			String completedTab = "";
			try
			{		

				if(CommonUtility.CheckpresenceofElementLocated(driver, 30, obj_PortalPage.pendingAdvisoriesTab()) && CommonUtility.CheckpresenceofElementLocated(driver, 30, obj_PortalPage.completedAdvisoriesTab()))
				{
					pendingTab = CommonUtility.highlightElement(driver,obj_PortalPage.pendingAdvisoriesTab()).getText();

					completedTab = CommonUtility.highlightElement(driver,obj_PortalPage.completedAdvisoriesTab()).getText();
					
					System.out.println("pendingTab text is: "+pendingTab);
					
					System.out.println("completedTab text is: "+completedTab);


					Report.put("User verifies Pending Advisories, Completed Advisories tabs are present with the Regional Impact charts",
	    					"User should be able to see the page size selector option at bottom right ",
							"Displaying Regional Impact charts with tabs "+Report.color(pendingTab)+Report.color(completedTab), "PASS");	
				}
				else
				{
					System.out.println("Failed to display Pending Advisories, Completed Advisories tabs");

					Report.put("User verifies Pending Advisories, Completed Advisories tabs are present with the Regional Impact charts",
	    					"User should be able to see the page size selector option at bottom right ",
							"Failed to display Pending Advisories, Completed Advisories tabs", "FAIL");						
					Assert.fail();
				}
			} 
			catch(Exception e)
			{
				e.printStackTrace();

				System.out.println("Failed to display Pending Advisories, Completed Advisories tabs");

				Report.put("User verifies Pending Advisories, Completed Advisories tabs are present with the Regional Impact charts",
    					"User should be able to see the page size selector option at bottom right ",
						"Failed to display Pending Advisories, Completed Advisories tabs", "FAIL");						
				Assert.fail();
			}
		}
		
		public void clickAdvisoryAmerRegionArcCritical(WebDriver driver)
		{
			System.out.println("Inside clickAdvisoryAmerRegionArcCritical method");
			Log.info("Inside clickAdvisoryAmerRegionArcCritical method");

			String severityValue = "";
			try
			{
				WebDriverWait wait = new WebDriverWait(driver, 120);
				
				CommonUtility.ScrollTo(driver, obj_PortalPage.advisoryAmerRegionArcCritical());
				CommonUtility.ClickOn(driver, obj_PortalPage.advisoryAmerRegionArcCritical());
						
				System.out.println("Clicked on Arc with Severity Critical ");
				
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.technicalAdvisoryGraphRegionPopupHeader()));	
				
				CommonUtility.highlightElement(driver,obj_PortalPage.severityColumnHeading());


					severityValue = CommonUtility.highlightElement(driver,obj_PortalPage.severityColumnFirstRowValue()).getText();
					
					System.out.println("Severity Value is: "+severityValue);
					
				Report.put("User clicks on any Segment on the chart",
					"It should navigate to the expanded version with pre selected filters present in the data showing (If User has clicked on Critical severity from the chart, it should show the Advisory Ids with Critical Severity only)",
					"Clicked on Arc with Severity"+Report.color(severityValue)+"and displayed Advisories with Critical Severity only", "PASS");
			} 
			catch(Exception e)
			{
				e.printStackTrace();
				Report.put("User clicks on any Segment on the chart",
						"It should navigate to the expanded version with pre selected filters present in the data showing (If User has clicked on Critical severity from the chart, it should show the Advisory Ids with Critical Severity only)",
						"Failed to click Arc with Severity Critical", "FAIL");
				Assert.fail("Failed to click Arc with Severity Critical");
			}
		}
		
		
		public void verifyAdvisoryStatusColumnPendingAndHUD(WebDriver driver)
		{
			System.out.println("Inside verifyAdvisoryStatusColumnPendingAndHUD method");
			Log.info("Inside verifyAdvisoryStatusColumnPendingAndHUD method");
			
			String hudText = "";
			String hudValue = "";
			String status = "";
			try
			{
				WebDriverWait wait = new WebDriverWait(driver, 120);

				CommonUtility.highlightElement(driver,(obj_PortalPage.advisoryStatusValueFirstRow()));
				status = CommonUtility.highlightElement(driver,obj_PortalPage.advisoryStatusValueFirstRow()).getText();

				if((status.equalsIgnoreCase("Work In Progress")) || (status.equalsIgnoreCase("Reviewed")) || (status.equalsIgnoreCase("New")))
				{
					System.out.println("Displayed status "+status);	
					
					hudValue = CommonUtility.highlightElement(driver,obj_PortalPage.securityAdvisoryHUDTextValue()).getText();
					System.out.println("Displayed hudValue "+hudValue);	

					hudText = CommonUtility.highlightElement(driver,obj_PortalPage.securityAdvisoryHUDTextName()).getText();
					System.out.println("Displayed hudText "+hudText);	
					
					
					Report.put("User tries to view only Pending Status by Severity in Security Advisory HUD",
							"User should be able to view only Pending Status by Severity in Security Advisory HUD ",
							"Displayed status value in Status Column is "+Report.color(status)+"Security Advisory HUD text is: "+Report.color(hudValue)+Report.color(hudText), "PASS");	
				}
				else
				{
					System.out.println("Failed to Display Pending Status Advisories");

					Report.put("User tries to view only Pending Status by Severity in Security Advisory HUD",
							"User should be able to view only Pending Status by Severity in Security Advisory HUD ",
							"Failed to view Pending Status by Severity in Security Advisory HUD", "FAIL");
					Assert.fail("Failed to view Pending Status by Severity in Security Advisory HUD");
				}		
			} 
			catch(Exception e)
			{
				e.printStackTrace();
				System.out.println("Failed to Display Pending Status Advisories");

				Report.put("User tries to view only Pending Status by Severity in Security Advisory HUD",
						"User should be able to view only Pending Status by Severity in Security Advisory HUD ",
						"Failed to view Pending Status by Severity in Security Advisory HUD", "FAIL");
				Assert.fail("Failed to view Pending Status by Severity in Security Advisory HUD");
			}
		}
		
		public void verifyHealthAndRiskSecurityAdvisoryHUDOrder(WebDriver driver)
		{
			System.out.println("Inside verifyHealthAndRiskSecurityAdvisoryHUDOrder method");
			Log.info("Inside verifyHealthAndRiskSecurityAdvisoryHUDOrder method");

			String textList = "";	

			try
			{
				WebDriverWait wait = new WebDriverWait(driver, 120);

				List<WebElement> list=driver.findElements(obj_PortalPage.healthAndRiskHUDNames());

				if(CommonUtility.CheckpresenceofElementLocated(driver, 30, obj_PortalPage.securityAdvisoryHUD()))
				{		
					for(WebElement lt:list)
					{
						CommonUtility.highlightElement(driver, lt);
						String text=lt.getText();
						if(!(text.isEmpty()))
						{
							System.out.println("text is: " +text);
							textList+=" <br> " + text;
						}
					}
					System.out.println("Text displayed are: "+textList);

					Report.put("User verifies DSA HUD ",
							"DSA HUD should be 3rd in the row: FCOs | TSEs | DSAs | DTAs",
							"Verified DSA HUD displayed order is: "+Report.color(textList), "PASS");	
				}
				else
				{
					System.out.println("Failed to verify DSA HUD");
					Report.put("User verifies DSA HUD ",
							"DSA HUD should be 3rd in the row: FCOs | TSEs | DSAs | DTAs",
							"Failed to verify DSA HUD", "FAIL");
					Assert.fail();
				}
			} 
			catch(Exception e)
			{
				e.printStackTrace();
				System.out.println("Failed to verify DSA HUD");
				Report.put("User verifies DSA HUD ",
						"DSA HUD should be 3rd in the row: FCOs | TSEs | DSAs | DTAs",
						"Failed to verify DSA HUD", "FAIL");
				Assert.fail();
			}
		}

		public void verifyTechnicalAdvisoryHUDArcValues(WebDriver driver)
		{
			System.out.println("Inside verifyTechnicalAdvisoryHUDArcValues method");
			Log.info("Inside verifyTechnicalAdvisoryHUDArcValues method");
			
			String criticalArc = "";
			String highArc = "";
			String mediumArc = "";
			String lowArc = "";
			String arcValues = "";
			try
			{
				WebDriverWait wait = new WebDriverWait(driver, 120);

				criticalArc = CommonUtility.highlightElement(driver,obj_PortalPage.technicalAdvisoryHUDCriticalArcValue()).getAttribute("value");
				System.out.println("Displayed criticalArc "+criticalArc);	
				highArc = CommonUtility.highlightElement(driver,obj_PortalPage.technicalAdvisoryHUDHighArcValue()).getAttribute("value");
				System.out.println("Displayed highArc "+highArc);	
				mediumArc = CommonUtility.highlightElement(driver,obj_PortalPage.technicalAdvisoryHUDMediumArcValue()).getAttribute("value");
				System.out.println("Displayed mediumArc "+mediumArc);	
				lowArc = CommonUtility.highlightElement(driver,obj_PortalPage.technicalAdvisoryHUDLowArcValue()).getAttribute("value");
				System.out.println("Displayed lowArc "+lowArc);
				
				arcValues = criticalArc +" Critical"+"<br>"+highArc +" High"+"<br>"+mediumArc +" Medium"+"<br>"+lowArc +" Low"+"<br>";
				
				System.out.println("Displayed Arc Values "+arcValues);	
					
			
					
					Report.put("User is on technical advisory HUD view ",
							"User should be able to verify that the Advisory Count is greater than Zero  and user should be able to see HUD with 4 summary perspective Critical, High, Medium and Low",
							"Displayed Technical Advisory Summary HUD View "+Report.color(arcValues), "PASS");	
			} 
			catch(Exception e)
			{
				e.printStackTrace();
				System.out.println("Failed to verify  Technical Advisory Summary HUD View ");

				Report.put("User is on technical advisory HUD view ",
						"User should be able to verify that the Advisory Count is greater than Zero  and user should be able to see HUD with 4 summary perspective Critical, High, Medium and Low",
						"Failed to verify  Technical Advisory Summary HUD View ", "FAIL");
				Assert.fail("Failed to verify  Technical Advisory Summary HUD View ");
			}
		}
		
		public void verifyTechnicalAdvisoryHUDDefaultData(WebDriver driver)
		{
			System.out.println("Inside verifyTechnicalAdvisoryHUDDefaultData method");
			Log.info("Inside verifyTechnicalAdvisoryHUDDefaultData method");
			
			String hudText = "";
			String hudValue = "";
			String status = "";
			try
			{
				WebDriverWait wait = new WebDriverWait(driver, 120);

					hudValue = CommonUtility.highlightElement(driver,obj_PortalPage.technicalAdvisoryHUDTextValue()).getText();
					System.out.println("Displayed hudValue "+hudValue);	

					hudText = CommonUtility.highlightElement(driver,obj_PortalPage.technicalAdvisoryHUDTextName()).getText();
					System.out.println("Displayed hudText "+hudText);	
					
					
					Report.put("User verifies the default selected data Set in the HUD",
							"Default selected data set in the HUD should be of Critical Advisories",
							"Displayed default selected data set in the HUD "+Report.color(hudValue)+Report.color(hudText), "PASS");	
			} 
			catch(Exception e)
			{
				e.printStackTrace();

				Report.put("User verifies the default selected data Set in the HUD",
						"Default selected data set in the HUD should be of Critical Advisories",
						"Failed to display default selected data set in the HUD", "FAIL");
				Assert.fail("Failed to display default selected data set in the HUD");
			}
		}
		
		public void hoverOverTechnicalAdvisoryHUDMediumArc(WebDriver driver)
		{
			System.out.println("Inside hoverOverTechnicalAdvisoryHUDMediumArc method");
			Log.info("Inside hoverOverTechnicalAdvisoryHUDMediumArc method");
			
			String mediumArc = "";
			try
			{
				WebDriverWait wait = new WebDriverWait(driver, 120);

				CommonUtility.scrollToViewElement(driver,obj_PortalPage.technicalAdvisoryHUDMediumArcValue());
				mediumArc = CommonUtility.highlightElement(driver,obj_PortalPage.technicalAdvisoryHUDMediumArcValue()).getAttribute("value");
				System.out.println("Displayed mediumArc "+mediumArc);	
					
					Report.put("User hovers over  a portion of the HUD ",
							"Users should be able to view  view the counts of Critical, High, Medium or Low.",
							"User Hovers on Arc Medium "+Report.color(mediumArc), "PASS");	
			} 
			catch(Exception e)
			{
				e.printStackTrace();
				System.out.println("Failed to hover over  a portion of the HUD ");

				Report.put("User hovers over  a portion of the HUD ",
						"Users should be able to view  view the counts of Critical, High, Medium or Low.",
						"Failed to hover over  a portion of the HUD ", "FAIL");
				Assert.fail("Failed to hover over  a portion of the HUD ");
			}
		}
		
		public void clickTechnicalAdvisoryHUDAndVerifyStatusColumn(WebDriver driver)
		{
			System.out.println("Inside clickTechnicalAdvisoryHUDAndVerifyStatusColumn method");
			Log.info("Inside clickTechnicalAdvisoryHUDAndVerifyStatusColumn method");
			
			String hudText = "";
			String hudValue = "";
			String status = "";
			try
			{
				WebDriverWait wait = new WebDriverWait(driver, 120);

				CommonUtility.ClickOn(driver,(obj_PortalPage.technicalAdvisoryHUD()));
				
				Thread.sleep(10000);
				CommonUtility.highlightElement(driver,(obj_PortalPage.advisoryStatusValueFirstRow()));
				status = CommonUtility.highlightElement(driver,obj_PortalPage.advisoryStatusValueFirstRow()).getText();

				if((status.equalsIgnoreCase("Work In Progress")) || (status.equalsIgnoreCase("Reviewed")) || (status.equalsIgnoreCase("New")))
				{
					System.out.println("Displayed status "+status);	
					
					
					Report.put("User clicks  on the Hud of DTA",
							"User should be  Navigated to Technical Advisory Page and advisory grid should be pre-filtered to pending advisories ",
							"Clicked on HUD of DTA  & displayed status value in Status Column is "+Report.color(status), "PASS");	
				}
				else
				{
					System.out.println("Failed to click on the HUD of DTA");

					Report.put("User clicks  on the Hud of DTA",
							"User should be  Navigated to Technical Advisory Page and advisory grid should be pre-filtered to pending advisories ",
							"Failed to view Pending Status by Severity in Security Advisory HUD", "FAIL");
					Assert.fail("Failed to click on the HUD of DTA");
				}		
			} 
			catch(Exception e)
			{
				e.printStackTrace();
				System.out.println("Failed to click on the HUD of DTA");

				Report.put("User clicks  on the Hud of DTA",
						"User should be  Navigated to Technical Advisory Page and advisory grid should be pre-filtered to pending advisories ",
						"Failed to view Pending Status by Severity in Security Advisory HUD", "FAIL");
				Assert.fail("Failed to click on the HUD of DTA");
			}
		}
		
		public void verifySecurityAdvisoryHUDDefaultData(WebDriver driver)
		{
			System.out.println("Inside verifySecurityAdvisoryHUDDefaultData method");
			Log.info("Inside verifySecurityAdvisoryHUDDefaultData method");
			
			String hudText = "";
			String hudValue = "";
			String status = "";
			try
			{
				WebDriverWait wait = new WebDriverWait(driver, 120);

					hudText = CommonUtility.highlightElement(driver,obj_PortalPage.securityAdvisoryHUDTextName()).getText();
					System.out.println("Displayed hudText "+hudText);	
					
					
					Report.put("Verify the default display of the HUD ",
							" The HUD should be defaulted to '# Critical DSAs'",
							"Displayed default  data  in the HUD "+Report.color(hudText), "PASS");	
			} 
			catch(Exception e)
			{
				e.printStackTrace();

				Report.put("Verify the default display of the HUD ",
						" The HUD should be defaulted to '# Critical DSAs'",
						"Failed to display default data in the HUD", "FAIL");
				Assert.fail("Failed to display default  data  in the HUD");
			}
		}
		
		public void verifySecurityAdvisoryHUDArcValues(WebDriver driver)
		{
			System.out.println("Inside verifySecurityAdvisoryHUDArcValues method");
			Log.info("Inside verifySecurityAdvisoryHUDArcValues method");
			
			String criticalArc = "";
			String highArc = "";
			String mediumArc = "";
			String lowArc = "";
			String arcValues = "";
			try
			{
				WebDriverWait wait = new WebDriverWait(driver, 120);

				criticalArc = CommonUtility.highlightElement(driver,obj_PortalPage.securityAdvisoryHUDCriticalArcValue()).getAttribute("value");
				System.out.println("Displayed criticalArc "+criticalArc);	
				highArc = CommonUtility.highlightElement(driver,obj_PortalPage.securityAdvisoryHUDHighArcValue()).getAttribute("value");
				System.out.println("Displayed highArc "+highArc);	
				mediumArc = CommonUtility.highlightElement(driver,obj_PortalPage.securityAdvisoryHUDMediumArcValue()).getAttribute("value");
				System.out.println("Displayed mediumArc "+mediumArc);	
				lowArc = CommonUtility.highlightElement(driver,obj_PortalPage.securityAdvisoryHUDLowArcValue()).getAttribute("value");
				System.out.println("Displayed lowArc "+lowArc);
				
				arcValues = criticalArc +" Critical"+"<br>"+highArc +" High"+"<br>"+mediumArc +" Medium"+"<br>"+lowArc +" Low"+"<br>";
				
				System.out.println("Displayed Arc Values "+arcValues);	
					
					Report.put("Verify the severity values displayed ",
							" The following severity values should be displayed Severity values: Critical, High, Medium, Low",
							"Displayed Security Advisory Severity Values:"+Report.color(arcValues), "PASS");	
			} 
			catch(Exception e)
			{
				e.printStackTrace();
				System.out.println("Failed to verify Security Advisory Severity Values ");

				Report.put("Verify the severity values displayed ",
						" The following severity values should be displayed Severity values: Critical, High, Medium, Low",
						"Failed to verify  Security Advisory Severity Values ", "FAIL");
				Assert.fail("Failed to verify  Security Advisory Severity Values ");
			}
		}
		
		public void hoverOverSecurityAdvisoryHUDMediumArc(WebDriver driver)
		{
			System.out.println("Inside hoverOverSecurityAdvisoryHUDMediumArc method");
			Log.info("Inside hoverOverSecurityAdvisoryHUDMediumArc method");
			
			String mediumArc = "";
			try
			{
				WebDriverWait wait = new WebDriverWait(driver, 120);

				CommonUtility.scrollToViewElement(driver,obj_PortalPage.securityAdvisoryHUDMediumArcValue());
				mediumArc = CommonUtility.highlightElement(driver,obj_PortalPage.securityAdvisoryHUDMediumArcValue()).getAttribute("value");
				System.out.println("Displayed mediumArc "+mediumArc);	
					
					Report.put("User hovers over  a portion of the HUD ",
							"Users should be able to view  view the counts of Critical, High, Medium or Low.",
							"User Hovers on Arc Medium "+Report.color(mediumArc), "PASS");	
			} 
			catch(Exception e)
			{
				e.printStackTrace();
				System.out.println("Failed to hover over  a portion of the HUD ");

				Report.put("User hovers over  a portion of the HUD ",
						"Users should be able to view  view the counts of Critical, High, Medium or Low.",
						"Failed to hover over  a portion of the HUD ", "FAIL");
				Assert.fail("Failed to hover over  a portion of the HUD ");
			}
		}
		
		public void clickTechnicalAdvisoryHUD(WebDriver driver)
		{
			System.out.println("Inside clickTechnicalAdvisoryHUD method");
			Log.info("Inside clickTechnicalAdvisoryHUD method");
			
			try
			{
				WebDriverWait wait = new WebDriverWait(driver, 120);

				CommonUtility.ClickOn(driver,(obj_PortalPage.technicalAdvisoryHUD()));
				
				Report.put("User clicks  on the Hud of DTA",
							"User should be  Navigated to Technical Advisory Page",
							"Clicked on HUD of DTA", "PASS");	
			} 
			catch(Exception e)
			{
				e.printStackTrace();
				System.out.println("Failed to click on the HUD of DTA");

				Report.put("User clicks  on the Hud of DTA",
						"User should be  Navigated to Technical Advisory Page",
						"Failed to click on the Hud of DTA", "FAIL");
				Assert.fail("Failed to click on the HUD of DTA");
			}
		}
		
		public void verifyInstallBaseTotalAssetsColumnsOrder(WebDriver driver)
		{
			System.out.println("Inside verifyInstallBaseTotalAssetsColumnsOrder method");
			Log.info("Inside verifyInstallBaseTotalAssetsColumnsOrder method");

			//String actualList = "";	
			  ArrayList<String> actualList = new ArrayList<String>();
			  ArrayList<String> expectedList = new ArrayList<String>();
			  
			  String columnList = "";
			try
			{
				WebDriverWait wait = new WebDriverWait(driver, 120);
				
				actualList.add("PROD ID/SERVICE TAG");
				actualList.add("PROD NAME");
				actualList.add("PRODUCT NICKNAME");
				actualList.add("CUSTOMER NAME");
				actualList.add("PROD TYPE");
				actualList.add("INSTALL STATUS");
				actualList.add("INSTALL BASE AGE");
				

			//	CommonUtility.scrollToViewElement(driver,(obj_PortalPage.installBaseColumns()));
				List<WebElement> list=driver.findElements(obj_PortalPage.installBaseColumns());

				for(WebElement lt:list)
				{
					CommonUtility.highlightElement(driver, lt);
					String col=lt.getText();
					if(!(col.isEmpty()))
					{
						System.out.println("Col is: " +col);
						expectedList.add(col);
						columnList+=" <br> " + col;
					}
				}
				System.out.println("Columns are: "+columnList);
				
//				for (String actual: actualList) {
//					  if (expectedList.contains(actual)) 
//					  {
//					    System.out.println("Search function verified"+actual);
//					  } 
//					  else 
//					  {
//					    System.out.println("Search function verification failed"+actual);
//					    }
//					  }
				if(expectedList.containsAll(actualList))
				{
					Report.put("User goes to Install Base tab-->clicks on the Total Assets Summary view",
							"User should be able to see the columns ordered in the following manner:PRODUCT ID, PRODUCT NAME, PRODUCT NICKNAME, SITE ID, CUSTOMER NAME, PRODUCT TYPE, INSTALL STATUS, INSTALL BASE AGE   ",
							"The Columns displayed in order are: "+Report.color(columnList), "PASS");	
				}
				else
				{
					Report.put("User goes to Install Base tab-->clicks on the Total Assets Summary view",
							"User should be able to see the columns ordered in the following manner:PRODUCT ID, PRODUCT NAME, PRODUCT NICKNAME, SITE ID, CUSTOMER NAME, PRODUCT TYPE, INSTALL STATUS, INSTALL BASE AGE   ",
							"Failed to display the Columns ", "FAIL");
					Assert.fail();
				}
			} 
			catch(Exception e)
			{
				e.printStackTrace();
				Report.put("User goes to Install Base tab-->clicks on the Total Assets Summary view",
						"User should be able to see the columns ordered in the following manner:PRODUCT ID, PRODUCT NAME, PRODUCT NICKNAME, SITE ID, CUSTOMER NAME, PRODUCT TYPE, INSTALL STATUS, INSTALL BASE AGE   ",
						"Failed to display the Columns ", "FAIL");
				Assert.fail();
			}
		}
		
		public void verifyInstallBaseConnectivityColumnsOrder(WebDriver driver)
		{
			System.out.println("Inside verifyInstallBaseConnectivityColumnsOrder method");
			Log.info("Inside verifyInstallBaseConnectivityColumnsOrder method");

			  ArrayList<String> actualList = new ArrayList<String>();
			  ArrayList<String> expectedList = new ArrayList<String>();
			  
			  String columnList = "";
			try
			{
				WebDriverWait wait = new WebDriverWait(driver, 120);
				
				actualList.add("PROD ID/SERVICE TAG");
				actualList.add("PROD NAME");
				actualList.add("PRODUCT NICKNAME");
				actualList.add("CUSTOMER NAME");
				actualList.add("CONNECTION STATUS");
				actualList.add("CONNECTION TYPE");
				actualList.add("CONNECTION AGE");
				actualList.add("LAST CONNECTED");

				List<WebElement> list=driver.findElements(obj_PortalPage.installBaseColumns());

				for(WebElement lt:list)
				{
					CommonUtility.highlightElement(driver, lt);
					String col=lt.getText();
					if(!(col.isEmpty()))
					{
						System.out.println("Col is: " +col);
						expectedList.add(col);
						columnList+=" <br> " + col;
					}
				}
				System.out.println("Columns are: "+columnList);
				

				if(expectedList.containsAll(actualList))
				{
					Report.put("User goes to Install Base tab-->clicks on the Connectivity Summary view",
							"User should be able to see the columns ordered in the following manner: PRODUCT ID, PRODUCT NAME, PRODUCT NICKNAME, CUSTOMER NAME, CONNECTION STATUS, CONNECTION TYPE, CONNECTION AGE, LAST CONNECTED",
							"The Columns displayed in order are: "+Report.color(columnList), "PASS");	
				}
				else
				{
					Report.put("User goes to Install Base tab-->clicks on the Connectivity Summary view",
							"User should be able to see the columns ordered in the following manner: PRODUCT ID, PRODUCT NAME, PRODUCT NICKNAME, CUSTOMER NAME, CONNECTION STATUS, CONNECTION TYPE, CONNECTION AGE, LAST CONNECTED",
							"Failed to display the Columns ", "FAIL");
					Assert.fail();
				}
			} 
			catch(Exception e)
			{
				e.printStackTrace();
				Report.put("User goes to Install Base tab-->clicks on the Connectivity Summary view",
						"User should be able to see the columns ordered in the following manner: PRODUCT ID, PRODUCT NAME, PRODUCT NICKNAME, CUSTOMER NAME, CONNECTION STATUS, CONNECTION TYPE, CONNECTION AGE, LAST CONNECTED",
						"Failed to display the Columns ", "FAIL");
				Assert.fail();
			}
		}
		
		public void verifyInstallBaseCodeLevelsColumnsOrder(WebDriver driver)
		{
			System.out.println("Inside verifyInstallBaseCodeLevelsColumnsOrder method");
			Log.info("Inside verifyInstallBaseCodeLevelsColumnsOrder method");

			  ArrayList<String> actualList = new ArrayList<String>();
			  ArrayList<String> expectedList = new ArrayList<String>();
			  
			  String columnList = "";
			try
			{
				WebDriverWait wait = new WebDriverWait(driver, 120);
				
				actualList.add("PROD ID/SERVICE TAG");
				actualList.add("PROD NAME");
				actualList.add("PRODUCT NICKNAME");
				actualList.add("CUSTOMER NAME");
				actualList.add("TARGET + CODE");
				actualList.add("TARGET -1 CODE");
				actualList.add("INSTALLED CODE");
				actualList.add("CODE LEVEL");

				List<WebElement> list=driver.findElements(obj_PortalPage.installBaseColumns());

				for(WebElement lt:list)
				{
					CommonUtility.scrollToViewElement(driver, lt);
					CommonUtility.highlightElement(driver, lt);
					String col=lt.getText();
					if(!(col.isEmpty()))
					{
						System.out.println("Col is: " +col);
						expectedList.add(col);
						columnList+=" <br> " + col;
					}
				}
				System.out.println("Columns are: "+columnList);
				

				if(expectedList.containsAll(actualList))
				{
					Report.put("User goes to Install Base tab-->clicks on the Code Levels Summary view",
							"User should be able to see the columns ordered in the following manner: PRODUCT ID, PRODUCT NAME, PRODUCT NICKNAME, SITE ID, CUSTOMER NAME, TARGET +, TARGET - 1, INSTALLED CODE, CODE LEVEL  ",
							"The Columns displayed in order are: "+Report.color(columnList), "PASS");	
				}
				else
				{
					Report.put("User goes to Install Base tab-->clicks on the Code Levels Summary view",
							"User should be able to see the columns ordered in the following manner: PRODUCT ID, PRODUCT NAME, PRODUCT NICKNAME, SITE ID, CUSTOMER NAME, TARGET +, TARGET - 1, INSTALLED CODE, CODE LEVEL  ",
							"Failed to display the Columns ", "FAIL");
					Assert.fail();
				}
			} 
			catch(Exception e)
			{
				e.printStackTrace();
				Report.put("User goes to Install Base tab-->clicks on the Code Levels Summary view",
						"User should be able to see the columns ordered in the following manner: PRODUCT ID, PRODUCT NAME, PRODUCT NICKNAME, SITE ID, CUSTOMER NAME, TARGET +, TARGET - 1, INSTALLED CODE, CODE LEVEL  ",
						"Failed to display the Columns ", "FAIL");
				Assert.fail();
			}
		}

		public void verifyInstallBaseContractsColumnsOrder(WebDriver driver)
		{
			System.out.println("Inside verifyInstallBaseContractsColumnsOrder method");
			Log.info("Inside verifyInstallBaseContractsColumnsOrder method");

			  ArrayList<String> actualList = new ArrayList<String>();
			  ArrayList<String> expectedList = new ArrayList<String>();
			  
			  String columnList = "";
			try
			{
				WebDriverWait wait = new WebDriverWait(driver, 120);
				
				actualList.add("PROD ID/SERVICE TAG");
				actualList.add("PRODUCT NICKNAME");
				actualList.add("PROD NAME");
				actualList.add("CUSTOMER NAME");
				actualList.add("SALES ORDER NUMBER");
				actualList.add("CONTRACT STATUS");
				actualList.add("SERVICE PLAN LEVEL");
				actualList.add("END DATE");

				List<WebElement> list=driver.findElements(obj_PortalPage.installBaseColumns());

				for(WebElement lt:list)
				{
					//CommonUtility.scrollToViewElement(driver, lt);
					CommonUtility.highlightElement(driver, lt);
					String col=lt.getText();
					if(!(col.isEmpty()))
					{
						System.out.println("Col is: " +col);
						expectedList.add(col);
						columnList+=" <br> " + col;
					}
				}
				System.out.println("Columns are: "+columnList);
				

				if(expectedList.containsAll(actualList))
				{
					Report.put("User goes to Install Base tab-->clicks on the Contracts Summary view",
							"User should be able to see the columns ordered in the following manner: PRODUCT ID, PRODUCT NICKNAME, PRODUCT NAME, SITE ID, CUSTOMER NAME, SALES ORDER#, CONTRACT STATUS, CONTRACT TYPE, CONTRACT END DATE ",
							"The Columns displayed in order are: "+Report.color(columnList), "PASS");	
				}
				else
				{
					Report.put("User goes to Install Base tab-->clicks on the Contracts Summary view",
							"User should be able to see the columns ordered in the following manner: PRODUCT ID, PRODUCT NICKNAME, PRODUCT NAME, SITE ID, CUSTOMER NAME, SALES ORDER#, CONTRACT STATUS, CONTRACT TYPE, CONTRACT END DATE ",
							"Failed to display the Columns ", "FAIL");
					Assert.fail();
				}
			} 
			catch(Exception e)
			{
				e.printStackTrace();
				Report.put("User goes to Install Base tab-->clicks on the Contracts Summary view",
						"User should be able to see the columns ordered in the following manner: PRODUCT ID, PRODUCT NICKNAME, PRODUCT NAME, SITE ID, CUSTOMER NAME, SALES ORDER#, CONTRACT STATUS, CONTRACT TYPE, CONTRACT END DATE ",
						"Failed to display the Columns ", "FAIL");
				Assert.fail();
			}
		}
		
		public void verifyConnectedAndNotConnectedArcsInGraphView(WebDriver driver)
		{
			System.out.println("Inside verifyConnectedAndNotConnectedArcsInGraphView method");
			Log.info("Inside verifyConnectedAndNotConnectedArcsInGraphView method");
			
			try
			{	
				if(CommonUtility.CheckpresenceofElementLocated(driver, 20, obj_PortalPage.ConnectedArcInGraph()) || CommonUtility.CheckpresenceofElementLocated(driver, 20, obj_PortalPage.NotConnectedArcInGraph()))
				{		
					Thread.sleep(5000);
					System.out.println("Connected & Not Connected Arc displayed ");

					Report.put("User verifies if able to view Connected Assets if data is present",
	    					"User should be able to see the arc for Connected Assets if data is present and user should be able to see the arc for Not Connected Assets if data is present",
							"Verified Connected & Not Connected Assets present ", "PASS");	
				}
				else
				{
					System.out.println("Failed to Verify Connected & Not Connected Assets present.");

					Report.put("User verifies if able to view Connected Assets if data is present",
	    					"User should be able to see the arc for Connected Assets if data is present and user should be able to see the arc for Not Connected Assets if data is present",
							"Failed to Verify Connected & Not Connected Assets present", "FAIL");						
					Assert.fail();
				}
			} 
			catch(Exception e)
			{
				e.printStackTrace();
				System.out.println("Failed to Verify Connected & Not Connected Assets present.");

				Report.put("User verifies if able to view Connected Assets if data is present",
    					"User should be able to see the arc for Connected Assets if data is present and user should be able to see the arc for Not Connected Assets if data is present",
						"Failed to Verify Connected & Not Connected Assets present", "FAIL");						
				Assert.fail();
			}
		}
		
		public void verifyNotEligibleOptionInConnectivityFilter(WebDriver driver)
		{
			System.out.println("Inside verifyNotEligibleOptionInConnectivityFilter method");
			Log.info("Inside verifyNotEligibleOptionInConnectivityFilter method");


			String option = "";
			String header = "";
			String notConnectedLabel = "";
			String filterBreadcrumb = "";
			try
			{
				WebDriverWait wait = new WebDriverWait(driver, 120);
				
				CommonUtility.ClickOn(driver,obj_PortalPage.incidentManagementSummaryViewFilterButton());

				CommonUtility.scrollToViewElement(driver,(obj_PortalPage.connectivityStatusFilterOption()));
				option = CommonUtility.highlightElement(driver,obj_PortalPage.connectivityStatusFilterOption()).getText();

				CommonUtility.ClickOn(driver,obj_PortalPage.connectivityStatusFilterOption());

				System.out.println("Clicked on option "+option);

				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.connectivityStatusFilterOptionHeader()));

				CommonUtility.highlightElement(driver,obj_PortalPage.connectivityStatusFilterOptionHeader());

				header = CommonUtility.highlightElement(driver,obj_PortalPage.connectivityStatusFilterOptionHeader()).getText();

				System.out.println("Header is "+header);


				if(!(CommonUtility.CheckpresenceofElementLocated(driver, 20, obj_PortalPage.ConnectivityStatusFilterOptionNotEligible())))
				{

				System.out.println("Not Eligible Label is not displayed");

				CommonUtility.ClickOn(driver,obj_PortalPage.connectivityStatusFilterOptionHeader());
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.incidentManagementFilterByPopupHeader()));
				CommonUtility.highlightElement(driver,obj_PortalPage.incidentManagementFilterByPopupCloseButton()).click();


				Report.put("User clicks on the Filter By button",
						"User should be able see the filter opens the Connectivity filter from the Filter By and 'Not Eligible' option should not be displayed",
						"Clicked on filter"+Report.color(option)+"'Not Eligible' option is not displayed", "PASS");
				}
				else
				{
					Report.put("User clicks on the Filter By button",
							"User should be able see the filter opens the Connectivity filter from the Filter By and 'Not Eligible' option should not be displayed",
							"Failed to verify 'Not Eligible' option is not displayed", "FAIL");
					Assert.fail();
				}
				} 
			catch(Exception e)
			{
				e.printStackTrace();

				Report.put("User clicks on the Filter By button",
						"User should be able see the filter opens the Connectivity filter from the Filter By and 'Not Eligible' option should not be displayed",
						"Failed to verify 'Not Eligible' option is not displayed", "FAIL");
				Assert.fail();
			}
		}
		
		public void verifyConnectedAndNotConnectedArcsInHUD(WebDriver driver)
		{
			System.out.println("Inside verifyConnectedAndNotConnectedArcsInHUD method");
			Log.info("Inside verifyConnectedAndNotConnectedArcsInHUD method");
			
			try
			{	
				if(CommonUtility.CheckpresenceofElementLocated(driver, 20, obj_PortalPage.notConnectedArcInHud()) || CommonUtility.CheckpresenceofElementLocated(driver, 20, obj_PortalPage.connectedArcInHud()))
				{		
					Thread.sleep(5000);
					System.out.println("Connected & Not Connected Arc displayed ");

					Report.put("User clicks on the Install Base tab",
	    					"User should be able to see the Connectivity KPI in the HUD should  be displayed with  only two data arcs 'Connected' and 'Not Connected' and data arc for 'Not Eligible' should not be displayed",
							"Verified Connected & Not Connected Arcs in HUD  and data arc for 'Not Eligible' is not displayed", "PASS");	
				}
				else
				{
					System.out.println("Failed to Verify Connected & Not Connected Arcs in HUD  and data arc for 'Not Eligible' is not displayed");

					Report.put("User clicks on the Install Base tab",
	    					"User should be able to see the Connectivity KPI in the HUD should  be displayed with  only two data arcs 'Connected' and 'Not Connected' and data arc for 'Not Eligible' should not be displayed",
							"Failed to Verify Connected & Not Connected Arcs in HUD  and data arc for 'Not Eligible' is not displayed", "FAIL");						
					Assert.fail();
				}
			} 
			catch(Exception e)
			{
				e.printStackTrace();
				System.out.println("Failed to Verify Connected & Not Connected Arcs in HUD  and data arc for 'Not Eligible' is not displayed");

				Report.put("User clicks on the Install Base tab",
    					"User should be able to see the Connectivity KPI in the HUD should  be displayed with  only two data arcs 'Connected' and 'Not Connected' and data arc for 'Not Eligible' should not be displayed",
						"Failed to Verify Connected & Not Connected Arcs in HUD  and data arc for 'Not Eligible' is not displayed", "FAIL");						
				Assert.fail();
			}
		}
		
		public void verifyInstallBaseCodeLevelBubbleChartIneligibleAsset(WebDriver driver)
		{
			System.out.println("Inside verifyInstallBaseCodeLevelBubbleChartIneligibleAsset method");
			Log.info("Inside verifyInstallBaseCodeLevelBubbleChartIneligibleAsset method");

			  ArrayList<String> actualList = new ArrayList<String>();
			  
			  String valueList = "";
			try
			{
				WebDriverWait wait = new WebDriverWait(driver, 120);
				
				List<WebElement> list=driver.findElements(obj_PortalPage.codeLevelBubbleChartTextList());

				for(WebElement lt:list)
				{
					CommonUtility.highlightElement(driver, lt);
					String value=lt.getText();
					if(!(value.isEmpty()))
					{
						System.out.println("value is: " +value);
						actualList.add(value);
						valueList+=" <br> " + value;
					}
				}
				System.out.println("Values are: "+valueList);
				
				if(!(actualList.contains("Ineligible")))
				{
					Report.put("User clicks on the Visualizations button",
							"User should be able to see the ineligible assets should not be present in the Code Level Category Bubbles ",
							"Verified ineligible assets is not present in the Code Level Category Bubbles  "+Report.color(valueList), "PASS");	
				}
				else
				{
					Report.put("User clicks on the Visualizations button",
							"User should be able to see the ineligible assets should not be present in the Code Level Category Bubbles ",
							"Failed to verify ineligible assets is not present in the Code Level Category Bubbles ", "FAIL");
					Assert.fail();
				}
			} 
			catch(Exception e)
			{
				e.printStackTrace();
				Report.put("User clicks on the Visualizations button",
						"User should be able to see the ineligible assets should not be present in the Code Level Category Bubbles ",
						"Failed to verify ineligible assets is not present in the Code Level Category Bubbles ", "FAIL");
				Assert.fail();
			}
		}
		
		public void verifyInstallBaseCodeLevelsHUDArcIneligibleAsset(WebDriver driver)
		{
			System.out.println("Inside verifyInstallBaseCodeLevelsHUDArcIneligibleAsset method");
			Log.info("Inside verifyInstallBaseCodeLevelsHUDArcIneligibleAsset method");

			
			String valueList = "";
			String att = "";
			boolean arc = false;
			try
			{
				WebDriverWait wait = new WebDriverWait(driver, 120);
				
				List<WebElement> list=driver.findElements(obj_PortalPage.codeLevelHUDArcsList());

				for(WebElement lt:list)
				{
					CommonUtility.highlightElement(driver, lt);
					String value=lt.getAttribute("class");
					if(!(value.isEmpty()))
					{
						System.out.println("value is: " +value);
						valueList+=" <br> " + value;
						if(value.contains("ineligible"))
						{
							arc=true;
						}
					}
				}
				
				if(!arc)
				{
					System.out.println("Code Levels is selected");
					
					Report.put("User navigates to the code levels Section KPI and user tries to hover on all the sections of Code Levels KPI ",
							"User should be able to see ineligible assets should not be present in the Code Level KPIs",
							"User verifies ineligible assets is not present in the Code Level KPIs ", "PASS");
				}
				else
				{
					Report.put("User navigates to the code levels Section KPI and user tries to hover on all the sections of Code Levels KPI ",
							"User should be able to see ineligible assets should not be present in the Code Level KPIs",
							"Failed to verify ineligible assets is not present in the Code Level KPIs", "FAIL");
					Assert.fail();	
				}
				
			} 
			catch(Exception e)
			{
				e.printStackTrace();
				Report.put("User navigates to the code levels Section KPI and user tries to hover on all the sections of Code Levels KPI ",
						"User should be able to see ineligible assets should not be present in the Code Level KPIs",
						"Failed to verify ineligible assets is not present in the Code Level KPIs", "FAIL");
				Assert.fail();	
			}
		}
		
		public void verifyInstallBaseCodeLevelBubbleChartMissingCode(WebDriver driver)
		{
			System.out.println("Inside verifyInstallBaseCodeLevelBubbleChartMissingCode method");
			Log.info("Inside verifyInstallBaseCodeLevelBubbleChartMissingCode method");

			  ArrayList<String> bubbleStringList = new ArrayList<String>();
			  ArrayList<String> legendStringList = new ArrayList<String>();
			  
			  String valBubbleList = "";
			  String valLegendList = "";
			try
			{
				WebDriverWait wait = new WebDriverWait(driver, 120);
				
				List<WebElement> list=driver.findElements(obj_PortalPage.codeLevelBubbleChartTextList());

				for(WebElement lt:list)
				{
					CommonUtility.highlightElement(driver, lt);
					String value=lt.getText();
					if(!(value.isEmpty()))
					{
						System.out.println("value is: " +value);
						bubbleStringList.add(value);
						valBubbleList+=" <br> " + value;
					}
				}
				System.out.println("Values are: "+valBubbleList);
				
				List<WebElement> legendList=driver.findElements(obj_PortalPage.codeLevelLegendChartTextList());

				for(WebElement lt:list)
				{
					CommonUtility.highlightElement(driver, lt);
					String value=lt.getText();
					if(!(value.isEmpty()))
					{
						System.out.println("value is: " +value);
						legendStringList.add(value);
						valLegendList+=" <br> " + value;
					}
				}
				System.out.println("Values are: "+valLegendList);
				
				if(!((bubbleStringList.contains("Missing Code")) && (legendStringList.contains("Missing Code"))))
				{
					Report.put("User  clicks on the Summary view of Code Levels  and then clicks on the Visualizations button",
							"User should not be able to see Missing Code bubble in the visualizations and no legend for Missing Code is displayed",
							"Verified Missing Code is not present in the Code Level Category Bubbles Chart"+Report.color(valBubbleList)+"<br>"+"values in Legend Chart are:"+Report.color(valLegendList), "PASS");	
				}
				else
				{
					Report.put("User  clicks on the Summary view of Code Levels  and then clicks on the Visualizations button",
							"User should not be able to see Missing Code bubble in the visualizations and no legend for Missing Code is displayed",
							"Failed to verify Missing Code is not present in the Code Level Category Bubbles and Legend", "FAIL");
					Assert.fail();
				}
			} 
			catch(Exception e)
			{
				e.printStackTrace();
				Report.put("User  clicks on the Summary view of Code Levels  and then clicks on the Visualizations button",
						"User should not be able to see Missing Code bubble in the visualizations and no legend for Missing Code is displayed",
						"Failed to verify Missing Code is not present in the Code Level Category Bubbles and Legend", "FAIL");
				Assert.fail();
			}
		}
		
		public void clickAdvisoryIDAndVerifyPopup(WebDriver driver)
		{
			System.out.println("Inside clickAdvisoryIDAndVerifyPopup method");
			Log.info("Inside clickAdvisoryIDAndVerifyPopup method");

			String advisoryID = "";
			String header = "";
			String prodList = "";
			
			WebDriverWait wait = new WebDriverWait(driver, 120);
			
			try
			{		

				if(CommonUtility.CheckpresenceofElementLocated(driver, 30, obj_PortalPage.advisoryColumnFirstRowValue()))
				{
					advisoryID = CommonUtility.highlightElement(driver,obj_PortalPage.advisoryColumnFirstRowValue()).getText();

					
					System.out.println("Clicked on Advisory ID "+advisoryID);

					CommonUtility.ClickOn(driver,obj_PortalPage.advisoryColumnFirstRowValue());
					
					Thread.sleep(5000);		

					wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.advisoryDetailsPopupHeader()));
					
					
						header = CommonUtility.highlightElement(driver,obj_PortalPage.advisoryDetailsPopupHeader()).getText();

						CommonUtility.ClickOn(driver,obj_PortalPage.advisoryDetailsPopupCloseButton());
						
						System.out.println("Displayed Modal Popup Header "+header);
					
						Report.put("User clicks on Advisory ID in the Advisory grid   ",
								"A modal window should open up with title of the modal header showing Account/Custom Group Name information and the modal should have label for the respective Summary view and  Advisory ID too",
								"Clicked on Advisory ID "+Report.color(advisoryID) +"and modal window displayed with the header "+Report.color(header), "PASS");	
					}
					else
					{
						System.out.println("Failed to click on Advisory ID ");

						Report.put("User clicks on Advisory ID in the Advisory grid   ",
								"A modal window should open up with title of the modal header showing Account/Custom Group Name information and the modal should have label for the respective Summary view and  Advisory ID too",
								"Failed to click on Advisory ID", "FAIL");						
						Assert.fail();
					}
			} 
			catch(Exception e)
			{
				e.printStackTrace();
				System.out.println("Failed to click on Advisory ID ");

				Report.put("User clicks on Advisory ID in the Advisory grid   ",
						"A modal window should open up with title of the modal header showing Account/Custom Group Name information and the modal should have label for the respective Summary view and  Advisory ID too",
						"Failed to click on Advisory ID", "FAIL");					
				Assert.fail();
			}
		}
		
		public void verifyAdvisoryReviewPopupHeader(WebDriver driver)
		{
			System.out.println("Inside verifyAdvisoryReviewPopupHeader method");
			Log.info("Inside verifyAdvisoryReviewPopupHeader method");

			try
			{
				String header = "";
				WebDriverWait wait = new WebDriverWait(driver, 120);

				if(CommonUtility.CheckpresenceofElementLocated(driver, 10, obj_PortalPage.advisoryReviewedPopupHeader()))
				{
					header = CommonUtility.highlightElement(driver,obj_PortalPage.advisoryReviewedPopupHeader()).getText();
					
					Report.put("User verifies the  header of the modal window should be 'Mark status as Reviewed for X of Y advisories'",
							"User should be able to view header of the modal window should be 'Mark status as Reviewed for X of Y advisories'",
							"Modal window displayed with header "+Report.color(header), "PASS");
				}
				else
				{
					Report.put("User verifies the  header of the modal window should be 'Mark status as Reviewed for X of Y advisories'",
							"User should be able to view header of the modal window should be 'Mark status as Reviewed for X of Y advisories'",
							"Failed to verify MultiSelect modal window header ", "FAIL");
					Assert.fail("Failed to verify MultiSelect modal window header ");
				}
			} 
			catch(Exception e)
			{
				e.printStackTrace();

				Report.put("User verifies the  header of the modal window should be 'Mark status as Reviewed for X of Y advisories'",
						"User should be able to view header of the modal window should be 'Mark status as Reviewed for X of Y advisories'",
						"Failed to verify MultiSelect modal window header ", "FAIL");
				Assert.fail("Failed to verify MultiSelect modal window header ");
			}
		}
		
		public void verifyAdvisoryReviewPopupMessageUnderHeader(WebDriver driver)
		{
			System.out.println("Inside verifyAdvisoryReviewPopupMessageUnderHeader method");
			Log.info("Inside verifyAdvisoryReviewPopupMessageUnderHeader method");

			try
			{
				String message = "";
				WebDriverWait wait = new WebDriverWait(driver, 120);

				if(CommonUtility.CheckpresenceofElementLocated(driver, 10, obj_PortalPage.advisoryReviewedPopupMessageUnderHeader()))
				{
					message = CommonUtility.highlightElement(driver,obj_PortalPage.advisoryReviewedPopupMessageUnderHeader()).getText();
					
					Report.put("User verifies message under the Header",
							"User should be view the message displayed as:'Selecting Reviewed indicates these Security Advisories have been evaluated and the affected products may require remediation' ",
							"Message displayed under the header "+Report.color(message), "PASS");
				}
				else
				{
					Report.put("User verifies message under the Header",
							"User should be view the message displayed as:'Selecting Reviewed indicates these Security Advisories have been evaluated and the affected products may require remediation' ",
							"Failed to display the message under the header ", "FAIL");
					Assert.fail("Failed to display the message under the header ");
				}
			} 
			catch(Exception e)
			{
				e.printStackTrace();

				Report.put("User verifies message under the Header",
						"User should be view the message displayed as:'Selecting Reviewed indicates these Security Advisories have been evaluated and the affected products may require remediation' ",
						"Failed to display the message under the header ", "FAIL");
				Assert.fail("Failed to display the message under the header ");
			}
		}
		
		public void verifyAdvisoryReviewPopupMessageImportantNote(WebDriver driver)
		{
			System.out.println("Inside verifyAdvisoryReviewPopupMessageImportantNote method");
			Log.info("Inside verifyAdvisoryReviewPopupMessageImportantNote method");

			try
			{
				String message = "";
				WebDriverWait wait = new WebDriverWait(driver, 120);

				if(CommonUtility.CheckpresenceofElementLocated(driver, 10, obj_PortalPage.advisoryReviewedPopupImportantNoteText()))
				{
					message = CommonUtility.highlightElement(driver,obj_PortalPage.advisoryReviewedPopupImportantNoteText()).getText();
					
					Report.put("User verifies for the message inside the  box",
							"User should be able to view the message displayed as 'Important: This status activates the Resolution Tracking functionality for the affected products. This advisory status will be reflected on all affected products on behalf of your organization.'",
							"Message displayed inside the box "+Report.color(message), "PASS");
				}
				else
				{
					Report.put("User verifies for the message inside the  box",
							"User should be able to view the message displayed as 'Important: This status activates the Resolution Tracking functionality for the affected products. This advisory status will be reflected on all affected products on behalf of your organization.'",
							"Failed to display the message inside the box", "FAIL");
					Assert.fail("Failed to display the message inside the box ");
				}
			} 
			catch(Exception e)
			{
				e.printStackTrace();

				Report.put("User verifies for the message inside the  box",
						"User should be able to view the message displayed as 'Important: This status activates the Resolution Tracking functionality for the affected products. This advisory status will be reflected on all affected products on behalf of your organization.'",
						"Failed to display the message inside the box", "FAIL");
				Assert.fail("Failed to display the message inside the box ");
			}
		}
		
		public void verifyAdvisoryReviewPopupSubmitAndCancelButton(WebDriver driver)
		{
			System.out.println("Inside verifyAdvisoryReviewPopupSubmitAndCancelButton method");
			Log.info("Inside verifyAdvisoryReviewPopupSubmitAndCancelButton method");

			String submitButton = "";
			String cancelButton = "";
			try
			{
				WebDriverWait wait = new WebDriverWait(driver, 120);

				if((CommonUtility.CheckpresenceofElementLocated(driver, 10, obj_PortalPage.advisoryReviewedPopupSubmitButton()) && (CommonUtility.CheckpresenceofElementLocated(driver, 10, obj_PortalPage.advisoryReviewedPopupCancelButton()))))
				{
					CommonUtility.highlightElement(driver,(obj_PortalPage.advisoryReviewedPopupSubmitButton()));
					submitButton = CommonUtility.highlightElement(driver,obj_PortalPage.advisoryReviewedPopupSubmitButton()).getText();

					System.out.println("Submit Button text is "+submitButton);
					
					CommonUtility.highlightElement(driver,(obj_PortalPage.advisoryReviewedPopupCancelButton()));
					cancelButton = CommonUtility.highlightElement(driver,obj_PortalPage.advisoryReviewedPopupCancelButton()).getText();

					System.out.println("Cancel Button text is "+cancelButton);
					
					Report.put("User verifies if  'SUBMIT' and 'CANCEL' buttons are displayed at bottom left",
							"User should be able view the 'SUBMIT' and 'CANCEL' buttons are displayed at bottom left",
							"User is able to view the buttons: "+Report.color(submitButton)+Report.color(cancelButton), "PASS");
				}
				else
				{	
					Report.put("User verifies if  'SUBMIT' and 'CANCEL' buttons are displayed at bottom left",
						"User should be able view the 'SUBMIT' and 'CANCEL' buttons are displayed at bottom left",
							"Failed to view the buttons 'SUBMIT' and 'CANCEL' ", "FAIL");
					Assert.fail();
				}
			} 
			catch(Exception e)
			{
				e.printStackTrace();
				Report.put("User verifies if  'SUBMIT' and 'CANCEL' buttons are displayed at bottom left",
						"User should be able view the 'SUBMIT' and 'CANCEL' buttons are displayed at bottom left",
							"Failed to view the buttons 'SUBMIT' and 'CANCEL' ", "FAIL");
					Assert.fail();
			}
		}
		
		public void verifyAdvisoryReviewPopupCloseButtonAndCheckbox(WebDriver driver)
		{
			System.out.println("Inside verifyAdvisoryReviewPopupCloseButtonAndCheckbox method");
			Log.info("Inside verifyAdvisoryReviewPopupCloseButtonAndCheckbox method");

			String header = "";
			try
			{
				WebDriverWait wait = new WebDriverWait(driver, 120);

				if(CommonUtility.CheckpresenceofElementLocated(driver, 10, obj_PortalPage.advisoryReviewedPopupCloseButton()))
				{
					CommonUtility.highlightElement(driver,(obj_PortalPage.advisoryReviewedPopupCloseButton()));
					
					CommonUtility.ClickOn(driver, obj_PortalPage.advisoryReviewedPopupFirstCheckbox());
					header = CommonUtility.highlightElement(driver,obj_PortalPage.advisoryReviewedPopupHeader()).getText();

					System.out.println("Header is "+header);
					
					Report.put("User verifies if X icon at top right corner to exit out the current window ",
							"User should be able to view the X icon at the top right corner and user should be able to select/deselect checkboxes in modal and count in header should change accordingly. ",
							"User is able to verify X icon and able to select/unselect the checkbox "+Report.color(header), "PASS");
				}
				else
				{	
					Report.put("User verifies if X icon at top right corner to exit out the current window ",
							"User should be able to view the X icon at the top right corner and user should be able to select/deselect checkboxes in modal and count in header should change accordingly. ",
							"Failed to verify X icon and able to select/unselect the checkbox ", "FAIL");
					Assert.fail();
				}
			} 
			catch(Exception e)
			{
				e.printStackTrace();
				Report.put("User verifies if X icon at top right corner to exit out the current window ",
						"User should be able to view the X icon at the top right corner and user should be able to select/deselect checkboxes in modal and count in header should change accordingly. ",
						"Failed to verify X icon and able to select/unselect the checkbox ", "FAIL");
				Assert.fail();
			}
		}
		
		public void clickAdvisoryReviewPopupCloseButtonAndVerifyCheckbox(WebDriver driver)
		{
			System.out.println("Inside clickAdvisoryReviewPopupCloseButtonAndVerifyCheckbox method");
			Log.info("Inside clickAdvisoryReviewPopupCloseButtonAndVerifyCheckbox method");

			String header = "";
			try
			{
				WebDriverWait wait = new WebDriverWait(driver, 120);

				CommonUtility.ClickOn(driver,(obj_PortalPage.advisoryReviewedPopupCloseButton()));

				Thread.sleep(10000);

			//	if(CommonUtility.highlightElement(driver,obj_PortalPage.advisoryCheckboxFirstRow()).isSelected())
			//	{
					System.out.println("Advisory checkbox is selected");

					Report.put("User clicks on the  'CANCEL' or X icon",
							"The modal window should get closed and selected rows in grid should remain selected and there should be no change in the status ",
							"User is able to click on X icon and checkbox remain selected", "PASS");
			//	}
//				else
//				{	
//					Report.put("User clicks on the  'CANCEL' or X icon",
//							"The modal window should get closed and selected rows in grid should remain selected and there should be no change in the status ",
//							"Failed to click X icon and verify checkbox remain selected ", "FAIL");
//					Assert.fail();
//				}
			} 
			catch(Exception e)
			{
				e.printStackTrace();
				Report.put("User clicks on the  'CANCEL' or X icon",
						"The modal window should get closed and selected rows in grid should remain selected and there should be no change in the status ",
						"Failed to click X icon and verify checkbox remain selected ", "FAIL");
				Assert.fail();
			}
		}
		
		public void clickAdvisoryReviewButton(WebDriver driver)
		{
			System.out.println("Inside clickAdvisoryReviewButton method");
			Log.info("Inside clickAdvisoryReviewButton method");

			try
			{
				WebDriverWait wait = new WebDriverWait(driver, 120);

				CommonUtility.ClickOn(driver,(obj_PortalPage.advisoryReviewButton()));

				Thread.sleep(10000);

				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.advisoryReviewedPopupHeader()));
				
				if(CommonUtility.CheckpresenceofElementLocated(driver, 10, obj_PortalPage.advisoryReviewedPopupHeader()))
				{

					Report.put("User clicks on Reviewed button",
							"Multi select modal window should be displayed",
							"User is able to click on Review Button and modal popup is displayed", "PASS");
				}
				else
				{	
					Report.put("User clicks on Reviewed button",
							"Multi select modal window should be displayed",
							"Failed to click Review Button and display modal popup ", "FAIL");
					Assert.fail();
				}
			} 
			catch(Exception e)
			{
				e.printStackTrace();
				Report.put("User clicks on Reviewed button",
						"Multi select modal window should be displayed",
						"Failed to click Review Button and display modal popup ", "FAIL");
				Assert.fail();
			}
		}
		
		public void clickAdvisoryReviewPopupSubmitButton(WebDriver driver)
		{
			System.out.println("Inside clickAdvisoryReviewPopupSubmitButton method");
			Log.info("Inside clickAdvisoryReviewPopupSubmitButton method");

			try
			{
				WebDriverWait wait = new WebDriverWait(driver, 120);

				CommonUtility.ClickOn(driver,(obj_PortalPage.advisoryReviewedPopupSubmitButton()));

				Thread.sleep(10000);

				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.securityAdvisoryColumns()));
				
				if(CommonUtility.CheckpresenceofElementLocated(driver, 10, obj_PortalPage.securityAdvisoryColumns()))
				{

					Report.put("User clicks on Submit button",
							"The modal should get closed and security advisory grid should reload ",
							"User is able to click on Submit Button and  security advisory grid  is displayed", "PASS");
				}
				else
				{	
					Report.put("User clicks on Submit button",
							"The modal should get closed and security advisory grid should reload ",
							"Failed to click on Submit Button and  verify security advisory grid ", "FAIL");
					Assert.fail();
				}
			} 
			catch(Exception e)
			{
				e.printStackTrace();
				Report.put("User clicks on Submit button",
						"The modal should get closed and security advisory grid should reload ",
						"Failed to click on Submit Button and  verify security advisory grid ", "FAIL");
				Assert.fail();
			}
		}
		
		public void verifyAdvisoryStatusReviewedAfterSubmit(WebDriver driver)
		{
			System.out.println("Inside verifyAdvisoryStatusReviewedAfterSubmit method");
			Log.info("Inside verifyAdvisoryStatusReviewedAfterSubmit method");
			
			String status = "";
			try
			{
				WebDriverWait wait = new WebDriverWait(driver, 120);

				CommonUtility.highlightElement(driver,(obj_PortalPage.advisoryStatusValueFirstRow()));
				status = CommonUtility.highlightElement(driver,obj_PortalPage.advisoryStatusValueFirstRow()).getText();

				if(status.equalsIgnoreCase("Reviewed"))
				{
					System.out.println("Displayed status "+status);	
					
					
					Report.put("User verifies the status under  security advisory for which the checkbox was selected in modal window",
							"User should be able to view the status changes to Reviewed and checkboxes should get deselected in grid ",
							"Status value in Status Column is "+Report.color(status), "PASS");	
				}
				else
				{
					System.out.println("Failed to verify Reviewed Status");

					Report.put("User verifies the status under  security advisory for which the checkbox was selected in modal window",
							"User should be able to view the status changes to Reviewed and checkboxes should get deselected in grid ",
							"Failed to view Reviewed Status for the advisory", "FAIL");
					Assert.fail("Failed to view Reviewed Status for the advisory");
				}		
			} 
			catch(Exception e)
			{
				e.printStackTrace();
				System.out.println("Failed to verify Reviewed Status");

				Report.put("User verifies the status under  security advisory for which the checkbox was selected in modal window",
						"User should be able to view the status changes to Reviewed and checkboxes should get deselected in grid ",
						"Failed to view Reviewed Status for the advisory", "FAIL");
				Assert.fail("Failed to view Reviewed Status for the advisory");
			}
		}
		
		public void clickAdvisoryCheckboxWithStatusNew(WebDriver driver)
		{
			System.out.println("Inside clickAdvisoryCheckboxWithStatusNew method");
			Log.info("Inside clickAdvisoryCheckboxWithStatusNew method");

			try
			{
				WebDriverWait wait = new WebDriverWait(driver, 120);

				CommonUtility.ClickOn(driver,obj_PortalPage.incidentManagementSummaryViewFilterButton());

				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.incidentManagementFilterByPopupHeader()));

				CommonUtility.highlightElement(driver,obj_PortalPage.incidentManagementFilterByPopupHeader());

				CommonUtility.ClickOn(driver,obj_PortalPage.incidentManagementFilterByPopupClearAllButton());

				CommonUtility.ClickOn(driver,obj_PortalPage.remediationStatusFilter());

				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.remediationStatusHeader()));

				CommonUtility.ClickOn(driver,obj_PortalPage.remediationStatusNew());

				CommonUtility.ClickOn(driver,obj_PortalPage.incidentManagementFilterByPopupApplySelectedButton());
				CommonUtility.ClickOn(driver,obj_PortalPage.incidentManagementFilterByPopupCloseButton());

				Thread.sleep(5000);
				CommonUtility.ClickOn(driver,obj_PortalPage.advisoryCheckboxFirstRow());

				Thread.sleep(3000);

				
					Report.put("User navigates to security advisory grid and User selects some New/Updated advisories ",
							" User should be able to select the New/Updated advisories ",
							"User able to select new advisory", "PASS");
			
			} 
			catch(Exception e)
			{
				e.printStackTrace();
				Report.put("User navigates to security advisory grid and User selects some New/Updated advisories ",
						" User should be able to select the New/Updated advisories ",
						"Failed to select new advisory", "FAIL");
				Assert.fail("Failed to select new advisory ");
			}
		}
		
		public void clickAdvisoryNotApplicableButton(WebDriver driver)
		{
			System.out.println("Inside clickAdvisoryNotApplicableButton method");
			Log.info("Inside clickAdvisoryNotApplicableButton method");

			try
			{
				WebDriverWait wait = new WebDriverWait(driver, 120);

				
				CommonUtility.ClickOn(driver,(obj_PortalPage.advisoryNotApplicableButton()));

				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.advisoryReviewedPopupHeader()));	

				if(CommonUtility.CheckpresenceofElementLocated(driver, 10, obj_PortalPage.advisoryReviewedPopupHeader()))
				{
					Report.put("User clicks on the Not Applicable button ",
							"User views a multi select modal window should be displayed  ",
							"MultiSelect modal window displayed", "PASS");
				}
				else
				{
					Report.put("User clicks on the Not Applicable button ",
							"User views a multi select modal window should be displayed  ",
							"Failed to verify MultiSelect modal window displayed ", "FAIL");
					Assert.fail("Failed to verify MultiSelect modal window displayed ");
				}
			} 
			catch(Exception e)
			{
				e.printStackTrace();
				Report.put("User clicks on the Not Applicable button ",
						"User views a multi select modal window should be displayed  ",
						"Failed to verify MultiSelect modal window displayed ", "FAIL");
				Assert.fail("Failed to verify MultiSelect modal window displayed ");
			}
		}
		
		public void verifyAdvisoryStatusNotApplicableAfterSubmit(WebDriver driver)
		{
			System.out.println("Inside verifyAdvisoryStatusNotApplicableAfterSubmit method");
			Log.info("Inside verifyAdvisoryStatusNotApplicableAfterSubmit method");
			
			String status = "";
			try
			{
				WebDriverWait wait = new WebDriverWait(driver, 120);

				CommonUtility.highlightElement(driver,(obj_PortalPage.advisoryStatusValueFirstRow()));
				status = CommonUtility.highlightElement(driver,obj_PortalPage.advisoryStatusValueFirstRow()).getText();

				if(status.equalsIgnoreCase("Not Applicable"))
				{
					System.out.println("Displayed status "+status);	
					
					
					Report.put("User verifies the status under  security advisory for which the checkbox was selected in modal window",
							"User should be able to view the status changes to Not Applicable and checkboxes should get deselected in grid ",
							"Status value in Status Column is "+Report.color(status), "PASS");	
				}
				else
				{
					System.out.println("Failed to verify Not Applicable Status");

					Report.put("User verifies the status under  security advisory for which the checkbox was selected in modal window",
							"User should be able to view the status changes to Not Applicable and checkboxes should get deselected in grid ",
							"Failed to view Not Applicable Status for the advisory", "FAIL");
					Assert.fail("Failed to view Not Applicable Status for the advisory");
				}		
			} 
			catch(Exception e)
			{
				e.printStackTrace();
				System.out.println("Failed to verify Not Applicable Status");

				Report.put("User verifies the status under  security advisory for which the checkbox was selected in modal window",
						"User should be able to view the status changes to Not Applicable and checkboxes should get deselected in grid ",
						"Failed to view Not Applicable Status for the advisory", "FAIL");
				Assert.fail("Failed to view Not Applicable Status for the advisory");
			}
		}
		
		
		//Lavanya
		
		public void ClickOnDownloadButtonAndValidateDownloadedCSV(WebDriver driver)
		{

			Log.info("Entering ClickOnDownloadButtonAndValidateDownloadedCSV method");	
			WebDriverWait wait = new WebDriverWait(driver, 120);
			Actions act=new Actions(driver);
			String expand="";
			String header="";


			try
			{
				if(CommonUtility.CheckpresenceofElementLocated(driver, 15, obj_PortalPage.DownloadButton()))
				{

					CommonUtility.scrollToViewElement(driver,obj_PortalPage.DownloadButton());	
					expand=CommonUtility.highlightElement(driver,obj_PortalPage.DownloadButton()).getText();
					System.out.println(expand);
					CommonUtility.highlightElement(driver,obj_PortalPage.DownloadButton()).click();

					wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.HeaderOfThePopUp()));


					CommonUtility.scrollToViewElement(driver,obj_PortalPage.HeaderOfThePopUp());	
					header=CommonUtility.highlightElement(driver,obj_PortalPage.HeaderOfThePopUp()).getText();
					System.out.println("header is "+header);

					Report.put("User checks if he's able able to expand the tabular view to full screen", 
							"User should be able to expand to full screen view" ,
							"User should be able to see "+Report.color(expand)+" button and able to expand tabular view with header "+Report.color(header), "PASS");

				}


				else
				{
					System.out.println("expand button not displayed for tabular view");
					Report.put("User checks if he's able able to expand the tabular view to full screen", 
							"User should be able to expand to full screen view" ,
							"not able to see expand button", "FAIL");
					Assert.fail();
				}
			}
			catch(Exception e)
			{
				Log.info(e);
				Report.put("User checks if he's able able to expand the tabular view to full screen", 
						"User should be able to expand to full screen view" ,
						"not able to see expand button", "FAIL");
				e.printStackTrace();
				Assert.fail();
			}

		} 
		
		
		public void ClickOnDownloadButtonInExpandedView(WebDriver driver)
		{

			Log.info("Entering ClickOnDownloadButtonInExpandedView method");	
			WebDriverWait wait = new WebDriverWait(driver, 120);
			Actions act=new Actions(driver);
			String expand="";
			String header="";


			try
			{
				if(CommonUtility.CheckpresenceofElementLocated(driver, 15, obj_PortalPage.DownloadButton()))
				{

					CommonUtility.ScrollTo(driver,obj_PortalPage.DownloadButton());	
					expand=CommonUtility.highlightElement(driver,obj_PortalPage.DownloadButton()).getText();
					System.out.println(expand);
					Thread.sleep(10000);
					CommonUtility.ClickOn(driver,obj_PortalPage.DownloadButton());
					Thread.sleep(10000);

//					  try
//				        {
//				            FileInputStream file = new FileInputStream(new File("C:\\TestDownloads\\srs.csv"));
//				 
//				            //Create Workbook instance holding reference to .xlsx file
//				            XSSFWorkbook workbook = new XSSFWorkbook(file);
//				 
//				            //Get first/desired sheet from the workbook
//				            XSSFSheet sheet = workbook.getSheetAt(0);
//				 
//				            //Iterate through each rows one by one
//				            Iterator<Row> rowIterator = sheet.iterator();
//				            while (rowIterator.hasNext()) 
//				            {
//				                Row row = rowIterator.next();
//				                //For each row, iterate through all the columns
//				                Iterator<Cell> cellIterator = row.cellIterator();
//				                 
//				              //Reading cell in my case column name is ppm
//				                Cell ppmEx= row.getCell(0);
//				                Cell ppmEx1= row.getCell(1);
//				                
//				                while (cellIterator.hasNext()) 
//				                {
//				                    Cell cell = cellIterator.next();
//				                    //Check the cell type and format accordingly
//				                    switch (cell.getCellType()) 
//				                    {
//				                        case Cell.CELL_TYPE_NUMERIC:
//				                            System.out.print(cell.getNumericCellValue() + "t");
//				                            break;
//				                        case Cell.CELL_TYPE_STRING:
//				                            System.out.print(cell.getStringCellValue() + "t");
//				                            break;
//				                    }
//				                }
//				                System.out.println("");
//				            }
//				            file.close();
						  
						  
//						  FileInputStream file = new FileInputStream("C:\\TestDownloads\\srs.csv");
//
//					       XSSFWorkbook workbook = new XSSFWorkbook(file);
//
//					       XSSFSheet sheet = workbook.getSheet("SheetName");
//
//					       XSSFRow row = sheet.getRow(0);
//
//					       int colNum = row.getLastCellNum();
//
//					       System.out.println("Total Number of Columns : "+colNum);
//
//					       int rowNum = sheet.getLastRowNum()+1;
//
//					       System.out.println("Total Number of Rows  : "+rowNum);
//				        } 
//				        catch (Exception e) 
//				        {
//				            e.printStackTrace();
//				        }
				    
				
			            
			            Thread.sleep(10000);
					
//					 Path path = Paths.get("C:\\TestDownloads\\srs.csv"); 
//			  
//			        // delete File 
//			        try { 
//			  
//			            Files.delete(path); 
//			            Thread.sleep(10000);
//			            System.out.println("File deleted successfully"); 
//			        } 
//			        catch (IOException e) { 
//			  
//			        	System.out.println("Failed to delete the file"); 
//			            e.printStackTrace(); 
//			        } 

					Report.put("User clicks on CSV file and verifies if it gets opened / Downloaded", 
							"The file should get opened / downloaded including data" ,
							"Able to download CSV file", "PASS");

				}


				else
				{
					System.out.println("download button not displayed");
					Report.put("User clicks on CSV file and verifies if it gets opened / Downloaded", 
							"The file should get opened / downloaded including data" ,
							"not able to see download button", "FAIL");
					Assert.fail();
				}
			}
			catch(Exception e)
			{
				Log.info(e);
				Report.put("User clicks on CSV file and verifies if it gets opened / Downloaded", 
						"The file should get opened / downloaded including data" ,
						"not able to see download button", "FAIL");
				e.printStackTrace();
				Assert.fail();
			}

		} 
		
		public void ClickOnSummaryTab(WebDriver driver)
		{

			Log.info("Entering ClickOnSummaryTab method");	
			WebDriverWait wait = new WebDriverWait(driver, 120);
			Actions act=new Actions(driver);
			String expand="";
			String header="";
			String tab="";

			try
			{
				if(CommonUtility.CheckpresenceofElementLocated(driver, 15, obj_PortalPage.SummaryTab()))
				{

					CommonUtility.ScrollTo(driver,obj_PortalPage.SummaryTab());
					tab=CommonUtility.highlightElement(driver,obj_PortalPage.SummaryTab()).getText();
					System.out.println(tab);
					CommonUtility.ClickOn(driver,obj_PortalPage.SummaryTab());

					wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.SummaryTab()));


					
					Report.put("User goes to Summary tab ", 
							"Summary page should get displayed " ,
							"User should be able to see "+Report.color(tab), "PASS");

				}


				else
				{
					System.out.println("not able to see summary tab");
					Report.put("User goes to Summary tab ", 
							"Summary page should get displayed " ,
							"not able to see summary tab", "FAIL");
					Assert.fail();
				}
			}
			catch(Exception e)
			{
				Log.info(e);
				Report.put("User goes to Summary tab ", 
						"Summary page should get displayed " ,
						"not able to see summary tab", "FAIL");
				e.printStackTrace();
				Assert.fail();
			}

		} 
		
		public void ClickOnChangeView(WebDriver driver)
		{

			Log.info("Entering ClickOnChangeView method");	
			WebDriverWait wait = new WebDriverWait(driver, 120);
			
			String expand="";
			String header="";
			String tab="";

			try
			{
//				Thread.sleep(500000);
//				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.ChangeViewHyperLink()));
				if(CommonUtility.CheckpresenceofElementLocated(driver, 10, obj_PortalPage.ChangeViewHyperLink()))
				{

					CommonUtility.ScrollTo(driver,obj_PortalPage.ChangeViewHyperLink());
					tab=CommonUtility.highlightElement(driver,obj_PortalPage.ChangeViewHyperLink()).getText();
					System.out.println(tab);
					CommonUtility.ClickOn(driver,obj_PortalPage.ChangeViewHyperLink());

//					wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.ChooseYourSitesOrProductsHeader()));

					if(CommonUtility.CheckpresenceofElementLocated(driver, 15, obj_PortalPage.SiteIDOverAllCheckBox()))
					{
					CommonUtility.ScrollTo(driver,obj_PortalPage.SiteIDOverAllCheckBox());
					
					CommonUtility.ClickOn(driver,obj_PortalPage.SiteIDOverAllCheckBox());
					}
					if(CommonUtility.CheckpresenceofElementLocated(driver, 15, obj_PortalPage.SiteIDUnCheckAllCheckBox()))
					{
					CommonUtility.ScrollTo(driver,obj_PortalPage.SiteIDUnCheckAllCheckBox());
					
					CommonUtility.ClickOn(driver,obj_PortalPage.SiteIDUnCheckAllCheckBox());
					wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.ToSelectFirstSiteID()));
					CommonUtility.ScrollTo(driver,obj_PortalPage.ToSelectFirstSiteID());
					
					CommonUtility.ClickOn(driver,obj_PortalPage.ToSelectFirstSiteID());
					
					CommonUtility.ScrollTo(driver,obj_PortalPage.ToSelectSecondSiteID());
					
					CommonUtility.ClickOn(driver,obj_PortalPage.ToSelectSecondSiteID());
					
					CommonUtility.ScrollTo(driver,obj_PortalPage.UpdateButton());
					
					CommonUtility.ClickOn(driver,obj_PortalPage.UpdateButton());
					

					}
					
					
					
					
					
					Report.put("Click on first 2 in customize your view ", 
							"user should be able to click on first 2 site ids " ,
							"able to click on first 2 site ids", "PASS");

				}


				else
				{
					System.out.println("not able to see summary tab");
					Report.put("Click on first 2 in customize your view ", 
							"user should be able to click on first 2 site ids " ,
							"Site IDs not displayed", "FAIL");
					Assert.fail();
				}
			}
			catch(Exception e)
			{
				Log.info(e);
				Report.put("Click on first 2 in customize your view ", 
						"user should be able to click on first 2 site ids " ,
						"Site IDs not displayed", "FAIL");
				e.printStackTrace();
				Assert.fail();
			}

		} 
		
		public void ValidateToolTipForDSAAndDTA(WebDriver driver)
		{

			Log.info("Entering ValidateToolTipForDSAAndDTA method");	
			WebDriverWait wait = new WebDriverWait(driver, 120);
			Actions act=new Actions(driver);
			String tooltip="";
			String tooltip1="";
			String tab="";
			String tab1="";
			try
			{
				if(CommonUtility.CheckpresenceofElementLocated(driver, 15, obj_PortalPage.SummaryTab()))
				{
					tab=CommonUtility.highlightElement(driver,obj_PortalPage.ZeroCriticalDSAsInSummaryView()).getText();
					System.out.println(tab);
					CommonUtility.ScrollTo(driver,obj_PortalPage.ZeroCriticalDSAsInSummaryView());
					
					wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.ToolTipMessages()));

					tooltip=CommonUtility.highlightElement(driver,obj_PortalPage.ToolTipMessages()).getText();
					System.out.println("DSA's tooltip is "+tooltip);
					
					tab1=CommonUtility.highlightElement(driver,obj_PortalPage.ZeroCriticalDTA()).getText();
					System.out.println(tab1);
					CommonUtility.ScrollTo(driver,obj_PortalPage.ZeroCriticalDTA());
					
					wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.ToolTipMessages()));

					tooltip1=CommonUtility.highlightElement(driver,obj_PortalPage.ToolTipMessages()).getText();
					System.out.println("DTA's tooltip is "+tooltip1);
					
					Report.put("User verifies that there is no Critical articles showing in pills under DSA/DTA subtab", 
							"User should verify no critical data found under DSA/DTA " ,
							"User should be able to see "+Report.color(tab)+" and "+Report.color(tab1), "PASS");
					
					Report.put("User hovers over on the pills", 
							"User should verify tooltip displaying with message, There are no Critical DSAs pending for remediation for the selected sites/products,<br>There are no Critical DTAs pending for remediation for the selected sites/products" ,
							"User should be able to see tooltip message "+Report.color(tooltip)+" mouse overing on DSA and <br> able to see tooltip message "+Report.color(tooltip1)+" mouse overing on DTA", "PASS");

				}


				else
				{
					System.out.println("not able to see summary tab");
					Report.put("User hovers over on the pills", 
							"User should verify tooltip displaying with message, There are no Critical DSAs pending for remediation for the selected sites/products,<br>There are no Critical DTAs pending for remediation for the selected sites/products" ,
							"not able to see summary tab", "FAIL");
					Assert.fail();
				}
			}
			catch(Exception e)
			{
				Log.info(e);
				Report.put("User hovers over on the pills", 
						"User should verify tooltip displaying with message, There are no Critical DSAs pending for remediation for the selected sites/products,<br>There are no Critical DTAs pending for remediation for the selected sites/products" ,
						"not able to see capture tooltips", "FAIL");
				e.printStackTrace();
				Assert.fail();
			}

		} 
		
		
		public void ValidateBreadcrumbDisplayedInHUDHomeIconSupportMyService360(WebDriver driver)
		{

			Log.info("Entering ValidateBreadcrumbDisplayedInHUDHomeIconSupportMyService360 method");	
			WebDriverWait wait = new WebDriverWait(driver, 120);
			
			String myservice="";
			
			String support="";
			
			try
			{
				CommonUtility.ScrollTo(driver,obj_PortalPage.BreadScrumbOfPortalPage());
				if(CommonUtility.CheckpresenceofElementLocated(driver, 15, obj_PortalPage.BreadScrumbOfPortalPage()))
				{
					CommonUtility.ScrollTo(driver,obj_PortalPage.HomeIconInBreadScrumbOfPortalPage());
					CommonUtility.highlightElement(driver,obj_PortalPage.HomeIconInBreadScrumbOfPortalPage());
					
					CommonUtility.ScrollTo(driver,obj_PortalPage.SupportLinkInBreadScrumbOfPortalPage());
					support=CommonUtility.highlightElement(driver,obj_PortalPage.SupportLinkInBreadScrumbOfPortalPage()).getText();
					System.out.println("breadscrumb is "+support);
					
					
					CommonUtility.ScrollTo(driver,obj_PortalPage.MyService360InBreadScrumbOfPortalPage());
					myservice=CommonUtility.highlightElement(driver,obj_PortalPage.MyService360InBreadScrumbOfPortalPage()).getText();
					System.out.println("breadscrumb is "+myservice);
					
										
					Report.put("User verifies the Breadcrumb displayed in HUD as below Home icon > Support > MyService360", 
							"Breadcrumbs should be displayed as below Home icon > Support > MyService360" ,
							"User should be able to see breadscrumb as Home icon > "+Report.color(support)+" > "+Report.color(myservice), "PASS");
					
					Report.put("User verifies breadcrumbs are displayed above the Account Name in the HUD ", 
							"Breadcrumbs should be displayed above the Account Name in the HUD " ,
							"breadscrumbs are displayed above the Account Name in the HUD", "PASS");

				}


				else
				{
					System.out.println("not able to see breadscrumbs ");
					Report.put("User verifies the Breadcrumb displayed in HUD as below Home icon > Support > MyService360", 
							"Breadcrumbs should be displayed as below Home icon > Support > MyService360" ,
							"not able to see breadscrumbs", "FAIL");
					Assert.fail();
				}
			}
			catch(Exception e)
			{
				Log.info(e);
				Report.put("User verifies the Breadcrumb displayed in HUD as below Home icon > Support > MyService360", 
						"Breadcrumbs should be displayed as below Home icon > Support > MyService360" ,
						"not able to see breadscrumbs", "FAIL");
				e.printStackTrace();
				Assert.fail();
			}

		} 
		
		public void ValidateMyService360Link(WebDriver driver)
		{

			Log.info("Entering ValidateMyService360Link method");	
			WebDriverWait wait = new WebDriverWait(driver, 120);
			
			String myservice="";
			
			String tab="";
			
			try
			{
				
				if(CommonUtility.CheckpresenceofElementLocated(driver, 15, obj_PortalPage.MyService360InBreadScrumbOfPortalPage()))
				{
					
					CommonUtility.ScrollTo(driver,obj_PortalPage.MyService360InBreadScrumbOfPortalPage());
					myservice=CommonUtility.highlightElement(driver,obj_PortalPage.MyService360InBreadScrumbOfPortalPage()).getText();
					System.out.println("breadscrumb is "+myservice);
					
					CommonUtility.ScrollTo(driver,obj_PortalPage.SummaryTab());
					tab=CommonUtility.highlightElement(driver,obj_PortalPage.SummaryTab()).getText();
					System.out.println(tab);
										
					Report.put("User goes to Breadcrumbs and click on MyService360", 
							"User should be redirected to portal Summary page" ,
							"User should be able to "+Report.color(myservice)+" and redirected to portal "+Report.color(tab), "PASS");
					
				}


				else
				{
					System.out.println("not able to see myservice360 ");
					Report.put("User goes to Breadcrumbs and click on MyService360", 
							"User should be redirected to portal Summary page" ,
							"not able to see myservice360", "FAIL");
					Assert.fail();
				}
			}
			catch(Exception e)
			{
				Log.info(e);
				Report.put("User goes to Breadcrumbs and click on MyService360", 
						"User should be redirected to portal Summary page" ,
						"not able to see myservice360", "FAIL");
				e.printStackTrace();
				Assert.fail();
			}

		} 
		
		
		public void ValidateClickingOnSupportLinkFromBreadscrumb(WebDriver driver)
		{

			Log.info("Entering ValidateClickingOnSupportLinkFromBreadscrumb method");	
			WebDriverWait wait = new WebDriverWait(driver, 120);
			
			String support="";
			
			String header="";
			
			try
			{
				
				if(CommonUtility.CheckpresenceofElementLocated(driver, 15, obj_PortalPage.SupportLinkInBreadScrumbOfPortalPage()))
				{
					
					CommonUtility.ScrollTo(driver,obj_PortalPage.SupportLinkInBreadScrumbOfPortalPage());
					support=CommonUtility.highlightElement(driver,obj_PortalPage.SupportLinkInBreadScrumbOfPortalPage()).getText();
					System.out.println("breadscrumb is "+support);
					CommonUtility.ClickOn(driver,obj_PortalPage.SupportLinkInBreadScrumbOfPortalPage());
					
					wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.SearchSupportHeaderAfterClickingOnSupportLink()));
					CommonUtility.ScrollTo(driver,obj_PortalPage.SearchSupportHeaderAfterClickingOnSupportLink());
					header=CommonUtility.highlightElement(driver,obj_PortalPage.SearchSupportHeaderAfterClickingOnSupportLink()).getText();
					System.out.println(header);
					String url=driver.getCurrentUrl();
					
					if(url.equals("https://www.dell.com/support/home/us/en/19"))
					{
						Report.put("User goes to Breadcrumbs and click on Support", 
								"User should be redirected to Support home page" ,
								"User should be able to click on "+Report.color(support)+" <br>and redirected to support home page with header as "+Report.color(header)+" and url is "+Report.color(url), "PASS");
						
					}
					else
					{
						System.out.println("not able to expected url ");
						Report.put("User goes to Breadcrumbs and click on Support", 
								"User should be redirected to Support home page" ,
								"not able to redirect to expected url", "FAIL");
						Assert.fail();	
					}
										
					
				}


				else
				{
					System.out.println("not able to see support link ");
					Report.put("User goes to Breadcrumbs and click on Support", 
							"User should be redirected to Support home page" ,
							"not able to see support link", "FAIL");
					Assert.fail();
				}
			}
			catch(Exception e)
			{
				Log.info(e);
				Report.put("User goes to Breadcrumbs and click on Support", 
						"User should be redirected to Support home page" ,
						"not able to see support link", "FAIL");
				e.printStackTrace();
				Assert.fail();
			}

		} 
		
		public void ValidateClickingOnHomeIconFromBreadscrumb(WebDriver driver)
		{

			Log.info("Entering ValidateClickingOnHomeIconFromBreadscrumb method");	
			WebDriverWait wait = new WebDriverWait(driver, 120);
			
			String support="";
			
			String header="";
			
			try
			{
				
				if(CommonUtility.CheckpresenceofElementLocated(driver, 15, obj_PortalPage.HomeIconInBreadScrumbOfPortalPage()))
				{
					
					CommonUtility.ScrollTo(driver,obj_PortalPage.HomeIconInBreadScrumbOfPortalPage());
					CommonUtility.ClickOn(driver,obj_PortalPage.HomeIconInBreadScrumbOfPortalPage());
					
					
					wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.BrowseMostPopularProductsHadingAfterClickingOnHomeIcon()));
					CommonUtility.ScrollTo(driver,obj_PortalPage.BrowseMostPopularProductsHadingAfterClickingOnHomeIcon());
					header=CommonUtility.highlightElement(driver,obj_PortalPage.BrowseMostPopularProductsHadingAfterClickingOnHomeIcon()).getText();
					System.out.println(header);
					
					String url=driver.getCurrentUrl();
					
					if(url.equals("https://www.dell.com/en-us"))
					{
						Report.put("User click on home icon in the breadcrumb ", 
								"User should be redirected to Dell home page" ,
								"User should be able to click on home icon and redirected to support home page with header as "+Report.color(header)+" and url is "+Report.color(url), "PASS");
						
					}
					else
					{
						System.out.println("not able to expected url ");
						Report.put("User click on home icon in the breadcrumb ", 
								"User should be redirected to Dell home page" ,
								"not able to redirect to expected url", "FAIL");
						Assert.fail();	
					}
										
					
				}


				else
				{
					System.out.println("not able to see home icon ");
					Report.put("User click on home icon in the breadcrumb ", 
							"User should be redirected to Dell home page" ,
							"not able to see home icon", "FAIL");
					Assert.fail();
				}
			}
			catch(Exception e)
			{
				Log.info(e);
				Report.put("User click on home icon in the breadcrumb ", 
						"User should be redirected to Dell home page" ,
						"not able to see home icon", "FAIL");
				e.printStackTrace();
				Assert.fail();
			}

		} 

		public void verifyInstallBaseTotalAssetsColumnsOrderExpandedView(WebDriver driver)
		{
			System.out.println("Inside verifyInstallBaseTotalAssetsColumnsOrderExpandedView method");
			Log.info("Inside verifyInstallBaseTotalAssetsColumnsOrderExpandedView method");

			//String actualList = "";	
			  ArrayList<String> actualList = new ArrayList<String>();
			  ArrayList<String> expectedList = new ArrayList<String>();
			  
			  String columnList = "";
			try
			{
				WebDriverWait wait = new WebDriverWait(driver, 120);
				
				actualList.add("PROD ID/SERVICE TAG");
				actualList.add("PROD NAME");
				actualList.add("PRODUCT NICKNAME");
				actualList.add("CUSTOMER NAME");
				actualList.add("PROD TYPE");
				actualList.add("INSTALL STATUS");
				actualList.add("INSTALL BASE AGE");
				actualList.add("INSTANCE ID");
				actualList.add("SOLUTION ID");
				actualList.add("CONNECTION STATUS");
				actualList.add("CONNECTION TYPE");
				actualList.add("CONNECTION AGE");
				actualList.add("LAST CONNECTED");
				actualList.add("CODE LEVEL");
				actualList.add("TARGET -1 CODE");
				actualList.add("TARGET + CODE");
				actualList.add("INSTALLED CODE");
				actualList.add("SALES ORDER NUMBER");
				actualList.add("CONTRACT STATUS");
				actualList.add("SERVICE PLAN LEVEL");
				actualList.add("END DATE");
				actualList.add("END OF STANDARD SUPPORT");
				actualList.add("CITY");
				actualList.add("COUNTRY");
				
				List<WebElement> list=driver.findElements(obj_PortalPage.installBaseColumns());

				for(WebElement lt:list)
				{
					CommonUtility.highlightElement(driver, lt);
					CommonUtility.scrollToViewElement(driver, lt);
					String col=lt.getText();
					if(!(col.isEmpty()))
					{
						System.out.println("Col is: " +col);
						expectedList.add(col);
						columnList+=" <br> " + col;
					}
				}
				System.out.println("Columns are: "+columnList);
				
				if(expectedList.containsAll(actualList))
				{
					Report.put("User goes to expanded view of Total Assets",
							"User should see the below columns in same order PRODID/SERVICE TAG , PRODUCT NICKNAME, PRODUCT NAME, SITE ID, CUSTOMERNAME, PRODUCT TYPE, INSTALL STATUS, INSTALL BASE AGE, INSTANCE ID, SOLUTION ID, CONNECTIVITY STATUS, CONNECTION TYPE, CONNECTION AGE, LAST CONNECTED, CODE LEVEL, TARGET -1 CODE, TARGET + CODE, INSTALLED CODE, SALES ORDER#, CONTRACT STATUS, CONTRACT TYPE, CONTRACT END DATE, END OF STANDARD SUPPORT ,CITY, COUNTRY ",
							"The Columns displayed in order are: "+Report.color(columnList), "PASS");	
				}
				else
				{
					Report.put("User goes to expanded view of Total Assets",
							"User should see the below columns in same order PRODID/SERVICE TAG , PRODUCT NICKNAME, PRODUCT NAME, SITE ID, CUSTOMERNAME, PRODUCT TYPE, INSTALL STATUS, INSTALL BASE AGE, INSTANCE ID, SOLUTION ID, CONNECTIVITY STATUS, CONNECTION TYPE, CONNECTION AGE, LAST CONNECTED, CODE LEVEL, TARGET -1 CODE, TARGET + CODE, INSTALLED CODE, SALES ORDER#, CONTRACT STATUS, CONTRACT TYPE, CONTRACT END DATE, END OF STANDARD SUPPORT ,CITY, COUNTRY ",
							"Failed to display the Columns ", "FAIL");
					Assert.fail();
				}
			} 
			catch(Exception e)
			{
				e.printStackTrace();
				Report.put("User goes to expanded view of Total Assets",
						"User should see the below columns in same order PRODID/SERVICE TAG , PRODUCT NICKNAME, PRODUCT NAME, SITE ID, CUSTOMERNAME, PRODUCT TYPE, INSTALL STATUS, INSTALL BASE AGE, INSTANCE ID, SOLUTION ID, CONNECTIVITY STATUS, CONNECTION TYPE, CONNECTION AGE, LAST CONNECTED, CODE LEVEL, TARGET -1 CODE, TARGET + CODE, INSTALLED CODE, SALES ORDER#, CONTRACT STATUS, CONTRACT TYPE, CONTRACT END DATE, END OF STANDARD SUPPORT ,CITY, COUNTRY ",
						"Failed to display the Columns ", "FAIL");
				Assert.fail();
			}
		}
		
		public void verifyIncidentManagementTotalSRColumnsOrderExpandedView(WebDriver driver)
		{
			System.out.println("Inside verifyIncidentManagementTotalSRColumnsOrderExpandedView method");
			Log.info("Inside verifyIncidentManagementTotalSRColumnsOrderExpandedView method");

			//String actualList = "";	
			  ArrayList<String> actualList = new ArrayList<String>();
			  ArrayList<String> expectedList = new ArrayList<String>();
			  
			  String columnList = "";
			try
			{
				WebDriverWait wait = new WebDriverWait(driver, 120);
				
				actualList.add("SR NUMBER");
				actualList.add("PROD ID/SERVICE TAG");
				actualList.add("PRODUCT NICKNAME");
				actualList.add("PROBLEM SUMMARY");
				actualList.add("PROD NAME");
				actualList.add("CUSTOMER NAME");
				
				actualList.add("SEVERITY");
				actualList.add("STATUS");
				actualList.add("SITE NAME");
				actualList.add("LAST UPDATED");
				actualList.add("NEXT CUSTOMER CONTACT");
				actualList.add("SR CREATE DATE");
				actualList.add("REQUEST AGE");
				actualList.add("PRIMARY CONTACT");
				actualList.add("TECH SUPP. OWNER");
				actualList.add("ACTION OWNER");
				actualList.add("SR TYPE");
				actualList.add("CHANNEL");
				actualList.add("ESC. CREATED DATE");
				actualList.add("SERVICE PLAN LEVEL");
				actualList.add("CITY");
				actualList.add("COUNTRY");
				actualList.add("SOLUTION");
				
				List<WebElement> list=driver.findElements(obj_PortalPage.incidentManagementExpandViewColumns());

				for(WebElement lt:list)
				{
					CommonUtility.highlightElement(driver, lt);
					CommonUtility.scrollToViewElement(driver, lt);
					String col=lt.getText();
					if(!(col.isEmpty()))
					{
						System.out.println("Col is: " +col);
						expectedList.add(col);
						columnList+=" <br> " + col;
					}
				}
				System.out.println("Columns are: "+columnList);
				
				if(expectedList.containsAll(actualList))
				{
					Report.put("User goes to expand view of Total SRs",
							"User should see the below columns in same order SR NUMBER ,PROD ID/SERVICE TAG ,PRODUCT NICKNAME, PROBLEM SUMMARY, PRODUCT NAME, CUSTOMER NAME, SEVERITY, SR STATUS, SITE NAME, LAST UPDATED, NEXT CUSTOMER CONTACT, SR CREATE DATE, REQUEST AGE, PRIMARY CONTACT, TECH SUPP. OWNER, ACTION OWNER, SR TYPE ,CHANNEL, ESC. CREATED DATE, CONTRACT TYPE, CITY, COUNTRY, SOLUTION  ",
							"The Columns displayed in order are: "+Report.color(columnList), "PASS");	
				}
				else
				{
					Report.put("User goes to expand view of Total SRs",
							"User should see the below columns in same order SR NUMBER ,PROD ID/SERVICE TAG ,PRODUCT NICKNAME, PROBLEM SUMMARY, PRODUCT NAME, CUSTOMER NAME, SEVERITY, SR STATUS, SITE NAME, LAST UPDATED, NEXT CUSTOMER CONTACT, SR CREATE DATE, REQUEST AGE, PRIMARY CONTACT, TECH SUPP. OWNER, ACTION OWNER, SR TYPE ,CHANNEL, ESC. CREATED DATE, CONTRACT TYPE, CITY, COUNTRY, SOLUTION  ",
							"Failed to display the Columns ", "FAIL");
					Assert.fail();
				}
			} 
			catch(Exception e)
			{
				e.printStackTrace();
				Report.put("User goes to expand view of Total SRs",
						"User should see the below columns in same order SR NUMBER ,PROD ID/SERVICE TAG ,PRODUCT NICKNAME, PROBLEM SUMMARY, PRODUCT NAME, CUSTOMER NAME, SEVERITY, SR STATUS, SITE NAME, LAST UPDATED, NEXT CUSTOMER CONTACT, SR CREATE DATE, REQUEST AGE, PRIMARY CONTACT, TECH SUPP. OWNER, ACTION OWNER, SR TYPE ,CHANNEL, ESC. CREATED DATE, CONTRACT TYPE, CITY, COUNTRY, SOLUTION  ",
						"Failed to display the Columns ", "FAIL");
				Assert.fail();
			}
		}
		
		public void verifyIncidentManagementEscalationsColumnsOrderExpandedView(WebDriver driver)
		{
			System.out.println("Inside verifyIncidentManagementEscalationsColumnsOrderExpandedView method");
			Log.info("Inside verifyIncidentManagementEscalationsColumnsOrderExpandedView method");

			//String actualList = "";	
			  ArrayList<String> actualList = new ArrayList<String>();
			  ArrayList<String> expectedList = new ArrayList<String>();
			  
			  String columnList = "";
			try
			{
				WebDriverWait wait = new WebDriverWait(driver, 120);
				
				actualList.add("SR NUMBER");
				actualList.add("PROD ID/SERVICE TAG");
				actualList.add("PRODUCT NICKNAME");
				actualList.add("PROBLEM SUMMARY");
				actualList.add("PROD NAME");
				actualList.add("CUSTOMER NAME");
				
				actualList.add("SEVERITY");
				actualList.add("STATUS");
				actualList.add("SITE NAME");
				actualList.add("LAST UPDATED");
				actualList.add("NEXT CUSTOMER CONTACT");
				actualList.add("SR CREATE DATE");
				actualList.add("REQUEST AGE");
				actualList.add("PRIMARY CONTACT");
				actualList.add("TECH SUPP. OWNER");
				actualList.add("ACTION OWNER");
				actualList.add("SR TYPE");
				actualList.add("CHANNEL");
				actualList.add("ESC. CREATED DATE");
				actualList.add("SERVICE PLAN LEVEL");
				actualList.add("CITY");
				actualList.add("COUNTRY");
				actualList.add("SOLUTION");
				
				List<WebElement> list=driver.findElements(obj_PortalPage.incidentManagementExpandViewColumns());

				for(WebElement lt:list)
				{
					CommonUtility.highlightElement(driver, lt);
					CommonUtility.scrollToViewElement(driver, lt);
					String col=lt.getText();
					if(!(col.isEmpty()))
					{
						System.out.println("Col is: " +col);
						expectedList.add(col);
						columnList+=" <br> " + col;
					}
				}
				System.out.println("Columns are: "+columnList);
				
				if(expectedList.containsAll(actualList))
				{
					Report.put("User goes to expand view of Escalations",
							"User should see the below columns in same order SR NUMBER ,PROD ID/SERVICE TAG ,PRODUCT NICKNAME, PROBLEM SUMMARY, PRODUCT NAME, CUSTOMER NAME, SEVERITY, SR STATUS, SITE NAME, LAST UPDATED, NEXT CUSTOMER CONTACT, SR CREATE DATE, REQUEST AGE, PRIMARY CONTACT, TECH SUPP. OWNER, ACTION OWNER, SR TYPE ,CHANNEL, ESC. CREATED DATE, CONTRACT TYPE, CITY, COUNTRY, SOLUTION  ",
							"The Columns displayed in order are: "+Report.color(columnList), "PASS");	
				}
				else
				{
					Report.put("User goes to expand view of Escalations",
							"User should see the below columns in same order SR NUMBER ,PROD ID/SERVICE TAG ,PRODUCT NICKNAME, PROBLEM SUMMARY, PRODUCT NAME, CUSTOMER NAME, SEVERITY, SR STATUS, SITE NAME, LAST UPDATED, NEXT CUSTOMER CONTACT, SR CREATE DATE, REQUEST AGE, PRIMARY CONTACT, TECH SUPP. OWNER, ACTION OWNER, SR TYPE ,CHANNEL, ESC. CREATED DATE, CONTRACT TYPE, CITY, COUNTRY, SOLUTION  ",
							"Failed to display the Columns ", "FAIL");
					Assert.fail();
				}
			} 
			catch(Exception e)
			{
				e.printStackTrace();
				Report.put("User goes to expand view of Escalations",
						"User should see the below columns in same order SR NUMBER ,PROD ID/SERVICE TAG ,PRODUCT NICKNAME, PROBLEM SUMMARY, PRODUCT NAME, CUSTOMER NAME, SEVERITY, SR STATUS, SITE NAME, LAST UPDATED, NEXT CUSTOMER CONTACT, SR CREATE DATE, REQUEST AGE, PRIMARY CONTACT, TECH SUPP. OWNER, ACTION OWNER, SR TYPE ,CHANNEL, ESC. CREATED DATE, CONTRACT TYPE, CITY, COUNTRY, SOLUTION  ",
						"Failed to display the Columns ", "FAIL");
				Assert.fail();
			}
		}
		
		public void verifyIncidentManagementOnsiteServicesColumnsOrderExpandedView(WebDriver driver)
		{
			System.out.println("Inside verifyIncidentManagementOnsiteServicesColumnsOrderExpandedView method");
			Log.info("Inside verifyIncidentManagementOnsiteServicesColumnsOrderExpandedView method");

			//String actualList = "";	
			  ArrayList<String> actualList = new ArrayList<String>();
			  ArrayList<String> expectedList = new ArrayList<String>();
			  
			  String columnList = "";
			try
			{
				WebDriverWait wait = new WebDriverWait(driver, 120);
				
				actualList.add("SR NUMBER");
				actualList.add("PROD ID/SERVICE TAG");
				actualList.add("PRODUCT NICKNAME");
				actualList.add("TASK TYPE");
				actualList.add("TASK STATUS");
				actualList.add("SEVERITY");
				actualList.add("PROD NAME");
				actualList.add("CUSTOMER NAME");
				
				actualList.add("SITE NAME");
				actualList.add("TASK ID");
				actualList.add("TASK DESCRIPTION");
				actualList.add("TASK CREATE DATE");
				actualList.add("TICKET ID");
				actualList.add("ONSITE CONTACT");
				actualList.add("ASSIGNED TECHNICIAN");
				actualList.add("SCHEDULED START TIME");
				actualList.add("SCHEDULED END TIME");
			
				
				List<WebElement> list=driver.findElements(obj_PortalPage.incidentManagementExpandViewColumns());

				for(WebElement lt:list)
				{
					CommonUtility.highlightElement(driver, lt);
					CommonUtility.scrollToViewElement(driver, lt);
					String col=lt.getText();
					if(!(col.isEmpty()))
					{
						System.out.println("Col is: " +col);
						expectedList.add(col);
						columnList+=" <br> " + col;
					}
				}
				System.out.println("Columns are: "+columnList);
				
				if(expectedList.containsAll(actualList))
				{
					Report.put("User goes to expand view of Onsite Services",
							"User should see the below columns in same order SR NUMBER, PROD ID/SERVICE TAG, PRODUCT NICKNAME, TASK TYPE, TASKSTATUS, Severity,  PRODUCT NAME, CUSTOMER NAME, SITE NAME, TASK ID, TASK DESCRIPTION, TASK CREATE DATE, TICKET ID, ONSITE CONTACT, ASSIGNED TECHNICIAN, SCHEDULED START TIME, SCHEDULED END TIME  ",
							"The Columns displayed in order are: "+Report.color(columnList), "PASS");	
				}
				else
				{
					Report.put("User goes to expand view of Onsite Services",
							"User should see the below columns in same order SR NUMBER ,PROD ID/SERVICE TAG ,PRODUCT NICKNAME, PROBLEM SUMMARY, PRODUCT NAME, CUSTOMER NAME, SEVERITY, SR STATUS, SITE NAME, LAST UPDATED, NEXT CUSTOMER CONTACT, SR CREATE DATE, REQUEST AGE, PRIMARY CONTACT, TECH SUPP. OWNER, ACTION OWNER, SR TYPE ,CHANNEL, ESC. CREATED DATE, CONTRACT TYPE, CITY, COUNTRY, SOLUTION  ",
							"Failed to display the Columns ", "FAIL");
					Assert.fail();
				}
			} 
			catch(Exception e)
			{
				e.printStackTrace();
				Report.put("User goes to expand view of Onsite Services",
						"User should see the below columns in same order SR NUMBER ,PROD ID/SERVICE TAG ,PRODUCT NICKNAME, PROBLEM SUMMARY, PRODUCT NAME, CUSTOMER NAME, SEVERITY, SR STATUS, SITE NAME, LAST UPDATED, NEXT CUSTOMER CONTACT, SR CREATE DATE, REQUEST AGE, PRIMARY CONTACT, TECH SUPP. OWNER, ACTION OWNER, SR TYPE ,CHANNEL, ESC. CREATED DATE, CONTRACT TYPE, CITY, COUNTRY, SOLUTION  ",
						"Failed to display the Columns ", "FAIL");
				Assert.fail();
			}
		}
		
		
		
		public void clickIncidentManagementOnsiteServiceButton(WebDriver driver)
		{
			System.out.println("Inside clickIncidentManagementOnsiteServiceButton method");
			Log.info("Inside clickIncidentManagementOnsiteServiceButton method");


			String Button = "";
			String escalationsBreadcrumb = "";
			try
			{
				WebDriverWait wait = new WebDriverWait(driver, 120);

				CommonUtility.highlightElement(driver,(obj_PortalPage.incidentManagementOnsiteServicesButton()));
				Button = CommonUtility.highlightElement(driver,obj_PortalPage.incidentManagementOnsiteServicesButton()).getText();

				CommonUtility.highlightElement(driver,obj_PortalPage.incidentManagementOnsiteServicesButton()).click();					

				System.out.println("Clicked on "+Button);



				Report.put("Select the Onsite Services from left menu ",
						"Onsite Service should be selected",
						"Clicked on button"+Report.color(Button), "PASS");	
			} 
			catch(Exception e)
			{
				e.printStackTrace();
				Report.put("Select the Onsite Services from left menu ",
						"Onsite Service should be selected",
						"Failed to Select the Onsite Services from left menu", "FAIL");
				Assert.fail();
			}
		}
		
		public void verifyHealthAndRiskFCOColumnsOrderExpandedView(WebDriver driver)
		{
			System.out.println("Inside verifyHealthAndRiskFCOColumnsOrderExpandedView method");
			Log.info("Inside verifyHealthAndRiskFCOColumnsOrderExpandedView method");

			//String actualList = "";	
			  ArrayList<String> actualList = new ArrayList<String>();
			  ArrayList<String> expectedList = new ArrayList<String>();
			  
			  String columnList = "";
			try
			{
				WebDriverWait wait = new WebDriverWait(driver, 120);
				
				actualList.add("SR NUMBER");
				actualList.add("PROD ID/SERVICE TAG");
				actualList.add("PRODUCT NICKNAME");
				actualList.add("PROD NAME");
				actualList.add("FCO ID");
				actualList.add("DESCRIPTION");
				actualList.add("FCO STATUS");
				
				actualList.add("CUSTOMER NAME");
				
				actualList.add("PROBLEM SUMMARY");
				actualList.add("CREATE/UPDATE DATE");
				actualList.add("ACTION OWNER");
				actualList.add("REQUEST AGE");
				actualList.add("PRIMARY CONTACT");
				actualList.add("SEVERITY");
				actualList.add("SITE ID");
				actualList.add("TECH SUPP. OWNER");
				actualList.add("SR TYPE");
				actualList.add("SOLUTION");
				actualList.add("CITY");
				actualList.add("STATE");
				actualList.add("COUNTRY");
			
				
				List<WebElement> list=driver.findElements(obj_PortalPage.incidentManagementExpandViewColumns());

				for(WebElement lt:list)
				{
					CommonUtility.highlightElement(driver, lt);
					CommonUtility.scrollToViewElement(driver, lt);
					String col=lt.getText();
					if(!(col.isEmpty()))
					{
						System.out.println("Col is: " +col);
						expectedList.add(col);
						columnList+=" <br> " + col;
					}
				}
				System.out.println("Columns are: "+columnList);
				
				if(expectedList.containsAll(actualList))
				{
					Report.put("User goes to expand view of Field Change Orders",
							"User should see the below columns in same order SR NUMBER, PRODUCT ID, PRODUCT NICKNAME, PROD NAME, FCO ID, DESCRIPTION, FCO STATUS, SITE ID / CUST NAME, PROBLEM SUMMARY, CREATE/UPDATE DATE, ACTION OWNER, REQUEST AGE, PRIMARY CONTACT, SEVERITY, SITE ID, TECH SUPP. OWNER, SR TYPE,SOLUTION,CITY, STATE, COUNTRY  ",
							"The Columns displayed in order are: "+Report.color(columnList), "PASS");	
				}
				else
				{
					Report.put("User goes to expand view of Field Change Orders",
							"User should see the below columns in same order SR NUMBER, PRODUCT ID, PRODUCT NICKNAME, PROD NAME, FCO ID, DESCRIPTION, FCO STATUS, SITE ID / CUST NAME, PROBLEM SUMMARY, CREATE/UPDATE DATE, ACTION OWNER, REQUEST AGE, PRIMARY CONTACT, SEVERITY, SITE ID, TECH SUPP. OWNER, SR TYPE,SOLUTION,CITY, STATE, COUNTRY  ",
							"Failed to display the Columns ", "FAIL");
					Assert.fail();
				}
			} 
			catch(Exception e)
			{
				e.printStackTrace();
				Report.put("User goes to expand view of Field Change Orders",
						"User should see the below columns in same order SR NUMBER, PRODUCT ID, PRODUCT NICKNAME, PROD NAME, FCO ID, DESCRIPTION, FCO STATUS, SITE ID / CUST NAME, PROBLEM SUMMARY, CREATE/UPDATE DATE, ACTION OWNER, REQUEST AGE, PRIMARY CONTACT, SEVERITY, SITE ID, TECH SUPP. OWNER, SR TYPE,SOLUTION,CITY, STATE, COUNTRY  ",
						"Failed to display the Columns ", "FAIL");
				Assert.fail();
			}
		}

		public void clickTrackableServiceEventsTab(WebDriver driver)
		{
			System.out.println("Inside clickTrackableServiceEventsTab method");
			Log.info("Inside clickTrackableServiceEventsTab method");

			String tab = "";
			try
			{		

				if(CommonUtility.CheckpresenceofElementLocated(driver, 30, obj_PortalPage.healthRiskTrackableServiceEventsTab()))
				{
					tab = CommonUtility.highlightElement(driver,obj_PortalPage.healthRiskTrackableServiceEventsTab()).getText();

					
					System.out.println("Technical Advisory Tab is: "+tab);

					CommonUtility.highlightElement(driver,obj_PortalPage.healthRiskTrackableServiceEventsTab()).click();
					Thread.sleep(5000);
					
					
					
						Report.put("User navigates to the Trackable Service Events Tab",
								"User is on Trackable Service Events Tab ",
								"Clicked on tab "+Report.color(tab), "PASS");	
					}
					else
					{
						System.out.println("Failed to click on Trackable Service Events Tab");

						Report.put("User navigates to the Trackable Service Events Tab",
								"User is on Trackable Service Events Tab ",
								"Failed to click  Trackable Service Events Tab", "FAIL");						
						Assert.fail();
					}
			} 
			catch(Exception e)
			{
				e.printStackTrace();
				System.out.println("Failed to click on Trackable Service Events Tab");

				Report.put("User navigates to the Trackable Service Events Tab",
						"User is on Trackable Service Events Tab ",
						"Failed to click  Trackable Service Events Tab", "FAIL");						
				Assert.fail();
			}
		}
		
		public void verifyHealthAndRiskTrackableServiceEventsColumnsOrderExpandedView(WebDriver driver)
		{
			System.out.println("Inside verifyHealthAndRiskTrackableServiceEventsColumnsOrderExpandedView method");
			Log.info("Inside verifyHealthAndRiskTrackableServiceEventsColumnsOrderExpandedView method");

			//String actualList = "";	
			  ArrayList<String> actualList = new ArrayList<String>();
			  ArrayList<String> expectedList = new ArrayList<String>();
			  
			  String columnList = "";
			try
			{
				WebDriverWait wait = new WebDriverWait(driver, 120);
				
				actualList.add("SR NUMBER");
				actualList.add("PROD ID/SERVICE TAG");
				actualList.add("PRODUCT NICKNAME");
				actualList.add("PROD NAME");
				actualList.add("TSE ID");
				actualList.add("DESCRIPTION");
				actualList.add("TSE STATUS");
				
				actualList.add("CUSTOMER NAME");
				
				actualList.add("PROBLEM SUMMARY");
				actualList.add("CREATE/UPDATE DATE");
				actualList.add("ACTION OWNER");
				actualList.add("REQUEST AGE");
				actualList.add("PRIMARY CONTACT");
				actualList.add("SEVERITY");
				actualList.add("SITE ID");
				actualList.add("TECH SUPP. OWNER");
				actualList.add("SR TYPE");
				actualList.add("SOLUTION");
				actualList.add("CITY");
				actualList.add("STATE");
				actualList.add("COUNTRY");
			
				
				List<WebElement> list=driver.findElements(obj_PortalPage.incidentManagementExpandViewColumns());

				for(WebElement lt:list)
				{
					CommonUtility.highlightElement(driver, lt);
					CommonUtility.scrollToViewElement(driver, lt);
					String col=lt.getText();
					if(!(col.isEmpty()))
					{
						System.out.println("Col is: " +col);
						expectedList.add(col);
						columnList+=" <br> " + col;
					}
				}
				System.out.println("Columns are: "+columnList);
				
				if(expectedList.containsAll(actualList))
				{
					Report.put("User goes to expand view of Trackable Service Events",
							"User should see the below columns in same order SR NUMBER PRODUCT ID, PRODUCT NICKNAME, PROD NAME, TSE ID, DESCRIPTION, TSE STATUS, SITE ID / CUST NAME, PROBLEM SUMMARY, CREATE/UPDATE DATE, ACTION OWNER, REQUEST AGE, PRIMARY CONTACT, SEVERITY, SITE ID, TECH SUPP. OWNER, SR TYPE, SOLUTION, CITY, STATE, COUNTRY ",
							"The Columns displayed in order are: "+Report.color(columnList), "PASS");	
				}
				else
				{
					Report.put("User goes to expand view of Trackable Service Events",
							"User should see the below columns in same order SR NUMBER PRODUCT ID, PRODUCT NICKNAME, PROD NAME, TSE ID, DESCRIPTION, TSE STATUS, SITE ID / CUST NAME, PROBLEM SUMMARY, CREATE/UPDATE DATE, ACTION OWNER, REQUEST AGE, PRIMARY CONTACT, SEVERITY, SITE ID, TECH SUPP. OWNER, SR TYPE, SOLUTION, CITY, STATE, COUNTRY ",
							"Failed to display the Columns ", "FAIL");
					Assert.fail();
				}
			} 
			catch(Exception e)
			{
				e.printStackTrace();
				Report.put("User goes to expand view of Trackable Service Events",
						"User should see the below columns in same order SR NUMBER PRODUCT ID, PRODUCT NICKNAME, PROD NAME, TSE ID, DESCRIPTION, TSE STATUS, SITE ID / CUST NAME, PROBLEM SUMMARY, CREATE/UPDATE DATE, ACTION OWNER, REQUEST AGE, PRIMARY CONTACT, SEVERITY, SITE ID, TECH SUPP. OWNER, SR TYPE, SOLUTION, CITY, STATE, COUNTRY ",
						"Failed to display the Columns ", "FAIL");
				Assert.fail();
			}
		}
		
		//Lavanya_Phase2_LKB
		
		public void clickHealthAndRiskTab_Phase2(WebDriver driver)
		{
			System.out.println("Inside clickHealthAndRiskTab_Phase2 method");
			Log.info("Inside clickHealthAndRiskTab_Phase2 method");

			
			String tab = "";
			try
			{
				WebDriverWait wait = new WebDriverWait(driver, 600);
				
				if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_PortalPage.HealthAndRiskTabP2()))
				{
					handleCookies(driver);
					CommonUtility.ScrollTo(driver,obj_PortalPage.HealthAndRiskTabP2());
				CommonUtility.ClickOn(driver,obj_PortalPage.HealthAndRiskTabP2());
				tab = CommonUtility.highlightElement(driver,obj_PortalPage.HealthAndRiskTabP2()).getText();
				
				System.out.println("Clicked on "+tab);

				wait.until(ExpectedConditions.presenceOfElementLocated(obj_PortalPage.HealthAndRiskTabAfterClickingOnIt()));
			
				
				Report.put("Go to Health & Risk page ",
						"User should be landed to H&R page",
						Report.color(tab)+"displayed successfully.", "PASS");
				}
				else
				{
					Report.put("Go to Health & Risk page ",
							"User should be landed to H&R page",
							"Failed to load Health & Risk page", "FAIL");
					Assert.fail();
				}
			} 
			catch(Exception e)
			{
				e.printStackTrace();
				Report.put("Go to Health & Risk page ",
						"User should be landed to H&R page",
						"Failed to load Health & Risk page", "FAIL");
				Assert.fail();
			}
		}
		public void clickSecurityAdvisoryTab_Phase2(WebDriver driver)
		{
			System.out.println("Inside clickSecurityAdvisoryTab_Phase2 method");
			Log.info("Inside clickSecurityAdvisoryTab_Phase2 method");

			WebDriverWait wait = new WebDriverWait(driver, 600);
			
			String securityTab = "";
			String columns = "";
			try
			{		

				if(CommonUtility.CheckpresenceofElementLocated(driver, 150, obj_PortalPage.DellSecurityAdvisoriesTab()))
				{
					CommonUtility.ScrollTo(driver,obj_PortalPage.DellSecurityAdvisoriesTab());
					securityTab = CommonUtility.highlightElement(driver,obj_PortalPage.DellSecurityAdvisoriesTab()).getText();

					
					System.out.println("Security Advisory Tab is: "+securityTab);

					CommonUtility.ClickOn(driver,obj_PortalPage.DellSecurityAdvisoriesTab());
					
					Thread.sleep(5000);
					wait.until(ExpectedConditions.presenceOfElementLocated(obj_PortalPage.SecurityAdvisoryTabAfterClickingOnIt()));
					wait.until(ExpectedConditions.presenceOfElementLocated(obj_PortalPage.DownArrowMarkToExpandSecurityAdvisory()));
					
				
						Report.put("Click on the Dell Security Advisories tab ",
								"User should be navigated to the new DSA page.",
								"Clicked on tab "+Report.color(securityTab) , "PASS");	
					}
					else
					{
						System.out.println("Failed to click on Security Advisory Tab");

						Report.put("Click on the Dell Security Advisories tab ",
								"User should be navigated to the new DSA page.",
								"Failed to click  Security Advisory Tab", "FAIL");						
						Assert.fail();
					}
			} 
			catch(Exception e)
			{
				e.printStackTrace();
				System.out.println("Failed to display  Adivsories Tab in the left");

				Report.put("Click on the Dell Security Advisories tab ",
						"User should be navigated to the new DSA page.",
						"Failed to click  Security Advisory Tab", "FAIL");				
				Assert.fail();
			}
		}
		
		public void clickExpandButtonOfFirstAdvisory_Phase2(WebDriver driver)
		{
			System.out.println("Inside clickExpandButtonOfFirstAdvisory_Phase2 method");
			Log.info("Inside clickExpandButtonOfFirstAdvisory_Phase2 method");

			WebDriverWait wait = new WebDriverWait(driver, 600);
			
			String Acts = "";
			String downpri = "";
			try
			{		
				CommonUtility.ScrollTo(driver,obj_PortalPage.AdvisoryIDLink());
				if(CommonUtility.CheckpresenceofElementLocated(driver, 30, obj_PortalPage.DownArrowMarkToExpandSecurityAdvisory()))
				{
					CommonUtility.ScrollTo(driver,obj_PortalPage.AdvisoryIDLink());
					CommonUtility.ScrollTo(driver,obj_PortalPage.BeforeClickingOnExpand());
					CommonUtility.ScrollTo(driver,obj_PortalPage.DownArrowMarkToExpandSecurityAdvisory());
					
					CommonUtility.ClickOn(driver,obj_PortalPage.DownArrowMarkToExpandSecurityAdvisory());
					
					Thread.sleep(5000);
					
					wait.until(ExpectedConditions.presenceOfElementLocated(obj_PortalPage.UpArrowMarkToExpandSecurityAdvisory()));
					CommonUtility.ScrollTo(driver,obj_PortalPage.ActionsHeader());
					Acts=CommonUtility.highlightElement(driver,obj_PortalPage.ActionsHeader()).getText();
					System.out.println(Acts);
					CommonUtility.ScrollTo(driver,obj_PortalPage.DownloadOrPrintLink());
					downpri=CommonUtility.highlightElement(driver,obj_PortalPage.DownloadOrPrintLink()).getText();
					System.out.println(downpri);
				
					
					CommonUtility.ScrollTo(driver,obj_PortalPage.UpArrowMarkToExpandSecurityAdvisory());
					CommonUtility.ScrollTo(driver,obj_PortalPage.UpArrowMarkToExpandSecurityAdvisory());
					Thread.sleep(6000);
						Report.put("Click to expand the row of a security advisory ",
								"The row should be expanded and a link should be displayed as \"Download\" under the \"Actions\" section",
								"Clicked on expand button able to see  "+Report.color(Acts)+" and "+Report.color(downpri)+" under Actions heading" , "PASS");	
					}
					else
					{
						System.out.println("Failed to see expand button");

						Report.put("Click to expand the row of a security advisory ",
								"The row should be expanded and a link should be displayed as \"Download\" under the \"Actions\" section",
								"Failed to see expand button", "FAIL");						
						Assert.fail();
					}
			} 
			catch(Exception e)
			{
				e.printStackTrace();
				
				Report.put("Click to expand the row of a security advisory ",
						"The row should be expanded and a link should be displayed as \"Download\" under the \"Actions\" section",
						"Failed to see expand button", "FAIL");				
				Assert.fail();
			}
		}
		
		public void clickOnAdvisoryID_Phase2(WebDriver driver)
		{
			System.out.println("Inside clickOnAdvisoryID_Phase2 method");
			Log.info("Inside clickOnAdvisoryID_Phase2 method");

			WebDriverWait wait = new WebDriverWait(driver, 600);
			
			String advid = "";
			String downpri = "";
			String Acts="";
			try
			{		

				if(CommonUtility.CheckpresenceofElementLocated(driver, 30, obj_PortalPage.AdvisoryIDLink()))
				{
					CommonUtility.ScrollTo(driver,obj_PortalPage.AdvisoryIDLink());
					advid=CommonUtility.highlightElement(driver,obj_PortalPage.AdvisoryIDLink()).getText();
					System.out.println(advid);
					CommonUtility.ClickOn(driver,obj_PortalPage.AdvisoryIDLink());
					
					Thread.sleep(5000);
					
					wait.until(ExpectedConditions.presenceOfElementLocated(obj_PortalPage.AdvisoryPopUpHeader()));
					CommonUtility.ScrollTo(driver,obj_PortalPage.ActionsHeader());
					Acts=CommonUtility.highlightElement(driver,obj_PortalPage.ActionsHeader()).getText();
					System.out.println(Acts);
					CommonUtility.ScrollTo(driver,obj_PortalPage.DownloadOrPrintLink());
					downpri=CommonUtility.highlightElement(driver,obj_PortalPage.DownloadOrPrintLink()).getText();
					System.out.println(downpri);
				
						Report.put("Click on an Advisory ID ",
								"A link called \"Download\" under the \"Actions\" section in the modal view",
								"Clicked on "+Report.color(advid)+" and able to see  "+Report.color(Acts)+" and "+Report.color(downpri)+" under Actions heading" , "PASS");	
					}
					else
					{
						System.out.println("Failed to see article id");

						Report.put("Click on an Advisory ID ",
								"A link called \"Download\" under the \"Actions\" section in the modal view",
								"Failed to see article id", "FAIL");						
						Assert.fail();
					}
			} 
			catch(Exception e)
			{
				e.printStackTrace();
				
				Report.put("Click on an Advisory ID ",
						"A link called \"Download\" under the \"Actions\" section in the modal view",
						"Failed to see article id", "FAIL");				
				Assert.fail();
			}
		}
		
		
		public void MouseHoverOnDownloadLink_Phase2(WebDriver driver)
		{
			System.out.println("Inside MouseHoverOnDownloadLink_Phase2 method");
			Log.info("Inside MouseHoverOnDownloadLink_Phase2 method");

			WebDriverWait wait = new WebDriverWait(driver, 600);
			
			String link = "";
			String downpri = "";
			String Acts="";
			try
			{		

				if(CommonUtility.CheckpresenceofElementLocated(driver, 150, obj_PortalPage.DownloadOrPrintLink()))
				{
					
					CommonUtility.ScrollTo(driver,obj_PortalPage.DownloadOrPrintLink());
					link=CommonUtility.highlightElement(driver,obj_PortalPage.DownloadOrPrintLink()).getAttribute("href");
					System.out.println(link);
					
					if(link.contains("https://www.dell.com/support/kbdoc/printview"))
					{
						Report.put("Hover the mouse on the Download link",
								"The link should be displayed as below https://www.dell.com/support/kbdoc/en-us/printview/<articleNumber>/<accessLevel>/en",
								"Mouse overing on Download/print able to see "+Report.color(link) , "PASS");
					}
					else
					{
						Report.put("Hover the mouse on the Download link",
								"The link should be displayed as below https://www.dell.com/support/kbdoc/en-us/printview/<articleNumber>/<accessLevel>/en",
								"Failed to see expected link", "FAIL");						
						Assert.fail();
					}
					
					}
					else
					{
						System.out.println("Failed to see download link");

						Report.put("Hover the mouse on the Download link",
								"The link should be displayed as below https://www.dell.com/support/kbdoc/en-us/printview/<articleNumber>/<accessLevel>/en",
								"Failed to see expected link", "FAIL");						
						Assert.fail();
					}
			} 
			catch(Exception e)
			{
				e.printStackTrace();
				
				Report.put("Hover the mouse on the Download link",
						"The link should be displayed as below https://www.dell.com/support/kbdoc/en-us/printview/<articleNumber>/<accessLevel>/en",
						"Failed to see expected link", "FAIL");				
				Assert.fail();
			}
		}
		
		public void ClickOnDownloadOrPrintLink_Phase2(WebDriver driver)
		{
			System.out.println("Inside ClickOnDownloadOrPrintLink_Phase2 method");
			Log.info("Inside ClickOnDownloadOrPrintLink_Phase2 method");

			WebDriverWait wait = new WebDriverWait(driver, 600);
			
			String link = "";
			String url = "";
			String header="";
			String print="";
			try
			{		

				if(CommonUtility.CheckpresenceofElementLocated(driver, 30, obj_PortalPage.DownloadOrPrintLink()))
				{
					CommonUtility.ScrollTo(driver,obj_PortalPage.DownloadOrPrintLink());
					link=CommonUtility.highlightElement(driver,obj_PortalPage.DownloadOrPrintLink()).getText();
					System.out.println(link);
					CommonUtility.ClickOn(driver,obj_PortalPage.DownloadOrPrintLink());
					Thread.sleep(6000);
					String mainwindow=driver.getWindowHandle();
					Set<String> set=driver.getWindowHandles();
					int countWindow=set.size(); 

					System.out.println("Switched Window Handles and  window count is :: "+countWindow);
					Thread.sleep(10000);
					
					Iterator<String> itr=set.iterator();
					while(itr.hasNext())
					{
						String childWindow=itr.next();
						if(!mainwindow.equals(childWindow))
						{
							Thread.sleep(5000);
							Thread.sleep(10000);
							driver.switchTo().window(childWindow);
						
						url=driver.getCurrentUrl();
						System.out.println("URL displayed as   :::::"+url); 

						if(url.contains("printview"))
						{
							url = driver.getCurrentUrl();
							System.out.println("Switched to window & URL is "+url);		
							
							wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.HeaderOfPrintableViewArticle()));
							CommonUtility.ScrollTo(driver,obj_PortalPage.HeaderOfPrintableViewArticle());
							header = CommonUtility.highlightElement(driver,obj_PortalPage.HeaderOfPrintableViewArticle()).getText();

							System.out.println("Header is: "+header);
							CommonUtility.ScrollTo(driver,obj_PortalPage.PrintButtonInPrintableView());
							print = CommonUtility.highlightElement(driver,obj_PortalPage.PrintButtonInPrintableView()).getText();

							System.out.println("link is: "+print);
							
													
						}	
						else
						{
							driver.close();

							System.out.println("Failed to redirect to expected url ");

							Report.put("Click on the Download link ",
									"User should be redirected to the printable articles page in a new tab",
									"Failed to redirect to expected url", "FAIL");
							Assert.fail();
						}
						
						driver.close();
						
					}
						
						driver.switchTo().window(mainwindow);
					}
					Report.put("Click on the Download link ",
							"User should be redirected to the printable articles page in a new tab",
							"User able to click on Download/Print link and able to bnavigate with title "+Report.color(header)+" with "+Report.color(print)+" button with url "+Report.color(url), "Pass");
					}
					else
					{
						System.out.println("Failed to see download/print link");

						Report.put("Click on the Download link ",
								"User should be redirected to the printable articles page in a new tab",
								"Failed to see download/print link", "FAIL");
						Assert.fail();
					}
			} 
			catch(Exception e)
			{
				e.printStackTrace();
				
				Report.put("Click on the Download link ",
						"User should be redirected to the printable articles page in a new tab",
						"Failed to see download/print link", "FAIL");
				Assert.fail();
			}
		}
		
		public void clickTechnicalAdvisoryTab_Phase2(WebDriver driver)
		{
			System.out.println("Inside clickTechnicalAdvisoryTab_Phase2 method");
			Log.info("Inside clickTechnicalAdvisoryTab_Phase2 method");

			WebDriverWait wait = new WebDriverWait(driver, 600);
			
			String securityTab = "";
			String columns = "";
			try
			{		

				if(CommonUtility.CheckpresenceofElementLocated(driver, 300, obj_PortalPage.DellTechnicalAdvisoriesTab()))
				{
					CommonUtility.ScrollTo(driver,obj_PortalPage.DellTechnicalAdvisoriesTab());
					securityTab = CommonUtility.highlightElement(driver,obj_PortalPage.DellTechnicalAdvisoriesTab()).getText();

					
					System.out.println("Security Advisory Tab is: "+securityTab);

					CommonUtility.ClickOn(driver,obj_PortalPage.DellTechnicalAdvisoriesTab());
					
					Thread.sleep(5000);
					
					wait.until(ExpectedConditions.presenceOfElementLocated(obj_PortalPage.TechnicalAdvisoryTabAfterClickingOnIt()));
					wait.until(ExpectedConditions.presenceOfElementLocated(obj_PortalPage.DownArrowMarkToExpandSecurityAdvisory()));
				
						Report.put("Click on the Dell Technical Advisories tab ",
								"User should be navigated to the new DSA page.",
								"Clicked on tab "+Report.color(securityTab) , "PASS");	
					}
					else
					{
						System.out.println("Failed to click on Technical Advisory Tab");

						Report.put("Click on the Dell Technical Advisories tab ",
								"User should be navigated to the new DSA page.",
								"Failed to click  Technical Advisory Tab", "FAIL");						
						Assert.fail();
					}
			} 
			catch(Exception e)
			{
				e.printStackTrace();
				System.out.println("Failed to display Technical Adivsories Tab in the left");

				Report.put("Click on the Dell Technical Advisories tab ",
						"User should be navigated to the new DSA page.",
						"Failed to click  Technical Advisory Tab", "FAIL");				
				Assert.fail();
			}
		}
		
		public void clickOnAdvisoryID_Phase2_SecurityAdv(WebDriver driver)
		{
			System.out.println("Inside clickOnAdvisoryID_Phase2_SecurityAdv method");
			Log.info("Inside clickOnAdvisoryID_Phase2_SecurityAdv method");

			WebDriverWait wait = new WebDriverWait(driver, 600);
			
			String advid = "";
			String downpri = "";
			String Acts="";
			String text1="";
			try
			{		

				if(CommonUtility.CheckpresenceofElementLocated(driver, 30, obj_PortalPage.AdvisoryIDLink()))
				{
					CommonUtility.ScrollTo(driver,obj_PortalPage.AdvisoryIDLink());
					advid=CommonUtility.highlightElement(driver,obj_PortalPage.AdvisoryIDLink()).getText();
					System.out.println(advid);
					CommonUtility.ClickOn(driver,obj_PortalPage.AdvisoryIDLink());
					
					Thread.sleep(5000);
					
					wait.until(ExpectedConditions.presenceOfElementLocated(obj_PortalPage.AdvisoryPopUpHeader()));
					CommonUtility.ScrollTo(driver,obj_PortalPage.SeeFullSecurityOrTechnicalAdvisoryLinkText());
					Acts=CommonUtility.highlightElement(driver,obj_PortalPage.SeeFullSecurityOrTechnicalAdvisoryLinkText()).getText();
					System.out.println(Acts);
					
					CommonUtility.ScrollTo(driver,obj_PortalPage.DocumentationHeading());
					downpri=CommonUtility.highlightElement(driver,obj_PortalPage.DocumentationHeading()).getText();
					System.out.println(downpri);
					
					List<WebElement> list=driver.findElements(obj_PortalPage.DocumentationLinks());


					for(WebElement lt:list)
					{
						CommonUtility.ScrollToWebElement(driver, lt);
						String heading=lt.getText();

						System.out.println(heading);

						text1+=" <br> "+heading;
					}
					System.out.println("links are "+text1);
					
						Report.put("Click on any Advisory ID, ",
								"User should see See Full advisory link and documents",
								"Clicked on "+Report.color(advid)+" and able to see  "+Report.color(Acts)+" and "+Report.color(downpri)+" along with links "+Report.color(text1) , "PASS");	
					}
					else
					{
						System.out.println("Failed to see article id");

						Report.put("Click on any Advisory ID, ",
								"User should see See Full advisory link and documents",
								"Failed to see article id", "FAIL");						
						Assert.fail();
					}
			} 
			catch(Exception e)
			{
				e.printStackTrace();
				
				Report.put("Click on any Advisory ID, ",
						"User should see See Full advisory link and documents",
						"Failed to see article id", "FAIL");				
				Assert.fail();
			}
		}
		
		
		public void MouseHoverOnSeeFullAdvisoryLink_Phase2(WebDriver driver)
		{
			System.out.println("Inside MouseHoverOnSeeFullAdvisoryLink_Phase2 method");
			Log.info("Inside MouseHoverOnSeeFullAdvisoryLink_Phase2 method");

			WebDriverWait wait = new WebDriverWait(driver, 600);
			
			String link = "";
			String downpri = "";
			String Acts="";
			try
			{		

				if(CommonUtility.CheckpresenceofElementLocated(driver, 150, obj_PortalPage.SeeFullSecurityOrTechnicalAdvisoryLink()))
				{
					
					CommonUtility.ScrollTo(driver,obj_PortalPage.SeeFullSecurityOrTechnicalAdvisoryLink());
					link=CommonUtility.highlightElement(driver,obj_PortalPage.SeeFullSecurityOrTechnicalAdvisoryLink()).getAttribute("href");
					System.out.println(link);
					
					if(link.contains("https://www.dell.com/support/kbdoc/"))
					{
						Report.put("Hover the mouse over on the link \"See Full Security Advisory\"",
								"User should see the below URL displayed \"https://www.dell.com/support/kbdoc/<articleNumber>/<title>\"",
								"Mouse overing on See full advisory able to see "+Report.color(link) , "PASS");
					}
					else
					{
						Report.put("Hover the mouse over on the link \"See Full Security Advisory\"",
								"User should see the below URL displayed \"https://www.dell.com/support/kbdoc/<articleNumber>/<title>\"",
								"Failed to see expected link", "FAIL");						
						Assert.fail();
					}
					
					}
					else
					{
						System.out.println("Failed to see download link");

						Report.put("Hover the mouse over on the link \"See Full Security Advisory\"",
								"User should see the below URL displayed \"https://www.dell.com/support/kbdoc/<articleNumber>/<title>\"",
								"Failed to see expected link", "FAIL");						
						Assert.fail();
					}
			} 
			catch(Exception e)
			{
				e.printStackTrace();
				
				Report.put("Hover the mouse over on the link \"See Full Security Advisory\"",
						"User should see the below URL displayed \"https://www.dell.com/support/kbdoc/<articleNumber>/<title>\"",
						"Failed to see expected link", "FAIL");				
				Assert.fail();
			}
		}
		
		public void ClickOnSellAllAdvisory_Phase2(WebDriver driver)
		{
			System.out.println("Inside ClickOnSellAllAdvisory_Phase2 method");
			Log.info("Inside ClickOnSellAllAdvisory_Phase2 method");

			WebDriverWait wait = new WebDriverWait(driver, 600);
			
			String link = "";
			String url = "";
			String header="";
			String print="";
			try
			{		

				if(CommonUtility.CheckpresenceofElementLocated(driver, 30, obj_PortalPage.SeeFullSecurityOrTechnicalAdvisoryLink()))
				{
					CommonUtility.ScrollTo(driver,obj_PortalPage.SeeFullSecurityOrTechnicalAdvisoryLink());
					link=CommonUtility.highlightElement(driver,obj_PortalPage.SeeFullSecurityOrTechnicalAdvisoryLinkText()).getText();
					System.out.println(link);
					CommonUtility.ClickOn(driver,obj_PortalPage.SeeFullSecurityOrTechnicalAdvisoryLink());
					Thread.sleep(6000);
					String mainwindow=driver.getWindowHandle();
					Set<String> set=driver.getWindowHandles();
					int countWindow=set.size(); 

					System.out.println("Switched Window Handles and  window count is :: "+countWindow);
					Thread.sleep(10000);
					
					Iterator<String> itr=set.iterator();
					while(itr.hasNext())
					{
						String childWindow=itr.next();
						if(!mainwindow.equals(childWindow))
						{
							Thread.sleep(5000);
							Thread.sleep(10000);
							driver.switchTo().window(childWindow);
						
						url=driver.getCurrentUrl();
						System.out.println("URL displayed as   :::::"+url); 

						if(url.contains("https://www.dell.com/support/kbdoc/en-us/"))
						{
							url = driver.getCurrentUrl();
							System.out.println("Switched to window & URL is "+url);		
							
							wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.HeaderOfPrintableViewArticle()));
							CommonUtility.ScrollTo(driver,obj_PortalPage.HeaderOfPrintableViewArticle());
							header = CommonUtility.highlightElement(driver,obj_PortalPage.HeaderOfPrintableViewArticle()).getText();

							System.out.println("Header is: "+header);
									
						}	
						else
						{
							driver.close();

							System.out.println("Failed to redirect to expected url ");

							Report.put("Click on the link \"See Full Security Advisory\"",
									"User should be redirected to the the below URL displayed \"https://www.dell.com/support/kbdoc/<articleNumber>/<title>\"",
									"Failed to redirect to expected url", "FAIL");
							Assert.fail();
						}
						
						driver.close();
						
					}
						
						driver.switchTo().window(mainwindow);
					}
					Report.put("Click on the link \"See Full Security Advisory\"",
							"User should be redirected to the the below URL displayed \"https://www.dell.com/support/kbdoc/<articleNumber>/<title>\"",
							"User able to click on "+Report.color(link)+" link and able to navigate with title "+Report.color(header)+" button with url "+Report.color(url), "Pass");
					}
					else
					{
						System.out.println("Failed to see \"See Full Security Advisory\" link");

						Report.put("Click on the link \"See Full Security Advisory\"",
								"User should be redirected to the the below URL displayed \"https://www.dell.com/support/kbdoc/<articleNumber>/<title>\"",
								"Failed to see \"See Full Security Advisory\"", "FAIL");
						Assert.fail();
					}
			} 
			catch(Exception e)
			{
				e.printStackTrace();
				
				Report.put("Click on the link \"See Full Security Advisory\"",
						"User should be redirected to the the below URL displayed \"https://www.dell.com/support/kbdoc/<articleNumber>/<title>\"",
						"Failed to see \"See Full Security Advisory\" link", "FAIL");
				Assert.fail();
			}
		}
		
		public void MouseHoverOnDocumentsLink_Phase2(WebDriver driver)
		{
			System.out.println("Inside MouseHoverOnDocumentsLink_Phase2 method");
			Log.info("Inside MouseHoverOnDocumentsLink_Phase2 method");

			WebDriverWait wait = new WebDriverWait(driver, 600);
			
			String link = "";
			String downpri = "";
			String Acts="";
			String text1="";
			String text2="";String header="";String url="";
			try
			{		

				if(CommonUtility.CheckpresenceofElementLocated(driver, 150, obj_PortalPage.DocumentationLinks()))
				{
					
					List<WebElement> list=driver.findElements(obj_PortalPage.DocumentationLinks());


					for(int i=0;i<list.size();i++)
					{
						CommonUtility.ScrollToWebElement(driver, list.get(i));
						String heading=list.get(i).getText();
						String links=list.get(i).getAttribute("href");
						System.out.println(heading);

						text1+=" <br> "+heading;
						
						text2+=" <br> "+links;
					
					
					text1=text1.toLowerCase();
					
					if(text1.contains("technical advisory document") || text1.contains("security advisory document"))
					{
						CommonUtility.ScrollToWebElement(driver, list.get(i));
						CommonUtility.ClickOnWebElement(driver, list.get(i));
					
					Thread.sleep(6000);
					String mainwindow=driver.getWindowHandle();
					Set<String> set=driver.getWindowHandles();
					int countWindow=set.size(); 

					System.out.println("Switched Window Handles and  window count is :: "+countWindow);
					Thread.sleep(10000);
					
					Iterator<String> itr=set.iterator();
					while(itr.hasNext())
					{
						String childWindow=itr.next();
						if(!mainwindow.equals(childWindow))
						{
							Thread.sleep(5000);
							Thread.sleep(10000);
							driver.switchTo().window(childWindow);
						
						url=driver.getCurrentUrl();
						System.out.println("URL displayed as   :::::"+url); 

						if(url.contains("https://www.dell.com/support/kbdoc/en-us/"))
						{
							url = driver.getCurrentUrl();
							System.out.println("Switched to window & URL is "+url);		
							
							wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.HeaderOfPrintableViewArticle()));
							CommonUtility.ScrollTo(driver,obj_PortalPage.HeaderOfPrintableViewArticle());
							header = CommonUtility.highlightElement(driver,obj_PortalPage.HeaderOfPrintableViewArticle()).getText();

							System.out.println("Header is: "+header);
									
						}	
						else
						{
							driver.close();

							System.out.println("Failed to redirect to expected url ");

							Report.put("Click on the link \"Security advisory document\" if only that is present else user sees the multiple links",
									"User should see the below URL displayed \"https://www.dell.com/support/kbdoc/<articleNumber>/<URL Name>\"",
									"Failed to redirect to expected url", "FAIL");
							Assert.fail();
						}
						
						driver.close();
						
					}
						
						driver.switchTo().window(mainwindow);
						
					}
					Report.put("Click on the link \"Security advisory document\" if only that is present else user sees the multiple links",
							"User should see the below URL displayed \"https://www.dell.com/support/kbdoc/<articleNumber>/<URL Name>\"",
							"User able to click on "+Report.color(text1)+" and clicking on it redirected to url "+Report.color(url),"PASS");
					}
					
					}
					System.out.println("headings are "+text1);
					System.out.println("links are "+text2);
					Report.put("Hover the mouse over the link \"Security advisory document \" or User can see the multiple links below Documentation ",
							"User should see the below URL displayed \"https://www.dell.com/support/kbdoc/<articleNumber>/<URL Name>\" or Multiple links should be present under Documentation(depending on data)",
							"Mouse hovering on "+Report.color(text1)+" able to see links displayed respectively "+Report.color(text2) , "PASS");	
				
					}
					else
					{
						System.out.println("Failed to see documents links link");

						Report.put("Hover the mouse over the link \"Security advisory document \" or User can see the multiple links below Documentation ",
								"User should see the below URL displayed \"https://www.dell.com/support/kbdoc/<articleNumber>/<URL Name>\" or Multiple links should be present under Documentation(depending on data)",
								"Failed to see expected link", "FAIL");						
						Assert.fail();
					}
			} 
			catch(Exception e)
			{
				e.printStackTrace();
				
				Report.put("Hover the mouse over the link \"Security advisory document \" or User can see the multiple links below Documentation ",
						"User should see the below URL displayed \"https://www.dell.com/support/kbdoc/<articleNumber>/<URL Name>\" or Multiple links should be present under Documentation(depending on data)",
						"Failed to see expected link", "FAIL");				
				Assert.fail();
			}
		}
		
		public void VerifySearchBoxSearchingAnyCharacters_ExpandedView_IMTab(WebDriver driver)
		{

			Log.info("Entering VerifySearchBoxSearchingAnyCharacters_ExpandedView_IMTab method");	
			WebDriverWait wait = new WebDriverWait(driver, 120);
			Actions act=new Actions(driver);
			String placeholder="";
			String header="";
			String displayedvalues="";
			String displayedvalues1="";
			String displayedvalues2="";
			String message="";
			String value=TestNGCreator.TestData.get(Esupport.SearchOption.ordinal());
			try
			{
				if(CommonUtility.CheckpresenceofElementLocated(driver, 15, obj_PortalPage.SearchTextBox()))
				{

					CommonUtility.ScrollTo(driver,obj_PortalPage.SearchTextBox());	
					placeholder=CommonUtility.highlightElement(driver,obj_PortalPage.SearchTextBox()).getAttribute("placeholder");
					System.out.println(placeholder);
					CommonUtility.highlightElement(driver,obj_PortalPage.SearchTextBox()).clear();
					CommonUtility.highlightElement(driver,obj_PortalPage.SearchTextBox()).sendKeys(value);

					CommonUtility.ScrollTo(driver,obj_PortalPage.SearchButton());
					CommonUtility.ClickOn(driver,obj_PortalPage.SearchButton());

					if(CommonUtility.CheckpresenceofElementLocated(driver, 15, obj_PortalPage.CountOfRowsDisplayed()))
					{

						List<WebElement> list=driver.findElements(obj_PortalPage.CountOfRowsDisplayed());
						List<WebElement> list1=driver.findElements(obj_PortalPage.RowsDisplayedUnderTable1());
						List<WebElement> list2=driver.findElements(obj_PortalPage.ValuesDisplayedUnderOtherDetailsTable());
						int count=list.size();
						System.out.println("count of values displayed are "+count);
						for(WebElement lt:list)
						{
							CommonUtility.highlightElement(driver, lt);
							String tabName=lt.getText();

							System.out.println("Tab is: " +tabName);
							displayedvalues+=" <br> " + tabName;
						}
						System.out.println("Tabs are:"+displayedvalues);

						int counts=0;
						for(WebElement lt:list1)
						{
							CommonUtility.scrollToViewElement(driver, lt);
							CommonUtility.highlightElement(driver, lt);
							String tabName=lt.getText();

							System.out.println("Tab is: " +tabName);
							displayedvalues1+=" <br> " + tabName;

							if(displayedvalues1.contains(value))
							{
								counts++;

							}
						}
						System.out.println("Tabs are:"+displayedvalues1);

						System.out.println("count of matching in first table are "+counts);

						int countss=0;
						for(WebElement lt:list2)
						{
							CommonUtility.highlightElement(driver, lt);
							String tabName=lt.getText();

							System.out.println("Tab is: " +tabName);
							displayedvalues2+=" <br> " + tabName;

							if(displayedvalues1.contains(value))
							{
								countss++;
							}
						}
						System.out.println("Tabs are:"+displayedvalues2);

						System.out.println("count of matching in second table are "+countss);

						int total=counts+countss;
						System.out.println("total count is "+total);


						Report.put("User verifies he/she is be able to see a search box  in View All screen and types in characters in the search box and hit enter or click on search icon", 
								"An expanded full screen should open up & Data should be filtered based on the search text ‘<searchText>example:searchText :66785" ,
								"user enters data as "+Report.color(value)+" in search box and able to click on search button and <br> expanded full view with header "+Report.color(header)+" displayed <br> with filtered searched data and count of displayed results are "+count+" along with SR number displayed "+Report.color(displayedvalues1), "PASS");

					}
					else
					{

						wait.until(ExpectedConditions.visibilityOfElementLocated(obj_PortalPage.HeaderOfThePopUp()));


						CommonUtility.scrollToViewElement(driver,obj_PortalPage.SearchedDataNotFoundMessage());	
						message=CommonUtility.highlightElement(driver,obj_PortalPage.SearchedDataNotFoundMessage()).getText();
						System.out.println("header is "+message);

						System.out.println("page size section not displayed");
						Report.put("User verifies he/she is be able to see a search box  in View All screen and types in characters in the search box and hit enter or click on search icon", 
								"An expanded full screen should open up & Data should be filtered based on the search text ‘<searchText>example:searchText :66785" ,
								"Searched data not found and display message as "+Report.color(message), "PASS");

					}
				}

				else
				{
					System.out.println("search text box not found");
					Report.put("User verifies he/she is be able to see a search box  in View All screen and types in characters in the search box and hit enter or click on search icon", 
							"An expanded full screen should open up & Data should be filtered based on the search text ‘<searchText>example:searchText :66785" ,
							"not able to see search text box", "FAIL");
					Assert.fail();
				}
			}
			catch(Exception e)
			{
				Log.info(e);
				Report.put("User verifies he/she is be able to see a search box  in View All screen and types in characters in the search box and hit enter or click on search icon", 
						"An expanded full screen should open up & Data should be filtered based on the search text ‘<searchText>example:searchText :66785" ,
						"not able to see search text box", "FAIL");
				e.printStackTrace();
				Assert.fail();
			}

		} 
		
		public void getIncidentManagementOpenSRHUDvalue(WebDriver driver)
		{
			System.out.println("Inside getIncidentManagementOpenSRHUDvalue method");
			Log.info("Inside getIncidentManagementOpenSRHUDvalue method");
			
			String totalSRHudValue = "";
			
			try
			{		
				if(CommonUtility.CheckpresenceofElementLocated(driver, 30, obj_PortalPage.incidentManagementTotalSRHudValue()))
				{
					
					totalSRHudValue = CommonUtility.highlightElement(driver,obj_PortalPage.incidentManagementTotalSRHudValue()).getText();
				
					System.out.println("Open SR Hud Value is: "+totalSRHudValue);
					
					if(totalSRHudValue!=null)
					{
						Report.put("User sees the Total SRs tab based on Open SRs",
								"User should be able to see the Total SRs tab based on Open SRs as SR status should be pre-filtered to open (which includes Working , Assigning & Complete)",
								"Displayed corresponding values for Open SRs"+Report.color(totalSRHudValue), "PASS");	
					}
					else
					{
						System.out.println("Failed to display  Open SRs value");
						Report.put("User sees the Total SRs tab based on Open SRs",
								"User should be able to see the Total SRs tab based on Open SRs as SR status should be pre-filtered to open (which includes Working , Assigning & Complete)",
								"Failed to display corresponding values for Open SRs", "FAIL");						
						Assert.fail();
					}
				}
				else
				{
					System.out.println("Failed to display  Open SRs value");
					Report.put("User sees the Total SRs tab based on Open SRs",
							"User should be able to see the Total SRs tab based on Open SRs as SR status should be pre-filtered to open (which includes Working , Assigning & Complete)",
							"Failed to display corresponding values for Open SRs", "FAIL");							
					Assert.fail();
				}										
			} 
			catch(Exception e)
			{
				e.printStackTrace();
				System.out.println("Failed to display  Open SRs value");
				Report.put(" User verifies if the icon for Open SRs based on Total SRs is displayed ",
						"User should be able to see the icon for Open SRs based on Total SRs and user should be able to see the count of Open SRs based on Total SRs over the past 2 years",
						"Failed to display corresponding values for Open SRs", "FAIL");				
				Assert.fail();	
			}
		}
		
		
		public void verifyIncidentManagementFiltersDisplayDefault(WebDriver driver)
		{
			System.out.println("Inside verifyIncidentManagementFiltersDisplayDefault method");
			Log.info("Inside verifyIncidentManagementFiltersDisplayDefault method");


			String filterButton = "";
			String filterByHeader = "";
			String srFilterList = "";
			try
			{
				WebDriverWait wait = new WebDriverWait(driver, 120);

				CommonUtility.ScrollTo(driver,(obj_PortalPage.FiltersBreadsrumbOnPopUpForSRs()));
						

				List<WebElement> list=driver.findElements(obj_PortalPage.FiltersBreadsrumbOnPopUpForSRs());

				for(WebElement lt:list)
				{
					CommonUtility.highlightElement(driver, lt);
					String filterName=lt.getText();
					if(!(filterName.isEmpty()))
					{
						System.out.println("Filter is: " +filterName);
						srFilterList+=" <br> " + filterName;
					}
				}
				System.out.println("Filters are:"+srFilterList);

				Report.put("User verifies a Pre Filter applied on the tabular view",
						"A Pre Filter should be applied on the tabular view with Install Base Status & SR Status (to Open)",
						"SR specific filters are: "+Report.color(srFilterList), "PASS");
			} 
			catch(Exception e)
			{
				e.printStackTrace();

				Report.put("User verifies a Pre Filter applied on the tabular view",
						"A Pre Filter should be applied on the tabular view with Install Base Status & SR Status (to Open)",
						"Failed to display SR specific filters", "FAIL");
				Assert.fail();
			}
		}
		
		public void ValidateTotalSRsCircleInHUD(WebDriver driver)
		{

			Log.info("Entering ValidateTotalSRsCircleInHUD");	
			WebDriverWait wait = new WebDriverWait(driver, 120);
			String text="";
			String text1="";
			String text2="";
			String text3="";

//			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);

			try
			{
				CommonUtility.ScrollTo(driver,obj_PortalPage.TotalSRsCircleOnHUDAfterUnderIMTabsDefaultView());
				
				if(CommonUtility.CheckpresenceofElementLocated(driver, 33, obj_PortalPage.TotalSRsCircleOnHUDAfterUnderIMTabsDefaultView()))
				{
					
					CommonUtility.ScrollTo(driver,obj_PortalPage.TotalSRsCircleOnHUDAfterUnderIMTabsDefaultView());
					CommonUtility.highlightElement(driver,obj_PortalPage.TotalSRsCircleOnHUDAfterUnderIMTabsDefaultView());

					CommonUtility.ScrollTo(driver,obj_PortalPage.NameDisplayedINKPIForIncidentManagementByDefault());
					text2=CommonUtility.highlightElement(driver,obj_PortalPage.NameDisplayedINKPIForIncidentManagementByDefault()).getText(); 
					System.out.println("value displayed by total  "+text2);

					CommonUtility.ScrollTo(driver,obj_PortalPage.ValueDisplayedINKPIForIncidentManagementByDefault());
					text3=CommonUtility.highlightElement(driver,obj_PortalPage.ValueDisplayedINKPIForIncidentManagementByDefault()).getText(); 
					System.out.println("value displayed by total  "+text3);

					System.out.println("text displayed in HUD under IM tab total SRs context are "+text3+" "+text2);

					Report.put("Verify the KPI displayed at the top", 
							"The KPI for Total SRs displayed as the primary KPI" ,
							"User able to see circle highlighted and displayed Total SRs as "+text3+" "+text2, "PASS");



					CommonUtility.ScrollTo(driver,obj_PortalPage.Severity1OnHUDUnderTotalSRsContext());
					String sev1=CommonUtility.highlightElement(driver,obj_PortalPage.Severity1OnHUDUnderTotalSRsContext()).getAttribute("value"); 
					System.out.println("number of sev1 number of SRs displayed are "+sev1);

					CommonUtility.ScrollTo(driver,obj_PortalPage.Severity2OnHUDUnderTotalSRsContext());
					String sev2=CommonUtility.highlightElement(driver,obj_PortalPage.Severity2OnHUDUnderTotalSRsContext()).getAttribute("value"); 
					System.out.println("number of sev2 number of SRs displayed are  "+sev2);

					CommonUtility.ScrollTo(driver,obj_PortalPage.Severity3OnHUDUnderTotalSRsContext());
					String sev3=CommonUtility.highlightElement(driver,obj_PortalPage.Severity3OnHUDUnderTotalSRsContext()).getAttribute("value"); 
					System.out.println("number of sev3 number of SRs displayed are  "+sev3);

					CommonUtility.ScrollTo(driver,obj_PortalPage.OthersOnHUDUnderTotalSRsContext());
					String others=CommonUtility.highlightElement(driver,obj_PortalPage.OthersOnHUDUnderTotalSRsContext()).getAttribute("value"); 
					System.out.println("number of others number of SRs displayed are  "+others);


					Report.put(" Verify the data arcs displayed in the KPI", 
							"All the data arcs (S1 + S2 + S3  + Others) are displayed in highlighted blue color at all times" ,
							"User able to see arcs of S1 number of SRs "+Report.color(sev1)+" and arcs of S2 number of SRs"+Report.color(sev2)+" <br> and arcs of S3 number of SRs"+Report.color(sev3)+" and arcs of others number of SRs"+Report.color(others)+" and displayed in highlighted blue color at all times", "PASS");
				}
				else 
					if(CommonUtility.CheckpresenceofElementLocated(driver, 33, obj_PortalPage.TotalSRsCircleOnHUDAfterUnderIMTabsDefaultView_IE()))
					{
						
						CommonUtility.ScrollTo(driver,obj_PortalPage.TotalSRsCircleOnHUDAfterUnderIMTabsDefaultView_IE());
						CommonUtility.highlightElement(driver,obj_PortalPage.TotalSRsCircleOnHUDAfterUnderIMTabsDefaultView_IE());
						Thread.sleep(6000);
						CommonUtility.ScrollTo(driver,obj_PortalPage.NameDisplayedINKPIForIncidentManagementByDefault_IE());
						text2=CommonUtility.highlightElement(driver,obj_PortalPage.NameDisplayedINKPIForIncidentManagementByDefault_IE()).getText(); 
						System.out.println("value displayed by total  "+text2);
						Thread.sleep(6000);
						CommonUtility.ScrollTo(driver,obj_PortalPage.ValueDisplayedINKPIForIncidentManagementByDefault_IE());
						text3=CommonUtility.highlightElement(driver,obj_PortalPage.ValueDisplayedINKPIForIncidentManagementByDefault_IE()).getText(); 
						System.out.println("value displayed by total  "+text3);

						System.out.println("text displayed in HUD under IM tab total SRs context are "+text3+" "+text2);

						Report.put("Verify the KPI displayed at the top", 
								"The KPI for Total SRs displayed as the primary KPI" ,
								"User able to see circle highlighted and displayed Total SRs as "+text3+" "+text2, "PASS");



						CommonUtility.ScrollTo(driver,obj_PortalPage.Severity1OnHUDUnderTotalSRsContext());
						String sev1=CommonUtility.highlightElement(driver,obj_PortalPage.Severity1OnHUDUnderTotalSRsContext()).getAttribute("value"); 
						System.out.println("number of sev1 number of SRs displayed are "+sev1);
						Thread.sleep(6000);
						CommonUtility.ScrollTo(driver,obj_PortalPage.Severity2OnHUDUnderTotalSRsContext());
						String sev2=CommonUtility.highlightElement(driver,obj_PortalPage.Severity2OnHUDUnderTotalSRsContext()).getAttribute("value"); 
						System.out.println("number of sev2 number of SRs displayed are  "+sev2);
						Thread.sleep(6000);
						CommonUtility.ScrollTo(driver,obj_PortalPage.Severity3OnHUDUnderTotalSRsContext());
						String sev3=CommonUtility.highlightElement(driver,obj_PortalPage.Severity3OnHUDUnderTotalSRsContext()).getAttribute("value"); 
						System.out.println("number of sev3 number of SRs displayed are  "+sev3);
						Thread.sleep(6000);
						CommonUtility.ScrollTo(driver,obj_PortalPage.OthersOnHUDUnderTotalSRsContext());
						String others=CommonUtility.highlightElement(driver,obj_PortalPage.OthersOnHUDUnderTotalSRsContext()).getAttribute("value"); 
						System.out.println("number of others number of SRs displayed are  "+others);


						Report.put(" Verify the data arcs displayed in the KPI", 
								"All the data arcs (S1 + S2 + S3  + Others) are displayed in highlighted blue color at all times" ,
								"User able to see arcs of S1 number of SRs "+Report.color(sev1)+" and arcs of S2 number of SRs"+Report.color(sev2)+" <br> and arcs of S3 number of SRs"+Report.color(sev3)+" and arcs of others number of SRs"+Report.color(others)+" and displayed in highlighted blue color at all times", "PASS");
					}
				
				else 
				{
					System.out.println("not able to see Expected circle in HUD");
					Report.put("Verify the KPI displayed at the top", 
							"The KPI for Total SRs displayed as the primary KPI" ,
							"Failed to to see Expected circle in HUD ", "FAIL");

					Assert.fail();
				}

			}
			catch(Exception e)
			{
				Log.info(e);
				System.out.println("not able to see Expected circle in HUD");
				Report.put("Verify the KPI displayed at the top", 
						"The KPI for Total SRs displayed as the primary KPI" ,
						"Failed to to see Expected circle in HUD ", "FAIL");
				e.printStackTrace();
				Assert.fail();
			}

		} 
}
