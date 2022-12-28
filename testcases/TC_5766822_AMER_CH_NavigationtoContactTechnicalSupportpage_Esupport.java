package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_5766822_AMER_CH_NavigationtoContactTechnicalSupportpage_Esupport extends BaseTest
{
	@Test
	public void validate_TC_5766822_AMER_CH_NavigationtoContactTechnicalSupportpage_Esupport() 
	{
		try
		{
			System.out.println("Starts TC_5766822_AMER_CH_NavigationtoContactTechnicalSupportpage_Esupport");
			obj_EsupportIncidentsWorkflow.ToVerifyURL(driver);
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_5766822_AMER_CH_NavigationtoContactTechnicalSupportpage_Esupport--------->\n  "+e);
		}
	}

}
