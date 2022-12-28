package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_5836719_AMER_FF_SupportSearch_IntegratedUX_Productname_searchquery_Esupport extends BaseTest {
	@Test
	public void validate_TC_5836719_AMER_FF_SupportSearch_IntegratedUX_Productname_searchquery_Esupport() 
	{

		try
		{
			System.out.println("Starts TC# TC_5836719_AMER_FF_SupportSearch_IntegratedUX_Productname_searchquery_Esupport");
			String home =driver.getCurrentUrl();
			obj_EsupportCoveoWorkflow.ToVerify_EnterServiceTage(driver, TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[0]);
//			driver.navigate().refresh();
//			driver.navigate().back();
//			driver.navigate().to(home);
//			obj_EsupportCoveoWorkflow.ToVerify_EnterServiceTage(driver, TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[1]);

			Thread.sleep(3000);


		}
		catch(Exception e){

			Assert.fail("Failed while executing test case TC_5836719_AMER_FF_SupportSearch_IntegratedUX_Productname_searchquery_Esupport--------->\n  "+e);

		}

	}

}
