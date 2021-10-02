package bank;

public enum TranceType {
    LOAN_FEE("loan fee"),
    INTEREST("interest"),
    WITHDRAW("withdraw"),
    DEPOSIT("deposit");
    private String tranceType;

    TranceType(String type) {
        this.tranceType = type;
    }

    public String getTranceType() {
        return tranceType;
    }
}
