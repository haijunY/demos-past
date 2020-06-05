package com.demos.basic.designpattern.prototype.dto;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @date: 2019/05/23 18:31
 */
public class TransferModel implements Serializable,Cloneable{

    private Account account1;

    private Account account2;

    private BigDecimal tradeAmount;

    public Account getAccount1() {
        return account1;
    }

    public void setAccount1(Account account1) {
        this.account1 = account1;
    }

    public Account getAccount2() {
        return account2;
    }

    public void setAccount2(Account account2) {
        this.account2 = account2;
    }

    public BigDecimal getTradeAmount() {
        return tradeAmount;
    }

    public void setTradeAmount(BigDecimal tradeAmount) {
        this.tradeAmount = tradeAmount;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
