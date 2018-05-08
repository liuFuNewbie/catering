package cn.catering.dao.warehousetype;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.catering.pojo.WarehouseType;

/**
 * @ClassName:  WarehouseTypeMapperCustom   
 * @Description:  后台仓库类型接口
 * @author: Arouse
 * @date:   2018年3月28日 上午11:30:46
 */
public interface WarehouseTypeMapperCustom {
	   /**
	    * @Title: getAllWarehouseType
	    * @Description: 获取后台仓库类型数据
	    * @author: Arouse
	    * @param warehouseId
	    * @param warehouseName
	    * @return 返回后台仓库类型数据集合
	    */
       public List<WarehouseType> getAllWarehouseType(@Param("warehouseId") Integer warehouseId,@Param("warehouseName") String warehouseName);
       
       /**
        * @Title: selectByWarehouseName
        * @Description:  判断是否存在同一个仓库名称
        * @author: Arouse
        * @param warehouseName
        * @return
        */
       public int selectByWarehouseName(@Param("warehouseName") String warehouseName);
}
