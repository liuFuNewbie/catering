package cn.catering.dao.purchase;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.catering.pojo.Purchase;

/**
 * @ClassName:  PurchaseMapperCustom   
 * @Description:  后台采购订单接口
 * @author: Arouse
 * @date:   2018年3月31日 下午3:27:56
 */
public interface PurchaseMapperCustom {

	/**
	 * @Title: getAllPurchase
	 * @Description:  查询采购订单所有的数据
	 * @author: Arouse
	 * @param shoppingName
	 * @return
	 */
	public List<Purchase> getAllPurchase(@Param("shoppingName") String shoppingName);
	
	/**
	 * @Title: getPurchaseByIdInfo
	 * @Description: 根据采购订单id查询信息
	 * @author: Arouse
	 * @param purchaseId
	 * @return
	 */
	public Purchase getPurchaseByIdInfo(@Param("purchaseId") Integer purchaseId);
	
	/**
	 * @Title: updatePUrchaseById
	 * @Description: 根据Id修改采购订单
	 * @author: Arouse
	 * @param purchase
	 * @return
	 */
	public int updatePUrchaseById(@Param("purchase") Purchase purchase);
}
