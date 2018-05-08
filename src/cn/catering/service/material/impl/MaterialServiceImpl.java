package cn.catering.service.material.impl;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.catering.dao.material.MaterialMapperCustom;
import cn.catering.pojo.Material;
import cn.catering.pojo.MaterialExtension;
import cn.catering.service.material.MaterialService;
import cn.catering.tools.PageSupport;

@Service
public class MaterialServiceImpl implements MaterialService {
	@Resource
	private MaterialMapperCustom materialMapperCustom;

	@Override
	public List<MaterialExtension> getMaterial(String postName, Integer type,
			PageSupport pageSupport) throws SQLException {
		return materialMapperCustom.getMaterial(postName, type, pageSupport);
	}

	@Override
	public  List<MaterialExtension> getMaterialCount(String postName, Integer typeId)
			throws SQLException {
		return materialMapperCustom.getMaterialCount(postName, typeId);
	}

	@Override
	public MaterialExtension getMaterialById(Integer Materiald)
			throws SQLException {
		return materialMapperCustom.getMaterialById(Materiald);
	}

	@Override
	public int updateMaterialById(MaterialExtension material)
			throws SQLException {
		return materialMapperCustom.updateMaterialById(material);
	}

	@Override
	public int insertMaterial(Material material) throws SQLException {
		return materialMapperCustom.insertMaterial(material);
	}

	@Override
	public int deleteMaterialById(Integer material) throws SQLException {
		return materialMapperCustom.deleteMaterialById(material);
	}
 


	public int getMaterialCountById(Integer payId) throws Exception {
		return materialMapperCustom.getMaterialCountById(payId);
	}
 }
