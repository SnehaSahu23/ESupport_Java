package com.dell.delta_uat_automation.esupport.pages;

import org.openqa.selenium.By;

import com.dell.delta_uat_automation.utility.CommonUtility;

public class EsupportMobieSEOPage extends EsupportMobilePojo{
	public By delllogo() throws Exception {

		return CommonUtility.getLocator_Mobile(UnifiedPortalPage_Data.get("Delllogo"));
	}
	
	public By acceptCookies() throws Exception {

		return CommonUtility.getLocator_Mobile(UnifiedPortalPage_Data.get("AcceptCookies"));
	}
}
