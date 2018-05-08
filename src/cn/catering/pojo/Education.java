package cn.catering.pojo;

import java.io.Serializable;

public class Education implements Serializable {
    private Integer educationId;

    private String educationName;

    private static final long serialVersionUID = 1L;

    public Integer getEducationId() {
        return educationId;
    }

    public void setEducationId(Integer educationId) {
        this.educationId = educationId;
    }

    public String getEducationName() {
        return educationName;
    }

    public void setEducationName(String educationName) {
        this.educationName = educationName == null ? null : educationName.trim();
    }
}