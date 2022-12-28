package com.dell.delta_uat_automation.esupport.testcases;


import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_5794711_AMER_ED_NavigationtoSRSearchpagethroughhomepage_Esupport extends BaseTest 
{
	@Test
	public void validate_TC_5794711_AMER_ED_NavigationtoSRSearchpagethroughhomepage_Esupport() 
	{
		try
		{
			System.out.println("Starts TC_5794711_AMER_ED_NavigationtoSRSearchpagethroughhomepage_Esupport");
			obj_EsupportIncidentsWorkflow.navigateToSRPagefromHomepage(driver);	
			
		}
		
		catch(Exception e)
		{
			Assert.fail("Failed while TC_5794711_AMER_ED_NavigationtoSRSearchpagethroughhomepage_Esupport--------->\n  "+e);
		}

	}
}

