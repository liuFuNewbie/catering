package cn.catering.service.supplier.impl;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.catering.dao.supplier.SupplierMapperCustom;
import cn.catering.pojo.Supplier;
import cn.catering.service.supplier.SupplierService;
import cn.catering.tools.PageSupport;
@Service
public class SupplierServiceImpl implements SupplierService{
     @Resource
     private SupplierMapperCustom supplierCoustorMapper;   
     /**
      * 第一个参数record代表是根据供应商名称获取供应商信息列表【参数可有可无】 第二个参数pageSupport使用分页
      */
	@Override
	public List<Supplier> getSuppliner(String  supplierName,
			PageSupport pageSupport)throws SQLException {
 		return supplierCoustorMapper.getSuppliner(supplierName, pageSupport);
	}
	/**
	 * 获取供应商数量
	 */
	@Override
	public int getSupplierCount(String  supplierName) throws SQLException {
  		return supplierCoustorMapper.getSupplierCount(supplierName);
	}
	/**根据供应商编号获取该供应商信息‘
	 * 
	 */
	@Override
	public Supplier getSupplierById(Integer supplierId) throws SQLException{
 		return supplierCoustorMapper.getSupplierById(supplierId);
	}
	/**根据供应商编号修改供应商信息
	 * 
	 */
	@Override
	public int updateSupplierById(Supplier supplier)throws SQLException {
 		return supplierCoustorMapper.updateSupplierById(supplier);
	}
	/**根据供应商编号删除该供应商信息
	 * 
	 */
	@Override
	public int delSupplierById(Integer supplierId) throws SQLException{
 		return supplierCoustorMapper.delSupplierById(supplierId);
	}
	/**
	 * 添加供应商信息
	 */
	@Override
	public int insertSupplier(Supplier supplier)throws SQLException {
 		return supplierCoustorMapper.insertSupplier(supplier);
	}
	@Override
	public int getBusinessById(Integer supplierId) throws SQLException {
 		return supplierCoustorMapper.getBusinessById(supplierId);
	}
	@Override
	public List<Supplier> getSupplinerList() throws SQLException {
 		return supplierCoustorMapper.getSupplinerList();
	}
	
 }
