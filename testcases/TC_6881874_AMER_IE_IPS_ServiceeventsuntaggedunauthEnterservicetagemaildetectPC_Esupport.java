package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_6881874_AMER_IE_IPS_ServiceeventsuntaggedunauthEnterservicetagemaildetectPC_Esupport extends BaseTest
{
	@Test
	public void validate_TC_6881874_AMER_IE_IPS_ServiceeventsuntaggedunauthEnterservicetagemaildetectPC_Esupport() 
	{
		try
		{
			System.out.println("Starts TC_6881874_AMER_IE_IPS_ServiceeventsuntaggedunauthEnterservicetagemaildetectPC_Esupport");
			
			obj_EsupportIPSWorkflow.clickBrowseAllProductsLink(driver);
//			obj_EsupportIPSWorkflow.clickLaptopsLink(driver);
//			obj_EsupportIPSWorkflow.clickLatitudeLink(driver);
//			obj_EsupportIPSWorkflow.clickLatitudeSeries(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[0]);
//			obj_EsupportIPSWorkflow.clickLatitudeSubProduct(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[1]);
		
			obj_EsupportIPSWorkflow.SelectProductFromBrowseAll(driver);
			
			obj_EsupportIPSWorkflow.clickServiceEventsTab(driver);
			
			obj_EsupportIPSWorkflow.verifyServiceEventsTab(driver);
			obj_EsupportIPSWorkflow.enterServiceTagEmailServiceEvents(driver, TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()), TestNGCreator.TestData.get(Esupport.Email.ordinal()));
			obj_EsupportIPSWorkflow.clickSubmitButtonServiceEvents(driver);
	
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_6881874_AMER_IE_IPS_ServiceeventsuntaggedunauthEnterservicetagemaildetectPC_Esupport--------->\n  "+e);
		}
	}
}
