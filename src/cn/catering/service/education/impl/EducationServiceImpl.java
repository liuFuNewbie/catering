package cn.catering.service.education.impl;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.catering.dao.education.EducationMapperCustom;
import cn.catering.pojo.Education;
import cn.catering.service.education.EducationService;

@Service
public class EducationServiceImpl implements EducationService {
	@Resource
	private EducationMapperCustom educationMapperCustom;

	@Override
	public List<Education> getEducationList() throws SQLException {
		return educationMapperCustom.getEducationList();
	}
 }
