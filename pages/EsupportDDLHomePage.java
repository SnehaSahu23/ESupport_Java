package com.dell.delta_uat_automation.esupport.pages;

import org.openqa.selenium.By;


import com.dell.delta_uat_automation.utility.CommonUtility;

public class EsupportDDLHomePage  extends EsupportPojo
{
	public By Delllogo() throws Exception
	{
		return CommonUtility.getLocator(DDLHomePage_Data.get("Delllogo"));
	}
	public By HomePageSignIn() throws Exception
    {
          return CommonUtility.getLocator(DDLHomePage_Data.get("HomePageSignIn"));
    }
    
    public By DigitalLockerHeader() throws Exception
    {
          return CommonUtility.getLocator(DDLHomePage_Data.get("DigitalLockerHeader"));
    }
        
    public By Email() throws Exception
    {
          return CommonUtility.getLocator(DDLHomePage_Data.get("Email"));
    }
    
    public By Password() throws Exception
    {
          return CommonUtility.getLocator(DDLHomePage_Data.get("Password"));
    }
    public By SignIn() throws Exception
	{
		return CommonUtility.getLocator(DDLHomePage_Data.get("SignIn"));
	} 
   public By SignInHeader() throws Exception
	{
		return CommonUtility.getLocator(DDLHomePage_Data.get("SignInHeader"));
	} 
   public By ErrorMessage() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("ErrorMessage"));
   }
   public By ProductTab() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("ProductTab"));
   }
   public By KeywordsLabel() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("KeywordsLabel"));
   }
   public By CategoryLabel() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("CategoryLabel"));
   }
   public By LicenseDate() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("LicenseDate"));
   } 
   public By Submit() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("Submit"));
   }
   public By ClearAll() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("ClearAll"));
   }
   public By SaveSearch() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("SaveSearch"));
   }
   public By FromRange() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("FromRange"));
   }
   public By ToRange() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("ToRange"));
   }
   public By DDLHeader() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("DDLHeader"));
   }
   
   public By SupportHeader() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("SupportHeader"));
   }
   
   
   public By DDlClickablelinks() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("DDlClickablelinks"));
   }
   
   
   public By ProductSupportLink() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("ProductSupportLink"));
   }
   public By TrailSupportLink() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("TrailSupportLink"));
   }
   
   public By OwnershipTransferLink() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("OwnershipTransferLink"));
   }
   
   
   public By OrderSupportLink() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("OrderSupportLink"));
   }
   

   
