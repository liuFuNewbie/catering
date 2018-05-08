package cn.catering.dao.paytype;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.catering.pojo.PayType;

/**
 * 
 * @ClassName:  PayTypeMapperCustom   
 * @Description:支付类型接口
 * @author: Sun
 * @date:   2018年3月31日 下午5:47:09
 */
public interface PayTypeMapperCustom {
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
	 * @Title: getPayTypeCountByName
	 * @Description:根据添加输入的支付类别名称与数据库的支付类别名称是否唯一
	 * @author: Sun
	 * @param payName 支付类别名称
	 * @return int类型
	 * @throws SQLException
	 */
	int getPayTypeCountByName(@Param("payName") String payName) throws SQLException;
}
