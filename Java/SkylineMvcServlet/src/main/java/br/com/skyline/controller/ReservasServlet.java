package br.com.skyline.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.skyline.dao.ClientesDAO;
import br.com.skyline.dao.ReservasDAO;
import br.com.skyline.dao.VooDAO;
import br.com.skyline.model.Clientes;
import br.com.skyline.model.Reservas;
import br.com.skyline.model.Voo;

@WebServlet(urlPatterns = { "/reservas", "/reservas-create", "/reservas-update", "/reservas-delete", "/reservas-cancel" })
public class ReservasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ReservasDAO rDao = new ReservasDAO();
	Reservas r = new Reservas();
	
	ClientesDAO cDao = new ClientesDAO();
	Clientes cli = new Clientes();
	
	VooDAO vDao = new VooDAO();
	Voo voo = new Voo();
	
	public ReservasServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String action = request.getServletPath();

		switch (action) {
		case "/reservas":
			read(request, response);
			break;
		case "/reservas-create":
			create(request, response);
			break;
		case "/reservas-update":
			update(request, response);
			break;
		case "/reservas-cancel":
			cancel(request, response);
			break;
		case "/reservas-delete":
			delete(request, response);
			break;
		default:
			response.sendRedirect("voo?msg=Error");
			break;
		}
		
	}//doGet
	
	protected void read(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Reservas> reservas =  rDao.listar();
		request.setAttribute("reservas", reservas);
		
		List<Clientes> clientes = cDao.listar();
		request.setAttribute("clientes", clientes);
		
		List<Voo> voos = vDao.listar();
		request.setAttribute("voos", voos);
		
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/reservas.jsp");
		rd.forward(request, response);
	}
	
	protected void delete(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		int id = Integer.parseInt(request.getParameter("id"));
		rDao.apagar(id);
		
		response.sendRedirect("reservas");		
	}
	
	protected void create(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		r.setNum_pessoas(Integer.parseInt(request.getParameter("num_pessoas")));
		
		cli = cDao.buscarPorCpf(request.getParameter("cliente"));
		r.setCliente(cli);
		
		voo = vDao.buscarPorId(Integer.parseInt(request.getParameter("voo")));
		r.setVoo(voo);
		
		rDao.createReserva(r);
		
		response.sendRedirect("reservas");
	}
	
	protected void update(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		int id = Integer.parseInt(request.getParameter("id"));
		r = rDao.buscarPorId(id);
		r.setNum_pessoas(Integer.parseInt(request.getParameter("num_pessoas")));
		
		voo = vDao.buscarPorId(Integer.parseInt(request.getParameter("voo")));
		r.setVoo(voo);
		
		rDao.atualizarDados(r);
		
		response.sendRedirect("reservas");
	}
	
	protected void cancel(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		r = rDao.buscarPorId(id);
		
		r.setCancelada(true);
		
		rDao.atualizarDados(r);
		
		response.sendRedirect("reservas");
	}
	
}//fim Servlet
