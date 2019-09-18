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
 * Servlet implementation class EmpEntry
 */
@WebServlet("/empEntry.do")
public class EmpEntry extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		String eNo=request.getParameter("eNo");
		String eName=request.getParameter("eName");
		String eGender=request.getParameter("eGender");
		String eBirth=request.getParameter("eBirth");
		String eId=request.getParameter("eId");
		String eDept=request.getParameter("eDept");
		String eJob=request.getParameter("eJob");
		String eEntry=request.getParameter("eEntry");
		String eWork=request.getParameter("eWork");
		String eFormal=request.getParameter("eFormal");
		String eResource=request.getParameter("eResource");
		String ePolitic=request.getParameter("ePolitic");
		String eNation=request.getParameter("eNation");
		String eTel=request.getParameter("eTel");
		String eMail=request.getParameter("eMail");
		String eHeight=request.getParameter("eHeight");
		String eBlood=request.getParameter("eBlood");
		String eMarriage=request.getParameter("eMarriage");
		String eNative=request.getParameter("eNative");
		String eBirthPlace=request.getParameter("eBirthPlace");
		String eRPR=request.getParameter("eRPR");
		String eEdu=request.getParameter("eEdu");
		String eDegree=request.getParameter("eDegree");
		String eSchool=request.getParameter("eSchool");
		String eMajor=request.getParameter("eMajor");
		String eGraduate=request.getParameter("eGraduate");
		
		System.out.print("eNo:"+eNo);
		
		Connection con=null;
		String sql=null;
		PreparedStatement ps=null;
		response.setCharacterEncoding("utf-8");
		PrintWriter pw=null;
//		传进来的是deptno
			con=DBTool.getCon();
			sql="insert into entryInformation values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			pw=response.getWriter();
			try {
				ps=con.prepareStatement(sql);
				ps.setString(1, eNo);
				ps.setString(2, eName);
				ps.setString(3, eGender);
				ps.setString(4, eBirth);
				ps.setString(5, eId);
				ps.setString(6, eDept);
				ps.setString(7, eJob);
				ps.setString(8, eEntry);
				ps.setString(9, eWork);
				ps.setString(10, eFormal);
				ps.setString(11, eResource);
				ps.setString(12, ePolitic);
				ps.setString(13, eNation);
				ps.setString(14, eTel);
				ps.setString(15, eMail);
				ps.setString(16, eHeight);
				ps.setString(17, eBlood);
				ps.setString(18, eMarriage);
				ps.setString(19, eNative);
				ps.setString(20, eBirthPlace);
				ps.setString(21, eRPR);
				ps.setString(22, eEdu);
				ps.setString(23, eDegree);
				ps.setString(24, eSchool);
				ps.setString(25, eMajor);
				ps.setString(26, eGraduate);
				int row=ps.executeUpdate();
				if(row!=0){
					pw.print("1");
				}else{
					pw.print("0");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				pw.print("0");
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
