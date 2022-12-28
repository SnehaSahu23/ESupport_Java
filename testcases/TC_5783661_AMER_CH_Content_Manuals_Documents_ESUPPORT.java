
package com.dell.delta_uat_automation.esupport.testcases;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;


public class TC_5783661_AMER_CH_Content_Manuals_Documents_ESUPPORT extends BaseTest 
{
	@Test
	public void validate_TC_5783661_AMER_CH_Content_Manuals_Documents_ESUPPORT() 
	{

		try
		{
			System.out.println("Starts TC_5783661_AMER_CH_Content_Manuals_Documents_ESUPPORT");
			obj_EsupportDriverandDownloadsWorkflow.ToVerify_EnterServiceTage(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
			obj_EsupportContentWorkflow.ClickManualsandDocument_Tab(driver);
			//obj_EsupportContentWorkflow.TOVerify_IconsDocument(driver);
			obj_EsupportContentWorkflow.ToVerify_RegulatoryHeader(driver);
			obj_EsupportContentWorkflow.clickPdfLink(driver);
			obj_EsupportContentWorkflow.TOclick_HtmlLink(driver);
			
			
			
			
			
			//System.out.println(driver.getCurrentUrl());
			
			
			
		}
		catch(Exception e)
		{

			Assert.fail("Failed while TC_5783661_AMER_CH_Content_Manuals_Documents_ESUPPORT--------->\n  "+e);

		}

	}
}