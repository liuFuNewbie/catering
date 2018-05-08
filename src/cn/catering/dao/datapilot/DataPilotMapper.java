package cn.catering.dao.datapilot;

import cn.catering.pojo.DataPilot;
import cn.catering.pojo.DataPilotExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DataPilotMapper {
    int countByExample(DataPilotExample example);

    int deleteByExample(DataPilotExample example);

    int deleteByPrimaryKey(Integer dataPilotId);

    int insert(DataPilot record);

    int insertSelective(DataPilot record);

    List<DataPilot> selectByExample(DataPilotExample example);

    DataPilot selectByPrimaryKey(Integer dataPilotId);

    int updateByExampleSelective(@Param("record") DataPilot record, @Param("example") DataPilotExample example);

    int updateByExample(@Param("record") DataPilot record, @Param("example") DataPilotExample example);

    int updateByPrimaryKeySelective(DataPilot record);

    int updateByPrimaryKey(DataPilot record);
}