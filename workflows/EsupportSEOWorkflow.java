package com.dell.delta_uat_automation.esupport.workflows;

import java.io.BufferedWriter;
//import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.dell.delta_uat_automation.utility.CommonUtility;
import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.Log;
import com.dell.delta_uat_automation.utility.Report;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class EsupportSEOWorkflow extends BaseFlow 
{
	public void handleCookies(WebDriver driver)
	{
		System.out.println("Handle Cookies");
		WebDriverWait wait = new WebDriverWait(driver, 50);
		Log.info("Handle Cookies");	
		try
		{
			if(CommonUtility.CheckpresenceofElementLocated(driver, 10, obj_SEOPage.acceptCookies()))
			{
			
				CommonUtility.ClickOn(driver,obj_SEOPage.acceptCookies()); 
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

	public void launchContactUSUrl(WebDriver driver)
	{
		System.out.println("Inside launchContactUSUrl method");
		String header="";
		WebDriverWait wait = new WebDriverWait(driver, 150);

		try
		{
			//			Thread.sleep(6000);
			driver.get("https://www.dell.com/support/incidents-online/en-us/contactus/dynamic?spestate");
			//			Thread.sleep(6000);

			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIncidentsPage.TSHeader()));
			header = CommonUtility.highlightElement(driver,obj_EsupportIncidentsPage.TSHeader()).getText();
			System.out.println("header is "+header);

			Report.put("Open URL https://www.dell.com/support/incidents-online/en-us/contactus/dynamic?spestate",
					"ContactUs home page should open",
					"User able to launch url and landed on "+Report.color(header)+" home page", "PASS");
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Open URL https://www.dell.com/support/incidents-online/en-us/contactus/dynamic?spestate",
					"ContactUs home page should open",
					"Failed to load contact us home page", "FAIL");
			Assert.fail();
		}
	}
	

	public void validateURLForCapitalization(WebDriver driver)
	{
		System.out.println("Inside validateURLForCapitalization method");
		String url="";
		String caps="[A-Z]";

		try
		{
			url=driver.getCurrentUrl();
			System.out.println(url);
			String extra= url+"@";
			if(url.contains(caps) || extra.contains("/@"))
			{
				System.out.println("failed as url is not as expected");
				Report.put("Check the URL for capitalization & if it ends with / character",
						"URL Shouldnt end with / as mentioned below and the words SHOULD NOT start with a capital letter. <br>https://www.dell.com/support/home/en-us NOTE : Encrypted service tags or IDs can contain Capital letters.",
						"Failed to see expected url", "FAIL");
				Assert.fail();
			}
			else
			{
				System.out.println("url displayed is as expected");
				Report.put("Check the URL for capitalization & if it ends with / character",
						"URL Shouldnt end with / as mentioned below and the words SHOULD NOT start with a capital letter.<br> https://www.dell.com/support/home/en-us NOTE : Encrypted service tags or IDs can contain Capital letters.",
						"User able to see expected url displayed <br>"+Report.color(url), "PASS");
			}

		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Check the URL for capitalization & if it ends with / character",
					"URL Shouldnt end with / as mentioned below and the words SHOULD NOT start with a capital letter.<br> https://www.dell.com/support/home/en-us NOTE : Encrypted service tags or IDs can contain Capital letters.",
					"Failed to see expected url", "FAIL");
			Assert.fail();
		}
	}

	public void validateSpecialCharsBedoreQueryString(WebDriver driver)
	{
		System.out.println("Inside validateSpecialCharsBedoreQueryString method");
		String url="";



		try
		{
			url=driver.getCurrentUrl();
			System.out.println(url);
			if(url.contains("/?"))
			{
				System.out.println("failed as url is not as expected");
				Report.put("Check URL it has “/” before a query string",
						"URL Should not have “/” before a query string. Refer below URL. https://www.dell.com/support/home/en-us?app=warranty",
						"Failed to see expected url", "FAIL");
				Assert.fail();
			}
			else
			{
				System.out.println("url displayed is as expected");
				Report.put("Check URL it has “/” before a query string",
						"URL Should not have “/” before a query string. Refer below URL. https://www.dell.com/support/home/en-us?app=warranty",
						"User able to see expected url displayed <br>"+Report.color(url), "PASS");
			}

		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Check URL it has “/” before a query string",
					"URL Should not have “/” before a query string. Refer below URL. https://www.dell.com/support/home/en-us?app=warranty",
					"Failed to see expected url", "FAIL");
			Assert.fail();
		}
	}


	public void validateSpecialCharsInURL(WebDriver driver)
	{
		System.out.println("Inside validateSpecialCharsInURL method");
		String url="";
		String spec="[@*^]";

		try
		{
			url=driver.getCurrentUrl();
			System.out.println(url);
			if(url.contains(spec) || url.contains("--"))
			{
				System.out.println("failed as url is not as expected");
				Report.put("Check whether URL has special characters",
						"The URL should not contain special characters as below.<br> https://www.dell.com/support/article/en-us/sln115162/resolve-@hardware^-issues-**-or-psa-error-codes NOTE: URL can have One dash “-“ but NOT Two dashes “—” and should not end with a dash.",
						"Failed to see expected url", "FAIL");
				Assert.fail();
			}
			else
			{
				System.out.println("url displayed is as expected");
				Report.put("Check whether URL has special characters",
						"The URL should not contain special characters as below.<br> https://www.dell.com/support/article/en-us/sln115162/resolve-@hardware^-issues-**-or-psa-error-codes NOTE: URL can have One dash “-“ but NOT Two dashes “—” and should not end with a dash.",
						"User able to see expected url displayed <br>"+Report.color(url), "PASS");
			}

		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Check whether URL has special characters",
					"The URL should not contain special characters as below.<br> https://www.dell.com/support/article/en-us/sln115162/resolve-@hardware^-issues-**-or-psa-error-codes NOTE: URL can have One dash “-“ but NOT Two dashes “—” and should not end with a dash.",
					"Failed to see expected url", "FAIL");
			Assert.fail();
		}
	}

	public void validateLanguageCountryInURLForUS(WebDriver driver)
	{
		System.out.println("Inside validateLanguageCountryInURLForUS method");
		String url="";


		try
		{
			url=driver.getCurrentUrl();
			System.out.println(url);
			if(url.contains("en-us") )
			{

				System.out.println("url displayed is as expected");
				Report.put("Validate whether the URL of the Content page from the above step shows the  segment, 'Language-Country' as |en-us| for the default country, US.",
						"User must see the URL of the support home should get redirected as below. https://www.dell.com/support/incidents-online/en-us/contactus/dynamic",
						"User able to see expected url displayed "+Report.color(url), "PASS");

			}
			else
			{
				System.out.println("failed as url is not as expected");
				Report.put("Validate whether the URL of the Content page from the above step shows the  segment, 'Language-Country' as |en-us| for the default country, US.",
						"User must see the URL of the support home should get redirected as below. https://www.dell.com/support/incidents-online/en-us/contactus/dynamic",
						"Failed to see expected url", "FAIL");
				Assert.fail();
			}

		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Validate whether the URL of the Content page from the above step shows the  segment, 'Language-Country' as |en-us| for the default country, US.",
					"User must see the URL of the support home should get redirected as below. https://www.dell.com/support/incidents-online/en-us/contactus/dynamic",
					"Failed to see expected url", "FAIL");
			Assert.fail();
		}
	}

	public void PageSourceValidations(WebDriver driver)
	{
		System.out.println("Inside PageSourceValidations method");

		Properties obj_property = new Properties();

		String path;

		try
		{
			String can= driver.getPageSource();


			if (TestNGCreator.TestData.get(Esupport.StartUrl.ordinal()).toUpperCase().contains("SEO"))
			{
				obj_property = CommonUtility.loadPropertyFile();
				
				obj_property.getProperty("seopath");
				//				 StringWriter writer = new StringWriter();
				//				  obj_property.list(new PrintWriter(writer));
				//				  path=writer.getBuffer().toString();
				path=obj_property.getProperty("seoPath");
				FileWriter fr=new FileWriter(path);
				BufferedWriter br=new BufferedWriter(fr);

				br.write(can);


				br.close();



				String value="<link rel=\"canonical\" ";
				if (can.contains(value))
				{
					System.out.println("pass");
					Report.put("Right-click on the page, and select View Page Source. Press CTRL+F and search for 'Canonical'",
							"User should be directed to source page. There should be word Canonical in the source page. <link rel=\"canonical\" href=\"https://www.dell.com/support/home/en-us?app=drivers\" ",
							"User able to see expected Canonical from source page "+Report.color(value), "Pass");


				}
				else
				{
					System.out.println("fail");
					Report.put("Right-click on the page, and select View Page Source. Press CTRL+F and search for 'Canonical'",
							"User should be directed to source page. There should be word Canonical in the source page. <link rel=\"canonical\" href=\"https://www.dell.com/support/home/en-us?app=drivers\" ",
							"User not able to see expected Canonical from source page", "Fail");
					Assert.fail();
				}

				String value1="<link rel=\"canonical\" href=\"https://www.dell.com/support/incidents-online/en-us/contactus/dynamic\" /";
				if (can.contains(value1))
				{
					System.out.println("pass");
					Report.put("In the Page Source. look for the word \"canonical\" and it is HTTPS",
							"User should be directed to source page. There should be word Canonical in the source page. <link rel=\"canonical\" href=\"https://www.dell.com/support/incidents-online/en-us/contactus/dynamic\" /",
							"User able to see expected https from source page "+Report.color(value1), "Pass");

				}
				else
				{
					System.out.println("fail");
					Report.put("In the Page Source. look for the word \"canonical\" and it is HTTPS",
							"User should be directed to source page. There should be word Canonical in the source page. <link rel=\"canonical\" href=\"https://www.dell.com/support/home/en-us?app=drivers\" ",
							"User not able to see expected https from source page ", "Fail");

					Assert.fail();
				}
				
				String value3="<title>Contact Us | Dell US</title>";
				if (can.contains(value3))
				{
					System.out.println("pass");
					Report.put("Check the Page Title",
							"The page should have the title. The Page source should have the title between the tags.<title> Page Title </title>",
							"User able to see expected title from source page "+Report.color(value3), "Pass");

				}
				else
				{
					System.out.println("fail");
					Report.put("Check the Page Title",
							"The page should have the title. The Page source should have the title between the tags.<title> Page Title </title>",
							"User not able to see expected title from source page", "Fail");

					Assert.fail();
				}
				
				String value4="<h1 class=\"heading-first text-center text-md-left text-xl-left  text-lg-left\" style=\"\">Contact Technical Support</h1>";
				String whitespaces=can;
				can=whitespaces.replaceAll("\\s", "");
				String value4whitespace=value4;
				value4=value4whitespace.replaceAll("\\s", "");
				System.out.println(value4);
				if (can.contains(value4))
				{
					System.out.println("pass");
					Report.put("Check for the header tags in Page source",
							"The page should have header as mentioned below.<h1 class=\"bottom-margin-remove\">Dell EMC PowerEdge Servers Troubleshooting Guide </h1>",
							"User able to see expected header from source page "+Report.color(value4), "Pass");

				}
				else
				{
					System.out.println("fail");
					Report.put("Check for the header tags in Page source",
							"The page should have header as mentioned below.<h1 class=\"bottom-margin-remove\">Dell EMC PowerEdge Servers Troubleshooting Guide </h1>",
							"User not able to see expected title from source page", "Fail");

					Assert.fail();
				}
				
				String value5="<meta name=\"DESCRIPTION\" content=\"Find Dell Support channels like email, chat, and telephone numbers for your Dell computer. Speak to one of our computer support specialist today!\" />";
//				String whitespaces1=can;
//				can=whitespaces.replaceAll("\\s", "");
				String value5whitespace=value5;
				value5=value5whitespace.replaceAll("\\s", "");
				System.out.println(value5);
				if (can.contains(value5))
				{
					System.out.println("pass");
					Report.put("In the Page Source search for the word \"DESCRIPTION\" ",
							"User should see the meta description of the support page as mentioned below. <meta name=\"DESCRIPTION\" content=\" \"",
							"User able to see expected header from source page "+Report.color(value5), "Pass");

				}
				else
				{
					System.out.println("fail");
					Report.put("In the Page Source search for the word \"DESCRIPTION\" ",
							"User should see the meta description of the support page as mentioned below. <meta name=\"DESCRIPTION\" content=\" \"",
							"User not able to see expected title from source page", "Fail");

					Assert.fail();
				}
				
				String value6="<meta name=\"keywords\" content=\"phone; chat; email; contact; contact Dell; call Dell; email Dell; create support ticket; support request,\" />";
//				String whitespaces1=can;
//				can=whitespaces.replaceAll("\\s", "");
				String value6whitespace=value6;
				value6=value6whitespace.replaceAll("\\s", "");
				System.out.println(value6);
				if (can.contains(value6))
				{
					System.out.println("pass");
					Report.put("In the Page Source search for the word \"KEYWORDS\" ",
							"User should see the meta description of the support page as mentioned below. <meta name=\"KEYWORDS\" ",
							"User able to see expected header from source page "+Report.color(value6), "Pass");
					
					Report.put("In the Page Source search for the word \"KEYWORDS\" Content  ",
							"User should see the meta description of the support page as mentioned below. <meta name=\"KEYWORDS\" content=\"{Values1, Value2}\"",
							"User able to see expected header from source page "+Report.color(value6), "Pass");

				}
				else
				{
					System.out.println("fail");
					Report.put("In the Page Source search for the word \"KEYWORDS\" ",
							"User should see the meta description of the support page as mentioned below. <meta name=\"KEYWORDS\" content=\"{Values1, Value2}\"",
							"User not able to see expected title from source page", "Fail");

					Assert.fail();
				}
				
			}
			else
			{
				System.out.println("properties file doesn't contain seopath");
				Report.put("Right-click on the page, and select View Page Source. Press CTRL+F and search for 'Canonical'",
						"User should be directed to source page. There should be word Canonical in the source page. <link rel=\"canonical\" href=\"https://www.dell.com/support/home/en-us?app=drivers\" ",
						"User not able to save page source as file doesn't contain seopath", "Fail");
				Assert.fail();
			}

		} 
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("properties file doesn't contain seopath");
			Report.put("Right-click on the page, and select View Page Source. Press CTRL+F and search for 'Canonical'",
					"User should be directed to source page. There should be word Canonical in the source page. <link rel=\"canonical\" href=\"https://www.dell.com/support/home/en-us?app=drivers\" ",
					"User not able to save page source as file doesn't contain seopath", "Fail");
			Assert.fail();
		}
	}
	
	//new methods paasing url and module name from test data sheet
	
	public void launchUrl(WebDriver driver, String moduleName, String moduleUrl)
	{
		System.out.println("Inside launchUrl method");
		String header="";
		WebDriverWait wait = new WebDriverWait(driver, 150);

		try
		{
			//			Thread.sleep(6000);
			driver.get(moduleUrl);
			//			Thread.sleep(6000);

//			wait.until(ExpectedConditions.visibilityOfElementLocated(obj_EsupportIncidentsPage.TSHeader()));
			if(CommonUtility.CheckpresenceofElementLocated(driver,10,obj_EsupportIncidentsPage.TSHeader()))
			{
			header = CommonUtility.highlightElement(driver,obj_EsupportIncidentsPage.TSHeader()).getText();
			System.out.println("header is "+header);
			}
			
			if(CommonUtility.CheckpresenceofElementLocated(driver,10,obj_EsupportIncidentsPage.HeaderOfContactUS()))
			{
			header = CommonUtility.highlightElement(driver,obj_EsupportIncidentsPage.HeaderOfContactUS()).getText();
			System.out.println("header is "+header);
			}
			Report.put("Open "+moduleName+"URL: "+moduleUrl,
					moduleName+" home page should open",
						"User able to launch <br>"+moduleUrl+" <br> and landed on "+Report.color(header)+" home page", "PASS");
			
			handleCookies(driver);
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Open URL "+moduleUrl,
					moduleName+" home page should open",
					"Failed to load <br>"+moduleName+" home page", "FAIL");
			Assert.fail();
		}
	}
	
	

	public void validateLanguageCountryInURLForUS_V1(WebDriver driver, String moduleUrl)
	{
		System.out.println("Inside validateLanguageCountryInURLForUS_V1 method");
		String url="";


		try
		{
			url=driver.getCurrentUrl();
			System.out.println(url);
			if(url.contains("en-us") )
			{

				System.out.println("url displayed is as expected");
				Report.put("Validate whether the URL of the Content page from the above step shows the  segment, 'Language-Country' as |en-us| for the default country, US.",
						"User must see the URL of the support home should get redirected as below.<br>"+moduleUrl,
						"User able to see expected url displayed <br>"+Report.color(url), "PASS");

			}
			else
			{
				System.out.println("failed as url is not as expected");
				Report.put("Validate whether the URL of the Content page from the above step shows the  segment, 'Language-Country' as |en-us| for the default country, US.",
						"User must see the URL of the support home should get redirected as below.<br>"+moduleUrl,
						"Failed to see expected url", "FAIL");
				Assert.fail();
			}

		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Validate whether the URL of the Content page from the above step shows the  segment, 'Language-Country' as |en-us| for the default country, US.",
					"User must see the URL of the support home should get redirected as below.<br>"+moduleUrl,
					"Failed to see expected url", "FAIL");
			Assert.fail();
		}
	}

	public void PageSourceValidations_V1(WebDriver driver)
	{
		System.out.println("Inside PageSourceValidations_V1 method");
		String url=TestNGCreator.TestData.get(Esupport.SearchOption.ordinal());
		System.out.println(url);
		String urlspec=url;
		url=urlspec.replaceAll("[<>]", "");
		System.out.println(url);
		Properties obj_property = new Properties();
		
		String path;

		try
		{
			String can= driver.getPageSource();
			

			if (TestNGCreator.TestData.get(Esupport.StartUrl.ordinal()).toUpperCase().contains("SEO"))
			{
				obj_property = CommonUtility.loadPropertyFile();
				
				obj_property.getProperty("seopath");
				//				 StringWriter writer = new StringWriter();
				//				  obj_property.list(new PrintWriter(writer));
				//				  path=writer.getBuffer().toString();
				path=obj_property.getProperty("seoPath");
				FileWriter fr=new FileWriter(path);
				BufferedWriter br=new BufferedWriter(fr);

				br.write(can);


				br.close();

				Thread.sleep(6000);

//				String value="<link rel=\"canonical\" ";
				String value=TestNGCreator.TestData.get(Esupport.SearchOption.ordinal());
				System.out.println(value);
				if (can.contains(value))
				{
					System.out.println("pass");
					String valuespec=value;
					value=valuespec.replaceAll("[<>]", "");
					System.out.println(value);
					Report.put("Right-click on the page, and select View Page Source. Press CTRL+F and search for 'Canonical'",
							"User should be directed to source page. There should be word Canonical in the source page."+url,
							"User able to see expected Canonical from source page <br>"+Report.color(value), "Pass");


				}
				else
				{
					System.out.println("fail, canonical not displayed");
					Report.put("Right-click on the page, and select View Page Source. Press CTRL+F and search for 'Canonical'",
							"User should be directed to source page. There should be word Canonical in the source page."+url,
							"User not able to see expected Canonical from source page", "Fail");
					Assert.fail();
				}

//				String value1="<link rel=\"canonical\" href=\"https://www.dell.com/support/incidents-online/en-us/contactus/dynamic\" />";
				String value1=TestNGCreator.TestData.get(Esupport.SearchOption.ordinal());
				System.out.println(value1);
				if (can.contains(value1))
				{
					System.out.println("pass");
					String value1spec=value1;
					value1=value1spec.replaceAll("[<>]", "");
					System.out.println(value1);
					Report.put("In the Page Source. look for the word \"canonical\" and it is HTTPS",
							"User should be directed to source page. There should be word Canonical in the source page."+url,
							"User able to see expected https from source page <br>"+Report.color(value1), "Pass");

				}
				else
				{
					System.out.println("fail, canonical not displayed");
					Report.put("In the Page Source. look for the word \"canonical\" and it is HTTPS",
							"User should be directed to source page. There should be word Canonical in the source page. "+url,
							"User not able to see expected https from source page ", "Fail");

					Assert.fail();
				}
				
//				String value3="<title>Contact Us | Dell US</title>";
				String value3=TestNGCreator.TestData.get(Esupport.Dpid.ordinal());
				System.out.println(value3);
				if (can.contains(value3))
				{
					System.out.println("pass");
					String value3spec=value3;
					value3=value3spec.replaceAll("[<>]", "");
					System.out.println(value3);
					Report.put("Check the Page Title",
							"The page should have the title. The Page source should have the title between the tags as below example.title Page Title /title",
							"User able to see expected title from source page <br> "+Report.color(value3), "Pass");

				}
				else
				{
					System.out.println("fail");
					Report.put("Check the Page Title",
							"The page should have the title. The Page source should have the title between the tags as below example.title Page Title /title",
							"User not able to see expected title from source page", "Fail");

					Assert.fail();
				}
				
//				String value4="<h1 class=\"heading-first text-center text-md-left text-xl-left  text-lg-left\" style=\"\">Contact Technical Support</h1>";
				String value4=TestNGCreator.TestData.get(Esupport.PhoneNumber.ordinal());
				String testcase=TestNGCreator.TestData.get(Esupport.TestCaseID.ordinal());
				if(testcase.contains("9257041"))
				{
					System.out.println("h1 class validations not required");
				}
				else
				{
//				System.out.println(value4);
//				String whitespaces=can;
//				can=whitespaces.replaceAll("\\s", "");
//				String value4s=value4;
//				String value4whitespace=value4s;
//				value4s=value4whitespace.replaceAll("\\s", "");
//				System.out.println(value4s);
//				if (can.contains(value4s))
//				{
//					System.out.println("pass");
//					String value4spec=value4;
//					value4=value4spec.replaceAll("[<>]", "");
//					System.out.println(value4);
//					Report.put("Check for the header tags in Page source",
//							"The page should have header as mentioned below example.h1 class='bottom-margin-remove' Dell EMC PowerEdge Servers Troubleshooting Guide /h1",
//							"User able to see expected header from source page <br> "+Report.color(value4), "Pass");
//
//				}
//				else
//				{
//					System.out.println("fail");
//					Report.put("Check for the header tags in Page source",
//							"The page should have header as mentioned below example.h1 class=\"bottom-margin-remove\" Dell EMC PowerEdge Servers Troubleshooting Guide /h1",
//							"User not able to see expected title from source page", "Fail");
//
//					Assert.fail();
//				}
				}
//				String value5="<meta name=\"DESCRIPTION\" content=\"Find Dell Support channels like email, chat, and telephone numbers for your Dell computer. Speak to one of our computer support specialist today!\" />";
				String value5=TestNGCreator.TestData.get(Esupport.PONumber.ordinal());
				System.out.println(value5);
				String whitespaces1=can;
				can=whitespaces1.replaceAll("\\s", "");
				String value5s=value5;
				String value5whitespace=value5s;
				value5s=value5whitespace.replaceAll("\\s", "");
				System.out.println(value5s);
				if (can.contains(value5s))
				{
					System.out.println("pass");
					String value5spec=value5;
					value5=value5spec.replaceAll("[<>]", "");
					System.out.println(value5);
					Report.put("In the Page Source search for the word \"DESCRIPTION\" ",
							"User should see the meta description of the support page as mentioned below example. meta name=\"DESCRIPTION\" content=\" \"",
							"User able to see expected header from source page <br> "+Report.color(value5), "Pass");

				}
				else
				{
					System.out.println("fail");
					Report.put("In the Page Source search for the word \"DESCRIPTION\" ",
							"User should see the meta description of the support page as mentioned below example. meta name=\"DESCRIPTION\" content=\" \"",
							"User not able to see expected title from source page", "Fail");

					Assert.fail();
				}
				
//				String value6="<meta name=\"keywords\" content=\"phone; chat; email; contact; contact Dell; call Dell; email Dell; create support ticket; support request,\" />";
				String value6=TestNGCreator.TestData.get(Esupport.FirstName.ordinal());
				System.out.println(value6);
				String whitespaces2=can;
				can=whitespaces2.replaceAll("\\s", "");
				String value6s=value6;
				String value6whitespace=value6s;
				value6s=value6whitespace.replaceAll("\\s", "");
				
				if (can.contains(value6s))
				{
					System.out.println("pass");
					String value6spec=value6;
					value6=value6spec.replaceAll("[<>]", "");
					System.out.println(value6);
					Report.put("In the Page Source search for the word \"KEYWORDS\" ",
							"User should see the meta description of the support page as mentioned below example. meta name=\"KEYWORDS\" ",
							"User able to see expected header from source page <br>"+Report.color(value6), "Pass");
					
					Report.put("In the Page Source search for the word \"KEYWORDS\" Content  ",
							"User should see the meta description of the support page as mentioned below example. meta name=\"KEYWORDS\" content=\"{Values1, Value2}\"",
							"User able to see expected header from source page <br>"+Report.color(value6), "Pass");

				}
				else
				{
					System.out.println("fail");
					Report.put("In the Page Source search for the word \"KEYWORDS\" ",
							"User should see the meta description of the support page as mentioned below example. <meta name=\"KEYWORDS\" content=\"{Values1, Value2}\"",
							"User not able to see expected title from source page", "Fail");

					Assert.fail();
				}
				
			}
			else
			{
				System.out.println("properties file doesn't contain seopath");
				Report.put("Right-click on the page, and select View Page Source. Press CTRL+F and search for 'Canonical'",
						"User should be directed to source page. There should be word Canonical in the source page."+url,
						"User not able to save page source as file doesn't contain seopath", "Fail");
				Assert.fail();
			}

		} 
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("properties file doesn't contain seopath");
			Report.put("Right-click on the page, and select View Page Source. Press CTRL+F and search for 'Canonical'",
					"User should be directed to source page. There should be word Canonical in the source page."+url,
					"User not able to save page source as file doesn't contain seopath", "Fail");
			Assert.fail();
		}
	}
	
	public void ValidateURLAfterCountryChange_Japan(WebDriver driver)
	{
		System.out.println("Inside ValidateURLAfterCountryChange_Japan method");
		String url="";


		try
		{
			url=driver.getCurrentUrl();
			System.out.println(url);
			if(url.contains("ja-jp") ||url.contains("jp/ja"))
			{

				System.out.println("url displayed is as expected");
				Report.put("Check the URL for Character encoding for Asian languages. Select Japan from country selector and check the URL. ",
						"The character encoding should be as below in the URL.https://www.dell.com/support/manuals/jp/ja/jpbsd1/poweredge-m820/server_tsg/#japan language#?guid=guid-f9a1d0ec-6bfb-402a-8c80-95626ce4719d",
						"User able to see expected url displayed <br>"+Report.color(url), "PASS");

			}
			else
			{
				System.out.println("failed as url is not as expected");
				Report.put("Check the URL for Character encoding for Asian languages. Select Japan from country selector and check the URL. ",
						"The character encoding should be as below in the URL.https://www.dell.com/support/manuals/jp/ja/jpbsd1/poweredge-m820/server_tsg/#japan language#?guid=guid-f9a1d0ec-6bfb-402a-8c80-95626ce4719d",
						"Failed to see expected url", "FAIL");
				Assert.fail();
			}

		} 
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put("Check the URL for Character encoding for Asian languages. Select Japan from country selector and check the URL. ",
					"The character encoding should be as below in the URL.https://www.dell.com/support/manuals/jp/ja/jpbsd1/poweredge-m820/server_tsg/ #japan language# guid=guid-f9a1d0ec-6bfb-402a-8c80-95626ce4719d",
					"Failed to see expected url", "FAIL");
			Assert.fail();
		}
	}
	
	public void  changeCountry(WebDriver driver)
	{
		// TODO Auto-generated method stub
		System.out.println("Entering changeCountry");
		Actions act=new Actions(driver);
		Log.info("Entering changeCountry");   
		String country = TestNGCreator.TestData.get(Esupport.Country.ordinal()).split(";")[0];
		String selectedcountry = "";

		try{

			act.moveToElement(CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.CountrySelector())).build().perform();


			if(CommonUtility.highlightElement(driver,obj_EsupportCoveoPage.CountrySelector()).isDisplayed())
			{

				System.out.println("country displayed");

				WebElement element =driver.findElement(By.xpath("//div[@id='countryselector']//a"));
				((JavascriptExecutor)driver).executeScript("arguments[0].click();", element); 

				Thread.sleep(6000);
				System.out.println("Country from Test data is :::: "+country);
				List<WebElement> countryList=driver.findElements(obj_EsupportCoveoPage.CountryselectorList());

				for(WebElement lt:countryList)
				{
					String couLi=lt.getText();

//					act.sendKeys(String.valueOf('\u0105')).perform();
					WebElement element1 = driver.findElement(By.xpath("(//a)[0162]"));
					((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",element1);
					
					System.out.println("Country is: " +couLi);
					if(couLi.contains(country))
					{
						System.out.println("Inside if**************");
						System.out.println("Country is: " +couLi);
//						CommonUtility.ClickOnWebElement(driver,lt);
//						act.moveToElement(CommonUtility.highlightElement(driver,lt)).click().build().perform();
//						WebElement element1 =CommonUtility.highlightElement(driver,lt);
//						((JavascriptExecutor)driver).executeScript("arguments[0].click();", element1); 
						lt.click();
						
						Thread.sleep(5000);
						handleCookies(driver);

						selectedcountry = couLi;
						System.out.println("Selected Country is "+selectedcountry);
						Report.put(" Change country to JAPAN from the country selector", 
								"The country should get changed to JAPAN or a country selected ", 
								"Country changed to : "+Report.color(country), "PASS");
						break;
					}							
				}
			} 	
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Report.put(" Change country to JAPAN from the country selector", 
					"The country should get changed to JAPAN or a country selected ", 
					"Not able to select the country"+Report.color(country), "FAIL");
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

			//act.moveToElement(CommonUtility.highlightElement(driver,obj_EsupportContentHomePage.CountrySelectorArticle())).build().perform();
			//			CommonUtility.scrollToViewElement(driver,obj_EsupportContentHomePage.CountrySelectorArticle());
			CommonUtility.ScrollTo(driver,obj_EsupportContentHomePage.CountrySelectorArticle());
			handleCookies(driver);

			if(CommonUtility.highlightElement(driver,obj_EsupportContentHomePage.CountrySelectorArticle()).isDisplayed())
			{

				System.out.println("country displayed");

				//				WebElement element =driver.findElement(By.xpath("//div[@id='countryselector']/a"));
				//				((JavascriptExecutor)driver).executeScript("arguments[0].click();", element); 
				CommonUtility.ClickOn(driver,By.xpath("//div[@id='countryselector']//a"));

				Thread.sleep(6000);
				System.out.println("Country from Test data is :::: "+country2);
				List<WebElement> countryList=driver.findElements(obj_EsupportContentHomePage.CountrySelectorList());

				WebElement element1 = driver.findElement(By.xpath("(//a)[256]"));
				((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",element1);
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
				
				Thread.sleep(6000);
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
			Assert.fail();
		}
	}
}