//Sujata 19/2/2019
   public By DigitalLockerHeaderProducts() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("DigitalLockerHeaderProducts"));
   }

   public By Pagination() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("Pagination"));
   }
   
   public By PaginationList() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("PaginationList"));
   }
   
   public By PaginationListCount() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("PaginationListCount"));
   }
   
   public By ClickingOnHistoryTab() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("ClickingOnHistoryTab"));
   }
   
   public By HistorySearchThirty() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("HistorySearchThirty"));
   }
   
   public By HistorySearchSixty() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("HistorySearchSixty"));
   }
   
   public By HistorySearchNinty() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("HistorySearchNinty"));
   }
   
   public By DateRange() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("DateRange"));
   }
   public By HistorySearchSubmit() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("HistorySearchSubmit"));
   }
   
    
   public By HistorySearchSubmitOrder() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("HistorySearchSubmitOrder"));
   }
   
   public By HistorySearchALL() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("HistorySearchALL"));
   }
   
   public By DaterangeFromdate() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("DaterangeFromdate"));
   }
   
   //Pushpa
   public By ProductHeader() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("ProductHeader"));
   }

   public By LicenseDateColumn() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("LicenseDateColumn"));
   }


   public By LicenseDateColumnData() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("LicenseDateColumnData"));
   }


   public By ProductNameColumn() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("ProductNameColumn"));
   }


   public By ProductNameColumnData() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("ProductNameColumnData"));
   }

   public By PrimaryIDColumn() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("PrimaryIDColumn"));
   }

   public By PrimaryIDColumnData() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("PrimaryIDColumnData"));
   }
   
   public By OrderNumberColumn() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("OrderNumberColumn"));
   }
   
   public By OrderNumberColumnData() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("OrderNumberColumnData"));
   }

   //Sudha
   public By ProductRegistrationTab() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("ProductRegistrationTab"));
   }
   public By Entry() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("Entry"));
   }
   public By OrderHistoryTab() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("OrderHistoryTab"));
   }
   public By OrderHistoryHeader() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("OrderHistoryHeader"));
   }
   public By SavethisSearch() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("SavethisSearch"));
   }
   public By SearchbydrpValues() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("SearchbydrpValues"));
   }
   public By Searchbydrp() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("Searchbydrp"));
   }  
   public By Categorytxt() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("Categorytxt"));
   }
   public By SubmitCategory() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("SubmitCategory"));
   }
   public By SavethisSearchHeader() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("SavethisSearchHeader"));
   }
   public By  SaveSearchSubmit() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("SaveSearchSubmit"));
   }
   public By  SavedSearchTab() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("SavedSearchTab"));
   }
   public By  SavedSearchTabHeader() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("SavedSearchTabHeader"));
   }
   public By   KeywordsTxt() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("KeywordsTxt"));
   }
   public By   SaveSearchbydrpValues() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("SaveSearchbydrpValues"));
   }
   public By   SaveSearchClose() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("SaveSearchClose"));
   }
   //Pushpa
   public By ActionsTopLabel() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("ActionsTopLabel"));
   }


   public By ActionsBottomLabel() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("ActionsBottomLabel"));
   }


   public By ActionsTopDropdown() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("ActionsTopDropdown"));
   }

   public By ActionsBottomDropdown() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("ActionsBottomDropdown"));
   }
   public By ClickonanyOrder() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("ClickonanyOrder"));
   }
   
   public By SummaryOrdernumber() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("SummaryOrdernumber"));
   }
   
   public By SummaryShippingLicence() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("SummaryShippingLicence"));
   }
 
   public By OrderSupportLinkTablesdata() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("OrderSupportLinkTablesdata"));
   }



public By   VerifySavesearchtabledata() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("VerifySavesearchtabledata"));
   } 
   public By   ClickonEdit() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("ClickonEdit"));
   } 
   public By   EditOrderhistoryEdit() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("EditOrderhistoryEdit"));
   } 
   
   
   public By   EditEnteryourName() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("EditEnteryourName"));
   } 
   public By   EditEnteryourNameTextBox() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("EditEnteryourNameTextBox"));
   } 
   public By   EditUpdatebtn() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("EditUpdatebtn"));
   } 
   public By   EditCancelbtn() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("EditCancelbtn"));
   } 
   public By   EditSubmitBtn() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("EditSubmitBtn"));
   }
//Sujata
   public By   ClickUserGroups() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("ClickUserGroups"));
   }
   public By   NavigationTabsUserGroups() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("NavigationTabsUserGroups"));
   }
   public By   UserGroupsClickProductGroups() throws Exception
   {
        return CommonUtility.getLocator(DDLHomePage_Data.get("UserGroupsClickProductGroups"));
   }
   public By   ProductGroupsselected() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("ProductGroupsselected"));
   }
   public By   ProductGroupsColumHeader() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("ProductGroupsColumHeader"));
   }
   
   public By   ProductGroupsColumHeaderclick() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("ProductGroupsColumHeaderclick"));
   }
   public By   ProductGroupsColumHeaderTdata() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("ProductGroupsColumHeaderTdata"));
   }
   //Pushpa
   public By   NumOfItems() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("NumOfItems"));
   }
   
   
   public By   PaginationSaveSearch() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("PaginationSaveSearch"));
   }
   
   public By   PaginationListSaveSearch() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("PaginationListSaveSearch"));
   }
      
   public By   PageNumberLink() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("PageNumberLink"));
   }

