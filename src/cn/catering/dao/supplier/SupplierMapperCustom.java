package cn.catering.dao.supplier;

 
 import java.util.List;
 
 
 

import org.apache.ibatis.annotations.Param;




import cn.catering.pojo.Supplier;
import cn.catering.tools.PageSupport;

public interface SupplierMapperCustom {
	/**
	 * 
	 * @Title: getSupplinerList
	 * @Description:   获取供应商列表
	 * @author: Administrator
	 * @return
	 */
  public  List<Supplier> getSupplinerList();
    /**
     * 
     * @Title: getSuppliner
     * @Description: 第一个参数record代表是根据供应商名称获取供应商信息列表【参数可有可无】 第二个参数pageSupport使用分页
     * @author: Administrator
     * @param record
     * @param pageSupport
     * @return
     */
    public List<Supplier> getSuppliner(@Param("supplierName") String  supplierName,@Param("pageSupport")PageSupport pageSupport);
    /**
     * 
     * @Title: getSupplierCount
     * @Description: 获取供应商数量
     * @author: Administrator
     * @param supplier
     * @return
     */
    public int getSupplierCount(@Param("supplierName") String  supplierName);
    /**
     * 
     * @Title: getSupplierById
     * @Description:   根据供应编号获取供应商信息
     * @author: Administrator
     * @param supplierId
     * @return
     */
    public Supplier getSupplierById(@Param("supplierId") Integer  supplierId);
    /**
     * 
     * @Title: updateSupplierById
     * @Description: 根据供应商编号修改供应商信息
     * @author: Administrator
     * @param supplier
     * @return
     */
    public int updateSupplierById(@Param("supplier") Supplier  supplier);
    /**
     * 
     * @Title: delSupplierById
     * @Description: 根据供应商编号删除该供应商信息
     * @author: Administrator
     * @param supplierId
     * @return
     */
    public int delSupplierById(@Param("supplierId") Integer  supplierId);
    /**
     * 
     * @Title: insertSupplier
     * @Description:  添加供应商信息
     * @author: Administrator
     * @param supplier
     * @return
     */
    public int insertSupplier(@Param("supplier") Supplier  supplier);
    /**
     * 
     * @Title: getBusinessById
      * @Description:   根据供应商编号获取供应商信息
     * @author: Administrator
     * @param businessById
     * @return
     */
    public int getBusinessById(@Param("supplierId") Integer supplierId);
}
