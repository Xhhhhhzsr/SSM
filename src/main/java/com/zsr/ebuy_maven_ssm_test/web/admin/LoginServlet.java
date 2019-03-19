package com.zsr.ebuy_maven_ssm_test.web.admin;

import com.zsr.ebuy_maven_ssm_test.dao.AdminDao;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(urlPatterns="/Admin/login")
public class LoginServlet extends HttpServlet {

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = request.getContextPath();
		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
		
		//设置一个账号密码 name 和 pass
	/*	String name="user";
		String pass="123";*/
		//接受表单值  request.getParameter();
		//获取登录页面的用户名的表单参数值
		String username=request.getParameter("username");
		//方法一
		request.getSession().setAttribute("username", username);
		
		//session 传递用户数据方法二
			HttpSession session=request.getSession();
		session.setAttribute("user", username);
		//获取登录页面的密码的表单参数值
		String password=request.getParameter("password");
		//判断 用户名是否正确
		
		//获取数据库账号密码AdminDao dao=new AdminDao()
		 if(new AdminDao().login(username, password)){
		//正确跳转成功。进入成功页面
		
			response.sendRedirect(basePath+"/Jsp/Admin/main.html");
		}
		 //反之失败跳转回到登录页
		else{
			response.sendRedirect(basePath+"/Jsp/Admin/login.jsp");
		}
	}

}
