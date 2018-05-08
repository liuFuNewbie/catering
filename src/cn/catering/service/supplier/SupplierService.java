package cn.catering.service.supplier;
import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.catering.pojo.Supplier;
import cn.catering.tools.PageSupport;

public interface SupplierService {
	  public  List<Supplier> getSupplinerList()throws SQLException;
	/**
     * 
     * @Title: getSuppliner
     * @Description: 第一个参数record代表是根据供应商名称获取供应商信息列表【参数可有可无】 第二个参数pageSupport使用分页
     * @author: Administrator
     * @param record
     * @param pageSupport
     * @return
     */
    public List<Supplier> getSuppliner(String  supplierName,PageSupport pageSupport)throws SQLException;
    /**
     * 
     * @Title: getSupplierCount
     * @Description: 获取供应商数量
     * @author: Administrator
     * @param supplier
     * @return
     */
    public int getSupplierCount(String  supplierName)throws SQLException;
    /**
     * 
     * @Title: getSupplierById
     * @Description:   根据供应编号获取供应商信息
     * @author: Administrator
     * @param supplierId
     * @return
     */
    public Supplier getSupplierById(@Param("supplierId") Integer  supplierId)throws SQLException;
    /**
     * 
     * @Title: updateSupplierById
     * @Description: 根据供应商编号修改供应商信息
     * @author: Administrator
     * @param supplier
     * @return
     */
    public int updateSupplierById(@Param("supplier") Supplier  supplier)throws SQLException;
    /**
     * 
     * @Title: delSupplierById
     * @Description: 根据供应商编号删除该供应商信息
     * @author: Administrator
     * @param supplierId
     * @return
     */
    public int delSupplierById(@Param("supplierId") Integer  supplierId)throws SQLException;
    /**
     * 
     * @Title: insertSupplier
     * @Description:  添加供应商信息
     * @author: Administrator
     * @param supplier
     * @return
     */

    public int insertSupplier( Supplier  supplier)throws SQLException;
    
    public int getBusinessById(Integer supplierId) throws SQLException;

 
}
