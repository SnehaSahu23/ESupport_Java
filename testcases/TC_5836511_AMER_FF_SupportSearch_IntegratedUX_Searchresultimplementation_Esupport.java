package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_5836511_AMER_FF_SupportSearch_IntegratedUX_Searchresultimplementation_Esupport extends BaseTest{
	@Test
	public void validate_TC_5836511_AMER_FF_SupportSearch_IntegratedUX_Searchresultimplementation_Esupport() 
	{

		try
		{
			System.out.println("Starts TC# TC_5836511_AMER_FF_SupportSearch_IntegratedUX_Searchresultimplementation_Esupport"); 
			obj_EsupportCoveoWorkflow.searchResult(driver);

		}catch(Exception e)
		{
			Assert.fail("Failed while executing test case TC_5836511_AMER_FF_SupportSearch_IntegratedUX_Searchresultimplementation_Esupport--------->\n  "+e);
		}
	}
}
