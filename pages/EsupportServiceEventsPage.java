package com.dell.delta_uat_automation.esupport.pages;

import org.openqa.selenium.By;

import com.dell.delta_uat_automation.utility.CommonUtility;

public class EsupportServiceEventsPage extends EsupportPojo{

	//Lavanya

	public By SearchInput() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("SearchInput"));
	}
	public By SearchButton() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("SearchButton"));
	}
	public By OverviewTab() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("OverviewTab"));
	}
	public By ServiceEvents() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("ServiceEvents"));
	}
	public By EmailSection() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("EmailSection"));
	}
	public By ValidateTextInEmailSection() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("ValidateTextInEmailSection"));
	}
	public By HeaderOfEmailSection() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("HeaderOfEmailSection"));
	}
	public By EmailInputTextBox() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("EmailInputTextBox"));
	}
	public By SubmitButton() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("SubmitButton"));
	}
	public By LandingPageServiceEventsTab() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("LandingPageServiceEventsTab"));
	}
	public By LabelOfCheckBox() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("LabelOfCheckBox"));
	}
	public By ValidateCheckBoxISChecked() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("ValidateCheckBoxISChecked"));
	}
	public By AlertMessage() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("AlertMessage"));
	}
	public By ValidateToggleButton() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("ValidateToggleButton"));
	}
	public By GetCountOfActiveAndClosedSE() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("GetCountOfActiveAndClosedSE"));
	}
	public By TitleOfSR() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("TitleOfSR"));
	}
	public By StatusOfSR() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("StatusOfSR"));
	}
	public By GetHeadingOfSRN() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("GetHeadingOfSRN"));
	}
	public By GetSRNNumber() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("GetSRNNumber"));
	}
	public By GetHeadingOfStatus() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("GetHeadingOfStatus"));
	}
	public By ServiceLifeEndAndWarrentyEndDate() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("ServiceLifeEndAndWarrentyEndDate"));
	}
	public By PresenceOfTodaysDate() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("PresenceOfTodaysDate"));
	}
	public By SEsDate() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("SEsDate"));
	}
	public By CountrySelectorArticle() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("CountrySelectorArticle"));
	}
	public By CountrySelectorList() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("CountrySelectorList"));
	}
	public By DocumentationTab() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("DocumentationTab"));
	}
	public By PresenceOfEventTypeOnLeftPanel() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("PresenceOfEventTypeOnLeftPanel"));
	}
	public By EventTypeSectionOnLeftPanel() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("EventTypeSectionOnLeftPanel"));
	}
	public By ValidateAllEventTypesOnLeftPanel() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("ValidateAllEventTypesOnLeftPanel"));
	}
	public By ClickExpandAllButtonOnLeftPanel() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("ClickExpandAllButtonOnLeftPanel"));
	}
	public By ValidateForCollapsebuttonForEachEventType() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("ValidateForCollapsebuttonForEachEventType"));
	}
	public By ValidateAllEventTypesOnLeftPanelAreExpanded() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("ValidateAllEventTypesOnLeftPanelAreExpanded"));
	}
	public By SelectAllCheckBoxOfEventTypesOfLeftPanel() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("SelectAllCheckBoxOfEventTypesOfLeftPanel"));
	}
	public By ApplyFiltersButton() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("ApplyFiltersButton"));
	}
	public By ClearFiltersButton() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("ClearFiltersButton"));
	}
	public By ValidatesFiltersInLeftPanel() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("ValidatesFiltersInLeftPanel"));
	}
	public By ValidateFiltersSectionAfterApplyingFilterOnLeftPanel() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("ValidateFiltersSectionAfterApplyingFilterOnLeftPanel"));
	}
	public By ShowAllButtonInFiltersSection() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("ShowAllButtonInFiltersSection"));
	}
	public By XButtonInFiltersSection() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("XButtonInFiltersSection"));
	}
	public By PresenceOFShipDate() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("PresenceOFShipDate"));
	}
	public By ClickOnExpandButtonOnEventTypeServiceRequest() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("ClickOnExpandButtonOnEventTypeServiceRequest"));
	}
	public By ClickCollapseAllButtonOnLeftPanel() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("ClickCollapseAllButtonOnLeftPanel"));
	}
	public By SelectAllCheckBoxOfEventTypesOfLeftPanelByKeepingCountAsReference() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("SelectAllCheckBoxOfEventTypesOfLeftPanelByKeepingCountAsReference"));
	}
	public By ClickExpandButtonOnMilestoneEventType() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("ClickExpandButtonOnMilestoneEventType"));
	}
	public By SelectCheckBoxUnderMilestones() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("SelectCheckBoxUnderMilestones"));
	}
	public By ValidateTwoDatePickerBoxSection() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("ValidateTwoDatePickerBoxSection"));
	}
	public By ValidateTwoDatePickerBoxDisplayed() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("ValidateTwoDatePickerBoxDisplayed"));
	}
	public By CountOfDispatches() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("CountOfDispatches"));
	}
	public By ValidateClickOnFirstDatePickerToDisplayCalender() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("ValidateClickOnFirstDatePickerToDisplayCalender"));
	}
	public By SelectMonthAndYearFromFirstDatePicker() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("SelectMonthAndYearFromFirstDatePicker"));
	}
	public By ValidateDaySectionOfFirstDatePicker() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("ValidateDaySectionOfFirstDatePicker"));
	}
	public By SelectDayFromFirstDatePicker() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("SelectDayFromFirstDatePicker"));
	}
	public By ValidateClickOnSecondDatePickerToDisplayCalender() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("ValidateClickOnSecondDatePickerToDisplayCalender"));
	}
	public By SelectMonthAndYearFromSecondDatePicker() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("SelectMonthAndYearFromSecondDatePicker"));
	}
	public By ValidateDaySectionOfSecondDatePicker() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("ValidateDaySectionOfSecondDatePicker"));
	}
	public By SelectDayFromSecondDatePicker() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("SelectDayFromSecondDatePicker"));
	}
	public By ValidateTextInEmailSectionInOverviewTab() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("ValidateTextInEmailSectionInOverviewTab"));
	}
	public By HeaderOfEmailSectionInOverviewTab() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("HeaderOfEmailSectionInOverviewTab"));
	}
	public By EmailInputTextBoxInOverviewTab() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("EmailInputTextBoxInOverviewTab"));
	}
	public By SubmitButtonInOverviewTab() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("SubmitButtonInOverviewTab"));
	}
	public By EmailSectionInOverviewTab() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("EmailSectionInOverviewTab"));
	}
	public By ServiceEventsCountInOverviewTab() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("ServiceEventsCountInOverviewTab"));
	}
	public By ClickOnViewAll() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("ClickOnViewAll"));
	}
	public By HeadingOfServiceEventsInOverviewTab() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("HeadingOfServiceEventsInOverviewTab"));
	}
	public By StatusOfSRInOverviewTab() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("StatusOfSRInOverviewTab"));
	}
	public By ClickOnFirstDatePicker() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("ClickOnFirstDatePicker"));
	}
	public By ClickOnSecondDatePicker() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("ClickOnSecondDatePicker"));
	}
	public By SelectMonthFromFirstDatePicker() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("SelectMonthFromFirstDatePicker"));
	}
	public By SelectYearFromFirstDatePicker() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("SelectYearFromFirstDatePicker"));
	}
	public By SelectMonthFromSecondDatePicker() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("SelectMonthFromSecondDatePicker"));
	}
	public By SelectYearFromSecondDatePicker() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("SelectYearFromSecondDatePicker"));
	}
	
	public By SelectWeekDaysFromSecondDatePicker() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("SelectWeekDaysFromSecondDatePicker"));
	}
	public By SelectWeekDaysFromFirstDatePicker() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("SelectWeekDaysFromFirstDatePicker"));
	}
	public By ValidateActiveDispatchIsSelectedByDefault() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("ValidateActiveDispatchIsSelectedByDefault"));
	}
	public By ClickOnExpandButtonOnDispatches() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("ClickOnExpandButtonOnDispatches"));
	}
	public By SelectClosedDispatches() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("SelectClosedDispatches"));
	}
	public By ExpandIconOfDispatchesValidation() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("ExpandIconOfDispatchesValidation"));
	}
	public By ClickOnExpandIconOfDispatch() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("ClickOnExpandIconOfDispatch"));
	}
	public By GetTextFromDispatches() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("GetTextFromDispatches"));
	}
	public By ClickOnServiceRequestNumberOfDispatch() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("ClickOnServiceRequestNumberOfDispatch"));
	}
	public By ClickOnDispatchNumberOfDispatch() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("ClickOnDispatchNumberOfDispatch"));
	}
	public By StatusOfOnlyDispatches() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("StatusOfOnlyDispatches"));
	}
	public By ServiceRequestActivity() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("ServiceRequestActivity"));
	}
	public By ActivityHistoryDetails() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("ActivityHistoryDetails"));
	}
	public By CaptureDispatchNumber() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("CaptureDispatchNumber"));
	}
	public By ClickOnInactiveServiceRequest() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("ClickOnInactiveServiceRequest"));
	}
	public By ExpandIconOfServiceRequestsValidation() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("ExpandIconOfServiceRequestsValidation"));
	}
	public By ClickOnExpandIconOfServiceRequest() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("ClickOnExpandIconOfServiceRequest"));
	}
	public By EmailEntryAfterClickingBack() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("EmailEntryAfterClickingBack"));
	}
	public By SubmitButtonAfterClickingBack() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("SubmitButtonAfterClickingBack"));
	}
	public By GetTextFromServiceRequests() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("GetTextFromServiceRequests"));
	}
	public By ClickOnSRNOfServiceResquest() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("ClickOnSRNOfServiceResquest"));
	}
	
	public By FCOTextInOverviewTab() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("FCOTextInOverviewTab"));
	}
	
	public By FCOServiceRequestLabel() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("FCOServiceRequestLabel"));
	}
	
	public By FCOServiceRequestNumber() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("FCOServiceRequestNumber"));
	}
	
	public By FCOSeverityLabel() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("FCOSeverityLabel"));
	}
	
	public By FCOSeverityValue() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("FCOSeverityValue"));
	}
	
	public By FCODateCreatedLabel() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("FCODateCreatedLabel"));
	}
	
	public By FCODateCreatedValue() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("FCODateCreatedValue"));
	}
	
	public By ServiceEventsHeaderInOverivewTab() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("ServiceEventsHeaderInOverivewTab"));
	}

	
	public By ServiceRequestTextInOverviewTab() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("ServiceRequestTextInOverviewTab"));
	}
	
	public By ServiceRequestLabel() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("ServiceRequestLabel"));
	}
	
	public By ServiceRequestNumber() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("ServiceRequestNumber"));
	}
	
	public By SRSeverityLabel() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("SRSeverityLabel"));
	}
	
	public By SRSeverityValue() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("SRSeverityValue"));
	}
	
	public By SRStatusLabel() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("SRStatusLabel"));
	}
	
	public By SRStatusValue() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("SRStatusValue"));
	}
	
	public By serviceEventsTypeHeaderSETab() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("ServiceEventsTypeHeaderSETab"));
	}

	
	public By eventTypesListSETab() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("EventTypesListSETab"));
	}
	
	
	public By serviceRequestExpandIconLeftPanelSETab() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("ServiceRequestExpandIconLeftPanelSETab"));
	}
	
	
	public By serviceRequestFiltersLeftPanelSETab() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("ServiceRequestFiltersLeftPanelSETab"));
	}
	
	public By serviceRequestLabelLeftPanelSETab() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("ServiceRequestLabelLeftPanelSETab"));
	}
	
	
	public By appliedFiltersTextLeftPanelSETab() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("AppliedFiltersTextLeftPanelSETab"));
	}
	
	
	public By jumpToTopIconSETab() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("JumpToTopIconSETab"));
	}
	
	
	public By changeLanguageLink() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("ChangeLanguageLink"));
	}
	
	
	public By serviceEventActivityCardHeader() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("ServiceEventActivityCardHeader"));
	}
	
	public By serviceEventActivityDonutNumber() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("ServiceEventActivityDonutNumber"));
	}
	
	public By serviceEventActivityDonutText() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("ServiceEventActivityDonutText"));
	}
	
	public By serviceEventActivityCardActiveLink() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("ServiceEventActivityCardActiveLink"));
	}
	
	public By serviceEventActivityCardActiveNumber() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("ServiceEventActivityCardActiveNumber"));
	}
	
	public By serviceEventActivityCardEscalatedLink() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("ServiceEventActivityCardEscalatedLink"));
	}
	
	public By serviceEventActivityCardEscalatedNumber() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("ServiceEventActivityCardEscalatedNumber"));
	}
	
	public By serviceEventActivityCardAwaitingLink() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("ServiceEventActivityCardAwaitingLink"));
	}
	
	public By serviceEventActivityCardAwaitingNumber() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("ServiceEventActivityCardAwaitingNumber"));
	}
	
	public By serviceEventActivityCardEscalatedIcon() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("ServiceEventActivityCardEscalatedIcon"));
	}
	
	public By serviceEventActivityCardAwaitingIcon() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("ServiceEventActivityCardAwaitingIcon"));
	}
	
	public By serviceEventActivityCardActiveIcon() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("ServiceEventActivityCardActiveIcon"));
	}
	
	
	public By NoActiveServiceEventsMessage() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("NoActiveServiceEventsMessage"));
	}

	
	public By showConnectivityEventsLabel() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("ShowConnectivityEventsLabel"));
	}
	
	public By showConnectivityEventsCheckbox() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("ShowConnectivityEventsCheckbox"));
	}

	
	public By showConnectivityEventsToggleButton() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("ShowConnectivityEventsToggleButton"));
	}
	
	
	public By timelineTextToday() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("TimelineTextToday"));
	}
	
	public By timelineTextTodayDate() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("TimelineTextTodayDate"));
	}
	
	
	public By connectivityEventsExpandIcon() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("ConnectivityEventsExpandIcon"));
	}
	
	public By connectHomeCheckbox() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("ConnectHomeCheckbox"));
	}
	
	public By connectInCheckbox() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("ConnectInCheckbox"));
	}
	
	
	public By connectHomeFilterLabel() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("ConnectHomeFilterLabel"));
	}
	
	public By connectInFilterLabel() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("ConnectInFilterLabel"));
	}

	
	public By ExportButton() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("ExportButton"));
	}

	
	public By EscalatedCheckbox() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("EscalatedCheckbox"));
	}
	
	
	public By EventName() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("EventName"));
	}
	
	
	public By SRNumberSETab() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("SRNumberSETab"));
	}
	
	public By SRSeveritySETab() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("SRSeveritySETab"));
	}
	
	public By SRStatusSETab() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("SRStatusSETab"));
	}

	
	public By SRExpandButton() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("SRExpandButton"));
	}
	
	public By CreatedLabel() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("CreatedLabel"));
	}
	
	public By CreatedValue() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("CreatedValue"));
	}
	
	public By SummaryLabel() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("SummaryLabel"));
	}
	
	public By SummaryValue() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("SummaryValue"));
	}

	
	public By ActiveEventName() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("ActiveEventName"));
	}
	
	public By ActiveSRNumber() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("ActiveSRNumber"));
	}
	
	public By ActiveSeverity() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("ActiveSeverity"));
	}
	
	public By ActiveStatus() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("ActiveStatus"));
	}
	
	public By ActiveFilterCheckbox() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("ActiveFilterCheckbox"));
	}

	public By ClosedFilterCheckbox() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("ClosedFilterCheckbox"));
	}
	
	
	public By ServiceRequestFilterCheckbox() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("ServiceRequestFilterCheckbox"));
	}
	
	
	public By ScheduledServicesExpandIcon() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("ScheduledServicesExpandIcon"));
	}
	
	public By CorrectiveMaintenanceCheckbox() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("CorrectiveMaintenanceCheckbox"));
	}
	
	
	public By StartTimeValue() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("StartTimeValue"));
	}
	
	public By EndTimeValue() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("EndTimeValue"));
	}
	
	public By Status() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("Status"));
	}
	
	public By Technician() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("Technician"));
	}
	
	public By OnsiteContact() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("OnsiteContact"));
	}
	
	
	public By activeEventsToggle() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("ActiveEventsToggle"));
	}
	
	public By activeEventsCheckbox() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("ActiveEventsCheckbox"));
	}
	
	
	public By FromDateTextbox() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("FromDateTextbox"));
	}
	
	public By ToDateTextbox() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("ToDateTextbox"));
	}
	
	public By MilestonesExpandIcon() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("MilestonesExpandIcon"));
	}
	
	public By MilestonesFilterList() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("MilestonesFilterList"));
	}

	
	public By MilestonesFilterCheckbox() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("MilestonesFilterCheckbox"));
	}

	
	public By AdvisoriesExpandIcon() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("AdvisoriesExpandIcon"));
	}
	
	public By TechnicalAdvisoryCheckbox() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("TechnicalAdvisoryCheckbox"));
	}
	
	public By AdvisoryName() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("AdvisoryName"));
	}
	
	public By AdvisoryTitle() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("AdvisoryTitle"));
	}
	
	public By TitleExpandedView() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("TitleExpandedView"));
	}
	
	public By AdvisoryIDExpandedView() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("AdvisoryIDExpandedView"));
	}
	
	public By UpdatedByExpandedView() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("UpdatedByExpandedView"));
	}
	
	public By ArticleAgeExpandedView() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("ArticleAgeExpandedView"));
	}

	
	public By AdvisoriesFilterList() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("AdvisoriesFilterList"));
	}
	
	
	public By ChangesSubmissionExpandIcon() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("ChangesSubmissionExpandIcon"));
	}
	
	public By ChangesSubmissionFiltersList() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("ChangesSubmissionFiltersList"));
	}
	
	public By InstallBaseChangeCheckbox() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("InstallBaseChangeCheckbox"));
	}
	
	public By ContactSalesSubmissionCheckbox() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("ContactSalesSubmissionCheckbox"));
	}
	
	public By ServicePlanContractText() throws Exception
	{
		return CommonUtility.getLocator(ServiceEventsHomePage_Data.get("ServicePlanContractText"));
	}

}
