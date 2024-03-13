package com.home.expensetrack.datamigrate.tracker2024;

public enum GroupTag {

    Christmas("Christmas"),
    Manipur("Manipur"),
    AGMMeeting("AGM-Meeting"),
    ACBMFee("ACBulletinMembershipFee"),
    AC5PercentOfDonations("AC5PercentContribution");

    private final String value;

    GroupTag(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
