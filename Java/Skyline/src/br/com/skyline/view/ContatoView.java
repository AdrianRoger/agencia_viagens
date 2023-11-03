package br.com.skyline.view;

import java.util.Scanner;

import br.com.skyline.controller.ContatoController;

public class ContatoView {
	private Scanner s;
	private int menuContato = 0;
	
	public void contatoMenu() {
		ContatoController contatoController = new ContatoController();
		s = new Scanner(System.in);

		do {
			
			System.out.println("\n     ---- Contato ----     ");
			System.out.println("Selecione a opção desejada:");
			System.out.println("\n1- Registrar  2- Listar  3- Buscar por ID");
			System.out.println("4- Atualizar  5- Apagar  0- Voltar ao menu anterior\n");
			

			menuContato = s.nextInt();

			
			switch(menuContato) {
				
				case 1://create
					contatoController.createContatoController();
					break;
				case 2://listar
					contatoController.listarContatoController();					
					break;
				case 3://buscar por id
					contatoController.buscarPorIdContatoController();
					break;
				case 4://atualizar
					contatoController.atualizarContatoController();
					break;
				case 5://apagar
					contatoController.apagarContatoController();					
					break;
				default:
					break;
			
			}
			
		}while(menuContato != 0);

	}
	
}
