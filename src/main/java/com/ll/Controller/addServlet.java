package com.ll.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ll.Dao.Impl.TestDaoImpl;
import com.ll.bean.Record;

/**
 * Servlet implementation class Testservlet
 */
/**
 * 这个主要是为了完成数据库的插入和修改
 * @author zwd
 *
 */
public class addServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public addServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		String parameter = request.getParameter("tt1");name的值显示的值
//		String parameter2 = request.getParameter("tt2");
//		System.out.println(parameter);
//		System.out.println(parameter2);
		String parameter = request.getParameter("textarea");
		String parameter1 = request.getParameter("input");
		System.out.println(parameter);
		System.out.println(parameter1);
		TestDaoImpl tt=new TestDaoImpl();
		tt.search(parameter1, parameter);
		
//		
//		String recordid="11";
//		String recordthings="12";
		
//		Record record=new Record(recordid,recordthings);
//		Record r1=new Record("11", "11");
		Record r2=new Record("阿斯加德拉克隆数据", "22");
//		List<Record> re=new ArrayList<Record>();
//		re.add(record);
//		re.add(r1);
//		re.add(r2);
		ObjectMapper om=new ObjectMapper();
		String ws = om.writeValueAsString(r2);
		
		String value = new String(ws.getBytes( "UTF-8"),"ISO-8859-1");
		System.out.println(value);
//		response.getWriter().write(value);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
