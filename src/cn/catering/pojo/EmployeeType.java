package cn.catering.pojo;

import java.io.Serializable;

public class EmployeeType implements Serializable {
    private Integer empTypeId;

    private String empTypeName;

    private static final long serialVersionUID = 1L;

    public Integer getEmpTypeId() {
        return empTypeId;
    }

    public void setEmpTypeId(Integer empTypeId) {
        this.empTypeId = empTypeId;
    }

    public String getEmpTypeName() {
        return empTypeName;
    }

    public void setEmpTypeName(String empTypeName) {
        this.empTypeName = empTypeName == null ? null : empTypeName.trim();
    }
}