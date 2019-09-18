package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dbutil.DBTool;

/**
 * Servlet implementation class DelServlet
 */
@WebServlet("/delDept.do")
public class DelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String deptno=request.getParameter("deptno");
		Connection con=DBTool.getCon();
		String sql="delete from createdept where deptno=?";
		PreparedStatement ps=null;
		response.setCharacterEncoding("utf-8");
		PrintWriter pw=response.getWriter();
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, deptno);
			int row=ps.executeUpdate();
			if(row>0){
				pw.print("1");
			}else{
				pw.print("0");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
