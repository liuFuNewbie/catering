package cn.catering.service.elsecost;

import java.sql.SQLException;
import java.util.List;

import cn.catering.pojo.ElseCost;
import cn.catering.pojo.Employee;
import cn.catering.pojo.Member;
import cn.catering.tools.PageSupport;

public interface ElsecostService {
	
	/**
	 * 
	 * 根据名称,当前页号，每页尺寸获取分页数据
	 * @param costName
	 * @param pageSupport
	 * @return
	 * @throws SQLException
	 */
	public List<ElseCost> getElsecostList(String costName,PageSupport pageSupport) throws SQLException;
	/**
	 * 统计总数
	 * @param costName
	 * @return
	 * @throws SQLException
	 */
	public int getElsecostCount(String costName)throws SQLException;
	/**
	 * 根据ID查询 再进行修改
	 * @param memberId
	 * @return
	 * @throws SQLException
	 */
	public ElseCost getElseCostByid(Integer costId) throws SQLException;
	/**
	 * 修改
	 * @param member
	 * @return
	 * @throws SQLException
	 */
	public boolean updateElseCost(ElseCost elseCost) throws SQLException;
	
	/**
	 * 2018-4-25
	 * 根据id删除费用信息
	 */
	public int delElseCostId(Integer costId) throws SQLException;
	/**
	 * 获取全部员工姓名
	 * @return
	 * @throws Exception
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
