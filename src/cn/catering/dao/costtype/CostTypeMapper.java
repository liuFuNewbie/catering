package cn.catering.dao.costtype;

import cn.catering.pojo.CostType;
import cn.catering.pojo.CostTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CostTypeMapper {
    int countByExample(CostTypeExample example);

    int deleteByExample(CostTypeExample example);

    int deleteByPrimaryKey(Integer costTypeId);

    int insert(CostType record);

    int insertSelective(CostType record);

    List<CostType> selectByExample(CostTypeExample example);

    CostType selectByPrimaryKey(Integer costTypeId);

    int updateByExampleSelective(@Param("record") CostType record, @Param("example") CostTypeExample example);

    int updateByExample(@Param("record") CostType record, @Param("example") CostTypeExample example);

    int updateByPrimaryKeySelective(CostType record);

    int updateByPrimaryKey(CostType record);
}