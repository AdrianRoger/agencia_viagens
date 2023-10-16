package br.com.skyline.view;

import java.util.Scanner;

import br.com.skyline.controller.ReservasController;

public class ReservasView {
	private Scanner s;
	private int menuRes = 0;

	public void reservasMenu() {
		ReservasController reservasController = new ReservasController();
		s = new Scanner(System.in);
		
		do {
			
			System.out.println("\n     ---- Reservas ----     ");
			System.out.println("Selecione a opção desejada:");
			System.out.println("\n1- Cadastrar  2- Listar  3- Buscar por ID");
			System.out.println("4- Atualizar  5- Apagar  0- Voltar ao menu anterior\n");

			menuRes = s.nextInt();
			//s.nextLine();
			
			switch(menuRes) {
				case 1://create
					reservasController.createReversasController();
					break;
				case 2://listar
					reservasController.listarReservasController();
					break;
				case 3://buscar por ID
					reservasController.buscarPorIdReservasController();
					break;
				case 4://Atualizar
					reservasController.atualizarReservasController();
					break;
				case 5://Apagar
					reservasController.apagarReservasController();					
					break;
				default:
					break;
			}
		}while(menuRes != 0);
	}
}