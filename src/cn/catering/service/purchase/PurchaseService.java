package cn.catering.service.purchase;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.catering.pojo.Purchase;
import cn.catering.pojo.WarehouseType;

/**
 * @ClassName:  PurchaseService   
 * @Description: 后台采购订单服务接口
 * @author: Arouse
 * @date:   2018年3月31日 下午3:45:37
 */
public interface PurchaseService {
    
	/**
	 * @Title: getAllPurchase
	 * @Description: 获取所用后台采购订单的数据
	 * @author: Arouse
	 * @param shoppingName
	 * @return
	 * @throws SQLException
	 */
	public List<Purchase> getAllPurchase(String shoppingName) throws SQLException;
	
	/**
	 * @Title: insertPurchase
	 * @Description: 新增采购订单数据
	 * @author: Arouse
	 * @param purchase
	 * @return
	 * @throws SQLException
	 */
	public boolean insertPurchase(Purchase purchase) throws SQLException;
	
	/**
	 * @Title: deletePurchase
	 * @Description:  根据采购订单id删除数据
	 * @author: Arouse
	 * @param purchaseId
	 * @return
	 * @throws SQLException
	 */
	public boolean deletePurchase(Integer purchaseId) throws SQLException;
	
	/**
	 * @Title: getPurchaseByIdInfo
	 * @Description:  根据采购订单id查询信息
	 * @author: Arouse
	 * @param purchaseId
	 * @return
	 */
	public Purchase getPurchaseByIdInfo(Integer purchaseId) throws SQLException;
	
	/**
	 * @Title: updataPurchase
	 * @Description:  修改采购订单信息
	 * @author: Arouse
	 * @param purchase
	 * @return
	 * @throws SQLException
	 */
	public boolean updataPurchase(Purchase purchase) throws SQLException;
}
