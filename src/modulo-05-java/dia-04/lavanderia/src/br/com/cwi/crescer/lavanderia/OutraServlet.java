package br.com.cwi.crescer.lavanderia;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "outra", urlPatterns = { "/outra" })
public class OutraServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int primeiro = 1;
		int segundo = 1;
		
		int resultado = primeiro + segundo;
		
		request.setAttribute("resultado", resultado);
		
		request.getRequestDispatcher("saida-outra.jsp")
			.forward(request, response);
		
	}
}













