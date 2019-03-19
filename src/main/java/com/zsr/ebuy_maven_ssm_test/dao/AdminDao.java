package com.zsr.ebuy_maven_ssm_test.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AdminDao {
	/**
	 * 根据账户名和密码去数据库查询，进行登录判断
	 * @param username 账户名
	 * @param password 密码
	 * @return true表示登录成功,false表示登录失败
	 */
	public boolean login(String username,String password){
		boolean judge=false;//表示登录状态，默认失败
		Connection conn=DBHelper.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try{
			//数据库获取用户名和密码
			String sql="select username,password from admin where username=? and password=?"; 
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			rs=pstmt.executeQuery();
			if(rs.next()){   //如果能够从数据库找到记录
				judge=true;
			}			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBHelper.closeConn(conn,pstmt,rs);
		}
		return judge;
	}
	
	
	public static void main(String[] args) {
		AdminDao adminDao=new AdminDao();
		System.out.println(adminDao.login("admin", "123"));
		System.out.println(adminDao.login("user", "123"));
		System.out.println(adminDao.login("user", "123456"));
		System.out.println(adminDao.login("zhangs", "111"));
	}
}
