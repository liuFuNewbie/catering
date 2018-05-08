package cn.catering.dao.business;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.catering.pojo.Business;
import cn.catering.pojo.BusinessExtension;
import cn.catering.tools.PageSupport;

public interface BusinessMapperCustom {
	/**
	 * 
	 * @Title: getBusinessExtension
	 * @Description:   获取业务列表
	 * @author: Administrator
	 * @param supplierName
	 * @param pageSupport
	 * @return
	 */
	public List<BusinessExtension> getBusinessExtension(
			@Param("supplierName")  String supplierName,
			@Param("pageSupport") PageSupport pageSupport);
/**
 * 
 * @Title: getBusinessExtensionCount
 * @Description:  根据供应商名称获取数量
 * @author: Administrator
 * @param supplierName
 * @return
 */
	public int getBusinessExtensionCount(
			@Param("supplierName") String supplierName);
	/**
	 * 
	 * @Title: getgetBusinessById
	 * @Description:    根据业务编号获取业务信息
	 * @author: Administrator
	 * @param businessId
	 * @return
	 */
	public Business getBusinessById(@Param("businessId") Integer businessId);
	/**
	 * 
	 * @Title: updateBusinessById
	 * @Description:  根据业务编号修改业务信息
	 * @author: Administrator
	 * @param business
	 * @return
	 */
	public int updateBusinessById(@Param("business") Business business);
	/**
	 * 
	 * @Title: delectBusinessById
	 * @Description:  根据业务编号删除业务信息
	 * @author: Administrator
	 * @param businessId
	 * @return
	 */
	public int delectBusinessById(@Param("businessId") Integer businessId);
	/**
	 * 
	 * @Title: insertBusinessById
	 * @Description:  添加业务信息
	 * @author: Administrator
	 * @param business
	 * @return
	 */
	public int insertBusiness(@Param("business") Business business);
}