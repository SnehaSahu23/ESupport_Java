

package com.dell.delta_uat_automation.esupport.pages;

import org.openqa.selenium.By;

import com.dell.delta_uat_automation.utility.CommonUtility;

public class EsupportSubscriptionHomePage extends EsupportPojo{
//Parul:30nov2018
		
	public By Signinclick() throws Exception
    {
          return CommonUtility.getLocator(SubscriptionHomePage_Data.get("Signinclick"));
    }
	
	public By UserName() throws Exception
    {
          return CommonUtility.getLocator(SubscriptionHomePage_Data.get("UserName"));
    }
	
	public By Password() throws Exception
    {
          return CommonUtility.getLocator(SubscriptionHomePage_Data.get("Password"));
    }
	
	public By SignIn() throws Exception
    {
          return CommonUtility.getLocator(SubscriptionHomePage_Data.get("SignIn"));
    }
	public By ClickOnSubscription() throws Exception
    {
          return CommonUtility.getLocator(SubscriptionHomePage_Data.get("ClickOnSubscription"));
    }
	public By ClickonD410Product() throws Exception
    {
          return CommonUtility.getLocator(SubscriptionHomePage_Data.get("ClickonD410Product"));
    }
	
	public By CancelButton() throws Exception
    {
          return CommonUtility.getLocator(SubscriptionHomePage_Data.get("CancelButton"));
    }
	
	public By SupportnotificationHeader() throws Exception
    {
          return CommonUtility.getLocator(SubscriptionHomePage_Data.get("SupportnotificationHeader"));
    }
	
	public By Supportnotificationfields() throws Exception
    {
          return CommonUtility.getLocator(SubscriptionHomePage_Data.get("Supportnotificationfields"));
    }
	
	//sudha
	
	
	public By premierSignIn() throws Exception
	{
	      return CommonUtility.getLocator(SubscriptionHomePage_Data.get("PremierSignIn"));
	}
	    public By PremierSignInHeading() throws Exception
	{
	      return CommonUtility.getLocator(SubscriptionHomePage_Data.get("PremierSignInHeading"));
	}
	    public By PremierHomeHeader() throws Exception
	{
	      return CommonUtility.getLocator(SubscriptionHomePage_Data.get("PremierHomeHeader"));
	}
	    
	    //sudha 6thFeb
	    public By SupportPageHeader() throws Exception
		{
		      return CommonUtility.getLocator(SubscriptionHomePage_Data.get("SupportPageHeader"));
		}
	    public By TypeofNotification2() throws Exception
		{
		      return CommonUtility.getLocator(SubscriptionHomePage_Data.get("TypeofNotification2"));
		}
	    public By TypeofNotification1() throws Exception
		{
		      return CommonUtility.getLocator(SubscriptionHomePage_Data.get("TypeofNotification1"));
		}
	    public By NewSubscription() throws Exception
		{
		      return CommonUtility.getLocator(SubscriptionHomePage_Data.get("NewSubscription"));
		}
	    
	    public By latitudeSeries() throws Exception
		{
		      return CommonUtility.getLocator(SubscriptionHomePage_Data.get("LatitudeSeries"));
		}
	    
	    
	    public By latitudeProduct() throws Exception
	  		{
	  		      return CommonUtility.getLocator(SubscriptionHomePage_Data.get("LatitudeProduct"));
	  		}
	  		
	  		 public By HeaderOfProductSelected() throws Exception
	  		{
	  		      return CommonUtility.getLocator(SubscriptionHomePage_Data.get("HeaderOfProductSelected"));
	  		}

}

