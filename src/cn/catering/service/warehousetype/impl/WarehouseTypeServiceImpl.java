package cn.catering.service.warehousetype.impl;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.catering.dao.warehousetype.WarehouseTypeMapper;
import cn.catering.dao.warehousetype.WarehouseTypeMapperCustom;
import cn.catering.pojo.WarehouseType;
import cn.catering.service.warehousetype.WarehouseTypeService;
/**
 * @ClassName:  WarehouseTypeServiceImpl   
 * @Description:  后台仓库类型数据接口的实现
 * @author: Arouse
 * @date:   2018年3月28日 下午1:21:36
 */
@Service
public class WarehouseTypeServiceImpl implements WarehouseTypeService {
	/**
	 * 后台仓库类型接口
	 */
	@Autowired
	private WarehouseTypeMapperCustom warehouseTypeMapperCustom;
	@Resource
	private WarehouseTypeMapper warehouseTypeMapper;

	@Override
	public List<WarehouseType> getAllWarehouseType(Integer warehouseId,String warehouseName) throws SQLException {
		return warehouseTypeMapperCustom.getAllWarehouseType(warehouseId, warehouseName);
	}

	@Override
	public boolean insertWarehouseType(WarehouseType warehouseType)
			throws SQLException {
		int i = warehouseTypeMapper.insert(warehouseType);
		if (i > 0)
			return true;
		else
			return false;
	}

	@Override
	public int selectByWarehouseName(String warehouseName)
			throws SQLException {
		return warehouseTypeMapperCustom.selectByWarehouseName(warehouseName);
	}

	@Override
	public boolean deleteWarehouse(Integer warehouseId) throws SQLException {
		int delWareId = warehouseTypeMapper.deleteByPrimaryKey(warehouseId);
		if(delWareId > 0)
			return true;
		else
		    return false;
	}

	@Override
	public boolean updataWarehouse(WarehouseType warehouseType)
			throws SQLException {
		int updWare = warehouseTypeMapper.updateByPrimaryKey(warehouseType);
		if(updWare > 0)
			return true;
		else
		    return false;
	}

}