//Sudha-25/2/2019
   public By   Users() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("Users"));
   }

   public By  AddUserGroup() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("AddUserGroup"));
   }
   public By  EditLink() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("EditLink"));
   }
   public By  RemoveLink() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("RemoveLink"));
   }
   public By  DeleteUserGroup() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("DeleteUserGroup"));
   }
   public By  DeleteUserGroupCancel() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("DeleteUserGroupCancel"));
   }
   public By  UserGroupsTab() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("UserGroupsTab"));
   }
   public By  DeleteUserGroupOK() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("DeleteUserGroupOK"));
   }
 //Pushapa
   public By   SimpleViewLink() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("SimpleViewLink"));
   }

   public By   HistoryTabSimpleView() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("HistoryTabSimpleView"));
   }

   public By   BillingAccountTabSimpleView() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("BillingAccountTabSimpleView"));
   }

   public By   ProductRegistrationTabSimpleView() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("ProductRegistrationTabSimpleView"));
   }

   public By   WarrantyTabSimpleView() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("WarrantyTabSimpleView"));
   }

   public By   HelpTabSimpleView() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("HelpTabSimpleView"));
   }
   
   
   public By   AdvancedViewLink() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("AdvancedViewLink"));
   }
   
   public By   BillingAccountTabAdvanceView() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("BillingAccountTabAdvanceView"));
   }
   
   public By   UsersGroupsTabAdvanceView() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("UsersGroupsTabAdvanceView"));
   }
   
   public By   ToolsTabAdvanceView() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("ToolsTabAdvanceView"));
   }
   
   public By   WarrantyTabAdvanceView() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("WarrantyTabAdvanceView"));
   }
   
   public By   HelpTabAdvanceView() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("HelpTabAdvanceView"));
   }
//Sujata
   public By   UsersTablesData() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("UsersTablesData"));
   }
   public By   UsersGroupsdisplayedinusers() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("UsersGroupsdisplayedinusers"));
   }
  
   public By   UsersGroupsLastNameClick() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("UsersGroupsLastNameClick"));
   }
   public By   UsersGroupsLastNameTablesdata() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("UsersGroupsLastNameTablesdata"));
   }
   
   public By   UsersGroupsUsergroupsclick() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("UsersGroupsUsergroupsclick"));
   }
   public By   UsersGroupsUsergTablesdata() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("UsersGroupsUsergTablesdata"));
   }
   
   public By   UsersGroupsNameClick() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("UsersGroupsNameClick"));
   }
   public By   UsersGroupsNameUsergTablesdata() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("UsersGroupsNameUsergTablesdata"));
   }
   
   
   public By   UnassignedProductGroupsselected() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("UnassignedProductGroupsselected"));
   }
   public By   ProductsgroupdTabtabledata() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("ProductsgroupdTabtabledata"));
   }
   
   public By   UnAssProductsgroupdTabtabledata() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("UnAssProductsgroupdTabtabledata"));
   }
   public By   UnAssProductsgroupdclick() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("UnAssProductsgroupdclick"));
   }
   
   
   public By   Removeuserstab() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("Removeuserstab"));
   }
   public By   RemoverstabheaderTablesdata() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("RemoverstabheaderTablesdata"));
   }
   
   public By   RemoveuserstablastNameClick() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("RemoveuserstablastNameClick"));
   }
   public By   RemoveuserstablastNameTablesdata() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("RemoveuserstablastNameTablesdata"));
   }
   //Sudha
   
   public By AddUserGroupHeader() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("AddUserGroupHeader"));
   }

   public By UserGroupName() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("UserGroupName"));
   }
   public By UserGroupContinue() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("UserGroupContinue"));
   }
   public By AssignRoleList() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("AssignRoleList"));
   }
   public By AssignRoledropdown() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("AssignRoledropdown"));
   }
   public By AddNewUser() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("AddNewUser"));
   }
   public By  AddUserHeader() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("AddUserHeader"));
   }
   public By  FirstName() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("FirstName"));
   }
   public By LastName() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("LastName"));
   }
   public By EmailAddress() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("EmailAddress"));
   }
   public By AddNewUserSubmit() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("AddNewUserSubmit"));
   }
   public By SuccessMsg() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("SuccessMsg"));
   }
   public By ReturntoadduserGroup() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("ReturntoadduserGroup"));
   }
   public By AssignedTab() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("AssignedTab"));
   }
   public By UnAssignedTab() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("UnAssignedTab"));
   }
   public By UnAssignedTabActive() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("UnAssignedTabActive"));
   }
  //Sujata
   public By  UnAssProductsgroupdcustomerNo() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("UnAssProductsgroupdcustomerNo"));
   }
   
   public By  UnAssProductsgroupdcustomerNotabledata() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("UnAssProductsgroupdcustomerNotabledata"));
   }
   
   
   public By  UnAssProductsgroupdOrderNo() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("UnAssProductsgroupdOrderNo"));
   }
   
   public By  UnAssProductsgroupdOrderNotabledata() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("UnAssProductsgroupdOrderNotabledata"));
   }
   
   
   public By  UnAssProductsgroupdShipDate() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("UnAssProductsgroupdShipDate"));
   }
   
   public By  UnAssProductsgroupdShipDatetabledata() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("UnAssProductsgroupdShipDatetabledata"));
   }
   
   
   public By  UnAssProductsgroupdPrimaryID() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("UnAssProductsgroupdPrimaryID"));
   }
   
   public By  UnAssProductsgroupdPrimaryIDtabledata() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("UnAssProductsgroupdPrimaryIDtabledata"));
   }
   //Pushpa 28/2/2019
   
