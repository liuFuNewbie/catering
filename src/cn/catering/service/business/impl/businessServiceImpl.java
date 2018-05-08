package cn.catering.service.business.impl;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.catering.dao.business.BusinessMapperCustom;
import cn.catering.pojo.Business;
import cn.catering.pojo.BusinessExtension;
import cn.catering.service.business.businessService;
import cn.catering.tools.PageSupport;
@Service
public class businessServiceImpl implements businessService {
@Resource
private BusinessMapperCustom businessMapperCustom;
	@Override
	public List<BusinessExtension> getBusinessExtension(String supplierName,
			PageSupport pageSupport) throws SQLException {
		return businessMapperCustom.getBusinessExtension(supplierName, pageSupport);
	}

	@Override
	public int getBusinessExtensionCount(String supplierName)
			throws SQLException {
		return businessMapperCustom.getBusinessExtensionCount(supplierName);
	}

	@Override
	public Business getBusinessById(Integer businessId) throws SQLException {
		return businessMapperCustom.getBusinessById(businessId);
	}

	@Override
	public int updateBusinessById(Business business) throws SQLException {
		return businessMapperCustom.updateBusinessById(business);
	}

	@Override
	public int delectBusinessById(Integer businessId) throws SQLException {
		return businessMapperCustom.delectBusinessById(businessId);
	}

	@Override
	public int insertBusiness(Business business) throws SQLException {
		return businessMapperCustom.insertBusiness(business);
	}

}
