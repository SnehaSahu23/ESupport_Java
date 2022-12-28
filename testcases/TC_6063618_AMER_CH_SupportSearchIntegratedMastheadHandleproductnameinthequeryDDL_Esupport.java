package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_6063618_AMER_CH_SupportSearchIntegratedMastheadHandleproductnameinthequeryDDL_Esupport extends BaseTest 
{
	@Test
	public void validate_TC_6063618_AMER_CH_SupportSearchIntegratedMastheadHandleproductnameinthequeryDDL_Esupport() 
	{

		try
		{
			System.out.println("Starts TC_6063618_AMER_CH_SupportSearchIntegratedMastheadHandleproductnameinthequeryDDL_Esupport");
		
			obj_EsupportCoveoWorkflow.navigateToURL(driver, "http://www.dell.com/support/software");
			obj_EsupportCoveoWorkflow.clickLatitudeSuggestionsSupportPage(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[0]);
			obj_EsupportCoveoWorkflow.selectProductFromSupportList(driver);
		//	obj_EsupportCoveoWorkflow.clickLatitudeSuggestionsPCFPage(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[0]);			

			
			obj_EsupportCoveoWorkflow.ToVerify_searchServiceTagsupportpage(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[1]);
		}
		catch(Exception e)
		{

			Assert.fail("Failed while TC_6063618_AMER_CH_SupportSearchIntegratedMastheadHandleproductnameinthequeryDDL_Esupport--------->\n  "+e);

		}

	}
}
