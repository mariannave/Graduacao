package br.edu.ifpb;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/debug")
public class DebugServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public DebugServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Enumeration e = request.getParameterNames();
		
		response.setContentType("text/html");
	    PrintWriter out = response.getWriter();
		
	    out.println("Todos os parametros usados");
		  while(e.hasMoreElements())
		    {
		      Object obj = e.nextElement();
		      String fieldName = (String) obj;
		      String fieldValue = request.getParameter(fieldName);
		      out.println(fieldName + " : " + fieldValue + "<br>");
		    }        
		
		 out.println("Nome do Metodo");
		 String metodo = request.getMethod();
		 out.println("Veio pelo Metodo ->" + metodo);
		
		 
		 
		 Enumeration enu = request.getHeaderNames();
		 
		 while(enu.hasMoreElements()) {
		 
		 }		 
		 
		out.close();
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
