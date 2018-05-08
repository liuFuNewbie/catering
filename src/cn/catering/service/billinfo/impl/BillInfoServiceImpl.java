package cn.catering.service.billinfo.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.catering.dao.billinfo.BillInfoMapperCustom;
import cn.catering.pojo.BillInfo;
import cn.catering.service.billinfo.BillInfoService;

@Service
public class BillInfoServiceImpl implements BillInfoService {

	@Resource
	BillInfoMapperCustom billInfoMapperCustom;
	
	@Override
	public int getBillInfotCount() throws Exception {
		
		return billInfoMapperCustom.getBillInfotCount();
	}

	@Override
	public List<BillInfo> getBillInfotList(String memberName,
			Integer currentPageNo, Integer pageSize) throws Exception {
		
		return billInfoMapperCustom.getBillInfotList(memberName, currentPageNo, pageSize);
	}

	@Override
	public List<BillInfo> getBillInfoByIdList(Integer marketId)
			throws Exception {
		
		return billInfoMapperCustom.getBillInfoByIdList(marketId);
	}

	@Override
	public boolean updateBillInfo(BillInfo billInfo) throws Exception {
		int count=billInfoMapperCustom.updateBillInfo(billInfo);
		if(count > 0)
			return true;
		else
			return false;		
	}

	@Override
	public boolean delBillInfo(Integer marketId) throws Exception {
		int count=billInfoMapperCustom.delBillInfo(marketId);
		if(count > 0)
			return true;
		else
			return false;
	}

}
