package com.dell.delta_uat_automation.esupport.workflows;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.dell.delta_uat_automation.utility.CommonUtility;
import com.dell.delta_uat_automation.utility.Log;
import com.dell.delta_uat_automation.utility.Report;



public class EsupportSecurityLandingPageWorkflow extends BaseFlow 
{
	public void handleCookies(WebDriver driver)
	{
		System.out.println("Handle Cookies");
		Log.info("Handle Cookies");	
		WebDriverWait wait = new WebDriverWait(driver, 50);
		try
		{
			if(CommonUtility.CheckpresenceofElementLocated(driver, 5, obj_SecurityLandingPage.acceptCookies()))
			{
				CommonUtility.highlightElement(driver,obj_SecurityLandingPage.acceptCookies()).click(); 
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
	
	public void  clickSignInHereLink(WebDriver driver) 
	{
		System.out.println("Inside clickSignInHereLink method");
		Log.info("Inside clickSignInHereLink method");

		String header = "";

		WebDriverWait  wait = new WebDriverWait(driver, 120);	
		try
		{
			Actions act=new Actions(driver);

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIPSHomePage.signInHeader()));
			CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.signInHereLink());
			Thread.sleep(3000);
			CommonUtility.ClickOn(driver,obj_EsupportIPSHomePage.signInHereLink());

			if(CommonUtility.CheckpresenceofElementLocated(driver,50,obj_SecurityLandingPage.securityAdvisoryHeader()))
			{

				header = CommonUtility.highlightElement(driver,obj_SecurityLandingPage.securityAdvisoryHeader()).getText();
				System.out.println("Header is: "+header);
			}
			else
			{
				Assert.fail("Not able to load 'Security Advisories and Notices' page");
			}


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
	
	public void clickAdvisoryTitleLink(WebDriver driver) 
	{
		Log.info("Inside method clickAdvisoryTitleLink");
		WebDriverWait  wait = new WebDriverWait(driver, 120);

		String url="";
		String title = "";
		String header = "";
		try
		{
			CommonUtility.ScrollTo(driver,obj_SecurityLandingPage.advisoryTitleLink());
			CommonUtility.ClickOn(driver,obj_SecurityLandingPage.advisoryTitleLink());
			
			Set<String> allWH=driver.getWindowHandles(); 
			String currentwindow=driver.getWindowHandle();
			int countWindow=allWH.size(); 
			
			System.out.println("Switched Window Handles and  window count is :: "+countWindow);

			for(String wh:allWH)
			{
				driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
				Thread.sleep(5000);
				driver.switchTo().window(wh); 
				Thread.sleep(5000);
				url=driver.getCurrentUrl();
				title=driver.getTitle();
				System.out.println("URL displayed as   :::::"+url); 
				System.out.println("Title displayed as   :::::"+title); 

				if(title.contains("Security Advisory"))
				{
					url = driver.getCurrentUrl();
					System.out.println("Switched to window & URL is "+url);		
					wait.until(ExpectedConditions.visibilityOfElementLocated(obj_SecurityLandingPage.advisoryHeader()));
					header = CommonUtility.highlightElement(driver,obj_SecurityLandingPage.advisoryHeader()).getText();
					System.out.println("Header on clicking link: "+header);
					driver.close();		
				}	
				

					
			}
			
			driver.switchTo().window(currentwindow);
			
				Report.put("Click on any of the Security Advisories or Security Notices or Informational links listed in the table", 
						"User must see the specific Security Advisories or Security Notices or Informational link open in a new tab",
						"Successfully navigated to Page "+Report.color(url)+" with header "+Report.color(header), "PASS");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Log.info("Failed to Click on the Security Advisory link");
			Report.put("Click on any of the Security Advisories or Security Notices or Informational links listed in the table", 
					"User must see the specific Security Advisories or Security Notices or Informational link open in a new tab",
					"Failed to Click on the Security Advisory link", "FAIL");
		}
	}
	
	public void clickVulnerabilityPolicyLink(WebDriver driver) 
	{
		Log.info("Inside method clickVulnerabilityPolicyLink");
		WebDriverWait  wait = new WebDriverWait(driver, 120);

		String url="";
		String title = "";
		String header = "";
		try
		{
			CommonUtility.highlightElement(driver,obj_SecurityLandingPage.vulnerabilityPolicyLink()).click();
			
			Set<String> allWH=driver.getWindowHandles(); 
			String currentwindow=driver.getWindowHandle();
			int countWindow=allWH.size(); 
			
			System.out.println("Switched Window Handles and  window count is :: "+countWindow);

			for(String wh:allWH)
			{
				driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
				Thread.sleep(5000);
				driver.switchTo().window(wh); 
				Thread.sleep(5000);
				url=driver.getCurrentUrl();
				title=driver.getTitle();
				System.out.println("URL displayed as   :::::"+url); 
				System.out.println("Title displayed as   :::::"+title); 

				if(title.contains("Dell Vulnerability Response"))
				{
					url = driver.getCurrentUrl();
					System.out.println("Switched to window & URL is "+url);		
					wait.until(ExpectedConditions.visibilityOfElementLocated(obj_SecurityLandingPage.vulnerabilityPolicyHeader()));
					header = CommonUtility.highlightElement(driver,obj_SecurityLandingPage.vulnerabilityPolicyHeader()).getText();
					System.out.println("Header on clicking link: "+header);
					driver.close();			
				}	
				

				
			}
			driver.switchTo().window(currentwindow);
				Report.put("User clicks on the current “Dell’s Vulnerability Response Policy” link", 
						"User must be taken to the respective links in a new tab ",
						"Successfully navigated to Page "+Report.color(url)+" with header "+Report.color(header), "PASS");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Log.info("Failed to Click on the Dell’s Vulnerability Response Policy link");
			Report.put("User clicks on the current “Dell’s Vulnerability Response Policy” link", 
					"User must be taken to the respective links in a new tab ",
					"Failed to Click on the Dell’s Vulnerability Response Policy link", "FAIL");
		}
	}
	
	public void clickAdditionalSecurityLink(WebDriver driver) 
	{
		Log.info("Inside method clickAdditionalSecurityLink");
		WebDriverWait  wait = new WebDriverWait(driver, 120);

		String url="";
		String title = "";
		String header = "";
		try
		{
			CommonUtility.ClickOn(driver,obj_SecurityLandingPage.additionalSecurityLink());
			
			Set<String> allWH=driver.getWindowHandles(); 
			String currentwindow=driver.getWindowHandle();
			int countWindow=allWH.size(); 
			
			System.out.println("Switched Window Handles and  window count is :: "+countWindow);

			for(String wh:allWH)
			{
				driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
				Thread.sleep(5000);
				driver.switchTo().window(wh); 
				Thread.sleep(5000);
				url=driver.getCurrentUrl();
				title=driver.getTitle();
				System.out.println("URL displayed as   :::::"+url); 
				System.out.println("Title displayed as   :::::"+title); 

				if(title.contains("Security and Antivirus"))
				{
					url = driver.getCurrentUrl();
					System.out.println("Switched to window & URL is "+url);		
					wait.until(ExpectedConditions.visibilityOfElementLocated(obj_SecurityLandingPage.additionalSecurityHeader()));
					header = CommonUtility.highlightElement(driver,obj_SecurityLandingPage.additionalSecurityHeader()).getText();
					System.out.println("Header on clicking link: "+header);
					driver.close();	
				}	
				

					
			}
			driver.switchTo().window(currentwindow);
				Report.put("user clicks on the current “Additional Security Resources” link ", 
						"User must be taken to the respective links in a new tab ",
						"Successfully navigated to Page "+Report.color(url)+" with header "+Report.color(header), "PASS");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Log.info("Failed to Click on the “Additional Security Resources” link");
			Report.put("user clicks on the current “Additional Security Resources” link ",  
					"User must be taken to the respective links in a new tab ",
					"Failed to Click on “Additional Security Resources” link", "FAIL");
		}
	}
	
	public void  clickCriticalFilterAndVerifyDetails(WebDriver driver) 
	{
		System.out.println("Inside clickCriticalFilterAndVerifyDetails method");
		Log.info("Inside clickCriticalFilterAndVerifyDetails method");

		String severity = "";
		String data = "";

		WebDriverWait  wait = new WebDriverWait(driver, 120);	
		try
		{
			Thread.sleep(6000);
			CommonUtility.ScrollTo(driver,obj_SecurityLandingPage.securityAdvisoriesCheckboxLeftPanel());
//			CommonUtility.ClickOn(driver,obj_SecurityLandingPage.securityAdvisoriesCheckboxLeftPanel());
			
			Thread.sleep(3000);
			CommonUtility.ScrollTo(driver,obj_SecurityLandingPage.criticalCheckboxLeftPanel());
			CommonUtility.ClickOn(driver,obj_SecurityLandingPage.criticalCheckboxLeftPanel());

			Thread.sleep(3000);
			CommonUtility.ScrollTo(driver,obj_SecurityLandingPage.applyFiltersButton());
			CommonUtility.ClickOn(driver,obj_SecurityLandingPage.applyFiltersButton());
			Thread.sleep(10000);
			CommonUtility.ScrollTo(driver,obj_SecurityLandingPage.severityColumnFirstRow());
			severity = CommonUtility.highlightElement(driver,obj_SecurityLandingPage.severityColumnFirstRow()).getText();
			
			System.out.println("Severity is: "+severity);
			
			if(severity.contains("Critical"))
			{

				data = CommonUtility.highlightElement(driver,obj_SecurityLandingPage.firstRowData()).getText();
				System.out.println("First Row data is: "+data);
			}
			else
			{
				Report.put("Select any filters on the left rail under Security Advisories or Security Notices or Informational link and click on Apply filters button",
						"User should see the table refresh with the results of the filters applied", 
						"Failed to apply the filters", "FAIL");
				Assert.fail("Failed to apply the filters");
			}


			Report.put("Select any filters on the left rail under Security Advisories or Security Notices or Informational link and click on Apply filters button",
					"User should see the table refresh with the results of the filters applied", 
					"Applied filter with Severity"+Report.color(severity) +"table refreshed with data"+Report.color(data) , "PASS");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Select any filters on the left rail under Security Advisories or Security Notices or Informational link and click on Apply filters button",
					"User should see the table refresh with the results of the filters applied", 
					"Failed to apply the filters", "FAIL");
			Assert.fail("Failed to apply the filters");
		}
	}

	public void  searchTextAndVerifyTitleColumn(WebDriver driver, String text) 
	{
		System.out.println("Inside searchTextAndVerifyTitleColumn method");
		Log.info("Inside searchTextAndVerifyTitleColumn method");

		WebDriverWait  wait = new WebDriverWait(driver, 120);	
		String dataList = "";
		try
		{
			
			CommonUtility.scrollToViewElement(driver,obj_SecurityLandingPage.searchTextbox());
			CommonUtility.highlightElement(driver,obj_SecurityLandingPage.searchTextbox()).sendKeys(text);
			
			Thread.sleep(3000);
			CommonUtility.ClickOn(driver, obj_SecurityLandingPage.searchIcon());

			Thread.sleep(3000);
			List<WebElement> list=driver.findElements(obj_SecurityLandingPage.titleColumnData());

			for(WebElement lt:list)
			{
				CommonUtility.highlightElement(driver, lt);
				String text1=lt.getText();

				System.out.println("Text is: " +text1);
				if(text1.contains(text))
				{
					System.out.println("Search text is present");
					dataList+=" <br> " + text1;
				}
				else
				{
					Report.put("Scenario : An user on SLP searches for a keyword phrase (more than one word) in the search box",
							"User must see all the search results displayed should include that phrase", 
							"Failed to search the keyword phrase", "FAIL");
					Assert.fail("Failed to  search the keyword phrase");
				}

			}
			System.out.println("Data is: "+dataList);	


			Report.put("Scenario : An user on SLP searches for a keyword phrase (more than one word) in the search box",
					"User must see all the search results displayed should include that phrase", 
					"User searched for "+Report.color(text) +"and displayed the search results "+Report.color(dataList) , "PASS");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Scenario : An user on SLP searches for a keyword phrase (more than one word) in the search box",
					"User must see all the search results displayed should include that phrase", 
					"Failed to search the keyword phrase", "FAIL");
			Assert.fail("Failed to  search the keyword phrase");
		}
	}
	
