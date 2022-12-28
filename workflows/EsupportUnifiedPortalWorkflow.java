package com.dell.delta_uat_automation.esupport.workflows;

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

public class EsupportUnifiedPortalWorkflow extends BaseFlow 
{
	public void handleCookies(WebDriver driver)
	{
		System.out.println("Handle Cookies");
		Log.info("Handle Cookies");	
		WebDriverWait wait = new WebDriverWait(driver, 50);
		try
		{
			if(CommonUtility.CheckpresenceofElementLocated(driver, 10, obj_UnifiedPortalPage.acceptCookies()))
			{
				CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.acceptCookies()); 
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

	public void clickCustomGroups(WebDriver driver)
	{
		System.out.println("Inside clickCustomGroups method");
		Log.info("Inside clickCustomGroups method");

		String header = "";
		String tab = "";
		String myCustomGroupHeader = "";
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 600);

			wait.until(ExpectedConditions.presenceOfElementLocated(obj_UnifiedPortalPage.preferenceHeader()));
			CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.preferenceHeader());
			header = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.preferenceHeader()).getText();

			System.out.println("Header is: "+header);
			CommonUtility.ScrollTo(driver, obj_UnifiedPortalPage.customGroupsTab());
			tab = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.customGroupsTab()).getText();

			System.out.println("Clicked on "+tab);
			Thread.sleep(15000);


			CommonUtility.ClickOn(driver, obj_UnifiedPortalPage.customGroupsTab());
			//CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.customGroupsTab()).click();	
			Thread.sleep(6000);
			Thread.sleep(6000);
			CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.MyCustomeGroupsHeading());
			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_UnifiedPortalPage.MyCustomeGroupsHeading()))
			{
				//			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_UnifiedPortalPage.myCustomGroupHeader()));
				myCustomGroupHeader = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.MyCustomeGroupsHeading()).getText();

				System.out.println("My Custom Group Header is: "+myCustomGroupHeader);
				//			Thread.sleep(30000);
				//			wait.until(ExpectedConditions.presenceOfElementLocated(obj_UnifiedPortalPage.customGroupTableContent()));
				//				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.customGroupTableContent());
			}

			Report.put("User Navigates to the Preferences>>Custom Groups tab",
					"My Customs Group page should open with a list of custom groups created under it",
					Report.color(tab)+"displayed successfully.", "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("User Navigates to the Preferences>>Custom Groups tab",
					"My Customs Group page should open with a list of custom groups created under it",
					"Failed to load My Customs Group page", "FAIL");
			Assert.fail();
		}
	}

	public void createProductGroup(WebDriver driver)
	{
		System.out.println("Inside createProductGroup method");
		Log.info("Inside createProductGroup method");

		String addHeader = "";
		String createHeader = "";
		String tab = "";
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);

			CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.addCustomGroupButton());	

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_UnifiedPortalPage.addCustomGroupHeader()));
			addHeader = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.addCustomGroupHeader()).getText();

			System.out.println("Add Header is: "+addHeader);		

			CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.createProductGroupLink());	

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_UnifiedPortalPage.createProductGroupHeader()));
			CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.createProductGroupHeader());

			createHeader = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.createProductGroupHeader()).getText();

			System.out.println("Create Header is: "+createHeader);

			Report.put("User Clicks Add Custom Group, Add a custom group page opens. and Select Create a Product group.",
					"Add custom group page should be displayed",
					Report.color(createHeader)+"displayed successfully.", "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("User Clicks Add Custom Group, Add a custom group page opens. and Select Create a Product group.",
					"Add custom group page should be displayed",
					"Failed to display Add Custom Group page.", "FAIL");
			Assert.fail();
		}
	}


	public void enterProductGroupDetails(WebDriver driver, String name, String desc, String option)
	{
		System.out.println("Inside enterProductGroupDetails method");
		Log.info("Inside enterProductGroupDetails method");

		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);
			System.out.println("Name from Testdata is: "+name);		
			System.out.println("Description from Testdata is: "+desc);		
			System.out.println("Option from Testdata is: "+option);		

			CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.productGroupNameTextbox()).sendKeys(name);	

			CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.productGroupDescTextbox()).sendKeys(desc);					

			Select selOption = new  Select(driver.findElement(obj_UnifiedPortalPage.findProductsDropdown()));

			selOption.selectByVisibleText(option); 
			System.out.println("Selected: "+option);

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_UnifiedPortalPage.accountSiteList()));

			Report.put("Enter name and Description and select Account sites from Find products by dropdown.",
					"A list of sites should open",
					"Displayed list of sites successfully. Entered Details are: Name: "+Report.color(name)+"Desc:"+Report.color(desc) +"Selected Option:"+Report.color(option), "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Enter name and Description and select Account sites from Find products by dropdown.",
					"A list of sites should open",
					"Failed to display list of sites", "FAIL");
			Assert.fail();
		}
	}

	public void verifyAccountSitesCount(WebDriver driver)
	{
		System.out.println("Inside verifyAccountSitesCount method");
		Log.info("Inside verifyAccountSitesCount method");

		String accountCount = "";
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_UnifiedPortalPage.accountSitesCount()));
			accountCount = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.accountSitesCount()).getText();

			System.out.println("Account Site Details: "+accountCount);


			Report.put("User verifies that the total count of account sites are displayed on the Grid",
					"User should see the total count of account sites on the page",
					Report.color(accountCount)+"displayed successfully.", "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();

			Report.put("User verifies that the total count of account sites are displayed on the Grid",
					"User should see the total count of account sites on the page",
					"Failed to display Account Sites on the page", "FAIL");
			Assert.fail();
		}
	}

	public void searchProductId(WebDriver driver, String prodId)
	{
		System.out.println("Inside searchProductId method");
		Log.info("Inside searchProductId method");

		String productName = "";
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);

			System.out.println("Product ID from Testdata is: "+prodId);						

			CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.productIdTextbox()).sendKeys(prodId);	

			CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.productIdSearchButton());
			//CommonUtility.ToClickByUsingJavaScript_PassingByLoc(driver, obj_UnifiedPortalPage.productIdSearchButton());

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_UnifiedPortalPage.productIdTable()));

			//CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.productIdCheckbox()).click();

			CommonUtility.ClickOn(driver, obj_UnifiedPortalPage.productIdCheckbox());

			Thread.sleep(10000);
			CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.addToGroupButton());

			productName = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.productIdSecondGridProdName()).getText();

			System.out.println("Product Name in the Second grid is: "+productName);

			Report.put("User selects products and add to group.",
					"Selected products should be added in second grid.",
					"Selected product added to group successfully."+Report.color(productName), "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("User selects products and add to group.",
					"Selected products should be added in second grid.",
					"Failed to add Product to the group", "FAIL");
			Assert.fail();
		}
	}

	public void verifyCreateProductGroupFields(WebDriver driver)
	{
		System.out.println("Inside verifyCreateProductGroupFields method");
		Log.info("Inside verifyCreateProductGroupFields method");

		String labelList = "";

		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);

			List<WebElement> list=driver.findElements(obj_UnifiedPortalPage.createProductGroupFieldsLabel());

			for(WebElement lt:list)
			{
				CommonUtility.highlightElement(driver, lt);
				String label=lt.getText();

				System.out.println("Label is: " +label);
				labelList+=" <br> " + label;
			}
			System.out.println("Tabs are:"+labelList);					


			Report.put("User verifies under create product group. Name field, Description, Find Product by dropdown all are required fields ",
					"Title and Description of Custom Group should be displayed under grid.",
					"Displayed fields successfully."+Report.color(labelList), "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("User verifies under create product group. Name field, Description, Find Product by dropdown all are required fields ",
					"Title and Description of Custom Group should be displayed under grid.",
					"Failed to Display the required fields", "FAIL");
			Assert.fail();
		}
	}

	public void selectSiteAndAddToGroup(WebDriver driver)
	{
		System.out.println("Inside selectSiteAndAddToGroup method");
		Log.info("Inside selectSiteAndAddToGroup method");

		String header = "";

		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);

			CommonUtility.scrollToViewElement(driver,obj_UnifiedPortalPage.accountSiteCheckbox());

			CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.accountSiteCheckbox());	

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_UnifiedPortalPage.addToGroupButton()));
			Thread.sleep(5000);

			CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.addToGroupButton());

			CommonUtility.scrollToViewElement(driver,obj_UnifiedPortalPage.createCustomGroupButton());

			CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.createCustomGroupButton());	

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_UnifiedPortalPage.myCustomGroupHeader()));
			CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.myCustomGroupHeader());

			header = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.myCustomGroupHeader()).getText();

			System.out.println("Header is: "+header);

			Report.put("User selects any of the site and add a custom group",
					"Custom group should be created and user should be redirected to the home page",
					"Created Custom group & redirected to page"+Report.color(header), "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("User selects any of the site and add a custom group",
					"Custom group should be created and user should be redirected to the home page",
					"Failed to Create Custom group & redirect to homepage", "FAIL");
			Assert.fail();
		}
	}

	public void searchAccountSites(WebDriver driver, String input)
	{
		System.out.println("Inside searchAccountSites method");
		Log.info("Inside searchAccountSites method");

		String productName = "";
		String accountList = "";
		String defaultList = "";
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);

			System.out.println("Input from Testdata is: "+input);						
			Thread.sleep(10000);
			CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.accountSiteSearchTextbox()).sendKeys(input);	

			CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.accountSiteFilterButton());
			Thread.sleep(10000);
			//	CommonUtility.ToClickByUsingJavaScript_PassingByLoc(driver, obj_UnifiedPortalPage.accountSiteFilterButton());
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_UnifiedPortalPage.accountSiteFilterList()));
			List<WebElement> list=driver.findElements(obj_UnifiedPortalPage.accountSiteFilterList());

			for(WebElement lt:list)
			{
				CommonUtility.highlightElement(driver, lt);
				String text=lt.getText();

				String classValue = lt.getAttribute("class");

				System.out.println("Text is: " +text);
				accountList+=" <br> " + text;

			}
			System.out.println("Accounts are:"+accountList);	

			CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.accountSiteClearButton());

			List<WebElement> defaultLlist=driver.findElements(obj_UnifiedPortalPage.accountSiteFilterList());

			for(WebElement lt:defaultLlist)
			{
				CommonUtility.highlightElement(driver, lt);
				String text=lt.getText();

				System.out.println("Text is: " +text);
				defaultList+=" <br> " + text;

			}
			System.out.println("Default Accounts are:"+defaultList);	

			Report.put("Search any text and observe that text is highlighted. Click 'X' in text box and observe that Search text is cleared and default data set appears.",
					"On clicking 'X', Search text is cleared and default data set appears. ",
					"Searched for text "+Report.color(input) +".Filtered list of sites is: "+Report.color(accountList) +"<br>"+"Default List after clearing filter: "+Report.color(defaultList), "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Search any text and observe that text is highlighted. Click 'X' in text box and observe that Search text is cleared and default data set appears.",
					"On clicking 'X', Search text is cleared and default data set appears. ",
					"Failed to search the text", "FAIL");
			Assert.fail();
		}
	}

	public void selectProductAndAddToGroup(WebDriver driver)
	{
		System.out.println("Inside selectProductAndAddToGroup method");
		Log.info("Inside selectProductAndAddToGroup method");

		String header = "";

		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);

			CommonUtility.scrollToViewElement(driver,obj_UnifiedPortalPage.accountSiteDownArrowButton());

			CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.accountSiteDownArrowButton());	

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_UnifiedPortalPage.accountSiteProductCheckbox()));
			Thread.sleep(5000);

			CommonUtility.scrollToViewElement(driver,obj_UnifiedPortalPage.accountSiteProductCheckbox());
			CommonUtility.ClickOn(driver, obj_UnifiedPortalPage.accountSiteProductCheckbox());
			//CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.accountSiteProductCheckbox()).click();
			Thread.sleep(5000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_UnifiedPortalPage.addToGroupButton()));
			Thread.sleep(5000);

			CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.addToGroupButton());

			CommonUtility.scrollToViewElement(driver,obj_UnifiedPortalPage.createCustomGroupButton());

			CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.createCustomGroupButton());	

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_UnifiedPortalPage.myCustomGroupHeader()));
			CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.myCustomGroupHeader());

			header = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.myCustomGroupHeader()).getText();

			System.out.println("Header is: "+header);

			Report.put("User selects any of the product group and add a custom group",
					"Custom group should be created and user should be redirected to the home page",
					"Created Custom group & redirected to page"+Report.color(header), "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("User selects any of the product group and add a custom group",
					"Custom group should be created and user should be redirected to the home page",
					"Failed to Create Custom group & redirect to homepage", "FAIL");
			Assert.fail();
		}
	}

	public void verifyProductsCount(WebDriver driver)
	{
		System.out.println("Inside verifyProductsCount method");
		Log.info("Inside verifyProductsCount method");

		String productCount = "";
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);

			//			CommonUtility.scrollToViewElement(driver,obj_UnifiedPortalPage.accountSiteDownArrowButton());
			//			
			//			CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.accountSiteDownArrowButton()).click();	

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_UnifiedPortalPage.accountSiteCheckbox()));
			Thread.sleep(5000);

			CommonUtility.scrollToViewElement(driver,obj_UnifiedPortalPage.accountSiteCheckbox());
			CommonUtility.ClickOn(driver, obj_UnifiedPortalPage.accountSiteCheckbox());
			//CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.accountSiteProductCheckbox()).click();
			Thread.sleep(5000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_UnifiedPortalPage.addToGroupButton()));
			Thread.sleep(5000);

			CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.addToGroupButton());

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_UnifiedPortalPage.productsGroupCount()));
			productCount = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.productsGroupCount()).getText();

			System.out.println("Products count: "+productCount);


			Report.put("User verifies that the total count of My product groups are displayed on the Grid ",
					"User should see the total count of My Product groups on the page",
					Report.color(productCount)+"displayed successfully.", "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();

			Report.put("User verifies that the total count of My product groups are displayed on the Grid ",
					"User should see the total count of My Product groups on the page",
					"Failed to display Product Count on the page", "FAIL");
			Assert.fail();
		}
	}

	public void verifyAddToGroupButtonEnabled(WebDriver driver)
	{
		System.out.println("Inside verifyAddToGroupButtonEnabled method");
		Log.info("Inside verifyAddToGroupButtonEnabled method");

		String buttonName = "";
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);

			CommonUtility.scrollToViewElement(driver,obj_UnifiedPortalPage.accountSiteDownArrowButton());

			CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.accountSiteDownArrowButton());	

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_UnifiedPortalPage.accountSiteProductCheckbox()));
			Thread.sleep(5000);

			CommonUtility.scrollToViewElement(driver,obj_UnifiedPortalPage.accountSiteProductCheckbox());
			CommonUtility.ClickOn(driver, obj_UnifiedPortalPage.accountSiteProductCheckbox());
			//CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.accountSiteProductCheckbox()).click();
			Thread.sleep(5000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_UnifiedPortalPage.addToGroupButton()));
			Thread.sleep(5000);

			if(CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.addToGroupButton()).isEnabled())
			{

				buttonName = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.addToGroupButton()).getAttribute("value");

				System.out.println("Button is: "+buttonName);
				Report.put("User can expand each product group and get product associated.",
						"Add to group button should be enabled when user select any product.",
						Report.color(buttonName)+"button is enabled.", "PASS");
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();


			Report.put("User can expand each product group and get product associated.",
					"Add to group button should be enabled when user select any product.",
					"Failed to enable Add to Group Button", "FAIL");
			Assert.fail();
		}
	}

	public void clickAddToGroupButtonVerifySecondGrid(WebDriver driver)
	{
		System.out.println("Inside clickAddToGroupButtonVerifySecondGrid method");
		Log.info("Inside clickAddToGroupButtonVerifySecondGrid method");

		String detailsList = "";
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);

			CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.addToGroupButton());

			List<WebElement> list=driver.findElements(obj_UnifiedPortalPage.productDetailsSecondGrid());

			for(WebElement lt:list)
			{
				CommonUtility.highlightElement(driver, lt);
				String text=lt.getText();

				System.out.println("Text is: " +text);
				detailsList+=" <br> " + text;
			}
			System.out.println("Details are:"+detailsList);		

			Report.put("Click Add to group button and verify that selected records are displayed in second grid and in upper grid selected records are greyed out",
					"Selected records should be displayed in the second grid",
					"Selected product details: "+Report.color(detailsList), "PASS");

		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click Add to group button and verify that selected records are displayed in second grid and in upper grid selected records are greyed out",
					"Selected records should be displayed in the second grid",
					"Failed to display details in the Second Grid.", "FAIL");
			Assert.fail();
		}
	}

	public void clickCreateCustomGroupButton(WebDriver driver)
	{
		System.out.println("Inside clickCreateCustomGroupButton method");
		Log.info("Inside clickCreateCustomGroupButton method");

		String header = "";

		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);			

			CommonUtility.scrollToViewElement(driver,obj_UnifiedPortalPage.createCustomGroupButton());

			CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.createCustomGroupButton());	

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_UnifiedPortalPage.myCustomGroupHeader()));
			CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.myCustomGroupHeader());

			header = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.myCustomGroupHeader()).getText();

			System.out.println("Header is: "+header);

			Report.put("User Clicks on Create Custom Group ",
					"Custom group should be created and user should be redirected to the home page",
					"Created Custom group & redirected to page"+Report.color(header), "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("User Clicks on Create Custom Group",
					"Custom group should be created and user should be redirected to the home page",
					"Failed to Create Custom group & redirect to homepage", "FAIL");
			Assert.fail();
		}
	}

	public void verifyRemoveFromGroup(WebDriver driver)
	{
		System.out.println("Inside verifyRemoveFromGroup method");
		Log.info("Inside verifyRemoveFromGroup method");

		String productName = "";
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);				


			CommonUtility.ClickOn(driver, obj_UnifiedPortalPage.productIdCheckboxSecondGrid());

			Thread.sleep(10000);
			CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.removeFromGroupButton());

			//if(!(CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.productIdSecondGridProdName()).isDisplayed())
			if(!(CommonUtility.CheckpresenceofElementLocated(driver, 10, obj_UnifiedPortalPage.productIdSecondGridProdName())))
			{
				Report.put("In second grid, select any product or site and click Remove from group and observe that records are removed from grid and in upper grid record is available.",
						"Records should be deleted from second grid.",
						"Selected product is removed from the group successfully."+Report.color(productName), "PASS");
			}		
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("In second grid, select any product or site and click Remove from group and observe that records are removed from grid and in upper grid record is available.",
					"Records should be deleted from second grid.",
					"Failed to Remove from group", "FAIL");
			Assert.fail();
		}
	}

	public void searchSiteId(WebDriver driver, String siteId)
	{
		System.out.println("Inside searchSiteId method");
		Log.info("Inside searchSiteId method");

		String header = "";
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);

			System.out.println("Site ID from Testdata is: "+siteId);						

			CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.siteIdTextbox()).sendKeys(siteId);	
			CommonUtility.ClickOn(driver, obj_UnifiedPortalPage.siteIdSearchButton());
			//	CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.siteIdSearchButton()).click();
			//CommonUtility.ToClickByUsingJavaScript_PassingByLoc(driver, obj_UnifiedPortalPage.productIdSearchButton());

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_UnifiedPortalPage.siteIdTable()));

			//CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.productIdCheckbox()).click();

			CommonUtility.ClickOn(driver, obj_UnifiedPortalPage.siteIdCheckbox());

			Thread.sleep(10000);
			CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.addToGroupButton());

			CommonUtility.scrollToViewElement(driver,obj_UnifiedPortalPage.createCustomGroupButton());

			CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.createCustomGroupButton());	

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_UnifiedPortalPage.myCustomGroupHeader()));
			CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.myCustomGroupHeader());

			header = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.myCustomGroupHeader()).getText();

			System.out.println("Header is: "+header);


			Report.put("Search any Site id.",
					"My Custom group is created for type Product using Site ID.",
					"Created group with Site Id "+Report.color(siteId) +". Header is: "+Report.color(header), "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Search any Site id.",
					"My Custom group is created for type Product using Site ID.",
					"Failed to create group with Site Id "+Report.color(siteId), "FAIL");
			Assert.fail();
		}
	}

	public void  clickSignInHereLink(WebDriver driver) 
	{
		System.out.println("Inside clickSignInHereLink method");
		Log.info("Inside clickSignInHereLink method");

		String header = "";

		WebDriverWait  wait = new WebDriverWait(driver, 600);	
		try
		{
			handleCookies(driver);
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIPSHomePage.signInHeader()));
			CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.signInHereLink());
			CommonUtility.ClickOn(driver,obj_EsupportIPSHomePage.signInHereLink());

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_UnifiedPortalPage.preferenceHeader()));

			header = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.preferenceHeader()).getText();

			System.out.println("Clicked on Sign In Link");

			Report.put("click on employees and vendors click here link  ",
					"User should logged in successfully  ", 
					"Sign in successful. Navigated to Page"+Report.color(header), "PASS");

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("click on employees and vendors click here link  ",
					"User should logged in successfully  ", 
					"Failed to Sign in", "FAIL");
			Assert.fail();
		}
	}

	public void clickNotificationsAlertsTab(WebDriver driver)
	{
		System.out.println("Inside clickNotificationsAlertsTab method");
		Log.info("Inside clickNotificationsAlertsTab method");

		String header = "";
		String tab = "";
		String serviceRequestEventsHeader = "";
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 666);

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_UnifiedPortalPage.preferenceHeader()));
			header = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.preferenceHeader()).getText();

			System.out.println("Header is: "+header);

			tab = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.notificationsAlertsTab()).getText();

			System.out.println("Clicked on "+tab);
			CommonUtility.ScrollTo(driver, obj_UnifiedPortalPage.notificationsAlertsTab());
			CommonUtility.ClickOn(driver, obj_UnifiedPortalPage.notificationsAlertsTab());
			//CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.customGroupsTab()).click();	
			Thread.sleep(7000);
			//			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_UnifiedPortalPage.serviceRequestEventsHeader()));

			if(CommonUtility.CheckpresenceofElementLocated(driver,10,obj_UnifiedPortalPage.serviceRequestEventsHeader()))
			{
				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.serviceRequestEventsHeader());

				serviceRequestEventsHeader = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.serviceRequestEventsHeader()).getText();

				System.out.println("Service Events Header is:  "+serviceRequestEventsHeader);
				Thread.sleep(10000);
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_UnifiedPortalPage.serviceRequestEventsTable()));
				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.serviceRequestEventsTable());
				CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.serviceRequestEventsTable());
			}

			Report.put("User navigates to the Preferences->Notifications & Alerts sections event Notifications tab",
					"User should be able to see a list of their existing SR event notifications.",
					Report.color(tab)+"displayed successfully.", "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();

			Report.put("User navigates to the Preferences->Notifications & Alerts sections event Notifications tab",
					"User should be able to see a list of their existing SR event notifications.",
					"Failed to load Notifications & Alerts section page", "FAIL");
			Assert.fail();
		}
	}

	public void verifyServiceRequestEventsColumns(WebDriver driver)
	{
		System.out.println("Inside verifyServiceRequestEventsColumns method");
		Log.info("Inside verifyServiceRequestEventsColumns method");

		String columnList = "";

		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);

			List<WebElement> list=driver.findElements(obj_UnifiedPortalPage.serviceRequestEventsColumns());

			for(WebElement lt:list)
			{
				CommonUtility.highlightElement(driver, lt);
				String column=lt.getText();

				System.out.println("Column is: " +column);
				columnList+=" <br> " + column;
			}
			System.out.println("Columns are:"+columnList);					


			Report.put("User sees the following columns: Notification Name, Description, Created, Active Notification, Actions",
					"User should be able to see the below columns on the page: Notification Name, Description, Created, Active Notification, Actions",
					"Displayed columns successfully."+Report.color(columnList), "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("User sees the following columns: Notification Name, Description, Created, Active Notification, Actions",
					"User should be able to see the below columns on the page: Notification Name, Description, Created, Active Notification, Actions",
					"Failed to Display the columns", "FAIL");
			Assert.fail();
		}
	}

	public void verifyPaginationServiceRequestEvents(WebDriver driver)
	{
		System.out.println("Inside verifyPaginationServiceRequestEvents method");
		Log.info("Inside verifyPaginationServiceRequestEvents method");

		String text = "";
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);			

			if((CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.serviceRequestEventsPagination()).isDisplayed()))
			{
				//				text = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.serviceRequestEventsPagination()).getText();
				//				
				//				System.out.println("Pagination text is: "+text);
				Report.put("User Sees Pagination",
						"Pagination should be present.",
						"Pagination displayed successfully.", "PASS");
			}		
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("User Sees Pagination",
					"Pagination should be present.",
					"Failed to to display Pagination", "FAIL");
			Assert.fail();
		}
	}

	public void verifyServiceRequestEventsNotificationToggle(WebDriver driver)
	{
		System.out.println("Inside verifyServiceRequestEventsNotificationToggle method");
		Log.info("Inside verifyServiceRequestEventsNotificationToggle method");

		try
		{

			String text = "";				

			List<WebElement> optionList=driver.findElements(obj_UnifiedPortalPage.serviceRequestEventsNotificationsToggleButton());

			for(WebElement lt:optionList)
			{
				CommonUtility.ScrollToWebElement(driver, lt);		
				//	CommonUtility.ToClickByUsingJavaScript(driver,lt);
				//				lt.click();
				CommonUtility.ClickOnWebElement(driver, lt);	
				System.out.println("Inside subscribe for loop");	
				text = "Able to subscribe/unsubscribe from notifications";
				Thread.sleep(3000);
			}				

			for(WebElement lt:optionList)
			{
				CommonUtility.ScrollToWebElement(driver, lt);			
				//				lt.click();
				CommonUtility.ClickOnWebElement(driver, lt);	
				System.out.println("Inside subscribe for loop");	
				text = "Able to subscribe/unsubscribe from notifications";
				Thread.sleep(3000);
			}	

			Report.put("User sees the ON/OFF slider button ",
					"User should be able to turn the notifications ON/OFF slider button from the landing page",
					Report.color(text)+" successfully. ", "PASS");

		} 
		catch(Exception e)
		{
			e.printStackTrace();

			Report.put("User sees the ON/OFF slider button ",
					"User should be able to turn the notifications ON/OFF slider button from the landing page",
					"Failed to display Notification Options in the Slider", "FAIL");
			Assert.fail();
		}
	}

	public void clickServiceRequestEventsTab(WebDriver driver)
	{
		System.out.println("Inside clickServiceRequestEventsTab method");
		Log.info("Inside clickServiceRequestEventsTab method");

		String header = "";
		String tab = "";
		String serviceRequestEventsHeader = "";
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);


			CommonUtility.ClickOn(driver, obj_UnifiedPortalPage.serviceRequestEventsTab());
			//CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.customGroupsTab()).click();	

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_UnifiedPortalPage.serviceRequestEventsHeader()));
			CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.serviceRequestEventsHeader());

			serviceRequestEventsHeader = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.serviceRequestEventsHeader()).getText();

			System.out.println("Service Events Header is:  "+serviceRequestEventsHeader);
			Thread.sleep(30000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_UnifiedPortalPage.serviceRequestEventsTable()));
			CommonUtility.scrollToViewElement(driver,obj_UnifiedPortalPage.serviceRequestEventsTable());
			CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.serviceRequestEventsTable());

			Report.put("Click on the Service Request Events",
					"A  list of their existing SR event notifications should be displayed",
					Report.color(serviceRequestEventsHeader)+"displayed successfully.", "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();

			Report.put("Click on the Service Request Events",
					"A  list of their existing SR event notifications should be displayed",
					"Failed to load Service Request Events page", "FAIL");
			Assert.fail();
		}
	}


	public void clickActionsButtonFirstRow(WebDriver driver)
	{
		System.out.println("Inside clickActionsButtonFirstRow method");
		Log.info("Inside clickActionsButtonFirstRow method");

		String confirmButton = "";
		String cancelButton = "";
		String header = "";
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);
			CommonUtility.ScrollTo(driver, obj_UnifiedPortalPage.actionsButtonFirstRow());
			CommonUtility.ClickOn(driver, obj_UnifiedPortalPage.actionsButtonFirstRow());

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_UnifiedPortalPage.actionsColumnDeleteOption()));
			CommonUtility.ScrollTo(driver, obj_UnifiedPortalPage.actionsColumnDeleteOption());
			CommonUtility.ClickOn(driver, obj_UnifiedPortalPage.actionsColumnDeleteOption());

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_UnifiedPortalPage.deleteSubscriptionHeader()));
			header = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.deleteSubscriptionHeader()).getText();

			confirmButton =	CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.deleteSubscriptionConfirmButton()).getText();
			cancelButton = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.deleteSubscriptionCancelButton()).getText();


			Report.put("User clicks on the 'Actions ' button->Delete ",
					"A modal should open with 'Confirm' and 'Cancel' buttons",
					Report.color(header)+"displayed successfully with buttons"+Report.color(confirmButton)+" and "+Report.color(cancelButton), "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();

			Report.put("User clicks on the 'Actions ' button->Delete ",
					"A modal should open with 'Confirm' and 'Cancel' buttons",
					"Failed to load Delete Subscription modal popup", "FAIL");
			Assert.fail();
		}
	}

	public void clickDeleteSubscriptionConfirmButton(WebDriver driver)
	{
		System.out.println("Inside clickDeleteSubscriptionConfirmButton method");
		Log.info("Inside clickDeleteSubscriptionConfirmButton method");
		String text="";
		String confirmButton = "";
		String cancelButton = "";
		String header = "";
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);
			CommonUtility.ScrollTo(driver, obj_UnifiedPortalPage.deleteSubscriptionConfirmButton());
			CommonUtility.ClickOn(driver, obj_UnifiedPortalPage.deleteSubscriptionConfirmButton());

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_UnifiedPortalPage.SuccessfullyDeletedMessage()));
			text=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.SuccessfullyDeletedMessage()).getText();
			System.out.println(text);
			//
			//			header = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.alertMessage()).getAttribute("value");
			//			System.out.println("Alert message is "+header);
			Thread.sleep(10000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_UnifiedPortalPage.serviceRequestEventsHeader()));
			CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.serviceRequestEventsHeader());

			Report.put("User clicks on Confirm",
					"The notification should be deleted ",
					"Deleted Notification Succesfully."+Report.color(text), "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();

			Report.put("User clicks on Confirm",
					"The notification should be deleted ",
					"Failed to  Delete Subscription", "FAIL");
			Assert.fail();
		}
	}

	public void createSiteGroup(WebDriver driver)
	{
		System.out.println("Inside createSiteGroup method");
		Log.info("Inside createSiteGroup method");

		String addHeader = "";
		String createHeader = "";
		String tab = "";
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);

			CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.addCustomGroupButton());	

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_UnifiedPortalPage.addCustomGroupHeader()));
			addHeader = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.addCustomGroupHeader()).getText();

			System.out.println("Add Header is: "+addHeader);		

			CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.createSiteGroupLink());	

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_UnifiedPortalPage.createSiteGroupHeader()));
			CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.createSiteGroupHeader());

			createHeader = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.createSiteGroupHeader()).getText();

			System.out.println("Create Header is: "+createHeader);

			Report.put("User Clicks Add Custom Group, Add a custom group page opens. and Select Create a Product group.",
					"Add custom group page should be displayed",
					Report.color(createHeader)+"displayed successfully.", "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("User Clicks Add Custom Group, Add a custom group page opens. and Select Create a Product group.",
					"Add custom group page should be displayed",
					"Failed to display Add Custom Group page.", "FAIL");
			Assert.fail();
		}
	}

	public void enterSiteGroupDetails(WebDriver driver, String name, String desc, String option)
	{
		System.out.println("Inside enterSiteGroupDetails method");
		Log.info("Inside enterSiteGroupDetails method");

		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);
			System.out.println("Name from Testdata is: "+name);		
			System.out.println("Description from Testdata is: "+desc);		
			System.out.println("Option from Testdata is: "+option);		

			CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.siteGroupNameTextbox()).sendKeys(name);	

			CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.siteGroupDescTextbox()).sendKeys(desc);					

			Select selOption = new  Select(driver.findElement(obj_UnifiedPortalPage.findSitesDropdown()));

			selOption.selectByVisibleText(option); 
			System.out.println("Selected: "+option);

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_UnifiedPortalPage.accountSiteList()));

			Report.put("Enter name and Description and select Account sites from Find Sites by dropdown.",
					"A list of sites should open",
					"Displayed list of sites successfully. Entered Details are: Name: "+Report.color(name)+"Desc:"+Report.color(desc) +"Selected Option:"+Report.color(option), "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Enter name and Description and select Account sites from Find Sites by dropdown.",
					"A list of sites should open",
					"Failed to display list of sites", "FAIL");
			Assert.fail();
		}
	}

	public void verifyShowProductsLink(WebDriver driver)
	{
		System.out.println("Inside verifyShowProductsLink method");
		Log.info("Inside verifyShowProductsLink method");

		String header = "";
		String ShowProductsLinkFirstGrid = "";
		String ShowProductsLinkSecondGrid = "";

		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);

			//CommonUtility.scrollToViewElement(driver,obj_UnifiedPortalPage.siteCheckboxFirstGrid());

			//	CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.siteCheckboxFirstGrid());	

			CommonUtility.ToClickByUsingJavaScript_PassingByLoc(driver, obj_UnifiedPortalPage.siteCheckboxFirstGrid());

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_UnifiedPortalPage.addToGroupButton()));
			Thread.sleep(5000);

			CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.addToGroupButton());

			ShowProductsLinkFirstGrid = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.showProductsLinkFirstGrid()).getText();

			System.out.println("Link in First Column is: "+ShowProductsLinkFirstGrid);

			ShowProductsLinkSecondGrid = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.showProductsLinkSecondGrid()).getText();

			System.out.println("Link in Second Column is: "+ShowProductsLinkSecondGrid);			


			Report.put("User verifies when the grid loads up with Account Sites",
					"User should be able to select 'Show Products' under Products Associated column to see the list of products available in that site in both top and bottom grids",
					"Displayed "+Report.color(ShowProductsLinkFirstGrid) +"in first grid & displayed "+Report.color(ShowProductsLinkSecondGrid) +"in second grid.", "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("User verifies when the grid loads up with Account Sites",
					"User should be able to select 'Show Products' under Products Associated column to see the list of products available in that site in both top and bottom grids",
					"Failed to display Show Products link in Products Associated Column", "FAIL");
			Assert.fail();
		}
	}

	public void verifySiteGridDetails(WebDriver driver)
	{
		System.out.println("Inside verifySiteGridDetails method");
		Log.info("Inside verifySiteGridDetails method");


		String column = "";
		String columnList = "";

		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);

			List<WebElement> list=driver.findElements(obj_UnifiedPortalPage.siteDetailsColumnsHeader());

			for(WebElement lt:list)
			{
				CommonUtility.highlightElement(driver, lt);
				String text=lt.getText();

				System.out.println("Column is: " +text);
				columnList+=" <br> " + text;
			}
			System.out.println("Columns are:"+columnList);					



			Report.put("User verifies that Grid populating with following columns: Site Location, Site ID, Site Name, Products Associated",
					"Grid should be populated with the following columns: Site Location, Site ID, Site Name, Products Associated",
					Report.color(columnList)+"displayed successfully.", "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();

			Report.put("User verifies that Grid populating with following columns: Site Location, Site ID, Site Name, Products Associated",
					"Grid should be populated with the following columns: Site Location, Site ID, Site Name, Products Associated",
					"Failed to load Columns: Site Location, Site ID, Site Name, Products Associated", "FAIL");
			Assert.fail();
		}
	}

	public void clickDeleteCustomGroup(WebDriver driver)
	{
		System.out.println("Inside clickDeleteCustomGroup method");
		Log.info("Inside clickDeleteCustomGroup method");

		String confirmButton = "";
		String cancelButton = "";
		String header = "";
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);

			CommonUtility.ClickOn(driver, obj_UnifiedPortalPage.actionsButtonFirstRow());

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_UnifiedPortalPage.actionsColumnDeleteOption()));
			CommonUtility.ClickOn(driver, obj_UnifiedPortalPage.actionsColumnDeleteOption());

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_UnifiedPortalPage.deleteCustomGroupHeader()));
			header = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.deleteCustomGroupHeader()).getText();

			confirmButton =	CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.deleteSubscriptionConfirmButton()).getText();
			cancelButton = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.deleteSubscriptionCancelButton()).getText();


			Report.put("Click Action item >> Remove custom group",
					"The user should be displayed with a pop up with cancel , confirm button ",
					Report.color(header)+"displayed successfully with buttons"+Report.color(confirmButton)+" and "+Report.color(cancelButton), "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();

			Report.put("Click Action item >> Remove custom group",
					"The user should be displayed with a pop up with cancel , confirm button ",
					"Failed to load modal popup with cancel , confirm button", "FAIL");
			Assert.fail();
		}
	}

	public void clickCustomGroupPopupConfirmButton(WebDriver driver)
	{
		System.out.println("Inside clickCustomGroupPopupConfirmButton method");
		Log.info("Inside clickCustomGroupPopupConfirmButton method");

		String confirmButton = "";
		String cancelButton = "";
		String header = "";
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);	

			CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.deleteSubscriptionConfirmButton());

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_UnifiedPortalPage.myCustomGroupHeader()));
			header = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.myCustomGroupHeader()).getText();


			Report.put("Click Confirm Removal",
					"It deletes the custom group from user's list of Custom Groups and the grid refreshes after removal to exclude the deleted group post which user should be  getting the message Custom Group Deleted",
					Report.color(header)+"displayed successfully with buttons"+Report.color(confirmButton)+" and "+Report.color(cancelButton), "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();

			Report.put("Click Action item >> Remove custom group",
					"The user should be displayed with a pop up with cancel , confirm button ",
					"Failed to load modal popup with cancel , confirm button", "FAIL");
			Assert.fail();
		}
	}

	public void clickCustomGroupPopupCancelButton(WebDriver driver)
	{
		System.out.println("Inside clickCustomGroupPopupCancelButton method");
		Log.info("Inside clickCustomGroupPopupCancelButton method");

		String confirmButton = "";
		String cancelButton = "";
		String header = "";
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);	

			//CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.deleteSubscriptionCancelButton()).click();
			CommonUtility.ClickOn(driver, obj_UnifiedPortalPage.deleteSubscriptionCancelButton());
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_UnifiedPortalPage.myCustomGroupHeader()));
			header = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.myCustomGroupHeader()).getText();


			Report.put("User selects ,Cancel",
					"No action will be taken and user should directed back to the grid.",
					"Redirected back to the page"+Report.color(header), "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();

			Report.put("User selects ,Cancel",
					"No action will be taken and user should directed back to the grid.",
					"Failed to redirect back to the grid", "FAIL");
			Assert.fail();
		}
	}

	public void searchCustomGroup(WebDriver driver, String input)
	{
		System.out.println("Inside searchCustomGroup method");
		Log.info("Inside searchCustomGroup method");

		String productName = "";
		String accountList = "";
		String defaultList = "";
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);

			System.out.println("Input from Testdata is: "+input);						
			Thread.sleep(10000);
			CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.myCustomGroupSearchTextbox()).sendKeys(input);	

			CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.myCustomGroupFilterButton());
			Thread.sleep(10000);			
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Failed in method searchCustomGroup");
			Assert.fail();
		}
	}

	public void clickDeleteSubscriptionCancelButton(WebDriver driver)
	{
		System.out.println("Inside clickDeleteSubscriptionCancelButton method");
		Log.info("Inside clickDeleteSubscriptionCancelButton method");

		String confirmButton = "";
		String cancelButton = "";
		String header = "";
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);
			CommonUtility.ScrollTo(driver, obj_UnifiedPortalPage.deleteSubscriptionCancelButton());
			CommonUtility.ClickOn(driver, obj_UnifiedPortalPage.deleteSubscriptionCancelButton());

			wait.until(ExpectedConditions.presenceOfElementLocated(obj_UnifiedPortalPage.serviceRequestEventsHeader()));
			CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.serviceRequestEventsHeader());

			Report.put("User clicks on Cancel",
					"That should cancel the action and navigate the user back to list of notifications",
					"Clicked on Cancel Succesfully and navigated back to list of notifications.", "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();

			Report.put("User clicks on Cancel",
					"That should cancel the action and navigate the user back to list of notifications",
					"Failed to  click on Cancel & navigate  back to list of notifications.", "FAIL");
			Assert.fail();
		}
	}

	public void verifyNotificationsAlertsTab(WebDriver driver)
	{
		System.out.println("Inside verifyNotificationsAlertsTab method");
		Log.info("Inside verifyNotificationsAlertsTab method");

		String header = "";
		String tab = "";
		String tabList = "";
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_UnifiedPortalPage.preferenceHeader()));
			header = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.preferenceHeader()).getText();

			System.out.println("Header is: "+header);

			tab = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.notificationsAlertsTab()).getText();

			System.out.println("Clicked on "+tab);

			CommonUtility.ClickOn(driver, obj_UnifiedPortalPage.notificationsAlertsTab());
			//CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.customGroupsTab()).click();	

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_UnifiedPortalPage.serviceRequestEventsHeader()));
			CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.serviceRequestEventsHeader());

			List<WebElement> list=driver.findElements(obj_UnifiedPortalPage.notificationsAlertsTabSections());

			for(WebElement lt:list)
			{
				CommonUtility.highlightElement(driver, lt);
				String text=lt.getText();

				System.out.println("Tab is: " +text);
				tabList+=" <br> " + text;
			}
			System.out.println("Tabs are:"+tabList);


			Report.put("Click on the Notifications and Alerts tab",
					"The Notifications and Alerts tab should be displayed with the three sections: Product Updates, Product Advisories, Service Request Events",
					Report.color(tab)+"displayed successfully.", "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();

			Report.put("Click on the Notifications and Alerts tab",
					"The Notifications and Alerts tab should be displayed with the three sections: Product Updates, Product Advisories, Service Request Events",
					"Failed to load Notifications & Alerts section page", "FAIL");
			Assert.fail();
		}
	}

	public void clickAddNotificationButton(WebDriver driver)
	{
		System.out.println("Inside clickAddNotificationButton method");
		Log.info("Inside clickAddNotificationButton method");

		String button = "";

		String SREventsNotificationHeader = "";		
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);

			CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.addNotificationButton());
			button = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.addNotificationButton()).getText();

			CommonUtility.ScrollTo(driver, obj_UnifiedPortalPage.addNotificationButton());
			CommonUtility.ClickOn(driver, obj_UnifiedPortalPage.addNotificationButton());

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_UnifiedPortalPage.createSREventNotificationHeader()));

			SREventsNotificationHeader = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.createSREventNotificationHeader()).getText();

			System.out.println("Service Events Notification Header is:  "+SREventsNotificationHeader);



			Report.put("Click on the 'Add Notification ' button",
					"A popup should be displayed with the title 'Create a Service Request Event Notification'",
					"Clicked on "+Report.color(button)+" navigated to "+Report.color(SREventsNotificationHeader)+" displayed successfully.", "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on the 'Add Notification ' button",
					"A popup should be displayed with the title 'Create a Service Request Event Notification'",
					"Failed to load Service Request Events page", "FAIL");
			Assert.fail();
		}
	}

	//Lavanya


	public void  ClickOnNotificationAndAlertsTab(WebDriver driver) 
	{
		//			System.out.println("Inside ClickOnNotificationAndAlertsTab method");
		Log.info("Inside ClickOnNotificationAndAlertsTab method");

		String header = "";
		String text="";
		String header1="";

		WebDriverWait  wait = new WebDriverWait(driver, 240);	
		try
		{
			//handleCookies(driver);
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_UnifiedPortalPage.NotificationAndAlertsTab()));
			//				text=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.NotificationAndAlertsTab()).getText();
			//				System.out.println(text);
			Thread.sleep(10000);
			CommonUtility.ScrollTo(driver, obj_UnifiedPortalPage.NotificationAndAlertsTab());
			CommonUtility.ClickOn(driver, obj_UnifiedPortalPage.NotificationAndAlertsTab());
			Thread.sleep(10000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_UnifiedPortalPage.ProductAdvisoriesTab()));
			CommonUtility.ScrollTo(driver, obj_UnifiedPortalPage.ProductAdvisoriesTab());
			header = CommonUtility.highlightElement(driver, obj_UnifiedPortalPage.ProductAdvisoriesTab()).getText();

			System.out.println(header);
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_UnifiedPortalPage.ProductUpdatesTab()));

			header1 = CommonUtility.highlightElement(driver, obj_UnifiedPortalPage.ProductUpdatesTab()).getText();

			System.out.println(header1);

			Report.put("click on Notification and alerts tab  ",
					"User should be able to click on Notification and alerts tab", 
					"user able to click on Notification and alerts tab", "PASS");

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("click on Notification and alerts tab  ",
					"User should be able to click on Notification and alerts tab",  
					"Failed click on Notification and alerts tab", "FAIL");
			Assert.fail();
		}
	}

	public void  ClickOnProductAdvisories(WebDriver driver) 
	{
		//			System.out.println("Inside ClickOnNotificationAndAlertsTab method");
		Log.info("Inside ClickOnProductAdvisories method");

		String header = "";
		String text="";

		WebDriverWait  wait = new WebDriverWait(driver, 60);	
		try
		{
			handleCookies(driver);
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_UnifiedPortalPage.ProductAdvisoriesTab()));

			CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.ProductAdvisoriesTab());
			//				text=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.ProductAdvisoriesTab()).getText();
			//				System.out.println(text);
			//				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_UnifiedPortalPage.AddAlertSection()));
			//				
			//				header = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.AddAlertSection()).getText();
			//				
			//				System.out.println(header);

			Report.put("click on Product Advisories tab",
					"User should be able to click on Product Advisories tab", 
					"user able to click on Product Advisories tab ", "PASS");

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("click on Product Advisories tab",
					"User should be able to click on Product Advisories tab", 
					"Failed click on Product Advisories tab", "FAIL");
			Assert.fail();
		}
	}

	public void  VerifyForAddAlert(WebDriver driver) 
	{
		//			System.out.println("Inside ClickOnNotificationAndAlertsTab method");
		Log.info("Inside VerifyForAddAlert method");

		String header = "";
		String text="";

		WebDriverWait  wait = new WebDriverWait(driver, 60);	
		try
		{
			handleCookies(driver);
			//			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_UnifiedPortalPage.AddAlertSection()));
			CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.AddAlertSection());
			//				CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.ProductAdvisoriesTab()).click();
			text=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.AddAlertSection()).getText();
			System.out.println(text);

			if(CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.AddAlertButtonInProductAdvisoryTabs()).isEnabled())
			{
				header = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.AddAlertButtonInProductAdvisoryTabs()).getText();

				System.out.println(header);
			}

			Report.put("User verifies as any C/P/E user without any existing subscriptions to Advisories, the landing page is empty with no records updated in it ",
					"User should be able to verify Empty state for Product Advisory subscriptions and verifies the add alert option is available", 
					"user able to see "+Report.color(header)+" button enabled", "PASS");

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("User verifies as any C/P/E user without any existing subscriptions to Advisories, the landing page is empty with no records updated in it ",
					"User should be able to verify Empty state for Product Advisory subscriptions and verifies the add alert option is available",  
					"Failed see Add Alert button", "FAIL");
			Assert.fail();
		}
	}

	public void  VerifyDeliveryPreferencesSection(WebDriver driver) 
	{
		//			System.out.println("Inside ClickOnNotificationAndAlertsTab method");
		Log.info("Inside VerifyDeliveryPreferencesSection method");

		String header = "";
		String text="";
		String text1="";
		String text2="";

		WebDriverWait  wait = new WebDriverWait(driver, 60);	
		try
		{
			handleCookies(driver);
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_UnifiedPortalPage.DeliveryPreferencesSection()));

			//				CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.ProductAdvisoriesTab()).click();
			text=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.DeliveryPreferencesSection()).getText();
			System.out.println(text);

			if(CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.HelpTextAsSelectYourDefaultEmailAddress()).isEnabled())
			{
				header = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.HelpTextAsSelectYourDefaultEmailAddress()).getText();

				System.out.println(header);

				text1 = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.EmailField()).getText();

				System.out.println(text1);

				text2 = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.EmailSelectedByDefault()).getText();

				System.out.println(text2);

			}

			Report.put("User checks if  able to see a 'Delivery Preferences' section with help text as -Select your default email address.",
					"User should be able to see a Email field should be defaulted to the Business Email address for first time users (or) based on user's previous selections <br> Note:If a user makes changes to the Email address selector in 'Product Updates' section ,it should be reflected here as well.", 
					"user able to see "+Report.color(text)+" section with help text "+Report.color(header)+" able to see "+Report.color(text1)+" field defaulted email displayed is "+Report.color(text2), "PASS");

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("User checks if  able to see a 'Delivery Preferences' section with help text as -Select your default email address.",
					"User should be able to see a Email field should be defaulted to the Business Email address for first time users (or) based on user's previous selections <br> Note:If a user makes changes to the Email address selector in 'Product Updates' section ,it should be reflected here as well.",
					"Failed see Email field", "FAIL");
			Assert.fail();
		}
	}

	public void  ValidateListOfExistingProductAdvisoryNotification(WebDriver driver) 
	{
		//			System.out.println("Inside ClickOnNotificationAndAlertsTab method");
		Log.info("Inside ValidateListOfExistingProductAdvisoryNotification method");

		String header = "";

		String text="";
		String text1="";
		String text2="";
		String text3="";
		String text4="";
		String labelList2="";
		String labelList="";
		String labelList1="";
		String text5="";

		WebDriverWait  wait = new WebDriverWait(driver, 60);	
		try
		{
			handleCookies(driver);
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_UnifiedPortalPage.ProductAdvisoriesHeading()));


			text=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.ProductAdvisoriesHeading()).getText();
			System.out.println(text);

			if(CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.ProductAdvisoriesDescription()).isDisplayed())
			{
				header = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.ProductAdvisoriesDescription()).getText();

				System.out.println(header);
			}


			text3=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.AddAlertButtonWithAdvisoryAlerts()).getText();
			System.out.println(text3);


			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_UnifiedPortalPage.DeliveryPreferencesSection()));


			text4=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.DeliveryPreferencesSection()).getText();
			System.out.println(text4);

			if(CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.HelpTextAsSelectYourDefaultEmailAddress()).isEnabled())
			{
				header = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.HelpTextAsSelectYourDefaultEmailAddress()).getText();

				System.out.println(header);

				text1 = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.EmailField()).getText();

				System.out.println(text1);

				text2 = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.EmailSelectedByDefault()).getText();

				System.out.println(text2);

			}

			List<WebElement> list2=driver.findElements(obj_UnifiedPortalPage.TechnicalSecurityTabs());

			for(WebElement lt1:list2)
			{
				CommonUtility.highlightElement(driver, lt1);
				String label1=lt1.getText();

				System.out.println("product values " +label1);
				labelList2+=" <br> " + label1;
			}
			System.out.println("Tabs are:"+labelList2);

			List<WebElement> list=driver.findElements(obj_UnifiedPortalPage.GridColumnsHeadings());

			for(WebElement lt:list)
			{
				CommonUtility.highlightElement(driver, lt);
				String label=lt.getText();

				System.out.println("Label is: " +label);
				labelList+=" <br> " + label;
			}
			System.out.println("Tabs are:"+labelList);

			List<WebElement> list1=driver.findElements(obj_UnifiedPortalPage.GridRowsDetails());

			for(WebElement lt1:list1)
			{
				CommonUtility.highlightElement(driver, lt1);
				String label1=lt1.getText();

				System.out.println("product values " +label1);
				labelList1+=" <br> " + label1;
			}
			System.out.println("Tabs are:"+labelList1);




			if(CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.ClickOnFirstTabUnderActionsTabForDeleteButton()).isDisplayed())
			{
				CommonUtility.scrollToViewElement(driver,obj_UnifiedPortalPage.ClickOnFirstTabUnderActionsTabForDeleteButton());
				CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.ClickOnFirstTabUnderActionsTabForDeleteButton());
				CommonUtility.scrollToViewElement(driver,obj_UnifiedPortalPage.DeleteButton());
				text5 = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.DeleteButton()).getText();

				System.out.println(text5);
			}


			Report.put("User checks if he/she is  able to see a list of their existing Product Advisory notifications",
					"User should be  able to see following list :    1.Product Advisories title and description<br> 2.Delivery Preferences Section with user default email address <br>3.Email :Business email address is defaulted if user has not made any selection in the Product Updates grid.<br>4.The following columns should be available in the grid: My Advisory Alerts (Product Name) Technical (DTA) -ability to select/unselect Security (DSA)-ability to select/unselect Actions :Delete  <br>5.pagination  Capacity <br> 6.'Add Alert' button", 
					"user able to see 1. "+Report.color(text+" and "+header)+" <br> 2. Delivery Preferences Section with "+Report.color(text1+" and "+text2)+" <br> 3.  field defaulted email displayed is "+Report.color(text2)+" <br> 4.  and "+Report.color(labelList2)+" toglle buttons and 4. able to see notifications in grid with headings "+Report.color(labelList+" with values "+labelList1)+" <br> 5. pagination capacity available and "+Report.color(text5)+" button<br> 6. and "+Report.color(text3)+" button", "PASS");

		}

		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("User checks if he/she is  able to see a list of their existing Product Advisory notifications",
					"User should be  able to see following list :    1.Product Advisories title and description<br> 2.Delivery Preferences Section with user default email address <br>3.Email :Business email address is defaulted if user has not made any selection in the Product Updates grid.<br>4.The following columns should be available in the grid: My Advisory Alerts (Product Name) Technical (DTA) -ability to select/unselect Security (DSA)-ability to select/unselect Actions :Delete  <br>5.pagination  Capacity <br> 6.'Add Alert' button",
					"Failed to see existing notifications", "FAIL");
			Assert.fail();
		}
	}

	public void  ClickOnProductUpdatesTab(WebDriver driver) 
	{
		//			System.out.println("Inside ClickOnNotificationAndAlertsTab method");
		Log.info("Inside ClickOnProductUpdatesTab method");

		String header = "";
		String text="";

		WebDriverWait  wait = new WebDriverWait(driver, 60);	
		try
		{
			handleCookies(driver);
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_UnifiedPortalPage.ProductUpdatesTab()));
			CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.AddNotificationsInSR());
			CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.ProductUpdatesTab());
			CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.ProductUpdatesTab());
			//				text=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.ProductAdvisoriesTab()).getText();
			//				System.out.println(text);
			//				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_UnifiedPortalPage.AddAlertSection()));
			//				
			//				header = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.AddAlertSection()).getText();
			//				
			//				System.out.println(header);

			Report.put("click on Product Updates tab",
					"User should be able to click on Product Updates tab", 
					"user able to click on Product Updates tab ", "PASS");

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("click on Product Updates tab",
					"User should be able to click on Product Updates tab", 
					"Failed click on Product Updates tab", "FAIL");
			Assert.fail();
		}
	}

	public void  VerifyForAddNotification(WebDriver driver) 
	{
		//			System.out.println("Inside ClickOnNotificationAndAlertsTab method");
		Log.info("Inside VerifyForAddNotification method");

		String header = "";
		String text="";

		WebDriverWait  wait = new WebDriverWait(driver, 60);	
		try
		{
			handleCookies(driver);
			//			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_UnifiedPortalPage.AddNotificationSection()));
			CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.AddNotificationSection());
			//				CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.ProductAdvisoriesTab()).click();
			text=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.AddNotificationSection()).getText();
			System.out.println(text);

			if(CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.AddNotificationButton()).isEnabled())
			{
				header = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.AddNotificationButton()).getText();

				System.out.println(header);
			}

			Report.put("User verifies as any C/P/E user without any existing subscriptions to product updates, the landing page is empty with no records updated in it ",
					"User should be navigated to product updates page with blank details and it should have a Add Notification Button which should be clickable", 
					"user able to see "+Report.color(header)+" button enabled", "PASS");

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("User verifies as any C/P/E user without any existing subscriptions to product updates, the landing page is empty with no records updated in it ",
					"User should be navigated to product updates page with blank details and it should have a Add Notification Button which should be clickable", 
					"Failed see Add Notification button", "FAIL");
			Assert.fail();
		}
	}


	public void  VerifyProductUpdatesSection(WebDriver driver) 
	{

		Log.info("Inside VerifyProductUpdatesSection method");

		String header = "";
		String text="";

		WebDriverWait  wait = new WebDriverWait(driver, 60);	
		try
		{
			handleCookies(driver);
			//			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_UnifiedPortalPage.ProductUpdatesHeading()));
			CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.ProductUpdatesHeading());
			//				CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.ProductAdvisoriesTab()).click();
			text=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.ProductUpdatesHeading()).getText();
			System.out.println(text);

			if(CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.ProductUpdatesDescription()).isDisplayed())
			{
				header = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.ProductUpdatesDescription()).getText();

				System.out.println(header);
			}

			Report.put("Verify the Product Updates section is displayed with description",
					"The Product Updates section should be displayed along with description", 
					"user able to see "+Report.color(text)+" section displayed followed with description "+Report.color(header), "PASS");

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify the Product Updates section is displayed with description",
					"The Product Updates section should be displayed along with description", 
					"Failed see Product Updates section with description", "FAIL");
			Assert.fail();
		}
	}


	public void  VerifyDeliveryPreferencesSectionInProductUpdatesTab(WebDriver driver) 
	{
		//			System.out.println("Inside ClickOnNotificationAndAlertsTab method");
		Log.info("Inside VerifyDeliveryPreferencesSectionInProductUpdatesTab method");

		String header = "";
		String text="";
		String text1="";
		String text2="";

		WebDriverWait  wait = new WebDriverWait(driver, 60);
		String labelList="";
		try
		{
			//handleCookies(driver);
			//			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_UnifiedPortalPage.DeliveryPreferencesSectionInProductUpdates()));

			CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.DeliveryPreferencesHeadingInProductUpdates());
			text=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.DeliveryPreferencesHeadingInProductUpdates()).getText();
			System.out.println(text);

			if(CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.SendEmailAndFrequesncyPreferencesInProductUpdates()).isDisplayed())
			{


				List<WebElement> list=driver.findElements(obj_UnifiedPortalPage.DeliveryPreferencesEmailSubscriptionFrequesncyHeadingsInProductUpdates());

				for(WebElement lt:list)
				{
					CommonUtility.highlightElement(driver, lt);
					String label=lt.getText();

					System.out.println("Label is: " +label);
					labelList+=" <br> " + label;
				}
				System.out.println("Tabs are:"+labelList);

				header = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.SendEmailAndFrequesncyPreferencesInProductUpdates()).getText();

				System.out.println(header);
				text1 = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.GetEmailDisplayedDefaultValueInProductUpdates()).getText();

				System.out.println(text1);

				text2 = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.GetDefaultDisplayedSubscriptionFrequesncyValueInProductUpdates()).getText();

				System.out.println(text2);

				WebElement element=driver.findElement(By.xpath("//select[@id='product-updates_subscription_frequency']"));
				Select s=new Select(element);

				List<WebElement> list1= s.getOptions();
				int countlist=list1.size();
				System.out.println("count of drop down values are "+countlist);

				for(int i=0;i<countlist;i++)
				{
					text+="<br>"+list1.get(i).getText();
					System.out.println("issue list "+text);

				}

			}

			Report.put("Verify the Delivery Preferences section and <br> Check for the Help text displayed under Delivery Preferences section and <br> Verify the default email address displayed in Email dropdown ",
					"The Delivery Preferences section should be displayed below the Product Updates <br> The help text should be displayed as -'Select email and frequency preferences' <br> Email field should be defaulted to the Business Email address for first time users (or) based on user's previous selections", 
					"user able to see "+Report.color(text)+" section with help text with headings "+Report.color(labelList)+" with following "+Report.color(header+" ,"+text1+" ,"+text2), "PASS");

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify the Delivery Preferences section and <br> Check for the Help text displayed under Delivery Preferences section and <br> Verify the default email address displayed in Email dropdown ",
					"The Delivery Preferences section should be displayed below the Product Updates <br> The help text should be displayed as -'Select email and frequency preferences' <br> Email field should be defaulted to the Business Email address for first time users (or) based on user's previous selections", 
					"Failed to see Delivery Preferences section with expected details", "FAIL");
			Assert.fail();
		}
	}


	public void  ChangeEmailInProductAdvisoryAndCheckInProductUpdates(WebDriver driver) 
	{

		Log.info("Inside ChangeEmailInProductAdvisoryAndCheckInProductUpdates method");

		String header = "";
		String text="";
		String text1="";
		String text2="";

		WebDriverWait  wait = new WebDriverWait(driver, 60);	
		try
		{
			handleCookies(driver);
			//			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_UnifiedPortalPage.DeliveryPreferencesSection()));
			CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.DeliveryPreferencesSection());
			//				CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.ProductAdvisoriesTab()).click();
			text=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.DeliveryPreferencesSection()).getText();
			System.out.println(text);

			if(CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.HelpTextAsSelectYourDefaultEmailAddress()).isEnabled())
			{
				header = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.HelpTextAsSelectYourDefaultEmailAddress()).getText();

				System.out.println(header);

				text1 = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.EmailField()).getText();

				System.out.println(text1);

				text2 = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.EmailSelectedByDefault()).getText();

				System.out.println(text2);

				WebElement element=driver.findElement(By.xpath("//select[@id='product-advisory-events_email']"));
				Select s=new Select(element);

				List<WebElement> list= s.getOptions();
				int countlist=list.size();
				System.out.println("count of drop down values are "+countlist);

				for(int i=0;i<countlist;i++)
				{
					text+="<br>"+list.get(i).getText();
					System.out.println("issue list "+text);

				}
				s.selectByValue("2");
			}

			Report.put("Make changes to the Email Address selector in the in the Product Advisories section",
					"able to change email in Product Advisories section", 
					"user able to change email in product advisories", "PASS");

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Make changes to the Email Address selector in the in the Product Advisories section",
					"able to change email in Product Advisories section",
					"Failed to change email in product advisories", "FAIL");
			Assert.fail();
		}
	}


	public void  ValidateEmailChangeInProductUpdates(WebDriver driver) 
	{

		Log.info("Inside ValidateEmailChangeInProductUpdates method");

		String header = "";
		String text="";
		String text1="";
		String text2="";

		WebDriverWait  wait = new WebDriverWait(driver, 60);
		String labelList="";
		try
		{
			//handleCookies(driver);
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_UnifiedPortalPage.DeliveryPreferencesSectionInProductUpdates()));

			//				CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.ProductAdvisoriesTab()).click();
			text=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.DeliveryPreferencesHeadingInProductUpdates()).getText();
			System.out.println(text);

			if(CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.SendEmailAndFrequesncyPreferencesInProductUpdates()).isDisplayed())
			{


				text1 = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.GetEmailDisplayedDefaultValueInProductUpdates()).getText();

				System.out.println(text1);
				WebElement element=driver.findElement(By.xpath("//select[@id='product-updates_email']"));
				Select s=new Select(element);

				List<WebElement> list= s.getOptions();
				int countlist=list.size();
				System.out.println("count of drop down values are "+countlist);

				for(int i=0;i<countlist;i++)
				{
					header+="<br>"+list.get(i).getText();
					System.out.println("issue list "+header);

				}
				//				s.getClass();
				//				
				//				System.out.println("class is "+s.getClass());
				//				
				//				if(s.getClass().equals("form-control ng-valid ng-touched ng-dirty"))
				//				{
				//					System.out.println("default selected email is ");
				//					text2 = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.EmailVerificationAfterChangingInProductUpdatesTab()).getText();
				//
				//					System.out.println(text2);
				//				}


				Report.put("verify it in the Delivery Preferences section ",
						"After making changes to the Email address selector in 'Product Advisories' section ,it should be reflected in the Delivery Preferences section as well in product updates", 
						"user able to see changed email"+Report.color(text1)+" first selected email is "+Report.color(header), "PASS");
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("verify it in the Delivery Preferences section ",
					"After making changes to the Email address selector in 'Product Advisories' section ,it should be reflected in the Delivery Preferences section as well in product updates",  
					"Failed to see changes email selected in Product advisories", "FAIL");
			Assert.fail();
		}
	}


	public void  VerifyInformationIconDisplayedNextToEmailField(WebDriver driver) 
	{

		Log.info("Inside VerifyInformationIconDisplayedNextToEmailField method");

		String header = "";
		String text="";
		String text1="";
		String text2="";

		WebDriverWait  wait = new WebDriverWait(driver, 60);
		String labelList="";
		try
		{
			//handleCookies(driver);
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_UnifiedPortalPage.EmailInformationIconInProductUpdatesTab()));

			//				CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.ProductAdvisoriesTab()).click();
			CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.EmailInformationIconInProductUpdatesTab());


			if(CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.EmailInformationIconInProductUpdatesTab()).isDisplayed())
			{

				System.out.println("information icon displayed next to email");

			}

			Report.put("Verify if the information icon is displayed next to the Email field",
					"The information icon should be displayed next to Email field as in the screenshot", 
					"user able to see information icon next to email", "PASS");

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify if the information icon is displayed next to the Email field",
					"The information icon should be displayed next to Email field as in the screenshot",  
					"Failed to see information icon next to email", "FAIL");
			Assert.fail();
		}
	}


	public void  ClickOnInofrmationIconInProductUpdatesTab(WebDriver driver) 
	{

		Log.info("Inside ClickOnInofrmationIconInProductUpdatesTab method");

		String header = "";
		String text="";
		String text1="";
		String text2="";

		WebDriverWait  wait = new WebDriverWait(driver, 60);
		String labelList="";
		try
		{
			//handleCookies(driver);
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_UnifiedPortalPage.EmailInformationIconInProductUpdatesTab()));


			if(CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.EmailInformationIconInProductUpdatesTab()).isDisplayed())
			{

				CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.EmailInformationIconInProductUpdatesTab());
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_UnifiedPortalPage.ToolTipMessageClickingOnInformationIconNextToEmail()));

				text=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.ToolTipMessageClickingOnInformationIconNextToEmail()).getText();
				System.out.println(text);

			}

			Report.put("Click on the information icon",
					"The message should be displayed as 'Any changes to this preference will apply to your notifications for both Product Updates and Product Advisories.'", 
					"user able to click on information icon next to email and able to see meessage as "+Report.color(text), "PASS");

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on the information icon",
					"The message should be displayed as 'Any changes to this preference will apply to your notifications for both Product Updates and Product Advisories.'",  
					"clicking on information icon failed to see tool tip message", "FAIL");
			Assert.fail();
		}
	}




	public void  CheckIfNoAddedNotificationsInProductUpdatesForNoExistingNotifications(WebDriver driver) 
	{

		Log.info("Inside CheckIfNoAddedNotificationsInProductUpdatesForNoExistingNotifications method");

		String header = "";
		String text="";

		WebDriverWait  wait = new WebDriverWait(driver, 60);	
		try
		{
			handleCookies(driver);
			if(CommonUtility.CheckpresenceofElementLocated(driver, 10,  obj_UnifiedPortalPage.AddNotificationSection()))
			{
				CommonUtility.scrollToViewElement(driver,obj_UnifiedPortalPage.AddNotificationSection());
				text=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.AddNotificationSection()).getText();
				System.out.println(text);

				if(CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.AddNotificationButton()).isEnabled())
				{
					header = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.AddNotificationButton()).getText();

					System.out.println(header);
				}
				else
				{
					Report.put("Verify the details in the Product Updates section",
							"The Product Updates section should be displayed with the existing Product Update notifications (or) Empty state if they have not created any subscriptions yet.", 
							"user able not able to see Add Notification button", "Fail");
					Assert.fail();
				}


				Report.put("Verify the details in the Product Updates section",
						"The Product Updates section should be displayed with the existing Product Update notifications (or) Empty state if they have not created any subscriptions yet.", 
						"user able to see empty state with only "+Report.color(header)+" button enabled", "PASS");
			}


		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify the details in the Product Updates section",
					"The Product Updates section should be displayed with the existing Product Update notifications (or) Empty state if they have not created any subscriptions yet.", 
					"The Product Updates section displayed with the existing Product Update notifications", "PASS");
			//				Assert.fail();
		}
	}


	public void  CheckForExistingNotificationsInProductsUpdates(WebDriver driver) 
	{

		Log.info("Inside CheckForExistingNotificationsInProductsUpdates method");

		String header = "";
		String text="";
		String labelList="";
		String labelList1="";
		String labelList2="";
		int count=0;

		WebDriverWait  wait = new WebDriverWait(driver, 60);	
		try
		{
			//handleCookies(driver);
			if(CommonUtility.CheckpresenceofElementLocated(driver, 10,  obj_UnifiedPortalPage.NotificationColumnGridHeadingsInProductUpdates()))
			{
				//				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_UnifiedPortalPage.NotificationColumnGridHeadingsInProductUpdates()));
				CommonUtility.scrollToViewElement(driver,obj_UnifiedPortalPage.NotificationColumnGridHeadingsInProductUpdates());
				if(CommonUtility.CheckpresenceofElementLocated(driver, 10,  obj_UnifiedPortalPage.NumberOfNotificationsDisplayedInGridInProductUpdates()))
				{
					List<WebElement> list2=driver.findElements(obj_UnifiedPortalPage.NumberOfNotificationsDisplayedInGridInProductUpdates());
					count=(list2.size())-1;
					for(int i=1;i<list2.size();i++)
					{
						CommonUtility.highlightElement(driver, list2.get(i));
						String label2= list2.get(i).getText();

						System.out.println("number of notifications displayed are " +label2);
						labelList2+=" <br> " + label2;
					}
					System.out.println("Tabs are:"+labelList2);
				}
				else
				{
					Report.put("Verify the details in the Product Updates section",
							"The Product Updates section should be displayed with the existing Product Update notifications (or) Empty state if they have not created any subscriptions yet.", 
							"user not able to see existing notifications ", "Fail");

					Assert.fail();
				}

				List<WebElement> list=driver.findElements(obj_UnifiedPortalPage.NotificationColumnGridHeadingsInProductUpdates());

				for(WebElement lt:list)
				{
					CommonUtility.highlightElement(driver, lt);
					String label=lt.getText();

					System.out.println("Label is: " +label);
					labelList+=" <br> " + label;
				}
				System.out.println("Tabs are:"+labelList);

				List<WebElement> list1=driver.findElements(obj_UnifiedPortalPage.NotificationGridColumnValuesInProductUpdates());

				for(WebElement lt1:list1)
				{
					CommonUtility.highlightElement(driver, lt1);
					String label1=lt1.getText();

					System.out.println("product values " +label1);
					labelList1+=" <br> " + label1;
				}
				System.out.println("Tabs are:"+labelList1);


				Report.put("Verify the details in the Product Updates section",
						"The Product Updates section should be displayed with the existing Product Update notifications (or) Empty state if they have not created any subscriptions yet.", 
						"user able to see existing product update notifications, total number of existing notifications are "+count+" <br> and displays wth heading"+Report.color(labelList+" with following values as "+labelList1), "PASS");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify the details in the Product Updates section",
					"The Product Updates section should be displayed with the existing Product Update notifications (or) Empty state if they have not created any subscriptions yet.", 
					"The Product Updates section displayed with empty state with Add Notification button", "PASS");
			//				Assert.fail();
		}
	}


	public void  ClickOnAddNotificationButton(WebDriver driver) 
	{

		Log.info("Inside ClickOnAddNotificationButton method");

		String header = "";
		String text="";

		WebDriverWait  wait = new WebDriverWait(driver, 60);	
		try
		{
			handleCookies(driver);
			//			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_UnifiedPortalPage.AddNotificationButtonInProductUpdatesTab()));
			CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.AddNotificationButtonInProductUpdatesTab());
			text=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.AddNotificationButtonInProductUpdatesTab()).getText();
			System.out.println(text);
			CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.AddNotificationButtonInProductUpdatesTab());

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_UnifiedPortalPage.ChooseAProductHeading()));

			header = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.ChooseAProductHeading()).getText();

			System.out.println(header);

			Report.put("Click on the button Add Notification",
					"A popup should be displayed with the Choose a product", 
					"user able to click on "+Report.color(text)+" button and able to see pop up with heading "+Report.color(header), "PASS");

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on the button Add Notification",
					"A popup should be displayed with the Choose a product", 
					"Failed to click on Add Notification button", "FAIL");
			Assert.fail();
		}
	}


	public void  VerifyCancelAndAddProductButtons(WebDriver driver) 
	{

		Log.info("Inside VerifyCancelAndAddProductButtons method");

		String header = "";
		String text="";

		WebDriverWait  wait = new WebDriverWait(driver, 60);	
		try
		{
			handleCookies(driver);

			if(CommonUtility.CheckpresenceofElementLocated(driver, 10,  obj_UnifiedPortalPage.CancelButtonInAddNotificationPopUp()))
			{
				//				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_UnifiedPortalPage.CancelButtonInAddNotificationPopUp()));
				CommonUtility.scrollToViewElement(driver,obj_UnifiedPortalPage.CancelButtonInAddNotificationPopUp());
				text=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.CancelButtonInAddNotificationPopUp()).getText();
				System.out.println(text);
				CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.CancelButtonInAddNotificationPopUp());

				CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.AddProductInAddNotificationPopUp());

				header = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.AddProductInAddNotificationPopUp()).getText();

				System.out.println(header);

				Report.put("Verify the Cancel and Add product buttons in the popup",
						"Cancel and Add product buttons should be displayed in the popup", 
						"user able to see "+Report.color(text)+" button and "+Report.color(header)+" button in the popup", "PASS");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify the Cancel and Add product buttons in the popup",
					"Cancel and Add product buttons should be displayed in the popup", 
					"Failed to see Cancel and Add product buttons", "FAIL");
			Assert.fail();
		}
	}


	public void  ClickXMarkAtTopRightOfPopUp(WebDriver driver) 
	{

		Log.info("Inside ClickXMarkAtTopRightOfPopUp method");

		String header = "";
		String text="";

		WebDriverWait  wait = new WebDriverWait(driver, 60);	
		try
		{
			handleCookies(driver);

			if(CommonUtility.CheckpresenceofElementLocated(driver, 10,  obj_UnifiedPortalPage.XbuttononChooseAProductPopUp()))
			{
				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.XbuttononChooseAProductPopUp());
				CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.XbuttononChooseAProductPopUp());

				text=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.AddNotificationButtonInProductUpdatesTab()).getText();
				System.out.println(text);

				Report.put("Click on the X at the top right of popup",
						"The popup should be closed", 
						"user able to click on X at the top right of popup and pop up closed ", "PASS");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on the X at the top right of popup",
					"The popup should be closed", 
					"Failed to click on x at top right of popup", "FAIL");
			Assert.fail();
		}
	}


	public void  SerachForAProductAndClickOnCancel(WebDriver driver) 
	{

		Log.info("Inside SerachForAProductAndClickOnCancel method");

		String header = "";
		String text="";

		String value=TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[0];

		WebDriverWait  wait = new WebDriverWait(driver, 60);	
		try
		{
			handleCookies(driver);

			if(CommonUtility.CheckpresenceofElementLocated(driver, 10,  obj_UnifiedPortalPage.SearchTextBoxInAddingNotificationPopUp()))
			{
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_UnifiedPortalPage.SearchTextBoxInAddingNotificationPopUp()));
				CommonUtility.scrollToViewElement(driver,obj_UnifiedPortalPage.SearchTextBoxInAddingNotificationPopUp());
				CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.SearchTextBoxInAddingNotificationPopUp()).sendKeys(value);
				CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.SearchTextBoxInAddingNotificationPopUp()).sendKeys(Keys.ENTER);

				if(CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.AddProductInAddNotificationPopUp()).isEnabled())
				{
					System.out.println("Add Product button is enabled");
				}

				text=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.CancelButtonInAddNotificationPopUp()).getText();
				System.out.println(text);

				CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.CancelButtonInAddNotificationPopUp());


				if(!(CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.AddProductInAddNotificationPopUp()).isEnabled()))
				{
					System.out.println("Add Product button is not enabled");
				}

				Report.put("Make a selection in the dropdown and Click on the Cancel button",
						"The selection should be reset", 
						"user able to search product "+Report.color(value)+" and by clicking on "+Report.color(text)+" button, user able to see selection reset", "PASS");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Make a selection in the dropdown and Click on the Cancel button",
					"The selection should be reset",
					"Failed to search product", "FAIL");
			Assert.fail();
		}
	}


	public void  SerachForAProductAndClickOnAddProduct(WebDriver driver) 
	{

		Log.info("Inside SerachForAProductAndClickOnAddProduct method");

		String productlist = "";
		String text="";
		String text2="";
		String value=TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[0];

		WebDriverWait  wait = new WebDriverWait(driver, 60);	
		try
		{
			handleCookies(driver);

			if(CommonUtility.CheckpresenceofElementLocated(driver, 10,  obj_UnifiedPortalPage.SearchTextBoxInAddingNotificationPopUp()))
			{
				CommonUtility.scrollToViewElement(driver,obj_UnifiedPortalPage.SearchTextBoxInAddingNotificationPopUp());
				CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.SearchTextBoxInAddingNotificationPopUp()).sendKeys(value);
				CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.SearchTextBoxInAddingNotificationPopUp()).sendKeys(Keys.ENTER);

				if(CommonUtility.CheckpresenceofElementLocated(driver, 10,  obj_UnifiedPortalPage.ThisWillSelectNotificationsForTheEntireProductFamilyAlertMessageForAddingNotificationForProductFamily()))
				{
					VerifyCOnfirmationMessageForAddingProductFamily(driver);

				}

				if(CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.AddProductInAddNotificationPopUp()).isEnabled())
				{

					text=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.AddProductInAddNotificationPopUp()).getText();
					System.out.println(text);
					System.out.println("Add Product button is enabled");

					CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.AddProductInAddNotificationPopUp());
				}

				if(CommonUtility.CheckpresenceofElementLocated(driver, 10,  obj_UnifiedPortalPage.SuccessfullyAddedMessageInProductUpdates()))
				{
					wait.until(ExpectedConditions.visibilityOfElementLocated(obj_UnifiedPortalPage.SuccessfullyAddedMessageInProductUpdates()));
					text2=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.SuccessfullyAddedMessageInProductUpdates()).getText();
					System.out.println(text2);
				}
				Thread.sleep(10000);
				if(CommonUtility.CheckpresenceofElementLocated(driver, 10,  obj_UnifiedPortalPage.ProductNameValidations()))
				{
					List<WebElement> list=driver.findElements(obj_UnifiedPortalPage.ProductNameValidations());

					for(WebElement lt:list)
					{
						CommonUtility.highlightElement(driver, lt);
						String text1=lt.getText();

						System.out.println("Text is: " +text1);
						productlist+=" <br> " + text1;

					}
					System.out.println("products are "+productlist);	

					if(productlist.contains(value))
					{
						System.out.println("Product added succesfully");
					}
				}


				Report.put("Make a selection in the dropdown and Click on the Add Product button",
						"A confirmation message should be displayed in green and disappears in 2600ms", 
						"user able to search product "+Report.color(value)+" and by clicking on "+Report.color(text)+" button,<br> user able to see product added in the notification grid with message"+Report.color(text2)+" and product display in the grid list"+Report.color(productlist), "PASS");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Make a selection in the dropdown and Click on the Add Product button",
					"A confirmation message should be displayed in green and disappears in 2600ms", 
					"Failed to search product", "FAIL");
			Assert.fail();
		}
	}


	public void  VerifyAlertMessageForDuplicateProductAddition(WebDriver driver) 
	{

		Log.info("Inside VerifyAlertMessageForDuplicateProductAddition method");

		String header = "";
		String text="";

		WebDriverWait  wait = new WebDriverWait(driver, 60);	
		try
		{
			handleCookies(driver);

			if(CommonUtility.CheckpresenceofElementLocated(driver, 10,  obj_UnifiedPortalPage.ANotificationForThisProductAlreadyExistsAlertMessageForDuplicateProductNotificationAddition()))
			{
				CommonUtility.scrollToViewElement(driver,obj_UnifiedPortalPage.ANotificationForThisProductAlreadyExistsAlertMessageForDuplicateProductNotificationAddition());
				text=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.ANotificationForThisProductAlreadyExistsAlertMessageForDuplicateProductNotificationAddition()).getText();
				System.out.println(text);

				Report.put("select the same product/product family already existing in their list of notifications,",
						"select a Product already existing in their list of notifications,then a message will be displayed", 
						"user able to see alert message for searching duplicate product as "+Report.color(text), "PASS");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("select the same product/product family already existing in their list of notifications,",
					"select a Product already existing in their list of notifications,then a message will be displayed",  
					"Alert message not displayed", "FAIL");
			Assert.fail();
		}
	}


	public void  VerifyCOnfirmationMessageForAddingProductFamily(WebDriver driver) 
	{

		Log.info("Inside VerifyCOnfirmationMessageForAddingProductFamily method");

		String header = "";
		String text="";

		WebDriverWait  wait = new WebDriverWait(driver, 60);	
		try
		{
			handleCookies(driver);

			if(CommonUtility.CheckpresenceofElementLocated(driver, 10,  obj_UnifiedPortalPage.ThisWillSelectNotificationsForTheEntireProductFamilyAlertMessageForAddingNotificationForProductFamily()))
			{
				CommonUtility.scrollToViewElement(driver,obj_UnifiedPortalPage.ThisWillSelectNotificationsForTheEntireProductFamilyAlertMessageForAddingNotificationForProductFamily());
				text=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.ThisWillSelectNotificationsForTheEntireProductFamilyAlertMessageForAddingNotificationForProductFamily()).getText();
				System.out.println(text);

				Report.put("Search any Product Family in Searchbox for choose a product e.g. SAN Copy Series and observe that information message",
						"A confirmation popup message should be displayed as 'This will select notifications for the entire product family.'", 
						"user able to see confirmation message for adding product family as "+Report.color(text), "PASS");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Search any Product Family in Searchbox for choose a product e.g. SAN Copy Series and observe that information message",
					"A confirmation popup message should be displayed as 'This will select notifications for the entire product family.'",  
					"confirmation message not displayed", "FAIL");
			Assert.fail();
		}
	}


	public void  ClickOnDeleteButtonForOneProductInTheProductUpdatesNotificationList(WebDriver driver) 
	{

		Log.info("Inside ClickOnDeleteButtonForOneProductInTheProductUpdatesNotificationList method");

		String header = "";
		String text="";
		String header1="";
		String text2="";

		WebDriverWait  wait = new WebDriverWait(driver, 60);	
		try
		{
			handleCookies(driver);
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_UnifiedPortalPage.DeleteButtonsInProductUpdate()));
			CommonUtility.ScrollTo(driver, obj_UnifiedPortalPage.DeleteButtonsInProductUpdate());
			CommonUtility.ClickOn(driver, obj_UnifiedPortalPage.DeleteButtonsInProductUpdate());
			CommonUtility.ClickOn(driver, obj_UnifiedPortalPage.DeleteButton());

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_UnifiedPortalPage.DeleteNotificationHeadingInPopUp()));
			CommonUtility.scrollToViewElement(driver, obj_UnifiedPortalPage.DeleteNotificationHeadingInPopUp());
			header = CommonUtility.highlightElement(driver, obj_UnifiedPortalPage.DeleteNotificationHeadingInPopUp()).getText();

			System.out.println(header);
			//			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_UnifiedPortalPage.ProductUpdatesTab()));
			CommonUtility.scrollToViewElement(driver, obj_UnifiedPortalPage.DeleteNotificationPopUpDescription());
			header1 = CommonUtility.highlightElement(driver, obj_UnifiedPortalPage.DeleteNotificationPopUpDescription()).getText();

			System.out.println(header1);
			CommonUtility.scrollToViewElement(driver, obj_UnifiedPortalPage.CancelButtonInDeleteNotificationPopUp());
			text = CommonUtility.highlightElement(driver, obj_UnifiedPortalPage.CancelButtonInDeleteNotificationPopUp()).getText();

			System.out.println(text);
			CommonUtility.scrollToViewElement(driver, obj_UnifiedPortalPage.ConfirmButtonInDeleteNotificationPopUp());
			text2 = CommonUtility.highlightElement(driver, obj_UnifiedPortalPage.ConfirmButtonInDeleteNotificationPopUp()).getText();

			System.out.println(text2);


			Report.put("Click on the Delete button for one product in the list",
					"A confirmation popup should be displayed for the user to confirm / cancel the delete", 
					"user able to click on delete button and able to see "+Report.color(header)+" pop up with description "+Report.color(header1)+" and able to see "+Report.color(text+" and "+text2)+" buttons", "PASS");

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on the Delete button for one product in the list",
					"A confirmation popup should be displayed for the user to confirm / cancel the delete",   
					"Failed click on delete button", "FAIL");
			Assert.fail();
		}
	}

	public void  ClickOnXOrCancelButtonInDeletePopUp(WebDriver driver) 
	{

		Log.info("Inside ClickOnXOrCancelButtonInDeletePopUp method");

		String header = "";
		String text="";


		WebDriverWait  wait = new WebDriverWait(driver, 60);	
		try
		{
			handleCookies(driver);
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_UnifiedPortalPage.XmarkInDeleteNotificationPopUp()));
			//	CommonUtility.scrollToViewElement(driver, obj_UnifiedPortalPage.XmarkInDeleteNotificationPopUp());
			CommonUtility.ClickOn(driver, obj_UnifiedPortalPage.XmarkInDeleteNotificationPopUp());

			text=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.AddNotificationButtonInProductUpdatesTab()).getText();
			System.out.println(text);


			Report.put("Click on the Cancel button or X link at the top right corner of the popup",
					"The popup should be closed and delete selection should be cancelled and Product Updates page should be displayed", 
					"Able to click on X button at the right top corner of pop up, and clicking on X button delete pop up closed and Product Updates page displayed", "PASS");

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on the Cancel button or X link at the top right corner of the popup",
					"The popup should be closed and delete selection should be cancelled and Product Updates page should be displayed",  
					"Failed click on X button", "FAIL");
			Assert.fail();
		}
	}

	public void  ClickOnConfirmButtonInDeleteNotificationPopUp(WebDriver driver) 
	{

		Log.info("Inside ClickOnConfirmButtonInDeleteNotificationPopUp method");

		String header1 = "";
		String text="";
		String productlist="";

		WebDriverWait  wait = new WebDriverWait(driver, 60);	
		try
		{
			handleCookies(driver);

			CommonUtility.scrollToViewElement(driver, obj_UnifiedPortalPage.DeleteNotificationPopUpDescription());
			header1 = CommonUtility.highlightElement(driver, obj_UnifiedPortalPage.DeleteNotificationPopUpDescription()).getText();

			System.out.println(header1);
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_UnifiedPortalPage.ConfirmButtonInDeleteNotificationPopUp()));
			CommonUtility.scrollToViewElement(driver, obj_UnifiedPortalPage.ConfirmButtonInDeleteNotificationPopUp());
			CommonUtility.ClickOn(driver, obj_UnifiedPortalPage.ConfirmButtonInDeleteNotificationPopUp());

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_UnifiedPortalPage.SuccessfullyDeletedMessage()));
			text=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.SuccessfullyDeletedMessage()).getText();
			System.out.println(text);

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_UnifiedPortalPage.ProductNameValidationsForDeletion()));
			productlist=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.ProductNameValidationsForDeletion()).getText();
			System.out.println(productlist);




			if(!(header1.contains(productlist)))
			{
				System.out.println("Product deleted succesfully");
			}

			Report.put("Click on the button Confirm in the popup and <br> Verify if the deleted product has been removed the users Product List",
					"A successful delete message should be displayed <br> and The deleted product should be removed and not displayed ", 
					"able to click on confirm button on delete notification pop up and able to see message as "+Report.color(text), "PASS");

			Report.put("Verify if the deleted product has been removed the users Product List",
					"The deleted product should be removed and not displayed ", 
					"Product deleted successfully from the grid", "PASS");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on the button Confirm in the popup",
					"A successful delete message should be displayed", 
					"Failed click on confirm button", "FAIL");
			Assert.fail();
		}
	}


	public void  SearchForADuplicateProductAndClickOnAddProduct(WebDriver driver) 
	{

		Log.info("Inside SearchForADuplicateProductAndClickOnAddProduct method");

		String productlist = "";
		String text="";
		String text2="";
		String value=TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[0];

		WebDriverWait  wait = new WebDriverWait(driver, 60);	
		try
		{
			handleCookies(driver);

			if(CommonUtility.CheckpresenceofElementLocated(driver, 10,  obj_UnifiedPortalPage.SearchTextBoxInAddingNotificationPopUp()))
			{
				CommonUtility.scrollToViewElement(driver,obj_UnifiedPortalPage.SearchTextBoxInAddingNotificationPopUp());
				CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.SearchTextBoxInAddingNotificationPopUp()).sendKeys(value);
				CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.SearchTextBoxInAddingNotificationPopUp()).sendKeys(Keys.ENTER);


				Report.put("Make a selection in the dropdown in pop up",
						"user should able to search product ", 
						"user able to search product "+Report.color(value), "PASS");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Make a selection in the dropdown in pop up",
					"user should able to search product ", 
					"Failed to search product", "FAIL");
			Assert.fail();
		}
	}


	public void  VerifyDefaultEmailAddress(WebDriver driver) 
	{

		Log.info("Inside VerifyDefaultEmailAddress method");

		String header = "";
		String text="";
		String text1="";
		String text2="";

		WebDriverWait  wait = new WebDriverWait(driver, 60);	
		try
		{
			//handleCookies(driver);
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_UnifiedPortalPage.DeliveryPreferencesSectionInProductUpdates()));

			//				CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.ProductAdvisoriesTab()).click();
			text=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.DeliveryPreferencesHeadingInProductUpdates()).getText();
			System.out.println(text);

			if(CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.SendEmailAndFrequesncyPreferencesInProductUpdates()).isDisplayed())
			{


				text1 = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.GetEmailDisplayedDefaultValueInProductUpdates()).getText();

				System.out.println(text1);

				WebElement element=driver.findElement(By.xpath("//select[@id='product-updates_email']"));
				Select s=new Select(element);

				List<WebElement> list= s.getOptions();
				int countlist=list.size();
				System.out.println("count of drop down values are "+countlist);

				for(int i=0;i<countlist;i++)
				{
					header+="<br>"+list.get(i).getText();
					System.out.println("issue list "+header);

				}

				//				s.getClass();
				//				
				//				System.out.println("class is "+s.getClass());
				//				
				//				if(s.getClass().equals("form-control ng-pristine ng-valid ng-touched"))
				//				{
				//					System.out.println("default selected email is ");
				//					text2 = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.DefaultDisplayedEmailInProductUpdatesTab()).getText();
				//
				//					System.out.println(text2);
				//				}



				Report.put("Verify the default email address displayed",
						"The email should be defaulted to the business email address", 
						"user able to defaulted email address displayed as "+Report.color(header), "PASS");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify the default email address displayed",
					"The email should be defaulted to the business email address", 
					"Failed to see default selected email", "FAIL");
			Assert.fail();
		}
	}


	public void  ChangeEmailInProductUpdates(WebDriver driver) 
	{

		Log.info("Inside ChangeEmailInProductUpdates method");

		String header = "";
		String text="";
		String text1="";
		String text2="";

		WebDriverWait  wait = new WebDriverWait(driver, 60);	
		try
		{
			//	handleCookies(driver);
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_UnifiedPortalPage.DeliveryPreferencesSectionInProductUpdates()));

			//				CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.ProductAdvisoriesTab()).click();
			text=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.DeliveryPreferencesHeadingInProductUpdates()).getText();
			System.out.println(text);

			if(CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.SendEmailAndFrequesncyPreferencesInProductUpdates()).isDisplayed())
			{

				text1 = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.GetEmailDisplayedDefaultValueInProductUpdates()).getText();

				System.out.println(text1);
				WebElement element=driver.findElement(By.xpath("//select[@id='product-updates_email']"));
				Select s=new Select(element);

				List<WebElement> list= s.getOptions();
				int countlist=list.size();
				System.out.println("count of drop down values are "+countlist);

				for(int i=0;i<countlist;i++)
				{
					text+="<br>"+list.get(i).getText();
					System.out.println("issue list "+text);

				}
				s.selectByValue("2");

				Report.put("Verify if the user can change the defaulted email ID ",
						"User should have the ability to select between Business and Alternate email address's", 
						"user able to select email addresses from drop down", "PASS");
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify if the user can change the defaulted email ID ",
					"User should have the ability to select between Business and Alternate email address's", 
					"Failed to change email in product updates", "FAIL");
			Assert.fail();
		}
	}


	public void  CheckForNumberOfResultsUserCanSelectForPagination(WebDriver driver) 
	{

		Log.info("Inside CheckForNumberOfResultsUserCanSelectForPagination method");

		String header = "";
		String text="";
		String text1="";
		String text2="";

		WebDriverWait  wait = new WebDriverWait(driver, 60);	
		try
		{
			//handleCookies(driver);
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_UnifiedPortalPage.DefaultDisplayedNumberOfNotificationPerPageInGridValidationsInProductUpdatesTab()));

			//				CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.ProductAdvisoriesTab()).click();
			text=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.DefaultDisplayedNumberOfNotificationPerPageInGridValidationsInProductUpdatesTab()).getText();
			System.out.println(text);

			if(CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.DefaultDisplayedNumberOfNotificationPerPageInGridValidationsInProductUpdatesTab()).isDisplayed())
			{

				text1 = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.DefaultDisplayedNumberOfNotificationPerPageInGridValidationsInProductUpdatesTab()).getText();

				System.out.println(text1);
				WebElement element=driver.findElement(By.xpath("//select[@id='product-updates_pagination_page_sizes']"));
				Select s=new Select(element);

				List<WebElement> list= s.getOptions();
				int countlist=list.size();
				System.out.println("count of drop down values are "+countlist);

				for(int i=0;i<countlist;i++)
				{
					text+="<br>"+list.get(i).getText();
					System.out.println("result list "+text);

				}
				System.out.println(text);

				Report.put("Verify the number of results user can select for pagination",
						"User should be able to choose the number of results displayed on the page from the following values: 10,25,50,100,All", 
						"user able to see number of results displayed on the page with the values displayed are "+Report.color(text), "PASS");
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify the number of results user can select for pagination",
					"User should be able to choose the number of results displayed on the page from the following values: 10,25,50,100,All", 
					"Failed to see numbers in pagination dropdown", "FAIL");
			Assert.fail();
		}
	}


	public void  VerifyDefaultNumberOfResultsInAPage(WebDriver driver) 
	{

		Log.info("Inside VerifyDefaultNumberOfResultsInAPage method");

		String header = "";
		String text="";
		String text1="";
		String text2="";

		WebDriverWait  wait = new WebDriverWait(driver, 60);	
		try
		{
			//handleCookies(driver);
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_UnifiedPortalPage.DefaultDisplayedNumberOfNotificationPerPageInGridValidationsInProductUpdatesTab()));


			text=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.DefaultDisplayedNumberOfNotificationPerPageInGridValidationsInProductUpdatesTab()).getText();
			System.out.println(text);

			if(CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.DefaultDisplayedNumberOfNotificationPerPageInGridValidationsInProductUpdatesTab()).isDisplayed())
			{

				text1 = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.DefaultDisplayedNumberOfNotificationPerPageInGridValidationsInProductUpdatesTab()).getText();

				System.out.println(text1);
				WebElement element=driver.findElement(By.xpath("//select[@id='product-updates_pagination_page_sizes']"));
				Select s=new Select(element);

				List<WebElement> list= s.getOptions();
				int countlist=list.size();
				System.out.println("count of drop down values are "+countlist);

				for(int i=0;i<countlist;i++)
				{
					header+="<br>"+list.get(i).getText();
					System.out.println("result list "+header);

				}
				//				s.getClass();
				//				
				//				System.out.println("class is "+s.getClass());
				//				
				//				if(s.getClass().equals("form-control ng-pristine ng-valid ng-touched"))
				//				{
				//					System.out.println("default selected number of results ");
				//					text2 = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.DefaultDisplayedResultsPerPageInGridInProductUpdatesTab()).getText();
				//
				//					System.out.println(text2);
				//				}

				Report.put("Verify the default number of results in a page",
						"Default value should always be  set to 10 results per page", 
						"user able to see default number of results in a page is "+Report.color(header), "PASS");
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify the default number of results in a page",
					"Default value should always be  set to 10 results per page", 
					"Failed to see default numbers delected in pagination dropdown", "FAIL");
			Assert.fail();
		}
	}


	public void  VerifyIfUserCanEnterNumberInTextBoxAndNavigateThroghPagesWithTheHelpOfPagination(WebDriver driver) 
	{

		Log.info("Inside VerifyIfUserCanEnterNumberInTextBoxAndNavigateThroghPagesWithTheHelpOfPagination method");

		String header = "";
		String text="";
		String text1="";
		String text2="";

		String value=TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[0];

		WebDriverWait  wait = new WebDriverWait(driver, 60);	
		try
		{
			//	handleCookies(driver);
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_UnifiedPortalPage.TextEntryToSwitchPagesInProductUpdates()));

			//				CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.ProductAdvisoriesTab()).click();
			text=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.TextEntryToSwitchPagesInProductUpdates()).getText();
			System.out.println(text);
			CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.TextEntryToSwitchPagesInProductUpdates()).clear();
			CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.TextEntryToSwitchPagesInProductUpdates()).sendKeys(value);
			Thread.sleep(10000);
			text1=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.TextEntryToSwitchPagesInProductUpdates()).getText();
			System.out.println(text1);

			if(text1.contains(value))
			{

				System.out.println("user able to see entered number in pagination text box");
			}

			Report.put("Verify if the user can enter a number in the text box and navigate through pages with the help of pagination ",
					"User should be able to navigate through pages", 
					"User able to enter number in pagination text box to navigate through pages", "PASS");



		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify if the user can enter a number in the text box and navigate through pages with the help of pagination ",
					"User should be able to navigate through pages",  
					"Failed to enter number in pagination text box", "FAIL");
			Assert.fail();
		}
	}


	public void  ValidatePaginationSectionDisabledForSinglePage(WebDriver driver) 
	{

		Log.info("Inside ValidatePaginationSectionDisabledForSinglePage method");

		String header = "";
		String text="";
		String text1="";
		String text2="";

		String value=TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[0];

		WebDriverWait  wait = new WebDriverWait(driver, 60);	
		try
		{
			//handleCookies(driver);
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_UnifiedPortalPage.TextEntryToSwitchPagesInProductUpdates()));


			text=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.TextEntryToSwitchPagesInProductUpdates()).getText();
			System.out.println(text);

			if(!(CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.ArrowMarkToDisplayFirstPageOfPaginationInProductUpdatesTab()).isEnabled()))
			{
				System.out.println("arrow mark to first page is enabled");
			}

			if(!(CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.ArrowMarkToDisplayPreviousPageOfPaginationInProductUpdatesTab()).isEnabled()))
			{
				System.out.println("arrow mark to first page is enabled");
			}

			if(!(CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.ArrowMarkToDisplayNextPageOfPaginationInProductUpdatesTab()).isEnabled()))
			{
				System.out.println("arrow mark to first page is enabled");
			}

			if(!(CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.ArrowMarkToDisplayLastPageOfPaginationInProductUpdatesTab()).isEnabled()))
			{
				System.out.println("arrow mark to first page is enabled");
			}

			Report.put("Select the number of records accordingly so that there is only a single page",
					"The user should be able to select and pagination section should be disabled", 
					"User able to pagination section disabled for only a single page of records", "PASS");


		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Select the number of records accordingly so that there is only a single page",
					"The user should be able to select and pagination section should be disabled", 
					"Failed to see pagination disabled for only single page of records", "FAIL");
			Assert.fail();
		}
	}


	public void  VerifyDefaultSortOfGridPage(WebDriver driver) 
	{

		Log.info("Inside VerifyDefaultSortOfGridPage method");

		String header = "";
		String text="";
		String labelList="";
		String labelList1="";
		String labelList2="";

		String att="";

		WebDriverWait  wait = new WebDriverWait(driver, 60);	
		try
		{
			//handleCookies(driver);
			if(CommonUtility.CheckpresenceofElementLocated(driver, 10,  obj_UnifiedPortalPage.NotificationColumnGridHeadingsInProductUpdates()))
			{

				CommonUtility.scrollToViewElement(driver,obj_UnifiedPortalPage.NotificationColumnGridHeadingsInProductUpdates());

				List<WebElement> list=driver.findElements(obj_UnifiedPortalPage.NotificationColumnGridHeadingsInProductUpdates());

				for(int i=0;i<list.size();i++)
				{
					if(i==0)
					{
						CommonUtility.highlightElement(driver, list.get(i));
						String label=list.get(i).getText();
						att=list.get(i).getAttribute("aria-sort");

						System.out.println(label);
						System.out.println(att);

						if(!(att.contains("ascending")))
						{
							System.out.println("sort is not ascending");

							Report.put("Verify the default sort of grid page",
									"Initial page load should be displayed with the grid results sorted by Product' column in ascending order", 
									"grid results not sorted by product's column in ascending order by default", "FAIL");
							Assert.fail();
						}

					}
				}

				List<WebElement> list1=driver.findElements(obj_UnifiedPortalPage.NotificationGridColumnValuesInProductUpdates());

				for(WebElement lt1:list1)
				{
					CommonUtility.highlightElement(driver, lt1);
					String label1=lt1.getText();

					System.out.println("product values " +label1);
					labelList1+=" <br> " + label1;
				}
				System.out.println("Tabs are:"+labelList1);


				Report.put("Verify the default sort of grid page",
						"Initial page load should be displayed with the grid results sorted by Product' column in ascending order", 
						"user able to see Grid results sorted by product's column in "+Report.color(att)+" order<br> and displayed as "+Report.color(labelList1), "PASS");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify the default sort of grid page",
					"Initial page load should be displayed with the grid results sorted by Product' column in ascending order", 
					"grid results not sorted by product's column in ascending order by default", "FAIL");
			Assert.fail();
		}
	}


	public void  SortRecordsInDescendingOrderInProductUpdatesGrid(WebDriver driver) 
	{

		Log.info("Inside SortRecordsInDescendingOrderInProductUpdatesGrid method");

		String header = "";
		String text="";
		String labelList="";
		String labelList1="";
		String labelList2="";

		String att="";

		WebDriverWait  wait = new WebDriverWait(driver, 60);	
		try
		{
			//handleCookies(driver);
			if(CommonUtility.CheckpresenceofElementLocated(driver, 10,  obj_UnifiedPortalPage.NotificationColumnGridHeadingsInProductUpdates()))
			{

				CommonUtility.scrollToViewElement(driver,obj_UnifiedPortalPage.NotificationColumnGridHeadingsInProductUpdates());

				List<WebElement> list=driver.findElements(obj_UnifiedPortalPage.NotificationColumnGridHeadingsInProductUpdates());

				for(int i=0;i<list.size();i++)
				{
					if(i==0)
					{
						CommonUtility.scrollToViewElement(driver, list.get(i));
						CommonUtility.highlightElement(driver, list.get(i));

						list.get(i).click();
						Thread.sleep(10000);
						String label=list.get(i).getText();
						att=list.get(i).getAttribute("aria-sort");

						System.out.println(label);
						System.out.println(att);

						if(!(att.contains("descending")))
						{
							System.out.println("sort is not descending");

							Report.put("Sort the records in descending order",
									"User should be able to sort in ascending or descending order", 
									"grid results not sorted by product's column in descending order after clicking on Products column to change the order", "FAIL");
							Assert.fail();
						}

					}
				}

				List<WebElement> list1=driver.findElements(obj_UnifiedPortalPage.NotificationGridColumnValuesInProductUpdates());

				for(WebElement lt1:list1)
				{
					CommonUtility.highlightElement(driver, lt1);
					String label1=lt1.getText();

					System.out.println("product values " +label1);
					labelList1+=" <br> " + label1;
				}
				System.out.println("Tabs are:"+labelList1);


				Report.put("Sort the records in descending order",
						"User should be able to sort in ascending or descending order", 
						"user able to see Grid results sorted by product's column in "+Report.color(att)+" order after clicking on Product's column to change order <br> and displayed as "+Report.color(labelList1), "PASS");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Sort the records in descending order",
					"User should be able to sort in ascending or descending order", 
					"grid results not sorted by product's column in descending order after clikcing on products column to change the order", "FAIL");
			Assert.fail();
		}
	}

	public void verifyNotificationNameDescriptionfields(WebDriver driver)
	{
		System.out.println("Inside verifyNotificationNameDescriptionfields method");
		Log.info("Inside verifyNotificationNameDescriptionfields method");

		String button = "";

		String SREventsNotificationHeader = "";
		String notificationName = "";
		String notificationDesc = "";
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);				

			CommonUtility.scrollToViewElement(driver,obj_UnifiedPortalPage.SRNotificationNameField());
			CommonUtility.scrollToViewElement(driver,obj_UnifiedPortalPage.SRNotificationDescription());		

			notificationName = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.SRNotificationNameField()).getText();
			notificationDesc = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.SRNotificationDescription()).getText();

			System.out.println("notificationName is:  "+notificationName);
			System.out.println("notificationDesc is:  "+notificationDesc);

			Report.put("Verify name and description fields in Service Request Events Page",
					"A form should be displayed with the name and description fields ",
					"Displayed fields"+Report.color(notificationName)+Report.color(notificationDesc), "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify name and description fields in Service Request Events Page",
					"A form should be displayed with the name and description fields ",
					"Failed to load Service Request Events page", "FAIL");
			Assert.fail();
		}
	}

	public void selectSRNotificationPopupProductsDropdown(WebDriver driver, String option)
	{
		System.out.println("Inside selectSRNotificationPopupProductsDropdown method");
		Log.info("Inside selectSRNotificationPopupProductsDropdown method");

		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);

			System.out.println("Option from Testdata is: "+option);		



			Select selOption = new  Select(driver.findElement(obj_UnifiedPortalPage.SRNotificationPopupProductsDropdown()));

			selOption.selectByVisibleText(option); 
			System.out.println("Selected: "+option);


			Report.put("Select the option 'My Product Groups'  from the dropdown.",
					"''My Product Groups'  should be selected from the dropdown",
					"Selected "+Report.color(option)+"from the dropdown", "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Select the option 'My Product Groups'  from the dropdown.",
					"''My Product Groups'  should be selected from the dropdown",
					"Failed to select 'My Product Groups' from the dropdown", "FAIL");
			Assert.fail();
		}
	}

	public void verifySRNotificationCreateEditGroupLink(WebDriver driver)
	{
		System.out.println("Inside verifySRNotificationCreateEditGroupLink method");
		Log.info("Inside verifySRNotificationCreateEditGroupLink method");

		String link = "";		

		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);				


			link = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.SRNotificationPopupCreateEditGroupLink()).getText();

			System.out.println("Link is:  "+link);

			Report.put("Verify the link  'Add/Edit Product Group'  is displayed",
					"The link 'Add/Edit Product Group' should be displayed ",
					"Displayed link"+Report.color(link), "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify the link  'Add/Edit Product Group'  is displayed",
					"The link 'Add/Edit Product Group' should be displayed ",
					"Failed to display link 'Add/Edit Product Group'", "FAIL");
			Assert.fail();
		}
	}	

	public void clickSRNotificationCreateEditGroupLink(WebDriver driver)
	{
		System.out.println("Inside clickSRNotificationCreateEditGroupLink method");
		Log.info("Inside clickSRNotificationCreateEditGroupLink method");

		String link = "";		
		String header = "";
		String title = "";
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);				


			link = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.SRNotificationPopupCreateEditGroupLink()).getText();

			System.out.println("Link is:  "+link);

			CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.SRNotificationPopupCreateEditGroupLink()).click();

			Set<String> allWH=driver.getWindowHandles(); 
			String currentwindow=driver.getWindowHandle();
			int countWindow=allWH.size(); 

			System.out.println("Switched Window Handles and  window count is :: "+countWindow);

			for(String wh:allWH)
			{
				Thread.sleep(10000);
				driver.switchTo().window(wh); 
				String url=driver.getCurrentUrl();
				System.out.println("URL displayed as   :::::"+url); 

				if(url.contains("mycustomgroups"))
				{
					title = driver.getTitle();
					System.out.println("Switched to window" +title);		

					wait.until(ExpectedConditions.visibilityOfElementLocated(obj_UnifiedPortalPage.myCustomGroupHeader()));
					CommonUtility.highlightElement(driver, obj_UnifiedPortalPage.myCustomGroupHeader());
					header = CommonUtility.highlightElement(driver, obj_UnifiedPortalPage.myCustomGroupHeader()).getText();

					driver.close();
					driver.switchTo().window(currentwindow);						
				}	
			}
			Report.put("Click on the link 'Add/Edit Product Group'",
					"User should be  navigated to custom groups landing page in a separate tab",
					"Navigated to page with title"+Report.color(title) +"Header is:"+Report.color(header), "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on the link 'Add/Edit Product Group'",
					"User should be  navigated to custom groups landing page in a separate tab",
					"Failed to navigate  to custom groups landing page in a separate tab", "FAIL");
			Assert.fail();
		}
	}	

	public void verifyMyCustomGroupsColumns(WebDriver driver)
	{
		System.out.println("Inside verifyMyCustomGroupsColumns method");
		Log.info("Inside verifyMyCustomGroupsColumns method");

		String columnList = "";

		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);

			List<WebElement> list=driver.findElements(obj_UnifiedPortalPage.myCustomGroupsColumns());

			for(WebElement lt:list)
			{
				CommonUtility.highlightElement(driver, lt);
				String column=lt.getText();

				System.out.println("Column is: " +column);
				columnList+=" <br> " + column;
			}
			System.out.println("Columns are:"+columnList);					


			Report.put("User sees the following columns in grid: Custom Group Name, Description, Type, Items, Created, Actions ",
					"User should be able to see the below columns on the page: Custom Group Name, Description, Type, Items, Created, Actions ",
					"Displayed columns successfully."+Report.color(columnList), "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("User sees the following columns in grid: Custom Group Name, Description, Type, Items, Created, Actions ",
					"User should be able to see the below columns on the page: Custom Group Name, Description, Type, Items, Created, Actions ",
					"Failed to Display the columns", "FAIL");
			Assert.fail();
		}
	}

	public void filterCustomGroups(WebDriver driver, String input)
	{
		System.out.println("Inside filterCustomGroups method");
		Log.info("Inside filterCustomGroups method");

		String productName = "";
		String accountList = "";
		String defaultList = "";
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);

			System.out.println("Input from Testdata is: "+input);						
			Thread.sleep(10000);
			CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.myCustomGroupSearchTextbox()).sendKeys(input);	

			CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.myCustomGroupFilterButton());
			Thread.sleep(10000);	

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_UnifiedPortalPage.customGroupTableContent()));
			CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.customGroupTableContent());

			Report.put("User sees Filter Custom Groups Tab",
					"User should be able to search based on the following data columns and results need to span across the entire data set and not just the page user is on Custom Group Name, Description, Type ",
					"Displayed columns based on search"+Report.color(input), "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("User sees Filter Custom Groups Tab",
					"User should be able to search based on the following data columns and results need to span across the entire data set and not just the page user is on Custom Group Name, Description, Type ",
					"Failed to Display the columns  based on search", "FAIL");
			Assert.fail();
		}
	}

	public void clickMyCustomGroupsClearButton(WebDriver driver)
	{
		System.out.println("Inside clickMyCustomGroupsClearButton method");
		Log.info("Inside clickMyCustomGroupsClearButton method");

		String productName = "";
		String accountList = "";
		String defaultList = "";
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);			

			CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.myCustomGroupsClearButton());

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_UnifiedPortalPage.customGroupTableContent()));


			//			List<WebElement> defaultLlist=driver.findElements(obj_UnifiedPortalPage.accountSiteFilterList());
			//
			//			for(WebElement lt:defaultLlist)
			//			{
			//				CommonUtility.highlightElement(driver, lt);
			//				String text=lt.getText();
			//
			//				System.out.println("Text is: " +text);
			//				defaultList+=" <br> " + text;
			//
			//			}
			//			System.out.println("Default Accounts are:"+defaultList);	

			Report.put("When user clicks on 'X' option",
					"The grid should go back to its original state ",
					"Displayed grid successfully ", "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("When user clicks on 'X' option",
					"The grid should go back to its original state ",
					"Failed to display the grid", "FAIL");
			Assert.fail();
		}
	}

	public void verifyMyCustomGroupsDownloadButton(WebDriver driver)
	{
		System.out.println("Inside verifyMyCustomGroupsDownloadButton method");
		Log.info("Inside verifyMyCustomGroupsDownloadButton method");

		String text = "";
		String header = "";
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);			

			text = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.myCustomGroupsDownloadButton()).getText();

			CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.myCustomGroupsDownloadButton());

			System.out.println("Button present: "+text);	

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_UnifiedPortalPage.myCustomGroupsDownloadPopupHeader()));
			CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.myCustomGroupsDownloadPopupHeader());

			header  = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.myCustomGroupsDownloadPopupHeader()).getText();

			System.out.println("Download header "+header);	

			CommonUtility.ClickOn(driver, obj_UnifiedPortalPage.downloadPopupXButton());
			//CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.downloadPopupDownloadButton()).click();

			Report.put("User sees Download tab and clicks on it",
					"User should be able to download/export the list of custom groups ",
					"Clicked on"+Report.color(text) +"Displayed download popup "+Report.color(header), "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("User sees Download tab and clicks on it",
					"User should be able to download/export the list of custom groups ",
					"Failed to display download popup", "FAIL");
			Assert.fail();
		}
	}

	public void verifySortingOptionColumns(WebDriver driver)
	{
		System.out.println("Inside verifySortingOptionColumns method");
		Log.info("Inside verifySortingOptionColumns method");

		String text = "";
		String header = "";
		String labelList = "";
		int count  = 0;
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);	

			List<WebElement> list=driver.findElements(obj_UnifiedPortalPage.myCustomGroupsSortableColumns());

			count = list.size();
			String countString = Integer.toString(count);

			System.out.println("Number of sortable columns are: "+countString);	

			List<WebElement> sortableList=driver.findElements(obj_UnifiedPortalPage.myCustomGroupsSortableColumnsName());

			for(WebElement lt:sortableList)
			{
				CommonUtility.highlightElement(driver, lt);
				String label=lt.getText();

				System.out.println("Label is: " +label);
				labelList+=" <br> " + label;
			}
			System.out.println("Tabs are:"+labelList);					


			Report.put("User sees the Sorting option under  below columns: Custom Group Name, Description, Type, Items, Created",
					"User should be able to sort the following columns: Custom Group Name, Description, Type, Items, Created",
					"Count of Sortable Columns: "+Report.color(countString) +"Column names: "+Report.color(labelList), "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("User sees the Sorting option under  below columns: Custom Group Name, Description, Type, Items, Created",
					"User should be able to sort the following columns: Custom Group Name, Description, Type, Items, Created",
					"Failed to display Sortable Columns", "FAIL");
			Assert.fail();
		}
	}

	public void verifyDeleteCustomGroupOption(WebDriver driver)
	{
		System.out.println("Inside verifyDeleteCustomGroupOption method");
		Log.info("Inside verifyDeleteCustomGroupOption method");

		String deleteOption = "";

		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);

			CommonUtility.ClickOn(driver, obj_UnifiedPortalPage.actionsButtonFirstRow());

			//	CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.actionsButtonFirstRow()).click();

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_UnifiedPortalPage.actionsColumnDeleteOption()));

			deleteOption = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.actionsColumnDeleteOption()).getText();

			Report.put("User sees  Actions and clicks",
					"Remove Custom Group (display only)",
					Report.color(deleteOption)+"displayed successfully", "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();

			Report.put("User sees  Actions and clicks",
					"Remove Custom Group (display only)",
					"Failed to display Delete Option", "FAIL");
			Assert.fail();
		}
	}

	public void verifySREventNotificationPopup(WebDriver driver)
	{
		System.out.println("Inside verifySREventNotificationPopup method");
		Log.info("Inside verifySREventNotificationPopup method");

		String button = "";

		String SREventsNotificationHeader = "";		
		String viewProductsLabel = "";
		String nameNotificationsLabel = "";
		String setPreferencesLabel = "";
		String labelList = "";
		String selectedOption;
		String availableOption;
		String optionList = "";
		String prodOptionList = "";
		String severityList = "";
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);


			button = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.addNotificationButton()).getText();

			CommonUtility.scrollToViewElement(driver,obj_UnifiedPortalPage.addNotificationButton());
			CommonUtility.ClickOn(driver, obj_UnifiedPortalPage.addNotificationButton());

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_UnifiedPortalPage.createSREventNotificationHeader()));

			SREventsNotificationHeader = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.createSREventNotificationHeader()).getText();

			System.out.println("Service Events Notification Header is:  "+SREventsNotificationHeader);


			Select selOption = new  Select(driver.findElement(obj_UnifiedPortalPage.SRNotificationPopupProductsDropdown()));

			List<WebElement> prodOptionsList=selOption.getOptions();


			for(WebElement lt:prodOptionsList)
			{
				CommonUtility.highlightElement(driver, lt);
				String prodOpt=lt.getText();

				System.out.println("Option is: " +prodOpt);
				prodOptionList+=" <br> " + prodOpt;
			}
			System.out.println("Product Dropdown options are:"+prodOptionList);


			viewProductsLabel = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.viewProductsByLabel()).getText();

			if(CommonUtility.CheckpresenceofElementLocated(driver, 10, obj_UnifiedPortalPage.nameYourNotifcationLabel()))
			{
				nameNotificationsLabel = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.nameYourNotifcationLabel()).getText();
			}

			setPreferencesLabel = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.setYourPreferencesLabel()).getText();

			List<WebElement> list=driver.findElements(obj_UnifiedPortalPage.notifyMeSROptions());

			for(WebElement lt:list)
			{
				CommonUtility.highlightElement(driver, lt);
				String label=lt.getText();

				System.out.println("Option is: " +label);
				labelList+=" <br> " + label;
			}
			System.out.println("Options are:"+labelList);

			Select dialOption = new  Select(driver.findElement(obj_UnifiedPortalPage.dialHomeSRDropdown()));

			selectedOption = dialOption.getFirstSelectedOption().getText(); 
			System.out.println("Default: "+selectedOption);

			List<WebElement> dialOptionsList=dialOption.getOptions();


			for(WebElement lt:dialOptionsList)
			{
				CommonUtility.highlightElement(driver, lt);
				String dialOpt=lt.getText();

				System.out.println("Option is: " +dialOpt);
				optionList+=" <br> " + dialOpt;
			}
			System.out.println("Options are:"+optionList);

			Select severityOption = new  Select(driver.findElement(obj_UnifiedPortalPage.SRNotificationSeverityDropdown()));


			List<WebElement> severityOptionsList=severityOption.getOptions();


			for(WebElement lt:severityOptionsList)
			{
				CommonUtility.highlightElement(driver, lt);
				String severityOpt=lt.getText();

				System.out.println("Option is: " +severityOpt);
				severityList+=" <br> " + severityOpt;
			}
			System.out.println("Options are:"+severityList);

			Report.put("User Clicks on the 'Add Notification ' button",
					"User should be  directed to the 'Create a Service Request Event Notification' page and should  be able to select, add the following details 1. Select All SRs when Iam the Owner of Primary contact from View products by Dropdown 2.Name your Notification 3.Set your preferences Section:Notify me when a Service Request is :•Created •Updated •Closed •Select All Options 4. Service Requests •All,Including Dial Home(This value should be defaulted) •Exclude Dial Home (In Dial home Service Requests Drop down)",
					"Redirected to "+Report.color(SREventsNotificationHeader)+" Displayed  "+Report.color(nameNotificationsLabel)+Report.color(prodOptionList)+" displayed "+Report.color(setPreferencesLabel)+Report.color(labelList)+"Severity Level"+Report.color(severityList)+"Dial Home Options are:"+Report.color(optionList), "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("User Clicks on the 'Add Notification ' button",
					"User should be  directed to the 'Create a Service Request Event Notification' page and should  be able to select, add the following details 1. Select All SRs when Iam the Owner of Primary contact from View products by Dropdown 2.Name your Notification 3.Set your preferences Section:Notify me when a Service Request is :•Created •Updated •Closed •Select All Options 4. Service Requests •All,Including Dial Home(This value should be defaulted) •Exclude Dial Home (In Dial home Service Requests Drop down)",
					"Failed to load Service Request Events page", "FAIL");
			Assert.fail();
		}
	}

	public void verifyConfirmEmailOption(WebDriver driver)
	{
		System.out.println("Inside verifyConfirmEmailOption method");
		Log.info("Inside verifyConfirmEmailOption method");

		String optionList = "";

		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);

			Select emailOption = new  Select(driver.findElement(obj_UnifiedPortalPage.confirmEmailDropdown()));


			List<WebElement> emailOptionsList=emailOption.getOptions();


			for(WebElement lt:emailOptionsList)
			{
				CommonUtility.highlightElement(driver, lt);
				String option=lt.getText();

				System.out.println("Option is: " +option);
				optionList+=" <br> " + option;
			}
			System.out.println("Options are:"+optionList);



			Report.put("User verifies 'Confirm email'",
					"User should be able to select Business/Alternate email in the 'Confirm email, Choose a recipient section.Alternate and Business emails come from User Settings of that particular user.",
					"User is able to select "+Report.color(optionList)+" email successfully", "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();

			Report.put("User verifies 'Confirm email'",
					"User should be able to select Business/Alternate email in the 'Confirm email, Choose a recipient section.Alternate and Business emails come from User Settings of that particular user.",
					"Failed to display Email Options", "FAIL");
			Assert.fail();
		}
	}

	public void verifySaveButtonEnabledSREventNotification(WebDriver driver)
	{
		System.out.println("Inside verifySaveButtonEnabledSREventNotification method");
		Log.info("Inside verifySaveButtonEnabledSREventNotification method");

		String buttonName = "";
		String createMessage = "";
		String serviceRequestEventsHeader = "";
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);

			if(CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.SRNotificationPopupSaveButton()).isEnabled())
			{

				buttonName = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.SRNotificationPopupSaveButton()).getAttribute("value");
				System.out.println("Button is: "+buttonName);
			}

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_UnifiedPortalPage.serviceRequestEventsTable()));
			CommonUtility.scrollToViewElement(driver,obj_UnifiedPortalPage.serviceRequestEventsTable());
			CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.serviceRequestEventsTable());

			createMessage = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.SuccessfullyAddedMessageInProductUpdates()).getText();

			System.out.println("Create Message is: "+createMessage);

			Report.put("User verifies Save button is enabled ,when user selects all the values in each criteria.",
					"Clicking 'Save' should enable the user to save the selections ,and user will be directed to list of notifications section and A green alert notification should be displayed on the top of the grid and goes away after 2600ms:",
					"Clicked on Button"+Report.color(buttonName)+"displayed message successfully.", "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();

			Report.put("User verifies Save button is enabled ,when user selects all the values in each criteria.",
					"Clicking 'Save' should enable the user to save the selections ,and user will be directed to list of notifications section and A green alert notification should be displayed on the top of the grid and goes away after 2600ms:",
					"Failed to load Service Events Notifications  page", "FAIL");
			Assert.fail();
		}
	}

	public void clickSREventsNotificationName(WebDriver driver)
	{
		System.out.println("Inside clickSREventsNotificationName method");
		Log.info("Inside clickSREventsNotificationName method");

		String NotificationName = "";
		String createMessage = "";
		String SREventsNotificationHeader = "";
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);

			CommonUtility.scrollToViewElement(driver,obj_UnifiedPortalPage.SREventsNotificationName());
			NotificationName = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.SREventsNotificationName()).getText();

			System.out.println("Notification Name is: "+NotificationName);

			CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.SREventsNotificationName());

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_UnifiedPortalPage.createSREventNotificationHeader()));

			SREventsNotificationHeader = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.createSREventNotificationHeader()).getText();

			System.out.println("Service Events Notification Header is:  "+SREventsNotificationHeader);

			Report.put("Clicks on hyperlink on the  notification name",
					"The   'Edit Service Request Event Notification' should be displayed",
					"Clicked on Notification Name"+Report.color(NotificationName)+"displayed "+Report.color(SREventsNotificationHeader), "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();

			Report.put("Clicks on hyperlink on the  notification name",
					"The   'Edit Service Request Event Notification' should be displayed",
					"Failed to load Service Events Notifications  page", "FAIL");
			Assert.fail();
		}
	}

	public void verifySREventNotificationEditableFields(WebDriver driver)
	{
		System.out.println("Inside verifySREventNotificationEditableFields method");
		Log.info("Inside verifySREventNotificationEditableFields method");


		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);

			if(CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.SRNotificationNameTextbox()).isDisplayed())
			{
				System.out.println("Notification textbox is displayed");
			}

			if(CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.SRNotificationDescTextbox()).isDisplayed())
			{
				System.out.println("Notification description textbox is displayed");
			}
			CommonUtility.scrollToViewElement(driver,obj_UnifiedPortalPage.setYourPreferencesCheckbox());
			Thread.sleep(3000);

			List<WebElement> list=driver.findElements(obj_UnifiedPortalPage.setYourPreferencesCheckbox());



			for(WebElement lt:list)
			{
				CommonUtility.highlightElement(driver, lt);
				//	CommonUtility.scrollToViewElement(driver,lt);
				Thread.sleep(3000);
				//	lt.click();
				System.out.println("Checkbox is enabled");				
			}

			if(CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.SRNotificationSeverityDropdown()).isDisplayed())
			{
				System.out.println("Severity dropdown is displayed");
			}

			if(CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.dialHomeSRDropdown()).isDisplayed())
			{
				System.out.println("DialHomeSR Dropdown  is displayed");
			} 

			if(CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.confirmEmailDropdown()).isDisplayed())
			{
				System.out.println("ConfirmEmailDropdown is displayed");
			} 


			Report.put("Verify the fields that can be edited",
					"The following fields should be editable 1.Name of the notification, Description of the notification, Set your preferences Section, Initial Severity Level, Dial Home Service Requests, Select your products, Confirm Email",
					"All the fields are displayed & editable", "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify the fields that can be edited",
					"The following fields should be editable 1.Name of the notification, Description of the notification, Set your preferences Section, Initial Severity Level, Dial Home Service Requests, Select your products, Confirm Email",
					"Failed to load Service Request Events page", "FAIL");
			Assert.fail();
		}
	}

	public void clickUserSettingsTab(WebDriver driver)
	{
		System.out.println("Inside clickUserSettingsTab method");
		Log.info("Inside clickUserSettingsTab method");

		String header = "";
		String tab = "";
		String userSettingsHeader = "";
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 500);
			Thread.sleep(10000);
			//			CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.preferenceHeader());
			wait.until(ExpectedConditions.presenceOfElementLocated(obj_UnifiedPortalPage.preferenceHeader()));
			header = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.preferenceHeader()).getText();

			System.out.println("Header is: "+header);

			tab = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.userSettingsTab()).getText();

			System.out.println("Clicked on "+tab);

			CommonUtility.ClickOn(driver, obj_UnifiedPortalPage.userSettingsTab());

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_UnifiedPortalPage.personalPreferencesHeader()));
			CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.personalPreferencesHeader());

			userSettingsHeader = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.personalPreferencesHeader()).getText();

			System.out.println("User Settings Header is:  "+userSettingsHeader);



			Report.put("User navigates to the Preferences->User Settings Tab",
					"User should be able to navigate to User Settings Tab",
					Report.color(tab)+"displayed successfully.", "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();

			Report.put("User navigates to the Preferences->User Settings Tab",
					"User should be able to navigate to User Settings Tab",
					"Failed to load User Settings page", "FAIL");
			Assert.fail();
		}
	}

	public void validatePersonalPreferenceSection(WebDriver driver)
	{
		System.out.println("Inside validatePersonalPreferenceSection method");
		Log.info("Inside validatePersonalPreferenceSection method");

		String labelList = "";

		try
		{

			List<WebElement> list = driver.findElements(obj_UnifiedPortalPage.personalPreferencesSectionLabel());


			for(WebElement lt:list)
			{
				CommonUtility.highlightElement(driver, lt);
				String label=lt.getText();

				System.out.println("Option is: " +label);
				labelList+=" <br> " + label;
			}
			System.out.println("Fields are:"+labelList);				

			Report.put("User verifies if following sections can be viewed when navigated to user settings ->personal preferences",
					"User should be able to see the below options :full name, email, phone number",
					Report.color(labelList)+"displayed successfully.", "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();

			Report.put("User verifies if following sections can be viewed when navigated to user settings ->personal preferences",
					"User should be able to see the below options :full name, email, phone number",
					"Failed to display options in Personal Preferences", "FAIL");
			Assert.fail();
		}
	}

	public void verifyPersonalPreferencesTooltip(WebDriver driver)
	{
		System.out.println("Inside verifyPersonalPreferencesTooltip method");
		Log.info("Inside verifyPersonalPreferencesTooltip method");

		String text = "";
		String tab = "";
		String userSettingsHeader = "";
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);
			CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.personalPreferencesTooltip());
			CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.personalPreferencesTooltip());

			text = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.personalPreferencesTooltipText()).getText();

			System.out.println("Text is: "+text);


			Report.put("User verifies  clicks on the tool tip at the personal preference section as indicated ",
					"User should be able to see the tool tip option at the personal preference section displayed with a message :' personal preference must be updated through your employee HR services'",
					"Tooltip Message displayed "+Report.color(text), "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();

			Report.put("User verifies  clicks on the tool tip at the personal preference section as indicated ",
					"User should be able to see the tool tip option at the personal preference section displayed with a message :' personal preference must be updated through your employee HR services'",
					"Failed to display Tooltip Message", "FAIL");
			Assert.fail();
		}
	}

	public void verifyPersonalPreferencesPasswordDisabled(WebDriver driver)
	{
		System.out.println("Inside verifyPersonalPreferencesPasswordDisabled method");
		Log.info("Inside verifyPersonalPreferencesPasswordDisabled method");


		try
		{		
			if(!(CommonUtility.CheckpresenceofElementLocated(driver, 5, obj_UnifiedPortalPage.personalPreferencesPasswordLabel())))
			{
				Report.put("User verifies that the password field is Hidden for all E type users (both Service enabled and non-enabled) ",
						"User should be able to see that the password field is hidden for all E type users ",
						"Password field is hidden for E type users", "PASS");
			}				
		} 
		catch(Exception e)
		{
			e.printStackTrace();

			Report.put("User verifies that the password field is Hidden for all E type users (both Service enabled and non-enabled) ",
					"User should be able to see that the password field is hidden for all E type users ",
					"Failed to verify Password field is hidden for E type users", "FAIL");
			Assert.fail();
		}
	}

	public void verifyPersonalPreferenceSectionOnClickingEdit(WebDriver driver)
	{
		System.out.println("Inside verifyPersonalPreferenceSectionOnClickingEdit method");
		Log.info("Inside verifyPersonalPreferenceSectionOnClickingEdit method");

		String initialMethodVal = "Online";
		String fromVal = "6:00 AM";
		String toVal = "4:00 PM";

		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);

			CommonUtility.scrollToViewElement(driver,obj_UnifiedPortalPage.personalPreferencesEditButton());
			CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.personalPreferencesEditButton());

			if(CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.contactPreferencesInitialContactDropdown()).isDisplayed())
			{
				System.out.println("contactPreferencesInitialContactDropdown Dropdown  is displayed");

				Select selOption = new  Select(driver.findElement(obj_UnifiedPortalPage.contactPreferencesInitialContactDropdown()));

				selOption.selectByVisibleText(initialMethodVal); 
				System.out.println("Selected from Initial Contact Method Dropdown"+initialMethodVal);
			} 

			if(CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.contactPreferencesFromDropdown()).isDisplayed())
			{
				System.out.println("contactPreferencesFromDropdown Dropdown  is displayed");
				Select selFrom = new  Select(driver.findElement(obj_UnifiedPortalPage.contactPreferencesFromDropdown()));

				selFrom.selectByVisibleText(fromVal); 
				System.out.println("Selected from contact Preferences From Dropdown"+fromVal);
			} 

			if(CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.contactPreferencesToDropdown()).isDisplayed())
			{
				System.out.println("contactPreferencesToDropdown Dropdown  is displayed");
				Select selFrom = new  Select(driver.findElement(obj_UnifiedPortalPage.contactPreferencesToDropdown()));

				selFrom.selectByVisibleText(toVal); 
				System.out.println("Selectedfrom contact Preferences To Dropdown"+toVal);
			} 	

			Report.put("User  verifies that he/she can edit the contact preferences Initial Contact Method, From/To Time",
					"User should be able to edit the contact preferences, Initial Contact Method, From / To Time",
					"User is able to edit the contact preferences Initial Contact Method, From/To Time"+Report.color(initialMethodVal)+Report.color(fromVal)+Report.color(toVal), "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();

			Report.put("User  verifies that he/she can edit the contact preferences Initial Contact Method, From/To Time",
					"User should be able to edit the contact preferences, Initial Contact Method, From / To Time",
					"Failed to display Initial Contact Method, From / To Time", "FAIL");
			Assert.fail();
		}
	}

	public void clickPersonalPreferenceSectionSaveButton(WebDriver driver)
	{
		System.out.println("Inside clickPersonalPreferenceSectionSaveButton method");
		Log.info("Inside clickPersonalPreferenceSectionSaveButton method");


		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);

			CommonUtility.scrollToViewElement(driver,obj_UnifiedPortalPage.contactPreferencesSaveButton());
			CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.contactPreferencesSaveButton());



			Report.put("User clicks on Save",
					"The modifications done should be saved",
					"Modification done is saved", "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();

			Report.put("User clicks on Save",
					"The modifications done should be saved",
					"Failed to click on Save button", "FAIL");
			Assert.fail();
		}
	}

	public void verifyPreferenceSectionCustomer(WebDriver driver)
	{
		System.out.println("Inside verifyPreferenceSectionCustomer method");
		Log.info("Inside verifyPreferenceSectionCustomer method");

		String labelList = "";
		String contactList = "";
		try
		{

			List<WebElement> list = driver.findElements(obj_UnifiedPortalPage.personalPreferencesSectionLabel());


			for(WebElement lt:list)
			{
				CommonUtility.highlightElement(driver, lt);
				String label=lt.getText();

				System.out.println("Option is: " +label);
				labelList+=" <br> " + label;
			}
			System.out.println("Fields are:"+labelList);				

			List<WebElement> ContactList = driver.findElements(obj_UnifiedPortalPage.contactPreferenceSectionLabel());


			for(WebElement lt:ContactList)
			{
				CommonUtility.highlightElement(driver, lt);
				String label=lt.getText();

				System.out.println("Option is: " +label);
				contactList+=" <br> " + label;
			}
			System.out.println("Labels are:"+contactList);

			Report.put("User verifies if following sections can be viewed when navigated to user settings",
					"User should be able to see the below options :Personal Preferences : Full Name,Business Email Address, Alternate Email Address,Password (Masked always),Primary Phone number,Alternate Phone Number Contact Preferences : Initial Contact Method for all Service Requests, Contact Hours ",
					"Personal Preferences: "+Report.color(labelList)+"Contact Preferences: "+Report.color(contactList)+"displayed successfully.", "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();

			Report.put("User verifies if following sections can be viewed when navigated to user settings",
					"User should be able to see the below options :Personal Preferences : Full Name,Business Email Address, Alternate Email Address,Password (Masked always),Primary Phone number,Alternate Phone Number Contact Preferences : Initial Contact Method for all Service Requests, Contact Hours ",
					"Failed to display Preferences", "FAIL");
			Assert.fail();
		}
	}

	public void verifyPersonalPreferenceFullName(WebDriver driver)
	{
		System.out.println("Inside verifyPersonalPreferenceFullName method");
		Log.info("Inside verifyPersonalPreferenceFullName method");

		String fullName = "";
		String tab = "";
		String userSettingsHeader = "";
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);

			fullName = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.personalPreferenceFullName()).getText();

			System.out.println("Full Name is: "+fullName);


			Report.put("User verifies the full name under personal preference",
					"User should be able to see the full name that user had entered during 'MyAccount' creation for a first time user (or) if the user has not made any changes to this field",
					"Full Name is displayed: "+Report.color(fullName), "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();

			Report.put("User verifies the full name under personal preference",
					"User should be able to see the full name that user had entered during 'MyAccount' creation for a first time user (or) if the user has not made any changes to this field",
					"Failed to display Full Name under Personal Preference", "FAIL");
			Assert.fail();
		}
	}

	public void verifyPersonalPreferenceBusinessEmail(WebDriver driver)
	{
		System.out.println("Inside verifyPersonalPreferenceBusinessEmail method");
		Log.info("Inside verifyPersonalPreferenceBusinessEmail method");

		String businessEmail = "";

		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);

			businessEmail = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.personalPreferenceBusinessEmail()).getText();

			System.out.println("Business Email is: "+businessEmail);


			Report.put("User verifies the Business Email Address under personal preference",
					"User should be able to see  the Email address that has been entered during 'MyAccount' creation for a first time user (or) if the user has not made any changes to this field",
					"Business Email is displayed: "+Report.color(businessEmail), "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();

			Report.put("User verifies the Business Email Address under personal preference",
					"User should be able to see  the Email address that has been entered during 'MyAccount' creation for a first time user (or) if the user has not made any changes to this field",
					"Failed to display Business Email under Personal Preference", "FAIL");
			Assert.fail();
		}
	}

	public void verifyPersonalPreferenceAlternateEmail(WebDriver driver)
	{
		System.out.println("Inside verifyPersonalPreferenceAlternateEmail method");
		Log.info("Inside verifyPersonalPreferenceAlternateEmail method");

		String alternateEmail = "";

		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);

			alternateEmail = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.personalPreferenceAlternateEmail()).getText();

			System.out.println("Alternate Email is: "+alternateEmail);


			Report.put("User verifies the Alternate Email Address under personal preference",
					"User should be able see the Alternate Email Address as Null until the user makes changes ",
					"Alternate Email is displayed: "+Report.color(alternateEmail), "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();

			Report.put("User verifies the Alternate Email Address under personal preference",
					"User should be able see the Alternate Email Address as Null until the user makes changes ",
					"Failed to display Alternate Email under Personal Preference", "FAIL");
			Assert.fail();
		}
	}

	public void verifyPersonalPreferencePassword(WebDriver driver)
	{
		System.out.println("Inside verifyPersonalPreferencePassword method");
		Log.info("Inside verifyPersonalPreferencePassword method");

		String password = "";

		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);

			password = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.personalPreferencePassword()).getText();

			System.out.println("Password is: "+password);


			Report.put("User verifies the password under personal preference",
					"User should be able to view the password which is always masked.",
					"Password is displayed: "+Report.color(password), "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();

			Report.put("User verifies the password under personal preference",
					"User should be able to view the password which is always masked.",
					"Failed to display Password under Personal Preference", "FAIL");
			Assert.fail();
		}
	}

	public void verifyPersonalPreferencePrimaryPhNum(WebDriver driver)
	{
		System.out.println("Inside verifyPersonalPreferencePrimaryPhNum method");
		Log.info("Inside verifyPersonalPreferencePrimaryPhNum method");

		String primaryPhNum = "";

		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);

			primaryPhNum = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.personalPreferencePrimaryPhNum()).getText();

			System.out.println("Primary Phone Number is: "+primaryPhNum);


			Report.put("User verifies the Primary Phone number",
					"User should be able to see the primary phone number details  that has been entered during 'Business Account' creation for a first time (or)if the user has not made any changes to this field",
					"Primary Phone Number is displayed: "+Report.color(primaryPhNum), "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();

			Report.put("User verifies the Primary Phone number",
					"User should be able to see the primary phone number details  that has been entered during 'Business Account' creation for a first time (or)if the user has not made any changes to this field",
					"Failed to display Primary Phone Number under Personal Preference", "FAIL");
			Assert.fail();
		}
	}

	public void verifyPersonalPreferenceAlternatePhNum(WebDriver driver)
	{
		System.out.println("Inside verifyPersonalPreferenceAlternatePhNum method");
		Log.info("Inside verifyPersonalPreferenceAlternatePhNum method");

		String alternatePhNum = "";

		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);

			alternatePhNum = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.personalPreferenceAlternatePhNum()).getText();

			System.out.println("Alternate Phone Number is: "+alternatePhNum);


			Report.put("User verifies Alternate Phone Number  ",
					"User should be able to see the alternate phone number value as Null until the user makes changes ",
					"Alternate Phone Number is displayed: "+Report.color(alternatePhNum), "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();

			Report.put("User verifies Alternate Phone Number  ",
					"User should be able to see the alternate phone number value as Null until the user makes changes ",
					"Failed to display Alternate Phone Number under Personal Preference", "FAIL");
			Assert.fail();
		}
	}

	public void verifyContactPreferenceInitialMethod(WebDriver driver)
	{
		System.out.println("Inside verifyContactPreferenceInitialMethod method");
		Log.info("Inside verifyContactPreferenceInitialMethod method");

		String methodVal = "";

		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);

			methodVal = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.contactPreferenceMethod()).getText();

			System.out.println("Initial Method Value is: "+methodVal);


			Report.put("User verifies Initial Contact Method for all Service Requests under contact preferences ",
					"User should be able to see the Initial Contact Method for all Service Requests or the value is null until the user makes changes",
					"Initial Method is displayed: "+Report.color(methodVal), "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();

			Report.put("User verifies Initial Contact Method for all Service Requests under contact preferences ",
					"User should be able to see the Initial Contact Method for all Service Requests or the value is null until the user makes changes",
					"Failed to display Initial Method under Contact Preference", "FAIL");
			Assert.fail();
		}
	}

	public void verifyContactPreferenceContactHours(WebDriver driver)
	{
		System.out.println("Inside verifyContactPreferenceContactHours method");
		Log.info("Inside verifyContactPreferenceContactHours method");

		String contactHours = "";

		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);

			contactHours = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.contactPreferenceHours()).getText();

			System.out.println("Contact Hours is: "+contactHours);


			Report.put("User verifies Contact Hours under contact preferences",
					"User should be able to view the contact hours or the value is null until user makes changes",
					"Contact Hours is displayed: "+Report.color(contactHours), "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();

			Report.put("User verifies Contact Hours under contact preferences",
					"User should be able to view the contact hours or the value is null until user makes changes",
					"Failed to display Contact Hours under Contact Preference", "FAIL");
			Assert.fail();
		}
	}



	public void clickPersonalPreferenceSectionEditButton(WebDriver driver)
	{
		System.out.println("Inside clickPersonalPreferenceSectionEditButton method");
		Log.info("Inside clickPersonalPreferenceSectionEditButton method");


		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);

			if(CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.personalPreferencesEditButton()).isDisplayed())
			{
				CommonUtility.scrollToViewElement(driver,obj_UnifiedPortalPage.personalPreferencesEditButton());
				CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.personalPreferencesEditButton());

				System.out.println("Click on Edit Button Preferences Section successful");
				Report.put("Click on Edit Button Preferences Section",
						"User should be able click on Edit Button Preferences Section",
						"Clicked on Edit Button", "PASS");
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();

			System.out.println("Failed to click on Edit Button Preferences Section");
			Report.put("Click on Edit Button Preferences Section",
					"User should be able click on Edit Button Preferences Section",
					"Failed to click on Edit Button", "FAIL");
			Assert.fail();
		}
	}

	public void editPersonalPreferenceFullName(WebDriver driver)
	{
		System.out.println("Inside editPersonalPreferenceFullName method");
		Log.info("Inside editPersonalPreferenceFullName method");

		String link = "";
		String header = "";

		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);
			CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.editLinkFullName());
			link = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.editLinkFullName()).getText();

			CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.editLinkFullName());

			System.out.println("Link is: "+link);

			Set<String> allWH=driver.getWindowHandles(); 
			String currentwindow=driver.getWindowHandle();
			int countWindow=allWH.size(); 

			System.out.println("Switched Window Handles in editPersonalPreferenceFullName "+countWindow);

			for(String wh:allWH)
			{
				Thread.sleep(10000);
				driver.switchTo().window(wh); 
				driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
				String url=driver.getCurrentUrl();
				System.out.println("URL is   :::::"+url); 

				if(url.contains("editaccount"))
				{			
					System.out.println("Switched to edit account page");


					wait.until(ExpectedConditions.visibilityOfElementLocated(obj_UnifiedPortalPage.editAccountHeader()));
					CommonUtility.highlightElement(driver, obj_UnifiedPortalPage.editAccountHeader());

					header = CommonUtility.highlightElement(driver, obj_UnifiedPortalPage.editAccountHeader()).getText();

					System.out.println("Header is: "+header);
					driver.close();
					driver.switchTo().window(currentwindow);						
				}	
			}


			Report.put("User verifies if able to edit full name under personal preference",
					"User should be able edit .User is redirected to 'MyAccount' pages (page re-load)  to make any changes to this field.",
					"Clicked on Link "+Report.color(link)+"Navigated to page "+Report.color(link), "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();

			Report.put("User verifies if able to edit full name under personal preference",
					"User should be able edit .User is redirected to 'MyAccount' pages (page re-load)  to make any changes to this field.",
					"Failed to click on Edit My Account Link", "FAIL");
			Assert.fail();
		}
	}

	public void editPersonalPreferenceBusinessEmail(WebDriver driver)
	{
		System.out.println("Inside editPersonalPreferenceBusinessEmail method");
		Log.info("Inside editPersonalPreferenceBusinessEmail method");

		String link = "";
		String header = "";

		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);

			link = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.editLinkBusinessEmail()).getText();

			CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.editLinkBusinessEmail());

			System.out.println("Link is: "+link);

			Set<String> allWH=driver.getWindowHandles(); 
			String currentwindow=driver.getWindowHandle();
			int countWindow=allWH.size(); 

			System.out.println("Switched Window Handles in editPersonalPreferenceBusinessEmail "+countWindow);

			for(String wh:allWH)
			{
				Thread.sleep(10000);
				driver.switchTo().window(wh); 
				driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
				String url=driver.getCurrentUrl();
				System.out.println("URL is   :::::"+url); 

				if(url.contains("editaccount"))
				{			
					System.out.println("Switched to edit account page");


					wait.until(ExpectedConditions.visibilityOfElementLocated(obj_UnifiedPortalPage.editAccountHeader()));
					CommonUtility.highlightElement(driver, obj_UnifiedPortalPage.editAccountHeader());

					header = CommonUtility.highlightElement(driver, obj_UnifiedPortalPage.editAccountHeader()).getText();

					System.out.println("Header is: "+header);
					driver.close();
					driver.switchTo().window(currentwindow);						
				}	
			}


			Report.put("User verifies if able to edit Business Email Address under personal preference",
					"User is redirected to 'MyAccount' pages(page re-load) to make any changes to this field. Note: user is put through 'Business Account Registration' process again for domain changes.",
					"Clicked on Link "+Report.color(link)+"Navigated to page "+Report.color(link), "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();

			Report.put("User verifies if able to edit Business Email Address under personal preference",
					"User is redirected to 'MyAccount' pages(page re-load) to make any changes to this field. Note: user is put through 'Business Account Registration' process again for domain changes.",
					"Failed to click on Edit My Account Link", "FAIL");
			Assert.fail();
		}
	}

	public void editPersonalPreferenceAlternateEmail(WebDriver driver, String email)
	{
		System.out.println("Inside editPersonalPreferenceAlternateEmail method");
		Log.info("Inside editPersonalPreferenceAlternateEmail method");

		String alternateEmail = "";
		String changedEmail = "";
		String errMessage = "";

		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);

			alternateEmail = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.alternateEmailTextbox()).getAttribute("value");

			System.out.println("Alternate Email is: "+alternateEmail);

			if(CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.alternateEmailTextbox()).isEnabled())
			{
				CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.alternateEmailTextbox()).clear();
				CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.alternateEmailTextbox()).sendKeys(email);

				changedEmail = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.alternateEmailTextbox()).getAttribute("value");

				System.out.println("Changed Email is: "+changedEmail);
				CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.contactPreferencesSaveButton());

				if((CommonUtility.CheckpresenceofElementLocated(driver, 5, obj_UnifiedPortalPage.userSettingsErrorMessage())))
				{
					errMessage = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.userSettingsErrorMessage()).getText();
					System.out.println("Failed to cLick on Save Button"+errMessage);

					Report.put("User verifies if able to edit the Alternate Email Address under personal preference",
							"User should be able see the Alternate Email and should be able to edit. Changes should be reflected on Save",
							"Failed to edit Alternate Email under Personal Preference.Error message is:"+Report.color(errMessage), "FAIL");
					Assert.fail();
				}
				Report.put("User verifies if able to edit the Alternate Email Address under personal preference",
						"User should be able see the Alternate Email and should be able to edit. Changes should be reflected on Save",
						"Alternate Email is displayed: "+Report.color(alternateEmail)+"Changed email to "+Report.color(changedEmail), "PASS");
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();

			Report.put("User verifies if able to edit the Alternate Email Address under personal preference",
					"User should be able see the Alternate Email and should be able to edit. Changes should be reflected on Save",
					"Failed to edit Alternate Email under Personal Preference", "FAIL");
			Assert.fail();
		}
	}

	public void editPersonalPreferencePassword(WebDriver driver)
	{
		System.out.println("Inside editPersonalPreferencePassword method");
		Log.info("Inside editPersonalPreferencePassword method");

		String link = "";
		String header = "";

		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);

			link = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.editLinkPassword()).getText();

			CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.editLinkPassword());

			System.out.println("Link is: "+link);

			Set<String> allWH=driver.getWindowHandles(); 
			String currentwindow=driver.getWindowHandle();
			int countWindow=allWH.size(); 

			System.out.println("Switched Window Handles in editPersonalPreferencePassword "+countWindow);

			for(String wh:allWH)
			{
				Thread.sleep(10000);
				driver.switchTo().window(wh); 
				driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
				String url=driver.getCurrentUrl();
				System.out.println("URL is   :::::"+url); 

				if(url.contains("editaccount"))
				{			
					System.out.println("Switched to edit account page");


					wait.until(ExpectedConditions.visibilityOfElementLocated(obj_UnifiedPortalPage.editAccountHeader()));
					CommonUtility.highlightElement(driver, obj_UnifiedPortalPage.editAccountHeader());

					header = CommonUtility.highlightElement(driver, obj_UnifiedPortalPage.editAccountHeader()).getText();

					System.out.println("Header is: "+header);
					driver.close();
					driver.switchTo().window(currentwindow);						
				}	
			}


			Report.put("User verifies and tried to edit the password under personal preference",
					"User is redirected to 'MyAccount' pages(page re-load) to make any changes to Password.",
					"Clicked on Link "+Report.color(link)+"Navigated to page "+Report.color(link), "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();

			Report.put("User verifies and tried to edit the password under personal preference",
					"User is redirected to 'MyAccount' pages(page re-load) to make any changes to Password.",
					"Failed to click on Edit My Account Link", "FAIL");
			Assert.fail();
		}
	}

	public void editPersonalPreferencePrimaryPhNum(WebDriver driver, String changedPhoneNum)
	{
		System.out.println("Inside editPersonalPreferencePrimaryPhNum method");
		Log.info("Inside editPersonalPreferencePrimaryPhNum method");

		String countryCode = "";
		String areaCode = "";
		String phoneNum = "";

		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);

			countryCode = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.primaryPhNumCountryCode()).getAttribute("value");
			areaCode = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.primaryPhNumAreaCode()).getAttribute("value");
			phoneNum = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.primaryPhNumContactNum()).getAttribute("value");

			System.out.println("Phone number from testdata is: "+changedPhoneNum);
			System.out.println("Primary Phone Details are: "+countryCode +areaCode +phoneNum);

			if((CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.primaryPhNumCountryCode()).isEnabled())&&(CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.primaryPhNumAreaCode()).isEnabled())&&(CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.primaryPhNumContactNum()).isEnabled()))
			{
				CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.primaryPhNumContactNum()).clear();
				CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.primaryPhNumContactNum()).sendKeys(changedPhoneNum);

				changedPhoneNum = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.primaryPhNumContactNum()).getAttribute("value");

				System.out.println("Changed Phone Num is: "+changedPhoneNum);

				Report.put("User edits  the Primary Phone number",
						"User should be able to edit the phone number .user should see the below fields when   editing the phone number. Country Code (mandatory), Area Code (Optional), Phone Number (mandatory) Changes should be reflected on Save",
						"Primary Phone Num Details are: "+Report.color(countryCode)+Report.color(areaCode)+Report.color(phoneNum)+"Changed Contact Num is "+Report.color(changedPhoneNum), "PASS");
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();

			Report.put("User edits  the Primary Phone number",
					"User should be able to edit the phone number .user should see the below fields when   editing the phone number. Country Code (mandatory), Area Code (Optional), Phone Number (mandatory) Changes should be reflected on Save",
					"Failed to edit Primary Phone Number under Personal Preference", "FAIL");
			Assert.fail();
		}
	}

	public void editPersonalPreferenceAlternatePhNum(WebDriver driver, String changedPhoneNum)
	{
		System.out.println("Inside editPersonalPreferenceAlternatePhNum method");
		Log.info("Inside editPersonalPreferenceAlternatePhNum method");

		String countryCode = "";
		String areaCode = "";
		String phoneNum = "";

		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);

			countryCode = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.alternatePhNumCountryCode()).getAttribute("value");
			areaCode = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.alternatePhNumAreaCode()).getAttribute("value");
			phoneNum = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.alternatePhNumContactNum()).getAttribute("value");

			System.out.println("Phone number from testdata is: "+changedPhoneNum);

			System.out.println("Alternate Phone Details are: "+countryCode +areaCode +phoneNum);

			if((CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.alternatePhNumCountryCode()).isEnabled())&&(CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.alternatePhNumAreaCode()).isEnabled())&&(CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.alternatePhNumContactNum()).isEnabled()))
			{
				CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.alternatePhNumContactNum()).clear();
				CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.alternatePhNumContactNum()).sendKeys(changedPhoneNum);

				changedPhoneNum = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.alternatePhNumContactNum()).getAttribute("value");

				System.out.println("Changed Phone Num is: "+changedPhoneNum);

				Report.put("User edits  Alternate Phone Number ",
						"User should be able to edit the alternate phone number .user should see the below fields when   editing the phone number. Country Code (mandatory), Area Code (Optional), Phone Number (mandatory) Changes should be reflected on Save",
						"Alternate Phone Num Details are: "+Report.color(countryCode)+Report.color(areaCode)+Report.color(phoneNum)+"Changed Contact Num is "+Report.color(changedPhoneNum), "PASS");
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();

			Report.put("User edits  Alternate Phone Number",
					"User should be able to edit alternate the phone number .user should see the below fields when   editing the phone number. Country Code (mandatory), Area Code (Optional), Phone Number (mandatory) Changes should be reflected on Save",
					"Failed to edit Primary Phone Number under Personal Preference", "FAIL");
			Assert.fail();
		}
	}

	public void editContactPreferenceContactMethod(WebDriver driver, String option)
	{
		System.out.println("Inside editContactPreferenceContactMethod method");
		Log.info("Inside editContactPreferenceContactMethod method");

		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);


			if(CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.contactPreferencesInitialContactDropdown()).isDisplayed())
			{
				System.out.println("contactPreferencesInitialContactDropdown is displayed. Option from testdata is: "+option);

				Select selOption = new  Select(driver.findElement(obj_UnifiedPortalPage.contactPreferencesInitialContactDropdown()));

				selOption.selectByVisibleText(option); 
				System.out.println("Selected from Initial Contact Method Dropdown"+option);
			} 	


			Report.put("User verifies and edits the Initial Contact Method for all Service Requests under contact preferences",
					"User should be allowed to choose from Online ,Email and Phone options. Changes should be reflected on Save",
					"User is able to edit the contact preferences Initial Contact Method"+Report.color(option), "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();

			Report.put("User verifies and edits the Initial Contact Method for all Service Requests under contact preferences",
					"User should be allowed to choose from Online ,Email and Phone options. Changes should be reflected on Save",
					"Failed to display Initial Contact Method", "FAIL");
			Assert.fail();
		}
	}

	public void editContactPreferenceContactHours(WebDriver driver, String fromVal, String toVal)
	{
		System.out.println("Inside editContactPreferenceContactHours method");
		Log.info("Inside editContactPreferenceContactHours method");

		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);


			if(CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.contactPreferencesFromDropdown()).isDisplayed())
			{
				System.out.println("contactPreferencesFromDropdown Dropdown  is displayed");
				Select selFrom = new  Select(driver.findElement(obj_UnifiedPortalPage.contactPreferencesFromDropdown()));

				selFrom.selectByVisibleText(fromVal); 
				System.out.println("Selected from contact Preferences From Dropdown"+fromVal);
			} 

			if(CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.contactPreferencesToDropdown()).isDisplayed())
			{
				System.out.println("contactPreferencesToDropdown Dropdown  is displayed");
				Select selFrom = new  Select(driver.findElement(obj_UnifiedPortalPage.contactPreferencesToDropdown()));

				selFrom.selectByVisibleText(toVal); 
				System.out.println("Selectedfrom contact Preferences To Dropdown"+toVal);
			} 	

			Report.put("User edits Contact Hours under contact preferences",
					"User should be allowed to choose from and to values. Changes should be reflected on Save",
					"User is able to edit the  From/To Time"+Report.color(fromVal)+Report.color(toVal), "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();

			Report.put("User edits Contact Hours under contact preferences",
					"User should be allowed to choose from and to values. Changes should be reflected on Save",
					"Failed to display From / To Time", "FAIL");
			Assert.fail();
		}
	}

	public void verifyPreferenceSectionEmployee(WebDriver driver)
	{
		System.out.println("Inside verifyPreferenceSectionEmployee method");
		Log.info("Inside verifyPreferenceSectionEmployee method");

		String labelList = "";
		String contactList = "";
		try
		{

			List<WebElement> list = driver.findElements(obj_UnifiedPortalPage.personalPreferencesSectionLabel());


			for(WebElement lt:list)
			{
				CommonUtility.highlightElement(driver, lt);
				String label=lt.getText();

				System.out.println("Option is: " +label);
				labelList+=" <br> " + label;
			}
			System.out.println("Fields are:"+labelList);				

			List<WebElement> ContactList = driver.findElements(obj_UnifiedPortalPage.contactPreferenceSectionLabel());


			for(WebElement lt:ContactList)
			{
				CommonUtility.highlightElement(driver, lt);
				String label=lt.getText();

				System.out.println("Option is: " +label);
				contactList+=" <br> " + label;
			}
			System.out.println("Labels are:"+contactList);

			Report.put("User verifies if following sections can be viewed when navigated to user settings",
					"User should be able to see the below options :Personal Preferences : Full Name,Business Email Address	,Password (Masked always),Primary Phone number Contact Preferences : Initial Contact Method for all Service Requests, Contact Hours ",
					"Personal Preferences: "+Report.color(labelList)+"Contact Preferences: "+Report.color(contactList)+"displayed successfully.", "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();

			Report.put("User verifies if following sections can be viewed when navigated to user settings",
					"User should be able to see the below options :Personal Preferences : Full Name,Business Email Address	,Password (Masked always),Primary Phone number Contact Preferences : Initial Contact Method for all Service Requests, Contact Hours ",
					"Failed to display Preferences", "FAIL");
			Assert.fail();
		}
	}

	public void verifyPersonalPreferenceFullNameEmployee(WebDriver driver)
	{
		System.out.println("Inside verifyPersonalPreferenceFullNameEmployee method");
		Log.info("Inside verifyPersonalPreferenceFullNameEmployee method");

		String link = "";
		String header = "";

		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);

			if(!(CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.personalPreferencesFullNameTextbox()).isEnabled()))
			{
				System.out.println("Full Name is disabled");
				Report.put("User verifies if the Full Name is editable ",
						"User should be able to edit and full name is Non-editable for E user or when logged in as E user",
						"Full Name is not  editable for employee users", "PASS");
			}		
		} 
		catch(Exception e)
		{
			e.printStackTrace();

			Report.put("User verifies if the Full Name is editable ",
					"User should be able to edit and full name is Non-editable for E user or when logged in as E user",
					"Failed to validate Full Name for employee users", "FAIL");
			Assert.fail();
		}
	}

	public void verifyPersonalPreferenceBusinessEmailEmployee(WebDriver driver)
	{
		System.out.println("Inside verifyPersonalPreferenceBusinessEmailEmployee method");
		Log.info("Inside verifyPersonalPreferenceBusinessEmailEmployee method");

		String link = "";
		String header = "";

		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);

			if(!(CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.personalPreferencesBusinessEmailTextbox()).isEnabled()))
			{
				System.out.println("Business Email Address is not editable");
				Report.put("User verifies if the Business Email Address is editable",
						"User should  be able to edit Business Email Address and is Non-editable for E user or when logged in as E user",
						"Business Email Address is not  editable for employee users", "PASS");
			}		 
		} 
		catch(Exception e)
		{
			e.printStackTrace();

			Report.put("User verifies if the Business Email Address is editable",
					"User should  be able to edit Business Email Address and is Non-editable for E user or when logged in as E user",
					"Failed to validate Business Email Address for employee users", "FAIL");
			Assert.fail();
		}
	}

	public void verifyPersonalPreferenceAlternateEmailEmployee(WebDriver driver)
	{
		System.out.println("Inside verifyPersonalPreferenceAlternateEmailEmployee method");
		Log.info("Inside verifyPersonalPreferenceAlternateEmailEmployee method");


		try
		{
			if(!(CommonUtility.CheckpresenceofElementLocated(driver, 5, obj_UnifiedPortalPage.alternateEmailTextbox())))
			{
				System.out.println("Alternate Email is disabled for employee user");


				Report.put("User verifies if the Alternate Email Address-Follow existing rules in OLS is editable",
						"User should be able to edit Alternate Email Address and is alternate email address section is hidden for E user or when logged in as E user ",
						"Alternate Email is hidden for employee users", "PASS");
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();

			Report.put("User verifies if the Alternate Email Address-Follow existing rules in OLS is editable",
					"User should be able to edit Alternate Email Address and is alternate email address section is hidden for E user or when logged in as E user ",
					"Failed to verify Alternate Email is hidden for employee users", "FAIL");
			Assert.fail();
		}
	}

	public void verifyPersonalPreferencePrimaryPhNumEmployee(WebDriver driver)
	{
		System.out.println("Inside verifyPersonalPreferencePrimaryPhNumEmployee method");
		Log.info("Inside verifyPersonalPreferencePrimaryPhNumEmployee method");

		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);


			if(!(CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.personalPreferencesPrimaryPhNumTextbox()).isEnabled()))
			{			

				System.out.println("Primary Phone Num is disabled");

				Report.put("User edits  the Primary Phone number",
						"User should be able to verify and edit Primary Phone number, Non-editable for E user  ",
						"Primary Phone Num is non-editable for employee users", "PASS");
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();

			Report.put("User edits  the Primary Phone number",
					"User should be able to verify and edit Primary Phone number, Non-editable for E user  ",
					"Failed to verify Primary Phone Num is non-editable for employee users", "FAIL");
			Assert.fail();
		}
	}

	public void verifyPersonalPreferenceAlternatePhNumEmployee(WebDriver driver)
	{
		System.out.println("Inside verifyPersonalPreferenceAlternatePhNumEmployee method");
		Log.info("Inside verifyPersonalPreferenceAlternatePhNumEmployee method");

		try
		{			
			if(!(CommonUtility.CheckpresenceofElementLocated(driver, 5, obj_UnifiedPortalPage.alternatePhNumCountryCode())))
			{
				System.out.println("Alternate Phone Num is hidden for employee users ");

				Report.put("User verifies if the Alternate Phone number*-Follow existing rules in OLS is editable",
						"User should be able to verify and edit alternate phone number , and is hidden section for E user",
						"Alternate Phone Num is hidden for Employee Users ", "PASS");
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();

			Report.put("User verifies if the Alternate Phone number*-Follow existing rules in OLS is editable",
					"User should be able to verify and edit alternate phone number , and is hidden section for E user",
					"Failed to verify Alternate Phone Number for employee users", "FAIL");
			Assert.fail();
		}
	}

	public void clickAnyItemLinkCustomGroup(WebDriver driver)
	{
		System.out.println("Inside clickAnyItemLinkCustomGroup method");
		Log.info("Inside clickAnyItemLinkCustomGroup method");

		String header = "";

		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);

			//	CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.itemsColumnFirstValue()).click();
			CommonUtility.ClickOn(driver, obj_UnifiedPortalPage.itemsColumnFirstValue());

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_UnifiedPortalPage.itemsPopupHeader()));
			CommonUtility.highlightElement(driver, obj_UnifiedPortalPage.itemsPopupHeader());

			header = CommonUtility.highlightElement(driver, obj_UnifiedPortalPage.itemsPopupHeader()).getText();

			System.out.println("Items Popup Header is: "+header);
			Thread.sleep(8000);
			CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.itemsPopupCloseButton());

			Report.put("User goes to any of the created custom group and click on item hyperlink present under ITEMS column",
					"User should be able to see a Modal window opened with heading as Items Associated With Custom Group: Custom group Name",
					"Modal Popup displayed with heading:  "+Report.color(header), "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("User goes to any of the created custom group and click on item hyperlink present under ITEMS column",
					"User should be able to see a Modal window opened with heading as Items Associated With Custom Group: Custom group Name",
					"Failed to display Modal Popup heading.", "FAIL");
			Assert.fail();
		}
	}

	public void clickItemLinkSitesCustomGroup(WebDriver driver)
	{
		System.out.println("Inside clickItemLinkSitesCustomGroup method");
		Log.info("Inside clickItemLinkSitesCustomGroup method");

		String header = "";
		String columnList = "";
		String siteDetails = "";
		String numOfSites = "";

		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);

			CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.itemsWithSiteOption()).click();

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_UnifiedPortalPage.itemsPopupHeader()));
			CommonUtility.highlightElement(driver, obj_UnifiedPortalPage.itemsPopupHeader());

			header = CommonUtility.highlightElement(driver, obj_UnifiedPortalPage.itemsPopupHeader()).getText();

			System.out.println("Items Popup Header is: "+header);

			List<WebElement> siteList=driver.findElements(obj_UnifiedPortalPage.itemsPopupSiteDetails());

			for(WebElement lt:siteList)
			{
				CommonUtility.highlightElement(driver, lt);
				String site=lt.getText();

				System.out.println("Data of first row is: " +site);
				siteDetails+=" <br> " + site;
			}
			System.out.println("Columns in Items Sites are:"+siteDetails);	

			CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.itemsPopupSiteExpandArrow());

			List<WebElement> list=driver.findElements(obj_UnifiedPortalPage.itemsPopupSitesList());

			for(WebElement lt:list)
			{
				CommonUtility.highlightElement(driver, lt);
				String column=lt.getText();

				System.out.println("Column is: " +column);
				columnList+=" <br> " + column;
			}
			System.out.println("Columns in Items Sites are:"+columnList);		

			numOfSites = CommonUtility.highlightElement(driver, obj_UnifiedPortalPage.itemsPopupNumOfSites()).getText();

			System.out.println("Number of Sites: "+numOfSites);

			Report.put("For Site Ids :User verifies the items Associated with Custom Group with Name of the Site ID and Site Details",
					"Grid should be populated with the following columns: Site Id, Site Details(Site Name, Site Address) post expansion ; user should see below columns: Product name, Product Nickname, Product ID. Note : User should also see how many Sites are under that particular custom group",
					"Grid Populated with Details: "+Report.color(siteDetails)+"post expansion columns displayed are: "+Report.color(columnList)+"Sites under Custom Groups are: "+Report.color(numOfSites), "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("For Site Ids :User verifies the items Associated with Custom Group with Name of the Site ID and Site Details",
					"Grid should be populated with the following columns: Site Id, Site Details(Site Name, Site Address) post expansion ; user should see below columns: Product name, Product Nickname, Product ID. Note : User should also see how many Sites are under that particular custom group",
					"Failed to display Modal Popup with the columns(Site Details)", "FAIL");
			Assert.fail();
		}
	}

	public void clickItemsPopupCloseButton(WebDriver driver)
	{
		System.out.println("Inside clickItemsPopupCloseButton method");
		Log.info("Inside clickItemsPopupCloseButton method");

		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);

			CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.itemsPopupCloseButton());

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_UnifiedPortalPage.myCustomGroupHeader()));
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_UnifiedPortalPage.myCustomGroupHeader()));
			CommonUtility.highlightElement(driver, obj_UnifiedPortalPage.myCustomGroupHeader());


			Report.put("User clicks on Close Button(X)",
					"The modal window should be closed.",
					"Modal Popup closed", "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("User clicks on Close Button(X)",
					"The modal window should be closed.",
					"Failed to display Modal Popup.", "FAIL");
			Assert.fail();
		}
	}

	public void clickItemLinkProductsCustomGroup(WebDriver driver)
	{
		System.out.println("Inside clickItemLinkProductsCustomGroup method");
		Log.info("Inside clickItemLinkProductsCustomGroup method");

		String header = "";
		String columnList = "";
		String numOfProducts = "";

		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);

			CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.itemsWithProductOption()).click();

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_UnifiedPortalPage.itemsPopupHeader()));
			CommonUtility.highlightElement(driver, obj_UnifiedPortalPage.itemsPopupHeader());

			header = CommonUtility.highlightElement(driver, obj_UnifiedPortalPage.itemsPopupHeader()).getText();

			System.out.println("Items Popup Header is: "+header);	


			List<WebElement> list=driver.findElements(obj_UnifiedPortalPage.itemsPopupProductsList());

			for(WebElement lt:list)
			{
				CommonUtility.highlightElement(driver, lt);
				String column=lt.getText();

				System.out.println("Column is: " +column);
				columnList+=" <br> " + column;
			}
			System.out.println("Columns in Items Products are:"+columnList);		

			numOfProducts = CommonUtility.highlightElement(driver, obj_UnifiedPortalPage.itemsPopupNumOfSites()).getText();

			System.out.println("Number of Products: "+numOfProducts);

			Report.put("For Site Ids :User verifies the items Associated with Custom Group with Name of the Site ID and Site Details",
					"Grid should be populated with the following  columns: Site Id, Site Details(Site Name, Site Address)Product name, Product Nickname, Site Location. Note : User should also see how any products are under that particular custom group",
					"Grid Populated with Columns: "+Report.color(columnList)+"Sites under Custom Groups are: "+Report.color(numOfProducts), "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("For Site Ids :User verifies the items Associated with Custom Group with Name of the Site ID and Site Details",
					"Grid should be populated with the following  columns: Site Id, Site Details(Site Name, Site Address)Product name, Product Nickname, Site Location. Note : User should also see how any products are under that particular custom group",
					"Failed to display Modal Popup with the columns(Product Details)", "FAIL");
			Assert.fail();
		}
	}

	public void verifyPersonalPreferencePrimaryPhNumDisplayedEmployee(WebDriver driver)
	{
		System.out.println("Inside verifyPersonalPreferencePrimaryPhNumDisplayedEmployee method");
		Log.info("Inside verifyPersonalPreferencePrimaryPhNumDisplayedEmployee method");

		String primaryPhNum = "";

		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);

			primaryPhNum = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.personalPreferencePrimaryPhNumEmployee()).getText();

			System.out.println("Primary Phone Number is: "+primaryPhNum);


			Report.put("User verifies the Primary Phone number",
					"User should be able to see the primary phone number details  that has been entered during 'Business Account' creation for a first time (or)if the user has not made any changes to this field",
					"Primary Phone Number is displayed: "+Report.color(primaryPhNum), "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();

			Report.put("User verifies the Primary Phone number",
					"User should be able to see the primary phone number details  that has been entered during 'Business Account' creation for a first time (or)if the user has not made any changes to this field",
					"Failed to display Primary Phone Number under Personal Preference", "FAIL");
			Assert.fail();
		}
	}

	public void verifySRNotificationPopupProductsDropdown(WebDriver driver)
	{
		System.out.println("Inside verifySRNotificationPopupProductsDropdown method");
		Log.info("Inside verifySRNotificationPopupProductsDropdown method");

		String text = "";
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);

			Select selOption = new  Select(driver.findElement(obj_UnifiedPortalPage.SRNotificationPopupProductsDropdown()));

			List<WebElement> list1= selOption.getOptions();
			int countlist=list1.size();
			System.out.println("Drop down values count "+countlist);

			for(int i=0;i<countlist;i++)
			{
				text+="<br>"+list1.get(i).getText();
				System.out.println("Dropdown Values are: "+text);

			}
			Report.put("Check for the Select your Products dropdown as C/P user",
					"C/P should be able to flip between Account Sites and My Product Groups",
					"Able to flip between "+Report.color(text)+"from the dropdown", "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();

			Report.put("Check for the Select your Products dropdown as C/P user",
					"C/P should be able to flip between Account Sites and My Product Groups",
					"Failed to flip values from the dropdown", "FAIL");
			Assert.fail();
		}
	}

	public void clickSRNotificationPopupCloseButton(WebDriver driver)
	{
		System.out.println("Inside clickSRNotificationPopupCloseButton method");
		Log.info("Inside clickSRNotificationPopupCloseButton method");

		try
		{

			CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.SRNotificationPopupCloseButton());
			System.out.println("Clicked on SRNotificationPopupCloseButton");
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Failed to click on SRNotificationPopupCloseButton");
			Assert.fail();
		}
	}

	public void editSREventNotificationclickSave(WebDriver driver)
	{
		System.out.println("Inside editSREventNotification method");
		Log.info("Inside editSREventNotification method");

		String text = "";
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);

			//	CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.SRNotificationPopupProductCheckbox()).click();
			//CommonUtility.ToClickByUsingJavaScript_PassingByLoc(driver, obj_UnifiedPortalPage.SRNotificationPopupProductCheckbox());
			if(CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.SRNotificationPopupProductCheckbox()).isDisplayed())
			{
				System.out.println("Inside if click SRNotificationPopupProductCheckbox");
				CommonUtility.scrollToViewElement(driver,obj_UnifiedPortalPage.SRNotificationPopupProductCheckbox());
				CommonUtility.ClickOn(driver, obj_UnifiedPortalPage.SRNotificationPopupProductCheckbox());
			}
			if(CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.SRNotificationNameTextbox()).isDisplayed())
			{
				CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.SRNotificationNameTextbox()).clear();
				Thread.sleep(3000);
				CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.SRNotificationNameTextbox()).sendKeys("new_desc");
				System.out.println("Notification textbox is displayed");
			}

			CommonUtility.scrollToViewElement(driver,obj_UnifiedPortalPage.setYourPreferencesCheckbox());
			Thread.sleep(3000);

			List<WebElement> list=driver.findElements(obj_UnifiedPortalPage.setYourPreferencesCheckbox());



			for(WebElement lt:list)
			{
				CommonUtility.highlightElement(driver, lt);
				//	CommonUtility.scrollToViewElement(driver,lt);
				Thread.sleep(3000);
				CommonUtility.ToClickByUsingJavaScript(driver, lt);
				//lt.click();
				System.out.println("Checkbox is enabled");				
			}

			if(CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.SRNotificationSeverityDropdown()).isDisplayed())
			{
				System.out.println("Severity dropdown is displayed");
				Select selOption = new  Select(driver.findElement(obj_UnifiedPortalPage.SRNotificationSeverityDropdown()));
				selOption.selectByIndex(2);
			}

			if(CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.dialHomeSRDropdown()).isDisplayed())
			{
				System.out.println("DialHomeSR Dropdown  is displayed");
				Select selDialHome = new  Select(driver.findElement(obj_UnifiedPortalPage.dialHomeSRDropdown()));
				selDialHome.selectByIndex(1);
			} 	

			//		CommonUtility.scrollToViewElement(driver,obj_UnifiedPortalPage.SRNotificationPopupSaveButton());
			//	CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.SRNotificationPopupSaveButton()).click();
			CommonUtility.ClickOn(driver, obj_UnifiedPortalPage.SRNotificationPopupSaveButton());

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_UnifiedPortalPage.serviceRequestEventsHeader()));
			CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.serviceRequestEventsHeader());

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_UnifiedPortalPage.SREventEditMessage()));
			text = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.SREventEditMessage()).getText();
			System.out.println("Edit message is: "+text);

			Report.put("Make changes to editable fields and click Save",
					"User should be able to save the changes",
					"Able to save the changes"+Report.color(text), "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Make changes to editable fields and click Save",
					"User should be able to save the changes",
					"Failed to load Service Request Events page", "FAIL");
			Assert.fail();
		}
	}

	public void editSREventNotificationclickCancel(WebDriver driver)
	{
		System.out.println("Inside editSREventNotificationclickCancel method");
		Log.info("Inside editSREventNotificationclickCancel method");

		String text = "";
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);

			//	CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.SRNotificationPopupProductCheckbox()).click();
			//CommonUtility.ToClickByUsingJavaScript_PassingByLoc(driver, obj_UnifiedPortalPage.SRNotificationPopupProductCheckbox());
			CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.SRNotificationPopupProductCheckbox());
			if(CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.SRNotificationPopupProductCheckbox()).isDisplayed())
			{
				System.out.println("Inside if click SRNotificationPopupProductCheckbox");
				//				CommonUtility.scrollToViewElement(driver,obj_UnifiedPortalPage.SRNotificationPopupProductCheckbox());
				CommonUtility.ClickOn(driver, obj_UnifiedPortalPage.SRNotificationPopupProductCheckbox());
			}
			if(CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.SRNotificationNameTextbox()).isDisplayed())
			{
				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.SRNotificationNameTextbox());
				CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.SRNotificationNameTextbox()).clear();
				CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.SRNotificationNameTextbox()).sendKeys("new_desc");
				System.out.println("Notification textbox is displayed");
			}

			CommonUtility.scrollToViewElement(driver,obj_UnifiedPortalPage.setYourPreferencesCheckbox());
			Thread.sleep(3000);

			List<WebElement> list=driver.findElements(obj_UnifiedPortalPage.setYourPreferencesCheckbox());



			for(WebElement lt:list)
			{
				CommonUtility.highlightElement(driver, lt);
				//	CommonUtility.scrollToViewElement(driver,lt);
				Thread.sleep(3000);
				CommonUtility.ToClickByUsingJavaScript(driver, lt);
				//lt.click();
				System.out.println("Checkbox is enabled");				
			}

			if(CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.SRNotificationSeverityDropdown()).isDisplayed())
			{
				System.out.println("Severity dropdown is displayed");
				Select selOption = new  Select(driver.findElement(obj_UnifiedPortalPage.SRNotificationSeverityDropdown()));
				selOption.selectByIndex(2);
			}

			if(CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.dialHomeSRDropdown()).isDisplayed())
			{
				System.out.println("DialHomeSR Dropdown  is displayed");
				Select selDialHome = new  Select(driver.findElement(obj_UnifiedPortalPage.dialHomeSRDropdown()));
				selDialHome.selectByIndex(1);
			} 	

			CommonUtility.scrollToViewElement(driver,obj_UnifiedPortalPage.SRNotificationPopupCancelButton());
			//	CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.SRNotificationPopupSaveButton()).click();
			CommonUtility.ClickOn(driver, obj_UnifiedPortalPage.SRNotificationPopupCancelButton());

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_UnifiedPortalPage.serviceRequestEventsHeader()));
			CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.serviceRequestEventsHeader());


			Report.put("Repeat the Steps 3 to 7 and > Make changes and click Cancel",
					"The changes should not be saved",
					"Able to click on Cancel"+Report.color(text), "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();

			Report.put("Repeat the Steps 3 to 7 and > Make changes and click Cancel",
					"The changes should not be saved",
					"Failed to click on Cancel in SR Event Popup", "FAIL");
			Assert.fail();
		}
	}

	public void verifyActionsButtonOptions(WebDriver driver)
	{
		System.out.println("Inside verifyActionsButtonOptions method");
		Log.info("Inside verifyActionsButtonOptions method");


		String header = "";
		String optionList = "";

		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);

			CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.actionsButtonFirstRow()).click();
			//	CommonUtility.ToClickByUsingJavaScript_PassingByLoc(driver, obj_UnifiedPortalPage.actionsButtonFirstRow());

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_UnifiedPortalPage.actionsButtonOptionsList()));

			List<WebElement> list=driver.findElements(obj_UnifiedPortalPage.actionsButtonOptionsListItems());

			for(WebElement lt:list)
			{
				CommonUtility.highlightElement(driver, lt);
				String option=lt.getText();

				System.out.println("Option is: " +option);
				optionList+=" <br> " + option;
			}
			System.out.println("Options are:"+optionList);		


			Report.put("Click on the button below the 'Actions ' menu for one notification",
					"A small modal should be displayed with the links to Edit, View Details, Delete",
					"Modal Popup displayed successfully with Options"+Report.color(optionList), "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();

			Report.put("Click on the button below the 'Actions ' menu for one notification",
					"A small modal should be displayed with the links to Edit, View Details, Delete",
					"Failed to load display Actions modal popup", "FAIL");
			Assert.fail();
		}
	}

	public void clickActionsButtonViewDetailsOption(WebDriver driver)
	{
		System.out.println("Inside clickActionsButtonViewDetailsOption method");
		Log.info("Inside clickActionsButtonViewDetailsOption method");

		String confirmButton = "";
		String cancelButton = "";
		String header = "";
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);
			System.out.println("Inside try of clickActionsButtonViewDetailsOption");
			driver.findElement(obj_UnifiedPortalPage.actionsButtonFirstRow());
			//	CommonUtility.ToClickByUsingJavaScript_PassingByLoc(driver,  obj_UnifiedPortalPage.actionsButtonFirstRow());
			CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.actionsButtonFirstRow()).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_UnifiedPortalPage.actionsButtonOptionsList()));
			CommonUtility.ClickOn(driver, obj_UnifiedPortalPage.actionsColumnViewDetailsOption());

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_UnifiedPortalPage.notificationDetailsHeader()));
			header = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.notificationDetailsHeader()).getText();


			Report.put("Click on the link View Details",
					"The Notification details should be displayed in the popup",
					"Popup displayed successfully with header"+Report.color(header), "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();

			Report.put("Click on the link View Details",
					"The Notification details should be displayed in the popup",
					"Failed to load Notification Details modal popup", "FAIL");
			Assert.fail();
		}
	}

	public void verifyNotificationPopupDetails(WebDriver driver)
	{
		System.out.println("Inside verifyNotificationPopupDetails method");
		Log.info("Inside verifyNotificationPopupDetails method");


		String header = "";
		String detailList = "";

		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);

			List<WebElement> list=driver.findElements(obj_UnifiedPortalPage.notificationPopupDetailsList());

			for(WebElement lt:list)
			{
				CommonUtility.highlightElement(driver, lt);
				String detail=lt.getAttribute("innerText");

				System.out.println("Detail is: " +detail);
				detailList+=" <br> " + detail;
			}
			System.out.println("Details are:"+detailList);		


			Report.put("Verify all the details in the popup",
					"The popup should have the following details 1.Name of the notification 2. Description of the notification 3. Notify me when a Service Request is <with options selected by the user> 4. Initial Severity Level <with option selected by the user> 5. Escalations  •<Notify me on all escalations>when user option selected is On•Do not notify me when user option selected is Off6. Dial Home Service Requests<with option selected by the user>",
					"Notification Popup displayed successfully with Details "+Report.color(detailList), "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();

			Report.put("Verify all the details in the popup",
					"The popup should have the following details 1.Name of the notification 2. Description of the notification 3. Notify me when a Service Request is <with options selected by the user> 4. Initial Severity Level <with option selected by the user> 5. Escalations  •<Notify me on all escalations>when user option selected is On•Do not notify me when user option selected is Off6. Dial Home Service Requests<with option selected by the user>",
					"Failed to  display Actions Notification popup", "FAIL");
			Assert.fail();
		}
	}

	public void clickNotificationPopupCloseButton(WebDriver driver)
	{
		System.out.println("Inside clickNotificationPopupCloseButton method");
		Log.info("Inside clickNotificationPopupCloseButton method");


		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);

			CommonUtility.scrollToViewElement(driver,obj_UnifiedPortalPage.notificationPopupCloseButton());
			CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.notificationPopupCloseButton());


			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_UnifiedPortalPage.serviceRequestEventsHeader()));
			CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.serviceRequestEventsHeader());
			String header = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.serviceRequestEventsHeader()).getText();

			Report.put("Click on the Cancel button ",
					"Cancel should kill the modal window and land the user back on list of subscriptions",
					"Closed modal window succesfully & displayed"+Report.color(header), "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();

			Report.put("Click on the Cancel button ",
					"Cancel should kill the modal window and land the user back on list of subscriptions",
					"Failed to click on Close button", "FAIL");
			Assert.fail();
		}
	}

	public void verifySREventNotificationSetYourPreferenceValues(WebDriver driver)
	{
		System.out.println("Inside verifySREventNotificationSetYourPreferenceValues method");
		Log.info("Inside verifySREventNotificationSetYourPreferenceValues method");

		String valList = "";

		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);		

			List<WebElement> list=driver.findElements(obj_UnifiedPortalPage.setYourPreferencesLabels());

			for(WebElement lt:list)
			{
				CommonUtility.highlightElement(driver, lt);
				String value=lt.getText();

				System.out.println("Value is: " +value);
				valList+=" <br> " + value;
			}
			System.out.println("Values are:"+valList);			

			Report.put("Verify the values under the Set your preferences section",
					"The following values should be displayed under Set your preferences: Created, Updated, Closed",
					"Set your Preferences values are:"+Report.color(valList), "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify the values under the Set your preferences section",
					"The following values should be displayed under Set your preferences: Created, Updated, Closed",
					"Failed to load Preferences Values", "FAIL");
			Assert.fail();
		}
	}

	public void selectSitesSRNotificationPopupProductsDropdown(WebDriver driver)
	{
		System.out.println("Inside selectSitesSRNotificationPopupProductsDropdown method");
		Log.info("Inside selectSitesSRNotificationPopupProductsDropdown method");

		String text = "";
		String valList = "";
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);

			Select selOption = new  Select(driver.findElement(obj_UnifiedPortalPage.SRNotificationPopupProductsDropdown()));


			selOption.selectByVisibleText("My Account Sites");
			WebElement selectedOption = selOption.getFirstSelectedOption();
			text = selectedOption.getText();
			List<WebElement> list=driver.findElements(obj_UnifiedPortalPage.SREventPopupSitesHeaderList());

			for(WebElement lt:list)
			{
				CommonUtility.highlightElement(driver, lt);
				String value=lt.getText();

				System.out.println("Value is: " +value);
				valList+=" <br> " + value;
			}
			System.out.println("Values are:"+valList);	

			Report.put("User verifies Account sites Dropdown on the page",
					"Account Sites should be loaded with the following data columns: Site ID, Site Name, Site Location",
					"Selected"+Report.color(text)+"from the dropdown. Displayed columns"+Report.color(valList), "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();


			Report.put("User verifies Account sites Dropdown on the page",
					"Account Sites should be loaded with the following data columns: Site ID, Site Name, Site Location",
					"Failed to select Account Sites from the dropdown", "FAIL");
			Assert.fail();
		}
	}

	public void clickSREventNotificationSitesCheckbox(WebDriver driver)
	{
		System.out.println("Inside clickSREventNotificationSitesCheckbox method");
		Log.info("Inside clickSREventNotificationSitesCheckbox method");

		String text = "";
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);

			if(CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.SRNotificationPopupSitesCheckbox()).isDisplayed())
			{
				System.out.println("Inside if click SRNotificationPopupSitesCheckbox");
				CommonUtility.scrollToViewElement(driver,obj_UnifiedPortalPage.SRNotificationPopupSitesCheckbox());
				CommonUtility.ClickOn(driver, obj_UnifiedPortalPage.SRNotificationPopupSitesCheckbox());
			}

			Report.put("User verifies that he/she has ability to select all",
					"That should be notified on all the products within the Account Sites of User",
					"Able to select all Products within the Account Sites", "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();

			Report.put("User verifies that he/she has ability to select all",
					"That should be notified on all the products within the Account Sites of User",
					"Failed to select all Products within the Account Sites", "FAIL");
			Assert.fail();
		}
	}

	public void verifySREventNotificationPagination(WebDriver driver)
	{
		System.out.println("Inside verifySREventNotificationPagination method");
		Log.info("Inside verifySREventNotificationPagination method");

		String text = "";
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);

			CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.SRNotificationPopupPaginationTextbox());

			if(CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.SRNotificationPopupPaginationTextbox()).isEnabled())
			{
				System.out.println("Inside if  SRNotificationPopupPaginationTextbox");

			}
			if((CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.SRNotificationPopupPaginationPreviousPage()).isDisplayed()) && (CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.SRNotificationPopupPaginationPreviousPage()).isDisplayed()))
			{
				System.out.println("Inside if  SRNotificationPopupPaginationPreviousPage & SRNotificationPopupPaginationPreviousPage ");

			}

			if((CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.SRNotificationPopupPaginationFirstPage()).isDisplayed()) && (CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.SRNotificationPopupPaginationLastPage()).isDisplayed()))
			{
				System.out.println("Inside if  SRNotificationPopupPaginationFirstPage & SRNotificationPopupPaginationLastPage ");

			}
			Report.put("User verifies Pagination",
					"User should be able to paginate through the set of results using the page control",
					"User is displayed with Pagination Controls", "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();

			Report.put("User verifies Pagination",
					"User should be able to paginate through the set of results using the page control",
					"Failed to display Pagination Controls", "FAIL");
			Assert.fail();
		}
	}

	public void verifyActivateNotificationSREventNotification(WebDriver driver)
	{
		System.out.println("Inside verifyActivateNotificationSREventNotification method");
		Log.info("Inside verifyActivateNotificationSREventNotification method");

		String text = "";

		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);

			if((CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.SRNotificationPopupActivateNotificationLabel()).isDisplayed()) && (CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.SRNotificationPopupActivateNotificationLabel()).isDisplayed()))
			{
				text = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.SRNotificationPopupActivateNotificationLabel()).getText();
				System.out.println("Text is: "+text);
			}				


			Report.put("Activate Notification",
					"User should see the Activate Notification Toggle button there ",
					"User displayed "+Report.color(text), "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();

			Report.put("Activate Notification",
					"User should see the Activate Notification Toggle button there ",
					"Failed to display Activate Notification Toggle button ", "FAIL");
			Assert.fail();
		}
	}

	public void verifySaveandCancelButtonREventNotification(WebDriver driver)
	{
		System.out.println("Inside verifySaveandCancelButtonREventNotification method");
		Log.info("Inside verifySaveandCancelButtonREventNotification method");

		String saveButton = "";
		String cancelButton = "";

		try
		{
			CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.SRNotificationPopupSaveButton());

			saveButton = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.SRNotificationPopupSaveButton()).getAttribute("value");
			System.out.println("Button is: "+saveButton);

			cancelButton = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.SRNotificationPopupCancelButton()).getAttribute("value");
			System.out.println("Button is: "+cancelButton);


			Report.put("User sees Save and Cancel Button at the End of the Page",
					"User should see the  Save and Cancel Button at the End of the Page ",
					"Displayed Buttons"+Report.color(saveButton)+Report.color(cancelButton), "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();

			Report.put("User sees Save and Cancel Button at the End of the Page",
					"User should see the  Save and Cancel Button at the End of the Page ",
					"Failed to display button in SR Notification Page", "FAIL");
			Assert.fail();
		}
	}

	public void createSREventNotificationAccountSite(WebDriver driver, String name)
	{
		System.out.println("Inside createSREventNotificationAccountSite method");
		Log.info("Inside createSREventNotificationAccountSite method");

		String text = "";
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);
			CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.SRNotificationNameTextbox());
			if(CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.SRNotificationNameTextbox()).isDisplayed())
			{
				CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.SRNotificationNameTextbox()).clear();
				Thread.sleep(3000);
				CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.SRNotificationNameTextbox()).sendKeys(name);
				System.out.println("Notification textbox is displayed");
			}

			CommonUtility.scrollToViewElement(driver,obj_UnifiedPortalPage.setYourPreferencesCheckbox());
			Thread.sleep(3000);

			List<WebElement> list=driver.findElements(obj_UnifiedPortalPage.setYourPreferencesCheckbox());


			for(WebElement lt:list)
			{
				CommonUtility.highlightElement(driver, lt);
				Thread.sleep(3000);
				if(!(lt.isSelected()))
					CommonUtility.ClickOnWebElement(driver, lt);
				System.out.println("Checkbox is enabled");				
			}

			if(CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.SRNotificationSeverityDropdown()).isDisplayed())
			{
				System.out.println("Severity dropdown is displayed");
				Select selOption = new  Select(driver.findElement(obj_UnifiedPortalPage.SRNotificationSeverityDropdown()));
				selOption.selectByIndex(2);
			}

			if(CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.dialHomeSRDropdown()).isDisplayed())
			{
				System.out.println("DialHomeSR Dropdown  is displayed");
				Select selDialHome = new  Select(driver.findElement(obj_UnifiedPortalPage.dialHomeSRDropdown()));
				selDialHome.selectByIndex(1);
			} 	

			CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.SRNotificationPopupSaveButton());
			//	CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.SRNotificationPopupSaveButton()).click();
			CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.SRNotificationPopupSaveButton());

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_UnifiedPortalPage.serviceRequestEventsHeader()));
			CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.serviceRequestEventsHeader());

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_UnifiedPortalPage.SREventCreateMessage()));
			text = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.SREventCreateMessage()).getText();
			System.out.println("Save message is: "+text);

			Report.put("User verifies Save button is enabled ,when user selects all the values in each criteria.",
					"User should be able to save the changes",
					"Able to save the changes"+Report.color(text), "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Make changes to editable fields and click Save",
					"User should be able to save the changes",
					"Failed to load Service Request Events page", "FAIL");
			Assert.fail();
		}
	}

	public void  ValidateMyAdvisoryAlertsTabInGrid(WebDriver driver) 
	{

		Log.info("Inside ValidateMyAdvisoryAlertsTabInGrid method");

		String header = "";

		String text="";
		String text1="";
		String text2="";
		String text3="";
		String text4="";
		String labelList2="";
		String labelList="";
		String labelList1="";
		String text5="";

		WebDriverWait  wait = new WebDriverWait(driver, 60);	
		try
		{
			List<WebElement> list=driver.findElements(obj_UnifiedPortalPage.GridColumnsHeadings());

			for(int i=0;i<list.size();i++)
			{

				if(i==0)
				{
					CommonUtility.scrollToViewElement(driver, list.get(i));
					text=CommonUtility.highlightElement(driver, list.get(i)).getText();
					System.out.println("tab name is "+text);


					List<WebElement> list1=driver.findElements(obj_UnifiedPortalPage.AddAdvisoryAltersTab());

					for(WebElement lt1:list1)
					{
						CommonUtility.highlightElement(driver, lt1);
						String label1=lt1.getText();

						System.out.println("product values " +label1);
						labelList1+=" <br> " + label1;
					}
					System.out.println("products and product names under my advisory alert tab is :"+labelList1);
				}
			}


			Report.put("User verifies My Advisory Alerts",
					"User should be able to verify that the My Advisory Alerts tab includes the list of products and product name", 
					"user able to see "+Report.color(text)+" tab in grid of notifications and it includes "+Report.color(labelList1), "PASS");

		}

		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("User verifies My Advisory Alerts",
					"User should be able to verify that the My Advisory Alerts tab includes the list of products and product name", 
					"Failed to see mt advisory alerts tab in grid", "FAIL");
			Assert.fail();
		}
	}

	public void  ValidateTechnicalTabInGrid(WebDriver driver) 
	{

		Log.info("Inside ValidateTechnicalTabInGrid method");

		String header = "";

		String text="";
		String text1="";
		String text2="";
		String text3="";
		String text4="";
		String labelList2="";
		String labelList="";
		String labelList1="";
		String text5="";

		WebDriverWait  wait = new WebDriverWait(driver, 60);	
		try
		{
			List<WebElement> list=driver.findElements(obj_UnifiedPortalPage.GridColumnsHeadings());

			for(int i=0;i<list.size();i++)
			{

				if(i==1)
				{
					CommonUtility.scrollToViewElement(driver, list.get(i));
					text=CommonUtility.highlightElement(driver, list.get(i)).getText();
					System.out.println("tab name is "+text);


					List<WebElement> list1=driver.findElements(obj_UnifiedPortalPage.TechnicalTabValidations());

					for(WebElement lt1:list1)
					{
						CommonUtility.scrollToViewElement(driver, lt1);
						CommonUtility.highlightElement(driver, lt1);

					}

					CommonUtility.scrollToViewElement(driver, obj_UnifiedPortalPage.ClickOnFirstCheckBoxUnderTechnicalTab());
					CommonUtility.highlightElement(driver, obj_UnifiedPortalPage.ClickOnFirstCheckBoxUnderTechnicalTab()).click();

					System.out.println("user able to select the check boc under technical tab");

				}
			}


			Report.put("user verifies Technical (DTA)  tab",
					"User should be able to select and unselect the products Under DTA tab", 
					"user able to see "+Report.color(text)+" tab in grid of notifications and user able to select and unselect the products Under DTA tab", "PASS");

		}

		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("user verifies Technical (DTA)  tab",
					"User should be able to select and unselect the products Under DTA tab", 
					"Failed to see technical tab in advisories grid", "FAIL");
			Assert.fail();
		}
	}

	public void  ValidateSecurityTabInGrid(WebDriver driver) 
	{

		Log.info("Inside ValidateSecurityTabInGrid method");

		String header = "";

		String text="";
		String text1="";
		String text2="";
		String text3="";
		String text4="";
		String labelList2="";
		String labelList="";
		String labelList1="";
		String text5="";

		WebDriverWait  wait = new WebDriverWait(driver, 60);	
		try
		{
			List<WebElement> list=driver.findElements(obj_UnifiedPortalPage.GridColumnsHeadings());

			for(int i=0;i<list.size();i++)
			{

				if(i==2)
				{
					CommonUtility.scrollToViewElement(driver, list.get(i));
					text=CommonUtility.highlightElement(driver, list.get(i)).getText();
					System.out.println("tab name is "+text);


					List<WebElement> list1=driver.findElements(obj_UnifiedPortalPage.SecurityTabValidations());

					for(WebElement lt1:list1)
					{
						CommonUtility.scrollToViewElement(driver, lt1);
						CommonUtility.highlightElement(driver, lt1);

					}

					CommonUtility.scrollToViewElement(driver, obj_UnifiedPortalPage.ClickOnFirstCheckBoxUnderSecurityTab());
					CommonUtility.highlightElement(driver, obj_UnifiedPortalPage.ClickOnFirstCheckBoxUnderSecurityTab()).click();

					System.out.println("user able to select the check box under security tab");

				}
			}


			Report.put("user verifies Security (DSA) tab ",
					"User should be able to select and unselect the products under DSA tab", 
					"user able to see "+Report.color(text)+" tab in grid of notifications and user able to select and unselect the products Under DSA tab", "PASS");

		}

		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("user verifies Security (DSA) tab ",
					"User should be able to select and unselect the products under DSA tab", 
					"Failed to see security tab in advisories grid", "FAIL");
			Assert.fail();
		}
	}

	public void  ValidateActionsTabInGrid(WebDriver driver) 
	{

		Log.info("Inside ValidateActionsTabInGrid method");

		String header = "";

		String text="";
		String text1="";
		String text2="";
		String text3="";
		String text4="";
		String labelList2="";
		String labelList="";
		String labelList1="";
		String text5="";
		String text6="";
		String text7="";

		WebDriverWait  wait = new WebDriverWait(driver, 60);	
		try
		{
			List<WebElement> list=driver.findElements(obj_UnifiedPortalPage.GridColumnsHeadings());

			for(int i=0;i<list.size();i++)
			{

				if(i==3)
				{
					CommonUtility.scrollToViewElement(driver, list.get(i));
					text=CommonUtility.highlightElement(driver, list.get(i)).getText();
					System.out.println("tab name is "+text);

					List<WebElement> list4=driver.findElements(obj_UnifiedPortalPage.GridColumnsHeadings());

					for(int j=0;j<list4.size();j++)
					{

						if(j==0)
						{
							CommonUtility.scrollToViewElement(driver, list4.get(i));
							text5=CommonUtility.highlightElement(driver, list4.get(i)).getText();
							System.out.println("tab name is "+text5);

							CommonUtility.scrollToViewElement(driver, obj_UnifiedPortalPage.FirstProductNameDisplayed());
							text2=CommonUtility.highlightElement(driver, obj_UnifiedPortalPage.FirstProductNameDisplayed()).getText();
							System.out.println("product name before delete is "+text2);


						}
					}

					List<WebElement> list1=driver.findElements(obj_UnifiedPortalPage.ActionsTabValidations());

					for(WebElement lt1:list1)
					{
						CommonUtility.scrollToViewElement(driver, lt1);
						CommonUtility.highlightElement(driver, lt1);

					}

					CommonUtility.scrollToViewElement(driver, obj_UnifiedPortalPage.ClickOnFirstTabUnderActionsTabForDeleteButton());
					CommonUtility.highlightElement(driver, obj_UnifiedPortalPage.ClickOnFirstTabUnderActionsTabForDeleteButton()).click();


					CommonUtility.scrollToViewElement(driver, obj_UnifiedPortalPage.DeleteButton());
					text1=CommonUtility.highlightElement(driver, obj_UnifiedPortalPage.DeleteButton()).getText();
					System.out.println("button is "+text1);

					CommonUtility.highlightElement(driver, obj_UnifiedPortalPage.DeleteButton()).click();

					wait.until(ExpectedConditions.visibilityOfElementLocated(obj_UnifiedPortalPage.DeleteNotificationHeadingInPopUpForAdvisories()));
					CommonUtility.scrollToViewElement(driver, obj_UnifiedPortalPage.DeleteNotificationHeadingInPopUpForAdvisories());
					text6=CommonUtility.highlightElement(driver, obj_UnifiedPortalPage.DeleteNotificationHeadingInPopUpForAdvisories()).getText();
					System.out.println("heading of pop up is "+text6);

					CommonUtility.scrollToViewElement(driver, obj_UnifiedPortalPage.DeleteNotificationPopUpDescriptionForAdvisories());
					text7=CommonUtility.highlightElement(driver, obj_UnifiedPortalPage.DeleteNotificationPopUpDescriptionForAdvisories()).getText();
					System.out.println("description is "+text7);

					CommonUtility.scrollToViewElement(driver, obj_UnifiedPortalPage.ConfirmButtonInDeleteNotificationPopUpForAdvisories());
					CommonUtility.highlightElement(driver, obj_UnifiedPortalPage.ConfirmButtonInDeleteNotificationPopUpForAdvisories()).click();

					driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);

					System.out.println("user able to see delete button clicking on actions button");

					List<WebElement> list3=driver.findElements(obj_UnifiedPortalPage.GridColumnsHeadings());

					for(int k=0;k<list3.size();k++)
					{

						if(k==0)
						{
							CommonUtility.scrollToViewElement(driver, list3.get(k));
							text3=CommonUtility.highlightElement(driver, list3.get(k)).getText();
							System.out.println("tab name is "+text3);

							CommonUtility.scrollToViewElement(driver, obj_UnifiedPortalPage.FirstProductNameDisplayed());
							text2=CommonUtility.highlightElement(driver, obj_UnifiedPortalPage.FirstProductNameDisplayed()).getText();
							System.out.println("product name after delete is "+text2);


						}
					}

					if(text2.equals(text5))
					{
						System.out.println("product name not removed from grid");
						Report.put("user verifies the Actions  tab",
								"User should be able to Delete the product ", 
								"Failed to delete a row", "FAIL");
						Assert.fail();
					}

				}
			}


			Report.put("user verifies the Actions  tab",
					"User should be able to Delete the product ", 
					"user able to see "+Report.color(text)+" tab and able to delete a ow clicking on it", "PASS");

		}

		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("user verifies the Actions  tab",
					"User should be able to Delete the product ",  
					"Failed to delete a row", "FAIL");
			Assert.fail();
		}
	}

	public void  ValidateClickingFirstDisplayedProductHyperlink(WebDriver driver) 
	{

		Log.info("Inside ValidateClickingFirstDisplayedProductHyperlink method");

		String header = "";

		String text="";
		String text1="";
		String text2="";
		String text3="";
		String text4="";
		String labelList2="";
		String labelList="";
		String labelList1="";
		String text5="";
		String title="";
		String url="";

		WebDriverWait  wait = new WebDriverWait(driver, 60);	
		try
		{

			CommonUtility.scrollToViewElement(driver, obj_UnifiedPortalPage.FirstProductNameDisplayed());
			text=CommonUtility.highlightElement(driver, obj_UnifiedPortalPage.FirstProductNameDisplayed()).getText();
			System.out.println("first displayed product is "+text);
			CommonUtility.highlightElement(driver, obj_UnifiedPortalPage.FirstProductNameDisplayed()).click();



			Set<String> allWH=driver.getWindowHandles(); 
			String currentwindow=driver.getWindowHandle();
			int countWindow=allWH.size(); 

			System.out.println("Switched Window Handles and  window count is :: "+countWindow);

			for(String wh:allWH)
			{
				Thread.sleep(10000);
				driver.switchTo().window(wh); 
				url=driver.getCurrentUrl();
				System.out.println("URL displayed as   :::::"+url); 
				driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
				title = driver.getTitle();
				System.out.println("Switched to window" +title);		

				driver.close();
				driver.switchTo().window(currentwindow);						

			}

			driver.switchTo().window(currentwindow);	

			Report.put("User checks that when clicked on the product hyperlink user is redirected to model page ",
					"User should be able to click on the products (where model pages are available) and be redirected to them", 
					"user able to click on first displayed product "+Report.color(text)+" and able to redirect to model page with url "+Report.color(url)+" and title "+Report.color(title), "PASS");

		}

		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("User checks that when clicked on the product hyperlink user is redirected to model page ",
					"User should be able to click on the products (where model pages are available) and be redirected to them",  
					"Failed to see product hyperlink", "FAIL");
			Assert.fail();
		}
	}

	public void  ValidateClickingOnAllTechnicalToggleButton(WebDriver driver) 
	{

		Log.info("Inside ValidateClickingOnAllTechnicalToggleButton method");

		String header = "";

		String text="";
		String text1="";
		String text2="";
		String text3="";
		String text4="";
		String labelList2="";
		String labelList="";
		String labelList1="";
		String text5="";

		WebDriverWait  wait = new WebDriverWait(driver, 60);	
		try
		{

			CommonUtility.scrollToViewElement(driver, obj_UnifiedPortalPage.AllTechnicalToggleButton());
			CommonUtility.highlightElement(driver, obj_UnifiedPortalPage.AllTechnicalToggleButton()).click();

			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);

			List<WebElement> list2=driver.findElements(obj_UnifiedPortalPage.ValidateTechnicalTabAfterTogglingOnAllTechnicalButton());

			for(WebElement lt1:list2)
			{
				CommonUtility.scrollToViewElement(driver, lt1);
				CommonUtility.highlightElement(driver, lt1);

			}


			Report.put("User clicks on  'All Technical (DTA)' toggle button",
					"'All Technical (DTA)' from DSA column selected so far should be un-editable (greyed out) ", 
					"user able to click on 'All Technical (DTA)' toffle button on and able to see All Technical (DTA) is un-editable (greyed out)", "PASS");

		}

		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("User clicks on  'All Technical (DTA)' toggle button",
					"'All Technical (DTA)' from DSA column selected so far should be un-editable (greyed out) ", 
					"Failed to see All Technical (DTA) toggle button", "FAIL");
			Assert.fail();
		}
	}

	public void  ValidateClickingOnAllSecurityToggleButton(WebDriver driver) 
	{

		Log.info("Inside ValidateClickingOnAllSecurityToggleButton method");

		String header = "";

		String text="";
		String text1="";
		String text2="";
		String text3="";
		String text4="";
		String labelList2="";
		String labelList="";
		String labelList1="";
		String text5="";

		WebDriverWait  wait = new WebDriverWait(driver, 60);	
		try
		{

			CommonUtility.scrollToViewElement(driver, obj_UnifiedPortalPage.AllSecurityToggleButton());
			CommonUtility.highlightElement(driver, obj_UnifiedPortalPage.AllSecurityToggleButton()).click();

			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);

			List<WebElement> list2=driver.findElements(obj_UnifiedPortalPage.ValidateSecurityTabAfterTogglingOnAllTechnicalButton());

			for(WebElement lt1:list2)
			{
				CommonUtility.scrollToViewElement(driver, lt1);
				CommonUtility.highlightElement(driver, lt1);

			}


			Report.put("User clicks on  'All Security (DSA)' toggle button",
					"'All Security (DSA)' from DSA column selected so far should be un-editable (greyed out) ", 
					"user able to click on 'All Security (DSA)' toffle button on and able to see All Security (DSA) is un-editable (greyed out)", "PASS");

		}

		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("User clicks on  'All Security (DSA)' toggle button",
					"'All Security (DSA)' from DSA column selected so far should be un-editable (greyed out) ",  
					"Failed to see All Security (DSA) toggle button", "FAIL");
			Assert.fail();
		}
	}

	public void  ValidateClickingOnAddAlertButton(WebDriver driver) 
	{

		Log.info("Inside ValidateClickingOnAddAlertButton method");

		String header = "";

		String text="";
		String text1="";
		String text2="";
		String text3="";
		String text4="";
		String labelList2="";
		String labelList="";
		String labelList1="";
		String text5="";
		String value=TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[0];

		WebDriverWait  wait = new WebDriverWait(driver, 60);	
		try
		{

			CommonUtility.scrollToViewElement(driver, obj_UnifiedPortalPage.AddAlertButtonWithAdvisoryAlerts());
			CommonUtility.highlightElement(driver, obj_UnifiedPortalPage.AddAlertButtonWithAdvisoryAlerts()).click();

			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);

			CommonUtility.scrollToViewElement(driver, obj_UnifiedPortalPage.DeleteNotificationHeadingInPopUp());
			text=CommonUtility.highlightElement(driver, obj_UnifiedPortalPage.DeleteNotificationHeadingInPopUp()).getText();
			System.out.println("pop up name is "+text);

			CommonUtility.scrollToViewElement(driver, obj_UnifiedPortalPage.SearchTextBoxInAddingAlertInAdvisoriesTab());
			CommonUtility.highlightElement(driver, obj_UnifiedPortalPage.SearchTextBoxInAddingAlertInAdvisoriesTab()).clear();
			CommonUtility.highlightElement(driver, obj_UnifiedPortalPage.SearchTextBoxInAddingAlertInAdvisoriesTab()).sendKeys(value);;

			CommonUtility.scrollToViewElement(driver, obj_UnifiedPortalPage.AddProductInAddAlertInAdvisoriesTab());
			CommonUtility.highlightElement(driver, obj_UnifiedPortalPage.AddProductInAddAlertInAdvisoriesTab()).click();

			List<WebElement> list1=driver.findElements(obj_UnifiedPortalPage.AddAdvisoryAltersTab());

			for(WebElement lt1:list1)
			{
				CommonUtility.highlightElement(driver, lt1);
				String label1=lt1.getText();

				System.out.println("product values " +label1);
				labelList1+=" <br> " + label1;
			}
			System.out.println("products and product names under my advisory alert tab is :"+labelList1);



			Report.put("User clicks on  'All Security (DSA)' toggle button",
					"'All Security (DSA)' from DSA column selected so far should be un-editable (greyed out) ", 
					"user able to click on 'All Security (DSA)' toffle button on and able to see All Security (DSA) is un-editable (greyed out)", "PASS");

		}

		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("User clicks on  'All Security (DSA)' toggle button",
					"'All Security (DSA)' from DSA column selected so far should be un-editable (greyed out) ",  
					"Failed to see All Security (DSA) toggle button", "FAIL");
			Assert.fail();
		}
	}

	public void searchAccountSitesAndClickFilterButton(WebDriver driver, String input)
	{
		System.out.println("Inside searchAccountSitesAndClickFilterButton method");
		Log.info("Inside searchAccountSitesAndClickFilterButton method");

		String productName = "";
		String accountList = "";
		String defaultList = "";
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);

			System.out.println("Input from Testdata is: "+input);						
			Thread.sleep(10000);
			CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.accountSiteSearchTextbox()).sendKeys(input);	

			CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.accountSiteFilterButton());
			Thread.sleep(10000);
			//	CommonUtility.ToClickByUsingJavaScript_PassingByLoc(driver, obj_UnifiedPortalPage.accountSiteFilterButton());
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_UnifiedPortalPage.accountSiteFilterList()));

			Report.put("Search for Site ID ",
					"Able to search the required site ID",
					"Searched for text "+Report.color(input), "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Search any text and observe that text is highlighted. Click 'X' in text box and observe that Search text is cleared and default data set appears.",
					"On clicking 'X', Search text is cleared and default data set appears. ",
					"Failed to search the text", "FAIL");
			Assert.fail();
		}
	}

	public void searchSiteIdInCreateSiteGroupAndClickFilterButton(WebDriver driver, String input)
	{
		System.out.println("Inside searchSiteIdInCreateSiteGroupAndClickFilterButton method");
		Log.info("Inside searchSiteIdInCreateSiteGroupAndClickFilterButton method");

		String productName = "";
		String accountList = "";
		String defaultList = "";
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);

			System.out.println("Input from Testdata is: "+input);						
			Thread.sleep(10000);
			CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.createSiteGroupSiteSearchTextbox()).sendKeys(input);	

			CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.createSiteGroupSiteFilterButton());
			Thread.sleep(10000);
			//	CommonUtility.ToClickByUsingJavaScript_PassingByLoc(driver, obj_UnifiedPortalPage.accountSiteFilterButton());
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_UnifiedPortalPage.accountSiteList()));

			Report.put("Search for Site ID ",
					"Able to search the required site ID",
					"Searched for text "+Report.color(input), "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Search any text and observe that text is highlighted. Click 'X' in text box and observe that Search text is cleared and default data set appears.",
					"On clicking 'X', Search text is cleared and default data set appears. ",
					"Failed to search the text", "FAIL");
			Assert.fail();
		}
	}

	public void clickSiteCustomGroupName(WebDriver driver, String groupName)
	{
		System.out.println("Inside clickSiteCustomGroupName method");
		Log.info("Inside clickSiteCustomGroupName method");

		String name = "";
		String header = "";
		String desc = "";

		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);

			System.out.println("Custom group Name from testdata is: "+groupName);


			name = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.siteCustomGroupNameFirstRow()).getText();

			System.out.println("Group name from application is: "+name);

			if(name.equalsIgnoreCase(groupName))
			{
				CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.siteCustomGroupNameFirstRow());
				System.out.println("Clicked on Site Custom Group");

				header = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.siteCustomGroupHeader()).getText();
				desc = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.siteCustomGroupDescription()).getText();

				System.out.println("Site Group Name & description is: "+header +desc);

				Report.put("User Selects a custom group",
						" User should be navigated to the 'Site Group' details page with Name of the custom group & Description reflecting there ",
						"Clicked on group "+Report.color(name)+"Name of the Custom group  "+Report.color(header)+"Description is: "+Report.color(desc), "PASS");
			}
			else
			{
				System.out.println("Failed to click on Custom Group");

				Report.put("User Selects a custom group",
						" User should be navigated to the 'Site Group' details page with Name of the custom group & Description reflecting there ",
						"Failed to click on Custom Group", "FAIL");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();

			System.out.println("Failed to click on Custom Group");

			Report.put("User Selects a custom group",
					" User should be navigated to the 'Site Group' details page with Name of the custom group & Description reflecting there ",
					"Failed to click on Custom Group", "FAIL");
			Assert.fail();
		}
	}

	public void verifyEditCustomGroupButton(WebDriver driver)
	{
		System.out.println("Inside verifyEditCustomGroupButton method");
		Log.info("Inside verifyEditCustomGroupButton method");

		String button = "";

		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);

			if(CommonUtility.CheckpresenceofElementLocated(driver, 10, obj_UnifiedPortalPage.editCustomGroupButton()))
			{
				button = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.editCustomGroupButton()).getText();

				System.out.println("Button is: "+button);

				Report.put("User verifies Edit custom group button is available",
						" The Edit custom Group should be present ",
						"Verified button "+Report.color(button), "PASS");
			}
			else
			{
				System.out.println("Failed to verify Edit custom group button");

				Report.put("User verifies Edit custom group button is available",
						" The Edit custom Group should be present ",
						"Failed to verify Edit custom group button", "FAIL");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();

			System.out.println("Failed to verify Edit custom group button");

			Report.put("User verifies Edit custom group button is available",
					" The Edit custom Group should be present ",
					"Failed to verify Edit custom group button", "FAIL");
			Assert.fail();
		}
	}

	public void verifySiteCustomGroupColumns(WebDriver driver)
	{
		System.out.println("Inside verifySiteCustomGroupColumns method");
		Log.info("Inside verifySiteCustomGroupColumns method");

		String columnList = "";

		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);

			List<WebElement> list=driver.findElements(obj_UnifiedPortalPage.myCustomGroupsColumns());

			for(WebElement lt:list)
			{
				CommonUtility.highlightElement(driver, lt);
				String column=lt.getText();

				System.out.println("Column is: " +column);
				columnList+=" <br> " + column;
			}
			System.out.println("Columns are:"+columnList);					


			Report.put("User verifies Grid is populated with the following columns with sort able in ascending and descending order",
					"The following columns should be populated in Grid with ability to sort them in ascending and descending order: Site ID, Site Name, Site Location",
					"Displayed columns successfully."+Report.color(columnList), "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("User verifies Grid is populated with the following columns with sort able in ascending and descending order",
					"The following columns should be populated in Grid with ability to sort them in ascending and descending order: Site ID, Site Name, Site Location",
					"Failed to Display the columns", "FAIL");
			Assert.fail();
		}
	}

	public void verifySearchTextBoxSiteGroup(WebDriver driver)
	{
		System.out.println("Inside verifySearchTextBoxSiteGroup method");
		Log.info("Inside verifySearchTextBoxSiteGroup method");

		String button = "";

		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);

			if(CommonUtility.CheckpresenceofElementLocated(driver, 10, obj_UnifiedPortalPage.searchTextBoxInEditSiteGroup()))
			{
				System.out.println("Search box is present");

				Report.put("User Sees Search Site box at Right hand side",
						"Search site box should be present",
						"Search site box is present", "PASS");
			}
			else
			{
				System.out.println("Failed to verify Search box is present");

				Report.put("User Sees Search Site box at Right hand side",
						"Search site box should be present",
						"Failed to verify Search box is present", "FAIL");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();

			System.out.println("Failed to verify Search box is present");

			Report.put("User Sees Search Site box at Right hand side",
					"Search site box should be present",
					"Failed to verify Search box is present", "FAIL");
			Assert.fail();
		}
	}

	public void verifyDeletePopupSiteCustomGroup(WebDriver driver)
	{
		System.out.println("Inside verifyDeletePopupSiteCustomGroup method");
		Log.info("Inside verifyDeletePopupSiteCustomGroup method");

		String yesButton = "";
		String noButton = "";
		String header = "";
		String text = "";
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);

			driver.findElement(obj_UnifiedPortalPage.actionsButtonFirstRow());
			CommonUtility.ClickOn(driver, obj_UnifiedPortalPage.actionsButtonFirstRow());

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_UnifiedPortalPage.actionsColumnDeleteOption()));
			CommonUtility.ClickOn(driver, obj_UnifiedPortalPage.actionsColumnDeleteOption());

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_UnifiedPortalPage.deletePopupSiteCustomGroupHeader()));
			header = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.deletePopupSiteCustomGroupHeader()).getText();

			text = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.deletePopupSiteCustomGroupText()).getText();

			yesButton =	CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.deletePopupSiteCustomGroupYesButton()).getText();
			noButton = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.deletePopupSiteCustomGroupNoButton()).getText();

			CommonUtility.ClickOn(driver, obj_UnifiedPortalPage.deletePopupSiteCustomGroupXButton());

			Report.put("Upon selecting Delete, user sees a message popping up 'Are you sure you want to remove the site? with Yes or No options",
					"User should see the following options. Yes, No",
					Report.color(header)+"displayed successfully with text" +Report.color(text)+" and buttons"+Report.color(yesButton)+" and "+Report.color(noButton), "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();

			Report.put("Upon selecting Delete, user sees a message popping up 'Are you sure you want to remove the site? with Yes or No options",
					"User should see the following options. Yes, No",
					"Failed to load Delete  modal popup", "FAIL");
			Assert.fail();
		}
	}

	public void verifyPaginationTextSiteCustomGroup(WebDriver driver)
	{
		System.out.println("Inside verifyPaginationTextSiteCustomGroup method");
		Log.info("Inside verifyPaginationTextSiteCustomGroup method");

		String text = "";
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);			

			if((CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.siteCustomGroupCountofRecordsText()).isDisplayed()))
			{
				text = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.siteCustomGroupCountofRecordsText()).getText();

				System.out.println("Count of records is: "+text);

				Report.put("User sees count of records displaying on that particular page where it shows displaying 6 out of total records ",
						"User should be able to see the count of records on that particular page with total number of records also displaying there",
						"Displayed count of records on that particular page"+Report.color(text), "PASS");
			}		
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("User sees count of records displaying on that particular page where it shows displaying 6 out of total records ",
					"User should be able to see the count of records on that particular page with total number of records also displaying there",
					"Failed to verify count of records on that particular page", "FAIL");
			Assert.fail();
		}
	}

	public void signOut(WebDriver driver)

	{

		System.out.println("Entering signOut");
		Log.info("Entering signOut");
		WebDriverWait wait = new WebDriverWait(driver, 120);
		try
		{			
			CommonUtility.ScrollTo(driver, obj_EsupportIPSHomePage.signInLabel());
			handleCookies(driver);
			WebElement ele = driver.findElement(obj_EsupportIPSHomePage.signOutButton());
			CommonUtility.ScrollTo(driver, obj_EsupportIPSHomePage.signOutButton());
			CommonUtility.ClickOn(driver, obj_EsupportIPSHomePage.signOutButton());
			handleCookies(driver);
			Thread.sleep(10000);
			Report.put("Log out from the current user", "User should be able to logout ",
					"Logged Out Successfully", "PASS");


		}
		catch(Exception e){
			Log.info(e);
			Report.put("Log out from the current user", "User should be able to logout ",
					"Failed while logging out", "FAIL");
			e.printStackTrace();
			Assert.fail();

		}

	}

	//Lavanya, new custom group cases

	public void validateAddCustomGroupButton(WebDriver driver)
	{

		Log.info("Inside validateAddCustomGroupButton method");

		String button = "";

		try
		{

			if(CommonUtility.CheckpresenceofElementLocated(driver,33,obj_UnifiedPortalPage.AddCustomGroup()))
			{
				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.AddCustomGroup());	
				button=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.AddCustomGroup()).getText();	
				System.out.println("button name is "+button);



				Report.put("User checks if able to view  button 'Add Custom Group' in the landing page	",
						"User should be  view 'Add Custom Group' button",
						"User able to see "+Report.color(button)+" button", "PASS");
			}
			else
			{
				System.out.println("not able to see add custom group button");
				Report.put("User checks if able to view  button 'Add Custom Group' in the landing page	",
						"User should be  view 'Add Custom Group' button",
						"User not able to see Add customer group button", "Fail");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("User checks if able to view  button 'Add Custom Group' in the landing page	",
					"User should be  view 'Add Custom Group' button",
					"User not able to see Add customer group button", "Fail");
			Assert.fail();
		}
	}

	public void clickOnAddCustomGroupButton(WebDriver driver)
	{

		Log.info("Inside clickOnAddCustomGroupButton method");

		String button = "";
		String header="";
		String totaloptions="";
		WebDriverWait wait = new WebDriverWait(driver, 600);
		try
		{

			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_UnifiedPortalPage.AddCustomGroup()))
			{
				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.AddCustomGroup());	
				button=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.AddCustomGroup()).getText();	
				System.out.println("button name is "+button);
				CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.AddCustomGroup());	

				wait.until(ExpectedConditions.presenceOfElementLocated(obj_UnifiedPortalPage.CreateACustomGroupHeader()));
				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.CreateACustomGroupHeader());	
				header=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.CreateACustomGroupHeader()).getText();	
				System.out.println("header is "+header);
				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.OptionsUnderCustomGroupCreation());
				List<WebElement> list=driver.findElements(obj_UnifiedPortalPage.OptionsUnderCustomGroupCreation());

				for(WebElement lt:list)
				{
					CommonUtility.highlightElement(driver, lt);
					String option=lt.getText();

					System.out.println("options are " +option);
					totaloptions+=" <br> " + option;
				}
				System.out.println("all options are "+totaloptions);



				Report.put("click on 'Add Custom Group' ",
						"User should be directed to 'Create  a Custom Group' page Title -Create a Custom Group <br> -Create a Custom Group by selecting individual Products -Create a Custom Group by selecting Sites and/or Product Families ",
						"User able to click on  "+Report.color(button)+" button and able to see "+Report.color(header)+" title with options to select "+Report.color(totaloptions), "PASS");
			}
			else
			{
				System.out.println("not able to click on add custom group button");
				Report.put("click on 'Add Custom Group' ",
						"User should be directed to 'Create  a Custom Group' page Title -Create a Custom Group <br> -Create a Custom Group by selecting individual Products -Create a Custom Group by selecting Sites and/or Product Families ",
						"User not able to click on Add customer group button", "Fail");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("click on 'Add Custom Group' ",
					"User should be directed to 'Create  a Custom Group' page Title -Create a Custom Group <br> -Create a Custom Group by selecting individual Products -Create a Custom Group by selecting Sites and/or Product Families ",
					"User not able to click on Add customer group button", "Fail");
			Assert.fail();
		}
	}

	public void validateCreateCustomGroupButton(WebDriver driver)
	{

		Log.info("Inside validateCreateCustomGroupButton method");

		String button = "";
		String message="";
		try
		{
			Thread.sleep(6000);
			CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.EmptyStateInCustomerGroup());
			if(CommonUtility.CheckpresenceofElementLocated(driver,33,obj_UnifiedPortalPage.CreateCustomGroupButtonInEmptyState()))
			{
				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.EmptyStateInCustomerGroup());	
				message=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.EmptyStateInCustomerGroup()).getText();	
				System.out.println("message is "+message);
				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.CreateCustomGroupButtonInEmptyState());	
				button=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.CreateCustomGroupButtonInEmptyState()).getText();	
				System.out.println("button name is "+button);



				Report.put("User checks if able to view  button 'Create Custom Group' in the empty state",
						"User should see a button 'Create Custom Group' in the empty state",
						"User able to see "+Report.color(button)+" button with message "+Report.color(message), "PASS");
			}
			else
			{
				System.out.println("not able to see create custom group button");
				Report.put("User checks if able to view  button 'Create Custom Group' in the empty state",
						"User should see a button 'Create Custom Group' in the empty state",
						"User not able to see create customer group button", "Fail");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("User checks if able to view  button 'Create Custom Group' in the empty state",
					"User should see a button 'Create Custom Group' in the empty state",
					"User not able to see create customer group button", "Fail");
			Assert.fail();
		}
	}

	public void clickOnCreateCustomGroupButton(WebDriver driver)
	{

		Log.info("Inside clickOnCreateCustomGroupButton method");

		String button = "";
		String header="";
		String totaloptions="";
		WebDriverWait wait = new WebDriverWait(driver, 600);
		try
		{

			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_UnifiedPortalPage.CreateCustomGroupButtonInEmptyState()))
			{
				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.CreateCustomGroupButtonInEmptyState());	
				button=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.CreateCustomGroupButtonInEmptyState()).getText();	
				System.out.println("button name is "+button);
				CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.CreateCustomGroupButtonInEmptyState());	

				wait.until(ExpectedConditions.presenceOfElementLocated(obj_UnifiedPortalPage.CreateACustomGroupHeader()));
				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.CreateACustomGroupHeader());	
				header=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.CreateACustomGroupHeader()).getText();	
				System.out.println("header is "+header);
				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.OptionsUnderCustomGroupCreation());
				List<WebElement> list=driver.findElements(obj_UnifiedPortalPage.OptionsUnderCustomGroupCreation());

				for(WebElement lt:list)
				{
					CommonUtility.highlightElement(driver, lt);
					String option=lt.getText();

					System.out.println("options are " +option);
					totaloptions+=" <br> " + option;
				}
				System.out.println("all options are "+totaloptions);



				Report.put("click on 'Create Custom Group' ",
						"User should be directed to 'Create  a Custom Group' page Title -Create a Custom Group <br> -Create a Custom Group by selecting individual Products -Create a Custom Group by selecting Sites and/or Product Families ",
						"User able to click on  "+Report.color(button)+" button and able to see "+Report.color(header)+" title with options to select "+Report.color(totaloptions), "PASS");
			}
			else
			{
				System.out.println("not able to click on create custom group button");
				Report.put("click on 'create Custom Group' ",
						"User should be directed to 'Create  a Custom Group' page Title -Create a Custom Group <br> -Create a Custom Group by selecting individual Products -Create a Custom Group by selecting Sites and/or Product Families ",
						"User not able to click on create customer group button", "Fail");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("click on 'create Custom Group' ",
					"User should be directed to 'Create  a Custom Group' page Title -Create a Custom Group <br> -Create a Custom Group by selecting individual Products -Create a Custom Group by selecting Sites and/or Product Families ",
					"User not able to click on create customer group button", "Fail");
			Assert.fail();
		}
	}

	public void SelectCreateByInduvidualProductsOption(WebDriver driver)
	{

		Log.info("Inside SelectCreateByInduvidualProductsOption method");

		String button = "";
		String header="";
		String header1="";
		String options="";
		WebDriverWait wait = new WebDriverWait(driver, 600);
		try
		{

			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_UnifiedPortalPage.CustomGroupCreationByIndividualProducts()))
			{
				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.CustomGroupCreationByIndividualProducts());	
				button=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.CustomGroupCreationByIndividualProducts()).getText();	
				System.out.println("option is "+button);
				CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.CustomGroupCreationByIndividualProducts());	

				wait.until(ExpectedConditions.presenceOfElementLocated(obj_UnifiedPortalPage.NextButtonInCustomGroupCreation()));
				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.NextButtonInCustomGroupCreation());	
				header=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.NextButtonInCustomGroupCreation()).getText();	
				System.out.println("button is "+header);
				CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.NextButtonInCustomGroupCreation());

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.CreateACustomGroupHeader());	
				header1=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.CreateACustomGroupHeader()).getText();	
				System.out.println("header is "+header1);

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.CustomGroupName());	
				String custname=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.CustomGroupName()).getText();	
				System.out.println("header is "+custname);
				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.CustomGroupNameTextBox());	

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.CustomGroupDescription());	
				String custdes=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.CustomGroupDescription()).getText();	
				System.out.println("header is "+custdes);
				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.CustomerGroupDescriptionTextBox());	

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.CustomGroupDescription());	
				String selprod=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.CustomGroupDescription()).getText();	
				System.out.println("header is "+selprod);

				Report.put("User selects 'Create by individual Products',and clicks 'Next'",
						"screen should load up and User should see the below options : Title : Create a Custom Group Select Products section",
						"User able to select "+Report.color(button)+" and clicking on "+Report.color(header)+" landed on <br>"+Report.color(header1)+" and "+Report.color(custname+" and "+custdes+" and "+selprod), "PASS");

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.SearchByHeader());	
				String serby=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.SearchByHeader()).getText();	
				System.out.println("header is "+serby);

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.SearchBySropDownValues());
				List<WebElement> list=driver.findElements(obj_UnifiedPortalPage.SearchBySropDownValues());

				for(WebElement lt:list)
				{
					CommonUtility.highlightElement(driver, lt);
					String label=lt.getText();

					System.out.println("option is: " +label);
					options+=" <br> " + label;
				}
				System.out.println("Options are:"+options);

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.ProductSearchHeader());	
				String prodsea=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.ProductSearchHeader()).getText();	
				System.out.println("header is "+prodsea);

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.SearchTextBox());	

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.InstructionText());	
				String instruction=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.InstructionText()).getText();	
				System.out.println("instruction is "+instruction);


				Report.put("User verifies the  Select Products section",
						"User should be able view : 1. Search by drop down with 'Search by Product' and 'Search by Site' options 2. Product Search box with watermark text indicating 'Enter a Serial Number or Service Tag' -6 min characters for SN and 5 for Service Tag",
						"User able to view "+Report.color(serby)+" with drop down options "+Report.color(options)+" and "+Report.color(prodsea)+" with text box with instruction message "+Report.color(instruction), "PASS");

			}
			else
			{
				System.out.println("not able to see select by induvidual option");
				Report.put("User selects 'Create by individual Products',and clicks 'Next'",
						"screen should load up and User should see the below options : Title : Create a Custom Group Select Products section",
						"User not able to see select by induvidual option", "Fail");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("User selects 'Create by individual Products',and clicks 'Next'",
					"screen should load up and User should see the below options : Title : Create a Custom Group Select Products section",
					"User not able to see select by induvidual option", "Fail");
			Assert.fail();
		}
	}

	public void SearchForProductCode(WebDriver driver, String search)
	{

		Log.info("Inside SearchForProductCode method");

		String button = "";
		String header="";
		String header1="";
		String columnam="";
		String rownam="";

		WebDriverWait wait = new WebDriverWait(driver, 240);
		try
		{

			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_UnifiedPortalPage.CustomGroupNameTextBox()))
			{
				//				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.InstructionText());	
				CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.CountrySelector());
				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.CustomGroupNameTextBox());	
				CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.CustomGroupNameTextBox()).clear();
				CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.CustomGroupNameTextBox()).sendKeys(TestNGCreator.TestData.get(Esupport.FirstName.ordinal()));

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.SearchTextBox());	
				CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.SearchTextBox()).clear();
				CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.SearchTextBox()).sendKeys(search);
				CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.CountrySelector());	
				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.SearchButton());
				Thread.sleep(6000);
				CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.SearchButton());

				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_UnifiedPortalPage.ColumnNamesInTheGridOfSelectByProduct()));
				List<WebElement> list=driver.findElements(obj_UnifiedPortalPage.ColumnNamesInTheGridOfSelectByProduct());
				List<WebElement> list1=driver.findElements(obj_UnifiedPortalPage.NumberSearchResultsDisplayed());

				int count=list1.size();
				System.out.println("total number of search rows displayed is "+count);
				for(WebElement lt:list)
				{
					CommonUtility.highlightElement(driver, lt);
					String label=lt.getText();

					System.out.println("column name is: " +label);
					columnam+=" <br> " + label;
				}
				System.out.println("table header is:"+columnam);


				List<WebElement> list2=driver.findElements(obj_UnifiedPortalPage.DetailsInEachRow());


				System.out.println("total number of search rows displayed is "+count);
				for(WebElement lt:list)
				{
					CommonUtility.ScrollToWebElement(driver, lt);
					String label=lt.getText();

					System.out.println("row name is: " +label);
					rownam+=" <br> " + label;
				}
				System.out.println("row grid details:"+rownam);

				Report.put("User selects :Search by Product ' and inputs any SN or ST and and clicks on search",
						"The search results should be retrieved based on the user's visibility model The list of assets should be displayed in the grid and the following fields should be available: <br> Asset ID ,Product Name,Product Nickname,Site ID ,Site Details (Site Name ,Address of the site)",
						"User able to search "+Report.color(search)+" and able to see grid details with columns "+Report.color(columnam)+" and row details "+Report.color(rownam), "PASS");

			}
			else
			{
				System.out.println("not able to see search text box");
				Report.put("User selects :Search by Product ' and inputs any SN or ST and and clicks on search",
						"The search results should be retrieved based on the user's visibility model The list of assets should be displayed in the grid and the following fields should be available: <br> Asset ID ,Product Name,Product Nickname,Site ID ,Site Details (Site Name ,Address of the site)",
						"User not able to see search text box", "Fail");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("User selects :Search by Product ' and inputs any SN or ST and and clicks on search",
					"The search results should be retrieved based on the user's visibility model The list of assets should be displayed in the grid and the following fields should be available: <br> Asset ID ,Product Name,Product Nickname,Site ID ,Site Details (Site Name ,Address of the site)",
					"User not able to see search text box", "Fail");
			Assert.fail();
		}
	}

	public void SelectOneOrMultipleAssets(WebDriver driver)
	{

		Log.info("Inside SelectOneOrMultipleAssets method");

		String button = "";

		WebDriverWait wait = new WebDriverWait(driver, 600);
		try
		{

			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_UnifiedPortalPage.FiestCheckBox()))
			{

				if(CommonUtility.CheckpresenceofElementLocated(driver,10,obj_UnifiedPortalPage.FiestCheckBox()))
				{
					CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.FiestCheckBox());
					CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.FiestCheckBox());
				}

				if(CommonUtility.CheckpresenceofElementLocated(driver,10,obj_UnifiedPortalPage.SecCheckBox()))
				{
					CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.SecCheckBox());
					CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.SecCheckBox());
				}

				if(CommonUtility.CheckpresenceofElementLocated(driver,10,obj_UnifiedPortalPage.ThirdCheckBox()))
				{
					CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.ThirdCheckBox());
					CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.ThirdCheckBox());
				}

				if(CommonUtility.CheckpresenceofElementLocated(driver,10,obj_UnifiedPortalPage.ForthCheckBox()))
				{
					CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.ForthCheckBox());
					CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.ForthCheckBox());
				}

				if(CommonUtility.CheckpresenceofElementLocated(driver,10,obj_UnifiedPortalPage.FifthCheckBox()))
				{
					CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.FifthCheckBox());
					CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.FifthCheckBox());
				}
				if(CommonUtility.CheckpresenceofElementLocated(driver,10,obj_UnifiedPortalPage.SixCheckBox()))
				{
					CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.SixCheckBox());
					CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.SixCheckBox());
				}

				//				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.CheckBoxInGrid());
				//				List<WebElement> list=driver.findElements(obj_UnifiedPortalPage.CheckBoxInGrid());
				//
				//				int count=list.size();
				//				System.out.println("total number of checkbox displayed is "+count);
				//				int count1=0;
				//				for(int i=0;i<list.size();i++)
				//				{
				//					count1++;
				//
				//					if(count1==1)
				//					{
				//						try
				//						{
				//						if (!(list.get(i).isSelected())) 
				//						{
				//							try
				//							{
				//								Thread.sleep(3000);
				//								CommonUtility.ScrollToWebElement(driver, list.get(i));
				//								CommonUtility.ClickOnWebElement(driver, list.get(i));
				//
				//								Thread.sleep(3000);
				//							}
				//							catch(Exception e)
				//							{
				//
				//							}
				//						}
				//						}
				//						catch(Exception e)
				//						{
				//
				//						}
				//					}
				//					else
				//					{
				//						break;
				//					}
				//
				//
				//				}

				if(CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.AddToGroupButtonInGrid()).isEnabled())
				{
					CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.AddToGroupButtonInGrid());
					button=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.AddToGroupButtonInGrid()).getText();
					System.out.println("button is "+button);
				}



				Report.put("User tries to select one or multiple assets by clicks on checkbox next to the assets",
						"User should be able to  select multiple/one/all the assets in the grid for custom group creation and 'Add to Group' button is enabled",
						"User able to select multiple assets enabled "+Report.color(button)+" button", "PASS");

			}
			else
			{
				System.out.println("not able to see check box");
				Report.put("User tries to select one or multiple assets by clicks on checkbox next to the assets",
						"User should be able to  select multiple/one/all the assets in the grid for custom group creation and 'Add to Group' button is enabled",
						"User not able to see check box", "Fail");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("User tries to select one or multiple assets by clicks on checkbox next to the assets",
					"User should be able to  select multiple/one/all the assets in the grid for custom group creation and 'Add to Group' button is enabled",
					"User not able to see check box", "Fail");
			Assert.fail();
		}
	}

	public void SelectOneOrMultipleAssets_IE(WebDriver driver)
	{

		Log.info("Inside SelectOneOrMultipleAssets_IE method");

		String button = "";

		WebDriverWait wait = new WebDriverWait(driver, 600);
		try
		{

			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_UnifiedPortalPage.FiestCheckBoxForIE()))
			{

				if(CommonUtility.CheckpresenceofElementLocated(driver,10,obj_UnifiedPortalPage.FiestCheckBoxForIE()))
				{
					CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.FiestCheckBoxForIE());
					CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.FiestCheckBoxForIE());
				}

				if(CommonUtility.CheckpresenceofElementLocated(driver,10,obj_UnifiedPortalPage.SecCheckBoxForIE()))
				{
					CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.SecCheckBoxForIE());
					CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.SecCheckBoxForIE());
				}

				if(CommonUtility.CheckpresenceofElementLocated(driver,10,obj_UnifiedPortalPage.ThirdCheckBoxForIE()))
				{
					CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.ThirdCheckBoxForIE());
					CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.ThirdCheckBoxForIE());
				}

				if(CommonUtility.CheckpresenceofElementLocated(driver,10,obj_UnifiedPortalPage.ForthCheckBoxForIE()))
				{
					CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.ForthCheckBoxForIE());
					CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.ForthCheckBoxForIE());
				}

				if(CommonUtility.CheckpresenceofElementLocated(driver,10,obj_UnifiedPortalPage.FifthCheckBoxForIE()))
				{
					CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.FifthCheckBoxForIE());
					CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.FifthCheckBoxForIE());
				}
				if(CommonUtility.CheckpresenceofElementLocated(driver,10,obj_UnifiedPortalPage.SixCheckBoxForIE()))
				{
					CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.SixCheckBoxForIE());
					CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.SixCheckBoxForIE());
				}

				//				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.CheckBoxInGrid());
				//				List<WebElement> list=driver.findElements(obj_UnifiedPortalPage.CheckBoxInGrid());
				//
				//				int count=list.size();
				//				System.out.println("total number of checkbox displayed is "+count);
				//				int count1=0;
				//				for(int i=0;i<list.size();i++)
				//				{
				//					count1++;
				//
				//					if(count1==1)
				//					{
				//						try
				//						{
				//						if (!(list.get(i).isSelected())) 
				//						{
				//							try
				//							{
				//								Thread.sleep(3000);
				//								CommonUtility.ScrollToWebElement(driver, list.get(i));
				//								CommonUtility.ClickOnWebElement(driver, list.get(i));
				//
				//								Thread.sleep(3000);
				//							}
				//							catch(Exception e)
				//							{
				//
				//							}
				//						}
				//						}
				//						catch(Exception e)
				//						{
				//
				//						}
				//					}
				//					else
				//					{
				//						break;
				//					}
				//
				//
				//				}

				if(CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.AddToGroupButtonInGrid()).isEnabled())
				{
					CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.AddToGroupButtonInGrid());
					button=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.AddToGroupButtonInGrid()).getText();
					System.out.println("button is "+button);
				}



				Report.put("User tries to select one or multiple assets by clicks on checkbox next to the assets",
						"User should be able to  select multiple/one/all the assets in the grid for custom group creation and 'Add to Group' button is enabled",
						"User able to select multiple assets enabled "+Report.color(button)+" button", "PASS");

			}
			else
			{
				System.out.println("not able to see check box");
				Report.put("User tries to select one or multiple assets by clicks on checkbox next to the assets",
						"User should be able to  select multiple/one/all the assets in the grid for custom group creation and 'Add to Group' button is enabled",
						"User not able to see check box", "Fail");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("User tries to select one or multiple assets by clicks on checkbox next to the assets",
					"User should be able to  select multiple/one/all the assets in the grid for custom group creation and 'Add to Group' button is enabled",
					"User not able to see check box", "Fail");
			Assert.fail();
		}
	}

	public void ClickOnAddToGroupButton(WebDriver driver)
	{

		Log.info("Inside ClickOnAddToGroupButton method");

		String button = "";
		String button1 = "";
		String button2="";
		String cancel="";
		String testcase=TestNGCreator.TestData.get(Esupport.TestCaseID.ordinal());
		WebDriverWait wait = new WebDriverWait(driver, 240);
		try
		{
			//			Actions act=new Actions(driver);
			//			act.moveToElement(CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.AddToGroupButtonInGrid())).build().perform();

			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_UnifiedPortalPage.AddToGroupButtonInGrid()))
			{

				if(CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.AddToGroupButtonInGrid()).isEnabled())
				{

					//					List<WebElement> list=driver.findElements(obj_UnifiedPortalPage.TextInGrid());
					//
					//					for(int i=0;i<list.size();i++)
					//					{
					//						CommonUtility.ScrollToWebElement(driver, list.get(i));
					////						CommonUtility.highlightElement(driver, list.get(i));
					//					}
					Thread.sleep(6000);
					CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.CountrySelector());
					CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.AddToGroupButtonInGrid());
					button=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.AddToGroupButtonInGrid()).getText();
					System.out.println("button is "+button);
					CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.AddToGroupButtonInGrid());



					Thread.sleep(6000);
					wait.until(ExpectedConditions.visibilityOfElementLocated(obj_UnifiedPortalPage.CreateCustomGroupButtonEnable()));
					CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.CreateCustomGroupButtonEnable());
					button1=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.CreateCustomGroupButtonEnable()).getText();
					System.out.println("button is "+button1);

					CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.CancelButton());
					cancel=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.CancelButton()).getText();
					System.out.println("button is "+cancel);

					CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.ShowSelectedProductsTab());
					button2=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.ShowSelectedProductsTab()).getText();
					System.out.println("button is "+button2);


					if(testcase.equals("8382682"))
					{
						Report.put("User adds the products  using 'Add to Group' in a Custom Group created using 'Products'",
								"Clicking on 'Add to Group' should flash the bottom section in blue for n seconds and create custom group button should be enabled and Show selected products tab should be enabled",
								"User able to click on "+Report.color(button)+" button and able to see "+Report.color(button1)+ " button enabled and able to see "+Report.color(button2)+ " tab displayed", "PASS");

						Report.put("User verifies Create Custom Group , cancel , Show Selected Products at the bottom of the page ",
								"Create Custom Group , cancel , Show Selected Products options are enabled ",
								"User able to see "+Report.color(button)+" button enabled and able to see "+Report.color(button1)+ " button enabled with "+Report.color(cancel)+" and able to see "+Report.color(button2)+ " tab displayed", "PASS");
					}
					else
					{
						Report.put("User adds the products  using 'Add to Group' in a Custom Group created using 'Products'",
								"Clicking on 'Add to Group' should flash the bottom section in blue for n seconds and create custom group button should be enabled and Show selected products tab should be enabled",
								"User able to click on "+Report.color(button)+" button and able to see "+Report.color(button1)+ " button enabled and able to see "+Report.color(button2)+ " tab displayed", "PASS");
					}
				}
				else
				{
					System.out.println("not able to see add to group button enabled");
					Report.put("User adds the products  using 'Add to Group' in a Custom Group created using 'Products'",
							"Clicking on 'Add to Group' should flash the bottom section in blue for n seconds and create custom group button should be enabled and Show selected products tab should be enabled",
							"User not able to see check box", "Fail");
					Assert.fail();
				}


			}
			else
			{
				System.out.println("not able to see add to group button");
				Report.put("User adds the products  using 'Add to Group' in a Custom Group created using 'Products'",
						"Clicking on 'Add to Group' should flash the bottom section in blue for n seconds and create custom group button should be enabled and Show selected products tab should be enabled",
						"User not able to see add to group button", "Fail");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("User adds the products  using 'Add to Group' in a Custom Group created using 'Products'",
					"Clicking on 'Add to Group' should flash the bottom section in blue for n seconds and create custom group button should be enabled and Show selected products tab should be enabled",
					"User not able to see add to group button", "Fail");
			Assert.fail();
		}

	}


	public void ClickOnShowSelectedProductsTab(WebDriver driver)
	{

		Log.info("Inside ClickOnShowSelectedProductsTab method");

		String button = "";
		String header = "";
		String hide="";
		String labelList="";
		WebDriverWait wait = new WebDriverWait(driver, 240);
		try
		{

			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_UnifiedPortalPage.ShowSelectedProductsTab()))
			{

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.ShowSelectedProductsTab());
				button=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.ShowSelectedProductsTab()).getText();
				System.out.println("button is "+button);
				CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.ShowSelectedProductsTab());

				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_UnifiedPortalPage.SelectedProductsHeading()));
				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.SelectedProductsHeading());
				header=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.SelectedProductsHeading()).getText();
				System.out.println("heading is "+header);

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.HideSelectedProductsTab());
				hide=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.HideSelectedProductsTab()).getText();
				System.out.println("link is "+hide);

				List<WebElement> list=driver.findElements(obj_UnifiedPortalPage.AssertIDs());

				for(WebElement lt:list)
				{
					CommonUtility.highlightElement(driver, lt);
					String label=lt.getText();

					System.out.println("assert ids: " +label);
					labelList+=" <br> " + label;
				}
				System.out.println("Assert IDs are:"+labelList);

				Report.put("clicks on the downward arrow Note :n indicating the products added to the group so far",
						"'Caret' icon should expand the bottom tray and Show Selected Products (n) and displays the selected products in a grid ",
						"User able to click on "+Report.color(button)+" button and able to see "+Report.color(header)+ " heading and with "+Report.color(hide)+ " tab with selected Products in the grid "+Report.color(labelList), "PASS");

			}
			else
			{
				System.out.println("not able to see selected products window pop up");
				Report.put("clicks on the downward arrow Note :n indicating the products added to the group so far",
						"'Caret' icon should expand the bottom tray and Show Selected Products (n) and displays the selected products in a grid ",
						"User not able to see selected products window pop up", "Fail");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("clicks on the downward arrow Note :n indicating the products added to the group so far",
					"'Caret' icon should expand the bottom tray and Show Selected Products (n) and displays the selected products in a grid ",
					"User not able to see selected products window pop up", "Fail");
			Assert.fail();
		}
	}

	public void verifyColumnNamesInGridOfSelectedItems(WebDriver driver)
	{

		Log.info("Inside verifyColumnNamesInGridOfSelectedItems method");

		String button = "";
		String header = "";
		String hide="";
		String labelList="";
		WebDriverWait wait = new WebDriverWait(driver, 240);
		try
		{

			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_UnifiedPortalPage.ColumnNamesOfGridOfSelectedItems()))
			{

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.ColumnNamesOfGridOfSelectedItems());	
				List<WebElement> list=driver.findElements(obj_UnifiedPortalPage.ColumnNamesOfGridOfSelectedItems());

				for(WebElement lt:list)
				{
					CommonUtility.highlightElement(driver, lt);
					String label=lt.getText();

					System.out.println("column name is : " +label);
					labelList+=" <br> " + label;
				}
				System.out.println("column names are:"+labelList);

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.PaginationLineInShowSelectedPopUp());

				Report.put("User verifies the Grid contains the following options :Asset ID,Product Name,Product Nickname,Site ID,Site Details",
						"Below  column should be displayed (IB status's  to be considered - Installed;Shipped;Awaiting Customer Install;Install-T&M ) Asset ID, Product Name, Product Nickname, Site ID, Site Details. User should be able to paginate through the list of selected products .",
						"User able to see Grid details with columns "+Report.color(labelList)+" along with pagination options to view more list", "PASS");

			}
			else
			{
				System.out.println("not able to see grid details");
				Report.put("User verifies the Grid contains the following options :Asset ID,Product Name,Product Nickname,Site ID,Site Details",
						"Below  column should be displayed (IB status's  to be considered - Installed;Shipped;Awaiting Customer Install;Install-T&M ) Asset ID, Product Name, Product Nickname, Site ID, Site Details. User should be able to paginate through the list of selected products .",
						"User not able to see Grid details", "Fail");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("User verifies the Grid contains the following options :Asset ID,Product Name,Product Nickname,Site ID,Site Details",
					"Below  column should be displayed (IB status's  to be considered - Installed;Shipped;Awaiting Customer Install;Install-T&M ) Asset ID, Product Name, Product Nickname, Site ID, Site Details. User should be able to paginate through the list of selected products .",
					"User not able to see Grid details", "Fail");
			Assert.fail();
		}
	}

	public void SelectOneOrMultipleAssetsOnSelectedProducts(WebDriver driver)
	{

		Log.info("Inside SelectOneOrMultipleAssetsOnSelectedProducts method");

		String button = "";

		WebDriverWait wait = new WebDriverWait(driver, 600);
		try
		{

			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_UnifiedPortalPage.CheckBoxInCustomerGroupSelectedTable()))
			{

				List<WebElement> list=driver.findElements(obj_UnifiedPortalPage.CheckBoxInCustomerGroupSelectedTable());

				int count=list.size();
				System.out.println("total number of checkbox displayed is "+count);
				int count1=0;
				for(int i=0;i<6;i++)
				{
					count1++;

					if(count1==1)
					{
						if (!(list.get(i).isSelected())) 
						{
							try
							{
								CommonUtility.ScrollToWebElement(driver, list.get(i));
								CommonUtility.ClickOnWebElement(driver, list.get(i));
							}
							catch(Exception e)
							{

							}
						}
					}
					else
					{
						break;
					}

				}

				if(CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.RemoveInPopUp()).isEnabled())
				{
					CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.RemoveInPopUp());
					button=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.RemoveInPopUp()).getText();
					System.out.println("button is "+button);

					Report.put("Once the Assets are selected User 'Remove from Group' button is enabled ",
							"The count on  Show Selected Products (n) is reduced accordingly.",
							"user able to see "+Report.color(button)+" enabled on selecting check box", "PASS");
				}



				Report.put("User tries to select one or more assets  by clicking on the checkbox next to the icon ",
						"User should be able to select one ,multiple or all Assets",
						"User able to select multiple checkbox and selecting enabled "+Report.color(button)+" button", "PASS");



			}
			else
			{
				System.out.println("not able to see check box");
				Report.put("User tries to select one or more assets  by clicking on the checkbox next to the icon ",
						"User should be able to select one ,multiple or all Assets",
						"User not able to see check box", "Fail");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("User tries to select one or more assets  by clicking on the checkbox next to the icon ",
					"User should be able to select one ,multiple or all Assets",
					"User not able to see check box", "Fail");
			Assert.fail();
		}
	}

	public void SelectOneOrMultipleAssetsOnSelectedProducts_IE(WebDriver driver)
	{

		Log.info("Inside SelectOneOrMultipleAssetsOnSelectedProducts_IE method");

		String button = "";

		WebDriverWait wait = new WebDriverWait(driver, 600);
		try
		{

			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_UnifiedPortalPage.CheckBoxInCustomerGroupSelectedTableInIE()))
			{

				List<WebElement> list=driver.findElements(obj_UnifiedPortalPage.CheckBoxInCustomerGroupSelectedTableInIE());

				int count=list.size();
				System.out.println("total number of checkbox displayed is "+count);
				int count1=0;
				for(int i=0;i<6;i++)
				{
					count1++;

					if(count1==1)
					{
						if (!(list.get(i).isSelected())) 
						{
							try
							{
								CommonUtility.ScrollToWebElement(driver, list.get(i));
								CommonUtility.ClickOnWebElement(driver, list.get(i));
							}
							catch(Exception e)
							{

							}
						}
					}

				}

				if(CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.RemoveInPopUp()).isEnabled())
				{
					CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.RemoveInPopUp());
					button=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.RemoveInPopUp()).getText();
					System.out.println("button is "+button);

					Report.put("Once the Assets are selected User 'Remove from Group' button is enabled ",
							"The count on  Show Selected Products (n) is reduced accordingly.",
							"user able to see "+Report.color(button)+" enabled on selecting check box", "PASS");
				}



				Report.put("User tries to select one or more assets  by clicking on the checkbox next to the icon ",
						"User should be able to select one ,multiple or all Assets",
						"User able to select multiple checkbox and selecting enabled "+Report.color(button)+" button", "PASS");



			}
			else
			{
				System.out.println("not able to see check box");
				Report.put("User tries to select one or more assets  by clicking on the checkbox next to the icon ",
						"User should be able to select one ,multiple or all Assets",
						"User not able to see check box", "Fail");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("User tries to select one or more assets  by clicking on the checkbox next to the icon ",
					"User should be able to select one ,multiple or all Assets",
					"User not able to see check box", "Fail");
			Assert.fail();
		}
	}

	public void SortingColumnsAssertId(WebDriver driver)
	{

		Log.info("Inside SortingColumnsAssertId method");

		String assertid = ""; String assertclass="";
		String Prodname=""; String prodclass="";
		String nickname="";String nickclass="";
		String siteid="";String siteidclass="";
		String sitedetils=""; String sitedetclass="";

		WebDriverWait wait = new WebDriverWait(driver, 600);
		try
		{

			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_UnifiedPortalPage.AssetIdSorting()))
			{	
				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.AssetIdSorting());
				assertid=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.AssetIdSorting()).getText();
				System.out.println("column name is "+assertid);
				CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.AssetIdSorting());

				Thread.sleep(6000);
				assertclass=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.AssetIdSorting()).getAttribute("class");
				System.out.println("class is "+assertclass);

				if(!(assertclass.contains("sorting_desc")|| assertclass.contains("sorting_asc")))
				{
					System.out.println("not able to see asset id sorting");
					Report.put("User verifies sort on the following columns in ascending and descending order ",
							" User should be able to sort on the following columns in ascending and descending order Asset ID,Product Name,Product Nickname,Site ID,Site Details",
							"User not able to see asset id sorting", "Fail");
					Assert.fail();
				}

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.ProductNameSorting());
				Prodname=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.ProductNameSorting()).getText();
				System.out.println("column name is "+Prodname);
				CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.ProductNameSorting());

				Thread.sleep(6000);
				prodclass=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.ProductNameSorting()).getAttribute("class");
				System.out.println("class is "+prodclass);

				if(!(prodclass.contains("sorting_desc")|| prodclass.contains("sorting_asc")))
				{
					System.out.println("not able to see product name sorting");
					Report.put("User verifies sort on the following columns in ascending and descending order ",
							" User should be able to sort on the following columns in ascending and descending order Asset ID,Product Name,Product Nickname,Site ID,Site Details",
							"User not able to see product name sorting", "Fail");
					Assert.fail();
				}

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.ProductNicknameSorting());
				nickname=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.ProductNicknameSorting()).getText();
				System.out.println("column name is "+nickname);
				CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.ProductNicknameSorting());

				Thread.sleep(6000);
				nickclass=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.ProductNicknameSorting()).getAttribute("class");
				System.out.println("class is "+nickclass);

				if(!(nickclass.contains("sorting_desc")|| nickclass.contains("sorting_asc")))
				{
					System.out.println("not able to see product nickname sorting");
					Report.put("User verifies sort on the following columns in ascending and descending order ",
							" User should be able to sort on the following columns in ascending and descending order Asset ID,Product Name,Product Nickname,Site ID,Site Details",
							"User not able to see product nickname sorting", "Fail");
					Assert.fail();
				}

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.SiteIDSorting());
				siteid=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.SiteIDSorting()).getText();
				System.out.println("column name is "+siteid);
				CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.SiteIDSorting());

				Thread.sleep(6000);
				siteidclass=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.SiteIDSorting()).getAttribute("class");
				System.out.println("class is "+siteidclass);

				if(!(siteidclass.contains("sorting_desc")|| siteidclass.contains("sorting_asc")))
				{
					System.out.println("not able to see site id sorting");
					Report.put("User verifies sort on the following columns in ascending and descending order ",
							" User should be able to sort on the following columns in ascending and descending order Asset ID,Product Name,Product Nickname,Site ID,Site Details",
							"User not able to see site id sorting", "Fail");
					Assert.fail();
				}


				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.SiteDetailsSorting());
				sitedetils=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.SiteDetailsSorting()).getText();
				System.out.println("column name is "+sitedetils);
				CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.SiteDetailsSorting());

				Thread.sleep(6000);
				sitedetclass=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.SiteDetailsSorting()).getAttribute("class");
				System.out.println("class is "+sitedetclass);

				if(!(sitedetclass.contains("sorting_desc")|| sitedetclass.contains("sorting_asc")))
				{
					System.out.println("not able to see site details sorting");
					Report.put("User verifies sort on the following columns in ascending and descending order ",
							" User should be able to sort on the following columns in ascending and descending order Asset ID,Product Name,Product Nickname,Site ID,Site Details",
							"User not able to see site details sorting", "Fail");
					Assert.fail();
				}


				Report.put("User verifies sort on the following columns in ascending and descending order ",
						" User should be able to sort on the following columns in ascending and descending order Asset ID,Product Name,Product Nickname,Site ID,Site Details",
						"User able to sort all columns in ascending and descending", "PASS");

			}
			else
			{
				System.out.println("not able to sort column names");
				Report.put("User verifies sort on the following columns in ascending and descending order ",
						" User should be able to sort on the following columns in ascending and descending order Asset ID,Product Name,Product Nickname,Site ID,Site Details",
						"User not able to sort column names", "Fail");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("User verifies sort on the following columns in ascending and descending order ",
					" User should be able to sort on the following columns in ascending and descending order Asset ID,Product Name,Product Nickname,Site ID,Site Details",
					"User not able to sort column names", "Fail");
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

			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_UnifiedPortalPage.FilterSearchBox()))
			{

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.FilterSearchBox());
				CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.FilterSearchBox()).clear();
				CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.FilterSearchBox()).sendKeys(search);

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.SearchFilterButton());
				CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.SearchFilterButton());

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.ClearXButton());

				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_UnifiedPortalPage.HighlightedTextValidation()));
				List<WebElement> list=driver.findElements(obj_UnifiedPortalPage.HighlightedTextValidation());

				for(int i=0;i<list.size();i++)
				{
					CommonUtility.ScrollToWebElement(driver, list.get(i));
				}

				Report.put("User tries to filter the products using the Filter icon on the right",
						"User should be able to select the filter based on Asset ID, Product Name, Product Nickname, Site ID, Site Details , Results will be highlighted with a clear (X) option",
						"User able to search using filter and able to see searched option highlighted and able to see clear (X) option", "PASS");

			}
			else
			{
				System.out.println("not able to see filter text box");
				Report.put("User tries to filter the products using the Filter icon on the right",
						"User should be able to select the filter based on Asset ID, Product Name, Product Nickname, Site ID, Site Details , Results will be highlighted with a clear (X) option",
						"User not able to see filter text box", "Fail");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("User tries to filter the products using the Filter icon on the right",
					"User should be able to select the filter based on Asset ID, Product Name, Product Nickname, Site ID, Site Details , Results will be highlighted with a clear (X) option",
					"User not able to see filter text box", "Fail");
			Assert.fail();
		}
	}

	public void ClickOnRemoveButton(WebDriver driver)
	{

		Log.info("Inside ClickOnRemoveButton method");

		String button = "";
		String selected = "";

		WebDriverWait wait = new WebDriverWait(driver, 600);
		try
		{

			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_UnifiedPortalPage.RemoveInPopUp()))
			{

				if(CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.RemoveInPopUp()).isEnabled())
				{

					CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.RemoveInPopUp());
					button=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.RemoveInPopUp()).getText();
					System.out.println("button is "+button);
					CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.RemoveInPopUp());

				}
				else
				{
					System.out.println("not able to see remove button");
					Report.put("User clicks on 'Remove from Group'  ",
							"Removes all the assets selected and the selection cart closes and user is returned to the first grid. User should see a Create CustomGroup and Cancel button when returned",
							"User not able to see remove button", "Fail");
					Assert.fail();
				}
				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.HideSelectedProductsTab());
				if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_UnifiedPortalPage.HideSelectedProductsTab()))
				{
					CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.HideSelectedProductsTab());
					String hide=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.HideSelectedProductsTab()).getText();
					System.out.println("button is "+hide);
					//					CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.HideSelectedProductsTab());
					CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.HideSelectedProductsTab());

					CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.ShowSelectedProductsTab());
					selected=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.ShowSelectedProductsTab()).getText();
					System.out.println("button is "+selected);


					Report.put("User clicks on 'Hide Selected Products ' option",
							"Hide Selected Products collapses the bottom tray and restores to the previous stage",
							"User able to see "+Report.color(hide)+" button, seleted products tray closed and restored provious page ", "PASS");

				}
				else
				{
					System.out.println("not able to see hide selected products button");
					Report.put("User clicks on 'Hide Selected Products ' option",
							"Hide Selected Products collapses the bottom tray and restores to the previous stage",
							"User not able to see hide selected products button", "Fail");
					Assert.fail();
				}

				Report.put("User clicks on 'Remove from Group'  ",
						"emoves all the assets selected and the selection cart closes and user is returned to the first grid. User should see a Create CustomGroup and Cancel button when returned",
						"User able to see "+Report.color(button)+" button and after removing number is reduced to "+Report.color(selected), "PASS");

			}
			else
			{
				System.out.println("not able to see remove button");
				Report.put("User clicks on 'Remove from Group'  ",
						"emoves all the assets selected and the selection cart closes and user is returned to the first grid. User should see a Create CustomGroup and Cancel button when returned",
						"User not able to see check box", "Fail");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("User clicks on 'Remove from Group'  ",
					"emoves all the assets selected and the selection cart closes and user is returned to the first grid. User should see a Create CustomGroup and Cancel button when returned",
					"User not able to see remove button", "Fail");
			Assert.fail();
		}
	}

	public void validateFilterSectionInAddCustomGroupPage(WebDriver driver, String search)
	{

		Log.info("Inside validateFilterSectionInAddCustomGroupPage method");

		String button = "";

		WebDriverWait wait = new WebDriverWait(driver, 600);
		try
		{

			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_UnifiedPortalPage.FilterSearchBoxInAddCustomGroup()))
			{

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.FilterSearchBoxInAddCustomGroup());
				CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.FilterSearchBoxInAddCustomGroup()).clear();
				CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.FilterSearchBoxInAddCustomGroup()).sendKeys(search);

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.FilterIcon());
				CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.FilterIcon());

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.ClearXButtonInAddCustomGroup());

				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_UnifiedPortalPage.HighlightedTextValidation()));
				List<WebElement> list=driver.findElements(obj_UnifiedPortalPage.HighlightedTextValidation());

				for(int i=0;i<list.size();i++)
				{
					CommonUtility.highlightElement(driver, list.get(i));
				}

				Report.put("User verifies filter search results on the right  and user types for Example : 'Ness'",
						"Matching results should be displayed with the search text highlighted. All the rows which match 'Ness' should be displayed with the data 'Ness' highlighted",
						"User able to search using filter and able to see searched option highlighted and able to see clear (X) option", "PASS");

			}
			else
			{
				System.out.println("not able to see filter text box");
				Report.put("User verifies filter search results on the right  and user types for Example : 'Ness'",
						"Matching results should be displayed with the search text highlighted. All the rows which match 'Ness' should be displayed with the data 'Ness' highlighted",
						"User not able to see filter text box", "Fail");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("User verifies filter search results on the right  and user types for Example : 'Ness'",
					"Matching results should be displayed with the search text highlighted. All the rows which match 'Ness' should be displayed with the data 'Ness' highlighted",
					"User not able to see filter text box", "Fail");
			Assert.fail();
		}
	}

	public void clickOnXButtonOfFilterClear(WebDriver driver)
	{

		Log.info("Inside clickOnXButtonOfFilterClear method");

		String button = "";

		WebDriverWait wait = new WebDriverWait(driver, 600);
		try
		{

			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_UnifiedPortalPage.ClearXButtonInAddCustomGroup()))
			{

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.ClearXButtonInAddCustomGroup());
				CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.ClearXButtonInAddCustomGroup());
				Thread.sleep(6000);

				if(CommonUtility.CheckpresenceofElementLocated(driver,10,obj_UnifiedPortalPage.ClearXButtonInAddCustomGroup()))
				{
					System.out.println("able to see highlighted search in the grid");
					Report.put("User clicks on the option to clear the 'filter' using 'X'",
							"Data set restores to the original ",
							"User able to see searched view in grid", "Fail");
					Assert.fail();
				}
				else
				{
					System.out.println("not able to see X button");
				}

				Report.put("User clicks on the option to clear the 'filter' using 'X'",
						"Data set restores to the original ",
						"User able to see data refresh and display grid", "PASS");

			}
			else
			{
				System.out.println("not able to see X button");
				Report.put("User clicks on the option to clear the 'filter' using 'X'",
						"Data set restores to the original ",
						"User not able to see X button", "Fail");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("User clicks on the option to clear the 'filter' using 'X'",
					"Data set restores to the original ",
					"User not able to see X button", "Fail");
			Assert.fail();
		}
	}


	public void clickOnXButtonOfFilterClear_ED(WebDriver driver)
	{

		Log.info("Inside clickOnXButtonOfFilterClear_ED method");

		String button = "";

		WebDriverWait wait = new WebDriverWait(driver, 600);
		Actions moveAction=new Actions(driver);
		try
		{

			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_UnifiedPortalPage.ClearXButtonInAddCustomGroup()))
			{

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.ClearXButtonInAddCustomGroup());
				CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.ClearXButtonInAddCustomGroup());

				Thread.sleep(6000);

				if(CommonUtility.CheckpresenceofElementLocated(driver,10,obj_UnifiedPortalPage.ClearXButtonInAddCustomGroup()))
				{
					System.out.println("able to see highlighted search in the grid");
					Report.put("User clicks on the option to clear the 'filter' using 'X'",
							"Data set restores to the original ",
							"User able to see searched view in grid", "Fail");
					Assert.fail();
				}
				else
				{
					System.out.println("not able to see X button");
				}

				Report.put("User clicks on the option to clear the 'filter' using 'X'",
						"Data set restores to the original ",
						"User able to see data refresh and display grid", "PASS");

			}
			else
			{
				System.out.println("not able to see X button");
				Report.put("User clicks on the option to clear the 'filter' using 'X'",
						"Data set restores to the original ",
						"User not able to see X button", "Fail");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("User clicks on the option to clear the 'filter' using 'X'",
					"Data set restores to the original ",
					"User not able to see X button", "Fail");
			Assert.fail();
		}
	}

	public void SortingColumnsInGridOfAddCustomGroupPage(WebDriver driver)
	{

		Log.info("Inside SortingColumnsInGridOfAddCustomGroupPage method");

		String assertid = ""; String assertclass="";
		String Prodname=""; String prodclass="";
		String nickname="";String nickclass="";
		String siteid="";String siteidclass="";
		String sitedetils=""; String sitedetclass="";

		WebDriverWait wait = new WebDriverWait(driver, 600);
		try
		{

			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_UnifiedPortalPage.AssetIdSortingInAddCustomGroup()))
			{	
				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.AssetIdSortingInAddCustomGroup());
				assertid=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.AssetIdSortingInAddCustomGroup()).getText();
				System.out.println("column name is "+assertid);
				CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.AssetIdSortingInAddCustomGroup());

				Thread.sleep(6000);
				assertclass=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.AssetIdSortingInAddCustomGroup()).getAttribute("class");
				System.out.println("class is "+assertclass);

				if(!(assertclass.contains("sorting_desc")|| assertclass.contains("sorting_asc")))
				{
					System.out.println("not able to see asset id sorting");
					Report.put("User verifies sort on the following columns in ascending and descending order ",
							" User should be able to sort on the following columns in ascending and descending order Asset ID,Product Name,Product Nickname,Site ID,Site Details",
							"User not able to see asset id sorting", "Fail");
					Assert.fail();
				}

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.ProductNameSortingInAddCustomGroup());
				Prodname=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.ProductNameSortingInAddCustomGroup()).getText();
				System.out.println("column name is "+Prodname);
				CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.ProductNameSortingInAddCustomGroup());

				Thread.sleep(6000);
				prodclass=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.ProductNameSortingInAddCustomGroup()).getAttribute("class");
				System.out.println("class is "+prodclass);

				if(!(prodclass.contains("sorting_desc")|| prodclass.contains("sorting_asc")))
				{
					System.out.println("not able to see product name sorting");
					Report.put("User verifies sort on the following columns in ascending and descending order ",
							" User should be able to sort on the following columns in ascending and descending order Asset ID,Product Name,Product Nickname,Site ID,Site Details",
							"User not able to see product name sorting", "Fail");
					Assert.fail();
				}

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.ProductNickNameSortingInAddCustomGroup());
				nickname=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.ProductNickNameSortingInAddCustomGroup()).getText();
				System.out.println("column name is "+nickname);
				CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.ProductNickNameSortingInAddCustomGroup());

				Thread.sleep(6000);
				nickclass=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.ProductNickNameSortingInAddCustomGroup()).getAttribute("class");
				System.out.println("class is "+nickclass);

				if(!(nickclass.contains("sorting_desc")|| nickclass.contains("sorting_asc")))
				{
					System.out.println("not able to see product nickname sorting");
					Report.put("User verifies sort on the following columns in ascending and descending order ",
							" User should be able to sort on the following columns in ascending and descending order Asset ID,Product Name,Product Nickname,Site ID,Site Details",
							"User not able to see product nickname sorting", "Fail");
					Assert.fail();
				}

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.SiteIDSortingInAddCustomGroup());
				siteid=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.SiteIDSortingInAddCustomGroup()).getText();
				System.out.println("column name is "+siteid);
				CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.SiteIDSortingInAddCustomGroup());

				Thread.sleep(6000);
				siteidclass=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.SiteIDSortingInAddCustomGroup()).getAttribute("class");
				System.out.println("class is "+siteidclass);

				if(!(siteidclass.contains("sorting_desc")|| siteidclass.contains("sorting_asc")))
				{
					System.out.println("not able to see site id sorting");
					Report.put("User verifies sort on the following columns in ascending and descending order ",
							" User should be able to sort on the following columns in ascending and descending order Asset ID,Product Name,Product Nickname,Site ID,Site Details",
							"User not able to see site id sorting", "Fail");
					Assert.fail();
				}


				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.SiteDetailsSortingInAddCustomGroup());
				sitedetils=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.SiteDetailsSortingInAddCustomGroup()).getText();
				System.out.println("column name is "+sitedetils);
				CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.SiteDetailsSortingInAddCustomGroup());

				Thread.sleep(6000);
				sitedetclass=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.SiteDetailsSortingInAddCustomGroup()).getAttribute("class");
				System.out.println("class is "+sitedetclass);

				if(!(sitedetclass.contains("sorting_desc")|| sitedetclass.contains("sorting_asc")))
				{
					System.out.println("not able to see site details sorting");
					Report.put("User verifies sort on the following columns in ascending and descending order ",
							" User should be able to sort on the following columns in ascending and descending order Asset ID,Product Name,Product Nickname,Site ID,Site Details",
							"User not able to see site details sorting", "Fail");
					Assert.fail();
				}


				Report.put("User verifies sort on the following columns in ascending and descending order ",
						" User should be able to sort on the following columns in ascending and descending order Asset ID,Product Name,Product Nickname,Site ID,Site Details",
						"User able to sort all columns in ascending and descending", "PASS");

			}
			else
			{
				System.out.println("not able to sort column names");
				Report.put("User verifies sort on the following columns in ascending and descending order ",
						" User should be able to sort on the following columns in ascending and descending order Asset ID,Product Name,Product Nickname,Site ID,Site Details",
						"User not able to sort column names", "Fail");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("User verifies sort on the following columns in ascending and descending order ",
					" User should be able to sort on the following columns in ascending and descending order Asset ID,Product Name,Product Nickname,Site ID,Site Details",
					"User not able to sort column names", "Fail");
			Assert.fail();
		}
	}

	public void VerifyPageNumbersDisplayingUnderPaginationSection(WebDriver driver)
	{

		Log.info("VerifyPageNumbersDisplayingUnderPaginationSection");	
		WebDriverWait wait = new WebDriverWait(driver, 120);
		String text="";
		String testcase=TestNGCreator.TestData.get(Esupport.TestCaseID.ordinal());

		try
		{
			if(testcase.contains("8385233"))
			{
				if(CommonUtility.CheckpresenceofElementLocated(driver, 15, obj_UnifiedPortalPage.PageinPaginationInSites()))
				{

					CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.PageinPaginationInSites());
					String pagesdisplayed=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.PageinPaginationInSites()).getText();
					System.out.println(pagesdisplayed);

					CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.PageNoTextPaginationInSites());
					text=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.PageNoTextPaginationInSites()).getText(); 
					System.out.println(text);

					CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.NumberOfPagesInPaginationInSites());
					String noofpages=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.NumberOfPagesInPaginationInSites()).getText(); 
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
			else
			{
				if(CommonUtility.CheckpresenceofElementLocated(driver, 15, obj_UnifiedPortalPage.PaginationInAddCustomerGroup()))
				{

					CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.PageinPagination());
					String pagesdisplayed=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.PageinPagination()).getText();
					System.out.println(pagesdisplayed);

					CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.PageNoTextPagination());
					text=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.PageNoTextPagination()).getText(); 
					System.out.println(text);

					CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.NumberOfPagesInPagination());
					String noofpages=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.NumberOfPagesInPagination()).getText(); 
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
			if(testcase.contains("8385233"))
			{
				if(CommonUtility.CheckpresenceofElementLocated(driver, 15, obj_UnifiedPortalPage.PageNoTextPaginationInSites()))
				{

					CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.PageNoTextPaginationInSites());
					String pagesdisplayed=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.PageNoTextPaginationInSites()).getText();
					System.out.println(pagesdisplayed);

					if(pagesdisplayed.equals("1"))
					{

						CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.FirstPageArrowMarkInAddCustGroupInSites());
						CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.FirstPageArrowMarkInAddCustGroupInSites());

						CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.PreviousPageArrowMarkInAddCustGroupInSites());
						CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.PreviousPageArrowMarkInAddCustGroupInSites());

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
			else
			{

				if(CommonUtility.CheckpresenceofElementLocated(driver, 15, obj_UnifiedPortalPage.PageNoTextPagination()))
				{

					CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.PageNoTextPagination());
					String pagesdisplayed=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.PageNoTextPagination()).getText();
					System.out.println(pagesdisplayed);

					if(pagesdisplayed.equals("1"))
					{

						CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.FirstPageArrowMarkInAddCustGroup());
						CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.FirstPageArrowMarkInAddCustGroup());

						CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.PreviousPageArrowMarkInAddCustGroup());
						CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.PreviousPageArrowMarkInAddCustGroup());

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
			if(testcase.contains("8385233"))
			{
				if(CommonUtility.CheckpresenceofElementLocated(driver, 15, obj_UnifiedPortalPage.LastPageArrowMarkInAddCustGroupInSites()))
				{

					CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.LastPageArrowMarkInAddCustGroupInSites());
					CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.LastPageArrowMarkInAddCustGroupInSites());

					wait.until(ExpectedConditions.visibilityOfElementLocated(obj_UnifiedPortalPage.PageNoTextPaginationInSites()));
					String pagesdisplayed=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.PageNoTextPaginationInSites()).getText();
					System.out.println(pagesdisplayed);

					if(!(pagesdisplayed.equals("1")))
					{

						CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.NextPageArrowMarkInAddCustGroupInSites());
						CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.NextPageArrowMarkInAddCustGroupInSites());

						CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.LastPageArrowMarkInAddCustGroupInSites());
						CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.LastPageArrowMarkInAddCustGroupInSites());

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
			else
			{
				if(CommonUtility.CheckpresenceofElementLocated(driver, 15, obj_UnifiedPortalPage.LastPageArrowMarkInAddCustGroup()))
				{

					CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.LastPageArrowMarkInAddCustGroup());
					CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.LastPageArrowMarkInAddCustGroup());

					wait.until(ExpectedConditions.visibilityOfElementLocated(obj_UnifiedPortalPage.PageNoTextPagination()));
					String pagesdisplayed=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.PageNoTextPagination()).getText();
					System.out.println(pagesdisplayed);

					if(!(pagesdisplayed.equals("1")))
					{

						CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.NextPageArrowMarkInAddCustGroup());
						CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.NextPageArrowMarkInAddCustGroup());

						CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.LastPageArrowMarkInAddCustGroup());
						CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.LastPageArrowMarkInAddCustGroup());

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

	public void clickOnCreateCustomGroupButtonAndVerifyGroupCreationInGrid(WebDriver driver)
	{
		System.out.println("Inside clickOnCreateCustomGroupButtonAndVerifyGroupCreationInGrid method");

		String header = "";
		String customgroupname="";

		String name=TestNGCreator.TestData.get(Esupport.FirstName.ordinal());
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);			
			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_UnifiedPortalPage.CreateCustomGroupButtonEnable()))
			{
				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.CreateCustomGroupButtonEnable());

				CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.CreateCustomGroupButtonEnable());	

				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_UnifiedPortalPage.MyCustomeGroupsHeading()));
				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.MyCustomeGroupsHeading());

				header = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.MyCustomeGroupsHeading()).getText();

				System.out.println("Header is: "+header);

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.FirstDisplayedCustomeGroup());

				customgroupname = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.FirstDisplayedCustomeGroup()).getText();

				System.out.println("name of custom group is: "+customgroupname);

				if(customgroupname.contains(name))
				{
					System.out.println("custom group name matching with entered");
					CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.DeleteFirstDisplayed());
					CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.DeleteFirstDisplayed());
					wait.until(ExpectedConditions.visibilityOfElementLocated(obj_UnifiedPortalPage.DeleteOptionInDeletePopUp()));
					CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.DeleteOptionInDeletePopUp());
					CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.DeleteOptionInDeletePopUp());

				}

				else
				{
					CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.DeleteFirstDisplayed());
					CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.DeleteFirstDisplayed());
					wait.until(ExpectedConditions.visibilityOfElementLocated(obj_UnifiedPortalPage.DeleteOptionInDeletePopUp()));
					CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.DeleteOptionInDeletePopUp());
					CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.DeleteOptionInDeletePopUp());
					System.out.println("custom group name not matching with entered");
					Report.put("If User clicks on Create Custom Group button",
							"This action should complete the creation of a Custom group and redirect the user to the list of custom groups page",
							"Failed to Create Custom group & redirect to homepage", "FAIL");
					Assert.fail();
				}
				Report.put("If User clicks on Create Custom Group button",
						"This action should complete the creation of a Custom group and redirect the user to the list of custom groups page",
						"Created Custom group & redirected to page"+Report.color(header)+" with created custom group in the grid "+Report.color(customgroupname), "PASS");
			}
			else
			{
				System.out.println("create custom group button not matching with entered");
				Report.put("If User clicks on Create Custom Group button",
						"This action should complete the creation of a Custom group and redirect the user to the list of custom groups page",
						"Failed to Create Custom group & redirect to homepage", "FAIL");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("If User clicks on Create Custom Group button",
					"This action should complete the creation of a Custom group and redirect the user to the list of custom groups page",
					"Failed to Create Custom group & redirect to homepage", "FAIL");
			Assert.fail();
		}
	}

	
	public void clickOnSaveChangesButton_Edit(WebDriver driver)
	{
		System.out.println("Inside clickOnSaveChangesButton_Edit method");

		String header = "";
		String customgroupname="";

		String name=TestNGCreator.TestData.get(Esupport.FirstName.ordinal());
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);			
			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_UnifiedPortalPage.SaveChanges()))
			{
				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.SaveChanges());

				CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.SaveChanges());	

				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_UnifiedPortalPage.MyCustomeGroupsHeading()));
				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.MyCustomeGroupsHeading());

				header = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.MyCustomeGroupsHeading()).getText();

				System.out.println("Header is: "+header);

				
				
				Report.put("If User clicks on Create Custom Group button",
						"This action should complete the creation of a Custom group and redirect the user to the list of custom groups page",
						"Created Custom group & redirected to page"+Report.color(header), "PASS");
			}
			else
			{
				System.out.println("create custom group button not matching with entered");
				Report.put("If User clicks on Create Custom Group button",
						"This action should complete the creation of a Custom group and redirect the user to the list of custom groups page",
						"Failed to Create Custom group & redirect to homepage", "FAIL");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("If User clicks on Create Custom Group button",
					"This action should complete the creation of a Custom group and redirect the user to the list of custom groups page",
					"Failed to Create Custom group & redirect to homepage", "FAIL");
			Assert.fail();
		}
	}
	public void ClickCancelButtonAndValidatePopUp(WebDriver driver)
	{
		System.out.println("Inside ClickCancelButtonAndValidatePopUp method");

		String message = "";
		String cancelButton = "";
		String header = "";
		String button1="";
		String button2="";

		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);	
			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_UnifiedPortalPage.CancelButton()))
			{
				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.CancelButton());
				cancelButton = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.CancelButton()).getText();
				System.out.println("button is "+cancelButton);
				CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.CancelButton());

				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_UnifiedPortalPage.DiscardChangesHeading()));;
				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.DiscardChangesHeading());
				header = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.DiscardChangesHeading()).getText();
				System.out.println("header is "+header);

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.AlertMessageInCancelPopUp());
				message = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.AlertMessageInCancelPopUp()).getText();
				System.out.println("message is "+message);


				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.NoButtonInCancelPopUp());
				button1 = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.NoButtonInCancelPopUp()).getText();
				System.out.println("button is "+button1);

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.YesDiscardButtonInCancelPopUp());
				button2 = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.YesDiscardButtonInCancelPopUp()).getText();
				System.out.println("button is "+button2);

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.XButoonInCancelPopUp());

				Report.put("If User clicks on Cancel Button ",
						"User should see the the Displays a modal window with a message-'Your Custom Group hasn't been saved.If you navigate away,it will be deleted' with No and Yes,Discard options .No will direct the user back to the create page Yes,Discard will cancel the create operation and redirect the user to the list of custom groups page",
						"User able to click on "+Report.color(cancelButton)+" button and able to see pop up displayed with header "+Report.color(header)+" with alert message "+Report.color(message)+" with buttons "+Report.color(button1+" and "+button2), "PASS");
			}
			else
			{
				System.out.println("cancel button not displayed");
				Report.put("If User clicks on Cancel Button ",
						"User should see the the Displays a modal window with a message-'Your Custom Group hasn't been saved.If you navigate away,it will be deleted' with No and Yes,Discard options .No will direct the user back to the create page Yes,Discard will cancel the create operation and redirect the user to the list of custom groups page",
						"Failed to see Cancel button", "FAIL");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();

			Report.put("If User clicks on Cancel Button ",
					"User should see the the Displays a modal window with a message-'Your Custom Group hasn't been saved.If you navigate away,it will be deleted' with No and Yes,Discard options .No will direct the user back to the create page Yes,Discard will cancel the create operation and redirect the user to the list of custom groups page",
					"Failed to see Cancel button", "FAIL");
			Assert.fail();
		}
	}

	public void clickOnYes(WebDriver driver)
	{
		System.out.println("Inside clickOnYes method");

		String confirmButton = "";
		String cancelButton = "";
		String header = "";
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 330);

			if(CommonUtility.CheckpresenceofElementLocated(driver,15, obj_UnifiedPortalPage.YesDiscardButtonInCancelPopUp()))
			{
				CommonUtility.ScrollTo(driver, obj_UnifiedPortalPage.YesDiscardButtonInCancelPopUp());
				CommonUtility.ClickOn(driver, obj_UnifiedPortalPage.YesDiscardButtonInCancelPopUp());
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_UnifiedPortalPage.MyCustomeGroupsHeading()));
				header = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.MyCustomeGroupsHeading()).getText();
				System.out.println(header);

				Report.put("If User clicks on Cancel Button ",
						"User should see the the Displays a modal window with a message-'Your Custom Group hasn't been saved.If you navigate away,it will be deleted' with No and Yes,Discard options .No will direct the user back to the create page Yes,Discard will cancel the create operation and redirect the user to the list of custom groups page",
						"Redirected to the page"+Report.color(header), "PASS");
			}
			else
			{
				System.out.println("failed to see yes button");
				Report.put("If User clicks on Cancel Button ",
						"User should see the the Displays a modal window with a message-'Your Custom Group hasn't been saved.If you navigate away,it will be deleted' with No and Yes,Discard options .No will direct the user back to the create page Yes,Discard will cancel the create operation and redirect the user to the list of custom groups page",
						"Failed to see yes button", "FAIL");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();

			Report.put("If User clicks on Cancel Button ",
					"User should see the the Displays a modal window with a message-'Your Custom Group hasn't been saved.If you navigate away,it will be deleted' with No and Yes,Discard options .No will direct the user back to the create page Yes,Discard will cancel the create operation and redirect the user to the list of custom groups page",
					"Failed to see yes button", "FAIL");
			Assert.fail();
		}
	}

	public void clickOnNo(WebDriver driver)
	{
		System.out.println("Inside clickOnNo method");

		String confirmButton = "";
		String cancelButton = "";
		String header = "";
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);	

			if(CommonUtility.CheckpresenceofElementLocated(driver,15, obj_UnifiedPortalPage.NoButtonInCancelPopUp()))
			{
				CommonUtility.ScrollTo(driver, obj_UnifiedPortalPage.NoButtonInCancelPopUp());
				CommonUtility.ClickOn(driver, obj_UnifiedPortalPage.NoButtonInCancelPopUp());
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_UnifiedPortalPage.CreateACustomGroupHeader()));
				header = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.CreateACustomGroupHeader()).getText();
				System.out.println(header);

				Report.put("If User clicks on Cancel Button ",
						"User should see the the Displays a modal window with a message-'Your Custom Group hasn't been saved.If you navigate away,it will be deleted' with No and Yes,Discard options .No will direct the user back to the create page Yes,Discard will cancel the create operation and redirect the user to the list of custom groups page",
						"user stays in the same page"+Report.color(header), "PASS");
			}
			else
			{
				System.out.println("failed to see no button");
				Report.put("If User clicks on Cancel Button ",
						"User should see the the Displays a modal window with a message-'Your Custom Group hasn't been saved.If you navigate away,it will be deleted' with No and Yes,Discard options .No will direct the user back to the create page Yes,Discard will cancel the create operation and redirect the user to the list of custom groups page",
						"Failed to see no button", "FAIL");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();

			Report.put("If User clicks on Cancel Button ",
					"User should see the the Displays a modal window with a message-'Your Custom Group hasn't been saved.If you navigate away,it will be deleted' with No and Yes,Discard options .No will direct the user back to the create page Yes,Discard will cancel the create operation and redirect the user to the list of custom groups page",
					"Failed to see no button", "FAIL");
			Assert.fail();
		}
	}

	public void selectSearchBySites(WebDriver driver)
	{

		Log.info("Inside selectSearchBySites method");

		String button = "";
		String header="";
		String header1="";
		String columnam="";
		String rownam="";

		WebDriverWait wait = new WebDriverWait(driver, 240);
		try
		{

			if(CommonUtility.CheckpresenceofElementLocated(driver,33,obj_UnifiedPortalPage.SearchBySropDownValues()))
			{

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.CustomGroupNameTextBox());	
				CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.CustomGroupNameTextBox()).clear();
				CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.CustomGroupNameTextBox()).sendKeys(TestNGCreator.TestData.get(Esupport.FirstName.ordinal()));
				//				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.SelectProductDropDown());
				//				CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.SelectProductDropDown());
				//				Thread.sleep(6000);
				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.SelectProductDropDown());
				Select selOption = new  Select(driver.findElement(obj_UnifiedPortalPage.SelectProductDropDown()));
				List<WebElement> list1=selOption.getOptions();


				for(WebElement lt:list1)
				{
					CommonUtility.highlightElement(driver, lt);
					String dropdown=lt.getText();

				}

				selOption.selectByValue("SearchBySites");

				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_UnifiedPortalPage.TableOfSites()));
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_UnifiedPortalPage.SitesListInTable()));
				List<WebElement> list=driver.findElements(obj_UnifiedPortalPage.SitesListInTable());

				int count=list.size();
				System.out.println("total number of sites displayed in table is "+count);
				for(WebElement lt:list)
				{
					CommonUtility.highlightElement(driver, lt);
					String label=lt.getText();

					System.out.println("site is: " +label);
					columnam+=" <br> " + label;
				}
				System.out.println("sites are :"+columnam);


				Report.put("User Selects Search by drop down with 'Search by Site' option ",
						"The list box should load that has the list of sites accessible to the logged in Customer user.",
						"User able to select search in sites option and able to see table displayed sites "+Report.color(columnam), "PASS");

			}
			else
			{
				System.out.println("not able to see search dropdown");
				Report.put("User Selects Search by drop down with 'Search by Site' option ",
						"The list box should load that has the list of sites accessible to the logged in Customer user.",
						"User not able to see search dropdown", "Fail");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("User Selects Search by drop down with 'Search by Site' option ",
					"The list box should load that has the list of sites accessible to the logged in Customer user.",
					"User not able to see search dropdown", "Fail");
			Assert.fail();
		}
	}

	public void selectSearchBySites_InEditPageOfProducts(WebDriver driver)
	{

		Log.info("Inside selectSearchBySites_InEditPageOfProducts method");

		String button = "";
		String header="";
		String header1="";
		String columnam="";
		String rownam="";

		WebDriverWait wait = new WebDriverWait(driver, 240);
		try
		{

			if(CommonUtility.CheckpresenceofElementLocated(driver,33,obj_UnifiedPortalPage.SearchBySropDownValues()))
			{

//				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.CustomGroupNameTextBox());	
//				CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.CustomGroupNameTextBox()).clear();
//				CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.CustomGroupNameTextBox()).sendKeys(TestNGCreator.TestData.get(Esupport.FirstName.ordinal()));
				//				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.SelectProductDropDown());
				//				CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.SelectProductDropDown());
				//				Thread.sleep(6000);
				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.SelectProductDropDown());
				Select selOption = new  Select(driver.findElement(obj_UnifiedPortalPage.SelectProductDropDown()));
				List<WebElement> list1=selOption.getOptions();


				for(WebElement lt:list1)
				{
					CommonUtility.highlightElement(driver, lt);
					String dropdown=lt.getText();

				}

				selOption.selectByValue("SearchBySites");

				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_UnifiedPortalPage.TableOfSites()));
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_UnifiedPortalPage.SitesListInTable()));
				List<WebElement> list=driver.findElements(obj_UnifiedPortalPage.SitesListInTable());

				int count=list.size();
				System.out.println("total number of sites displayed in table is "+count);
				for(WebElement lt:list)
				{
					CommonUtility.highlightElement(driver, lt);
					String label=lt.getText();

					System.out.println("site is: " +label);
					columnam+=" <br> " + label;
				}
				System.out.println("sites are :"+columnam);


				Report.put("User Selects Search by drop down with 'Search by Site' option ",
						"The list box should load that has the list of sites accessible to the logged in Customer user.",
						"User able to select search in sites option and able to see table displayed sites "+Report.color(columnam), "PASS");

			}
			else
			{
				System.out.println("not able to see search dropdown");
				Report.put("User Selects Search by drop down with 'Search by Site' option ",
						"The list box should load that has the list of sites accessible to the logged in Customer user.",
						"User not able to see search dropdown", "Fail");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("User Selects Search by drop down with 'Search by Site' option ",
					"The list box should load that has the list of sites accessible to the logged in Customer user.",
					"User not able to see search dropdown", "Fail");
			Assert.fail();
		}
	}
	public void SelectOneOrMultipleAssetsInSitesGrid(WebDriver driver)
	{

		Log.info("Inside SelectOneOrMultipleAssetsInSitesGrid method");

		String button = "";

		WebDriverWait wait = new WebDriverWait(driver, 600);
		try
		{

			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_UnifiedPortalPage.SitesListInTable()))
			{

				CommonUtility.ScrollTo(driver, obj_UnifiedPortalPage.SitesListInTable());
				List<WebElement> list1=driver.findElements(obj_UnifiedPortalPage.SitesListInTable());

				int count3=list1.size();
				System.out.println("total number of sites displayed in table "+count3);
				int count2=0;
				for(int i=0;i<7;i++)
				{
					count2++;

					if(count2==1)
					{
						if (!(list1.get(i).isSelected())) 
						{
							try
							{
								CommonUtility.ScrollToWebElement(driver, list1.get(i));
								CommonUtility.ClickOnWebElement(driver, list1.get(i));

								Thread.sleep(3000);
							}
							catch(Exception e)
							{

							}
						}
					}


				}
				Thread.sleep(15000);

				if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_UnifiedPortalPage.FiestCheckBox()))
				{

					if(CommonUtility.CheckpresenceofElementLocated(driver,10,obj_UnifiedPortalPage.FiestCheckBox()))
					{
						CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.FiestCheckBox());
						CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.FiestCheckBox());
					}

					if(CommonUtility.CheckpresenceofElementLocated(driver,10,obj_UnifiedPortalPage.SecCheckBox()))
					{
						CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.SecCheckBox());
						CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.SecCheckBox());
					}

					if(CommonUtility.CheckpresenceofElementLocated(driver,10,obj_UnifiedPortalPage.ThirdCheckBox()))
					{
						CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.ThirdCheckBox());
						CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.ThirdCheckBox());
					}

					if(CommonUtility.CheckpresenceofElementLocated(driver,10,obj_UnifiedPortalPage.ForthCheckBox()))
					{
						CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.ForthCheckBox());
						CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.ForthCheckBox());
					}

					if(CommonUtility.CheckpresenceofElementLocated(driver,10,obj_UnifiedPortalPage.FifthCheckBox()))
					{
						CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.FifthCheckBox());
						CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.FifthCheckBox());
					}
					if(CommonUtility.CheckpresenceofElementLocated(driver,10,obj_UnifiedPortalPage.SixCheckBox()))
					{
						CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.SixCheckBox());
						CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.SixCheckBox());
					}


				}
				else
				{
					System.out.println("not able to see asset IDs");
					Report.put("User selects one/multiple/all the assets",
							"'Add to Group' button is enabled; (IB status's  to be considered - Installed;Shipped;Awaiting Customer Install;Install-T&M )",
							"User not able to see asset IDs", "Fail");
					Assert.fail();
				}
				Thread.sleep(6000);
				if(CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.AddToGroupButtonInSitesGrid()).isEnabled())
				{
					CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.AddToGroupButtonInSitesGrid());
					button=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.AddToGroupButtonInSitesGrid()).getText();
					System.out.println("button is "+button);
				}
				else
				{
					System.out.println("not able to see add to group");
					Report.put("User selects one/multiple/all the assets",
							"'Add to Group' button is enabled; (IB status's  to be considered - Installed;Shipped;Awaiting Customer Install;Install-T&M )",
							"User not able to see add to group button", "Fail");
					Assert.fail();
				}



				Report.put("User selects one/multiple/all the assets",
						"'Add to Group' button is enabled; (IB status's  to be considered - Installed;Shipped;Awaiting Customer Install;Install-T&M )",
						"User able to select multiple assets, enabled "+Report.color(button)+" button", "PASS");

			}
			else
			{
				System.out.println("not able to see sites in table");
				Report.put("User selects one/multiple/all the assets",
						"'Add to Group' button is enabled; (IB status's  to be considered - Installed;Shipped;Awaiting Customer Install;Install-T&M )",
						"User not able to see sites in table", "Fail");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("User selects one/multiple/all the assets",
					"'Add to Group' button is enabled; (IB status's  to be considered - Installed;Shipped;Awaiting Customer Install;Install-T&M )",
					"User not able to see sites in table", "Fail");
			Assert.fail();
		}
	}

	public void SelectOneOrMultipleAssetsInSitesGrid_Edit(WebDriver driver)
	{

		Log.info("Inside SelectOneOrMultipleAssetsInSitesGrid_Edit method");

		String button = "";

		WebDriverWait wait = new WebDriverWait(driver, 600);
		try
		{

			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_UnifiedPortalPage.SitesListInTable()))
			{

				CommonUtility.ScrollTo(driver, obj_UnifiedPortalPage.SitesListInTable());
				List<WebElement> list1=driver.findElements(obj_UnifiedPortalPage.SitesListInTable());

				int count3=list1.size();
				System.out.println("total number of sites displayed in table "+count3);
				int count2=0;
				for(int i=0;i<7;i++)
				{
					count2++;

					if(count2==1)
					{
						if (!(list1.get(i).isSelected())) 
						{
							try
							{
								CommonUtility.ScrollToWebElement(driver, list1.get(i));
								CommonUtility.ClickOnWebElement(driver, list1.get(i));

								Thread.sleep(3000);
							}
							catch(Exception e)
							{

							}
						}
					}


				}
				Thread.sleep(15000);

				if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_UnifiedPortalPage.FiestCheckBox()))
				{

					if(CommonUtility.CheckpresenceofElementLocated(driver,10,obj_UnifiedPortalPage.FiestCheckBox()))
					{
						CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.FiestCheckBox());
						CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.FiestCheckBox());
					}

					if(CommonUtility.CheckpresenceofElementLocated(driver,10,obj_UnifiedPortalPage.SecCheckBox()))
					{
						CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.SecCheckBox());
						CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.SecCheckBox());
					}

//					if(CommonUtility.CheckpresenceofElementLocated(driver,10,obj_UnifiedPortalPage.ThirdCheckBox()))
//					{
//						CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.ThirdCheckBox());
//						CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.ThirdCheckBox());
//					}
//
//					if(CommonUtility.CheckpresenceofElementLocated(driver,10,obj_UnifiedPortalPage.ForthCheckBox()))
//					{
//						CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.ForthCheckBox());
//						CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.ForthCheckBox());
//					}
//
//					if(CommonUtility.CheckpresenceofElementLocated(driver,10,obj_UnifiedPortalPage.FifthCheckBox()))
//					{
//						CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.FifthCheckBox());
//						CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.FifthCheckBox());
//					}
//					if(CommonUtility.CheckpresenceofElementLocated(driver,10,obj_UnifiedPortalPage.SixCheckBox()))
//					{
//						CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.SixCheckBox());
//						CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.SixCheckBox());
//					}


				}
				else
				{
					System.out.println("not able to see asset IDs");
					Report.put("User selects one/multiple/all the assets",
							"'Add to Group' button is enabled; (IB status's  to be considered - Installed;Shipped;Awaiting Customer Install;Install-T&M )",
							"User not able to see asset IDs", "Fail");
					Assert.fail();
				}
				Thread.sleep(6000);
				if(CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.AddToGroupButtonInSitesGrid()).isEnabled())
				{
					CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.AddToGroupButtonInSitesGrid());
					button=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.AddToGroupButtonInSitesGrid()).getText();
					System.out.println("button is "+button);
				}
				else
				{
					System.out.println("not able to see add to group");
					Report.put("User selects one/multiple/all the assets",
							"'Add to Group' button is enabled; (IB status's  to be considered - Installed;Shipped;Awaiting Customer Install;Install-T&M )",
							"User not able to see add to group button", "Fail");
					Assert.fail();
				}



				Report.put("User selects one/multiple/all the assets",
						"'Add to Group' button is enabled; (IB status's  to be considered - Installed;Shipped;Awaiting Customer Install;Install-T&M )",
						"User able to select multiple assets, enabled "+Report.color(button)+" button", "PASS");

			}
			else
			{
				System.out.println("not able to see sites in table");
				Report.put("User selects one/multiple/all the assets",
						"'Add to Group' button is enabled; (IB status's  to be considered - Installed;Shipped;Awaiting Customer Install;Install-T&M )",
						"User not able to see sites in table", "Fail");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("User selects one/multiple/all the assets",
					"'Add to Group' button is enabled; (IB status's  to be considered - Installed;Shipped;Awaiting Customer Install;Install-T&M )",
					"User not able to see sites in table", "Fail");
			Assert.fail();
		}
	}
	public void SelectOneOrMultipleAssetsInSitesGrid_IE(WebDriver driver)
	{

		Log.info("Inside SelectOneOrMultipleAssetsInSitesGrid_IE method");

		String button = "";

		WebDriverWait wait = new WebDriverWait(driver, 600);
		try
		{

			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_UnifiedPortalPage.SitesListInTable()))
			{


				List<WebElement> list1=driver.findElements(obj_UnifiedPortalPage.SitesListInTable());

				int count3=list1.size();
				System.out.println("total number of sites displayed in table "+count3);
				int count2=0;
				for(int i=0;i<7;i++)
				{
					count2++;

					if(count2==1)
					{
						if (!(list1.get(i).isSelected())) 
						{
							try
							{
								CommonUtility.ScrollToWebElement(driver, list1.get(i));
								CommonUtility.ClickOnWebElement(driver, list1.get(i));

								Thread.sleep(3000);
							}
							catch(Exception e)
							{

							}
						}
					}


				}
				Thread.sleep(15000);
				if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_UnifiedPortalPage.FiestCheckBoxForIE()))
				{

					if(CommonUtility.CheckpresenceofElementLocated(driver,10,obj_UnifiedPortalPage.FiestCheckBoxForIE()))
					{
						CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.FiestCheckBoxForIE());
						CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.FiestCheckBoxForIE());
					}

					if(CommonUtility.CheckpresenceofElementLocated(driver,10,obj_UnifiedPortalPage.SecCheckBoxForIE()))
					{
						CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.SecCheckBoxForIE());
						CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.SecCheckBoxForIE());
					}

					if(CommonUtility.CheckpresenceofElementLocated(driver,10,obj_UnifiedPortalPage.ThirdCheckBoxForIE()))
					{
						CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.ThirdCheckBoxForIE());
						CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.ThirdCheckBoxForIE());
					}

					if(CommonUtility.CheckpresenceofElementLocated(driver,10,obj_UnifiedPortalPage.ForthCheckBoxForIE()))
					{
						CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.ForthCheckBoxForIE());
						CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.ForthCheckBoxForIE());
					}

					if(CommonUtility.CheckpresenceofElementLocated(driver,10,obj_UnifiedPortalPage.FifthCheckBoxForIE()))
					{
						CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.FifthCheckBoxForIE());
						CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.FifthCheckBoxForIE());
					}
					if(CommonUtility.CheckpresenceofElementLocated(driver,10,obj_UnifiedPortalPage.SixCheckBoxForIE()))
					{
						CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.SixCheckBoxForIE());
						CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.SixCheckBoxForIE());
					}


				}
				else
				{
					System.out.println("not able to see asset IDs");
					Report.put("User selects one/multiple/all the assets",
							"'Add to Group' button is enabled; (IB status's  to be considered - Installed;Shipped;Awaiting Customer Install;Install-T&M )",
							"User not able to see asset IDs", "Fail");
					Assert.fail();
				}
				if(CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.AddToGroupButtonInSitesGrid()).isEnabled())
				{
					CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.AddToGroupButtonInSitesGrid());
					button=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.AddToGroupButtonInSitesGrid()).getText();
					System.out.println("button is "+button);
				}
				else
				{
					System.out.println("not able to see add to group");
					Report.put("User selects one/multiple/all the assets",
							"'Add to Group' button is enabled; (IB status's  to be considered - Installed;Shipped;Awaiting Customer Install;Install-T&M )",
							"User not able to see add to group button", "Fail");
					Assert.fail();
				}



				Report.put("User selects one/multiple/all the assets",
						"'Add to Group' button is enabled; (IB status's  to be considered - Installed;Shipped;Awaiting Customer Install;Install-T&M )",
						"User able to select multiple assets, enabled "+Report.color(button)+" button", "PASS");

			}
			else
			{
				System.out.println("not able to see sites in table");
				Report.put("User selects one/multiple/all the assets",
						"'Add to Group' button is enabled; (IB status's  to be considered - Installed;Shipped;Awaiting Customer Install;Install-T&M )",
						"User not able to see sites in table", "Fail");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("User selects one/multiple/all the assets",
					"'Add to Group' button is enabled; (IB status's  to be considered - Installed;Shipped;Awaiting Customer Install;Install-T&M )",
					"User not able to see sites in table", "Fail");
			Assert.fail();
		}
	}

	public void SelectOneOrMultipleAssetsInSitesGrid_IE_Edit(WebDriver driver)
	{

		Log.info("Inside SelectOneOrMultipleAssetsInSitesGrid_IE_Edit method");

		String button = "";

		WebDriverWait wait = new WebDriverWait(driver, 600);
		try
		{

			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_UnifiedPortalPage.SitesListInTable()))
			{


				List<WebElement> list1=driver.findElements(obj_UnifiedPortalPage.SitesListInTable());

				int count3=list1.size();
				System.out.println("total number of sites displayed in table "+count3);
				int count2=0;
				for(int i=0;i<7;i++)
				{
					count2++;

					if(count2==1)
					{
						if (!(list1.get(i).isSelected())) 
						{
							try
							{
								CommonUtility.ScrollToWebElement(driver, list1.get(i));
								CommonUtility.ClickOnWebElement(driver, list1.get(i));

								Thread.sleep(3000);
							}
							catch(Exception e)
							{

							}
						}
					}


				}
				Thread.sleep(15000);
				if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_UnifiedPortalPage.FiestCheckBoxForIE()))
				{

//					if(CommonUtility.CheckpresenceofElementLocated(driver,10,obj_UnifiedPortalPage.FiestCheckBoxForIE()))
//					{
//						CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.FiestCheckBoxForIE());
//						CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.FiestCheckBoxForIE());
//					}

//					if(CommonUtility.CheckpresenceofElementLocated(driver,10,obj_UnifiedPortalPage.SecCheckBoxForIE()))
//					{
//						CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.SecCheckBoxForIE());
//						CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.SecCheckBoxForIE());
//					}

					if(CommonUtility.CheckpresenceofElementLocated(driver,10,obj_UnifiedPortalPage.ThirdCheckBoxForIE()))
					{
						CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.ThirdCheckBoxForIE());
						CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.ThirdCheckBoxForIE());
					}

//					if(CommonUtility.CheckpresenceofElementLocated(driver,10,obj_UnifiedPortalPage.ForthCheckBoxForIE()))
//					{
//						CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.ForthCheckBoxForIE());
//						CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.ForthCheckBoxForIE());
//					}
//
//					if(CommonUtility.CheckpresenceofElementLocated(driver,10,obj_UnifiedPortalPage.FifthCheckBoxForIE()))
//					{
//						CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.FifthCheckBoxForIE());
//						CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.FifthCheckBoxForIE());
//					}
//					if(CommonUtility.CheckpresenceofElementLocated(driver,10,obj_UnifiedPortalPage.SixCheckBoxForIE()))
//					{
//						CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.SixCheckBoxForIE());
//						CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.SixCheckBoxForIE());
//					}


				}
				else
				{
					System.out.println("not able to see asset IDs");
					Report.put("User selects one/multiple/all the assets",
							"'Add to Group' button is enabled; (IB status's  to be considered - Installed;Shipped;Awaiting Customer Install;Install-T&M )",
							"User not able to see asset IDs", "Fail");
					Assert.fail();
				}
				if(CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.AddToGroupButtonInSitesGrid()).isEnabled())
				{
					CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.AddToGroupButtonInSitesGrid());
					button=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.AddToGroupButtonInSitesGrid()).getText();
					System.out.println("button is "+button);
				}
				else
				{
					System.out.println("not able to see add to group");
					Report.put("User selects one/multiple/all the assets",
							"'Add to Group' button is enabled; (IB status's  to be considered - Installed;Shipped;Awaiting Customer Install;Install-T&M )",
							"User not able to see add to group button", "Fail");
					Assert.fail();
				}



				Report.put("User selects one/multiple/all the assets",
						"'Add to Group' button is enabled; (IB status's  to be considered - Installed;Shipped;Awaiting Customer Install;Install-T&M )",
						"User able to select multiple assets, enabled "+Report.color(button)+" button", "PASS");

			}
			else
			{
				System.out.println("not able to see sites in table");
				Report.put("User selects one/multiple/all the assets",
						"'Add to Group' button is enabled; (IB status's  to be considered - Installed;Shipped;Awaiting Customer Install;Install-T&M )",
						"User not able to see sites in table", "Fail");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("User selects one/multiple/all the assets",
					"'Add to Group' button is enabled; (IB status's  to be considered - Installed;Shipped;Awaiting Customer Install;Install-T&M )",
					"User not able to see sites in table", "Fail");
			Assert.fail();
		}
	}
	public void ClickOnAddToGroupButtonInSitesGrid(WebDriver driver)
	{

		Log.info("Inside ClickOnAddToGroupButtonInSitesGrid method");

		String button = "";
		String button1 = "";
		String button2="";
		String cancel="";
		//		String testcase=TestNGCreator.TestData.get(Esupport.TestCaseID.ordinal());
		WebDriverWait wait = new WebDriverWait(driver, 240);
		try
		{

			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_UnifiedPortalPage.AddToGroupButtonInSitesGrid()))
			{

				if(CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.AddToGroupButtonInSitesGrid()).isEnabled())
				{
					CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.AddToGroupButtonInSitesGrid());
					button=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.AddToGroupButtonInSitesGrid()).getText();
					System.out.println("button is "+button);

					CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.AddToGroupButtonInSitesGrid());

					wait.until(ExpectedConditions.visibilityOfElementLocated(obj_UnifiedPortalPage.CreateCustomGroupButtonEnable()));
					CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.CreateCustomGroupButtonEnable());
					button1=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.CreateCustomGroupButtonEnable()).getText();
					System.out.println("button is "+button1);

					CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.CancelButton());
					cancel=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.CancelButton()).getText();
					System.out.println("button is "+cancel);

					CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.ShowSelectedProductsTab());
					button2=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.ShowSelectedProductsTab()).getText();
					System.out.println("button is "+button2);



					Report.put("User adds the products  using 'Add to Group' in a Custom Group created using 'Products'",
							"Clicking on 'Add to Group' should flash the bottom section in blue for n seconds and create custom group button should be enabled and Show selected products tab should be enabled",
							"User able to click on "+Report.color(button)+" button and able to see "+Report.color(button1)+ " button enabled and able to see "+Report.color(button2)+ " tab displayed", "PASS");

				}
				else
				{
					System.out.println("not able to see add to group button enabled");
					Report.put("User adds the products  using 'Add to Group' in a Custom Group created using 'Products'",
							"Clicking on 'Add to Group' should flash the bottom section in blue for n seconds and create custom group button should be enabled and Show selected products tab should be enabled",
							"User not able to see check box", "Fail");
					Assert.fail();
				}


			}
			else
			{
				System.out.println("not able to see add to group button");
				Report.put("User adds the products  using 'Add to Group' in a Custom Group created using 'Products'",
						"Clicking on 'Add to Group' should flash the bottom section in blue for n seconds and create custom group button should be enabled and Show selected products tab should be enabled",
						"User not able to see add to group button", "Fail");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("User adds the products  using 'Add to Group' in a Custom Group created using 'Products'",
					"Clicking on 'Add to Group' should flash the bottom section in blue for n seconds and create custom group button should be enabled and Show selected products tab should be enabled",
					"User not able to see add to group button", "Fail");
			Assert.fail();
		}

	}

	public void ClickOnAddToGroupButtonInSitesGrid_Edit(WebDriver driver)
	{

		Log.info("Inside ClickOnAddToGroupButtonInSitesGrid_Edit method");

		String button = "";
		String button1 = "";
		String button2="";
		String cancel="";
		//		String testcase=TestNGCreator.TestData.get(Esupport.TestCaseID.ordinal());
		WebDriverWait wait = new WebDriverWait(driver, 240);
		try
		{

			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_UnifiedPortalPage.AddToGroupButtonInSitesGrid()))
			{

				if(CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.AddToGroupButtonInSitesGrid()).isEnabled())
				{
					CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.AddToGroupButtonInSitesGrid());
					button=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.AddToGroupButtonInSitesGrid()).getText();
					System.out.println("button is "+button);

					CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.AddToGroupButtonInSitesGrid());

					wait.until(ExpectedConditions.visibilityOfElementLocated(obj_UnifiedPortalPage.SaveChanges()));
					CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.SaveChanges());
					button1=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.SaveChanges()).getText();
					System.out.println("button is "+button1);

					CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.CancelButton());
					cancel=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.CancelButton()).getText();
					System.out.println("button is "+cancel);

					CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.ShowSelectedProductsTab());
					button2=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.ShowSelectedProductsTab()).getText();
					System.out.println("button is "+button2);



					Report.put("User adds the products  using 'Add to Group' in a Custom Group created using 'Products'",
							"Clicking on 'Add to Group' should flash the bottom section in blue for n seconds and create custom group button should be enabled and Show selected products tab should be enabled",
							"User able to click on "+Report.color(button)+" button and able to see "+Report.color(button1)+ " button enabled and able to see "+Report.color(button2)+ " tab displayed", "PASS");

				}
				else
				{
					System.out.println("not able to see add to group button enabled");
					Report.put("User adds the products  using 'Add to Group' in a Custom Group created using 'Products'",
							"Clicking on 'Add to Group' should flash the bottom section in blue for n seconds and create custom group button should be enabled and Show selected products tab should be enabled",
							"User not able to see check box", "Fail");
					Assert.fail();
				}


			}
			else
			{
				System.out.println("not able to see add to group button");
				Report.put("User adds the products  using 'Add to Group' in a Custom Group created using 'Products'",
						"Clicking on 'Add to Group' should flash the bottom section in blue for n seconds and create custom group button should be enabled and Show selected products tab should be enabled",
						"User not able to see add to group button", "Fail");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("User adds the products  using 'Add to Group' in a Custom Group created using 'Products'",
					"Clicking on 'Add to Group' should flash the bottom section in blue for n seconds and create custom group button should be enabled and Show selected products tab should be enabled",
					"User not able to see add to group button", "Fail");
			Assert.fail();
		}

	}
	public void verifyRightHandSideDetails(WebDriver driver)
	{

		Log.info("Inside verifyRightHandSideDetails method");

		String siteidheader = "";String SiteVisibilityHeader = "";String NameHeader = "";String AddressHeader = "";
		String NameOFSite = "";String SiteIDDetails = "";String SiteVisibilityDetails = "";String AddressDetails = "";
		WebDriverWait wait = new WebDriverWait(driver, 600);
		try
		{

			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_UnifiedPortalPage.NameHeader()))
			{
				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.NameHeader());
				NameHeader=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.NameHeader()).getText();
				System.out.println(NameHeader);

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.SiteIDHeader());
				siteidheader=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.SiteIDHeader()).getText();
				System.out.println(siteidheader);

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.SiteVisibilityHeader());
				SiteVisibilityHeader=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.SiteVisibilityHeader()).getText();
				System.out.println(SiteVisibilityHeader);


				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.AddressHeader());
				AddressHeader=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.AddressHeader()).getText();
				System.out.println(AddressHeader);

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.NameOFSite());
				NameOFSite=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.NameOFSite()).getText();
				System.out.println(NameOFSite);

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.SiteIDDetails());
				SiteIDDetails=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.SiteIDDetails()).getText();
				System.out.println(SiteIDDetails);

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.SiteVisibilityDetails());
				SiteVisibilityDetails=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.SiteVisibilityDetails()).getText();
				System.out.println(SiteVisibilityDetails);

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.AddressDetails());
				AddressDetails=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.AddressDetails()).getText();
				System.out.println(AddressDetails);


				Report.put("User Clicks anywhere on the site in the left pod (other than the check box)",
						"The site details will be revealed in the grid on the right hand side Site details like Name ,ID ,Address and security should be displayed",
						"User able to see details "+Report.color(NameHeader+" : "+NameOFSite)+" , "+Report.color(siteidheader+" : "+SiteIDDetails)+" , "
								+Report.color(SiteVisibilityHeader+" : "+SiteVisibilityDetails)+" , "+Report.color(AddressHeader+" : "+AddressDetails), "PASS");

			}
			else
			{
				System.out.println("not able to see expected details");
				Report.put("User Clicks anywhere on the site in the left pod (other than the check box)",
						"The site details will be revealed in the grid on the right hand side Site details like Name ,ID ,Address and security should be displayed",
						"User not able to see expected details", "Fail");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("User Clicks anywhere on the site in the left pod (other than the check box)",
					"The site details will be revealed in the grid on the right hand side Site details like Name ,ID ,Address and security should be displayed",
					"User not able to see expected details", "Fail");
			Assert.fail();
		}
	}

	public void validateFilterSiteForSites(WebDriver driver, String search)
	{

		Log.info("Inside validateFilterSiteForSites method");

		String button = "";
		String message="";
		WebDriverWait wait = new WebDriverWait(driver, 600);
		try
		{

			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_UnifiedPortalPage.FilterSitesHeader()))
			{
				CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.CountrySelector());
				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.FilterSitesHeader());
				CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.SearchTextBox()).clear();
				CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.SearchTextBox()).sendKeys(search);

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.SearchButton());
				CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.SearchButton());

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.InstructionText());
				message=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.InstructionText()).getText();
				System.out.println(message);

				Thread.sleep(10000);
				//				CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.CountrySelector());
				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.SitesListInTable());
				CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.SitesListInTable());




				Report.put("User navigates to the Filter sites section",
						"User should be able to view Filter Sites box with watermark text to enter a site name ,Site ID ,location Note : ->This option lets User search against the entire site base accessible to the user and displays results in the list box on the left side. ->The count below the list box updates accordingly ->The search results should be retrieved based on users access",
						"User able to search using filter sites with label message "+Report.color(message)+" and able to see searched option highlighted ", "PASS");

			}
			else
			{
				System.out.println("not able to see filter sites text box");
				Report.put("User navigates to the Filter sites section",
						"User should be able to view Filter Sites box with watermark text to enter a site name ,Site ID ,location Note : ->This option lets User search against the entire site base accessible to the user and displays results in the list box on the left side. ->The count below the list box updates accordingly ->The search results should be retrieved based on users access",
						"User not able to see filter sites text box", "Fail");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("User navigates to the Filter sites section",
					"User should be able to view Filter Sites box with watermark text to enter a site name ,Site ID ,location Note : ->This option lets User search against the entire site base accessible to the user and displays results in the list box on the left side. ->The count below the list box updates accordingly ->The search results should be retrieved based on users access",
					"User not able to see filter sites text box", "Fail");
			Assert.fail();
		}
	}

	public void verifyDisplayedColumns(WebDriver driver)
	{

		Log.info("Inside verifyDisplayedColumns method");

		String button = "";
		String header="";
		String header1="";
		String columnam="";
		String rownam="";

		WebDriverWait wait = new WebDriverWait(driver, 240);
		try
		{

			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_UnifiedPortalPage.ColumnNamesInTheGridOfSelectByProduct()))
			{

				wait.until(ExpectedConditions.presenceOfElementLocated(obj_UnifiedPortalPage.ColumnNamesInTheGridOfSelectByProduct()));
				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.ColumnNamesInTheGridOfSelectByProduct());
				List<WebElement> list=driver.findElements(obj_UnifiedPortalPage.ColumnNamesInTheGridOfSelectByProduct());
				List<WebElement> list1=driver.findElements(obj_UnifiedPortalPage.NumberSearchResultsDisplayed());

				int count=list1.size();
				System.out.println("total number of search rows displayed is "+count);
				for(WebElement lt:list)
				{
					CommonUtility.highlightElement(driver, lt);
					String label=lt.getText();

					System.out.println("column name is: " +label);
					columnam+=" <br> " + label;
				}
				System.out.println("table header is:"+columnam);


				List<WebElement> list2=driver.findElements(obj_UnifiedPortalPage.DetailsInEachRow());


				System.out.println("total number of search rows displayed is "+count);
				for(WebElement lt:list)
				{
					CommonUtility.ScrollToWebElement(driver, lt);
					String label=lt.getText();

					System.out.println("row name is: " +label);
					rownam+=" <br> " + label;
				}
				System.out.println("row grid details:"+rownam);

				Report.put("User verifies the list of assets for the selected  Site below the filter option ",
						"The list of assets for the selected site should be displayed in the grid ,and the following fields should be available: (IB status's  to be considered - Installed;Shipped;Awaiting Customer Install;Install-T&M ) Asset ID , Product Name, Product Nickname",
						"User able to grid details with columns "+Report.color(columnam)+" and row details "+Report.color(rownam), "PASS");

			}
			else
			{
				System.out.println("not able to see column details");
				Report.put("User verifies the list of assets for the selected  Site below the filter option ",
						"The list of assets for the selected site should be displayed in the grid ,and the following fields should be available: (IB status's  to be considered - Installed;Shipped;Awaiting Customer Install;Install-T&M ) Asset ID , Product Name, Product Nickname",
						"User not able to see column dteails", "Fail");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("User verifies the list of assets for the selected  Site below the filter option ",
					"The list of assets for the selected site should be displayed in the grid ,and the following fields should be available: (IB status's  to be considered - Installed;Shipped;Awaiting Customer Install;Install-T&M ) Asset ID , Product Name, Product Nickname",
					"User not able to see column details", "Fail");
			Assert.fail();
		}
	}


	public void vrifyButtonSectionButtons(WebDriver driver)
	{

		Log.info("Inside vrifyButtonSectionButtons method");

		String button = "";
		String button1 = "";
		String button2="";
		String cancel="";

		WebDriverWait wait = new WebDriverWait(driver, 240);
		try
		{

			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_UnifiedPortalPage.CreateCustomGroupButtonEnable()))
			{

				if(CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.CreateCustomGroupButtonEnable()).isEnabled())
				{
					System.out.println("create custom group button is enabled");
					Report.put("At the bottom of the page  Following options should be available in Selection tray:",
							"->Create Custom Group is available in disabled state ->Cancel button -Ability to cancel  ->No Products selected.Select one or more Products and click Add to Group. ",
							"create custom group button is enabled before selecting any sites", "Fail");
					Assert.fail();
				}
				else
				{
					CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.CreateCustomGroupButtonEnable());
					button1=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.CreateCustomGroupButtonEnable()).getText();
					System.out.println("button is "+button1);
				}
				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.CancelButton());
				cancel=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.CancelButton()).getText();
				System.out.println("button is "+cancel);

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.NoProductsSelectedMessage());
				button2=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.NoProductsSelectedMessage()).getText();
				System.out.println("button is "+button2);



				Report.put("At the bottom of the page  Following options should be available in Selection tray:",
						"->Create Custom Group is available in disabled state ->Cancel button -Ability to cancel  ->No Products selected.Select one or more Products and click Add to Group. ",
						"User able to see "+Report.color(button1)+ " button disabled and able to see "+Report.color(button2)+ " and button "+Report.color(cancel), "PASS");

			}


			else
			{
				System.out.println("not able to see create custom group button");
				Report.put("At the bottom of the page  Following options should be available in Selection tray:",
						"->Create Custom Group is available in disabled state ->Cancel button -Ability to cancel  ->No Products selected.Select one or more Products and click Add to Group. ",
						"User not able to see create custom group button", "Fail");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("At the bottom of the page  Following options should be available in Selection tray:",
					"->Create Custom Group is available in disabled state ->Cancel button -Ability to cancel  ->No Products selected.Select one or more Products and click Add to Group. ",
					"User not able to see create custom group button", "Fail");
			Assert.fail();
		}

	}
	public void validateFilterSectionInSitesGrid(WebDriver driver, String search)
	{

		Log.info("Inside validateFilterSectionInSitesGrid method");

		String button = "";

		WebDriverWait wait = new WebDriverWait(driver, 600);
		try
		{
			Thread.sleep(10000);
			CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.FilterSearchBoxInSiteGrid());
			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_UnifiedPortalPage.FilterSearchBoxInSiteGrid()))
			{

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.FilterSearchBoxInSiteGrid());
				CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.FilterSearchBoxInSiteGrid()).clear();
				CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.FilterSearchBoxInSiteGrid()).sendKeys(search);

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.FilterIconInSiteGrid());
				CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.FilterIconInSiteGrid());

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.XButtonInSiteGridFilter());

				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_UnifiedPortalPage.HighlightedTextValidation()));
				List<WebElement> list=driver.findElements(obj_UnifiedPortalPage.HighlightedTextValidation());

				for(int i=0;i<list.size();i++)
				{
					CommonUtility.ScrollToWebElement(driver, list.get(i));
				}

				Report.put("User verifies filter search results on the right  and user types for Example : 'Ness'",
						"Matching results should be displayed with the search text highlighted. All the rows which match 'Ness' should be displayed with the data 'Ness' highlighted",
						"User able to search using filter and able to see searched option highlighted and able to see clear (X) option", "PASS");

			}
			else
			{
				System.out.println("not able to see filter text box");
				Report.put("User verifies filter search results on the right  and user types for Example : 'Ness'",
						"Matching results should be displayed with the search text highlighted. All the rows which match 'Ness' should be displayed with the data 'Ness' highlighted",
						"User not able to see filter text box", "Fail");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("User verifies filter search results on the right  and user types for Example : 'Ness'",
					"Matching results should be displayed with the search text highlighted. All the rows which match 'Ness' should be displayed with the data 'Ness' highlighted",
					"User not able to see filter text box", "Fail");
			Assert.fail();
		}
	}


	public void searchForMetaData(WebDriver driver)
	{

		Log.info("Inside searchForMetaData method");

		String button = "";
		String columnam="";
		String rownam="";
		WebDriverWait wait = new WebDriverWait(driver, 150);
		try
		{

			if(CommonUtility.CheckpresenceofElementLocated(driver,33,obj_UnifiedPortalPage.SitesListInTable()))
			{

				Thread.sleep(6000);
				List<WebElement> list1=driver.findElements(obj_UnifiedPortalPage.SitesListInTable());

				int count3=list1.size();
				System.out.println("total number of sites displayed in table "+count3);
				int count2=0;
				for(int i=0;i<7;i++)
				{
					count2++;

					if(count2==1)
					{
						if (!(list1.get(i).isSelected())) 
						{
							try
							{
								CommonUtility.ScrollToWebElement(driver, list1.get(i));
								CommonUtility.ClickOnWebElement(driver, list1.get(i));

								Thread.sleep(3000);
							}
							catch(Exception e)
							{

							}
						}
					}


				}
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_UnifiedPortalPage.ColumnNamesInTheGridOfSelectByProduct()));
				List<WebElement> list=driver.findElements(obj_UnifiedPortalPage.ColumnNamesInTheGridOfSelectByProduct());
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_UnifiedPortalPage.NumberSearchResultsDisplayed()));
				List<WebElement> list2=driver.findElements(obj_UnifiedPortalPage.NumberSearchResultsDisplayed());

				int count=list2.size();
				System.out.println("total number of search rows displayed is "+count);
				for(WebElement lt:list)
				{
					CommonUtility.highlightElement(driver, lt);
					String label=lt.getText();

					System.out.println("column name is: " +label);
					columnam+=" <br> " + label;
				}
				System.out.println("table header is:"+columnam);


				List<WebElement> list3=driver.findElements(obj_UnifiedPortalPage.DetailsInEachRow());


				System.out.println("total number of search rows displayed is "+count);
				for(WebElement lt:list3)
				{
					CommonUtility.ScrollToWebElement(driver, lt);
					String label=lt.getText();

					System.out.println("row name is: " +label);
					rownam+=" <br> " + label;
				}
				System.out.println("row grid details:"+rownam);



				Report.put("User conducts a search using Site metadata and User inputs Site data ",
						"Site details are loaded up and Site details are loaded up Asset ID (SN or ST), Product Name, Product Nickname",
						"User able to see and clicked on first displayed meta data and able to see "+Report.color(columnam)+" as expected", "PASS");

			}
			else
			{
				System.out.println("not able to see sites in table");
				Report.put("User conducts a search using Site metadata and User inputs Site data ",
						"Site details are loaded up and Site details are loaded up Asset ID (SN or ST), Product Name, Product Nickname",
						"User not able to see sites in table", "Fail");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("User conducts a search using Site metadata and User inputs Site data ",
					"Site details are loaded up and Site details are loaded up Asset ID (SN or ST), Product Name, Product Nickname",
					"User not able to see sites in table", "Fail");
			Assert.fail();
		}
	}

	public void clickOnXButtonOfFilterClearInSitesGrid(WebDriver driver)
	{

		Log.info("Inside clickOnXButtonOfFilterClearInSitesGrid method");

		String button = "";

		WebDriverWait wait = new WebDriverWait(driver, 600);
		try
		{

			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_UnifiedPortalPage.XButtonInSiteGridFilter()))
			{

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.XButtonInSiteGridFilter());

				CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.XButtonInSiteGridFilter());
				Thread.sleep(6000);

				if(CommonUtility.CheckpresenceofElementLocated(driver,10,obj_UnifiedPortalPage.XButtonInSiteGridFilter()))
				{
					System.out.println("able to see highlighted search in the grid");
					Report.put("User clicks on the option to clear the 'filter' using 'X'",
							"Data set restores to the original ",
							"User able to see searched view in grid", "Fail");
					Assert.fail();
				}
				else
				{
					System.out.println("not able to see X button");
				}

				Report.put("User clicks on the option to clear the 'filter' using 'X'",
						"Data set restores to the original ",
						"User able to see data refresh and display grid", "PASS");

			}
			else
			{
				System.out.println("not able to see X button");
				Report.put("User clicks on the option to clear the 'filter' using 'X'",
						"Data set restores to the original ",
						"User not able to see X button", "Fail");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("User clicks on the option to clear the 'filter' using 'X'",
					"Data set restores to the original ",
					"User not able to see X button", "Fail");
			Assert.fail();
		}
	}
	public void SortingColumnsInGridOfSitesPage(WebDriver driver)
	{

		Log.info("Inside SortingColumnsInGridOfSitesPage method");

		String assertid = ""; String assertclass="";
		String Prodname=""; String prodclass="";
		String nickname="";String nickclass="";
		String siteid="";String siteidclass="";
		String sitedetils=""; String sitedetclass="";

		WebDriverWait wait = new WebDriverWait(driver, 600);
		try
		{

			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_UnifiedPortalPage.AssertIDSortingInSiteGrid()))
			{	
				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.AssertIDSortingInSiteGrid());
				assertid=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.AssertIDSortingInSiteGrid()).getText();
				System.out.println("column name is "+assertid);
				CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.AssertIDSortingInSiteGrid());

				Thread.sleep(6000);
				assertclass=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.AssertIDSortingInSiteGrid()).getAttribute("class");
				System.out.println("class is "+assertclass);

				if(!(assertclass.contains("sorting_desc")|| assertclass.contains("sorting_asc")))
				{
					System.out.println("not able to see asset id sorting");
					Report.put("User verifies sort on the following columns in ascending and descending order ",
							" User should be able to sort on the following columns in ascending and descending order Asset ID,Product Name,Product Nickname,Site ID,Site Details",
							"User not able to see asset id sorting", "Fail");
					Assert.fail();
				}

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.ProductNameSortinginSiteGrid());
				Prodname=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.ProductNameSortinginSiteGrid()).getText();
				System.out.println("column name is "+Prodname);
				CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.ProductNameSortinginSiteGrid());

				Thread.sleep(6000);
				prodclass=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.ProductNameSortinginSiteGrid()).getAttribute("class");
				System.out.println("class is "+prodclass);

				if(!(prodclass.contains("sorting_desc")|| prodclass.contains("sorting_asc")))
				{
					System.out.println("not able to see product name sorting");
					Report.put("User verifies sort on the following columns in ascending and descending order ",
							" User should be able to sort on the following columns in ascending and descending order Asset ID,Product Name,Product Nickname,Site ID,Site Details",
							"User not able to see product name sorting", "Fail");
					Assert.fail();
				}

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.ProductNicknameSortingInSiteGrid());
				nickname=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.ProductNicknameSortingInSiteGrid()).getText();
				System.out.println("column name is "+nickname);
				CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.ProductNicknameSortingInSiteGrid());

				Thread.sleep(6000);
				nickclass=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.ProductNicknameSortingInSiteGrid()).getAttribute("class");
				System.out.println("class is "+nickclass);

				if(!(nickclass.contains("sorting_desc")|| nickclass.contains("sorting_asc")))
				{
					System.out.println("not able to see product nickname sorting");
					Report.put("User verifies sort on the following columns in ascending and descending order ",
							" User should be able to sort on the following columns in ascending and descending order Asset ID,Product Name,Product Nickname,Site ID,Site Details",
							"User not able to see product nickname sorting", "Fail");
					Assert.fail();
				}



				Report.put("User verifies sort on the following columns in ascending and descending order ",
						" User should be able to sort on the following columns in ascending and descending order Asset ID,Product Name,Product Nickname",
						"User able to sort all columns in ascending and descending", "PASS");

			}
			else
			{
				System.out.println("not able to sort column names");
				Report.put("User verifies sort on the following columns in ascending and descending order ",
						" User should be able to sort on the following columns in ascending and descending order Asset ID,Product Name,Product Nickname",
						"User not able to sort column names", "Fail");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("User verifies sort on the following columns in ascending and descending order ",
					" User should be able to sort on the following columns in ascending and descending order Asset ID,Product Name,Product Nickname",
					"User not able to sort column names", "Fail");
			Assert.fail();
		}
	}

	public void SelectCreateBySitesAndOrProductFamilies(WebDriver driver)
	{

		Log.info("Inside SelectCreateBySitesAndOrProductFamilies method");

		String button = "";
		String header="";
		String header1="";
		String options="";
		String header2="";
		WebDriverWait wait = new WebDriverWait(driver, 600);
		try
		{

			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_UnifiedPortalPage.SitesOrProductFamiliesOption()))
			{
				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.SitesOrProductFamiliesOption());	
				button=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.SitesOrProductFamiliesOption()).getText();	
				System.out.println("option is "+button);
				CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.SitesOrProductFamiliesOption());	

				wait.until(ExpectedConditions.presenceOfElementLocated(obj_UnifiedPortalPage.NextButtonInCustomGroupCreation()));
				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.NextButtonInCustomGroupCreation());	
				header=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.NextButtonInCustomGroupCreation()).getText();	
				System.out.println("button is "+header);
				CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.NextButtonInCustomGroupCreation());

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.CreateACustomGroupHeader());	
				header1=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.CreateACustomGroupHeader()).getText();	
				System.out.println("header is "+header1);

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.CustomGroupName());	
				String custname=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.CustomGroupName()).getText();	
				System.out.println("header is "+custname);
				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.CustomGroupNameTextBox());	

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.CustomGroupDescription());	
				String custdes=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.CustomGroupDescription()).getText();	
				System.out.println("header is "+custdes);
				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.CustomerGroupDescriptionTextBox());	

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.CustomGroupDescription());	
				String selprod=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.CustomGroupDescription()).getText();	
				System.out.println("header is "+selprod);

				Report.put("User selects 'Create a Custom Group by selecting Sites and/or Product Families 'Next'",
						"screen should load up and User should see the below options : Title : Create a Custom Group, Two tabs with Select Sites and Select Product Families options",
						"User able to select "+Report.color(button)+" and clicking on "+Report.color(header)+" landed on <br>"+Report.color(header1)+" and "+Report.color(custname+" and "+custdes+" and "+selprod), "PASS");

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.SelectSitesTab());	
				String serby=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.SelectSitesTab()).getText();	
				System.out.println("header is "+serby);


				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.SelectProductFamiliesTab());
				header2=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.SelectProductFamiliesTab()).getText();	
				System.out.println("header is "+header2);

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.FilterSitesInSitesOrFamilies());	
				String prodsea=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.FilterSitesInSitesOrFamilies()).getText();	
				System.out.println("header is "+prodsea);

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.SearchTextBox());	

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.LabelUnderFilterSectionForSitesOrFamilies());	
				String instruction=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.LabelUnderFilterSectionForSitesOrFamilies()).getText();	
				System.out.println("instruction is "+instruction);

				if(CommonUtility.CheckpresenceofElementLocated(driver,5,obj_UnifiedPortalPage.SiteListInSitesOrFamilies()))
				{
					CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.SiteListInSitesOrFamilies());
					List<WebElement> list=driver.findElements(obj_UnifiedPortalPage.SiteListInSitesOrFamilies());

					for(WebElement lt:list)
					{
						CommonUtility.highlightElement(driver, lt);
						String label=lt.getText();

						System.out.println("option is: " +label);
						options+=" <br> " + label;
					}
					System.out.println("Options are:"+options);
				}
				Report.put("User verifies the  ist box with a select all option- Select all and options available on the page as following :",
						"User should be able select the Sites listed by clicking on the checkbox next to the site .List box is loaded with first 10 sites ->list of all the sites accessible to the user ;( Status =Active ;Account Type= Location; Install At =1 )->User should be able to do a virtualized scroll through the entire list ->The bottom of the grid has a count of the total sites -Account Sites / number of Sites when user performs a search -'Displaying <n> items '->Create Custom Group button  in disabled state->Cancel button->Message : No Sites selected.Select one or more Sites to see your selections here.",
						"User able to view "+Report.color(options)+" and "+Report.color(prodsea+" , "+header2)+" with text box with instruction message "+Report.color(instruction)+" with sites displayed "+Report.color(options), "PASS");

			}
			else
			{
				System.out.println("not able to see select by Sites and/or Product Families  option");
				Report.put("User selects 'Create a Custom Group by selecting Sites and/or Product Families 'Next'",
						"screen should load up and User should see the below options : Title : Create a Custom Group, Two tabs with Select Sites and Select Product Families options",
						"User not able to see select by Sites and/or Product Families  option", "Fail");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("User selects 'Create a Custom Group by selecting Sites and/or Product Families 'Next'",
					"screen should load up and User should see the below options : Title : Create a Custom Group, Two tabs with Select Sites and Select Product Families options",
					"User not able to see select by Sites and/or Product Families  option", "Fail");
			Assert.fail();
		}
	}


	public void verifyMessageOnRightSideBeforeSelectingSite(WebDriver driver)
	{

		Log.info("Inside verifyMessageOnRightSideBeforeSelectingSite method");

		String message = "";


		WebDriverWait wait = new WebDriverWait(driver, 240);
		try
		{

			if(CommonUtility.CheckpresenceofElementLocated(driver,33,obj_UnifiedPortalPage.TextMessageBeforeSelectingSite()))
			{
				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.TextMessageBeforeSelectingSite());	
				message=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.TextMessageBeforeSelectingSite()).getText();
				System.out.println(message);


				Report.put("User verify on the right site of the screen with a Message option that says Message: Click on a site to see details here, screen when User clicks on any of the site available on the list ",
						"User should be able to view the site details on the right side ",
						"User able to see expeced message before selecting sites from table as "+Report.color(message), "PASS");

			}
			else
			{
				System.out.println("not able to see message");
				Report.put("User verify on the right site of the screen with a Message option that says Message: Click on a site to see details here, screen when User clicks on any of the site available on the list ",
						"User should be able to view the site details on the right side ",
						"User failed to see expected message", "Fail");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("User verify on the right site of the screen with a Message option that says Message: Click on a site to see details here, screen when User clicks on any of the site available on the list ",
					"User should be able to view the site details on the right side ",
					"User failed to see expected message", "Fail");
			Assert.fail();
		}
	}

	
	public void verifyMessageOnRightSideBeforeSelectingProductFamilies(WebDriver driver)
	{

		Log.info("Inside verifyMessageOnRightSideBeforeSelectingProductFamilies method");

		String message = "";


		WebDriverWait wait = new WebDriverWait(driver, 240);
		try
		{

			if(CommonUtility.CheckpresenceofElementLocated(driver,33,obj_UnifiedPortalPage.TextMessageBeforeSelectingSite()))
			{
				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.TextMessageBeforeSelectingSite());	
				message=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.TextMessageBeforeSelectingSite()).getText();
				System.out.println(message);


				Report.put("User verifies on the right side of the screen  and should see a message ",
						"User should be able to see a Message: Click on a Product Family to see details here",
						"User able to see expeced message before selecting product families from table as "+Report.color(message), "PASS");

			}
			else
			{
				System.out.println("not able to see message");
				Report.put("User verifies on the right side of the screen  and should see a message ",
						"User should be able to see a Message: Click on a Product Family to see details here",
						"User failed to see expected message", "Fail");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("User verifies on the right side of the screen  and should see a message ",
					"User should be able to see a Message: Click on a Product Family to see details here",
					"User failed to see expected message", "Fail");
			Assert.fail();
		}
	}
	public void validateDiaabledButtonEnabledOnSelectingAnyCheckBox(WebDriver driver)
	{

		Log.info("Inside validateDiaabledButtonEnabledOnSelectingAnyCheckBox method");

		String button = "";
		String button1="";
		String cancel="";
		String button2="";

		WebDriverWait wait = new WebDriverWait(driver, 600);
		try
		{

			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_UnifiedPortalPage.FirstCheckBoxForSiteFamily()))
			{

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.CustomGroupNameTextBox());	
				CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.CustomGroupNameTextBox()).clear();
				CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.CustomGroupNameTextBox()).sendKeys(TestNGCreator.TestData.get(Esupport.FirstName.ordinal()));
				//				List<WebElement> list1=driver.findElements(obj_UnifiedPortalPage.CheckBoxForSelectingSitesForSitesOrFamilies());
				//
				//				int count3=list1.size();
				//				System.out.println("total number of sites displayed in table "+count3);
				//				int count2=0;
				//				for(int i=0;i<10;i++)
				//				{
				//					count2++;
				//
				//					if(count2==1)
				//					{
				//						if (!(list1.get(i).isSelected())) 
				//						{
				//							try
				//							{
				//								CommonUtility.ScrollToWebElement(driver, list1.get(i));
				//								CommonUtility.ClickOnWebElement(driver, list1.get(i));
				//
				//								
				//							}
				//							catch(Exception e)
				//							{
				//
				//							}
				//						}
				//					}
				//					else
				//					{
				//						break;
				//					}
				//				}
				CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.CountrySelector());
				if(CommonUtility.CheckpresenceofElementLocated(driver,10,obj_UnifiedPortalPage.FirstCheckBoxForSiteFamily()))
				{
					CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.FirstCheckBoxForSiteFamily());
					CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.FirstCheckBoxForSiteFamily());
				}

				if(CommonUtility.CheckpresenceofElementLocated(driver,10,obj_UnifiedPortalPage.SecondCheckBoxForSiteFamily()))
				{
					CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.SecondCheckBoxForSiteFamily());
					CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.SecondCheckBoxForSiteFamily());
				}

				if(CommonUtility.CheckpresenceofElementLocated(driver,10,obj_UnifiedPortalPage.ThirdCheckBoxForSiteFamily()))
				{
					CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.ThirdCheckBoxForSiteFamily());
					CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.ThirdCheckBoxForSiteFamily());
				}

				if(CommonUtility.CheckpresenceofElementLocated(driver,10,obj_UnifiedPortalPage.ForthCheckBoxForSiteFamily()))
				{
					CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.ForthCheckBoxForSiteFamily());
					CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.ForthCheckBoxForSiteFamily());
				}

				if(CommonUtility.CheckpresenceofElementLocated(driver,10,obj_UnifiedPortalPage.FifthCheckBoxForSiteFamily()))
				{
					
					CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.FifthCheckBoxForSiteFamily());
					CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.FifthCheckBoxForSiteFamily());
				}
				if(CommonUtility.CheckpresenceofElementLocated(driver,10,obj_UnifiedPortalPage.SixthCheckBoxForSiteFamily()))
				{
					CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.CountrySelector());
					CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.SixthCheckBoxForSiteFamily());
					CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.SixthCheckBoxForSiteFamily());
				}

				Thread.sleep(3000);


				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_UnifiedPortalPage.CreateCustomGroupButtonEnable()));
				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.CreateCustomGroupButtonEnable());
				button1=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.CreateCustomGroupButtonEnable()).getText();
				System.out.println("button is "+button1);

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.CancelButton());
				cancel=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.CancelButton()).getText();
				System.out.println("button is "+cancel);

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.ShowSelectedProductsTab());
				button2=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.ShowSelectedProductsTab()).getText();
				System.out.println("button is "+button2);

				Report.put("User verifies Create Custom Group , cancel , Show Selected Products at the bottom of the page ",
						"Create Custom Group , cancel , Show Selected Products options are enabled ",
						"User able to see "+Report.color(button1)+ " button enabled with "+Report.color(cancel)+" and able to see "+Report.color(button2)+ " tab displayed by selecting any check box of site in left side", "PASS");

			}
			else
			{

				System.out.println("not able to see sites in table");
				Report.put("User verifies Create Custom Group , cancel , Show Selected Products at the bottom of the page ",
						"Create Custom Group , cancel , Show Selected Products options are enabled ",
						"User not able to see sites in table", "Fail");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("User verifies Create Custom Group , cancel , Show Selected Products at the bottom of the page ",
					"Create Custom Group , cancel , Show Selected Products options are enabled ",
					"User not able to see sites in table", "Fail");
			Assert.fail();
		}
	}
	
	public void validateDiaabledButtonEnabledOnSelectingAnyCheckBox_ED_V1(WebDriver driver)
	{

		Log.info("Inside validateDiaabledButtonEnabledOnSelectingAnyCheckBox_ED_V1 method");

		String button = "";
		String button1="";
		String cancel="";
		String button2="";

		WebDriverWait wait = new WebDriverWait(driver, 600);
		try
		{

			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_UnifiedPortalPage.FirstCheckBoxForSiteFamily()))
			{

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.CustomGroupNameTextBox());	
				CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.CustomGroupNameTextBox()).clear();
				CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.CustomGroupNameTextBox()).sendKeys(TestNGCreator.TestData.get(Esupport.FirstName.ordinal()));
				//				List<WebElement> list1=driver.findElements(obj_UnifiedPortalPage.CheckBoxForSelectingSitesForSitesOrFamilies());
				//
				//				int count3=list1.size();
				//				System.out.println("total number of sites displayed in table "+count3);
				//				int count2=0;
				//				for(int i=0;i<10;i++)
				//				{
				//					count2++;
				//
				//					if(count2==1)
				//					{
				//						if (!(list1.get(i).isSelected())) 
				//						{
				//							try
				//							{
				//								CommonUtility.ScrollToWebElement(driver, list1.get(i));
				//								CommonUtility.ClickOnWebElement(driver, list1.get(i));
				//
				//								
				//							}
				//							catch(Exception e)
				//							{
				//
				//							}
				//						}
				//					}
				//					else
				//					{
				//						break;
				//					}
				//				}
//				CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.CountrySelector());
				
				if(CommonUtility.CheckpresenceofElementLocated(driver,10,obj_UnifiedPortalPage.SecondCheckBoxForSiteFamily()))
				{
					CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.SecondCheckBoxForSiteFamily());
					CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.SecondCheckBoxForSiteFamily());
				}
				if(CommonUtility.CheckpresenceofElementLocated(driver,10,obj_UnifiedPortalPage.FirstCheckBoxForSiteFamily()))
				{
					CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.CountrySelector());
					CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.FirstCheckBoxForSiteFamily());
					CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.FirstCheckBoxForSiteFamily());
				}

				if(CommonUtility.CheckpresenceofElementLocated(driver,10,obj_UnifiedPortalPage.SecondCheckBoxForSiteFamily()))
				{
					CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.CountrySelector());
					CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.SecondCheckBoxForSiteFamily());
					CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.SecondCheckBoxForSiteFamily());
				}

				if(CommonUtility.CheckpresenceofElementLocated(driver,10,obj_UnifiedPortalPage.ThirdCheckBoxForSiteFamily()))
				{
					CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.CountrySelector());
					CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.ThirdCheckBoxForSiteFamily());
					CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.ThirdCheckBoxForSiteFamily());
				}

				if(CommonUtility.CheckpresenceofElementLocated(driver,10,obj_UnifiedPortalPage.ForthCheckBoxForSiteFamily()))
				{
					CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.CountrySelector());
					CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.ForthCheckBoxForSiteFamily());
					CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.ForthCheckBoxForSiteFamily());
				}

				if(CommonUtility.CheckpresenceofElementLocated(driver,10,obj_UnifiedPortalPage.FifthCheckBoxForSiteFamily()))
				{
					CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.CountrySelector());
					CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.FifthCheckBoxForSiteFamily());
					CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.FifthCheckBoxForSiteFamily());
				}
				if(CommonUtility.CheckpresenceofElementLocated(driver,10,obj_UnifiedPortalPage.SixthCheckBoxForSiteFamily()))
				{
					CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.CountrySelector());
					CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.SixthCheckBoxForSiteFamily());
					CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.SixthCheckBoxForSiteFamily());
				}

				Thread.sleep(3000);


				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_UnifiedPortalPage.CreateCustomGroupButtonEnable()));
				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.CreateCustomGroupButtonEnable());
				button1=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.CreateCustomGroupButtonEnable()).getText();
				System.out.println("button is "+button1);

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.CancelButton());
				cancel=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.CancelButton()).getText();
				System.out.println("button is "+cancel);

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.ShowSelectedProductsTab());
				button2=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.ShowSelectedProductsTab()).getText();
				System.out.println("button is "+button2);

				Report.put("User verifies Create Custom Group , cancel , Show Selected Products at the bottom of the page ",
						"Create Custom Group , cancel , Show Selected Products options are enabled ",
						"User able to see "+Report.color(button1)+ " button enabled with "+Report.color(cancel)+" and able to see "+Report.color(button2)+ " tab displayed by selecting any check box of site in left side", "PASS");

			}
			else
			{

				System.out.println("not able to see sites in table");
				Report.put("User verifies Create Custom Group , cancel , Show Selected Products at the bottom of the page ",
						"Create Custom Group , cancel , Show Selected Products options are enabled ",
						"User not able to see sites in table", "Fail");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("User verifies Create Custom Group , cancel , Show Selected Products at the bottom of the page ",
					"Create Custom Group , cancel , Show Selected Products options are enabled ",
					"User not able to see sites in table", "Fail");
			Assert.fail();
		}
	}

	public void validateFilterSiteForSitesOrFamilies(WebDriver driver, String search)
	{

		Log.info("Inside validateFilterSiteForSitesOrFamilies method");

		String button = "";
		String message="";
		WebDriverWait wait = new WebDriverWait(driver, 600);
		try
		{

			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_UnifiedPortalPage.FilterSitesInSitesOrFamilies()))
			{

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.FilterSitesInSitesOrFamilies());
				CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.SearchTextBox()).clear();
				CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.SearchTextBox()).sendKeys(search);

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.FilterIconForSitesOrFamilies());
				CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.FilterIconForSitesOrFamilies());

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.LabelUnderFilterSectionForSitesOrFamilies());
				message=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.LabelUnderFilterSectionForSitesOrFamilies()).getText();
				System.out.println(message);

				Thread.sleep(10000);
				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.SiteListInSitesOrFamilies());
				CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.SiteListInSitesOrFamilies());




				Report.put("User clicks on the filter option ",
						"User should be able to filter by :Site ID,Site Name ,Site Location",
						"User able to search using filter sites with label message "+Report.color(message)+" and able to see searched option highlighted and searched with site ID for testing ", "PASS");

			}
			else
			{
				System.out.println("not able to see filter sites text box");
				Report.put("User clicks on the filter option ",
						"User should be able to filter by :Site ID,Site Name ,Site Location",
						"User not able to see filter sites text box", "Fail");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("User clicks on the filter option ",
					"User should be able to filter by :Site ID,Site Name ,Site Location",
					"User not able to see filter sites text box", "Fail");
			Assert.fail();
		}
	}

	public void clickOnXButtonOfFilterClearInSitesOrFamiliesGrid(WebDriver driver)
	{

		Log.info("Inside clickOnXButtonOfFilterClearInSitesOrFamiliesGrid method");

		String button = "";

		WebDriverWait wait = new WebDriverWait(driver, 600);
		try
		{

			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_UnifiedPortalPage.XButtonInSitesOrFamilies()))
			{

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.XButtonInSitesOrFamilies());

				CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.XButtonInSitesOrFamilies());
				Thread.sleep(6000);

				if(CommonUtility.CheckpresenceofElementLocated(driver,10,obj_UnifiedPortalPage.XButtonInSitesOrFamilies()))
				{
					System.out.println("able to see highlighted search in the grid");
					Report.put("User clicks on the option to clear the 'filter' using 'X'",
							"Data set restores to the original ",
							"User able to see searched view in grid", "Fail");
					Assert.fail();
				}
				else
				{
					System.out.println("not able to see X button");
				}

				Report.put("User clicks on the option to clear the 'filter' using 'X'",
						"Data set restores to the original ",
						"User able to see data refresh and display grid", "PASS");

			}
			else
			{
				System.out.println("not able to see X button");
				Report.put("User clicks on the option to clear the 'filter' using 'X'",
						"Data set restores to the original ",
						"User not able to see X button", "Fail");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("User clicks on the option to clear the 'filter' using 'X'",
					"Data set restores to the original ",
					"User not able to see X button", "Fail");
			Assert.fail();
		}
	}

	public void verifySitesAvailableInSitesOrFamilies(WebDriver driver)
	{

		Log.info("Inside verifySitesAvailableInSitesOrFamilies method");

		String button = "";
		String header="";
		String header1="";
		String columnam="";
		String rownam="";

		WebDriverWait wait = new WebDriverWait(driver, 240);
		try
		{

			if(CommonUtility.CheckpresenceofElementLocated(driver,33,obj_UnifiedPortalPage.SearchBySropDownValues()))
			{
				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.CustomGroupNameTextBox());	
				CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.CustomGroupNameTextBox()).clear();
				CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.CustomGroupNameTextBox()).sendKeys(TestNGCreator.TestData.get(Esupport.FirstName.ordinal()));
				//				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.SelectProductDropDown());
				//				CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.SelectProductDropDown());
				//				Thread.sleep(6000);
				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.SelectProductDropDown());
				Select selOption = new  Select(driver.findElement(obj_UnifiedPortalPage.SelectProductDropDown()));
				List<WebElement> list1=selOption.getOptions();


				for(WebElement lt:list1)
				{
					CommonUtility.highlightElement(driver, lt);
					String dropdown=lt.getText();

				}

				selOption.selectByValue("SearchBySites");

				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_UnifiedPortalPage.TableOfSites()));
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_UnifiedPortalPage.SitesListInTable()));
				List<WebElement> list=driver.findElements(obj_UnifiedPortalPage.SitesListInTable());

				int count=list.size();
				System.out.println("total number of sites displayed in table is "+count);
				for(WebElement lt:list)
				{
					CommonUtility.highlightElement(driver, lt);
					String label=lt.getText();

					System.out.println("site is: " +label);
					columnam+=" <br> " + label;
				}
				System.out.println("sites are :"+columnam);


				Report.put("User Selects Search by drop down with 'Search by Site' option ",
						"The list box should load that has the list of sites accessible to the logged in Customer user.",
						"User able to select search in sites option and able to see table displayed sites "+Report.color(columnam), "PASS");

			}
			else
			{
				System.out.println("not able to see search dropdown");
				Report.put("User Selects Search by drop down with 'Search by Site' option ",
						"The list box should load that has the list of sites accessible to the logged in Customer user.",
						"User not able to see search dropdown", "Fail");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("User Selects Search by drop down with 'Search by Site' option ",
					"The list box should load that has the list of sites accessible to the logged in Customer user.",
					"User not able to see search dropdown", "Fail");
			Assert.fail();
		}
	}

	public void verifyListOfSitesAvailable(WebDriver driver)
	{

		Log.info("Inside verifyListOfSitesAvailable method");

		String button = "";
		String header="";
		String header1="";
		String columnam="";
		String rownam="";

		WebDriverWait wait = new WebDriverWait(driver, 240);
		try
		{

			if(CommonUtility.CheckpresenceofElementLocated(driver,33,obj_UnifiedPortalPage.SiteListInSitesOrFamilies()))
			{

				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_UnifiedPortalPage.SiteListInSitesOrFamilies()));
				List<WebElement> list=driver.findElements(obj_UnifiedPortalPage.SitesListInTable());

				int count=list.size();
				System.out.println("total number of sites displayed in table is "+count);
				for(WebElement lt:list)
				{
					CommonUtility.ScrollToWebElement(driver, lt);
					String label=lt.getText();

					System.out.println("site is: " +label);
					columnam+=" <br> " + label;
				}
				System.out.println("sites are :"+columnam);


				Report.put("user is on  'Select Sites' option and should be verify the list of sites available",
						"User should be able see the Sites listed by ",
						"User able to see sites option selected and able to see table displayed sites "+Report.color(columnam), "PASS");

			}
			else
			{
				System.out.println("not able to see sites list");
				Report.put("user is on  'Select Sites' option and should be verify the list of sites available",
						"User should be able see the Sites listed by ",
						"User failed to see sites list ", "Fail");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("user is on  'Select Sites' option and should be verify the list of sites available",
					"User should be able see the Sites listed by ",
					"User failed to see sites list ", "Fail");
			Assert.fail();
		}
	}

	public void verifyRightHandSideDetailsForSitesOrFamilies(WebDriver driver)
	{

		Log.info("Inside verifyRightHandSideDetailsForSitesOrFamilies method");

		String siteidheader = "";String SiteVisibilityHeader = "";String NameHeader = "";String AddressHeader = "";
		String NameOFSite = "";String SiteIDDetails = "";String SiteVisibilityDetails = "";String AddressDetails = "";
		WebDriverWait wait = new WebDriverWait(driver, 600);
		try
		{

			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_UnifiedPortalPage.SecondCheckBoxForSiteFamily()))
			{
//				CommonUtility.ScrollTo(driver, obj_UnifiedPortalPage.SitesListInTable());
//				List<WebElement> list=driver.findElements(obj_UnifiedPortalPage.SitesListInTable());
//
//				int count=list.size();
//				System.out.println("total number of checkbox displayed is "+count);
//				int count1=0;
//				for(int i=0;i<6;i++)
//				{
//					count1++;
//
//					if(count1==1)
//					{
//						try
//						{
//							CommonUtility.ScrollToWebElement(driver, list.get(i));
//							CommonUtility.ClickOnWebElement(driver, list.get(i));
//						}
//						catch(Exception e)
//						{
//
//						}
//
//					}
//					else
//					{
//						break;
//					}
//
//				}
				//				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.SelectSitefromTable());
				//				CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.SelectSitefromTable());
				
				if(CommonUtility.CheckpresenceofElementLocated(driver,10,obj_UnifiedPortalPage.SecondCheckBoxForSiteFamily()))
				{
					CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.SecondCheckBoxForSiteFamily());
					CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.SecondCheckBoxForSiteFamily());
				}
				
				Thread.sleep(6000);
				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.NameHeader());
				NameHeader=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.NameHeader()).getText();
				System.out.println(NameHeader);

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.SiteIDHeader());
				siteidheader=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.SiteIDHeader()).getText();
				System.out.println(siteidheader);

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.SiteVisibilityHeader());
				SiteVisibilityHeader=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.SiteVisibilityHeader()).getText();
				System.out.println(SiteVisibilityHeader);


				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.AddressHeader());
				AddressHeader=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.AddressHeader()).getText();
				System.out.println(AddressHeader);

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.NameOFSite());
				NameOFSite=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.NameOFSite()).getText();
				System.out.println(NameOFSite);

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.SiteIDDetails());
				SiteIDDetails=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.SiteIDDetails()).getText();
				System.out.println(SiteIDDetails);

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.SiteVisibilityDetails());
				SiteVisibilityDetails=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.SiteVisibilityDetails()).getText();
				System.out.println(SiteVisibilityDetails);

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.AddressDetails());
				AddressDetails=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.AddressDetails()).getText();
				System.out.println(AddressDetails);


				Report.put("User Clicks anywhere on the site in the left pod (other than the check box)",
						"The site details will be revealed in the grid on the right hand side Site details like Name ,ID ,Address and security should be displayed",
						"User able to see details "+Report.color(NameHeader+" : "+NameOFSite)+" , "+Report.color(siteidheader+" : "+SiteIDDetails)+" , "
								+Report.color(SiteVisibilityHeader+" : "+SiteVisibilityDetails)+" , "+Report.color(AddressHeader+" : "+AddressDetails), "PASS");

			}
			else
			{
				System.out.println("not able to see expected details");
				Report.put("User Clicks anywhere on the site in the left pod (other than the check box)",
						"The site details will be revealed in the grid on the right hand side Site details like Name ,ID ,Address and security should be displayed",
						"User not able to see expected details", "Fail");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("User Clicks anywhere on the site in the left pod (other than the check box)",
					"The site details will be revealed in the grid on the right hand side Site details like Name ,ID ,Address and security should be displayed",
					"User not able to see expected details", "Fail");
			Assert.fail();
		}
	}
	
	public void verifyRightHandSideDetailsForSitesOrFamilies_ED(WebDriver driver)
	{

		Log.info("Inside verifyRightHandSideDetailsForSitesOrFamilies_ED method");

		String siteidheader = "";String SiteVisibilityHeader = "";String NameHeader = "";String AddressHeader = "";
		String NameOFSite = "";String SiteIDDetails = "";String SiteVisibilityDetails = "";String AddressDetails = "";
		WebDriverWait wait = new WebDriverWait(driver, 600);
		try
		{

			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_UnifiedPortalPage.SecondCheckBoxForSiteFamily()))
			{
//				CommonUtility.ScrollTo(driver, obj_UnifiedPortalPage.SitesListInTable());
//				List<WebElement> list=driver.findElements(obj_UnifiedPortalPage.SitesListInTable());
//
//				int count=list.size();
//				System.out.println("total number of checkbox displayed is "+count);
//				int count1=0;
//				for(int i=0;i<6;i++)
//				{
//					count1++;
//
//					if(count1==1)
//					{
//						try
//						{
//							CommonUtility.ScrollToWebElement(driver, list.get(i));
//							CommonUtility.ClickOnWebElement(driver, list.get(i));
//						}
//						catch(Exception e)
//						{
//
//						}
//
//					}
//					else
//					{
//						break;
//					}
//
//				}
				//				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.SelectSitefromTable());
				//				CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.SelectSitefromTable());
				
				if(CommonUtility.CheckpresenceofElementLocated(driver,10,obj_UnifiedPortalPage.SecondCheckBoxForSiteFamily()))
				{
					CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.CountrySelector());
					CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.SecondCheckBoxForSiteFamily());
					CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.SecondCheckBoxForSiteFamily());
				}
				
				Thread.sleep(6000);
				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.NameHeader());
				NameHeader=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.NameHeader()).getText();
				System.out.println(NameHeader);

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.SiteIDHeader());
				siteidheader=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.SiteIDHeader()).getText();
				System.out.println(siteidheader);

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.SiteVisibilityHeader());
				SiteVisibilityHeader=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.SiteVisibilityHeader()).getText();
				System.out.println(SiteVisibilityHeader);


				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.AddressHeader());
				AddressHeader=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.AddressHeader()).getText();
				System.out.println(AddressHeader);

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.NameOFSite());
				NameOFSite=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.NameOFSite()).getText();
				System.out.println(NameOFSite);

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.SiteIDDetails());
				SiteIDDetails=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.SiteIDDetails()).getText();
				System.out.println(SiteIDDetails);

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.SiteVisibilityDetails());
				SiteVisibilityDetails=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.SiteVisibilityDetails()).getText();
				System.out.println(SiteVisibilityDetails);

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.AddressDetails());
				AddressDetails=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.AddressDetails()).getText();
				System.out.println(AddressDetails);


				Report.put("User Clicks anywhere on the site in the left pod (other than the check box)",
						"The site details will be revealed in the grid on the right hand side Site details like Name ,ID ,Address and security should be displayed",
						"User able to see details "+Report.color(NameHeader+" : "+NameOFSite)+" , "+Report.color(siteidheader+" : "+SiteIDDetails)+" , "
								+Report.color(SiteVisibilityHeader+" : "+SiteVisibilityDetails)+" , "+Report.color(AddressHeader+" : "+AddressDetails), "PASS");

			}
			else
			{
				System.out.println("not able to see expected details");
				Report.put("User Clicks anywhere on the site in the left pod (other than the check box)",
						"The site details will be revealed in the grid on the right hand side Site details like Name ,ID ,Address and security should be displayed",
						"User not able to see expected details", "Fail");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("User Clicks anywhere on the site in the left pod (other than the check box)",
					"The site details will be revealed in the grid on the right hand side Site details like Name ,ID ,Address and security should be displayed",
					"User not able to see expected details", "Fail");
			Assert.fail();
		}
	}
	public void ClickOnAddToGroupButton_ED(WebDriver driver)
	{

		Log.info("Inside ClickOnAddToGroupButton_ED method");

		String button = "";
		String button1 = "";
		String button2="";
		String cancel="";
		String testcase=TestNGCreator.TestData.get(Esupport.TestCaseID.ordinal());
		WebDriverWait wait = new WebDriverWait(driver, 240);
		try
		{

			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_UnifiedPortalPage.AddToGroupButtonInGrid()))
			{

				if(CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.AddToGroupButtonInGrid()).isEnabled())
				{


					Thread.sleep(6000);

					//					Actions act=new Actions(driver);
					//					act.moveToElement(CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.AddToGroupButtonInGrid())).click().build().perform();
					CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.CountrySelector());
					Thread.sleep(6000);
					CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.AddToGroupButtonInGrid());
					button=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.AddToGroupButtonInGrid()).getText();
					System.out.println("button is "+button);
					CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.AddToGroupButtonInGrid());



					Thread.sleep(6000);
					wait.until(ExpectedConditions.visibilityOfElementLocated(obj_UnifiedPortalPage.CreateCustomGroupButtonEnable()));
					CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.CreateCustomGroupButtonEnable());
					button1=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.CreateCustomGroupButtonEnable()).getText();
					System.out.println("button is "+button1);

					CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.CancelButton());
					cancel=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.CancelButton()).getText();
					System.out.println("button is "+cancel);

					CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.ShowSelectedProductsTab());
					button2=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.ShowSelectedProductsTab()).getText();
					System.out.println("button is "+button2);


					if(testcase.equals("8382682"))
					{
						Report.put("User adds the products  using 'Add to Group' in a Custom Group created using 'Products'",
								"Clicking on 'Add to Group' should flash the bottom section in blue for n seconds and create custom group button should be enabled and Show selected products tab should be enabled",
								"User able to click on "+Report.color(button)+" button and able to see "+Report.color(button1)+ " button enabled and able to see "+Report.color(button2)+ " tab displayed", "PASS");

						Report.put("User verifies Create Custom Group , cancel , Show Selected Products at the bottom of the page ",
								"Create Custom Group , cancel , Show Selected Products options are enabled ",
								"User able to see "+Report.color(button)+" button enabled and able to see "+Report.color(button1)+ " button enabled with "+Report.color(cancel)+" and able to see "+Report.color(button2)+ " tab displayed", "PASS");
					}
					else
					{
						Report.put("User adds the products  using 'Add to Group' in a Custom Group created using 'Products'",
								"Clicking on 'Add to Group' should flash the bottom section in blue for n seconds and create custom group button should be enabled and Show selected products tab should be enabled",
								"User able to click on "+Report.color(button)+" button and able to see "+Report.color(button1)+ " button enabled and able to see "+Report.color(button2)+ " tab displayed", "PASS");
					}
				}
				else
				{
					System.out.println("not able to see add to group button enabled");
					Report.put("User adds the products  using 'Add to Group' in a Custom Group created using 'Products'",
							"Clicking on 'Add to Group' should flash the bottom section in blue for n seconds and create custom group button should be enabled and Show selected products tab should be enabled",
							"User not able to see check box", "Fail");
					Assert.fail();
				}


			}
			else
			{
				System.out.println("not able to see add to group button");
				Report.put("User adds the products  using 'Add to Group' in a Custom Group created using 'Products'",
						"Clicking on 'Add to Group' should flash the bottom section in blue for n seconds and create custom group button should be enabled and Show selected products tab should be enabled",
						"User not able to see add to group button", "Fail");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("User adds the products  using 'Add to Group' in a Custom Group created using 'Products'",
					"Clicking on 'Add to Group' should flash the bottom section in blue for n seconds and create custom group button should be enabled and Show selected products tab should be enabled",
					"User not able to see add to group button", "Fail");
			Assert.fail();
		}

	}

	public void SelectOneOrMultipleAssetsInSitesGrid_ED(WebDriver driver)
	{

		Log.info("Inside SelectOneOrMultipleAssetsInSitesGrid_ED method");

		String button = "";

		WebDriverWait wait = new WebDriverWait(driver, 600);
		try
		{

			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_UnifiedPortalPage.SitesListInTable()))
			{
				CommonUtility.ScrollTo(driver, obj_UnifiedPortalPage.SitesListInTable());
				//				WebElement element=driver.findElement(obj_UnifiedPortalPage.SitesListInTable());
				//				CommonUtility.ScrollTo(driver, obj_UnifiedPortalPage.SitesListInTable());
				//				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
				List<WebElement> list1=driver.findElements(obj_UnifiedPortalPage.SitesListInTable());

				int count3=list1.size();
				System.out.println("total number of sites displayed in table "+count3);
				int count2=0;
				for(int i=0;i<7;i++)
				{
					count2++;

					if(count2==1)
					{
						if (!(list1.get(i).isSelected())) 
						{
							try
							{
								CommonUtility.scrollToViewElement(driver, list1.get(i));
								CommonUtility.ClickOnWebElement(driver, list1.get(i));

								Thread.sleep(3000);
							}
							catch(Exception e)
							{

							}
						}
					}


				}
				Thread.sleep(15000);
				verifyDisplayedColumns(driver);
				if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_UnifiedPortalPage.FiestCheckBox()))
				{

					if(CommonUtility.CheckpresenceofElementLocated(driver,10,obj_UnifiedPortalPage.FiestCheckBox()))
					{
						CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.FiestCheckBox());
						CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.FiestCheckBox());
					}

					if(CommonUtility.CheckpresenceofElementLocated(driver,10,obj_UnifiedPortalPage.SecCheckBox()))
					{
						CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.SecCheckBox());
						CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.SecCheckBox());
					}

					if(CommonUtility.CheckpresenceofElementLocated(driver,10,obj_UnifiedPortalPage.ThirdCheckBox()))
					{
						CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.ThirdCheckBox());
						CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.ThirdCheckBox());
					}

					if(CommonUtility.CheckpresenceofElementLocated(driver,10,obj_UnifiedPortalPage.ForthCheckBox()))
					{
						CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.ForthCheckBox());
						CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.ForthCheckBox());
					}

					if(CommonUtility.CheckpresenceofElementLocated(driver,10,obj_UnifiedPortalPage.FifthCheckBox()))
					{
						CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.FifthCheckBox());
						CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.FifthCheckBox());
					}
					if(CommonUtility.CheckpresenceofElementLocated(driver,10,obj_UnifiedPortalPage.SixCheckBox()))
					{
						CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.SixCheckBox());
						CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.SixCheckBox());
					}


				}
				else
				{
					System.out.println("not able to see asset IDs");
					Report.put("User selects one/multiple/all the assets",
							"'Add to Group' button is enabled; (IB status's  to be considered - Installed;Shipped;Awaiting Customer Install;Install-T&M )",
							"User not able to see asset IDs", "Fail");
					Assert.fail();
				}
				Thread.sleep(6000);
				if(CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.AddToGroupButtonInSitesGrid()).isEnabled())
				{
					CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.CountrySelector());
					CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.AddToGroupButtonInSitesGrid());
					button=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.AddToGroupButtonInSitesGrid()).getText();
					System.out.println("button is "+button);
				}
				else
				{
					System.out.println("not able to see add to group");
					Report.put("User selects one/multiple/all the assets",
							"'Add to Group' button is enabled; (IB status's  to be considered - Installed;Shipped;Awaiting Customer Install;Install-T&M )",
							"User not able to see add to group button", "Fail");
					Assert.fail();
				}



				Report.put("User selects one/multiple/all the assets",
						"'Add to Group' button is enabled; (IB status's  to be considered - Installed;Shipped;Awaiting Customer Install;Install-T&M )",
						"User able to select multiple assets, enabled "+Report.color(button)+" button", "PASS");

			}
			else
			{
				System.out.println("not able to see sites in table");
				Report.put("User selects one/multiple/all the assets",
						"'Add to Group' button is enabled; (IB status's  to be considered - Installed;Shipped;Awaiting Customer Install;Install-T&M )",
						"User not able to see sites in table", "Fail");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("User selects one/multiple/all the assets",
					"'Add to Group' button is enabled; (IB status's  to be considered - Installed;Shipped;Awaiting Customer Install;Install-T&M )",
					"User not able to see sites in table", "Fail");
			Assert.fail();
		}
	}

	public void clickOnGroupNameHyperlink(WebDriver driver)
	{

		Log.info("Inside clickOnGroupNameHyperlink method");
		String item=TestNGCreator.TestData.get(Esupport.SearchOption.ordinal());
		String button = "";
		String header="";
		String totaloptions="";
		WebDriverWait wait = new WebDriverWait(driver, 600);
		try
		{

			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_UnifiedPortalPage.ItemsColumnDetails()))
			{

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.ItemsColumnDetails());
				List<WebElement> list=driver.findElements(obj_UnifiedPortalPage.ItemsColumnDetails());


				for(int i=0;i<list.size();i++)
				{
					//					CommonUtility.ScrollToWebElement(driver, list.get(i));
					String option=list.get(i).getText();
					totaloptions += "<br>"+option;		

					if(option.contains(item))
					{
						try
						{
							CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.GroupNameDetails());
							List<WebElement> list1=driver.findElements(obj_UnifiedPortalPage.GroupNameDetails());

							CommonUtility.ScrollToWebElement(driver, list1.get(i));

							CommonUtility.ClickOnWebElement(driver, list1.get(i));


							break;
						}
						catch(Exception e)
						{

						}

						Thread.sleep(6000);
					}
				}
				System.out.println(totaloptions);

				wait.until(ExpectedConditions.presenceOfElementLocated(obj_UnifiedPortalPage.CustomGroupNameOnDetailsPage()));
				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.CustomGroupNameOnDetailsPage());
				header=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.CustomGroupNameOnDetailsPage()).getText();
				System.out.println(header);

				Report.put("Precondition : When a user  User clicks on select 'hyperlink' for any group name of the type 'Sites and Product Families' for viewing ",
						"User should be taken to the details page with the 'contents' as below:1.Title (Custom Group Name) 2.Custom Group Name field (view only) 3.Custom Group Description (View only) 4.Selected Items tab 5.Asset Preview tab 6.Selected Sites section 7.In this use case , all the selected sites should be listed one below another <br> 8.Selected Product Families section 9.List of Product Families selected so far(Example -if 10 Product Families are selected ,all 10 should be displayed like below)>>Isilon (n Assets)>>VMAX (n Assets)>>PowerEdge (n Assets)>>Cloud Products (n Assets) >>Dell Networking (n Assets) 10.Back to Custom Groups link -Should redirect the user to list of custom groups page 11.Edit Selected Items button-On click should direct the users to edit page 12.Delete Custom Group Button -On click",
						"User able to click on group name of item type sites and families ", "PASS");
				Thread.sleep(6000);
				validateDetailsOnSitesAndFamiliesGroupname(driver);
				Thread.sleep(6000);
			}
			else
			{
				System.out.println("not able to see grid details");
				Report.put("Precondition : When a user  User clicks on select 'hyperlink' for any group name of the type 'Sites and Product Families' for viewing ",
						"User should be taken to the details page with the 'contents' as below:1.Title (Custom Group Name) 2.Custom Group Name field (view only) 3.Custom Group Description (View only) 4.Selected Items tab 5.Asset Preview tab 6.Selected Sites section 7.In this use case , all the selected sites should be listed one below another <br> 8.Selected Product Families section 9.List of Product Families selected so far(Example -if 10 Product Families are selected ,all 10 should be displayed like below)>>Isilon (n Assets)>>VMAX (n Assets)>>PowerEdge (n Assets)>>Cloud Products (n Assets) >>Dell Networking (n Assets) 10.Back to Custom Groups link -Should redirect the user to list of custom groups page 11.Edit Selected Items button-On click should direct the users to edit page 12.Delete Custom Group Button -On click",
						"User failed to see grid details", "Fail");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Precondition : When a user  User clicks on select 'hyperlink' for any group name of the type 'Sites and Product Families' for viewing ",
					"User should be taken to the details page with the 'contents' as below:1.Title (Custom Group Name) 2.Custom Group Name field (view only) 3.Custom Group Description (View only) 4.Selected Items tab 5.Asset Preview tab 6.Selected Sites section 7.In this use case , all the selected sites should be listed one below another <br> 8.Selected Product Families section 9.List of Product Families selected so far(Example -if 10 Product Families are selected ,all 10 should be displayed like below)>>Isilon (n Assets)>>VMAX (n Assets)>>PowerEdge (n Assets)>>Cloud Products (n Assets) >>Dell Networking (n Assets) 10.Back to Custom Groups link -Should redirect the user to list of custom groups page 11.Edit Selected Items button-On click should direct the users to edit page 12.Delete Custom Group Button -On click",
					"User failed to see grid details", "Fail");
			Assert.fail();
		}
	}

	public void clickOnGroupNameHyperlink_IE(WebDriver driver)
	{

		Log.info("Inside clickOnGroupNameHyperlink_IE method");
		String item=TestNGCreator.TestData.get(Esupport.SearchOption.ordinal());
		String button = "";
		String header="";
		String totaloptions="";
		WebDriverWait wait = new WebDriverWait(driver, 600);
		Actions act=new Actions(driver);
		try
		{

			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_UnifiedPortalPage.ItemsColumnDetails()))
			{

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.ItemsColumnDetails());
				List<WebElement> list=driver.findElements(obj_UnifiedPortalPage.ItemsColumnDetails());


				for(int i=0;i<list.size();i++)
				{
					//					CommonUtility.ScrollToWebElement(driver, list.get(i));
					String option=list.get(i).getText();
					totaloptions += "<br>"+option;		

					if(option.contains(item))
					{
						try
						{
							CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.GroupNameDetailsInIE());
							List<WebElement> list1=driver.findElements(obj_UnifiedPortalPage.GroupNameDetailsInIE());

							CommonUtility.ScrollToWebElement(driver, list1.get(i));

							CommonUtility.ClickOnWebElement(driver, list1.get(i));

							break;
						}
						catch(Exception e)
						{

						}

						Thread.sleep(6000);
					}
				}
				System.out.println(totaloptions);

				wait.until(ExpectedConditions.presenceOfElementLocated(obj_UnifiedPortalPage.CustomGroupNameOnDetailsPage()));
				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.CustomGroupNameOnDetailsPage());
				header=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.CustomGroupNameOnDetailsPage()).getText();
				System.out.println(header);

				Report.put("Precondition : When a user  User clicks on select 'hyperlink' for any group name of the type 'Sites and Product Families' for viewing ",
						"User should be taken to the details page with the 'contents' as below:1.Title (Custom Group Name) 2.Custom Group Name field (view only) 3.Custom Group Description (View only) 4.Selected Items tab 5.Asset Preview tab 6.Selected Sites section 7.In this use case , all the selected sites should be listed one below another <br> 8.Selected Product Families section 9.List of Product Families selected so far(Example -if 10 Product Families are selected ,all 10 should be displayed like below)>>Isilon (n Assets)>>VMAX (n Assets)>>PowerEdge (n Assets)>>Cloud Products (n Assets) >>Dell Networking (n Assets) 10.Back to Custom Groups link -Should redirect the user to list of custom groups page 11.Edit Selected Items button-On click should direct the users to edit page 12.Delete Custom Group Button -On click",
						"User able to click on group name of item type sites and families ", "PASS");
				Thread.sleep(6000);
				validateDetailsOnSitesAndFamiliesGroupname(driver);
				Thread.sleep(6000);
			}
			else
			{
				System.out.println("not able to see grid details");
				Report.put("Precondition : When a user  User clicks on select 'hyperlink' for any group name of the type 'Sites and Product Families' for viewing ",
						"User should be taken to the details page with the 'contents' as below:1.Title (Custom Group Name) 2.Custom Group Name field (view only) 3.Custom Group Description (View only) 4.Selected Items tab 5.Asset Preview tab 6.Selected Sites section 7.In this use case , all the selected sites should be listed one below another <br> 8.Selected Product Families section 9.List of Product Families selected so far(Example -if 10 Product Families are selected ,all 10 should be displayed like below)>>Isilon (n Assets)>>VMAX (n Assets)>>PowerEdge (n Assets)>>Cloud Products (n Assets) >>Dell Networking (n Assets) 10.Back to Custom Groups link -Should redirect the user to list of custom groups page 11.Edit Selected Items button-On click should direct the users to edit page 12.Delete Custom Group Button -On click",
						"User failed to see grid details", "Fail");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Precondition : When a user  User clicks on select 'hyperlink' for any group name of the type 'Sites and Product Families' for viewing ",
					"User should be taken to the details page with the 'contents' as below:1.Title (Custom Group Name) 2.Custom Group Name field (view only) 3.Custom Group Description (View only) 4.Selected Items tab 5.Asset Preview tab 6.Selected Sites section 7.In this use case , all the selected sites should be listed one below another <br> 8.Selected Product Families section 9.List of Product Families selected so far(Example -if 10 Product Families are selected ,all 10 should be displayed like below)>>Isilon (n Assets)>>VMAX (n Assets)>>PowerEdge (n Assets)>>Cloud Products (n Assets) >>Dell Networking (n Assets) 10.Back to Custom Groups link -Should redirect the user to list of custom groups page 11.Edit Selected Items button-On click should direct the users to edit page 12.Delete Custom Group Button -On click",
					"User failed to see grid details", "Fail");
			Assert.fail();
		}
	}
	public void validateDetailsOnSitesAndFamiliesGroupname(WebDriver driver)
	{

		Log.info("Inside validateDetailsOnSitesAndFamiliesGroupname method");
		String item=TestNGCreator.TestData.get(Esupport.SearchOption.ordinal());
		String button = "";
		String header="";
		String totaloptions="";
		String details="";
		String columns="";
		String details2="";
		WebDriverWait wait = new WebDriverWait(driver, 600);
		try
		{

			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_UnifiedPortalPage.BackToCustomGroupsButton()))
			{

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.BackToCustomGroupsButton());
				button=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.BackToCustomGroupsButton()).getText();
				System.out.println(button);


				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.CustomGroupNameOnDetailsPage());
				header=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.CustomGroupNameOnDetailsPage()).getText();
				System.out.println(header);

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.CustomGroupNameAndDescriptionHeaderOnDetailsPage());
				List<WebElement> list=driver.findElements(obj_UnifiedPortalPage.CustomGroupNameAndDescriptionHeaderOnDetailsPage());

				for(WebElement lt:list)
				{
					CommonUtility.highlightElement(driver, lt);
					String option=lt.getText();
					totaloptions+="<br>"+option;
				}
				System.out.println(totaloptions);
				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.CustomGroupNameAndDescriptionDetailsOnDetailsPage());
				List<WebElement> list1=driver.findElements(obj_UnifiedPortalPage.CustomGroupNameAndDescriptionDetailsOnDetailsPage());

				for(WebElement lt:list1)
				{
					CommonUtility.highlightElement(driver, lt);
					String option=lt.getAttribute("placeholder");
					details+="<br>"+option;
				}
				System.out.println(details);

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.SelectedItemsTab());
				String tab1=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.SelectedItemsTab()).getText();
				System.out.println(tab1);

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.AssetPreviewTab());
				String tab2=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.AssetPreviewTab()).getText();
				System.out.println(tab2);

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.SelectedSitesOrProductFamiliesColumns());
				List<WebElement> list2=driver.findElements(obj_UnifiedPortalPage.SelectedSitesOrProductFamiliesColumns());

				for(WebElement lt:list2)
				{
					CommonUtility.highlightElement(driver, lt);
					String option=lt.getText();
					columns+=option;
				}
				System.out.println(columns);
				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.SelectedSitesAndProduuctFamiliesDetails());
				List<WebElement> list3=driver.findElements(obj_UnifiedPortalPage.SelectedSitesAndProduuctFamiliesDetails());

				for(WebElement lt:list3)
				{
					CommonUtility.highlightElement(driver, lt);
					String option=lt.getText();
					details2+=option;
				}
				System.out.println(details2);

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.EditSelectedItemsTab());
				String Edittab=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.EditSelectedItemsTab()).getText();
				System.out.println(Edittab);

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.DeleteCustomGroupTab());
				String deletetab=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.DeleteCustomGroupTab()).getText();
				System.out.println(deletetab);

				Report.put("Precondition : When a user  User clicks on select 'hyperlink' for any group name of the type 'Sites and Product Families' for viewing ",
						"User should be taken to the details page with the 'contents' as below:1.Title (Custom Group Name) 2.Custom Group Name field (view only) 3.Custom Group Description (View only) 4.Selected Items tab 5.Asset Preview tab 6.Selected Sites section 7.In this use case , all the selected sites should be listed one below another <br> 8.Selected Product Families section 9.List of Product Families selected so far(Example -if 10 Product Families are selected ,all 10 should be displayed like below)>>Isilon (n Assets)>>VMAX (n Assets)>>PowerEdge (n Assets)>>Cloud Products (n Assets) >>Dell Networking (n Assets) 10.Back to Custom Groups link -Should redirect the user to list of custom groups page 11.Edit Selected Items button-On click should direct the users to edit page 12.Delete Custom Group Button -On click",
						"User able to see 1. "+Report.color(button)+" with 2.title "+Report.color(header)
						+" 3. Custom group "+Report.color(totaloptions+" 4. along with "+details)
						+" 5. "+Report.color(tab1+" and 6. "+tab2)+" 7. "+Report.color(columns+" and 8. "+details2)
						+"9. "+Report.color(Edittab+" and 10. "+deletetab), "PASS");
			}
			else
			{
				System.out.println("not able to see expected details");
				Report.put("Precondition : When a user  User clicks on select 'hyperlink' for any group name of the type 'Sites and Product Families' for viewing ",
						"User should be taken to the details page with the 'contents' as below:1.Title (Custom Group Name) 2.Custom Group Name field (view only) 3.Custom Group Description (View only) 4.Selected Items tab 5.Asset Preview tab 6.Selected Sites section 7.In this use case , all the selected sites should be listed one below another <br> 8.Selected Product Families section 9.List of Product Families selected so far(Example -if 10 Product Families are selected ,all 10 should be displayed like below)>>Isilon (n Assets)>>VMAX (n Assets)>>PowerEdge (n Assets)>>Cloud Products (n Assets) >>Dell Networking (n Assets) 10.Back to Custom Groups link -Should redirect the user to list of custom groups page 11.Edit Selected Items button-On click should direct the users to edit page 12.Delete Custom Group Button -On click",
						"User failed to see expected details", "Fail");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Precondition : When a user  User clicks on select 'hyperlink' for any group name of the type 'Sites and Product Families' for viewing ",
					"User should be taken to the details page with the 'contents' as below:1.Title (Custom Group Name) 2.Custom Group Name field (view only) 3.Custom Group Description (View only) 4.Selected Items tab 5.Asset Preview tab 6.Selected Sites section 7.In this use case , all the selected sites should be listed one below another <br> 8.Selected Product Families section 9.List of Product Families selected so far(Example -if 10 Product Families are selected ,all 10 should be displayed like below)>>Isilon (n Assets)>>VMAX (n Assets)>>PowerEdge (n Assets)>>Cloud Products (n Assets) >>Dell Networking (n Assets) 10.Back to Custom Groups link -Should redirect the user to list of custom groups page 11.Edit Selected Items button-On click should direct the users to edit page 12.Delete Custom Group Button -On click",
					"User failed to see expected details", "Fail");
			Assert.fail();
		}
	}

	public void validateFilterSectionInCustomGroupGrid(WebDriver driver, String search)
	{

		Log.info("Inside validateFilterSectionInCustomGroupGrid method");

		String button = "";

		WebDriverWait wait = new WebDriverWait(driver, 600);
		try
		{
			Thread.sleep(10000);
			CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.FilterSearchBoxOnCustomeGroupMAinGrid());
			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_UnifiedPortalPage.FilterSearchBoxOnCustomeGroupMAinGrid()))
			{

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.FilterSearchBoxOnCustomeGroupMAinGrid());
				CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.FilterSearchBoxOnCustomeGroupMAinGrid()).clear();
				CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.FilterSearchBoxOnCustomeGroupMAinGrid()).sendKeys(search);

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.FilterIconInCustomGroupGrid());
				CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.FilterIconInCustomGroupGrid());

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.XButonToClearFilter());

				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_UnifiedPortalPage.HighlightedTextValidation()));
				List<WebElement> list=driver.findElements(obj_UnifiedPortalPage.HighlightedTextValidation());

				for(int i=0;i<list.size();i++)
				{
					CommonUtility.highlightElement(driver, list.get(i));
				}

				Report.put("Verify the filter options ",
						"User should be able to filter on the list of Custom groups using the following options with a 'X' clear option Group Name, Description, Items, Modified",
						"User able to search using filter and able to see searched option highlighted and able to see clear (X) option", "PASS");

			}
			else
			{
				System.out.println("not able to see filter text box");
				Report.put("Verify the filter options ",
						"User should be able to filter on the list of Custom groups using the following options with a 'X' clear option Group Name, Description, Items, Modified",
						"User not able to see filter text box", "Fail");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify the filter options ",
					"User should be able to filter on the list of Custom groups using the following options with a 'X' clear option Group Name, Description, Items, Modified",
					"User not able to see filter text box", "Fail");
			Assert.fail();
		}
	}

	public void clickOnXButtonOfFilterClearInCustomGrid(WebDriver driver)
	{

		Log.info("Inside clickOnXButtonOfFilterClearInCustomGrid method");

		String button = "";

		WebDriverWait wait = new WebDriverWait(driver, 600);
		try
		{

			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_UnifiedPortalPage.XButonToClearFilter()))
			{

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.XButonToClearFilter());

				CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.XButonToClearFilter());
				Thread.sleep(6000);

				if(CommonUtility.CheckpresenceofElementLocated(driver,10,obj_UnifiedPortalPage.XButonToClearFilter()))
				{
					System.out.println("able to see highlighted search in the grid");
					Report.put("Verify that user is able to clear filter using X icon or Clear All option",
							"User should be able to 'Clear All' using the 'X' icon -this should clear all the filter settings and render the grid default view",
							"User able to see searched view in grid", "Fail");
					Assert.fail();
				}
				else
				{
					System.out.println("not able to see X button");
				}

				Report.put("Verify that user is able to clear filter using X icon or Clear All option",
						"User should be able to 'Clear All' using the 'X' icon -this should clear all the filter settings and render the grid default view",
						"User able to see data refresh and display grid", "PASS");

			}
			else
			{
				System.out.println("not able to see X button");
				Report.put("Verify that user is able to clear filter using X icon or Clear All option",
						"User should be able to 'Clear All' using the 'X' icon -this should clear all the filter settings and render the grid default view",
						"User not able to see X button", "Fail");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify that user is able to clear filter using X icon or Clear All option",
					"User should be able to 'Clear All' using the 'X' icon -this should clear all the filter settings and render the grid default view",
					"User not able to see X button", "Fail");
			Assert.fail();
		}
	}


	public void SortingColumnsInCustomGroupGridColumns(WebDriver driver)
	{

		Log.info("Inside SortingColumnsInCustomGroupGridColumns method");

		String assertid = ""; String assertclass="";
		String Prodname=""; String prodclass="";
		String nickname="";String nickclass="";
		String siteid="";String siteidclass="";
		String sitedetils=""; String sitedetclass="";

		WebDriverWait wait = new WebDriverWait(driver, 600);
		try
		{

			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_UnifiedPortalPage.GroupNameSorting()))
			{	
				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.GroupNameSorting());
				assertid=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.GroupNameSorting()).getText();
				System.out.println("column name is "+assertid);
				CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.GroupNameSorting());

				Thread.sleep(6000);
				assertclass=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.GroupNameSorting()).getAttribute("class");
				System.out.println("class is "+assertclass);

				if(!(assertclass.contains("sorting_desc")|| assertclass.contains("sorting_asc")))
				{
					System.out.println("not able to see group name sorting");
					Report.put("User verifies sort on the following columns in ascending and descending order ",
							" User should be able to sort the list of custom groups on the table grid for following columns:Group Name,Description,Modified User should be able to sort in both in ascending and descending orders The sorting should consider all the results ,not just the rows displayed on the page",
							"User not able to see group name sorting", "Fail");
					Assert.fail();
				}

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.DescriptionSorting());
				Prodname=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.DescriptionSorting()).getText();
				System.out.println("column name is "+Prodname);
				CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.DescriptionSorting());

				Thread.sleep(6000);
				prodclass=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.DescriptionSorting()).getAttribute("class");
				System.out.println("class is "+prodclass);

				if(!(prodclass.contains("sorting_desc")|| prodclass.contains("sorting_asc")))
				{
					System.out.println("not able to see description sorting");
					Report.put("User verifies sort on the following columns in ascending and descending order ",
							" User should be able to sort the list of custom groups on the table grid for following columns:Group Name,Description,Modified User should be able to sort in both in ascending and descending orders The sorting should consider all the results ,not just the rows displayed on the page",
							"User not able to see description sorting", "Fail");
					Assert.fail();
				}

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.ItemsSorting());
				nickname=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.ItemsSorting()).getText();
				System.out.println("column name is "+nickname);
				CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.ItemsSorting());

				Thread.sleep(6000);
				nickclass=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.ItemsSorting()).getAttribute("class");
				System.out.println("class is "+nickclass);

				if(!(nickclass.contains("sorting_desc")|| nickclass.contains("sorting_asc")))
				{
					System.out.println("not able to see item sorting sorting");
					Report.put("User verifies sort on the following columns in ascending and descending order ",
							" User should be able to sort the list of custom groups on the table grid for following columns:Group Name,Description,Modified User should be able to sort in both in ascending and descending orders The sorting should consider all the results ,not just the rows displayed on the page",
							"User not able to see item sorting sorting", "Fail");
					Assert.fail();
				}

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.ModifiedSorting());
				siteid=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.ModifiedSorting()).getText();
				System.out.println("column name is "+siteid);
				CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.ModifiedSorting());

				Thread.sleep(6000);
				siteidclass=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.ModifiedSorting()).getAttribute("class");
				System.out.println("class is "+siteidclass);

				if(!(siteidclass.contains("sorting_desc")|| siteidclass.contains("sorting_asc")))
				{
					System.out.println("not able to see modified column sorting");
					Report.put("User verifies sort on the following columns in ascending and descending order ",
							" User should be able to sort the list of custom groups on the table grid for following columns:Group Name,Description,Modified User should be able to sort in both in ascending and descending orders The sorting should consider all the results ,not just the rows displayed on the page",
							"User not able to see  modified column  sorting", "Fail");
					Assert.fail();
				}




				Report.put("User verifies sort on the following columns in ascending and descending order ",
						" User should be able to sort the list of custom groups on the table grid for following columns:Group Name,Description,Modified User should be able to sort in both in ascending and descending orders The sorting should consider all the results ,not just the rows displayed on the page",
						"User able to sort all columns in ascending and descending", "PASS");

			}
			else
			{
				System.out.println("not able to sort column names");
				Report.put("User verifies sort on the following columns in ascending and descending order ",
						" User should be able to sort the list of custom groups on the table grid for following columns:Group Name,Description,Modified User should be able to sort in both in ascending and descending orders The sorting should consider all the results ,not just the rows displayed on the page",
						"User not able to sort column names", "Fail");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("User verifies sort on the following columns in ascending and descending order ",
					" User should be able to sort the list of custom groups on the table grid for following columns:Group Name,Description,Modified User should be able to sort in both in ascending and descending orders The sorting should consider all the results ,not just the rows displayed on the page",
					"User not able to sort column names", "Fail");
			Assert.fail();
		}
	}

	public void verifyDownloadOption(WebDriver driver)
	{

		Log.info("Inside verifyDownloadOption method");

		String download = ""; 

		WebDriverWait wait = new WebDriverWait(driver, 600);
		try
		{

			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_UnifiedPortalPage.DownloadButtonInCustonmGroup()))
			{	
				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.DownloadButtonInCustonmGroup());
				download=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.DownloadButtonInCustonmGroup()).getText();
				System.out.println("hyperlink is "+download);


				Report.put("Verify the Download option is displayed",
						"The Download link should be displayed at the top of the list view",
						"User able to see "+Report.color(download)+" hyperlink at top of the grid", "PASS");

			}
			else
			{
				System.out.println("failed to see download hyperlink");
				Report.put("Verify the Download option is displayed",
						"The Download link should be displayed at the top of the list view",
						"User failed to see download hyperlink", "Fail");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify the Download option is displayed",
					"The Download link should be displayed at the top of the list view",
					"User failed to see download hyperlink", "Fail");
			Assert.fail();
		}
	}

	public void verifyClickingDownloadOption(WebDriver driver)
	{

		Log.info("Inside verifyClickingDownloadOption method");

		String download = ""; 

		WebDriverWait wait = new WebDriverWait(driver, 600);
		try
		{

			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_UnifiedPortalPage.DownloadButtonInCustonmGroup()))
			{	
				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.DownloadButtonInCustonmGroup());
				download=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.DownloadButtonInCustonmGroup()).getText();
				System.out.println("hyperlink is "+download);
				CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.DownloadButtonInCustonmGroup());

				Report.put("Click on the Download link",
						"The user should be able to download (export) the filtered results on the table grid and should be able to download in CSV/PDF formats",
						"User able to click on "+Report.color(download)+" hyperlink and successfully downloaded CSV formats", "PASS");

			}
			else
			{
				System.out.println("failed to see download hyperlink");
				Report.put("Click on the Download link",
						"The user should be able to download (export) the filtered results on the table grid and should be able to download in CSV/PDF formats",
						"User failed to see download hyperlink", "Fail");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on the Download link",
					"The user should be able to download (export) the filtered results on the table grid and should be able to download in CSV/PDF formats",
					"User failed to see download hyperlink", "Fail");
			Assert.fail();
		}
	}

	public void VerifyPageNumbersDisplayingUnderPaginationSection_SitesAndFamilies(WebDriver driver)
	{

		Log.info("VerifyPageNumbersDisplayingUnderPaginationSection_SitesAndFamilies");	
		WebDriverWait wait = new WebDriverWait(driver, 120);
		String text="";
		String testcase=TestNGCreator.TestData.get(Esupport.TestCaseID.ordinal());

		try
		{
			if(testcase.contains("8385233"))
			{
				if(CommonUtility.CheckpresenceofElementLocated(driver, 15, obj_UnifiedPortalPage.PageinPaginationInSitesAndFamilies()))
				{

					CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.PageinPaginationInSitesAndFamilies());
					String pagesdisplayed=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.PageinPaginationInSitesAndFamilies()).getText();
					System.out.println(pagesdisplayed);

					CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.PageNoTextPaginationInSitesAndFamilies());
					text=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.PageNoTextPaginationInSitesAndFamilies()).getText(); 
					System.out.println(text);

					CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.NumberOfPagesInPaginationInSitesAndFamilies());
					String noofpages=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.NumberOfPagesInPaginationInSitesAndFamilies()).getText(); 
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
			else
			{
				if(CommonUtility.CheckpresenceofElementLocated(driver, 15, obj_UnifiedPortalPage.PaginationInCustomGroup()))
				{

					CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.PageinPaginationInSitesAndFamilies());
					String pagesdisplayed=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.PageinPaginationInSitesAndFamilies()).getText();
					System.out.println(pagesdisplayed);

					CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.PageNoTextPaginationInSitesAndFamilies());
					text=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.PageNoTextPaginationInSitesAndFamilies()).getText(); 
					System.out.println(text);

					CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.NumberOfPagesInPaginationInSitesAndFamilies());
					String noofpages=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.NumberOfPagesInPaginationInSitesAndFamilies()).getText(); 
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

	public void ValidatePreviousWillBeGreyedOutWhenUserIsOn1stPageIfMoreThanOnePagePresent_SitesAndFamilies(WebDriver driver)
	{

		Log.info("Entering ValidatePreviousWillBeGreyedOutWhenUserIsOn1stPageIfMoreThanOnePagePresent_SitesAndFamilies method");	
		WebDriverWait wait = new WebDriverWait(driver, 120);
		String text="";
		String testcase=TestNGCreator.TestData.get(Esupport.TestCaseID.ordinal());
		try
		{
			if(testcase.contains("8385233"))
			{
				if(CommonUtility.CheckpresenceofElementLocated(driver, 15, obj_UnifiedPortalPage.PageNoTextPaginationInSitesAndFamilies()))
				{

					CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.PageNoTextPaginationInSitesAndFamilies());
					String pagesdisplayed=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.PageNoTextPaginationInSitesAndFamilies()).getText();
					System.out.println(pagesdisplayed);

					if(pagesdisplayed.equals("1"))
					{

						CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.FirstPageArrowMarkInAddCustGroupInSitesAndFamilies());
						CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.FirstPageArrowMarkInAddCustGroupInSitesAndFamilies());

						CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.PreviousPageArrowMarkInAddCustGroupInSitesAndFamilies());
						CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.PreviousPageArrowMarkInAddCustGroupInSitesAndFamilies());

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
			else
			{

				if(CommonUtility.CheckpresenceofElementLocated(driver, 15, obj_UnifiedPortalPage.PageNoTextPaginationInSitesAndFamilies()))
				{

					CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.PageNoTextPaginationInSitesAndFamilies());
					String pagesdisplayed=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.PageNoTextPaginationInSitesAndFamilies()).getText();
					System.out.println(pagesdisplayed);

					if(pagesdisplayed.equals("1"))
					{

						CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.FirstPageArrowMarkInAddCustGroupInSitesAndFamilies());
						CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.FirstPageArrowMarkInAddCustGroupInSitesAndFamilies());

						CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.PreviousPageArrowMarkInAddCustGroupInSitesAndFamilies());
						CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.PreviousPageArrowMarkInAddCustGroupInSitesAndFamilies());

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
	public void ValidateNextWillBeGreyedOutWhenUserIsOnLastPageIfMoreThanOnePagePresent_SitesAndFamilies(WebDriver driver)
	{

		Log.info("Entering ValidateNextWillBeGreyedOutWhenUserIsOnLastPageIfMoreThanOnePagePresent_SitesAndFamilies method");	
		WebDriverWait wait = new WebDriverWait(driver, 120);
		String text="";
		String testcase=TestNGCreator.TestData.get(Esupport.TestCaseID.ordinal());
		try
		{
			if(testcase.contains("8385233"))
			{
				if(CommonUtility.CheckpresenceofElementLocated(driver, 15, obj_UnifiedPortalPage.LastPageArrowMarkInAddCustGroupInSitesAndFamilies()))
				{

					CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.LastPageArrowMarkInAddCustGroupInSitesAndFamilies());
					CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.LastPageArrowMarkInAddCustGroupInSitesAndFamilies());

					wait.until(ExpectedConditions.visibilityOfElementLocated(obj_UnifiedPortalPage.PageNoTextPaginationInSitesAndFamilies()));
					String pagesdisplayed=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.PageNoTextPaginationInSitesAndFamilies()).getText();
					System.out.println(pagesdisplayed);

					if(!(pagesdisplayed.equals("1")))
					{

						CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.NextPageArrowMarkInAddCustGroupInSitesAndFamilies());
						CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.NextPageArrowMarkInAddCustGroupInSitesAndFamilies());

						CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.LastPageArrowMarkInAddCustGroupInSitesAndFamilies());
						CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.LastPageArrowMarkInAddCustGroupInSitesAndFamilies());

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
			else
			{
				if(CommonUtility.CheckpresenceofElementLocated(driver, 15, obj_UnifiedPortalPage.LastPageArrowMarkInAddCustGroupInSitesAndFamilies()))
				{

					CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.LastPageArrowMarkInAddCustGroupInSitesAndFamilies());
					CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.LastPageArrowMarkInAddCustGroupInSitesAndFamilies());

					wait.until(ExpectedConditions.visibilityOfElementLocated(obj_UnifiedPortalPage.PageNoTextPaginationInSitesAndFamilies()));
					String pagesdisplayed=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.PageNoTextPaginationInSitesAndFamilies()).getText();
					System.out.println(pagesdisplayed);

					if(!(pagesdisplayed.equals("1")))
					{

						CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.NextPageArrowMarkInAddCustGroupInSitesAndFamilies());
						CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.NextPageArrowMarkInAddCustGroupInSitesAndFamilies());

						CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.LastPageArrowMarkInAddCustGroupInSitesAndFamilies());
						CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.LastPageArrowMarkInAddCustGroupInSitesAndFamilies());

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

	public void validateGridOFCustomGroup(WebDriver driver)
	{

		Log.info("Inside validateGridOFCustomGroup method");

		String button = "";

		try
		{

			if(CommonUtility.CheckpresenceofElementLocated(driver,33,obj_UnifiedPortalPage.CustomGroupGridTable()))
			{
				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.CustomGroupGridTable());	


				Report.put("Verify the grid page  ",
						"The list of Custom groups that the user has previously created should be displayed ",
						"User able to see "+Report.color(button)+" button", "PASS");
			}
			else
			{
				System.out.println("failed to see previous custon groupd list in grid");
				Report.put("Verify the grid page  ",
						"The list of Custom groups that the user has previously created should be displayed ",
						"User failed to see previous custon groupd list in grid", "Fail");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify the grid page  ",
					"The list of Custom groups that the user has previously created should be displayed ",
					"User failed to see previous custon groupd list in grid", "Fail");
			Assert.fail();
		}
	}

	public void verifyDetailsInCustomGroupGrid(WebDriver driver)
	{

		Log.info("Inside verifyDetailsInCustomGroupGrid method");

		String button = "";
		String header = "";
		String hide="";
		String labelList="";
		String groupnames=""; String description="";String items="";String modified="";
		WebDriverWait wait = new WebDriverWait(driver, 240);
		try
		{

			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_UnifiedPortalPage.ColumnNamesInTheGridOfCustomGroups()))
			{

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.ColumnNamesInTheGridOfCustomGroups());	
				List<WebElement> list=driver.findElements(obj_UnifiedPortalPage.ColumnNamesInTheGridOfCustomGroups());

				for(WebElement lt:list)
				{
					CommonUtility.highlightElement(driver, lt);
					String label=lt.getText();
					labelList+=" <br> " + label;
				}
				System.out.println("column names are:"+labelList);

				Report.put("Verify the details displayed",
						"The following details should be displayed 1. 'Custom Groups' title with a description 2. Add Custom Group tab (On click will be created as a separate story) 3. Group Name :Name of the Custom group;Sorting should always be done on the 'Modified Date' in descending order (last modified should show up on the top of the list) 4. Description:Description of the Custom group",
						"User able to see title, Add Custom Group tab and Grid details with columns "+Report.color(labelList), "PASS");

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.CustomGroupNamesDisplayedInGrid());	
				List<WebElement> list1=driver.findElements(obj_UnifiedPortalPage.CustomGroupNamesDisplayedInGrid());

				for(WebElement lt:list1)
				{
					CommonUtility.highlightElement(driver, lt);
					String label=lt.getText();
					groupnames+=" <br> " + label;
				}
				System.out.println("group names are:"+groupnames);

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.DescriptionDetailsOfCustomGroupInGrid());	
				List<WebElement> list2=driver.findElements(obj_UnifiedPortalPage.DescriptionDetailsOfCustomGroupInGrid());

				for(WebElement lt:list2)
				{
					CommonUtility.highlightElement(driver, lt);
					String label=lt.getText();
					description+=" <br> " + label;
				}
				System.out.println("description:"+description);


				Report.put("Verify the details displayed",
						"The following details should be displayed 1. 'Custom Groups' title with a description 2. Add Custom Group tab (On click will be created as a separate story) 3. Group Name :Name of the Custom group;Sorting should always be done on the 'Modified Date' in descending order (last modified should show up on the top of the list) 4. Description:Description of the Custom group",
						"User able to see group names "+Report.color(groupnames)+" and description details "+Report.color(description), "PASS");


				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.ItemsDetailsInCustomGroupGrid());	
				List<WebElement> list3=driver.findElements(obj_UnifiedPortalPage.ItemsDetailsInCustomGroupGrid());

				for(WebElement lt:list3)
				{
					CommonUtility.highlightElement(driver, lt);
					String label=lt.getText();
					items+=" <br> " + label;
				}
				System.out.println("items are :"+items);

				Report.put("Verify the Items count  ",
						"Items displayed with for this phase we will only display the type -Sites,Sites and Product Families ,Product Families,Products",
						"User able to see iems with details "+Report.color(items), "PASS");

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.ModifiedDetailsInGrid());	
				List<WebElement> list4=driver.findElements(obj_UnifiedPortalPage.ModifiedDetailsInGrid());

				for(WebElement lt:list4)
				{
					CommonUtility.highlightElement(driver, lt);
					String label=lt.getText();
					modified+=" <br> " + label;
				}
				System.out.println("modified dates :"+modified);

				Report.put("Verify the Modified section",
						"The Modified should display the Last modified date ",
						"User able to see modified details "+Report.color(modified), "PASS");

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.ActionsDetailsInGrid());	
				List<WebElement> list5=driver.findElements(obj_UnifiedPortalPage.ActionsDetailsInGrid());

				for(WebElement lt:list5)
				{
					CommonUtility.ScrollToWebElement(driver, lt);

				}
				System.out.println("able to see edit and delete");

				Report.put("Verify the actions ",
						"The Actions column should be displayed with Delete and Edit icons ",
						"User able to see Action columns Delete and Edit", "PASS");

			}
			else
			{
				System.out.println("failed to see column names in custom group grid");
				Report.put("Verify the details displayed",
						"The following details should be displayed 1. 'Custom Groups' title with a description 2. Add Custom Group tab (On click will be created as a separate story) 3. Group Name :Name of the Custom group;Sorting should always be done on the 'Modified Date' in descending order (last modified should show up on the top of the list) 4. Description:Description of the Custom group",
						"Userfailed to see column names in custom group grid", "Fail");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify the details displayed",
					"The following details should be displayed 1. 'Custom Groups' title with a description 2. Add Custom Group tab (On click will be created as a separate story) 3. Group Name :Name of the Custom group;Sorting should always be done on the 'Modified Date' in descending order (last modified should show up on the top of the list) 4. Description:Description of the Custom group",
					"Userfailed to see column names in custom group grid", "Fail");
			Assert.fail();
		}
	}


	public void  ChangeEmailInProductAdvisoryAndValidatePopUp(WebDriver driver) 
	{

		Log.info("Inside ChangeEmailInProductAdvisoryAndValidatePopUp method");

		String header = "";String text="";String text1="";String text2="";
		String popupheader="";String popupdetails="";String cancel="";String submit="";


		WebDriverWait  wait = new WebDriverWait(driver, 60);	
		try
		{
			handleCookies(driver);
			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_UnifiedPortalPage.DeliveryPreferencesSection()))
			{
				//			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_UnifiedPortalPage.DeliveryPreferencesSection()));
				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.DeliveryPreferencesSection());
				//				CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.ProductAdvisoriesTab()).click();
				text=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.DeliveryPreferencesSection()).getText();
				System.out.println(text);


				header = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.HelpTextAsSelectYourDefaultEmailAddress()).getText();

				System.out.println(header);

				text1 = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.EmailField()).getText();

				System.out.println(text1);

				text2 = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.EmailSelectedByDefault()).getText();

				System.out.println(text2);

				WebElement element=driver.findElement(By.xpath("//select[@id='product-advisory-events_email']"));
				Select s=new Select(element);

				List<WebElement> list= s.getOptions();
				int countlist=list.size();
				System.out.println("count of drop down values are "+countlist);

				for(int i=0;i<countlist;i++)
				{
					text+="<br>"+list.get(i).getText();
					System.out.println("issue list "+text);

				}
				s.selectByValue("1");



				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_UnifiedPortalPage.DeliveryPreferenceNoticeHeadingInPopUp()));
				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.DeliveryPreferenceNoticeHeadingInPopUp());
				popupheader = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.DeliveryPreferenceNoticeHeadingInPopUp()).getText();

				System.out.println("Header is: "+popupheader);

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.DeliveryPreferencesDetails());
				popupdetails = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.DeliveryPreferencesDetails()).getText();

				System.out.println("Details are "+popupdetails);

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.DeliveryPreferencesCancelButton());
				cancel = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.DeliveryPreferencesCancelButton()).getText();

				System.out.println("button is "+cancel);

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.DeliveryPreferencesConfirmButton());
				submit = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.DeliveryPreferencesConfirmButton()).getText();

				System.out.println("button is "+submit);

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.DeliveryPreferencesCancelButton());
				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.DeliveryPreferencesCancelButton());

				Report.put("User tries to change the preferred email address from the \"Delivery Preferences\" email drop down",
						"User should be able to see a warning message displayed :Updating the delivery preferences will affect all Product Update notifications, but will only affect newly created Product Advisory alerts.Learn how to update your existing Product Advisories.", 
						"Selecting different email user able to see pop up "+Report.color(popupheader)+" header with alert text "+Report.color(popupdetails)+" along with "+Report.color(cancel+" and "+submit)+" buttons", "PASS");
			}
			else
			{
				Report.put("User tries to change the preferred email address from the \"Delivery Preferences\" email drop down",
						"User should be able to see a warning message displayed :Updating the delivery preferences will affect all Product Update notifications, but will only affect newly created Product Advisory alerts.Learn how to update your existing Product Advisories.", 
						"Failed to change email in product advisories", "FAIL");
				Assert.fail();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("User tries to change the preferred email address from the \"Delivery Preferences\" email drop down",
					"User should be able to see a warning message displayed :Updating the delivery preferences will affect all Product Update notifications, but will only affect newly created Product Advisory alerts.Learn how to update your existing Product Advisories.", 
					"Failed to change email in product advisories", "FAIL");
			Assert.fail();
		}
	}

	public void  ChangeEmailInProductUpdates_ValidateAlermessagePopup(WebDriver driver) 
	{

		Log.info("Inside ChangeEmailInProductUpdates_ValidateAlermessagePopup method");

		String header = "";
		String text="";
		String text1="";
		String text2="";
		String popupheader="";String popupdetails="";String cancel="";String submit="";


		WebDriverWait  wait = new WebDriverWait(driver, 60);	
		try
		{
			//	handleCookies(driver);
			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_UnifiedPortalPage.DeliveryPreferencesSectionInProductUpdates()))
			{
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_UnifiedPortalPage.DeliveryPreferencesSectionInProductUpdates()));

				//				CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.ProductAdvisoriesTab()).click();
				text=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.DeliveryPreferencesHeadingInProductUpdates()).getText();
				System.out.println(text);



				text1 = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.GetEmailDisplayedDefaultValueInProductUpdates()).getText();

				System.out.println(text1);
				WebElement element=driver.findElement(By.xpath("//select[@id='product-updates_email']"));
				Select s=new Select(element);

				List<WebElement> list= s.getOptions();
				int countlist=list.size();
				System.out.println("count of drop down values are "+countlist);

				for(int i=0;i<countlist;i++)
				{
					text+="<br>"+list.get(i).getText();
					System.out.println("issue list "+text);

				}
				s.selectByValue("1");

				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_UnifiedPortalPage.DeliveryPreferenceNoticeHeadingInPopUp()));
				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.DeliveryPreferenceNoticeHeadingInPopUp());
				popupheader = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.DeliveryPreferenceNoticeHeadingInPopUp()).getText();

				System.out.println("Header is: "+popupheader);

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.DeliveryPreferencesDetails());
				popupdetails = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.DeliveryPreferencesDetails()).getText();

				System.out.println("Details are "+popupdetails);

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.DeliveryPreferencesCancelButton());
				cancel = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.DeliveryPreferencesCancelButton()).getText();

				System.out.println("button is "+cancel);

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.DeliveryPreferencesConfirmButton());
				submit = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.DeliveryPreferencesConfirmButton()).getText();

				System.out.println("button is "+submit);

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.DeliveryPreferencesCancelButton());
				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.DeliveryPreferencesCancelButton());

				Report.put("User tries to  change the preferred email address from the \"Delivery Preferences\" email drop down ",
						"User should be able to see a warning message displayed :Updating the delivery preferences will affect all Product Update notifications, but will only affect newly created Product Advisory alerts.Learn how to update your existing Product Advisories", 
						"User able to see "+Report.color(text)+" and clicking on alternate email Id able to see see pop up "+Report.color(popupheader)+" header with alert text "+Report.color(popupdetails)+" along with "+Report.color(cancel+" and "+submit)+" buttons", "PASS");
			}
			else
			{
				Report.put("User tries to  change the preferred email address from the \"Delivery Preferences\" email drop down ",
						"User should be able to see a warning message displayed :Updating the delivery preferences will affect all Product Update notifications, but will only affect newly created Product Advisory alerts.Learn how to update your existing Product Advisories", 
						"Failed to change email in product updates", "FAIL");
				Assert.fail();
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("User tries to  change the preferred email address from the \"Delivery Preferences\" email drop down ",
					"User should be able to see a warning message displayed :Updating the delivery preferences will affect all Product Update notifications, but will only affect newly created Product Advisory alerts.Learn how to update your existing Product Advisories", 
					"Failed to change email in product updates", "FAIL");
			Assert.fail();
		}
	}


	public void editPersonalPreferenceAlternateEmail_ValidatePopUp(WebDriver driver, String email)
	{
		System.out.println("Inside editPersonalPreferenceAlternateEmail_ValidatePopUp method");

		String alternateEmail = "";
		String changedEmail = "";
		String errMessage = "";

		String popupheader="";String popupdetails="";String cancel="";String submit="";


		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);
			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_UnifiedPortalPage.EditButton()))
			{
				CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.CountrySelector());
				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.EditButton());
				CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.EditButton());

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.alternateEmailTextbox());
				CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.alternateEmailTextbox());

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.alternateEmailTextbox());
				alternateEmail = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.alternateEmailTextbox()).getAttribute("value");

				System.out.println("Alternate Email is: "+alternateEmail);


				CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.alternateEmailTextbox()).clear();
				CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.alternateEmailTextbox()).sendKeys(email);

				changedEmail = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.alternateEmailTextbox()).getAttribute("value");

				System.out.println("Changed Email is: "+changedEmail);

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.SaveButton());
				CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.SaveButton());

				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_UnifiedPortalPage.AlternateEmailNoticeHeaderPopUp()));
				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.AlternateEmailNoticeHeaderPopUp());
				popupheader = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.AlternateEmailNoticeHeaderPopUp()).getText();

				System.out.println("Header is: "+popupheader);

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.DeliveryPreferencesDetails());
				popupdetails = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.DeliveryPreferencesDetails()).getText();

				System.out.println("Details are "+popupdetails);

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.DeliveryPreferencesCancelButton());
				cancel = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.DeliveryPreferencesCancelButton()).getText();

				System.out.println("button is "+cancel);

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.DeliveryPreferencesConfirmButton());
				submit = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.DeliveryPreferencesConfirmButton()).getText();

				System.out.println("button is "+submit);

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.DeliveryPreferencesCancelButton());
				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.DeliveryPreferencesCancelButton());

				Report.put("User Clicks on the Edit button and tries to change the alternate email address from the \"Alternate Email\" textbox",
						"User should be able to see a warning message displayed : Updating the alternate email address will not update your existing Product Advisory alerts if you have your alternative email set as your preferred delivery method. Learn how to update the email for your existing Product Advisories.",
						"Alternate Email is displayed: "+Report.color(alternateEmail)+"Changing email to "+Report.color(changedEmail)+" and clicking on save user able to see pop up "+Report.color(popupheader)+" header with alert text "+Report.color(popupdetails)+" along with "+Report.color(cancel+" and "+submit)+" buttons", "PASS");
			}
			else
			{
				Report.put("User Clicks on the Edit button and tries to change the alternate email address from the \"Alternate Email\" textbox",
						"User should be able to see a warning message displayed : Updating the alternate email address will not update your existing Product Advisory alerts if you have your alternative email set as your preferred delivery method. Learn how to update the email for your existing Product Advisories.",
						"Failed to edit Alternate Email under Personal Preference", "FAIL");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();

			Report.put("User Clicks on the Edit button and tries to change the alternate email address from the \"Alternate Email\" textbox",
					"User should be able to see a warning message displayed : Updating the alternate email address will not update your existing Product Advisory alerts if you have your alternative email set as your preferred delivery method. Learn how to update the email for your existing Product Advisories.",
					"Failed to edit Alternate Email under Personal Preference", "FAIL");
			Assert.fail();
		}
	}


	public void EnterValuesInNameAndDescription(WebDriver driver, String desc)
	{

		Log.info("Inside EnterValuesInNameAndDescription method");

		String button = "";
		String header="";
		String header1="";
		String columnam="";
		String rownam="";String name=TestNGCreator.TestData.get(Esupport.FirstName.ordinal());

		WebDriverWait wait = new WebDriverWait(driver, 240);
		try
		{

			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_UnifiedPortalPage.CustomGroupNameTextBox()))
			{
				//				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.InstructionText());	
				CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.CountrySelector());
				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.CustomGroupNameTextBox());	
				CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.CustomGroupNameTextBox()).clear();
				CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.CustomGroupNameTextBox()).sendKeys(TestNGCreator.TestData.get(Esupport.FirstName.ordinal()));

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.CustomerGroupDescriptionTextBox());	
				CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.CustomerGroupDescriptionTextBox()).clear();
				CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.CustomerGroupDescriptionTextBox()).sendKeys(desc);


				Report.put("Once the user completes selection of group type ",
						"User should be allowed to enter Name (mandatory) and Description",
						"User able to enter name  "+Report.color(name)+" "+Report.color(desc), "PASS");

			}
			else
			{
				System.out.println("not able to see custom group name text box");
				Report.put("Once the user completes selection of group type ",
						"User should be allowed to enter Name (mandatory) and Description",
						"User not able to see custom group name text box", "Fail");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Once the user completes selection of group type ",
					"User should be allowed to enter Name (mandatory) and Description",
					"User not able to see custom group name text box", "Fail");
			Assert.fail();
		}
	}


	public void SelectOneOrMultipleAssetsInSitesGrid_Partner(WebDriver driver)
	{

		Log.info("Inside SelectOneOrMultipleAssetsInSitesGrid_Partner method");

		String button = "";

		WebDriverWait wait = new WebDriverWait(driver, 600);
		try
		{

			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_UnifiedPortalPage.SitesListInTable()))
			{

				CommonUtility.ScrollTo(driver, obj_UnifiedPortalPage.SitesListInTable());
//				List<WebElement> list1=driver.findElements(obj_UnifiedPortalPage.SitesListInTable());
//
//				int count3=list1.size();
//				System.out.println("total number of sites displayed in table "+count3);
//				int count2=0;
//				for(int i=0;i<7;i++)
//				{
//					count2++;
//
//					if(count2==3)
//					{
//						if (!(list1.get(i).isSelected())) 
//						{
//							try
//							{
//								CommonUtility.ScrollToWebElement(driver, list1.get(i));
//								CommonUtility.ClickOnWebElement(driver, list1.get(i));
//
//								Thread.sleep(3000);
//							}
//							catch(Exception e)
//							{
//
//							}
//						}
//					}
//
//
//				}
				Thread.sleep(15000);

				if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_UnifiedPortalPage.FiestCheckBox()))
				{

					if(CommonUtility.CheckpresenceofElementLocated(driver,10,obj_UnifiedPortalPage.FiestCheckBox()))
					{
						CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.FiestCheckBox());
						CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.FiestCheckBox());
					}

					if(CommonUtility.CheckpresenceofElementLocated(driver,10,obj_UnifiedPortalPage.SecCheckBox()))
					{
						CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.SecCheckBox());
						CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.SecCheckBox());
					}

					if(CommonUtility.CheckpresenceofElementLocated(driver,10,obj_UnifiedPortalPage.ThirdCheckBox()))
					{
						CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.ThirdCheckBox());
						CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.ThirdCheckBox());
					}

					if(CommonUtility.CheckpresenceofElementLocated(driver,10,obj_UnifiedPortalPage.ForthCheckBox()))
					{
						CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.ForthCheckBox());
						CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.ForthCheckBox());
					}

					if(CommonUtility.CheckpresenceofElementLocated(driver,10,obj_UnifiedPortalPage.FifthCheckBox()))
					{
						CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.FifthCheckBox());
						CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.FifthCheckBox());
					}
					if(CommonUtility.CheckpresenceofElementLocated(driver,10,obj_UnifiedPortalPage.SixCheckBox()))
					{
						CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.SixCheckBox());
						CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.SixCheckBox());
					}


				}
				else
				{
					System.out.println("not able to see asset IDs");
					Report.put("User selects one/multiple/all the assets",
							"'Add to Group' button is enabled; (IB status's  to be considered - Installed;Shipped;Awaiting Customer Install;Install-T&M )",
							"User not able to see asset IDs", "Fail");
					Assert.fail();
				}
				Thread.sleep(6000);
				if(CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.AddToGroupButtonInSitesGrid()).isEnabled())
				{
					CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.AddToGroupButtonInSitesGrid());
					button=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.AddToGroupButtonInSitesGrid()).getText();
					System.out.println("button is "+button);
				}
				else
				{
					System.out.println("not able to see add to group");
					Report.put("User selects one/multiple/all the assets",
							"'Add to Group' button is enabled; (IB status's  to be considered - Installed;Shipped;Awaiting Customer Install;Install-T&M )",
							"User not able to see add to group button", "Fail");
					Assert.fail();
				}



				Report.put("User selects one/multiple/all the assets",
						"'Add to Group' button is enabled; (IB status's  to be considered - Installed;Shipped;Awaiting Customer Install;Install-T&M )",
						"User able to select multiple assets, enabled "+Report.color(button)+" button", "PASS");

			}
			else
			{
				System.out.println("not able to see sites in table");
				Report.put("User selects one/multiple/all the assets",
						"'Add to Group' button is enabled; (IB status's  to be considered - Installed;Shipped;Awaiting Customer Install;Install-T&M )",
						"User not able to see sites in table", "Fail");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("User selects one/multiple/all the assets",
					"'Add to Group' button is enabled; (IB status's  to be considered - Installed;Shipped;Awaiting Customer Install;Install-T&M )",
					"User not able to see sites in table", "Fail");
			Assert.fail();
		}
	}

	public void SelectOneOrMultipleAssetsInSitesGrid_Partner_ED(WebDriver driver)
	{

		Log.info("Inside SelectOneOrMultipleAssetsInSitesGrid_Partner_ED method");

		String button = "";

		WebDriverWait wait = new WebDriverWait(driver, 600);
		try
		{

			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_UnifiedPortalPage.SitesListInTable()))
			{
				CommonUtility.ScrollTo(driver, obj_UnifiedPortalPage.SitesListInTable());
				//				WebElement element=driver.findElement(obj_UnifiedPortalPage.SitesListInTable());
				//				CommonUtility.ScrollTo(driver, obj_UnifiedPortalPage.SitesListInTable());
				//				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
				List<WebElement> list1=driver.findElements(obj_UnifiedPortalPage.SitesListInTable());

				int count3=list1.size();
				System.out.println("total number of sites displayed in table "+count3);
				int count2=0;
				for(int i=0;i<7;i++)
				{
					count2++;

					if(count2==3)
					{
						if (!(list1.get(i).isSelected())) 
						{
							try
							{
								CommonUtility.scrollToViewElement(driver, list1.get(i));
								CommonUtility.ClickOnWebElement(driver, list1.get(i));

								Thread.sleep(3000);
							}
							catch(Exception e)
							{

							}
						}
					}


				}
				Thread.sleep(15000);
				verifyDisplayedColumns(driver);
				if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_UnifiedPortalPage.FiestCheckBox()))
				{

					if(CommonUtility.CheckpresenceofElementLocated(driver,10,obj_UnifiedPortalPage.FiestCheckBox()))
					{
						CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.FiestCheckBox());
						CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.FiestCheckBox());
					}

					if(CommonUtility.CheckpresenceofElementLocated(driver,10,obj_UnifiedPortalPage.SecCheckBox()))
					{
						CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.SecCheckBox());
						CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.SecCheckBox());
					}

					if(CommonUtility.CheckpresenceofElementLocated(driver,10,obj_UnifiedPortalPage.ThirdCheckBox()))
					{
						CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.ThirdCheckBox());
						CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.ThirdCheckBox());
					}

					if(CommonUtility.CheckpresenceofElementLocated(driver,10,obj_UnifiedPortalPage.ForthCheckBox()))
					{
						CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.ForthCheckBox());
						CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.ForthCheckBox());
					}

					if(CommonUtility.CheckpresenceofElementLocated(driver,10,obj_UnifiedPortalPage.FifthCheckBox()))
					{
						CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.FifthCheckBox());
						CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.FifthCheckBox());
					}
					if(CommonUtility.CheckpresenceofElementLocated(driver,10,obj_UnifiedPortalPage.SixCheckBox()))
					{
						CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.SixCheckBox());
						CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.SixCheckBox());
					}


				}
				else
				{
					System.out.println("not able to see asset IDs");
					Report.put("User selects one/multiple/all the assets",
							"'Add to Group' button is enabled; (IB status's  to be considered - Installed;Shipped;Awaiting Customer Install;Install-T&M )",
							"User not able to see asset IDs", "Fail");
					Assert.fail();
				}
				Thread.sleep(6000);
				if(CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.AddToGroupButtonInSitesGrid()).isEnabled())
				{
					CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.AddToGroupButtonInSitesGrid());
					button=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.AddToGroupButtonInSitesGrid()).getText();
					System.out.println("button is "+button);
				}
				else
				{
					System.out.println("not able to see add to group");
					Report.put("User selects one/multiple/all the assets",
							"'Add to Group' button is enabled; (IB status's  to be considered - Installed;Shipped;Awaiting Customer Install;Install-T&M )",
							"User not able to see add to group button", "Fail");
					Assert.fail();
				}



				Report.put("User selects one/multiple/all the assets",
						"'Add to Group' button is enabled; (IB status's  to be considered - Installed;Shipped;Awaiting Customer Install;Install-T&M )",
						"User able to select multiple assets, enabled "+Report.color(button)+" button", "PASS");

			}
			else
			{
				System.out.println("not able to see sites in table");
				Report.put("User selects one/multiple/all the assets",
						"'Add to Group' button is enabled; (IB status's  to be considered - Installed;Shipped;Awaiting Customer Install;Install-T&M )",
						"User not able to see sites in table", "Fail");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("User selects one/multiple/all the assets",
					"'Add to Group' button is enabled; (IB status's  to be considered - Installed;Shipped;Awaiting Customer Install;Install-T&M )",
					"User not able to see sites in table", "Fail");
			Assert.fail();
		}
	}


	public void SelectOneOrMultipleAssetsInSitesGrid_Partner_IE(WebDriver driver)
	{

		Log.info("Inside SelectOneOrMultipleAssetsInSitesGrid_Partner_IE method");

		String button = "";

		WebDriverWait wait = new WebDriverWait(driver, 600);
		try
		{

			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_UnifiedPortalPage.SitesListInTable()))
			{


				List<WebElement> list1=driver.findElements(obj_UnifiedPortalPage.SitesListInTable());

				int count3=list1.size();
				System.out.println("total number of sites displayed in table "+count3);
				int count2=0;
				for(int i=0;i<7;i++)
				{
					count2++;

					if(count2==3)
					{
						if (!(list1.get(i).isSelected())) 
						{
							try
							{
								CommonUtility.ScrollToWebElement(driver, list1.get(i));
								CommonUtility.ClickOnWebElement(driver, list1.get(i));

								Thread.sleep(3000);
							}
							catch(Exception e)
							{

							}
						}
					}


				}
				Thread.sleep(15000);
				if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_UnifiedPortalPage.FiestCheckBoxForIE()))
				{

					if(CommonUtility.CheckpresenceofElementLocated(driver,10,obj_UnifiedPortalPage.FiestCheckBoxForIE()))
					{
						CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.FiestCheckBoxForIE());
						CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.FiestCheckBoxForIE());
					}

					if(CommonUtility.CheckpresenceofElementLocated(driver,10,obj_UnifiedPortalPage.SecCheckBoxForIE()))
					{
						CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.SecCheckBoxForIE());
						CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.SecCheckBoxForIE());
					}

					if(CommonUtility.CheckpresenceofElementLocated(driver,10,obj_UnifiedPortalPage.ThirdCheckBoxForIE()))
					{
						CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.ThirdCheckBoxForIE());
						CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.ThirdCheckBoxForIE());
					}

					if(CommonUtility.CheckpresenceofElementLocated(driver,10,obj_UnifiedPortalPage.ForthCheckBoxForIE()))
					{
						CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.ForthCheckBoxForIE());
						CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.ForthCheckBoxForIE());
					}

					if(CommonUtility.CheckpresenceofElementLocated(driver,10,obj_UnifiedPortalPage.FifthCheckBoxForIE()))
					{
						CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.FifthCheckBoxForIE());
						CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.FifthCheckBoxForIE());
					}
					if(CommonUtility.CheckpresenceofElementLocated(driver,10,obj_UnifiedPortalPage.SixCheckBoxForIE()))
					{
						CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.SixCheckBoxForIE());
						CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.SixCheckBoxForIE());
					}


				}
				else
				{
					System.out.println("not able to see asset IDs");
					Report.put("User selects one/multiple/all the assets",
							"'Add to Group' button is enabled; (IB status's  to be considered - Installed;Shipped;Awaiting Customer Install;Install-T&M )",
							"User not able to see asset IDs", "Fail");
					Assert.fail();
				}

				if(CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.AddToGroupButtonInSitesGrid()).isEnabled())
				{
					CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.AddToGroupButtonInSitesGrid());
					button=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.AddToGroupButtonInSitesGrid()).getText();
					System.out.println("button is "+button);
				}
				else
				{
					System.out.println("not able to see add to group");
					Report.put("User selects one/multiple/all the assets",
							"'Add to Group' button is enabled; (IB status's  to be considered - Installed;Shipped;Awaiting Customer Install;Install-T&M )",
							"User not able to see add to group button", "Fail");
					Assert.fail();
				}



				Report.put("User selects one/multiple/all the assets",
						"'Add to Group' button is enabled; (IB status's  to be considered - Installed;Shipped;Awaiting Customer Install;Install-T&M )",
						"User able to select multiple assets, enabled "+Report.color(button)+" button", "PASS");

			}
			else
			{
				System.out.println("not able to see sites in table");
				Report.put("User selects one/multiple/all the assets",
						"'Add to Group' button is enabled; (IB status's  to be considered - Installed;Shipped;Awaiting Customer Install;Install-T&M )",
						"User not able to see sites in table", "Fail");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("User selects one/multiple/all the assets",
					"'Add to Group' button is enabled; (IB status's  to be considered - Installed;Shipped;Awaiting Customer Install;Install-T&M )",
					"User not able to see sites in table", "Fail");
			Assert.fail();
		}
	}


	public void clickOnCreateCustomGroupButtonAndVerifyGroupCreationInGrid_OnlyCreate(WebDriver driver)
	{
		System.out.println("Inside clickOnCreateCustomGroupButtonAndVerifyGroupCreationInGrid_OnlyCreate method");

		String header = "";
		String customgroupname="";
		String message="";

		String name=TestNGCreator.TestData.get(Esupport.FirstName.ordinal());
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);			
			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_UnifiedPortalPage.CreateCustomGroupButtonEnable()))
			{
				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.CreateCustomGroupButtonEnable());

				CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.CreateCustomGroupButtonEnable());	

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.CreatedCustomGroupSuccessMessage());

				message = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.CreatedCustomGroupSuccessMessage()).getText();

				System.out.println("message is: "+message);
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_UnifiedPortalPage.MyCustomeGroupsHeading()));
				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.MyCustomeGroupsHeading());

				header = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.MyCustomeGroupsHeading()).getText();

				System.out.println("Header is: "+header);

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.FirstDisplayedCustomeGroup());

				customgroupname = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.FirstDisplayedCustomeGroup()).getText();

				System.out.println("name of custom group is: "+customgroupname);

				//				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.CreatedCustomGroupSuccessMessage());
				//
				//				message = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.CreatedCustomGroupSuccessMessage()).getText();
				//
				//				System.out.println("message is: "+message);

				if(customgroupname.contains(name))
				{
					System.out.println("custom group name matching with entered");

				}

				else
				{

					System.out.println("custom group name not matching with entered");
					Report.put("If User clicks on Create Custom Group button",
							"This action should complete the creation of a Custom group and redirect the user to the list of custom groups page",
							"Failed to Create Custom group & redirect to homepage", "FAIL");
					Assert.fail();
				}
				Report.put("If User clicks on Create Custom Group button",
						"This action should complete the creation of a Custom group and redirect the user to the list of custom groups page",
						"Created Custom group & redirected to page"+Report.color(header)+" with created custom group in the grid "+Report.color(customgroupname)+" with message "+Report.color(message), "PASS");
			}
			else
			{
				System.out.println("create custom group button not matching with entered");
				Report.put("If User clicks on Create Custom Group button",
						"This action should complete the creation of a Custom group and redirect the user to the list of custom groups page",
						"Failed to Create Custom group & redirect to homepage", "FAIL");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("If User clicks on Create Custom Group button",
					"This action should complete the creation of a Custom group and redirect the user to the list of custom groups page",
					"Failed to Create Custom group & redirect to homepage", "FAIL");
			Assert.fail();
		}
	}


	public void edit_CustomGroup(WebDriver driver)
	{
		System.out.println("Inside edit_CustomGroup method");

		String header = "";String header1="";String button="";
		String customgroupname="";
		String message="";

		String name=TestNGCreator.TestData.get(Esupport.FirstName.ordinal());
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);			
			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_UnifiedPortalPage.EditButton()))
			{
				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.EditButton());

				CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.EditButton());	

				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_UnifiedPortalPage.EditHeading()));
				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.EditHeading());

				header = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.EditHeading()).getText();

				System.out.println("Header is: "+header);


				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.CustomGroupNameTextBox());	
				customgroupname = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.CustomGroupNameTextBox()).getText();

				System.out.println("name of custom group is: "+customgroupname);

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.ShowSelectedProductsTab());
				button=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.ShowSelectedProductsTab()).getText();
				System.out.println("button is "+button);
				CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.ShowSelectedProductsTab());

				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_UnifiedPortalPage.SelectedProductsHeading()));
				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.SelectedProductsHeading());
				header1=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.SelectedProductsHeading()).getText();
				System.out.println("heading is "+header1);

				Thread.sleep(6000);
				SelectOneOrMultipleAssetsOnSelectedProducts(driver);
				Thread.sleep(6000);
				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.RemoveInPopUp());
				CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.RemoveInPopUp());
				Thread.sleep(6000);
				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.SaveChanges());
				CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.SaveChanges());

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.EditedCustomGroupSuccessMessage());

				message = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.EditedCustomGroupSuccessMessage()).getText();

				System.out.println("message is: "+message);

				//				if(customgroupname.contains(name))
				//				{
				//					System.out.println("custom group name matching with entered");
				//
				//				}
				//
				//				else
				//				{
				//					
				//					System.out.println("custom group name not matching with entered");
				//					Report.put("If User clicks on edit Custom Group button on recebtly created custome group`",
				//							"User should be able to edit the selected custom group",
				//							"Failed to edit Custom group & redirect to homepage", "FAIL");
				//					Assert.fail();
				//				}
				Report.put("If User clicks on edit Custom Group button on recebtly created custome group`",
						"User should be able to edit the selected custom group",
						"Edit Custom group & redirected to page"+Report.color(header)+" with created custom group in the grid "+Report.color(customgroupname)+" and user able to edit succcessfully with message "+Report.color(message), "PASS");
			}
			else
			{
				System.out.println("create custom group button not matching with entered");
				Report.put("If User clicks on edit Custom Group button on recebtly created custome group`",
						"User should be able to edit the selected custom group",
						"Failed to edit Custom group & redirect to homepage", "FAIL");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("If User clicks on edit Custom Group button on recebtly created custome group`",
					"User should be able to edit the selected custom group",
					"Failed to edit Custom group & redirect to homepage", "FAIL");
			Assert.fail();
		}
	}

	public void deleteCustomGroup(WebDriver driver)
	{
		System.out.println("Inside deleteCustomGroup method");

		String header = "";
		String customgroupname="";String message="";

		String name=TestNGCreator.TestData.get(Esupport.FirstName.ordinal());
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);			
			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_UnifiedPortalPage.FirstDisplayedCustomeGroup()))
			{

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.FirstDisplayedCustomeGroup());

				customgroupname = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.FirstDisplayedCustomeGroup()).getText();

				System.out.println("name of custom group is: "+customgroupname);

				if(customgroupname.contains(name))
				{
					System.out.println("custom group name matching with entered");
					CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.DeleteFirstDisplayed());
					CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.DeleteFirstDisplayed());
					wait.until(ExpectedConditions.visibilityOfElementLocated(obj_UnifiedPortalPage.DeleteOptionInDeletePopUp()));
					CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.DeleteOptionInDeletePopUp());
					CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.DeleteOptionInDeletePopUp());
					//					CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.DeletedCustomGroupSuccessMessage());
					//					message = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.DeletedCustomGroupSuccessMessage()).getText();
					//					System.out.println("message is: "+message);
				}

				else
				{

					System.out.println("custom group name not matching with entered");
					Report.put("If User clicks on delete Custom Group button",
							"User should be able to delete selected custom group",
							"Failed to delete Custom group & redirect to homepage", "FAIL");
					Assert.fail();
				}
				Report.put("If User clicks on delete Custom Group button",
						"User should be able to delete selected custom group",
						"User able to delete selected custom group in the grid "+Report.color(customgroupname)+" successfully with message "+Report.color(message), "PASS");
			}
			else
			{
				System.out.println("create custom group button not matching with entered");
				Report.put("If User clicks on delete Custom Group button",
						"User should be able to delete selected custom group",
						"Failed to delete Custom group & redirect to homepage", "FAIL");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("If User clicks on delete Custom Group button",
					"User should be able to delete selected custom group",
					"Failed to delete Custom group & redirect to homepage", "FAIL");
			Assert.fail();
		}
	}

	public void edit_CustomGroup_IE(WebDriver driver)
	{
		System.out.println("Inside edit_CustomGroup_IE method");

		String header = "";String header1="";String button="";
		String customgroupname="";
		String message="";

		String name=TestNGCreator.TestData.get(Esupport.FirstName.ordinal());
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);			
			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_UnifiedPortalPage.EditButton()))
			{
				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.EditButton());

				CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.EditButton());	

				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_UnifiedPortalPage.EditHeading()));
				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.EditHeading());

				header = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.EditHeading()).getText();

				System.out.println("Header is: "+header);


				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.CustomGroupNameTextBox());	
				customgroupname = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.CustomGroupNameTextBox()).getText();

				System.out.println("name of custom group is: "+customgroupname);

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.ShowSelectedProductsTab());
				button=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.ShowSelectedProductsTab()).getText();
				System.out.println("button is "+button);
				CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.ShowSelectedProductsTab());

				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_UnifiedPortalPage.SelectedProductsHeading()));
				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.SelectedProductsHeading());
				header1=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.SelectedProductsHeading()).getText();
				System.out.println("heading is "+header1);

				Thread.sleep(6000);
				SelectOneOrMultipleAssetsOnSelectedProducts_IE(driver);
				Thread.sleep(6000);
				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.RemoveInPopUp());
				CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.RemoveInPopUp());
				Thread.sleep(6000);
				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.SaveChanges());
				CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.SaveChanges());


				//				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.EditedCustomGroupSuccessMessage());
				//
				//				message = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.EditedCustomGroupSuccessMessage()).getText();
				//
				//				System.out.println("message is: "+message);

				//				if(customgroupname.contains(name))
				//				{
				//					System.out.println("custom group name matching with entered");
				//
				//				}
				//
				//				else
				//				{
				//					
				//					System.out.println("custom group name not matching with entered");
				//					Report.put("If User clicks on edit Custom Group button on recebtly created custome group`",
				//							"User should be able to edit the selected custom group",
				//							"Failed to edit Custom group & redirect to homepage", "FAIL");
				//					Assert.fail();
				//				}
				Report.put("If User clicks on edit Custom Group button on recebtly created custome group`",
						"User should be able to edit the selected custom group",
						"Edit Custom group & redirected to page"+Report.color(header)+" with created custom group in the grid "+Report.color(customgroupname)+" and user able to edit succcessfully with message "+Report.color(message), "PASS");
			}
			else
			{
				System.out.println("create custom group button not matching with entered");
				Report.put("If User clicks on edit Custom Group button on recebtly created custome group`",
						"User should be able to edit the selected custom group",
						"Failed to edit Custom group & redirect to homepage", "FAIL");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("If User clicks on edit Custom Group button on recebtly created custome group`",
					"User should be able to edit the selected custom group",
					"Failed to edit Custom group & redirect to homepage", "FAIL");
			Assert.fail();
		}
	}

	public void validateDetailsOnProductsGroupname(WebDriver driver)
	{

		Log.info("Inside validateDetailsOnProductsGroupname method");
		String item=TestNGCreator.TestData.get(Esupport.SearchOption.ordinal());
		String button = "";
		String header="";
		String totaloptions="";
		String details="";
		String columns="";
		String details2="";
		WebDriverWait wait = new WebDriverWait(driver, 600);
		try
		{

			if(CommonUtility.CheckpresenceofElementLocated(driver,66,obj_UnifiedPortalPage.BackToCustomGroupsButton()))
			{

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.BackToCustomGroupsButton());
				button=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.BackToCustomGroupsButton()).getText();
				System.out.println(button);

				Report.put("User  selects an existing Custom Group of the type 'Products' for viewing  ",
						"User should land on the details page with the 'contents' as below Title :< Custom Group Name> 1.Custom Group Name field (view only) 2.Custom Group Description (View only) 3. Show Selected Products 4. This section displays the previous selections  in a grid with the following columns: (IB status's  to be considered - Installed;Shipped;Awaiting Customer Install;Install-T&M ) Asset ID, Product Name, Product Nickname, Site ID, Site Details <br> 5. Filter selected products based on Asset ID,Product Name,Product Nickname,Site ID,Site Details 6. Ability to sort on the following columns in ascending and descending order, Asset ID,Product Name,Product Nickname,Site ID,Site Details 7.User should be able to paginate through the list of selected products .8. Delete Custom Group Button -On click (refer to story #) 9.Back to Custom Groups link -Should redirect the user to list of custom groups page 10. 'Edit Custom Group' button",
						"User able to see "+Report.color(button)+" link", "PASS");
				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.CustomGroupNameOnDetailsPage());
				header=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.CustomGroupNameOnDetailsPage()).getText();
				System.out.println(header);
				Report.put("User  selects an existing Custom Group of the type 'Products' for viewing  ",
						"User should land on the details page with the 'contents' as below Title :< Custom Group Name> 1.Custom Group Name field (view only) 2.Custom Group Description (View only) 3. Show Selected Products 4. This section displays the previous selections  in a grid with the following columns: (IB status's  to be considered - Installed;Shipped;Awaiting Customer Install;Install-T&M ) Asset ID, Product Name, Product Nickname, Site ID, Site Details <br> 5. Filter selected products based on Asset ID,Product Name,Product Nickname,Site ID,Site Details 6. Ability to sort on the following columns in ascending and descending order, Asset ID,Product Name,Product Nickname,Site ID,Site Details 7.User should be able to paginate through the list of selected products .8. Delete Custom Group Button -On click (refer to story #) 9.Back to Custom Groups link -Should redirect the user to list of custom groups page 10. 'Edit Custom Group' button",
						"User able to see "+Report.color(header)+" displayed", "PASS");
				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.CustomGroupNameAndDescriptionHeaderOnDetailsPage());
				List<WebElement> list=driver.findElements(obj_UnifiedPortalPage.CustomGroupNameAndDescriptionHeaderOnDetailsPage());

				for(WebElement lt:list)
				{
					CommonUtility.highlightElement(driver, lt);
					String option=lt.getText();
					totaloptions+="<br>"+option;
				}
				System.out.println(totaloptions);
				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.CustomGroupNameAndDescriptionDetailsOnDetailsPage());
				List<WebElement> list1=driver.findElements(obj_UnifiedPortalPage.CustomGroupNameAndDescriptionDetailsOnDetailsPage());

				for(WebElement lt:list1)
				{
					CommonUtility.highlightElement(driver, lt);
					String option=lt.getAttribute("placeholder");
					details+="<br>"+option;
				}
				System.out.println(details);
				Report.put("User  selects an existing Custom Group of the type 'Products' for viewing  ",
						"User should land on the details page with the 'contents' as below Title :< Custom Group Name> 1.Custom Group Name field (view only) 2.Custom Group Description (View only) 3. Show Selected Products 4. This section displays the previous selections  in a grid with the following columns: (IB status's  to be considered - Installed;Shipped;Awaiting Customer Install;Install-T&M ) Asset ID, Product Name, Product Nickname, Site ID, Site Details <br> 5. Filter selected products based on Asset ID,Product Name,Product Nickname,Site ID,Site Details 6. Ability to sort on the following columns in ascending and descending order, Asset ID,Product Name,Product Nickname,Site ID,Site Details 7.User should be able to paginate through the list of selected products .8. Delete Custom Group Button -On click (refer to story #) 9.Back to Custom Groups link -Should redirect the user to list of custom groups page 10. 'Edit Custom Group' button",
						"User able to see "+Report.color(totaloptions)+" displayed along with disabled text box with pre filled values "+Report.color(details), "PASS");
				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.SelectedProductsHeading());
				String tab1=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.SelectedProductsHeading()).getText();
				System.out.println(tab1);


				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.ColumnNamesOfGridOfSelectedItems());
				List<WebElement> list2=driver.findElements(obj_UnifiedPortalPage.ColumnNamesOfGridOfSelectedItems());

				for(WebElement lt:list2)
				{
					CommonUtility.highlightElement(driver, lt);
					String option=lt.getText();
					columns+=option;
				}
				System.out.println(columns);
				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.NumberSearchResultsDisplayed());
				List<WebElement> list3=driver.findElements(obj_UnifiedPortalPage.NumberSearchResultsDisplayed());
				int count=list3.size();
				System.out.println("displayed count "+count);
				for(WebElement lt:list3)
				{
					CommonUtility.highlightElement(driver, lt);
					String option=lt.getText();
					details2+=option;
				}
				System.out.println(details2);
				Report.put("User  selects an existing Custom Group of the type 'Products' for viewing  ",
						"User should land on the details page with the 'contents' as below Title :< Custom Group Name> 1.Custom Group Name field (view only) 2.Custom Group Description (View only) 3. Show Selected Products 4. This section displays the previous selections  in a grid with the following columns: (IB status's  to be considered - Installed;Shipped;Awaiting Customer Install;Install-T&M ) Asset ID, Product Name, Product Nickname, Site ID, Site Details <br> 5. Filter selected products based on Asset ID,Product Name,Product Nickname,Site ID,Site Details 6. Ability to sort on the following columns in ascending and descending order, Asset ID,Product Name,Product Nickname,Site ID,Site Details 7.User should be able to paginate through the list of selected products .8. Delete Custom Group Button -On click (refer to story #) 9.Back to Custom Groups link -Should redirect the user to list of custom groups page 10. 'Edit Custom Group' button",
						"User able to see "+Report.color(tab1)+" displayed with table with columns "+Report.color(columns)+" and total pre selected assets are "+count+" with details "+Report.color(details2), "PASS");





				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.EditSelectedItemsTab());
				String Edittab=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.EditSelectedItemsTab()).getText();
				System.out.println(Edittab);
				Report.put("User  selects an existing Custom Group of the type 'Products' for viewing  ",
						"User should land on the details page with the 'contents' as below Title :< Custom Group Name> 1.Custom Group Name field (view only) 2.Custom Group Description (View only) 3. Show Selected Products 4. This section displays the previous selections  in a grid with the following columns: (IB status's  to be considered - Installed;Shipped;Awaiting Customer Install;Install-T&M ) Asset ID, Product Name, Product Nickname, Site ID, Site Details <br> 5. Filter selected products based on Asset ID,Product Name,Product Nickname,Site ID,Site Details 6. Ability to sort on the following columns in ascending and descending order, Asset ID,Product Name,Product Nickname,Site ID,Site Details 7.User should be able to paginate through the list of selected products .8. Delete Custom Group Button -On click (refer to story #) 9.Back to Custom Groups link -Should redirect the user to list of custom groups page 10. 'Edit Custom Group' button",
						"User able to see "+Report.color(Edittab)+" button", "PASS");

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.DeleteCustomGroupTab());
				String deletetab=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.DeleteCustomGroupTab()).getText();
				System.out.println(deletetab);
				Report.put("User  selects an existing Custom Group of the type 'Products' for viewing  ",
						"User should land on the details page with the 'contents' as below Title :< Custom Group Name> 1.Custom Group Name field (view only) 2.Custom Group Description (View only) 3. Show Selected Products 4. This section displays the previous selections  in a grid with the following columns: (IB status's  to be considered - Installed;Shipped;Awaiting Customer Install;Install-T&M ) Asset ID, Product Name, Product Nickname, Site ID, Site Details <br> 5. Filter selected products based on Asset ID,Product Name,Product Nickname,Site ID,Site Details 6. Ability to sort on the following columns in ascending and descending order, Asset ID,Product Name,Product Nickname,Site ID,Site Details 7.User should be able to paginate through the list of selected products .8. Delete Custom Group Button -On click (refer to story #) 9.Back to Custom Groups link -Should redirect the user to list of custom groups page 10. 'Edit Custom Group' button",
						"User able to see "+Report.color(deletetab)+" button", "PASS");
			}
			else
			{
				System.out.println("not able to see expected details");
				Report.put("User  selects an existing Custom Group of the type 'Products' for viewing  ",
						"User should land on the details page with the 'contents' as below Title :< Custom Group Name> 1.Custom Group Name field (view only) 2.Custom Group Description (View only) 3. Show Selected Products 4. This section displays the previous selections  in a grid with the following columns: (IB status's  to be considered - Installed;Shipped;Awaiting Customer Install;Install-T&M ) Asset ID, Product Name, Product Nickname, Site ID, Site Details <br> 5. Filter selected products based on Asset ID,Product Name,Product Nickname,Site ID,Site Details 6. Ability to sort on the following columns in ascending and descending order, Asset ID,Product Name,Product Nickname,Site ID,Site Details 7.User should be able to paginate through the list of selected products .8. Delete Custom Group Button -On click (refer to story #) 9.Back to Custom Groups link -Should redirect the user to list of custom groups page 10. 'Edit Custom Group' button",
						"User failed to see expected details", "Fail");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("User  selects an existing Custom Group of the type 'Products' for viewing  ",
					"User should land on the details page with the 'contents' as below Title :< Custom Group Name> 1.Custom Group Name field (view only) 2.Custom Group Description (View only) 3. Show Selected Products 4. This section displays the previous selections  in a grid with the following columns: (IB status's  to be considered - Installed;Shipped;Awaiting Customer Install;Install-T&M ) Asset ID, Product Name, Product Nickname, Site ID, Site Details <br> 5. Filter selected products based on Asset ID,Product Name,Product Nickname,Site ID,Site Details 6. Ability to sort on the following columns in ascending and descending order, Asset ID,Product Name,Product Nickname,Site ID,Site Details 7.User should be able to paginate through the list of selected products .8. Delete Custom Group Button -On click (refer to story #) 9.Back to Custom Groups link -Should redirect the user to list of custom groups page 10. 'Edit Custom Group' button",
					"User failed to see expected details", "Fail");
			Assert.fail();
		}
	}


	public void clickOnGroupNameHyperlink_Products(WebDriver driver)
	{

		Log.info("Inside clickOnGroupNameHyperlink_Products method");
		String item=TestNGCreator.TestData.get(Esupport.SearchOption.ordinal());
		String button = "";
		String header="";
		String totaloptions="";
		WebDriverWait wait = new WebDriverWait(driver, 600);
		try
		{

			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_UnifiedPortalPage.GroupNameForProductsItem()))
			{

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.GroupNameForProductsItem());
				CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.GroupNameForProductsItem());
				//				List<WebElement> list=driver.findElements(obj_UnifiedPortalPage.ItemsColumnDetails());
				//
				//
				//				for(int i=0;i<list.size();i++)
				//				{
				//					//					CommonUtility.ScrollToWebElement(driver, list.get(i));
				//
				//					String option=list.get(i).getText();
				//					totaloptions += "<br>"+option;		
				//
				//					if(option.contains(item))
				//					{
				//						try
				//						{
				//							CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.GroupNameDetails());
				//							List<WebElement> list1=driver.findElements(obj_UnifiedPortalPage.GroupNameDetails());
				//
				//							CommonUtility.ScrollToWebElement(driver, list1.get(i));
				//
				//							CommonUtility.ClickOnWebElement(driver, list1.get(i));
				//
				//							//							CommonUtility.ClickOnWebElement(driver, list1.get(i));
				//							break;
				//						}
				//						catch(Exception e)
				//						{
				//
				//						}
				//
				//						Thread.sleep(6000);
				//					}
				//
				//				}
				//				System.out.println(totaloptions);

				wait.until(ExpectedConditions.presenceOfElementLocated(obj_UnifiedPortalPage.CustomGroupNameOnDetailsPage()));
				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.CustomGroupNameOnDetailsPage());
				header=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.CustomGroupNameOnDetailsPage()).getText();
				System.out.println(header);

				Report.put("User  selects an existing Custom Group of the type 'Products' for viewing  ",
						"User should land on the details page with the 'contents' as below Title :< Custom Group Name> 1.Custom Group Name field (view only) 2.Custom Group Description (View only) 3. Show Selected Products 4. This section displays the previous selections  in a grid with the following columns: (IB status's  to be considered - Installed;Shipped;Awaiting Customer Install;Install-T&M ) Asset ID, Product Name, Product Nickname, Site ID, Site Details <br> 5. Filter selected products based on Asset ID,Product Name,Product Nickname,Site ID,Site Details 6. Ability to sort on the following columns in ascending and descending order, Asset ID,Product Name,Product Nickname,Site ID,Site Details 7.User should be able to paginate through the list of selected products .8. Delete Custom Group Button -On click (refer to story #) 9.Back to Custom Groups link -Should redirect the user to list of custom groups page 10. 'Edit Custom Group' button",
						"User able to click on group name of item type Products", "PASS");
				Thread.sleep(6000);
				validateDetailsOnProductsGroupname(driver);
				Thread.sleep(6000);
			}
			else
			{
				System.out.println("not able to see grid details");
				Report.put("User  selects an existing Custom Group of the type 'Products' for viewing  ",
						"User should land on the details page with the 'contents' as below Title :< Custom Group Name> 1.Custom Group Name field (view only) 2.Custom Group Description (View only) 3. Show Selected Products 4. This section displays the previous selections  in a grid with the following columns: (IB status's  to be considered - Installed;Shipped;Awaiting Customer Install;Install-T&M ) Asset ID, Product Name, Product Nickname, Site ID, Site Details <br> 5. Filter selected products based on Asset ID,Product Name,Product Nickname,Site ID,Site Details 6. Ability to sort on the following columns in ascending and descending order, Asset ID,Product Name,Product Nickname,Site ID,Site Details 7.User should be able to paginate through the list of selected products .8. Delete Custom Group Button -On click (refer to story #) 9.Back to Custom Groups link -Should redirect the user to list of custom groups page 10. 'Edit Custom Group' button",
						"User failed to see grid details", "Fail");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("User  selects an existing Custom Group of the type 'Products' for viewing  ",
					"User should land on the details page with the 'contents' as below Title :< Custom Group Name> 1.Custom Group Name field (view only) 2.Custom Group Description (View only) 3. Show Selected Products 4. This section displays the previous selections  in a grid with the following columns: (IB status's  to be considered - Installed;Shipped;Awaiting Customer Install;Install-T&M ) Asset ID, Product Name, Product Nickname, Site ID, Site Details <br> 5. Filter selected products based on Asset ID,Product Name,Product Nickname,Site ID,Site Details 6. Ability to sort on the following columns in ascending and descending order, Asset ID,Product Name,Product Nickname,Site ID,Site Details 7.User should be able to paginate through the list of selected products .8. Delete Custom Group Button -On click (refer to story #) 9.Back to Custom Groups link -Should redirect the user to list of custom groups page 10. 'Edit Custom Group' button",
					"User failed to see grid details", "Fail");
			Assert.fail();
		}
	}


	public void SelectProductFamilyDisabled(WebDriver driver)
	{

		Log.info("Inside SelectProductFamilyDisabled method");

		String button = "";

		WebDriverWait wait = new WebDriverWait(driver, 600);

		try
		{

			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_UnifiedPortalPage.SelectProductFamiliesTab()))
			{

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.SelectProductFamiliesTab());
				boolean b=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.SelectProductFamiliesTab()).isEnabled();
				if(b==true)
				{
					System.out.println("able to see Select product families enabled");
					Report.put("Verify that the Select Product Families in disabled state with tool tip indicator.",
							"Select Product Families should be disabled state with tool tip indicator.",
							"User able to see Select Product Families is enabled", "Fail");
					Assert.fail();
				}
				else
				{
					System.out.println("able to see Select product families is in disabled state");

				}

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.ToolTipIconNextToSelectProductFamilyTab());

				Report.put("Verify that the Select Product Families in disabled state with tool tip indicator.",
						"Select Product Families should be disabled state with tool tip indicator.",
						"User able to see Select Product Families is in disabled state with tool tip indicator", "PASS");


			}
			else
			{
				System.out.println("able to see Select product families enabled");
				Report.put("Verify that the Select Product Families in disabled state with tool tip indicator.",
						"Select Product Families should be disabled state with tool tip indicator.",
						"User able to see Select Product Families is enabled", "Fail");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify that the Select Product Families in disabled state with tool tip indicator.",
					"Select Product Families should be disabled state with tool tip indicator.",
					"User able to see Select Product Families is enabled", "Fail");
			Assert.fail();
		}
	}

	public void ClickOnToolTip(WebDriver driver)
	{

		Log.info("Inside ClickOnToolTip method");

		String button = "";

		WebDriverWait wait = new WebDriverWait(driver, 600);

		try
		{

			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_UnifiedPortalPage.ToolTipIconNextToSelectProductFamilyTab()))
			{

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.ToolTipIconNextToSelectProductFamilyTab());
				CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.ToolTipIconNextToSelectProductFamilyTab());

				String message=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.ToolTipMessageClickingOnFamilyToolTip()).getText();
				System.out.println(message);

				Report.put("Click on the tooltip",
						"The  tool tip should display 'Select one or more Sites to use this option' message ",
						"User able to click on tool tip and able to see message "+Report.color(message), "PASS");


			}
			else
			{
				System.out.println("tool tip not displayed");
				Report.put("Click on the tooltip",
						"The  tool tip should display 'Select one or more Sites to use this option' message ",
						"User failed to see tool tip", "Fail");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on the tooltip",
					"The  tool tip should display 'Select one or more Sites to use this option' message ",
					"User failed to see tool tip", "Fail");
			Assert.fail();
		}
	}

	public void SelectAllListBox(WebDriver driver)
	{

		Log.info("Inside SelectAllListBox method");

		String button = "";

		WebDriverWait wait = new WebDriverWait(driver, 600);

		try
		{

			if(CommonUtility.CheckpresenceofElementLocated(driver,05,obj_UnifiedPortalPage.SelectAllDisabled()))
			{

				CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.SelectAllDisabled());


				Report.put("Verify the list box",
						"The List box with a select all option disabled should be displayed",
						"User able to see List box with select all option disabled", "PASS");


			}
			else
			{
				System.out.println("filed to see List box with select all option disabled");
				Report.put("Verify the list box",
						"The List box with a select all option disabled should be displayed",
						"User failed to see List box with select all option disabled", "Fail");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify the list box",
					"The List box with a select all option disabled should be displayed",
					"User failed to see List box with select all option disabled", "Fail");
			Assert.fail();
		}
	}

	public void verifySitesAvailableInSitesOrFamilies_DefaultDisplayed(WebDriver driver)
	{

		Log.info("Inside verifySitesAvailableInSitesOrFamilies_DefaultDisplayed method");

		String button = "";
		String header="";
		String header1="";
		String columnam="";
		String rownam="";

		WebDriverWait wait = new WebDriverWait(driver, 240);
		try
		{

			if(CommonUtility.CheckpresenceofElementLocated(driver,33,obj_UnifiedPortalPage.TableOfSites()))
			{

				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_UnifiedPortalPage.TableOfSites()));
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_UnifiedPortalPage.SitesListInTable()));
				List<WebElement> list=driver.findElements(obj_UnifiedPortalPage.SitesListInTable());

				int count=list.size();
				System.out.println("total number of sites displayed in table is "+count);
				for(WebElement lt:list)
				{
					CommonUtility.highlightElement(driver, lt);
					String label=lt.getText();

					System.out.println("site is: " +label);
					columnam+=" <br> " + label;
				}
				System.out.println("sites are :"+columnam);


				Report.put("Verify the data in the list box",
						"The list box should be loaded with first 10 sites (refer to the prototype) The candidates for this <br>-list of all the sites accessible to the user ;( Inherited ,Whitelist relationship ,3rd party relationship and Support Parnter sites ), User should be able to do a virtualized scroll through the entire list , The bottom of the grid has a count of the total sites -Account Sites / number of Sites when user performs a search -'Displaying <n> items '",
						"User able to select search in sites option and able to see table displayed sites "+Report.color(columnam), "PASS");

			}
			else
			{
				System.out.println("User failed to see table of list of sites");
				Report.put("Verify the data in the list box",
						"The list box should be loaded with first 10 sites (refer to the prototype) The candidates for this <br>-list of all the sites accessible to the user ;( Inherited ,Whitelist relationship ,3rd party relationship and Support Parnter sites ), User should be able to do a virtualized scroll through the entire list , The bottom of the grid has a count of the total sites -Account Sites / number of Sites when user performs a search -'Displaying <n> items '",
						"User failed to see table of list of sites", "Fail");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify the data in the list box",
					"The list box should be loaded with first 10 sites (refer to the prototype) The candidates for this <br>-list of all the sites accessible to the user ;( Inherited ,Whitelist relationship ,3rd party relationship and Support Parnter sites ), User should be able to do a virtualized scroll through the entire list , The bottom of the grid has a count of the total sites -Account Sites / number of Sites when user performs a search -'Displaying <n> items '",
					"User failed to see table of list of sites ", "Fail");
			Assert.fail();
		}
	}

	public void PreviewSectionAtBottom(WebDriver driver)
	{

		Log.info("Inside PreviewSectionAtBottom method");

		String button = "";
		String button1="";
		String cancel="";
		String button2="";

		WebDriverWait wait = new WebDriverWait(driver, 600);
		try
		{

			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_UnifiedPortalPage.CreateCustomGroupButtonEnable()))
			{
				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.CreateCustomGroupButtonEnable());
				boolean b=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.CreateCustomGroupButtonEnable()).isEnabled();
				if(b==true)
				{

					System.out.println("User failed to see Create Custom Group button in disabled state");
					Report.put("Verify the Preview section at the bottom  ",
							"The Preview section at the bottom of the screen should contain the following :Create Custom Group button  in disabled state,Cancel button -this cancels the create operation and directs the user back to previous screen",
							"User failed to see Create Custom Group button in disabled state", "Fail");
					Assert.fail();
				}
				else
				{
					CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.CreateCustomGroupButtonEnable());
					button1=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.CreateCustomGroupButtonEnable()).getText();
					System.out.println("button is "+button1);

					Report.put("Verify the Preview section at the bottom  ",
							"The Preview section at the bottom of the screen should contain the following :Create Custom Group button  in disabled state,Cancel button -this cancels the create operation and directs the user back to previous screen",
							"User able to see "+Report.color(button1)+ " button in disabled state", "PASS");
				}
				if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_UnifiedPortalPage.NoSitesSelectedMessage()))
				{
					CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.NoSitesSelectedMessage());
					button2=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.NoSitesSelectedMessage()).getText();
					System.out.println("button is "+button2);

					Report.put("Verify a message is displayed when no sites are selected",
							"There should be a message as follows : No Sites selected.Select one or more Sites to see your selections here.",
							"User able to see message "+Report.color(button2), "PASS");
				}
				else
				{
					System.out.println("User failed to see 'No Sites selected' message");
					Report.put("Verify a message is displayed when no sites are selected",
							"There should be a message as follows : No Sites selected.Select one or more Sites to see your selections here.",
							"User failed to see 'No Sites selected' message", "Fail");
					Assert.fail();
				}
				if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_UnifiedPortalPage.CancelButton()))
				{
					CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.CancelButton());
					boolean b1=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.CancelButton()).isEnabled();
					if(b1==true)
					{
						CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.CancelButton());
						cancel=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.CancelButton()).getText();
						System.out.println("button is "+cancel);

						CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.CancelButton());
						wait.until(ExpectedConditions.visibilityOfElementLocated(obj_UnifiedPortalPage.AddCustomGroup()));
						CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.AddCustomGroup());	
						button=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.AddCustomGroup()).getText();	
						System.out.println("button name is "+button);

						Report.put("Verify the Preview section at the bottom  ",
								"The Preview section at the bottom of the screen should contain the following :Create Custom Group button  in disabled state,Cancel button -this cancels the create operation and directs the user back to previous screen",
								"User able to see "+Report.color(cancel)+ " button enabled and clicking on cancel button redirecting to previous page with enabled button "+Report.color(button), "PASS");
					}
					else
					{
						System.out.println("User failed to see cancel button in enabled state");
						Report.put("Verify the Preview section at the bottom  ",
								"The Preview section at the bottom of the screen should contain the following :Create Custom Group button  in disabled state,Cancel button -this cancels the create operation and directs the user back to previous screen",
								"User failed to see cancel button in enabled state", "Fail");
						Assert.fail();
					}
				}
				else
				{
					System.out.println("User failed to see cancel button in enabled state");
					Report.put("Verify the Preview section at the bottom  ",
							"The Preview section at the bottom of the screen should contain the following :Create Custom Group button  in disabled state,Cancel button -this cancels the create operation and directs the user back to previous screen",
							"User failed to see cancel button in enabled state", "Fail");
					Assert.fail();
				}
			}
			else
			{

				System.out.println("User failed to see Create Custom Group button in disabled state");
				Report.put("Verify the Preview section at the bottom  ",
						"The Preview section at the bottom of the screen should contain the following :Create Custom Group button  in disabled state,Cancel button -this cancels the create operation and directs the user back to previous screen",
						"User failed to see Create Custom Group button in disabled state", "Fail");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify the Preview section at the bottom  ",
					"The Preview section at the bottom of the screen should contain the following :Create Custom Group button  in disabled state,Cancel button -this cancels the create operation and directs the user back to previous screen",
					"User failed to see Create Custom Group button in disabled state and Cancel Button", "Fail");
			Assert.fail();
		}
	}


	public void SortingColumns_SitesFamilies(WebDriver driver)
	{

		Log.info("Inside SortingColumns_SitesFamilies method");

		String assertid = ""; String assertclass="";
		String Prodname=""; String prodclass="";
		String nickname="";String nickclass="";
		String siteid="";String siteidclass="";
		String sitedetils=""; String sitedetclass="";

		WebDriverWait wait = new WebDriverWait(driver, 600);
		try
		{

			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_UnifiedPortalPage.AssetIdSorting()))
			{	
				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.AssetIdSorting());
				assertid=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.AssetIdSorting()).getText();
				System.out.println("column name is "+assertid);
				CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.AssetIdSorting());

				Thread.sleep(6000);
				assertclass=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.AssetIdSorting()).getAttribute("class");
				System.out.println("class is "+assertclass);

				if(!(assertclass.contains("sorting_desc")|| assertclass.contains("sorting_asc")))
				{
					System.out.println("not able to see asset id sorting");
					Report.put("User verifies sort on the following columns in ascending and descending order ",
							"The details are sorted in ascending or descending order  for the below columns :Product Name,Product Nickname, Asset ID",
							"User not able to see asset id sorting", "Fail");
					Assert.fail();
				}

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.ProductNameSorting());
				Prodname=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.ProductNameSorting()).getText();
				System.out.println("column name is "+Prodname);
				CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.ProductNameSorting());

				Thread.sleep(6000);
				prodclass=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.ProductNameSorting()).getAttribute("class");
				System.out.println("class is "+prodclass);

				if(!(prodclass.contains("sorting_desc")|| prodclass.contains("sorting_asc")))
				{
					System.out.println("not able to see product name sorting");
					Report.put("User verifies sort on the following columns in ascending and descending order ",
							"The details are sorted in ascending or descending order  for the below columns :Product Name,Product Nickname, Asset ID",
							"User not able to see product name sorting", "Fail");
					Assert.fail();
				}

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.ProductFamilySorting());
				siteid=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.ProductFamilySorting()).getText();
				System.out.println("column name is "+siteid);
				CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.ProductFamilySorting());

				Thread.sleep(6000);
				siteidclass=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.ProductFamilySorting()).getAttribute("class");
				System.out.println("class is "+siteidclass);

				if(!(siteidclass.contains("sorting_desc")|| siteidclass.contains("sorting_asc")))
				{
					System.out.println("not able to see product family sorting");
					Report.put("User verifies sort on the following columns in ascending and descending order ",
							"The details are sorted in ascending or descending order  for the below columns :Product Name,Product Nickname, Asset ID",
							"User not able to see product family sorting", "Fail");
					Assert.fail();
				}
				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.ProductNicknameSorting());
				nickname=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.ProductNicknameSorting()).getText();
				System.out.println("column name is "+nickname);
				CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.ProductNicknameSorting());

				Thread.sleep(6000);
				nickclass=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.ProductNicknameSorting()).getAttribute("class");
				System.out.println("class is "+nickclass);

				if(!(nickclass.contains("sorting_desc")|| nickclass.contains("sorting_asc")))
				{
					System.out.println("not able to see product nickname sorting");
					Report.put("User verifies sort on the following columns in ascending and descending order ",
							"The details are sorted in ascending or descending order  for the below columns :Product Name,Product Nickname, Asset ID",
							"User not able to see product nickname sorting", "Fail");
					Assert.fail();
				}


				Report.put("User verifies sort on the following columns in ascending and descending order ",
						"The details are sorted in ascending or descending order  for the below columns :Product Name,Product Nickname, Asset ID",
						"User able to sort all columns in ascending and descending", "PASS");

			}
			else
			{
				System.out.println("not able to sort column names");
				Report.put("User verifies sort on the following columns in ascending and descending order ",
						"The details are sorted in ascending or descending order  for the below columns :Product Name,Product Nickname, Asset ID",
						"User not able to sort column names", "Fail");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("User verifies sort on the following columns in ascending and descending order ",
					"The details are sorted in ascending or descending order  for the below columns :Product Name,Product Nickname, Asset ID",
					"User not able to sort column names", "Fail");
			Assert.fail();
		}
	}


	public void ClickOnShowSelectedItemsTab_SitesFamilies(WebDriver driver)
	{

		Log.info("Inside ClickOnShowSelectedItemsTab_SitesFamilies method");

		String button = "";
		String header = "";
		String hide="";
		String labelList="";
		String sitesfamilies="";
		WebDriverWait wait = new WebDriverWait(driver, 240);
		try
		{

			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_UnifiedPortalPage.ShowSelectedProductsTab()))
			{

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.ShowSelectedProductsTab());
				button=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.ShowSelectedProductsTab()).getText();
				System.out.println("button is "+button);
				CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.ShowSelectedProductsTab());

				//				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_UnifiedPortalPage.SelectedProductsHeading()));
				//				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.SelectedProductsHeading());
				//				header=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.SelectedProductsHeading()).getText();
				//				System.out.println("heading is "+header);

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.HideSelectedProductsTab());
				hide=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.HideSelectedProductsTab()).getText();
				System.out.println("link is "+hide);

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.SelectedItemsTab());
				String tab1=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.SelectedItemsTab()).getText();
				System.out.println(tab1);

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.AssetPreviewTab());
				String tab2=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.AssetPreviewTab()).getText();
				System.out.println(tab2);
				
				List<WebElement> list=driver.findElements(obj_UnifiedPortalPage.SelectedSitesAndFamiliesHeading());

				for(WebElement lt:list)
				{
					CommonUtility.highlightElement(driver, lt);
					String label=lt.getText();

					System.out.println("headings are " +label);
					labelList+=" <br> " + label;
				}
				System.out.println("Headings are:"+labelList);

				List<WebElement> list1=driver.findElements(obj_UnifiedPortalPage.SitesAndFamiliesSelectedList());

				for(WebElement lt:list1)
				{
					CommonUtility.highlightElement(driver, lt);
					String label=lt.getText();

					System.out.println("selected sites and families: " +label);
					sitesfamilies+=" <br> " + label;
				}
				System.out.println("selected sites and families"+sitesfamilies);


				List<WebElement> list2=driver.findElements(obj_UnifiedPortalPage.RemoveMinusButton());
				int count=list2.size();
				System.out.println("count of remove - buttons are "+count);
				for(int i=0;i<list2.size();i++)
				{
					CommonUtility.ScrollToWebElement(driver, list2.get(i));

				}

				Report.put("User navigates at the bottom of the page and clicks on caret icon 'Show Selected Items( site ) ' dropdown",
						"The tray opens revealing the following contents: 1.Selected Items 2.Custom Group Preview buttons :3.Selected Sites section 4.Site name List of Sites selected so far with Site Name for each site Example -if 10 sites are selected ,all 10 should be displayed like this :Site Name 1 (n Assets)Site Name 2 (n Assets)Site Name 3 (n Assets)Site Name 4 (n Assets) Site Name 5 (n Assets) <br>5.Selected product families 6.'All Product Families / No family products-message should be displayed 7. 'Remove' icon should be available against each site user clicks on the   icon ,the site is removed from the selection  8.Hide Selected Items -to close the selection tray and drop back into the 'Create' flow. 9.Create Custom Group button -When user clicks on this ,the Custom group creation is completed and user is directed back to the list page. 10.Cancel button -to cancel the create action and go back to the list page.",
						"User able to click on "+Report.color(button)+" button and heading and with "+Report.color(hide)+ " tab with "+Report.color(tab1+" and "+tab2)+" with selected sites and families heading in the grid "+Report.color(labelList+" aling with sites and families details "+sitesfamilies+" respectively <br> and also able to see remove icon"), "PASS");

				CommonUtility.ScrollTo(driver, obj_UnifiedPortalPage.RemoveMinusButton());
				CommonUtility.ClickOn(driver, obj_UnifiedPortalPage.RemoveMinusButton());
				Thread.sleep(6000);
				int count1=0;
				if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_UnifiedPortalPage.RemoveMinusButton()))
				{
				List<WebElement> list3=driver.findElements(obj_UnifiedPortalPage.RemoveMinusButton());
				count1=list3.size();

				System.out.println(count1);
				}

				Report.put("User navigates at the bottom of the page and clicks on caret icon 'Show Selected Items( site ) ' dropdown",
						"The tray opens revealing the following contents: 1.Selected Items 2.Custom Group Preview buttons :3.Selected Sites section 4.Site name List of Sites selected so far with Site Name for each site Example -if 10 sites are selected ,all 10 should be displayed like this :Site Name 1 (n Assets)Site Name 2 (n Assets)Site Name 3 (n Assets)Site Name 4 (n Assets) Site Name 5 (n Assets) <br>5.Selected product families 6.'All Product Families / No family products-message should be displayed 7. 'Remove' icon should be available against each site user clicks on the   icon ,the site is removed from the selection  8.Hide Selected Items -to close the selection tray and drop back into the 'Create' flow. 9.Create Custom Group button -When user clicks on this ,the Custom group creation is completed and user is directed back to the list page. 10.Cancel button -to cancel the create action and go back to the list page.",
						"User able to click on first minus icon and able to see count of selected sites reduced from "+count+" to "+count1, "PASS");

			}
			else
			{
				System.out.println("not able to see selected products window pop up");
				Report.put("User navigates at the bottom of the page and clicks on caret icon 'Show Selected Items( site ) ' dropdown",
						"The tray opens revealing the following contents: 1.Selected Items 2.Custom Group Preview buttons :3.Selected Sites section 4.Site name List of Sites selected so far with Site Name for each site Example -if 10 sites are selected ,all 10 should be displayed like this :Site Name 1 (n Assets)Site Name 2 (n Assets)Site Name 3 (n Assets)Site Name 4 (n Assets) Site Name 5 (n Assets) <br>5.Selected product families 6.'All Product Families / No family products-message should be displayed 7. 'Remove' icon should be available against each site user clicks on the   icon ,the site is removed from the selection  8.Hide Selected Items -to close the selection tray and drop back into the 'Create' flow. 9.Create Custom Group button -When user clicks on this ,the Custom group creation is completed and user is directed back to the list page. 10.Cancel button -to cancel the create action and go back to the list page.",
						"User not able to see selected items window pop up", "Fail");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("User navigates at the bottom of the page and clicks on caret icon 'Show Selected Items( site ) ' dropdown",
					"The tray opens revealing the following contents: 1.Selected Items 2.Custom Group Preview buttons :3.Selected Sites section 4.Site name List of Sites selected so far with Site Name for each site Example -if 10 sites are selected ,all 10 should be displayed like this :Site Name 1 (n Assets)Site Name 2 (n Assets)Site Name 3 (n Assets)Site Name 4 (n Assets) Site Name 5 (n Assets) <br>5.Selected product families 6.'All Product Families / No family products-message should be displayed 7. 'Remove' icon should be available against each site user clicks on the   icon ,the site is removed from the selection  8.Hide Selected Items -to close the selection tray and drop back into the 'Create' flow. 9.Create Custom Group button -When user clicks on this ,the Custom group creation is completed and user is directed back to the list page. 10.Cancel button -to cancel the create action and go back to the list page.",
					"User not able to see selected items window pop up", "Fail");
			Assert.fail();
		}
	}

	public void ClickOnShowSelectedItemsTab_SitesFamilies_PreviewTab(WebDriver driver)
	{

		Log.info("Inside ClickOnShowSelectedItemsTab_SitesFamilies_PreviewTab method");

		String button = "";
		String header = "";
		String hide="";
		String labelList="";
		String sitesfamilies="";
		WebDriverWait wait = new WebDriverWait(driver, 240);
		try
		{

			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_UnifiedPortalPage.ShowSelectedProductsTab()))
			{

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.ShowSelectedProductsTab());
				button=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.ShowSelectedProductsTab()).getText();
				System.out.println("button is "+button);
				CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.ShowSelectedProductsTab());

			
				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.HideSelectedProductsTab());
				hide=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.HideSelectedProductsTab()).getText();
				System.out.println("link is "+hide);
				
				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.SelectedItemsTab());
				String tab1=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.SelectedItemsTab()).getText();
				System.out.println(tab1);

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.AssetPreviewTab());
				String tab2=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.AssetPreviewTab()).getText();
				System.out.println(tab2);
				CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.AssetPreviewTab());
				
				

				Report.put("User clicks  on caret icon 'Show Selected Items(n Sites n Product Families))' cart:",
						"User should see the below two options on expansion : Selected items and Custom group Preview",
						"User able to click on "+Report.color(button)+" and able to see "+Report.color(hide)+" along with two tabs "+Report.color(tab1+" , "+tab2), "PASS");
				
				Report.put("User Navigates to the Custom group Preview tab ",
						"User should be able to click on Custom group Preview tab",
						"User able to click on "+Report.color(tab2)+" successfully", "PASS");

			}
			else
			{
				System.out.println("not able to see selected items window pop up");
				Report.put("User clicks  on caret icon 'Show Selected Items(n Sites n Product Families))' cart:",
						"User should see the below two options on expansion : Selected items and Custom group Preview",
						"User failed to see selected items window pop up", "Fail");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("User clicks  on caret icon 'Show Selected Items(n Sites n Product Families))' cart:",
					"User should see the below two options on expansion : Selected items and Custom group Preview",
					"User failed to see selected items window pop up", "Fail");
			Assert.fail();
		}
	}

	public void HideSelectedItems_SitesFamilies(WebDriver driver)
	{

		Log.info("Inside HideSelectedItems_SitesFamilies method");


		String selected = "";String hide="";

		WebDriverWait wait = new WebDriverWait(driver, 240);
		try
		{

			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_UnifiedPortalPage.HideSelectedProductsTab()))
			{
				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.HideSelectedProductsTab());
				hide=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.HideSelectedProductsTab()).getText();
				System.out.println("button is "+hide);
				//				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.HideSelectedProductsTab());
				CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.HideSelectedProductsTab());

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.ShowSelectedProductsTab());
				selected=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.ShowSelectedProductsTab()).getText();
				System.out.println("button is "+selected);


				Report.put("User clicks on 'Hide Selected Products ' option",
						"Hide Selected Products collapses the bottom tray and restores to the previous stage",
						"User able to see "+Report.color(hide)+" button, seleted products tray closed and restored provious page ", "PASS");

			}
			else
			{
				System.out.println("not able to see hide selected products button");
				Report.put("User clicks on 'Hide Selected Products ' option",
						"Hide Selected Products collapses the bottom tray and restores to the previous stage",
						"User not able to see hide selected products button", "Fail");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("User clicks on 'Hide Selected Products ' option",
					"Hide Selected Products collapses the bottom tray and restores to the previous stage",
					"User not able to see hide selected products button", "Fail");
			Assert.fail();
		}
	}

	public void verifyColumnNamesInGridOfSelectedItems_PreviewTab(WebDriver driver)
	{

		Log.info("Inside verifyColumnNamesInGridOfSelectedItems_PreviewTab method");

		String button = "";
		String header = "";
		String hide="";
		String labelList="";
		WebDriverWait wait = new WebDriverWait(driver, 240);
		try
		{

			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_UnifiedPortalPage.ColumnNamesInSelectedCustomGroupPreview()))
			{
				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.TextMessageBeforeSelectingSite());	
				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.ColumnNamesInSelectedCustomGroupPreview());	
				List<WebElement> list=driver.findElements(obj_UnifiedPortalPage.ColumnNamesInSelectedCustomGroupPreview());

				for(WebElement lt:list)
				{
					CommonUtility.highlightElement(driver, lt);
					String label=lt.getText();

					System.out.println("column name is : " +label);
					labelList+=" <br> " + label;
				}
				System.out.println("column names are:"+labelList);

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.PaginationLineInShowSelectedPopUp());

				Report.put("User clicks on 'Custom Group Preview' tab ",
						"Below  column should be displayed (IB status's  to be considered - Installed;Shipped;Awaiting Customer Install;Install-T&M ) Asset ID, Product Name, Product Nickname, Site ID, Site Details. User should be able to paginate through the list of selected products .",
						"User able to see Grid details with columns "+Report.color(labelList)+" along with pagination options to view more list", "PASS");

			}
			else
			{
				System.out.println("not able to see grid details");
				Report.put("User clicks on 'Custom Group Preview' tab ",
						"Below  column should be displayed (IB status's  to be considered - Installed;Shipped;Awaiting Customer Install;Install-T&M ) Asset ID, Product Name, Product Nickname, Site ID, Site Details. User should be able to paginate through the list of selected products .",
						"User not able to see Grid details", "Fail");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("User clicks on 'Custom Group Preview' tab ",
					"Below  column should be displayed (IB status's  to be considered - Installed;Shipped;Awaiting Customer Install;Install-T&M ) Asset ID, Product Name, Product Nickname, Site ID, Site Details. User should be able to paginate through the list of selected products .",
					"User not able to see Grid details", "Fail");
			Assert.fail();
		}
	}


	public void SortingColumnsAssertId_CustomGroupPreviewTab(WebDriver driver)
	{

		Log.info("Inside SortingColumnsAssertId_CustomGroupPreviewTab method");

		String assertid = ""; String assertclass="";
		String Prodname=""; String prodclass="";
		String nickname="";String nickclass="";
		String siteid="";String siteidclass="";
		String sitedetils=""; String sitedetclass="";

		WebDriverWait wait = new WebDriverWait(driver, 600);
		try
		{

			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_UnifiedPortalPage.AssetIdSortingSitesFamilies()))
			{	
				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.AssetIdSortingSitesFamilies());
				assertid=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.AssetIdSortingSitesFamilies()).getText();
				System.out.println("column name is "+assertid);
				CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.AssetIdSortingSitesFamilies());

				Thread.sleep(6000);
				assertclass=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.AssetIdSortingSitesFamilies()).getAttribute("class");
				System.out.println("class is "+assertclass);

				if(!(assertclass.contains("sorting_desc")|| assertclass.contains("sorting_asc")))
				{
					System.out.println("not able to see asset id sorting");
					Report.put("User verifies sort on the following columns in ascending and descending order ",
							" User should be able to sort on the following columns in ascending and descending order Asset ID,Product Name,Product family,Product Nickname,Site ID,Site Details",
							"User not able to see asset id sorting", "Fail");
					Assert.fail();
				}

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.ProductNameSortingSitesFamilies());
				Prodname=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.ProductNameSortingSitesFamilies()).getText();
				System.out.println("column name is "+Prodname);
				CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.ProductNameSortingSitesFamilies());

				Thread.sleep(6000);
				prodclass=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.ProductNameSortingSitesFamilies()).getAttribute("class");
				System.out.println("class is "+prodclass);

				if(!(prodclass.contains("sorting_desc")|| prodclass.contains("sorting_asc")))
				{
					System.out.println("not able to see product name sorting");
					Report.put("User verifies sort on the following columns in ascending and descending order ",
							" User should be able to sort on the following columns in ascending and descending order Asset ID,Product Name,Product family,Product Nickname,Site ID,Site Details",
							"User not able to see product name sorting", "Fail");
					Assert.fail();
				}

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.ProductFamilySortingSitesFamilies());
				sitedetils=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.ProductFamilySortingSitesFamilies()).getText();
				System.out.println("column name is "+sitedetils);
				CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.ProductFamilySortingSitesFamilies());

				Thread.sleep(6000);
				sitedetclass=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.ProductFamilySortingSitesFamilies()).getAttribute("class");
				System.out.println("class is "+sitedetclass);

				if(!(sitedetclass.contains("sorting_desc")|| sitedetclass.contains("sorting_asc")))
				{
					System.out.println("not able to see site details sorting");
					Report.put("User verifies sort on the following columns in ascending and descending order ",
							" User should be able to sort on the following columns in ascending and descending order Asset ID,Product Name,Product family,Product Nickname,Site ID,Site Details",
							"User failed to see Product family sorting", "Fail");
					Assert.fail();
				}
				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.ProductNicknameSortingSitesFamilies());
				nickname=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.ProductNicknameSortingSitesFamilies()).getText();
				System.out.println("column name is "+nickname);
				CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.ProductNicknameSortingSitesFamilies());

				Thread.sleep(6000);
				nickclass=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.ProductNicknameSortingSitesFamilies()).getAttribute("class");
				System.out.println("class is "+nickclass);

				if(!(nickclass.contains("sorting_desc")|| nickclass.contains("sorting_asc")))
				{
					System.out.println("not able to see product nickname sorting");
					Report.put("User verifies sort on the following columns in ascending and descending order ",
							" User should be able to sort on the following columns in ascending and descending order Asset ID,Product Name,Product family,Product Nickname,Site ID,Site Details",
							"User failed to see product nickname sorting", "Fail");
					Assert.fail();
				}

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.SiteIDSortingSitesFamilies());
				siteid=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.SiteIDSortingSitesFamilies()).getText();
				System.out.println("column name is "+siteid);
				CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.SiteIDSortingSitesFamilies());

				Thread.sleep(6000);
				siteidclass=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.SiteIDSortingSitesFamilies()).getAttribute("class");
				System.out.println("class is "+siteidclass);

				if(!(siteidclass.contains("sorting_desc")|| siteidclass.contains("sorting_asc")))
				{
					System.out.println("not able to see site id sorting");
					Report.put("User verifies sort on the following columns in ascending and descending order ",
							" User should be able to sort on the following columns in ascending and descending order Asset ID,Product Name,Product family,Product Nickname,Site ID,Site Details",
							"User failed to see site id sorting", "Fail");
					Assert.fail();
				}


				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.SiteDetailsSortingSitesFamilies());
				sitedetils=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.SiteDetailsSortingSitesFamilies()).getText();
				System.out.println("column name is "+sitedetils);
				CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.SiteDetailsSortingSitesFamilies());

				Thread.sleep(6000);
				sitedetclass=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.SiteDetailsSortingSitesFamilies()).getAttribute("class");
				System.out.println("class is "+sitedetclass);

				if(!(sitedetclass.contains("sorting_desc")|| sitedetclass.contains("sorting_asc")))
				{
					System.out.println("not able to see site details sorting");
					Report.put("User verifies sort on the following columns in ascending and descending order ",
							" User should be able to sort on the following columns in ascending and descending order Asset ID,Product Name,Product family,Product Nickname,Site ID,Site Details",
							"User failed to see site details sorting", "Fail");
					Assert.fail();
				}


				Report.put("User verifies sort on the following columns in ascending and descending order ",
						" User should be able to sort on the following columns in ascending and descending order Asset ID,Product Name,Product family,Product Nickname,Site ID,Site Details",
						"User able to sort all columns in ascending and descending", "PASS");

			}
			else
			{
				System.out.println("not able to sort column names");
				Report.put("User verifies sort on the following columns in ascending and descending order ",
						" User should be able to sort on the following columns in ascending and descending order Asset ID,Product Name,Product family,Product Nickname,Site ID,Site Details",
						"User failed to sort column names", "Fail");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("User verifies sort on the following columns in ascending and descending order ",
					" User should be able to sort on the following columns in ascending and descending order Asset ID,Product Name,Product family,Product Nickname,Site ID,Site Details",
					"User failed to sort column names", "Fail");
			Assert.fail();
		}
	}


	public void validateFilterSection_PreviewTab(WebDriver driver, String search)
	{

		Log.info("Inside validateFilterSection_PreviewTab method");

		String button = "";

		WebDriverWait wait = new WebDriverWait(driver, 600);
		try
		{

			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_UnifiedPortalPage.FilterTextBoxInPreviewTab()))
			{

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.FilterTextBoxInPreviewTab());
				CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.FilterTextBoxInPreviewTab()).clear();
				CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.FilterTextBoxInPreviewTab()).sendKeys(search);

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.SearchFilterButtonPreviewTab());
				CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.SearchFilterButtonPreviewTab());

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.ClearXButtonPreviewTab());

				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_UnifiedPortalPage.HighlightedTextValidation()));
				List<WebElement> list=driver.findElements(obj_UnifiedPortalPage.HighlightedTextValidation());

				for(int i=0;i<list.size();i++)
				{
					CommonUtility.ScrollToWebElement(driver, list.get(i));
				}

				Report.put("User tries to filter the products using the Filter icon on the right",
						"User should be able to select the filter based on Asset ID, Product Name, Product family,Product Nickname, Site ID, Site Details , Results will be highlighted with a clear (X) option",
						"User able to search using filter and able to see searched option highlighted and able to see clear (X) option", "PASS");

			}
			else
			{
				System.out.println("not able to see filter text box");
				Report.put("User tries to filter the products using the Filter icon on the right",
						"User should be able to select the filter based on Asset ID, Product Name,Product family, Product Nickname, Site ID, Site Details , Results will be highlighted with a clear (X) option",
						"User not able to see filter text box", "Fail");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("User tries to filter the products using the Filter icon on the right",
					"User should be able to select the filter based on Asset ID, Product Name, Product family,Product Nickname, Site ID, Site Details , Results will be highlighted with a clear (X) option",
					"User not able to see filter text box", "Fail");
			Assert.fail();
		}
	}

	
	public void validateFilterSection_Slectedtems_PreviewTab(WebDriver driver, String search)
	{

		Log.info("Inside validateFilterSection_Slectedtems_PreviewTab method");

		String button = "";

		WebDriverWait wait = new WebDriverWait(driver, 600);
		try
		{

			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_UnifiedPortalPage.FilterTextBoxInSelectedItemsPreviewTab()))
			{

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.FilterTextBoxInSelectedItemsPreviewTab());
				CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.FilterTextBoxInSelectedItemsPreviewTab()).clear();
				CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.FilterTextBoxInSelectedItemsPreviewTab()).sendKeys(search);

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.SearchFilterButtonSelectedItemsPreviewTab());
				CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.SearchFilterButtonSelectedItemsPreviewTab());

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.ClearXButtonSelectedItemsPreviewTab());

				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_UnifiedPortalPage.HighlightedTextValidation()));
				List<WebElement> list=driver.findElements(obj_UnifiedPortalPage.HighlightedTextValidation());

				for(int i=0;i<list.size();i++)
				{
					CommonUtility.ScrollToWebElement(driver, list.get(i));
				}

				Report.put("User tries to filter the products using the Filter icon on the right",
						"User should be able to select the filter based on Asset ID, Product Name, Product family,Product Nickname, Site ID, Site Details , Results will be highlighted with a clear (X) option",
						"User able to search using filter and able to see searched option highlighted and able to see clear (X) option", "PASS");

			}
			else
			{
				System.out.println("not able to see filter text box");
				Report.put("User tries to filter the products using the Filter icon on the right",
						"User should be able to select the filter based on Asset ID, Product Name,Product family, Product Nickname, Site ID, Site Details , Results will be highlighted with a clear (X) option",
						"User not able to see filter text box", "Fail");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("User tries to filter the products using the Filter icon on the right",
					"User should be able to select the filter based on Asset ID, Product Name, Product family,Product Nickname, Site ID, Site Details , Results will be highlighted with a clear (X) option",
					"User not able to see filter text box", "Fail");
			Assert.fail();
		}
	}
	public void ClickSelectProductFamilyTab(WebDriver driver)
	{

		Log.info("Inside ClickSelectProductFamilyTab method");

		String button = "";

		WebDriverWait wait = new WebDriverWait(driver, 600);

		try
		{

			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_UnifiedPortalPage.SelectProductFamiliesTab()))
			{

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.SelectProductFamiliesTab());
				boolean b=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.SelectProductFamiliesTab()).isEnabled();
				if(b==true)
				{
					System.out.println("able to see Select product families enabled");
					CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.SelectProductFamiliesTab());
					CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.SelectProductFamiliesTab());
					Thread.sleep(6000);
					
					verifyMessageOnRightSideBeforeSelectingProductFamilies(driver);
					
					Thread.sleep(6000);
					if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_UnifiedPortalPage.SelectedProductFamilyTabTableListHeading()))
					{
						CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.CountrySelector());
						CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.SelectedProductFamilyTabTableListHeading());
						List<WebElement> list=driver.findElements(obj_UnifiedPortalPage.SelectedProductFamilyTabTableListHeading());

						int count=list.size();
						System.out.println("total number of checkbox product family displayed is "+count);
						int count1=0;
						for(int i=0;i<list.size();i++)
						{
							count1++;

							if(count1==1)
							{
								try
								{
									if (!(list.get(i).isSelected())) 
									{
										try
										{
											Thread.sleep(3000);
											CommonUtility.ScrollToWebElement(driver, list.get(i));
											CommonUtility.ClickOnWebElement(driver, list.get(i));

											Thread.sleep(3000);
										}
										catch(Exception e)
										{

										}
									}
								}
								catch(Exception e)
								{

								}
							}
							else
							{
								break;
							}


						}
					}

				}
				else
				{

					System.out.println("able to see Select product families enabled");
					Report.put("User clicks 'Select Product Families' tab and selects one of the ",
							"User should be able o view The list of assets for the selected product family should be displayed in the grid ,and the following fields should be available: (IB status's  to be considered - Installed;Shipped;Awaiting Customer Install;Install-T&M ),Asset ID ,Product Name, Product Nickname, Site ID, Site Details (Name and Address)",
							"User able to see Select Product Families tab is disabled", "Fail");
					Assert.fail();
				}


				Report.put("User clicks 'Select Product Families' tab and selects one of the ",
						"User should be able o view The list of assets for the selected product family should be displayed in the grid ,and the following fields should be available: (IB status's  to be considered - Installed;Shipped;Awaiting Customer Install;Install-T&M ),Asset ID ,Product Name, Product Nickname, Site ID, Site Details (Name and Address)",
						"User able to see Select Product Families tab is enabled, and able to click on it", "PASS");


			}
			else
			{
				System.out.println("able to see Select product families tab is disabled");
				Report.put("User clicks 'Select Product Families' tab and selects one of the ",
						"User should be able o view The list of assets for the selected product family should be displayed in the grid ,and the following fields should be available: (IB status's  to be considered - Installed;Shipped;Awaiting Customer Install;Install-T&M ),Asset ID ,Product Name, Product Nickname, Site ID, Site Details (Name and Address)",
						"User able to see Select Product Families tab is disabled", "Fail");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("User clicks 'Select Product Families' tab and selects one of the ",
					"User should be able o view The list of assets for the selected product family should be displayed in the grid ,and the following fields should be available: (IB status's  to be considered - Installed;Shipped;Awaiting Customer Install;Install-T&M ),Asset ID ,Product Name, Product Nickname, Site ID, Site Details (Name and Address)",
					"User able to see Select Product Families tab is disabled", "Fail");
			Assert.fail();
		}
	}

	public void ClickSelectProductFamilyTab_ED(WebDriver driver)
	{

		Log.info("Inside ClickSelectProductFamilyTab_ED method");

		String button = "";

		WebDriverWait wait = new WebDriverWait(driver, 600);

		try
		{

			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_UnifiedPortalPage.SelectProductFamiliesTab()))
			{
				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.SearchTextBox());
				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.SelectProductFamiliesTab());
				boolean b=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.SelectProductFamiliesTab()).isEnabled();
				if(b==true)
				{
					System.out.println("able to see Select product families enabled");
					CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.SelectProductFamiliesTab());
					CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.SelectProductFamiliesTab());
					Thread.sleep(6000);
					if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_UnifiedPortalPage.SelectProductFamilyTableListItemsED()))
					{
						CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.createCustomGroupButton());
						CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.SelectProductFamilyTableListItemsED());
						List<WebElement> list=driver.findElements(obj_UnifiedPortalPage.SelectProductFamilyTableListItemsED());

						int count=list.size();
						System.out.println("total number of checkbox product family displayed is "+count);
						int count1=0;
						for(int i=0;i<list.size();i++)
						{
							count1++;

							if(count1==1)
							{
								try
								{
									if (!(list.get(i).isSelected())) 
									{
										try
										{
											Thread.sleep(3000);
//											CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.CountrySelector());
											CommonUtility.ScrollToWebElement(driver, list.get(i));
											CommonUtility.ClickOnWebElement(driver, list.get(i));

											Thread.sleep(3000);
										}
										catch(Exception e)
										{

										}
									}
								}
								catch(Exception e)
								{

								}
							}
							else
							{
								break;
							}


						}
					}

				}
				else
				{

					System.out.println("able to see Select product families enabled");
					Report.put("User clicks 'Select Product Families' tab and selects one of the ",
							"User should be able o view The list of assets for the selected product family should be displayed in the grid ,and the following fields should be available: (IB status's  to be considered - Installed;Shipped;Awaiting Customer Install;Install-T&M ),Asset ID ,Product Name, Product Nickname, Site ID, Site Details (Name and Address)",
							"User able to see Select Product Families tab is disabled", "Fail");
					Assert.fail();
				}


				Report.put("User clicks 'Select Product Families' tab and selects one of the ",
						"User should be able o view The list of assets for the selected product family should be displayed in the grid ,and the following fields should be available: (IB status's  to be considered - Installed;Shipped;Awaiting Customer Install;Install-T&M ),Asset ID ,Product Name, Product Nickname, Site ID, Site Details (Name and Address)",
						"User able to see Select Product Families tab is enabled, and able to click on it", "PASS");


			}
			else
			{
				System.out.println("able to see Select product families tab is disabled");
				Report.put("User clicks 'Select Product Families' tab and selects one of the ",
						"User should be able o view The list of assets for the selected product family should be displayed in the grid ,and the following fields should be available: (IB status's  to be considered - Installed;Shipped;Awaiting Customer Install;Install-T&M ),Asset ID ,Product Name, Product Nickname, Site ID, Site Details (Name and Address)",
						"User able to see Select Product Families tab is disabled", "Fail");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("User clicks 'Select Product Families' tab and selects one of the ",
					"User should be able o view The list of assets for the selected product family should be displayed in the grid ,and the following fields should be available: (IB status's  to be considered - Installed;Shipped;Awaiting Customer Install;Install-T&M ),Asset ID ,Product Name, Product Nickname, Site ID, Site Details (Name and Address)",
					"User able to see Select Product Families tab is disabled", "Fail");
			Assert.fail();
		}
	}
	public void validateDiaabledButtonEnabledOnSelectingAnyCheckBox_ED(WebDriver driver)
	{

		Log.info("Inside validateDiaabledButtonEnabledOnSelectingAnyCheckBox_ED method");

		String button = "";
		String button1="";
		String cancel="";
		String button2="";

		WebDriverWait wait = new WebDriverWait(driver, 600);
		try
		{

			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_UnifiedPortalPage.FirstCheckBoxForSiteFamilyED()))
			{

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.CustomGroupNameTextBox());	
				CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.CustomGroupNameTextBox()).clear();
				CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.CustomGroupNameTextBox()).sendKeys(TestNGCreator.TestData.get(Esupport.FirstName.ordinal()));
				//				List<WebElement> list1=driver.findElements(obj_UnifiedPortalPage.CheckBoxForSelectingSitesForSitesOrFamilies());
				//
				//				int count3=list1.size();
				//				System.out.println("total number of sites displayed in table "+count3);
				//				int count2=0;
				//				for(int i=0;i<10;i++)
				//				{
				//					count2++;
				//
				//					if(count2==1)
				//					{
				//						if (!(list1.get(i).isSelected())) 
				//						{
				//							try
				//							{
				//								CommonUtility.ScrollToWebElement(driver, list1.get(i));
				//								CommonUtility.ClickOnWebElement(driver, list1.get(i));
				//
				//								
				//							}
				//							catch(Exception e)
				//							{
				//
				//							}
				//						}
				//					}
				//					else
				//					{
				//						break;
				//					}
				//				}
				CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.CountrySelector());
				if(CommonUtility.CheckpresenceofElementLocated(driver,10,obj_UnifiedPortalPage.FirstCheckBoxForSiteFamilyED()))
				{
					CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.FirstCheckBoxForSiteFamilyED());
					CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.FirstCheckBoxForSiteFamilyED());
				}

				if(CommonUtility.CheckpresenceofElementLocated(driver,10,obj_UnifiedPortalPage.SecondCheckBoxForSiteFamilyED()))
				{
					CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.SecondCheckBoxForSiteFamilyED());
					CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.SecondCheckBoxForSiteFamilyED());
				}

				if(CommonUtility.CheckpresenceofElementLocated(driver,10,obj_UnifiedPortalPage.ThirdCheckBoxForSiteFamilyED()))
				{
					CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.ThirdCheckBoxForSiteFamilyED());
					CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.ThirdCheckBoxForSiteFamilyED());
				}

				if(CommonUtility.CheckpresenceofElementLocated(driver,10,obj_UnifiedPortalPage.ForthCheckBoxForSiteFamilyED()))
				{
					CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.ForthCheckBoxForSiteFamilyED());
					CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.ForthCheckBoxForSiteFamilyED());
				}

				if(CommonUtility.CheckpresenceofElementLocated(driver,10,obj_UnifiedPortalPage.FifthCheckBoxForSiteFamilyED()))
				{
					CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.FifthCheckBoxForSiteFamilyED());
					CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.FifthCheckBoxForSiteFamilyED());
				}
				if(CommonUtility.CheckpresenceofElementLocated(driver,10,obj_UnifiedPortalPage.SixthCheckBoxForSiteFamilyED()))
				{
					CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.SixthCheckBoxForSiteFamilyED());
					CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.SixthCheckBoxForSiteFamilyED());
				}

				Thread.sleep(3000);


				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_UnifiedPortalPage.CreateCustomGroupButtonEnable()));
				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.CreateCustomGroupButtonEnable());
				button1=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.CreateCustomGroupButtonEnable()).getText();
				System.out.println("button is "+button1);

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.CancelButton());
				cancel=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.CancelButton()).getText();
				System.out.println("button is "+cancel);

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.ShowSelectedProductsTab());
				button2=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.ShowSelectedProductsTab()).getText();
				System.out.println("button is "+button2);

				Report.put("User verifies Create Custom Group , cancel , Show Selected Products at the bottom of the page ",
						"Create Custom Group , cancel , Show Selected Products options are enabled ",
						"User able to see "+Report.color(button1)+ " button enabled with "+Report.color(cancel)+" and able to see "+Report.color(button2)+ " tab displayed by selecting any check box of site in left side", "PASS");

			}
			else
			{

				System.out.println("not able to see sites in table");
				Report.put("User verifies Create Custom Group , cancel , Show Selected Products at the bottom of the page ",
						"Create Custom Group , cancel , Show Selected Products options are enabled ",
						"User not able to see sites in table", "Fail");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("User verifies Create Custom Group , cancel , Show Selected Products at the bottom of the page ",
					"Create Custom Group , cancel , Show Selected Products options are enabled ",
					"User not able to see sites in table", "Fail");
			Assert.fail();
		}
	}

	public void validateDiaabledButtonEnabledOnSelectingAnyCheckBox_IE(WebDriver driver)
	{

		Log.info("Inside validateDiaabledButtonEnabledOnSelectingAnyCheckBox_IE method");

		String button = "";
		String button1="";
		String cancel="";
		String button2="";

		WebDriverWait wait = new WebDriverWait(driver, 600);
		try
		{

			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_UnifiedPortalPage.FiestCheckBoxForSiteFamilyIE()))
			{

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.CustomGroupNameTextBox());	
				CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.CustomGroupNameTextBox()).clear();
				CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.CustomGroupNameTextBox()).sendKeys(TestNGCreator.TestData.get(Esupport.FirstName.ordinal()));
				//				List<WebElement> list1=driver.findElements(obj_UnifiedPortalPage.CheckBoxForSelectingSitesForSitesOrFamilies());
				//
				//				int count3=list1.size();
				//				System.out.println("total number of sites displayed in table "+count3);
				//				int count2=0;
				//				for(int i=0;i<10;i++)
				//				{
				//					count2++;
				//
				//					if(count2==1)
				//					{
				//						if (!(list1.get(i).isSelected())) 
				//						{
				//							try
				//							{
				//								CommonUtility.ScrollToWebElement(driver, list1.get(i));
				//								CommonUtility.ClickOnWebElement(driver, list1.get(i));
				//
				//								
				//							}
				//							catch(Exception e)
				//							{
				//
				//							}
				//						}
				//					}
				//					else
				//					{
				//						break;
				//					}
				//				}
				//				CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.CountrySelector());
				if(CommonUtility.CheckpresenceofElementLocated(driver,10,obj_UnifiedPortalPage.FiestCheckBoxForSiteFamilyIE()))
				{
					CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.FiestCheckBoxForSiteFamilyIE());
					CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.FiestCheckBoxForSiteFamilyIE());
				}

				if(CommonUtility.CheckpresenceofElementLocated(driver,10,obj_UnifiedPortalPage.SecCheckBoxForSiteFamilyIE()))
				{
					CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.SecCheckBoxForSiteFamilyIE());
					CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.SecCheckBoxForSiteFamilyIE());
				}

				if(CommonUtility.CheckpresenceofElementLocated(driver,10,obj_UnifiedPortalPage.ThirdCheckBoxForSiteFamilyIE()))
				{
					CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.ThirdCheckBoxForSiteFamilyIE());
					CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.ThirdCheckBoxForSiteFamilyIE());
				}

				if(CommonUtility.CheckpresenceofElementLocated(driver,10,obj_UnifiedPortalPage.ForthCheckBoxForSiteFamilyIE()))
				{
					CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.ForthCheckBoxForSiteFamilyIE());
					CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.ForthCheckBoxForSiteFamilyIE());
				}

				if(CommonUtility.CheckpresenceofElementLocated(driver,10,obj_UnifiedPortalPage.FifthCheckBoxForSiteFamilyIE()))
				{
					CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.FifthCheckBoxForSiteFamilyIE());
					CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.FifthCheckBoxForSiteFamilyIE());
				}
				if(CommonUtility.CheckpresenceofElementLocated(driver,10,obj_UnifiedPortalPage.SixCheckBoxForSiteFamilyIE()))
				{
					CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.SixCheckBoxForSiteFamilyIE());
					CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.SixCheckBoxForSiteFamilyIE());
				}

				Thread.sleep(3000);


				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_UnifiedPortalPage.CreateCustomGroupButtonEnable()));
				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.CreateCustomGroupButtonEnable());
				button1=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.CreateCustomGroupButtonEnable()).getText();
				System.out.println("button is "+button1);

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.CancelButton());
				cancel=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.CancelButton()).getText();
				System.out.println("button is "+cancel);

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.ShowSelectedProductsTab());
				button2=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.ShowSelectedProductsTab()).getText();
				System.out.println("button is "+button2);

				Report.put("User verifies Create Custom Group , cancel , Show Selected Products at the bottom of the page ",
						"Create Custom Group , cancel , Show Selected Products options are enabled ",
						"User able to see "+Report.color(button1)+ " button enabled with "+Report.color(cancel)+" and able to see "+Report.color(button2)+ " tab displayed by selecting any check box of site in left side", "PASS");

			}
			else
			{

				System.out.println("not able to see sites in table");
				Report.put("User verifies Create Custom Group , cancel , Show Selected Products at the bottom of the page ",
						"Create Custom Group , cancel , Show Selected Products options are enabled ",
						"User not able to see sites in table", "Fail");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("User verifies Create Custom Group , cancel , Show Selected Products at the bottom of the page ",
					"Create Custom Group , cancel , Show Selected Products options are enabled ",
					"User not able to see sites in table", "Fail");
			Assert.fail();
		}
	}

	public void clickOnXButtonOfFilterClear_SiteFamily(WebDriver driver)
	{

		Log.info("Inside clickOnXButtonOfFilterClear_SiteFamily method");

		String button = "";

		WebDriverWait wait = new WebDriverWait(driver, 600);
		try
		{

			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_UnifiedPortalPage.ClearXButtonSitesFamily()))
			{

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.ClearXButtonSitesFamily());
				CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.ClearXButtonSitesFamily());
				Thread.sleep(6000);

				if(CommonUtility.CheckpresenceofElementLocated(driver,10,obj_UnifiedPortalPage.ClearXButtonSitesFamily()))
				{
					System.out.println("able to see highlighted search in the grid");
					Report.put("User clicks on the option to clear the 'filter' using 'X'",
							"Data set restores to the original ",
							"User able to see searched view in grid", "Fail");
					Assert.fail();
				}
				else
				{
					System.out.println("not able to see X button");
				}

				Report.put("User clicks on the option to clear the 'filter' using 'X'",
						"Data set restores to the original ",
						"User able to see data refresh and display grid", "PASS");

			}
			else
			{
				System.out.println("not able to see X button");
				Report.put("User clicks on the option to clear the 'filter' using 'X'",
						"Data set restores to the original ",
						"User not able to see X button", "Fail");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("User clicks on the option to clear the 'filter' using 'X'",
					"Data set restores to the original ",
					"User not able to see X button", "Fail");
			Assert.fail();
		}
	}

	public void clickOnXButtonOfFilterClear_SelectedItems_SiteFamily(WebDriver driver)
	{

		Log.info("Inside clickOnXButtonOfFilterClear_SelectedItems_SiteFamily method");

		String button = "";

		WebDriverWait wait = new WebDriverWait(driver, 600);
		try
		{

			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_UnifiedPortalPage.ClearXButtonSelectedItemsPreviewTab()))
			{

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.ClearXButtonSelectedItemsPreviewTab());
				CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.ClearXButtonSelectedItemsPreviewTab());
				Thread.sleep(6000);

				if(CommonUtility.CheckpresenceofElementLocated(driver,10,obj_UnifiedPortalPage.ClearXButtonSelectedItemsPreviewTab()))
				{
					System.out.println("able to see highlighted search in the grid");
					Report.put("User clicks on the option to clear the 'filter' using 'X'",
							"Data set restores to the original ",
							"User able to see searched view in grid", "Fail");
					Assert.fail();
				}
				else
				{
					System.out.println("not able to see X button");
				}

				Report.put("User clicks on the option to clear the 'filter' using 'X'",
						"Data set restores to the original ",
						"User able to see data refresh and display grid", "PASS");

			}
			else
			{
				System.out.println("not able to see X button");
				Report.put("User clicks on the option to clear the 'filter' using 'X'",
						"Data set restores to the original ",
						"User not able to see X button", "Fail");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("User clicks on the option to clear the 'filter' using 'X'",
					"Data set restores to the original ",
					"User not able to see X button", "Fail");
			Assert.fail();
		}
	}

	public void validateChangeSiteSelectionAfterSelectingProductFamily_SiteFamily(WebDriver driver)
	{

		Log.info("Inside validateChangeSiteSelectionAfterSelectingProductFamily_SiteFamily method");

		String message = "";

		WebDriverWait wait = new WebDriverWait(driver, 600);
		try
		{

			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_UnifiedPortalPage.SelectSitesTab()))
			{
				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.CustomGroupNameTextBox());	

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.SelectSitesTab());	
				String serby=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.SelectSitesTab()).getText();	
				System.out.println("header is "+serby);
				CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.SelectSitesTab());

				CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.CountrySelector());
				if(CommonUtility.CheckpresenceofElementLocated(driver,10,obj_UnifiedPortalPage.SeventhCheckBoxForSiteFamily()))
				{
					CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.SeventhCheckBoxForSiteFamily());
					CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.SeventhCheckBoxForSiteFamily());
				}
				if(CommonUtility.CheckpresenceofElementLocated(driver,10,obj_UnifiedPortalPage.SelectionUpdatedMessageSiteFamily()))
				{
					CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.SelectionUpdatedMessageSiteFamily());
					message=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.SelectionUpdatedMessageSiteFamily()).getText();	
					System.out.println("message is "+message);
				}
				else
				{
					System.out.println("failed to see message");
					Report.put("Scenario :If user change selection in sites after product families selection, should show Warning message to user :<br> User selects a few sites and then proceeds to select a few product families and wants to go back to change site selections",
							"User should receive the below warning message :Selections updated. The Product Families list has been updated to reflect the Sites selected.” ",
							"User failed to see warning message", "Fail");
					Assert.fail();
				}
				Report.put("Scenario :If user change selection in sites after product families selection, should show Warning message to user :<br> User selects a few sites and then proceeds to select a few product families and wants to go back to change site selections",
						"User should receive the below warning message :Selections updated. The Product Families list has been updated to reflect the Sites selected.” ",
						"Clicking on "+Report.color(serby)+"User able to see warining message "+Report.color(message), "PASS");

			}
			else
			{
				System.out.println("not able to see X button");
				Report.put("Scenario :If user change selection in sites after product families selection, should show Warning message to user :<br> User selects a few sites and then proceeds to select a few product families and wants to go back to change site selections",
						"User should receive the below warning message :Selections updated. The Product Families list has been updated to reflect the Sites selected.” ",
						"User failed to see selected sites tab", "Fail");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Scenario :If user change selection in sites after product families selection, should show Warning message to user :<br> User selects a few sites and then proceeds to select a few product families and wants to go back to change site selections",
					"User should receive the below warning message :Selections updated. The Product Families list has been updated to reflect the Sites selected.” ",
					"User failed to see selected sites tab", "Fail");
			Assert.fail();
		}
	}
	
	
	

	public void ClickOnProductFamilyCheckBox(WebDriver driver)
	{

		Log.info("Inside ClickOnProductFamilyCheckBox method");

		String button = "";

		WebDriverWait wait = new WebDriverWait(driver, 600);
		try
		{

			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_UnifiedPortalPage.FirstCheckBoxForSiteFamily()))
			{

				if(CommonUtility.CheckpresenceofElementLocated(driver,10,obj_UnifiedPortalPage.FirstCheckBoxForSiteFamily()))
				{
					CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.FirstCheckBoxForSiteFamily());
					CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.FirstCheckBoxForSiteFamily());
				}

				else
				{
					System.out.println("not able to see product family list in table");
					Report.put("User selects the product family from the list",
							"User should be able to select product family from list on left side",
							"User failed to see product family list", "Fail");
					Assert.fail();
				}

				Report.put("User selects the product family from the list",
						"User should be able to select product family from list on left side",
						"User able to see select first displayed product family", "PASS");

			}
			else
			{
				System.out.println("not able to see product family list in table");
				Report.put("User selects the product family from the list",
						"User should be able to select product family from list on left side",
						"User failed to see product family list", "Fail");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("User selects the product family from the list",
					"User should be able to select product family from list on left side",
					"User failed to see product family list", "Fail");
			Assert.fail();
		}
	}

	public void ClickOnProductFamilyCheckBox_ED(WebDriver driver)
	{

		Log.info("Inside ClickOnProductFamilyCheckBox_ED method");

		String button = "";

		WebDriverWait wait = new WebDriverWait(driver, 600);
		try
		{

			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_UnifiedPortalPage.FirstCheckBoxForSiteFamily()))
			{

				if(CommonUtility.CheckpresenceofElementLocated(driver,10,obj_UnifiedPortalPage.FirstCheckBoxForSiteFamily()))
				{
					CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.CountrySelector());
					CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.FirstCheckBoxForSiteFamily());
					CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.FirstCheckBoxForSiteFamily());
				}

				else
				{
					System.out.println("not able to see product family list in table");
					Report.put("User selects the product family from the list",
							"User should be able to select product family from list on left side",
							"User failed to see product family list", "Fail");
					Assert.fail();
				}

				Report.put("User selects the product family from the list",
						"User should be able to select product family from list on left side",
						"User able to see select first displayed product family", "PASS");

			}
			else
			{
				System.out.println("not able to see product family list in table");
				Report.put("User selects the product family from the list",
						"User should be able to select product family from list on left side",
						"User failed to see product family list", "Fail");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("User selects the product family from the list",
					"User should be able to select product family from list on left side",
					"User failed to see product family list", "Fail");
			Assert.fail();
		}
	}
	public void ClickOnProductFamilyCheckBox_IE(WebDriver driver)
	{

		Log.info("Inside ClickOnProductFamilyCheckBox_IE method");

		String button = "";

		WebDriverWait wait = new WebDriverWait(driver, 600);
		try
		{

			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_UnifiedPortalPage.FiestCheckBoxForSiteFamilyIE()))
			{

				if(CommonUtility.CheckpresenceofElementLocated(driver,10,obj_UnifiedPortalPage.FiestCheckBoxForSiteFamilyIE()))
				{
					CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.FiestCheckBoxForSiteFamilyIE());
					CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.FiestCheckBoxForSiteFamilyIE());
				}

				else
				{
					System.out.println("not able to see product family list in table");
					Report.put("User selects the product family from the list",
							"User should be able to select product family from list on left side",
							"User failed to see product family list", "Fail");
					Assert.fail();
				}

				Report.put("User selects the product family from the list",
						"User should be able to select product family from list on left side",
						"User able to see select first displayed product family", "PASS");

			}
			else
			{
				System.out.println("not able to see product family list in table");
				Report.put("User selects the product family from the list",
						"User should be able to select product family from list on left side",
						"User failed to see product family list", "Fail");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("User selects the product family from the list",
					"User should be able to select product family from list on left side",
					"User failed to see product family list", "Fail");
			Assert.fail();
		}
	}

	public void validateChangeSiteSelectionAfterSelectingProductFamily_SiteFamily_IE(WebDriver driver)
	{

		Log.info("Inside validateChangeSiteSelectionAfterSelectingProductFamily_SiteFamily_IE method");

		String message = "";

		WebDriverWait wait = new WebDriverWait(driver, 600);
		try
		{

			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_UnifiedPortalPage.SelectSitesTab()))
			{

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.SelectSitesTab());	
				String serby=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.SelectSitesTab()).getText();	
				System.out.println("header is "+serby);
				CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.SelectSitesTab());

				CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.CountrySelector());
				if(CommonUtility.CheckpresenceofElementLocated(driver,10,obj_UnifiedPortalPage.SeventhCheckBoxForSiteFamilyIE()))
				{
					CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.SeventhCheckBoxForSiteFamilyIE());
					CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.SeventhCheckBoxForSiteFamilyIE());
				}
				if(CommonUtility.CheckpresenceofElementLocated(driver,10,obj_UnifiedPortalPage.SelectionUpdatedMessageSiteFamily()))
				{
					CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.SelectionUpdatedMessageSiteFamily());
					message=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.SelectionUpdatedMessageSiteFamily()).getText();	
					System.out.println("message is "+message);
				}
				else
				{
					System.out.println("failed to see message");
					Report.put("Scenario :If user change selection in sites after product families selection, should show Warning message to user :<br> User selects a few sites and then proceeds to select a few product families and wants to go back to change site selections",
							"User should receive the below warning message :Selections updated. The Product Families list has been updated to reflect the Sites selected.” ",
							"User failed to see warning message", "Fail");
					Assert.fail();
				}
				Report.put("Scenario :If user change selection in sites after product families selection, should show Warning message to user :<br> User selects a few sites and then proceeds to select a few product families and wants to go back to change site selections",
						"User should receive the below warning message :Selections updated. The Product Families list has been updated to reflect the Sites selected.” ",
						"Clicking on "+Report.color(serby)+"User able to see warining message "+Report.color(message), "PASS");

			}
			else
			{
				System.out.println("not able to see X button");
				Report.put("Scenario :If user change selection in sites after product families selection, should show Warning message to user :<br> User selects a few sites and then proceeds to select a few product families and wants to go back to change site selections",
						"User should receive the below warning message :Selections updated. The Product Families list has been updated to reflect the Sites selected.” ",
						"User failed to see selected sites tab", "Fail");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Scenario :If user change selection in sites after product families selection, should show Warning message to user :<br> User selects a few sites and then proceeds to select a few product families and wants to go back to change site selections",
					"User should receive the below warning message :Selections updated. The Product Families list has been updated to reflect the Sites selected.” ",
					"User failed to see selected sites tab", "Fail");
			Assert.fail();
		}
	}


	public void clickOnEdit_ValidateDisplayedPage_Products(WebDriver driver)
	{

		Log.info("Inside clickOnEdit_ValidateDisplayedPage_Products method");
		String item=TestNGCreator.TestData.get(Esupport.SearchOption.ordinal());
		String button = "";
		String header="";
		String totaloptions="";String dropdown="";
		WebDriverWait wait = new WebDriverWait(driver, 600);
		try
		{

			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_UnifiedPortalPage.EditButtonForProductsItem()))
			{

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.EditButtonForProductsItem());
				CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.EditButtonForProductsItem());

				wait.until(ExpectedConditions.presenceOfElementLocated(obj_UnifiedPortalPage.EditHeading()));
				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.EditHeading());
				header=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.EditHeading()).getText();
				System.out.println(header);

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.CustomGroupName());	
				String custname=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.CustomGroupName()).getText();	
				System.out.println("header is "+custname);
				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.CustomGroupNameTextBox());	

				String name=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.CustomGroupNameTextBox()).getText();	
				System.out.println("name is "+name);

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.CustomGroupDescription());	
				String custdes=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.CustomGroupDescription()).getText();	
				System.out.println("header is "+custdes);
				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.CustomerGroupDescriptionTextBox());	
				String desc=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.CustomerGroupDescriptionTextBox()).getText();	
				System.out.println("description is "+desc);

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.SelectProductDropDown());
				Select selOption = new  Select(driver.findElement(obj_UnifiedPortalPage.SelectProductDropDown()));
				List<WebElement> list1=selOption.getOptions();


				for(WebElement lt:list1)
				{
					CommonUtility.highlightElement(driver, lt);
					dropdown+= "<br>"+lt.getText();

				}

				System.out.println(dropdown);

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.SaveChanges());
				String savechangebut=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.SaveChanges()).getText();
				System.out.println("button is "+savechangebut);
//				boolean b=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.SaveChanges()).isEnabled();
//				if(b=true)
//				{
//					System.out.println("Save changes is enabled");
//					Report.put("When a user  selects an existing Custom Group of the type 'Products' for editing",
//							"That should land on the edit flow with the 'items' with below contents :1. Title : Edit Custom Group 2. Name 3. Description <br>4. Select Products section : with a filter applied message to indicate the GDUNS restriction 5. Search by drop down with 'Search by Product' and 'Search by Site' options Product Search box with watermark text indicating 'Enter a Serial Number or Service Tag' -6 min characters for SN and 5 for Service Tag (IB status's  to be considered - Installed;Shipped;Awaiting Customer Install;Install-T&M )6. Save Changes in disabled state-this changes to enabled state if there is any change done to Name/Description field. 7. Cancel- Displays a modal window with a message-'Your Custom Group hasn't been saved.If you navigate away,it will be deleted' with No and Yes,Discard options . No will direct the user back to the create page Yes,Discard will cancel the create operation and redirect the user to the list of custom groups page 8. Show Selected Products (n) - This count should be inclusive of the current and previous selections.",
//							"User failed to see save changes button in enabled state", "Fail");
//					Assert.fail();
//				}
				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.CancelButton());
				String cancel=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.CancelButton()).getText();
				System.out.println("button is "+cancel);

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.ShowSelectedProductsTab());
				String button2=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.ShowSelectedProductsTab()).getText();
				System.out.println("button is "+button2);

				Report.put("When a user  selects an existing Custom Group of the type 'Products' for editing",
						"That should land on the edit flow with the 'items' with below contents :1. Title : Edit Custom Group 2. Name 3. Description <br>4. Select Products section : with a filter applied message to indicate the GDUNS restriction 5. Search by drop down with 'Search by Product' and 'Search by Site' options Product Search box with watermark text indicating 'Enter a Serial Number or Service Tag' -6 min characters for SN and 5 for Service Tag (IB status's  to be considered - Installed;Shipped;Awaiting Customer Install;Install-T&M )6. Save Changes in disabled state-this changes to enabled state if there is any change done to Name/Description field. 7. Cancel- Displays a modal window with a message-'Your Custom Group hasn't been saved.If you navigate away,it will be deleted' with No and Yes,Discard options . No will direct the user back to the create page Yes,Discard will cancel the create operation and redirect the user to the list of custom groups page 8. Show Selected Products (n) - This count should be inclusive of the current and previous selections.",
						"User able to click on edit icon of item type Products and able to see expected "+Report.color(header)+" header with "+Report.color(custname)+" as "+Report.color(name)+" and <br>"+Report.color(custdes)+" with "+Report.color(desc)+" <br> with selected products dropdown with options "+Report.color(dropdown)+" <br> along with preview section with buttons "+Report.color(savechangebut)+" in disabled state and "+Report.color(cancel)+" button <br> and "+Report.color(button2)+" tab", "PASS");

			}
			else
			{
				System.out.println("not able to see edit details");
				Report.put("When a user  selects an existing Custom Group of the type 'Products' for editing",
						"That should land on the edit flow with the 'items' with below contents :1. Title : Edit Custom Group 2. Name 3. Description <br>4. Select Products section : with a filter applied message to indicate the GDUNS restriction 5. Search by drop down with 'Search by Product' and 'Search by Site' options Product Search box with watermark text indicating 'Enter a Serial Number or Service Tag' -6 min characters for SN and 5 for Service Tag (IB status's  to be considered - Installed;Shipped;Awaiting Customer Install;Install-T&M )6. Save Changes in disabled state-this changes to enabled state if there is any change done to Name/Description field. 7. Cancel- Displays a modal window with a message-'Your Custom Group hasn't been saved.If you navigate away,it will be deleted' with No and Yes,Discard options . No will direct the user back to the create page Yes,Discard will cancel the create operation and redirect the user to the list of custom groups page 8. Show Selected Products (n) - This count should be inclusive of the current and previous selections.",
						"User failed to see edit details", "Fail");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("When a user  selects an existing Custom Group of the type 'Products' for editing",
					"That should land on the edit flow with the 'items' with below contents :1. Title : Edit Custom Group 2. Name 3. Description <br>4. Select Products section : with a filter applied message to indicate the GDUNS restriction 5. Search by drop down with 'Search by Product' and 'Search by Site' options Product Search box with watermark text indicating 'Enter a Serial Number or Service Tag' -6 min characters for SN and 5 for Service Tag (IB status's  to be considered - Installed;Shipped;Awaiting Customer Install;Install-T&M )6. Save Changes in disabled state-this changes to enabled state if there is any change done to Name/Description field. 7. Cancel- Displays a modal window with a message-'Your Custom Group hasn't been saved.If you navigate away,it will be deleted' with No and Yes,Discard options . No will direct the user back to the create page Yes,Discard will cancel the create operation and redirect the user to the list of custom groups page 8. Show Selected Products (n) - This count should be inclusive of the current and previous selections.",
					"User failed to see edit details", "Fail");
			Assert.fail();
		}
	}



	public void edit_CustomGroup_Products(WebDriver driver)
	{
		System.out.println("Inside edit_CustomGroup_Products method");

		String header = "";String header1="";String button="";
		String customgroupname="";
		String message="";

		String name=TestNGCreator.TestData.get(Esupport.FirstName.ordinal());
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);			
			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_UnifiedPortalPage.EditButtonForProductsItem()))
			{
				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.EditButtonForProductsItem());
				CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.EditButtonForProductsItem());

				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_UnifiedPortalPage.EditHeading()));
				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.EditHeading());

				header = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.EditHeading()).getText();

				System.out.println("Header is: "+header);


				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.CustomGroupNameTextBox());	
				customgroupname = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.CustomGroupNameTextBox()).getText();

				System.out.println("name of custom group is: "+customgroupname);

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.ShowSelectedProductsTab());
				button=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.ShowSelectedProductsTab()).getText();
				System.out.println("button is "+button);
				CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.ShowSelectedProductsTab());

				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_UnifiedPortalPage.SelectedProductsHeading()));
				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.SelectedProductsHeading());
				header1=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.SelectedProductsHeading()).getText();
				System.out.println("heading is "+header1);

				Thread.sleep(6000);
				SelectOneOrMultipleAssetsOnSelectedProducts(driver);
				Thread.sleep(6000);
				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.RemoveInPopUp());
				CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.RemoveInPopUp());
				Thread.sleep(6000);
				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.SaveChanges());
				CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.SaveChanges());

				//				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.EditedCustomGroupSuccessMessage());
				//
				//				message = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.EditedCustomGroupSuccessMessage()).getText();
				//
				//				System.out.println("message is: "+message);


				Report.put("User selects an existing Custom Group of the type 'Products' for editing and click show selected option ",
						"That should land on the edit flow with the 'items' tray expanded with below contents :1.  'Selected Products' section :2. Show Selected Products  displays the previous selections  in a grid with the following columns: (IB status's  to be considered - Installed;Shipped;Awaiting Customer Install;Install-T&M ) Asset ID, Product Name,Product Nickname, Site ID, Site Details, User should be able to paginate through the list of selected products .3. Ability to sort on the following columns in ascending and descending order Asset ID,Product Name,Product Nickname,Site ID,Site Details 4. Ability to select one ,multiple or all Assets for removing from group. <br>5. Filter selected products based on Asset ID,Product Name,Product Nickname,Site ID,Site Details 6. Users can select one, multiple or all assets from the grid -this enables the 'Remove from Group' button.7. Save Changes button-completes the edit and lands the user on Custom group list page.8. Cancels the edit action.Soft stop message if there is at least  one selection. If not ,there is no message and user is directed back to the list page.9. Hide Selected Products collapses the bottom tray and lands the user on the 'Create/Edit Mode'",
						"Edit Custom group & redirected to page"+Report.color(header)+" with created custom group in the grid "+Report.color(customgroupname)+" and user able to edit succcessfully with message "+Report.color(message), "PASS");
			}
			else
			{
				System.out.println("create custom group button not matching with entered");
				Report.put("User selects an existing Custom Group of the type 'Products' for editing and click show selected option ",
						"That should land on the edit flow with the 'items' tray expanded with below contents :1.  'Selected Products' section :2. Show Selected Products  displays the previous selections  in a grid with the following columns: (IB status's  to be considered - Installed;Shipped;Awaiting Customer Install;Install-T&M ) Asset ID, Product Name,Product Nickname, Site ID, Site Details, User should be able to paginate through the list of selected products .3. Ability to sort on the following columns in ascending and descending order Asset ID,Product Name,Product Nickname,Site ID,Site Details 4. Ability to select one ,multiple or all Assets for removing from group. <br>5. Filter selected products based on Asset ID,Product Name,Product Nickname,Site ID,Site Details 6. Users can select one, multiple or all assets from the grid -this enables the 'Remove from Group' button.7. Save Changes button-completes the edit and lands the user on Custom group list page.8. Cancels the edit action.Soft stop message if there is at least  one selection. If not ,there is no message and user is directed back to the list page.9. Hide Selected Products collapses the bottom tray and lands the user on the 'Create/Edit Mode'",
						"Failed to edit Custom group & redirect to homepage", "FAIL");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("User selects an existing Custom Group of the type 'Products' for editing and click show selected option ",
					"That should land on the edit flow with the 'items' tray expanded with below contents :1.  'Selected Products' section :2. Show Selected Products  displays the previous selections  in a grid with the following columns: (IB status's  to be considered - Installed;Shipped;Awaiting Customer Install;Install-T&M ) Asset ID, Product Name,Product Nickname, Site ID, Site Details, User should be able to paginate through the list of selected products .3. Ability to sort on the following columns in ascending and descending order Asset ID,Product Name,Product Nickname,Site ID,Site Details 4. Ability to select one ,multiple or all Assets for removing from group. <br>5. Filter selected products based on Asset ID,Product Name,Product Nickname,Site ID,Site Details 6. Users can select one, multiple or all assets from the grid -this enables the 'Remove from Group' button.7. Save Changes button-completes the edit and lands the user on Custom group list page.8. Cancels the edit action.Soft stop message if there is at least  one selection. If not ,there is no message and user is directed back to the list page.9. Hide Selected Products collapses the bottom tray and lands the user on the 'Create/Edit Mode'",
					"Failed to edit Custom group & redirect to homepage", "FAIL");
			Assert.fail();
		}
	}

	public void edit_CustomGroup_Products_IE(WebDriver driver)
	{
		System.out.println("Inside edit_CustomGroup_Products_IE method");

		String header = "";String header1="";String button="";
		String customgroupname="";
		String message="";

		String name=TestNGCreator.TestData.get(Esupport.FirstName.ordinal());
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);			
			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_UnifiedPortalPage.EditButtonForProductsItem()))
			{
				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.EditButtonForProductsItem());
				CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.EditButtonForProductsItem());

				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_UnifiedPortalPage.EditHeading()));
				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.EditHeading());

				header = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.EditHeading()).getText();

				System.out.println("Header is: "+header);


				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.CustomGroupNameTextBox());	
				customgroupname = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.CustomGroupNameTextBox()).getText();

				System.out.println("name of custom group is: "+customgroupname);

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.ShowSelectedProductsTab());
				button=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.ShowSelectedProductsTab()).getText();
				System.out.println("button is "+button);
				CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.ShowSelectedProductsTab());

				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_UnifiedPortalPage.SelectedProductsHeading()));
				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.SelectedProductsHeading());
				header1=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.SelectedProductsHeading()).getText();
				System.out.println("heading is "+header1);

				Thread.sleep(6000);
				SelectOneOrMultipleAssetsOnSelectedProducts_IE(driver);
				Thread.sleep(6000);
				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.RemoveInPopUp());
				CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.RemoveInPopUp());
				Thread.sleep(6000);
				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.SaveChanges());
				CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.SaveChanges());

				//				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.EditedCustomGroupSuccessMessage());
				//
				//				message = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.EditedCustomGroupSuccessMessage()).getText();
				//
				//				System.out.println("message is: "+message);


				Report.put("User selects an existing Custom Group of the type 'Products' for editing and click show selected option ",
						"That should land on the edit flow with the 'items' tray expanded with below contents :1.  'Selected Products' section :2. Show Selected Products  displays the previous selections  in a grid with the following columns: (IB status's  to be considered - Installed;Shipped;Awaiting Customer Install;Install-T&M ) Asset ID, Product Name,Product Nickname, Site ID, Site Details, User should be able to paginate through the list of selected products .3. Ability to sort on the following columns in ascending and descending order Asset ID,Product Name,Product Nickname,Site ID,Site Details 4. Ability to select one ,multiple or all Assets for removing from group. <br>5. Filter selected products based on Asset ID,Product Name,Product Nickname,Site ID,Site Details 6. Users can select one, multiple or all assets from the grid -this enables the 'Remove from Group' button.7. Save Changes button-completes the edit and lands the user on Custom group list page.8. Cancels the edit action.Soft stop message if there is at least  one selection. If not ,there is no message and user is directed back to the list page.9. Hide Selected Products collapses the bottom tray and lands the user on the 'Create/Edit Mode'",
						"Edit Custom group & redirected to page"+Report.color(header)+" with created custom group in the grid "+Report.color(customgroupname)+" and user able to edit succcessfully with message "+Report.color(message), "PASS");
			}
			else
			{
				System.out.println("create custom group button not matching with entered");
				Report.put("User selects an existing Custom Group of the type 'Products' for editing and click show selected option ",
						"That should land on the edit flow with the 'items' tray expanded with below contents :1.  'Selected Products' section :2. Show Selected Products  displays the previous selections  in a grid with the following columns: (IB status's  to be considered - Installed;Shipped;Awaiting Customer Install;Install-T&M ) Asset ID, Product Name,Product Nickname, Site ID, Site Details, User should be able to paginate through the list of selected products .3. Ability to sort on the following columns in ascending and descending order Asset ID,Product Name,Product Nickname,Site ID,Site Details 4. Ability to select one ,multiple or all Assets for removing from group. <br>5. Filter selected products based on Asset ID,Product Name,Product Nickname,Site ID,Site Details 6. Users can select one, multiple or all assets from the grid -this enables the 'Remove from Group' button.7. Save Changes button-completes the edit and lands the user on Custom group list page.8. Cancels the edit action.Soft stop message if there is at least  one selection. If not ,there is no message and user is directed back to the list page.9. Hide Selected Products collapses the bottom tray and lands the user on the 'Create/Edit Mode'",
						"Failed to edit Custom group & redirect to homepage", "FAIL");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("User selects an existing Custom Group of the type 'Products' for editing and click show selected option ",
					"That should land on the edit flow with the 'items' tray expanded with below contents :1.  'Selected Products' section :2. Show Selected Products  displays the previous selections  in a grid with the following columns: (IB status's  to be considered - Installed;Shipped;Awaiting Customer Install;Install-T&M ) Asset ID, Product Name,Product Nickname, Site ID, Site Details, User should be able to paginate through the list of selected products .3. Ability to sort on the following columns in ascending and descending order Asset ID,Product Name,Product Nickname,Site ID,Site Details 4. Ability to select one ,multiple or all Assets for removing from group. <br>5. Filter selected products based on Asset ID,Product Name,Product Nickname,Site ID,Site Details 6. Users can select one, multiple or all assets from the grid -this enables the 'Remove from Group' button.7. Save Changes button-completes the edit and lands the user on Custom group list page.8. Cancels the edit action.Soft stop message if there is at least  one selection. If not ,there is no message and user is directed back to the list page.9. Hide Selected Products collapses the bottom tray and lands the user on the 'Create/Edit Mode'",
					"Failed to edit Custom group & redirect to homepage", "FAIL");
			Assert.fail();
		}
	}
	public void edit_CustomGroup_GridValidations_Products(WebDriver driver)
	{
		System.out.println("Inside edit_CustomGroup_GridValidations_Products method");

		String header = "";String header1="";String button="";
		String customgroupname="";
		String message="";
		String columnam="";

		String name=TestNGCreator.TestData.get(Esupport.FirstName.ordinal());
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);			
			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_UnifiedPortalPage.EditButtonForProductsItem()))
			{
				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.EditButtonForProductsItem());
				CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.EditButtonForProductsItem());

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.EditHeading());

				header = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.EditHeading()).getText();

				System.out.println("Header is: "+header);


				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.CustomGroupNameTextBox());	
				customgroupname = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.CustomGroupNameTextBox()).getText();

				System.out.println("name of custom group is: "+customgroupname);

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.ShowSelectedProductsTab());
				button=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.ShowSelectedProductsTab()).getText();
				System.out.println("button is "+button);
				CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.ShowSelectedProductsTab());

				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_UnifiedPortalPage.SelectedProductsHeading()));
				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.SelectedProductsHeading());
				header1=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.SelectedProductsHeading()).getText();
				System.out.println("heading is "+header1);

				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_UnifiedPortalPage.ColumnNamesInTheGridOfSelectByProduct()));
				List<WebElement> list=driver.findElements(obj_UnifiedPortalPage.ColumnNamesInTheGridOfSelectByProduct());
				List<WebElement> list1=driver.findElements(obj_UnifiedPortalPage.NumberSearchResultsDisplayed());

				int count=list1.size();
				System.out.println("total number of search rows displayed is "+count);
				for(WebElement lt:list)
				{
					CommonUtility.highlightElement(driver, lt);
					String label=lt.getText();

					System.out.println("column name is: " +label);
					columnam+=" <br> " + label;
				}
				System.out.println("table header is:"+columnam);


				Report.put("User selects an existing Custom Group of the type 'Products' for editing and click show selected option ",
						"That should land on the edit flow with the 'items' tray expanded with below contents :1.  'Selected Products' section :2. Show Selected Products  displays the previous selections  in a grid with the following columns: (IB status's  to be considered - Installed;Shipped;Awaiting Customer Install;Install-T&M ) Asset ID, Product Name,Product Nickname, Site ID, Site Details, User should be able to paginate through the list of selected products .3. Ability to sort on the following columns in ascending and descending order Asset ID,Product Name,Product Nickname,Site ID,Site Details 4. Ability to select one ,multiple or all Assets for removing from group. <br>5. Filter selected products based on Asset ID,Product Name,Product Nickname,Site ID,Site Details 6. Users can select one, multiple or all assets from the grid -this enables the 'Remove from Group' button.7. Save Changes button-completes the edit and lands the user on Custom group list page.8. Cancels the edit action.Soft stop message if there is at least  one selection. If not ,there is no message and user is directed back to the list page.9. Hide Selected Products collapses the bottom tray and lands the user on the 'Create/Edit Mode'",
						"Clicking on "+Report.color(button)+" tab, User able to see column names "+Report.color(columnam)+" with count of selected products "+count, "PASS");
				Thread.sleep(6000);
				SortingColumnsAssertId(driver);
				Thread.sleep(6000);
				validateFilterSection(driver,TestNGCreator.TestData.get(Esupport.Dpid.ordinal()));
				Thread.sleep(6000);
				VerifyPageNumbersDisplayingUnderPaginationSection(driver);
				Thread.sleep(6000);
				ValidatePreviousWillBeGreyedOutWhenUserIsOn1stPageIfMoreThanOnePagePresent(driver);
				Thread.sleep(6000);
				ValidateNextWillBeGreyedOutWhenUserIsOnLastPageIfMoreThanOnePagePresent(driver);
				Thread.sleep(6000);
				HideSelectedItems_SitesFamilies(driver);
				Thread.sleep(6000);
				if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_UnifiedPortalPage.CancelButton()))
				{
					CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.CancelButton());
					String cancelButton = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.CancelButton()).getText();
					System.out.println("button is "+cancelButton);
					CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.CancelButton());

					if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_UnifiedPortalPage.DiscardChangesHeading()))
					{
						CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.DiscardChangesHeading());

						String header2 = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.DiscardChangesHeading()).getText();
						System.out.println("header is "+header2);

						CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.AlertMessageInCancelPopUp());
						String message1 = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.AlertMessageInCancelPopUp()).getText();
						System.out.println("message is "+message1);


						CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.NoButtonInCancelPopUp());
						String button1 = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.NoButtonInCancelPopUp()).getText();
						System.out.println("button is "+button1);

						CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.YesDiscardButtonInCancelPopUp());
						String button2 = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.YesDiscardButtonInCancelPopUp()).getText();
						System.out.println("button is "+button2);

						CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.XButoonInCancelPopUp());

						Report.put("If User clicks on Cancel Button ",
								"User should see the the Displays a modal window with a message-'Your Custom Group hasn't been saved.If you navigate away,it will be deleted' with No and Yes,Discard options .No will direct the user back to the create page Yes,Discard will cancel the create operation and redirect the user to the list of custom groups page",
								"User able to click on "+Report.color(cancelButton)+" button and able to see pop up displayed with header "+Report.color(header2)+" with alert message "+Report.color(message1)+" with buttons "+Report.color(button1+" and "+button2), "PASS");
						Thread.sleep(3000);
						clickOnYes(driver);
					}

					wait.until(ExpectedConditions.visibilityOfElementLocated(obj_UnifiedPortalPage.MyCustomeGroupsHeading()));
					header = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.MyCustomeGroupsHeading()).getText();
					System.out.println(header);

					Report.put("If User clicks on Cancel Button ",
							"User should see the the Displays a modal window with a message-'Your Custom Group hasn't been saved.If you navigate away,it will be deleted' with No and Yes,Discard options .No will direct the user back to the create page Yes,Discard will cancel the create operation and redirect the user to the list of custom groups page",
							"Redirected to the page"+Report.color(header), "PASS");
				}
				else
				{
					System.out.println("cancel button not displayed");
					Report.put("If User clicks on Cancel Button ",
							"User should see the the Displays a modal window with a message-'Your Custom Group hasn't been saved.If you navigate away,it will be deleted' with No and Yes,Discard options .No will direct the user back to the create page Yes,Discard will cancel the create operation and redirect the user to the list of custom groups page",
							"Failed to see Cancel button", "FAIL");
					Assert.fail();
				}
				Thread.sleep(6000);

			}
			else
			{
				System.out.println("not able to see edit page tray");
				Report.put("User selects an existing Custom Group of the type 'Products' for editing and click show selected option ",
						"That should land on the edit flow with the 'items' tray expanded with below contents :1.  'Selected Products' section :2. Show Selected Products  displays the previous selections  in a grid with the following columns: (IB status's  to be considered - Installed;Shipped;Awaiting Customer Install;Install-T&M ) Asset ID, Product Name,Product Nickname, Site ID, Site Details, User should be able to paginate through the list of selected products .3. Ability to sort on the following columns in ascending and descending order Asset ID,Product Name,Product Nickname,Site ID,Site Details 4. Ability to select one ,multiple or all Assets for removing from group. <br>5. Filter selected products based on Asset ID,Product Name,Product Nickname,Site ID,Site Details 6. Users can select one, multiple or all assets from the grid -this enables the 'Remove from Group' button.7. Save Changes button-completes the edit and lands the user on Custom group list page.8. Cancels the edit action.Soft stop message if there is at least  one selection. If not ,there is no message and user is directed back to the list page.9. Hide Selected Products collapses the bottom tray and lands the user on the 'Create/Edit Mode'",
						"Failed to see column names", "FAIL");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("User selects an existing Custom Group of the type 'Products' for editing and click show selected option ",
					"That should land on the edit flow with the 'items' tray expanded with below contents :1.  'Selected Products' section :2. Show Selected Products  displays the previous selections  in a grid with the following columns: (IB status's  to be considered - Installed;Shipped;Awaiting Customer Install;Install-T&M ) Asset ID, Product Name,Product Nickname, Site ID, Site Details, User should be able to paginate through the list of selected products .3. Ability to sort on the following columns in ascending and descending order Asset ID,Product Name,Product Nickname,Site ID,Site Details 4. Ability to select one ,multiple or all Assets for removing from group. <br>5. Filter selected products based on Asset ID,Product Name,Product Nickname,Site ID,Site Details 6. Users can select one, multiple or all assets from the grid -this enables the 'Remove from Group' button.7. Save Changes button-completes the edit and lands the user on Custom group list page.8. Cancels the edit action.Soft stop message if there is at least  one selection. If not ,there is no message and user is directed back to the list page.9. Hide Selected Products collapses the bottom tray and lands the user on the 'Create/Edit Mode'",
					"Failed to see column names", "FAIL");
			Assert.fail();
		}
	}
	
	public void ClickOnShowSelectedItemsTab(WebDriver driver)
	{

		Log.info("Inside ClickOnShowSelectedItemsTab method");

		String button = "";String hide="";

		WebDriverWait wait = new WebDriverWait(driver, 600);
		try
		{
			Thread.sleep(10000);
//			CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.AssetPreviewTab());
			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_UnifiedPortalPage.ShowSelectedProductsTab()))
			{
				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.ShowSelectedProductsTab());
				button=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.ShowSelectedProductsTab()).getText();
				System.out.println("button is "+button);
				CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.ShowSelectedProductsTab());

			
				
				
				Report.put("clicks on caret icon 'Show Selected Items(n Sites n Product Families))' cart:",
						"Selected Items' tab -this click will take the user back to selection tray.",
						"User able to click on "+Report.color(button), "PASS");

			}
			else
			{
				System.out.println("failed to see selected items tab");
				Report.put("clicks on caret icon 'Show Selected Items(n Sites n Product Families))' cart:",
						"Selected Items' tab -this click will take the user back to selection tray.",
						"User failed to see selected items tab", "Fail");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("clicks on caret icon 'Show Selected Items(n Sites n Product Families))' cart:",
					"Selected Items' tab -this click will take the user back to selection tray.",
					"User failed to see selected items tab", "Fail");
			Assert.fail();
		}
	}
	
	public void SortingColumnsAssertId_CustomGroupPreviewTab_SelectedItems(WebDriver driver)
	{

		Log.info("Inside SortingColumnsAssertId_CustomGroupPreviewTab_SelectedItems method");

		String assertid = ""; String assertclass="";
		String Prodname=""; String prodclass="";
		String nickname="";String nickclass="";
		String siteid="";String siteidclass="";
		String sitedetils=""; String sitedetclass="";

		WebDriverWait wait = new WebDriverWait(driver, 600);
		try
		{

			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_UnifiedPortalPage.AssetIdSortingSitesFamiliesPreviewTab()))
			{	
				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.AssetIdSortingSitesFamiliesPreviewTab());
				assertid=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.AssetIdSortingSitesFamiliesPreviewTab()).getText();
				System.out.println("column name is "+assertid);
				CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.AssetIdSortingSitesFamiliesPreviewTab());

				Thread.sleep(6000);
				assertclass=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.AssetIdSortingSitesFamiliesPreviewTab()).getAttribute("class");
				System.out.println("class is "+assertclass);

				if(!(assertclass.contains("sorting_desc")|| assertclass.contains("sorting_asc")))
				{
					System.out.println("not able to see asset id sorting");
					Report.put("User verifies sort on the following columns in ascending and descending order ",
							" User should be able to sort on the following columns in ascending and descending order Asset ID,Product Name,Product family,Product Nickname,Site ID,Site Details",
							"User not able to see asset id sorting", "Fail");
					Assert.fail();
				}

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.ProductNameSortingSitesFamiliesPreviewTab());
				Prodname=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.ProductNameSortingSitesFamiliesPreviewTab()).getText();
				System.out.println("column name is "+Prodname);
				CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.ProductNameSortingSitesFamiliesPreviewTab());

				Thread.sleep(6000);
				prodclass=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.ProductNameSortingSitesFamiliesPreviewTab()).getAttribute("class");
				System.out.println("class is "+prodclass);

				if(!(prodclass.contains("sorting_desc")|| prodclass.contains("sorting_asc")))
				{
					System.out.println("not able to see product name sorting");
					Report.put("User verifies sort on the following columns in ascending and descending order ",
							" User should be able to sort on the following columns in ascending and descending order Asset ID,Product Name,Product family,Product Nickname,Site ID,Site Details",
							"User not able to see product name sorting", "Fail");
					Assert.fail();
				}

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.ProductFamilySortingSitesFamiliesPreviewTab());
				sitedetils=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.ProductFamilySortingSitesFamiliesPreviewTab()).getText();
				System.out.println("column name is "+sitedetils);
				CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.ProductFamilySortingSitesFamiliesPreviewTab());

				Thread.sleep(6000);
				sitedetclass=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.ProductFamilySortingSitesFamiliesPreviewTab()).getAttribute("class");
				System.out.println("class is "+sitedetclass);

				if(!(sitedetclass.contains("sorting_desc")|| sitedetclass.contains("sorting_asc")))
				{
					System.out.println("not able to see site details sorting");
					Report.put("User verifies sort on the following columns in ascending and descending order ",
							" User should be able to sort on the following columns in ascending and descending order Asset ID,Product Name,Product family,Product Nickname,Site ID,Site Details",
							"User failed to see Product family sorting", "Fail");
					Assert.fail();
				}
				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.ProductNicknameSortingSitesFamiliesPreviewTab());
				nickname=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.ProductNicknameSortingSitesFamiliesPreviewTab()).getText();
				System.out.println("column name is "+nickname);
				CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.ProductNicknameSortingSitesFamiliesPreviewTab());

				Thread.sleep(6000);
				nickclass=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.ProductNicknameSortingSitesFamiliesPreviewTab()).getAttribute("class");
				System.out.println("class is "+nickclass);

				if(!(nickclass.contains("sorting_desc")|| nickclass.contains("sorting_asc")))
				{
					System.out.println("not able to see product nickname sorting");
					Report.put("User verifies sort on the following columns in ascending and descending order ",
							" User should be able to sort on the following columns in ascending and descending order Asset ID,Product Name,Product family,Product Nickname,Site ID,Site Details",
							"User failed to see product nickname sorting", "Fail");
					Assert.fail();
				}

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.SiteIDSortingSitesFamiliesPreviewTab());
				siteid=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.SiteIDSortingSitesFamiliesPreviewTab()).getText();
				System.out.println("column name is "+siteid);
				CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.SiteIDSortingSitesFamiliesPreviewTab());

				Thread.sleep(6000);
				siteidclass=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.SiteIDSortingSitesFamiliesPreviewTab()).getAttribute("class");
				System.out.println("class is "+siteidclass);

				if(!(siteidclass.contains("sorting_desc")|| siteidclass.contains("sorting_asc")))
				{
					System.out.println("not able to see site id sorting");
					Report.put("User verifies sort on the following columns in ascending and descending order ",
							" User should be able to sort on the following columns in ascending and descending order Asset ID,Product Name,Product family,Product Nickname,Site ID,Site Details",
							"User failed to see site id sorting", "Fail");
					Assert.fail();
				}


				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.SiteDetailsSortingSitesFamiliesPreviewTab());
				sitedetils=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.SiteDetailsSortingSitesFamiliesPreviewTab()).getText();
				System.out.println("column name is "+sitedetils);
				CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.SiteDetailsSortingSitesFamiliesPreviewTab());

				Thread.sleep(6000);
				sitedetclass=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.SiteDetailsSortingSitesFamiliesPreviewTab()).getAttribute("class");
				System.out.println("class is "+sitedetclass);

				if(!(sitedetclass.contains("sorting_desc")|| sitedetclass.contains("sorting_asc")))
				{
					System.out.println("not able to see site details sorting");
					Report.put("User verifies sort on the following columns in ascending and descending order ",
							" User should be able to sort on the following columns in ascending and descending order Asset ID,Product Name,Product family,Product Nickname,Site ID,Site Details",
							"User failed to see site details sorting", "Fail");
					Assert.fail();
				}


				Report.put("User verifies sort on the following columns in ascending and descending order ",
						" User should be able to sort on the following columns in ascending and descending order Asset ID,Product Name,Product family,Product Nickname,Site ID,Site Details",
						"User able to sort all columns in ascending and descending", "PASS");

			}
			else
			{
				System.out.println("not able to sort column names");
				Report.put("User verifies sort on the following columns in ascending and descending order ",
						" User should be able to sort on the following columns in ascending and descending order Asset ID,Product Name,Product family,Product Nickname,Site ID,Site Details",
						"User failed to sort column names", "Fail");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("User verifies sort on the following columns in ascending and descending order ",
					" User should be able to sort on the following columns in ascending and descending order Asset ID,Product Name,Product family,Product Nickname,Site ID,Site Details",
					"User failed to sort column names", "Fail");
			Assert.fail();
		}
	}
	
	
	public void VerifyPageNumbersDisplayingUnderPaginationSection_SitesAndFamilies_PreviewTab(WebDriver driver)
	{

		Log.info("VerifyPageNumbersDisplayingUnderPaginationSection_SitesAndFamilies_PreviewTab");	
		WebDriverWait wait = new WebDriverWait(driver, 120);
		String text="";
		String testcase=TestNGCreator.TestData.get(Esupport.TestCaseID.ordinal());

		try
		{
			if(testcase.contains("8385233"))
			{
				if(CommonUtility.CheckpresenceofElementLocated(driver, 15, obj_UnifiedPortalPage.PageinPaginationInSitesAndFamiliesPreviewTab()))
				{

					CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.PageinPaginationInSitesAndFamiliesPreviewTab());
					String pagesdisplayed=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.PageinPaginationInSitesAndFamiliesPreviewTab()).getText();
					System.out.println(pagesdisplayed);

					CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.PageNoTextPaginationInSitesAndFamiliesPreviewTab());
					text=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.PageNoTextPaginationInSitesAndFamiliesPreviewTab()).getText(); 
					System.out.println(text);

					CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.NumberOfPagesInPaginationInSitesAndFamiliesPreviewTab());
					String noofpages=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.NumberOfPagesInPaginationInSitesAndFamiliesPreviewTab()).getText(); 
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
			else
			{
				if(CommonUtility.CheckpresenceofElementLocated(driver, 15, obj_UnifiedPortalPage.PageinPaginationInSitesAndFamiliesPreviewTab()))
				{

					CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.PageinPaginationInSitesAndFamiliesPreviewTab());
					String pagesdisplayed=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.PageinPaginationInSitesAndFamiliesPreviewTab()).getText();
					System.out.println(pagesdisplayed);

					CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.PageNoTextPaginationInSitesAndFamiliesPreviewTab());
					text=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.PageNoTextPaginationInSitesAndFamiliesPreviewTab()).getText(); 
					System.out.println(text);

					CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.NumberOfPagesInPaginationInSitesAndFamiliesPreviewTab());
					String noofpages=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.NumberOfPagesInPaginationInSitesAndFamiliesPreviewTab()).getText(); 
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
	
	
	public void ValidatePreviousWillBeGreyedOutWhenUserIsOn1stPageIfMoreThanOnePagePresent_SitesAndFamilies_PreviewTab(WebDriver driver)
	{

		Log.info("Entering ValidatePreviousWillBeGreyedOutWhenUserIsOn1stPageIfMoreThanOnePagePresent_SitesAndFamilies_PreviewTab method");	
		WebDriverWait wait = new WebDriverWait(driver, 120);
		String text="";
		String testcase=TestNGCreator.TestData.get(Esupport.TestCaseID.ordinal());
		try
		{
			if(testcase.contains("8385233"))
			{
				if(CommonUtility.CheckpresenceofElementLocated(driver, 15, obj_UnifiedPortalPage.PageNoTextPaginationInSitesAndFamiliesPreviewTab()))
				{

					CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.PageNoTextPaginationInSitesAndFamiliesPreviewTab());
					String pagesdisplayed=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.PageNoTextPaginationInSitesAndFamiliesPreviewTab()).getText();
					System.out.println(pagesdisplayed);

					if(pagesdisplayed.equals("1"))
					{

						CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.FirstPageArrowMarkInAddCustGroupInSitesAndFamiliesPreviewTab());
						CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.FirstPageArrowMarkInAddCustGroupInSitesAndFamiliesPreviewTab());

						CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.PreviousPageArrowMarkInAddCustGroupInSitesAndFamiliesPreviewTab());
						CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.PreviousPageArrowMarkInAddCustGroupInSitesAndFamiliesPreviewTab());

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
			else
			{

				if(CommonUtility.CheckpresenceofElementLocated(driver, 15, obj_UnifiedPortalPage.PageNoTextPaginationInSitesAndFamiliesPreviewTab()))
				{

					CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.PageNoTextPaginationInSitesAndFamiliesPreviewTab());
					String pagesdisplayed=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.PageNoTextPaginationInSitesAndFamiliesPreviewTab()).getText();
					System.out.println(pagesdisplayed);

					if(pagesdisplayed.equals("1"))
					{

						CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.FirstPageArrowMarkInAddCustGroupInSitesAndFamiliesPreviewTab());
						CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.FirstPageArrowMarkInAddCustGroupInSitesAndFamiliesPreviewTab());

						CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.PreviousPageArrowMarkInAddCustGroupInSitesAndFamiliesPreviewTab());
						CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.PreviousPageArrowMarkInAddCustGroupInSitesAndFamiliesPreviewTab());

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
	
	
	public void ValidateNextWillBeGreyedOutWhenUserIsOnLastPageIfMoreThanOnePagePresent_SitesAndFamilies_PreviewTab(WebDriver driver)
	{

		Log.info("Entering ValidateNextWillBeGreyedOutWhenUserIsOnLastPageIfMoreThanOnePagePresent_SitesAndFamilies_PreviewTab method");	
		WebDriverWait wait = new WebDriverWait(driver, 120);
		String text="";
		String testcase=TestNGCreator.TestData.get(Esupport.TestCaseID.ordinal());
		try
		{
			if(testcase.contains("8385233"))
			{
				if(CommonUtility.CheckpresenceofElementLocated(driver, 15, obj_UnifiedPortalPage.LastPageArrowMarkInAddCustGroupInSitesAndFamiliesPreviewTab()))
				{

					CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.LastPageArrowMarkInAddCustGroupInSitesAndFamiliesPreviewTab());
					CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.LastPageArrowMarkInAddCustGroupInSitesAndFamiliesPreviewTab());

					wait.until(ExpectedConditions.visibilityOfElementLocated(obj_UnifiedPortalPage.PageNoTextPaginationInSitesAndFamiliesPreviewTab()));
					String pagesdisplayed=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.PageNoTextPaginationInSitesAndFamiliesPreviewTab()).getText();
					System.out.println(pagesdisplayed);

					if(!(pagesdisplayed.equals("1")))
					{

						CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.NextPageArrowMarkInAddCustGroupInSitesAndFamiliesPreviewTab());
						CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.NextPageArrowMarkInAddCustGroupInSitesAndFamiliesPreviewTab());

						CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.LastPageArrowMarkInAddCustGroupInSitesAndFamiliesPreviewTab());
						CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.LastPageArrowMarkInAddCustGroupInSitesAndFamiliesPreviewTab());

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
			else
			{
				if(CommonUtility.CheckpresenceofElementLocated(driver, 15, obj_UnifiedPortalPage.LastPageArrowMarkInAddCustGroupInSitesAndFamiliesPreviewTab()))
				{

					CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.LastPageArrowMarkInAddCustGroupInSitesAndFamiliesPreviewTab());
					CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.LastPageArrowMarkInAddCustGroupInSitesAndFamiliesPreviewTab());

					wait.until(ExpectedConditions.visibilityOfElementLocated(obj_UnifiedPortalPage.PageNoTextPaginationInSitesAndFamiliesPreviewTab()));
					String pagesdisplayed=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.PageNoTextPaginationInSitesAndFamiliesPreviewTab()).getText();
					System.out.println(pagesdisplayed);

					if(!(pagesdisplayed.equals("1")))
					{

						CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.NextPageArrowMarkInAddCustGroupInSitesAndFamiliesPreviewTab());
						CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.NextPageArrowMarkInAddCustGroupInSitesAndFamiliesPreviewTab());

						CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.LastPageArrowMarkInAddCustGroupInSitesAndFamiliesPreviewTab());
						CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.LastPageArrowMarkInAddCustGroupInSitesAndFamiliesPreviewTab());

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
	
	public void clickOnEdit_ValidateDisplayedPage_SitesAndFamilies(WebDriver driver)
	{

		Log.info("Inside clickOnEdit_ValidateDisplayedPage_SitesAndFamilies method");
		String item=TestNGCreator.TestData.get(Esupport.SearchOption.ordinal());
		String button = "";
		String header="";
		String totaloptions="";String dropdown="";
		WebDriverWait wait = new WebDriverWait(driver, 600);
		try
		{

			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_UnifiedPortalPage.EditButtonForSitesAndFamilyItem()))
			{

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.EditButtonForSitesAndFamilyItem());
				CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.EditButtonForSitesAndFamilyItem());

				wait.until(ExpectedConditions.presenceOfElementLocated(obj_UnifiedPortalPage.EditHeading()));
				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.EditHeading());
				header=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.EditHeading()).getText();
				System.out.println(header);

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.CustomGroupName());	
				String custname=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.CustomGroupName()).getText();	
				System.out.println("header is "+custname);
				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.CustomGroupNameTextBox());	

				String name=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.CustomGroupNameTextBox()).getText();	
				System.out.println("name is "+name);

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.CustomGroupDescription());	
				String custdes=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.CustomGroupDescription()).getText();	
				System.out.println("header is "+custdes);
				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.CustomerGroupDescriptionTextBox());	
				String desc=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.CustomerGroupDescriptionTextBox()).getText();	
				System.out.println("description is "+desc);

				
				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.CancelButton());
				String cancel=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.CancelButton()).getText();
				System.out.println("button is "+cancel);

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.ShowSelectedProductsTab());
				String button2=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.ShowSelectedProductsTab()).getText();
				System.out.println("button is "+button2);

				Report.put("When a user  selects an existing Custom Group of the type 'Sites and Product families' for editing",
						"The screen should load up with the below details : 1. Title : Edit Custom Group Custom group name and Description .Two tabs with Select Sites and Select Product Families options 2. List box with a select all option- Select all and all preview tabs",
						"User able to click on edit icon of item type Products and able to see expected "+Report.color(header)+" header with "+Report.color(custname)+" as "+Report.color(name)+" and <br>"+Report.color(custdes)+" with "+Report.color(desc)+" and "+Report.color(cancel)+" button <br> and "+Report.color(button2)+" tab", "PASS");

			}
			else
			{
				System.out.println("not able to see edit details");
				Report.put("When a user  selects an existing Custom Group of the type 'Sites and Product families' for editing",
						"The screen should load up with the below details : 1. Title : Edit Custom Group Custom group name and Description .Two tabs with Select Sites and Select Product Families options 2. List box with a select all option- Select all and all preview tabs",
						"User failed to see edit details", "Fail");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("When a user  selects an existing Custom Group of the type 'Sites and Product families' for editing",
					"The screen should load up with the below details : 1. Title : Edit Custom Group Custom group name and Description .Two tabs with Select Sites and Select Product Families options 2. List box with a select all option- Select all and all preview tabs",
					"User failed to see edit details", "Fail");
			Assert.fail();
		}
	}
	
	
	
	public void validateFilterProductFamily(WebDriver driver, String search)
	{

		Log.info("Inside validateFilterProductFamily method");

		String button = "";
		String message="";
		WebDriverWait wait = new WebDriverWait(driver, 600);
		try
		{

			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_UnifiedPortalPage.FilterProductFamiliesHeading()))
			{
				CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.CountrySelector());
				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.FilterProductFamiliesHeading());
				CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.SearchTextBox()).clear();
				CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.SearchTextBox()).sendKeys(search);

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.SearchButton());
				CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.SearchButton());

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.InstructionText());
				message=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.InstructionText()).getText();
				System.out.println(message);

				Thread.sleep(10000);
				//				CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.CountrySelector());
				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.SitesListInTable());
				String filter=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.SitesListInTable()).getText();
				System.out.println(filter);

				if(!(filter.contains(search)))
				{
					System.out.println("not able to see product families text highlighted in table");
					Report.put("User  clicks on the fliter option  based on Product Family name",
							"User should be able to filter on the products : -The count on the top/bottom of the list box should reflect the result set",
							"User not able to see product families text highlighted in table", "Fail");
					Assert.fail();
				}


				Report.put("User  clicks on the fliter option  based on Product Family name",
						"User should be able to filter on the products : -The count on the top/bottom of the list box should reflect the result set",
						"User able to search using filter product families with label message "+Report.color(message)+" and able to see searched option highlighted "+Report.color(filter), "PASS");

			}
			else
			{
				System.out.println("not able to see filter product families text box");
				Report.put("User  clicks on the fliter option  based on Product Family name",
						"User should be able to filter on the products : -The count on the top/bottom of the list box should reflect the result set",
						"User not able to see filter product families text box", "Fail");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("User  clicks on the fliter option  based on Product Family name",
					"User should be able to filter on the products : -The count on the top/bottom of the list box should reflect the result set",
					"User not able to see filter product families text box", "Fail");
			Assert.fail();
		}
	}
	
	
	public void clickOnEdit_ValidateDisplayedPage_Sites(WebDriver driver)
	{

		Log.info("Inside clickOnEdit_ValidateDisplayedPage_Sites method");
		String item=TestNGCreator.TestData.get(Esupport.SearchOption.ordinal());
		String button = "";
		String header="";
		String totaloptions="";String dropdown="";
		WebDriverWait wait = new WebDriverWait(driver, 600);
		try
		{

			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_UnifiedPortalPage.EditButtonForSites()))
			{

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.EditButtonForSites());
				CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.EditButtonForSites());

				wait.until(ExpectedConditions.presenceOfElementLocated(obj_UnifiedPortalPage.EditHeading()));
				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.EditHeading());
				header=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.EditHeading()).getText();
				System.out.println(header);

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.CustomGroupName());	
				String custname=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.CustomGroupName()).getText();	
				System.out.println("header is "+custname);
				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.CustomGroupNameTextBox());	

				String name=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.CustomGroupNameTextBox()).getText();	
				System.out.println("name is "+name);

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.CustomGroupDescription());	
				String custdes=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.CustomGroupDescription()).getText();	
				System.out.println("header is "+custdes);
				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.CustomerGroupDescriptionTextBox());	
				String desc=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.CustomerGroupDescriptionTextBox()).getText();	
				System.out.println("description is "+desc);

				
				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.CancelButton());
				String cancel=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.CancelButton()).getText();
				System.out.println("button is "+cancel);

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.ShowSelectedProductsTab());
				String button2=CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.ShowSelectedProductsTab()).getText();
				System.out.println("button is "+button2);

				Report.put("When a user  selects an existing Custom Group of the type 'Sites and Product families' for editing",
						"The screen should load up with the below details : 1. Title : Edit Custom Group Custom group name and Description .Two tabs with Select Sites and Select Product Families options 2. List box with a select all option- Select all and all preview tabs",
						"User able to click on edit icon of item type Products and able to see expected "+Report.color(header)+" header with "+Report.color(custname)+" as "+Report.color(name)+" and <br>"+Report.color(custdes)+" with "+Report.color(desc)+" and "+Report.color(cancel)+" button <br> and "+Report.color(button2)+" tab", "PASS");

			}
			else
			{
				System.out.println("not able to see edit details");
				Report.put("When a user  selects an existing Custom Group of the type 'Sites and Product families' for editing",
						"The screen should load up with the below details : 1. Title : Edit Custom Group Custom group name and Description .Two tabs with Select Sites and Select Product Families options 2. List box with a select all option- Select all and all preview tabs",
						"User failed to see edit details", "Fail");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("When a user  selects an existing Custom Group of the type 'Sites and Product families' for editing",
					"The screen should load up with the below details : 1. Title : Edit Custom Group Custom group name and Description .Two tabs with Select Sites and Select Product Families options 2. List box with a select all option- Select all and all preview tabs",
					"User failed to see edit details", "Fail");
			Assert.fail();
		}
	}
	
	
	public void ClickOnsaveChanges(WebDriver driver)
	{
		System.out.println("Inside ClickOnsaveChanges method");

		String header = "";String header1="";String button="";
		String customgroupname="";
		String message="";

		String name=TestNGCreator.TestData.get(Esupport.FirstName.ordinal());
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);			
			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_UnifiedPortalPage.SaveChanges()))
			{
				
				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.SaveChanges());
				CommonUtility.ClickOn(driver,obj_UnifiedPortalPage.SaveChanges());

				CommonUtility.ScrollTo(driver,obj_UnifiedPortalPage.EditedCustomGroupSuccessMessage());

				message = CommonUtility.highlightElement(driver,obj_UnifiedPortalPage.EditedCustomGroupSuccessMessage()).getText();

				System.out.println("message is: "+message);

				
				Report.put("user clicks on save changes button",
						"User should be able to edit the selected custom group",
						"User able to click on sae changes button and user able to edit succcessfully with message "+Report.color(message), "PASS");
			}
			else
			{
				System.out.println("create custom group button not matching with entered");
				Report.put("user clicks on save changes button",
						"User should be able to edit the selected custom group",
						"Failed to edit Custom group & redirect to homepage", "FAIL");
				Assert.fail();
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("user clicks on save changes button",
					"User should be able to edit the selected custom group",
					"Failed to edit Custom group & redirect to homepage", "FAIL");
			Assert.fail();
		}
	}
}