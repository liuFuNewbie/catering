package cn.catering.service.purchase.impl;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.catering.dao.purchase.PurchaseMapper;
import cn.catering.dao.purchase.PurchaseMapperCustom;
import cn.catering.pojo.Purchase;
import cn.catering.service.purchase.PurchaseService;
/**
 * @ClassName:  PurchaseServiceImpl   
 * @Description:  实现后台采购订单接口
 * @author: Arouse
 * @date:   2018年3月31日 下午3:49:21
 */
@Service
public class PurchaseServiceImpl implements PurchaseService {
	
	@Resource
	private PurchaseMapperCustom purchaseMapperCustom;
	@Resource
	private PurchaseMapper purchaseMapper;

	@Override
	public List<Purchase> getAllPurchase(String shoppingName)
			throws SQLException {
		return purchaseMapperCustom.getAllPurchase(shoppingName);
	}

	@Override
	public boolean insertPurchase(Purchase purchase) throws SQLException {
		int count = purchaseMapper.insert(purchase);
		if(count > 0)
			return true;
		else
		    return false;
	}

	@Override
	public boolean deletePurchase(Integer purchaseId) throws SQLException {
		int del = purchaseMapper.deleteByPrimaryKey(purchaseId);
		if(del > 0)
			return true;
		else
		    return false;
	}

	@Override
	public boolean updataPurchase(Purchase purchase) throws SQLException {
		int updPur = purchaseMapperCustom.updatePUrchaseById(purchase);
		if(updPur > 0)
			return true;
		else
		    return false;
	}

	@Override
	public Purchase getPurchaseByIdInfo(Integer purchaseId) throws SQLException {
		Purchase pur = purchaseMapperCustom.getPurchaseByIdInfo(purchaseId);
		return pur;
	}

}
