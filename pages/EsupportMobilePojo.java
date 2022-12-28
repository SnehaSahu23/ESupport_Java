package com.dell.delta_uat_automation.esupport.pages;

import java.util.Hashtable;

import com.dell.delta_uat_automation.utility.MobileReadExcel;
import com.dell.delta_uat_automation.utility.MobileTestNGCreator;

public class EsupportMobilePojo {

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
	public void storePageDataFromExcel(String Envi) {

		try
		{

			if(Envi.equalsIgnoreCase("MOB1MB") || Envi.equalsIgnoreCase("MOB2MB")|| Envi.equalsIgnoreCase("MOB3MB")||Envi.equalsIgnoreCase("MOB4MB") || Envi.equalsIgnoreCase("MOBPRODMB"))
			{
				System.out.println("Reading the entire Repository sheets of ESUPPORT Application(CHROME)!!!!!");

				OrderHomePage_Data = MobileReadExcel.getEntireExcelSheetData(MobileTestNGCreator.folderPath, "OrderHomePage",
						"Object Name / Label Name", "Locator Type%Object Properties");

				RecentOrderPage_Data = MobileReadExcel.getEntireExcelSheetData(MobileTestNGCreator.folderPath, "RecentOrderPage",
						"Object Name / Label Name", "Locator Type%Object Properties"); 
				RetailAssetPage_Data =MobileReadExcel.getEntireExcelSheetData(MobileTestNGCreator.folderPath, "RetailAssetPage",
						"Object Name / Label Name", "Locator Type%Object Properties"); 
				DriversandDownloads_Data =MobileReadExcel.getEntireExcelSheetData(MobileTestNGCreator.folderPath, "DriversandDownloads",
						"Object Name / Label Name", "Locator Type%Object Properties"); 
				IncidentsPage_Data =MobileReadExcel.getEntireExcelSheetData(MobileTestNGCreator.folderPath, "IncidentsPage",
						"Object Name / Label Name", "Locator Type%Object Properties"); 
				MPSPage_Data =MobileReadExcel.getEntireExcelSheetData(MobileTestNGCreator.folderPath, "MPSPage",
						"Object Name / Label Name", "Locator Type%Object Properties");
				CoveoPage_Data =MobileReadExcel.getEntireExcelSheetData(MobileTestNGCreator.folderPath, "CoveoPage",
						"Object Name / Label Name", "Locator Type%Object Properties");
				System.out.println("Reading Repository sheets of coveo Application Successfully done!!!!!!");
				IntegratedHomePage_Data =MobileReadExcel.getEntireExcelSheetData(MobileTestNGCreator.folderPath, "IntegratedHomePage",
						"Object Name / Label Name", "Locator Type%Object Properties");
				System.out.println("Reading Repository sheets of Integration Application Successfully done!!!!!!");
				ContentHomePage_Data =MobileReadExcel.getEntireExcelSheetData(MobileTestNGCreator.folderPath, "ContentPage",
						"Object Name / Label Name", "Locator Type%Object Properties");
				System.out.println("Reading Repository sheets of content Application Successfully done!!!!!!");
				SubscriptionHomePage_Data =MobileReadExcel.getEntireExcelSheetData(MobileTestNGCreator.folderPath, "SubscriptionPage",
						"Object Name / Label Name", "Locator Type%Object Properties");
				System.out.println("Reading Repository sheets of sunscription Application Successfully done!!!!!!");
				ErevenueHomePage_Data =MobileReadExcel.getEntireExcelSheetData(MobileTestNGCreator.folderPath, "ErevenuePage",
						"Object Name / Label Name", "Locator Type%Object Properties");
				System.out.println("Reading Repository sheets of erevenue Application Successfully done!!!!!!");
				DDLHomePage_Data =MobileReadExcel.getEntireExcelSheetData(MobileTestNGCreator.folderPath, "DDLPage",
						"Object Name / Label Name", "Locator Type%Object Properties");
				System.out.println("Reading Repository sheets of DDL ESUPPORT Application Successfully done!!!!!!");
				IPSHomePage_Data =MobileReadExcel.getEntireExcelSheetData(MobileTestNGCreator.folderPath, "IPSPage",
						"Object Name / Label Name", "Locator Type%Object Properties");
				System.out.println("Reading Repository sheets of ESUPPORT IPS page Successfully done!!!!!!");
				
				ServiceEventsHomePage_Data =MobileReadExcel.getEntireExcelSheetData(MobileTestNGCreator.folderPath, "ServiceEventsPage",
						"Object Name / Label Name", "Locator Type%Object Properties");
				System.out.println("Reading Repository sheets of ESUPPORT ServiceEvents page Successfully done");
			
				UnifiedPortalPage_Data =MobileReadExcel.getEntireExcelSheetData(MobileTestNGCreator.folderPath, "UnifiedPortalPage",
						"Object Name / Label Name", "Locator Type%Object Properties");
				System.out.println("Reading Repository sheets of ESUPPORT UnifiedPortal page Successfully done!!!!!!");
				PortalPage_Data =MobileReadExcel.getEntireExcelSheetData(MobileTestNGCreator.folderPath, "PortalPage",
						"Object Name / Label Name", "Locator Type%Object Properties");
				System.out.println("Reading Repository sheets of ESUPPORT Portal page Successfully done!!!!!!");
				
				SecurityLandingPage_Data =MobileReadExcel.getEntireExcelSheetData(MobileTestNGCreator.folderPath, "SecurityLandingPage",
						"Object Name / Label Name", "Locator Type%Object Properties");
				System.out.println("Reading Repository sheets of Security Landing page Successfully done!!!!!!");
			}
			


		}catch(Exception e)
		{
			System.out.println("Unable to read the entire repository excel file");
		}
	}




}
