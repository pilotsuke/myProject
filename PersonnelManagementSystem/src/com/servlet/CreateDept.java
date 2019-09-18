package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dbutil.DBTool;
import com.entity.Dept;

/**
 * Servlet implementation class CreateDept
 */
@WebServlet("/create.do")
public class CreateDept extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateDept() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String deptno=request.getParameter("deptno");
		String deptname=request.getParameter("deptname");
		String depttype=request.getParameter("depttype");
		String depttel=request.getParameter("depttel");
		String deptfax=request.getParameter("deptfax");
		String deptdesc=request.getParameter("deptdesc");
		String superiordept=request.getParameter("superiordept");
		String establish=request.getParameter("establish");
		
		Connection con=null;
		String sql=null;
		PreparedStatement ps=null;
		response.setCharacterEncoding("utf-8");
		PrintWriter pw=null;
//		传进来的是deptno
			con=DBTool.getCon();
			sql="insert into createdept values(?,?,?,?,?,?,?,?)";
			pw=response.getWriter();
			try {
				ps=con.prepareStatement(sql);
				ps.setString(1, deptno);
				ps.setString(2, deptname);
				ps.setString(3, depttype);
				ps.setString(4, depttel);
				ps.setString(5, deptfax);
				ps.setString(6, deptdesc);
				ps.setString(7, superiordept);
				ps.setString(8, establish);
				int row=ps.executeUpdate();
				if(row!=0){
					pw.print("insert sccuess");
				}else{
					pw.print("insert failure");
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
