package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_5836511_AMER_CH_SupportSearch_IntegratedUX_Searchresultimplementation_Esupport extends BaseTest{
	@Test
	public void validate_TC_5836511_AMER_CH_SupportSearch_IntegratedUX_Searchresultimplementation_Esupport() 
	{

		try
		{
			System.out.println("Starts TC# 5836511"); 
			obj_EsupportCoveoWorkflow.searchResult(driver);

		}catch(Exception e)
		{
			Assert.fail("Failed while executing test case TC_5836511_AMER_CH_SupportSearch_IntegratedUX_Searchresultimplementation_Esupport--------->\n  "+e);
		}
	}
}
