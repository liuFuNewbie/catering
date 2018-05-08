package cn.catering.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Business implements Serializable {
    private Integer businessId;

    private BigDecimal due;

    private BigDecimal accountPaid;

    private Date createDate;

    private String remark;

    private Integer supplierId;

    private Integer empId;

    private static final long serialVersionUID = 1L;

    public Integer getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Integer businessId) {
        this.businessId = businessId;
    }

    public BigDecimal getDue() {
        return due;
    }

    public void setDue(BigDecimal due) {
        this.due = due;
    }

    public BigDecimal getAccountPaid() {
        return accountPaid;
    }

    public void setAccountPaid(BigDecimal accountPaid) {
        this.accountPaid = accountPaid;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }
}