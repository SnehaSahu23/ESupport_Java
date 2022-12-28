package com.dell.delta_uat_automation.esupport.pages;
import java.util.Hashtable;

import com.dell.delta_uat_automation.utility.ReadExcel;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class EsupportPojo {

	//SFDC page variables

	public static Hashtable<String, String> OrderHomePage_Data = null; 
	public static Hashtable<String, String> RecentOrderPage_Data = null; 
	public static Hashtable<String, String> RetailAssetPage_Data = null;
	public static Hashtable<String, String> DriversandDownloads_Data = null;
	public static Hashtable<String, String> IncidentsPage_Data = null;
	public static Hashtable<String, String> MPSPage_Data = null;
	public static Hashtable<String, String> CoveoPage_Data = null;
	public static Hashtable<String, String> IntegratedHomePage_Data = null;
	public static Hashtable<String, String> ContentHomePage_Data = null;
	public static Hashtable<String, String> SubscriptionHomePage_Data = null;
	public static Hashtable<String, String> ErevenueHomePage_Data = null;
	public static Hashtable<String, String> DDLHomePage_Data = null;
	public static Hashtable<String, String> IPSHomePage_Data = null;
	public static Hashtable<String, String> ServiceEventsHomePage_Data = null;
	public static Hashtable<String, String> UnifiedPortalPage_Data = null;
	public static Hashtable<String, String> PortalPage_Data = null;
	public static Hashtable<String, String> SecurityLandingPage_Data = null;
	
	// read from excel store it in hash objects for all pages
	public void storePageDataFromExcel(String environment) {

		try
		{

			if(environment.contains("ES4IE") || environment.equalsIgnoreCase("ES3IE")|| environment.equalsIgnoreCase("ES2IE")||environment.equalsIgnoreCase("ES1IE") || environment.equalsIgnoreCase("ESPRODIE"))
			{
				System.out.println("Reading the entire Repository sheets of ESUPPORT Application(INTERNET EXPLORER)!!!!!");

				OrderHomePage_Data = ReadExcel.getEntireExcelSheetData(TestNGCreator.folderPath, "OrderHomePage",
						"Object Name / Label Name", "Locator Type%Object Properties");

				RecentOrderPage_Data = ReadExcel.getEntireExcelSheetData(TestNGCreator.folderPath, "RecentOrderPage",
						"Object Name / Label Name", "Locator Type%Object Properties"); 
				RetailAssetPage_Data =ReadExcel.getEntireExcelSheetData(TestNGCreator.folderPath, "RetailAssetPage",
						"Object Name / Label Name", "Locator Type%Object Properties"); 
				DriversandDownloads_Data =ReadExcel.getEntireExcelSheetData(TestNGCreator.folderPath, "DriversandDownloads",
						"Object Name / Label Name", "Locator Type%Object Properties"); 
				IncidentsPage_Data =ReadExcel.getEntireExcelSheetData(TestNGCreator.folderPath, "IncidentsPage",
						"Object Name / Label Name", "Locator Type%Object Properties"); 
				MPSPage_Data =ReadExcel.getEntireExcelSheetData(TestNGCreator.folderPath, "MPSPage",
						"Object Name / Label Name", "Locator Type%Object Properties");
				CoveoPage_Data =ReadExcel.getEntireExcelSheetData(TestNGCreator.folderPath, "CoveoPage",
						"Object Name / Label Name", "Locator Type%Object Properties");
				System.out.println("Reading Repository sheets of ESUPPORT Application Successfully done!!!!!!");
				IntegratedHomePage_Data =ReadExcel.getEntireExcelSheetData(TestNGCreator.folderPath, "IntegratedHomePage",
						"Object Name / Label Name", "Locator Type%Object Properties");
				System.out.println("Reading Repository sheets of ESUPPORT Application Successfully done!!!!!!");

				ContentHomePage_Data =ReadExcel.getEntireExcelSheetData(TestNGCreator.folderPath, "ContentPage",
						"Object Name / Label Name", "Locator Type%Object Properties");
				System.out.println("Reading Repository sheets of ESUPPORT Application Successfully done!!!!!!");

				SubscriptionHomePage_Data =ReadExcel.getEntireExcelSheetData(TestNGCreator.folderPath, "SubscriptionPage",
						"Object Name / Label Name", "Locator Type%Object Properties");
				System.out.println("Reading Repository sheets of ESUPPORT Application Successfully done!!!!!!");
				ErevenueHomePage_Data =ReadExcel.getEntireExcelSheetData(TestNGCreator.folderPath, "ErevenuePage",
						"Object Name / Label Name", "Locator Type%Object Properties");
				System.out.println("Reading Repository sheets of ESUPPORT Application Successfully done!!!!!!");
				DDLHomePage_Data =ReadExcel.getEntireExcelSheetData(TestNGCreator.folderPath, "DDLPage",
						"Object Name / Label Name", "Locator Type%Object Properties");
				System.out.println("Reading Repository sheets of ESUPPORT Application Successfully done!!!!!!"); 
				ServiceEventsHomePage_Data =ReadExcel.getEntireExcelSheetData(TestNGCreator.folderPath, "ServiceEventsPage",
						"Object Name / Label Name", "Locator Type%Object Properties");
				System.out.println("Reading Repository sheets of ESUPPORT ServiceEvents page Successfully done");
				IPSHomePage_Data =ReadExcel.getEntireExcelSheetData(TestNGCreator.folderPath, "IPSPage",
						"Object Name / Label Name", "Locator Type%Object Properties");
				System.out.println("Reading Repository sheets of ESUPPORT IPS page Successfully done!!!!!!");
				UnifiedPortalPage_Data =ReadExcel.getEntireExcelSheetData(TestNGCreator.folderPath, "UnifiedPortalPage",
						"Object Name / Label Name", "Locator Type%Object Properties");
				System.out.println("Reading Repository sheets of ESUPPORT UnifiedPortal page Successfully done!!!!!!");
				PortalPage_Data =ReadExcel.getEntireExcelSheetData(TestNGCreator.folderPath, "PortalPage",
						"Object Name / Label Name", "Locator Type%Object Properties");
				System.out.println("Reading Repository sheets of ESUPPORT Portal page Successfully done!!!!!!");
				
				SecurityLandingPage_Data =ReadExcel.getEntireExcelSheetData(TestNGCreator.folderPath, "SecurityLandingPage",
						"Object Name / Label Name", "Locator Type%Object Properties");
				System.out.println("Reading Repository sheets of Security Landing page Successfully done!!!!!!");
			}
			//added for Mobile automation
			else if(environment.equalsIgnoreCase("ES4CH") || environment.equalsIgnoreCase("ES3CH")|| environment.equalsIgnoreCase("ES2CH")||environment.equalsIgnoreCase("ES1CH") || environment.equalsIgnoreCase("ESPRODCH")||
					environment.equalsIgnoreCase("MOB1MB") || environment.equalsIgnoreCase("MOBPRODMB")||environment.equalsIgnoreCase("MOB4MB") ||environment.equalsIgnoreCase("MOB3MB")||environment.equalsIgnoreCase("MOB2MB"))
			{
				System.out.println("Reading the entire Repository sheets of ESUPPORT Application(CHROME)!!!!!");

				OrderHomePage_Data = ReadExcel.getEntireExcelSheetData(TestNGCreator.folderPath, "OrderHomePage",
						"Object Name / Label Name", "Locator Type%Object Properties");

				RecentOrderPage_Data = ReadExcel.getEntireExcelSheetData(TestNGCreator.folderPath, "RecentOrderPage",
						"Object Name / Label Name", "Locator Type%Object Properties"); 
				RetailAssetPage_Data =ReadExcel.getEntireExcelSheetData(TestNGCreator.folderPath, "RetailAssetPage",
						"Object Name / Label Name", "Locator Type%Object Properties"); 
				DriversandDownloads_Data =ReadExcel.getEntireExcelSheetData(TestNGCreator.folderPath, "DriversandDownloads",
						"Object Name / Label Name", "Locator Type%Object Properties"); 
				IncidentsPage_Data =ReadExcel.getEntireExcelSheetData(TestNGCreator.folderPath, "IncidentsPage",
						"Object Name / Label Name", "Locator Type%Object Properties"); 
				MPSPage_Data =ReadExcel.getEntireExcelSheetData(TestNGCreator.folderPath, "MPSPage",
						"Object Name / Label Name", "Locator Type%Object Properties");
				CoveoPage_Data =ReadExcel.getEntireExcelSheetData(TestNGCreator.folderPath, "CoveoPage",
						"Object Name / Label Name", "Locator Type%Object Properties");
				System.out.println("Reading Repository sheets of ESUPPORT Application Successfully done!!!!!!");
				IntegratedHomePage_Data =ReadExcel.getEntireExcelSheetData(TestNGCreator.folderPath, "IntegratedHomePage",
						"Object Name / Label Name", "Locator Type%Object Properties");
				System.out.println("Reading Repository sheets of ESUPPORT Application Successfully done!!!!!!");

				ContentHomePage_Data =ReadExcel.getEntireExcelSheetData(TestNGCreator.folderPath, "ContentPage",
						"Object Name / Label Name", "Locator Type%Object Properties");
				System.out.println("Reading Repository sheets of ESUPPORT Application Successfully done!!!!!!");
				SubscriptionHomePage_Data =ReadExcel.getEntireExcelSheetData(TestNGCreator.folderPath, "SubscriptionPage",
						"Object Name / Label Name", "Locator Type%Object Properties");
				System.out.println("Reading Repository sheets of ESUPPORT Application Successfully done!!!!!!");
				ErevenueHomePage_Data =ReadExcel.getEntireExcelSheetData(TestNGCreator.folderPath, "ErevenuePage",
						"Object Name / Label Name", "Locator Type%Object Properties");
				System.out.println("Reading Repository sheets of ESUPPORT Application Successfully done!!!!!!");
				DDLHomePage_Data =ReadExcel.getEntireExcelSheetData(TestNGCreator.folderPath, "DDLPage",
						"Object Name / Label Name", "Locator Type%Object Properties");
				System.out.println("Reading Repository sheets of DDL ******ESUPPORT Application Successfully done!!!!!!");
				IPSHomePage_Data =ReadExcel.getEntireExcelSheetData(TestNGCreator.folderPath, "IPSPage",
						"Object Name / Label Name", "Locator Type%Object Properties");
				System.out.println("Reading Repository sheets of ESUPPORT IPS page Successfully done!!!!!!");
				
				ServiceEventsHomePage_Data =ReadExcel.getEntireExcelSheetData(TestNGCreator.folderPath, "ServiceEventsPage",
						"Object Name / Label Name", "Locator Type%Object Properties");
				System.out.println("Reading Repository sheets of ESUPPORT ServiceEvents page Successfully done");
			
				UnifiedPortalPage_Data =ReadExcel.getEntireExcelSheetData(TestNGCreator.folderPath, "UnifiedPortalPage",
						"Object Name / Label Name", "Locator Type%Object Properties");
				System.out.println("Reading Repository sheets of ESUPPORT UnifiedPortal page Successfully done!!!!!!");
				PortalPage_Data =ReadExcel.getEntireExcelSheetData(TestNGCreator.folderPath, "PortalPage",
						"Object Name / Label Name", "Locator Type%Object Properties");
				System.out.println("Reading Repository sheets of ESUPPORT Portal page Successfully done!!!!!!");
				
				SecurityLandingPage_Data =ReadExcel.getEntireExcelSheetData(TestNGCreator.folderPath, "SecurityLandingPage",
						"Object Name / Label Name", "Locator Type%Object Properties");
				System.out.println("Reading Repository sheets of Security Landing page Successfully done!!!!!!");
			}


			else if(environment.equalsIgnoreCase("ES4FF") || environment.equalsIgnoreCase("ES3FF")|| environment.equalsIgnoreCase("ES2FF")||environment.equalsIgnoreCase("ES1FF") || environment.equalsIgnoreCase("ESPRODFF"))
			{
				System.out.println("Reading the entire Repository sheets of ESUPPORT Application(FIREFOX)!!!!!");

				OrderHomePage_Data = ReadExcel.getEntireExcelSheetData(TestNGCreator.folderPath, "OrderHomePage",
						"Object Name / Label Name", "Locator Type%Object Properties");

				RecentOrderPage_Data = ReadExcel.getEntireExcelSheetData(TestNGCreator.folderPath, "RecentOrderPage",
						"Object Name / Label Name", "Locator Type%Object Properties"); 
				RetailAssetPage_Data =ReadExcel.getEntireExcelSheetData(TestNGCreator.folderPath, "RetailAssetPage",
						"Object Name / Label Name", "Locator Type%Object Properties"); 
				DriversandDownloads_Data =ReadExcel.getEntireExcelSheetData(TestNGCreator.folderPath, "DriversandDownloads",
						"Object Name / Label Name", "Locator Type%Object Properties"); 
				IncidentsPage_Data =ReadExcel.getEntireExcelSheetData(TestNGCreator.folderPath, "IncidentsPage",
						"Object Name / Label Name", "Locator Type%Object Properties"); 
				MPSPage_Data =ReadExcel.getEntireExcelSheetData(TestNGCreator.folderPath, "MPSPage",
						"Object Name / Label Name", "Locator Type%Object Properties");
				CoveoPage_Data =ReadExcel.getEntireExcelSheetData(TestNGCreator.folderPath, "CoveoPage",
						"Object Name / Label Name", "Locator Type%Object Properties");
				System.out.println("Reading Repository sheets of ESUPPORT Application Successfully done!!!!!!");
				IntegratedHomePage_Data =ReadExcel.getEntireExcelSheetData(TestNGCreator.folderPath, "IntegratedHomePage",
						"Object Name / Label Name", "Locator Type%Object Properties");
				System.out.println("Reading Repository sheets of ESUPPORT Application Successfully done!!!!!!");

				ContentHomePage_Data =ReadExcel.getEntireExcelSheetData(TestNGCreator.folderPath, "ContentPage",
						"Object Name / Label Name", "Locator Type%Object Properties");
				System.out.println("Reading Repository sheets of ESUPPORT Application Successfully done!!!!!!");

				SubscriptionHomePage_Data =ReadExcel.getEntireExcelSheetData(TestNGCreator.folderPath, "SubscriptionPage",
						"Object Name / Label Name", "Locator Type%Object Properties");
				System.out.println("Reading Repository sheets of ESUPPORT Application Successfully done!!!!!!");
				ErevenueHomePage_Data =ReadExcel.getEntireExcelSheetData(TestNGCreator.folderPath, "ErevenuePage",
						"Object Name / Label Name", "Locator Type%Object Properties");
				System.out.println("Reading Repository sheets of ESUPPORT Application Successfully done!!!!!!");
				DDLHomePage_Data =ReadExcel.getEntireExcelSheetData(TestNGCreator.folderPath, "DDLPage",
						"Object Name / Label Name", "Locator Type%Object Properties");
				System.out.println("Reading Repository sheets of ESUPPORT Application Successfully done!!!!!!");
				IPSHomePage_Data =ReadExcel.getEntireExcelSheetData(TestNGCreator.folderPath, "IPSPage",
						"Object Name / Label Name", "Locator Type%Object Properties");
				System.out.println("Reading Repository sheets of ESUPPORT IPS page Successfully done!!!!!!");
				ServiceEventsHomePage_Data =ReadExcel.getEntireExcelSheetData(TestNGCreator.folderPath, "ServiceEventsPage",
						"Object Name / Label Name", "Locator Type%Object Properties");
				System.out.println("Reading Repository sheets of ESUPPORT ServiceEvents page Successfully done");
				UnifiedPortalPage_Data =ReadExcel.getEntireExcelSheetData(TestNGCreator.folderPath, "UnifiedPortalPage",
						"Object Name / Label Name", "Locator Type%Object Properties");
				System.out.println("Reading Repository sheets of ESUPPORT UnifiedPortal page Successfully done!!!!!!");
				PortalPage_Data =ReadExcel.getEntireExcelSheetData(TestNGCreator.folderPath, "PortalPage",
						"Object Name / Label Name", "Locator Type%Object Properties");
				System.out.println("Reading Repository sheets of ESUPPORT Portal page Successfully done!!!!!!");
				
				SecurityLandingPage_Data =ReadExcel.getEntireExcelSheetData(TestNGCreator.folderPath, "SecurityLandingPage",
						"Object Name / Label Name", "Locator Type%Object Properties");
				System.out.println("Reading Repository sheets of Security Landing page Successfully done!!!!!!");
			}
			else if(environment.equalsIgnoreCase("ES4ED") || environment.equalsIgnoreCase("ES3ED")|| environment.equalsIgnoreCase("ES2ED")||environment.equalsIgnoreCase("ES1ED") || environment.equalsIgnoreCase("ESPRODED"))
			{
				System.out.println("Reading the entire Repository sheets of ESUPPORT Application(EDGE)!!!!!");

				OrderHomePage_Data = ReadExcel.getEntireExcelSheetData(TestNGCreator.folderPath, "OrderHomePage",
						"Object Name / Label Name", "Locator Type%Object Properties");

				RecentOrderPage_Data = ReadExcel.getEntireExcelSheetData(TestNGCreator.folderPath, "RecentOrderPage",
						"Object Name / Label Name", "Locator Type%Object Properties"); 
				RetailAssetPage_Data =ReadExcel.getEntireExcelSheetData(TestNGCreator.folderPath, "RetailAssetPage",
						"Object Name / Label Name", "Locator Type%Object Properties"); 
				DriversandDownloads_Data =ReadExcel.getEntireExcelSheetData(TestNGCreator.folderPath, "DriversandDownloads",
						"Object Name / Label Name", "Locator Type%Object Properties"); 
				IncidentsPage_Data =ReadExcel.getEntireExcelSheetData(TestNGCreator.folderPath, "IncidentsPage",
						"Object Name / Label Name", "Locator Type%Object Properties"); 
				MPSPage_Data =ReadExcel.getEntireExcelSheetData(TestNGCreator.folderPath, "MPSPage",
						"Object Name / Label Name", "Locator Type%Object Properties");
				CoveoPage_Data =ReadExcel.getEntireExcelSheetData(TestNGCreator.folderPath, "CoveoPage",
						"Object Name / Label Name", "Locator Type%Object Properties");
				System.out.println("Reading Repository sheets of ESUPPORT Application Successfully done!!!!!!");
				IntegratedHomePage_Data =ReadExcel.getEntireExcelSheetData(TestNGCreator.folderPath, "IntegratedHomePage",
						"Object Name / Label Name", "Locator Type%Object Properties");
				System.out.println("Reading Repository sheets of ESUPPORT Application Successfully done!!!!!!");
				ContentHomePage_Data =ReadExcel.getEntireExcelSheetData(TestNGCreator.folderPath, "ContentPage",
						"Object Name / Label Name", "Locator Type%Object Properties");
				System.out.println("Reading Repository sheets of ESUPPORT Application Successfully done!!!!!!");
				SubscriptionHomePage_Data =ReadExcel.getEntireExcelSheetData(TestNGCreator.folderPath, "SubscriptionPage",
						"Object Name / Label Name", "Locator Type%Object Properties");
				System.out.println("Reading Repository sheets of ESUPPORT Application Successfully done!!!!!!");

				ErevenueHomePage_Data =ReadExcel.getEntireExcelSheetData(TestNGCreator.folderPath, "ErevenuePage",
						"Object Name / Label Name", "Locator Type%Object Properties");
				System.out.println("Reading Repository sheets of ESUPPORT Application Successfully done!!!!!!");
				DDLHomePage_Data =ReadExcel.getEntireExcelSheetData(TestNGCreator.folderPath, "DDLPage",
						"Object Name / Label Name", "Locator Type%Object Properties");
				System.out.println("Reading Repository sheets of ESUPPORT Application Successfully done!!!!!!");
				IPSHomePage_Data =ReadExcel.getEntireExcelSheetData(TestNGCreator.folderPath, "IPSPage",
						"Object Name / Label Name", "Locator Type%Object Properties");
				System.out.println("Reading Repository sheets of ESUPPORT IPS page Successfully done!!!!!!");
				ServiceEventsHomePage_Data =ReadExcel.getEntireExcelSheetData(TestNGCreator.folderPath, "ServiceEventsPage",
						"Object Name / Label Name", "Locator Type%Object Properties");
				System.out.println("Reading Repository sheets of ESUPPORT ServiceEvents page Successfully done");
				UnifiedPortalPage_Data =ReadExcel.getEntireExcelSheetData(TestNGCreator.folderPath, "UnifiedPortalPage",
						"Object Name / Label Name", "Locator Type%Object Properties");
				System.out.println("Reading Repository sheets of ESUPPORT UnifiedPortal page Successfully done!!!!!!");
				PortalPage_Data =ReadExcel.getEntireExcelSheetData(TestNGCreator.folderPath, "PortalPage",
						"Object Name / Label Name", "Locator Type%Object Properties");
				System.out.println("Reading Repository sheets of ESUPPORT Portal page Successfully done!!!!!!");
				
				SecurityLandingPage_Data =ReadExcel.getEntireExcelSheetData(TestNGCreator.folderPath, "SecurityLandingPage",
						"Object Name / Label Name", "Locator Type%Object Properties");
				System.out.println("Reading Repository sheets of Security Landing page Successfully done!!!!!!");
			}


		}catch(Exception e)
		{
			System.out.println("Unable to read the entire repository excel file");
		}
	}




}


