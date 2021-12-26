package com.xushibo.studyspringframework.di.beans;

public class AccountDao {

    private String accountName;

    private long accountAmount;

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountName() {
        return accountName;
    }

    public long getAccountAmount() {
        return accountAmount;
    }

    public void setAccountAmount(long accountAmount) {
        this.accountAmount = accountAmount;
    }

    @Override
    public String toString() {
        return "AccountDao{" +
                "accountName='" + accountName + '\'' +
                ", accountAmount=" + accountAmount +
                '}';
    }
}
