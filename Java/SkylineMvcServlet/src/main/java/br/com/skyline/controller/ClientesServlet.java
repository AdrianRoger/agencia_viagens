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
import br.com.skyline.model.Clientes;

@WebServlet(urlPatterns = {"/clientes", "/clientes-create", "/clientes-update", "/clientes-updateCpf", "/clientes-delete"})
public class ClientesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	Clientes cli = new Clientes();
	ClientesDAO cDao = new ClientesDAO();
	
    public ClientesServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getServletPath();

		switch (action) {
		case "/clientes":
			read(request, response);
			break;
		case "/clientes-create":
			create(request, response);
			break;
		case "/clientes-update":
			update(request, response);
			break;
		case "/clientes-updateCpf":
			updateCpf(request, response);
			break;
		case "/clientes-delete":
			delete(request, response);
			break;
		default:
			response.sendRedirect("voo?msg=Error");
			break;
		}
		
	}//doGet
	
	protected void read(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		List<Clientes> clientes = cDao.listar();
		request.setAttribute("clientes", clientes);
		
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/clientes.jsp");
		rd.forward(request, response);
	}
	
	protected void create(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		cli.setCpf(request.getParameter("cpf"));
		cli.setNome(request.getParameter("nome"));
		cli.setEmail(request.getParameter("email"));
		cli.setTelefone(request.getParameter("telefone"));
		cli.setCep(request.getParameter("cep"));
		cli.setRua(request.getParameter("rua"));
		cli.setNumero(Integer.parseInt(request.getParameter("numero")));
		cli.setComplemento(request.getParameter("complemento"));
		
		cDao.createCliente(cli);
		response.sendRedirect("clientes");
	}
	
	protected void update(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		cli = cDao.buscarPorCpf(request.getParameter("cpf"));
		
		cli.setNome(request.getParameter("nome"));
		cli.setEmail(request.getParameter("email"));
		cli.setTelefone(request.getParameter("telefone"));
		cli.setCep(request.getParameter("cep"));
		cli.setRua(request.getParameter("rua"));
		cli.setNumero(Integer.parseInt(request.getParameter("numero")));
		cli.setComplemento(request.getParameter("complemento"));
		
		cli.setAtivo(request.getParameter("ativo") == "Sim" ? true : false);
		
		cDao.atualizarDados(cli);
		
		response.sendRedirect("clientes");
	}
	
	protected void delete(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String cpf = request.getParameter("cpf");
		cDao.apagar(cpf);
		
		response.sendRedirect("clientes");
	}
	
	protected void updateCpf(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		
		String oldCpf = request.getParameter("oldcpf");
		String newCpf = request.getParameter("newcpf");
		
		cDao.atualizarCpf(oldCpf, newCpf);

		
		response.sendRedirect("clientes");
	}

}
