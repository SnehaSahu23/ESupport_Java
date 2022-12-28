package com.dell.delta_uat_automation.esupport.pages;

import org.openqa.selenium.By;

import com.dell.delta_uat_automation.utility.CommonUtility;


public class EsupportPortalPage extends EsupportPojo
{
	public By delllogo() throws Exception {

		return CommonUtility.getLocator(PortalPage_Data.get("Delllogo"));
	}

	public By acceptCookies() throws Exception {

		return CommonUtility.getLocator(PortalPage_Data.get("AcceptCookies"));
	}

	public By incidentManagementTab() throws Exception {

		return CommonUtility.getLocator(PortalPage_Data.get("IncidentManagementTab"));
	}
	
	public By incidentManagementTable() throws Exception {

		return CommonUtility.getLocator(PortalPage_Data.get("IncidentManagementTable"));
	}
	
	public By incidentManagementSummaryViewFilterButton() throws Exception {

		return CommonUtility.getLocator(PortalPage_Data.get("IncidentManagementSummaryViewFilterButton"));
	}
	
	public By incidentManagementFilterByPopupHeader() throws Exception {

		return CommonUtility.getLocator(PortalPage_Data.get("IncidentManagementFilterByPopupHeader"));
	}
	
	public By incidentManagementFilterByPopupSRStatus() throws Exception {

		return CommonUtility.getLocator(PortalPage_Data.get("IncidentManagementFilterByPopupSRStatus"));
	}
	
	public By incidentManagementFilterByPopupSRStatusHeader() throws Exception {

		return CommonUtility.getLocator(PortalPage_Data.get("IncidentManagementFilterByPopupSRStatusHeader"));
	}
	
	public By incidentManagementFilterByPopupSRStatusClosedCheckbox() throws Exception {

		return CommonUtility.getLocator(PortalPage_Data.get("IncidentManagementFilterByPopupSRStatusClosedCheckbox"));
	}
	public By incidentManagementFilterByPopupApplySelectedButton() throws Exception {

		return CommonUtility.getLocator(PortalPage_Data.get("IncidentManagementFilterByPopupApplySelectedButton"));
	}
	
	
	public By incidentManagementFilterByPopupCloseButton() throws Exception {

		return CommonUtility.getLocator(PortalPage_Data.get("IncidentManagementFilterByPopupCloseButton"));
	}
	
	
	public By incidentManagementFilterBreadcrumbSRStatus() throws Exception {

		return CommonUtility.getLocator(PortalPage_Data.get("IncidentManagementFilterBreadcrumbSRStatus"));
	}
	
	public By incidentManagementFilterByPopupSRStatusClosedLabel() throws Exception {

		return CommonUtility.getLocator(PortalPage_Data.get("IncidentManagementFilterByPopupSRStatusClosedLabel"));
	}
	
	public By incidentManagementFilterByPopupClearAllButton() throws Exception {

		return CommonUtility.getLocator(PortalPage_Data.get("IncidentManagementFilterByPopupClearAllButton"));
	}
	
	
	public By incidentManagementFilterBreadcrumbClearAll() throws Exception {

		return CommonUtility.getLocator(PortalPage_Data.get("IncidentManagementFilterBreadcrumbClearAll"));
	}
	
	
	public By incidentManagementEscalationsButton() throws Exception {

		return CommonUtility.getLocator(PortalPage_Data.get("IncidentManagementEscalationsButton"));
	}
	
	public By incidentManagementFilterBreadcrumbEscalations() throws Exception {

		return CommonUtility.getLocator(PortalPage_Data.get("IncidentManagementFilterBreadcrumbEscalations"));
	}
	
	
	public By incidentManagementFilterByPopupEscalations() throws Exception {

		return CommonUtility.getLocator(PortalPage_Data.get("IncidentManagementFilterByPopupEscalations"));
	}
	
	public By incidentManagementFilterByPopupEscalationsHeader() throws Exception {

		return CommonUtility.getLocator(PortalPage_Data.get("IncidentManagementFilterByPopupEscalationsHeader"));
	}
	
	public By incidentManagementFilterByPopupEscalationsSelectAll() throws Exception {

		return CommonUtility.getLocator(PortalPage_Data.get("IncidentManagementFilterByPopupEscalationsSelectAll"));
	}
	
	public By incidentManagementFilterByPopupEscalationsOpen() throws Exception {

		return CommonUtility.getLocator(PortalPage_Data.get("IncidentManagementFilterByPopupEscalationsOpen"));
	}
	
	public By incidentManagementFilterByPopupEscalationsClosed() throws Exception {

		return CommonUtility.getLocator(PortalPage_Data.get("IncidentManagementFilterByPopupEscalationsClosed"));
	}

	
	public By incidentManagementExpandButton() throws Exception {

		return CommonUtility.getLocator(PortalPage_Data.get("IncidentManagementExpandButton"));
	}
	
	public By incidentManagementExpandHeader() throws Exception {

		return CommonUtility.getLocator(PortalPage_Data.get("IncidentManagementExpandHeader"));
	}	

	public By 	incidentManagementFilterByPopupEscalationsNeverEscalated() throws Exception {

		return CommonUtility.getLocator(PortalPage_Data.get("IncidentManagementFilterByPopupEscalationsNeverEscalated"));
	}
	
	public By incidentManagementFilterByPopupEscalationsNone() throws Exception {

		return CommonUtility.getLocator(PortalPage_Data.get("IncidentManagementFilterByPopupEscalationsNone"));
	}
	
