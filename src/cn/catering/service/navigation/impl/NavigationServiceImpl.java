package cn.catering.service.navigation.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.catering.dao.navigation.NavigationMapper;
import cn.catering.dao.navigation.NavigationMapperCustom;
import cn.catering.pojo.Navigation;
import cn.catering.service.navigation.NavigationService;

/**
 * 
 * @ClassName: NavigationServiceImpl
 * @Description:实现商品类别业务处理类
 * @author: Sun
 * @date: 2018年3月28日 下午2:09:18
 */

@Service
public class NavigationServiceImpl implements NavigationService {
	@Autowired
	private NavigationMapperCustom navigationMapperCustom;
	@Autowired
	private NavigationMapper navigationMapper;

	@Override
	public List<Navigation> getNavigationList() throws SQLException {
		return navigationMapperCustom.getNavigationList();
	}

	@Override
	public int insertNavigation(Navigation navigation) throws SQLException {
		return navigationMapper.insert(navigation);
	}

	@Override
	public int getNavigationCountByName(String navName) throws SQLException {
		return navigationMapperCustom.getNavigationCountByName(navName);
	}
	
	@Override
	public boolean delNavigationById(Integer navId) throws SQLException {
		// TODO Auto-generated method stub
		int res = navigationMapper.deleteByPrimaryKey(navId);
		if (res > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public int updateNavigationById(Navigation navigation) throws SQLException {
		// TODO Auto-generated method stub
		return navigationMapper.updateByPrimaryKeySelective(navigation);
	}

}