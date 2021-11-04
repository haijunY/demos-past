package com.yhj.study.spring.event.entity;

/**
 * @author yinhaijun
 * @description:
 * @date 2021/9/28 16:37
 */
public class Order {

    private Long id;
    private String buyer;
    private String seller;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBuyer() {
        return buyer;
    }

    public void setBuyer(String buyer) {
        this.buyer = buyer;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }
}
