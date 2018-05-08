package cn.catering.dao.warehousetype;

import cn.catering.pojo.WarehouseType;
import cn.catering.pojo.WarehouseTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WarehouseTypeMapper {
    int countByExample(WarehouseTypeExample example);

    int deleteByExample(WarehouseTypeExample example);

    int deleteByPrimaryKey(Integer warehouseId);

    int insert(WarehouseType record);

    int insertSelective(WarehouseType record);

    List<WarehouseType> selectByExample(WarehouseTypeExample example);

    WarehouseType selectByPrimaryKey(Integer warehouseId);

    int updateByExampleSelective(@Param("record") WarehouseType record, @Param("example") WarehouseTypeExample example);

    int updateByExample(@Param("record") WarehouseType record, @Param("example") WarehouseTypeExample example);

    int updateByPrimaryKeySelective(WarehouseType record);

    int updateByPrimaryKey(WarehouseType record);
}