//Sudha 1stMarch
   public By GroupContinueButton1() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("GroupContinueButton1"));
   }

   public By GroupContinueButton2() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("GroupContinueButton2"));
   }
   
   public By SelectProductCheckbox() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("SelectProductCheckbox"));
   }
   
   
   public By DoneButton() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("DoneButton"));
   }
   
   
   public By UserGroupNameColumnData() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("UserGroupNameColumnData"));
   }

   
   public By SortingButtonUserGroupName() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("SortingButtonUserGroupName"));
   }
   
   
   public By EditUserGroupNameTextbox() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("EditUserGroupNameTextbox"));
   }
   
   
   public By UserGroupSubmitButton() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("UserGroupSubmitButton"));
   }
   
   
   public By UserGroupHeader() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("UserGroupHeader"));
   }

   
   public By  ProductSelect() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("ProductSelect"));
   }
   public By ProductName() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("ProductName"));
   }
   public By ProductHeaderGetKey() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("ProductHeaderGetKey"));
   }
   public By  GetkeyEmailDownloadList() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("GetkeyEmailDownloadList"));
   }
   public By  Getkey() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("Getkey"));
   }
   //Sujata 1st march
   public By Productsnavigationtabs() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("Productsnavigationtabs"));
   }
   
   public By ProductstabProductname() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("ProductstabProductname"));
   }
   
   public By ProductstabOrderNumber() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("ProductstabOrderNumber"));
   }
   
   public By ProductstabPrimaryId() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("ProductstabPrimaryId"));
   }
   
   public By ProductstabLicencename() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("ProductstabLicencename"));
   }
   
   public By ProductstabLicenceDate() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("ProductstabLicenceDate"));
   }
   
   
   public By ProductstabInstalledonhardwareID() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("ProductstabInstalledonhardwareID"));
   }
   
   public By ProductstabCurrentversion() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("ProductstabCurrentversion"));
   }
   
   public By ProductstabGetKeylink() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("ProductstabGetKeylink"));
   }
   public By ProductstabAvvaibleDownloads() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("ProductstabAvvaibleDownloads"));
   }
   
   public By ProductstabAvvaibleDownloadslabels() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("ProductstabAvvaibleDownloadslabels"));
   }
   
   public By Supportlinksclick() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("Supportlinksclick"));
   }
   
   public By SupportlinksclickLinkspopup() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("SupportlinksclickLinkspopup"));
   }
   
//pushpa
   public By FaqHeader() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("FaqHeader"));
   }
         
   public By ShowAllLink() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("ShowAllLink"));
   }
   
   public By HideAllLink() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("HideAllLink"));
   }

   
   public By ArrowDownward() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("ArrowDownward"));
   }      
   
   public By ShowAllList() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("ShowAllList"));
   }      
   
   public By AdvancedViewList() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("AdvancedViewList"));
   }
