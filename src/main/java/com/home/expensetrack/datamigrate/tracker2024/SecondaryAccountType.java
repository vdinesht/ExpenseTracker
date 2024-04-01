package com.home.expensetrack.datamigrate.tracker2024;

public enum SecondaryAccountType {
    GiftCard("Gift Card"),
    ShellChargeCard("Shell Charge Card"),
    CEFCU_Dinesh("CEFCU - Dinesh"),
    SearsMasterCard("Sears Master Card"),
    SamsClubDiscoverCard("Sams Club Discover Card"),
    BergnersCard("Bergners Card"),
    JCPenneyCard("JCPenney Card"),
    ChaseCard("Chase Card"),
    SearsChargeCard("Sears Charge Card"),
    FamousBaar_MacysCard("Famous Baar - Macys Card"),
    KohlsCard("Kohls Card"),
    ProvidianCard("Providian Card"),
    Sodexo("Sodexo"),
    SBIAdvantage_Dinesh("SBI Advantage - Dinesh"),
    SBIAdvantage_Sebina("SBI Advantage - Sebina"),
    HSBC_Dinesh("HSBC - Dinesh"),
    HSBC_Sebina("HSBC - Sebina"),
    SBIElite_Dinesh("SBI Elite - Dinesh"),
    Amex_Dinesh("Amex - Dinesh"),
    SBIGM_Dinesh("SBI GM - Dinesh"),
    CEFCUChecking_Dinesh("CEFCU Checking - Dinesh"),
    CEFCUChecking_Sebina("CEFCU Checking - Sebina"),
    CEFCUSaving_Dinesh("CEFCU Saving - Dinesh"),
    CEFCUSaving_Sebina("CEFCU Saving - Sebina"),
    ICICINglJoint("ICICI Ngl Joint"),
    ICICIThoraipakkam_Dinesh("ICICI Thoraipakkam - Dinesh"),
    ICICIThoraipakkam_Sebina("ICICI Thoraipakkam -  Sebina"),
    SBIKulithuraiNRE("SBI Kulithurai NRE"),
    ICICINglNRE("ICICI Ngl NRE"),
    CanaraBankGuindy("Canara Bank Guindy"),
    SBIPerungudi_Dinesh("SBI Perungudi - Dinesh"),
    SBIPerungudi_Sebina("SBI Perungudi - Sebina"),
    SBIGreenAcresHomeLoan("SBI Green Acres Home Loan"),
    HSBCHomeLoan("HSBC Home Loan"),
    IndiaBullsHomeLoan("India Bulls Home Loan"),
    CanaraBankAdyar("Canara Bank Adyar"),
    HSBCPerungudi_Dinesh("HSBC Perungudi - Dinesh"),
    HSBCPerungudi_Netanya("HSBC Perungudi - Netanya"),
    HousingExpenses("Housing Expenses"),
    TravelExpense("Travel Expense"),
    FoodExpenses("Food Expenses"),
    ClothingExpenses("Clothing Expenses"),
    EducationExpenses("Education Expenses"),
    OtherExpense("Other Expense"),
    PersonalLoan("Personal Loan"),
    VendorBank("Vendor Bank"),
    CaterpillarInc("Caterpillar Inc"),
    StaffMgmt("Staff Mgmt"),
    CaterpillarIndia("Caterpillar India"),
    Aurigo("Aurigo"),
    Tenant("Tenant"),
    SBI("SBI"),
    ICICI("ICICI"),
    MedicalExpense("Medical Expense"),
    CEFCU("CEFCU"),
    OtherBank("Other Bank");
    private final String value;

    SecondaryAccountType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
