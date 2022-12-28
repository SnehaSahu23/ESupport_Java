package com.dell.delta_uat_automation.esupport.testcases;





import java.io.File;
import java.io.IOException;

import org.apache.log4j.MDC;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.dell.delta_uat_automation.esupport.workflows.EsupportContentWorkflow;
import com.dell.delta_uat_automation.esupport.workflows.EsupportCoveoWorkflow;
import com.dell.delta_uat_automation.esupport.workflows.EsupportDDLWorkflow;
import com.dell.delta_uat_automation.esupport.workflows.EsupportDriverandDownloadsWorkflow;
import com.dell.delta_uat_automation.esupport.workflows.EsupportErevenueWorkflow;
import com.dell.delta_uat_automation.esupport.workflows.EsupportIncidentsWorkflow;
import com.dell.delta_uat_automation.esupport.workflows.EsupportIntegratedHomePageWorkflow;
import com.dell.delta_uat_automation.esupport.workflows.EsupportMPSWorkflow;
import com.dell.delta_uat_automation.esupport.workflows.EsupportMobileWorkFlow;
import com.dell.delta_uat_automation.esupport.workflows.EsupportOrderHomeWorkflow;
import com.dell.delta_uat_automation.esupport.workflows.EsupportPortalWorkflow;
import com.dell.delta_uat_automation.esupport.workflows.EsupportProductionValidationsWorkflow;
import com.dell.delta_uat_automation.esupport.workflows.EsupportIPSWorkflow;
import com.dell.delta_uat_automation.esupport.workflows.EsupportRecentOrderWorkflow;
import com.dell.delta_uat_automation.esupport.workflows.EsupportRetailAssetWorkflow;
import com.dell.delta_uat_automation.esupport.workflows.EsupportSEOWorkflow;
import com.dell.delta_uat_automation.esupport.workflows.EsupportSecurityLandingPageWorkflow;
import com.dell.delta_uat_automation.esupport.workflows.EsupportServiceEventsWorkflow;
import com.dell.delta_uat_automation.esupport.workflows.EsupportSubscriptionWorkflow;
import com.dell.delta_uat_automation.esupport.workflows.EsupportUnifiedPortalWorkflow;

import com.dell.delta_uat_automation.utility.BrowserInitialization;
import com.dell.delta_uat_automation.utility.CommonUtility;
import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;
import com.dell.delta_uat_automation.utility.WebDriverListener;



public class BaseTest extends BrowserInitialization
{
	
	
	//----------UX WORKFLOW OBJECTS---------------------------------------------------------
	//public AeonWorkFlow obj_AeonWorkFlow=new AeonWorkFlow();
	
	public EsupportOrderHomeWorkflow obj_EsupportOrderHomeWorkflow = new EsupportOrderHomeWorkflow(); 
	public EsupportRecentOrderWorkflow obj_EsupportRecentOrderWorkflow = new EsupportRecentOrderWorkflow();
	public EsupportRetailAssetWorkflow obj_EsupportRetailAssetWorkflow = new EsupportRetailAssetWorkflow();
	public EsupportDriverandDownloadsWorkflow obj_EsupportDriverandDownloadsWorkflow = new EsupportDriverandDownloadsWorkflow();
	public EsupportIncidentsWorkflow obj_EsupportIncidentsWorkflow = new EsupportIncidentsWorkflow();
	public EsupportMPSWorkflow obj_EsupportMPSWorkflow = new EsupportMPSWorkflow();
	public EsupportCoveoWorkflow obj_EsupportCoveoWorkflow = new EsupportCoveoWorkflow();
	public EsupportIntegratedHomePageWorkflow obj_EsupportIntegratedHomePageWorkflow = new EsupportIntegratedHomePageWorkflow();
	public EsupportContentWorkflow obj_EsupportContentWorkflow = new EsupportContentWorkflow();
	
	public EsupportSubscriptionWorkflow obj_EsupportSubscriptionWorkflow = new EsupportSubscriptionWorkflow();
	public EsupportErevenueWorkflow obj_EsupportErevenueWorkflow = new EsupportErevenueWorkflow();
	public EsupportDDLWorkflow obj_EsupportDDLWorkflow = new EsupportDDLWorkflow();
	public EsupportIPSWorkflow obj_EsupportIPSWorkflow = new EsupportIPSWorkflow();
	public EsupportServiceEventsWorkflow obj_EsupportServiceEventsWorkflow = new EsupportServiceEventsWorkflow();
	public EsupportUnifiedPortalWorkflow obj_EsupportUnifiedPortalWorkflow = new EsupportUnifiedPortalWorkflow();
	public EsupportPortalWorkflow obj_EsupportPortalWorkflow = new EsupportPortalWorkflow();
	public EsupportProductionValidationsWorkflow obj_EsupportProductionValidationsWorkflow = new EsupportProductionValidationsWorkflow();
	public EsupportSecurityLandingPageWorkflow obj_EsupportSecurityLandingPageWorkflow = new EsupportSecurityLandingPageWorkflow();
	public EsupportSEOWorkflow obj_EsupportSEOWorkflow = new EsupportSEOWorkflow();
	public EsupportMobileWorkFlow obj_EsupportMobileWorkflow = new EsupportMobileWorkFlow();
	
	//	public GttWorkFlow obj_GttWorkFlow=new GttWorkFlow(); 
	

	//----------END OF UX WORKFLOW OBJECTS-------------------------------------------------- 

	//----------UI WORKFLOW OBJECTS-------------------------------------------------------------


	
	//----------END OF UI WORKFLOW OBJECTS------------------------------------------------------
	
	

}
