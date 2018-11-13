package com.shop.utils;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewResolver {
	
	public final String errorUrl = "/error/exception.jsp";
	
	public static void view(HttpServletRequest request, HttpServletResponse response, String pageUrl) throws ServletException, IOException {
		
		String prefix = "/WEB-INF/views";
		
		boolean flag = false;
		
		// flag
		if(pageUrl.contains("redirect:")){
			pageUrl = pageUrl.replace("redirect:", "");
			flag = true;
		} else {
			pageUrl = prefix + pageUrl;
		}
		
		// output
		if(flag){
			System.out.println(request.getServletPath() + " ---> redirect ---> " + pageUrl);
			response.sendRedirect(pageUrl);
		} else {
			System.out.println(request.getServletPath() + " ---> forward ---> " + pageUrl);
			request.getRequestDispatcher(pageUrl).forward(request, response);;
		}
		
	}
}
