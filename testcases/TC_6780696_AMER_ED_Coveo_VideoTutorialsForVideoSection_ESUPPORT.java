package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_6780696_AMER_ED_Coveo_VideoTutorialsForVideoSection_ESUPPORT extends BaseTest
{
	@Test
	public void validate_TC_6780696_AMER_ED_Coveo_VideoTutorialsForVideoSection_ESUPPORT() 
	{
		try
		{
			System.out.println("Starts TC_6780696_AMER_ED_Coveo_VideoTutorialsForVideoSection_ESUPPORT");
			//obj_EsupportContentWorkflow.handleCookies(driver);
			obj_EsupportIPSWorkflow.clickBrowseAllProductsLink(driver);
			obj_EsupportIPSWorkflow.SelectProductFromBrowseAll(driver);
//			obj_EsupportIPSWorkflow.clickLaptopsLink(driver);
//			obj_EsupportIPSWorkflow.clickLatitudeLink(driver);
//			obj_EsupportIPSWorkflow.clickLatitudeSeries(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[0]);
//			obj_EsupportIPSWorkflow.clickLatitudeSubProduct(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[1]);
			obj_EsupportContentWorkflow.ClickDocumentationTab(driver);
			obj_EsupportCoveoWorkflow.ScrollToVideos(driver);
			obj_EsupportCoveoWorkflow.ValidateClickOnSeeVideoTutorials(driver);

		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_6780696_AMER_ED_Coveo_VideoTutorialsForVideoSection_ESUPPORT--------->\n  "+e);
		}
	}
}
