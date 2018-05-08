package cn.catering.dao.elsecost;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.catering.pojo.ElseCost;
import cn.catering.pojo.Employee;
import cn.catering.pojo.Member;
import cn.catering.tools.PageSupport;

public interface ElseCostMapperCustom {
	/**
	 * 统计总数
	 * @param costName
	 * @return
	 */
	public int getElsecostCount(@Param("costName")String costName);
	/**
	 * 根据名称,当前页号，每页尺寸获取分页数据
	 * @param costName
	 * @param pageSupport
	 * @return
	 */
	public List<ElseCost> getElsecostList(@Param("costName") String costName,@Param("pageSupport") PageSupport pageSupport);
	/**
	 * 按名称查询
	 * @param costName
	 * @return
	 * @throws SQLException
	 */
	boolean getElsecostCoByName(@Param("costName") String costName) throws SQLException;
	/**
	 * 按ID查询数据   再进行修改
	 * @Title: getMemberByid
	 * @Description:
	 * @author: zjb
	 * @param memberId
	 * @return
	 * @throws SQLException
	 */
	public ElseCost getElseCostByid(@Param("costId")Integer costId)throws SQLException;
	/**
	 *修改
	 * @param elseCost
	 * @return
	 * @throws SQLException
	 */
	public boolean updateElseCost(ElseCost elseCost)throws SQLException;
	/**
	 * 获取全部员工姓名
	 * @return
	 * @throws SQLException
	 */
	public List<Employee> listEmployees()throws SQLException;
	/**
	 * 添加
	 * @param elseCost
	 * @return
	 * @throws Exception
	 */
	public boolean addElseCost(ElseCost elseCost)throws SQLException;
	
}   


