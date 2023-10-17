package br.com.skyline.controller;

import java.util.Scanner;

import br.com.skyline.dao.CidadesDAO;
import br.com.skyline.model.Cidades;

public class CidadesController {
	CidadesDAO cidadeDao = new CidadesDAO(); 
	private int id;
	
	private Scanner extracted() {
		return new Scanner(System.in);
	}
	
	public void createCidadeController() {
		Cidades c = new Cidades();
		System.out.print("Digite a Cidade: ");
		c.setCidade(extracted().nextLine());
		System.out.print("Digite o Estado: ");
		c.setEstado(extracted().nextLine());
		System.out.print("Digite Pais: ");
		c.setPais(extracted().nextLine());
		System.out.print("Digite Aeroporto: ");
		c.setAeroporto(extracted().nextLine());
		
		cidadeDao.createCidade(c);
	}

	public void listarCidadeController() {
		
		for(Cidades c1 : cidadeDao.listar()) {
			System.out.println(c1.toString());
		}
	}

	public void buscarCidadesPorIDController() {
		System.out.println("Digite o ID para buscar: ");
		id = extracted().nextInt();
		Cidades c2 = new Cidades();
		c2 = cidadeDao.buscarPorId(id);
		System.out.println(c2.toString());
		
	}

	public void atualizarCidadeController() {
		Cidades c3 = new Cidades();
		System.out.print("Digite o Id: ");
		c3.setId_cidade(extracted().nextInt());
		
		System.out.print("Digite o nome da Cidade: ");
		c3.setCidade(extracted().nextLine());
		
		System.out.print("Digite o Estado: ");
		c3.setEstado(extracted().nextLine());
		
		System.out.print("Digite o País: ");
		c3.setPais(extracted().nextLine());
		
		System.out.print("Digite nome do Aeroporto: ");
		c3.setAeroporto(extracted().nextLine());
							
		cidadeDao.atualizarDados(c3);
	}

	public void apagarCidadeController() {
		System.out.println("Digite o ID do registro que deseja apagar: ");
		//id = s.nextInt();
		cidadeDao.apagar(extracted().nextInt());	
		
	}
		
}