	public void  verifySecurityAndAdvisoryHeader(WebDriver driver) 
	{
		System.out.println("Inside verifySecurityAndAdvisoryHeader method");
		Log.info("Inside verifySecurityAndAdvisoryHeader method");

		String header = "";

		WebDriverWait  wait = new WebDriverWait(driver, 120);	
		try
		{
			if(CommonUtility.CheckpresenceofElementLocated(driver,10,obj_SecurityLandingPage.securityAdvisoryHeader()))
			{

				header = CommonUtility.highlightElement(driver,obj_SecurityLandingPage.securityAdvisoryHeader()).getText();
				System.out.println("Header is: "+header);
			}
			else
			{
				Assert.fail("Not able to load 'Security Advisories and Notices' page");
			}


			Report.put("Launch the URL  https://www.dell.com/support/security/en-ca",
					"User must land on the  'Security Advisories and Notices' page", 
					"USer is navigated to Page"+Report.color(header), "PASS");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Launch the URL  https://www.dell.com/support/security/en-ca",
					"User must land on the  'Security Advisories and Notices' page", 
					"Failed to load 'Security Advisories and Notices' page", "FAIL");
			Assert.fail();
		}
	}
	
	public void  searchCVEIdentifierAndVerifyURL(WebDriver driver, String text) 
	{
		System.out.println("Inside searchCVEIdentifierAndVerifyURL method");
		Log.info("Inside searchCVEIdentifierAndVerifyURL method");

		WebDriverWait  wait = new WebDriverWait(driver, 120);	
		String url = "";
		String title = "";
		String header = "";
		String data = "";
		try
		{
			
			CommonUtility.scrollToViewElement(driver,obj_SecurityLandingPage.searchTextbox());
			CommonUtility.scrollToViewElement(driver,obj_SecurityLandingPage.searchTextbox()).clear();
			CommonUtility.highlightElement(driver,obj_SecurityLandingPage.searchTextbox()).sendKeys(text);
			
			Thread.sleep(3000);
			CommonUtility.highlightElement(driver, obj_SecurityLandingPage.searchIcon()).click();
			Thread.sleep(3000);
		
			data = CommonUtility.highlightElement(driver,obj_SecurityLandingPage.firstRowData()).getText();
			System.out.println("First Row data is: "+data);
			
			CommonUtility.ClickOn(driver,obj_SecurityLandingPage.advisoryTitleLink());
			
			Set<String> allWH=driver.getWindowHandles(); 
			String currentwindow=driver.getWindowHandle();
			int countWindow=allWH.size(); 
			
			System.out.println("Switched Window Handles and  window count is :: "+countWindow);

			for(String wh:allWH)
			{
				driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
				Thread.sleep(5000);
				driver.switchTo().window(wh); 
				Thread.sleep(5000);
				url=driver.getCurrentUrl();
				title=driver.getTitle();
				System.out.println("URL displayed as   :::::"+url); 
				System.out.println("Title displayed as   :::::"+title); 

				if(url.contains("article"))
				{
					url = driver.getCurrentUrl();
					System.out.println("Switched to window & URL is "+url);		
					wait.until(ExpectedConditions.visibilityOfElementLocated(obj_SecurityLandingPage.advisoryHeader()));
					header = CommonUtility.highlightElement(driver,obj_SecurityLandingPage.advisoryHeader()).getText();
					System.out.println("Header on clicking link: "+header);
					driver.close();

					driver.switchTo().window(currentwindow);						
				}
				else if(url.contains("details"))
				{
					url = driver.getCurrentUrl();
					System.out.println("Switched to window & URL is "+url);		
					wait.until(ExpectedConditions.visibilityOfElementLocated(obj_SecurityLandingPage.advisoryHeader()));
					header = CommonUtility.highlightElement(driver,obj_SecurityLandingPage.advisoryHeader()).getText();
					System.out.println("Header on clicking link: "+header);
					driver.close();

					driver.switchTo().window(currentwindow);						
				}	
			}


			Report.put("An authenticated user on SLP page searches for any keyword  in EMC or RSA security advisories, security notices, and informational content in the search box",
					"User must see all  EMC and  RSA and Dell security advisories, security notices, and informational content that have the keyword anywhere in the article title, header, or body (including tables) be displayed in the search results list view", 
					"User searched for "+Report.color(text) +"and displayed the search results "+Report.color(data) , "PASS");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("An authenticated user on SLP page searches for any keyword  in EMC or RSA security advisories, security notices, and informational content in the search box",
					"User must see all  EMC and  RSA and Dell security advisories, security notices, and informational content that have the keyword anywhere in the article title, header, or body (including tables) be displayed in the search results list view", 
					"Failed to search the EMC and  RSA and Dell security advisories", "FAIL");
			Assert.fail("Failed to  search EMC and  RSA and Dell security advisories");
		}
	}
	
	public void  verifySecurityAndAdvisoryMessage(WebDriver driver) 
	{
		System.out.println("Inside verifySecurityAndAdvisoryMessage method");
		Log.info("Inside verifySecurityAndAdvisoryMessage method");

		String message = "";

		WebDriverWait  wait = new WebDriverWait(driver, 120);	
		try
		{
			if(CommonUtility.CheckpresenceofElementLocated(driver,10,obj_SecurityLandingPage.securityAdvisoryMessage()))
			{

				message = CommonUtility.highlightElement(driver,obj_SecurityLandingPage.securityAdvisoryMessage()).getText();
				System.out.println("Message is: "+message);
			}
			else
			{
				Report.put("Validate the Messages displayed under Security Advisories and Notices",
						"User must see the following 'Dell strives to provide customers with timely information, guidance and mitigation options to minimize risks associated with security vulnerabilities. Below is a list of published Security Advisories and Notices for Dell, Dell EMC and RSA products. Dell recommends that customers run the most recent version of software available from Dell and stay current with the latest security updates. To understand Dell’s vulnerability response policies including severity ratings, see Dell’s Vulnerability Response Policy. For support, tutorials and advice on security for your products visit Additional Security Resources. Security Advisories and Notices are available from January 1, 2019, to present.", 
						"Failed to verify Security Advisory Message", "FAIL");
				Assert.fail("Not able to verify Security Advisory Message");
			}


			Report.put("Validate the Messages displayed under Security Advisories and Notices",
					"User must see the following 'Dell strives to provide customers with timely information, guidance and mitigation options to minimize risks associated with security vulnerabilities. Below is a list of published Security Advisories and Notices for Dell, Dell EMC and RSA products. Dell recommends that customers run the most recent version of software available from Dell and stay current with the latest security updates. To understand Dell’s vulnerability response policies including severity ratings, see Dell’s Vulnerability Response Policy. For support, tutorials and advice on security for your products visit Additional Security Resources. Security Advisories and Notices are available from January 1, 2019, to present.", 
					"User is displayed with message "+Report.color(message), "PASS");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Validate the Messages displayed under Security Advisories and Notices",
					"User must see the following 'Dell strives to provide customers with timely information, guidance and mitigation options to minimize risks associated with security vulnerabilities. Below is a list of published Security Advisories and Notices for Dell, Dell EMC and RSA products. Dell recommends that customers run the most recent version of software available from Dell and stay current with the latest security updates. To understand Dell’s vulnerability response policies including severity ratings, see Dell’s Vulnerability Response Policy. For support, tutorials and advice on security for your products visit Additional Security Resources. Security Advisories and Notices are available from January 1, 2019, to present.", 
					"Failed to verify Security Advisory Message", "FAIL");
			Assert.fail();
		}
	}
	
	public void  verifySearchTextbox(WebDriver driver) 
	{
		System.out.println("Inside verifySearchTextbox method");
		Log.info("Inside verifySearchTextbox method");


		WebDriverWait  wait = new WebDriverWait(driver, 120);	
		try
		{
			if(CommonUtility.CheckpresenceofElementLocated(driver,10,obj_SecurityLandingPage.searchTextbox()))
			{

				System.out.println("Search textbox is displayed");
			}
			else
			{
				Report.put("Validate whether a Search box is displayed ",
						"User must see a search box for the user to search.", 
						"Failed to verify search box for the user to search.", "FAIL");
				Assert.fail("Not able to verify Search textbox is displayed");
			}


			Report.put("Validate whether a Search box is displayed ",
					"User must see a search box for the user to search.", 
					"User is displayed with search box for the user to search. ", "PASS");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Validate whether a Search box is displayed ",
					"User must see a search box for the user to search.", 
					"Failed to verify search box for the user to search.", "FAIL");
			Assert.fail();
		}
	}
	
	public void verifyDefaultFilters(WebDriver driver) 
	{
		Log.info("Inside method verifyDefaultFilters");
		WebDriverWait  wait = new WebDriverWait(driver, 120);
		
		String filterList = "";
		try
		{
			CommonUtility.scrollToViewElement(driver, obj_SecurityLandingPage.criticalCheckboxLeftPanel());
			
			boolean a=CommonUtility.highlightElement(driver, obj_SecurityLandingPage.criticalCheckboxLeftPanel()).isSelected();
			boolean b=CommonUtility.highlightElement(driver, obj_SecurityLandingPage.HighCheckboxLeftPanel()).isSelected();
			boolean c=CommonUtility.highlightElement(driver, obj_SecurityLandingPage.MediumCheckboxLeftPanel()).isSelected();
			boolean d=CommonUtility.highlightElement(driver, obj_SecurityLandingPage.LowCheckboxLeftPanel()).isSelected();
			boolean e=CommonUtility.highlightElement(driver, obj_SecurityLandingPage.SecurityNoticesCheckbox()).isSelected();
			boolean f=CommonUtility.highlightElement(driver, obj_SecurityLandingPage.InformationalCheckbox()).isSelected();
			boolean g=CommonUtility.highlightElement(driver, obj_SecurityLandingPage.PublishedRadioButton()).isSelected();
			
			if(a && b && c && d && e && f && g)
			{
				Log.info("Filters are selected by default");
			}
			else
			{
				Log.info("Filters are not selected by default");
				Report.put("Validate whether all the FILTERS are selected by default", 
						"User must see the following filters selected by default 1. Under Security Advisories: • Critical• Medium • High • Low 2. Security Notice 3. Informational >User must see all the FILTER selected by default be displayed under FILTERS above Date Picker.  >User must see the Published option be selected by default. >Apply filters button be displayed in BLUE indcating about the selection of all the filters by default. ",
						"User is not able to verify FILTERS are selected by default", "FAIL");
				Assert.fail();
			}
			
			List<WebElement> list=driver.findElements(obj_SecurityLandingPage.FiltersList());

			for(WebElement lt:list)
			{
				CommonUtility.highlightElement(driver, lt);
				String text=lt.getText();

				System.out.println("Text is: " +text);
				filterList+=" <br> " + text;
			}
				
			System.out.println("Filters are: "+filterList);
			
			Report.put("Validate whether all the FILTERS are selected by default", 
					"User must see the following filters selected by default 1. Under Security Advisories: • Critical• Medium • High • Low 2. Security Notice 3. Informational >User must see all the FILTER selected by default be displayed under FILTERS above Date Picker.  >User must see the Published option be selected by default. >Apply filters button be displayed in BLUE indcating about the selection of all the filters by default. ",
					"User Successfully selected  filters by default"+Report.color(filterList), "PASS");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Validate whether all the FILTERS are selected by default", 
					"User must see the following filters selected by default 1. Under Security Advisories: • Critical• Medium • High • Low 2. Security Notice 3. Informational >User must see all the FILTER selected by default be displayed under FILTERS above Date Picker.  >User must see the Published option be selected by default. >Apply filters button be displayed in BLUE indcating about the selection of all the filters by default. ",
					"User is not able to verify FILTERS are selected by default", "FAIL");
			Assert.fail();
		}
	}
	
	public void validateDatePickerDefaultText(WebDriver driver) 
	{
		Log.info("Inside method validateDatePickerDefaultText");
		WebDriverWait  wait = new WebDriverWait(driver, 120);
		
		String fromText = "";
		String toText = "";
		
		try
		{
			
			fromText = CommonUtility.highlightElement(driver, obj_SecurityLandingPage.FromDateTextbox()).getAttribute("placeholder");
			toText = CommonUtility.highlightElement(driver, obj_SecurityLandingPage.ToDateTextbox()).getAttribute("placeholder");
			
							
			System.out.println("Default text displayed is: "+fromText+toText);
			
			Report.put("Validate the date picker details displayed by default", 
					"User must see two date picker box empty(with the format MM/DD/YYYY) along with the calendar icon on the left. The two date picker is for the user to pick from and to date",
					"User is able to see two date picker box with text from "+Report.color(fromText) +"and to "+Report.color(fromText), "PASS");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Validate the date picker details displayed by default", 
					"User must see two date picker box empty(with the format MM/DD/YYYY) along with the calendar icon on the left. The two date picker is for the user to pick from and to date",
					"User is not able to verify date picker details displayed by default", "FAIL");
			Assert.fail();
		}
	}
	
	public void verifyExportButtonAndColumnsAndDisplayingText(WebDriver driver) 
	{
		Log.info("Inside method verifyExportButtonAndColumnsAndDisplayingText");
		WebDriverWait  wait = new WebDriverWait(driver, 120);
		
		String exportButton = "";
		String columnsList = "";
		String displayingText = "";
		
		try
		{
			
			exportButton = CommonUtility.highlightElement(driver, obj_SecurityLandingPage.ExportTable()).getText();
			displayingText = CommonUtility.highlightElement(driver, obj_SecurityLandingPage.displayingPageText()).getText();
			
							
			System.out.println("Export button text and diplaying text is: "+exportButton + displayingText);
			
			List<WebElement> list=driver.findElements(obj_SecurityLandingPage.ColumnNames());

			for(WebElement lt:list)
			{
				CommonUtility.highlightElement(driver, lt);
				String text=lt.getText();

				System.out.println("Text is: " +text);
				columnsList+=" <br> " + text;
			}
				
			System.out.println("Columns are: "+columnsList);
			
			Report.put("Validate the details displayed on the table", 
					"User must see a Export Table hyperlink along with the icon above the table >User must see the following options under table 1. Severity along with the sort icon 2. CVE IDNETIFIER along with the sort icon 3. Title along with the sort icon 4. Type along with the sort icon 5. Published along with the sort icon 6. Updated along with the sort icon >The end of the table should display 'Show More' button along with the Displaying the Total count of the Article links displayed on the page against the overall Total count of the articles.",
					"User is able to see button "+Report.color(exportButton) +"<br>"+"Columns with sort button are:"+Report.color(columnsList)+"<br>"+Report.color(displayingText), "PASS");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Validate the details displayed on the table", 
					"User must see a Export Table hyperlink along with the icon above the table >User must see the following options under table 1. Severity along with the sort icon 2. CVE IDNETIFIER along with the sort icon 3. Title along with the sort icon 4. Type along with the sort icon 5. Published along with the sort icon 6. Updated along with the sort icon >The end of the table should display 'Show More' button along with the Displaying the Total count of the Article links displayed on the page against the overall Total count of the articles.",
					"User is not able to verify details displayed on the table", "FAIL");
			Assert.fail();
		}
	}
	
	public void verifyDetailsAfterSignout(WebDriver driver) 
	{
		Log.info("Inside method verifyDetailsAfterSignout");
		WebDriverWait  wait = new WebDriverWait(driver, 120);
		
		String text = "";
		
		try
		{
			if(!CommonUtility.CheckpresenceofElementLocated(driver,10,obj_SecurityLandingPage.InformationalCheckbox()))
			{
				text = CommonUtility.highlightElement(driver,obj_SecurityLandingPage.SignInMessage()).getText();
				System.out.println("Text is: "+text);
			}
			else
			{
				Report.put("Verify Sign out and the default view for unauthenticated user will be dispalyed", 
						"The unauthenicated experience for the default user will be the same as above except for the two changes. 1. Infomational option won't be listed under Filters.2. A blue tile with the message, 'Please sign in into your account to access additional security content.' along with the info icon will be displayed",
						"User is not able to verify default view for unauthenticated user", "FAIL");
				Assert.fail("User is not able to verify default view for unauthenticated user");
			}
			
			Report.put("Verify Sign out and the default view for unauthenticated user will be dispalyed", 
					"The unauthenicated experience for the default user will be the same as above except for the two changes. 1. Infomational option won't be listed under Filters.2. A blue tile with the message, 'Please sign in into your account to access additional security content.' along with the info icon will be displayed",
					"User is not able to see Informational Option and displayed message "+Report.color(text), "PASS");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify Sign out and the default view for unauthenticated user will be dispalyed", 
					"The unauthenicated experience for the default user will be the same as above except for the two changes. 1. Infomational option won't be listed under Filters.2. A blue tile with the message, 'Please sign in into your account to access additional security content.' along with the info icon will be displayed",
					"User is not able to verify default view for unauthenticated user", "FAIL");
			Assert.fail();
		}
	}
	
	public void clickSignInLinkAndVerifyHeader(WebDriver driver) 
	{
		Log.info("Inside method clickSignInLinkAndVerifyHeader");
		WebDriverWait  wait = new WebDriverWait(driver, 120);
		
		String text = "";
		String header = "";
		
		try
		{
			if(CommonUtility.CheckpresenceofElementLocated(driver,10,obj_SecurityLandingPage.SignInLink()))
			{
				text = CommonUtility.highlightElement(driver,obj_SecurityLandingPage.SignInLink()).getText();
				System.out.println("Text is: "+text);
				CommonUtility.ClickOn(driver,obj_SecurityLandingPage.SignInLink());
				
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIPSHomePage.signInHeader()));
				CommonUtility.ScrollTo(driver,obj_EsupportIPSHomePage.signInHereLink());
				Thread.sleep(3000);
				CommonUtility.ClickOn(driver,obj_EsupportIPSHomePage.signInHereLink());

				if(CommonUtility.CheckpresenceofElementLocated(driver,10,obj_SecurityLandingPage.securityAdvisoryHeader()))
				{

					header = CommonUtility.highlightElement(driver,obj_SecurityLandingPage.securityAdvisoryHeader()).getText();
					System.out.println("Header is: "+header);
				}
				else
				{
					Report.put("Click on Sign-in hyperlink from the above page", 
							"User should be able to  succcesfully sign in and land on the Seciurity Landing Page",
							"User is not able to sign in & land on Security Landing Page", "FAIL");
					Assert.fail("User is not able to sign in & land on Security Landing Page");
				}
			}
			else
			{
				Report.put("Click on Sign-in hyperlink from the above page", 
						"User should be able to  succcesfully sign in and land on the Seciurity Landing Page",
						"User is not able to sign in & land on Security Landing Page", "FAIL");
				Assert.fail("User is not able to sign in & land on Security Landing Page");
			}
			
			Report.put("Click on Sign-in hyperlink from the above page", 
					"User should be able to  succcesfully sign in and land on the Seciurity Landing Page",
					"User clicked on link"+Report.color(text)+"and navigated to page"+Report.color(header), "PASS");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on Sign-in hyperlink from the above page", 
					"User should be able to  succcesfully sign in and land on the Seciurity Landing Page",
					"User is not able to sign in & land on Security Landing Page", "FAIL");
			Assert.fail("User is not able to sign in & land on Security Landing Page");
		}
	}
	
	public void  verifySecurityAdvisoriesTooltip(WebDriver driver) 
	{
		System.out.println("Inside verifySecurityAdvisoriesTooltip method");
		Log.info("Inside verifySecurityAdvisoriesTooltip method");

		String text = "";

		WebDriverWait  wait = new WebDriverWait(driver, 120);	
		try
		{
			//CommonUtility.scrollToViewElement(driver, obj_SecurityLandingPage.SecurityAdvisoriesTooltipIcon());
			Thread.sleep(3000);
//			Actions act=new Actions(driver);
//			act.moveToElement(CommonUtility.highlightElement(driver, obj_SecurityLandingPage.SecurityAdvisoriesTooltipIcon())).build().perform();
//			CommonUtility.ScrollTo(driver,obj_SecurityLandingPage.SecurityAdvisoriesTooltipIcon());
			Thread.sleep(7000);
			if(CommonUtility.CheckpresenceofElementLocated(driver,20,obj_SecurityLandingPage.SecurityAdvisoriesTooltipIcon()))
			{
				CommonUtility.ScrollTo(driver,obj_SecurityLandingPage.SecurityAdvisoriesTooltipIcon());
				CommonUtility.ClickOn(driver,obj_SecurityLandingPage.SecurityAdvisoriesTooltipIcon());
				text = CommonUtility.highlightElement(driver,obj_SecurityLandingPage.SecurityAdvisoriesTooltip()).getText();
				System.out.println("Security Advisories Tooltip text is: "+text);
			}
			else
			{
				Report.put("Hover on the ? Info symbol next to Security Advisories",
						"User must see the message, 'Notify customers when there is a workaround or security update for a security vulnerability.' in a grey tile", 
						"Failed to Hover on the ? Info symbol next to Security Advisories", "FAIL");
				Assert.fail("Failed to Hover on the ? Info symbol next to Security Advisories");
			}


			Report.put("Hover on the ? Info symbol next to Security Advisories",
					"User must see the message, 'Notify customers when there is a workaround or security update for a security vulnerability.' in a grey tile", 
					"User is displayed with the Message "+Report.color(text), "PASS");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Hover on the ? Info symbol next to Security Advisories",
					"User must see the message, 'Notify customers when there is a workaround or security update for a security vulnerability.' in a grey tile", 
					"Failed to Hover on the ? Info symbol next to Security Advisories", "FAIL");
			Assert.fail();
		}
	}
	
	public void  verifySecurityNoticesTooltip(WebDriver driver) 
	{
		System.out.println("Inside verifySecurityNoticesTooltip method");
		Log.info("Inside verifySecurityNoticesTooltip method");

		String text = "";

		WebDriverWait  wait = new WebDriverWait(driver, 120);	
		try
		{
//			CommonUtility.scrollToViewElement(driver, obj_SecurityLandingPage.SecurityNoticesTooltipIcon());
			Thread.sleep(3000);
//			Actions act=new Actions(driver);
//			act.moveToElement(CommonUtility.highlightElement(driver, obj_SecurityLandingPage.SecurityNoticesTooltipIcon())).build().perform();
			
			if(CommonUtility.CheckpresenceofElementLocated(driver,10,obj_SecurityLandingPage.SecurityNoticesTooltipIcon()))
			{
				CommonUtility.ScrollTo(driver,obj_SecurityLandingPage.SecurityNoticesTooltipIcon());
				CommonUtility.ClickOn(driver,obj_SecurityLandingPage.SecurityNoticesTooltipIcon());
				text = CommonUtility.highlightElement(driver,obj_SecurityLandingPage.SecurityNoticesTooltip()).getText();
				System.out.println("Security Notices Tooltip text is: "+text);
			}
			else
			{
				Report.put("Hover on the ? Info symbol next to Security Notices",
						"User must see the message, 'Notify customers of Dell public disclosures where vulnerability has received significant attention and where exploits may be available.'", 
						"Failed to Hover on the ? Info symbol next to Security Notices", "FAIL");
				Assert.fail("Failed to Hover on the ? Info symbol next to Security Notices");
			}


			Report.put("Hover on the ? Info symbol next to Security Notices",
					"User must see the message, 'Notify customers of Dell public disclosures where vulnerability has received significant attention and where exploits may be available.'", 
					"User is displayed with the Message "+Report.color(text), "PASS");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Hover on the ? Info symbol next to Security Notices",
					"User must see the message, 'Notify customers of Dell public disclosures where vulnerability has received significant attention and where exploits may be available.'", 
					"Failed to Hover on the ? Info symbol next to Security Notices", "FAIL");
			Assert.fail("Failed to Hover on the ? Info symbol next to Security Notices");
		}
	}
	
	public void  verifyInformationalTooltip(WebDriver driver) 
	{
		System.out.println("Inside verifyInformationalTooltip method");
		Log.info("Inside verifyInformationalTooltip method");

		String text = "";

		WebDriverWait  wait = new WebDriverWait(driver, 120);	
		try
		{
//			CommonUtility.scrollToViewElement(driver, obj_SecurityLandingPage.InformationalTooltipIcon());
			Thread.sleep(3000);
			
//			Actions act=new Actions(driver);
//			act.moveToElement(CommonUtility.highlightElement(driver, obj_SecurityLandingPage.InformationalTooltipIcon())).build().perform();
			
			if(CommonUtility.CheckpresenceofElementLocated(driver,10,obj_SecurityLandingPage.InformationalTooltipIcon()))
			{
				CommonUtility.ScrollTo(driver,obj_SecurityLandingPage.InformationalTooltipIcon());
				CommonUtility.ClickOn(driver,obj_SecurityLandingPage.InformationalTooltipIcon());
				text = CommonUtility.highlightElement(driver,obj_SecurityLandingPage.InformationalTooltip()).getText();
				System.out.println("Informational Tooltip text is: "+text);
			}
			else
			{
				Report.put("Hover on the ? Info symbol next to Informational",
						"User must see the message, 'Provides additional security-related resources for registered customers.'", 
						"Failed to Hover on the ? Info symbol next to Informational", "FAIL");
				Assert.fail("Failed to Hover on the ? Info symbol next to Informational");
			}


			Report.put("Hover on the ? Info symbol next to Informational",
					"User must see the message, 'Provides additional security-related resources for registered customers.'", 
					"User is displayed with the Message "+Report.color(text), "PASS");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Hover on the ? Info symbol next to Informational",
					"User must see the message, 'Provides additional security-related resources for registered customers.'", 
					"Failed to Hover on the ? Info symbol next to Informational", "FAIL");
			Assert.fail("Failed to Hover on the ? Info symbol next to Informational");
		}
	}
	
	public void  verifySeverityColumnSortingAscending(WebDriver driver) 
	{
		System.out.println("Inside verifySeverityColumnSorting method");
		Log.info("Inside verifySeverityColumnSorting method");

		String att = "";
		String data = "";

		WebDriverWait  wait = new WebDriverWait(driver, 120);	
		try
		{
			CommonUtility.ScrollTo(driver, obj_SecurityLandingPage.SeverityColumnHeader());
			att=CommonUtility.highlightElement(driver, obj_SecurityLandingPage.SeverityColumnHeader()).getAttribute("aria-label");

			System.out.println(att);

			if(att.contains("ascending"))
			{
				System.out.println("sort is  ascending");
				data = CommonUtility.highlightElement(driver,obj_SecurityLandingPage.firstRowData()).getText();
				System.out.println("First Row data is: "+data);

				Report.put("User on the security Landing page and tries to sort the severity column",
						" All results with N/A should appear together at the bottom of the table when sorted ascending", 
						"User displayed with data in ascending order"+Report.color(data), "PASS");
			}
			else
			{
				Log.info("Failed  to sort the severity column in ascending");
			Report.put("User on the security Landing page and tries to sort the severity column",
					" All results with N/A should appear together at the bottom of the table when sorted ascending", 
					"Failed to sort the severity column in ascending", "FAIL");
			Assert.fail();
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Log.info("Failed  to sort the severity column in ascending");
			Report.put("User on the security Landing page and tries to sort the severity column",
					" All results with N/A should appear together at the bottom of the table when sorted ascending", 
					"Failed to sort the severity column in ascending", "FAIL");
			Assert.fail();
		}
	}
	
	public void  verifySeverityColumnSortingDescending(WebDriver driver) 
	{
		System.out.println("Inside verifySeverityColumnSortingDescending method");
		Log.info("Inside verifySeverityColumnSortingDescending method");

		String att = "";
		String data = "";

		WebDriverWait  wait = new WebDriverWait(driver, 120);	
		try
		{
			CommonUtility.ClickOn(driver, obj_SecurityLandingPage.SeverityColumnHeader());
			Thread.sleep(3000);
			att=CommonUtility.highlightElement(driver, obj_SecurityLandingPage.SeverityColumnHeader()).getAttribute("aria-label");

			System.out.println(att);

			if(att.contains("descending"))
			{
				System.out.println("sort is  descending");
				data = CommonUtility.highlightElement(driver,obj_SecurityLandingPage.firstRowData()).getText();
				System.out.println("First Row data is: "+data);

				Report.put("User on the security Landing page and tries to sort the severity column",
						"  All results with 'N/A' should appear together at the top of the table when sorted descending", 
						"User displayed with data in descending order"+Report.color(data), "PASS");
			}
			else
			{
				Log.info("Failed  to sort the severity column in descending");
				Report.put("User on the security Landing page and tries to sort the severity column",
						"  All results with 'N/A' should appear together at the top of the table when sorted descending", 
					"Failed to sort the severity column in descending", "FAIL");
				Assert.fail();
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Log.info("Failed  to sort the severity column in descending");
			Report.put("User on the security Landing page and tries to sort the severity column",
					"  All results with 'N/A' should appear together at the top of the table when sorted descending", 
				"Failed to sort the severity column in descending", "FAIL");
			Assert.fail();
		}
	}
	
	public void  verifyTypeColumnSorting(WebDriver driver) 
	{
		System.out.println("Inside verifyTypeColumnSorting method");
		Log.info("Inside verifyTypeColumnSorting method");

		String attAsc = "";
		String dataAsc = "";
		String attDesc = "";
		String dataDesc = "";

		WebDriverWait  wait = new WebDriverWait(driver, 120);	
		try
		{
			CommonUtility.ScrollTo(driver, obj_SecurityLandingPage.TypeColumnHeader());
			attAsc=CommonUtility.highlightElement(driver, obj_SecurityLandingPage.TypeColumnHeader()).getAttribute("aria-label");

			System.out.println(attAsc);

			if(attAsc.contains("ascending"))
			{
				System.out.println("sort is  ascending");
				dataAsc = CommonUtility.highlightElement(driver,obj_SecurityLandingPage.firstRowData()).getText();
				System.out.println("First Row data is: "+dataAsc);

				
			}
			else
			{
				Log.info("Failed  to sort the Type column in ascending");
			Report.put("Scenario:  User on the security Landing page and tries to sort the Type column",
					"User must see the following : 1. Advisory should appear together at the bottom of the table when sorted ascending 2. Notice will appear together at the top of the table when sorted descending", 
					"Failed to sort the Type column in ascending", "FAIL");
			Assert.fail();
			}

			CommonUtility.ClickOn(driver, obj_SecurityLandingPage.TypeColumnHeader());
			Thread.sleep(3000);
			attDesc=CommonUtility.highlightElement(driver, obj_SecurityLandingPage.TypeColumnHeader()).getAttribute("aria-label");

			
			if(attDesc.contains("descending"))
			{
				System.out.println("sort is  descending");
				dataDesc = CommonUtility.highlightElement(driver,obj_SecurityLandingPage.firstRowData()).getText();
				System.out.println("First Row data is: "+dataDesc);
			}
			else
			{
				Log.info("Failed  to sort the Type column in descending");
				Report.put("Scenario:  User on the security Landing page and tries to sort the Type column",
						"User must see the following : 1. Advisory should appear together at the bottom of the table when sorted ascending 2. Notice will appear together at the top of the table when sorted descending", 
						"Failed to sort the Type column in descending", "FAIL");
				Assert.fail();
			}
			
			Report.put("Scenario:  User on the security Landing page and tries to sort the Type column",
					"User must see the following : 1. Advisory should appear together at the bottom of the table when sorted ascending 2. Notice will appear together at the top of the table when sorted descending",
					"User displayed with data in ascending order"+Report.color(dataAsc)+"<br>"+"displayed with data in descending order"+Report.color(dataDesc), "PASS");
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Log.info("Failed  to sort the Type column");
			Report.put("Scenario:  User on the security Landing page and tries to sort the Type column",
					"User must see the following : 1. Advisory should appear together at the bottom of the table when sorted ascending 2. Notice will appear together at the top of the table when sorted descending",
					"Failed to sort the Type column", "FAIL");
			Assert.fail();
		}
	}
	
	public void  verifyPublishedColumnSorting(WebDriver driver) 
	{
		System.out.println("Inside verifyPublishedColumnSorting method");
		Log.info("Inside verifyPublishedColumnSorting method");

		String attAsc = "";
		String dataAsc = "";
		String attDesc = "";
		String dataDesc = "";

		WebDriverWait  wait = new WebDriverWait(driver, 120);	
		try
		{
			CommonUtility.ScrollTo(driver, obj_SecurityLandingPage.PublishedColumnHeader());
			attAsc=CommonUtility.highlightElement(driver, obj_SecurityLandingPage.PublishedColumnHeader()).getAttribute("aria-label");

			System.out.println(attAsc);

			if(attAsc.contains("ascending"))
			{
				System.out.println("sort is  ascending");
				dataAsc = CommonUtility.highlightElement(driver,obj_SecurityLandingPage.firstRowData()).getText();
				System.out.println("First Row data is: "+dataAsc);
			}
			else
			{
				Log.info("Failed  to sort the Type column in ascending");
			Report.put("Scenario:  User on the security Landing page and tries to sort the Type column",
					"User must see the following : 1. Advisory should appear together at the bottom of the table when sorted ascending 2. Notice will appear together at the top of the table when sorted descending", 
					"Failed to sort the Type column in ascending", "FAIL");
			Assert.fail();
			}

			CommonUtility.ClickOn(driver, obj_SecurityLandingPage.PublishedColumnHeader());
			Thread.sleep(3000);
			attDesc=CommonUtility.highlightElement(driver, obj_SecurityLandingPage.PublishedColumnHeader()).getAttribute("aria-label");
			
			if(attDesc.contains("descending"))
			{
				System.out.println("sort is  descending");
				dataDesc = CommonUtility.highlightElement(driver,obj_SecurityLandingPage.firstRowData()).getText();
				System.out.println("First Row data is: "+dataDesc);
			}
			else
			{
				Log.info("Failed  to sort the Published column in descending");
				Report.put("Scenario:  User on the security Landing page and tries to sort the Published column",
						"User must see the following : 1. The result will be displayed from  any date starting  from 09 Jan 2019(the date from when we started displaying the articles)) to the latest recent published date at the table when sorted ascending 2.  The result will be displayed from the latest recent published articles to the date 09 Jan 2019(the date from when we started displaying the articles)when sorted descending",
						"Failed to sort the Published column in descending", "FAIL");
				Assert.fail();
			}
			
			Report.put("Scenario:  User on the security Landing page and tries to sort the Published column",
					"User must see the following : 1. The result will be displayed from  any date starting  from 09 Jan 2019(the date from when we started displaying the articles)) to the latest recent published date at the table when sorted ascending 2.  The result will be displayed from the latest recent published articles to the date 09 Jan 2019(the date from when we started displaying the articles)when sorted descending",
					"User displayed with data in ascending order"+Report.color(dataAsc)+"<br>"+"displayed with data in descending order"+Report.color(dataDesc), "PASS");
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Log.info("Failed  to sort the Published column");
			Report.put("Scenario:  User on the security Landing page and tries to sort the Published column",
					"User must see the following : 1. The result will be displayed from  any date starting  from 09 Jan 2019(the date from when we started displaying the articles)) to the latest recent published date at the table when sorted ascending 2.  The result will be displayed from the latest recent published articles to the date 09 Jan 2019(the date from when we started displaying the articles)when sorted descending",
					"Failed to sort the Published column", "FAIL");
			Assert.fail();
		}
	}
	
	public void  verifyUpdatedColumnSorting(WebDriver driver) 
	{
		System.out.println("Inside verifyUpdatedColumnSorting method");
		Log.info("Inside verifyUpdatedColumnSorting method");

		String attAsc = "";
		String dataAsc = "";
		String attDesc = "";
		String dataDesc = "";

		WebDriverWait  wait = new WebDriverWait(driver, 120);	
		try
		{
			CommonUtility.ScrollTo(driver, obj_SecurityLandingPage.UpdatedColumnHeader());
			attAsc=CommonUtility.highlightElement(driver, obj_SecurityLandingPage.UpdatedColumnHeader()).getAttribute("aria-label");

			System.out.println(attAsc);

			if(attAsc.contains("ascending"))
			{
				System.out.println("sort is  ascending");
				dataAsc = CommonUtility.highlightElement(driver,obj_SecurityLandingPage.firstRowData()).getText();
				System.out.println("First Row data is: "+dataAsc);
			}
			else
			{
				Log.info("Failed  to sort the Updated column in ascending");
			Report.put("Scenario:  User on the security Landing page and tries to sort the Updated column",
					"User must see the following : 1. The result will be displayed from any date starting  from 09 Jan 2019(the date from when we started displaying the articles)) to the latest recent update date at the table when sorted ascending 2.  The result will be displayed from the latest recent updated articles to any date  starting 09 Jan 2019(the date from when we started displaying the articles)when sorted descending", 
					"Failed to sort the Type column in ascending", "FAIL");
			Assert.fail();
			}

			CommonUtility.ClickOn(driver, obj_SecurityLandingPage.UpdatedColumnHeader());
			Thread.sleep(3000);
			attDesc=CommonUtility.highlightElement(driver, obj_SecurityLandingPage.UpdatedColumnHeader()).getAttribute("aria-label");
			
			if(attDesc.contains("descending"))
			{
				System.out.println("sort is  descending");
				dataDesc = CommonUtility.highlightElement(driver,obj_SecurityLandingPage.firstRowData()).getText();
				System.out.println("First Row data is: "+dataDesc);
			}
			else
			{
				Log.info("Failed  to sort the Updated column in descending");
				Report.put("Scenario:  User on the security Landing page and tries to sort the Updated column",
						"User must see the following : 1. The result will be displayed from any date starting  from 09 Jan 2019(the date from when we started displaying the articles)) to the latest recent update date at the table when sorted ascending 2.  The result will be displayed from the latest recent updated articles to any date  starting 09 Jan 2019(the date from when we started displaying the articles)when sorted descending", 
						"Failed to sort the Updated column in descending", "FAIL");
				Assert.fail();
			}
			
			Report.put("Scenario:  User on the security Landing page and tries to sort the Updated column",
					"User must see the following : 1. The result will be displayed from any date starting  from 09 Jan 2019(the date from when we started displaying the articles)) to the latest recent update date at the table when sorted ascending 2.  The result will be displayed from the latest recent updated articles to any date  starting 09 Jan 2019(the date from when we started displaying the articles)when sorted descending", 
					"User displayed with data in ascending order"+Report.color(dataAsc)+"<br>"+"displayed with data in descending order"+Report.color(dataDesc), "PASS");
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Log.info("Failed  to sort the Updated column");
			Report.put("Scenario:  User on the security Landing page and tries to sort the Updated column",
					"User must see the following : 1. The result will be displayed from any date starting  from 09 Jan 2019(the date from when we started displaying the articles)) to the latest recent update date at the table when sorted ascending 2.  The result will be displayed from the latest recent updated articles to any date  starting 09 Jan 2019(the date from when we started displaying the articles)when sorted descending", 
					"Failed to sort the Updated column", "FAIL");
			Assert.fail();
		}
	}
	
	public void  verifyTitleColumnSorting(WebDriver driver) 
	{
		System.out.println("Inside verifyTitleColumnSorting method");
		Log.info("Inside verifyTitleColumnSorting method");

		String attAsc = "";
		String dataAsc = "";
		String attDesc = "";
		String dataDesc = "";

		WebDriverWait  wait = new WebDriverWait(driver, 120);	
		try
		{
			CommonUtility.ScrollTo(driver, obj_SecurityLandingPage.TitleColumnHeader());
			attAsc=CommonUtility.highlightElement(driver, obj_SecurityLandingPage.TitleColumnHeader()).getAttribute("aria-label");

			System.out.println(attAsc);

			if(attAsc.contains("ascending"))
			{
				System.out.println("sort is  ascending");
				dataAsc = CommonUtility.highlightElement(driver,obj_SecurityLandingPage.firstRowData()).getText();
				System.out.println("First Row data is: "+dataAsc);
			}
			else
			{
				Log.info("Failed  to sort the Title column in ascending");
			Report.put("Scenario:  User on the security Landing page and tries to sort the Title column",
					"User must see the following : 1. The result will be displayed alphabetically from A-Z when sorted ascending 2.  The result will be displayed alphabetically from Z-A when sorted descending", 
					"Failed to sort the Title column in ascending", "FAIL");
			Assert.fail();
			}

			CommonUtility.ClickOn(driver, obj_SecurityLandingPage.TitleColumnHeader());
			Thread.sleep(3000);
			attDesc=CommonUtility.highlightElement(driver, obj_SecurityLandingPage.TitleColumnHeader()).getAttribute("aria-label");
			
			if(attDesc.contains("descending"))
			{
				System.out.println("sort is  descending");
				dataDesc = CommonUtility.highlightElement(driver,obj_SecurityLandingPage.firstRowData()).getText();
				System.out.println("First Row data is: "+dataDesc);
			}
			else
			{
				Log.info("Failed  to sort the Updated column in descending");
				Report.put("Scenario:  User on the security Landing page and tries to sort the Title column",
						"User must see the following : 1. The result will be displayed alphabetically from A-Z when sorted ascending 2.  The result will be displayed alphabetically from Z-A when sorted descending", 
						"Failed to sort the Updated column in descending", "FAIL");
				Assert.fail();
			}
			
			Report.put("Scenario:  User on the security Landing page and tries to sort the Title column",
					"User must see the following : 1. The result will be displayed alphabetically from A-Z when sorted ascending 2.  The result will be displayed alphabetically from Z-A when sorted descending", 
					"User displayed with data in ascending order"+Report.color(dataAsc)+"<br>"+"displayed with data in descending order"+Report.color(dataDesc), "PASS");
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Log.info("Failed  to sort the Title column");
			Report.put("Scenario:  User on the security Landing page and tries to sort the Title column",
					"User must see the following : 1. The result will be displayed alphabetically from A-Z when sorted ascending 2.  The result will be displayed alphabetically from Z-A when sorted descending", 
					"Failed to sort the Title column", "FAIL");
			Assert.fail();
		}
	}
	
	public void  verifyCVEColumnSorting(WebDriver driver) 
	{
		System.out.println("Inside verifyCVEColumnSorting method");
		Log.info("Inside verifyCVEColumnSorting method");

		String attAsc = "";
		String dataAsc = "";
		String attDesc = "";
		String dataDesc = "";

		WebDriverWait  wait = new WebDriverWait(driver, 120);	
		try
		{
			CommonUtility.ScrollTo(driver, obj_SecurityLandingPage.CVEColumnHeader());
			attAsc=CommonUtility.highlightElement(driver, obj_SecurityLandingPage.CVEColumnHeader()).getAttribute("aria-label");

			System.out.println(attAsc);

			if(attAsc.contains("ascending"))
			{
				System.out.println("sort is  ascending");
				dataAsc = CommonUtility.highlightElement(driver,obj_SecurityLandingPage.firstRowData()).getText();
				System.out.println("First Row data is: "+dataAsc);
			}
			else
			{
				Log.info("Failed  to sort the CVE column in ascending");
				Report.put("Scenario:  User on the security Landing page and tries to sort the CVE column",
						"User must see the following : 1. The result will be displayed alphabetically from A-Z and the year next to the(CVE)when sorted ascending.  The year will be displayed in the ascending order 2.  The result will be displayed alphabetically from Z-A and the year next to the CVE when sorted descending. The year will be displayed in the descending order", 
					"Failed to sort the CVE column in ascending", "FAIL");
			Assert.fail();
			}

			CommonUtility.ClickOn(driver, obj_SecurityLandingPage.CVEColumnHeader());
			Thread.sleep(3000);
			attDesc=CommonUtility.highlightElement(driver, obj_SecurityLandingPage.CVEColumnHeader()).getAttribute("aria-label");
			
			if(attDesc.contains("descending"))
			{
				System.out.println("sort is  descending");
				dataDesc = CommonUtility.highlightElement(driver,obj_SecurityLandingPage.firstRowData()).getText();
				System.out.println("First Row data is: "+dataDesc);
			}
			else
			{
				Log.info("Failed  to sort the CVE column in descending");
				Report.put("Scenario:  User on the security Landing page and tries to sort the CVE column",
						"User must see the following : 1. The result will be displayed alphabetically from A-Z and the year next to the(CVE)when sorted ascending.  The year will be displayed in the ascending order 2.  The result will be displayed alphabetically from Z-A and the year next to the CVE when sorted descending. The year will be displayed in the descending order", 
						"Failed to sort the Updated column in descending", "FAIL");
				Assert.fail();
			}
			
			Report.put("Scenario:  User on the security Landing page and tries to sort the CVE column",
					"User must see the following : 1. The result will be displayed alphabetically from A-Z and the year next to the(CVE)when sorted ascending.  The year will be displayed in the ascending order 2.  The result will be displayed alphabetically from Z-A and the year next to the CVE when sorted descending. The year will be displayed in the descending order", 
					"User displayed with data in ascending order"+Report.color(dataAsc)+"<br>"+"displayed with data in descending order"+Report.color(dataDesc), "PASS");
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Log.info("Failed  to sort the CVE column");
			Report.put("Scenario:  User on the security Landing page and tries to sort the CVE column",
					"User must see the following : 1. The result will be displayed alphabetically from A-Z and the year next to the(CVE)when sorted ascending.  The year will be displayed in the ascending order 2.  The result will be displayed alphabetically from Z-A and the year next to the CVE when sorted descending. The year will be displayed in the descending order", 
					"Failed to sort the CVE column", "FAIL");
			Assert.fail();
		}
	}
	
	
	
	
	public void verifyFiltersList(WebDriver driver) 
	{
		Log.info("Inside method verifyFiltersList");
		WebDriverWait  wait = new WebDriverWait(driver, 120);
		
		String filterList = "";
		try
		{
			
			List<WebElement> list=driver.findElements(obj_SecurityLandingPage.FiltersList());

			for(WebElement lt:list)
			{
				CommonUtility.highlightElement(driver, lt);
				String text=lt.getText();

				System.out.println("Text is: " +text);
				filterList+=" <br> " + text;
			}
				
			System.out.println("Filters are: "+filterList);
			
			Report.put("Validate whether the default filters are displayed in a separate tile above the data picker.", 
					"User must see the default filters are displayed in a separate tile above the data picker",
					"User Successfully displayed  filters by default"+Report.color(filterList), "PASS");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
			Report.put("Validate whether the default filters are displayed in a separate tile above the data picker.", 
					"User must see the default filters are displayed in a separate tile above the data picker",
					"User is not able to verify displayed  filters by default", "FAIL");
			Assert.fail();
		}
	}
	
	public void  removeCriticalFilterAndVerifyDetails(WebDriver driver) 
	{
		System.out.println("Inside removeCriticalFilterAndVerifyDetails method");
		Log.info("Inside removeCriticalFilterAndVerifyDetails method");

		String severity = "";
		String data = "";

		WebDriverWait  wait = new WebDriverWait(driver, 120);	
		try
		{
			
			CommonUtility.ScrollTo(driver, obj_SecurityLandingPage.criticalCheckboxLeftPanel());
			CommonUtility.ClickOn(driver,obj_SecurityLandingPage.criticalCheckboxLeftPanel());

			Thread.sleep(3000);
			CommonUtility.ScrollTo(driver,obj_SecurityLandingPage.applyFiltersButton());
			CommonUtility.ClickOn(driver,obj_SecurityLandingPage.applyFiltersButton());
			
				data = CommonUtility.highlightElement(driver,obj_SecurityLandingPage.firstRowData()).getText();
				System.out.println("First Row data is: "+data);
			
			Report.put("Remove each filters individually from above date picker",
					"User must see the specific filter be unchecked under filters filed on the left pane and the table be updated as per the filter selected.", 
					"Removed Filter Critical and table refreshed with data"+Report.color(data) , "PASS");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Remove each filters individually from above date picker",
					"User must see the specific filter be unchecked under filters filed on the left pane and the table be updated as per the filter selected.", 
					"Failed to remove the filters", "FAIL");
			Assert.fail("Failed to remove the filters");
		}
	}
	
	public void  selectSecurityNoticesAndVerifyDetails(WebDriver driver) 
	{
		System.out.println("Inside selectSecurityNoticesAndVerifyDetails method");
		Log.info("Inside selectSecurityNoticesAndVerifyDetails method");

		String filterList = "";
		String data = "";
		String displayingText = "";

		WebDriverWait  wait = new WebDriverWait(driver, 120);	
		try
		{
			CommonUtility.ScrollTo(driver,obj_SecurityLandingPage.securityAdvisoriesCheckboxLeftPanel());
			CommonUtility.ClickOn(driver,obj_SecurityLandingPage.securityAdvisoriesCheckboxLeftPanel());
			CommonUtility.ClickOn(driver,obj_SecurityLandingPage.securityAdvisoriesCheckboxLeftPanel());
			
			Thread.sleep(3000);
			CommonUtility.ClickOn(driver,obj_SecurityLandingPage.InformationalCheckbox());
			
			CommonUtility.ScrollTo(driver,obj_SecurityLandingPage.applyFiltersButton());
			CommonUtility.highlightElement(driver,obj_SecurityLandingPage.applyFiltersButton()).click();
			
				data = CommonUtility.highlightElement(driver,obj_SecurityLandingPage.firstRowData()).getText();
				System.out.println("First Row data is: "+data);
				
				List<WebElement> list=driver.findElements(obj_SecurityLandingPage.FiltersList());

				for(WebElement lt:list)
				{
					CommonUtility.highlightElement(driver, lt);
					String text=lt.getText();

					System.out.println("Text is: " +text);
					filterList+=" <br> " + text;
				}
					
				System.out.println("Filters are: "+filterList);
				displayingText = CommonUtility.highlightElement(driver, obj_SecurityLandingPage.displayingPageText()).getText();
				
			
			Report.put("Select only 'Security Notices' filter on the left pane and click on Apply filters",
					"User must see the following: 1. The table should show filters only Security Notices. 2. Security and Notice filter must be displayed in a separate tile above the data picker. 3. At the bottom, the displaying count should be same as the  count against the Security Notices filter ", 
					"Select only 'Security Notices' and table refreshed with data"+Report.color(data)+"and filters"+Report.color(filterList)+Report.color(displayingText) , "PASS");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Select only 'Security Notices' filter on the left pane and click on Apply filters",
					"User must see the following: 1. The table should show filters only Security Notices. 2. Security and Notice filter must be displayed in a separate tile above the data picker. 3. At the bottom, the displaying count should be same as the  count against the Security Notices filter ", 
					"Failed to Select only 'Security Notices' filter", "FAIL");
			Assert.fail("Failed to Select only 'Security Notices' filter");
		}
	}
	
	public void  selectInformationalAndVerifyDetails(WebDriver driver) 
	{
		System.out.println("Inside selectInformationalAndVerifyDetails method");
		Log.info("Inside selectInformationalAndVerifyDetails method");

		String filterList = "";
		String data = "";
		String displayingText = "";

		WebDriverWait  wait = new WebDriverWait(driver, 120);	
		try
		{
			CommonUtility.ClickOn(driver,obj_SecurityLandingPage.SecurityNoticesCheckbox());
			
			CommonUtility.ScrollTo(driver,obj_SecurityLandingPage.InformationalCheckbox());
			CommonUtility.ClickOn(driver,obj_SecurityLandingPage.InformationalCheckbox());
			
			Thread.sleep(3000);
			
			
			CommonUtility.ScrollTo(driver,obj_SecurityLandingPage.applyFiltersButton());
			CommonUtility.ClickOn(driver,obj_SecurityLandingPage.applyFiltersButton());
		
			Thread.sleep(3000);
			
			if(CommonUtility.CheckpresenceofElementLocated(driver,10,obj_SecurityLandingPage.NoRecordsMessage()))
			{

				data = CommonUtility.highlightElement(driver,obj_SecurityLandingPage.NoRecordsMessage()).getText();
				System.out.println("Message is "+data);
			}
			else
			{
			
				data = CommonUtility.highlightElement(driver,obj_SecurityLandingPage.firstRowData()).getText();
				System.out.println("First Row data is: "+data);
			}	
				List<WebElement> list=driver.findElements(obj_SecurityLandingPage.FiltersList());

				for(WebElement lt:list)
				{
					CommonUtility.highlightElement(driver, lt);
					String text=lt.getText();

					System.out.println("Text is: " +text);
					filterList+=" <br> " + text;
				}
					
				System.out.println("Filters are: "+filterList);
				
				displayingText = CommonUtility.highlightElement(driver, obj_SecurityLandingPage.displayingPageText()).getText();
			
			Report.put("Select only 'Informational' filter on the left pane and click on Apply filters",
					"User must see the following: 1. The table should show filters only Informational 2. Informational filter must be displayed in a separate tile above the data picker. 3. At the bottom, the displaying count should be same as the count against the Informational  filter ", 
					"Select only 'Informational' filter and table refreshed with data"+Report.color(data)+"and filters"+Report.color(filterList)+"with count"+Report.color(displayingText) , "PASS");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Select only 'Informational' filter on the left pane and click on Apply filters",
					"User must see the following: 1. The table should show filters only Informational 2. Informational filter must be displayed in a separate tile above the data picker. 3. At the bottom, the displaying count should be same as the count against the Informational  filter ", 
					"Failed to Select only 'Informational' filter", "FAIL");
			Assert.fail("Failed to Select only 'Informational' filter");
		}
	}
	
	public void  selectOnlyCriticalFilterAndVerifyDetails(WebDriver driver) 
	{
		System.out.println("Inside selectOnlyCriticalFilterAndVerifyDetails method");
		Log.info("Inside selectOnlyCriticalFilterAndVerifyDetails method");

		String displayingText = "";
		String data = "";

		WebDriverWait  wait = new WebDriverWait(driver, 120);	
		try
		{
			CommonUtility.ClickOn(driver,obj_SecurityLandingPage.InformationalCheckbox());
			
			CommonUtility.ScrollTo(driver, obj_SecurityLandingPage.criticalCheckboxLeftPanel());
			CommonUtility.ClickOn(driver,obj_SecurityLandingPage.criticalCheckboxLeftPanel());

			Thread.sleep(3000);
			CommonUtility.ScrollTo(driver,obj_SecurityLandingPage.applyFiltersButton());
			CommonUtility.ClickOn(driver,obj_SecurityLandingPage.applyFiltersButton());
			
				data = CommonUtility.highlightElement(driver,obj_SecurityLandingPage.firstRowData()).getText();
				System.out.println("First Row data is: "+data);
				
				displayingText = CommonUtility.highlightElement(driver, obj_SecurityLandingPage.displayingPageText()).getText();
			
			Report.put("Select only 'Critical' filter on the left pane and click on Apply filters",
					"User must see the following: 1. The table should show filters only Critical  2. Critical filter must be displayed in a separate tile above the data picker.3. The number against the 'Security Advisories' should be the same as number against Critical filter", 
					"Select Filter Critical and table refreshed with data"+Report.color(data)+Report.color(displayingText) , "PASS");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Select only 'Critical' filter on the left pane and click on Apply filters",
					"User must see the following: 1. The table should show filters only Critical  2. Critical filter must be displayed in a separate tile above the data picker.3. The number against the 'Security Advisories' should be the same as number against Critical filter", 
					"Failed to Select only 'Critical' filter ", "FAIL");
			Assert.fail("Failed to Select only 'Critical' filter");
		}
	}
	
	public void  selectOnlyHighFilterAndVerifyDetails(WebDriver driver) 
	{
		System.out.println("Inside selectOnlyHighFilterAndVerifyDetails method");
		Log.info("Inside selectOnlyHighFilterAndVerifyDetails method");

		String displayingText = "";
		String data = "";

		WebDriverWait  wait = new WebDriverWait(driver, 120);	
		try
		{
			
			CommonUtility.ClickOn(driver,obj_SecurityLandingPage.criticalCheckboxLeftPanel());
			
			CommonUtility.ScrollTo(driver, obj_SecurityLandingPage.HighCheckboxLeftPanel());
			CommonUtility.ClickOn(driver,obj_SecurityLandingPage.HighCheckboxLeftPanel());

			Thread.sleep(3000);
			CommonUtility.ScrollTo(driver,obj_SecurityLandingPage.applyFiltersButton());
			CommonUtility.highlightElement(driver,obj_SecurityLandingPage.applyFiltersButton()).click();
			Thread.sleep(3000);
				data = CommonUtility.highlightElement(driver,obj_SecurityLandingPage.firstRowData()).getText();
				System.out.println("First Row data is: "+data);
				
				displayingText = CommonUtility.highlightElement(driver, obj_SecurityLandingPage.displayingPageText()).getText();
			
			Report.put("Select only 'High' filter on the left pane and click on Apply filters",
					"User must see the following: 1. The table should show filters only High 2. High filter must be displayed in a separate tile above the data picker. 3. The number against the 'Security Advisories' should be the same as number against High filter 4. At the bottom, the displayimg count should be same as the count against the High filter ", 
					"Select Filter High and table refreshed with data"+Report.color(data)+Report.color(displayingText) , "PASS");
		}
		catch(Exception e)
		{
			Report.put("Select only 'High' filter on the left pane and click on Apply filters",
					"User must see the following: 1. The table should show filters only High 2. High filter must be displayed in a separate tile above the data picker. 3. The number against the 'Security Advisories' should be the same as number against High filter 4. At the bottom, the displayimg count should be same as the count against the High filter ", 
					"Failed to Select only 'High' filter ", "FAIL");
			Assert.fail("Failed to Select only 'High' filter");
		}
	}
	
	public void  selectOnlyMediumFilterAndVerifyDetails(WebDriver driver) 
	{
		System.out.println("Inside selectOnlyMediumFilterAndVerifyDetails method");
		Log.info("Inside selectOnlyMediumFilterAndVerifyDetails method");

		String displayingText = "";
		String data = "";

		WebDriverWait  wait = new WebDriverWait(driver, 120);	
		try
		{
			CommonUtility.ClickOn(driver,obj_SecurityLandingPage.HighCheckboxLeftPanel());
			
			CommonUtility.ScrollTo(driver, obj_SecurityLandingPage.MediumCheckboxLeftPanel());
			CommonUtility.ClickOn(driver,obj_SecurityLandingPage.MediumCheckboxLeftPanel());

			Thread.sleep(3000);
			CommonUtility.ScrollTo(driver,obj_SecurityLandingPage.applyFiltersButton());
			CommonUtility.highlightElement(driver,obj_SecurityLandingPage.applyFiltersButton()).click();
			Thread.sleep(3000);
				data = CommonUtility.highlightElement(driver,obj_SecurityLandingPage.firstRowData()).getText();
				System.out.println("First Row data is: "+data);
				
				displayingText = CommonUtility.highlightElement(driver, obj_SecurityLandingPage.displayingPageText()).getText();
			
			Report.put("Select only 'Medium' filter on the left pane and click on Apply filters",
					"User must see the following: 1. The table should show filters only Medium 2. Medium filter must be displayed in a separate tile above the data picker.3. The number against the 'Security Advisories' should be the same as number against medium filter 4. At the bottom, the displaying count should be same as the count against the Medium filter ", 
					"Select Filter Medium and table refreshed with data"+Report.color(data)+Report.color(displayingText) , "PASS");
		}
		catch(Exception e)
		{Report.put("Select only 'Medium' filter on the left pane and click on Apply filters",
				"User must see the following: 1. The table should show filters only Medium 2. Medium filter must be displayed in a separate tile above the data picker.3. The number against the 'Security Advisories' should be the same as number against medium filter 4. At the bottom, the displaying count should be same as the count against the Medium filter ", 
					"Failed to Select only 'Medium' filter ", "FAIL");
			Assert.fail("Failed to Select only 'Medium' filter");
		}
	}
	
	public void  selectOnlyLowFilterAndVerifyDetails(WebDriver driver) 
	{
		System.out.println("Inside selectOnlyLowFilterAndVerifyDetails method");
		Log.info("Inside selectOnlyLowFilterAndVerifyDetails method");

		String displayingText = "";
		String data = "";

		WebDriverWait  wait = new WebDriverWait(driver, 120);	
		try
		{
			CommonUtility.ClickOn(driver,obj_SecurityLandingPage.MediumCheckboxLeftPanel());
			
			CommonUtility.ScrollTo(driver, obj_SecurityLandingPage.LowCheckboxLeftPanel());
			CommonUtility.ClickOn(driver,obj_SecurityLandingPage.LowCheckboxLeftPanel());

			Thread.sleep(3000);
			CommonUtility.scrollToViewElement(driver,obj_SecurityLandingPage.applyFiltersButton());
			CommonUtility.highlightElement(driver,obj_SecurityLandingPage.applyFiltersButton()).click();
			Thread.sleep(3000);
				data = CommonUtility.highlightElement(driver,obj_SecurityLandingPage.firstRowData()).getText();
				System.out.println("First Row data is: "+data);
				
				displayingText = CommonUtility.highlightElement(driver, obj_SecurityLandingPage.displayingPageText()).getText();
			
			Report.put("Select only 'Low' filter on the left pane and click on Apply filters",
					"User must see the following: 1. The table should show filters only Low 2. Low filter must be displayed in a separate tile above the data picker. 3. The number against the 'Security Advisories' should be the same as number against Low filter 4. At the bottom, the displaying count should be same as the count against the Low filter ", 
					"Select Filter Low and table refreshed with data"+Report.color(data)+Report.color(displayingText) , "PASS");
		}
		catch(Exception e)
		{
			Report.put("Select only 'Low' filter on the left pane and click on Apply filters",
					"User must see the following: 1. The table should show filters only Low 2. Low filter must be displayed in a separate tile above the data picker. 3. The number against the 'Security Advisories' should be the same as number against Low filter 4. At the bottom, the displaying count should be same as the count against the Low filter ", 
					"Failed to Select only 'Critical' filter ", "FAIL");
			Assert.fail("Failed to Select only 'Low' filter");
		}
	}
	
	public void verifyContactUsSliderContent(WebDriver driver)
	{
		System.out.println("Inside verifyContactUsSliderContent method");
		Log.info("Inside verifyContactUsSliderContent method");

		try
		{

			String contentList = "";
			String temp = "";

			WebDriverWait wait = new WebDriverWait(driver, 120);

			CommonUtility.ClickOn(driver,obj_EsupportIPSHomePage.clickSlider());
			
			List<WebElement> list=driver.findElements(obj_EsupportIPSHomePage.contactUsSliderContent());

			for(WebElement lt:list)
			{
				CommonUtility.highlightElement(driver, lt);
				String name=lt.getText();

				System.out.println("Content is: " +name);
				contentList+=" <br> " + name;
			}
			System.out.println("Content List: "+contentList);



			Report.put("Validate whether the user sees the Contact slider on the right side of the page with the option: Contact Technical Support, Order Support",
					"User must see the Contact slider on the right side of the page with the option: Contact Technical Support, Order Support",
					"Contact us Slider options are: "+Report.color(contentList), "PASS");

		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Validate whether the user sees the Contact slider on the right side of the page with the option: Contact Technical Support, Order Support",
					"User must see the Contact slider on the right side of the page with the option: Contact Technical Support, Order Support",
					"Failed to display Contact us Slider options", "FAIL");
			Assert.fail();
		}
	}
	
	public void verifyContactUsSliderOnSignIn(WebDriver driver)
	{
		System.out.println("Inside verifyContactUsSliderOnSignIn method");
		Log.info("Inside verifyContactUsSliderOnSignIn method");

		try
		{

			String contentList = "";
			String temp = "";

			WebDriverWait wait = new WebDriverWait(driver, 120);

			Thread.sleep(7000);
			List<WebElement> list=driver.findElements(obj_EsupportIPSHomePage.contactUsSliderContent());

			for(WebElement lt:list)
			{
				CommonUtility.highlightElement(driver, lt);
				String name=lt.getText();

				System.out.println("Content is: " +name);
				contentList+=" <br> " + name;
			}
			System.out.println("Content List: "+contentList);



			Report.put("An authenticated EMC user is accessing the Contact slider on the SLP page, validate the options displayed in the contact Slider",
					"User must see 'Chat with Support' and 'Create Service Request' options ",
					"Contact us Slider options are: "+Report.color(contentList), "PASS");

		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("An authenticated EMC user is accessing the Contact slider on the SLP page, validate the options displayed in the contact Slider",
					"User must see 'Chat with Support' and 'Create Service Request' options ",
					"Failed to display Contact us Slider options", "FAIL");
			Assert.fail();
		}
	}
	
	public void  searchTextAndVerifyData(WebDriver driver, String text) 
	{
		System.out.println("Inside searchTextAndVerifyData method");
		Log.info("Inside searchTextAndVerifyData method");

		WebDriverWait  wait = new WebDriverWait(driver, 120);	
		String data = "";
		String count = "";
		try
		{
			
			CommonUtility.scrollToViewElement(driver,obj_SecurityLandingPage.searchTextbox());
			CommonUtility.highlightElement(driver,obj_SecurityLandingPage.searchTextbox()).sendKeys(text);
			
			Thread.sleep(3000);
			CommonUtility.ClickOn(driver, obj_SecurityLandingPage.searchIcon());
			Thread.sleep(3000);

			data = CommonUtility.highlightElement(driver,obj_SecurityLandingPage.firstRowData()).getText();
			System.out.println("First Row data is: "+data);
			
			count = CommonUtility.highlightElement(driver,obj_SecurityLandingPage.CriticalCount()).getText();
			System.out.println("Filter count is: "+count);

			Report.put("An user on the SLP page searches for a keyword(s) using the searh box and the table is updated with the results of the keyword(s) search",
					"User must see the numbers next to the filter labels should update to reflect the contents of the table", 
					"User searched for "+Report.color(text) +"and displayed the search results "+Report.color(data)+".The count next to filter is "+Report.color(count) , "PASS");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("An user on the SLP page searches for a keyword(s) using the searh box and the table is updated with the results of the keyword(s) search",
					"User must see the numbers next to the filter labels should update to reflect the contents of the table", 
					"Failed to search the keyword", "FAIL");
			Assert.fail("Failed to  search the keyword");
		}
	}
	
	public void enterDateAndVerifyFilterCount(WebDriver driver, String fromDate, String toDate) 
	{
		Log.info("Inside method enterDateAndVerifyFilterCount");
		WebDriverWait  wait = new WebDriverWait(driver, 120);
		
		String count = "";
		try
		{
			
			 CommonUtility.highlightElement(driver, obj_SecurityLandingPage.FromDateTextbox()).sendKeys(fromDate);
			 CommonUtility.highlightElement(driver, obj_SecurityLandingPage.ToDateTextbox()).sendKeys(toDate);
			
							
			System.out.println("Dates are: "+fromDate+toDate);
			
			Thread.sleep(3000);
			CommonUtility.scrollToViewElement(driver,obj_SecurityLandingPage.applyFiltersButton());
			CommonUtility.highlightElement(driver,obj_SecurityLandingPage.applyFiltersButton()).click();
			
			Thread.sleep(3000);
			
			count = CommonUtility.highlightElement(driver,obj_SecurityLandingPage.CriticalCount()).getText();
			System.out.println("Filter count is: "+count);
			
			Report.put("An user on the SLP page,selects a date range and apply the filters", 
					"User must see the numbers next to the filter labels should update to reflect the contents of the table",
					"User is able to see two date picker box with dates entered "+Report.color(fromDate) +Report.color(toDate)+"and filter count is "+Report.color(count), "PASS");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("An user on the SLP page,selects a date range and apply the filters", 
					"User must see the numbers next to the filter labels should update to reflect the contents of the table",
					"User is not able to enter date range and apply filters", "FAIL");
			Assert.fail();
		}
	}
	
	public void  removeCriticalFilterAndVerifyCount(WebDriver driver) 
	{
		System.out.println("Inside removeCriticalFilterAndVerifyCount method");
		Log.info("Inside removeCriticalFilterAndVerifyCount method");

		String count = "";
		String data = "";

		WebDriverWait  wait = new WebDriverWait(driver, 120);	
		try
		{
			
			CommonUtility.scrollToViewElement(driver, obj_SecurityLandingPage.criticalCheckboxLeftPanel());
			CommonUtility.ClickOn(driver,obj_SecurityLandingPage.criticalCheckboxLeftPanel());

			Thread.sleep(3000);
			CommonUtility.scrollToViewElement(driver,obj_SecurityLandingPage.applyFiltersButton());
			CommonUtility.highlightElement(driver,obj_SecurityLandingPage.applyFiltersButton()).click();
			Thread.sleep(3000);
				data = CommonUtility.highlightElement(driver,obj_SecurityLandingPage.firstRowData()).getText();
				System.out.println("First Row data is: "+data);
				Thread.sleep(3000);	
				count = CommonUtility.highlightElement(driver,obj_SecurityLandingPage.CriticalCount()).getText();
				System.out.println("Filter count is: "+count);
			
			Report.put("An user on the SLP page removes filters and applies them",
					"User must see the  numbers next to the filter labels should update to reflect the filters that were removed", 
					"Removed Filter Critical and table refreshed with data"+Report.color(data) +"and filter count is:" , "PASS");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("An user on the SLP page removes filters and applies them",
					"User must see the  numbers next to the filter labels should update to reflect the filters that were removed", 
					"Failed to remove the filters", "FAIL");
			Assert.fail("Failed to remove the filters");
		}
	}
	
	public void enterFromDateAndVerifyDateTextbox(WebDriver driver) 
	{
		Log.info("Inside method enterFromDateAndVerifyDateTextbox");
		WebDriverWait  wait = new WebDriverWait(driver, 120);
		
		String att = "";
		String fromDate = "";
		try
		{
			 CommonUtility.scrollToViewElement(driver, obj_SecurityLandingPage.FromDateTextbox());	
			 CommonUtility.ClickOn(driver, obj_SecurityLandingPage.FromDateTextbox());
			 Thread.sleep(3000);
			 CommonUtility.ClickOn(driver, obj_SecurityLandingPage.FromCalendarPrevArrow());
			 Thread.sleep(5000);
			 CommonUtility.scrollToViewElement(driver, obj_SecurityLandingPage.SelectDateFromCalendar());	
			 CommonUtility.highlightElement(driver, obj_SecurityLandingPage.SelectDateFromCalendar()).click();
			 Thread.sleep(5000);
			 fromDate = CommonUtility.highlightElement(driver, obj_SecurityLandingPage.FromDateTextbox()).getAttribute("placeholder");
			 
			 att = CommonUtility.highlightElement(driver, obj_SecurityLandingPage.ToDateTextbox()).getAttribute("class");	
			
			 System.out.println("Attribute value is: "+att);
			 if(att.contains("border-danger"))
			 {
				 Report.put("User is on the Security Landing Page and tries to filter only the From date or to date", 
							"User must see the other date picker box highlighted in Red respectively",
							"User entered From Date"+Report.color(fromDate) +"and To Date box is highlighted in Red ", "PASS");
			 }
			 else
			 {
				 Report.put("User is on the Security Landing Page and tries to filter only the From date or to date", 
							"User must see the other date picker box highlighted in Red respectively",
							"User is not able to verify date picker box highlighted in Red respectively", "FAIL");
					Assert.fail(); 
			 }
		}
		catch(Exception e)
		{
			e.printStackTrace();
			 Report.put("User is on the Security Landing Page and tries to filter only the From date or to date", 
						"User must see the other date picker box highlighted in Red respectively",
						"User is not able to verify date picker box highlighted in Red respectively", "FAIL");
				Assert.fail(); 
		}
	}
	
	public void verifyPublishedOptionAndUpdatedOption(WebDriver driver) 
	{
		Log.info("Inside method verifyPublishedOptionAndUpdatedOption");
		WebDriverWait  wait = new WebDriverWait(driver, 120);
		
		String publishedText = "";
		String updatedText = "";
		String fromDate = "";
		String toDate = "";
		
		try
		{
		
			fromDate = CommonUtility.highlightElement(driver, obj_SecurityLandingPage.FromDateTextbox()).getAttribute("placeholder");	
			
			 CommonUtility.ClickOn(driver, obj_SecurityLandingPage.ToDateTextbox());
			 Thread.sleep(5000);
			 CommonUtility.highlightElement(driver, obj_SecurityLandingPage.SelectDateToCalendar()).click();
			 Thread.sleep(5000);
			 toDate = CommonUtility.highlightElement(driver, obj_SecurityLandingPage.ToDateTextbox()).getAttribute("placeholder");	
			 Thread.sleep(3000);
			 publishedText = CommonUtility.highlightElement(driver, obj_SecurityLandingPage.DatePill()).getText();	
			
			 System.out.println("Text from the pill is "+publishedText);
			 
			 CommonUtility.ClickOn(driver, obj_SecurityLandingPage.UpdatedRadioButton());
			 
			 updatedText = CommonUtility.highlightElement(driver, obj_SecurityLandingPage.DatePill()).getText();	
			 
				 Report.put("User selects Published option and selects the date from the date picker. 2. User selects Updated option and selects the date range from the date picker.", 
							"User must see the following : 1. User should see the table results updated by the Published articles within the date range selected. 2. User should see the table results updated by the Updated articles within the date range selected.",
							"User entered From Date and To Date "+Report.color(fromDate) +Report.color(fromDate)+ "Results are updated with time range "+Report.color(publishedText)+Report.color(updatedText), "PASS");
			 
		}
		catch(Exception e)
		{
			e.printStackTrace();
			 Report.put("User selects Published option and selects the date from the date picker. 2. User selects Updated option and selects the date range from the date picker.", 
						"User must see the following : 1. User should see the table results updated by the Published articles within the date range selected. 2. User should see the table results updated by the Updated articles within the date range selected.",
						"User is not able to select Published option & Updated option", "FAIL");
				Assert.fail(); 
		}
	}
	
	public void enterOutOfRangeDateAndVerifydate(WebDriver driver, String fromDate, String toDate) 
	{
		Log.info("Inside method enterOutOfRangeDateAndVerifydate");
		WebDriverWait  wait = new WebDriverWait(driver, 120);
		
		String datePill = "";
		try
		{
			 CommonUtility.highlightElement(driver, obj_SecurityLandingPage.FromDateTextbox()).clear();
			 CommonUtility.highlightElement(driver, obj_SecurityLandingPage.ToDateTextbox()).clear();
			 
			 CommonUtility.highlightElement(driver, obj_SecurityLandingPage.FromDateTextbox()).sendKeys(fromDate);
			 CommonUtility.highlightElement(driver, obj_SecurityLandingPage.ToDateTextbox()).sendKeys(toDate);
			
							
			System.out.println("Dates are: "+fromDate+toDate);
			
			Thread.sleep(3000);
			CommonUtility.scrollToViewElement(driver,obj_SecurityLandingPage.applyFiltersButton());
			CommonUtility.highlightElement(driver,obj_SecurityLandingPage.applyFiltersButton()).click();
			
			Thread.sleep(3000);
			
			datePill = CommonUtility.highlightElement(driver,obj_SecurityLandingPage.DatePill()).getText();
			System.out.println("Date range  is: "+datePill);
			
			Report.put("User is on the Security Landing Page and user tries to  manually enters a date that falls outside the configured range ", 
					"User must be able to see the picker should automatically adjust to a date that falls within the range",
					"User entered the date "+Report.color(fromDate) +Report.color(toDate)+"and date range picked is "+Report.color(datePill), "PASS");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("User is on the Security Landing Page and user tries to  manually enters a date that falls outside the configured range ", 
					"User must be able to see the picker should automatically adjust to a date that falls within the range",
					"User is not able to enter date out of range ", "FAIL");
			Assert.fail();
		}
	}
	
	public void verifyYearOptionsInCalendar(WebDriver driver) 
	{
		Log.info("Inside method verifyYearOptionsInCalendar");
		WebDriverWait  wait = new WebDriverWait(driver, 120);
		
		String options = "";
		try
		{
			 CommonUtility.ScrollTo(driver, obj_SecurityLandingPage.FromDateTextbox());	
			 CommonUtility.ClickOn(driver, obj_SecurityLandingPage.FromDateTextbox());
			 Thread.sleep(3000);
			 CommonUtility.ClickOn(driver, obj_SecurityLandingPage.YearDropdown());
			 
			 List<WebElement> list=driver.findElements(obj_SecurityLandingPage.YearOptions());

				for(WebElement lt:list)
				{
					CommonUtility.highlightElement(driver, lt);
					String text=lt.getText();

					System.out.println("Text is: " +text);
					options+=" <br> " + text;
				}
					
				System.out.println("Options are: "+options);
			
			Report.put("Scenario : User is on the Security Landing Page and user tries to  select date ", 
					"ser must be able to see the calendar only display the years 2019 and 2020 ",
					"User is displayed with years "+Report.color(options) , "PASS");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Scenario : User is on the Security Landing Page and user tries to  select date ", 
					"ser must be able to see the calendar only display the years 2019 and 2020 ",
					"User is not able to verify the years 2019 and 2020", "FAIL");
			Assert.fail();
		}
	}
	
	public void clickApplyFiltersAndVerifyData(WebDriver driver) 
	{
		Log.info("Inside method clickApplyFiltersAndVerifyData");
		WebDriverWait  wait = new WebDriverWait(driver, 120);
		
		String data = "";
		try
		{
			
			CommonUtility.scrollToViewElement(driver,obj_SecurityLandingPage.applyFiltersButton());
			CommonUtility.highlightElement(driver,obj_SecurityLandingPage.applyFiltersButton()).click();
			
			Thread.sleep(3000);
			
			data = CommonUtility.highlightElement(driver,obj_SecurityLandingPage.firstRowData()).getText();
			System.out.println("Data is: "+data);
			
			Report.put("User is on the Security Landing Page and user tries to  filters by date", 
					"User must be able to see the table should be updated based on the filter selection",
					"User is able to see table updated based on filter section" +Report.color(data), "PASS");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("User is on the Security Landing Page and user tries to  filters by date", 
					"User must be able to see the table should be updated based on the filter selection",
					"User is not able to enter date range and apply filters", "FAIL");
			Assert.fail();
		}
	}
	
	public void verifyDisplayingText(WebDriver driver) 
	{
		Log.info("Inside method verifyDisplayingText");
		WebDriverWait  wait = new WebDriverWait(driver, 120);
		
		String displayingText = "";
		
		try
		{
			displayingText = CommonUtility.highlightElement(driver, obj_SecurityLandingPage.displayingPageText()).getText();
			
							
			System.out.println("Displaying text is: "+ displayingText);
			
			
			Report.put("An user on SLP sees multiple pages of articles", 
					"User must see the following : 1. Text with the number of articles displayed should appear 2. Should be updated based on the user's page (example: Displaying 1-25 of 123 on the first page; Displaying 26-50 of 123 on the second page, etc.)",
					"User is displayed with text"+Report.color(displayingText), "PASS");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("An user on SLP sees multiple pages of articles", 
					"User must see the following : 1. Text with the number of articles displayed should appear 2. Should be updated based on the user's page (example: Displaying 1-25 of 123 on the first page; Displaying 26-50 of 123 on the second page, etc.)",
					"User is not able to verify details displayed on the table", "FAIL");
			Assert.fail();
		}
	}
	
	public void verifyPageDropdown(WebDriver driver) 
	{
		Log.info("Inside method verifyPageDropdown");
		WebDriverWait  wait = new WebDriverWait(driver, 120);
		
		String dropdownValues = "";
		String defaultValue = "";
		
		try
		{
			 CommonUtility.ScrollTo(driver, obj_SecurityLandingPage.PageDropdown());	
//			 CommonUtility.ClickOn(driver, obj_SecurityLandingPage.PageDropdown());
//			 Thread.sleep(3000);
			 
			 if(CommonUtility.CheckpresenceofElementLocated(driver, 10, obj_SecurityLandingPage.PageDropdown()))
				{		
				
					WebElement selectElement = driver.findElement(obj_SecurityLandingPage.PageDropdown());
					Select select = new Select(selectElement);
					
					defaultValue = select.getFirstSelectedOption().getText();
					
					System.out.println("Default Value is: "+defaultValue);
					
					List<WebElement> allOptions = select.getOptions();

					for(WebElement op:allOptions)
					{
						CommonUtility.highlightElement(driver,op);
						String value = op.getText();
						System.out.println("Value  is: " +value);
						dropdownValues+=" <br> " + value;
					}
					System.out.println("Dropdown Values : "+dropdownValues);

			
			Report.put("An user on SLP clicks the dropdown that shows how many articles per page", 
					"User must see the following : 1. Should be able to select from 10, 25, 50, and 100 2. the default value selected should be 25",
					"User is displayed with options to select "+Report.color(dropdownValues) +"and default value"+Report.color(defaultValue), "PASS");
				}
			 else
			 {
				 Report.put("An user on SLP clicks the dropdown that shows how many articles per page", 
							"User must see the following : 1. Should be able to select from 10, 25, 50, and 100 2. the default value selected should be 25",
							"User is not able to verify dropdown that shows how many articles per page", "FAIL");
					Assert.fail();
			 }
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("An user on SLP clicks the dropdown that shows how many articles per page", 
					"User must see the following : 1. Should be able to select from 10, 25, 50, and 100 2. the default value selected should be 25",
					"User is not able to verify dropdown that shows how many articles per page", "FAIL");
			Assert.fail();
		}
	}
	
	public void verifyrightPointingArrows(WebDriver driver) 
	{
		Log.info("Inside method verifyrightPointingArrows");
		WebDriverWait  wait = new WebDriverWait(driver, 120);

		try
		{
			if(CommonUtility.highlightElement(driver, obj_SecurityLandingPage.NextPageArrow()).isEnabled() && CommonUtility.highlightElement(driver, obj_SecurityLandingPage.LastPageArrow()).isEnabled())
			{		
				System.out.println("Next Page Arrow & Last Page Arrow is enabled ");

				Report.put("An user on the first page of articles", 
						"User must see the right-pointing arrows should be activated",
						"User is displayed with right-pointing arrows activated", "PASS");
			}
			else
			{
				Report.put("An user on the first page of articles", 
						"User must see the right-pointing arrows should be activated",
						"User is not able to verify right-pointing arrows activated", "FAIL");
				Assert.fail();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("An user on the first page of articles", 
					"User must see the right-pointing arrows should be activated",
					"User is not able to verify right-pointing arrows activated", "FAIL");
			Assert.fail();
		}
	}
	
	public void verifyNextPageAndLastPage(WebDriver driver) 
	{
		Log.info("Inside method verifyNextPageAndLastPage");
		WebDriverWait  wait = new WebDriverWait(driver, 120);

		String nextPageNum = "";
		String lastPageNum = "";
		
		try
		{
			CommonUtility.ClickOn(driver, obj_SecurityLandingPage.NextPageArrow());
			Thread.sleep(3000);
			
			nextPageNum = CommonUtility.highlightElement(driver, obj_SecurityLandingPage.PageNumberTextbox()).getAttribute("value");
		
			System.out.println("Next Page number is:"+nextPageNum);
			
			CommonUtility.ClickOn(driver, obj_SecurityLandingPage.LastPageArrow());
			Thread.sleep(3000);
			lastPageNum = CommonUtility.highlightElement(driver, obj_SecurityLandingPage.PageNumberTextbox()).getAttribute("value");

			System.out.println("Last Page number is:"+lastPageNum);
			

				Report.put("An user sees the right-pointing arrows are activated", 
						"User must see the following : 1. Clicking on the first arrow should take me to the next page 2. Clicking on the second one (with the arrow and vertical bar) should take me to the last page",
						"User clicked on first arrow and displayed page "+Report.color(nextPageNum)+".Clicking on second one displayed page "+Report.color(lastPageNum), "PASS");
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("An user sees the right-pointing arrows are activated", 
					"User must see the following : 1. Clicking on the first arrow should take me to the next page 2. Clicking on the second one (with the arrow and vertical bar) should take me to the last page",
					"User is not able to verify next page and last page arrows", "FAIL");
			Assert.fail();
		}
	}
	
	public void verifyArrowsActivated(WebDriver driver) 
	{
		Log.info("Inside method verifyrightPointingArrows");
		WebDriverWait  wait = new WebDriverWait(driver, 120);

		try
		{
			CommonUtility.ClickOn(driver, obj_SecurityLandingPage.PreviousPageArrow());
			Thread.sleep(3000);
			
			if(CommonUtility.highlightElement(driver, obj_SecurityLandingPage.NextPageArrow()).isEnabled() && CommonUtility.highlightElement(driver, obj_SecurityLandingPage.LastPageArrow()).isEnabled() && CommonUtility.highlightElement(driver, obj_SecurityLandingPage.PreviousPageArrow()).isEnabled() && CommonUtility.highlightElement(driver, obj_SecurityLandingPage.FirstPageArrow()).isEnabled())
			{		
				System.out.println("Arrows are enabled ");

				Report.put("An user on the SLP page on one of the middle pages of articles", 
						"User must see the left-pointing and right-pointing arrows be activated.",
						"User is displayed with left-pointing and right-pointing arrows activated", "PASS");
			}
			else
			{
				Report.put("An user on the SLP page on one of the middle pages of articles", 
						"User must see the left-pointing and right-pointing arrows be activated.",
						"User is not able to verify left-pointing and right-pointing arrows activated", "FAIL");
				Assert.fail();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("An user on the SLP page on one of the middle pages of articles", 
					"User must see the left-pointing and right-pointing arrows be activated.",
					"User is not able to verify left-pointing and right-pointing arrows activated", "FAIL");
			Assert.fail();
		}
	}
	
	public void verifyPageNavigation(WebDriver driver) 
	{
		Log.info("Inside method verifyPageNavigation");
		WebDriverWait  wait = new WebDriverWait(driver, 120);

		String nextPageNum = "";
		String lastPageNum = "";
		String previousPageNum = "";
		String firstPageNum = "";
		
		try
		{
			CommonUtility.ClickOn(driver, obj_SecurityLandingPage.NextPageArrow());
			
			nextPageNum = CommonUtility.highlightElement(driver, obj_SecurityLandingPage.PageNumberTextbox()).getAttribute("value");
		
			System.out.println("Next Page number is:"+nextPageNum);
			
			CommonUtility.ClickOn(driver, obj_SecurityLandingPage.LastPageArrow());
			lastPageNum = CommonUtility.highlightElement(driver, obj_SecurityLandingPage.PageNumberTextbox()).getAttribute("value");

			System.out.println("Last Page number is:"+lastPageNum);
			
			CommonUtility.ClickOn(driver, obj_SecurityLandingPage.PreviousPageArrow());
			
			previousPageNum = CommonUtility.highlightElement(driver, obj_SecurityLandingPage.PageNumberTextbox()).getAttribute("value");
		
			System.out.println("Previous Page number is:"+previousPageNum);
			
			CommonUtility.ClickOn(driver, obj_SecurityLandingPage.FirstPageArrow());
			
			firstPageNum = CommonUtility.highlightElement(driver, obj_SecurityLandingPage.PageNumberTextbox()).getAttribute("value");

			System.out.println("First Page number is:"+firstPageNum);
			

				Report.put("An user on the SLP page and left-pointing and right-pointing arrows are activated.", 
						"User must see the following : 1. Clicking on the first one (left-facing arrow and vertical bar) should take me to the first page 2. Clicking on the second one (left-facing arrow) should take me to the previous page 3. Clicking on the third one (right-facing arrow) should take me to the next page 4. Clicking on the fourth one (with the arrow and vertical bar) should take me to the last page",
						"User clicked on first arrow and displayed page "+Report.color(nextPageNum)+".Clicking on second one displayed page "+Report.color(lastPageNum)+".User clicked on Previous Page and displayed"+Report.color(previousPageNum)+". User clicked on First Page & displayed "+Report.color(firstPageNum), "PASS");
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("An user on the SLP page and left-pointing and right-pointing arrows are activated.", 
					"User must see the following : 1. Clicking on the first one (left-facing arrow and vertical bar) should take me to the first page 2. Clicking on the second one (left-facing arrow) should take me to the previous page 3. Clicking on the third one (right-facing arrow) should take me to the next page 4. Clicking on the fourth one (with the arrow and vertical bar) should take me to the last page",
					"User is not able to verify next page and last page, first & previous arrows", "FAIL");
			Assert.fail();
		}
	}
	
	public void verifyLeftPointingArrows(WebDriver driver) 
	{
		Log.info("Inside method verifyLeftPointingArrows");
		WebDriverWait  wait = new WebDriverWait(driver, 120);

		String lastPageNum = "";
		
		try
		{
			
			
			CommonUtility.ClickOn(driver, obj_SecurityLandingPage.LastPageArrow());
			lastPageNum = CommonUtility.highlightElement(driver, obj_SecurityLandingPage.PageNumberTextbox()).getAttribute("value");

			System.out.println("Last Page number is:"+lastPageNum);
			
			if(CommonUtility.highlightElement(driver, obj_SecurityLandingPage.PreviousPageArrow()).isEnabled() && CommonUtility.highlightElement(driver, obj_SecurityLandingPage.FirstPageArrow()).isEnabled())
			{		
				System.out.println("Arrows are enabled ");

				Report.put("An user on the SLP page on the last page of articles", 
						"User must see the left-pointing arrows should be activated. ",
						"User is displayed with left-pointing arrows activated", "PASS");
			}
			else
			{
				Report.put("An user on the SLP page on the last page of articles", 
						"User must see the left-pointing arrows should be activated. ",
						"User is not able to verify left-pointing arrows activated", "FAIL");
				Assert.fail();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("An user on the SLP page on the last page of articles", 
					"User must see the left-pointing arrows should be activated. ",
					"User is not able to verify left-pointing arrows activated", "FAIL");
			Assert.fail();
		}
	}
}
