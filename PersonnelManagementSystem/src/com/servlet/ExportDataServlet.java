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
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dbutil.DBTool;
import com.entity.Dept;
import com.google.gson.Gson;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

/**
 * Servlet implementation class ExportDataServlet
 */
@WebServlet("/exportDataServlet")
public class ExportDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("����ExportDataServlet");
		//�趨��Ӧ���ݵ�����
		response.setHeader("Content-disposition", "attachment;filename=DeptInfo.xls");
		//�����޻���
		response.setHeader("pragma", "no-cache");
		//�����������
		response.setContentType("application/mxexcel");
		
		//��ȡ���������
		ServletOutputStream os=response.getOutputStream();
		
		//����������
		WritableWorkbook book = Workbook.createWorkbook(os);
		//����sheet   ��һ��������sheet����    �ڶ���������sheet������ֵ   ����ֵ��0��ʼ
		WritableSheet sheet = book.createSheet("������Ϣ", 0);
		
		//�趨��ʽ
		WritableFont font1 = new WritableFont(WritableFont.TIMES,16,WritableFont.BOLD);
		//Ƕ����ʽ����Ԫ��
		WritableCellFormat format1 = new WritableCellFormat(font1);
		
		//�趨��ʽ
		WritableFont font2 = new WritableFont(WritableFont.TIMES,12,WritableFont.NO_BOLD);
		//Ƕ����ʽ����Ԫ��
		WritableCellFormat format2 = new WritableCellFormat(font2);
				
		
		//������Ԫ��  ��һ���������е�����   �ڶ����������е�����   �����������ǵ�Ԫ�������   ���ĸ���Ԫ����Ƕ�����ʽ
		Label cell = new Label(0,0,"������Ϣ�б�",format1);
		
		try {
			sheet.addCell(cell);
			//������ͷ�ĵ�Ԫ��
			sheet.addCell(new Label(0,1,"���ű��",format2));
			sheet.addCell(new Label(1,1,"��������",format2));
			sheet.addCell(new Label(2,1,"��������",format2));
			sheet.addCell(new Label(3,1,"���ŵ绰",format2));
			sheet.addCell(new Label(4,1,"���Ŵ���",format2));
			sheet.addCell(new Label(5,1,"��������",format2));
			sheet.addCell(new Label(6,1,"�ϼ�����",format2));
			sheet.addCell(new Label(7,1,"���Ŵ���ʱ��",format2));
		} catch (RowsExceededException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (WriteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Connection con=DBTool.getCon();
		String sql="select * from createdept";
		PreparedStatement ps=null;
		response.setCharacterEncoding("utf-8");
		Dept deptResult=null;

			try {
				ps=con.prepareStatement(sql);
				ResultSet rs=ps.executeQuery();
				Gson gs=new Gson();
				List<Dept> dlist=new ArrayList<Dept>();
				while(rs.next()){
					Dept d1 = new Dept();
					d1.setDeptno(rs.getString("deptno"));
					d1.setDeptname(rs.getString("deptname"));
					d1.setDepttype(rs.getString("depttype"));
					d1.setDepttel(rs.getString("depttel"));
					d1.setDeptfax(rs.getString("deptfax"));
					d1.setDeptdesc(rs.getString("deptdesc"));
					d1.setSuperiordept(rs.getString("superiordept"));
					d1.setEstablish(rs.getString("establish"));
					dlist.add(d1);
				}
				for(int i=0;i<dlist.size();i++){
					Dept d = dlist.get(i);
					try {
						sheet.addCell(new Label(0,i+2,d.getDeptno(),format2));
						sheet.addCell(new Label(1,i+2,d.getDeptname(),format2));
						sheet.addCell(new Label(2,i+2,d.getDepttype(),format2));
						sheet.addCell(new Label(3,i+2,d.getDepttel(),format2));
						sheet.addCell(new Label(4,i+2,d.getDeptfax(),format2));
						sheet.addCell(new Label(5,i+2,d.getDeptdesc(),format2));
						sheet.addCell(new Label(6,i+2,d.getSuperiordept(),format2));
						sheet.addCell(new Label(7,i+2,d.getEstablish(),format2));
					} catch (RowsExceededException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (WriteException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				book.write();
				try {
					book.close();
				} catch (WriteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				os.close();
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
