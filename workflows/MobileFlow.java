package com.dell.delta_uat_automation.esupport.workflows;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.dell.delta_uat_automation.esupport.pages.EsupportContentHomePage;
import com.dell.delta_uat_automation.esupport.pages.EsupportCoveoPage;
import com.dell.delta_uat_automation.esupport.pages.EsupportDDLHomePage;
import com.dell.delta_uat_automation.esupport.pages.EsupportDriversandDownloadsPage;
import com.dell.delta_uat_automation.esupport.pages.EsupportErevenueHomePage;
import com.dell.delta_uat_automation.esupport.pages.EsupportIPSPage;
import com.dell.delta_uat_automation.esupport.pages.EsupportIncidentsPage;
import com.dell.delta_uat_automation.esupport.pages.EsupportIntegratedHomePage;
import com.dell.delta_uat_automation.esupport.pages.EsupportMPSPage;
import com.dell.delta_uat_automation.esupport.pages.EsupportMobieSEOPage;
import com.dell.delta_uat_automation.esupport.pages.EsupportMobileContentHomePage;
import com.dell.delta_uat_automation.esupport.pages.EsupportMobileCoveoPage;
import com.dell.delta_uat_automation.esupport.pages.EsupportMobileDDLHomePage;
import com.dell.delta_uat_automation.esupport.pages.EsupportMobileDriversandDownloadsPage;
import com.dell.delta_uat_automation.esupport.pages.EsupportMobileErevenueHomePage;
import com.dell.delta_uat_automation.esupport.pages.EsupportMobileIPSPage;
import com.dell.delta_uat_automation.esupport.pages.EsupportMobileIncidentsPage;
import com.dell.delta_uat_automation.esupport.pages.EsupportMobileIntegratedHomePage;
import com.dell.delta_uat_automation.esupport.pages.EsupportMobileMPSPage;
import com.dell.delta_uat_automation.esupport.pages.EsupportMobileOrderHomePage;
import com.dell.delta_uat_automation.esupport.pages.EsupportMobilePortalPage;
import com.dell.delta_uat_automation.esupport.pages.EsupportMobileRecentOrderPage;
import com.dell.delta_uat_automation.esupport.pages.EsupportMobileSecurityLandingPage;
import com.dell.delta_uat_automation.esupport.pages.EsupportMobileServiceEventsPage;
import com.dell.delta_uat_automation.esupport.pages.EsupportMobileUnifiedPortalPage;
import com.dell.delta_uat_automation.esupport.pages.EsupportOrderHomePage;
import com.dell.delta_uat_automation.esupport.pages.EsupportPortalPage;
import com.dell.delta_uat_automation.esupport.pages.EsupportRecentOrderPage;
import com.dell.delta_uat_automation.esupport.pages.EsupportRetailAssetPage;
import com.dell.delta_uat_automation.esupport.pages.EsupportSEOPage;
import com.dell.delta_uat_automation.esupport.pages.EsupportSecurityLandingPage;
import com.dell.delta_uat_automation.esupport.pages.EsupportServiceEventsPage;
import com.dell.delta_uat_automation.esupport.pages.EsupportSubscriptionHomePage;
import com.dell.delta_uat_automation.esupport.pages.EsupportUnifiedPortalPage;
import com.dell.delta_uat_automation.utility.CommonUtility;
import com.dell.delta_uat_automation.utility.Log;

public class MobileFlow {


	
	//public EsupportHomePage obj_EsupportHomePage = new EsupportHomePage();
	
	//public CsFlowDashboardPage obj_CsFlowDashboard = new CsFlowDashboardPage(); 
	
	//static EsupportHomePage obj_EsupportHomePage = new EsupportHomePage();
	public EsupportMobileOrderHomePage obj_EsupportOrderHomePage = new EsupportMobileOrderHomePage();
	public EsupportMobileRecentOrderPage obj_EsupportRecentOrderPage = new EsupportMobileRecentOrderPage(); 
//	public EsupportMobileRetailAssetPage obj_EsupportRetailAssetPage = new EsupportMobileRetailAssetPage(); 
	public EsupportMobileDriversandDownloadsPage obj_EsupportDriversandDownloadsPage = new EsupportMobileDriversandDownloadsPage(); 
	public EsupportMobileIncidentsPage obj_EsupportMobileIncidentsPage = new EsupportMobileIncidentsPage(); 
	public EsupportMobileMPSPage obj_EsupportMPSPage = new EsupportMobileMPSPage();
	public EsupportMobileCoveoPage obj_EsupportCoveoPage = new EsupportMobileCoveoPage();
    public EsupportMobileIntegratedHomePage obj_EsupportIntegratedHomePage = new EsupportMobileIntegratedHomePage();
    public EsupportMobileContentHomePage obj_EsupportContentHomePage = new EsupportMobileContentHomePage();
//    public EsupportMobileSubscriptionHomePage obj_EsupportSubscriptionHomePage = new EsupportMobileSubscriptionHomePage();
    public EsupportMobileErevenueHomePage obj_EsupportErevenueHomePage = new EsupportMobileErevenueHomePage();
    public EsupportMobileDDLHomePage obj_EsupportDDLHomePage = new EsupportMobileDDLHomePage();
    public EsupportMobileIPSPage obj_EsupportIPSHomePage = new EsupportMobileIPSPage();
    public EsupportMobileServiceEventsPage obj_EsupportServiceEventsHomePage = new EsupportMobileServiceEventsPage();
    public EsupportMobileUnifiedPortalPage obj_UnifiedPortalPage = new EsupportMobileUnifiedPortalPage();
    public EsupportMobilePortalPage obj_PortalPage = new EsupportMobilePortalPage();
    public EsupportMobileSecurityLandingPage obj_SecurityLandingPage = new EsupportMobileSecurityLandingPage();
    public EsupportMobieSEOPage obj_SEOPage = new EsupportMobieSEOPage();
    
	
}

