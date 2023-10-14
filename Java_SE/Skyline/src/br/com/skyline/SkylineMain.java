package br.com.skyline;

import java.util.Scanner;
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
					
					break;
				case 2:
					
					break;
				case 3:
					
					break;
				case 4:
					
					break;
				case 5:
					ContatoView cView = new ContatoView();
					cView.contatoMenu();
					break;
				default:
					break;
					
			}
			
		}while(opcao != 0);
		
		entrada.close();
		System.out.println("\nPrograma encerrado!!");
		
	}

}
