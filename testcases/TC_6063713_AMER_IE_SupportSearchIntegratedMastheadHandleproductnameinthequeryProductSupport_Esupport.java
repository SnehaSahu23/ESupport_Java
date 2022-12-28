package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_6063713_AMER_IE_SupportSearchIntegratedMastheadHandleproductnameinthequeryProductSupport_Esupport extends BaseTest
{
	@Test
	public void validate_TC_6063713_AMER_IE_SupportSearchIntegratedMastheadHandleproductnameinthequeryProductSupport_Esupport() 
	{

		try
		{
			System.out.println("Starts TC_6063713_AMER_IE_SupportSearchIntegratedMastheadHandleproductnameinthequeryProductSupport_Esupport"); 

			obj_EsupportCoveoWorkflow.enterServiceTaginMasthead(driver, TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[0]);
			obj_EsupportCoveoWorkflow.clickLatitudeSuggestionsSupportPage(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[1]);
			obj_EsupportCoveoWorkflow.selectProductFromSupportList(driver);
			obj_EsupportCoveoWorkflow.clickLatitudeSuggestionsPCFPage(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[1]);

			//obj_EsupportCoveoWorkflow.ToVerify_searchServiceTag(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[0]);

			obj_EsupportCoveoWorkflow.ToVerify_searchServiceTagsupportpage(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[2]);
		}
		catch(Exception e)
		{
			Assert.fail("Failed while executing test case TC_6063713_AMER_IE_SupportSearchIntegratedMastheadHandleproductnameinthequeryProductSupport_Esupport--------->\n  "+e);
		}
	}
}

