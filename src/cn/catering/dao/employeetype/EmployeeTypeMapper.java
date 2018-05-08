package cn.catering.dao.employeetype;

import cn.catering.pojo.EmployeeType;
import cn.catering.pojo.EmployeeTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EmployeeTypeMapper {
    int countByExample(EmployeeTypeExample example);

    int deleteByExample(EmployeeTypeExample example);

    int deleteByPrimaryKey(Integer empTypeId);

    int insert(EmployeeType record);

    int insertSelective(EmployeeType record);

    List<EmployeeType> selectByExample(EmployeeTypeExample example);

    EmployeeType selectByPrimaryKey(Integer empTypeId);

    int updateByExampleSelective(@Param("record") EmployeeType record, @Param("example") EmployeeTypeExample example);

    int updateByExample(@Param("record") EmployeeType record, @Param("example") EmployeeTypeExample example);

    int updateByPrimaryKeySelective(EmployeeType record);

    int updateByPrimaryKey(EmployeeType record);
}