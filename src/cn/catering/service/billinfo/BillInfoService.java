package cn.catering.service.billinfo;

import java.util.List;

import cn.catering.pojo.BillInfo;

public interface BillInfoService {
	
	/**
	 * 根据名称统计总数
	 * @Title: getComboCount
	 * @Description:
	 * @author: Administrator
	 * @param comboName
	 * @return
	 * @throws Exception
	 */
	public int getBillInfotCount()throws Exception;
	
	/**
	 * 根据名称,当前页号，每页尺寸获取分页数据
	 * @Title: getComboList
	 * @Description:
	 * @author: Administrator
	 * @param comboName
	 * @param currentPageNo
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	public List<BillInfo> getBillInfotList(String memberName,Integer currentPageNo,Integer pageSize) throws Exception;
	
	/**
	 * 根据Id查询数据（点击修改进行传值）
	 * @Title: getMarkeByIdList
	 * @Description:
	 * @author: Administrator
	 * @param marketId
	 * @return
	 * @throws Exception
	 */
	public List<BillInfo> getBillInfoByIdList(Integer marketId)throws Exception;
	
	/**
	 * 账单明细修改
	 * @Title: updateBillInfo
	 * @Description:
	 * @author: Administrator
	 * @param billInfo
	 * @return
	 * @throws Exception
	 */
	public boolean updateBillInfo(BillInfo billInfo)throws Exception;
	
	/**
	 * 账单明细信息删除
	 * @Title: delBillInfo
	 * @Description:
	 * @author: Administrator
	 * @param marketId
	 * @return
	 * @throws Exception
	 */
	public boolean delBillInfo(Integer marketId) throws Exception;

}
