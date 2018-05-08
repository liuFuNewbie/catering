package cn.catering.service.paytype.impl;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.catering.dao.paytype.PayTypeMapper;
import cn.catering.dao.paytype.PayTypeMapperCustom;
import cn.catering.pojo.PayType;
import cn.catering.service.paytype.PayTypeService;

/**
 * 
 * @ClassName:  PayTypeServiceImpl   
 * @Description:实现支付类型业务逻辑类
 * @author: Sun
 * @date:   2018年3月31日 下午6:03:47
 */
@Service
public class PayTypeServiceImpl implements PayTypeService {
	@Resource
	private PayTypeMapperCustom payTypeMapperCustom;
	@Resource
	private PayTypeMapper payTypeMapper;
	
	@Override
	public List<PayType> getPayTypeList() throws SQLException {
		// TODO Auto-generated method stub
		return payTypeMapperCustom.getPayTypeList();
	}

	@Override
	public int insertPayType(PayType payType) throws SQLException {
		// TODO Auto-generated method stub
		return payTypeMapper.insert(payType);
	}

	@Override
	public int getPayTypeCountByName(String payName) throws SQLException {
		// TODO Auto-generated method stub
		return payTypeMapperCustom.getPayTypeCountByName(payName);
	}

	/**
	 * 
	 * @Title: delPayTypeById
	 * @Description:根据支付类别Id删除支付类别信息
	 * @author: Sun
	 * @param payId 支付类别Id
	 * @return boolean类型
	 * @throws SQLException
	 */
	@Override
	public int delPayTypeById(Integer payId) throws SQLException {
		// TODO Auto-generated method stub
		return payTypeMapper.deleteByPrimaryKey(payId);
	}

	@Override
	public int updatePayTypeById(PayType payType) throws SQLException {
		// TODO Auto-generated method stub
		return payTypeMapper.updateByPrimaryKeySelective(payType);
	}

}
