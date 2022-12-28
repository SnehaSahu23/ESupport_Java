package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_6025720_AMER_IE_SupportSearch_IntegratedMasthead_Handleproductquery_Drivers_ESUPPORT extends BaseTest{
	@Test
	public void validate_TC_6025720_AMER_IE_SupportSearch_IntegratedMasthead_Handleproductquery_Drivers_ESUPPORT() 
	{

		try
		{
			System.out.println("Starts TC# 6025720_AMER_IE"); 
			
			driver.navigate().to("https://www.dell.com/support/home/ae/en/aebsdt1/product-support/servicetag/dnpk882/drivers");
			obj_EsupportCoveoWorkflow.clickLatitudeSuggestionsSupportPage(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[0]);
			obj_EsupportCoveoWorkflow.selectProductFromSupportList(driver);

			obj_EsupportCoveoWorkflow.ToVerify_searchServiceTagPCFPage(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[0]);

			obj_EsupportCoveoWorkflow.ToVerify_searchServiceTagsupportpage(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[1]);

			driver.navigate().to("https://www.dell.com/support/home");
			obj_EsupportCoveoWorkflow.clickDriversDownloads(driver);
			obj_EsupportCoveoWorkflow.clickLatitudeSuggestionsSupportPage(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[0]);
			obj_EsupportCoveoWorkflow.selectProductFromSupportList(driver);
			obj_EsupportCoveoWorkflow.ToVerify_searchServiceTagPCFPage(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[0]);

			obj_EsupportCoveoWorkflow.ToVerify_searchServiceTagsupportpage(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[1]);


		}catch(Exception e)
		{
			Assert.fail("Failed while executing test case TC_6025720_AMER_IE_SupportSearch_IntegratedMasthead_Handleproductquery_Drivers_ESUPPORT--------->\n  "+e);
		}
	}
}


