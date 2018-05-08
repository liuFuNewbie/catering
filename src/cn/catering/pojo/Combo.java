package cn.catering.pojo;

import java.io.Serializable;

public class Combo implements Serializable {
    private Integer comboId;

    private String comboName;

    private static final long serialVersionUID = 1L;

    public Integer getComboId() {
        return comboId;
    }

    public void setComboId(Integer comboId) {
        this.comboId = comboId;
    }

    public String getComboName() {
        return comboName;
    }

    public void setComboName(String comboName) {
        this.comboName = comboName == null ? null : comboName.trim();
    }


}