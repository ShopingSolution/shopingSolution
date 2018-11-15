package com.shop.dao;

import java.sql.SQLException;
import java.util.List;

import com.shop.dto.MemberVO;

public interface MemberDAO {
	public String confirmIdByPwdFind(String id) throws SQLException;
	public String selectPasswordById(String id) throws SQLException;
	
	public MemberVO getMember(String id) throws SQLException;
	
	
	public List<MemberVO> listMember() throws SQLException;
	
	public void confirmId(String id) throws SQLException;
	public void modifyActivation(String id) throws SQLException;
	public void modifyPassword(String id, String pwd) throws SQLException;
	public void resetPassword(String id) throws SQLException;
	public void registMember(MemberVO member) throws SQLException;
	public void outMember(String id) throws SQLException;
	
}
