package com.ll.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ll.Dao.Impl.TestDaoImpl;
import com.ll.bean.Record;

/**
 * Servlet implementation class SetandDel
 */
public class SetandDel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SetandDel() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String parameter1 = request.getParameter("input");
		System.out.println(parameter1);
		TestDaoImpl tt=new TestDaoImpl();
		Record querer = tt.querer(parameter1);
		System.out.println(querer+"121");

		
		ObjectMapper om=new ObjectMapper();
		String ws = om.writeValueAsString(querer);
		
		System.out.println(ws+"ws");
		String value = new String(ws.getBytes( "UTF-8"),"ISO-8859-1");
//		System.out.println(value);
		if(value==null) {
			String ss="kong";
			response.getWriter().write(ss);
		}
		else {
			response.getWriter().write(value);
		}
		
//		response.getWriter().write(search);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
