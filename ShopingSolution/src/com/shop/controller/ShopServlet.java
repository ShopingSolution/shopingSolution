package com.shop.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.action.Action;
import com.shop.utils.ViewResolver;

/**
 * Servlet implementation class PPServlet
 */
@WebServlet("/ShopServlet")
public class ShopServlet extends HttpServlet {
	
	private HandlerMapper mapper;
	Map<String, Action> commandMap;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		controller(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		controller(request, response);
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		mapper = HandlerMapper.getInstance();
		commandMap = mapper.getMap();
	}
	
	public void controller(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String command = request.getRequestURI();
		
		if(command.indexOf(request.getContextPath()) == 0){
			command = command.substring(request.getContextPath().length());
		}
		
		String view = null;
		Action act = null;
		
		act = (Action)commandMap.get(command);
		if(act == null){
			System.out.println("not found : " + command);
			return;
		}
		
		try{
			view = act.execute(request, response);			
		}catch(SQLException e){
			
		}
		
		if(view == null){
			return;
		}
		
		ViewResolver.view(request, response, view);
	}
	
	
}
