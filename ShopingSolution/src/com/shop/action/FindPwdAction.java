package com.shop.action;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.dao.MemberDAO;
import com.shop.dao.impl.MemberDAOImpl;
import com.shop.utils.Mailer;

public class FindPwdAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException{
		String url = "redirect:main.do";
		
		String id = request.getParameter("id");
		String email = request.getParameter("email");
		
		MemberDAO dao = MemberDAOImpl.getInstance();
		
		String result = dao.confirmIdWithEmail(id, email);
		
		if(result != null){
			// 아이디 이메일 매칭 성공
			dao.resetPassword(id);
			
			String password = dao.selectPasswordById(id);
			
			String uid = "ousong45";
			String pwd = "elelm533";
			String title = "[ShopingSolution] 회원님의 패스워드가 초기화되었어요.";
			String content = id + "님의 패스워드가 다음과 같이 초기화되었습니다. \n ["+ password  +"] \n가급적 빠른 시일내에 개인정보를 변경해주시기 바랍니다. ";
			String fromMail = "ousong45@naver.com";
			String fromUser = "쇼핑솔루션";
			
			
			Mailer mail = new Mailer(uid, pwd, title, content, fromMail, fromUser, email);
			
			
			try {	
				mail.execute();
				request.getSession().setAttribute("message", "패스워드 초기화가 완료되었습니다. 이메일을 확인해주시기 바랍니다.");
			} catch (Exception e) {
				// 이메일 발송 실패
				url = "/error/exception.jsp";
				e.printStackTrace();
			}
		}else{
			// 아이디 이메일 매칭 실패
			request.getSession().setAttribute("message", "해당 아이디와 이메일이 일치하는 계정이 존재하지 않습니다. 다시 확인해주세요.");
		}
		
		return url;
	}

}
