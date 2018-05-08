package cn.catering.dao.elsecost;

import cn.catering.pojo.ElseCost;
import cn.catering.pojo.ElseCostExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ElseCostMapper {
    int countByExample(ElseCostExample example);

    int deleteByExample(ElseCostExample example);

    int deleteByPrimaryKey(Integer costId);

    int insert(ElseCost record);

    int insertSelective(ElseCost record);

    List<ElseCost> selectByExample(ElseCostExample example);

    ElseCost selectByPrimaryKey(Integer costId);

    int updateByExampleSelective(@Param("record") ElseCost record, @Param("example") ElseCostExample example);

    int updateByExample(@Param("record") ElseCost record, @Param("example") ElseCostExample example);

    int updateByPrimaryKeySelective(ElseCost record);

    int updateByPrimaryKey(ElseCost record);
}