package br.com.skyline.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.skyline.dao.CidadesDAO;
import br.com.skyline.model.Cidades;

@WebServlet(urlPatterns = {"/cidades", "/cidades-create", "/cidades-update", "/cidades-delete"})
public class CidadesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	CidadesDAO cDao = new CidadesDAO();
    Cidades cid = new Cidades();

    public CidadesServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();

		switch (action) {
		case "/cidades":
			read(request, response);
			break;
		case "/cidades-create":
			create(request, response);
			break;
		case "/cidades-update":
			update(request, response);
			break;
		case "/cidades-delete":
			delete(request, response);
			break;
		default:
			response.sendRedirect("cidades?msg=Error");
			break;
		}
		
	}//doGet
		
	protected void read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Cidades> cidades = cDao.listar();
		
		request.setAttribute("cidades", cidades);
		
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/cidades.jsp");
		rd.forward(request, response);
	}
	
	protected void create(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		cid.setCidade(request.getParameter("cidade"));
		cid.setEstado(request.getParameter("estado"));
		cid.setPais(request.getParameter("pais"));
		cid.setAeroporto(request.getParameter("aero"));
		
		cDao.createCidade(cid);
		
		response.sendRedirect("cidades");
	}
	
	protected void delete(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		cDao.apagar(id);
		response.sendRedirect("cidades");
	}
	
	protected void update(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		cid = cDao.buscarPorId(id);
		cid.setCidade(request.getParameter("cidade"));
		cid.setEstado(request.getParameter("estado"));
		cid.setPais(request.getParameter("pais"));
		cid.setAeroporto(request.getParameter("aero"));

		
		cDao.atualizarDados(cid);
		
		response.sendRedirect("cidades");
	}

}
