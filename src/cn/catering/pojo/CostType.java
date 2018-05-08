package cn.catering.pojo;

import java.io.Serializable;

public class CostType implements Serializable {
    private Integer costTypeId;

    private String name;

    private static final long serialVersionUID = 1L;

    public Integer getCostTypeId() {
        return costTypeId;
    }

    public void setCostTypeId(Integer costTypeId) {
        this.costTypeId = costTypeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}