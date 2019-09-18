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
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dbutil.DBTool;
import com.entity.Dept;
import com.google.gson.Gson;

/**
 * Servlet implementation class SearchDept
 */
@WebServlet("/search.do")
//@MultipartConfig
public class SearchDept extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		String sdeptno=request.getParameter("sdeptno");
		String sdeptname=request.getParameter("sdeptname");
		String sdepttype=request.getParameter("sdepttype");
		
		System.out.println("sdeptno:"+sdeptno+"sdeptname:"+sdeptname+"sdepttype:"+sdepttype);
		
		Connection con=DBTool.getCon();
		String sql="select * from createdept";
		
		if(!(sdeptno.equals("")) || !(sdeptname.equals("")) || !(sdepttype.equals(""))){
			sql+=" where";
			if(!(sdeptno.equals(""))){
				sql+=" deptno=?";
			}
			if(!(sdeptname.equals(""))){
				sql+=" and deptname=?";
			}
			if(!(sdepttype.equals(""))){
				sql+=" and depttype=?";
			}
		}
		
		System.out.println(sql);
		
		
		PreparedStatement ps=null;
		response.setCharacterEncoding("utf-8");
		PrintWriter pw=response.getWriter();
		Dept deptResult=null;
		try {
			ps=con.prepareStatement(sql);
			int index=1;
			if(!(sdeptno.equals(""))){
				ps.setString(index++,sdeptno );
			}
			if(!(sdeptname.equals(""))){
				ps.setString(index++,sdeptname);
			}
			if(!(sdepttype.equals(""))){
				ps.setString(index++,sdepttype);
			}
			
			ResultSet rs=ps.executeQuery();
			Gson gs=new Gson();
			List<Dept> dlist=new ArrayList<Dept>();
			while(rs.next()){
				deptResult=new Dept();
				deptResult.setDeptno(rs.getString("deptno"));
				deptResult.setDeptname(rs.getString("deptname"));
				deptResult.setDepttype(rs.getString("depttype"));
				deptResult.setDepttel(rs.getString("depttel"));
				deptResult.setDeptfax(rs.getString("deptfax"));
				deptResult.setDeptdesc(rs.getString("deptdesc"));
				deptResult.setSuperiordept(rs.getString("superiordept"));
				deptResult.setEstablish(rs.getString("establish"));
				
				dlist.add(deptResult);
			}
			if(dlist.size()>0){
				String objstr=gs.toJson(dlist);
				System.out.println("组合查询得到的结果是:"+objstr);
				pw.print(objstr);
			}
			else{
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
