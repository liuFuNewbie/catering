package cn.catering.service.user.impl;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.catering.dao.user.UserMapperCustom;
import cn.catering.pojo.User;
import cn.catering.service.user.UserService;
import cn.catering.tools.PageSupport;
@Service
public class UserServiceImpl implements UserService {
@Resource
private UserMapperCustom userMapperCustom;
	@Override
	public List<User> getUserList()throws SQLException {
 		return userMapperCustom.getUserList();
	}
	@Override
	public User getUserByUserName(String userName)throws SQLException {
 		return userMapperCustom.getUserByUserName(userName);
	}
	@Override
	public List<User> getUserListByWrongUserName(String userName,PageSupport pageSupport )
			throws SQLException {
 		return userMapperCustom.getUserListByWrongUserName(userName, pageSupport);
	}

	@Override
	public int insertUser(User user) throws SQLException {
 		return userMapperCustom.insertUser(user);
	}
	@Override
	public User getUserById(Integer userId) throws SQLException {
 		return userMapperCustom.getUserById(userId);
	}
	@Override
	public int updateUserById(User user) throws SQLException {
 		return userMapperCustom.updateUserById(user);
	}
	@Override
	public int getUserCountById(Integer userId) throws SQLException {
 		return userMapperCustom.getUserCountById(userId);
	}
	@Override
	public int delUserById(Integer userId) throws SQLException {
 		return userMapperCustom.delUserById(userId);
	}
	@Override
	public int getUserListByWrongUserNameCount(String userName ) throws SQLException {
 		return userMapperCustom.getUserListByWrongUserNameCount(userName);
	}
	@Override
	public List<User> getSelectUserheadPortraits(String userName) throws Exception {
		
		return userMapperCustom.getSelectUserheadPortraits(userName);
	}
	@Override
	public int updateheadPortraits(User user) throws Exception {
		
		return userMapperCustom.updateheadPortraits(user);
	}
	@Override
	public User getUser(String userName, String userPwd) throws SQLException {
		User user = userMapperCustom.getUser(userName);
		if(user != null){
			if(user.getUserPwd().equals(userPwd)){
				return user;
			}
		}
		return null;
	}
}
