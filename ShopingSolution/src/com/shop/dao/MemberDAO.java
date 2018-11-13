package com.shop.dao;

import java.sql.SQLException;

import com.shop.dto.MemberVO;

public interface MemberDAO {
	public String selectIdNameWithEmail(String name, String email) throws SQLException;
	public String confirmIdWithEmail(String id, String email) throws SQLException;
	public String selectPasswordById(String id) throws SQLException;
	public void resetPassword(String id) throws SQLException;
	public MemberVO getMember(String id) throws SQLException;
	
}
