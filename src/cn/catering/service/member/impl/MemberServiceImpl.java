package cn.catering.service.member.impl;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.catering.dao.member.MemberMapper;
import cn.catering.dao.member.MemberMapperCustom;
import cn.catering.pojo.Member;
import cn.catering.service.member.MemberService;
import cn.catering.tools.PageSupport;
@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberMapperCustom memberMapperCustom;
	@Resource
	private MemberMapper memberMapper;
	/**
	 * 查询全部会员信息
	 */
	@Override
	public List<Member> getMemberList(String memberName, PageSupport pageSupport)
			throws SQLException {
		return memberMapperCustom.getMemberList(memberName, pageSupport);
	}
	
	/**
	 * 按会员名称查询信息
	 */
	@Override
	public int getMemberCount(String MemberName) throws SQLException {
		// TODO Auto-generated method stub
		return memberMapperCustom.getMemberCount(MemberName);
	}
	/**
	 * 根据会员ID删除信息
	 */
	@Override
	public int delmember(Integer memberId) throws SQLException {
		
		return memberMapper.deleteByPrimaryKey(memberId);
		
	}
	/**
	 * 修改
	 */
	@Override
	public boolean updateMember(Member member) throws SQLException {
		int number = memberMapper.updateByPrimaryKey(member);
		if (number > 0)
			return true;
		else
			return false;
	}
	/**
	 * 根据ID查询
	 */
	@Override
	public Member getMemberByid(Integer memberId) throws SQLException {
		return memberMapperCustom.getMemberByid(memberId);
	}
	/**
	 * 添加会员信息
	 */
	@Override
	public boolean addMember(Member member) throws SQLException {
		int number = memberMapper.insert(member);
		if (number > 0)
			return true;
		else
			return false;
	}
	@Override
	public Integer selectIsAccount(long account) throws SQLException {
		return memberMapperCustom.selectIsAccount(account);
	}
}

