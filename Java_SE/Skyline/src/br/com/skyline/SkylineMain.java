package br.com.skyline;

import java.util.Scanner;

import br.com.skyline.view.CidadesView;
import br.com.skyline.view.ClientesView;
import br.com.skyline.view.ContatoView;

public class SkylineMain {

	public static void main(String[] args){
		
		Scanner entrada = new Scanner(System.in);
		int opcao = 0;

		
		do {
			
			System.out.println("\n **** Menu Principal ****");
			System.out.println("Selecione a opção desejada:\n");
			System.out.println("1- Clientes  2- Reservas  3- Voo");
			System.out.println("4- Cidades   5- Contato   0- Sair\n");
			

			opcao = entrada.nextInt();
			entrada.nextLine();

			
			switch(opcao) {
				
				case 1:
					ClientesView cliView = new ClientesView();
					cliView.clienteMenu();
					break;
				case 2:
					
					break;
				case 3:
					
					break;
				case 4:
					CidadesView cidView = new CidadesView();
					cidView.cidadeMenu();
					break;
				case 5:
					ContatoView contatoView = new ContatoView();
					contatoView.contatoMenu();
					break;
				default:
					break;
					
			}
			
		}while(opcao != 0);
		
		entrada.close();
		System.out.println("\nPrograma encerrado!!");
		
	}

}
