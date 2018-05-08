package cn.catering.service.member;

import java.sql.SQLException;
import java.util.List;

import cn.catering.pojo.Member;
import cn.catering.tools.PageSupport;

public interface MemberService {
	
	/**
	 * 根据名称,当前页号，每页尺寸获取分页数据
	 * @Title: getMemberList
	 * @Description:
	 * @author: zjb
	 * @param memberName
	 * @param pageSupport
	 * @return
	 * @throws SQLException
	 */
	public List<Member> getMemberList(String memberName,PageSupport pageSupport) throws SQLException;
	/**
	 * 总数
	 * @Title: getMemberCount
	 * @Description:
	 * @author: zjb
	 * @param MemberName
	 * @return
	 * @throws SQLException
	 */
	public int getMemberCount(String MemberName)throws SQLException;
	
	/**
	 * 删除
	 * @Title: delmember
	 * @Description:
	 * @author: zjb
	 * @param memberId
	 * @return
	 * @throws SQLException
	 */
	public int delmember(Integer memberId) throws SQLException;
	/**
	 * 修改
	 * @Title: updateMember
	 * @Description:
	 * @author: zjb
	 * @param member
	 * @return
	 * @throws SQLException
	 */
	public boolean updateMember(Member member) throws SQLException;
	/**
	 * 根据ID查询
	 * @Title: getMemberByid
	 * @Description:
	 * @author: zjb
	 * @param memberId
	 * @return
	 * @throws SQLException
	 */
	public Member getMemberByid(Integer memberId) throws SQLException;
	/**
	 * 添加
	 * @Title: addMember
	 * @Description:
	 * @author: zjb
	 * @param member
	 * @return
	 * @throws SQLException
	 */
	public boolean addMember(Member member) throws SQLException;
	/**
	 * @Title: selectIsAccount
	 * @Description:验证会员号是否存在并且返回会员编号
	 * @author: MDS
	 * @param account 会员号
	 * @return 返回会员编号
	 * @throws SQLException
	 */
	public Integer selectIsAccount(long account)throws SQLException;
}
