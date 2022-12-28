package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_6877489_AMER_ED_Coveo_ConsistentSearchUX_SupportSearch_AppendBreadcrumbInformationOnManualsHTMLLinks_ESUPPORT extends BaseTest
{
	@Test
	public void validate_TC_6877489_AMER_ED_Coveo_ConsistentSearchUX_SupportSearch_AppendBreadcrumbInformationOnManualsHTMLLinks_ESUPPORT() 
	{
		try
		{
			System.out.println("Starts TC_6877489_AMER_ED_Coveo_ConsistentSearchUX_SupportSearch_AppendBreadcrumbInformationOnManualsHTMLLinks_ESUPPORT");
			obj_EsupportContentWorkflow.handleCookies(driver);
			obj_EsupportCoveoWorkflow.ValidateSearchForKeyword(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()), TestNGCreator.TestData.get(Esupport.Dpid.ordinal()));

			obj_EsupportCoveoWorkflow.SelectManualsAndDocuments(driver, TestNGCreator.TestData.get(Esupport.Dpid.ordinal()));
			
			obj_EsupportCoveoWorkflow.CLickOnFirstResultTitle(driver);

		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_6877489_AMER_ED_Coveo_ConsistentSearchUX_SupportSearch_AppendBreadcrumbInformationOnManualsHTMLLinks_ESUPPORT--------->\n  "+e);
		}
	}
}
