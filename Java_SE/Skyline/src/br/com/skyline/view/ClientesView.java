package br.com.skyline.view;

import java.util.Scanner;

import br.com.skyline.controller.ClientesController;

public class ClientesView {
	private Scanner s;
	private int menuCliente = 0;

	public void clienteMenu() {
		ClientesController cliController = new ClientesController();
		s = new Scanner(System.in);

		
		do {
			
			System.out.println("\n    ---- Clientes ----     ");
			System.out.println("Selecione a opção desejada:");
			System.out.println("\n1- Cadastrar  2- Listar  3- Buscar por CPF");
			System.out.println("4- Atualizar  5- Apagar  0- Voltar ao menu anterior\n");
			

			menuCliente = s.nextInt();
			//s.nextLine();
			
			switch(menuCliente) {
				
				case 1://create
					cliController.createClientesController();
					break;
					
				case 2://listar
					cliController.listarClientesController();
					break;
					
				case 3://buscar por cpf
					cliController.buscarPorCpfClientesController();
					break;
					
				case 4://Atusalizar
					cliController.atualizarDadosConlientesController();
					break;
					
				case 5://Apagar
					cliController.apagarClientesController();				
					break;
				default:
					break;
			
			}
			
		}while(menuCliente != 0);

	}
	
}
