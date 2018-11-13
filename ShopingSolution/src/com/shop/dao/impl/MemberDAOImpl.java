package com.shop.dao.impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.shop.dao.MemberDAO;
import com.shop.db.sqlconfig.IBatisDBConnector;
import com.shop.utils.Mailer;

public class MemberDAOImpl implements MemberDAO {
	private static MemberDAOImpl instance = new MemberDAOImpl();
	protected MemberDAOImpl(){}
	public static MemberDAOImpl getInstance(){
		return instance;
	}
	
	private SqlMapClient client = IBatisDBConnector.getSqlMapClient();
	
	@Override
	public String selectIdNameWithEmail(String name, String email) throws SQLException {
		////////////////////////
		// 아이디 찾기에 필요한 쿼리 //
		///////////////////////
		String id = null;
		
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("name", name);
		paramMap.put("email", email);
		
		id = (String)client.queryForObject("Member.selectIdNameWithEmail", paramMap);
		
		return id;
	}

	@Override
	public String confirmIdWithEmail(String id, String email) throws SQLException {
		//////////////////////////
		// 패스워드 찾기에 필요한 쿼리 //
		/////////////////////////
		String result = null;
		
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("id", id);
		paramMap.put("email", email);
		
		result = (String)client.queryForObject("Member.confirmIdWithEmail", paramMap);
		
		return result;
	}
	@Override
	public String selectPasswordById(String id) throws SQLException {
		//////////////////////////
		// 아이디를 통한 패스워드 조회  //
		/////////////////////////
		String pwd = null;
		
		pwd = (String)client.queryForObject("Member.selectPasswordById", id);
		
		return pwd;
	}
	@Override
	public void resetPassword(String id) throws SQLException {
		//////////////////////////
		// 패스워드 랜덤문자열로 초기화 //
		/////////////////////////
		String pwd = Mailer.getAuthKey(15);
		
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("id", id);
		paramMap.put("pwd", pwd);
		
		client.update("Member.resetPassword", paramMap);
		
	}
	

}
