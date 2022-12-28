package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_5795573_AMER_FF_ContactOrderSupport_SearchCriteriaDPID_OrderNumber_OtherLookupOptions_Esupport extends BaseTest 
{
	@Test
	public void validate_TC_5795573_AMER_FF_ContactOrderSupport_SearchCriteriaDPID_OrderNumber_OtherLookupOptions_Esupport() 
	{

		try
		{
			System.out.println("Starts TC_5795573_AMER_FF_ContactOrderSupport_SearchCriteriaDPID_OrderNumber_OtherLookupOptions_Esupport");

			obj_EsupportIncidentsWorkflow.ToVerify_ContanctOrderSupport(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
            obj_EsupportIncidentsWorkflow.ToVerify_ClickContanctOrderSupportSearch(driver,TestNGCreator.TestData.get(Esupport.Dpid.ordinal()).split(";")[0]);
			obj_EsupportIncidentsWorkflow.ToVerify_ClickContanctOrderSupportSearch(driver,TestNGCreator.TestData.get(Esupport.OrderNumber.ordinal()).split(";")[0]);

			obj_EsupportIncidentsWorkflow.ToVerify_ClickLookupoptions(driver,TestNGCreator.TestData.get(Esupport.FirstName.ordinal()).split(";")[0],TestNGCreator.TestData.get(Esupport.CustomerNumber.ordinal()),TestNGCreator.TestData.get(Esupport.PostalCode.ordinal()).split(";")[0],TestNGCreator.TestData.get(Esupport.PostalCode.ordinal()).split(";")[1],TestNGCreator.TestData.get(Esupport.PhoneNumber.ordinal()));
			
			driver.navigate().back();
			Thread.sleep(10000);
			obj_EsupportIncidentsWorkflow.ToVerify_ClickLookupoptions(driver,TestNGCreator.TestData.get(Esupport.FirstName.ordinal()).split(";")[1],TestNGCreator.TestData.get(Esupport.PONumber.ordinal()),TestNGCreator.TestData.get(Esupport.FirstName.ordinal()).split(";")[0],TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()),TestNGCreator.TestData.get(Esupport.PhoneNumber.ordinal()));

			


		}
		catch(Exception e)
		{

			Assert.fail("Failed while TC_5795573_AMER_FF_ContactOrderSupport_SearchCriteriaDPID_OrderNumber_OtherLookupOptions_Esupport--------->\n  "+e);

		}

	}
}
