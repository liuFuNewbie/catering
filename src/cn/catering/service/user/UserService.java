package cn.catering.service.user;

import java.sql.SQLException;
import java.util.List;

import cn.catering.pojo.User;
import cn.catering.tools.PageSupport;

public interface UserService {
	/**
	 * 
	 * @Title: getUserList
	 * @Description: 获取用户列表
	 * @author: Administrator
	 * @return
	 */
	public List<User> getUserList() throws SQLException;

	/**
	 * 
	 * @Title: getUserByUserName
	 * @Description: 根据用户名获取用户编号
	 * @author: Administrator
	 * @param userName
	 * @return
	 */
	public User getUserByUserName(String userName) throws SQLException;

	/**
	 * 
	 * @Title: getUserListByWronguserName
	 * @Description: 获取用户列表 条件可有可无
	 * @author: Administrator
	 * @param userName
	 * @return
	 */
	public List<User> getUserListByWrongUserName(String userName,PageSupport pageSupport)
			throws SQLException;

	/**
	 * 
	 * @Title: getUserListByWronguserNameCount
	 * @Description: 获取用户列表数量 条件可有可无
	 * @author: Administrator
	 * @param userName
	 * @return
	 */
	public int getUserListByWrongUserNameCount(String userName)
			throws SQLException;

	/**
	 * 
	 * @Title: insertUser
	 * @Description: 添加用户信息
	 * @author: Administrator
	 * @param user
	 * @return
	 */
	public int insertUser(User user) throws SQLException;

	/**
	 * 
	 * @Title: getUserById
	 * @Description:根据用户编号获取用户信息
	 * @author: Administrator
	 * @param userId
	 * @return
	 */
	public User getUserById(Integer userId) throws SQLException;

	/**
	 * 
	 * @Title: updateUserById
	 * @Description:根据用户编号修改用户信息
	 * @author: Administrator
	 * @param user
	 * @return
	 */
	public int updateUserById(User user) throws SQLException;

	/**
	 * 
	 * @Title: getUserCountById
	 * @Description:根据用户编号获取用户数量
	 * @author: Administrator
	 * @param userId
	 * @return
	 */
	public int getUserCountById(Integer userId) throws SQLException;

	/**
	 * 
	 * @Title: delUserById
	 * @Description: 根据用户编号删除用户信息
	 * @author: Administrator
	 * @param userId
	 * @return
	 */
	public int delUserById(Integer userId) throws SQLException;
	/**
	 * 根据用户名称查找用户头像(有用)
	 * @Title: getSelectUserName
	 * @Description:
	 * @author: Administrator
	 * @param UserName
	 * @return
	 * @throws Exception
	 */
	public List<User> getSelectUserheadPortraits(String userName)throws Exception;

	/**
	 * 根据  Id  修改用户头像
	 * @Title: udpUserheadPortraits
	 * @Description:
	 * @author: Administrator
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	public int updateheadPortraits(User user)throws Exception;
	/**
	 * 获取登录对象
	 * @Title: getUser
	 * @Description:
	 * @author: MDS
	 * @param userName 登录名称
	 * @param userPwd 登录密码
	 * @return 返回登录对象
	 * @throws SQLException
	 */
	public User getUser(String userName,String userPwd) throws SQLException;
}
