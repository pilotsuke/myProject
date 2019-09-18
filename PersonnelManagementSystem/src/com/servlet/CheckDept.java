package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dbutil.DBTool;

/**
 * Servlet implementation class CreateDept
 */
@WebServlet("/check.do")
@MultipartConfig
public class CheckDept extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public CheckDept() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("utf-8");
		
		String onblurName=request.getParameter("onblurName");
		String onblurValue=request.getParameter("onblurValue");
		System.out.println("名字是: "+onblurName+" 值是: "+onblurValue);
//		新建部门的时候需要检查以上4项内容, 不能重复, 加4个判断
		Connection con=null;
		String sql=null;
		PreparedStatement ps=null;
		response.setCharacterEncoding("utf-8");
		PrintWriter pw=null;
		ResultSet rs=null;
//		传进来的是deptno
		if(onblurName.equals("deptno")){
			con=DBTool.getCon();
			sql="select * from createdept where deptno=?";
			pw=response.getWriter();
			try {
				ps=con.prepareStatement(sql);
				ps.setString(1, onblurValue);
				rs=ps.executeQuery();
				if(rs.next()){
					pw.print("deptno has been existed");
				}else{
					pw.print("deptno can use");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				pw.close();
			}
		}
//			传进来的是deptname
		else if(onblurName.equals("deptname")){
				con=DBTool.getCon();
				sql="select * from createdept where deptname=?";
				pw=response.getWriter();
				try {
					ps=con.prepareStatement(sql);
					ps.setString(1, onblurValue);
					rs=ps.executeQuery();
					if(rs.next()){
						pw.print("deptname has been existed");
					}else{
						pw.print("deptname can use");
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally{
					pw.close();
				}
		}
//			传进来的是电话
		else if(onblurName.equals("depttel")){
				con=DBTool.getCon();
				sql="select * from createdept where depttel=?";
				pw=response.getWriter();
				try {
					ps=con.prepareStatement(sql);
					ps.setString(1, onblurValue);
					rs=ps.executeQuery();
					if(rs.next()){
						pw.print("depttel has been existed");
					}else{
						pw.print("depttel can use");
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally{
					pw.close();
				}
			}
//			传进来的是传真
		else if(onblurName.equals("deptfax")){
				con=DBTool.getCon();
				sql="select * from createdept where deptfax=?";
				pw=response.getWriter();
				try {
					ps=con.prepareStatement(sql);
					ps.setString(1, onblurValue);
					rs=ps.executeQuery();
					if(rs.next()){
						pw.print("deptfax has been existed");
					}else{
						pw.print("deptfax can use");
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally{
					pw.close();
				}
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
