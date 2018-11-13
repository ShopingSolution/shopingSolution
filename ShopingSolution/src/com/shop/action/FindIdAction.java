package com.shop.action;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.dao.MemberDAO;
import com.shop.dao.impl.MemberDAOImpl;
import com.shop.utils.Mailer;

public class FindIdAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		String url = "redirect:main.do";
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		
		MemberDAO dao = MemberDAOImpl.getInstance();
		
		String userId = dao.selectIdNameWithEmail(name, email);
		
		if(userId != null){
			// 매칭이 성공했을 경우
			String id = "ousong45";
			String pwd = "elelm533";
			String title = "[ShopingSolution] 회원님의 아이디를 찾았어요.";
			String content = name + "님의 아이디는 ["+ userId +"] 입니다";
			String fromMail = "ousong45@naver.com";
			String fromUser = "쇼핑솔루션";
			
			
			Mailer mail = new Mailer(id, pwd, title, content, fromMail, fromUser, email);
			
			
			try {	
				mail.execute();
				request.getSession().setAttribute("message", "이메일 발송에 성공했습니다.");
			} catch (Exception e) {
				// 이메일 발송 실패
				url = "/error/exception.jsp";
				e.printStackTrace();
			}
			
		} else {
			// 매칭에 실패했을 경우
			request.getSession().setAttribute("message", "해당 이름과 이메일이 일치하는 아이디가 존재하지 않습니다. 다시 확인해주세요.");
		}
		
		return url;
	}

}
