package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dbutil.DBTool;
import com.entity.Dept;
import com.google.gson.Gson;

/**
 * Servlet implementation class EditDept
 */
@WebServlet("/editDept.do")
public class EditDept extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		request.setCharacterEncoding("utf-8");

		String elist=request.getParameter("da");
		String[] a=elist.split(";");
		Connection con=DBTool.getCon();
		String sql="update createdept set establish=?,superiordept=?,deptdesc=?,deptfax=?,depttel=?,depttype=?,deptname=? where deptno=?";
		PreparedStatement ps=null;
		response.setCharacterEncoding("utf-8");
		PrintWriter pw=response.getWriter();
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, a[0]);
			ps.setString(2, a[1]);
			ps.setString(3, a[2]);
			ps.setString(4, a[3]);
			ps.setString(5, a[4]);
			ps.setString(6, a[5]);
			ps.setString(7, a[6]);
			ps.setString(8, a[7]);
			
			
			int row=ps.executeUpdate();
			if(row>0){
				System.out.println("修改成功");
			}else{
				System.out.println("修改失败");
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
