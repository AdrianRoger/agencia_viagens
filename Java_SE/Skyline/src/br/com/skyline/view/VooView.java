package br.com.skyline.view;

import java.util.Scanner;

import br.com.skyline.controller.VooController;

public class VooView {
	private Scanner s;
	private int menuVoo = 0;
	
	public void vooMenu() {
		VooController vooController = new VooController();
		s = new Scanner(System.in);		
		
		
		do {
			
			System.out.println("\n     ---- Voo ----     ");
			System.out.println("Selecione a opção desejada:");
			System.out.println("\n1- Cadastrar  2- Listar  3- Buscar por ID");
			System.out.println("4- Atualizar  5- Apagar  0- Voltar ao menu anterior\n");

			menuVoo = s.nextInt();
			//s.nextLine();
			
			switch(menuVoo) {
				case 1://create
					vooController.createVooController();
					break;
				case 2://listar
					vooController.listarVooController();
					break;
				case 3://buscar por ID
					vooController.buscarPorIdVooController();
					break;
				case 4://Atualizar
					vooController.atualizarVooController();
					break;
				case 5://Apagar
					vooController.apagarVooController();					
					break;
				default:
					break;
			}
			
		}while(menuVoo != 0);

	}
}
