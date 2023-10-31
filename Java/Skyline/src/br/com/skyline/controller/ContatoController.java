package br.com.skyline.controller;

import java.util.Scanner;

import br.com.skyline.dao.ContatoDAO;
import br.com.skyline.model.Contato;

public class ContatoController {
	ContatoDAO contatoDao = new ContatoDAO(); 
	private int id;

	private Scanner extracted() {
		return new Scanner(System.in);
	}
	
	public void createContatoController() {
		Contato c = new Contato();
		System.out.print("Digite seu nome: ");
		c.setNome(extracted().nextLine());
		System.out.print("Digite seu Email: ");
		c.setEmail(extracted().nextLine());
		System.out.print("Digite seu telefone: ");
		c.setTelefone(extracted().nextLine());
		System.out.print("Digite sua mensagem: ");
		c.setMensagem(extracted().nextLine());
		
		contatoDao.createContato(c);
	}

	public void listarContatoController() {
		for(Contato c1 : contatoDao.listar()) {
			System.out.println(c1.toString());
		}
	}

	public void buscarPorIdContatoController() {
		System.out.println("Digite o ID para buscar: ");
		id = extracted().nextInt();
		Contato c2 = new Contato();
		c2 = contatoDao.buscarPorId(id);
		System.out.println(c2.toString());
	}

	public void atualizarContatoController() {
		Contato c3 = new Contato();
		System.out.print("Digite seu Id: ");
		c3.setId_contato(extracted().nextInt());
		System.out.print("Digite seu nome: ");
		c3.setNome(extracted().nextLine());
		System.out.print("Digite seu Email: ");
		c3.setEmail(extracted().nextLine());
		System.out.print("Digite seu telefone: ");
		c3.setTelefone(extracted().nextLine());
		System.out.print("Digite sua mensagem: ");
		c3.setMensagem(extracted().nextLine());
		System.out.print("Resolvido? ");
		c3.setResolvido(extracted().nextBoolean());
		
		contatoDao.atualizar(c3);
	}

	public void apagarContatoController() {
		System.out.println("Digite o ID do registro que deseja apagar: ");
		id = extracted().nextInt();
		contatoDao.apagar(id);
	}
	
	
}
