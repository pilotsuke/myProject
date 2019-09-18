package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dbutil.DBTool;
import com.entity.Dept;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		String uid=request.getParameter("uid");
		String pwd=request.getParameter("pwd");
		
		System.out.println(uid+" "+pwd);
		
		Connection con=DBTool.getCon();
		String sql="select * from accountManagement where uid=? and pwd=?";
		
		PreparedStatement ps=null;
		PrintWriter pw=response.getWriter();
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, uid);
			ps.setString(2, pwd);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				System.out.println("µÇÂ¼³É¹¦");
				pw.print("success");
			}else{
				System.out.println("µÇÂ¼Ê§°Ü");
				pw.print("failure");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			pw.close();
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
