package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_6095584_AMER_FF_Coveo_SupportSearch_ShowCommunityDataFromLithiumOnSERP_ESUPPORT extends BaseTest
{
	@Test
	public void validate_TC_6095584_AMER_FF_Coveo_SupportSearch_ShowCommunityDataFromLithiumOnSERP_ESUPPORT() 
	{
		try
		{
			System.out.println("Starts TC_6095584_AMER_FF_Coveo_SupportSearch_ShowCommunityDataFromLithiumOnSERP_ESUPPORT");
			
			obj_EsupportCoveoWorkflow.ValidateSearchForKeyword1WithOutDoubleQuotes(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[0], TestNGCreator.TestData.get(Esupport.Dpid.ordinal()));
			
			obj_EsupportCoveoWorkflow.SelectForumClickFirstDiplayedResultWhichHaveForumIcon(driver, TestNGCreator.TestData.get(Esupport.Dpid.ordinal()));
			
			obj_EsupportCoveoWorkflow.ValidateSearchForKeyword2WithOutDoubleQuotes(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[1], TestNGCreator.TestData.get(Esupport.Dpid.ordinal()));
			obj_EsupportCoveoWorkflow.SelectForumClickFirstDiplayedResultWhichHaveForumIcon(driver, TestNGCreator.TestData.get(Esupport.Dpid.ordinal()));
			
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_6095584_AMER_FF_Coveo_SupportSearch_ShowCommunityDataFromLithiumOnSERP_ESUPPORT--------->\n  "+e);
		}
	}
}
