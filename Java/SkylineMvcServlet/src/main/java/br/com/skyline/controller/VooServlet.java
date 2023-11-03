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
import br.com.skyline.dao.VooDAO;
import br.com.skyline.model.Cidades;
import br.com.skyline.model.Voo;

@WebServlet(urlPatterns = { "/voo", "/voo-create", "/voo-update", "/voo-delete" })
public class VooServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Voo voo = new Voo();
	VooDAO vDao = new VooDAO();
	
	Cidades cid = new Cidades();
	CidadesDAO cDao = new CidadesDAO();

	public VooServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getServletPath();

		switch (action) {
		case "/voo":
			read(request, response);
			break;
		case "/voo-create":
			create(request, response);
			break;
		case "/voo-update":
			update(request, response);
			break;
		case "/voo-delete":
			delete(request, response);
			break;
		default:
			response.sendRedirect("voo?msg=Error");
			break;
		}

	}// doGet

	protected void read(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		List<Voo> voos = vDao.listar();
		request.setAttribute("voos", voos);
		
		List<Cidades> cidades = cDao.listar();
		request.setAttribute("cidades", cidades);

		RequestDispatcher rd = request.getRequestDispatcher("/jsp/voo.jsp");
		rd.forward(request, response);
	}

	protected void create(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		voo.setNum_voo(Integer.parseInt(request.getParameter("num_voo")));
		voo.setComp_aerea(request.getParameter("comp_aerea"));
		voo.setAssentos(Integer.parseInt(request.getParameter("assentos")));
		
		String preco = request.getParameter("preco_unit");
		preco = preco.replace(".", "");
		preco = preco.replace(",", ".");
		voo.setPreco_unit(Double.parseDouble(preco));
		
		voo.setData_partida(request.getParameter("data"));
		
		int aux = Integer.parseInt(request.getParameter("origem"));
		cid = cDao.buscarPorId(aux);
		voo.setOrigem(cid);
		
		aux = Integer.parseInt(request.getParameter("destino"));
		cid = cDao.buscarPorId(aux);
		voo.setDestino(cid);
		
		vDao.createVoo(voo);
		
		response.sendRedirect("voo");
	}
	
	protected void delete(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		vDao.apagar(id);
		response.sendRedirect("voo");
	}
	
	protected void update(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		voo = vDao.buscarPorId(id);
		voo.setNum_voo(Integer.parseInt(request.getParameter("num_voo")));
		voo.setComp_aerea(request.getParameter("comp_aerea"));
		voo.setAssentos(Integer.parseInt(request.getParameter("assentos")));
		
		String preco = request.getParameter("preco_unit");
		preco = preco.replace(".", "");
		preco = preco.replace(",", ".");
		voo.setPreco_unit(Double.parseDouble(preco));
		
		voo.setData_partida(request.getParameter("data"));
		
		int aux = Integer.parseInt(request.getParameter("origem"));
		cid = cDao.buscarPorId(aux);
		voo.setOrigem(cid);
		
		aux = Integer.parseInt(request.getParameter("destino"));
		cid = cDao.buscarPorId(aux);
		voo.setDestino(cid);
		
		vDao.atualizarDados(voo);
		
		response.sendRedirect("voo");
	}

}
