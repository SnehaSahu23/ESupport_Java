package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_5795211_AMER_IE_SR_Grid_page_ESUPPORT extends BaseTest 
{
	@Test
	public void validate_TC_5795211_AMER_IE_SR_Grid_page_ESUPPORT() 
	{

		try
		{
			
			System.out.println("Starts TC_5795211_AMER_IE_SR_Grid_page_ESUPPORT");
			obj_EsupportIncidentsWorkflow.navigateToSRPage(driver);
			obj_EsupportIncidentsWorkflow.toEnter_ServiceTag(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()),TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()),TestNGCreator.TestData.get(Esupport.Email.ordinal()));
			
			obj_EsupportIncidentsWorkflow.toValidate_SRGridPage(driver);
			obj_EsupportIncidentsWorkflow.toclick_DPScountnumber(driver);
			obj_EsupportIncidentsWorkflow.Click_closebutton(driver);

		}
		catch(Exception e)
		{

			Assert.fail("Failed while TC_5795211_AMER_IE_SR_Grid_page_ESUPPORT--------->\n  "+e);

		}

	}
}