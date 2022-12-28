package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_10820686_AMER_FF_Story_10817039_CXJ_FY22_JTSA_Contact_Channel_Layout_Recommended_Channel_Logic extends BaseTest
{
	@Test
	public void validate_TC_10820686_AMER_FF_Story_10817039_CXJ_FY22_JTSA_Contact_Channel_Layout_Recommended_Channel_Logic()
	{
		try
		{
			System.out.println("Starts validate_TC_10820686_AMER_FF_Story_10817039_CXJ_FY22_JTSA_Contact_Channel_Layout_Recommended_Channel_Logic");
//			obj_EsupportIncidentsWorkflow.ToVerify_EnterServiceTag_HandledPopup(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(",")[0]);
//			obj_EsupportIncidentsWorkflow.SelectIssueFromDropDown(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()));
//			obj_EsupportIncidentsWorkflow.verifyRecommendLabelForSelfServeOption(driver);
//			
//			obj_EsupportCoveoWorkflow.ToNavigate_IntegratedSupportHomePage(driver);
//			
//			obj_EsupportIPSWorkflow.searchServiceTag(driver, TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(",")[1]);
//			obj_EsupportErevenueWorkflow.selectIssueAndSubIssueFromDropdownOverviewTab(driver,
//					         TestNGCreator.TestData.get(Esupport.IssueType.ordinal()).split(",")[0],
//					         TestNGCreator.TestData.get(Esupport.IssueType.ordinal()).split(",")[1]);
//			obj_EsupportIncidentsWorkflow.verifyRecommendTileOnOverViewTab(driver);//IssueType
			
			//****************new functionality ********************
			
			obj_EsupportIncidentsWorkflow.clickOnEnterServiceTag(driver);
			obj_EsupportIncidentsWorkflow.EnterValueInServiceTagField(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(",")[0]);
			obj_EsupportIncidentsWorkflow.clickOnSubmitButtonAfterEnteringServiceTag(driver);
			obj_EsupportIncidentsWorkflow.SelectIssueFromDropDown(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()));
			Thread.sleep(10000);
			obj_EsupportIncidentsWorkflow.clickOnNextButton(driver);
			obj_EsupportIncidentsWorkflow.verifyRecommendLabelForSelfServeOption(driver);
			
			obj_EsupportCoveoWorkflow.ToNavigate_IntegratedSupportHomePage(driver);
			
			obj_EsupportIPSWorkflow.searchServiceTag(driver, TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(",")[1]);
			obj_EsupportErevenueWorkflow.selectIssueAndSubIssueFromDropdownOverviewTab(driver,
					         TestNGCreator.TestData.get(Esupport.IssueType.ordinal()).split(",")[0],
					         TestNGCreator.TestData.get(Esupport.IssueType.ordinal()).split(",")[1]);
			obj_EsupportIncidentsWorkflow.verifyRecommendTileOnOverViewTab(driver);//IssueType
		
		}
		catch(Exception e)
		{
			Assert.fail("Failed while TC_10820686_AMER_FF_Story_10817039_CXJ_FY22_JTSA_Contact_Channel_Layout_Recommended_Channel_Logic--------->\n  "+e);
		}
	}
}
