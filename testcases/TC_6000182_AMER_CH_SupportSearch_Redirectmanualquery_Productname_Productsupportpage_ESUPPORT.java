	

package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_6000182_AMER_CH_SupportSearch_Redirectmanualquery_Productname_Productsupportpage_ESUPPORT extends BaseTest{
	@Test
	public void validate_TC_6000182_AMER_CH_SupportSearch_Redirectmanualquery_Productname_Productsupportpage_ESUPPORT() 
	{

		try
		{
			System.out.println("Starts TC# 6000182_AMER_CH"); 
			//obj_EsupportCoveoWorkflow.ToNavigate_SupportUrl(driver);
			String home = driver.getCurrentUrl();
			obj_EsupportCoveoWorkflow.ToVerify_searchServiceTagPCFPage(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[0]);

			obj_EsupportCoveoWorkflow.ToVerify_searchServiceTagnavigate(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[1]);

			//driver.navigate().to(home);

			//obj_EsupportCoveoWorkflow.ToVerify_searchServiceTag(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[2]);
//			obj_EsupportCoveoWorkflow.ToVerify_searchServiceTag(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[2]);
//			obj_EsupportCoveoWorkflow.ToVerify_searchServiceTagsupportpage(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[3]);

			obj_EsupportCoveoWorkflow.ToVerify_searchServiceTagPCFPage(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[2]);

			obj_EsupportCoveoWorkflow.ToVerify_searchServiceTagsupportpage(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[3]);


		}catch(Exception e)
		{
			Assert.fail("Failed while executing test case TC_6000182_AMER_CH_SupportSearch_Redirectmanualquery_Productname_Productsupportpage_ESUPPORT--------->\n  "+e);
		}
	}
}

