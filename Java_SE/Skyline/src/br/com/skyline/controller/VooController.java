package br.com.skyline.controller;

import java.util.Scanner;

import br.com.skyline.dao.VooDAO;
import br.com.skyline.model.Cidades;
import br.com.skyline.model.Voo;

public class VooController {
	VooDAO vooDao = new VooDAO(); 
	private int id;
	
	private Scanner extracted() {
		return new Scanner(System.in);
	}
	
	public void createVooController() {
		Voo v = new Voo();
		Cidades cOrigem = new Cidades();
		Cidades cDestino = new Cidades();
		
		System.out.print("Numero do Voo: ");
		v.setNum_voo(extracted().nextInt());
		System.out.print("Companhia Aérea: ");
		v.setComp_aerea(extracted().nextLine());
		System.out.print("Numero de Assentos: ");
		v.setAssentos(extracted().nextInt());
		System.out.print("Preco Unitário: ");
		v.setPreco_unit(extracted().nextDouble());
		//new Scanner(System.in).nextLine();//correção de bug da Scanner
		System.out.println("Data de partida: (Dia/Mês/Ano) ");
		v.setData_partida(extracted().nextLine());
		
		System.out.println("Digite o ID da cidade de origem");
		cOrigem.setId_cidade(extracted().nextInt());
		System.out.println("Digite o ID da cidade de destino");
		cDestino.setId_cidade(extracted().nextInt());
		v.setOrigem(cOrigem);
		v.setDestino(cDestino);
		
		vooDao.createVoo(v);		
	}

	public void listarVooController() {
		for(Voo v1 : vooDao.listar()) {
			System.out.println(v1.toString());
		}		
	}

	public void buscarPorIdVooController() {
		System.out.println("Digite o ID para buscar: ");
		id = extracted().nextInt();
		Voo v2 = new Voo();
		v2 = vooDao.buscarPorId(id);
		System.out.println(v2.toString());		
	}

	public void atualizarVooController() {
		Voo v3 = new Voo();
		Cidades cOrigem1 = new Cidades();
		Cidades cDestino1 = new Cidades();
		
		System.out.print("Digite o ID para Atualizar: ");
		v3.setId_voo(extracted().nextInt());
		
		System.out.print("Numero do Voo: ");
		v3.setNum_voo(extracted().nextInt());
		System.out.print("Companhia Aérea: ");
		v3.setComp_aerea(extracted().nextLine());
		System.out.print("Numero de Assentos: ");
		v3.setAssentos(extracted().nextInt());
		System.out.print("Preco Unitário: ");
		v3.setPreco_unit(extracted().nextDouble());
		//new Scanner(System.in).nextLine();//correção de bug da Scanner
		System.out.println("Data de partida: (Dia/Mês/Ano) ");
		v3.setData_partida(extracted().nextLine());
		
		System.out.println("Digite o ID da cidade de origem");
		cOrigem1.setId_cidade(extracted().nextInt());
		System.out.println("Digite o ID da cidade de destino");
		cDestino1.setId_cidade(extracted().nextInt());
		v3.setOrigem(cOrigem1);
		v3.setDestino(cDestino1);
							
		vooDao.atualizarDados(v3);
	}

	public void apagarVooController() {
		System.out.println("Digite o ID do registro que deseja apagar: ");
		//id = s.nextInt();
		vooDao.apagar(extracted().nextInt());
	}
	
	
	
	
}
