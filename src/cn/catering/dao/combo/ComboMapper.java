package cn.catering.dao.combo;

import cn.catering.pojo.Combo;
import cn.catering.pojo.ComboExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ComboMapper {
    int countByExample(ComboExample example);

    int deleteByExample(ComboExample example);

    int deleteByPrimaryKey(Integer comboId);

    int insert(Combo record);

    int insertSelective(Combo record);

    List<Combo> selectByExample(ComboExample example);

    Combo selectByPrimaryKey(Integer comboId);

    int updateByExampleSelective(@Param("record") Combo record, @Param("example") ComboExample example);

    int updateByExample(@Param("record") Combo record, @Param("example") ComboExample example);

    int updateByPrimaryKeySelective(Combo record);

    int updateByPrimaryKey(Combo record);
}