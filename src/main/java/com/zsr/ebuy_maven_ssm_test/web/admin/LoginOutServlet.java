package com.zsr.ebuy_maven_ssm_test.web.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns="/Admin/loginout")
public class LoginOutServlet extends HttpServlet {

	//service 也可以替代 doget 和dopost
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = request.getContextPath();
		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
		
		response.sendRedirect(basePath+"/Jsp/Admin/login.jsp");
		
	}

}
