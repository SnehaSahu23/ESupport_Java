package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_6000178_AMER_CH_SupportSearchIntegratedMastheadHandleproductnameinthequeryHome_Esupport extends BaseTest
{
	@Test
	public void validate_TC_6000178_AMER_CH_SupportSearchIntegratedMastheadHandleproductnameinthequeryHome_Esupport() 
	{

		try
		{
			System.out.println("Starts 6000178_AMER_CH_SupportSearchIntegratedMastheadHandleproductnameinthequeryHome_Esupport"); 
			obj_EsupportCoveoWorkflow.clickLatitudeSuggestionsSupportPage(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[0]);
			obj_EsupportCoveoWorkflow.selectProductFromSupportList(driver);
		//	obj_EsupportCoveoWorkflow.ToVerify_searchServiceTag(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[0]);
			obj_EsupportCoveoWorkflow.clickLatitudeSuggestionsPCFPage(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[0]);			

			
			obj_EsupportCoveoWorkflow.ToVerify_searchServiceTagsupportpage(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[1]);
		}
		catch(Exception e)
		{
			Assert.fail("Failed while executing test case 6000178_AMER_CH_SupportSearchIntegratedMastheadHandleproductnameinthequeryHome_Esupport--------->\n  "+e);
		}
	}
}


