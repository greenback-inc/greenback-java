package com.greenback.kit.model;

public class Entitlements {

    private String dashboardExperience;     // this is an enum, but we'll do a string for now
    private Boolean personalWorkspace;
    private Boolean manageConnects;
    private Boolean onboardingWizard;
    private Boolean trialing;
    private Boolean showAccounts;
    private EntitlementFeaturePermission autoExport;
    private EntitlementFeaturePermission bulkExport;
    private EntitlementFeaturePermission mailboxDelivery;

    public String getDashboardExperience() {
        return dashboardExperience;
    }

    public Entitlements setDashboardExperience(String dashboardExperience) {
        this.dashboardExperience = dashboardExperience;
        return this;
    }

    public Boolean getPersonalWorkspace() {
        return personalWorkspace;
    }

    public Entitlements setPersonalWorkspace(Boolean personalWorkspace) {
        this.personalWorkspace = personalWorkspace;
        return this;
    }

    public Boolean getManageConnects() {
        return manageConnects;
    }

    public Entitlements setManageConnects(Boolean manageConnects) {
        this.manageConnects = manageConnects;
        return this;
    }

    public Boolean getOnboardingWizard() {
        return onboardingWizard;
    }

    public Entitlements setOnboardingWizard(Boolean onboardingWizard) {
        this.onboardingWizard = onboardingWizard;
        return this;
    }

    public Boolean getTrialing() {
        return trialing;
    }

    public Entitlements setTrialing(Boolean trialing) {
        this.trialing = trialing;
        return this;
    }

    public Boolean getShowAccounts() {
        return showAccounts;
    }

    public Entitlements setShowAccounts(Boolean showAccounts) {
        this.showAccounts = showAccounts;
        return this;
    }

    public EntitlementFeaturePermission getAutoExport() {
        return autoExport;
    }

    public Entitlements setAutoExport(EntitlementFeaturePermission autoExport) {
        this.autoExport = autoExport;
        return this;
    }

    public EntitlementFeaturePermission getBulkExport() {
        return bulkExport;
    }

    public Entitlements setBulkExport(EntitlementFeaturePermission bulkExport) {
        this.bulkExport = bulkExport;
        return this;
    }

    public EntitlementFeaturePermission getMailboxDelivery() {
        return mailboxDelivery;
    }

    public Entitlements setMailboxDelivery(EntitlementFeaturePermission mailboxDelivery) {
        this.mailboxDelivery = mailboxDelivery;
        return this;
    }

}