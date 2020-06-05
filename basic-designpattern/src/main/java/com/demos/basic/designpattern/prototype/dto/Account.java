package com.demos.basic.designpattern.prototype.dto;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 员工
 * @date: 2019/05/23 18:55
 */
public class Account implements Serializable,Cloneable {

    private String accountId;

    private String accountName;

    private BigDecimal balance;

    public Account(){

    }

    public Account(String accountId, String accountName, BigDecimal balance){
        this.accountId = accountId;
        this.accountName = accountName;
        this.balance = balance;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
