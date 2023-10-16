package br.com.skyline.controller;

import java.util.Scanner;

import br.com.skyline.dao.ReservasDAO;
import br.com.skyline.model.Clientes;
import br.com.skyline.model.Reservas;
import br.com.skyline.model.Voo;

public class ReservasController {
	ReservasDAO resDao = new ReservasDAO();
	private int id;
	
	private Scanner extracted() {
		return new Scanner(System.in);
	}
	
	public void createReversasController() {
		Reservas res = new Reservas();
		Voo voo = new Voo();
		Clientes cli = new Clientes();
		
		System.out.print("Numero de pessoas da Reserva: ");
		res.setNum_pessoas(extracted().nextInt());
		
		System.out.println("Digite o CPF do Cliente: ");
		cli.setCpf(extracted().nextLine());
		
		System.out.println("Digite o ID do Voo: ");
		voo.setId_voo(extracted().nextInt());
		res.setCliente(cli);
		res.setVoo(voo);
							
		resDao.createReserva(res);
	}

	public void listarReservasController() {
		for(Reservas r1 : resDao.listar()) {
			System.out.println(r1.toString());
		}
	}

	public void buscarPorIdReservasController() {
		System.out.println("Digite o ID para buscar: ");
		id = extracted().nextInt();
		Reservas r2 = new Reservas();
		r2 = resDao.buscarPorId(id);
		System.out.println(r2.toString());
	}

	public void atualizarReservasController() {
		Reservas r3 = new Reservas();
		Voo v1 = new Voo();
		
		
		System.out.print("Digite o ID para Atualizar: ");
		r3.setId_reserva(extracted().nextInt());
		
		System.out.print("Numero de pessas da reserva: ");
		r3.setNum_pessoas(extracted().nextInt());
		
		System.out.println("Cancelar reserva? \n "
						 + "true para SIM / false para NÃO ");
		r3.setCancelada(extracted().nextBoolean());
		
		
		System.out.println("Digite o ID do Voo: ");
		v1.setId_voo(extracted().nextInt());
		r3.setVoo(v1);
							
		resDao.atualizarDados(r3);
	}

	public void apagarReservasController() {
		System.out.println("Digite o ID do registro que deseja apagar: ");
		//id = s.nextInt();
		resDao.apagar(extracted().nextInt());
	}


	
	
	
}
