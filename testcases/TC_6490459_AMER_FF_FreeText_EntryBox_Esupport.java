package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.TestNGCreator;
import com.dell.delta_uat_automation.utility.Ux;

public class TC_6490459_AMER_FF_FreeText_EntryBox_Esupport extends BaseTest
{
	@Test
	public void validate_TC_6490459_AMER_FF_FreeText_EntryBox_Esupport() 
	{

		try
		{
			System.out.println("Starts TC_6490459_AMER_FF_FreeText_EntryBox_Esupport");
			
			obj_EsupportErevenueWorkflow.handleCookies(driver);

			obj_EsupportErevenueWorkflow.EnterServiceTag(driver,TestNGCreator.TestData.get(Ux.ServiceTag.ordinal()));
			
			obj_EsupportErevenueWorkflow.Click_IssueTypeandSubIssueLink(driver);
			obj_EsupportErevenueWorkflow.ToSelect_ExpressService(driver);
			obj_EsupportErevenueWorkflow.ToValidate_Textbox_MaximumCharacters(driver);
			obj_EsupportErevenueWorkflow.ToVerify_TextboxLabel(driver);
			obj_EsupportErevenueWorkflow.Textboxfilling_mandatory(driver);
		    obj_EsupportErevenueWorkflow.ToValidate_TextboxwithSpecialCharacters(driver,"Test<>/");			
		}
		catch(Exception e)
		{
			Assert.fail("Failed while executing test case TC_6490459_AMER_FF_FreeText_EntryBox_Esupport--------->\n  "+e);
		}
	}
}
