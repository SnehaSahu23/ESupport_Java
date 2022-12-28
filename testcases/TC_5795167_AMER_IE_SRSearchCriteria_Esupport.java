package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_5795167_AMER_IE_SRSearchCriteria_Esupport extends BaseTest 
{
	@Test
	public void validate_TC_5795167_AMER_IE_SRSearchCriteria_Esupport() 
	{
		try
		{
			System.out.println("Starts TC_5795167_AMER_IE_SRSearchCriteria_Esupport");
			obj_EsupportIncidentsWorkflow.navigateToSRPage(driver);		
			obj_EsupportIncidentsWorkflow.toEnter_ServiceTag(driver,TestNGCreator.TestData.get(Esupport.ActionOption.ordinal()).split(";")[0],TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[0],TestNGCreator.TestData.get(Esupport.Email.ordinal()));
			Thread.sleep(5000);
			driver.navigate().back();
			obj_EsupportIncidentsWorkflow.toEnter_ServiceTag(driver,TestNGCreator.TestData.get(Esupport.ActionOption.ordinal()).split(";")[1],TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[1],TestNGCreator.TestData.get(Esupport.Email.ordinal()));
			Thread.sleep(5000);
			driver.navigate().back();
			obj_EsupportIncidentsWorkflow.toEnter_ServiceTag(driver,TestNGCreator.TestData.get(Esupport.ActionOption.ordinal()).split(";")[2],TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[2],TestNGCreator.TestData.get(Esupport.Email.ordinal()));
			
			obj_EsupportIncidentsWorkflow.verifyAdditionalInfo(driver);		
		}
		
		catch(Exception e)
		{
			Assert.fail("Failed while TC_5795167_AMER_IE_SRSearchCriteria_Esupport--------->\n  "+e);
		}

	}
}
