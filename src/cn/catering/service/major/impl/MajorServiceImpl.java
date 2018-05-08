package cn.catering.service.major.impl;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.catering.dao.major.MajorMapperCustom;
import cn.catering.pojo.Major;
import cn.catering.service.major.MajorService;
 @Service
public class MajorServiceImpl implements MajorService {
@Resource
private MajorMapperCustom majorMapperCustom;
	@Override
	public List<Major> getMajorList() throws SQLException {
 		return majorMapperCustom.getMajorList();
	}

}
