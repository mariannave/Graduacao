package br.edu.ifpb;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/valide")
public class ValidaLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ValidaLoginServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Properties passwdFile;
		passwdFile = new Properties();
		
		try {
			
			passwdFile.load(
					this.getServletContext().getResourceAsStream("/WEB-INF/senhas.properties"));
			
		}catch (IOException e){
			
			response.sendError(
					response.SC_BAD_REQUEST,"Erro ao ler o arquivo de senhas");
			return;
		}
		
		
		
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		
		if(passwdFile.containsKey(login) && senha.equals(passwdFile.get(login))) {
			request.setAttribute("login",login);
			request.getRequestDispatcher("loginValido.jsp").forward(request, response);
		} else {
			response.sendRedirect("index.html");
		}
		
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<html><body>");
		out.println("<h1>Login:"+login+"</h1>");
		out.println("<h1>Senha:"+senha+"</h1>");
		out.println("</body></html>");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<html><body>");
		out.println("<h1>Login:"+login+"</h1>");
		out.println("<h1>Senha:"+senha+"</h1>");
		out.println("</body></html>");
		
	}

}
