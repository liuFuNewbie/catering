package cn.catering.service.datapilot.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.catering.dao.datapilot.DataPilotMapperCustom;
import cn.catering.pojo.DataPilotCustom;
import cn.catering.service.datapilot.DataPilotService;

/**
 * @ClassName: DataPilotServiceImpl
 * @Description:后台导航条数据接口实现类
 * @author: MDS
 * @date: 2018年3月27日 下午9:39:59
 */
@Service
public class DataPilotServiceImpl implements DataPilotService {
	/**
	 * 后台导航条数据接口对象
	 */
	@Autowired
	private DataPilotMapperCustom dataPilotMapperCustom;

	@Override
	public List<DataPilotCustom> getAllDataPilots() throws SQLException {
		List<DataPilotCustom> list = dataPilotMapperCustom.getAllDataPilots();
		List<DataPilotCustom> parentList = new ArrayList<DataPilotCustom>();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getParent() == 0) {
				parentList.add(list.get(i));
				list.remove(i);
				i--;
			}
		}
		for (DataPilotCustom dataPilotCustom : parentList) {
			dataPilotCustom.setDataPilotList(getChildList(
					dataPilotCustom.getDataPilotId(), list));
		}
		return parentList;
	}
	/**
	 * 
	 * @Title: getChildList
	 * @Description: 排序
	 * @author: MDS
	 * @param dataPilotId 后台导航条数据编号
	 * @param list 后台导航条数据集合
	 * @return 返回后台导航条数据集合
	 */
	private List<DataPilotCustom> getChildList(Integer dataPilotId,
			List<DataPilotCustom> list) {
		List<DataPilotCustom> childList = new ArrayList<DataPilotCustom>();
		for (int i = 0; i < list.size(); i++) {
			if (dataPilotId == list.get(i).getParent()) {
				childList.add(list.get(i));
				list.remove(i);
				i--;
			}
		}
		for (DataPilotCustom dataPilotCustom : childList) {
			dataPilotCustom.setDataPilotList(getChildList(dataPilotCustom.getDataPilotId(), list));
		}
		return childList;
	}
}
