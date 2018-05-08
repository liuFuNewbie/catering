package cn.catering.pojo;

import java.io.Serializable;

public class DataPilot implements Serializable {
    private Integer dataPilotId;

    private String dataPilotName;

    private Integer grade;

    private Integer parent;

    private String webPagePath;

    private static final long serialVersionUID = 1L;

    public Integer getDataPilotId() {
        return dataPilotId;
    }

    public void setDataPilotId(Integer dataPilotId) {
        this.dataPilotId = dataPilotId;
    }

    public String getDataPilotName() {
        return dataPilotName;
    }

    public void setDataPilotName(String dataPilotName) {
        this.dataPilotName = dataPilotName == null ? null : dataPilotName.trim();
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public Integer getParent() {
        return parent;
    }

    public void setParent(Integer parent) {
        this.parent = parent;
    }

    public String getWebPagePath() {
        return webPagePath;
    }

    public void setWebPagePath(String webPagePath) {
        this.webPagePath = webPagePath == null ? null : webPagePath.trim();
    }
}