	//Lavanya 
		public By IncidentsManagementTab() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("IncidentsManagementTab"));
		}
		public By AfterClickingIncidentsManagementTab() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("AfterClickingIncidentsManagementTab"));
		}
		public By PageNumberDisplayed() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("PageNumberDisplayed"));
		}
		public By GoToNextPageArrowMark() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("GoToNextPageArrowMark"));
		}
		public By PagesDisplayedInPagination() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("PagesDisplayedInPagination"));
		}
		public By GoToLastPageArrowMark() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("GoToLastPageArrowMark"));
		}
		public By GoToFirstPageArrowMark() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("GoToFirstPageArrowMark"));
		}
		public By GoToPreviousPageArrowMark() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("GoToPreviousPageArrowMark"));
		}
		public By GoToPreviousPageArrowMarkEnabled() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("GoToPreviousPageArrowMarkEnabled"));
		}
		public By GoToFirstPageArrowMarkEnabled() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("GoToFirstPageArrowMarkEnabled"));
		}
		public By GoToNextPageArrowMarkDisabled() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("GoToNextPageArrowMarkDisabled"));
		}
		public By GoToLastPageArrowMarkDisabled() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("GoToLastPageArrowMarkDisabled"));
		}
		public By PageSizeSection() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("PageSizeSection"));
		}
		public By DropDownValuesUnderPageSizeSection() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("DropDownValuesUnderPageSizeSection"));
		}
		public By DefaultDisplayedPerPageValue() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("DefaultDisplayedPerPageValue"));
		}
		public By SearchTextBox() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("SearchTextBox"));
		}
		public By SearchButton() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("SearchButton"));
		}
		public By HeaderOfThePopUp() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("HeaderOfThePopUp"));
		}
		public By SearchedDataOnExpandedPopUp() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("SearchedDataOnExpandedPopUp"));
		}
		public By HeadingsOfTable1() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("HeadingsOfTable1"));
		}
		public By RowsDisplayedUnderTable1() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("RowsDisplayedUnderTable1"));
		}
		public By CountOfRowsDisplayed() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("CountOfRowsDisplayed"));
		}
		public By OtherDetailsDisplayedInResultPopUp() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("OtherDetailsDisplayedInResultPopUp"));
		}
		public By CountOfRowsInOtherDetailsDisplayedInResultPopUp() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("CountOfRowsInOtherDetailsDisplayedInResultPopUp"));
		}
		public By ValuesDisplayedUnderOtherDetailsTable() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("ValuesDisplayedUnderOtherDetailsTable"));
		}
		public By SRsTabDefault() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("SRsTabDefault"));
		}
		public By TableViewDefaultDisplay() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("TableViewDefaultDisplay"));
		}
		public By SearchedDataNotFoundMessage() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("SearchedDataNotFoundMessage"));
		}
		public By ExpandButtonOnTabularView() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("ExpandButtonOnTabularView"));
		}
		public By CloseButton() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("CloseButton"));
		}
		
		public By OnlineServicesButton() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("OnlineServicesButton"));
		}
		public By HeadingsInColumnsOfGridInOnsiteServices() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("HeadingsInColumnsOfGridInOnsiteServices"));
		}
		public By ValuesUnderGridInOnsiteServices() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("ValuesUnderGridInOnsiteServices"));
		}
		public By MapButtonUnderIncidentManagementTab() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("MapButtonUnderIncidentManagementTab"));
		}
		public By WhiteSpotsThatIndicateSiteLocation() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("WhiteSpotsThatIndicateSiteLocation"));
		}
		public By HeaderOnPopUpDisplayedClickingOnWhiteSpot() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("HeaderOnPopUpDisplayedClickingOnWhiteSpot"));
		}
		public By DetailsIndisePopUpDisplayedClickingOnWhiteSpot() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("DetailsIndisePopUpDisplayedClickingOnWhiteSpot"));
		}
		public By FiltersBreadsrumbOnPopUpForSRs() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("FiltersBreadsrumbOnPopUpForSRs"));
		}
		public By ClearAllHyperlinkOnFilterBreadscrumb() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("ClearAllHyperlinkOnFilterBreadscrumb"));
		}
		public By DataPointClick() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("DataPointClick"));
		}
		public By GraphsButton() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("GraphsButton"));
		}
		
		public By ServiceRequestSeverityLevelHeader() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("ServiceRequestSeverityLevelHeader"));
		}
		public By SeverityLevelDisplayedInGrapgView() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("SeverityLevelDisplayedInGrapgView"));
		}
		public By SeverityLevelRangeDisplayedInGraphView() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("SeverityLevelRangeDisplayedInGraphView"));
		}
		public By OpenSeverityGraphView() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("OpenSeverityGraphView"));
		}
		public By ClosedSeverityGraphView() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("ClosedSeverityGraphView"));
		}
		public By OpenAndClosedSeverityRequests() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("OpenAndClosedSeverityRequests"));
		}
		public By XButtonToCloseBreadscrumFilter() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("XButtonToCloseBreadscrumFilter"));
		}
		public By FilterButton() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("FilterButton"));
		}
		public By SRStatusInFiltersWindow() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("SRStatusInFiltersWindow"));
		}
		public By ClickOpenFilterUnderSRStatusInFilterWindow() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("ClickOpenFilterUnderSRStatusInFilterWindow"));
		}
		public By ApplySelectedInFilterWindow() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("ApplySelectedInFilterWindow"));
		}
		public By XButtonOnFilterWindow() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("XButtonOnFilterWindow"));
		}
		
		public By incidentManagementExpandViewColumns() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("IncidentManagementExpandViewColumns"));
		}	
		
		public By incidentManagementExpandViewScrollbar() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("IncidentManagementExpandViewScrollbar"));
		}	
		
		public By incidentManagementExpandViewCloseButton() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("IncidentManagementExpandViewCloseButton"));
		}
		
		
		public By incidentManagementSiteIdDownArrow() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("IncidentManagementSiteIdDownArrow"));
		}
		
		
		public By incidentManagementExpandedSiteIdSRNumber() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("IncidentManagementExpandedSiteIdSRNumber"));
		}
		
		public By incidentManagementExpandedSiteIdServiceTag() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("IncidentManagementExpandedSiteIdServiceTag"));
		}
		
		public By incidentManagementExpandedSiteIdStatus() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("IncidentManagementExpandedSiteIdStatus"));
		}
		
		
		public By incidentManagementExpandedSiteIdDataPoints() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("IncidentManagementExpandedSiteIdDataPoints"));
		}

		public By incidentManagementStatusValueFirstRow() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("IncidentManagementStatusValueFirstRow"));
		}		
		
		public By incidentManagementTotalSRButton() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("IncidentManagementTotalSRButton"));
		}
		
		
		public By incidentManagementFilterValuesList() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("IncidentManagementFilterValuesList"));
		}
		
		
		public By incidentManagementExpandIcon() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("IncidentManagementExpandIcon"));
		}
		//Lavanya
		public By EscalationsTabOnLeftMenu() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("EscalationsTabOnLeftMenu"));
		}
		public By EscalationsInFilterWindow() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("EscalationsInFilterWindow"));
		}
		public By OpenOptionUnderEscalationsInFilterWindow() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("OpenOptionUnderEscalationsInFilterWindow"));
		}
		
		public By BreadScrumbsOnGraphView() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("BreadScrumbsOnGraphView"));
		}
		public By ClickOnTabularView() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("ClickOnTabularView"));
		}
		
		public By ProductNameInFiltersWindow() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("ProductNameInFiltersWindow"));
		}
		public By AppSyncOptionUnderProductNameInFilterWindow() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("AppSyncOptionUnderProductNameInFilterWindow"));
		}
		public By OpenEscalationsOnTabularView() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("OpenEscalationsOnTabularView"));
		}
		public By TypeOfEscalationsDisplayed() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("TypeOfEscalationsDisplayed"));
		}
		public By OpenEscalationsGraphBar() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("OpenEscalationsGraphBar"));
		}
		public By CountOfOpenEscalationsInGraphView() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("CountOfOpenEscalationsInGraphView"));
		}
		
		public By AvamarDataStoreGen4SProductNameSubFilterWindow() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("AvamarDataStoreGen4SProductNameSubFilterWindow"));
		}
		
		public By XButtonOnBreadScrumbForProductName() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("XButtonOnBreadScrumbForProductName"));
		}
		
		public By InstallBaseTab() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("InstallBaseTab"));
		}
		public By WhiteSpotsInSummaryView() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("WhiteSpotsInSummaryView"));
		}
		public By SummaryTab() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("SummaryTab"));
		}
		
		public By FilterByHeader() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("FilterByHeader"));
		}
		public By InstanceIDINFilterWindow() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("InstanceIDINFilterWindow"));
		}
		public By SearchBoxInInstanceIDOptionExpandedInFilterWindow() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("SearchBoxInInstanceIDOptionExpandedInFilterWindow"));
		}
		public By SelectSearchedFirstResultDisplayedInFilterWindow() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("SelectSearchedFirstResultDisplayedInFilterWindow"));
		}
		public By ClearAllButtonInFilterWindow() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("ClearAllButtonInFilterWindow"));
		}
		public By DescriptionUnderSearchBoxOfInstanceIDExpandedView() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("DescriptionUnderSearchBoxOfInstanceIDExpandedView"));
		}
		public By InstanceIDHeaderInExpandedViewInFilterWindow() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("InstanceIDHeaderInExpandedViewInFilterWindow"));
		}
		public By ResetSelectedButtonInFilterWindow() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("ResetSelectedButtonInFilterWindow"));
		}
		public By AssetsOnLeftRailOfInstallBase() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("AssetsOnLeftRailOfInstallBase"));
		}
		public By ConnectivityOnLeftRailOfInstallBase() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("ConnectivityOnLeftRailOfInstallBase"));
		}
		public By CodeLevelsOnLeftRailOfInstallBase() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("CodeLevelsOnLeftRailOfInstallBase"));
		}
		public By ContractsOnLeftRailOfInstallBase() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("ContractsOnLeftRailOfInstallBase"));
		}
		public By TabsOnPortalView() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("TabsOnPortalView"));
		}
		public By TabsLocatedOnOfGrid() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("TabsLocatedOnOfGrid"));
		}
		public By LeftSideMenuListOfTheGridOfInstallBase() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("LeftSideMenuListOfTheGridOfInstallBase"));
		}
		public By PartsReplacedInIncidentManagement() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("PartsReplacedInIncidentManagement"));
		}
		public By PartsReplacebleWithHUD() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("PartsReplacebleWithHUD"));
		}
		
		public By SeverityFilterInFilterWindow() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("SeverityFilterInFilterWindow"));
		}
		public By S3SevetityInFlterWindow() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("S3SevetityInFlterWindow"));
		}
		
		public By AfterClickingOnInstallBase() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("AfterClickingOnInstallBase"));
		}
		
		public By AssetsOnLeftRailDefaultClickingOnInstallBase() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("AssetsOnLeftRailDefaultClickingOnInstallBase"));
		}
		
		public By DropDownArrowOnFirstAssetOnRightMostColumn() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("DropDownArrowOnFirstAssetOnRightMostColumn"));
		}
		
		public By DetailsUnderAfterDropDownArrowClicked() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("DetailsUnderAfterDropDownArrowClicked"));
		}
		public By ImageUnderDropDownAfterDropDownArrowClicked() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("ImageUnderDropDownAfterDropDownArrowClicked"));
		}
		public By ConnectivityAtGlanceInGraphViewUnderConnectivityContext() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("ConnectivityAtGlanceInGraphViewUnderConnectivityContext"));
		}
		public By GraphViewOfConnectivity() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("GraphViewOfConnectivity"));
		}
		public By PercentageOfConnectivityDisplayedInGraphView() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("PercentageOfConnectivityDisplayedInGraphView"));
		}
		public By ConnectivityStatusBarDisplayedInGraphView() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("ConnectivityStatusBarDisplayedInGraphView"));
		}
		public By ConnectivityStatusInFilterWindow() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("ConnectivityStatusInFilterWindow"));
		}
		public By ConnectivityStatusHeading() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("ConnectivityStatusHeading"));
		}
		public By SearchBoxInFilterWindow() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("SearchBoxInFilterWindow"));
		}
		public By OptionsUnderConnectivityStatusInFilterWindow() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("OptionsUnderConnectivityStatusInFilterWindow"));
		}
		public By BackToConnectivityAtAGlanceButton() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("BackToConnectivityAtAGlanceButton"));
		}
		public By HeaderAfterApplyingFilter() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("HeaderAfterApplyingFilter"));
		}
		public By TabsOnGraphViewAfterApplyingFilters() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("TabsOnGraphViewAfterApplyingFilters"));
		}
		public By ViewByHeaderOnGraphViewAfterApplyingFilters() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("ViewByHeaderOnGraphViewAfterApplyingFilters"));
		}
		public By TextDisplayedUnderSubHeadingForConnectivityAfterApplyingFilter() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("TextDisplayedUnderSubHeadingForConnectivityAfterApplyingFilter"));
		}
		public By CountOfConnectivityDisplayedInGraphBars() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("CountOfConnectivityDisplayedInGraphBars"));
		}
		public By HeaderOfConnectivityDisplayedInGraphBars() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("HeaderOfConnectivityDisplayedInGraphBars"));
		}
		public By BarsOnGraphViewAfterApplyingFilters() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("BarsOnGraphViewAfterApplyingFilters"));
		}
		public By AssetsCircleOnHUDForIBContext() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("AssetsCircleOnHUDForIBContext"));
		}
		public By ConnectivityCircleOnHUDForIBContext() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("ConnectivityCircleOnHUDForIBContext"));
		}
		public By CodeLevelsCircleOnHUDForIBContext() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("CodeLevelsCircleOnHUDForIBContext"));
		}
		public By ContractsCircleOnHUDForIBContext() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("ContractsCircleOnHUDForIBContext"));
		}
		public By AssetsCircleOnHUDForIBContextAfterSelectingAssetsFromIBGrid() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("AssetsCircleOnHUDForIBContextAfterSelectingAssetsFromIBGrid"));
		}
		public By ConnectivityCircleOnHUDForIBContextAfterSelectingConnectivityFromIBGrid() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("ConnectivityCircleOnHUDForIBContextAfterSelectingConnectivityFromIBGrid"));
		}
		public By CodeLevelsCircleOnHUDForIBContextAfterSelectingCodeLevelsFromIBGrid() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("CodeLevelsCircleOnHUDForIBContextAfterSelectingCodeLevelsFromIBGrid"));
		}
		public By ContractsCircleOnHUDForIBContextAfterSelectingContractsFromIBGrid() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("ContractsCircleOnHUDForIBContextAfterSelectingContractsFromIBGrid"));
		}
		public By CircleInPopUpInMapView() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("CircleInPopUpInMapView"));
		}
		public By ScrollToElementOnHUDInPopUp() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("ScrollToElementOnHUDInPopUp"));
		}
		
		public By AssetsOnLeftRailOfInstallBaseForActiveValidation() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("AssetsOnLeftRailOfInstallBaseForActiveValidation"));
		}
		public By ConnectivityOnLeftRailOfInstallBaseForActiveValidation() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("ConnectivityOnLeftRailOfInstallBaseForActiveValidation"));
		}
		public By CodeLevelsOnLeftRailOfInstallBaseForActiveValidation() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("CodeLevelsOnLeftRailOfInstallBaseForActiveValidation"));
		}
		public By ContractsOnLeftRailOfInstallBaseForActiveValidation() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("ContractsOnLeftRailOfInstallBaseForActiveValidation"));
		}
		
		public By incidentManagementOpenSrHud() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("IncidentManagementOpenSrHud"));
		}
				
		public By incidentManagementOnsiteServiceHud() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("IncidentManagementOnsiteServiceHud"));
		}
		
		public By incidentManagementEscalationsHud() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("IncidentManagementEscalationsHud"));
		}
		
		
		public By incidentManagementOnsiteServicesButton() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("IncidentManagementOnsiteServicesButton"));
		}
		
		
		public By incidentManagementPartsReplacedHud() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("IncidentManagementPartsReplacedHud"));
		}
		
		public By incidentManagementPartsReplacedButton() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("IncidentManagementPartsReplacedButton"));
		}
		
		public By installBaseTab() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("InstallBaseTab"));
		}		
		
		public By installBaseTotalAssetsButton() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("InstallBaseTotalAssetsButton"));
		}
				
		public By installBaseButtonsList() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("InstallBaseButtonsList"));
		}		
		
		public By expandViewBreadcrumbDateRange() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("ExpandViewBreadcrumbDateRange"));
		}
		
		
		public By expandViewLastUpdatedFirstRowValue() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("ExpandViewLastUpdatedFirstRowValue"));
		}
		
		
		public By installBaseConnectivityButton() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("InstallBaseConnectivityButton"));
		}
		
		
		public By installBaseCodeLevelsButton() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("InstallBaseCodeLevelsButton"));
		}
		
		public By installBaseContractsButton() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("InstallBaseContractsButton"));
		}

		
		public By incidentManagementEscalationsHudValue() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("IncidentManagementEscalationsHudValue"));
		}
		
		
		public By incidentManagementTotalSRHudValue() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("IncidentManagementTotalSRHudValue"));
		}
		
		
		public By incidentManagementTotalSRArcs() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("IncidentManagementTotalSRArcs"));
		}
				
		public By firstSectionAccountName() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("FirstSectionAccountName"));
		}		
		
		public By healthScoreRisk() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("HealthScoreRisk"));
		}
		
		
		public By portalTabs() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("PortalTabs"));
		}
		
		
		public By summaryTabKPIList() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("SummaryTabKPIList"));
		}
		
		
		public By healthAndRiskTab() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("HealthAndRiskTab"));
		}
		
		
		public By healthAndRiskTable() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("HealthAndRiskTable"));
		}
		
		
		public By securityAdvisoryColumns() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("SecurityAdvisoryColumns"));
		}
		
		public By securityAdvisoryTab() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("SecurityAdvisoryTab"));
		}
		
		public By technicalAdvisoryTab() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("TechnicalAdvisoryTab"));
		}

		
		public By severityColumnHeading() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("SeverityColumnHeading"));
		}
		
		public By severityColumnFirstRowValue() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("SeverityColumnFirstRowValue"));
		}
		
		
		public By advisoryColumnHeading() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("AdvisoryColumnHeading"));
		}
		
		public By advisoryColumnFirstRowValue() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("AdvisoryColumnFirstRowValue"));
		}
		
		
		public By technicalAdvisoryColumns() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("TechnicalAdvisoryColumns"));
		}
		
		
		public By visualizationsButton() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("VisualizationsButton"));
		}
		
		
		public By visualizationsViewHeader() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("VisualizationsViewHeader"));
		}
		
		
		public By visualizationsConnectedButton() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("VisualizationsConnectedButton"));
		}
		
		
		public By connectivityBarChart() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("ConnectivityBarChart"));
		}
		
		
		public By connectivityStatusFilterOption() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("ConnectivityStatusFilterOption"));
		}
		
		public By connectivityStatusFilterOptionHeader() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("ConnectivityStatusFilterOptionHeader"));
		}
		
		public By connectivityStatusFilterOptionNotConnected() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("ConnectivityStatusFilterOptionNotConnected"));
		}

		
		public By breadcrumbConnectivityStatus() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("BreadcrumbConnectivityStatus"));
		}

		
		public By connectivityBackButton() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("ConnectivityBackButton"));
		}
		
		//Lavanya
		public By NoDataErrorMessageInInstallBase() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("NoDataErrorMessageInInstallBase"));
		}
		public By ProductFamilyInFilterWindow() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("ProductFamilyInFilterWindow"));
		}
		public By NoneOptionInProductFamilySubWindowInFilterWindow() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("NoneOptionInProductFamilySubWindowInFilterWindow"));
		}
		public By ConnectedArcUnderInstallBase() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("ConnectedArcUnderInstallBase"));
		}
		public By NotConnectedArcUnderInstallBase() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("NotConnectedArcUnderInstallBase"));
		}
		
		public By NotEligibleArcUnderInstallBase() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("NotEligibleArcUnderInstallBase"));
		}
		public By DisplayedContractsInHUDByDefault() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("DisplayedContractsInHUDByDefault"));
		}
		public By ExpiredContractsInHUD() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("ExpiredContractsInHUD"));
		}
		public By ExpiringWithin30DaysContractsInHUD() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("ExpiringWithin30DaysContractsInHUD"));
		}
		public By ExpiringWithIn31To180DaysContractsInHUD() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("ExpiringWithIn31To180DaysContractsInHUD"));
		}
		public By ContractSothersContractsInHUD() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("ContractSothersContractsInHUD"));
		}
		public By GetContractsHeadingMouseHoveringOnIt() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("GetContractsHeadingMouseHoveringOnIt"));
		}
		
		public By LocationNameForZoomOutMap() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("LocationNameForZoomOutMap"));
		}
		public By ContractsIconOnHUD() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("ContractsIconOnHUD"));
		}
		public By GetTextFromContractsCircleInHUD() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("GetTextFromContractsCircleInHUD"));
		}

		public By FirstDisplayedExpandButtonInGrid() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("FirstDisplayedExpandButtonInGrid"));
		}

		public By healthAndRiskPaginationOptionsLeft() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("HealthAndRiskPaginationOptionsLeft"));
		}
		
		public By healthAndRiskPageSelectorRight() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("HealthAndRiskPageSelectorRight"));
		}
		
		
		public By healthAndRiskPageNumberTextbox() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("HealthAndRiskPageNumberTextbox"));
		}
		
		
		public By healthAndRiskFirstPageButton() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("HealthAndRiskFirstPageButton"));
		}
		
		
		public By healthAndRiskPreviousPageButton() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("HealthAndRiskPreviousPageButton"));
		}
		
		public By healthAndRiskNextPageButton() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("HealthAndRiskNextPageButton"));
		}
		
		public By healthAndRiskLastPageButton() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("HealthAndRiskLastPageButton"));
		}

		
		public By healthAndRiskPageSelectorDropdown() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("HealthAndRiskPageSelectorDropdown"));
		}
		
		public By advisoryDetailsPopupHeader() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("AdvisoryDetailsPopupHeader"));
		}
		
		
		public By advisoryDetailsPopupContent() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("AdvisoryDetailsPopupContent"));
		}
		
		
		public By advisoryDetailsPopupManageAffectedProductsHeader() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("AdvisoryDetailsPopupManageAffectedProductsHeader"));
		}
		
		
		public By advisoryDetailsPopupManageAffectedProductsList() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("AdvisoryDetailsPopupManageAffectedProductsList"));
		}

		
		public By advisoryDetailsPopupManageAffectedProductsColumns() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("AdvisoryDetailsPopupManageAffectedProductsColumns"));
		}
		
		
		public By advisoryDetailsPopupManageAffectedProductsChevronUp() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("AdvisoryDetailsPopupManageAffectedProductsChevronUp"));
		}
		
		
		public By advisoryDetailsPopupManageAffectedProductsChevronDown() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("AdvisoryDetailsPopupManageAffectedProductsChevronDown"));
		}
		
		
		public By advisoryDetailsPopupCloseButton() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("AdvisoryDetailsPopupCloseButton"));
		}
				
		public By filterHeader() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("FilterHeader"));
		}
		
		
		public By filterResetSelectionButton() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("FilterResetSelectionButton"));
		}
		
		
		public By filterButtonNumberIcon() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("FilterButtonNumberIcon"));
		}
		
		
		public By noDataFoundMessage() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("NoDataFoundMessage"));
		}
		
		
		public By searchTextboxInFilterPopup() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("SearchTextboxInFilterPopup"));
		}
		
		
		public By searchTextErrorMessage() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("SearchTextErrorMessage"));
		}
		
		
		public By mapViewButton() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("MapViewButton"));
		}
		
		
		public By changeViewLink() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("ChangeViewLink"));
		}
		
		public By siteIDCheckbox() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("SiteIDCheckbox"));
		}

		
		public By updateButton() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("UpdateButton"));
		}
		
		
		public By technicalAdvisoryGraphAmerRegion() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("TechnicalAdvisoryGraphAmerRegion"));
		}
		
		
		public By technicalAdvisoryGraphRegionPopupHeader() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("TechnicalAdvisoryGraphRegionPopupHeader"));
		}
		
		public By technicalAdvisoryGraphRegionPopupDownloadButton() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("TechnicalAdvisoryGraphRegionPopupDownloadButton"));
		}

		public By technicalAdvisoryGraphRegionPopupCloseButton() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("TechnicalAdvisoryGraphRegionPopupCloseButton"));
		}
		
		public By technicalAdvisoryGraphHeader() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("TechnicalAdvisoryGraphHeader"));
		}
		
		public By healthAndRiskSearchTextbox() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("HealthAndRiskSearchTextbox"));
		}
		
		
		public By advisoryAmerRegionTotalIssues() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("AdvisoryAmerRegionTotalIssues"));
		}
		
		
		public By graphViewAdvisoryRegionsList() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("GraphViewAdvisoryRegionsList"));
		}
		
		
		public By advisoryAmerRegionArcs() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("AdvisoryAmerRegionArcs"));
		}
		
		
		public By severityBreadcrumbCrossButton() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("SeverityBreadcrumbCrossButton"));
		}
		
		
		public By severityColumnValues() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("SeverityColumnValues"));
		}
		
		
		public By advisoryDownArrowFirstRow() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("AdvisoryDownArrowFirstRow"));
		}
		
		
		public By advisoryExpandedViewLabelList() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("AdvisoryExpandedViewLabelList"));
		}
		
		
		public By expandedViewDownloadButton() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("ExpandedViewDownloadButton"));
		}
		
		
		public By filterBreadcrumbsList() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("FilterBreadcrumbsList"));
		}
		
		
		//lavanya
		
		public By DefaultAssetDisplayedUnderIB() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("DefaultAssetDisplayedUnderIB"));
		}
		public By ConnectivityInIBselected() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("ConnectivityInIBselected"));
		}
		public By CodeLevelsInIBselected() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("CodeLevelsInIBselected"));
		}
		public By ContractsInIBSelected() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("ContractsInIBSelected"));
		}
		public By IBStatusInFilterWindow() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("IBStatusInFilterWindow"));
		}
		
		public By IBStatusHeadingInFilterWindow() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("IBStatusHeadingInFilterWindow"));
		}
		public By DefaultSelectedFilterOptionsUnderIBInFilterWindow() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("DefaultSelectedFilterOptionsUnderIBInFilterWindow"));
		}
		public By UnCheckedFilterOptionsUnderIBStatusInFilterWindow() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("UnCheckedFilterOptionsUnderIBStatusInFilterWindow"));
		}
		
		public By TotalSRsSelectedUnderIMPage() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("TotalSRsSelectedUnderIMPage"));
		}
		public By FieldChangeOrderInHealthAndRisk() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("FieldChangeOrderInHealthAndRisk"));
		}
		public By SecurityAdvisoriesActiveAfterSelected() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("SecurityAdvisoriesActiveAfterSelected"));
		}
		
		public By TexhnicalAdvisoriesTabActiveAfterselected() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("TexhnicalAdvisoriesTabActiveAfterselected"));
		}
		public By TrackableServiceEventsActiveAfterSelected() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("TrackableServiceEventsActiveAfterSelected"));
		}
		public By TrackableServiceEventsTab() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("TrackableServiceEventsTab"));
		}
	
		public By invalidDataErrorMessage() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("InvalidDataErrorMessage"));
		}
		
		
		public By healthAndRiskSearchIcon() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("HealthAndRiskSearchIcon"));
		}
		
		
		public By prodNameColFirstRow() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("ProdNameColFirstRow"));
		}
		
		
		public By SrCreateDateFilter() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("SrCreateDateFilter"));
		}
		
		public By advisoryCheckboxFirstRow() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("AdvisoryCheckboxFirstRow"));
		}
				
		public By markAdvisoryLabel() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("MarkAdvisoryLabel"));
		}
		
		
		public By advisoryReviewButton() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("AdvisoryReviewButton"));
		}
		
		public By advisoryNotApplicableButton() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("AdvisoryNotApplicableButton"));
		}

		public By advisoryReviewButtonTooltip() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("AdvisoryReviewButtonTooltip"));
		}
		
		
		public By remediationStatusFilter() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("RemediationStatusFilter"));
		}
		
		
		public By remediationStatusHeader() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("RemediationStatusHeader"));
		}
		
		
		public By remediationStatusNew() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("RemediationStatusNew"));
		}
		
		
		public By productNameFilter() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("ProductNameFilter"));
		}
		
		public By productNameHeader() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("ProductNameHeader"));
		}
		
		public By productNameNone() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("ProductNameNone"));
		}
		
		
		public By productNameColUnavailableVal() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("ProductNameColUnavailableVal"));
		}

		
		public By installBaseExpandRightArrow() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("InstallBaseExpandRightArrow"));
		}
		
		public By advisoriesDateFilter() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("AdvisoriesDateFilter"));
		}
		
		public By advisoriesDateHeader() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("AdvisoriesDateHeader"));
		}
		
		
		public By advisoryFilterFromDatePicker() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("AdvisoryFilterFromDatePicker"));
		}
		
		public By advisoryFilterToDatePicker() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("AdvisoryFilterToDatePicker"));
		}

		
		public By advisoryFilterDatePickerTodayButton() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("AdvisoryFilterDatePickerTodayButton"));
		}
		
		
		public By advisoryFilterFromDatePickerPrevYearArrow() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("AdvisoryFilterFromDatePickerPrevYearArrow"));
		}
		
		public By advisoryFilterFromDatePickerNextYearArrow() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("AdvisoryFilterFromDatePickerNextYearArrow"));
		}
		
		
		public By advisoryFilterFromDatePickerTextbox() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("AdvisoryFilterFromDatePickerTextbox"));
		}
		
		
		public By advisoryFilterFromDatePickerNewDate() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("AdvisoryFilterFromDatePickerNewDate"));
		}
		
		
		public By advisoryFilterFromDatePickerNextMonthArrow() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("AdvisoryFilterFromDatePickerNextMonthArrow"));
		}
		
		
		public By installBaseExpandRowConnectivityStatus() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("InstallBaseExpandRowConnectivityStatus"));
		}
		
		
		public By connectivityHUDText() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("ConnectivityHUDText"));
		}
		
		
		public By connectivityStatusFilterOptionConnected() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("ConnectivityStatusFilterOptionConnected"));
		}
		
		
		public By codeLevelFilter() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("CodeLevelFilter"));
		}
		
		public By codeLevelFilterTargetPlusOption() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("CodeLevelFilterTargetPlusOption"));
		}
		
		public By codeLevelFilterHeader() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("CodeLevelFilterHeader"));
		}

		
		public By codeLevelHUDText() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("CodeLevelHUDText"));
		}
		
		
		public By contractsFilter() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("ContractsFilter"));
		}
		
		public By contractsFilterHeader() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("ContractsFilterHeader"));
		}
		
		public By contractsFilterExpiredOption() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("ContractsFilterExpiredOption"));
		}
		
		public By contractsHUDText() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("ContractsHUDText"));
		}

		
		public By salesOrderNumberValExpandedView() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("SalesOrderNumberValExpandedView"));
		}
		public By ContractsAfterClickingOnIt() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("ContractsAfterClickingOnIt"));
		}
		
		public By ContractByProductFamilyHeaderInGraphView() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("ContractByProductFamilyHeaderInGraphView"));
		}
		public By ViewByHeaderInGraphView() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("ViewByHeaderInGraphView"));
		}
		public By ProductFamilyHyperlink() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("ProductFamilyHyperlink"));
		}
		public By ContractCategoryHyperlinkAfterClickingOnProductFamilyHyperlink() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("ContractCategoryHyperlinkAfterClickingOnProductFamilyHyperlink"));
		}
		public By ContractCategoryInGrahView() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("ContractCategoryInGrahView"));
		}
		public By ProductFamilyInGraphView() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("ProductFamilyInGraphView"));
		}
		public By ListOfContractCategoryInGraphView() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("ListOfContractCategoryInGraphView"));
		}
		public By ColorOfExpiredCategory() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("ColorOfExpiredCategory"));
		}
		public By ColorOfCategoryNamesDisplayed() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("ColorOfCategoryNamesDisplayed"));
		}
		public By ExpiresWithIn30DaysColor() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("ExpiresWithIn30DaysColor"));
		}
		public By Expires31To90DaysColor() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("Expires31To90DaysColor"));
		}
		public By Expires91To180DaysColor() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("Expires91To180DaysColor"));
		}
		public By ExpiresBeyond180DaysColor() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("ExpiresBeyond180DaysColor"));
		}
		public By TerminatedColor() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("TerminatedColor"));
		}
		public By NAColor() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("NAColor"));
		}
		public By CategoryGraphHeadings() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("CategoryGraphHeadings"));
		}
		public By PercentageValuesOfGraphViewOfDifferentCategories() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("PercentageValuesOfGraphViewOfDifferentCategories"));
		}
		public By ExpiredCategoryBarInGraphView() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("ExpiredCategoryBarInGraphView"));
		}
		public By ExpiresWithIn30DaysCategoryBarInGraphView() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("ExpiresWithIn30DaysCategoryBarInGraphView"));
		}
		public By Expires31to90DaysCategoryBarInGraphView() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("Expires31to90DaysCategoryBarInGraphView"));
		}
		public By Expires91To180DaysCategoryBarInGraphView() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("Expires91To180DaysCategoryBarInGraphView"));
		}
		public By ExpiresBeyond180DaysCategoryBarInGraphView() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("ExpiresBeyond180DaysCategoryBarInGraphView"));
		}
		public By TerminatedBarInGraphView() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("TerminatedBarInGraphView"));
		}
		public By NABarInGraphView() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("NABarInGraphView"));
		}
		public By CountOfBars() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("CountOfBars"));
		}
		public By ViewMoreLink() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("ViewMoreLink"));
		}
		public By ViewLessLink() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("ViewLessLink"));
		}
		public By ValuesOfCategoriesInProductFamilyViewFirstBarDisplayed() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("ValuesOfCategoriesInProductFamilyViewFirstBarDisplayed"));
		}
		public By ValuesOfCategoriesInProductFamilyViewSecondBarDisplayed() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("ValuesOfCategoriesInProductFamilyViewSecondBarDisplayed"));
		}
		public By ProductNameInExpandedView() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("ProductNameInExpandedView"));
		}
		public By EligibleForConnectivityFilterInFilterWindow() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("EligibleForConnectivityFilterInFilterWindow"));
		}
		public By EligibleForConnectivityHeaderInFilterWindow() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("EligibleForConnectivityHeaderInFilterWindow"));
		}
		public By SearchBoxInEligibleForConnectivity() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("SearchBoxInEligibleForConnectivity"));
		}
		public By OptionsUnderEligibleForConnectivityFilter() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("OptionsUnderEligibleForConnectivityFilter"));
		}
		public By DefaultSelectedFilterOptionUnderEligibleForConnectivityFilter() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("DefaultSelectedFilterOptionUnderEligibleForConnectivityFilter"));
		}
		
		public By NotEligibleOptionUnderEligibleForConnectivityFilter() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("NotEligibleOptionUnderEligibleForConnectivityFilter"));
		}
		public By ConnectivityStatusInExpandedViewAfterApplyingFilter() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("ConnectivityStatusInExpandedViewAfterApplyingFilter"));
		}
		public By EligibleForCodeLevelsMgmtFilterInFilterWindow() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("EligibleForCodeLevelsMgmtFilterInFilterWindow"));
		}
		public By NonManagedOptionsUnderEligibleForCodeLevelsMgmtFilter() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("NonManagedOptionsUnderEligibleForCodeLevelsMgmtFilter"));
		}
		public By FirstProductFamilyName() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("FirstProductFamilyName"));
		}
		public By ListOfContractCategoryInProductFamilyPage() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("ListOfContractCategoryInProductFamilyPage"));
		}
		public By XButtonOnExpandedView() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("XButtonOnExpandedView"));
		}
		public By AwaitingActionsFilter() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("AwaitingActionsFilter"));
		}
		public By OptionsUnderAwaitingActionsFilter() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("OptionsUnderAwaitingActionsFilter"));
		}
		public By SelectYesUnderAwaitingActionsFilter() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("SelectYesUnderAwaitingActionsFilter"));
		}
		public By YesOptionAfterSelectingtheOption() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("YesOptionAfterSelectingtheOption"));
		}
		public By FooterLinks() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("FooterLinks"));
		}
		public By CountrySelector() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("CountrySelector"));
		}
		public By WindowPopUpWithMarketingMessage() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("WindowPopUpWithMarketingMessage"));
		}
		public By HardwareAssetsDisplayedInHUD() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("HardwareAssetsDisplayedInHUD"));
		}
		public By SoftwareAssetsDisplayedInHUD() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("SoftwareAssetsDisplayedInHUD"));
		}
		public By TotalSRsCircleOnHUDAfterUnderIMTabsDefaultView() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("TotalSRsCircleOnHUDAfterUnderIMTabsDefaultView"));
		}
		public By TotalSRsCircleOnHUDAfterUnderIMTabsDefaultView_IE() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("TotalSRsCircleOnHUDAfterUnderIMTabsDefaultView_IE"));
		}
		
		public By Severity2OnHUDUnderTotalSRsContext() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("Severity2OnHUDUnderTotalSRsContext"));
		}
		public By Severity1OnHUDUnderTotalSRsContext() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("Severity1OnHUDUnderTotalSRsContext"));
		}
		public By Severity3OnHUDUnderTotalSRsContext() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("Severity3OnHUDUnderTotalSRsContext"));
		}
		public By OthersOnHUDUnderTotalSRsContext() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("OthersOnHUDUnderTotalSRsContext"));
		}
		public By NameDisplayedINKPIForINstallBaseByDefault() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("NameDisplayedINKPIForINstallBaseByDefault"));
		}
		public By ValueDisplayedINKPIForINstallBaseByDefault() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("ValueDisplayedINKPIForINstallBaseByDefault"));
		}
		public By NameDisplayedINKPIForIncidentManagementByDefault() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("NameDisplayedINKPIForIncidentManagementByDefault"));
		}
		public By ValueDisplayedINKPIForIncidentManagementByDefault() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("ValueDisplayedINKPIForIncidentManagementByDefault"));
		}
		
		public By severityListAllRegions() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("SeverityListAllRegions"));
		}

		
		public By pendingAdvisoriesTab() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("PendingAdvisoriesTab"));
		}
		
		public By completedAdvisoriesTab() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("CompletedAdvisoriesTab"));
		}
		
		
		public By advisoryAmerRegionArcCritical() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("AdvisoryAmerRegionArcCritical"));
		}
		
		
		public By securityAdvisoryHUD() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("SecurityAdvisoryHUD"));
		}

		
		public By advisoryStatusValueFirstRow() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("AdvisoryStatusValueFirstRow"));
		}
		
		public By securityAdvisoryHUDTextName() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("SecurityAdvisoryHUDTextName"));
		}
		
		public By securityAdvisoryHUDTextValue() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("SecurityAdvisoryHUDTextValue"));
		}
		
		
		public By healthAndRiskHUDNames() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("HealthAndRiskHUDNames"));
		}
		
		
		public By technicalAdvisoryHUDCriticalArcValue() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("TechnicalAdvisoryHUDCriticalArcValue"));
		}
		
		public By technicalAdvisoryHUDHighArcValue() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("TechnicalAdvisoryHUDHighArcValue"));
		}
		
		public By technicalAdvisoryHUDMediumArcValue() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("TechnicalAdvisoryHUDMediumArcValue"));
		}
		
		public By technicalAdvisoryHUDLowArcValue() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("TechnicalAdvisoryHUDLowArcValue"));
		}
		
		public By technicalAdvisoryHUDTextName() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("TechnicalAdvisoryHUDTextName"));
		}
		
		public By technicalAdvisoryHUDTextValue() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("TechnicalAdvisoryHUDTextValue"));
		}
		
		
		public By technicalAdvisoryHUD() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("TechnicalAdvisoryHUD"));
		}
		

		public By securityAdvisoryHUDCriticalArcValue() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("SecurityAdvisoryHUDCriticalArcValue"));
		}
		
		public By securityAdvisoryHUDHighArcValue() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("SecurityAdvisoryHUDHighArcValue"));
		}
		
		public By securityAdvisoryHUDMediumArcValue() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("SecurityAdvisoryHUDMediumArcValue"));
		}
		
		public By securityAdvisoryHUDLowArcValue() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("SecurityAdvisoryHUDLowArcValue"));
		}

		
		public By installBaseColumns() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("InstallBaseColumns"));
		}
		
		
		public By ConnectedArcInGraph() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("ConnectedArcInGraph"));
		}
		
		public By NotConnectedArcInGraph() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("NotConnectedArcInGraph"));
		}

		
		public By ConnectivityStatusFilterOptionNotEligible() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("ConnectivityStatusFilterOptionNotEligible"));
		}

		
		public By notConnectedArcInHud() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("NotConnectedArcInHud"));
		}
		
		public By connectedArcInHud() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("ConnectedArcInHud"));
		}

		
		public By codeLevelBubbleChartTextList() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("CodeLevelBubbleChartTextList"));
		}
		
		public By codeLevelLegendChartTextList() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("CodeLevelLegendChartTextList"));
		}

		
		public By codeLevelHUDArcsList() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("CodeLevelHUDArcsList"));
		}

		
		public By advisoryReviewedPopupHeader() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("AdvisoryReviewedPopupHeader"));
		}
		
		
		public By advisoryReviewedPopupMessageUnderHeader() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("AdvisoryReviewedPopupMessageUnderHeader"));
		}
		
		
		public By advisoryReviewedPopupImportantNoteText() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("AdvisoryReviewedPopupImportantNoteText"));
		}
		
		
		public By advisoryReviewedPopupSubmitButton() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("AdvisoryReviewedPopupSubmitButton"));
		}
		
		public By advisoryReviewedPopupCancelButton() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("AdvisoryReviewedPopupCancelButton"));
		}
		
		public By advisoryReviewedPopupCloseButton() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("AdvisoryReviewedPopupCloseButton"));
		}
		
		public By advisoryReviewedPopupFirstCheckbox() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("AdvisoryReviewedPopupFirstCheckbox"));
		}
		
		public By DownloadButton() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("DownloadButton"));
		}
		
		public By SiteIDOverAllCheckBox() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("SiteIDOverAllCheckBox"));
		}
		public By SiteIDUnCheckAllCheckBox() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("SiteIDUnCheckAllCheckBox"));
		}
		public By ToSelectFirstSiteID() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("ToSelectFirstSiteID"));
		}
		public By ToSelectSecondSiteID() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("ToSelectSecondSiteID"));
		}
		public By UpdateButton() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("UpdateButton"));
		}
		public By ChooseYourSitesOrProductsHeader() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("ChooseYourSitesOrProductsHeader"));
		}
		
		public By ChangeViewHyperLink() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("ChangeViewHyperLink"));
		}
		public By ZeroCriticalDSAsInSummaryView() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("ZeroCriticalDSAsInSummaryView"));
		}
		public By ZeroCriticalDTA() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("ZeroCriticalDTA"));
		}
		public By ToolTipMessages() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("ToolTipMessages"));
		}
		public By BreadScrumbOfPortalPage() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("BreadScrumbOfPortalPage"));
		}
		public By HomeIconInBreadScrumbOfPortalPage() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("HomeIconInBreadScrumbOfPortalPage"));
		}
		public By SupportLinkInBreadScrumbOfPortalPage() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("SupportLinkInBreadScrumbOfPortalPage"));
		}
		public By MyService360InBreadScrumbOfPortalPage() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("MyService360InBreadScrumbOfPortalPage"));
		}
		public By SearchSupportHeaderAfterClickingOnSupportLink() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("SearchSupportHeaderAfterClickingOnSupportLink"));
		}
		public By BrowseMostPopularProductsHadingAfterClickingOnHomeIcon() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("BrowseMostPopularProductsHadingAfterClickingOnHomeIcon"));
		}
		
		public By healthRiskTrackableServiceEventsTab() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("HealthRiskTrackableServiceEventsTab"));
		}
		
		
		//Lavanya, Portal- Phase 2 - LKB
		public By HealthAndRiskTabP2() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("HealthAndRiskTabP2"));
		}
		
		public By DellSecurityAdvisoriesTab() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("DellSecurityAdvisoriesTab"));
		}
		public By DownArrowMarkToExpandSecurityAdvisory() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("DownArrowMarkToExpandSecurityAdvisory"));
		}
		public By UpArrowMarkToExpandSecurityAdvisory() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("UpArrowMarkToExpandSecurityAdvisory"));
		}
		public By ActionsHeader() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("ActionsHeader"));
		}
		public By DownloadOrPrintLink() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("DownloadOrPrintLink"));
		}
		public By AdvisoryIDLink() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("AdvisoryIDLink"));
		}
		public By AdvisoryPopUpHeader() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("AdvisoryPopUpHeader"));
		}
		public By HeaderOfPrintableViewArticle() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("HeaderOfPrintableViewArticle"));
		}
		public By PrintButtonInPrintableView() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("PrintButtonInPrintableView"));
		}
		public By DellTechnicalAdvisoriesTab() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("DellTechnicalAdvisoriesTab"));
		}
		public By HealthAndRiskTabAfterClickingOnIt() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("HealthAndRiskTabAfterClickingOnIt"));
		}
		public By TechnicalAdvisoryTabAfterClickingOnIt() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("TechnicalAdvisoryTabAfterClickingOnIt"));
		}
		public By SecurityAdvisoryTabAfterClickingOnIt() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("SecurityAdvisoryTabAfterClickingOnIt"));
		}
		
		public By BeforeClickingOnExpand() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("BeforeClickingOnExpand"));
		}
		public By SeeFullSecurityOrTechnicalAdvisoryLink() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("SeeFullSecurityOrTechnicalAdvisoryLink"));
		}
		public By DocumentationHeading() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("DocumentationHeading"));
		}
		public By DocumentationLinks() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("DocumentationLinks"));
		}
		public By SeeFullSecurityOrTechnicalAdvisoryLinkText() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("SeeFullSecurityOrTechnicalAdvisoryLinkText"));
		}
		public By NameDisplayedINKPIForIncidentManagementByDefault_IE() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("NameDisplayedINKPIForIncidentManagementByDefault_IE"));
		}
		public By ValueDisplayedINKPIForIncidentManagementByDefault_IE() throws Exception {

			return CommonUtility.getLocator(PortalPage_Data.get("ValueDisplayedINKPIForIncidentManagementByDefault_IE"));
		}
		
}

