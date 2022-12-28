package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_5780256_AMER_FF_FindMyDellEMCProductsAccountsitesTabHomepageEmployeeLogin_Esupport extends BaseTest
{
    @Test
 public void validate_TC_5780256_AMER_FF_FindMyDellEMCProductsAccountsitesTabHomepageEmployeeLogin_Esupport() 
 {

         try
         {
                 System.out.println("Starts TC_5780256_AMER_FF_FindMyDellEMCProductsAccountsitesTabHomepageEmployeeLogin_Esupport");
                 

     			obj_EsupportIPSWorkflow.handleCookies(driver);
     			obj_EsupportIPSWorkflow.clickSignIn(driver);
     		//	obj_EsupportIPSWorkflow.clickSignInHereLink(driver);
     			Thread.sleep(10000);
     			obj_EsupportIPSWorkflow.employeeLogin_Firefox(driver, TestNGCreator.TestData.get(Esupport.Username.ordinal()), TestNGCreator.TestData.get(Esupport.Password.ordinal()));
                // obj_EsupportCoveoWorkflow.EmployeeLogin(driver, TestNGCreator.TestData.get(Esupport.Username.ordinal()).split(";")[0],TestNGCreator.TestData.get(Esupport.Password.ordinal()).split(";")[0]);
               //  obj_EsupportIntegratedHomePageWorkflow.handleCookies(driver);
                 obj_EsupportIntegratedHomePageWorkflow.TOclick_FindMyDellEMCProductsLink(driver);
                 obj_EsupportIntegratedHomePageWorkflow.clickOnAccountSitesTab(driver);
                 obj_EsupportIntegratedHomePageWorkflow.validateSearchIcon(driver);
                 obj_EsupportIntegratedHomePageWorkflow.handleSiteSearchTextbox(driver, TestNGCreator.TestData.get(Esupport.Textarea.ordinal()));
                 driver.navigate().refresh();
                 obj_EsupportIntegratedHomePageWorkflow.handleCookies(driver);
                 obj_EsupportIntegratedHomePageWorkflow.TOclick_FindMyDellEMCProductsLink(driver);
                 obj_EsupportIntegratedHomePageWorkflow.clickOnAccountSitesTab(driver);
                 obj_EsupportIntegratedHomePageWorkflow.handleSiteSearchTextbox(driver, TestNGCreator.TestData.get(Esupport.Country.ordinal()));
                 driver.navigate().refresh();
                 obj_EsupportIntegratedHomePageWorkflow.handleCookies(driver);
                 obj_EsupportIntegratedHomePageWorkflow.TOclick_FindMyDellEMCProductsLink(driver);
                 obj_EsupportIntegratedHomePageWorkflow.clickOnAccountSitesTab(driver);
                 obj_EsupportIntegratedHomePageWorkflow.handleSiteSearchTextbox(driver, TestNGCreator.TestData.get(Esupport.PostalCode.ordinal()));
                
                
             
                 Thread.sleep(3000);


         }
         catch(Exception e){

                 Assert.fail("Failed while executing test case TC_5780256_AMER_FF_FindMyDellEMCProductsAccountsitesTabHomepageEmployeeLogin_Esupport--------->\n  "+e);

         }

 }
}
