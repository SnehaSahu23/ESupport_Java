package com.dell.delta_uat_automation.esupport.testcases;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_6106869_AMER_CH_alertexpire_Expiredservicetag_productsupportDashboard_ESUPPORT extends BaseTest{

	@Test
	public void validate_TC_6106869_AMER_CH_alertexpire_Expiredservicetag_productsupportDashboard_ESUPPORT(){


		try
		{
			System.out.println("Starting TC_6106869_AMER_CH_alertexpire_Expiredservicetag_productsupportDashboard_ESUPPORT..."); 

			System.out.println("Integrated HomePage.");
			//Scenario1
			obj_EsupportIntegratedHomePageWorkflow.ToVerify_EnterServiceTags(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[0]);

			obj_EsupportIntegratedHomePageWorkflow.TOverify_AboutToExpiretext(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[0]);
			obj_EsupportIntegratedHomePageWorkflow.TOClick_AbouttoExpiretextClickHere(driver);
			obj_EsupportIntegratedHomePageWorkflow.TOclick_SupportBreadcrumbs(driver);
			//scenario2
			obj_EsupportIntegratedHomePageWorkflow.ToVerify_EnterServiceTags(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[1]);
			obj_EsupportIntegratedHomePageWorkflow.TOverify_Expiretext(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[1]);
			obj_EsupportIntegratedHomePageWorkflow.TOClick_ExpiretextClickHere(driver);


			Thread.sleep(5000);



		}catch(Exception e)
		{
			Assert.fail("Failed while executing test case TC_6106869_AMER_CH_alertexpire_Expiredservicetag_productsupportDashboard_ESUPPORT--------->\n  "+e);
		}
	}

}


