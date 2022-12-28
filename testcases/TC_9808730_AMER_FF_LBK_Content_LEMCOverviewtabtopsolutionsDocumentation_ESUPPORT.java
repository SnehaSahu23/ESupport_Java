package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_9808730_AMER_FF_LBK_Content_LEMCOverviewtabtopsolutionsDocumentation_ESUPPORT extends BaseTest {


	@Test
	public void validate_TC_9808730_AMER_FF_LBK_Content_LEMCOverviewtabtopsolutionsDocumentation_ESUPPORT() 
	{
		try
		{
			System.out.println("Starts TC_9808730_AMER_FF_LBK_Content_LEMCOverviewtabtopsolutionsDocumentation_ESUPPORT()");
			obj_EsupportContentWorkflow.handleCookies(driver);
			//Level 10
			obj_EsupportContentWorkflow.ClickSearchServiceTag(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[0]);
			obj_EsupportContentWorkflow.ClickReadMoreHyperlink(driver);
			obj_EsupportContentWorkflow.ClickViewAll(driver);
			obj_EsupportContentWorkflow.UnexpectedPopup_Prod(driver);
			//Level 30
			obj_EsupportCoveoWorkflow.ToNavigate_IPShomepage(driver);
			obj_EsupportIPSWorkflow.clickSignIn(driver);
			obj_EsupportIPSWorkflow.Emaillogin(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()).split(";")[0],TestNGCreator.TestData.get(Esupport.Password.ordinal()).split(";")[0]);

			obj_EsupportContentWorkflow.ClickSearchServiceTag(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[1]);
			obj_EsupportContentWorkflow.ClickReadMoreHyperlink(driver);
			obj_EsupportContentWorkflow.ClickViewAll(driver);
			obj_EsupportIPSWorkflow.signOut(driver);
			//Level 40
			obj_EsupportCoveoWorkflow.ToNavigate_IPShomepage(driver);
			obj_EsupportIPSWorkflow.clickSignIn(driver);
			obj_EsupportIPSWorkflow.Emaillogin(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()).split(";")[1],TestNGCreator.TestData.get(Esupport.Password.ordinal()).split(";")[1]);

			obj_EsupportContentWorkflow.ClickSearchServiceTag(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[2]);
			obj_EsupportContentWorkflow.ClickReadMoreHyperlink(driver);
			obj_EsupportContentWorkflow.ClickViewAll(driver);
			obj_EsupportIPSWorkflow.signOut(driver);
			//Level 50
			obj_EsupportCoveoWorkflow.ToNavigate_IPShomepage(driver);
			obj_EsupportIPSWorkflow.clickSignIn(driver);
//			obj_EsupportIPSWorkflow.Emaillogin(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			obj_EsupportIPSWorkflow.clickSignInHereLink(driver);
			
			obj_EsupportContentWorkflow.ClickSearchServiceTag(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[3]);
			obj_EsupportContentWorkflow.ClickReadMoreHyperlink(driver);
			obj_EsupportContentWorkflow.ClickViewAll(driver);
			obj_EsupportIPSWorkflow.signOut(driver);
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_9808730_AMER_FF_LBK_Content_LEMCOverviewtabtopsolutionsDocumentation_ESUPPORT()--------->\n  "+e);
		}
	}
}
