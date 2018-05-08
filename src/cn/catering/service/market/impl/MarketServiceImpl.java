package cn.catering.service.market.impl;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.catering.dao.market.MarketMapper;
import cn.catering.dao.market.MarketMapperCustom;
import cn.catering.pojo.Employee;
import cn.catering.pojo.Market;
import cn.catering.pojo.Menu;
import cn.catering.service.market.MarketService;

@Service
public class MarketServiceImpl implements MarketService {
	
	@Resource
	private MarketMapperCustom marketmapperCustom;
	@Resource
	private MarketMapper marketMapper;
	@Override
	public int getMarketCount(String menuName) throws Exception {
		
		return marketmapperCustom.getMarketCount(menuName);
	}

	@Override
	public List<Market> getMarketList(String menuName, Integer currentPageNo,
			Integer pageSize) throws Exception {
		currentPageNo = (currentPageNo - 1) * pageSize;
		return marketmapperCustom.getMarketList(menuName, currentPageNo, pageSize);
	}

	@Override
	public List<Market> getMarkeByIdList(Integer marketId) throws Exception {
		
		return marketmapperCustom.getMarkeByIdList(marketId);
	}

	@Override
	public boolean addMarket(Market market) throws Exception {
		int count=marketmapperCustom.addMarket(market);
		if(count>0)
			return true;
		else 
			return false;
	}

	@Override
	public int updateMarket(Market market) throws Exception {
		
		return marketmapperCustom.updateMarket(market);
		
	}

	@Override
	public boolean delMarket(Integer marketId) throws Exception {
		int count=marketMapper.deleteByPrimaryKey(marketId);
		if(count>0)
			return true;
		else 
			return false;
	}
	
	@Override
	public List<Menu> listMenus() throws Exception {
		
		return marketmapperCustom.listMenus();
	}
	
	@Override
	public List<Employee> listEmployees() throws Exception {
		
		return marketmapperCustom.listEmployees();
	}

	@Override
	public List<Market> listByMemberName() throws Exception {
		
		return marketmapperCustom.listByMemberName();
	}

	@Override
	public int selectEmpByIdInfo(Integer empId) throws SQLException {
		return marketmapperCustom.selectEmpByIdInfo(empId);
	}

}
