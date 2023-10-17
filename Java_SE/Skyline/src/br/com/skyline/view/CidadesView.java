package br.com.skyline.view;

import java.util.Scanner;

import br.com.skyline.controller.CidadesController;

public class CidadesView {
	private Scanner s;
	private int menuCidade = 0;
	
	public void cidadeMenu() {
		CidadesController cidController = new CidadesController(); 

		s = new Scanner(System.in);
		
		
		do {
			
			System.out.println("\n     ---- Cidades ----     ");
			System.out.println("Selecione a opção desejada:");
			System.out.println("\n1- Cadastrar  2- Listar  3- Buscar por ID");
			System.out.println("4- Atualizar  5- Apagar  0- Voltar ao menu anterior\n");
			

			menuCidade = s.nextInt();
			//s.nextLine();
			
			switch(menuCidade) {
				
				case 1://create
					cidController.createCidadeController();
					break;
					
				case 2://listar
					cidController.listarCidadeController();
					break;
					
				case 3://buscar por ID
					cidController.buscarCidadesPorIDController();
					break;
					
				case 4://Atualizar
					cidController.atualizarCidadeController();
					break;
					
				case 5://Apagar
					cidController.apagarCidadeController();				
					break;
				default:
					break;
			
			}
			
		}while(menuCidade != 0);

	}
	
}
