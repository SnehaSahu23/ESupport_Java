package com.dell.delta_uat_automation.esupport.workflows;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
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



public class EsupportCoveoWorkflow extends BaseFlow {
	//Mamta
	ArrayList<String>List_type= new ArrayList<String>();
	//Sudha
	String User1count="";
	String User2count="";
	int count1,count2;
	String[] username=TestNGCreator.TestData.get(Esupport.Username.ordinal()).split(";");   
	String[] password=TestNGCreator.TestData.get(Esupport.Password.ordinal()).split(";");

	public void handleCookies(WebDriver driver)
	{
		System.out.println("Handle Cookies");
		Log.info("Handle Cookies");	
		try{
			WebDriverWait wait = new WebDriverWait(driver,200);
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			//			if(CommonUtility.CheckpresenceofElementLocated(driver, 5, obj_EsupportOrderHomePage.declinecookies()))
			//				CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.declinecookies()).click();  
			//			else 
			if(CommonUtility.CheckpresenceofElementLocated(driver, 10, obj_EsupportOrderHomePage.acceptCookies()))
			{
				//				CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.acceptCookies()).click(); 
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
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

	}  

	public void  validateSupportPage(WebDriver driver) {
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 120);


		System.out.println("Entering validateSupportPage");

		Log.info("Entering validateSupportPage");   
		String supportHeader = "";

		try{
			//wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.delllogo()));
			//CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.delllogo());

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.SupportHeader()));
			CommonUtility.highlightElement(driver, obj_EsupportCoveoPage.SupportHeader());
			supportHeader = CommonUtility.highlightElement(driver, obj_EsupportCoveoPage.SupportHeader()).getText();
			System.out.println("Header is: "+supportHeader);

			Report.put("Open Dell support home page.", 
					"Support home page should get loaded.", 
					"Successfully Navigated to Support HomePage. Header is : "+Report.color(supportHeader), "PASS");

			//Thread.sleep(3000);			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Open Dell support home page.", 
					"Support home page should get loaded. ", 
					"Failed to Navigate to Support HomePage.", "FAIL");
			Assert.fail();
		}
	}

	public void handleCaptcha_Aleinware(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 1200);

		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
		try
		{

			System.out.println("In try block of captcha wait");

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Looking for more Dell EMC content?']")));


		}
		catch(Exception e)
		{
			e.printStackTrace();

			Assert.fail();
		}

	}

	public void handleCaptcha(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 1200);

		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
		try
		{

			System.out.println("In try block of captcha wait");

			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Looking for more Dell EMC content?']")));


		}
		catch(Exception e)
		{
			e.printStackTrace();

			Assert.fail();
		}

	}

	public void  searchServiceTag(WebDriver driver) {
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 120);
		Actions act=new Actions(driver);

		System.out.println("Entering searchServiceTag");

		Log.info("Entering searchServiceTag");   
		String serviceTag = TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal());
		String contentHeader = "";

		try
		{	
			CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.SearchTextbox());
			//			act.moveToElement(CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SearchTextbox())).build().perform();
			if(CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SearchTextbox()).isDisplayed())
			{
				CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.SearchTextbox());
				Log.info("Entering fields in serchtagsss"); 
				CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.SearchTextbox());
				CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SearchTextbox()).sendKeys(serviceTag);
				System.out.println("Service Tag is : "+serviceTag);
				//				CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SearchButton()).click();
				
				if(CommonUtility.CheckpresenceofElementLocated(driver, 20, obj_EsupportCoveoPage.SearchButton2()))
				{
				   CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.SearchButton2());
				   CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.SearchButton2());
				}
				else if(CommonUtility.CheckpresenceofElementLocated(driver, 20, obj_EsupportCoveoPage.SearchButtonMastHead()))
				{
				   CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.SearchButtonMastHead());
				   CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.SearchButtonMastHead());
				}

				//CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SearchTextbox()).sendKeys(Keys.ENTER);
			}
			Thread.sleep(6000);
//			driver.navigate().refresh();
			handleCookies(driver);
			//	handleCaptcha(driver);
			wait.until(ExpectedConditions.presenceOfElementLocated(obj_EsupportCoveoPage.ContentHeader()));
			if(CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ContentHeader()).isDisplayed())
			{
				CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ContentHeader());
				contentHeader = CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ContentHeader()).getText();
				System.out.println("Content Header is : "+contentHeader );
			}


			Report.put(" Enter QNA44328 in Mast head Coveo search Text box and click Search button.", 
					"It should fetch the results", 
					"Result fetched Successfully" +"<br>"+"ServiceTag: "+Report.color(serviceTag)+"<br>" +"Header is: "+Report.color(contentHeader), "PASS");

			//Thread.sleep(3000);			
		}
		catch(Exception e)
		{
			e.printStackTrace();

			Report.put(" Enter Service Tag in Mast head Coveo search Text box and click Search button.", 
					"Not able to fetch the results", 
					"Not able to fetch the results", "FAIL");


			Assert.fail();
		}
	}
	public void  validateHeader(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 120);

		String contentHeader = "";
		try
		{			

			//handleCookies(driver);
			//handleCaptcha(driver);
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.ContentHeader()));
			if(CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ContentHeader()).isDisplayed())
			{
				CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ContentHeader());
				contentHeader = CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ContentHeader()).getText();
				System.out.println("Content Header is : "+contentHeader );
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Open Dell support home page.", 
					"Support home page should get loaded. ", 
					"Failed to Navigate to Support HomePage.", "FAIL");
			Assert.fail();
		}

	}
	public void  changeCountry(WebDriver driver)
	{
		// TODO Auto-generated method stub
		System.out.println("Entering changeCountry");
		Actions act=new Actions(driver);
		Log.info("Entering changeCountry");   
		String country = TestNGCreator.TestData.get(Esupport.Country.ordinal());
		String selectedcountry = "";

		try{

			//			act.moveToElement(CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.CountrySelector())).build().perform();

			CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.CountrySelector());
			if(CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.CountrySelector()).isDisplayed())
			{

				System.out.println("country displayed");

				WebElement element =driver.findElement(By.xpath("//div[@id='countryselector']/a"));
				CommonUtility.ClickOn(driver,By.xpath("//div[@id='countryselector']/a"));
				//				((JavascriptExecutor)driver).executeScript("arguments[0].click();", element); 

				//				CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.CountrySelector());
				//				  Thread.sleep(2000);
				//				CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.CountrySelector()).click();
				//				
				//				Thread.sleep(4000);
				//				CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.CountrySelector()).sendKeys(Keys.ENTER);
				Thread.sleep(6000);
				System.out.println("Country from Test data is :::: "+country);
				List<WebElement> countryList=driver.findElements(obj_EsupportCoveoPage.CountryselectorList());

				for(WebElement lt:countryList)
				{
					String couLi=lt.getText();

					System.out.println("Country is: " +couLi);
					if(couLi.equalsIgnoreCase(country))
					{
						System.out.println("Inside if**************");
						System.out.println("Country is: " +couLi);
						lt.click();

						Thread.sleep(5000);
						handleCookies(driver);

						selectedcountry = couLi;
						System.out.println("Selected Country is "+selectedcountry);
						Report.put(" Change country to CANADA from the country selector or a country which has more than two languages ", 
								"The country should get changed to CANADA or a country selected ", 
								"Country changed to : "+Report.color(country), "PASS");
						break;
					}							
				}
			} 	
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put(" Change country to CANADA from the country selector or a country which has more than two languages ", 
					"The country should get changed to CANADA or a country selected ", 
					"Not able to select the country"+Report.color(country), "FAIL");
			Assert.fail();
		}
	}

	public void  changeLanguage(WebDriver driver)
	{
		// TODO Auto-generated method stub
		System.out.println("Entering changeLanguage");

		Log.info("Entering changeLanguage");   
		String contentHeader = "";
		String languages="";
		String selectedLanguage = "";
		WebDriverWait wait = new WebDriverWait(driver, 120);

		try
		{
			if(CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.LangList()).isDisplayed())
			{                                                        
				List<WebElement> langList=driver.findElements(obj_EsupportCoveoPage.LangList());

				for(WebElement lt:langList)
				{
					CommonUtility.highlightElement(driver, lt);
					String langLi=lt.getText();

					System.out.println("Language is: " +langLi);
					languages+= langLi +"<br>";
				}
				System.out.println("Lanuage list : "+languages);

				if(CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.LangList()).isDisplayed())
				{
					//					CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.FrenchLanguage()).click();
					CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.FrenchLanguage());
					selectedLanguage = CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.FrenchLanguage()).getText();
					System.out.println("Selected language is :"+selectedLanguage);


				}
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.ContentHeader()));
				handleCookies(driver);
				if(CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ContentHeader()).isDisplayed())
				{
					CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ContentHeader());
					contentHeader = CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ContentHeader()).getText();
					System.out.println("Content Header is : "+contentHeader );
				}
				Report.put("Now change the language (other language below country selector) and check the results ", 
						"Results should get refreshed and displayed in the language selected.  ", 
						"Language List: "+Report.color(languages)+"<br>"+"Language Selected :"
								+Report.color(selectedLanguage)+"<br>"+"Header is:"+Report.color(contentHeader), "PASS");

			}
		}             

		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Now change the language (other language below country selector) and check the results ", 
					"Results should get refreshed and displayed in the language selected.  ", 
					"Failed to Change the language", "FAIL");
			Assert.fail();
		}
	}


	public void  clickOnLink(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 120);
		System.out.println("Inside clickOnLink");
		String currentUrl = "";
		String title = "";
		try
		{		
//			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.ResultLink()));
			CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.ResultLink());
			if(CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ResultLink()).isDisplayed())
			{
				//				CommonUtility.scrollToViewElement(driver,obj_EsupportCoveoPage.ResultLink());
				//				CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ResultLink()).click();
				CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.ResultLink());
				//System.out.println("Content Header is : "+contentHeader );
			}
			Set<String> allWH=driver.getWindowHandles(); 
			String currentwindow=driver.getWindowHandle();
			int count=allWH.size(); 
			System.out.println("Switched Window Handles and  window count is :: "+count);

			for(String wh:allWH)
			{

				Thread.sleep(10000);
				driver.switchTo().window(wh); 
				currentUrl=driver.getCurrentUrl();
				title = driver.getTitle();
				if(title.contains("Dell PowerEdge"))
				{

					System.out.println("CurrentUrl is : "+currentUrl); 
					System.out.println("CurrentTitle  is : "+title); 
					Thread.sleep(10000);
					driver.close();
				}
				driver.switchTo().window(currentwindow);

			}

			Thread.sleep(5000);
			if(currentUrl.contains("https"))
			{
				Report.put("Check for HTTPS Link ", 
						"Result Page should navigate to https link. ", 
						"Result link is HTTPS: "+Report.color(currentUrl)+"<br>"+"Title is :"
								+Report.color(title), "PASS");
			}


		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Check for HTTPS Link ", 
					"Result Page should navigate to https link. ", 
					"Result link is HTTPS: "+Report.color(currentUrl)+"<br>"+"Title is :"
							+Report.color(title), "FAIL");
			Assert.fail();
		}

	}


	//Sneha : Nov28 
	public void searchResult(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 200);
//		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);      
		System.out.println("Search Result");
		Log.info("Search Result");    
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try{
			handleCookies(driver);
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.SearchInput()));
			CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.SearchInput());
			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SearchInput()).clear();
			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SearchInput()).sendKeys("search");

			//wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.SearchButton()));
			//			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SearchButton()).click();
			CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.SearchButton2());
			CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.SearchButton2());
			Thread.sleep(10000);
			driver.navigate().refresh();

//			handleCookies(driver);

			Report.put("Go to search integrated page ", "Search integrated page should open", "Search integrated page", "Pass");

			//handleCaptcha(driver);
			Thread.sleep(15000);

			Set<String> wins = driver.getWindowHandles();

			for(String win:wins){
				driver.switchTo().window(win);
			}
			Thread.sleep(6000);
			//wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.SearchSupportTag()));
//			handleCookies(driver);
			CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.numberofResult());
			
			js.executeScript("window.scrollBy(0,250)", "");
			CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.KnowledgeBaseClick());
			if(CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.KnowledgeBaseClick()).isDisplayed()){
				//				CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.KnowledgeBaseClick()).click();
//				CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.KnowledgeBaseClick());
				CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.KnowledgeBaseClick());
				
				CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.KnowledgeBaseClick());
				Thread.sleep(5000);
			}
			
//			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);      
			String url = driver.getCurrentUrl();
			System.out.println("the url is"+url);
			if(url.contains("Knowledgebase")){
				System.out.println("Knowledgebase is coming in url");
				Report.put("Click on knowledgebase content type.  ", "The meta for dell data and emc data will be shown as per the chart in description ", "The meta for dell data and emc data is shown as per the chart in description ", "Pass");
			}
			else
			{
				Report.put("Click on the content type", "The meta for dell data and emc data will be shown as per the chart in description", "The meta for dell data and emc data is not shown as per the chart in description", "Fail");
				Assert.fail();
			}

			if(CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.DownloadDriversClick()).isDisplayed()){
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.DownloadDriversClick()));
				//				CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.DownloadDriversClick()).click();
				CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.DownloadDriversClick());
				CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.DownloadDriversClick());
				Thread.sleep(5000);
			}
			String url1 = driver.getCurrentUrl();
			System.out.println("the url is"+url1);
			if(url1.contains("Drivers")){
				System.out.println("Drivers is coming in url");
				Report.put("Click on drivers and download content type.  ", "The meta for dell data and emc data will be shown as per the chart in description", "The meta for dell data and emc data is shown as per the chart in description", "Pass");
			}
			else{
				Report.put("Click on the content type", "The meta for dell data and emc data will be shown as per the chart in description", "The meta for dell data and emc data is not shown as per the chart in description", "Fail");
				Assert.fail();
			}
			CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.ForumsClick());
			if(CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ForumsClick()).isDisplayed()){
				//				CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ForumsClick()).click();
				CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.ForumsClick());
				Thread.sleep(5000);
			}
			String url2 = driver.getCurrentUrl();
			System.out.println("the url is"+url2);
			if(url2.contains("Forums")){
				System.out.println("forum is coming in url");
				Report.put("Click on Forums content type", "The meta for dell data and emc data will be shown as per the chart in description", "The meta for dell data and emc data is shown as per the chart in description", "Pass");
			}
			else{
				Report.put("Click on the content type", "The meta for dell data and emc data will be shown as per the chart in description", "The meta for dell data and emc data is not shown as per the chart in description", "Fail");
				Assert.fail();
			}
			CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.ManualDocumentationClick());
			if(CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ManualDocumentationClick()).isDisplayed()){
				//				CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ManualDocumentationClick()).click();
				//				CommonUtility.ToClickByUsingJavaScript_PassingByLoc(driver,obj_EsupportCoveoPage.ManualDocumentationClick());
				CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.ManualDocumentationClick());
				Thread.sleep(5000);
			}
			String url3 = driver.getCurrentUrl();
			System.out.println("the url is"+url3);
			if(url3.contains("Manuals")){
				System.out.println("Forums is coming in url");
				Report.put("Click on manuals and documentation content type", "The meta for dell data and emc data will be shown as per the chart in description", "The meta for dell data and emc data is shown as per the chart in description", "Pass");
			}
			else{
				Report.put("Click on the content type", "The meta for dell data and emc data will be shown as per the chart in description", "The meta for dell data and emc data is not shown as per the chart in description", "Fail");
				Assert.fail();
			}


		}
		catch(Exception ex){
			ex.printStackTrace();
			Report.put("Click on the content type", "The meta for dell data and emc data will be shown as per the chart in description", "The meta for dell data and emc data is not shown as per the chart in description", "FAIL");
			Assert.fail();
		}
	}  


	//MAMTA: Nov28
	public void toVerify_MastHead_Search(WebDriver driver)
	{
		Log.info("Verifying Mast Head Search");
		try{
			CommonUtility.CheckpresenceofElementLocated(driver, 10, obj_EsupportCoveoPage.mastHead());
			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.mastHead());        
			//			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.domainSelector()).click(); 
//			CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.domainSelector());
//			List<WebElement> options=driver.findElements(obj_EsupportCoveoPage.domainSelectorList());

			Report.put("Observe Search functionality in Mast Head ", "Mast Head should contain Search box and a Domain Selector drop down", "Mast Head containing a Search box and a Domain Selector drop down", "PASS");

		}
		catch(Exception ex){
			ex.printStackTrace();
			Report.put("Observe Search functionality in Mast Head ", "Mast Head should contain Search box and a Domain Selector drop down", "Mast Head does not contain a Search box and a Domain Selector drop down", "FAIL");
			Assert.fail();
		}
	}  
	public void toVerify_DomainSelector_Dropdown(WebDriver driver)
	{
		Log.info("Verifying Domain Selector Drop down");
		try{
			//			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.domainSelector()).click(); 
			CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.domainSelector());
			List<WebElement> options=driver.findElements(obj_EsupportCoveoPage.domainSelectorList());
			for(WebElement op:options){
				CommonUtility.highlightElement(driver,op);
				System.out.println(List_type);
				List_type.add(op.getText());
			}

			Report.put("Verify the Domain Selector Drop down", "Domain selector dropdown should have 3 options, Support and Dell.com, DellEMC.com ", "Domain selector dropdown having 3 options: "+Report.color(List_type), "PASS");

		}
		catch(Exception ex){
			ex.printStackTrace();
			Report.put("Verify the Domain Selector Drop down", 
					"Failed to selector dropdown should have 3 options, Support and Dell.com, DellEMC.com ", 
					"Failed to selector dropdown should have 3 options, Support and Dell.com, DellEMC.com", "FAIL");


			Assert.fail();
		}
	} 
	public void toVerify_Support_Dropdown(WebDriver driver)
	{
		Log.info("Verifying Support Drop down");
		try{
			//			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.domainSelector()).click(); 
			CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.domainSelector());
			List<WebElement> options=driver.findElements(obj_EsupportCoveoPage.domainSelectorList());
			for(int i=0;i<options.size();)
			{
				options.get(i).getText().equals("Support");
				System.out.println("the first option is support");
				CommonUtility.highlightElement(driver,options.get(i));
				break;
			}

			Report.put("Verify the default option", "'Support' should be the default option", "'Support' is the default option", "PASS");

		}
		catch(Exception ex){
			ex.printStackTrace();
			Report.put("Verify the default option", "'Support' should be the default option", "'Support' is not the default option", "FAIL");
			Assert.fail();
		}
	} 
	public void Select_Search_Values(WebDriver driver, String value , String option)
	{
		WebDriverWait wait = new WebDriverWait(driver,100);
		System.out.println("Entering in method Select_Search_Values");
		Log.info("Entering in method Select_Search_Values");
		String flag="";
		try{
			//			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.domainSelector()));
			//			CommonUtility.scrollToViewElement(driver,obj_EsupportCoveoPage.domainSelector());
			//			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.domainSelector()).click(); 
//			CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.domainSelector());
//			List<WebElement> options=driver.findElements(obj_EsupportCoveoPage.domainSelectorList());
//
//			for(WebElement op:options){
//				CommonUtility.ScrollToWebElement(driver,op);
//				System.out.println(op.getText());
//				if(op.getText().contains(option)){
//					op.click();
//					flag=option;
//					break;
//				}
//			}      
			//			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.mastHead()).click();
			//			CommonUtility.ToClickByUsingJavaScript_PassingByLoc(driver,obj_EsupportCoveoPage.mastHead());
			CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.mastHead());
			CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.mastHead());
			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.mastHead()).clear();
			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.mastHead()).sendKeys(value);
			//			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.mastHead()).sendKeys(Keys.ENTER);
			//			CommonUtility.ToClickByUsingJavaScript_PassingByLoc(driver,obj_EsupportCoveoPage.SearchButton());
			CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.SearchButton2());
			CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.SearchButton2());
			
			Thread.sleep(6000);
			driver.navigate().refresh();
			Thread.sleep(10000);
			if(flag.equals("Support")){
				Report.put("Select 'Support' item and enter some keywords :"+Report.color(value), "Search Should take customer to Coveo search result page", "Customer is in Coveo search result page ", "PASS");
			}else if(flag.equals("Dell.com")){
				Report.put("Select 'Dell.com' item and enter some keywords :"+Report.color(value), "Search Should take customer to unified search result page. The results should be displayed in LIST view. ", "Unified search result page is opened and the results should be displayed in LIST view. ", "PASS");   

			}
		}
		catch(Exception ex){
			ex.printStackTrace();
			Report.put("Select 'Dell.com' item and enter some keywords :"+Report.color(value),
					"Search Should take customer to unified search result page. The results should be displayed in LIST view. ", "Unified search result page is opened and the results should be displayed in LIST view. ", "FAIL");   
			Assert.fail();
		}
	}
	public void SearchValues_CharacterByCharacter(WebDriver driver, String value , String option)
	{
		Log.info("Enter in search method");
		String flag="";
		Actions act = new Actions(driver);
		try{
			//			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.domainSelector()).click(); 
			CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.domainSelector());
			List<WebElement> options=driver.findElements(obj_EsupportCoveoPage.domainSelectorList());

			for(WebElement op:options){
				CommonUtility.highlightElement(driver,op);
				System.out.println(op.getText());
				if(op.getText().contains(option)){
					op.click();
					flag=option;
					break;
				}
			}
			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.mastHead()).clear();
			//			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.mastHead()).click();
			CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.mastHead());
			char[] NameInputArray = value.toCharArray();
			for(int j=0;j<NameInputArray.length;j++)
			{
				driver.findElement(obj_EsupportCoveoPage.mastHead()).sendKeys(String.valueOf(NameInputArray[j]));
				Thread.sleep(2000);
			}
			System.out.println("Value from test data is"+value);
			List<WebElement> charoptions=driver.findElements(By.xpath("//ul/li/a[text()='"+value+"']"));
			System.out.println("the size of avialable options"+charoptions.size());

			for(int i=1;i<=charoptions.size()-1;i++){
				System.out.println("i val---"+i);
				CommonUtility.highlightElement(driver,charoptions.get(i)).isDisplayed();
				if(i==charoptions.size()-1){
					WebElement elmt = driver.findElement(By.xpath("//ul/li/strong[text()='"+value+"']/../../li["+i+"]")); 
					//					act.moveToElement(elmt).click().perform();   
					CommonUtility.ClickOn(driver,By.xpath("//ul/li/strong[text()='"+value+"']/../../li["+i+"]"));
				}
			}
			if(flag.equals("Support")){      
				Report.put("Select 'Support' item and enter 3 Chars :"+Report.color(value), "Auto suggest should show all relevant keywords for those characters from Coveo ", "Auto suggest is displaying should show all relevant keywords for those characters ", "PASS");
			}else if(flag.equals("Dell.com")){     
				Report.put("Select 'All Dell.com' item and enter 3 Chars :"+Report.color(value), "Auto suggest should show all relevant keywords for those characters from Coveo ", "Auto suggest is displaying all relevant keywords", "PASS");
			}else if(flag.equals("DellEMC.com")){  
				Report.put("Select 'All DellEMC.com' item and enter 3 Chars :"+Report.color(value), "Auto suggest should show all relevant keywords for those characters from Coveo ", "Auto suggest is displaying all relevant keywords ", "PASS");
			}
		}      
		catch(Exception ex){
			ex.printStackTrace();
			Report.put("Select '"+flag+"' item and enter some keywords", "Auto suggest should show all relevant keywords for those characters from Unified search ", "Auto suggest is not displaying the relevant keywords for entered characters", "FAIL");
			Assert.fail();
		}
	}

	//Sujata :NOV 28

	public void ToVerify_EnterServiceTage(WebDriver driver,String Servicetag) 
	{
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 120);
		Actions act = new Actions(driver);
		String convertedTag=Servicetag.toUpperCase();
		System.out.println("The converted Service tag is: " + convertedTag);

		System.out.println("Entering ToVerify_ProductSupport");

		Log.info("Entering Esupport Home Page");         
		try 
		{
			String Browseallproductslink="";
			String DetectPCButton="";

			String Headerservicetag="";
			String Headerservicetagdisplay="";

			handleCookies(driver);

			CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.Delllogo());
			CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.SearchServicetag());
			CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.SearchServicetag()).clear();
			CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.SearchServicetag()).sendKeys(Servicetag);
			Thread.sleep(3000);
			CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.SearchServicetag()).sendKeys(Keys.SPACE);
			CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.SearchServicetag()).sendKeys(Keys.BACK_SPACE);

			System.out.println("Entered Product Name");


			Thread.sleep(5000);
			WebElement element =driver.findElement(By.xpath("(//span[@class='ui-state-highlight'])[1]"));
			//			act.moveToElement(element).build().perform();
			//			((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);  
			CommonUtility.ScrollTo(driver,By.xpath("(//span[@class='ui-state-highlight'])[1]"));
			CommonUtility.ClickOn(driver,By.xpath("(//span[@class='ui-state-highlight'])[1]"));


			Report.put("Enter few characters in Product selector search box ", "It should list of all similar products starting with those characters. Incase the user continues entering more characters, it should further refine the result set in the list. as "+Report.color(Servicetag),
					"Not able to find Entered service tag", "PASS");


			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.productPageHeader()));

			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.productPageHeader());
			String  autosugestionproductslist= CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.productPageHeader()).getText();
			Report.put("Select one of the product from the list  ", "It should load the selected "+Report.color(autosugestionproductslist)+" details page",
					"Successfully It should load the selected product details page", "PASS");

			//driver.navigate().back();
			Thread.sleep(5000);

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Select one of the product from the list  ", "Failed to load the selected product details page",
					"Failed to load the selected product details page", "FAIL");
			Assert.fail();

		}

	}

	public void  ClickSignIn(WebDriver driver) 
	{
		System.out.println("ClicKing on Save Button");
		WebDriverWait  wait = new WebDriverWait(driver, 120);
		System.out.println("After webdriver wait");
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
		try
		{

			handleCookies(driver);

			driver.navigate().to("https://www.dell.com/Identity/global/LoginOrRegister/566178c1-e152-4ac5-8539-23efcc474552?redirectUrl=https%3A%2F%2Fwww.dell.com%2Fsupport%2Fhome%2Fus%2Fen%2F19&c=us&l=en&feir=1");
			System.out.println("Clicked on Sign In Button");
			Report.put("Click on SignIn button", "Sign In Page should dispaly", "Application navigated to Sign In page ", "PASS");

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on SignIn button", "Sign In Page should dispaly", "Application is not navigated to Sign In page ", "FAIL");
			Assert.fail();
		}
	}


	public void  EmployeeLogin(WebDriver driver, String name, String pwd) {
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 120);

		//String name = TestNGCreator.TestData.get(Esupport.Username.ordinal()) ;
		//String pwd = TestNGCreator.TestData.get(Esupport.Password.ordinal()) ;
		System.out.println("Entering Login Home Page");


		try{

			handleCookies(driver);

			

			Report.put("Click Sign in here link in Sign-in page ", "It should navigate to page asking for Enter User Name ",
					"Successfully It should navigate to page asking for Enter User Name ", "PASS");

			
			CommonUtility.ClickOn(driver, obj_EsupportIncidentsPage.signInLabelHomepage());

			WebElement ele = driver.findElement(obj_EsupportIncidentsPage.signInButtonHomepage());
			
			CommonUtility.ClickOn(driver, obj_EsupportIncidentsPage.signInButtonHomepage());

			if(CommonUtility.CheckpresenceofElementLocated(driver, 20, obj_EsupportDDLHomePage.Email()))
			{
			   wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.Email()));
			   Thread.sleep(5000);
			   //			CommonUtility.scrollToViewElement(driver, obj_EsupportDDLHomePage.Email());
			   CommonUtility.ScrollTo(driver, obj_EsupportDDLHomePage.Email());
			   CommonUtility.highlightElement(driver, obj_EsupportDDLHomePage.Email()).sendKeys(name);

			   System.out.println("Entered Email(Username) as "+name);

			   //			CommonUtility.scrollToViewElement(driver, obj_EsupportDDLHomePage.Password());
			   CommonUtility.ScrollTo(driver, obj_EsupportDDLHomePage.Password());
			   CommonUtility.highlightElement(driver, obj_EsupportDDLHomePage.Password()).sendKeys(pwd);

			   System.out.println("Entered Password as "+pwd);
			   CommonUtility.highlightElement(driver, obj_EsupportDDLHomePage.SignIn());
			   //			CommonUtility.highlightElement(driver, obj_EsupportDDLHomePage.SignIn()).click();
		    	//			CommonUtility.ToClickByUsingJavaScript_PassingByLoc(driver, obj_EsupportDDLHomePage.SignIn());
			   CommonUtility.ClickOn(driver, obj_EsupportDDLHomePage.SignIn());
		    	System.out.println("Clicked on SignIn Button ");
			}
			else if(CommonUtility.CheckpresenceofElementLocated(driver, alertcount, obj_EsupportDDLHomePage.Email1())) 
			{
				CommonUtility.ScrollTo(driver, obj_EsupportDDLHomePage.Email1());
				CommonUtility.highlightElement(driver, obj_EsupportDDLHomePage.Email1()).sendKeys(name);

				System.out.println("Entered Email(Username) as "+name);

//				CommonUtility.ScrollTo(driver, obj_EsupportDDLHomePage.ContinueButton());
//				CommonUtility.ToClickByUsingJavaScript_PassingByLoc(driver, obj_EsupportDDLHomePage.ContinueButton());
				
				Thread.sleep(10000);
				
				CommonUtility.ScrollTo(driver, obj_EsupportDDLHomePage.Password1());
				CommonUtility.highlightElement(driver, obj_EsupportDDLHomePage.Password1()).sendKeys(pwd);

				System.out.println("Entered Password as "+pwd);
				CommonUtility.highlightElement(driver, obj_EsupportDDLHomePage.SignInButton());
//				CommonUtility.highlightElement(driver, obj_EsupportDDLHomePage.SignIn()).click();
				CommonUtility.ClickOn(driver, obj_EsupportDDLHomePage.SignInButton());
				System.out.println("Clicked on SignIn Button ");
			}
			//			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.delllogo()));


			//			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.SigninhereHeader()));
			//			Thread.sleep(3000);
			//			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SigninUsernameTextbox()).sendKeys(name);

			//			Report.put("Enter EMC User Name "+Report.color(name)+" and click Sign In button  ", "It should navigate to page where user needs to enter password  ",
			//					"Successfully It should navigate to page where user needs to enter password ", "PASS");
			//			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SigninUsernamebutton()).click();
			//
			//			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.SigninhereHeader()));
			//			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SigninPwdtextbox()).sendKeys(pwd);
			//
			//			Report.put("Enter Password "+Report.color(pwd)+" and click Continue button ", "It should login and navigate to home page  ",
			//					"Successfully It should login and navigate to home page  ", "PASS");
			//			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SigninPwdcontinuebutton()).click();

			Report.put("Enter EMC User Name "+Report.color(name)+" and password "+Report.color(pwd)+" click Sign In button  ", "It should be able to login  ",
					"Successfully It should navigate to support home page", "PASS");

		}catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Enter valid credentials", "Not able to find valid credentials ", "Not able to Signin", "Fail");

			Assert.fail();
		}
	}


	public void ToVerify_EnterServiceTagsonly(WebDriver driver,String Servicetag) 
	{
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 120);
		Actions act = new Actions(driver);

		System.out.println("Entering ToVerify_EnterServiceTagsonly");

		Log.info("Entering Esupport Home Page");         
		try 
		{

			handleCookies(driver);

			//CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.Delllogo());
			CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.SearchServicetag());
			CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.SearchServicetag()).clear();
			CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.SearchServicetag()).sendKeys(Servicetag);
			Thread.sleep(10000);
			//			CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.Servicetagiconsearch()).click();
			CommonUtility.ClickOn(driver,obj_EsupportDriversandDownloadsPage.Servicetagiconsearch());
			
			Thread.sleep(6000);
			driver.navigate().refresh();
			Thread.sleep(10000);

			Report.put("Perform search for keyword "+Report.color(Servicetag)+"  ", " It should display the result set",
					"Successfully It should display the result set", "PASS");


		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Not able to find Entered service tag", "Not able to find Entered service tag",
					"Not able to find Entered service tag", "FAIL");
			Assert.fail();

		}

	}

	public void ToVerify_clickDriverDownloads(WebDriver driver) 
	{
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 120);
		Actions act = new Actions(driver);

		System.out.println("Entering ToVerify_clickDriverDownloads");


		try 
		{

			handleCookies(driver);

			//CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.Delllogo());

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.SearchSupportTag()));
			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SearchSupportTag());

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.DriversDownloadsradiobuttonclick()));
			if(CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.DriversDownloadsradiobuttonclick()).isDisplayed())
			{
				act.moveToElement(CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.DriversDownloadsradiobuttonclick())).build().perform();
				//				CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.DriversDownloadsHeader()).click();
				CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.DownloadDriversClick());
				CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.DownloadDriversClick());
				Report.put("From the Facet select 'Drivers & Downloads' option", " It should show all the links to download the Drivers or Content",
						"Successfully It should show all the links to download the Drivers or Content", "PASS");

				System.out.println("Clicked radio button");
			}


			Thread.sleep(6000);
			CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.ClickingonMoreinDownloads());
			String ClickingonMoreinDownloads=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ClickingonMoreinDownloads()).getText();
			//			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ClickingonMoreinDownloads()).click();
			CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.ClickingonMoreinDownloads());


			Thread.sleep(1000);



//			CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.ChecksumLink());
//
//			String ChecksumLink=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ChecksumLink()).getText();
//
//			Report.put("In the result set, for the link with DOWNLOAD icon, click on "+Report.color(ClickingonMoreinDownloads), " It should show the "+Report.color(ChecksumLink)+" link ",
//					"Successfully It should show the CHECKSUM link ", "PASS");
//
//			//			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ChecksumLink()).click();
//			CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.ChecksumLink());
//
//			Thread.sleep(3000);
//
//
//			if(CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ChecksumLinkPopupheader()).isDisplayed())
//			{
//
//				CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.ChecksumLinkPopupheader());
//				String ChecksumLinkPopupheader=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ChecksumLinkPopupheader()).getText();
//
//				Report.put("Click on CHECKSUM link" , " It will show the CheckSum value in the "+Report.color(ChecksumLinkPopupheader)+" popup and Popup should be able to close ",
//						"Successfully It will show the CheckSum value in the Checksum popup and Popup should be able to close   ", "PASS");
//
//				//				CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ChecksumLinkPopupheaderClose()).click();
//				CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.ChecksumLinkPopupheaderClose());
//
//
//			}


		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on CHECKSUM link" , " It is not able to  show the CheckSum value in the Checksumvalue popup and Popup should be able to close ",
					"It is not able to  show the CheckSum value in the Checksumvalue popup and Popup should be able to close   ", "FAIL");
			Assert.fail();

		}

	}

	//Sudha: Nov 28
	public void Emaillogin(WebDriver driver,String name,String pwd ) {
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 120);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		boolean exists = true;

		System.out.println("Entering in Emaillogin");
		//String name = TestNGCreator.TestData.get(Esupport.Username.ordinal()) ;
		//   String pwd = TestNGCreator.TestData.get(Esupport.Password.ordinal()) ;
		System.out.println("Entering Email Login Home Page");

		Log.info("Entering Email Login Home Page");             
		try {


			System.out.println(name);
			System.out.println(pwd);

			driver.navigate().to("https://www.dell.com/Identity/global/LoginOrRegister/566178c1-e152-4ac5-8539-23efcc474552?redirectUrl=https%3A%2F%2Fwww.dell.com%2Fsupport%2Fhome%2Fus%2Fen%2F19&c=us&l=en&feir=1");
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.emailUsername()));
			CommonUtility.highlightElement(driver,(obj_EsupportCoveoPage.emailUsername())).clear();
			CommonUtility.highlightElement(driver,(obj_EsupportCoveoPage.emailUsername())).sendKeys(name);

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.emailPassword()));

			CommonUtility.highlightElement(driver,(obj_EsupportCoveoPage.emailPassword())).clear();
			CommonUtility.highlightElement(driver,(obj_EsupportCoveoPage.emailPassword())).sendKeys(pwd);



			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.emailSignin()));
			//			CommonUtility.highlightElement(driver,(obj_EsupportCoveoPage.emailSignin())).click();
			CommonUtility.ClickOn(driver,(obj_EsupportCoveoPage.emailSignin()));

			Report.put("Login with Credentials for"+Report.color(name), "User should be able to login without any issues" ,
					"User logged in successfully.", "PASS");




		}

		catch (Exception e) {
			Log.info(e);
			Report.put("Login with Credentials", "User should be able to login without any issues",
					"Failed while logging into esupport application", "FAIL");
			e.printStackTrace();
			Assert.fail();
		}               
	}
	public void toVerify_CountofResults(WebDriver driver)
	{

		System.out.println("Verify the count of Results");
		Log.info("Verify the count of Results");
		try{
			WebDriverWait wait = new WebDriverWait(driver, 100);
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			//String Username=driver.findElement(By.xpath("//span[@id='user_name']")).getText(); //span[@id='um-si-label']
			String Username=driver.findElement(By.xpath("//span[@id='um-si-label']")).getText();
			Username=Username.toLowerCase();
			System.out.println(Username);
			System.out.println(User1count);
			if(username[0].contains(Username))
			{
				CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.numberofResult());
				User1count=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.numberofResult()).getText();
				//count1 = Integer.valueOf(User1count);
				String us1= User1count.replace(",", "");

				System.out.println(us1);

				count1=Integer.parseInt(us1);



			}else if(username[1].contains(Username))
			{
				User2count=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.numberofResult()).getText();
				String us2= User2count.replace(",", "");

				count1=Integer.parseInt(us2);	



			}
		}
		catch(Exception e){

			Log.info(e);

			e.printStackTrace();
			Assert.fail();
		}
	}
	public void toVerify_CountofResults_Comparision(WebDriver driver)
	{ 


		System.out.println("Verify the count of Results");
		Log.info("Verify the count of Results");
		try{
			wait = new WebDriverWait(driver, 50);
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			//String Username=driver.findElement(By.xpath("//span[@id='user_name']")).getText();
			String Username=driver.findElement(By.xpath("//span[@id='um-si-label']")).getText();
			System.out.println(Username);
			System.out.println(User1count);
			if(count1>count2)
			{
				System.out.println(count1);
			}

			else
			{
				System.out.println(count2);
			}


			Report.put("Now compare the records fetched from Access Level 40 &50","The number of records fetched for Access Level 50 should be more than Access Level 40. All records that appeared or has Access Level 40 , Access Level 30, Access Level 20, Access Level 10 also should appear for user having Access Level 50.",
					"The number of records fetched for Access Level 50 is more than Access Level 40", "PASS");

		}catch(Exception e){

			Log.info(e);
			Report.put("Now compare the records fetched from Access Level 40 &50","The number of records fetched for Access Level 50 should be more than Access Level 40. All records that appeared or has Access Level 40 , Access Level 30, Access Level 20, Access Level 10 also should appear for user having Access Level 50.",
					"The number of records fetched for Access Level 50 is not more than Access Level 40", "FAIL");

			e.printStackTrace();
			Assert.fail();
		}

	}

	public void Logout(WebDriver driver)

	{

		System.out.println("Entering Logout");
		Log.info("Entering Logout");
		try{
			//driver.close();
			//driver.navigate().back();
			//			handleCookies(driver);
			//			((JavascriptExecutor)driver).executeScript("scroll(0, 200)"); 
			//			WebElement element = driver.findElement(obj_EsupportIncidentsPage.signInLabelHomepage());
			//			Actions actions = new Actions(driver);
			//			actions.moveToElement(element).click().perform();

			//			CommonUtility.scrollToViewElement(driver, obj_EsupportIncidentsPage.signInLabelHomepage());
			CommonUtility.ScrollTo(driver, obj_EsupportIncidentsPage.signInLabelHomepage());
			CommonUtility.highlightElement(driver, obj_EsupportIncidentsPage.signInLabelHomepage());

			//			CommonUtility.ToClickByUsingJavaScript_PassingByLoc(driver, obj_EsupportIncidentsPage.signInLabelHomepage());
			CommonUtility.ClickOn(driver, obj_EsupportIncidentsPage.signInLabelHomepage());

			wait = new WebDriverWait(driver, 50);
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);


			WebElement ele = driver.findElement(obj_EsupportCoveoPage.signOut());
			//			CommonUtility.ToClickByUsingJavaScript(driver, ele);
			CommonUtility.ClickOn(driver, obj_EsupportCoveoPage.signOut());

			Report.put("Log out from the current user", "User should be able to logout form esuuport application",
					"Logged Out Successfully", "PASS");


			//			handleCookies(driver);
		}
		catch(Exception e){
			Log.info(e);
			Report.put("Log out from the current user", "User should be able to logout form esupport application",
					"Failed while logging out esupport application", "FAIL");
			e.printStackTrace();
			Assert.fail();

		}

	}

	public void Search_Values_7digitEntries(WebDriver driver, String value , String option)
	{
		WebDriverWait wait = new WebDriverWait(driver,50);
		Log.info("Enter in search");
		String flag="";
		try{
			handleCookies(driver);
//			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.domainSelector()));
//			//			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.domainSelector()).click(); 
//			CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.domainSelector());
//			CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.domainSelector());
//			List<WebElement> options=driver.findElements(obj_EsupportCoveoPage.domainSelectorList());
//
//			for(WebElement op:options){
//				CommonUtility.highlightElement(driver,op);
//				System.out.println(op.getText());
//				if(op.getText().contains(option)){
//					CommonUtility.ClickOnWebElement(driver,op);
//					flag=option;
//					break;
//				}
//			}   

			//			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.mastHead()).click();
			CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.mastHead());
			CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.mastHead());
			//			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.mastHead()).clear();
			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.mastHead()).clear();
			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.mastHead()).sendKeys(value);
//			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.mastHead()).sendKeys(Keys.ENTER);
			CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.SearchButton2());
			CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.SearchButton2());
			
			if(flag.equals("Support")){

			}else if(flag.equals("Dell.com")){

			}
		}
		catch(Exception ex){
			ex.printStackTrace();
			//Report.put("Select '"+flag+"' item and enter some keywords", "Search Should take customer to Coveo search result page", "Coveo search result page s not opened", "FAIL");
			Assert.fail();
		}
	}

	public void toVerify_CoveoResults_7digitEntries(WebDriver driver,String scanario)
	{ 


		System.out.println("Verify the toVerify_CoveoResults_7digitEntries Results");
		Log.info("Verify the toVerify_CoveoResults_7digitEntries Results");
		try{
			WebDriverWait wait = new WebDriverWait(driver, 120);
//			driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
			//	handleCaptcha(driver);
			//			handleCookies(driver);
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.Servicetagheaderdisplayed()));
			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.Servicetagheaderdisplayed());
			CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.Servicetag());
			String ServiceTag=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.Servicetag()).getText();
			System.out.println(ServiceTag);

			CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.Diagnostics());

			System.out.println("Type="+scanario);
			if (scanario.contentEquals("1"))
			{
				Report.put("Both 7 digit alphanumeric service tag exist and 7 digit alphanumeric LEMC Serial Number exists.","It  should display the both Service Tag:"+Report.color(ServiceTag)+ "& LEMC results.", "Displayed both service tag & LEMC results.", "PASS");
			}else if(scanario.contentEquals("2"))
				Report.put("7 digit alphanumeric service tag does not exist and 7 digit alphanumeric LEMC Serial Number exist.","It  should display the both Service Tag:" +Report.color(ServiceTag)+ " & LEMC results.", "Displayed both service tag & LEMC results.", "PASS");
			//else if(scanario.contentEquals("2"))
			//	Report.put("7 digit alphanumeric service tag exist and 7 digit alphanumeric LEMC Serial Number does not exist.","It  should display the both" +Report.color(ServiceTag)+ " & LEMC results.", "Displayed both service tag & LEMC results.", "PASS");
			else if(scanario.contentEquals("3"))
				Report.put("7 digit alphanumeric service tag exist and 7 digit alphanumeric LEMC Serial Number does not exist.","It  should display the both Service Tag:" +Report.color(ServiceTag)+ " & LEMC results.", "Displayed both service tag & LEMC results.", "PASS");
		}catch(Exception e){

			Log.info(e);
			Report.put("7 digit alphanumeric service tag does not exist and 7 digit alphanumeric LEMC Serial Number exist.","It  should display the both service tag & LEMC results.", "Not displaying service tag & LEMC results.", "FAIL");

			e.printStackTrace();
			Assert.fail();
		}

	}

	public void toVerify_ArticleID(WebDriver driver) 
	{
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 120);
		Actions act = new Actions(driver);

		System.out.println("Entering ToVerify_ArticleId");


		try 
		{

			handleCookies(driver);

			//CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.Delllogo());

//			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.SearchSupportTag()));
			CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.SearchSupportTag());
						handleCookies(driver);
			CommonUtility.ScrollTo(driver, obj_EsupportCoveoPage.KnowledgeBaseClick());
			if(CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.KnowledgeBaseClick()).isDisplayed())
			{
				//				act.moveToElement(CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.knowledgebaseClick())).build().perform();

				Thread.sleep(3000);
				WebElement ele = driver.findElement(obj_EsupportCoveoPage.KnowledgeBaseClick());
				//				CommonUtility.ToClickByUsingJavaScript(driver, ele);
				CommonUtility.ScrollTo(driver, obj_EsupportCoveoPage.KnowledgeBaseClick());
				CommonUtility.ClickOn(driver, obj_EsupportCoveoPage.KnowledgeBaseClick());
				//CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.knowledgebaseHeader()).click();

				Report.put("From the Face select 'knowledge base' option", " It should show all the links to knowledge base Content",
						"Successfully It should show all the links to download the Drivers or Content", "PASS");

				System.out.println("Clicked radio button");
			}





			Thread.sleep(3000);



			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.articleId());

			String ArticleID=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.articleId()).getText();
			System.out.println(ArticleID);



			Thread.sleep(3000);
			CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.mastHead());
			//			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.mastHead()).click();
			CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.mastHead());
			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.mastHead()).clear();
			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.mastHead()).sendKeys(ArticleID);
			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.mastHead()).sendKeys(Keys.ENTER);

			Thread.sleep(3000);
//			WebElement ele = driver.findElement(obj_EsupportCoveoPage.articleLink());
			//			CommonUtility.ToClickByUsingJavaScript(driver, ele);
			CommonUtility.ScrollTo(driver, obj_EsupportCoveoPage.articleLink());
			CommonUtility.ToClickByUsingJavaScript_PassingByLoc(driver, obj_EsupportCoveoPage.articleLink());
			//CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.articleLink()).click();

			Set<String> allWH=driver.getWindowHandles(); 
			String currentwindow=driver.getWindowHandle();
			int count=allWH.size(); 
			System.out.println("Switched Window Handles and  window count is :: "+count);

			for(String wh:allWH)
			{

				Thread.sleep(10000);
				driver.switchTo().window(wh); 
				String title=driver.getTitle();
				System.out.println("Tittle displayed as   ;;;;;;;;:::::"+title); 



				if(title.contains("latitude-3450-no-video-sleep-behavior"))
				{

					// Actions actn=new Actions(driver);
					System.out.println("Switched to window");


					handleCookies(driver);
					CommonUtility.highlightElement(driver, obj_EsupportCoveoPage.articleHeader());

					Report.put("Click on the Article URL link" , "Based on the access level given to the logged in User, the Article ID should open.",
							"Successfully It will show the Article ID ", "PASS");

					//CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ChecksumLinkPopupheaderClose()).click();


				}


			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on the Article URL link" , "Failed to click Article URL",
					"Failed to click Article URL ", "FAIL");

			Assert.fail();

		}

	}

	//Sneha:Nov30/2018

	public void Show_ProductCategory(WebDriver driver)
	{


		Log.info("Verifying ProductCategory");
		try{
			handleCookies(driver);
			WebDriverWait wait = new WebDriverWait(driver, 120);
//			driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS); 
			CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.SearchInput());
			CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.SearchInput());
			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SearchInput()).clear();
			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SearchInput()).sendKeys("search");

			//wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.SearchButton()));
			//			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SearchButton()).click();
		//	CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.SearchButtonMastHead());
			CommonUtility.ToClickByUsingJavaScript_PassingByLoc(driver,obj_EsupportCoveoPage.SearchButton2());
			Thread.sleep(6000);
			
			driver.navigate().refresh();
			Thread.sleep(10000);
			Report.put("Go to search integrated page ", "Search integrated page should open", "Search integrated page", "Pass");


			//handleCaptcha(driver);
			//			Thread.sleep(15000);
			//			Set<String> wins = driver.getWindowHandles();
			//
			//			for(String win:wins){
			//				driver.switchTo().window(win);
			//			}
			//handleCookies(driver);

			driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
			//			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.SearchSupportTag()));
			if(CommonUtility.CheckpresenceofElementLocated(driver,50,obj_EsupportCoveoPage.SearchSupportTag()))
			{

			}
			if(CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.DownloadDriversClick()).isDisplayed())
			{
				//CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ManualDocumentationClick()).click();
				//				CommonUtility.ClickOn(driver, obj_EsupportCoveoPage.ManualDocumentationClick());
				CommonUtility.ClickOn(driver, obj_EsupportCoveoPage.DownloadDriversClick());
			}
			
			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ProductCategory());
//			wait = new WebDriverWait(driver, 60);
//			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
//			Thread.sleep(5000);
//			//	handleCookies(driver);
//			if(CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ProductCategory()).isDisplayed())
//			{
//				//				CommonUtility.scrollToViewElement(driver,obj_EsupportCoveoPage.Laptops1());
//				//				CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.Laptops1()).click();
//				CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.Laptops1());
//			}
//			Thread.sleep(5000);
//			if(CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ProductFamily()).isDisplayed())
//			{
//				//				CommonUtility.scrollToViewElement(driver,obj_EsupportCoveoPage.Inspiron());
//				//				CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.Inspiron()).click();
//				CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.Inspiron());
//			}
//			Thread.sleep(10000);
//			if(CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ProductModel()).isDisplayed()){
//				//				CommonUtility.scrollToViewElement(driver,obj_EsupportCoveoPage.InpironModel());
//				//				CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.InpironModel()).click();
//				CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.InpironModel());
//			}
//
//
//			Report.put("When clicking on any of the content type facet except Support by Topic, show product categories which would have both Dell and Dell EMC products in below levels ", 
//					"When clicking on any of the content type facet except Support by Topic, show product categories which would have both Dell and Dell EMC products", "When clicking on any of the content type facet except Support by Topic,product categories are seen which would have both Dell and Dell EMC products","Pass");

		}
		catch(Exception ex){
			ex.printStackTrace();
			Report.put("When clicking on any of the content type facet except Support by Topic, show product categories which would have both Dell and Dell EMC products in below levels ", 
					"When clicking on any of the content type facet except Support by Topic, show product categories which would have both Dell and Dell EMC products in below levels.", "When clicking on any of the content type facet except Support by Topic,product categories are not seen which would have both Dell and Dell EMC products.","Fail");
			Assert.fail();
		}
	} 


	public void SupportCheck(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 100);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);    
		Log.info("Verifying SupportCheck");
		try{

			Thread.sleep(5000);
			//			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.Clear()).click(); 
			CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.Clear());
			CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.Clear());
			Thread.sleep(5000);
			if(CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.EnglishLanguage()).isDisplayed()){
				//				CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.EnglishLanguage()).click();
				CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.EnglishLanguage());
				CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.EnglishLanguage());
			}
			wait = new WebDriverWait(driver, 60);
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			Thread.sleep(5000);
			Report.put("Click on Support by Topic option in the Content Type section on left nav bar ", "Product category shouldn’t be shown when clicked on Support by Topic", "Product category is not shown while only language and last updatedare shown when clicked on Support by Topic", "PASS");
		}
		catch(Exception ex){
			ex.printStackTrace();
			Report.put("Click on Support by Topic option in the Content Type section on left nav bar ", "Product category shouldn’t be shown when clicked on Support by Topic", "Product category is shown when clicked on Support by Topic", "FAIL");
			Assert.fail();
		}
	} 
	public void change_Language(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 100);
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);    
		Log.info("Inside change_Language");
		try{


			//			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.Clear()).click();  
			CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.Clear());
			CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.Clear());
			Thread.sleep(5000);
			if(CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.EnglishLanguage()).isDisplayed()){
				//				CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.EnglishLanguage()).click();
				CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.EnglishLanguage());
				CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.EnglishLanguage());
			}
			try
			{
			String Lng=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.EnglishFilter()).getText();
			if(Lng.equals("English"))
			{
				Report.put("Change the language by clicking any particular language link", "Clicking on any language should show the content in that language. ", "Clicking on any language shows the content in that language.","PASS");
			}
			else{
				Report.put("Change the language by clicking any particular language link", "Clicking on any language should show the content in that language. ", "Clicking on any language do not show the content in that language.","Fail");
				Assert.fail();

			}
			}
			catch(Exception e)
			{
				
			}

		}
		catch(Exception ex){
			ex.printStackTrace();
			Report.put("Change the language by clicking any particular language link", "Clicking on any language should show the content in that language. ", "Clicking on any language do not show the content in that language.","Fail");
			Assert.fail();
		}
	} 

	public void check_dates(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 100);
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);    
		Log.info("Verifying check_dates");
		String ContentCount;

		try{
			Thread.sleep(5000);

			//			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.Clear()).click();  
			CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.Clear());
			CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.Clear());
			Thread.sleep(5000);
			CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.AllDates());
			if(CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.AllDates()).isDisplayed()){
				//				CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.AllDates()).click();
				CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.AllDates());
				CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.AllDates());
			}

			Thread.sleep(5000);
			ContentCount=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ContentCount()).getText();
			String AllDatesCount=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.AllDatesCount()).getText();
			//if(AllDatesCount.equals(ContentCount))
			//{
			Report.put("Click on All Dates in the Last Updated section on left nav bar ", "Clicking on All Dates will show all old and new contents ", "Clicking on All Dates shows all old and new contents","PASS");
			//}
			//			else
			//			{
			//				Report.put("Click on All Dates in the Last Updated section on left nav bar ", "Clicking on All Dates will show all old and new contents ", "Clicking on All Dates do not show all old and new contents","Fail");
			//				Assert.fail();
			//			}
			if(CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.AllDates()).isDisplayed()){
				//				CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.AllDates()).click();
				CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.AllDates());
				CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.AllDates());
			}
			Thread.sleep(5000);
			//added below as part of 0403 2020
			CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.ClearFilters());
			CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.ClearFilters());
			Thread.sleep(5000);
			if(CommonUtility.CheckpresenceofElementLocated(driver,10,obj_EsupportCoveoPage.WithinLastWeek()))
			{
				//				CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.WithinLastWeek()).click();
				CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.WithinLastWeek());
				CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.WithinLastWeek());

				Thread.sleep(5000);
				ContentCount=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ContentCount()).getText();
				String WithinLastWeekCount=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.WithinLastWeekCount()).getText();
				//			if(WithinLastWeekCount.equals(ContentCount))
				//			{
				Report.put("Click on Within Last Week in the Last Updated section on left nav bar ", "Clicking on Within last week will show all contents been added / modified within last week","Clicking on Within last week will show all contents been added / modified within last week","PASS");
				//			}
				//			else
				//			{
				//				Report.put("Click on Within Last Week in the Last Updated section on left nav bar ", "Clicking on Within last week will show all contents been added / modified within last week", "Clicking on Within last week will not show all contents been added / modified within last week","Fail");
				//				Assert.fail();
				//			}
			}
			if(CommonUtility.CheckpresenceofElementLocated(driver,10,obj_EsupportCoveoPage.WithinLastMonth()))
			{
				//				CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.WithinLastMonth()).click();
				CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.WithinLastMonth());
				CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.WithinLastMonth());

				Thread.sleep(5000);
				ContentCount=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ContentCount()).getText();
				String WithinLastMonthCount=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.WithinLastMonthCount()).getText();
				//			if(WithinLastMonthCount.equals(ContentCount))
				//			{
				Report.put("Click on Within Last Month in the Last Updated section on left nav bar ", "Clicking on within last month will show all contents been added / modified within last month ", "Clicking on within last month will show all contents been added / modified within last month ","PASS");
				//			}
				//			else
				//			{
				//				Report.put("Click on Within Last Month in the Last Updated section on left nav bar ", "Clicking on within last month will show all contents been added / modified within last month ", "Clicking on within last month will not  show all contents been added / modified within last month ","Fail");
				//				Assert.fail();
				//			}
			}
			if(CommonUtility.CheckpresenceofElementLocated(driver,10,obj_EsupportCoveoPage.WithinLastYear()))
			{
				Thread.sleep(5000);
				CommonUtility.ScrollTo(driver, obj_EsupportCoveoPage.WithinLastYear());
				CommonUtility.ClickOn(driver, obj_EsupportCoveoPage.WithinLastYear());
				//CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.WithinLastYear()).click();

				Thread.sleep(5000);
				ContentCount=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ContentCount()).getText();
				String WithinLastYearCount=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.WithinLastYearCount()).getText();
				//			if(WithinLastYearCount.equals(ContentCount))
				//			{
				Report.put("Click on Within Last Year in the Last Updated section on left nav bar ", "Clicking on within last year will show all contents been added / modified within last year", "Clicking on within last year will show all contents been added / modified within last year","PASS");
				//			}
				//			else
				//			{
				//				Report.put("Click on Within Last Year in the Last Updated section on left nav bar ", "Failed by Clicking on within last year will show all contents been added / modified within last year ", "Failed by Clicking on within last year will show all contents been added / modified within last year","Fail");
				//				Assert.fail();
				//			}


			}

		}
		catch(Exception ex){
			ex.printStackTrace();
			Report.put("Click on any tab in the Last Updated section on left nav bar ", "Failed by Clicking on that tab will show all old and new contents", "Failed by Clicking on any language do not show the content in that language.","Fail");
			Assert.fail();
		}
	} 
	//Sujatha:30nov2018
	public void searchResultfornosound(WebDriver driver , String Searchvalue )
	{
		WebDriverWait wait = new WebDriverWait(driver, 200);
//		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);      
		System.out.println("Entering method searchResultfornosound");
		Log.info("Search Result");    
		Actions act=new Actions(driver);
		try{

			handleCookies(driver);

			//CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.Delllogo());

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.SearchInput()));
			CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.SearchInput());
			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SearchInput()).clear();
			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SearchInput()).sendKeys(Searchvalue);

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.SearchButton()));
			//			CommonUtility.scrollToViewElement(driver,obj_EsupportCoveoPage.ViewAllResultsFromMastHeasdSearch());
			//			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ViewAllResultsFromMastHeasdSearch()).click();

			//			CommonUtility.scrollToViewElement(driver,obj_EsupportCoveoPage.SearchButton());
			//			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SearchButton()).click();
			//			CommonUtility.ToClickByUsingJavaScript_PassingByLoc(driver,obj_EsupportCoveoPage.SearchButton());
			//			act.moveToElement(CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SearchButton())).click().build().perform();

			WebElement element = driver.findElement(obj_EsupportCoveoPage.SearchButton2());
			//			((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);
			CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.SearchButton2());
			CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.SearchButton2());

			//			Thread.sleep(7000);

			//			String url=driver.getCurrentUrl();
			//			
			//			driver.get(url);
			Thread.sleep(6000);
			driver.navigate().refresh();
			Thread.sleep(10000);

			Report.put("Go to search integrated page ", "Search integrated page should open", "Search integrated page", "PASS");


			//	handleCaptcha(driver);

			Report.put(" Perform Search for '"+Report.color(Searchvalue)+"' ", "The results should get loaded", "Successfully The results should get loaded", "PASS");

		}
		catch(Exception e){
			Log.info(e);
			Report.put(" Perform Search for '"+Report.color(Searchvalue)+"' ", "The results not get loaded", "The results not get loaded", "FAIL");
			e.printStackTrace();
			Assert.fail();

		}
	}



	public void ToVerify_clickKnowledgebase(WebDriver driver) 
	{
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 200);
		Actions act = new Actions(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
//		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		System.out.println("Entering ToVerify_clickKnowledgebase");


		try 
		{

			//			handleCookies(driver);

			//CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.Delllogo());
			Thread.sleep(10000);
			//wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.SearchSupportTag()));
			//			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SearchSupportTag());
			Thread.sleep(6000);
			CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.XbuttonOnSignInBanner());
			CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.XbuttonOnSignInBanner());
			
			CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.numberofResult());
			js.executeScript("window.scrollBy(0,250)", "");
			if(CommonUtility.CheckpresenceofElementLocated(driver,10,obj_EsupportCoveoPage.Knowledgebaseradiobuttonclick()))
			{
				//				act.moveToElement(CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.Knowledgebaseradiobuttonclick())).build().perform();
				CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.Knowledgebaseradiobuttonclick());
				//				CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.Knowledgebaseheader()).click();
				CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.Knowledgebaseradiobuttonclick());
				Report.put("Click on Knowledgebase ", " User is able to click on Knowledgebase Facet ", 
						"Successfully User is able to click on Knowledgebase Facet","PASS");

				System.out.println("Clicked Knowledgebase radio button");
			}

			Thread.sleep(3000);

			String ltMessages="";
			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.NavigationHeader());

			List<WebElement> list=driver.findElements(obj_EsupportCoveoPage.NavigationHeader());

			for(WebElement lt:list)
			{
				CommonUtility.highlightElement(driver, lt);
				String names=lt.getText();
				if(!(names.equals(""))){

					System.out.println("Alert Name is: " +names);
					ltMessages+=" <br> " + names;
				}

			}

			Report.put("Now select or modify the criteria from the "+ Report.color(ltMessages)+ "  from left nav bar. ", "Based on the selection of the criteria from the Facet, the Filter should get displayed for even Intergrated page. The Filteration should appear same across all search result pages. ", 
					"Successfully Based on the selection of the criteria from the Facet, the Filter should get displayed for even Intergrated page. The Filteration should appear same across all search result pages. ", "PASS");


			//CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SearchSupportTag());
			handleCookies(driver);

			if(CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.Withinlastyearradioclick()).isDisplayed())
			{
				CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.countryselectorList());
				//				act.moveToElement(CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.Withinlastyearradioclick())).build().perform();
				CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.Withinlastyearradioclick());
				//				CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.WithinlastyearText()).click();
				CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.WithinlastyearText());
				Report.put("Click on Within last year ", " User is able to click on Within last year Facet ", 
						"Successfully User is able to click on Within last year Facet","PASS");


				System.out.println("Clicked on Withinlastyear radio button");
			}

			Thread.sleep(3000);

		}
		catch(Exception e){
			Log.info(e);


			Report.put("click on Knowledge base radio button", "User is not able to click on Knowledgebase radio button",
					"User is not able to click on Knowledgebase radio button", "FAIL");


			e.printStackTrace();
			Assert.fail();

		}
	}


	public void ToVerify_YourFilters(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 600);
		Actions act=new Actions(driver);
		driver.manage().timeouts().implicitlyWait(600, TimeUnit.SECONDS);      
		System.out.println("In Function ToVerify_YourFilters");
		Log.info("In Function ToVerify_YourFilters");    
		try{


			Thread.sleep(5000);
			//			act.moveToElement(CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.YourFiltersHeaders())).build().perform();

			CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.YourFiltersHeaders());

			String ltMessages="";


			List<WebElement> list=driver.findElements(obj_EsupportCoveoPage.YourFiltersHeaders());

			for(WebElement lt:list)
			{
				CommonUtility.ScrollToWebElement(driver, lt);
				String names=lt.getText();

				System.out.println("Alert Name is: " +names);
				ltMessages+=" <br> " + names;


			}


			Report.put("Select or modify the criteria from the Category, Language, Content Type, Last Updated sections from left nav bar. ", "Based on the selection of the criteria from the Facet, the Filter should get displayed for even Intergrated page. The Filteration should appear same across all search result pages. as " +Report.color(ltMessages), "Successfully Your filters are displayed", "PASS");

		}
		catch(Exception e){
			Log.info(e);

			Report.put("Select or modify the criteria from the Category, Language, Content Type, Last Updated sections from left nav bar. ", 
					"Failed by the selection of the criteria from the Facet, the Filter should get displayed for even Intergrated page. The Filteration should appear same across all search result pages. " ,
					"Failed by the filters are displayed", "FAIL");

			e.printStackTrace();
			Assert.fail();

		}
	}


	public void ToVerify_Paginationvalues(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 100);
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);      
		System.out.println("In Function ToVerify_Paginationvalues");
		Log.info("In Function ToVerify_Paginationvalues");    
		try{

			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ResultPerPage());


			String ltMessages="";


			List<WebElement> list=driver.findElements(obj_EsupportCoveoPage.ResultPerPage());

			for(WebElement lt:list)
			{
				CommonUtility.highlightElement(driver, lt);
				String names=lt.getText();

				System.out.println("Alert Name is: " +names);
				ltMessages+=" <br> " + names;


			}
			String newten="";

			if(CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.Bydeafaultselectionten()).isDisplayed())
			{
				System.out.println("entering isselected if statement  in to selected 10");

				CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.Bydeafaultselectionten());
				newten=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.Bydeafaultselectionten()).getText();

			}




			Report.put("The number of searches can be "+Report.color(ltMessages)+" The default value should be "+Report.color(newten), 
					" The number of results displayed should vary based on the Value set. The results set shouldn’t change. ",
					"Successfully The number of results displayed should vary based on the Value set. The results set shouldn’t change. ", "PASS");



		}
		catch(Exception e){
			Log.info(e);

			e.printStackTrace();

			Report.put("The number of results displayed should vary based on the Value set ", 
					" The number of results displayed should not vary based on the Value set. The results set should changed. ",
					"The number of results displayed should not vary based on the Value set. The results set should changed. ", "FAIL");

			Assert.fail();

		}
	}

	//yet to add
	public void ToVerify_PaginationvaluesPerPage(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 100);
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);      
		System.out.println("In Function ToVerify_PaginationvaluesPerPage");
		Log.info("In Function ToVerify_PaginationvaluesPerPage");    
		try{


			String newone="";

			if(CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.Bydeafaultselectionperpageone()).isDisplayed())
			{
				System.out.println("entering isselected if statement  in to selected 10");

				CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.Bydeafaultselectionperpageone());
				newone=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.Bydeafaultselectionperpageone()).getText();

			}




			Report.put("The number of searches can be  The default value Page per Item should be "+Report.color(newone), 
					" The number of results displayed should vary based on the Value set. The results set shouldn’t change. ",
					"Successfully The number of results displayed should vary based on the Value set. The results set shouldn’t change. ", "PASS");



		}
		catch(Exception e){
			Log.info(e);

			e.printStackTrace();

			Report.put("The number of results displayed should vary based on the Value set ", 
					" The number of results displayed should not vary based on the Value set. The results set should changed. ",
					"The number of results displayed should not vary based on the Value set. The results set should changed. ", "FAIL");

			Assert.fail();

		}
	}


	public void ToVerify_PrevandNextbuttonicon(WebDriver driver)
	{
		//WebDriverWait wait = new WebDriverWait(driver, 100);

		Actions act=new Actions(driver);
		//      driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);      
		System.out.println("In Function ToVerify_PrevandNextbuttonicon");
		Log.info("In Function ToVerify_PrevandNextbuttonicon");    
		
		try{


			String newone="";
			CommonUtility.ScrollTo(driver,  obj_EsupportCoveoPage.NextButtondisplayed());
			//			act.moveToElement(CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.Bydeafaultselectionperpageone())).build().perform();
			if(CommonUtility.CheckpresenceofElementLocated(driver, 2, obj_EsupportCoveoPage.NextButtondisplayed()))
			{
				System.out.println("entering previous button isdisplayed else statement");
				Report.put("it has previous page link which will take user to previous page of the search results. On "+Report.color(newone)+" page, this link will be disabled. ",
						"In the First page, The Previous Link Page or First Page buttons should be disabled. ","Successfully In the First page, The Previous Link Page or First Page buttons should be disabled. ", "PASS");

			}
			else
			{

				System.out.println("entering previous button isdisplayed if statement");
				Report.put("it has previous page link which will take user to previous page of the search results. On first page, this link will be Enabled. ",
						"In the First page, The Previous Link Page or First Page buttons should be Enabled. ","Successfully In the First page, The Previous Link Page or First Page buttons should be Enabled. ", "FAIL");
				Assert.fail();

			}



			//			act.moveToElement(CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.BydeafaultselectionHundred())).build().perform();
			//			CommonUtility.scrollToViewElement(driver,obj_EsupportCoveoPage.BydeafaultselectionHundred());

			//			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.BydeafaultselectionHundred()).click();
			CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.BydeafaultselectionHundred());
			WebDriverWait wait = new WebDriverWait(driver, 100);
			Thread.sleep(5000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.Bydeafaultselectiolastperpage()));
			Thread.sleep(5000);
			//			act.moveToElement(CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.Bydeafaultselectiolastperpage())).build().perform();
			//			CommonUtility.scrollToViewElement(driver,obj_EsupportCoveoPage.Bydeafaultselectiolastperpage());
			//			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.Bydeafaultselectiolastperpage()).click();
			CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.Bydeafaultselectiolastperpage());

			Thread.sleep(7000);
			CommonUtility.ScrollTo(driver, obj_EsupportCoveoPage.PrevButtondisplayed());
			if(CommonUtility.CheckpresenceofElementLocated(driver, 2, obj_EsupportCoveoPage.PrevButtondisplayed()))
			{
				//if(CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.NextButtondisplayed()).isDisplayed()){
				System.out.println("entering Next button isdisplayed else statement");
				Report.put("The pagination section has next page link which will take user to immediate next page. On the last page, this link is disabled ",
						"In the Last page, The Next Page Link and Last Page link buttons should be disabled. ","In the Last page, The Next Page Link and Last Page link buttons should be disabled. ", "PASS");



			}
			else
			{
				System.out.println("entering Next button isdisplayed if statement");
				Report.put("The pagination section has next page link which will take user to immediate next page. On the last page, this link is Enabled ",
						"In the Last page, The Next Page Link and Last Page link buttons should be Enabled. ","In the Last page, The Next Page Link and Last Page link buttons should be Enabled. ", "Fail");
				Assert.fail();

			}


		}

		catch(Exception e)
		{
			Log.info(e);
			Report.put("The pagination section has next page link which will take user to immediate next page. On the last page, this link is Enabled ",
					"In the Last page, The Next Page Link and Last Page link buttons should be Enabled. ","In the Last page, The Next Page Link and Last Page link buttons should be Enabled. ", "Fail");


			e.printStackTrace();
			Assert.fail();

		}



	}


	public void ToVerify_Tablesdata(WebDriver driver, String a)
	{
		WebDriverWait wait = new WebDriverWait(driver, 100);
		Actions act=new Actions(driver);
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);      
		System.out.println("In Function ToVerify_Tablesdata");
		Log.info("In Function ToVerify_Tablesdata");    
		try{


			Thread.sleep(5000);
			//act.moveToElement(CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.TablesRecord())).build().perform();
			CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.TablesRecord());;
			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ResultPerPage());
			String ltMessages="";

			try
			{
				List<WebElement> list=driver.findElements(obj_EsupportCoveoPage.ResultPerPage());

				for(WebElement lt:list)
				{
					CommonUtility.highlightElement(driver, lt);
					String names=lt.getText();

					System.out.println("Alert Name is: " +names);
					//ltMessages+=" <br> " + names;
					if(names.equals(a))
					{
						lt.click();
						Thread.sleep(5000);
						break;
					}


				}
			}
			catch(Exception e)
			{

			}




			List<WebElement> list1=driver.findElements(obj_EsupportCoveoPage.TablesRecord());
			int listcount1=list1.size();
			String intvalue=Integer.toString(listcount1);
			System.out.println(intvalue);



			Report.put("On click of items per page as "+ Report.color(a)+" the number of search result will changed based on the user selection and te page count is "+Report.color(intvalue), "The Result set displayed on screen should change as per the value set. But the result set shouldn’t change. ",
					"Successfully The Result set displayed on screen should change as per the value set. But the result set shouldn’t change. ", "PASS");

		}
		catch(Exception e){
			Log.info(e);

			e.printStackTrace();

			Report.put("On click of items per page as "+ Report.color(a)+" the number of search result will changed based on the user selection and te page count ",
					"The Result set displayed on screen should not able to change as per the value set. But the result set changed. ",
					"The Result set displayed on screen should not able to change as per the value set. But the result set changed. ", "FAIL");

			Assert.fail();

		}
	}

	public void ToVerify_TablesdataTwentyfive(WebDriver driver,String a)
	{
		WebDriverWait wait = new WebDriverWait(driver, 100);
		Actions act=new Actions(driver);
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);      
		System.out.println("In Function ToVerify_TablesdataTwentyfive");
		Log.info("In Function ToVerify_TablesdataTwentyfive");    
		try{


			Thread.sleep(5000);
			//			act.moveToElement(CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.Bydeafaultselectiontwentyfive())).build().perform();

			//			CommonUtility.scrollToViewElement(driver,obj_EsupportCoveoPage.Bydeafaultselectiontwentyfive());
			CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.Bydeafaultselectiontwentyfive());
			//			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.Bydeafaultselectiontwentyfive()).click();

			Thread.sleep(5000);

			List<WebElement> list1=driver.findElements(obj_EsupportCoveoPage.TablesRecord());
			int listcount1=list1.size();
			String intvalue=Integer.toString(listcount1);
			System.out.println(intvalue);



			Report.put("On click of items per page as "+ Report.color(a) +" the number of search result will changed based on the user selection and te page count is "+Report.color(intvalue), "The Result set displayed on screen should change as per the value set. But the result set shouldn’t change. ",
					"Successfully The Result set displayed on screen should change as per the value set. But the result set shouldn’t change. ", "PASS");

		}
		catch(Exception e){
			Log.info(e);

			e.printStackTrace();

			Report.put("On click of items per page as "+ Report.color(a)+" the number of search result will changed based on the user selection and te page count ",
					"The Result set displayed on screen should not able to change as per the value set. But the result set changed. ",
					"The Result set displayed on screen should not able to change as per the value set. But the result set changed. ", "FAIL");

			Assert.fail();

		}
	}

	public void ToVerify_TablesdataFifty(WebDriver driver,String a)
	{
		WebDriverWait wait = new WebDriverWait(driver, 100);
		Actions act=new Actions(driver);
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);      
		System.out.println("In Function ToVerify_TablesdataFifty");
		Log.info("In Function ToVerify_TablesdataFifty");    
		try{


			Thread.sleep(5000);
			//			act.moveToElement(CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.BydeafaultselectionFifty())).build().perform();

			//			CommonUtility.scrollToViewElement(driver,obj_EsupportCoveoPage.BydeafaultselectionFifty());
			CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.BydeafaultselectionFifty());
			//			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.BydeafaultselectionFifty()).click();

			Thread.sleep(5000);

			List<WebElement> list1=driver.findElements(obj_EsupportCoveoPage.TablesRecord());
			int listcount1=list1.size();
			String intvalue=Integer.toString(listcount1);
			System.out.println(intvalue);


			Report.put("On click of items per page as "+ Report.color(a) +" the number of search result will changed based on the user selection and te page count is "+Report.color(intvalue), "The Result set displayed on screen should change as per the value set. But the result set shouldn’t change. ",
					"Successfully The Result set displayed on screen should change as per the value set. But the result set shouldn’t change. ", "PASS");

		}
		catch(Exception e){
			Log.info(e);

			e.printStackTrace();

			Report.put("On click of items per page as "+ Report.color(a)+" the number of search result will changed based on the user selection and te page count ",
					"The Result set displayed on screen should not able to change as per the value set. But the result set changed. ",
					"The Result set displayed on screen should not able to change as per the value set. But the result set changed. ", "FAIL");

			Assert.fail();

		}
	}



	public void ToVerify_TablesdataHundred(WebDriver driver,String  a)
	{
		WebDriverWait wait = new WebDriverWait(driver, 100);
		Actions act=new Actions(driver);
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);      
		System.out.println("In Function ToVerify_TablesdataHundred");
		Log.info("In Function ToVerify_TablesdataHundred");    
		try{


			Thread.sleep(5000);
			//			act.moveToElement(CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.BydeafaultselectionHundred())).build().perform();
			CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.BydeafaultselectionHundred());
			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.BydeafaultselectionHundred());

			//			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.BydeafaultselectionHundred()).click();
			CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.BydeafaultselectionHundred());

			Thread.sleep(10000);
			String intvalue="";
			try
			{

				List<WebElement> list1=driver.findElements(obj_EsupportCoveoPage.TablesRecord());
				int listcount1=list1.size();
				intvalue=Integer.toString(listcount1);
				System.out.println(intvalue);
			}
			catch(Exception e){

			}


			Report.put("On click of items per page as "+ Report.color(a) +" the number of search result will changed based on the user selection and te page count is "+Report.color(intvalue), "The Result set displayed on screen should change as per the value set. But the result set shouldn’t change. ",
					"Successfully The Result set displayed on screen should change as per the value set. But the result set shouldn’t change. ", "PASS");

		}
		catch(Exception e){
			Log.info(e);

			e.printStackTrace();

			Report.put("On click of items per page as "+ Report.color(a)+" the number of search result will changed based on the user selection and te page count ",
					"The Result set displayed on screen should not able to change as per the value set. But the result set changed. ",
					"The Result set displayed on screen should not able to change as per the value set. But the result set changed. ", "FAIL");

			Assert.fail();

		}
	}

	public void ToVerify_ByRelevance(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 100);
		Actions act=new Actions(driver);
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);      
		System.out.println("In Function ToVerify_ByRelevance");
		Log.info("In Function ToVerify_ByRelevance");    
		try{


			Thread.sleep(5000);

			String Relevance="";


			if(CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.Relevance()).isDisplayed())
			{
				//				act.moveToElement(CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.Relevance())).build().perform();
				CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.Relevance());

				Relevance = CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.Relevance()).getText();
				System.out.println(Relevance);

			}

			Report.put("The default sorting setting will be relevance ", " By Deafault "+Report.color(Relevance)+" should display",
					"Successfully By Deafault Relevance should display ", "PASS");

		}
		catch(Exception e){
			Log.info(e);

			e.printStackTrace();

			Report.put("The default sorting setting will be relevance ", " Failed to display sorting settings relevance",
					"Failed to display sorting settings relevance ", "FAIL");
			Assert.fail();

		}
	}






	public void ToVerify_Datefunctiondescending(WebDriver driver,String descAcending)
	{
		WebDriverWait wait = new WebDriverWait(driver, 100);
		Actions act=new Actions(driver);
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);      
		System.out.println("In Function ToVerify_Datefunctiondescending");
		Log.info("In Function ToVerify_Datefunctiondescending");    
		try{



			//			act.moveToElement(CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.Datesortingclick())).build().perform();
			//			CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.Datesortingclick());
			//			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.Datesortingclick()).click();
			CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.Datesortingclick());

			CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.Datesortingclick());



			Thread.sleep(10000);


			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.MoreclickDate());

			List<WebElement> morelistafterclickingdate=driver.findElements(obj_EsupportCoveoPage.MoreclickDate());

			for(WebElement lt:morelistafterclickingdate)
			{
				CommonUtility.highlightElement(driver, lt);
				String names=lt.getText();

				lt.click();
			}

			Thread.sleep(3000);


			//			act.moveToElement(CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.MoreclickDateSorttable())).build().perform();

			CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.MoreclickDateSorttable());

			String ltMessagesbeforesortafterclickingdate="";

			List<WebElement> listdate=driver.findElements(obj_EsupportCoveoPage.MoreclickDateSorttable());

			for(WebElement lt:listdate)
			{
				CommonUtility.highlightElement(driver, lt);
				String names=lt.getText();

				//Thread.sleep(4000);

				System.out.println("After clicking date  :::: " +names);
				ltMessagesbeforesortafterclickingdate+=" <br> " + names;

			}

			Report.put("After clicking on date  ", "User is able to see a records as "+ Report.color(descAcending)+" , with the First Page ten records values as  "+Report.color(ltMessagesbeforesortafterclickingdate),
					"Successfully Sorted by clicking Date ", "PASS");

		}
		catch(Exception e){
			Log.info(e);

			e.printStackTrace();

			Report.put("After clicking on date  ", "Failed to see a records with the First Page ten records values",
					"Failed to see a records with the First Page ten records values ", "FAIL");
			Assert.fail();

		}
	}


	public void ToVerify_DatefunctionAscending(WebDriver driver,String descAcending)
	{
		WebDriverWait wait = new WebDriverWait(driver, 100);
		Actions act=new Actions(driver);
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);      
		System.out.println("In Function ToVerify_DatefunctionAscending");
		Log.info("In Function ToVerify_DatefunctionAscending");    
		try{



			//			act.moveToElement(CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.Dateresortingclick())).build().perform();
			//			CommonUtility.scrollToViewElement(driver,obj_EsupportCoveoPage.Dateresortingclick());
			//			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.Dateresortingclick()).click();

			CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.Dateresortingclick());

			Thread.sleep(10000);


			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.MoreclickDate());
			try
			{
				List<WebElement> morelistafterclickingdate=driver.findElements(obj_EsupportCoveoPage.MoreclickDate());

				for(WebElement lt:morelistafterclickingdate)
				{
					CommonUtility.highlightElement(driver, lt);
					String names=lt.getText();

					lt.click();
				}

				Thread.sleep(3000);
			}
			catch(Exception e)
			{

			}

			//			act.moveToElement(CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.MoreclickDateSorttable())).build().perform();

			CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.MoreclickDateSorttable());

			String ltMessagesbeforesortafterclickingdate="";

			List<WebElement> listdate=driver.findElements(obj_EsupportCoveoPage.MoreclickDateSorttable());

			for(WebElement lt:listdate)
			{
				CommonUtility.highlightElement(driver, lt);
				String names=lt.getText();

				//Thread.sleep(4000);

				System.out.println("After clicking date  :::: " +names);
				ltMessagesbeforesortafterclickingdate+=" <br> " + names;

			}

			Report.put("After clicking on date  ", "User is able to see a records as "+ Report.color(descAcending)+"  , with the First Page ten records values as  "+Report.color(ltMessagesbeforesortafterclickingdate),
					"Successfully Sorted by clicking Date ", "PASS");

		}
		catch(Exception e){
			Log.info(e);

			e.printStackTrace();

			Report.put("After clicking on date  ", "Failed to see a records with the Last Page ten records values",
					"Failed to see a records with the Last Page ten records values ", "FAIL");
			Assert.fail();


		}
	}

	//Mamta 3Dec
	public void Select_Search_Values_DirectContent(WebDriver driver, String value , String option)
	{
		WebDriverWait wait = new WebDriverWait(driver,120);
		Log.info("Enter in search");
		String flag="";
		try{
//			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.domainSelector()));
			//			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.domainSelector()).click(); 
//			CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.domainSelector());
			try
			{
//			List<WebElement> options=driver.findElements(obj_EsupportCoveoPage.domainSelectorList());
//
//			for(WebElement op:options){
//				CommonUtility.highlightElement(driver,op);
//				System.out.println(op.getText());
//				if(op.getText().contains(option)){
//					op.click();
//					flag=option;
//					break;
//				}
//			}      
			//			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.mastHead()).click();
			CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.mastHead());
			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.mastHead()).clear();
			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.mastHead()).sendKeys(value);
			CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.SearchButtonMastHead());
			CommonUtility.ToClickByUsingJavaScript_PassingByLoc(driver,obj_EsupportCoveoPage.SearchButtonMastHead());
			Thread.sleep(3000);
			//  handleCookies(driver);
			}
			catch(Exception e)
			{
				
			}

			if(flag.equals("Support")){
				try{
					//       if(CommonUtility.CheckpresenceofElementLocated(driver, 1, (By.xpath("//div[text()='Sorry, no results were found for ']")))){
					if(driver.findElement(By.xpath("//div[text()='Sorry, no results were found for ']")).isDisplayed())
					{
						String msg1=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.noResultFoundMessage1()).getText();
						System.out.println("the message is"+msg1);
						Report.put("Search for keyword "+Report.color(value)+" in Masthead.", "No Results are found page should be displayed. ", Report.color(msg1)+" is displayed", "PASS");

						String msg2=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.noResultFoundMessage2()).getText();
						System.out.println("the message is"+msg2);
						Report.put("Check if there is any Direct Content created for this Keyword ", "As there is a Direct Content created for this keyword, there should be 'Looking for Drivers for your Dell Product' is displayed above the 'No Result Found' section ", "Direct Content created for this keyword, and "+Report.color(msg2)+" is displayed above the 'No Result Found' section ", "PASS");
					}
					//     }
				}catch(Exception ex){
					//else if(CommonUtility.CheckpresenceofElementLocated(driver, 5,(By.xpath("//h1[text()='Looking for more Dell EMC content?']")))){
					//           else {
					System.out.println("EMC enabled direct content");
					//     wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Looking for more Dell EMC content?']")));      
					// if(wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//h1[text()='Looking for more Dell EMC content?']")))!=null){
					//CommonUtility.highlightElement(driver,By.xpath("//h1[text()='Looking for more Dell EMC content?']"));
					if(value.equals("Alienware"))
					{
						System.out.println("inside alienware ");
						//handleCaptcha_Aleinware(driver);
						Thread.sleep(10000);

					}
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Looking for more Dell EMC content?']")));
					Report.put("Perform search for EMC specific keyword: "+Report.color(value)+ "for which Direct Content is enabled and no results set is displayed ", "If the Direct content is enabled and has no restrictions, It will be displayed. ", "The result page is being displayed ", "PASS");
				}
				//     }
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
			Report.put("Select '"+flag+"' item and enter some keywords", "Search Should take customer to Coveo search result page", "Coveo search result page is not opened", "FAIL");
			Assert.fail();
		}
	}


	public void toSearch_Value_HomeSupport(WebDriver driver, String val)
	{
		try{
			CommonUtility.CheckpresenceofElementLocated(driver, 10, obj_EsupportCoveoPage.searchInputTextBox());
			//			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.searchInputTextBox()).click();
			CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.searchInputTextBox());
			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.searchInputTextBox()).sendKeys(val);
			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.searchInputTextBox()).sendKeys(Keys.ENTER);

			//        CommonUtility.CheckpresenceofElementLocated(driver, 50, By.xpath("//div[@id='divCatalogItems']//div/a[contains(text(),'Support for "+val+"')]"));
			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.diagnostics());
			String classval=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.diagnostics()).getAttribute("class");
			if(classval.contains("active")){
				System.out.println("diagnostics is active/clicked");
				Report.put("Enter "+Report.color(val)+" in Product Selector Search box or Mast Head Search box and click search button ",
						"It should navigate to Product support page of the product. By default Diagnostics tab should be selected.", "It is navigated to Product support page of the product and by default Diagnostics tab is selected.", "PASS");
			}else{
				System.out.println("diagnostics is not active/clicked");
				Report.put("Enter "+Report.color(val)+" in Product Selector Search box or Mast Head Search box and click search button ",
						"It should navigate to Product support page of the product. By default Diagnostics tab should be selected.", "Result is not as expecteds", "FAIL");
				Assert.fail();
			}

		} catch(Exception ex){
			ex.printStackTrace();
			Report.put("Enter "+Report.color(val)+" in Product Selector Search box or Mast Head Search box and click search button ",
					"It should navigate to Product support page of the product. By default Diagnostics tab should be selected.", "Result is not as expecteds", "FAIL");
			Assert.fail();
		}
	}
	public void Select_country_language(WebDriver driver, String country, String language)
	{
		WebDriverWait wait = new WebDriverWait(driver,50);
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.countryselector()));
			//			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.countryselector()).click();
			CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.countryselector());
			List<WebElement> lists=driver.findElements(obj_EsupportCoveoPage.countryselectorList());
			for(WebElement l:lists){
				if(l.getText().equalsIgnoreCase(country)){
					l.click();
					break;
				}
			}
			handleCookies(driver);
			//			CommonUtility.scrollToViewElement(driver, obj_EsupportCoveoPage.countryselector());
			CommonUtility.ScrollTo(driver, obj_EsupportCoveoPage.countryselector());
			List<WebElement> Langlists=driver.findElements(obj_EsupportCoveoPage.languageList());
			for(WebElement l:Langlists){
				if(l.getText().equalsIgnoreCase(language)){
					System.out.println("lanuage is selcted as:"+l.getText());
					l.click();
					break;
				}
			}
			Report.put("Now change the country to "+Report.color(country),
					"Based on the availability of Top Solution topics in the selected country & Language should get displayed.", "Top Solution topics & Language:" +Report.color(language)+"is getting displayed as per the selected country:"+Report.color(country), "PASS");

		} catch(Exception ex){
			ex.printStackTrace();
			Report.put("Now change the country to "+Report.color(country),
					"Based on the availability of Top Solution topics in the selected country & Language should get displayed.", "Result is not as expecteds", "FAIL");
			Assert.fail();
		}
	}

	public void select_product(WebDriver driver, String val)
	{
		try{
			CommonUtility.highlightElement(driver,By.xpath("//h1/span[contains(text(),'Support for "+val+"')]"));
			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.diagnostics());
			String classval=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.diagnostics()).getAttribute("class");
			if(classval.contains("active")){
				System.out.println("diagnostics is active/clicked");
				Report.put("Observe Default tab",
						"It should navigate to Product support page of the product. By default Diagnostics tab should be selected.", "It is navigated to Product support page of the product and by default Diagnostics tab is selected.", "PASS");
			}else{
				System.out.println("diagnostics is not active/clicked");
				Report.put("Observe Default tab",
						"It should navigate to Product support page of the product. By default Diagnostics tab should be selected.", "Result is not as expecteds", "FAIL");
				Assert.fail();
			}

		} catch(Exception ex){
			ex.printStackTrace();
			Report.put("Observe Default tab",
					"It should navigate to Product support page of the product. By default Diagnostics tab should be selected.", "Result is not as expecteds", "FAIL");
			Assert.fail();
		}
	}

	public void toLoad_SupportTopicsArticles (WebDriver driver)
	{
		Log.info("Clicking to Support Topics & Articles ");
		try{

			handleCookies(driver);
			//			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.supportTopicsArticles()).click(); 
			CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.supportTopicsArticles());
			String classval=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.supportTopicsArticles()).getAttribute("class");
			if(classval.contains("active")){
				System.out.println("Support Topics & Articles is active/clicked");
				//				CommonUtility.scrollToViewElement(driver, obj_EsupportCoveoPage.topSolutions());
				CommonUtility.ScrollTo(driver, obj_EsupportCoveoPage.topSolutions());;
				CommonUtility.CheckpresenceofElementLocated(driver, 50, obj_EsupportCoveoPage.topSolutions());

				List<WebElement> list=driver.findElements(obj_EsupportCoveoPage.topSolutionsLists());
				for(WebElement l:list){
					System.out.println(l.getText());
					CommonUtility.highlightElement(driver,l);
					List_type.add(l.getText());
				}
				Report.put("Now click Support Topics & Articles tab ",
						"It should show Support topics and at bottom of the page TOP SOLUTIONS section should be available showing the list of topics ", 
						" Support topics are displayed at the bottom of the page under TOP SOLUTIONS section. </br>The support topics are:"+Report.color(List_type), "PASS");

			}else{
				System.out.println("diagnostics is not active/clicked");
				Report.put("Now click Support Topics & Articles tab ",
						"It should show Support topics and at bottom of the page TOP SOLUTIONS section should be available showing the list of topics ", 
						" Result is not as expected", "FAIL");

				Assert.fail();
			}
		} catch(Exception ex){
			ex.printStackTrace();
			Report.put("Now click Support Topics & Articles tab ",
					"It should show Support topics and at bottom of the page TOP SOLUTIONS section should be available showing the list of topics ", 
					" Result is not as expected", "FAIL");
			Assert.fail();
		}      
	}

	public void toLoad_Productselector_HomePage(WebDriver driver, String val, String product1, String product2,String product3 )
	{
		Log.info("Entering to Product selector home page");
		try{
			//			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.browseAllProducts()).click(); 
			CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.browseAllProducts());
			CommonUtility.CheckpresenceofElementLocated(driver, 10, By.xpath("//div[@id='divCatalogSubItems']//div[contains(@class,'CatalogAlign')]//p[text()='"+product1+"']"));
			//			CommonUtility.highlightElement(driver,By.xpath("//div[@id='divCatalogSubItems']//div[contains(@class,'CatalogAlign')]//p[text()='"+product1+"']")).click(); 
			CommonUtility.ClickOn(driver,By.xpath("//div[@id='divCatalogSubItems']//div[contains(@class,'CatalogAlign')]//p[text()='"+product1+"']"));

			CommonUtility.CheckpresenceofElementLocated(driver, 10, By.xpath("//div[@id='divCatalogItems']//div[contains(@class,'CatalogAlign')]//p[text()='"+product2+"']"));
			//			CommonUtility.highlightElement(driver,By.xpath("//div[@id='divCatalogItems']//div[contains(@class,'CatalogAlign')]//p[text()='"+product2+"']")).click(); 
			CommonUtility.ClickOn(driver,By.xpath("//div[@id='divCatalogItems']//div[contains(@class,'CatalogAlign')]//p[text()='"+product2+"']"));
			// added below during 0202 2020 for e-series

			CommonUtility.CheckpresenceofElementLocated(driver, 10, By.xpath("//div[@id='divCatalogItems']//div[contains(@class,'CatalogAlign')]//p[text()='"+product3+"']"));
			//			CommonUtility.highlightElement(driver,By.xpath("//div[@id='divCatalogItems']//div[contains(@class,'CatalogAlign')]//p[text()='"+product3+"']")).click(); 
			CommonUtility.ClickOn(driver,By.xpath("//div[@id='divCatalogItems']//div[contains(@class,'CatalogAlign')]//p[text()='"+product3+"']"));

			//			CommonUtility.scrollToViewElement(driver, By.xpath("//div[@id='divCatalogItems']//div/a[contains(text(),'"+val+"')]"));
			//			CommonUtility.highlightElement(driver, By.xpath("//div[@id='divCatalogItems']//div/a[contains(text(),'"+val+"')]")).click(); 
			CommonUtility.ClickOn(driver, By.xpath("//div[@id='divCatalogItems']//div/a[contains(text(),'"+val+"')]")); 


			Report.put("Scenario 1: </br> Select product Latitude 7525 using Product selector </br> BROWSE ALL PRODUCTS --> "+Report.color(product1)+" -->  "+Report.color(product1)+" --> "+Report.color(val),
					"Product Support Home page should get loaded", "Product Support Home page is loaded", "PASS");
		}
		catch(Exception ex){
			ex.printStackTrace();
			Report.put("Scenario 1: </br> Select product Latitude 7525 using Product selector </br> BROWSE ALL PRODUCTS --> "+Report.color(product1)+" -->  "+Report.color(product1)+" --> "+Report.color(val),
					"Product Support Home page should get loaded", "Product Support Home page is not loaded", "FAIL");
			Assert.fail();
		}
	}

	public void DisplayTopSolutionsLists(WebDriver driver)
	{
		List<WebElement> list=null;
		try{
			list=driver.findElements(obj_EsupportCoveoPage.topSolutionsLists());
			System.out.println("the size of list :"+list.size());

			if(list.size()>=10){
				for(WebElement l:list){
					System.out.println(l.getText());
					CommonUtility.highlightElement(driver,l);
					List_type.add(l.getText());
				}
				if(CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.loadMoreResults()).isDisplayed()){
					//					CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.loadMoreResults()).click();
					CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.loadMoreResults());
					Thread.sleep(3000);
					list=null;
					list=driver.findElements(obj_EsupportCoveoPage.topSolutionsLists());
					System.out.println("the size of list now:"+list.size());
					for(WebElement l:list){
						System.out.println(l.getText());
						CommonUtility.highlightElement(driver,l);
						List_type.add(l.getText());
					}
				}
			}else if(list.size()<10){
				for(WebElement l:list){
					System.out.println(l.getText());
					List_type.add(l.getText());
				}      
			}

			Report.put("Now observe TOP SOLUTIONS section",
					"It should display Ten results and display button LOAD MORE RESULTS button (If there are more than 10 solutions). If the results fetched are less than 10, LOAD MORE RESULTS button shouldn’t be shown. ", 
					"The support topics are:"+Report.color(List_type), "PASS");
			Report.put("Now click LOAD MORE RESULTS button ",
					"It should display Ten more results.", 
					"Ten more results are displayed", "PASS");

			try{
				String val="";
				list=driver.findElements(obj_EsupportCoveoPage.topSolutionsLists());


				for(WebElement l:list){
					System.out.println(l.getText());
					CommonUtility.highlightElement(driver,l).click();
					break;
				}
				val=CommonUtility.highlightElement(driver,By.xpath("//h1[@id='ArticleTitle']")).getText();
				Report.put("Click on any of the link under TOP SOLUTIONS section ",
						"It should open the Solution page clicked.", 
						"The clicked topic is"+Report.color(val), "PASS");
			} catch(Exception ex){
				ex.printStackTrace();
				Report.put("Click on any of the link under TOP SOLUTIONS section ",
						"It should open the Solution page clicked.", 
						"No topic is clicked", "FAIL");
				Assert.fail();
			}
		}catch(Exception ex){
			ex.printStackTrace();
			Report.put("Now observe TOP SOLUTIONS section",
					"It should display Ten results and display button LOAD MORE RESULTS button (If there are more than 10 solutions). If the results fetched are less than 10, LOAD MORE RESULTS button shouldn’t be shown. ", 
					"Result is not as expected", "FAIL");
			Report.put("Now click LOAD MORE RESULTS button ",
					"It should display Ten more results.", 
					"Result is not as expected", "FAIL");
			Assert.fail();
		}
	}

	public void select_actionatorLink(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver,10);
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.searchSupport()));
			List<WebElement> lists= driver.findElements(obj_EsupportCoveoPage.actionatorLinkList());
			for(WebElement l:lists){
				l.click();
				break;
			}
			WebElement element = driver.findElement(By.xpath("//div[contains(@class,'coveo-result-action-menu')]/div//div[text()='Email Result']"));
			Actions actions = new Actions(driver);
			CommonUtility.ClickOn(driver,By.xpath("//div[contains(@class,'coveo-result-action-menu')]/div//div[text()='Email Result']"));
			//			actions.moveToElement(element).click().perform();

			System.out.println("the element is clicked");
			Report.put("Click on the actionator link for dell data.",
					"Only 'Email a result' link will be shown to customer.", "Only 'Email a result' link is showing to customer.", "PASS");

		} catch(Exception ex){
			ex.printStackTrace();
			Report.put("Click on the actionator link for dell data.",
					"Only 'Email a result' link will be shown to customer.", "'Email a result' link is not showing", "FAIL");
			Assert.fail();
		}
	}
	public void select_actionatorLink(WebDriver driver, String keyword)
	{
		System.out.println("enter in select_actionatorLink");
		WebDriverWait wait = new WebDriverWait(driver,100);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		List_type.clear();
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.searchSupport()));
			//			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.searchSupport()));
			try
			{
				List<WebElement> lists= driver.findElements(obj_EsupportCoveoPage.actionatorLinkList());

				for(WebElement l:lists){
					//Thread.sleep(4000);
					//				handleCookies(driver);
					CommonUtility.ScrollToWebElement(driver, l);
					js.executeScript("window.scrollBy(0,250)", "");
					CommonUtility.ToClickByUsingJavaScript_PassingByLoc(driver, l);
//					l.click();
					break;
				}
			}
			catch(Exception e)
			{

			}
			//			      if(keyword.equals("Dell")){
			//			      WebElement element = driver.findElement(By.xpath("//div[contains(@class,'coveo-result-action-menu')]/div//div[text()='Email Result']"));
			//			      Actions actions = new Actions(driver);
			//			      actions.moveToElement(element).click().perform();
//			CommonUtility.ScrollTo(driver, By.xpath("//div[contains(@class,'coveo-result-action-menu')]//div[contains(@class,'coveo-settings-item')]//div[contains(@class,'coveo-settings-text')]"));
//			List<WebElement> lst= driver.findElements(By.xpath("//div[contains(@class,'coveo-result-action-menu')]//div[contains(@class,'coveo-settings-item')]//div[contains(@class,'coveo-settings-text')]"));
//			try
//			{
//				for(WebElement l:lst){
//					System.out.println(l.getText());
//					List_type.add(l.getText());
//					CommonUtility.highlightElement(driver, l);
//					Thread.sleep(2000);
//				}
//			}
//			catch(Exception e)
//			{
//
//			}
			//System.out.println("the element is clicked");
			Report.put("Click on the actionator link for "+Report.color(keyword)+" data.",
					"Only "+Report.color(List_type)+" link will be shown to customer.", "Only "+Report.color(List_type)+" link is showing to customer.", "PASS");

			//         }
			//             System.out.println("the element is clicked");
			//             Report.put("Click on the actionator link for EMC data.",
			//                          "Only 'Email a result' & 'Link to Service Request' links will be shown to customer", "Only 'Email a result' & 'Link to Service Request' links are showing to customer.", "PASS");
		} catch(Exception ex){
			ex.printStackTrace();
			Report.put("Click on the actionator link for dell/EMC data.",
					"Only 'Email a result' & 'Link to Service Request' links will be shown to customer.", "'Email a result' & 'Link to Service Request' links are not showing", "FAIL");
			Assert.fail();
		}
	}



	//Pushpa
	public void  handleSearchTextbox(WebDriver driver, String inputText, String type) 
	{
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 120);


		System.out.println("Entering handleSearchTextbox");

		Log.info("Entering handleSearchTextbox");   
		String srNumber = TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[0];
		String driverId = TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[1];
		String articleId = TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[2];
		String contentHeader = "";

		try
		{       
			System.out.println("Inside try of handleSearchTextbox");
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.SearchTextbox()));
			if(CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SearchTextbox()).isDisplayed())
			{
				CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.SearchTextbox());
				CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SearchTextbox()).clear();
				CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SearchTextbox()).sendKeys(inputText);
				System.out.println("Input is : "+inputText);
				//				CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SearchButton()).click();
				CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.SearchButton2());
				CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.SearchButton2());
				
				Thread.sleep(6000);
				driver.navigate().refresh();
				Thread.sleep(10000);

			}



			Report.put(" Enter data  in Search Text box and click Search button.", 
					"Data should be entered", 
					"Data entered Successfully. Data is "+Report.color(type)+":" +Report.color(inputText), "PASS");

			Thread.sleep(3000);                     
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put(" Enter data  in Search Text box and click Search button.", 
					"Data should be entered", 
					"Failed to enter Data" +Report.color(inputText), "FAIL");;
					Assert.fail();
		}
	}
	public void  validateSearchHeader_ArticleID(WebDriver driver, String ArticleID)
	{
		WebDriverWait wait = new WebDriverWait(driver, 120);
		String releasedate = "";String status="";String articletype="";String articleid="";String productsname="";
		
		String SearchSupportTag = "";
		String linkText = "";
		try
		{                       

			handleCookies(driver);
			//handleCaptcha(driver);
			CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.SearchSupportTag());
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.SearchSupportTag()));
			
			if(CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SearchSupportTag()).isDisplayed())
			{
				CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SearchSupportTag());
				SearchSupportTag = CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SearchSupportTag()).getText();
				System.out.println("Header is : "+SearchSupportTag );
			}
			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_EsupportCoveoPage.ResultLink()))
			{
				CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ResultLink());
				linkText = CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ResultLink()).getText();
				System.out.println("Link Content is : "+linkText );
			
			
			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_EsupportCoveoPage.Morelink()))
			{

			CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.Morelink());
			String more=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.Morelink()).getText();
			System.out.println("link is "+more);
			CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.Morelink());
			
			
			wait.until(ExpectedConditions.presenceOfElementLocated(obj_EsupportCoveoPage.ArticleIDDetails()));
			CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.ArticleIDDetails());
			articleid=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ArticleIDDetails()).getText();
			System.out.println("article id is "+articleid);
			articleid=articleid.toLowerCase();
			System.out.println("article id is "+articleid);
			
			if((articleid.equals(ArticleID)))
			{
				Report.put("SCENARIO 3\r\n"
						+ "Enter Article ID ", 
						"Entering article id shows the article link. If Article ID # entered is not valid, it should display the Coveo results.  ", 
						"Failed to load coveo search result displaying searched article id", "FAIL");
			//	Assert.fail();
			}
			
			Report.put("SCENARIO 3\r\n"
					+ "Enter Article ID ", 
					"Entering article id shows the article link. If Article ID # entered is not valid, it should display the Coveo results.  ", 
					"Navigated to Coveo search page. Header is: "+Report.color(SearchSupportTag)+"Link Content: " +Report.color(linkText)+" and displayed article id is "+Report.color(articleid),"PASS");                         

			}
			}
			
			else
			{
				Report.put("SCENARIO 3\r\n"
						+ "Enter Article ID ", 
						"Entering article id shows the article link. If Article ID # entered is not valid, it should display the Coveo results.  ", 
						"Failed to load coveo search result displaying searched article id", "FAIL");
				Assert.fail();
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("SCENARIO 3\r\n"
					+ "Enter Article ID ", 
					"Entering article id shows the article link. If Article ID # entered is not valid, it should display the Coveo results.  ", 
					"Failed to load coveo search result displaying searched article id", "FAIL");
			Assert.fail();
		}

	}

	public void  validateSearchHeader_DriverID(WebDriver driver, String DriverID)
	{
		WebDriverWait wait = new WebDriverWait(driver, 120);
		String releasedate = "";String status="";String articletype="";String driid="";String productsname="";
		System.out.println("validateSearchHeader_DriverID");
		String SearchSupportTag = "";
		String linkText = "";
		try
		{                       

			handleCookies(driver);
			//handleCaptcha(driver);
			CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.SearchSupportTag());
			Thread.sleep(4000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.SearchSupportTag()));
			
			if(CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SearchSupportTag()).isDisplayed())
			{
				CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SearchSupportTag());
				SearchSupportTag = CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SearchSupportTag()).getText();
				System.out.println("Header is : "+SearchSupportTag );
			}
			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_EsupportCoveoPage.ResultLink()))
			{
				CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ResultLink());
				linkText = CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ResultLink()).getText();
				System.out.println("Link Content is : "+linkText );
			
			
			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_EsupportCoveoPage.Morelink()))
			{

			CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.Morelink());
			String more=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.Morelink()).getText();
			System.out.println("link is "+more);
			CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.Morelink());
			
			
			wait.until(ExpectedConditions.presenceOfElementLocated(obj_EsupportCoveoPage.DriversIDInCoveoSearch()));
			CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.DriversIDInCoveoSearch());
			driid=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.DriversIDInCoveoSearch()).getText();
			System.out.println("article id is "+driid);
			driid=driid.toLowerCase();
			System.out.println("article id is "+driid);
			
			if(!(driid.equals(DriverID)))
			{
				Report.put("SCENARIO 2 \r\n"
						+ "Enter Drivers ID", 
						"Entering drivers id shows the exact driver details link for that driver id. If driver id old then show the latest driver id for that driver. If Driver ID # entered is not valid, it should display the Coveo results.", 
						"Failed to load coveo search result displaying searched driver id", "FAIL");
//				Assert.fail();
			}
			
			Report.put("SCENARIO 2 \r\n"
					+ "Enter Drivers ID", 
					"Entering drivers id shows the exact driver details link for that driver id. If driver id old then show the latest driver id for that driver. If Driver ID # entered is not valid, it should display the Coveo results.", 
					"Navigated to Coveo search page. Header is: "+Report.color(SearchSupportTag)+"Link Content: " +Report.color(linkText)+" and displayed article id is "+Report.color(driid),"PASS");                         

			}
			}
			
			else
			{
				Report.put("SCENARIO 2 \r\n"
						+ "Enter Drivers ID", 
						"Entering drivers id shows the exact driver details link for that driver id. If driver id old then show the latest driver id for that driver. If Driver ID # entered is not valid, it should display the Coveo results.", 
						"Failed to load coveo search result displaying searched article id", "FAIL");
				Assert.fail();
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("SCENARIO 2 \r\n"
					+ "Enter Drivers ID", 
					"Entering drivers id shows the exact driver details link for that driver id. If driver id old then show the latest driver id for that driver. If Driver ID # entered is not valid, it should display the Coveo results.", 
					"Failed to load coveo search result displaying searched driver id", "FAIL");
			Assert.fail();
		}

	}
	public void  validateDriverHeader(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 120);

		String SearchSupportTag = "";
		String linkText = "";
		try
		{                       

			handleCookies(driver);
			//handleCaptcha(driver);
			CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.DriverHeaderPage());
//			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.DriverHeaderPage()));
			if(CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.DriverHeaderPage()).isDisplayed())
			{
				CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.DriverHeaderPage());
				SearchSupportTag = CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.DriverHeaderPage()).getText();
				System.out.println("Header is : "+SearchSupportTag );
			}
			
			Report.put("Open driver page", 
					"driver page should get loaded. ", 
					"Navigated to to driver page Successfully. Header is: "+Report.color(SearchSupportTag),"PASS");                         

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Open driver page", 
					"driver page should get loaded. ",
					"Failed to Navigate to driver details page", "FAIL");
			Assert.fail();
		}

	}
	public void  validateSupportHeader_ServiceTag(WebDriver driver, String ServiceTag)
	{
		WebDriverWait wait = new WebDriverWait(driver, 120);

		String SearchSupportHeader = "";
		try
		{      
			System.out.println("Entering validateSupportHeader_ServiceTag");
			driver.manage().timeouts().pageLoadTimeout(180, TimeUnit.SECONDS);
			Log.info("Entering validateSupportHeader_ServiceTag");

//			handleCookies(driver);
			//handleCaptcha(driver);
//			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.SearchSupportHeader()));
			if(CommonUtility.CheckpresenceofElementLocated(driver,10,obj_EsupportCoveoPage.Servicetag()))
			{
				CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.Servicetag());
				SearchSupportHeader = CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.Servicetag()).getText();
				System.out.println("tag is : "+SearchSupportHeader );
//				SearchSupportHeader=SearchSupportHeader.toLowerCase();
				
				if(!(SearchSupportHeader.contains(ServiceTag)))
				{
					Report.put("SCENARIO 4\r\n"
							+ "Enter Service tag in search text box and click Submit button. ", 
							"When entering service tag number, check the validity of the service tag and if it is valid, take user to product support page. If the service tag entered is invalid show search result with the text matching the values in the text box ", 
							"Failed to Navigate to product support page", "FAIL");
//					Assert.fail();
				}
				Report.put("SCENARIO 4\r\n"
						+ "Enter Service tag in search text box and click Submit button. ", 
						"When entering service tag number, check the validity of the service tag and if it is valid, take user to product support page. If the service tag entered is invalid show search result with the text matching the values in the text box ", 
						"user successfully navigated to product support page with searched product "+Report.color(SearchSupportHeader), "PASS");
			}
			
			else
			{
				Report.put("SCENARIO 4\r\n"
						+ "Enter Service tag in search text box and click Submit button. ", 
						"When entering service tag number, check the validity of the service tag and if it is valid, take user to product support page. If the service tag entered is invalid show search result with the text matching the values in the text box ", 
						"Failed to Navigate to product support page", "FAIL");
				Assert.fail();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("SCENARIO 4\r\n"
					+ "Enter Service tag in search text box and click Submit button. ", 
					"When entering service tag number, check the validity of the service tag and if it is valid, take user to product support page. If the service tag entered is invalid show search result with the text matching the values in the text box ", 
					"Failed to Navigate to Support HomePage.", "FAIL");
			Assert.fail();
		}

	}


	//sujata new code on 21st march 19

	public void ToNavigate_SupportUrlDND(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver,10);

		System.out.println("Entering methods in to the ToNavigate_SupportUrlDND");
		try{

			//handleCookies(driver);

			driver.navigate().to("https://www.dell.com/support/home/ae/en/aebsdt1/product-support/servicetag/dnpk882/drivers");

			//handleCookies(driver);

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDriversandDownloadsPage.driversandDownloads()));
			CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.driversandDownloads());
			String header=CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.driversandDownloads()).getText();
			System.out.println("Support Header is "+header);


			Report.put("Open Dell Integrated home page using URL https://www.dell.com/support/home/ae/en/aebsdt1/product-support/servicetag/dnpk882/drivers",
					Report.color(header)+" Support Home page should get loaded. ", "Successfully Drivers & Downloads Support Home page should get loaded. ", "PASS");

		} catch(Exception ex){
			ex.printStackTrace();

			Report.put("Open Dell Integrated home page using URL https://www.dell.com/support/home/ae/en/aebsdt1/product-support/servicetag/dnpk882/drivers",
					"Failed to navigate Drivers & Downloads Support Home page   ", "Failed to navigate Drivers & Downloads Support Home page  ", "FAIL");


			Assert.fail();
		}
	}

	public void  ToVerify_searchServiceTag(WebDriver driver,String serviceTag) {
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 120);
		Actions act=new Actions(driver);

		System.out.println("Entering ToVerify_searchServiceTag");

		Log.info("Entering ToVerify_searchServiceTag");   
		//String serviceTag = TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal());
		String contentHeader = "";

		try
		{	
			//handleCookies(driver);
			act.moveToElement(CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SearchTextbox())).build().perform();
			if(CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SearchTextbox()).isDisplayed())
			{

				Log.info("Entering fields in serchtagsss"); 

				CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SearchTextbox()).clear();
				Thread.sleep(3000);
				CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SearchTextbox()).sendKeys(serviceTag);
				System.out.println("Service Tag is : "+serviceTag);
				//Thread.sleep(6000);

				String ltMessages="";
				//	CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SuggetionslattitudeDD());

				List<WebElement> list=driver.findElements(obj_EsupportCoveoPage.SuggetionslattitudeDD());
				int count=list.size();
				System.out.println("list of lattitude count is :  " +count );
				int val=0;
				for(WebElement lt:list)
				{
					CommonUtility.highlightElement(driver, lt);
					String names=lt.getText();

					val++;

					System.out.println("Alert Name is: " +names);
					ltMessages+=" <br> " + names;

					if(val==10)
					{

						break;
					}
				}


				Report.put(" Enter first four ' "+Report.color(serviceTag)+" ' characters of any product Latitude", 
						"It should provide list of all count is ' "+ count +" ' similar products starting with those characters in the dropdown first 10 records are " +Report.color(ltMessages), 
						"Successfully It should provide list of all similar products starting with those characters in the dropdown", "PASS");

				//Thread.sleep(3000);			
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();

			Report.put(" Enter first four characters of any product Latitude", 
					"Failed to provide list of all similar products starting with those characters in the dropdown", 
					"Failed to provide list of all similar products starting with those characters in the dropdown", "FAIL");


			Assert.fail();
		}
	}

	public void  clickLatitudeSuggestionsPCFPage(WebDriver driver,String serviceTag) {
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 120);
		Actions act=new Actions(driver);

		System.out.println("Entering clickLatitudeSuggestionsPCFPage");

		Log.info("Entering clickLatitudeSuggestionsPCFPage");   
		//String serviceTag = TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal());
		String contentHeader = "";

		try
		{	
			handleCookies(driver);
			//			act.moveToElement(CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SearchTextbox())).build().perform();
			CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.SearchTextbox());
			if(CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SearchTextbox()).isDisplayed())
			{

				Log.info("Entering fields in serchtagsss"); 

				CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SearchTextbox()).clear();
				Thread.sleep(3000);
				CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SearchTextbox()).sendKeys(serviceTag);
				System.out.println("Service Tag is : "+serviceTag);
				//Thread.sleep(6000);

				String ltMessages="";
				//	CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SuggetionslattitudeDD());

				List<WebElement> list=driver.findElements(obj_EsupportCoveoPage.SuggestionsPCFPageList());
				int count=list.size();
				System.out.println("list of lattitude count is :  " +count );
				int val=0;
				for(WebElement lt:list)
				{
					CommonUtility.highlightElement(driver, lt);
					String names=lt.getText();

					val++;

					System.out.println("Alert Name is: " +names);
					ltMessages+=" <br> " + names;

					if(val==10)
					{

						break;
					}
				}


				Report.put(" Enter first four ' "+Report.color(serviceTag)+" ' characters of any product Latitude", 
						"It should provide list of all count is ' "+ count +" ' similar products starting with those characters in the dropdown first 10 records are " +Report.color(ltMessages), 
						"Successfully It should provide list of all similar products starting with those characters in the dropdown", "PASS");

				//Thread.sleep(3000);			
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();

			Report.put(" Enter first four characters of any product Latitude", 
					"Failed to provide list of all similar products starting with those characters in the dropdown", 
					"Failed to provide list of all similar products starting with those characters in the dropdown", "FAIL");


			Assert.fail();
		}
	}

	public void  ToVerify_searchServiceTagPCFPage(WebDriver driver,String serviceTag) {
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 120);
		Actions act=new Actions(driver);

		System.out.println("Entering ToVerify_searchServiceTagPCFPage");

		Log.info("Entering ToVerify_searchServiceTagPCFPage");   
		//String serviceTag = TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal());
		String contentHeader = "";

		try
		{	
			handleCookies(driver);
			//			act.moveToElement(CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SearchTextbox())).build().perform();
			CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.SearchTextbox());
			if(CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SearchTextbox()).isDisplayed())
			{

				//Log.info("Entering fields in serchtagsss"); 

				CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SearchTextbox()).clear();
				Thread.sleep(3000);
				CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SearchTextbox()).sendKeys(serviceTag);
				System.out.println("Service Tag is : "+serviceTag);
				Thread.sleep(6000);
				Thread.sleep(6000);
				String ltMessages="";
				CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.SuggestionsPCFPageList());

				List<WebElement> list=driver.findElements(obj_EsupportCoveoPage.SuggestionsPCFPageList());
				int count=list.size();
				System.out.println("list of lattitude count is :  " +count );
				int val=0;
				for(WebElement lt:list)
				{
					CommonUtility.highlightElement(driver, lt);
					String names=lt.getText();

					val++;

					System.out.println("Alert Name is: " +names);
					ltMessages+=" <br> " + names;

					if(val==10)
					{

						break;
					}
				}


				Report.put(" Enter first four ' "+Report.color(serviceTag)+" ' characters of any product Latitude", 
						"It should provide list of all count is ' "+ count +" ' similar products starting with those characters in the dropdown first 10 records are " +Report.color(ltMessages), 
						"Successfully It should provide list of all similar products starting with those characters in the dropdown", "PASS");

				//Thread.sleep(3000);			
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();

			Report.put(" Enter first four characters of any product Latitude", 
					"Failed to provide list of all similar products starting with those characters in the dropdown", 
					"Failed to provide list of all similar products starting with those characters in the dropdown", "FAIL");


			Assert.fail();
		}
	}

	public void  ToVerify_searchServiceTagnavigate(WebDriver driver,String serviceTag) {
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 120);
		Actions act=new Actions(driver);

		System.out.println("Entering ToVerify_searchServiceTagnavigate");

		Log.info("Entering ToVerify_searchServiceTagnavigate");   
		//String serviceTag = TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal());
		String contentHeader = "";

		try
		{	
			act.moveToElement(CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SearchTextbox())).build().perform();
			if(CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SearchTextbox()).isDisplayed())
			{

				Log.info("Entering fields in serchtagsss"); 

				CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SearchTextbox()).clear();

				Thread.sleep(3000);
				CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SearchTextbox()).sendKeys(serviceTag);
				System.out.println("Service Tag is : "+serviceTag);
				Thread.sleep(6000);

				//act.moveToElement(CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SuggetionslattitudeDD())).build().perform();
				//CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SuggetionslattitudeDD()).click();
				//				act.moveToElement(CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SuggestionsSupportPageList())).build().perform();
				//				CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SuggestionsSupportPageList()).click();
				CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.SuggestionsSupportPageList());


			}
			handleCookies(driver);
			//handleCaptcha(driver);
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.productPageHeader()));

			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.productPageHeader());
			contentHeader = CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.productPageHeader()).getText();
			System.out.println("Content Header is : "+contentHeader );



			Report.put(" Now continue typing ' "+Report.color(serviceTag)+" ' and click Search Button", 
					"It should navigate to Product Support Home page. as "+Report.color(contentHeader), 
					"Successfully It should navigate to Product Support Home page. ", "PASS");

			//Thread.sleep(3000);			

		}
		catch(Exception e)
		{
			e.printStackTrace();


			Report.put(" Now continue typing "+Report.color(serviceTag)+" and click Search Button", 
					"Failed to navigate to Product Support Home page. ", 
					"Failed to navigate to Product Support Home page. ", "FAIL");


			Assert.fail();
		}
	}


	public void  ToVerify_searchServiceTagsupportpage(WebDriver driver,String serviceTag) {
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 120);
		Actions act=new Actions(driver);

		System.out.println("Entering ToVerify_searchServiceTagsupportpage");

		Log.info("Entering ToVerify_searchServiceTagsupportpage");   
		//String serviceTag = TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal());
		String contentHeader = "";

		try
		{	
			//			act.moveToElement(CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SearchTextbox())).build().perform();
			CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.SearchTextbox());
			if(CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SearchTextbox()).isDisplayed())
			{

				Log.info("Entering fields in serchtagsss"); 

				CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SearchTextbox()).clear();
				Thread.sleep(3000);
				CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SearchTextbox()).sendKeys(serviceTag);
				System.out.println("Service Tag is : "+serviceTag);
				Thread.sleep(5000);

				//				CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SearchButton()).click();
				CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.SearchButton2());

				handleCookies(driver);
				//handleCaptcha(driver);
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.SearchSupportTag()));

				CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SearchSupportTag());
				contentHeader = CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SearchSupportTag()).getText();
				System.out.println("Content Header is : "+contentHeader );



				Report.put("Continue entering and type ' "+Report.color(serviceTag)+" ' and click Search button ", 
						"It should load ' "+Report.color(contentHeader)+" ' page ", 
						"Successfully Search Results page loaded", "PASS");
				//Thread.sleep(3000);			
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Continue entering and type' "+Report.color(serviceTag)+" ' and click Search button ", 
					"It should load Search Results page ", 
					"Successfully Search Results page loaded", "FAIL");

			Assert.fail();
		}
	}


	public void ToVerify_EnterServiceTagsupportpage(WebDriver driver,String Servicetag) 
	{
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 120);

		System.out.println("Entering ToVerify_EnterServiceTagsupportpage");
		Actions act = new Actions(driver);
		String convertedTag=Servicetag.toUpperCase();
		System.out.println("The converted Service tag is: " + convertedTag);

		System.out.println("Entering ToVerify_EnterServiceTagsupportpage");

		Log.info("Entering ToVerify_EnterServiceTagsupportpage");         
		try 
		{
			String Browseallproductslink="";
			String DetectPCButton="";

			String Headerservicetag="";
			String Headerservicetagdisplay="";

			handleCookies(driver);

			CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.Delllogo());
			CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.SearchServicetag());
			CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.SearchServicetag()).clear();
			CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.SearchServicetag()).sendKeys(Servicetag);
			Thread.sleep(3000);
			CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.SearchServicetag()).sendKeys(Keys.SPACE);
			CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.SearchServicetag()).sendKeys(Keys.BACK_SPACE);

			System.out.println("Entered Product Name");


			CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.Servicetagiconsearch());

			//			CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.Servicetagiconsearch()).click();
			CommonUtility.ClickOn(driver,obj_EsupportDriversandDownloadsPage.Servicetagiconsearch());
			//CommonUtility.highlightElement(driver,obj_EsupportDriversandDownloadsPage.Servicetagiconsearch()).sendKeys(Keys.ENTER);

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.productPageHeader()));

			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.productPageHeader());
			String  autosugestionproductslist= CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.productPageHeader()).getText();
			Report.put("Select one of the product from the list  ", "It should load the selected "+Report.color(autosugestionproductslist)+" details page",
					"Successfully It should load the selected product details page", "PASS");


			Thread.sleep(5000);

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Select one of the product from the list  ", "Failed to load the selected product details page",
					"Failed to load the selected product details page", "FAIL");
			Assert.fail();

		}

	}

	//pushpa

	public void  selectProductFromList(WebDriver driver) 
	{
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 120);
		Actions act=new Actions(driver);

		System.out.println("Entering selectProductFromList");

		Log.info("Entering selectProductFromList");   
		String header = "";

		try
		{ 
			String ltMessages="";
			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SuggetionslattitudeDD());

			List<WebElement> list=driver.findElements(obj_EsupportCoveoPage.SuggetionslattitudeDD());
			int count=list.size();
			System.out.println("list of lattitude count is :  " +count );

			for(WebElement lt:list)
			{
				CommonUtility.highlightElement(driver, lt);
				String names=lt.getText();
				lt.click();

				System.out.println("Alert Name is: " +names);
				ltMessages+=" <br> " + names;
				break;
			}
			Thread.sleep(3000);

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.productPageHeader()));

			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.productPageHeader());
			header = CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.productPageHeader()).getText();
			System.out.println("Content Header is : "+header );



			Report.put(" Now select any of the product from the dropdown ", 
					"It should navigate to Product Support Home page. as "+Report.color(header), 
					"Successfully navigated to Product Support Home page. ", "PASS");              
		}
		catch(Exception e)
		{
			e.printStackTrace();


			Report.put(" Now select any of the product from the dropdown ", 
					"It should navigate to Product Support Home page. as "+Report.color(header), 
					"Failed to navigate to Product Support Home page. ", "FAIL");

			Assert.fail();
		}
	}

	public void  selectProductFromSupportList(WebDriver driver) 
	{
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 120);
		Actions act=new Actions(driver);

		System.out.println("Entering selectProductFromSupportList");

		Log.info("Entering selectProductFromSupportList");   
		String header = "";

		try
		{ 
			String ltMessages="";
			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SuggestionsSupportPageList());

			List<WebElement> list=driver.findElements(obj_EsupportCoveoPage.SuggestionsSupportPageList());
			int count=list.size();
			System.out.println("list of lattitude count is :  " +count );

			for(WebElement lt:list)
			{
				CommonUtility.highlightElement(driver, lt);
				String names=lt.getText();
				lt.click();

				System.out.println("Alert Name is: " +names);
				ltMessages+=" <br> " + names;
				break;
			}
			Thread.sleep(3000);

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.productPageHeader()));

			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.productPageHeader());
			header = CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.productPageHeader()).getText();
			System.out.println("Content Header is : "+header );



			Report.put(" Now select any of the product from the dropdown ", 
					"It should navigate to Product Support Home page. as "+Report.color(header), 
					"Successfully navigated to Product Support Home page. ", "PASS");              
		}
		catch(Exception e)
		{
			e.printStackTrace();


			Report.put(" Now select any of the product from the dropdown ", 
					"It should navigate to Product Support Home page. as "+Report.color(header), 
					"Failed to navigate to Product Support Home page. ", "FAIL");

			Assert.fail();
		}
	}
	public void  selectProductFromListPCFPage(WebDriver driver) 
	{
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 120);
		Actions act=new Actions(driver);

		System.out.println("Entering selectProductFromListPCFPage");

		Log.info("Entering selectProductFromListPCFPage");   
		String header = "";

		try
		{ 
			String ltMessages="";
			//	CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SuggestionsPCFPageList());

			List<WebElement> list=driver.findElements(obj_EsupportCoveoPage.SuggestionsPCFPageList());
			int count=list.size();
			System.out.println("list of lattitude count is :  " +count );

			for(WebElement lt:list)
			{
				CommonUtility.highlightElement(driver, lt);
				String names=lt.getText();
				lt.click();

				System.out.println("Alert Name is: " +names);
				ltMessages+=" <br> " + names;
				break;
			}
			Thread.sleep(3000);

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.productPageHeader()));

			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.productPageHeader());
			header = CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.productPageHeader()).getText();
			System.out.println("Content Header is : "+header );



			Report.put(" Now select any of the product from the dropdown ", 
					"It should navigate to Product Support Home page. as "+Report.color(header), 
					"Successfully navigated to Product Support Home page. ", "PASS");              
		}
		catch(Exception e)
		{
			e.printStackTrace();


			Report.put(" Now select any of the product from the dropdown ", 
					"It should navigate to Product Support Home page. as "+Report.color(header), 
					"Failed to navigate to Product Support Home page. ", "FAIL");

			Assert.fail();
		}
	}

	public void  ToVerify_searchServiceTagsupportpagespecialchar(WebDriver driver,String serviceTag) {
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 120);
		Actions act=new Actions(driver);

		System.out.println("Entering ToVerify_searchServiceTagsupportpagespecialchar");

		Log.info("Entering ToVerify_searchServiceTagsupportpagespecialchar");   
		//String serviceTag = TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal());
		String contentHeader = "";

		try
		{	
			//			act.moveToElement(CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SearchTextbox())).build().perform();
			CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.SearchTextbox());
			if(CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SearchTextbox()).isDisplayed())
			{

				Log.info("Entering fields in serchtagsss"); 

				CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SearchTextbox()).clear();
				Thread.sleep(3000);
				CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SearchTextbox()).sendKeys(serviceTag);
				System.out.println("Service Tag is : "+serviceTag);
				Thread.sleep(5000);

				//				CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SearchButton()).click();
				CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.SearchButton());

				//				handleCookies(driver);
				//				handleCaptcha(driver);
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.SearchSupportTag()));

				CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SearchSupportTag());
				contentHeader = CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SearchSupportTag()).getText();
				System.out.println("Content Header is : "+contentHeader );



				Report.put("Continue entering and type ' "+Report.color(serviceTag)+" ' and click Search button ", 
						"It should load ' "+Report.color(contentHeader)+" ' page ", 
						"Successfully Search Results page loaded", "PASS");
				//Thread.sleep(3000);			
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Continue entering and type' "+Report.color(serviceTag)+" ' and click Search button ", 
					"It should load Search Results page ", 
					"Successfully Search Results page loaded", "FAIL");

			Assert.fail();
		}
	}

	//sujata 

	public void ToVerify_ClickCOntanctUS(WebDriver driver) 
	{
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 120);

		System.out.println("Entering ToVerify_ClickCOntanctUS");

		Log.info("Entering Esupport Home Page");    
		String currentURL = "";
		Actions act=new Actions(driver);
		try 
		{
			handleCookies(driver);

			//CommonUtility.highlightElement(driver,obj_EsupportIncidentsPage.Delllogo());
			System.out.println("Inside try block");

			System.out.println("Enter the url");


			driver.navigate().to("https://www.dell.com/support/home/us/en/19");
			Thread.sleep(2000);

			System.out.println("Successfully Entered the url");


			handleCookies(driver);

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIncidentsPage.ServicerequestDetailsheader()));
			CommonUtility.highlightElement(driver,obj_EsupportIncidentsPage.ServicerequestDetailsheader());
			String tsHeader1=CommonUtility.highlightElement(driver,obj_EsupportIncidentsPage.ServicerequestDetailsheader()).getText();
			System.out.println("Header1 is : "+tsHeader1);
			Report.put("Open Dell Support Home page using the URL provided (as per the test phase)SIT Env - https://dell.com/support/home", "Dell Integrated Support Home page should get loaded."  +Report.color(tsHeader1),
					"Successfully Dell Integrated Support Home page should get loaded. ", "PASS");


			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIncidentsPage.contactUs()));
			CommonUtility.highlightElement(driver,obj_EsupportIncidentsPage.contactUs());
			//			CommonUtility.highlightElement(driver,obj_EsupportIncidentsPage.contactUs()).click();
			CommonUtility.ClickOn(driver,obj_EsupportIncidentsPage.contactUs());
			Thread.sleep(3000);



			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIncidentsPage.technicalSupportSelect()));
			if(CommonUtility.highlightElement(driver,obj_EsupportIncidentsPage.technicalSupportSelect()).isDisplayed())
			{

				System.out.println("Technical Support displayed");
				//				CommonUtility.highlightElement(driver,obj_EsupportIncidentsPage.technicalSupportSelect()).click();
				CommonUtility.ClickOn(driver,obj_EsupportIncidentsPage.technicalSupportSelect());
			}
			else
			{
				//				CommonUtility.highlightElement(driver,obj_EsupportIncidentsPage.contactUs()).click();
				CommonUtility.ClickOn(driver,obj_EsupportIncidentsPage.contactUs());
				Thread.sleep(3000);


				System.out.println("Technical Support displayed");
				//				CommonUtility.highlightElement(driver,obj_EsupportIncidentsPage.technicalSupportSelect()).click();
				CommonUtility.ClickOn(driver,obj_EsupportIncidentsPage.technicalSupportSelect());


			}
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIncidentsPage.tsHeader()));
			CommonUtility.highlightElement(driver,obj_EsupportIncidentsPage.tsHeader());
			String tsHeader2=CommonUtility.highlightElement(driver,obj_EsupportIncidentsPage.tsHeader()).getText();
			System.out.println("Header2 is : "+tsHeader2);

			Report.put("Navigation from home page www.dell.com/support/home -> Contact Us -> Technical Support ", "User must land on Contact Technical Support page.",
					"Navigated to Contact Technical Support page successfully. Header is: "  +Report.color(tsHeader2), "PASS");




		}


		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Navigate to Contact Technical Support page", "Failed to navigate Contact Technical Support page.",
					" Failed to navigate Contact Technical Support page ", "FAIL");
			Assert.fail();
		}
	}


	public void ToNavigate_iNtegratedhomepage(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver,10);

		System.out.println("Entering methods in to the ToNavigate_iNtegratedhomepage");
		try{

			handleCookies(driver);

			driver.navigate().to("https://www.dell.com/support/home");

			handleCookies(driver);


			Report.put("Open Dell Integrated home page using URL https://www.dell.com/support/home",
					" Integrated Support Home page should get loaded. ", "Successfully Integrated Support Home page should get loaded. ", "PASS");



			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.clickhomedriversdownload()));
			//			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.clickhomedriversdownload()).click();
			CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.clickhomedriversdownload());


			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.welcomeSupportHeader()));
			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.welcomeSupportHeader());
			String driversdownloads=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.welcomeSupportHeader()).getText();


			Report.put("Now click on DRIVERS & DOWNLOADS link (Jump page link) ",
					" It should navigate to "+Report.color(driversdownloads)+" home page.  ", "Successfully It should navigate to Drivers & Downloads home page.  ", "PASS");

		} catch(Exception ex){
			ex.printStackTrace();

			Report.put("Now click on DRIVERS & DOWNLOADS link (Jump page link) ",
					"Failed to navigate Drivers & Downloads home page.  ", "Failed to navigate Drivers & Downloads home page.  ", "FAIL");


			Assert.fail();
		}
	}
	
	public void ToNavigate_IPShomepage(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver,10);

		System.out.println("Entering methods in to the ToNavigate_IPShomepage");
		try{

			handleCookies(driver);

			driver.navigate().to("https://www.dell.com/support/home");

			handleCookies(driver);


			Report.put("Open Dell Integrated home page using URL https://www.dell.com/support/home",
					" Integrated Support Home page should get loaded. ", "Successfully Integrated Support Home page should get loaded. ", "PASS");



			
		} catch(Exception ex){
			ex.printStackTrace();

			Report.put("Open Dell Integrated home page using URL https://www.dell.com/support/home",
					" Integrated Support Home page should get loaded. ", "Failed to navigate home page.  ", "FAIL");


			Assert.fail();
		}
	}

	//pushpa


	public void  navigateToURL(WebDriver driver, String Url)
	{
		WebDriverWait wait = new WebDriverWait(driver, 60);

		String header = "";
		String currentUrl = "";
		System.out.println("Entering navigateToURL");
		Log.info("Entering navigateToURL");   

		try
		{      
			driver.navigate().to(Url);
			currentUrl = driver.getCurrentUrl();
			System.out.println("Current URL is :"+currentUrl);

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.DdlHeader()));
			if(CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.DdlHeader()).isDisplayed())
			{
				CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.DdlHeader());
				header = CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.DdlHeader()).getText();
				System.out.println("Header is : "+header );
			}

			Report.put("Open Dell Integrated home page using URL https://dell.com/support/software", 
					"Dell Digital Locker page should get loaded. ", 
					"Navigated to Dell Digital Locker page succesfully", "PASS");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Open Dell Integrated home page using URL https://dell.com/support/software", 
					"Dell Digital Locker page should get loaded. ", 
					"Failed to navigate to Dell Digital Locker page", "FAIL");
			Assert.fail();
		}

	}


	public void  handleFooterLinks(WebDriver driver) 
	{
		System.out.println("Entering method handleFooterLinks");
		WebDriverWait  wait = new WebDriverWait(driver, 120);
		String currentURL = "";
		String currentUrlList = "";
		try
		{
			String PartsAccessoriesHeader="";
			String linkText = "";
			List<WebElement> list=driver.findElements(obj_EsupportCoveoPage.FooterLinks());
			int count = list.size();
			System.out.println("Count of Footer Links is:" +count);


			for (int i = 0; i < list.size(); i++)
			{
				list = driver.findElements(obj_EsupportCoveoPage.FooterLinks());
				String value = list.get(i).getText();
				CommonUtility.highlightElement(driver, list.get(i)).click();
				Thread.sleep(5000);
				System.out.println(value);
				currentURL = driver.getCurrentUrl();
				linkText+=" <br> " + value;
				currentUrlList+=" <br> " + currentURL;
				driver.navigate().back();
				Thread.sleep(5000);

				handleCookies(driver);

			}
			/*for(WebElement lt:list)
			{
				driver.navigate().refresh();
				handleCookies(driver);
				CommonUtility.highlightElement(driver, lt);
				String names=lt.getText();
				lt.click();
				Thread.sleep(5000);
				System.out.println("Part & Accessories is: " +names);
				currentURL = driver.getCurrentUrl();
				partAccessNames+=" <br> " + names;
				System.out.println("Current URL is:" +currentURL);

				currentUrlList+=" <br> " + currentURL;
				Thread.sleep(5000);
				driver.navigate().back();

			}*/

			System.out.println("Links are:"+linkText);

			Report.put("Verify all links in Footer",
					"All the links in Footer should work fine and the target pages should load properly.",
					"Successfully Footer Links displayed."+"Footer Links are:"+Report.color(linkText)+"<br>"+"URL's are:"+"<br>"+Report.color(currentUrlList),
					"PASS");

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify all links in Footer",
					"All the links in Footer should work fine and the target pages should load properly.",
					"Failed to display Footer Links ",
					"FAIL");
			Assert.fail();
		}
	}

	public void  displaySignInOptions(WebDriver driver) 
	{
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 120);
		Actions act=new Actions(driver);

		System.out.println("Entering displaySignInOptions");

		Log.info("Entering displaySignInOptions");   
		String header = "";

		try
		{ 
			String ltMessages="";
			WebElement element = driver.findElement(By.xpath("//div[@class='utility col-lg-3 col-md-3 col-sm-2']/ul/li[3]/a[@id='signin-link']"));
			Actions actions = new Actions(driver);
			//			actions.moveToElement(element).build().perform();
			CommonUtility.ScrollTo(driver,By.xpath("//div[@class='utility col-lg-3 col-md-3 col-sm-2']/ul/li[3]/a[@id='signin-link']"));
			//CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SuggetionslattitudeDD());

			List<WebElement> list=driver.findElements(obj_EsupportCoveoPage.SignInLinks());
			int count=list.size();
			System.out.println("list of Sign In links are:  " +count );

			for(WebElement lt:list)
			{
				CommonUtility.highlightElement(driver, lt);
				String names=lt.getText();
				//lt.click();

				System.out.println("Alert Name is: " +names);
				ltMessages+=" <br> " + names;
				//break;
			}
			Thread.sleep(3000);

			Report.put("Sign-in mouse over/click", 
					"Clicking Sign-in button should give the user the option to login as different user types.", 
					"Successfully displayed SignIn Links"+Report.color(ltMessages), "PASS");              
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Sign-in mouse over/click", 
					"Clicking Sign-in button should give the user the option to login as different user types.", 
					"Failed to display SignIn Links", "FAIL");      
			Assert.fail();
		}
	}

	public void  clickPremierSignIn(WebDriver driver) 
	{
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 120);
		Actions act=new Actions(driver);

		System.out.println("Entering clickPremierSignIn");
		Log.info("Entering clickPremierSignIn");

		String header = "";

		try
		{ 
			String ltMessages="";
			WebElement element = driver.findElement(By.xpath("//div[@class='utility col-lg-3 col-md-3 col-sm-2']/ul/li[3]/a[@id='signin-link']"));
			Actions actions = new Actions(driver);
			//			actions.moveToElement(element).build().perform();
			CommonUtility.ScrollTo(driver,By.xpath("//div[@class='utility col-lg-3 col-md-3 col-sm-2']/ul/li[3]/a[@id='signin-link']"));
			//CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SuggetionslattitudeDD());

			List<WebElement> list=driver.findElements(obj_EsupportCoveoPage.SignInLinks());
			int count=list.size();
			System.out.println("list of Sign In links are:  " +count );

			for(WebElement lt:list)
			{
				CommonUtility.highlightElement(driver, lt);
				String names=lt.getText();
				//lt.click();
				System.out.println("Alert Name is: " +names);
				ltMessages+=" <br> " + names;
				if(names.equalsIgnoreCase("Premier Sign In"))
				{
					lt.click();
					break;
				}

				//break;
			}
			Thread.sleep(3000);

			Report.put("Login with below Premier user credentials", 
					"Should navigate to Premier Login Page.", 
					"Successfully navigated to Premier Login Page"+Report.color(ltMessages), "PASS");              
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Login with below Premier user credentials", 
					"Should navigate to Premier Login Page.", 
					"Failed to navigate to Premier Login Page", "FAIL");        
			Assert.fail();
		}
	}

	public void  selectPremierStore(WebDriver driver, String account) 
	{
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 120);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		boolean exists = true;

		System.out.println("Entering selectPremierStore");
		Log.info("Entering selectPremierStore");        
		try 
		{	
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportOrderHomePage.selectAccount()));
			CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.selectAccount());

			//			CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.selectAccountdrp()).click();
			CommonUtility.ClickOn(driver,obj_EsupportOrderHomePage.selectAccountdrp());
			Thread.sleep(3000);
			List<WebElement> elements = driver.findElements(obj_EsupportOrderHomePage.selectlist());
			for (int i = 0; i < elements.size(); i++) 
			{
				String Account=elements.get(i).getText();
				// if(Account.contains(" Balance Innovations [ General Access ]"))

				if(Account. contains(account))
				{
					elements.get(i).click();
					System.out.println("Selected Account/Access Group"); 
					Thread.sleep(3000);
					break;
				}
			}
			Thread.sleep(3000);
			//			CommonUtility.highlightElement(driver,obj_EsupportOrderHomePage.accessPremier()).click();
			CommonUtility.ClickOn(driver,obj_EsupportOrderHomePage.accessPremier());


			Report.put("Enter valid credentials and select the required store ",
					"Coresponding premier store must be displayed",
					"Coresponding premier store is displayed", "PASS");

		}
		catch(Exception e)
		{
			e.printStackTrace();

			Report.put("Enter valid credentials and select the required store ",
					"Corresponding premier store must be displayed",
					"Corresponding premier store is not displayed", "FAIL");

			Assert.fail();
		}
	}

	public void  handlePremierHeaderLinks(WebDriver driver) 
	{
		System.out.println("Entering method handlePremierHeaderLinks");
		WebDriverWait  wait = new WebDriverWait(driver, 120);

		try
		{			
			String linkText = "";
			List<WebElement> list=driver.findElements(obj_EsupportCoveoPage.PremierPageLinks());
			int count = list.size();
			System.out.println("Count of Premier Header Links is:" +count);

			for(WebElement lt:list)
			{				
				CommonUtility.highlightElement(driver, lt);
				String names=lt.getText();

				Thread.sleep(5000);
				System.out.println("Link is: " +names);

				linkText+=" <br> " + names;

				Thread.sleep(5000);		
			}

			System.out.println("Links are:"+linkText);

			Report.put("Verify all links in Header",
					"All the links in Header should work fine",
					"Successfully Header Links are displayed."+"Header Links are:"+Report.color(linkText),
					"PASS");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify all links in Header",
					"All the links in Header should work fine",
					"Failed to display Header Links",
					"FAIL");
			Assert.fail();
		}
	}


	public void  handlePremierFooterLinks(WebDriver driver) 
	{
		System.out.println("Entering method handleFooterLinks");
		WebDriverWait  wait = new WebDriverWait(driver, 120);
		String currentURL = "";
		String currentUrlList = "";
		try
		{
			String PartsAccessoriesHeader="";
			String linkText = "";
			List<WebElement> list=driver.findElements(obj_EsupportCoveoPage.PremierPageFooterLinks());
			int count = list.size();
			System.out.println("Count of Footer Links is:" +count);


			for (int i = 0; i < list.size(); i++)
			{
				list = driver.findElements(obj_EsupportCoveoPage.PremierPageFooterLinks());
				String value = list.get(i).getText();
				CommonUtility.highlightElement(driver, list.get(i)).click();
				Thread.sleep(5000);
				System.out.println(value);
				currentURL = driver.getCurrentUrl();
				linkText+=" <br> " + value;
				currentUrlList+=" <br> " + currentURL;
				driver.navigate().back();
				Thread.sleep(5000);

				handleCookies(driver);

			}

			System.out.println("Links are:"+linkText);

			Report.put("Verify all links in Footer",
					"All the links in Footer should work fine and the target pages should load properly.",
					"Successfully Footer Links displayed."+"Footer Links are:"+Report.color(linkText)+"<br>"+"URL's are:"+"<br>"+Report.color(currentUrlList),
					"PASS");

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify all links in Footer",
					"All the links in Footer should work fine and the target pages should load properly.",
					"Failed to display Footer Links ",
					"FAIL");
			Assert.fail();
		}
	}

	public void  handleHeaderLinks(WebDriver driver) 
	{
		System.out.println("Entering method handleHeaderLinks");
		WebDriverWait  wait = new WebDriverWait(driver, 120);
		String currentURL = "";
		String currentUrlList = "";
		try
		{
			String PartsAccessoriesHeader="";
			String linkText = "";
			List<WebElement> list=driver.findElements(obj_EsupportCoveoPage.HeaderLinks());
			int count = list.size();
			System.out.println("Count of Footer Links is:" +count);


			for (int i = 0; i < list.size(); i++)
			{
				list = driver.findElements(obj_EsupportCoveoPage.HeaderLinks());
				String value = list.get(i).getText();
				CommonUtility.highlightElement(driver, list.get(i)).click();
				Thread.sleep(5000);
				System.out.println(value);
				currentURL = driver.getCurrentUrl();
				linkText+=" <br> " + value;
				currentUrlList+=" <br> " + currentURL;
				driver.navigate().back();
				Thread.sleep(5000);

				handleCookies(driver);

			}

			System.out.println("Links are:"+linkText);

			Report.put("Verify all links in Footer",
					"All the links in Footer should work fine and the target pages should load properly.",
					"Successfully Footer Links displayed."+"Footer Links are:"+Report.color(linkText)+"<br>"+"URL's are:"+"<br>"+Report.color(currentUrlList),
					"PASS");

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Verify all links in Footer",
					"All the links in Footer should work fine and the target pages should load properly.",
					"Failed to display Footer Links ",
					"FAIL");
			Assert.fail();
		}
	}

	public void  enterServiceTaginMasthead(WebDriver driver,String serviceTag)
	{
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 120);
		Actions act=new Actions(driver);

		System.out.println("Entering enterServiceTaginMasthead");

		Log.info("Entering enterServiceTaginMasthead");   
		String contentHeader = "";

		try
		{	
			handleCookies(driver);
			act.moveToElement(CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SearchTextbox())).build().perform();
			if(CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SearchTextbox()).isDisplayed())
			{
				CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SearchTextbox()).clear();
				Thread.sleep(3000);
				CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SearchTextbox()).sendKeys(serviceTag);
				System.out.println("Service Tag is : "+serviceTag);
				Thread.sleep(5000);

				//				CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SearchButton()).click();
				CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.SearchButton2());

				handleCookies(driver);
				//	handleCaptcha(driver);
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.SearchSupportHeader()));

				CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SearchSupportHeader());
				contentHeader = CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SearchSupportHeader()).getText();
				System.out.println("Header is : "+contentHeader );



				Report.put("Continue entering and type ' "+Report.color(serviceTag)+" ' and click Search button ", 
						"It should load ' "+Report.color(contentHeader)+" ' page ", 
						"Successfully Search Results page loaded", "PASS");
				//Thread.sleep(3000);			
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Continue entering and type' "+Report.color(serviceTag)+" ' and click Search button ", 
					"It should load Search Results page ", 
					"Search Results page not loaded", "FAIL");

			Assert.fail();
		}
	}

	public void  searchSRNumber(WebDriver driver, String serviceTag, String Email)
	{
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 120);
		Actions act=new Actions(driver);

		System.out.println("Entering searchSRNumber");

		Log.info("Entering searchSRNumber");   
		String srHeader = "";

		try
		{	
			act.moveToElement(CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SearchTextbox())).build().perform();
			if(CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SearchTextbox()).isDisplayed())
			{

				Log.info("Entering fields in serchtagsss"); 
				CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SearchTextbox()).sendKeys(serviceTag);
				System.out.println("Service Tag is : "+serviceTag);
				//				CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SearchButton()).click();
				CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.SearchButton());

			}
			handleCookies(driver);
			//handleCaptcha(driver);
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIncidentsPage.serviceRequestHeader()));

			handleCookies(driver);
			if(CommonUtility.highlightElement(driver,obj_EsupportIncidentsPage.serviceRequestHeader()).isDisplayed())
			{
				CommonUtility.highlightElement(driver,obj_EsupportIncidentsPage.serviceRequestHeader());
				srHeader = CommonUtility.highlightElement(driver,obj_EsupportIncidentsPage.serviceRequestHeader()).getText();
				System.out.println("SR Page header is :"+srHeader);

				//				CommonUtility.highlightElement(driver,obj_EsupportIncidentsPage.srSearchClick()).click();

				CommonUtility.ClickOn(driver,obj_EsupportIncidentsPage.srSearchClick());

				Thread.sleep(4000);        
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIncidentsPage.validateServiceRequest()));

				CommonUtility.highlightElement(driver,obj_EsupportIncidentsPage.emailEntryText()).clear();
				CommonUtility.highlightElement(driver,obj_EsupportIncidentsPage.emailEntryText()).sendKeys(Email);
				//				CommonUtility.highlightElement(driver,obj_EsupportIncidentsPage.emailEntryButton()).click();
				CommonUtility.ClickOn(driver,obj_EsupportIncidentsPage.emailEntryButton());
				Thread.sleep(10000);        
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIncidentsPage.searchResultsHeader()));
				CommonUtility.highlightElement(driver,obj_EsupportIncidentsPage.searchResultsHeader());



				Report.put("Enter valid SR number in the masthead and click search button.", 
						"It should fetch the results", 
						"Result fetched Successfully" +"<br>"+"SR Number "+Report.color(serviceTag)+"<br>" +"Header is: "+Report.color(srHeader), "PASS");

				//Thread.sleep(3000);			
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();

			Report.put(" Enter SR Number in Mast head Coveo search Text box and click Search button.", 
					"Not able to fetch the results", 
					"Not able to fetch the results", "FAIL");


			Assert.fail();
		}
	}

	public void  clickLatitudeSuggestionsSupportPage(WebDriver driver,String serviceTag) {
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 240);
		Actions act=new Actions(driver);

		System.out.println("Entering clickLatitudeSuggestionsSupportPage");

		Log.info("Entering clickLatitudeSuggestionsSupportPage");   
		//String serviceTag = TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal());
		String contentHeader = "";

		try
		{	
			handleCookies(driver);
			//			act.moveToElement(CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SearchTextbox())).build().perform();
			CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.SearchTextbox());
			if(CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SearchTextbox()).isDisplayed())
			{

				Log.info("Entering fields in serchtagsss"); 

				CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SearchTextbox()).clear();
				Thread.sleep(3000);
				CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SearchTextbox()).sendKeys(serviceTag);
				System.out.println("Service Tag is : "+serviceTag);
				//Thread.sleep(6000);
				CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SearchTextbox()).sendKeys(Keys.SPACE);
				CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SearchTextbox()).sendKeys(Keys.SPACE);
				
				CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SearchTextbox()).sendKeys(Keys.BACK_SPACE);
				
				String ltMessages="";
				
				
				//	CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SuggetionslattitudeDD());
				wait.until(ExpectedConditions.presenceOfElementLocated(obj_EsupportCoveoPage.SuggestionsSupportPageList()));
				
				List<WebElement> list=driver.findElements(obj_EsupportCoveoPage.SuggestionsSupportPageList());
				int count=list.size();
				System.out.println("list of lattitude count is :  " +count );
				int val=0;
				for(WebElement lt:list)
				{
					try
					{
					CommonUtility.ScrollToWebElement(driver, lt);
					String names=lt.getText();

					val++;

					System.out.println("Alert Name is: " +names);
					ltMessages+=" <br> " + names;
					}catch(Exception e)
					{
						
					}

					if(val==10)
					{

						break;
					}
				}


				Report.put(" Enter first four ' "+Report.color(serviceTag)+" ' characters of any product Latitude", 
						"It should provide list of all count is ' "+ count +" ' similar products starting with those characters in the dropdown first 10 records are " +Report.color(ltMessages), 
						"Successfully It should provide list of all similar products starting with those characters in the dropdown", "PASS");

				//Thread.sleep(3000);			
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();

			Report.put(" Enter first four characters of any product Latitude", 
					"Failed to provide list of all similar products starting with those characters in the dropdown", 
					"Failed to provide list of all similar products starting with those characters in the dropdown", "FAIL");


			Assert.fail();
		}
	}

	public void  handleSearchTextbox_IE(WebDriver driver, String inputText, String type) 
	{
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 120);


		System.out.println("Entering handleSearchTextbox_IE");

		Log.info("Entering handleSearchTextbox_IE");   
		String srNumber = TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[0];
		String driverId = TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[1];
		String articleId = TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[2];
		String contentHeader = "";

		try
		{       
			System.out.println("Inside try of handleSearchTextbox_IE");
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.SearchTextbox()));
			if(CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SearchTextbox()).isDisplayed())
			{
				CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SearchTextbox()).clear();
				CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SearchTextbox()).sendKeys(inputText);
				System.out.println("Input is : "+inputText);
				WebElement ele = driver.findElement(obj_EsupportCoveoPage.SearchButton());
				//				CommonUtility.ToClickByUsingJavaScript(driver, ele);
				CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.SearchButton());
			}



			Report.put(" Enter data  in Search Text box and click Search button.", 
					"Data should be entered", 
					"Data entered Successfully. Data is "+Report.color(type)+":" +Report.color(inputText), "PASS");

			Thread.sleep(3000);       
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put(" Enter data  in Search Text box and click Search button.", 
					"Data should be entered", 
					"Failed to enter Data" +Report.color(inputText), "FAIL");;
					Assert.fail();
		}
	}

	public void toClickDiagnosticsTools(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver,10);

		System.out.println("Entering toClickDiagnosticsTools");
		try
		{	
			Actions act=new Actions(driver);
			//			act.moveToElement(CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.diagnosticsToolsLink())).build().perform();
			//			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.diagnosticsToolsLink()).click();
			CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.diagnosticsToolsLink());

			String header=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.diagnosticsToolsHeader()).getText();
			System.out.println("Header is "+header);


			Report.put("Click 'Diagnostics & Tools' image in the integrated support home page. (Jump Page link)",
					"It should navigate to Diagnostics home page. ",
					"Successfully loaded "+Report.color(header), "PASS");

		} catch(Exception ex){
			ex.printStackTrace();

			Report.put("Click 'Diagnostics & Tools' image in the integrated support home page. (Jump Page link)",
					"It should navigate to Diagnostics home page. ",
					"Failed to loadDiagnostics & Tools Page", "FAIL");
			Assert.fail();
		}
	}

	public void selectSupportfromDropdown(WebDriver driver, String option)
	{
		WebDriverWait wait = new WebDriverWait(driver,50);
		System.out.println("Entering in method Select_Search_Values");
		Log.info("Entering in method Select_Search_Values");
		String flag="";
		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.domainSelector()));
			//			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.domainSelector()).click(); 
			CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.domainSelector());
			List<WebElement> options=driver.findElements(obj_EsupportCoveoPage.domainSelectorList());

			for(WebElement op:options)
			{
				CommonUtility.highlightElement(driver,op);
				System.out.println(op.getText());
				if(op.getText().contains(option))
				{
					op.click();
					flag=option;
					break;
				}
			}     
		}
		catch(Exception ex){
			ex.printStackTrace();
			Report.put("Select 'Dell.com' item and enter some keywords :",
					"Search Should take customer to unified search result page. The results should be displayed in LIST view. ", "Unified search result page is opened and the results should be displayed in LIST view. ", "FAIL");   
			Assert.fail();
		}
	}

	public void clickDriversDownloads(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver,10);

		System.out.println("Entering toClickDriversDownloads");
		try
		{	
			Actions act=new Actions(driver);
			//			act.moveToElement(CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.clickhomedriversdownload())).build().perform();
			//			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.clickhomedriversdownload()).click();
			CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.clickhomedriversdownload());

			String header=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.DriversDownloadsHeader()).getText();
			System.out.println("Header is "+header);


			Report.put("Click on DRIVERS & DOWNLOADS link (Jump page link)",
					"It should navigate to DRIVERS & DOWNLOADS home page. ",
					"Successfully loaded "+Report.color(header), "PASS");

		} catch(Exception ex){
			ex.printStackTrace();

			Report.put("Click on DRIVERS & DOWNLOADS link (Jump page link)",
					"It should navigate to DRIVERS & DOWNLOADS home page. ",
					"Failed to load Drivers & Downloads Page ", "FAIL");
			Assert.fail();
		}
	}

	public void clickContactUsTechnicalSupport(WebDriver driver) 
	{
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 120);

		System.out.println("Entering clickContactUsTechnicalSupport");

		Log.info("Entering clickContactUsTechnicalSupport");    
		String currentURL = "";
		String header = "";
		Actions act=new Actions(driver);
		try 
		{			

			driver.navigate().to("https://dell.com/support/home");
			Thread.sleep(2000);

			System.out.println("Successfully Entered the url");




			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.welcomeSupportHeader()));
			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.welcomeSupportHeader());
			header = CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.welcomeSupportHeader()).getText();

			Report.put("Open Dell Support Home page https://dell.com/support/home", 
					"Dell Integrated Support Home page should get loaded."  +Report.color(header),
					"Successfully Dell Integrated Support Home page should get loaded. ", "PASS");


			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIncidentsPage.contactUs()));
			CommonUtility.highlightElement(driver,obj_EsupportIncidentsPage.contactUs());
			//			CommonUtility.highlightElement(driver,obj_EsupportIncidentsPage.contactUs()).click();
			CommonUtility.ClickOn(driver,obj_EsupportIncidentsPage.contactUs());
			Thread.sleep(3000);



			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIncidentsPage.technicalSupportSelect()));
			if(CommonUtility.highlightElement(driver,obj_EsupportIncidentsPage.technicalSupportSelect()).isDisplayed())
			{

				System.out.println("Technical Support displayed");
				//				CommonUtility.highlightElement(driver,obj_EsupportIncidentsPage.technicalSupportSelect()).click();
				CommonUtility.ClickOn(driver,obj_EsupportIncidentsPage.technicalSupportSelect());
			}

			Report.put("Navigation from home page www.dell.com/support/home -> Contact Us -> Technical Support ", "User must land on Contact Technical Support page.",
					"Navigated to Contact Technical Support page successfully. Header is: " , "PASS");




		}


		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Navigate to Contact Technical Support page", "Failed to navigate Contact Technical Support page.",
					" Failed to navigate Contact Technical Support page ", "FAIL");
			Assert.fail();
		}
	}
	//Lavanya
	public void ClickShowMoreButton(WebDriver driver) 
	{
		Log.info("Entering method ClickShowMoreButton");
		WebDriverWait  wait = new WebDriverWait(driver, 120);
		String result="";


		String upgradescount="";

		String articlenames="";
		String result1="";
		String result2="";

		try
		{
			handleCookies(driver);

			if(CommonUtility.CheckpresenceofElementLocated(driver, 30, obj_EsupportCoveoPage.ShowMoreResults()))
			{ 
				System.out.println("searching more results");
				//				CommonUtility.scrollToViewElement(driver, obj_EsupportCoveoPage.ShowMoreResults());
				CommonUtility.ScrollTo(driver, obj_EsupportCoveoPage.ShowMoreResults());
				List<WebElement> showmore=driver.findElements(obj_EsupportCoveoPage.ShowMoreResults());
				if((showmore).size()>0)
				{
					for(int i=0;i<showmore.size();i++)
					{
						String title=showmore.get(i).getText();
						System.out.println(title);

						System.out.println("clicking showmore");
						CommonUtility.highlightElement(driver, showmore.get(i)).click();
						Thread.sleep(30000);
						handleCookies(driver);
						result=CommonUtility.highlightElement(driver, obj_EsupportContentHomePage.GetCoveoPageResults()).getText();
						System.out.println("Search results "+result);
						result=result.toLowerCase();
						if (result.contains("result"))
						{
							Log.info("Test case pass");
						}
						else
						{
							Log.info("Test case fail");
							Report.put("Click on show more button to see more articles", 
									"User should able to click on show more button and able to see more articles loading untill show more disappears",
									"afer clicking on show more button coveo page not reloaded", "FAIL");
							Assert.fail();
						}
						//wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.ShowMoreResults()));
						if(CommonUtility.CheckpresenceofElementLocated(driver, 30, obj_EsupportCoveoPage.ShowMoreResults()))
						{
							System.out.println();
							//							CommonUtility.highlightElement(driver, obj_EsupportCoveoPage.ShowMoreResults()).click();
							CommonUtility.ClickOn(driver, obj_EsupportCoveoPage.ShowMoreResults());
							Thread.sleep(15000);
							handleCookies(driver);

						}

					}

				}
			}
			else

				if(CommonUtility.CheckpresenceofElementLocated(driver, 30, obj_EsupportContentHomePage.GetCoveoPageResults()))
				{
					result2=CommonUtility.highlightElement(driver, obj_EsupportContentHomePage.GetCoveoPageResults()).getText();
					System.out.println("Search results "+result2);
					result1=result.replaceAll("[a-zA-Z\\s]", "");

					int list=Integer.parseInt(result1);

					System.out.println(list);
					List<WebElement> articlecount=driver.findElements(obj_EsupportCoveoPage.CountOfTopSolutionsArticles());
					int upgradecount=articlecount.size();
					upgradescount=String.valueOf(upgradecount);
					System.out.println(upgradecount);


					int count=0;
					for(int i=0;i<upgradecount;i++)
					{
						articlenames=articlenames+" , "+articlecount.get(i).getText();

						System.out.println("part and Accessories Available for upgrade are: " +articlenames);

						count++;
					}
					System.out.println(count);
					if(list==upgradecount)
					{
						Log.info("Test step pass");

					}
					else
					{
						Log.info("test step fail:count don't match");
						Report.put("Click on show more button to see more articles", 
								"User should able to click on show more button and able to see more articles loading untill show more disappears",
								"The content not display in coveo result page <br> or<br> mismatch in article names count"+Report.color(upgradescount)+" and displayed count "+Report.color(result1), "FAIL");
						Assert.fail();
					}
				}
			Report.put("Click on Shop All Product_Name parts and accessories Hyperlink or the -> next to it.", 
					"User should be directed to the Parts & Upgrades for your Product_Name page. The content should display all the parts and Accesories(eg. mouse)available  for upgrade with different compatible specifictaions.",
					"The content successfully display all the articles with count "+Report.color(upgradescount)+" match with their displayed count "+Report.color(result1), "PASS");
		}

		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on show more button to see more articles", 
					"User should able to click on show more button and able to see more articles loading untill show more disappears",
					"user not able to see any content in coveo result page", "FAIL");
			Assert.fail();
		}
	}	

	public void ScrollToVideos(WebDriver driver) 
	{
		Log.info("Entering method ScrollToVideos");
		WebDriverWait  wait = new WebDriverWait(driver, 120);
		String highlightvidoes="";
		String videos="";
		String videossheader="";
		String text1="";
		String text2="";
		Actions act=new Actions(driver);
		try
		{
			//CommonUtility.scrollToViewElement(driver, obj_EsupportCoveoPage.ScrollToVideos());
			if(CommonUtility.CheckpresenceofElementLocated(driver, 30, obj_EsupportCoveoPage.ScrollToVideos()))
			{
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.ScrollToVideos()));
				//				CommonUtility.scrollToViewElement(driver, obj_EsupportCoveoPage.ScrollToVideos());
				CommonUtility.ScrollTo(driver, obj_EsupportCoveoPage.ScrollToVideos());
				videos=CommonUtility.highlightElement(driver, obj_EsupportCoveoPage.ScrollToVideos()).getText();
				System.out.println("title is "+videos);
				//				CommonUtility.highlightElement(driver, obj_EsupportCoveoPage.ScrollToVideos()).click();
				CommonUtility.ClickOn(driver, obj_EsupportCoveoPage.ScrollToVideos());
				Thread.sleep(10000);
				highlightvidoes=CommonUtility.highlightElement(driver, obj_EsupportCoveoPage.ScrollToVideos()).getAttribute("class");
				System.out.println("Class changed from 'nav-link' to "+highlightvidoes);

				if(highlightvidoes.contains("active"))
				{
					Log.info("Test case Pass");
				}
				else
				{
					Log.info("Test case Fail");
					Report.put("On the left rail, scroll to Videos OR click on Videos", 
							"User should see the Videos on the left rail highlighted(bold) and directs to Videos content part of the page. All the available manuals will be displayed under the Videos section of the page",
							"failed to scroll to Videos or failed to display Videos content part of the page", "FAIL");
					Assert.fail();
				}
				videossheader=CommonUtility.highlightElement(driver, obj_EsupportCoveoPage.ValidateVideosHeader()).getText();
				System.out.println("Top solutions hearder "+videossheader);

				//				CommonUtility.scrollToViewElement(driver, obj_EsupportCoveoPage.DescriptionBelowVideos());
				CommonUtility.ScrollTo(driver, obj_EsupportCoveoPage.DescriptionBelowVideos());
				String des=CommonUtility.highlightElement(driver, obj_EsupportCoveoPage.DescriptionBelowVideos()).getText();
				System.out.println("description under videos are "+des);

				//				CommonUtility.scrollToViewElement(driver, obj_EsupportCoveoPage.VideoWindowDisplayed());
				//				CommonUtility.highlightElement(driver, obj_EsupportCoveoPage.VideoWindowDisplayed());


				List<WebElement> list=driver.findElements(obj_EsupportCoveoPage.HeaderAndDateOfPublishUnderVideoWindow());


				for(WebElement lt:list)
				{

					//						CommonUtility.scrollToViewElement(driver, lt);

					act.moveToElement(CommonUtility.highlightElement(driver, lt)).build().perform();
					CommonUtility.highlightElement(driver, lt);
					String text=lt.getText();
					text1+="<br>"+text;

				}

				System.out.println("heading and date of video publish displayed as "+text1);


				//				CommonUtility.scrollToViewElement(driver, obj_EsupportCoveoPage.TitleOfVideoDisplayedUnderVideosSection());
				CommonUtility.ScrollTo(driver, obj_EsupportCoveoPage.TitleOfVideoDisplayedUnderVideosSection());
				String title=CommonUtility.highlightElement(driver, obj_EsupportCoveoPage.TitleOfVideoDisplayedUnderVideosSection()).getText();
				System.out.println("title of video is "+title);

				//				CommonUtility.scrollToViewElement(driver, obj_EsupportCoveoPage.DescriptionUnderTitleOfVideoDisplayed());
				CommonUtility.ScrollTo(driver, obj_EsupportCoveoPage.DescriptionUnderTitleOfVideoDisplayed());
				String description=CommonUtility.highlightElement(driver, obj_EsupportCoveoPage.DescriptionUnderTitleOfVideoDisplayed()).getText();
				System.out.println("description of video is "+description);

				//				CommonUtility.scrollToViewElement(driver, obj_EsupportCoveoPage.DescriptionUnderTitleOfVideoDisplayed());
				CommonUtility.ScrollTo(driver, obj_EsupportCoveoPage.DescriptionUnderTitleOfVideoDisplayed());
				String recc=CommonUtility.highlightElement(driver, obj_EsupportCoveoPage.DescriptionUnderTitleOfVideoDisplayed()).getText();
				System.out.println("recommended videos heading "+recc);

				List<WebElement> list1=driver.findElements(obj_EsupportCoveoPage.RecommendedVideosDisplayedUnderVideosSection());


				for(WebElement lt:list1)
				{

					//						CommonUtility.scrollToViewElement(driver, lt);

					//						act.moveToElement(CommonUtility.highlightElement(driver, lt)).build().perform();
					CommonUtility.scrollToViewElement(driver, lt);
					CommonUtility.highlightElement(driver, lt);
					String text=lt.getText();
					text2+="<br>"+text;

				}

				System.out.println("recommended videos links are "+text2);

				Report.put("On the left rail, scroll to Videos OR click on Videos", 
						"User should see the Videos on the left rail highlighted(bold) and directs to Videos content part of the page. All the available manuals will be displayed under the Videos section of the page",
						"User Successfully see the "+Report.color(videos)+ " on the left rail highlighted and <br> directs to "+Report.color(videossheader)+" and description as "+Report.color(des)+" below videos header <br> and video publish date as "+Report.color(text1)+" <br> and title of viedo "+Report.color(title+" description of video "+description)+" and <br> recommended header "+Report.color(recc+" along with links "+text2)+" on the content part of the page", "PASS");

			}

			else
			{
				System.out.println("video's not found for this product family ");
				Report.put("If there is no video for the selected product", 
						"User should see the following:<br>1. VIDEO should not be displayed on the left rail.2. Video section on the page should not be displayed",
						"Video section not displayed for the selected product/series/tag", "PASS");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("On the left rail, scroll to Videos OR click on Videos", 
					"User should see the Videos on the left rail highlighted(bold) and directs to Videos content part of the page. All the available manuals will be displayed under the Videos section of the page",
					"failed to scroll to Videos or failed to display Videos content part of the page", "FAIL");
			Assert.fail();
		}
	}	

	public void ValidateClickOnSeeVideoTutorials(WebDriver driver) 
	{
		Log.info("Entering method ValidateClickOnSeeVideoTutorials");
		String topscount="";
		String title="";
		String currenturl="";
		int count=0;
		Actions act=new Actions(driver);

		try
		{
			//CommonUtility.scrollToViewElement(driver, obj_EsupportContentHomePage.ValidateManualsAndDocumentsCount());
			if(CommonUtility.CheckpresenceofElementLocated(driver, 30, obj_EsupportCoveoPage.ClickOnSeeVideoTutorials()))
			{

				//				act.moveToElement(CommonUtility.highlightElement(driver, obj_EsupportCoveoPage.ClickOnSeeVideoTutorials())).click().build().perform();
				//				CommonUtility.scrollToViewElement(driver, obj_EsupportCoveoPage.ClickOnSeeVideoTutorials());
				CommonUtility.ScrollTo(driver, obj_EsupportCoveoPage.ClickOnSeeVideoTutorials());
				CommonUtility.highlightElement(driver, obj_EsupportCoveoPage.ClickOnSeeVideoTutorials());

				Thread.sleep(10000);
				String mainwindow=driver.getWindowHandle();
				Set<String> set=driver.getWindowHandles();
				Iterator<String> itr=set.iterator();
				while(itr.hasNext())
				{
					String childWindow=itr.next();
					if(!mainwindow.equals(childWindow))
					{
						driver.switchTo().window(childWindow);
						title=driver.getTitle();

						currenturl=driver.getCurrentUrl();
						if (currenturl.contains("videos"))
						{
							Log.info("Test case pass:videos coveo page opened");
						}
						else
						{
							driver.close();
							Log.info("Test case fail:videos coveo page not opened");
							Report.put("Check for See video tutorials link and Click on See video tutorials link", 
									"See video tutorials link should be available if there are more Videos than displayed.It should navigate to the Coveo results page showing all the Videos available and VIDEOS option selected in the facet. ",
									"See video tutorials link not displayed or video's coveo result page not displayed", "FAIL");
							Assert.fail();
						}
						driver.close();
					}
				}

				driver.switchTo().window(mainwindow);



			}
			Report.put("Check for See video tutorials link and Click on See video tutorials link", 
					"See video tutorials link should be available if there are more Videos than displayed.It should navigate to the Coveo results page showing all the Videos available and VIDEOS option selected in the facet.",
					"User successfully navigated to video coveo result page with title"+Report.color(title)+"<br> in a window and displayed with URL "+Report.color(currenturl), "PASS");

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Check for See video tutorials link and Click on See video tutorials link", 
					"See video tutorials link should be available if there are more Videos than displayed.It should navigate to the Coveo results page showing all the Videos available and VIDEOS option selected in the facet.",
					"See video tutorials link not displayed or video's coveo result page not displayed", "FAIL");
			Assert.fail();
		}
	}
	public void  ValidateSearchForKeyword(WebDriver driver, String SearchOption, String Dpid) 
	{
		Log.info("Entering ValidateSearchForKeyword");   
		
		String keyword1 = TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[0];

		String enteredtext = "";
		String searchresult="";
		String filter="";

		String resourcetype1 = TestNGCreator.TestData.get(Esupport.Dpid.ordinal()).split(";")[0];
		String resourcetype2 = TestNGCreator.TestData.get(Esupport.Dpid.ordinal()).split(";")[1];
		String resourcetype3 = TestNGCreator.TestData.get(Esupport.Dpid.ordinal()).split(";")[2];
		String resourcetype4 = TestNGCreator.TestData.get(Esupport.Dpid.ordinal()).split(";")[3];
		String resourcetype5 = TestNGCreator.TestData.get(Esupport.Dpid.ordinal()).split(";")[4];
		String resourcetype6 = TestNGCreator.TestData.get(Esupport.Dpid.ordinal()).split(";")[5];
		Actions act=new Actions(driver);

		try
		{       
			System.out.println("Inside try of ValidateSearchForKeyword");
			WebDriverWait wait = new WebDriverWait(driver, 120);
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.SearchTextbox()));
			if(CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SearchTextbox()).isDisplayed())
			{
				CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.SearchTextbox());
				CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SearchTextbox()).clear();
				CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SearchTextbox()).sendKeys(keyword1);

				CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.SearchButton2());
				//					act.moveToElement(CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SearchButton())).click().build().perform();
				CommonUtility.ToClickByUsingJavaScript_PassingByLoc(driver,obj_EsupportCoveoPage.SearchButton2());
//				Thread.sleep(10000);
			}
			//			Thread.sleep(10000);
			//			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
				handleCookies(driver);
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.searchSupport()));
				if(driver.getCurrentUrl().contains("Facet"))
				{
					Log.info("test case pass: url contains Facet keyword");
				}
				else
				{
					Log.info("test case fail: url doesnt contains Facet keyword");
					Report.put("Search for keyword 'audio driver' without double quotes", 
							"All Relevant featured results should be displayed belonging to all Resource Types and none of the resource types should be selected by default.", 
							"not landed on coveo page", "FAIL");;
							Assert.fail();
				}
				Thread.sleep(15000);
				CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.KewordValidationInCoveoPage());
				enteredtext=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.KewordValidationInCoveoPage()).getText();
				System.out.println(enteredtext);
//				String keyword2= keyword1.toLowerCase();
//				System.out.println(keyword2);
//				if(enteredtext.contains(keyword1))
//				{
//					Log.info("test case pass: keyword entered is displayed in search of coveo result");
//				}
//				else
//				{
//					Log.info("test case fail: keyword entered is not displayed in search of coveo result");
//					Report.put("Search for keyword 'audio driver' without double quotes", 
//							"All Relevant featured results should be displayed belonging to all Resource Types and none of the resource types should be selected by default.", 
//							"not landed on correct coveo page for searched Keyword "+Report.color(keyword1), "FAIL");;
//							Assert.fail();
//				}
			

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.GetCoveoOverAllSearchResult()));
			searchresult=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.GetCoveoOverAllSearchResult()).getText();
			System.out.println("all result is for entered keyword is "+searchresult);
			handleCookies(driver);
			List<WebElement> resourcetypelist=driver.findElements(obj_EsupportCoveoPage.ValidateResourceTypeIsSelected());
			int resourcetypecount=resourcetypelist.size();
			System.out.println("total number of resources displayed are "+resourcetypecount);

			for(int i=0; i<resourcetypecount;i++)
			{
				if(CommonUtility.highlightElement(driver,resourcetypelist.get(i)).isSelected())
				{
					Log.info("test case fail: resource types selected");
					Report.put("Search for keyword 'audio driver' without double quotes", 
							"All Relevant featured results should be displayed belonging to all Resource Types and none of the resource types should be selected by default.", 
							"Any of Resource Type is selected by default", "FAIL");;
							Assert.fail();
				}
			}

			String filterheader=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ValidateFiltersSectionHeader()).getText();
			System.out.println("header is "+filterheader);

			List<WebElement> getallfilters=driver.findElements(obj_EsupportCoveoPage.GetAllFilters());
			int totalfilterscount=getallfilters.size();
			System.out.println("total count of selected filters "+totalfilterscount);

			for(int j=0;j<totalfilterscount;j++)
			{
				filter+=",<br>"+getallfilters.get(j).getText();
				System.out.println("filters displayed are "+filter);

				if (filter.contains(resourcetype1) || filter.contains(resourcetype2)|| filter.contains(resourcetype3)|| filter.contains(resourcetype4)|| filter.contains(resourcetype5)|| filter.contains(resourcetype6))
				{
					Log.info("test case fail: resource types displayed under your filters section");
					Report.put("Search for keyword 'audio driver' with out double quotes", 
							"All Relevant featured results should be displayed belonging to all Resource Types and none of the resource types should be selected by default.", 
							"Any of Resource Type "+Report.color(filter)+" is displayed by default under heading "+Report.color(filterheader), "FAIL");;
							Assert.fail();
				}

			}

			Report.put("Search for keyword 'audio driver' without double quotes", 
					"All Relevant featured results should be displayed belonging to all Resource Types and none of the resource types should be selected by default.", 
					"keyword "+Report.color(keyword1)+" searched Successfully.<br> and all relevant results displayed with result count of "+Report.color(searchresult)+"<br> and filters displayed under "+Report.color(filterheader)+" are <br> "+Report.color(filter), "PASS");

			Thread.sleep(3000);                     
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Search for keyword 'audio driver' without double quotes", 
					"All Relevant featured results should be displayed belonging to all Resource Types and none of the resource types should be selected by default.", 
					"coveo search results display with default selected any of resource type or not landed on searched keyword coveo search result page", "FAIL");;
					Assert.fail();
		}
	}

	public void  SelectDellSupportVideos(WebDriver driver, String Dpid) 
	{
		Log.info("Entering SelectDellSupportVideos");   
		WebDriverWait wait = new WebDriverWait(driver, 120);

		String enteredtext = "";
		String searchresult="";
		String filter="";
		String result="";
		String attr="";
		String title="";
		String currenturl="";
		String resourcetype1 = TestNGCreator.TestData.get(Esupport.Dpid.ordinal()).split(";")[0];
		Actions act=new Actions(driver);


		try
		{       
			Log.info("Inside try of SelectDellSupportVideos");
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.ClickOnDellSupportVideosResourceType()));
			CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.ClickOnDellSupportVideosResourceType());
			if(CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ClickOnDellSupportVideosResourceType()).isDisplayed())
			{
//				CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.ClickOnDellSupportVideosResourceType());
				//					CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ClickOnDellSupportVideosResourceType()).click();
				//					act.moveToElement(CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ClickOnDellSupportVideosResourceType())).click().build().perform();
				CommonUtility.ClickOn(driver, obj_EsupportCoveoPage.ClickOnDellSupportVideosResourceType());
				Thread.sleep(10000);
			}

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.GetCoveoOverAllSearchResult()));
			searchresult=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.GetCoveoOverAllSearchResult()).getText();
			System.out.println("all result is for entered keyword is "+searchresult);



			String filterheader=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ValidateFiltersSectionHeader()).getText();
			System.out.println("header is "+filterheader);

			List<WebElement> getallfilters=driver.findElements(obj_EsupportCoveoPage.GetAllFilters());
			int totalfilterscount=getallfilters.size();
			System.out.println("total count of selected filters "+totalfilterscount);

			for(int j=0;j<totalfilterscount;j++)
			{
				filter+=",<br>"+getallfilters.get(j).getText();
				System.out.println("filters displayed are "+filter);

				if (filter.contains(resourcetype1))
				{
					Log.info("test case pass: resource types dell support videos displayed under your filter section");
				}
				else
				{
					Log.info("test case fail: resource types dell support videos not displayed under your filter section");
					Report.put("Select the resource type 'Dell Support Videos'", 
							"Only the results belonging to Dell Support Videos should be shown. No other results of other resource type should be shown. Observe the Icon displayed with the result as well. It should be same. Open few results and verify.", 
							"for Resource Type "+Report.color(filter)+" is not displayed by under heading "+Report.color(filterheader), "FAIL");;
							Assert.fail();
				}

			}

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.CoveoResultSection()));

			List<WebElement> listofresultsdisplayed=driver.findElements(obj_EsupportCoveoPage.CountOfDisplayedResults());
			int countofresultsdisplayed=listofresultsdisplayed.size();
			System.out.println("total number of results displayed are "+countofresultsdisplayed);

			for(int i=0; i<countofresultsdisplayed;i++)
			{
				result+=",<br>"+listofresultsdisplayed.get(i).getText();
				System.out.println("displayed result on clicking resource type dell support video are "+result);
			}

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.VideoIconValidation()));

			List<WebElement> videoiconlist=driver.findElements(obj_EsupportCoveoPage.VideoIconValidation());
			int videoiconcount=videoiconlist.size();
			System.out.println("total number of video icons displayed are "+videoiconcount);

			for(int k=0; k<videoiconcount;k++)
			{
				attr+="<br>"+videoiconlist.get(k).getAttribute("title");
				System.out.println("title displayed is "+attr);
//				if(attr.contains("Videos"))
//				{
//					Log.info("test case pass: Videos icon displayed on selecting dell support videos");
//				}
//				else
//				{
//					Log.info("test case fail: Videos icon not displayed on selecting dell support videos in result");
//					Report.put("Select the resource type 'Dell Support Videos'", 
//							"Only the results belonging to Dell Support Videos should be shown. No other results of other resource type should be shown. Observe the Icon displayed with the result as well. It should be same. Open few results and verify.", 
//							"for Resource Type "+Report.color(resourcetype1)+" videos icon is not displayed", "FAIL");;
//							Assert.fail();
//				}
			}

			//				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.ClickOnFirstResult()));
			//			CommonUtility.scrollToViewElement(driver,obj_EsupportCoveoPage.ClickOnFirstResult());
			//			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ClickOnFirstResult()).click();
			CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.ClickOnFirstResult());
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);

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
					Thread.sleep(7000);
					title=driver.getTitle();
					System.out.println(title);
					currenturl=driver.getCurrentUrl();
					System.out.println(currenturl);

					Thread.sleep(30000);
					//						if (currenturl.contains("videos"))
					//						{
					//							Log.info("Test case pass:videos content page opened");
					//						}
					//						else
					//						{
					//							Thread.sleep(30000);
					//							driver.close();
					//							Log.info("Test case fail:videos content page not opened");
					//							Report.put("Select the resource type 'Dell Support Videos'", 
					//									"Only the results belonging to Dell Support Videos should be shown. No other results of other resource type should be shown. Observe the Icon displayed with the result as well. It should be same. Open few results and verify.", 
					//									"content page not opened in seperate window on clicking coveo results displayed for keyword search", "FAIL");
					//							Assert.fail();
					//						}
					driver.close();
				}
			}

			driver.switchTo().window(mainwindow);

			//				driver.switchTo().window(mainwindow);
			//wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.ClearFilters()));
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.ClearFilters());

			//			CommonUtility.scrollToViewElement(driver,obj_EsupportCoveoPage.ClearFilters());
			//			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ClearFilters()).click();
			CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.ClearFilters());
			Thread.sleep(10000);
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			Report.put("Select the resource type 'Dell Support Videos'", 
					"Only the results belonging to Dell Support Videos should be shown. No other results of other resource type should be shown. Observe the Icon displayed with the result as well. It should be same. Open few results and verify.",
					"User able to see Only the results belonging to "+Report.color(resourcetype1)+"<br> and Icon displayed is <br> "+Report.color(attr)+"<br> and clicked on first result displayed and able to see title of page as "+Report.color(title)+" <br> and url of page is <br> "+Report.color(currenturl), "PASS");

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Select the resource type 'Dell Support Videos'", 
					"Only the results belonging to Dell Support Videos should be shown. No other results of other resource type should be shown. Observe the Icon displayed with the result as well. It should be same. Open few results and verify.",
					"not able to see only selected resource type filtered or not able to navigate to content page clicking on coveo results displayed", "FAIL");;
					Assert.fail();
		}
	}

	public void  SelectKnowledgebase(WebDriver driver, String Dpid) 
	{
		Log.info("Entering SelectKnowledgebase");   
		WebDriverWait wait = new WebDriverWait(driver, 120);

		String enteredtext = "";
		String searchresult="";
		String filter="";
		String result="";
		String attr="";
		String title="";
		String currenturl="";
		String resourcetype2 = TestNGCreator.TestData.get(Esupport.Dpid.ordinal()).split(";")[1];
		Actions act= new Actions(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		try
		{       
			Log.info("Inside try of SelectKnowledgebase");
			//wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.KnowledgeBaseClick()));
			//Lavanya added implicit wait to click below element
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			js.executeScript("window.scrollBy(0,250)", "");
			CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.KnowledgeBaseClick());
			if(CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.KnowledgeBaseClick()).isDisplayed())
			{
				CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.KnowledgeBaseClick());
				Thread.sleep(5000);
				//					CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.KnowledgeBaseClick()).click();
				//				act.moveToElement(CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.KnowledgeBaseClick())).click().build().perform();
				CommonUtility.ClickOn(driver, obj_EsupportCoveoPage.KnowledgeBaseClick());
				Thread.sleep(10000);
			}
			handleCookies(driver);
//			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.GetCoveoOverAllSearchResult()));
//			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			//			CommonUtility.scrollToViewElement(driver,obj_EsupportCoveoPage.GetCoveoOverAllSearchResult());
			CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.GetCoveoOverAllSearchResult());

			searchresult=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.GetCoveoOverAllSearchResult()).getText();
			System.out.println("all result is for entered keyword and selected resource type is "+searchresult);



			String filterheader=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ValidateFiltersSectionHeader()).getText();
			System.out.println("header is "+filterheader);

			List<WebElement> getallfilters=driver.findElements(obj_EsupportCoveoPage.GetAllFilters());
			int totalfilterscount=getallfilters.size();
			System.out.println("total count of selected filters "+totalfilterscount);

			for(int j=0;j<totalfilterscount;j++)
			{
				filter+=",<br>"+getallfilters.get(j).getText();
				System.out.println("filters displayed are "+filter);

				if (filter.contains(resourcetype2))
				{
					Log.info("test case pass: resource types knowledgebase displayed under your filter section");
				}
				else
				{
					Log.info("test case fail: resource types knowledge base not displayed under your filter section");
					Report.put("Select the resource type 'knowledge base'", 
							"All featured results belonging to resource type should be shown displayed. Observe the Icon of every result. Open few results and verify.", 
							"for Resource Type "+Report.color(filter)+" is not displayed by under heading "+Report.color(filterheader), "FAIL");;
							Assert.fail();
				}

			}

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.CoveoResultSection()));

			List<WebElement> listofresultsdisplayed=driver.findElements(obj_EsupportCoveoPage.CountOfDisplayedResults());
			int countofresultsdisplayed=listofresultsdisplayed.size();
			System.out.println("total number of results displayed are "+countofresultsdisplayed);

			for(int i=0; i<countofresultsdisplayed;i++)
			{
				result+=",<br>"+listofresultsdisplayed.get(i).getText();
				System.out.println("displayed result on clicking resource type knowledgebase are "+result);
			}

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.KnowledgeBaseIconValidation()));

			List<WebElement> knowledgebaseiconlist=driver.findElements(obj_EsupportCoveoPage.KnowledgeBaseIconValidation());
			int knowledgebaseiconcount=knowledgebaseiconlist.size();
			System.out.println("total number of video icons displayed are "+knowledgebaseiconcount);

			for(int k=0; k<knowledgebaseiconcount;k++)
			{
				attr+="<br>"+knowledgebaseiconlist.get(k).getText();
				System.out.println("title displayed is "+attr);
				if(attr.contains("Knowledgebase") || attr.contains("KNOWLEDGEBASE"))
				{
					Log.info("test case pass: Knowledgebase icon displayed on selecting Knowledgebase resource type");
				}
				else
				{
					Log.info("test case fail:Knowledgebase icon not displayed on selecting Knowledgebase in result");
					Report.put("Select the resource type 'knowledge base'", 
							"All featured results belonging to resource type should be shown displayed. Observe the Icon of every result. Open few results and verify.", 
							"for Resource Type "+Report.color(resourcetype2)+" Knowledgebase icon is not displayed", "FAIL");;
							Assert.fail();
				}
			}

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.ClickOnFirstResult()));
			//			CommonUtility.scrollToViewElement(driver,obj_EsupportCoveoPage.ClickOnFirstResult());
			//			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ClickOnFirstResult()).click();
			CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.ClickOnFirstResult());

			Thread.sleep(10000);
			String mainwindow=driver.getWindowHandle();
			Set<String> set=driver.getWindowHandles();
			Iterator<String> itr=set.iterator();
			while(itr.hasNext())
			{
				String childWindow=itr.next();
				if(!mainwindow.equals(childWindow))
				{
					driver.switchTo().window(childWindow);
					title=title+" ,<br> "+driver.getTitle();
					System.out.println(driver.switchTo().window(childWindow).getTitle());
					System.out.println(driver.switchTo().window(childWindow).getCurrentUrl());
					currenturl=currenturl+" ,<br> "+driver.getCurrentUrl();
					if (currenturl.contains("Facet"))
					{
						Log.info("Test case pass:Knowledgebase content page opened");
					}
					else
					{
						driver.close();
						Log.info("Test case fail:Knowledgebase content page not opened");
						Report.put("Select the resource type 'knowledge base'", 
								"All featured results belonging to resource type should be shown displayed. Observe the Icon of every result. Open few results and verify.", 
								"content page not opened in seperate window on clicking coveo results displayed for keyword search", "FAIL");
						Assert.fail();
					}
					driver.close();
				}
			}

			driver.switchTo().window(mainwindow);
			//wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.ClearFilters()));
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			//			CommonUtility.scrollToViewElement(driver,obj_EsupportCoveoPage.ClearFilters());

			//			CommonUtility.scrollToViewElement(driver,obj_EsupportCoveoPage.ClearFilters());
			//			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ClearFilters()).click();
			CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.ClearFilters());
			Thread.sleep(10000);

			Report.put("Select the resource type 'knowledge base'", 
					"All featured results belonging to resource type should be shown displayed. Observe the Icon of every result. Open few results and verify.", 
					"User able to see Only the results belonging to "+Report.color(resourcetype2)+"<br> and Icon displayed is <br> "+Report.color(attr)+"<br> and clicked on first result displayed and able to see title of page as "+Report.color(title)+" <br> and url of page is <br> "+Report.color(currenturl), "PASS");

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Select the resource type 'knowledge base'", 
					"All featured results belonging to resource type should be shown displayed. Observe the Icon of every result. Open few results and verify.", 
					"not able to see only selected resource type filtered or not able to navigate to content page clicking on coveo results displayed", "FAIL");
			Assert.fail();
		}
	}

	public void  ValidateSearchForKeyword2(WebDriver driver, String SearchOption, String Dpid) 
	{
		Log.info("Entering ValidateSearchForKeyword2");   
		WebDriverWait wait = new WebDriverWait(driver, 120);
		String keyword2 = TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[1];

		String enteredtext = "";
		String searchresult="";
		String filter="";

		String resourcetype1 = TestNGCreator.TestData.get(Esupport.Dpid.ordinal()).split(";")[0];
		String resourcetype2 = TestNGCreator.TestData.get(Esupport.Dpid.ordinal()).split(";")[1];
		String resourcetype3 = TestNGCreator.TestData.get(Esupport.Dpid.ordinal()).split(";")[2];
		String resourcetype4 = TestNGCreator.TestData.get(Esupport.Dpid.ordinal()).split(";")[3];
		String resourcetype5 = TestNGCreator.TestData.get(Esupport.Dpid.ordinal()).split(";")[4];
		String resourcetype6 = TestNGCreator.TestData.get(Esupport.Dpid.ordinal()).split(";")[5];

		try
		{       
			Thread.sleep(15000);
			System.out.println("Inside try of ValidateSearchForKeyword2");
			//wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.SearchTextbox()));
//			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.SearchTextbox());
			if(CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SearchTextbox()).isDisplayed())
			{
				CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SearchTextbox()).clear();
				CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SearchTextbox()).sendKeys(keyword2);

				//				CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SearchButton()).click();
				CommonUtility.ToClickByUsingJavaScript_PassingByLoc(driver,obj_EsupportCoveoPage.SearchButton2());
				Thread.sleep(5000);
			}

			if(CommonUtility.CheckpresenceofElementLocated(driver,10,obj_EsupportCoveoPage.searchSupport()))
			{
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.searchSupport()));
				if(driver.getCurrentUrl().contains("Facet"))
				{
					Log.info("test case pass: url contains Facet keyword");
				}
				else
				{
					Log.info("test case fail: url doesnt contains Facet keyword");
					Report.put("Search for keyword 'audio driver' without double quotes", 
							"All Relevant featured results should be displayed belonging to all Resource Types and none of the resource types should be selected by default.", 
							"not landed on coveo page", "FAIL");;
							Assert.fail();
				}
				enteredtext=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.KewordValidationInCoveoPage()).getText();
				if(enteredtext.contains(keyword2))
				{
					Log.info("test case pass: keyword entered is displayed in search of coveo result");
				}
				else
				{
					Log.info("test case fail: keyword entered is not displayed in search of coveo result");
					Report.put("Search for keyword 'audio driver' without double quotes", 
							"All Relevant featured results should be displayed belonging to all Resource Types and none of the resource types should be selected by default.", 
							"not landed on correct coveo page for searched Keyword "+Report.color(keyword2), "FAIL");;
							Assert.fail();
				}
			}
			else
			{
				CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.SearchButton2());

				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.searchSupport()));
				if(driver.getCurrentUrl().contains("Facet"))
				{
					Log.info("test case pass: url contains Facet keyword");
				}
				else
				{
					Log.info("test case fail: url doesnt contains Facet keyword");
					Report.put("Search for keyword 'audio driver' without double quotes", 
							"All Relevant featured results should be displayed belonging to all Resource Types and none of the resource types should be selected by default.", 
							"not landed on coveo page", "FAIL");;
							Assert.fail();
				}
				enteredtext=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.KewordValidationInCoveoPage()).getText();
				if(enteredtext.contains(keyword2))
				{
					Log.info("test case pass: keyword entered is displayed in search of coveo result");
				}
				else
				{
					Log.info("test case fail: keyword entered is not displayed in search of coveo result");
					Report.put("Search for keyword 'audio driver' without double quotes", 
							"All Relevant featured results should be displayed belonging to all Resource Types and none of the resource types should be selected by default.", 
							"not landed on correct coveo page for searched Keyword "+Report.color(keyword2), "FAIL");;
							Assert.fail();
				}

			}
			//			if(driver.getCurrentUrl().contains("Facet"))
			//			{
			//				Log.info("test case pass: url contains Facet keyword");
			//			}
			//			else
			//			{
			//				Log.info("test case fail: url doesnt contains Facet keyword");
			//				Report.put("Scenario 2 : Enter keyword 'touchpad' in masthead and click Search button.", 
			//						"All Relevant featured results should be displayed of all resource types. None of the resource types should be selected.", 
			//						"not landed on coveo page", "FAIL");;
			//						Assert.fail();
			//			}
			//			enteredtext=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.KewordValidationInCoveoPage()).getText();
			//			if(enteredtext.equalsIgnoreCase(keyword2))
			//			{
			//				Log.info("test case pass: keyword entered is displayed in search of coveo result");
			//			}
			//			else
			//			{
			//				Log.info("test case fail: keyword entered is not displayed in search of coveo result");
			//				Report.put("Scenario 2 : Enter keyword 'touchpad' in masthead and click Search button.", 
			//						"All Relevant featured results should be displayed of all resource types. None of the resource types should be selected.", 
			//						"not landed on correct coveo page for searched Keyword "+Report.color(keyword2), "FAIL");;
			//						Assert.fail();
			//			}

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.GetCoveoOverAllSearchResult()));
			searchresult=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.GetCoveoOverAllSearchResult()).getText();
			System.out.println("all result is for entered keyword is "+searchresult);

			List<WebElement> resourcetypelist=driver.findElements(obj_EsupportCoveoPage.ValidateResourceTypeIsSelected());
			int resourcetypecount=resourcetypelist.size();
			System.out.println("total number of resources displayed are "+resourcetypecount);
			try
			{

				for(int i=0; i<resourcetypecount;i++)
				{
					if(CommonUtility.highlightElement(driver,resourcetypelist.get(i)).isSelected())
					{
						Log.info("test case fail: resource types selected");
						Report.put("Scenario 2 : Enter keyword 'touchpad' in masthead and click Search button.", 
								"All Relevant featured results should be displayed of all resource types. None of the resource types should be selected.",  
								"Any of Resource Type is selected by default", "FAIL");;
								Assert.fail();
					}
				}
			}
			catch(Exception e)
			{

			}

			String filterheader=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ValidateFiltersSectionHeader()).getText();
			System.out.println("header is "+filterheader);

			List<WebElement> getallfilters=driver.findElements(obj_EsupportCoveoPage.GetAllFilters());
			int totalfilterscount=getallfilters.size();
			System.out.println("total count of selected filters "+totalfilterscount);

			for(int j=0;j<totalfilterscount;j++)
			{
				filter+=",<br>"+getallfilters.get(j).getText();
				System.out.println("filters displayed are "+filter);

				if (filter.contains(resourcetype1) || filter.contains(resourcetype2)|| filter.contains(resourcetype3)|| filter.contains(resourcetype4)|| filter.contains(resourcetype5)|| filter.contains(resourcetype6))
				{
					Log.info("test case fail: resource types displayed under your filters section");
					Report.put("Scenario 2 : Enter keyword 'touchpad' in masthead and click Search button.", 
							"All Relevant featured results should be displayed of all resource types. None of the resource types should be selected.",  
							"Any of Resource Type "+Report.color(filter)+" is displayed by default under heading "+Report.color(filterheader), "FAIL");;
							Assert.fail();
				}

			}

			Report.put("Scenario 2 : Enter keyword 'touchpad' in masthead and click Search button.", 
					"All Relevant featured results should be displayed of all resource types. None of the resource types should be selected.",  
					"keyword "+Report.color(keyword2)+" searched Successfully.<br> and all relevant results displayed with result count of "+Report.color(searchresult)+"<br> and filters displayed under "+Report.color(filterheader)+" are <br> "+Report.color(filter), "PASS");

			Thread.sleep(3000);                     
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Scenario 2 : Enter keyword 'touchpad' in masthead and click Search button.", 
					"All Relevant featured results should be displayed of all resource types. None of the resource types should be selected.",  
					"coveo search results display with default selected any of resource type or not landed on searched keyword coveo search result page", "FAIL");;
					Assert.fail();
		}
	}
	public void  SelectDellSupportByTopic(WebDriver driver, String Dpid) 
	{
		Log.info("Entering SelectDellSupportByTopic");   
		WebDriverWait wait = new WebDriverWait(driver, 120);

		String enteredtext = "";
		String searchresult="";
		String filter="";
		String result="";
		String attr="";
		String title="";
		String currenturl="";
		String resourcetype3 = TestNGCreator.TestData.get(Esupport.Dpid.ordinal()).split(";")[2];
		Actions act=new Actions(driver);

		try
		{       
			Log.info("Inside try of SelectDellSupportByTopic");
//			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.SuportByTopicClick()));

			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.SuportByTopicClick());
			if(CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SuportByTopicClick()).isDisplayed())
			{
				CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.SuportByTopicClick());
				//					act.moveToElement(CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SuportByTopicClick())).click().build().perform();
				CommonUtility.ClickOn(driver, obj_EsupportCoveoPage.SuportByTopicClick());
				Thread.sleep(10000);
			}

			//wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.GetCoveoOverAllSearchResult()));
			CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.GetCoveoOverAllSearchResult());
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			searchresult=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.GetCoveoOverAllSearchResult()).getText();
			System.out.println("all result is for entered keyword is "+searchresult);



			String filterheader=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ValidateFiltersSectionHeader()).getText();
			System.out.println("header is "+filterheader);

			List<WebElement> getallfilters=driver.findElements(obj_EsupportCoveoPage.GetAllFilters());
			int totalfilterscount=getallfilters.size();
			System.out.println("total count of selected filters "+totalfilterscount);

			for(int j=0;j<totalfilterscount;j++)
			{
				filter+=",<br>"+getallfilters.get(j).getText();
				System.out.println("filters displayed are "+filter);

				if (filter.contains(resourcetype3))
				{
					Log.info("test case pass: resource types dell support by topic displayed under your filter section");
				}
				else
				{
					Log.info("test case fail: resource types dell support by topic not displayed under your filter section");
					Report.put("Click on 'Dell Support by Topic' option from the facet.", 
							"The result set should get refreshed and display only result set belonging to resource type 'Support by Topic'.", 
							"for Resource Type "+Report.color(filter)+" is not displayed by under heading "+Report.color(filterheader), "FAIL");;
							Assert.fail();
				}

			}

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.CoveoResultSection()));

			List<WebElement> listofresultsdisplayed=driver.findElements(obj_EsupportCoveoPage.CountOfDisplayedResults());
			int countofresultsdisplayed=listofresultsdisplayed.size();
			System.out.println("total number of results displayed are "+countofresultsdisplayed);

			for(int i=0; i<countofresultsdisplayed;i++)
			{
				result+=",<br>"+listofresultsdisplayed.get(i).getText();
				System.out.println("displayed result on clicking resource type dell Support by Topic are "+result);
			}

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.SuportByTopicIconValidation()));

			List<WebElement> videoiconlist=driver.findElements(obj_EsupportCoveoPage.SuportByTopicIconValidation());
			int videoiconcount=videoiconlist.size();
			System.out.println("total number of Support by Topic icons displayed are "+videoiconcount);

			for(int k=0; k<videoiconcount;k++)
			{
				attr+="<br>"+videoiconlist.get(k).getText();
				System.out.println("title displayed is "+attr);
				if(attr.contains("Support by Topic") || attr.contains("SUPPORT BY TOPIC"))
				{
					Log.info("test case pass: Support by Topic icon displayed on selecting dell Support by Topic");
				}
				else
				{
					Log.info("test case fail: Support by Topic icon not displayed on selecting dell Support by Topic in result");
					Report.put("Click on 'Dell Support by Topic' option from the facet.", 
							"The result set should get refreshed and display only result set belonging to resource type 'Support by Topic'.",  
							"for Resource Type "+Report.color(resourcetype3)+" Support by Topic icon is not displayed", "FAIL");;
							Assert.fail();
				}
			}

			//wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.ClearFilters()));
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			//			CommonUtility.scrollToViewElement(driver,obj_EsupportCoveoPage.ClearFilters());

			//			CommonUtility.scrollToViewElement(driver,obj_EsupportCoveoPage.ClearFilters());
			//			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ClearFilters()).click();
			CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.ClearFilters());
			Thread.sleep(10000);

			Report.put("Click on 'Dell Support by Topic' option from the facet.", 
					"The result set should get refreshed and display only result set belonging to resource type 'Support by Topic'.", 
					"User able to see Only the results belonging to "+Report.color(resourcetype3)+"<br> and Icon displayed is <br> "+Report.color(attr), "PASS");

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on 'Dell Support by Topic' option from the facet.", 
					"The result set should get refreshed and display only result set belonging to resource type 'Support by Topic'.",
					"not able to see only selected resource type filtered", "FAIL");;
					Assert.fail();
		}
	}

	public void  SelectKnowledgebaseForKeyword2(WebDriver driver, String Dpid) 
	{
		Log.info("Entering SelectKnowledgebaseForKeyword2");   
		WebDriverWait wait = new WebDriverWait(driver, 120);

		String enteredtext = "";
		String searchresult="";
		String filter="";
		String result="";
		String attr="";
		String title="";
		String currenturl="";
		String resourcetype2 = TestNGCreator.TestData.get(Esupport.Dpid.ordinal()).split(";")[1];
		Actions act=new Actions(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		try
		{       
			Log.info("Inside try of SelectKnowledgebaseForKeyword2");
			//wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.KnowledgeBaseClick()));
			//Lavanya added implicit wait to click below element
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
			js.executeScript("window.scrollBy(0,250)", "");
			CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.KnowledgeBaseClick());
			if(CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.KnowledgeBaseClick()).isDisplayed())
			{
				CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.KnowledgeBaseClick());
				//				act.moveToElement(CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.KnowledgeBaseClick())).click().build().perform();
				CommonUtility.ClickOn(driver, obj_EsupportCoveoPage.KnowledgeBaseClick());
				Thread.sleep(10000);
			}

			//wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.GetCoveoOverAllSearchResult()));
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.GetCoveoOverAllSearchResult());
			searchresult=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.GetCoveoOverAllSearchResult()).getText();
			System.out.println("all result is for entered keyword and selected resource type is "+searchresult);



			String filterheader=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ValidateFiltersSectionHeader()).getText();
			System.out.println("header is "+filterheader);

			List<WebElement> getallfilters=driver.findElements(obj_EsupportCoveoPage.GetAllFilters());
			int totalfilterscount=getallfilters.size();
			System.out.println("total count of selected filters "+totalfilterscount);

			for(int j=0;j<totalfilterscount;j++)
			{
				filter+=",<br>"+getallfilters.get(j).getText();
				System.out.println("filters displayed are "+filter);

				if (filter.contains(resourcetype2))
				{
					Log.info("test case pass: resource types knowledgebase displayed under your filter section");
				}
				else
				{
					Log.info("test case fail: resource types knowledge base not displayed under your filter section");
					Report.put("Click on 'Knowledge Base' option from the facet.", 
							"The result set should get refreshed and display only result set belonging to resource type 'Knowledge base'.", 
							"for Resource Type "+Report.color(filter)+" is not displayed by under heading "+Report.color(filterheader), "FAIL");;
							Assert.fail();
				}

			}

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.CoveoResultSection()));

			List<WebElement> listofresultsdisplayed=driver.findElements(obj_EsupportCoveoPage.CountOfDisplayedResults());
			int countofresultsdisplayed=listofresultsdisplayed.size();
			System.out.println("total number of results displayed are "+countofresultsdisplayed);

			for(int i=0; i<countofresultsdisplayed;i++)
			{
				result+=",<br>"+listofresultsdisplayed.get(i).getText();
				System.out.println("displayed result on clicking resource type knowledgebase are "+result);
			}

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.KnowledgeBaseIconValidation()));

			List<WebElement> knowledgebaseiconlist=driver.findElements(obj_EsupportCoveoPage.KnowledgeBaseIconValidation());
			int knowledgebaseiconcount=knowledgebaseiconlist.size();
			System.out.println("total number of video icons displayed are "+knowledgebaseiconcount);

			for(int k=0; k<knowledgebaseiconcount;k++)
			{
				attr+="<br>"+knowledgebaseiconlist.get(k).getText();
				System.out.println("title displayed is "+attr);
				if(attr.contains("Knowledgebase") || attr.contains("KNOWLEDGEBASE"))
				{
					Log.info("test case pass: Knowledgebase icon displayed on selecting Knowledgebase resource type");
				}
				else
				{
					Log.info("test case fail:Knowledgebase icon not displayed on selecting Knowledgebase in result");
					Report.put("Click on 'Knowledge Base' option from the facet.", 
							"The result set should get refreshed and display only result set belonging to resource type 'Knowledge base'.", 
							"for Resource Type "+Report.color(resourcetype2)+" knowledgebase icon is not displayed", "FAIL");;
							Assert.fail();
				}
			}

			//wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.ClearFilters()));
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			//			CommonUtility.scrollToViewElement(driver,obj_EsupportCoveoPage.ClearFilters());

			//			CommonUtility.scrollToViewElement(driver,obj_EsupportCoveoPage.ClearFilters());
			//			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ClearFilters()).click();
			CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.ClearFilters());
			Thread.sleep(10000);

			Report.put("Click on 'Knowledge Base' option from the facet.", 
					"The result set should get refreshed and display only result set belonging to resource type 'Knowledge base'.",  
					"User able to see Only the results belonging to "+Report.color(resourcetype2)+"<br> and Icon displayed is <br> "+Report.color(attr), "PASS");

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on 'Knowledge Base' option from the facet.", 
					"The result set should get refreshed and display only result set belonging to resource type 'Knowledge base'.", 
					"not able to see only selected resource type filtered", "FAIL");
			Assert.fail();
		}
	}
	public void  SelectManualsAndDocuments(WebDriver driver, String Dpid) 
	{
		Log.info("Entering SelectManualsAndDocuments");   
		WebDriverWait wait = new WebDriverWait(driver, 120);

		String enteredtext = "";
		String searchresult="";
		String filter="";
		String result="";
		String attr="";
		String title="";
		String currenturl="";
		String resourcetype6 = TestNGCreator.TestData.get(Esupport.Dpid.ordinal()).split(";")[5];
		Actions act=new Actions(driver);

		try
		{       
			Log.info("Inside try of SelectManualsAndDocuments");
			//wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.ManualDocumentationClick()));
			//Lavanya added implicit wait to click below element
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
//			Thread.sleep(7000);
			CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.ManualDocumentationClick());
			if(CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ManualDocumentationClick()).isDisplayed())
			{
//				CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.ManualDocumentationClick());
				//					CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ManualDocumentationClick()).click();
				//				act.moveToElement(CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ManualDocumentationClick())).click().build().perform();
				CommonUtility.ClickOn(driver, obj_EsupportCoveoPage.ManualDocumentationClick());
				Thread.sleep(10000);
			}

			//wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.GetCoveoOverAllSearchResult()));
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			Thread.sleep(7000);
			CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.GetCoveoOverAllSearchResult());
			searchresult=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.GetCoveoOverAllSearchResult()).getText();
			System.out.println("all result is for entered keyword and selected resource type is "+searchresult);



			String filterheader=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ValidateFiltersSectionHeader()).getText();
			System.out.println("header is "+filterheader);

			List<WebElement> getallfilters=driver.findElements(obj_EsupportCoveoPage.GetAllFilters());
			int totalfilterscount=getallfilters.size();
			System.out.println("total count of selected filters "+totalfilterscount);

			for(int j=0;j<totalfilterscount;j++)
			{
				filter+=",<br>"+getallfilters.get(j).getText();
				System.out.println("filters displayed are "+filter);

				if (filter.contains(resourcetype6))
				{
					Log.info("test case pass: resource types Manuals And Documents displayed under your filter section");
				}
				else
				{
					Log.info("test case fail: resource types Manuals And Documents not displayed under your filter section");
					Report.put("Click on any other facet.", 
							"The result set should get refreshed and display only result set belonging to that resource type only. Results belonging to other resource type shouldn't get displayed.", 
							"Resource Type selected is "+Report.color(resourcetype6)+" and for Resource Type "+Report.color(filter)+" is not displayed by under heading "+Report.color(filterheader), "FAIL");;
//							Assert.fail();
				}

			}

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.CoveoResultSection()));

			List<WebElement> listofresultsdisplayed=driver.findElements(obj_EsupportCoveoPage.CountOfDisplayedResults());
			int countofresultsdisplayed=listofresultsdisplayed.size();
			System.out.println("total number of results displayed are "+countofresultsdisplayed);

			for(int i=0; i<countofresultsdisplayed;i++)
			{
				result+=",<br>"+listofresultsdisplayed.get(i).getText();
				System.out.println("displayed result on clicking resource type Manuals And Documents are "+result);
			}

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.ManualsAndDocumentsIconValidation()));

			List<WebElement> knowledgebaseiconlist=driver.findElements(obj_EsupportCoveoPage.ManualsAndDocumentsIconValidation());
			int knowledgebaseiconcount=knowledgebaseiconlist.size();
			System.out.println("total number of video icons displayed are "+knowledgebaseiconcount);

			for(int k=0; k<knowledgebaseiconcount;k++)
			{
				attr+="<br>"+knowledgebaseiconlist.get(k).getText();
				System.out.println("title displayed is "+attr);
				if(attr.contains("Manuals") || attr.contains("MANUALS"))
				{
					Log.info("test case pass: Manuals And Documents icon displayed on selecting Manuals And Documents resource type");
				}
				else
				{
					Log.info("test case fail: Manuals And Documents icon not displayed on selecting Manuals And Documents in result");
					Report.put("Click on any other facet.", 
							"The result set should get refreshed and display only result set belonging to that resource type only. Results belonging to other resource type shouldn't get displayed.", 
							"Resource Type selected is "+Report.color(resourcetype6)+" Manuals And Documents icon is not displayed", "FAIL");;
							Assert.fail();
				}
			}

			Report.put("Click on any other facet.", 
					"The result set should get refreshed and display only result set belonging to that resource type only. Results belonging to other resource type shouldn't get displayed.",   
					"User able to see Only the results belonging to "+Report.color(resourcetype6)+"<br> and Icon displayed is <br> "+Report.color(attr), "PASS");

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on any other facet.", 
					"The result set should get refreshed and display only result set belonging to that resource type only. Results belonging to other resource type shouldn't get displayed.", 
					"Resource Type selected is "+Report.color(resourcetype6)+" user not able to see only selected resource type filtered", "FAIL");
			Assert.fail();
		}
	}
	public void  ValidateSearchForKeywordCommandCenterWithDoublequotes(WebDriver driver, String SearchOption) 
	{
		Log.info("Entering ValidateSearchForKeywordCommandCenterWithDoublequotes");   
		WebDriverWait wait = new WebDriverWait(driver, 120);
		String keyword1 = TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[0];

		String enteredtext = "";
		String searchresult="";
		String filter="";
		String filter1="";
		String searchresult1="";

		String resourcetype1 = TestNGCreator.TestData.get(Esupport.Dpid.ordinal()).split(";")[0];
		String resourcetype2 = TestNGCreator.TestData.get(Esupport.Dpid.ordinal()).split(";")[1];
		String resourcetype3 = TestNGCreator.TestData.get(Esupport.Dpid.ordinal()).split(";")[2];
		String resourcetype4 = TestNGCreator.TestData.get(Esupport.Dpid.ordinal()).split(";")[3];
		String resourcetype5 = TestNGCreator.TestData.get(Esupport.Dpid.ordinal()).split(";")[4];
		String resourcetype6 = TestNGCreator.TestData.get(Esupport.Dpid.ordinal()).split(";")[5];

		Actions act=new Actions(driver);

		try
		{       
			System.out.println("Inside try of ValidateSearchForKeywordCommandCenterWithDoublequotes");
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.SearchTextbox()));
			if(CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SearchTextbox()).isDisplayed())
			{	CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.SearchTextbox());
				CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.SearchTextbox());
				CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SearchTextbox()).clear();
				CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SearchTextbox()).sendKeys(keyword1);
				CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.SearchButton2());
				//				CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SearchButton()).click();
				CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.SearchButton2());

				Thread.sleep(10000);
			}
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.searchSupport()));
//			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			if(driver.getCurrentUrl().contains("Facet"))
			{
				Log.info("test case pass: url contains Facet keyword");
			}
			else
			{
				Log.info("test case fail: url doesnt contains Facet keyword");
				Report.put("Scenario 1: Type keyword alienware 'command center' windows 10 and with click Search", 
						"It should return all relevant results matching alienware, 'Command Center' and windows 10. It shouldn't return null results or blank page.", 
						"not landed on coveo page", "FAIL");;
						Assert.fail();
			}
			//				enteredtext=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.KewordValidationInCoveoPage()).getText();
			//				if(enteredtext.contains(keyword1))
			//				{
			//					Log.info("test case pass: keyword entered is displayed in search of coveo result");
			//				}
			//				else
			//				{
			//					Log.info("test case fail: keyword entered is not displayed in search of coveo result");
			//					Report.put("Scenario 1: Type keyword alienware 'command center' windows 10 and with click Search", 
			//							"It should return all relevant results matching alienware, 'Command Center' and windows 10. It shouldn't return null results or blank page.", 
			//							"not landed on correct coveo page for searched Keyword "+Report.color(keyword1), "FAIL");;
			//							Assert.fail();
			//				}

			//wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.GetCoveoOverAllSearchResult()));
			handleCookies(driver);
			CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.GetCoveoOverAllSearchResult());
//			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			searchresult=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.GetCoveoOverAllSearchResult()).getText();
			System.out.println("all result is for entered keyword is "+searchresult);

			List<WebElement> resourcetypelist=driver.findElements(obj_EsupportCoveoPage.ValidateResourceTypeIsSelected());
			int resourcetypecount=resourcetypelist.size();
			System.out.println("total number of resources displayed are "+resourcetypecount);

			for(int i=0; i<resourcetypecount;i++)
			{
				if(CommonUtility.highlightElement(driver,resourcetypelist.get(i)).isSelected())
				{
					Log.info("test case fail: resource types selected");
					Report.put("Scenario 1: Type keyword alienware 'command center' windows 10 and with click Search", 
							"It should return all relevant results matching alienware, 'Command Center' and windows 10. It shouldn't return null results or blank page.", 
							"Any of Resource Type is selected by default", "FAIL");
					Assert.fail();
				}
			}

			String filterheader=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ValidateFiltersSectionHeader()).getText();
			System.out.println("header is "+filterheader);

			List<WebElement> getallfilters=driver.findElements(obj_EsupportCoveoPage.GetAllFilters());
			int totalfilterscount=getallfilters.size();
			System.out.println("total count of selected filters "+totalfilterscount);

			for(int j=0;j<totalfilterscount;j++)
			{
				filter+=",<br>"+getallfilters.get(j).getText();
				System.out.println("filters displayed are "+filter);

				if (filter.contains(resourcetype1) || filter.contains(resourcetype2)|| filter.contains(resourcetype3)|| filter.contains(resourcetype4)|| filter.contains(resourcetype5)|| filter.contains(resourcetype6))
				{
					Log.info("test case fail: resource types displayed under your filters section");
					Report.put("Scenario 1: Type keyword alienware 'command center' windows 10 and with click Search", 
							"It should return all relevant results matching alienware, 'Command Center' and windows 10. It shouldn't return null results or blank page.",
							"Any of Resource Type "+Report.color(filter)+" is displayed by default under heading "+Report.color(filterheader), "FAIL");;
							Assert.fail();
				}

			}

			//wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.DownloadDriversClick()));
			//Lavanya added implicit wait to click below element
//			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.DownloadDriversClick());
			if(CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.DownloadDriversClick()).isDisplayed())
			{
				//act.moveToElement(CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.DownloadDriversClick())).build().perform();
				//CommonUtility.scrollToViewElement(driver,obj_EsupportCoveoPage.DownloadDriversClick());
				//act.moveToElement(CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.DownloadDriversClick())).click().build().perform();
				CommonUtility.ToClickByUsingJavaScript_PassingByLoc(driver, obj_EsupportCoveoPage.DownloadDriversClick());
				Thread.sleep(10000);
				System.out.println("clicked on drivers and downloads");
			}

			String filterheader1=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ValidateFiltersSectionHeader()).getText();
			System.out.println("header is "+filterheader1);

			List<WebElement> getallfilters1=driver.findElements(obj_EsupportCoveoPage.GetAllFilters());
			int totalfilterscount1=getallfilters1.size();
			System.out.println("total count of selected filters "+totalfilterscount1);

			for(int j=0;j<totalfilterscount1;j++)
			{
				filter1 +=",<br>"+getallfilters1.get(j).getText();
				System.out.println("filters displayed are "+filter1);

				if (filter1.contains(resourcetype4))
				{
					Log.info("test case pass: resource types Drivers and downloads displayed under your filter section");
				}
				else
				{
					Log.info("test case fail: resource types Drivers and downloads not displayed under your filter section");
					Report.put("Click on any other facet.", 
							"The result set should get refreshed and display only result set belonging to that resource type only. Results belonging to other resource type shouldn't get displayed.", 
							"Resource Type selected is "+Report.color(resourcetype4)+" and for Resource Type "+Report.color(filter1)+" is not displayed by under heading "+Report.color(filterheader1), "FAIL");;
							Assert.fail();
				}

			}

			searchresult1=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.GetCoveoOverAllSearchResult()).getText();
			System.out.println("all result is for entered keyword is "+searchresult1);

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.CoveoResultSection()));

			List<WebElement> listofresultsdisplayed=driver.findElements(obj_EsupportCoveoPage.HeadingOfDisplayedResult());
			int countofresultsdisplayed=listofresultsdisplayed.size();
			System.out.println("total number of results displayed are "+countofresultsdisplayed);

			for(int i=0; i<countofresultsdisplayed;i++)
			{
				String result=listofresultsdisplayed.get(i).getText();
				System.out.println("displayed result are "+result);
				result=result.toLowerCase();
				if(result.contains("alienware") || result.contains("command center") || result.contains("windows") || result.contains("10"))
				{
					Log.info("test case pass: heading of result displayed contains entered keyword");
					Report.put("Scenario 1: Type keyword alienware 'command center' windows 10 and with click Search", 
							"It should return all relevant results matching alienware, 'Command Center' and windows 10. It shouldn't return null results or blank page.",
							"entered keyword "+Report.color(keyword1)+" displayed in headings of search results as <br>"+Report.color(result), "PASS");
				}
				else
				{
					Log.info("test case fail: heading of result not displayed entered keyword");
					Report.put("Scenario 1: Type keyword alienware 'command center' windows 10 and with click Search", 
							"It should return all relevant results matching alienware, 'Command Center' and windows 10. It shouldn't return null results or blank page.",
							"entered keyword not displayed in headings of search results", "FAIL");
					Assert.fail();
				}
			}

			//wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.ClearFilters()));
//			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			//CommonUtility.scrollToViewElement(driver,obj_EsupportCoveoPage.ClearFilters());
			CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.ClearFilters());
			//CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ClearFilters()).click();
			CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.ClearFilters());
			Thread.sleep(6000);


			Report.put("Scenario 1: Type keyword alienware 'command center' windows 10 and with click Search", 
					"It should return all relevant results matching alienware, 'Command Center' and windows 10. It shouldn't return null results or blank page.", 
					"keyword "+Report.color(keyword1)+" searched Successfully.<br> and all relevant results displayed with result count of "+Report.color(searchresult1)+"<br> and filters displayed under "+Report.color(filterheader1)+" are <br> "+Report.color(filter1), "PASS");

			Thread.sleep(3000);                     
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Search for keyword 'audio driver' without double quotes", 
					"All Relevant featured results should be displayed belonging to all Resource Types and none of the resource types should be selected by default.", 
					"coveo search results display with default selected any of resource type or not landed on searched keyword coveo search result page", "FAIL");;
					Assert.fail();
		}
	}

	public void  ValidateSearchForKeywordBluetoothDriverWithDoublequotes(WebDriver driver, String SearchOption) 
	{
		Log.info("Entering ValidateSearchForKeywordBluetoothDriverWithDoublequotes");   
		WebDriverWait wait = new WebDriverWait(driver, 120);
		String keyword2 = TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[1];

		String enteredtext = "";
		String searchresult="";
		String filter="";
		String searchresult1="";
		String filter1="";

		String resourcetype1 = TestNGCreator.TestData.get(Esupport.Dpid.ordinal()).split(";")[0];
		String resourcetype2 = TestNGCreator.TestData.get(Esupport.Dpid.ordinal()).split(";")[1];
		String resourcetype3 = TestNGCreator.TestData.get(Esupport.Dpid.ordinal()).split(";")[2];
		String resourcetype4 = TestNGCreator.TestData.get(Esupport.Dpid.ordinal()).split(";")[3];
		String resourcetype5 = TestNGCreator.TestData.get(Esupport.Dpid.ordinal()).split(";")[4];
		String resourcetype6 = TestNGCreator.TestData.get(Esupport.Dpid.ordinal()).split(";")[5];

		try
		{       
			driver.manage().timeouts().implicitlyWait(600, TimeUnit.SECONDS);
			System.out.println("Inside try of ValidateSearchForKeywordBluetoothDriverWithDoublequotes");
			CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.SearchTextbox());
			CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.SearchTextbox());
			//wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.SearchTextbox()));
			if(CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SearchTextbox()).isDisplayed())
			{
				CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SearchTextbox()).clear();
				//				CommonUtility.scrollToViewElement(driver,obj_EsupportCoveoPage.SearchTextbox());
				CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SearchTextbox()).sendKeys(keyword2);
				CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.SearchButton2());
				//CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SearchButton()).click();
				CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.SearchButton2());
				Thread.sleep(20000);
			
			}
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.searchSupport()));
			if(driver.getCurrentUrl().contains("Facet"))
			{
				Log.info("test case pass: url contains Facet keyword");
			}
			else
			{
				Log.info("test case fail: url doesnt contains Facet keyword");
				Report.put("Enter the keyword 'Bluetooth driver' and click Search button. and select any facet from resource type", 
						"It should return all relevant results matching exact word 'Bluetooth driver'. It shouldn't return null results or blank page.", 
						"not landed on coveo page", "FAIL");;
						Assert.fail();
			}
			//				enteredtext=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.KewordValidationInCoveoPage()).getText();
			//				if(enteredtext.contains(keyword2))
			//				{
			//					Log.info("test case pass: keyword entered is displayed in search of coveo result");
			//				}
			//				else
			//				{
			//					Log.info("test case fail: keyword entered is not displayed in search of coveo result");
			//					Report.put("Enter the keyword 'Bluetooth driver' and click Search button. and select any facet from resource type", 
			//							"It should return all relevant results matching exact word 'Bluetooth driver'. It shouldn't return null results or blank page.", 
			//							"not landed on correct coveo page for searched Keyword "+Report.color(keyword2), "FAIL");;
			//							Assert.fail();
			//				}

			String filterheader=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ValidateFiltersSectionHeader()).getText();
			System.out.println("header is "+filterheader);

			List<WebElement> resourcetypelist=driver.findElements(obj_EsupportCoveoPage.ValidateResourceTypeIsSelected());
			int resourcetypecount=resourcetypelist.size();
			System.out.println("total number of resources displayed are "+resourcetypecount);
			try
			{
			for(int i=0; i<resourcetypecount;i++)
			{
				if(CommonUtility.highlightElement(driver,resourcetypelist.get(i)).isSelected())
				{
					Log.info("test case fail: resource types selected");
					Report.put("Enter the keyword 'Bluetooth driver' and click Search button. and select any facet from resource type", 
							"It should return all relevant results matching exact word 'Bluetooth driver'. It shouldn't return null results or blank page.",
							"Any of Resource Type is selected by default", "FAIL");;
							Assert.fail();
				}
			}
			

			List<WebElement> getallfilters=driver.findElements(obj_EsupportCoveoPage.GetAllFilters());
			int totalfilterscount=getallfilters.size();
			System.out.println("total count of selected filters "+totalfilterscount);

			for(int j=0;j<totalfilterscount;j++)
			{
				filter+=",<br>"+getallfilters.get(j).getText();
				System.out.println("filters displayed are "+filter);

				if (filter.contains(resourcetype1) || filter.contains(resourcetype2)|| filter.contains(resourcetype3)|| filter.contains(resourcetype4)|| filter.contains(resourcetype5)|| filter.contains(resourcetype6))
				{
					Log.info("test case fail: resource types displayed under your filters section");
					Report.put("Enter the keyword 'Bluetooth driver' and click Search button. and select any facet from resource type", 
							"It should return all relevant results matching exact word 'Bluetooth driver'. It shouldn't return null results or blank page.",
							"Any of Resource Type "+Report.color(filter)+" is displayed by default under heading "+Report.color(filterheader), "FAIL");;
							Assert.fail();
				}

			}
			}
			catch(Exception e)
			{
				
			}
			//wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.ManualDocumentationClick()));
			//Lavanya added implicit wait to click below element for 1102
//			driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
			handleCookies(driver);
			
			if(CommonUtility.CheckpresenceofElementLocated(driver,10,obj_EsupportCoveoPage.ManualDocumentationClick()))
			{
				CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.ManualDocumentationClick());
				//CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ManualDocumentationClick()).click();
				CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.ManualDocumentationClick());
//				Thread.sleep(10000);
			}
			handleCookies(driver);
			String filterheader1=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ValidateFiltersSectionHeader()).getText();
			System.out.println("header is "+filterheader1);

			List<WebElement> getallfilters1=driver.findElements(obj_EsupportCoveoPage.GetAllFilters());
			int totalfilterscount1=getallfilters1.size();
			System.out.println("total count of selected filters "+totalfilterscount1);

			for(int j=0;j<totalfilterscount1;j++)
			{
				filter1 +=",<br>"+getallfilters1.get(j).getText();
				System.out.println("filters displayed are "+filter1);

				if (filter1.contains(resourcetype6))
				{
					Log.info("test case pass: resource types Manuals And Documents displayed under your filter section");
				}
				else
				{
					Log.info("test case fail: resource types Manuals And Documents not displayed under your filter section");
					Report.put("Click on any other facet.", 
							"The result set should get refreshed and display only result set belonging to that resource type only. Results belonging to other resource type shouldn't get displayed.", 
							"Resource Type selected is "+Report.color(resourcetype6)+" and for Resource Type "+Report.color(filter1)+" is not displayed by under heading "+Report.color(filterheader1), "FAIL");;
//							Assert.fail();
				}

			}


//			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.GetCoveoOverAllSearchResult()));
			searchresult1=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.GetCoveoOverAllSearchResult()).getText();
			System.out.println("all result is for entered keyword is "+searchresult1);


			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.CoveoResultSection()));

			List<WebElement> listofresultsdisplayed=driver.findElements(obj_EsupportCoveoPage.HeadingOfDisplayedResult());
			int countofresultsdisplayed=listofresultsdisplayed.size();
			System.out.println("total number of results displayed are "+countofresultsdisplayed);

			for(int i=0; i<countofresultsdisplayed;i++)
			{
				String result=listofresultsdisplayed.get(i).getText();
				System.out.println("displayed result are "+result);
//				result=result.toLowerCase();
//				System.out.println("displayed result are "+result);
				if(result.contains("Bluetooth driver"))
				{
					Log.info("test case pass: heading of result displayed contains entered keyword");
					Report.put("Enter the keyword 'Bluetooth driver' and click Search button. and select any facet from resource type", 
							"It should return all relevant results matching exact word 'Bluetooth driver'. It shouldn't return null results or blank page.",
							"entered keyword "+Report.color(keyword2)+" displayed in headings of search results as <br>"+Report.color(result), "PASS");
				}
				else
				{
					Log.info("test case fail: heading of result not displayed contains entered keyword");
					Report.put("Enter the keyword 'Bluetooth driver' and click Search button. and select any facet from resource type", 
							"It should return all relevant results matching exact word 'Bluetooth driver'. It shouldn't return null results or blank page.",
							"entered keyword not displayed in headings of search results", "FAIL");
//					Assert.fail();
				}
			}
			//wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.ClearFilters()));
			//			CommonUtility.scrollToViewElement(driver,obj_EsupportCoveoPage.ClearFilters());
			//CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ClearFilters()).click();
			CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.ClearFilters());
			Thread.sleep(6000);

			Report.put("Enter the keyword 'Bluetooth driver' and click Search button. and select any facet from resource type", 
					"It should return all relevant results matching exact word 'Bluetooth driver'. It shouldn't return null results or blank page.",
					"keyword "+Report.color(keyword2)+" searched Successfully.<br> and all relevant results displayed with result count of "+Report.color(searchresult1)+"<br> and filters displayed under "+Report.color(filterheader1)+" are <br> "+Report.color(filter1), "PASS");

			Thread.sleep(3000);                     
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Enter the keyword 'Bluetooth driver' and click Search button. and select any facet from resource type", 
					"It should return all relevant results matching exact word 'Bluetooth driver'. It shouldn't return null results or blank page.",
					"coveo search results display with default selected any of resource type or not landed on searched keyword coveo search result page", "FAIL");
			Assert.fail();
		}
	}

	public void  ValidateSearchForKeywordAvamarCrashSymptomsWithDoublequotes(WebDriver driver, String SearchOption) 
	{
		Log.info("Entering ValidateSearchForKeywordAvamarCrashSymptomsWithDoublequotes");   
		WebDriverWait wait = new WebDriverWait(driver, 120);
		String keyword3 = TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[2];

		String enteredtext = "";
		String searchresult="";
		String filter="";
		String searchresult1="";
		String filter1="";

		String resourcetype1 = TestNGCreator.TestData.get(Esupport.Dpid.ordinal()).split(";")[0];
		String resourcetype2 = TestNGCreator.TestData.get(Esupport.Dpid.ordinal()).split(";")[1];
		String resourcetype3 = TestNGCreator.TestData.get(Esupport.Dpid.ordinal()).split(";")[2];
		String resourcetype4 = TestNGCreator.TestData.get(Esupport.Dpid.ordinal()).split(";")[3];
		String resourcetype5 = TestNGCreator.TestData.get(Esupport.Dpid.ordinal()).split(";")[4];
		String resourcetype6 = TestNGCreator.TestData.get(Esupport.Dpid.ordinal()).split(";")[5];

		try
		{       
			System.out.println("Inside try of ValidateSearchForKeywordAvamarCrashSymptomsWithDoublequotes");
			CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.SearchTextbox());
			CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.SearchTextbox());
			//wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.SearchTextbox()));
			if(CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SearchTextbox()).isDisplayed())
			{
				CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SearchTextbox()).clear();
				//				CommonUtility.scrollToViewElement(driver,obj_EsupportCoveoPage.SearchTextbox());
				CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SearchTextbox()).sendKeys(keyword3);
				CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.SearchButton2());
				//CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SearchButton()).click();
				CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.SearchButton2());
//				Thread.sleep(10000);
			}
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.searchSupport()));
			if(driver.getCurrentUrl().contains("Facet"))
			{
				Log.info("test case pass: url contains Facet keyword");
			}
			else
			{
				Log.info("test case fail: url doesnt contains Facet keyword");
				Report.put("Enter the keyword 'Avamar crash symptoms' and click Search button. and select any facet from resource type.", 
						"It should return relevant search results without a blank page and message should be displayed as in screen shot.", 
						"not landed on coveo page", "FAIL");;
						Assert.fail();
			}
			//				enteredtext=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.KewordValidationInCoveoPage()).getText();
			//				if(enteredtext.contains(keyword3))
			//				{
			//					Log.info("test case pass: keyword entered is displayed in search of coveo result");
			//				}
			//				else
			//				{
			//					Log.info("test case fail: keyword entered is not displayed in search of coveo result");
			//					Report.put("Enter the keyword 'Avamar crash symptoms' and click Search button. and select any facet from resource type.", 
			//							"It should return relevant search results without a blank page and message should be displayed as in screen shot.", 
			//							"not landed on correct coveo page for searched Keyword "+Report.color(keyword3), "FAIL");
			//							Assert.fail();
			//				}

			String filterheader=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ValidateFiltersSectionHeader()).getText();
			System.out.println("header is "+filterheader);

			List<WebElement> resourcetypelist=driver.findElements(obj_EsupportCoveoPage.ValidateResourceTypeIsSelected());
			int resourcetypecount=resourcetypelist.size();
			System.out.println("total number of resources displayed are "+resourcetypecount);
			try
			{
			for(int i=0; i<resourcetypecount;i++)
			{
				if(CommonUtility.highlightElement(driver,resourcetypelist.get(i)).isSelected())
				{
					Log.info("test case fail: resource types selected");
					Report.put("Enter the keyword 'Avamar crash symptoms' and click Search button. and select any facet from resource type.", 
							"It should return relevant search results without a blank page and message should be displayed as in screen shot.", 
							"Any of Resource Type is selected by default", "FAIL");;
							Assert.fail();
				}
			}
			
			List<WebElement> getallfilters=driver.findElements(obj_EsupportCoveoPage.GetAllFilters());
			int totalfilterscount=getallfilters.size();
			System.out.println("total count of selected filters "+totalfilterscount);

			for(int j=0;j<totalfilterscount;j++)
			{
				filter+=",<br>"+getallfilters.get(j).getText();
				System.out.println("filters displayed are "+filter);

				if (filter.contains(resourcetype1) || filter.contains(resourcetype2)|| filter.contains(resourcetype3)|| filter.contains(resourcetype4)|| filter.contains(resourcetype5)|| filter.contains(resourcetype6))
				{
					Log.info("test case fail: resource types displayed under your filters section");
					Report.put("Enter the keyword 'Avamar crash symptoms' and click Search button. and select any facet from resource type.", 
							"It should return relevant search results without a blank page and message should be displayed as in screen shot.", 
							"Any of Resource Type "+Report.color(filter)+" is displayed by default under heading "+Report.color(filterheader), "FAIL");;
							Assert.fail();
				}

			}
			}
			catch(Exception e)
			{
				
			}

			if(CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.MessageWhenSearchedResultsNotFound()).isDisplayed())
			{
				CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.MessageWhenSearchedResultsNotFound());
				String text=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.MessageWhenSearchedResultsNotFound()).getText();
				System.out.println("displayed text is "+text);
				if(text.contains("Query was automatically corrected to"))
				{
					Log.info("pass : expected word with double quotes not found");
				}
				else
				{
					Log.info("fail : expected word with double quotes found");
					Report.put("Enter the keyword 'Avamar crash symptoms' and click Search button. and select any facet from resource type.", 
							"It should return relevant search results without a blank page and message should be displayed as in screen shot.", 
							"entered keyword not displayed in headings of search results", "FAIL");
//					Assert.fail();

				}
				//					enteredtext=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.KewordValidationInCoveoPage()).getText();
				//					if(enteredtext.equals("Avamar crash symptoms"))
				//					{
				//						Log.info("test case pass: keyword entered is displayed in search without double quotes of coveo result");
				//					}
				//					else
				//					{
				//						Log.info("test case fail: keyword entered is not displayed in search without double quotes of coveo result");
				//						Report.put("Enter the keyword 'Avamar crash symptoms' and click Search button. and select any facet from resource type.", 
				//								"It should return relevant search results without a blank page and message should be displayed as in screen shot.", 
				//								"not landed on correct coveo page for searched Keyword "+Report.color(keyword3), "FAIL");;
				//								Assert.fail();
				//					}

				//wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.ManualDocumentationClick()));
				//Lavanya added implicit wait to click below element
//				driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
				CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.ManualDocumentationClick());
				if(CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ManualDocumentationClick()).isDisplayed())
				{
					//					CommonUtility.scrollToViewElement(driver,obj_EsupportCoveoPage.ManualDocumentationClick());
					//CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ManualDocumentationClick()).click();
					CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.ManualDocumentationClick());
					Thread.sleep(10000);
				}
				String filterheader1=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ValidateFiltersSectionHeader()).getText();
				System.out.println("header is "+filterheader1);

				List<WebElement> getallfilters1=driver.findElements(obj_EsupportCoveoPage.GetAllFilters());
				int totalfilterscount1=getallfilters1.size();
				System.out.println("total count of selected filters "+totalfilterscount1);

				for(int j=0;j<totalfilterscount1;j++)
				{
					filter1 +=",<br>"+getallfilters1.get(j).getText();
					System.out.println("filters displayed are "+filter1);

					if (filter1.contains(resourcetype6))
					{
						Log.info("test case pass: resource types Manuals And Documents displayed under your filter section");
					}
					else
					{
						Log.info("test case fail: resource types Manuals And Documents not displayed under your filter section");
						Report.put("Click on any facet.", 
								"The result set should get refreshed and display only result set belonging to that resource type only. Results belonging to other resource type shouldn't get displayed.", 
								"Resource Type selected is "+Report.color(resourcetype6)+" and for Resource Type "+Report.color(filter1)+" is not displayed by under heading "+Report.color(filterheader1), "FAIL");;
								Assert.fail();
					}

				}


				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.GetCoveoOverAllSearchResult()));
				searchresult1=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.GetCoveoOverAllSearchResult()).getText();
				System.out.println("all result is for entered keyword is "+searchresult1);

				wait.until(ExpectedConditions.presenceOfElementLocated(obj_EsupportCoveoPage.CoveoResultSection()));

				List<WebElement> listofresultsdisplayed=driver.findElements(obj_EsupportCoveoPage.HeadingOfDisplayedResult());
				int countofresultsdisplayed=listofresultsdisplayed.size();
				System.out.println("total number of results displayed are "+countofresultsdisplayed);

				for(int i=0; i<countofresultsdisplayed;i++)
				{
					String result=listofresultsdisplayed.get(i).getText();
//					System.out.println("displayed result are "+result);
					result=result.toLowerCase();
					System.out.println("displayed result are "+result);
					if(result.contains("avamar") || result.contains("crash") || result.contains("symptoms"))
					{
						Log.info("test case pass: heading of result displayed contains entered keyword");
						Report.put("Enter the keyword 'Avamar crash symptoms' with double quotes and click Search button. and select any facet from resource type", 
								"It should return all relevant removing double quotes and searching only the work without double quotes 'Avamar crash symptoms'. It shouldn't return null results or blank page.",
								"entered keyword "+Report.color(keyword3)+" displayed in headings of search results as <br>"+Report.color(result), "PASS");
					}
					else
					{
						Log.info("test case fail: heading of result not displayed contains entered keyword");
						Report.put("Enter the keyword 'Avamar crash symptoms' with double quotes and click Search button. and select any facet from resource type", 
								"It should return all relevant removing double quotes and searching only the work without double quotes 'Avamar crash symptoms'. It shouldn't return null results or blank page.",
								"entered keyword not displayed in headings of search results", "FAIL");
						//Assert.fail();
					}
				}
				//wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.ClearFilters()));
				//				CommonUtility.scrollToViewElement(driver,obj_EsupportCoveoPage.ClearFilters());
				//CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ClearFilters()).click();
				CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.ClearFilters());
				Thread.sleep(6000);

				Report.put("Enter the keyword 'Avamar crash symptoms' with double quotes and click Search button. and select any facet from resource type", 
						"It should return all relevant removing double quotes and searching only the work without double quotes 'Avamar crash symptoms'. It shouldn't return null results or blank page.",
						"keyword "+Report.color(keyword3)+" searched Successfully.<br> and all relevant results displayed with result count of "+Report.color(searchresult1)+"<br> and filters displayed under "+Report.color(filterheader)+" are <br> "+Report.color(filter1), "PASS");

				Thread.sleep(3000);            

			}

			else
			{

				//					enteredtext=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.KewordValidationInCoveoPage()).getText();
				//					if(enteredtext.contains(keyword3))
				//					{
				//						Log.info("test case pass: keyword entered is displayed in search without double quotes of coveo result");
				//					}
				//					else
				//					{
				//						Log.info("test case fail: keyword entered is not displayed in search without double quotes of coveo result");
				//						Report.put("Enter the keyword 'Avamar crash symptoms' with double quotes and click Search button. and select any facet from resource type", 
				//								"It should return all relevant removing double quotes and searching only the work without double quotes 'Avamar crash symptoms'. It shouldn't return null results or blank page.",
				//								"not landed on correct coveo page for searched Keyword "+Report.color(keyword3), "FAIL");;
				//								Assert.fail();
				//					}

				//wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.ManualDocumentationClick()));
				//Lavanya added implicit wait to click below element
				driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
				if(CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ManualDocumentationClick()).isDisplayed())
				{
					//					CommonUtility.scrollToViewElement(driver,obj_EsupportCoveoPage.ManualDocumentationClick());
					//					CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ManualDocumentationClick()).click();
					CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.ManualDocumentationClick());
					Thread.sleep(10000);
				}
				String filterheader1=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ValidateFiltersSectionHeader()).getText();
				System.out.println("header is "+filterheader1);

				List<WebElement> getallfilters1=driver.findElements(obj_EsupportCoveoPage.GetAllFilters());
				int totalfilterscount1=getallfilters1.size();
				System.out.println("total count of selected filters "+totalfilterscount1);

				for(int j=0;j<totalfilterscount1;j++)
				{
					filter1 +=",<br>"+getallfilters1.get(j).getText();
					System.out.println("filters displayed are "+filter1);

					if (filter1.contains(resourcetype6))
					{
						Log.info("test case pass: resource types Manuals And Documents displayed under your filter section");
					}
					else
					{
						Log.info("test case fail: resource types Manuals And Documents not displayed under your filter section");
						Report.put("Click on any facet.", 
								"The result set should get refreshed and display only result set belonging to that resource type only. Results belonging to other resource type shouldn't get displayed.", 
								"Resource Type selected is "+Report.color(resourcetype6)+" and for Resource Type "+Report.color(filter1)+" is not displayed by under heading "+Report.color(filterheader1), "FAIL");;
								Assert.fail();
					}

				}


				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.GetCoveoOverAllSearchResult()));
				searchresult1=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.GetCoveoOverAllSearchResult()).getText();
				System.out.println("all result is for entered keyword is "+searchresult1);

				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.CoveoResultSection()));

				List<WebElement> listofresultsdisplayed=driver.findElements(obj_EsupportCoveoPage.HeadingOfDisplayedResult());
				int countofresultsdisplayed=listofresultsdisplayed.size();
				System.out.println("total number of results displayed are "+countofresultsdisplayed);

				for(int i=0; i<countofresultsdisplayed;i++)
				{
					String result=listofresultsdisplayed.get(i).getText();
					System.out.println("displayed result are "+result);
					result=result.toLowerCase();
					if(result.contains("avamar crash symptoms"))
					{
						Log.info("test case pass: heading of result displayed contains entered keyword");
						Report.put("Enter the keyword 'Avamar crash symptoms' with double quotes and click Search button. and select any facet from resource type", 
								"It should return all relevant removing double quotes and searching only the work without double quotes 'Avamar crash symptoms'. It shouldn't return null results or blank page.",
								"entered keyword "+Report.color(keyword3)+" displayed in headings of search results as <br>"+Report.color(result), "PASS");
					}
					else
					{
						Log.info("test case fail: heading of result not displayed contains entered keyword");
						Report.put("Enter the keyword 'Avamar crash symptoms' with double quotes and click Search button. and select any facet from resource type", 
								"It should return all relevant removing double quotes and searching only the work without double quotes 'Avamar crash symptoms'. It shouldn't return null results or blank page.",
								"entered keyword not displayed in headings of search results", "FAIL");
						Assert.fail();
					}
				}
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.ClearFilters()));
				//				CommonUtility.scrollToViewElement(driver,obj_EsupportCoveoPage.ClearFilters());
				//					CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ClearFilters()).click();

				CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.ClearFilters());
				Thread.sleep(6000);

				Report.put("Enter the keyword 'Avamar crash symptoms' with double quotes and click Search button. and select any facet from resource type", 
						"It should return all relevant removing double quotes and searching only the work without double quotes 'Avamar crash symptoms'. It shouldn't return null results or blank page.",
						"keyword "+Report.color(keyword3)+" searched Successfully.<br> and all relevant results displayed with result count of "+Report.color(searchresult1)+"<br> and filters displayed under "+Report.color(filterheader)+" are <br> "+Report.color(filter1), "PASS");

				Thread.sleep(3000);            
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Enter the keyword 'Avamar crash symptoms' with double quotes and click Search button. and select any facet from resource type", 
					"It should return all relevant removing double quotes and searching only the work without double quotes 'Avamar crash symptoms'. It shouldn't return null results or blank page.",
					"coveo search results display with default selected any of resource type or not landed on searched keyword coveo search result page", "FAIL");
			Assert.fail();
		}
	}

	public void  ValidateSearchForVNXfailuremodeanalysisWithDoublequotes(WebDriver driver, String SearchOption) 
	{
		Log.info("Entering ValidateSearchForVNXfailuremodeanalysisWithDoublequotes");   
		WebDriverWait wait = new WebDriverWait(driver, 120);
		String keyword4 = TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[3];

		String enteredtext = "";
		String searchresult="";
		String filter="";
		String searchresult1="";
		String filter1="";

		String resourcetype1 = TestNGCreator.TestData.get(Esupport.Dpid.ordinal()).split(";")[0];
		String resourcetype2 = TestNGCreator.TestData.get(Esupport.Dpid.ordinal()).split(";")[1];
		String resourcetype3 = TestNGCreator.TestData.get(Esupport.Dpid.ordinal()).split(";")[2];
		String resourcetype4 = TestNGCreator.TestData.get(Esupport.Dpid.ordinal()).split(";")[3];
		String resourcetype5 = TestNGCreator.TestData.get(Esupport.Dpid.ordinal()).split(";")[4];
		String resourcetype6 = TestNGCreator.TestData.get(Esupport.Dpid.ordinal()).split(";")[5];

		try
		{       
			System.out.println("Inside try of ValidateSearchForVNXfailuremodeanalysisWithDoublequotes");
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.SearchTextbox()));
			if(CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SearchTextbox()).isDisplayed())
			{
				CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SearchTextbox()).clear();
				CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SearchTextbox()).sendKeys(keyword4);

				//				CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SearchButton()).click();
				CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.SearchButton());
				Thread.sleep(10000);
			}
			if(driver.getCurrentUrl().contains("Facet"))
			{
				Log.info("test case pass: url contains Facet keyword");
			}
			else
			{
				Log.info("test case fail: url doesnt contains Facet keyword");
				Report.put("Enter the keyword 'VNX failure mode analysis' and click Search button. and select any facet from resource type.", 
						"It should return relevant search results without a blank page", 
						"not landed on coveo page", "FAIL");;
						Assert.fail();
			}
			enteredtext=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.KewordValidationInCoveoPage()).getText();
			if(enteredtext.contains(keyword4))
			{
				Log.info("test case pass: keyword entered is displayed in search of coveo result");
			}
			else
			{
				Log.info("test case fail: keyword entered is not displayed in search of coveo result");
				Report.put("Enter the keyword 'VNX failure mode analysis' and click Search button. and select any facet from resource type.", 
						"It should return relevant search results without a blank page", 
						"not landed on correct coveo page for searched Keyword "+Report.color(keyword4), "FAIL");
				Assert.fail();
			}

			String filterheader=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ValidateFiltersSectionHeader()).getText();
			System.out.println("header is "+filterheader);

			List<WebElement> resourcetypelist=driver.findElements(obj_EsupportCoveoPage.ValidateResourceTypeIsSelected());
			int resourcetypecount=resourcetypelist.size();
			System.out.println("total number of resources displayed are "+resourcetypecount);

			for(int i=0; i<resourcetypecount;i++)
			{
				if(CommonUtility.highlightElement(driver,resourcetypelist.get(i)).isSelected())
				{
					Log.info("test case fail: resource types selected");
					Report.put("Enter the keyword 'VNX failure mode analysis' and click Search button. and select any facet from resource type.", 
							"It should return relevant search results without a blank page", 
							"Any of Resource Type is selected by default", "FAIL");;
							Assert.fail();
				}
			}

			List<WebElement> getallfilters=driver.findElements(obj_EsupportCoveoPage.GetAllFilters());
			int totalfilterscount=getallfilters.size();
			System.out.println("total count of selected filters "+totalfilterscount);

			for(int j=0;j<totalfilterscount;j++)
			{
				filter+=",<br>"+getallfilters.get(j).getText();
				System.out.println("filters displayed are "+filter);

				if (filter.contains(resourcetype1) || filter.contains(resourcetype2)|| filter.contains(resourcetype3)|| filter.contains(resourcetype4)|| filter.contains(resourcetype5)|| filter.contains(resourcetype6))
				{
					Log.info("test case fail: resource types displayed under your filters section");
					Report.put("Enter the keyword 'VNX failure mode analysis' and click Search button. and select any facet from resource type.", 
							"It should return relevant search results without a blank page",  
							"Any of Resource Type "+Report.color(filter)+" is displayed by default under heading "+Report.color(filterheader), "FAIL");;
							Assert.fail();
				}

			}


			if(CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.MessageWhenSearchedResultsNotFound()).isDisplayed())
			{
				CommonUtility.scrollToViewElement(driver,obj_EsupportCoveoPage.MessageWhenSearchedResultsNotFound());
				String text=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.MessageWhenSearchedResultsNotFound()).getText();
				System.out.println("displayed text is "+text);
				if(text.contains("Query was automatically corrected to"))
				{
					Log.info("pass : expected word with double quotes not found");
				}
				else
				{
					Log.info("fail : expected word with double quotes found");
					Report.put("Enter the keyword 'VNX failure mode analysis' and click Search button. and select any facet from resource type.", 
							"It should return relevant search results without a blank page", 
							"entered keyword not displayed in headings of search results", "FAIL");
					Assert.fail();

				}
				enteredtext=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.KewordValidationInCoveoPage()).getText();
				if(enteredtext.equals("VNX failure mode analysis"))
				{
					Log.info("test case pass: keyword entered is displayed in search without double quotes of coveo result");
				}
				else
				{
					Log.info("test case fail: keyword entered is not displayed in search without double quotes of coveo result");
					Report.put("Enter the keyword 'VNX failure mode analysis' and click Search button. and select any facet from resource type.", 
							"It should return relevant search results without a blank page", 
							"not landed on correct coveo page for searched Keyword "+Report.color(keyword4), "FAIL");;
							Assert.fail();
				}

				//wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.ManualDocumentationClick()));
				//Lavanya added implicit wait to click below element
				driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
				if(CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ManualDocumentationClick()).isDisplayed())
				{
					//					CommonUtility.scrollToViewElement(driver,obj_EsupportCoveoPage.ManualDocumentationClick());
					//					CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ManualDocumentationClick()).click();
					CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.ManualDocumentationClick());
					Thread.sleep(10000);
				}
				String filterheader1=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ValidateFiltersSectionHeader()).getText();
				System.out.println("header is "+filterheader1);

				List<WebElement> getallfilters1=driver.findElements(obj_EsupportCoveoPage.GetAllFilters());
				int totalfilterscount1=getallfilters1.size();
				System.out.println("total count of selected filters "+totalfilterscount1);

				for(int j=0;j<totalfilterscount1;j++)
				{
					filter1 +=",<br>"+getallfilters1.get(j).getText();
					System.out.println("filters displayed are "+filter1);

					if (filter1.contains(resourcetype6))
					{
						Log.info("test case pass: resource types Manuals And Documents displayed under your filter section");
					}
					else
					{
						Log.info("test case fail: resource types Manuals And Documents not displayed under your filter section");
						Report.put("Click on any facet.", 
								"The result set should get refreshed and display only result set belonging to that resource type only. Results belonging to other resource type shouldn't get displayed.", 
								"Resource Type selected is "+Report.color(resourcetype6)+" and for Resource Type "+Report.color(filter1)+" is not displayed by under heading "+Report.color(filterheader1), "FAIL");;
								Assert.fail();
					}

				}


				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.GetCoveoOverAllSearchResult()));
				searchresult1=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.GetCoveoOverAllSearchResult()).getText();
				System.out.println("all result is for entered keyword is "+searchresult1);

				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.CoveoResultSection()));

				List<WebElement> listofresultsdisplayed=driver.findElements(obj_EsupportCoveoPage.HeadingOfDisplayedResult());
				int countofresultsdisplayed=listofresultsdisplayed.size();
				System.out.println("total number of results displayed are "+countofresultsdisplayed);

				for(int i=0; i<countofresultsdisplayed;i++)
				{
					String result=listofresultsdisplayed.get(i).getText();
					System.out.println("displayed result are "+result);
					result=result.toLowerCase();
					if(result.contains("vnx") || result.contains("failure") || result.contains("mode") || result.contains("analysis"))
					{
						Log.info("test case pass: heading of result displayed contains entered keyword");
						Report.put("Enter the keyword 'VNX failure mode analysis' with double quotes and click Search button. and select any facet from resource type", 
								"It should return all relevant removing double quotes and searching only the work without double quotes 'VNX failure mode analysis'. It shouldn't return null results or blank page.",
								"entered keyword "+Report.color(keyword4)+" displayed in headings of search results as <br>"+Report.color(result), "PASS");
					}
					else
					{
						Log.info("test case fail: heading of result not displayed contains entered keyword");
						Report.put("Enter the keyword 'VNX failure mode analysis' with double quotes and click Search button. and select any facet from resource type", 
								"It should return all relevant removing double quotes and searching only the work without double quotes 'VNX failure mode analysis'. It shouldn't return null results or blank page.",
								"entered keyword not displayed in headings of search results", "FAIL");
						Assert.fail();
					}
				}
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.ClearFilters()));
				//				CommonUtility.scrollToViewElement(driver,obj_EsupportCoveoPage.ClearFilters());
				//					CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ClearFilters()).click();
				CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.ClearFilters());
				Thread.sleep(6000);

				Report.put("Enter the keyword 'VNX failure mode analysis' with double quotes and click Search button. and select any facet from resource type", 
						"It should return all relevant removing double quotes and searching only the work without double quotes 'VNX failure mode analysis'. It shouldn't return null results or blank page.",
						"keyword "+Report.color(keyword4)+" searched Successfully.<br> and all relevant results displayed with result count of "+Report.color(searchresult1)+"<br> and filters displayed under "+Report.color(filterheader)+" are <br> "+Report.color(filter1), "PASS");

				Thread.sleep(3000);            

			}

			else
			{

				enteredtext=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.KewordValidationInCoveoPage()).getText();
				if(enteredtext.contains(keyword4))
				{
					Log.info("test case pass: keyword entered is displayed in search without double quotes of coveo result");
				}
				else
				{
					Log.info("test case fail: keyword entered is not displayed in search without double quotes of coveo result");
					Report.put("Enter the keyword 'VNX failure mode analysis' with double quotes and click Search button. and select any facet from resource type", 
							"It should return all relevant removing double quotes and searching only the work without double quotes 'VNX failure mode analysis'. It shouldn't return null results or blank page.",
							"not landed on correct coveo page for searched Keyword "+Report.color(keyword4), "FAIL");;
							Assert.fail();
				}

				//wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.ManualDocumentationClick()));
				//Lavanya added implicit wait to click below element
				driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
				if(CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ManualDocumentationClick()).isDisplayed())
				{
					//					CommonUtility.scrollToViewElement(driver,obj_EsupportCoveoPage.ManualDocumentationClick());
					//					CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ManualDocumentationClick()).click();
					CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.ManualDocumentationClick());
					Thread.sleep(10000);
				}
				String filterheader1=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ValidateFiltersSectionHeader()).getText();
				System.out.println("header is "+filterheader1);

				List<WebElement> getallfilters1=driver.findElements(obj_EsupportCoveoPage.GetAllFilters());
				int totalfilterscount1=getallfilters1.size();
				System.out.println("total count of selected filters "+totalfilterscount1);

				for(int j=0;j<totalfilterscount1;j++)
				{
					filter1 +=",<br>"+getallfilters1.get(j).getText();
					System.out.println("filters displayed are "+filter1);

					if (filter1.contains(resourcetype6))
					{
						Log.info("test case pass: resource types Manuals And Documents displayed under your filter section");
					}
					else
					{
						Log.info("test case fail: resource types Manuals And Documents not displayed under your filter section");
						Report.put("Click on any facet.", 
								"The result set should get refreshed and display only result set belonging to that resource type only. Results belonging to other resource type shouldn't get displayed.", 
								"Resource Type selected is "+Report.color(resourcetype6)+" and for Resource Type "+Report.color(filter1)+" is not displayed by under heading "+Report.color(filterheader1), "FAIL");;
								Assert.fail();
					}

				}

				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.GetCoveoOverAllSearchResult()));
				searchresult1=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.GetCoveoOverAllSearchResult()).getText();
				System.out.println("all result is for entered keyword is "+searchresult1);

				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.CoveoResultSection()));

				List<WebElement> listofresultsdisplayed=driver.findElements(obj_EsupportCoveoPage.HeadingOfDisplayedResult());
				int countofresultsdisplayed=listofresultsdisplayed.size();
				System.out.println("total number of results displayed are "+countofresultsdisplayed);

				for(int i=0; i<countofresultsdisplayed;i++)
				{
					String result=listofresultsdisplayed.get(i).getText();
					System.out.println("displayed result are "+result);
					result=result.toLowerCase();
					if(result.contains("VNX failure mode analysis"))
					{
						Log.info("test case pass: heading of result displayed contains entered keyword");
						Report.put("Enter the keyword 'VNX failure mode analysis' with double quotes and click Search button. and select any facet from resource type", 
								"It should return all relevant removing double quotes and searching only the work without double quotes 'VNX failure mode analysis'. It shouldn't return null results or blank page.",
								"entered keyword "+Report.color(keyword4)+" displayed in headings of search results as <br>"+Report.color(result), "PASS");
					}
					else
					{
						Log.info("test case fail: heading of result not displayed contains entered keyword");
						Report.put("Enter the keyword 'VNX failure mode analysis' with double quotes and click Search button. and select any facet from resource type", 
								"It should return all relevant removing double quotes and searching only the work without double quotes 'VNX failure mode analysis'. It shouldn't return null results or blank page.",
								"entered keyword not displayed in headings of search results", "FAIL");
						Assert.fail();
					}
				}
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.ClearFilters()));
				//				CommonUtility.scrollToViewElement(driver,obj_EsupportCoveoPage.ClearFilters());
				//					CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ClearFilters()).click();
				CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.ClearFilters());
				Thread.sleep(6000);

				Report.put("Enter the keyword 'VNX failure mode analysis' with double quotes and click Search button. and select any facet from resource type", 
						"It should return all relevant removing double quotes and searching only the work without double quotes 'VNX failure mode analysis'. It shouldn't return null results or blank page.",
						"keyword "+Report.color(keyword4)+" searched Successfully.<br> and all relevant results displayed with result count of "+Report.color(searchresult1)+"<br> and filters displayed under "+Report.color(filterheader)+" are <br> "+Report.color(filter1), "PASS");

				Thread.sleep(3000);            
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Enter the keyword 'VNX failure mode analysis' and click Search button. and select any facet from resource type.", 
					"It should return all relevant results matching exact word 'VNX failure mode analysis' or it should search removing double quotes. It shouldn't return null results or blank page.",
					"coveo search results display with default selected any of resource type or not landed on searched keyword coveo search result page", "FAIL");
			Assert.fail();
		}
	}

	public void  ValidateSearchForLatitudelatestDriverupdatesWithDoublequotes(WebDriver driver, String SearchOption) 
	{
		Log.info("Entering ValidateSearchForLatitudelatestDriverupdatesWithDoublequotes");   
		WebDriverWait wait = new WebDriverWait(driver, 120);
		String keyword5 = TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[4];

		String enteredtext = "";
		String searchresult="";
		String filter="";
		String searchresult1="";
		String filter1="";

		String resourcetype1 = TestNGCreator.TestData.get(Esupport.Dpid.ordinal()).split(";")[0];
		String resourcetype2 = TestNGCreator.TestData.get(Esupport.Dpid.ordinal()).split(";")[1];
		String resourcetype3 = TestNGCreator.TestData.get(Esupport.Dpid.ordinal()).split(";")[2];
		String resourcetype4 = TestNGCreator.TestData.get(Esupport.Dpid.ordinal()).split(";")[3];
		String resourcetype5 = TestNGCreator.TestData.get(Esupport.Dpid.ordinal()).split(";")[4];
		String resourcetype6 = TestNGCreator.TestData.get(Esupport.Dpid.ordinal()).split(";")[5];

		try
		{       
			System.out.println("Inside try of ValidateSearchForLatitudelatestDriverupdatesWithDoublequotes");
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.SearchTextbox()));
			if(CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SearchTextbox()).isDisplayed())
			{
				CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SearchTextbox()).clear();
				CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SearchTextbox()).sendKeys(keyword5);

				//				CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SearchButton()).click();
				CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.SearchButton());
				Thread.sleep(10000);
			}
			if(driver.getCurrentUrl().contains("Facet"))
			{
				Log.info("test case pass: url contains Facet keyword");
			}
			else
			{
				Log.info("test case fail: url doesnt contains Facet keyword");
				Report.put("Enter the keyword 'Latitude latest Driver updates' and click Search button. and select any facet from resource type.", 
						"It should return relevant search results without a blank page", 
						"not landed on coveo page", "FAIL");;
						Assert.fail();
			}
			enteredtext=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.KewordValidationInCoveoPage()).getText();
			if(enteredtext.contains(keyword5))
			{
				Log.info("test case pass: keyword entered is displayed in search of coveo result");
			}
			else
			{
				Log.info("test case fail: keyword entered is not displayed in search of coveo result");
				Report.put("Enter the keyword 'Latitude latest Driver updates' and click Search button. and select any facet from resource type.", 
						"It should return relevant search results without a blank page", 
						"not landed on correct coveo page for searched Keyword "+Report.color(keyword5), "FAIL");
				Assert.fail();
			}

			String filterheader=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ValidateFiltersSectionHeader()).getText();
			System.out.println("header is "+filterheader);

			List<WebElement> resourcetypelist=driver.findElements(obj_EsupportCoveoPage.ValidateResourceTypeIsSelected());
			int resourcetypecount=resourcetypelist.size();
			System.out.println("total number of resources displayed are "+resourcetypecount);

			for(int i=0; i<resourcetypecount;i++)
			{
				if(CommonUtility.highlightElement(driver,resourcetypelist.get(i)).isSelected())
				{
					Log.info("test case fail: resource types selected");
					Report.put("Enter the keyword 'Latitude latest Driver updates' and click Search button. and select any facet from resource type.", 
							"It should return relevant search results without a blank page", 
							"Any of Resource Type is selected by default", "FAIL");;
							Assert.fail();
				}
			}

			List<WebElement> getallfilters=driver.findElements(obj_EsupportCoveoPage.GetAllFilters());
			int totalfilterscount=getallfilters.size();
			System.out.println("total count of selected filters "+totalfilterscount);

			for(int j=0;j<totalfilterscount;j++)
			{
				filter+=",<br>"+getallfilters.get(j).getText();
				System.out.println("filters displayed are "+filter);

				if (filter.contains(resourcetype1) || filter.contains(resourcetype2)|| filter.contains(resourcetype3)|| filter.contains(resourcetype4)|| filter.contains(resourcetype5)|| filter.contains(resourcetype6))
				{
					Log.info("test case fail: resource types displayed under your filters section");
					Report.put("Enter the keyword 'Latitude latest Driver updates' and click Search button. and select any facet from resource type.", 
							"It should return relevant search results without a blank page",  
							"Any of Resource Type "+Report.color(filter)+" is displayed by default under heading "+Report.color(filterheader), "FAIL");;
							Assert.fail();
				}

			}


			if(CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.MessageWhenSearchedResultsNotFound()).isDisplayed())
			{
				CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.MessageWhenSearchedResultsNotFound());
				String text=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.MessageWhenSearchedResultsNotFound()).getText();
				System.out.println("displayed text is "+text);
				if(text.contains("Query was automatically corrected to"))
				{
					Log.info("pass : expected word with double quotes not found");
				}
				else
				{
					Log.info("fail : expected word with double quotes found");
					Report.put("Enter the keyword 'Latitude latest Driver updates' and click Search button. and select any facet from resource type.", 
							"It should return relevant search results without a blank page", 
							"entered keyword not displayed in headings of search results", "FAIL");
					Assert.fail();

				}
				enteredtext=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.KewordValidationInCoveoPage()).getText();
				if(enteredtext.equals("Latitude latest Driver updates"))
				{
					Log.info("test case pass: keyword entered is displayed in search without double quotes of coveo result");
				}
				else
				{
					Log.info("test case fail: keyword entered is not displayed in search without double quotes of coveo result");
					Report.put("Enter the keyword 'Latitude latest Driver updates' and click Search button. and select any facet from resource type.", 
							"It should return relevant search results without a blank page", 
							"not landed on correct coveo page for searched Keyword "+Report.color(keyword5), "FAIL");;
							Assert.fail();
				}

				//wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.ManualDocumentationClick()));
				//Lavanya added implicit wait to click below element
				driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
				if(CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ManualDocumentationClick()).isDisplayed())
				{
					//					CommonUtility.scrollToViewElement(driver,obj_EsupportCoveoPage.ManualDocumentationClick());
					//					CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ManualDocumentationClick()).click();
					CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.ManualDocumentationClick());
					Thread.sleep(10000);
				}
				String filterheader1=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ValidateFiltersSectionHeader()).getText();
				System.out.println("header is "+filterheader1);

				List<WebElement> getallfilters1=driver.findElements(obj_EsupportCoveoPage.GetAllFilters());
				int totalfilterscount1=getallfilters1.size();
				System.out.println("total count of selected filters "+totalfilterscount1);

				for(int j=0;j<totalfilterscount1;j++)
				{
					filter1 +=",<br>"+getallfilters1.get(j).getText();
					System.out.println("filters displayed are "+filter1);

					if (filter1.contains(resourcetype6))
					{
						Log.info("test case pass: resource types Manuals And Documents displayed under your filter section");
					}
					else
					{
						Log.info("test case fail: resource types Manuals And Documents not displayed under your filter section");
						Report.put("Click on any facet.", 
								"The result set should get refreshed and display only result set belonging to that resource type only. Results belonging to other resource type shouldn't get displayed.", 
								"Resource Type selected is "+Report.color(resourcetype6)+" and for Resource Type "+Report.color(filter1)+" is not displayed by under heading "+Report.color(filterheader1), "FAIL");;
								Assert.fail();
					}

				}


				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.GetCoveoOverAllSearchResult()));
				searchresult1=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.GetCoveoOverAllSearchResult()).getText();
				System.out.println("all result is for entered keyword is "+searchresult1);

				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.CoveoResultSection()));

				List<WebElement> listofresultsdisplayed=driver.findElements(obj_EsupportCoveoPage.HeadingOfDisplayedResult());
				int countofresultsdisplayed=listofresultsdisplayed.size();
				System.out.println("total number of results displayed are "+countofresultsdisplayed);

				for(int i=0; i<countofresultsdisplayed;i++)
				{
					String result=listofresultsdisplayed.get(i).getText();
					System.out.println("displayed result are "+result);
					result=result.toLowerCase();
					if(result.contains("latitude") || result.contains("latest") || result.contains("driver") || result.contains("updates"))
					{
						Log.info("test case pass: heading of result displayed contains entered keyword");
						Report.put("Enter the keyword 'Latitude latest Driver updates' with double quotes and click Search button. and select any facet from resource type", 
								"It should return all relevant removing double quotes and searching only the work without double quotes 'Latitude latest Driver updates'. It shouldn't return null results or blank page.",
								"entered keyword "+Report.color(keyword5)+" displayed in headings of search results as <br>"+Report.color(result), "PASS");
					}
					else
					{
						Log.info("test case fail: heading of result not displayed contains entered keyword");
						Report.put("Enter the keyword 'Latitude latest Driver updates' with double quotes and click Search button. and select any facet from resource type", 
								"It should return all relevant removing double quotes and searching only the work without double quotes 'Latitude latest Driver updates'. It shouldn't return null results or blank page.",
								"entered keyword not displayed in headings of search results", "FAIL");
						Assert.fail();
					}
				}
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.ClearFilters()));
				//				CommonUtility.scrollToViewElement(driver,obj_EsupportCoveoPage.ClearFilters());
				//					CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ClearFilters()).click();
				CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.ClearFilters());
				Thread.sleep(6000);

				Report.put("Enter the keyword 'Latitude latest Driver updates' with double quotes and click Search button. and select any facet from resource type", 
						"It should return all relevant removing double quotes and searching only the work without double quotes 'Latitude latest Driver updates'. It shouldn't return null results or blank page.",
						"keyword "+Report.color(keyword5)+" searched Successfully.<br> and all relevant results displayed with result count of "+Report.color(searchresult1)+"<br> and filters displayed under "+Report.color(filterheader)+" are <br> "+Report.color(filter1), "PASS");

				Thread.sleep(3000);            

			}

			else
			{

				enteredtext=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.KewordValidationInCoveoPage()).getText();
				if(enteredtext.contains(keyword5))
				{
					Log.info("test case pass: keyword entered is displayed in search without double quotes of coveo result");
				}
				else
				{
					Log.info("test case fail: keyword entered is not displayed in search without double quotes of coveo result");
					Report.put("Enter the keyword 'Latitude latest Driver updates' with double quotes and click Search button. and select any facet from resource type", 
							"It should return all relevant removing double quotes and searching only the work without double quotes 'Latitude latest Driver updates'. It shouldn't return null results or blank page.",
							"not landed on correct coveo page for searched Keyword "+Report.color(keyword5), "FAIL");;
							Assert.fail();
				}

				//wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.ManualDocumentationClick()));
				//Lavanya added implicit wait to click below element
				driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
				if(CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ManualDocumentationClick()).isDisplayed())
				{
					//					CommonUtility.scrollToViewElement(driver,obj_EsupportCoveoPage.ManualDocumentationClick());
					//					CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ManualDocumentationClick()).click();
					CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.ManualDocumentationClick());
					Thread.sleep(10000);
				}
				String filterheader1=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ValidateFiltersSectionHeader()).getText();
				System.out.println("header is "+filterheader1);

				List<WebElement> getallfilters1=driver.findElements(obj_EsupportCoveoPage.GetAllFilters());
				int totalfilterscount1=getallfilters1.size();
				System.out.println("total count of selected filters "+totalfilterscount1);

				for(int j=0;j<totalfilterscount1;j++)
				{
					filter1 +=",<br>"+getallfilters1.get(j).getText();
					System.out.println("filters displayed are "+filter1);

					if (filter1.contains(resourcetype6))
					{
						Log.info("test case pass: resource types Manuals And Documents displayed under your filter section");
					}
					else
					{
						Log.info("test case fail: resource types Manuals And Documents not displayed under your filter section");
						Report.put("Click on any facet.", 
								"The result set should get refreshed and display only result set belonging to that resource type only. Results belonging to other resource type shouldn't get displayed.", 
								"Resource Type selected is "+Report.color(resourcetype6)+" and for Resource Type "+Report.color(filter1)+" is not displayed by under heading "+Report.color(filterheader1), "FAIL");;
								Assert.fail();
					}

				}

				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.GetCoveoOverAllSearchResult()));
				searchresult1=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.GetCoveoOverAllSearchResult()).getText();
				System.out.println("all result is for entered keyword is "+searchresult1);

				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.CoveoResultSection()));

				List<WebElement> listofresultsdisplayed=driver.findElements(obj_EsupportCoveoPage.HeadingOfDisplayedResult());
				int countofresultsdisplayed=listofresultsdisplayed.size();
				System.out.println("total number of results displayed are "+countofresultsdisplayed);

				for(int i=0; i<countofresultsdisplayed;i++)
				{
					String result=listofresultsdisplayed.get(i).getText();
					System.out.println("displayed result are "+result);
					result=result.toLowerCase();
					if(result.contains("VNX failure mode analysis"))
					{
						Log.info("test case pass: heading of result displayed contains entered keyword");
						Report.put("Enter the keyword 'Latitude latest Driver updates' with double quotes and click Search button. and select any facet from resource type", 
								"It should return all relevant removing double quotes and searching only the work without double quotes 'Latitude latest Driver updates'. It shouldn't return null results or blank page.",
								"entered keyword "+Report.color(keyword5)+" displayed in headings of search results as <br>"+Report.color(result), "PASS");
					}
					else
					{
						Log.info("test case fail: heading of result not displayed contains entered keyword");
						Report.put("Enter the keyword 'Latitude latest Driver updates' with double quotes and click Search button. and select any facet from resource type", 
								"It should return all relevant removing double quotes and searching only the work without double quotes 'Latitude latest Driver updates'. It shouldn't return null results or blank page.",
								"entered keyword not displayed in headings of search results", "FAIL");
						Assert.fail();
					}
				}
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.ClearFilters()));
				//				CommonUtility.scrollToViewElement(driver,obj_EsupportCoveoPage.ClearFilters());
				//					CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ClearFilters()).click();
				CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.ClearFilters());
				Thread.sleep(6000);

				Report.put("Enter the keyword 'Latitude latest Driver updates' with double quotes and click Search button. and select any facet from resource type", 
						"It should return all relevant removing double quotes and searching only the work without double quotes 'Latitude latest Driver updates'. It shouldn't return null results or blank page.",
						"keyword "+Report.color(keyword5)+" searched Successfully.<br> and all relevant results displayed with result count of "+Report.color(searchresult1)+"<br> and filters displayed under "+Report.color(filterheader)+" are <br> "+Report.color(filter1), "PASS");

				Thread.sleep(3000);            
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Enter the keyword 'Latitude latest Driver updates' and click Search button. and select any facet from resource type.", 
					"It should return all relevant results matching exact word 'Latitude latest Driver updates' or it should search removing double quotes. It shouldn't return null results or blank page.",
					"coveo search results display with default selected any of resource type or not landed on searched keyword coveo search result page", "FAIL");
			Assert.fail();
		}
	}

	public void  ValidateSearchForHardDiscReplicationsoftwareWithDoublequotes(WebDriver driver, String SearchOption) 
	{
		Log.info("Entering ValidateSearchForHardDiscReplicationsoftwareWithDoublequotes");   
		WebDriverWait wait = new WebDriverWait(driver, 120);
		String keyword6 = TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[5];

		String enteredtext = "";
		String searchresult="";
		String filter="";
		String searchresult1="";
		String filter1="";

		String resourcetype1 = TestNGCreator.TestData.get(Esupport.Dpid.ordinal()).split(";")[0];
		String resourcetype2 = TestNGCreator.TestData.get(Esupport.Dpid.ordinal()).split(";")[1];
		String resourcetype3 = TestNGCreator.TestData.get(Esupport.Dpid.ordinal()).split(";")[2];
		String resourcetype4 = TestNGCreator.TestData.get(Esupport.Dpid.ordinal()).split(";")[3];
		String resourcetype5 = TestNGCreator.TestData.get(Esupport.Dpid.ordinal()).split(";")[4];
		String resourcetype6 = TestNGCreator.TestData.get(Esupport.Dpid.ordinal()).split(";")[5];

		try
		{       
			System.out.println("Inside try of ValidateSearchForHardDiscReplicationsoftwareWithDoublequotes");
			CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.SearchTextbox());
			//wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.SearchTextbox()));
			if(CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SearchTextbox()).isDisplayed())
			{
				CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SearchTextbox()).clear();
				//				CommonUtility.scrollToViewElement(driver,obj_EsupportCoveoPage.SearchTextbox());
				CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SearchTextbox()).sendKeys(keyword6);

				//CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SearchButton()).click();
				CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.SearchButton());
//				Thread.sleep(10000);
			}
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.searchSupport()));
			if(driver.getCurrentUrl().contains("Facet"))
			{
				Log.info("test case pass: url contains Facet keyword");
			}
			else
			{
				Log.info("test case fail: url doesnt contains Facet keyword");
				Report.put("Enter the keyword 'Hard Disc Replication software' and click Search button. and select any facet from resource type.", 
						"It should return relevant search results without a blank page", 
						"not landed on coveo page", "FAIL");;
						Assert.fail();
			}
			//				enteredtext=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.KewordValidationInCoveoPage()).getText();
			//				if(enteredtext.contains(keyword6))
			//				{
			//					Log.info("test case pass: keyword entered is displayed in search of coveo result");
			//				}
			//				else
			//				{
			//					Log.info("test case fail: keyword entered is not displayed in search of coveo result");
			//					Report.put("Enter the keyword 'Hard Disc Replication software' and click Search button. and select any facet from resource type.", 
			//							"It should return relevant search results without a blank page", 
			//							"not landed on correct coveo page for searched Keyword "+Report.color(keyword6), "FAIL");
			//							Assert.fail();
			//				}

			String filterheader=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ValidateFiltersSectionHeader()).getText();
			System.out.println("header is "+filterheader);

			List<WebElement> resourcetypelist=driver.findElements(obj_EsupportCoveoPage.ValidateResourceTypeIsSelected());
			int resourcetypecount=resourcetypelist.size();
			System.out.println("total number of resources displayed are "+resourcetypecount);
			
			for(int i=0; i<resourcetypecount;i++)
			{
				if(CommonUtility.highlightElement(driver,resourcetypelist.get(i)).isSelected())
				{
					Log.info("test case fail: resource types selected");
					Report.put("Enter the keyword 'Hard Disc Replication software' and click Search button. and select any facet from resource type.", 
							"It should return relevant search results without a blank page", 
							"Any of Resource Type is selected by default", "FAIL");;
							Assert.fail();
				}
			}
			try
			{
			List<WebElement> getallfilters=driver.findElements(obj_EsupportCoveoPage.GetAllFilters());
			int totalfilterscount=getallfilters.size();
			System.out.println("total count of selected filters "+totalfilterscount);

			for(int j=0;j<totalfilterscount;j++)
			{
				filter+=",<br>"+getallfilters.get(j).getText();
				System.out.println("filters displayed are "+filter);

				if (filter.contains(resourcetype1) || filter.contains(resourcetype2)|| filter.contains(resourcetype3)|| filter.contains(resourcetype4)|| filter.contains(resourcetype5)|| filter.contains(resourcetype6))
				{
					Log.info("test case fail: resource types displayed under your filters section");
					Report.put("Enter the keyword 'Hard Disc Replication software' and click Search button. and select any facet from resource type.", 
							"It should return relevant search results without a blank page",  
							"Any of Resource Type "+Report.color(filter)+" is displayed by default under heading "+Report.color(filterheader), "FAIL");;
							Assert.fail();
				}

			}
			}
			catch(Exception e)
			{
				
			}


			if(CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.MessageWhenSearchedResultsNotFound()).isDisplayed())
			{
				CommonUtility.scrollToViewElement(driver,obj_EsupportCoveoPage.MessageWhenSearchedResultsNotFound());
				String text=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.MessageWhenSearchedResultsNotFound()).getText();
				System.out.println("displayed text is "+text);
				if(text.contains("Query was automatically corrected to"))
				{
					Log.info("pass : expected word with double quotes not found");
				}
				else
				{
					Log.info("fail : expected word with double quotes found");
					Report.put("Enter the keyword 'Hard Disc Replication software' and click Search button. and select any facet from resource type.", 
							"It should return relevant search results without a blank page", 
							"entered keyword not displayed in headings of search results", "FAIL");
					Assert.fail();

				}
				//					enteredtext=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.KewordValidationInCoveoPage()).getText();
				//					if(enteredtext.equals("Hard Disc Replication software"))
				//					{
				//						Log.info("test case pass: keyword entered is displayed in search without double quotes of coveo result");
				//					}
				//					else
				//					{
				//						Log.info("test case fail: keyword entered is not displayed in search without double quotes of coveo result");
				//						Report.put("Enter the keyword 'Hard Disc Replication software' and click Search button. and select any facet from resource type.", 
				//								"It should return relevant search results without a blank page", 
				//								"not landed on correct coveo page for searched Keyword "+Report.color(keyword6), "FAIL");;
				//								Assert.fail();
				//					}

				//wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.ManualDocumentationClick()));
				//Lavanya added implicit wait to click below element
//				driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
				CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.ManualDocumentationClick());
				if(CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ManualDocumentationClick()).isDisplayed())
				{
					//					CommonUtility.scrollToViewElement(driver,obj_EsupportCoveoPage.ManualDocumentationClick());
					//CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ManualDocumentationClick()).click();
					CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.ManualDocumentationClick());
//					Thread.sleep(10000);
				}
				handleCookies(driver);
				String filterheader1=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ValidateFiltersSectionHeader()).getText();
				System.out.println("header is "+filterheader1);

				List<WebElement> getallfilters1=driver.findElements(obj_EsupportCoveoPage.GetAllFilters());
				int totalfilterscount1=getallfilters1.size();
				System.out.println("total count of selected filters "+totalfilterscount1);

				for(int j=0;j<totalfilterscount1;j++)
				{
					filter1 +=",<br>"+getallfilters1.get(j).getText();
					System.out.println("filters displayed are "+filter1);

					if (filter1.contains(resourcetype6))
					{
						Log.info("test case pass: resource types Manuals And Documents displayed under your filter section");
					}
					else
					{
						Log.info("test case fail: resource types Manuals And Documents not displayed under your filter section");
						Report.put("Click on any facet.", 
								"The result set should get refreshed and display only result set belonging to that resource type only. Results belonging to other resource type shouldn't get displayed.", 
								"Resource Type selected is "+Report.color(resourcetype6)+" and for Resource Type "+Report.color(filter1)+" is not displayed by under heading "+Report.color(filterheader1), "FAIL");;
								Assert.fail();
					}

				}


				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.GetCoveoOverAllSearchResult()));
				searchresult1=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.GetCoveoOverAllSearchResult()).getText();
				System.out.println("all result is for entered keyword is "+searchresult1);

				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.CoveoResultSection()));

				List<WebElement> listofresultsdisplayed=driver.findElements(obj_EsupportCoveoPage.HeadingOfDisplayedResult());
				int countofresultsdisplayed=listofresultsdisplayed.size();
				System.out.println("total number of results displayed are "+countofresultsdisplayed);

				for(int i=0; i<countofresultsdisplayed;i++)
				{
					String result=listofresultsdisplayed.get(i).getText();
					System.out.println("displayed result are "+result);
					result=result.toLowerCase();
					if(result.contains("hard") || result.contains("disc") || result.contains("replication") || result.contains("software"))
					{
						Log.info("test case pass: heading of result displayed contains entered keyword");
						Report.put("Enter the keyword 'Hard Disc Replication software' with double quotes and click Search button. and select any facet from resource type", 
								"It should return all relevant removing double quotes and searching only the work without double quotes 'Hard Disc Replication software'. It shouldn't return null results or blank page.",
								"entered keyword "+Report.color(keyword6)+" displayed in headings of search results as <br>"+Report.color(result), "PASS");
					}
					else
					{
						Log.info("test case fail: heading of result not displayed contains entered keyword");
						Report.put("Enter the keyword 'Hard Disc Replication software' with double quotes and click Search button. and select any facet from resource type", 
								"It should return all relevant removing double quotes and searching only the work without double quotes 'Hard Disc Replication software'. It shouldn't return null results or blank page.",
								"entered keyword not displayed in headings of search results", "FAIL");
						Assert.fail();
					}
				}
				//wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.ClearFilters()));
				CommonUtility.scrollToViewElement(driver,obj_EsupportCoveoPage.ClearFilters());
				//CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ClearFilters()).click();
				CommonUtility.ToClickByUsingJavaScript_PassingByLoc(driver,obj_EsupportCoveoPage.ClearFilters());
				Thread.sleep(6000);

				Report.put("Enter the keyword 'Hard Disc Replication software' with double quotes and click Search button. and select any facet from resource type", 
						"It should return all relevant removing double quotes and searching only the work without double quotes 'Hard Disc Replication software'. It shouldn't return null results or blank page.",
						"keyword "+Report.color(keyword6)+" searched Successfully.<br> and all relevant results displayed with result count of "+Report.color(searchresult1)+"<br> and filters displayed under "+Report.color(filterheader)+" are <br> "+Report.color(filter1), "PASS");

				Thread.sleep(3000);            

			}

			else
			{

				//					enteredtext=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.KewordValidationInCoveoPage()).getText();
				//					if(enteredtext.contains(keyword6))
				//					{
				//						Log.info("test case pass: keyword entered is displayed in search without double quotes of coveo result");
				//					}
				//					else
				//					{
				//						Log.info("test case fail: keyword entered is not displayed in search without double quotes of coveo result");
				//						Report.put("Enter the keyword 'Hard Disc Replication software' with double quotes and click Search button. and select any facet from resource type", 
				//								"It should return all relevant removing double quotes and searching only the work without double quotes 'Hard Disc Replication software'. It shouldn't return null results or blank page.",
				//								"not landed on correct coveo page for searched Keyword "+Report.color(keyword6), "FAIL");;
				//								Assert.fail();
				//					}

				//wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.ManualDocumentationClick()));
				//Lavanya added implicit wait to click below element
				driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
				if(CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ManualDocumentationClick()).isDisplayed())
				{
					//					CommonUtility.scrollToViewElement(driver,obj_EsupportCoveoPage.ManualDocumentationClick());
					//					CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ManualDocumentationClick()).click();
					CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.ManualDocumentationClick());
					Thread.sleep(10000);
				}
				String filterheader1=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ValidateFiltersSectionHeader()).getText();
				System.out.println("header is "+filterheader1);

				List<WebElement> getallfilters1=driver.findElements(obj_EsupportCoveoPage.GetAllFilters());
				int totalfilterscount1=getallfilters1.size();
				System.out.println("total count of selected filters "+totalfilterscount1);

				for(int j=0;j<totalfilterscount1;j++)
				{
					filter1 +=",<br>"+getallfilters1.get(j).getText();
					System.out.println("filters displayed are "+filter1);

					if (filter1.contains(resourcetype6))
					{
						Log.info("test case pass: resource types Manuals And Documents displayed under your filter section");
					}
					else
					{
						Log.info("test case fail: resource types Manuals And Documents not displayed under your filter section");
						Report.put("Click on any facet.", 
								"The result set should get refreshed and display only result set belonging to that resource type only. Results belonging to other resource type shouldn't get displayed.", 
								"Resource Type selected is "+Report.color(resourcetype6)+" and for Resource Type "+Report.color(filter1)+" is not displayed by under heading "+Report.color(filterheader1), "FAIL");;
								Assert.fail();
					}

				}

				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.GetCoveoOverAllSearchResult()));
				searchresult1=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.GetCoveoOverAllSearchResult()).getText();
				System.out.println("all result is for entered keyword is "+searchresult1);

				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.CoveoResultSection()));

				List<WebElement> listofresultsdisplayed=driver.findElements(obj_EsupportCoveoPage.HeadingOfDisplayedResult());
				int countofresultsdisplayed=listofresultsdisplayed.size();
				System.out.println("total number of results displayed are "+countofresultsdisplayed);

				for(int i=0; i<countofresultsdisplayed;i++)
				{
					String result=listofresultsdisplayed.get(i).getText();
					System.out.println("displayed result are "+result);
					result=result.toLowerCase();
					if(result.contains("VNX failure mode analysis"))
					{
						Log.info("test case pass: heading of result displayed contains entered keyword");
						Report.put("Enter the keyword 'Hard Disc Replication software' with double quotes and click Search button. and select any facet from resource type", 
								"It should return all relevant removing double quotes and searching only the work without double quotes 'Hard Disc Replication software'. It shouldn't return null results or blank page.",
								"entered keyword "+Report.color(keyword6)+" displayed in headings of search results as <br>"+Report.color(result), "PASS");
					}
					else
					{
						Log.info("test case fail: heading of result not displayed contains entered keyword");
						Report.put("Enter the keyword 'Hard Disc Replication software' with double quotes and click Search button. and select any facet from resource type", 
								"It should return all relevant removing double quotes and searching only the work without double quotes 'Hard Disc Replication software'. It shouldn't return null results or blank page.",
								"entered keyword not displayed in headings of search results", "FAIL");
						Assert.fail();
					}
				}
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.ClearFilters()));
				//				CommonUtility.scrollToViewElement(driver,obj_EsupportCoveoPage.ClearFilters());
				//					CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ClearFilters()).click();
				CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.ClearFilters());
				Thread.sleep(6000);

				Report.put("Enter the keyword 'Hard Disc Replication software' with double quotes and click Search button. and select any facet from resource type", 
						"It should return all relevant removing double quotes and searching only the work without double quotes 'Hard Disc Replication software'. It shouldn't return null results or blank page.",
						"keyword "+Report.color(keyword6)+" searched Successfully.<br> and all relevant results displayed with result count of "+Report.color(searchresult1)+"<br> and filters displayed under "+Report.color(filterheader)+" are <br> "+Report.color(filter1), "PASS");

				Thread.sleep(3000);            
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Enter the keyword 'Hard Disc Replication software' and click Search button. and select any facet from resource type.", 
					"It should return all relevant results matching exact word 'Hard Disc Replication software' or it should search removing double quotes. It shouldn't return null results or blank page.",
					"coveo search results display with default selected any of resource type or not landed on searched keyword coveo search result page", "FAIL");
			Assert.fail();
		}
	}

	public void  ValidateSearchFor038003816vnxWithDoublequotes(WebDriver driver, String SearchOption) 
	{
		Log.info("Entering ValidateSearchFor038003816vnxWithDoublequotes");   
		WebDriverWait wait = new WebDriverWait(driver, 120);
		String keyword7 = TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[6];

		String enteredtext = "";
		String searchresult="";
		String filter="";
		String searchresult1="";
		String filter1="";

		String resourcetype1 = TestNGCreator.TestData.get(Esupport.Dpid.ordinal()).split(";")[0];
		String resourcetype2 = TestNGCreator.TestData.get(Esupport.Dpid.ordinal()).split(";")[1];
		String resourcetype3 = TestNGCreator.TestData.get(Esupport.Dpid.ordinal()).split(";")[2];
		String resourcetype4 = TestNGCreator.TestData.get(Esupport.Dpid.ordinal()).split(";")[3];
		String resourcetype5 = TestNGCreator.TestData.get(Esupport.Dpid.ordinal()).split(";")[4];
		String resourcetype6 = TestNGCreator.TestData.get(Esupport.Dpid.ordinal()).split(";")[5];

		try
		{       
			System.out.println("Inside try of ValidateSearchFor038003816vnxWithDoublequotes");
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.SearchTextbox()));
			if(CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SearchTextbox()).isDisplayed())
			{
				CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SearchTextbox()).clear();
				CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SearchTextbox()).sendKeys(keyword7);

				//				CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SearchButton()).click();
				CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.SearchButton());
				Thread.sleep(10000);
			}
			if(driver.getCurrentUrl().contains("Facet"))
			{
				Log.info("test case pass: url contains Facet keyword");
			}
			else
			{
				Log.info("test case fail: url doesnt contains Facet keyword");
				Report.put("Enter the keyword '038-003-816' vnx and click Search button. and select any facet from resource type.", 
						"It should return relevant search results without a blank page", 
						"not landed on coveo page", "FAIL");;
						Assert.fail();
			}
			//				enteredtext=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.KewordValidationInCoveoPage()).getText();
			//				if(enteredtext.contains(keyword7))
			//				{
			//					Log.info("test case pass: keyword entered is displayed in search of coveo result");
			//				}
			//				else
			//				{
			//					Log.info("test case fail: keyword entered is not displayed in search of coveo result");
			//					Report.put("Enter the keyword '038-003-816' vnx and click Search button. and select any facet from resource type.", 
			//							"It should return relevant search results without a blank page", 
			//							"not landed on correct coveo page for searched Keyword "+Report.color(keyword7), "FAIL");
			//							Assert.fail();
			//				}

			String filterheader=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ValidateFiltersSectionHeader()).getText();
			System.out.println("header is "+filterheader);

			List<WebElement> resourcetypelist=driver.findElements(obj_EsupportCoveoPage.ValidateResourceTypeIsSelected());
			int resourcetypecount=resourcetypelist.size();
			System.out.println("total number of resources displayed are "+resourcetypecount);

			for(int i=0; i<resourcetypecount;i++)
			{
				if(CommonUtility.highlightElement(driver,resourcetypelist.get(i)).isSelected())
				{
					Log.info("test case fail: resource types selected");
					Report.put("Enter the keyword '038-003-816' vnx and click Search button. and select any facet from resource type.", 
							"It should return relevant search results without a blank page", 
							"Any of Resource Type is selected by default", "FAIL");;
							Assert.fail();
				}
			}

			List<WebElement> getallfilters=driver.findElements(obj_EsupportCoveoPage.GetAllFilters());
			int totalfilterscount=getallfilters.size();
			System.out.println("total count of selected filters "+totalfilterscount);

			for(int j=0;j<totalfilterscount;j++)
			{
				filter+=",<br>"+getallfilters.get(j).getText();
				System.out.println("filters displayed are "+filter);

				if (filter.contains(resourcetype1) || filter.contains(resourcetype2)|| filter.contains(resourcetype3)|| filter.contains(resourcetype4)|| filter.contains(resourcetype5)|| filter.contains(resourcetype6))
				{
					Log.info("test case fail: resource types displayed under your filters section");
					Report.put("Enter the keyword '038-003-816' vnx and click Search button. and select any facet from resource type.", 
							"It should return relevant search results without a blank page",  
							"Any of Resource Type "+Report.color(filter)+" is displayed by default under heading "+Report.color(filterheader), "FAIL");;
							Assert.fail();
				}

			}


			if(CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.MessageWhenSearchedResultsNotFound()).isDisplayed())
			{
				CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.MessageWhenSearchedResultsNotFound());
				String text=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.MessageWhenSearchedResultsNotFound()).getText();
				System.out.println("displayed text is "+text);
				if(text.contains("Query was automatically corrected to"))
				{
					Log.info("pass : expected word with double quotes not found");
				}
				else
				{
					Log.info("fail : expected word with double quotes found");
					Report.put("Enter the keyword '038-003-816' vnx and click Search button. and select any facet from resource type.", 
							"It should return relevant search results without a blank page", 
							"entered keyword not displayed in headings of search results", "FAIL");
					Assert.fail();

				}
				enteredtext=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.KewordValidationInCoveoPage()).getText();
				if(enteredtext.equals("038-003-816 vnx"))
				{
					Log.info("test case pass: keyword entered is displayed in search without double quotes of coveo result");
				}
				else
				{
					Log.info("test case fail: keyword entered is not displayed in search without double quotes of coveo result");
					Report.put("Enter the keyword '038-003-816' vnx and click Search button. and select any facet from resource type.", 
							"It should return relevant search results without a blank page", 
							"not landed on correct coveo page for searched Keyword "+Report.color(keyword7), "FAIL");;
							Assert.fail();
				}

				//wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.ManualDocumentationClick()));
				//Lavanya added implicit wait to click below element
				driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
				if(CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ManualDocumentationClick()).isDisplayed())
				{
					//					CommonUtility.scrollToViewElement(driver,obj_EsupportCoveoPage.ManualDocumentationClick());
					//					CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ManualDocumentationClick()).click();
					CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.ManualDocumentationClick());
					Thread.sleep(10000);
				}
				String filterheader1=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ValidateFiltersSectionHeader()).getText();
				System.out.println("header is "+filterheader1);

				List<WebElement> getallfilters1=driver.findElements(obj_EsupportCoveoPage.GetAllFilters());
				int totalfilterscount1=getallfilters1.size();
				System.out.println("total count of selected filters "+totalfilterscount1);

				for(int j=0;j<totalfilterscount1;j++)
				{
					filter1 +=",<br>"+getallfilters1.get(j).getText();
					System.out.println("filters displayed are "+filter1);

					if (filter1.contains(resourcetype6))
					{
						Log.info("test case pass: resource types Manuals And Documents displayed under your filter section");
					}
					else
					{
						Log.info("test case fail: resource types Manuals And Documents not displayed under your filter section");
						Report.put("Click on any facet.", 
								"The result set should get refreshed and display only result set belonging to that resource type only. Results belonging to other resource type shouldn't get displayed.", 
								"Resource Type selected is "+Report.color(resourcetype4)+" and for Resource Type "+Report.color(filter1)+" is not displayed by under heading "+Report.color(filterheader1), "FAIL");;
								Assert.fail();
					}

				}


				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.GetCoveoOverAllSearchResult()));
				searchresult1=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.GetCoveoOverAllSearchResult()).getText();
				System.out.println("all result is for entered keyword is "+searchresult1);

				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.CoveoResultSection()));

				List<WebElement> listofresultsdisplayed=driver.findElements(obj_EsupportCoveoPage.HeadingOfDisplayedResult());
				int countofresultsdisplayed=listofresultsdisplayed.size();
				System.out.println("total number of results displayed are "+countofresultsdisplayed);

				for(int i=0; i<countofresultsdisplayed;i++)
				{
					String result=listofresultsdisplayed.get(i).getText();
					System.out.println("displayed result are "+result);
					result=result.toLowerCase();
					if(result.contains("0") || result.contains("3") || result.contains("8") || result.contains("-") || result.contains("1") || result.contains("6") || result.contains("vnx"))
					{
						Log.info("test case pass: heading of result displayed contains entered keyword");
						Report.put("Enter the keyword '038-003-816' vnx with double quotes and click Search button. and select any facet from resource type", 
								"It should return all relevant removing double quotes and searching only the work without double quotes '038-003-816' vnx. It shouldn't return null results or blank page.",
								"entered keyword "+Report.color(keyword7)+" displayed in headings of search results as <br>"+Report.color(result), "PASS");
					}
					else
					{
						Log.info("test case fail: heading of result not displayed contains entered keyword");
						Report.put("Enter the keyword '038-003-816' vnx with double quotes and click Search button. and select any facet from resource type", 
								"It should return all relevant removing double quotes and searching only the work without double quotes '038-003-816' vnx. It shouldn't return null results or blank page.",
								"entered keyword not displayed in headings of search results", "FAIL");
						Assert.fail();
					}
				}
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.ClearFilters()));
				//				CommonUtility.scrollToViewElement(driver,obj_EsupportCoveoPage.ClearFilters());
				//					CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ClearFilters()).click();
				CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.ClearFilters());
				Thread.sleep(6000);

				Report.put("Enter the keyword '038-003-816' vnx with double quotes and click Search button. and select any facet from resource type", 
						"It should return all relevant removing double quotes and searching only the work without double quotes '038-003-816' vnx. It shouldn't return null results or blank page.",
						"keyword "+Report.color(keyword7)+" searched Successfully.<br> and all relevant results displayed with result count of "+Report.color(searchresult1)+"<br> and filters displayed under "+Report.color(filterheader)+" are <br> "+Report.color(filter1), "PASS");

				Thread.sleep(3000);            

			}

			else
			{

				enteredtext=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.KewordValidationInCoveoPage()).getText();
				if(enteredtext.contains(keyword7))
				{
					Log.info("test case pass: keyword entered is displayed in search without double quotes of coveo result");
				}
				else
				{
					Log.info("test case fail: keyword entered is not displayed in search without double quotes of coveo result");
					Report.put("Enter the keyword '038-003-816' vnx with double quotes and click Search button. and select any facet from resource type", 
							"It should return all relevant removing double quotes and searching only the work without double quotes '038-003-816' vnx. It shouldn't return null results or blank page.",
							"not landed on correct coveo page for searched Keyword "+Report.color(keyword7), "FAIL");;
							Assert.fail();
				}

				//wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.ManualDocumentationClick()));
				//Lavanya added implicit wait to click below element
				driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
				if(CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.DownloadDriversClick()).isDisplayed())
				{
					//					CommonUtility.scrollToViewElement(driver,obj_EsupportCoveoPage.DownloadDriversClick());
					//					CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.DownloadDriversClick()).click();
					CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.DownloadDriversClick());
					Thread.sleep(10000);
				}
				String filterheader1=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ValidateFiltersSectionHeader()).getText();
				System.out.println("header is "+filterheader1);

				List<WebElement> getallfilters1=driver.findElements(obj_EsupportCoveoPage.GetAllFilters());
				int totalfilterscount1=getallfilters1.size();
				System.out.println("total count of selected filters "+totalfilterscount1);

				for(int j=0;j<totalfilterscount1;j++)
				{
					filter1 +=",<br>"+getallfilters1.get(j).getText();
					System.out.println("filters displayed are "+filter1);

					if (filter1.contains(resourcetype4))
					{
						Log.info("test case pass: resource types Manuals And Documents displayed under your filter section");
					}
					else
					{
						Log.info("test case fail: resource types Manuals And Documents not displayed under your filter section");
						Report.put("Click on any facet.", 
								"The result set should get refreshed and display only result set belonging to that resource type only. Results belonging to other resource type shouldn't get displayed.", 
								"Resource Type selected is "+Report.color(resourcetype4)+" and for Resource Type "+Report.color(filter1)+" is not displayed by under heading "+Report.color(filterheader1), "FAIL");;
								Assert.fail();
					}

				}

				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.GetCoveoOverAllSearchResult()));
				searchresult1=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.GetCoveoOverAllSearchResult()).getText();
				System.out.println("all result is for entered keyword is "+searchresult1);

				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.CoveoResultSection()));

				List<WebElement> listofresultsdisplayed=driver.findElements(obj_EsupportCoveoPage.HeadingOfDisplayedResult());
				int countofresultsdisplayed=listofresultsdisplayed.size();
				System.out.println("total number of results displayed are "+countofresultsdisplayed);

				for(int i=0; i<countofresultsdisplayed;i++)
				{
					String result=listofresultsdisplayed.get(i).getText();
					System.out.println("displayed result are "+result);
					result=result.toLowerCase();
					if(result.contains("VNX failure mode analysis"))
					{
						Log.info("test case pass: heading of result displayed contains entered keyword");
						Report.put("Enter the keyword '038-003-816' vnx with double quotes and click Search button. and select any facet from resource type", 
								"It should return all relevant removing double quotes and searching only the work without double quotes '038-003-816' vnx. It shouldn't return null results or blank page.",
								"entered keyword "+Report.color(keyword7)+" displayed in headings of search results as <br>"+Report.color(result), "PASS");
					}
					else
					{
						Log.info("test case fail: heading of result not displayed contains entered keyword");
						Report.put("Enter the keyword '038-003-816' vnx with double quotes and click Search button. and select any facet from resource type", 
								"It should return all relevant removing double quotes and searching only the work without double quotes '038-003-816' vnx. It shouldn't return null results or blank page.",
								"entered keyword not displayed in headings of search results", "FAIL");
						Assert.fail();
					}
				}
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.ClearFilters()));
				//				CommonUtility.scrollToViewElement(driver,obj_EsupportCoveoPage.ClearFilters());
				//				CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ClearFilters()).click();
				CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.ClearFilters());
				Thread.sleep(6000);

				Report.put("Enter the keyword '038-003-816' vnx with double quotes and click Search button. and select any facet from resource type", 
						"It should return all relevant removing double quotes and searching only the work without double quotes '038-003-816' vnx. It shouldn't return null results or blank page.",
						"keyword "+Report.color(keyword7)+" searched Successfully.<br> and all relevant results displayed with result count of "+Report.color(searchresult1)+"<br> and filters displayed under "+Report.color(filterheader)+" are <br> "+Report.color(filter1), "PASS");

				Thread.sleep(3000);            
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Enter the keyword '038-003-816' vnx and click Search button. and select any facet from resource type.", 
					"It should return all relevant results matching exact word '038-003-816' vnx or it should search removing double quotes. It shouldn't return null results or blank page.",
					"coveo search results display with default selected any of resource type or not landed on searched keyword coveo search result page", "FAIL");
			Assert.fail();
		}
	}


	public void  CLickOnFirstResultTitle(WebDriver driver) 
	{
		Log.info("Entering CLickOnFirstResultTitle");   
		WebDriverWait wait = new WebDriverWait(driver, 120);

		String enteredtext = "";
		String searchresult="";
		String filter="";
		String result="";
		String attr="";
		String title="";
		String currenturl="";
		String text="";
		Actions act=new Actions(driver);
		String text1="";
		String text2="";

		try
		{       
			Log.info("Inside try of CLickOnFirstResultTitle");


			//				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.ClickOnFirstResult()));
			CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.ClickOnFirstResult());
			text=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ClickOnFirstResult()).getText();
			System.out.println(text);
			String firstwordoftitle=text.split("|")[0];
			String secondwordoftitle=text.split("|")[1];

			//			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ClickOnFirstResult()).click();
			CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.ClickOnFirstResult());
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);

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
					Thread.sleep(7000);
					title=driver.getTitle();
					System.out.println(title);
					currenturl=driver.getCurrentUrl();
					System.out.println(currenturl);

					Thread.sleep(10000);

					//					CommonUtility.scrollToViewElement(driver,obj_EsupportCoveoPage.BreadScrumOfTitleInManualOpenedInNewTab());
					//					text1=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.BreadScrumOfTitleInManualOpenedInNewTab()).getText();
					//					System.out.println(text1);
					//
					//					CommonUtility.scrollToViewElement(driver,obj_EsupportCoveoPage.BreadScrumCurrentTopicInManualOpenedInNewTab());
					//					text2=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.BreadScrumCurrentTopicInManualOpenedInNewTab()).getText();
					//					System.out.println(text2);

					driver.close();
				}
			}

			driver.switchTo().window(mainwindow);

			if (firstwordoftitle.contains(text1))
			{
				Log.info("Test case pass:first word of title of search result contains first word of breadscrum which is displayed when clicking on that title");
			}
			else
			{

				Log.info("Test case fail:first word of title of search result not contains first word");
				Report.put("Now observe the Breadcrumb of the Manual loaded.", 
						"It should show the breadcrumb.It should pick the First and Last part of the Title (excluding Product Name)",
						"breadscrum first word not matching with title first word", "FAIL");
				Assert.fail();
			}

			if (secondwordoftitle.contains(text2))
			{
				Log.info("Test case pass:second word of title of search result contains last word of breadscrum which is displayed when clicking on that title");
			}
			else
			{

				Log.info("Test case fail:second word of title of search result contains last word of breadscrum");
				Report.put("Now observe the Breadcrumb of the Manual loaded.", 
						"It should show the breadcrumb as in attached image.It should pick the First and Last part of the Title (excluding Product Name)", 
						"breadscrum last word not matching with title second word", "FAIL");
				Assert.fail();
			}

			Report.put("Open any of the link.", 
					"It should open the manual in new tab.(in G4 the content is loading currently)",
					"able to click on second result displayed and able to see title of page as "+Report.color(title)+" <br> and url of page is <br> "+Report.color(currenturl), "PASS");

			Report.put("Now observe the Breadcrumb of the Manual loaded.", 
					"It should show the breadcrumb as in attached image.It should pick the First and Last part of the Title (excluding Product Name)",
					"able to see first breadscrum "+Report.color(text1+" same as and respective first word of title "+firstwordoftitle)+" <br> and able to see last breadscrum "+Report.color(text2+" same as and respective second word of title "+secondwordoftitle), "PASS");

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Now observe the Breadcrumb of the Manual loaded.", 
					"It should show the breadcrumb as in attached image.It should pick the First and Last part of the Title (excluding Product Name)",
					"not able to click on second title of displayed search result", "FAIL");;
					Assert.fail();
		}
	}

	public void  ClickOnTrainingLink(WebDriver driver) 
	{

		WebDriverWait wait = new WebDriverWait(driver, 120);
		Actions act=new Actions(driver);

		Log.info("Entering ClickOnTrainingLink");   
		String header = "";
		String title="";
		String currenturl="";

		try
		{ 
			//				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.TrainingLinkInDocumentationTab()));

			//			CommonUtility.scrollToViewElement(driver,obj_EsupportCoveoPage.TrainingLinkInDocumentationTab());
			header=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.TrainingLinkInDocumentationTab()).getText();
			//			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.TrainingLinkInDocumentationTab()).click();
			CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.TrainingLinkInDocumentationTab());
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
					driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
					Thread.sleep(10000);
					title=driver.getTitle();
					currenturl=driver.getCurrentUrl();
					System.out.println(title);
					System.out.println(currenturl);

					driver.close();
				}
			}

			driver.switchTo().window(mainwindow);

			Report.put("Click on the Training link", 
					"User should be directed to a new tab with the available training link details.", 
					"able to click on "+Report.color(header)+"and able to see open in with "+Report.color(title)+" and url "+Report.color(currenturl), "PASS");              
		}
		catch(Exception e)
		{
			e.printStackTrace();


			Report.put("Click on the Training link", 
					"User should be directed to a new tab with the available training link details.", 
					"failed to display Training link", "FAIL");

			Assert.fail();
		}
	}

	public void  TrainingLinkValidationInDocumentationTab(WebDriver driver) 
	{

		WebDriverWait wait = new WebDriverWait(driver, 120);
		Actions act=new Actions(driver);

		Log.info("Entering TrainingLinkValidationInDocumentationTab");   
		String header = "";

		try
		{ 
			//				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.TrainingLinkInDocumentationTab()));

			CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.TrainingLinkInDocumentationTab());
			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.TrainingLinkInDocumentationTab());

			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.TrainingIconInDocumentationTab());
			header = CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.TrainingLinkInDocumentationTab()).getText();
			System.out.println("link is displayed as  "+header );

			if(header.contains("Training"))
			{
				System.out.println("displayed link is correct");
			}

			Report.put("Observe the TRAINING link.", 
					"Training link should be present on the left bottom of the Documentation page. (Available for only few products)", 
					"able to see link displayes as "+Report.color(header), "PASS");              
		}
		catch(Exception e)
		{
			e.printStackTrace();


			Report.put("Observe the TRAINING link.", 
					"Training link should be present on the left bottom of the Documentation page. (Available for only few products)", 
					"failed to display Training link", "FAIL");

			Assert.fail();
		}
	}

	public void  VerifyTrainingLinkNotFoundInDocumentationTab(WebDriver driver) 
	{

		WebDriverWait wait = new WebDriverWait(driver, 120);
		Actions act=new Actions(driver);

		Log.info("Entering VerifyTrainingLinkNotFoundInDocumentationTab");   
		String header = "";

		try
		{ 
			CommonUtility.ScrollTo(driver, obj_EsupportContentHomePage.LeftRail());
			//				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.TrainingLinkInDocumentationTab()));
			if(CommonUtility.CheckpresenceofElementLocated(driver, 2, obj_EsupportCoveoPage.TrainingLinkInDocumentationTab()))
			{
				System.out.println("able to see training link");
				Report.put("Observe the TRAINING link.", 
						"Training link should not be on the left bottom of the Documentation page.",  
						"display Training link", "FAIL");
				Assert.fail();

			}
			else
			{
				System.out.println("not able to see training link");

				Report.put("Observe the TRAINING link.", 
						"Training link should not be on the left bottom of the Documentation page.", 
						"user not able to see training link for searched product", "PASS");  
			}


		}
		catch(Exception e)
		{
			e.printStackTrace();


			Report.put("Observe the TRAINING link.", 
					"Training link should not be on the left bottom of the Documentation page.", 
					"display Training link", "FAIL");

			Assert.fail();
		}
	}

	//Lavanya

	public void ToNavigate_IntegratedSupportHomePage(WebDriver driver)
	{


		System.out.println("Entering method ToNavigate_IntegratedSupportHomePage");
		try{

			handleCookies(driver);

			driver.navigate().to("https://www.dell.com/support/home/en-us");

			handleCookies(driver);
			WebDriverWait wait = new WebDriverWait(driver,100);
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.SupportHeader()));
			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SupportHeader());
			String welcometosupport=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SupportHeader()).getText();
			System.out.println("displayed page is "+welcometosupport);


			Report.put("Open URL 'https://www.dell.com/support/home/us/en/19'",
					"Integrated Support Home page should get loaded.", 
					"Integrated Support Home page loaded Successfully with header "+Report.color(welcometosupport), "PASS");


		} 
		catch(Exception ex)
		{
			ex.printStackTrace();

			Report.put("Open URL 'https://www.dell.com/support/home/us/en/19'",
					"Integrated Support Home page should get loaded.", 
					"Failed to load Integrated Support Home page", "FAIL");
			Assert.fail();
		}
	}

	public void ToNavigate_IntegratedProductHomePage(WebDriver driver)
	{


		System.out.println("Entering method ToNavigate_IntegratedProductHomePage");
		try{

			handleCookies(driver);

			driver.navigate().to("https://www.dell.com/support/home/en-us/product-support/servicetag/0-RGR6ckY3ZklQQlNNeExSWVY4dUk4UT090/overview");
			
			handleCookies(driver);
			WebDriverWait wait = new WebDriverWait(driver,100);
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.ProductSupportHomePage()));
			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ProductSupportHomePage());
			String welcometosupport=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ProductSupportHomePage()).getText();
			System.out.println("displayed page is "+welcometosupport);


			Report.put("Open URL 'https://www.dell.com/support/home/ae/en/aebsdt1/product-support/servicetag/RGR6ckY3ZklQQlNNeExSWVY4dUk4UT090/overview'",
					"Integrated Product Home page should get loaded.", 
					"Integrated Product Home page loaded Successfully with header "+Report.color(welcometosupport), "PASS");


		} 
		catch(Exception ex)
		{
			ex.printStackTrace();

			Report.put("Open URL 'https://www.dell.com/support/home/ae/en/aebsdt1/product-support/servicetag/RGR6ckY3ZklQQlNNeExSWVY4dUk4UT090/overview'",
					"Integrated Product Home page should get loaded.", 
					"Failed to load Integrated Product Home page", "FAIL");
			Assert.fail();
		}
	}

	public void ToNavigate_SearchSupportPage(WebDriver driver)
	{

//		WebDriverWait wait = new WebDriverWait(driver,300);
		System.out.println("Entering method ToNavigate_SearchSupportPage");
		try{

						handleCookies(driver);
			Thread.sleep(10000);
			driver.navigate().to("https://www.dell.com/support/search/en-us");
			Thread.sleep(15000);
//			driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
//			Thread.sleep(10000);

			//			handleCookies(driver);
			
			handleCookies(driver);
			WebDriverWait wait = new WebDriverWait(driver,700);
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.searchSupport()));
			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.searchSupport());
			String welcometosupport=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.searchSupport()).getText();
			System.out.println("displayed page is "+welcometosupport);


			Report.put("Open URL 'https://dell.com/support/search/us/en/19'",
					"Coveo search page should display with heading search support", 
					"Search Support page loaded Successfully with header "+Report.color(welcometosupport), "PASS");


		} 
		catch(Exception ex)
		{
			ex.printStackTrace();

			Report.put("Open URL 'https://dell.com/support/search/us/en/19'",
					"Coveo search page should display with heading search support", 
					"Failed to load search Support page", "FAIL");
			Assert.fail();
		}
	}

	public void ToNavigate_ContactUSHomePagePage(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver,100);

		System.out.println("Entering methods ToNavigate_ContactUSHomePagePage");
		try{

			//			handleCookies(driver);
			Thread.sleep(7000);

			driver.navigate().to("https://www.dell.com/support/incidents-online/us/en/04/contactus/Dynamic?spestate?ref=contactus");
			Thread.sleep(7000);
			handleCookies(driver);

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.ContactUsHomePageHeader()));
			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ContactUsHomePageHeader());
			String welcometosupport=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ContactUsHomePageHeader()).getText();
			System.out.println("displayed page is "+welcometosupport);


			Report.put("Open URL    https://www.dell.com/support/incidents-online/us/en/04/contactus/Dynamic?spestate?ref=contactus",
					"Contact Us Home page should get loaded.", 
					"contact us home page loaded Successfully with header "+Report.color(welcometosupport), "PASS");


		} 
		catch(Exception ex)
		{
			ex.printStackTrace();

			Report.put("Open URL    https://www.dell.com/support/incidents-online/us/en/04/contactus/Dynamic?spestate?ref=contactus",
					"Contact Us Home page should get loaded.",  
					"Failed to load Contact us home page", "FAIL");
			Assert.fail();
		}
	}

	public void ToNavigate_DriversAndDownloadHomePage(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver,10);

		System.out.println("Entering method ToNavigate_DriversAndDownloadHomePage");
		try{

			//			handleCookies(driver);

			driver.navigate().to("https://www.dell.com/support/home/us/en/19?app=drivers");

			handleCookies(driver);

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.DriversAndDonloadsHeadingOnDriversHomePage()));
			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.DriversAndDonloadsHeadingOnDriversHomePage());
			String welcometosupport=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.DriversAndDonloadsHeadingOnDriversHomePage()).getText();
			System.out.println("displayed page is "+welcometosupport);


			Report.put("Open URL     https://www.dell.com/support/home/us/en/19?app=drivers",
					"Drivers & Downloads Home page should get loaded. ", 
					"Drivers and download home page loaded Successfully with header "+Report.color(welcometosupport), "PASS");


		} 
		catch(Exception ex)
		{
			ex.printStackTrace();

			Report.put("Open URL     https://www.dell.com/support/home/us/en/19?app=drivers",
					"Drivers & Downloads Home page should get loaded. ", 
					"Failed to load Drivers and download home page", "FAIL");
			Assert.fail();
		}
	}

	public void ValidateSearchPageWithOutEnteringKeywordInMastHeadAndClickOnSearchButton(WebDriver driver)
	{
		String tag="";
		String overview="";

		Log.info("Entering method ValidateSearchPageWithOutEnteringKeywordInMastHeadAndClickOnSearchButton");
		//		String value=TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal());

		try{
			WebDriverWait wait = new WebDriverWait(driver,100);
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.mastHead()));

			CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.mastHead());
			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.mastHead()).clear();


			CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.SearchButton());

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.mastHead()));

			CommonUtility.scrollToViewElement(driver,obj_EsupportCoveoPage.mastHead());
			tag=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.mastHead()).getText();
			System.out.println("displayed keyword is "+tag);

			//			if(tag.contains(value))
			//			{
			//				System.out.println("pass: searched tag product home page displayed");
			//			}
			//			else
			//			{
			//				System.out.println("searched tag product home page not displayed");
			//				Report.put("Provide Service tag DNPK882 in masthead and click search button.", 
			//						"It should navigate to Product Support home page.", 
			//						"not able to search given service tag in mast head", "FAIL");   
			//				
			//				Assert.fail();
			//			}
			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.searchSupport());
			String welcometosupport=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.searchSupport()).getText();
			System.out.println("displayed page is "+welcometosupport);

			Report.put("Without entering the keyword in Masthead, press Search button.", 
					"It shouldn't navigate to search page showing result set.", 
					"user able to search without entering any keyword and click on search button, user shouldn't navigate to search page showing result set."+Report.color(tag), "PASS");   


		}
		catch(Exception ex){
			ex.printStackTrace();
			Report.put("Without entering the keyword in Masthead, press Search button.", 
					"It shouldn't navigate to search page showing result set.", 
					"not able to click on search button in mast head", "FAIL");   

			Assert.fail();
		}
	}

	public void ValidateSearchPageWithEnteringSpaceInMastHeadAndClickOnSearchButton(WebDriver driver)
	{
		String tag="";
		String overview="";

		Log.info("Entering in method ValidateSearchPageWithEnteringSpaceInMastHeadAndClickOnSearchButton");
		//		String value=TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal());

		try{
			WebDriverWait wait = new WebDriverWait(driver,100);
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.mastHead()));

			CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.mastHead());
			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.mastHead()).clear();
			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.mastHead()).sendKeys(Keys.SPACE);

			CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.SearchButton());

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.mastHead()));

			CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.mastHead());
			tag=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.mastHead()).getText();
			System.out.println("displayed is "+tag);

			//			if(tag.contains(value))
			//			{
			//				System.out.println("pass: searched tag product home page displayed");
			//			}
			//			else
			//			{
			//				System.out.println("searched tag product home page not displayed");
			//				Report.put("Provide Service tag DNPK882 in masthead and click search button.", 
			//						"It should navigate to Product Support home page.", 
			//						"not able to search given service tag in mast head", "FAIL");   
			//				
			//				Assert.fail();
			//			}

			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.searchSupport());
			String welcometosupport=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.searchSupport()).getText();
			System.out.println("displayed page is "+welcometosupport);

			Report.put("Press Spacebar in Masthead and click  Search button", 
					"It shouldn't navigate to search page showing result set. ", 
					"User able to enter space in mast head and able to click on search button, user not navigated to search page showing different result set", "PASS");   


		}
		catch(Exception ex){
			ex.printStackTrace();
			Report.put("Press Spacebar in Masthead and click  Search button", 
					"It shouldn't navigate to search page showing result set. ",
					"not able to click on search button in mast head", "FAIL");   

			Assert.fail();
		}
	}

	public void ValidateSearchingServiceTagInMastHead(WebDriver driver)
	{
		String tag="";
		String overview="";
		
		Log.info("Entering in method ValidateSearchingServiceTagInMastHead");
		String value=TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal());
		//		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);

		try{
			handleCookies(driver);
			WebDriverWait wait = new WebDriverWait(driver, 200);

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.mastHead()));
			CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.mastHead());
			CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.mastHead());
			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.mastHead()).clear();
			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.mastHead()).sendKeys(value);
			CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.SearchButtonMastHead());
			CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.SearchButtonMastHead());
			
//			Thread.sleep(6000);
//			driver.navigate().refresh();
			Thread.sleep(10000);

			if(CommonUtility.CheckpresenceofElementLocated(driver,30,obj_EsupportCoveoPage.ServiceTagValidationOnProductSupportPage()))
			{
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.ServiceTagValidationOnProductSupportPage()));

				CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.ServiceTagValidationOnProductSupportPage());
				tag=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ServiceTagValidationOnProductSupportPage()).getText();
				System.out.println("tag displayed is "+tag);

				if(tag.contains(value))
				{
					System.out.println("pass: searched tag product home page displayed");
				}
				else
				{
					System.out.println("searched tag product home page not displayed");
					Report.put("Provide Service tag DNPK882 in masthead and click search button.", 
							"It should navigate to Product Support home page.", 
							"not able to search given service tag in mast head", "FAIL");   

					Assert.fail();
				}
			}
			else
			{
				CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.SearchButton());
				CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.SearchButton());
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.ServiceTagValidationOnProductSupportPage()));

				CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.ServiceTagValidationOnProductSupportPage());
				tag=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ServiceTagValidationOnProductSupportPage()).getText();
				System.out.println("tag displayed is "+tag);

				if(tag.contains(value))
				{
					System.out.println("pass: searched tag product home page displayed");
				}
				else
				{
					System.out.println("searched tag product home page not displayed");
					Report.put("Provide Service tag DNPK882 in masthead and click search button.", 
							"It should navigate to Product Support home page.", 
							"not able to search given service tag in mast head", "FAIL");   

					Assert.fail();
				}
			}

			Thread.sleep(10000);

			CommonUtility.ScrollTo(driver,obj_EsupportContentHomePage.DefaultDisplayedTabInProductHomePage());
			overview=CommonUtility.highlightElement(driver,obj_EsupportContentHomePage.DefaultDisplayedTabInProductHomePage()).getText();
			System.out.println("displayed tab is "+overview);



			Report.put("Provide Service tag DNPK882 in masthead and click search button.", 
					"It should navigate to Product Support home page.", 
					"user able to search "+Report.color(value)+" in mast head and linding on "+Report.color(tag)+" Product support home page and default landing on "+Report.color(overview)+" tag", "PASS");   


		}
		catch(Exception ex){
			ex.printStackTrace();
			Report.put("Provide Service tag DNPK882 in masthead and click search button.", 
					"It should navigate to Product Support home page.", 
					"not able to search given service tag in mast head", "FAIL");   

			Assert.fail();
		}
	}

	public void ValidateSearchingExpressServiceCodeInMastHead(WebDriver driver)
	{
		String tag="";
		String overview="";

		Log.info("Entering in method ValidateSearchingExpressServiceCodeInMastHead");
		String value=TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[0];
		//		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);

		try{
			handleCookies(driver);
			WebDriverWait wait = new WebDriverWait(driver, 200);

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.mastHead()));
			CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.mastHead());
			CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.mastHead());
			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.mastHead()).clear();
			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.mastHead()).sendKeys(value);
			CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.SearchButton2());
			CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.SearchButton2());

			if(CommonUtility.CheckpresenceofElementLocated(driver,30,obj_EsupportCoveoPage.ExpressServiceCodeInProductHomePage()))
			{
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.ExpressServiceCodeInProductHomePage()));

				CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.ExpressServiceCodeInProductHomePage());
				tag=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ExpressServiceCodeInProductHomePage()).getText();
				System.out.println("tag displayed is "+tag);

				if(tag.contains(value))
				{
					System.out.println("pass: searched express service code displayed");
				}
				else
				{
					System.out.println("searched express service code not displayed");
					Report.put("Type the Express Service Code in Masthead and click Search button.", 
							"It should display the Details of the system with Express Service Code provided.  ", 
							"not able to search given express service code in mast head", "FAIL");   

					Assert.fail();
				}
			}
			else
			{
				CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.SearchButton());
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.ExpressServiceCodeInProductHomePage()));

				CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.ExpressServiceCodeInProductHomePage());
				tag=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ExpressServiceCodeInProductHomePage()).getText();
				System.out.println("tag displayed is "+tag);

				if(tag.contains(value))
				{
					System.out.println("pass: searched express service code displayed");
				}
				else
				{
					System.out.println("searched express service code not displayed");
					Report.put("Type the Express Service Code in Masthead and click Search button.", 
							"It should display the Details of the system with Express Service Code provided.  ", 
							"not able to search given express service code in mast head", "FAIL");   

					Assert.fail();
				}
			}

			Thread.sleep(10000);

			CommonUtility.ScrollTo(driver,obj_EsupportContentHomePage.DefaultDisplayedTabInProductHomePage());
			overview=CommonUtility.highlightElement(driver,obj_EsupportContentHomePage.DefaultDisplayedTabInProductHomePage()).getText();
			System.out.println("displayed tab is "+overview);



			Report.put("Type the Express Service Code in Masthead and click Search button.", 
					"It should display the Details of the system with Express Service Code provided.  ",
					"user able to search "+Report.color(value)+" in mast head and linding on "+Report.color(tag)+" Product support home page and default landing on "+Report.color(overview)+" tag", "PASS");   


		}
		catch(Exception ex){
			ex.printStackTrace();
			Report.put("Type the Express Service Code in Masthead and click Search button.", 
					"It should display the Details of the system with Express Service Code provided.  ",
					"not able to search given Express Service Code in mast head", "FAIL");   

			Assert.fail();
		}
	}
	public void  SearchLatiInMastHeadAndSearchAutoDisplayedResults(WebDriver driver) 
	{
		Log.info("Entering SearchLatiInMastHeadAndSearchAutoDisplayedResults");   
		String searchvalue = TestNGCreator.TestData.get(Esupport.SearchOption.ordinal());
		String ltMessages1 = "";
		String ltMessages="";
		String Productsupportpage="";
		String searchresults="";
		String viewallresultsfor="";

		try
		{	
			//handleCookies(driver);
			WebDriverWait wait = new WebDriverWait(driver, 300);
			Actions act=new Actions(driver);

			if(CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SearchTextbox()).isDisplayed())
			{
				//				act.moveToElement(CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SearchTextbox())).build().perform();
				CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SearchTextbox()).clear();
				CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.SearchTextbox());
				CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.SearchTextbox());
//				CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SearchTextbox()).clear();
//				Thread.sleep(3000);
				CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SearchTextbox()).sendKeys(searchvalue);
				
				Thread.sleep(3000);
				
				CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SearchTextbox()).clear();
				CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.SearchTextbox());
				CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.SearchTextbox());
				CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SearchTextbox()).clear();
				Thread.sleep(3000);
				CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SearchTextbox()).sendKeys(searchvalue);
//				char[] NameInputArray = searchvalue.toCharArray();
//				for(int j=0;j<NameInputArray.length;j++)
//				{
//					driver.findElement(obj_EsupportCoveoPage.mastHead()).sendKeys(String.valueOf(NameInputArray[j]));
//					Thread.sleep(7000);
//				}
				System.out.println("Value from test data is"+searchvalue);
				Thread.sleep(6000);
//				CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SearchTextbox()).sendKeys(Keys.SPACE);
//				CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SearchTextbox()).sendKeys(Keys.BACK_SPACE);
//				Thread.sleep(7000);
//				CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SearchTextbox()).sendKeys(Keys.SPACE);
//				CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SearchTextbox()).sendKeys(Keys.BACK_SPACE);
				Thread.sleep(6000);
				//wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.ProductSupportPagesHeadingInMastHeadSearchResults()));
				CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.ProductSupportPagesHeadingInMastHeadSearchResults());
				Productsupportpage=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ProductSupportPagesHeadingInMastHeadSearchResults()).getText();
				System.out.println("heading is "+Productsupportpage);

				List<WebElement> list=driver.findElements(obj_EsupportCoveoPage.ProductSupportPagesResultsInMastHeadSearchResults());
				int count=list.size();
				System.out.println("list of lati count is :  " +count );
				try
				{
				for(WebElement lt:list)
				{

					CommonUtility.highlightElement(driver, lt);
					String names=lt.getText();

					System.out.println("Alert Name is: " +names);
					ltMessages+=" <br> " + names;

				}

				System.out.println("product support page search results are "+ltMessages);
				}
				catch(Exception e)
				{
					
				}

//				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.SearchResultsHeadingInMastHeadSearchResults()));
//				CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.SearchResultsHeadingInMastHeadSearchResults());
//				searchresults=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SearchResultsHeadingInMastHeadSearchResults()).getText();
//				System.out.println("heading is "+searchresults);
//
//				List<WebElement> list1=driver.findElements(obj_EsupportCoveoPage.SearchResultsResultsInMastHeadSearchResults());
//				int count1=list1.size();
//				System.out.println("list of lati count displayed under search results is :  " +count1 );
//
//				for(WebElement lt:list1)
//				{
//					CommonUtility.scrollToViewElement(driver, lt);
//					CommonUtility.highlightElement(driver, lt);
//					String names=lt.getText();
//
//					System.out.println("result displayed under search results is: " +names);
//					ltMessages1+=" <br> " + names;
//
//				}
//
//				System.out.println("search results displayed are "+ltMessages1);

//				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.ViewAllResultsForLinkResultsinMastHeadSearchResults()));
				CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.ViewAllResultsForLinkResultsinMastHeadSearchResults());
				viewallresultsfor=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ViewAllResultsForLinkResultsinMastHeadSearchResults()).getText();
				System.out.println("last displayedlink name is  is "+viewallresultsfor);


				Report.put("Type Lati in masthead.", 
						"It should provide list of products starting with letters LATI. It should show two sections namely 1. Dell Products - Should appear only when there are related products.2.<br> Search Results - Should always appear and display the related recent search keywords. 3. View all Results for (should always appear)" , 
						"user able to type "+Report.color(searchvalue)+" and able to see auto-populated results "+Report.color(Productsupportpage)+" header follows all options and displayed count is "+count+" <br> and display "+Report.color(searchresults)+" heading along with options "+Report.color(ltMessages1)+" with count of "+count1+" <br> and also display link "+Report.color(viewallresultsfor), "PASS");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();

			Report.put("Type Lati in masthead.", 
					"It should provide list of products starting with letters LATI. It should show two sections namely 1. Dell Products - Should appear only when there are related products.2.<br> Search Results - Should always appear and display the related recent search keywords. 3. View all Results for (should always appear)" , 
					"failed to display all expected auto-populated results", "FAIL");
			Assert.fail();
		}
	}
	
	
	
	public void  SearchLatiInMastHeadAndSearchAutoDisplayedResultsForSupportPage(WebDriver driver) 
	{
		Log.info("Entering SearchLatiInMastHeadAndSearchAutoDisplayedResultsForSupportPage");   
		String searchvalue = TestNGCreator.TestData.get(Esupport.SearchOption.ordinal());
		String ltMessages1 = "";
		String ltMessages="";
		String Productsupportpage="";
		String searchresults="";
		String viewallresultsfor="";

		try
		{	
			//handleCookies(driver);
			WebDriverWait wait = new WebDriverWait(driver, 120);
			Actions act=new Actions(driver);

			if(CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SearchTextbox()).isDisplayed())
			{
				//				act.moveToElement(CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SearchTextbox())).build().perform();
				CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.SearchTextbox());
//				CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SearchTextbox()).clear();
//				Thread.sleep(3000);
//				CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SearchTextbox()).sendKeys(searchvalue);
				char[] NameInputArray = searchvalue.toCharArray();
				for(int j=0;j<NameInputArray.length;j++)
				{
					driver.findElement(obj_EsupportCoveoPage.mastHead()).sendKeys(String.valueOf(NameInputArray[j]));
					Thread.sleep(2000);
				}
				System.out.println("Value from test data is"+searchvalue);
				
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.ProductSupportPagesHeadingInMastHeadSearchResults()));
				CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.ProductSupportPagesHeadingInMastHeadSearchResults());
				Productsupportpage=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ProductSupportPagesHeadingInMastHeadSearchResults()).getText();
				System.out.println("heading is "+Productsupportpage);

				List<WebElement> list=driver.findElements(obj_EsupportCoveoPage.ProductSupportPagesResultsInMastHeadSearchResults());
				int count=list.size();
				System.out.println("list of lati count is :  " +count );
				try
				{
				for(WebElement lt:list)
				{

					CommonUtility.highlightElement(driver, lt);
					String names=lt.getText();

					System.out.println("Alert Name is: " +names);
					ltMessages+=" <br> " + names;

				}

				System.out.println("product support page search results are "+ltMessages);
				}
				catch(Exception e)
				{
					
				}

				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.SearchResultsHeadingInMastHeadSearchResults()));
				CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.SearchResultsHeadingInMastHeadSearchResults());
				searchresults=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SearchResultsHeadingInMastHeadSearchResults()).getText();
				System.out.println("heading is "+searchresults);

				List<WebElement> list1=driver.findElements(obj_EsupportCoveoPage.Searchresultpagesearchautopopulatedresult());
				int count1=list1.size();
				System.out.println("list of lati count displayed under search results is :  " +count1 );

				for(WebElement lt:list1)
				{
					CommonUtility.scrollToViewElement(driver, lt);
					CommonUtility.highlightElement(driver, lt);
					String names=lt.getText();

					System.out.println("result displayed under search results is: " +names);
					ltMessages1+=" <br> " + names;

				}

				System.out.println("search results displayed are "+ltMessages1);

				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.ViewAllResultsForLinkResultsinMastHeadSearchResults()));
				CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.ViewAllResultsForLinkResultsinMastHeadSearchResults());
				viewallresultsfor=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ViewAllResultsForLinkResultsinMastHeadSearchResults()).getText();
				System.out.println("last displayedlink name is  is "+viewallresultsfor);


				Report.put("Type Lati in masthead.", 
						"It should provide list of products starting with letters LATI. It should show two sections namely 1. Dell Products - Should appear only when there are related products.2.<br> Search Results - Should always appear and display the related recent search keywords. 3. View all Results for (should always appear)" , 
						"user able to type "+Report.color(searchvalue)+" and able to see auto-populated results "+Report.color(Productsupportpage)+" header follows all options and displayed count is "+count+" <br> and display "+Report.color(searchresults)+" heading along with options "+Report.color(ltMessages1)+" with count of "+count1+" <br> and also display link "+Report.color(viewallresultsfor), "PASS");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();

			Report.put("Type Lati in masthead.", 
					"It should provide list of products starting with letters LATI. It should show two sections namely 1. Dell Products - Should appear only when there are related products.2.<br> Search Results - Should always appear and display the related recent search keywords. 3. View all Results for (should always appear)" , 
					"failed to display all expected auto-populated results", "FAIL");
			Assert.fail();
		}
	}

	public void  ValidateSearchForKeywordLatiAndSelectFirstResultFromSearchResultsAutoDisplayedResult(WebDriver driver) 
	{
		Log.info("Entering ValidateSearchForKeywordLatiAndSelectFirstResultFromSearchResultsAutoDisplayedResult");   


		String searchvalue = TestNGCreator.TestData.get(Esupport.SearchOption.ordinal());

		String enteredtext = "";
		String searchresult="";
		String filter="";

		String resourcetype1 = TestNGCreator.TestData.get(Esupport.Dpid.ordinal()).split(";")[0];
		String resourcetype2 = TestNGCreator.TestData.get(Esupport.Dpid.ordinal()).split(";")[1];
		String resourcetype3 = TestNGCreator.TestData.get(Esupport.Dpid.ordinal()).split(";")[2];
		String resourcetype4 = TestNGCreator.TestData.get(Esupport.Dpid.ordinal()).split(";")[3];
		String resourcetype5 = TestNGCreator.TestData.get(Esupport.Dpid.ordinal()).split(";")[4];
		String resourcetype6 = TestNGCreator.TestData.get(Esupport.Dpid.ordinal()).split(";")[5];
		Actions act=new Actions(driver);

		try
		{   
			WebDriverWait wait = new WebDriverWait(driver, 300);
			//			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.SearchTextbox()));
			
			Thread.sleep(5000);
			if(CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.FirstResultSearchResultsInMastHeadSearchResults()).isDisplayed())
			{
				//				CommonUtility.scrollToViewElement(driver,obj_EsupportCoveoPage.FirstResultSearchResultsInMastHeadSearchResults());
				//				CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.FirstResultSearchResultsInMastHeadSearchResults()).click();
//				CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.FirstResultSearchResultsInMastHeadSearchResults());
//				Thread.sleep(5000);
				CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.FirstResultSearchResultsInMastHeadSearchResults());
				if(CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.FirstResultSearchResultsInMastHeadSearchResults()).isDisplayed())
				{
				CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.FirstResultSearchResultsInMastHeadSearchResults());
				
				}
				else if(CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.FirstResultSearchResultsInMastHeadSearchResults()).isDisplayed())
				{
					CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.FirstResultSearchResultsInMastHeadSearchResults());
//					CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.FirstResultSearchResultsInMastHeadSearchResults());
					act.moveToElement(CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.FirstResultSearchResultsInMastHeadSearchResults())).click().build().perform();
				}
				else
				{
					CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.FirstResultSearchResultsInMastHeadSearchResults());
//					CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.FirstResultSearchResultsInMastHeadSearchResults());
				
					act.moveToElement(CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.FirstResultSearchResultsInMastHeadSearchResults())).click().build().perform();
				//				driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
				}
				System.out.println("clicked");
				Thread.sleep(10000);
			}

			handleCookies(driver);
			
			Thread.sleep(6000);
			driver.navigate().refresh();
			Thread.sleep(10000);
			
//			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.searchSupport()));
			CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.searchSupport());
//			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.searchSupport());
			handleCookies(driver);
			System.out.println(driver.getCurrentUrl());
			if(driver.getCurrentUrl().contains("Facet"))
			{
				Log.info("test case pass: url contains Facet keyword");
			}
			else
			{
				Log.info("test case fail: url doesnt contains Facet keyword");
				Report.put("Select any keyword from Search Results section", 
						"It should display the Coveo search results for the selected keyword.",
						"not landed on coveo page", "FAIL");;
//						Assert.fail();
			}
			Thread.sleep(5000);
			enteredtext=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.KewordValidationInCoveoPage()).getText();
			System.out.println(enteredtext);
			String valuelower=searchvalue.toLowerCase();
			if(enteredtext.contains(valuelower))
			{
				Log.info("test case pass: keyword selected is displayed in search of coveo result");
			}
			else
			{
				Log.info("test case fail: keyword selected is not displayed in search of coveo result");
				Report.put("Select any keyword from Search Results section", 
						"It should display the Coveo search results for the selected keyword.", 
						"not landed on correct coveo page for searched Keyword "+Report.color(searchvalue), "FAIL");;
						Assert.fail();
			}

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.GetCoveoOverAllSearchResult()));
			searchresult=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.GetCoveoOverAllSearchResult()).getText();
			System.out.println("all result is for entered keyword is "+searchresult);

			List<WebElement> resourcetypelist=driver.findElements(obj_EsupportCoveoPage.ValidateResourceTypeIsSelected());
			int resourcetypecount=resourcetypelist.size();
			System.out.println("total number of resources displayed are "+resourcetypecount);

			for(int i=0; i<resourcetypecount;i++)
			{
				if(CommonUtility.highlightElement(driver,resourcetypelist.get(i)).isSelected())
				{
					Log.info("test case fail: resource types selected");
					Report.put("Select any keyword from Search Results section", 
							"It should display the Coveo search results for the selected keyword.",
							"Any of Resource Type is selected by default", "FAIL");;
							Assert.fail();
				}
			}

			String filterheader=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ValidateFiltersSectionHeader()).getText();
			System.out.println("header is "+filterheader);

			List<WebElement> getallfilters=driver.findElements(obj_EsupportCoveoPage.GetAllFilters());
			int totalfilterscount=getallfilters.size();
			System.out.println("total count of selected filters "+totalfilterscount);

			for(int j=0;j<totalfilterscount;j++)
			{
				filter+=",<br>"+getallfilters.get(j).getText();
				System.out.println("filters displayed are "+filter);

				if (filter.contains(resourcetype1) || filter.contains(resourcetype2)|| filter.contains(resourcetype3)|| filter.contains(resourcetype4)|| filter.contains(resourcetype5)|| filter.contains(resourcetype6))
				{
					Log.info("test case fail: resource types displayed under your filters section");
					Report.put("Select any keyword from Search Results section", 
							"It should display the Coveo search results for the selected keyword.",
							"Any of Resource Type "+Report.color(filter)+" is displayed by default under heading "+Report.color(filterheader), "FAIL");;
							Assert.fail();
				}

			}

			Report.put("Select any keyword from Search Results section", 
					"It should display the Coveo search results for the selected keyword.",
					"user able to click on first displayed "+Report.color(searchvalue)+" Successfully.<br> and coveo search page displayed with all relevant results displayed with result count of "+Report.color(searchresult)+"<br> and filters displayed under "+Report.color(filterheader)+" are <br> "+Report.color(filter), "PASS");

			Thread.sleep(3000);                     
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Select any keyword from Search Results section", 
					"It should display the Coveo search results for the selected keyword.",
					"coveo search results display with default selected any of resource type or not landed on searched keyword coveo search result page", "FAIL");
			Assert.fail();
		}
	}
	
	public void  ValidateSearchForKeywordLatiAndSelectFirstResultFromSearchResultsAutoDisplayedResultForSearchPage(WebDriver driver) 
	{
		Log.info("Entering ValidateSearchForKeywordLatiAndSelectFirstResultFromSearchResultsAutoDisplayedResultForSearchPage");   


		String searchvalue = TestNGCreator.TestData.get(Esupport.SearchOption.ordinal());

		String enteredtext = "";
		String searchresult="";
		String filter="";

		String resourcetype1 = TestNGCreator.TestData.get(Esupport.Dpid.ordinal()).split(";")[0];
		String resourcetype2 = TestNGCreator.TestData.get(Esupport.Dpid.ordinal()).split(";")[1];
		String resourcetype3 = TestNGCreator.TestData.get(Esupport.Dpid.ordinal()).split(";")[2];
		String resourcetype4 = TestNGCreator.TestData.get(Esupport.Dpid.ordinal()).split(";")[3];
		String resourcetype5 = TestNGCreator.TestData.get(Esupport.Dpid.ordinal()).split(";")[4];
		String resourcetype6 = TestNGCreator.TestData.get(Esupport.Dpid.ordinal()).split(";")[5];
		Actions act=new Actions(driver);

		try
		{   
			WebDriverWait wait = new WebDriverWait(driver, 300);
			//			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.SearchTextbox()));
			if(CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.FirstResultSearchResultsInMastHeadSearchResultsForSearchResult()).isDisplayed())
			{
				//				CommonUtility.scrollToViewElement(driver,obj_EsupportCoveoPage.FirstResultSearchResultsInMastHeadSearchResults());
				//				CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.FirstResultSearchResultsInMastHeadSearchResults()).click();
				CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.FirstResultSearchResultsInMastHeadSearchResultsForSearchResult());
				//				act.moveToElement(CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.FirstResultSearchResultsInMastHeadSearchResults())).click().build().perform();
				//				driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);

				Thread.sleep(10000);
			}

			handleCookies(driver);
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.searchSupport()));
			CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.searchSupport());
//			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.searchSupport());
			handleCookies(driver);
			System.out.println(driver.getCurrentUrl());
			if(driver.getCurrentUrl().contains("Facet"))
			{
				Log.info("test case pass: url contains Facet keyword");
			}
			else
			{
				Log.info("test case fail: url doesnt contains Facet keyword");
				Report.put("Select any keyword from Search Results section", 
						"It should display the Coveo search results for the selected keyword.",
						"not landed on coveo page", "FAIL");;
						Assert.fail();
			}
			Thread.sleep(5000);
			CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.KewordValidationInCoveoPage());
			enteredtext=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.KewordValidationInCoveoPage()).getText();
			System.out.println(enteredtext);
			String valuelower=searchvalue.toLowerCase();
			if(!enteredtext.equalsIgnoreCase(valuelower))
			{
				Log.info("test case pass: keyword selected is displayed in search of coveo result");
			}
			else
			{
				Log.info("test case fail: keyword selected is not displayed in search of coveo result");
				Report.put("Select any keyword from Search Results section", 
						"It should display the Coveo search results for the selected keyword.", 
						"not landed on correct coveo page for searched Keyword "+Report.color(searchvalue), "FAIL");;
						Assert.fail();
			}

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.GetCoveoOverAllSearchResult()));
			searchresult=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.GetCoveoOverAllSearchResult()).getText();
			System.out.println("all result is for entered keyword is "+searchresult);

			List<WebElement> resourcetypelist=driver.findElements(obj_EsupportCoveoPage.ValidateResourceTypeIsSelected());
			int resourcetypecount=resourcetypelist.size();
			System.out.println("total number of resources displayed are "+resourcetypecount);

			for(int i=0; i<resourcetypecount;i++)
			{
				if(CommonUtility.highlightElement(driver,resourcetypelist.get(i)).isSelected())
				{
					Log.info("test case fail: resource types selected");
					Report.put("Select any keyword from Search Results section", 
							"It should display the Coveo search results for the selected keyword.",
							"Any of Resource Type is selected by default", "FAIL");;
							Assert.fail();
				}
			}

			String filterheader=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ValidateFiltersSectionHeader()).getText();
			System.out.println("header is "+filterheader);

			List<WebElement> getallfilters=driver.findElements(obj_EsupportCoveoPage.GetAllFilters());
			int totalfilterscount=getallfilters.size();
			System.out.println("total count of selected filters "+totalfilterscount);

			for(int j=0;j<totalfilterscount;j++)
			{
				filter+=",<br>"+getallfilters.get(j).getText();
				System.out.println("filters displayed are "+filter);

				if (filter.contains(resourcetype1) || filter.contains(resourcetype2)|| filter.contains(resourcetype3)|| filter.contains(resourcetype4)|| filter.contains(resourcetype5)|| filter.contains(resourcetype6))
				{
					Log.info("test case fail: resource types displayed under your filters section");
					Report.put("Select any keyword from Search Results section", 
							"It should display the Coveo search results for the selected keyword.",
							"Any of Resource Type "+Report.color(filter)+" is displayed by default under heading "+Report.color(filterheader), "FAIL");;
							Assert.fail();
				}

			}

			Report.put("Select any keyword from Search Results section", 
					"It should display the Coveo search results for the selected keyword.",
					"user able to click on first displayed "+Report.color(searchvalue)+" Successfully.<br> and coveo search page displayed with all relevant results displayed with result count of "+Report.color(searchresult)+"<br> and filters displayed under "+Report.color(filterheader)+" are <br> "+Report.color(filter), "PASS");

			Thread.sleep(3000);                     
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Select any keyword from Search Results section", 
					"It should display the Coveo search results for the selected keyword.",
					"coveo search results display with default selected any of resource type or not landed on searched keyword coveo search result page", "FAIL");
			Assert.fail();
		}
	}

	public void  ValidateSearchForKeywordLatiAndSelectFirstResultFromAutoDisplayedResultProductSupportPage(WebDriver driver, String SearchOption, String Dpid) 
	{
		Log.info("Entering ValidateSearchForKeywordLatiAndSelectFirstResultFromAutoDisplayedResultProductSupportPage");   
		WebDriverWait wait = new WebDriverWait(driver, 300);

		String searchvalue = TestNGCreator.TestData.get(Esupport.SearchOption.ordinal());
		String overview = "";
		String tag="";
		String firstvalue="";

		Actions act=new Actions(driver);

		try
		{       
			if(CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SearchTextbox()).isDisplayed())
			{
				//				act.moveToElement(CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SearchTextbox())).build().perform();
				CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.SearchTextbox());
				CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.SearchTextbox());
				CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SearchTextbox()).clear();
//				Thread.sleep(3000);
				CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SearchTextbox()).sendKeys(searchvalue);
//				char[] NameInputArray = searchvalue.toCharArray();
//				for(int j=0;j<NameInputArray.length;j++)
//				{
//					driver.findElement(obj_EsupportCoveoPage.mastHead()).sendKeys(String.valueOf(NameInputArray[j]));
//					Thread.sleep(2000);
//				}
//				System.out.println("Value from test data is"+searchvalue);
				Thread.sleep(6000);
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.FirstResultProductSupportPagesInMastHeadSearchResults()));
				CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.FirstResultProductSupportPagesInMastHeadSearchResults());
				if(CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.FirstResultProductSupportPagesInMastHeadSearchResults()).isDisplayed())
				{
//					CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.FirstResultProductSupportPagesInMastHeadSearchResults());
					firstvalue=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.FirstResultProductSupportPagesInMastHeadSearchResults()).getText();
					System.out.println("first displayed result under product support page auto-populated search result is "+firstvalue);

					//					CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.FirstResultProductSupportPagesInMastHeadSearchResults()).click();
					CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.FirstResultProductSupportPagesInMastHeadSearchResults());
					CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.FirstResultProductSupportPagesInMastHeadSearchResults());

					Thread.sleep(10000);
				}
				else if(CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.FirstResultProductSupportPagesInMastHeadSearchResults()).isDisplayed())
				{
//					CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.FirstResultProductSupportPagesInMastHeadSearchResults());
					firstvalue=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.FirstResultProductSupportPagesInMastHeadSearchResults()).getText();
					System.out.println("first displayed result under product support page auto-populated search result is "+firstvalue);

					//					CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.FirstResultProductSupportPagesInMastHeadSearchResults()).click();
					CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.FirstResultProductSupportPagesInMastHeadSearchResults());
//					CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.FirstResultProductSupportPagesInMastHeadSearchResults());
					CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.FirstResultSearchResultsInMastHeadSearchResults());
//					CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.FirstResultSearchResultsInMastHeadSearchResults());
					act.moveToElement(CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.FirstResultSearchResultsInMastHeadSearchResults())).click().build().perform();
					Thread.sleep(10000);
				}
				else
				{
					firstvalue=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.FirstResultProductSupportPagesInMastHeadSearchResults()).getText();
					System.out.println("first displayed result under product support page auto-populated search result is "+firstvalue);

					//					CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.FirstResultProductSupportPagesInMastHeadSearchResults()).click();
					CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.FirstResultProductSupportPagesInMastHeadSearchResults());
//					CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.FirstResultProductSupportPagesInMastHeadSearchResults());
					CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.FirstResultSearchResultsInMastHeadSearchResults());
					CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.FirstResultSearchResultsInMastHeadSearchResults());
//					act.moveToElement(CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.FirstResultSearchResultsInMastHeadSearchResults())).click().build().perform();
					Thread.sleep(10000);
				}


				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.ProductSupportHomePage()));

				CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.ProductSupportHomePage());
				tag=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ProductSupportHomePage()).getText();
				System.out.println("displayed product is "+tag);

				if(tag.contains(firstvalue))
				{
					System.out.println("pass: selected result product home page displayed");
				}
				else
				{
					System.out.println("selected result product home page not displayed");
					Report.put("Select any product from the products list section.", 
							"It should navigate to Product Support Home page.", 
							"not able to see clicked product in product home page", "FAIL");   

					Assert.fail();
				}

				//			CommonUtility.scrollToViewElement(driver,obj_EsupportContentHomePage.DefaultDisplayedTabInProductHomePage());
				Thread.sleep(10000);
				overview=CommonUtility.highlightElement(driver,obj_EsupportContentHomePage.DefaultDisplayedTabInProductHomePage()).getText();
				System.out.println("displayed tab is "+overview);



				Report.put("Select any product from the products list section.", 
						"It should navigate to Product Support Home page.", 
						"User able to click on first displayed result under products list "+Report.color(firstvalue)+ " and able to see product home page displaed with product name "+Report.color(tag)+ " landed on "+Report.color(overview)+" tab by default", "PASS");

				Thread.sleep(3000);                     
			}
			else
			{
				Report.put("Select any product from the products list section.", 
						"It should navigate to Product Support Home page.", 
						"for searched key word "+Report.color(searchvalue)+ " product support pages not displayed in auto-populated view", "PASS");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Select any product from the products list section.", 
					"It should navigate to Product Support Home page.", 
					"not able to select first displayed product support home page", "FAIL");;
					Assert.fail();
		}
	}

	public void  ValidateSearchForKeywordLatiAndClickOnViewAllResultsForAutoDisplayedResult(WebDriver driver) 
	{
		Log.info("Entering ValidateSearchForKeywordLatiAndClickOnViewAllResultsForAutoDisplayedResult");   
		WebDriverWait wait = new WebDriverWait(driver, 300);

		String searchvalue = TestNGCreator.TestData.get(Esupport.SearchOption.ordinal());

		String enteredtext = "";
		String searchresult="";
		String filter="";

		String resourcetype1 = TestNGCreator.TestData.get(Esupport.Dpid.ordinal()).split(";")[0];
		String resourcetype2 = TestNGCreator.TestData.get(Esupport.Dpid.ordinal()).split(";")[1];
		String resourcetype3 = TestNGCreator.TestData.get(Esupport.Dpid.ordinal()).split(";")[2];
		String resourcetype4 = TestNGCreator.TestData.get(Esupport.Dpid.ordinal()).split(";")[3];
		String resourcetype5 = TestNGCreator.TestData.get(Esupport.Dpid.ordinal()).split(";")[4];
		String resourcetype6 = TestNGCreator.TestData.get(Esupport.Dpid.ordinal()).split(";")[5];
		Actions act=new Actions(driver);

		try
		{   
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.SearchTextbox()));

			if(CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SearchTextbox()).isDisplayed())
			{
				//				act.moveToElement(CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SearchTextbox())).build().perform();
				CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.SearchTextbox());
				CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.SearchTextbox());
				CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SearchTextbox()).clear();
//				Thread.sleep(3000);
				CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SearchTextbox()).sendKeys(searchvalue);

//				char[] NameInputArray = searchvalue.toCharArray();
//				for(int j=0;j<NameInputArray.length;j++)
//				{
//					driver.findElement(obj_EsupportCoveoPage.mastHead()).sendKeys(String.valueOf(NameInputArray[j]));
//					Thread.sleep(2000);
//				}
				System.out.println("Value from test data is"+searchvalue);
			}
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.ViewAllResultsForLinkResultsinMastHeadSearchResults()));
			if(CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ViewAllResultsForLinkResultsinMastHeadSearchResults()).isDisplayed())
			{
				//				CommonUtility.scrollToViewElement(driver,obj_EsupportCoveoPage.ViewAllResultsForLinkResultsinMastHeadSearchResults());
				//				CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ViewAllResultsForLinkResultsinMastHeadSearchResults()).click();
				CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.ViewAllResultsForLinkResultsinMastHeadSearchResults());
				CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.ViewAllResultsForLinkResultsinMastHeadSearchResults());

				Thread.sleep(10000);
			}

			Thread.sleep(6000);
//			driver.navigate().refresh();
//			Thread.sleep(10000);
//			Thread.sleep(10000);
//			driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.searchSupport()));
			Thread.sleep(10000);
			Thread.sleep(6000);
			String url=driver.getCurrentUrl();
			System.out.println("URL is "+url);
			if(url.contains("Facet"))
			{
				//Log.info("test case pass: url contains Facet keyword");
				Log.info("test case pass: url contains Facet keyword");
			}
			else
			{
				Log.info("test case fail: url doesnt contains Facet keyword");
				Report.put("Click 'View all Results for '  '' link ", 
						"It should display the Coveo Search results page.",
						"not landed on coveo page", "FAIL");;
						Assert.fail();
			}
			enteredtext=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.KewordValidationInCoveoPage()).getText();
			System.out.println(enteredtext);
			String valuelower=searchvalue.toLowerCase();
			if(enteredtext.contains(valuelower))
			{
				Log.info("test case pass: keyword selected is displayed in search of coveo result");
			}
			else
			{
				Log.info("test case fail: keyword selected is not displayed in search of coveo result");
				Report.put("Click 'View all Results for '  '' link ", 
						"It should display the Coveo Search results page.",
						"not landed on correct coveo page for searched Keyword "+Report.color(searchvalue), "FAIL");;
						Assert.fail();
			}

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.GetCoveoOverAllSearchResult()));
			searchresult=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.GetCoveoOverAllSearchResult()).getText();
			System.out.println("all result is for entered keyword is "+searchresult);

			List<WebElement> resourcetypelist=driver.findElements(obj_EsupportCoveoPage.ValidateResourceTypeIsSelected());
			int resourcetypecount=resourcetypelist.size();
			System.out.println("total number of resources displayed are "+resourcetypecount);

			for(int i=0; i<resourcetypecount;i++)
			{
				if(CommonUtility.highlightElement(driver,resourcetypelist.get(i)).isSelected())
				{
					Log.info("test case fail: resource types selected");
					Report.put("Click 'View all Results for '  '' link ", 
							"It should display the Coveo Search results page.",
							"Any of Resource Type is selected by default", "FAIL");;
							Assert.fail();
				}
			}

			String filterheader=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ValidateFiltersSectionHeader()).getText();
			System.out.println("header is "+filterheader);

			List<WebElement> getallfilters=driver.findElements(obj_EsupportCoveoPage.GetAllFilters());
			int totalfilterscount=getallfilters.size();
			System.out.println("total count of selected filters "+totalfilterscount);

			for(int j=0;j<totalfilterscount;j++)
			{
				filter+=",<br>"+getallfilters.get(j).getText();
				System.out.println("filters displayed are "+filter);

				if (filter.contains(resourcetype1) || filter.contains(resourcetype2)|| filter.contains(resourcetype3)|| filter.contains(resourcetype4)|| filter.contains(resourcetype5)|| filter.contains(resourcetype6))
				{
					Log.info("test case fail: resource types displayed under your filters section");
					Report.put("Click 'View all Results for '  '' link ", 
							"It should display the Coveo Search results page.",
							"Any of Resource Type "+Report.color(filter)+" is displayed by default under heading "+Report.color(filterheader), "FAIL");;
							Assert.fail();
				}

			}

			Report.put("Click 'View all Results for '  '' link ", 
					"It should display the Coveo Search results page.",
					"user able to click on first displayed "+Report.color(searchvalue)+" Successfully.<br> and coveo search page displayed with all relevant results displayed with result count of "+Report.color(searchresult)+"<br> and filters displayed under "+Report.color(filterheader)+" are <br> "+Report.color(filter), "PASS");

			Thread.sleep(3000);                     
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click 'View all Results for '  '' link ", 
					"It should display the Coveo Search results page.",
					"coveo search results display with default selected any of resource type or not landed on searched keyword coveo search result page", "FAIL");
			Assert.fail();
		}
	}

	public void  ValidateClickOnCrossLinkXOnCoveoSearchBox(WebDriver driver, String Dpid) 
	{
		Log.info("Entering ValidateClickOnCrossLinkXOnCoveoSearchBox");   
		WebDriverWait wait = new WebDriverWait(driver, 120);

		String enteredtext = "";
		String searchresult="";
		String filter="";
		String result="";
		String attr="";
		String title="";
		String currenturl="";
		String resourcetype2 = TestNGCreator.TestData.get(Esupport.Dpid.ordinal()).split(";")[1];
		Actions act= new Actions(driver);
		String text="";
		String text1="";

		try
		{       
			Log.info("Inside try of ValidateClickOnCrossLinkXOnCoveoSearchBox");
			//wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.KnowledgeBaseClick()));
			//Lavanya added implicit wait to click below element
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			if(CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.XButtonInSearchBoxInSearchSupport()).isDisplayed())
			{
				//					CommonUtility.scrollToViewElement(driver,obj_EsupportCoveoPage.XButtonInSearchBoxInSearchSupport());
				Thread.sleep(5000);
				//					CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.XButtonInSearchBoxInSearchSupport()).click();
				//				act.moveToElement(CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.XButtonInSearchBoxInSearchSupport())).click().build().perform();
				CommonUtility.ClickOn(driver, obj_EsupportCoveoPage.XButtonInSearchBoxInSearchSupport());
				Thread.sleep(10000);
			}

			//wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.GetCoveoOverAllSearchResult()));
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);

			//			CommonUtility.scrollToViewElement(driver,obj_EsupportCoveoPage.SearchBoxInSearchSupportInSearchPage());
			Thread.sleep(5000);
			text=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SearchBoxInSearchSupportInSearchPage()).getText();
			System.out.println("text displayed in search box after clicking on x button is "+text);

			//			CommonUtility.scrollToViewElement(driver,obj_EsupportCoveoPage.mastHead());
			Thread.sleep(5000);
			text1=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.mastHead()).getText();
			System.out.println("text displayed in mast head after clicking on x button in search box is "+text1);

			CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.GetCoveoOverAllSearchResult());

			searchresult=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.GetCoveoOverAllSearchResult()).getText();
			System.out.println("all result is for entered keyword and selected resource type is "+searchresult);



			String filterheader=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ValidateFiltersSectionHeader()).getText();
			System.out.println("header is "+filterheader);

			List<WebElement> getallfilters=driver.findElements(obj_EsupportCoveoPage.GetAllFilters());
			int totalfilterscount=getallfilters.size();
			System.out.println("total count of selected filters "+totalfilterscount);

			for(int j=0;j<totalfilterscount;j++)
			{
				filter+=",<br>"+getallfilters.get(j).getText();
				System.out.println("filters displayed are "+filter);

				if (filter.contains(resourcetype2))
				{
					Log.info("test case pass: resource types knowledgebase displayed under your filter section");
				}
				else
				{
					Log.info("test case fail: resource types knowledge base not displayed under your filter section");
					Report.put("Select the resource type 'knowledge base'", 
							"All featured results belonging to resource type should be shown displayed. Observe the Icon of every result. Open few results and verify.", 
							"for Resource Type "+Report.color(filter)+" is not displayed by under heading "+Report.color(filterheader), "FAIL");;
							Assert.fail();
				}

			}

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.CoveoResultSection()));

			List<WebElement> listofresultsdisplayed=driver.findElements(obj_EsupportCoveoPage.CountOfDisplayedResults());
			int countofresultsdisplayed=listofresultsdisplayed.size();
			System.out.println("total number of results displayed are "+countofresultsdisplayed);

			for(int i=0; i<countofresultsdisplayed;i++)
			{
				result+=",<br>"+listofresultsdisplayed.get(i).getText();
				System.out.println("displayed result on clicking resource type knowledgebase are "+result);
			}

//			wait.until(ExpectedConditions.presenceOfElementLocated(obj_EsupportCoveoPage.KnowledgeBaseIconValidation()));
//
//			List<WebElement> knowledgebaseiconlist=driver.findElements(obj_EsupportCoveoPage.KnowledgeBaseIconValidation());
//			int knowledgebaseiconcount=knowledgebaseiconlist.size();
//			System.out.println("total number of video icons displayed are "+knowledgebaseiconcount);
//
//			for(int k=0; k<knowledgebaseiconcount;k++)
//			{
//				attr+="<br>"+knowledgebaseiconlist.get(k).getAttribute("title");
//				System.out.println("title displayed is "+attr);
//				if(attr.contains("Knowledgebase"))
//				{
//					Log.info("test case pass: Knowledgebase icon displayed on selecting Knowledgebase resource type");
//				}
//				else
//				{
//					Log.info("test case fail:Knowledgebase icon not displayed on selecting Knowledgebase in result");
//					Report.put("Select the resource type 'knowledge base'", 
//							"All featured results belonging to resource type should be shown displayed. Observe the Icon of every result. Open few results and verify.", 
//							"for Resource Type "+Report.color(resourcetype2)+" Knowledgebase icon is not displayed", "FAIL");;
//							Assert.fail();
//				}
//			}

			wait.until(ExpectedConditions.presenceOfElementLocated(obj_EsupportCoveoPage.ClickOnFirstResult()));
			CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.ClickOnFirstResult());
			//			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ClickOnFirstResult()).click();
			CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.ClickOnFirstResult());

			Thread.sleep(20000);
			String mainwindow=driver.getWindowHandle();
			Set<String> set=driver.getWindowHandles();
			Iterator<String> itr=set.iterator();
			while(itr.hasNext())
			{
				String childWindow=itr.next();
				if(!mainwindow.equals(childWindow))
				{
					driver.switchTo().window(childWindow);
					Thread.sleep(10000);
					title=driver.getTitle();
					System.out.println(title);
					
					currenturl=driver.getCurrentUrl();
					System.out.println(currenturl);
					if (currenturl.contains("sln") || currenturl.contains("article") || currenturl.contains("docs")||currenturl.contains("kbdoc"))
					{
						Log.info("Test case pass:Knowledgebase content page opened");
					}
					else
					{
						driver.close();
						Log.info("Test case fail:Knowledgebase content page not opened");
						Report.put("Select the resource type 'knowledge base'", 
								"All featured results belonging to resource type should be shown displayed. Observe the Icon of every result. Open few results and verify.", 
								"content page not opened in seperate window on clicking coveo results displayed for keyword search", "FAIL");
						Assert.fail();
					}
					driver.close();
				}
			}

			driver.switchTo().window(mainwindow);
			//wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.ClearFilters()));
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			//			CommonUtility.scrollToViewElement(driver,obj_EsupportCoveoPage.ClearFilters());
			//
			//			CommonUtility.scrollToViewElement(driver,obj_EsupportCoveoPage.ClearFilters());
			//			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ClearFilters()).click();
			CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.ClearFilters());
			Thread.sleep(10000);

			Report.put("Select the resource type 'knowledge base'", 
					"All featured results belonging to resource type should be shown displayed. Observe the Icon of every result. Open few results and verify.", 
					"User able to see Only the results belonging to "+Report.color(resourcetype2)+"<br> and Icon displayed is <br> "+Report.color(attr)+"<br> and clicked on first result displayed and able to see title of page as "+Report.color(title)+" <br> and url of page is <br> "+Report.color(currenturl), "PASS");

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Select the resource type 'knowledge base'", 
					"All featured results belonging to resource type should be shown displayed. Observe the Icon of every result. Open few results and verify.", 
					"not able to see only selected resource type filtered or not able to navigate to content page clicking on coveo results displayed", "FAIL");
			Assert.fail();
		}
	}

	public void ValidateIntegratedProductHomePageWithOutEnteringKeywordInMastHeadAndClickOnSearchButton(WebDriver driver)
	{
		String tag="";
		String overview="";

		Log.info("Entering method ValidateIntegratedProductHomePageWithOutEnteringKeywordInMastHeadAndClickOnSearchButton");
		String value=TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal());

		try{
			WebDriverWait wait = new WebDriverWait(driver,100);
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.mastHead()));

			CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.mastHead());
			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.mastHead()).clear();


			CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.SearchButton());

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.mastHead()));

			CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.mastHead());
			tag=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.mastHead()).getText();
			System.out.println("displayed keyword is "+tag);

			//			if(tag.contains(value))
			//			{
			//				System.out.println("pass: searched tag product home page displayed");
			//			}
			//			else
			//			{
			//				System.out.println("searched tag product home page not displayed");
			//				Report.put("Provide Service tag DNPK882 in masthead and click search button.", 
			//						"It should navigate to Product Support home page.", 
			//						"not able to search given service tag in mast head", "FAIL");   
			//				
			//				Assert.fail();
			//			}

			//			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.ServiceTagValidationOnProductSupportPage()));
			CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.ServiceTagValidationOnProductSupportPage());
			tag=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ServiceTagValidationOnProductSupportPage()).getText();
			System.out.println("tag displayed is "+tag);


			Report.put("Without entering any keyword in Masthead click search button.", 
					"It shouldn't navigate to search page showing result set.", 
					"user able to search without entering any keyword and click on search button, user not navigated to search page showing result set. and stayed back on integrated home page with heading "+Report.color(tag), "PASS");   


		}
		catch(Exception ex){
			ex.printStackTrace();
			Report.put("Without entering the keyword in Masthead, press Search button.", 
					"It shouldn't navigate to search page showing result set.", 
					"not able to click on search button in mast head under integrated support home page", "FAIL");   

			Assert.fail();
		}
	}

	public void ValidateSearchPageWithEnteringSpaceInMastHeadAndClickOnSearchButtonInIntegratedSuppportHomePage(WebDriver driver)
	{
		String tag="";
		String overview="";

		Log.info("Entering method ValidateSearchPageWithEnteringSpaceInMastHeadAndClickOnSearchButtonInIntegratedSuppportHomePage");
		//		String value=TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal());

		try{
			WebDriverWait wait = new WebDriverWait(driver,100);
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.mastHead()));

			CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.mastHead());
			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.mastHead()).clear();
			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.mastHead()).sendKeys(Keys.SPACE);

			CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.SearchButton());

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.mastHead()));

			CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.mastHead());
			tag=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.mastHead()).getText();
			System.out.println("displayed is "+tag);

			//			if(tag.contains(value))
			//			{
			//				System.out.println("pass: searched tag product home page displayed");
			//			}
			//			else
			//			{
			//				System.out.println("searched tag product home page not displayed");
			//				Report.put("Provide Service tag DNPK882 in masthead and click search button.", 
			//						"It should navigate to Product Support home page.", 
			//						"not able to search given service tag in mast head", "FAIL");   
			//				
			//				Assert.fail();
			//			}

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.ServiceTagValidationOnProductSupportPage()));
			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ServiceTagValidationOnProductSupportPage());
			String welcometosupport=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ServiceTagValidationOnProductSupportPage()).getText();
			System.out.println("displayed page is "+welcometosupport);


			Report.put("Press Spacebar in Masthead and click  Search button", 
					"It shouldn't navigate to search page showing result set. ", 
					"User able to enter space in mast head and able to click on search button, user not navigated to search page showing different result set instead user in same page of Integrated support home page with heading "+Report.color(welcometosupport), "PASS");   


		}
		catch(Exception ex){
			ex.printStackTrace();
			Report.put("Press Spacebar in Masthead and click  Search button", 
					"It shouldn't navigate to search page showing result set. ",
					"not able to click on search button in mast head", "FAIL");   

			Assert.fail();
		}
	}

	public void  ValidateSearchForKeywordWithOutDoubleQuotes(WebDriver driver, String SearchOption, String Dpid) 
	{
		Log.info("Entering ValidateSearchForKeywordWithOutDoubleQuotes");   
		WebDriverWait wait = new WebDriverWait(driver, 300);
		String keyword1 = TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[0];

		String enteredtext = "";
		String searchresult="";
		String filter="";

		String resourcetype1 = TestNGCreator.TestData.get(Esupport.Dpid.ordinal()).split(";")[0];
		String resourcetype2 = TestNGCreator.TestData.get(Esupport.Dpid.ordinal()).split(";")[1];
		String resourcetype3 = TestNGCreator.TestData.get(Esupport.Dpid.ordinal()).split(";")[2];
		String resourcetype4 = TestNGCreator.TestData.get(Esupport.Dpid.ordinal()).split(";")[3];
		String resourcetype5 = TestNGCreator.TestData.get(Esupport.Dpid.ordinal()).split(";")[4];
		String resourcetype6 = TestNGCreator.TestData.get(Esupport.Dpid.ordinal()).split(";")[5];
		Actions act=new Actions(driver);

		try
		{       
			System.out.println("Inside try of ValidateSearchForKeyword");
			//			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.SearchTextbox()));
			//			CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.SearchTextbox());

			CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.SearchTextbox());
			CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.SearchTextbox());
			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SearchTextbox()).clear();
			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SearchTextbox()).sendKeys(keyword1);
			handleCookies(driver);
			CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.SearchButtonMastHead());
			if(CommonUtility.CheckpresenceofElementLocated(driver, 10, obj_EsupportCoveoPage.SearchButtonMastHead()))
			{
				CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.SearchButtonMastHead());
			}
			else if(CommonUtility.CheckpresenceofElementLocated(driver, 10, obj_EsupportCoveoPage.SearchButton2()))
			{
				CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.SearchButton2());
			}
			Thread.sleep(10000);
//			driver.navigate().refresh();
//						Thread.sleep(10000);
//			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
//						Thread.sleep(10000);
						Thread.sleep(6000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.searchSupport()));
//			Thread.sleep(10000);
//			Thread.sleep(6000);
//			Thread.sleep(6000);
			Thread.sleep(10000);
			Thread.sleep(10000);
			String url = driver.getCurrentUrl();
			System.out.println(url);
			if(url.contains("Facet"))
			{
				Log.info("test case pass: url contains Facet keyword");
				
			}
			else
			{
				Log.info("test case fail: url doesnt contains Facet keyword");
				Report.put("Type 'Driver Update' in the masthead and click search button.", 
						"It should show the relevant search results", 
						"not landed on coveo page", "FAIL");;
						Assert.fail();
			}
			Thread.sleep(5000);
			enteredtext=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.KewordValidationInCoveoPage()).getText();
			System.out.println(enteredtext);
			enteredtext=enteredtext.toLowerCase();
			keyword1=keyword1.toLowerCase();
			System.out.println(keyword1);
			if(enteredtext.contains(keyword1))
			{
				Log.info("test case pass: keyword entered is displayed in search of coveo result");
			}
			else
			{
				Log.info("test case fail: keyword entered is not displayed in search of coveo result");
				Report.put("Type 'Driver Update' in the masthead and click search button.", 
						"It should show the relevant search results", 
						"not landed on correct coveo page for searched Keyword "+Report.color(keyword1), "FAIL");;
						Assert.fail();
			}
			
			Thread.sleep(6000);
			driver.navigate().refresh();
			Thread.sleep(10000);
			Thread.sleep(6000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.GetCoveoOverAllSearchResult()));
			searchresult=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.GetCoveoOverAllSearchResult()).getText();
			System.out.println("all result is for entered keyword is "+searchresult);
			Thread.sleep(10000);
			Thread.sleep(6000);
			List<WebElement> resourcetypelist=driver.findElements(obj_EsupportCoveoPage.ValidateResourceTypeIsSelected());
			int resourcetypecount=resourcetypelist.size();
			System.out.println("total number of resources displayed are "+resourcetypecount);

			for(int i=0; i<resourcetypecount;i++)
			{
				if(CommonUtility.highlightElement(driver,resourcetypelist.get(i)).isSelected())
				{
					Log.info("test case fail: resource types selected");
					Report.put("Type 'Driver Update' in the masthead and click search button.", 
							"It should show the relevant search results", 
							"Any of Resource Type is selected by default", "FAIL");;
							Assert.fail();
				}
			}

			String filterheader=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ValidateFiltersSectionHeader()).getText();
			System.out.println("header is "+filterheader);

			List<WebElement> getallfilters=driver.findElements(obj_EsupportCoveoPage.GetAllFilters());
			int totalfilterscount=getallfilters.size();
			System.out.println("total count of selected filters "+totalfilterscount);

			for(int j=0;j<totalfilterscount;j++)
			{
				filter+=",<br>"+getallfilters.get(j).getText();
				System.out.println("filters displayed are "+filter);

				if (filter.contains(resourcetype1) || filter.contains(resourcetype2)|| filter.contains(resourcetype3)|| filter.contains(resourcetype4)|| filter.contains(resourcetype5)|| filter.contains(resourcetype6))
				{
					Log.info("test case fail: resource types displayed under your filters section");
					Report.put("Type 'Driver Update' in the masthead and click search button.", 
							"It should show the relevant search results", 
							"Any of Resource Type "+Report.color(filter)+" is displayed by default under heading "+Report.color(filterheader), "FAIL");;
							Assert.fail();
				}

			}

			Report.put("Type 'Driver Update' in the masthead and click search button.", 
					"It should show the relevant search results", 
					"keyword "+Report.color(keyword1)+" searched Successfully.<br> and all relevant results displayed with result count of "+Report.color(searchresult)+"<br> and filters displayed under "+Report.color(filterheader)+" are <br> "+Report.color(filter), "PASS");

			Thread.sleep(3000);                     
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Type 'Driver Update' in the masthead and click search button.", 
					"It should show the relevant search results", 
					"coveo search results display with default selected any of resource type or not landed on searched keyword coveo search result page", "FAIL");;
					Assert.fail();
		}
	}

	public void  ValidateSearchForKeyword1WithOutDoubleQuotes(WebDriver driver, String SearchOption, String Dpid) 
	{
		Log.info("Entering ValidateSearchForKeyword1WithOutDoubleQuotes");   
		WebDriverWait wait = new WebDriverWait(driver, 300);
		String keyword1 = TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[0];

		String enteredtext = "";
		String searchresult="";
		String filter="";

		String resourcetype1 = TestNGCreator.TestData.get(Esupport.Dpid.ordinal()).split(";")[0];
		String resourcetype2 = TestNGCreator.TestData.get(Esupport.Dpid.ordinal()).split(";")[1];
		String resourcetype3 = TestNGCreator.TestData.get(Esupport.Dpid.ordinal()).split(";")[2];
		String resourcetype4 = TestNGCreator.TestData.get(Esupport.Dpid.ordinal()).split(";")[3];
		String resourcetype5 = TestNGCreator.TestData.get(Esupport.Dpid.ordinal()).split(";")[4];
		String resourcetype6 = TestNGCreator.TestData.get(Esupport.Dpid.ordinal()).split(";")[5];
		Actions act=new Actions(driver);

		try
		{       
			System.out.println("Inside try of ValidateSearchForKeyword");
			//			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.SearchTextbox()));
			//			CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.SearchTextbox());

			CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.SearchTextbox());
			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SearchTextbox()).clear();
			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SearchTextbox()).sendKeys(keyword1);
			handleCookies(driver);

			//					CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SearchButton()).click();
			//					act.moveToElement(CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SearchButton())).click().build().perform();
			//				CommonUtility.ToClickByUsingJavaScript_PassingByLoc(driver,obj_EsupportCoveoPage.SearchButton());
			CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.SearchButton2());
			Thread.sleep(20000);
			driver.navigate().refresh();
			Thread.sleep(6000);
			

			//			Thread.sleep(10000);
//			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.searchSupport()));
			if(driver.getCurrentUrl().contains("Facet"))
			{
				Log.info("test case pass: url contains Facet keyword");
			}
			else
			{
				Log.info("test case fail: url doesnt contains Facet keyword");
				Report.put("Type 'Driver Update' in the masthead and click search button.", 
						"It should show the relevant search results", 
						"not landed on coveo page", "FAIL");;
						Assert.fail();
			}
			Thread.sleep(5000);
			enteredtext=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.KewordValidationInCoveoPage()).getText();
			System.out.println(enteredtext);
			if(enteredtext.contains(keyword1))
			{
				Log.info("test case pass: keyword entered is displayed in search of coveo result");
			}
			else
			{
				Log.info("test case fail: keyword entered is not displayed in search of coveo result");
				Report.put("Type 'Driver Update' in the masthead and click search button.", 
						"It should show the relevant search results", 
						"not landed on correct coveo page for searched Keyword "+Report.color(keyword1), "FAIL");;
						Assert.fail();
			}

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.GetCoveoOverAllSearchResult()));
			searchresult=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.GetCoveoOverAllSearchResult()).getText();
			System.out.println("all result is for entered keyword is "+searchresult);

			List<WebElement> resourcetypelist=driver.findElements(obj_EsupportCoveoPage.ValidateResourceTypeIsSelected());
			int resourcetypecount=resourcetypelist.size();
			System.out.println("total number of resources displayed are "+resourcetypecount);

			for(int i=0; i<resourcetypecount;i++)
			{
				if(CommonUtility.highlightElement(driver,resourcetypelist.get(i)).isSelected())
				{
					Log.info("test case fail: resource types selected");
					Report.put("Type 'Driver Update' in the masthead and click search button.", 
							"It should show the relevant search results", 
							"Any of Resource Type is selected by default", "FAIL");;
							Assert.fail();
				}
			}

			String filterheader=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ValidateFiltersSectionHeader()).getText();
			System.out.println("header is "+filterheader);

			List<WebElement> getallfilters=driver.findElements(obj_EsupportCoveoPage.GetAllFilters());
			int totalfilterscount=getallfilters.size();
			System.out.println("total count of selected filters "+totalfilterscount);

			for(int j=0;j<totalfilterscount;j++)
			{
				filter+=",<br>"+getallfilters.get(j).getText();
				System.out.println("filters displayed are "+filter);

				if (filter.contains(resourcetype1) || filter.contains(resourcetype2)|| filter.contains(resourcetype3)|| filter.contains(resourcetype4)|| filter.contains(resourcetype5)|| filter.contains(resourcetype6))
				{
					Log.info("test case fail: resource types displayed under your filters section");
					Report.put("Type 'Driver Update' in the masthead and click search button.", 
							"It should show the relevant search results", 
							"Any of Resource Type "+Report.color(filter)+" is displayed by default under heading "+Report.color(filterheader), "FAIL");;
							Assert.fail();
				}

			}

			Report.put("Type 'Driver Update' in the masthead and click search button.", 
					"It should show the relevant search results", 
					"keyword "+Report.color(keyword1)+" searched Successfully.<br> and all relevant results displayed with result count of "+Report.color(searchresult)+"<br> and filters displayed under "+Report.color(filterheader)+" are <br> "+Report.color(filter), "PASS");

			Thread.sleep(3000);                     
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Type 'Driver Update' in the masthead and click search button.", 
					"It should show the relevant search results", 
					"coveo search results display with default selected any of resource type or not landed on searched keyword coveo search result page", "FAIL");;
					Assert.fail();
		}
	}

	public void  ValidateSearchForKeyword2WithOutDoubleQuotes(WebDriver driver, String SearchOption, String Dpid) 
	{
		Log.info("Entering ValidateSearchForKeyword2WithOutDoubleQuotes");   
		WebDriverWait wait = new WebDriverWait(driver, 300);
		String keyword1 = TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[1];

		String enteredtext = "";
		String searchresult="";
		String filter="";

		String resourcetype1 = TestNGCreator.TestData.get(Esupport.Dpid.ordinal()).split(";")[0];
		String resourcetype2 = TestNGCreator.TestData.get(Esupport.Dpid.ordinal()).split(";")[1];
		String resourcetype3 = TestNGCreator.TestData.get(Esupport.Dpid.ordinal()).split(";")[2];
		String resourcetype4 = TestNGCreator.TestData.get(Esupport.Dpid.ordinal()).split(";")[3];
		String resourcetype5 = TestNGCreator.TestData.get(Esupport.Dpid.ordinal()).split(";")[4];
		String resourcetype6 = TestNGCreator.TestData.get(Esupport.Dpid.ordinal()).split(";")[5];
		Actions act=new Actions(driver);

		try
		{       
			System.out.println("Inside try of ValidateSearchForKeyword");
			//			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.SearchTextbox()));
			//			CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.SearchTextbox());

			CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.SearchTextbox());
			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SearchTextbox()).clear();
			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SearchTextbox()).sendKeys(keyword1);
			handleCookies(driver);

			//					CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SearchButton()).click();
			//					act.moveToElement(CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SearchButton())).click().build().perform();
			//				CommonUtility.ToClickByUsingJavaScript_PassingByLoc(driver,obj_EsupportCoveoPage.SearchButton());
			CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.SearchButton2());
			Thread.sleep(20000);

			//			Thread.sleep(10000);
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			handleCookies(driver);
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.searchSupport()));
			if(driver.getCurrentUrl().contains("Facet"))
			{
				Log.info("test case pass: url contains Facet keyword");
			}
			else
			{
				Log.info("test case fail: url doesnt contains Facet keyword");
				Report.put("Type 'Driver Update' in the masthead and click search button.", 
						"It should show the relevant search results", 
						"not landed on coveo page", "FAIL");;
						Assert.fail();
			}
			Thread.sleep(5000);
			enteredtext=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.KewordValidationInCoveoPage()).getText();
			System.out.println(enteredtext);
			if(enteredtext.contains(keyword1))
			{
				Log.info("test case pass: keyword entered is displayed in search of coveo result");
			}
			else
			{
				Log.info("test case fail: keyword entered is not displayed in search of coveo result");
				Report.put("Type 'Driver Update' in the masthead and click search button.", 
						"It should show the relevant search results", 
						"not landed on correct coveo page for searched Keyword "+Report.color(keyword1), "FAIL");;
						Assert.fail();
			}

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.GetCoveoOverAllSearchResult()));
			searchresult=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.GetCoveoOverAllSearchResult()).getText();
			System.out.println("all result is for entered keyword is "+searchresult);

			List<WebElement> resourcetypelist=driver.findElements(obj_EsupportCoveoPage.ValidateResourceTypeIsSelected());
			int resourcetypecount=resourcetypelist.size();
			System.out.println("total number of resources displayed are "+resourcetypecount);

			for(int i=0; i<resourcetypecount;i++)
			{
				if(CommonUtility.highlightElement(driver,resourcetypelist.get(i)).isSelected())
				{
					Log.info("test case fail: resource types selected");
					Report.put("Type 'Driver Update' in the masthead and click search button.", 
							"It should show the relevant search results", 
							"Any of Resource Type is selected by default", "FAIL");;
							Assert.fail();
				}
			}

			String filterheader=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ValidateFiltersSectionHeader()).getText();
			System.out.println("header is "+filterheader);

			List<WebElement> getallfilters=driver.findElements(obj_EsupportCoveoPage.GetAllFilters());
			int totalfilterscount=getallfilters.size();
			System.out.println("total count of selected filters "+totalfilterscount);

			for(int j=0;j<totalfilterscount;j++)
			{
				filter+=",<br>"+getallfilters.get(j).getText();
				System.out.println("filters displayed are "+filter);

				if (filter.contains(resourcetype1) || filter.contains(resourcetype2)|| filter.contains(resourcetype3)|| filter.contains(resourcetype4)|| filter.contains(resourcetype5)|| filter.contains(resourcetype6))
				{
					Log.info("test case fail: resource types displayed under your filters section");
					Report.put("Type 'Driver Update' in the masthead and click search button.", 
							"It should show the relevant search results", 
							"Any of Resource Type "+Report.color(filter)+" is displayed by default under heading "+Report.color(filterheader), "FAIL");;
							Assert.fail();
				}

			}

			Report.put("Type 'Driver Update' in the masthead and click search button.", 
					"It should show the relevant search results", 
					"keyword "+Report.color(keyword1)+" searched Successfully.<br> and all relevant results displayed with result count of "+Report.color(searchresult)+"<br> and filters displayed under "+Report.color(filterheader)+" are <br> "+Report.color(filter), "PASS");

			Thread.sleep(3000);                     
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Type 'Driver Update' in the masthead and click search button.", 
					"It should show the relevant search results", 
					"coveo search results display with default selected any of resource type or not landed on searched keyword coveo search result page", "FAIL");;
					Assert.fail();
		}
	}

	public void  SelectKnowledgebaseResouceTypeWithOutClearingFilterAtEnd(WebDriver driver, String Dpid) 
	{
		Log.info("Entering SelectKnowledgebaseResouceTypeWithOutClearingFilterAtEnd");   
		WebDriverWait wait = new WebDriverWait(driver, 120);

		String enteredtext = "";
		String searchresult="";
		String filter="";
		String result="";
		String attr="";
		String title="";
		String currenturl="";
		String resourcetype2 = TestNGCreator.TestData.get(Esupport.Dpid.ordinal()).split(";")[1];
		Actions act= new Actions(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		try
		{       
			Log.info("Inside try of SelectKnowledgebaseResouceTypeWithOutClearingFilterAtEnd");
			//wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.KnowledgeBaseClick()));
			//Lavanya added implicit wait to click below element
//			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
//			CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.KnowledgeBaseClick());
			

			if(CommonUtility.CheckpresenceofElementLocated(driver,20,obj_EsupportCoveoPage.KnowledgeBaseClick()))
			{
				try
	            {
				CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.numberofResult());
				CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.KnowledgeBaseClick());
				Thread.sleep(2000);
				js.executeScript("window.scrollBy(0,200)", "");
				Thread.sleep(2000);
				CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.KnowledgeBaseClick());

	            }
	             catch(JavascriptException e) 
	            {
	                   e.printStackTrace();
	            }
			}
			driver.navigate().refresh();
			Thread.sleep(6000);
			//wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.GetCoveoOverAllSearchResult()));
			driver.manage().timeouts().implicitlyWait(600, TimeUnit.SECONDS);
			
			CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.GetCoveoOverAllSearchResult());

			searchresult=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.GetCoveoOverAllSearchResult()).getText();
			System.out.println("all result is for entered keyword and selected resource type is "+searchresult);

			Thread.sleep(10000);

			String filterheader=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ValidateFiltersSectionHeader()).getText();
			System.out.println("header is "+filterheader);
			Thread.sleep(6000);
			List<WebElement> getallfilters=driver.findElements(obj_EsupportCoveoPage.GetAllFilters());
			int totalfilterscount=getallfilters.size();
			System.out.println("total count of selected filters "+totalfilterscount);

			for(int j=0;j<totalfilterscount;j++)
			{
				filter+=",<br>"+getallfilters.get(j).getText();
				System.out.println("filters displayed are "+filter);

				if (filter.contains(resourcetype2))
				{
					Log.info("test case pass: resource types knowledgebase displayed under your filter section");
				}
				else
				{
					Log.info("test case fail: resource types knowledge base not displayed under your filter section");
					Report.put("Select the resource type 'knowledge base'", 
							"All featured results belonging to resource type should be shown displayed. Observe the Icon of every result. Open few results and verify.", 
							"for Resource Type "+Report.color(filter)+" is not displayed by under heading "+Report.color(filterheader), "FAIL");;
							Assert.fail();
				}

			}

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.CoveoResultSection()));

			List<WebElement> listofresultsdisplayed=driver.findElements(obj_EsupportCoveoPage.CountOfDisplayedResults());
			int countofresultsdisplayed=listofresultsdisplayed.size();
			System.out.println("total number of results displayed are "+countofresultsdisplayed);

			for(int i=0; i<countofresultsdisplayed;i++)
			{
				result+=",<br>"+listofresultsdisplayed.get(i).getText();
				System.out.println("displayed result on clicking resource type knowledgebase are "+result);
			}

//			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.KnowledgeBaseIconValidation()));
//
//			List<WebElement> knowledgebaseiconlist=driver.findElements(obj_EsupportCoveoPage.KnowledgeBaseIconValidation());
//			int knowledgebaseiconcount=knowledgebaseiconlist.size();
//			System.out.println("total number of video icons displayed are "+knowledgebaseiconcount);
//
//			for(int k=0; k<knowledgebaseiconcount;k++)
//			{
//				attr+="<br>"+knowledgebaseiconlist.get(k).getAttribute("textContent");
//				System.out.println("title displayed is "+attr);
//				if(attr.contains("Knowledgebase"))
//				{
//					Log.info("test case pass: Knowledgebase icon displayed on selecting Knowledgebase resource type");
//				}
//				else
//				{
//					Log.info("test case fail:Knowledgebase icon not displayed on selecting Knowledgebase in result");
//					Report.put("Select the resource type 'knowledge base'", 
//							"All featured results belonging to resource type should be shown displayed. Observe the Icon of every result. Open few results and verify.", 
//							"for Resource Type "+Report.color(resourcetype2)+" Knowledgebase icon is not displayed", "FAIL");;
//							Assert.fail();
//				}
//			}

			//			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.ClickOnFirstResult()));
			//			CommonUtility.scrollToViewElement(driver,obj_EsupportCoveoPage.ClickOnFirstResult());
			//			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ClickOnFirstResult()).click();
			//
			//			Thread.sleep(10000);
			//			String mainwindow=driver.getWindowHandle();
			//			Set<String> set=driver.getWindowHandles();
			//			Iterator<String> itr=set.iterator();
			//			while(itr.hasNext())
			//			{
			//				String childWindow=itr.next();
			//				if(!mainwindow.equals(childWindow))
			//				{
			//					driver.switchTo().window(childWindow);
			//					title=title+" ,<br> "+driver.getTitle();
			//					System.out.println(driver.switchTo().window(childWindow).getTitle());
			//					System.out.println(driver.switchTo().window(childWindow).getCurrentUrl());
			//					currenturl=currenturl+" ,<br> "+driver.getCurrentUrl();
			//					if (currenturl.contains("sln"))
			//					{
			//						Log.info("Test case pass:Knowledgebase content page opened");
			//					}
			//					else
			//					{
			//						driver.close();
			//						Log.info("Test case fail:Knowledgebase content page not opened");
			//						Report.put("Select the resource type 'knowledge base'", 
			//								"All featured results belonging to resource type should be shown displayed. Observe the Icon of every result. Open few results and verify.", 
			//								"content page not opened in seperate window on clicking coveo results displayed for keyword search", "FAIL");
			//						Assert.fail();
			//					}
			//					driver.close();
			//				}
			//			}
			//
			//			driver.switchTo().window(mainwindow);
			//wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.ClearFilters()));
			//			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			//			CommonUtility.scrollToViewElement(driver,obj_EsupportCoveoPage.ClearFilters());
			//
			//			CommonUtility.scrollToViewElement(driver,obj_EsupportCoveoPage.ClearFilters());
			//			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ClearFilters()).click();
			//			Thread.sleep(10000);

			Report.put("Select the resource type 'knowledge base'", 
					"All featured results belonging to resource type should be shown displayed. Observe the Icon of every result. Open few results and verify.", 
					"User able to see Only the results belonging to "+Report.color(resourcetype2)+"<br> and Icon displayed is <br> "+Report.color(attr)+"<br> and clicked on first result displayed and able to see title of page as "+Report.color(title)+" <br> and url of page is <br> "+Report.color(currenturl), "PASS");

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Select the resource type 'knowledge base'", 
					"All featured results belonging to resource type should be shown displayed. Observe the Icon of every result. Open few results and verify.", 
					"not able to see only selected resource type filtered or not able to navigate to content page clicking on coveo results displayed", "FAIL");
			Assert.fail();
		}
	}

	public void ValidateSearchPageWithOutEnteringKeywordInMastHeadAndClickOnSearchButtonOnIntegratedSupportHomePage(WebDriver driver)
	{
		String tag="";
		String overview="";

		Log.info("Entering method ValidateSearchPageWithOutEnteringKeywordInMastHeadAndClickOnSearchButtonOnIntegratedSupportHomePage");
		//		String value=TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal());

		try{
			WebDriverWait wait = new WebDriverWait(driver,100);
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.mastHead()));

			CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.mastHead());
			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.mastHead()).clear();


			CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.SearchButton());

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.mastHead()));

			CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.mastHead());
			tag=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.mastHead()).getText();
			System.out.println("displayed keyword is "+tag);

			//			if(tag.contains(value))
			//			{
			//				System.out.println("pass: searched tag product home page displayed");
			//			}
			//			else
			//			{
			//				System.out.println("searched tag product home page not displayed");
			//				Report.put("Provide Service tag DNPK882 in masthead and click search button.", 
			//						"It should navigate to Product Support home page.", 
			//						"not able to search given service tag in mast head", "FAIL");   
			//				
			//				Assert.fail();
			//			}
			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SupportHeader());
			String welcometosupport=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SupportHeader()).getText();
			System.out.println("displayed page is "+welcometosupport);

			Report.put("Without entering the keyword in Masthead, press Search button.", 
					"It shouldn't navigate to search page showing result set.", 
					"user able to search without entering any keyword and click on search button, user shouldn't navigate to search page showing result set."+Report.color(tag), "PASS");   


		}
		catch(Exception ex){
			ex.printStackTrace();
			Report.put("Without entering the keyword in Masthead, press Search button.", 
					"It shouldn't navigate to search page showing result set.", 
					"not able to click on search button in mast head", "FAIL");   

			Assert.fail();
		}
	}

	public void ValidateSearchPageWithEnteringSpaceInMastHeadAndClickOnSearchButtonInSuppportHomePage(WebDriver driver)
	{
		String tag="";
		String overview="";

		Log.info("Entering method ValidateSearchPageWithEnteringSpaceInMastHeadAndClickOnSearchButtonInSuppportHomePage");
		//		String value=TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal());

		try{
			WebDriverWait wait = new WebDriverWait(driver,100);
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.mastHead()));

			CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.mastHead());
			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.mastHead()).clear();
			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.mastHead()).sendKeys(Keys.SPACE);

			CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.SearchButton());

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.mastHead()));

			CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.mastHead());
			tag=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.mastHead()).getText();
			System.out.println("displayed is "+tag);

			//			if(tag.contains(value))
			//			{
			//				System.out.println("pass: searched tag product home page displayed");
			//			}
			//			else
			//			{
			//				System.out.println("searched tag product home page not displayed");
			//				Report.put("Provide Service tag DNPK882 in masthead and click search button.", 
			//						"It should navigate to Product Support home page.", 
			//						"not able to search given service tag in mast head", "FAIL");   
			//				
			//				Assert.fail();
			//			}

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.SupportHeader()));
			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SupportHeader());
			String welcometosupport=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SupportHeader()).getText();
			System.out.println("displayed page is "+welcometosupport);


			Report.put("Press Spacebar in Masthead and click  Search button", 
					"It shouldn't navigate to search page showing result set. ", 
					"User able to enter space in mast head and able to click on search button, user not navigated to search page showing different result set instead user in same page of Integrated support home page with heading "+Report.color(welcometosupport), "PASS");   


		}
		catch(Exception ex){
			ex.printStackTrace();
			Report.put("Press Spacebar in Masthead and click  Search button", 
					"It shouldn't navigate to search page showing result set. ",
					"not able to click on search button in mast head", "FAIL");   

			Assert.fail();
		}
	}

	public void ValidateSearchPageWithEnteringSpaceInMastHeadAndClickOnSearchButtonInDriversAndDownloadHomePage(WebDriver driver)
	{
		String tag="";
		String overview="";

		Log.info("Entering method ValidateSearchPageWithEnteringSpaceInMastHeadAndClickOnSearchButtonInDriversAndDownloadHomePage");
		//		String value=TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal());

		try{
			WebDriverWait wait = new WebDriverWait(driver,100);
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.mastHead()));
			CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.mastHead());
			CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.mastHead());
			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.mastHead()).clear();
			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.mastHead()).sendKeys(Keys.SPACE);
			CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.SearchButton());
			CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.SearchButton());

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.mastHead()));

			CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.mastHead());
			tag=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.mastHead()).getText();
			System.out.println("displayed is "+tag);

			//			if(tag.contains(value))
			//			{
			//				System.out.println("pass: searched tag product home page displayed");
			//			}
			//			else
			//			{
			//				System.out.println("searched tag product home page not displayed");
			//				Report.put("Provide Service tag DNPK882 in masthead and click search button.", 
			//						"It should navigate to Product Support home page.", 
			//						"not able to search given service tag in mast head", "FAIL");   
			//				
			//				Assert.fail();
			//			}

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.DriversAndDonloadsHeadingOnDriversHomePage()));
			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.DriversAndDonloadsHeadingOnDriversHomePage());
			String welcometosupport=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.DriversAndDonloadsHeadingOnDriversHomePage()).getText();
			System.out.println("displayed page is "+welcometosupport);


			Report.put("Press Spacebar in Masthead and click  Search button", 
					"It shouldn't navigate to search page showing result set. ", 
					"User able to enter space in mast head and able to click on search button, user not navigated to search page showing different result set instead user in same page of Integrated support home page with heading "+Report.color(welcometosupport), "PASS");   


		}
		catch(Exception ex){
			ex.printStackTrace();
			Report.put("Press Spacebar in Masthead and click  Search button", 
					"It shouldn't navigate to search page showing result set. ",
					"not able to click on search button in mast head", "FAIL");   

			Assert.fail();
		}
	}

	public void ValidateSearchPageWithOutEnteringKeywordInMastHeadAndClickOnSearchButtonInDriversAndDownloadPage(WebDriver driver)
	{
		String tag="";
		String overview="";

		Log.info("Entering method ValidateSearchPageWithOutEnteringKeywordInMastHeadAndClickOnSearchButtonInDriversAndDownloadPage");
		//		String value=TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal());

		try{
			WebDriverWait wait = new WebDriverWait(driver,100);
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.mastHead()));
			CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.mastHead());
			CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.mastHead());
			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.mastHead()).clear();

			CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.SearchButton());
			CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.SearchButton());

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.mastHead()));

			CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.mastHead());
			tag=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.mastHead()).getText();
			System.out.println("displayed keyword is "+tag);

			//			if(tag.contains(value))
			//			{
			//				System.out.println("pass: searched tag product home page displayed");
			//			}
			//			else
			//			{
			//				System.out.println("searched tag product home page not displayed");
			//				Report.put("Provide Service tag DNPK882 in masthead and click search button.", 
			//						"It should navigate to Product Support home page.", 
			//						"not able to search given service tag in mast head", "FAIL");   
			//				
			//				Assert.fail();
			//			}
			CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.DriversAndDonloadsHeadingOnDriversHomePage());
			String welcometosupport=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.DriversAndDonloadsHeadingOnDriversHomePage()).getText();
			System.out.println("displayed page is "+welcometosupport);

			Report.put("Without entering the keyword in Masthead, press Search button.", 
					"It shouldn't navigate to search page showing result set.", 
					"user able to search without entering any keyword and click on search button, user shouldn't navigate to search page showing result set."+Report.color(tag), "PASS");   


		}
		catch(Exception ex){
			ex.printStackTrace();
			Report.put("Without entering the keyword in Masthead, press Search button.", 
					"It shouldn't navigate to search page showing result set.", 
					"not able to click on search button in mast head", "FAIL");   

			Assert.fail();
		}
	}

	public void ValidateSearchPageWithOutEnteringKeywordInMastHeadAndClickOnSearchButtonInContactUsPage(WebDriver driver)
	{
		String tag="";
		String overview="";

		Log.info("Entering method ValidateSearchPageWithOutEnteringKeywordInMastHeadAndClickOnSearchButtonInContactUsPage");
		//		String value=TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal());

		try{
			WebDriverWait wait = new WebDriverWait(driver,100);
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.mastHead()));

			CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.mastHead());
			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.mastHead()).clear();


			CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.SearchButton2());

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.mastHead()));

			CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.mastHead());
			tag=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.mastHead()).getText();
			System.out.println("displayed keyword is "+tag);

			//			if(tag.contains(value))
			//			{
			//				System.out.println("pass: searched tag product home page displayed");
			//			}
			//			else
			//			{
			//				System.out.println("searched tag product home page not displayed");
			//				Report.put("Provide Service tag DNPK882 in masthead and click search button.", 
			//						"It should navigate to Product Support home page.", 
			//						"not able to search given service tag in mast head", "FAIL");   
			//				
			//				Assert.fail();
			//			}
			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ContactUsHomePageHeader());
			String welcometosupport=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ContactUsHomePageHeader()).getText();
			System.out.println("displayed page is "+welcometosupport);

			Report.put("Without entering the keyword in Masthead, press Search button.", 
					"It shouldn't navigate to search page showing result set.", 
					"user able to search without entering any keyword and click on search button, user shouldn't navigate to search page showing result set."+Report.color(tag), "PASS");   


		}
		catch(Exception ex){
			ex.printStackTrace();
			Report.put("Without entering the keyword in Masthead, press Search button.", 
					"It shouldn't navigate to search page showing result set.", 
					"not able to click on search button in mast head", "FAIL");   

			Assert.fail();
		}
	}

	public void ValidateSearchPageWithEnteringSpaceInMastHeadAndClickOnSearchButtonInContactUSHomePage(WebDriver driver)
	{
		String tag="";
		String overview="";

		Log.info("Entering method ValidateSearchPageWithEnteringSpaceInMastHeadAndClickOnSearchButtonInContactUsHomePage");
		//		String value=TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal());

		try{
			WebDriverWait wait = new WebDriverWait(driver,100);
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.mastHead()));

			CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.mastHead());
			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.mastHead()).clear();
			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.mastHead()).sendKeys(Keys.SPACE);

			CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.SearchButton());

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.mastHead()));

			CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.mastHead());
			tag=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.mastHead()).getText();
			System.out.println("displayed is "+tag);

			//			if(tag.contains(value))
			//			{
			//				System.out.println("pass: searched tag product home page displayed");
			//			}
			//			else
			//			{
			//				System.out.println("searched tag product home page not displayed");
			//				Report.put("Provide Service tag DNPK882 in masthead and click search button.", 
			//						"It should navigate to Product Support home page.", 
			//						"not able to search given service tag in mast head", "FAIL");   
			//				
			//				Assert.fail();
			//			}

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.ContactUsHomePageHeader()));
			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ContactUsHomePageHeader());
			String welcometosupport=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ContactUsHomePageHeader()).getText();
			System.out.println("displayed page is "+welcometosupport);


			Report.put("Press Spacebar in Masthead and click  Search button", 
					"It shouldn't navigate to search page showing result set. ", 
					"User able to enter space in mast head and able to click on search button, user not navigated to search page showing different result set instead user in same page of Integrated support home page with heading "+Report.color("Contact Us"), "PASS");   


		}
		catch(Exception ex){
			ex.printStackTrace();
			Report.put("Press Spacebar in Masthead and click  Search button", 
					"It shouldn't navigate to search page showing result set. ",
					"not able to click on search button in mast head", "FAIL");   

			Assert.fail();
		}
	}

	public void ToNavigate_ArticleHTMLPage(WebDriver driver)
	{


		System.out.println("Entering method ToNavigate_ArticleHTMLPage");
		try{

			Thread.sleep(7000);

			driver.navigate().to("https://www.dell.com/support/article/en-au/sln128667/dell-laptop-battery-frequently-asked-questions?lang=en");
			Thread.sleep(7000);
			handleCookies(driver);
			WebDriverWait wait = new WebDriverWait(driver,100);
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.ArticleTitle()));
			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ArticleTitle());
			String welcometosupport=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ArticleTitle()).getText();
			System.out.println("displayed page is "+welcometosupport);


			Report.put("Article Open URL https://www.dell.com/support/article/us/en/04/sln128667/dell-laptop-battery-frequently-asked-questions?lang=en ",
					"It should load the Article details.", 
					"Article page loaded Successfully with header "+Report.color(welcometosupport), "PASS");


		} 
		catch(Exception ex)
		{
			ex.printStackTrace();

			Report.put("Article Open URL https://www.dell.com/support/article/us/en/04/sln128667/dell-laptop-battery-frequently-asked-questions?lang=en ",
					"It should load the Article details.", 
					"Failed to load Article page", "FAIL");
			Assert.fail();
		}
	}

	public void ValidateSearchPageWithOutEnteringKeywordInMastHeadAndClickOnSearchButtonInArticleHomePage(WebDriver driver)
	{
		String tag="";
		String overview="";

		Log.info("Entering method ValidateSearchPageWithOutEnteringKeywordInMastHeadAndClickOnSearchButtonInArticleHomePage");
		//		String value=TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal());

		try{
			WebDriverWait wait = new WebDriverWait(driver,100);
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.mastHead()));

			CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.mastHead());
			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.mastHead()).clear();


			CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.SearchButton());

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.mastHead()));

			CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.mastHead());
			tag=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.mastHead()).getText();
			System.out.println("displayed keyword is "+tag);

			//			if(tag.contains(value))
			//			{
			//				System.out.println("pass: searched tag product home page displayed");
			//			}
			//			else
			//			{
			//				System.out.println("searched tag product home page not displayed");
			//				Report.put("Provide Service tag DNPK882 in masthead and click search button.", 
			//						"It should navigate to Product Support home page.", 
			//						"not able to search given service tag in mast head", "FAIL");   
			//				
			//				Assert.fail();
			//			}
			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ArticleTitle());
			String welcometosupport=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ArticleTitle()).getText();
			System.out.println("displayed page is "+welcometosupport);

			Report.put("Without entering the keyword in Masthead, press Search button.", 
					"It shouldn't navigate to search page showing result set.", 
					"user able to search without entering any keyword and click on search button, user shouldn't navigate to search page showing result set."+Report.color(tag), "PASS");   


		}
		catch(Exception ex){
			ex.printStackTrace();
			Report.put("Without entering the keyword in Masthead, press Search button.", 
					"It shouldn't navigate to search page showing result set.", 
					"not able to click on search button in mast head", "FAIL");   

			Assert.fail();
		}
	}

	public void ValidateSearchPageWithEnteringSpaceInMastHeadAndClickOnSearchButtonInArticlePage(WebDriver driver)
	{
		String tag="";
		String overview="";

		Log.info("Entering method ValidateSearchPageWithEnteringSpaceInMastHeadAndClickOnSearchButtonInArticlePage");
		//		String value=TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal());

		try{
			WebDriverWait wait = new WebDriverWait(driver,100);
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.mastHead()));

			CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.mastHead());
			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.mastHead()).clear();
			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.mastHead()).sendKeys(Keys.SPACE);

			CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.SearchButton());

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.mastHead()));

			CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.mastHead());
			tag=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.mastHead()).getText();
			System.out.println("displayed is "+tag);

			//			if(tag.contains(value))
			//			{
			//				System.out.println("pass: searched tag product home page displayed");
			//			}
			//			else
			//			{
			//				System.out.println("searched tag product home page not displayed");
			//				Report.put("Provide Service tag DNPK882 in masthead and click search button.", 
			//						"It should navigate to Product Support home page.", 
			//						"not able to search given service tag in mast head", "FAIL");   
			//				
			//				Assert.fail();
			//			}

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.ArticleTitle()));
			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ArticleTitle());
			String welcometosupport=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ArticleTitle()).getText();
			System.out.println("displayed page is "+welcometosupport);


			Report.put("Press Spacebar in Masthead and click  Search button", 
					"It shouldn't navigate to search page showing result set. ", 
					"User able to enter space in mast head and able to click on search button, user not navigated to search page showing different result set instead user in same page of Integrated support home page with heading "+Report.color(welcometosupport), "PASS");   


		}
		catch(Exception ex){
			ex.printStackTrace();
			Report.put("Press Spacebar in Masthead and click  Search button", 
					"It shouldn't navigate to search page showing result set. ",
					"not able to click on search button in mast head", "FAIL");   

			Assert.fail();
		}
	}

	public void ToNavigate_ManualPage(WebDriver driver)
	{


		System.out.println("Entering method ToNavigate_ManualPage");
		try{

			handleCookies(driver);

			driver.navigate().to("https://www.dell.com/support/manuals/in/en/inbsd1/latitude-e5450-laptop/dell_latitude_e5450_bdw-v1/contacting-dell?guid=guid-7a3627f9-0363-4515-a1d4-1b7878f4b8c4&lang=en-us");

			//			handleCookies(driver);
			WebDriverWait wait = new WebDriverWait(driver,300);
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.AlertsAndVulnerabilitiesHeading()));
			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.AlertsAndVulnerabilitiesHeading());
			String welcometosupport=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.AlertsAndVulnerabilitiesHeading()).getText();
			System.out.println("displayed page is "+welcometosupport);


			Report.put("Manual - launch Open URL https://www.dell.com/support/manuals/in/en/inbsd1/latitude-e5450-laptop/dell_latitude_e5450_bdw-v1/contacting-dell?guid=guid-7a3627f9-0363-4515-a1d4-1b7878f4b8c4&lang=en-us",
					"It should load Manual Details page.", 
					"Manual page loaded Successfully with header "+Report.color(welcometosupport), "PASS");


		} 
		catch(Exception ex)
		{
			ex.printStackTrace();

			Report.put("Manual - launch Open URL https://www.dell.com/support/manuals/in/en/inbsd1/latitude-e5450-laptop/dell_latitude_e5450_bdw-v1/contacting-dell?guid=guid-7a3627f9-0363-4515-a1d4-1b7878f4b8c4&lang=en-us ",
					"It should load Manual Details page.", 
					"Failed to load Manual page", "FAIL");
			Assert.fail();
		}
	}

	public void ValidateSearchPageWithOutEnteringKeywordInMastHeadAndClickOnSearchButtonInAlertAndVulnerabilityPage(WebDriver driver)
	{
		String tag="";
		String overview="";

		Log.info("Entering method ValidateSearchPageWithOutEnteringKeywordInMastHeadAndClickOnSearchButtonInAlertAndVulnerabilityPage");
		//		String value=TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal());

		try{
			WebDriverWait wait = new WebDriverWait(driver,100);
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.mastHead()));

			CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.mastHead());
			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.mastHead()).clear();


			CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.SearchButton());

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.mastHead()));

			CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.mastHead());
			tag=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.mastHead()).getText();
			System.out.println("displayed keyword is "+tag);

			//			if(tag.contains(value))
			//			{
			//				System.out.println("pass: searched tag product home page displayed");
			//			}
			//			else
			//			{
			//				System.out.println("searched tag product home page not displayed");
			//				Report.put("Provide Service tag DNPK882 in masthead and click search button.", 
			//						"It should navigate to Product Support home page.", 
			//						"not able to search given service tag in mast head", "FAIL");   
			//				
			//				Assert.fail();
			//			}
			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.AlertsAndVulnerabilitiesHeading());
			String welcometosupport=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.AlertsAndVulnerabilitiesHeading()).getText();
			System.out.println("displayed page is "+welcometosupport);

			Report.put("Without entering the keyword in Masthead, press Search button.", 
					"It shouldn't navigate to search page showing result set.", 
					"user able to search without entering any keyword and click on search button, user shouldn't navigate to search page showing result set."+Report.color(tag), "PASS");   


		}
		catch(Exception ex){
			ex.printStackTrace();
			Report.put("Without entering the keyword in Masthead, press Search button.", 
					"It shouldn't navigate to search page showing result set.", 
					"not able to click on search button in mast head", "FAIL");   

			Assert.fail();
		}
	}

	public void ValidateSearchPageWithEnteringSpaceInMastHeadAndClickOnSearchButtonInAlertsAndVulnerabilities(WebDriver driver)
	{
		String tag="";
		String overview="";

		Log.info("Entering method ValidateSearchPageWithEnteringSpaceInMastHeadAndClickOnSearchButtonInAlertsAndVulnerabilities");
		//		String value=TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal());

		try{
			WebDriverWait wait = new WebDriverWait(driver,100);
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.mastHead()));

			CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.mastHead());
			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.mastHead()).clear();
			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.mastHead()).sendKeys(Keys.SPACE);

			CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.SearchButton());

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.mastHead()));

			CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.mastHead());
			tag=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.mastHead()).getText();
			System.out.println("displayed is "+tag);

			//			if(tag.contains(value))
			//			{
			//				System.out.println("pass: searched tag product home page displayed");
			//			}
			//			else
			//			{
			//				System.out.println("searched tag product home page not displayed");
			//				Report.put("Provide Service tag DNPK882 in masthead and click search button.", 
			//						"It should navigate to Product Support home page.", 
			//						"not able to search given service tag in mast head", "FAIL");   
			//				
			//				Assert.fail();
			//			}

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.AlertsAndVulnerabilitiesHeading()));
			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.AlertsAndVulnerabilitiesHeading());
			String welcometosupport=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.AlertsAndVulnerabilitiesHeading()).getText();
			System.out.println("displayed page is "+welcometosupport);


			Report.put("Press Spacebar in Masthead and click  Search button", 
					"It shouldn't navigate to search page showing result set. ", 
					"User able to enter space in mast head and able to click on search button, user not navigated to search page showing different result set instead user in same page of Integrated support home page with heading "+Report.color(welcometosupport), "PASS");   


		}
		catch(Exception ex){
			ex.printStackTrace();
			Report.put("Press Spacebar in Masthead and click  Search button", 
					"It shouldn't navigate to search page showing result set. ",
					"not able to click on search button in mast head", "FAIL");   

			Assert.fail();
		}
	}

	public void ToNavigate_SupportVidoesPage(WebDriver driver)
	{


		System.out.println("Entering method ToNavigate_SupportVidoesPage");
		try{

			handleCookies(driver);

			driver.navigate().to("https://www.dell.com/support/contents/us/en/04/videos/videoplayer/using-windows-troubleshooters-in-windows-10/ZjbWlnNDE6HBGgnzRJb5manT7_ezGM4b?ref=supportviedeos");

			//			handleCookies(driver);
			WebDriverWait wait = new WebDriverWait(driver,500);
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.SupportVideosHeading()));
			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SupportVideosHeading());
			String welcometosupport=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SupportVideosHeading()).getText();
			System.out.println("displayed page is "+welcometosupport);


			Report.put("Open URL https://www.dell.com/support/contents/us/en/04/videos/videoplayer/using-windows-troubleshooters-in-windows-10/ZjbWlnNDE6HBGgnzRJb5manT7_ezGM4b?ref=supportviedeos",
					"It should work as expected.", 
					"Support video page loaded Successfully with header "+Report.color(welcometosupport), "PASS");


		} 
		catch(Exception ex)
		{
			ex.printStackTrace();

			Report.put("Open URL https://www.dell.com/support/contents/us/en/04/videos/videoplayer/using-windows-troubleshooters-in-windows-10/ZjbWlnNDE6HBGgnzRJb5manT7_ezGM4b?ref=supportviedeos",
					"It should work as expected.",  
					"Failed to load support video page", "FAIL");
			Assert.fail();
		}
	}

	public void ValidateSearchPageWithOutEnteringKeywordInMastHeadAndClickOnSearchButtonInSupportVideosPage(WebDriver driver)
	{
		String tag="";
		String overview="";

		Log.info("Entering method ValidateSearchPageWithOutEnteringKeywordInMastHeadAndClickOnSearchButtonInSupportVideosPage");
		//		String value=TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal());

		try{
			WebDriverWait wait = new WebDriverWait(driver,100);
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.mastHead()));

			CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.mastHead());
			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.mastHead()).clear();


			CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.SearchButton());

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.mastHead()));

			CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.mastHead());
			tag=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.mastHead()).getText();
			System.out.println("displayed keyword is "+tag);

			//			if(tag.contains(value))
			//			{
			//				System.out.println("pass: searched tag product home page displayed");
			//			}
			//			else
			//			{
			//				System.out.println("searched tag product home page not displayed");
			//				Report.put("Provide Service tag DNPK882 in masthead and click search button.", 
			//						"It should navigate to Product Support home page.", 
			//						"not able to search given service tag in mast head", "FAIL");   
			//				
			//				Assert.fail();
			//			}
			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SupportVideosHeading());
			String welcometosupport=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SupportVideosHeading()).getText();
			System.out.println("displayed page is "+welcometosupport);

			Report.put("Without entering the keyword in Masthead, press Search button.", 
					"It shouldn't navigate to search page showing result set.", 
					"user able to search without entering any keyword and click on search button, user shouldn't navigate to search page showing result set."+Report.color(tag), "PASS");   


		}
		catch(Exception ex){
			ex.printStackTrace();
			Report.put("Without entering the keyword in Masthead, press Search button.", 
					"It shouldn't navigate to search page showing result set.", 
					"not able to click on search button in mast head", "FAIL");   

			Assert.fail();
		}
	}

	public void ValidateSearchPageWithEnteringSpaceInMastHeadAndClickOnSearchButtonInSupportVideosPage(WebDriver driver)
	{
		String tag="";
		String overview="";

		Log.info("Entering method ValidateSearchPageWithEnteringSpaceInMastHeadAndClickOnSearchButtonInSupportVideosPage");
		//		String value=TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal());

		try{
			WebDriverWait wait = new WebDriverWait(driver,100);
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.mastHead()));

			CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.mastHead());
			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.mastHead()).clear();
			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.mastHead()).sendKeys(Keys.SPACE);

			CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.SearchButton());

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.mastHead()));

			CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.mastHead());
			tag=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.mastHead()).getText();
			System.out.println("displayed is "+tag);

			//			if(tag.contains(value))
			//			{
			//				System.out.println("pass: searched tag product home page displayed");
			//			}
			//			else
			//			{
			//				System.out.println("searched tag product home page not displayed");
			//				Report.put("Provide Service tag DNPK882 in masthead and click search button.", 
			//						"It should navigate to Product Support home page.", 
			//						"not able to search given service tag in mast head", "FAIL");   
			//				
			//				Assert.fail();
			//			}

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.SupportVideosHeading()));
			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SupportVideosHeading());
			String welcometosupport=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SupportVideosHeading()).getText();
			System.out.println("displayed page is "+welcometosupport);


			Report.put("Press Spacebar in Masthead and click  Search button", 
					"It shouldn't navigate to search page showing result set. ", 
					"User able to enter space in mast head and able to click on search button, user not navigated to search page showing different result set instead user in same page of Integrated support home page with heading "+Report.color(welcometosupport), "PASS");   


		}
		catch(Exception ex){
			ex.printStackTrace();
			Report.put("Press Spacebar in Masthead and click  Search button", 
					"It shouldn't navigate to search page showing result set. ",
					"not able to click on search button in mast head", "FAIL");   

			Assert.fail();
		}
	}

	public void ToNavigate_AlertVulnerabilitiesPage(WebDriver driver)
	{


		System.out.println("Entering method ToNavigate_AlertVulnerabilitiesPage");
		try{

			handleCookies(driver);

			driver.navigate().to("https://www.dell.com/support/contents/us/en/04/category/product-support/self-support-knowledgebase/security-antivirus/alerts-vulnerabilities");

			handleCookies(driver);
			WebDriverWait wait = new WebDriverWait(driver,100);
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.AlertsAndVulnerabilitiesHeading()));
			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.AlertsAndVulnerabilitiesHeading());
			String welcometosupport=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.AlertsAndVulnerabilitiesHeading()).getText();
			System.out.println("displayed page is "+welcometosupport);


			Report.put("Open URL https://www.dell.com/support/contents/us/en/04/category/product-support/self-support-knowledgebase/security-antivirus/alerts-vulnerabilities",
					"It should work as expected.", 
					"Alert vulnerabilities page loaded Successfully with header "+Report.color(welcometosupport), "PASS");


		} 
		catch(Exception ex)
		{
			ex.printStackTrace();

			Report.put("Open URL https://www.dell.com/support/contents/us/en/04/category/product-support/self-support-knowledgebase/security-antivirus/alerts-vulnerabilities",
					"It should work as expected.", 
					"Failed to load Alert vulnerabilities page", "FAIL");
			Assert.fail();
		}
	}

	public void ValidateSearchPageWithOutEnteringKeywordInMastHeadAndClickOnSearchButtonInAlertVulnerabilityPage(WebDriver driver)
	{
		String tag="";
		String overview="";

		Log.info("Entering method ValidateSearchPageWithOutEnteringKeywordInMastHeadAndClickOnSearchButtonInAlertVulnerabilityPage");
		//		String value=TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal());

		try{
			WebDriverWait wait = new WebDriverWait(driver,100);
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.mastHead()));

			CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.mastHead());
			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.mastHead()).clear();


			CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.SearchButton());

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.mastHead()));

			CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.mastHead());
			tag=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.mastHead()).getText();
			System.out.println("displayed keyword is "+tag);

			//			if(tag.contains(value))
			//			{
			//				System.out.println("pass: searched tag product home page displayed");
			//			}
			//			else
			//			{
			//				System.out.println("searched tag product home page not displayed");
			//				Report.put("Provide Service tag DNPK882 in masthead and click search button.", 
			//						"It should navigate to Product Support home page.", 
			//						"not able to search given service tag in mast head", "FAIL");   
			//				
			//				Assert.fail();
			//			}
			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.AlertsAndVulnerabilitiesHeading());
			String welcometosupport=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.AlertsAndVulnerabilitiesHeading()).getText();
			System.out.println("displayed page is "+welcometosupport);

			Report.put("Without entering the keyword in Masthead, press Search button.", 
					"It shouldn't navigate to search page showing result set.", 
					"user able to search without entering any keyword and click on search button, user shouldn't navigate to search page showing result set."+Report.color(tag), "PASS");   


		}
		catch(Exception ex){
			ex.printStackTrace();
			Report.put("Without entering the keyword in Masthead, press Search button.", 
					"It shouldn't navigate to search page showing result set.", 
					"not able to click on search button in mast head", "FAIL");   

			Assert.fail();
		}
	}

	public void ValidateSearchPageWithEnteringSpaceInMastHeadAndClickOnSearchButtonInAlertVulnerabilityPage(WebDriver driver)
	{
		String tag="";
		String overview="";

		Log.info("Entering method ValidateSearchPageWithEnteringSpaceInMastHeadAndClickOnSearchButtonInAlertVulnerabilityPage");
		//		String value=TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal());

		try{
			WebDriverWait wait = new WebDriverWait(driver,100);
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.mastHead()));

			CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.mastHead());
			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.mastHead()).clear();
			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.mastHead()).sendKeys(Keys.SPACE);

			CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.SearchButton());

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.mastHead()));

			CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.mastHead());
			tag=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.mastHead()).getText();
			System.out.println("displayed is "+tag);

			//			if(tag.contains(value))
			//			{
			//				System.out.println("pass: searched tag product home page displayed");
			//			}
			//			else
			//			{
			//				System.out.println("searched tag product home page not displayed");
			//				Report.put("Provide Service tag DNPK882 in masthead and click search button.", 
			//						"It should navigate to Product Support home page.", 
			//						"not able to search given service tag in mast head", "FAIL");   
			//				
			//				Assert.fail();
			//			}

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.AlertsAndVulnerabilitiesHeading()));
			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.AlertsAndVulnerabilitiesHeading());
			String welcometosupport=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.AlertsAndVulnerabilitiesHeading()).getText();
			System.out.println("displayed page is "+welcometosupport);


			Report.put("Press Spacebar in Masthead and click  Search button", 
					"It shouldn't navigate to search page showing result set. ", 
					"User able to enter space in mast head and able to click on search button, user not navigated to search page showing different result set instead user in same page of Integrated support home page with heading "+Report.color(welcometosupport), "PASS");   


		}
		catch(Exception ex){
			ex.printStackTrace();
			Report.put("Press Spacebar in Masthead and click  Search button", 
					"It shouldn't navigate to search page showing result set. ",
					"not able to click on search button in mast head", "FAIL");   

			Assert.fail();
		}
	}

	public void ToNavigate_OrderStatusHomePage(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver,100);

		System.out.println("Entering methods ToNavigate_OrderStatusHomePage");
		try{
			Thread.sleep(7000);
			//			handleCookies(driver);

			driver.navigate().to("https://www.dell.com/support/order-status/en-us/order-support");

			handleCookies(driver);
			
			Thread.sleep(7000);

			//wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.OrderStatusHeading()));
			if(CommonUtility.CheckpresenceofElementLocated(driver, 10, obj_EsupportCoveoPage.OrderStatusHeading()))
			{
				CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.OrderStatusHeading());
				String welcometosupport=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.OrderStatusHeading()).getText();
				System.out.println("displayed page is "+welcometosupport);
				
				Report.put("Open URL     https://www.dell.com/support/orders/in/en/inbsd1/",
						"Order Status Home page should get loaded.", 
						"Order Status home page loaded Successfully with header "+Report.color(welcometosupport), "PASS");
            }
			else if(CommonUtility.CheckpresenceofElementLocated(driver, 10, obj_EsupportCoveoPage.OrderHistoryHeading()))
			{
				CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.OrderHistoryHeading());
				String welcometosupport=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.OrderHistoryHeading()).getText();
				System.out.println("displayed page is "+welcometosupport);
				
				Report.put("Open URL     https://www.dell.com/support/orders/in/en/inbsd1/",
						"Order Status Home page should get loaded.", 
						"Order Status home page loaded Successfully with header "+Report.color(welcometosupport), "PASS");
			}
			
			

			


		} 
		catch(Exception ex)
		{
			ex.printStackTrace();

			Report.put("Open URL     https://www.dell.com/support/orders/in/en/inbsd1/",
					"Order Status Home page should get loaded.",   
					"Failed to load Order Status home page", "FAIL");
			Assert.fail();
		}
	}

	public void ValidateSearchPageWithOutEnteringKeywordInMastHeadAndClickOnSearchButtonInOrderStatusPage(WebDriver driver)
	{
		String tag="";
		String overview="";

		Log.info("Entering method ValidateSearchPageWithOutEnteringKeywordInMastHeadAndClickOnSearchButtonInOrderStatusPage");
		//		String value=TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal());

		try{
			WebDriverWait wait = new WebDriverWait(driver,100);
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.mastHead()));

			CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.mastHead());
			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.mastHead()).clear();


			CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.SearchButton());

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.mastHead()));

			CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.mastHead());
			tag=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.mastHead()).getText();
			System.out.println("displayed keyword is "+tag);

			//			if(tag.contains(value))
			//			{
			//				System.out.println("pass: searched tag product home page displayed");
			//			}
			//			else
			//			{
			//				System.out.println("searched tag product home page not displayed");
			//				Report.put("Provide Service tag DNPK882 in masthead and click search button.", 
			//						"It should navigate to Product Support home page.", 
			//						"not able to search given service tag in mast head", "FAIL");   
			//				
			//				Assert.fail();
			//			}
			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.OrderStatusHeading());
			String welcometosupport=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.OrderStatusHeading()).getText();
			System.out.println("displayed page is "+welcometosupport);

			Report.put("Without entering the keyword in Masthead, press Search button.", 
					"It shouldn't navigate to search page showing result set.", 
					"user able to search without entering any keyword and click on search button, user shouldn't navigate to search page showing result set."+Report.color(tag), "PASS");   


		}
		catch(Exception ex){
			ex.printStackTrace();
			Report.put("Without entering the keyword in Masthead, press Search button.", 
					"It shouldn't navigate to search page showing result set.", 
					"not able to click on search button in mast head", "FAIL");   

			Assert.fail();
		}
	}

	public void ValidateSearchPageWithEnteringSpaceInMastHeadAndClickOnSearchButtonInOrderStatusHomePage(WebDriver driver)
	{
		String tag="";
		String overview="";

		Log.info("Entering method ValidateSearchPageWithEnteringSpaceInMastHeadAndClickOnSearchButtonInOrderStatusHomePage");
		//		String value=TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal());

		try{
			WebDriverWait wait = new WebDriverWait(driver,100);
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.mastHead()));

			CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.mastHead());
			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.mastHead()).clear();
			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.mastHead()).sendKeys(Keys.SPACE);

			CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.SearchButton());

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.mastHead()));

			CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.mastHead());
			tag=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.mastHead()).getText();
			System.out.println("displayed is "+tag);

			//			if(tag.contains(value))
			//			{
			//				System.out.println("pass: searched tag product home page displayed");
			//			}
			//			else
			//			{
			//				System.out.println("searched tag product home page not displayed");
			//				Report.put("Provide Service tag DNPK882 in masthead and click search button.", 
			//						"It should navigate to Product Support home page.", 
			//						"not able to search given service tag in mast head", "FAIL");   
			//				
			//				Assert.fail();
			//			}

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.OrderStatusHeading()));
			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.OrderStatusHeading());
			String welcometosupport=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.OrderStatusHeading()).getText();
			System.out.println("displayed page is "+welcometosupport);


			Report.put("Press Spacebar in Masthead and click  Search button", 
					"It shouldn't navigate to search page showing result set. ", 
					"User able to enter space in mast head and able to click on search button, user not navigated to search page showing different result set instead user in same page of Integrated support home page with heading "+Report.color(welcometosupport), "PASS");   


		}
		catch(Exception ex){
			ex.printStackTrace();
			Report.put("Press Spacebar in Masthead and click  Search button", 
					"It shouldn't navigate to search page showing result set. ",
					"not able to click on search button in mast head", "FAIL");   

			Assert.fail();
		}
	}

	public void ToNavigate_DiagnosticsAndToolsHomePage(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver,10);

		System.out.println("Entering methods ToNavigate_DiagnosticsAndToolsHomePage");
		try{

			//			handleCookies(driver);

			driver.navigate().to("https://www.dell.com/support/diagnose/us/en/19/quicktest");

			handleCookies(driver);

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.DiagnosticsAndTools()));
			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.DiagnosticsAndTools());
			String welcometosupport=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.DiagnosticsAndTools()).getText();
			System.out.println("displayed page is "+welcometosupport);


			Report.put("Open URL     https://www.dell.com/support/diagnose/us/en/19/quicktest",
					"Diagnostics Home page should get loaded.", 
					"Diagnostics home page loaded Successfully with header "+Report.color(welcometosupport), "PASS");


		} 
		catch(Exception ex)
		{
			ex.printStackTrace();

			Report.put("Open URL     https://www.dell.com/support/diagnose/us/en/19/quicktest",
					"Diagnostics Home page should get loaded.",
					"Failed to load Diagnostics home page", "FAIL");
			Assert.fail();
		}
	}

	public void ToNavigate_PreBootAnalysis(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver,10);

		System.out.println("Entering methods ToNavigate_PreBootAnalysis");
		try{

			//			handleCookies(driver);

			driver.navigate().to("https://www.dell.com/support/home/in/en/indhs1/pre-boot-analysis");

			handleCookies(driver);

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.DiagnosticsAndTools()));
			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.DiagnosticsAndTools());
			String welcometosupport=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.DiagnosticsAndTools()).getText();
			System.out.println("displayed page is "+welcometosupport);


			Report.put("Open URL    https://www.dell.com/support/home/in/en/indhs1/pre-boot-analysis",
					"Pre Boot Analysis page should get loaded.", 
					"Pre Boot Analysis page loaded Successfully with header "+Report.color(welcometosupport), "PASS");


		} 
		catch(Exception ex)
		{
			ex.printStackTrace();

			Report.put("Open URL    https://www.dell.com/support/home/in/en/indhs1/pre-boot-analysis",
					"Pre Boot Analysis page should get loaded.", 
					"Failed to load Pre Boot Analysis page", "FAIL");
			Assert.fail();
		}
	}

	public void ToNavigate_CISCustomerFacingTool(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver,10);

		System.out.println("Entering methods ToNavigate_CISCustomerFacingTool");
		try{

			//			handleCookies(driver);

			driver.navigate().to("https://www.dell.com/support/home/in/en/indhs1/servicecenter");

			handleCookies(driver);

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.CISPageHeading()));
			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.CISPageHeading());
			String welcometosupport=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.CISPageHeading()).getText();
			System.out.println("displayed page is "+welcometosupport);


			Report.put("Open URL    https://www.dell.com/support/home/in/en/indhs1/servicecenter",
					"CIS Customer facing tool should open.", 
					"CIS Customer facing tool loaded Successfully with header "+Report.color(welcometosupport), "PASS");


		} 
		catch(Exception ex)
		{
			ex.printStackTrace();

			Report.put("Open URL    https://www.dell.com/support/home/in/en/indhs1/servicecenter",
					"CIS Customer facing tool should open.", 
					"Failed to load CIS Customer facing tool page", "FAIL");
			Assert.fail();
		}
	}

	public void ValidateSearchPageWithOutEnteringKeywordInMastHeadAndClickOnSearchButtonInDiagnosticsPage(WebDriver driver)
	{
		String tag="";
		String overview="";

		Log.info("Entering method ValidateSearchPageWithOutEnteringKeywordInMastHeadAndClickOnSearchButtonInDiagnosticsPage");
		//		String value=TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal());

		try{
			WebDriverWait wait = new WebDriverWait(driver,100);
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.mastHead()));

			CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.mastHead());
			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.mastHead()).clear();


			CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.SearchButton());

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.mastHead()));

			CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.mastHead());
			tag=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.mastHead()).getText();
			System.out.println("displayed keyword is "+tag);

			//			if(tag.contains(value))
			//			{
			//				System.out.println("pass: searched tag product home page displayed");
			//			}
			//			else
			//			{
			//				System.out.println("searched tag product home page not displayed");
			//				Report.put("Provide Service tag DNPK882 in masthead and click search button.", 
			//						"It should navigate to Product Support home page.", 
			//						"not able to search given service tag in mast head", "FAIL");   
			//				
			//				Assert.fail();
			//			}
			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.DiagnosticsAndTools());
			String welcometosupport=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.DiagnosticsAndTools()).getText();
			System.out.println("displayed page is "+welcometosupport);

			Report.put("Without entering the keyword in Masthead, press Search button.", 
					"It shouldn't navigate to search page showing result set.", 
					"user able to search without entering any keyword and click on search button, user shouldn't navigate to search page showing result set."+Report.color(tag), "PASS");   


		}
		catch(Exception ex){
			ex.printStackTrace();
			Report.put("Without entering the keyword in Masthead, press Search button.", 
					"It shouldn't navigate to search page showing result set.", 
					"not able to click on search button in mast head", "FAIL");   

			Assert.fail();
		}
	}

	public void ValidateSearchPageWithEnteringSpaceInMastHeadAndClickOnSearchButtonInDiagnosticsHomePage(WebDriver driver)
	{
		String tag="";
		String overview="";

		Log.info("Entering method ValidateSearchPageWithEnteringSpaceInMastHeadAndClickOnSearchButtonInDiagnosticsHomePage");
		//		String value=TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal());

		try{
			WebDriverWait wait = new WebDriverWait(driver,100);
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.mastHead()));

			CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.mastHead());
			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.mastHead()).clear();
			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.mastHead()).sendKeys(Keys.SPACE);

			CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.SearchButton());

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.mastHead()));

			CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.mastHead());
			tag=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.mastHead()).getText();
			System.out.println("displayed is "+tag);

			//			if(tag.contains(value))
			//			{
			//				System.out.println("pass: searched tag product home page displayed");
			//			}
			//			else
			//			{
			//				System.out.println("searched tag product home page not displayed");
			//				Report.put("Provide Service tag DNPK882 in masthead and click search button.", 
			//						"It should navigate to Product Support home page.", 
			//						"not able to search given service tag in mast head", "FAIL");   
			//				
			//				Assert.fail();
			//			}

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.DiagnosticsAndTools()));
			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.DiagnosticsAndTools());
			String welcometosupport=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.DiagnosticsAndTools()).getText();
			System.out.println("displayed page is "+welcometosupport);


			Report.put("Press Spacebar in Masthead and click  Search button", 
					"It shouldn't navigate to search page showing result set. ", 
					"User able to enter space in mast head and able to click on search button, user not navigated to search page showing different result set instead user in same page of Integrated support home page with heading "+Report.color(welcometosupport), "PASS");   


		}
		catch(Exception ex){
			ex.printStackTrace();
			Report.put("Press Spacebar in Masthead and click  Search button", 
					"It shouldn't navigate to search page showing result set. ",
					"not able to click on search button in mast head", "FAIL");   

			Assert.fail();
		}
	}

	public void ToNavigate_DDLHomePage(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver,200);

		System.out.println("Entering methods ToNavigate_DDLHomePage");
		try{

			//			handleCookies(driver);

			driver.navigate().to("https://www.dell.com/support/software/us/en/19");

			handleCookies(driver);

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.DigitalLockerHeader()));
			CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.DigitalLockerHeader());
			String welcometosupport=CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.DigitalLockerHeader()).getText();
			System.out.println("displayed page is "+welcometosupport);


			Report.put("Open URL     https://www.dell.com/support/software/us/en/19",
					"DDL sign-in page should get loaded.", 
					"DDL sign-in page loaded Successfully with header "+Report.color(welcometosupport), "PASS");


		} 
		catch(Exception ex)
		{
			ex.printStackTrace();

			Report.put("Open URL     https://www.dell.com/support/software/us/en/19",
					"DDL sign-in page should get loaded.", 
					"Failed to load DDL sign-in page", "FAIL");
			Assert.fail();
		}
	}

	public void ValidateSearchPageWithOutEnteringKeywordInMastHeadAndClickOnSearchButtonInDDLPageBeforeSignIn(WebDriver driver)
	{
		String tag="";
		String overview="";

		Log.info("Entering method ValidateSearchPageWithOutEnteringKeywordInMastHeadAndClickOnSearchButtonInDDLPageBeforeSignIn");
		//		String value=TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal());

		try{
			WebDriverWait wait = new WebDriverWait(driver,100);
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.mastHead()));

			CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.mastHead());
			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.mastHead()).clear();


			CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.SearchButton());

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.mastHead()));

			CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.mastHead());
			tag=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.mastHead()).getText();
			System.out.println("displayed keyword is "+tag);

			//			if(tag.contains(value))
			//			{
			//				System.out.println("pass: searched tag product home page displayed");
			//			}
			//			else
			//			{
			//				System.out.println("searched tag product home page not displayed");
			//				Report.put("Provide Service tag DNPK882 in masthead and click search button.", 
			//						"It should navigate to Product Support home page.", 
			//						"not able to search given service tag in mast head", "FAIL");   
			//				
			//				Assert.fail();
			//			}
			CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.DigitalLockerHeader());
			String welcometosupport=CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.DigitalLockerHeader()).getText();
			System.out.println("displayed page is "+welcometosupport);

			Report.put("Without entering the keyword in Masthead, press Search button.", 
					"It shouldn't navigate to search page showing result set.", 
					"user able to search without entering any keyword and click on search button, user shouldn't navigate to search page showing result set."+Report.color(tag), "PASS");   


		}
		catch(Exception ex){
			ex.printStackTrace();
			Report.put("Without entering the keyword in Masthead, press Search button.", 
					"It shouldn't navigate to search page showing result set.", 
					"not able to click on search button in mast head", "FAIL");   

			Assert.fail();
		}
	}


	public void ValidateSearchPageWithEnteringSpaceInMastHeadAndClickOnSearchButtonInDDLPageBeforeSignIn(WebDriver driver)
	{
		String tag="";
		String overview="";

		Log.info("Entering method ValidateSearchPageWithEnteringSpaceInMastHeadAndClickOnSearchButtonInDDLPageBeforeSignIn");
		//		String value=TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal());

		try{
			WebDriverWait wait = new WebDriverWait(driver,100);
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.mastHead()));

			CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.mastHead());
			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.mastHead()).clear();
			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.mastHead()).sendKeys(Keys.SPACE);

			CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.SearchButton());

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.mastHead()));

			CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.mastHead());
			tag=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.mastHead()).getText();
			System.out.println("displayed is "+tag);

			//			if(tag.contains(value))
			//			{
			//				System.out.println("pass: searched tag product home page displayed");
			//			}
			//			else
			//			{
			//				System.out.println("searched tag product home page not displayed");
			//				Report.put("Provide Service tag DNPK882 in masthead and click search button.", 
			//						"It should navigate to Product Support home page.", 
			//						"not able to search given service tag in mast head", "FAIL");   
			//				
			//				Assert.fail();
			//			}

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.DigitalLockerHeader()));
			CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.DigitalLockerHeader());
			String welcometosupport=CommonUtility.highlightElement(driver,obj_EsupportDDLHomePage.DigitalLockerHeader()).getText();
			System.out.println("displayed page is "+welcometosupport);


			Report.put("Press Spacebar in Masthead and click  Search button", 
					"It shouldn't navigate to search page showing result set. ", 
					"User able to enter space in mast head and able to click on search button, user not navigated to search page showing different result set instead user in same page of Integrated support home page with heading "+Report.color(welcometosupport), "PASS");   


		}
		catch(Exception ex){
			ex.printStackTrace();
			Report.put("Press Spacebar in Masthead and click  Search button", 
					"It shouldn't navigate to search page showing result set. ",
					"not able to click on search button in mast head", "FAIL");   

			Assert.fail();
		}
	}

	public void ValidateSearchPageWithOutEnteringKeywordInMastHeadAndClickOnSearchButtonInDDLPageAfterSignIn(WebDriver driver)
	{
		String tag="";
		String overview="";

		Log.info("Entering method ValidateSearchPageWithOutEnteringKeywordInMastHeadAndClickOnSearchButtonInDDLPageAfterSignIn");
		//		String value=TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal());

		try{
			WebDriverWait wait = new WebDriverWait(driver,100);
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.mastHead()));

			CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.mastHead());
			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.mastHead()).clear();


			CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.SearchButton());

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.mastHead()));

			CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.mastHead());
			tag=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.mastHead()).getText();
			System.out.println("displayed keyword is "+tag);

			//			if(tag.contains(value))
			//			{
			//				System.out.println("pass: searched tag product home page displayed");
			//			}
			//			else
			//			{
			//				System.out.println("searched tag product home page not displayed");
			//				Report.put("Provide Service tag DNPK882 in masthead and click search button.", 
			//						"It should navigate to Product Support home page.", 
			//						"not able to search given service tag in mast head", "FAIL");   
			//				
			//				Assert.fail();
			//			}
			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.DellDigitalLockerHeadingAfterSignIn());
			String welcometosupport=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.DellDigitalLockerHeadingAfterSignIn()).getText();
			System.out.println("displayed page is "+welcometosupport);

			Report.put("Without entering the keyword in Masthead, press Search button.", 
					"It shouldn't navigate to search page showing result set.", 
					"user able to search without entering any keyword and click on search button, user shouldn't navigate to search page showing result set."+Report.color(tag), "PASS");   


		}
		catch(Exception ex){
			ex.printStackTrace();
			Report.put("Without entering the keyword in Masthead, press Search button.", 
					"It shouldn't navigate to search page showing result set.", 
					"not able to click on search button in mast head", "FAIL");   

			Assert.fail();
		}
	}

	public void ValidateSearchPageWithEnteringSpaceInMastHeadAndClickOnSearchButtonInDDLPageAfterSignIn(WebDriver driver)
	{
		String tag="";
		String overview="";

		Log.info("Entering method ValidateSearchPageWithEnteringSpaceInMastHeadAndClickOnSearchButtonInDDLPageAfterSignIn");
		//		String value=TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal());

		try{
			WebDriverWait wait = new WebDriverWait(driver,200);
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.mastHead()));

			CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.mastHead());
			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.mastHead()).clear();
			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.mastHead()).sendKeys(Keys.SPACE);

			CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.SearchButton());

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.mastHead()));

			CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.mastHead());
			tag=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.mastHead()).getText();
			System.out.println("displayed is "+tag);

			//			if(tag.contains(value))
			//			{
			//				System.out.println("pass: searched tag product home page displayed");
			//			}
			//			else
			//			{
			//				System.out.println("searched tag product home page not displayed");
			//				Report.put("Provide Service tag DNPK882 in masthead and click search button.", 
			//						"It should navigate to Product Support home page.", 
			//						"not able to search given service tag in mast head", "FAIL");   
			//				
			//				Assert.fail();
			//			}

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.DellDigitalLockerHeadingAfterSignIn()));
			CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.DellDigitalLockerHeadingAfterSignIn());
			String welcometosupport=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.DellDigitalLockerHeadingAfterSignIn()).getText();
			System.out.println("displayed page is "+welcometosupport);


			Report.put("Press Spacebar in Masthead and click  Search button", 
					"It shouldn't navigate to search page showing result set. ", 
					"User able to enter space in mast head and able to click on search button, user not navigated to search page showing different result set instead user in same page of Integrated support home page with heading "+Report.color(welcometosupport), "PASS");   


		}
		catch(Exception ex){
			ex.printStackTrace();
			Report.put("Press Spacebar in Masthead and click  Search button", 
					"It shouldn't navigate to search page showing result set. ",
					"not able to click on search button in mast head", "FAIL");   

			Assert.fail();
		}
	}

	public void  SelectForumClickFirstDiplayedResultWhichHaveForumIcon(WebDriver driver, String Dpid) 
	{
		Log.info("Entering SelectForumClickFirstDiplayedResultWhichHaveForumIcon");   
		WebDriverWait wait = new WebDriverWait(driver, 120);

		String enteredtext = "";
		String searchresult="";
		String filter="";
		String result="";
		String attr="";
		String title="";
		String currenturl="";
		String resourcetype2 = TestNGCreator.TestData.get(Esupport.Dpid.ordinal()).split(";")[4];
		Actions act= new Actions(driver);

		try
		{       
			Log.info("Inside try of SelectForumClickFirstDiplayedResultWhichHaveForumIcon");
			//wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.KnowledgeBaseClick()));
			//Lavanya added implicit wait to click below element
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			if(CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ForumsClick()).isDisplayed())
			{
				//				CommonUtility.scrollToViewElement(driver,obj_EsupportCoveoPage.ForumsClick());
				CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.ForumsClick());
				//				Thread.sleep(5000);
				//					CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.KnowledgeBaseClick()).click();
				//				act.moveToElement(CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ForumsClick())).click().build().perform();
				//					CommonUtility.ToClickByUsingJavaScript_PassingByLoc(driver, obj_EsupportCoveoPage.KnowledgeBaseClick());
				CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.ForumsClick());
				Thread.sleep(10000);
			}

			//wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.GetCoveoOverAllSearchResult()));
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			//			CommonUtility.scrollToViewElement(driver,obj_EsupportCoveoPage.GetCoveoOverAllSearchResult());
			CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.GetCoveoOverAllSearchResult());
			searchresult=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.GetCoveoOverAllSearchResult()).getText();
			System.out.println("all result is for entered keyword and selected resource type is "+searchresult);



			String filterheader=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ValidateFiltersSectionHeader()).getText();
			System.out.println("header is "+filterheader);

			List<WebElement> getallfilters=driver.findElements(obj_EsupportCoveoPage.GetAllFilters());
			int totalfilterscount=getallfilters.size();
			System.out.println("total count of selected filters "+totalfilterscount);

			for(int j=0;j<totalfilterscount;j++)
			{
				filter+=",<br>"+getallfilters.get(j).getText();
				System.out.println("filters displayed are "+filter);

				if (filter.contains(resourcetype2))
				{
					Log.info("test case pass: resource types forums displayed under your filter section");
				}
				else
				{
					Log.info("test case fail: resource types knowledge base not displayed under your filter section");
					Report.put("Select Forums option from the Resources Facet. Click on any of the link having ForumIcon from the result set as in attached image ", 
							"It should open the link in new window.",  
							"for Resource Type "+Report.color(filter)+" is not displayed by under heading "+Report.color(filterheader), "FAIL");;
							Assert.fail();
				}

			}

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.CoveoResultSection()));

			List<WebElement> listofresultsdisplayed=driver.findElements(obj_EsupportCoveoPage.CountOfDisplayedResults());
			int countofresultsdisplayed=listofresultsdisplayed.size();
			System.out.println("total number of results displayed are "+countofresultsdisplayed);

			for(int i=0; i<countofresultsdisplayed;i++)
			{
				result+=",<br>"+listofresultsdisplayed.get(i).getText();
				System.out.println("displayed result on clicking resource type forums are "+result);
			}

			//wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.ForumIcon()));

			//			CommonUtility.scrollToViewElement(driver,obj_EsupportCoveoPage.ForumIcon());
			//CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.ForumIcon());

			//			List<WebElement> knowledgebaseiconlist=driver.findElements(obj_EsupportCoveoPage.KnowledgeBaseIconValidation());
			//			int knowledgebaseiconcount=knowledgebaseiconlist.size();
			//			System.out.println("total number of video icons displayed are "+knowledgebaseiconcount);
			//
			//			for(int k=0; k<knowledgebaseiconcount;k++)
			//			{
			//				attr+="<br>"+knowledgebaseiconlist.get(k).getAttribute("title");
			//				System.out.println("title displayed is "+attr);
			//				if(attr.contains("Knowledgebase"))
			//				{
			//					Log.info("test case pass: Knowledgebase icon displayed on selecting Knowledgebase resource type");
			//				}
			//				else
			//				{
			//					Log.info("test case fail:Knowledgebase icon not displayed on selecting Knowledgebase in result");
			//					Report.put("Select the resource type 'knowledge base'", 
			//							"All featured results belonging to resource type should be shown displayed. Observe the Icon of every result. Open few results and verify.", 
			//							"for Resource Type "+Report.color(resourcetype2)+" Knowledgebase icon is not displayed", "FAIL");;
			//							Assert.fail();
			//				}
			//			}

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.LinkTitleWhichHaveForumIcon()));
			//			CommonUtility.scrollToViewElement(driver,obj_EsupportCoveoPage.LinkTitleWhichHaveForumIcon());
			//			CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.LinkTitleWhichHaveForumIcon());
			//			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.LinkTitleWhichHaveForumIcon()).click();
			CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.LinkTitleWhichHaveForumIcon());

			Thread.sleep(10000);
			String mainwindow=driver.getWindowHandle();
			Set<String> set=driver.getWindowHandles();
			Iterator<String> itr=set.iterator();
			while(itr.hasNext())
			{
				String childWindow=itr.next();
				if(!mainwindow.equals(childWindow))
				{
					driver.switchTo().window(childWindow);
					title=title+" ,<br> "+driver.getTitle();
					System.out.println(driver.switchTo().window(childWindow).getTitle());
					System.out.println(driver.switchTo().window(childWindow).getCurrentUrl());
					currenturl=currenturl+" ,<br> "+driver.getCurrentUrl();
					if (currenturl.contains("community"))
					{
						Log.info("Test case pass:forum content page opened");
					}
					else
					{
						driver.close();
						Log.info("Test case forum content page not opened");
						Report.put("Select Forums option from the Resources Facet. Click on any of the link having ForumIcon from the result set as in attached image ", 
								"It should open the link in new window.", 
								"content page not opened in seperate window on clicking coveo results displayed for keyword search", "FAIL");
						Assert.fail();
					}
					driver.close();
				}
			}

			driver.switchTo().window(mainwindow);
			//wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.ClearFilters()));
			//			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			//			CommonUtility.scrollToViewElement(driver,obj_EsupportCoveoPage.ClearFilters());
			//
			//			CommonUtility.scrollToViewElement(driver,obj_EsupportCoveoPage.ClearFilters());
			//			CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.ClearFilters());
			//			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ClearFilters()).click();
			CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.ClearFilters());
			Thread.sleep(10000);

			Report.put("Select Forums option from the Resources Facet. Click on any of the link having ForumIcon from the result set as in attached image ", 
					"It should open the link in new window.", 
					"User able to see Only the results belonging to "+Report.color(resourcetype2)+"<br> and Icon displayed is <br> "+Report.color(attr)+"<br> and clicked on first result displayed and able to see title of page as "+Report.color(title)+" <br> and url of page is <br> "+Report.color(currenturl), "PASS");

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Select Forums option from the Resources Facet. Click on any of the link having ForumIcon from the result set as in attached image ", 
					"It should open the link in new window.", 
					"not able to see only selected resource type filtered or not able to navigate to content page clicking on coveo results displayed", "FAIL");
			Assert.fail();
		}
	}

	public void SearchingServiceTagProductCodeSerialNumberInMastHead(WebDriver driver, String SearchOption)
	{
		String tag="";
		String overview="";

		Log.info("Entering in method SearchingServiceTagProductCodeSerialNumberInMastHead");
		//		String value=TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal());
		//		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);

		try{
			handleCookies(driver);
			WebDriverWait wait = new WebDriverWait(driver, 200);

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.mastHead()));
			CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.mastHead());
			CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.mastHead());
			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.mastHead()).clear();
			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.mastHead()).sendKeys(SearchOption);
			
			CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.SearchButtonMastHead());
			CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.SearchButtonMastHead());
			
			Thread.sleep(10000);
//			driver.navigate().refresh();
			Thread.sleep(10000);
			
			CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.ProductSupportHomePage());
			if(CommonUtility.CheckpresenceofElementLocated(driver,30,obj_EsupportCoveoPage.ProductSupportHomePage()))
			{
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.ProductSupportHomePage()));

				CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.ProductSupportHomePage());
				tag=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ProductSupportHomePage()).getText();
				System.out.println("tag displayed is "+tag);

				if(tag.contains(SearchOption))
				{
					System.out.println("pass: searched tag product home page displayed");
				}
				else
				{
					System.out.println("searched tag product home page not displayed");
					Report.put("Provide product code/serial number in masthead and click search button.", 
							"It should navigate to Product Support home page.", 
							"not able to search given service tag in mast head", "FAIL");   

					Assert.fail();
				}
			}
			else
			{
				CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.SearchButton());
				CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.SearchButton());
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.ProductSupportHomePage()));

				CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.ProductSupportHomePage());
				tag=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ProductSupportHomePage()).getText();
				System.out.println("tag displayed is "+tag);

				if(tag.contains(SearchOption))
				{
					System.out.println("pass: searched tag product home page displayed");
				}
				else
				{
					System.out.println("searched tag product home page not displayed");
					Report.put("Provide product code/serial number in masthead and click search button.", 
							"It should navigate to Product Support home page.", 
							"not able to search given service tag in mast head", "FAIL");   

					Assert.fail();
				}
			}

			Thread.sleep(10000);

			CommonUtility.ScrollTo(driver,obj_EsupportContentHomePage.DefaultDisplayedTabInProductHomePage());
			overview=CommonUtility.highlightElement(driver,obj_EsupportContentHomePage.DefaultDisplayedTabInProductHomePage()).getText();
			System.out.println("displayed tab is "+overview);



			Report.put("Provide product code/serial number in masthead and click search button.", 
					"It should navigate to Product Support home page.", 
					"user able to search "+Report.color(SearchOption)+" in mast head and linding on "+Report.color(tag)+" Product support home page and default landing on "+Report.color(overview)+" tag", "PASS");   


		}
		catch(Exception ex){
			ex.printStackTrace();
			Report.put("Provide product code/serial number in masthead and click search button.", 
					"It should navigate to Product Support home page.", 
					"not able to search given service tag in mast head", "FAIL");   

			Assert.fail();
		}
	}

	public void SearchingServiceTagProductCodeSerialNumberInMastHead1(WebDriver driver, String SearchOption)
	{
		String tag="";
		String overview="";

		Log.info("Entering in method SearchingServiceTagProductCodeSerialNumberInMastHead");
		//		String value=TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal());
		//		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);

		try{
			handleCookies(driver);
			WebDriverWait wait = new WebDriverWait(driver, 200);

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.mastHead()));
			CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.mastHead());
			CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.mastHead());
			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.mastHead()).clear();
			//CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.mastHead()).sendKeys(SearchOption);
			
			char[] productNameInputArray = SearchOption.toCharArray();
			for (int j = 0; j < productNameInputArray.length; j++) 
			{
				Thread.sleep(3000);
				driver.findElement(obj_EsupportCoveoPage.mastHead())
						.sendKeys(String.valueOf(productNameInputArray[j]));
			}
			CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.SearchButtonMastHead());
			CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.SearchButtonMastHead());
			
			Thread.sleep(10000);
//			driver.navigate().refresh();
			Thread.sleep(10000);
			
			CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.ProductSupportHomePage());
			if(CommonUtility.CheckpresenceofElementLocated(driver,30,obj_EsupportCoveoPage.ProductSupportHomePage()))
			{
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.ProductSupportHomePage()));

				CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.ProductSupportHomePage());
				tag=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ProductSupportHomePage()).getText();
				System.out.println("tag displayed is "+tag);

				if(tag.contains(SearchOption))
				{
					System.out.println("pass: searched tag product home page displayed");
				}
				else
				{
					System.out.println("searched tag product home page not displayed");
					Report.put("Provide product code/serial number in masthead and click search button.", 
							"It should navigate to Product Support home page.", 
							"not able to search given service tag in mast head", "FAIL");   

					Assert.fail();
				}
			}
			else
			{
				CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.SearchButton());
				CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.SearchButton());
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.ProductSupportHomePage()));

				CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.ProductSupportHomePage());
				tag=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ProductSupportHomePage()).getText();
				System.out.println("tag displayed is "+tag);

				if(tag.contains(SearchOption))
				{
					System.out.println("pass: searched tag product home page displayed");
				}
				else
				{
					System.out.println("searched tag product home page not displayed");
					Report.put("Provide product code/serial number in masthead and click search button.", 
							"It should navigate to Product Support home page.", 
							"not able to search given service tag in mast head", "FAIL");   

					Assert.fail();
				}
			}

			Thread.sleep(10000);

			CommonUtility.ScrollTo(driver,obj_EsupportContentHomePage.DefaultDisplayedTabInProductHomePage());
			overview=CommonUtility.highlightElement(driver,obj_EsupportContentHomePage.DefaultDisplayedTabInProductHomePage()).getText();
			System.out.println("displayed tab is "+overview);



			Report.put("Provide product code/serial number in masthead and click search button.", 
					"It should navigate to Product Support home page.", 
					"user able to search "+Report.color(SearchOption)+" in mast head and linding on "+Report.color(tag)+" Product support home page and default landing on "+Report.color(overview)+" tag", "PASS");   


		}
		catch(Exception ex){
			ex.printStackTrace();
			Report.put("Provide product code/serial number in masthead and click search button.", 
					"It should navigate to Product Support home page.", 
					"not able to search given service tag in mast head", "FAIL");   

			Assert.fail();
		}
	}
	
	public void ClickSearchProductForLEMC(WebDriver driver,String Product,String Username, String Password) 
	{
		Log.info("Entering method ClickSearchProductForLEMC");
		WebDriverWait  wait = new WebDriverWait(driver, 120);
//		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String overview="";
		String tag="";
		
		try
		{
			handleCookies(driver);
			//			WebDriverWait wait = new WebDriverWait(driver, 200);

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.mastHead()));

			CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.mastHead());
			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.mastHead()).clear();
			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.mastHead()).sendKeys(Product);
			
			CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.SearchButtonMastHead());
			CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.SearchButtonMastHead());
			
//			Thread.sleep(6000);
//			driver.navigate().refresh();
			Thread.sleep(10000);
			
			CommonUtility.ScrollTo(driver, obj_EsupportDDLHomePage.Email());
			if(CommonUtility.CheckpresenceofElementLocated(driver, 20,obj_EsupportDDLHomePage.Email()))
			{
//				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.Email()));

				CommonUtility.ScrollTo(driver, obj_EsupportDDLHomePage.Email());
				CommonUtility.highlightElement(driver, obj_EsupportDDLHomePage.Email()).sendKeys(Username);

				System.out.println("Entered Email(Username) as "+Username);

				CommonUtility.ScrollTo(driver, obj_EsupportDDLHomePage.Password());
				CommonUtility.highlightElement(driver, obj_EsupportDDLHomePage.Password()).sendKeys(Password);

				System.out.println("Entered Password as "+Password);
				CommonUtility.highlightElement(driver, obj_EsupportDDLHomePage.SignIn());
				//			CommonUtility.highlightElement(driver, obj_EsupportDDLHomePage.SignIn()).click();
				CommonUtility.ClickOn(driver, obj_EsupportDDLHomePage.SignIn());
				System.out.println("Clicked on SignIn Button ");
			}
			else if(CommonUtility.CheckpresenceofElementLocated(driver, alertcount, obj_EsupportDDLHomePage.Email1())) 
			{
				CommonUtility.ScrollTo(driver, obj_EsupportDDLHomePage.Email1());
				CommonUtility.highlightElement(driver, obj_EsupportDDLHomePage.Email1()).sendKeys(Username);

				System.out.println("Entered Email(Username) as "+Username);

//				CommonUtility.ScrollTo(driver, obj_EsupportDDLHomePage.ContinueButton());
//				CommonUtility.ToClickByUsingJavaScript_PassingByLoc(driver, obj_EsupportDDLHomePage.ContinueButton());
				
				Thread.sleep(10000);
				
				CommonUtility.ScrollTo(driver, obj_EsupportDDLHomePage.Password1());
				CommonUtility.highlightElement(driver, obj_EsupportDDLHomePage.Password1()).sendKeys(Password);

				System.out.println("Entered Password as "+Password);
				CommonUtility.highlightElement(driver, obj_EsupportDDLHomePage.SignInButton());
//				CommonUtility.highlightElement(driver, obj_EsupportDDLHomePage.SignIn()).click();
				CommonUtility.ClickOn(driver, obj_EsupportDDLHomePage.SignInButton());
				System.out.println("Clicked on SignIn Button ");
			}
			else
			{
//				CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.SearchButton());
				
				if(CommonUtility.CheckpresenceofElementLocated(driver, 20,obj_EsupportDDLHomePage.Email()))
				{
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.Email()));

				CommonUtility.ScrollTo(driver, obj_EsupportDDLHomePage.Email());
				CommonUtility.highlightElement(driver, obj_EsupportDDLHomePage.Email()).sendKeys(Username);

				System.out.println("Entered Email(Username) as "+Username);

				CommonUtility.ScrollTo(driver, obj_EsupportDDLHomePage.Password());
				CommonUtility.highlightElement(driver, obj_EsupportDDLHomePage.Password()).sendKeys(Password);

				System.out.println("Entered Password as "+Password);
				CommonUtility.highlightElement(driver, obj_EsupportDDLHomePage.SignIn());
				//				CommonUtility.highlightElement(driver, obj_EsupportDDLHomePage.SignIn()).click();
				CommonUtility.ClickOn(driver, obj_EsupportDDLHomePage.SignIn());
				System.out.println("Clicked on SignIn Button ");
				}
			}
			Thread.sleep(10000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.ServiceTagValidationOnProductSupportPage()));

			CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.ServiceTagValidationOnProductSupportPage());
			tag=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ServiceTagValidationOnProductSupportPage()).getText();
			System.out.println("tag displayed is "+tag);

			if(tag.contains(Product))
			{
				System.out.println("pass: searched tag product home page displayed");
			}
			else
			{
				System.out.println("searched tag product home page not displayed");
				Report.put("On the Homepage select the required product by:Entering a product code "+Report.color(Product)+" and click on the arrow button", 
						"User should be directed to the product support page of the selected Product/tag "+Report.color(Product)+" and land on "+Report.color(overview)+" Tab  by default",
						"Not landed EMC support page", "FAIL"); 

				Assert.fail();
			}

			Thread.sleep(10000);

			CommonUtility.ScrollTo(driver,obj_EsupportContentHomePage.DefaultDisplayedTabInProductHomePage());
			overview=CommonUtility.highlightElement(driver,obj_EsupportContentHomePage.DefaultDisplayedTabInProductHomePage()).getText();
			System.out.println("displayed tab is "+overview);

			Report.put("On the Homepage select the required product by:Entering a product code and click "+Report.color(Product)+" on the arrow button", 
					"User should be directed to the product support page of the selected Product/tag "+Report.color(Product)+" and land on "+Report.color(overview)+" Tab  by default",
					"Successfully landed on "+Report.color(overview)+" Tab", "PASS");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("On the Homepage select the required product by:Entering a product code "+Report.color(Product)+" and click on the arrow button", 
					"User should be directed to the product support page of the selected Product/tag "+Report.color(Product)+" and land on "+Report.color(overview)+" Tab  by default",
					"Not landed on Overview Tab", "FAIL");
			Assert.fail();
		}
	}	


	public void DellSRSearchFromMastHead(WebDriver driver,String Product,String Email) 
	{
		Log.info("Entering method DellSRSearchFromMastHead");
		WebDriverWait  wait = new WebDriverWait(driver, 120);
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		String overview="";
		String tag="";
		String sr="";
		String DropDown="";
		String SRdetails="";
		String heading="";
		String popup="";

		try
		{
			handleCookies(driver);
			//			WebDriverWait wait = new WebDriverWait(driver, 200);

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.mastHead()));
			CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.mastHead());
			CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.mastHead());
			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.mastHead()).clear();
			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.mastHead()).sendKeys(Product);
			CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.SearchButtonMastHead());
			CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.SearchButtonMastHead());

			if(CommonUtility.CheckpresenceofElementLocated(driver,10,obj_EsupportCoveoPage.ServiceRequestsHeading()))
			{
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.ServiceRequestsHeading()));

				CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.ServiceRequestsHeading());
				tag=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ServiceRequestsHeading()).getText();
				System.out.println("heading displayed is "+tag);



				Thread.sleep(10000);

				CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.SearchHeading());
				overview=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SearchHeading()).getText();
				System.out.println("description above search text box is "+overview);

				CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SearchBoxInServiceRequestPage());
				//			sr=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SearchBoxInServiceRequestPage()).getText();
				//			System.out.println("SR displayed in search box is "+sr);
				//			
				//			if(sr.contains(Product))
				//			{
				//				System.out.println("pass: SR displayed matching with entered");
				//			}
				//			else
				//			{
				//				System.out.println("SR displayed not matching with");
				//				Report.put("Enter valid Dell SR number in the masthead and click search button.", 
				//						"It should load or redirected to SRO landing page as no User hasn't Logged-In or the logged-in user is not authorised to view details of the SR# entered. if not unthenticated or details page is authenticated and validated user",
				//						"Not landed on SR page", "FAIL"); 
				//				
				//				Assert.fail();
				//			}

				WebElement ele=driver.findElement(obj_EsupportCoveoPage.DefaultSelectedDropDownValue());
				Select s1=new Select(ele);

				List<WebElement> ddvalues=s1.getOptions();

				for(WebElement lt:ddvalues)
				{
					CommonUtility.highlightElement(driver, lt);
					String langLi=lt.getText();

					System.out.println("Language is: " +langLi);
					DropDown+= langLi +"<br>";
				}
				System.out.println("list is : "+DropDown);
				s1.getFirstSelectedOption();

				Thread.sleep(6000);
				Thread.sleep(6000);
				CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.SearchButtonInServiceRequestPage());


				CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.PopUpHeadingInServiceRequest());
				popup=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.PopUpHeadingInServiceRequest()).getText();
				System.out.println("pop up heading is "+popup);
				CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.TextBoxInServiceRequestPopUp());
				CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.TextBoxInServiceRequestPopUp());
				CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.TextBoxInServiceRequestPopUp()).clear();
				CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.TextBoxInServiceRequestPopUp()).sendKeys(Email);
				CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.SubmitButtonInServiceRequestPopUp());
				CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.SubmitButtonInServiceRequestPopUp());

			}
			else
			{
				CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.SearchButton2());
				CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.SearchButton2());


				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.ServiceRequestsHeading()));

				CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.ServiceRequestsHeading());
				tag=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ServiceRequestsHeading()).getText();
				System.out.println("heading displayed is "+tag);



				Thread.sleep(10000);

				CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.SearchHeading());
				overview=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SearchHeading()).getText();
				System.out.println("description above search text box is "+overview);

				CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SearchBoxInServiceRequestPage());
				//				sr=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SearchBoxInServiceRequestPage()).getText();
				//				System.out.println("SR displayed in search box is "+sr);
				//				
				//				if(sr.contains(Product))
				//				{
				//					System.out.println("pass: SR displayed matching with entered");
				//				}
				//				else
				//				{
				//					System.out.println("SR displayed not matching with");
				//					Report.put("Enter valid Dell SR number in the masthead and click search button.", 
				//							"It should load or redirected to SRO landing page as no User hasn't Logged-In or the logged-in user is not authorised to view details of the SR# entered. if not unthenticated or details page is authenticated and validated user",
				//							"Not landed on SR page", "FAIL"); 
				//					
				//					Assert.fail();
				//				}

				WebElement ele=driver.findElement(obj_EsupportCoveoPage.DefaultSelectedDropDownValue());
				Select s1=new Select(ele);

				List<WebElement> ddvalues=s1.getOptions();

				for(WebElement lt:ddvalues)
				{
					CommonUtility.highlightElement(driver, lt);
					String langLi=lt.getText();

					System.out.println("Language is: " +langLi);
					DropDown+= langLi +"<br>";
				}
				System.out.println("list is : "+DropDown);
				s1.getFirstSelectedOption();


				CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.SearchButtonInServiceRequestPage());


				CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.PopUpHeadingInServiceRequest());
				popup=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.PopUpHeadingInServiceRequest()).getText();
				System.out.println("pop up heading is "+popup);

				CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.TextBoxInServiceRequestPopUp());
				CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.TextBoxInServiceRequestPopUp()).clear();
				CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.TextBoxInServiceRequestPopUp()).sendKeys(Email);

				CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.SubmitButtonInServiceRequestPopUp());
			}

			if(CommonUtility.CheckpresenceofElementLocated(driver,10,obj_EsupportCoveoPage.ServiceRequestsDetailsPageHeading()))
			{
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.ServiceRequestsDetailsPageHeading()));
				CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ServiceRequestsDetailsPageHeading());

				if(CommonUtility.CheckpresenceofElementLocated(driver,10,obj_EsupportCoveoPage.SRDetailsInSRDetailsPage()))

				{
					List<WebElement> list=driver.findElements(obj_EsupportCoveoPage.SRDetailsInSRDetailsPage());

					for(WebElement lt:list)
					{
						CommonUtility.highlightElement(driver, lt);
						String text=lt.getText();

						System.out.println("details are is: " +text);
						SRdetails+= text +"<br>";
					}

					System.out.println("sr details are "+SRdetails);
				}
				else
					if(CommonUtility.CheckpresenceofElementLocated(driver,10,obj_EsupportCoveoPage.SRNumberForDell()))

					{
						CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SRNumberForDell());
						SRdetails=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SRNumberForDell()).getText();
						System.out.println("sr details are "+SRdetails);
					}
			}
			else
			{
				CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.SubmitButtonInServiceRequestPopUp());
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.ServiceRequestsDetailsPageHeading()));
				CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ServiceRequestsDetailsPageHeading());

				if(CommonUtility.CheckpresenceofElementLocated(driver,10,obj_EsupportCoveoPage.SRDetailsInSRDetailsPage()))

				{
					List<WebElement> list=driver.findElements(obj_EsupportCoveoPage.SRDetailsInSRDetailsPage());

					for(WebElement lt:list)
					{
						CommonUtility.highlightElement(driver, lt);
						String text=lt.getText();

						System.out.println("details are is: " +text);
						SRdetails+= text +"<br>";
					}

					System.out.println("sr details are "+SRdetails);
				}
				else
					if(CommonUtility.CheckpresenceofElementLocated(driver,10,obj_EsupportCoveoPage.SRNumberForDell()))

					{
						CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SRNumberForDell());
						SRdetails=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SRNumberForDell()).getText();
						System.out.println("sr details are "+SRdetails);
					}
			}

			Report.put("Enter valid Dell SR number in the masthead and click search button.", 
					"It should load or redirected to SRO landing page as no User hasn't Logged-In or the logged-in user is not authorised to view details of the SR# entered. if not unthenticated or details page is authenticated and validated user",
					"Successfully able to search Dell SR "+Report.color(Product)+" and landed on "+Report.color(tag)+" and able to click on Search button and enter "+Report.color(Email)+" And display SR details as "+Report.color(SRdetails), "PASS");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Enter valid Dell SR number in the masthead and click search button.", 
					"It should load or redirected to SRO landing page as no User hasn't Logged-In or the logged-in user is not authorised to view details of the SR# entered. if not unthenticated or details page is authenticated and validated user",
					"Not landed on service requests page", "FAIL");
			Assert.fail();
		}
	}	

	public void ValidateSearchingEMCSRnumber(WebDriver driver,String Product,String Username, String Password) 
	{
		Log.info("Entering method ValidateSearchingEMCSRnumber");
		WebDriverWait  wait = new WebDriverWait(driver, 200);
//		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String overview="";
		String tag="";

		try
		{
			handleCookies(driver);
			//			WebDriverWait wait = new WebDriverWait(driver, 200);

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.mastHead()));

			CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.mastHead());
			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.mastHead()).clear();
			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.mastHead()).sendKeys(Product);
			CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.SearchButtonMastHead());
			CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.SearchButtonMastHead());
			
//			Thread.sleep(6000);
//			driver.navigate().refresh();
			Thread.sleep(10000);

			CommonUtility.ScrollTo(driver, obj_EsupportDDLHomePage.Email());
			if(CommonUtility.CheckpresenceofElementLocated(driver,20, obj_EsupportDDLHomePage.Email()))
			{
//				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportDDLHomePage.Email()));

				CommonUtility.ScrollTo(driver, obj_EsupportDDLHomePage.Email());
				CommonUtility.highlightElement(driver, obj_EsupportDDLHomePage.Email()).sendKeys(Username);

				System.out.println("Entered Email(Username) as "+Username);

				CommonUtility.ScrollTo(driver, obj_EsupportDDLHomePage.Password());
				CommonUtility.highlightElement(driver, obj_EsupportDDLHomePage.Password()).sendKeys(Password);

				System.out.println("Entered Password as "+Password);
				CommonUtility.highlightElement(driver, obj_EsupportDDLHomePage.SignIn());
				//			CommonUtility.highlightElement(driver, obj_EsupportDDLHomePage.SignIn()).click();
				CommonUtility.ClickOn(driver, obj_EsupportDDLHomePage.SignIn());
				System.out.println("Clicked on SignIn Button ");
			}
			Thread.sleep(6000);
			
			Thread.sleep(6000);
			CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.EMCSRLandingPage());
			if(CommonUtility.CheckpresenceofElementLocated(driver,40,obj_EsupportCoveoPage.EMCSRLandingPage()))
			{
//				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.EMCSRLandingPage()));

				CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.EMCSRLandingPage());
				tag=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.EMCSRLandingPage()).getText();
				System.out.println("tag displayed is "+tag);

				if(tag.contains(Product))
				{
					System.out.println("pass: SR displayed matching with entered");
				}
				else
				{
					System.out.println("SR displayed not matching with entered");
					Report.put("Enter valid EMC SR number  in the masthead and click search button.", 
							"It should load or redirected to SRO details page as the Logged-In User is Authorised or Validated User to view details of the SR# entered.",
							"Not landed on EMC SR page", "FAIL"); 

					Assert.fail();
				}
			}
			else
			{
//				CommonUtility.ClickOn(driver, obj_EsupportDDLHomePage.SignIn());
//				System.out.println("Clicked on SignIn Button again");
				
//				Thread.sleep(6000);
//				driver.navigate().refresh();
				Thread.sleep(10000);
				Thread.sleep(10000);
				wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.EMCSRLandingPage()));

				CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.EMCSRLandingPage());
				tag=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.EMCSRLandingPage()).getText();
				System.out.println("tag displayed is "+tag);

				if(tag.contains(Product))
				{
					System.out.println("pass: SR displayed matching with entered");
				}
				else
				{
					System.out.println("SR displayed not matching with entered");
					Report.put("Enter valid EMC SR number  in the masthead and click search button.", 
							"It should load or redirected to SRO details page as the Logged-In User is Authorised or Validated User to view details of the SR# entered.",
							"Not landed on EMC SR page", "FAIL"); 

					Assert.fail();
				}
			}

			Report.put("Enter valid EMC SR number  in the masthead and click search button.", 
					"It should load or redirected to SRO details page as the Logged-In User is Authorised or Validated User to view details of the SR# entered.",
					"Successfully use able to search "+Report.color(Product)+" and able to use login credentisla "+Report.color(Username+" and "+Password)+" and able to see SR details "+Report.color(tag), "PASS");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Enter valid EMC SR number  in the masthead and click search button.", 
					"It should load or redirected to SRO details page as the Logged-In User is Authorised or Validated User to view details of the SR# entered.",
					"Not landed SR details page", "FAIL");
			Assert.fail();
		}
	}	
	
	
	public void ProductCategorySectionValidation(WebDriver driver)
	{


		Log.info("Verifying ProductCategorySectionValidation");
		String optio="";
		String optioaft="";
		String filter="";
		String filter1="";
		try{
			handleCookies(driver);
			WebDriverWait wait = new WebDriverWait(driver, 120);
//			driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS); 
			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SearchInput()).sendKeys("Inspiron audio issue");

			CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.SearchButton2());
			CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.SearchButton2());
			
			Thread.sleep(6000);
			driver.navigate().refresh();
			Thread.sleep(10000);

			List<WebElement> resourcetypelist1=driver.findElements(obj_EsupportCoveoPage.ValidateResourceTypeIsSelected());
			int resourcetypecount1=resourcetypelist1.size();
			System.out.println("total number of resources displayed are "+resourcetypecount1);

			for(int i=0; i<resourcetypecount1;i++)
			{
				CommonUtility.ScrollToWebElement(driver, resourcetypelist1.get(i));
				filter1+=resourcetypelist1.get(i).getText();
				
			}
			System.out.println(filter1);
			CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.ProductCategory());
			wait = new WebDriverWait(driver, 120);

			handleCookies(driver);
			if(CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ProductCategory()).isDisplayed())
			{
				CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.ProductCategorySearchBoxInCoveoPage());
				CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.OptionsDisplayedUnderProductCategoryInCoveoPage());
				
				List<WebElement> opt=driver.findElements(obj_EsupportCoveoPage.OptionsDisplayedUnderProductCategoryInCoveoPage());

				for(WebElement lt:opt)
				{
					CommonUtility.highlightElement(driver, lt);
					String langLi=lt.getText();

					System.out.println("options displaed are " +langLi);
					optio+= langLi +"<br>";
				}
				System.out.println("options displayed default are : "+optio);
			}
			Thread.sleep(5000);
			
			
			if(CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.DownloadDriversClick()).isDisplayed())
			{
				CommonUtility.ScrollTo(driver, obj_EsupportCoveoPage.DownloadDriversClick());
				CommonUtility.ClickOn(driver, obj_EsupportCoveoPage.DownloadDriversClick());
				Thread.sleep(7000);
			}
			
			CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.ClearFilters());
			CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.ClearFilters());
			
			
			Report.put("Scenario 1: Keyword Search Search for the keyword 'Inspiron audio issue'", 
					" It should display Resources Facet & Product Facet. No default selection should take place based on the search, User should be able to select any option in Resources & Product Facet, Selection of any option in any facet should be independent of each other ", 
					"user able to see product starategy information with default displayed options as "+Report.color(optio)+" along with resource type "+Report.color(filter), "Pass");


			if(CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ProductCategorySearchBoxInCoveoPage()).isDisplayed())
			{

				CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.ProductCategorySearchBoxInCoveoPage());
				CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.ProductCategorySearchBoxInCoveoPage());
				CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ProductCategorySearchBoxInCoveoPage()).sendKeys("Laptops");;
			}
			Thread.sleep(6000);
			if(CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.LaptopsHeadingUnderProductCategoryInCoveoPage()).isDisplayed())
			{
				CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.LaptopsHeadingUnderProductCategoryInCoveoPage());
				String lap=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.LaptopsHeadingUnderProductCategoryInCoveoPage()).getText();
				System.out.println(lap);
				CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.LaptopsHeadingUnderProductCategoryInCoveoPage());
			
			Thread.sleep(10000);
			Report.put("Scenario 2: Single Product Category selection Select Laptops in Product Category facet. ", 
					" It should show all available Laptop models only, The results should be pertaining to only Laptops", 
					"user able to search laptops and able to see option displayed "+Report.color(lap), "Pass");
			}
			
			if(CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ClickOnDellSupportVideosResourceType()).isDisplayed())
			{
				CommonUtility.ScrollTo(driver, obj_EsupportCoveoPage.ClickOnDellSupportVideosResourceType());
				CommonUtility.ClickOn(driver, obj_EsupportCoveoPage.ClickOnDellSupportVideosResourceType());
				Thread.sleep(7000);
				
				Report.put("Select Videos option from Resources Facet  ", 
						"It should refresh the result set as per the selection made from Resources Facet.", 
						"user able to click on videos", "Pass");
			}
			else
			{
				System.out.println("videos not displayed");
			}
			try
			{
			if(CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.InspironClickUnderProductCategoryInCoveoPage()).isDisplayed())
			{
				CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.InspironClickUnderProductCategoryInCoveoPage());
				String ins=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.InspironClickUnderProductCategoryInCoveoPage()).getText();
				System.out.println(ins);
				CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.InspironClickUnderProductCategoryInCoveoPage());
			
				List<WebElement> resourcetypelist=driver.findElements(obj_EsupportCoveoPage.ValidateResourceTypeIsSelected());
				int resourcetypecount=resourcetypelist.size();
				System.out.println("total number of resources displayed are "+resourcetypecount);

				for(int i=0; i<resourcetypecount;i++)
				{
					CommonUtility.ScrollToWebElement(driver, resourcetypelist.get(i));
					filter+=resourcetypelist.get(i).getText();
					
				}
				System.out.println(filter);

			Thread.sleep(10000);
			Report.put("Scenario 3: Single product family selection Select Inspiron from Laptops ", 
					"It should display all the models / series belonging to Inspiron.  Result set should get refreshed accordingly.", 
					"user able to find Inspiron and able to see option displayed "+Report.color(ins), "Pass");
			
			Report.put("Observe Resource Facet ", 
					"The options will appear / disappear as per the results available in the product category.", 
					"user able to see resource tpe change accordingly "+Report.color(filter), "Pass");
			}
			}
			catch(Exception e)
			{
				
			}
			
			if(CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.Click3000SeriesUnderProductCategoryInCoveoPage()).isDisplayed())
			{
				CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.Click3000SeriesUnderProductCategoryInCoveoPage());
				
				String ser=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.Click3000SeriesUnderProductCategoryInCoveoPage()).getText();
				System.out.println(ser);
				CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.Click3000SeriesUnderProductCategoryInCoveoPage());
			
			
			Thread.sleep(10000);
			Report.put("Scenario 4: Single product series selection Select 3000 Series from the option ", 
					"It should display all products available in that series, It should refresh the result set according to the selection ", 
					"user able to find 3000 series and able to see option displayed "+Report.color(ser), "Pass");
			}
			if(CommonUtility.CheckpresenceofElementLocated(driver,10,obj_EsupportCoveoPage.Inspiron153555Click()))
			{
				CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.Inspiron153555Click());
				String inspiron=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.Inspiron153555Click()).getText();
				System.out.println(inspiron);
				CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.Inspiron153555Click());
				Report.put("Scenario 5: Search by Product Name Clear all the search criteria. Now select Videos option from Resources Facet & Search for 'Inspiron 15 3555 Videos'  ", 
						"It should display videos pertaining to the model searched for ", 
						"user able to find Inspiron 15 3555 and able to see option displayed "+Report.color(inspiron), "Pass");
				
				
			}
			else
			{
				CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.DownArrowMarkUnderProductCategoryInCoveoPage());
				CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.DownArrowMarkUnderProductCategoryInCoveoPage());
				if(CommonUtility.CheckpresenceofElementLocated(driver,10,obj_EsupportCoveoPage.Inspiron153555Click()))
				{
					CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.Inspiron153555Click());
					String inspiron=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.Inspiron153555Click()).getText();
					System.out.println(inspiron);
					CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.Inspiron153555Click());
					Report.put("Scenario 5: Search by Product Name Clear all the search criteria. Now select Videos option from Resources Facet & Search for 'Inspiron 15 3555 Videos'  ", 
							"It should display videos pertaining to the model searched for ", 
							"user able to find Inspiron 15 3555 and able to see option displayed "+Report.color(inspiron), "Pass");
					
				}
				else
				{
					CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.DownArrowMarkUnderProductCategoryInCoveoPage());
					CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.DownArrowMarkUnderProductCategoryInCoveoPage());
					if(CommonUtility.CheckpresenceofElementLocated(driver,10,obj_EsupportCoveoPage.Inspiron153555Click()))
					{
						CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.Inspiron153555Click());
						String inspiron=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.Inspiron153555Click()).getText();
						System.out.println(inspiron);
						CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.Inspiron153555Click());
						
						Report.put("Scenario 5: Search by Product Name Clear all the search criteria. Now select Videos option from Resources Facet & Search for 'Inspiron 15 3555 Videos'  ", 
								"It should display videos pertaining to the model searched for ", 
								"user able to find Inspiron 15 3555 and able to see option displayed "+Report.color(inspiron), "Pass");
					}
				}
			}
			
			
			
			List<WebElement> opt1=driver.findElements(obj_EsupportCoveoPage.OptionsDisplayedUnderProductCategoryInCoveoPage());

			for(WebElement lt:opt1)
			{
				try
				{
				CommonUtility.ScrollToWebElement(driver, lt);
				}
				catch(Exception e)
				{
					
				}
				String langLi=lt.getText();

				System.out.println("options displayed after selection " +langLi);
				optioaft+= langLi +"<br>";
			}
			System.out.println("options displayed after selection are : "+optioaft);
			
			
			Thread.sleep(10000);
			Report.put("Scenario 5: Search by Product Name Clear all the search criteria. Now select Videos option from Resources Facet & Search for 'Inspiron 15 3555 Videos'  ", 
					"It should display videos pertaining to the model searched for ", 
					"user able to find Inspiron 15 3555 and able to see option displayed "+Report.color(optioaft), "Pass");
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			Report.put("search for Laptops, ", 
					"", 
					"", "Fail");
//			Assert.fail();
		}
	} 
	
	
	public void  ValidateSearchForKeywordWithOutDoubleQuotes_Keyword(WebDriver driver, String SearchOption, String Dpid) 
	{
		Log.info("Entering ValidateSearchForKeywordWithOutDoubleQuotes_Keyword");   
		WebDriverWait wait = new WebDriverWait(driver, 300);
		String keyword1 = TestNGCreator.TestData.get(Esupport.SearchOption.ordinal());

		String enteredtext = "";
		String searchresult="";
		String filter="";

		String resourcetype1 = TestNGCreator.TestData.get(Esupport.Dpid.ordinal()).split(";")[0];
		String resourcetype2 = TestNGCreator.TestData.get(Esupport.Dpid.ordinal()).split(";")[1];
		String resourcetype3 = TestNGCreator.TestData.get(Esupport.Dpid.ordinal()).split(";")[2];
		String resourcetype4 = TestNGCreator.TestData.get(Esupport.Dpid.ordinal()).split(";")[3];
		String resourcetype5 = TestNGCreator.TestData.get(Esupport.Dpid.ordinal()).split(";")[4];
		String resourcetype6 = TestNGCreator.TestData.get(Esupport.Dpid.ordinal()).split(";")[5];
		Actions act=new Actions(driver);

		try
		{       
			System.out.println("Inside try of ValidateSearchForKeywordWithOutDoubleQuotes_Keyword");
			//			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.SearchTextbox()));
			//			CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.SearchTextbox());

			CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.SearchTextbox());
			CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.SearchTextbox());
			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SearchTextbox()).clear();
			CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SearchTextbox()).sendKeys(keyword1);
			handleCookies(driver);
			CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.SearchButton2());
			//					CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SearchButton()).click();
			//					act.moveToElement(CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.SearchButton())).click().build().perform();
			//				CommonUtility.ToClickByUsingJavaScript_PassingByLoc(driver,obj_EsupportCoveoPage.SearchButton());
			CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.SearchButton2());
			//				Thread.sleep(20000);
			Thread.sleep(10000);
//			driver.navigate().refresh();
//						Thread.sleep(10000);
//			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
//						Thread.sleep(10000);
						Thread.sleep(6000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.searchSupport()));
//			Thread.sleep(10000);
//			Thread.sleep(6000);
//			Thread.sleep(6000);
//			Thread.sleep(10000);
			Thread.sleep(10000);
			String url = driver.getCurrentUrl();
			System.out.println(url);
			if(url.contains("Facet"))
			{
				Log.info("test case pass: url contains Facet keyword");
			}
			else
			{
				Log.info("test case fail: url doesnt contains Facet keyword");
				Report.put("Scenario 1 : User searches for keyword and successfully lands on search result page Search for \"Avamar Issues\" keyword.", 
						"It should show relevant results matching the keyword.", 
						"not landed on coveo page", "FAIL");;
//						Assert.fail();
			}
			Thread.sleep(5000);
			enteredtext=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.KewordValidationInCoveoPage()).getText();
			System.out.println(enteredtext);
			enteredtext=enteredtext.toLowerCase();
			keyword1=keyword1.toLowerCase();
			System.out.println(keyword1);
			if(enteredtext.contains(keyword1))
			{
				Log.info("test case pass: keyword entered is displayed in search of coveo result");
			}
			else
			{
				Log.info("test case fail: keyword entered is not displayed in search of coveo result");
				Report.put("Scenario 1 : User searches for keyword and successfully lands on search result page Search for \"Avamar Issues\" keyword.", 
						"It should show relevant results matching the keyword.", 
						"not landed on correct coveo page for searched Keyword "+Report.color(keyword1), "FAIL");;
						Assert.fail();
			}
			
//			Thread.sleep(6000);
//			driver.navigate().refresh();
//			Thread.sleep(10000);
			Thread.sleep(6000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.GetCoveoOverAllSearchResult()));
			searchresult=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.GetCoveoOverAllSearchResult()).getText();
			System.out.println("all result is for entered keyword is "+searchresult);
//			Thread.sleep(10000);
			Thread.sleep(6000);
			List<WebElement> resourcetypelist=driver.findElements(obj_EsupportCoveoPage.ValidateResourceTypeIsSelected());
			int resourcetypecount=resourcetypelist.size();
			System.out.println("total number of resources displayed are "+resourcetypecount);

			for(int i=0; i<resourcetypecount;i++)
			{
				if(CommonUtility.highlightElement(driver,resourcetypelist.get(i)).isSelected())
				{
					Log.info("test case fail: resource types selected");
					Report.put("Scenario 1 : User searches for keyword and successfully lands on search result page Search for \"Avamar Issues\" keyword.", 
							"It should show relevant results matching the keyword.", 
							"Any of Resource Type is selected by default", "FAIL");;
							Assert.fail();
				}
			}

			String filterheader=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ValidateFiltersSectionHeader()).getText();
			System.out.println("header is "+filterheader);

			List<WebElement> getallfilters=driver.findElements(obj_EsupportCoveoPage.GetAllFilters());
			int totalfilterscount=getallfilters.size();
			System.out.println("total count of selected filters "+totalfilterscount);

			for(int j=0;j<totalfilterscount;j++)
			{
				filter+=",<br>"+getallfilters.get(j).getText();
				System.out.println("filters displayed are "+filter);

				if (filter.contains(resourcetype1) || filter.contains(resourcetype2)|| filter.contains(resourcetype3)|| filter.contains(resourcetype4)|| filter.contains(resourcetype5)|| filter.contains(resourcetype6))
				{
					Log.info("test case fail: resource types displayed under your filters section");
					Report.put("Scenario 1 : User searches for keyword and successfully lands on search result page Search for \"Avamar Issues\" keyword.", 
							"It should show relevant results matching the keyword.", 
							"Any of Resource Type "+Report.color(filter)+" is displayed by default under heading "+Report.color(filterheader), "FAIL");;
							Assert.fail();
				}

			}

			Report.put("Scenario 1 : User searches for keyword and successfully lands on search result page Search for \"Avamar Issues\" keyword.", 
					"It should show relevant results matching the keyword.", 
					"keyword "+Report.color(keyword1)+" searched Successfully.<br> and all relevant results displayed with result count of "+Report.color(searchresult)+"<br> and filters displayed under "+Report.color(filterheader)+" are <br> "+Report.color(filter), "PASS");

			Thread.sleep(3000);                     
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Scenario 1 : User searches for keyword and successfully lands on search result page Search for \"Avamar Issues\" keyword.", 
					"It should show relevant results matching the keyword.", 
					"coveo search results display with default selected any of resource type or not landed on searched keyword coveo search result page", "FAIL");;
					Assert.fail();
		}
	}

	
	public void  ClickOnMoreAndValidateDetails(WebDriver driver) 
	{
		Log.info("Entering ClickOnMoreAndValidateDetails");   
		WebDriverWait wait = new WebDriverWait(driver, 150);
		
		String releasedate = "";String status="";String articletype="";String articleid="";String productsname="";
		Actions act=new Actions(driver);

		try
		{       
			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_EsupportCoveoPage.Morelink()))
			{

			CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.Morelink());
			String more=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.Morelink()).getText();
			System.out.println("link is "+more);
			CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.Morelink());
			
			wait.until(ExpectedConditions.presenceOfElementLocated(obj_EsupportCoveoPage.LastUpdatedDate()));
			CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.LastUpdatedDate());
			releasedate=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.LastUpdatedDate()).getText();
			System.out.println("release date is "+releasedate);
			
			
			wait.until(ExpectedConditions.presenceOfElementLocated(obj_EsupportCoveoPage.ArticleIDDetails()));
			CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.ArticleIDDetails());
			articleid=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ArticleIDDetails()).getText();
			System.out.println("article id is "+articleid);
			
			
			wait.until(ExpectedConditions.presenceOfElementLocated(obj_EsupportCoveoPage.StatusDetails()));
			CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.StatusDetails());
			status=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.StatusDetails()).getText();
			System.out.println("status is "+status);
			
			wait.until(ExpectedConditions.presenceOfElementLocated(obj_EsupportCoveoPage.ArticleTypeDetails()));
			CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.ArticleTypeDetails());
			articletype=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ArticleTypeDetails()).getText();
			System.out.println("article type is "+articletype);
			
			wait.until(ExpectedConditions.presenceOfElementLocated(obj_EsupportCoveoPage.ProductsDetails()));
			CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.ProductsDetails());
			productsname=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ProductsDetails()).getText();
			System.out.println("product is "+productsname);
//			String releasedate = "";String status="";String articletype="";String articleid="";String productsname="";
			Report.put("Observe the Meta Data of the each article by clicking on MORE link", 
					"It should display the below data  a. Release Date   b. Status ( if available for dell articles)  c. Article Type ( if available for dell articles) d. Article Id ( new salesforce id ) e. Products article tag", 
					"Clicking on "+Report.color(more)+ " link able to see <br> a. Release Date "+Report.color(releasedate)+" <br> b. Status "
							+Report.color(status)+ "<br> c. Article type "+Report.color(articletype)+" <br> d. Article id "+Report.color(articleid)+" <br> e. first product name "+Report.color(productsname), "PASS");

			Thread.sleep(3000);         
			}
			else
			{
				System.out.println("more link not displayed");
				Report.put("Observe the Meta Data of the each article by clicking on MORE link", 
						"It should display the below data  a. Release Date   b. Status ( if available for dell articles)  c. Article Type ( if available for dell articles) d. Article Id ( new salesforce id ) e. Products article tag",
						"more link not displayed", "FAIL");;
						Assert.fail();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Observe the Meta Data of the each article by clicking on MORE link", 
					"It should display the below data  a. Release Date   b. Status ( if available for dell articles)  c. Article Type ( if available for dell articles) d. Article Id ( new salesforce id ) e. Products article tag",
					"Failed to see expected details", "FAIL");;
					Assert.fail();
		}
	}
	
	public void  SelectKnowledgebaseResouce_ValidateArticleTypeStatusOtherDetails(WebDriver driver, String Dpid) 
	{
		Log.info("Entering SelectKnowledgebaseResouce_ValidateArticleTypeStatusOtherDetails");   
		WebDriverWait wait = new WebDriverWait(driver, 120);

		String enteredtext = "";
		String searchresult="";
		String filter="";
		String result="";
		String attr="";
		String title="";
		String currenturl="";
		String resourcetype2 = TestNGCreator.TestData.get(Esupport.Dpid.ordinal()).split(";")[1];
		Actions act= new Actions(driver);
		String detailsofprobcode="";String status="";String detailsofstatus="";String articletype="";String problemcode="";
		String productcate="";String language="";String lastupdated="";
		String testcase = TestNGCreator.TestData.get(Esupport.TestCaseID.ordinal());
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try
		{       
			if(testcase.equals("9543621"))
			{
				if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_EsupportCoveoPage.KnowledgeBaseClick()))
				{
					try
		            {
						CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.XbuttonOnSignInBanner());
					CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.XbuttonOnSignInBanner());
					Thread.sleep(6000);
					CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.numberofResult());
					
					Thread.sleep(3000);
					CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.KnowledgeBaseClick());
					Thread.sleep(3000);
					js.executeScript("window.scrollBy(0,250)", "");
					Thread.sleep(2000);
					CommonUtility.ClickOn(driver, obj_EsupportCoveoPage.KnowledgeBaseClick());

		            }
		             catch(JavascriptException e) 
		            {
		                   e.printStackTrace();
		            }
				
				//wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.GetCoveoOverAllSearchResult()));
				driver.manage().timeouts().implicitlyWait(600, TimeUnit.SECONDS);
				
				CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.GetCoveoOverAllSearchResult());

				searchresult=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.GetCoveoOverAllSearchResult()).getText();
				System.out.println("all result is for entered keyword and selected resource type is "+searchresult);

				Thread.sleep(10000);

				String filterheader=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ValidateFiltersSectionHeader()).getText();
				System.out.println("header is "+filterheader);
				Thread.sleep(6000);
				List<WebElement> getallfilters=driver.findElements(obj_EsupportCoveoPage.GetAllFilters());
				int totalfilterscount=getallfilters.size();
				System.out.println("total count of selected filters "+totalfilterscount);

				for(int j=0;j<totalfilterscount;j++)
				{
					filter+=",<br>"+getallfilters.get(j).getText();
					System.out.println("filters displayed are "+filter);

					if (filter.contains(resourcetype2))
					{
						Log.info("test case pass: resource types knowledgebase displayed under your filter section");
					}
					else
					{
						Log.info("test case fail: resource types knowledge base not displayed under your filter section");
						
						Report.put("Select the resource type 'knowledge base'", 
								"User should be able to see the following facets Language, status ( if applicable) , Problem code( if applicable), Article type( if applicable)  Last updated as facets on page load Product category facet will be displayed similar to  STORY 8141057 (single facet )& product version if applicable ", 
								"for Resource Type "+Report.color(filter)+" is not displayed by under heading "+Report.color(filterheader), "FAIL");;
								Assert.fail();
					}

				}

				
				wait.until(ExpectedConditions.presenceOfElementLocated(obj_EsupportCoveoPage.ProductCategorySelector()));
				CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.ProductCategorySelector());

				CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.ProductCategorySelectorHeader());
				productcate=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ProductCategorySelectorHeader()).getText();
				System.out.println("header is "+productcate);
				
				
				wait.until(ExpectedConditions.presenceOfElementLocated(obj_EsupportCoveoPage.LanguageSection()));
				CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.LanguageSection());

				CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.LanguageHeader());
				language=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.LanguageHeader()).getText();
				System.out.println("header is "+language);
				
				wait.until(ExpectedConditions.presenceOfElementLocated(obj_EsupportCoveoPage.LastUpdatedSection()));
				CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.LastUpdatedSection());

				CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.LastUpdatedHeader());
				lastupdated=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.LastUpdatedHeader()).getText();
				System.out.println("header is "+lastupdated);
				
				if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_EsupportCoveoPage.StatusSection()))
				{
				wait.until(ExpectedConditions.presenceOfElementLocated(obj_EsupportCoveoPage.StatusSection()));
				CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.StatusSection());

				CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.StatusSectionHeader());
				status=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.StatusSectionHeader()).getText();
				System.out.println("status is "+status);
				
				CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.StatusDisplayedInStatusSection());
				detailsofstatus=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.StatusDisplayedInStatusSection()).getText();
				System.out.println("details of status is "+detailsofstatus);
				}
				else
				{
					System.out.println("status section not displayed");
					Report.put("Select the resource type 'knowledge base'", 
							"User should be able to see the following facets Language, status ( if applicable) , Problem code( if applicable), Article type( if applicable)  Last updated as facets on page load Product category facet will be displayed similar to  STORY 8141057 (single facet )& product version if applicable ", 
							"Status section not displayed", "Pass");
					
				}
				if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_EsupportCoveoPage.ArticleTypeSection()))
				{
				wait.until(ExpectedConditions.presenceOfElementLocated(obj_EsupportCoveoPage.ArticleTypeSection()));

				CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.ArticleTypeSection());

				CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.ArticleTypeHeader());
				articletype=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ArticleTypeHeader()).getText();
				System.out.println("article type is "+articletype);
				
				List<WebElement> knowledgebaseiconlist=driver.findElements(obj_EsupportCoveoPage.ArticleTypesDisplayed());
				int knowledgebaseiconcount=knowledgebaseiconlist.size();
				System.out.println("total number of article types displayed are "+knowledgebaseiconcount);

				for(int k=0; k<knowledgebaseiconcount;k++)
				{
					CommonUtility.ScrollToWebElement(driver,knowledgebaseiconlist.get(k));
					attr+="<br>"+knowledgebaseiconlist.get(k).getText();
					
					
				}
				System.out.println("article types displayed are "+attr);
				}
				else
				{
					System.out.println("article type section not displayed");
					Report.put("Select the resource type 'knowledge base'", 
							"User should be able to see the following facets Language, status ( if applicable) , Problem code( if applicable), Article type( if applicable)  Last updated as facets on page load Product category facet will be displayed similar to  STORY 8141057 (single facet )& product version if applicable ", 
							"article type section not displayed", "Pass");
					
				}
				if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_EsupportCoveoPage.ProblemCodeSection()))
				{
				wait.until(ExpectedConditions.presenceOfElementLocated(obj_EsupportCoveoPage.ProblemCodeSection()));

				CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.ProblemCodeSection());

				CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.ProblemCodeHeader());
				problemcode=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ProblemCodeHeader()).getText();
				System.out.println("problem code is "+problemcode);
				
				List<WebElement> list=driver.findElements(obj_EsupportCoveoPage.ProblemCodeDetails());
				int listcount=list.size();
				System.out.println("total number of problem codes displayed are "+listcount);

				for(int i=0; i<listcount;i++)
				{
					CommonUtility.ScrollToWebElement(driver,list.get(i));
					String details=list.get(i).getText();
					System.out.println(details);
					detailsofprobcode+="<br>"+details;
				}
				System.out.println("Problem codes displayed are "+detailsofprobcode);
				}
				else
				{
					System.out.println("Problem code section not displayed");
					Report.put("Select the resource type 'knowledge base'", 
							"User should be able to see the following facets Language, status ( if applicable) , Problem code( if applicable), Article type( if applicable)  Last updated as facets on page load Product category facet will be displayed similar to  STORY 8141057 (single facet )& product version if applicable ", 
							"Problem code section not displayed", "Pass");
					
				}

				Report.put("Select the resource type 'knowledge base'", 
						"User should be able to see the following facets Language, status ( if applicable) , Problem code( if applicable), Article type( if applicable)  Last updated as facets on page load Product category facet will be displayed similar to  STORY 8141057 (single facet )& product version if applicable ", 
						"User able to click on knowledge base and able to see "+Report.color(productcate)+"<br>"+Report.color(language)+"<br>"+Report.color(lastupdated)+"<br>"+Report.color(status+" section along with details"+detailsofstatus)+" <br> "+Report.color(articletype+" section along with details "+attr)+" <br> "+Report.color(problemcode+" section with details "+Report.color(detailsofprobcode)), "PASS");

				}
				else
				{
					System.out.println("not able to see knowledge base resource type");
					Report.put("Select the resource type 'knowledge base'", 
							"User should be able to see the following facets Language, status ( if applicable) , Problem code( if applicable), Article type( if applicable)  Last updated as facets on page load Product category facet will be displayed similar to  STORY 8141057 (single facet )& product version if applicable ", 
							"failed to see knowledge base resource type", "FAIL");
					Assert.fail();
				}
			}
			
			else
			{
			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_EsupportCoveoPage.KnowledgeBaseClick()))
			{
				try
	            {
					CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.XbuttonOnSignInBanner());
					CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.XbuttonOnSignInBanner());
					CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.numberofResult());
					
				CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.KnowledgeBaseClick());
				CommonUtility.ClickOn(driver, obj_EsupportCoveoPage.KnowledgeBaseClick());

	            }
	             catch(JavascriptException e) 
	            {
	                   e.printStackTrace();
	            }
			
			//wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportCoveoPage.GetCoveoOverAllSearchResult()));
			driver.manage().timeouts().implicitlyWait(600, TimeUnit.SECONDS);
			
			CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.GetCoveoOverAllSearchResult());

			searchresult=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.GetCoveoOverAllSearchResult()).getText();
			System.out.println("all result is for entered keyword and selected resource type is "+searchresult);

			Thread.sleep(10000);

			String filterheader=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ValidateFiltersSectionHeader()).getText();
			System.out.println("header is "+filterheader);
			Thread.sleep(6000);
			List<WebElement> getallfilters=driver.findElements(obj_EsupportCoveoPage.GetAllFilters());
			int totalfilterscount=getallfilters.size();
			System.out.println("total count of selected filters "+totalfilterscount);

			for(int j=0;j<totalfilterscount;j++)
			{
				filter+=",<br>"+getallfilters.get(j).getText();
				System.out.println("filters displayed are "+filter);

				if (filter.contains(resourcetype2))
				{
					Log.info("test case pass: resource types knowledgebase displayed under your filter section");
				}
				else
				{
					Log.info("test case fail: resource types knowledge base not displayed under your filter section");
					
					Report.put("Select the resource type 'knowledge base'", 
							"User should see article type ( if applicable) Break Fix, Security Advisory,Technical Advisory, HowTo,Security kb: Runbook,Solution,Policy & Procedure and Emc Problem codes remains same ( if applicable)",
							"for Resource Type "+Report.color(filter)+" is not displayed by under heading "+Report.color(filterheader), "FAIL");;
							Assert.fail();
				}

			}
			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_EsupportCoveoPage.StatusSection()))
			{
			wait.until(ExpectedConditions.presenceOfElementLocated(obj_EsupportCoveoPage.StatusSection()));
			CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.StatusSection());

			CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.StatusSectionHeader());
			status=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.StatusSectionHeader()).getText();
			System.out.println("status is "+status);
			
			CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.StatusDisplayedInStatusSection());
			detailsofstatus=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.StatusDisplayedInStatusSection()).getText();
			System.out.println("details of status is "+detailsofstatus);
			}
			else
			{
				System.out.println("status section not displayed");
				Report.put("Select the resource type 'knowledge base'", 
						"User should see article type ( if applicable) Break Fix, Security Advisory,Technical Advisory, HowTo,Security kb: Runbook,Solution,Policy & Procedure and Emc Problem codes remains same ( if applicable)", 
						"Status section not displayed", "Pass");
				
			}
			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_EsupportCoveoPage.ArticleTypeSection()))
			{
			wait.until(ExpectedConditions.presenceOfElementLocated(obj_EsupportCoveoPage.ArticleTypeSection()));

			CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.ArticleTypeSection());

			CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.ArticleTypeHeader());
			articletype=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ArticleTypeHeader()).getText();
			System.out.println("article type is "+articletype);
			
			List<WebElement> knowledgebaseiconlist=driver.findElements(obj_EsupportCoveoPage.ArticleTypesDisplayed());
			int knowledgebaseiconcount=knowledgebaseiconlist.size();
			System.out.println("total number of article types displayed are "+knowledgebaseiconcount);

			for(int k=0; k<knowledgebaseiconcount;k++)
			{
				CommonUtility.ScrollToWebElement(driver,knowledgebaseiconlist.get(k));
				attr+="<br>"+knowledgebaseiconlist.get(k).getText();
				
				
			}
			System.out.println("article types displayed are "+attr);
			}
			else
			{
				System.out.println("article type section not displayed");
				Report.put("Select the resource type 'knowledge base'", 
						"User should see article type ( if applicable) Break Fix, Security Advisory,Technical Advisory, HowTo,Security kb: Runbook,Solution,Policy & Procedure and Emc Problem codes remains same ( if applicable)", 
						"article type section not displayed", "Pass");
				
			}
			if(CommonUtility.CheckpresenceofElementLocated(driver,15,obj_EsupportCoveoPage.ProblemCodeSection()))
			{
			wait.until(ExpectedConditions.presenceOfElementLocated(obj_EsupportCoveoPage.ProblemCodeSection()));

			CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.ProblemCodeSection());

			CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.ProblemCodeHeader());
			problemcode=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.ProblemCodeHeader()).getText();
			System.out.println("problem code is "+problemcode);
			
			List<WebElement> list=driver.findElements(obj_EsupportCoveoPage.ProblemCodeDetails());
			int listcount=list.size();
			System.out.println("total number of problem codes displayed are "+listcount);

			for(int i=0; i<listcount;i++)
			{
				CommonUtility.ScrollToWebElement(driver,list.get(i));
				String details=list.get(i).getText();
				System.out.println(details);
				detailsofprobcode+="<br>"+details;
			}
			System.out.println("Problem codes displayed are "+detailsofprobcode);
			}
			else
			{
				System.out.println("Problem code section not displayed");
				Report.put("Select the resource type 'knowledge base'", 
						"User should see article type ( if applicable) Break Fix, Security Advisory,Technical Advisory, HowTo,Security kb: Runbook,Solution,Policy & Procedure and Emc Problem codes remains same ( if applicable)", 
						"Problem code section not displayed", "Pass");
				
			}

			Report.put("Select the resource type 'knowledge base'", 
					"User should see article type ( if applicable) Break Fix, Security Advisory,Technical Advisory, HowTo,Security kb: Runbook,Solution,Policy & Procedure and Emc Problem codes remains same ( if applicable)", 
					"User able to click on knowledge base and able to see "+Report.color(status+" section along with details"+detailsofstatus)+" <br> "+Report.color(articletype+" section along with details "+attr)+" <br> "+Report.color(problemcode+" section with details "+Report.color(detailsofprobcode)), "PASS");

			}
			else
			{
				System.out.println("not able to see knowledge base resource type");
				Report.put("Select the resource type 'knowledge base'", 
						"User should see article type ( if applicable) Break Fix, Security Advisory,Technical Advisory, HowTo,Security kb: Runbook,Solution,Policy & Procedure and Emc Problem codes remains same ( if applicable)", 
						"failed to see knowledge base resource type", "FAIL");
				Assert.fail();
			}
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Select the resource type 'knowledge base'", 
					"User should see article type ( if applicable) Break Fix, Security Advisory,Technical Advisory, HowTo,Security kb: Runbook,Solution,Policy & Procedure and Emc Problem codes remains same ( if applicable)", 
					"failed to see knowledge base resource type", "FAIL");
			Assert.fail();
		}
	}
	
	public void  ClickOnVandValidateForEmailResults(WebDriver driver) 
	{
		Log.info("Entering ClickOnVandValidateForEmailResults");   
		WebDriverWait wait = new WebDriverWait(driver, 150);
		
		String Email="";
		Actions act=new Actions(driver);

		try
		{       
			if(CommonUtility.CheckpresenceofAllElementLocated(driver,15,obj_EsupportCoveoPage.VboxOfFirstDisplayed()))
			{

			CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.VboxOfFirstDisplayed());
			String Vlink=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.VboxOfFirstDisplayed()).getText();
			System.out.println("link is "+Vlink);
			CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.VboxOfFirstDisplayed());
			
			wait.until(ExpectedConditions.presenceOfElementLocated(obj_EsupportCoveoPage.EmailResultDisplayedOnFirstResult()));
			CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.EmailResultDisplayedOnFirstResult());
			Email=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.EmailResultDisplayedOnFirstResult()).getText();
			System.out.println("displayed is "+Email);
			
			
			Report.put("Click on V icon   at the end of each result", 
					"It should only show option \"email result\".", 
					"User able to click on "+Report.color(Vlink)+" and able to see "+Report.color(Email)+" option only.", "PASS");

			        
			}
			else
			{
				System.out.println("V link not displayed");
				Report.put("Click on V icon   at the end of each result", 
						"It should only show option \"email result\".", 
						"V link not displayed", "FAIL");;
						Assert.fail();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Click on V icon   at the end of each result", 
					"It should only show option \"email result\".", 
					"Failed to see V link", "FAIL");;
					Assert.fail();
		}
	}
	
	public void  ClickOnMoreLinkAndValidateDriverIDSearchResults(WebDriver driver) 
	{
		Log.info("Entering ClickOnMoreLinkAndValidateDriverIDSearchResults");   
		WebDriverWait wait = new WebDriverWait(driver, 150);
		String testdata=TestNGCreator.TestData.get(Esupport.SearchOption.ordinal());
		String details="";String driverid="";
		Actions act=new Actions(driver);

		try
		{       
			if(CommonUtility.CheckpresenceofAllElementLocated(driver,15,obj_EsupportCoveoPage.Morelink()))
			{

			CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.Morelink());
			String more=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.Morelink()).getText();
			System.out.println("link is "+more);
			CommonUtility.ClickOn(driver,obj_EsupportCoveoPage.Morelink());
			
			wait.until(ExpectedConditions.presenceOfElementLocated(obj_EsupportCoveoPage.DetailsClickingOnMore()));
			CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.DetailsClickingOnMore());
			details=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.DetailsClickingOnMore()).getText();
			System.out.println("displayed is "+details);
			
			wait.until(ExpectedConditions.presenceOfElementLocated(obj_EsupportCoveoPage.DriverIDDetails()));
			CommonUtility.ScrollTo(driver,obj_EsupportCoveoPage.DriverIDDetails());
			driverid=CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.DriverIDDetails()).getText();
			System.out.println("displayed is "+driverid);
			
			Report.put("Scenario : 1, 2 , 3- Search Result Page Enter LDell driver id and click Search button.", 
					"It should show the driver id as top most link on search result page", 
					"User able to click on "+Report.color(more)+" and able to see searched "+Report.color(driverid), "PASS");

			        
			}
			else
			{
				System.out.println("more link not displayed");
				Report.put("Scenario : 1,2,3 - Search Result Page Enter LDell driver id and click Search button.", 
						"It should show the driver id as top most link on search result page", 
						"more link not displayed", "FAIL");;
						Assert.fail();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Scenario : 1,2,3 - Search Result Page Enter LDell driver id and click Search button.", 
					"It should show the driver id as top most link on search result page", 
					"Failed to see more link", "FAIL");;
					Assert.fail();
		}
	}
	
	public void RemoveSignInPopUp(WebDriver driver)
	{
		Log.info("Entering ClickOnMoreLinkAndValidateDriverIDSearchResults");   
		WebDriverWait wait = new WebDriverWait(driver, 150);
		
		
	}
}

