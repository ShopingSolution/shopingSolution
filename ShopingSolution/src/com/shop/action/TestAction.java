package com.shop.action;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.shop.db.sqlconfig.IBatisDBConnector;
import com.shop.dto.MemberVO;

public class TestAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO This is Sample~~~~~~~
		String url = "";
		
		SqlMapClient client = IBatisDBConnector.getSqlMapClient();
		
		MemberVO member = new MemberVO("ksh1042","kekkk141","문동훈","kekekekek@mefkw.com","문씨네 집","01065336966");
		
		try {
			client.insert("Member.insertMember", member);
		} catch (SQLException e){
			e.printStackTrace();
		}
		
		
		
		return url;
	}

}
