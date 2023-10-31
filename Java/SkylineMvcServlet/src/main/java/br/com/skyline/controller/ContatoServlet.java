package br.com.skyline.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.skyline.dao.ContatoDAO;
import br.com.skyline.model.Contato;

@WebServlet(urlPatterns = {"/contato", "/contato-create", "/contato-update", "/contato-delete"})
public class ContatoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Contato contato = new Contato();
	ContatoDAO cDao = new ContatoDAO();
       
    public ContatoServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String action = request.getServletPath();

		switch (action) {
		case "/contato":
			read(request, response);
			break;
		case "/contato-create":
			create(request, response);
			break;
		case "/contato-update":
			update(request, response);
			break;
		case "/contato-delete":
			delete(request, response);
			break;
		default:
			response.sendRedirect("contato?msg=Error");
			break;
		}
		
	}//doGet
	
	protected void read(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException  {
		List<Contato> contatos = cDao.listar();
		
		request.setAttribute("contatos", contatos);
		
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/contato.jsp");
		rd.forward(request, response);
	}
	
	protected void create(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		contato.setNome(request.getParameter("nome"));
		contato.setEmail(request.getParameter("email"));
		contato.setTelefone(request.getParameter("telefone"));
		contato.setMensagem(request.getParameter("msg"));
		
		cDao.createContato(contato);
		
		response.sendRedirect("contato");
	}
	
	protected void delete(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		cDao.apagar(id);
		response.sendRedirect("contato");
	}
	
	protected void update(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		contato = cDao.buscarPorId(id);
		contato.setResolvido(true);
		
		cDao.atualizar(contato);
		
		response.sendRedirect("contato");
	}
	
}