//Sujata 
   public By  Getkeylinkpopoup() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("Getkeylinkpopoup"));
   }
   public By  KeywordGetlink() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("KeywordGetlink"));
   } 
   
   public By  KeywordGetlinkSubmit() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("KeywordGetlinkSubmit"));
   } 
   
   public By  KeywordGetlinksendemail() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("KeywordGetlinksendemail"));
   } 
   
   public By  KeywordGetlinksendemailSubmit() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("KeywordGetlinksendemailSubmit"));
   } 
   
   public By  KeywordGetlinkDownload() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("KeywordGetlinkDownload"));
   } 
   
   public By  KeywordGetlinksendemailpopupheader() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("KeywordGetlinksendemailpopupheader"));
   } 

   public By  KeywordGetlinksendemailpopupheadermsg() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("KeywordGetlinksendemailpopupheadermsg"));
   } 
   
   public By  ErrorMessagepopupnotdisplayed() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("ErrorMessagepopupnotdisplayed"));
   } 
   public By  ErrorMessagepopupnotdisplayedinpage() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("ErrorMessagepopupnotdisplayedinpage"));
   } 
   
   public By  productpagelicensename() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("productpagelicensename"));
   } 
   public By  productpagelicensemessage() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("productpagelicensemessage"));
   } 
   
   
   public By  productpagelicensenameEdit() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("productpagelicensenameEdit"));
   } 
   public By  productpagelicensetextbox() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("productpagelicensetextbox"));
   } 
   
   
   public By  productpagelicensetextboxSave() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("productpagelicensetextboxSave"));
   } 
   
   public By  productpagelicensenameEditBox() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("productpagelicensenameEditBox"));
   } 
   
   
   public By  productpagelicensetextboxSavetext() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("productpagelicensetextboxSavetext"));
   } 
//Pushpa
   public By EditUserGroupHeader() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("EditUserGroupHeader"));
   }
         
   public By RoleDropdown() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("RoleDropdown"));
   }
   
   
   public By RemoveLinkUser() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("RemoveLinkUser"));
   }
   
   
   public By AddUserLink() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("AddUserLink"));
   }
   
   
   public By SaveButton() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("SaveButton"));
   }
   
   
   public By AddNewUserButton() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("AddNewUserButton"));
   }
   
   
   public By AssignedAddUserHeader() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("AssignedAddUserHeader"));
   }
   
   
   public By ReturntoEditUserGroupLink() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("ReturntoEditUserGroupLink"));
   }
   //Sujata
   public By Getlinknodelistcount() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("Getlinknodelistcount"));
   }
   
   public By GetlinknodelistHeader() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("GetlinknodelistHeader"));
   }
//Sujata
   public By AddaProductName() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("AddaProductName"));
   }
   
   public By AddProductGroupName() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("AddProductGroupName"));
   }
   
   
   
   public By AddProductGroupNameSelect() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("AddProductGroupNameSelect"));
   }
   
   public By AddProductGroupNameSubmit() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("AddProductGroupNameSubmit"));
   }
   
   public By AddProductGroupNameSelectText() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("AddProductGroupNameSelectText"));
   }
   
   public By AvaibleProductselectclicked() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("AvaibleProductselectclicked"));
   }
   
   public By AvaibleProductselectSaveContinue() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("AvaibleProductselectSaveContinue"));
   }
   
   public By AvaibleProductheader() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("AvaibleProductheader"));
   }
   public By VerifyProductGroupName() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("VerifyProductGroupName"));
   }
   
   public By VerifyProductGroupNameSavebtn() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("VerifyProductGroupNameSavebtn"));
   }
   
   public By VerifyProductsdisplayed() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("VerifyProductsdisplayed"));
   }
   
   public By AddaanotherProducts() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("AddaanotherProducts"));
   }
   
   public By AvaibleProductselectclickedsecond() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("AvaibleProductselectclickedsecond"));
   }
   
   public By AvaibleProductselectclickedsecondSave() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("AvaibleProductselectclickedsecondSave"));
   }
   
   //pushpa
   
   public By BillingAccountHeader() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("BillingAccountHeader"));
   }
   
   public By BillingAccountTableHeader() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("BillingAccountTableHeader"));
   }

   
   public By OfferNameColumnData() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("OfferNameColumnData"));
   }
   
   
   public By BillPlanDetailsHeader() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("BillPlanDetailsHeader"));
   }

   
   public By SelectAllProductNameCheckbox() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("SelectAllProductNameCheckbox"));
   }
   
   public By BillingHistoryLink() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("BillingHistoryLink"));
   }
   
   public By BillingHistoryTableHeader() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("BillingHistoryTableHeader"));
   }
   
   public By AmountColumnData() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("AmountColumnData"));
   }
   
   public By UnitChargeAmountColumnData() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("UnitChargeAmountColumnData"));
   }
   
   public By ViewDetailsLink() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("ViewDetailsLink"));
  }
   
   
   public By BillingDetailsHeader() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("BillingDetailsHeader"));
   }
   
   public By DetailsAmountData() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("DetailsAmountData"));
   }
   
   
   public By TotalAmountData() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("TotalAmountData"));
   }

