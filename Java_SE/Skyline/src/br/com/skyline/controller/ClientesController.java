package br.com.skyline.controller;

import java.util.Scanner;

import br.com.skyline.dao.ClientesDAO;
import br.com.skyline.model.Clientes;

public class ClientesController {
	ClientesDAO clienteDao = new ClientesDAO(); 
	private String cpf;
	
	private Scanner extracted() {
		return new Scanner(System.in);
	}
	
	public void createClientesController() {
		Clientes c = new Clientes();
		System.out.print("CPF: ");
		c.setCpf(extracted().nextLine());
		System.out.print("Nome: ");
		c.setNome(extracted().nextLine());
		System.out.print("Email: ");
		c.setEmail(extracted().nextLine());
		System.out.print("Telefone: ");
		c.setTelefone(extracted().nextLine());
		System.out.println("Cep: ");
		c.setCep(extracted().nextLine());
		System.out.println("Rua: ");
		c.setRua(extracted().nextLine());
		System.out.println("Numero: ");
		c.setNumero(extracted().nextInt());
		System.out.println("Complemento: ");
		c.setComplemento(extracted().nextLine());
		
		clienteDao.createCliente(c);
	}

	public void listarClientesController() {
		for(Clientes c1 : clienteDao.listar()) {
			System.out.println(c1.toString());
		}
	}


	public void buscarPorCpfClientesController() {
		System.out.println("Digite o CPF para buscar: ");
		cpf = extracted().nextLine();
		Clientes c2 = new Clientes();
		c2 = clienteDao.buscarPorCpf(cpf);
		System.out.println(c2.toString());		
	}


	public void atualizarDadosConlientesController() {
		Clientes c3 = new Clientes();
		
		System.out.print("Digite o CPF: ");
		c3.setCpf(extracted().nextLine());
		
		System.out.print("Nome: ");
		c3.setNome(extracted().nextLine());
		
		System.out.print("Email: ");
		c3.setEmail(extracted().nextLine());
		
		System.out.print("Telefone: ");
		c3.setTelefone(extracted().nextLine());
		
		System.out.print("cep: ");
		c3.setCep(extracted().nextLine());
							
		System.out.print("Rua: ");
		c3.setRua(extracted().nextLine());
		
		System.out.print("Numero: ");
		c3.setNumero(extracted().nextInt());
		
		System.out.print("Complemento: ");
		c3.setComplemento(extracted().nextLine());
		
		System.out.print("Ativo?: ");
		c3.setAtivo(extracted().nextBoolean());
		
		clienteDao.atualizarDados(c3);
	}

	public void apagarClientesController() {
		System.out.println("Digite o CPF do registro que deseja apagar: ");
		clienteDao.apagar(extracted().nextLine());
	}
	

}
