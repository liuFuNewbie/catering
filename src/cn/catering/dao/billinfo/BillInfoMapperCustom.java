package cn.catering.dao.billinfo;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.catering.pojo.BillInfo;

public interface BillInfoMapperCustom {
	
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
	public List<BillInfo> getBillInfotList(@Param("memberName") String memberName,@Param("currentPageNo")  Integer currentPageNo,@Param("pageSize") Integer pageSize) throws Exception;
	
	/**
	 * 根据Id查询数据（点击修改进行传值）
	 * @Title: getMarkeByIdList
	 * @Description:
	 * @author: Administrator
	 * @param marketId
	 * @return
	 * @throws Exception
	 */
	public List<BillInfo> getBillInfoByIdList(@Param("marketId")Integer marketId)throws Exception;
	
	/**
	 * 账单明细修改
	 * @Title: updateBillInfo
	 * @Description:
	 * @author: Administrator
	 * @param billInfo
	 * @returnmemberName
	 * @throws Exception
	 */
	public int updateBillInfo(BillInfo billInfo)throws Exception;
	
	/**
	 * 账单明细信息删除
	 * @Title: addBillInfo
	 * @Description:
	 * @author: Administrator
	 * @param billInfo
	 * @return
	 * @throws Exception
	 */
	public int delBillInfo(@Param("marketId")Integer marketId) throws Exception;
	
	
}