//pushpa
   
   public By GetAllTextBasedKeys() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("GetAllTextBasedKeys"));
   } 
   
   
   public By ProductNameColumnLink() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("ProductNameColumnLink"));
   }   
   
   
   public By FileNameColumnData() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("FileNameColumnData"));
   }
   
   
   public By ServiceWarrantyLink() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("ServiceWarrantyLink"));
   }
   
   public By ManagePaymentMethodLink() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("ManagePaymentMethodLink"));
   }

   
   public By ManageBillingInfoHeader() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("ManageBillingInfoHeader"));
   }

   
   public By ChangePaymentButton() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("ChangePaymentButton"));
   }
   
   public By AddNewPaymentMethodHeader() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("AddNewPaymentMethodHeader"));
   }
   
   
   public By CardNumberTextbox() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("CardNumberTextbox"));
   }
   
   public By ExpiryMonthDropdown() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("ExpiryMonthDropdown"));
   }
   
   public By ExpiryYearDropdown() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("ExpiryYearDropdown"));
   }
   
   public By CVVNumberTextbox() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("CVVNumberTextbox"));
   }
   
   public By NameTextbox() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("NameTextbox"));
   }
   
   public By AddressTextbox() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("AddressTextbox"));
   }
   
   public By CityTextbox() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("CityTextbox"));
   }
   
   public By StateDropdown() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("StateDropdown"));
   }
   
   public By ZipTextbox() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("ZipTextbox"));
   }
   
   public By ZipSubCodeTextbox() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("ZipSubCodeTextbox"));
   }
   
   public By PhoneNumberTextbox() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("PhoneNumberTextbox"));
   }
   
   public By SaveChangesButton() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("SaveChangesButton"));
   }
   
   public By PaymentErrorMessage() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("PaymentErrorMessage"));
   }
   
   public By emailCloseButton() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("EmailCloseButton"));
   } 
   
   
   // pushpa
   
   public By subscriptionData() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("SubscriptionData"));
   }
   
   public By taxData() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("TaxData"));
   }
   
   public By totalData() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("TotalData"));
   }

   //Lavanya
   
   public By PaginationInBillingAccountTab() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("PaginationInBillingAccountTab"));
   }
   
   public By PaginationListInBillingAccountTab() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("PaginationListInBillingAccountTab"));
   }
   public By BillPlanIDColumnData() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("BillPlanIDColumnData"));
   }
   public By EditForPerticularOfferName() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("EditForPerticularOfferName"));
   }
   public By RemoveLinkForOffers() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("RemoveLinkForOffers"));
   }
   
   public By PaginationInUserGroupTab() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("PaginationInUserGroupTab"));
   }
   public By PaginationListInUserGroupTab() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("PaginationListInUserGroupTab"));
   }
   public By TextBoxInSaveTextBox() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("TextBoxInSaveTextBox"));
   }
   //Sneha
   
   public By Email1() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("Email1"));
   }
   public By Password1() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("Password1"));
   }
   public By ContinueButton() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("ContinueButton"));
   }
   public By SignInButton() throws Exception
   {
         return CommonUtility.getLocator(DDLHomePage_Data.get("SignInButton"));
   }
}
