package com.dell.delta_uat_automation.esupport.testcases;



import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_5836719_AMER_IE_SupportSearch_IntegratedUX_Productname_searchquery_Esupport extends BaseTest {
	@Test
	public void validate_TC_5836719_AMER_IE_SupportSearch_IntegratedUX_Productname_searchquery_Esupport() 
	{

		try
		{
			System.out.println("Starts TC# 5836719");

			obj_EsupportCoveoWorkflow.ToVerify_EnterServiceTage(driver, TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[0]);
			//obj_EsupportCoveoWorkflow.ToVerify_EnterServiceTage(driver, TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[1]);

			Thread.sleep(3000);


		}
		catch(Exception e){

			Assert.fail("Failed while executing test case TC_5836719_AMER_IE_SupportSearch_IntegratedUX_Productname_searchquery_Esupport--------->\n  "+e);

		}

	}

}

