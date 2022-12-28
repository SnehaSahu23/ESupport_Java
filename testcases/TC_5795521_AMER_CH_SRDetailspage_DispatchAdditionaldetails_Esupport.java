

package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_5795521_AMER_CH_SRDetailspage_DispatchAdditionaldetails_Esupport extends BaseTest 
{
	@Test
	public void validate_TC_5795521_AMER_CH_SRDetailspage_DispatchAdditionaldetails_Esupport() 
	{
		try
		{
			System.out.println("Starts TC_5795521_AMER_CH_SRDetailspage_DispatchAdditionaldetails_Esupport");
			obj_EsupportIncidentsWorkflow.navigateToSRPage(driver);
			
			obj_EsupportIncidentsWorkflow.toEnter_ServiceTag(driver,TestNGCreator.TestData.get(Esupport.ActionOption.ordinal()),TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()),TestNGCreator.TestData.get(Esupport.Email.ordinal()));
			
			obj_EsupportIncidentsWorkflow.ToClick_Verifydispatchclick(driver);
			
			
			
			
			Thread.sleep(10000);
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_5795521_AMER_CH_SRDetailspage_DispatchAdditionaldetails_Esupport--------->\n  "+e);
		}
	}
}
