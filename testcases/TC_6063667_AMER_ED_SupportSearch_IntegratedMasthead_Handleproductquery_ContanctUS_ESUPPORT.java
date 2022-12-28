package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_6063667_AMER_ED_SupportSearch_IntegratedMasthead_Handleproductquery_ContanctUS_ESUPPORT extends BaseTest{
	@Test
	public void validate_TC_6063667_AMER_ED_SupportSearch_IntegratedMasthead_Handleproductquery_ContanctUS_ESUPPORT() 
	{

		try
		{
			System.out.println("Starts TC# 6063667_AMER_ED"); 
			obj_EsupportCoveoWorkflow.clickContactUsTechnicalSupport(driver);
			//obj_EsupportCoveoWorkflow.ToVerify_EnterServiceTagsupportpage(driver,TestNGCreator.TestData.get(Esupport.OrderNumber.ordinal()));
			
			//obj_EsupportCoveoWorkflow.ToVerify_searchServiceTag(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[0]);
			obj_EsupportCoveoWorkflow.clickLatitudeSuggestionsPCFPage(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[0]);			
			//obj_EsupportCoveoWorkflow.clickLatitudeSuggestionsPCFPage(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[1]);
			obj_EsupportCoveoWorkflow.selectProductFromListPCFPage(driver);
			

			obj_EsupportCoveoWorkflow.ToVerify_searchServiceTagsupportpage(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[2]);
		

		}catch(Exception e)
		{
			Assert.fail("Failed while executing test case TC_6063667_AMER_ED_SupportSearch_IntegratedMasthead_Handleproductquery_ContanctUS_ESUPPORT--------->\n  "+e);
		}
	}
}



