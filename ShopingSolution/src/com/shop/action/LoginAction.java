package com.shop.action;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shop.dao.MemberDAO;
import com.shop.dao.impl.MemberDAOImpl;
import com.shop.dto.MemberVO;

public class LoginAction implements Action{
	MemberDAO memberDAO = MemberDAOImpl.getInstance();
	public void setMemberDAO(MemberDAO memberDAO){
		this.memberDAO=memberDAO;
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url="redirect:main.do";
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		HttpSession session = request.getSession();
		
		MemberVO member = null;
		
		try{
			member=memberDAO.getMember(id);
		}catch (SQLException e){
			e.printStackTrace();
		}
		
		if(member!=null){
			if(member.getPwd().equals(pwd)){
				session.setAttribute("loginUser",member);
				session.setAttribute("message", "로그인 성공했습니다.");
			}else{
				session.setAttribute("message", "로그인 실패했습니다.");
			}
		}
		return url;
	}

}
