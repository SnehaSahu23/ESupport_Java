package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_6881229_AMER_IE_IPS_LDellMnAdocumentationtabinterlock_Esupport extends BaseTest
{
	@Test
	public void validate_TC_6881229_AMER_IE_IPS_LDellMnAdocumentationtabinterlock_Esupport() 
	{
		try
		{
			System.out.println("Starts TC_6881229_AMER_IE_IPS_LDellMnAdocumentationtabinterlock_Esupport");
			
			obj_EsupportIPSWorkflow.searchServiceTag(driver, TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
		
			obj_EsupportIPSWorkflow.verifyDocumentationTab(driver);	
			obj_EsupportIPSWorkflow.clickDocumentationTab(driver);	
		}
		catch(Exception e)
		{
			Assert.fail("FailIE in TC_6881229_AMER_IE_IPS_LDellMnAdocumentationtabinterlock_Esupport--------->\n  "+e);
		}
	}
}
