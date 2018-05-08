package cn.catering.service.business;

import java.sql.SQLException;
import java.util.List;

 
import cn.catering.pojo.Business;
import cn.catering.pojo.BusinessExtension;
import cn.catering.tools.PageSupport;

public interface businessService {
	/**
	 * 
	 * @Title: getBusinessExtension
	 * @Description:   获取业务列表
	 * @author: Administrator
	 * @param supplierName
	 * @param pageSupport
	 * @return
	 */
	public List<BusinessExtension> getBusinessExtension(String supplierName, PageSupport pageSupport)throws SQLException;
/**
 * 
 * @Title: getBusinessExtensionCount
 * @Description:  根据供应商名称获取数量
 * @author: Administrator
 * @param supplierName
 * @return
 */
	public int getBusinessExtensionCount(String supplierName)throws SQLException;
	/**
	 * 
	 * @Title: getgetBusinessById
	 * @Description:    根据业务编号获取业务信息
	 * @author: Administrator
	 * @param businessId
	 * @return
	 */
	public Business getBusinessById(Integer businessId)throws SQLException;
	/**
	 * 
	 * @Title: updateBusinessById
	 * @Description:  根据业务编号修改业务信息
	 * @author: Administrator
	 * @param business
	 * @return
	 */
	public int updateBusinessById(Business business)throws SQLException;
	/**
	 * 
	 * @Title: delectBusinessById
	 * @Description:  根据业务编号删除业务信息
	 * @author: Administrator
	 * @param businessId
	 * @return
	 */
	public int delectBusinessById(Integer businessId)throws SQLException;
	/**
	 * 
	 * @Title: insertBusinessById
	 * @Description:  添加业务信息
	 * @author: Administrator
	 * @param business
	 * @return
	 */
	public int insertBusiness(Business business)throws SQLException;
}
