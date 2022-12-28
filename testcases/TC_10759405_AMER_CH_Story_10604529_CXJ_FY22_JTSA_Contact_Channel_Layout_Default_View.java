package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_10759405_AMER_CH_Story_10604529_CXJ_FY22_JTSA_Contact_Channel_Layout_Default_View extends BaseTest
{
	@Test
	public void Validate_TC_10759405_AMER_CH_Story_10604529_CXJ_FY22_JTSA_Contact_Channel_Layout_Default_View()
	{
		try
		{
			System.out.println("Starts Validate_TC_10759405_AMER_CH_Story_10604529_CXJ_FY22_JTSA_Contact_Channel_Layout_Default_View");
			obj_EsupportIncidentsWorkflow.ToVerify_EnterServiceTag_HandledPopup(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
			obj_EsupportIncidentsWorkflow.verifyTheChannelNewLayOutForIssueType(driver);
		}
		catch(Exception e)
		{
			Assert.fail("Failed while TC_10759405_AMER_CH_Story_10604529_CXJ_FY22_JTSA_Contact_Channel_Layout_Default_View--------->\n  "+e);
		}
	}

}
