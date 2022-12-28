
package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_5837117_AMER_IE_MastHead_SearchOptions_ESUPPORT extends BaseTest 
{
	@Test
	public void validate_TC_5837117_AMER_IE_MastHead_SearchOptions_ESUPPORT() 
	{

		try
		{
			System.out.println("Starts TC_5837117_AMER_CH_MastHead_SearchOptions_ESUPPORT");
			obj_EsupportCoveoWorkflow.handleCookies(driver);
//			obj_EsupportCoveoWorkflow.toVerify_MastHead_Search(driver);
//			obj_EsupportCoveoWorkflow.toVerify_DomainSelector_Dropdown(driver);
//			obj_EsupportCoveoWorkflow.toVerify_Support_Dropdown(driver);
			obj_EsupportCoveoWorkflow.Select_Search_Values(driver, TestNGCreator.TestData.get(Esupport.SupportValue.ordinal()).split(";")[0], "Support");
			//driver.navigate().back();
			driver.navigate().to("https://www.dell.com/support/home/us/en/19");
			obj_EsupportCoveoWorkflow.Select_Search_Values(driver, TestNGCreator.TestData.get(Esupport.DellcomValue.ordinal()).split(";")[0], "All Dell.com");
			driver.navigate().to("https://www.dell.com/support/home/us/en/19");
//			Thread.sleep(10000);
//			obj_EsupportCoveoWorkflow.selectSupportfromDropdown(driver,  "Support");
//			obj_EsupportCoveoWorkflow.clickLatitudeSuggestionsSupportPage(driver,TestNGCreator.TestData.get(Esupport.SupportValue.ordinal()).split(";")[1]);
			obj_EsupportCoveoWorkflow.SearchLatiInMastHeadAndSearchAutoDisplayedResults(driver);
			
		}
		catch(Exception e)
		{

			Assert.fail("Failed while TC_5837117_AMER_IE_MastHead_SearchOptions_ESUPPORT--------->\n  "+e);

		}

	}
}



