package cn.catering.service.combo.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.catering.dao.combo.ComboMapper;
import cn.catering.dao.combo.ComboMapperCustom;
import cn.catering.pojo.Combo;
import cn.catering.service.combo.ComboService;

@Service
public class ComboServiceImpl implements ComboService {

	@Resource
	private ComboMapperCustom comboMapperCustom;
	@Resource
	private ComboMapper comboMapper;

	@Override
	public int getComboCount(String comboName) throws Exception {

		return comboMapperCustom.getComboCount(comboName);
	}

	@Override
	public List<Combo> getComboList(String comboName, Integer currentPageNo,
			Integer pageSize) throws Exception {
		currentPageNo = (currentPageNo - 1) * pageSize;
		return comboMapperCustom.getComboList(comboName, currentPageNo,
				pageSize);
	}

	@Override
	public boolean addCombo(Combo combo) throws Exception {
		int number = comboMapper.insert(combo);
		if (number > 0)
			return true;
		else
			return false;
	}

	@Override
	public boolean updateCombo(Combo combo) throws Exception {
		int number = comboMapper.updateByPrimaryKey(combo);
		if (number > 0)
			return true;
		else
			return false;
	}

	@Override
	public boolean delCombo(Integer ComboId) throws Exception {
		int number = comboMapper.deleteByPrimaryKey(ComboId);
		if (number > 0)
			return true;
		else
			return false;
	}

	@Override
	public List<Combo> getComboByid(Integer comboId) throws Exception {

		return comboMapperCustom.getComboByid(comboId);
	}

	@Override
	public List<Combo> selectlistCombos() throws Exception {

		return comboMapperCustom.selectlistCombos();
	}
}
