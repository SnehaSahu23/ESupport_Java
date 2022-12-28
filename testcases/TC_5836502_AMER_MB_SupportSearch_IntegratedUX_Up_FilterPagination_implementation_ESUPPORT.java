package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.MobileTestNGCreator;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_5836502_AMER_MB_SupportSearch_IntegratedUX_Up_FilterPagination_implementation_ESUPPORT extends MobilePage{
	@Test
	public void validate_TC_5836502_AMER_MB_SupportSearch_IntegratedUX_Up_FilterPagination_implementation_ESUPPORT() 
	{

		try
		{
			System.out.println("Starts TC_5836502_AMER_MB_SupportSearch_IntegratedUX_Up_FilterPagination_implementation_ESUPPORT"); 
			
			  
//			System.out.println("Starts TC_9922198_AMER_MB_Drivers_LDELL_Story9911898Downloadcountandtableformatfordownloads_ESUPPORT");
			Thread.sleep(6000);
			obj_EsupportMobileWorkflow.handleCookies(driver);
			obj_EsupportMobileWorkflow.ClickExtensionsAndPinMobileView(driver);
			obj_EsupportMobileWorkflow.ClickExtensionIconAndSelectDevice(driver, "Samsung_Galaxy_S6_Portrait");
            obj_EsupportMobileWorkflow.Switch_To_Mobile_window(driver);
            Thread.sleep(6000);
			
            obj_EsupportMobileWorkflow.searchResultfornosound(driver,MobileTestNGCreator.TestData.get(Esupport.SupportValue.ordinal()));
            obj_EsupportMobileWorkflow.ToVerify_clickKnowledgebase(driver);
            obj_EsupportMobileWorkflow.ToVerify_YourFilters(driver);
            obj_EsupportMobileWorkflow.ToVerify_Paginationvalues(driver);
            obj_EsupportMobileWorkflow.ToVerify_PaginationvaluesPerPage(driver);
            obj_EsupportMobileWorkflow.ToVerify_PrevandNextbuttonicon(driver);
            obj_EsupportMobileWorkflow.ToVerify_TablesdataHundred(driver,"100");
            obj_EsupportMobileWorkflow.ToVerify_TablesdataFifty(driver,"50");
            obj_EsupportMobileWorkflow.ToVerify_TablesdataTwentyfive(driver,"25");
            obj_EsupportMobileWorkflow.ToVerify_Tablesdata(driver,"10");
            obj_EsupportMobileWorkflow.ToVerify_ByRelevance(driver); 
            obj_EsupportMobileWorkflow.ToVerify_Datefunctiondescending(driver,"Descending Order");
            obj_EsupportMobileWorkflow.ToVerify_DatefunctionAscending(driver,"Ascending Order");


		}catch(Exception e)
		{
			Assert.fail("Failed while executing test case TC_5836502_AMER_MB_SupportSearch_IntegratedUX_Up_FilterPagination_implementation_ESUPPORT--------->\n  "+e);
		}
	}
}