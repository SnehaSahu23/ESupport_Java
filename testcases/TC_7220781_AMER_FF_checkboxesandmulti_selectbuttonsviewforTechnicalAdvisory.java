package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_7220781_AMER_FF_checkboxesandmulti_selectbuttonsviewforTechnicalAdvisory extends BaseTest
{
	@Test
	public void validate_TC_7220781_AMER_FF_checkboxesandmulti_selectbuttonsviewforTechnicalAdvisory() 
	{
		try
		{
			System.out.println("Starts TC_7220781_AMER_FF_checkboxesandmulti_selectbuttonsviewforTechnicalAdvisory");
			obj_EsupportPortalWorkflow.handleCookies(driver);
			obj_EsupportIPSWorkflow.Emaillogin(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			Thread.sleep(20000);
			obj_EsupportPortalWorkflow.clickHealthAndRiskTab(driver);	
			obj_EsupportPortalWorkflow.clickTechnicalAdvisoryTab(driver);
			obj_EsupportPortalWorkflow.verifyCheckboxAdvisoryRow(driver);
			obj_EsupportPortalWorkflow.verifyAdvisoryReviewAndNotApplicableButton(driver);
			//obj_EsupportPortalWorkflow.verifyAdvisoryReviewButtonTooltip(driver);
			obj_EsupportPortalWorkflow.clickAdvisoryCheckboxWithStatusNewAndClickReview(driver);
			obj_EsupportPortalWorkflow.verifyAdvisoryReviewPopupHeader(driver);
			obj_EsupportPortalWorkflow.verifyAdvisoryReviewPopupMessageUnderHeader(driver);
			obj_EsupportPortalWorkflow.verifyAdvisoryReviewPopupMessageImportantNote(driver);
			obj_EsupportPortalWorkflow.verifyAdvisoryReviewPopupSubmitAndCancelButton(driver);
			obj_EsupportPortalWorkflow.verifyAdvisoryReviewPopupCloseButtonAndCheckbox(driver);
			obj_EsupportPortalWorkflow.clickAdvisoryReviewPopupCloseButtonAndVerifyCheckbox(driver);
			obj_EsupportPortalWorkflow.clickAdvisoryReviewButton(driver);
			obj_EsupportPortalWorkflow.clickAdvisoryReviewPopupSubmitButton(driver);
			obj_EsupportPortalWorkflow.verifyAdvisoryStatusReviewedAfterSubmit(driver);
			obj_EsupportPortalWorkflow.clickIncidentManagementClearAllButton(driver);
			
			//verify Not Applicable button flow
			obj_EsupportPortalWorkflow.clickAdvisoryCheckboxWithStatusNew(driver);
			obj_EsupportPortalWorkflow.clickAdvisoryNotApplicableButton(driver);
			obj_EsupportPortalWorkflow.verifyAdvisoryReviewPopupHeader(driver);
			obj_EsupportPortalWorkflow.verifyAdvisoryReviewPopupMessageUnderHeader(driver);
			obj_EsupportPortalWorkflow.verifyAdvisoryReviewPopupMessageImportantNote(driver);
			obj_EsupportPortalWorkflow.verifyAdvisoryReviewPopupSubmitAndCancelButton(driver);
			obj_EsupportPortalWorkflow.verifyAdvisoryReviewPopupCloseButtonAndCheckbox(driver);
			obj_EsupportPortalWorkflow.clickAdvisoryReviewPopupCloseButtonAndVerifyCheckbox(driver);
			obj_EsupportPortalWorkflow.clickAdvisoryNotApplicableButton(driver);
			obj_EsupportPortalWorkflow.clickAdvisoryReviewPopupSubmitButton(driver);
			obj_EsupportPortalWorkflow.verifyAdvisoryStatusNotApplicableAfterSubmit(driver);
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_7220781_AMER_FF_checkboxesandmulti_selectbuttonsviewforTechnicalAdvisory--------->\n  "+e);
		}
	}
}