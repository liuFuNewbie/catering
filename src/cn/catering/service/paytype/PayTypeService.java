package cn.catering.service.paytype;

import java.sql.SQLException;
import java.util.List;

import cn.catering.pojo.PayType;

/**
 * 
 * @ClassName:  PayTypeService   
 * @Description:支付类型业务逻辑接口
 * @author: Sun
 * @date:   2018年3月31日 下午6:02:00
 */
public interface PayTypeService {
	/**
	 * 
	 * @Title: getPayTypeList
	 * @Description:获取所有支付类型
	 * @author: Sun
	 * @return 支付类型对象集合
	 * @throws SQLException
	 */
	List<PayType> getPayTypeList() throws SQLException;
	
	/**
	 * 
	 * @Title: insertPayType
	 * @Description:添加支付类别
	 * @author: Sun
	 * @param payType 支付对象
	 * @return int类型
	 * @throws SQLException
	 */
	int insertPayType(PayType payType) throws SQLException;
	
	/**
	 * 
	 * @Title: getPayTypeCountByName
	 * @Description:根据添加输入的支付类别名称与数据库的支付类别名称是否唯一
	 * @author: Sun
	 * @param payName 支付类别名称
	 * @return int类型
	 * @throws SQLException
	 */
	int getPayTypeCountByName(String payName) throws SQLException;
	
	/**
	 * 
	 * @Title: delPayTypeById
	 * @Description:根据支付类别Id删除支付类别信息
	 * @author: Sun
	 * @param payId 支付类别Id
	 * @return int类型
	 * @throws SQLException
	 */
	int delPayTypeById(Integer payId) throws SQLException;
	
	/**
	 * 
	 * @Title: updatePayTypeById
	 * @Description:根据支付类别编号修改支付类别信息
	 * @author: Sun
	 * @param payType 支付类别对象
	 * @return int类型
	 * @throws SQLException
	 */
	int updatePayTypeById(PayType payType) throws SQLException;
}
