package cn.catering.service.elsecost.impl;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.catering.dao.elsecost.ElseCostMapper;
import cn.catering.dao.elsecost.ElseCostMapperCustom;
import cn.catering.dao.member.MemberMapper;
import cn.catering.dao.member.MemberMapperCustom;
import cn.catering.pojo.ElseCost;
import cn.catering.pojo.Employee;
import cn.catering.service.elsecost.ElsecostService;
import cn.catering.tools.PageSupport;
@Service
public class ElsecostServiceImpl implements ElsecostService {
	@Autowired
	private ElseCostMapperCustom elseCostMapperCustom;
	@Resource
	private ElseCostMapper elseCostMapper;
	
	/**
	 * 查询全部数据 并分页
	 */
	@Override
	public List<ElseCost> getElsecostList(String costName,
			PageSupport pageSupport) throws SQLException {
		return elseCostMapperCustom.getElsecostList(costName, pageSupport);
		
	}
	/**
	 * 统计总数
	 */
	@Override
	public int getElsecostCount(String costName) throws SQLException {
		// TODO Auto-generated method stub
		return elseCostMapperCustom.getElsecostCount(costName);
	}
	/**
	 * 根据ID查询 再进行修改
	 */
	@Override
	public ElseCost getElseCostByid(Integer costId) throws SQLException {
		// TODO Auto-generated method stub
		return elseCostMapperCustom.getElseCostByid(costId);
	}
	/**
	 * 修改
	 */
	@Override
	public boolean updateElseCost(ElseCost elseCost) throws SQLException {
		return elseCostMapperCustom.updateElseCost(elseCost);
	}
	/**
	 * 删除
	 */
	@Override
	public int delElseCostId(Integer costId) throws SQLException {
		return elseCostMapper.deleteByPrimaryKey(costId);
	}
	/**
	 * 获取全部员工姓名
	 */
	@Override
	public List<Employee> listEmployees() throws SQLException {
		return elseCostMapperCustom.listEmployees();
	}
	/**
	 * 添加
	 */
	@Override
	public boolean addElseCost(ElseCost elseCost) throws SQLException {
		return elseCostMapperCustom.addElseCost(elseCost);
	}

}
