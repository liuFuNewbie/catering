package cn.catering.pojo;

import java.io.Serializable;

public class PayType implements Serializable {
    private Integer payId;

    private String payName;

    private static final long serialVersionUID = 1L;

    public Integer getPayId() {
        return payId;
    }

    public void setPayId(Integer payId) {
        this.payId = payId;
    }

    public String getPayName() {
        return payName;
    }

    public void setPayName(String payName) {
        this.payName = payName == null ? null : payName.trim();
    }
}