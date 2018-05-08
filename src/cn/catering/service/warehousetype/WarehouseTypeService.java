package cn.catering.service.warehousetype;

import java.sql.SQLException;
import java.util.List;

import cn.catering.pojo.WarehouseType;

/**
 * @ClassName:  WarehouseTypeService   
 * @Description:  获取后台仓库类型所有的数据
 * @author: Arouse
 * @date:   2018年3月28日 下午1:11:59
 */
public interface WarehouseTypeService {
	/**
	 * @Title: getAllWarehouseType
	 * @Description:  获取后台仓库类型所有的数据
	 * @author: Arouse
	 * @return  返回后台仓库类型所有数据
	 * @throws SQLException
	 */
    public List<WarehouseType> getAllWarehouseType(Integer warehouseId,String warehouseName) throws SQLException;
    
    /**
     * @Title: insertWarehouseType
     * @Description: 新增后台仓库类型数据
     * @author: Arouse
     * @param warehouseType
     * @return 返回 是否成功！ true为成功 ；false为失败
     * @throws SQLException
     */
    public boolean insertWarehouseType(WarehouseType warehouseType) throws SQLException;
    
    /**
     * @Title: selectByWarehouseName
     * @Description: 根据后台仓库类型名称判断是否存在同一个仓库名称
     * @author: Arouse
     * @param warehouseName
     * @return  返回仓库类型对象数据
     * @throws SQLException
     */
    public int selectByWarehouseName(String warehouseName) throws SQLException;
    
    /**
     * @Title: deleteWarehouse
     * @Description:  根据仓库id删除数据
     * @author: Arouse
     * @param warehouseId
     * @return
     * @throws SQLException
     */
    public boolean deleteWarehouse(Integer warehouseId) throws SQLException;
    
    /**
     * @Title: updataWarehouse
     * @Description:  修改仓库名称
     * @author: Arouse
     * @param warehouseType
     * @return
     * @throws SQLException
     */
    public boolean updataWarehouse(WarehouseType warehouseType) throws SQLException;
}
