package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_6000176_AMER_IE_SupportSearch_IntegratedMasthead_Handleproductquery_Diagnostics_ESUPPORT extends BaseTest{
	@Test
	public void validate_TC_6000176_AMER_IE_SupportSearch_IntegratedMasthead_Handleproductquery_Diagnostics_ESUPPORT() 
	{

		try
		{
			System.out.println("Starts TC# 6000176_AMER_IE"); 
			String home = driver.getCurrentUrl();
			obj_EsupportCoveoWorkflow.handleCookies(driver);
			obj_EsupportCoveoWorkflow.toClickDiagnosticsTools(driver);

			//obj_EsupportCoveoWorkflow.ToVerify_EnterServiceTagsupportpage(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[0]);
			obj_EsupportCoveoWorkflow.ToVerify_searchServiceTag(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[0]);
			//	obj_EsupportCoveoWorkflow.ToVerify_searchServiceTagPCFPage(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[1]);
			obj_EsupportCoveoWorkflow.selectProductFromList(driver);
			obj_EsupportCoveoWorkflow.ToVerify_searchServiceTagPCFPage(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[1]);
			obj_EsupportCoveoWorkflow.ToVerify_searchServiceTagsupportpage(driver, TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[2]);
			obj_EsupportCoveoWorkflow.ToVerify_searchServiceTagsupportpage(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[3]);
			
			driver.navigate().to("https://dell.com/support/home");

			obj_EsupportCoveoWorkflow.enterServiceTaginMasthead(driver, TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[4]);
			obj_EsupportCoveoWorkflow.ToVerify_searchServiceTag(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[0]);

			obj_EsupportCoveoWorkflow.selectProductFromList(driver);
			obj_EsupportCoveoWorkflow.ToVerify_searchServiceTagPCFPage(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[1]);
			obj_EsupportCoveoWorkflow.ToVerify_searchServiceTagsupportpage(driver, TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[2]);
			obj_EsupportCoveoWorkflow.ToVerify_searchServiceTagsupportpage(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[3]);
			
			}catch(Exception e)
		{
			Assert.fail("Failed while executing test case TC_6000176_AMER_IE_SupportSearch_IntegratedMasthead_Handleproductquery_Diagnostics_ESUPPORT--------->\n  "+e);
		}
	}
}


