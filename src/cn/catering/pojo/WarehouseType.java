package cn.catering.pojo;

import java.io.Serializable;

public class WarehouseType implements Serializable {
    private Integer warehouseId;

    private String warehouseName;

    private static final long serialVersionUID = 1L;

    public Integer getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Integer warehouseId) {
        this.warehouseId = warehouseId;
    }

    public String getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName == null ? null : warehouseName.trim();
    }
}